package androidx.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.animation.core.StartOffset;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u000fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001aK\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a&\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0%2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0001H\u0002\u001aU\u0010&\u001a\u00020'*\u00020'2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020\u000fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+\"\u001c\u0010\u0000\u001a\u00020\u00018GXD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u00018GXD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"\u001c\u0010\t\u001a\u00020\n8GX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\r\"!\u0010\u000e\u001a\u00020\u000f8GX\u0004ø\u0001\u0000¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0012\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"DefaultMarqueeDelayMillis", "", "getDefaultMarqueeDelayMillis$annotations", "()V", "getDefaultMarqueeDelayMillis", "()I", "DefaultMarqueeIterations", "getDefaultMarqueeIterations$annotations", "getDefaultMarqueeIterations", "DefaultMarqueeSpacing", "Landroidx/compose/foundation/MarqueeSpacing;", "getDefaultMarqueeSpacing$annotations", "getDefaultMarqueeSpacing", "()Landroidx/compose/foundation/MarqueeSpacing;", "DefaultMarqueeVelocity", "Landroidx/compose/ui/unit/Dp;", "getDefaultMarqueeVelocity$annotations", "getDefaultMarqueeVelocity", "()F", "F", "MarqueeSpacing", "spacing", "MarqueeSpacing-0680j_4", "(F)Landroidx/compose/foundation/MarqueeSpacing;", "createMarqueeAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "iterations", "targetValue", "initialDelayMillis", "delayMillis", "velocity", "density", "Landroidx/compose/ui/unit/Density;", "createMarqueeAnimationSpec-Z4HSEVQ", "(IFIIFLandroidx/compose/ui/unit/Density;)Landroidx/compose/animation/core/AnimationSpec;", "velocityBasedTween", "Landroidx/compose/animation/core/TweenSpec;", "basicMarquee", "Landroidx/compose/ui/Modifier;", "animationMode", "Landroidx/compose/foundation/MarqueeAnimationMode;", "basicMarquee-1Mj1MLw", "(Landroidx/compose/ui/Modifier;IIIILandroidx/compose/foundation/MarqueeSpacing;F)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicMarquee.kt */
public final class BasicMarqueeKt {
    private static final int DefaultMarqueeDelayMillis = 1200;
    private static final int DefaultMarqueeIterations = 3;
    private static final MarqueeSpacing DefaultMarqueeSpacing = MarqueeSpacing.Companion.fractionOfContainer(0.33333334f);
    private static final float DefaultMarqueeVelocity = Dp.m5986constructorimpl((float) 30);

    public static /* synthetic */ void getDefaultMarqueeDelayMillis$annotations() {
    }

    public static /* synthetic */ void getDefaultMarqueeIterations$annotations() {
    }

    public static /* synthetic */ void getDefaultMarqueeSpacing$annotations() {
    }

    public static /* synthetic */ void getDefaultMarqueeVelocity$annotations() {
    }

    public static final int getDefaultMarqueeIterations() {
        return DefaultMarqueeIterations;
    }

    public static final int getDefaultMarqueeDelayMillis() {
        return DefaultMarqueeDelayMillis;
    }

    public static final MarqueeSpacing getDefaultMarqueeSpacing() {
        return DefaultMarqueeSpacing;
    }

    public static final float getDefaultMarqueeVelocity() {
        return DefaultMarqueeVelocity;
    }

    /* renamed from: basicMarquee-1Mj1MLw$default  reason: not valid java name */
    public static /* synthetic */ Modifier m453basicMarquee1Mj1MLw$default(Modifier modifier, int i, int i2, int i3, int i4, MarqueeSpacing marqueeSpacing, float f, int i5, Object obj) {
        int i6;
        int i7;
        int i8;
        MarqueeSpacing marqueeSpacing2;
        float f2;
        if ((i5 & 1) != 0) {
            i = DefaultMarqueeIterations;
        }
        if ((i5 & 2) != 0) {
            i6 = MarqueeAnimationMode.Companion.m510getImmediatelyZbEOnfQ();
        } else {
            i6 = i2;
        }
        if ((i5 & 4) != 0) {
            i7 = DefaultMarqueeDelayMillis;
        } else {
            i7 = i3;
        }
        if ((i5 & 8) != 0) {
            i8 = MarqueeAnimationMode.m504equalsimpl0(i6, MarqueeAnimationMode.Companion.m510getImmediatelyZbEOnfQ()) ? i7 : 0;
        } else {
            i8 = i4;
        }
        if ((i5 & 16) != 0) {
            marqueeSpacing2 = DefaultMarqueeSpacing;
        } else {
            marqueeSpacing2 = marqueeSpacing;
        }
        if ((i5 & 32) != 0) {
            f2 = DefaultMarqueeVelocity;
        } else {
            f2 = f;
        }
        return m452basicMarquee1Mj1MLw(modifier, i, i6, i7, i8, marqueeSpacing2, f2);
    }

    /* renamed from: basicMarquee-1Mj1MLw  reason: not valid java name */
    public static final Modifier m452basicMarquee1Mj1MLw(Modifier $this$basicMarquee_u2d1Mj1MLw, int iterations, int animationMode, int delayMillis, int initialDelayMillis, MarqueeSpacing spacing, float velocity) {
        Intrinsics.checkNotNullParameter($this$basicMarquee_u2d1Mj1MLw, "$this$basicMarquee");
        Intrinsics.checkNotNullParameter(spacing, "spacing");
        return ComposedModifierKt.composed($this$basicMarquee_u2d1Mj1MLw, InspectableValueKt.isDebugInspectorInfoEnabled() ? new BasicMarqueeKt$basicMarquee1Mj1MLw$$inlined$debugInspectorInfo$1(iterations, animationMode, delayMillis, initialDelayMillis, spacing, velocity) : InspectableValueKt.getNoInspectorInfo(), new BasicMarqueeKt$basicMarquee$2(iterations, delayMillis, initialDelayMillis, velocity, spacing, animationMode));
    }

    /* access modifiers changed from: private */
    /* renamed from: createMarqueeAnimationSpec-Z4HSEVQ  reason: not valid java name */
    public static final AnimationSpec<Float> m454createMarqueeAnimationSpecZ4HSEVQ(int iterations, float targetValue, int initialDelayMillis, int delayMillis, float velocity, Density density) {
        int i = delayMillis;
        TweenSpec<Float> velocityBasedTween = velocityBasedTween(Math.abs(density.m5967toPx0680j_4(velocity)), targetValue, i);
        long startOffset = StartOffset.m409constructorimpl$default((-i) + initialDelayMillis, 0, 2, (DefaultConstructorMarker) null);
        if (iterations == Integer.MAX_VALUE) {
            return AnimationSpecKt.m389infiniteRepeatable9IiC70o$default(velocityBasedTween, (RepeatMode) null, startOffset, 2, (Object) null);
        }
        return AnimationSpecKt.m391repeatable91I0pcU$default(iterations, velocityBasedTween, (RepeatMode) null, startOffset, 4, (Object) null);
    }

    private static final TweenSpec<Float> velocityBasedTween(float velocity, float targetValue, int delayMillis) {
        return AnimationSpecKt.tween((int) ((float) Math.ceil((double) (targetValue / (velocity / 1000.0f)))), delayMillis, EasingKt.getLinearEasing());
    }

    /* renamed from: MarqueeSpacing-0680j_4  reason: not valid java name */
    public static final MarqueeSpacing m450MarqueeSpacing0680j_4(float spacing) {
        return new BasicMarqueeKt$MarqueeSpacing$1(spacing);
    }
}
