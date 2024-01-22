package androidx.core.content.pm;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompatSaver;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ShortcutManagerCompat {
    static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final int DEFAULT_MAX_ICON_DIMENSION_DP = 96;
    private static final int DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP = 48;
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    public static final int FLAG_MATCH_CACHED = 8;
    public static final int FLAG_MATCH_DYNAMIC = 2;
    public static final int FLAG_MATCH_MANIFEST = 1;
    public static final int FLAG_MATCH_PINNED = 4;
    static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
    private static final String SHORTCUT_LISTENER_INTENT_FILTER_ACTION = "androidx.core.content.pm.SHORTCUT_LISTENER";
    private static final String SHORTCUT_LISTENER_META_DATA_KEY = "androidx.core.content.pm.shortcut_listener_impl";
    private static volatile List<ShortcutInfoChangeListener> sShortcutInfoChangeListeners = null;
    private static volatile ShortcutInfoCompatSaver<?> sShortcutInfoCompatSaver = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShortcutMatchFlags {
    }

    private ShortcutManagerCompat() {
    }

    public static boolean isRequestPinShortcutSupported(Context context) {
        return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
    }

    public static boolean requestPinShortcut(Context context, ShortcutInfoCompat shortcut, IntentSender callback) {
        if (Build.VERSION.SDK_INT > 31 || !shortcut.isExcludedFromSurfaces(1)) {
            return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).requestPinShortcut(shortcut.toShortcutInfo(), callback);
        }
        return false;
    }

    public static Intent createShortcutResultIntent(Context context, ShortcutInfoCompat shortcut) {
        Intent result = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).createShortcutResultIntent(shortcut.toShortcutInfo());
        if (result == null) {
            result = new Intent();
        }
        return shortcut.addToIntent(result);
    }

    public static List<ShortcutInfoCompat> getShortcuts(Context context, int matchFlags) {
        if (Build.VERSION.SDK_INT >= 30) {
            return ShortcutInfoCompat.fromShortcuts(context, ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getShortcuts(matchFlags));
        }
        ShortcutManager manager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
        List<ShortcutInfo> shortcuts = new ArrayList<>();
        if ((matchFlags & 1) != 0) {
            shortcuts.addAll(manager.getManifestShortcuts());
        }
        if ((matchFlags & 2) != 0) {
            shortcuts.addAll(manager.getDynamicShortcuts());
        }
        if ((matchFlags & 4) != 0) {
            shortcuts.addAll(manager.getPinnedShortcuts());
        }
        return ShortcutInfoCompat.fromShortcuts(context, shortcuts);
    }

    public static boolean addDynamicShortcuts(Context context, List<ShortcutInfoCompat> shortcutInfoList) {
        List<ShortcutInfoCompat> clone = removeShortcutsExcludedFromSurface(shortcutInfoList, 1);
        if (Build.VERSION.SDK_INT <= 29) {
            convertUriIconsToBitmapIcons(context, clone);
        }
        ArrayList<ShortcutInfo> shortcuts = new ArrayList<>();
        for (ShortcutInfoCompat item : clone) {
            shortcuts.add(item.toShortcutInfo());
        }
        if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).addDynamicShortcuts(shortcuts)) {
            return false;
        }
        getShortcutInfoSaverInstance(context).addShortcuts(clone);
        for (ShortcutInfoChangeListener listener : getShortcutInfoListeners(context)) {
            listener.onShortcutAdded(shortcutInfoList);
        }
        return true;
    }

    public static int getMaxShortcutCountPerActivity(Context context) {
        Preconditions.checkNotNull(context);
        return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
    }

    public static boolean isRateLimitingActive(Context context) {
        Preconditions.checkNotNull(context);
        return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).isRateLimitingActive();
    }

    public static int getIconMaxWidth(Context context) {
        Preconditions.checkNotNull(context);
        return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getIconMaxWidth();
    }

    public static int getIconMaxHeight(Context context) {
        Preconditions.checkNotNull(context);
        return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getIconMaxHeight();
    }

    public static void reportShortcutUsed(Context context, String shortcutId) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(shortcutId);
        ((ShortcutManager) context.getSystemService(ShortcutManager.class)).reportShortcutUsed(shortcutId);
        for (ShortcutInfoChangeListener listener : getShortcutInfoListeners(context)) {
            listener.onShortcutUsageReported(Collections.singletonList(shortcutId));
        }
    }

    public static boolean setDynamicShortcuts(Context context, List<ShortcutInfoCompat> shortcutInfoList) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(shortcutInfoList);
        List<ShortcutInfoCompat> clone = removeShortcutsExcludedFromSurface(shortcutInfoList, 1);
        List<ShortcutInfo> shortcuts = new ArrayList<>(clone.size());
        for (ShortcutInfoCompat compat : clone) {
            shortcuts.add(compat.toShortcutInfo());
        }
        if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).setDynamicShortcuts(shortcuts)) {
            return false;
        }
        getShortcutInfoSaverInstance(context).removeAllShortcuts();
        getShortcutInfoSaverInstance(context).addShortcuts(clone);
        for (ShortcutInfoChangeListener listener : getShortcutInfoListeners(context)) {
            listener.onAllShortcutsRemoved();
            listener.onShortcutAdded(shortcutInfoList);
        }
        return true;
    }

    public static List<ShortcutInfoCompat> getDynamicShortcuts(Context context) {
        List<ShortcutInfo> shortcuts = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
        List<ShortcutInfoCompat> compats = new ArrayList<>(shortcuts.size());
        for (ShortcutInfo item : shortcuts) {
            compats.add(new ShortcutInfoCompat.Builder(context, item).build());
        }
        return compats;
    }

    public static boolean updateShortcuts(Context context, List<ShortcutInfoCompat> shortcutInfoList) {
        List<ShortcutInfoCompat> clone = removeShortcutsExcludedFromSurface(shortcutInfoList, 1);
        if (Build.VERSION.SDK_INT <= 29) {
            convertUriIconsToBitmapIcons(context, clone);
        }
        ArrayList<ShortcutInfo> shortcuts = new ArrayList<>();
        for (ShortcutInfoCompat item : clone) {
            shortcuts.add(item.toShortcutInfo());
        }
        if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).updateShortcuts(shortcuts)) {
            return false;
        }
        getShortcutInfoSaverInstance(context).addShortcuts(clone);
        for (ShortcutInfoChangeListener listener : getShortcutInfoListeners(context)) {
            listener.onShortcutUpdated(shortcutInfoList);
        }
        return true;
    }

    static boolean convertUriIconToBitmapIcon(Context context, ShortcutInfoCompat info) {
        Bitmap bitmap;
        IconCompat iconCompat;
        if (info.mIcon == null) {
            return false;
        }
        int type = info.mIcon.mType;
        if (type != 6 && type != 4) {
            return true;
        }
        InputStream is = info.mIcon.getUriInputStream(context);
        if (is == null || (bitmap = BitmapFactory.decodeStream(is)) == null) {
            return false;
        }
        if (type == 6) {
            iconCompat = IconCompat.createWithAdaptiveBitmap(bitmap);
        } else {
            iconCompat = IconCompat.createWithBitmap(bitmap);
        }
        info.mIcon = iconCompat;
        return true;
    }

    static void convertUriIconsToBitmapIcons(Context context, List<ShortcutInfoCompat> shortcutInfoList) {
        for (ShortcutInfoCompat info : new ArrayList<>(shortcutInfoList)) {
            if (!convertUriIconToBitmapIcon(context, info)) {
                shortcutInfoList.remove(info);
            }
        }
    }

    public static void disableShortcuts(Context context, List<String> shortcutIds, CharSequence disabledMessage) {
        ((ShortcutManager) context.getSystemService(ShortcutManager.class)).disableShortcuts(shortcutIds, disabledMessage);
        getShortcutInfoSaverInstance(context).removeShortcuts(shortcutIds);
        for (ShortcutInfoChangeListener listener : getShortcutInfoListeners(context)) {
            listener.onShortcutRemoved(shortcutIds);
        }
    }

    public static void enableShortcuts(Context context, List<ShortcutInfoCompat> shortcutInfoList) {
        List<ShortcutInfoCompat> clone = removeShortcutsExcludedFromSurface(shortcutInfoList, 1);
        ArrayList<String> shortcutIds = new ArrayList<>(shortcutInfoList.size());
        for (ShortcutInfoCompat shortcut : clone) {
            shortcutIds.add(shortcut.mId);
        }
        ((ShortcutManager) context.getSystemService(ShortcutManager.class)).enableShortcuts(shortcutIds);
        getShortcutInfoSaverInstance(context).addShortcuts(clone);
        for (ShortcutInfoChangeListener listener : getShortcutInfoListeners(context)) {
            listener.onShortcutAdded(shortcutInfoList);
        }
    }

    public static void removeDynamicShortcuts(Context context, List<String> shortcutIds) {
        ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(shortcutIds);
        getShortcutInfoSaverInstance(context).removeShortcuts(shortcutIds);
        for (ShortcutInfoChangeListener listener : getShortcutInfoListeners(context)) {
            listener.onShortcutRemoved(shortcutIds);
        }
    }

    public static void removeAllDynamicShortcuts(Context context) {
        ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
        getShortcutInfoSaverInstance(context).removeAllShortcuts();
        for (ShortcutInfoChangeListener listener : getShortcutInfoListeners(context)) {
            listener.onAllShortcutsRemoved();
        }
    }

    public static void removeLongLivedShortcuts(Context context, List<String> shortcutIds) {
        if (Build.VERSION.SDK_INT < 30) {
            removeDynamicShortcuts(context, shortcutIds);
            return;
        }
        ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeLongLivedShortcuts(shortcutIds);
        getShortcutInfoSaverInstance(context).removeShortcuts(shortcutIds);
        for (ShortcutInfoChangeListener listener : getShortcutInfoListeners(context)) {
            listener.onShortcutRemoved(shortcutIds);
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static boolean pushDynamicShortcut(android.content.Context r7, androidx.core.content.pm.ShortcutInfoCompat r8) {
        /*
            androidx.core.util.Preconditions.checkNotNull(r7)
            androidx.core.util.Preconditions.checkNotNull(r8)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            r2 = 1
            if (r0 > r1) goto L_0x0030
            boolean r0 = r8.isExcludedFromSurfaces(r2)
            if (r0 == 0) goto L_0x0030
            java.util.List r0 = getShortcutInfoListeners(r7)
            java.util.Iterator r0 = r0.iterator()
        L_0x001b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x002f
            java.lang.Object r1 = r0.next()
            androidx.core.content.pm.ShortcutInfoChangeListener r1 = (androidx.core.content.pm.ShortcutInfoChangeListener) r1
            java.util.List r3 = java.util.Collections.singletonList(r8)
            r1.onShortcutAdded(r3)
            goto L_0x001b
        L_0x002f:
            return r2
        L_0x0030:
            int r0 = getMaxShortcutCountPerActivity(r7)
            r1 = 0
            if (r0 != 0) goto L_0x0038
            return r1
        L_0x0038:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 29
            if (r3 > r4) goto L_0x0041
            convertUriIconToBitmapIcon(r7, r8)
        L_0x0041:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 30
            if (r3 < r4) goto L_0x0057
            java.lang.Class<android.content.pm.ShortcutManager> r3 = android.content.pm.ShortcutManager.class
            java.lang.Object r3 = r7.getSystemService(r3)
            android.content.pm.ShortcutManager r3 = (android.content.pm.ShortcutManager) r3
            android.content.pm.ShortcutInfo r4 = r8.toShortcutInfo()
            r3.pushDynamicShortcut(r4)
            goto L_0x0090
        L_0x0057:
            java.lang.Class<android.content.pm.ShortcutManager> r3 = android.content.pm.ShortcutManager.class
            java.lang.Object r3 = r7.getSystemService(r3)
            android.content.pm.ShortcutManager r3 = (android.content.pm.ShortcutManager) r3
            boolean r4 = r3.isRateLimitingActive()
            if (r4 == 0) goto L_0x0067
            return r1
        L_0x0067:
            java.util.List r4 = r3.getDynamicShortcuts()
            int r5 = r4.size()
            if (r5 < r0) goto L_0x0081
            java.lang.String r5 = androidx.core.content.pm.ShortcutManagerCompat.Api25Impl.getShortcutInfoWithLowestRank(r4)
            java.lang.String[] r5 = new java.lang.String[]{r5}
            java.util.List r5 = java.util.Arrays.asList(r5)
            r3.removeDynamicShortcuts(r5)
        L_0x0081:
            android.content.pm.ShortcutInfo[] r5 = new android.content.pm.ShortcutInfo[r2]
            android.content.pm.ShortcutInfo r6 = r8.toShortcutInfo()
            r5[r1] = r6
            java.util.List r5 = java.util.Arrays.asList(r5)
            r3.addDynamicShortcuts(r5)
        L_0x0090:
            androidx.core.content.pm.ShortcutInfoCompatSaver r3 = getShortcutInfoSaverInstance(r7)
            java.util.List r4 = r3.getShortcuts()     // Catch:{ Exception -> 0x0102, all -> 0x00dd }
            int r5 = r4.size()     // Catch:{ Exception -> 0x0102, all -> 0x00dd }
            if (r5 < r0) goto L_0x00ad
            java.lang.String[] r5 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0102, all -> 0x00dd }
            java.lang.String r6 = getShortcutInfoCompatWithLowestRank(r4)     // Catch:{ Exception -> 0x0102, all -> 0x00dd }
            r5[r1] = r6     // Catch:{ Exception -> 0x0102, all -> 0x00dd }
            java.util.List r5 = java.util.Arrays.asList(r5)     // Catch:{ Exception -> 0x0102, all -> 0x00dd }
            r3.removeShortcuts(r5)     // Catch:{ Exception -> 0x0102, all -> 0x00dd }
        L_0x00ad:
            androidx.core.content.pm.ShortcutInfoCompat[] r5 = new androidx.core.content.pm.ShortcutInfoCompat[r2]     // Catch:{ Exception -> 0x0102, all -> 0x00dd }
            r5[r1] = r8     // Catch:{ Exception -> 0x0102, all -> 0x00dd }
            java.util.List r5 = java.util.Arrays.asList(r5)     // Catch:{ Exception -> 0x0102, all -> 0x00dd }
            r3.addShortcuts(r5)     // Catch:{ Exception -> 0x0102, all -> 0x00dd }
            java.util.List r1 = getShortcutInfoListeners(r7)
            java.util.Iterator r1 = r1.iterator()
        L_0x00c1:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x00d5
            java.lang.Object r5 = r1.next()
            androidx.core.content.pm.ShortcutInfoChangeListener r5 = (androidx.core.content.pm.ShortcutInfoChangeListener) r5
            java.util.List r6 = java.util.Collections.singletonList(r8)
            r5.onShortcutAdded(r6)
            goto L_0x00c1
        L_0x00d5:
            java.lang.String r1 = r8.getId()
            reportShortcutUsed(r7, r1)
            return r2
        L_0x00dd:
            r1 = move-exception
            java.util.List r2 = getShortcutInfoListeners(r7)
            java.util.Iterator r2 = r2.iterator()
        L_0x00e6:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00fa
            java.lang.Object r4 = r2.next()
            androidx.core.content.pm.ShortcutInfoChangeListener r4 = (androidx.core.content.pm.ShortcutInfoChangeListener) r4
            java.util.List r5 = java.util.Collections.singletonList(r8)
            r4.onShortcutAdded(r5)
            goto L_0x00e6
        L_0x00fa:
            java.lang.String r2 = r8.getId()
            reportShortcutUsed(r7, r2)
            throw r1
        L_0x0102:
            r2 = move-exception
            java.util.List r2 = getShortcutInfoListeners(r7)
            java.util.Iterator r2 = r2.iterator()
        L_0x010b:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x011f
            java.lang.Object r4 = r2.next()
            androidx.core.content.pm.ShortcutInfoChangeListener r4 = (androidx.core.content.pm.ShortcutInfoChangeListener) r4
            java.util.List r5 = java.util.Collections.singletonList(r8)
            r4.onShortcutAdded(r5)
            goto L_0x010b
        L_0x011f:
            java.lang.String r2 = r8.getId()
            reportShortcutUsed(r7, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.pm.ShortcutManagerCompat.pushDynamicShortcut(android.content.Context, androidx.core.content.pm.ShortcutInfoCompat):boolean");
    }

    private static String getShortcutInfoCompatWithLowestRank(List<ShortcutInfoCompat> shortcuts) {
        int rank = -1;
        String target = null;
        for (ShortcutInfoCompat s : shortcuts) {
            if (s.getRank() > rank) {
                target = s.getId();
                rank = s.getRank();
            }
        }
        return target;
    }

    static void setShortcutInfoCompatSaver(ShortcutInfoCompatSaver<Void> saver) {
        sShortcutInfoCompatSaver = saver;
    }

    static void setShortcutInfoChangeListeners(List<ShortcutInfoChangeListener> listeners) {
        sShortcutInfoChangeListeners = listeners;
    }

    static List<ShortcutInfoChangeListener> getShortcutInfoChangeListeners() {
        return sShortcutInfoChangeListeners;
    }

    private static int getIconDimensionInternal(Context context, boolean isHorizontal) {
        ActivityManager am = (ActivityManager) context.getSystemService("activity");
        int iconDimensionDp = Math.max(1, am == null || am.isLowRamDevice() ? DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP : DEFAULT_MAX_ICON_DIMENSION_DP);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (((float) iconDimensionDp) * ((isHorizontal ? displayMetrics.xdpi : displayMetrics.ydpi) / 160.0f));
    }

    private static ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(Context context) {
        if (sShortcutInfoCompatSaver == null) {
            try {
                sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
            } catch (Exception e) {
            }
            if (sShortcutInfoCompatSaver == null) {
                sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver.NoopImpl();
            }
        }
        return sShortcutInfoCompatSaver;
    }

    private static List<ShortcutInfoChangeListener> getShortcutInfoListeners(Context context) {
        Bundle metaData;
        String shortcutListenerImplName;
        if (sShortcutInfoChangeListeners == null) {
            List<ShortcutInfoChangeListener> result = new ArrayList<>();
            PackageManager packageManager = context.getPackageManager();
            Intent activityIntent = new Intent(SHORTCUT_LISTENER_INTENT_FILTER_ACTION);
            activityIntent.setPackage(context.getPackageName());
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(activityIntent, 128)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (!(activityInfo == null || (metaData = activityInfo.metaData) == null || (shortcutListenerImplName = metaData.getString(SHORTCUT_LISTENER_META_DATA_KEY)) == null)) {
                    try {
                        result.add((ShortcutInfoChangeListener) Class.forName(shortcutListenerImplName, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context}));
                    } catch (Exception e) {
                    }
                }
            }
            if (sShortcutInfoChangeListeners == null) {
                sShortcutInfoChangeListeners = result;
            }
        }
        return sShortcutInfoChangeListeners;
    }

    private static List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface(List<ShortcutInfoCompat> shortcuts, int surfaces) {
        Objects.requireNonNull(shortcuts);
        if (Build.VERSION.SDK_INT > 31) {
            return shortcuts;
        }
        List<ShortcutInfoCompat> clone = new ArrayList<>(shortcuts);
        for (ShortcutInfoCompat si : shortcuts) {
            if (si.isExcludedFromSurfaces(surfaces)) {
                clone.remove(si);
            }
        }
        return clone;
    }

    private static class Api25Impl {
        private Api25Impl() {
        }

        static String getShortcutInfoWithLowestRank(List<ShortcutInfo> shortcuts) {
            int rank = -1;
            String target = null;
            for (ShortcutInfo s : shortcuts) {
                if (s.getRank() > rank) {
                    target = s.getId();
                    rank = s.getRank();
                }
            }
            return target;
        }
    }
}
