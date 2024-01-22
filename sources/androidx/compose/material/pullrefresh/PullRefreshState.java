package androidx.compose.material.pullrefresh;

import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B3\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\tH\u0002J\b\u00107\u001a\u00020\tH\u0002J\u0015\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\tH\u0000¢\u0006\u0002\b:J\u0015\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\tH\u0000¢\u0006\u0002\b=J\u0015\u0010>\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0014H\u0000¢\u0006\u0002\b?J\u0015\u0010@\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\bAJ\u0015\u0010B\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0002\bCR+\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u00148B@BX\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R+\u0010\u001b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t8B@BX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R+\u0010\u001f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t8B@BX\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0013\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u001b\u0010#\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b$\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R+\u0010'\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t8B@BX\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0013\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u000fR\u0011\u0010/\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b0\u0010\u000fR\u0014\u00101\u001a\u00020\u00148@X\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0017R\u0014\u0010\n\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u000f¨\u0006D"}, d2 = {"Landroidx/compose/material/pullrefresh/PullRefreshState;", "", "animationScope", "Lkotlinx/coroutines/CoroutineScope;", "onRefreshState", "Landroidx/compose/runtime/State;", "Lkotlin/Function0;", "", "refreshingOffset", "", "threshold", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/State;FF)V", "<set-?>", "_position", "get_position", "()F", "set_position", "(F)V", "_position$delegate", "Landroidx/compose/runtime/MutableState;", "", "_refreshing", "get_refreshing", "()Z", "set_refreshing", "(Z)V", "_refreshing$delegate", "_refreshingOffset", "get_refreshingOffset", "set_refreshingOffset", "_refreshingOffset$delegate", "_threshold", "get_threshold", "set_threshold", "_threshold$delegate", "adjustedDistancePulled", "getAdjustedDistancePulled", "adjustedDistancePulled$delegate", "Landroidx/compose/runtime/State;", "distancePulled", "getDistancePulled", "setDistancePulled", "distancePulled$delegate", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "position", "getPosition$material_release", "progress", "getProgress", "refreshing", "getRefreshing$material_release", "getThreshold$material_release", "animateIndicatorTo", "Lkotlinx/coroutines/Job;", "offset", "calculateIndicatorPosition", "onPull", "pullDelta", "onPull$material_release", "onRelease", "velocity", "onRelease$material_release", "setRefreshing", "setRefreshing$material_release", "setRefreshingOffset", "setRefreshingOffset$material_release", "setThreshold", "setThreshold$material_release", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullRefreshState.kt */
public final class PullRefreshState {
    public static final int $stable = 8;
    private final MutableState _position$delegate;
    private final MutableState _refreshing$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState _refreshingOffset$delegate;
    private final MutableState _threshold$delegate;
    private final State adjustedDistancePulled$delegate = SnapshotStateKt.derivedStateOf(new PullRefreshState$adjustedDistancePulled$2(this));
    private final CoroutineScope animationScope;
    private final MutableState distancePulled$delegate;
    /* access modifiers changed from: private */
    public final MutatorMutex mutatorMutex;
    private final State<Function0<Unit>> onRefreshState;

