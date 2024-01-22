package androidx.compose.foundation;

import android.view.View;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0006\u0010\u0019\u001a\u00020\u0017J\u0010\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\fR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/ExcludeFromSystemGestureModifier;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "view", "Landroid/view/View;", "exclusion", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "getExclusion", "()Lkotlin/jvm/functions/Function1;", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "setRect", "(Landroid/graphics/Rect;)V", "getView", "()Landroid/view/View;", "calcBounds", "layoutCoordinates", "findRoot", "onGloballyPositioned", "", "coordinates", "removeRect", "replaceRect", "newRect", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SystemGestureExclusion.kt */
final class ExcludeFromSystemGestureModifier implements OnGloballyPositionedModifier {
    private final Function1<LayoutCoordinates, Rect> exclusion;
    private android.graphics.Rect rect;
    private final View view;

    public ExcludeFromSystemGestureModifier(View view2, Function1<? super LayoutCoordinates, Rect> exclusion2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.view = view2;
        this.exclusion = exclusion2;
    }

    public final View getView() {
        return this.view;
    }

    public final Function1<LayoutCoordinates, Rect> getExclusion() {
        return this.exclusion;
    }

    public final android.graphics.Rect getRect() {
        return this.rect;
    }

    public final void setRect(android.graphics.Rect rect2) {
        this.rect = rect2;
    }

    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        android.graphics.Rect newRect;
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Function1<LayoutCoordinates, Rect> function1 = this.exclusion;
        if (function1 == null) {
            Rect boundsInRoot = LayoutCoordinatesKt.boundsInRoot(coordinates);
            newRect = new android.graphics.Rect(MathKt.roundToInt(boundsInRoot.getLeft()), MathKt.roundToInt(boundsInRoot.getTop()), MathKt.roundToInt(boundsInRoot.getRight()), MathKt.roundToInt(boundsInRoot.getBottom()));
        } else {
            newRect = calcBounds(coordinates, function1.invoke(coordinates));
        }
        replaceRect(newRect);
    }

    public final void removeRect() {
        replaceRect((android.graphics.Rect) null);
    }

    public final void replaceRect(android.graphics.Rect newRect) {
        boolean z = false;
        MutableVector rects = new MutableVector(new android.graphics.Rect[16], 0);
        List elements$iv = this.view.getSystemGestureExclusionRects();
        Intrinsics.checkNotNullExpressionValue(elements$iv, "view.systemGestureExclusionRects");
        MutableVector this_$iv = rects;
        this_$iv.addAll(this_$iv.getSize(), elements$iv);
        android.graphics.Rect it = this.rect;
        if (it != null) {
            rects.remove(it);
        }
        if (newRect != null && !newRect.isEmpty()) {
            z = true;
        }
        if (z) {
            rects.add(newRect);
        }
        this.view.setSystemGestureExclusionRects(rects.asMutableList());
        this.rect = newRect;
    }

    private final android.graphics.Rect calcBounds(LayoutCoordinates layoutCoordinates, Rect rect2) {
        LayoutCoordinates layoutCoordinates2 = layoutCoordinates;
        LayoutCoordinates root = findRoot(layoutCoordinates);
        long topLeft = root.m4840localPositionOfR5De75A(layoutCoordinates2, rect2.m2950getTopLeftF1C5BW0());
        long topRight = root.m4840localPositionOfR5De75A(layoutCoordinates2, rect2.m2951getTopRightF1C5BW0());
        long bottomLeft = root.m4840localPositionOfR5De75A(layoutCoordinates2, rect2.m2943getBottomLeftF1C5BW0());
        long bottomRight = root.m4840localPositionOfR5De75A(layoutCoordinates2, rect2.m2944getBottomRightF1C5BW0());
        LayoutCoordinates layoutCoordinates3 = root;
        long j = topLeft;
        return new android.graphics.Rect(MathKt.roundToInt(ComparisonsKt.minOf(Offset.m2915getXimpl(topLeft), Offset.m2915getXimpl(topRight), Offset.m2915getXimpl(bottomLeft), Offset.m2915getXimpl(bottomRight))), MathKt.roundToInt(ComparisonsKt.minOf(Offset.m2916getYimpl(topLeft), Offset.m2916getYimpl(topRight), Offset.m2916getYimpl(bottomLeft), Offset.m2916getYimpl(bottomRight))), MathKt.roundToInt(ComparisonsKt.maxOf(Offset.m2915getXimpl(topLeft), Offset.m2915getXimpl(topRight), Offset.m2915getXimpl(bottomLeft), Offset.m2915getXimpl(bottomRight))), MathKt.roundToInt(ComparisonsKt.maxOf(Offset.m2916getYimpl(topLeft), Offset.m2916getYimpl(topRight), Offset.m2916getYimpl(bottomLeft), Offset.m2916getYimpl(bottomRight))));
    }

    private final LayoutCoordinates findRoot(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates coordinates = layoutCoordinates;
        LayoutCoordinates parent = layoutCoordinates.getParentLayoutCoordinates();
        while (parent != null) {
            coordinates = parent;
            parent = coordinates.getParentLayoutCoordinates();
        }
        return coordinates;
    }
}
