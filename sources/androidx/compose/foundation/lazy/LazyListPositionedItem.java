package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001Bn\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0019\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010'2\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000J\u000e\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u001e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-J.\u0010.\u001a\u00020\u0012*\u00020\u00122\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000300H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102R\u0011\u0010\u0016\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0014\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u001e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001aR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0019\u0010\u0011\u001a\u00020\u0012X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\"\u001a\u00020\u0003*\u00020#8BX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00063"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListPositionedItem;", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "offset", "", "index", "key", "", "size", "minMainAxisOffset", "maxMainAxisOffset", "isVertical", "", "wrappers", "", "Landroidx/compose/foundation/lazy/LazyListPlaceableWrapper;", "placementAnimator", "Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "reverseLayout", "mainAxisLayoutSize", "(IILjava/lang/Object;IIIZLjava/util/List;Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;JZILkotlin/jvm/internal/DefaultConstructorMarker;)V", "hasAnimations", "getHasAnimations", "()Z", "getIndex", "()I", "getKey", "()Ljava/lang/Object;", "getOffset", "placeablesCount", "getPlaceablesCount", "getSize", "J", "mainAxisSize", "Landroidx/compose/ui/layout/Placeable;", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "getAnimationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "getOffset-Bjo55l4", "(I)J", "place", "", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyMeasuredItem.kt */
public final class LazyListPositionedItem implements LazyListItemInfo {
    private final boolean hasAnimations;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int mainAxisLayoutSize;
    private final int maxMainAxisOffset;
    private final int minMainAxisOffset;
    private final int offset;
    private final LazyListItemPlacementAnimator placementAnimator;
    private final boolean reverseLayout;
    private final int size;
    private final long visualOffset;
    private final List<LazyListPlaceableWrapper> wrappers;

    public /* synthetic */ LazyListPositionedItem(int i, int i2, Object obj, int i3, int i4, int i5, boolean z, List list, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, long j, boolean z2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, obj, i3, i4, i5, z, list, lazyListItemPlacementAnimator, j, z2, i6);
    }

    private LazyListPositionedItem(int offset2, int index2, Object key2, int size2, int minMainAxisOffset2, int maxMainAxisOffset2, boolean isVertical2, List<LazyListPlaceableWrapper> wrappers2, LazyListItemPlacementAnimator placementAnimator2, long visualOffset2, boolean reverseLayout2, int mainAxisLayoutSize2) {
        boolean z;
        this.offset = offset2;
        this.index = index2;
        this.key = key2;
        this.size = size2;
        this.minMainAxisOffset = minMainAxisOffset2;
        this.maxMainAxisOffset = maxMainAxisOffset2;
        this.isVertical = isVertical2;
        this.wrappers = wrappers2;
        this.placementAnimator = placementAnimator2;
        this.visualOffset = visualOffset2;
        this.reverseLayout = reverseLayout2;
        this.mainAxisLayoutSize = mainAxisLayoutSize2;
        LazyListPositionedItem $this$hasAnimations_u24lambda_u241 = this;
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

    public int getOffset() {
        return this.offset;
    }

    public int getIndex() {
        return this.index;
    }

    public Object getKey() {
        return this.key;
    }

    public int getSize() {
        return this.size;
    }

    public final int getPlaceablesCount() {
        return this.wrappers.size();
    }

    /* renamed from: getOffset-Bjo55l4  reason: not valid java name */
    public final long m910getOffsetBjo55l4(int index2) {
        return this.wrappers.get(index2).m908getOffsetnOccac();
    }

    public final int getMainAxisSize(int index2) {
        return getMainAxisSize(this.wrappers.get(index2).getPlaceable());
    }

    public final FiniteAnimationSpec<IntOffset> getAnimationSpec(int index2) {
        Object parentData = this.wrappers.get(index2).getPlaceable().getParentData();
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
            Placeable placeable = this.wrappers.get(index2).getPlaceable();
            int minOffset = this.minMainAxisOffset - getMainAxisSize(placeable);
            int maxOffset = this.maxMainAxisOffset;
            if (getAnimationSpec(index2) != null) {
                int i5 = maxOffset;
                j = this.placementAnimator.m899getAnimatedOffsetYT5a7pE(getKey(), index2, minOffset, maxOffset, m910getOffsetBjo55l4(index2));
            } else {
                j = m910getOffsetBjo55l4(index2);
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
    private final long m909copy4Tuh3kE(long $this$copy_u2d4Tuh3kE, Function1<? super Integer, Integer> mainAxisMap) {
        return IntOffsetKt.IntOffset(this.isVertical ? IntOffset.m6104getXimpl($this$copy_u2d4Tuh3kE) : mainAxisMap.invoke(Integer.valueOf(IntOffset.m6104getXimpl($this$copy_u2d4Tuh3kE))).intValue(), this.isVertical ? mainAxisMap.invoke(Integer.valueOf(IntOffset.m6105getYimpl($this$copy_u2d4Tuh3kE))).intValue() : IntOffset.m6105getYimpl($this$copy_u2d4Tuh3kE));
    }
}
