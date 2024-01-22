package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a<\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\n\u001aW\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u0017\u001aE\u0010\u000b\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u0018\u001a\u0001\u0010\u0019\u001a\u00020\f*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u001d\u001aw\u0010\u0019\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u001e\u001a©\u0001\u0010\u001f\u001a\u00020\f*\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010!\u001a\u00020\"2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b&\u001aQ\u0010'\u001a\u00020\u0001*\u00020(2\u0006\u0010)\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00160$H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"PressedInteractionSourceDisposableEffect", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "pressedInteraction", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "currentKeyPressInteractions", "", "Landroidx/compose/ui/input/key/Key;", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/MutableState;Ljava/util/Map;Landroidx/compose/runtime/Composer;I)V", "clickable", "Landroidx/compose/ui/Modifier;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "clickable-O2vRcR0", "clickable-XHw0xAI", "combinedClickable", "onLongClickLabel", "onLongClick", "onDoubleClick", "combinedClickable-XVZzFYc", "combinedClickable-cJG_KMw", "genericClickableWithoutGesture", "gestureModifiers", "indicationScope", "Lkotlinx/coroutines/CoroutineScope;", "keyClickOffset", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/geometry/Offset;", "genericClickableWithoutGesture-bdNGguI", "handlePressInteraction", "Landroidx/compose/foundation/gestures/PressGestureScope;", "pressPoint", "delayPressInteraction", "handlePressInteraction-EPk0efs", "(Landroidx/compose/foundation/gestures/PressGestureScope;JLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
public final class ClickableKt {
    /* renamed from: clickable-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m473clickableXHw0xAI$default(Modifier modifier, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m472clickableXHw0xAI(modifier, z, str, role, function0);
    }

    /* renamed from: clickable-XHw0xAI  reason: not valid java name */
    public static final Modifier m472clickableXHw0xAI(Modifier $this$clickable_u2dXHw0xAI, boolean enabled, String onClickLabel, Role role, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter($this$clickable_u2dXHw0xAI, "$this$clickable");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.composed($this$clickable_u2dXHw0xAI, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$clickableXHw0xAI$$inlined$debugInspectorInfo$1(enabled, onClickLabel, role, onClick) : InspectableValueKt.getNoInspectorInfo(), new ClickableKt$clickable$2(enabled, onClickLabel, role, onClick));
    }

    /* renamed from: clickable-O2vRcR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m471clickableO2vRcR0$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        boolean z2;
        String str2;
        Role role2;
        if ((i & 4) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        if ((i & 8) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i & 16) != 0) {
            role2 = null;
        } else {
            role2 = role;
        }
        return m470clickableO2vRcR0(modifier, mutableInteractionSource, indication, z2, str2, role2, function0);
    }

    /* renamed from: clickable-O2vRcR0  reason: not valid java name */
    public static final Modifier m470clickableO2vRcR0(Modifier $this$clickable_u2dO2vRcR0, MutableInteractionSource interactionSource, Indication indication, boolean enabled, String onClickLabel, Role role, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter($this$clickable_u2dO2vRcR0, "$this$clickable");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.composed($this$clickable_u2dO2vRcR0, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$clickableO2vRcR0$$inlined$debugInspectorInfo$1(enabled, onClickLabel, role, onClick, indication, interactionSource) : InspectableValueKt.getNoInspectorInfo(), new ClickableKt$clickable$4(onClick, enabled, interactionSource, indication, onClickLabel, role));
    }

    /* renamed from: combinedClickable-cJG_KMw$default  reason: not valid java name */
    public static /* synthetic */ Modifier m477combinedClickablecJG_KMw$default(Modifier modifier, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        boolean z2;
        String str3;
        Role role2;
        String str4;
        Function0 function04;
        Function0 function05;
        if ((i & 1) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        if ((i & 2) != 0) {
            str3 = null;
        } else {
            str3 = str;
        }
        if ((i & 4) != 0) {
            role2 = null;
        } else {
            role2 = role;
        }
        if ((i & 8) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i & 16) != 0) {
            function04 = null;
        } else {
            function04 = function0;
        }
        if ((i & 32) != 0) {
            function05 = null;
        } else {
            function05 = function02;
        }
        return m476combinedClickablecJG_KMw(modifier, z2, str3, role2, str4, function04, function05, function03);
    }

