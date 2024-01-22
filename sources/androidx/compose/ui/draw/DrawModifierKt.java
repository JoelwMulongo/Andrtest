package androidx.compose.ui.draw;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u001a#\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0002\b\u0006\u001a#\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¨\u0006\r"}, d2 = {"drawBehind", "Landroidx/compose/ui/Modifier;", "onDraw", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "drawWithCache", "onBuildDrawCache", "Landroidx/compose/ui/draw/CacheDrawScope;", "Landroidx/compose/ui/draw/DrawResult;", "drawWithContent", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DrawModifier.kt */
public final class DrawModifierKt {
    public static final Modifier drawBehind(Modifier $this$drawBehind, Function1<? super DrawScope, Unit> onDraw) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "<this>");
        Intrinsics.checkNotNullParameter(onDraw, "onDraw");
        return $this$drawBehind.then(new DrawBehindElement(onDraw));
    }

    public static final Modifier drawWithCache(Modifier $this$drawWithCache, Function1<? super CacheDrawScope, DrawResult> onBuildDrawCache) {
        Intrinsics.checkNotNullParameter($this$drawWithCache, "<this>");
        Intrinsics.checkNotNullParameter(onBuildDrawCache, "onBuildDrawCache");
        return ComposedModifierKt.composed($this$drawWithCache, InspectableValueKt.isDebugInspectorInfoEnabled() ? new DrawModifierKt$drawWithCache$$inlined$debugInspectorInfo$1(onBuildDrawCache) : InspectableValueKt.getNoInspectorInfo(), new DrawModifierKt$drawWithCache$2(onBuildDrawCache));
    }

    public static final Modifier drawWithContent(Modifier $this$drawWithContent, Function1<? super ContentDrawScope, Unit> onDraw) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "<this>");
        Intrinsics.checkNotNullParameter(onDraw, "onDraw");
        return $this$drawWithContent.then(new DrawWithContentElement(onDraw));
    }
}
