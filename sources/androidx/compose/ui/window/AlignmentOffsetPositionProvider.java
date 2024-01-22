package androidx.compose.ui.window;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J5\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/window/AlignmentOffsetPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "alignment", "Landroidx/compose/ui/Alignment;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getOffset-nOcc-ac", "()J", "J", "calculatePosition", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Popup.kt */
public final class AlignmentOffsetPositionProvider implements PopupPositionProvider {
    private final Alignment alignment;
    private final long offset;

    public /* synthetic */ AlignmentOffsetPositionProvider(Alignment alignment2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignment2, j);
    }

    private AlignmentOffsetPositionProvider(Alignment alignment2, long offset2) {
        this.alignment = alignment2;
        this.offset = offset2;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    /* renamed from: getOffset-nOcc-ac  reason: not valid java name */
    public final long m6228getOffsetnOccac() {
        return this.offset;
    }

    /* renamed from: calculatePosition-llwVHH4  reason: not valid java name */
    public long m6227calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        LayoutDirection layoutDirection2 = layoutDirection;
        Intrinsics.checkNotNullParameter(anchorBounds, "anchorBounds");
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        long popupPosition = IntOffsetKt.IntOffset(0, 0);
        LayoutDirection layoutDirection3 = layoutDirection;
        long parentAlignmentPoint = this.alignment.m2805alignKFBX0sM(IntSize.Companion.m6151getZeroYbymL2g(), IntSizeKt.IntSize(anchorBounds.getWidth(), anchorBounds.getHeight()), layoutDirection3);
        long relativePopupPos = this.alignment.m2805alignKFBX0sM(IntSize.Companion.m6151getZeroYbymL2g(), IntSizeKt.IntSize(IntSize.m6146getWidthimpl(popupContentSize), IntSize.m6145getHeightimpl(popupContentSize)), layoutDirection3);
        long other$iv = IntOffsetKt.IntOffset(anchorBounds.getLeft(), anchorBounds.getTop());
        long other$iv2 = IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(popupPosition) + IntOffset.m6104getXimpl(other$iv), IntOffset.m6105getYimpl(popupPosition) + IntOffset.m6105getYimpl(other$iv));
        long popupPosition2 = IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(other$iv2) + IntOffset.m6104getXimpl(parentAlignmentPoint), IntOffset.m6105getYimpl(other$iv2) + IntOffset.m6105getYimpl(parentAlignmentPoint));
        long other$iv3 = IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(relativePopupPos), IntOffset.m6105getYimpl(relativePopupPos));
        long popupPosition3 = IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(popupPosition2) - IntOffset.m6104getXimpl(other$iv3), IntOffset.m6105getYimpl(popupPosition2) - IntOffset.m6105getYimpl(other$iv3));
        long resolvedOffset = IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(this.offset) * (layoutDirection2 == LayoutDirection.Ltr ? 1 : -1), IntOffset.m6105getYimpl(this.offset));
        return IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(popupPosition3) + IntOffset.m6104getXimpl(resolvedOffset), IntOffset.m6105getYimpl(popupPosition3) + IntOffset.m6105getYimpl(resolvedOffset));
    }
}
