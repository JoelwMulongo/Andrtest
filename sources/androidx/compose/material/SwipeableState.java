package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0017\b\u0017\u0018\u0000 t*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001tBB\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\b\u0002\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0002\u0010\rJ'\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u00062\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010aJ)\u0010b\u001a\u00020^2\u0006\u0010O\u001a\u00028\u00002\u000e\b\u0002\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010dJ!\u0010e\u001a\u00020^2\u0012\u0010f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0011H\u0000¢\u0006\u0002\bgJ\u000e\u0010h\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u0006J\u0019\u0010j\u001a\u00020^2\u0006\u0010k\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010lJ;\u0010m\u001a\u00020^2\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0011H@ø\u0001\u0000¢\u0006\u0004\bo\u0010pJ\u0019\u0010q\u001a\u00020^2\u0006\u0010_\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010lJ\u0019\u0010r\u001a\u00020^2\u0006\u0010O\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010sR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fX\u0004¢\u0006\u0002\n\u0000RC\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00118@@@X\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000fX\u0004¢\u0006\u0002\n\u0000R/\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR+\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00008F@BX\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0018\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020\u00068FX\u0004¢\u0006\f\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R+\u0010-\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f8F@BX\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0018\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u001103X\u0004¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010(\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010(\"\u0004\b:\u00107R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00060<8F¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00060<8F¢\u0006\u0006\u001a\u0004\bA\u0010>R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fX\u0004¢\u0006\u0002\n\u0000R \u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000D8FX\u0004¢\u0006\f\u0012\u0004\bE\u0010&\u001a\u0004\bF\u0010GR/\u0010I\u001a\u0004\u0018\u00010H2\b\u0010\u0010\u001a\u0004\u0018\u00010H8@@@X\u0002¢\u0006\u0012\n\u0004\bN\u0010\u0018\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001a\u0010O\u001a\u00028\u00008FX\u0004¢\u0006\f\u0012\u0004\bP\u0010&\u001a\u0004\bQ\u0010 RO\u0010S\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060R2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060R8@@@X\u0002¢\u0006\u0012\n\u0004\bX\u0010\u0018\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR+\u0010Y\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068@@@X\u0002¢\u0006\u0012\n\u0004\b\\\u0010\u0018\u001a\u0004\bZ\u0010(\"\u0004\b[\u00107\u0002\u0004\n\u0002\b\u0019¨\u0006u"}, d2 = {"Landroidx/compose/material/SwipeableState;", "T", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "absoluteOffset", "Landroidx/compose/runtime/MutableState;", "<set-?>", "", "anchors", "getAnchors$material_release", "()Ljava/util/Map;", "setAnchors$material_release", "(Ljava/util/Map;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec$material_release", "()Landroidx/compose/animation/core/AnimationSpec;", "animationTarget", "getConfirmStateChange$material_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "currentValue$delegate", "direction", "getDirection$annotations", "()V", "getDirection", "()F", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$material_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "isAnimationRunning", "()Z", "setAnimationRunning", "(Z)V", "isAnimationRunning$delegate", "latestNonEmptyAnchorsFlow", "Lkotlinx/coroutines/flow/Flow;", "maxBound", "getMaxBound$material_release", "setMaxBound$material_release", "(F)V", "minBound", "getMinBound$material_release", "setMinBound$material_release", "offset", "Landroidx/compose/runtime/State;", "getOffset", "()Landroidx/compose/runtime/State;", "offsetState", "overflow", "getOverflow", "overflowState", "progress", "Landroidx/compose/material/SwipeProgress;", "getProgress$annotations", "getProgress", "()Landroidx/compose/material/SwipeProgress;", "Landroidx/compose/material/ResistanceConfig;", "resistance", "getResistance$material_release", "()Landroidx/compose/material/ResistanceConfig;", "setResistance$material_release", "(Landroidx/compose/material/ResistanceConfig;)V", "resistance$delegate", "targetValue", "getTargetValue$annotations", "getTargetValue", "Lkotlin/Function2;", "thresholds", "getThresholds$material_release", "()Lkotlin/jvm/functions/Function2;", "setThresholds$material_release", "(Lkotlin/jvm/functions/Function2;)V", "thresholds$delegate", "velocityThreshold", "getVelocityThreshold$material_release", "setVelocityThreshold$material_release", "velocityThreshold$delegate", "animateInternalToOffset", "", "target", "spec", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "anim", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureInit", "newAnchors", "ensureInit$material_release", "performDrag", "delta", "performFling", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processNewAnchors", "oldAnchors", "processNewAnchors$material_release", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapInternalToOffset", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Swipeable.kt */
public class SwipeableState<T> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final MutableState<Float> absoluteOffset;
    private final MutableState anchors$delegate;
    private final AnimationSpec<Float> animationSpec;
    /* access modifiers changed from: private */
    public final MutableState<Float> animationTarget;
    private final Function1<T, Boolean> confirmStateChange;
    private final MutableState currentValue$delegate;
    private final DraggableState draggableState;
    private final MutableState isAnimationRunning$delegate;
    private final Flow<Map<Float, T>> latestNonEmptyAnchorsFlow;
    private float maxBound;
    private float minBound;
    /* access modifiers changed from: private */
    public final MutableState<Float> offsetState;
    /* access modifiers changed from: private */
    public final MutableState<Float> overflowState;
    private final MutableState resistance$delegate;
    private final MutableState thresholds$delegate;
    private final MutableState velocityThreshold$delegate;

    public static /* synthetic */ void getDirection$annotations() {
    }

    public static /* synthetic */ void getProgress$annotations() {
    }

    public static /* synthetic */ void getTargetValue$annotations() {
    }

    public SwipeableState(T initialValue, AnimationSpec<Float> animationSpec2, Function1<? super T, Boolean> confirmStateChange2) {
        Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmStateChange2, "confirmStateChange");
        this.animationSpec = animationSpec2;
        this.confirmStateChange = confirmStateChange2;
        this.currentValue$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialValue, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isAnimationRunning$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        Float valueOf = Float.valueOf(0.0f);
        this.offsetState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.overflowState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.absoluteOffset = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.animationTarget = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.anchors$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.latestNonEmptyAnchorsFlow = FlowKt.take(new SwipeableState$special$$inlined$filter$1(SnapshotStateKt.snapshotFlow(new SwipeableState$latestNonEmptyAnchorsFlow$1(this))), 1);
        this.minBound = Float.NEGATIVE_INFINITY;
        this.maxBound = Float.POSITIVE_INFINITY;
        this.thresholds$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(SwipeableState$thresholds$2.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.velocityThreshold$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.resistance$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.draggableState = DraggableKt.DraggableState(new SwipeableState$draggableState$1(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SwipeableState(Object obj, AnimationSpec animationSpec2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec2, (i & 4) != 0 ? AnonymousClass1.INSTANCE : function1);
    }

    public final AnimationSpec<Float> getAnimationSpec$material_release() {
        return this.animationSpec;
    }

    public final Function1<T, Boolean> getConfirmStateChange$material_release() {
        return this.confirmStateChange;
    }

    /* access modifiers changed from: private */
    public final void setCurrentValue(T t) {
        this.currentValue$delegate.setValue(t);
    }

    public final T getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void setAnimationRunning(boolean z) {
        this.isAnimationRunning$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean isAnimationRunning() {
        return ((Boolean) this.isAnimationRunning$delegate.getValue()).booleanValue();
    }

    public final State<Float> getOffset() {
        return this.offsetState;
    }

    public final State<Float> getOverflow() {
        return this.overflowState;
    }

    public final Map<Float, T> getAnchors$material_release() {
        return (Map) this.anchors$delegate.getValue();
    }

    public final void setAnchors$material_release(Map<Float, ? extends T> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.anchors$delegate.setValue(map);
    }

    public final float getMinBound$material_release() {
        return this.minBound;
    }

    public final void setMinBound$material_release(float f) {
        this.minBound = f;
    }

    public final float getMaxBound$material_release() {
        return this.maxBound;
    }

    public final void setMaxBound$material_release(float f) {
        this.maxBound = f;
    }

    public final void ensureInit$material_release(Map<Float, ? extends T> newAnchors) {
        Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
        if (getAnchors$material_release().isEmpty()) {
            Float initialOffset = SwipeableKt.getOffset(newAnchors, getCurrentValue());
            if (initialOffset != null) {
                this.offsetState.setValue(initialOffset);
                this.absoluteOffset.setValue(initialOffset);
                return;
            }
            throw new IllegalArgumentException("The initial value must have an associated anchor.".toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a5, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01f2, code lost:
        r2.setCurrentValue(kotlin.collections.MapsKt.getValue(r14, kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)));
        r13 = kotlin.collections.CollectionsKt.minOrNull(r14.keySet());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r13);
        r2.minBound = r13.floatValue();
        r13 = kotlin.collections.CollectionsKt.maxOrNull(r14.keySet());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r13);
        r2.maxBound = r13.floatValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0236, code lost:
        r1.setCurrentValue(kotlin.collections.MapsKt.getValue(r14, kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)));
        r13 = kotlin.collections.CollectionsKt.minOrNull(r14.keySet());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r13);
        r1.minBound = r13.floatValue();
        r13 = kotlin.collections.CollectionsKt.maxOrNull(r14.keySet());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r13);
        r1.maxBound = r13.floatValue();
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.Map<java.lang.Float, ? extends T>, code=java.util.Map, for r14v0, types: [java.util.Map<java.lang.Float, ? extends T>, java.util.Map, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processNewAnchors$material_release(java.util.Map<java.lang.Float, ? extends T> r13, java.util.Map r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof androidx.compose.material.SwipeableState$processNewAnchors$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            androidx.compose.material.SwipeableState$processNewAnchors$1 r0 = (androidx.compose.material.SwipeableState$processNewAnchors$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            androidx.compose.material.SwipeableState$processNewAnchors$1 r0 = new androidx.compose.material.SwipeableState$processNewAnchors$1
            r0.<init>(r12, r15)
        L_0x0019:
            r15 = r0
            java.lang.Object r0 = r15.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r15.label
            switch(r2) {
                case 0: goto L_0x005b;
                case 1: goto L_0x0057;
                case 2: goto L_0x003f;
                case 3: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x002d:
            float r13 = r15.F$0
            java.lang.Object r14 = r15.L$1
            java.util.Map r14 = (java.util.Map) r14
            java.lang.Object r1 = r15.L$0
            androidx.compose.material.SwipeableState r1 = (androidx.compose.material.SwipeableState) r1
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x003c }
            goto L_0x0236
        L_0x003c:
            r2 = move-exception
            goto L_0x0268
        L_0x003f:
            float r13 = r15.F$0
            java.lang.Object r14 = r15.L$1
            java.util.Map r14 = (java.util.Map) r14
            java.lang.Object r2 = r15.L$0
            androidx.compose.material.SwipeableState r2 = (androidx.compose.material.SwipeableState) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ CancellationException -> 0x0054 }
            goto L_0x01f2
        L_0x004e:
            r1 = move-exception
            r11 = r2
            r2 = r1
            r1 = r11
            goto L_0x0268
        L_0x0054:
            r3 = move-exception
            goto L_0x0225
        L_0x0057:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00a3
        L_0x005b:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r12
            boolean r3 = r13.isEmpty()
            if (r3 == 0) goto L_0x00b4
            java.util.Set r13 = r14.keySet()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.lang.Float r13 = kotlin.collections.CollectionsKt.minOrNull(r13)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            float r13 = r13.floatValue()
            r2.minBound = r13
            java.util.Set r13 = r14.keySet()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.lang.Float r13 = kotlin.collections.CollectionsKt.maxOrNull(r13)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            float r13 = r13.floatValue()
            r2.maxBound = r13
            java.lang.Object r13 = r2.getCurrentValue()
            java.lang.Float r13 = androidx.compose.material.SwipeableKt.getOffset(r14, r13)
            if (r13 == 0) goto L_0x00a6
            float r14 = r13.floatValue()
            r3 = 1
            r15.label = r3
            java.lang.Object r13 = r2.snapInternalToOffset(r14, r15)
            if (r13 != r1) goto L_0x00a3
            return r1
        L_0x00a3:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x00a6:
            r13 = 0
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "The initial value must have an associated anchor."
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L_0x00b4:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r13)
            if (r3 != 0) goto L_0x00a3
            r3 = -8388608(0xffffffffff800000, float:-Infinity)
            r2.minBound = r3
            r3 = 2139095040(0x7f800000, float:Infinity)
            r2.maxBound = r3
            androidx.compose.runtime.MutableState<java.lang.Float> r3 = r2.animationTarget
            java.lang.Object r3 = r3.getValue()
            java.lang.Float r3 = (java.lang.Float) r3
            r4 = 0
            if (r3 == 0) goto L_0x0141
            java.lang.Object r13 = r13.get(r3)
            java.lang.Float r13 = androidx.compose.material.SwipeableKt.getOffset(r14, r13)
            if (r13 == 0) goto L_0x00dd
            float r4 = r13.floatValue()
            goto L_0x01de
        L_0x00dd:
            java.util.Set r13 = r14.keySet()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            r5 = 0
            java.util.Iterator r6 = r13.iterator()
            boolean r13 = r6.hasNext()
            if (r13 != 0) goto L_0x00ef
            goto L_0x0136
        L_0x00ef:
            java.lang.Object r4 = r6.next()
            boolean r13 = r6.hasNext()
            if (r13 != 0) goto L_0x00fa
            goto L_0x0136
        L_0x00fa:
            r13 = r4
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            r7 = 0
            float r8 = r3.floatValue()
            float r8 = r13 - r8
            float r8 = java.lang.Math.abs(r8)
            r13 = r8
        L_0x010d:
            java.lang.Object r7 = r6.next()
            r8 = r7
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            r9 = 0
            float r10 = r3.floatValue()
            float r10 = r8 - r10
            float r10 = java.lang.Math.abs(r10)
            r8 = r10
            int r9 = java.lang.Float.compare(r13, r8)
            if (r9 <= 0) goto L_0x012f
            r13 = r7
            r4 = r8
            r11 = r4
            r4 = r13
            r13 = r11
        L_0x012f:
            boolean r7 = r6.hasNext()
            if (r7 != 0) goto L_0x010d
        L_0x0136:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            goto L_0x01de
        L_0x0141:
            androidx.compose.runtime.State r3 = r2.getOffset()
            java.lang.Object r3 = r3.getValue()
            java.lang.Object r13 = r13.get(r3)
            java.lang.Object r3 = r2.getCurrentValue()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x015c
            java.lang.Object r3 = r2.getCurrentValue()
            r13 = r3
        L_0x015c:
            java.lang.Float r13 = androidx.compose.material.SwipeableKt.getOffset(r14, r13)
            if (r13 == 0) goto L_0x0168
            float r4 = r13.floatValue()
            goto L_0x01de
        L_0x0168:
            java.util.Set r13 = r14.keySet()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            r3 = 0
            java.util.Iterator r5 = r13.iterator()
            boolean r13 = r5.hasNext()
            if (r13 != 0) goto L_0x017a
            goto L_0x01d5
        L_0x017a:
            java.lang.Object r4 = r5.next()
            boolean r13 = r5.hasNext()
            if (r13 != 0) goto L_0x0185
            goto L_0x01d5
        L_0x0185:
            r13 = r4
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            r6 = 0
            androidx.compose.runtime.State r7 = r2.getOffset()
            java.lang.Object r7 = r7.getValue()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            float r7 = r13 - r7
            float r7 = java.lang.Math.abs(r7)
            r13 = r7
        L_0x01a2:
            java.lang.Object r6 = r5.next()
            r7 = r6
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            r8 = 0
            androidx.compose.runtime.State r9 = r2.getOffset()
            java.lang.Object r9 = r9.getValue()
            java.lang.Number r9 = (java.lang.Number) r9
            float r9 = r9.floatValue()
            float r9 = r7 - r9
            float r9 = java.lang.Math.abs(r9)
            r7 = r9
            int r8 = java.lang.Float.compare(r13, r7)
            if (r8 <= 0) goto L_0x01ce
            r13 = r6
            r4 = r7
            r11 = r4
            r4 = r13
            r13 = r11
        L_0x01ce:
            boolean r6 = r5.hasNext()
            if (r6 != 0) goto L_0x01a2
        L_0x01d5:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
        L_0x01de:
            r13 = r4
            androidx.compose.animation.core.AnimationSpec<java.lang.Float> r3 = r2.animationSpec     // Catch:{ CancellationException -> 0x0054 }
            r15.L$0 = r2     // Catch:{ CancellationException -> 0x0054 }
            r15.L$1 = r14     // Catch:{ CancellationException -> 0x0054 }
            r15.F$0 = r13     // Catch:{ CancellationException -> 0x0054 }
            r4 = 2
            r15.label = r4     // Catch:{ CancellationException -> 0x0054 }
            java.lang.Object r3 = r2.animateInternalToOffset(r13, r3, r15)     // Catch:{ CancellationException -> 0x0054 }
            if (r3 != r1) goto L_0x01f2
            return r1
        L_0x01f2:
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)
            java.lang.Object r1 = kotlin.collections.MapsKt.getValue(r14, r1)
            r2.setCurrentValue(r1)
            java.util.Set r13 = r14.keySet()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.lang.Float r13 = kotlin.collections.CollectionsKt.minOrNull(r13)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            float r13 = r13.floatValue()
            r2.minBound = r13
            java.util.Set r13 = r14.keySet()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.lang.Float r13 = kotlin.collections.CollectionsKt.maxOrNull(r13)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            float r13 = r13.floatValue()
            r2.maxBound = r13
        L_0x0223:
            goto L_0x00a3
        L_0x0225:
            r15.L$0 = r2     // Catch:{ all -> 0x004e }
            r15.L$1 = r14     // Catch:{ all -> 0x004e }
            r15.F$0 = r13     // Catch:{ all -> 0x004e }
            r3 = 3
            r15.label = r3     // Catch:{ all -> 0x004e }
            java.lang.Object r3 = r2.snapInternalToOffset(r13, r15)     // Catch:{ all -> 0x004e }
            if (r3 != r1) goto L_0x0235
            return r1
        L_0x0235:
            r1 = r2
        L_0x0236:
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)
            java.lang.Object r2 = kotlin.collections.MapsKt.getValue(r14, r2)
            r1.setCurrentValue(r2)
            java.util.Set r13 = r14.keySet()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.lang.Float r13 = kotlin.collections.CollectionsKt.minOrNull(r13)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            float r13 = r13.floatValue()
            r1.minBound = r13
            java.util.Set r13 = r14.keySet()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.lang.Float r13 = kotlin.collections.CollectionsKt.maxOrNull(r13)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            float r13 = r13.floatValue()
            r1.maxBound = r13
            goto L_0x0223
        L_0x0268:
            java.lang.Float r3 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)
            java.lang.Object r3 = kotlin.collections.MapsKt.getValue(r14, r3)
            r1.setCurrentValue(r3)
            java.util.Set r13 = r14.keySet()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.lang.Float r13 = kotlin.collections.CollectionsKt.minOrNull(r13)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            float r13 = r13.floatValue()
            r1.minBound = r13
            java.util.Set r13 = r14.keySet()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.lang.Float r13 = kotlin.collections.CollectionsKt.maxOrNull(r13)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            float r13 = r13.floatValue()
            r1.maxBound = r13
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableState.processNewAnchors$material_release(java.util.Map, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Function2<Float, Float, Float> getThresholds$material_release() {
        return (Function2) this.thresholds$delegate.getValue();
    }

    public final void setThresholds$material_release(Function2<? super Float, ? super Float, Float> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.thresholds$delegate.setValue(function2);
    }

    public final float getVelocityThreshold$material_release() {
        return ((Number) this.velocityThreshold$delegate.getValue()).floatValue();
    }

    public final void setVelocityThreshold$material_release(float f) {
        this.velocityThreshold$delegate.setValue(Float.valueOf(f));
    }

    public final ResistanceConfig getResistance$material_release() {
        return (ResistanceConfig) this.resistance$delegate.getValue();
    }

    public final void setResistance$material_release(ResistanceConfig resistanceConfig) {
        this.resistance$delegate.setValue(resistanceConfig);
    }

    public final DraggableState getDraggableState$material_release() {
        return this.draggableState;
    }

    /* access modifiers changed from: private */
    public final Object snapInternalToOffset(float target, Continuation<? super Unit> $completion) {
        Object drag$default = DraggableState.drag$default(this.draggableState, (MutatePriority) null, new SwipeableState$snapInternalToOffset$2(target, this, (Continuation<? super SwipeableState$snapInternalToOffset$2>) null), $completion, 1, (Object) null);
        return drag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? drag$default : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object animateInternalToOffset(float target, AnimationSpec<Float> spec, Continuation<? super Unit> $completion) {
        Object drag$default = DraggableState.drag$default(this.draggableState, (MutatePriority) null, new SwipeableState$animateInternalToOffset$2(this, target, spec, (Continuation<? super SwipeableState$animateInternalToOffset$2>) null), $completion, 1, (Object) null);
        return drag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? drag$default : Unit.INSTANCE;
    }

    public final T getTargetValue() {
        float target;
        Float value = this.animationTarget.getValue();
        if (value != null) {
            target = value.floatValue();
        } else {
            float floatValue = getOffset().getValue().floatValue();
            Float access$getOffset = SwipeableKt.getOffset(getAnchors$material_release(), getCurrentValue());
            target = SwipeableKt.computeTarget(floatValue, access$getOffset != null ? access$getOffset.floatValue() : getOffset().getValue().floatValue(), getAnchors$material_release().keySet(), getThresholds$material_release(), 0.0f, Float.POSITIVE_INFINITY);
        }
        T t = getAnchors$material_release().get(Float.valueOf(target));
        return t == null ? getCurrentValue() : t;
    }

    public final SwipeProgress<T> getProgress() {
        float fraction;
        Object to;
        Object from;
        Pair pair;
        List bounds = SwipeableKt.findBounds(getOffset().getValue().floatValue(), getAnchors$material_release().keySet());
        switch (bounds.size()) {
            case 0:
                from = getCurrentValue();
                to = getCurrentValue();
                fraction = 1.0f;
                break;
            case 1:
                from = MapsKt.getValue(getAnchors$material_release(), bounds.get(0));
                to = MapsKt.getValue(getAnchors$material_release(), bounds.get(0));
                fraction = 1.0f;
                break;
            default:
                if (getDirection() > 0.0f) {
                    pair = TuplesKt.to(bounds.get(0), bounds.get(1));
                } else {
                    pair = TuplesKt.to(bounds.get(1), bounds.get(0));
                }
                float a = ((Number) pair.component1()).floatValue();
                float b = ((Number) pair.component2()).floatValue();
                from = MapsKt.getValue(getAnchors$material_release(), Float.valueOf(a));
                to = MapsKt.getValue(getAnchors$material_release(), Float.valueOf(b));
                fraction = (getOffset().getValue().floatValue() - a) / (b - a);
                break;
        }
        return new SwipeProgress<>(from, to, fraction);
    }

    public final float getDirection() {
        Float access$getOffset = SwipeableKt.getOffset(getAnchors$material_release(), getCurrentValue());
        if (access$getOffset == null) {
            return 0.0f;
        }
        return Math.signum(getOffset().getValue().floatValue() - access$getOffset.floatValue());
    }

    public final Object snapTo(T targetValue, Continuation<? super Unit> $completion) {
        Object collect = this.latestNonEmptyAnchorsFlow.collect(new SwipeableState$snapTo$2(targetValue, this), $completion);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(SwipeableState swipeableState, Object obj, AnimationSpec<Float> animationSpec2, Continuation continuation, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 2) != 0) {
                animationSpec2 = swipeableState.animationSpec;
            }
            return swipeableState.animateTo(obj, animationSpec2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateTo");
    }

    public final Object animateTo(T targetValue, AnimationSpec<Float> anim, Continuation<? super Unit> $completion) {
        Object collect = this.latestNonEmptyAnchorsFlow.collect(new SwipeableState$animateTo$2(targetValue, this, anim), $completion);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public final Object performFling(float velocity, Continuation<? super Unit> $completion) {
        Object collect = this.latestNonEmptyAnchorsFlow.collect(new SwipeableState$performFling$2(this, velocity), $completion);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public final float performDrag(float delta) {
        float deltaToConsume = RangesKt.coerceIn(this.absoluteOffset.getValue().floatValue() + delta, this.minBound, this.maxBound) - this.absoluteOffset.getValue().floatValue();
        if (Math.abs(deltaToConsume) > 0.0f) {
            this.draggableState.dispatchRawDelta(deltaToConsume);
        }
        return deltaToConsume;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"}, d2 = {"Landroidx/compose/material/SwipeableState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/SwipeableState;", "T", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Swipeable.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> Saver<SwipeableState<T>, T> Saver(AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmStateChange) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
            return SaverKt.Saver(SwipeableState$Companion$Saver$1.INSTANCE, new SwipeableState$Companion$Saver$2(animationSpec, confirmStateChange));
        }
    }
}
