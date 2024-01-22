package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, d2 = {"synthesizeTypeface", "", "Landroidx/compose/ui/text/font/FontSynthesis;", "typeface", "font", "Landroidx/compose/ui/text/font/Font;", "requestedWeight", "Landroidx/compose/ui/text/font/FontWeight;", "requestedStyle", "Landroidx/compose/ui/text/font/FontStyle;", "synthesizeTypeface-FxwP2eA", "(ILjava/lang/Object;Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/lang/Object;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontSynthesis.android.kt */
public final class FontSynthesis_androidKt {
    /* renamed from: synthesizeTypeface-FxwP2eA  reason: not valid java name */
    public static final Object m5582synthesizeTypefaceFxwP2eA(int $this$synthesizeTypeface_u2dFxwP2eA, Object typeface, Font font, FontWeight requestedWeight, int requestedStyle) {
        int finalFontWeight;
        boolean finalFontStyle;
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        Intrinsics.checkNotNullParameter(font, "font");
        Intrinsics.checkNotNullParameter(requestedWeight, "requestedWeight");
        if (!(typeface instanceof Typeface)) {
            return typeface;
        }
        boolean synthesizeStyle = true;
        boolean synthesizeWeight = FontSynthesis.m5575isWeightOnimpl$ui_text_release($this$synthesizeTypeface_u2dFxwP2eA) && !Intrinsics.areEqual((Object) font.getWeight(), (Object) requestedWeight) && requestedWeight.compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.Companion)) >= 0 && font.getWeight().compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.Companion)) < 0;
        if (!FontSynthesis.m5574isStyleOnimpl$ui_text_release($this$synthesizeTypeface_u2dFxwP2eA) || FontStyle.m5563equalsimpl0(requestedStyle, font.m5535getStyle_LCdwA())) {
            synthesizeStyle = false;
        }
        if (!synthesizeStyle && !synthesizeWeight) {
            return typeface;
        }
        if (synthesizeWeight) {
            finalFontWeight = requestedWeight.getWeight();
        } else {
            finalFontWeight = font.getWeight().getWeight();
        }
        if (synthesizeStyle) {
            finalFontStyle = FontStyle.m5563equalsimpl0(requestedStyle, FontStyle.Companion.m5567getItalic_LCdwA());
        } else {
            finalFontStyle = FontStyle.m5563equalsimpl0(font.m5535getStyle_LCdwA(), FontStyle.Companion.m5567getItalic_LCdwA());
        }
        Typeface create = TypefaceHelperMethodsApi28.INSTANCE.create((Typeface) typeface, finalFontWeight, finalFontStyle);
        Intrinsics.checkNotNullExpressionValue(create, "if (Build.VERSION.SDK_IN…ht, finalFontStyle)\n    }");
        return create;
    }
}
