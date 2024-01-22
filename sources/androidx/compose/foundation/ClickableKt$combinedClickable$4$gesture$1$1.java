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
@DebugMetadata(c = "androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$1", f = "Clickable.kt", i = {}, l = {343}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Clickable.kt */
final class ClickableKt$combinedClickable$4$gesture$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Offset> $centreOffset;
    final /* synthetic */ State<Function0<Boolean>> $delayPressInteraction;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ boolean $hasDoubleClick;
    final /* synthetic */ boolean $hasLongClick;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ State<Function0<Unit>> $onClickState;
    final /* synthetic */ State<Function0<Unit>> $onDoubleClickState;
    final /* synthetic */ State<Function0<Unit>> $onLongClickState;
    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableKt$combinedClickable$4$gesture$1$1(MutableState<Offset> mutableState, boolean z, boolean z2, boolean z3, State<? extends Function0<Unit>> state, State<? extends Function0<Unit>> state2, MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState2, State<? extends Function0<Boolean>> state3, State<? extends Function0<Unit>> state4, Continuation<? super ClickableKt$combinedClickable$4$gesture$1$1> continuation) {
        super(2, continuation);
        this.$centreOffset = mutableState;
        this.$hasDoubleClick = z;
        this.$enabled = z2;
        this.$hasLongClick = z3;
        this.$onDoubleClickState = state;
        this.$onLongClickState = state2;
        this.$interactionSource = mutableInteractionSource;
        this.$pressedInteraction = mutableState2;
        this.$delayPressInteraction = state3;
        this.$onClickState = state4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ClickableKt$combinedClickable$4$gesture$1$1 clickableKt$combinedClickable$4$gesture$1$1 = new ClickableKt$combinedClickable$4$gesture$1$1(this.$centreOffset, this.$hasDoubleClick, this.$enabled, this.$hasLongClick, this.$onDoubleClickState, this.$onLongClickState, this.$interactionSource, this.$pressedInteraction, this.$delayPressInteraction, this.$onClickState, continuation);
        clickableKt$combinedClickable$4$gesture$1$1.L$0 = obj;
        return clickableKt$combinedClickable$4$gesture$1$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((ClickableKt$combinedClickable$4$gesture$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$1$3", f = "Clickable.kt", i = {}, l = {356}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$1$3  reason: invalid class name */
    /* compiled from: Clickable.kt */
    static final class AnonymousClass3 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m485invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m2925unboximpl(), (Continuation) obj3);
        }

        /* renamed from: invoke-d-4ec7I  reason: not valid java name */
        public final Object m485invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
            AnonymousClass3 r0 = new AnonymousClass3(z, mutableInteractionSource, mutableState2, state3, continuation);
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
                boolean r2 = r7
                if (r2 == 0) goto L_0x003c
                androidx.compose.foundation.interaction.MutableInteractionSource r6 = r8
                androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r7 = r9
                androidx.compose.runtime.State<kotlin.jvm.functions.Function0<java.lang.Boolean>> r8 = r10
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$1.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object $result) {
        Function1 function1;
        Function1 function12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                MutableState<Offset> mutableState = this.$centreOffset;
                long $this$toOffset_u2d_u2dgyyYBs$iv = IntSizeKt.m6152getCenterozmzZPI($this$pointerInput.m4703getSizeYbymL2g());
                mutableState.setValue(Offset.m2904boximpl(OffsetKt.Offset((float) IntOffset.m6104getXimpl($this$toOffset_u2d_u2dgyyYBs$iv), (float) IntOffset.m6105getYimpl($this$toOffset_u2d_u2dgyyYBs$iv))));
                if (!this.$hasDoubleClick || !this.$enabled) {
                    function1 = null;
                } else {
                    final State<Function0<Unit>> state = this.$onDoubleClickState;
                    function1 = new Function1<Offset, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            m483invokek4lQ0M(((Offset) p1).m2925unboximpl());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                        public final void m483invokek4lQ0M(long it) {
                            Function0 value = state.getValue();
                            if (value != null) {
                                value.invoke();
                            }
                        }
                    };
                }
                if (!this.$hasLongClick || !this.$enabled) {
                    function12 = null;
                } else {
                    final State<Function0<Unit>> state2 = this.$onLongClickState;
                    function12 = new Function1<Offset, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            m484invokek4lQ0M(((Offset) p1).m2925unboximpl());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                        public final void m484invokek4lQ0M(long it) {
                            Function0 value = state2.getValue();
                            if (value != null) {
                                value.invoke();
                            }
                        }
                    };
                }
                final boolean z = this.$enabled;
                final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                final MutableState<PressInteraction.Press> mutableState2 = this.$pressedInteraction;
                final State<Function0<Boolean>> state3 = this.$delayPressInteraction;
                final boolean z2 = this.$enabled;
                final State<Function0<Unit>> state4 = this.$onClickState;
                this.label = 1;
                if (TapGestureDetectorKt.detectTapGestures($this$pointerInput, function1, function12, new AnonymousClass3((Continuation<? super AnonymousClass3>) null), new Function1<Offset, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        m486invokek4lQ0M(((Offset) p1).m2925unboximpl());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                    public final void m486invokek4lQ0M(long it) {
                        if (z2) {
                            state4.getValue().invoke();
                        }
                    }
                }, this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
