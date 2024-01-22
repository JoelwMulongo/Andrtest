package androidx.compose.ui.window;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B;\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\u0006\u0010\u001d\u001a\u00020\u0005J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J&\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b&¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+H\u0002J$\u0010,\u001a\u00020\u00052\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\u00020\u0016X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, d2 = {"Landroidx/compose/ui/window/DialogWrapper;", "Landroidx/activity/ComponentDialog;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "onDismissRequest", "Lkotlin/Function0;", "", "properties", "Landroidx/compose/ui/window/DialogProperties;", "composeView", "Landroid/view/View;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "dialogId", "Ljava/util/UUID;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/DialogProperties;Landroid/view/View;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Ljava/util/UUID;)V", "defaultSoftInputMode", "", "dialogLayout", "Landroidx/compose/ui/window/DialogLayout;", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "subCompositionView", "Landroidx/compose/ui/platform/AbstractComposeView;", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "cancel", "disposeComposition", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setContent", "parentComposition", "Landroidx/compose/runtime/CompositionContext;", "children", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setLayoutDirection", "setSecurePolicy", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "updateParameters", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidDialog.android.kt */
final class DialogWrapper extends ComponentDialog implements ViewRootForInspector {
    private final View composeView;
    private final int defaultSoftInputMode;
    private final DialogLayout dialogLayout;
    private final float maxSupportedElevation;
    /* access modifiers changed from: private */
    public Function0<Unit> onDismissRequest;
    /* access modifiers changed from: private */
    public DialogProperties properties;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidDialog.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DialogWrapper(kotlin.jvm.functions.Function0<kotlin.Unit> r17, androidx.compose.ui.window.DialogProperties r18, android.view.View r19, androidx.compose.ui.unit.LayoutDirection r20, androidx.compose.ui.unit.Density r21, java.util.UUID r22) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r22
            java.lang.String r6 = "onDismissRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r6)
            java.lang.String r6 = "properties"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r6)
            java.lang.String r6 = "composeView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r6)
            java.lang.String r6 = "layoutDirection"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r6)
            java.lang.String r6 = "density"
            r7 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r6)
            java.lang.String r6 = "dialogId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
            android.view.ContextThemeWrapper r6 = new android.view.ContextThemeWrapper
            android.content.Context r8 = r19.getContext()
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 31
            if (r9 >= r10) goto L_0x0046
            boolean r9 = r18.getDecorFitsSystemWindows()
            if (r9 == 0) goto L_0x0043
            goto L_0x0046
        L_0x0043:
            int r9 = androidx.compose.ui.R.style.FloatingDialogWindowTheme
            goto L_0x0048
        L_0x0046:
            int r9 = androidx.compose.ui.R.style.DialogWindowTheme
        L_0x0048:
            r6.<init>(r8, r9)
            android.content.Context r6 = (android.content.Context) r6
            r8 = 2
            r9 = 0
            r10 = 0
            r0.<init>(r6, r9, r8, r10)
            r0.onDismissRequest = r1
            r0.properties = r2
            r0.composeView = r3
            r6 = 8
            r8 = 0
            float r11 = (float) r6
            float r6 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r11)
            r0.maxSupportedElevation = r6
            android.view.Window r8 = r16.getWindow()
            if (r8 == 0) goto L_0x011d
            android.view.WindowManager$LayoutParams r11 = r8.getAttributes()
            int r11 = r11.softInputMode
            r11 = r11 & 240(0xf0, float:3.36E-43)
            r0.defaultSoftInputMode = r11
            r11 = 1
            r8.requestFeature(r11)
            r11 = 17170445(0x106000d, float:2.461195E-38)
            r8.setBackgroundDrawableResource(r11)
            androidx.compose.ui.window.DialogProperties r11 = r0.properties
            boolean r11 = r11.getDecorFitsSystemWindows()
            androidx.core.view.WindowCompat.setDecorFitsSystemWindows(r8, r11)
            androidx.compose.ui.window.DialogLayout r11 = new androidx.compose.ui.window.DialogLayout
            android.content.Context r12 = r16.getContext()
            java.lang.String r13 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            r11.<init>(r12, r8)
            r12 = r11
            r13 = 0
            int r14 = androidx.compose.ui.R.id.compose_view_saveable_id_tag
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r10 = "Dialog:"
            java.lang.StringBuilder r10 = r15.append(r10)
            java.lang.StringBuilder r10 = r10.append(r5)
            java.lang.String r10 = r10.toString()
            r12.setTag(r14, r10)
            r12.setClipChildren(r9)
            r9 = r21
            r10 = 0
            float r6 = r9.m5967toPx0680j_4(r6)
            r12.setElevation(r6)
            androidx.compose.ui.window.DialogWrapper$1$2 r6 = new androidx.compose.ui.window.DialogWrapper$1$2
            r6.<init>()
            android.view.ViewOutlineProvider r6 = (android.view.ViewOutlineProvider) r6
            r12.setOutlineProvider(r6)
            r0.dialogLayout = r11
            android.view.View r6 = r8.getDecorView()
            boolean r9 = r6 instanceof android.view.ViewGroup
            if (r9 == 0) goto L_0x00d6
            r10 = r6
            android.view.ViewGroup r10 = (android.view.ViewGroup) r10
            goto L_0x00d7
        L_0x00d6:
            r10 = 0
        L_0x00d7:
            if (r10 == 0) goto L_0x00dc
            _init_$disableClipping(r10)
        L_0x00dc:
            r6 = r11
            android.view.View r6 = (android.view.View) r6
            r0.setContentView((android.view.View) r6)
            r6 = r11
            android.view.View r6 = (android.view.View) r6
            androidx.lifecycle.LifecycleOwner r9 = androidx.lifecycle.ViewTreeLifecycleOwner.get(r19)
            androidx.lifecycle.ViewTreeLifecycleOwner.set(r6, r9)
            r6 = r11
            android.view.View r6 = (android.view.View) r6
            androidx.lifecycle.ViewModelStoreOwner r9 = androidx.lifecycle.ViewTreeViewModelStoreOwner.get(r19)
            androidx.lifecycle.ViewTreeViewModelStoreOwner.set(r6, r9)
            android.view.View r11 = (android.view.View) r11
            androidx.savedstate.SavedStateRegistryOwner r6 = androidx.savedstate.ViewTreeSavedStateRegistryOwner.get(r19)
            androidx.savedstate.ViewTreeSavedStateRegistryOwner.set(r11, r6)
            kotlin.jvm.functions.Function0<kotlin.Unit> r6 = r0.onDismissRequest
            androidx.compose.ui.window.DialogProperties r9 = r0.properties
            r0.updateParameters(r6, r9, r4)
            androidx.activity.OnBackPressedDispatcher r10 = r16.getOnBackPressedDispatcher()
            r11 = r0
            androidx.lifecycle.LifecycleOwner r11 = (androidx.lifecycle.LifecycleOwner) r11
            r12 = 0
            androidx.compose.ui.window.DialogWrapper$2 r6 = new androidx.compose.ui.window.DialogWrapper$2
            r6.<init>(r0)
            r13 = r6
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r14 = 2
            r15 = 0
            androidx.activity.OnBackPressedDispatcherKt.addCallback$default(r10, r11, r12, r13, r14, r15)
            return
        L_0x011d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r8 = "Dialog has no window"
            java.lang.String r8 = r8.toString()
            r6.<init>(r8)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.DialogWrapper.<init>(kotlin.jvm.functions.Function0, androidx.compose.ui.window.DialogProperties, android.view.View, androidx.compose.ui.unit.LayoutDirection, androidx.compose.ui.unit.Density, java.util.UUID):void");
    }

    public AbstractComposeView getSubCompositionView() {
        return this.dialogLayout;
    }

    private static final void _init_$disableClipping(ViewGroup $this$_init__u24disableClipping) {
        $this$_init__u24disableClipping.setClipChildren(false);
        if (!($this$_init__u24disableClipping instanceof DialogLayout)) {
            int childCount = $this$_init__u24disableClipping.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = $this$_init__u24disableClipping.getChildAt(i);
                ViewGroup viewGroup = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
                if (viewGroup != null) {
                    _init_$disableClipping(viewGroup);
                }
            }
        }
    }

    private final void setLayoutDirection(LayoutDirection layoutDirection) {
        int i;
        DialogLayout dialogLayout2 = this.dialogLayout;
        switch (WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()]) {
            case 1:
                i = 0;
                break;
            case 2:
                i = 1;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        dialogLayout2.setLayoutDirection(i);
    }

    public final void setContent(CompositionContext parentComposition, Function2<? super Composer, ? super Integer, Unit> children) {
        Intrinsics.checkNotNullParameter(parentComposition, "parentComposition");
        Intrinsics.checkNotNullParameter(children, "children");
        this.dialogLayout.setContent(parentComposition, children);
    }

    private final void setSecurePolicy(SecureFlagPolicy securePolicy) {
        int i;
        boolean secureFlagEnabled = SecureFlagPolicy_androidKt.shouldApplySecureFlag(securePolicy, AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView));
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        if (secureFlagEnabled) {
            i = 8192;
        } else {
            i = -8193;
        }
        window.setFlags(i, 8192);
    }

    public final void updateParameters(Function0<Unit> onDismissRequest2, DialogProperties properties2, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(onDismissRequest2, "onDismissRequest");
        Intrinsics.checkNotNullParameter(properties2, "properties");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        this.onDismissRequest = onDismissRequest2;
        this.properties = properties2;
        setSecurePolicy(properties2.getSecurePolicy());
        setLayoutDirection(layoutDirection);
        this.dialogLayout.setUsePlatformDefaultWidth(properties2.getUsePlatformDefaultWidth());
        if (Build.VERSION.SDK_INT >= 31) {
            return;
        }
        if (properties2.getDecorFitsSystemWindows()) {
            Window window = getWindow();
            if (window != null) {
                window.setSoftInputMode(this.defaultSoftInputMode);
                return;
            }
            return;
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(16);
        }
    }

    public final void disposeComposition() {
        this.dialogLayout.disposeComposition();
    }

    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        boolean result = super.onTouchEvent(event);
        if (result && this.properties.getDismissOnClickOutside()) {
            this.onDismissRequest.invoke();
        }
        return result;
    }

    public void cancel() {
    }
}
