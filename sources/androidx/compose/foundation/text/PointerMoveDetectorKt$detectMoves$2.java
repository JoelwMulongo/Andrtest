package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2", f = "PointerMoveDetector.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PointerMoveDetector.kt */
final class PointerMoveDetectorKt$detectMoves$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Offset, Unit> $onMove;
    final /* synthetic */ PointerEventPass $pointerEventPass;
    final /* synthetic */ PointerInputScope $this_detectMoves;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PointerMoveDetectorKt$detectMoves$2(PointerInputScope pointerInputScope, PointerEventPass pointerEventPass, Function1<? super Offset, Unit> function1, Continuation<? super PointerMoveDetectorKt$detectMoves$2> continuation) {
        super(2, continuation);
        this.$this_detectMoves = pointerInputScope;
        this.$pointerEventPass = pointerEventPass;
        this.$onMove = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PointerMoveDetectorKt$detectMoves$2(this.$this_detectMoves, this.$pointerEventPass, this.$onMove, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PointerMoveDetectorKt$detectMoves$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final CoroutineContext currentContext = getContext();
                PointerInputScope pointerInputScope = this.$this_detectMoves;
                final PointerEventPass pointerEventPass = this.$pointerEventPass;
                final Function1<Offset, Unit> function1 = this.$onMove;
                this.label = 1;
                if (pointerInputScope.awaitPointerEventScope(new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) != coroutine_suspended) {
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

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2$1", f = "PointerMoveDetector.kt", i = {0, 0}, l = {44}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "previousPosition"}, s = {"L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2$1  reason: invalid class name */
    /* compiled from: PointerMoveDetector.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(currentContext, pointerEventPass, function1, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:8:0x003c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                r2 = 1
                switch(r1) {
                    case 0: goto L_0x0024;
                    case 1: goto L_0x0012;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x0012:
                r1 = r11
                java.lang.Object r3 = r1.L$1
                kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
                java.lang.Object r4 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                kotlin.ResultKt.throwOnFailure(r12)
                r5 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r12
                goto L_0x0055
            L_0x0024:
                kotlin.ResultKt.throwOnFailure(r12)
                r1 = r11
                java.lang.Object r3 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
                r4.<init>()
                r10 = r4
                r4 = r3
                r3 = r10
            L_0x0034:
                kotlin.coroutines.CoroutineContext r5 = r2
                boolean r5 = kotlinx.coroutines.JobKt.isActive(r5)
                if (r5 == 0) goto L_0x00c5
                androidx.compose.ui.input.pointer.PointerEventPass r5 = r5
                r6 = r1
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r1.L$0 = r4
                r1.L$1 = r3
                r1.label = r2
                java.lang.Object r5 = r4.awaitPointerEvent(r5, r6)
                if (r5 != r0) goto L_0x004e
                return r0
            L_0x004e:
                r10 = r0
                r0 = r12
                r12 = r5
                r5 = r4
                r4 = r3
                r3 = r1
                r1 = r10
            L_0x0055:
                androidx.compose.ui.input.pointer.PointerEvent r12 = (androidx.compose.ui.input.pointer.PointerEvent) r12
                int r6 = r12.m4612getType7fucELk()
                androidx.compose.ui.input.pointer.PointerEventType$Companion r7 = androidx.compose.ui.input.pointer.PointerEventType.Companion
                int r7 = r7.m4625getMove7fucELk()
                boolean r7 = androidx.compose.ui.input.pointer.PointerEventType.m4619equalsimpl0(r6, r7)
                if (r7 == 0) goto L_0x0069
                r7 = r2
                goto L_0x0073
            L_0x0069:
                androidx.compose.ui.input.pointer.PointerEventType$Companion r7 = androidx.compose.ui.input.pointer.PointerEventType.Companion
                int r7 = r7.m4623getEnter7fucELk()
                boolean r7 = androidx.compose.ui.input.pointer.PointerEventType.m4619equalsimpl0(r6, r7)
            L_0x0073:
                if (r7 == 0) goto L_0x0077
                r6 = r2
                goto L_0x0081
            L_0x0077:
                androidx.compose.ui.input.pointer.PointerEventType$Companion r7 = androidx.compose.ui.input.pointer.PointerEventType.Companion
                int r7 = r7.m4624getExit7fucELk()
                boolean r6 = androidx.compose.ui.input.pointer.PointerEventType.m4619equalsimpl0(r6, r7)
            L_0x0081:
                if (r6 == 0) goto L_0x00be
                java.util.List r6 = r12.getChanges()
                java.lang.Object r6 = kotlin.collections.CollectionsKt.first(r6)
                androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
                long r6 = r6.m4667getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r6 = androidx.compose.ui.geometry.Offset.m2904boximpl(r6)
                long r7 = r6.m2925unboximpl()
                r12 = 0
                T r9 = r4.element
                boolean r12 = androidx.compose.ui.geometry.Offset.m2911equalsimpl(r7, r9)
                if (r12 != 0) goto L_0x00a4
                goto L_0x00a5
            L_0x00a4:
                r6 = 0
            L_0x00a5:
                if (r6 == 0) goto L_0x00bd
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r12 = r6
                long r6 = r6.m2925unboximpl()
                r8 = 0
                androidx.compose.ui.geometry.Offset r9 = androidx.compose.ui.geometry.Offset.m2904boximpl(r6)
                r4.element = r9
                androidx.compose.ui.geometry.Offset r9 = androidx.compose.ui.geometry.Offset.m2904boximpl(r6)
                r12.invoke(r9)
            L_0x00bd:
            L_0x00be:
                r12 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r4 = r5
                goto L_0x0034
            L_0x00c5:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
