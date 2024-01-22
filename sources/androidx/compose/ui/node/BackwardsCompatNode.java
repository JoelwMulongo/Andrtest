package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BuildDrawCacheParams;
import androidx.compose.ui.draw.DrawCacheModifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusRequesterModifier;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.layout.IntermediateLayoutModifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.LookaheadOnPlacedModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.modifier.BackwardsCompatLocalMap;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalNode;
import androidx.compose.ui.modifier.ModifierLocalNodeKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u0010B\r\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u001fH\u0002J\b\u0010H\u001a\u00020\u001fH\u0016J\u0010\u0010I\u001a\u00020F2\u0006\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020FH\u0016J\b\u0010M\u001a\u00020FH\u0016J\b\u0010N\u001a\u00020FH\u0016J\r\u0010O\u001a\u00020FH\u0000¢\u0006\u0002\bPJ\u0010\u0010Q\u001a\u00020F2\u0006\u0010R\u001a\u00020SH\u0016J\u0010\u0010T\u001a\u00020F2\u0006\u0010U\u001a\u00020#H\u0016J\u0010\u0010V\u001a\u00020F2\u0006\u0010U\u001a\u00020WH\u0016J\b\u0010X\u001a\u00020FH\u0016J\u0010\u0010Y\u001a\u00020F2\u0006\u0010U\u001a\u00020#H\u0016J-\u0010Z\u001a\u00020F2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020<H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010aJ\u001d\u0010b\u001a\u00020F2\u0006\u00108\u001a\u00020<H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bc\u0010@J\b\u0010d\u001a\u00020\u001fH\u0016J\b\u0010e\u001a\u00020fH\u0016J\b\u0010g\u001a\u00020FH\u0002J\b\u0010h\u001a\u00020FH\u0002J\u0006\u0010i\u001a\u00020FJ\u0014\u0010j\u001a\u00020F2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030kH\u0002J\f\u0010l\u001a\u00020F*\u00020mH\u0016J\u001c\u0010n\u001a\u00020o*\u00020p2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020oH\u0016J\u001c\u0010t\u001a\u00020o*\u00020p2\u0006\u0010q\u001a\u00020r2\u0006\u0010u\u001a\u00020oH\u0016J)\u0010v\u001a\u00020w*\u00020x2\u0006\u0010q\u001a\u00020y2\u0006\u0010z\u001a\u00020{H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b|\u0010}J\u001c\u0010~\u001a\u00020o*\u00020p2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020oH\u0016J\u001c\u0010\u001a\u00020o*\u00020p2\u0006\u0010q\u001a\u00020r2\u0006\u0010u\u001a\u00020oH\u0016J\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u0001*\u00020\u00172\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u0013R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R2\u0010,\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030.0-j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030.`/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00104\u001a\u0002058VX\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001d\u00108\u001a\u0002098VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b:\u0010;R-\u0010=\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020<8V@VX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u001a\u0004\b>\u0010;\"\u0004\b?\u0010@R$\u0010A\u001a\u0002HB\"\u0004\b\u0000\u0010B*\b\u0012\u0004\u0012\u0002HB0.8VX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/BackwardsCompatNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/IntermediateLayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalNode;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "Landroidx/compose/ui/Modifier$Node;", "element", "Landroidx/compose/ui/Modifier$Element;", "(Landroidx/compose/ui/Modifier$Element;)V", "_providedValues", "Landroidx/compose/ui/modifier/BackwardsCompatLocalMap;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "value", "getElement", "()Landroidx/compose/ui/Modifier$Element;", "setElement", "invalidateCache", "", "isValidOwnerScope", "()Z", "lastOnPlacedCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "readValues", "Ljava/util/HashSet;", "Landroidx/compose/ui/modifier/ModifierLocal;", "Lkotlin/collections/HashSet;", "getReadValues", "()Ljava/util/HashSet;", "setReadValues", "(Ljava/util/HashSet;)V", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getSemanticsConfiguration", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "Landroidx/compose/ui/unit/IntSize;", "targetSize", "getTargetSize-YbymL2g", "setTargetSize-ozmzZPI", "(J)V", "current", "T", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "initializeModifier", "", "duringAttach", "interceptOutOfBoundsChildEvents", "modifyFocusProperties", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "onAttach", "onCancelPointerInput", "onDetach", "onDrawCacheReadsChanged", "onDrawCacheReadsChanged$ui_release", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "onGloballyPositioned", "coordinates", "onLookaheadPlaced", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "onMeasureResultChanged", "onPlaced", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onRemeasured", "onRemeasured-ozmzZPI", "sharePointerInputWithSiblings", "toString", "", "unInitializeModifier", "updateDrawCache", "updateModifierLocalConsumer", "updateModifierLocalProvider", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "modifyParentData", "", "parentData", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackwardsCompatNode.kt */
public final class BackwardsCompatNode extends Modifier.Node implements LayoutModifierNode, IntermediateLayoutModifierNode, DrawModifierNode, SemanticsModifierNode, PointerInputModifierNode, ModifierLocalNode, ModifierLocalReadScope, ParentDataModifierNode, LayoutAwareModifierNode, GlobalPositionAwareModifierNode, FocusEventModifierNode, FocusPropertiesModifierNode, FocusRequesterModifierNode, OwnerScope, BuildDrawCacheParams {
    private BackwardsCompatLocalMap _providedValues;
    private Modifier.Element element;
    private boolean invalidateCache = true;
    /* access modifiers changed from: private */
    public LayoutCoordinates lastOnPlacedCoordinates;
    private HashSet<ModifierLocal<?>> readValues = new HashSet<>();

