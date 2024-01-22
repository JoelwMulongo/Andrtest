package androidx.compose.ui.text.font;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.TypefaceResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0011\u0010 \u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b#\u0010$R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R+\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028V@RX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Landroidx/compose/ui/text/font/AsyncFontListLoader;", "Landroidx/compose/runtime/State;", "", "fontList", "", "Landroidx/compose/ui/text/font/Font;", "initialType", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "onCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "(Ljava/util/List;Ljava/lang/Object;Landroidx/compose/ui/text/font/TypefaceRequest;Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/font/PlatformFontLoader;)V", "cacheable", "", "getCacheable$ui_text_release", "()Z", "setCacheable$ui_text_release", "(Z)V", "<set-?>", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "load", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadWithTimeoutOrNull", "loadWithTimeoutOrNull$ui_text_release", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
public final class AsyncFontListLoader implements State<Object> {
    private final AsyncTypefaceCache asyncTypefaceCache;
    private boolean cacheable = true;
    private final List<Font> fontList;
    private final Function1<TypefaceResult.Immutable, Unit> onCompletion;
    /* access modifiers changed from: private */
    public final PlatformFontLoader platformFontLoader;
    private final TypefaceRequest typefaceRequest;
    private final MutableState value$delegate;

    public AsyncFontListLoader(List<? extends Font> fontList2, Object initialType, TypefaceRequest typefaceRequest2, AsyncTypefaceCache asyncTypefaceCache2, Function1<? super TypefaceResult.Immutable, Unit> onCompletion2, PlatformFontLoader platformFontLoader2) {
        Intrinsics.checkNotNullParameter(fontList2, "fontList");
        Intrinsics.checkNotNullParameter(initialType, "initialType");
        Intrinsics.checkNotNullParameter(typefaceRequest2, "typefaceRequest");
        Intrinsics.checkNotNullParameter(asyncTypefaceCache2, "asyncTypefaceCache");
        Intrinsics.checkNotNullParameter(onCompletion2, "onCompletion");
        Intrinsics.checkNotNullParameter(platformFontLoader2, "platformFontLoader");
        this.fontList = fontList2;
        this.typefaceRequest = typefaceRequest2;
        this.asyncTypefaceCache = asyncTypefaceCache2;
        this.onCompletion = onCompletion2;
        this.platformFontLoader = platformFontLoader2;
        this.value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialType, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private void setValue(Object obj) {
        this.value$delegate.setValue(obj);
    }

    public Object getValue() {
        return this.value$delegate.getValue();
    }

    public final boolean getCacheable$ui_text_release() {
        return this.cacheable;
    }

    public final void setCacheable$ui_text_release(boolean z) {
        this.cacheable = z;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007b, code lost:
        if (r15 >= r13) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r11 = r4.get(r15);
        r16 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0095, code lost:
        if (androidx.compose.ui.text.font.FontLoadingStrategy.m5550equalsimpl0(r11.m5534getLoadingStrategyPKNRLFQ(), androidx.compose.ui.text.font.FontLoadingStrategy.Companion.m5554getAsyncPKNRLFQ()) == false) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0097, code lost:
        r8 = r12.asyncTypefaceCache;
        r10 = r12.platformFontLoader;
        r18 = new androidx.compose.ui.text.font.AsyncFontListLoader$load$2$typeface$1(r12, r11, (kotlin.coroutines.Continuation<? super androidx.compose.ui.text.font.AsyncFontListLoader$load$2$typeface$1>) null);
        r1.L$0 = r12;
        r1.L$1 = r4;
        r1.L$2 = r11;
        r1.I$0 = r15;
        r1.I$1 = r13;
        r1.label = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b2, code lost:
        r19 = r11;
        r20 = r12;
        r17 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r8 = r8.runCached(r11, r10, false, r18, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c2, code lost:
        if (r8 != r0) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c4, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c5, code lost:
        r12 = r4;
        r10 = r15;
        r9 = r17;
        r11 = r19;
        r13 = r20;
        r4 = r3;
        r3 = r8;
        r8 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d1, code lost:
        if (r3 == null) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r13.setValue(androidx.compose.ui.text.font.FontSynthesis_androidKt.m5582synthesizeTypefaceFxwP2eA(r13.typefaceRequest.m5615getFontSynthesisGVVA2EU(), r3, r11, r13.typefaceRequest.getFontWeight(), r13.typefaceRequest.m5614getFontStyle_LCdwA()));
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f0, code lost:
        r3 = kotlinx.coroutines.JobKt.isActive(r1.getContext());
        r13.cacheable = false;
        r5 = r13.onCompletion;
        r9 = r13.getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0102, code lost:
        if (r3 == false) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0105, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0106, code lost:
        r5.invoke(new androidx.compose.ui.text.font.TypefaceResult.Immutable(r9, r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x010c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r1.L$0 = r13;
        r1.L$1 = r12;
        r1.L$2 = null;
        r1.I$0 = r10;
        r1.I$1 = r9;
        r1.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x011e, code lost:
        if (kotlinx.coroutines.YieldKt.yield(r1) != r0) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0120, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0121, code lost:
        r3 = r4;
        r11 = r12;
        r12 = r13;
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0126, code lost:
        r14 = r8;
        r13 = r9;
        r15 = r10;
        r4 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x012b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x012c, code lost:
        r3 = r4;
        r12 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x012f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0130, code lost:
        r12 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0133, code lost:
        r19 = r11;
        r20 = r12;
        r17 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0139, code lost:
        r15 = r15 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x013d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x013e, code lost:
        r20 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0141, code lost:
        r20 = r12;
        r0 = kotlinx.coroutines.JobKt.isActive(r1.getContext());
        r12.cacheable = false;
        r4 = r12.onCompletion;
        r8 = r12.getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0157, code lost:
        if (r0 == false) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x015a, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x015b, code lost:
        r4.invoke(new androidx.compose.ui.text.font.TypefaceResult.Immutable(r8, r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0164, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object load(kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            r21 = this;
            r0 = r22
            boolean r1 = r0 instanceof androidx.compose.ui.text.font.AsyncFontListLoader$load$1
            if (r1 == 0) goto L_0x0019
            r1 = r0
            androidx.compose.ui.text.font.AsyncFontListLoader$load$1 r1 = (androidx.compose.ui.text.font.AsyncFontListLoader$load$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0019
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r21
            goto L_0x0021
        L_0x0019:
            androidx.compose.ui.text.font.AsyncFontListLoader$load$1 r1 = new androidx.compose.ui.text.font.AsyncFontListLoader$load$1
            r2 = r21
            r1.<init>(r2, r0)
            r0 = r1
        L_0x0021:
            java.lang.Object r3 = r1.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 0
            r6 = 1
            r7 = 0
            switch(r4) {
                case 0: goto L_0x0069;
                case 1: goto L_0x004a;
                case 2: goto L_0x0037;
                default: goto L_0x002f;
            }
        L_0x002f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0037:
            r4 = 0
            r8 = 0
            int r9 = r1.I$1
            int r10 = r1.I$0
            java.lang.Object r11 = r1.L$1
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r12 = r1.L$0
            androidx.compose.ui.text.font.AsyncFontListLoader r12 = (androidx.compose.ui.text.font.AsyncFontListLoader) r12
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x0165 }
            goto L_0x0126
        L_0x004a:
            r4 = 0
            r8 = 0
            int r9 = r1.I$1
            int r10 = r1.I$0
            java.lang.Object r11 = r1.L$2
            androidx.compose.ui.text.font.Font r11 = (androidx.compose.ui.text.font.Font) r11
            java.lang.Object r12 = r1.L$1
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r13 = r1.L$0
            androidx.compose.ui.text.font.AsyncFontListLoader r13 = (androidx.compose.ui.text.font.AsyncFontListLoader) r13
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x0065 }
            r16 = r8
            r8 = r4
            r4 = r3
            goto L_0x00d0
        L_0x0065:
            r0 = move-exception
            r12 = r13
            goto L_0x0166
        L_0x0069:
            kotlin.ResultKt.throwOnFailure(r3)
            r12 = r21
            java.util.List<androidx.compose.ui.text.font.Font> r4 = r12.fontList     // Catch:{ all -> 0x0165 }
            r8 = 0
            r9 = 0
            int r10 = r4.size()     // Catch:{ all -> 0x0165 }
            r14 = r8
            r15 = r9
            r13 = r10
        L_0x007b:
            if (r15 >= r13) goto L_0x0141
            java.lang.Object r8 = r4.get(r15)     // Catch:{ all -> 0x013d }
            r9 = r8
            androidx.compose.ui.text.font.Font r9 = (androidx.compose.ui.text.font.Font) r9     // Catch:{ all -> 0x013d }
            r11 = r9
            r16 = 0
            int r8 = r11.m5534getLoadingStrategyPKNRLFQ()     // Catch:{ all -> 0x013d }
            androidx.compose.ui.text.font.FontLoadingStrategy$Companion r9 = androidx.compose.ui.text.font.FontLoadingStrategy.Companion     // Catch:{ all -> 0x013d }
            int r9 = r9.m5554getAsyncPKNRLFQ()     // Catch:{ all -> 0x013d }
            boolean r8 = androidx.compose.ui.text.font.FontLoadingStrategy.m5550equalsimpl0(r8, r9)     // Catch:{ all -> 0x013d }
            if (r8 == 0) goto L_0x0133
            androidx.compose.ui.text.font.AsyncTypefaceCache r8 = r12.asyncTypefaceCache     // Catch:{ all -> 0x013d }
            androidx.compose.ui.text.font.PlatformFontLoader r10 = r12.platformFontLoader     // Catch:{ all -> 0x013d }
            r17 = 0
            androidx.compose.ui.text.font.AsyncFontListLoader$load$2$typeface$1 r9 = new androidx.compose.ui.text.font.AsyncFontListLoader$load$2$typeface$1     // Catch:{ all -> 0x013d }
            r9.<init>(r12, r11, r5)     // Catch:{ all -> 0x013d }
            r18 = r9
            kotlin.jvm.functions.Function1 r18 = (kotlin.jvm.functions.Function1) r18     // Catch:{ all -> 0x013d }
            r1.L$0 = r12     // Catch:{ all -> 0x013d }
            r1.L$1 = r4     // Catch:{ all -> 0x013d }
            r1.L$2 = r11     // Catch:{ all -> 0x013d }
            r1.I$0 = r15     // Catch:{ all -> 0x013d }
            r1.I$1 = r13     // Catch:{ all -> 0x013d }
            r1.label = r6     // Catch:{ all -> 0x013d }
            r9 = r11
            r19 = r11
            r11 = r17
            r20 = r12
            r12 = r18
            r17 = r13
            r13 = r1
            java.lang.Object r8 = r8.runCached(r9, r10, r11, r12, r13)     // Catch:{ all -> 0x012f }
            if (r8 != r0) goto L_0x00c5
            return r0
        L_0x00c5:
            r12 = r4
            r10 = r15
            r9 = r17
            r11 = r19
            r13 = r20
            r4 = r3
            r3 = r8
            r8 = r14
        L_0x00d0:
            if (r3 == 0) goto L_0x010d
            androidx.compose.ui.text.font.TypefaceRequest r0 = r13.typefaceRequest     // Catch:{ all -> 0x012b }
            int r0 = r0.m5615getFontSynthesisGVVA2EU()     // Catch:{ all -> 0x012b }
            androidx.compose.ui.text.font.TypefaceRequest r5 = r13.typefaceRequest     // Catch:{ all -> 0x012b }
            androidx.compose.ui.text.font.FontWeight r5 = r5.getFontWeight()     // Catch:{ all -> 0x012b }
            androidx.compose.ui.text.font.TypefaceRequest r9 = r13.typefaceRequest     // Catch:{ all -> 0x012b }
            int r9 = r9.m5614getFontStyle_LCdwA()     // Catch:{ all -> 0x012b }
            java.lang.Object r0 = androidx.compose.ui.text.font.FontSynthesis_androidKt.m5582synthesizeTypefaceFxwP2eA(r0, r3, r11, r5, r9)     // Catch:{ all -> 0x012b }
            r13.setValue(r0)     // Catch:{ all -> 0x012b }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x012b }
            kotlin.coroutines.CoroutineContext r3 = r1.getContext()
            boolean r3 = kotlinx.coroutines.JobKt.isActive(r3)
            r13.cacheable = r7
            kotlin.jvm.functions.Function1<androidx.compose.ui.text.font.TypefaceResult$Immutable, kotlin.Unit> r5 = r13.onCompletion
            androidx.compose.ui.text.font.TypefaceResult$Immutable r8 = new androidx.compose.ui.text.font.TypefaceResult$Immutable
            java.lang.Object r9 = r13.getValue()
            if (r3 == 0) goto L_0x0105
            goto L_0x0106
        L_0x0105:
            r6 = r7
        L_0x0106:
            r8.<init>(r9, r6)
            r5.invoke(r8)
            return r0
        L_0x010d:
            r1.L$0 = r13     // Catch:{ all -> 0x012b }
            r1.L$1 = r12     // Catch:{ all -> 0x012b }
            r1.L$2 = r5     // Catch:{ all -> 0x012b }
            r1.I$0 = r10     // Catch:{ all -> 0x012b }
            r1.I$1 = r9     // Catch:{ all -> 0x012b }
            r3 = 2
            r1.label = r3     // Catch:{ all -> 0x012b }
            java.lang.Object r3 = kotlinx.coroutines.YieldKt.yield(r1)     // Catch:{ all -> 0x012b }
            if (r3 != r0) goto L_0x0121
            return r0
        L_0x0121:
            r3 = r4
            r11 = r12
            r12 = r13
            r4 = r16
        L_0x0126:
            r14 = r8
            r13 = r9
            r15 = r10
            r4 = r11
            goto L_0x0139
        L_0x012b:
            r0 = move-exception
            r3 = r4
            r12 = r13
            goto L_0x0166
        L_0x012f:
            r0 = move-exception
            r12 = r20
            goto L_0x0166
        L_0x0133:
            r19 = r11
            r20 = r12
            r17 = r13
        L_0x0139:
            int r15 = r15 + r6
            goto L_0x007b
        L_0x013d:
            r0 = move-exception
            r20 = r12
            goto L_0x0166
        L_0x0141:
            r20 = r12
            kotlin.coroutines.CoroutineContext r0 = r1.getContext()
            boolean r0 = kotlinx.coroutines.JobKt.isActive(r0)
            r12.cacheable = r7
            kotlin.jvm.functions.Function1<androidx.compose.ui.text.font.TypefaceResult$Immutable, kotlin.Unit> r4 = r12.onCompletion
            androidx.compose.ui.text.font.TypefaceResult$Immutable r5 = new androidx.compose.ui.text.font.TypefaceResult$Immutable
            java.lang.Object r8 = r12.getValue()
            if (r0 == 0) goto L_0x015a
            goto L_0x015b
        L_0x015a:
            r6 = r7
        L_0x015b:
            r5.<init>(r8, r6)
            r4.invoke(r5)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0165:
            r0 = move-exception
        L_0x0166:
            kotlin.coroutines.CoroutineContext r4 = r1.getContext()
            boolean r4 = kotlinx.coroutines.JobKt.isActive(r4)
            r12.cacheable = r7
            kotlin.jvm.functions.Function1<androidx.compose.ui.text.font.TypefaceResult$Immutable, kotlin.Unit> r5 = r12.onCompletion
            androidx.compose.ui.text.font.TypefaceResult$Immutable r8 = new androidx.compose.ui.text.font.TypefaceResult$Immutable
            java.lang.Object r9 = r12.getValue()
            if (r4 == 0) goto L_0x017b
            goto L_0x017c
        L_0x017b:
            r6 = r7
        L_0x017c:
            r8.<init>(r9, r6)
            r5.invoke(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncFontListLoader.load(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loadWithTimeoutOrNull$ui_text_release(androidx.compose.ui.text.font.Font r9, kotlin.coroutines.Continuation<java.lang.Object> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1 r0 = (androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1 r0 = new androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1
            r0.<init>(r8, r10)
        L_0x0019:
            r10 = r0
            java.lang.Object r0 = r10.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r10.label
            r3 = 0
            switch(r2) {
                case 0: goto L_0x0037;
                case 1: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x002e:
            java.lang.Object r9 = r10.L$0
            androidx.compose.ui.text.font.Font r9 = (androidx.compose.ui.text.font.Font) r9
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ CancellationException -> 0x0089, Exception -> 0x0053 }
            r3 = r0
            goto L_0x0051
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r8
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$2 r4 = new androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$2     // Catch:{ CancellationException -> 0x0089, Exception -> 0x0053 }
            r4.<init>(r2, r9, r3)     // Catch:{ CancellationException -> 0x0089, Exception -> 0x0053 }
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch:{ CancellationException -> 0x0089, Exception -> 0x0053 }
            r10.L$0 = r9     // Catch:{ CancellationException -> 0x0089, Exception -> 0x0053 }
            r5 = 1
            r10.label = r5     // Catch:{ CancellationException -> 0x0089, Exception -> 0x0053 }
            r5 = 15000(0x3a98, double:7.411E-320)
            java.lang.Object r3 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r5, r4, r10)     // Catch:{ CancellationException -> 0x0089, Exception -> 0x0053 }
            if (r3 != r1) goto L_0x0051
            return r1
        L_0x0051:
            goto L_0x0094
        L_0x0053:
            r1 = move-exception
            kotlin.coroutines.CoroutineContext r2 = r10.getContext()
            kotlinx.coroutines.CoroutineExceptionHandler$Key r4 = kotlinx.coroutines.CoroutineExceptionHandler.Key
            kotlin.coroutines.CoroutineContext$Key r4 = (kotlin.coroutines.CoroutineContext.Key) r4
            kotlin.coroutines.CoroutineContext$Element r2 = r2.get(r4)
            kotlinx.coroutines.CoroutineExceptionHandler r2 = (kotlinx.coroutines.CoroutineExceptionHandler) r2
            if (r2 == 0) goto L_0x0088
            kotlin.coroutines.CoroutineContext r4 = r10.getContext()
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Unable to load font "
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r9)
            java.lang.String r9 = r6.toString()
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            r5.<init>(r9, r1)
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r2.handleException(r4, r5)
        L_0x0088:
            goto L_0x0094
        L_0x0089:
            r9 = move-exception
            kotlin.coroutines.CoroutineContext r1 = r10.getContext()
            boolean r1 = kotlinx.coroutines.JobKt.isActive(r1)
            if (r1 == 0) goto L_0x0095
        L_0x0094:
            return r3
        L_0x0095:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncFontListLoader.loadWithTimeoutOrNull$ui_text_release(androidx.compose.ui.text.font.Font, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
