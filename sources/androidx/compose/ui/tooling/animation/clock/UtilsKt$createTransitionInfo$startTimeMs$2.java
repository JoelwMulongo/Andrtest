package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.RepeatableSpec;
import androidx.compose.animation.core.SnapSpec;
import androidx.compose.animation.core.StartOffset;
import androidx.compose.animation.core.StartOffsetType;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Utils.kt */
final class UtilsKt$createTransitionInfo$startTimeMs$2 extends Lambda implements Function0<Long> {
    final /* synthetic */ AnimationSpec<T> $animationSpec;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UtilsKt$createTransitionInfo$startTimeMs$2(AnimationSpec<T> animationSpec) {
        super(0);
        this.$animationSpec = animationSpec;
    }

    public final Long invoke() {
        long j;
        AnimationSpec<T> animationSpec = this.$animationSpec;
        if (animationSpec instanceof TweenSpec) {
            j = Integer.valueOf(((TweenSpec) animationSpec).getDelay());
        } else if (animationSpec instanceof SnapSpec) {
            j = Integer.valueOf(((SnapSpec) animationSpec).getDelay());
        } else if (animationSpec instanceof KeyframesSpec) {
            j = Integer.valueOf(((KeyframesSpec) animationSpec).getConfig().getDelayMillis());
        } else if (animationSpec instanceof RepeatableSpec) {
            if (StartOffsetType.m420equalsimpl0(StartOffset.m413getOffsetTypeEo1U57Q(((RepeatableSpec) animationSpec).m404getInitialStartOffsetRmkjzm4()), StartOffsetType.Companion.m424getDelayEo1U57Q())) {
                j = Integer.valueOf(StartOffset.m412getOffsetMillisimpl(((RepeatableSpec) this.$animationSpec).m404getInitialStartOffsetRmkjzm4()));
            } else {
                j = 0L;
            }
        } else if (animationSpec instanceof InfiniteRepeatableSpec) {
            if (StartOffsetType.m420equalsimpl0(StartOffset.m413getOffsetTypeEo1U57Q(((InfiniteRepeatableSpec) animationSpec).m392getInitialStartOffsetRmkjzm4()), StartOffsetType.Companion.m424getDelayEo1U57Q())) {
                j = Integer.valueOf(StartOffset.m412getOffsetMillisimpl(((InfiniteRepeatableSpec) this.$animationSpec).m392getInitialStartOffsetRmkjzm4()));
            } else {
                j = 0L;
            }
        } else if (animationSpec instanceof VectorizedDurationBasedAnimationSpec) {
            j = Integer.valueOf(((VectorizedDurationBasedAnimationSpec) animationSpec).getDelayMillis());
        } else {
            j = 0L;
        }
        return Long.valueOf(j.longValue());
    }
}
