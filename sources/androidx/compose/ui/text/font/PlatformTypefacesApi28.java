package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.autofill.HintConstants;
import androidx.compose.ui.text.font.FontVariation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\fJ?\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006!"}, d2 = {"Landroidx/compose/ui/text/font/PlatformTypefacesApi28;", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "()V", "createAndroidTypefaceApi28", "Landroid/graphics/Typeface;", "genericFontFamily", "", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "createAndroidTypefaceApi28-RetOiIg", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createDefault", "createDefault-FO1MlWM", "(Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createNamed", "name", "Landroidx/compose/ui/text/font/GenericFontFamily;", "createNamed-RetOiIg", "(Landroidx/compose/ui/text/font/GenericFontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "loadNamedFromTypefaceCacheOrNull", "familyName", "weight", "style", "loadNamedFromTypefaceCacheOrNull-RetOiIg", "optionalOnDeviceFontFamilyByName", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "context", "Landroid/content/Context;", "optionalOnDeviceFontFamilyByName-78DK7lM", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Landroid/content/Context;)Landroid/graphics/Typeface;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PlatformTypefaces.kt */
final class PlatformTypefacesApi28 implements PlatformTypefaces {
    /* renamed from: optionalOnDeviceFontFamilyByName-78DK7lM  reason: not valid java name */
    public Typeface m5602optionalOnDeviceFontFamilyByName78DK7lM(String familyName, FontWeight weight, int style, FontVariation.Settings variationSettings, Context context) {
        Typeface result;
        Intrinsics.checkNotNullParameter(familyName, "familyName");
        Intrinsics.checkNotNullParameter(weight, "weight");
        Intrinsics.checkNotNullParameter(variationSettings, "variationSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual((Object) familyName, (Object) FontFamily.Companion.getSansSerif().getName())) {
            result = m5601createNamedRetOiIg(FontFamily.Companion.getSansSerif(), weight, style);
        } else if (Intrinsics.areEqual((Object) familyName, (Object) FontFamily.Companion.getSerif().getName())) {
            result = m5601createNamedRetOiIg(FontFamily.Companion.getSerif(), weight, style);
        } else if (Intrinsics.areEqual((Object) familyName, (Object) FontFamily.Companion.getMonospace().getName())) {
            result = m5601createNamedRetOiIg(FontFamily.Companion.getMonospace(), weight, style);
        } else if (Intrinsics.areEqual((Object) familyName, (Object) FontFamily.Companion.getCursive().getName())) {
            result = m5601createNamedRetOiIg(FontFamily.Companion.getCursive(), weight, style);
        } else {
            result = m5599loadNamedFromTypefaceCacheOrNullRetOiIg(familyName, weight, style);
        }
        return PlatformTypefacesKt.setFontVariationSettings(result, variationSettings, context);
    }

    /* renamed from: createDefault-FO1MlWM  reason: not valid java name */
    public Typeface m5600createDefaultFO1MlWM(FontWeight fontWeight, int fontStyle) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return m5597createAndroidTypefaceApi28RetOiIg((String) null, fontWeight, fontStyle);
    }

    /* renamed from: createNamed-RetOiIg  reason: not valid java name */
    public Typeface m5601createNamedRetOiIg(GenericFontFamily name, FontWeight fontWeight, int fontStyle) {
        Intrinsics.checkNotNullParameter(name, HintConstants.AUTOFILL_HINT_NAME);
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return m5597createAndroidTypefaceApi28RetOiIg(name.getName(), fontWeight, fontStyle);
    }

    /* renamed from: loadNamedFromTypefaceCacheOrNull-RetOiIg  reason: not valid java name */
    private final Typeface m5599loadNamedFromTypefaceCacheOrNullRetOiIg(String familyName, FontWeight weight, int style) {
        boolean z = true;
        if (familyName.length() == 0) {
            return null;
        }
        Typeface typeface = m5597createAndroidTypefaceApi28RetOiIg(familyName, weight, style);
        boolean isItalic = FontStyle.m5563equalsimpl0(style, FontStyle.Companion.m5567getItalic_LCdwA());
        Typeface it = typeface;
        TypefaceHelperMethodsApi28 typefaceHelperMethodsApi28 = TypefaceHelperMethodsApi28.INSTANCE;
        Typeface typeface2 = Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(typeface2, "DEFAULT");
        if (Intrinsics.areEqual((Object) it, (Object) typefaceHelperMethodsApi28.create(typeface2, weight.getWeight(), isItalic)) || Intrinsics.areEqual((Object) it, (Object) m5597createAndroidTypefaceApi28RetOiIg((String) null, weight, style))) {
            z = false;
        }
        if (z) {
            return typeface;
        }
        return null;
    }

    /* renamed from: createAndroidTypefaceApi28-RetOiIg$default  reason: not valid java name */
    static /* synthetic */ Typeface m5598createAndroidTypefaceApi28RetOiIg$default(PlatformTypefacesApi28 platformTypefacesApi28, String str, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return platformTypefacesApi28.m5597createAndroidTypefaceApi28RetOiIg(str, fontWeight, i);
    }

    /* renamed from: createAndroidTypefaceApi28-RetOiIg  reason: not valid java name */
    private final Typeface m5597createAndroidTypefaceApi28RetOiIg(String genericFontFamily, FontWeight fontWeight, int fontStyle) {
        Typeface familyTypeface;
        if (FontStyle.m5563equalsimpl0(fontStyle, FontStyle.Companion.m5568getNormal_LCdwA()) && Intrinsics.areEqual((Object) fontWeight, (Object) FontWeight.Companion.getNormal())) {
            CharSequence charSequence = genericFontFamily;
            if (charSequence == null || charSequence.length() == 0) {
                Typeface typeface = Typeface.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(typeface, "DEFAULT");
                return typeface;
            }
        }
        if (genericFontFamily == null) {
            familyTypeface = Typeface.DEFAULT;
        } else {
            familyTypeface = Typeface.create(genericFontFamily, 0);
        }
        Typeface create = Typeface.create(familyTypeface, fontWeight.getWeight(), FontStyle.m5563equalsimpl0(fontStyle, FontStyle.Companion.m5567getItalic_LCdwA()));
        Intrinsics.checkNotNullExpressionValue(create, "create(\n            fami…ontStyle.Italic\n        )");
        return create;
    }
}
