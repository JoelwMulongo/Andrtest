package androidx.compose.material;

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

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aS\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a-\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u001c\u001aM\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001b2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010 2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010!\u001a9\u0010\"\u001a\u00020\f*\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001aA\u0010,\u001a\u00020\f*\u00020#2\u0006\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020(2\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\b\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\t\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\n\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxRippleRadius", "CheckboxSize", "RadiusSize", "StrokeWidth", "Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/CheckboxColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "Landroidx/compose/ui/state/ToggleableState;", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "TriStateCheckbox", "state", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material/CheckDrawingCache;)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Checkbox.kt */
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding = Dp.m5986constructorimpl((float) 2);
    private static final float CheckboxRippleRadius = Dp.m5986constructorimpl((float) 24);
    private static final float CheckboxSize = Dp.m5986constructorimpl((float) 20);
    /* access modifiers changed from: private */
    public static final float RadiusSize = Dp.m5986constructorimpl((float) 2);
    /* access modifiers changed from: private */
    public static final float StrokeWidth = Dp.m5986constructorimpl((float) 2);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Checkbox.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void Checkbox(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, CheckboxColors colors, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        boolean z;
        MutableInteractionSource mutableInteractionSource;
        CheckboxColors colors2;
        MutableInteractionSource interactionSource2;
        boolean enabled2;
        Modifier modifier3;
        CheckboxColors colors3;
        boolean enabled3;
        Modifier modifier4;
        MutableInteractionSource interactionSource3;
        Function0 function0;
        Object value$iv$iv;
        int i2;
        boolean z2 = checked;
        Function1<? super Boolean, Unit> function1 = onCheckedChange;
        int i3 = $changed;
        Composer $composer2 = $composer.startRestartGroup(-2118660998);
        ComposerKt.sourceInformation($composer2, "C(Checkbox)P(!1,5,4,2,3)90@4153L39,91@4240L8,93@4257L284:Checkbox.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer2.changed(z2) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if ((i3 & 112) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
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
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            mutableInteractionSource = interactionSource;
        } else if ((i3 & 57344) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty |= $composer2.changed((Object) mutableInteractionSource) ? 16384 : 8192;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((i3 & 458752) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                if ($composer2.changed((Object) colors2)) {
                    i2 = 131072;
                    $dirty |= i2;
                }
            } else {
                colors2 = colors;
            }
            i2 = 65536;
            $dirty |= i2;
        } else {
            colors2 = colors;
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
                if (i6 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer2;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    interactionSource3 = (MutableInteractionSource) value$iv$iv;
                } else {
                    interactionSource3 = mutableInteractionSource;
                }
                if ((i & 32) != 0) {
                    colors3 = CheckboxDefaults.INSTANCE.m1423colorszjMxDiM(0, 0, 0, 0, 0, $composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    $dirty &= -458753;
                } else {
                    colors3 = colors;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                modifier4 = modifier2;
                enabled3 = z;
                interactionSource3 = mutableInteractionSource;
                colors3 = colors2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2118660998, $dirty, -1, "androidx.compose.material.Checkbox (Checkbox.kt:85)");
            }
            ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(checked);
            $composer2.startReplaceableGroup(1433125990);
            ComposerKt.sourceInformation($composer2, "95@4366L29");
            if (function1 != null) {
                Boolean valueOf = Boolean.valueOf(checked);
                int $changed$iv = (($dirty >> 3) & 14) | (($dirty << 3) & 112);
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer2.changed((Object) function1) | $composer2.changed((Object) valueOf);
                Composer $this$cache$iv$iv2 = $composer2;
                Boolean bool = valueOf;
                Object value$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
                if (!invalid$iv$iv) {
                    int i7 = $changed$iv;
                    if (value$iv$iv2 != Composer.Companion.getEmpty()) {
                        Object obj = value$iv$iv2;
                        $composer2.endReplaceableGroup();
                        function0 = (Function0) value$iv$iv2;
                    }
                }
                Object obj2 = value$iv$iv2;
                value$iv$iv2 = new CheckboxKt$Checkbox$2$1(function1, z2);
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
                $composer2.endReplaceableGroup();
                function0 = (Function0) value$iv$iv2;
            } else {
                function0 = null;
            }
            $composer2.endReplaceableGroup();
            TriStateCheckbox(ToggleableState, function0, modifier4, enabled3, interactionSource3, colors3, $composer2, ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | ($dirty & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interactionSource2 = interactionSource3;
            int i8 = $dirty;
            modifier3 = modifier4;
            enabled2 = enabled3;
            colors2 = colors3;
        } else {
            $composer2.skipToGroupEnd();
            int i9 = $dirty;
            enabled2 = z;
            interactionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new CheckboxKt$Checkbox$3(checked, onCheckedChange, modifier3, enabled2, interactionSource2, colors2, $changed, i));
    }

    public static final void TriStateCheckbox(ToggleableState state, Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, CheckboxColors colors, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        boolean z;
        MutableInteractionSource interactionSource2;
        CheckboxColors colors2;
        MutableInteractionSource interactionSource3;
        boolean enabled2;
        Modifier modifier3;
        int $dirty;
        int $dirty2;
        Modifier modifier4;
        Modifier modifier5;
        Modifier modifier6;
        boolean enabled3;
        Object value$iv$iv;
        int i2;
        ToggleableState toggleableState = state;
        Function0<Unit> function0 = onClick;
        int i3 = $changed;
        Intrinsics.checkNotNullParameter(toggleableState, "state");
        Composer $composer2 = $composer.startRestartGroup(2031255194);
        ComposerKt.sourceInformation($composer2, "C(TriStateCheckbox)P(5,4,3,1,2)136@6460L39,137@6547L8,155@7071L412:Checkbox.kt#jmzs0o");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty3 |= $composer2.changed((Object) toggleableState) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if ((i3 & 112) == 0) {
            $dirty3 |= $composer2.changedInstance(function0) ? 32 : 16;
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
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty3 |= 24576;
            interactionSource2 = interactionSource;
        } else if ((57344 & i3) == 0) {
            interactionSource2 = interactionSource;
            $dirty3 |= $composer2.changed((Object) interactionSource2) ? 16384 : 8192;
        } else {
            interactionSource2 = interactionSource;
        }
        if ((458752 & i3) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                if ($composer2.changed((Object) colors2)) {
                    i2 = 131072;
                    $dirty3 |= i2;
                }
            } else {
                colors2 = colors;
            }
            i2 = 65536;
            $dirty3 |= i2;
        } else {
            colors2 = colors;
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
                if (i6 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
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
                }
                if ((i & 32) != 0) {
                    colors2 = CheckboxDefaults.INSTANCE.m1423colorszjMxDiM(0, 0, 0, 0, 0, $composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    $dirty = $dirty3 & -458753;
                    modifier3 = modifier6;
                    enabled2 = enabled3;
                    interactionSource3 = interactionSource2;
                } else {
                    colors2 = colors;
                    $dirty = $dirty3;
                    modifier3 = modifier6;
                    enabled2 = enabled3;
                    interactionSource3 = interactionSource2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty = $dirty3 & -458753;
                    modifier3 = modifier2;
                    enabled2 = z;
                    interactionSource3 = interactionSource2;
                } else {
                    $dirty = $dirty3;
                    modifier3 = modifier2;
                    enabled2 = z;
                    interactionSource3 = interactionSource2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2031255194, $dirty, -1, "androidx.compose.material.TriStateCheckbox (Checkbox.kt:131)");
            }
            $composer2.startReplaceableGroup(-1517549514);
            ComposerKt.sourceInformation($composer2, "147@6884L120");
            if (function0 != null) {
                $dirty2 = $dirty;
                modifier4 = ToggleableKt.m1087triStateToggleableO2vRcR0(Modifier.Companion, state, interactionSource3, RippleKt.m1729rememberRipple9IZ8Weo(false, CheckboxRippleRadius, 0, $composer2, 54, 4), enabled2, Role.m5306boximpl(Role.Companion.m5314getCheckboxo7Vup1c()), onClick);
            } else {
                $dirty2 = $dirty;
                modifier4 = Modifier.Companion;
            }
            $composer2.endReplaceableGroup();
            Modifier toggleableModifier = modifier4;
            if (function0 != null) {
                modifier5 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
            } else {
                modifier5 = Modifier.Companion;
            }
            CheckboxImpl(enabled2, state, PaddingKt.m760padding3ABfNKs(modifier3.then(modifier5).then(toggleableModifier), CheckboxDefaultPadding), colors2, $composer2, (($dirty2 >> 9) & 14) | (($dirty2 << 3) & 112) | (($dirty2 >> 6) & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i7 = $dirty2;
        } else {
            $composer2.skipToGroupEnd();
            int i8 = $dirty3;
            modifier3 = modifier2;
            enabled2 = z;
            interactionSource3 = interactionSource2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new CheckboxKt$TriStateCheckbox$2(state, onClick, modifier3, enabled2, interactionSource3, colors2, $changed, i));
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
        Composer $composer2 = $composer.startRestartGroup(-2118895727);
        ComposerKt.sourceInformation($composer2, "C(CheckboxImpl)P(1,3,2)264@11068L23,265@11132L443,281@11635L458,296@12115L32,297@12177L21,298@12226L24,299@12281L27,300@12391L508,300@12313L586:Checkbox.kt#jmzs0o");
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
                ComposerKt.traceEventStart(-2118895727, $dirty2, -1, "androidx.compose.material.CheckboxImpl (Checkbox.kt:258)");
            }
            Transition transition = TransitionKt.updateTransition(toggleableState, (String) null, $composer2, ($dirty2 >> 3) & 14, 2);
            Function3 transitionSpec$iv = CheckboxKt$CheckboxImpl$checkDrawFraction$2.INSTANCE;
            $composer2.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation($composer2, "C(animateFloat)P(2)933@37134L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            Transition $this$animateValue$iv$iv = transition;
            int $changed$iv$iv = ((0 << 3) & 57344) | (0 & 14) | ((0 << 3) & 896) | ((0 << 3) & 7168);
            $composer2.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)851@33724L32,852@33779L31,853@33835L23,855@33871L89:Transition.kt#pdpnli");
            int $changed2 = ($changed$iv$iv >> 9) & 112;
            ToggleableState it = (ToggleableState) $this$animateValue$iv$iv.getCurrentState();
            Composer $composer3 = $composer2;
            $composer3.startReplaceableGroup(-1798345588);
            ComposerKt.sourceInformation($composer3, "C:Checkbox.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                str = "C(animateFloat)P(2)933@37134L78:Transition.kt#pdpnli";
                ComposerKt.traceEventStart(-1798345588, $changed2, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:273)");
            } else {
                str = "C(animateFloat)P(2)933@37134L78:Transition.kt#pdpnli";
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
            Object initialValue$iv$iv = Float.valueOf(f);
            int $changed3 = ($changed$iv$iv >> 9) & 112;
            ToggleableState it2 = (ToggleableState) $this$animateValue$iv$iv.getTargetState();
            Composer $composer4 = $composer2;
            $composer4.startReplaceableGroup(-1798345588);
            ComposerKt.sourceInformation($composer4, "C:Checkbox.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1798345588, $changed3, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:273)");
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
            Function3 function3 = transitionSpec$iv;
            State checkDrawFraction$delegate = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv, initialValue$iv$iv, Float.valueOf(f2), (FiniteAnimationSpec) transitionSpec$iv.invoke($this$animateValue$iv$iv.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112)), vectorConverter, "FloatAnimation", $composer2, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            Function3 transitionSpec$iv2 = CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2.INSTANCE;
            $composer2.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation($composer2, str);
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            Transition $this$animateValue$iv$iv2 = transition;
            int $changed$iv$iv2 = ((0 << 3) & 57344) | (0 & 14) | ((0 << 3) & 896) | ((0 << 3) & 7168);
            $composer2.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)851@33724L32,852@33779L31,853@33835L23,855@33871L89:Transition.kt#pdpnli");
            int $changed4 = ($changed$iv$iv2 >> 9) & 112;
            ToggleableState it3 = (ToggleableState) $this$animateValue$iv$iv2.getCurrentState();
            Composer $composer5 = $composer2;
            $composer5.startReplaceableGroup(-2098942571);
            ComposerKt.sourceInformation($composer5, "C:Checkbox.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                Transition transition4 = transition;
                ComposerKt.traceEventStart(-2098942571, $changed4, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:289)");
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
            Object initialValue$iv$iv2 = Float.valueOf(f3);
            int $changed5 = ($changed$iv$iv2 >> 9) & 112;
            ToggleableState it4 = (ToggleableState) $this$animateValue$iv$iv2.getTargetState();
            Composer $composer6 = $composer2;
            $composer6.startReplaceableGroup(-2098942571);
            ComposerKt.sourceInformation($composer6, "C:Checkbox.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2098942571, $changed5, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:289)");
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
            State checkCenterGravitationShiftFraction$delegate = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv2, initialValue$iv$iv2, Float.valueOf(f4), (FiniteAnimationSpec) transitionSpec$iv2.invoke($this$animateValue$iv$iv2.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv2 >> 3) & 112)), vectorConverter2, "FloatAnimation", $composer2, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
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
            State checkColor$delegate = checkboxColors.checkmarkColor(toggleableState, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 6) & 112));
            boolean z2 = enabled;
            State boxColor$delegate = checkboxColors.boxColor(z2, toggleableState, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896));
            State borderColor$delegate = checkboxColors.borderColor(z2, toggleableState, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896));
            Modifier r10 = SizeKt.m822requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.Companion.getCenter(), false, 2, (Object) null), CheckboxSize);
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : new Object[]{boxColor$delegate, borderColor$delegate, checkColor$delegate, checkDrawFraction$delegate, checkCenterGravitationShiftFraction$delegate, checkCache}) {
                invalid$iv |= $composer2.changed(key$iv);
            }
            Composer $this$cache$iv$iv2 = $composer2;
            Object value$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
            if (invalid$iv || value$iv$iv2 == Composer.Companion.getEmpty()) {
                Object obj = value$iv$iv2;
                value$iv$iv2 = new CheckboxKt$CheckboxImpl$1$1(checkCache, boxColor$delegate, borderColor$delegate, checkColor$delegate, checkDrawFraction$delegate, checkCenterGravitationShiftFraction$delegate);
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
    public static final float CheckboxImpl$lambda$4(State<Float> $checkDrawFraction$delegate) {
        return ((Number) $checkDrawFraction$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final float CheckboxImpl$lambda$6(State<Float> $checkCenterGravitationShiftFraction$delegate) {
        return ((Number) $checkCenterGravitationShiftFraction$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final long CheckboxImpl$lambda$8(State<Color> $checkColor$delegate) {
        return ((Color) $checkColor$delegate.getValue()).m3174unboximpl();
    }

    /* access modifiers changed from: private */
    public static final long CheckboxImpl$lambda$9(State<Color> $boxColor$delegate) {
        return ((Color) $boxColor$delegate.getValue()).m3174unboximpl();
    }

    /* access modifiers changed from: private */
    public static final long CheckboxImpl$lambda$10(State<Color> $borderColor$delegate) {
        return ((Color) $borderColor$delegate.getValue()).m3174unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: drawBox-1wkBAMs  reason: not valid java name */
    public static final void m1426drawBox1wkBAMs(DrawScope $this$drawBox_u2d1wkBAMs, long boxColor, long borderColor, float radius, float strokeWidth) {
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
    public static final void m1427drawCheck3IgeMak(DrawScope $this$drawCheck_u2d3IgeMak, long checkColor, float checkFraction, float crossCenterGravitation, float strokeWidthPx, CheckDrawingCache drawingCache) {
        float f = crossCenterGravitation;
        Stroke stroke = new Stroke(strokeWidthPx, 0.0f, StrokeCap.Companion.m3549getSquareKaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
        float width = Size.m2984getWidthimpl($this$drawCheck_u2d3IgeMak.m3772getSizeNHjbRc());
        float gravitatedCrossX = MathHelpersKt.lerp(0.4f, 0.5f, f);
        float gravitatedCrossY = MathHelpersKt.lerp(0.7f, 0.5f, f);
        float gravitatedLeftY = MathHelpersKt.lerp(0.5f, 0.5f, f);
        float gravitatedRightY = MathHelpersKt.lerp(0.3f, 0.5f, f);
        CheckDrawingCache $this$drawCheck_3IgeMak_u24lambda_u2412 = drawingCache;
        $this$drawCheck_3IgeMak_u24lambda_u2412.getCheckPath().reset();
        $this$drawCheck_3IgeMak_u24lambda_u2412.getCheckPath().moveTo(width * 0.2f, width * gravitatedLeftY);
        $this$drawCheck_3IgeMak_u24lambda_u2412.getCheckPath().lineTo(width * gravitatedCrossX, width * gravitatedCrossY);
        $this$drawCheck_3IgeMak_u24lambda_u2412.getCheckPath().lineTo(width * 0.8f, width * gravitatedRightY);
        $this$drawCheck_3IgeMak_u24lambda_u2412.getPathMeasure().setPath($this$drawCheck_3IgeMak_u24lambda_u2412.getCheckPath(), false);
        $this$drawCheck_3IgeMak_u24lambda_u2412.getPathToDraw().reset();
        float f2 = width;
        $this$drawCheck_3IgeMak_u24lambda_u2412.getPathMeasure().getSegment(0.0f, $this$drawCheck_3IgeMak_u24lambda_u2412.getPathMeasure().getLength() * checkFraction, $this$drawCheck_3IgeMak_u24lambda_u2412.getPathToDraw(), true);
        DrawScope.m3744drawPathLG529CI$default($this$drawCheck_u2d3IgeMak, drawingCache.getPathToDraw(), checkColor, 0.0f, stroke, (ColorFilter) null, 0, 52, (Object) null);
    }
}
