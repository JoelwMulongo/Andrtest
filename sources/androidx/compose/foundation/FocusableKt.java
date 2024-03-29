package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusPropertiesKt;
import androidx.compose.ui.platform.InspectableModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0003H\u0007\u001a \u0010\u0004\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a\u001e\u0010\t\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"focusGroupInspectorInfo", "Landroidx/compose/ui/platform/InspectableModifier;", "focusGroup", "Landroidx/compose/ui/Modifier;", "focusable", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "focusableInNonTouchMode", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Focusable.kt */
public final class FocusableKt {
    private static final InspectableModifier focusGroupInspectorInfo = new InspectableModifier(InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusableKt$special$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo());

    public static /* synthetic */ Modifier focusable$default(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            mutableInteractionSource = null;
        }
        return focusable(modifier, z, mutableInteractionSource);
    }

    public static final Modifier focusable(Modifier $this$focusable, boolean enabled, MutableInteractionSource interactionSource) {
        Intrinsics.checkNotNullParameter($this$focusable, "<this>");
        return ComposedModifierKt.composed($this$focusable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusableKt$focusable$$inlined$debugInspectorInfo$1(enabled, interactionSource) : InspectableValueKt.getNoInspectorInfo(), new FocusableKt$focusable$2(interactionSource, enabled));
    }

    public static final Modifier focusGroup(Modifier $this$focusGroup) {
        Intrinsics.checkNotNullParameter($this$focusGroup, "<this>");
        return FocusModifierKt.focusTarget(FocusPropertiesKt.focusProperties($this$focusGroup.then(focusGroupInspectorInfo), FocusableKt$focusGroup$1.INSTANCE));
    }

    public static final Modifier focusableInNonTouchMode(Modifier $this$focusableInNonTouchMode, boolean enabled, MutableInteractionSource interactionSource) {
        Intrinsics.checkNotNullParameter($this$focusableInNonTouchMode, "<this>");
        return ComposedModifierKt.composed($this$focusableInNonTouchMode, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusableKt$focusableInNonTouchMode$$inlined$debugInspectorInfo$1(enabled, interactionSource) : InspectableValueKt.getNoInspectorInfo(), new FocusableKt$focusableInNonTouchMode$2(enabled, interactionSource));
    }
}
