package androidx.compose.ui.input.pointer;

import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a5\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a5\u0010\r\u001a\u00020\u0001*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\f\u001a=\u0010\r\u001a\u00020\u0001*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"emptyCancelMotionEventScope", "", "nowMillis", "", "block", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "toCancelMotionEventScope", "Landroidx/compose/ui/input/pointer/PointerEvent;", "offset", "Landroidx/compose/ui/geometry/Offset;", "toCancelMotionEventScope-d-4ec7I", "(Landroidx/compose/ui/input/pointer/PointerEvent;JLkotlin/jvm/functions/Function1;)V", "toMotionEventScope", "toMotionEventScope-d-4ec7I", "cancel", "", "toMotionEventScope-ubNVwUQ", "(Landroidx/compose/ui/input/pointer/PointerEvent;JLkotlin/jvm/functions/Function1;Z)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerInteropUtils.android.kt */
public final class PointerInteropUtils_androidKt {
    /* renamed from: toMotionEventScope-d-4ec7I  reason: not valid java name */
    public static final void m4727toMotionEventScoped4ec7I(PointerEvent $this$toMotionEventScope_u2dd_u2d4ec7I, long offset, Function1<? super MotionEvent, Unit> block) {
        Intrinsics.checkNotNullParameter($this$toMotionEventScope_u2dd_u2d4ec7I, "$this$toMotionEventScope");
        Intrinsics.checkNotNullParameter(block, "block");
        m4728toMotionEventScopeubNVwUQ($this$toMotionEventScope_u2dd_u2d4ec7I, offset, block, false);
    }

    /* renamed from: toCancelMotionEventScope-d-4ec7I  reason: not valid java name */
    public static final void m4726toCancelMotionEventScoped4ec7I(PointerEvent $this$toCancelMotionEventScope_u2dd_u2d4ec7I, long offset, Function1<? super MotionEvent, Unit> block) {
        Intrinsics.checkNotNullParameter($this$toCancelMotionEventScope_u2dd_u2d4ec7I, "$this$toCancelMotionEventScope");
        Intrinsics.checkNotNullParameter(block, "block");
        m4728toMotionEventScopeubNVwUQ($this$toCancelMotionEventScope_u2dd_u2d4ec7I, offset, block, true);
    }

    public static /* synthetic */ void emptyCancelMotionEventScope$default(long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = SystemClock.uptimeMillis();
        }
        emptyCancelMotionEventScope(j, function1);
    }

    public static final void emptyCancelMotionEventScope(long nowMillis, Function1<? super MotionEvent, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        MotionEvent motionEvent = MotionEvent.obtain(nowMillis, nowMillis, 3, 0.0f, 0.0f, 0);
        motionEvent.setSource(0);
        Intrinsics.checkNotNullExpressionValue(motionEvent, "motionEvent");
        block.invoke(motionEvent);
        motionEvent.recycle();
    }

    /* renamed from: toMotionEventScope-ubNVwUQ  reason: not valid java name */
    private static final void m4728toMotionEventScopeubNVwUQ(PointerEvent $this$toMotionEventScope_u2dubNVwUQ, long offset, Function1<? super MotionEvent, Unit> block, boolean cancel) {
        MotionEvent motionEvent = $this$toMotionEventScope_u2dubNVwUQ.getMotionEvent$ui_release();
        if (motionEvent != null) {
            MotionEvent $this$toMotionEventScope_ubNVwUQ_u24lambda_u241 = motionEvent;
            int oldAction = $this$toMotionEventScope_ubNVwUQ_u24lambda_u241.getAction();
            if (cancel) {
                $this$toMotionEventScope_ubNVwUQ_u24lambda_u241.setAction(3);
            }
            $this$toMotionEventScope_ubNVwUQ_u24lambda_u241.offsetLocation(-Offset.m2915getXimpl(offset), -Offset.m2916getYimpl(offset));
            block.invoke($this$toMotionEventScope_ubNVwUQ_u24lambda_u241);
            $this$toMotionEventScope_ubNVwUQ_u24lambda_u241.offsetLocation(Offset.m2915getXimpl(offset), Offset.m2916getYimpl(offset));
            $this$toMotionEventScope_ubNVwUQ_u24lambda_u241.setAction(oldAction);
            return;
        }
        throw new IllegalArgumentException("The PointerEvent receiver cannot have a null MotionEvent.".toString());
    }
}
