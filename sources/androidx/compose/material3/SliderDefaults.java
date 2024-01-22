package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JE\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0014Jy\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u00162\b\b\u0002\u0010\u001d\u001a\u00020\u00162\b\b\u0002\u0010\u001e\u001a\u00020\u00162\b\b\u0002\u0010\u001f\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\""}, d2 = {"Landroidx/compose/material3/SliderDefaults;", "", "()V", "Thumb", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "Landroidx/compose/material3/SliderColors;", "enabled", "", "thumbSize", "Landroidx/compose/ui/unit/DpSize;", "Thumb-9LiSoMs", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "Track", "sliderPositions", "Landroidx/compose/material3/SliderPositions;", "(Landroidx/compose/material3/SliderPositions;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SliderColors;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Slider.kt */
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final SliderDefaults INSTANCE = new SliderDefaults();

    private SliderDefaults() {
    }

    /* renamed from: colors-q0g_0yA  reason: not valid java name */
    public final SliderColors m2055colorsq0g_0yA(long thumbColor, long activeTrackColor, long activeTickColor, long inactiveTrackColor, long inactiveTickColor, long disabledThumbColor, long disabledActiveTrackColor, long disabledActiveTickColor, long disabledInactiveTrackColor, long disabledInactiveTickColor, Composer $composer, int $changed, int $changed1, int i) {
        long activeTrackColor2;
        long activeTickColor2;
        long inactiveTrackColor2;
        long inactiveTickColor2;
        long disabledThumbColor2;
        long disabledActiveTrackColor2;
        long disabledActiveTickColor2;
        long disabledInactiveTrackColor2;
        long disabledInactiveTickColor2;
        Composer composer = $composer;
        int i2 = i;
        composer.startReplaceableGroup(885588574);
        ComposerKt.sourceInformation(composer, "C(colors)P(9:c#ui.graphics.Color,1:c#ui.graphics.Color,0:c#ui.graphics.Color,8:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color)619@27285L9,620@27360L9,622@27460L9,624@27611L9,625@27702L9,628@27869L9,630@27982L11,633@28113L9,636@28294L9,640@28492L9,643@28665L9:Slider.kt#uh7d8r");
        long thumbColor2 = (i2 & 1) != 0 ? ColorSchemeKt.toColor(SliderTokens.INSTANCE.getHandleColor(), composer, 6) : thumbColor;
        if ((i2 & 2) != 0) {
            activeTrackColor2 = ColorSchemeKt.toColor(SliderTokens.INSTANCE.getActiveTrackColor(), composer, 6);
        } else {
            activeTrackColor2 = activeTrackColor;
        }
        if ((i2 & 4) != 0) {
            activeTickColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getTickMarksActiveContainerColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            activeTickColor2 = activeTickColor;
        }
        if ((i2 & 8) != 0) {
            inactiveTrackColor2 = ColorSchemeKt.toColor(SliderTokens.INSTANCE.getInactiveTrackColor(), composer, 6);
        } else {
            inactiveTrackColor2 = inactiveTrackColor;
        }
        if ((i2 & 16) != 0) {
            inactiveTickColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getTickMarksInactiveContainerColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            inactiveTickColor2 = inactiveTickColor;
        }
        if ((i2 & 32) != 0) {
            disabledThumbColor2 = ColorKt.m3209compositeOverOWjLjI(Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getDisabledHandleColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1818getSurface0d7_KjU());
        } else {
            disabledThumbColor2 = disabledThumbColor;
        }
        if ((i2 & 64) != 0) {
            disabledActiveTrackColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getDisabledActiveTrackColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledActiveTrackColor2 = disabledActiveTrackColor;
        }
        if ((i2 & 128) != 0) {
            disabledActiveTickColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getTickMarksDisabledContainerColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledActiveTickColor2 = disabledActiveTickColor;
        }
        if ((i2 & 256) != 0) {
            disabledInactiveTrackColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getDisabledInactiveTrackColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledInactiveTrackColor2 = disabledInactiveTrackColor;
        }
        if ((i2 & 512) != 0) {
            disabledInactiveTickColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getTickMarksDisabledContainerColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledInactiveTickColor2 = disabledInactiveTickColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(885588574, $changed, $changed1, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:618)");
        } else {
            int i3 = $changed;
            int i4 = $changed1;
        }
        SliderColors sliderColors = new SliderColors(thumbColor2, activeTrackColor2, activeTickColor2, inactiveTrackColor2, inactiveTickColor2, disabledThumbColor2, disabledActiveTrackColor2, disabledActiveTickColor2, disabledInactiveTrackColor2, disabledInactiveTickColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return sliderColors;
    }

    @ExperimentalMaterial3Api
    /* renamed from: Thumb-9LiSoMs  reason: not valid java name */
    public final void m2054Thumb9LiSoMs(MutableInteractionSource interactionSource, Modifier modifier, SliderColors colors, boolean enabled, long thumbSize, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        SliderColors sliderColors;
        boolean enabled2;
        long j;
        long thumbSize2;
        boolean enabled3;
        SliderColors colors2;
        Modifier modifier3;
        long thumbSize3;
        boolean enabled4;
        SliderColors colors3;
        Modifier modifier4;
        int $dirty;
        Object value$iv$iv;
        Object value$iv$iv2;
        float f;
        Modifier modifier5;
        SliderColors colors4;
        int i2;
        MutableInteractionSource mutableInteractionSource = interactionSource;
        int i3 = $changed;
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Composer $composer2 = $composer.startRestartGroup(-290277409);
        ComposerKt.sourceInformation($composer2, "C(Thumb)P(2,3!,4:c#ui.unit.DpSize)676@30208L8,680@30324L46,681@30413L658,681@30379L692,699@31270L9,706@31472L143,713@31814L19,701@31289L568:Slider.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty2 |= $composer2.changed((Object) mutableInteractionSource) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if ((i3 & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i3 & 896) == 0) {
            if ((i & 4) == 0) {
                sliderColors = colors;
                if ($composer2.changed((Object) sliderColors)) {
                    i2 = 256;
                    $dirty2 |= i2;
                }
            } else {
                sliderColors = colors;
            }
            i2 = 128;
            $dirty2 |= i2;
        } else {
            sliderColors = colors;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            enabled2 = enabled;
        } else if ((i3 & 7168) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer2.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
            j = thumbSize;
        } else if ((57344 & i3) == 0) {
            j = thumbSize;
            $dirty2 |= $composer2.changed(j) ? 16384 : 8192;
        } else {
            j = thumbSize;
        }
        if ((i & 32) != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((458752 & i3) == 0) {
            $dirty2 |= $composer2.changed((Object) this) ? 131072 : 65536;
        }
        if ((374491 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i3 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier5 = Modifier.Companion;
                } else {
                    modifier5 = modifier2;
                }
                if ((i & 4) != 0) {
                    colors4 = m2055colorsq0g_0yA(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer2, 0, ($dirty2 >> 15) & 14, 1023);
                    $dirty2 &= -897;
                } else {
                    colors4 = sliderColors;
                }
                if (i5 != 0) {
                    enabled2 = true;
                }
                if (i6 != 0) {
                    $dirty = $dirty2;
                    modifier4 = modifier5;
                    colors3 = colors4;
                    thumbSize3 = SliderKt.ThumbSize;
                    enabled4 = enabled2;
                } else {
                    thumbSize3 = thumbSize;
                    $dirty = $dirty2;
                    modifier4 = modifier5;
                    colors3 = colors4;
                    enabled4 = enabled2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                $dirty = $dirty2;
                modifier4 = modifier2;
                thumbSize3 = j;
                colors3 = sliderColors;
                enabled4 = enabled2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-290277409, $dirty, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:673)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = SnapshotStateKt.mutableStateListOf();
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SnapshotStateList interactions = (SnapshotStateList) value$iv$iv;
            $composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed((Object) mutableInteractionSource) | $composer2.changed((Object) interactions);
            Composer $this$cache$iv$iv2 = $composer2;
            Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
            int i7 = ($dirty & 14) | 560;
            if (invalid$iv$iv || it$iv$iv2 == Composer.Companion.getEmpty()) {
                value$iv$iv2 = (Function2) new SliderDefaults$Thumb$1$1(mutableInteractionSource, interactions, (Continuation<? super SliderDefaults$Thumb$1$1>) null);
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect((Object) mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) value$iv$iv2, $composer2, ($dirty & 14) | 64);
            if (!interactions.isEmpty()) {
                f = SliderKt.ThumbPressedElevation;
            } else {
                f = SliderKt.ThumbDefaultElevation;
            }
            float elevation = f;
            Shape shape = ShapesKt.toShape(SliderTokens.INSTANCE.getHandleShape(), $composer2, 6);
            int $dirty3 = $dirty;
            SpacerKt.Spacer(BackgroundKt.m448backgroundbw27NRU(ShadowKt.m2832shadows4CzXII$default(HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m831size6HolHcs(modifier4, thumbSize3), mutableInteractionSource, RippleKt.m1729rememberRipple9IZ8Weo(false, Dp.m5986constructorimpl(SliderTokens.INSTANCE.m2664getStateLayerSizeD9Ej5fM() / ((float) 2)), 0, $composer2, 54, 4)), mutableInteractionSource, false, 2, (Object) null), enabled4 ? elevation : Dp.m5986constructorimpl((float) 0), shape, false, 0, 0, 24, (Object) null), colors3.thumbColor$material3_release(enabled4, $composer2, (($dirty3 >> 9) & 14) | (($dirty3 >> 3) & 112)).getValue().m3174unboximpl(), shape), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            thumbSize2 = thumbSize3;
            enabled3 = enabled4;
            colors2 = colors3;
            modifier3 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
            int i8 = $dirty2;
            enabled3 = enabled2;
            thumbSize2 = j;
            modifier3 = modifier2;
            colors2 = sliderColors;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new SliderDefaults$Thumb$2(this, interactionSource, modifier3, colors2, enabled3, thumbSize2, $changed, i));
    }

    @ExperimentalMaterial3Api
    public final void Track(SliderPositions sliderPositions, Modifier modifier, SliderColors colors, boolean enabled, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        SliderColors sliderColors;
        boolean z;
        Modifier modifier3;
        boolean enabled2;
        SliderColors colors2;
        int $dirty;
        Modifier modifier4;
        Modifier modifier5;
        Modifier modifier6;
        SliderColors colors3;
        int i2;
        SliderPositions sliderPositions2 = sliderPositions;
        int i3 = $changed;
        Intrinsics.checkNotNullParameter(sliderPositions2, "sliderPositions");
        Composer $composer2 = $composer.startRestartGroup(-1546713545);
        ComposerKt.sourceInformation($composer2, "C(Track)P(3,2)734@32707L8,737@32798L35,738@32872L34,739@32946L34,740@33018L33,744@33147L1806,741@33060L1893:Slider.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty2 |= $composer2.changed((Object) sliderPositions2) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if ((i3 & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i3 & 896) == 0) {
            if ((i & 4) == 0) {
                sliderColors = colors;
                if ($composer2.changed((Object) sliderColors)) {
                    i2 = 256;
                    $dirty2 |= i2;
                }
            } else {
                sliderColors = colors;
            }
            i2 = 128;
            $dirty2 |= i2;
        } else {
            sliderColors = colors;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            z = enabled;
        } else if ((i3 & 7168) == 0) {
            z = enabled;
            $dirty2 |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        if ((i & 16) != 0) {
            $dirty2 |= 24576;
        } else if ((57344 & i3) == 0) {
            $dirty2 |= $composer2.changed((Object) this) ? 16384 : 8192;
        }
        if ((46811 & $dirty2) != 9362 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i3 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier6 = Modifier.Companion;
                } else {
                    modifier6 = modifier2;
                }
                if ((i & 4) != 0) {
                    colors3 = m2055colorsq0g_0yA(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer2, 0, ($dirty2 >> 12) & 14, 1023);
                    $dirty2 &= -897;
                } else {
                    colors3 = sliderColors;
                }
                if (i5 != 0) {
                    $dirty = $dirty2;
                    modifier4 = modifier6;
                    colors2 = colors3;
                    enabled2 = true;
                } else {
                    $dirty = $dirty2;
                    colors2 = colors3;
                    enabled2 = z;
                    modifier4 = modifier6;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                $dirty = $dirty2;
                colors2 = sliderColors;
                enabled2 = z;
                modifier4 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1546713545, $dirty, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:731)");
            }
            State inactiveTrackColor = colors2.trackColor$material3_release(enabled2, false, $composer2, (($dirty >> 9) & 14) | 48 | ($dirty & 896));
            State activeTrackColor = colors2.trackColor$material3_release(enabled2, true, $composer2, (($dirty >> 9) & 14) | 48 | ($dirty & 896));
            State activeTickColor = colors2.tickColor$material3_release(enabled2, false, $composer2, (($dirty >> 9) & 14) | 48 | ($dirty & 896));
            State activeTickColor2 = colors2.tickColor$material3_release(enabled2, true, $composer2, (($dirty >> 9) & 14) | 48 | ($dirty & 896));
            Modifier r3 = SizeKt.m816height3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), SliderKt.getTrackHeight());
            Object[] keys$iv = {inactiveTrackColor, sliderPositions2, activeTrackColor, activeTickColor, activeTickColor2};
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : keys$iv) {
                invalid$iv |= $composer2.changed(key$iv);
            }
            Composer $this$cache$iv$iv = $composer2;
            Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv || value$iv$iv == Composer.Companion.getEmpty()) {
                Object obj = value$iv$iv;
                Object[] objArr = keys$iv;
                modifier3 = modifier4;
                modifier5 = r3;
                State state = activeTickColor;
                value$iv$iv = new SliderDefaults$Track$1$1(inactiveTrackColor, sliderPositions, activeTrackColor, activeTickColor, activeTickColor2);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                Object obj2 = value$iv$iv;
                Object[] objArr2 = keys$iv;
                State state2 = activeTickColor2;
                State state3 = activeTickColor;
                modifier3 = modifier4;
                modifier5 = r3;
            }
            $composer2.endReplaceableGroup();
            CanvasKt.Canvas(modifier5, (Function1) value$iv$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            int i6 = $dirty2;
            modifier3 = modifier2;
            colors2 = sliderColors;
            enabled2 = z;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new SliderDefaults$Track$2(this, sliderPositions, modifier3, colors2, enabled2, $changed, i));
    }
}
