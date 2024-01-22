package androidx.compose.material;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0001\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u0013\u001a:\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a?\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0013\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\tH\u0002¢\u0006\u0002\u0010\u001d\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"BaselinesOffsetColumn", "", "offsets", "", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ListItem", "icon", "secondaryText", "singleLineSecondaryText", "", "overlineText", "trailing", "text", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OffsetToBaselineOrCenter", "offset", "OffsetToBaselineOrCenter-Kz89ssw", "(FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "applyTextStyle", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "(Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
public final class ListItemKt {
    public static final void ListItem(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> secondaryText, boolean singleLineSecondaryText, Function2<? super Composer, ? super Integer, Unit> overlineText, Function2<? super Composer, ? super Integer, Unit> trailing, Function2<? super Composer, ? super Integer, Unit> text, Composer $composer, int $changed, int i) {
        Function2 function2;
        Function2 secondaryText2;
        boolean z;
        Function2 overlineText2;
        Function2 secondaryText3;
        boolean singleLineSecondaryText2;
        Function2 icon2;
        Function2 trailing2;
        Modifier modifier2;
        Modifier modifier3;
        Function2 trailing3;
        Function2 overlineText3;
        Function2 trailing4;
        Function2<? super Composer, ? super Integer, Unit> function22 = text;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function22, "text");
        Composer $composer2 = $composer.startRestartGroup(-450923337);
        ComposerKt.sourceInformation($composer2, "C(ListItem)P(1!1,3,4!1,6)81@3397L10,83@3480L4,84@3570L6,85@3671L4,86@3764L4:ListItem.kt#jmzs0o");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            Modifier modifier4 = modifier;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 4 : 2;
        } else {
            Modifier modifier5 = modifier;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            function2 = icon;
        } else if ((i2 & 112) == 0) {
            function2 = icon;
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        } else {
            function2 = icon;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            secondaryText2 = secondaryText;
        } else if ((i2 & 896) == 0) {
            secondaryText2 = secondaryText;
            $dirty |= $composer2.changedInstance(secondaryText2) ? 256 : 128;
        } else {
            secondaryText2 = secondaryText;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
            z = singleLineSecondaryText;
        } else if ((i2 & 7168) == 0) {
            z = singleLineSecondaryText;
            $dirty |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = singleLineSecondaryText;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
            overlineText2 = overlineText;
        } else if ((57344 & i2) == 0) {
            overlineText2 = overlineText;
            $dirty |= $composer2.changedInstance(overlineText2) ? 16384 : 8192;
        } else {
            overlineText2 = overlineText;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            Function2<? super Composer, ? super Integer, Unit> function23 = trailing;
        } else if ((i2 & 458752) == 0) {
            $dirty |= $composer2.changedInstance(trailing) ? 131072 : 65536;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = trailing;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if ((i2 & 3670016) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? 1048576 : 524288;
        }
        if (($dirty & 2995931) != 599186 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (i4 != 0) {
                icon2 = null;
            } else {
                icon2 = function2;
            }
            if (i5 != 0) {
                secondaryText2 = null;
            }
            if (i6 != 0) {
                singleLineSecondaryText2 = true;
            } else {
                singleLineSecondaryText2 = z;
            }
            if (i7 != 0) {
                overlineText2 = null;
            }
            if (i8 != 0) {
                trailing3 = null;
            } else {
                trailing3 = trailing;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-450923337, $dirty, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
            }
            Typography typography = MaterialTheme.INSTANCE.getTypography($composer2, 6);
            Function2 trailing5 = applyTextStyle(typography.getSubtitle1(), ContentAlpha.INSTANCE.getHigh($composer2, 6), function22);
            Intrinsics.checkNotNull(trailing5);
            Function2 styledSecondaryText = applyTextStyle(typography.getBody2(), ContentAlpha.INSTANCE.getMedium($composer2, 6), secondaryText2);
            Function2 styledOverlineText = applyTextStyle(typography.getOverline(), ContentAlpha.INSTANCE.getHigh($composer2, 6), overlineText2);
            Function2<Composer, Integer, Unit> applyTextStyle = applyTextStyle(typography.getCaption(), ContentAlpha.INSTANCE.getHigh($composer2, 6), trailing3);
            Modifier semanticsModifier = SemanticsModifierKt.semantics(modifier3, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
            if (styledSecondaryText == null && styledOverlineText == null) {
                $composer2.startReplaceableGroup(-210280579);
                ComposerKt.sourceInformation($composer2, "91@3942L61");
                int i9 = $dirty;
                secondaryText3 = secondaryText2;
                OneLine.INSTANCE.ListItem(semanticsModifier, icon2, trailing5, applyTextStyle, $composer2, ($dirty & 112) | 24576, 0);
                $composer2.endReplaceableGroup();
                overlineText3 = overlineText2;
                trailing4 = trailing3;
            } else {
                int $dirty2 = $dirty;
                secondaryText3 = secondaryText2;
                if ((styledOverlineText != null || !singleLineSecondaryText2) && styledSecondaryText != null) {
                    overlineText3 = overlineText2;
                    trailing4 = trailing3;
                    $composer2.startReplaceableGroup(-210280168);
                    ComposerKt.sourceInformation($composer2, "104@4355L184");
                    ThreeLine.INSTANCE.ListItem(semanticsModifier, icon2, trailing5, styledSecondaryText, styledOverlineText, applyTextStyle, $composer2, ($dirty2 & 112) | 1572864, 0);
                    $composer2.endReplaceableGroup();
                } else {
                    $composer2.startReplaceableGroup(-210280382);
                    ComposerKt.sourceInformation($composer2, "95@4139L184");
                    overlineText3 = overlineText2;
                    trailing4 = trailing3;
                    TwoLine.INSTANCE.ListItem(semanticsModifier, icon2, trailing5, styledSecondaryText, styledOverlineText, applyTextStyle, $composer2, ($dirty2 & 112) | 1572864, 0);
                    $composer2.endReplaceableGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            trailing2 = trailing4;
            overlineText2 = overlineText3;
        } else {
            $composer2.skipToGroupEnd();
            trailing2 = trailing;
            int i10 = $dirty;
            icon2 = function2;
            secondaryText3 = secondaryText2;
            singleLineSecondaryText2 = z;
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new ListItemKt$ListItem$1(modifier2, icon2, secondaryText3, singleLineSecondaryText2, overlineText2, trailing2, text, $changed, i));
    }

    /* access modifiers changed from: private */
    public static final void BaselinesOffsetColumn(List<Dp> offsets, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Composer $composer2 = $composer.startRestartGroup(1631148337);
        ComposerKt.sourceInformation($composer2, "C(BaselinesOffsetColumn)P(2,1)352@13107L1127:ListItem.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 2) != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1631148337, $dirty, -1, "androidx.compose.material.BaselinesOffsetColumn (ListItem.kt:347)");
        }
        MeasurePolicy measurePolicy$iv = new ListItemKt$BaselinesOffsetColumn$1(offsets);
        $composer2.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
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
        Function0 factory$iv$iv = ComposeUiNode.Companion.getConstructor();
        Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier2);
        int $changed$iv$iv = ((((($dirty >> 6) & 14) | ($dirty & 112)) << 9) & 7168) | 6;
        if (!($composer2.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer2.startReusableNode();
        if ($composer2.getInserting()) {
            $composer2.createNode(factory$iv$iv);
        } else {
            $composer2.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv = Updater.m2787constructorimpl($composer2);
        int i2 = $dirty;
        Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
        Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
        skippableUpdate$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
        $composer2.startReplaceableGroup(2058660585);
        content.invoke($composer2, Integer.valueOf(($changed$iv$iv >> 9) & 14));
        $composer2.endReplaceableGroup();
        $composer2.endNode();
        $composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ListItemKt$BaselinesOffsetColumn$2(offsets, modifier2, content, $changed, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: OffsetToBaselineOrCenter-Kz89ssw  reason: not valid java name */
    public static final void m1530OffsetToBaselineOrCenterKz89ssw(float offset, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        float f = offset;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i2 = $changed;
        Composer $composer2 = $composer.startRestartGroup(-1062692685);
        ComposerKt.sourceInformation($composer2, "C(OffsetToBaselineOrCenter)P(2:c#ui.unit.Dp,1)394@14762L806:ListItem.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed(f) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if ((i2 & 896) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1062692685, $dirty2, -1, "androidx.compose.material.OffsetToBaselineOrCenter (ListItem.kt:389)");
            }
            MeasurePolicy measurePolicy$iv = new ListItemKt$OffsetToBaselineOrCenter$1(f);
            int $changed$iv = (($dirty2 >> 6) & 14) | ($dirty2 & 112);
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
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
            Function0 factory$iv$iv = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier4);
            int $changed$iv$iv = (($changed$iv << 9) & 7168) | 6;
            Modifier modifier5 = modifier4;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m2787constructorimpl($composer2);
            int i4 = $changed$iv;
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            function2.invoke($composer2, Integer.valueOf(($changed$iv$iv >> 9) & 14));
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ListItemKt$OffsetToBaselineOrCenter$2(offset, modifier3, content, $changed, i));
        }
    }

    private static final Function2<Composer, Integer, Unit> applyTextStyle(TextStyle textStyle, float contentAlpha, Function2<? super Composer, ? super Integer, Unit> icon) {
        if (icon == null) {
            return null;
        }
        return ComposableLambdaKt.composableLambdaInstance(-830176860, true, new ListItemKt$applyTextStyle$1(contentAlpha, textStyle, icon));
    }
}
