package androidx.compose.foundation.pager;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JO\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/pager/PagerDefaults;", "", "()V", "flingBehavior", "Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "state", "Landroidx/compose/foundation/pager/PagerState;", "pagerSnapDistance", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "lowVelocityAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "highVelocityAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/pager/PagerSnapDistance;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Pager.kt */
public final class PagerDefaults {
    public static final int $stable = 0;
    public static final PagerDefaults INSTANCE = new PagerDefaults();

    private PagerDefaults() {
    }

    public final SnapFlingBehavior flingBehavior(PagerState state, PagerSnapDistance pagerSnapDistance, AnimationSpec<Float> lowVelocityAnimationSpec, DecayAnimationSpec<Float> highVelocityAnimationSpec, AnimationSpec<Float> snapAnimationSpec, Composer $composer, int $changed, int i) {
        AnimationSpec lowVelocityAnimationSpec2;
        DecayAnimationSpec<Float> decayAnimationSpec;
        AnimationSpec snapAnimationSpec2;
        PagerState pagerState = state;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(pagerState, "state");
        composer.startReplaceableGroup(-344874176);
        ComposerKt.sourceInformation(composer, "C(flingBehavior)P(4,2,1)469@20718L26,472@20905L7,474@20929L662:Pager.kt#g6yjnt");
        PagerSnapDistance pagerSnapDistance2 = (i & 2) != 0 ? PagerSnapDistance.Companion.atMost(1) : pagerSnapDistance;
        if ((i & 4) != 0) {
            lowVelocityAnimationSpec2 = AnimationSpecKt.tween$default(500, 0, EasingKt.getLinearEasing(), 2, (Object) null);
        } else {
            lowVelocityAnimationSpec2 = lowVelocityAnimationSpec;
        }
        if ((i & 8) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0);
        } else {
            decayAnimationSpec = highVelocityAnimationSpec;
        }
        if ((i & 16) != 0) {
            snapAnimationSpec2 = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        } else {
            snapAnimationSpec2 = snapAnimationSpec;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-344874176, $changed, -1, "androidx.compose.foundation.pager.PagerDefaults.flingBehavior (Pager.kt:462)");
        } else {
            int i2 = $changed;
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume;
        Object[] keys$iv = {lowVelocityAnimationSpec2, decayAnimationSpec, snapAnimationSpec2, pagerSnapDistance2, density};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= composer.changed(key$iv);
        }
        Composer $this$cache$iv$iv = $composer;
        Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv || value$iv$iv == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv;
            Object[] objArr = keys$iv;
            DecayAnimationSpec<Float> decayAnimationSpec2 = decayAnimationSpec;
            value$iv$iv = new SnapFlingBehavior(PagerKt.SnapLayoutInfoProvider(pagerState, pagerSnapDistance2, decayAnimationSpec), lowVelocityAnimationSpec2, decayAnimationSpec, snapAnimationSpec2, density, 0.0f, 32, (DefaultConstructorMarker) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            Object obj2 = value$iv$iv;
            Object[] objArr2 = keys$iv;
            DecayAnimationSpec<Float> decayAnimationSpec3 = decayAnimationSpec;
        }
        $composer.endReplaceableGroup();
        SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return snapFlingBehavior;
    }

    public final NestedScrollConnection pageNestedScrollConnection(Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == Orientation.Horizontal) {
            return PagerKt.ConsumeHorizontalFlingNestedScrollConnection;
        }
        return PagerKt.ConsumeVerticalFlingNestedScrollConnection;
    }
}
