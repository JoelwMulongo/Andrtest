package androidx.compose.material;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0001\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a{\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00100&¢\u0006\u0002\b\u0016¢\u0006\u0002\b(H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a7\u0010+\u001a\u00020\u00102\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u0016H\u0003¢\u0006\u0002\u0010,\u001a@\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001aD\u00102\u001a\u00020\u0010*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000bH\u0002\u001a\u001c\u0010=\u001a\u00020\u0010*\u0002032\u0006\u0010>\u001a\u0002072\u0006\u0010:\u001a\u00020\u000bH\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"\u0013\u0010\u000e\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006?"}, d2 = {"DoubleLineTextBaselineWithIcon", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalTextPadding", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "LargeTabHeight", "SingleLineTextBaselineWithIcon", "SmallTabHeight", "TabFadeInAnimationDelay", "", "TabFadeInAnimationDuration", "TabFadeOutAnimationDuration", "TextDistanceFromLeadingIcon", "LeadingIconTab", "", "selected", "", "onClick", "Lkotlin/Function0;", "text", "Landroidx/compose/runtime/Composable;", "icon", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "LeadingIconTab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "Tab", "Tab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-EVJuX4I", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextAndIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "tabWidth", "tabHeight", "firstBaseline", "lastBaseline", "placeTextOrIcon", "textOrIconPlaceable", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tab.kt */
public final class TabKt {
    private static final float DoubleLineTextBaselineWithIcon = Dp.m5986constructorimpl((float) 6);
    /* access modifiers changed from: private */
    public static final float HorizontalTextPadding = Dp.m5986constructorimpl((float) 16);
    private static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    /* access modifiers changed from: private */
    public static final float LargeTabHeight = Dp.m5986constructorimpl((float) 72);
    private static final float SingleLineTextBaselineWithIcon = Dp.m5986constructorimpl((float) 14);
    /* access modifiers changed from: private */
    public static final float SmallTabHeight = Dp.m5986constructorimpl((float) 48);
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    /* access modifiers changed from: private */
    public static final float TextDistanceFromLeadingIcon = Dp.m5986constructorimpl((float) 8);

    /* renamed from: Tab-0nD-MI0  reason: not valid java name */
    public static final void m1649Tab0nDMI0(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, Composer $composer, int $changed, int i) {
        boolean z;
        Function2 function2;
        long j;
        Function2 icon2;
        long unselectedContentColor2;
        Modifier modifier2;
        long selectedContentColor2;
        MutableInteractionSource interactionSource2;
        Function2 text2;
        Composer $composer2;
        boolean enabled2;
        Function2 text3;
        Function2 icon3;
        int $dirty;
        Function2 function22;
        Modifier modifier3;
        boolean enabled3;
        Function2 text4;
        Function2 icon4;
        boolean enabled4;
        MutableInteractionSource interactionSource3;
        long selectedContentColor3;
        Object value$iv$iv;
        int i2;
        int i3;
        Function0<Unit> function0 = onClick;
        int i4 = $changed;
        int i5 = i;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer3 = $composer.startRestartGroup(-1486097588);
        ComposerKt.sourceInformation($composer3, "C(Tab)P(5,4,3!1,7!2,6:c#ui.graphics.Color,8:c#ui.graphics.Color)96@4350L39,97@4443L7,98@4535L6,106@4792L234:Tab.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i5 & 1) != 0) {
            $dirty2 |= 6;
            boolean z2 = selected;
        } else if ((i4 & 14) == 0) {
            $dirty2 |= $composer3.changed(selected) ? 4 : 2;
        } else {
            boolean z3 = selected;
        }
        if ((i5 & 2) != 0) {
            $dirty2 |= 48;
        } else if ((i4 & 112) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int i6 = i5 & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
            Modifier modifier4 = modifier;
        } else if ((i4 & 896) == 0) {
            $dirty2 |= $composer3.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier5 = modifier;
        }
        int i7 = i5 & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            z = enabled;
        } else if ((i4 & 7168) == 0) {
            z = enabled;
            $dirty2 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i8 = i5 & 16;
        if (i8 != 0) {
            $dirty2 |= 24576;
            Function2<? super Composer, ? super Integer, Unit> function23 = text;
        } else if ((i4 & 57344) == 0) {
            $dirty2 |= $composer3.changedInstance(text) ? 16384 : 8192;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = text;
        }
        int i9 = i5 & 32;
        if (i9 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function2 = icon;
        } else if ((i4 & 458752) == 0) {
            function2 = icon;
            $dirty2 |= $composer3.changedInstance(function2) ? 131072 : 65536;
        } else {
            function2 = icon;
        }
        int i10 = i5 & 64;
        if (i10 != 0) {
            $dirty2 |= 1572864;
            MutableInteractionSource mutableInteractionSource = interactionSource;
        } else if ((i4 & 3670016) == 0) {
            $dirty2 |= $composer3.changed((Object) interactionSource) ? 1048576 : 524288;
        } else {
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
        }
        if ((i4 & 29360128) == 0) {
            if ((i5 & 128) != 0) {
                long j2 = selectedContentColor;
            } else if ($composer3.changed(selectedContentColor)) {
                i3 = 8388608;
                $dirty2 |= i3;
            }
            i3 = 4194304;
            $dirty2 |= i3;
        } else {
            long j3 = selectedContentColor;
        }
        if ((234881024 & i4) == 0) {
            if ((i5 & 256) == 0) {
                j = unselectedContentColor;
                if ($composer3.changed(j)) {
                    i2 = 67108864;
                    $dirty2 |= i2;
                }
            } else {
                j = unselectedContentColor;
            }
            i2 = 33554432;
            $dirty2 |= i2;
        } else {
            j = unselectedContentColor;
        }
        if ((191739611 & $dirty2) != 38347922 || !$composer3.getSkipping()) {
            $composer3.startDefaults();
            if ((i4 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i7 != 0) {
                    enabled3 = true;
                } else {
                    enabled3 = z;
                }
                if (i8 != 0) {
                    text4 = null;
                } else {
                    text4 = text;
                }
                if (i9 != 0) {
                    icon4 = null;
                } else {
                    icon4 = function2;
                }
                if (i10 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    modifier2 = modifier3;
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        enabled4 = enabled3;
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        enabled4 = enabled3;
                        Composer composer = $this$cache$iv$iv;
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource3 = (MutableInteractionSource) value$iv$iv;
                } else {
                    modifier2 = modifier3;
                    enabled4 = enabled3;
                    interactionSource3 = interactionSource;
                }
                if ((i5 & 128) != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(ContentColorKt.getLocalContentColor());
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    selectedContentColor3 = ((Color) consume).m3174unboximpl();
                    $dirty2 &= -29360129;
                } else {
                    selectedContentColor3 = selectedContentColor;
                }
                if ((i5 & 256) != 0) {
                    enabled2 = enabled4;
                    interactionSource2 = interactionSource3;
                    selectedContentColor2 = selectedContentColor3;
                    text3 = text4;
                    icon3 = icon4;
                    unselectedContentColor2 = Color.m3163copywmQWz5c$default(selectedContentColor3, ContentAlpha.INSTANCE.getMedium($composer3, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    $dirty = $dirty2 & -234881025;
                } else {
                    enabled2 = enabled4;
                    interactionSource2 = interactionSource3;
                    selectedContentColor2 = selectedContentColor3;
                    text3 = text4;
                    icon3 = icon4;
                    unselectedContentColor2 = j;
                    $dirty = $dirty2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i5 & 128) != 0) {
                    $dirty2 &= -29360129;
                }
                if ((i5 & 256) != 0) {
                    modifier2 = modifier;
                    interactionSource2 = interactionSource;
                    selectedContentColor2 = selectedContentColor;
                    enabled2 = z;
                    unselectedContentColor2 = j;
                    icon3 = function2;
                    text3 = text;
                    $dirty = $dirty2 & -234881025;
                } else {
                    modifier2 = modifier;
                    interactionSource2 = interactionSource;
                    selectedContentColor2 = selectedContentColor;
                    enabled2 = z;
                    unselectedContentColor2 = j;
                    icon3 = function2;
                    text3 = text;
                    $dirty = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1486097588, $dirty, -1, "androidx.compose.material.Tab (Tab.kt:89)");
            }
            if (text3 != null) {
                Function2 function25 = text3;
                function22 = ComposableLambdaKt.composableLambda($composer3, -1729014781, true, new TabKt$Tab$styledText$1$1(text3, $dirty));
            } else {
                function22 = null;
            }
            Function2 styledText = function22;
            int i11 = $dirty;
            Function2 function26 = styledText;
            icon2 = icon3;
            text2 = text3;
            $composer2 = $composer3;
            m1650TabEVJuX4I(selected, onClick, modifier2, enabled2, interactionSource2, selectedContentColor2, unselectedContentColor2, ComposableLambdaKt.composableLambda($composer3, -178151495, true, new TabKt$Tab$2(styledText, icon3, $dirty)), $composer3, 12582912 | ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty >> 6) & 57344) | (($dirty >> 6) & 458752) | (($dirty >> 6) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            text2 = text;
            interactionSource2 = interactionSource;
            selectedContentColor2 = selectedContentColor;
            int i12 = $dirty2;
            enabled2 = z;
            unselectedContentColor2 = j;
            icon2 = function2;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TabKt$Tab$3(selected, onClick, modifier2, enabled2, text2, icon2, interactionSource2, selectedContentColor2, unselectedContentColor2, $changed, i));
        }
    }

    /* renamed from: LeadingIconTab-0nD-MI0  reason: not valid java name */
    public static final void m1648LeadingIconTab0nDMI0(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        boolean enabled2;
        MutableInteractionSource interactionSource2;
        int $dirty;
        long unselectedContentColor2;
        long selectedContentColor2;
        MutableInteractionSource interactionSource3;
        boolean enabled3;
        Modifier modifier3;
        int $dirty2;
        long selectedContentColor3;
        MutableInteractionSource mutableInteractionSource;
        int i2;
        int $dirty3;
        int i3;
        Function0<Unit> function0 = onClick;
        Function2<? super Composer, ? super Integer, Unit> function2 = text;
        Function2<? super Composer, ? super Integer, Unit> function22 = icon;
        int i4 = $changed;
        int i5 = i;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function2, "text");
        Intrinsics.checkNotNullParameter(function22, "icon");
        Composer $composer2 = $composer.startRestartGroup(-1499861761);
        ComposerKt.sourceInformation($composer2, "C(LeadingIconTab)P(5,4,7,1,3!2,6:c#ui.graphics.Color,8:c#ui.graphics.Color)158@6914L39,159@7007L7,160@7099L6,165@7347L60,167@7413L929:Tab.kt#jmzs0o");
        int $dirty4 = $changed;
        if ((i5 & 1) != 0) {
            $dirty4 |= 6;
            boolean z = selected;
        } else if ((i4 & 14) == 0) {
            $dirty4 |= $composer2.changed(selected) ? 4 : 2;
        } else {
            boolean z2 = selected;
        }
        if ((i5 & 2) != 0) {
            $dirty4 |= 48;
        } else if ((i4 & 112) == 0) {
            $dirty4 |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if ((i5 & 4) != 0) {
            $dirty4 |= 384;
        } else if ((i4 & 896) == 0) {
            $dirty4 |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        if ((i5 & 8) != 0) {
            $dirty4 |= 3072;
        } else if ((i4 & 7168) == 0) {
            $dirty4 |= $composer2.changedInstance(function22) ? 2048 : 1024;
        }
        int i6 = i5 & 16;
        if (i6 != 0) {
            $dirty4 |= 24576;
            modifier2 = modifier;
        } else if ((57344 & i4) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer2.changed((Object) modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i7 = i5 & 32;
        if (i7 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            enabled2 = enabled;
        } else if ((458752 & i4) == 0) {
            enabled2 = enabled;
            $dirty4 |= $composer2.changed(enabled2) ? 131072 : 65536;
        } else {
            enabled2 = enabled;
        }
        int i8 = i5 & 64;
        if (i8 != 0) {
            $dirty4 |= 1572864;
            interactionSource2 = interactionSource;
        } else if ((3670016 & i4) == 0) {
            interactionSource2 = interactionSource;
            $dirty4 |= $composer2.changed((Object) interactionSource2) ? 1048576 : 524288;
        } else {
            interactionSource2 = interactionSource;
        }
        if ((29360128 & i4) == 0) {
            if ((i5 & 128) == 0) {
                $dirty3 = $dirty4;
                if ($composer2.changed(selectedContentColor)) {
                    i3 = 8388608;
                    $dirty = $dirty3 | i3;
                }
            } else {
                $dirty3 = $dirty4;
                long j = selectedContentColor;
            }
            i3 = 4194304;
            $dirty = $dirty3 | i3;
        } else {
            long j2 = selectedContentColor;
            $dirty = $dirty4;
        }
        if ((i4 & 234881024) == 0) {
            if ((i5 & 256) != 0) {
                long j3 = unselectedContentColor;
            } else if ($composer2.changed(unselectedContentColor)) {
                i2 = 67108864;
                $dirty |= i2;
            }
            i2 = 33554432;
            $dirty |= i2;
        } else {
            long j4 = unselectedContentColor;
        }
        if (($dirty & 191739611) != 38347922 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i4 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i7 != 0) {
                    enabled2 = true;
                }
                if (i8 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer2;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource);
                    } else {
                        mutableInteractionSource = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    interactionSource2 = mutableInteractionSource;
                }
                if ((i5 & 128) != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(ContentColorKt.getLocalContentColor());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    selectedContentColor3 = ((Color) consume).m3174unboximpl();
                    $dirty &= -29360129;
                } else {
                    selectedContentColor3 = selectedContentColor;
                }
                if ((i5 & 256) != 0) {
                    $dirty2 = $dirty & -234881025;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                    unselectedContentColor2 = Color.m3163copywmQWz5c$default(selectedContentColor3, ContentAlpha.INSTANCE.getMedium($composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    selectedContentColor2 = selectedContentColor3;
                } else {
                    unselectedContentColor2 = unselectedContentColor;
                    selectedContentColor2 = selectedContentColor3;
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i5 & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i5 & 256) != 0) {
                    selectedContentColor2 = selectedContentColor;
                    unselectedContentColor2 = unselectedContentColor;
                    $dirty2 = $dirty & -234881025;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                } else {
                    selectedContentColor2 = selectedContentColor;
                    unselectedContentColor2 = unselectedContentColor;
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1499861761, $dirty2, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:151)");
            }
            TabKt$LeadingIconTab$2 tabKt$LeadingIconTab$2 = r0;
            int $dirty5 = $dirty2;
            TabKt$LeadingIconTab$2 tabKt$LeadingIconTab$22 = new TabKt$LeadingIconTab$2(modifier3, selected, interactionSource3, RippleKt.m1729rememberRipple9IZ8Weo(true, 0.0f, selectedContentColor2, $composer2, (($dirty2 >> 15) & 896) | 6, 2), enabled3, onClick, icon, $dirty2, text);
            m1651TabTransitionKlgxPg(selectedContentColor2, unselectedContentColor2, selected, ComposableLambdaKt.composableLambda($composer2, 866677691, true, tabKt$LeadingIconTab$2), $composer2, (($dirty5 >> 21) & 14) | 3072 | (($dirty5 >> 21) & 112) | (($dirty5 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            selectedContentColor2 = selectedContentColor;
            unselectedContentColor2 = unselectedContentColor;
            enabled3 = enabled2;
            interactionSource3 = interactionSource2;
            int i9 = $dirty;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new TabKt$LeadingIconTab$3(selected, onClick, text, icon, modifier3, enabled3, interactionSource3, selectedContentColor2, unselectedContentColor2, $changed, i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:128:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0131  */
    /* renamed from: Tab-EVJuX4I  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1650TabEVJuX4I(boolean r29, kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.ui.Modifier r31, boolean r32, androidx.compose.foundation.interaction.MutableInteractionSource r33, long r34, long r36, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r13 = r30
            r14 = r38
            r15 = r40
            r12 = r41
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 713679175(0x2a89e147, float:2.4492406E-13)
            r1 = r39
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Tab)P(5,4,3,1,2,6:c#ui.graphics.Color,7:c#ui.graphics.Color)227@10083L39,228@10176L7,229@10268L6,235@10562L60,237@10628L618:Tab.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r40
            r2 = r12 & 1
            if (r2 == 0) goto L_0x002c
            r1 = r1 | 6
            r10 = r29
            goto L_0x003f
        L_0x002c:
            r2 = r15 & 14
            if (r2 != 0) goto L_0x003d
            r10 = r29
            boolean r2 = r11.changed((boolean) r10)
            if (r2 == 0) goto L_0x003a
            r2 = 4
            goto L_0x003b
        L_0x003a:
            r2 = 2
        L_0x003b:
            r1 = r1 | r2
            goto L_0x003f
        L_0x003d:
            r10 = r29
        L_0x003f:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0046
            r1 = r1 | 48
            goto L_0x0056
        L_0x0046:
            r2 = r15 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0056
            boolean r2 = r11.changedInstance(r13)
            if (r2 == 0) goto L_0x0053
            r2 = 32
            goto L_0x0055
        L_0x0053:
            r2 = 16
        L_0x0055:
            r1 = r1 | r2
        L_0x0056:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x005f
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r31
            goto L_0x0074
        L_0x005f:
            r3 = r15 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0072
            r3 = r31
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x006e
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0070
        L_0x006e:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0070:
            r1 = r1 | r4
            goto L_0x0074
        L_0x0072:
            r3 = r31
        L_0x0074:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x007d
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r32
            goto L_0x0092
        L_0x007d:
            r5 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0090
            r5 = r32
            boolean r6 = r11.changed((boolean) r5)
            if (r6 == 0) goto L_0x008c
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x008e
        L_0x008c:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x008e:
            r1 = r1 | r6
            goto L_0x0092
        L_0x0090:
            r5 = r32
        L_0x0092:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x009b
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r7 = r33
            goto L_0x00b2
        L_0x009b:
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r15
            if (r7 != 0) goto L_0x00b0
            r7 = r33
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x00ac
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ae
        L_0x00ac:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x00ae:
            r1 = r1 | r8
            goto L_0x00b2
        L_0x00b0:
            r7 = r33
        L_0x00b2:
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r15
            if (r8 != 0) goto L_0x00cd
            r8 = r12 & 32
            if (r8 != 0) goto L_0x00c6
            r8 = r34
            boolean r16 = r11.changed((long) r8)
            if (r16 == 0) goto L_0x00c8
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ca
        L_0x00c6:
            r8 = r34
        L_0x00c8:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00ca:
            r1 = r1 | r16
            goto L_0x00cf
        L_0x00cd:
            r8 = r34
        L_0x00cf:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r15 & r16
            if (r16 != 0) goto L_0x00ef
            r16 = r12 & 64
            if (r16 != 0) goto L_0x00e6
            r39 = r1
            r0 = r36
            boolean r17 = r11.changed((long) r0)
            if (r17 == 0) goto L_0x00ea
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ec
        L_0x00e6:
            r39 = r1
            r0 = r36
        L_0x00ea:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00ec:
            r17 = r39 | r17
            goto L_0x00f5
        L_0x00ef:
            r39 = r1
            r0 = r36
            r17 = r39
        L_0x00f5:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00fe
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00fb:
            r17 = r17 | r0
            goto L_0x010f
        L_0x00fe:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r15
            if (r0 != 0) goto L_0x010f
            boolean r0 = r11.changedInstance(r14)
            if (r0 == 0) goto L_0x010c
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fb
        L_0x010c:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00fb
        L_0x010f:
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r17 & r0
            r1 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r1) goto L_0x0131
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x0120
            goto L_0x0131
        L_0x0120:
            r11.skipToGroupEnd()
            r23 = r36
            r16 = r3
            r18 = r7
            r21 = r8
            r19 = r17
            r17 = r5
            goto L_0x027b
        L_0x0131:
            r11.startDefaults()
            r0 = r15 & 1
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r0 == 0) goto L_0x016d
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0142
            goto L_0x016d
        L_0x0142:
            r11.skipToGroupEnd()
            r0 = r12 & 32
            if (r0 == 0) goto L_0x014b
            r17 = r17 & r18
        L_0x014b:
            r0 = r12 & 64
            if (r0 == 0) goto L_0x0160
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r0 = r17 & r0
            r23 = r36
            r17 = r5
            r18 = r7
            r21 = r8
            r8 = r0
            r9 = r3
            goto L_0x0207
        L_0x0160:
            r23 = r36
            r18 = r7
            r21 = r8
            r8 = r17
            r9 = r3
            r17 = r5
            goto L_0x0207
        L_0x016d:
            if (r2 == 0) goto L_0x0174
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r3 = r0
        L_0x0174:
            if (r4 == 0) goto L_0x0178
            r0 = 1
            r5 = r0
        L_0x0178:
            if (r6 == 0) goto L_0x01af
            r0 = 0
            r2 = 0
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            r4 = 0
            r6 = r11
            r19 = 0
            java.lang.Object r1 = r6.rememberedValue()
            r21 = 0
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r31 = r0
            java.lang.Object r0 = r22.getEmpty()
            if (r1 != r0) goto L_0x01a6
            r0 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r6.updateRememberedValue(r0)
            goto L_0x01a7
        L_0x01a6:
            r0 = r1
        L_0x01a7:
            r11.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r7 = r0
        L_0x01af:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x01d3
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r2 = 0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r6)
            java.lang.Object r4 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.graphics.Color r4 = (androidx.compose.ui.graphics.Color) r4
            long r0 = r4.m3174unboximpl()
            r17 = r17 & r18
            r8 = r0
        L_0x01d3:
            r0 = r12 & 64
            if (r0 == 0) goto L_0x01fc
            androidx.compose.material.ContentAlpha r0 = androidx.compose.material.ContentAlpha.INSTANCE
            r1 = 6
            float r23 = r0.getMedium(r11, r1)
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 14
            r28 = 0
            r21 = r8
            long r0 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r21, r23, r24, r25, r26, r27, r28)
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r2 = r17 & r2
            r23 = r0
            r17 = r5
            r18 = r7
            r8 = r2
            r9 = r3
            goto L_0x0207
        L_0x01fc:
            r23 = r36
            r18 = r7
            r21 = r8
            r8 = r17
            r9 = r3
            r17 = r5
        L_0x0207:
            r11.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0219
            r0 = -1
            java.lang.String r1 = "androidx.compose.material.Tab (Tab.kt:222)"
            r2 = 713679175(0x2a89e147, float:2.4492406E-13)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r8, r0, r1)
        L_0x0219:
            r0 = 1
            r1 = 0
            int r2 = r8 >> 9
            r2 = r2 & 896(0x380, float:1.256E-42)
            r3 = 6
            r2 = r2 | r3
            r3 = 2
            r31 = r0
            r32 = r1
            r33 = r21
            r35 = r11
            r36 = r2
            r37 = r3
            androidx.compose.foundation.Indication r16 = androidx.compose.material.ripple.RippleKt.m1729rememberRipple9IZ8Weo(r31, r32, r33, r35, r36, r37)
            androidx.compose.material.TabKt$Tab$5 r7 = new androidx.compose.material.TabKt$Tab$5
            r0 = r7
            r1 = r9
            r2 = r29
            r3 = r18
            r4 = r16
            r5 = r17
            r6 = r30
            r31 = r9
            r9 = r7
            r7 = r38
            r19 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = -1237246709(0xffffffffb6411d0b, float:-2.8776146E-6)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r0, r1, r9)
            r6 = r0
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            int r0 = r19 >> 15
            r0 = r0 & 14
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            int r1 = r19 >> 15
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r19 << 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r8 = r0 | r1
            r1 = r21
            r3 = r23
            r5 = r29
            r7 = r11
            m1651TabTransitionKlgxPg(r1, r3, r5, r6, r7, r8)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0279
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0279:
            r16 = r31
        L_0x027b:
            androidx.compose.runtime.ScopeUpdateScope r8 = r11.endRestartGroup()
            if (r8 != 0) goto L_0x0284
            r25 = r11
            goto L_0x02a9
        L_0x0284:
            androidx.compose.material.TabKt$Tab$6 r20 = new androidx.compose.material.TabKt$Tab$6
            r0 = r20
            r1 = r29
            r2 = r30
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r21
            r13 = r8
            r8 = r23
            r10 = r38
            r25 = r11
            r11 = r40
            r12 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x02a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabKt.m1650TabEVJuX4I(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: TabTransition-Klgx-Pg  reason: not valid java name */
    public static final void m1651TabTransitionKlgxPg(long activeColor, long inactiveColor, boolean selected, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        long j;
        long j2;
        TwoWayConverter value$iv$iv$iv;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-405571117);
        ComposerKt.sourceInformation($composer2, "C(TabTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)268@11677L26,269@11732L550,287@12287L164:Tab.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            j = activeColor;
            $dirty |= $composer2.changed(j) ? 4 : 2;
        } else {
            j = activeColor;
        }
        if ((i & 112) == 0) {
            j2 = inactiveColor;
            $dirty |= $composer2.changed(j2) ? 32 : 16;
        } else {
            j2 = inactiveColor;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changed(selected) ? 256 : 128;
        } else {
            boolean z = selected;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-405571117, $dirty, -1, "androidx.compose.material.TabTransition (Tab.kt:262)");
            }
            Transition transition = TransitionKt.updateTransition(Boolean.valueOf(selected), (String) null, $composer2, ($dirty >> 6) & 14, 2);
            Function3 transitionSpec$iv = TabKt$TabTransition$color$2.INSTANCE;
            Transition $this$animateColor$iv = transition;
            $composer2.startReplaceableGroup(-1939694975);
            ComposerKt.sourceInformation($composer2, "C(animateColor)P(2)68@3224L31,69@3291L70,73@3374L70:Transition.kt#xbi5r1");
            int $changed2 = (0 >> 6) & 112;
            boolean it = ((Boolean) $this$animateColor$iv.getTargetState()).booleanValue();
            Composer $composer3 = $composer2;
            $composer3.startReplaceableGroup(1445938070);
            ComposerKt.sourceInformation($composer3, "C:Tab.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                Transition transition2 = transition;
                ComposerKt.traceEventStart(1445938070, $changed2, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:284)");
            }
            long j3 = it ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer3.endReplaceableGroup();
            ColorSpace colorSpace$iv = Color.m3168getColorSpaceimpl(j3);
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv$iv = $composer2.changed((Object) colorSpace$iv);
            Composer $this$cache$iv$iv$iv = $composer2;
            Object it$iv$iv$iv = $this$cache$iv$iv$iv.rememberedValue();
            if (invalid$iv$iv$iv || it$iv$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv$iv = ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpace$iv);
                $this$cache$iv$iv$iv.updateRememberedValue(value$iv$iv$iv);
            } else {
                value$iv$iv$iv = it$iv$iv$iv;
                Composer composer = $this$cache$iv$iv$iv;
            }
            $composer2.endReplaceableGroup();
            TwoWayConverter typeConverter$iv = value$iv$iv$iv;
            int $changed$iv$iv = (0 & 14) | 64 | ((0 << 3) & 896) | ((0 << 3) & 7168) | ((0 << 3) & 57344);
            Transition $this$animateValue$iv$iv = $this$animateColor$iv;
            $composer2.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)851@33724L32,852@33779L31,853@33835L23,855@33871L89:Transition.kt#pdpnli");
            int $changed3 = ($changed$iv$iv >> 9) & 112;
            boolean it2 = ((Boolean) $this$animateValue$iv$iv.getCurrentState()).booleanValue();
            ColorSpace colorSpace = colorSpace$iv;
            Composer $composer4 = $composer2;
            $composer4.startReplaceableGroup(1445938070);
            ComposerKt.sourceInformation($composer4, "C:Tab.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1445938070, $changed3, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:284)");
            }
            long j4 = it2 ? activeColor : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer4.endReplaceableGroup();
            Object initialValue$iv$iv = Color.m3154boximpl(j4);
            int $changed4 = ($changed$iv$iv >> 9) & 112;
            boolean it3 = ((Boolean) $this$animateValue$iv$iv.getTargetState()).booleanValue();
            Composer $composer5 = $composer2;
            $composer5.startReplaceableGroup(1445938070);
            ComposerKt.sourceInformation($composer5, "C:Tab.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1445938070, $changed4, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:284)");
            }
            long j5 = it3 ? activeColor : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer5.endReplaceableGroup();
            State createTransitionAnimation = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv, initialValue$iv$iv, Color.m3154boximpl(j5), (FiniteAnimationSpec) transitionSpec$iv.invoke($this$animateValue$iv$iv.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112)), typeConverter$iv, "ColorAnimation", $composer2, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            State color$delegate = createTransitionAnimation;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(Color.m3163copywmQWz5c$default(TabTransition_Klgx_Pg$lambda$5(color$delegate), 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3166getAlphaimpl(TabTransition_Klgx_Pg$lambda$5(color$delegate))))}, function2, $composer2, (($dirty >> 6) & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i2 = $dirty;
            Composer composer2 = $composer2;
            return;
        }
        int i3 = $dirty;
        Composer composer3 = $composer2;
        endRestartGroup.updateScope(new TabKt$TabTransition$1(activeColor, inactiveColor, selected, content, $changed));
    }

    private static final long TabTransition_Klgx_Pg$lambda$5(State<Color> $color$delegate) {
        return ((Color) $color$delegate.getValue()).m3174unboximpl();
    }

    /* access modifiers changed from: private */
    public static final void TabBaselineLayout(Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, Composer $composer, int $changed) {
        String str;
        Function2<? super Composer, ? super Integer, Unit> function2 = text;
        Function2<? super Composer, ? super Integer, Unit> function22 = icon;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(1249848471);
        ComposerKt.sourceInformation($composer2, "C(TabBaselineLayout)P(1)304@12859L1909:Tab.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1249848471, $dirty, -1, "androidx.compose.material.TabBaselineLayout (Tab.kt:300)");
            }
            MeasurePolicy measurePolicy$iv = new TabKt$TabBaselineLayout$2(function2, function22);
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m2787constructorimpl($composer2);
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            MeasurePolicy measurePolicy = measurePolicy$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            function3.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            Composer $composer3 = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer3, -2141028452, "C:Tab.kt#jmzs0o");
            $composer3.startReplaceableGroup(-2141028452);
            ComposerKt.sourceInformation($composer3, "307@12925L123");
            int i2 = ($changed$iv$iv >> 9) & 14;
            if (function2 != null) {
                Modifier modifier = modifier$iv;
                Density density = density$iv;
                LayoutDirection layoutDirection = layoutDirection$iv;
                ViewConfiguration viewConfiguration = viewConfiguration$iv;
                int i3 = $changed$iv$iv;
                Modifier modifier$iv2 = PaddingKt.m762paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "text"), HorizontalTextPadding, 0.0f, 2, (Object) null);
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                Alignment alignment = contentAlignment$iv;
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer3.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv = (Density) consume4;
                Function0<ComposeUiNode> function0 = constructor;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume5;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(modifier$iv2);
                Modifier modifier2 = modifier$iv2;
                int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = materializerOf2;
                str = "C:CompositionLocal.kt#9igjgp";
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(constructor2);
                } else {
                    $composer3.useNode();
                }
                $composer3.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer3);
                Function0<ComposeUiNode> function02 = constructor2;
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer3.enableReusing();
                ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = function33;
                function34.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                Composer $composer$iv = $composer3;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function35 = function34;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                int i4 = ((6 >> 6) & 112) | 6;
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i5 = ($changed$iv$iv$iv >> 9) & 14;
                int i6 = $changed$iv$iv$iv;
                Composer $composer4 = $composer$iv;
                ComposerKt.sourceInformationMarkerStart($composer4, -1952926252, "C309@13040L6:Tab.kt#jmzs0o");
                function2.invoke($composer4, Integer.valueOf($dirty & 14));
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            } else {
                str = "C:CompositionLocal.kt#9igjgp";
                Modifier modifier3 = modifier$iv;
                Density density2 = density$iv;
                LayoutDirection layoutDirection2 = layoutDirection$iv;
                ViewConfiguration viewConfiguration3 = viewConfiguration$iv;
                int i7 = $changed$iv$iv;
                Function0<ComposeUiNode> function03 = constructor;
            }
            $composer3.endReplaceableGroup();
            $composer2.startReplaceableGroup(448373045);
            ComposerKt.sourceInformation($composer2, "312@13111L41");
            if (function22 != null) {
                Modifier modifier$iv3 = LayoutIdKt.layoutId(Modifier.Companion, "icon");
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                Alignment alignment2 = contentAlignment$iv2;
                String str2 = str;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str2);
                Object consume7 = $composer3.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv2 = (Density) consume7;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str2);
                Object consume8 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume8;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str2);
                Object consume9 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume9;
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv3);
                int $changed$iv$iv$iv2 = ((((6 << 3) & 112) << 9) & 7168) | 6;
                Modifier modifier4 = modifier$iv3;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(constructor3);
                } else {
                    $composer3.useNode();
                }
                $composer3.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2787constructorimpl($composer3);
                Function0<ComposeUiNode> function04 = constructor3;
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer3.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                Composer $composer$iv2 = $composer3;
                int i8 = ($changed$iv$iv$iv2 >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i9 = ((6 >> 6) & 112) | 6;
                Density density3 = density$iv$iv2;
                Composer $composer5 = $composer$iv2;
                ComposerKt.sourceInformationMarkerStart($composer5, -1952926148, "C312@13144L6:Tab.kt#jmzs0o");
                function22.invoke($composer5, Integer.valueOf(($dirty >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            }
            $composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i10 = $changed;
        } else {
            endRestartGroup.updateScope(new TabKt$TabBaselineLayout$3(function2, function22, $changed));
        }
    }

    /* access modifiers changed from: private */
    public static final void placeTextOrIcon(Placeable.PlacementScope $this$placeTextOrIcon, Placeable textOrIconPlaceable, int tabHeight) {
        Placeable.PlacementScope.placeRelative$default($this$placeTextOrIcon, textOrIconPlaceable, 0, (tabHeight - textOrIconPlaceable.getHeight()) / 2, 0.0f, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void placeTextAndIcon(Placeable.PlacementScope $this$placeTextAndIcon, Density density, Placeable textPlaceable, Placeable iconPlaceable, int tabWidth, int tabHeight, int firstBaseline, int lastBaseline) {
        float baselineOffset;
        int i = firstBaseline;
        int i2 = lastBaseline;
        if (i == i2) {
            baselineOffset = SingleLineTextBaselineWithIcon;
        } else {
            baselineOffset = DoubleLineTextBaselineWithIcon;
        }
        Density $this$placeTextAndIcon_u24lambda_u249 = density;
        int textOffset = $this$placeTextAndIcon_u24lambda_u249.m5961roundToPx0680j_4(baselineOffset) + $this$placeTextAndIcon_u24lambda_u249.m5961roundToPx0680j_4(TabRowDefaults.INSTANCE.m1660getIndicatorHeightD9Ej5fM());
        int iconOffset = (iconPlaceable.getHeight() + density.m5960roundToPxR2X_6o(IconDistanceFromBaseline)) - i;
        int textPlaceableY = (tabHeight - i2) - textOffset;
        Placeable.PlacementScope.placeRelative$default($this$placeTextAndIcon, textPlaceable, (tabWidth - textPlaceable.getWidth()) / 2, textPlaceableY, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default($this$placeTextAndIcon, iconPlaceable, (tabWidth - iconPlaceable.getWidth()) / 2, textPlaceableY - iconOffset, 0.0f, 4, (Object) null);
    }
}
