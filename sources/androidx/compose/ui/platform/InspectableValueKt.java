package androidx.compose.ui.platform;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a8\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\u0019\b\u0004\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\bø\u0001\u0000\u001aD\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\u0019\b\b\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0001¢\u0006\u0002\b\u0004H\bø\u0001\u0000\u001a-\u0010\u0012\u001a\u00020\u000f*\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\u0006\u0010\u0013\u001a\u00020\u000fH\u0001\"\"\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0014"}, d2 = {"NoInspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "getNoInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "isDebugInspectorInfoEnabled", "", "()Z", "setDebugInspectorInfoEnabled", "(Z)V", "debugInspectorInfo", "definitions", "inspectable", "Landroidx/compose/ui/Modifier;", "inspectorInfo", "factory", "inspectableWrapper", "wrapped", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: InspectableValue.kt */
public final class InspectableValueKt {
    private static final Function1<InspectorInfo, Unit> NoInspectorInfo = InspectableValueKt$NoInspectorInfo$1.INSTANCE;
    private static boolean isDebugInspectorInfoEnabled;

    public static final Function1<InspectorInfo, Unit> getNoInspectorInfo() {
        return NoInspectorInfo;
    }

    public static final boolean isDebugInspectorInfoEnabled() {
        return isDebugInspectorInfoEnabled;
    }

    public static final void setDebugInspectorInfoEnabled(boolean z) {
        isDebugInspectorInfoEnabled = z;
    }

    public static final Function1<InspectorInfo, Unit> debugInspectorInfo(Function1<? super InspectorInfo, Unit> definitions) {
        Intrinsics.checkNotNullParameter(definitions, "definitions");
        return isDebugInspectorInfoEnabled() ? new InspectableValueKt$debugInspectorInfo$1(definitions) : getNoInspectorInfo();
    }

    public static final Modifier inspectable(Modifier $this$inspectable, Function1<? super InspectorInfo, Unit> inspectorInfo, Function1<? super Modifier, ? extends Modifier> factory) {
        Intrinsics.checkNotNullParameter($this$inspectable, "<this>");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        Intrinsics.checkNotNullParameter(factory, "factory");
        return inspectableWrapper($this$inspectable, inspectorInfo, (Modifier) factory.invoke(Modifier.Companion));
    }

    public static final Modifier inspectableWrapper(Modifier $this$inspectableWrapper, Function1<? super InspectorInfo, Unit> inspectorInfo, Modifier wrapped) {
        Intrinsics.checkNotNullParameter($this$inspectableWrapper, "<this>");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        Intrinsics.checkNotNullParameter(wrapped, "wrapped");
        InspectableModifier begin = new InspectableModifier(inspectorInfo);
        return $this$inspectableWrapper.then(begin).then(wrapped).then(begin.getEnd());
    }
}
