package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a;\u0010\u0013\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00160\u0015HHø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0019\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0012\u001ag\u0010\u001b\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d26\u0010\u001e\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a_\u0010'\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001026\u0010(\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a'\u0010+\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b,\u0010\u0012\u001a]\u0010-\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010.\u001a\u00020\u00012\b\b\u0002\u0010/\u001a\u00020\u00162\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u001fHHø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a_\u00103\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001026\u0010(\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u001100¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b4\u0010*\u001a'\u00105\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b6\u0010\u0012\u001ag\u00107\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d26\u0010(\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b8\u0010&\u001a_\u00109\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001026\u0010(\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b:\u0010*\u001a\u0001\u0010;\u001a\u00020$*\u00020<2\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u00152\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020$0?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020$0?26\u0010A\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u001100¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020$0\u001fH@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010C\u001a\u0001\u0010D\u001a\u00020$*\u00020<2\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u00152\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020$0?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020$0?26\u0010A\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u001100¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020$0\u001fH@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010C\u001a\u0001\u0010E\u001a\u00020$*\u00020<2\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u00152\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020$0?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020$0?26\u0010F\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020$0\u001fH@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010C\u001a\u0001\u0010G\u001a\u00020$*\u00020<2\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u00152\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020$0?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020$0?26\u0010H\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020$0\u001fH@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010C\u001a9\u0010I\u001a\u00020\u0016*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0\u0015H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bJ\u0010\u0018\u001ac\u0010I\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0\u00152\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u00152\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00160\u0015HHø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a9\u0010O\u001a\u00020\u0016*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0\u0015H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bP\u0010\u0018\u001a!\u0010Q\u001a\u00020\u0016*\u00020R2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a!\u0010U\u001a\u00020\u000b*\u00020V2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010X\u001a\f\u0010Y\u001a\u00020\u0001*\u00020ZH\u0000\u001a9\u0010[\u001a\u00020\u0016*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0\u0015H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\\\u0010\u0018\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0013\u0010\u0006\u001a\u00020\u0007X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\b\"\u0013\u0010\t\u001a\u00020\u0007X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\b\"\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006]"}, d2 = {"HorizontalPointerDirectionConfig", "Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "getHorizontalPointerDirectionConfig", "()Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "VerticalPointerDirectionConfig", "getVerticalPointerDirectionConfig", "defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitDragOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrUp", "hasDragged", "Lkotlin/Function1;", "", "awaitDragOrUp-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalDragOrCancellation", "awaitHorizontalDragOrCancellation-rnUCldI", "awaitHorizontalPointerSlopOrCancellation", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalTouchSlopOrCancellation", "onTouchSlopReached", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation", "awaitLongPressOrCancellation-rnUCldI", "awaitPointerSlopOrCancellation", "pointerDirectionConfig", "triggerOnMainAxisSlop", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-wtdNQyU", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILandroidx/compose/foundation/gestures/PointerDirectionConfig;ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitTouchSlopOrCancellation", "awaitTouchSlopOrCancellation-jO51t88", "awaitVerticalDragOrCancellation", "awaitVerticalDragOrCancellation-rnUCldI", "awaitVerticalPointerSlopOrCancellation", "awaitVerticalPointerSlopOrCancellation-gDDlDlE", "awaitVerticalTouchSlopOrCancellation", "awaitVerticalTouchSlopOrCancellation-jO51t88", "detectDragGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "onDrag", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "detectHorizontalDragGestures", "onHorizontalDrag", "detectVerticalDragGestures", "onVerticalDrag", "drag", "drag-jO51t88", "motionFromChange", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "horizontalDrag", "horizontalDrag-jO51t88", "isPointerUp", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "toPointerDirectionConfig", "Landroidx/compose/foundation/gestures/Orientation;", "verticalDrag", "verticalDrag-jO51t88", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragGestureDetector.kt */
public final class DragGestureDetectorKt {
    private static final PointerDirectionConfig HorizontalPointerDirectionConfig = new DragGestureDetectorKt$HorizontalPointerDirectionConfig$1();
    private static final PointerDirectionConfig VerticalPointerDirectionConfig = new DragGestureDetectorKt$VerticalPointerDirectionConfig$1();
    private static final float defaultTouchSlop = Dp.m5986constructorimpl((float) 18);
    private static final float mouseSlop = Dp.m5986constructorimpl((float) 0.125d);
    private static final float mouseToTouchSlopRatio = (mouseSlop / defaultTouchSlop);

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01f9 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: awaitTouchSlopOrCancellation-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m548awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r25, long r26, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r28, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r29) {
        /*
            r0 = r29
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 0
            switch(r3) {
                case 0: goto L_0x0083;
                case 1: goto L_0x005e;
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
            float r5 = r0.F$2
            float r6 = r0.F$1
            float r7 = r0.F$0
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            java.lang.Object r10 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r11 = r0.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            java.lang.Object r12 = r0.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r12 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r12
            java.lang.Object r13 = r0.L$0
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            kotlin.ResultKt.throwOnFailure(r1)
            r23 = r11
            r11 = r3
            r3 = r23
            r24 = r8
            r8 = r7
            r7 = r13
            r13 = r10
            r10 = r24
            goto L_0x01f3
        L_0x005e:
            r3 = 0
            float r5 = r0.F$2
            float r6 = r0.F$1
            float r7 = r0.F$0
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r0.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r0.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r11 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r11
            java.lang.Object r12 = r0.L$0
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            kotlin.ResultKt.throwOnFailure(r1)
            r13 = r9
            r9 = r11
            r11 = r8
            r8 = r7
            r7 = r12
            r12 = r3
            r3 = r2
            r2 = r1
            goto L_0x00e0
        L_0x0083:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r25
            r5 = r26
            r7 = r28
            androidx.compose.ui.input.pointer.PointerType$Companion r8 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r8 = r8.m4746getTouchT8wyACA()
            androidx.compose.foundation.gestures.PointerDirectionConfig r9 = HorizontalPointerDirectionConfig
            r10 = 0
            r11 = 0
            androidx.compose.ui.input.pointer.PointerEvent r12 = r3.getCurrentEvent()
            boolean r12 = m556isPointerUpDmW0f2w(r12, r5)
            if (r12 == 0) goto L_0x00a3
            goto L_0x023b
        L_0x00a3:
            androidx.compose.ui.platform.ViewConfiguration r12 = r3.getViewConfiguration()
            float r8 = m557pointerSlopE8SPZFQ(r12, r8)
            kotlin.jvm.internal.Ref$LongRef r12 = new kotlin.jvm.internal.Ref$LongRef
            r12.<init>()
            r12.element = r5
            r5 = 0
            r6 = 0
            r23 = r6
            r6 = r5
            r5 = r23
        L_0x00b9:
            r0.L$0 = r7
            r0.L$1 = r9
            r0.L$2 = r3
            r0.L$3 = r12
            r0.L$4 = r4
            r0.I$0 = r10
            r0.F$0 = r8
            r0.F$1 = r6
            r0.F$2 = r5
            r13 = 1
            r0.label = r13
            java.lang.Object r13 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r3, r4, r0, r13, r4)
            if (r13 != r2) goto L_0x00d6
            return r2
        L_0x00d6:
            r23 = r2
            r2 = r1
            r1 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r3
            r3 = r23
        L_0x00e0:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            java.util.List r14 = r1.getChanges()
            r15 = 0
            r16 = 0
            r17 = 0
            int r4 = r14.size()
            r25 = r2
            r2 = r17
        L_0x00f6:
            if (r2 >= r4) goto L_0x0127
            java.lang.Object r17 = r14.get(r2)
            r18 = r17
            r19 = 0
            r20 = r18
            androidx.compose.ui.input.pointer.PointerInputChange r20 = (androidx.compose.ui.input.pointer.PointerInputChange) r20
            r21 = 0
            r27 = r14
            r26 = r15
            long r14 = r20.m4666getIdJ3iCeTQ()
            r28 = r3
            r22 = r4
            long r3 = r13.element
            boolean r3 = androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r14, r3)
            if (r3 == 0) goto L_0x011b
            goto L_0x0130
        L_0x011b:
            int r2 = r2 + 1
            r15 = r26
            r14 = r27
            r3 = r28
            r4 = r22
            goto L_0x00f6
        L_0x0127:
            r28 = r3
            r27 = r14
            r26 = r15
            r18 = 0
        L_0x0130:
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            if (r18 != 0) goto L_0x0139
            r4 = 0
            r1 = r25
            goto L_0x023b
        L_0x0139:
            r2 = r18
            boolean r3 = r2.isConsumed()
            if (r3 == 0) goto L_0x0146
            r4 = 0
            r1 = r25
            goto L_0x023b
        L_0x0146:
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r2)
            if (r3 == 0) goto L_0x0194
            java.util.List r1 = r1.getChanges()
            r2 = 0
            r3 = 0
            r4 = 0
            int r14 = r1.size()
        L_0x015a:
            if (r4 >= r14) goto L_0x0175
            java.lang.Object r15 = r1.get(r4)
            r16 = r15
            r17 = 0
            r18 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            r19 = 0
            boolean r18 = r18.getPressed()
            if (r18 == 0) goto L_0x0171
            goto L_0x0178
        L_0x0171:
            int r4 = r4 + 1
            goto L_0x015a
        L_0x0175:
            r16 = 0
        L_0x0178:
            r1 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            if (r1 != 0) goto L_0x0183
            r4 = 0
            r1 = r25
            goto L_0x023b
        L_0x0183:
            long r2 = r1.m4666getIdJ3iCeTQ()
            r13.element = r2
            r1 = r25
            r2 = r28
            r3 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r4 = 0
            goto L_0x00b9
        L_0x0194:
            long r3 = r2.m4667getPositionF1C5BW0()
            long r14 = r2.m4668getPreviousPositionF1C5BW0()
            float r1 = r9.m583mainAxisDeltak4lQ0M(r3)
            float r16 = r9.m583mainAxisDeltak4lQ0M(r14)
            float r1 = r1 - r16
            float r3 = r9.m582crossAxisDeltak4lQ0M(r3)
            float r4 = r9.m582crossAxisDeltak4lQ0M(r14)
            float r3 = r3 - r4
            float r6 = r6 + r1
            float r5 = r5 + r3
            if (r11 == 0) goto L_0x01b8
            float r1 = java.lang.Math.abs(r6)
            goto L_0x01c3
        L_0x01b8:
            long r3 = r9.m584offsetFromChangesdBAh8RU(r6, r5)
            float r1 = androidx.compose.ui.geometry.Offset.m2913getDistanceimpl(r3)
        L_0x01c3:
            int r3 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x0200
            androidx.compose.ui.input.pointer.PointerEventPass r1 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r0.L$0 = r7
            r0.L$1 = r9
            r0.L$2 = r10
            r0.L$3 = r13
            r0.L$4 = r2
            r0.I$0 = r11
            r0.F$0 = r8
            r0.F$1 = r6
            r0.F$2 = r5
            r3 = 2
            r0.label = r3
            java.lang.Object r1 = r10.awaitPointerEvent(r1, r0)
            r3 = r28
            if (r1 != r3) goto L_0x01e8
            return r3
        L_0x01e8:
            r1 = r25
            r23 = r9
            r9 = r2
            r2 = r3
            r3 = r10
            r10 = r11
            r11 = r12
            r12 = r23
        L_0x01f3:
            boolean r4 = r9.isConsumed()
            if (r4 == 0) goto L_0x01fb
            r4 = 0
            goto L_0x023b
        L_0x01fb:
            r9 = r12
            r12 = r13
            r4 = 0
            goto L_0x00b9
        L_0x0200:
            r3 = r28
            if (r11 == 0) goto L_0x0213
            float r1 = java.lang.Math.signum(r6)
            float r1 = r1 * r8
            float r6 = r6 - r1
            long r4 = r9.m584offsetFromChangesdBAh8RU(r6, r5)
            goto L_0x0228
        L_0x0213:
            long r4 = r9.m584offsetFromChangesdBAh8RU(r6, r5)
            long r14 = androidx.compose.ui.geometry.Offset.m2910divtuRUvjQ(r4, r1)
            long r14 = androidx.compose.ui.geometry.Offset.m2922timestuRUvjQ(r14, r8)
            long r16 = androidx.compose.ui.geometry.Offset.m2919minusMKHz9U(r4, r14)
            r4 = r16
        L_0x0228:
            androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.m2904boximpl(r4)
            r7.invoke(r2, r1)
            boolean r1 = r2.isConsumed()
            if (r1 == 0) goto L_0x023c
            r1 = r25
            r4 = r2
        L_0x023b:
            return r4
        L_0x023c:
            r6 = 0
            r5 = 0
            r1 = r25
            r2 = r3
            r3 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r4 = 0
            goto L_0x00b9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m548awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* renamed from: drag-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m554dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, long r8, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r10, kotlin.coroutines.Continuation<? super java.lang.Boolean> r11) {
        /*
            boolean r0 = r11 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            r0.<init>(r11)
        L_0x0019:
            r11 = r0
            java.lang.Object r0 = r11.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r11.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x003b;
                case 1: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x002e:
            java.lang.Object r7 = r11.L$1
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r8 = r11.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r0)
            r9 = r0
            goto L_0x0052
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r0)
            r4 = r8
            r8 = r7
            r7 = r10
        L_0x0041:
            r11.L$0 = r8
            r11.L$1 = r7
            r11.label = r3
            java.lang.Object r9 = m539awaitDragOrCancellationrnUCldI(r8, r4, r11)
            if (r9 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r6 = r0
            r0 = r9
            r9 = r6
        L_0x0052:
            androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0
            if (r0 != 0) goto L_0x005c
            r10 = 0
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            return r10
        L_0x005c:
            r10 = r0
            boolean r0 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r10)
            if (r0 == 0) goto L_0x0068
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r0
        L_0x0068:
            r7.invoke(r10)
            long r4 = r10.m4666getIdJ3iCeTQ()
            r0 = r9
            goto L_0x0041
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m554dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ff, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r2) != false) goto L_0x0102;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: awaitDragOrCancellation-rnUCldI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m539awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, long r21, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r23) {
        /*
            r0 = r23
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 1
            r5 = 0
            switch(r3) {
                case 0: goto L_0x0043;
                case 1: goto L_0x0031;
                default: goto L_0x0029;
            }
        L_0x0029:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0031:
            r3 = 0
            java.lang.Object r6 = r0.L$1
            kotlin.jvm.internal.Ref$LongRef r6 = (kotlin.jvm.internal.Ref.LongRef) r6
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r1)
            r8 = r7
            r7 = r6
            r6 = r3
            r3 = r2
            r2 = r1
            goto L_0x0078
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r20
            r6 = r21
            androidx.compose.ui.input.pointer.PointerEvent r8 = r3.getCurrentEvent()
            boolean r8 = m556isPointerUpDmW0f2w(r8, r6)
            if (r8 == 0) goto L_0x0055
            return r5
        L_0x0055:
            r8 = 0
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            r9.element = r6
            r7 = r3
            r3 = r8
            r6 = r9
        L_0x0061:
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r8 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r7, r5, r0, r4, r5)
            if (r8 != r2) goto L_0x006f
            return r2
        L_0x006f:
            r19 = r2
            r2 = r1
            r1 = r8
            r8 = r7
            r7 = r6
            r6 = r3
            r3 = r19
        L_0x0078:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            java.util.List r9 = r1.getChanges()
            r10 = 0
            r11 = 0
            r12 = 0
            int r13 = r9.size()
        L_0x0088:
            if (r12 >= r13) goto L_0x00b2
            java.lang.Object r14 = r9.get(r12)
            r15 = r14
            r16 = 0
            r17 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            r18 = 0
            long r4 = r17.m4666getIdJ3iCeTQ()
            r20 = r2
            r21 = r3
            long r2 = r7.element
            boolean r2 = androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r4, r2)
            if (r2 == 0) goto L_0x00a8
            goto L_0x00b8
        L_0x00a8:
            int r12 = r12 + 1
            r2 = r20
            r3 = r21
            r4 = 1
            r5 = 0
            goto L_0x0088
        L_0x00b2:
            r20 = r2
            r21 = r3
            r15 = 0
        L_0x00b8:
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            if (r15 != 0) goto L_0x00be
            r2 = 0
            goto L_0x0102
        L_0x00be:
            r2 = r15
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r2)
            if (r3 == 0) goto L_0x00f9
            java.util.List r1 = r1.getChanges()
            r3 = 0
            r4 = 0
            r5 = 0
            int r9 = r1.size()
        L_0x00d3:
            if (r5 >= r9) goto L_0x00ea
            java.lang.Object r10 = r1.get(r5)
            r11 = r10
            r12 = 0
            r13 = r11
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            r14 = 0
            boolean r13 = r13.getPressed()
            if (r13 == 0) goto L_0x00e6
            goto L_0x00ec
        L_0x00e6:
            int r5 = r5 + 1
            goto L_0x00d3
        L_0x00ea:
            r11 = 0
        L_0x00ec:
            r1 = r11
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            if (r1 != 0) goto L_0x00f2
            goto L_0x0102
        L_0x00f2:
            long r3 = r1.m4666getIdJ3iCeTQ()
            r7.element = r3
            goto L_0x0115
        L_0x00f9:
            r1 = r2
            r3 = 0
            boolean r1 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r1)
            if (r1 == 0) goto L_0x0115
        L_0x0102:
            r1 = r2
            r2 = 0
            if (r1 == 0) goto L_0x010e
            boolean r3 = r1.isConsumed()
            if (r3 != 0) goto L_0x010e
            r4 = 1
            goto L_0x010f
        L_0x010e:
            r4 = r2
        L_0x010f:
            if (r4 == 0) goto L_0x0113
            r5 = r1
            goto L_0x0114
        L_0x0113:
            r5 = 0
        L_0x0114:
            return r5
        L_0x0115:
            r1 = r20
            r2 = r21
            r3 = r6
            r6 = r7
            r7 = r8
            r4 = 1
            r5 = 0
            goto L_0x0061
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m539awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        Function1 function12;
        Function0 function03;
        Function0 function04;
        if ((i & 1) != 0) {
            function12 = DragGestureDetectorKt$detectDragGestures$2.INSTANCE;
        } else {
            function12 = function1;
        }
        if ((i & 2) != 0) {
            function03 = DragGestureDetectorKt$detectDragGestures$3.INSTANCE;
        } else {
            function03 = function0;
        }
        if ((i & 4) != 0) {
            function04 = DragGestureDetectorKt$detectDragGestures$4.INSTANCE;
        } else {
            function04 = function02;
        }
        return detectDragGestures(pointerInputScope, function12, function03, function04, function2, continuation);
    }

    public static final Object detectDragGestures(PointerInputScope $this$detectDragGestures, Function1<? super Offset, Unit> onDragStart, Function0<Unit> onDragEnd, Function0<Unit> onDragCancel, Function2<? super PointerInputChange, ? super Offset, Unit> onDrag, Continuation<? super Unit> $completion) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectDragGestures, new DragGestureDetectorKt$detectDragGestures$5(onDragStart, onDrag, onDragCancel, onDragEnd, (Continuation<? super DragGestureDetectorKt$detectDragGestures$5>) null), $completion);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectDragGesturesAfterLongPress$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        Function1 function12;
        Function0 function03;
        Function0 function04;
        if ((i & 1) != 0) {
            function12 = DragGestureDetectorKt$detectDragGesturesAfterLongPress$2.INSTANCE;
        } else {
            function12 = function1;
        }
        if ((i & 2) != 0) {
            function03 = DragGestureDetectorKt$detectDragGesturesAfterLongPress$3.INSTANCE;
        } else {
            function03 = function0;
        }
        if ((i & 4) != 0) {
            function04 = DragGestureDetectorKt$detectDragGesturesAfterLongPress$4.INSTANCE;
        } else {
            function04 = function02;
        }
        return detectDragGesturesAfterLongPress(pointerInputScope, function12, function03, function04, function2, continuation);
    }

    public static final Object detectDragGesturesAfterLongPress(PointerInputScope $this$detectDragGesturesAfterLongPress, Function1<? super Offset, Unit> onDragStart, Function0<Unit> onDragEnd, Function0<Unit> onDragCancel, Function2<? super PointerInputChange, ? super Offset, Unit> onDrag, Continuation<? super Unit> $completion) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectDragGesturesAfterLongPress, new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(onDragStart, onDragEnd, onDragCancel, onDrag, (Continuation<? super DragGestureDetectorKt$detectDragGesturesAfterLongPress$5>) null), $completion);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01fa A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: awaitVerticalTouchSlopOrCancellation-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m551awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r25, long r26, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r28, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r29) {
        /*
            r0 = r29
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 0
            switch(r3) {
                case 0: goto L_0x0083;
                case 1: goto L_0x005e;
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
            float r5 = r0.F$2
            float r6 = r0.F$1
            float r7 = r0.F$0
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            java.lang.Object r10 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r11 = r0.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            java.lang.Object r12 = r0.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r12 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r12
            java.lang.Object r13 = r0.L$0
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            kotlin.ResultKt.throwOnFailure(r1)
            r23 = r11
            r11 = r3
            r3 = r23
            r24 = r8
            r8 = r7
            r7 = r13
            r13 = r10
            r10 = r24
            goto L_0x01f4
        L_0x005e:
            r3 = 0
            float r5 = r0.F$2
            float r6 = r0.F$1
            float r7 = r0.F$0
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r0.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r0.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r11 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r11
            java.lang.Object r12 = r0.L$0
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            kotlin.ResultKt.throwOnFailure(r1)
            r13 = r9
            r9 = r11
            r11 = r8
            r8 = r7
            r7 = r12
            r12 = r3
            r3 = r2
            r2 = r1
            goto L_0x00e1
        L_0x0083:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r25
            r5 = r26
            r7 = r28
            androidx.compose.ui.input.pointer.PointerType$Companion r8 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r8 = r8.m4746getTouchT8wyACA()
            androidx.compose.foundation.gestures.PointerDirectionConfig r9 = VerticalPointerDirectionConfig
            r10 = 1
            r11 = 0
            androidx.compose.ui.input.pointer.PointerEvent r12 = r3.getCurrentEvent()
            boolean r12 = m556isPointerUpDmW0f2w(r12, r5)
            if (r12 == 0) goto L_0x00a4
            goto L_0x0249
        L_0x00a4:
            androidx.compose.ui.platform.ViewConfiguration r12 = r3.getViewConfiguration()
            float r8 = m557pointerSlopE8SPZFQ(r12, r8)
            kotlin.jvm.internal.Ref$LongRef r12 = new kotlin.jvm.internal.Ref$LongRef
            r12.<init>()
            r12.element = r5
            r5 = 0
            r6 = 0
            r23 = r6
            r6 = r5
            r5 = r23
        L_0x00ba:
            r0.L$0 = r7
            r0.L$1 = r9
            r0.L$2 = r3
            r0.L$3 = r12
            r0.L$4 = r4
            r0.I$0 = r10
            r0.F$0 = r8
            r0.F$1 = r6
            r0.F$2 = r5
            r13 = 1
            r0.label = r13
            java.lang.Object r13 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r3, r4, r0, r13, r4)
            if (r13 != r2) goto L_0x00d7
            return r2
        L_0x00d7:
            r23 = r2
            r2 = r1
            r1 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r3
            r3 = r23
        L_0x00e1:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            java.util.List r14 = r1.getChanges()
            r15 = 0
            r16 = 0
            r17 = 0
            int r4 = r14.size()
            r25 = r2
            r2 = r17
        L_0x00f7:
            if (r2 >= r4) goto L_0x0128
            java.lang.Object r17 = r14.get(r2)
            r18 = r17
            r19 = 0
            r20 = r18
            androidx.compose.ui.input.pointer.PointerInputChange r20 = (androidx.compose.ui.input.pointer.PointerInputChange) r20
            r21 = 0
            r27 = r14
            r26 = r15
            long r14 = r20.m4666getIdJ3iCeTQ()
            r28 = r3
            r22 = r4
            long r3 = r13.element
            boolean r3 = androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r14, r3)
            if (r3 == 0) goto L_0x011c
            goto L_0x0131
        L_0x011c:
            int r2 = r2 + 1
            r15 = r26
            r14 = r27
            r3 = r28
            r4 = r22
            goto L_0x00f7
        L_0x0128:
            r28 = r3
            r27 = r14
            r26 = r15
            r18 = 0
        L_0x0131:
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            if (r18 != 0) goto L_0x013a
            r4 = 0
            r1 = r25
            goto L_0x0249
        L_0x013a:
            r2 = r18
            boolean r3 = r2.isConsumed()
            if (r3 == 0) goto L_0x0147
            r4 = 0
            r1 = r25
            goto L_0x0249
        L_0x0147:
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r2)
            if (r3 == 0) goto L_0x0195
            java.util.List r1 = r1.getChanges()
            r2 = 0
            r3 = 0
            r4 = 0
            int r14 = r1.size()
        L_0x015b:
            if (r4 >= r14) goto L_0x0176
            java.lang.Object r15 = r1.get(r4)
            r16 = r15
            r17 = 0
            r18 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            r19 = 0
            boolean r18 = r18.getPressed()
            if (r18 == 0) goto L_0x0172
            goto L_0x0179
        L_0x0172:
            int r4 = r4 + 1
            goto L_0x015b
        L_0x0176:
            r16 = 0
        L_0x0179:
            r1 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            if (r1 != 0) goto L_0x0184
            r4 = 0
            r1 = r25
            goto L_0x0249
        L_0x0184:
            long r2 = r1.m4666getIdJ3iCeTQ()
            r13.element = r2
            r1 = r25
            r2 = r28
            r3 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r4 = 0
            goto L_0x00ba
        L_0x0195:
            long r3 = r2.m4667getPositionF1C5BW0()
            long r14 = r2.m4668getPreviousPositionF1C5BW0()
            float r1 = r9.m583mainAxisDeltak4lQ0M(r3)
            float r16 = r9.m583mainAxisDeltak4lQ0M(r14)
            float r1 = r1 - r16
            float r3 = r9.m582crossAxisDeltak4lQ0M(r3)
            float r4 = r9.m582crossAxisDeltak4lQ0M(r14)
            float r3 = r3 - r4
            float r6 = r6 + r1
            float r5 = r5 + r3
            if (r11 == 0) goto L_0x01b9
            float r1 = java.lang.Math.abs(r6)
            goto L_0x01c4
        L_0x01b9:
            long r3 = r9.m584offsetFromChangesdBAh8RU(r6, r5)
            float r1 = androidx.compose.ui.geometry.Offset.m2913getDistanceimpl(r3)
        L_0x01c4:
            int r3 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x0201
            androidx.compose.ui.input.pointer.PointerEventPass r1 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r0.L$0 = r7
            r0.L$1 = r9
            r0.L$2 = r10
            r0.L$3 = r13
            r0.L$4 = r2
            r0.I$0 = r11
            r0.F$0 = r8
            r0.F$1 = r6
            r0.F$2 = r5
            r3 = 2
            r0.label = r3
            java.lang.Object r1 = r10.awaitPointerEvent(r1, r0)
            r3 = r28
            if (r1 != r3) goto L_0x01e9
            return r3
        L_0x01e9:
            r1 = r25
            r23 = r9
            r9 = r2
            r2 = r3
            r3 = r10
            r10 = r11
            r11 = r12
            r12 = r23
        L_0x01f4:
            boolean r4 = r9.isConsumed()
            if (r4 == 0) goto L_0x01fc
            r4 = 0
            goto L_0x0249
        L_0x01fc:
            r9 = r12
            r12 = r13
            r4 = 0
            goto L_0x00ba
        L_0x0201:
            r3 = r28
            if (r11 == 0) goto L_0x0214
            float r1 = java.lang.Math.signum(r6)
            float r1 = r1 * r8
            float r6 = r6 - r1
            long r4 = r9.m584offsetFromChangesdBAh8RU(r6, r5)
            goto L_0x0229
        L_0x0214:
            long r4 = r9.m584offsetFromChangesdBAh8RU(r6, r5)
            long r14 = androidx.compose.ui.geometry.Offset.m2910divtuRUvjQ(r4, r1)
            long r14 = androidx.compose.ui.geometry.Offset.m2922timestuRUvjQ(r14, r8)
            long r16 = androidx.compose.ui.geometry.Offset.m2919minusMKHz9U(r4, r14)
            r4 = r16
        L_0x0229:
            r1 = r2
            r14 = r4
            r6 = 0
            float r16 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r14)
            r17 = r0
            java.lang.Float r0 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r16)
            r7.invoke(r1, r0)
            boolean r0 = r2.isConsumed()
            if (r0 == 0) goto L_0x024a
            r1 = r25
            r4 = r2
            r0 = r17
        L_0x0249:
            return r4
        L_0x024a:
            r6 = 0
            r5 = 0
            r1 = r25
            r2 = r3
            r3 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r0 = r17
            r4 = 0
            goto L_0x00ba
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m551awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01f2 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m550awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r24, long r25, int r27, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r28, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r29) {
        /*
            r0 = r29
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 0
            switch(r3) {
                case 0: goto L_0x0085;
                case 1: goto L_0x005f;
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
            float r5 = r0.F$2
            float r6 = r0.F$1
            float r7 = r0.F$0
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            java.lang.Object r10 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r11 = r0.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            java.lang.Object r12 = r0.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r12 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r12
            java.lang.Object r13 = r0.L$0
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            kotlin.ResultKt.throwOnFailure(r1)
            r22 = r11
            r11 = r3
            r3 = r22
            r23 = r7
            r7 = r5
            r5 = r13
            r13 = r10
            r10 = r8
            r8 = r23
            goto L_0x01ec
        L_0x005f:
            r3 = 0
            float r5 = r0.F$2
            float r6 = r0.F$1
            float r7 = r0.F$0
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r0.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r0.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r11 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r11
            java.lang.Object r12 = r0.L$0
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            kotlin.ResultKt.throwOnFailure(r1)
            r13 = r9
            r9 = r11
            r11 = r8
            r8 = r7
            r7 = r5
            r5 = r12
            r12 = r3
            r3 = r2
            r2 = r1
            goto L_0x00da
        L_0x0085:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r24
            r5 = r28
            r6 = r25
            r8 = r27
            androidx.compose.foundation.gestures.PointerDirectionConfig r9 = VerticalPointerDirectionConfig
            r10 = 1
            r11 = 0
            androidx.compose.ui.input.pointer.PointerEvent r12 = r3.getCurrentEvent()
            boolean r12 = m556isPointerUpDmW0f2w(r12, r6)
            if (r12 == 0) goto L_0x00a2
            goto L_0x0241
        L_0x00a2:
            androidx.compose.ui.platform.ViewConfiguration r12 = r3.getViewConfiguration()
            float r8 = m557pointerSlopE8SPZFQ(r12, r8)
            kotlin.jvm.internal.Ref$LongRef r12 = new kotlin.jvm.internal.Ref$LongRef
            r12.<init>()
            r12.element = r6
            r6 = 0
            r7 = 0
        L_0x00b3:
            r0.L$0 = r5
            r0.L$1 = r9
            r0.L$2 = r3
            r0.L$3 = r12
            r0.L$4 = r4
            r0.I$0 = r10
            r0.F$0 = r8
            r0.F$1 = r6
            r0.F$2 = r7
            r13 = 1
            r0.label = r13
            java.lang.Object r13 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r3, r4, r0, r13, r4)
            if (r13 != r2) goto L_0x00d0
            return r2
        L_0x00d0:
            r22 = r2
            r2 = r1
            r1 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r3
            r3 = r22
        L_0x00da:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            java.util.List r14 = r1.getChanges()
            r15 = 0
            r16 = 0
            r17 = 0
            int r4 = r14.size()
            r24 = r2
            r2 = r17
        L_0x00f0:
            if (r2 >= r4) goto L_0x0121
            java.lang.Object r17 = r14.get(r2)
            r18 = r17
            r19 = 0
            r20 = r18
            androidx.compose.ui.input.pointer.PointerInputChange r20 = (androidx.compose.ui.input.pointer.PointerInputChange) r20
            r21 = 0
            r26 = r14
            r25 = r15
            long r14 = r20.m4666getIdJ3iCeTQ()
            r27 = r3
            r28 = r4
            long r3 = r13.element
            boolean r3 = androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r14, r3)
            if (r3 == 0) goto L_0x0115
            goto L_0x012a
        L_0x0115:
            int r2 = r2 + 1
            r15 = r25
            r14 = r26
            r3 = r27
            r4 = r28
            goto L_0x00f0
        L_0x0121:
            r27 = r3
            r26 = r14
            r25 = r15
            r18 = 0
        L_0x012a:
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            if (r18 != 0) goto L_0x0133
            r4 = 0
            r1 = r24
            goto L_0x0241
        L_0x0133:
            r2 = r18
            boolean r3 = r2.isConsumed()
            if (r3 == 0) goto L_0x0140
            r4 = 0
            r1 = r24
            goto L_0x0241
        L_0x0140:
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r2)
            if (r3 == 0) goto L_0x018e
            java.util.List r1 = r1.getChanges()
            r2 = 0
            r3 = 0
            r4 = 0
            int r14 = r1.size()
        L_0x0154:
            if (r4 >= r14) goto L_0x016f
            java.lang.Object r15 = r1.get(r4)
            r16 = r15
            r17 = 0
            r18 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            r19 = 0
            boolean r18 = r18.getPressed()
            if (r18 == 0) goto L_0x016b
            goto L_0x0172
        L_0x016b:
            int r4 = r4 + 1
            goto L_0x0154
        L_0x016f:
            r16 = 0
        L_0x0172:
            r1 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            if (r1 != 0) goto L_0x017d
            r4 = 0
            r1 = r24
            goto L_0x0241
        L_0x017d:
            long r2 = r1.m4666getIdJ3iCeTQ()
            r13.element = r2
            r1 = r24
            r2 = r27
            r3 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r4 = 0
            goto L_0x00b3
        L_0x018e:
            long r3 = r2.m4667getPositionF1C5BW0()
            long r14 = r2.m4668getPreviousPositionF1C5BW0()
            float r1 = r9.m583mainAxisDeltak4lQ0M(r3)
            float r16 = r9.m583mainAxisDeltak4lQ0M(r14)
            float r1 = r1 - r16
            float r3 = r9.m582crossAxisDeltak4lQ0M(r3)
            float r4 = r9.m582crossAxisDeltak4lQ0M(r14)
            float r3 = r3 - r4
            float r6 = r6 + r1
            float r1 = r7 + r3
            if (r11 == 0) goto L_0x01b3
            float r3 = java.lang.Math.abs(r6)
            goto L_0x01be
        L_0x01b3:
            long r3 = r9.m584offsetFromChangesdBAh8RU(r6, r1)
            float r3 = androidx.compose.ui.geometry.Offset.m2913getDistanceimpl(r3)
        L_0x01be:
            int r4 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x01f9
            androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r0.L$0 = r5
            r0.L$1 = r9
            r0.L$2 = r10
            r0.L$3 = r13
            r0.L$4 = r2
            r0.I$0 = r11
            r0.F$0 = r8
            r0.F$1 = r6
            r0.F$2 = r1
            r4 = 2
            r0.label = r4
            java.lang.Object r3 = r10.awaitPointerEvent(r3, r0)
            r4 = r27
            if (r3 != r4) goto L_0x01e3
            return r4
        L_0x01e3:
            r7 = r1
            r3 = r10
            r10 = r11
            r11 = r12
            r1 = r24
            r12 = r9
            r9 = r2
            r2 = r4
        L_0x01ec:
            boolean r4 = r9.isConsumed()
            if (r4 == 0) goto L_0x01f4
            r4 = 0
            goto L_0x0241
        L_0x01f4:
            r9 = r12
            r12 = r13
            r4 = 0
            goto L_0x00b3
        L_0x01f9:
            r4 = r27
            if (r11 == 0) goto L_0x020c
            float r3 = java.lang.Math.signum(r6)
            float r3 = r3 * r8
            float r6 = r6 - r3
            long r6 = r9.m584offsetFromChangesdBAh8RU(r6, r1)
            goto L_0x0221
        L_0x020c:
            long r6 = r9.m584offsetFromChangesdBAh8RU(r6, r1)
            long r14 = androidx.compose.ui.geometry.Offset.m2910divtuRUvjQ(r6, r3)
            long r14 = androidx.compose.ui.geometry.Offset.m2922timestuRUvjQ(r14, r8)
            long r16 = androidx.compose.ui.geometry.Offset.m2919minusMKHz9U(r6, r14)
            r6 = r16
        L_0x0221:
            r1 = r2
            r14 = r6
            r3 = 0
            float r16 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r14)
            r17 = r0
            java.lang.Float r0 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r16)
            r5.invoke(r1, r0)
            boolean r0 = r2.isConsumed()
            if (r0 == 0) goto L_0x0242
            r1 = r24
            r4 = r2
            r0 = r17
        L_0x0241:
            return r4
        L_0x0242:
            r0 = 0
            r7 = 0
            r1 = r24
            r6 = r0
            r2 = r4
            r3 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r0 = r17
            r4 = 0
            goto L_0x00b3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m550awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x013e, code lost:
        if ((!(androidx.compose.ui.geometry.Offset.m2916getYimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r2)) == 0.0f)) != false) goto L_0x0141;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: verticalDrag-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m558verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r22, long r23, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r25, kotlin.coroutines.Continuation<? super java.lang.Boolean> r26) {
        /*
            r0 = r26
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r5 = 1
            r6 = 0
            switch(r3) {
                case 0: goto L_0x004f;
                case 1: goto L_0x0031;
                default: goto L_0x0029;
            }
        L_0x0029:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0031:
            r3 = 0
            r7 = 0
            java.lang.Object r8 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r8 = (kotlin.jvm.internal.Ref.LongRef) r8
            java.lang.Object r9 = r0.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            java.lang.Object r10 = r0.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r0.L$0
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            kotlin.ResultKt.throwOnFailure(r1)
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r3
            r3 = r2
            r2 = r1
            goto L_0x0099
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r22
            r7 = r23
            r9 = r25
            r10 = 0
            androidx.compose.ui.input.pointer.PointerEvent r11 = r3.getCurrentEvent()
            boolean r11 = m556isPointerUpDmW0f2w(r11, r7)
            if (r11 == 0) goto L_0x0067
            r3 = r5
            goto L_0x015d
        L_0x0067:
            r11 = r7
        L_0x0068:
            r7 = r3
            r8 = 0
            kotlin.jvm.internal.Ref$LongRef r13 = new kotlin.jvm.internal.Ref$LongRef
            r13.<init>()
            r13.element = r11
            r11 = r9
            r9 = r7
            r7 = r8
            r8 = r13
            r21 = r10
            r10 = r3
            r3 = r21
        L_0x007b:
            r0.L$0 = r11
            r0.L$1 = r10
            r0.L$2 = r9
            r0.L$3 = r8
            r0.label = r5
            java.lang.Object r12 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r9, r6, r0, r5, r6)
            if (r12 != r2) goto L_0x008d
            return r2
        L_0x008d:
            r21 = r2
            r2 = r1
            r1 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r3
            r3 = r21
        L_0x0099:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            java.util.List r13 = r1.getChanges()
            r14 = 0
            r15 = 0
            r16 = 0
            int r4 = r13.size()
            r6 = r16
        L_0x00ac:
            if (r6 >= r4) goto L_0x00d8
            java.lang.Object r16 = r13.get(r6)
            r17 = r16
            r18 = 0
            r19 = r17
            androidx.compose.ui.input.pointer.PointerInputChange r19 = (androidx.compose.ui.input.pointer.PointerInputChange) r19
            r20 = 0
            r22 = r6
            long r5 = r19.m4666getIdJ3iCeTQ()
            r23 = r2
            r24 = r3
            long r2 = r9.element
            boolean r2 = androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r5, r2)
            if (r2 == 0) goto L_0x00cf
            goto L_0x00e1
        L_0x00cf:
            int r6 = r22 + 1
            r2 = r23
            r3 = r24
            r5 = 1
            goto L_0x00ac
        L_0x00d8:
            r23 = r2
            r24 = r3
            r22 = r6
            r17 = 0
        L_0x00e1:
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            if (r17 != 0) goto L_0x00e8
            r2 = 0
            r3 = 1
            goto L_0x0141
        L_0x00e8:
            r2 = r17
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r2)
            if (r3 == 0) goto L_0x0128
            java.util.List r1 = r1.getChanges()
            r3 = 0
            r4 = 0
            r5 = 0
            int r6 = r1.size()
        L_0x00fe:
            if (r5 >= r6) goto L_0x0117
            java.lang.Object r13 = r1.get(r5)
            r14 = r13
            r15 = 0
            r16 = r14
            androidx.compose.ui.input.pointer.PointerInputChange r16 = (androidx.compose.ui.input.pointer.PointerInputChange) r16
            r17 = 0
            boolean r16 = r16.getPressed()
            if (r16 == 0) goto L_0x0113
            goto L_0x0119
        L_0x0113:
            int r5 = r5 + 1
            goto L_0x00fe
        L_0x0117:
            r14 = 0
        L_0x0119:
            r1 = r14
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            if (r1 != 0) goto L_0x0120
            r3 = 1
            goto L_0x0141
        L_0x0120:
            long r2 = r1.m4666getIdJ3iCeTQ()
            r9.element = r2
            r3 = 1
            goto L_0x017a
        L_0x0128:
            r1 = r2
            r3 = 0
            r4 = 0
            long r5 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r1)
            float r1 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r5)
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x013b
            r1 = 1
            goto L_0x013c
        L_0x013b:
            r1 = 0
        L_0x013c:
            r3 = 1
            r1 = r1 ^ r3
            if (r1 == 0) goto L_0x017a
        L_0x0141:
            if (r2 != 0) goto L_0x0147
            r1 = r23
            r6 = 0
            goto L_0x015d
        L_0x0147:
            r1 = r2
            r4 = 0
            boolean r2 = r2.isConsumed()
            if (r2 == 0) goto L_0x0154
            r1 = r23
            r6 = 0
            goto L_0x015d
        L_0x0154:
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r1)
            if (r2 == 0) goto L_0x0167
            r6 = r1
            r1 = r23
        L_0x015d:
            if (r6 == 0) goto L_0x0161
            r4 = r3
            goto L_0x0162
        L_0x0161:
            r4 = 0
        L_0x0162:
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r2
        L_0x0167:
            r12.invoke(r1)
            long r1 = r1.m4666getIdJ3iCeTQ()
            r5 = r3
            r10 = r7
            r3 = r11
            r9 = r12
            r6 = 0
            r11 = r1
            r1 = r23
            r2 = r24
            goto L_0x0068
        L_0x017a:
            r1 = r23
            r2 = r24
            r5 = r3
            r3 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r6 = 0
            goto L_0x007b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m558verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0112, code lost:
        if ((!(androidx.compose.ui.geometry.Offset.m2916getYimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r3)) == 0.0f)) != false) goto L_0x0115;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: awaitVerticalDragOrCancellation-rnUCldI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m549awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, long r21, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r23) {
        /*
            r0 = r23
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 1
            r5 = 0
            switch(r3) {
                case 0: goto L_0x0043;
                case 1: goto L_0x0031;
                default: goto L_0x0029;
            }
        L_0x0029:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0031:
            r3 = 0
            java.lang.Object r6 = r0.L$1
            kotlin.jvm.internal.Ref$LongRef r6 = (kotlin.jvm.internal.Ref.LongRef) r6
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r1)
            r8 = r7
            r7 = r6
            r6 = r3
            r3 = r2
            r2 = r1
            goto L_0x0078
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r20
            r6 = r21
            androidx.compose.ui.input.pointer.PointerEvent r8 = r3.getCurrentEvent()
            boolean r8 = m556isPointerUpDmW0f2w(r8, r6)
            if (r8 == 0) goto L_0x0055
            return r5
        L_0x0055:
            r8 = 0
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            r9.element = r6
            r7 = r3
            r3 = r8
            r6 = r9
        L_0x0061:
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r8 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r7, r5, r0, r4, r5)
            if (r8 != r2) goto L_0x006f
            return r2
        L_0x006f:
            r19 = r2
            r2 = r1
            r1 = r8
            r8 = r7
            r7 = r6
            r6 = r3
            r3 = r19
        L_0x0078:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            java.util.List r9 = r1.getChanges()
            r10 = 0
            r11 = 0
            r12 = 0
            int r13 = r9.size()
        L_0x0088:
            if (r12 >= r13) goto L_0x00b5
            java.lang.Object r14 = r9.get(r12)
            r15 = r14
            r16 = 0
            r17 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            r18 = 0
            r20 = r6
            long r5 = r17.m4666getIdJ3iCeTQ()
            r21 = r2
            r22 = r3
            long r2 = r7.element
            boolean r2 = androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r5, r2)
            if (r2 == 0) goto L_0x00aa
            goto L_0x00bd
        L_0x00aa:
            int r12 = r12 + 1
            r6 = r20
            r2 = r21
            r3 = r22
            r5 = 0
            goto L_0x0088
        L_0x00b5:
            r21 = r2
            r22 = r3
            r20 = r6
            r15 = 0
        L_0x00bd:
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            r2 = 0
            if (r15 != 0) goto L_0x00c4
            r3 = 0
            goto L_0x0115
        L_0x00c4:
            r3 = r15
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r3)
            if (r5 == 0) goto L_0x00ff
            java.util.List r1 = r1.getChanges()
            r5 = 0
            r6 = 0
            r9 = 0
            int r10 = r1.size()
        L_0x00d9:
            if (r9 >= r10) goto L_0x00f0
            java.lang.Object r11 = r1.get(r9)
            r12 = r11
            r13 = 0
            r14 = r12
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            r15 = 0
            boolean r14 = r14.getPressed()
            if (r14 == 0) goto L_0x00ec
            goto L_0x00f2
        L_0x00ec:
            int r9 = r9 + 1
            goto L_0x00d9
        L_0x00f0:
            r12 = 0
        L_0x00f2:
            r1 = r12
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            if (r1 != 0) goto L_0x00f8
            goto L_0x0115
        L_0x00f8:
            long r2 = r1.m4666getIdJ3iCeTQ()
            r7.element = r2
            goto L_0x0126
        L_0x00ff:
            r1 = r3
            r5 = 0
            long r9 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r1)
            float r6 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r9)
            r9 = 0
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 != 0) goto L_0x0110
            r1 = r4
            goto L_0x0111
        L_0x0110:
            r1 = r2
        L_0x0111:
            r1 = r1 ^ r4
            if (r1 == 0) goto L_0x0126
        L_0x0115:
            r1 = r3
            if (r1 == 0) goto L_0x011f
            boolean r3 = r1.isConsumed()
            if (r3 != 0) goto L_0x011f
            goto L_0x0120
        L_0x011f:
            r4 = r2
        L_0x0120:
            if (r4 == 0) goto L_0x0124
            r5 = r1
            goto L_0x0125
        L_0x0124:
            r5 = 0
        L_0x0125:
            return r5
        L_0x0126:
            r3 = r20
            r1 = r21
            r2 = r22
            r6 = r7
            r7 = r8
            r5 = 0
            goto L_0x0061
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m549awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectVerticalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        Function1 function12;
        Function0 function03;
        Function0 function04;
        if ((i & 1) != 0) {
            function12 = DragGestureDetectorKt$detectVerticalDragGestures$2.INSTANCE;
        } else {
            function12 = function1;
        }
        if ((i & 2) != 0) {
            function03 = DragGestureDetectorKt$detectVerticalDragGestures$3.INSTANCE;
        } else {
            function03 = function0;
        }
        if ((i & 4) != 0) {
            function04 = DragGestureDetectorKt$detectVerticalDragGestures$4.INSTANCE;
        } else {
            function04 = function02;
        }
        return detectVerticalDragGestures(pointerInputScope, function12, function03, function04, function2, continuation);
    }

    public static final Object detectVerticalDragGestures(PointerInputScope $this$detectVerticalDragGestures, Function1<? super Offset, Unit> onDragStart, Function0<Unit> onDragEnd, Function0<Unit> onDragCancel, Function2<? super PointerInputChange, ? super Float, Unit> onVerticalDrag, Continuation<? super Unit> $completion) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectVerticalDragGestures, new DragGestureDetectorKt$detectVerticalDragGestures$5(onDragStart, onVerticalDrag, onDragEnd, onDragCancel, (Continuation<? super DragGestureDetectorKt$detectVerticalDragGestures$5>) null), $completion);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01fa A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m543awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r25, long r26, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r28, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r29) {
        /*
            r0 = r29
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 0
            switch(r3) {
                case 0: goto L_0x0083;
                case 1: goto L_0x005e;
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
            float r5 = r0.F$2
            float r6 = r0.F$1
            float r7 = r0.F$0
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            java.lang.Object r10 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r11 = r0.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            java.lang.Object r12 = r0.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r12 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r12
            java.lang.Object r13 = r0.L$0
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            kotlin.ResultKt.throwOnFailure(r1)
            r23 = r11
            r11 = r3
            r3 = r23
            r24 = r8
            r8 = r7
            r7 = r13
            r13 = r10
            r10 = r24
            goto L_0x01f4
        L_0x005e:
            r3 = 0
            float r5 = r0.F$2
            float r6 = r0.F$1
            float r7 = r0.F$0
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r0.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r0.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r11 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r11
            java.lang.Object r12 = r0.L$0
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            kotlin.ResultKt.throwOnFailure(r1)
            r13 = r9
            r9 = r11
            r11 = r8
            r8 = r7
            r7 = r12
            r12 = r3
            r3 = r2
            r2 = r1
            goto L_0x00e1
        L_0x0083:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r25
            r5 = r26
            r7 = r28
            androidx.compose.ui.input.pointer.PointerType$Companion r8 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r8 = r8.m4746getTouchT8wyACA()
            androidx.compose.foundation.gestures.PointerDirectionConfig r9 = HorizontalPointerDirectionConfig
            r10 = 1
            r11 = 0
            androidx.compose.ui.input.pointer.PointerEvent r12 = r3.getCurrentEvent()
            boolean r12 = m556isPointerUpDmW0f2w(r12, r5)
            if (r12 == 0) goto L_0x00a4
            goto L_0x0249
        L_0x00a4:
            androidx.compose.ui.platform.ViewConfiguration r12 = r3.getViewConfiguration()
            float r8 = m557pointerSlopE8SPZFQ(r12, r8)
            kotlin.jvm.internal.Ref$LongRef r12 = new kotlin.jvm.internal.Ref$LongRef
            r12.<init>()
            r12.element = r5
            r5 = 0
            r6 = 0
            r23 = r6
            r6 = r5
            r5 = r23
        L_0x00ba:
            r0.L$0 = r7
            r0.L$1 = r9
            r0.L$2 = r3
            r0.L$3 = r12
            r0.L$4 = r4
            r0.I$0 = r10
            r0.F$0 = r8
            r0.F$1 = r6
            r0.F$2 = r5
            r13 = 1
            r0.label = r13
            java.lang.Object r13 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r3, r4, r0, r13, r4)
            if (r13 != r2) goto L_0x00d7
            return r2
        L_0x00d7:
            r23 = r2
            r2 = r1
            r1 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r3
            r3 = r23
        L_0x00e1:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            java.util.List r14 = r1.getChanges()
            r15 = 0
            r16 = 0
            r17 = 0
            int r4 = r14.size()
            r25 = r2
            r2 = r17
        L_0x00f7:
            if (r2 >= r4) goto L_0x0128
            java.lang.Object r17 = r14.get(r2)
            r18 = r17
            r19 = 0
            r20 = r18
            androidx.compose.ui.input.pointer.PointerInputChange r20 = (androidx.compose.ui.input.pointer.PointerInputChange) r20
            r21 = 0
            r27 = r14
            r26 = r15
            long r14 = r20.m4666getIdJ3iCeTQ()
            r28 = r3
            r22 = r4
            long r3 = r13.element
            boolean r3 = androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r14, r3)
            if (r3 == 0) goto L_0x011c
            goto L_0x0131
        L_0x011c:
            int r2 = r2 + 1
            r15 = r26
            r14 = r27
            r3 = r28
            r4 = r22
            goto L_0x00f7
        L_0x0128:
            r28 = r3
            r27 = r14
            r26 = r15
            r18 = 0
        L_0x0131:
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            if (r18 != 0) goto L_0x013a
            r4 = 0
            r1 = r25
            goto L_0x0249
        L_0x013a:
            r2 = r18
            boolean r3 = r2.isConsumed()
            if (r3 == 0) goto L_0x0147
            r4 = 0
            r1 = r25
            goto L_0x0249
        L_0x0147:
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r2)
            if (r3 == 0) goto L_0x0195
            java.util.List r1 = r1.getChanges()
            r2 = 0
            r3 = 0
            r4 = 0
            int r14 = r1.size()
        L_0x015b:
            if (r4 >= r14) goto L_0x0176
            java.lang.Object r15 = r1.get(r4)
            r16 = r15
            r17 = 0
            r18 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            r19 = 0
            boolean r18 = r18.getPressed()
            if (r18 == 0) goto L_0x0172
            goto L_0x0179
        L_0x0172:
            int r4 = r4 + 1
            goto L_0x015b
        L_0x0176:
            r16 = 0
        L_0x0179:
            r1 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            if (r1 != 0) goto L_0x0184
            r4 = 0
            r1 = r25
            goto L_0x0249
        L_0x0184:
            long r2 = r1.m4666getIdJ3iCeTQ()
            r13.element = r2
            r1 = r25
            r2 = r28
            r3 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r4 = 0
            goto L_0x00ba
        L_0x0195:
            long r3 = r2.m4667getPositionF1C5BW0()
            long r14 = r2.m4668getPreviousPositionF1C5BW0()
            float r1 = r9.m583mainAxisDeltak4lQ0M(r3)
            float r16 = r9.m583mainAxisDeltak4lQ0M(r14)
            float r1 = r1 - r16
            float r3 = r9.m582crossAxisDeltak4lQ0M(r3)
            float r4 = r9.m582crossAxisDeltak4lQ0M(r14)
            float r3 = r3 - r4
            float r6 = r6 + r1
            float r5 = r5 + r3
            if (r11 == 0) goto L_0x01b9
            float r1 = java.lang.Math.abs(r6)
            goto L_0x01c4
        L_0x01b9:
            long r3 = r9.m584offsetFromChangesdBAh8RU(r6, r5)
            float r1 = androidx.compose.ui.geometry.Offset.m2913getDistanceimpl(r3)
        L_0x01c4:
            int r3 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x0201
            androidx.compose.ui.input.pointer.PointerEventPass r1 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r0.L$0 = r7
            r0.L$1 = r9
            r0.L$2 = r10
            r0.L$3 = r13
            r0.L$4 = r2
            r0.I$0 = r11
            r0.F$0 = r8
            r0.F$1 = r6
            r0.F$2 = r5
            r3 = 2
            r0.label = r3
            java.lang.Object r1 = r10.awaitPointerEvent(r1, r0)
            r3 = r28
            if (r1 != r3) goto L_0x01e9
            return r3
        L_0x01e9:
            r1 = r25
            r23 = r9
            r9 = r2
            r2 = r3
            r3 = r10
            r10 = r11
            r11 = r12
            r12 = r23
        L_0x01f4:
            boolean r4 = r9.isConsumed()
            if (r4 == 0) goto L_0x01fc
            r4 = 0
            goto L_0x0249
        L_0x01fc:
            r9 = r12
            r12 = r13
            r4 = 0
            goto L_0x00ba
        L_0x0201:
            r3 = r28
            if (r11 == 0) goto L_0x0214
            float r1 = java.lang.Math.signum(r6)
            float r1 = r1 * r8
            float r6 = r6 - r1
            long r4 = r9.m584offsetFromChangesdBAh8RU(r6, r5)
            goto L_0x0229
        L_0x0214:
            long r4 = r9.m584offsetFromChangesdBAh8RU(r6, r5)
            long r14 = androidx.compose.ui.geometry.Offset.m2910divtuRUvjQ(r4, r1)
            long r14 = androidx.compose.ui.geometry.Offset.m2922timestuRUvjQ(r14, r8)
            long r16 = androidx.compose.ui.geometry.Offset.m2919minusMKHz9U(r4, r14)
            r4 = r16
        L_0x0229:
            r1 = r2
            r14 = r4
            r6 = 0
            float r16 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r14)
            r17 = r0
            java.lang.Float r0 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r16)
            r7.invoke(r1, r0)
            boolean r0 = r2.isConsumed()
            if (r0 == 0) goto L_0x024a
            r1 = r25
            r4 = r2
            r0 = r17
        L_0x0249:
            return r4
        L_0x024a:
            r6 = 0
            r5 = 0
            r1 = r25
            r2 = r3
            r3 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r0 = r17
            r4 = 0
            goto L_0x00ba
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m543awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01f2 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m542awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r24, long r25, int r27, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r28, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r29) {
        /*
            r0 = r29
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 0
            switch(r3) {
                case 0: goto L_0x0085;
                case 1: goto L_0x005f;
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
            float r5 = r0.F$2
            float r6 = r0.F$1
            float r7 = r0.F$0
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            java.lang.Object r10 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r11 = r0.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            java.lang.Object r12 = r0.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r12 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r12
            java.lang.Object r13 = r0.L$0
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            kotlin.ResultKt.throwOnFailure(r1)
            r22 = r11
            r11 = r3
            r3 = r22
            r23 = r7
            r7 = r5
            r5 = r13
            r13 = r10
            r10 = r8
            r8 = r23
            goto L_0x01ec
        L_0x005f:
            r3 = 0
            float r5 = r0.F$2
            float r6 = r0.F$1
            float r7 = r0.F$0
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r0.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r0.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r11 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r11
            java.lang.Object r12 = r0.L$0
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            kotlin.ResultKt.throwOnFailure(r1)
            r13 = r9
            r9 = r11
            r11 = r8
            r8 = r7
            r7 = r5
            r5 = r12
            r12 = r3
            r3 = r2
            r2 = r1
            goto L_0x00da
        L_0x0085:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r24
            r5 = r28
            r6 = r25
            r8 = r27
            androidx.compose.foundation.gestures.PointerDirectionConfig r9 = HorizontalPointerDirectionConfig
            r10 = 1
            r11 = 0
            androidx.compose.ui.input.pointer.PointerEvent r12 = r3.getCurrentEvent()
            boolean r12 = m556isPointerUpDmW0f2w(r12, r6)
            if (r12 == 0) goto L_0x00a2
            goto L_0x0241
        L_0x00a2:
            androidx.compose.ui.platform.ViewConfiguration r12 = r3.getViewConfiguration()
            float r8 = m557pointerSlopE8SPZFQ(r12, r8)
            kotlin.jvm.internal.Ref$LongRef r12 = new kotlin.jvm.internal.Ref$LongRef
            r12.<init>()
            r12.element = r6
            r6 = 0
            r7 = 0
        L_0x00b3:
            r0.L$0 = r5
            r0.L$1 = r9
            r0.L$2 = r3
            r0.L$3 = r12
            r0.L$4 = r4
            r0.I$0 = r10
            r0.F$0 = r8
            r0.F$1 = r6
            r0.F$2 = r7
            r13 = 1
            r0.label = r13
            java.lang.Object r13 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r3, r4, r0, r13, r4)
            if (r13 != r2) goto L_0x00d0
            return r2
        L_0x00d0:
            r22 = r2
            r2 = r1
            r1 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r3
            r3 = r22
        L_0x00da:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            java.util.List r14 = r1.getChanges()
            r15 = 0
            r16 = 0
            r17 = 0
            int r4 = r14.size()
            r24 = r2
            r2 = r17
        L_0x00f0:
            if (r2 >= r4) goto L_0x0121
            java.lang.Object r17 = r14.get(r2)
            r18 = r17
            r19 = 0
            r20 = r18
            androidx.compose.ui.input.pointer.PointerInputChange r20 = (androidx.compose.ui.input.pointer.PointerInputChange) r20
            r21 = 0
            r26 = r14
            r25 = r15
            long r14 = r20.m4666getIdJ3iCeTQ()
            r27 = r3
            r28 = r4
            long r3 = r13.element
            boolean r3 = androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r14, r3)
            if (r3 == 0) goto L_0x0115
            goto L_0x012a
        L_0x0115:
            int r2 = r2 + 1
            r15 = r25
            r14 = r26
            r3 = r27
            r4 = r28
            goto L_0x00f0
        L_0x0121:
            r27 = r3
            r26 = r14
            r25 = r15
            r18 = 0
        L_0x012a:
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            if (r18 != 0) goto L_0x0133
            r4 = 0
            r1 = r24
            goto L_0x0241
        L_0x0133:
            r2 = r18
            boolean r3 = r2.isConsumed()
            if (r3 == 0) goto L_0x0140
            r4 = 0
            r1 = r24
            goto L_0x0241
        L_0x0140:
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r2)
            if (r3 == 0) goto L_0x018e
            java.util.List r1 = r1.getChanges()
            r2 = 0
            r3 = 0
            r4 = 0
            int r14 = r1.size()
        L_0x0154:
            if (r4 >= r14) goto L_0x016f
            java.lang.Object r15 = r1.get(r4)
            r16 = r15
            r17 = 0
            r18 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            r19 = 0
            boolean r18 = r18.getPressed()
            if (r18 == 0) goto L_0x016b
            goto L_0x0172
        L_0x016b:
            int r4 = r4 + 1
            goto L_0x0154
        L_0x016f:
            r16 = 0
        L_0x0172:
            r1 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            if (r1 != 0) goto L_0x017d
            r4 = 0
            r1 = r24
            goto L_0x0241
        L_0x017d:
            long r2 = r1.m4666getIdJ3iCeTQ()
            r13.element = r2
            r1 = r24
            r2 = r27
            r3 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r4 = 0
            goto L_0x00b3
        L_0x018e:
            long r3 = r2.m4667getPositionF1C5BW0()
            long r14 = r2.m4668getPreviousPositionF1C5BW0()
            float r1 = r9.m583mainAxisDeltak4lQ0M(r3)
            float r16 = r9.m583mainAxisDeltak4lQ0M(r14)
            float r1 = r1 - r16
            float r3 = r9.m582crossAxisDeltak4lQ0M(r3)
            float r4 = r9.m582crossAxisDeltak4lQ0M(r14)
            float r3 = r3 - r4
            float r6 = r6 + r1
            float r1 = r7 + r3
            if (r11 == 0) goto L_0x01b3
            float r3 = java.lang.Math.abs(r6)
            goto L_0x01be
        L_0x01b3:
            long r3 = r9.m584offsetFromChangesdBAh8RU(r6, r1)
            float r3 = androidx.compose.ui.geometry.Offset.m2913getDistanceimpl(r3)
        L_0x01be:
            int r4 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x01f9
            androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r0.L$0 = r5
            r0.L$1 = r9
            r0.L$2 = r10
            r0.L$3 = r13
            r0.L$4 = r2
            r0.I$0 = r11
            r0.F$0 = r8
            r0.F$1 = r6
            r0.F$2 = r1
            r4 = 2
            r0.label = r4
            java.lang.Object r3 = r10.awaitPointerEvent(r3, r0)
            r4 = r27
            if (r3 != r4) goto L_0x01e3
            return r4
        L_0x01e3:
            r7 = r1
            r3 = r10
            r10 = r11
            r11 = r12
            r1 = r24
            r12 = r9
            r9 = r2
            r2 = r4
        L_0x01ec:
            boolean r4 = r9.isConsumed()
            if (r4 == 0) goto L_0x01f4
            r4 = 0
            goto L_0x0241
        L_0x01f4:
            r9 = r12
            r12 = r13
            r4 = 0
            goto L_0x00b3
        L_0x01f9:
            r4 = r27
            if (r11 == 0) goto L_0x020c
            float r3 = java.lang.Math.signum(r6)
            float r3 = r3 * r8
            float r6 = r6 - r3
            long r6 = r9.m584offsetFromChangesdBAh8RU(r6, r1)
            goto L_0x0221
        L_0x020c:
            long r6 = r9.m584offsetFromChangesdBAh8RU(r6, r1)
            long r14 = androidx.compose.ui.geometry.Offset.m2910divtuRUvjQ(r6, r3)
            long r14 = androidx.compose.ui.geometry.Offset.m2922timestuRUvjQ(r14, r8)
            long r16 = androidx.compose.ui.geometry.Offset.m2919minusMKHz9U(r6, r14)
            r6 = r16
        L_0x0221:
            r1 = r2
            r14 = r6
            r3 = 0
            float r16 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r14)
            r17 = r0
            java.lang.Float r0 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r16)
            r5.invoke(r1, r0)
            boolean r0 = r2.isConsumed()
            if (r0 == 0) goto L_0x0242
            r1 = r24
            r4 = r2
            r0 = r17
        L_0x0241:
            return r4
        L_0x0242:
            r0 = 0
            r7 = 0
            r1 = r24
            r6 = r0
            r2 = r4
            r3 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r0 = r17
            r4 = 0
            goto L_0x00b3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m542awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x013e, code lost:
        if ((!(androidx.compose.ui.geometry.Offset.m2915getXimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r2)) == 0.0f)) != false) goto L_0x0141;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: horizontalDrag-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m555horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r22, long r23, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r25, kotlin.coroutines.Continuation<? super java.lang.Boolean> r26) {
        /*
            r0 = r26
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r5 = 1
            r6 = 0
            switch(r3) {
                case 0: goto L_0x004f;
                case 1: goto L_0x0031;
                default: goto L_0x0029;
            }
        L_0x0029:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0031:
            r3 = 0
            r7 = 0
            java.lang.Object r8 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r8 = (kotlin.jvm.internal.Ref.LongRef) r8
            java.lang.Object r9 = r0.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            java.lang.Object r10 = r0.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r0.L$0
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            kotlin.ResultKt.throwOnFailure(r1)
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r3
            r3 = r2
            r2 = r1
            goto L_0x0099
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r22
            r7 = r23
            r9 = r25
            r10 = 0
            androidx.compose.ui.input.pointer.PointerEvent r11 = r3.getCurrentEvent()
            boolean r11 = m556isPointerUpDmW0f2w(r11, r7)
            if (r11 == 0) goto L_0x0067
            r3 = r5
            goto L_0x015d
        L_0x0067:
            r11 = r7
        L_0x0068:
            r7 = r3
            r8 = 0
            kotlin.jvm.internal.Ref$LongRef r13 = new kotlin.jvm.internal.Ref$LongRef
            r13.<init>()
            r13.element = r11
            r11 = r9
            r9 = r7
            r7 = r8
            r8 = r13
            r21 = r10
            r10 = r3
            r3 = r21
        L_0x007b:
            r0.L$0 = r11
            r0.L$1 = r10
            r0.L$2 = r9
            r0.L$3 = r8
            r0.label = r5
            java.lang.Object r12 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r9, r6, r0, r5, r6)
            if (r12 != r2) goto L_0x008d
            return r2
        L_0x008d:
            r21 = r2
            r2 = r1
            r1 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r3
            r3 = r21
        L_0x0099:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            java.util.List r13 = r1.getChanges()
            r14 = 0
            r15 = 0
            r16 = 0
            int r4 = r13.size()
            r6 = r16
        L_0x00ac:
            if (r6 >= r4) goto L_0x00d8
            java.lang.Object r16 = r13.get(r6)
            r17 = r16
            r18 = 0
            r19 = r17
            androidx.compose.ui.input.pointer.PointerInputChange r19 = (androidx.compose.ui.input.pointer.PointerInputChange) r19
            r20 = 0
            r22 = r6
            long r5 = r19.m4666getIdJ3iCeTQ()
            r23 = r2
            r24 = r3
            long r2 = r9.element
            boolean r2 = androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r5, r2)
            if (r2 == 0) goto L_0x00cf
            goto L_0x00e1
        L_0x00cf:
            int r6 = r22 + 1
            r2 = r23
            r3 = r24
            r5 = 1
            goto L_0x00ac
        L_0x00d8:
            r23 = r2
            r24 = r3
            r22 = r6
            r17 = 0
        L_0x00e1:
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            if (r17 != 0) goto L_0x00e8
            r2 = 0
            r3 = 1
            goto L_0x0141
        L_0x00e8:
            r2 = r17
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r2)
            if (r3 == 0) goto L_0x0128
            java.util.List r1 = r1.getChanges()
            r3 = 0
            r4 = 0
            r5 = 0
            int r6 = r1.size()
        L_0x00fe:
            if (r5 >= r6) goto L_0x0117
            java.lang.Object r13 = r1.get(r5)
            r14 = r13
            r15 = 0
            r16 = r14
            androidx.compose.ui.input.pointer.PointerInputChange r16 = (androidx.compose.ui.input.pointer.PointerInputChange) r16
            r17 = 0
            boolean r16 = r16.getPressed()
            if (r16 == 0) goto L_0x0113
            goto L_0x0119
        L_0x0113:
            int r5 = r5 + 1
            goto L_0x00fe
        L_0x0117:
            r14 = 0
        L_0x0119:
            r1 = r14
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            if (r1 != 0) goto L_0x0120
            r3 = 1
            goto L_0x0141
        L_0x0120:
            long r2 = r1.m4666getIdJ3iCeTQ()
            r9.element = r2
            r3 = 1
            goto L_0x017a
        L_0x0128:
            r1 = r2
            r3 = 0
            r4 = 0
            long r5 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r1)
            float r1 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r5)
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x013b
            r1 = 1
            goto L_0x013c
        L_0x013b:
            r1 = 0
        L_0x013c:
            r3 = 1
            r1 = r1 ^ r3
            if (r1 == 0) goto L_0x017a
        L_0x0141:
            if (r2 != 0) goto L_0x0147
            r1 = r23
            r6 = 0
            goto L_0x015d
        L_0x0147:
            r1 = r2
            r4 = 0
            boolean r2 = r2.isConsumed()
            if (r2 == 0) goto L_0x0154
            r1 = r23
            r6 = 0
            goto L_0x015d
        L_0x0154:
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r1)
            if (r2 == 0) goto L_0x0167
            r6 = r1
            r1 = r23
        L_0x015d:
            if (r6 == 0) goto L_0x0161
            r4 = r3
            goto L_0x0162
        L_0x0161:
            r4 = 0
        L_0x0162:
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r2
        L_0x0167:
            r12.invoke(r1)
            long r1 = r1.m4666getIdJ3iCeTQ()
            r5 = r3
            r10 = r7
            r3 = r11
            r9 = r12
            r6 = 0
            r11 = r1
            r1 = r23
            r2 = r24
            goto L_0x0068
        L_0x017a:
            r1 = r23
            r2 = r24
            r5 = r3
            r3 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r6 = 0
            goto L_0x007b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m555horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0112, code lost:
        if ((!(androidx.compose.ui.geometry.Offset.m2915getXimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r3)) == 0.0f)) != false) goto L_0x0115;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: awaitHorizontalDragOrCancellation-rnUCldI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m541awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, long r21, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r23) {
        /*
            r0 = r23
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 1
            r5 = 0
            switch(r3) {
                case 0: goto L_0x0043;
                case 1: goto L_0x0031;
                default: goto L_0x0029;
            }
        L_0x0029:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0031:
            r3 = 0
            java.lang.Object r6 = r0.L$1
            kotlin.jvm.internal.Ref$LongRef r6 = (kotlin.jvm.internal.Ref.LongRef) r6
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r1)
            r8 = r7
            r7 = r6
            r6 = r3
            r3 = r2
            r2 = r1
            goto L_0x0078
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r20
            r6 = r21
            androidx.compose.ui.input.pointer.PointerEvent r8 = r3.getCurrentEvent()
            boolean r8 = m556isPointerUpDmW0f2w(r8, r6)
            if (r8 == 0) goto L_0x0055
            return r5
        L_0x0055:
            r8 = 0
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            r9.element = r6
            r7 = r3
            r3 = r8
            r6 = r9
        L_0x0061:
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r8 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r7, r5, r0, r4, r5)
            if (r8 != r2) goto L_0x006f
            return r2
        L_0x006f:
            r19 = r2
            r2 = r1
            r1 = r8
            r8 = r7
            r7 = r6
            r6 = r3
            r3 = r19
        L_0x0078:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            java.util.List r9 = r1.getChanges()
            r10 = 0
            r11 = 0
            r12 = 0
            int r13 = r9.size()
        L_0x0088:
            if (r12 >= r13) goto L_0x00b5
            java.lang.Object r14 = r9.get(r12)
            r15 = r14
            r16 = 0
            r17 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            r18 = 0
            r20 = r6
            long r5 = r17.m4666getIdJ3iCeTQ()
            r21 = r2
            r22 = r3
            long r2 = r7.element
            boolean r2 = androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r5, r2)
            if (r2 == 0) goto L_0x00aa
            goto L_0x00bd
        L_0x00aa:
            int r12 = r12 + 1
            r6 = r20
            r2 = r21
            r3 = r22
            r5 = 0
            goto L_0x0088
        L_0x00b5:
            r21 = r2
            r22 = r3
            r20 = r6
            r15 = 0
        L_0x00bd:
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            r2 = 0
            if (r15 != 0) goto L_0x00c4
            r3 = 0
            goto L_0x0115
        L_0x00c4:
            r3 = r15
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r3)
            if (r5 == 0) goto L_0x00ff
            java.util.List r1 = r1.getChanges()
            r5 = 0
            r6 = 0
            r9 = 0
            int r10 = r1.size()
        L_0x00d9:
            if (r9 >= r10) goto L_0x00f0
            java.lang.Object r11 = r1.get(r9)
            r12 = r11
            r13 = 0
            r14 = r12
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            r15 = 0
            boolean r14 = r14.getPressed()
            if (r14 == 0) goto L_0x00ec
            goto L_0x00f2
        L_0x00ec:
            int r9 = r9 + 1
            goto L_0x00d9
        L_0x00f0:
            r12 = 0
        L_0x00f2:
            r1 = r12
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            if (r1 != 0) goto L_0x00f8
            goto L_0x0115
        L_0x00f8:
            long r2 = r1.m4666getIdJ3iCeTQ()
            r7.element = r2
            goto L_0x0126
        L_0x00ff:
            r1 = r3
            r5 = 0
            long r9 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r1)
            float r6 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r9)
            r9 = 0
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 != 0) goto L_0x0110
            r1 = r4
            goto L_0x0111
        L_0x0110:
            r1 = r2
        L_0x0111:
            r1 = r1 ^ r4
            if (r1 == 0) goto L_0x0126
        L_0x0115:
            r1 = r3
            if (r1 == 0) goto L_0x011f
            boolean r3 = r1.isConsumed()
            if (r3 != 0) goto L_0x011f
            goto L_0x0120
        L_0x011f:
            r4 = r2
        L_0x0120:
            if (r4 == 0) goto L_0x0124
            r5 = r1
            goto L_0x0125
        L_0x0124:
            r5 = 0
        L_0x0125:
            return r5
        L_0x0126:
            r3 = r20
            r1 = r21
            r2 = r22
            r6 = r7
            r7 = r8
            r5 = 0
            goto L_0x0061
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m541awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectHorizontalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        Function1 function12;
        Function0 function03;
        Function0 function04;
        if ((i & 1) != 0) {
            function12 = DragGestureDetectorKt$detectHorizontalDragGestures$2.INSTANCE;
        } else {
            function12 = function1;
        }
        if ((i & 2) != 0) {
            function03 = DragGestureDetectorKt$detectHorizontalDragGestures$3.INSTANCE;
        } else {
            function03 = function0;
        }
        if ((i & 4) != 0) {
            function04 = DragGestureDetectorKt$detectHorizontalDragGestures$4.INSTANCE;
        } else {
            function04 = function02;
        }
        return detectHorizontalDragGestures(pointerInputScope, function12, function03, function04, function2, continuation);
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope $this$detectHorizontalDragGestures, Function1<? super Offset, Unit> onDragStart, Function0<Unit> onDragEnd, Function0<Unit> onDragCancel, Function2<? super PointerInputChange, ? super Float, Unit> onHorizontalDrag, Continuation<? super Unit> $completion) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectHorizontalDragGestures, new DragGestureDetectorKt$detectHorizontalDragGestures$5(onDragStart, onHorizontalDrag, onDragEnd, onDragCancel, (Continuation<? super DragGestureDetectorKt$detectHorizontalDragGestures$5>) null), $completion);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ef A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: drag-VnAYq1g  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m552dragVnAYq1g(androidx.compose.ui.input.pointer.AwaitPointerEventScope r23, long r24, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r26, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float> r27, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Boolean> r28, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r29) {
        /*
            r0 = r29
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$2
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$2 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$2) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$2 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$2
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 1
            r5 = 0
            switch(r3) {
                case 0: goto L_0x005a;
                case 1: goto L_0x0031;
                default: goto L_0x0029;
            }
        L_0x0029:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0031:
            r3 = 0
            r6 = 0
            java.lang.Object r7 = r0.L$5
            kotlin.jvm.internal.Ref$LongRef r7 = (kotlin.jvm.internal.Ref.LongRef) r7
            java.lang.Object r8 = r0.L$4
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            java.lang.Object r9 = r0.L$3
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r11 = r0.L$1
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            java.lang.Object r12 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
            kotlin.ResultKt.throwOnFailure(r1)
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r3
            r3 = r2
            r2 = r1
            goto L_0x00aa
        L_0x005a:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r23
            r6 = r27
            r7 = r24
            r9 = r26
            r10 = r28
            r11 = 0
            androidx.compose.ui.input.pointer.PointerEvent r12 = r3.getCurrentEvent()
            boolean r12 = m556isPointerUpDmW0f2w(r12, r7)
            if (r12 == 0) goto L_0x0073
            return r5
        L_0x0073:
            r12 = r7
        L_0x0074:
            r7 = r3
            r8 = 0
            kotlin.jvm.internal.Ref$LongRef r14 = new kotlin.jvm.internal.Ref$LongRef
            r14.<init>()
            r14.element = r12
            r12 = r3
            r3 = r11
            r11 = r9
            r9 = r10
            r10 = r6
            r6 = r8
            r8 = r7
            r7 = r14
        L_0x0086:
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r10
            r0.L$3 = r9
            r0.L$4 = r8
            r0.L$5 = r7
            r0.label = r4
            java.lang.Object r13 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r8, r5, r0, r4, r5)
            if (r13 != r2) goto L_0x009c
            return r2
        L_0x009c:
            r22 = r2
            r2 = r1
            r1 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r3
            r3 = r22
        L_0x00aa:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            java.util.List r14 = r1.getChanges()
            r15 = 0
            r16 = 0
            r17 = 0
            int r5 = r14.size()
            r4 = r17
        L_0x00be:
            if (r4 >= r5) goto L_0x00ef
            java.lang.Object r17 = r14.get(r4)
            r18 = r17
            r19 = 0
            r20 = r18
            androidx.compose.ui.input.pointer.PointerInputChange r20 = (androidx.compose.ui.input.pointer.PointerInputChange) r20
            r21 = 0
            r23 = r2
            r24 = r3
            long r2 = r20.m4666getIdJ3iCeTQ()
            r26 = r5
            r25 = r6
            long r5 = r8.element
            boolean r2 = androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r2, r5)
            if (r2 == 0) goto L_0x00e3
            goto L_0x00f8
        L_0x00e3:
            int r4 = r4 + 1
            r2 = r23
            r3 = r24
            r6 = r25
            r5 = r26
            goto L_0x00be
        L_0x00ef:
            r23 = r2
            r24 = r3
            r25 = r6
            r18 = 0
        L_0x00f8:
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            if (r18 != 0) goto L_0x00ff
            r2 = 0
            r3 = 1
            goto L_0x015a
        L_0x00ff:
            r2 = r18
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r2)
            if (r3 == 0) goto L_0x0141
            java.util.List r1 = r1.getChanges()
            r3 = 0
            r4 = 0
            r5 = 0
            int r6 = r1.size()
        L_0x0115:
            if (r5 >= r6) goto L_0x012f
            java.lang.Object r14 = r1.get(r5)
            r15 = r14
            r16 = 0
            r17 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            r18 = 0
            boolean r17 = r17.getPressed()
            if (r17 == 0) goto L_0x012b
            goto L_0x0131
        L_0x012b:
            int r5 = r5 + 1
            goto L_0x0115
        L_0x012f:
            r15 = 0
        L_0x0131:
            r1 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            if (r1 != 0) goto L_0x0138
            r3 = 1
            goto L_0x015a
        L_0x0138:
            long r2 = r1.m4666getIdJ3iCeTQ()
            r8.element = r2
            r3 = 1
            r4 = 0
            goto L_0x018a
        L_0x0141:
            r1 = r2
            r3 = 0
            java.lang.Object r4 = r11.invoke(r1)
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x0154
            r1 = 1
            goto L_0x0155
        L_0x0154:
            r1 = 0
        L_0x0155:
            r3 = 1
            r1 = r1 ^ r3
            if (r1 == 0) goto L_0x0189
        L_0x015a:
            if (r2 != 0) goto L_0x015e
            r4 = 0
            return r4
        L_0x015e:
            r4 = 0
            r1 = r2
            java.lang.Object r2 = r10.invoke(r1)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x016d
            return r4
        L_0x016d:
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r1)
            if (r2 == 0) goto L_0x0174
            return r1
        L_0x0174:
            r12.invoke(r1)
            long r1 = r1.m4666getIdJ3iCeTQ()
            r5 = r4
            r6 = r11
            r9 = r12
            r11 = r25
            r4 = r3
            r3 = r13
            r12 = r1
            r1 = r23
            r2 = r24
            goto L_0x0074
        L_0x0189:
            r4 = 0
        L_0x018a:
            r1 = r23
            r2 = r24
            r5 = r4
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r4 = r3
            r3 = r25
            goto L_0x0086
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m552dragVnAYq1g(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: drag-VnAYq1g$$forInline  reason: not valid java name */
    private static final Object m553dragVnAYq1g$$forInline(AwaitPointerEventScope $this$drag_u2dVnAYq1g, long pointerId, Function1<? super PointerInputChange, Unit> onDrag, Function1<? super PointerInputChange, Float> motionFromChange, Function1<? super PointerInputChange, Boolean> motionConsumed, Continuation<? super PointerInputChange> $completion) {
        int i;
        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv;
        Object it$iv$iv;
        PointerInputChange dragEvent$iv;
        Object it$iv$iv2;
        int dragEvent$iv2 = 0;
        PointerEventPass pointerEventPass = null;
        if (m556isPointerUpDmW0f2w($this$drag_u2dVnAYq1g.getCurrentEvent(), pointerId)) {
            return null;
        }
        long pointer = pointerId;
        while (true) {
            AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv2 = $this$drag_u2dVnAYq1g;
            Ref.LongRef pointer$iv = new Ref.LongRef();
            pointer$iv.element = pointer;
            while (true) {
                InlineMarker.mark(0);
                Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88$iv2, pointerEventPass, $completion, 1, pointerEventPass);
                InlineMarker.mark(1);
                PointerEvent event$iv = (PointerEvent) awaitPointerEvent$default;
                List $this$fastForEach$iv$iv$iv = event$iv.getChanges();
                int size = $this$fastForEach$iv$iv$iv.size();
                int index$iv$iv$iv = 0;
                while (true) {
                    if (index$iv$iv$iv >= size) {
                        i = dragEvent$iv2;
                        $this$awaitDragOrUp_u2djO51t88$iv = $this$awaitDragOrUp_u2djO51t88$iv2;
                        it$iv$iv = null;
                        break;
                    }
                    it$iv$iv = $this$fastForEach$iv$iv$iv.get(index$iv$iv$iv);
                    i = dragEvent$iv2;
                    $this$awaitDragOrUp_u2djO51t88$iv = $this$awaitDragOrUp_u2djO51t88$iv2;
                    Boolean valueOf = Boolean.valueOf(PointerId.m4652equalsimpl0(((PointerInputChange) it$iv$iv).m4666getIdJ3iCeTQ(), pointer$iv.element));
                    Boolean bool = valueOf;
                    if (valueOf.booleanValue()) {
                        break;
                    }
                    index$iv$iv$iv++;
                    Continuation<? super PointerInputChange> continuation = $completion;
                    dragEvent$iv2 = i;
                    $this$awaitDragOrUp_u2djO51t88$iv2 = $this$awaitDragOrUp_u2djO51t88$iv;
                }
                PointerInputChange pointerInputChange = (PointerInputChange) it$iv$iv;
                if (pointerInputChange == null) {
                    Function1<? super PointerInputChange, Float> function1 = motionFromChange;
                    dragEvent$iv = null;
                    break;
                }
                dragEvent$iv = pointerInputChange;
                if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                    List $this$fastForEach$iv$iv$iv2 = event$iv.getChanges();
                    int index$iv$iv$iv2 = 0;
                    int size2 = $this$fastForEach$iv$iv$iv2.size();
                    while (true) {
                        if (index$iv$iv$iv2 >= size2) {
                            it$iv$iv2 = null;
                            break;
                        }
                        it$iv$iv2 = $this$fastForEach$iv$iv$iv2.get(index$iv$iv$iv2);
                        Boolean valueOf2 = Boolean.valueOf(((PointerInputChange) it$iv$iv2).getPressed());
                        Boolean bool2 = valueOf2;
                        if (valueOf2.booleanValue()) {
                            break;
                        }
                        index$iv$iv$iv2++;
                    }
                    PointerInputChange otherDown$iv = (PointerInputChange) it$iv$iv2;
                    if (otherDown$iv == null) {
                        Function1<? super PointerInputChange, Float> function12 = motionFromChange;
                        break;
                    }
                    pointer$iv.element = otherDown$iv.m4666getIdJ3iCeTQ();
                    Function1<? super PointerInputChange, Float> function13 = motionFromChange;
                } else {
                    Boolean valueOf3 = Boolean.valueOf(!(motionFromChange.invoke(dragEvent$iv).floatValue() == 0.0f));
                    Boolean bool3 = valueOf3;
                    if (valueOf3.booleanValue()) {
                        break;
                    }
                }
                dragEvent$iv2 = i;
                $this$awaitDragOrUp_u2djO51t88$iv2 = $this$awaitDragOrUp_u2djO51t88$iv;
                pointerEventPass = null;
            }
            PointerInputChange pointerInputChange2 = dragEvent$iv;
            if (dragEvent$iv == null) {
                Function1<? super PointerInputChange, Unit> function14 = onDrag;
                Function1<? super PointerInputChange, Boolean> function15 = motionConsumed;
                return null;
            } else if (motionConsumed.invoke(dragEvent$iv).booleanValue()) {
                return null;
            } else {
                if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                    return dragEvent$iv;
                }
                onDrag.invoke(dragEvent$iv);
                pointer = dragEvent$iv.m4666getIdJ3iCeTQ();
                dragEvent$iv2 = i;
                pointerEventPass = null;
            }
        }
    }

    /* renamed from: awaitDragOrUp-jO51t88  reason: not valid java name */
    private static final Object m540awaitDragOrUpjO51t88(AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88, long pointerId, Function1<? super PointerInputChange, Boolean> hasDragged, Continuation<? super PointerInputChange> $completion) {
        PointerEvent event;
        Object it$iv;
        Object obj;
        Ref.LongRef pointer = new Ref.LongRef();
        pointer.element = pointerId;
        while (true) {
            InlineMarker.mark(0);
            Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88, (PointerEventPass) null, $completion, 1, (Object) null);
            InlineMarker.mark(1);
            PointerEvent event2 = (PointerEvent) awaitPointerEvent$default;
            List $this$fastForEach$iv$iv = event2.getChanges();
            int index$iv$iv = 0;
            int size = $this$fastForEach$iv$iv.size();
            while (true) {
                if (index$iv$iv >= size) {
                    event = event2;
                    it$iv = null;
                    break;
                }
                it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
                event = event2;
                Boolean valueOf = Boolean.valueOf(PointerId.m4652equalsimpl0(((PointerInputChange) it$iv).m4666getIdJ3iCeTQ(), pointer.element));
                Boolean bool = valueOf;
                if (valueOf.booleanValue()) {
                    break;
                }
                index$iv$iv++;
                long j = pointerId;
                event2 = event;
            }
            PointerInputChange pointerInputChange = (PointerInputChange) it$iv;
            if (pointerInputChange != null) {
                PointerInputChange dragEvent = pointerInputChange;
                if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent)) {
                    List $this$fastForEach$iv$iv2 = event.getChanges();
                    int index$iv$iv2 = 0;
                    int size2 = $this$fastForEach$iv$iv2.size();
                    while (true) {
                        if (index$iv$iv2 >= size2) {
                            obj = null;
                            break;
                        }
                        Object it$iv2 = $this$fastForEach$iv$iv2.get(index$iv$iv2);
                        Boolean valueOf2 = Boolean.valueOf(((PointerInputChange) it$iv2).getPressed());
                        Boolean bool2 = valueOf2;
                        if (valueOf2.booleanValue()) {
                            obj = it$iv2;
                            break;
                        }
                        index$iv$iv2++;
                    }
                    PointerInputChange otherDown = (PointerInputChange) obj;
                    if (otherDown == null) {
                        return dragEvent;
                    }
                    pointer.element = otherDown.m4666getIdJ3iCeTQ();
                    Function1<? super PointerInputChange, Boolean> function1 = hasDragged;
                } else if (hasDragged.invoke(dragEvent).booleanValue()) {
                    return dragEvent;
                }
                long j2 = pointerId;
            } else {
                Function1<? super PointerInputChange, Boolean> function12 = hasDragged;
                return null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01e6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: awaitPointerSlopOrCancellation-wtdNQyU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m545awaitPointerSlopOrCancellationwtdNQyU(androidx.compose.ui.input.pointer.AwaitPointerEventScope r23, long r24, int r26, androidx.compose.foundation.gestures.PointerDirectionConfig r27, boolean r28, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r29, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r30) {
        /*
            r0 = r30
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 0
            switch(r3) {
                case 0: goto L_0x0085;
                case 1: goto L_0x005b;
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
            float r5 = r0.F$2
            float r6 = r0.F$1
            float r7 = r0.F$0
            boolean r8 = r0.Z$0
            java.lang.Object r9 = r0.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            java.lang.Object r10 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r11 = r0.L$2
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            java.lang.Object r12 = r0.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r12 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r12
            java.lang.Object r13 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            kotlin.ResultKt.throwOnFailure(r1)
            r4 = r7
            r7 = r6
            r6 = r12
            r12 = r10
            r10 = r8
            r8 = r5
            r5 = r11
            r11 = r3
            r3 = r13
            goto L_0x01e0
        L_0x005b:
            r3 = 0
            float r5 = r0.F$2
            float r6 = r0.F$1
            float r7 = r0.F$0
            boolean r8 = r0.Z$0
            java.lang.Object r9 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            java.lang.Object r11 = r0.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r11 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r11
            java.lang.Object r12 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
            kotlin.ResultKt.throwOnFailure(r1)
            r13 = r9
            r9 = r7
            r7 = r6
            r6 = r11
            r11 = r3
            r3 = r2
            r2 = r1
            r22 = r8
            r8 = r5
            r5 = r10
            r10 = r22
            goto L_0x00d6
        L_0x0085:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r23
            r5 = r29
            r6 = r27
            r7 = r24
            r9 = r26
            r10 = r28
            r11 = 0
            androidx.compose.ui.input.pointer.PointerEvent r12 = r3.getCurrentEvent()
            boolean r12 = m556isPointerUpDmW0f2w(r12, r7)
            if (r12 == 0) goto L_0x00a0
            return r4
        L_0x00a0:
            androidx.compose.ui.platform.ViewConfiguration r12 = r3.getViewConfiguration()
            float r9 = m557pointerSlopE8SPZFQ(r12, r9)
            kotlin.jvm.internal.Ref$LongRef r12 = new kotlin.jvm.internal.Ref$LongRef
            r12.<init>()
            r12.element = r7
            r7 = 0
            r8 = 0
        L_0x00b1:
            r0.L$0 = r3
            r0.L$1 = r6
            r0.L$2 = r5
            r0.L$3 = r12
            r0.L$4 = r4
            r0.Z$0 = r10
            r0.F$0 = r9
            r0.F$1 = r7
            r0.F$2 = r8
            r13 = 1
            r0.label = r13
            java.lang.Object r13 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r3, r4, r0, r13, r4)
            if (r13 != r2) goto L_0x00ce
            return r2
        L_0x00ce:
            r22 = r2
            r2 = r1
            r1 = r13
            r13 = r12
            r12 = r3
            r3 = r22
        L_0x00d6:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            java.util.List r14 = r1.getChanges()
            r15 = 0
            r16 = 0
            r17 = 0
            int r4 = r14.size()
            r23 = r2
            r2 = r17
        L_0x00ec:
            if (r2 >= r4) goto L_0x011d
            java.lang.Object r17 = r14.get(r2)
            r18 = r17
            r19 = 0
            r20 = r18
            androidx.compose.ui.input.pointer.PointerInputChange r20 = (androidx.compose.ui.input.pointer.PointerInputChange) r20
            r21 = 0
            r25 = r14
            r24 = r15
            long r14 = r20.m4666getIdJ3iCeTQ()
            r26 = r3
            r27 = r4
            long r3 = r13.element
            boolean r3 = androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r14, r3)
            if (r3 == 0) goto L_0x0111
            goto L_0x0126
        L_0x0111:
            int r2 = r2 + 1
            r15 = r24
            r14 = r25
            r3 = r26
            r4 = r27
            goto L_0x00ec
        L_0x011d:
            r26 = r3
            r25 = r14
            r24 = r15
            r18 = 0
        L_0x0126:
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            if (r18 != 0) goto L_0x012c
            r2 = 0
            return r2
        L_0x012c:
            r2 = 0
            r3 = r18
            boolean r4 = r3.isConsumed()
            if (r4 == 0) goto L_0x0136
            return r2
        L_0x0136:
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r3)
            if (r2 == 0) goto L_0x017f
            java.util.List r1 = r1.getChanges()
            r2 = 0
            r3 = 0
            r4 = 0
            int r14 = r1.size()
        L_0x014a:
            if (r4 >= r14) goto L_0x0165
            java.lang.Object r15 = r1.get(r4)
            r16 = r15
            r17 = 0
            r18 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            r19 = 0
            boolean r18 = r18.getPressed()
            if (r18 == 0) goto L_0x0161
            goto L_0x0168
        L_0x0161:
            int r4 = r4 + 1
            goto L_0x014a
        L_0x0165:
            r16 = 0
        L_0x0168:
            r1 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            if (r1 != 0) goto L_0x0170
            r2 = 0
            return r2
        L_0x0170:
            long r2 = r1.m4666getIdJ3iCeTQ()
            r13.element = r2
            r1 = r23
            r2 = r26
            r3 = r12
            r12 = r13
            r4 = 0
            goto L_0x00b1
        L_0x017f:
            long r1 = r3.m4667getPositionF1C5BW0()
            long r14 = r3.m4668getPreviousPositionF1C5BW0()
            float r4 = r6.m583mainAxisDeltak4lQ0M(r1)
            float r16 = r6.m583mainAxisDeltak4lQ0M(r14)
            float r4 = r4 - r16
            float r1 = r6.m582crossAxisDeltak4lQ0M(r1)
            float r2 = r6.m582crossAxisDeltak4lQ0M(r14)
            float r1 = r1 - r2
            float r2 = r7 + r4
            float r1 = r1 + r8
            if (r10 == 0) goto L_0x01a4
            float r4 = java.lang.Math.abs(r2)
            goto L_0x01af
        L_0x01a4:
            long r7 = r6.m584offsetFromChangesdBAh8RU(r2, r1)
            float r4 = androidx.compose.ui.geometry.Offset.m2913getDistanceimpl(r7)
        L_0x01af:
            int r7 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r7 >= 0) goto L_0x01ed
            androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r0.L$0 = r12
            r0.L$1 = r6
            r0.L$2 = r5
            r0.L$3 = r13
            r0.L$4 = r3
            r0.Z$0 = r10
            r0.F$0 = r9
            r0.F$1 = r2
            r0.F$2 = r1
            r7 = 2
            r0.label = r7
            java.lang.Object r4 = r12.awaitPointerEvent(r4, r0)
            r7 = r26
            if (r4 != r7) goto L_0x01d4
            return r7
        L_0x01d4:
            r8 = r1
            r4 = r9
            r1 = r23
            r9 = r3
            r3 = r12
            r12 = r13
            r22 = r7
            r7 = r2
            r2 = r22
        L_0x01e0:
            boolean r13 = r9.isConsumed()
            if (r13 == 0) goto L_0x01e8
            r14 = 0
            return r14
        L_0x01e8:
            r14 = 0
            r9 = r4
            r4 = r14
            goto L_0x00b1
        L_0x01ed:
            r7 = r26
            r14 = 0
            if (r10 == 0) goto L_0x0201
            float r4 = java.lang.Math.signum(r2)
            float r4 = r4 * r9
            float r2 = r2 - r4
            long r1 = r6.m584offsetFromChangesdBAh8RU(r2, r1)
            goto L_0x0216
        L_0x0201:
            long r1 = r6.m584offsetFromChangesdBAh8RU(r2, r1)
            long r14 = androidx.compose.ui.geometry.Offset.m2910divtuRUvjQ(r1, r4)
            long r14 = androidx.compose.ui.geometry.Offset.m2922timestuRUvjQ(r14, r9)
            long r16 = androidx.compose.ui.geometry.Offset.m2919minusMKHz9U(r1, r14)
            r1 = r16
        L_0x0216:
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m2904boximpl(r1)
            r5.invoke(r3, r4)
            boolean r4 = r3.isConsumed()
            if (r4 == 0) goto L_0x0227
            return r3
        L_0x0227:
            r3 = 0
            r8 = 0
            r1 = r23
            r2 = r7
            r4 = 0
            r7 = r3
            r3 = r12
            r12 = r13
            goto L_0x00b1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m545awaitPointerSlopOrCancellationwtdNQyU(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, androidx.compose.foundation.gestures.PointerDirectionConfig, boolean, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: awaitPointerSlopOrCancellation-wtdNQyU$default  reason: not valid java name */
    public static /* synthetic */ Object m547awaitPointerSlopOrCancellationwtdNQyU$default(AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default, long pointerId, int pointerType, PointerDirectionConfig pointerDirectionConfig, boolean triggerOnMainAxisSlop, Function2 onPointerSlopReached, Continuation $completion, int i, Object obj) {
        PointerDirectionConfig pointerDirectionConfig2;
        boolean triggerOnMainAxisSlop2;
        Object it$iv;
        float f;
        long offset;
        Object it$iv2;
        AwaitPointerEventScope awaitPointerEventScope = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default;
        Continuation continuation = $completion;
        if ((i & 4) != 0) {
            pointerDirectionConfig2 = getHorizontalPointerDirectionConfig();
        } else {
            pointerDirectionConfig2 = pointerDirectionConfig;
        }
        if ((i & 8) != 0) {
            triggerOnMainAxisSlop2 = true;
        } else {
            triggerOnMainAxisSlop2 = triggerOnMainAxisSlop;
        }
        PointerInputChange otherDown = null;
        PointerEventPass pointerEventPass = null;
        if (m556isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default.getCurrentEvent(), pointerId)) {
            return null;
        }
        float touchSlop = m557pointerSlopE8SPZFQ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default.getViewConfiguration(), pointerType);
        long pointer = pointerId;
        float totalMainPositionChange = 0.0f;
        float totalCrossPositionChange = 0.0f;
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
            PointerInputChange pointerInputChange = (PointerInputChange) it$iv;
            if (pointerInputChange == null) {
                return null;
            }
            PointerInputChange dragEvent = pointerInputChange;
            if (dragEvent.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent)) {
                List changes = event.getChanges();
                List $this$fastForEach$iv$iv3 = changes;
                PointerInputChange pointerInputChange2 = otherDown;
                int size2 = $this$fastForEach$iv$iv3.size();
                List<PointerInputChange> list = changes;
                int index$iv$iv2 = 0;
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
                otherDown = pointerInputChange2;
                pointerEventPass = null;
            } else {
                PointerInputChange pointerInputChange3 = otherDown;
                long currentPosition = dragEvent.m4667getPositionF1C5BW0();
                long previousPosition = dragEvent.m4668getPreviousPositionF1C5BW0();
                float mainPositionChange = pointerDirectionConfig2.m583mainAxisDeltak4lQ0M(currentPosition) - pointerDirectionConfig2.m583mainAxisDeltak4lQ0M(previousPosition);
                totalMainPositionChange += mainPositionChange;
                totalCrossPositionChange += pointerDirectionConfig2.m582crossAxisDeltak4lQ0M(currentPosition) - pointerDirectionConfig2.m582crossAxisDeltak4lQ0M(previousPosition);
                if (triggerOnMainAxisSlop2) {
                    f = Math.abs(totalMainPositionChange);
                } else {
                    f = Offset.m2913getDistanceimpl(pointerDirectionConfig2.m584offsetFromChangesdBAh8RU(totalMainPositionChange, totalCrossPositionChange));
                }
                float inDirection = f;
                float f2 = mainPositionChange;
                float mainPositionChange2 = inDirection;
                if (mainPositionChange2 < touchSlop) {
                    long j3 = currentPosition;
                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                    InlineMarker.mark(0);
                    awaitPointerEventScope.awaitPointerEvent(pointerEventPass2, continuation);
                    InlineMarker.mark(1);
                    if (dragEvent.isConsumed()) {
                        return null;
                    }
                    long j4 = pointerId;
                    otherDown = pointerInputChange3;
                    pointerEventPass = null;
                } else {
                    if (triggerOnMainAxisSlop2) {
                        offset = pointerDirectionConfig2.m584offsetFromChangesdBAh8RU(totalMainPositionChange - (Math.signum(totalMainPositionChange) * touchSlop), totalCrossPositionChange);
                    } else {
                        long offset2 = pointerDirectionConfig2.m584offsetFromChangesdBAh8RU(totalMainPositionChange, totalCrossPositionChange);
                        offset = Offset.m2919minusMKHz9U(offset2, Offset.m2922timestuRUvjQ(Offset.m2910divtuRUvjQ(offset2, mainPositionChange2), touchSlop));
                    }
                    onPointerSlopReached.invoke(dragEvent, Offset.m2904boximpl(offset));
                    if (dragEvent.isConsumed()) {
                        return dragEvent;
                    }
                    totalMainPositionChange = 0.0f;
                    totalCrossPositionChange = 0.0f;
                    awaitPointerEventScope = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default;
                    long j5 = pointerId;
                    otherDown = pointerInputChange3;
                    continuation = $completion;
                    pointerEventPass = null;
                }
            }
        }
    }

    /* renamed from: awaitPointerSlopOrCancellation-wtdNQyU$$forInline  reason: not valid java name */
    private static final Object m546awaitPointerSlopOrCancellationwtdNQyU$$forInline(AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU, long pointerId, int pointerType, PointerDirectionConfig pointerDirectionConfig, boolean triggerOnMainAxisSlop, Function2<? super PointerInputChange, ? super Offset, Unit> onPointerSlopReached, Continuation<? super PointerInputChange> $completion) {
        Object it$iv;
        int i;
        float f;
        long postSlopOffset;
        Object it$iv2;
        AwaitPointerEventScope awaitPointerEventScope = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU;
        long j = pointerId;
        PointerDirectionConfig pointerDirectionConfig2 = pointerDirectionConfig;
        Continuation<? super PointerInputChange> continuation = $completion;
        int i2 = 0;
        PointerEventPass pointerEventPass = null;
        if (m556isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dwtdNQyU.getCurrentEvent(), j)) {
            return null;
        }
        float touchSlop = m557pointerSlopE8SPZFQ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU.getViewConfiguration(), pointerType);
        Ref.LongRef pointer = new Ref.LongRef();
        pointer.element = j;
        float totalMainPositionChange = 0.0f;
        float totalCrossPositionChange = 0.0f;
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
                List $this$fastForEach$iv$iv3 = $this$fastForEach$iv$iv2;
                Boolean valueOf = Boolean.valueOf(PointerId.m4652equalsimpl0(((PointerInputChange) it$iv).m4666getIdJ3iCeTQ(), pointer.element));
                Boolean bool = valueOf;
                if (valueOf.booleanValue()) {
                    break;
                }
                index$iv$iv++;
                long j2 = pointerId;
                int i3 = pointerType;
                $this$fastForEach$iv$iv = $this$fastForEach$iv$iv3;
            }
            PointerInputChange pointerInputChange = (PointerInputChange) it$iv;
            if (pointerInputChange == null) {
                return null;
            }
            PointerInputChange dragEvent = pointerInputChange;
            if (dragEvent.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent)) {
                List $this$fastForEach$iv$iv4 = event.getChanges();
                int index$iv$iv2 = 0;
                int size2 = $this$fastForEach$iv$iv4.size();
                while (true) {
                    if (index$iv$iv2 >= size2) {
                        it$iv2 = null;
                        break;
                    }
                    it$iv2 = $this$fastForEach$iv$iv4.get(index$iv$iv2);
                    Boolean valueOf2 = Boolean.valueOf(((PointerInputChange) it$iv2).getPressed());
                    Boolean bool2 = valueOf2;
                    if (valueOf2.booleanValue()) {
                        break;
                    }
                    index$iv$iv2++;
                }
                PointerInputChange otherDown = (PointerInputChange) it$iv2;
                if (otherDown == null) {
                    return null;
                }
                pointer.element = otherDown.m4666getIdJ3iCeTQ();
                Function2<? super PointerInputChange, ? super Offset, Unit> function2 = onPointerSlopReached;
                i = i2;
            } else {
                long currentPosition = dragEvent.m4667getPositionF1C5BW0();
                long previousPosition = dragEvent.m4668getPreviousPositionF1C5BW0();
                float mainPositionChange = pointerDirectionConfig2.m583mainAxisDeltak4lQ0M(currentPosition) - pointerDirectionConfig2.m583mainAxisDeltak4lQ0M(previousPosition);
                totalMainPositionChange += mainPositionChange;
                totalCrossPositionChange += pointerDirectionConfig2.m582crossAxisDeltak4lQ0M(currentPosition) - pointerDirectionConfig2.m582crossAxisDeltak4lQ0M(previousPosition);
                if (triggerOnMainAxisSlop) {
                    f = Math.abs(totalMainPositionChange);
                } else {
                    f = Offset.m2913getDistanceimpl(pointerDirectionConfig2.m584offsetFromChangesdBAh8RU(totalMainPositionChange, totalCrossPositionChange));
                }
                float inDirection = f;
                float f2 = mainPositionChange;
                float mainPositionChange2 = inDirection;
                if (mainPositionChange2 < touchSlop) {
                    i = i2;
                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                    InlineMarker.mark(0);
                    awaitPointerEventScope.awaitPointerEvent(pointerEventPass2, continuation);
                    InlineMarker.mark(1);
                    if (dragEvent.isConsumed()) {
                        return null;
                    }
                    Function2<? super PointerInputChange, ? super Offset, Unit> function22 = onPointerSlopReached;
                } else {
                    i = i2;
                    if (triggerOnMainAxisSlop) {
                        postSlopOffset = pointerDirectionConfig2.m584offsetFromChangesdBAh8RU(totalMainPositionChange - (Math.signum(totalMainPositionChange) * touchSlop), totalCrossPositionChange);
                        long j3 = currentPosition;
                    } else {
                        long offset = pointerDirectionConfig2.m584offsetFromChangesdBAh8RU(totalMainPositionChange, totalCrossPositionChange);
                        long j4 = currentPosition;
                        postSlopOffset = Offset.m2919minusMKHz9U(offset, Offset.m2922timestuRUvjQ(Offset.m2910divtuRUvjQ(offset, mainPositionChange2), touchSlop));
                    }
                    onPointerSlopReached.invoke(dragEvent, Offset.m2904boximpl(postSlopOffset));
                    if (dragEvent.isConsumed()) {
                        return dragEvent;
                    }
                    totalCrossPositionChange = 0.0f;
                    totalMainPositionChange = 0.0f;
                }
            }
            long j5 = pointerId;
            int i4 = pointerType;
            continuation = $completion;
            i2 = i;
            pointerEventPass = null;
        }
    }

    public static final PointerDirectionConfig getHorizontalPointerDirectionConfig() {
        return HorizontalPointerDirectionConfig;
    }

    public static final PointerDirectionConfig getVerticalPointerDirectionConfig() {
        return VerticalPointerDirectionConfig;
    }

    public static final PointerDirectionConfig toPointerDirectionConfig(Orientation $this$toPointerDirectionConfig) {
        Intrinsics.checkNotNullParameter($this$toPointerDirectionConfig, "<this>");
        if ($this$toPointerDirectionConfig == Orientation.Vertical) {
            return VerticalPointerDirectionConfig;
        }
        return HorizontalPointerDirectionConfig;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: awaitLongPressOrCancellation-rnUCldI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m544awaitLongPressOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            r0 = r20
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r2 = r1.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 0
            switch(r3) {
                case 0: goto L_0x0042;
                case 1: goto L_0x0030;
                default: goto L_0x0028;
            }
        L_0x0028:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0030:
            java.lang.Object r0 = r1.L$1
            r3 = r0
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r0 = r1.L$0
            r5 = r0
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ PointerEventTimeoutCancellationException -> 0x003f }
            goto L_0x00c1
        L_0x003f:
            r0 = move-exception
            goto L_0x00c5
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r2)
            r3 = r17
            r5 = r18
            androidx.compose.ui.input.pointer.PointerEvent r7 = r3.getCurrentEvent()
            boolean r7 = m556isPointerUpDmW0f2w(r7, r5)
            if (r7 == 0) goto L_0x0054
            return r4
        L_0x0054:
            androidx.compose.ui.input.pointer.PointerEvent r7 = r3.getCurrentEvent()
            java.util.List r7 = r7.getChanges()
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r7.size()
        L_0x0066:
            if (r10 >= r11) goto L_0x008a
            java.lang.Object r12 = r7.get(r10)
            r13 = r12
            r14 = 0
            r15 = r13
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            r16 = 0
            r18 = r7
            r17 = r8
            long r7 = r15.m4666getIdJ3iCeTQ()
            boolean r7 = androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r7, r5)
            if (r7 == 0) goto L_0x0082
            goto L_0x0090
        L_0x0082:
            int r10 = r10 + 1
            r8 = r17
            r7 = r18
            goto L_0x0066
        L_0x008a:
            r18 = r7
            r17 = r8
            r13 = r4
        L_0x0090:
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            if (r13 != 0) goto L_0x0095
            return r4
        L_0x0095:
            r5 = r13
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r7.element = r5
            androidx.compose.ui.platform.ViewConfiguration r8 = r3.getViewConfiguration()
            long r8 = r8.getLongPressTimeoutMillis()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2 r10 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2     // Catch:{ PointerEventTimeoutCancellationException -> 0x00c3 }
            r10.<init>(r7, r6, r4)     // Catch:{ PointerEventTimeoutCancellationException -> 0x00c3 }
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10     // Catch:{ PointerEventTimeoutCancellationException -> 0x00c3 }
            r1.L$0 = r5     // Catch:{ PointerEventTimeoutCancellationException -> 0x00c3 }
            r1.L$1 = r6     // Catch:{ PointerEventTimeoutCancellationException -> 0x00c3 }
            r11 = 1
            r1.label = r11     // Catch:{ PointerEventTimeoutCancellationException -> 0x00c3 }
            java.lang.Object r10 = r3.withTimeout(r8, r10, r1)     // Catch:{ PointerEventTimeoutCancellationException -> 0x00c3 }
            if (r10 != r0) goto L_0x00c0
            return r0
        L_0x00c0:
            r3 = r6
        L_0x00c1:
            goto L_0x00ce
        L_0x00c3:
            r0 = move-exception
            r3 = r6
        L_0x00c5:
            T r0 = r3.element
            androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0
            if (r0 != 0) goto L_0x00cd
            r4 = r5
            goto L_0x00ce
        L_0x00cd:
            r4 = r0
        L_0x00ce:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m544awaitLongPressOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* renamed from: isPointerUp-DmW0f2w  reason: not valid java name */
    public static final boolean m556isPointerUpDmW0f2w(PointerEvent $this$isPointerUp_u2dDmW0f2w, long pointerId) {
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
    public static final float m557pointerSlopE8SPZFQ(ViewConfiguration $this$pointerSlop_u2dE8SPZFQ, int pointerType) {
        Intrinsics.checkNotNullParameter($this$pointerSlop_u2dE8SPZFQ, "$this$pointerSlop");
        if (PointerType.m4739equalsimpl0(pointerType, PointerType.Companion.m4744getMouseT8wyACA())) {
            return $this$pointerSlop_u2dE8SPZFQ.getTouchSlop() * mouseToTouchSlopRatio;
        }
        return $this$pointerSlop_u2dE8SPZFQ.getTouchSlop();
    }
}
