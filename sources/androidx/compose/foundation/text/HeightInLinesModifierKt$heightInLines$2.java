package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: HeightInLinesModifier.kt */
final class HeightInLinesModifierKt$heightInLines$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ int $maxLines;
    final /* synthetic */ int $minLines;
    final /* synthetic */ TextStyle $textStyle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HeightInLinesModifierKt$heightInLines$2(int i, int i2, TextStyle textStyle) {
        super(3);
        this.$minLines = i;
        this.$maxLines = i2;
        this.$textStyle = textStyle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        TextStyle value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Object value$iv$iv4;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        composer.startReplaceableGroup(408240218);
        ComposerKt.sourceInformation(composer, "C62@2391L7,63@2452L7,64@2507L7,68@2678L96,71@2795L312,80@3135L366,96@3533L428:HeightInLinesModifier.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(408240218, $changed, -1, "androidx.compose.foundation.text.heightInLines.<anonymous> (HeightInLinesModifier.kt:58)");
        } else {
            int i = $changed;
        }
        HeightInLinesModifierKt.validateMinMaxLines(this.$minLines, this.$maxLines);
        if (this.$minLines == 1 && this.$maxLines == Integer.MAX_VALUE) {
            Modifier.Companion companion = Modifier.Companion;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceableGroup();
            return companion;
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
        ComposerKt.sourceInformationMarkerEnd($composer);
        FontFamily.Resolver fontFamilyResolver = (FontFamily.Resolver) consume2;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd($composer);
        LayoutDirection layoutDirection = (LayoutDirection) consume3;
        Object key1$iv = this.$textStyle;
        TextStyle textStyle = this.$textStyle;
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed(key1$iv) | composer.changed((Object) layoutDirection);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = TextStyleKt.resolveDefaults(textStyle, layoutDirection);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
            Composer composer2 = $this$cache$iv$iv;
        }
        $composer.endReplaceableGroup();
        TextStyle resolvedStyle = value$iv$iv;
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = composer.changed((Object) fontFamilyResolver) | composer.changed((Object) resolvedStyle);
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv2 || it$iv$iv2 == Composer.Companion.getEmpty()) {
            FontFamily fontFamily = resolvedStyle.getFontFamily();
            FontWeight fontWeight = resolvedStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontWeight fontWeight2 = fontWeight;
            FontStyle r16 = resolvedStyle.m5496getFontStyle4Lr2A7w();
            int r6 = r16 != null ? r16.m5566unboximpl() : FontStyle.Companion.m5568getNormal_LCdwA();
            FontSynthesis r162 = resolvedStyle.m5497getFontSynthesisZQGJjVo();
            value$iv$iv2 = fontFamilyResolver.m5537resolveDPcqOEQ(fontFamily, fontWeight2, r6, r162 != null ? r162.m5577unboximpl() : FontSynthesis.Companion.m5578getAllGVVA2EU());
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        State typeface$delegate = (State) value$iv$iv2;
        Object[] keys$iv = {density, fontFamilyResolver, this.$textStyle, layoutDirection, invoke$lambda$2(typeface$delegate)};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= composer.changed(key$iv);
        }
        Composer $this$cache$iv$iv3 = $composer;
        Object it$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
        if (invalid$iv || it$iv$iv3 == Composer.Companion.getEmpty()) {
            Object[] objArr = keys$iv;
            value$iv$iv3 = Integer.valueOf(IntSize.m6145getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(resolvedStyle, density, fontFamilyResolver, TextFieldDelegateKt.getEmptyTextReplacement(), 1)));
            $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
        } else {
            Object[] objArr2 = keys$iv;
            value$iv$iv3 = it$iv$iv3;
        }
        $composer.endReplaceableGroup();
        int firstLineHeight = ((Number) value$iv$iv3).intValue();
        Object[] keys$iv2 = {density, fontFamilyResolver, this.$textStyle, layoutDirection, invoke$lambda$2(typeface$delegate)};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv2 = false;
        for (Object key$iv2 : keys$iv2) {
            invalid$iv2 |= composer.changed(key$iv2);
        }
        Composer $this$cache$iv$iv4 = $composer;
        Object it$iv$iv4 = $this$cache$iv$iv4.rememberedValue();
        if (invalid$iv2 || it$iv$iv4 == Composer.Companion.getEmpty()) {
            State state = typeface$delegate;
            value$iv$iv4 = Integer.valueOf(IntSize.m6145getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(resolvedStyle, density, fontFamilyResolver, TextFieldDelegateKt.getEmptyTextReplacement() + 10 + TextFieldDelegateKt.getEmptyTextReplacement(), 2)));
            $this$cache$iv$iv4.updateRememberedValue(value$iv$iv4);
        } else {
            State state2 = typeface$delegate;
            value$iv$iv4 = it$iv$iv4;
        }
        $composer.endReplaceableGroup();
        int lineHeight = ((Number) value$iv$iv4).intValue() - firstLineHeight;
        int i2 = this.$minLines;
        Integer precomputedMaxLinesHeight = null;
        Integer precomputedMinLinesHeight = i2 == 1 ? null : Integer.valueOf(((i2 - 1) * lineHeight) + firstLineHeight);
        int i3 = this.$maxLines;
        if (i3 != Integer.MAX_VALUE) {
            precomputedMaxLinesHeight = Integer.valueOf(((i3 - 1) * lineHeight) + firstLineHeight);
        }
        Density $this$invoke_u24lambda_u245 = density;
        Modifier r10 = SizeKt.m817heightInVpY3zN4(Modifier.Companion, precomputedMinLinesHeight != null ? $this$invoke_u24lambda_u245.m5964toDpu2uoSUM(precomputedMinLinesHeight.intValue()) : Dp.Companion.m6006getUnspecifiedD9Ej5fM(), precomputedMaxLinesHeight != null ? $this$invoke_u24lambda_u245.m5964toDpu2uoSUM(precomputedMaxLinesHeight.intValue()) : Dp.Companion.m6006getUnspecifiedD9Ej5fM());
        if (ComposerKt.isTraceInProgress() != 0) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r10;
    }

    private static final Object invoke$lambda$2(State<? extends Object> $typeface$delegate) {
        return $typeface$delegate.getValue();
    }
}
