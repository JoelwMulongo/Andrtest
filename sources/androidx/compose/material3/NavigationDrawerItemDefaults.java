package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Je\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/NavigationDrawerItemDefaults;", "", "()V", "ItemPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getItemPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "selectedContainerColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContainerColor", "selectedIconColor", "unselectedIconColor", "selectedTextColor", "unselectedTextColor", "selectedBadgeColor", "unselectedBadgeColor", "colors-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationDrawerItemColors;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
/* compiled from: NavigationDrawer.kt */
public final class NavigationDrawerItemDefaults {
    public static final int $stable = 0;
    public static final NavigationDrawerItemDefaults INSTANCE = new NavigationDrawerItemDefaults();
    private static final PaddingValues ItemPadding = PaddingKt.m755PaddingValuesYgX7TsA$default(Dp.m5986constructorimpl((float) 12), 0.0f, 2, (Object) null);

    private NavigationDrawerItemDefaults() {
    }

    /* renamed from: colors-oq7We08  reason: not valid java name */
    public final NavigationDrawerItemColors m2005colorsoq7We08(long selectedContainerColor, long unselectedContainerColor, long selectedIconColor, long unselectedIconColor, long selectedTextColor, long unselectedTextColor, long selectedBadgeColor, long unselectedBadgeColor, Composer $composer, int $changed, int i) {
        long unselectedContainerColor2;
        long selectedIconColor2;
        long unselectedIconColor2;
        long selectedTextColor2;
        long unselectedTextColor2;
        long selectedBadgeColor2;
        long unselectedBadgeColor2;
        Composer composer = $composer;
        int i2 = i;
        composer.startReplaceableGroup(-1574983348);
        ComposerKt.sourceInformation(composer, "C(colors)P(1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.graphics.Color,3:c#ui.graphics.Color,7:c#ui.graphics.Color,0:c#ui.graphics.Color,4:c#ui.graphics.Color)760@29199L9,761@29290L9,762@29375L9,763@29464L9,764@29554L9,765@29648L9:NavigationDrawer.kt#uh7d8r");
        long selectedContainerColor2 = (i2 & 1) != 0 ? ColorSchemeKt.toColor(NavigationDrawerTokens.INSTANCE.getActiveIndicatorColor(), composer, 6) : selectedContainerColor;
        if ((i2 & 2) != 0) {
            unselectedContainerColor2 = ColorSchemeKt.toColor(NavigationDrawerTokens.INSTANCE.getContainerColor(), composer, 6);
        } else {
            unselectedContainerColor2 = unselectedContainerColor;
        }
        if ((i2 & 4) != 0) {
            selectedIconColor2 = ColorSchemeKt.toColor(NavigationDrawerTokens.INSTANCE.getActiveIconColor(), composer, 6);
        } else {
            selectedIconColor2 = selectedIconColor;
        }
        if ((i2 & 8) != 0) {
            unselectedIconColor2 = ColorSchemeKt.toColor(NavigationDrawerTokens.INSTANCE.getInactiveIconColor(), composer, 6);
        } else {
            unselectedIconColor2 = unselectedIconColor;
        }
        if ((i2 & 16) != 0) {
            selectedTextColor2 = ColorSchemeKt.toColor(NavigationDrawerTokens.INSTANCE.getActiveLabelTextColor(), composer, 6);
        } else {
            selectedTextColor2 = selectedTextColor;
        }
        if ((i2 & 32) != 0) {
            unselectedTextColor2 = ColorSchemeKt.toColor(NavigationDrawerTokens.INSTANCE.getInactiveLabelTextColor(), composer, 6);
        } else {
            unselectedTextColor2 = unselectedTextColor;
        }
        if ((i2 & 64) != 0) {
            selectedBadgeColor2 = selectedTextColor2;
        } else {
            selectedBadgeColor2 = selectedBadgeColor;
        }
        if ((i2 & 128) != 0) {
            unselectedBadgeColor2 = unselectedTextColor2;
        } else {
            unselectedBadgeColor2 = unselectedBadgeColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1574983348, $changed, -1, "androidx.compose.material3.NavigationDrawerItemDefaults.colors (NavigationDrawer.kt:759)");
        } else {
            int i3 = $changed;
        }
        DefaultDrawerItemsColor defaultDrawerItemsColor = new DefaultDrawerItemsColor(selectedIconColor2, unselectedIconColor2, selectedTextColor2, unselectedTextColor2, selectedContainerColor2, unselectedContainerColor2, selectedBadgeColor2, unselectedBadgeColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultDrawerItemsColor;
    }

    public final PaddingValues getItemPadding() {
        return ItemPadding;
    }
}