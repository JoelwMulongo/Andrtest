package androidx.compose.foundation.text;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u001a>\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2'\u0010\u000e\u001a#\u0012\u001f\u0012\u001d\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t0\u0003j\u0002`\n0\u0002H\u0001¢\u0006\u0002\u0010\u000f\u001aa\u0010\u0010\u001a?\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t0\u0003j\u0002`\n0\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u0012H\u0000\u001ay\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&\u001ae\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(\"K\u0010\u0000\u001a?\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t0\u0003j\u0002`\n0\u00020\u0001X\u0004¢\u0006\u0002\n\u0000*:\b\u0002\u0010)\"\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t0\u00032\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t0\u0003*\u0018\b\u0002\u0010*\"\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u00020\u00040\u0003\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006+"}, d2 = {"EmptyInlineContent", "Lkotlin/Pair;", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "Landroidx/compose/foundation/text/PlaceholderRange;", "Lkotlin/Function1;", "", "", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/foundation/text/InlineContentRange;", "InlineChildren", "text", "Landroidx/compose/ui/text/AnnotatedString;", "inlineContents", "(Landroidx/compose/ui/text/AnnotatedString;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "resolveInlineContent", "inlineContent", "", "Landroidx/compose/foundation/text/InlineTextContent;", "updateTextDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "current", "style", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "", "minLines", "placeholders", "updateTextDelegate-rm0N8CA", "(Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;ZIIILjava/util/List;)Landroidx/compose/foundation/text/TextDelegate;", "updateTextDelegate-x_uQXYA", "(Landroidx/compose/foundation/text/TextDelegate;Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;ZIII)Landroidx/compose/foundation/text/TextDelegate;", "InlineContentRange", "PlaceholderRange", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreText.kt */
public final class CoreTextKt {
    private static final Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> EmptyInlineContent = new Pair<>(CollectionsKt.emptyList(), CollectionsKt.emptyList());