    /* renamed from: combinedClickable-cJG_KMw  reason: not valid java name */
    public static final Modifier m476combinedClickablecJG_KMw(Modifier $this$combinedClickable_u2dcJG_KMw, boolean enabled, String onClickLabel, Role role, String onLongClickLabel, Function0<Unit> onLongClick, Function0<Unit> onDoubleClick, Function0<Unit> onClick) {
        Modifier modifier = $this$combinedClickable_u2dcJG_KMw;
        Intrinsics.checkNotNullParameter($this$combinedClickable_u2dcJG_KMw, "$this$combinedClickable");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.composed($this$combinedClickable_u2dcJG_KMw, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$combinedClickablecJG_KMw$$inlined$debugInspectorInfo$1(enabled, onClickLabel, role, onClick, onDoubleClick, onLongClick, onLongClickLabel) : InspectableValueKt.getNoInspectorInfo(), new ClickableKt$combinedClickable$2(enabled, onClickLabel, role, onLongClickLabel, onLongClick, onDoubleClick, onClick));
    }

    /* renamed from: combinedClickable-XVZzFYc$default  reason: not valid java name */
    public static /* synthetic */ Modifier m475combinedClickableXVZzFYc$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        boolean z2;
        String str3;
        Role role2;
        String str4;
        Function0 function04;
        Function0 function05;
        int i2 = i;
        if ((i2 & 4) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        if ((i2 & 8) != 0) {
            str3 = null;
        } else {
            str3 = str;
        }
        if ((i2 & 16) != 0) {
            role2 = null;
        } else {
            role2 = role;
        }
        if ((i2 & 32) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i2 & 64) != 0) {
            function04 = null;
        } else {
            function04 = function0;
        }
        if ((i2 & 128) != 0) {
            function05 = null;
        } else {
            function05 = function02;
        }
        return m474combinedClickableXVZzFYc(modifier, mutableInteractionSource, indication, z2, str3, role2, str4, function04, function05, function03);
    }

    /* renamed from: combinedClickable-XVZzFYc  reason: not valid java name */
    public static final Modifier m474combinedClickableXVZzFYc(Modifier $this$combinedClickable_u2dXVZzFYc, MutableInteractionSource interactionSource, Indication indication, boolean enabled, String onClickLabel, Role role, String onLongClickLabel, Function0<Unit> onLongClick, Function0<Unit> onDoubleClick, Function0<Unit> onClick) {
        Modifier modifier = $this$combinedClickable_u2dXVZzFYc;
        Intrinsics.checkNotNullParameter($this$combinedClickable_u2dXVZzFYc, "$this$combinedClickable");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.composed($this$combinedClickable_u2dXVZzFYc, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$combinedClickableXVZzFYc$$inlined$debugInspectorInfo$1(enabled, onClickLabel, role, onClick, onDoubleClick, onLongClick, onLongClickLabel, indication, interactionSource) : InspectableValueKt.getNoInspectorInfo(), new ClickableKt$combinedClickable$4(onClick, onLongClick, onDoubleClick, enabled, interactionSource, indication, onClickLabel, role, onLongClickLabel));
    }

    public static final void PressedInteractionSourceDisposableEffect(MutableInteractionSource interactionSource, MutableState<PressInteraction.Press> pressedInteraction, Map<Key, PressInteraction.Press> currentKeyPressInteractions, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(pressedInteraction, "pressedInteraction");
        Intrinsics.checkNotNullParameter(currentKeyPressInteractions, "currentKeyPressInteractions");
        Composer $composer2 = $composer.startRestartGroup(1297229208);
        ComposerKt.sourceInformation($composer2, "C(PressedInteractionSourceDisposableEffect)P(1,2)414@17663L504:Clickable.kt#71ulvw");
        int $dirty = $changed;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1297229208, $dirty, -1, "androidx.compose.foundation.PressedInteractionSourceDisposableEffect (Clickable.kt:409)");
        }
        EffectsKt.DisposableEffect((Object) interactionSource, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new ClickableKt$PressedInteractionSourceDisposableEffect$1(pressedInteraction, currentKeyPressInteractions, interactionSource), $composer2, $dirty & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ClickableKt$PressedInteractionSourceDisposableEffect$2(interactionSource, pressedInteraction, currentKeyPressInteractions, $changed));
        }
    }

    /* renamed from: handlePressInteraction-EPk0efs  reason: not valid java name */
    public static final Object m480handlePressInteractionEPk0efs(PressGestureScope $this$handlePressInteraction_u2dEPk0efs, long pressPoint, MutableInteractionSource interactionSource, MutableState<PressInteraction.Press> pressedInteraction, State<? extends Function0<Boolean>> delayPressInteraction, Continuation<? super Unit> $completion) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ClickableKt$handlePressInteraction$2($this$handlePressInteraction_u2dEPk0efs, pressPoint, interactionSource, pressedInteraction, delayPressInteraction, (Continuation<? super ClickableKt$handlePressInteraction$2>) null), $completion);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* renamed from: genericClickableWithoutGesture-bdNGguI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m479genericClickableWithoutGesturebdNGguI$default(Modifier modifier, Modifier modifier2, MutableInteractionSource mutableInteractionSource, Indication indication, CoroutineScope coroutineScope, Map map, State state, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, int i, Object obj) {
        String str3;
        Role role2;
        String str4;
        Function0 function03;
        int i2 = i;
        boolean z2 = (i2 & 64) != 0 ? true : z;
        if ((i2 & 128) != 0) {
            str3 = null;
        } else {
            str3 = str;
        }
        if ((i2 & 256) != 0) {
            role2 = null;
        } else {
            role2 = role;
        }
        if ((i2 & 512) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i2 & 1024) != 0) {
            function03 = null;
        } else {
            function03 = function0;
        }
        return m478genericClickableWithoutGesturebdNGguI(modifier, modifier2, mutableInteractionSource, indication, coroutineScope, map, state, z2, str3, role2, str4, function03, function02);
    }

    private static final Modifier genericClickableWithoutGesture_bdNGguI$clickSemantics(Modifier $this$genericClickableWithoutGesture_bdNGguI_u24clickSemantics, Role $role, String $onClickLabel, Function0<Unit> $onLongClick, String $onLongClickLabel, boolean $enabled, Function0<Unit> $onClick) {
        return SemanticsModifierKt.semantics($this$genericClickableWithoutGesture_bdNGguI_u24clickSemantics, true, new ClickableKt$genericClickableWithoutGesture$clickSemantics$1($role, $onClickLabel, $onLongClick, $onLongClickLabel, $enabled, $onClick));
    }

    private static final Modifier genericClickableWithoutGesture_bdNGguI$detectPressAndClickFromKey(Modifier $this$genericClickableWithoutGesture_bdNGguI_u24detectPressAndClickFromKey, boolean $enabled, Map<Key, PressInteraction.Press> $currentKeyPressInteractions, State<Offset> $keyClickOffset, CoroutineScope $indicationScope, Function0<Unit> $onClick, MutableInteractionSource $interactionSource) {
        return KeyInputModifierKt.onKeyEvent($this$genericClickableWithoutGesture_bdNGguI_u24detectPressAndClickFromKey, new ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1($enabled, $currentKeyPressInteractions, $keyClickOffset, $indicationScope, $onClick, $interactionSource));
    }

    /* renamed from: genericClickableWithoutGesture-bdNGguI  reason: not valid java name */
    public static final Modifier m478genericClickableWithoutGesturebdNGguI(Modifier $this$genericClickableWithoutGesture_u2dbdNGguI, Modifier gestureModifiers, MutableInteractionSource interactionSource, Indication indication, CoroutineScope indicationScope, Map<Key, PressInteraction.Press> currentKeyPressInteractions, State<Offset> keyClickOffset, boolean enabled, String onClickLabel, Role role, String onLongClickLabel, Function0<Unit> onLongClick, Function0<Unit> onClick) {
        Modifier modifier = gestureModifiers;
        MutableInteractionSource mutableInteractionSource = interactionSource;
        boolean z = enabled;
        Modifier modifier2 = $this$genericClickableWithoutGesture_u2dbdNGguI;
        Intrinsics.checkNotNullParameter($this$genericClickableWithoutGesture_u2dbdNGguI, "$this$genericClickableWithoutGesture");
        Intrinsics.checkNotNullParameter(modifier, "gestureModifiers");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(indicationScope, "indicationScope");
        Intrinsics.checkNotNullParameter(currentKeyPressInteractions, "currentKeyPressInteractions");
        Intrinsics.checkNotNullParameter(keyClickOffset, "keyClickOffset");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(genericClickableWithoutGesture_bdNGguI$detectPressAndClickFromKey(genericClickableWithoutGesture_bdNGguI$clickSemantics($this$genericClickableWithoutGesture_u2dbdNGguI, role, onClickLabel, onLongClick, onLongClickLabel, enabled, onClick), enabled, currentKeyPressInteractions, keyClickOffset, indicationScope, onClick, interactionSource), mutableInteractionSource, indication), mutableInteractionSource, z), z, mutableInteractionSource).then(modifier);
    }
}
