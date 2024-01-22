package androidx.compose.foundation.relocation;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewRequesterImpl;", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "()V", "modifiers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/relocation/BringIntoViewRequesterModifier;", "getModifiers", "()Landroidx/compose/runtime/collection/MutableVector;", "bringIntoView", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BringIntoViewRequester.kt */
final class BringIntoViewRequesterImpl implements BringIntoViewRequester {
    private final MutableVector<BringIntoViewRequesterModifier> modifiers = new MutableVector<>(new BringIntoViewRequesterModifier[16], 0);

    public final MutableVector<BringIntoViewRequesterModifier> getModifiers() {
        return this.modifiers;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0058, code lost:
        r12.L$0 = r7;
        r12.L$1 = r6;
        r12.I$0 = r5;
        r12.I$1 = r4;
        r12.label = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006b, code lost:
        if (((androidx.compose.foundation.relocation.BringIntoViewRequesterModifier) r6[r4]).bringIntoView(r7, r12) != r1) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006f, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0072, code lost:
        if (r4 < r5) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0074, code lost:
        r4 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0078, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object bringIntoView(androidx.compose.ui.geometry.Rect r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1 r0 = (androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1 r0 = new androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1
            r0.<init>(r10, r12)
        L_0x0019:
            r12 = r0
            java.lang.Object r0 = r12.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r12.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x0040;
                case 1: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x002e:
            r11 = 0
            r2 = 0
            int r4 = r12.I$1
            int r5 = r12.I$0
            java.lang.Object r6 = r12.L$1
            java.lang.Object[] r6 = (java.lang.Object[]) r6
            java.lang.Object r7 = r12.L$0
            androidx.compose.ui.geometry.Rect r7 = (androidx.compose.ui.geometry.Rect) r7
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x006f
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r10
            androidx.compose.runtime.collection.MutableVector<androidx.compose.foundation.relocation.BringIntoViewRequesterModifier> r2 = r2.modifiers
            r4 = 0
            int r5 = r2.getSize()
            if (r5 <= 0) goto L_0x0075
            r6 = 0
            java.lang.Object[] r7 = r2.getContent()
            r9 = r7
            r7 = r11
            r11 = r4
            r4 = r6
            r6 = r9
        L_0x0058:
            r2 = r6[r4]
            androidx.compose.foundation.relocation.BringIntoViewRequesterModifier r2 = (androidx.compose.foundation.relocation.BringIntoViewRequesterModifier) r2
            r8 = 0
            r12.L$0 = r7
            r12.L$1 = r6
            r12.I$0 = r5
            r12.I$1 = r4
            r12.label = r3
            java.lang.Object r2 = r2.bringIntoView(r7, r12)
            if (r2 != r1) goto L_0x006e
            return r1
        L_0x006e:
            r2 = r8
        L_0x006f:
            int r4 = r4 + r3
            if (r4 < r5) goto L_0x0058
            r4 = r11
        L_0x0075:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.relocation.BringIntoViewRequesterImpl.bringIntoView(androidx.compose.ui.geometry.Rect, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
