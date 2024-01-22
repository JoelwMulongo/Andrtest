package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.ClickableKt$clickable$4$gesture$1$1", f = "Clickable.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Clickable.kt */
final class ClickableKt$clickable$4$gesture$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Offset> $centreOffset;
    final /* synthetic */ State<Function0<Boolean>> $delayPressInteraction;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ State<Function0<Unit>> $onClickState;
    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableKt$clickable$4$gesture$1$1(MutableState<Offset> mutableState, boolean z, MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState2, State<? extends Function0<Boolean>> state, State<? extends Function0<Unit>> state2, Continuation<? super ClickableKt$clickable$4$gesture$1$1> continuation) {
        super(2, continuation);
        this.$centreOffset = mutableState;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
        this.$pressedInteraction = mutableState2;
        this.$delayPressInteraction = state;
        this.$onClickState = state2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ClickableKt$clickable$4$gesture$1$1 clickableKt$clickable$4$gesture$1$1 = new ClickableKt$clickable$4$gesture$1$1(this.$centreOffset, this.$enabled, this.$interactionSource, this.$pressedInteraction, this.$delayPressInteraction, this.$onClickState, continuation);
        clickableKt$clickable$4$gesture$1$1.L$0 = obj;
        return clickableKt$clickable$4$gesture$1$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((ClickableKt$clickable$4$gesture$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.ClickableKt$clickable$4$gesture$1$1$1", f = "Clickable.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.ClickableKt$clickable$4$gesture$1$1$1  reason: invalid class name */
    /* compiled from: Clickable.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m481invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m2925unboximpl(), (Continuation) obj3);
        }

        /* renamed from: invoke-d-4ec7I  reason: not valid java name */
        public final Object m481invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(z, mutableInteractionSource, mutableState2, state, continuation);
            r0.L$0 = pressGestureScope;
            r0.J$0 = j;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r10.label
                switch(r1) {
                    case 0: goto L_0x0016;
                    case 1: goto L_0x0011;
                    default: goto L_0x0009;
                }
            L_0x0009:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x0011:
                r0 = r10
                kotlin.ResultKt.throwOnFailure(r11)
                goto L_0x003b
            L_0x0016:
                kotlin.ResultKt.throwOnFailure(r11)
                r1 = r10
                java.lang.Object r2 = r1.L$0
                r3 = r2
                androidx.compose.foundation.gestures.PressGestureScope r3 = (androidx.compose.foundation.gestures.PressGestureScope) r3
                long r4 = r1.J$0
                boolean r2 = r6
                if (r2 == 0) goto L_0x003c
                androidx.compose.foundation.interaction.MutableInteractionSource r6 = r7
                androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r7 = r8
                androidx.compose.runtime.State<kotlin.jvm.functions.Function0<java.lang.Boolean>> r8 = r9
                r9 = r1
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r2 = 1
                r1.label = r2
                java.lang.Object r2 = androidx.compose.foundation.ClickableKt.m480handlePressInteractionEPk0efs(r3, r4, r6, r7, r8, r9)
                if (r2 != r0) goto L_0x003a
                return r0
            L_0x003a:
                r0 = r1
            L_0x003b:
                r1 = r0
            L_0x003c:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableKt$clickable$4$gesture$1$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                MutableState<Offset> mutableState = this.$centreOffset;
                long $this$toOffset_u2d_u2dgyyYBs$iv = IntSizeKt.m6152getCenterozmzZPI($this$pointerInput.m4703getSizeYbymL2g());
                mutableState.setValue(Offset.m2904boximpl(OffsetKt.Offset((float) IntOffset.m6104getXimpl($this$toOffset_u2d_u2dgyyYBs$iv), (float) IntOffset.m6105getYimpl($this$toOffset_u2d_u2dgyyYBs$iv))));
                final boolean z = this.$enabled;
                final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                final MutableState<PressInteraction.Press> mutableState2 = this.$pressedInteraction;
                final State<Function0<Boolean>> state = this.$delayPressInteraction;
                Function3 r3 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
                final boolean z2 = this.$enabled;
                final State<Function0<Unit>> state2 = this.$onClickState;
                this.label = 1;
                if (TapGestureDetectorKt.detectTapAndPress($this$pointerInput, r3, new Function1<Offset, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        m482invokek4lQ0M(((Offset) p1).m2925unboximpl());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                    public final void m482invokek4lQ0M(long it) {
                        if (z2) {
                            state2.getValue().invoke();
                        }
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
