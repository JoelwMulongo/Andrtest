package androidx.compose.material3;

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

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bb\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0017J \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u0019\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\r\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/material3/CheckboxColors;", "", "checkedCheckmarkColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedCheckmarkColor", "checkedBoxColor", "uncheckedBoxColor", "disabledCheckedBoxColor", "disabledUncheckedBoxColor", "disabledIndeterminateBoxColor", "checkedBorderColor", "uncheckedBorderColor", "disabledBorderColor", "disabledIndeterminateBorderColor", "(JJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "borderColor", "Landroidx/compose/runtime/State;", "enabled", "", "state", "Landroidx/compose/ui/state/ToggleableState;", "borderColor$material3_release", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "boxColor", "boxColor$material3_release", "checkmarkColor", "checkmarkColor$material3_release", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Checkbox.kt */
public final class CheckboxColors {
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

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Checkbox.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            iArr[ToggleableState.On.ordinal()] = 1;
            iArr[ToggleableState.Indeterminate.ordinal()] = 2;
            iArr[ToggleableState.Off.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ CheckboxColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11);
    }

    private CheckboxColors(long checkedCheckmarkColor2, long uncheckedCheckmarkColor2, long checkedBoxColor2, long uncheckedBoxColor2, long disabledCheckedBoxColor2, long disabledUncheckedBoxColor2, long disabledIndeterminateBoxColor2, long checkedBorderColor2, long uncheckedBorderColor2, long disabledBorderColor2, long disabledIndeterminateBorderColor2) {
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

    public final State<Color> checkmarkColor$material3_release(ToggleableState state, Composer $composer, int $changed) {
        long target;
        Intrinsics.checkNotNullParameter(state, "state");
        $composer.startReplaceableGroup(-507585681);
        ComposerKt.sourceInformation($composer, "C(checkmarkColor)404@16011L61:Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-507585681, $changed, -1, "androidx.compose.material3.CheckboxColors.checkmarkColor (Checkbox.kt:396)");
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

    public final State<Color> boxColor$material3_release(boolean enabled, ToggleableState state, Composer $composer, int $changed) {
        long target;
        State<Color> state2;
        Intrinsics.checkNotNullParameter(state, "state");
        $composer.startReplaceableGroup(360729865);
        ComposerKt.sourceInformation($composer, "C(boxColor):Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(360729865, $changed, -1, "androidx.compose.material3.CheckboxColors.boxColor (Checkbox.kt:415)");
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
            $composer.startReplaceableGroup(1143718194);
            ComposerKt.sourceInformation($composer, "433@17199L61");
            state2 = SingleValueAnimationKt.m362animateColorAsStateKTwxG1Y(target, AnimationSpecKt.tween$default(state == ToggleableState.Off ? 100 : 50, 0, (Easing) null, 6, (Object) null), (Function1) null, $composer, 0, 4);
            $composer.endReplaceableGroup();
        } else {
            $composer.startReplaceableGroup(1143718380);
            ComposerKt.sourceInformation($composer, "435@17290L28");
            state2 = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(target), $composer, 0);
            $composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return state2;
    }

    public final State<Color> borderColor$material3_release(boolean enabled, ToggleableState state, Composer $composer, int $changed) {
        long target;
        State<Color> state2;
        Intrinsics.checkNotNullParameter(state, "state");
        $composer.startReplaceableGroup(1009643462);
        ComposerKt.sourceInformation($composer, "C(borderColor):Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1009643462, $changed, -1, "androidx.compose.material3.CheckboxColors.borderColor (Checkbox.kt:446)");
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
            $composer.startReplaceableGroup(1209369334);
            ComposerKt.sourceInformation($composer, "463@18402L61");
            state2 = SingleValueAnimationKt.m362animateColorAsStateKTwxG1Y(target, AnimationSpecKt.tween$default(state == ToggleableState.Off ? 100 : 50, 0, (Easing) null, 6, (Object) null), (Function1) null, $composer, 0, 4);
            $composer.endReplaceableGroup();
        } else {
            $composer.startReplaceableGroup(1209369520);
            ComposerKt.sourceInformation($composer, "465@18493L28");
            state2 = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(target), $composer, 0);
            $composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return state2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof CheckboxColors) || !Color.m3165equalsimpl0(this.checkedCheckmarkColor, ((CheckboxColors) other).checkedCheckmarkColor) || !Color.m3165equalsimpl0(this.uncheckedCheckmarkColor, ((CheckboxColors) other).uncheckedCheckmarkColor) || !Color.m3165equalsimpl0(this.checkedBoxColor, ((CheckboxColors) other).checkedBoxColor) || !Color.m3165equalsimpl0(this.uncheckedBoxColor, ((CheckboxColors) other).uncheckedBoxColor) || !Color.m3165equalsimpl0(this.disabledCheckedBoxColor, ((CheckboxColors) other).disabledCheckedBoxColor) || !Color.m3165equalsimpl0(this.disabledUncheckedBoxColor, ((CheckboxColors) other).disabledUncheckedBoxColor) || !Color.m3165equalsimpl0(this.disabledIndeterminateBoxColor, ((CheckboxColors) other).disabledIndeterminateBoxColor) || !Color.m3165equalsimpl0(this.checkedBorderColor, ((CheckboxColors) other).checkedBorderColor) || !Color.m3165equalsimpl0(this.uncheckedBorderColor, ((CheckboxColors) other).uncheckedBorderColor) || !Color.m3165equalsimpl0(this.disabledBorderColor, ((CheckboxColors) other).disabledBorderColor) || !Color.m3165equalsimpl0(this.disabledIndeterminateBorderColor, ((CheckboxColors) other).disabledIndeterminateBorderColor)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((Color.m3171hashCodeimpl(this.checkedCheckmarkColor) * 31) + Color.m3171hashCodeimpl(this.uncheckedCheckmarkColor)) * 31) + Color.m3171hashCodeimpl(this.checkedBoxColor)) * 31) + Color.m3171hashCodeimpl(this.uncheckedBoxColor)) * 31) + Color.m3171hashCodeimpl(this.disabledCheckedBoxColor)) * 31) + Color.m3171hashCodeimpl(this.disabledUncheckedBoxColor)) * 31) + Color.m3171hashCodeimpl(this.disabledIndeterminateBoxColor)) * 31) + Color.m3171hashCodeimpl(this.checkedBorderColor)) * 31) + Color.m3171hashCodeimpl(this.uncheckedBorderColor)) * 31) + Color.m3171hashCodeimpl(this.disabledBorderColor)) * 31) + Color.m3171hashCodeimpl(this.disabledIndeterminateBorderColor);
    }
}