    public static final void InlineChildren(AnnotatedString text, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> inlineContents, Composer $composer, int $changed) {
        AnnotatedString annotatedString = text;
        List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> list = inlineContents;
        int i = $changed;
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Intrinsics.checkNotNullParameter(list, "inlineContents");
        Composer $composer2 = $composer.startRestartGroup(-110905764);
        ComposerKt.sourceInformation($composer2, "C(InlineChildren)P(1)*81@3639L356:CoreText.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-110905764, i, -1, "androidx.compose.foundation.text.InlineChildren (CoreText.kt:76)");
        }
        List $this$fastForEach$iv = inlineContents;
        int $i$f$fastForEach = false;
        int index$iv = 0;
        int size = $this$fastForEach$iv.size();
        while (index$iv < size) {
            AnnotatedString.Range<Function3<String, Composer, Integer, Unit>> range = $this$fastForEach$iv.get(index$iv);
            AnnotatedString.Range range2 = range;
            Function3 content = (Function3) range2.component1();
            int start = range2.component2();
            int end = range2.component3();
            MeasurePolicy measurePolicy$iv = CoreTextKt$InlineChildren$1$2.INSTANCE;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.Companion;
            List $this$fastForEach$iv2 = $this$fastForEach$iv;
            int $i$f$fastForEach2 = $i$f$fastForEach;
            int i2 = size;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv = (Density) consume;
            AnnotatedString.Range<Function3<String, Composer, Integer, Unit>> range3 = range;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m2787constructorimpl($composer2);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i3 = ($changed$iv$iv >> 9) & 14;
            Composer $composer3 = $composer2;
            Density density = density$iv;
            LayoutDirection layoutDirection = layoutDirection$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, -1487999110, "C82@3671L42:CoreText.kt#423gt5");
            content.invoke(annotatedString.subSequence(start, end).getText(), $composer3, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            index$iv++;
            $this$fastForEach$iv = $this$fastForEach$iv2;
            $i$f$fastForEach = $i$f$fastForEach2;
            size = i2;
        }
        int i4 = $i$f$fastForEach;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CoreTextKt$InlineChildren$2(annotatedString, list, i));
        }
    }

    /* renamed from: updateTextDelegate-rm0N8CA$default  reason: not valid java name */
    public static /* synthetic */ TextDelegate m1142updateTextDelegaterm0N8CA$default(TextDelegate textDelegate, AnnotatedString annotatedString, TextStyle textStyle, Density density, FontFamily.Resolver resolver, boolean z, int i, int i2, int i3, List list, int i4, Object obj) {
        boolean z2;
        int i5;
        int i6 = i4;
        if ((i6 & 32) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        int r9 = (i6 & 64) != 0 ? TextOverflow.Companion.m5898getClipgIe3tQ8() : i;
        int i7 = (i6 & 128) != 0 ? Integer.MAX_VALUE : i2;
        if ((i6 & 256) != 0) {
            i5 = 1;
        } else {
            i5 = i3;
        }
        return m1141updateTextDelegaterm0N8CA(textDelegate, annotatedString, textStyle, density, resolver, z2, r9, i7, i5, list);
    }

    /* renamed from: updateTextDelegate-rm0N8CA  reason: not valid java name */
    public static final TextDelegate m1141updateTextDelegaterm0N8CA(TextDelegate current, AnnotatedString text, TextStyle style, Density density, FontFamily.Resolver fontFamilyResolver, boolean softWrap, int overflow, int maxLines, int minLines, List<AnnotatedString.Range<Placeholder>> placeholders) {
        AnnotatedString annotatedString = text;
        TextStyle textStyle = style;
        Density density2 = density;
        FontFamily.Resolver resolver = fontFamilyResolver;
        List<AnnotatedString.Range<Placeholder>> list = placeholders;
        TextDelegate textDelegate = current;
        Intrinsics.checkNotNullParameter(textDelegate, "current");
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(density2, "density");
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(list, "placeholders");
        if (!Intrinsics.areEqual((Object) current.getText(), (Object) annotatedString)) {
            boolean z = softWrap;
            int i = overflow;
            int i2 = maxLines;
            int i3 = minLines;
        } else if (!Intrinsics.areEqual((Object) current.getStyle(), (Object) textStyle)) {
            boolean z2 = softWrap;
            int i4 = overflow;
            int i5 = maxLines;
            int i6 = minLines;
        } else if (current.getSoftWrap() != softWrap) {
            int i7 = overflow;
            int i8 = maxLines;
            int i9 = minLines;
        } else if (!TextOverflow.m5891equalsimpl0(current.m1200getOverflowgIe3tQ8(), overflow)) {
            int i10 = maxLines;
            int i11 = minLines;
        } else if (current.getMaxLines() != maxLines) {
            int i12 = minLines;
        } else if (current.getMinLines() == minLines && Intrinsics.areEqual((Object) current.getDensity(), (Object) density2) && Intrinsics.areEqual((Object) current.getPlaceholders(), (Object) list) && current.getFontFamilyResolver() == resolver) {
            return textDelegate;
        }
        return new TextDelegate(text, style, maxLines, minLines, softWrap, overflow, density, fontFamilyResolver, placeholders, (DefaultConstructorMarker) null);
    }

    /* renamed from: updateTextDelegate-x_uQXYA$default  reason: not valid java name */
    public static /* synthetic */ TextDelegate m1144updateTextDelegatex_uQXYA$default(TextDelegate textDelegate, String str, TextStyle textStyle, Density density, FontFamily.Resolver resolver, boolean z, int i, int i2, int i3, int i4, Object obj) {
        boolean z2;
        int i5;
        int i6 = i4;
        if ((i6 & 32) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        int r9 = (i6 & 64) != 0 ? TextOverflow.Companion.m5898getClipgIe3tQ8() : i;
        int i7 = (i6 & 128) != 0 ? Integer.MAX_VALUE : i2;
        if ((i6 & 256) != 0) {
            i5 = 1;
        } else {
            i5 = i3;
        }
        return m1143updateTextDelegatex_uQXYA(textDelegate, str, textStyle, density, resolver, z2, r9, i7, i5);
    }

    /* renamed from: updateTextDelegate-x_uQXYA  reason: not valid java name */
    public static final TextDelegate m1143updateTextDelegatex_uQXYA(TextDelegate current, String text, TextStyle style, Density density, FontFamily.Resolver fontFamilyResolver, boolean softWrap, int overflow, int maxLines, int minLines) {
        String str = text;
        TextStyle textStyle = style;
        Density density2 = density;
        FontFamily.Resolver resolver = fontFamilyResolver;
        TextDelegate textDelegate = current;
        Intrinsics.checkNotNullParameter(textDelegate, "current");
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(density2, "density");
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        if (!Intrinsics.areEqual((Object) current.getText().getText(), (Object) str)) {
            boolean z = softWrap;
            int i = overflow;
            int i2 = maxLines;
            int i3 = minLines;
        } else if (!Intrinsics.areEqual((Object) current.getStyle(), (Object) textStyle)) {
            boolean z2 = softWrap;
            int i4 = overflow;
            int i5 = maxLines;
            int i6 = minLines;
        } else if (current.getSoftWrap() != softWrap) {
            int i7 = overflow;
            int i8 = maxLines;
            int i9 = minLines;
        } else if (!TextOverflow.m5891equalsimpl0(current.m1200getOverflowgIe3tQ8(), overflow)) {
            int i10 = maxLines;
            int i11 = minLines;
        } else if (current.getMaxLines() != maxLines) {
            int i12 = minLines;
        } else if (current.getMinLines() == minLines && Intrinsics.areEqual((Object) current.getDensity(), (Object) density2) && current.getFontFamilyResolver() == resolver) {
            return textDelegate;
        }
        return new TextDelegate(new AnnotatedString(text, (List) null, (List) null, 6, (DefaultConstructorMarker) null), style, maxLines, minLines, softWrap, overflow, density, fontFamilyResolver, (List) null, 256, (DefaultConstructorMarker) null);
    }

    public static final Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> resolveInlineContent(AnnotatedString text, Map<String, InlineTextContent> inlineContent) {
        AnnotatedString annotatedString = text;
        Map<String, InlineTextContent> map = inlineContent;
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Intrinsics.checkNotNullParameter(map, "inlineContent");
        if (inlineContent.isEmpty()) {
            return EmptyInlineContent;
        }
        List stringAnnotations = annotatedString.getStringAnnotations(InlineTextContentKt.INLINE_CONTENT_TAG, 0, text.length());
        List placeholders = new ArrayList();
        List inlineComposables = new ArrayList();
        List $this$fastForEach$iv = stringAnnotations;
        int index$iv = 0;
        int size = $this$fastForEach$iv.size();
        while (index$iv < size) {
            AnnotatedString.Range annotation = $this$fastForEach$iv.get(index$iv);
            InlineTextContent inlineTextContent = map.get(annotation.getItem());
            if (inlineTextContent != null) {
                placeholders.add(new AnnotatedString.Range(inlineTextContent.getPlaceholder(), annotation.getStart(), annotation.getEnd()));
                inlineComposables.add(new AnnotatedString.Range(inlineTextContent.getChildren(), annotation.getStart(), annotation.getEnd()));
            }
            index$iv++;
            AnnotatedString annotatedString2 = text;
            map = inlineContent;
        }
        return new Pair<>(placeholders, inlineComposables);
    }
}
