package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationConstants;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.selection.SelectableKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a[\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0014H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a=\u0010\u0017\u001a\u00020\t2\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\t0\u0019¢\u0006\u0002\b\u00132\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019¢\u0006\u0002\b\u00132\u0006\u0010\u001b\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010\u001c\u001aU\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2&\u0010\u0010\u001a\"\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0013H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u0001\u0010'\u001a\u00020\t*\u00020\u00122\u0006\u0010 \u001a\u00020!2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\u00192\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\t0\u0019¢\u0006\u0002\b\u00132\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020!2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019¢\u0006\u0002\b\u00132\b\b\u0002\u0010*\u001a\u00020!2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\r2\b\b\u0002\u0010.\u001a\u00020\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a)\u00101\u001a\u000202*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a9\u0010:\u001a\u000202*\u0002032\u0006\u0010;\u001a\u0002052\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010\u001b\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006>"}, d2 = {"BottomNavigationAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomNavigationHeight", "Landroidx/compose/ui/unit/Dp;", "F", "BottomNavigationItemHorizontalPadding", "CombinedItemTextBaseline", "BottomNavigation", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomNavigation-PEIptTM", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomNavigationItemBaselineLayout", "icon", "Lkotlin/Function0;", "label", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "BottomNavigationTransition", "activeColor", "inactiveColor", "selected", "", "Lkotlin/ParameterName;", "name", "animationProgress", "BottomNavigationTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "BottomNavigationItem", "onClick", "enabled", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "BottomNavigationItem-jY6E1Zs", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;III)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomNavigation.kt */
public final class BottomNavigationKt {
    private static final TweenSpec<Float> BottomNavigationAnimationSpec = new TweenSpec(AnimationConstants.DefaultDurationMillis, 0, EasingKt.getFastOutSlowInEasing(), 2, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final float BottomNavigationHeight = Dp.m5986constructorimpl((float) 56);
    private static final float BottomNavigationItemHorizontalPadding = Dp.m5986constructorimpl((float) 12);
    private static final float CombinedItemTextBaseline = Dp.m5986constructorimpl((float) 12);

    /* renamed from: BottomNavigation-PEIptTM  reason: not valid java name */
    public static final void m1388BottomNavigationPEIptTM(Modifier modifier, long backgroundColor, long contentColor, float elevation, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        long contentColor2;
        float f;
        float elevation2;
        long contentColor3;
        long backgroundColor2;
        Modifier modifier3;
        float elevation3;
        long backgroundColor3;
        Modifier modifier4;
        int i2;
        int i3;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
        int i4 = $changed;
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(456489494);
        ComposerKt.sourceInformation($composer2, "C(BottomNavigation)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)91@4097L6,92@4146L32,96@4289L403:BottomNavigation.kt#jmzs0o");
        int $dirty = $changed;
        int i5 = i & 1;
        if (i5 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if ((i4 & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i4 & 112) == 0) {
            if ((i & 2) == 0) {
                j = backgroundColor;
                if ($composer2.changed(j)) {
                    i3 = 32;
                    $dirty |= i3;
                }
            } else {
                j = backgroundColor;
            }
            i3 = 16;
            $dirty |= i3;
        } else {
            j = backgroundColor;
        }
        if ((i4 & 896) == 0) {
            if ((i & 4) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                contentColor2 = contentColor;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            contentColor2 = contentColor;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
            f = elevation;
        } else if ((i4 & 7168) == 0) {
            f = elevation;
            $dirty |= $composer2.changed(f) ? 2048 : 1024;
        } else {
            f = elevation;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if ((57344 & i4) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 16384 : 8192;
        }
        if ((46811 & $dirty) != 9362 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i4 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 2) != 0) {
                    backgroundColor3 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer2, 6));
                    $dirty &= -113;
                } else {
                    backgroundColor3 = j;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    contentColor2 = ColorsKt.m1463contentColorForek8zF_U(backgroundColor3, $composer2, ($dirty >> 3) & 14);
                }
                elevation3 = i6 != 0 ? BottomNavigationDefaults.INSTANCE.m1387getElevationD9Ej5fM() : f;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier4 = modifier2;
                backgroundColor3 = j;
                elevation3 = f;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(456489494, $dirty, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:89)");
            }
            SurfaceKt.m1620SurfaceFjzlyU(modifier4, (Shape) null, backgroundColor3, contentColor2, (BorderStroke) null, elevation3, ComposableLambdaKt.composableLambda($composer2, 678339930, true, new BottomNavigationKt$BottomNavigation$1(function3, $dirty)), $composer2, ($dirty & 14) | 1572864 | (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 6) & 458752), 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i7 = $dirty;
            modifier3 = modifier4;
            backgroundColor2 = backgroundColor3;
            elevation2 = elevation3;
            contentColor3 = contentColor2;
        } else {
            $composer2.skipToGroupEnd();
            int i8 = $dirty;
            backgroundColor2 = j;
            contentColor3 = contentColor2;
            elevation2 = f;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new BottomNavigationKt$BottomNavigation$2(modifier3, backgroundColor2, contentColor3, elevation2, content, $changed, i));
    }

    /* renamed from: BottomNavigationItem-jY6E1Zs  reason: not valid java name */
    public static final void m1389BottomNavigationItemjY6E1Zs(RowScope $this$BottomNavigationItem_u2djY6E1Zs, boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> icon, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> label, boolean alwaysShowLabel, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, Composer $composer, int $changed, int $changed1, int i) {
        Modifier modifier2;
        long unselectedContentColor2;
        long unselectedContentColor3;
        MutableInteractionSource interactionSource2;
        long selectedContentColor2;
        Modifier modifier3;
        boolean enabled2;
        boolean alwaysShowLabel2;
        Function2 label2;
        boolean alwaysShowLabel3;
        Function2 label3;
        int $dirty1;
        long selectedContentColor3;
        int $dirty12;
        MutableInteractionSource interactionSource3;
        boolean enabled3;
        Function2 label4;
        Function2 styledLabel;
        Modifier modifier4;
        boolean enabled4;
        boolean enabled5;
        MutableInteractionSource interactionSource4;
        MutableInteractionSource interactionSource5;
        Object value$iv$iv;
        int i2;
        int i3;
        RowScope rowScope = $this$BottomNavigationItem_u2djY6E1Zs;
        Function0<Unit> function0 = onClick;
        Function2<? super Composer, ? super Integer, Unit> function2 = icon;
        int i4 = $changed;
        int i5 = i;
        Intrinsics.checkNotNullParameter(rowScope, "$this$BottomNavigationItem");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function2, "icon");
        Composer $composer2 = $composer.startRestartGroup(-1473735525);
        ComposerKt.sourceInformation($composer2, "C(BottomNavigationItem)P(7,6,2,5,1,4!2,8:c#ui.graphics.Color,9:c#ui.graphics.Color)154@7016L39,155@7109L7,156@7201L6,167@7704L61,169@7771L804:BottomNavigation.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty13 = $changed1;
        if ((Integer.MIN_VALUE & i5) != 0) {
            $dirty |= 6;
        } else if ((i4 & 14) == 0) {
            $dirty |= $composer2.changed((Object) rowScope) ? 4 : 2;
        }
        if ((i5 & 1) != 0) {
            $dirty |= 48;
            boolean z = selected;
        } else if ((i4 & 112) == 0) {
            $dirty |= $composer2.changed(selected) ? 32 : 16;
        } else {
            boolean z2 = selected;
        }
        if ((i5 & 2) != 0) {
            $dirty |= 384;
        } else if ((i4 & 896) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        if ((i5 & 4) != 0) {
            $dirty |= 3072;
        } else if ((i4 & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int i6 = i5 & 8;
        if (i6 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if ((57344 & i4) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i7 = i5 & 16;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            boolean z3 = enabled;
        } else if ((458752 & i4) == 0) {
            $dirty |= $composer2.changed(enabled) ? 131072 : 65536;
        } else {
            boolean z4 = enabled;
        }
        int i8 = i5 & 32;
        if (i8 != 0) {
            $dirty |= 1572864;
            Function2<? super Composer, ? super Integer, Unit> function22 = label;
        } else if ((i4 & 3670016) == 0) {
            $dirty |= $composer2.changedInstance(label) ? 1048576 : 524288;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = label;
        }
        int i9 = i5 & 64;
        if (i9 != 0) {
            $dirty |= 12582912;
            boolean z5 = alwaysShowLabel;
        } else if ((i4 & 29360128) == 0) {
            $dirty |= $composer2.changed(alwaysShowLabel) ? 8388608 : 4194304;
        } else {
            boolean z6 = alwaysShowLabel;
        }
        int i10 = i5 & 128;
        if (i10 != 0) {
            $dirty |= 100663296;
            MutableInteractionSource mutableInteractionSource = interactionSource;
        } else if ((i4 & 234881024) == 0) {
            $dirty |= $composer2.changed((Object) interactionSource) ? 67108864 : 33554432;
        } else {
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
        }
        if ((i4 & 1879048192) == 0) {
            if ((i5 & 256) != 0) {
                long j = selectedContentColor;
            } else if ($composer2.changed(selectedContentColor)) {
                i3 = 536870912;
                $dirty |= i3;
            }
            i3 = 268435456;
            $dirty |= i3;
        } else {
            long j2 = selectedContentColor;
        }
        if (($changed1 & 14) == 0) {
            if ((i5 & 512) == 0) {
                unselectedContentColor2 = unselectedContentColor;
                if ($composer2.changed(unselectedContentColor2)) {
                    i2 = 4;
                    $dirty13 |= i2;
                }
            } else {
                unselectedContentColor2 = unselectedContentColor;
            }
            i2 = 2;
            $dirty13 |= i2;
        } else {
            unselectedContentColor2 = unselectedContentColor;
        }
        if ((1533916891 & $dirty) == 306783378 && ($dirty13 & 11) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            enabled2 = enabled;
            label2 = label;
            alwaysShowLabel2 = alwaysShowLabel;
            interactionSource2 = interactionSource;
            selectedContentColor2 = selectedContentColor;
            int i11 = $dirty;
            int i12 = $dirty13;
            modifier3 = modifier2;
            unselectedContentColor3 = unselectedContentColor2;
        } else {
            $composer2.startDefaults();
            if ((i4 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i7 != 0) {
                    enabled4 = true;
                } else {
                    enabled4 = enabled;
                }
                if (i8 != 0) {
                    label3 = null;
                } else {
                    label3 = label;
                }
                if (i9 != 0) {
                    alwaysShowLabel3 = true;
                } else {
                    alwaysShowLabel3 = alwaysShowLabel;
                }
                if (i10 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer2;
                    modifier3 = modifier4;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    enabled5 = enabled4;
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
                    interactionSource4 = (MutableInteractionSource) value$iv$iv;
                } else {
                    modifier3 = modifier4;
                    enabled5 = enabled4;
                    interactionSource4 = interactionSource;
                }
                if ((i5 & 256) != 0) {
                    interactionSource5 = interactionSource4;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(ContentColorKt.getLocalContentColor());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    selectedContentColor3 = ((Color) consume).m3174unboximpl();
                    $dirty &= -1879048193;
                } else {
                    interactionSource5 = interactionSource4;
                    selectedContentColor3 = selectedContentColor;
                }
                if ((i5 & 512) != 0) {
                    unselectedContentColor2 = Color.m3163copywmQWz5c$default(selectedContentColor3, ContentAlpha.INSTANCE.getMedium($composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    enabled3 = enabled5;
                    $dirty1 = $dirty13 & -15;
                    $dirty12 = $dirty;
                    interactionSource3 = interactionSource5;
                } else {
                    enabled3 = enabled5;
                    $dirty1 = $dirty13;
                    $dirty12 = $dirty;
                    interactionSource3 = interactionSource5;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i5 & 256) != 0) {
                    $dirty &= -1879048193;
                }
                if ((i5 & 512) != 0) {
                    $dirty13 &= -15;
                }
                enabled3 = enabled;
                alwaysShowLabel3 = alwaysShowLabel;
                selectedContentColor3 = selectedContentColor;
                $dirty1 = $dirty13;
                modifier3 = modifier2;
                label3 = label;
                $dirty12 = $dirty;
                interactionSource3 = interactionSource;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1473735525, $dirty12, $dirty1, "androidx.compose.material.BottomNavigationItem (BottomNavigation.kt:146)");
            }
            if (label3 != null) {
                label4 = label3;
                Function2 function24 = label3;
                styledLabel = ComposableLambdaKt.composableLambda($composer2, 1343298261, true, new BottomNavigationKt$BottomNavigationItem$styledLabel$1$1(label3, $dirty12));
            } else {
                label4 = label3;
                styledLabel = null;
            }
            Indication ripple = RippleKt.m1729rememberRipple9IZ8Weo(false, 0.0f, selectedContentColor3, $composer2, (($dirty12 >> 21) & 896) | 6, 2);
            Modifier modifier$iv = RowScope.weight$default($this$BottomNavigationItem_u2djY6E1Zs, SelectableKt.m1079selectableO2vRcR0(modifier3, selected, interactionSource3, ripple, enabled3, Role.m5306boximpl(Role.Companion.m5319getTabo7Vup1c()), onClick), 1.0f, false, 2, (Object) null);
            enabled2 = enabled3;
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            interactionSource2 = interactionSource3;
            Indication indication = ripple;
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Alignment alignment = contentAlignment$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
            unselectedContentColor3 = unselectedContentColor2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv$iv = ((((48 << 3) & 112) << 9) & 7168) | 6;
            Modifier modifier5 = modifier$iv;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer2);
            Function0<ComposeUiNode> function02 = constructor;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i13 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer2;
            Density density = density$iv$iv;
            MeasurePolicy measurePolicy = measurePolicy$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i14 = ((48 >> 6) & 112) | 6;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            Composer $composer3 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, -1277963843, "C182@8148L421:BottomNavigation.kt#jmzs0o");
            Function2 function25 = styledLabel;
            m1390BottomNavigationTransitionKlgxPg(selectedContentColor3, unselectedContentColor3, selected, ComposableLambdaKt.composableLambda($composer3, -1411872801, true, new BottomNavigationKt$BottomNavigationItem$2$1(alwaysShowLabel3, function2, styledLabel, $dirty12)), $composer3, (($dirty12 >> 27) & 14) | 3072 | (($dirty1 << 3) & 112) | (($dirty12 << 3) & 896));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            label2 = label4;
            int i15 = $dirty12;
            selectedContentColor2 = selectedContentColor3;
            int i16 = $dirty1;
            alwaysShowLabel2 = alwaysShowLabel3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new BottomNavigationKt$BottomNavigationItem$3($this$BottomNavigationItem_u2djY6E1Zs, selected, onClick, icon, modifier3, enabled2, label2, alwaysShowLabel2, interactionSource2, selectedContentColor2, unselectedContentColor3, $changed, $changed1, i));
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomNavigationTransition-Klgx-Pg  reason: not valid java name */
    public static final void m1390BottomNavigationTransitionKlgxPg(long activeColor, long inactiveColor, boolean selected, Function3<? super Float, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int $dirty;
        long j = activeColor;
        long j2 = inactiveColor;
        boolean z = selected;
        Function3<? super Float, ? super Composer, ? super Integer, Unit> function3 = content;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-985175058);
        ComposerKt.sourceInformation($composer2, "C(BottomNavigationTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)227@9693L128,234@9896L181:BottomNavigation.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 14) == 0) {
            $dirty2 |= $composer2.changed(j) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty2 |= $composer2.changed(j2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty2 |= $composer2.changed(z) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        int $dirty3 = $dirty2;
        if (($dirty3 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-985175058, $dirty3, -1, "androidx.compose.material.BottomNavigationTransition (BottomNavigation.kt:221)");
            }
            State animationProgress$delegate = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, BottomNavigationAnimationSpec, 0.0f, (Function1) null, $composer2, 48, 12);
            long color = ColorKt.m3215lerpjxsXWHM(j2, j, BottomNavigationTransition_Klgx_Pg$lambda$3(animationProgress$delegate));
            $dirty = $dirty3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(Color.m3163copywmQWz5c$default(color, 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3166getAlphaimpl(color)))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, -138092754, true, new BottomNavigationKt$BottomNavigationTransition$1(function3, $dirty, animationProgress$delegate)), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            $dirty = $dirty3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i2 = $dirty;
            return;
        }
        int i3 = $dirty;
        endRestartGroup.updateScope(new BottomNavigationKt$BottomNavigationTransition$2(activeColor, inactiveColor, selected, content, $changed));
    }

    /* access modifiers changed from: private */
    public static final float BottomNavigationTransition_Klgx_Pg$lambda$3(State<Float> $animationProgress$delegate) {
        return ((Number) $animationProgress$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final void BottomNavigationItemBaselineLayout(Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> label, float iconPositionAnimationProgress, Composer $composer, int $changed) {
        Function2<? super Composer, ? super Integer, Unit> function2 = icon;
        Function2<? super Composer, ? super Integer, Unit> function22 = label;
        float f = iconPositionAnimationProgress;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-1162995092);
        ComposerKt.sourceInformation($composer2, "C(BottomNavigationItemBaselineLayout)P(!1,2)259@10750L1203:BottomNavigation.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changed(f) ? 256 : 128;
        }
        if (($dirty & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1162995092, $dirty, -1, "androidx.compose.material.BottomNavigationItemBaselineLayout (BottomNavigation.kt:253)");
            }
            MeasurePolicy measurePolicy$iv = new BottomNavigationKt$BottomNavigationItemBaselineLayout$2(function22, f);
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
            int i2 = $changed$iv$iv;
            Composer $composer3 = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer3, 619997302, "C261@10780L41:BottomNavigation.kt#jmzs0o");
            Modifier modifier$iv2 = LayoutIdKt.layoutId(Modifier.Companion, "icon");
            ViewConfiguration viewConfiguration = viewConfiguration$iv;
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            int i3 = ($changed$iv$iv >> 9) & 14;
            Modifier modifier = modifier$iv;
            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            Alignment alignment = contentAlignment$iv;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Density density = density$iv;
            LayoutDirection layoutDirection = layoutDirection$iv;
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
            String str = "C:CompositionLocal.kt#9igjgp";
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
            int i4 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer3;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function35 = function34;
            int i5 = $changed$iv$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            int i6 = ((6 >> 6) & 112) | 6;
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            Density density2 = density$iv$iv;
            Composer $composer4 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer4, -1517374536, "C261@10813L6:BottomNavigation.kt#jmzs0o");
            function2.invoke($composer4, Integer.valueOf($dirty & 14));
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            $composer2.startReplaceableGroup(-1198312437);
            ComposerKt.sourceInformation($composer2, "263@10871L253");
            if (function22 != null) {
                Modifier modifier$iv3 = PaddingKt.m762paddingVpY3zN4$default(AlphaKt.alpha(LayoutIdKt.layoutId(Modifier.Companion, "label"), f), BottomNavigationItemHorizontalPadding, 0.0f, 2, (Object) null);
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv2 = (0 << 3) & 112;
                Alignment alignment2 = contentAlignment$iv2;
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
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
                Modifier modifier3 = modifier$iv3;
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                int i7 = $changed$iv$iv2;
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
                Function0<ComposeUiNode> function03 = constructor3;
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer3.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i8 = ($changed$iv$iv$iv2 >> 9) & 14;
                Composer $composer$iv2 = $composer3;
                int i9 = $changed$iv$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i10 = ((0 >> 6) & 112) | 6;
                Density density3 = density$iv$iv2;
                Composer $composer5 = $composer$iv2;
                ComposerKt.sourceInformationMarkerStart($composer5, -1517374234, "C268@11115L7:BottomNavigation.kt#jmzs0o");
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
            int i11 = $changed;
        } else {
            endRestartGroup.updateScope(new BottomNavigationKt$BottomNavigationItemBaselineLayout$3(function2, function22, f, $changed));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: placeIcon-3p2s80s  reason: not valid java name */
    public static final MeasureResult m1394placeIcon3p2s80s(MeasureScope $this$placeIcon_u2d3p2s80s, Placeable iconPlaceable, long constraints) {
        int height = Constraints.m5929getMaxHeightimpl(constraints);
        return MeasureScope.layout$default($this$placeIcon_u2d3p2s80s, iconPlaceable.getWidth(), height, (Map) null, new BottomNavigationKt$placeIcon$1(iconPlaceable, (height - iconPlaceable.getHeight()) / 2), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-DIyivk0  reason: not valid java name */
    public static final MeasureResult m1395placeLabelAndIconDIyivk0(MeasureScope $this$placeLabelAndIcon_u2dDIyivk0, Placeable labelPlaceable, Placeable iconPlaceable, long constraints, float iconPositionAnimationProgress) {
        int height = Constraints.m5929getMaxHeightimpl(constraints);
        int baseline = labelPlaceable.get(AlignmentLineKt.getLastBaseline());
        int baselineOffset = $this$placeLabelAndIcon_u2dDIyivk0.m5961roundToPx0680j_4(CombinedItemTextBaseline);
        int labelY = (height - baseline) - baselineOffset;
        int unselectedIconY = (height - iconPlaceable.getHeight()) / 2;
        int selectedIconY = (height - (baselineOffset * 2)) - iconPlaceable.getHeight();
        int containerWidth = Math.max(labelPlaceable.getWidth(), iconPlaceable.getWidth());
        int iconDistance = unselectedIconY - selectedIconY;
        int i = iconDistance;
        return MeasureScope.layout$default($this$placeLabelAndIcon_u2dDIyivk0, containerWidth, height, (Map) null, new BottomNavigationKt$placeLabelAndIcon$1(iconPositionAnimationProgress, labelPlaceable, (containerWidth - labelPlaceable.getWidth()) / 2, labelY, MathKt.roundToInt(((float) iconDistance) * (((float) 1) - iconPositionAnimationProgress)), iconPlaceable, (containerWidth - iconPlaceable.getWidth()) / 2, selectedIconY), 4, (Object) null);
    }
}
