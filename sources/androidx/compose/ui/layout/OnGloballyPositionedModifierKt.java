package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0007¨\u0006\u0005"}, d2 = {"onGloballyPositioned", "Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: OnGloballyPositionedModifier.kt */
public final class OnGloballyPositionedModifierKt {
    public static final Modifier onGloballyPositioned(Modifier $this$onGloballyPositioned, Function1<? super LayoutCoordinates, Unit> onGloballyPositioned) {
        Intrinsics.checkNotNullParameter($this$onGloballyPositioned, "<this>");
        Intrinsics.checkNotNullParameter(onGloballyPositioned, "onGloballyPositioned");
        return $this$onGloballyPositioned.then(new OnGloballyPositionedModifierImpl(onGloballyPositioned, InspectableValueKt.isDebugInspectorInfoEnabled() ? new OnGloballyPositionedModifierKt$onGloballyPositioned$$inlined$debugInspectorInfo$1(onGloballyPositioned) : InspectableValueKt.getNoInspectorInfo()));
    }
}
