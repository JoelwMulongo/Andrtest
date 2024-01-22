package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0002\u0010\r\u001a:\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\t2\u0019\b\u0002\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0012\u001a9\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0003¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0003¢\u0006\u0002\u0010\u001e\u001a\u001e\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000*b\b\u0002\u0010%\"-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\u0002\b\f¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\f2-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\u0002\b\f¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\f¨\u0006("}, d2 = {"SnackbarFadeInMillis", "", "SnackbarFadeOutMillis", "SnackbarInBetweenDelayMillis", "FadeInFadeOutWithScale", "", "current", "Landroidx/compose/material3/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SnackbarHost", "hostState", "Landroidx/compose/material3/SnackbarHostState;", "snackbar", "(Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animatedOpacity", "Landroidx/compose/runtime/State;", "", "animation", "Landroidx/compose/animation/core/AnimationSpec;", "visible", "", "onAnimationFinish", "Lkotlin/Function0;", "(Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animatedScale", "(Landroidx/compose/animation/core/AnimationSpec;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "toMillis", "", "Landroidx/compose/material3/SnackbarDuration;", "hasAction", "accessibilityManager", "Landroidx/compose/ui/platform/AccessibilityManager;", "FadeInFadeOutTransition", "Lkotlin/ParameterName;", "name", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SnackbarHost.kt */
public final class SnackbarHostKt {
    private static final int SnackbarFadeInMillis = 150;
    private static final int SnackbarFadeOutMillis = 75;
    private static final int SnackbarInBetweenDelayMillis = 0;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SnackbarHost.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SnackbarDuration.values().length];
            iArr[SnackbarDuration.Indefinite.ordinal()] = 1;
            iArr[SnackbarDuration.Long.ordinal()] = 2;
            iArr[SnackbarDuration.Short.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void SnackbarHost(SnackbarHostState hostState, Modifier modifier, Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> snackbar, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Function3 function3;
        Function3 snackbar2;
        Modifier modifier3;
        Modifier modifier4;
        SnackbarHostState snackbarHostState = hostState;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(snackbarHostState, "hostState");
        Composer $composer2 = $composer.startRestartGroup(464178177);
        ComposerKt.sourceInformation($composer2, "C(SnackbarHost)224@9340L7,225@9352L356,235@9713L134:SnackbarHost.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed((Object) snackbarHostState) ? 4 : 2;
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
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            function3 = snackbar;
        } else if ((i2 & 896) == 0) {
            function3 = snackbar;
            $dirty |= $composer2.changed((Object) function3) ? 256 : 128;
        } else {
            function3 = snackbar;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            Function3 snackbar3 = i4 != 0 ? ComposableSingletons$SnackbarHostKt.INSTANCE.m1876getLambda1$material3_release() : function3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(464178177, $dirty2, -1, "androidx.compose.material3.SnackbarHost (SnackbarHost.kt:218)");
            }
            SnackbarData currentSnackbarData = hostState.getCurrentSnackbarData();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalAccessibilityManager());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect((Object) currentSnackbarData, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new SnackbarHostKt$SnackbarHost$1(currentSnackbarData, (AccessibilityManager) consume, (Continuation<? super SnackbarHostKt$SnackbarHost$1>) null), $composer2, 64);
            FadeInFadeOutWithScale(hostState.getCurrentSnackbarData(), modifier4, snackbar3, $composer2, ($dirty2 & 112) | ($dirty2 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            snackbar2 = snackbar3;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            snackbar2 = function3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SnackbarHostKt$SnackbarHost$2(hostState, modifier3, snackbar2, $changed, i));
        }
    }

    public static final long toMillis(SnackbarDuration $this$toMillis, boolean hasAction, AccessibilityManager accessibilityManager) {
        long original;
        Intrinsics.checkNotNullParameter($this$toMillis, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$toMillis.ordinal()]) {
            case 1:
                original = Long.MAX_VALUE;
                break;
            case 2:
                original = 10000;
                break;
            case 3:
                original = 4000;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (accessibilityManager == null) {
            return original;
        }
        return accessibilityManager.calculateRecommendedTimeoutMillis(original, true, true, hasAction);
    }

    /* access modifiers changed from: private */
    public static final void FadeInFadeOutWithScale(SnackbarData current, Modifier modifier, Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Object value$iv$iv;
        SnackbarData snackbarData = current;
        Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function3 = content;
        int i2 = $changed;
        Composer $composer2 = $composer.startRestartGroup(-1316639904);
        ComposerKt.sourceInformation($composer2, "C(FadeInFadeOutWithScale)P(1,2)345@12638L48,399@14885L242:SnackbarHost.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed((Object) snackbarData) ? 4 : 2;
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
            $dirty |= $composer2.changed((Object) function3) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1316639904, $dirty2, -1, "androidx.compose.material3.FadeInFadeOutWithScale (SnackbarHost.kt:340)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = new FadeInFadeOutState();
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            FadeInFadeOutState state = (FadeInFadeOutState) value$iv$iv;
            if (!Intrinsics.areEqual((Object) snackbarData, state.getCurrent())) {
                state.setCurrent(snackbarData);
                Iterable<FadeInFadeOutAnimationItem> $this$map$iv = state.getItems();
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (FadeInFadeOutAnimationItem it : $this$map$iv) {
                    destination$iv$iv.add((SnackbarData) it.getKey());
                }
                List keys = CollectionsKt.toMutableList((List) destination$iv$iv);
                if (!keys.contains(snackbarData)) {
                    keys.add(snackbarData);
                }
                state.getItems().clear();
                Iterable<SnackbarData> $this$mapTo$iv = CollectionsKt.filterNotNull(keys);
                Collection destination$iv = state.getItems();
                for (SnackbarData key : $this$mapTo$iv) {
                    destination$iv.add(new FadeInFadeOutAnimationItem(key, ComposableLambdaKt.composableLambda($composer2, 1365430839, true, new SnackbarHostKt$FadeInFadeOutWithScale$1$1(key, snackbarData, keys, state))));
                    keys = keys;
                    $this$mapTo$iv = $this$mapTo$iv;
                }
                Iterable iterable = $this$mapTo$iv;
            }
            int $changed$iv = ($dirty2 >> 3) & 14;
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Alignment alignment = contentAlignment$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier4);
            modifier3 = modifier4;
            int $changed$iv$iv$iv = (((($changed$iv << 3) & 112) << 9) & 7168) | 6;
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
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int $changed$iv2 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer2;
            int i4 = $changed$iv$iv$iv;
            $composer$iv.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation($composer$iv, "C72@3384L9:Box.kt#2w3rfo");
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            if (($changed$iv2 & 11) != 2 || !$composer$iv.getSkipping()) {
                int $changed2 = (($changed$iv >> 6) & 112) | 6;
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i5 = $changed$iv;
                Composer $composer3 = $composer$iv;
                $composer3.startReplaceableGroup(393759974);
                ComposerKt.sourceInformation($composer3, "C400@14923L21:SnackbarHost.kt#uh7d8r");
                int i6 = $changed2;
                if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                    state.setScope(ComposablesKt.getCurrentRecomposeScope($composer3, 0));
                    Iterable<FadeInFadeOutAnimationItem> $this$forEach$iv = state.getItems();
                    int $i$f$forEach = false;
                    for (FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem : $this$forEach$iv) {
                        FadeInFadeOutState state2 = state;
                        SnackbarData item = (SnackbarData) fadeInFadeOutAnimationItem.component1();
                        Iterable $this$forEach$iv2 = $this$forEach$iv;
                        Function3 opacity = fadeInFadeOutAnimationItem.component2();
                        $composer3.startMovableGroup(870027402, item);
                        ComposerKt.sourceInformation($composer3, "403@15034L63");
                        SnackbarData snackbarData2 = item;
                        opacity.invoke(ComposableLambdaKt.composableLambda($composer3, -1462081411, true, new SnackbarHostKt$FadeInFadeOutWithScale$2$1$1(function3, item, $dirty2)), $composer3, 6);
                        $composer3.endMovableGroup();
                        state = state2;
                        $this$forEach$iv = $this$forEach$iv2;
                        $i$f$forEach = $i$f$forEach;
                        $changed$iv2 = $changed$iv2;
                    }
                    Iterable iterable2 = $this$forEach$iv;
                    int i7 = $i$f$forEach;
                    int i8 = $changed$iv2;
                } else {
                    $composer3.skipToGroupEnd();
                    FadeInFadeOutState fadeInFadeOutState = state;
                    int i9 = $changed$iv2;
                }
                $composer3.endReplaceableGroup();
            } else {
                $composer$iv.skipToGroupEnd();
                FadeInFadeOutState fadeInFadeOutState2 = state;
                int i10 = $changed$iv;
                int i11 = $changed$iv2;
            }
            $composer$iv.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SnackbarHostKt$FadeInFadeOutWithScale$3(current, modifier3, content, $changed, i));
        }
    }

    /* access modifiers changed from: private */
    public static final State<Float> animatedOpacity(AnimationSpec<Float> animation, boolean visible, Function0<Unit> onAnimationFinish, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(1431889134);
        ComposerKt.sourceInformation(composer, "C(animatedOpacity)P(!1,2)431@15775L49,432@15829L169:SnackbarHost.kt#uh7d8r");
        Function0 onAnimationFinish2 = (i & 4) != 0 ? SnackbarHostKt$animatedOpacity$1.INSTANCE : onAnimationFinish;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1431889134, i2, -1, "androidx.compose.material3.animatedOpacity (SnackbarHost.kt:426)");
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = AnimatableKt.Animatable$default(!visible ? 1.0f : 0.0f, 0.0f, 2, (Object) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Animatable alpha = (Animatable) value$iv$iv;
        EffectsKt.LaunchedEffect((Object) Boolean.valueOf(visible), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new SnackbarHostKt$animatedOpacity$2(alpha, visible, animation, onAnimationFinish2, (Continuation<? super SnackbarHostKt$animatedOpacity$2>) null), composer, ((i2 >> 3) & 14) | 64);
        State<Float> asState = alpha.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return asState;
    }

    /* access modifiers changed from: private */
    public static final State<Float> animatedScale(AnimationSpec<Float> animation, boolean visible, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(1966809761);
        ComposerKt.sourceInformation($composer, "C(animatedScale)444@16150L51,445@16206L143:SnackbarHost.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1966809761, $changed, -1, "androidx.compose.material3.animatedScale (SnackbarHost.kt:443)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = AnimatableKt.Animatable$default(!visible ? 1.0f : 0.8f, 0.0f, 2, (Object) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Animatable scale = (Animatable) value$iv$iv;
        EffectsKt.LaunchedEffect((Object) Boolean.valueOf(visible), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new SnackbarHostKt$animatedScale$1(scale, visible, animation, (Continuation<? super SnackbarHostKt$animatedScale$1>) null), $composer, (($changed >> 3) & 14) | 64);
        State<Float> asState = scale.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return asState;
    }
}
