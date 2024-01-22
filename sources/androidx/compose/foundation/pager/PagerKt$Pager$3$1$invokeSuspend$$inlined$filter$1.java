package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class PagerKt$Pager$3$1$invokeSuspend$$inlined$filter$1 implements Flow<Boolean> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;

    public PagerKt$Pager$3$1$invokeSuspend$$inlined$filter$1(Flow flow) {
        this.$this_unsafeTransform$inlined = flow;
    }

    public Object collect(FlowCollector collector, Continuation $completion) {
        final FlowCollector $this$unsafeTransform_u24lambda_u2d0 = collector;
        Continuation continuation = $completion;
        Object collect = this.$this_unsafeTransform$inlined.collect(new FlowCollector() {
            /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
            /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof androidx.compose.foundation.pager.PagerKt$Pager$3$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0014
                    r0 = r9
                    androidx.compose.foundation.pager.PagerKt$Pager$3$1$invokeSuspend$$inlined$filter$1$2$1 r0 = (androidx.compose.foundation.pager.PagerKt$Pager$3$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r9 = r0.label
                    int r9 = r9 - r2
                    r0.label = r9
                    goto L_0x0019
                L_0x0014:
                    androidx.compose.foundation.pager.PagerKt$Pager$3$1$invokeSuspend$$inlined$filter$1$2$1 r0 = new androidx.compose.foundation.pager.PagerKt$Pager$3$1$invokeSuspend$$inlined$filter$1$2$1
                    r0.<init>(r7, r9)
                L_0x0019:
                    r9 = r0
                    java.lang.Object r0 = r9.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r9.label
                    switch(r2) {
                        case 0: goto L_0x0032;
                        case 1: goto L_0x002d;
                        default: goto L_0x0025;
                    }
                L_0x0025:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L_0x002d:
                    r8 = 0
                    kotlin.ResultKt.throwOnFailure(r0)
                    goto L_0x0058
                L_0x0032:
                    kotlin.ResultKt.throwOnFailure(r0)
                    r2 = r7
                    kotlinx.coroutines.flow.FlowCollector r2 = r0
                    r3 = 0
                    r4 = r9
                    kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                    r4 = r8
                    java.lang.Boolean r4 = (java.lang.Boolean) r4
                    boolean r4 = r4.booleanValue()
                    r5 = 0
                    r6 = 1
                    if (r4 != 0) goto L_0x0049
                    r4 = r6
                    goto L_0x004a
                L_0x0049:
                    r4 = 0
                L_0x004a:
                    if (r4 == 0) goto L_0x0057
                    r9.label = r6
                    java.lang.Object r8 = r2.emit(r8, r9)
                    if (r8 != r1) goto L_0x0055
                    return r1
                L_0x0055:
                    r8 = r3
                    goto L_0x0058
                L_0x0057:
                L_0x0058:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt$Pager$3$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, $completion);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
