package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B*\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0003ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\rJ \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\rR\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/FloatingActionButtonElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "animateElevation", "Landroidx/compose/runtime/State;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "tonalElevation", "tonalElevation$material3_release", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FloatingActionButton.kt */
public class FloatingActionButtonElevation {
    private final float defaultElevation;
    /* access modifiers changed from: private */
    public final float focusedElevation;
    /* access modifiers changed from: private */
    public final float hoveredElevation;
    /* access modifiers changed from: private */
    public final float pressedElevation;

    public /* synthetic */ FloatingActionButtonElevation(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    private FloatingActionButtonElevation(float defaultElevation2, float pressedElevation2, float focusedElevation2, float hoveredElevation2) {
        this.defaultElevation = defaultElevation2;
        this.pressedElevation = pressedElevation2;
        this.focusedElevation = focusedElevation2;
        this.hoveredElevation = hoveredElevation2;
    }

    public final State<Dp> shadowElevation$material3_release(InteractionSource interactionSource, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(-424810125);
        ComposerKt.sourceInformation($composer, "C(shadowElevation)494@23984L55:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-424810125, $changed, -1, "androidx.compose.material3.FloatingActionButtonElevation.shadowElevation (FloatingActionButton.kt:493)");
        }
        State<Dp> animateElevation = animateElevation(interactionSource, $composer, ($changed & 14) | ($changed & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateElevation;
    }

    public final State<Dp> tonalElevation$material3_release(InteractionSource interactionSource, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(-550096911);
        ComposerKt.sourceInformation($composer, "C(tonalElevation)499@24161L55:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-550096911, $changed, -1, "androidx.compose.material3.FloatingActionButtonElevation.tonalElevation (FloatingActionButton.kt:498)");
        }
        State<Dp> animateElevation = animateElevation(interactionSource, $composer, ($changed & 14) | ($changed & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateElevation;
    }

    private final State<Dp> animateElevation(InteractionSource interactionSource, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        float target;
        Object value$iv$iv3;
        InteractionSource interactionSource2 = interactionSource;
        Composer composer = $composer;
        int i = $changed;
        composer.startReplaceableGroup(-1845106002);
        ComposerKt.sourceInformation(composer, "C(animateElevation)504@24351L46,506@24441L1077,506@24407L1111,543@25862L51,545@25923L499:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1845106002, i, -1, "androidx.compose.material3.FloatingActionButtonElevation.animateElevation (FloatingActionButton.kt:503)");
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = SnapshotStateKt.mutableStateListOf();
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        SnapshotStateList interactions = (SnapshotStateList) value$iv$iv;
        int i2 = (i & 14) | 560;
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) interactionSource2) | composer.changed((Object) interactions);
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv2 = (Function2) new FloatingActionButtonElevation$animateElevation$1$1(interactionSource2, interactions, (Continuation<? super FloatingActionButtonElevation$animateElevation$1$1>) null);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect((Object) interactionSource2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) value$iv$iv2, composer, (i & 14) | 64);
        Interaction interaction = (Interaction) CollectionsKt.lastOrNull(interactions);
        if (interaction instanceof PressInteraction.Press) {
            target = this.pressedElevation;
        } else if (interaction instanceof HoverInteraction.Enter) {
            target = this.hoveredElevation;
        } else if (interaction instanceof FocusInteraction.Focus) {
            target = this.focusedElevation;
        } else {
            target = this.defaultElevation;
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv3 = $composer;
        Object it$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
        if (it$iv$iv3 == Composer.Companion.getEmpty()) {
            value$iv$iv3 = new Animatable(Dp.m5984boximpl(target), VectorConvertersKt.getVectorConverter(Dp.Companion), (Object) null, 4, (DefaultConstructorMarker) null);
            $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
        } else {
            value$iv$iv3 = it$iv$iv3;
        }
        $composer.endReplaceableGroup();
        Animatable animatable = (Animatable) value$iv$iv3;
        EffectsKt.LaunchedEffect((Object) Dp.m5984boximpl(target), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new FloatingActionButtonElevation$animateElevation$2(animatable, this, target, interaction, (Continuation<? super FloatingActionButtonElevation$animateElevation$2>) null), composer, 64);
        State<Dp> asState = animatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return asState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof FloatingActionButtonElevation) || !Dp.m5991equalsimpl0(this.defaultElevation, ((FloatingActionButtonElevation) other).defaultElevation) || !Dp.m5991equalsimpl0(this.pressedElevation, ((FloatingActionButtonElevation) other).pressedElevation) || !Dp.m5991equalsimpl0(this.focusedElevation, ((FloatingActionButtonElevation) other).focusedElevation) || !Dp.m5991equalsimpl0(this.hoveredElevation, ((FloatingActionButtonElevation) other).hoveredElevation)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((Dp.m5992hashCodeimpl(this.defaultElevation) * 31) + Dp.m5992hashCodeimpl(this.pressedElevation)) * 31) + Dp.m5992hashCodeimpl(this.focusedElevation)) * 31) + Dp.m5992hashCodeimpl(this.hoveredElevation);
    }
}