    public BackwardsCompatNode(Modifier.Element element2) {
        Intrinsics.checkNotNullParameter(element2, "element");
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(element2));
        this.element = element2;
    }

    public final Modifier.Element getElement() {
        return this.element;
    }

    public final void setElement(Modifier.Element value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (isAttached()) {
            unInitializeModifier();
        }
        this.element = value;
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(value));
        if (isAttached()) {
            initializeModifier(false);
        }
    }

    public void onAttach() {
        initializeModifier(true);
    }

    public void onDetach() {
        unInitializeModifier();
    }

    private final void unInitializeModifier() {
        if (isAttached()) {
            Modifier.Element element2 = this.element;
            boolean z = true;
            if (((getKindSet$ui_release() & NodeKind.m5123constructorimpl(32)) != 0 ? 1 : null) != null) {
                if (element2 instanceof ModifierLocalProvider) {
                    DelegatableNodeKt.requireOwner(this).getModifierLocalManager().removedProvider(this, ((ModifierLocalProvider) element2).getKey());
                }
                if (element2 instanceof ModifierLocalConsumer) {
                    ((ModifierLocalConsumer) element2).onModifierLocalsUpdated(BackwardsCompatNodeKt.DetachedModifierLocalReadScope);
                }
            }
            if ((getKindSet$ui_release() & NodeKind.m5123constructorimpl(8)) == 0) {
                z = false;
            }
            if (z) {
                DelegatableNodeKt.requireOwner(this).onSemanticsChange();
            }
            if (element2 instanceof FocusRequesterModifier) {
                ((FocusRequesterModifier) element2).getFocusRequester().getFocusRequesterNodes$ui_release().remove(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final void initializeModifier(boolean duringAttach) {
        if (isAttached()) {
            Modifier.Element element2 = this.element;
            boolean z = false;
            if (((getKindSet$ui_release() & NodeKind.m5123constructorimpl(32)) != 0 ? 1 : null) != null) {
                if (element2 instanceof ModifierLocalProvider) {
                    updateModifierLocalProvider((ModifierLocalProvider) element2);
                }
                if (element2 instanceof ModifierLocalConsumer) {
                    if (duringAttach) {
                        updateModifierLocalConsumer();
                    } else {
                        sideEffect(new BackwardsCompatNode$initializeModifier$1(this));
                    }
                }
            }
            if (((getKindSet$ui_release() & NodeKind.m5123constructorimpl(4)) != 0 ? 1 : null) != null) {
                if (element2 instanceof DrawCacheModifier) {
                    this.invalidateCache = true;
                }
                if (!duringAttach) {
                    LayoutModifierNodeKt.invalidateLayer(this);
                }
            }
            if (((getKindSet$ui_release() & NodeKind.m5123constructorimpl(2)) != 0 ? 1 : null) != null) {
                if (DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release().getTail$ui_release().isAttached()) {
                    NodeCoordinator coordinator = getCoordinator$ui_release();
                    Intrinsics.checkNotNull(coordinator);
                    LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) coordinator;
                    ((LayoutModifierNodeCoordinator) coordinator).setLayoutModifierNode$ui_release(this);
                    coordinator.onLayoutModifierNodeChanged();
                }
                if (!duringAttach) {
                    LayoutModifierNodeKt.invalidateLayer(this);
                    DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
                }
            }
            if (element2 instanceof RemeasurementModifier) {
                ((RemeasurementModifier) element2).onRemeasurementAvailable(this);
            }
            if (((getKindSet$ui_release() & NodeKind.m5123constructorimpl(128)) != 0 ? 1 : null) != null) {
                if ((element2 instanceof OnRemeasuredModifier) && DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release().getTail$ui_release().isAttached()) {
                    DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
                }
                if (element2 instanceof OnPlacedModifier) {
                    this.lastOnPlacedCoordinates = null;
                    if (DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release().getTail$ui_release().isAttached()) {
                        DelegatableNodeKt.requireOwner(this).registerOnLayoutCompletedListener(new BackwardsCompatNode$initializeModifier$2(this));
                    }
                }
            }
            if (((getKindSet$ui_release() & NodeKind.m5123constructorimpl(256)) != 0 ? 1 : null) != null && (element2 instanceof OnGloballyPositionedModifier) && DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release().getTail$ui_release().isAttached()) {
                DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
            }
            if (element2 instanceof FocusRequesterModifier) {
                ((FocusRequesterModifier) element2).getFocusRequester().getFocusRequesterNodes$ui_release().add(this);
            }
            if (((getKindSet$ui_release() & NodeKind.m5123constructorimpl(16)) != 0 ? 1 : null) != null && (element2 instanceof PointerInputModifier)) {
                ((PointerInputModifier) element2).getPointerInputFilter().setLayoutCoordinates$ui_release(getCoordinator$ui_release());
            }
            if ((getKindSet$ui_release() & NodeKind.m5123constructorimpl(8)) != 0) {
                z = true;
            }
            if (z) {
                DelegatableNodeKt.requireOwner(this).onSemanticsChange();
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public Density getDensity() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity();
    }

    public LayoutDirection getLayoutDirection() {
        return DelegatableNodeKt.requireLayoutNode(this).getLayoutDirection();
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public long m4943getSizeNHjbRc() {
        return IntSizeKt.m6156toSizeozmzZPI(DelegatableNodeKt.m4965requireCoordinator64DMado(this, NodeKind.m5123constructorimpl(128)).m5096getSizeYbymL2g());
    }

    public void onMeasureResultChanged() {
        this.invalidateCache = true;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    private final void updateDrawCache() {
        Modifier.Element element2 = this.element;
        if (element2 instanceof DrawCacheModifier) {
            DelegatableNodeKt.requireOwner(this).getSnapshotObserver().observeReads$ui_release(this, BackwardsCompatNodeKt.onDrawCacheReadsChanged, new BackwardsCompatNode$updateDrawCache$1(element2, this));
        }
        this.invalidateCache = false;
    }

    public final void onDrawCacheReadsChanged$ui_release() {
        this.invalidateCache = true;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    public final HashSet<ModifierLocal<?>> getReadValues() {
        return this.readValues;
    }

    public final void setReadValues(HashSet<ModifierLocal<?>> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
        this.readValues = hashSet;
    }

    public ModifierLocalMap getProvidedValues() {
        BackwardsCompatLocalMap backwardsCompatLocalMap = this._providedValues;
        return backwardsCompatLocalMap != null ? backwardsCompatLocalMap : ModifierLocalNodeKt.modifierLocalMapOf();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007c, code lost:
        r0 = r10.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T getCurrent(androidx.compose.ui.modifier.ModifierLocal<T> r17) {
        /*
            r16 = this;
            r0 = r16
            java.lang.String r1 = "<this>"
            r2 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            r1 = r17
            java.util.HashSet<androidx.compose.ui.modifier.ModifierLocal<?>> r3 = r0.readValues
            r3.add(r1)
            r3 = r0
            androidx.compose.ui.node.DelegatableNode r3 = (androidx.compose.ui.node.DelegatableNode) r3
            r4 = 0
            r5 = 32
            int r4 = androidx.compose.ui.node.NodeKind.m5123constructorimpl(r5)
            r5 = 0
            r6 = r4
            r7 = r3
            r8 = 0
            androidx.compose.ui.Modifier$Node r9 = r7.getNode()
            boolean r9 = r9.isAttached()
            if (r9 == 0) goto L_0x0097
            androidx.compose.ui.Modifier$Node r9 = r7.getNode()
            androidx.compose.ui.Modifier$Node r9 = r9.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r10 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r7)
        L_0x0035:
            if (r10 == 0) goto L_0x008c
            androidx.compose.ui.node.NodeChain r11 = r10.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r11 = r11.getHead$ui_release()
            int r12 = r11.getAggregateChildKindSet$ui_release()
            r12 = r12 & r6
            if (r12 == 0) goto L_0x0076
        L_0x0046:
            if (r9 == 0) goto L_0x0076
            int r12 = r9.getKindSet$ui_release()
            r12 = r12 & r6
            if (r12 == 0) goto L_0x006f
            r12 = r9
            r13 = 0
            boolean r14 = r12 instanceof androidx.compose.ui.modifier.ModifierLocalNode
            if (r14 == 0) goto L_0x006e
            r14 = r12
            androidx.compose.ui.modifier.ModifierLocalNode r14 = (androidx.compose.ui.modifier.ModifierLocalNode) r14
            r15 = 0
            androidx.compose.ui.modifier.ModifierLocalMap r0 = r14.getProvidedValues()
            boolean r0 = r0.contains$ui_release(r1)
            if (r0 == 0) goto L_0x006c
            androidx.compose.ui.modifier.ModifierLocalMap r0 = r14.getProvidedValues()
            java.lang.Object r0 = r0.get$ui_release(r1)
            return r0
        L_0x006c:
        L_0x006e:
        L_0x006f:
            androidx.compose.ui.Modifier$Node r9 = r9.getParent$ui_release()
            r0 = r16
            goto L_0x0046
        L_0x0076:
            androidx.compose.ui.node.LayoutNode r10 = r10.getParent$ui_release()
            if (r10 == 0) goto L_0x0087
            androidx.compose.ui.node.NodeChain r0 = r10.getNodes$ui_release()
            if (r0 == 0) goto L_0x0087
            androidx.compose.ui.Modifier$Node r0 = r0.getTail$ui_release()
            goto L_0x0088
        L_0x0087:
            r0 = 0
        L_0x0088:
            r9 = r0
            r0 = r16
            goto L_0x0035
        L_0x008c:
            kotlin.jvm.functions.Function0 r0 = r1.getDefaultFactory$ui_release()
            java.lang.Object r0 = r0.invoke()
            return r0
        L_0x0097:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r9 = "Check failed."
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.BackwardsCompatNode.getCurrent(androidx.compose.ui.modifier.ModifierLocal):java.lang.Object");
    }

    public final void updateModifierLocalConsumer() {
        if (isAttached()) {
            this.readValues.clear();
            DelegatableNodeKt.requireOwner(this).getSnapshotObserver().observeReads$ui_release(this, BackwardsCompatNodeKt.updateModifierLocalConsumer, new BackwardsCompatNode$updateModifierLocalConsumer$1(this));
        }
    }

    private final void updateModifierLocalProvider(ModifierLocalProvider<?> element2) {
        BackwardsCompatLocalMap providedValues = this._providedValues;
        if (providedValues == null || !providedValues.contains$ui_release(element2.getKey())) {
            this._providedValues = new BackwardsCompatLocalMap(element2);
            if (DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release().getTail$ui_release().isAttached()) {
                DelegatableNodeKt.requireOwner(this).getModifierLocalManager().insertedProvider(this, element2.getKey());
                return;
            }
            return;
        }
        providedValues.setElement(element2);
        DelegatableNodeKt.requireOwner(this).getModifierLocalManager().updatedProvider(this, element2.getKey());
    }

    public boolean isValidOwnerScope() {
        return isAttached();
    }

    /* renamed from: getTargetSize-YbymL2g  reason: not valid java name */
    public long m4944getTargetSizeYbymL2g() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.IntermediateLayoutModifier");
        return ((IntermediateLayoutModifier) element2).m4824getTargetSizeYbymL2g();
    }

    /* renamed from: setTargetSize-ozmzZPI  reason: not valid java name */
    public void m4948setTargetSizeozmzZPI(long value) {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.IntermediateLayoutModifier");
        ((IntermediateLayoutModifier) element2).m4825setTargetSizeozmzZPI(value);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m4945measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).m4847measure3p2s80s($this$measure_u2d3p2s80s, measurable, constraints);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).minIntrinsicWidth($this$minIntrinsicWidth, measurable, height);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).minIntrinsicHeight($this$minIntrinsicHeight, measurable, width);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).maxIntrinsicWidth($this$maxIntrinsicWidth, measurable, height);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).maxIntrinsicHeight($this$maxIntrinsicHeight, measurable, width);
    }

    public void draw(ContentDrawScope $this$draw) {
        Intrinsics.checkNotNullParameter($this$draw, "<this>");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.draw.DrawModifier");
        DrawModifier $this$draw_u24lambda_u246 = (DrawModifier) element2;
        if (this.invalidateCache && (element2 instanceof DrawCacheModifier)) {
            updateDrawCache();
        }
        $this$draw_u24lambda_u246.draw($this$draw);
    }

    public SemanticsConfiguration getSemanticsConfiguration() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsModifier");
        return ((SemanticsModifier) element2).getSemanticsConfiguration();
    }

    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void m4946onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pass, "pass");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((PointerInputModifier) element2).getPointerInputFilter().m4688onPointerEventH0pRuoY(pointerEvent, pass, bounds);
    }

    public void onCancelPointerInput() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((PointerInputModifier) element2).getPointerInputFilter().onCancel();
    }

    public boolean sharePointerInputWithSiblings() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((PointerInputModifier) element2).getPointerInputFilter().getShareWithSiblings();
    }

    public boolean interceptOutOfBoundsChildEvents() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((PointerInputModifier) element2).getPointerInputFilter().getInterceptOutOfBoundsChildEvents();
    }

    public Object modifyParentData(Density $this$modifyParentData, Object parentData) {
        Intrinsics.checkNotNullParameter($this$modifyParentData, "<this>");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.ParentDataModifier");
        return ((ParentDataModifier) element2).modifyParentData($this$modifyParentData, parentData);
    }

    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.OnGloballyPositionedModifier");
        ((OnGloballyPositionedModifier) element2).onGloballyPositioned(coordinates);
    }

    public void onLookaheadPlaced(LookaheadLayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Modifier.Element element2 = this.element;
        if (element2 instanceof LookaheadOnPlacedModifier) {
            ((LookaheadOnPlacedModifier) element2).onPlaced(coordinates);
        }
    }

    /* renamed from: onRemeasured-ozmzZPI  reason: not valid java name */
    public void m4947onRemeasuredozmzZPI(long size) {
        Modifier.Element element2 = this.element;
        if (element2 instanceof OnRemeasuredModifier) {
            ((OnRemeasuredModifier) element2).m4893onRemeasuredozmzZPI(size);
        }
    }

    public void onPlaced(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        this.lastOnPlacedCoordinates = coordinates;
        Modifier.Element element2 = this.element;
        if (element2 instanceof OnPlacedModifier) {
            ((OnPlacedModifier) element2).onPlaced(coordinates);
        }
    }

    public void onFocusEvent(FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        Modifier.Element focusEventModifier = this.element;
        if (focusEventModifier instanceof FocusEventModifier) {
            ((FocusEventModifier) focusEventModifier).onFocusEvent(focusState);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public void modifyFocusProperties(FocusProperties focusProperties) {
        Intrinsics.checkNotNullParameter(focusProperties, "focusProperties");
        Modifier.Element focusOrderModifier = this.element;
        if (focusOrderModifier instanceof FocusOrderModifier) {
            new FocusOrderModifierToProperties((FocusOrderModifier) focusOrderModifier).invoke(focusProperties);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public String toString() {
        return this.element.toString();
    }
}
