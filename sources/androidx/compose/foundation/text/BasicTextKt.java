package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a{\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001ae\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001ao\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u001c\u001a\u001e\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\""}, d2 = {"BasicText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "BasicText-VhcvRP8", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "BasicText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "BasicText-BpD7jsM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILandroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/runtime/Composer;II)V", "selectionIdSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicText.kt */
public final class BasicTextKt {
    /* renamed from: BasicText-4YKlhWE  reason: not valid java name */
    public static final void m1123BasicText4YKlhWE(String text, Modifier modifier, TextStyle style, Function1<? super TextLayoutResult, Unit> onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, Composer $composer, int $changed, int i) {
        TextStyle textStyle;
        Function1<? super TextLayoutResult, Unit> function1;
        int overflow2;
        boolean softWrap2;
        Modifier modifier2;
        TextStyle style2;
        int minLines2;
        int maxLines2;
        int overflow3;
        Function1<? super TextLayoutResult, Unit> function12;
        Modifier modifier3;
        int minLines3;
        long j;
        SelectionRegistrar selectionRegistrar;
        int overflow4;
        boolean softWrap3;
        TextController controller;
        TextState state;
        SelectionRegistrar selectionRegistrar2;
        String str;
        Function1<? super TextLayoutResult, Unit> function13;
        int i2;
        String str2 = text;
        int i3 = $changed;
        int i4 = i;
        Intrinsics.checkNotNullParameter(str2, "text");
        Composer $composer2 = $composer.startRestartGroup(1542716361);
        ComposerKt.sourceInformation($composer2, "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5)80@4041L7,81@4080L7,82@4141L7,102@5126L514,141@6375L96:BasicText.kt#423gt5");
        int $dirty = $changed;
        if ((i4 & 1) != 0) {
            $dirty |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer2.changed((Object) str2) ? 4 : 2;
        }
        int i5 = i4 & 2;
        if (i5 != 0) {
            $dirty |= 48;
            Modifier modifier4 = modifier;
        } else if ((i3 & 112) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier5 = modifier;
        }
        int i6 = i4 & 4;
        if (i6 != 0) {
            $dirty |= 384;
            textStyle = style;
        } else if ((i3 & 896) == 0) {
            textStyle = style;
            $dirty |= $composer2.changed((Object) textStyle) ? 256 : 128;
        } else {
            textStyle = style;
        }
        int i7 = i4 & 8;
        if (i7 != 0) {
            $dirty |= 3072;
            function1 = onTextLayout;
        } else if ((i3 & 7168) == 0) {
            function1 = onTextLayout;
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        } else {
            function1 = onTextLayout;
        }
        int i8 = i4 & 16;
        if (i8 != 0) {
            $dirty |= 24576;
            overflow2 = overflow;
        } else if ((57344 & i3) == 0) {
            overflow2 = overflow;
            $dirty |= $composer2.changed(overflow2) ? 16384 : 8192;
        } else {
            overflow2 = overflow;
        }
        int i9 = i4 & 32;
        if (i9 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            softWrap2 = softWrap;
        } else if ((458752 & i3) == 0) {
            softWrap2 = softWrap;
            $dirty |= $composer2.changed(softWrap2) ? 131072 : 65536;
        } else {
            softWrap2 = softWrap;
        }
        int i10 = i4 & 64;
        if (i10 != 0) {
            $dirty |= 1572864;
            int i11 = maxLines;
        } else if ((i3 & 3670016) == 0) {
            $dirty |= $composer2.changed(maxLines) ? 1048576 : 524288;
        } else {
            int i12 = maxLines;
        }
        int i13 = i4 & 128;
        if (i13 != 0) {
            $dirty |= 12582912;
            int i14 = minLines;
        } else if ((i3 & 29360128) == 0) {
            $dirty |= $composer2.changed(minLines) ? 8388608 : 4194304;
        } else {
            int i15 = minLines;
        }
        if (($dirty & 23967451) != 4793490 || !$composer2.getSkipping()) {
            if (i5 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (i6 != 0) {
                style2 = TextStyle.Companion.getDefault();
            } else {
                style2 = textStyle;
            }
            if (i7 != 0) {
                function1 = BasicTextKt$BasicText$1.INSTANCE;
            }
            if (i8 != 0) {
                overflow2 = TextOverflow.Companion.m5898getClipgIe3tQ8();
            }
            if (i9 != 0) {
                softWrap2 = true;
            }
            if (i10 != 0) {
                maxLines2 = Integer.MAX_VALUE;
            } else {
                maxLines2 = maxLines;
            }
            if (i13 != 0) {
                minLines3 = 1;
            } else {
                minLines3 = minLines;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1542716361, i3, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:60)");
            }
            HeightInLinesModifierKt.validateMinMaxLines(minLines3, maxLines2);
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(SelectionRegistrarKt.getLocalSelectionRegistrar());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SelectionRegistrar selectionRegistrar3 = (SelectionRegistrar) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            FontFamily.Resolver fontFamilyResolver = (FontFamily.Resolver) consume3;
            $composer2.startReplaceableGroup(959238681);
            ComposerKt.sourceInformation($composer2, "97@4947L150");
            if (selectionRegistrar3 == null) {
                j = 0;
            } else {
                j = ((Number) RememberSaveableKt.rememberSaveable(new Object[]{str2, selectionRegistrar3}, selectionIdSaver(selectionRegistrar3), (String) null, new BasicTextKt$BasicText$selectableId$1(selectionRegistrar3), $composer2, 72, 4)).longValue();
            }
            $composer2.endReplaceableGroup();
            long selectableId = j;
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
            Modifier modifier6 = modifier3;
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                Object obj = value$iv$iv;
                selectionRegistrar = selectionRegistrar3;
                value$iv$iv = new TextController(new TextState(new TextDelegate(new AnnotatedString(text, (List) null, (List) null, 6, (DefaultConstructorMarker) null), style2, maxLines2, minLines3, softWrap2, overflow2, density, fontFamilyResolver, (List) null, 256, (DefaultConstructorMarker) null), selectableId));
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                Object it$iv$iv = value$iv$iv;
                selectionRegistrar = selectionRegistrar3;
                Composer composer = $this$cache$iv$iv;
            }
            $composer2.endReplaceableGroup();
            TextController controller2 = (TextController) value$iv$iv;
            TextState state2 = controller2.getState();
            if (!$composer2.getInserting()) {
                long j2 = selectableId;
                Modifier modifier7 = modifier6;
                selectionRegistrar2 = selectionRegistrar;
                state = state2;
                str = "CC:CompositionLocal.kt#9igjgp";
                boolean z = softWrap2;
                softWrap3 = softWrap2;
                controller = controller2;
                int i16 = overflow2;
                overflow4 = overflow2;
                function13 = function1;
                minLines2 = minLines3;
                controller.setTextDelegate(CoreTextKt.m1143updateTextDelegatex_uQXYA(state2.getTextDelegate(), text, style2, density, fontFamilyResolver, z, i16, maxLines2, minLines3));
            } else {
                selectionRegistrar2 = selectionRegistrar;
                long j3 = selectableId;
                state = state2;
                str = "CC:CompositionLocal.kt#9igjgp";
                minLines2 = minLines3;
                overflow4 = overflow2;
                softWrap3 = softWrap2;
                controller = controller2;
                function13 = function1;
            }
            state.setOnTextLayout(function13);
            controller.update(selectionRegistrar2);
            $composer2.startReplaceableGroup(959240076);
            ComposerKt.sourceInformation($composer2, "138@6340L7");
            if (selectionRegistrar2 != null) {
                i2 = 2023513938;
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str);
                Object consume4 = $composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
                ComposerKt.sourceInformationMarkerEnd($composer2);
                state.m1239setSelectionBackgroundColor8_81llA(((TextSelectionColors) consume4).m1357getBackgroundColor0d7_KjU());
            } else {
                i2 = 2023513938;
            }
            $composer2.endReplaceableGroup();
            Modifier modifier8 = modifier6;
            Modifier modifier$iv = modifier8.then(controller.getModifiers());
            MeasurePolicy measurePolicy$iv = controller.getMeasurePolicy();
            $composer2.startReplaceableGroup(544976794);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(1)119@4537L7,120@4592L7,121@4651L7,123@4724L439:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer2, i2, str);
            Object consume5 = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv = (Density) consume5;
            ComposerKt.sourceInformationMarkerStart($composer2, i2, str);
            Object consume6 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume6;
            ComposerKt.sourceInformationMarkerStart($composer2, i2, str);
            Object consume7 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume7;
            Modifier materialized$iv = ComposedModifierKt.materialize($composer2, modifier$iv);
            Function0 factory$iv$iv = ComposeUiNode.Companion.getConstructor();
            Modifier modifier9 = modifier$iv;
            $composer2.startReplaceableGroup(1405779621);
            ComposerKt.sourceInformation($composer2, "CC(ReusableComposeNode):Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(new BasicTextKt$BasicText4YKlhWE$$inlined$Layout$1(factory$iv$iv));
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u241$iv = Updater.m2787constructorimpl($composer2);
            modifier2 = modifier8;
            Updater.m2794setimpl($this$Layout_u24lambda_u241$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u241$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u241$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u241$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            Updater.m2794setimpl($this$Layout_u24lambda_u241$iv, materialized$iv, ComposeUiNode.Companion.getSetModifier());
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            softWrap2 = softWrap3;
            overflow3 = overflow4;
            function12 = function13;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            maxLines2 = maxLines;
            minLines2 = minLines;
            style2 = textStyle;
            function12 = function1;
            overflow3 = overflow2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Function1<? super TextLayoutResult, Unit> function14 = function12;
            return;
        }
        Function1<? super TextLayoutResult, Unit> function15 = function12;
        endRestartGroup.updateScope(new BasicTextKt$BasicText$2(text, modifier2, style2, function12, overflow3, softWrap2, maxLines2, minLines2, $changed, i));
    }

    /* renamed from: BasicText-VhcvRP8  reason: not valid java name */
    public static final void m1125BasicTextVhcvRP8(AnnotatedString text, Modifier modifier, TextStyle style, Function1<? super TextLayoutResult, Unit> onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, Map<String, InlineTextContent> inlineContent, Composer $composer, int $changed, int i) {
        Function1 onTextLayout2;
        int i2;
        int maxLines2;
        int minLines2;
        Function1 onTextLayout3;
        Map inlineContent2;
        Modifier modifier2;
        int $dirty;
        int overflow2;
        TextStyle style2;
        boolean softWrap2;
        Composer $composer2;
        Modifier modifier3;
        int maxLines3;
        int minLines3;
        Map inlineContent3;
        int $dirty2;
        long selectableId;
        List inlineComposables;
        Function1 onTextLayout4;
        long selectionBackgroundColor;
        String str;
        SelectionRegistrar selectionRegistrar;
        int $dirty3;
        Composer $composer3;
        long selectableId2;
        int $dirty4;
        List inlineComposables2;
        Function2 content$iv;
        AnnotatedString annotatedString = text;
        int i3 = $changed;
        int i4 = i;
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Composer $composer4 = $composer.startRestartGroup(851408699);
        ComposerKt.sourceInformation($composer4, "C(BasicText)P(8,3,7,4,5:c#ui.text.style.TextOverflow,6,1,2)187@9049L7,188@9088L7,189@9149L7,190@9217L7,212@10305L545,252@11559L270:BasicText.kt#423gt5");
        int $dirty5 = $changed;
        if ((i4 & 1) != 0) {
            $dirty5 |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty5 |= $composer4.changed((Object) annotatedString) ? 4 : 2;
        }
        int i5 = i4 & 2;
        if (i5 != 0) {
            $dirty5 |= 48;
            Modifier modifier4 = modifier;
        } else if ((i3 & 112) == 0) {
            $dirty5 |= $composer4.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier5 = modifier;
        }
        int i6 = i4 & 4;
        if (i6 != 0) {
            $dirty5 |= 384;
            TextStyle textStyle = style;
        } else if ((i3 & 896) == 0) {
            $dirty5 |= $composer4.changed((Object) style) ? 256 : 128;
        } else {
            TextStyle textStyle2 = style;
        }
        int i7 = i4 & 8;
        if (i7 != 0) {
            $dirty5 |= 3072;
            onTextLayout2 = onTextLayout;
        } else if ((i3 & 7168) == 0) {
            onTextLayout2 = onTextLayout;
            $dirty5 |= $composer4.changedInstance(onTextLayout2) ? 2048 : 1024;
        } else {
            onTextLayout2 = onTextLayout;
        }
        int i8 = i4 & 16;
        if (i8 != 0) {
            $dirty5 |= 24576;
            i2 = overflow;
        } else if ((57344 & i3) == 0) {
            i2 = overflow;
            $dirty5 |= $composer4.changed(i2) ? 16384 : 8192;
        } else {
            i2 = overflow;
        }
        int i9 = i4 & 32;
        if (i9 != 0) {
            $dirty5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            boolean z = softWrap;
        } else if ((i3 & 458752) == 0) {
            $dirty5 |= $composer4.changed(softWrap) ? 131072 : 65536;
        } else {
            boolean z2 = softWrap;
        }
        int i10 = i4 & 64;
        if (i10 != 0) {
            $dirty5 |= 1572864;
            int i11 = maxLines;
        } else if ((i3 & 3670016) == 0) {
            $dirty5 |= $composer4.changed(maxLines) ? 1048576 : 524288;
        } else {
            int i12 = maxLines;
        }
        int i13 = i4 & 128;
        if (i13 != 0) {
            $dirty5 |= 12582912;
            int i14 = minLines;
        } else if ((i3 & 29360128) == 0) {
            $dirty5 |= $composer4.changed(minLines) ? 8388608 : 4194304;
        } else {
            int i15 = minLines;
        }
        int i16 = i4 & 256;
        if (i16 != 0) {
            $dirty5 |= 33554432;
        }
        if (i16 == 256 && (191739611 & $dirty5) == 38347922 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            modifier2 = modifier;
            style2 = style;
            softWrap2 = softWrap;
            maxLines2 = maxLines;
            minLines2 = minLines;
            inlineContent2 = inlineContent;
            $dirty = $dirty5;
            onTextLayout3 = onTextLayout2;
            overflow2 = i2;
            AnnotatedString annotatedString2 = annotatedString;
            $composer2 = $composer4;
        } else {
            if (i5 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (i6 != 0) {
                style2 = TextStyle.Companion.getDefault();
            } else {
                style2 = style;
            }
            if (i7 != 0) {
                onTextLayout2 = BasicTextKt$BasicText$3.INSTANCE;
            }
            if (i8 != 0) {
                overflow2 = TextOverflow.Companion.m5898getClipgIe3tQ8();
            } else {
                overflow2 = i2;
            }
            if (i9 != 0) {
                softWrap2 = true;
            } else {
                softWrap2 = softWrap;
            }
            if (i10 != 0) {
                maxLines3 = Integer.MAX_VALUE;
            } else {
                maxLines3 = maxLines;
            }
            if (i13 != 0) {
                minLines3 = 1;
            } else {
                minLines3 = minLines;
            }
            if (i16 != 0) {
                inlineContent3 = MapsKt.emptyMap();
            } else {
                inlineContent3 = inlineContent;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(851408699, $dirty5, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:170)");
            }
            HeightInLinesModifierKt.validateMinMaxLines(minLines3, maxLines3);
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer4.consume(SelectionRegistrarKt.getLocalSelectionRegistrar());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            SelectionRegistrar selectionRegistrar2 = (SelectionRegistrar) consume;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Density density = (Density) consume2;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer4.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            FontFamily.Resolver fontFamilyResolver = (FontFamily.Resolver) consume3;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer4.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier6 = modifier3;
            long selectionBackgroundColor2 = ((TextSelectionColors) consume4).m1357getBackgroundColor0d7_KjU();
            Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> resolveInlineContent = CoreTextKt.resolveInlineContent(annotatedString, inlineContent3);
            List placeholders = resolveInlineContent.component1();
            List inlineComposables3 = resolveInlineContent.component2();
            $composer4.startReplaceableGroup(959243860);
            ComposerKt.sourceInformation($composer4, "207@10126L150");
            if (selectionRegistrar2 == null) {
                selectableId = 0;
                $dirty2 = $dirty5;
            } else {
                $dirty2 = $dirty5;
                selectableId = ((Number) RememberSaveableKt.rememberSaveable(new Object[]{annotatedString, selectionRegistrar2}, selectionIdSaver(selectionRegistrar2), (String) null, new BasicTextKt$BasicText$selectableId$2(selectionRegistrar2), $composer4, 72, 4)).longValue();
            }
            $composer4.endReplaceableGroup();
            long selectableId3 = selectableId;
            $composer4.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer4, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer4;
            Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
            Composer $this$cache$iv$iv2 = $this$cache$iv$iv;
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                long selectableId4 = selectableId3;
                Object obj = value$iv$iv;
                $dirty3 = $dirty2;
                $composer3 = $composer4;
                inlineComposables = inlineComposables3;
                selectionRegistrar = selectionRegistrar2;
                str = "CC:CompositionLocal.kt#9igjgp";
                selectionBackgroundColor = selectionBackgroundColor2;
                modifier2 = modifier6;
                inlineContent2 = inlineContent3;
                onTextLayout4 = onTextLayout2;
                minLines2 = minLines3;
                maxLines2 = maxLines3;
                TextDelegate textDelegate = new TextDelegate(text, style2, maxLines3, minLines3, softWrap2, overflow2, density, fontFamilyResolver, placeholders, (DefaultConstructorMarker) null);
                selectableId2 = selectableId4;
                value$iv$iv = new TextController(new TextState(textDelegate, selectableId2));
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv);
            } else {
                modifier2 = modifier6;
                Object obj2 = value$iv$iv;
                selectionRegistrar = selectionRegistrar2;
                str = "CC:CompositionLocal.kt#9igjgp";
                selectionBackgroundColor = selectionBackgroundColor2;
                inlineContent2 = inlineContent3;
                onTextLayout4 = onTextLayout2;
                minLines2 = minLines3;
                maxLines2 = maxLines3;
                $dirty3 = $dirty2;
                selectableId2 = selectableId3;
                inlineComposables = inlineComposables3;
                $composer3 = $composer4;
            }
            $composer3.endReplaceableGroup();
            TextController controller = (TextController) value$iv$iv;
            TextState state = controller.getState();
            if (!$composer3.getInserting()) {
                long j = selectableId2;
                controller.setTextDelegate(CoreTextKt.m1141updateTextDelegaterm0N8CA(state.getTextDelegate(), text, style2, density, fontFamilyResolver, softWrap2, overflow2, maxLines2, minLines2, placeholders));
            }
            Function1 onTextLayout5 = onTextLayout4;
            state.setOnTextLayout(onTextLayout5);
            long selectionBackgroundColor3 = selectionBackgroundColor;
            state.m1239setSelectionBackgroundColor8_81llA(selectionBackgroundColor3);
            SelectionRegistrar selectionRegistrar3 = selectionRegistrar;
            controller.update(selectionRegistrar3);
            if (inlineComposables.isEmpty()) {
                content$iv = ComposableSingletons$BasicTextKt.INSTANCE.m1136getLambda1$foundation_release();
                AnnotatedString annotatedString3 = text;
                inlineComposables2 = inlineComposables;
                $composer2 = $composer3;
                $dirty4 = $dirty3;
            } else {
                inlineComposables2 = inlineComposables;
                $dirty4 = $dirty3;
                $composer2 = $composer3;
                content$iv = ComposableLambdaKt.composableLambda($composer2, 1749415830, true, new BasicTextKt$BasicText$4(text, inlineComposables2, $dirty4));
            }
            Modifier modifier$iv = modifier2.then(controller.getModifiers());
            MeasurePolicy measurePolicy$iv = controller.getMeasurePolicy();
            long j2 = selectionBackgroundColor3;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            SelectionRegistrar selectionRegistrar4 = selectionRegistrar3;
            String str2 = str;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str2);
            Object consume5 = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv = (Density) consume5;
            List list = inlineComposables2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str2);
            Object consume6 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume6;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str2);
            Object consume7 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume7;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier7 = modifier$iv;
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
            onTextLayout3 = onTextLayout5;
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
            $dirty = $dirty4;
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            content$iv.invoke($composer2, Integer.valueOf(($changed$iv$iv >> 9) & 14));
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            int i17 = $dirty;
            return;
        }
        Composer composer2 = $composer2;
        int i18 = $dirty;
        endRestartGroup.updateScope(new BasicTextKt$BasicText$5(text, modifier2, style2, onTextLayout3, overflow2, softWrap2, maxLines2, minLines2, inlineContent2, $changed, i));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-BpD7jsM  reason: not valid java name */
    public static final /* synthetic */ void m1124BasicTextBpD7jsM(String text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, Composer $composer, int $changed, int i) {
        TextStyle textStyle;
        Function1 function1;
        int i2;
        boolean softWrap2;
        int i3;
        int overflow2;
        Function1 onTextLayout2;
        TextStyle style2;
        Modifier modifier2;
        int maxLines2;
        String str = text;
        int i4 = $changed;
        Intrinsics.checkNotNullParameter(str, "text");
        Composer $composer2 = $composer.startRestartGroup(1022429478);
        ComposerKt.sourceInformation($composer2, "C(BasicText)P(6,1,5,2,3:c#ui.text.style.TextOverflow,4)274@12210L234:BasicText.kt#423gt5");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i4 & 14) == 0) {
            $dirty |= $composer2.changed((Object) str) ? 4 : 2;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty |= 48;
            Modifier modifier3 = modifier;
        } else if ((i4 & 112) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier4 = modifier;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty |= 384;
            textStyle = style;
        } else if ((i4 & 896) == 0) {
            textStyle = style;
            $dirty |= $composer2.changed((Object) textStyle) ? 256 : 128;
        } else {
            textStyle = style;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty |= 3072;
            function1 = onTextLayout;
        } else if ((i4 & 7168) == 0) {
            function1 = onTextLayout;
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        } else {
            function1 = onTextLayout;
        }
        int i8 = i & 16;
        if (i8 != 0) {
            $dirty |= 24576;
            i2 = overflow;
        } else if ((i4 & 57344) == 0) {
            i2 = overflow;
            $dirty |= $composer2.changed(i2) ? 16384 : 8192;
        } else {
            i2 = overflow;
        }
        int i9 = i & 32;
        if (i9 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            softWrap2 = softWrap;
        } else if ((i4 & 458752) == 0) {
            softWrap2 = softWrap;
            $dirty |= $composer2.changed(softWrap2) ? 131072 : 65536;
        } else {
            softWrap2 = softWrap;
        }
        int i10 = i & 64;
        if (i10 != 0) {
            $dirty |= 1572864;
            i3 = maxLines;
        } else if ((i4 & 3670016) == 0) {
            i3 = maxLines;
            $dirty |= $composer2.changed(i3) ? 1048576 : 524288;
        } else {
            i3 = maxLines;
        }
        if (($dirty & 2995931) != 599186 || !$composer2.getSkipping()) {
            if (i5 != 0) {
                modifier2 = Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (i6 != 0) {
                style2 = TextStyle.Companion.getDefault();
            } else {
                style2 = textStyle;
            }
            if (i7 != 0) {
                onTextLayout2 = BasicTextKt$BasicText$6.INSTANCE;
            } else {
                onTextLayout2 = function1;
            }
            if (i8 != 0) {
                overflow2 = TextOverflow.Companion.m5898getClipgIe3tQ8();
            } else {
                overflow2 = i2;
            }
            if (i9 != 0) {
                softWrap2 = true;
            }
            if (i10 != 0) {
                maxLines2 = Integer.MAX_VALUE;
            } else {
                maxLines2 = i3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1022429478, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:265)");
            }
            int i11 = $dirty;
            m1123BasicText4YKlhWE(text, modifier2, style2, (Function1<? super TextLayoutResult, Unit>) onTextLayout2, overflow2, softWrap2, maxLines2, 1, $composer2, 12582912 | ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | ($dirty & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            int i12 = $dirty;
            style2 = textStyle;
            onTextLayout2 = function1;
            maxLines2 = i3;
            overflow2 = i2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BasicTextKt$BasicText$7(text, modifier2, style2, onTextLayout2, overflow2, softWrap2, maxLines2, $changed, i));
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-4YKlhWE  reason: not valid java name */
    public static final /* synthetic */ void m1122BasicText4YKlhWE(AnnotatedString text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, Map inlineContent, Composer $composer, int $changed, int i) {
        TextStyle textStyle;
        Function1 function1;
        int i2;
        boolean z;
        Map inlineContent2;
        int overflow2;
        Function1 onTextLayout2;
        TextStyle style2;
        Modifier modifier2;
        int maxLines2;
        boolean softWrap2;
        AnnotatedString annotatedString = text;
        int i3 = $changed;
        int i4 = i;
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Composer $composer2 = $composer.startRestartGroup(-648605928);
        ComposerKt.sourceInformation($composer2, "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5,1)298@12896L273:BasicText.kt#423gt5");
        int $dirty = $changed;
        if ((i4 & 1) != 0) {
            $dirty |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer2.changed((Object) annotatedString) ? 4 : 2;
        }
        int i5 = i4 & 2;
        if (i5 != 0) {
            $dirty |= 48;
            Modifier modifier3 = modifier;
        } else if ((i3 & 112) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier4 = modifier;
        }
        int i6 = i4 & 4;
        if (i6 != 0) {
            $dirty |= 384;
            textStyle = style;
        } else if ((i3 & 896) == 0) {
            textStyle = style;
            $dirty |= $composer2.changed((Object) textStyle) ? 256 : 128;
        } else {
            textStyle = style;
        }
        int i7 = i4 & 8;
        if (i7 != 0) {
            $dirty |= 3072;
            function1 = onTextLayout;
        } else if ((i3 & 7168) == 0) {
            function1 = onTextLayout;
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        } else {
            function1 = onTextLayout;
        }
        int i8 = i4 & 16;
        if (i8 != 0) {
            $dirty |= 24576;
            i2 = overflow;
        } else if ((i3 & 57344) == 0) {
            i2 = overflow;
            $dirty |= $composer2.changed(i2) ? 16384 : 8192;
        } else {
            i2 = overflow;
        }
        int i9 = i4 & 32;
        if (i9 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z = softWrap;
        } else if ((i3 & 458752) == 0) {
            z = softWrap;
            $dirty |= $composer2.changed(z) ? 131072 : 65536;
        } else {
            z = softWrap;
        }
        int i10 = i4 & 64;
        if (i10 != 0) {
            $dirty |= 1572864;
            int i11 = maxLines;
        } else if ((i3 & 3670016) == 0) {
            $dirty |= $composer2.changed(maxLines) ? 1048576 : 524288;
        } else {
            int i12 = maxLines;
        }
        int i13 = i4 & 128;
        if (i13 != 0) {
            $dirty |= 4194304;
        }
        if (i13 == 128 && (23967451 & $dirty) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            maxLines2 = maxLines;
            inlineContent2 = inlineContent;
            int i14 = $dirty;
            style2 = textStyle;
            onTextLayout2 = function1;
            softWrap2 = z;
            overflow2 = i2;
        } else {
            if (i5 != 0) {
                modifier2 = Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (i6 != 0) {
                style2 = TextStyle.Companion.getDefault();
            } else {
                style2 = textStyle;
            }
            if (i7 != 0) {
                onTextLayout2 = BasicTextKt$BasicText$8.INSTANCE;
            } else {
                onTextLayout2 = function1;
            }
            if (i8 != 0) {
                overflow2 = TextOverflow.Companion.m5898getClipgIe3tQ8();
            } else {
                overflow2 = i2;
            }
            if (i9 != 0) {
                softWrap2 = true;
            } else {
                softWrap2 = z;
            }
            if (i10 != 0) {
                maxLines2 = Integer.MAX_VALUE;
            } else {
                maxLines2 = maxLines;
            }
            if (i13 != 0) {
                inlineContent2 = MapsKt.emptyMap();
            } else {
                inlineContent2 = inlineContent;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-648605928, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:288)");
            }
            int i15 = $dirty;
            m1125BasicTextVhcvRP8(text, modifier2, style2, onTextLayout2, overflow2, softWrap2, maxLines2, 1, inlineContent2, $composer2, 146800640 | ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | ($dirty & 458752) | ($dirty & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BasicTextKt$BasicText$9(text, modifier2, style2, onTextLayout2, overflow2, softWrap2, maxLines2, inlineContent2, $changed, i));
        }
    }

    private static final Saver<Long, Long> selectionIdSaver(SelectionRegistrar selectionRegistrar) {
        return SaverKt.Saver(new BasicTextKt$selectionIdSaver$1(selectionRegistrar), BasicTextKt$selectionIdSaver$2.INSTANCE);
    }
}
