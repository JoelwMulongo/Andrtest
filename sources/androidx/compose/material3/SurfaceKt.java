package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0001\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001ap\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a \u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060#2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010$\u001a%\u0010%\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0002H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a;\u0010)\u001a\u00020\n*\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"LocalAbsoluteTonalElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/unit/Dp;", "getLocalAbsoluteTonalElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "shadowElevation", "border", "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "Surface-o_FOJdg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Surface-T9BRK9s", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-d85dljk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surfaceColorAtElevation", "elevation", "surfaceColorAtElevation-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "surface", "backgroundColor", "surface-8ww4TTg", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Surface.kt */
public final class SurfaceKt {
    private static final ProvidableCompositionLocal<Dp> LocalAbsoluteTonalElevation = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, SurfaceKt$LocalAbsoluteTonalElevation$1.INSTANCE, 1, (Object) null);

    /* renamed from: Surface-T9BRK9s  reason: not valid java name */
    public static final void m2097SurfaceT9BRK9s(Modifier modifier, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Shape shape2;
        long color2;
        long contentColor2;
        float tonalElevation2;
        float shadowElevation2;
        BorderStroke border2;
        Composer composer = $composer;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(-513881741);
        ComposerKt.sourceInformation(composer, "C(Surface)P(4,6,1:c#ui.graphics.Color,3:c#ui.graphics.Color,7:c#ui.unit.Dp,5:c#ui.unit.Dp)101@5053L11,102@5100L22,*108@5317L7,109@5346L728:Surface.kt#uh7d8r");
        Modifier modifier2 = (i & 1) != 0 ? Modifier.Companion : modifier;
        if ((i & 2) != 0) {
            shape2 = RectangleShapeKt.getRectangleShape();
        } else {
            shape2 = shape;
        }
        if ((i & 4) != 0) {
            color2 = MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1818getSurface0d7_KjU();
        } else {
            color2 = color;
        }
        if ((i & 8) != 0) {
            contentColor2 = ColorSchemeKt.m1854contentColorForek8zF_U(color2, composer, (i2 >> 6) & 14);
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 16) != 0) {
            tonalElevation2 = Dp.m5986constructorimpl((float) 0);
        } else {
            tonalElevation2 = tonalElevation;
        }
        if ((i & 32) != 0) {
            shadowElevation2 = Dp.m5986constructorimpl((float) 0);
        } else {
            shadowElevation2 = shadowElevation;
        }
        if ((i & 64) != 0) {
            border2 = null;
        } else {
            border2 = border;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-513881741, i2, -1, "androidx.compose.material3.Surface (Surface.kt:98)");
        }
        ProvidableCompositionLocal<Dp> this_$iv = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        float absoluteElevation = Dp.m5986constructorimpl(((Dp) consume).m6000unboximpl() + tonalElevation2);
        SurfaceKt$Surface$1 surfaceKt$Surface$1 = r1;
        long j = color2;
        SurfaceKt$Surface$1 surfaceKt$Surface$12 = new SurfaceKt$Surface$1(modifier2, shape2, color2, absoluteElevation, $changed, border2, shadowElevation2, content);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(contentColor2)), this_$iv.provides(Dp.m5984boximpl(absoluteElevation))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, -70914509, true, surfaceKt$Surface$1), composer, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    @ExperimentalMaterial3Api
    /* renamed from: Surface-o_FOJdg  reason: not valid java name */
    public static final void m2100Surfaceo_FOJdg(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i) {
        boolean enabled2;
        Shape shape2;
        long color2;
        long contentColor2;
        float tonalElevation2;
        float shadowElevation2;
        BorderStroke border2;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource mutableInteractionSource;
        Composer composer = $composer;
        int i2 = $changed;
        int i3 = i;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(-789752804);
        ComposerKt.sourceInformation(composer, "C(Surface)P(7,6,4,9,1:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.unit.Dp,8:c#ui.unit.Dp!1,5)205@10448L11,206@10495L22,210@10666L39,*213@10803L7,214@10832L948:Surface.kt#uh7d8r");
        Modifier modifier2 = (i3 & 2) != 0 ? Modifier.Companion : modifier;
        if ((i3 & 4) != 0) {
            enabled2 = true;
        } else {
            enabled2 = enabled;
        }
        if ((i3 & 8) != 0) {
            shape2 = RectangleShapeKt.getRectangleShape();
        } else {
            shape2 = shape;
        }
        if ((i3 & 16) != 0) {
            color2 = MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1818getSurface0d7_KjU();
        } else {
            color2 = color;
        }
        if ((i3 & 32) != 0) {
            contentColor2 = ColorSchemeKt.m1854contentColorForek8zF_U(color2, composer, (i2 >> 12) & 14);
        } else {
            contentColor2 = contentColor;
        }
        if ((i3 & 64) != 0) {
            tonalElevation2 = Dp.m5986constructorimpl((float) 0);
        } else {
            tonalElevation2 = tonalElevation;
        }
        if ((i3 & 128) != 0) {
            shadowElevation2 = Dp.m5986constructorimpl((float) 0);
        } else {
            shadowElevation2 = shadowElevation;
        }
        if ((i3 & 256) != 0) {
            border2 = null;
        } else {
            border2 = border;
        }
        if ((i3 & 512) != 0) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
                $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource);
            } else {
                mutableInteractionSource = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            interactionSource2 = mutableInteractionSource;
        } else {
            interactionSource2 = interactionSource;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-789752804, i2, $changed1, "androidx.compose.material3.Surface (Surface.kt:200)");
        } else {
            int i4 = $changed1;
        }
        ProvidableCompositionLocal<Dp> this_$iv = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        float absoluteElevation = Dp.m5986constructorimpl(((Dp) consume).m6000unboximpl() + tonalElevation2);
        SurfaceKt$Surface$3 surfaceKt$Surface$3 = r1;
        long j = color2;
        SurfaceKt$Surface$3 surfaceKt$Surface$32 = new SurfaceKt$Surface$3(modifier2, shape2, color2, absoluteElevation, $changed, border2, shadowElevation2, interactionSource2, enabled2, onClick, content, $changed1);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(contentColor2)), this_$iv.provides(Dp.m5984boximpl(absoluteElevation))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 1279702876, true, surfaceKt$Surface$3), composer, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    @ExperimentalMaterial3Api
    /* renamed from: Surface-d85dljk  reason: not valid java name */
    public static final void m2098Surfaced85dljk(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i) {
        boolean enabled2;
        Shape shape2;
        long color2;
        long contentColor2;
        float tonalElevation2;
        float shadowElevation2;
        BorderStroke border2;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource mutableInteractionSource;
        Composer composer = $composer;
        int i2 = $changed;
        int i3 = i;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(540296512);
        ComposerKt.sourceInformation(composer, "C(Surface)P(8,7,6,4,10,1:c#ui.graphics.Color,3:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp!1,5)317@16096L11,318@16143L22,322@16314L39,*325@16451L7,326@16480L987:Surface.kt#uh7d8r");
        Modifier modifier2 = (i3 & 4) != 0 ? Modifier.Companion : modifier;
        if ((i3 & 8) != 0) {
            enabled2 = true;
        } else {
            enabled2 = enabled;
        }
        if ((i3 & 16) != 0) {
            shape2 = RectangleShapeKt.getRectangleShape();
        } else {
            shape2 = shape;
        }
        if ((i3 & 32) != 0) {
            color2 = MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1818getSurface0d7_KjU();
        } else {
            color2 = color;
        }
        if ((i3 & 64) != 0) {
            contentColor2 = ColorSchemeKt.m1854contentColorForek8zF_U(color2, composer, (i2 >> 15) & 14);
        } else {
            contentColor2 = contentColor;
        }
        if ((i3 & 128) != 0) {
            tonalElevation2 = Dp.m5986constructorimpl((float) 0);
        } else {
            tonalElevation2 = tonalElevation;
        }
        if ((i3 & 256) != 0) {
            shadowElevation2 = Dp.m5986constructorimpl((float) 0);
        } else {
            shadowElevation2 = shadowElevation;
        }
        if ((i3 & 512) != 0) {
            border2 = null;
        } else {
            border2 = border;
        }
        if ((i3 & 1024) != 0) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
                $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource);
            } else {
                mutableInteractionSource = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            interactionSource2 = mutableInteractionSource;
        } else {
            interactionSource2 = interactionSource;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(540296512, i2, $changed1, "androidx.compose.material3.Surface (Surface.kt:311)");
        } else {
            int i4 = $changed1;
        }
        ProvidableCompositionLocal<Dp> this_$iv = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        float absoluteElevation = Dp.m5986constructorimpl(((Dp) consume).m6000unboximpl() + tonalElevation2);
        SurfaceKt$Surface$5 surfaceKt$Surface$5 = r1;
        long j = color2;
        SurfaceKt$Surface$5 surfaceKt$Surface$52 = new SurfaceKt$Surface$5(modifier2, shape2, color2, absoluteElevation, $changed, border2, shadowElevation2, selected, interactionSource2, enabled2, onClick, content, $changed1);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(contentColor2)), this_$iv.provides(Dp.m5984boximpl(absoluteElevation))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, -1164547968, true, surfaceKt$Surface$5), composer, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    @ExperimentalMaterial3Api
    /* renamed from: Surface-d85dljk  reason: not valid java name */
    public static final void m2099Surfaced85dljk(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i) {
        boolean enabled2;
        Shape shape2;
        long color2;
        long contentColor2;
        float tonalElevation2;
        float shadowElevation2;
        BorderStroke border2;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource mutableInteractionSource;
        Composer composer = $composer;
        int i2 = $changed;
        int i3 = i;
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(-1877401889);
        ComposerKt.sourceInformation(composer, "C(Surface)P(1,8,7,5,10,2:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp!1,6)430@21854L11,431@21901L22,435@22072L39,*438@22209L7,439@22238L1000:Surface.kt#uh7d8r");
        Modifier modifier2 = (i3 & 4) != 0 ? Modifier.Companion : modifier;
        if ((i3 & 8) != 0) {
            enabled2 = true;
        } else {
            enabled2 = enabled;
        }
        if ((i3 & 16) != 0) {
            shape2 = RectangleShapeKt.getRectangleShape();
        } else {
            shape2 = shape;
        }
        if ((i3 & 32) != 0) {
            color2 = MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1818getSurface0d7_KjU();
        } else {
            color2 = color;
        }
        if ((i3 & 64) != 0) {
            contentColor2 = ColorSchemeKt.m1854contentColorForek8zF_U(color2, composer, (i2 >> 15) & 14);
        } else {
            contentColor2 = contentColor;
        }
        if ((i3 & 128) != 0) {
            tonalElevation2 = Dp.m5986constructorimpl((float) 0);
        } else {
            tonalElevation2 = tonalElevation;
        }
        if ((i3 & 256) != 0) {
            shadowElevation2 = Dp.m5986constructorimpl((float) 0);
        } else {
            shadowElevation2 = shadowElevation;
        }
        if ((i3 & 512) != 0) {
            border2 = null;
        } else {
            border2 = border;
        }
        if ((i3 & 1024) != 0) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
                $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource);
            } else {
                mutableInteractionSource = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            interactionSource2 = mutableInteractionSource;
        } else {
            interactionSource2 = interactionSource;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1877401889, i2, $changed1, "androidx.compose.material3.Surface (Surface.kt:424)");
        } else {
            int i4 = $changed1;
        }
        ProvidableCompositionLocal<Dp> this_$iv = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        float absoluteElevation = Dp.m5986constructorimpl(((Dp) consume).m6000unboximpl() + tonalElevation2);
        SurfaceKt$Surface$7 surfaceKt$Surface$7 = r1;
        long j = color2;
        SurfaceKt$Surface$7 surfaceKt$Surface$72 = new SurfaceKt$Surface$7(modifier2, shape2, color2, absoluteElevation, $changed, border2, shadowElevation2, checked, interactionSource2, enabled2, onCheckedChange, content, $changed1);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(contentColor2)), this_$iv.provides(Dp.m5984boximpl(absoluteElevation))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 712720927, true, surfaceKt$Surface$7), composer, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    /* access modifiers changed from: private */
    /* renamed from: surface-8ww4TTg  reason: not valid java name */
    public static final Modifier m2103surface8ww4TTg(Modifier $this$surface_u2d8ww4TTg, Shape shape, long backgroundColor, BorderStroke border, float shadowElevation) {
        Modifier r0 = ShadowKt.m2832shadows4CzXII$default($this$surface_u2d8ww4TTg, shadowElevation, shape, false, 0, 0, 24, (Object) null);
        Modifier modifier = Modifier.Companion;
        if (border != null) {
            modifier = BorderKt.border(modifier, border, shape);
        }
        return ClipKt.clip(BackgroundKt.m448backgroundbw27NRU(r0.then(modifier), backgroundColor, shape), shape);
    }

    /* access modifiers changed from: private */
    /* renamed from: surfaceColorAtElevation-CLU3JFs  reason: not valid java name */
    public static final long m2104surfaceColorAtElevationCLU3JFs(long color, float elevation, Composer $composer, int $changed) {
        long j;
        $composer.startReplaceableGroup(-2079918090);
        ComposerKt.sourceInformation($composer, "C(surfaceColorAtElevation)P(0:c#ui.graphics.Color,1:c#ui.unit.Dp)482@23697L11,483@23742L11:Surface.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2079918090, $changed, -1, "androidx.compose.material3.surfaceColorAtElevation (Surface.kt:481)");
        }
        if (Color.m3165equalsimpl0(color, MaterialTheme.INSTANCE.getColorScheme($composer, 6).m1818getSurface0d7_KjU())) {
            j = ColorSchemeKt.m1859surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme($composer, 6), elevation);
        } else {
            j = color;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return j;
    }

    public static final ProvidableCompositionLocal<Dp> getLocalAbsoluteTonalElevation() {
        return LocalAbsoluteTonalElevation;
    }
}
