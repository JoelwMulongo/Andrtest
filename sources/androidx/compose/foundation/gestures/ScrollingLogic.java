package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ!\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b#\u0010$J!\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020!H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b(\u0010$J\u001b\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-J\u000e\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\u0005J\u0006\u00100\u001a\u00020\u0005J'\u00101\u001a\u00020**\u0002022\u0006\u00103\u001a\u00020*2\u0006\u00104\u001a\u000205ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020**\u00020*ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010-J\n\u00108\u001a\u00020:*\u00020:J\u0017\u0010;\u001a\u00020**\u00020*ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010-J\u0017\u0010=\u001a\u00020!*\u00020!ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010-J\u0017\u0010?\u001a\u00020:*\u00020*ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u0010AJ\u0017\u0010?\u001a\u00020:*\u00020!ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u0010AJ\u001a\u0010C\u001a\u00020**\u00020:ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bD\u0010EJ\u001f\u0010F\u001a\u00020!*\u00020!2\u0006\u0010G\u001a\u00020:ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bH\u0010IR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001b\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006J"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "", "nestedScrollDispatcher", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/runtime/State;Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/OverscrollEffect;)V", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "isNestedFlinging", "Landroidx/compose/runtime/MutableState;", "getNestedScrollDispatcher", "()Landroidx/compose/runtime/State;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getOverscrollEffect", "()Landroidx/compose/foundation/OverscrollEffect;", "getReverseDirection", "()Z", "getScrollableState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "shouldDispatchOverscroll", "getShouldDispatchOverscroll", "doFlingAnimation", "Landroidx/compose/ui/unit/Velocity;", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped", "", "initialVelocity", "onDragStopped-sF-c-tU", "performRawScroll", "Landroidx/compose/ui/geometry/Offset;", "scroll", "performRawScroll-MK-Hz9U", "(J)J", "registerNestedFling", "isFlinging", "shouldScrollImmediately", "dispatchScroll", "Landroidx/compose/foundation/gestures/ScrollScope;", "availableDelta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "", "singleAxisOffset", "singleAxisOffset-MK-Hz9U", "singleAxisVelocity", "singleAxisVelocity-AH228Gc", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "update", "newValue", "update-QWom1Mo", "(JF)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
final class ScrollingLogic {
    private final FlingBehavior flingBehavior;
    private final MutableState<Boolean> isNestedFlinging = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final State<NestedScrollDispatcher> nestedScrollDispatcher;
    private final Orientation orientation;
    private final OverscrollEffect overscrollEffect;
    private final boolean reverseDirection;
    private final ScrollableState scrollableState;

