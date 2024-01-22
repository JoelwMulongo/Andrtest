package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.util.DisplayMetrics;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\r*\u00020\u0004H\u0001¢\u0006\u0002\b\u0011J\u0011\u0010\u0010\u001a\u00020\r*\u00020\u0012H\u0001¢\u0006\u0002\b\u0011J\u0011\u0010\u0013\u001a\u00020\u0012*\u00020\rH\u0001¢\u0006\u0002\b\u0014\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/graphics/Api26Bitmap;", "", "()V", "createBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "bitmapConfig", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "createBitmap-x__-hDU$ui_graphics_release", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroid/graphics/Bitmap;", "composeColorSpace", "composeColorSpace$ui_graphics_release", "Landroid/graphics/ColorSpace;", "toFrameworkColorSpace", "toFrameworkColorSpace$ui_graphics_release", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidImageBitmap.android.kt */
final class Api26Bitmap {
    public static final Api26Bitmap INSTANCE = new Api26Bitmap();

    private Api26Bitmap() {
    }

    @JvmStatic
    /* renamed from: createBitmap-x__-hDU$ui_graphics_release  reason: not valid java name */
    public static final Bitmap m3062createBitmapx__hDU$ui_graphics_release(int width, int height, int bitmapConfig, boolean hasAlpha, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        Bitmap createBitmap = Bitmap.createBitmap((DisplayMetrics) null, width, height, AndroidImageBitmap_androidKt.m3025toBitmapConfig1JJdX4A(bitmapConfig), hasAlpha, toFrameworkColorSpace$ui_graphics_release(colorSpace));
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(\n          …orkColorSpace()\n        )");
        return createBitmap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = composeColorSpace$ui_graphics_release(r0);
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.graphics.colorspace.ColorSpace composeColorSpace$ui_graphics_release(android.graphics.Bitmap r1) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            android.graphics.ColorSpace r0 = r1.getColorSpace()
            if (r0 == 0) goto L_0x0012
            androidx.compose.ui.graphics.colorspace.ColorSpace r0 = composeColorSpace$ui_graphics_release((android.graphics.ColorSpace) r0)
            if (r0 == 0) goto L_0x0012
            goto L_0x001a
        L_0x0012:
            androidx.compose.ui.graphics.colorspace.ColorSpaces r0 = androidx.compose.ui.graphics.colorspace.ColorSpaces.INSTANCE
            androidx.compose.ui.graphics.colorspace.Rgb r0 = r0.getSrgb()
            androidx.compose.ui.graphics.colorspace.ColorSpace r0 = (androidx.compose.ui.graphics.colorspace.ColorSpace) r0
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.Api26Bitmap.composeColorSpace$ui_graphics_release(android.graphics.Bitmap):androidx.compose.ui.graphics.colorspace.ColorSpace");
    }

    @JvmStatic
    public static final android.graphics.ColorSpace toFrameworkColorSpace$ui_graphics_release(ColorSpace $this$toFrameworkColorSpace) {
        ColorSpace.Named frameworkNamedSpace;
        Intrinsics.checkNotNullParameter($this$toFrameworkColorSpace, "<this>");
        if (Intrinsics.areEqual((Object) $this$toFrameworkColorSpace, (Object) ColorSpaces.INSTANCE.getSrgb())) {
            frameworkNamedSpace = ColorSpace.Named.SRGB;
        } else if (Intrinsics.areEqual((Object) $this$toFrameworkColorSpace, (Object) ColorSpaces.INSTANCE.getAces())) {
            frameworkNamedSpace = ColorSpace.Named.ACES;
        } else if (Intrinsics.areEqual((Object) $this$toFrameworkColorSpace, (Object) ColorSpaces.INSTANCE.getAcescg())) {
            frameworkNamedSpace = ColorSpace.Named.ACESCG;
        } else if (Intrinsics.areEqual((Object) $this$toFrameworkColorSpace, (Object) ColorSpaces.INSTANCE.getAdobeRgb())) {
            frameworkNamedSpace = ColorSpace.Named.ADOBE_RGB;
        } else if (Intrinsics.areEqual((Object) $this$toFrameworkColorSpace, (Object) ColorSpaces.INSTANCE.getBt2020())) {
            frameworkNamedSpace = ColorSpace.Named.BT2020;
        } else if (Intrinsics.areEqual((Object) $this$toFrameworkColorSpace, (Object) ColorSpaces.INSTANCE.getBt709())) {
            frameworkNamedSpace = ColorSpace.Named.BT709;
        } else if (Intrinsics.areEqual((Object) $this$toFrameworkColorSpace, (Object) ColorSpaces.INSTANCE.getCieLab())) {
            frameworkNamedSpace = ColorSpace.Named.CIE_LAB;
        } else if (Intrinsics.areEqual((Object) $this$toFrameworkColorSpace, (Object) ColorSpaces.INSTANCE.getCieXyz())) {
            frameworkNamedSpace = ColorSpace.Named.CIE_XYZ;
        } else if (Intrinsics.areEqual((Object) $this$toFrameworkColorSpace, (Object) ColorSpaces.INSTANCE.getDciP3())) {
            frameworkNamedSpace = ColorSpace.Named.DCI_P3;
        } else if (Intrinsics.areEqual((Object) $this$toFrameworkColorSpace, (Object) ColorSpaces.INSTANCE.getDisplayP3())) {
            frameworkNamedSpace = ColorSpace.Named.DISPLAY_P3;
        } else if (Intrinsics.areEqual((Object) $this$toFrameworkColorSpace, (Object) ColorSpaces.INSTANCE.getExtendedSrgb())) {
            frameworkNamedSpace = ColorSpace.Named.EXTENDED_SRGB;
        } else if (Intrinsics.areEqual((Object) $this$toFrameworkColorSpace, (Object) ColorSpaces.INSTANCE.getLinearExtendedSrgb())) {
            frameworkNamedSpace = ColorSpace.Named.LINEAR_EXTENDED_SRGB;
        } else if (Intrinsics.areEqual((Object) $this$toFrameworkColorSpace, (Object) ColorSpaces.INSTANCE.getLinearSrgb())) {
            frameworkNamedSpace = ColorSpace.Named.LINEAR_SRGB;
        } else if (Intrinsics.areEqual((Object) $this$toFrameworkColorSpace, (Object) ColorSpaces.INSTANCE.getNtsc1953())) {
            frameworkNamedSpace = ColorSpace.Named.NTSC_1953;
        } else if (Intrinsics.areEqual((Object) $this$toFrameworkColorSpace, (Object) ColorSpaces.INSTANCE.getProPhotoRgb())) {
            frameworkNamedSpace = ColorSpace.Named.PRO_PHOTO_RGB;
        } else if (Intrinsics.areEqual((Object) $this$toFrameworkColorSpace, (Object) ColorSpaces.INSTANCE.getSmpteC())) {
            frameworkNamedSpace = ColorSpace.Named.SMPTE_C;
        } else {
            frameworkNamedSpace = ColorSpace.Named.SRGB;
        }
        android.graphics.ColorSpace colorSpace = android.graphics.ColorSpace.get(frameworkNamedSpace);
        Intrinsics.checkNotNullExpressionValue(colorSpace, "get(frameworkNamedSpace)");
        return colorSpace;
    }

