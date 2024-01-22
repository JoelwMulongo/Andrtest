package androidx.compose.foundation.text;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2", f = "LongPressTextDragObserver.kt", i = {0, 1, 1}, l = {98, 102}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down"}, s = {"L$0", "L$0", "L$1"})
/* compiled from: LongPressTextDragObserver.kt */
final class LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextDragObserver $observer;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2(TextDragObserver textDragObserver, Continuation<? super LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2> continuation) {
        super(2, continuation);
        this.$observer = textDragObserver;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2 longPressTextDragObserverKt$detectPreDragGesturesWithObserver$2 = new LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2(this.$observer, continuation);
        longPressTextDragObserverKt$detectPreDragGesturesWithObserver$2.L$0 = obj;
        return longPressTextDragObserverKt$detectPreDragGesturesWithObserver$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0059, code lost:
        r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4;
        r2.$observer.m1202onDownk4lQ0M(r4.m4667getPositionF1C5BW0());
        r17 = r5;
        r5 = r4;
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0069, code lost:
        r2.L$0 = r6;
        r2.L$1 = r5;
        r2.label = 2;
        r7 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r6, (androidx.compose.ui.input.pointer.PointerEventPass) null, r2, r3, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0078, code lost:
        if (r7 != r0) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007a, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007b, code lost:
        r17 = r5;
        r5 = r4;
        r4 = r7;
        r7 = r6;
        r6 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0082, code lost:
        r4 = ((androidx.compose.ui.input.pointer.PointerEvent) r4).getChanges();
        r10 = 0;
        r11 = r4.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0092, code lost:
        if (r10 >= r11) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0094, code lost:
        r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r4.get(r10);
        r19 = r4;
        r16 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ad, code lost:
        if (androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r13.m4666getIdJ3iCeTQ(), r6.m4666getIdJ3iCeTQ()) == false) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b3, code lost:
        if (r16.getPressed() == false) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b5, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b7, code lost:
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b8, code lost:
        if (r12 == false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ba, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00bc, code lost:
        r10 = r10 + 1;
        r4 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c3, code lost:
        r19 = r4;
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c7, code lost:
        if (r12 != false) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c9, code lost:
        r2.$observer.onUp();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d0, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d1, code lost:
        r4 = r5;
        r5 = r6;
        r6 = r7;
        r3 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r18
            int r2 = r1.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x0035;
                case 1: goto L_0x0027;
                case 2: goto L_0x0014;
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
            java.lang.Object r5 = r2.L$1
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            java.lang.Object r6 = r2.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
            kotlin.ResultKt.throwOnFailure(r4)
            r7 = r6
            r6 = r5
            r5 = r4
            goto L_0x0082
        L_0x0027:
            r2 = r18
            r4 = r19
            java.lang.Object r5 = r2.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            kotlin.ResultKt.throwOnFailure(r4)
            r6 = r5
            r5 = r4
            goto L_0x0059
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r19)
            r2 = r18
            r4 = r19
            java.lang.Object r5 = r2.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            r7 = 0
            r8 = 0
            r9 = r2
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r10 = 3
            r11 = 0
            r2.L$0 = r5
            r2.label = r3
            r6 = r5
            java.lang.Object r6 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r6, r7, r8, r9, r10, r11)
            if (r6 != r0) goto L_0x0053
            return r0
        L_0x0053:
            r17 = r5
            r5 = r4
            r4 = r6
            r6 = r17
        L_0x0059:
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
            androidx.compose.foundation.text.TextDragObserver r7 = r2.$observer
            long r8 = r4.m4667getPositionF1C5BW0()
            r7.m1202onDownk4lQ0M(r8)
            r17 = r5
            r5 = r4
            r4 = r17
        L_0x0069:
            r7 = r2
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r2.L$0 = r6
            r2.L$1 = r5
            r8 = 2
            r2.label = r8
            r8 = 0
            java.lang.Object r7 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r6, r8, r7, r3, r8)
            if (r7 != r0) goto L_0x007b
            return r0
        L_0x007b:
            r17 = r5
            r5 = r4
            r4 = r7
            r7 = r6
            r6 = r17
        L_0x0082:
            androidx.compose.ui.input.pointer.PointerEvent r4 = (androidx.compose.ui.input.pointer.PointerEvent) r4
            java.util.List r4 = r4.getChanges()
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r4.size()
        L_0x0092:
            if (r10 >= r11) goto L_0x00c3
            java.lang.Object r13 = r4.get(r10)
            r14 = 0
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            r15 = 0
            r19 = r4
            long r3 = r13.m4666getIdJ3iCeTQ()
            r16 = r13
            long r12 = r6.m4666getIdJ3iCeTQ()
            boolean r3 = androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r3, r12)
            if (r3 == 0) goto L_0x00b7
            boolean r3 = r16.getPressed()
            if (r3 == 0) goto L_0x00b7
            r12 = 1
            goto L_0x00b8
        L_0x00b7:
            r12 = 0
        L_0x00b8:
            if (r12 == 0) goto L_0x00bc
            r12 = 1
            goto L_0x00c7
        L_0x00bc:
            int r10 = r10 + 1
            r4 = r19
            r3 = 1
            goto L_0x0092
        L_0x00c3:
            r19 = r4
            r12 = 0
        L_0x00c7:
            if (r12 != 0) goto L_0x00d1
            androidx.compose.foundation.text.TextDragObserver r0 = r2.$observer
            r0.onUp()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00d1:
            r4 = r5
            r5 = r6
            r6 = r7
            r3 = 1
            goto L_0x0069
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
