package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aY\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u000e\u001aG\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u000f\u001aS\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0015\u001aA\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"toggleable", "Landroidx/compose/ui/Modifier;", "value", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onValueChange", "Lkotlin/Function1;", "", "toggleable-O2vRcR0", "toggleable-XHw0xAI", "triStateToggleable", "state", "Landroidx/compose/ui/state/ToggleableState;", "onClick", "Lkotlin/Function0;", "triStateToggleable-O2vRcR0", "triStateToggleable-XHw0xAI", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Toggleable.kt */
public final class ToggleableKt {
    /* renamed from: toggleable-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1086toggleableXHw0xAI$default(Modifier modifier, boolean z, boolean z2, Role role, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m1085toggleableXHw0xAI(modifier, z, z2, role, function1);
    }

    /* renamed from: toggleable-XHw0xAI  reason: not valid java name */
    public static final Modifier m1085toggleableXHw0xAI(Modifier $this$toggleable_u2dXHw0xAI, boolean value, boolean enabled, Role role, Function1<? super Boolean, Unit> onValueChange) {
        Intrinsics.checkNotNullParameter($this$toggleable_u2dXHw0xAI, "$this$toggleable");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        return ComposedModifierKt.composed($this$toggleable_u2dXHw0xAI, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$toggleableXHw0xAI$$inlined$debugInspectorInfo$1(value, enabled, role, onValueChange) : InspectableValueKt.getNoInspectorInfo(), new ToggleableKt$toggleable$2(value, enabled, role, onValueChange));
    }

    /* renamed from: toggleable-O2vRcR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1084toggleableO2vRcR0$default(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Role role, Function1 function1, int i, Object obj) {
        boolean z3;
        if ((i & 8) != 0) {
            z3 = true;
        } else {
            z3 = z2;
        }
        return m1083toggleableO2vRcR0(modifier, z, mutableInteractionSource, indication, z3, (i & 16) != 0 ? null : role, function1);
    }

    /* renamed from: toggleable-O2vRcR0  reason: not valid java name */
    public static final Modifier m1083toggleableO2vRcR0(Modifier $this$toggleable_u2dO2vRcR0, boolean value, MutableInteractionSource interactionSource, Indication indication, boolean enabled, Role role, Function1<? super Boolean, Unit> onValueChange) {
        Function1<? super Boolean, Unit> function1 = onValueChange;
        Intrinsics.checkNotNullParameter($this$toggleable_u2dO2vRcR0, "$this$toggleable");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$toggleableO2vRcR0$$inlined$debugInspectorInfo$1(value, interactionSource, indication, enabled, role, onValueChange) : InspectableValueKt.getNoInspectorInfo();
        Modifier $this$inspectable$iv = $this$toggleable_u2dO2vRcR0;
        Modifier modifier = Modifier.Companion;
        return InspectableValueKt.inspectableWrapper($this$inspectable$iv, inspectorInfo$iv, m1087triStateToggleableO2vRcR0(Modifier.Companion, ToggleableStateKt.ToggleableState(value), interactionSource, indication, enabled, role, new ToggleableKt$toggleable$4$1(function1, value)));
    }

    /* renamed from: triStateToggleable-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1090triStateToggleableXHw0xAI$default(Modifier modifier, ToggleableState toggleableState, boolean z, Role role, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m1089triStateToggleableXHw0xAI(modifier, toggleableState, z, role, function0);
    }

    /* renamed from: triStateToggleable-XHw0xAI  reason: not valid java name */
    public static final Modifier m1089triStateToggleableXHw0xAI(Modifier $this$triStateToggleable_u2dXHw0xAI, ToggleableState state, boolean enabled, Role role, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter($this$triStateToggleable_u2dXHw0xAI, "$this$triStateToggleable");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.composed($this$triStateToggleable_u2dXHw0xAI, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$triStateToggleableXHw0xAI$$inlined$debugInspectorInfo$1(state, enabled, role, onClick) : InspectableValueKt.getNoInspectorInfo(), new ToggleableKt$triStateToggleable$2(state, enabled, role, onClick));
    }

    /* renamed from: triStateToggleable-O2vRcR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1088triStateToggleableO2vRcR0$default(Modifier modifier, ToggleableState toggleableState, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, Role role, Function0 function0, int i, Object obj) {
        boolean z2;
        if ((i & 8) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        return m1087triStateToggleableO2vRcR0(modifier, toggleableState, mutableInteractionSource, indication, z2, (i & 16) != 0 ? null : role, function0);
    }

    /* renamed from: triStateToggleable-O2vRcR0  reason: not valid java name */
    public static final Modifier m1087triStateToggleableO2vRcR0(Modifier $this$triStateToggleable_u2dO2vRcR0, ToggleableState state, MutableInteractionSource interactionSource, Indication indication, boolean enabled, Role role, Function0<Unit> onClick) {
        ToggleableState toggleableState = state;
        Intrinsics.checkNotNullParameter($this$triStateToggleable_u2dO2vRcR0, "$this$triStateToggleable");
        Intrinsics.checkNotNullParameter(toggleableState, "state");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return InspectableValueKt.inspectableWrapper($this$triStateToggleable_u2dO2vRcR0, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$triStateToggleableO2vRcR0$$inlined$debugInspectorInfo$1(state, enabled, role, interactionSource, indication, onClick) : InspectableValueKt.getNoInspectorInfo(), SemanticsModifierKt.semantics$default(ClickableKt.m471clickableO2vRcR0$default(Modifier.Companion, interactionSource, indication, enabled, (String) null, role, onClick, 8, (Object) null), false, new ToggleableKt$triStateToggleable$4$1(toggleableState), 1, (Object) null));
    }
}
