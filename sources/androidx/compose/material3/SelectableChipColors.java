package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001Br\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0010J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0017J(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0017J(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0017R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\r\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\u000e\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\u000f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/material3/SelectableChipColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "leadingIconColor", "trailingIconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "(JJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "selected", "containerColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "labelColor$material3_release", "leadingIconContentColor", "leadingIconContentColor$material3_release", "trailingIconContentColor", "trailingIconContentColor$material3_release", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
/* compiled from: Chip.kt */
public final class SelectableChipColors {
    private final long containerColor;
    private final long disabledContainerColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledSelectedContainerColor;
    private final long disabledTrailingIconColor;
    private final long labelColor;
    private final long leadingIconColor;
    private final long selectedContainerColor;
    private final long selectedLabelColor;
    private final long selectedLeadingIconColor;
    private final long selectedTrailingIconColor;
    private final long trailingIconColor;

    public /* synthetic */ SelectableChipColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13);
    }

    private SelectableChipColors(long containerColor2, long labelColor2, long leadingIconColor2, long trailingIconColor2, long disabledContainerColor2, long disabledLabelColor2, long disabledLeadingIconColor2, long disabledTrailingIconColor2, long selectedContainerColor2, long disabledSelectedContainerColor2, long selectedLabelColor2, long selectedLeadingIconColor2, long selectedTrailingIconColor2) {
        this.containerColor = containerColor2;
        this.labelColor = labelColor2;
        this.leadingIconColor = leadingIconColor2;
        this.trailingIconColor = trailingIconColor2;
        this.disabledContainerColor = disabledContainerColor2;
        this.disabledLabelColor = disabledLabelColor2;
        this.disabledLeadingIconColor = disabledLeadingIconColor2;
        this.disabledTrailingIconColor = disabledTrailingIconColor2;
        this.selectedContainerColor = selectedContainerColor2;
        this.disabledSelectedContainerColor = disabledSelectedContainerColor2;
        this.selectedLabelColor = selectedLabelColor2;
        this.selectedLeadingIconColor = selectedLeadingIconColor2;
        this.selectedTrailingIconColor = selectedTrailingIconColor2;
    }

    public final State<Color> containerColor$material3_release(boolean enabled, boolean selected, Composer $composer, int $changed) {
        long target;
        $composer.startReplaceableGroup(-2126903408);
        ComposerKt.sourceInformation($composer, "C(containerColor)1890@88306L28:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2126903408, $changed, -1, "androidx.compose.material3.SelectableChipColors.containerColor (Chip.kt:1884)");
        }
        if (!enabled) {
            target = selected ? this.disabledSelectedContainerColor : this.disabledContainerColor;
        } else if (!selected) {
            target = this.containerColor;
        } else {
            target = this.selectedContainerColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(target), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> labelColor$material3_release(boolean enabled, boolean selected, Composer $composer, int $changed) {
        long target;
        $composer.startReplaceableGroup(-829231549);
        ComposerKt.sourceInformation($composer, "C(labelColor)1906@88823L28:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-829231549, $changed, -1, "androidx.compose.material3.SelectableChipColors.labelColor (Chip.kt:1900)");
        }
        if (!enabled) {
            target = this.disabledLabelColor;
        } else if (!selected) {
            target = this.labelColor;
        } else {
            target = this.selectedLabelColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(target), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> leadingIconContentColor$material3_release(boolean enabled, boolean selected, Composer $composer, int $changed) {
        long target;
        $composer.startReplaceableGroup(-1112029563);
        ComposerKt.sourceInformation($composer, "C(leadingIconContentColor)1922@89378L28:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1112029563, $changed, -1, "androidx.compose.material3.SelectableChipColors.leadingIconContentColor (Chip.kt:1916)");
        }
        if (!enabled) {
            target = this.disabledLeadingIconColor;
        } else if (!selected) {
            target = this.leadingIconColor;
        } else {
            target = this.selectedLeadingIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(target), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> trailingIconContentColor$material3_release(boolean enabled, boolean selected, Composer $composer, int $changed) {
        long target;
        $composer.startReplaceableGroup(963620819);
        ComposerKt.sourceInformation($composer, "C(trailingIconContentColor)1938@89938L28:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(963620819, $changed, -1, "androidx.compose.material3.SelectableChipColors.trailingIconContentColor (Chip.kt:1932)");
        }
        if (!enabled) {
            target = this.disabledTrailingIconColor;
        } else if (!selected) {
            target = this.trailingIconColor;
        } else {
            target = this.selectedTrailingIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(target), $composer, 0);
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
        if (other == null || !(other instanceof SelectableChipColors) || !Color.m3165equalsimpl0(this.containerColor, ((SelectableChipColors) other).containerColor) || !Color.m3165equalsimpl0(this.labelColor, ((SelectableChipColors) other).labelColor) || !Color.m3165equalsimpl0(this.leadingIconColor, ((SelectableChipColors) other).leadingIconColor) || !Color.m3165equalsimpl0(this.trailingIconColor, ((SelectableChipColors) other).trailingIconColor) || !Color.m3165equalsimpl0(this.disabledContainerColor, ((SelectableChipColors) other).disabledContainerColor) || !Color.m3165equalsimpl0(this.disabledLabelColor, ((SelectableChipColors) other).disabledLabelColor) || !Color.m3165equalsimpl0(this.disabledLeadingIconColor, ((SelectableChipColors) other).disabledLeadingIconColor) || !Color.m3165equalsimpl0(this.disabledTrailingIconColor, ((SelectableChipColors) other).disabledTrailingIconColor) || !Color.m3165equalsimpl0(this.selectedContainerColor, ((SelectableChipColors) other).selectedContainerColor) || !Color.m3165equalsimpl0(this.disabledSelectedContainerColor, ((SelectableChipColors) other).disabledSelectedContainerColor) || !Color.m3165equalsimpl0(this.selectedLabelColor, ((SelectableChipColors) other).selectedLabelColor) || !Color.m3165equalsimpl0(this.selectedLeadingIconColor, ((SelectableChipColors) other).selectedLeadingIconColor) || !Color.m3165equalsimpl0(this.selectedTrailingIconColor, ((SelectableChipColors) other).selectedTrailingIconColor)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((((((Color.m3171hashCodeimpl(this.containerColor) * 31) + Color.m3171hashCodeimpl(this.labelColor)) * 31) + Color.m3171hashCodeimpl(this.leadingIconColor)) * 31) + Color.m3171hashCodeimpl(this.trailingIconColor)) * 31) + Color.m3171hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m3171hashCodeimpl(this.disabledLabelColor)) * 31) + Color.m3171hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m3171hashCodeimpl(this.disabledTrailingIconColor)) * 31) + Color.m3171hashCodeimpl(this.selectedContainerColor)) * 31) + Color.m3171hashCodeimpl(this.disabledSelectedContainerColor)) * 31) + Color.m3171hashCodeimpl(this.selectedLabelColor)) * 31) + Color.m3171hashCodeimpl(this.selectedLeadingIconColor)) * 31) + Color.m3171hashCodeimpl(this.selectedTrailingIconColor);
    }
}
