package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
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
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B:\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\tJ&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0011J*\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0011R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\n\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/CardElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "(FFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "animateElevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "tonalElevation", "tonalElevation$material3_release", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Card.kt */
public final class CardElevation {
    /* access modifiers changed from: private */
    public final float defaultElevation;
    private final float disabledElevation;
    /* access modifiers changed from: private */
    public final float draggedElevation;
    /* access modifiers changed from: private */
    public final float focusedElevation;
    /* access modifiers changed from: private */
    public final float hoveredElevation;
    /* access modifiers changed from: private */
    public final float pressedElevation;

    public /* synthetic */ CardElevation(float f, float f2, float f3, float f4, float f5, float f6, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5, f6);
    }

    private CardElevation(float defaultElevation2, float pressedElevation2, float focusedElevation2, float hoveredElevation2, float draggedElevation2, float disabledElevation2) {
        this.defaultElevation = defaultElevation2;
        this.pressedElevation = pressedElevation2;
        this.focusedElevation = focusedElevation2;
        this.hoveredElevation = hoveredElevation2;
        this.draggedElevation = draggedElevation2;
        this.disabledElevation = disabledElevation2;
    }

    public final State<Dp> tonalElevation$material3_release(boolean enabled, InteractionSource interactionSource, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(1757792649);
        ComposerKt.sourceInformation($composer, "C(tonalElevation)586@27029L74:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1757792649, $changed, -1, "androidx.compose.material3.CardElevation.tonalElevation (Card.kt:579)");
        }
        $composer.startReplaceableGroup(603878391);
        ComposerKt.sourceInformation($composer, "584@26958L45");
        if (interactionSource == null) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m5984boximpl(this.defaultElevation), (SnapshotMutationPolicy) null, 2, (Object) null);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) value$iv$iv;
            $composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceableGroup();
            return mutableState;
        }
        $composer.endReplaceableGroup();
        State<Dp> animateElevation = animateElevation(enabled, interactionSource, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateElevation;
    }

    public final State<Dp> shadowElevation$material3_release(boolean enabled, InteractionSource interactionSource, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(-1763481333);
        ComposerKt.sourceInformation($composer, "C(shadowElevation)608@27911L74:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1763481333, $changed, -1, "androidx.compose.material3.CardElevation.shadowElevation (Card.kt:601)");
        }
        $composer.startReplaceableGroup(-1409180589);
        ComposerKt.sourceInformation($composer, "606@27840L45");
        if (interactionSource == null) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m5984boximpl(this.defaultElevation), (SnapshotMutationPolicy) null, 2, (Object) null);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) value$iv$iv;
            $composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceableGroup();
            return mutableState;
        }
        $composer.endReplaceableGroup();
        State<Dp> animateElevation = animateElevation(enabled, interactionSource, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateElevation;
    }

    private final State<Dp> animateElevation(boolean enabled, InteractionSource interactionSource, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        float target;
        Object value$iv$iv3;
        InteractionSource interactionSource2 = interactionSource;
        Composer composer = $composer;
        int i = $changed;
        composer.startReplaceableGroup(-1421890746);
        ComposerKt.sourceInformation(composer, "C(animateElevation)616@28160L46,617@28249L1473,617@28215L1507,669@30284L51,671@30345L776:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1421890746, i, -1, "androidx.compose.material3.CardElevation.animateElevation (Card.kt:612)");
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
        int i2 = ((i >> 3) & 14) | 560;
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) interactionSource2) | composer.changed((Object) interactions);
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv2 = (Function2) new CardElevation$animateElevation$1$1(interactionSource2, interactions, (Continuation<? super CardElevation$animateElevation$1$1>) null);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect((Object) interactionSource2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) value$iv$iv2, composer, ((i >> 3) & 14) | 64);
        Interaction interaction = (Interaction) CollectionsKt.lastOrNull(interactions);
        if (!enabled) {
            target = this.disabledElevation;
        } else if (interaction instanceof PressInteraction.Press) {
            target = this.pressedElevation;
        } else if (interaction instanceof HoverInteraction.Enter) {
            target = this.hoveredElevation;
        } else if (interaction instanceof FocusInteraction.Focus) {
            target = this.focusedElevation;
        } else if (interaction instanceof DragInteraction.Start) {
            target = this.draggedElevation;
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
        EffectsKt.LaunchedEffect((Object) Dp.m5984boximpl(target), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new CardElevation$animateElevation$2(enabled, animatable, this, target, interaction, (Continuation<? super CardElevation$animateElevation$2>) null), composer, 64);
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
        if (other == null || !(other instanceof CardElevation) || !Dp.m5991equalsimpl0(this.defaultElevation, ((CardElevation) other).defaultElevation) || !Dp.m5991equalsimpl0(this.pressedElevation, ((CardElevation) other).pressedElevation) || !Dp.m5991equalsimpl0(this.focusedElevation, ((CardElevation) other).focusedElevation) || !Dp.m5991equalsimpl0(this.hoveredElevation, ((CardElevation) other).hoveredElevation) || !Dp.m5991equalsimpl0(this.disabledElevation, ((CardElevation) other).disabledElevation)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((Dp.m5992hashCodeimpl(this.defaultElevation) * 31) + Dp.m5992hashCodeimpl(this.pressedElevation)) * 31) + Dp.m5992hashCodeimpl(this.focusedElevation)) * 31) + Dp.m5992hashCodeimpl(this.hoveredElevation)) * 31) + Dp.m5992hashCodeimpl(this.disabledElevation);
    }
}
