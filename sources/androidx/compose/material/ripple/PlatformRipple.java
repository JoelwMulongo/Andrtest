package androidx.compose.material.ripple;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B&\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007ø\u0001\u0000¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\fJI\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"Landroidx/compose/material/ripple/PlatformRipple;", "Landroidx/compose/material/ripple/Ripple;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "(ZFLandroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "findNearestViewGroup", "Landroid/view/ViewGroup;", "(Landroidx/compose/runtime/Composer;I)Landroid/view/ViewGroup;", "rememberUpdatedRippleInstance", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rememberUpdatedRippleInstance-942rkJo", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleIndicationInstance;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Ripple.android.kt */
public final class PlatformRipple extends Ripple {
    public /* synthetic */ PlatformRipple(boolean z, float f, State state, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, state);
    }

    private PlatformRipple(boolean bounded, float radius, State<Color> color) {
        super(bounded, radius, color, (DefaultConstructorMarker) null);
    }

    /* renamed from: rememberUpdatedRippleInstance-942rkJo  reason: not valid java name */
    public RippleIndicationInstance m1720rememberUpdatedRippleInstance942rkJo(InteractionSource interactionSource, boolean bounded, float radius, State<Color> color, State<RippleAlpha> rippleAlpha, Composer $composer, int $changed) {
        RippleContainer rippleContainer;
        InteractionSource interactionSource2 = interactionSource;
        Composer composer = $composer;
        int i = $changed;
        Intrinsics.checkNotNullParameter(interactionSource2, "interactionSource");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(rippleAlpha, "rippleAlpha");
        composer.startReplaceableGroup(331259447);
        ComposerKt.sourceInformation(composer, "C(rememberUpdatedRippleInstance)P(2!1,3:c#ui.unit.Dp)64@2484L22,90@3354L160:Ripple.android.kt#vhb33q");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(331259447, i, -1, "androidx.compose.material.ripple.PlatformRipple.rememberUpdatedRippleInstance (Ripple.android.kt:57)");
        }
        ViewGroup view = findNearestViewGroup(composer, (i >> 15) & 14);
        composer.startReplaceableGroup(1643267286);
        ComposerKt.sourceInformation(composer, "67@2658L133");
        if (view.isInEditMode()) {
            int i2 = (i & 14) | ((i >> 12) & 112);
            composer.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composer, "C(remember)P(1,2):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer;
            boolean invalid$iv$iv = composer.changed((Object) interactionSource2) | composer.changed((Object) this);
            Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || value$iv$iv == Composer.Companion.getEmpty()) {
                Object obj = value$iv$iv;
                value$iv$iv = new CommonRippleIndicationInstance(bounded, radius, color, rippleAlpha, (DefaultConstructorMarker) null);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                Object obj2 = value$iv$iv;
            }
            $composer.endReplaceableGroup();
            CommonRippleIndicationInstance commonRippleIndicationInstance = (CommonRippleIndicationInstance) value$iv$iv;
            $composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceableGroup();
            return commonRippleIndicationInstance;
        }
        $composer.endReplaceableGroup();
        View view2 = null;
        int index = 0;
        int childCount = view.getChildCount();
        while (true) {
            if (index >= childCount) {
                break;
            }
            View child = view.getChildAt(index);
            if (child instanceof RippleContainer) {
                view2 = child;
                break;
            }
            index++;
        }
        if (view2 == null) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            RippleContainer $this$rememberUpdatedRippleInstance_942rkJo_u24lambda_u241 = new RippleContainer(context);
            view.addView($this$rememberUpdatedRippleInstance_942rkJo_u24lambda_u241);
            rippleContainer = $this$rememberUpdatedRippleInstance_942rkJo_u24lambda_u241;
        } else {
            rippleContainer = view2;
        }
        int i3 = (i & 14) | 512 | ((i >> 12) & 112);
        RippleContainer rippleContainer2 = rippleContainer;
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = composer.changed((Object) interactionSource2) | composer.changed((Object) this) | composer.changed((Object) rippleContainer2);
        Composer $this$cache$iv$iv2 = $composer;
        Object value$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv2 || value$iv$iv2 == Composer.Companion.getEmpty()) {
            Object obj3 = value$iv$iv2;
            Composer $this$cache$iv$iv3 = $this$cache$iv$iv2;
            RippleContainer rippleContainer3 = rippleContainer2;
            value$iv$iv2 = new AndroidRippleIndicationInstance(bounded, radius, color, rippleAlpha, rippleContainer, (DefaultConstructorMarker) null);
            $this$cache$iv$iv3.updateRememberedValue(value$iv$iv2);
        } else {
            Object obj4 = value$iv$iv2;
            Composer composer2 = $this$cache$iv$iv2;
            RippleContainer rippleContainer4 = rippleContainer2;
        }
        $composer.endReplaceableGroup();
        AndroidRippleIndicationInstance androidRippleIndicationInstance = (AndroidRippleIndicationInstance) value$iv$iv2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return androidRippleIndicationInstance;
    }

    private final ViewGroup findNearestViewGroup(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1737891121);
        ComposerKt.sourceInformation($composer, "C(findNearestViewGroup)105@4003L7:Ripple.android.kt#vhb33q");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1737891121, $changed, -1, "androidx.compose.material.ripple.PlatformRipple.findNearestViewGroup (Ripple.android.kt:104)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Object view = consume;
        while (!(view instanceof ViewGroup)) {
            Object parent = ((View) view).getParent();
            if (parent instanceof View) {
                Intrinsics.checkNotNullExpressionValue(parent, "parent");
                view = parent;
            } else {
                throw new IllegalArgumentException(("Couldn't find a valid parent for " + view + ". Are you overriding LocalView and providing a View that is not attached to the view hierarchy?").toString());
            }
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return viewGroup;
    }
}
