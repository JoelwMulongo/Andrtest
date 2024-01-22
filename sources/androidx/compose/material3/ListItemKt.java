package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.core.app.FrameMetricsAggregator;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a¬\u0001\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u0001H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"2\u001c\u0010#\u001a\u0018\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000b0$¢\u0006\u0002\b\u000e¢\u0006\u0002\b&H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a8\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,2\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000eH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001aN\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000b0$¢\u0006\u0002\b\u000e¢\u0006\u0002\b&2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001aN\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000b0$¢\u0006\u0002\b\u000e¢\u0006\u0002\b&2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00102\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"ContentEndPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LeadingContentEndPadding", "ListItemHorizontalPadding", "ListItemThreeLineVerticalPadding", "ListItemVerticalPadding", "ThreeLineListItemContainerHeight", "TrailingHorizontalPadding", "TwoLineListItemContainerHeight", "ListItem", "", "headlineText", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "overlineText", "supportingText", "leadingContent", "trailingContent", "colors", "Landroidx/compose/material3/ListItemColors;", "tonalElevation", "shadowElevation", "ListItem-HXNGIdc", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ListItemColors;FFLandroidx/compose/runtime/Composer;II)V", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "minHeight", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "ListItem-xOgov6c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFFFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ProvideTextStyleFromToken", "color", "textToken", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "ProvideTextStyleFromToken-3J-VO9M", "(JLandroidx/compose/material3/tokens/TypographyKeyTokens;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "topAlign", "", "leadingContent-iJQMabo", "(Lkotlin/jvm/functions/Function2;JZLandroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function3;", "trailingContent-iJQMabo", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ListItem.kt */
public final class ListItemKt {
    /* access modifiers changed from: private */
    public static final float ContentEndPadding = Dp.m5986constructorimpl((float) 8);
    /* access modifiers changed from: private */
    public static final float LeadingContentEndPadding = Dp.m5986constructorimpl((float) 16);
    private static final float ListItemHorizontalPadding = Dp.m5986constructorimpl((float) 16);
    private static final float ListItemThreeLineVerticalPadding = Dp.m5986constructorimpl((float) 16);
    private static final float ListItemVerticalPadding = Dp.m5986constructorimpl((float) 8);
    private static final float ThreeLineListItemContainerHeight = Dp.m5986constructorimpl((float) 88);
    /* access modifiers changed from: private */
    public static final float TrailingHorizontalPadding = Dp.m5986constructorimpl((float) 8);
    private static final float TwoLineListItemContainerHeight = Dp.m5986constructorimpl((float) 72);

    @ExperimentalMaterial3Api
    /* renamed from: ListItem-HXNGIdc  reason: not valid java name */
    public static final void m1971ListItemHXNGIdc(Function2<? super Composer, ? super Integer, Unit> headlineText, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> overlineText, Function2<? super Composer, ? super Integer, Unit> supportingText, Function2<? super Composer, ? super Integer, Unit> leadingContent, Function2<? super Composer, ? super Integer, Unit> trailingContent, ListItemColors colors, float tonalElevation, float shadowElevation, Composer $composer, int $changed, int i) {
        Function2 function2;
        Function2 function22;
        float shadowElevation2;
        float tonalElevation2;
        ListItemColors colors2;
        Function2 trailingContent2;
        Function2 leadingContent2;
        Function2 supportingText2;
        Function2 overlineText2;
        Modifier modifier2;
        ListItemColors colors3;
        Function2 trailingContent3;
        Function2 leadingContent3;
        Function2 supportingText3;
        Function2 overlineText3;
        float shadowElevation3;
        Modifier modifier3;
        float tonalElevation3;
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function23 = headlineText;
        int i3 = $changed;
        int i4 = i;
        Intrinsics.checkNotNullParameter(function23, "headlineText");
        Composer $composer2 = $composer.startRestartGroup(-1647707763);
        ComposerKt.sourceInformation($composer2, "C(ListItem)P(1,3,4,6,2,8!1,7:c#ui.unit.Dp,5:c#ui.unit.Dp)78@3522L8:ListItem.kt#uh7d8r");
        int $dirty = $changed;
        if ((i4 & 1) != 0) {
            $dirty |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer2.changed((Object) function23) ? 4 : 2;
        }
        int i5 = i4 & 2;
        if (i5 != 0) {
            $dirty |= 48;
            Modifier modifier4 = modifier;
        } else if ((i3 & 112) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier5 = modifier;
        }
        int i6 = i4 & 4;
        if (i6 != 0) {
            $dirty |= 384;
            Function2<? super Composer, ? super Integer, Unit> function24 = overlineText;
        } else if ((i3 & 896) == 0) {
            $dirty |= $composer2.changed((Object) overlineText) ? 256 : 128;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function25 = overlineText;
        }
        int i7 = i4 & 8;
        if (i7 != 0) {
            $dirty |= 3072;
            Function2<? super Composer, ? super Integer, Unit> function26 = supportingText;
        } else if ((i3 & 7168) == 0) {
            $dirty |= $composer2.changed((Object) supportingText) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function27 = supportingText;
        }
        int i8 = i4 & 16;
        if (i8 != 0) {
            $dirty |= 24576;
            function2 = leadingContent;
        } else if ((i3 & 57344) == 0) {
            function2 = leadingContent;
            $dirty |= $composer2.changed((Object) function2) ? 16384 : 8192;
        } else {
            function2 = leadingContent;
        }
        int i9 = i4 & 32;
        if (i9 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function22 = trailingContent;
        } else if ((i3 & 458752) == 0) {
            function22 = trailingContent;
            $dirty |= $composer2.changed((Object) function22) ? 131072 : 65536;
        } else {
            function22 = trailingContent;
        }
        if ((i3 & 3670016) == 0) {
            if ((i4 & 64) != 0) {
                ListItemColors listItemColors = colors;
            } else if ($composer2.changed((Object) colors)) {
                i2 = 1048576;
                $dirty |= i2;
            }
            i2 = 524288;
            $dirty |= i2;
        } else {
            ListItemColors listItemColors2 = colors;
        }
        int i10 = i4 & 128;
        if (i10 != 0) {
            $dirty |= 12582912;
            float f = tonalElevation;
        } else if ((i3 & 29360128) == 0) {
            $dirty |= $composer2.changed(tonalElevation) ? 8388608 : 4194304;
        } else {
            float f2 = tonalElevation;
        }
        int i11 = i4 & 256;
        if (i11 != 0) {
            $dirty |= 100663296;
            float f3 = shadowElevation;
        } else if ((i3 & 234881024) == 0) {
            $dirty |= $composer2.changed(shadowElevation) ? 67108864 : 33554432;
        } else {
            float f4 = shadowElevation;
        }
        if (($dirty & 191739611) != 38347922 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i3 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i6 != 0) {
                    overlineText3 = null;
                } else {
                    overlineText3 = overlineText;
                }
                if (i7 != 0) {
                    supportingText3 = null;
                } else {
                    supportingText3 = supportingText;
                }
                if (i8 != 0) {
                    leadingContent3 = null;
                } else {
                    leadingContent3 = function2;
                }
                if (i9 != 0) {
                    trailingContent3 = null;
                } else {
                    trailingContent3 = function22;
                }
                if ((i4 & 64) != 0) {
                    colors3 = ListItemDefaults.INSTANCE.m1969colorsJ08w3E(0, 0, 0, 0, 0, 0, 0, 0, 0, $composer2, 805306368, FrameMetricsAggregator.EVERY_DURATION);
                    $dirty &= -3670017;
                } else {
                    colors3 = colors;
                }
                if (i10 != 0) {
                    tonalElevation3 = ListItemDefaults.INSTANCE.m1970getElevationD9Ej5fM();
                } else {
                    tonalElevation3 = tonalElevation;
                }
                shadowElevation3 = i11 != 0 ? ListItemDefaults.INSTANCE.m1970getElevationD9Ej5fM() : shadowElevation;
            } else {
                $composer2.skipToGroupEnd();
                if ((i4 & 64) != 0) {
                    modifier3 = modifier;
                    overlineText3 = overlineText;
                    supportingText3 = supportingText;
                    shadowElevation3 = shadowElevation;
                    $dirty &= -3670017;
                    trailingContent3 = function22;
                    leadingContent3 = function2;
                    colors3 = colors;
                    tonalElevation3 = tonalElevation;
                } else {
                    modifier3 = modifier;
                    overlineText3 = overlineText;
                    supportingText3 = supportingText;
                    tonalElevation3 = tonalElevation;
                    shadowElevation3 = shadowElevation;
                    trailingContent3 = function22;
                    leadingContent3 = function2;
                    colors3 = colors;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1647707763, $dirty, -1, "androidx.compose.material3.ListItem (ListItem.kt:71)");
            }
            if (overlineText3 == null && supportingText3 == null) {
                $composer2.startReplaceableGroup(-85614273);
                ComposerKt.sourceInformation($composer2, "86@3818L16,87@3876L29,84@3739L1377");
                m1972ListItemxOgov6c(modifier3, (Shape) null, colors3.containerColor$material3_release($composer2, ($dirty >> 18) & 14).getValue().m3174unboximpl(), colors3.headlineColor$material3_release(true, $composer2, (($dirty >> 15) & 112) | 6).getValue().m3174unboximpl(), tonalElevation3, shadowElevation3, ListTokens.INSTANCE.m2504getListItemContainerHeightD9Ej5fM(), PaddingKt.m754PaddingValuesYgX7TsA(ListItemHorizontalPadding, ListItemVerticalPadding), ComposableLambdaKt.composableLambda($composer2, 967218806, true, new ListItemKt$ListItem$1(leadingContent3, colors3, $dirty, trailingContent3, headlineText)), $composer2, (($dirty >> 3) & 14) | 114819072 | (($dirty >> 9) & 57344) | (($dirty >> 9) & 458752), 2);
                $composer2.endReplaceableGroup();
            } else if (overlineText3 == null) {
                $composer2.startReplaceableGroup(-85612818);
                ComposerKt.sourceInformation($composer2, "123@5273L16,124@5331L29,121@5194L1665");
                m1972ListItemxOgov6c(modifier3, (Shape) null, colors3.containerColor$material3_release($composer2, ($dirty >> 18) & 14).getValue().m3174unboximpl(), colors3.headlineColor$material3_release(true, $composer2, (($dirty >> 15) & 112) | 6).getValue().m3174unboximpl(), tonalElevation3, shadowElevation3, TwoLineListItemContainerHeight, PaddingKt.m754PaddingValuesYgX7TsA(ListItemHorizontalPadding, ListItemVerticalPadding), ComposableLambdaKt.composableLambda($composer2, 48069791, true, new ListItemKt$ListItem$2(leadingContent3, colors3, $dirty, trailingContent3, headlineText, supportingText3)), $composer2, (($dirty >> 3) & 14) | 114819072 | (($dirty >> 9) & 57344) | (($dirty >> 9) & 458752), 2);
                $composer2.endReplaceableGroup();
            } else if (supportingText3 == null) {
                $composer2.startReplaceableGroup(-85611073);
                ComposerKt.sourceInformation($composer2, "167@7018L16,168@7076L29,165@6939L1653");
                m1972ListItemxOgov6c(modifier3, (Shape) null, colors3.containerColor$material3_release($composer2, ($dirty >> 18) & 14).getValue().m3174unboximpl(), colors3.headlineColor$material3_release(true, $composer2, (($dirty >> 15) & 112) | 6).getValue().m3174unboximpl(), tonalElevation3, shadowElevation3, TwoLineListItemContainerHeight, PaddingKt.m754PaddingValuesYgX7TsA(ListItemHorizontalPadding, ListItemVerticalPadding), ComposableLambdaKt.composableLambda($composer2, 1733969726, true, new ListItemKt$ListItem$3(leadingContent3, colors3, $dirty, trailingContent3, overlineText3, headlineText)), $composer2, (($dirty >> 3) & 14) | 114819072 | (($dirty >> 9) & 57344) | (($dirty >> 9) & 458752), 2);
                $composer2.endReplaceableGroup();
            } else {
                $composer2.startReplaceableGroup(-85609368);
                ComposerKt.sourceInformation($composer2, "211@8725L16,212@8783L29,209@8646L1935");
                m1972ListItemxOgov6c(modifier3, (Shape) null, colors3.containerColor$material3_release($composer2, ($dirty >> 18) & 14).getValue().m3174unboximpl(), colors3.headlineColor$material3_release(true, $composer2, (($dirty >> 15) & 112) | 6).getValue().m3174unboximpl(), tonalElevation3, shadowElevation3, ThreeLineListItemContainerHeight, PaddingKt.m754PaddingValuesYgX7TsA(ListItemHorizontalPadding, ListItemThreeLineVerticalPadding), ComposableLambdaKt.composableLambda($composer2, -1269203265, true, new ListItemKt$ListItem$4(leadingContent3, colors3, $dirty, trailingContent3, overlineText3, headlineText, supportingText3)), $composer2, (($dirty >> 3) & 14) | 114819072 | (($dirty >> 9) & 57344) | (($dirty >> 9) & 458752), 2);
                $composer2.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            tonalElevation2 = tonalElevation3;
            int i12 = $dirty;
            modifier2 = modifier3;
            shadowElevation2 = shadowElevation3;
            overlineText2 = overlineText3;
            supportingText2 = supportingText3;
            leadingContent2 = leadingContent3;
            trailingContent2 = trailingContent3;
            colors2 = colors3;
        } else {
            $composer2.skipToGroupEnd();
            overlineText2 = overlineText;
            supportingText2 = supportingText;
            colors2 = colors;
            tonalElevation2 = tonalElevation;
            shadowElevation2 = shadowElevation;
            int i13 = $dirty;
            trailingContent2 = function22;
            leadingContent2 = function2;
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new ListItemKt$ListItem$5(headlineText, modifier2, overlineText2, supportingText2, leadingContent2, trailingContent2, colors2, tonalElevation2, shadowElevation2, $changed, i));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0109  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* renamed from: ListItem-xOgov6c  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1972ListItemxOgov6c(androidx.compose.ui.Modifier r29, androidx.compose.ui.graphics.Shape r30, long r31, long r33, float r35, float r36, float r37, androidx.compose.foundation.layout.PaddingValues r38, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r14 = r37
            r15 = r38
            r13 = r39
            r12 = r41
            r11 = r42
            r0 = 1069030861(0x3fb81dcd, float:1.4384094)
            r1 = r40
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ListItem)P(4,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.unit.Dp,6:c#ui.unit.Dp,3:c#ui.unit.Dp,5)282@11449L5,283@11501L14,284@11560L12,291@11788L388:ListItem.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r41
            r2 = r11 & 1
            if (r2 == 0) goto L_0x0023
            r1 = r1 | 6
            r3 = r29
            goto L_0x0036
        L_0x0023:
            r3 = r12 & 14
            if (r3 != 0) goto L_0x0034
            r3 = r29
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0031
            r4 = 4
            goto L_0x0032
        L_0x0031:
            r4 = 2
        L_0x0032:
            r1 = r1 | r4
            goto L_0x0036
        L_0x0034:
            r3 = r29
        L_0x0036:
            r4 = r12 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004f
            r4 = r11 & 2
            if (r4 != 0) goto L_0x0049
            r4 = r30
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004b
            r5 = 32
            goto L_0x004d
        L_0x0049:
            r4 = r30
        L_0x004b:
            r5 = 16
        L_0x004d:
            r1 = r1 | r5
            goto L_0x0051
        L_0x004f:
            r4 = r30
        L_0x0051:
            r5 = r12 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x006a
            r5 = r11 & 4
            if (r5 != 0) goto L_0x0064
            r5 = r31
            boolean r7 = r10.changed((long) r5)
            if (r7 == 0) goto L_0x0066
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0064:
            r5 = r31
        L_0x0066:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r1 = r1 | r7
            goto L_0x006c
        L_0x006a:
            r5 = r31
        L_0x006c:
            r7 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0085
            r7 = r11 & 8
            if (r7 != 0) goto L_0x007f
            r7 = r33
            boolean r9 = r10.changed((long) r7)
            if (r9 == 0) goto L_0x0081
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x007f:
            r7 = r33
        L_0x0081:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r1 = r1 | r9
            goto L_0x0087
        L_0x0085:
            r7 = r33
        L_0x0087:
            r9 = r11 & 16
            r16 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x0093
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r0 = r35
            goto L_0x00a9
        L_0x0093:
            r17 = r12 & r16
            if (r17 != 0) goto L_0x00a7
            r0 = r35
            boolean r18 = r10.changed((float) r0)
            if (r18 == 0) goto L_0x00a2
            r18 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a2:
            r18 = 8192(0x2000, float:1.14794E-41)
        L_0x00a4:
            r1 = r1 | r18
            goto L_0x00a9
        L_0x00a7:
            r0 = r35
        L_0x00a9:
            r18 = r11 & 32
            r19 = 458752(0x70000, float:6.42848E-40)
            if (r18 == 0) goto L_0x00b6
            r20 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r20
            r0 = r36
            goto L_0x00cc
        L_0x00b6:
            r20 = r12 & r19
            if (r20 != 0) goto L_0x00ca
            r0 = r36
            boolean r20 = r10.changed((float) r0)
            if (r20 == 0) goto L_0x00c5
            r20 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c7
        L_0x00c5:
            r20 = 65536(0x10000, float:9.18355E-41)
        L_0x00c7:
            r1 = r1 | r20
            goto L_0x00cc
        L_0x00ca:
            r0 = r36
        L_0x00cc:
            r20 = r11 & 64
            if (r20 == 0) goto L_0x00d5
            r20 = 1572864(0x180000, float:2.204052E-39)
        L_0x00d2:
            r1 = r1 | r20
            goto L_0x00e7
        L_0x00d5:
            r20 = 3670016(0x380000, float:5.142788E-39)
            r20 = r12 & r20
            if (r20 != 0) goto L_0x00e7
            boolean r20 = r10.changed((float) r14)
            if (r20 == 0) goto L_0x00e4
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d2
        L_0x00e4:
            r20 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00d2
        L_0x00e7:
            r0 = r11 & 128(0x80, float:1.794E-43)
            r20 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00f0
            r1 = r1 | r20
            goto L_0x0101
        L_0x00f0:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r12
            if (r0 != 0) goto L_0x0101
            boolean r0 = r10.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x00fe
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0100
        L_0x00fe:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x0100:
            r1 = r1 | r0
        L_0x0101:
            r0 = r11 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0109
            r0 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x0107:
            r1 = r1 | r0
            goto L_0x011a
        L_0x0109:
            r0 = 234881024(0xe000000, float:1.5777218E-30)
            r0 = r0 & r12
            if (r0 != 0) goto L_0x011a
            boolean r0 = r10.changed((java.lang.Object) r13)
            if (r0 == 0) goto L_0x0117
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0107
        L_0x0117:
            r0 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x0107
        L_0x011a:
            r0 = 191739611(0xb6db6db, float:4.5782105E-32)
            r0 = r0 & r1
            r3 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r3) goto L_0x013d
            boolean r0 = r10.getSkipping()
            if (r0 != 0) goto L_0x012a
            goto L_0x013d
        L_0x012a:
            r10.skipToGroupEnd()
            r16 = r29
            r22 = r35
            r23 = r36
            r24 = r1
            r17 = r4
            r18 = r5
            r20 = r7
            goto L_0x0227
        L_0x013d:
            r10.startDefaults()
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0175
            boolean r0 = r10.getDefaultsInvalid()
            if (r0 == 0) goto L_0x014b
            goto L_0x0175
        L_0x014b:
            r10.skipToGroupEnd()
            r0 = r11 & 2
            if (r0 == 0) goto L_0x0154
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0154:
            r0 = r11 & 4
            if (r0 == 0) goto L_0x015a
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x015a:
            r0 = r11 & 8
            if (r0 == 0) goto L_0x016b
            r0 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r3 = r35
            r1 = r0
            r2 = r4
            r4 = r5
            r6 = r7
            r0 = r29
            r8 = r36
            goto L_0x01bf
        L_0x016b:
            r0 = r29
            r3 = r35
            r2 = r4
            r4 = r5
            r6 = r7
            r8 = r36
            goto L_0x01bf
        L_0x0175:
            if (r2 == 0) goto L_0x017c
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x017e
        L_0x017c:
            r0 = r29
        L_0x017e:
            r2 = r11 & 2
            r3 = 6
            if (r2 == 0) goto L_0x018c
            androidx.compose.material3.ListItemDefaults r2 = androidx.compose.material3.ListItemDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getShape(r10, r3)
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x018d
        L_0x018c:
            r2 = r4
        L_0x018d:
            r4 = r11 & 4
            if (r4 == 0) goto L_0x019a
            androidx.compose.material3.ListItemDefaults r4 = androidx.compose.material3.ListItemDefaults.INSTANCE
            long r4 = r4.getContainerColor(r10, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x019b
        L_0x019a:
            r4 = r5
        L_0x019b:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x01a8
            androidx.compose.material3.ListItemDefaults r6 = androidx.compose.material3.ListItemDefaults.INSTANCE
            long r6 = r6.getContentColor(r10, r3)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x01a9
        L_0x01a8:
            r6 = r7
        L_0x01a9:
            if (r9 == 0) goto L_0x01b2
            androidx.compose.material3.ListItemDefaults r3 = androidx.compose.material3.ListItemDefaults.INSTANCE
            float r3 = r3.m1970getElevationD9Ej5fM()
            goto L_0x01b4
        L_0x01b2:
            r3 = r35
        L_0x01b4:
            if (r18 == 0) goto L_0x01bd
            androidx.compose.material3.ListItemDefaults r8 = androidx.compose.material3.ListItemDefaults.INSTANCE
            float r8 = r8.m1970getElevationD9Ej5fM()
            goto L_0x01bf
        L_0x01bd:
            r8 = r36
        L_0x01bf:
            r10.endDefaults()
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x01d1
            r9 = -1
            java.lang.String r11 = "androidx.compose.material3.ListItem (ListItem.kt:280)"
            r12 = 1069030861(0x3fb81dcd, float:1.4384094)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r1, r9, r11)
        L_0x01d1:
            r24 = 0
            androidx.compose.material3.ListItemKt$ListItem$6 r9 = new androidx.compose.material3.ListItemKt$ListItem$6
            r9.<init>(r14, r15, r13, r1)
            r11 = 1393735016(0x5312b568, float:6.3010872E11)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r11, r12, r9)
            r25 = r9
            kotlin.jvm.functions.Function2 r25 = (kotlin.jvm.functions.Function2) r25
            r9 = r1 & 14
            r9 = r9 | r20
            r11 = r1 & 112(0x70, float:1.57E-43)
            r9 = r9 | r11
            r11 = r1 & 896(0x380, float:1.256E-42)
            r9 = r9 | r11
            r11 = r1 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | r11
            r11 = r1 & r16
            r9 = r9 | r11
            r11 = r1 & r19
            r27 = r9 | r11
            r28 = 64
            r16 = r0
            r17 = r2
            r18 = r4
            r20 = r6
            r22 = r3
            r23 = r8
            r26 = r10
            androidx.compose.material3.SurfaceKt.m2097SurfaceT9BRK9s(r16, r17, r18, r20, r22, r23, r24, r25, r26, r27, r28)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0219
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0219:
            r16 = r0
            r24 = r1
            r17 = r2
            r22 = r3
            r18 = r4
            r20 = r6
            r23 = r8
        L_0x0227:
            androidx.compose.runtime.ScopeUpdateScope r12 = r10.endRestartGroup()
            if (r12 != 0) goto L_0x0230
            r26 = r10
            goto L_0x0257
        L_0x0230:
            androidx.compose.material3.ListItemKt$ListItem$7 r25 = new androidx.compose.material3.ListItemKt$ListItem$7
            r0 = r25
            r1 = r16
            r2 = r17
            r3 = r18
            r5 = r20
            r7 = r22
            r8 = r23
            r9 = r37
            r26 = r10
            r10 = r38
            r11 = r39
            r14 = r12
            r12 = r41
            r13 = r42
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13)
            r0 = r25
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x0257:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ListItemKt.m1972ListItemxOgov6c(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, float, float, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: leadingContent-iJQMabo  reason: not valid java name */
    public static final Function3<RowScope, Composer, Integer, Unit> m1978leadingContentiJQMabo(Function2<? super Composer, ? super Integer, Unit> leadingContent, long contentColor, boolean topAlign, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(292744125);
        ComposerKt.sourceInformation($composer, "C(leadingContent)P(1,0:c#ui.graphics.Color):ListItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(292744125, $changed, -1, "androidx.compose.material3.leadingContent (ListItem.kt:309)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda($composer, -1755598478, true, new ListItemKt$leadingContent$1(contentColor, topAlign, leadingContent, $changed));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return composableLambda;
    }

    /* access modifiers changed from: private */
    /* renamed from: trailingContent-iJQMabo  reason: not valid java name */
    public static final Function3<RowScope, Composer, Integer, Unit> m1979trailingContentiJQMabo(Function2<? super Composer, ? super Integer, Unit> trailingContent, long contentColor, boolean topAlign, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(2067138571);
        ComposerKt.sourceInformation($composer, "C(trailingContent)P(2,0:c#ui.graphics.Color):ListItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2067138571, $changed, -1, "androidx.compose.material3.trailingContent (ListItem.kt:334)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda($composer, -1301939978, true, new ListItemKt$trailingContent$1(topAlign, contentColor, trailingContent, $changed));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return composableLambda;
    }

    /* access modifiers changed from: private */
    /* renamed from: ProvideTextStyleFromToken-3J-VO9M  reason: not valid java name */
    public static final void m1973ProvideTextStyleFromToken3JVO9M(long color, TypographyKeyTokens textToken, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1133967795);
        ComposerKt.sourceInformation($composer2, "C(ProvideTextStyleFromToken)P(0:c#ui.graphics.Color,2)494@19374L10,495@19410L111:ListItem.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(color) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed((Object) textToken) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed((Object) content) ? 256 : 128;
        }
        if (($dirty & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1133967795, $dirty, -1, "androidx.compose.material3.ProvideTextStyleFromToken (ListItem.kt:489)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(color))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, -514310925, true, new ListItemKt$ProvideTextStyleFromToken$1(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), textToken), content, $dirty)), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ListItemKt$ProvideTextStyleFromToken$2(color, textToken, content, $changed));
        }
    }
}
