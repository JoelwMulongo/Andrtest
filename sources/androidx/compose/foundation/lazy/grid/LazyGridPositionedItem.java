package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B~\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0019\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010,2\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000J\u0006\u0010-\u001a\u00020\u0005J\u0006\u0010.\u001a\u00020\u0005J\u0006\u0010)\u001a\u00020\u0005J\u000e\u0010)\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202J.\u00103\u001a\u00020\u0003*\u00020\u00032\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000505H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107R\u0014\u0010\t\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0016\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b%\u0010\u001aR\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u001f\u0010\n\u001a\u00020\u000bX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010#\u001a\u0004\b'\u0010\"R\u0019\u0010\u0015\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010#R\u0018\u0010(\u001a\u00020\u0005*\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00068"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "index", "", "key", "", "row", "column", "size", "Landroidx/compose/ui/unit/IntSize;", "minMainAxisOffset", "maxMainAxisOffset", "isVertical", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "visualOffset", "mainAxisLayoutSize", "reverseLayout", "(JILjava/lang/Object;IIJIIZLjava/util/List;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;JIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColumn", "()I", "hasAnimations", "getHasAnimations", "()Z", "getIndex", "getKey", "()Ljava/lang/Object;", "getOffset-nOcc-ac", "()J", "J", "placeablesCount", "getPlaceablesCount", "getRow", "getSize-YbymL2g", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "getAnimationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "getCrossAxisOffset", "getCrossAxisSize", "place", "", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridMeasuredItem.kt */
public final class LazyGridPositionedItem implements LazyGridItemInfo {
    private final int column;
    private final boolean hasAnimations;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int mainAxisLayoutSize;
    private final int maxMainAxisOffset;
    private final int minMainAxisOffset;
    private final long offset;
    private final List<Placeable> placeables;
    private final LazyGridItemPlacementAnimator placementAnimator;
    private final boolean reverseLayout;
    private final int row;
    private final long size;
    private final long visualOffset;

