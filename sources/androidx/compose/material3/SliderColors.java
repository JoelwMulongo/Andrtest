package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001BZ\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001bR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/SliderColors;", "", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "(JJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "equals", "", "other", "hashCode", "", "Landroidx/compose/runtime/State;", "enabled", "thumbColor$material3_release", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "tickColor", "active", "tickColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "trackColor", "trackColor$material3_release", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Slider.kt */
public final class SliderColors {
    private final long activeTickColor;
    private final long activeTrackColor;
    private final long disabledActiveTickColor;
    private final long disabledActiveTrackColor;
    private final long disabledInactiveTickColor;
    private final long disabledInactiveTrackColor;
    private final long disabledThumbColor;
    private final long inactiveTickColor;
    private final long inactiveTrackColor;
    private final long thumbColor;

    public /* synthetic */ SliderColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10);
    }

    private SliderColors(long thumbColor2, long activeTrackColor2, long activeTickColor2, long inactiveTrackColor2, long inactiveTickColor2, long disabledThumbColor2, long disabledActiveTrackColor2, long disabledActiveTickColor2, long disabledInactiveTrackColor2, long disabledInactiveTickColor2) {
        this.thumbColor = thumbColor2;
        this.activeTrackColor = activeTrackColor2;
        this.activeTickColor = activeTickColor2;
        this.inactiveTrackColor = inactiveTrackColor2;
        this.inactiveTickColor = inactiveTickColor2;
        this.disabledThumbColor = disabledThumbColor2;
        this.disabledActiveTrackColor = disabledActiveTrackColor2;
        this.disabledActiveTickColor = disabledActiveTickColor2;
        this.disabledInactiveTrackColor = disabledInactiveTrackColor2;
        this.disabledInactiveTickColor = disabledInactiveTickColor2;
    }

    public final State<Color> thumbColor$material3_release(boolean enabled, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1917959445);
        ComposerKt.sourceInformation($composer, "C(thumbColor)1308@53323L69:Slider.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1917959445, $changed, -1, "androidx.compose.material3.SliderColors.thumbColor (Slider.kt:1307)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(enabled ? this.thumbColor : this.disabledThumbColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> trackColor$material3_release(boolean enabled, boolean active, Composer $composer, int $changed) {
        long j;
        $composer.startReplaceableGroup(760609284);
        ComposerKt.sourceInformation($composer, "C(trackColor)P(1)1313@53510L247:Slider.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(760609284, $changed, -1, "androidx.compose.material3.SliderColors.trackColor (Slider.kt:1312)");
        }
        if (enabled) {
            j = active ? this.activeTrackColor : this.inactiveTrackColor;
        } else {
            j = active ? this.disabledActiveTrackColor : this.disabledInactiveTrackColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(j), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> tickColor$material3_release(boolean enabled, boolean active, Composer $composer, int $changed) {
        long j;
        $composer.startReplaceableGroup(337026738);
        ComposerKt.sourceInformation($composer, "C(tickColor)P(1)1324@53874L243:Slider.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(337026738, $changed, -1, "androidx.compose.material3.SliderColors.tickColor (Slider.kt:1323)");
        }
        if (enabled) {
            j = active ? this.activeTickColor : this.inactiveTickColor;
        } else {
            j = active ? this.disabledActiveTickColor : this.disabledInactiveTickColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(j), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof SliderColors) || !Color.m3165equalsimpl0(this.thumbColor, ((SliderColors) other).thumbColor) || !Color.m3165equalsimpl0(this.activeTrackColor, ((SliderColors) other).activeTrackColor) || !Color.m3165equalsimpl0(this.activeTickColor, ((SliderColors) other).activeTickColor) || !Color.m3165equalsimpl0(this.inactiveTrackColor, ((SliderColors) other).inactiveTrackColor) || !Color.m3165equalsimpl0(this.inactiveTickColor, ((SliderColors) other).inactiveTickColor) || !Color.m3165equalsimpl0(this.disabledThumbColor, ((SliderColors) other).disabledThumbColor) || !Color.m3165equalsimpl0(this.disabledActiveTrackColor, ((SliderColors) other).disabledActiveTrackColor) || !Color.m3165equalsimpl0(this.disabledActiveTickColor, ((SliderColors) other).disabledActiveTickColor) || !Color.m3165equalsimpl0(this.disabledInactiveTrackColor, ((SliderColors) other).disabledInactiveTrackColor) || !Color.m3165equalsimpl0(this.disabledInactiveTickColor, ((SliderColors) other).disabledInactiveTickColor)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((Color.m3171hashCodeimpl(this.thumbColor) * 31) + Color.m3171hashCodeimpl(this.activeTrackColor)) * 31) + Color.m3171hashCodeimpl(this.activeTickColor)) * 31) + Color.m3171hashCodeimpl(this.inactiveTrackColor)) * 31) + Color.m3171hashCodeimpl(this.inactiveTickColor)) * 31) + Color.m3171hashCodeimpl(this.disabledThumbColor)) * 31) + Color.m3171hashCodeimpl(this.disabledActiveTrackColor)) * 31) + Color.m3171hashCodeimpl(this.disabledActiveTickColor)) * 31) + Color.m3171hashCodeimpl(this.disabledInactiveTrackColor)) * 31) + Color.m3171hashCodeimpl(this.disabledInactiveTickColor);
    }
}
