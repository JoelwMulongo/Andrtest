package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.IconButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u000f\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0019\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"DefaultIconSizeModifier", "Landroidx/compose/ui/Modifier;", "Icon", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "tint", "Landroidx/compose/ui/graphics/Color;", "Icon-ww6aTOc", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "defaultSizeFor", "isInfinite", "", "Landroidx/compose/ui/geometry/Size;", "isInfinite-uvyYCjk", "(J)Z", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Icon.kt */
public final class IconKt {
    private static final Modifier DefaultIconSizeModifier = SizeKt.m830size3ABfNKs(Modifier.Companion, IconButtonTokens.INSTANCE.m2491getIconSizeD9Ej5fM());

    /* renamed from: Icon-ww6aTOc  reason: not valid java name */
    public static final void m1961Iconww6aTOc(ImageVector imageVector, String contentDescription, Modifier modifier, long tint, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long tint2;
        long tint3;
        Modifier modifier3;
        Modifier modifier4;
        int i2;
        ImageVector imageVector2 = imageVector;
        int i3 = $changed;
        Intrinsics.checkNotNullParameter(imageVector2, "imageVector");
        Composer $composer2 = $composer.startRestartGroup(-126890956);
        ComposerKt.sourceInformation($composer2, "C(Icon)P(1!,3:c#ui.graphics.Color)59@2668L7,62@2708L34,61@2684L163:Icon.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer2.changed((Object) imageVector2) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
            String str = contentDescription;
        } else if ((i3 & 112) == 0) {
            $dirty |= $composer2.changed((Object) contentDescription) ? 32 : 16;
        } else {
            String str2 = contentDescription;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if ((i3 & 896) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ((i3 & 7168) == 0) {
            if ((i & 8) == 0) {
                tint2 = tint;
                if ($composer2.changed(tint2)) {
                    i2 = 2048;
                    $dirty |= i2;
                }
            } else {
                tint2 = tint;
            }
            i2 = 1024;
            $dirty |= i2;
        } else {
            tint2 = tint;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i3 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 8) != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(ContentColorKt.getLocalContentColor());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $dirty &= -7169;
                    tint2 = ((Color) consume).m3174unboximpl();
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                modifier4 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-126890956, $dirty, -1, "androidx.compose.material3.Icon (Icon.kt:55)");
            }
            m1960Iconww6aTOc((Painter) VectorPainterKt.rememberVectorPainter(imageVector2, $composer2, $dirty & 14), contentDescription, modifier4, tint2, $composer2, VectorPainter.$stable | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i5 = $dirty;
            modifier3 = modifier4;
            tint3 = tint2;
        } else {
            $composer2.skipToGroupEnd();
            int i6 = $dirty;
            modifier3 = modifier2;
            tint3 = tint2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new IconKt$Icon$1(imageVector, contentDescription, modifier3, tint3, $changed, i));
    }

    /* renamed from: Icon-ww6aTOc  reason: not valid java name */
    public static final void m1959Iconww6aTOc(ImageBitmap bitmap, String contentDescription, Modifier modifier, long tint, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long tint2;
        int $dirty;
        ImageBitmap imageBitmap = bitmap;
        Intrinsics.checkNotNullParameter(imageBitmap, "bitmap");
        Composer $composer2 = $composer.startRestartGroup(-1092052280);
        ComposerKt.sourceInformation($composer2, "C(Icon)P(!,3:c#ui.graphics.Color)89@3837L7,91@3867L42,92@3914L136:Icon.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 4) != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) != 0) {
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $dirty = $dirty2 & -7169;
            tint2 = ((Color) consume).m3174unboximpl();
        } else {
            tint2 = tint;
            $dirty = $dirty2;
        }
        if (ComposerKt.isTraceInProgress() != 0) {
            ComposerKt.traceEventStart(-1092052280, $dirty, -1, "androidx.compose.material3.Icon (Icon.kt:85)");
        }
        $composer2.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer2;
        boolean invalid$iv$iv = $composer2.changed((Object) imageBitmap);
        Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || value$iv$iv == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv;
            value$iv$iv = new BitmapPainter(bitmap, 0, 0, 6, (DefaultConstructorMarker) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            Object obj2 = value$iv$iv;
        }
        $composer2.endReplaceableGroup();
        int i2 = $dirty;
        Composer $composer3 = $composer2;
        m1960Iconww6aTOc((Painter) (BitmapPainter) value$iv$iv, contentDescription, modifier2, tint2, $composer2, ($dirty & 112) | 8 | ($dirty & 896) | ($dirty & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new IconKt$Icon$2(bitmap, contentDescription, modifier2, tint2, $changed, i));
        }
    }

