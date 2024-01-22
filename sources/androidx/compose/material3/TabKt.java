package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
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

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0001\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a{\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00100&¢\u0006\u0002\b\u0016¢\u0006\u0002\b(H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a7\u0010+\u001a\u00020\u00102\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u0016H\u0003¢\u0006\u0002\u0010,\u001a@\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00122\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001aD\u00102\u001a\u00020\u0010*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000bH\u0002\u001a\u001c\u0010=\u001a\u00020\u0010*\u0002032\u0006\u0010>\u001a\u0002072\u0006\u0010:\u001a\u00020\u000bH\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"\u0013\u0010\u000e\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006?"}, d2 = {"DoubleLineTextBaselineWithIcon", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalTextPadding", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "LargeTabHeight", "SingleLineTextBaselineWithIcon", "SmallTabHeight", "TabFadeInAnimationDelay", "", "TabFadeInAnimationDuration", "TabFadeOutAnimationDuration", "TextDistanceFromLeadingIcon", "LeadingIconTab", "", "selected", "", "onClick", "Lkotlin/Function0;", "text", "Landroidx/compose/runtime/Composable;", "icon", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "LeadingIconTab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "Tab", "Tab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-bogVsAg", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextAndIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "tabWidth", "tabHeight", "firstBaseline", "lastBaseline", "placeTextOrIcon", "textOrIconPlaceable", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Tab.kt */
public final class TabKt {
    private static final float DoubleLineTextBaselineWithIcon = Dp.m5986constructorimpl((float) 6);
    /* access modifiers changed from: private */
    public static final float HorizontalTextPadding = Dp.m5986constructorimpl((float) 16);
    /* access modifiers changed from: private */
    public static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    /* access modifiers changed from: private */
    public static final float LargeTabHeight = Dp.m5986constructorimpl((float) 72);
    private static final float SingleLineTextBaselineWithIcon = Dp.m5986constructorimpl((float) 14);
    /* access modifiers changed from: private */
    public static final float SmallTabHeight = PrimaryNavigationTabTokens.INSTANCE.m2649getContainerHeightD9Ej5fM();
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    /* access modifiers changed from: private */
    public static final float TextDistanceFromLeadingIcon = Dp.m5986constructorimpl((float) 8);

    /* renamed from: Tab-wqdebIU  reason: not valid java name */
    public static final void m2123TabwqdebIU(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, long selectedContentColor, long unselectedContentColor, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i) {
        Function2 function2;
        long unselectedContentColor2;
        Function2 icon2;
        MutableInteractionSource interactionSource2;
        long unselectedContentColor3;
        long selectedContentColor2;
        boolean enabled2;
        Modifier modifier2;
        Function2 text2;
        Composer $composer2;
        Function2 text3;
        Function2 icon3;
        int $dirty;
        Function2 function22;
        Modifier modifier3;
        boolean enabled3;
        Function2 text4;
        Function2 icon4;
        Modifier modifier4;
        long selectedContentColor3;
        Object value$iv$iv;
        int i2;
        int i3;
        Function0<Unit> function0 = onClick;
        int i4 = $changed;
        int i5 = i;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer3 = $composer.startRestartGroup(-350627181);
        ComposerKt.sourceInformation($composer3, "C(Tab)P(5,4,3!1,7!1,6:c#ui.graphics.Color,8:c#ui.graphics.Color)98@4343L7,100@4460L39,110@4827L234:Tab.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i5 & 1) != 0) {
            $dirty2 |= 6;
            boolean z = selected;
        } else if ((i4 & 14) == 0) {
            $dirty2 |= $composer3.changed(selected) ? 4 : 2;
        } else {
            boolean z2 = selected;
        }
        if ((i5 & 2) != 0) {
            $dirty2 |= 48;
        } else if ((i4 & 112) == 0) {
            $dirty2 |= $composer3.changed((Object) function0) ? 32 : 16;
        }
        int i6 = i5 & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
            Modifier modifier5 = modifier;
        } else if ((i4 & 896) == 0) {
            $dirty2 |= $composer3.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier6 = modifier;
        }
        int i7 = i5 & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            boolean z3 = enabled;
        } else if ((i4 & 7168) == 0) {
            $dirty2 |= $composer3.changed(enabled) ? 2048 : 1024;
        } else {
            boolean z4 = enabled;
        }
        int i8 = i5 & 16;
        if (i8 != 0) {
            $dirty2 |= 24576;
            Function2<? super Composer, ? super Integer, Unit> function23 = text;
        } else if ((i4 & 57344) == 0) {
            $dirty2 |= $composer3.changed((Object) text) ? 16384 : 8192;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = text;
        }
        int i9 = i5 & 32;
        if (i9 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function2 = icon;
        } else if ((i4 & 458752) == 0) {
            function2 = icon;
            $dirty2 |= $composer3.changed((Object) function2) ? 131072 : 65536;
        } else {
            function2 = icon;
        }
        if ((i4 & 3670016) == 0) {
            if ((i5 & 64) != 0) {
                long j = selectedContentColor;
            } else if ($composer3.changed(selectedContentColor)) {
                i3 = 1048576;
                $dirty2 |= i3;
            }
            i3 = 524288;
            $dirty2 |= i3;
        } else {
            long j2 = selectedContentColor;
        }
        if ((i4 & 29360128) == 0) {
            if ((i5 & 128) == 0) {
                unselectedContentColor2 = unselectedContentColor;
                if ($composer3.changed(unselectedContentColor2)) {
                    i2 = 8388608;
                    $dirty2 |= i2;
                }
            } else {
                unselectedContentColor2 = unselectedContentColor;
            }
            i2 = 4194304;
            $dirty2 |= i2;
        } else {
            unselectedContentColor2 = unselectedContentColor;
        }
        int i10 = i5 & 256;
        if (i10 != 0) {
            $dirty2 |= 100663296;
            MutableInteractionSource mutableInteractionSource = interactionSource;
        } else if ((i4 & 234881024) == 0) {
            $dirty2 |= $composer3.changed((Object) interactionSource) ? 67108864 : 33554432;
        } else {
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
        }
        if (($dirty2 & 191739611) != 38347922 || !$composer3.getSkipping()) {
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
                    enabled3 = enabled;
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
                if ((i5 & 64) != 0) {
                    modifier4 = modifier3;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(ContentColorKt.getLocalContentColor());
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    selectedContentColor3 = ((Color) consume).m3174unboximpl();
                    $dirty2 &= -3670017;
                } else {
                    modifier4 = modifier3;
                    selectedContentColor3 = selectedContentColor;
                }
                if ((i5 & 128) != 0) {
                    unselectedContentColor2 = selectedContentColor3;
                    $dirty2 &= -29360129;
                }
                if (i10 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    int $dirty3 = $dirty2;
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        Object obj = it$iv$iv;
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        Object obj2 = it$iv$iv;
                        Object it$iv$iv2 = $this$cache$iv$iv;
                        value$iv$iv = obj2;
                    }
                    $composer3.endReplaceableGroup();
                    modifier2 = modifier4;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    enabled2 = enabled3;
                    unselectedContentColor3 = unselectedContentColor2;
                    selectedContentColor2 = selectedContentColor3;
                    $dirty = $dirty3;
                    text3 = text4;
                    icon3 = icon4;
                } else {
                    modifier2 = modifier4;
                    interactionSource2 = interactionSource;
                    enabled2 = enabled3;
                    unselectedContentColor3 = unselectedContentColor2;
                    selectedContentColor2 = selectedContentColor3;
                    $dirty = $dirty2;
                    text3 = text4;
                    icon3 = icon4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i5 & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i5 & 128) != 0) {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    selectedContentColor2 = selectedContentColor;
                    interactionSource2 = interactionSource;
                    unselectedContentColor3 = unselectedContentColor2;
                    icon3 = function2;
                    text3 = text;
                    $dirty = $dirty2 & -29360129;
                } else {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    selectedContentColor2 = selectedContentColor;
                    interactionSource2 = interactionSource;
                    unselectedContentColor3 = unselectedContentColor2;
                    icon3 = function2;
                    text3 = text;
                    $dirty = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-350627181, $dirty, -1, "androidx.compose.material3.Tab (Tab.kt:91)");
            }
            if (text3 != null) {
                Function2 function25 = text3;
                function22 = ComposableLambdaKt.composableLambda($composer3, 708874428, true, new TabKt$Tab$styledText$1$1(text3, $dirty));
            } else {
                function22 = null;
            }
            Function2 styledText = function22;
            Function2 function26 = styledText;
            int i11 = $dirty;
            icon2 = icon3;
            text2 = text3;
            $composer2 = $composer3;
            m2122TabbogVsAg(selected, onClick, modifier2, enabled2, selectedContentColor2, unselectedContentColor3, interactionSource2, ComposableLambdaKt.composableLambda($composer3, 1540996038, true, new TabKt$Tab$2(styledText, icon3, $dirty)), $composer3, 12582912 | ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty >> 6) & 57344) | (($dirty >> 6) & 458752) | (($dirty >> 6) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            enabled2 = enabled;
            text2 = text;
            selectedContentColor2 = selectedContentColor;
            interactionSource2 = interactionSource;
            int i12 = $dirty2;
            unselectedContentColor3 = unselectedContentColor2;
            icon2 = function2;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TabKt$Tab$3(selected, onClick, modifier2, enabled2, text2, icon2, selectedContentColor2, unselectedContentColor3, interactionSource2, $changed, i));
        }
    }

    /* renamed from: LeadingIconTab-wqdebIU  reason: not valid java name */
    public static final void m2121LeadingIconTabwqdebIU(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, Modifier modifier, boolean enabled, long selectedContentColor, long unselectedContentColor, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        boolean enabled2;
        long selectedContentColor2;
        int $dirty;
        MutableInteractionSource interactionSource2;
        long unselectedContentColor2;
        long selectedContentColor3;
        boolean enabled3;
        Modifier modifier3;
        int $dirty2;
        long unselectedContentColor3;
        Object value$iv$iv;
        int $dirty3;
        int i2;
        int i3;
        Function0<Unit> function0 = onClick;
        Function2<? super Composer, ? super Integer, Unit> function2 = text;
        Function2<? super Composer, ? super Integer, Unit> function22 = icon;
        int i4 = $changed;
        int i5 = i;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function2, "text");
        Intrinsics.checkNotNullParameter(function22, "icon");
        Composer $composer2 = $composer.startRestartGroup(-777316544);
        ComposerKt.sourceInformation($composer2, "C(LeadingIconTab)P(5,4,7,1,3!1,6:c#ui.graphics.Color,8:c#ui.graphics.Color)161@6803L7,163@6920L39,168@7200L60,170@7266L991:Tab.kt#uh7d8r");
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
            $dirty4 |= $composer2.changed((Object) function0) ? 32 : 16;
        }
        if ((i5 & 4) != 0) {
            $dirty4 |= 384;
        } else if ((i4 & 896) == 0) {
            $dirty4 |= $composer2.changed((Object) function2) ? 256 : 128;
        }
        if ((i5 & 8) != 0) {
            $dirty4 |= 3072;
        } else if ((i4 & 7168) == 0) {
            $dirty4 |= $composer2.changed((Object) function22) ? 2048 : 1024;
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
        if ((3670016 & i4) == 0) {
            if ((i5 & 64) == 0) {
                selectedContentColor2 = selectedContentColor;
                if ($composer2.changed(selectedContentColor2)) {
                    i3 = 1048576;
                    $dirty4 |= i3;
                }
            } else {
                selectedContentColor2 = selectedContentColor;
            }
            i3 = 524288;
            $dirty4 |= i3;
        } else {
            selectedContentColor2 = selectedContentColor;
        }
        if ((29360128 & i4) == 0) {
            if ((i5 & 128) == 0) {
                $dirty3 = $dirty4;
                if ($composer2.changed(unselectedContentColor)) {
                    i2 = 8388608;
                    $dirty = $dirty3 | i2;
                }
            } else {
                $dirty3 = $dirty4;
                long j = unselectedContentColor;
            }
            i2 = 4194304;
            $dirty = $dirty3 | i2;
        } else {
            long j2 = unselectedContentColor;
            $dirty = $dirty4;
        }
        int i8 = i5 & 256;
        if (i8 != 0) {
            $dirty |= 100663296;
            MutableInteractionSource mutableInteractionSource = interactionSource;
        } else if ((i4 & 234881024) == 0) {
            $dirty |= $composer2.changed((Object) interactionSource) ? 67108864 : 33554432;
        } else {
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
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
                if ((i5 & 64) != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(ContentColorKt.getLocalContentColor());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $dirty &= -3670017;
                    selectedContentColor2 = ((Color) consume).m3174unboximpl();
                }
                if ((i5 & 128) != 0) {
                    unselectedContentColor3 = selectedContentColor2;
                    $dirty &= -29360129;
                } else {
                    unselectedContentColor3 = unselectedContentColor;
                }
                if (i8 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer2;
                    long unselectedContentColor4 = unselectedContentColor3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        Object obj = it$iv$iv;
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        Object obj2 = it$iv$iv;
                        Object it$iv$iv2 = $this$cache$iv$iv;
                        value$iv$iv = obj2;
                    }
                    $composer2.endReplaceableGroup();
                    unselectedContentColor2 = unselectedContentColor4;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    enabled3 = enabled2;
                    selectedContentColor3 = selectedContentColor2;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                } else {
                    unselectedContentColor2 = unselectedContentColor3;
                    interactionSource2 = interactionSource;
                    enabled3 = enabled2;
                    selectedContentColor3 = selectedContentColor2;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i5 & 64) != 0) {
                    $dirty &= -3670017;
                }
                if ((i5 & 128) != 0) {
                    unselectedContentColor2 = unselectedContentColor;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty & -29360129;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    selectedContentColor3 = selectedContentColor2;
                } else {
                    unselectedContentColor2 = unselectedContentColor;
                    interactionSource2 = interactionSource;
                    enabled3 = enabled2;
                    selectedContentColor3 = selectedContentColor2;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-777316544, $dirty2, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:154)");
            }
            TabKt$LeadingIconTab$2 tabKt$LeadingIconTab$2 = r0;
            int $dirty5 = $dirty2;
            TabKt$LeadingIconTab$2 tabKt$LeadingIconTab$22 = new TabKt$LeadingIconTab$2(modifier3, selected, interactionSource2, RippleKt.m1729rememberRipple9IZ8Weo(true, 0.0f, selectedContentColor3, $composer2, (($dirty2 >> 12) & 896) | 6, 2), enabled3, onClick, icon, $dirty2, text);
            m2124TabTransitionKlgxPg(selectedContentColor3, unselectedContentColor2, selected, ComposableLambdaKt.composableLambda($composer2, -429037564, true, tabKt$LeadingIconTab$2), $composer2, (($dirty5 >> 18) & 14) | 3072 | (($dirty5 >> 18) & 112) | (($dirty5 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            unselectedContentColor2 = unselectedContentColor;
            interactionSource2 = interactionSource;
            enabled3 = enabled2;
            selectedContentColor3 = selectedContentColor2;
            int i9 = $dirty;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new TabKt$LeadingIconTab$3(selected, onClick, text, icon, modifier3, enabled3, selectedContentColor3, unselectedContentColor2, interactionSource2, $changed, i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:130:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0129  */
    /* renamed from: Tab-bogVsAg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2122TabbogVsAg(boolean r26, kotlin.jvm.functions.Function0<kotlin.Unit> r27, androidx.compose.ui.Modifier r28, boolean r29, long r30, long r32, androidx.compose.foundation.interaction.MutableInteractionSource r34, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r13 = r27
            r14 = r35
            r15 = r37
            r12 = r38
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -202735880(0xfffffffff3ea7ef8, float:-3.715737E31)
            r1 = r36
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Tab)P(5,4,3,1,6:c#ui.graphics.Color,7:c#ui.graphics.Color,2)230@9864L7,232@9981L39,238@10307L60,240@10373L618:Tab.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r37
            r2 = r12 & 1
            if (r2 == 0) goto L_0x002c
            r1 = r1 | 6
            r10 = r26
            goto L_0x003f
        L_0x002c:
            r2 = r15 & 14
            if (r2 != 0) goto L_0x003d
            r10 = r26
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
            r10 = r26
        L_0x003f:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0046
            r1 = r1 | 48
            goto L_0x0056
        L_0x0046:
            r2 = r15 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0056
            boolean r2 = r11.changed((java.lang.Object) r13)
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
            r3 = r28
            goto L_0x0074
        L_0x005f:
            r3 = r15 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0072
            r3 = r28
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
            r3 = r28
        L_0x0074:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x007d
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r29
            goto L_0x0092
        L_0x007d:
            r5 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0090
            r5 = r29
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
            r5 = r29
        L_0x0092:
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r15
            if (r6 != 0) goto L_0x00ad
            r6 = r12 & 16
            if (r6 != 0) goto L_0x00a7
            r6 = r30
            boolean r8 = r11.changed((long) r6)
            if (r8 == 0) goto L_0x00a9
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ab
        L_0x00a7:
            r6 = r30
        L_0x00a9:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x00ab:
            r1 = r1 | r8
            goto L_0x00af
        L_0x00ad:
            r6 = r30
        L_0x00af:
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r15
            if (r8 != 0) goto L_0x00ca
            r8 = r12 & 32
            if (r8 != 0) goto L_0x00c3
            r8 = r32
            boolean r16 = r11.changed((long) r8)
            if (r16 == 0) goto L_0x00c5
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c7
        L_0x00c3:
            r8 = r32
        L_0x00c5:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c7:
            r1 = r1 | r16
            goto L_0x00cc
        L_0x00ca:
            r8 = r32
        L_0x00cc:
            r16 = r12 & 64
            if (r16 == 0) goto L_0x00d7
            r17 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r17
            r0 = r34
            goto L_0x00ef
        L_0x00d7:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r15 & r17
            if (r17 != 0) goto L_0x00ed
            r0 = r34
            boolean r18 = r11.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00e8
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ea
        L_0x00e8:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00ea:
            r1 = r1 | r18
            goto L_0x00ef
        L_0x00ed:
            r0 = r34
        L_0x00ef:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00f7
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00f5:
            r1 = r1 | r0
            goto L_0x0108
        L_0x00f7:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r15
            if (r0 != 0) goto L_0x0108
            boolean r0 = r11.changed((java.lang.Object) r14)
            if (r0 == 0) goto L_0x0105
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f5
        L_0x0105:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00f5
        L_0x0108:
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r0 & r1
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x0129
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x0118
            goto L_0x0129
        L_0x0118:
            r11.skipToGroupEnd()
            r16 = r28
            r22 = r34
            r23 = r1
            r17 = r5
            r18 = r6
            r20 = r8
            goto L_0x0270
        L_0x0129:
            r11.startDefaults()
            r0 = r15 & 1
            r3 = -458753(0xfffffffffff8ffff, float:NaN)
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0166
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x013d
            goto L_0x0166
        L_0x013d:
            r11.skipToGroupEnd()
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0146
            r1 = r1 & r18
        L_0x0146:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0159
            r0 = r1 & r3
            r22 = r34
            r16 = r5
            r18 = r6
            r20 = r8
            r9 = r28
            r8 = r0
            goto L_0x01fa
        L_0x0159:
            r22 = r34
            r16 = r5
            r18 = r6
            r20 = r8
            r9 = r28
            r8 = r1
            goto L_0x01fa
        L_0x0166:
            if (r2 == 0) goto L_0x016d
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x016f
        L_0x016d:
            r0 = r28
        L_0x016f:
            if (r4 == 0) goto L_0x0173
            r2 = 1
            r5 = r2
        L_0x0173:
            r2 = r12 & 16
            if (r2 == 0) goto L_0x019b
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 6
            r19 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            r28 = r0
            java.lang.String r0 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r3, r0)
            java.lang.Object r0 = r11.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r2 = r0.m3174unboximpl()
            r1 = r1 & r18
            r6 = r2
            goto L_0x019d
        L_0x019b:
            r28 = r0
        L_0x019d:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x01a7
            r2 = r6
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r0
            r8 = r2
        L_0x01a7:
            if (r16 == 0) goto L_0x01ec
            r0 = 0
            r2 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
            r3 = 0
            r4 = r11
            r16 = 0
            r29 = r0
            java.lang.Object r0 = r4.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r30 = r1
            java.lang.Object r1 = r19.getEmpty()
            if (r0 != r1) goto L_0x01d6
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r4.updateRememberedValue(r1)
            goto L_0x01d7
        L_0x01d6:
            r1 = r0
        L_0x01d7:
            r11.endReplaceableGroup()
            r0 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r22 = r0
            r16 = r5
            r18 = r6
            r20 = r8
            r9 = r28
            r8 = r30
            goto L_0x01fa
        L_0x01ec:
            r30 = r1
            r22 = r34
            r16 = r5
            r18 = r6
            r20 = r8
            r9 = r28
            r8 = r30
        L_0x01fa:
            r11.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x020c
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.Tab (Tab.kt:225)"
            r2 = -202735880(0xfffffffff3ea7ef8, float:-3.715737E31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r8, r0, r1)
        L_0x020c:
            r0 = 1
            r1 = 0
            int r2 = r8 >> 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r2 = r2 | 6
            r3 = 2
            r28 = r0
            r29 = r1
            r30 = r18
            r32 = r11
            r33 = r2
            r34 = r3
            androidx.compose.foundation.Indication r17 = androidx.compose.material.ripple.RippleKt.m1729rememberRipple9IZ8Weo(r28, r29, r30, r32, r33, r34)
            androidx.compose.material3.TabKt$Tab$5 r7 = new androidx.compose.material3.TabKt$Tab$5
            r0 = r7
            r1 = r9
            r2 = r26
            r3 = r22
            r4 = r17
            r5 = r16
            r6 = r27
            r28 = r9
            r9 = r7
            r7 = r35
            r23 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = -551896140(0xffffffffdf1abbb4, float:-1.1149703E19)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r0, r1, r9)
            r6 = r0
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            int r0 = r23 >> 12
            r0 = r0 & 14
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            int r1 = r23 >> 12
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r23 << 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r8 = r0 | r1
            r1 = r18
            r3 = r20
            r5 = r26
            r7 = r11
            m2124TabTransitionKlgxPg(r1, r3, r5, r6, r7, r8)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x026c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x026c:
            r17 = r16
            r16 = r28
        L_0x0270:
            androidx.compose.runtime.ScopeUpdateScope r9 = r11.endRestartGroup()
            if (r9 != 0) goto L_0x0279
            r25 = r11
            goto L_0x029e
        L_0x0279:
            androidx.compose.material3.TabKt$Tab$6 r24 = new androidx.compose.material3.TabKt$Tab$6
            r0 = r24
            r1 = r26
            r2 = r27
            r3 = r16
            r4 = r17
            r5 = r18
            r7 = r20
            r13 = r9
            r9 = r22
            r10 = r35
            r25 = r11
            r11 = r37
            r12 = r38
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12)
            r0 = r24
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x029e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabKt.m2122TabbogVsAg(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, long, long, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x022b  */
    /* renamed from: TabTransition-Klgx-Pg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2124TabTransitionKlgxPg(long r30, long r32, boolean r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, int r37) {
        /*
            r8 = r35
            r9 = r37
            r0 = 735731848(0x2bda6088, float:1.5516624E-12)
            r1 = r36
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(TabTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)271@11422L26,272@11477L550,290@12032L99:Tab.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = r37
            r2 = r9 & 14
            r3 = 2
            if (r2 != 0) goto L_0x0026
            r5 = r30
            boolean r2 = r7.changed((long) r5)
            if (r2 == 0) goto L_0x0023
            r2 = 4
            goto L_0x0024
        L_0x0023:
            r2 = r3
        L_0x0024:
            r1 = r1 | r2
            goto L_0x0028
        L_0x0026:
            r5 = r30
        L_0x0028:
            r2 = r9 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x003b
            r14 = r32
            boolean r2 = r7.changed((long) r14)
            if (r2 == 0) goto L_0x0037
            r2 = 32
            goto L_0x0039
        L_0x0037:
            r2 = 16
        L_0x0039:
            r1 = r1 | r2
            goto L_0x003d
        L_0x003b:
            r14 = r32
        L_0x003d:
            r2 = r9 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0050
            r4 = r34
            boolean r2 = r7.changed((boolean) r4)
            if (r2 == 0) goto L_0x004c
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x004e
        L_0x004c:
            r2 = 128(0x80, float:1.794E-43)
        L_0x004e:
            r1 = r1 | r2
            goto L_0x0052
        L_0x0050:
            r4 = r34
        L_0x0052:
            r2 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0062
            boolean r2 = r7.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x005f
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0061
        L_0x005f:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0061:
            r1 = r1 | r2
        L_0x0062:
            r2 = r1 & 5851(0x16db, float:8.199E-42)
            r10 = 1170(0x492, float:1.64E-42)
            if (r2 != r10) goto L_0x0074
            boolean r2 = r7.getSkipping()
            if (r2 != 0) goto L_0x006f
            goto L_0x0074
        L_0x006f:
            r7.skipToGroupEnd()
            goto L_0x022e
        L_0x0074:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r11 = -1
            if (r2 == 0) goto L_0x0080
            java.lang.String r2 = "androidx.compose.material3.TabTransition (Tab.kt:265)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r11, r2)
        L_0x0080:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r34)
            int r2 = r1 >> 6
            r2 = r2 & 14
            r10 = 0
            androidx.compose.animation.core.Transition r0 = androidx.compose.animation.core.TransitionKt.updateTransition(r0, (java.lang.String) r10, (androidx.compose.runtime.Composer) r7, (int) r2, (int) r3)
            androidx.compose.material3.TabKt$TabTransition$color$2 r2 = androidx.compose.material3.TabKt$TabTransition$color$2.INSTANCE
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            r3 = 0
            r18 = r0
            r19 = 0
            r10 = -1462136984(0xffffffffa8d98f68, float:-2.4154032E-14)
            r7.startReplaceableGroup(r10)
            java.lang.String r10 = "C(animateColor)P(2)68@3224L31,69@3291L70,73@3374L70:Transition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r10)
            java.lang.String r20 = "ColorAnimation"
            java.lang.Object r10 = r18.getTargetState()
            int r12 = r3 >> 6
            r12 = r12 & 112(0x70, float:1.57E-43)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            r13 = r7
            r16 = 0
            r11 = -1997025499(0xffffffff88f7cf25, float:-1.4914471E-33)
            r13.startReplaceableGroup(r11)
            java.lang.String r11 = "C:Tab.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r11)
            boolean r21 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r22 = r0
            java.lang.String r0 = "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:287)"
            if (r21 == 0) goto L_0x00d0
            r4 = -1
            r5 = -1997025499(0xffffffff88f7cf25, float:-1.4914471E-33)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r12, r4, r0)
        L_0x00d0:
            if (r10 == 0) goto L_0x00d5
            r4 = r30
            goto L_0x00d6
        L_0x00d5:
            r4 = r14
        L_0x00d6:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x00df
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00df:
            r13.endReplaceableGroup()
            androidx.compose.ui.graphics.colorspace.ColorSpace r4 = androidx.compose.ui.graphics.Color.m3168getColorSpaceimpl(r4)
            r5 = 8
            r6 = r5
            r10 = 0
            r12 = -3686930(0xffffffffffc7bdee, float:NaN)
            r7.startReplaceableGroup(r12)
            java.lang.String r12 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r12)
            boolean r12 = r7.changed((java.lang.Object) r4)
            r13 = r7
            r16 = 0
            java.lang.Object r5 = r13.rememberedValue()
            r23 = 0
            if (r12 != 0) goto L_0x0112
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r25 = r6
            java.lang.Object r6 = r24.getEmpty()
            if (r5 != r6) goto L_0x010f
            goto L_0x0114
        L_0x010f:
            r26 = r5
            goto L_0x0127
        L_0x0112:
            r25 = r6
        L_0x0114:
            r6 = 0
            androidx.compose.ui.graphics.Color$Companion r24 = androidx.compose.ui.graphics.Color.Companion
            r26 = r5
            kotlin.jvm.functions.Function1 r5 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r24)
            java.lang.Object r5 = r5.invoke(r4)
            androidx.compose.animation.core.TwoWayConverter r5 = (androidx.compose.animation.core.TwoWayConverter) r5
            r13.updateRememberedValue(r5)
        L_0x0127:
            r7.endReplaceableGroup()
            androidx.compose.animation.core.TwoWayConverter r5 = (androidx.compose.animation.core.TwoWayConverter) r5
            r6 = r3 & 14
            r6 = r6 | 64
            int r10 = r3 << 3
            r10 = r10 & 896(0x380, float:1.256E-42)
            r6 = r6 | r10
            int r10 = r3 << 3
            r10 = r10 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | r10
            int r10 = r3 << 3
            r12 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r12
            r6 = r6 | r10
            r10 = r18
            r23 = 0
            r13 = 1847725064(0x6e220c08, float:1.2537779E28)
            r7.startReplaceableGroup(r13)
            java.lang.String r13 = "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r13)
            java.lang.Object r13 = r10.getCurrentState()
            int r16 = r6 >> 9
            r12 = r16 & 112(0x70, float:1.57E-43)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            r16 = r7
            r25 = 0
            r26 = r3
            r27 = r4
            r3 = r16
            r4 = -1997025499(0xffffffff88f7cf25, float:-1.4914471E-33)
            r3.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r11)
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x017d
            r9 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r12, r9, r0)
        L_0x017d:
            if (r13 == 0) goto L_0x0182
            r28 = r30
            goto L_0x0184
        L_0x0182:
            r28 = r14
        L_0x0184:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x018d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x018d:
            r3.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m3154boximpl(r28)
            java.lang.Object r4 = r10.getTargetState()
            int r9 = r6 >> 9
            r9 = r9 & 112(0x70, float:1.57E-43)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r12 = r7
            r13 = 0
            r16 = r13
            r13 = -1997025499(0xffffffff88f7cf25, float:-1.4914471E-33)
            r12.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r11)
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x01b9
            r11 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r9, r11, r0)
        L_0x01b9:
            if (r4 == 0) goto L_0x01be
            r28 = r30
            goto L_0x01c0
        L_0x01be:
            r28 = r14
        L_0x01c0:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01c9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01c9:
            r12.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r0 = androidx.compose.ui.graphics.Color.m3154boximpl(r28)
            androidx.compose.animation.core.Transition$Segment r4 = r10.getSegment()
            int r9 = r6 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.Object r4 = r2.invoke(r4, r7, r9)
            androidx.compose.animation.core.FiniteAnimationSpec r4 = (androidx.compose.animation.core.FiniteAnimationSpec) r4
            r9 = r6 & 14
            int r11 = r6 << 9
            r12 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r12
            r9 = r9 | r11
            int r11 = r6 << 6
            r12 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r12
            r17 = r9 | r11
            r11 = r3
            r12 = r0
            r13 = r4
            r14 = r5
            r15 = r20
            r16 = r7
            androidx.compose.runtime.State r9 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r10, r11, r12, r13, r14, r15, r16, r17)
            r7.endReplaceableGroup()
            r7.endReplaceableGroup()
            r0 = r9
            r2 = 1
            androidx.compose.runtime.ProvidedValue[] r2 = new androidx.compose.runtime.ProvidedValue[r2]
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            long r4 = m2125TabTransition_Klgx_Pg$lambda5(r0)
            androidx.compose.ui.graphics.Color r4 = androidx.compose.ui.graphics.Color.m3154boximpl(r4)
            androidx.compose.runtime.ProvidedValue r3 = r3.provides(r4)
            r4 = 0
            r2[r4] = r3
            int r3 = r1 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r4 = 8
            r3 = r3 | r4
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r8, (androidx.compose.runtime.Composer) r7, (int) r3)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x022e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x022e:
            androidx.compose.runtime.ScopeUpdateScope r9 = r7.endRestartGroup()
            if (r9 != 0) goto L_0x0237
            r11 = r1
            r12 = r7
            goto L_0x024e
        L_0x0237:
            androidx.compose.material3.TabKt$TabTransition$1 r10 = new androidx.compose.material3.TabKt$TabTransition$1
            r0 = r10
            r11 = r1
            r1 = r30
            r3 = r32
            r5 = r34
            r6 = r35
            r12 = r7
            r7 = r37
            r0.<init>(r1, r3, r5, r6, r7)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x024e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabKt.m2124TabTransitionKlgxPg(long, long, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    /* renamed from: TabTransition_Klgx_Pg$lambda-5  reason: not valid java name */
    private static final long m2125TabTransition_Klgx_Pg$lambda5(State<Color> $color$delegate) {
        return ((Color) $color$delegate.getValue()).m3174unboximpl();
    }

    /* access modifiers changed from: private */
    public static final void TabBaselineLayout(Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, Composer $composer, int $changed) {
        Composer $composer2;
        Function0<ComposeUiNode> function0;
        Function2<? super Composer, ? super Integer, Unit> function2 = text;
        Function2<? super Composer, ? super Integer, Unit> function22 = icon;
        int i = $changed;
        Composer $composer3 = $composer.startRestartGroup(514131524);
        ComposerKt.sourceInformation($composer3, "C(TabBaselineLayout)P(1)306@12539L2151:Tab.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer3.changed((Object) function2) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer3.changed((Object) function22) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(514131524, $dirty, -1, "androidx.compose.material3.TabBaselineLayout (Tab.kt:302)");
            }
            MeasurePolicy measurePolicy$iv = new TabKt$TabBaselineLayout$2(function2, function22);
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2907L7,75@2962L7,76@3021L7,77@3033L460:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Function0<ComposeUiNode> function02 = constructor;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function0 = function02;
                $composer3.createNode(function0);
            } else {
                function0 = function02;
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv = Updater.m2787constructorimpl($composer3);
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer3.enableReusing();
            MeasurePolicy measurePolicy = measurePolicy$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            function3.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int $changed2 = ($changed$iv$iv >> 9) & 14;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            Composer $composer4 = $composer3;
            $composer4.startReplaceableGroup(1480471867);
            ComposerKt.sourceInformation($composer4, "C316@12841L41:Tab.kt#uh7d8r");
            int i2 = $changed2;
            if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                $composer4.startReplaceableGroup(720850841);
                ComposerKt.sourceInformation($composer4, "309@12605L173");
                Function0<ComposeUiNode> function03 = function0;
                if (function2 != null) {
                    Modifier modifier = modifier$iv;
                    Density density = density$iv;
                    LayoutDirection layoutDirection = layoutDirection$iv;
                    ViewConfiguration viewConfiguration = viewConfiguration$iv;
                    Modifier modifier$iv2 = PaddingKt.m762paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "text"), HorizontalTextPadding, 0.0f, 2, (Object) null);
                    $composer4.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                    Alignment alignment = contentAlignment$iv;
                    $composer4.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume4 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Density density$iv$iv = (Density) consume4;
                    int i3 = $changed$iv$iv;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume5 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume5;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume6 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume6;
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(modifier$iv2);
                    Modifier modifier2 = modifier$iv2;
                    int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = materializerOf2;
                    $composer2 = $composer3;
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        $composer4.createNode(constructor2);
                    } else {
                        $composer4.useNode();
                    }
                    $composer4.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer4);
                    Function0<ComposeUiNode> function04 = constructor2;
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
                    $composer4.enableReusing();
                    ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = function33;
                    function34.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                    $composer4.startReplaceableGroup(2058660585);
                    int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                    Composer $composer$iv = $composer4;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function35 = function34;
                    $composer$iv.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer$iv, "C72@3384L9:Box.kt#2w3rfo");
                    int i4 = $changed$iv;
                    if (($changed$iv & 11) != 2 || !$composer$iv.getSkipping()) {
                        int $changed3 = ((6 >> 6) & 112) | 6;
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i5 = $changed$iv$iv$iv;
                        Composer $composer5 = $composer$iv;
                        $composer5.startReplaceableGroup(-947514212);
                        ComposerKt.sourceInformation($composer5, "C313@12770L6:Tab.kt#uh7d8r");
                        int i6 = $changed3;
                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                            function2.invoke($composer5, Integer.valueOf($dirty & 14));
                        } else {
                            $composer5.skipToGroupEnd();
                        }
                        $composer5.endReplaceableGroup();
                    } else {
                        $composer$iv.skipToGroupEnd();
                        int i7 = $changed$iv$iv$iv;
                    }
                    $composer$iv.endReplaceableGroup();
                    $composer4.endReplaceableGroup();
                    $composer4.endNode();
                    $composer4.endReplaceableGroup();
                    $composer4.endReplaceableGroup();
                } else {
                    $composer2 = $composer3;
                    Modifier modifier3 = modifier$iv;
                    Density density2 = density$iv;
                    LayoutDirection layoutDirection2 = layoutDirection$iv;
                    ViewConfiguration viewConfiguration3 = viewConfiguration$iv;
                    int i8 = $changed$iv$iv;
                }
                $composer4.endReplaceableGroup();
                if (function22 != null) {
                    Modifier modifier$iv3 = LayoutIdKt.layoutId(Modifier.Companion, "icon");
                    $composer4.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                    $composer4.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    Alignment alignment2 = contentAlignment$iv2;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume7 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Density density$iv$iv2 = (Density) consume7;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume8 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume8;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume9 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume9;
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv3);
                    int $changed$iv$iv$iv2 = ((((6 << 3) & 112) << 9) & 7168) | 6;
                    Modifier modifier4 = modifier$iv3;
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        $composer4.createNode(constructor3);
                    } else {
                        $composer4.useNode();
                    }
                    $composer4.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2787constructorimpl($composer4);
                    Function0<ComposeUiNode> function05 = constructor3;
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                    $composer4.enableReusing();
                    skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                    $composer4.startReplaceableGroup(2058660585);
                    int $changed$iv2 = ($changed$iv$iv$iv2 >> 9) & 14;
                    Composer $composer$iv2 = $composer4;
                    Density density3 = density$iv$iv2;
                    $composer$iv2.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer$iv2, "C72@3384L9:Box.kt#2w3rfo");
                    if (($changed$iv2 & 11) != 2 || !$composer$iv2.getSkipping()) {
                        int i9 = $changed$iv2;
                        Composer $composer6 = $composer$iv2;
                        $composer6.startReplaceableGroup(-1983967725);
                        ComposerKt.sourceInformation($composer6, "C316@12874L6:Tab.kt#uh7d8r");
                        int i10 = (((6 >> 6) & 112) | 6) & 81;
                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                        if (i10 != 16 || !$composer6.getSkipping()) {
                            function22.invoke($composer6, Integer.valueOf(($dirty >> 3) & 14));
                        } else {
                            $composer6.skipToGroupEnd();
                        }
                        $composer6.endReplaceableGroup();
                    } else {
                        $composer$iv2.skipToGroupEnd();
                        int i11 = $changed$iv2;
                    }
                    $composer$iv2.endReplaceableGroup();
                    $composer4.endReplaceableGroup();
                    $composer4.endNode();
                    $composer4.endReplaceableGroup();
                    $composer4.endReplaceableGroup();
                }
            } else {
                $composer4.skipToGroupEnd();
                $composer2 = $composer3;
                Function0<ComposeUiNode> function06 = function0;
                Modifier modifier5 = modifier$iv;
                Density density4 = density$iv;
                LayoutDirection layoutDirection3 = layoutDirection$iv;
                ViewConfiguration viewConfiguration4 = viewConfiguration$iv;
                int i12 = $changed$iv$iv;
            }
            $composer4.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i13 = $changed;
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
        Density $this$placeTextAndIcon_u24lambda_u2d9 = density;
        int textOffset = $this$placeTextAndIcon_u24lambda_u2d9.m5961roundToPx0680j_4(baselineOffset) + $this$placeTextAndIcon_u24lambda_u2d9.m5961roundToPx0680j_4(PrimaryNavigationTabTokens.INSTANCE.m2647getActiveIndicatorHeightD9Ej5fM());
        int iconOffset = (iconPlaceable.getHeight() + density.m5960roundToPxR2X_6o(IconDistanceFromBaseline)) - i;
        int textPlaceableY = (tabHeight - i2) - textOffset;
        Placeable.PlacementScope.placeRelative$default($this$placeTextAndIcon, textPlaceable, (tabWidth - textPlaceable.getWidth()) / 2, textPlaceableY, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default($this$placeTextAndIcon, iconPlaceable, (tabWidth - iconPlaceable.getWidth()) / 2, textPlaceableY - iconOffset, 0.0f, 4, (Object) null);
    }
}
