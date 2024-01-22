package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\"\u0010\t\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016J/\u0010\u000b\u001a\u00020\f*\u00020\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0013\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\"\u0010\u0014\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"androidx/compose/foundation/text/TextController$measurePolicy$1", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreText.kt */
public final class TextController$measurePolicy$1 implements MeasurePolicy {
    final /* synthetic */ TextController this$0;

    TextController$measurePolicy$1(TextController $receiver) {
        this.this$0 = $receiver;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m1190measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        TextLayoutResult prevLayout;
        Object it$iv;
        List $this$fastMapIndexedNotNull$iv;
        SelectionRegistrar access$getSelectionRegistrar$p;
        MeasureScope measureScope = $this$measure_u2d3p2s80s;
        List<? extends Measurable> list = measurables;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(list, "measurables");
        this.this$0.getState().getLayoutInvalidation();
        TextLayoutResult prevLayout2 = this.this$0.getState().getLayoutResult();
        TextLayoutResult layoutResult = this.this$0.getState().getTextDelegate().m1201layoutNN6EwU(constraints, $this$measure_u2d3p2s80s.getLayoutDirection(), prevLayout2);
        if (!Intrinsics.areEqual((Object) prevLayout2, (Object) layoutResult)) {
            this.this$0.getState().getOnTextLayout().invoke(layoutResult);
            if (prevLayout2 != null) {
                TextController textController = this.this$0;
                if (!Intrinsics.areEqual((Object) prevLayout2.getLayoutInput().getText(), (Object) layoutResult.getLayoutInput().getText()) && (access$getSelectionRegistrar$p = textController.selectionRegistrar) != null) {
                    access$getSelectionRegistrar$p.notifySelectableChange(textController.getState().getSelectableId());
                }
            }
        }
        this.this$0.getState().setLayoutResult(layoutResult);
        if (measurables.size() >= layoutResult.getPlaceholderRects().size()) {
            List placeholderRects = layoutResult.getPlaceholderRects();
            ArrayList target$iv = new ArrayList(placeholderRects.size());
            List $this$fastForEachIndexed$iv$iv = placeholderRects;
            int index$iv$iv = 0;
            int size = $this$fastForEachIndexed$iv$iv.size();
            while (index$iv$iv < size) {
                Rect rect = (Rect) $this$fastForEachIndexed$iv$iv.get(index$iv$iv);
                int index = index$iv$iv;
                if (rect != null) {
                    Rect it = rect;
                    prevLayout = prevLayout2;
                    $this$fastMapIndexedNotNull$iv = placeholderRects;
                    it$iv = new Pair(((Measurable) list.get(index)).m4863measureBRTryo0(ConstraintsKt.Constraints$default(0, (int) ((float) Math.floor((double) it.getWidth())), 0, (int) ((float) Math.floor((double) it.getHeight())), 5, (Object) null)), IntOffset.m6095boximpl(IntOffsetKt.IntOffset(MathKt.roundToInt(it.getLeft()), MathKt.roundToInt(it.getTop()))));
                } else {
                    $this$fastMapIndexedNotNull$iv = placeholderRects;
                    int i = index;
                    prevLayout = prevLayout2;
                    it$iv = null;
                }
                if (it$iv != null) {
                    target$iv.add(it$iv);
                }
                index$iv$iv++;
                list = measurables;
                placeholderRects = $this$fastMapIndexedNotNull$iv;
                prevLayout2 = prevLayout;
                long j = constraints;
            }
            List list2 = placeholderRects;
            return measureScope.layout(IntSize.m6146getWidthimpl(layoutResult.m5447getSizeYbymL2g()), IntSize.m6145getHeightimpl(layoutResult.m5447getSizeYbymL2g()), MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(layoutResult.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(layoutResult.getLastBaseline())))), new TextController$measurePolicy$1$measure$2(target$iv));
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        this.this$0.getState().getTextDelegate().layoutIntrinsics($this$minIntrinsicWidth.getLayoutDirection());
        return this.this$0.getState().getTextDelegate().getMinIntrinsicWidth();
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return IntSize.m6145getHeightimpl(TextDelegate.m1198layoutNN6EwU$default(this.this$0.getState().getTextDelegate(), ConstraintsKt.Constraints(0, width, 0, Integer.MAX_VALUE), $this$minIntrinsicHeight.getLayoutDirection(), (TextLayoutResult) null, 4, (Object) null).m5447getSizeYbymL2g());
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        this.this$0.getState().getTextDelegate().layoutIntrinsics($this$maxIntrinsicWidth.getLayoutDirection());
        return this.this$0.getState().getTextDelegate().getMaxIntrinsicWidth();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return IntSize.m6145getHeightimpl(TextDelegate.m1198layoutNN6EwU$default(this.this$0.getState().getTextDelegate(), ConstraintsKt.Constraints(0, width, 0, Integer.MAX_VALUE), $this$maxIntrinsicHeight.getLayoutDirection(), (TextLayoutResult) null, 4, (Object) null).m5447getSizeYbymL2g());
    }
}
