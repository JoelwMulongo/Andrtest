package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001d\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0001\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0001\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001b\u001a\u001f\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0014\u0010 \u001a\u00020!*\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"LocalColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/Colors;", "getLocalColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "primarySurface", "Landroidx/compose/ui/graphics/Color;", "getPrimarySurface", "(Landroidx/compose/material/Colors;)J", "contentColorFor", "backgroundColor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "darkColors", "primary", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "darkColors-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material/Colors;", "lightColors", "lightColors-2qZNXz8", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material/Colors;J)J", "updateColorsFrom", "", "other", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Colors.kt */
public final class ColorsKt {
    private static final ProvidableCompositionLocal<Colors> LocalColors = CompositionLocalKt.staticCompositionLocalOf(ColorsKt$LocalColors$1.INSTANCE);

    /* renamed from: lightColors-2qZNXz8$default  reason: not valid java name */
    public static /* synthetic */ Colors m1467lightColors2qZNXz8$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, int i, Object obj) {
        long j13;
        long j14;
        long j15;
        long j16;
        int i2 = i;
        if ((i2 & 1) != 0) {
            j13 = ColorKt.Color(4284612846L);
        } else {
            j13 = j;
        }
        if ((i2 & 2) != 0) {
            j14 = ColorKt.Color(4281794739L);
        } else {
            j14 = j2;
        }
        if ((i2 & 4) != 0) {
            j15 = ColorKt.Color(4278442694L);
        } else {
            j15 = j3;
        }
        if ((i2 & 8) != 0) {
            j16 = ColorKt.Color(4278290310L);
        } else {
            j16 = j4;
        }
        return m1466lightColors2qZNXz8(j13, j14, j15, j16, (i2 & 16) != 0 ? Color.Companion.m3201getWhite0d7_KjU() : j5, (i2 & 32) != 0 ? Color.Companion.m3201getWhite0d7_KjU() : j6, (i2 & 64) != 0 ? ColorKt.Color(4289724448L) : j7, (i2 & 128) != 0 ? Color.Companion.m3201getWhite0d7_KjU() : j8, (i2 & 256) != 0 ? Color.Companion.m3190getBlack0d7_KjU() : j9, (i2 & 512) != 0 ? Color.Companion.m3190getBlack0d7_KjU() : j10, (i2 & 1024) != 0 ? Color.Companion.m3190getBlack0d7_KjU() : j11, (i2 & 2048) != 0 ? Color.Companion.m3201getWhite0d7_KjU() : j12);
    }

    /* renamed from: lightColors-2qZNXz8  reason: not valid java name */
    public static final Colors m1466lightColors2qZNXz8(long primary, long primaryVariant, long secondary, long secondaryVariant, long background, long surface, long error, long onPrimary, long onSecondary, long onBackground, long onSurface, long onError) {
        return new Colors(primary, primaryVariant, secondary, secondaryVariant, background, surface, error, onPrimary, onSecondary, onBackground, onSurface, onError, true, (DefaultConstructorMarker) null);
    }

    /* renamed from: darkColors-2qZNXz8$default  reason: not valid java name */
    public static /* synthetic */ Colors m1465darkColors2qZNXz8$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, int i, Object obj) {
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        int i2 = i;
        if ((i2 & 1) != 0) {
            j13 = ColorKt.Color(4290479868L);
        } else {
            j13 = j;
        }
        if ((i2 & 2) != 0) {
            j14 = ColorKt.Color(4281794739L);
        } else {
            j14 = j2;
        }
        if ((i2 & 4) != 0) {
            j15 = ColorKt.Color(4278442694L);
        } else {
            j15 = j3;
        }
        if ((i2 & 8) != 0) {
            j16 = j15;
        } else {
            j16 = j4;
        }
        if ((i2 & 16) != 0) {
            j17 = ColorKt.Color(4279374354L);
        } else {
            j17 = j5;
        }
        if ((i2 & 32) != 0) {
            j18 = ColorKt.Color(4279374354L);
        } else {
            j18 = j6;
        }
        return m1464darkColors2qZNXz8(j13, j14, j15, j16, j17, j18, (i2 & 64) != 0 ? ColorKt.Color(4291782265L) : j7, (i2 & 128) != 0 ? Color.Companion.m3190getBlack0d7_KjU() : j8, (i2 & 256) != 0 ? Color.Companion.m3190getBlack0d7_KjU() : j9, (i2 & 512) != 0 ? Color.Companion.m3201getWhite0d7_KjU() : j10, (i2 & 1024) != 0 ? Color.Companion.m3201getWhite0d7_KjU() : j11, (i2 & 2048) != 0 ? Color.Companion.m3190getBlack0d7_KjU() : j12);
    }

    /* renamed from: darkColors-2qZNXz8  reason: not valid java name */
    public static final Colors m1464darkColors2qZNXz8(long primary, long primaryVariant, long secondary, long secondaryVariant, long background, long surface, long error, long onPrimary, long onSecondary, long onBackground, long onSurface, long onError) {
        return new Colors(primary, primaryVariant, secondary, secondaryVariant, background, surface, error, onPrimary, onSecondary, onBackground, onSurface, onError, false, (DefaultConstructorMarker) null);
    }

    public static final long getPrimarySurface(Colors $this$primarySurface) {
        Intrinsics.checkNotNullParameter($this$primarySurface, "<this>");
        return $this$primarySurface.isLight() ? $this$primarySurface.m1445getPrimary0d7_KjU() : $this$primarySurface.m1449getSurface0d7_KjU();
    }

    /* renamed from: contentColorFor-4WTKRHQ  reason: not valid java name */
    public static final long m1462contentColorFor4WTKRHQ(Colors $this$contentColorFor_u2d4WTKRHQ, long backgroundColor) {
        Intrinsics.checkNotNullParameter($this$contentColorFor_u2d4WTKRHQ, "$this$contentColorFor");
        if (Color.m3165equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m1445getPrimary0d7_KjU())) {
            return $this$contentColorFor_u2d4WTKRHQ.m1442getOnPrimary0d7_KjU();
        }
        if (Color.m3165equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m1446getPrimaryVariant0d7_KjU())) {
            return $this$contentColorFor_u2d4WTKRHQ.m1442getOnPrimary0d7_KjU();
        }
        if (Color.m3165equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m1447getSecondary0d7_KjU())) {
            return $this$contentColorFor_u2d4WTKRHQ.m1443getOnSecondary0d7_KjU();
        }
        if (Color.m3165equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m1448getSecondaryVariant0d7_KjU())) {
            return $this$contentColorFor_u2d4WTKRHQ.m1443getOnSecondary0d7_KjU();
        }
        if (Color.m3165equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m1438getBackground0d7_KjU())) {
            return $this$contentColorFor_u2d4WTKRHQ.m1440getOnBackground0d7_KjU();
        }
        if (Color.m3165equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m1449getSurface0d7_KjU())) {
            return $this$contentColorFor_u2d4WTKRHQ.m1444getOnSurface0d7_KjU();
        }
        if (Color.m3165equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m1439getError0d7_KjU())) {
            return $this$contentColorFor_u2d4WTKRHQ.m1441getOnError0d7_KjU();
        }
        return Color.Companion.m3200getUnspecified0d7_KjU();
    }

    /* renamed from: contentColorFor-ek8zF_U  reason: not valid java name */
    public static final long m1463contentColorForek8zF_U(long backgroundColor, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 441849991, "C(contentColorFor)P(0:c#ui.graphics.Color)*296@11462L6,296@11533L7:Colors.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(441849991, $changed, -1, "androidx.compose.material.contentColorFor (Colors.kt:295)");
        }
        long $this$takeOrElse_u2dDxMtmZc$iv = m1462contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColors($composer, 6), backgroundColor);
        if (!($this$takeOrElse_u2dDxMtmZc$iv != Color.Companion.m3200getUnspecified0d7_KjU())) {
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd($composer);
            $this$takeOrElse_u2dDxMtmZc$iv = ((Color) consume).m3174unboximpl();
        }
        if (ComposerKt.isTraceInProgress() != 0) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return $this$takeOrElse_u2dDxMtmZc$iv;
    }

    public static final void updateColorsFrom(Colors $this$updateColorsFrom, Colors other) {
        Intrinsics.checkNotNullParameter($this$updateColorsFrom, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        $this$updateColorsFrom.m1457setPrimary8_81llA$material_release(other.m1445getPrimary0d7_KjU());
        $this$updateColorsFrom.m1458setPrimaryVariant8_81llA$material_release(other.m1446getPrimaryVariant0d7_KjU());
        $this$updateColorsFrom.m1459setSecondary8_81llA$material_release(other.m1447getSecondary0d7_KjU());
        $this$updateColorsFrom.m1460setSecondaryVariant8_81llA$material_release(other.m1448getSecondaryVariant0d7_KjU());
        $this$updateColorsFrom.m1450setBackground8_81llA$material_release(other.m1438getBackground0d7_KjU());
        $this$updateColorsFrom.m1461setSurface8_81llA$material_release(other.m1449getSurface0d7_KjU());
        $this$updateColorsFrom.m1451setError8_81llA$material_release(other.m1439getError0d7_KjU());
        $this$updateColorsFrom.m1454setOnPrimary8_81llA$material_release(other.m1442getOnPrimary0d7_KjU());
        $this$updateColorsFrom.m1455setOnSecondary8_81llA$material_release(other.m1443getOnSecondary0d7_KjU());
        $this$updateColorsFrom.m1452setOnBackground8_81llA$material_release(other.m1440getOnBackground0d7_KjU());
        $this$updateColorsFrom.m1456setOnSurface8_81llA$material_release(other.m1444getOnSurface0d7_KjU());
        $this$updateColorsFrom.m1453setOnError8_81llA$material_release(other.m1441getOnError0d7_KjU());
        $this$updateColorsFrom.setLight$material_release(other.isLight());
    }

    public static final ProvidableCompositionLocal<Colors> getLocalColors() {
        return LocalColors;
    }
}
