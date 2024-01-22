package androidx.compose.material3;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NavigationBar.kt */
final class NavigationBarKt$placeLabelAndIcon$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ boolean $alwaysShowLabel;
    final /* synthetic */ float $animationProgress;
    final /* synthetic */ int $containerWidth;
    final /* synthetic */ Placeable $iconPlaceable;
    final /* synthetic */ int $iconX;
    final /* synthetic */ Placeable $indicatorPlaceable;
    final /* synthetic */ Placeable $indicatorRipplePlaceable;
    final /* synthetic */ Placeable $labelPlaceable;
    final /* synthetic */ int $labelX;
    final /* synthetic */ int $labelY;
    final /* synthetic */ int $offset;
    final /* synthetic */ int $rippleX;
    final /* synthetic */ int $rippleY;
    final /* synthetic */ int $selectedIconY;
    final /* synthetic */ MeasureScope $this_placeLabelAndIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationBarKt$placeLabelAndIcon$1(Placeable placeable, boolean z, float f, Placeable placeable2, int i, int i2, int i3, Placeable placeable3, int i4, int i5, Placeable placeable4, int i6, int i7, int i8, MeasureScope measureScope) {
        super(1);
        this.$indicatorPlaceable = placeable;
        this.$alwaysShowLabel = z;
        this.$animationProgress = f;
        this.$labelPlaceable = placeable2;
        this.$labelX = i;
        this.$labelY = i2;
        this.$offset = i3;
        this.$iconPlaceable = placeable3;
        this.$iconX = i4;
        this.$selectedIconY = i5;
        this.$indicatorRipplePlaceable = placeable4;
        this.$rippleX = i6;
        this.$rippleY = i7;
        this.$containerWidth = i8;
        this.$this_placeLabelAndIcon = measureScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Placeable.PlacementScope) p1);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
        if ((r10.$animationProgress == 0.0f) == false) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.ui.layout.Placeable.PlacementScope r11) {
        /*
            r10 = this;
            java.lang.String r0 = "$this$layout"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            androidx.compose.ui.layout.Placeable r2 = r10.$indicatorPlaceable
            if (r2 == 0) goto L_0x002e
            int r0 = r10.$containerWidth
            int r1 = r10.$selectedIconY
            androidx.compose.ui.layout.MeasureScope r3 = r10.$this_placeLabelAndIcon
            int r4 = r10.$offset
            r8 = 0
            int r5 = r2.getWidth()
            int r0 = r0 - r5
            int r0 = r0 / 2
            float r5 = androidx.compose.material3.NavigationBarKt.IndicatorVerticalPadding
            int r3 = r3.m5961roundToPx0680j_4(r5)
            int r9 = r1 - r3
            int r4 = r4 + r9
            r5 = 0
            r6 = 4
            r7 = 0
            r1 = r11
            r3 = r0
            androidx.compose.ui.layout.Placeable.PlacementScope.placeRelative$default(r1, r2, r3, r4, r5, r6, r7)
        L_0x002e:
            boolean r0 = r10.$alwaysShowLabel
            if (r0 != 0) goto L_0x003e
            float r0 = r10.$animationProgress
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x003b
            r0 = 1
            goto L_0x003c
        L_0x003b:
            r0 = 0
        L_0x003c:
            if (r0 != 0) goto L_0x004f
        L_0x003e:
            androidx.compose.ui.layout.Placeable r2 = r10.$labelPlaceable
            int r3 = r10.$labelX
            int r0 = r10.$labelY
            int r1 = r10.$offset
            int r4 = r0 + r1
            r5 = 0
            r6 = 4
            r7 = 0
            r1 = r11
            androidx.compose.ui.layout.Placeable.PlacementScope.placeRelative$default(r1, r2, r3, r4, r5, r6, r7)
        L_0x004f:
            androidx.compose.ui.layout.Placeable r2 = r10.$iconPlaceable
            int r3 = r10.$iconX
            int r0 = r10.$selectedIconY
            int r1 = r10.$offset
            int r4 = r0 + r1
            r5 = 0
            r6 = 4
            r7 = 0
            r1 = r11
            androidx.compose.ui.layout.Placeable.PlacementScope.placeRelative$default(r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.ui.layout.Placeable r2 = r10.$indicatorRipplePlaceable
            int r3 = r10.$rippleX
            int r0 = r10.$rippleY
            int r1 = r10.$offset
            int r4 = r0 + r1
            r1 = r11
            androidx.compose.ui.layout.Placeable.PlacementScope.placeRelative$default(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationBarKt$placeLabelAndIcon$1.invoke(androidx.compose.ui.layout.Placeable$PlacementScope):void");
    }
}
