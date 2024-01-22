package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0002\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\u0002ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u0012\u0010\t\u001a\u00020\u0007*\u00020\u0002ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u0012\u0010\n\u001a\u00020\u0007*\u00020\u0002ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"boundsInParent", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsInRoot", "boundsInWindow", "findRootCoordinates", "positionInParent", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "positionInRoot", "positionInWindow", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutCoordinates.kt */
public final class LayoutCoordinatesKt {
    public static final long positionInRoot(LayoutCoordinates $this$positionInRoot) {
        Intrinsics.checkNotNullParameter($this$positionInRoot, "<this>");
        return $this$positionInRoot.m4841localToRootMKHz9U(Offset.Companion.m2931getZeroF1C5BW0());
    }

    public static final long positionInWindow(LayoutCoordinates $this$positionInWindow) {
        Intrinsics.checkNotNullParameter($this$positionInWindow, "<this>");
        return $this$positionInWindow.m4842localToWindowMKHz9U(Offset.Companion.m2931getZeroF1C5BW0());
    }

    public static final Rect boundsInRoot(LayoutCoordinates $this$boundsInRoot) {
        Intrinsics.checkNotNullParameter($this$boundsInRoot, "<this>");
        return LayoutCoordinates.localBoundingBoxOf$default(findRootCoordinates($this$boundsInRoot), $this$boundsInRoot, false, 2, (Object) null);
    }

    public static final Rect boundsInWindow(LayoutCoordinates $this$boundsInWindow) {
        Intrinsics.checkNotNullParameter($this$boundsInWindow, "<this>");
        LayoutCoordinates root = findRootCoordinates($this$boundsInWindow);
        Rect bounds = boundsInRoot($this$boundsInWindow);
        float rootWidth = (float) IntSize.m6146getWidthimpl(root.m4839getSizeYbymL2g());
        float rootHeight = (float) IntSize.m6145getHeightimpl(root.m4839getSizeYbymL2g());
        float boundsLeft = RangesKt.coerceIn(bounds.getLeft(), 0.0f, rootWidth);
        float boundsTop = RangesKt.coerceIn(bounds.getTop(), 0.0f, rootHeight);
        float boundsRight = RangesKt.coerceIn(bounds.getRight(), 0.0f, rootWidth);
        float boundsBottom = RangesKt.coerceIn(bounds.getBottom(), 0.0f, rootHeight);
        if (!(boundsLeft == boundsRight)) {
            if (boundsTop == boundsBottom) {
                LayoutCoordinates layoutCoordinates = root;
                Rect rect = bounds;
                float f = rootWidth;
            } else {
                long topLeft = root.m4842localToWindowMKHz9U(OffsetKt.Offset(boundsLeft, boundsTop));
                long topRight = root.m4842localToWindowMKHz9U(OffsetKt.Offset(boundsRight, boundsTop));
                long bottomRight = root.m4842localToWindowMKHz9U(OffsetKt.Offset(boundsRight, boundsBottom));
                long bottomLeft = root.m4842localToWindowMKHz9U(OffsetKt.Offset(boundsLeft, boundsBottom));
                LayoutCoordinates layoutCoordinates2 = root;
                Rect rect2 = bounds;
                float f2 = rootWidth;
                return new Rect(ComparisonsKt.minOf(Offset.m2915getXimpl(topLeft), Offset.m2915getXimpl(topRight), Offset.m2915getXimpl(bottomLeft), Offset.m2915getXimpl(bottomRight)), ComparisonsKt.minOf(Offset.m2916getYimpl(topLeft), Offset.m2916getYimpl(topRight), Offset.m2916getYimpl(bottomLeft), Offset.m2916getYimpl(bottomRight)), ComparisonsKt.maxOf(Offset.m2915getXimpl(topLeft), Offset.m2915getXimpl(topRight), Offset.m2915getXimpl(bottomLeft), Offset.m2915getXimpl(bottomRight)), ComparisonsKt.maxOf(Offset.m2916getYimpl(topLeft), Offset.m2916getYimpl(topRight), Offset.m2916getYimpl(bottomLeft), Offset.m2916getYimpl(bottomRight)));
            }
        } else {
            Rect rect3 = bounds;
            float f3 = rootWidth;
        }
        return Rect.Companion.getZero();
    }

    public static final long positionInParent(LayoutCoordinates $this$positionInParent) {
        Intrinsics.checkNotNullParameter($this$positionInParent, "<this>");
        LayoutCoordinates parentLayoutCoordinates = $this$positionInParent.getParentLayoutCoordinates();
        return parentLayoutCoordinates != null ? parentLayoutCoordinates.m4840localPositionOfR5De75A($this$positionInParent, Offset.Companion.m2931getZeroF1C5BW0()) : Offset.Companion.m2931getZeroF1C5BW0();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = androidx.compose.ui.layout.LayoutCoordinates.localBoundingBoxOf$default(r0, r4, false, 2, (java.lang.Object) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.geometry.Rect boundsInParent(androidx.compose.ui.layout.LayoutCoordinates r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.compose.ui.layout.LayoutCoordinates r0 = r4.getParentLayoutCoordinates()
            if (r0 == 0) goto L_0x0014
            r1 = 2
            r2 = 0
            r3 = 0
            androidx.compose.ui.geometry.Rect r0 = androidx.compose.ui.layout.LayoutCoordinates.localBoundingBoxOf$default(r0, r4, r3, r1, r2)
            if (r0 != 0) goto L_0x002c
        L_0x0014:
            androidx.compose.ui.geometry.Rect r0 = new androidx.compose.ui.geometry.Rect
            long r1 = r4.m4839getSizeYbymL2g()
            int r1 = androidx.compose.ui.unit.IntSize.m6146getWidthimpl(r1)
            float r1 = (float) r1
            long r2 = r4.m4839getSizeYbymL2g()
            int r2 = androidx.compose.ui.unit.IntSize.m6145getHeightimpl(r2)
            float r2 = (float) r2
            r3 = 0
            r0.<init>(r3, r3, r1, r2)
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInParent(androidx.compose.ui.layout.LayoutCoordinates):androidx.compose.ui.geometry.Rect");
    }

    public static final LayoutCoordinates findRootCoordinates(LayoutCoordinates $this$findRootCoordinates) {
        Intrinsics.checkNotNullParameter($this$findRootCoordinates, "<this>");
        LayoutCoordinates root = $this$findRootCoordinates;
        LayoutCoordinates parent = root.getParentLayoutCoordinates();
        while (parent != null) {
            root = parent;
            parent = root.getParentLayoutCoordinates();
        }
        NodeCoordinator rootCoordinator = root instanceof NodeCoordinator ? (NodeCoordinator) root : null;
        if (rootCoordinator == null) {
            return root;
        }
        for (NodeCoordinator parentCoordinator = rootCoordinator.getWrappedBy$ui_release(); parentCoordinator != null; parentCoordinator = parentCoordinator.getWrappedBy$ui_release()) {
            rootCoordinator = parentCoordinator;
        }
        return rootCoordinator;
    }
}
