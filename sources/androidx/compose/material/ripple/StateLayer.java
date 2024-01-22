package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014J'\u0010\u0015\u001a\u00020\u0011*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Landroidx/compose/material/ripple/StateLayer;", "", "bounded", "", "rippleAlpha", "Landroidx/compose/runtime/State;", "Landroidx/compose/material/ripple/RippleAlpha;", "(ZLandroidx/compose/runtime/State;)V", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "currentInteraction", "Landroidx/compose/foundation/interaction/Interaction;", "interactions", "", "handleInteraction", "", "interaction", "scope", "Lkotlinx/coroutines/CoroutineScope;", "drawStateLayer", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "drawStateLayer-H2RKhps", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJ)V", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Ripple.kt */
final class StateLayer {
    /* access modifiers changed from: private */
    public final Animatable<Float, AnimationVector1D> animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
    private final boolean bounded;
    private Interaction currentInteraction;
    private final List<Interaction> interactions = new ArrayList();
    private final State<RippleAlpha> rippleAlpha;

    public StateLayer(boolean bounded2, State<RippleAlpha> rippleAlpha2) {
        Intrinsics.checkNotNullParameter(rippleAlpha2, "rippleAlpha");
        this.bounded = bounded2;
        this.rippleAlpha = rippleAlpha2;
    }

    public final void handleInteraction(Interaction interaction, CoroutineScope scope) {
        float targetAlpha;
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (interaction instanceof HoverInteraction.Enter) {
            this.interactions.add(interaction);
        } else if (interaction instanceof HoverInteraction.Exit) {
            this.interactions.remove(((HoverInteraction.Exit) interaction).getEnter());
        } else if (interaction instanceof FocusInteraction.Focus) {
            this.interactions.add(interaction);
        } else if (interaction instanceof FocusInteraction.Unfocus) {
            this.interactions.remove(((FocusInteraction.Unfocus) interaction).getFocus());
        } else if (interaction instanceof DragInteraction.Start) {
            this.interactions.add(interaction);
        } else if (interaction instanceof DragInteraction.Stop) {
            this.interactions.remove(((DragInteraction.Stop) interaction).getStart());
        } else if (interaction instanceof DragInteraction.Cancel) {
            this.interactions.remove(((DragInteraction.Cancel) interaction).getStart());
        } else {
            return;
        }
        Interaction newInteraction = (Interaction) CollectionsKt.lastOrNull(this.interactions);
        if (!Intrinsics.areEqual((Object) this.currentInteraction, (Object) newInteraction)) {
            if (newInteraction != null) {
                if (interaction instanceof HoverInteraction.Enter) {
                    targetAlpha = this.rippleAlpha.getValue().getHoveredAlpha();
                } else if (interaction instanceof FocusInteraction.Focus) {
                    targetAlpha = this.rippleAlpha.getValue().getFocusedAlpha();
                } else if (interaction instanceof DragInteraction.Start) {
                    targetAlpha = this.rippleAlpha.getValue().getDraggedAlpha();
                } else {
                    targetAlpha = 0.0f;
                }
                Job unused = BuildersKt__Builders_commonKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new StateLayer$handleInteraction$1(this, targetAlpha, RippleKt.incomingStateLayerAnimationSpecFor(newInteraction), (Continuation<? super StateLayer$handleInteraction$1>) null), 3, (Object) null);
            } else {
                Job unused2 = BuildersKt__Builders_commonKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new StateLayer$handleInteraction$2(this, RippleKt.outgoingStateLayerAnimationSpecFor(this.currentInteraction), (Continuation<? super StateLayer$handleInteraction$2>) null), 3, (Object) null);
            }
            this.currentInteraction = newInteraction;
        }
    }

    /* renamed from: drawStateLayer-H2RKhps  reason: not valid java name */
    public final void m1733drawStateLayerH2RKhps(DrawScope $this$drawStateLayer_u2dH2RKhps, float radius, long color) {
        float targetRadius;
        DrawScope drawScope = $this$drawStateLayer_u2dH2RKhps;
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawStateLayer");
        if (Float.isNaN(radius)) {
            targetRadius = RippleAnimationKt.m1723getRippleEndRadiuscSwnlzA(drawScope, this.bounded, $this$drawStateLayer_u2dH2RKhps.m3772getSizeNHjbRc());
        } else {
            targetRadius = $this$drawStateLayer_u2dH2RKhps.m5967toPx0680j_4(radius);
        }
        float alpha = this.animatedAlpha.getValue().floatValue();
        if (alpha > 0.0f) {
            long modulatedColor = Color.m3163copywmQWz5c$default(color, alpha, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            if (this.bounded) {
                DrawScope $this$clipRect_u2drOu3jXo_u24default$iv = $this$drawStateLayer_u2dH2RKhps;
                float right$iv = Size.m2984getWidthimpl($this$clipRect_u2drOu3jXo_u24default$iv.m3772getSizeNHjbRc());
                float bottom$iv = Size.m2981getHeightimpl($this$clipRect_u2drOu3jXo_u24default$iv.m3772getSizeNHjbRc());
                int clipOp$iv = ClipOp.Companion.m3153getIntersectrtfAjoo();
                DrawScope $this$withTransform$iv$iv = $this$clipRect_u2drOu3jXo_u24default$iv;
                DrawContext $this$withTransform_u24lambda_u2d6$iv$iv = $this$withTransform$iv$iv.getDrawContext();
                long previousSize$iv$iv = $this$withTransform_u24lambda_u2d6$iv$iv.m3715getSizeNHjbRc();
                $this$withTransform_u24lambda_u2d6$iv$iv.getCanvas().save();
                DrawScope drawScope2 = $this$clipRect_u2drOu3jXo_u24default$iv;
                $this$withTransform_u24lambda_u2d6$iv$iv.getTransform().m3827clipRectN_I0leg(0.0f, 0.0f, right$iv, bottom$iv, clipOp$iv);
                DrawContext $this$withTransform_u24lambda_u2d6$iv$iv2 = $this$withTransform_u24lambda_u2d6$iv$iv;
                DrawScope.m3735drawCircleVaOC9Bg$default($this$withTransform$iv$iv, modulatedColor, targetRadius, 0, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 124, (Object) null);
                $this$withTransform_u24lambda_u2d6$iv$iv2.getCanvas().restore();
                $this$withTransform_u24lambda_u2d6$iv$iv2.m3716setSizeuvyYCjk(previousSize$iv$iv);
                return;
            }
            DrawScope.m3735drawCircleVaOC9Bg$default($this$drawStateLayer_u2dH2RKhps, modulatedColor, targetRadius, 0, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 124, (Object) null);
        }
    }
}
