package androidx.compose.foundation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010-\u001a\u00020!H\u0002JE\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u0002002\"\u00101\u001a\u001e\b\u0001\u0012\u0004\u0012\u000200\u0012\n\u0012\b\u0012\u0004\u0012\u00020003\u0012\u0006\u0012\u0004\u0018\u00010402H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b5\u00106J9\u00107\u001a\u00020%2\u0006\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020:2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0\u001fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\b\u0010>\u001a\u00020!H\u0002J%\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020%H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ%\u0010E\u001a\u00020@2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020%H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010DJ%\u0010G\u001a\u00020@2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020%H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010DJ%\u0010I\u001a\u00020@2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020%H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u0010DJ\u001d\u0010K\u001a\u00020\u00142\u0006\u00108\u001a\u00020%H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ\b\u0010N\u001a\u00020\u0014H\u0002J \u0010O\u001a\u00020\u0014*\u00020P2\u0006\u0010Q\u001a\u00020\t2\n\u0010R\u001a\u00060Sj\u0002`TH\u0002J \u0010U\u001a\u00020\u0014*\u00020P2\u0006\u0010V\u001a\u00020\t2\n\u0010R\u001a\u00060Sj\u0002`TH\u0002J\n\u0010W\u001a\u00020!*\u00020PJ \u0010X\u001a\u00020\u0014*\u00020P2\u0006\u0010Y\u001a\u00020\t2\n\u0010R\u001a\u00060Sj\u0002`TH\u0002J \u0010Z\u001a\u00020\u0014*\u00020P2\u0006\u0010[\u001a\u00020\t2\n\u0010R\u001a\u00060Sj\u0002`TH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\u00020\rX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\u00148\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u000e\u0010\u001c\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\"\u001a\u0004\u0018\u00010#X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0019\u0010$\u001a\u0004\u0018\u00010%X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020!0'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\\"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "context", "Landroid/content/Context;", "overscrollConfig", "Landroidx/compose/foundation/OverscrollConfiguration;", "(Landroid/content/Context;Landroidx/compose/foundation/OverscrollConfiguration;)V", "allEffects", "", "Landroid/widget/EdgeEffect;", "bottomEffect", "bottomEffectNegation", "containerSize", "Landroidx/compose/ui/geometry/Size;", "J", "effectModifier", "Landroidx/compose/ui/Modifier;", "getEffectModifier", "()Landroidx/compose/ui/Modifier;", "invalidationEnabled", "", "getInvalidationEnabled$foundation_release$annotations", "()V", "getInvalidationEnabled$foundation_release", "()Z", "setInvalidationEnabled$foundation_release", "(Z)V", "isInProgress", "leftEffect", "leftEffectNegation", "onNewSize", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "redrawSignal", "Landroidx/compose/runtime/MutableState;", "rightEffect", "rightEffectNegation", "scrollCycleInProgress", "topEffect", "topEffectNegation", "animateToRelease", "applyToFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyToScroll", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "invalidateOverscroll", "pullBottom", "", "scroll", "displacement", "pullBottom-0a9Yr6o", "(JJ)F", "pullLeft", "pullLeft-0a9Yr6o", "pullRight", "pullRight-0a9Yr6o", "pullTop", "pullTop-0a9Yr6o", "releaseOppositeOverscroll", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "stopOverscrollAnimation", "drawBottom", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "bottom", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawLeft", "left", "drawOverscroll", "drawRight", "right", "drawTop", "top", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidOverscroll.kt */
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    private final List<EdgeEffect> allEffects;
    /* access modifiers changed from: private */
    public final EdgeEffect bottomEffect;
    /* access modifiers changed from: private */
    public final EdgeEffect bottomEffectNegation;
    /* access modifiers changed from: private */
    public long containerSize;
    private final Modifier effectModifier;
    private boolean invalidationEnabled;
    /* access modifiers changed from: private */
    public final EdgeEffect leftEffect;
    /* access modifiers changed from: private */
    public final EdgeEffect leftEffectNegation;
    private final Function1<IntSize, Unit> onNewSize;
    private final OverscrollConfiguration overscrollConfig;
    /* access modifiers changed from: private */
    public PointerId pointerId;
    /* access modifiers changed from: private */
    public Offset pointerPosition;
    private final MutableState<Unit> redrawSignal;
    /* access modifiers changed from: private */
    public final EdgeEffect rightEffect;
    /* access modifiers changed from: private */
    public final EdgeEffect rightEffectNegation;
    private boolean scrollCycleInProgress;
    /* access modifiers changed from: private */
    public final EdgeEffect topEffect;
    /* access modifiers changed from: private */
    public final EdgeEffect topEffectNegation;

    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }

    public AndroidEdgeEffectOverscrollEffect(Context context, OverscrollConfiguration overscrollConfig2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(overscrollConfig2, "overscrollConfig");
        this.overscrollConfig = overscrollConfig2;
        EdgeEffect create = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.topEffect = create;
        EdgeEffect create2 = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.bottomEffect = create2;
        EdgeEffect create3 = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.leftEffect = create3;
        EdgeEffect create4 = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.rightEffect = create4;
        this.allEffects = CollectionsKt.listOf(create3, create, create4, create2);
        this.topEffectNegation = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.bottomEffectNegation = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.leftEffectNegation = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.rightEffectNegation = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        List $this$fastForEach$iv = this.allEffects;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            $this$fastForEach$iv.get(index$iv).setColor(ColorKt.m3218toArgb8_81llA(this.overscrollConfig.m517getGlowColor0d7_KjU()));
        }
        this.redrawSignal = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.Companion.m2993getZeroNHjbRc();
        Function1<IntSize, Unit> androidEdgeEffectOverscrollEffect$onNewSize$1 = new AndroidEdgeEffectOverscrollEffect$onNewSize$1(this);
        this.onNewSize = androidEdgeEffectOverscrollEffect$onNewSize$1;
        this.effectModifier = OnRemeasuredModifierKt.onSizeChanged(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion.then(AndroidOverscrollKt.StretchOverscrollNonClippingLayer), (Object) Unit.INSTANCE, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this, (Continuation<? super AndroidEdgeEffectOverscrollEffect$effectModifier$1>) null)), androidEdgeEffectOverscrollEffect$onNewSize$1).then(new DrawOverscrollModifier(this, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1(this) : InspectableValueKt.getNoInspectorInfo()));
    }

    public final boolean getInvalidationEnabled$foundation_release() {
        return this.invalidationEnabled;
    }

    public final void setInvalidationEnabled$foundation_release(boolean z) {
        this.invalidationEnabled = z;
    }

    /* renamed from: applyToScroll-Rhakbz0  reason: not valid java name */
    public long m444applyToScrollRhakbz0(long delta, int source, Function1<? super Offset, Offset> performScroll) {
        float consumedPixelsY;
        boolean appliedHorizontalOverscroll;
        boolean appliedVerticalOverscroll;
        long j = delta;
        Function1<? super Offset, Offset> function1 = performScroll;
        Intrinsics.checkNotNullParameter(function1, "performScroll");
        if (Size.m2986isEmptyimpl(this.containerSize)) {
            return function1.invoke(Offset.m2904boximpl(delta)).m2925unboximpl();
        }
        if (!this.scrollCycleInProgress) {
            stopOverscrollAnimation();
            this.scrollCycleInProgress = true;
        }
        Offset offset = this.pointerPosition;
        long pointer = offset != null ? offset.m2925unboximpl() : SizeKt.m2994getCenteruvyYCjk(this.containerSize);
        float consumedPixelsX = 0.0f;
        if (Offset.m2916getYimpl(delta) == 0.0f) {
            consumedPixelsY = 0.0f;
        } else {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) == 0.0f)) {
                consumedPixelsY = m441pullTop0a9Yr6o(j, pointer);
                float f = consumedPixelsY;
                if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) == 0.0f) {
                    this.topEffect.onRelease();
                }
            } else {
                if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f)) {
                    consumedPixelsY = m438pullBottom0a9Yr6o(j, pointer);
                    float f2 = consumedPixelsY;
                    if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f) {
                        this.bottomEffect.onRelease();
                    }
                } else {
                    consumedPixelsY = 0.0f;
                }
            }
        }
        if (!(Offset.m2915getXimpl(delta) == 0.0f)) {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f)) {
                float r10 = m439pullLeft0a9Yr6o(j, pointer);
                float f3 = r10;
                if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f) {
                    this.leftEffect.onRelease();
                }
                consumedPixelsX = r10;
            } else {
                if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f)) {
                    float r102 = m440pullRight0a9Yr6o(j, pointer);
                    float f4 = r102;
                    if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f) {
                        this.rightEffect.onRelease();
                    }
                    consumedPixelsX = r102;
                }
            }
        }
        long consumedOffset = OffsetKt.Offset(consumedPixelsX, consumedPixelsY);
        if (!Offset.m2912equalsimpl0(consumedOffset, Offset.Companion.m2931getZeroF1C5BW0())) {
            invalidateOverscroll();
        }
        long leftForDelta = Offset.m2919minusMKHz9U(j, consumedOffset);
        long consumedByDelta = function1.invoke(Offset.m2904boximpl(leftForDelta)).m2925unboximpl();
        long consumedOffset2 = consumedOffset;
        long leftForOverscroll = Offset.m2919minusMKHz9U(leftForDelta, consumedByDelta);
        boolean needsInvalidation = false;
        if (NestedScrollSource.m4561equalsimpl0(source, NestedScrollSource.Companion.m4566getDragWNlRxjI())) {
            if (Offset.m2915getXimpl(leftForOverscroll) > 0.5f) {
                m439pullLeft0a9Yr6o(leftForOverscroll, pointer);
                appliedHorizontalOverscroll = true;
            } else if (Offset.m2915getXimpl(leftForOverscroll) < -0.5f) {
                m440pullRight0a9Yr6o(leftForOverscroll, pointer);
                appliedHorizontalOverscroll = true;
            } else {
                appliedHorizontalOverscroll = false;
            }
            if (Offset.m2916getYimpl(leftForOverscroll) > 0.5f) {
                m441pullTop0a9Yr6o(leftForOverscroll, pointer);
                appliedVerticalOverscroll = true;
            } else if (Offset.m2916getYimpl(leftForOverscroll) < -0.5f) {
                m438pullBottom0a9Yr6o(leftForOverscroll, pointer);
                appliedVerticalOverscroll = true;
            } else {
                appliedVerticalOverscroll = false;
            }
            needsInvalidation = appliedHorizontalOverscroll || appliedVerticalOverscroll;
        }
        if (m442releaseOppositeOverscrollk4lQ0M(delta) || needsInvalidation) {
            invalidateOverscroll();
        }
        return Offset.m2920plusMKHz9U(consumedOffset2, consumedByDelta);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005c, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x013f, code lost:
        r10 = androidx.compose.ui.unit.Velocity.m6214minusAH228Gc(r10, ((androidx.compose.ui.unit.Velocity) r12).m6220unboximpl());
        r2.scrollCycleInProgress = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0151, code lost:
        if (androidx.compose.ui.unit.Velocity.m6211getXimpl(r10) <= 0.0f) goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0153, code lost:
        androidx.compose.foundation.EdgeEffectCompat.INSTANCE.onAbsorbCompat(r2.leftEffect, kotlin.math.MathKt.roundToInt(androidx.compose.ui.unit.Velocity.m6211getXimpl(r10)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0169, code lost:
        if (androidx.compose.ui.unit.Velocity.m6211getXimpl(r10) >= 0.0f) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x016b, code lost:
        androidx.compose.foundation.EdgeEffectCompat.INSTANCE.onAbsorbCompat(r2.rightEffect, -kotlin.math.MathKt.roundToInt(androidx.compose.ui.unit.Velocity.m6211getXimpl(r10)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0181, code lost:
        if (androidx.compose.ui.unit.Velocity.m6212getYimpl(r10) <= 0.0f) goto L_0x0193;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0183, code lost:
        androidx.compose.foundation.EdgeEffectCompat.INSTANCE.onAbsorbCompat(r2.topEffect, kotlin.math.MathKt.roundToInt(androidx.compose.ui.unit.Velocity.m6212getYimpl(r10)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0199, code lost:
        if (androidx.compose.ui.unit.Velocity.m6212getYimpl(r10) >= 0.0f) goto L_0x01ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x019b, code lost:
        androidx.compose.foundation.EdgeEffectCompat.INSTANCE.onAbsorbCompat(r2.bottomEffect, -kotlin.math.MathKt.roundToInt(androidx.compose.ui.unit.Velocity.m6212getYimpl(r10)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01b5, code lost:
        if (androidx.compose.ui.unit.Velocity.m6210equalsimpl0(r10, androidx.compose.ui.unit.Velocity.Companion.m6222getZero9UxMQ8M()) != false) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01b7, code lost:
        r2.invalidateOverscroll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01ba, code lost:
        r2.animateToRelease();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01bf, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x013e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* renamed from: applyToFling-BMRW4eQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m443applyToFlingBMRW4eQ(long r10, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Velocity, ? super kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity>, ? extends java.lang.Object> r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$applyToFling$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$applyToFling$1 r0 = (androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$applyToFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$applyToFling$1 r0 = new androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$applyToFling$1
            r0.<init>(r9, r13)
        L_0x0019:
            r13 = r0
            java.lang.Object r0 = r13.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r13.label
            r3 = 0
            r4 = 0
            switch(r2) {
                case 0: goto L_0x0040;
                case 1: goto L_0x003c;
                case 2: goto L_0x002f;
                default: goto L_0x0027;
            }
        L_0x0027:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x002f:
            long r10 = r13.J$0
            java.lang.Object r12 = r13.L$0
            androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r12 = (androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect) r12
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r12
            r12 = r0
            goto L_0x013f
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x005a
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r9
            long r5 = r2.containerSize
            boolean r5 = androidx.compose.ui.geometry.Size.m2986isEmptyimpl(r5)
            r6 = 1
            if (r5 == 0) goto L_0x005d
            androidx.compose.ui.unit.Velocity r2 = androidx.compose.ui.unit.Velocity.m6202boximpl(r10)
            r13.label = r6
            java.lang.Object r10 = r12.invoke(r2, r13)
            if (r10 != r1) goto L_0x005a
            return r1
        L_0x005a:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x005d:
            float r5 = androidx.compose.ui.unit.Velocity.m6211getXimpl(r10)
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x008a
            androidx.compose.foundation.EdgeEffectCompat r5 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r7 = r2.leftEffect
            float r5 = r5.getDistanceCompat(r7)
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x0073
            r5 = r6
            goto L_0x0074
        L_0x0073:
            r5 = r3
        L_0x0074:
            if (r5 != 0) goto L_0x008a
            androidx.compose.foundation.EdgeEffectCompat r5 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r7 = r2.leftEffect
            float r8 = androidx.compose.ui.unit.Velocity.m6211getXimpl(r10)
            int r8 = kotlin.math.MathKt.roundToInt((float) r8)
            r5.onAbsorbCompat(r7, r8)
            float r5 = androidx.compose.ui.unit.Velocity.m6211getXimpl(r10)
            goto L_0x00b9
        L_0x008a:
            float r5 = androidx.compose.ui.unit.Velocity.m6211getXimpl(r10)
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 >= 0) goto L_0x00b8
            androidx.compose.foundation.EdgeEffectCompat r5 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r7 = r2.rightEffect
            float r5 = r5.getDistanceCompat(r7)
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x00a0
            r5 = r6
            goto L_0x00a1
        L_0x00a0:
            r5 = r3
        L_0x00a1:
            if (r5 != 0) goto L_0x00b8
            androidx.compose.foundation.EdgeEffectCompat r5 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r7 = r2.rightEffect
            float r8 = androidx.compose.ui.unit.Velocity.m6211getXimpl(r10)
            int r8 = kotlin.math.MathKt.roundToInt((float) r8)
            int r8 = -r8
            r5.onAbsorbCompat(r7, r8)
            float r5 = androidx.compose.ui.unit.Velocity.m6211getXimpl(r10)
            goto L_0x00b9
        L_0x00b8:
            r5 = r4
        L_0x00b9:
            float r7 = androidx.compose.ui.unit.Velocity.m6212getYimpl(r10)
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x00e7
            androidx.compose.foundation.EdgeEffectCompat r7 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r8 = r2.topEffect
            float r7 = r7.getDistanceCompat(r8)
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 != 0) goto L_0x00d0
            r7 = r6
            goto L_0x00d1
        L_0x00d0:
            r7 = r3
        L_0x00d1:
            if (r7 != 0) goto L_0x00e7
            androidx.compose.foundation.EdgeEffectCompat r6 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r7 = r2.topEffect
            float r8 = androidx.compose.ui.unit.Velocity.m6212getYimpl(r10)
            int r8 = kotlin.math.MathKt.roundToInt((float) r8)
            r6.onAbsorbCompat(r7, r8)
            float r6 = androidx.compose.ui.unit.Velocity.m6212getYimpl(r10)
            goto L_0x0115
        L_0x00e7:
            float r7 = androidx.compose.ui.unit.Velocity.m6212getYimpl(r10)
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 >= 0) goto L_0x0114
            androidx.compose.foundation.EdgeEffectCompat r7 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r8 = r2.bottomEffect
            float r7 = r7.getDistanceCompat(r8)
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 != 0) goto L_0x00fc
            goto L_0x00fd
        L_0x00fc:
            r6 = r3
        L_0x00fd:
            if (r6 != 0) goto L_0x0114
            androidx.compose.foundation.EdgeEffectCompat r6 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r7 = r2.bottomEffect
            float r8 = androidx.compose.ui.unit.Velocity.m6212getYimpl(r10)
            int r8 = kotlin.math.MathKt.roundToInt((float) r8)
            int r8 = -r8
            r6.onAbsorbCompat(r7, r8)
            float r6 = androidx.compose.ui.unit.Velocity.m6212getYimpl(r10)
            goto L_0x0115
        L_0x0114:
            r6 = r4
        L_0x0115:
            long r5 = androidx.compose.ui.unit.VelocityKt.Velocity(r5, r6)
            androidx.compose.ui.unit.Velocity$Companion r7 = androidx.compose.ui.unit.Velocity.Companion
            long r7 = r7.m6222getZero9UxMQ8M()
            boolean r7 = androidx.compose.ui.unit.Velocity.m6210equalsimpl0(r5, r7)
            if (r7 != 0) goto L_0x0129
            r2.invalidateOverscroll()
        L_0x0129:
            long r10 = androidx.compose.ui.unit.Velocity.m6214minusAH228Gc(r10, r5)
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.m6202boximpl(r10)
            r13.L$0 = r2
            r13.J$0 = r10
            r6 = 2
            r13.label = r6
            java.lang.Object r12 = r12.invoke(r5, r13)
            if (r12 != r1) goto L_0x013f
            return r1
        L_0x013f:
            androidx.compose.ui.unit.Velocity r12 = (androidx.compose.ui.unit.Velocity) r12
            long r5 = r12.m6220unboximpl()
            long r10 = androidx.compose.ui.unit.Velocity.m6214minusAH228Gc(r10, r5)
            r2.scrollCycleInProgress = r3
            float r12 = androidx.compose.ui.unit.Velocity.m6211getXimpl(r10)
            int r12 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r12 <= 0) goto L_0x0163
            androidx.compose.foundation.EdgeEffectCompat r12 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r1 = r2.leftEffect
            float r3 = androidx.compose.ui.unit.Velocity.m6211getXimpl(r10)
            int r3 = kotlin.math.MathKt.roundToInt((float) r3)
            r12.onAbsorbCompat(r1, r3)
            goto L_0x017b
        L_0x0163:
            float r12 = androidx.compose.ui.unit.Velocity.m6211getXimpl(r10)
            int r12 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r12 >= 0) goto L_0x017b
            androidx.compose.foundation.EdgeEffectCompat r12 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r1 = r2.rightEffect
            float r3 = androidx.compose.ui.unit.Velocity.m6211getXimpl(r10)
            int r3 = kotlin.math.MathKt.roundToInt((float) r3)
            int r3 = -r3
            r12.onAbsorbCompat(r1, r3)
        L_0x017b:
            float r12 = androidx.compose.ui.unit.Velocity.m6212getYimpl(r10)
            int r12 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r12 <= 0) goto L_0x0193
            androidx.compose.foundation.EdgeEffectCompat r12 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r1 = r2.topEffect
            float r3 = androidx.compose.ui.unit.Velocity.m6212getYimpl(r10)
            int r3 = kotlin.math.MathKt.roundToInt((float) r3)
            r12.onAbsorbCompat(r1, r3)
            goto L_0x01ab
        L_0x0193:
            float r12 = androidx.compose.ui.unit.Velocity.m6212getYimpl(r10)
            int r12 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r12 >= 0) goto L_0x01ab
            androidx.compose.foundation.EdgeEffectCompat r12 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r1 = r2.bottomEffect
            float r3 = androidx.compose.ui.unit.Velocity.m6212getYimpl(r10)
            int r3 = kotlin.math.MathKt.roundToInt((float) r3)
            int r3 = -r3
            r12.onAbsorbCompat(r1, r3)
        L_0x01ab:
            androidx.compose.ui.unit.Velocity$Companion r12 = androidx.compose.ui.unit.Velocity.Companion
            long r3 = r12.m6222getZero9UxMQ8M()
            boolean r12 = androidx.compose.ui.unit.Velocity.m6210equalsimpl0(r10, r3)
            if (r12 != 0) goto L_0x01ba
            r2.invalidateOverscroll()
        L_0x01ba:
            r2.animateToRelease()
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.m443applyToFlingBMRW4eQ(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean isInProgress() {
        List $this$fastForEach$iv$iv = this.allEffects;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (true) {
            boolean z = false;
            if (index$iv$iv >= size) {
                return false;
            }
            if (EdgeEffectCompat.INSTANCE.getDistanceCompat((EdgeEffect) $this$fastForEach$iv$iv.get(index$iv$iv)) == 0.0f) {
                z = true;
            }
            if (!z) {
                return true;
            }
            index$iv$iv++;
        }
    }

    private final boolean stopOverscrollAnimation() {
        boolean stopped = false;
        long fakeDisplacement = SizeKt.m2994getCenteruvyYCjk(this.containerSize);
        boolean z = true;
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f)) {
            m439pullLeft0a9Yr6o(Offset.Companion.m2931getZeroF1C5BW0(), fakeDisplacement);
            stopped = true;
        }
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f)) {
            m440pullRight0a9Yr6o(Offset.Companion.m2931getZeroF1C5BW0(), fakeDisplacement);
            stopped = true;
        }
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) == 0.0f)) {
            m441pullTop0a9Yr6o(Offset.Companion.m2931getZeroF1C5BW0(), fakeDisplacement);
            stopped = true;
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) != 0.0f) {
            z = false;
        }
        if (z) {
            return stopped;
        }
        m438pullBottom0a9Yr6o(Offset.Companion.m2931getZeroF1C5BW0(), fakeDisplacement);
        return true;
    }

    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    public final void drawOverscroll(DrawScope $this$drawOverscroll) {
        Intrinsics.checkNotNullParameter($this$drawOverscroll, "<this>");
        if (!Size.m2986isEmptyimpl(this.containerSize)) {
            Canvas it = $this$drawOverscroll.getDrawContext().getCanvas();
            this.redrawSignal.getValue();
            android.graphics.Canvas canvas = AndroidCanvas_androidKt.getNativeCanvas(it);
            boolean needsInvalidate = false;
            boolean z = true;
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffectNegation) == 0.0f)) {
                drawRight($this$drawOverscroll, this.leftEffectNegation, canvas);
                this.leftEffectNegation.finish();
            }
            if (!this.leftEffect.isFinished()) {
                needsInvalidate = drawLeft($this$drawOverscroll, this.leftEffect, canvas);
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect), 0.0f);
            }
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffectNegation) == 0.0f)) {
                drawBottom($this$drawOverscroll, this.topEffectNegation, canvas);
                this.topEffectNegation.finish();
            }
            if (!this.topEffect.isFinished()) {
                needsInvalidate = drawTop($this$drawOverscroll, this.topEffect, canvas) || needsInvalidate;
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect), 0.0f);
            }
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffectNegation) == 0.0f)) {
                drawLeft($this$drawOverscroll, this.rightEffectNegation, canvas);
                this.rightEffectNegation.finish();
            }
            if (!this.rightEffect.isFinished()) {
                needsInvalidate = drawRight($this$drawOverscroll, this.rightEffect, canvas) || needsInvalidate;
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect), 0.0f);
            }
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffectNegation) == 0.0f)) {
                drawTop($this$drawOverscroll, this.bottomEffectNegation, canvas);
                this.bottomEffectNegation.finish();
            }
            if (!this.bottomEffect.isFinished()) {
                if (!drawBottom($this$drawOverscroll, this.bottomEffect, canvas) && !needsInvalidate) {
                    z = false;
                }
                needsInvalidate = z;
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect), 0.0f);
            }
            if (needsInvalidate) {
                invalidateOverscroll();
            }
        }
    }

    private final boolean drawLeft(DrawScope $this$drawLeft, EdgeEffect left, android.graphics.Canvas canvas) {
        int restore = canvas.save();
        canvas.rotate(270.0f);
        canvas.translate(-Size.m2981getHeightimpl(this.containerSize), $this$drawLeft.m5967toPx0680j_4(this.overscrollConfig.getDrawPadding().m771calculateLeftPaddingu2uoSUM($this$drawLeft.getLayoutDirection())));
        boolean needsInvalidate = left.draw(canvas);
        canvas.restoreToCount(restore);
        return needsInvalidate;
    }

    private final boolean drawTop(DrawScope $this$drawTop, EdgeEffect top, android.graphics.Canvas canvas) {
        int restore = canvas.save();
        canvas.translate(0.0f, $this$drawTop.m5967toPx0680j_4(this.overscrollConfig.getDrawPadding().m773calculateTopPaddingD9Ej5fM()));
        boolean needsInvalidate = top.draw(canvas);
        canvas.restoreToCount(restore);
        return needsInvalidate;
    }

    private final boolean drawRight(DrawScope $this$drawRight, EdgeEffect right, android.graphics.Canvas canvas) {
        int restore = canvas.save();
        int width = MathKt.roundToInt(Size.m2984getWidthimpl(this.containerSize));
        float rightPadding = this.overscrollConfig.getDrawPadding().m772calculateRightPaddingu2uoSUM($this$drawRight.getLayoutDirection());
        canvas.rotate(90.0f);
        canvas.translate(0.0f, (-((float) width)) + $this$drawRight.m5967toPx0680j_4(rightPadding));
        boolean needsInvalidate = right.draw(canvas);
        canvas.restoreToCount(restore);
        return needsInvalidate;
    }

    private final boolean drawBottom(DrawScope $this$drawBottom, EdgeEffect bottom, android.graphics.Canvas canvas) {
        int restore = canvas.save();
        canvas.rotate(180.0f);
        canvas.translate(-Size.m2984getWidthimpl(this.containerSize), (-Size.m2981getHeightimpl(this.containerSize)) + $this$drawBottom.m5967toPx0680j_4(this.overscrollConfig.getDrawPadding().m770calculateBottomPaddingD9Ej5fM()));
        boolean needsInvalidate = bottom.draw(canvas);
        canvas.restoreToCount(restore);
        return needsInvalidate;
    }

    /* access modifiers changed from: private */
    public final void invalidateOverscroll() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    public final void animateToRelease() {
        boolean needsInvalidation = false;
        List $this$fastForEach$iv = this.allEffects;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            EdgeEffect it = $this$fastForEach$iv.get(index$iv);
            it.onRelease();
            needsInvalidation = it.isFinished() || needsInvalidation;
        }
        if (needsInvalidation) {
            invalidateOverscroll();
        }
    }

    /* renamed from: releaseOppositeOverscroll-k-4lQ0M  reason: not valid java name */
    private final boolean m442releaseOppositeOverscrollk4lQ0M(long delta) {
        boolean needsInvalidation = false;
        if (!this.leftEffect.isFinished() && Offset.m2915getXimpl(delta) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.leftEffect, Offset.m2915getXimpl(delta));
            needsInvalidation = this.leftEffect.isFinished();
        }
        boolean needsInvalidation2 = false;
        if (!this.rightEffect.isFinished() && Offset.m2915getXimpl(delta) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.rightEffect, Offset.m2915getXimpl(delta));
            needsInvalidation = needsInvalidation || this.rightEffect.isFinished();
        }
        if (!this.topEffect.isFinished() && Offset.m2916getYimpl(delta) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.topEffect, Offset.m2916getYimpl(delta));
            needsInvalidation = needsInvalidation || this.topEffect.isFinished();
        }
        if (this.bottomEffect.isFinished() || Offset.m2916getYimpl(delta) <= 0.0f) {
            return needsInvalidation;
        }
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.bottomEffect, Offset.m2916getYimpl(delta));
        if (needsInvalidation || this.bottomEffect.isFinished()) {
            needsInvalidation2 = true;
        }
        return needsInvalidation2;
    }

    /* renamed from: pullTop-0a9Yr6o  reason: not valid java name */
    private final float m441pullTop0a9Yr6o(long scroll, long displacement) {
        float consumed = EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffect, Offset.m2916getYimpl(scroll) / Size.m2981getHeightimpl(this.containerSize), Offset.m2915getXimpl(displacement) / Size.m2984getWidthimpl(this.containerSize)) * Size.m2981getHeightimpl(this.containerSize);
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) == 0.0f)) {
            return Offset.m2916getYimpl(scroll);
        }
        return consumed;
    }

    /* renamed from: pullBottom-0a9Yr6o  reason: not valid java name */
    private final float m438pullBottom0a9Yr6o(long scroll, long displacement) {
        float displacementX = Offset.m2915getXimpl(displacement) / Size.m2984getWidthimpl(this.containerSize);
        boolean z = true;
        float consumed = (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffect, -(Offset.m2916getYimpl(scroll) / Size.m2981getHeightimpl(this.containerSize)), ((float) 1) - displacementX)) * Size.m2981getHeightimpl(this.containerSize);
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) != 0.0f) {
            z = false;
        }
        if (!z) {
            return Offset.m2916getYimpl(scroll);
        }
        return consumed;
    }

    /* renamed from: pullLeft-0a9Yr6o  reason: not valid java name */
    private final float m439pullLeft0a9Yr6o(long scroll, long displacement) {
        float displacementY = Offset.m2916getYimpl(displacement) / Size.m2981getHeightimpl(this.containerSize);
        boolean z = true;
        float consumed = EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffect, Offset.m2915getXimpl(scroll) / Size.m2984getWidthimpl(this.containerSize), ((float) 1) - displacementY) * Size.m2984getWidthimpl(this.containerSize);
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) != 0.0f) {
            z = false;
        }
        if (!z) {
            return Offset.m2915getXimpl(scroll);
        }
        return consumed;
    }

    /* renamed from: pullRight-0a9Yr6o  reason: not valid java name */
    private final float m440pullRight0a9Yr6o(long scroll, long displacement) {
        float consumed = (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffect, -(Offset.m2915getXimpl(scroll) / Size.m2984getWidthimpl(this.containerSize)), Offset.m2916getYimpl(displacement) / Size.m2981getHeightimpl(this.containerSize))) * Size.m2984getWidthimpl(this.containerSize);
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f)) {
            return Offset.m2915getXimpl(scroll);
        }
        return consumed;
    }
}
