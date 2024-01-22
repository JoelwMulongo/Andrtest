package androidx.compose.material3;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NavigationDrawer.kt */
final class NavigationDrawerKt$DismissibleNavigationDrawer$2$2 implements MeasurePolicy {
    final /* synthetic */ DrawerState $drawerState;

    NavigationDrawerKt$DismissibleNavigationDrawer$2$2(DrawerState drawerState) {
        this.$drawerState = drawerState;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m2014measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        Placeable sheetPlaceable = ((Measurable) measurables.get(0)).m4863measureBRTryo0(constraints);
        Placeable contentPlaceable = ((Measurable) measurables.get(1)).m4863measureBRTryo0(constraints);
        return MeasureScope.layout$default($this$Layout, contentPlaceable.getWidth(), contentPlaceable.getHeight(), (Map) null, new NavigationDrawerKt$DismissibleNavigationDrawer$2$2$measure$1(contentPlaceable, sheetPlaceable, this.$drawerState), 4, (Object) null);
    }
}
