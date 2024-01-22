package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1", f = "SelectionMagnifier.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SelectionMagnifier.kt */
final class SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Offset, AnimationVector2D> $animatable;
    final /* synthetic */ State<Offset> $targetValue$delegate;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1(State<Offset> state, Animatable<Offset, AnimationVector2D> animatable, Continuation<? super SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1> continuation) {
        super(2, continuation);
        this.$targetValue$delegate = state;
        this.$animatable = animatable;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1 selectionMagnifierKt$rememberAnimatedMagnifierPosition$1 = new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1(this.$targetValue$delegate, this.$animatable, continuation);
        selectionMagnifierKt$rememberAnimatedMagnifierPosition$1.L$0 = obj;
        return selectionMagnifierKt$rememberAnimatedMagnifierPosition$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final CoroutineScope animationScope = (CoroutineScope) this.L$0;
                final State<Offset> state = this.$targetValue$delegate;
                Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Offset>() {
                    public /* bridge */ /* synthetic */ Object invoke() {
                        return Offset.m2904boximpl(m1282invokeF1C5BW0());
                    }

                    /* renamed from: invoke-F1C5BW0  reason: not valid java name */
                    public final long m1282invokeF1C5BW0() {
                        return SelectionMagnifierKt.rememberAnimatedMagnifierPosition$lambda$1(state);
                    }
                });
                final Animatable<Offset, AnimationVector2D> animatable = this.$animatable;
                this.label = 1;
                if (snapshotFlow.collect(new FlowCollector<Offset>() {
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return m1283emit3MmeM6k(((Offset) value).m2925unboximpl(), $completion);
                    }

                    /* renamed from: emit-3MmeM6k  reason: not valid java name */
                    public final Object m1283emit3MmeM6k(long targetValue, Continuation<? super Unit> $completion) {
                        if (OffsetKt.m2934isSpecifiedk4lQ0M(animatable.getValue().m2925unboximpl()) && OffsetKt.m2934isSpecifiedk4lQ0M(targetValue)) {
                            if (!(Offset.m2916getYimpl(animatable.getValue().m2925unboximpl()) == Offset.m2916getYimpl(targetValue))) {
                                Job unused = BuildersKt__Builders_commonKt.launch$default(animationScope, (CoroutineContext) null, (CoroutineStart) null, new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$emit$2(animatable, targetValue, (Continuation<? super SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$emit$2>) null), 3, (Object) null);
                                return Unit.INSTANCE;
                            }
                        }
                        Object snapTo = animatable.snapTo(Offset.m2904boximpl(targetValue), $completion);
                        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
                    }
                }, this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
