package androidx.compose.material3.tokens;

import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006¨\u0006#"}, d2 = {"Landroidx/compose/material3/tokens/TypographyTokens;", "", "()V", "BodyLarge", "Landroidx/compose/ui/text/TextStyle;", "getBodyLarge", "()Landroidx/compose/ui/text/TextStyle;", "BodyMedium", "getBodyMedium", "BodySmall", "getBodySmall", "DisplayLarge", "getDisplayLarge", "DisplayMedium", "getDisplayMedium", "DisplaySmall", "getDisplaySmall", "HeadlineLarge", "getHeadlineLarge", "HeadlineMedium", "getHeadlineMedium", "HeadlineSmall", "getHeadlineSmall", "LabelLarge", "getLabelLarge", "LabelMedium", "getLabelMedium", "LabelSmall", "getLabelSmall", "TitleLarge", "getTitleLarge", "TitleMedium", "getTitleMedium", "TitleSmall", "getTitleSmall", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TypographyTokens.kt */
public final class TypographyTokens {
    private static final TextStyle BodyLarge;
    private static final TextStyle BodyMedium;
    private static final TextStyle BodySmall;
    private static final TextStyle DisplayLarge;
    private static final TextStyle DisplayMedium;
    private static final TextStyle DisplaySmall;
    private static final TextStyle HeadlineLarge;
    private static final TextStyle HeadlineMedium;
    private static final TextStyle HeadlineSmall;
    public static final TypographyTokens INSTANCE = new TypographyTokens();
    private static final TextStyle LabelLarge;
    private static final TextStyle LabelMedium;
    private static final TextStyle LabelSmall;
    private static final TextStyle TitleLarge;
    private static final TextStyle TitleMedium;
    private static final TextStyle TitleSmall;

    private TypographyTokens() {
    }

    public final TextStyle getBodyLarge() {
        return BodyLarge;
    }

