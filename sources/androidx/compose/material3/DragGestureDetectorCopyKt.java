package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ag\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f26\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000eH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a]\u0010\u0016\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00050\u0018HHø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a!\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a!\u0010!\u001a\u00020\u0005*\u00020\"2\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitHorizontalPointerSlopOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPointerSlopOrCancellation", "getDragDirectionValue", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPointerUp", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: DragGestureDetectorCopy.kt */
public final class DragGestureDetectorCopyKt {
    private static final float defaultTouchSlop = Dp.m5986constructorimpl((float) 18);
    private static final float mouseSlop = Dp.m5986constructorimpl((float) 0.125d);
    private static final float mouseToTouchSlopRatio = (mouseSlop / defaultTouchSlop);

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01a1 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m1891awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r23, long r24, int r26, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r27, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r28) {
        /*
            r0 = r28
            boolean r1 = r0 instanceof androidx.compose.material3.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.material3.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 r1 = (androidx.compose.material3.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.material3.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 r1 = new androidx.compose.material3.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 0
            switch(r3) {
                case 0: goto L_0x0072;
                case 1: goto L_0x0056;
                case 2: goto L_0x0030;
                default: goto L_0x0028;
            }
        L_0x0028:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0030:
            r3 = 0
            float r5 = r0.F$1
            float r6 = r0.F$0
            java.lang.Object r7 = r0.L$3
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            java.lang.Object r8 = r0.L$2
            kotlin.jvm.internal.Ref$LongRef r8 = (kotlin.jvm.internal.Ref.LongRef) r8
            java.lang.Object r9 = r0.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            java.lang.Object r10 = r0.L$0
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            kotlin.ResultKt.throwOnFailure(r1)
            r21 = r9
            r9 = r3
            r3 = r21
            r22 = r6
            r6 = r5
            r5 = r10
            r10 = r8
            r8 = r22
            goto L_0x019b
        L_0x0056:
            r3 = 0
            float r5 = r0.F$1
            float r6 = r0.F$0
            java.lang.Object r7 = r0.L$2
            kotlin.jvm.internal.Ref$LongRef r7 = (kotlin.jvm.internal.Ref.LongRef) r7
            java.lang.Object r8 = r0.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            java.lang.Object r9 = r0.L$0
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            kotlin.ResultKt.throwOnFailure(r1)
            r10 = r7
            r7 = r6
            r6 = r5
            r5 = r9
            r9 = r3
            r3 = r2
            r2 = r1
            goto L_0x00ba
        L_0x0072:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r23
            r5 = r27
            r6 = r24
            r8 = r26
            r9 = 0
            androidx.compose.ui.input.pointer.PointerEvent r10 = r3.getCurrentEvent()
            boolean r10 = m1893isPointerUpDmW0f2w(r10, r6)
            if (r10 == 0) goto L_0x008b
            goto L_0x01be
        L_0x008b:
            androidx.compose.ui.platform.ViewConfiguration r10 = r3.getViewConfiguration()
            float r8 = m1894pointerSlopE8SPZFQ(r10, r8)
            kotlin.jvm.internal.Ref$LongRef r10 = new kotlin.jvm.internal.Ref$LongRef
            r10.<init>()
            r10.element = r6
            r6 = 0
        L_0x009b:
            r0.L$0 = r5
            r0.L$1 = r3
            r0.L$2 = r10
            r0.L$3 = r4
            r0.F$0 = r8
            r0.F$1 = r6
            r7 = 1
            r0.label = r7
            java.lang.Object r7 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r3, r4, r0, r7, r4)
            if (r7 != r2) goto L_0x00b2
            return r2
        L_0x00b2:
            r21 = r2
            r2 = r1
            r1 = r7
            r7 = r8
            r8 = r3
            r3 = r21
        L_0x00ba:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            java.util.List r11 = r1.getChanges()
            r12 = 0
            r13 = 0
            r14 = 0
            int r15 = r11.size()
        L_0x00ca:
            if (r14 >= r15) goto L_0x00f7
            java.lang.Object r16 = r11.get(r14)
            r17 = r16
            r18 = 0
            r19 = r17
            androidx.compose.ui.input.pointer.PointerInputChange r19 = (androidx.compose.ui.input.pointer.PointerInputChange) r19
            r20 = 0
            r23 = r5
            long r4 = r19.m4666getIdJ3iCeTQ()
            r25 = r11
            r24 = r12
            long r11 = r10.element
            boolean r4 = androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r4, r11)
            if (r4 == 0) goto L_0x00ed
            goto L_0x0100
        L_0x00ed:
            int r14 = r14 + 1
            r4 = 0
            r5 = r23
            r12 = r24
            r11 = r25
            goto L_0x00ca
        L_0x00f7:
            r23 = r5
            r25 = r11
            r24 = r12
            r17 = 0
        L_0x0100:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r17)
            r4 = r17
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
            boolean r5 = r4.isConsumed()
            if (r5 == 0) goto L_0x0111
            r1 = r2
            r4 = 0
            goto L_0x01be
        L_0x0111:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r4)
            if (r5 == 0) goto L_0x0157
            java.util.List r1 = r1.getChanges()
            r4 = 0
            r5 = 0
            r11 = 0
            int r12 = r1.size()
        L_0x0125:
            if (r11 >= r12) goto L_0x013d
            java.lang.Object r13 = r1.get(r11)
            r14 = r13
            r15 = 0
            r16 = r14
            androidx.compose.ui.input.pointer.PointerInputChange r16 = (androidx.compose.ui.input.pointer.PointerInputChange) r16
            r17 = 0
            boolean r16 = r16.getPressed()
            if (r16 == 0) goto L_0x013a
            goto L_0x013f
        L_0x013a:
            int r11 = r11 + 1
            goto L_0x0125
        L_0x013d:
            r14 = 0
        L_0x013f:
            r1 = r14
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            if (r1 != 0) goto L_0x0148
            r1 = r2
            r4 = 0
            goto L_0x01be
        L_0x0148:
            long r4 = r1.m4666getIdJ3iCeTQ()
            r10.element = r4
            r5 = r23
            r1 = r2
            r2 = r3
            r3 = r8
            r4 = 0
            r8 = r7
            goto L_0x009b
        L_0x0157:
            long r11 = r4.m4667getPositionF1C5BW0()
            long r13 = r4.m4668getPreviousPositionF1C5BW0()
            r1 = 0
            float r1 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r11)
            r11 = r13
            r5 = 0
            float r5 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r11)
            float r1 = r1 - r5
            float r5 = r6 + r1
            float r1 = java.lang.Math.abs(r5)
            int r6 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r6 >= 0) goto L_0x01a6
            androidx.compose.ui.input.pointer.PointerEventPass r1 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r6 = r23
            r0.L$0 = r6
            r0.L$1 = r8
            r0.L$2 = r10
            r0.L$3 = r4
            r0.F$0 = r7
            r0.F$1 = r5
            r11 = 2
            r0.label = r11
            java.lang.Object r1 = r8.awaitPointerEvent(r1, r0)
            if (r1 != r3) goto L_0x0191
            return r3
        L_0x0191:
            r1 = r2
            r2 = r3
            r3 = r8
            r8 = r7
            r7 = r4
            r21 = r6
            r6 = r5
            r5 = r21
        L_0x019b:
            boolean r4 = r7.isConsumed()
            if (r4 == 0) goto L_0x01a3
            r4 = 0
            goto L_0x01be
        L_0x01a3:
            r4 = 0
            goto L_0x009b
        L_0x01a6:
            r6 = r23
            float r1 = java.lang.Math.signum(r5)
            float r1 = r1 * r7
            float r5 = r5 - r1
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            r6.invoke(r4, r1)
            boolean r1 = r4.isConsumed()
            if (r1 == 0) goto L_0x01bf
            r1 = r2
        L_0x01be:
            return r4
        L_0x01bf:
            r1 = 0
            r5 = r6
            r4 = 0
            r6 = r1
            r1 = r2
            r2 = r3
            r3 = r8
            r8 = r7
            goto L_0x009b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DragGestureDetectorCopyKt.m1891awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: awaitPointerSlopOrCancellation-pn7EDYM  reason: not valid java name */
    private static final Object m1892awaitPointerSlopOrCancellationpn7EDYM(AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dpn7EDYM, long pointerId, int pointerType, Function2<? super PointerInputChange, ? super Float, Unit> onPointerSlopReached, Function1<? super Offset, Float> getDragDirectionValue, Continuation<? super PointerInputChange> $completion) {
        Object it$iv;
        Object it$iv2;
        AwaitPointerEventScope awaitPointerEventScope = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM;
        Function1<? super Offset, Float> function1 = getDragDirectionValue;
        Continuation<? super PointerInputChange> continuation = $completion;
        PointerInputChange otherDown = null;
        PointerEventPass pointerEventPass = null;
        if (m1893isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dpn7EDYM.getCurrentEvent(), pointerId)) {
            return null;
        }
        float touchSlop = m1894pointerSlopE8SPZFQ($this$awaitPointerSlopOrCancellation_u2dpn7EDYM.getViewConfiguration(), pointerType);
        long pointer = pointerId;
        float totalPositionChange = 0.0f;
        while (true) {
            InlineMarker.mark(0);
            Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, pointerEventPass, continuation, 1, pointerEventPass);
            InlineMarker.mark(1);
            PointerEvent event = (PointerEvent) awaitPointerEvent$default;
            List $this$fastForEach$iv$iv = event.getChanges();
            int size = $this$fastForEach$iv$iv.size();
            int index$iv$iv = 0;
            while (true) {
                if (index$iv$iv >= size) {
                    it$iv = null;
                    break;
                }
                List $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                it$iv = $this$fastForEach$iv$iv2.get(index$iv$iv);
                if (PointerId.m4652equalsimpl0(((PointerInputChange) it$iv).m4666getIdJ3iCeTQ(), pointer)) {
                    break;
                }
                index$iv$iv++;
                long j = pointerId;
                $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
            }
            Intrinsics.checkNotNull(it$iv);
            PointerInputChange dragEvent = (PointerInputChange) it$iv;
            if (dragEvent.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent)) {
                List $this$fastForEach$iv$iv3 = event.getChanges();
                int index$iv$iv2 = 0;
                PointerInputChange pointerInputChange = otherDown;
                int size2 = $this$fastForEach$iv$iv3.size();
                while (true) {
                    if (index$iv$iv2 >= size2) {
                        it$iv2 = null;
                        break;
                    }
                    it$iv2 = $this$fastForEach$iv$iv3.get(index$iv$iv2);
                    if (((PointerInputChange) it$iv2).getPressed()) {
                        break;
                    }
                    index$iv$iv2++;
                }
                PointerInputChange otherDown2 = (PointerInputChange) it$iv2;
                if (otherDown2 == null) {
                    return null;
                }
                pointer = otherDown2.m4666getIdJ3iCeTQ();
                long j2 = pointerId;
                otherDown = pointerInputChange;
                pointerEventPass = null;
            } else {
                PointerInputChange pointerInputChange2 = otherDown;
                totalPositionChange += function1.invoke(Offset.m2904boximpl(dragEvent.m4667getPositionF1C5BW0())).floatValue() - function1.invoke(Offset.m2904boximpl(dragEvent.m4668getPreviousPositionF1C5BW0())).floatValue();
                if (Math.abs(totalPositionChange) < touchSlop) {
                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                    InlineMarker.mark(0);
                    awaitPointerEventScope.awaitPointerEvent(pointerEventPass2, continuation);
                    InlineMarker.mark(1);
                    if (dragEvent.isConsumed()) {
                        return null;
                    }
                    long j3 = pointerId;
                    pointerEventPass = null;
                    otherDown = pointerInputChange2;
                    function1 = getDragDirectionValue;
                } else {
                    onPointerSlopReached.invoke(dragEvent, Float.valueOf(totalPositionChange - (Math.signum(totalPositionChange) * touchSlop)));
                    if (dragEvent.isConsumed()) {
                        return dragEvent;
                    }
                    totalPositionChange = 0.0f;
                    awaitPointerEventScope = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM;
                    long j4 = pointerId;
                    function1 = getDragDirectionValue;
                    otherDown = pointerInputChange2;
                    pointerEventPass = null;
                }
            }
        }
    }

    /* renamed from: isPointerUp-DmW0f2w  reason: not valid java name */
    private static final boolean m1893isPointerUpDmW0f2w(PointerEvent $this$isPointerUp_u2dDmW0f2w, long pointerId) {
        Object it$iv;
        List $this$fastForEach$iv$iv = $this$isPointerUp_u2dDmW0f2w.getChanges();
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (true) {
            if (index$iv$iv >= size) {
                it$iv = null;
                break;
            }
            it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            if (PointerId.m4652equalsimpl0(((PointerInputChange) it$iv).m4666getIdJ3iCeTQ(), pointerId)) {
                break;
            }
            index$iv$iv++;
        }
        PointerInputChange pointerInputChange = (PointerInputChange) it$iv;
        boolean z = false;
        if (pointerInputChange != null && pointerInputChange.getPressed()) {
            z = true;
        }
        return !z;
    }

    /* renamed from: pointerSlop-E8SPZFQ  reason: not valid java name */
    public static final float m1894pointerSlopE8SPZFQ(ViewConfiguration $this$pointerSlop_u2dE8SPZFQ, int pointerType) {
        Intrinsics.checkNotNullParameter($this$pointerSlop_u2dE8SPZFQ, "$this$pointerSlop");
        if (PointerType.m4739equalsimpl0(pointerType, PointerType.Companion.m4744getMouseT8wyACA())) {
            return $this$pointerSlop_u2dE8SPZFQ.getTouchSlop() * mouseToTouchSlopRatio;
        }
        return $this$pointerSlop_u2dE8SPZFQ.getTouchSlop();
    }
}
