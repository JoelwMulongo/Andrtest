package androidx.compose.foundation.layout;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0001\u001aC\u0010\r\u001a\u00020\u0001*\u00020\u00012\u0019\b\b\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u00122\u0019\b\u0004\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u000f¢\u0006\u0002\b\u0012H\b¨\u0006\u0016"}, d2 = {"captionBarPadding", "Landroidx/compose/ui/Modifier;", "displayCutoutPadding", "imePadding", "mandatorySystemGesturesPadding", "navigationBarsPadding", "safeContentPadding", "safeDrawingPadding", "safeGesturesPadding", "statusBarsPadding", "systemBarsPadding", "systemGesturesPadding", "waterfallPadding", "windowInsetsPadding", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "insetsCalculation", "Landroidx/compose/foundation/layout/WindowInsetsHolder;", "Landroidx/compose/foundation/layout/WindowInsets;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsetsPadding.android.kt */
public final class WindowInsetsPadding_androidKt {
    public static final Modifier safeDrawingPadding(Modifier $this$safeDrawingPadding) {
        Intrinsics.checkNotNullParameter($this$safeDrawingPadding, "<this>");
        return ComposedModifierKt.composed($this$safeDrawingPadding, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$safeDrawingPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$safeDrawingPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier safeGesturesPadding(Modifier $this$safeGesturesPadding) {
        Intrinsics.checkNotNullParameter($this$safeGesturesPadding, "<this>");
        return ComposedModifierKt.composed($this$safeGesturesPadding, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$safeGesturesPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$safeGesturesPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier safeContentPadding(Modifier $this$safeContentPadding) {
        Intrinsics.checkNotNullParameter($this$safeContentPadding, "<this>");
        return ComposedModifierKt.composed($this$safeContentPadding, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$safeContentPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$safeContentPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier systemBarsPadding(Modifier $this$systemBarsPadding) {
        Intrinsics.checkNotNullParameter($this$systemBarsPadding, "<this>");
        return ComposedModifierKt.composed($this$systemBarsPadding, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$systemBarsPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$systemBarsPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier displayCutoutPadding(Modifier $this$displayCutoutPadding) {
        Intrinsics.checkNotNullParameter($this$displayCutoutPadding, "<this>");
        return ComposedModifierKt.composed($this$displayCutoutPadding, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$displayCutoutPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$displayCutoutPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier statusBarsPadding(Modifier $this$statusBarsPadding) {
        Intrinsics.checkNotNullParameter($this$statusBarsPadding, "<this>");
        return ComposedModifierKt.composed($this$statusBarsPadding, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$statusBarsPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$statusBarsPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier imePadding(Modifier $this$imePadding) {
        Intrinsics.checkNotNullParameter($this$imePadding, "<this>");
        return ComposedModifierKt.composed($this$imePadding, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$imePadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$imePadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier navigationBarsPadding(Modifier $this$navigationBarsPadding) {
        Intrinsics.checkNotNullParameter($this$navigationBarsPadding, "<this>");
        return ComposedModifierKt.composed($this$navigationBarsPadding, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$navigationBarsPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$navigationBarsPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier captionBarPadding(Modifier $this$captionBarPadding) {
        Intrinsics.checkNotNullParameter($this$captionBarPadding, "<this>");
        return ComposedModifierKt.composed($this$captionBarPadding, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$captionBarPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$captionBarPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier waterfallPadding(Modifier $this$waterfallPadding) {
        Intrinsics.checkNotNullParameter($this$waterfallPadding, "<this>");
        return ComposedModifierKt.composed($this$waterfallPadding, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$waterfallPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$waterfallPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier systemGesturesPadding(Modifier $this$systemGesturesPadding) {
        Intrinsics.checkNotNullParameter($this$systemGesturesPadding, "<this>");
        return ComposedModifierKt.composed($this$systemGesturesPadding, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$systemGesturesPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$systemGesturesPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier mandatorySystemGesturesPadding(Modifier $this$mandatorySystemGesturesPadding) {
        Intrinsics.checkNotNullParameter($this$mandatorySystemGesturesPadding, "<this>");
        return ComposedModifierKt.composed($this$mandatorySystemGesturesPadding, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$mandatorySystemGesturesPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$mandatorySystemGesturesPadding$$inlined$windowInsetsPadding$1());
    }

    private static final Modifier windowInsetsPadding(Modifier $this$windowInsetsPadding, Function1<? super InspectorInfo, Unit> inspectorInfo, Function1<? super WindowInsetsHolder, ? extends WindowInsets> insetsCalculation) {
        return ComposedModifierKt.composed($this$windowInsetsPadding, inspectorInfo, new WindowInsetsPadding_androidKt$windowInsetsPadding$1(insetsCalculation));
    }
}
