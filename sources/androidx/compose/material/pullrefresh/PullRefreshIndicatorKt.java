package androidx.compose.material.pullrefresh;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationConstants;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002\u001a-\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aM\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001a2\b\b\u0002\u0010#\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020!H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001aA\u0010'\u001a\u00020\u0016*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0013H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u0013\u0010\n\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u000b\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\f\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0011\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"AlphaTween", "Landroidx/compose/animation/core/TweenSpec;", "", "ArcRadius", "Landroidx/compose/ui/unit/Dp;", "F", "ArrowHeight", "ArrowWidth", "CrossfadeDurationMs", "", "Elevation", "IndicatorSize", "MaxAlpha", "MaxProgressArc", "MinAlpha", "SpinnerShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "StrokeWidth", "ArrowValues", "Landroidx/compose/material/pullrefresh/ArrowValues;", "progress", "CircularArrowIndicator", "", "state", "Landroidx/compose/material/pullrefresh/PullRefreshState;", "color", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "CircularArrowIndicator-iJQMabo", "(Landroidx/compose/material/pullrefresh/PullRefreshState;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "PullRefreshIndicator", "refreshing", "", "backgroundColor", "contentColor", "scale", "PullRefreshIndicator-jB83MbM", "(ZLandroidx/compose/material/pullrefresh/PullRefreshState;Landroidx/compose/ui/Modifier;JJZLandroidx/compose/runtime/Composer;II)V", "drawArrow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "alpha", "values", "drawArrow-Bx497Mc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material/pullrefresh/ArrowValues;)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullRefreshIndicator.kt */
public final class PullRefreshIndicatorKt {
    private static final TweenSpec<Float> AlphaTween = AnimationSpecKt.tween$default(AnimationConstants.DefaultDurationMillis, 0, EasingKt.getLinearEasing(), 2, (Object) null);
    /* access modifiers changed from: private */
    public static final float ArcRadius = Dp.m5986constructorimpl((float) 7.5d);
    private static final float ArrowHeight = Dp.m5986constructorimpl((float) 5);
    private static final float ArrowWidth = Dp.m5986constructorimpl((float) 10);
    private static final int CrossfadeDurationMs = 100;
    private static final float Elevation = Dp.m5986constructorimpl((float) 6);
    private static final float IndicatorSize = Dp.m5986constructorimpl((float) 40);
    private static final float MaxAlpha = 1.0f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final RoundedCornerShape SpinnerShape = RoundedCornerShapeKt.getCircleShape();
    /* access modifiers changed from: private */
    public static final float StrokeWidth = Dp.m5986constructorimpl((float) 2.5d);

