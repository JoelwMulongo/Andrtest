package androidx.compose.material3.internal;

import android.view.View;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0013\b\b\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\fH\b¢\u0006\u0002\u0010\u0011\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0012"}, d2 = {"LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ExposedDropdownMenuPopup", "", "onDismissRequest", "Lkotlin/Function0;", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExposedDropdownMenuPopup.kt */
public final class ExposedDropdownMenuPopupKt {
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, ExposedDropdownMenuPopupKt$LocalPopupTestTag$1.INSTANCE, 1, (Object) null);

    public static final void ExposedDropdownMenuPopup(Function0<Unit> onDismissRequest, PopupPositionProvider popupPositionProvider, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Function0 onDismissRequest2;
        Function0 onDismissRequest3;
        Composer $composer2;
        int $dirty;
        String testTag;
        LayoutDirection layoutDirection;
        State<T> state;
        PopupLayout popupLayout;
        PopupPositionProvider popupPositionProvider2 = popupPositionProvider;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(popupPositionProvider2, "popupPositionProvider");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer3 = $composer.startRestartGroup(187306684);
        ComposerKt.sourceInformation($composer3, "C(ExposedDropdownMenuPopup)P(1,2)83@3320L7,84@3359L7,85@3403L7,86@3458L7,87@3494L28,88@3549L29,89@3597L38,90@3658L907,117@4571L380,131@4957L192,139@5155L166,148@5499L647:ExposedDropdownMenuPopup.kt#mqatfk");
        int $dirty2 = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty2 |= 6;
            onDismissRequest2 = onDismissRequest;
        } else if ((i2 & 14) == 0) {
            onDismissRequest2 = onDismissRequest;
            $dirty2 |= $composer3.changed((Object) onDismissRequest2) ? 4 : 2;
        } else {
            onDismissRequest2 = onDismissRequest;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if ((i2 & 112) == 0) {
            $dirty2 |= $composer3.changed((Object) popupPositionProvider2) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if ((i2 & 896) == 0) {
            $dirty2 |= $composer3.changed((Object) function2) ? 256 : 128;
        }
        int $dirty3 = $dirty2;
        if (($dirty3 & 731) != 146 || !$composer3.getSkipping()) {
            if (i3 != 0) {
                onDismissRequest2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(187306684, $dirty3, -1, "androidx.compose.material3.internal.ExposedDropdownMenuPopup (ExposedDropdownMenuPopup.kt:78)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(AndroidCompositionLocals_androidKt.getLocalView());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            View view = (View) consume;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density = (Density) consume2;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(LocalPopupTestTag);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            String testTag2 = (String) consume3;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume4;
            CompositionContext parentComposition = ComposablesKt.rememberCompositionContext($composer3, 0);
            State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, $composer3, ($dirty3 >> 6) & 14);
            CompositionContext parentComposition2 = parentComposition;
            String str = "C:CompositionLocal.kt#9igjgp";
            Composer $this$cache$iv$iv = $composer3;
            UUID popupId = (UUID) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupId$1.INSTANCE, $this$cache$iv$iv, 3080, 6);
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Intrinsics.checkNotNullExpressionValue(popupId, "popupId");
                Object obj = it$iv$iv;
                layoutDirection = layoutDirection2;
                testTag = testTag2;
                onDismissRequest3 = onDismissRequest2;
                $dirty = $dirty3;
                $composer2 = $composer3;
                PopupLayout $this$ExposedDropdownMenuPopup_u24lambda_u2d2_u24lambda_u2d1 = new PopupLayout(onDismissRequest2, testTag2, view, density, popupPositionProvider, popupId);
                state = rememberUpdatedState;
                $this$ExposedDropdownMenuPopup_u24lambda_u2d2_u24lambda_u2d1.setContent(parentComposition2, ComposableLambdaKt.composableLambdaInstance(686046343, true, new ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1($this$ExposedDropdownMenuPopup_u24lambda_u2d2_u24lambda_u2d1, state)));
                $this$cache$iv$iv.updateRememberedValue($this$ExposedDropdownMenuPopup_u24lambda_u2d2_u24lambda_u2d1);
                popupLayout = $this$ExposedDropdownMenuPopup_u24lambda_u2d2_u24lambda_u2d1;
            } else {
                testTag = testTag2;
                onDismissRequest3 = onDismissRequest2;
                $dirty = $dirty3;
                $composer2 = $composer3;
                Object it$iv$iv2 = it$iv$iv;
                state = rememberUpdatedState;
                CompositionContext compositionContext = parentComposition2;
                layoutDirection = layoutDirection2;
                popupLayout = it$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            PopupLayout popupLayout2 = (PopupLayout) popupLayout;
            String testTag3 = testTag;
            $composer3 = $composer2;
            EffectsKt.DisposableEffect((Object) popupLayout2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$1(popupLayout2, onDismissRequest3, testTag3, layoutDirection), $composer3, 8);
            EffectsKt.SideEffect(new ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$2(popupLayout2, onDismissRequest3, testTag3, layoutDirection), $composer3, 0);
            EffectsKt.DisposableEffect((Object) popupPositionProvider2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$3(popupLayout2, popupPositionProvider2), $composer3, ($dirty >> 3) & 14);
            Modifier modifier$iv = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.Companion, new ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$5(popupLayout2));
            MeasurePolicy measurePolicy$iv = new ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$6(popupLayout2, layoutDirection);
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2907L7,75@2962L7,76@3021L7,77@3033L460:Layout.kt#80mrfh");
            PopupLayout popupLayout3 = popupLayout2;
            String str2 = str;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str2);
            Object consume5 = $composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv = (Density) consume5;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str2);
            Object consume6 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume6;
            String str3 = testTag3;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str2);
            Object consume7 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume7;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
            State<T> state2 = state;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv = Updater.m2787constructorimpl($composer3);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer3.enableReusing();
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            Composer $composer4 = $composer3;
            ViewConfiguration viewConfiguration = viewConfiguration$iv;
            $composer4.startReplaceableGroup(975527269);
            ComposerKt.sourceInformation($composer4, "C:ExposedDropdownMenuPopup.kt#mqatfk");
            int i4 = $changed$iv$iv;
            if ((($changed$iv$iv >> 9) & 14 & 11) == 2 && $composer4.getSkipping()) {
                $composer4.skipToGroupEnd();
            }
            $composer4.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            onDismissRequest3 = onDismissRequest2;
            int i5 = $dirty3;
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$7(onDismissRequest3, popupPositionProvider, content, $changed, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ExposedDropdownMenuPopup$lambda-0  reason: not valid java name */
    public static final Function2<Composer, Integer, Unit> m2253ExposedDropdownMenuPopup$lambda0(State<? extends Function2<? super Composer, ? super Integer, Unit>> $currentContent$delegate) {
        return (Function2) $currentContent$delegate.getValue();
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Composer composer = $composer;
        composer.startReplaceableGroup(-483170785);
        ComposerKt.sourceInformation(composer, "C(SimpleStack)P(1)177@6690L979:ExposedDropdownMenuPopup.kt#mqatfk");
        MeasurePolicy measurePolicy$iv = ExposedDropdownMenuPopupKt$SimpleStack$1.INSTANCE;
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2907L7,75@2962L7,76@3021L7,77@3033L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density$iv = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd($composer);
        LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd($composer);
        ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
        Function0 factory$iv$iv = ComposeUiNode.Companion.getConstructor();
        Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier);
        int $changed$iv$iv = ((((($changed >> 3) & 14) | (($changed << 3) & 112)) << 9) & 7168) | 6;
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            composer.createNode(factory$iv$iv);
        } else {
            $composer.useNode();
        }
        $composer.disableReusing();
        Composer $this$Layout_u24lambda_u2d0$iv = Updater.m2787constructorimpl($composer);
        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
        $composer.enableReusing();
        skippableUpdate$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        content.invoke(composer, Integer.valueOf(($changed$iv$iv >> 9) & 14));
        $composer.endReplaceableGroup();
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
    }
}
