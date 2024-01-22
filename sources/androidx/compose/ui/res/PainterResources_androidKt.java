package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.graphics.vector.compat.XmlVectorParser_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.ImageVectorCache;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a1\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bR\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\r\u001a\u0017\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"errorMessage", "", "loadImageBitmapResource", "Landroidx/compose/ui/graphics/ImageBitmap;", "res", "Landroid/content/res/Resources;", "id", "", "loadVectorResource", "Landroidx/compose/ui/graphics/vector/ImageVector;", "theme", "Landroid/content/res/Resources$Theme;", "changingConfigurations", "(Landroid/content/res/Resources$Theme;Landroid/content/res/Resources;IILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/ImageVector;", "painterResource", "Landroidx/compose/ui/graphics/painter/Painter;", "(ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PainterResources.android.kt */
public final class PainterResources_androidKt {
    private static final String errorMessage = "Only VectorDrawables and rasterized asset types are supported ex. PNG, JPG";

    public static final Painter painterResource(int id, Composer $composer, int $changed) {
        Object value$iv$iv;
        Painter painter;
        Object value$iv$iv2;
        int i = id;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(473971343);
        ComposerKt.sourceInformation(composer, "C(painterResource)57@2406L7,58@2428L11,59@2456L25:PainterResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(473971343, i2, -1, "androidx.compose.ui.res.painterResource (PainterResources.android.kt:56)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Context context = (Context) consume;
        Resources res = Resources_androidKt.resources(composer, 0);
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = new TypedValue();
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        TypedValue value = (TypedValue) value$iv$iv;
        boolean z = true;
        res.getValue(i, value, true);
        CharSequence path = value.string;
        if (path == null || !StringsKt.endsWith$default(path, (CharSequence) ".xml", false, 2, (Object) null)) {
            z = false;
        }
        if (z) {
            composer.startReplaceableGroup(-738265327);
            ComposerKt.sourceInformation(composer, "64@2687L72,65@2768L34");
            Resources.Theme theme = context.getTheme();
            Intrinsics.checkNotNullExpressionValue(theme, "context.theme");
            VectorPainter rememberVectorPainter = VectorPainterKt.rememberVectorPainter(loadVectorResource(theme, res, id, value.changingConfigurations, $composer, ((i2 << 6) & 896) | 72), composer, 0);
            $composer.endReplaceableGroup();
            painter = rememberVectorPainter;
        } else {
            composer.startReplaceableGroup(-738265172);
            ComposerKt.sourceInformation(composer, "68@2888L90");
            Object valueOf = Integer.valueOf(id);
            Object key3$iv = context.getTheme();
            int i3 = ((i2 << 3) & 112) | 520;
            composer.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean invalid$iv$iv = composer.changed((Object) path) | composer.changed(valueOf) | composer.changed(key3$iv);
            Composer $this$cache$iv$iv2 = $composer;
            Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
            if (!invalid$iv$iv) {
                Integer num = valueOf;
                if (it$iv$iv2 != Composer.Companion.getEmpty()) {
                    value$iv$iv2 = it$iv$iv2;
                    $composer.endReplaceableGroup();
                    BitmapPainter bitmapPainter = new BitmapPainter((ImageBitmap) value$iv$iv2, 0, 0, 6, (DefaultConstructorMarker) null);
                    $composer.endReplaceableGroup();
                    painter = bitmapPainter;
                }
            } else {
                Object key2$iv = valueOf;
            }
            value$iv$iv2 = loadImageBitmapResource(res, i);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
            $composer.endReplaceableGroup();
            BitmapPainter bitmapPainter2 = new BitmapPainter((ImageBitmap) value$iv$iv2, 0, 0, 6, (DefaultConstructorMarker) null);
            $composer.endReplaceableGroup();
            painter = bitmapPainter2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return painter;
    }

    private static final ImageVector loadVectorResource(Resources.Theme theme, Resources res, int id, int changingConfigurations, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(21855625);
        ComposerKt.sourceInformation($composer, "C(loadVectorResource)P(3,2,1)87@3464L7:PainterResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(21855625, $changed, -1, "androidx.compose.ui.res.loadVectorResource (PainterResources.android.kt:81)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(AndroidCompositionLocals_androidKt.getLocalImageVectorCache());
        ComposerKt.sourceInformationMarkerEnd($composer);
        ImageVectorCache imageVectorCache = (ImageVectorCache) consume;
        ImageVectorCache.Key key = new ImageVectorCache.Key(theme, id);
        ImageVectorCache.ImageVectorEntry imageVectorEntry = imageVectorCache.get(key);
        if (imageVectorEntry == null) {
            XmlResourceParser parser = res.getXml(id);
            Intrinsics.checkNotNullExpressionValue(parser, "res.getXml(id)");
            if (Intrinsics.areEqual((Object) XmlVectorParser_androidKt.seekToStartTag(parser).getName(), (Object) "vector")) {
                imageVectorEntry = VectorResources_androidKt.loadVectorResourceInner(theme, res, parser, changingConfigurations);
                imageVectorCache.set(key, imageVectorEntry);
            } else {
                throw new IllegalArgumentException(errorMessage);
            }
        }
        ImageVector imageVector = imageVectorEntry.getImageVector();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return imageVector;
    }

    /* access modifiers changed from: private */
    public static final ImageBitmap loadImageBitmapResource(Resources res, int id) {
        try {
            return ImageResources_androidKt.imageResource(ImageBitmap.Companion, res, id);
        } catch (Throwable th) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
