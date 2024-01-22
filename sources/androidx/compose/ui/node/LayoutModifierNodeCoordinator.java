package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 :2\u00020\u0001:\u0003:;<B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0017H\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0017H\u0016J\u001d\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0017H\u0016J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0017H\u0016J\b\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020.H\u0016J@\u0010/\u001a\u00020+2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0019\u00104\u001a\u0015\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020+\u0018\u000105¢\u0006\u0002\b7H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00109R$\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006="}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "Landroidx/compose/ui/node/NodeCoordinator;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "measureNode", "Landroidx/compose/ui/node/LayoutModifierNode;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/LayoutModifierNode;)V", "<set-?>", "layoutModifierNode", "getLayoutModifierNode", "()Landroidx/compose/ui/node/LayoutModifierNode;", "setLayoutModifierNode$ui_release", "(Landroidx/compose/ui/node/LayoutModifierNode;)V", "lookAheadTransientMeasureNode", "Landroidx/compose/ui/node/IntermediateLayoutModifierNode;", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrappedNonNull", "getWrappedNonNull", "()Landroidx/compose/ui/node/NodeCoordinator;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "createLookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "scope", "Landroidx/compose/ui/layout/LookaheadScope;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "onLayoutModifierNodeChanged", "", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "Companion", "LookaheadDelegateForIntermediateLayoutModifier", "LookaheadDelegateForLayoutModifierNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutModifierNodeCoordinator.kt */
public final class LayoutModifierNodeCoordinator extends NodeCoordinator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Paint modifierBoundsPaint;
    private LayoutModifierNode layoutModifierNode;
    private IntermediateLayoutModifierNode lookAheadTransientMeasureNode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutModifierNodeCoordinator(LayoutNode layoutNode, LayoutModifierNode measureNode) {
        super(layoutNode);
        IntermediateLayoutModifierNode intermediateLayoutModifierNode;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Intrinsics.checkNotNullParameter(measureNode, "measureNode");
        this.layoutModifierNode = measureNode;
        LayoutModifierNode $this$lookAheadTransientMeasureNode_u24lambda_u240 = measureNode;
        if (!(($this$lookAheadTransientMeasureNode_u24lambda_u240.getNode().getKindSet$ui_release() & NodeKind.m5123constructorimpl(512)) != 0) || !($this$lookAheadTransientMeasureNode_u24lambda_u240 instanceof IntermediateLayoutModifierNode)) {
            intermediateLayoutModifierNode = null;
        } else {
            intermediateLayoutModifierNode = (IntermediateLayoutModifierNode) $this$lookAheadTransientMeasureNode_u24lambda_u240;
        }
        this.lookAheadTransientMeasureNode = intermediateLayoutModifierNode;
    }

    public final LayoutModifierNode getLayoutModifierNode() {
        return this.layoutModifierNode;
    }

    public final void setLayoutModifierNode$ui_release(LayoutModifierNode layoutModifierNode2) {
        Intrinsics.checkNotNullParameter(layoutModifierNode2, "<set-?>");
        this.layoutModifierNode = layoutModifierNode2;
    }

    public Modifier.Node getTail() {
        return this.layoutModifierNode.getNode();
    }

    public final NodeCoordinator getWrappedNonNull() {
        NodeCoordinator wrapped$ui_release = getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        return wrapped$ui_release;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$LookaheadDelegateForLayoutModifierNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "scope", "Landroidx/compose/ui/layout/LookaheadScope;", "(Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;Landroidx/compose/ui/layout/LookaheadScope;)V", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutModifierNodeCoordinator.kt */
    private final class LookaheadDelegateForLayoutModifierNode extends LookaheadDelegate {
        final /* synthetic */ LayoutModifierNodeCoordinator this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LookaheadDelegateForLayoutModifierNode(LayoutModifierNodeCoordinator this$02, LookaheadScope scope) {
            super(this$02, scope);
            Intrinsics.checkNotNullParameter(scope, "scope");
            this.this$0 = this$02;
        }

        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m4994measureBRTryo0(long constraints) {
            LookaheadDelegate this_$iv = this;
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = this.this$0;
            this_$iv.m4902setMeasurementConstraintsBRTryo0(constraints);
            LookaheadDelegate lookaheadDelegate$ui_release = layoutModifierNodeCoordinator.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            this_$iv.set_measureResult(layoutModifierNodeCoordinator.getLayoutModifierNode().m4990measure3p2s80s(this, lookaheadDelegate$ui_release, constraints));
            return this_$iv;
        }

        public int calculateAlignmentLine(AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            int it = LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
            getCachedAlignmentLinesMap().put(alignmentLine, Integer.valueOf(it));
            return it;
        }

        public int minIntrinsicWidth(int height) {
            LayoutModifierNode $this$minIntrinsicWidth_u24lambda_u243 = this.this$0.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return $this$minIntrinsicWidth_u24lambda_u243.minIntrinsicWidth(this, lookaheadDelegate$ui_release, height);
        }

        public int maxIntrinsicWidth(int height) {
            LayoutModifierNode $this$maxIntrinsicWidth_u24lambda_u244 = this.this$0.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return $this$maxIntrinsicWidth_u24lambda_u244.maxIntrinsicWidth(this, lookaheadDelegate$ui_release, height);
        }

        public int minIntrinsicHeight(int width) {
            LayoutModifierNode $this$minIntrinsicHeight_u24lambda_u245 = this.this$0.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return $this$minIntrinsicHeight_u24lambda_u245.minIntrinsicHeight(this, lookaheadDelegate$ui_release, width);
        }

        public int maxIntrinsicHeight(int width) {
            LayoutModifierNode $this$maxIntrinsicHeight_u24lambda_u246 = this.this$0.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return $this$maxIntrinsicHeight_u24lambda_u246.maxIntrinsicHeight(this, lookaheadDelegate$ui_release, width);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001d\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n0\nR\u00060\u0000R\u00020\u000bX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$LookaheadDelegateForIntermediateLayoutModifier;", "Landroidx/compose/ui/node/LookaheadDelegate;", "scope", "Landroidx/compose/ui/layout/LookaheadScope;", "intermediateMeasureNode", "Landroidx/compose/ui/node/IntermediateLayoutModifierNode;", "(Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;Landroidx/compose/ui/layout/LookaheadScope;Landroidx/compose/ui/node/IntermediateLayoutModifierNode;)V", "getIntermediateMeasureNode", "()Landroidx/compose/ui/node/IntermediateLayoutModifierNode;", "passThroughMeasureResult", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$LookaheadDelegateForIntermediateLayoutModifier$PassThroughMeasureResult;", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "PassThroughMeasureResult", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutModifierNodeCoordinator.kt */
    private final class LookaheadDelegateForIntermediateLayoutModifier extends LookaheadDelegate {
        private final IntermediateLayoutModifierNode intermediateMeasureNode;
        private final PassThroughMeasureResult passThroughMeasureResult = new PassThroughMeasureResult();
        final /* synthetic */ LayoutModifierNodeCoordinator this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LookaheadDelegateForIntermediateLayoutModifier(LayoutModifierNodeCoordinator this$02, LookaheadScope scope, IntermediateLayoutModifierNode intermediateMeasureNode2) {
            super(this$02, scope);
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(intermediateMeasureNode2, "intermediateMeasureNode");
            this.this$0 = this$02;
            this.intermediateMeasureNode = intermediateMeasureNode2;
        }

        public final IntermediateLayoutModifierNode getIntermediateMeasureNode() {
            return this.intermediateMeasureNode;
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$LookaheadDelegateForIntermediateLayoutModifier$PassThroughMeasureResult;", "Landroidx/compose/ui/layout/MeasureResult;", "(Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$LookaheadDelegateForIntermediateLayoutModifier;)V", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "()I", "width", "getWidth", "placeChildren", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: LayoutModifierNodeCoordinator.kt */
        private final class PassThroughMeasureResult implements MeasureResult {
            private final Map<AlignmentLine, Integer> alignmentLines = MapsKt.emptyMap();

            public PassThroughMeasureResult() {
            }

            public int getWidth() {
                LookaheadDelegate lookaheadDelegate$ui_release = LookaheadDelegateForIntermediateLayoutModifier.this.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
                return lookaheadDelegate$ui_release.getMeasureResult$ui_release().getWidth();
            }

            public int getHeight() {
                LookaheadDelegate lookaheadDelegate$ui_release = LookaheadDelegateForIntermediateLayoutModifier.this.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
                return lookaheadDelegate$ui_release.getMeasureResult$ui_release().getHeight();
            }

            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return this.alignmentLines;
            }

            public void placeChildren() {
                Placeable.PlacementScope.Companion $this$placeChildren_u24lambda_u240 = Placeable.PlacementScope.Companion;
                LookaheadDelegate lookaheadDelegate$ui_release = LookaheadDelegateForIntermediateLayoutModifier.this.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
                Placeable.PlacementScope.place$default($this$placeChildren_u24lambda_u240, lookaheadDelegate$ui_release, 0, 0, 0.0f, 4, (Object) null);
            }
        }

        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m4993measureBRTryo0(long constraints) {
            IntermediateLayoutModifierNode $this$measure_BRTryo0_u24lambda_u242 = this.intermediateMeasureNode;
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = this.this$0;
            LookaheadDelegate this_$iv = this;
            this_$iv.m4902setMeasurementConstraintsBRTryo0(constraints);
            LookaheadDelegate $this$measure_BRTryo0_u24lambda_u242_u24lambda_u241_u24lambda_u240 = layoutModifierNodeCoordinator.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull($this$measure_BRTryo0_u24lambda_u242_u24lambda_u241_u24lambda_u240);
            $this$measure_BRTryo0_u24lambda_u242_u24lambda_u241_u24lambda_u240.m4863measureBRTryo0(constraints);
            $this$measure_BRTryo0_u24lambda_u242.m4988setTargetSizeozmzZPI(IntSizeKt.IntSize($this$measure_BRTryo0_u24lambda_u242_u24lambda_u241_u24lambda_u240.getMeasureResult$ui_release().getWidth(), $this$measure_BRTryo0_u24lambda_u242_u24lambda_u241_u24lambda_u240.getMeasureResult$ui_release().getHeight()));
            this_$iv.set_measureResult(this.passThroughMeasureResult);
            return this_$iv;
        }

        public int calculateAlignmentLine(AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            int it = LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
            getCachedAlignmentLinesMap().put(alignmentLine, Integer.valueOf(it));
            return it;
        }
    }

    public LookaheadDelegate createLookaheadDelegate(LookaheadScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        IntermediateLayoutModifierNode it = this.lookAheadTransientMeasureNode;
        if (it != null) {
            return new LookaheadDelegateForIntermediateLayoutModifier(this, scope, it);
        }
        return new LookaheadDelegateForLayoutModifierNode(this, scope);
    }

    /* renamed from: measure-BRTryo0  reason: not valid java name */
    public Placeable m4991measureBRTryo0(long constraints) {
        NodeCoordinator this_$iv = this;
        this_$iv.m4902setMeasurementConstraintsBRTryo0(constraints);
        setMeasureResult$ui_release(this.layoutModifierNode.m4990measure3p2s80s(this, getWrappedNonNull(), constraints));
        Placeable placeable = this;
        OwnedLayer layer = this_$iv.getLayer();
        if (layer != null) {
            layer.m5170resizeozmzZPI(this_$iv.m4898getMeasuredSizeYbymL2g());
        }
        onMeasured();
        return this;
    }

    public int minIntrinsicWidth(int height) {
        return this.layoutModifierNode.minIntrinsicWidth(this, getWrappedNonNull(), height);
    }

    public int maxIntrinsicWidth(int height) {
        return this.layoutModifierNode.maxIntrinsicWidth(this, getWrappedNonNull(), height);
    }

    public int minIntrinsicHeight(int width) {
        return this.layoutModifierNode.minIntrinsicHeight(this, getWrappedNonNull(), width);
    }

    public int maxIntrinsicHeight(int width) {
        return this.layoutModifierNode.maxIntrinsicHeight(this, getWrappedNonNull(), width);
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public void m4992placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        super.m5107placeAtf8xVGno(position, zIndex, layerBlock);
        if (!isShallowPlacing$ui_release()) {
            onPlaced();
            Placeable.PlacementScope.Companion this_$iv = Placeable.PlacementScope.Companion;
            int parentWidth$iv = IntSize.m6146getWidthimpl(m4898getMeasuredSizeYbymL2g());
            LayoutDirection parentLayoutDirection$iv = getLayoutDirection();
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
    }

    public void onLayoutModifierNodeChanged() {
        super.onLayoutModifierNodeChanged();
        LayoutModifierNode node = this.layoutModifierNode;
        if (!((node.getNode().getKindSet$ui_release() & NodeKind.m5123constructorimpl(512)) != 0) || !(node instanceof IntermediateLayoutModifierNode)) {
            this.lookAheadTransientMeasureNode = null;
            LookaheadDelegate it = getLookaheadDelegate$ui_release();
            if (it != null) {
                updateLookaheadDelegate(new LookaheadDelegateForLayoutModifierNode(this, it.getLookaheadScope()));
                return;
            }
            return;
        }
        this.lookAheadTransientMeasureNode = (IntermediateLayoutModifierNode) node;
        LookaheadDelegate it2 = getLookaheadDelegate$ui_release();
        if (it2 != null) {
            updateLookaheadDelegate(new LookaheadDelegateForIntermediateLayoutModifier(this, it2.getLookaheadScope(), (IntermediateLayoutModifierNode) node));
        }
    }

    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        LookaheadDelegate lookaheadDelegate$ui_release = getLookaheadDelegate$ui_release();
        if (lookaheadDelegate$ui_release != null) {
            return lookaheadDelegate$ui_release.getCachedAlignmentLine$ui_release(alignmentLine);
        }
        return LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
    }

    public void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getWrappedNonNull().draw(canvas);
        if (LayoutNodeKt.requireOwner(getLayoutNode()).getShowLayoutBounds()) {
            drawBorder(canvas, modifierBoundsPaint);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$Companion;", "", "()V", "modifierBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getModifierBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutModifierNodeCoordinator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Paint getModifierBoundsPaint() {
            return LayoutModifierNodeCoordinator.modifierBoundsPaint;
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint paint = Paint;
        paint.m3427setColor8_81llA(Color.Companion.m3191getBlue0d7_KjU());
        paint.setStrokeWidth(1.0f);
        paint.m3431setStylek9PVt8s(PaintingStyle.Companion.m3440getStrokeTiuSbCo());
        modifierBoundsPaint = Paint;
    }
}
