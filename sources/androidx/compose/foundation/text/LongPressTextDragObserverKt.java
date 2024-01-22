package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u001d\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u001d\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u001d\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"detectDownAndDragGesturesWithObserver", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "observer", "Landroidx/compose/foundation/text/TextDragObserver;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPressWithObserver", "detectDragGesturesWithObserver", "detectPreDragGesturesWithObserver", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LongPressTextDragObserver.kt */
public final class LongPressTextDragObserverKt {
    public static final Object detectDragGesturesAfterLongPressWithObserver(PointerInputScope $this$detectDragGesturesAfterLongPressWithObserver, TextDragObserver observer, Continuation<? super Unit> $completion) {
        Object detectDragGesturesAfterLongPress = DragGestureDetectorKt.detectDragGesturesAfterLongPress($this$detectDragGesturesAfterLongPressWithObserver, new LongPressTextDragObserverKt$detectDragGesturesAfterLongPressWithObserver$2(observer), new LongPressTextDragObserverKt$detectDragGesturesAfterLongPressWithObserver$3(observer), new LongPressTextDragObserverKt$detectDragGesturesAfterLongPressWithObserver$4(observer), new LongPressTextDragObserverKt$detectDragGesturesAfterLongPressWithObserver$5(observer), $completion);
        return detectDragGesturesAfterLongPress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectDragGesturesAfterLongPress : Unit.INSTANCE;
    }

    public static final Object detectDownAndDragGesturesWithObserver(PointerInputScope $this$detectDownAndDragGesturesWithObserver, TextDragObserver observer, Continuation<? super Unit> $completion) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new LongPressTextDragObserverKt$detectDownAndDragGesturesWithObserver$2($this$detectDownAndDragGesturesWithObserver, observer, (Continuation<? super LongPressTextDragObserverKt$detectDownAndDragGesturesWithObserver$2>) null), $completion);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Object detectPreDragGesturesWithObserver(PointerInputScope $this$detectPreDragGesturesWithObserver, TextDragObserver observer, Continuation<? super Unit> $completion) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectPreDragGesturesWithObserver, new LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2(observer, (Continuation<? super LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2>) null), $completion);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Object detectDragGesturesWithObserver(PointerInputScope $this$detectDragGesturesWithObserver, TextDragObserver observer, Continuation<? super Unit> $completion) {
        Object detectDragGestures = DragGestureDetectorKt.detectDragGestures($this$detectDragGesturesWithObserver, new LongPressTextDragObserverKt$detectDragGesturesWithObserver$2(observer), new LongPressTextDragObserverKt$detectDragGesturesWithObserver$3(observer), new LongPressTextDragObserverKt$detectDragGesturesWithObserver$4(observer), new LongPressTextDragObserverKt$detectDragGesturesWithObserver$5(observer), $completion);
        return detectDragGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectDragGestures : Unit.INSTANCE;
    }
}
