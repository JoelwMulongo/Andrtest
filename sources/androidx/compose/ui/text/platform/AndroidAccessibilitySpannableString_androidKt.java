package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TtsAnnotation;
import androidx.compose.ui.text.UrlAnnotation;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.TtsAnnotationExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.UrlAnnotationExtensions_androidKt;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001c\u0010\f\u001a\u00020\u0002*\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u001c\u0010\f\u001a\u00020\u0002*\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\u0010"}, d2 = {"setSpanStyle", "", "Landroid/text/SpannableString;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "start", "", "end", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "toAccessibilitySpannableString", "Landroidx/compose/ui/text/AnnotatedString;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidAccessibilitySpannableString.android.kt */
public final class AndroidAccessibilitySpannableString_androidKt {
    public static final SpannableString toAccessibilitySpannableString(AnnotatedString $this$toAccessibilitySpannableString, Density density, Font.ResourceLoader resourceLoader) {
        Intrinsics.checkNotNullParameter($this$toAccessibilitySpannableString, "<this>");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resourceLoader, "resourceLoader");
        return toAccessibilitySpannableString($this$toAccessibilitySpannableString, density, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader));
    }

    public static final SpannableString toAccessibilitySpannableString(AnnotatedString $this$toAccessibilitySpannableString, Density density, FontFamily.Resolver fontFamilyResolver) {
        AnnotatedString annotatedString = $this$toAccessibilitySpannableString;
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        SpannableString spannableString = new SpannableString($this$toAccessibilitySpannableString.getText());
        List spanStylesOrNull$ui_text_release = $this$toAccessibilitySpannableString.getSpanStylesOrNull$ui_text_release();
        if (spanStylesOrNull$ui_text_release != null) {
            List $this$fastForEach$iv = spanStylesOrNull$ui_text_release;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                AnnotatedString.Range range = $this$fastForEach$iv.get(index$iv);
                setSpanStyle(spannableString, SpanStyle.m5426copyIuqyXdg$default((SpanStyle) range.component1(), 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, 16351, (Object) null), range.component2(), range.component3(), density, fontFamilyResolver);
            }
        }
        List $this$fastForEach$iv2 = annotatedString.getTtsAnnotations(0, $this$toAccessibilitySpannableString.length());
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            AnnotatedString.Range range2 = $this$fastForEach$iv2.get(index$iv2);
            spannableString.setSpan(TtsAnnotationExtensions_androidKt.toSpan((TtsAnnotation) range2.component1()), range2.component2(), range2.component3(), 33);
        }
        List $this$fastForEach$iv3 = annotatedString.getUrlAnnotations(0, $this$toAccessibilitySpannableString.length());
        int size3 = $this$fastForEach$iv3.size();
        for (int index$iv3 = 0; index$iv3 < size3; index$iv3++) {
            AnnotatedString.Range range3 = $this$fastForEach$iv3.get(index$iv3);
            spannableString.setSpan(UrlAnnotationExtensions_androidKt.toSpan((UrlAnnotation) range3.component1()), range3.component2(), range3.component3(), 33);
        }
        return spannableString;
    }

    private static final void setSpanStyle(SpannableString $this$setSpanStyle, SpanStyle spanStyle, int start, int end, Density density, FontFamily.Resolver fontFamilyResolver) {
        SpannableExtensions_androidKt.m5728setColorRPmYEkk($this$setSpanStyle, spanStyle.m5434getColor0d7_KjU(), start, end);
        SpannableExtensions_androidKt.m5729setFontSizeKmRG4DE($this$setSpanStyle, spanStyle.m5435getFontSizeXSAIIZE(), density, start, end);
        if (!(spanStyle.getFontWeight() == null && spanStyle.m5436getFontStyle4Lr2A7w() == null)) {
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle r2 = spanStyle.m5436getFontStyle4Lr2A7w();
            $this$setSpanStyle.setSpan(new StyleSpan(AndroidFontUtils_androidKt.m5513getAndroidTypefaceStyleFO1MlWM(fontWeight, r2 != null ? r2.m5566unboximpl() : FontStyle.Companion.m5568getNormal_LCdwA())), start, end, 33);
        }
        if (spanStyle.getFontFamily() != null) {
            if (spanStyle.getFontFamily() instanceof GenericFontFamily) {
                $this$setSpanStyle.setSpan(new TypefaceSpan(((GenericFontFamily) spanStyle.getFontFamily()).getName()), start, end, 33);
            } else {
                FontFamily fontFamily = spanStyle.getFontFamily();
                FontSynthesis r0 = spanStyle.m5437getFontSynthesisZQGJjVo();
                Object value = FontFamily.Resolver.m5536resolveDPcqOEQ$default(fontFamilyResolver, fontFamily, (FontWeight) null, 0, r0 != null ? r0.m5577unboximpl() : FontSynthesis.Companion.m5578getAllGVVA2EU(), 6, (Object) null).getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.graphics.Typeface");
                $this$setSpanStyle.setSpan(Api28Impl.INSTANCE.createTypefaceSpan((Typeface) value), start, end, 33);
            }
        }
        if (spanStyle.getTextDecoration() != null) {
            if (spanStyle.getTextDecoration().contains(TextDecoration.Companion.getUnderline())) {
                $this$setSpanStyle.setSpan(new UnderlineSpan(), start, end, 33);
            }
            if (spanStyle.getTextDecoration().contains(TextDecoration.Companion.getLineThrough())) {
                $this$setSpanStyle.setSpan(new StrikethroughSpan(), start, end, 33);
            }
        }
        if (spanStyle.getTextGeometricTransform() != null) {
            $this$setSpanStyle.setSpan(new ScaleXSpan(spanStyle.getTextGeometricTransform().getScaleX()), start, end, 33);
        }
        SpannableExtensions_androidKt.setLocaleList($this$setSpanStyle, spanStyle.getLocaleList(), start, end);
        SpannableExtensions_androidKt.m5726setBackgroundRPmYEkk($this$setSpanStyle, spanStyle.m5432getBackground0d7_KjU(), start, end);
    }
}
