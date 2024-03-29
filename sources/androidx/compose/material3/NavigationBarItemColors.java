package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B2\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016R\u001d\u0010\t\u001a\u00020\u00038@X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/NavigationBarItemColors;", "", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "selectedIndicatorColor", "unselectedIconColor", "unselectedTextColor", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "indicatorColor", "getIndicatorColor-0d7_KjU$material3_release", "()J", "J", "equals", "", "other", "hashCode", "", "iconColor", "Landroidx/compose/runtime/State;", "selected", "iconColor$material3_release", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "textColor", "textColor$material3_release", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NavigationBar.kt */
public final class NavigationBarItemColors {
    private final long selectedIconColor;
    private final long selectedIndicatorColor;
    private final long selectedTextColor;
    private final long unselectedIconColor;
    private final long unselectedTextColor;

    public /* synthetic */ NavigationBarItemColors(long j, long j2, long j3, long j4, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5);
    }

    private NavigationBarItemColors(long selectedIconColor2, long selectedTextColor2, long selectedIndicatorColor2, long unselectedIconColor2, long unselectedTextColor2) {
        this.selectedIconColor = selectedIconColor2;
        this.selectedTextColor = selectedTextColor2;
        this.selectedIndicatorColor = selectedIndicatorColor2;
        this.unselectedIconColor = unselectedIconColor2;
        this.unselectedTextColor = unselectedTextColor2;
    }

    public final State<Color> iconColor$material3_release(boolean selected, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1510597389);
        ComposerKt.sourceInformation($composer, "C(iconColor)321@13956L177:NavigationBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1510597389, $changed, -1, "androidx.compose.material3.NavigationBarItemColors.iconColor (NavigationBar.kt:320)");
        }
        State<Color> r0 = SingleValueAnimationKt.m362animateColorAsStateKTwxG1Y(selected ? this.selectedIconColor : this.unselectedIconColor, AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), (Function1) null, $composer, 48, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r0;
    }

    public final State<Color> textColor$material3_release(boolean selected, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1773887143);
        ComposerKt.sourceInformation($composer, "C(textColor)334@14396L177:NavigationBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1773887143, $changed, -1, "androidx.compose.material3.NavigationBarItemColors.textColor (NavigationBar.kt:333)");
        }
        State<Color> r0 = SingleValueAnimationKt.m362animateColorAsStateKTwxG1Y(selected ? this.selectedTextColor : this.unselectedTextColor, AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), (Function1) null, $composer, 48, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r0;
    }

    /* renamed from: getIndicatorColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m1989getIndicatorColor0d7_KjU$material3_release() {
        return this.selectedIndicatorColor;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof NavigationBarItemColors) || !Color.m3165equalsimpl0(this.selectedIconColor, ((NavigationBarItemColors) other).selectedIconColor) || !Color.m3165equalsimpl0(this.unselectedIconColor, ((NavigationBarItemColors) other).unselectedIconColor) || !Color.m3165equalsimpl0(this.selectedTextColor, ((NavigationBarItemColors) other).selectedTextColor) || !Color.m3165equalsimpl0(this.unselectedTextColor, ((NavigationBarItemColors) other).unselectedTextColor) || !Color.m3165equalsimpl0(this.selectedIndicatorColor, ((NavigationBarItemColors) other).selectedIndicatorColor)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((Color.m3171hashCodeimpl(this.selectedIconColor) * 31) + Color.m3171hashCodeimpl(this.unselectedIconColor)) * 31) + Color.m3171hashCodeimpl(this.selectedTextColor)) * 31) + Color.m3171hashCodeimpl(this.unselectedTextColor)) * 31) + Color.m3171hashCodeimpl(this.selectedIndicatorColor);
    }
}