    public ScrollingLogic(Orientation orientation2, boolean reverseDirection2, State<NestedScrollDispatcher> nestedScrollDispatcher2, ScrollableState scrollableState2, FlingBehavior flingBehavior2, OverscrollEffect overscrollEffect2) {
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        Intrinsics.checkNotNullParameter(nestedScrollDispatcher2, "nestedScrollDispatcher");
        Intrinsics.checkNotNullParameter(scrollableState2, "scrollableState");
        Intrinsics.checkNotNullParameter(flingBehavior2, "flingBehavior");
        this.orientation = orientation2;
        this.reverseDirection = reverseDirection2;
        this.nestedScrollDispatcher = nestedScrollDispatcher2;
        this.scrollableState = scrollableState2;
        this.flingBehavior = flingBehavior2;
        this.overscrollEffect = overscrollEffect2;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    public final State<NestedScrollDispatcher> getNestedScrollDispatcher() {
        return this.nestedScrollDispatcher;
    }

    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    public final OverscrollEffect getOverscrollEffect() {
        return this.overscrollEffect;
    }

    /* renamed from: toOffset-tuRUvjQ  reason: not valid java name */
    public final long m635toOffsettuRUvjQ(float $this$toOffset_u2dtuRUvjQ) {
        if ($this$toOffset_u2dtuRUvjQ == 0.0f) {
            return Offset.Companion.m2931getZeroF1C5BW0();
        }
        if (this.orientation == Orientation.Horizontal) {
            return OffsetKt.Offset($this$toOffset_u2dtuRUvjQ, 0.0f);
        }
        return OffsetKt.Offset(0.0f, $this$toOffset_u2dtuRUvjQ);
    }

    /* renamed from: singleAxisOffset-MK-Hz9U  reason: not valid java name */
    public final long m631singleAxisOffsetMKHz9U(long $this$singleAxisOffset_u2dMK_u2dHz9U) {
        return Offset.m2909copydBAh8RU$default($this$singleAxisOffset_u2dMK_u2dHz9U, 0.0f, 0.0f, this.orientation == Orientation.Horizontal ? 1 : 2, (Object) null);
    }

    /* renamed from: toFloat-k-4lQ0M  reason: not valid java name */
    public final float m634toFloatk4lQ0M(long $this$toFloat_u2dk_u2d4lQ0M) {
        return this.orientation == Orientation.Horizontal ? Offset.m2915getXimpl($this$toFloat_u2dk_u2d4lQ0M) : Offset.m2916getYimpl($this$toFloat_u2dk_u2d4lQ0M);
    }

    /* renamed from: toFloat-TH1AsA0  reason: not valid java name */
    public final float m633toFloatTH1AsA0(long $this$toFloat_u2dTH1AsA0) {
        return this.orientation == Orientation.Horizontal ? Velocity.m6211getXimpl($this$toFloat_u2dTH1AsA0) : Velocity.m6212getYimpl($this$toFloat_u2dTH1AsA0);
    }

    /* renamed from: singleAxisVelocity-AH228Gc  reason: not valid java name */
    public final long m632singleAxisVelocityAH228Gc(long $this$singleAxisVelocity_u2dAH228Gc) {
        return Velocity.m6207copyOhffZ5M$default($this$singleAxisVelocity_u2dAH228Gc, 0.0f, 0.0f, this.orientation == Orientation.Horizontal ? 1 : 2, (Object) null);
    }

    /* renamed from: update-QWom1Mo  reason: not valid java name */
    public final long m636updateQWom1Mo(long $this$update_u2dQWom1Mo, float newValue) {
        Object obj;
        int i;
        float f;
        float f2;
        long j;
        if (this.orientation == Orientation.Horizontal) {
            f = 0.0f;
            i = 2;
            obj = null;
            j = $this$update_u2dQWom1Mo;
            f2 = newValue;
        } else {
            f2 = 0.0f;
            i = 1;
            obj = null;
            j = $this$update_u2dQWom1Mo;
            f = newValue;
        }
        return Velocity.m6207copyOhffZ5M$default(j, f2, f, i, obj);
    }

    public final float reverseIfNeeded(float $this$reverseIfNeeded) {
        return this.reverseDirection ? ((float) -1) * $this$reverseIfNeeded : $this$reverseIfNeeded;
    }

    /* renamed from: reverseIfNeeded-MK-Hz9U  reason: not valid java name */
    public final long m630reverseIfNeededMKHz9U(long $this$reverseIfNeeded_u2dMK_u2dHz9U) {
        return this.reverseDirection ? Offset.m2922timestuRUvjQ($this$reverseIfNeeded_u2dMK_u2dHz9U, -1.0f) : $this$reverseIfNeeded_u2dMK_u2dHz9U;
    }

    /* renamed from: dispatchScroll-3eAAhYA  reason: not valid java name */
    public final long m626dispatchScroll3eAAhYA(ScrollScope $this$dispatchScroll_u2d3eAAhYA, long availableDelta, int source) {
        Intrinsics.checkNotNullParameter($this$dispatchScroll_u2d3eAAhYA, "$this$dispatchScroll");
        long scrollDelta = m631singleAxisOffsetMKHz9U(availableDelta);
        Function1 performScroll = new ScrollingLogic$dispatchScroll$performScroll$1(this, source, $this$dispatchScroll_u2d3eAAhYA);
        if (this.overscrollEffect == null || !getShouldDispatchOverscroll()) {
            return ((Offset) performScroll.invoke(Offset.m2904boximpl(scrollDelta))).m2925unboximpl();
        }
        return this.overscrollEffect.m519applyToScrollRhakbz0(scrollDelta, source, performScroll);
    }

    private final boolean getShouldDispatchOverscroll() {
        return this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward();
    }

    /* renamed from: performRawScroll-MK-Hz9U  reason: not valid java name */
    public final long m629performRawScrollMKHz9U(long scroll) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.Companion.m2931getZeroF1C5BW0();
        }
        return m635toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m634toFloatk4lQ0M(scroll)))));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: onDragStopped-sF-c-tU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m628onDragStoppedsFctU(long r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            r0.<init>(r6, r9)
        L_0x0019:
            r9 = r0
            java.lang.Object r0 = r9.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r9.label
            switch(r2) {
                case 0: goto L_0x003d;
                case 1: goto L_0x0035;
                case 2: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x002d:
            java.lang.Object r7 = r9.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r7 = (androidx.compose.foundation.gestures.ScrollingLogic) r7
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x007b
        L_0x0035:
            java.lang.Object r7 = r9.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r7 = (androidx.compose.foundation.gestures.ScrollingLogic) r7
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0069
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r6
            r3 = 1
            r2.registerNestedFling(r3)
            long r7 = r2.m632singleAxisVelocityAH228Gc(r7)
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1 r4 = new androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1
            r5 = 0
            r4.<init>(r2, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            androidx.compose.foundation.OverscrollEffect r5 = r2.overscrollEffect
            if (r5 == 0) goto L_0x006a
            boolean r5 = r2.getShouldDispatchOverscroll()
            if (r5 == 0) goto L_0x006a
            androidx.compose.foundation.OverscrollEffect r5 = r2.overscrollEffect
            r9.L$0 = r2
            r9.label = r3
            java.lang.Object r7 = r5.m518applyToFlingBMRW4eQ(r7, r4, r9)
            if (r7 != r1) goto L_0x0068
            return r1
        L_0x0068:
            r7 = r2
        L_0x0069:
            goto L_0x007c
        L_0x006a:
            androidx.compose.ui.unit.Velocity r3 = androidx.compose.ui.unit.Velocity.m6202boximpl(r7)
            r9.L$0 = r2
            r5 = 2
            r9.label = r5
            java.lang.Object r7 = r4.invoke(r3, r9)
            if (r7 != r1) goto L_0x007a
            return r1
        L_0x007a:
            r7 = r2
        L_0x007b:
        L_0x007c:
            r8 = 0
            r7.registerNestedFling(r8)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m628onDragStoppedsFctU(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* renamed from: doFlingAnimation-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m627doFlingAnimationQWom1Mo(long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r20) {
        /*
            r17 = this;
            r0 = r20
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            if (r1 == 0) goto L_0x0019
            r1 = r0
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r1 = (androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0019
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r17
            goto L_0x0021
        L_0x0019:
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r1 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            r2 = r17
            r1.<init>(r2, r0)
            r0 = r1
        L_0x0021:
            java.lang.Object r1 = r0.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            switch(r3) {
                case 0: goto L_0x003c;
                case 1: goto L_0x0034;
                default: goto L_0x002c;
            }
        L_0x002c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0034:
            java.lang.Object r3 = r0.L$0
            kotlin.jvm.internal.Ref$LongRef r3 = (kotlin.jvm.internal.Ref.LongRef) r3
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0073
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r1)
            r8 = r17
            r6 = r18
            kotlin.jvm.internal.Ref$LongRef r3 = new kotlin.jvm.internal.Ref$LongRef
            r3.<init>()
            r5 = r3
            r5.element = r6
            androidx.compose.foundation.gestures.ScrollableState r3 = r8.scrollableState
            r4 = 0
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2 r16 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2
            r15 = 0
            r10 = r16
            r11 = r8
            r12 = r5
            r13 = r6
            r10.<init>(r11, r12, r13, r15)
            r10 = r16
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r11 = 1
            r12 = 0
            r0.L$0 = r5
            r13 = 1
            r0.label = r13
            r13 = r5
            r5 = r10
            r14 = r6
            r6 = r0
            r7 = r11
            r10 = r8
            r8 = r12
            java.lang.Object r3 = androidx.compose.foundation.gestures.ScrollableState.scroll$default(r3, r4, r5, r6, r7, r8)
            if (r3 != r9) goto L_0x0072
            return r9
        L_0x0072:
            r3 = r13
        L_0x0073:
            long r4 = r3.element
            androidx.compose.ui.unit.Velocity r4 = androidx.compose.ui.unit.Velocity.m6202boximpl(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m627doFlingAnimationQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean shouldScrollImmediately() {
        if (!this.scrollableState.isScrollInProgress() && !this.isNestedFlinging.getValue().booleanValue()) {
            OverscrollEffect overscrollEffect2 = this.overscrollEffect;
            return overscrollEffect2 != null ? overscrollEffect2.isInProgress() : false;
        }
    }

    public final void registerNestedFling(boolean isFlinging) {
        this.isNestedFlinging.setValue(Boolean.valueOf(isFlinging));
    }
}
