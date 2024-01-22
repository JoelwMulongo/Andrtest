package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aG\u0010\u0007\u001a\u00020\b*\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"DefaultIncomingSpec", "Landroidx/compose/animation/core/TweenSpec;", "Landroidx/compose/ui/unit/Dp;", "DefaultOutgoingSpec", "HoveredOutgoingSpec", "OutgoingSpecEasing", "Landroidx/compose/animation/core/Easing;", "animateElevation", "", "Landroidx/compose/animation/core/Animatable;", "target", "from", "Landroidx/compose/foundation/interaction/Interaction;", "to", "animateElevation-rAjV9yQ", "(Landroidx/compose/animation/core/Animatable;FLandroidx/compose/foundation/interaction/Interaction;Landroidx/compose/foundation/interaction/Interaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Elevation.kt */
public final class ElevationKt {
    /* access modifiers changed from: private */
    public static final TweenSpec<Dp> DefaultIncomingSpec = new TweenSpec(120, 0, EasingKt.getFastOutSlowInEasing(), 2, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TweenSpec<Dp> DefaultOutgoingSpec;
    /* access modifiers changed from: private */
    public static final TweenSpec<Dp> HoveredOutgoingSpec;
    private static final Easing OutgoingSpecEasing;

    /* renamed from: animateElevation-rAjV9yQ$default  reason: not valid java name */
    public static /* synthetic */ Object m1905animateElevationrAjV9yQ$default(Animatable animatable, float f, Interaction interaction, Interaction interaction2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            interaction = null;
        }
        if ((i & 4) != 0) {
            interaction2 = null;
        }
        return m1904animateElevationrAjV9yQ(animatable, f, interaction, interaction2, continuation);
    }

    /* renamed from: animateElevation-rAjV9yQ  reason: not valid java name */
    public static final Object m1904animateElevationrAjV9yQ(Animatable<Dp, ?> $this$animateElevation_u2drAjV9yQ, float target, Interaction from, Interaction to, Continuation<? super Unit> $completion) {
        AnimationSpec spec;
        if (to != null) {
            spec = ElevationDefaults.INSTANCE.incomingAnimationSpecForInteraction(to);
        } else if (from != null) {
            spec = ElevationDefaults.INSTANCE.outgoingAnimationSpecForInteraction(from);
        } else {
            spec = null;
        }
        if (spec != null) {
            Object animateTo$default = Animatable.animateTo$default($this$animateElevation_u2drAjV9yQ, Dp.m5984boximpl(target), spec, (Object) null, (Function1) null, $completion, 12, (Object) null);
            if (animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return animateTo$default;
            }
        } else {
            Object snapTo = $this$animateElevation_u2drAjV9yQ.snapTo(Dp.m5984boximpl(target), $completion);
            if (snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return snapTo;
            }
        }
        return Unit.INSTANCE;
    }

    static {
        Easing cubicBezierEasing = new CubicBezierEasing(0.4f, 0.0f, 0.6f, 1.0f);
        OutgoingSpecEasing = cubicBezierEasing;
        Easing easing = cubicBezierEasing;
        DefaultOutgoingSpec = new TweenSpec(150, 0, easing, 2, (DefaultConstructorMarker) null);
        HoveredOutgoingSpec = new TweenSpec(120, 0, easing, 2, (DefaultConstructorMarker) null);
    }
}
