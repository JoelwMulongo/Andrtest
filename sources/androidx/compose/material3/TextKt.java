package androidx.compose.material3;

import androidx.compose.foundation.text.BasicTextKt;
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
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aß\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(2\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060,2\b\b\u0002\u0010.\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100\u001aÉ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020)2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060,2\b\b\u0002\u0010.\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00063"}, d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Text.kt */
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), TextKt$LocalTextStyle$1.INSTANCE);

    /* renamed from: Text-fLXpl1I  reason: not valid java name */
    public static final void m2178TextfLXpl1I(String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Function1<? super TextLayoutResult, Unit> onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i) {
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
        FontStyle fontStyle2;
        long fontSize2;
        long color2;
        Modifier modifier2;
        long lineHeight3;
        long letterSpacing3;
        FontFamily fontFamily3;
        FontWeight fontWeight3;
        long fontSize3;
        long color3;
        int $dirty1;
        FontStyle fontStyle3;
        Function1 onTextLayout3;
        int maxLines3;
        boolean softWrap3;
        TextAlign textAlign3;
        int overflow3;
        TextStyle style3;
        TextDecoration textDecoration3;
        Modifier modifier3;
        long color4;
        long textColor;
        Modifier modifier4;
        TextDecoration textDecoration4;
        int i3;
        String str = text;
        int i4 = $changed;
        int i5 = $changed1;
        int i6 = i;
        Intrinsics.checkNotNullParameter(str, "text");
        Composer $composer2 = $composer.startRestartGroup(1968784669);
        ComposerKt.sourceInformation($composer2, "C(Text)P(13,8,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,15,14:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,10:c#ui.text.style.TextOverflow,11)104@5368L7,127@6086L145:Text.kt#uh7d8r");
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
            Modifier modifier5 = modifier;
        } else if ((i4 & 112) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier6 = modifier;
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
            TextDecoration textDecoration5 = textDecoration;
        } else if ((i4 & 234881024) == 0) {
            $dirty |= $composer2.changed((Object) textDecoration) ? 67108864 : 33554432;
        } else {
            TextDecoration textDecoration6 = textDecoration;
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
        int i18 = i6 & 1024;
        if (i18 != 0) {
            $dirty12 |= 6;
            long j7 = lineHeight;
        } else if ((i5 & 14) == 0) {
            $dirty12 |= $composer2.changed(lineHeight) ? 4 : 2;
        } else {
            long j8 = lineHeight;
        }
        int i19 = i6 & 2048;
        if (i19 != 0) {
            $dirty12 |= 48;
            int i20 = overflow;
        } else if ((i5 & 112) == 0) {
            $dirty12 |= $composer2.changed(overflow) ? 32 : 16;
        } else {
            int i21 = overflow;
        }
        int i22 = i6 & 4096;
        if (i22 != 0) {
            $dirty12 |= 384;
            boolean z = softWrap;
        } else if ((i5 & 896) == 0) {
            $dirty12 |= $composer2.changed(softWrap) ? 256 : 128;
        } else {
            boolean z2 = softWrap;
        }
        int i23 = i6 & 8192;
        if (i23 != 0) {
            $dirty12 |= 3072;
            int i24 = maxLines;
        } else if ((i5 & 7168) == 0) {
            if (!$composer2.changed(maxLines)) {
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
            Function1<? super TextLayoutResult, Unit> function1 = onTextLayout;
        } else if ((i5 & 57344) == 0) {
            i2 = i26;
            if (!$composer2.changed((Object) onTextLayout)) {
                i12 = 8192;
            }
            $dirty12 |= i12;
        } else {
            i2 = i26;
            Function1<? super TextLayoutResult, Unit> function12 = onTextLayout;
        }
        if ((i5 & 458752) == 0) {
            if ((i6 & 32768) != 0) {
                TextStyle textStyle = style;
            } else if ($composer2.changed((Object) style)) {
                i3 = 131072;
                $dirty12 |= i3;
            }
            i3 = 65536;
            $dirty12 |= i3;
        } else {
            TextStyle textStyle2 = style;
        }
        if (($dirty & 1533916891) == 306783378 && (374491 & $dirty12) == 74898 && $composer2.getSkipping()) {
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
            onTextLayout2 = onTextLayout;
            style2 = style;
            int i27 = $dirty12;
        } else {
            $composer2.startDefaults();
            if ((i4 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i7 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier;
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
                    textDecoration4 = null;
                } else {
                    textDecoration4 = textDecoration;
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
                    onTextLayout3 = TextKt$Text$1.INSTANCE;
                } else {
                    onTextLayout3 = onTextLayout;
                }
                if ((i6 & 32768) != 0) {
                    TextDecoration textDecoration7 = textDecoration4;
                    Modifier modifier7 = modifier4;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(LocalTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    style3 = (TextStyle) consume;
                    $dirty1 = $dirty12 & -458753;
                    textDecoration3 = textDecoration7;
                    modifier3 = modifier7;
                } else {
                    TextDecoration textDecoration8 = textDecoration4;
                    Modifier modifier8 = modifier4;
                    style3 = style;
                    modifier3 = modifier8;
                    $dirty1 = $dirty12;
                    textDecoration3 = textDecoration8;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i6 & 32768) != 0) {
                    int i28 = -458753 & $dirty12;
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
                    onTextLayout3 = onTextLayout;
                    style3 = style;
                    $dirty1 = i28;
                    modifier3 = modifier;
                } else {
                    modifier3 = modifier;
                    color3 = color;
                    fontSize3 = fontSize;
                    fontStyle3 = fontStyle;
                    fontWeight3 = fontWeight;
                    fontFamily3 = fontFamily;
                    letterSpacing3 = letterSpacing;
                    textAlign3 = textAlign;
                    lineHeight3 = lineHeight;
                    overflow3 = overflow;
                    softWrap3 = softWrap;
                    maxLines3 = maxLines;
                    onTextLayout3 = onTextLayout;
                    style3 = style;
                    $dirty1 = $dirty12;
                    textDecoration3 = textDecoration;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1968784669, $dirty, $dirty1, "androidx.compose.material3.Text (Text.kt:88)");
            }
            $composer2.startReplaceableGroup(79582607);
            ComposerKt.sourceInformation($composer2, "*109@5483L7");
            long $this$takeOrElse_u2dDxMtmZc$iv = color3;
            boolean z3 = true;
            if ($this$takeOrElse_u2dDxMtmZc$iv != Color.Companion.m3200getUnspecified0d7_KjU()) {
                color4 = color3;
                textColor = $this$takeOrElse_u2dDxMtmZc$iv;
            } else {
                long $this$takeOrElse_u2dDxMtmZc$iv2 = style3.m5494getColor0d7_KjU();
                if ($this$takeOrElse_u2dDxMtmZc$iv2 == Color.Companion.m3200getUnspecified0d7_KjU()) {
                    z3 = false;
                }
                if (z3) {
                    color4 = color3;
                } else {
                    color4 = color3;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer2.consume(ContentColorKt.getLocalContentColor());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $this$takeOrElse_u2dDxMtmZc$iv2 = ((Color) consume2).m3174unboximpl();
                }
                textColor = $this$takeOrElse_u2dDxMtmZc$iv2;
            }
            $composer2.endReplaceableGroup();
            BasicTextKt.m1124BasicTextBpD7jsM(text, modifier3, style3.merge(new TextStyle(textColor, fontSize3, fontWeight3, fontStyle3, (FontSynthesis) null, fontFamily3, (String) null, letterSpacing3, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, textDecoration3, (Shadow) null, textAlign3, (TextDirection) null, lineHeight3, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), onTextLayout3, overflow3, softWrap3, maxLines3, $composer2, ($dirty & 14) | ($dirty & 112) | (($dirty1 >> 3) & 7168) | (($dirty1 << 9) & 57344) | (($dirty1 << 9) & 458752) | (3670016 & ($dirty1 << 9)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            textDecoration2 = textDecoration3;
            style2 = style3;
            overflow2 = overflow3;
            textAlign2 = textAlign3;
            softWrap2 = softWrap3;
            maxLines2 = maxLines3;
            onTextLayout2 = onTextLayout3;
            fontStyle2 = fontStyle3;
            int i29 = $dirty1;
            fontWeight2 = fontWeight3;
            fontFamily2 = fontFamily3;
            letterSpacing2 = letterSpacing3;
            lineHeight2 = lineHeight3;
            color2 = color4;
            fontSize2 = fontSize3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i30 = $dirty;
            Composer composer = $composer2;
            return;
        }
        int i31 = $dirty;
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new TextKt$Text$2(text, modifier2, color2, fontSize2, fontStyle2, fontWeight2, fontFamily2, letterSpacing2, textDecoration2, textAlign2, lineHeight2, overflow2, softWrap2, maxLines2, onTextLayout2, style2, $changed, $changed1, i));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: androidx.compose.ui.text.TextStyle} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: Text--4IGK_g  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2177Text4IGK_g(androidx.compose.ui.text.AnnotatedString r58, androidx.compose.ui.Modifier r59, long r60, long r62, androidx.compose.ui.text.font.FontStyle r64, androidx.compose.ui.text.font.FontWeight r65, androidx.compose.ui.text.font.FontFamily r66, long r67, androidx.compose.ui.text.style.TextDecoration r69, androidx.compose.ui.text.style.TextAlign r70, long r71, int r73, boolean r74, int r75, java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r76, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r77, androidx.compose.ui.text.TextStyle r78, androidx.compose.runtime.Composer r79, int r80, int r81, int r82) {
        /*
            r14 = r58
            r15 = r80
            r13 = r81
            r12 = r82
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 224529679(0xd620d0f, float:6.9657345E-31)
            r1 = r79
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12,8)206@10226L7,228@10943L167:Text.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r80
            r2 = r81
            r3 = r12 & 1
            if (r3 == 0) goto L_0x0027
            r1 = r1 | 6
            goto L_0x0035
        L_0x0027:
            r3 = r15 & 14
            if (r3 != 0) goto L_0x0035
            boolean r3 = r10.changed((java.lang.Object) r14)
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
            r8 = r59
            goto L_0x0053
        L_0x003e:
            r8 = r15 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0051
            r8 = r59
            boolean r9 = r10.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x004d
            r9 = 32
            goto L_0x004f
        L_0x004d:
            r9 = 16
        L_0x004f:
            r1 = r1 | r9
            goto L_0x0053
        L_0x0051:
            r8 = r59
        L_0x0053:
            r9 = r12 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x005e
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r60
            goto L_0x0074
        L_0x005e:
            r4 = r15 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0072
            r5 = r60
            boolean r18 = r10.changed((long) r5)
            if (r18 == 0) goto L_0x006d
            r18 = 256(0x100, float:3.59E-43)
            goto L_0x006f
        L_0x006d:
            r18 = r16
        L_0x006f:
            r1 = r1 | r18
            goto L_0x0074
        L_0x0072:
            r5 = r60
        L_0x0074:
            r18 = r12 & 8
            r19 = 2048(0x800, float:2.87E-42)
            r20 = 1024(0x400, float:1.435E-42)
            if (r18 == 0) goto L_0x0081
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r62
            goto L_0x0097
        L_0x0081:
            r4 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0095
            r7 = r62
            boolean r22 = r10.changed((long) r7)
            if (r22 == 0) goto L_0x0090
            r22 = r19
            goto L_0x0092
        L_0x0090:
            r22 = r20
        L_0x0092:
            r1 = r1 | r22
            goto L_0x0097
        L_0x0095:
            r7 = r62
        L_0x0097:
            r22 = r12 & 16
            if (r22 == 0) goto L_0x00a0
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r11 = r64
            goto L_0x00b9
        L_0x00a0:
            r24 = 57344(0xe000, float:8.0356E-41)
            r24 = r15 & r24
            if (r24 != 0) goto L_0x00b7
            r11 = r64
            boolean r25 = r10.changed((java.lang.Object) r11)
            if (r25 == 0) goto L_0x00b2
            r25 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b4
        L_0x00b2:
            r25 = 8192(0x2000, float:1.14794E-41)
        L_0x00b4:
            r1 = r1 | r25
            goto L_0x00b9
        L_0x00b7:
            r11 = r64
        L_0x00b9:
            r25 = r12 & 32
            r26 = 458752(0x70000, float:6.42848E-40)
            r27 = 65536(0x10000, float:9.18355E-41)
            if (r25 == 0) goto L_0x00c8
            r28 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r28
            r0 = r65
            goto L_0x00de
        L_0x00c8:
            r28 = r15 & r26
            if (r28 != 0) goto L_0x00dc
            r0 = r65
            boolean r29 = r10.changed((java.lang.Object) r0)
            if (r29 == 0) goto L_0x00d7
            r29 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d9
        L_0x00d7:
            r29 = r27
        L_0x00d9:
            r1 = r1 | r29
            goto L_0x00de
        L_0x00dc:
            r0 = r65
        L_0x00de:
            r29 = r12 & 64
            r30 = 3670016(0x380000, float:5.142788E-39)
            if (r29 == 0) goto L_0x00eb
            r31 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r31
            r4 = r66
            goto L_0x0101
        L_0x00eb:
            r31 = r15 & r30
            if (r31 != 0) goto L_0x00ff
            r4 = r66
            boolean r32 = r10.changed((java.lang.Object) r4)
            if (r32 == 0) goto L_0x00fa
            r32 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fc
        L_0x00fa:
            r32 = 524288(0x80000, float:7.34684E-40)
        L_0x00fc:
            r1 = r1 | r32
            goto L_0x0101
        L_0x00ff:
            r4 = r66
        L_0x0101:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x010c
            r32 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r32
            r4 = r67
            goto L_0x0123
        L_0x010c:
            r32 = 29360128(0x1c00000, float:7.052966E-38)
            r32 = r15 & r32
            if (r32 != 0) goto L_0x0121
            r4 = r67
            boolean r6 = r10.changed((long) r4)
            if (r6 == 0) goto L_0x011d
            r6 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x011f
        L_0x011d:
            r6 = 4194304(0x400000, float:5.877472E-39)
        L_0x011f:
            r1 = r1 | r6
            goto L_0x0123
        L_0x0121:
            r4 = r67
        L_0x0123:
            r6 = r12 & 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x012e
            r32 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r32
            r4 = r69
            goto L_0x0145
        L_0x012e:
            r32 = 234881024(0xe000000, float:1.5777218E-30)
            r32 = r15 & r32
            if (r32 != 0) goto L_0x0143
            r4 = r69
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x013f
            r5 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0141
        L_0x013f:
            r5 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0141:
            r1 = r1 | r5
            goto L_0x0145
        L_0x0143:
            r4 = r69
        L_0x0145:
            r5 = r12 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x0150
            r32 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r32
            r4 = r70
            goto L_0x0168
        L_0x0150:
            r32 = 1879048192(0x70000000, float:1.58456325E29)
            r32 = r15 & r32
            if (r32 != 0) goto L_0x0166
            r4 = r70
            boolean r32 = r10.changed((java.lang.Object) r4)
            if (r32 == 0) goto L_0x0161
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0163
        L_0x0161:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0163:
            r1 = r1 | r32
            goto L_0x0168
        L_0x0166:
            r4 = r70
        L_0x0168:
            r4 = r12 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x0171
            r2 = r2 | 6
            r7 = r71
            goto L_0x0187
        L_0x0171:
            r32 = r13 & 14
            if (r32 != 0) goto L_0x0185
            r7 = r71
            boolean r32 = r10.changed((long) r7)
            if (r32 == 0) goto L_0x0180
            r21 = 4
            goto L_0x0182
        L_0x0180:
            r21 = 2
        L_0x0182:
            r2 = r2 | r21
            goto L_0x0187
        L_0x0185:
            r7 = r71
        L_0x0187:
            r7 = r12 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x0190
            r2 = r2 | 48
            r8 = r73
            goto L_0x01a6
        L_0x0190:
            r8 = r13 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x01a4
            r8 = r73
            boolean r21 = r10.changed((int) r8)
            if (r21 == 0) goto L_0x019f
            r23 = 32
            goto L_0x01a1
        L_0x019f:
            r23 = 16
        L_0x01a1:
            r2 = r2 | r23
            goto L_0x01a6
        L_0x01a4:
            r8 = r73
        L_0x01a6:
            r8 = r12 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x01af
            r2 = r2 | 384(0x180, float:5.38E-43)
            r11 = r74
            goto L_0x01c5
        L_0x01af:
            r11 = r13 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x01c3
            r11 = r74
            boolean r17 = r10.changed((boolean) r11)
            if (r17 == 0) goto L_0x01be
            r24 = 256(0x100, float:3.59E-43)
            goto L_0x01c0
        L_0x01be:
            r24 = r16
        L_0x01c0:
            r2 = r2 | r24
            goto L_0x01c5
        L_0x01c3:
            r11 = r74
        L_0x01c5:
            r11 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r11 == 0) goto L_0x01ce
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r14 = r75
            goto L_0x01e2
        L_0x01ce:
            r14 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r14 != 0) goto L_0x01e0
            r14 = r75
            boolean r16 = r10.changed((int) r14)
            if (r16 == 0) goto L_0x01db
            goto L_0x01dd
        L_0x01db:
            r19 = r20
        L_0x01dd:
            r2 = r2 | r19
            goto L_0x01e2
        L_0x01e0:
            r14 = r75
        L_0x01e2:
            r14 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r14 == 0) goto L_0x01e8
            r2 = r2 | 8192(0x2000, float:1.14794E-41)
        L_0x01e8:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r12 & r16
            if (r16 == 0) goto L_0x01f8
            r17 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r17
            r17 = r11
            r11 = r77
            goto L_0x0212
        L_0x01f8:
            r17 = r13 & r26
            if (r17 != 0) goto L_0x020e
            r17 = r11
            r11 = r77
            boolean r19 = r10.changed((java.lang.Object) r11)
            if (r19 == 0) goto L_0x0209
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x020b
        L_0x0209:
            r19 = r27
        L_0x020b:
            r2 = r2 | r19
            goto L_0x0212
        L_0x020e:
            r17 = r11
            r11 = r77
        L_0x0212:
            r19 = r13 & r30
            if (r19 != 0) goto L_0x022c
            r19 = r12 & r27
            if (r19 != 0) goto L_0x0225
            r11 = r78
            boolean r19 = r10.changed((java.lang.Object) r11)
            if (r19 == 0) goto L_0x0227
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0229
        L_0x0225:
            r11 = r78
        L_0x0227:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x0229:
            r2 = r2 | r19
            goto L_0x022e
        L_0x022c:
            r11 = r78
        L_0x022e:
            r11 = 16384(0x4000, float:2.2959E-41)
            if (r14 != r11) goto L_0x0274
            r11 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r11 = r11 & r1
            r13 = 306783378(0x12492492, float:6.3469493E-28)
            if (r11 != r13) goto L_0x0274
            r11 = 2995931(0x2db6db, float:4.198194E-39)
            r11 = r11 & r2
            r13 = 599186(0x92492, float:8.39638E-40)
            if (r11 != r13) goto L_0x0274
            boolean r11 = r10.getSkipping()
            if (r11 != 0) goto L_0x024b
            goto L_0x0274
        L_0x024b:
            r10.skipToGroupEnd()
            r25 = r59
            r26 = r60
            r28 = r62
            r30 = r64
            r31 = r65
            r32 = r66
            r33 = r67
            r35 = r69
            r36 = r70
            r37 = r71
            r39 = r73
            r40 = r74
            r41 = r75
            r42 = r76
            r43 = r77
            r44 = r78
            r79 = r1
            r45 = r2
            goto L_0x04ea
        L_0x0274:
            r10.startDefaults()
            r11 = r15 & 1
            if (r11 == 0) goto L_0x02da
            boolean r11 = r10.getDefaultsInvalid()
            if (r11 == 0) goto L_0x0283
            goto L_0x02da
        L_0x0283:
            r10.skipToGroupEnd()
            if (r14 == 0) goto L_0x028c
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r2 = r2 & r0
        L_0x028c:
            r0 = r12 & r27
            if (r0 == 0) goto L_0x02b7
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r0 = r0 & r2
            r19 = r60
            r23 = r62
            r9 = r64
            r11 = r65
            r13 = r66
            r21 = r67
            r2 = r69
            r5 = r70
            r3 = r71
            r6 = r73
            r7 = r74
            r8 = r75
            r14 = r76
            r16 = r77
            r70 = r78
            r12 = r0
            r0 = r59
            goto L_0x03ad
        L_0x02b7:
            r0 = r59
            r19 = r60
            r23 = r62
            r9 = r64
            r11 = r65
            r13 = r66
            r21 = r67
            r5 = r70
            r3 = r71
            r6 = r73
            r7 = r74
            r8 = r75
            r14 = r76
            r16 = r77
            r70 = r78
            r12 = r2
            r2 = r69
            goto L_0x03ad
        L_0x02da:
            if (r3 == 0) goto L_0x02e1
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x02e3
        L_0x02e1:
            r3 = r59
        L_0x02e3:
            if (r9 == 0) goto L_0x02ec
            androidx.compose.ui.graphics.Color$Companion r9 = androidx.compose.ui.graphics.Color.Companion
            long r19 = r9.m3200getUnspecified0d7_KjU()
            goto L_0x02ee
        L_0x02ec:
            r19 = r60
        L_0x02ee:
            if (r18 == 0) goto L_0x02f7
            androidx.compose.ui.unit.TextUnit$Companion r9 = androidx.compose.ui.unit.TextUnit.Companion
            long r23 = r9.m6178getUnspecifiedXSAIIZE()
            goto L_0x02f9
        L_0x02f7:
            r23 = r62
        L_0x02f9:
            if (r22 == 0) goto L_0x02fd
            r9 = 0
            goto L_0x02ff
        L_0x02fd:
            r9 = r64
        L_0x02ff:
            if (r25 == 0) goto L_0x0303
            r11 = 0
            goto L_0x0305
        L_0x0303:
            r11 = r65
        L_0x0305:
            if (r29 == 0) goto L_0x0309
            r13 = 0
            goto L_0x030b
        L_0x0309:
            r13 = r66
        L_0x030b:
            if (r0 == 0) goto L_0x0314
            androidx.compose.ui.unit.TextUnit$Companion r0 = androidx.compose.ui.unit.TextUnit.Companion
            long r21 = r0.m6178getUnspecifiedXSAIIZE()
            goto L_0x0316
        L_0x0314:
            r21 = r67
        L_0x0316:
            if (r6 == 0) goto L_0x031a
            r0 = 0
            goto L_0x031c
        L_0x031a:
            r0 = r69
        L_0x031c:
            if (r5 == 0) goto L_0x0320
            r5 = 0
            goto L_0x0322
        L_0x0320:
            r5 = r70
        L_0x0322:
            if (r4 == 0) goto L_0x032b
            androidx.compose.ui.unit.TextUnit$Companion r4 = androidx.compose.ui.unit.TextUnit.Companion
            long r31 = r4.m6178getUnspecifiedXSAIIZE()
            goto L_0x032d
        L_0x032b:
            r31 = r71
        L_0x032d:
            if (r7 == 0) goto L_0x0336
            androidx.compose.ui.text.style.TextOverflow$Companion r4 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r4 = r4.m5898getClipgIe3tQ8()
            goto L_0x0338
        L_0x0336:
            r4 = r73
        L_0x0338:
            if (r8 == 0) goto L_0x033c
            r6 = 1
            goto L_0x033e
        L_0x033c:
            r6 = r74
        L_0x033e:
            if (r17 == 0) goto L_0x0344
            r7 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0346
        L_0x0344:
            r7 = r75
        L_0x0346:
            if (r14 == 0) goto L_0x0351
            java.util.Map r8 = kotlin.collections.MapsKt.emptyMap()
            r14 = -57345(0xffffffffffff1fff, float:NaN)
            r2 = r2 & r14
            goto L_0x0353
        L_0x0351:
            r8 = r76
        L_0x0353:
            if (r16 == 0) goto L_0x035a
            androidx.compose.material3.TextKt$Text$3 r14 = androidx.compose.material3.TextKt$Text$3.INSTANCE
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            goto L_0x035c
        L_0x035a:
            r14 = r77
        L_0x035c:
            r16 = r12 & r27
            if (r16 == 0) goto L_0x0397
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.text.TextStyle> r16 = LocalTextStyle
            r59 = r0
            r0 = r16
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r16 = 6
            r17 = 0
            r79 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            r60 = r4
            java.lang.String r4 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r4)
            java.lang.Object r3 = r10.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r0 = r3
            androidx.compose.ui.text.TextStyle r0 = (androidx.compose.ui.text.TextStyle) r0
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r2 = r2 & r3
            r70 = r0
            r12 = r2
            r16 = r14
            r3 = r31
            r2 = r59
            r0 = r79
            r14 = r8
            r8 = r7
            r7 = r6
            r6 = r60
            goto L_0x03ad
        L_0x0397:
            r59 = r0
            r79 = r3
            r60 = r4
            r70 = r78
            r0 = r79
            r12 = r2
            r16 = r14
            r3 = r31
            r2 = r59
            r14 = r8
            r8 = r7
            r7 = r6
            r6 = r60
        L_0x03ad:
            r10.endDefaults()
            boolean r17 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r17 == 0) goto L_0x03c1
            java.lang.String r15 = "androidx.compose.material3.Text (Text.kt:189)"
            r71 = r14
            r14 = 224529679(0xd620d0f, float:6.9657345E-31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r1, r12, r15)
            goto L_0x03c3
        L_0x03c1:
            r71 = r14
        L_0x03c3:
            r14 = 79587464(0x4be6888, float:4.4764782E-36)
            r10.startReplaceableGroup(r14)
            java.lang.String r14 = "*210@10340L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            r14 = r19
            r17 = 0
            r27 = r14
            r18 = 0
            androidx.compose.ui.graphics.Color$Companion r25 = androidx.compose.ui.graphics.Color.Companion
            long r31 = r25.m3200getUnspecified0d7_KjU()
            int r25 = (r27 > r31 ? 1 : (r27 == r31 ? 0 : -1))
            r29 = 1
            if (r25 == 0) goto L_0x03e5
            r25 = r29
            goto L_0x03e7
        L_0x03e5:
            r25 = 0
        L_0x03e7:
            if (r25 == 0) goto L_0x03ee
            r72 = r8
            r32 = r14
            goto L_0x043a
        L_0x03ee:
            r18 = 0
            long r27 = r70.m5494getColor0d7_KjU()
            r25 = 0
            r31 = r27
            r33 = 0
            androidx.compose.ui.graphics.Color$Companion r34 = androidx.compose.ui.graphics.Color.Companion
            long r34 = r34.m3200getUnspecified0d7_KjU()
            int r34 = (r31 > r34 ? 1 : (r31 == r34 ? 0 : -1))
            if (r34 == 0) goto L_0x0405
            goto L_0x0407
        L_0x0405:
            r29 = 0
        L_0x0407:
            if (r29 == 0) goto L_0x040e
            r72 = r8
            r59 = r14
            goto L_0x0438
        L_0x040e:
            r29 = 0
            androidx.compose.runtime.ProvidableCompositionLocal r31 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            r59 = r14
            r14 = r31
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r15 = 6
            r31 = 0
            r61 = r15
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            r72 = r8
            java.lang.String r8 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r15, r8)
            java.lang.Object r8 = r10.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.graphics.Color r8 = (androidx.compose.ui.graphics.Color) r8
            long r14 = r8.m3174unboximpl()
            r27 = r14
        L_0x0438:
            r32 = r27
        L_0x043a:
            r10.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r8 = new androidx.compose.ui.text.TextStyle
            r31 = r8
            r38 = 0
            r40 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r49 = 0
            r51 = 0
            r54 = 0
            r55 = 175952(0x2af50, float:2.46561E-40)
            r56 = 0
            r34 = r23
            r36 = r11
            r37 = r9
            r39 = r13
            r41 = r21
            r48 = r2
            r50 = r5
            r52 = r3
            r31.<init>((long) r32, (long) r34, (androidx.compose.ui.text.font.FontWeight) r36, (androidx.compose.ui.text.font.FontStyle) r37, (androidx.compose.ui.text.font.FontSynthesis) r38, (androidx.compose.ui.text.font.FontFamily) r39, (java.lang.String) r40, (long) r41, (androidx.compose.ui.text.style.BaselineShift) r43, (androidx.compose.ui.text.style.TextGeometricTransform) r44, (androidx.compose.ui.text.intl.LocaleList) r45, (long) r46, (androidx.compose.ui.text.style.TextDecoration) r48, (androidx.compose.ui.graphics.Shadow) r49, (androidx.compose.ui.text.style.TextAlign) r50, (androidx.compose.ui.text.style.TextDirection) r51, (long) r52, (androidx.compose.ui.text.style.TextIndent) r54, (int) r55, (kotlin.jvm.internal.DefaultConstructorMarker) r56)
            r14 = r70
            androidx.compose.ui.text.TextStyle r8 = r14.merge((androidx.compose.ui.text.TextStyle) r8)
            r15 = 16777216(0x1000000, float:2.3509887E-38)
            r17 = r1 & 14
            r15 = r17 | r15
            r17 = r1 & 112(0x70, float:1.57E-43)
            r15 = r15 | r17
            r79 = r1
            int r1 = r12 >> 6
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r15
            int r15 = r12 << 9
            r17 = 57344(0xe000, float:8.0356E-41)
            r15 = r15 & r17
            r1 = r1 | r15
            int r15 = r12 << 9
            r15 = r15 & r26
            r1 = r1 | r15
            int r15 = r12 << 9
            r15 = r15 & r30
            r1 = r1 | r15
            r15 = 0
            r59 = r58
            r60 = r0
            r61 = r8
            r62 = r16
            r63 = r6
            r64 = r7
            r65 = r72
            r66 = r71
            r67 = r10
            r68 = r1
            r69 = r15
            androidx.compose.foundation.text.BasicTextKt.m1122BasicText4YKlhWE((androidx.compose.ui.text.AnnotatedString) r59, (androidx.compose.ui.Modifier) r60, (androidx.compose.ui.text.TextStyle) r61, (kotlin.jvm.functions.Function1) r62, (int) r63, (boolean) r64, (int) r65, (java.util.Map) r66, (androidx.compose.runtime.Composer) r67, (int) r68, (int) r69)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x04c8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04c8:
            r42 = r71
            r41 = r72
            r25 = r0
            r35 = r2
            r37 = r3
            r36 = r5
            r39 = r6
            r40 = r7
            r30 = r9
            r31 = r11
            r45 = r12
            r32 = r13
            r44 = r14
            r43 = r16
            r26 = r19
            r33 = r21
            r28 = r23
        L_0x04ea:
            androidx.compose.runtime.ScopeUpdateScope r14 = r10.endRestartGroup()
            if (r14 != 0) goto L_0x04f5
            r47 = r79
            r48 = r10
            goto L_0x0533
        L_0x04f5:
            androidx.compose.material3.TextKt$Text$4 r46 = new androidx.compose.material3.TextKt$Text$4
            r0 = r46
            r47 = r79
            r1 = r58
            r2 = r25
            r3 = r26
            r5 = r28
            r7 = r30
            r8 = r31
            r9 = r32
            r48 = r10
            r10 = r33
            r12 = r35
            r13 = r36
            r57 = r14
            r14 = r37
            r16 = r39
            r17 = r40
            r18 = r41
            r19 = r42
            r20 = r43
            r21 = r44
            r22 = r80
            r23 = r81
            r24 = r82
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r0 = r46
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r57
            r1.updateScope(r0)
        L_0x0533:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m2177Text4IGK_g(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    public static final void ProvideTextStyle(TextStyle value, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-460300127);
        ComposerKt.sourceInformation($composer2, "C(ProvideTextStyle)P(1)259@12067L7,260@12092L80:Text.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) value) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed((Object) content) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-460300127, $dirty, -1, "androidx.compose.material3.ProvideTextStyle (Text.kt:258)");
            }
            ProvidableCompositionLocal<TextStyle> this_$iv = LocalTextStyle;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
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
