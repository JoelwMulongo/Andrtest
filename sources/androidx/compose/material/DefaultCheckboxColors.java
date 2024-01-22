package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B`\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0016J&\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u0019\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\r\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/material/DefaultCheckboxColors;", "Landroidx/compose/material/CheckboxColors;", "checkedCheckmarkColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedCheckmarkColor", "checkedBoxColor", "uncheckedBoxColor", "disabledCheckedBoxColor", "disabledUncheckedBoxColor", "disabledIndeterminateBoxColor", "checkedBorderColor", "uncheckedBorderColor", "disabledBorderColor", "disabledIndeterminateBorderColor", "(JJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "borderColor", "Landroidx/compose/runtime/State;", "enabled", "", "state", "Landroidx/compose/ui/state/ToggleableState;", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "boxColor", "checkmarkColor", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Checkbox.kt */
final class DefaultCheckboxColors implements CheckboxColors {
    private final long checkedBorderColor;
    private final long checkedBoxColor;
    private final long checkedCheckmarkColor;
    private final long disabledBorderColor;
    private final long disabledCheckedBoxColor;
    private final long disabledIndeterminateBorderColor;
    private final long disabledIndeterminateBoxColor;
    private final long disabledUncheckedBoxColor;
    private final long uncheckedBorderColor;
    private final long uncheckedBoxColor;
    private final long uncheckedCheckmarkColor;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Checkbox.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ DefaultCheckboxColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11);
    }

    private DefaultCheckboxColors(long checkedCheckmarkColor2, long uncheckedCheckmarkColor2, long checkedBoxColor2, long uncheckedBoxColor2, long disabledCheckedBoxColor2, long disabledUncheckedBoxColor2, long disabledIndeterminateBoxColor2, long checkedBorderColor2, long uncheckedBorderColor2, long disabledBorderColor2, long disabledIndeterminateBorderColor2) {
        this.checkedCheckmarkColor = checkedCheckmarkColor2;
        this.uncheckedCheckmarkColor = uncheckedCheckmarkColor2;
        this.checkedBoxColor = checkedBoxColor2;
        this.uncheckedBoxColor = uncheckedBoxColor2;
        this.disabledCheckedBoxColor = disabledCheckedBoxColor2;
        this.disabledUncheckedBoxColor = disabledUncheckedBoxColor2;
        this.disabledIndeterminateBoxColor = disabledIndeterminateBoxColor2;
        this.checkedBorderColor = checkedBorderColor2;
        this.uncheckedBorderColor = uncheckedBorderColor2;
        this.disabledBorderColor = disabledBorderColor2;
        this.disabledIndeterminateBorderColor = disabledIndeterminateBorderColor2;
    }

    public State<Color> checkmarkColor(ToggleableState state, Composer $composer, int $changed) {
        long target;
        Intrinsics.checkNotNullParameter(state, "state");
        $composer.startReplaceableGroup(544656267);
        ComposerKt.sourceInformation($composer, "C(checkmarkColor)422@16505L61:Checkbox.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(544656267, $changed, -1, "androidx.compose.material.DefaultCheckboxColors.checkmarkColor (Checkbox.kt:414)");
        }
        if (state == ToggleableState.Off) {
            target = this.uncheckedCheckmarkColor;
        } else {
            target = this.checkedCheckmarkColor;
        }
        State<Color> r1 = SingleValueAnimationKt.m362animateColorAsStateKTwxG1Y(target, AnimationSpecKt.tween$default(state == ToggleableState.Off ? 100 : 50, 0, (Easing) null, 6, (Object) null), (Function1) null, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r1;
    }

    public State<Color> boxColor(boolean enabled, ToggleableState state, Composer $composer, int $changed) {
        long target;
        State<Color> state2;
        Intrinsics.checkNotNullParameter(state, "state");
        $composer.startReplaceableGroup(840901029);
        ComposerKt.sourceInformation($composer, "C(boxColor):Checkbox.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(840901029, $changed, -1, "androidx.compose.material.DefaultCheckboxColors.boxColor (Checkbox.kt:426)");
        }
        if (enabled) {
            switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                case 1:
                case 2:
                    target = this.checkedBoxColor;
                    break;
                case 3:
                    target = this.uncheckedBoxColor;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else {
            switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                case 1:
                    target = this.disabledCheckedBoxColor;
                    break;
                case 2:
                    target = this.disabledIndeterminateBoxColor;
                    break;
                case 3:
                    target = this.disabledUncheckedBoxColor;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        if (enabled) {
            $composer.startReplaceableGroup(-2010643468);
            ComposerKt.sourceInformation($composer, "444@17433L61");
            state2 = SingleValueAnimationKt.m362animateColorAsStateKTwxG1Y(target, AnimationSpecKt.tween$default(state == ToggleableState.Off ? 100 : 50, 0, (Easing) null, 6, (Object) null), (Function1) null, $composer, 0, 4);
            $composer.endReplaceableGroup();
        } else {
            $composer.startReplaceableGroup(-2010643282);
            ComposerKt.sourceInformation($composer, "446@17524L28");
            state2 = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(target), $composer, 0);
            $composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return state2;
    }

    public State<Color> borderColor(boolean enabled, ToggleableState state, Composer $composer, int $changed) {
        long target;
        State<Color> state2;
        Intrinsics.checkNotNullParameter(state, "state");
        $composer.startReplaceableGroup(-1568341342);
        ComposerKt.sourceInformation($composer, "C(borderColor):Checkbox.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1568341342, $changed, -1, "androidx.compose.material.DefaultCheckboxColors.borderColor (Checkbox.kt:451)");
        }
        if (enabled) {
            switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                case 1:
                case 2:
                    target = this.checkedBorderColor;
                    break;
                case 3:
                    target = this.uncheckedBorderColor;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else {
            switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                case 1:
                case 3:
                    target = this.disabledBorderColor;
                    break;
                case 2:
                    target = this.disabledIndeterminateBorderColor;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        if (enabled) {
            $composer.startReplaceableGroup(-796405227);
            ComposerKt.sourceInformation($composer, "468@18393L61");
            state2 = SingleValueAnimationKt.m362animateColorAsStateKTwxG1Y(target, AnimationSpecKt.tween$default(state == ToggleableState.Off ? 100 : 50, 0, (Easing) null, 6, (Object) null), (Function1) null, $composer, 0, 4);
            $composer.endReplaceableGroup();
        } else {
            $composer.startReplaceableGroup(-796405041);
            ComposerKt.sourceInformation($composer, "470@18484L28");
            state2 = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(target), $composer, 0);
            $composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return state2;
    }
}