    public PullRefreshState(CoroutineScope animationScope2, State<? extends Function0<Unit>> onRefreshState2, float refreshingOffset, float threshold) {
        Intrinsics.checkNotNullParameter(animationScope2, "animationScope");
        Intrinsics.checkNotNullParameter(onRefreshState2, "onRefreshState");
        this.animationScope = animationScope2;
        this.onRefreshState = onRefreshState2;
        Float valueOf = Float.valueOf(0.0f);
        this._position$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.distancePulled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, (SnapshotMutationPolicy) null, 2, (Object) null);
        this._threshold$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(threshold), (SnapshotMutationPolicy) null, 2, (Object) null);
        this._refreshingOffset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(refreshingOffset), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.mutatorMutex = new MutatorMutex();
    }

    public final float getProgress() {
        return getAdjustedDistancePulled() / getThreshold$material_release();
    }

    public final boolean getRefreshing$material_release() {
        return get_refreshing();
    }

    public final float getPosition$material_release() {
        return get_position();
    }

    public final float getThreshold$material_release() {
        return get_threshold();
    }

    private final float getAdjustedDistancePulled() {
        return ((Number) this.adjustedDistancePulled$delegate.getValue()).floatValue();
    }

    private final boolean get_refreshing() {
        return ((Boolean) this._refreshing$delegate.getValue()).booleanValue();
    }

    private final void set_refreshing(boolean z) {
        this._refreshing$delegate.setValue(Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public final float get_position() {
        return ((Number) this._position$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public final void set_position(float f) {
        this._position$delegate.setValue(Float.valueOf(f));
    }

    /* access modifiers changed from: private */
    public final float getDistancePulled() {
        return ((Number) this.distancePulled$delegate.getValue()).floatValue();
    }

    private final void setDistancePulled(float f) {
        this.distancePulled$delegate.setValue(Float.valueOf(f));
    }

    private final float get_threshold() {
        return ((Number) this._threshold$delegate.getValue()).floatValue();
    }

    private final void set_threshold(float f) {
        this._threshold$delegate.setValue(Float.valueOf(f));
    }

    private final float get_refreshingOffset() {
        return ((Number) this._refreshingOffset$delegate.getValue()).floatValue();
    }

    private final void set_refreshingOffset(float f) {
        this._refreshingOffset$delegate.setValue(Float.valueOf(f));
    }

    public final float onPull$material_release(float pullDelta) {
        if (get_refreshing()) {
            return 0.0f;
        }
        float newOffset = RangesKt.coerceAtLeast(getDistancePulled() + pullDelta, 0.0f);
        float dragConsumed = newOffset - getDistancePulled();
        setDistancePulled(newOffset);
        set_position(calculateIndicatorPosition());
        return dragConsumed;
    }

    public final float onRelease$material_release(float velocity) {
        float consumed;
        if (getRefreshing$material_release()) {
            return 0.0f;
        }
        if (getAdjustedDistancePulled() > getThreshold$material_release()) {
            this.onRefreshState.getValue().invoke();
        }
        animateIndicatorTo(0.0f);
        if (getDistancePulled() == 0.0f) {
            consumed = 0.0f;
        } else if (velocity < 0.0f) {
            consumed = 0.0f;
        } else {
            consumed = velocity;
        }
        setDistancePulled(0.0f);
        return consumed;
    }

    public final void setRefreshing$material_release(boolean refreshing) {
        if (get_refreshing() != refreshing) {
            set_refreshing(refreshing);
            float f = 0.0f;
            setDistancePulled(0.0f);
            if (refreshing) {
                f = get_refreshingOffset();
            }
            animateIndicatorTo(f);
        }
    }

    public final void setThreshold$material_release(float threshold) {
        set_threshold(threshold);
    }

    public final void setRefreshingOffset$material_release(float refreshingOffset) {
        if (!(get_refreshingOffset() == refreshingOffset)) {
            set_refreshingOffset(refreshingOffset);
            if (getRefreshing$material_release()) {
                animateIndicatorTo(refreshingOffset);
            }
        }
    }

    private final Job animateIndicatorTo(float offset) {
        return BuildersKt__Builders_commonKt.launch$default(this.animationScope, (CoroutineContext) null, (CoroutineStart) null, new PullRefreshState$animateIndicatorTo$1(this, offset, (Continuation<? super PullRefreshState$animateIndicatorTo$1>) null), 3, (Object) null);
    }

    private final float calculateIndicatorPosition() {
        if (getAdjustedDistancePulled() <= getThreshold$material_release()) {
            return getAdjustedDistancePulled();
        }
        float linearTension = RangesKt.coerceIn(Math.abs(getProgress()) - 1.0f, 0.0f, 2.0f);
        float threshold$material_release = getThreshold$material_release();
        return getThreshold$material_release() + (threshold$material_release * (linearTension - (((float) Math.pow((double) linearTension, (double) 2)) / ((float) 4))));
    }
}
