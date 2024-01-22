package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000b¢\u0006\u0002\b\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"BoxWithConstraints", "", "modifier", "Landroidx/compose/ui/Modifier;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BoxWithConstraints.kt */
public final class BoxWithConstraintsKt {
    public static final void BoxWithConstraints(Modifier modifier, Alignment contentAlignment, boolean propagateMinConstraints, Function3<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Alignment alignment;
        boolean propagateMinConstraints2;
        boolean propagateMinConstraints3;
        Alignment contentAlignment2;
        Modifier modifier3;
        Modifier modifier4;
        Alignment contentAlignment3;
        Alignment contentAlignment4;
        Object value$iv$iv;
        Function3<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, Unit> function3 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(1781813501);
        ComposerKt.sourceInformation($composer2, "C(BoxWithConstraints)P(2,1,3)65@3186L67,66@3285L218,66@3258L245:BoxWithConstraints.kt#2w3rfo");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if ((i2 & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            alignment = contentAlignment;
        } else if ((i2 & 112) == 0) {
            alignment = contentAlignment;
            $dirty |= $composer2.changed((Object) alignment) ? 32 : 16;
        } else {
            alignment = contentAlignment;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            propagateMinConstraints2 = propagateMinConstraints;
        } else if ((i2 & 896) == 0) {
            propagateMinConstraints2 = propagateMinConstraints;
            $dirty |= $composer2.changed(propagateMinConstraints2) ? 256 : 128;
        } else {
            propagateMinConstraints2 = propagateMinConstraints;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if ((i2 & 7168) == 0) {
            $dirty |= $composer2.changed((Object) function3) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                contentAlignment3 = Alignment.Companion.getTopStart();
            } else {
                contentAlignment3 = alignment;
            }
            if (i5 != 0) {
                propagateMinConstraints2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1781813501, $dirty2, -1, "androidx.compose.foundation.layout.BoxWithConstraints (BoxWithConstraints.kt:58)");
            }
            MeasurePolicy measurePolicy = BoxKt.rememberBoxMeasurePolicy(contentAlignment3, propagateMinConstraints2, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 112));
            int i6 = ($dirty2 >> 9) & 14;
            $composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed((Object) function3) | $composer2.changed((Object) measurePolicy);
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                contentAlignment4 = contentAlignment3;
                value$iv$iv = (Function2) new BoxWithConstraintsKt$BoxWithConstraints$1$1(measurePolicy, function3, $dirty2);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                contentAlignment4 = contentAlignment3;
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier4, (Function2) value$iv$iv, $composer2, $dirty2 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentAlignment2 = contentAlignment4;
            propagateMinConstraints3 = propagateMinConstraints2;
            modifier3 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
            contentAlignment2 = alignment;
            propagateMinConstraints3 = propagateMinConstraints2;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BoxWithConstraintsKt$BoxWithConstraints$2(modifier3, contentAlignment2, propagateMinConstraints3, content, $changed, i));
        }
    }
}
