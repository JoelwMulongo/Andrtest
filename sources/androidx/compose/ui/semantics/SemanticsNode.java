package androidx.compose.ui.semantics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010D\u001a\u00020E2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00000GH\u0002J6\u0010H\u001a\u00020\u00002\b\u0010I\u001a\u0004\u0018\u00010J2\u0017\u0010K\u001a\u0013\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020E0L¢\u0006\u0002\bNH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\bOJ\u000f\u0010P\u001a\u0004\u0018\u00010QH\u0000¢\u0006\u0002\bRJ\u001e\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00000\u00102\u000e\b\u0002\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00000GH\u0002J\u000e\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020WJ\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u00102\u0006\u0010X\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u0005H\u0002J\u0010\u0010Z\u001a\u00020E2\u0006\u0010[\u001a\u00020\u0014H\u0002J\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00000\u00102\b\b\u0002\u0010Y\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\\R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001eR\u0011\u0010\"\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001eR\u0014\u0010#\u001a\u00020\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u001eR\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010.\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b/\u00100R\u001a\u00101\u001a\u0002028Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b3\u00104R\u001a\u00105\u001a\u0002028Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b6\u00104R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u00000\u00108@X\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0012R\u0013\u00109\u001a\u0004\u0018\u00010:8F¢\u0006\u0006\u001a\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020>8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b?\u00104R\u0011\u0010@\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bA\u0010\fR\u0014\u0010B\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0016\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006]"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsNode;", "", "outerSemanticsNode", "Landroidx/compose/ui/node/SemanticsModifierNode;", "mergingEnabled", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/SemanticsModifierNode;ZLandroidx/compose/ui/node/LayoutNode;)V", "boundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "getBoundsInRoot", "()Landroidx/compose/ui/geometry/Rect;", "boundsInWindow", "getBoundsInWindow", "children", "", "getChildren", "()Ljava/util/List;", "config", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getConfig", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "fakeNodeParent", "id", "", "getId", "()I", "isFake", "isFake$ui_release", "()Z", "setFake$ui_release", "(Z)V", "isMergingSemanticsOfDescendants", "isRoot", "isTransparent", "isTransparent$ui_release", "layoutInfo", "Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutNode$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "getMergingEnabled", "getOuterSemanticsNode$ui_release", "()Landroidx/compose/ui/node/SemanticsModifierNode;", "parent", "getParent", "()Landroidx/compose/ui/semantics/SemanticsNode;", "positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "getPositionInRoot-F1C5BW0", "()J", "positionInWindow", "getPositionInWindow-F1C5BW0", "replacedChildren", "getReplacedChildren$ui_release", "root", "Landroidx/compose/ui/node/RootForTest;", "getRoot", "()Landroidx/compose/ui/node/RootForTest;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "touchBoundsInRoot", "getTouchBoundsInRoot", "unmergedConfig", "getUnmergedConfig$ui_release", "emitFakeNodes", "", "unmergedChildren", "", "fakeSemanticsNode", "role", "Landroidx/compose/ui/semantics/Role;", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "Lkotlin/ExtensionFunctionType;", "fakeSemanticsNode-ypyhhiA", "findCoordinatorToGetBounds", "Landroidx/compose/ui/node/NodeCoordinator;", "findCoordinatorToGetBounds$ui_release", "findOneLayerOfMergingSemanticsNodes", "list", "getAlignmentLinePosition", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "includeReplacedSemantics", "includeFakeNodes", "mergeConfig", "mergedConfig", "unmergedChildren$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SemanticsNode.kt */
public final class SemanticsNode {
    public static final int $stable = 8;
    private SemanticsNode fakeNodeParent;
    private final int id;
    private boolean isFake;
    private final LayoutNode layoutNode;
    private final boolean mergingEnabled;
    private final SemanticsModifierNode outerSemanticsNode;
    private final SemanticsConfiguration unmergedConfig;

    public SemanticsNode(SemanticsModifierNode outerSemanticsNode2, boolean mergingEnabled2, LayoutNode layoutNode2) {
        Intrinsics.checkNotNullParameter(outerSemanticsNode2, "outerSemanticsNode");
        Intrinsics.checkNotNullParameter(layoutNode2, "layoutNode");
        this.outerSemanticsNode = outerSemanticsNode2;
        this.mergingEnabled = mergingEnabled2;
        this.layoutNode = layoutNode2;
        this.unmergedConfig = SemanticsModifierNodeKt.collapsedSemanticsConfiguration(outerSemanticsNode2);
        this.id = layoutNode2.getSemanticsId();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SemanticsNode(SemanticsModifierNode semanticsModifierNode, boolean z, LayoutNode layoutNode2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(semanticsModifierNode, z, (i & 4) != 0 ? DelegatableNodeKt.requireLayoutNode(semanticsModifierNode) : layoutNode2);
    }

    public final SemanticsModifierNode getOuterSemanticsNode$ui_release() {
        return this.outerSemanticsNode;
    }

    public final boolean getMergingEnabled() {
        return this.mergingEnabled;
    }

    public final LayoutNode getLayoutNode$ui_release() {
        return this.layoutNode;
    }

    public final boolean isFake$ui_release() {
        return this.isFake;
    }

    public final void setFake$ui_release(boolean z) {
        this.isFake = z;
    }

    public final SemanticsConfiguration getUnmergedConfig$ui_release() {
        return this.unmergedConfig;
    }

    public final LayoutInfo getLayoutInfo() {
        return this.layoutNode;
    }

    public final RootForTest getRoot() {
        Owner owner$ui_release = this.layoutNode.getOwner$ui_release();
        if (owner$ui_release != null) {
            return owner$ui_release.getRootForTest();
        }
        return null;
    }

    public final int getId() {
        return this.id;
    }

    public final Rect getTouchBoundsInRoot() {
        SemanticsModifierNode entity;
        if (this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            entity = SemanticsNodeKt.getOuterMergingSemantics(this.layoutNode);
            if (entity == null) {
                entity = this.outerSemanticsNode;
            }
        } else {
            entity = this.outerSemanticsNode;
        }
        return SemanticsModifierNodeKt.touchBoundsInRoot(entity);
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public final long m5323getSizeYbymL2g() {
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        return findCoordinatorToGetBounds$ui_release != null ? findCoordinatorToGetBounds$ui_release.m5096getSizeYbymL2g() : IntSize.Companion.m6151getZeroYbymL2g();
    }

    public final Rect getBoundsInRoot() {
        Rect boundsInRoot;
        NodeCoordinator it = findCoordinatorToGetBounds$ui_release();
        if (it != null) {
            if (!it.isAttached()) {
                it = null;
            }
            if (!(it == null || (boundsInRoot = LayoutCoordinatesKt.boundsInRoot(it)) == null)) {
                return boundsInRoot;
            }
        }
        return Rect.Companion.getZero();
    }

    /* renamed from: getPositionInRoot-F1C5BW0  reason: not valid java name */
    public final long m5321getPositionInRootF1C5BW0() {
        NodeCoordinator it = findCoordinatorToGetBounds$ui_release();
        if (it != null) {
            if (!it.isAttached()) {
                it = null;
            }
            if (it != null) {
                return LayoutCoordinatesKt.positionInRoot(it);
            }
        }
        return Offset.Companion.m2931getZeroF1C5BW0();
    }

    public final Rect getBoundsInWindow() {
        Rect boundsInWindow;
        NodeCoordinator it = findCoordinatorToGetBounds$ui_release();
        if (it != null) {
            if (!it.isAttached()) {
                it = null;
            }
            if (!(it == null || (boundsInWindow = LayoutCoordinatesKt.boundsInWindow(it)) == null)) {
                return boundsInWindow;
            }
        }
        return Rect.Companion.getZero();
    }

    /* renamed from: getPositionInWindow-F1C5BW0  reason: not valid java name */
    public final long m5322getPositionInWindowF1C5BW0() {
        NodeCoordinator it = findCoordinatorToGetBounds$ui_release();
        if (it != null) {
            if (!it.isAttached()) {
                it = null;
            }
            if (it != null) {
                return LayoutCoordinatesKt.positionInWindow(it);
            }
        }
        return Offset.Companion.m2931getZeroF1C5BW0();
    }

    public final boolean isTransparent$ui_release() {
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (findCoordinatorToGetBounds$ui_release != null) {
            return findCoordinatorToGetBounds$ui_release.isTransparent();
        }
        return false;
    }

    public final int getAlignmentLinePosition(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (findCoordinatorToGetBounds$ui_release != null) {
            return findCoordinatorToGetBounds$ui_release.get(alignmentLine);
        }
        return Integer.MIN_VALUE;
    }

    public final SemanticsConfiguration getConfig() {
        if (!isMergingSemanticsOfDescendants()) {
            return this.unmergedConfig;
        }
        SemanticsConfiguration mergedConfig = this.unmergedConfig.copy();
        mergeConfig(mergedConfig);
        return mergedConfig;
    }

    private final void mergeConfig(SemanticsConfiguration mergedConfig) {
        if (!this.unmergedConfig.isClearingSemantics()) {
            List $this$fastForEach$iv = unmergedChildren$ui_release$default(this, false, 1, (Object) null);
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                SemanticsNode child = (SemanticsNode) $this$fastForEach$iv.get(index$iv);
                if (!child.isMergingSemanticsOfDescendants()) {
                    mergedConfig.mergeChild$ui_release(child.unmergedConfig);
                    child.mergeConfig(mergedConfig);
                }
            }
        }
    }

    private final boolean isMergingSemanticsOfDescendants() {
        return this.mergingEnabled && this.unmergedConfig.isMergingSemanticsOfDescendants();
    }

    public static /* synthetic */ List unmergedChildren$ui_release$default(SemanticsNode semanticsNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return semanticsNode.unmergedChildren$ui_release(z);
    }

    public final List<SemanticsNode> unmergedChildren$ui_release(boolean includeFakeNodes) {
        if (this.isFake) {
            return CollectionsKt.emptyList();
        }
        List unmergedChildren = new ArrayList();
        List semanticsChildren = SemanticsNodeKt.findOneLayerOfSemanticsWrappers$default(this.layoutNode, (List) null, 1, (Object) null);
        List $this$fastForEach$iv = semanticsChildren;
        int index$iv = 0;
        int size = $this$fastForEach$iv.size();
        while (index$iv < size) {
            List semanticsChildren2 = semanticsChildren;
            SemanticsNode semanticsNode = r8;
            SemanticsNode semanticsNode2 = new SemanticsNode((SemanticsModifierNode) $this$fastForEach$iv.get(index$iv), this.mergingEnabled, (LayoutNode) null, 4, (DefaultConstructorMarker) null);
            unmergedChildren.add(semanticsNode);
            index$iv++;
            semanticsChildren = semanticsChildren2;
        }
        if (includeFakeNodes) {
            emitFakeNodes(unmergedChildren);
        }
        return unmergedChildren;
    }

    public final List<SemanticsNode> getChildren() {
        return getChildren(!this.mergingEnabled, false);
    }

    public final List<SemanticsNode> getReplacedChildren$ui_release() {
        return getChildren(false, true);
    }

    private final List<SemanticsNode> getChildren(boolean includeReplacedSemantics, boolean includeFakeNodes) {
        if (!includeReplacedSemantics && this.unmergedConfig.isClearingSemantics()) {
            return CollectionsKt.emptyList();
        }
        if (isMergingSemanticsOfDescendants()) {
            return findOneLayerOfMergingSemanticsNodes$default(this, (List) null, 1, (Object) null);
        }
        return unmergedChildren$ui_release(includeFakeNodes);
    }

    public final boolean isRoot() {
        return getParent() == null;
    }

    public final SemanticsNode getParent() {
        SemanticsNode semanticsNode = this.fakeNodeParent;
        if (semanticsNode != null) {
            return semanticsNode;
        }
        LayoutNode node = null;
        if (this.mergingEnabled) {
            node = SemanticsNodeKt.findClosestParentNode(this.layoutNode, SemanticsNode$parent$1.INSTANCE);
        }
        if (node == null) {
            node = SemanticsNodeKt.findClosestParentNode(this.layoutNode, SemanticsNode$parent$2.INSTANCE);
        }
        SemanticsModifierNode outerSemantics = node != null ? SemanticsNodeKt.getOuterSemantics(node) : null;
        if (outerSemantics == null) {
            return null;
        }
        return new SemanticsNode(outerSemantics, this.mergingEnabled, (LayoutNode) null, 4, (DefaultConstructorMarker) null);
    }

    static /* synthetic */ List findOneLayerOfMergingSemanticsNodes$default(SemanticsNode semanticsNode, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return semanticsNode.findOneLayerOfMergingSemanticsNodes(list);
    }

    private final List<SemanticsNode> findOneLayerOfMergingSemanticsNodes(List<SemanticsNode> list) {
        List $this$fastForEach$iv = unmergedChildren$ui_release$default(this, false, 1, (Object) null);
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            SemanticsNode child = (SemanticsNode) $this$fastForEach$iv.get(index$iv);
            if (child.isMergingSemanticsOfDescendants()) {
                list.add(child);
            } else if (!child.unmergedConfig.isClearingSemantics()) {
                child.findOneLayerOfMergingSemanticsNodes(list);
            }
        }
        return list;
    }

    public final NodeCoordinator findCoordinatorToGetBounds$ui_release() {
        SemanticsModifierNode semanticsModifierNode = null;
        if (this.isFake) {
            SemanticsNode parent = getParent();
            if (parent != null) {
                return parent.findCoordinatorToGetBounds$ui_release();
            }
            return null;
        }
        SemanticsModifierNode outerMergingSemantics = SemanticsNodeKt.getOuterMergingSemantics(this.layoutNode);
        SemanticsModifierNode semanticsModifierNode2 = outerMergingSemantics;
        if (this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            semanticsModifierNode = outerMergingSemantics;
        }
        if (semanticsModifierNode == null) {
            semanticsModifierNode = this.outerSemanticsNode;
        }
        return DelegatableNodeKt.m4965requireCoordinator64DMado(semanticsModifierNode, NodeKind.m5123constructorimpl(8));
    }

    private final void emitFakeNodes(List<SemanticsNode> unmergedChildren) {
        Role nodeRole = SemanticsNodeKt.getRole(this);
        if (nodeRole != null && this.unmergedConfig.isMergingSemanticsOfDescendants() && (!unmergedChildren.isEmpty())) {
            unmergedChildren.add(m5320fakeSemanticsNodeypyhhiA(nodeRole, new SemanticsNode$emitFakeNodes$fakeNode$1(nodeRole)));
        }
        if (this.unmergedConfig.contains(SemanticsProperties.INSTANCE.getContentDescription()) && (!unmergedChildren.isEmpty()) && this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            List list = (List) SemanticsConfigurationKt.getOrNull(this.unmergedConfig, SemanticsProperties.INSTANCE.getContentDescription());
            String contentDescription = list != null ? (String) CollectionsKt.firstOrNull(list) : null;
            if (contentDescription != null) {
                unmergedChildren.add(0, m5320fakeSemanticsNodeypyhhiA((Role) null, new SemanticsNode$emitFakeNodes$fakeNode$2(contentDescription)));
            }
        }
    }

    /* renamed from: fakeSemanticsNode-ypyhhiA  reason: not valid java name */
    private final SemanticsNode m5320fakeSemanticsNodeypyhhiA(Role role, Function1<? super SemanticsPropertyReceiver, Unit> properties) {
        SemanticsNode fakeNode = new SemanticsNode(new SemanticsNode$fakeSemanticsNode$fakeNode$1(properties), false, new LayoutNode(true, role != null ? SemanticsNodeKt.roleFakeNodeId(this) : SemanticsNodeKt.contentDescriptionFakeNodeId(this)));
        fakeNode.isFake = true;
        fakeNode.fakeNodeParent = this;
        return fakeNode;
    }
}
