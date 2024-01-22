package androidx.compose.ui.text.font;

import androidx.compose.ui.text.caches.LruCache;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0011J(\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0017J4\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\u0006\u0010\u0010\u001a\u00020\t2\u001e\u0010\u0016\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u0017\u0012\u0004\u0012\u00020\n0\u0017R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8@X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/font/TypefaceRequestCache;", "", "()V", "lock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "getLock$ui_text_release", "()Landroidx/compose/ui/text/platform/SynchronizedObject;", "resultCache", "Landroidx/compose/ui/text/caches/LruCache;", "Landroidx/compose/ui/text/font/TypefaceRequest;", "Landroidx/compose/ui/text/font/TypefaceResult;", "size", "", "getSize$ui_text_release", "()I", "get", "typefaceRequest", "get$ui_text_release", "preWarmCache", "", "typefaceRequests", "", "resolveTypeface", "Lkotlin/Function1;", "runCached", "Landroidx/compose/runtime/State;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontFamilyResolver.kt */
public final class TypefaceRequestCache {
    private final SynchronizedObject lock = Synchronization_jvmKt.createSynchronizedObject();
    /* access modifiers changed from: private */
    public final LruCache<TypefaceRequest, TypefaceResult> resultCache = new LruCache<>(16);

    public final SynchronizedObject getLock$ui_text_release() {
        return this.lock;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r0 = (androidx.compose.ui.text.font.TypefaceResult) r8.invoke(new androidx.compose.ui.text.font.TypefaceRequestCache$runCached$currentTypefaceResult$1(r6, r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        r1 = r6.lock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004a, code lost:
        if (r6.resultCache.get(r7) != null) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0050, code lost:
        if (r0.getCacheable() == false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        r6.resultCache.put(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        r3 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005e, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0062, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006d, code lost:
        throw new java.lang.IllegalStateException("Could not load font", r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.runtime.State<java.lang.Object> runCached(androidx.compose.ui.text.font.TypefaceRequest r7, kotlin.jvm.functions.Function1<? super kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.font.TypefaceResult, kotlin.Unit>, ? extends androidx.compose.ui.text.font.TypefaceResult> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "typefaceRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "resolveTypeface"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            androidx.compose.ui.text.platform.SynchronizedObject r0 = r6.lock
            r1 = 0
            monitor-enter(r0)
            r2 = 0
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.TypefaceRequest, androidx.compose.ui.text.font.TypefaceResult> r3 = r6.resultCache     // Catch:{ all -> 0x006e }
            java.lang.Object r3 = r3.get(r7)     // Catch:{ all -> 0x006e }
            androidx.compose.ui.text.font.TypefaceResult r3 = (androidx.compose.ui.text.font.TypefaceResult) r3     // Catch:{ all -> 0x006e }
            if (r3 == 0) goto L_0x0030
            r4 = 0
            boolean r5 = r3.getCacheable()     // Catch:{ all -> 0x006e }
            if (r5 == 0) goto L_0x0027
            r5 = r3
            androidx.compose.runtime.State r5 = (androidx.compose.runtime.State) r5     // Catch:{ all -> 0x006e }
            monitor-exit(r0)
            return r5
        L_0x0027:
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.TypefaceRequest, androidx.compose.ui.text.font.TypefaceResult> r5 = r6.resultCache     // Catch:{ all -> 0x006e }
            java.lang.Object r5 = r5.remove(r7)     // Catch:{ all -> 0x006e }
            androidx.compose.ui.text.font.TypefaceResult r5 = (androidx.compose.ui.text.font.TypefaceResult) r5     // Catch:{ all -> 0x006e }
        L_0x0030:
            monitor-exit(r0)
            androidx.compose.ui.text.font.TypefaceRequestCache$runCached$currentTypefaceResult$1 r0 = new androidx.compose.ui.text.font.TypefaceRequestCache$runCached$currentTypefaceResult$1     // Catch:{ Exception -> 0x0062 }
            r0.<init>(r6, r7)     // Catch:{ Exception -> 0x0062 }
            java.lang.Object r0 = r8.invoke(r0)     // Catch:{ Exception -> 0x0062 }
            androidx.compose.ui.text.font.TypefaceResult r0 = (androidx.compose.ui.text.font.TypefaceResult) r0     // Catch:{ Exception -> 0x0062 }
            androidx.compose.ui.text.platform.SynchronizedObject r1 = r6.lock
            r2 = 0
            monitor-enter(r1)
            r3 = 0
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.TypefaceRequest, androidx.compose.ui.text.font.TypefaceResult> r4 = r6.resultCache     // Catch:{ all -> 0x005f }
            java.lang.Object r4 = r4.get(r7)     // Catch:{ all -> 0x005f }
            if (r4 != 0) goto L_0x0057
            boolean r4 = r0.getCacheable()     // Catch:{ all -> 0x005f }
            if (r4 == 0) goto L_0x0057
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.TypefaceRequest, androidx.compose.ui.text.font.TypefaceResult> r4 = r6.resultCache     // Catch:{ all -> 0x005f }
            r4.put(r7, r0)     // Catch:{ all -> 0x005f }
        L_0x0057:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005f }
            monitor-exit(r1)
            r1 = r0
            androidx.compose.runtime.State r1 = (androidx.compose.runtime.State) r1
            return r1
        L_0x005f:
            r3 = move-exception
            monitor-exit(r1)
            throw r3
        L_0x0062:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Could not load font"
            r3 = r0
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r1.<init>(r2, r3)
            throw r1
        L_0x006e:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.TypefaceRequestCache.runCached(androidx.compose.ui.text.font.TypefaceRequest, kotlin.jvm.functions.Function1):androidx.compose.runtime.State");
    }

    public final void preWarmCache(List<TypefaceRequest> typefaceRequests, Function1<? super TypefaceRequest, ? extends TypefaceResult> resolveTypeface) {
        TypefaceResult prior;
        Intrinsics.checkNotNullParameter(typefaceRequests, "typefaceRequests");
        Intrinsics.checkNotNullParameter(resolveTypeface, "resolveTypeface");
        int size = typefaceRequests.size();
        for (int i = 0; i < size; i++) {
            TypefaceRequest typeRequest = typefaceRequests.get(i);
            synchronized (this.lock) {
                prior = this.resultCache.get(typeRequest);
            }
            if (prior == null) {
                try {
                    TypefaceResult next = (TypefaceResult) resolveTypeface.invoke(typeRequest);
                    if (!(next instanceof TypefaceResult.Async)) {
                        synchronized (this.lock) {
                            TypefaceResult put = this.resultCache.put(typeRequest, next);
                        }
                    } else {
                        continue;
                    }
                } catch (Exception cause) {
                    throw new IllegalStateException("Could not load font", cause);
                }
            }
        }
    }

    public final TypefaceResult get$ui_text_release(TypefaceRequest typefaceRequest) {
        TypefaceResult typefaceResult;
        Intrinsics.checkNotNullParameter(typefaceRequest, "typefaceRequest");
        synchronized (this.lock) {
            typefaceResult = this.resultCache.get(typefaceRequest);
        }
        return typefaceResult;
    }

    public final int getSize$ui_text_release() {
        int size;
        synchronized (this.lock) {
            size = this.resultCache.size();
        }
        return size;
    }
}
