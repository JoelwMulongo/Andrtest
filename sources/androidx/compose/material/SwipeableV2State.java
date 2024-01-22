package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.unit.Density;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0001\u0018\u0000 h*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001hB\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\b\u0002\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b\u0012.\b\u0002\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0002\b\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0014J#\u0010T\u001a\u00020U2\u0006\u0010O\u001a\u00028\u00002\b\b\u0002\u0010V\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010WJ%\u0010X\u001a\u00028\u00002\u0006\u0010D\u001a\u00020\u00062\u0006\u0010(\u001a\u00028\u00002\u0006\u0010V\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010YJ\u000e\u0010Z\u001a\u00020\u00062\u0006\u0010[\u001a\u00020\u0006J\u0013\u0010\\\u001a\u00020\f2\u0006\u0010]\u001a\u00028\u0000¢\u0006\u0002\u0010^J\b\u0010_\u001a\u00020\u000fH\u0002J\u0006\u0010`\u001a\u00020\u0006J\u0019\u0010a\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010bJ\u0019\u0010c\u001a\u00020U2\u0006\u0010O\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010dJ!\u0010e\u001a\u00020\f2\u0012\u0010f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0016H\u0000¢\u0006\u0002\bgRC\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00162\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00168@@@X\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR/\u0010 \u001a\u0004\u0018\u00018\u00002\b\u0010\u0015\u001a\u0004\u0018\u00018\u00008B@BX\u0002¢\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R/\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R+\u0010(\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00008F@BX\u0002¢\u0006\u0012\n\u0004\b+\u0010\u001d\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001c\u0010,\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00101\u001a\u000202X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b5\u00106R+\u00107\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00068F@BX\u0002¢\u0006\u0012\n\u0004\b<\u0010\u001d\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001b\u0010=\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\b>\u00109R\u001b\u0010A\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\bC\u0010@\u001a\u0004\bB\u00109R/\u0010D\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00068F@BX\u0002¢\u0006\u0012\n\u0004\bI\u0010\u001d\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR:\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0002\b\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u001b\u0010L\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\bN\u0010@\u001a\u0004\bM\u00109R\u001b\u0010O\u001a\u00028\u00008FX\u0002¢\u0006\f\n\u0004\bQ\u0010@\u001a\u0004\bP\u0010\"R\u001f\u0010\u0012\u001a\u00020\u0013X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010S\u001a\u0004\bR\u00109\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006i"}, d2 = {"Landroidx/compose/material/SwipeableV2State;", "T", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "positionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "totalDistance", "Lkotlin/ExtensionFunctionType;", "velocityThreshold", "Landroidx/compose/ui/unit/Dp;", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "", "anchors", "getAnchors$material_release", "()Ljava/util/Map;", "setAnchors$material_release", "(Ljava/util/Map;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec$material_release", "()Landroidx/compose/animation/core/AnimationSpec;", "animationTarget", "getAnimationTarget", "()Ljava/lang/Object;", "setAnimationTarget", "(Ljava/lang/Object;)V", "animationTarget$delegate", "getConfirmValueChange$material_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "setCurrentValue", "currentValue$delegate", "density", "getDensity$material_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$material_release", "(Landroidx/compose/ui/unit/Density;)V", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$material_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "isAnimationRunning", "()Z", "lastVelocity", "getLastVelocity", "()F", "setLastVelocity", "(F)V", "lastVelocity$delegate", "maxOffset", "getMaxOffset", "maxOffset$delegate", "Landroidx/compose/runtime/State;", "minOffset", "getMinOffset", "minOffset$delegate", "offset", "getOffset", "()Ljava/lang/Float;", "setOffset", "(Ljava/lang/Float;)V", "offset$delegate", "getPositionalThreshold$material_release", "()Lkotlin/jvm/functions/Function2;", "progress", "getProgress", "progress$delegate", "targetValue", "getTargetValue", "targetValue$delegate", "getVelocityThreshold-D9Ej5fM$material_release", "F", "animateTo", "", "velocity", "(Ljava/lang/Object;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "(FLjava/lang/Object;F)Ljava/lang/Object;", "dispatchRawDelta", "delta", "hasAnchorForValue", "value", "(Ljava/lang/Object;)Z", "requireDensity", "requireOffset", "settle", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAnchors", "newAnchors", "updateAnchors$material_release", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeableV2.kt */
public final class SwipeableV2State<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final MutableState anchors$delegate;
    private final AnimationSpec<Float> animationSpec;
    private final MutableState animationTarget$delegate;
    private final Function1<T, Boolean> confirmValueChange;
    private final MutableState currentValue$delegate;
    private Density density;
    private final DraggableState draggableState;
    private final MutableState lastVelocity$delegate;
    private final State maxOffset$delegate;
    private final State minOffset$delegate;
    private final MutableState offset$delegate;
    private final Function2<Density, Float, Float> positionalThreshold;
    private final State progress$delegate;
    private final State targetValue$delegate;
    private final float velocityThreshold;

    public /* synthetic */ SwipeableV2State(Object obj, AnimationSpec animationSpec2, Function1 function1, Function2 function2, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, animationSpec2, function1, function2, f);
    }

    private SwipeableV2State(T initialValue, AnimationSpec<Float> animationSpec2, Function1<? super T, Boolean> confirmValueChange2, Function2<? super Density, ? super Float, Float> positionalThreshold2, float velocityThreshold2) {
        this.animationSpec = animationSpec2;
        this.confirmValueChange = confirmValueChange2;
        this.positionalThreshold = positionalThreshold2;
        this.velocityThreshold = velocityThreshold2;
        this.currentValue$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialValue, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.targetValue$delegate = SnapshotStateKt.derivedStateOf(new SwipeableV2State$targetValue$2(this));
        this.offset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.progress$delegate = SnapshotStateKt.derivedStateOf(new SwipeableV2State$progress$2(this));
        this.lastVelocity$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.minOffset$delegate = SnapshotStateKt.derivedStateOf(new SwipeableV2State$minOffset$2(this));
        this.maxOffset$delegate = SnapshotStateKt.derivedStateOf(new SwipeableV2State$maxOffset$2(this));
        this.animationTarget$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.draggableState = DraggableKt.DraggableState(new SwipeableV2State$draggableState$1(this));
        this.anchors$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SwipeableV2State(java.lang.Object r8, androidx.compose.animation.core.AnimationSpec r9, kotlin.jvm.functions.Function1 r10, kotlin.jvm.functions.Function2 r11, float r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 2
            if (r14 == 0) goto L_0x000e
            androidx.compose.material.SwipeableV2Defaults r9 = androidx.compose.material.SwipeableV2Defaults.INSTANCE
            androidx.compose.animation.core.SpringSpec r9 = r9.getAnimationSpec()
            androidx.compose.animation.core.AnimationSpec r9 = (androidx.compose.animation.core.AnimationSpec) r9
            r2 = r9
            goto L_0x000f
        L_0x000e:
            r2 = r9
        L_0x000f:
            r9 = r13 & 4
            if (r9 == 0) goto L_0x001a
            androidx.compose.material.SwipeableV2State$1 r9 = androidx.compose.material.SwipeableV2State.AnonymousClass1.INSTANCE
            r10 = r9
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r3 = r10
            goto L_0x001b
        L_0x001a:
            r3 = r10
        L_0x001b:
            r9 = r13 & 8
            if (r9 == 0) goto L_0x0027
            androidx.compose.material.SwipeableV2Defaults r9 = androidx.compose.material.SwipeableV2Defaults.INSTANCE
            kotlin.jvm.functions.Function2 r11 = r9.getPositionalThreshold()
            r4 = r11
            goto L_0x0028
        L_0x0027:
            r4 = r11
        L_0x0028:
            r9 = r13 & 16
            if (r9 == 0) goto L_0x0034
            androidx.compose.material.SwipeableV2Defaults r9 = androidx.compose.material.SwipeableV2Defaults.INSTANCE
            float r12 = r9.m1639getVelocityThresholdD9Ej5fM()
            r5 = r12
            goto L_0x0035
        L_0x0034:
            r5 = r12
        L_0x0035:
            r6 = 0
            r0 = r7
            r1 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableV2State.<init>(java.lang.Object, androidx.compose.animation.core.AnimationSpec, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final AnimationSpec<Float> getAnimationSpec$material_release() {
        return this.animationSpec;
    }

    public final Function1<T, Boolean> getConfirmValueChange$material_release() {
        return this.confirmValueChange;
    }

    public final Function2<Density, Float, Float> getPositionalThreshold$material_release() {
        return this.positionalThreshold;
    }

    /* renamed from: getVelocityThreshold-D9Ej5fM$material_release  reason: not valid java name */
    public final float m1642getVelocityThresholdD9Ej5fM$material_release() {
        return this.velocityThreshold;
    }

    private final void setCurrentValue(T t) {
        this.currentValue$delegate.setValue(t);
    }

    public final T getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    public final T getTargetValue() {
        return this.targetValue$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void setOffset(Float f) {
        this.offset$delegate.setValue(f);
    }

    public final Float getOffset() {
        return (Float) this.offset$delegate.getValue();
    }

    public final float requireOffset() {
        Float offset = getOffset();
        if (offset != null) {
            return offset.floatValue();
        }
        throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
    }

    public final boolean isAnimationRunning() {
        return getAnimationTarget() != null;
    }

    public final float getProgress() {
        return ((Number) this.progress$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public final void setLastVelocity(float f) {
        this.lastVelocity$delegate.setValue(Float.valueOf(f));
    }

    public final float getLastVelocity() {
        return ((Number) this.lastVelocity$delegate.getValue()).floatValue();
    }

    public final float getMinOffset() {
        return ((Number) this.minOffset$delegate.getValue()).floatValue();
    }

    public final float getMaxOffset() {
        return ((Number) this.maxOffset$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public final T getAnimationTarget() {
        return this.animationTarget$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void setAnimationTarget(T t) {
        this.animationTarget$delegate.setValue(t);
    }

    public final DraggableState getDraggableState$material_release() {
        return this.draggableState;
    }

    public final Map<T, Float> getAnchors$material_release() {
        return (Map) this.anchors$delegate.getValue();
    }

    public final void setAnchors$material_release(Map<T, Float> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.anchors$delegate.setValue(map);
    }

    public final Density getDensity$material_release() {
        return this.density;
    }

    public final void setDensity$material_release(Density density2) {
        this.density = density2;
    }

    public final boolean updateAnchors$material_release(Map<T, Float> newAnchors) {
        boolean initialValueHasAnchor;
        Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
        boolean previousAnchorsEmpty = getAnchors$material_release().isEmpty();
        setAnchors$material_release(newAnchors);
        if (previousAnchorsEmpty) {
            Float initialValueAnchor = (Float) getAnchors$material_release().get(getCurrentValue());
            initialValueHasAnchor = initialValueAnchor != null;
            if (initialValueHasAnchor) {
                setOffset(initialValueAnchor);
            }
        } else {
            initialValueHasAnchor = true;
        }
        if (!initialValueHasAnchor || !previousAnchorsEmpty) {
            return true;
        }
        return false;
    }

    public final boolean hasAnchorForValue(T value) {
        return getAnchors$material_release().containsKey(value);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r0.setCurrentValue(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006b, code lost:
        r0.setAnimationTarget((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007a, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=T, code=java.lang.Object, for r12v0, types: [T, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object snapTo(java.lang.Object r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof androidx.compose.material.SwipeableV2State$snapTo$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            androidx.compose.material.SwipeableV2State$snapTo$1 r0 = (androidx.compose.material.SwipeableV2State$snapTo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            androidx.compose.material.SwipeableV2State$snapTo$1 r0 = new androidx.compose.material.SwipeableV2State$snapTo$1
            r0.<init>(r11, r13)
        L_0x0019:
            r13 = r0
            java.lang.Object r6 = r13.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r13.label
            r8 = 0
            switch(r0) {
                case 0: goto L_0x003a;
                case 1: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x002e:
            java.lang.Object r12 = r13.L$1
            java.lang.Object r0 = r13.L$0
            androidx.compose.material.SwipeableV2State r0 = (androidx.compose.material.SwipeableV2State) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0038 }
            goto L_0x0068
        L_0x0038:
            r12 = move-exception
            goto L_0x0071
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            r9 = r11
            java.util.Map r0 = r9.getAnchors$material_release()
            java.lang.Object r0 = r0.get(r12)
            r10 = r0
            java.lang.Float r10 = (java.lang.Float) r10
            if (r10 == 0) goto L_0x0075
            androidx.compose.foundation.gestures.DraggableState r0 = r9.draggableState     // Catch:{ all -> 0x006f }
            r1 = 0
            androidx.compose.material.SwipeableV2State$snapTo$2 r2 = new androidx.compose.material.SwipeableV2State$snapTo$2     // Catch:{ all -> 0x006f }
            r2.<init>(r9, r12, r10, r8)     // Catch:{ all -> 0x006f }
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch:{ all -> 0x006f }
            r4 = 1
            r5 = 0
            r13.L$0 = r9     // Catch:{ all -> 0x006f }
            r13.L$1 = r12     // Catch:{ all -> 0x006f }
            r3 = 1
            r13.label = r3     // Catch:{ all -> 0x006f }
            r3 = r13
            java.lang.Object r0 = androidx.compose.foundation.gestures.DraggableState.drag$default(r0, r1, r2, r3, r4, r5)     // Catch:{ all -> 0x006f }
            if (r0 != r7) goto L_0x0067
            return r7
        L_0x0067:
            r0 = r9
        L_0x0068:
            r0.setCurrentValue(r12)     // Catch:{ all -> 0x0038 }
            r0.setAnimationTarget(r8)
            goto L_0x0078
        L_0x006f:
            r12 = move-exception
            r0 = r9
        L_0x0071:
            r0.setAnimationTarget(r8)
            throw r12
        L_0x0075:
            r9.setCurrentValue(r12)
        L_0x0078:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableV2State.snapTo(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object animateTo$default(SwipeableV2State swipeableV2State, Object obj, float f, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = swipeableV2State.getLastVelocity();
        }
        return swipeableV2State.animateTo(obj, f, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: androidx.compose.material.SwipeableV2State} */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0081, code lost:
        r3.setAnimationTarget((java.lang.Object) null);
        r0 = r3.requireOffset();
        r6 = r3.getAnchors$material_release().entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009c, code lost:
        if (r6.hasNext() == false) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009e, code lost:
        r4 = r6.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b8, code lost:
        if (java.lang.Math.abs(((java.lang.Number) ((java.util.Map.Entry) r4).getValue()).floatValue() - r0) >= 0.5f) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ba, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00bc, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bd, code lost:
        if (r7 == false) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c0, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c1, code lost:
        r4 = (java.util.Map.Entry) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c3, code lost:
        if (r4 == null) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c5, code lost:
        r13 = r4.getKey();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ca, code lost:
        r0 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cb, code lost:
        if (r0 != null) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cd, code lost:
        r0 = r3.getCurrentValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d1, code lost:
        r3.setCurrentValue(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0136, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x011a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object animateTo(T r22, float r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            r21 = this;
            r0 = r24
            boolean r1 = r0 instanceof androidx.compose.material.SwipeableV2State$animateTo$1
            if (r1 == 0) goto L_0x0019
            r1 = r0
            androidx.compose.material.SwipeableV2State$animateTo$1 r1 = (androidx.compose.material.SwipeableV2State$animateTo$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0019
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r21
            goto L_0x0021
        L_0x0019:
            androidx.compose.material.SwipeableV2State$animateTo$1 r1 = new androidx.compose.material.SwipeableV2State$animateTo$1
            r2 = r21
            r1.<init>(r2, r0)
            r0 = r1
        L_0x0021:
            java.lang.Object r9 = r1.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r11 = 1056964608(0x3f000000, float:0.5)
            r12 = 1
            r13 = 0
            switch(r3) {
                case 0: goto L_0x0044;
                case 1: goto L_0x0038;
                default: goto L_0x0030;
            }
        L_0x0030:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0038:
            java.lang.Object r0 = r1.L$0
            r3 = r0
            androidx.compose.material.SwipeableV2State r3 = (androidx.compose.material.SwipeableV2State) r3
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0041 }
            goto L_0x0081
        L_0x0041:
            r0 = move-exception
            goto L_0x00db
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r9)
            r8 = r21
            r18 = r23
            r7 = r22
            java.util.Map r3 = r8.getAnchors$material_release()
            java.lang.Object r3 = r3.get(r7)
            r20 = r3
            java.lang.Float r20 = (java.lang.Float) r20
            if (r20 == 0) goto L_0x012f
            androidx.compose.foundation.gestures.DraggableState r3 = r8.draggableState     // Catch:{ all -> 0x00d8 }
            r4 = 0
            androidx.compose.material.SwipeableV2State$animateTo$2 r5 = new androidx.compose.material.SwipeableV2State$animateTo$2     // Catch:{ all -> 0x00d8 }
            r19 = 0
            r14 = r5
            r15 = r8
            r16 = r7
            r17 = r20
            r14.<init>(r15, r16, r17, r18, r19)     // Catch:{ all -> 0x00d8 }
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch:{ all -> 0x00d8 }
            r14 = 1
            r15 = 0
            r1.L$0 = r8     // Catch:{ all -> 0x00d8 }
            r1.label = r12     // Catch:{ all -> 0x00d8 }
            r6 = r1
            r10 = r7
            r7 = r14
            r14 = r8
            r8 = r15
            java.lang.Object r3 = androidx.compose.foundation.gestures.DraggableState.drag$default(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00d5 }
            if (r3 != r0) goto L_0x0080
            return r0
        L_0x0080:
            r3 = r14
        L_0x0081:
            r3.setAnimationTarget(r13)
            float r0 = r3.requireOffset()
            java.util.Map r4 = r3.getAnchors$material_release()
            java.util.Set r4 = r4.entrySet()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            r5 = 0
            java.util.Iterator r6 = r4.iterator()
        L_0x0098:
            boolean r4 = r6.hasNext()
            if (r4 == 0) goto L_0x00c0
            java.lang.Object r4 = r6.next()
            r7 = r4
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            r8 = 0
            java.lang.Object r7 = r7.getValue()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            float r10 = r7 - r0
            float r7 = java.lang.Math.abs(r10)
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 >= 0) goto L_0x00bc
            r7 = r12
            goto L_0x00bd
        L_0x00bc:
            r7 = 0
        L_0x00bd:
            if (r7 == 0) goto L_0x0098
            goto L_0x00c1
        L_0x00c0:
            r4 = r13
        L_0x00c1:
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            if (r4 == 0) goto L_0x00ca
            java.lang.Object r13 = r4.getKey()
        L_0x00ca:
            r0 = r13
            if (r0 != 0) goto L_0x00d1
            java.lang.Object r0 = r3.getCurrentValue()
        L_0x00d1:
            r3.setCurrentValue(r0)
            goto L_0x0134
        L_0x00d5:
            r0 = move-exception
            r3 = r14
            goto L_0x00db
        L_0x00d8:
            r0 = move-exception
            r14 = r8
            r3 = r14
        L_0x00db:
            r3.setAnimationTarget(r13)
            float r4 = r3.requireOffset()
            java.util.Map r5 = r3.getAnchors$material_release()
            java.util.Set r5 = r5.entrySet()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            r6 = 0
            java.util.Iterator r7 = r5.iterator()
        L_0x00f2:
            boolean r5 = r7.hasNext()
            if (r5 == 0) goto L_0x011a
            java.lang.Object r5 = r7.next()
            r8 = r5
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            r10 = 0
            java.lang.Object r8 = r8.getValue()
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            float r14 = r8 - r4
            float r8 = java.lang.Math.abs(r14)
            int r8 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r8 >= 0) goto L_0x0116
            r8 = r12
            goto L_0x0117
        L_0x0116:
            r8 = 0
        L_0x0117:
            if (r8 == 0) goto L_0x00f2
            goto L_0x011b
        L_0x011a:
            r5 = r13
        L_0x011b:
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            if (r5 == 0) goto L_0x0124
            java.lang.Object r13 = r5.getKey()
        L_0x0124:
            r4 = r13
            if (r4 != 0) goto L_0x012b
            java.lang.Object r4 = r3.getCurrentValue()
        L_0x012b:
            r3.setCurrentValue(r4)
            throw r0
        L_0x012f:
            r10 = r7
            r14 = r8
            r14.setCurrentValue(r10)
        L_0x0134:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableV2State.animateTo(java.lang.Object, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object settle(float velocity, Continuation<? super Unit> $completion) {
        Object previousValue = getCurrentValue();
        Object targetValue = computeTarget(requireOffset(), previousValue, velocity);
        if (this.confirmValueChange.invoke(targetValue).booleanValue()) {
            Object animateTo = animateTo(targetValue, velocity, $completion);
            return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
        }
        Object animateTo2 = animateTo(previousValue, velocity, $completion);
        return animateTo2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo2 : Unit.INSTANCE;
    }

    public final float dispatchRawDelta(float delta) {
        Float offset = getOffset();
        float currentDragPosition = offset != null ? offset.floatValue() : 0.0f;
        float deltaToConsume = RangesKt.coerceIn(currentDragPosition + delta, getMinOffset(), getMaxOffset()) - currentDragPosition;
        if (Math.abs(deltaToConsume) > 0.0f) {
            this.draggableState.dispatchRawDelta(deltaToConsume);
        }
        return deltaToConsume;
    }

    /* access modifiers changed from: private */
    public final T computeTarget(float offset, T currentValue, float velocity) {
        Map currentAnchors = getAnchors$material_release();
        Float currentAnchor = (Float) currentAnchors.get(currentValue);
        Density currentDensity = requireDensity();
        float velocityThresholdPx = currentDensity.m5967toPx0680j_4(this.velocityThreshold);
        if (Intrinsics.areEqual(currentAnchor, offset) == 0 && currentAnchor != null) {
            if (currentAnchor.floatValue() < offset) {
                if (velocity >= velocityThresholdPx) {
                    return SwipeableV2Kt.closestAnchor(currentAnchors, offset, true);
                }
                Object upper = SwipeableV2Kt.closestAnchor(currentAnchors, offset, true);
                if (offset >= Math.abs(currentAnchor.floatValue() + Math.abs(this.positionalThreshold.invoke(currentDensity, Float.valueOf(Math.abs(((Number) MapsKt.getValue(currentAnchors, upper)).floatValue() - currentAnchor.floatValue()))).floatValue()))) {
                    return upper;
                }
            } else if (velocity <= (-velocityThresholdPx)) {
                return SwipeableV2Kt.closestAnchor(currentAnchors, offset, false);
            } else {
                Object lower = SwipeableV2Kt.closestAnchor(currentAnchors, offset, false);
                float absoluteThreshold = Math.abs(currentAnchor.floatValue() - Math.abs(this.positionalThreshold.invoke(currentDensity, Float.valueOf(Math.abs(currentAnchor.floatValue() - ((Number) MapsKt.getValue(currentAnchors, lower)).floatValue()))).floatValue()));
                if (offset < 0.0f) {
                    if (Math.abs(offset) >= absoluteThreshold) {
                        return lower;
                    }
                } else if (offset <= absoluteThreshold) {
                    return lower;
                }
            }
        }
        return currentValue;
    }

    private final Density requireDensity() {
        Density density2 = this.density;
        if (density2 != null) {
            return density2;
        }
        throw new IllegalArgumentException(("SwipeableState did not have a density attached. Are you using Modifier.swipeable with this=" + this + " SwipeableState?").toString());
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0001\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\f0\u000b2,\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Landroidx/compose/material/SwipeableV2State$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/SwipeableV2State;", "T", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ParameterName;", "name", "distance", "Lkotlin/ExtensionFunctionType;", "velocityThreshold", "Landroidx/compose/ui/unit/Dp;", "Saver-eqLRuRQ", "(Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;F)Landroidx/compose/runtime/saveable/Saver;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SwipeableV2.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: Saver-eqLRuRQ  reason: not valid java name */
        public final <T> Saver<SwipeableV2State<T>, T> m1643SavereqLRuRQ(AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmValueChange, Function2<? super Density, ? super Float, Float> positionalThreshold, float velocityThreshold) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
            Intrinsics.checkNotNullParameter(positionalThreshold, "positionalThreshold");
            return SaverKt.Saver(SwipeableV2State$Companion$Saver$1.INSTANCE, new SwipeableV2State$Companion$Saver$2(animationSpec, confirmValueChange, positionalThreshold, velocityThreshold));
        }
    }
}
