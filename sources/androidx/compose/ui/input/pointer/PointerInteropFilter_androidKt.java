package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003H\u0007\u001a,\u0010\t\u001a\u00020\u0001*\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u0003H\u0007\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0001¨\u0006\u0010"}, d2 = {"motionEventSpy", "Landroidx/compose/ui/Modifier;", "watcher", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "Lkotlin/ParameterName;", "name", "motionEvent", "", "pointerInteropFilter", "requestDisallowInterceptTouchEvent", "Landroidx/compose/ui/input/pointer/RequestDisallowInterceptTouchEvent;", "onTouchEvent", "", "view", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerInteropFilter.android.kt */
public final class PointerInteropFilter_androidKt {
    public static /* synthetic */ Modifier pointerInteropFilter$default(Modifier modifier, RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            requestDisallowInterceptTouchEvent = null;
        }
        return pointerInteropFilter(modifier, requestDisallowInterceptTouchEvent, function1);
    }

    public static final Modifier pointerInteropFilter(Modifier $this$pointerInteropFilter, RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent, Function1<? super MotionEvent, Boolean> onTouchEvent) {
        Intrinsics.checkNotNullParameter($this$pointerInteropFilter, "<this>");
        Intrinsics.checkNotNullParameter(onTouchEvent, "onTouchEvent");
        return ComposedModifierKt.composed($this$pointerInteropFilter, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PointerInteropFilter_androidKt$pointerInteropFilter$$inlined$debugInspectorInfo$1(requestDisallowInterceptTouchEvent, onTouchEvent) : InspectableValueKt.getNoInspectorInfo(), new PointerInteropFilter_androidKt$pointerInteropFilter$2(onTouchEvent, requestDisallowInterceptTouchEvent));
    }

    public static final Modifier pointerInteropFilter(Modifier $this$pointerInteropFilter, AndroidViewHolder view) {
        Intrinsics.checkNotNullParameter($this$pointerInteropFilter, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        PointerInteropFilter filter = new PointerInteropFilter();
        filter.setOnTouchEvent(new PointerInteropFilter_androidKt$pointerInteropFilter$3(view));
        RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent = new RequestDisallowInterceptTouchEvent();
        filter.setRequestDisallowInterceptTouchEvent(requestDisallowInterceptTouchEvent);
        view.setOnRequestDisallowInterceptTouchEvent$ui_release(requestDisallowInterceptTouchEvent);
        return $this$pointerInteropFilter.then(filter);
    }

    public static final Modifier motionEventSpy(Modifier $this$motionEventSpy, Function1<? super MotionEvent, Unit> watcher) {
        Intrinsics.checkNotNullParameter($this$motionEventSpy, "<this>");
        Intrinsics.checkNotNullParameter(watcher, "watcher");
        return SuspendingPointerInputFilterKt.pointerInput($this$motionEventSpy, (Object) watcher, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new PointerInteropFilter_androidKt$motionEventSpy$1(watcher, (Continuation<? super PointerInteropFilter_androidKt$motionEventSpy$1>) null));
    }
}