    public /* synthetic */ LazyGridPositionedItem(long j, int i, Object obj, int i2, int i3, long j2, int i4, int i5, boolean z, List list, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j3, int i6, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i, obj, i2, i3, j2, i4, i5, z, list, lazyGridItemPlacementAnimator, j3, i6, z2);
    }

    private LazyGridPositionedItem(long offset2, int index2, Object key2, int row2, int column2, long size2, int minMainAxisOffset2, int maxMainAxisOffset2, boolean isVertical2, List<? extends Placeable> placeables2, LazyGridItemPlacementAnimator placementAnimator2, long visualOffset2, int mainAxisLayoutSize2, boolean reverseLayout2) {
        boolean z;
        this.offset = offset2;
        this.index = index2;
        this.key = key2;
        this.row = row2;
        this.column = column2;
        this.size = size2;
        this.minMainAxisOffset = minMainAxisOffset2;
        this.maxMainAxisOffset = maxMainAxisOffset2;
        this.isVertical = isVertical2;
        this.placeables = placeables2;
        this.placementAnimator = placementAnimator2;
        this.visualOffset = visualOffset2;
        this.mainAxisLayoutSize = mainAxisLayoutSize2;
        this.reverseLayout = reverseLayout2;
        LazyGridPositionedItem $this$hasAnimations_u24lambda_u241 = this;
        int placeablesCount = $this$hasAnimations_u24lambda_u241.getPlaceablesCount();
        int index3 = 0;
        while (true) {
            if (index3 >= placeablesCount) {
                z = false;
                break;
            }
            int i = placeablesCount;
            if ($this$hasAnimations_u24lambda_u241.getAnimationSpec(index3) != null) {
                z = true;
                break;
            } else {
                index3++;
                placeablesCount = i;
            }
        }
        this.hasAnimations = z;
    }

    /* renamed from: getOffset-nOcc-ac  reason: not valid java name */
    public long m971getOffsetnOccac() {
        return this.offset;
    }

    public int getIndex() {
        return this.index;
    }

    public Object getKey() {
        return this.key;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public long m972getSizeYbymL2g() {
        return this.size;
    }

    public final int getPlaceablesCount() {
        return this.placeables.size();
    }

    public final int getMainAxisSize(int index2) {
        return getMainAxisSize(this.placeables.get(index2));
    }

    public final int getMainAxisSize() {
        return this.isVertical ? IntSize.m6145getHeightimpl(m972getSizeYbymL2g()) : IntSize.m6146getWidthimpl(m972getSizeYbymL2g());
    }

    public final int getCrossAxisSize() {
        return this.isVertical ? IntSize.m6146getWidthimpl(m972getSizeYbymL2g()) : IntSize.m6145getHeightimpl(m972getSizeYbymL2g());
    }

    public final int getCrossAxisOffset() {
        return this.isVertical ? IntOffset.m6104getXimpl(m971getOffsetnOccac()) : IntOffset.m6105getYimpl(m971getOffsetnOccac());
    }

    public final FiniteAnimationSpec<IntOffset> getAnimationSpec(int index2) {
        Object parentData = this.placeables.get(index2).getParentData();
        if (parentData instanceof FiniteAnimationSpec) {
            return (FiniteAnimationSpec) parentData;
        }
        return null;
    }

    public final boolean getHasAnimations() {
        return this.hasAnimations;
    }

    public final void place(Placeable.PlacementScope scope) {
        long j;
        int i;
        long $this$copy_u2d4Tuh3kE$iv;
        int mainAxisOffset;
        int i2;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Placeable.PlacementScope $this$place_u24lambda_u244 = scope;
        int i3 = 0;
        int placeablesCount = getPlaceablesCount();
        int i4 = 0;
        while (i4 < placeablesCount) {
            int index2 = i4;
            Placeable placeable = this.placeables.get(index2);
            int minOffset = this.minMainAxisOffset - getMainAxisSize(placeable);
            int maxOffset = this.maxMainAxisOffset;
            if (getAnimationSpec(index2) != null) {
                int i5 = maxOffset;
                j = this.placementAnimator.m957getAnimatedOffsetYT5a7pE(getKey(), index2, minOffset, maxOffset, m971getOffsetnOccac());
            } else {
                j = m971getOffsetnOccac();
            }
            long offset2 = j;
            if (this.reverseLayout) {
                long $this$copy_u2d4Tuh3kE$iv2 = offset2;
                if (this.isVertical) {
                    mainAxisOffset = IntOffset.m6104getXimpl($this$copy_u2d4Tuh3kE$iv2);
                } else {
                    mainAxisOffset = (this.mainAxisLayoutSize - IntOffset.m6104getXimpl($this$copy_u2d4Tuh3kE$iv2)) - getMainAxisSize(placeable);
                }
                if (this.isVertical != 0) {
                    i = i3;
                    i2 = (this.mainAxisLayoutSize - IntOffset.m6105getYimpl($this$copy_u2d4Tuh3kE$iv2)) - getMainAxisSize(placeable);
                } else {
                    i = i3;
                    i2 = IntOffset.m6105getYimpl($this$copy_u2d4Tuh3kE$iv2);
                }
                $this$copy_u2d4Tuh3kE$iv = IntOffsetKt.IntOffset(mainAxisOffset, i2);
            } else {
                i = i3;
                $this$copy_u2d4Tuh3kE$iv = offset2;
            }
            long reverseLayoutAwareOffset = $this$copy_u2d4Tuh3kE$iv;
            if (this.isVertical) {
                long other$iv = this.visualOffset;
                Placeable.PlacementScope.m4906placeWithLayeraW9wM$default($this$place_u24lambda_u244, placeable, IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(reverseLayoutAwareOffset) + IntOffset.m6104getXimpl(other$iv), IntOffset.m6105getYimpl(reverseLayoutAwareOffset) + IntOffset.m6105getYimpl(other$iv)), 0.0f, (Function1) null, 6, (Object) null);
                Placeable placeable2 = placeable;
            } else {
                long other$iv2 = this.visualOffset;
                Placeable.PlacementScope.m4905placeRelativeWithLayeraW9wM$default($this$place_u24lambda_u244, placeable, IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(reverseLayoutAwareOffset) + IntOffset.m6104getXimpl(other$iv2), IntOffset.m6105getYimpl(reverseLayoutAwareOffset) + IntOffset.m6105getYimpl(other$iv2)), 0.0f, (Function1) null, 6, (Object) null);
            }
            i4++;
            i3 = i;
        }
    }

    private final int getMainAxisSize(Placeable $this$mainAxisSize) {
        return this.isVertical ? $this$mainAxisSize.getHeight() : $this$mainAxisSize.getWidth();
    }

    /* renamed from: copy-4Tuh3kE  reason: not valid java name */
    private final long m970copy4Tuh3kE(long $this$copy_u2d4Tuh3kE, Function1<? super Integer, Integer> mainAxisMap) {
        return IntOffsetKt.IntOffset(this.isVertical ? IntOffset.m6104getXimpl($this$copy_u2d4Tuh3kE) : mainAxisMap.invoke(Integer.valueOf(IntOffset.m6104getXimpl($this$copy_u2d4Tuh3kE))).intValue(), this.isVertical ? mainAxisMap.invoke(Integer.valueOf(IntOffset.m6105getYimpl($this$copy_u2d4Tuh3kE))).intValue() : IntOffset.m6105getYimpl($this$copy_u2d4Tuh3kE));
    }
}
