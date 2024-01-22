package androidx.compose.foundation.gestures;

import androidx.compose.foundation.FocusedBoundsKt;
import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.foundation.relocation.BringIntoViewResponderKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001EB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ!\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\"H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0015H\u0016J\b\u0010%\u001a\u00020&H\u0002J%\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u001dH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\n\u0010,\u001a\u0004\u0018\u00010\u0015H\u0002J\n\u0010-\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010.\u001a\u00020 H\u0002J\u0010\u0010/\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001d\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\u001dH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103J \u00104\u001a\u00020&2\u0006\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020&2\u0006\u0010)\u001a\u00020&H\u0002J%\u00107\u001a\u0002082\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u001dH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\"\u0010;\u001a\u00020<*\u00020=2\u0006\u0010>\u001a\u00020=H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\"\u0010;\u001a\u00020<*\u00020\u001d2\u0006\u0010>\u001a\u00020\u001dH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010@J#\u0010B\u001a\u00020\u000b*\u00020\u00152\b\b\u0002\u00101\u001a\u00020\u001dH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\u00020\u001dX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, d2 = {"Landroidx/compose/foundation/gestures/ContentInViewModifier;", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "Landroidx/compose/ui/layout/OnRemeasuredModifier;", "Landroidx/compose/ui/layout/OnPlacedModifier;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "scrollState", "Landroidx/compose/foundation/gestures/ScrollableState;", "reverseDirection", "", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/ScrollableState;Z)V", "animationState", "Landroidx/compose/foundation/gestures/UpdatableAnimationState;", "bringIntoViewRequests", "Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "focusedChild", "focusedChildBoundsFromPreviousRemeasure", "Landroidx/compose/ui/geometry/Rect;", "isAnimationRunning", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "trackingFocusedChild", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "J", "bringChildIntoView", "", "localRect", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateRectForParent", "calculateScrollDelta", "", "computeDestination", "childBounds", "containerSize", "computeDestination-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/Rect;", "findBringIntoViewRequest", "getFocusedChildBounds", "launchAnimation", "onPlaced", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "relocationDistance", "leadingEdge", "trailingEdge", "relocationOffset", "Landroidx/compose/ui/geometry/Offset;", "relocationOffset-BMxPBkI", "(Landroidx/compose/ui/geometry/Rect;J)J", "compareTo", "", "Landroidx/compose/ui/geometry/Size;", "other", "compareTo-iLBOSCw", "(JJ)I", "compareTo-TemP2vQ", "isMaxVisible", "isMaxVisible-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Z", "Request", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContentInViewModifier.kt */
public final class ContentInViewModifier implements BringIntoViewResponder, OnRemeasuredModifier, OnPlacedModifier {
    /* access modifiers changed from: private */
    public final UpdatableAnimationState animationState = new UpdatableAnimationState();
    /* access modifiers changed from: private */
    public final BringIntoViewRequestPriorityQueue bringIntoViewRequests = new BringIntoViewRequestPriorityQueue();
    private LayoutCoordinates coordinates;
    /* access modifiers changed from: private */
    public LayoutCoordinates focusedChild;
    private Rect focusedChildBoundsFromPreviousRemeasure;
    /* access modifiers changed from: private */
    public boolean isAnimationRunning;
    private final Modifier modifier = BringIntoViewResponderKt.bringIntoViewResponder(FocusedBoundsKt.onFocusedBoundsChanged(this, new ContentInViewModifier$modifier$1(this)), this);
    private final Orientation orientation;
    /* access modifiers changed from: private */
    public final boolean reverseDirection;
    private final CoroutineScope scope;
    /* access modifiers changed from: private */
    public final ScrollableState scrollState;
    /* access modifiers changed from: private */
    public boolean trackingFocusedChild;
    private long viewportSize = IntSize.Companion.m6151getZeroYbymL2g();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ContentInViewModifier.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ContentInViewModifier(CoroutineScope scope2, Orientation orientation2, ScrollableState scrollState2, boolean reverseDirection2) {
        Intrinsics.checkNotNullParameter(scope2, "scope");
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        Intrinsics.checkNotNullParameter(scrollState2, "scrollState");
        this.scope = scope2;
        this.orientation = orientation2;
        this.scrollState = scrollState2;
        this.reverseDirection = reverseDirection2;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public Rect calculateRectForParent(Rect localRect) {
        Intrinsics.checkNotNullParameter(localRect, "localRect");
        if (!IntSize.m6144equalsimpl0(this.viewportSize, IntSize.Companion.m6151getZeroYbymL2g())) {
            return m529computeDestinationO0kMr_c(localRect, this.viewportSize);
        }
        throw new IllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.".toString());
    }

    public Object bringChildIntoView(Function0<Rect> localRect, Continuation<? super Unit> $completion) {
        Rect invoke = localRect.invoke();
        boolean z = false;
        if (invoke != null && !m531isMaxVisibleO0kMr_c$default(this, invoke, 0, 1, (Object) null)) {
            z = true;
        }
        if (!z) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellable$iv.initCancellability();
        if (this.bringIntoViewRequests.enqueue(new Request(localRect, cancellable$iv)) && !this.isAnimationRunning) {
            launchAnimation();
        }
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    public void onPlaced(LayoutCoordinates coordinates2) {
        Intrinsics.checkNotNullParameter(coordinates2, "coordinates");
        this.coordinates = coordinates2;
    }

    /* renamed from: onRemeasured-ozmzZPI  reason: not valid java name */
    public void m533onRemeasuredozmzZPI(long size) {
        Rect focusedChild2;
        long oldSize = this.viewportSize;
        this.viewportSize = size;
        if (m527compareToTemP2vQ(size, oldSize) < 0 && (focusedChild2 = getFocusedChildBounds()) != null) {
            Rect previousFocusedChildBounds = this.focusedChildBoundsFromPreviousRemeasure;
            if (previousFocusedChildBounds == null) {
                previousFocusedChildBounds = focusedChild2;
            }
            if (!this.isAnimationRunning && !this.trackingFocusedChild && m530isMaxVisibleO0kMr_c(previousFocusedChildBounds, oldSize) && !m530isMaxVisibleO0kMr_c(focusedChild2, size)) {
                this.trackingFocusedChild = true;
                launchAnimation();
            }
            this.focusedChildBoundsFromPreviousRemeasure = focusedChild2;
        }
    }

    /* access modifiers changed from: private */
    public final Rect getFocusedChildBounds() {
        LayoutCoordinates it;
        LayoutCoordinates coordinates2 = this.coordinates;
        if (coordinates2 != null) {
            if (!coordinates2.isAttached()) {
                coordinates2 = null;
            }
            if (!(coordinates2 == null || (it = this.focusedChild) == null)) {
                if (!it.isAttached()) {
                    it = null;
                }
                if (it != null) {
                    return coordinates2.localBoundingBoxOf(it, false);
                }
            }
            return null;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final void launchAnimation() {
        if (!this.isAnimationRunning) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new ContentInViewModifier$launchAnimation$1(this, (Continuation<? super ContentInViewModifier$launchAnimation$1>) null), 1, (Object) null);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* access modifiers changed from: private */
    public final float calculateScrollDelta() {
        if (IntSize.m6144equalsimpl0(this.viewportSize, IntSize.Companion.m6151getZeroYbymL2g())) {
            return 0.0f;
        }
        Rect rectangleToMakeVisible = findBringIntoViewRequest();
        if (rectangleToMakeVisible == null) {
            rectangleToMakeVisible = this.trackingFocusedChild ? getFocusedChildBounds() : null;
            if (rectangleToMakeVisible == null) {
                return 0.0f;
            }
        }
        long size = IntSizeKt.m6156toSizeozmzZPI(this.viewportSize);
        switch (WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()]) {
            case 1:
                return relocationDistance(rectangleToMakeVisible.getTop(), rectangleToMakeVisible.getBottom(), Size.m2981getHeightimpl(size));
            case 2:
                return relocationDistance(rectangleToMakeVisible.getLeft(), rectangleToMakeVisible.getRight(), Size.m2984getWidthimpl(size));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final Rect findBringIntoViewRequest() {
        int $i$f$forEachFromSmallest;
        BringIntoViewRequestPriorityQueue this_$iv;
        Rect rect = null;
        BringIntoViewRequestPriorityQueue this_$iv2 = this.bringIntoViewRequests;
        int $i$f$forEachFromSmallest2 = 0;
        MutableVector this_$iv$iv = this_$iv2.requests;
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = size$iv$iv - 1;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            while (true) {
                Rect bounds = ((Request) content$iv$iv[i$iv$iv]).getCurrentBounds().invoke();
                if (bounds != null) {
                    this_$iv = this_$iv2;
                    $i$f$forEachFromSmallest = $i$f$forEachFromSmallest2;
                    if (m528compareToiLBOSCw(bounds.m2948getSizeNHjbRc(), IntSizeKt.m6156toSizeozmzZPI(this.viewportSize)) > 0) {
                        return rect;
                    }
                    rect = bounds;
                } else {
                    this_$iv = this_$iv2;
                    $i$f$forEachFromSmallest = $i$f$forEachFromSmallest2;
                }
                i$iv$iv--;
                if (i$iv$iv < 0) {
                    break;
                }
                this_$iv2 = this_$iv;
                $i$f$forEachFromSmallest2 = $i$f$forEachFromSmallest;
            }
        }
        return rect;
    }

    /* renamed from: computeDestination-O0kMr_c  reason: not valid java name */
    private final Rect m529computeDestinationO0kMr_c(Rect childBounds, long containerSize) {
        return childBounds.m2952translatek4lQ0M(Offset.m2924unaryMinusF1C5BW0(m532relocationOffsetBMxPBkI(childBounds, containerSize)));
    }

    /* renamed from: isMaxVisible-O0kMr_c$default  reason: not valid java name */
    static /* synthetic */ boolean m531isMaxVisibleO0kMr_c$default(ContentInViewModifier contentInViewModifier, Rect rect, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = contentInViewModifier.viewportSize;
        }
        return contentInViewModifier.m530isMaxVisibleO0kMr_c(rect, j);
    }

    /* renamed from: isMaxVisible-O0kMr_c  reason: not valid java name */
    private final boolean m530isMaxVisibleO0kMr_c(Rect $this$isMaxVisible_u2dO0kMr_c, long size) {
        return Offset.m2912equalsimpl0(m532relocationOffsetBMxPBkI($this$isMaxVisible_u2dO0kMr_c, size), Offset.Companion.m2931getZeroF1C5BW0());
    }

    /* renamed from: relocationOffset-BMxPBkI  reason: not valid java name */
    private final long m532relocationOffsetBMxPBkI(Rect childBounds, long containerSize) {
        long size = IntSizeKt.m6156toSizeozmzZPI(containerSize);
        switch (WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()]) {
            case 1:
                return OffsetKt.Offset(0.0f, relocationDistance(childBounds.getTop(), childBounds.getBottom(), Size.m2981getHeightimpl(size)));
            case 2:
                return OffsetKt.Offset(relocationDistance(childBounds.getLeft(), childBounds.getRight(), Size.m2984getWidthimpl(size)), 0.0f);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final float relocationDistance(float leadingEdge, float trailingEdge, float containerSize) {
        if (leadingEdge >= 0.0f && trailingEdge <= containerSize) {
            return 0.0f;
        }
        if (leadingEdge < 0.0f && trailingEdge > containerSize) {
            return 0.0f;
        }
        if (Math.abs(leadingEdge) < Math.abs(trailingEdge - containerSize)) {
            return leadingEdge;
        }
        return trailingEdge - containerSize;
    }

    /* renamed from: compareTo-TemP2vQ  reason: not valid java name */
    private final int m527compareToTemP2vQ(long $this$compareTo_u2dTemP2vQ, long other) {
        switch (WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()]) {
            case 1:
                return Intrinsics.compare(IntSize.m6145getHeightimpl($this$compareTo_u2dTemP2vQ), IntSize.m6145getHeightimpl(other));
            case 2:
                return Intrinsics.compare(IntSize.m6146getWidthimpl($this$compareTo_u2dTemP2vQ), IntSize.m6146getWidthimpl(other));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: compareTo-iLBOSCw  reason: not valid java name */
    private final int m528compareToiLBOSCw(long $this$compareTo_u2diLBOSCw, long other) {
        switch (WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()]) {
            case 1:
                return Float.compare(Size.m2981getHeightimpl($this$compareTo_u2diLBOSCw), Size.m2981getHeightimpl(other));
            case 2:
                return Float.compare(Size.m2984getWidthimpl($this$compareTo_u2diLBOSCw), Size.m2984getWidthimpl(other));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/gestures/ContentInViewModifier$Request;", "", "currentBounds", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CancellableContinuation;)V", "getContinuation", "()Lkotlinx/coroutines/CancellableContinuation;", "getCurrentBounds", "()Lkotlin/jvm/functions/Function0;", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ContentInViewModifier.kt */
    public static final class Request {
        private final CancellableContinuation<Unit> continuation;
        private final Function0<Rect> currentBounds;

        public Request(Function0<Rect> currentBounds2, CancellableContinuation<? super Unit> continuation2) {
            Intrinsics.checkNotNullParameter(currentBounds2, "currentBounds");
            Intrinsics.checkNotNullParameter(continuation2, "continuation");
            this.currentBounds = currentBounds2;
            this.continuation = continuation2;
        }

        public final Function0<Rect> getCurrentBounds() {
            return this.currentBounds;
        }

        public final CancellableContinuation<Unit> getContinuation() {
            return this.continuation;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0058, code lost:
            if (r2 == null) goto L_0x005a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String toString() {
            /*
                r6 = this;
                kotlinx.coroutines.CancellableContinuation<kotlin.Unit> r0 = r6.continuation
                kotlin.coroutines.CoroutineContext r0 = r0.getContext()
                kotlinx.coroutines.CoroutineName$Key r1 = kotlinx.coroutines.CoroutineName.Key
                kotlin.coroutines.CoroutineContext$Key r1 = (kotlin.coroutines.CoroutineContext.Key) r1
                kotlin.coroutines.CoroutineContext$Element r0 = r0.get(r1)
                kotlinx.coroutines.CoroutineName r0 = (kotlinx.coroutines.CoroutineName) r0
                if (r0 == 0) goto L_0x0017
                java.lang.String r0 = r0.getName()
                goto L_0x0018
            L_0x0017:
                r0 = 0
            L_0x0018:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Request@"
                java.lang.StringBuilder r1 = r1.append(r2)
                int r2 = r6.hashCode()
                r3 = 16
                int r3 = kotlin.text.CharsKt.checkRadix(r3)
                java.lang.String r2 = java.lang.Integer.toString(r2, r3)
                java.lang.String r3 = "toString(this, checkRadix(radix))"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                java.lang.StringBuilder r1 = r1.append(r2)
                if (r0 == 0) goto L_0x005a
                r2 = r0
                r3 = 0
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r5 = 91
                java.lang.StringBuilder r4 = r4.append(r5)
                java.lang.StringBuilder r4 = r4.append(r2)
                java.lang.String r5 = "]("
                java.lang.StringBuilder r4 = r4.append(r5)
                java.lang.String r2 = r4.toString()
                if (r2 != 0) goto L_0x005c
            L_0x005a:
                java.lang.String r2 = "("
            L_0x005c:
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r2 = "currentBounds()="
                java.lang.StringBuilder r1 = r1.append(r2)
                kotlin.jvm.functions.Function0<androidx.compose.ui.geometry.Rect> r2 = r6.currentBounds
                java.lang.Object r2 = r2.invoke()
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r2 = ", continuation="
                java.lang.StringBuilder r1 = r1.append(r2)
                kotlinx.coroutines.CancellableContinuation<kotlin.Unit> r2 = r6.continuation
                java.lang.StringBuilder r1 = r1.append(r2)
                r2 = 41
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r1 = r1.toString()
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ContentInViewModifier.Request.toString():java.lang.String");
        }
    }
}
