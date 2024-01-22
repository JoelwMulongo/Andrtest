package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u001a-\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¨\u0006\n"}, d2 = {"clearAndSetSemantics", "Landroidx/compose/ui/Modifier;", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "Lkotlin/ExtensionFunctionType;", "semantics", "mergeDescendants", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SemanticsModifier.kt */
public final class SemanticsModifierKt {
    public static /* synthetic */ Modifier semantics$default(Modifier modifier, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return semantics(modifier, z, function1);
    }

    public static final Modifier semantics(Modifier $this$semantics, boolean mergeDescendants, Function1<? super SemanticsPropertyReceiver, Unit> properties) {
        Intrinsics.checkNotNullParameter($this$semantics, "<this>");
        Intrinsics.checkNotNullParameter(properties, "properties");
        return $this$semantics.then(new SemanticsModifierCore(mergeDescendants, false, properties, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SemanticsModifierKt$semantics$$inlined$debugInspectorInfo$1(mergeDescendants, properties) : InspectableValueKt.getNoInspectorInfo()));
    }

    public static final Modifier clearAndSetSemantics(Modifier $this$clearAndSetSemantics, Function1<? super SemanticsPropertyReceiver, Unit> properties) {
        Intrinsics.checkNotNullParameter($this$clearAndSetSemantics, "<this>");
        Intrinsics.checkNotNullParameter(properties, "properties");
        return $this$clearAndSetSemantics.then(new SemanticsModifierCore(false, true, properties, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SemanticsModifierKt$clearAndSetSemantics$$inlined$debugInspectorInfo$1(properties) : InspectableValueKt.getNoInspectorInfo()));
    }
}
