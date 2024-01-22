package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001BN\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020%H\u0016J.\u0010&\u001a\u00020\u0003*\u00020\u00032\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050(H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u000e\u0010\u0010\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\t\u001a\u00020\nX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0019\u0010\u001b\u001a\u00020\u0005*\u00020\r8Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridPositionedItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "index", "", "lane", "key", "", "size", "Landroidx/compose/ui/unit/IntSize;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "mainAxisLayoutSize", "(JIILjava/lang/Object;JLjava/util/List;ZILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "getKey", "()Ljava/lang/Object;", "getLane", "getOffset-nOcc-ac", "()J", "J", "getSize-YbymL2g", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "place", "", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "context", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "toString", "", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasure.kt */
final class LazyStaggeredGridPositionedItem implements LazyStaggeredGridItemInfo {
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int lane;
    private final int mainAxisLayoutSize;
    private final long offset;
    private final List<Placeable> placeables;
    private final long size;

    public /* synthetic */ LazyStaggeredGridPositionedItem(long j, int i, int i2, Object obj, long j2, List list, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i, i2, obj, j2, list, z, i3);
    }

    private LazyStaggeredGridPositionedItem(long offset2, int index2, int lane2, Object key2, long size2, List<? extends Placeable> placeables2, boolean isVertical2, int mainAxisLayoutSize2) {
        this.offset = offset2;
        this.index = index2;
        this.lane = lane2;
        this.key = key2;
        this.size = size2;
        this.placeables = placeables2;
        this.isVertical = isVertical2;
        this.mainAxisLayoutSize = mainAxisLayoutSize2;
    }

    /* renamed from: getOffset-nOcc-ac  reason: not valid java name */
    public long m1058getOffsetnOccac() {
        return this.offset;
    }

    public int getIndex() {
        return this.index;
    }

    public int getLane() {
        return this.lane;
    }

    public Object getKey() {
        return this.key;
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public long m1059getSizeYbymL2g() {
        return this.size;
    }

    public final void place(Placeable.PlacementScope scope, LazyStaggeredGridMeasureContext context) {
        int index$iv;
        long $this$copy_u2d4Tuh3kE$iv;
        int i;
        int i2;
        LazyStaggeredGridPositionedItem lazyStaggeredGridPositionedItem = this;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        LazyStaggeredGridMeasureContext $this$place_u24lambda_u243 = context;
        Placeable.PlacementScope $this$place_u24lambda_u243_u24lambda_u242 = scope;
        List $this$fastForEach$iv = lazyStaggeredGridPositionedItem.placeables;
        int index$iv2 = 0;
        for (int index$iv3 = $this$fastForEach$iv.size(); index$iv2 < index$iv3; index$iv3 = index$iv3) {
            Placeable placeable = $this$fastForEach$iv.get(index$iv2);
            if ($this$place_u24lambda_u243.getReverseLayout()) {
                long $this$copy_u2d4Tuh3kE$iv2 = m1058getOffsetnOccac();
                if (this.isVertical) {
                    i = IntOffset.m6104getXimpl($this$copy_u2d4Tuh3kE$iv2);
                    index$iv = index$iv2;
                } else {
                    int mainAxisOffset = IntOffset.m6104getXimpl($this$copy_u2d4Tuh3kE$iv2);
                    int i3 = lazyStaggeredGridPositionedItem.mainAxisLayoutSize - mainAxisOffset;
                    Placeable $this$mainAxisSize$iv = placeable;
                    int i4 = mainAxisOffset;
                    index$iv = index$iv2;
                    i = i3 - (this.isVertical != 0 ? $this$mainAxisSize$iv.getHeight() : $this$mainAxisSize$iv.getWidth());
                }
                if (this.isVertical) {
                    int mainAxisOffset2 = IntOffset.m6105getYimpl($this$copy_u2d4Tuh3kE$iv2);
                    int i5 = lazyStaggeredGridPositionedItem.mainAxisLayoutSize - mainAxisOffset2;
                    Placeable $this$mainAxisSize$iv2 = placeable;
                    int i6 = mainAxisOffset2;
                    i2 = i5 - (this.isVertical != 0 ? $this$mainAxisSize$iv2.getHeight() : $this$mainAxisSize$iv2.getWidth());
                } else {
                    i2 = IntOffset.m6105getYimpl($this$copy_u2d4Tuh3kE$iv2);
                }
                $this$copy_u2d4Tuh3kE$iv = IntOffsetKt.IntOffset(i, i2);
            } else {
                index$iv = index$iv2;
                $this$copy_u2d4Tuh3kE$iv = m1058getOffsetnOccac();
            }
            long reverseLayoutAwareOffset = $this$copy_u2d4Tuh3kE$iv;
            long other$iv = $this$place_u24lambda_u243.m1045getContentOffsetnOccac();
            Placeable.PlacementScope.m4905placeRelativeWithLayeraW9wM$default($this$place_u24lambda_u243_u24lambda_u242, placeable, IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(reverseLayoutAwareOffset) + IntOffset.m6104getXimpl(other$iv), IntOffset.m6105getYimpl(reverseLayoutAwareOffset) + IntOffset.m6105getYimpl(other$iv)), 0.0f, (Function1) null, 6, (Object) null);
            index$iv2 = index$iv + 1;
            lazyStaggeredGridPositionedItem = this;
        }
    }

    private final int getMainAxisSize(Placeable $this$mainAxisSize) {
        return this.isVertical ? $this$mainAxisSize.getHeight() : $this$mainAxisSize.getWidth();
    }

    /* renamed from: copy-4Tuh3kE  reason: not valid java name */
    private final long m1057copy4Tuh3kE(long $this$copy_u2d4Tuh3kE, Function1<? super Integer, Integer> mainAxisMap) {
        return IntOffsetKt.IntOffset(this.isVertical ? IntOffset.m6104getXimpl($this$copy_u2d4Tuh3kE) : mainAxisMap.invoke(Integer.valueOf(IntOffset.m6104getXimpl($this$copy_u2d4Tuh3kE))).intValue(), this.isVertical ? mainAxisMap.invoke(Integer.valueOf(IntOffset.m6105getYimpl($this$copy_u2d4Tuh3kE))).intValue() : IntOffset.m6105getYimpl($this$copy_u2d4Tuh3kE));
    }

    public String toString() {
        return super.toString();
    }
}
