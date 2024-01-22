package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadLayoutCoordinatesImpl;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b \u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010I\u001a\u00020\u00142\u0006\u0010J\u001a\u00020\u0013H\u0000¢\u0006\u0002\bKJ\u0010\u0010L\u001a\u00020\u00142\u0006\u0010M\u001a\u00020\u0014H\u0016J\u0010\u0010N\u001a\u00020\u00142\u0006\u0010O\u001a\u00020\u0014H\u0016J\u0010\u0010P\u001a\u00020\u00142\u0006\u0010M\u001a\u00020\u0014H\u0016J\u0010\u0010Q\u001a\u00020\u00142\u0006\u0010O\u001a\u00020\u0014H\u0016J/\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\t0WH\bø\u0001\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010YJ@\u0010Z\u001a\u00020[2\u0006\u0010B\u001a\u00020C2\u0006\u0010\\\u001a\u00020!2\u0019\u0010]\u001a\u0015\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020[\u0018\u00010^¢\u0006\u0002\b`H\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\ba\u0010bJ\b\u0010c\u001a\u00020[H\u0014J \u0010d\u001a\u00020C2\u0006\u0010e\u001a\u00020\u0000H\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bf\u0010gJ\r\u0010h\u001a\u00020[H\u0010¢\u0006\u0002\biR\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0014\u0010&\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020/8VX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0011\u00102\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0014\u00108\u001a\u00020\t8PX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u001c\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010<\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0019R\u0016\u0010>\u001a\u0004\u0018\u00010?8VX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR%\u0010B\u001a\u00020CX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010H\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b20\u0001¨\u0006j"}, d2 = {"Landroidx/compose/ui/node/LookaheadDelegate;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "(Landroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/layout/LookaheadScope;)V", "result", "Landroidx/compose/ui/layout/MeasureResult;", "_measureResult", "set_measureResult", "(Landroidx/compose/ui/layout/MeasureResult;)V", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "cachedAlignmentLinesMap", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getCachedAlignmentLinesMap", "()Ljava/util/Map;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "lookaheadLayoutCoordinates", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinatesImpl;", "getLookaheadLayoutCoordinates", "()Landroidx/compose/ui/layout/LookaheadLayoutCoordinatesImpl;", "getLookaheadScope", "()Landroidx/compose/ui/layout/LookaheadScope;", "measureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "oldAlignmentLines", "parent", "getParent", "parentData", "", "getParentData", "()Ljava/lang/Object;", "position", "Landroidx/compose/ui/unit/IntOffset;", "getPosition-nOcc-ac", "()J", "setPosition--gyyYBs", "(J)V", "J", "getCachedAlignmentLine", "alignmentLine", "getCachedAlignmentLine$ui_release", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "block", "Lkotlin/Function0;", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "", "zIndex", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeChildren", "positionIn", "ancestor", "positionIn-Bjo55l4$ui_release", "(Landroidx/compose/ui/node/LookaheadDelegate;)J", "replace", "replace$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadDelegate.kt */
public abstract class LookaheadDelegate extends LookaheadCapablePlaceable implements Measurable {
    private MeasureResult _measureResult;
    private final Map<AlignmentLine, Integer> cachedAlignmentLinesMap = new LinkedHashMap();
    private final NodeCoordinator coordinator;
    private final LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinates = new LookaheadLayoutCoordinatesImpl(this);
    private final LookaheadScope lookaheadScope;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position = IntOffset.Companion.m6114getZeronOccac();

    public final NodeCoordinator getCoordinator() {
        return this.coordinator;
    }

    public final LookaheadScope getLookaheadScope() {
        return this.lookaheadScope;
    }

    public LookaheadDelegate(NodeCoordinator coordinator2, LookaheadScope lookaheadScope2) {
        Intrinsics.checkNotNullParameter(coordinator2, "coordinator");
        Intrinsics.checkNotNullParameter(lookaheadScope2, "lookaheadScope");
        this.coordinator = coordinator2;
        this.lookaheadScope = lookaheadScope2;
    }

    public LookaheadCapablePlaceable getChild() {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        return wrapped$ui_release != null ? wrapped$ui_release.getLookaheadDelegate$ui_release() : null;
    }

    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    /* renamed from: getPosition-nOcc-ac  reason: not valid java name */
    public long m5059getPositionnOccac() {
        return this.position;
    }

    /* renamed from: setPosition--gyyYBs  reason: not valid java name */
    public void m5063setPositiongyyYBs(long j) {
        this.position = j;
    }

    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException("LookaheadDelegate has not been measured yet when measureResult is requested.".toString());
    }

    public LayoutDirection getLayoutDirection() {
        return this.coordinator.getLayoutDirection();
    }

    public float getDensity() {
        return this.coordinator.getDensity();
    }

    public float getFontScale() {
        return this.coordinator.getFontScale();
    }

    public LookaheadCapablePlaceable getParent() {
        NodeCoordinator wrappedBy$ui_release = this.coordinator.getWrappedBy$ui_release();
        return wrappedBy$ui_release != null ? wrappedBy$ui_release.getLookaheadDelegate$ui_release() : null;
    }

    public LayoutNode getLayoutNode() {
        return this.coordinator.getLayoutNode();
    }

    public LayoutCoordinates getCoordinates() {
        return this.lookaheadLayoutCoordinates;
    }

    public final LookaheadLayoutCoordinatesImpl getLookaheadLayoutCoordinates() {
        return this.lookaheadLayoutCoordinates;
    }

    public AlignmentLinesOwner getAlignmentLinesOwner() {
        AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = this.coordinator.getLayoutNode().getLayoutDelegate$ui_release().getLookaheadAlignmentLinesOwner$ui_release();
        Intrinsics.checkNotNull(lookaheadAlignmentLinesOwner$ui_release);
        return lookaheadAlignmentLinesOwner$ui_release;
    }

    /* access modifiers changed from: private */
    public final void set_measureResult(MeasureResult result) {
        Unit unit;
        if (result != null) {
            MeasureResult it = result;
            m4901setMeasuredSizeozmzZPI(IntSizeKt.IntSize(it.getWidth(), it.getHeight()));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            m4901setMeasuredSizeozmzZPI(IntSize.Companion.m6151getZeroYbymL2g());
        }
        if (!Intrinsics.areEqual((Object) this._measureResult, (Object) result) && result != null) {
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if ((!(map == null || map.isEmpty()) || (!result.getAlignmentLines().isEmpty())) && !Intrinsics.areEqual((Object) result.getAlignmentLines(), (Object) this.oldAlignmentLines)) {
                getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
                Map oldLines = this.oldAlignmentLines;
                if (oldLines == null) {
                    oldLines = new LinkedHashMap();
                    this.oldAlignmentLines = oldLines;
                }
                oldLines.clear();
                oldLines.putAll(result.getAlignmentLines());
            }
        }
        this._measureResult = result;
    }

    /* access modifiers changed from: protected */
    public final Map<AlignmentLine, Integer> getCachedAlignmentLinesMap() {
        return this.cachedAlignmentLinesMap;
    }

    public final int getCachedAlignmentLine$ui_release(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        Integer num = this.cachedAlignmentLinesMap.get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    public void replace$ui_release() {
        m5061placeAtf8xVGno(m5059getPositionnOccac(), 0.0f, (Function1<? super GraphicsLayerScope, Unit>) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public final void m5061placeAtf8xVGno(long position2, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        if (!IntOffset.m6103equalsimpl0(m5059getPositionnOccac(), position2)) {
            m5063setPositiongyyYBs(position2);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLayoutNode().getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
            if (lookaheadPassDelegate$ui_release != null) {
                lookaheadPassDelegate$ui_release.notifyChildrenUsingCoordinatesWhilePlacing();
            }
            invalidateAlignmentLinesFromPositionChange(this.coordinator);
        }
        if (!isShallowPlacing$ui_release()) {
            placeChildren();
        }
    }

    /* access modifiers changed from: protected */
    public void placeChildren() {
        Placeable.PlacementScope.Companion this_$iv = Placeable.PlacementScope.Companion;
        int parentWidth$iv = getMeasureResult$ui_release().getWidth();
        LayoutDirection parentLayoutDirection$iv = this.coordinator.getLayoutDirection();
        LayoutCoordinates previousLayoutCoordinates$iv = Placeable.PlacementScope._coordinates;
        int previousParentWidth$iv = Placeable.PlacementScope.Companion.getParentWidth();
        LayoutDirection previousParentLayoutDirection$iv = Placeable.PlacementScope.Companion.getParentLayoutDirection();
        LayoutNodeLayoutDelegate previousLayoutDelegate$iv = Placeable.PlacementScope.layoutDelegate;
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentWidth = parentWidth$iv;
        Placeable.PlacementScope.Companion companion2 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentLayoutDirection = parentLayoutDirection$iv;
        boolean wasPlacingForAlignment$iv = this_$iv.configureForPlacingForAlignment(this);
        Placeable.PlacementScope placementScope = this_$iv;
        getMeasureResult$ui_release().placeChildren();
        setPlacingForAlignment$ui_release(wasPlacingForAlignment$iv);
        Placeable.PlacementScope.Companion companion3 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentWidth = previousParentWidth$iv;
        Placeable.PlacementScope.Companion companion4 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentLayoutDirection = previousParentLayoutDirection$iv;
        Placeable.PlacementScope._coordinates = previousLayoutCoordinates$iv;
        Placeable.PlacementScope.layoutDelegate = previousLayoutDelegate$iv;
    }

    /* renamed from: performingMeasure-K40F9xA  reason: not valid java name */
    public final Placeable m5060performingMeasureK40F9xA(long constraints, Function0<? extends MeasureResult> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        m4902setMeasurementConstraintsBRTryo0(constraints);
        set_measureResult((MeasureResult) block.invoke());
        return this;
    }

    public Object getParentData() {
        return this.coordinator.getParentData();
    }

    public int minIntrinsicWidth(int height) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate$ui_release = wrapped$ui_release.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.minIntrinsicWidth(height);
    }

    public int maxIntrinsicWidth(int height) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate$ui_release = wrapped$ui_release.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.maxIntrinsicWidth(height);
    }

    public int minIntrinsicHeight(int width) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate$ui_release = wrapped$ui_release.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.minIntrinsicHeight(width);
    }

    public int maxIntrinsicHeight(int width) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate$ui_release = wrapped$ui_release.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.maxIntrinsicHeight(width);
    }

    /* renamed from: positionIn-Bjo55l4$ui_release  reason: not valid java name */
    public final long m5062positionInBjo55l4$ui_release(LookaheadDelegate ancestor) {
        Intrinsics.checkNotNullParameter(ancestor, "ancestor");
        long aggregatedOffset = IntOffset.Companion.m6114getZeronOccac();
        LookaheadDelegate lookaheadDelegate = this;
        while (!Intrinsics.areEqual((Object) lookaheadDelegate, (Object) ancestor)) {
            long other$iv = lookaheadDelegate.m5059getPositionnOccac();
            aggregatedOffset = IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(aggregatedOffset) + IntOffset.m6104getXimpl(other$iv), IntOffset.m6105getYimpl(aggregatedOffset) + IntOffset.m6105getYimpl(other$iv));
            NodeCoordinator wrappedBy$ui_release = lookaheadDelegate.coordinator.getWrappedBy$ui_release();
            Intrinsics.checkNotNull(wrappedBy$ui_release);
            LookaheadDelegate lookaheadDelegate$ui_release = wrappedBy$ui_release.getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            lookaheadDelegate = lookaheadDelegate$ui_release;
        }
        return aggregatedOffset;
    }
}
