package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5", f = "DragGestureDetector.kt", i = {0, 1, 2}, l = {235, 236, 241}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "$this$awaitEachGesture"}, s = {"L$0", "L$0", "L$0"})
/* compiled from: DragGestureDetector.kt */
final class DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function0<Unit> $onDragEnd;
    final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super DragGestureDetectorKt$detectDragGesturesAfterLongPress$5> continuation) {
        super(2, continuation);
        this.$onDragStart = function1;
        this.$onDragEnd = function0;
        this.$onDragCancel = function02;
        this.$onDrag = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 dragGestureDetectorKt$detectDragGesturesAfterLongPress$5 = new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$onDrag, continuation);
        dragGestureDetectorKt$detectDragGesturesAfterLongPress$5.L$0 = obj;
        return dragGestureDetectorKt$detectDragGesturesAfterLongPress$5;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGesturesAfterLongPress$5) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            switch(r1) {
                case 0: goto L_0x0038;
                case 1: goto L_0x002c;
                case 2: goto L_0x0020;
                case 3: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0011:
            r0 = r10
            java.lang.Object r1 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CancellationException -> 0x001d }
            r3 = r1
            r1 = r11
            goto L_0x00a0
        L_0x001d:
            r1 = move-exception
            goto L_0x00f0
        L_0x0020:
            r1 = r10
            java.lang.Object r2 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CancellationException -> 0x00ec }
            r3 = r2
            r2 = r1
            r1 = r11
            goto L_0x0070
        L_0x002c:
            r1 = r10
            java.lang.Object r2 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CancellationException -> 0x00ec }
            r3 = r2
            r2 = r1
            r1 = r11
            goto L_0x005a
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r11)
            r1 = r10
            java.lang.Object r2 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            r4 = 0
            r5 = 0
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch:{ CancellationException -> 0x00ec }
            r7 = 2
            r8 = 0
            r1.L$0 = r2     // Catch:{ CancellationException -> 0x00ec }
            r3 = 1
            r1.label = r3     // Catch:{ CancellationException -> 0x00ec }
            r3 = r2
            java.lang.Object r3 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r3, r4, r5, r6, r7, r8)     // Catch:{ CancellationException -> 0x00ec }
            if (r3 != r0) goto L_0x0055
            return r0
        L_0x0055:
            r9 = r1
            r1 = r11
            r11 = r3
            r3 = r2
            r2 = r9
        L_0x005a:
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11     // Catch:{ CancellationException -> 0x00e6 }
            long r4 = r11.m4666getIdJ3iCeTQ()     // Catch:{ CancellationException -> 0x00e6 }
            r6 = r2
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch:{ CancellationException -> 0x00e6 }
            r2.L$0 = r3     // Catch:{ CancellationException -> 0x00e6 }
            r7 = 2
            r2.label = r7     // Catch:{ CancellationException -> 0x00e6 }
            java.lang.Object r4 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m544awaitLongPressOrCancellationrnUCldI(r3, r4, r6)     // Catch:{ CancellationException -> 0x00e6 }
            if (r4 != r0) goto L_0x006f
            return r0
        L_0x006f:
            r11 = r4
        L_0x0070:
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11     // Catch:{ CancellationException -> 0x00e6 }
            if (r11 == 0) goto L_0x00e3
            kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r4 = r2.$onDragStart     // Catch:{ CancellationException -> 0x00e6 }
            long r5 = r11.m4667getPositionF1C5BW0()     // Catch:{ CancellationException -> 0x00e6 }
            androidx.compose.ui.geometry.Offset r5 = androidx.compose.ui.geometry.Offset.m2904boximpl(r5)     // Catch:{ CancellationException -> 0x00e6 }
            r4.invoke(r5)     // Catch:{ CancellationException -> 0x00e6 }
            long r4 = r11.m4666getIdJ3iCeTQ()     // Catch:{ CancellationException -> 0x00e6 }
            androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1 r6 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1     // Catch:{ CancellationException -> 0x00e6 }
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r7 = r2.$onDrag     // Catch:{ CancellationException -> 0x00e6 }
            r6.<init>(r7)     // Catch:{ CancellationException -> 0x00e6 }
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6     // Catch:{ CancellationException -> 0x00e6 }
            r7 = r2
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch:{ CancellationException -> 0x00e6 }
            r2.L$0 = r3     // Catch:{ CancellationException -> 0x00e6 }
            r8 = 3
            r2.label = r8     // Catch:{ CancellationException -> 0x00e6 }
            java.lang.Object r4 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m554dragjO51t88(r3, r4, r6, r7)     // Catch:{ CancellationException -> 0x00e6 }
            if (r4 != r0) goto L_0x009e
            return r0
        L_0x009e:
            r0 = r2
            r11 = r4
        L_0x00a0:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ CancellationException -> 0x00de }
            boolean r11 = r11.booleanValue()     // Catch:{ CancellationException -> 0x00de }
            if (r11 == 0) goto L_0x00d7
            androidx.compose.ui.input.pointer.PointerEvent r11 = r3.getCurrentEvent()     // Catch:{ CancellationException -> 0x00de }
            java.util.List r11 = r11.getChanges()     // Catch:{ CancellationException -> 0x00de }
            r2 = 0
            r3 = 0
            int r4 = r11.size()     // Catch:{ CancellationException -> 0x00de }
        L_0x00b7:
            if (r3 >= r4) goto L_0x00d0
            java.lang.Object r5 = r11.get(r3)     // Catch:{ CancellationException -> 0x00de }
            r6 = r5
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6     // Catch:{ CancellationException -> 0x00de }
            r5 = r6
            r6 = 0
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r5)     // Catch:{ CancellationException -> 0x00de }
            if (r7 == 0) goto L_0x00cb
            r5.consume()     // Catch:{ CancellationException -> 0x00de }
        L_0x00cb:
            int r3 = r3 + 1
            goto L_0x00b7
        L_0x00d0:
            kotlin.jvm.functions.Function0<kotlin.Unit> r11 = r0.$onDragEnd     // Catch:{ CancellationException -> 0x00de }
            r11.invoke()     // Catch:{ CancellationException -> 0x00de }
            goto L_0x00dc
        L_0x00d7:
            kotlin.jvm.functions.Function0<kotlin.Unit> r11 = r0.$onDragCancel     // Catch:{ CancellationException -> 0x00de }
            r11.invoke()     // Catch:{ CancellationException -> 0x00de }
        L_0x00dc:
            r2 = r0
            goto L_0x00e3
        L_0x00de:
            r11 = move-exception
            r9 = r1
            r1 = r11
            r11 = r9
            goto L_0x00f0
        L_0x00e3:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00e6:
            r11 = move-exception
            r0 = r2
            r9 = r1
            r1 = r11
            r11 = r9
            goto L_0x00f0
        L_0x00ec:
            r0 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
        L_0x00f0:
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = r0.$onDragCancel
            r2.invoke()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
