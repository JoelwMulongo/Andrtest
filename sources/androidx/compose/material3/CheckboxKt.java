package androidx.compose.material3;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.PathMeasure;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aS\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a-\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010\u001b\u001aM\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001a2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010 \u001a9\u0010!\u001a\u00020\u000b*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aA\u0010+\u001a\u00020\u000b*\u00020\"2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020'2\u0006\u00100\u001a\u000201H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\b\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\t\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxSize", "RadiusSize", "StrokeWidth", "Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/CheckboxColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "Landroidx/compose/ui/state/ToggleableState;", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "TriStateCheckbox", "state", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material3/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material3/CheckDrawingCache;)V", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Checkbox.kt */
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding = Dp.m5986constructorimpl((float) 2);
    private static final float CheckboxSize = Dp.m5986constructorimpl((float) 20);
    /* access modifiers changed from: private */
    public static final float RadiusSize = Dp.m5986constructorimpl((float) 2);
    /* access modifiers changed from: private */
    public static final float StrokeWidth = Dp.m5986constructorimpl((float) 2);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Checkbox.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            iArr[ToggleableState.On.ordinal()] = 1;
            iArr[ToggleableState.Off.ordinal()] = 2;
            iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void Checkbox(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, CheckboxColors colors, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        boolean z;
        CheckboxColors colors2;
        MutableInteractionSource interactionSource2;
        CheckboxColors colors3;
        boolean enabled2;
        Modifier modifier3;
        MutableInteractionSource interactionSource3;
        boolean enabled3;
        Modifier modifier4;
        Function0 function0;
        MutableInteractionSource mutableInteractionSource;
        int i2;
        boolean z2 = checked;
        Function1<? super Boolean, Unit> function1 = onCheckedChange;
        int i3 = $changed;
        Composer $composer2 = $composer.startRestartGroup(-1406741137);
        ComposerKt.sourceInformation($composer2, "C(Checkbox)P(!1,5,4,2)92@4151L8,93@4211L39,98@4380L29,95@4259L304:Checkbox.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer2.changed(z2) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if ((i3 & 112) == 0) {
            $dirty |= $composer2.changed((Object) function1) ? 32 : 16;
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
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            z = enabled;
        } else if ((i3 & 7168) == 0) {
            z = enabled;
            $dirty |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        if ((i3 & 57344) == 0) {
            if ((i & 16) == 0) {
                colors2 = colors;
                if ($composer2.changed((Object) colors2)) {
                    i2 = 16384;
                    $dirty |= i2;
                }
            } else {
                colors2 = colors;
            }
            i2 = 8192;
            $dirty |= i2;
        } else {
            colors2 = colors;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            interactionSource2 = interactionSource;
        } else if ((i3 & 458752) == 0) {
            interactionSource2 = interactionSource;
            $dirty |= $composer2.changed((Object) interactionSource2) ? 131072 : 65536;
        } else {
            interactionSource2 = interactionSource;
        }
        if ((374491 & $dirty) != 74898 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i3 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i5 != 0) {
                    enabled3 = true;
                } else {
                    enabled3 = z;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                    colors2 = CheckboxDefaults.INSTANCE.m1780colors5tl4gsc(0, 0, 0, 0, 0, 0, $composer2, 1572864, 63);
                }
                if (i6 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer2;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource);
                    } else {
                        mutableInteractionSource = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    interactionSource3 = mutableInteractionSource;
                } else {
                    interactionSource3 = interactionSource;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                modifier4 = modifier2;
                enabled3 = z;
                interactionSource3 = interactionSource2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1406741137, $dirty, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:87)");
            }
            ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(checked);
            if (function1 != null) {
                Boolean valueOf = Boolean.valueOf(checked);
                int $changed$iv = (($dirty >> 3) & 14) | (($dirty << 3) & 112);
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer2.changed((Object) function1) | $composer2.changed((Object) valueOf);
                Composer $this$cache$iv$iv2 = $composer2;
                Boolean bool = valueOf;
                Object value$iv$iv = $this$cache$iv$iv2.rememberedValue();
                if (!invalid$iv$iv) {
                    int i7 = $changed$iv;
                    if (value$iv$iv != Composer.Companion.getEmpty()) {
                        Object obj = value$iv$iv;
                        $composer2.endReplaceableGroup();
                        function0 = (Function0) value$iv$iv;
                    }
                }
                Object obj2 = value$iv$iv;
                value$iv$iv = new CheckboxKt$Checkbox$2$1(function1, z2);
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv);
                $composer2.endReplaceableGroup();
                function0 = (Function0) value$iv$iv;
            } else {
                function0 = null;
            }
            TriStateCheckbox(ToggleableState, function0, modifier4, enabled3, colors2, interactionSource3, $composer2, ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | ($dirty & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i8 = $dirty;
            modifier3 = modifier4;
            enabled2 = enabled3;
            interactionSource2 = interactionSource3;
            colors3 = colors2;
        } else {
            $composer2.skipToGroupEnd();
            int i9 = $dirty;
            modifier3 = modifier2;
            enabled2 = z;
            colors3 = colors2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new CheckboxKt$Checkbox$3(checked, onCheckedChange, modifier3, enabled2, colors3, interactionSource2, $changed, i));
    }

    public static final void TriStateCheckbox(ToggleableState state, Function0<Unit> onClick, Modifier modifier, boolean enabled, CheckboxColors colors, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        boolean z;
        CheckboxColors checkboxColors;
        MutableInteractionSource interactionSource2;
        CheckboxColors colors2;
        boolean enabled2;
        Modifier modifier3;
        int $dirty;
        int $dirty2;
        Modifier modifier4;
        Modifier modifier5;
        Modifier modifier6;
        boolean enabled3;
        CheckboxColors colors3;
        Object value$iv$iv;
        int i2;
        ToggleableState toggleableState = state;
        Function0<Unit> function0 = onClick;
        int i3 = $changed;
        Intrinsics.checkNotNullParameter(toggleableState, "state");
        Composer $composer2 = $composer.startRestartGroup(-1608358065);
        ComposerKt.sourceInformation($composer2, "C(TriStateCheckbox)P(5,4,3,1)140@6419L8,141@6479L39,159@7047L403:Checkbox.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty3 |= $composer2.changed((Object) toggleableState) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if ((i3 & 112) == 0) {
            $dirty3 |= $composer2.changed((Object) function0) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if ((i3 & 896) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed((Object) modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty3 |= 3072;
            z = enabled;
        } else if ((i3 & 7168) == 0) {
            z = enabled;
            $dirty3 |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        if ((57344 & i3) == 0) {
            if ((i & 16) == 0) {
                checkboxColors = colors;
                if ($composer2.changed((Object) checkboxColors)) {
                    i2 = 16384;
                    $dirty3 |= i2;
                }
            } else {
                checkboxColors = colors;
            }
            i2 = 8192;
            $dirty3 |= i2;
        } else {
            checkboxColors = colors;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            interactionSource2 = interactionSource;
        } else if ((458752 & i3) == 0) {
            interactionSource2 = interactionSource;
            $dirty3 |= $composer2.changed((Object) interactionSource2) ? 131072 : 65536;
        } else {
            interactionSource2 = interactionSource;
        }
        if ((374491 & $dirty3) != 74898 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i3 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier6 = Modifier.Companion;
                } else {
                    modifier6 = modifier2;
                }
                if (i5 != 0) {
                    enabled3 = true;
                } else {
                    enabled3 = z;
                }
                if ((i & 16) != 0) {
                    colors3 = CheckboxDefaults.INSTANCE.m1780colors5tl4gsc(0, 0, 0, 0, 0, 0, $composer2, 1572864, 63);
                    $dirty3 &= -57345;
                } else {
                    colors3 = checkboxColors;
                }
                if (i6 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer2;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    $dirty = $dirty3;
                    modifier3 = modifier6;
                    enabled2 = enabled3;
                    colors2 = colors3;
                } else {
                    interactionSource2 = interactionSource;
                    $dirty = $dirty3;
                    modifier3 = modifier6;
                    enabled2 = enabled3;
                    colors2 = colors3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                $dirty = $dirty3;
                modifier3 = modifier2;
                enabled2 = z;
                colors2 = checkboxColors;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1608358065, $dirty, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:135)");
            }
            $composer2.startReplaceableGroup(1797978036);
            ComposerKt.sourceInformation($composer2, "151@6847L133");
            if (function0 != null) {
                $dirty2 = $dirty;
                modifier4 = ToggleableKt.m1087triStateToggleableO2vRcR0(Modifier.Companion, state, interactionSource2, RippleKt.m1729rememberRipple9IZ8Weo(false, Dp.m5986constructorimpl(CheckboxTokens.INSTANCE.m2286getStateLayerSizeD9Ej5fM() / ((float) 2)), 0, $composer2, 54, 4), enabled2, Role.m5306boximpl(Role.Companion.m5314getCheckboxo7Vup1c()), onClick);
            } else {
                $dirty2 = $dirty;
                modifier4 = Modifier.Companion;
            }
            $composer2.endReplaceableGroup();
            Modifier toggleableModifier = modifier4;
            if (function0 != null) {
                modifier5 = TouchTargetKt.minimumTouchTargetSize(Modifier.Companion);
            } else {
                modifier5 = Modifier.Companion;
            }
            CheckboxImpl(enabled2, state, PaddingKt.m760padding3ABfNKs(modifier3.then(modifier5).then(toggleableModifier), CheckboxDefaultPadding), colors2, $composer2, (($dirty2 >> 9) & 14) | (($dirty2 << 3) & 112) | (($dirty2 >> 3) & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i7 = $dirty2;
        } else {
            $composer2.skipToGroupEnd();
            int i8 = $dirty3;
            modifier3 = modifier2;
            enabled2 = z;
            colors2 = checkboxColors;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new CheckboxKt$TriStateCheckbox$2(state, onClick, modifier3, enabled2, colors2, interactionSource2, $changed, i));
    }

    /* access modifiers changed from: private */
    public static final void CheckboxImpl(boolean enabled, ToggleableState value, Modifier modifier, CheckboxColors colors, Composer $composer, int $changed) {
        String str;
        float f;
        float f2;
        float f3;
        Object value$iv$iv;
        boolean z = enabled;
        ToggleableState toggleableState = value;
        Modifier modifier2 = modifier;
        CheckboxColors checkboxColors = colors;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(2007131616);
        ComposerKt.sourceInformation($composer2, "C(CheckboxImpl)P(1,3,2)233@10125L23,234@10188L443,250@10690L458,265@11170L32,266@11231L21,267@11279L24,268@11333L27,273@11483L538,269@11365L656:Checkbox.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed(z) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changed((Object) toggleableState) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changed((Object) modifier2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer2.changed((Object) checkboxColors) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2007131616, $dirty2, -1, "androidx.compose.material3.CheckboxImpl (Checkbox.kt:227)");
            }
            Transition transition = TransitionKt.updateTransition(toggleableState, (String) null, $composer2, ($dirty2 >> 3) & 14, 2);
            Function3 transitionSpec$iv = CheckboxKt$CheckboxImpl$checkDrawFraction$1.INSTANCE;
            $composer2.startReplaceableGroup(1399891485);
            ComposerKt.sourceInformation($composer2, "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            Transition $this$animateValue$iv$iv = transition;
            int $changed$iv$iv = ((0 << 3) & 57344) | (0 & 14) | ((0 << 3) & 896) | ((0 << 3) & 7168);
            $composer2.startReplaceableGroup(1847725064);
            ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
            int $changed2 = ($changed$iv$iv >> 9) & 112;
            ToggleableState it = (ToggleableState) $this$animateValue$iv$iv.getCurrentState();
            Composer $composer3 = $composer2;
            $composer3.startReplaceableGroup(1800065638);
            ComposerKt.sourceInformation($composer3, "C:Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                str = "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli";
                ComposerKt.traceEventStart(1800065638, $changed2, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:242)");
            } else {
                str = "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli";
            }
            float f4 = 0.0f;
            switch (WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
                case 1:
                    f = 1.0f;
                    break;
                case 2:
                    f = 0.0f;
                    break;
                case 3:
                    f = 1.0f;
                    break;
                default:
                    Transition transition2 = transition;
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer3.endReplaceableGroup();
            Float valueOf = Float.valueOf(f);
            int $changed3 = ($changed$iv$iv >> 9) & 112;
            ToggleableState it2 = (ToggleableState) $this$animateValue$iv$iv.getTargetState();
            Composer $composer4 = $composer2;
            $composer4.startReplaceableGroup(1800065638);
            ComposerKt.sourceInformation($composer4, "C:Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1800065638, $changed3, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:242)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it2.ordinal()]) {
                case 1:
                    f2 = 1.0f;
                    break;
                case 2:
                    f2 = 0.0f;
                    break;
                case 3:
                    f2 = 1.0f;
                    break;
                default:
                    Transition transition3 = transition;
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer4.endReplaceableGroup();
            Float valueOf2 = Float.valueOf(f2);
            Float f5 = valueOf;
            Float f6 = valueOf2;
            Function3 function3 = transitionSpec$iv;
            State checkDrawFraction = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv, valueOf, valueOf2, (FiniteAnimationSpec) transitionSpec$iv.invoke($this$animateValue$iv$iv.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112)), vectorConverter, "FloatAnimation", $composer2, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            Function3 transitionSpec$iv2 = CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1.INSTANCE;
            $composer2.startReplaceableGroup(1399891485);
            ComposerKt.sourceInformation($composer2, str);
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            Transition $this$animateValue$iv$iv2 = transition;
            int $changed$iv$iv2 = ((0 << 3) & 57344) | (0 & 14) | ((0 << 3) & 896) | ((0 << 3) & 7168);
            $composer2.startReplaceableGroup(1847725064);
            ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
            int $changed4 = ($changed$iv$iv2 >> 9) & 112;
            ToggleableState it3 = (ToggleableState) $this$animateValue$iv$iv2.getCurrentState();
            Composer $composer5 = $composer2;
            $composer5.startReplaceableGroup(-1426969489);
            ComposerKt.sourceInformation($composer5, "C:Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                Transition transition4 = transition;
                ComposerKt.traceEventStart(-1426969489, $changed4, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:258)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it3.ordinal()]) {
                case 1:
                    f3 = 0.0f;
                    break;
                case 2:
                    f3 = 0.0f;
                    break;
                case 3:
                    f3 = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer5.endReplaceableGroup();
            Float valueOf3 = Float.valueOf(f3);
            int $changed5 = ($changed$iv$iv2 >> 9) & 112;
            ToggleableState it4 = (ToggleableState) $this$animateValue$iv$iv2.getTargetState();
            Composer $composer6 = $composer2;
            $composer6.startReplaceableGroup(-1426969489);
            ComposerKt.sourceInformation($composer6, "C:Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1426969489, $changed5, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:258)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it4.ordinal()]) {
                case 1:
                case 2:
                    break;
                case 3:
                    f4 = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer6.endReplaceableGroup();
            State checkCenterGravitationShiftFraction = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv2, valueOf3, Float.valueOf(f4), (FiniteAnimationSpec) transitionSpec$iv2.invoke($this$animateValue$iv$iv2.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv2 >> 3) & 112)), vectorConverter2, "FloatAnimation", $composer2, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = new CheckDrawingCache((Path) null, (PathMeasure) null, (Path) null, 7, (DefaultConstructorMarker) null);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            CheckDrawingCache checkCache = (CheckDrawingCache) value$iv$iv;
            State checkColor = checkboxColors.checkmarkColor$material3_release(toggleableState, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 6) & 112));
            boolean z2 = enabled;
            State boxColor = checkboxColors.boxColor$material3_release(z2, toggleableState, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896));
            State borderColor = checkboxColors.borderColor$material3_release(z2, toggleableState, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896));
            Modifier r10 = SizeKt.m822requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.Companion.getCenter(), false, 2, (Object) null), CheckboxSize);
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : new Object[]{boxColor, borderColor, checkColor, checkDrawFraction, checkCenterGravitationShiftFraction, checkCache}) {
                invalid$iv |= $composer2.changed(key$iv);
            }
            Composer $this$cache$iv$iv2 = $composer2;
            Object value$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
            if (invalid$iv || value$iv$iv2 == Composer.Companion.getEmpty()) {
                Object obj = value$iv$iv2;
                value$iv$iv2 = new CheckboxKt$CheckboxImpl$1$1(boxColor, borderColor, checkColor, checkDrawFraction, checkCenterGravitationShiftFraction, checkCache);
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
            } else {
                Object obj2 = value$iv$iv2;
                Composer composer = $this$cache$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            CanvasKt.Canvas(r10, (Function1) value$iv$iv2, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            Modifier modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i2 = $dirty2;
            Composer composer2 = $composer2;
            return;
        }
        int i3 = $dirty2;
        Composer composer3 = $composer2;
        endRestartGroup.updateScope(new CheckboxKt$CheckboxImpl$2(enabled, value, modifier, colors, $changed));
    }

    /* access modifiers changed from: private */
    /* renamed from: drawBox-1wkBAMs  reason: not valid java name */
    public static final void m1783drawBox1wkBAMs(DrawScope $this$drawBox_u2d1wkBAMs, long boxColor, long borderColor, float radius, float strokeWidth) {
        float f = radius;
        float f2 = strokeWidth;
        float halfStrokeWidth = f2 / 2.0f;
        Stroke stroke = new Stroke(strokeWidth, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null);
        float checkboxSize = Size.m2984getWidthimpl($this$drawBox_u2d1wkBAMs.m3772getSizeNHjbRc());
        if (Color.m3165equalsimpl0(boxColor, borderColor)) {
            DrawScope.m3750drawRoundRectuAw5IA$default($this$drawBox_u2d1wkBAMs, boxColor, 0, androidx.compose.ui.geometry.SizeKt.Size(checkboxSize, checkboxSize), CornerRadiusKt.CornerRadius$default(f, 0.0f, 2, (Object) null), Fill.INSTANCE, 0.0f, (ColorFilter) null, 0, 226, (Object) null);
            return;
        }
        float f3 = (float) 2;
        DrawScope.m3750drawRoundRectuAw5IA$default($this$drawBox_u2d1wkBAMs, boxColor, OffsetKt.Offset(f2, f2), androidx.compose.ui.geometry.SizeKt.Size(checkboxSize - (f2 * f3), checkboxSize - (f3 * f2)), CornerRadiusKt.CornerRadius$default(Math.max(0.0f, f - f2), 0.0f, 2, (Object) null), Fill.INSTANCE, 0.0f, (ColorFilter) null, 0, 224, (Object) null);
        DrawScope.m3750drawRoundRectuAw5IA$default($this$drawBox_u2d1wkBAMs, borderColor, OffsetKt.Offset(halfStrokeWidth, halfStrokeWidth), androidx.compose.ui.geometry.SizeKt.Size(checkboxSize - f2, checkboxSize - f2), CornerRadiusKt.CornerRadius$default(f - halfStrokeWidth, 0.0f, 2, (Object) null), stroke, 0.0f, (ColorFilter) null, 0, 224, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawCheck-3IgeMak  reason: not valid java name */
    public static final void m1784drawCheck3IgeMak(DrawScope $this$drawCheck_u2d3IgeMak, long checkColor, float checkFraction, float crossCenterGravitation, float strokeWidthPx, CheckDrawingCache drawingCache) {
        float f = crossCenterGravitation;
        Stroke stroke = new Stroke(strokeWidthPx, 0.0f, StrokeCap.Companion.m3549getSquareKaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
        float width = Size.m2984getWidthimpl($this$drawCheck_u2d3IgeMak.m3772getSizeNHjbRc());
        float gravitatedCrossX = MathHelpersKt.lerp(0.4f, 0.5f, f);
        float gravitatedCrossY = MathHelpersKt.lerp(0.7f, 0.5f, f);
        float gravitatedLeftY = MathHelpersKt.lerp(0.5f, 0.5f, f);
        float gravitatedRightY = MathHelpersKt.lerp(0.3f, 0.5f, f);
        CheckDrawingCache $this$drawCheck_3IgeMak_u24lambda_u2d7 = drawingCache;
        $this$drawCheck_3IgeMak_u24lambda_u2d7.getCheckPath().reset();
        $this$drawCheck_3IgeMak_u24lambda_u2d7.getCheckPath().moveTo(width * 0.2f, width * gravitatedLeftY);
        $this$drawCheck_3IgeMak_u24lambda_u2d7.getCheckPath().lineTo(width * gravitatedCrossX, width * gravitatedCrossY);
        $this$drawCheck_3IgeMak_u24lambda_u2d7.getCheckPath().lineTo(width * 0.8f, width * gravitatedRightY);
        $this$drawCheck_3IgeMak_u24lambda_u2d7.getPathMeasure().setPath($this$drawCheck_3IgeMak_u24lambda_u2d7.getCheckPath(), false);
        $this$drawCheck_3IgeMak_u24lambda_u2d7.getPathToDraw().reset();
        float f2 = width;
        $this$drawCheck_3IgeMak_u24lambda_u2d7.getPathMeasure().getSegment(0.0f, $this$drawCheck_3IgeMak_u24lambda_u2d7.getPathMeasure().getLength() * checkFraction, $this$drawCheck_3IgeMak_u24lambda_u2d7.getPathToDraw(), true);
        DrawScope.m3744drawPathLG529CI$default($this$drawCheck_u2d3IgeMak, drawingCache.getPathToDraw(), checkColor, 0.0f, stroke, (ColorFilter) null, 0, 52, (Object) null);
    }
}
