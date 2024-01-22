package androidx.compose.material3;

import androidx.compose.foundation.interaction.Interaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class MappedInteractionSource$special$$inlined$map$1 implements Flow<Interaction> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ MappedInteractionSource this$0;

    public MappedInteractionSource$special$$inlined$map$1(Flow flow, MappedInteractionSource mappedInteractionSource) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = mappedInteractionSource;
    }

    public Object collect(FlowCollector collector, Continuation $completion) {
        final FlowCollector $this$unsafeTransform_u24lambda_u2d0 = collector;
        Continuation continuation = $completion;
        Flow flow = this.$this_unsafeTransform$inlined;
        final MappedInteractionSource mappedInteractionSource = this.this$0;
        Object collect = flow.collect(new FlowCollector() {
            /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
            /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r9, kotlin.coroutines.Continuation r10) {
                /*
                    r8 = this;
                    boolean r0 = r10 instanceof androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0014
                    r0 = r10
                    androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1$2$1 r0 = (androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r10 = r0.label
                    int r10 = r10 - r2
                    r0.label = r10
                    goto L_0x0019
                L_0x0014:
                    androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1$2$1 r0 = new androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1$2$1
                    r0.<init>(r8, r10)
                L_0x0019:
                    r10 = r0
                    java.lang.Object r0 = r10.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r10.label
                    switch(r2) {
                        case 0: goto L_0x0033;
                        case 1: goto L_0x002d;
                        default: goto L_0x0025;
                    }
                L_0x0025:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r10)
                    throw r9
                L_0x002d:
                    r9 = 0
                    kotlin.ResultKt.throwOnFailure(r0)
                    goto L_0x00b7
                L_0x0033:
                    kotlin.ResultKt.throwOnFailure(r0)
                    r2 = r8
                    kotlinx.coroutines.flow.FlowCollector r3 = r0
                    r4 = 0
                    r5 = r10
                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                    androidx.compose.foundation.interaction.Interaction r9 = (androidx.compose.foundation.interaction.Interaction) r9
                    r5 = 0
                    boolean r6 = r9 instanceof androidx.compose.foundation.interaction.PressInteraction.Press
                    if (r6 == 0) goto L_0x005c
                    androidx.compose.material3.MappedInteractionSource r6 = r5
                    r7 = r9
                    androidx.compose.foundation.interaction.PressInteraction$Press r7 = (androidx.compose.foundation.interaction.PressInteraction.Press) r7
                    androidx.compose.foundation.interaction.PressInteraction$Press r6 = r6.mapPress(r7)
                    androidx.compose.material3.MappedInteractionSource r7 = r5
                    java.util.Map r7 = r7.mappedPresses
                    r7.put(r9, r6)
                    r9 = r6
                    androidx.compose.foundation.interaction.Interaction r9 = (androidx.compose.foundation.interaction.Interaction) r9
                    goto L_0x00ab
                L_0x005c:
                    boolean r6 = r9 instanceof androidx.compose.foundation.interaction.PressInteraction.Cancel
                    if (r6 == 0) goto L_0x0083
                    androidx.compose.material3.MappedInteractionSource r6 = r5
                    java.util.Map r6 = r6.mappedPresses
                    r7 = r9
                    androidx.compose.foundation.interaction.PressInteraction$Cancel r7 = (androidx.compose.foundation.interaction.PressInteraction.Cancel) r7
                    androidx.compose.foundation.interaction.PressInteraction$Press r7 = r7.getPress()
                    java.lang.Object r6 = r6.remove(r7)
                    r2 = r6
                    androidx.compose.foundation.interaction.PressInteraction$Press r2 = (androidx.compose.foundation.interaction.PressInteraction.Press) r2
                    if (r2 != 0) goto L_0x007a
                    r6 = r9
                    androidx.compose.foundation.interaction.PressInteraction$Cancel r6 = (androidx.compose.foundation.interaction.PressInteraction.Cancel) r6
                    goto L_0x007f
                L_0x007a:
                    androidx.compose.foundation.interaction.PressInteraction$Cancel r6 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
                    r6.<init>(r2)
                L_0x007f:
                    r9 = r6
                    androidx.compose.foundation.interaction.Interaction r9 = (androidx.compose.foundation.interaction.Interaction) r9
                    goto L_0x00ab
                L_0x0083:
                    boolean r6 = r9 instanceof androidx.compose.foundation.interaction.PressInteraction.Release
                    if (r6 == 0) goto L_0x00aa
                    androidx.compose.material3.MappedInteractionSource r6 = r5
                    java.util.Map r6 = r6.mappedPresses
                    r7 = r9
                    androidx.compose.foundation.interaction.PressInteraction$Release r7 = (androidx.compose.foundation.interaction.PressInteraction.Release) r7
                    androidx.compose.foundation.interaction.PressInteraction$Press r7 = r7.getPress()
                    java.lang.Object r6 = r6.remove(r7)
                    r2 = r6
                    androidx.compose.foundation.interaction.PressInteraction$Press r2 = (androidx.compose.foundation.interaction.PressInteraction.Press) r2
                    if (r2 != 0) goto L_0x00a1
                    r6 = r9
                    androidx.compose.foundation.interaction.PressInteraction$Release r6 = (androidx.compose.foundation.interaction.PressInteraction.Release) r6
                    goto L_0x00a6
                L_0x00a1:
                    androidx.compose.foundation.interaction.PressInteraction$Release r6 = new androidx.compose.foundation.interaction.PressInteraction$Release
                    r6.<init>(r2)
                L_0x00a6:
                    r9 = r6
                    androidx.compose.foundation.interaction.Interaction r9 = (androidx.compose.foundation.interaction.Interaction) r9
                    goto L_0x00ab
                L_0x00aa:
                L_0x00ab:
                    r2 = 1
                    r10.label = r2
                    java.lang.Object r9 = r3.emit(r9, r10)
                    if (r9 != r1) goto L_0x00b6
                    return r1
                L_0x00b6:
                    r9 = r4
                L_0x00b7:
                    kotlin.Unit r9 = kotlin.Unit.INSTANCE
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, $completion);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
