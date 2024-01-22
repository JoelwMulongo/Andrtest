package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 <2\u00020\u0001:\u0002<=B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016JS\u0010\u0013\u001a\u00020\u0014\"\b\b\u0000\u0010\u0015*\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00150\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\fH\u0016J\u0010\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH\u0016J\u001d\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\f2\u0006\u0010#\u001a\u00020\fH\u0016J\u0010\u0010-\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH\u0016J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u000200H\u0016J@\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0019\u00106\u001a\u0015\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u0014\u0018\u000107¢\u0006\u0002\b9H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u0010;R\u001a\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006>"}, d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator;", "Landroidx/compose/ui/node/NodeCoordinator;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail$annotations", "()V", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "createLookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "scope", "Landroidx/compose/ui/layout/LookaheadScope;", "hitTestChild", "", "T", "Landroidx/compose/ui/node/DelegatableNode;", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "hitTestChild-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "Companion", "LookaheadDelegateImpl", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InnerNodeCoordinator.kt */
public final class InnerNodeCoordinator extends NodeCoordinator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Paint innerBoundsPaint;
    private final Modifier.Node tail = new InnerNodeCoordinator$tail$1();

    public static /* synthetic */ void getTail$annotations() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InnerNodeCoordinator(LayoutNode layoutNode) {
        super(layoutNode);
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        getTail().updateCoordinator$ui_release(this);
    }

    public Modifier.Node getTail() {
        return this.tail;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0014\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator$LookaheadDelegateImpl;", "Landroidx/compose/ui/node/LookaheadDelegate;", "scope", "Landroidx/compose/ui/layout/LookaheadScope;", "(Landroidx/compose/ui/node/InnerNodeCoordinator;Landroidx/compose/ui/layout/LookaheadScope;)V", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "placeChildren", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: InnerNodeCoordinator.kt */
    private final class LookaheadDelegateImpl extends LookaheadDelegate {
        final /* synthetic */ InnerNodeCoordinator this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LookaheadDelegateImpl(InnerNodeCoordinator this$02, LookaheadScope scope) {
            super(this$02, scope);
            Intrinsics.checkNotNullParameter(scope, "scope");
            this.this$0 = this$02;
        }

        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m4986measureBRTryo0(long constraints) {
            LookaheadDelegate this_$iv = this;
            this_$iv.m4902setMeasurementConstraintsBRTryo0(constraints);
            MutableVector this_$iv$iv = getLayoutNode().get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    ((LayoutNode) content$iv$iv[i$iv$iv]).setMeasuredByParentInLookahead$ui_release(LayoutNode.UsageByParent.NotUsed);
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
            this_$iv.set_measureResult(getLayoutNode().getMeasurePolicy().m4864measure3p2s80s(this, getLayoutNode().getChildLookaheadMeasurables$ui_release(), constraints));
            return this_$iv;
        }

        public int calculateAlignmentLine(AlignmentLine alignmentLine) {
            int it;
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            Integer num = getAlignmentLinesOwner().calculateAlignmentLines().get(alignmentLine);
            if (num != null) {
                it = num.intValue();
            } else {
                it = Integer.MIN_VALUE;
            }
            getCachedAlignmentLinesMap().put(alignmentLine, Integer.valueOf(it));
            return it;
        }

        /* access modifiers changed from: protected */
        public void placeChildren() {
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLayoutNode().getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
            lookaheadPassDelegate$ui_release.onPlaced();
            getAlignmentLinesOwner().layoutChildren();
        }

        public int minIntrinsicWidth(int height) {
            return getLayoutNode().getIntrinsicsPolicy$ui_release().minLookaheadIntrinsicWidth(height);
        }

        public int minIntrinsicHeight(int width) {
            return getLayoutNode().getIntrinsicsPolicy$ui_release().minLookaheadIntrinsicHeight(width);
        }

        public int maxIntrinsicWidth(int height) {
            return getLayoutNode().getIntrinsicsPolicy$ui_release().maxLookaheadIntrinsicWidth(height);
        }

        public int maxIntrinsicHeight(int width) {
            return getLayoutNode().getIntrinsicsPolicy$ui_release().maxLookaheadIntrinsicHeight(width);
        }
    }

    public LookaheadDelegate createLookaheadDelegate(LookaheadScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        return new LookaheadDelegateImpl(this, scope);
    }

    /* renamed from: measure-BRTryo0  reason: not valid java name */
    public Placeable m4984measureBRTryo0(long constraints) {
        m4902setMeasurementConstraintsBRTryo0(constraints);
        MutableVector this_$iv$iv = getLayoutNode().get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                ((LayoutNode) content$iv$iv[i$iv$iv]).setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
        setMeasureResult$ui_release(getLayoutNode().getMeasurePolicy().m4864measure3p2s80s(this, getLayoutNode().getChildMeasurables$ui_release(), constraints));
        onMeasured();
        return this;
    }

    public int minIntrinsicWidth(int height) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().minIntrinsicWidth(height);
    }

    public int minIntrinsicHeight(int width) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().minIntrinsicHeight(width);
    }

    public int maxIntrinsicWidth(int height) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().maxIntrinsicWidth(height);
    }

    public int maxIntrinsicHeight(int width) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().maxIntrinsicHeight(width);
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public void m4985placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        super.m5107placeAtf8xVGno(position, zIndex, layerBlock);
        if (!isShallowPlacing$ui_release()) {
            onPlaced();
            getLayoutNode().onNodePlaced$ui_release();
        }
    }

    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        LookaheadDelegate lookaheadDelegate$ui_release = getLookaheadDelegate$ui_release();
        if (lookaheadDelegate$ui_release != null) {
            return lookaheadDelegate$ui_release.calculateAlignmentLine(alignmentLine);
        }
        Integer num = getAlignmentLinesOwner().calculateAlignmentLines().get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    public void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Owner owner = LayoutNodeKt.requireOwner(getLayoutNode());
        MutableVector this_$iv = getLayoutNode().getZSortedChildren();
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                LayoutNode child = (LayoutNode) content$iv[i$iv];
                if (child.isPlaced()) {
                    child.draw$ui_release(canvas);
                }
                i$iv++;
            } while (i$iv < size$iv);
        }
        if (owner.getShowLayoutBounds()) {
            drawBorder(canvas, innerBoundsPaint);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* renamed from: hitTestChild-YqVAtuI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends androidx.compose.ui.node.DelegatableNode> void m4983hitTestChildYqVAtuI(androidx.compose.ui.node.NodeCoordinator.HitTestSource<T> r26, long r27, androidx.compose.ui.node.HitTestResult<T> r29, boolean r30, boolean r31) {
        /*
            r25 = this;
            r0 = r25
            r8 = r26
            r9 = r27
            java.lang.String r1 = "hitTestSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            java.lang.String r1 = "hitTestResult"
            r11 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            r1 = 0
            r1 = r31
            r2 = 0
            androidx.compose.ui.node.LayoutNode r3 = r25.getLayoutNode()
            boolean r3 = r8.shouldHitTestChildren(r3)
            if (r3 == 0) goto L_0x004c
            boolean r3 = r0.m5113withinLayerBoundsk4lQ0M(r9)
            if (r3 == 0) goto L_0x002c
            r2 = 1
            r14 = r1
            r15 = r2
            goto L_0x004e
        L_0x002c:
            if (r30 == 0) goto L_0x004c
            long r3 = r25.m5094getMinimumTouchTargetSizeNHjbRc()
            float r3 = r0.m5091distanceInMinimumTouchTargettz77jQw(r9, r3)
            boolean r4 = java.lang.Float.isInfinite(r3)
            if (r4 != 0) goto L_0x0044
            boolean r3 = java.lang.Float.isNaN(r3)
            if (r3 != 0) goto L_0x0044
            r3 = 1
            goto L_0x0045
        L_0x0044:
            r3 = 0
        L_0x0045:
            if (r3 == 0) goto L_0x004c
            r1 = 0
            r2 = 1
            r14 = r1
            r15 = r2
            goto L_0x004e
        L_0x004c:
            r14 = r1
            r15 = r2
        L_0x004e:
            if (r15 == 0) goto L_0x00cd
            r7 = r29
            r16 = 0
            int r6 = r7.hitDepth
            r17 = 0
            androidx.compose.ui.node.LayoutNode r1 = r25.getLayoutNode()
            androidx.compose.runtime.collection.MutableVector r18 = r1.getZSortedChildren()
            r19 = 0
            int r20 = r18.getSize()
            if (r20 <= 0) goto L_0x00c4
            int r1 = r20 + -1
            java.lang.Object[] r21 = r18.getContent()
            r22 = r1
        L_0x0073:
            r1 = r21[r22]
            r23 = r1
            androidx.compose.ui.node.LayoutNode r23 = (androidx.compose.ui.node.LayoutNode) r23
            r24 = 0
            boolean r1 = r23.isPlaced()
            if (r1 == 0) goto L_0x00b6
            r1 = r26
            r2 = r23
            r3 = r27
            r5 = r29
            r12 = r6
            r6 = r30
            r13 = r7
            r7 = r14
            r1.m5118childHitTestYqVAtuI(r2, r3, r5, r6, r7)
            boolean r1 = r29.hasHit()
            r2 = 0
            if (r1 != 0) goto L_0x00a0
            r2 = 1
            goto L_0x00b0
        L_0x00a0:
            androidx.compose.ui.node.NodeCoordinator r3 = r23.getOuterCoordinator$ui_release()
            boolean r3 = r3.shouldSharePointerInputWithSiblings()
            if (r3 == 0) goto L_0x00af
            r29.acceptHits()
            r2 = 1
            goto L_0x00b0
        L_0x00af:
            r2 = 0
        L_0x00b0:
            if (r2 != 0) goto L_0x00b4
            r1 = 1
            goto L_0x00b9
        L_0x00b4:
            r1 = 0
            goto L_0x00b9
        L_0x00b6:
            r12 = r6
            r13 = r7
            r1 = 0
        L_0x00b9:
            if (r1 != 0) goto L_0x00c7
            int r22 = r22 + -1
            if (r22 >= 0) goto L_0x00c1
            goto L_0x00c6
        L_0x00c1:
            r6 = r12
            r7 = r13
            goto L_0x0073
        L_0x00c4:
            r12 = r6
            r13 = r7
        L_0x00c6:
        L_0x00c7:
            r13.hitDepth = r12
        L_0x00cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.InnerNodeCoordinator.m4983hitTestChildYqVAtuI(androidx.compose.ui.node.NodeCoordinator$HitTestSource, long, androidx.compose.ui.node.HitTestResult, boolean, boolean):void");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator$Companion;", "", "()V", "innerBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getInnerBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: InnerNodeCoordinator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Paint getInnerBoundsPaint() {
            return InnerNodeCoordinator.innerBoundsPaint;
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint paint = Paint;
        paint.m3427setColor8_81llA(Color.Companion.m3198getRed0d7_KjU());
        paint.setStrokeWidth(1.0f);
        paint.m3431setStylek9PVt8s(PaintingStyle.Companion.m3440getStrokeTiuSbCo());
        innerBoundsPaint = Paint;
    }
}