    /* renamed from: Icon-ww6aTOc  reason: not valid java name */
    public static final void m1960Iconww6aTOc(Painter painter, String contentDescription, Modifier modifier, long tint, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long tint2;
        int $dirty;
        Modifier modifier3;
        Object value$iv$iv;
        Painter painter2 = painter;
        String str = contentDescription;
        Intrinsics.checkNotNullParameter(painter2, "painter");
        Composer $composer2 = $composer.startRestartGroup(-2142239481);
        ComposerKt.sourceInformation($composer2, "C(Icon)P(2!,3:c#ui.graphics.Color)120@5038L7,132@5397L217:Icon.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 4) != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) != 0) {
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $dirty = $dirty2 & -7169;
            tint2 = ((Color) consume).m3174unboximpl();
        } else {
            tint2 = tint;
            $dirty = $dirty2;
        }
        if (ComposerKt.isTraceInProgress() != 0) {
            ComposerKt.traceEventStart(-2142239481, $dirty, -1, "androidx.compose.material3.Icon (Icon.kt:116)");
        }
        ColorFilter colorFilter = Color.m3165equalsimpl0(tint2, Color.Companion.m3200getUnspecified0d7_KjU()) ? null : ColorFilter.Companion.m3205tintxETnrds$default(ColorFilter.Companion, tint2, 0, 2, (Object) null);
        $composer2.startReplaceableGroup(69355216);
        ComposerKt.sourceInformation($composer2, "125@5229L115");
        if (str != null) {
            Modifier modifier4 = Modifier.Companion;
            int i2 = ($dirty >> 3) & 14;
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed((Object) str);
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = (Function1) new IconKt$Icon$semantics$1$1(str);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            modifier3 = SemanticsModifierKt.semantics$default(modifier4, false, (Function1) value$iv$iv, 1, (Object) null);
        } else {
            modifier3 = Modifier.Companion;
        }
        $composer2.endReplaceableGroup();
        Modifier semantics = modifier3;
        BoxKt.Box(PainterModifierKt.paint$default(defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(modifier2), painter2), painter, false, (Alignment) null, ContentScale.Companion.getFit(), 0.0f, colorFilter, 22, (Object) null).then(semantics), $composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Modifier modifier5 = semantics;
            int i3 = $dirty;
            long j = tint2;
            Composer composer = $composer2;
            return;
        }
        Modifier modifier6 = semantics;
        int i4 = $dirty;
        long j2 = tint2;
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new IconKt$Icon$3(painter, contentDescription, modifier2, tint2, $changed, i));
    }

    private static final Modifier defaultSizeFor(Modifier $this$defaultSizeFor, Painter painter) {
        Modifier modifier;
        if (Size.m2980equalsimpl0(painter.m3867getIntrinsicSizeNHjbRc(), Size.Companion.m2992getUnspecifiedNHjbRc()) || m1962isInfiniteuvyYCjk(painter.m3867getIntrinsicSizeNHjbRc())) {
            modifier = DefaultIconSizeModifier;
        } else {
            modifier = Modifier.Companion;
        }
        return $this$defaultSizeFor.then(modifier);
    }

    /* renamed from: isInfinite-uvyYCjk  reason: not valid java name */
    private static final boolean m1962isInfiniteuvyYCjk(long $this$isInfinite_u2duvyYCjk) {
        return Float.isInfinite(Size.m2984getWidthimpl($this$isInfinite_u2duvyYCjk)) && Float.isInfinite(Size.m2981getHeightimpl($this$isInfinite_u2duvyYCjk));
    }
}
