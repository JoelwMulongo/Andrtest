package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 implements MeasuredItemFactory {
    final /* synthetic */ int $afterContentPadding;
    final /* synthetic */ int $beforeContentPadding;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ LazyGridItemPlacementAnimator $placementAnimator;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyLayoutMeasureScope $this_null;
    final /* synthetic */ long $visualItemOffset;

    LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1(LazyLayoutMeasureScope lazyLayoutMeasureScope, boolean z, boolean z2, int i, int i2, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j) {
        this.$this_null = lazyLayoutMeasureScope;
        this.$isVertical = z;
        this.$reverseLayout = z2;
        this.$beforeContentPadding = i;
        this.$afterContentPadding = i2;
        this.$placementAnimator = lazyGridItemPlacementAnimator;
        this.$visualItemOffset = j;
    }

    /* renamed from: createItem-PU_OBEw  reason: not valid java name */
    public final LazyGridMeasuredItem m963createItemPU_OBEw(int index, Object key, int crossAxisSize, int mainAxisSpacing, List<? extends Placeable> placeables) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(placeables, "placeables");
        LayoutDirection layoutDirection = this.$this_null.getLayoutDirection();
        return new LazyGridMeasuredItem(index, key, this.$isVertical, crossAxisSize, mainAxisSpacing, this.$reverseLayout, layoutDirection, this.$beforeContentPadding, this.$afterContentPadding, placeables, this.$placementAnimator, this.$visualItemOffset, (DefaultConstructorMarker) null);
    }
}
