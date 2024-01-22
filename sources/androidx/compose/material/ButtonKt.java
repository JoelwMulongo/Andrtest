package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0001\u0010\u001b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001c"}, d2 = {"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "elevation", "Landroidx/compose/material/ButtonElevation;", "shape", "Landroidx/compose/ui/graphics/Shape;", "border", "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ButtonColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/ButtonElevation;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ButtonColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedButton", "TextButton", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Button.kt */
public final class ButtonKt {
    public static final void Button(Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, ButtonElevation elevation, Shape shape, BorderStroke border, ButtonColors colors, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        boolean z;
        MutableInteractionSource mutableInteractionSource;
        ButtonElevation elevation2;
        BorderStroke borderStroke;
        int i2;
        PaddingValues paddingValues;
        MutableInteractionSource interactionSource2;
        boolean enabled2;
        Modifier modifier2;
        Composer $composer2;
        ButtonElevation elevation3;
        PaddingValues contentPadding2;
        ButtonColors colors2;
        BorderStroke border2;
        Shape shape2;
        Modifier modifier3;
        boolean enabled3;
        ButtonElevation elevation4;
        PaddingValues contentPadding3;
        ButtonColors colors3;
        int $dirty;
        float f;
        Modifier modifier4;
        boolean enabled4;
        int i3;
        Shape shape3;
        BorderStroke border3;
        ButtonColors colors4;
        Object value$iv$iv;
        int i4;
        int i5;
        int i6;
        Function0<Unit> function0 = onClick;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
        int i7 = $changed;
        int i8 = i;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer3 = $composer.startRestartGroup(-2116133464);
        ComposerKt.sourceInformation($composer3, "C(Button)P(8,7,5,6,4,9!2,3)97@4664L39,98@4754L11,99@4800L6,101@4890L14,105@5053L21,111@5250L24,106@5079L1119:Button.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i8 & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i7 & 14) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        int i9 = i8 & 2;
        if (i9 != 0) {
            $dirty2 |= 48;
            Modifier modifier5 = modifier;
        } else if ((i7 & 112) == 0) {
            $dirty2 |= $composer3.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier6 = modifier;
        }
        int i10 = i8 & 4;
        if (i10 != 0) {
            $dirty2 |= 384;
            z = enabled;
        } else if ((i7 & 896) == 0) {
            z = enabled;
            $dirty2 |= $composer3.changed(z) ? 256 : 128;
        } else {
            z = enabled;
        }
        int i11 = i8 & 8;
        if (i11 != 0) {
            $dirty2 |= 3072;
            mutableInteractionSource = interactionSource;
        } else if ((i7 & 7168) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty2 |= $composer3.changed((Object) mutableInteractionSource) ? 2048 : 1024;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((57344 & i7) == 0) {
            if ((i8 & 16) == 0) {
                elevation2 = elevation;
                if ($composer3.changed((Object) elevation2)) {
                    i6 = 16384;
                    $dirty2 |= i6;
                }
            } else {
                elevation2 = elevation;
            }
            i6 = 8192;
            $dirty2 |= i6;
        } else {
            elevation2 = elevation;
        }
        if ((458752 & i7) == 0) {
            if ((i8 & 32) != 0) {
                Shape shape4 = shape;
            } else if ($composer3.changed((Object) shape)) {
                i5 = 131072;
                $dirty2 |= i5;
            }
            i5 = 65536;
            $dirty2 |= i5;
        } else {
            Shape shape5 = shape;
        }
        int i12 = i8 & 64;
        if (i12 != 0) {
            $dirty2 |= 1572864;
            borderStroke = border;
        } else if ((i7 & 3670016) == 0) {
            borderStroke = border;
            $dirty2 |= $composer3.changed((Object) borderStroke) ? 1048576 : 524288;
        } else {
            borderStroke = border;
        }
        if ((i7 & 29360128) == 0) {
            if ((i8 & 128) != 0) {
                ButtonColors buttonColors = colors;
            } else if ($composer3.changed((Object) colors)) {
                i4 = 8388608;
                $dirty2 |= i4;
            }
            i4 = 4194304;
            $dirty2 |= i4;
        } else {
            ButtonColors buttonColors2 = colors;
        }
        int i13 = i8 & 256;
        if (i13 != 0) {
            $dirty2 |= 100663296;
            i2 = i13;
            paddingValues = contentPadding;
        } else if ((i7 & 234881024) == 0) {
            i2 = i13;
            paddingValues = contentPadding;
            $dirty2 |= $composer3.changed((Object) paddingValues) ? 67108864 : 33554432;
        } else {
            i2 = i13;
            paddingValues = contentPadding;
        }
        if ((i8 & 512) != 0) {
            $dirty2 |= 805306368;
        } else if ((1879048192 & i7) == 0) {
            $dirty2 |= $composer3.changedInstance(function3) ? 536870912 : 268435456;
        }
        int $dirty3 = $dirty2;
        if ((1533916891 & $dirty3) != 306783378 || !$composer3.getSkipping()) {
            $composer3.startDefaults();
            if ((i7 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i9 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier;
                }
                if (i10 != 0) {
                    enabled4 = true;
                } else {
                    enabled4 = z;
                }
                if (i11 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    interactionSource2 = mutableInteractionSource;
                }
                if ((i8 & 16) != 0) {
                    i3 = i2;
                    $dirty3 &= -57345;
                    elevation2 = ButtonDefaults.INSTANCE.m1411elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                } else {
                    i3 = i2;
                }
                if ((i8 & 32) != 0) {
                    shape3 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall();
                    $dirty3 &= -458753;
                } else {
                    shape3 = shape;
                }
                if (i12 != 0) {
                    border3 = null;
                } else {
                    border3 = border;
                }
                if ((i8 & 128) != 0) {
                    colors4 = ButtonDefaults.INSTANCE.m1410buttonColorsro_MJ88(0, 0, 0, 0, $composer3, 24576, 15);
                    $dirty3 &= -29360129;
                } else {
                    colors4 = colors;
                }
                if (i3 != 0) {
                    shape2 = shape3;
                    border2 = border3;
                    colors3 = colors4;
                    contentPadding3 = ButtonDefaults.INSTANCE.getContentPadding();
                    elevation4 = elevation2;
                    modifier3 = modifier4;
                    enabled3 = enabled4;
                    $dirty = $dirty3;
                } else {
                    contentPadding3 = contentPadding;
                    $dirty = $dirty3;
                    shape2 = shape3;
                    border2 = border3;
                    colors3 = colors4;
                    elevation4 = elevation2;
                    modifier3 = modifier4;
                    enabled3 = enabled4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i8 & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i8 & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i8 & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                shape2 = shape;
                colors3 = colors;
                $dirty = $dirty3;
                interactionSource2 = mutableInteractionSource;
                border2 = borderStroke;
                contentPadding3 = paddingValues;
                elevation4 = elevation2;
                modifier3 = modifier;
                enabled3 = z;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2116133464, $dirty, -1, "androidx.compose.material.Button (Button.kt:93)");
            }
            State<Color> contentColor = colors3.contentColor(enabled3, $composer3, (($dirty >> 6) & 14) | (($dirty >> 18) & 112));
            State<Dp> state = null;
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier3, false, ButtonKt$Button$2.INSTANCE, 1, (Object) null);
            long r18 = colors3.backgroundColor(enabled3, $composer3, (($dirty >> 6) & 14) | (($dirty >> 18) & 112)).getValue().m3174unboximpl();
            long r20 = Color.m3163copywmQWz5c$default(Button$lambda$1(contentColor), 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            $composer3.startReplaceableGroup(-423487112);
            ComposerKt.sourceInformation($composer3, "114@5392L37");
            if (elevation4 != null) {
                state = elevation4.elevation(enabled3, interactionSource2, $composer3, (($dirty >> 6) & 896) | (($dirty >> 6) & 14) | (($dirty >> 6) & 112));
            }
            $composer3.endReplaceableGroup();
            if (state != null) {
                f = state.getValue().m6000unboximpl();
            } else {
                f = Dp.m5986constructorimpl((float) 0);
            }
            int i14 = ($dirty & 14) | 805306368 | ($dirty & 896) | (($dirty >> 6) & 7168) | ($dirty & 3670016) | (($dirty << 15) & 234881024);
            int i15 = $dirty;
            State<Color> state2 = contentColor;
            long j = r18;
            colors2 = colors3;
            contentPadding2 = contentPadding3;
            long j2 = r20;
            elevation3 = elevation4;
            enabled2 = enabled3;
            modifier2 = modifier3;
            $composer2 = $composer3;
            SurfaceKt.m1621SurfaceLPr_se0(onClick, semantics$default, enabled3, shape2, j, j2, border2, f, interactionSource2, ComposableLambdaKt.composableLambda($composer3, 7524271, true, new ButtonKt$Button$3(contentColor, contentPadding3, function3, $dirty)), $composer2, i14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            shape2 = shape;
            colors2 = colors;
            int i16 = $dirty3;
            enabled2 = z;
            interactionSource2 = mutableInteractionSource;
            border2 = borderStroke;
            contentPadding2 = paddingValues;
            elevation3 = elevation2;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ButtonKt$Button$4(onClick, modifier2, enabled2, interactionSource2, elevation3, shape2, border2, colors2, contentPadding2, content, $changed, i));
        }
    }

    /* access modifiers changed from: private */
    public static final long Button$lambda$1(State<Color> $contentColor$delegate) {
        return ((Color) $contentColor$delegate.getValue()).m3174unboximpl();
    }

    public static final void OutlinedButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, ButtonElevation elevation, Shape shape, BorderStroke border, ButtonColors colors, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        boolean enabled2;
        MutableInteractionSource interactionSource2;
        ButtonElevation elevation2;
        Shape shape2;
        BorderStroke border2;
        ButtonColors colors2;
        PaddingValues contentPadding2;
        MutableInteractionSource mutableInteractionSource;
        Composer composer = $composer;
        int i2 = $changed;
        int i3 = i;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(-1776134358);
        ComposerKt.sourceInformation(composer, "C(OutlinedButton)P(8,7,5,6,4,9!2,3)171@8120L39,173@8234L6,174@8291L14,175@8349L22,178@8489L270:Button.kt#jmzs0o");
        Modifier modifier2 = (i3 & 2) != 0 ? Modifier.Companion : modifier;
        if ((i3 & 4) != 0) {
            enabled2 = true;
        } else {
            enabled2 = enabled;
        }
        if ((i3 & 8) != 0) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
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
        if ((i3 & 16) != 0) {
            elevation2 = null;
        } else {
            elevation2 = elevation;
        }
        if ((i3 & 32) != 0) {
            shape2 = MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall();
        } else {
            shape2 = shape;
        }
        if ((i3 & 64) != 0) {
            border2 = ButtonDefaults.INSTANCE.getOutlinedBorder(composer, 6);
        } else {
            border2 = border;
        }
        if ((i3 & 128) != 0) {
            colors2 = ButtonDefaults.INSTANCE.m1418outlinedButtonColorsRGew2ao(0, 0, 0, $composer, 3072, 7);
        } else {
            colors2 = colors;
        }
        if ((i3 & 256) != 0) {
            contentPadding2 = ButtonDefaults.INSTANCE.getContentPadding();
        } else {
            contentPadding2 = contentPadding;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1776134358, i2, -1, "androidx.compose.material.OutlinedButton (Button.kt:167)");
        }
        Button(onClick, modifier2, enabled2, interactionSource2, elevation2, shape2, border2, colors2, contentPadding2, content, $composer, (i2 & 14) | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2) | (29360128 & i2) | (234881024 & i2) | (1879048192 & i2), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    public static final void TextButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, ButtonElevation elevation, Shape shape, BorderStroke border, ButtonColors colors, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        boolean enabled2;
        MutableInteractionSource interactionSource2;
        ButtonElevation elevation2;
        Shape shape2;
        BorderStroke border2;
        ButtonColors colors2;
        PaddingValues contentPadding2;
        MutableInteractionSource mutableInteractionSource;
        Composer composer = $composer;
        int i2 = $changed;
        int i3 = i;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(288797557);
        ComposerKt.sourceInformation(composer, "C(TextButton)P(8,7,5,6,4,9!2,3)225@10691L39,227@10805L6,229@10895L18,232@11041L270:Button.kt#jmzs0o");
        Modifier modifier2 = (i3 & 2) != 0 ? Modifier.Companion : modifier;
        if ((i3 & 4) != 0) {
            enabled2 = true;
        } else {
            enabled2 = enabled;
        }
        if ((i3 & 8) != 0) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
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
        if ((i3 & 16) != 0) {
            elevation2 = null;
        } else {
            elevation2 = elevation;
        }
        if ((i3 & 32) != 0) {
            shape2 = MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall();
        } else {
            shape2 = shape;
        }
        if ((i3 & 64) != 0) {
            border2 = null;
        } else {
            border2 = border;
        }
        if ((i3 & 128) != 0) {
            colors2 = ButtonDefaults.INSTANCE.m1419textButtonColorsRGew2ao(0, 0, 0, $composer, 3072, 7);
        } else {
            colors2 = colors;
        }
        if ((i3 & 256) != 0) {
            contentPadding2 = ButtonDefaults.INSTANCE.getTextButtonContentPadding();
        } else {
            contentPadding2 = contentPadding;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(288797557, i2, -1, "androidx.compose.material.TextButton (Button.kt:221)");
        }
        Button(onClick, modifier2, enabled2, interactionSource2, elevation2, shape2, border2, colors2, contentPadding2, content, $composer, (i2 & 14) | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2) | (29360128 & i2) | (234881024 & i2) | (1879048192 & i2), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }
}