    /* renamed from: PullRefreshIndicator-jB83MbM  reason: not valid java name */
    public static final void m1709PullRefreshIndicatorjB83MbM(boolean refreshing, PullRefreshState state, Modifier modifier, long backgroundColor, long contentColor, boolean scale, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long backgroundColor2;
        long contentColor2;
        int $dirty;
        boolean scale2;
        State key1$iv;
        float f;
        PullRefreshState pullRefreshState = state;
        Intrinsics.checkNotNullParameter(pullRefreshState, "state");
        Composer $composer2 = $composer.startRestartGroup(308716636);
        ComposerKt.sourceInformation($composer2, "C(PullRefreshIndicator)P(3,5,2,0:c#ui.graphics.Color,1:c#ui.graphics.Color)76@3283L6,77@3325L32,80@3415L98,84@3519L1047:PullRefreshIndicator.kt#t44y28");
        int $dirty2 = $changed;
        if ((i & 4) != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) != 0) {
            $dirty2 &= -7169;
            backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1449getSurface0d7_KjU();
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((i & 16) != 0) {
            $dirty = $dirty2 & -57345;
            contentColor2 = ColorsKt.m1463contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 9) & 14);
        } else {
            contentColor2 = contentColor;
            $dirty = $dirty2;
        }
        if ((i & 32) != 0) {
            scale2 = false;
        } else {
            scale2 = scale;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(308716636, $dirty, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator (PullRefreshIndicator.kt:72)");
        }
        Boolean valueOf = Boolean.valueOf(refreshing);
        int i2 = ($dirty & 14) | 64;
        $composer2.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer2.changed((Object) valueOf) | $composer2.changed((Object) pullRefreshState);
        Composer $this$cache$iv$iv = $composer2;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            Boolean bool = valueOf;
            boolean z = invalid$iv$iv;
            key1$iv = SnapshotStateKt.derivedStateOf(new PullRefreshIndicatorKt$PullRefreshIndicator$showElevation$2$1(refreshing, pullRefreshState));
            $this$cache$iv$iv.updateRememberedValue(key1$iv);
        } else {
            Boolean bool2 = valueOf;
            boolean z2 = invalid$iv$iv;
            key1$iv = it$iv$iv;
            boolean invalid$iv$iv2 = refreshing;
        }
        $composer2.endReplaceableGroup();
        Modifier pullRefreshIndicatorTransform = PullRefreshIndicatorTransformKt.pullRefreshIndicatorTransform(SizeKt.m830size3ABfNKs(modifier2, IndicatorSize), pullRefreshState, scale2);
        Shape shape = SpinnerShape;
        if (PullRefreshIndicator_jB83MbM$lambda$1(key1$iv)) {
            f = Elevation;
        } else {
            f = Dp.m5986constructorimpl((float) 0);
        }
        SurfaceKt.m1620SurfaceFjzlyU(pullRefreshIndicatorTransform, shape, backgroundColor2, 0, (BorderStroke) null, f, ComposableLambdaKt.composableLambda($composer2, -194757728, true, new PullRefreshIndicatorKt$PullRefreshIndicator$1(refreshing, $dirty, contentColor2, state)), $composer2, (($dirty >> 3) & 896) | 1572912, 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            boolean z3 = scale2;
            long j = backgroundColor2;
            int i3 = $dirty;
            Modifier modifier3 = modifier2;
            Composer composer = $composer2;
            return;
        }
        long j2 = backgroundColor2;
        int i4 = $dirty;
        Modifier modifier4 = modifier2;
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new PullRefreshIndicatorKt$PullRefreshIndicator$2(refreshing, state, modifier2, backgroundColor2, contentColor2, scale2, $changed, i));
    }

    private static final boolean PullRefreshIndicator_jB83MbM$lambda$1(State<Boolean> $showElevation$delegate) {
        return ((Boolean) $showElevation$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: CircularArrowIndicator-iJQMabo  reason: not valid java name */
    public static final void m1708CircularArrowIndicatoriJQMabo(PullRefreshState state, long color, Modifier modifier, Composer $composer, int $changed) {
        Object value$iv$iv;
        State value$iv$iv2;
        PullRefreshState pullRefreshState = state;
        Composer $composer2 = $composer.startRestartGroup(-486016981);
        ComposerKt.sourceInformation($composer2, "C(CircularArrowIndicator)P(2,0:c#ui.graphics.Color)126@4777L61,128@4863L119,134@5005L74,137@5118L1000:PullRefreshIndicator.kt#t44y28");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-486016981, $changed, -1, "androidx.compose.material.pullrefresh.CircularArrowIndicator (PullRefreshIndicator.kt:121)");
        } else {
            int i = $changed;
        }
        $composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer2;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            Object $this$CircularArrowIndicator_iJQMabo_u24lambda_u243_u24lambda_u242 = AndroidPath_androidKt.Path();
            $this$CircularArrowIndicator_iJQMabo_u24lambda_u243_u24lambda_u242.m3445setFillTypeoQ8Xj4U(PathFillType.Companion.m3457getEvenOddRgk1Os());
            value$iv$iv = $this$CircularArrowIndicator_iJQMabo_u24lambda_u243_u24lambda_u242;
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer2.endReplaceableGroup();
        Path path = (Path) value$iv$iv;
        $composer2.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer2.changed((Object) pullRefreshState);
        Composer $this$cache$iv$iv2 = $composer2;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv2 = SnapshotStateKt.derivedStateOf(new PullRefreshIndicatorKt$CircularArrowIndicator$targetAlpha$2$1(pullRefreshState));
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer2.endReplaceableGroup();
        Modifier modifier2 = modifier;
        CanvasKt.Canvas(SemanticsModifierKt.semantics$default(modifier2, false, PullRefreshIndicatorKt$CircularArrowIndicator$1.INSTANCE, 1, (Object) null), new PullRefreshIndicatorKt$CircularArrowIndicator$2(state, AnimateAsStateKt.animateFloatAsState(CircularArrowIndicator_iJQMabo$lambda$5(value$iv$iv2), AlphaTween, 0.0f, (Function1) null, $composer2, 48, 12), color, path), $composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PullRefreshIndicatorKt$CircularArrowIndicator$3(state, color, modifier, $changed));
        }
    }

    private static final float CircularArrowIndicator_iJQMabo$lambda$5(State<Float> $targetAlpha$delegate) {
        return ((Number) $targetAlpha$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final ArrowValues ArrowValues(float progress) {
        float adjustedPercent = (Math.max(Math.min(1.0f, progress) - 0.4f, 0.0f) * ((float) 5)) / ((float) 3);
        float linearTension = RangesKt.coerceIn(Math.abs(progress) - 1.0f, 0.0f, 2.0f);
        float rotation = (((0.4f * adjustedPercent) - 16.0f) + (linearTension - (((float) Math.pow((double) linearTension, (double) 2)) / ((float) 4)))) * 0.5f;
        float f = (float) 360;
        return new ArrowValues(rotation, rotation * f, (rotation + (MaxProgressArc * adjustedPercent)) * f, Math.min(1.0f, adjustedPercent));
    }

    /* access modifiers changed from: private */
    /* renamed from: drawArrow-Bx497Mc  reason: not valid java name */
    public static final void m1712drawArrowBx497Mc(DrawScope $this$drawArrow_u2dBx497Mc, Path arrow, Rect bounds, long color, float alpha, ArrowValues values) {
        DrawScope drawScope = $this$drawArrow_u2dBx497Mc;
        Path path = arrow;
        arrow.reset();
        path.moveTo(0.0f, 0.0f);
        float f = ArrowWidth;
        path.lineTo(drawScope.m5967toPx0680j_4(f) * values.getScale(), 0.0f);
        path.lineTo((drawScope.m5967toPx0680j_4(f) * values.getScale()) / ((float) 2), drawScope.m5967toPx0680j_4(ArrowHeight) * values.getScale());
        float radius = Math.min(bounds.getWidth(), bounds.getHeight()) / 2.0f;
        path.m3446translatek4lQ0M(OffsetKt.Offset((Offset.m2915getXimpl(bounds.m2945getCenterF1C5BW0()) + radius) - ((drawScope.m5967toPx0680j_4(f) * values.getScale()) / 2.0f), Offset.m2916getYimpl(bounds.m2945getCenterF1C5BW0()) + (drawScope.m5967toPx0680j_4(StrokeWidth) / 2.0f)));
        arrow.close();
        DrawScope $this$rotate_u2dRg1IO4c_u24default$iv = $this$drawArrow_u2dBx497Mc;
        float degrees$iv = values.getEndAngle();
        long pivot$iv = $this$rotate_u2dRg1IO4c_u24default$iv.m3771getCenterF1C5BW0();
        DrawScope $this$withTransform$iv$iv = $this$rotate_u2dRg1IO4c_u24default$iv;
        DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform$iv$iv.getDrawContext();
        long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
        $this$withTransform_u24lambda_u246$iv$iv.getTransform().m3830rotateUv8p0NA(degrees$iv, pivot$iv);
        DrawContext $this$withTransform_u24lambda_u246$iv$iv2 = $this$withTransform_u24lambda_u246$iv$iv;
        long j = pivot$iv;
        DrawScope.m3744drawPathLG529CI$default($this$withTransform$iv$iv, arrow, color, alpha, (DrawStyle) null, (ColorFilter) null, 0, 56, (Object) null);
        $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv$iv2.m3716setSizeuvyYCjk(previousSize$iv$iv);
    }
}
