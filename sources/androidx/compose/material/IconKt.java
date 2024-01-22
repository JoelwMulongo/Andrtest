package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u000f\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0019\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"DefaultIconSizeModifier", "Landroidx/compose/ui/Modifier;", "Icon", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "tint", "Landroidx/compose/ui/graphics/Color;", "Icon-ww6aTOc", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "defaultSizeFor", "isInfinite", "", "Landroidx/compose/ui/geometry/Size;", "isInfinite-uvyYCjk", "(J)Z", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Icon.kt */
public final class IconKt {
    private static final Modifier DefaultIconSizeModifier = SizeKt.m830size3ABfNKs(Modifier.Companion, Dp.m5986constructorimpl((float) 24));

    /* renamed from: Icon-ww6aTOc  reason: not valid java name */
    public static final void m1528Iconww6aTOc(ImageVector imageVector, String contentDescription, Modifier modifier, long tint, Composer $composer, int $changed, int i) {
        long tint2;
        ImageVector imageVector2 = imageVector;
        Composer composer = $composer;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(imageVector2, "imageVector");
        composer.startReplaceableGroup(-800853103);
        ComposerKt.sourceInformation(composer, "C(Icon)P(1!,3:c#ui.graphics.Color)65@3149L7,65@3188L7,68@3229L34,67@3205L163:Icon.kt#jmzs0o");
        Modifier modifier2 = (i & 4) != 0 ? Modifier.Companion : modifier;
        if ((i & 8) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd($composer);
            long r12 = ((Color) consume).m3174unboximpl();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(ContentAlphaKt.getLocalContentAlpha());
            ComposerKt.sourceInformationMarkerEnd($composer);
            tint2 = Color.m3163copywmQWz5c$default(r12, ((Number) consume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            tint2 = tint;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-800853103, i2, -1, "androidx.compose.material.Icon (Icon.kt:61)");
        }
        m1527Iconww6aTOc((Painter) VectorPainterKt.rememberVectorPainter(imageVector2, composer, i2 & 14), contentDescription, modifier2, tint2, $composer, VectorPainter.$stable | (i2 & 112) | (i2 & 896) | (i2 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    /* renamed from: Icon-ww6aTOc  reason: not valid java name */
    public static final void m1526Iconww6aTOc(ImageBitmap bitmap, String contentDescription, Modifier modifier, long tint, Composer $composer, int $changed, int i) {
        long tint2;
        ImageBitmap imageBitmap = bitmap;
        Composer composer = $composer;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(imageBitmap, "bitmap");
        composer.startReplaceableGroup(-554892675);
        ComposerKt.sourceInformation(composer, "C(Icon)P(!,3:c#ui.graphics.Color)99@4800L7,99@4839L7,101@4870L42,102@4917L136:Icon.kt#jmzs0o");
        Modifier modifier2 = (i & 4) != 0 ? Modifier.Companion : modifier;
        if ((i & 8) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd($composer);
            long r13 = ((Color) consume).m3174unboximpl();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(ContentAlphaKt.getLocalContentAlpha());
            ComposerKt.sourceInformationMarkerEnd($composer);
            tint2 = Color.m3163copywmQWz5c$default(r13, ((Number) consume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            tint2 = tint;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-554892675, i2, -1, "androidx.compose.material.Icon (Icon.kt:95)");
        }
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) imageBitmap);
        Composer $this$cache$iv$iv = $composer;
        Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || value$iv$iv == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv;
            value$iv$iv = new BitmapPainter(bitmap, 0, 0, 6, (DefaultConstructorMarker) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            Object obj2 = value$iv$iv;
            Composer composer2 = $this$cache$iv$iv;
        }
        $composer.endReplaceableGroup();
        m1527Iconww6aTOc((Painter) (BitmapPainter) value$iv$iv, contentDescription, modifier2, tint2, $composer, (i2 & 112) | 8 | (i2 & 896) | (i2 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    /* renamed from: Icon-ww6aTOc  reason: not valid java name */
    public static final void m1527Iconww6aTOc(Painter painter, String contentDescription, Modifier modifier, long tint, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long tint2;
        int $dirty;
        Modifier modifier3;
        Object value$iv$iv;
        Painter painter2 = painter;
        String str = contentDescription;
        Intrinsics.checkNotNullParameter(painter2, "painter");
        Composer $composer2 = $composer.startRestartGroup(-1142959010);
        ComposerKt.sourceInformation($composer2, "C(Icon)P(2!,3:c#ui.graphics.Color)133@6456L7,133@6495L7,145@6878L253:Icon.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 4) != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) != 0) {
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            long r17 = ((Color) consume).m3174unboximpl();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(ContentAlphaKt.getLocalContentAlpha());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $dirty = $dirty2 & -7169;
            tint2 = Color.m3163copywmQWz5c$default(r17, ((Number) consume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            tint2 = tint;
            $dirty = $dirty2;
        }
        if (ComposerKt.isTraceInProgress() != 0) {
            ComposerKt.traceEventStart(-1142959010, $dirty, -1, "androidx.compose.material.Icon (Icon.kt:129)");
        }
        ColorFilter colorFilter = Color.m3165equalsimpl0(tint2, Color.Companion.m3200getUnspecified0d7_KjU()) ? null : ColorFilter.Companion.m3205tintxETnrds$default(ColorFilter.Companion, tint2, 0, 2, (Object) null);
        $composer2.startReplaceableGroup(1547387026);
        ComposerKt.sourceInformation($composer2, "138@6734L103");
        if (str != null) {
            Modifier modifier4 = Modifier.Companion;
            int i2 = ($dirty >> 3) & 14;
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
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
        endRestartGroup.updateScope(new IconKt$Icon$1(painter, contentDescription, modifier2, tint2, $changed, i));
    }

    private static final Modifier defaultSizeFor(Modifier $this$defaultSizeFor, Painter painter) {
        Modifier modifier;
        if (Size.m2980equalsimpl0(painter.m3867getIntrinsicSizeNHjbRc(), Size.Companion.m2992getUnspecifiedNHjbRc()) || m1529isInfiniteuvyYCjk(painter.m3867getIntrinsicSizeNHjbRc())) {
            modifier = DefaultIconSizeModifier;
        } else {
            modifier = Modifier.Companion;
        }
        return $this$defaultSizeFor.then(modifier);
    }

    /* renamed from: isInfinite-uvyYCjk  reason: not valid java name */
    private static final boolean m1529isInfiniteuvyYCjk(long $this$isInfinite_u2duvyYCjk) {
        return Float.isInfinite(Size.m2984getWidthimpl($this$isInfinite_u2duvyYCjk)) && Float.isInfinite(Size.m2981getHeightimpl($this$isInfinite_u2duvyYCjk));
    }
}
