package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J)\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/platform/NestedScrollInteropConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "consumedScrollCache", "", "nestedScrollChildHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "interruptOngoingScrolls", "", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NestedScrollInteropConnection.kt */
public final class NestedScrollInteropConnection implements NestedScrollConnection {
    private final int[] consumedScrollCache = new int[2];
    private final NestedScrollingChildHelper nestedScrollChildHelper;
    private final View view;

    public NestedScrollInteropConnection(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.view = view2;
        NestedScrollingChildHelper $this$nestedScrollChildHelper_u24lambda_u240 = new NestedScrollingChildHelper(view2);
        $this$nestedScrollChildHelper_u24lambda_u240.setNestedScrollingEnabled(true);
        this.nestedScrollChildHelper = $this$nestedScrollChildHelper_u24lambda_u240;
        ViewCompat.setNestedScrollingEnabled(view2, true);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m5259onPreScrollOzD1aCk(long available, int source) {
        if (this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.m5263getScrollAxesk4lQ0M(available), NestedScrollInteropConnectionKt.m5265toViewTypeGyEprt8(source))) {
            ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
            this.nestedScrollChildHelper.dispatchNestedPreScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2915getXimpl(available)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2916getYimpl(available)), this.consumedScrollCache, (int[]) null, NestedScrollInteropConnectionKt.m5265toViewTypeGyEprt8(source));
            return NestedScrollInteropConnectionKt.m5264toOffsetUv8p0NA(this.consumedScrollCache, available);
        }
        long j = available;
        return Offset.Companion.m2931getZeroF1C5BW0();
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m5257onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.m5263getScrollAxesk4lQ0M(available), NestedScrollInteropConnectionKt.m5265toViewTypeGyEprt8(source))) {
            ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
            this.nestedScrollChildHelper.dispatchNestedScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2915getXimpl(consumed)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2916getYimpl(consumed)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2915getXimpl(available)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2916getYimpl(available)), (int[]) null, NestedScrollInteropConnectionKt.m5265toViewTypeGyEprt8(source), this.consumedScrollCache);
            return NestedScrollInteropConnectionKt.m5264toOffsetUv8p0NA(this.consumedScrollCache, available);
        }
        long j = available;
        return Offset.Companion.m2931getZeroF1C5BW0();
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public Object m5258onPreFlingQWom1Mo(long available, Continuation<? super Velocity> $completion) {
        long result;
        if (this.nestedScrollChildHelper.dispatchNestedPreFling(NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m6211getXimpl(available)), NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m6212getYimpl(available)))) {
            result = available;
        } else {
            result = Velocity.Companion.m6222getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m6202boximpl(result);
    }

    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public Object m5256onPostFlingRZ2iAVY(long consumed, long available, Continuation<? super Velocity> $completion) {
        long result;
        if (this.nestedScrollChildHelper.dispatchNestedFling(NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m6211getXimpl(available)), NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m6212getYimpl(available)), true)) {
            result = available;
        } else {
            result = Velocity.Companion.m6222getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m6202boximpl(result);
    }

    private final void interruptOngoingScrolls() {
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(0)) {
            this.nestedScrollChildHelper.stopNestedScroll(0);
        }
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(1)) {
            this.nestedScrollChildHelper.stopNestedScroll(1);
        }
    }
}
