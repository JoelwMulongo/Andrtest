package androidx.compose.foundation.selection;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, d2 = {"selectableGroup", "Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectableGroup.kt */
public final class SelectableGroupKt {
    public static final Modifier selectableGroup(Modifier $this$selectableGroup) {
        Intrinsics.checkNotNullParameter($this$selectableGroup, "<this>");
        return SemanticsModifierKt.semantics$default($this$selectableGroup, false, SelectableGroupKt$selectableGroup$1.INSTANCE, 1, (Object) null);
    }
}
