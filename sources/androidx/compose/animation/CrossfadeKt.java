package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001aX\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\n2&\u0010\t\u001a\"\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Crossfade", "", "T", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "label", "", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/animation/core/Transition;", "contentKey", "Lkotlin/ParameterName;", "name", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Crossfade.kt */
public final class CrossfadeKt {
    public static final <T> void Crossfade(T targetState, Modifier modifier, FiniteAnimationSpec<Float> animationSpec, String label, Function3<? super T, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        String label2;
        String label3;
        FiniteAnimationSpec animationSpec2;
        Modifier modifier3;
        T t = targetState;
        Function3<? super T, ? super Composer, ? super Integer, Unit> function3 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(-310686752);
        ComposerKt.sourceInformation($composer2, "C(Crossfade)P(4,3!1,2)55@2280L36,56@2332L53:Crossfade.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed((Object) t) ? 4 : 2;
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
            $dirty |= 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            label2 = label;
        } else if ((i2 & 7168) == 0) {
            label2 = label;
            $dirty |= $composer2.changed((Object) label2) ? 2048 : 1024;
        } else {
            label2 = label;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if ((i2 & 57344) == 0) {
            $dirty |= $composer2.changed((Object) function3) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (i4 == 4 && (46811 & $dirty2) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            animationSpec2 = animationSpec;
            modifier3 = modifier2;
            label3 = label2;
        } else {
            if (i3 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                animationSpec2 = AnimationSpecKt.tween$default(0, 0, (Easing) null, 7, (Object) null);
            } else {
                animationSpec2 = animationSpec;
            }
            if (i5 != 0) {
                label2 = "Crossfade";
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-310686752, $dirty2, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:48)");
            }
            label3 = label2;
            Crossfade(TransitionKt.updateTransition(t, label2, $composer2, ($dirty2 & 8) | ($dirty2 & 14) | (($dirty2 >> 6) & 112), 0), modifier3, (FiniteAnimationSpec<Float>) animationSpec2, (Function1) null, content, $composer2, ($dirty2 & 112) | 512 | ($dirty2 & 57344), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CrossfadeKt$Crossfade$1(targetState, modifier3, animationSpec2, label3, content, $changed, i));
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Crossfade API now has a new label parameter added.")
    public static final /* synthetic */ void Crossfade(Object targetState, Modifier modifier, FiniteAnimationSpec animationSpec, Function3 content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        FiniteAnimationSpec animationSpec2;
        Modifier modifier3;
        Object obj = targetState;
        Function3 function3 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(523603005);
        ComposerKt.sourceInformation($composer2, "C(Crossfade)P(3,2)71@2743L29,72@2788L53:Crossfade.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed(obj) ? 4 : 2;
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
            $dirty |= 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if ((i2 & 7168) == 0) {
            $dirty |= $composer2.changed((Object) function3) ? 2048 : 1024;
        }
        if (i4 == 4 && ($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            animationSpec2 = animationSpec;
        } else {
            if (i3 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                animationSpec2 = AnimationSpecKt.tween$default(0, 0, (Easing) null, 7, (Object) null);
            } else {
                animationSpec2 = animationSpec;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(523603005, $dirty, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:65)");
            }
            Crossfade(TransitionKt.updateTransition(obj, (String) null, $composer2, ($dirty & 8) | ($dirty & 14), 2), modifier3, (FiniteAnimationSpec<Float>) animationSpec2, (Function1) null, content, $composer2, ($dirty & 112) | 512 | (($dirty << 3) & 57344), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i5 = $dirty;
            Composer composer = $composer2;
            return;
        }
        int i6 = $dirty;
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new CrossfadeKt$Crossfade$2(targetState, modifier2, animationSpec2, content, $changed, i));
    }

    public static final <T> void Crossfade(Transition<T> $this$Crossfade, Modifier modifier, FiniteAnimationSpec<Float> animationSpec, Function1<? super T, ? extends Object> contentKey, Function3<? super T, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Function1 contentKey2;
        FiniteAnimationSpec animationSpec2;
        Modifier modifier3;
        Function1 contentKey3;
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Transition<T> transition = $this$Crossfade;
        Function3<? super T, ? super Composer, ? super Integer, Unit> function3 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(679005231);
        ComposerKt.sourceInformation($composer2, "C(Crossfade)P(3!1,2)103@4375L64,104@4461L66,138@5750L159:Crossfade.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & Integer.MIN_VALUE) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed((Object) transition) ? 4 : 2;
        }
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 128;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 3072;
            contentKey2 = contentKey;
        } else if ((i2 & 7168) == 0) {
            contentKey2 = contentKey;
            $dirty |= $composer2.changed((Object) contentKey2) ? 2048 : 1024;
        } else {
            contentKey2 = contentKey;
        }
        if ((i & 8) != 0) {
            $dirty |= 24576;
        } else if ((57344 & i2) == 0) {
            $dirty |= $composer2.changed((Object) function3) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (i4 == 2 && (46811 & $dirty2) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            animationSpec2 = animationSpec;
            modifier3 = modifier2;
            contentKey3 = contentKey2;
        } else {
            if (i3 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                animationSpec2 = AnimationSpecKt.tween$default(0, 0, (Easing) null, 7, (Object) null);
            } else {
                animationSpec2 = animationSpec;
            }
            if (i5 != 0) {
                contentKey2 = CrossfadeKt$Crossfade$3.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(679005231, $dirty2, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:97)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object $this$Crossfade_u24lambda_u241_u24lambda_u240 = SnapshotStateKt.mutableStateListOf();
                $this$Crossfade_u24lambda_u241_u24lambda_u240.add($this$Crossfade.getCurrentState());
                value$iv$iv = $this$Crossfade_u24lambda_u241_u24lambda_u240;
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SnapshotStateList currentlyVisible = (SnapshotStateList) value$iv$iv;
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv2 = $composer2;
            Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
            if (it$iv$iv2 == Composer.Companion.getEmpty()) {
                value$iv$iv2 = (Map) new LinkedHashMap();
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            Map contentMap = (Map) value$iv$iv2;
            $composer2.startReplaceableGroup(-1621449213);
            ComposerKt.sourceInformation($composer2, "111@4841L21");
            if (Intrinsics.areEqual((Object) $this$Crossfade.getCurrentState(), (Object) $this$Crossfade.getTargetState()) && (currentlyVisible.size() != 1 || !Intrinsics.areEqual(currentlyVisible.get(0), (Object) $this$Crossfade.getTargetState()))) {
                List list = currentlyVisible;
                int $changed$iv = $dirty2 & 14;
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer2.changed((Object) transition);
                Composer $this$cache$iv$iv3 = $composer2;
                Object it$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
                if (!invalid$iv$iv) {
                    int i6 = $changed$iv;
                    if (it$iv$iv3 != Composer.Companion.getEmpty()) {
                        value$iv$iv3 = it$iv$iv3;
                        $composer2.endReplaceableGroup();
                        CollectionsKt.removeAll(list, (Function1) value$iv$iv3);
                        contentMap.clear();
                    }
                }
                value$iv$iv3 = (Function1) new CrossfadeKt$Crossfade$4$1(transition);
                $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
                $composer2.endReplaceableGroup();
                CollectionsKt.removeAll(list, (Function1) value$iv$iv3);
                contentMap.clear();
            }
            $composer2.endReplaceableGroup();
            if (!contentMap.containsKey($this$Crossfade.getTargetState())) {
                List $this$indexOfFirst$iv = currentlyVisible;
                int $i$f$indexOfFirst = false;
                int index$iv = 0;
                Iterator it = $this$indexOfFirst$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        int i7 = $i$f$indexOfFirst;
                        index$iv = -1;
                        break;
                    }
                    List $this$indexOfFirst$iv2 = $this$indexOfFirst$iv;
                    int $i$f$indexOfFirst2 = $i$f$indexOfFirst;
                    if (Intrinsics.areEqual((Object) contentKey2.invoke(it.next()), (Object) contentKey2.invoke($this$Crossfade.getTargetState()))) {
                        break;
                    }
                    index$iv++;
                    $this$indexOfFirst$iv = $this$indexOfFirst$iv2;
                    $i$f$indexOfFirst = $i$f$indexOfFirst2;
                }
                int replacementId = index$iv;
                if (replacementId == -1) {
                    currentlyVisible.add($this$Crossfade.getTargetState());
                } else {
                    currentlyVisible.set(replacementId, $this$Crossfade.getTargetState());
                }
                contentMap.clear();
                List $this$fastForEach$iv = currentlyVisible;
                int size = $this$fastForEach$iv.size();
                int index$iv2 = 0;
                while (index$iv2 < size) {
                    CrossfadeKt$Crossfade$5$1 crossfadeKt$Crossfade$5$1 = r0;
                    Object stateForContent = $this$fastForEach$iv.get(index$iv2);
                    CrossfadeKt$Crossfade$5$1 crossfadeKt$Crossfade$5$12 = new CrossfadeKt$Crossfade$5$1($this$Crossfade, $dirty2, animationSpec2, stateForContent, content);
                    contentMap.put(stateForContent, ComposableLambdaKt.composableLambda($composer2, -1426421288, true, crossfadeKt$Crossfade$5$1));
                    index$iv2++;
                    Transition<T> transition2 = $this$Crossfade;
                    size = size;
                    $this$fastForEach$iv = $this$fastForEach$iv;
                    replacementId = replacementId;
                }
                int i8 = index$iv2;
                List list2 = $this$fastForEach$iv;
                int i9 = replacementId;
            }
            int $changed$iv2 = ($dirty2 >> 3) & 14;
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, (($changed$iv2 >> 3) & 14) | (($changed$iv2 >> 3) & 112));
            int $changed$iv$iv = ($changed$iv2 << 3) & 112;
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
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier3);
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            int i10 = $changed$iv$iv;
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
            Composer $composer$iv = $composer2;
            Density density = density$iv$iv;
            $composer$iv.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation($composer$iv, "C72@3384L9:Box.kt#2w3rfo");
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            if ((($changed$iv$iv$iv >> 9) & 14 & 11) != 2 || !$composer$iv.getSkipping()) {
                int i11 = $changed$iv2;
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i12 = (($changed$iv2 >> 6) & 112) | 6;
                Composer $composer3 = $composer$iv;
                ComposerKt.sourceInformationMarkerStart($composer3, 2072161918, "C:Crossfade.kt#xbi5r1");
                $composer2.startReplaceableGroup(-1621447954);
                ComposerKt.sourceInformation($composer2, "");
                List $this$fastForEach$iv2 = currentlyVisible;
                int $i$f$fastForEach = $this$fastForEach$iv2.size();
                ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                int index$iv3 = 0;
                while (index$iv3 < $i$f$fastForEach) {
                    List $this$fastForEach$iv3 = $this$fastForEach$iv2;
                    Object it2 = $this$fastForEach$iv2.get(index$iv3);
                    int i13 = $i$f$fastForEach;
                    MeasurePolicy measurePolicy$iv2 = measurePolicy$iv;
                    $composer3.startMovableGroup(-450541366, contentKey2.invoke(it2));
                    ComposerKt.sourceInformation($composer3, "141@5871L8");
                    Function2 function2 = (Function2) contentMap.get(it2);
                    Object obj = it2;
                    if (function2 != null) {
                        function2.invoke($composer3, 0);
                    }
                    $composer3.endMovableGroup();
                    index$iv3++;
                    $i$f$fastForEach = i13;
                    $this$fastForEach$iv2 = $this$fastForEach$iv3;
                    measurePolicy$iv = measurePolicy$iv2;
                }
                MeasurePolicy measurePolicy = measurePolicy$iv;
                $composer2.endReplaceableGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                $composer$iv.skipToGroupEnd();
                int i14 = $changed$iv2;
                ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv;
                MeasurePolicy measurePolicy2 = measurePolicy$iv;
            }
            $composer$iv.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentKey3 = contentKey2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CrossfadeKt$Crossfade$7($this$Crossfade, modifier3, animationSpec2, contentKey3, content, $changed, i));
        }
    }
}
