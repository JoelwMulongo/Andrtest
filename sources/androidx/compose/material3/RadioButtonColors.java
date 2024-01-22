package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B*\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/RadioButtonColors;", "", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledSelectedColor", "disabledUnselectedColor", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "equals", "", "other", "hashCode", "", "radioColor", "Landroidx/compose/runtime/State;", "enabled", "selected", "radioColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RadioButton.kt */
public final class RadioButtonColors {
    private final long disabledSelectedColor;
    private final long disabledUnselectedColor;
    private final long selectedColor;
    private final long unselectedColor;

    public /* synthetic */ RadioButtonColors(long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4);
    }

    private RadioButtonColors(long selectedColor2, long unselectedColor2, long disabledSelectedColor2, long disabledUnselectedColor2) {
        this.selectedColor = selectedColor2;
        this.unselectedColor = unselectedColor2;
        this.disabledSelectedColor = disabledSelectedColor2;
        this.disabledUnselectedColor = disabledUnselectedColor2;
    }

    public final State<Color> radioColor$material3_release(boolean enabled, boolean selected, Composer $composer, int $changed) {
        long target;
        State<Color> state;
        $composer.startReplaceableGroup(-1840145292);
        ComposerKt.sourceInformation($composer, "C(radioColor):RadioButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1840145292, $changed, -1, "androidx.compose.material3.RadioButtonColors.radioColor (RadioButton.kt:182)");
        }
        if (enabled && selected) {
            target = this.selectedColor;
        } else if (enabled && !selected) {
            target = this.unselectedColor;
        } else if (enabled || !selected) {
            target = this.disabledUnselectedColor;
        } else {
            target = this.disabledSelectedColor;
        }
        if (enabled) {
            $composer.startReplaceableGroup(-1943770140);
            ComposerKt.sourceInformation($composer, "193@8110L75");
            state = SingleValueAnimationKt.m362animateColorAsStateKTwxG1Y(target, AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), (Function1) null, $composer, 48, 4);
            $composer.endReplaceableGroup();
        } else {
            $composer.startReplaceableGroup(-1943770035);
            ComposerKt.sourceInformation($composer, "195@8215L28");
            state = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(target), $composer, 0);
            $composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return state;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof RadioButtonColors) || !Color.m3165equalsimpl0(this.selectedColor, ((RadioButtonColors) other).selectedColor) || !Color.m3165equalsimpl0(this.unselectedColor, ((RadioButtonColors) other).unselectedColor) || !Color.m3165equalsimpl0(this.disabledSelectedColor, ((RadioButtonColors) other).disabledSelectedColor) || !Color.m3165equalsimpl0(this.disabledUnselectedColor, ((RadioButtonColors) other).disabledUnselectedColor)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((Color.m3171hashCodeimpl(this.selectedColor) * 31) + Color.m3171hashCodeimpl(this.unselectedColor)) * 31) + Color.m3171hashCodeimpl(this.disabledSelectedColor)) * 31) + Color.m3171hashCodeimpl(this.disabledUnselectedColor);
    }
}
