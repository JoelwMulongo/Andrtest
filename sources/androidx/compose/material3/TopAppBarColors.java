package androidx.compose.material3;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B2\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\bJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001f\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u001f\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u001f\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\n\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/TopAppBarColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActionIconContentColor-0d7_KjU$material3_release", "()J", "J", "getNavigationIconContentColor-0d7_KjU$material3_release", "getTitleContentColor-0d7_KjU$material3_release", "colorTransitionFraction", "", "containerColor-XeAY9LY$material3_release", "(FLandroidx/compose/runtime/Composer;I)J", "equals", "", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
/* compiled from: AppBar.kt */
public final class TopAppBarColors {
    private final long actionIconContentColor;
    private final long containerColor;
    private final long navigationIconContentColor;
    private final long scrolledContainerColor;
    private final long titleContentColor;

    public /* synthetic */ TopAppBarColors(long j, long j2, long j3, long j4, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5);
    }

    private TopAppBarColors(long containerColor2, long scrolledContainerColor2, long navigationIconContentColor2, long titleContentColor2, long actionIconContentColor2) {
        this.containerColor = containerColor2;
        this.scrolledContainerColor = scrolledContainerColor2;
        this.navigationIconContentColor = navigationIconContentColor2;
        this.titleContentColor = titleContentColor2;
        this.actionIconContentColor = actionIconContentColor2;
    }

    /* renamed from: getNavigationIconContentColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m2246getNavigationIconContentColor0d7_KjU$material3_release() {
        return this.navigationIconContentColor;
    }

    /* renamed from: getTitleContentColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m2247getTitleContentColor0d7_KjU$material3_release() {
        return this.titleContentColor;
    }

    /* renamed from: getActionIconContentColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m2245getActionIconContentColor0d7_KjU$material3_release() {
        return this.actionIconContentColor;
    }

    /* renamed from: containerColor-XeAY9LY$material3_release  reason: not valid java name */
    public final long m2244containerColorXeAY9LY$material3_release(float colorTransitionFraction, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1456204135);
        ComposerKt.sourceInformation($composer, "C(containerColor):AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1456204135, $changed, -1, "androidx.compose.material3.TopAppBarColors.containerColor (AppBar.kt:897)");
        }
        long r0 = ColorKt.m3215lerpjxsXWHM(this.containerColor, this.scrolledContainerColor, EasingKt.getFastOutLinearInEasing().transform(colorTransitionFraction));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof TopAppBarColors) || !Color.m3165equalsimpl0(this.containerColor, ((TopAppBarColors) other).containerColor) || !Color.m3165equalsimpl0(this.scrolledContainerColor, ((TopAppBarColors) other).scrolledContainerColor) || !Color.m3165equalsimpl0(this.navigationIconContentColor, ((TopAppBarColors) other).navigationIconContentColor) || !Color.m3165equalsimpl0(this.titleContentColor, ((TopAppBarColors) other).titleContentColor) || !Color.m3165equalsimpl0(this.actionIconContentColor, ((TopAppBarColors) other).actionIconContentColor)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((Color.m3171hashCodeimpl(this.containerColor) * 31) + Color.m3171hashCodeimpl(this.scrolledContainerColor)) * 31) + Color.m3171hashCodeimpl(this.navigationIconContentColor)) * 31) + Color.m3171hashCodeimpl(this.titleContentColor)) * 31) + Color.m3171hashCodeimpl(this.actionIconContentColor);
    }
}
