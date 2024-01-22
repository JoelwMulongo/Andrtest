package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2", f = "DragGestureDetector.kt", i = {0, 0, 1, 1, 1}, l = {811, 828}, m = "invokeSuspend", n = {"$this$withTimeout", "finished", "$this$withTimeout", "event", "finished"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"})
/* compiled from: DragGestureDetector.kt */
final class DragGestureDetectorKt$awaitLongPressOrCancellation$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $currentDown;
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $longPress;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$awaitLongPressOrCancellation$2(Ref.ObjectRef<PointerInputChange> objectRef, Ref.ObjectRef<PointerInputChange> objectRef2, Continuation<? super DragGestureDetectorKt$awaitLongPressOrCancellation$2> continuation) {
        super(2, continuation);
        this.$currentDown = objectRef;
        this.$longPress = objectRef2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(this.$currentDown, this.$longPress, continuation);
        dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$0 = obj;
        return dragGestureDetectorKt$awaitLongPressOrCancellation$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$awaitLongPressOrCancellation$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00d4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x012a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            r23 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r23
            int r2 = r1.label
            r3 = 0
            r5 = 1
            switch(r2) {
                case 0: goto L_0x003b;
                case 1: goto L_0x002a;
                case 2: goto L_0x0015;
                default: goto L_0x000d;
            }
        L_0x000d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0015:
            r2 = r23
            r6 = r24
            int r7 = r2.I$0
            java.lang.Object r8 = r2.L$1
            androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
            java.lang.Object r9 = r2.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            kotlin.ResultKt.throwOnFailure(r6)
            r3 = r7
            r7 = r6
            goto L_0x0100
        L_0x002a:
            r2 = r23
            r6 = r24
            int r7 = r2.I$0
            java.lang.Object r8 = r2.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r6)
            r9 = r8
            r8 = r7
            r7 = r6
            goto L_0x0069
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r24)
            r2 = r23
            r6 = r24
            java.lang.Object r7 = r2.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            r8 = 0
            r22 = r8
            r8 = r7
            r7 = r22
        L_0x004c:
            if (r7 != 0) goto L_0x01e3
            androidx.compose.ui.input.pointer.PointerEventPass r9 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r10 = r2
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r2.L$0 = r8
            r2.L$1 = r3
            r2.I$0 = r7
            r2.label = r5
            java.lang.Object r9 = r8.awaitPointerEvent(r9, r10)
            if (r9 != r0) goto L_0x0062
            return r0
        L_0x0062:
            r22 = r7
            r7 = r6
            r6 = r9
            r9 = r8
            r8 = r22
        L_0x0069:
            androidx.compose.ui.input.pointer.PointerEvent r6 = (androidx.compose.ui.input.pointer.PointerEvent) r6
            java.util.List r10 = r6.getChanges()
            r11 = 0
            r12 = 0
            r13 = 0
            int r14 = r10.size()
        L_0x0079:
            if (r13 >= r14) goto L_0x0095
            java.lang.Object r15 = r10.get(r13)
            r16 = r15
            r17 = 0
            r18 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            r19 = 0
            boolean r18 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r18)
            if (r18 != 0) goto L_0x0091
            r10 = 0
            goto L_0x0097
        L_0x0091:
            int r13 = r13 + 1
            goto L_0x0079
        L_0x0095:
            r10 = r5
        L_0x0097:
            if (r10 == 0) goto L_0x009a
            r8 = 1
        L_0x009a:
            java.util.List r10 = r6.getChanges()
            r11 = 0
            r12 = 0
            r13 = 0
            int r14 = r10.size()
        L_0x00a9:
            if (r13 >= r14) goto L_0x00de
            java.lang.Object r15 = r10.get(r13)
            r16 = 0
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            r17 = 0
            boolean r18 = r15.isConsumed()
            if (r18 != 0) goto L_0x00cf
            long r3 = r9.m4583getSizeYbymL2g()
            r24 = r6
            long r5 = r9.m4582getExtendedTouchPaddingNHjbRc()
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.m4615isOutOfBoundsjwHxaWs(r15, r3, r5)
            if (r3 == 0) goto L_0x00cd
            goto L_0x00d1
        L_0x00cd:
            r3 = 0
            goto L_0x00d2
        L_0x00cf:
            r24 = r6
        L_0x00d1:
            r3 = 1
        L_0x00d2:
            if (r3 == 0) goto L_0x00d6
            r3 = 1
            goto L_0x00e2
        L_0x00d6:
            int r13 = r13 + 1
            r6 = r24
            r3 = 0
            r5 = 1
            goto L_0x00a9
        L_0x00de:
            r24 = r6
            r3 = 0
        L_0x00e2:
            if (r3 == 0) goto L_0x00e6
            r3 = 1
            goto L_0x00e7
        L_0x00e6:
            r3 = r8
        L_0x00e7:
            androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r5 = r2
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r2.L$0 = r9
            r6 = r24
            r2.L$1 = r6
            r2.I$0 = r3
            r8 = 2
            r2.label = r8
            java.lang.Object r4 = r9.awaitPointerEvent(r4, r5)
            if (r4 != r0) goto L_0x00fe
            return r0
        L_0x00fe:
            r8 = r6
            r6 = r4
        L_0x0100:
            r4 = r6
            androidx.compose.ui.input.pointer.PointerEvent r4 = (androidx.compose.ui.input.pointer.PointerEvent) r4
            java.util.List r4 = r4.getChanges()
            r5 = 0
            r6 = 0
            r10 = 0
            int r11 = r4.size()
        L_0x0111:
            if (r10 >= r11) goto L_0x012a
            java.lang.Object r12 = r4.get(r10)
            r13 = r12
            r14 = 0
            r15 = r13
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            r16 = 0
            boolean r15 = r15.isConsumed()
            if (r15 == 0) goto L_0x0126
            r4 = 1
            goto L_0x012c
        L_0x0126:
            int r10 = r10 + 1
            goto L_0x0111
        L_0x012a:
            r4 = 0
        L_0x012c:
            if (r4 == 0) goto L_0x012f
            r3 = 1
        L_0x012f:
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r2.$currentDown
            T r4 = r4.element
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
            long r4 = r4.m4666getIdJ3iCeTQ()
            boolean r4 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m556isPointerUpDmW0f2w(r8, r4)
            if (r4 == 0) goto L_0x0186
            java.util.List r4 = r8.getChanges()
            r5 = 0
            r6 = 0
            r8 = 0
            int r10 = r4.size()
        L_0x014d:
            if (r8 >= r10) goto L_0x0164
            java.lang.Object r11 = r4.get(r8)
            r12 = r11
            r13 = 0
            r14 = r12
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            r15 = 0
            boolean r14 = r14.getPressed()
            if (r14 == 0) goto L_0x0160
            goto L_0x0166
        L_0x0160:
            int r8 = r8 + 1
            goto L_0x014d
        L_0x0164:
            r12 = 0
        L_0x0166:
            r4 = r12
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
            if (r4 == 0) goto L_0x017e
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r5 = r2.$currentDown
            r5.element = r4
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r2.$longPress
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r5 = r2.$currentDown
            T r5 = r5.element
            r4.element = r5
            r24 = r0
            r20 = r2
            r21 = r3
            goto L_0x01d5
        L_0x017e:
            r3 = 1
            r6 = r7
            r8 = r9
            r5 = 1
            r7 = r3
            r3 = 0
            goto L_0x004c
        L_0x0186:
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r2.$longPress
            java.util.List r5 = r8.getChanges()
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r6 = r2.$currentDown
            r8 = 0
            r10 = 0
            r11 = 0
            int r12 = r5.size()
        L_0x0198:
            if (r11 >= r12) goto L_0x01cb
            java.lang.Object r13 = r5.get(r11)
            r14 = r13
            r15 = 0
            r16 = r14
            androidx.compose.ui.input.pointer.PointerInputChange r16 = (androidx.compose.ui.input.pointer.PointerInputChange) r16
            r17 = 0
            r24 = r0
            long r0 = r16.m4666getIdJ3iCeTQ()
            r20 = r2
            T r2 = r6.element
            androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
            r21 = r3
            long r2 = r2.m4666getIdJ3iCeTQ()
            boolean r0 = androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r0, r2)
            if (r0 == 0) goto L_0x01bf
            goto L_0x01d3
        L_0x01bf:
            int r11 = r11 + 1
            r1 = r23
            r0 = r24
            r2 = r20
            r3 = r21
            goto L_0x0198
        L_0x01cb:
            r24 = r0
            r20 = r2
            r21 = r3
            r14 = 0
        L_0x01d3:
            r4.element = r14
        L_0x01d5:
            r1 = r23
            r0 = r24
            r6 = r7
            r8 = r9
            r2 = r20
            r7 = r21
            r3 = 0
            r5 = 1
            goto L_0x004c
        L_0x01e3:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
