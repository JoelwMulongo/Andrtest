package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0007\u001a\u0014\u0010\n\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0014\u0010\n\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0007\u001a/\u0010\u000b\u001a\u00020\u0006*\u00020\u00062!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00100\rH\u0007\u001a\u0014\u0010\u0011\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0007\u001a/\u0010\u0012\u001a\u00020\u0006*\u00020\u00062!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00100\rH\u0007\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0013"}, d2 = {"ModifierLocalConsumedWindowInsets", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/foundation/layout/WindowInsets;", "getModifierLocalConsumedWindowInsets", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "consumeWindowInsets", "Landroidx/compose/ui/Modifier;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "insets", "consumedWindowInsets", "onConsumedWindowInsetsChanged", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "windowInsetsPadding", "withConsumedWindowInsets", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsetsPadding.kt */
public final class WindowInsetsPaddingKt {
    private static final ProvidableModifierLocal<WindowInsets> ModifierLocalConsumedWindowInsets = ModifierLocalKt.modifierLocalOf(WindowInsetsPaddingKt$ModifierLocalConsumedWindowInsets$1.INSTANCE);

    public static final Modifier windowInsetsPadding(Modifier $this$windowInsetsPadding, WindowInsets insets) {
        Intrinsics.checkNotNullParameter($this$windowInsetsPadding, "<this>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        return $this$windowInsetsPadding.then(new InsetsPaddingModifier(insets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$windowInsetsPadding$$inlined$debugInspectorInfo$1(insets) : InspectableValueKt.getNoInspectorInfo()));
    }

    public static final Modifier consumeWindowInsets(Modifier $this$consumeWindowInsets, WindowInsets insets) {
        Intrinsics.checkNotNullParameter($this$consumeWindowInsets, "<this>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        return $this$consumeWindowInsets.then(new UnionInsetsConsumingModifier(insets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$consumeWindowInsets$$inlined$debugInspectorInfo$1(insets) : InspectableValueKt.getNoInspectorInfo()));
    }

    @Deprecated(message = "Use consumeWindowInsets", replaceWith = @ReplaceWith(expression = "this.consumeWindowInsets(insets)", imports = {}))
    public static final Modifier consumedWindowInsets(Modifier $this$consumedWindowInsets, WindowInsets insets) {
        Intrinsics.checkNotNullParameter($this$consumedWindowInsets, "<this>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        return consumeWindowInsets($this$consumedWindowInsets, insets);
    }

    public static final Modifier consumeWindowInsets(Modifier $this$consumeWindowInsets, PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter($this$consumeWindowInsets, "<this>");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return $this$consumeWindowInsets.then(new PaddingValuesConsumingModifier(paddingValues, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$consumeWindowInsets$$inlined$debugInspectorInfo$2(paddingValues) : InspectableValueKt.getNoInspectorInfo()));
    }

    @Deprecated(message = "Use consumeWindowInsets", replaceWith = @ReplaceWith(expression = "this.consumeWindowInsets(paddingValues)", imports = {}))
    public static final Modifier consumedWindowInsets(Modifier $this$consumedWindowInsets, PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter($this$consumedWindowInsets, "<this>");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return consumeWindowInsets($this$consumedWindowInsets, paddingValues);
    }

    public static final Modifier onConsumedWindowInsetsChanged(Modifier $this$onConsumedWindowInsetsChanged, Function1<? super WindowInsets, Unit> block) {
        Intrinsics.checkNotNullParameter($this$onConsumedWindowInsetsChanged, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return $this$onConsumedWindowInsetsChanged.then(new ConsumedInsetsModifier(block, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$onConsumedWindowInsetsChanged$$inlined$debugInspectorInfo$1(block) : InspectableValueKt.getNoInspectorInfo()));
    }

    @Deprecated(message = "Use onConsumedWindowInsetsChanged", replaceWith = @ReplaceWith(expression = "onConsumedWindowInsetsChanged(block)", imports = {}))
    public static final Modifier withConsumedWindowInsets(Modifier $this$withConsumedWindowInsets, Function1<? super WindowInsets, Unit> block) {
        Intrinsics.checkNotNullParameter($this$withConsumedWindowInsets, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return onConsumedWindowInsetsChanged($this$withConsumedWindowInsets, block);
    }

    public static final ProvidableModifierLocal<WindowInsets> getModifierLocalConsumedWindowInsets() {
        return ModifierLocalConsumedWindowInsets;
    }
}