    static {
        GenericFontFamily bodyLargeFont = TypeScaleTokens.INSTANCE.getBodyLargeFont();
        FontWeight bodyLargeWeight = TypeScaleTokens.INSTANCE.getBodyLargeWeight();
        FontFamily fontFamily = bodyLargeFont;
        BodyLarge = new TextStyle(0, TypeScaleTokens.INSTANCE.m2717getBodyLargeSizeXSAIIZE(), bodyLargeWeight, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, TypeScaleTokens.INSTANCE.m2718getBodyLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TypeScaleTokens.INSTANCE.m2716getBodyLargeLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily bodyMediumFont = TypeScaleTokens.INSTANCE.getBodyMediumFont();
        FontWeight bodyMediumWeight = TypeScaleTokens.INSTANCE.getBodyMediumWeight();
        FontFamily fontFamily2 = bodyMediumFont;
        BodyMedium = new TextStyle(0, TypeScaleTokens.INSTANCE.m2720getBodyMediumSizeXSAIIZE(), bodyMediumWeight, (FontStyle) null, (FontSynthesis) null, fontFamily2, (String) null, TypeScaleTokens.INSTANCE.m2721getBodyMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TypeScaleTokens.INSTANCE.m2719getBodyMediumLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily bodySmallFont = TypeScaleTokens.INSTANCE.getBodySmallFont();
        FontWeight bodySmallWeight = TypeScaleTokens.INSTANCE.getBodySmallWeight();
        FontFamily fontFamily3 = bodySmallFont;
        BodySmall = new TextStyle(0, TypeScaleTokens.INSTANCE.m2723getBodySmallSizeXSAIIZE(), bodySmallWeight, (FontStyle) null, (FontSynthesis) null, fontFamily3, (String) null, TypeScaleTokens.INSTANCE.m2724getBodySmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TypeScaleTokens.INSTANCE.m2722getBodySmallLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily displayLargeFont = TypeScaleTokens.INSTANCE.getDisplayLargeFont();
        FontWeight displayLargeWeight = TypeScaleTokens.INSTANCE.getDisplayLargeWeight();
        FontFamily fontFamily4 = displayLargeFont;
        DisplayLarge = new TextStyle(0, TypeScaleTokens.INSTANCE.m2726getDisplayLargeSizeXSAIIZE(), displayLargeWeight, (FontStyle) null, (FontSynthesis) null, fontFamily4, (String) null, TypeScaleTokens.INSTANCE.m2727getDisplayLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TypeScaleTokens.INSTANCE.m2725getDisplayLargeLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily displayMediumFont = TypeScaleTokens.INSTANCE.getDisplayMediumFont();
        FontWeight displayMediumWeight = TypeScaleTokens.INSTANCE.getDisplayMediumWeight();
        FontFamily fontFamily5 = displayMediumFont;
        DisplayMedium = new TextStyle(0, TypeScaleTokens.INSTANCE.m2729getDisplayMediumSizeXSAIIZE(), displayMediumWeight, (FontStyle) null, (FontSynthesis) null, fontFamily5, (String) null, TypeScaleTokens.INSTANCE.m2730getDisplayMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TypeScaleTokens.INSTANCE.m2728getDisplayMediumLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily displaySmallFont = TypeScaleTokens.INSTANCE.getDisplaySmallFont();
        FontWeight displaySmallWeight = TypeScaleTokens.INSTANCE.getDisplaySmallWeight();
        FontFamily fontFamily6 = displaySmallFont;
        DisplaySmall = new TextStyle(0, TypeScaleTokens.INSTANCE.m2732getDisplaySmallSizeXSAIIZE(), displaySmallWeight, (FontStyle) null, (FontSynthesis) null, fontFamily6, (String) null, TypeScaleTokens.INSTANCE.m2733getDisplaySmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TypeScaleTokens.INSTANCE.m2731getDisplaySmallLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily headlineLargeFont = TypeScaleTokens.INSTANCE.getHeadlineLargeFont();
        FontWeight headlineLargeWeight = TypeScaleTokens.INSTANCE.getHeadlineLargeWeight();
        FontFamily fontFamily7 = headlineLargeFont;
        HeadlineLarge = new TextStyle(0, TypeScaleTokens.INSTANCE.m2735getHeadlineLargeSizeXSAIIZE(), headlineLargeWeight, (FontStyle) null, (FontSynthesis) null, fontFamily7, (String) null, TypeScaleTokens.INSTANCE.m2736getHeadlineLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TypeScaleTokens.INSTANCE.m2734getHeadlineLargeLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily headlineMediumFont = TypeScaleTokens.INSTANCE.getHeadlineMediumFont();
        FontWeight headlineMediumWeight = TypeScaleTokens.INSTANCE.getHeadlineMediumWeight();
        FontFamily fontFamily8 = headlineMediumFont;
        HeadlineMedium = new TextStyle(0, TypeScaleTokens.INSTANCE.m2738getHeadlineMediumSizeXSAIIZE(), headlineMediumWeight, (FontStyle) null, (FontSynthesis) null, fontFamily8, (String) null, TypeScaleTokens.INSTANCE.m2739getHeadlineMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TypeScaleTokens.INSTANCE.m2737getHeadlineMediumLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily headlineSmallFont = TypeScaleTokens.INSTANCE.getHeadlineSmallFont();
        FontWeight headlineSmallWeight = TypeScaleTokens.INSTANCE.getHeadlineSmallWeight();
        FontFamily fontFamily9 = headlineSmallFont;
        HeadlineSmall = new TextStyle(0, TypeScaleTokens.INSTANCE.m2741getHeadlineSmallSizeXSAIIZE(), headlineSmallWeight, (FontStyle) null, (FontSynthesis) null, fontFamily9, (String) null, TypeScaleTokens.INSTANCE.m2742getHeadlineSmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TypeScaleTokens.INSTANCE.m2740getHeadlineSmallLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily labelLargeFont = TypeScaleTokens.INSTANCE.getLabelLargeFont();
        FontWeight labelLargeWeight = TypeScaleTokens.INSTANCE.getLabelLargeWeight();
        FontFamily fontFamily10 = labelLargeFont;
        LabelLarge = new TextStyle(0, TypeScaleTokens.INSTANCE.m2744getLabelLargeSizeXSAIIZE(), labelLargeWeight, (FontStyle) null, (FontSynthesis) null, fontFamily10, (String) null, TypeScaleTokens.INSTANCE.m2745getLabelLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TypeScaleTokens.INSTANCE.m2743getLabelLargeLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily labelMediumFont = TypeScaleTokens.INSTANCE.getLabelMediumFont();
        FontWeight labelMediumWeight = TypeScaleTokens.INSTANCE.getLabelMediumWeight();
        FontFamily fontFamily11 = labelMediumFont;
        LabelMedium = new TextStyle(0, TypeScaleTokens.INSTANCE.m2747getLabelMediumSizeXSAIIZE(), labelMediumWeight, (FontStyle) null, (FontSynthesis) null, fontFamily11, (String) null, TypeScaleTokens.INSTANCE.m2748getLabelMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TypeScaleTokens.INSTANCE.m2746getLabelMediumLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily labelSmallFont = TypeScaleTokens.INSTANCE.getLabelSmallFont();
        FontWeight labelSmallWeight = TypeScaleTokens.INSTANCE.getLabelSmallWeight();
        FontFamily fontFamily12 = labelSmallFont;
        LabelSmall = new TextStyle(0, TypeScaleTokens.INSTANCE.m2750getLabelSmallSizeXSAIIZE(), labelSmallWeight, (FontStyle) null, (FontSynthesis) null, fontFamily12, (String) null, TypeScaleTokens.INSTANCE.m2751getLabelSmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TypeScaleTokens.INSTANCE.m2749getLabelSmallLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily titleLargeFont = TypeScaleTokens.INSTANCE.getTitleLargeFont();
        FontWeight titleLargeWeight = TypeScaleTokens.INSTANCE.getTitleLargeWeight();
        FontFamily fontFamily13 = titleLargeFont;
        TitleLarge = new TextStyle(0, TypeScaleTokens.INSTANCE.m2753getTitleLargeSizeXSAIIZE(), titleLargeWeight, (FontStyle) null, (FontSynthesis) null, fontFamily13, (String) null, TypeScaleTokens.INSTANCE.m2754getTitleLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TypeScaleTokens.INSTANCE.m2752getTitleLargeLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily titleMediumFont = TypeScaleTokens.INSTANCE.getTitleMediumFont();
        FontWeight titleMediumWeight = TypeScaleTokens.INSTANCE.getTitleMediumWeight();
        FontFamily fontFamily14 = titleMediumFont;
        TitleMedium = new TextStyle(0, TypeScaleTokens.INSTANCE.m2756getTitleMediumSizeXSAIIZE(), titleMediumWeight, (FontStyle) null, (FontSynthesis) null, fontFamily14, (String) null, TypeScaleTokens.INSTANCE.m2757getTitleMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TypeScaleTokens.INSTANCE.m2755getTitleMediumLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily titleSmallFont = TypeScaleTokens.INSTANCE.getTitleSmallFont();
        FontWeight titleSmallWeight = TypeScaleTokens.INSTANCE.getTitleSmallWeight();
        FontFamily fontFamily15 = titleSmallFont;
        TitleSmall = new TextStyle(0, TypeScaleTokens.INSTANCE.m2759getTitleSmallSizeXSAIIZE(), titleSmallWeight, (FontStyle) null, (FontSynthesis) null, fontFamily15, (String) null, TypeScaleTokens.INSTANCE.m2760getTitleSmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TypeScaleTokens.INSTANCE.m2758getTitleSmallLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
    }

    public final TextStyle getBodyMedium() {
        return BodyMedium;
    }

    public final TextStyle getBodySmall() {
        return BodySmall;
    }

    public final TextStyle getDisplayLarge() {
        return DisplayLarge;
    }

    public final TextStyle getDisplayMedium() {
        return DisplayMedium;
    }

    public final TextStyle getDisplaySmall() {
        return DisplaySmall;
    }

    public final TextStyle getHeadlineLarge() {
        return HeadlineLarge;
    }

    public final TextStyle getHeadlineMedium() {
        return HeadlineMedium;
    }

    public final TextStyle getHeadlineSmall() {
        return HeadlineSmall;
    }

    public final TextStyle getLabelLarge() {
        return LabelLarge;
    }

    public final TextStyle getLabelMedium() {
        return LabelMedium;
    }

    public final TextStyle getLabelSmall() {
        return LabelSmall;
    }

    public final TextStyle getTitleLarge() {
        return TitleLarge;
    }

    public final TextStyle getTitleMedium() {
        return TitleMedium;
    }

    public final TextStyle getTitleSmall() {
        return TitleSmall;
    }
}
