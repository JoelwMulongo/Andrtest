package androidx.compose.ui.res;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.LoadedFontFamily;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.font.Typeface;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\b\u001a\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"cacheLock", "Ljava/lang/Object;", "syncLoadedTypefaces", "", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/Typeface;", "fontResource", "fontFamily", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/font/Typeface;", "fontResourceFromContext", "context", "Landroid/content/Context;", "a", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontResources.android.kt */
public final class FontResources_androidKt {
    private static final Object cacheLock = new Object();
    private static final Map<FontFamily, Typeface> syncLoadedTypefaces = new LinkedHashMap();

    @Deprecated(level = DeprecationLevel.WARNING, message = "Prefer to preload fonts using FontFamily.Resolver.", replaceWith = @ReplaceWith(expression = "FontFamily.Resolver.preload(fontFamily, Font.AndroidResourceLoader(context))", imports = {}))
    public static final Typeface fontResource(FontFamily fontFamily, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        ComposerKt.sourceInformationMarkerStart($composer, -190831095, "C(fontResource)54@1901L7:FontResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-190831095, $changed, -1, "androidx.compose.ui.res.fontResource (FontResources.android.kt:53)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Typeface fontResourceFromContext = fontResourceFromContext((Context) consume, fontFamily);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return fontResourceFromContext;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Prefer to preload fonts using FontFamily.Resolver.", replaceWith = @ReplaceWith(expression = "FontFamily.Resolver.preload(fontFamily, Font.AndroidResourceLoader(context))", imports = {}))
    private static final Typeface fontResourceFromContext(Context context, FontFamily a) {
        Object answer$iv;
        Typeface typeface;
        if (!(a instanceof SystemFontFamily) && !(a instanceof LoadedFontFamily)) {
            return AndroidTypeface_androidKt.Typeface$default(context, a, (List) null, 4, (Object) null);
        }
        synchronized (cacheLock) {
            Map $this$getOrPut$iv = syncLoadedTypefaces;
            Object value$iv = $this$getOrPut$iv.get(a);
            if (value$iv == null) {
                answer$iv = AndroidTypeface_androidKt.Typeface$default(context, a, (List) null, 4, (Object) null);
                $this$getOrPut$iv.put(a, answer$iv);
            } else {
                answer$iv = value$iv;
            }
            typeface = (Typeface) answer$iv;
        }
        return typeface;
    }
}