    @JvmStatic
    public static final androidx.compose.ui.graphics.colorspace.ColorSpace composeColorSpace$ui_graphics_release(android.graphics.ColorSpace $this$composeColorSpace) {
        Intrinsics.checkNotNullParameter($this$composeColorSpace, "<this>");
        if (Intrinsics.areEqual((Object) $this$composeColorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.SRGB))) {
            return ColorSpaces.INSTANCE.getSrgb();
        }
        if (Intrinsics.areEqual((Object) $this$composeColorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.ACES))) {
            return ColorSpaces.INSTANCE.getAces();
        }
        if (Intrinsics.areEqual((Object) $this$composeColorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.ACESCG))) {
            return ColorSpaces.INSTANCE.getAcescg();
        }
        if (Intrinsics.areEqual((Object) $this$composeColorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.ADOBE_RGB))) {
            return ColorSpaces.INSTANCE.getAdobeRgb();
        }
        if (Intrinsics.areEqual((Object) $this$composeColorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.BT2020))) {
            return ColorSpaces.INSTANCE.getBt2020();
        }
        if (Intrinsics.areEqual((Object) $this$composeColorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.BT709))) {
            return ColorSpaces.INSTANCE.getBt709();
        }
        if (Intrinsics.areEqual((Object) $this$composeColorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.CIE_LAB))) {
            return ColorSpaces.INSTANCE.getCieLab();
        }
        if (Intrinsics.areEqual((Object) $this$composeColorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.CIE_XYZ))) {
            return ColorSpaces.INSTANCE.getCieXyz();
        }
        if (Intrinsics.areEqual((Object) $this$composeColorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.DCI_P3))) {
            return ColorSpaces.INSTANCE.getDciP3();
        }
        if (Intrinsics.areEqual((Object) $this$composeColorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.DISPLAY_P3))) {
            return ColorSpaces.INSTANCE.getDisplayP3();
        }
        if (Intrinsics.areEqual((Object) $this$composeColorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.EXTENDED_SRGB))) {
            return ColorSpaces.INSTANCE.getExtendedSrgb();
        }
        if (Intrinsics.areEqual((Object) $this$composeColorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB))) {
            return ColorSpaces.INSTANCE.getLinearExtendedSrgb();
        }
        if (Intrinsics.areEqual((Object) $this$composeColorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.LINEAR_SRGB))) {
            return ColorSpaces.INSTANCE.getLinearSrgb();
        }
        if (Intrinsics.areEqual((Object) $this$composeColorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.NTSC_1953))) {
            return ColorSpaces.INSTANCE.getNtsc1953();
        }
        if (Intrinsics.areEqual((Object) $this$composeColorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.PRO_PHOTO_RGB))) {
            return ColorSpaces.INSTANCE.getProPhotoRgb();
        }
        if (Intrinsics.areEqual((Object) $this$composeColorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.SMPTE_C))) {
            return ColorSpaces.INSTANCE.getSmpteC();
        }
        return ColorSpaces.INSTANCE.getSrgb();
    }
}
