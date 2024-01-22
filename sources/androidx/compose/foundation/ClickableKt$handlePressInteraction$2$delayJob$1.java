package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.ClickableKt$handlePressInteraction$2$delayJob$1", f = "Clickable.kt", i = {1}, l = {439, 442}, m = "invokeSuspend", n = {"pressInteraction"}, s = {"L$0"})
/* compiled from: Clickable.kt */
final class ClickableKt$handlePressInteraction$2$delayJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function0<Boolean>> $delayPressInteraction;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $pressPoint;
    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableKt$handlePressInteraction$2$delayJob$1(State<? extends Function0<Boolean>> state, long j, MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState, Continuation<? super ClickableKt$handlePressInteraction$2$delayJob$1> continuation) {
        super(2, continuation);
        this.$delayPressInteraction = state;
        this.$pressPoint = j;
        this.$interactionSource = mutableInteractionSource;
        this.$pressedInteraction = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClickableKt$handlePressInteraction$2$delayJob$1(this.$delayPressInteraction, this.$pressPoint, this.$interactionSource, this.$pressedInteraction, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClickableKt$handlePressInteraction$2$delayJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        PressInteraction.Press pressInteraction;
        ClickableKt$handlePressInteraction$2$delayJob$1 clickableKt$handlePressInteraction$2$delayJob$1;
        ClickableKt$handlePressInteraction$2$delayJob$1 clickableKt$handlePressInteraction$2$delayJob$12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                clickableKt$handlePressInteraction$2$delayJob$12 = this;
                if (((Boolean) clickableKt$handlePressInteraction$2$delayJob$12.$delayPressInteraction.getValue().invoke()).booleanValue()) {
                    clickableKt$handlePressInteraction$2$delayJob$12.label = 1;
                    if (DelayKt.delay(Clickable_androidKt.getTapIndicationDelay(), clickableKt$handlePressInteraction$2$delayJob$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                clickableKt$handlePressInteraction$2$delayJob$12 = this;
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                clickableKt$handlePressInteraction$2$delayJob$1 = this;
                pressInteraction = (PressInteraction.Press) clickableKt$handlePressInteraction$2$delayJob$1.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PressInteraction.Press pressInteraction2 = new PressInteraction.Press(clickableKt$handlePressInteraction$2$delayJob$12.$pressPoint, (DefaultConstructorMarker) null);
        clickableKt$handlePressInteraction$2$delayJob$12.L$0 = pressInteraction2;
        clickableKt$handlePressInteraction$2$delayJob$12.label = 2;
        if (clickableKt$handlePressInteraction$2$delayJob$12.$interactionSource.emit(pressInteraction2, clickableKt$handlePressInteraction$2$delayJob$12) == coroutine_suspended) {
            return coroutine_suspended;
        }
        clickableKt$handlePressInteraction$2$delayJob$1 = clickableKt$handlePressInteraction$2$delayJob$12;
        pressInteraction = pressInteraction2;
        clickableKt$handlePressInteraction$2$delayJob$1.$pressedInteraction.setValue(pressInteraction);
        return Unit.INSTANCE;
    }
}
