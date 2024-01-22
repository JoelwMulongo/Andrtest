package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.animation.core.InfiniteTransition;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Utils.kt */
final class UtilsKt$createTransitionInfo$values$4 extends Lambda implements Function0<Map<Long, T>> {
    final /* synthetic */ long $endTimeMs;
    final /* synthetic */ long $startTimeMs;
    final /* synthetic */ long $stepMs;
    final /* synthetic */ InfiniteTransition.TransitionAnimationState<T, V> $this_createTransitionInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UtilsKt$createTransitionInfo$values$4(long j, InfiniteTransition.TransitionAnimationState<T, V> transitionAnimationState, long j2, long j3) {
        super(0);
        this.$startTimeMs = j;
        this.$this_createTransitionInfo = transitionAnimationState;
        this.$endTimeMs = j2;
        this.$stepMs = j3;
    }

    public final Map<Long, T> invoke() {
        Map values = new LinkedHashMap();
        values.put(Long.valueOf(this.$startTimeMs), this.$this_createTransitionInfo.getAnimation().getValueFromNanos(UtilsKt.millisToNanos(this.$startTimeMs)));
        values.put(Long.valueOf(this.$endTimeMs), this.$this_createTransitionInfo.getAnimation().getValueFromNanos(UtilsKt.millisToNanos(this.$endTimeMs)));
        long j = this.$stepMs;
        if (j > 0) {
            long millis = this.$startTimeMs;
            long progressionLastElement = ProgressionUtilKt.getProgressionLastElement(this.$startTimeMs, this.$endTimeMs, j);
            if (millis <= progressionLastElement) {
                while (true) {
                    values.put(Long.valueOf(millis), this.$this_createTransitionInfo.getAnimation().getValueFromNanos(UtilsKt.millisToNanos(millis)));
                    if (millis == progressionLastElement) {
                        break;
                    }
                    millis += this.$stepMs;
                }
            }
            return values;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + this.$stepMs + '.');
    }
}
