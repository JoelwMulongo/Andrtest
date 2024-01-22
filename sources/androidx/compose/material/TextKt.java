package androidx.compose.material;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import androidx.profileinstaller.ProfileVerifier;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aé\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u001aß\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103\u001aÉ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105\u001aÓ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00106\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00067"}, d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Text.kt */
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), TextKt$LocalTextStyle$1.INSTANCE);

    /* renamed from: Text--4IGK_g  reason: not valid java name */
    public static final void m1694Text4IGK_g(String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, int minLines, Function1<? super TextLayoutResult, Unit> onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i) {
        int i2;
        TextStyle style2;
        Function1 onTextLayout2;
        int minLines2;
        int maxLines2;
        boolean softWrap2;
        int overflow2;
        long lineHeight2;
        TextAlign textAlign2;
        TextDecoration textDecoration2;
        long letterSpacing2;
        FontFamily fontFamily2;
        FontWeight fontWeight2;
        FontStyle fontStyle2;
        long fontSize2;
        long color2;
        Modifier modifier2;
        long lineHeight3;
        long fontSize3;
        long letterSpacing3;
        long color3;
        FontFamily fontFamily3;
        int $dirty1;
        FontWeight fontWeight3;
        Function1 onTextLayout3;
        int minLines3;
        FontStyle fontStyle3;
        int maxLines3;
        boolean softWrap3;
        TextAlign textAlign3;
        TextDecoration textDecoration3;
        Modifier modifier3;
        TextStyle style3;
        int overflow3;
        int minLines4;
        long textColor;
        int i3;
        String str = text;
        int i4 = $changed;
        int i5 = $changed1;
        int i6 = i;
        Intrinsics.checkNotNullParameter(str, "text");
        Composer $composer2 = $composer.startRestartGroup(1028090691);
        ComposerKt.sourceInformation($composer2, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12)109@5705L7,132@6463L247:Text.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        if ((i6 & 1) != 0) {
            $dirty |= 6;
        } else if ((i4 & 14) == 0) {
            $dirty |= $composer2.changed((Object) str) ? 4 : 2;
        }
        int i7 = i6 & 2;
        if (i7 != 0) {
            $dirty |= 48;
            Modifier modifier4 = modifier;
        } else if ((i4 & 112) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier5 = modifier;
        }
        int i8 = i6 & 4;
        if (i8 != 0) {
            $dirty |= 384;
            long j = color;
        } else if ((i4 & 896) == 0) {
            $dirty |= $composer2.changed(color) ? 256 : 128;
        } else {
            long j2 = color;
        }
        int i9 = i6 & 8;
        int i10 = 2048;
        if (i9 != 0) {
            $dirty |= 3072;
            long j3 = fontSize;
        } else if ((i4 & 7168) == 0) {
            $dirty |= $composer2.changed(fontSize) ? 2048 : 1024;
        } else {
            long j4 = fontSize;
        }
        int i11 = i6 & 16;
        int i12 = 16384;
        if (i11 != 0) {
            $dirty |= 24576;
            FontStyle fontStyle4 = fontStyle;
        } else if ((i4 & 57344) == 0) {
            $dirty |= $composer2.changed((Object) fontStyle) ? 16384 : 8192;
        } else {
            FontStyle fontStyle5 = fontStyle;
        }
        int i13 = i6 & 32;
        if (i13 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            FontWeight fontWeight4 = fontWeight;
        } else if ((i4 & 458752) == 0) {
            $dirty |= $composer2.changed((Object) fontWeight) ? 131072 : 65536;
        } else {
            FontWeight fontWeight5 = fontWeight;
        }
        int i14 = i6 & 64;
        if (i14 != 0) {
            $dirty |= 1572864;
            FontFamily fontFamily4 = fontFamily;
        } else if ((i4 & 3670016) == 0) {
            $dirty |= $composer2.changed((Object) fontFamily) ? 1048576 : 524288;
        } else {
            FontFamily fontFamily5 = fontFamily;
        }
        int i15 = i6 & 128;
        if (i15 != 0) {
            $dirty |= 12582912;
            long j5 = letterSpacing;
        } else if ((i4 & 29360128) == 0) {
            $dirty |= $composer2.changed(letterSpacing) ? 8388608 : 4194304;
        } else {
            long j6 = letterSpacing;
        }
        int i16 = i6 & 256;
        if (i16 != 0) {
            $dirty |= 100663296;
            TextDecoration textDecoration4 = textDecoration;
        } else if ((234881024 & i4) == 0) {
            $dirty |= $composer2.changed((Object) textDecoration) ? 67108864 : 33554432;
        } else {
            TextDecoration textDecoration5 = textDecoration;
        }
        int i17 = i6 & 512;
        if (i17 != 0) {
            $dirty |= 805306368;
            TextAlign textAlign4 = textAlign;
        } else if ((i4 & 1879048192) == 0) {
            $dirty |= $composer2.changed((Object) textAlign) ? 536870912 : 268435456;
        } else {
            TextAlign textAlign5 = textAlign;
        }
        int $dirty2 = $dirty;
        int $dirty3 = i6 & 1024;
        if ($dirty3 != 0) {
            $dirty12 |= 6;
            i2 = i17;
            long j7 = lineHeight;
        } else if ((i5 & 14) == 0) {
            i2 = i17;
            $dirty12 |= $composer2.changed(lineHeight) ? 4 : 2;
        } else {
            i2 = i17;
            long j8 = lineHeight;
        }
        int i18 = i6 & 2048;
        if (i18 != 0) {
            $dirty12 |= 48;
            int i19 = overflow;
        } else if ((i5 & 112) == 0) {
            $dirty12 |= $composer2.changed(overflow) ? 32 : 16;
        } else {
            int i20 = overflow;
        }
        int i21 = i6 & 4096;
        if (i21 != 0) {
            $dirty12 |= 384;
            boolean z = softWrap;
        } else if ((i5 & 896) == 0) {
            $dirty12 |= $composer2.changed(softWrap) ? 256 : 128;
        } else {
            boolean z2 = softWrap;
        }
        int i22 = i6 & 8192;
        if (i22 != 0) {
            $dirty12 |= 3072;
            int i23 = maxLines;
        } else if ((i5 & 7168) == 0) {
            if (!$composer2.changed(maxLines)) {
                i10 = 1024;
            }
            $dirty12 |= i10;
        } else {
            int i24 = maxLines;
        }
        int i25 = i6 & 16384;
        if (i25 != 0) {
            $dirty12 |= 24576;
            int i26 = minLines;
        } else if ((i5 & 57344) == 0) {
            if (!$composer2.changed(minLines)) {
                i12 = 8192;
            }
            $dirty12 |= i12;
        } else {
            int i27 = minLines;
        }
        int i28 = i6 & 32768;
        if (i28 != 0) {
            $dirty12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            Function1<? super TextLayoutResult, Unit> function1 = onTextLayout;
        } else if ((i5 & 458752) == 0) {
            $dirty12 |= $composer2.changedInstance(onTextLayout) ? 131072 : 65536;
        } else {
            Function1<? super TextLayoutResult, Unit> function12 = onTextLayout;
        }
        if ((i5 & 3670016) == 0) {
            if ((i6 & 65536) != 0) {
                TextStyle textStyle = style;
            } else if ($composer2.changed((Object) style)) {
                i3 = 1048576;
                $dirty12 |= i3;
            }
            i3 = 524288;
            $dirty12 |= i3;
        } else {
            TextStyle textStyle2 = style;
        }
        if (($dirty2 & 1533916891) == 306783378 && (2995931 & $dirty12) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            color2 = color;
            fontSize2 = fontSize;
            fontStyle2 = fontStyle;
            fontWeight2 = fontWeight;
            fontFamily2 = fontFamily;
            letterSpacing2 = letterSpacing;
            textDecoration2 = textDecoration;
            textAlign2 = textAlign;
            lineHeight2 = lineHeight;
            overflow2 = overflow;
            softWrap2 = softWrap;
            maxLines2 = maxLines;
            minLines2 = minLines;
            onTextLayout2 = onTextLayout;
            style2 = style;
            int i29 = $dirty12;
        } else {
            $composer2.startDefaults();
            if ((i4 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i8 != 0) {
                    color3 = Color.Companion.m3200getUnspecified0d7_KjU();
                } else {
                    color3 = color;
                }
                if (i9 != 0) {
                    fontSize3 = TextUnit.Companion.m6178getUnspecifiedXSAIIZE();
                } else {
                    fontSize3 = fontSize;
                }
                if (i11 != 0) {
                    fontStyle3 = null;
                } else {
                    fontStyle3 = fontStyle;
                }
                if (i13 != 0) {
                    fontWeight3 = null;
                } else {
                    fontWeight3 = fontWeight;
                }
                if (i14 != 0) {
                    fontFamily3 = null;
                } else {
                    fontFamily3 = fontFamily;
                }
                if (i15 != 0) {
                    letterSpacing3 = TextUnit.Companion.m6178getUnspecifiedXSAIIZE();
                } else {
                    letterSpacing3 = letterSpacing;
                }
                if (i16 != 0) {
                    textDecoration3 = null;
                } else {
                    textDecoration3 = textDecoration;
                }
                if (i2 != 0) {
                    textAlign3 = null;
                } else {
                    textAlign3 = textAlign;
                }
                if ($dirty3 != 0) {
                    lineHeight3 = TextUnit.Companion.m6178getUnspecifiedXSAIIZE();
                } else {
                    lineHeight3 = lineHeight;
                }
                if (i18 != 0) {
                    overflow3 = TextOverflow.Companion.m5898getClipgIe3tQ8();
                } else {
                    overflow3 = overflow;
                }
                if (i21 != 0) {
                    softWrap3 = true;
                } else {
                    softWrap3 = softWrap;
                }
                if (i22 != 0) {
                    maxLines3 = Integer.MAX_VALUE;
                } else {
                    maxLines3 = maxLines;
                }
                if (i25 != 0) {
                    minLines3 = 1;
                } else {
                    minLines3 = minLines;
                }
                if (i28 != 0) {
                    onTextLayout3 = TextKt$Text$1.INSTANCE;
                } else {
                    onTextLayout3 = onTextLayout;
                }
                if ((i6 & 65536) != 0) {
                    int overflow4 = overflow3;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(LocalTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $dirty1 = $dirty12 & -3670017;
                    style3 = (TextStyle) consume;
                    overflow3 = overflow4;
                } else {
                    $dirty1 = $dirty12;
                    style3 = style;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i6 & 65536) != 0) {
                    int i30 = -3670017 & $dirty12;
                    modifier3 = modifier;
                    color3 = color;
                    fontSize3 = fontSize;
                    fontStyle3 = fontStyle;
                    fontWeight3 = fontWeight;
                    fontFamily3 = fontFamily;
                    letterSpacing3 = letterSpacing;
                    textDecoration3 = textDecoration;
                    textAlign3 = textAlign;
                    lineHeight3 = lineHeight;
                    softWrap3 = softWrap;
                    maxLines3 = maxLines;
                    minLines3 = minLines;
                    onTextLayout3 = onTextLayout;
                    style3 = style;
                    $dirty1 = i30;
                    overflow3 = overflow;
                } else {
                    modifier3 = modifier;
                    color3 = color;
                    fontSize3 = fontSize;
                    fontStyle3 = fontStyle;
                    fontWeight3 = fontWeight;
                    fontFamily3 = fontFamily;
                    letterSpacing3 = letterSpacing;
                    textDecoration3 = textDecoration;
                    textAlign3 = textAlign;
                    lineHeight3 = lineHeight;
                    overflow3 = overflow;
                    softWrap3 = softWrap;
                    maxLines3 = maxLines;
                    minLines3 = minLines;
                    onTextLayout3 = onTextLayout;
                    $dirty1 = $dirty12;
                    style3 = style;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                minLines4 = minLines3;
                ComposerKt.traceEventStart(1028090691, $dirty2, $dirty1, "androidx.compose.material.Text (Text.kt:92)");
            } else {
                minLines4 = minLines3;
            }
            $composer2.startReplaceableGroup(1557613245);
            ComposerKt.sourceInformation($composer2, "*114@5820L7,114@5859L7");
            long $this$takeOrElse_u2dDxMtmZc$iv = color3;
            boolean z3 = true;
            if ($this$takeOrElse_u2dDxMtmZc$iv != Color.Companion.m3200getUnspecified0d7_KjU()) {
                textColor = $this$takeOrElse_u2dDxMtmZc$iv;
            } else {
                long $this$takeOrElse_u2dDxMtmZc$iv2 = style3.m5494getColor0d7_KjU();
                if ($this$takeOrElse_u2dDxMtmZc$iv2 == Color.Companion.m3200getUnspecified0d7_KjU()) {
                    z3 = false;
                }
                if (!z3) {
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer2.consume(ContentColorKt.getLocalContentColor());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    long r34 = ((Color) consume2).m3174unboximpl();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume3 = $composer2.consume(ContentAlphaKt.getLocalContentAlpha());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $this$takeOrElse_u2dDxMtmZc$iv2 = Color.m3163copywmQWz5c$default(r34, ((Number) consume3).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                }
                textColor = $this$takeOrElse_u2dDxMtmZc$iv2;
            }
            $composer2.endReplaceableGroup();
            BasicTextKt.m1123BasicText4YKlhWE(text, modifier3, style3.merge(new TextStyle(textColor, fontSize3, fontWeight3, fontStyle3, (FontSynthesis) null, fontFamily3, (String) null, letterSpacing3, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, textDecoration3, (Shadow) null, textAlign3, (TextDirection) null, lineHeight3, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4108112, (DefaultConstructorMarker) null)), (Function1<? super TextLayoutResult, Unit>) onTextLayout3, overflow3, softWrap3, maxLines3, minLines4, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($dirty1 >> 6) & 7168) | (($dirty1 << 9) & 57344) | (($dirty1 << 9) & 458752) | (($dirty1 << 9) & 3670016) | (($dirty1 << 9) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            minLines2 = minLines4;
            overflow2 = overflow3;
            style2 = style3;
            textDecoration2 = textDecoration3;
            textAlign2 = textAlign3;
            softWrap2 = softWrap3;
            maxLines2 = maxLines3;
            fontStyle2 = fontStyle3;
            onTextLayout2 = onTextLayout3;
            fontWeight2 = fontWeight3;
            int i31 = $dirty1;
            fontFamily2 = fontFamily3;
            letterSpacing2 = letterSpacing3;
            fontSize2 = fontSize3;
            lineHeight2 = lineHeight3;
            modifier2 = modifier3;
            color2 = color3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i32 = $dirty2;
            Composer composer = $composer2;
            return;
        }
        int i33 = $dirty2;
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new TextKt$Text$2(text, modifier2, color2, fontSize2, fontStyle2, fontWeight2, fontFamily2, letterSpacing2, textDecoration2, textAlign2, lineHeight2, overflow2, softWrap2, maxLines2, minLines2, onTextLayout2, style2, $changed, $changed1, i));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text-fLXpl1I  reason: not valid java name */
    public static final /* synthetic */ void m1696TextfLXpl1I(String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Function1 onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i) {
        int i2;
        TextStyle style2;
        Function1 onTextLayout2;
        int maxLines2;
        boolean softWrap2;
        int overflow2;
        long lineHeight2;
        TextAlign textAlign2;
        TextDecoration textDecoration2;
        long letterSpacing2;
        FontFamily fontFamily2;
        FontWeight fontWeight2;
        long fontSize2;
        long color2;
        Composer $composer2;
        FontStyle fontStyle2;
        Modifier modifier2;
        int $dirty1;
        Modifier modifier3;
        long color3;
        long fontSize3;
        FontStyle fontStyle3;
        FontWeight fontWeight3;
        FontFamily fontFamily3;
        long letterSpacing3;
        TextDecoration textDecoration3;
        TextAlign textAlign3;
        long lineHeight3;
        int overflow3;
        boolean softWrap3;
        int maxLines3;
        Function1 onTextLayout3;
        int i3;
        String str = text;
        int i4 = $changed;
        int i5 = $changed1;
        int i6 = i;
        Intrinsics.checkNotNullParameter(str, "text");
        Composer $composer3 = $composer.startRestartGroup(-366126944);
        ComposerKt.sourceInformation($composer3, "C(Text)P(13,8,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,15,14:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,10:c#ui.text.style.TextOverflow,11)165@7490L7,167@7506L322:Text.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        if ((i6 & 1) != 0) {
            $dirty |= 6;
        } else if ((i4 & 14) == 0) {
            $dirty |= $composer3.changed((Object) str) ? 4 : 2;
        }
        int i7 = i6 & 2;
        if (i7 != 0) {
            $dirty |= 48;
            Modifier modifier4 = modifier;
        } else if ((i4 & 112) == 0) {
            $dirty |= $composer3.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier5 = modifier;
        }
        int i8 = i6 & 4;
        if (i8 != 0) {
            $dirty |= 384;
            long j = color;
        } else if ((i4 & 896) == 0) {
            $dirty |= $composer3.changed(color) ? 256 : 128;
        } else {
            long j2 = color;
        }
        int i9 = i6 & 8;
        int i10 = 2048;
        if (i9 != 0) {
            $dirty |= 3072;
            long j3 = fontSize;
        } else if ((i4 & 7168) == 0) {
            $dirty |= $composer3.changed(fontSize) ? 2048 : 1024;
        } else {
            long j4 = fontSize;
        }
        int i11 = i6 & 16;
        int i12 = 16384;
        if (i11 != 0) {
            $dirty |= 24576;
            FontStyle fontStyle4 = fontStyle;
        } else if ((i4 & 57344) == 0) {
            $dirty |= $composer3.changed((Object) fontStyle) ? 16384 : 8192;
        } else {
            FontStyle fontStyle5 = fontStyle;
        }
        int i13 = i6 & 32;
        if (i13 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            FontWeight fontWeight4 = fontWeight;
        } else if ((i4 & 458752) == 0) {
            $dirty |= $composer3.changed((Object) fontWeight) ? 131072 : 65536;
        } else {
            FontWeight fontWeight5 = fontWeight;
        }
        int i14 = i6 & 64;
        if (i14 != 0) {
            $dirty |= 1572864;
            FontFamily fontFamily4 = fontFamily;
        } else if ((i4 & 3670016) == 0) {
            $dirty |= $composer3.changed((Object) fontFamily) ? 1048576 : 524288;
        } else {
            FontFamily fontFamily5 = fontFamily;
        }
        int i15 = i6 & 128;
        if (i15 != 0) {
            $dirty |= 12582912;
            long j5 = letterSpacing;
        } else if ((i4 & 29360128) == 0) {
            $dirty |= $composer3.changed(letterSpacing) ? 8388608 : 4194304;
        } else {
            long j6 = letterSpacing;
        }
        int i16 = i6 & 256;
        if (i16 != 0) {
            $dirty |= 100663296;
            TextDecoration textDecoration4 = textDecoration;
        } else if ((i4 & 234881024) == 0) {
            $dirty |= $composer3.changed((Object) textDecoration) ? 67108864 : 33554432;
        } else {
            TextDecoration textDecoration5 = textDecoration;
        }
        int i17 = i6 & 512;
        if (i17 != 0) {
            $dirty |= 805306368;
            TextAlign textAlign4 = textAlign;
        } else if ((i4 & 1879048192) == 0) {
            $dirty |= $composer3.changed((Object) textAlign) ? 536870912 : 268435456;
        } else {
            TextAlign textAlign5 = textAlign;
        }
        int i18 = i6 & 1024;
        if (i18 != 0) {
            $dirty12 |= 6;
            long j7 = lineHeight;
        } else if ((i5 & 14) == 0) {
            $dirty12 |= $composer3.changed(lineHeight) ? 4 : 2;
        } else {
            long j8 = lineHeight;
        }
        int i19 = i6 & 2048;
        if (i19 != 0) {
            $dirty12 |= 48;
            int i20 = overflow;
        } else if ((i5 & 112) == 0) {
            $dirty12 |= $composer3.changed(overflow) ? 32 : 16;
        } else {
            int i21 = overflow;
        }
        int i22 = i6 & 4096;
        if (i22 != 0) {
            $dirty12 |= 384;
            boolean z = softWrap;
        } else if ((i5 & 896) == 0) {
            $dirty12 |= $composer3.changed(softWrap) ? 256 : 128;
        } else {
            boolean z2 = softWrap;
        }
        int i23 = i6 & 8192;
        if (i23 != 0) {
            $dirty12 |= 3072;
            int i24 = maxLines;
        } else if ((i5 & 7168) == 0) {
            if (!$composer3.changed(maxLines)) {
                i10 = 1024;
            }
            $dirty12 |= i10;
        } else {
            int i25 = maxLines;
        }
        int i26 = i6 & 16384;
        if (i26 != 0) {
            $dirty12 |= 24576;
            i2 = i26;
            Function1 function1 = onTextLayout;
        } else if ((i5 & 57344) == 0) {
            i2 = i26;
            if (!$composer3.changedInstance(onTextLayout)) {
                i12 = 8192;
            }
            $dirty12 |= i12;
        } else {
            i2 = i26;
            Function1 function12 = onTextLayout;
        }
        if ((i5 & 458752) == 0) {
            if ((i6 & 32768) != 0) {
                TextStyle textStyle = style;
            } else if ($composer3.changed((Object) style)) {
                i3 = 131072;
                $dirty12 |= i3;
            }
            i3 = 65536;
            $dirty12 |= i3;
        } else {
            TextStyle textStyle2 = style;
        }
        if (($dirty & 1533916891) == 306783378 && (374491 & $dirty12) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            color2 = color;
            fontSize2 = fontSize;
            fontStyle2 = fontStyle;
            fontWeight2 = fontWeight;
            fontFamily2 = fontFamily;
            letterSpacing2 = letterSpacing;
            textDecoration2 = textDecoration;
            textAlign2 = textAlign;
            lineHeight2 = lineHeight;
            overflow2 = overflow;
            softWrap2 = softWrap;
            maxLines2 = maxLines;
            onTextLayout2 = onTextLayout;
            style2 = style;
            int i27 = $dirty;
            int i28 = $dirty12;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if ((i4 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i8 != 0) {
                    color3 = Color.Companion.m3200getUnspecified0d7_KjU();
                } else {
                    color3 = color;
                }
                if (i9 != 0) {
                    fontSize3 = TextUnit.Companion.m6178getUnspecifiedXSAIIZE();
                } else {
                    fontSize3 = fontSize;
                }
                if (i11 != 0) {
                    fontStyle3 = null;
                } else {
                    fontStyle3 = fontStyle;
                }
                if (i13 != 0) {
                    fontWeight3 = null;
                } else {
                    fontWeight3 = fontWeight;
                }
                if (i14 != 0) {
                    fontFamily3 = null;
                } else {
                    fontFamily3 = fontFamily;
                }
                if (i15 != 0) {
                    letterSpacing3 = TextUnit.Companion.m6178getUnspecifiedXSAIIZE();
                } else {
                    letterSpacing3 = letterSpacing;
                }
                if (i16 != 0) {
                    textDecoration3 = null;
                } else {
                    textDecoration3 = textDecoration;
                }
                if (i17 != 0) {
                    textAlign3 = null;
                } else {
                    textAlign3 = textAlign;
                }
                if (i18 != 0) {
                    lineHeight3 = TextUnit.Companion.m6178getUnspecifiedXSAIIZE();
                } else {
                    lineHeight3 = lineHeight;
                }
                if (i19 != 0) {
                    overflow3 = TextOverflow.Companion.m5898getClipgIe3tQ8();
                } else {
                    overflow3 = overflow;
                }
                if (i22 != 0) {
                    softWrap3 = true;
                } else {
                    softWrap3 = softWrap;
                }
                if (i23 != 0) {
                    maxLines3 = Integer.MAX_VALUE;
                } else {
                    maxLines3 = maxLines;
                }
                if (i2 != 0) {
                    onTextLayout3 = TextKt$Text$3.INSTANCE;
                } else {
                    onTextLayout3 = onTextLayout;
                }
                if ((i6 & 32768) != 0) {
                    TextDecoration textDecoration6 = textDecoration3;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(LocalTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textDecoration2 = textDecoration6;
                    style2 = (TextStyle) consume;
                    overflow2 = overflow3;
                    textAlign2 = textAlign3;
                    softWrap2 = softWrap3;
                    maxLines2 = maxLines3;
                    onTextLayout2 = onTextLayout3;
                    color2 = color3;
                    fontSize2 = fontSize3;
                    fontWeight2 = fontWeight3;
                    fontFamily2 = fontFamily3;
                    letterSpacing2 = letterSpacing3;
                    lineHeight2 = lineHeight3;
                    modifier2 = modifier3;
                    $dirty1 = $dirty12 & -458753;
                    fontStyle2 = fontStyle3;
                } else {
                    textDecoration2 = textDecoration3;
                    style2 = style;
                    overflow2 = overflow3;
                    textAlign2 = textAlign3;
                    softWrap2 = softWrap3;
                    maxLines2 = maxLines3;
                    onTextLayout2 = onTextLayout3;
                    color2 = color3;
                    fontSize2 = fontSize3;
                    fontWeight2 = fontWeight3;
                    fontFamily2 = fontFamily3;
                    letterSpacing2 = letterSpacing3;
                    lineHeight2 = lineHeight3;
                    modifier2 = modifier3;
                    $dirty1 = $dirty12;
                    fontStyle2 = fontStyle3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i6 & 32768) != 0) {
                    modifier2 = modifier;
                    color2 = color;
                    fontSize2 = fontSize;
                    fontStyle2 = fontStyle;
                    fontWeight2 = fontWeight;
                    fontFamily2 = fontFamily;
                    letterSpacing2 = letterSpacing;
                    textDecoration2 = textDecoration;
                    textAlign2 = textAlign;
                    lineHeight2 = lineHeight;
                    overflow2 = overflow;
                    softWrap2 = softWrap;
                    maxLines2 = maxLines;
                    onTextLayout2 = onTextLayout;
                    style2 = style;
                    $dirty1 = -458753 & $dirty12;
                } else {
                    modifier2 = modifier;
                    color2 = color;
                    fontSize2 = fontSize;
                    fontStyle2 = fontStyle;
                    fontWeight2 = fontWeight;
                    fontFamily2 = fontFamily;
                    letterSpacing2 = letterSpacing;
                    textDecoration2 = textDecoration;
                    textAlign2 = textAlign;
                    lineHeight2 = lineHeight;
                    overflow2 = overflow;
                    softWrap2 = softWrap;
                    maxLines2 = maxLines;
                    onTextLayout2 = onTextLayout;
                    style2 = style;
                    $dirty1 = $dirty12;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-366126944, $dirty, $dirty1, "androidx.compose.material.Text (Text.kt:149)");
            }
            int i29 = $dirty;
            $composer2 = $composer3;
            int i30 = $dirty1;
            m1694Text4IGK_g(text, modifier2, color2, fontSize2, fontStyle2, fontWeight2, fontFamily2, letterSpacing2, textDecoration2, textAlign2, lineHeight2, overflow2, softWrap2, maxLines2, 1, (Function1<? super TextLayoutResult, Unit>) onTextLayout2, style2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | ($dirty & 57344) | ($dirty & 458752) | ($dirty & 3670016) | (29360128 & $dirty) | (234881024 & $dirty) | (1879048192 & $dirty), ($dirty1 & 14) | 24576 | ($dirty1 & 112) | ($dirty1 & 896) | ($dirty1 & 7168) | (($dirty1 << 3) & 458752) | (($dirty1 << 3) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextKt$Text$4(text, modifier2, color2, fontSize2, fontStyle2, fontWeight2, fontFamily2, letterSpacing2, textDecoration2, textAlign2, lineHeight2, overflow2, softWrap2, maxLines2, onTextLayout2, style2, $changed, $changed1, i));
        }
    }

    /* renamed from: Text-IbK3jfQ  reason: not valid java name */
    public static final void m1695TextIbK3jfQ(AnnotatedString text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, int minLines, Map<String, InlineTextContent> inlineContent, Function1<? super TextLayoutResult, Unit> onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i) {
        int i2;
        int i3;
        TextStyle style2;
        Function1 onTextLayout2;
        Map inlineContent2;
        int minLines2;
        int maxLines2;
        boolean softWrap2;
        int overflow2;
        long lineHeight2;
        TextAlign textAlign2;
        TextDecoration textDecoration2;
        long letterSpacing2;
        FontFamily fontFamily2;
        FontWeight fontWeight2;
        FontStyle fontStyle2;
        long lineHeight3;
        long color2;
        Modifier modifier2;
        long lineHeight4;
        long letterSpacing3;
        long fontSize2;
        long color3;
        FontFamily fontFamily3;
        Function1 onTextLayout3;
        int $dirty1;
        Map inlineContent3;
        FontWeight fontWeight3;
        int minLines3;
        FontStyle fontStyle3;
        int maxLines3;
        boolean softWrap3;
        TextAlign textAlign3;
        TextDecoration textDecoration3;
        Modifier modifier3;
        TextStyle style3;
        int overflow3;
        Map inlineContent4;
        long textColor;
        int i4;
        AnnotatedString annotatedString = text;
        int i5 = $changed;
        int i6 = $changed1;
        int i7 = i;
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Composer $composer2 = $composer.startRestartGroup(744129681);
        ComposerKt.sourceInformation($composer2, "C(Text)P(15,10,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,17,16:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,12:c#ui.text.style.TextOverflow,13,8,9)261@12187L7,283@12944L286:Text.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        if ((i7 & 1) != 0) {
            $dirty |= 6;
        } else if ((i5 & 14) == 0) {
            $dirty |= $composer2.changed((Object) annotatedString) ? 4 : 2;
        }
        int i8 = i7 & 2;
        if (i8 != 0) {
            $dirty |= 48;
            Modifier modifier4 = modifier;
        } else if ((i5 & 112) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier5 = modifier;
        }
        int i9 = i7 & 4;
        if (i9 != 0) {
            $dirty |= 384;
            long j = color;
        } else if ((i5 & 896) == 0) {
            $dirty |= $composer2.changed(color) ? 256 : 128;
        } else {
            long j2 = color;
        }
        int i10 = i7 & 8;
        int i11 = 2048;
        if (i10 != 0) {
            $dirty |= 3072;
            long j3 = fontSize;
        } else if ((i5 & 7168) == 0) {
            $dirty |= $composer2.changed(fontSize) ? 2048 : 1024;
        } else {
            long j4 = fontSize;
        }
        int i12 = i7 & 16;
        int i13 = 16384;
        if (i12 != 0) {
            $dirty |= 24576;
            FontStyle fontStyle4 = fontStyle;
        } else if ((i5 & 57344) == 0) {
            $dirty |= $composer2.changed((Object) fontStyle) ? 16384 : 8192;
        } else {
            FontStyle fontStyle5 = fontStyle;
        }
        int i14 = i7 & 32;
        if (i14 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            FontWeight fontWeight4 = fontWeight;
        } else if ((i5 & 458752) == 0) {
            $dirty |= $composer2.changed((Object) fontWeight) ? 131072 : 65536;
        } else {
            FontWeight fontWeight5 = fontWeight;
        }
        int i15 = i7 & 64;
        if (i15 != 0) {
            $dirty |= 1572864;
            FontFamily fontFamily4 = fontFamily;
        } else if ((i5 & 3670016) == 0) {
            $dirty |= $composer2.changed((Object) fontFamily) ? 1048576 : 524288;
        } else {
            FontFamily fontFamily5 = fontFamily;
        }
        int i16 = i7 & 128;
        if (i16 != 0) {
            $dirty |= 12582912;
            long j5 = letterSpacing;
        } else if ((i5 & 29360128) == 0) {
            $dirty |= $composer2.changed(letterSpacing) ? 8388608 : 4194304;
        } else {
            long j6 = letterSpacing;
        }
        int i17 = i7 & 256;
        if (i17 != 0) {
            $dirty |= 100663296;
            TextDecoration textDecoration4 = textDecoration;
        } else if ((234881024 & i5) == 0) {
            $dirty |= $composer2.changed((Object) textDecoration) ? 67108864 : 33554432;
        } else {
            TextDecoration textDecoration5 = textDecoration;
        }
        int i18 = i7 & 512;
        if (i18 != 0) {
            $dirty |= 805306368;
            TextAlign textAlign4 = textAlign;
        } else if ((i5 & 1879048192) == 0) {
            $dirty |= $composer2.changed((Object) textAlign) ? 536870912 : 268435456;
        } else {
            TextAlign textAlign5 = textAlign;
        }
        int $dirty2 = $dirty;
        int $dirty3 = i7 & 1024;
        if ($dirty3 != 0) {
            $dirty12 |= 6;
            i2 = i18;
            long j7 = lineHeight;
        } else if ((i6 & 14) == 0) {
            i2 = i18;
            $dirty12 |= $composer2.changed(lineHeight) ? 4 : 2;
        } else {
            i2 = i18;
            long j8 = lineHeight;
        }
        int i19 = i7 & 2048;
        if (i19 != 0) {
            $dirty12 |= 48;
            int i20 = overflow;
        } else if ((i6 & 112) == 0) {
            $dirty12 |= $composer2.changed(overflow) ? 32 : 16;
        } else {
            int i21 = overflow;
        }
        int i22 = i7 & 4096;
        if (i22 != 0) {
            $dirty12 |= 384;
            boolean z = softWrap;
        } else if ((i6 & 896) == 0) {
            $dirty12 |= $composer2.changed(softWrap) ? 256 : 128;
        } else {
            boolean z2 = softWrap;
        }
        int i23 = i7 & 8192;
        if (i23 != 0) {
            $dirty12 |= 3072;
            int i24 = maxLines;
        } else if ((i6 & 7168) == 0) {
            if (!$composer2.changed(maxLines)) {
                i11 = 1024;
            }
            $dirty12 |= i11;
        } else {
            int i25 = maxLines;
        }
        int i26 = i7 & 16384;
        if (i26 != 0) {
            $dirty12 |= 24576;
            int i27 = minLines;
        } else if ((i6 & 57344) == 0) {
            if (!$composer2.changed(minLines)) {
                i13 = 8192;
            }
            $dirty12 |= i13;
        } else {
            int i28 = minLines;
        }
        int i29 = i7 & 32768;
        if (i29 != 0) {
            $dirty12 |= 65536;
        }
        int i30 = i7 & 65536;
        if (i30 != 0) {
            $dirty12 |= 1572864;
            i3 = i26;
            Function1<? super TextLayoutResult, Unit> function1 = onTextLayout;
        } else if ((i6 & 3670016) == 0) {
            i3 = i26;
            $dirty12 |= $composer2.changedInstance(onTextLayout) ? 1048576 : 524288;
        } else {
            i3 = i26;
            Function1<? super TextLayoutResult, Unit> function12 = onTextLayout;
        }
        if ((i6 & 29360128) == 0) {
            if ((i7 & 131072) != 0) {
                TextStyle textStyle = style;
            } else if ($composer2.changed((Object) style)) {
                i4 = 8388608;
                $dirty12 |= i4;
            }
            i4 = 4194304;
            $dirty12 |= i4;
        } else {
            TextStyle textStyle2 = style;
        }
        if (i29 == 32768 && (1533916891 & $dirty2) == 306783378 && (23967451 & $dirty12) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            color2 = color;
            lineHeight3 = fontSize;
            fontStyle2 = fontStyle;
            fontWeight2 = fontWeight;
            fontFamily2 = fontFamily;
            letterSpacing2 = letterSpacing;
            textDecoration2 = textDecoration;
            textAlign2 = textAlign;
            lineHeight2 = lineHeight;
            overflow2 = overflow;
            softWrap2 = softWrap;
            maxLines2 = maxLines;
            minLines2 = minLines;
            inlineContent2 = inlineContent;
            onTextLayout2 = onTextLayout;
            style2 = style;
            int i31 = $dirty12;
        } else {
            $composer2.startDefaults();
            if ((i5 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i8 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i9 != 0) {
                    color3 = Color.Companion.m3200getUnspecified0d7_KjU();
                } else {
                    color3 = color;
                }
                if (i10 != 0) {
                    fontSize2 = TextUnit.Companion.m6178getUnspecifiedXSAIIZE();
                } else {
                    fontSize2 = fontSize;
                }
                if (i12 != 0) {
                    fontStyle3 = null;
                } else {
                    fontStyle3 = fontStyle;
                }
                if (i14 != 0) {
                    fontWeight3 = null;
                } else {
                    fontWeight3 = fontWeight;
                }
                if (i15 != 0) {
                    fontFamily3 = null;
                } else {
                    fontFamily3 = fontFamily;
                }
                if (i16 != 0) {
                    letterSpacing3 = TextUnit.Companion.m6178getUnspecifiedXSAIIZE();
                } else {
                    letterSpacing3 = letterSpacing;
                }
                if (i17 != 0) {
                    textDecoration3 = null;
                } else {
                    textDecoration3 = textDecoration;
                }
                if (i2 != 0) {
                    textAlign3 = null;
                } else {
                    textAlign3 = textAlign;
                }
                if ($dirty3 != 0) {
                    lineHeight4 = TextUnit.Companion.m6178getUnspecifiedXSAIIZE();
                } else {
                    lineHeight4 = lineHeight;
                }
                if (i19 != 0) {
                    overflow3 = TextOverflow.Companion.m5898getClipgIe3tQ8();
                } else {
                    overflow3 = overflow;
                }
                if (i22 != 0) {
                    softWrap3 = true;
                } else {
                    softWrap3 = softWrap;
                }
                if (i23 != 0) {
                    maxLines3 = Integer.MAX_VALUE;
                } else {
                    maxLines3 = maxLines;
                }
                if (i3 != 0) {
                    minLines3 = 1;
                } else {
                    minLines3 = minLines;
                }
                if (i29 != 0) {
                    inlineContent3 = MapsKt.emptyMap();
                } else {
                    inlineContent3 = inlineContent;
                }
                if (i30 != 0) {
                    onTextLayout3 = TextKt$Text$5.INSTANCE;
                } else {
                    onTextLayout3 = onTextLayout;
                }
                if ((i7 & 131072) != 0) {
                    int overflow4 = overflow3;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(LocalTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $dirty1 = $dirty12 & -29360129;
                    style3 = (TextStyle) consume;
                    overflow3 = overflow4;
                } else {
                    $dirty1 = $dirty12;
                    style3 = style;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i7 & 131072) != 0) {
                    int i32 = -29360129 & $dirty12;
                    modifier3 = modifier;
                    color3 = color;
                    fontSize2 = fontSize;
                    fontStyle3 = fontStyle;
                    fontWeight3 = fontWeight;
                    fontFamily3 = fontFamily;
                    letterSpacing3 = letterSpacing;
                    textDecoration3 = textDecoration;
                    textAlign3 = textAlign;
                    lineHeight4 = lineHeight;
                    softWrap3 = softWrap;
                    maxLines3 = maxLines;
                    minLines3 = minLines;
                    inlineContent3 = inlineContent;
                    onTextLayout3 = onTextLayout;
                    style3 = style;
                    $dirty1 = i32;
                    overflow3 = overflow;
                } else {
                    modifier3 = modifier;
                    color3 = color;
                    fontSize2 = fontSize;
                    fontStyle3 = fontStyle;
                    fontWeight3 = fontWeight;
                    fontFamily3 = fontFamily;
                    letterSpacing3 = letterSpacing;
                    textDecoration3 = textDecoration;
                    textAlign3 = textAlign;
                    lineHeight4 = lineHeight;
                    overflow3 = overflow;
                    softWrap3 = softWrap;
                    maxLines3 = maxLines;
                    minLines3 = minLines;
                    inlineContent3 = inlineContent;
                    onTextLayout3 = onTextLayout;
                    $dirty1 = $dirty12;
                    style3 = style;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                inlineContent4 = inlineContent3;
                ComposerKt.traceEventStart(744129681, $dirty2, $dirty1, "androidx.compose.material.Text (Text.kt:243)");
            } else {
                inlineContent4 = inlineContent3;
            }
            $composer2.startReplaceableGroup(1557619726);
            ComposerKt.sourceInformation($composer2, "*265@12301L7,265@12340L7");
            long $this$takeOrElse_u2dDxMtmZc$iv = color3;
            boolean z3 = true;
            if ($this$takeOrElse_u2dDxMtmZc$iv != Color.Companion.m3200getUnspecified0d7_KjU()) {
                textColor = $this$takeOrElse_u2dDxMtmZc$iv;
            } else {
                long $this$takeOrElse_u2dDxMtmZc$iv2 = style3.m5494getColor0d7_KjU();
                if ($this$takeOrElse_u2dDxMtmZc$iv2 == Color.Companion.m3200getUnspecified0d7_KjU()) {
                    z3 = false;
                }
                if (!z3) {
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer2.consume(ContentColorKt.getLocalContentColor());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    long r36 = ((Color) consume2).m3174unboximpl();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume3 = $composer2.consume(ContentAlphaKt.getLocalContentAlpha());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $this$takeOrElse_u2dDxMtmZc$iv2 = Color.m3163copywmQWz5c$default(r36, ((Number) consume3).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                }
                textColor = $this$takeOrElse_u2dDxMtmZc$iv2;
            }
            $composer2.endReplaceableGroup();
            BasicTextKt.m1125BasicTextVhcvRP8(text, modifier3, style3.merge(new TextStyle(textColor, fontSize2, fontWeight3, fontStyle3, (FontSynthesis) null, fontFamily3, (String) null, letterSpacing3, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, textDecoration3, (Shadow) null, textAlign3, (TextDirection) null, lineHeight4, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4108112, (DefaultConstructorMarker) null)), onTextLayout3, overflow3, softWrap3, maxLines3, minLines3, inlineContent4, $composer2, 134217728 | ($dirty2 & 14) | ($dirty2 & 112) | (($dirty1 >> 9) & 7168) | (($dirty1 << 9) & 57344) | (($dirty1 << 9) & 458752) | (($dirty1 << 9) & 3670016) | (($dirty1 << 9) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            inlineContent2 = inlineContent4;
            overflow2 = overflow3;
            style2 = style3;
            textDecoration2 = textDecoration3;
            textAlign2 = textAlign3;
            softWrap2 = softWrap3;
            maxLines2 = maxLines3;
            fontStyle2 = fontStyle3;
            minLines2 = minLines3;
            fontWeight2 = fontWeight3;
            int i33 = $dirty1;
            onTextLayout2 = onTextLayout3;
            fontFamily2 = fontFamily3;
            color2 = color3;
            letterSpacing2 = letterSpacing3;
            lineHeight2 = lineHeight4;
            modifier2 = modifier3;
            lineHeight3 = fontSize2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i34 = $dirty2;
            Composer composer = $composer2;
            return;
        }
        int i35 = $dirty2;
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new TextKt$Text$6(text, modifier2, color2, lineHeight3, fontStyle2, fontWeight2, fontFamily2, letterSpacing2, textDecoration2, textAlign2, lineHeight2, overflow2, softWrap2, maxLines2, minLines2, inlineContent2, onTextLayout2, style2, $changed, $changed1, i));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: androidx.compose.ui.text.TextStyle} */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text--4IGK_g  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m1693Text4IGK_g(androidx.compose.ui.text.AnnotatedString r51, androidx.compose.ui.Modifier r52, long r53, long r55, androidx.compose.ui.text.font.FontStyle r57, androidx.compose.ui.text.font.FontWeight r58, androidx.compose.ui.text.font.FontFamily r59, long r60, androidx.compose.ui.text.style.TextDecoration r62, androidx.compose.ui.text.style.TextAlign r63, long r64, int r66, boolean r67, int r68, java.util.Map r69, kotlin.jvm.functions.Function1 r70, androidx.compose.ui.text.TextStyle r71, androidx.compose.runtime.Composer r72, int r73, int r74, int r75) {
        /*
            r15 = r51
            r13 = r73
            r14 = r74
            r12 = r75
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = -422393234(0xffffffffe6d2ca6e, float:-4.9771557E23)
            r1 = r72
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12,8)318@14080L7,320@14096L345:Text.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r73
            r2 = r74
            r3 = r12 & 1
            if (r3 == 0) goto L_0x0027
            r1 = r1 | 6
            goto L_0x0035
        L_0x0027:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x0035
            boolean r3 = r11.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x0033
            r3 = 4
            goto L_0x0034
        L_0x0033:
            r3 = 2
        L_0x0034:
            r1 = r1 | r3
        L_0x0035:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x003e
            r1 = r1 | 48
            r8 = r52
            goto L_0x0053
        L_0x003e:
            r8 = r13 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0051
            r8 = r52
            boolean r9 = r11.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x004d
            r9 = 32
            goto L_0x004f
        L_0x004d:
            r9 = 16
        L_0x004f:
            r1 = r1 | r9
            goto L_0x0053
        L_0x0051:
            r8 = r52
        L_0x0053:
            r9 = r12 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x005e
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r53
            goto L_0x0074
        L_0x005e:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0072
            r5 = r53
            boolean r18 = r11.changed((long) r5)
            if (r18 == 0) goto L_0x006d
            r18 = 256(0x100, float:3.59E-43)
            goto L_0x006f
        L_0x006d:
            r18 = r16
        L_0x006f:
            r1 = r1 | r18
            goto L_0x0074
        L_0x0072:
            r5 = r53
        L_0x0074:
            r18 = r12 & 8
            r19 = 2048(0x800, float:2.87E-42)
            r20 = 1024(0x400, float:1.435E-42)
            if (r18 == 0) goto L_0x0081
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r55
            goto L_0x0097
        L_0x0081:
            r4 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0095
            r7 = r55
            boolean r22 = r11.changed((long) r7)
            if (r22 == 0) goto L_0x0090
            r22 = r19
            goto L_0x0092
        L_0x0090:
            r22 = r20
        L_0x0092:
            r1 = r1 | r22
            goto L_0x0097
        L_0x0095:
            r7 = r55
        L_0x0097:
            r22 = r12 & 16
            if (r22 == 0) goto L_0x00a0
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r10 = r57
            goto L_0x00b9
        L_0x00a0:
            r24 = 57344(0xe000, float:8.0356E-41)
            r24 = r13 & r24
            if (r24 != 0) goto L_0x00b7
            r10 = r57
            boolean r25 = r11.changed((java.lang.Object) r10)
            if (r25 == 0) goto L_0x00b2
            r25 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b4
        L_0x00b2:
            r25 = 8192(0x2000, float:1.14794E-41)
        L_0x00b4:
            r1 = r1 | r25
            goto L_0x00b9
        L_0x00b7:
            r10 = r57
        L_0x00b9:
            r25 = r12 & 32
            r26 = 458752(0x70000, float:6.42848E-40)
            r27 = 65536(0x10000, float:9.18355E-41)
            if (r25 == 0) goto L_0x00c8
            r28 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r28
            r0 = r58
            goto L_0x00de
        L_0x00c8:
            r28 = r13 & r26
            if (r28 != 0) goto L_0x00dc
            r0 = r58
            boolean r29 = r11.changed((java.lang.Object) r0)
            if (r29 == 0) goto L_0x00d7
            r29 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d9
        L_0x00d7:
            r29 = r27
        L_0x00d9:
            r1 = r1 | r29
            goto L_0x00de
        L_0x00dc:
            r0 = r58
        L_0x00de:
            r29 = r12 & 64
            r30 = 3670016(0x380000, float:5.142788E-39)
            if (r29 == 0) goto L_0x00eb
            r31 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r31
            r4 = r59
            goto L_0x0101
        L_0x00eb:
            r31 = r13 & r30
            if (r31 != 0) goto L_0x00ff
            r4 = r59
            boolean r32 = r11.changed((java.lang.Object) r4)
            if (r32 == 0) goto L_0x00fa
            r32 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fc
        L_0x00fa:
            r32 = 524288(0x80000, float:7.34684E-40)
        L_0x00fc:
            r1 = r1 | r32
            goto L_0x0101
        L_0x00ff:
            r4 = r59
        L_0x0101:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r32 = 29360128(0x1c00000, float:7.052966E-38)
            if (r0 == 0) goto L_0x010e
            r33 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r33
            r4 = r60
            goto L_0x0123
        L_0x010e:
            r33 = r13 & r32
            if (r33 != 0) goto L_0x0121
            r4 = r60
            boolean r6 = r11.changed((long) r4)
            if (r6 == 0) goto L_0x011d
            r6 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x011f
        L_0x011d:
            r6 = 4194304(0x400000, float:5.877472E-39)
        L_0x011f:
            r1 = r1 | r6
            goto L_0x0123
        L_0x0121:
            r4 = r60
        L_0x0123:
            r6 = r12 & 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x012e
            r33 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r33
            r4 = r62
            goto L_0x0145
        L_0x012e:
            r33 = 234881024(0xe000000, float:1.5777218E-30)
            r33 = r13 & r33
            if (r33 != 0) goto L_0x0143
            r4 = r62
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x013f
            r5 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0141
        L_0x013f:
            r5 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0141:
            r1 = r1 | r5
            goto L_0x0145
        L_0x0143:
            r4 = r62
        L_0x0145:
            r5 = r12 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x0150
            r33 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r33
            r4 = r63
            goto L_0x0168
        L_0x0150:
            r33 = 1879048192(0x70000000, float:1.58456325E29)
            r33 = r13 & r33
            if (r33 != 0) goto L_0x0166
            r4 = r63
            boolean r33 = r11.changed((java.lang.Object) r4)
            if (r33 == 0) goto L_0x0161
            r33 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0163
        L_0x0161:
            r33 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0163:
            r1 = r1 | r33
            goto L_0x0168
        L_0x0166:
            r4 = r63
        L_0x0168:
            r4 = r12 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x0171
            r2 = r2 | 6
            r7 = r64
            goto L_0x0187
        L_0x0171:
            r33 = r14 & 14
            if (r33 != 0) goto L_0x0185
            r7 = r64
            boolean r33 = r11.changed((long) r7)
            if (r33 == 0) goto L_0x0180
            r21 = 4
            goto L_0x0182
        L_0x0180:
            r21 = 2
        L_0x0182:
            r2 = r2 | r21
            goto L_0x0187
        L_0x0185:
            r7 = r64
        L_0x0187:
            r7 = r12 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x0190
            r2 = r2 | 48
            r8 = r66
            goto L_0x01a6
        L_0x0190:
            r8 = r14 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x01a4
            r8 = r66
            boolean r21 = r11.changed((int) r8)
            if (r21 == 0) goto L_0x019f
            r23 = 32
            goto L_0x01a1
        L_0x019f:
            r23 = 16
        L_0x01a1:
            r2 = r2 | r23
            goto L_0x01a6
        L_0x01a4:
            r8 = r66
        L_0x01a6:
            r8 = r12 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x01af
            r2 = r2 | 384(0x180, float:5.38E-43)
            r10 = r67
            goto L_0x01c5
        L_0x01af:
            r10 = r14 & 896(0x380, float:1.256E-42)
            if (r10 != 0) goto L_0x01c3
            r10 = r67
            boolean r17 = r11.changed((boolean) r10)
            if (r17 == 0) goto L_0x01be
            r24 = 256(0x100, float:3.59E-43)
            goto L_0x01c0
        L_0x01be:
            r24 = r16
        L_0x01c0:
            r2 = r2 | r24
            goto L_0x01c5
        L_0x01c3:
            r10 = r67
        L_0x01c5:
            r10 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r10 == 0) goto L_0x01ce
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r15 = r68
            goto L_0x01e2
        L_0x01ce:
            r15 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r15 != 0) goto L_0x01e0
            r15 = r68
            boolean r16 = r11.changed((int) r15)
            if (r16 == 0) goto L_0x01db
            goto L_0x01dd
        L_0x01db:
            r19 = r20
        L_0x01dd:
            r2 = r2 | r19
            goto L_0x01e2
        L_0x01e0:
            r15 = r68
        L_0x01e2:
            r15 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r15 == 0) goto L_0x01e8
            r2 = r2 | 8192(0x2000, float:1.14794E-41)
        L_0x01e8:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r12 & r16
            if (r16 == 0) goto L_0x01f8
            r17 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r17
            r17 = r10
            r10 = r70
            goto L_0x0212
        L_0x01f8:
            r17 = r14 & r26
            if (r17 != 0) goto L_0x020e
            r17 = r10
            r10 = r70
            boolean r19 = r11.changedInstance(r10)
            if (r19 == 0) goto L_0x0209
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x020b
        L_0x0209:
            r19 = r27
        L_0x020b:
            r2 = r2 | r19
            goto L_0x0212
        L_0x020e:
            r17 = r10
            r10 = r70
        L_0x0212:
            r19 = r14 & r30
            if (r19 != 0) goto L_0x022c
            r19 = r12 & r27
            if (r19 != 0) goto L_0x0225
            r10 = r71
            boolean r19 = r11.changed((java.lang.Object) r10)
            if (r19 == 0) goto L_0x0227
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0229
        L_0x0225:
            r10 = r71
        L_0x0227:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x0229:
            r2 = r2 | r19
            goto L_0x022e
        L_0x022c:
            r10 = r71
        L_0x022e:
            r10 = 16384(0x4000, float:2.2959E-41)
            if (r15 != r10) goto L_0x0276
            r10 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r10 = r10 & r1
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r10 != r14) goto L_0x0276
            r10 = 2995931(0x2db6db, float:4.198194E-39)
            r10 = r10 & r2
            r14 = 599186(0x92492, float:8.39638E-40)
            if (r10 != r14) goto L_0x0276
            boolean r10 = r11.getSkipping()
            if (r10 != 0) goto L_0x024b
            goto L_0x0276
        L_0x024b:
            r11.skipToGroupEnd()
            r27 = r52
            r33 = r53
            r35 = r55
            r29 = r57
            r31 = r58
            r37 = r59
            r38 = r60
            r40 = r62
            r41 = r63
            r42 = r64
            r44 = r66
            r45 = r67
            r46 = r68
            r47 = r69
            r48 = r70
            r49 = r71
            r26 = r1
            r30 = r2
            r28 = r11
            goto L_0x045f
        L_0x0276:
            r11.startDefaults()
            r10 = r13 & 1
            if (r10 == 0) goto L_0x02d5
            boolean r10 = r11.getDefaultsInvalid()
            if (r10 == 0) goto L_0x0284
            goto L_0x02d5
        L_0x0284:
            r11.skipToGroupEnd()
            r0 = r12 & r27
            if (r0 == 0) goto L_0x02b2
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r0 = r0 & r2
            r27 = r52
            r33 = r53
            r35 = r55
            r29 = r57
            r31 = r58
            r37 = r59
            r38 = r60
            r40 = r62
            r41 = r63
            r42 = r64
            r44 = r66
            r45 = r67
            r46 = r68
            r47 = r69
            r48 = r70
            r49 = r71
            r15 = r0
            goto L_0x03c8
        L_0x02b2:
            r27 = r52
            r33 = r53
            r35 = r55
            r29 = r57
            r31 = r58
            r37 = r59
            r38 = r60
            r40 = r62
            r41 = r63
            r42 = r64
            r44 = r66
            r45 = r67
            r46 = r68
            r47 = r69
            r48 = r70
            r49 = r71
            r15 = r2
            goto L_0x03c8
        L_0x02d5:
            if (r3 == 0) goto L_0x02dc
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x02de
        L_0x02dc:
            r3 = r52
        L_0x02de:
            if (r9 == 0) goto L_0x02e7
            androidx.compose.ui.graphics.Color$Companion r9 = androidx.compose.ui.graphics.Color.Companion
            long r9 = r9.m3200getUnspecified0d7_KjU()
            goto L_0x02e9
        L_0x02e7:
            r9 = r53
        L_0x02e9:
            if (r18 == 0) goto L_0x02f2
            androidx.compose.ui.unit.TextUnit$Companion r14 = androidx.compose.ui.unit.TextUnit.Companion
            long r18 = r14.m6178getUnspecifiedXSAIIZE()
            goto L_0x02f4
        L_0x02f2:
            r18 = r55
        L_0x02f4:
            if (r22 == 0) goto L_0x02f8
            r14 = 0
            goto L_0x02fa
        L_0x02f8:
            r14 = r57
        L_0x02fa:
            if (r25 == 0) goto L_0x02ff
            r20 = 0
            goto L_0x0301
        L_0x02ff:
            r20 = r58
        L_0x0301:
            if (r29 == 0) goto L_0x0306
            r21 = 0
            goto L_0x0308
        L_0x0306:
            r21 = r59
        L_0x0308:
            if (r0 == 0) goto L_0x0311
            androidx.compose.ui.unit.TextUnit$Companion r0 = androidx.compose.ui.unit.TextUnit.Companion
            long r22 = r0.m6178getUnspecifiedXSAIIZE()
            goto L_0x0313
        L_0x0311:
            r22 = r60
        L_0x0313:
            if (r6 == 0) goto L_0x0317
            r0 = 0
            goto L_0x0319
        L_0x0317:
            r0 = r62
        L_0x0319:
            if (r5 == 0) goto L_0x031d
            r5 = 0
            goto L_0x031f
        L_0x031d:
            r5 = r63
        L_0x031f:
            if (r4 == 0) goto L_0x0328
            androidx.compose.ui.unit.TextUnit$Companion r4 = androidx.compose.ui.unit.TextUnit.Companion
            long r24 = r4.m6178getUnspecifiedXSAIIZE()
            goto L_0x032a
        L_0x0328:
            r24 = r64
        L_0x032a:
            if (r7 == 0) goto L_0x0333
            androidx.compose.ui.text.style.TextOverflow$Companion r4 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r4 = r4.m5898getClipgIe3tQ8()
            goto L_0x0335
        L_0x0333:
            r4 = r66
        L_0x0335:
            if (r8 == 0) goto L_0x0339
            r6 = 1
            goto L_0x033b
        L_0x0339:
            r6 = r67
        L_0x033b:
            if (r17 == 0) goto L_0x0341
            r7 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0343
        L_0x0341:
            r7 = r68
        L_0x0343:
            if (r15 == 0) goto L_0x034a
            java.util.Map r8 = kotlin.collections.MapsKt.emptyMap()
            goto L_0x034c
        L_0x034a:
            r8 = r69
        L_0x034c:
            if (r16 == 0) goto L_0x0353
            androidx.compose.material.TextKt$Text$7 r15 = androidx.compose.material.TextKt$Text$7.INSTANCE
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            goto L_0x0355
        L_0x0353:
            r15 = r70
        L_0x0355:
            r16 = r12 & r27
            if (r16 == 0) goto L_0x03a1
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.text.TextStyle> r16 = LocalTextStyle
            r52 = r0
            r0 = r16
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r16 = 6
            r17 = 0
            r72 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            r53 = r4
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r3, r4)
            java.lang.Object r3 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r0 = r3
            androidx.compose.ui.text.TextStyle r0 = (androidx.compose.ui.text.TextStyle) r0
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r2 = r2 & r3
            r40 = r52
            r44 = r53
            r27 = r72
            r49 = r0
            r41 = r5
            r45 = r6
            r46 = r7
            r47 = r8
            r33 = r9
            r29 = r14
            r48 = r15
            r35 = r18
            r31 = r20
            r37 = r21
            r38 = r22
            r42 = r24
            r15 = r2
            goto L_0x03c8
        L_0x03a1:
            r52 = r0
            r72 = r3
            r53 = r4
            r40 = r52
            r44 = r53
            r49 = r71
            r27 = r72
            r41 = r5
            r45 = r6
            r46 = r7
            r47 = r8
            r33 = r9
            r29 = r14
            r48 = r15
            r35 = r18
            r31 = r20
            r37 = r21
            r38 = r22
            r42 = r24
            r15 = r2
        L_0x03c8:
            r11.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03d9
            java.lang.String r0 = "androidx.compose.material.Text (Text.kt:301)"
            r2 = -422393234(0xffffffffe6d2ca6e, float:-4.9771557E23)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r15, r0)
        L_0x03d9:
            r18 = 1
            r0 = r1 & 14
            r2 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r2 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r2 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = r1 & r26
            r0 = r0 | r2
            r2 = r1 & r30
            r0 = r0 | r2
            r2 = r1 & r32
            r0 = r0 | r2
            r2 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r1
            r23 = r0 | r2
            r0 = 286720(0x46000, float:4.0178E-40)
            r2 = r15 & 14
            r0 = r0 | r2
            r2 = r15 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r2 = r15 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r2 = r15 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r15 << 3
            r2 = r2 & r30
            r0 = r0 | r2
            int r2 = r15 << 3
            r2 = r2 & r32
            r24 = r0 | r2
            r25 = 0
            r0 = r51
            r26 = r1
            r1 = r27
            r2 = r33
            r4 = r35
            r6 = r29
            r7 = r31
            r8 = r37
            r9 = r38
            r28 = r11
            r11 = r40
            r12 = r41
            r13 = r42
            r30 = r15
            r15 = r44
            r16 = r45
            r17 = r46
            r19 = r47
            r20 = r48
            r21 = r49
            r22 = r28
            m1695TextIbK3jfQ(r0, r1, r2, r4, r6, r7, r8, r9, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x045f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x045f:
            androidx.compose.runtime.ScopeUpdateScope r14 = r28.endRestartGroup()
            if (r14 != 0) goto L_0x0466
            goto L_0x04a0
        L_0x0466:
            androidx.compose.material.TextKt$Text$8 r25 = new androidx.compose.material.TextKt$Text$8
            r0 = r25
            r1 = r51
            r2 = r27
            r3 = r33
            r5 = r35
            r7 = r29
            r8 = r31
            r9 = r37
            r10 = r38
            r12 = r40
            r13 = r41
            r50 = r14
            r14 = r42
            r16 = r44
            r17 = r45
            r18 = r46
            r19 = r47
            r20 = r48
            r21 = r49
            r22 = r73
            r23 = r74
            r24 = r75
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r0 = r25
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r50
            r1.updateScope(r0)
        L_0x04a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m1693Text4IGK_g(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    public static final void ProvideTextStyle(TextStyle value, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(1772272796);
        ComposerKt.sourceInformation($composer2, "C(ProvideTextStyle)P(1)361@15397L7,362@15422L80:Text.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) value) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1772272796, $dirty, -1, "androidx.compose.material.ProvideTextStyle (Text.kt:360)");
            }
            ProvidableCompositionLocal<TextStyle> this_$iv = LocalTextStyle;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{this_$iv.provides(((TextStyle) consume).merge(value))}, content, $composer2, ($dirty & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextKt$ProvideTextStyle$1(value, content, $changed));
        }
    }
}
