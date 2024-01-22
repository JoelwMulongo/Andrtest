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
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5", f = "DragGestureDetector.kt", i = {0, 1, 1}, l = {539, 541, 552}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "overSlop"}, s = {"L$0", "L$0", "L$1"})
/* compiled from: DragGestureDetector.kt */
final class DragGestureDetectorKt$detectHorizontalDragGestures$5 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function0<Unit> $onDragEnd;
    final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    final /* synthetic */ Function2<PointerInputChange, Float, Unit> $onHorizontalDrag;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$detectHorizontalDragGestures$5(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super DragGestureDetectorKt$detectHorizontalDragGestures$5> continuation) {
        super(2, continuation);
        this.$onDragStart = function1;
        this.$onHorizontalDrag = function2;
        this.$onDragEnd = function0;
        this.$onDragCancel = function02;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectHorizontalDragGestures$5 dragGestureDetectorKt$detectHorizontalDragGestures$5 = new DragGestureDetectorKt$detectHorizontalDragGestures$5(this.$onDragStart, this.$onHorizontalDrag, this.$onDragEnd, this.$onDragCancel, continuation);
        dragGestureDetectorKt$detectHorizontalDragGestures$5.L$0 = obj;
        return dragGestureDetectorKt$detectHorizontalDragGestures$5;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectHorizontalDragGestures$5) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0054, code lost:
        r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12;
        r10 = new kotlin.jvm.internal.Ref.FloatRef();
        r2.L$0 = r9;
        r2.L$1 = r10;
        r2.label = 2;
        r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m542awaitHorizontalPointerSlopOrCancellationgDDlDlE(r9, r12.m4666getIdJ3iCeTQ(), r12.m4670getTypeT8wyACA(), new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$drag$1(r10), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x007c, code lost:
        if (r12 != r0) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007e, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007f, code lost:
        r3 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0080, code lost:
        r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0082, code lost:
        if (r12 == null) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0084, code lost:
        r2.$onDragStart.invoke(androidx.compose.ui.geometry.Offset.m2904boximpl(r12.m4667getPositionF1C5BW0()));
        r2.$onHorizontalDrag.invoke(r12, kotlin.coroutines.jvm.internal.Boxing.boxFloat(r10.element));
        r4 = r12.m4666getIdJ3iCeTQ();
        r7 = r2.$onHorizontalDrag;
        r2.L$0 = null;
        r2.L$1 = null;
        r2.label = 3;
        r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m555horizontalDragjO51t88(r3, r4, new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5.AnonymousClass1(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b9, code lost:
        if (r12 != r0) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00bb, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00bc, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c3, code lost:
        if (((java.lang.Boolean) r12).booleanValue() == false) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00c5, code lost:
        r0.$onDragEnd.invoke();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00cb, code lost:
        r0.$onDragCancel.invoke();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d0, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00d3, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            switch(r1) {
                case 0: goto L_0x0034;
                case 1: goto L_0x0028;
                case 2: goto L_0x0018;
                case 3: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0011:
            r0 = r11
            kotlin.ResultKt.throwOnFailure(r12)
            r1 = r12
            goto L_0x00bd
        L_0x0018:
            r1 = r11
            java.lang.Object r2 = r1.L$1
            kotlin.jvm.internal.Ref$FloatRef r2 = (kotlin.jvm.internal.Ref.FloatRef) r2
            java.lang.Object r3 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
            kotlin.ResultKt.throwOnFailure(r12)
            r10 = r2
            r2 = r1
            r1 = r12
            goto L_0x0080
        L_0x0028:
            r1 = r11
            java.lang.Object r2 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            kotlin.ResultKt.throwOnFailure(r12)
            r9 = r2
            r2 = r1
            r1 = r12
            goto L_0x0054
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r12)
            r1 = r11
            java.lang.Object r2 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            r4 = 0
            r5 = 0
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7 = 2
            r8 = 0
            r1.L$0 = r2
            r3 = 1
            r1.label = r3
            r3 = r2
            java.lang.Object r3 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r3, r4, r5, r6, r7, r8)
            if (r3 != r0) goto L_0x0050
            return r0
        L_0x0050:
            r9 = r2
            r2 = r1
            r1 = r12
            r12 = r3
        L_0x0054:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            kotlin.jvm.internal.Ref$FloatRef r3 = new kotlin.jvm.internal.Ref$FloatRef
            r3.<init>()
            r10 = r3
            long r4 = r12.m4666getIdJ3iCeTQ()
            int r6 = r12.m4670getTypeT8wyACA()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$drag$1 r12 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$drag$1
            r12.<init>(r10)
            r7 = r12
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = r2
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r2.L$0 = r9
            r2.L$1 = r10
            r12 = 2
            r2.label = r12
            r3 = r9
            java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m542awaitHorizontalPointerSlopOrCancellationgDDlDlE(r3, r4, r6, r7, r8)
            if (r12 != r0) goto L_0x007f
            return r0
        L_0x007f:
            r3 = r9
        L_0x0080:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            if (r12 == 0) goto L_0x00d1
            kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r4 = r2.$onDragStart
            long r5 = r12.m4667getPositionF1C5BW0()
            androidx.compose.ui.geometry.Offset r5 = androidx.compose.ui.geometry.Offset.m2904boximpl(r5)
            r4.invoke(r5)
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float, kotlin.Unit> r4 = r2.$onHorizontalDrag
            float r5 = r10.element
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            r4.invoke(r12, r5)
            long r4 = r12.m4666getIdJ3iCeTQ()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1 r6 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float, kotlin.Unit> r7 = r2.$onHorizontalDrag
            r6.<init>(r7)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r7 = r2
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r8 = 0
            r2.L$0 = r8
            r2.L$1 = r8
            r8 = 3
            r2.label = r8
            java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m555horizontalDragjO51t88(r3, r4, r6, r7)
            if (r12 != r0) goto L_0x00bc
            return r0
        L_0x00bc:
            r0 = r2
        L_0x00bd:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x00cb
            kotlin.jvm.functions.Function0<kotlin.Unit> r12 = r0.$onDragEnd
            r12.invoke()
            goto L_0x00d0
        L_0x00cb:
            kotlin.jvm.functions.Function0<kotlin.Unit> r12 = r0.$onDragCancel
            r12.invoke()
        L_0x00d0:
            r2 = r0
        L_0x00d1:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
