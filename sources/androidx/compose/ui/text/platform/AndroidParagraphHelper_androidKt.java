package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.platform.extensions.PlaceholderExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.emoji2.text.EmojiCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000]\n\u0000\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0001\u001a\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\f2\u0006\u0010\u0011\u001a\u00020\u00122&\u0010\u0013\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0000ø\u0001\u0000\u001a\f\u0010\u001c\u001a\u00020\u001b*\u00020\nH\u0000\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"NoopSpan", "androidx/compose/ui/text/platform/AndroidParagraphHelper_androidKt$NoopSpan$1", "Landroidx/compose/ui/text/platform/AndroidParagraphHelper_androidKt$NoopSpan$1;", "createCharSequence", "", "text", "", "contextFontSize", "", "contextTextStyle", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "useEmojiCompat", "", "isIncludeFontPaddingEnabled", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidParagraphHelper.android.kt */
public final class AndroidParagraphHelper_androidKt {
    private static final AndroidParagraphHelper_androidKt$NoopSpan$1 NoopSpan = new AndroidParagraphHelper_androidKt$NoopSpan$1();

    public static final CharSequence createCharSequence(String text, float contextFontSize, TextStyle contextTextStyle, List<AnnotatedString.Range<SpanStyle>> spanStyles, List<AnnotatedString.Range<Placeholder>> placeholders, Density density, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> resolveTypeface, boolean useEmojiCompat) {
        CharSequence currentText;
        Spannable spannableString;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(contextTextStyle, "contextTextStyle");
        Intrinsics.checkNotNullParameter(spanStyles, "spanStyles");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resolveTypeface, "resolveTypeface");
        if (!useEmojiCompat || !EmojiCompat.isConfigured()) {
            currentText = text;
        } else {
            currentText = EmojiCompat.get().process(text);
            Intrinsics.checkNotNull(currentText);
        }
        Intrinsics.checkNotNullExpressionValue(currentText, "if (useEmojiCompat && Em…else {\n        text\n    }");
        if (spanStyles.isEmpty() && placeholders.isEmpty() && Intrinsics.areEqual((Object) contextTextStyle.getTextIndent(), (Object) TextIndent.Companion.getNone()) && TextUnitKt.m6185isUnspecifiedR2X_6o(contextTextStyle.m5501getLineHeightXSAIIZE())) {
            return currentText;
        }
        if (currentText instanceof Spannable) {
            spannableString = (Spannable) currentText;
        } else {
            spannableString = new SpannableString(currentText);
        }
        if (Intrinsics.areEqual((Object) contextTextStyle.getTextDecoration(), (Object) TextDecoration.Companion.getUnderline())) {
            SpannableExtensions_androidKt.setSpan(spannableString, NoopSpan, 0, text.length());
        }
        if (!isIncludeFontPaddingEnabled(contextTextStyle) || contextTextStyle.getLineHeightStyle() != null) {
            LineHeightStyle lineHeightStyle = contextTextStyle.getLineHeightStyle();
            if (lineHeightStyle == null) {
                lineHeightStyle = LineHeightStyle.Companion.getDefault();
            }
            LineHeightStyle lineHeightStyle2 = lineHeightStyle;
            SpannableExtensions_androidKt.m5730setLineHeightKmRG4DE(spannableString, contextTextStyle.m5501getLineHeightXSAIIZE(), contextFontSize, density, lineHeightStyle2);
        } else {
            SpannableExtensions_androidKt.m5731setLineHeightr9BaKPg(spannableString, contextTextStyle.m5501getLineHeightXSAIIZE(), contextFontSize, density);
        }
        SpannableExtensions_androidKt.setTextIndent(spannableString, contextTextStyle.getTextIndent(), contextFontSize, density);
        SpannableExtensions_androidKt.setSpanStyles(spannableString, contextTextStyle, spanStyles, density, resolveTypeface);
        PlaceholderExtensions_androidKt.setPlaceholders(spannableString, placeholders, density);
        return spannableString;
    }

    public static final boolean isIncludeFontPaddingEnabled(TextStyle $this$isIncludeFontPaddingEnabled) {
        PlatformParagraphStyle paragraphStyle;
        Intrinsics.checkNotNullParameter($this$isIncludeFontPaddingEnabled, "<this>");
        PlatformTextStyle platformStyle = $this$isIncludeFontPaddingEnabled.getPlatformStyle();
        if (platformStyle == null || (paragraphStyle = platformStyle.getParagraphStyle()) == null) {
            return true;
        }
        return paragraphStyle.getIncludeFontPadding();
    }
}
