package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aS\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u000e\u001aA\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u000f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"selectable", "Landroidx/compose/ui/Modifier;", "selected", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "selectable-O2vRcR0", "selectable-XHw0xAI", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Selectable.kt */
public final class SelectableKt {
    /* renamed from: selectable-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1082selectableXHw0xAI$default(Modifier modifier, boolean z, boolean z2, Role role, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m1081selectableXHw0xAI(modifier, z, z2, role, function0);
    }

    /* renamed from: selectable-XHw0xAI  reason: not valid java name */
    public static final Modifier m1081selectableXHw0xAI(Modifier $this$selectable_u2dXHw0xAI, boolean selected, boolean enabled, Role role, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter($this$selectable_u2dXHw0xAI, "$this$selectable");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.composed($this$selectable_u2dXHw0xAI, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SelectableKt$selectableXHw0xAI$$inlined$debugInspectorInfo$1(selected, enabled, role, onClick) : InspectableValueKt.getNoInspectorInfo(), new SelectableKt$selectable$2(selected, enabled, role, onClick));
    }

    /* renamed from: selectable-O2vRcR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1080selectableO2vRcR0$default(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Role role, Function0 function0, int i, Object obj) {
        boolean z3;
        if ((i & 8) != 0) {
            z3 = true;
        } else {
            z3 = z2;
        }
        return m1079selectableO2vRcR0(modifier, z, mutableInteractionSource, indication, z3, (i & 16) != 0 ? null : role, function0);
    }

    /* renamed from: selectable-O2vRcR0  reason: not valid java name */
    public static final Modifier m1079selectableO2vRcR0(Modifier $this$selectable_u2dO2vRcR0, boolean selected, MutableInteractionSource interactionSource, Indication indication, boolean enabled, Role role, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter($this$selectable_u2dO2vRcR0, "$this$selectable");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new SelectableKt$selectableO2vRcR0$$inlined$debugInspectorInfo$1(selected, interactionSource, indication, enabled, role, onClick) : InspectableValueKt.getNoInspectorInfo();
        Modifier $this$inspectable$iv = $this$selectable_u2dO2vRcR0;
        Modifier modifier = Modifier.Companion;
        return InspectableValueKt.inspectableWrapper($this$inspectable$iv, inspectorInfo$iv, SemanticsModifierKt.semantics$default(ClickableKt.m471clickableO2vRcR0$default(Modifier.Companion, interactionSource, indication, enabled, (String) null, role, onClick, 8, (Object) null), false, new SelectableKt$selectable$4$1(selected), 1, (Object) null));
    }
}
