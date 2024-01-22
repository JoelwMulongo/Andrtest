package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt$mouseWheelScroll$1", f = "Scrollable.kt", i = {}, l = {291}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Scrollable.kt */
final class ScrollableKt$mouseWheelScroll$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ScrollConfig $mouseWheelScrollConfig;
    final /* synthetic */ State<ScrollingLogic> $scrollingLogicState;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollableKt$mouseWheelScroll$1(ScrollConfig scrollConfig, State<ScrollingLogic> state, Continuation<? super ScrollableKt$mouseWheelScroll$1> continuation) {
        super(2, continuation);
        this.$mouseWheelScrollConfig = scrollConfig;
        this.$scrollingLogicState = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollableKt$mouseWheelScroll$1 scrollableKt$mouseWheelScroll$1 = new ScrollableKt$mouseWheelScroll$1(this.$mouseWheelScrollConfig, this.$scrollingLogicState, continuation);
        scrollableKt$mouseWheelScroll$1.L$0 = obj;
        return scrollableKt$mouseWheelScroll$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((ScrollableKt$mouseWheelScroll$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt$mouseWheelScroll$1$1", f = "Scrollable.kt", i = {0}, l = {293}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.ScrollableKt$mouseWheelScroll$1$1  reason: invalid class name */
    /* compiled from: Scrollable.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(scrollConfig, state, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:9:0x003c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                r18 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                r1 = r18
                int r2 = r1.label
                r3 = 1
                switch(r2) {
                    case 0: goto L_0x0022;
                    case 1: goto L_0x0014;
                    default: goto L_0x000c;
                }
            L_0x000c:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0014:
                r2 = r18
                r4 = r19
                java.lang.Object r5 = r2.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                kotlin.ResultKt.throwOnFailure(r4)
                r6 = r5
                r5 = r4
                goto L_0x0042
            L_0x0022:
                kotlin.ResultKt.throwOnFailure(r19)
                r2 = r18
                r4 = r19
                java.lang.Object r5 = r2.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            L_0x002d:
                r6 = r2
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r2.L$0 = r5
                r2.label = r3
                java.lang.Object r6 = androidx.compose.foundation.gestures.ScrollableKt.awaitScrollEvent(r5, r6)
                if (r6 != r0) goto L_0x003c
                return r0
            L_0x003c:
                r17 = r5
                r5 = r4
                r4 = r6
                r6 = r17
            L_0x0042:
                androidx.compose.ui.input.pointer.PointerEvent r4 = (androidx.compose.ui.input.pointer.PointerEvent) r4
                java.util.List r7 = r4.getChanges()
                r8 = 0
                r9 = 0
                r10 = 0
                int r11 = r7.size()
            L_0x0052:
                r12 = 0
                if (r10 >= r11) goto L_0x006f
                java.lang.Object r13 = r7.get(r10)
                r14 = 0
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                r15 = 0
                boolean r16 = r13.isConsumed()
                if (r16 != 0) goto L_0x0066
                r13 = r3
                goto L_0x0067
            L_0x0066:
                r13 = r12
            L_0x0067:
                if (r13 != 0) goto L_0x006b
                r7 = r12
                goto L_0x0071
            L_0x006b:
                int r10 = r10 + 1
                goto L_0x0052
            L_0x006f:
                r7 = r3
            L_0x0071:
                if (r7 == 0) goto L_0x00c4
                androidx.compose.foundation.gestures.ScrollConfig r7 = r4
                androidx.compose.runtime.State<androidx.compose.foundation.gestures.ScrollingLogic> r8 = r5
                r9 = 0
                r10 = r6
                androidx.compose.ui.unit.Density r10 = (androidx.compose.ui.unit.Density) r10
                long r13 = r6.m4583getSizeYbymL2g()
                long r10 = r7.m621calculateMouseWheelScroll8xgXZGE(r10, r4, r13)
                java.lang.Object r7 = r8.getValue()
                androidx.compose.foundation.gestures.ScrollingLogic r7 = (androidx.compose.foundation.gestures.ScrollingLogic) r7
                r8 = 0
                float r13 = r7.m634toFloatk4lQ0M(r10)
                float r10 = r7.reverseIfNeeded(r13)
                androidx.compose.foundation.gestures.ScrollableState r11 = r7.getScrollableState()
                float r7 = r11.dispatchRawDelta(r10)
                r10 = 0
                int r10 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
                if (r10 != 0) goto L_0x00a1
                r12 = r3
            L_0x00a1:
                if (r12 != 0) goto L_0x00c0
                java.util.List r4 = r4.getChanges()
                r7 = 0
                r10 = 0
                int r11 = r4.size()
            L_0x00ae:
                if (r10 >= r11) goto L_0x00bf
                java.lang.Object r12 = r4.get(r10)
                r13 = r12
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                r14 = 0
                r13.consume()
                int r10 = r10 + 1
                goto L_0x00ae
            L_0x00bf:
            L_0x00c0:
            L_0x00c4:
                r4 = r5
                r5 = r6
                goto L_0x002d
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt$mouseWheelScroll$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final ScrollConfig scrollConfig = this.$mouseWheelScrollConfig;
                final State<ScrollingLogic> state = this.$scrollingLogicState;
                this.label = 1;
                if (((PointerInputScope) this.L$0).awaitPointerEventScope(new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) != coroutine_suspended) {
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
