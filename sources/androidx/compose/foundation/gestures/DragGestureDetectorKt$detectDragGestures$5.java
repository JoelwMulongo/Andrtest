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
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5", f = "DragGestureDetector.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {176, 890, 940, 193}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv", "pointerDirectionConfig$iv", "pointer$iv", "triggerOnMainAxisSlop$iv", "touchSlop$iv", "totalMainPositionChange$iv", "totalCrossPositionChange$iv", "$this$awaitEachGesture", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv", "pointerDirectionConfig$iv", "pointer$iv", "dragEvent$iv", "triggerOnMainAxisSlop$iv", "touchSlop$iv", "totalMainPositionChange$iv", "totalCrossPositionChange$iv"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "F$0", "F$1", "F$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "F$0", "F$1", "F$2"})
/* compiled from: DragGestureDetector.kt */
final class DragGestureDetectorKt$detectDragGestures$5 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function0<Unit> $onDragEnd;
    final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    float F$0;
    float F$1;
    float F$2;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$detectDragGestures$5(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super DragGestureDetectorKt$detectDragGestures$5> continuation) {
        super(2, continuation);
        this.$onDragStart = function1;
        this.$onDrag = function2;
        this.$onDragCancel = function0;
        this.$onDragEnd = function02;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGestures$5 dragGestureDetectorKt$detectDragGestures$5 = new DragGestureDetectorKt$detectDragGestures$5(this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
        dragGestureDetectorKt$detectDragGestures$5.L$0 = obj;
        return dragGestureDetectorKt$detectDragGestures$5;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGestures$5) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00c9, code lost:
        r3 = (androidx.compose.ui.input.pointer.PointerInputChange) r3;
        r6 = new kotlin.jvm.internal.Ref.LongRef();
        r6.element = androidx.compose.ui.geometry.Offset.Companion.m2931getZeroF1C5BW0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00d8, code lost:
        r7 = r5;
        r8 = r3.m4666getIdJ3iCeTQ();
        r10 = r3.m4670getTypeT8wyACA();
        r11 = 0;
        r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.getHorizontalPointerDirectionConfig();
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00f1, code lost:
        if (androidx.compose.foundation.gestures.DragGestureDetectorKt.m556isPointerUpDmW0f2w(r7.getCurrentEvent(), r8) == false) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00f3, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00f6, code lost:
        r10 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m557pointerSlopE8SPZFQ(r7.getViewConfiguration(), r10);
        r14 = new kotlin.jvm.internal.Ref.LongRef();
        r14.element = r8;
        r8 = 0.0f;
        r9 = 0.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0107, code lost:
        r2.L$0 = r5;
        r2.L$1 = r3;
        r2.L$2 = r6;
        r2.L$3 = r7;
        r2.L$4 = r12;
        r2.L$5 = r14;
        r2.L$6 = null;
        r2.I$0 = r11;
        r2.F$0 = r10;
        r2.F$1 = r8;
        r2.F$2 = r9;
        r31 = r3;
        r2.label = 2;
        r15 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r7, (androidx.compose.ui.input.pointer.PointerEventPass) null, r2, 1, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x012c, code lost:
        if (r15 != r0) goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x012e, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x012f, code lost:
        r1 = r13;
        r13 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0132, code lost:
        r15 = (androidx.compose.ui.input.pointer.PointerEvent) r15;
        r31 = r15.getChanges();
        r3 = r31.size();
        r19 = r1;
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x014a, code lost:
        if (r1 >= r3) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x014c, code lost:
        r18 = r3;
        r3 = r31;
        r21 = r3.get(r1);
        r25 = r3;
        r31 = r4;
        r26 = r6;
        r27 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0170, code lost:
        if (androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(((androidx.compose.ui.input.pointer.PointerInputChange) r21).m4666getIdJ3iCeTQ(), r14.element) == false) goto L_0x0175;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0172, code lost:
        r1 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0175, code lost:
        r1 = r1 + 1;
        r4 = r31;
        r3 = r18;
        r31 = r25;
        r6 = r26;
        r7 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0183, code lost:
        r25 = r31;
        r31 = r4;
        r26 = r6;
        r27 = r7;
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x018d, code lost:
        r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x018f, code lost:
        if (r1 != null) goto L_0x0199;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0191, code lost:
        r4 = r31;
        r3 = r13;
        r6 = r26;
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x019d, code lost:
        if (r1.isConsumed() == false) goto L_0x01a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x019f, code lost:
        r4 = r31;
        r3 = r13;
        r6 = r26;
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x01ab, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r1) == false) goto L_0x01f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x01ad, code lost:
        r1 = r15.getChanges();
        r6 = 0;
        r7 = r1.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x01bb, code lost:
        if (r6 >= r7) goto L_0x01d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x01bd, code lost:
        r16 = r1.get(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x01cf, code lost:
        if (((androidx.compose.ui.input.pointer.PointerInputChange) r16).getPressed() == false) goto L_0x01d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01d1, code lost:
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01d4, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01d8, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01da, code lost:
        r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01dc, code lost:
        if (r1 != null) goto L_0x01e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01de, code lost:
        r4 = r31;
        r3 = r13;
        r6 = r26;
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01e6, code lost:
        r14.element = r1.m4666getIdJ3iCeTQ();
        r1 = r30;
        r4 = r31;
        r3 = r13;
        r13 = r19;
        r6 = r26;
        r7 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01f9, code lost:
        r3 = r1.m4667getPositionF1C5BW0();
        r6 = r1.m4668getPreviousPositionF1C5BW0();
        r8 = r8 + (r12.m583mainAxisDeltak4lQ0M(r3) - r12.m583mainAxisDeltak4lQ0M(r6));
        r7 = r9 + (r12.m582crossAxisDeltak4lQ0M(r3) - r12.m582crossAxisDeltak4lQ0M(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0217, code lost:
        if (r11 == 0) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0219, code lost:
        r3 = java.lang.Math.abs(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x021e, code lost:
        r3 = androidx.compose.ui.geometry.Offset.m2913getDistanceimpl(r12.m584offsetFromChangesdBAh8RU(r8, r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x022c, code lost:
        if (r3 >= r10) goto L_0x0273;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x022e, code lost:
        r2.L$0 = r5;
        r2.L$1 = r13;
        r6 = r26;
        r2.L$2 = r6;
        r9 = r27;
        r2.L$3 = r9;
        r2.L$4 = r12;
        r2.L$5 = r14;
        r2.L$6 = r1;
        r2.I$0 = r11;
        r2.F$0 = r10;
        r2.F$1 = r8;
        r2.F$2 = r7;
        r2.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0254, code lost:
        if (r9.awaitPointerEvent(androidx.compose.ui.input.pointer.PointerEventPass.Final, r2) != r0) goto L_0x0257;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0256, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0257, code lost:
        r4 = r31;
        r3 = r13;
        r13 = r19;
        r28 = r11;
        r11 = r1;
        r1 = r28;
        r29 = r9;
        r9 = r7;
        r7 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x026a, code lost:
        if (r11.isConsumed() == false) goto L_0x026e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x026c, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x026e, code lost:
        r11 = r1;
        r1 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0273, code lost:
        r6 = r26;
        r9 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0277, code lost:
        if (r11 == 0) goto L_0x0289;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0279, code lost:
        r3 = r12.m584offsetFromChangesdBAh8RU(r8 - (java.lang.Math.signum(r8) * r10), r7);
        r15 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0289, code lost:
        r7 = r12.m584offsetFromChangesdBAh8RU(r8, r7);
        r15 = r5;
        r3 = androidx.compose.ui.geometry.Offset.m2919minusMKHz9U(r7, androidx.compose.ui.geometry.Offset.m2922timestuRUvjQ(androidx.compose.ui.geometry.Offset.m2910divtuRUvjQ(r7, r3), r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x029f, code lost:
        r1.consume();
        r6.element = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x02b2, code lost:
        if (r1.isConsumed() == false) goto L_0x0323;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x02b4, code lost:
        r4 = r31;
        r3 = r13;
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x02b9, code lost:
        if (r1 == null) goto L_0x02c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x02bf, code lost:
        if (r1.isConsumed() == false) goto L_0x02c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x02c2, code lost:
        r1 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x02c6, code lost:
        if (r1 == null) goto L_0x0320;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x02c8, code lost:
        r2.$onDragStart.invoke(androidx.compose.ui.geometry.Offset.m2904boximpl(r1.m4667getPositionF1C5BW0()));
        r2.$onDrag.invoke(r1, androidx.compose.ui.geometry.Offset.m2904boximpl(r6.element));
        r6 = r1.m4666getIdJ3iCeTQ();
        r8 = r2.$onDrag;
        r2.L$0 = null;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.L$5 = null;
        r2.L$6 = null;
        r2.label = 4;
        r1 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m554dragjO51t88(r5, r6, new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5.AnonymousClass2(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0307, code lost:
        if (r1 != r0) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0309, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x030a, code lost:
        r0 = r2;
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0312, code lost:
        if (((java.lang.Boolean) r2).booleanValue() != false) goto L_0x031a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0314, code lost:
        r0.$onDragCancel.invoke();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x031a, code lost:
        r0.$onDragEnd.invoke();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x031f, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0322, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0323, code lost:
        r8 = 0.0f;
        r4 = r31;
        r7 = r9;
        r3 = r13;
        r5 = r15;
        r13 = r19;
        r9 = 0.0f;
        r1 = r30;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r31) {
        /*
            r30 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r30
            int r2 = r1.label
            switch(r2) {
                case 0: goto L_0x00a4;
                case 1: goto L_0x0096;
                case 2: goto L_0x0059;
                case 3: goto L_0x001d;
                case 4: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0013:
            r0 = r30
            r2 = r31
            kotlin.ResultKt.throwOnFailure(r2)
            r4 = r2
            goto L_0x030c
        L_0x001d:
            r2 = r30
            r5 = r31
            r6 = 0
            float r7 = r2.F$2
            float r8 = r2.F$1
            float r9 = r2.F$0
            int r10 = r2.I$0
            java.lang.Object r11 = r2.L$6
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            java.lang.Object r12 = r2.L$5
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
            java.lang.Object r13 = r2.L$4
            androidx.compose.foundation.gestures.PointerDirectionConfig r13 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r13
            java.lang.Object r14 = r2.L$3
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
            java.lang.Object r15 = r2.L$2
            kotlin.jvm.internal.Ref$LongRef r15 = (kotlin.jvm.internal.Ref.LongRef) r15
            java.lang.Object r4 = r2.L$1
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
            java.lang.Object r3 = r2.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
            kotlin.ResultKt.throwOnFailure(r5)
            r1 = r10
            r10 = r9
            r9 = r7
            r7 = r14
            r14 = r12
            r12 = r13
            r13 = r6
            r6 = r15
            r28 = r5
            r5 = r3
            r3 = r4
            r4 = r28
            goto L_0x0266
        L_0x0059:
            r2 = r30
            r3 = r31
            r4 = 0
            float r5 = r2.F$2
            float r6 = r2.F$1
            float r7 = r2.F$0
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$5
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r2.L$4
            androidx.compose.foundation.gestures.PointerDirectionConfig r10 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r10
            java.lang.Object r11 = r2.L$3
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            java.lang.Object r12 = r2.L$2
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
            java.lang.Object r13 = r2.L$1
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            java.lang.Object r14 = r2.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
            kotlin.ResultKt.throwOnFailure(r3)
            r15 = r3
            r1 = r4
            r4 = r15
            r3 = 1
            r28 = r9
            r9 = r5
            r5 = r14
            r14 = r28
            r29 = r8
            r8 = r6
            r6 = r12
            r12 = r10
            r10 = r7
            r7 = r11
            r11 = r29
            goto L_0x0132
        L_0x0096:
            r2 = r30
            r3 = r31
            java.lang.Object r4 = r2.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
            kotlin.ResultKt.throwOnFailure(r3)
            r5 = r4
            r4 = r3
            goto L_0x00c9
        L_0x00a4:
            kotlin.ResultKt.throwOnFailure(r31)
            r2 = r30
            r3 = r31
            java.lang.Object r4 = r2.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
            r6 = 0
            r7 = 0
            r8 = r2
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r9 = 2
            r10 = 0
            r2.L$0 = r4
            r5 = 1
            r2.label = r5
            r5 = r4
            java.lang.Object r5 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)
            if (r5 != r0) goto L_0x00c3
            return r0
        L_0x00c3:
            r28 = r4
            r4 = r3
            r3 = r5
            r5 = r28
        L_0x00c9:
            androidx.compose.ui.input.pointer.PointerInputChange r3 = (androidx.compose.ui.input.pointer.PointerInputChange) r3
            kotlin.jvm.internal.Ref$LongRef r6 = new kotlin.jvm.internal.Ref$LongRef
            r6.<init>()
            androidx.compose.ui.geometry.Offset$Companion r7 = androidx.compose.ui.geometry.Offset.Companion
            long r7 = r7.m2931getZeroF1C5BW0()
            r6.element = r7
        L_0x00d8:
            r7 = r5
            long r8 = r3.m4666getIdJ3iCeTQ()
            int r10 = r3.m4670getTypeT8wyACA()
            r11 = 0
            androidx.compose.foundation.gestures.PointerDirectionConfig r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.getHorizontalPointerDirectionConfig()
            r13 = 0
            androidx.compose.ui.input.pointer.PointerEvent r14 = r7.getCurrentEvent()
            boolean r14 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m556isPointerUpDmW0f2w(r14, r8)
            if (r14 == 0) goto L_0x00f6
            r1 = 0
            goto L_0x02b8
        L_0x00f6:
            androidx.compose.ui.platform.ViewConfiguration r14 = r7.getViewConfiguration()
            float r10 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m557pointerSlopE8SPZFQ(r14, r10)
            kotlin.jvm.internal.Ref$LongRef r14 = new kotlin.jvm.internal.Ref$LongRef
            r14.<init>()
            r14.element = r8
            r8 = 0
            r9 = 0
        L_0x0107:
            r15 = r2
            kotlin.coroutines.Continuation r15 = (kotlin.coroutines.Continuation) r15
            r2.L$0 = r5
            r2.L$1 = r3
            r2.L$2 = r6
            r2.L$3 = r7
            r2.L$4 = r12
            r2.L$5 = r14
            r1 = 0
            r2.L$6 = r1
            r2.I$0 = r11
            r2.F$0 = r10
            r2.F$1 = r8
            r2.F$2 = r9
            r31 = r3
            r3 = 2
            r2.label = r3
            r3 = 1
            java.lang.Object r15 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r7, r1, r15, r3, r1)
            if (r15 != r0) goto L_0x012f
            return r0
        L_0x012f:
            r1 = r13
            r13 = r31
        L_0x0132:
            androidx.compose.ui.input.pointer.PointerEvent r15 = (androidx.compose.ui.input.pointer.PointerEvent) r15
            java.util.List r16 = r15.getChanges()
            r17 = 0
            r31 = r16
            r16 = 0
            r18 = 0
            int r3 = r31.size()
            r19 = r1
            r1 = r18
        L_0x014a:
            if (r1 >= r3) goto L_0x0183
            r18 = r3
            r3 = r31
            java.lang.Object r20 = r3.get(r1)
            r21 = r20
            r22 = 0
            r23 = r21
            androidx.compose.ui.input.pointer.PointerInputChange r23 = (androidx.compose.ui.input.pointer.PointerInputChange) r23
            r24 = 0
            r25 = r3
            r31 = r4
            long r3 = r23.m4666getIdJ3iCeTQ()
            r26 = r6
            r27 = r7
            long r6 = r14.element
            boolean r3 = androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r3, r6)
            if (r3 == 0) goto L_0x0175
            r1 = r21
            goto L_0x018d
        L_0x0175:
            int r1 = r1 + 1
            r4 = r31
            r3 = r18
            r31 = r25
            r6 = r26
            r7 = r27
            goto L_0x014a
        L_0x0183:
            r25 = r31
            r31 = r4
            r26 = r6
            r27 = r7
            r1 = 0
        L_0x018d:
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            if (r1 != 0) goto L_0x0199
            r4 = r31
            r3 = r13
            r6 = r26
            r1 = 0
            goto L_0x02b8
        L_0x0199:
            boolean r3 = r1.isConsumed()
            if (r3 == 0) goto L_0x01a7
            r4 = r31
            r3 = r13
            r6 = r26
            r1 = 0
            goto L_0x02b8
        L_0x01a7:
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r1)
            if (r3 == 0) goto L_0x01f9
            java.util.List r1 = r15.getChanges()
            r3 = 0
            r4 = 0
            r6 = 0
            int r7 = r1.size()
        L_0x01bb:
            if (r6 >= r7) goto L_0x01d8
            java.lang.Object r15 = r1.get(r6)
            r16 = r15
            r17 = 0
            r18 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            r20 = 0
            boolean r18 = r18.getPressed()
            if (r18 == 0) goto L_0x01d4
            r1 = r16
            goto L_0x01da
        L_0x01d4:
            int r6 = r6 + 1
            goto L_0x01bb
        L_0x01d8:
            r1 = 0
        L_0x01da:
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            if (r1 != 0) goto L_0x01e6
            r4 = r31
            r3 = r13
            r6 = r26
            r1 = 0
            goto L_0x02b8
        L_0x01e6:
            long r3 = r1.m4666getIdJ3iCeTQ()
            r14.element = r3
            r1 = r30
            r4 = r31
            r3 = r13
            r13 = r19
            r6 = r26
            r7 = r27
            goto L_0x0107
        L_0x01f9:
            long r3 = r1.m4667getPositionF1C5BW0()
            long r6 = r1.m4668getPreviousPositionF1C5BW0()
            float r15 = r12.m583mainAxisDeltak4lQ0M(r3)
            float r16 = r12.m583mainAxisDeltak4lQ0M(r6)
            float r15 = r15 - r16
            float r3 = r12.m582crossAxisDeltak4lQ0M(r3)
            float r4 = r12.m582crossAxisDeltak4lQ0M(r6)
            float r3 = r3 - r4
            float r8 = r8 + r15
            float r7 = r9 + r3
            if (r11 == 0) goto L_0x021e
            float r3 = java.lang.Math.abs(r8)
            goto L_0x0229
        L_0x021e:
            long r3 = r12.m584offsetFromChangesdBAh8RU(r8, r7)
            float r3 = androidx.compose.ui.geometry.Offset.m2913getDistanceimpl(r3)
        L_0x0229:
            int r4 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r4 >= 0) goto L_0x0273
            androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r4 = r2
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r2.L$0 = r5
            r2.L$1 = r13
            r6 = r26
            r2.L$2 = r6
            r9 = r27
            r2.L$3 = r9
            r2.L$4 = r12
            r2.L$5 = r14
            r2.L$6 = r1
            r2.I$0 = r11
            r2.F$0 = r10
            r2.F$1 = r8
            r2.F$2 = r7
            r15 = 3
            r2.label = r15
            java.lang.Object r3 = r9.awaitPointerEvent(r3, r4)
            if (r3 != r0) goto L_0x0257
            return r0
        L_0x0257:
            r4 = r31
            r3 = r13
            r13 = r19
            r28 = r11
            r11 = r1
            r1 = r28
            r29 = r9
            r9 = r7
            r7 = r29
        L_0x0266:
            boolean r15 = r11.isConsumed()
            if (r15 == 0) goto L_0x026e
            r1 = 0
            goto L_0x02b8
        L_0x026e:
            r11 = r1
            r1 = r30
            goto L_0x0107
        L_0x0273:
            r6 = r26
            r9 = r27
            if (r11 == 0) goto L_0x0289
            float r3 = java.lang.Math.signum(r8)
            float r3 = r3 * r10
            float r8 = r8 - r3
            long r3 = r12.m584offsetFromChangesdBAh8RU(r8, r7)
            r15 = r5
            goto L_0x029f
        L_0x0289:
            long r7 = r12.m584offsetFromChangesdBAh8RU(r8, r7)
            r15 = r5
            long r4 = androidx.compose.ui.geometry.Offset.m2910divtuRUvjQ(r7, r3)
            long r3 = androidx.compose.ui.geometry.Offset.m2922timestuRUvjQ(r4, r10)
            long r16 = androidx.compose.ui.geometry.Offset.m2919minusMKHz9U(r7, r3)
            r3 = r16
        L_0x029f:
            r5 = r1
            r7 = r3
            r16 = 0
            r5.consume()
            r6.element = r7
            boolean r5 = r1.isConsumed()
            if (r5 == 0) goto L_0x0323
            r4 = r31
            r3 = r13
            r5 = r15
        L_0x02b8:
            if (r1 == 0) goto L_0x02c6
            boolean r7 = r1.isConsumed()
            if (r7 == 0) goto L_0x02c2
            goto L_0x02c6
        L_0x02c2:
            r1 = r30
            goto L_0x00d8
        L_0x02c6:
            if (r1 == 0) goto L_0x0320
            kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r3 = r2.$onDragStart
            long r7 = r1.m4667getPositionF1C5BW0()
            androidx.compose.ui.geometry.Offset r7 = androidx.compose.ui.geometry.Offset.m2904boximpl(r7)
            r3.invoke(r7)
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r3 = r2.$onDrag
            long r7 = r6.element
            androidx.compose.ui.geometry.Offset r7 = androidx.compose.ui.geometry.Offset.m2904boximpl(r7)
            r3.invoke(r1, r7)
            long r6 = r1.m4666getIdJ3iCeTQ()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$2 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$2
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r8 = r2.$onDrag
            r3.<init>(r8)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r8 = r2
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r9 = 0
            r2.L$0 = r9
            r2.L$1 = r9
            r2.L$2 = r9
            r2.L$3 = r9
            r2.L$4 = r9
            r2.L$5 = r9
            r2.L$6 = r9
            r9 = 4
            r2.label = r9
            java.lang.Object r1 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m554dragjO51t88(r5, r6, r3, r8)
            if (r1 != r0) goto L_0x030a
            return r0
        L_0x030a:
            r0 = r2
            r2 = r1
        L_0x030c:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r1 = r2.booleanValue()
            if (r1 != 0) goto L_0x031a
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r0.$onDragCancel
            r1.invoke()
            goto L_0x031f
        L_0x031a:
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r0.$onDragEnd
            r1.invoke()
        L_0x031f:
            r2 = r0
        L_0x0320:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0323:
            r5 = 0
            r8 = 0
            r1 = 0
            r4 = r31
            r7 = r9
            r3 = r13
            r5 = r15
            r13 = r19
            r9 = r1
            r1 = r30
            goto L_0x0107
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
