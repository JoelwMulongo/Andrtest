package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a9\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001d\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\n\u001aA\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001d\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"SubcomposeLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "state", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "(Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SubcomposeSlotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "maxSlotsToRetainForReuse", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
public final class SubcomposeLayoutKt {
    public static final void SubcomposeLayout(Modifier modifier, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer $composer2 = $composer.startRestartGroup(-1298353104);
        ComposerKt.sourceInformation($composer2, "C(SubcomposeLayout)P(1)75@3400L36,74@3366L144:SubcomposeLayout.kt#80mrfh");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(measurePolicy) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1298353104, $dirty2, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:70)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = new SubcomposeLayoutState();
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayout((SubcomposeLayoutState) value$iv$iv, modifier, measurePolicy, $composer2, (($dirty2 << 3) & 112) | 8 | (($dirty2 << 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SubcomposeLayoutKt$SubcomposeLayout$2(modifier, measurePolicy, $changed, i));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0185  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SubcomposeLayout(androidx.compose.ui.layout.SubcomposeLayoutState r20, androidx.compose.ui.Modifier r21, kotlin.jvm.functions.Function2<? super androidx.compose.ui.layout.SubcomposeMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult> r22, androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r6 = r20
            r7 = r22
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "measurePolicy"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = -511989831(0xffffffffe17ba7b9, float:-2.9013865E20)
            r1 = r23
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SubcomposeLayout)P(2,1)108@4858L28,110@4979L7,111@5034L7,112@5093L7,113@5105L519,130@5764L27,131@5819L89,131@5796L112:SubcomposeLayout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r25 & 2
            if (r1 == 0) goto L_0x0028
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r9 = r1
            goto L_0x002a
        L_0x0028:
            r9 = r21
        L_0x002a:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0039
            r1 = -1
            java.lang.String r2 = "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:103)"
            r10 = r24
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r10, r1, r2)
            goto L_0x003b
        L_0x0039:
            r10 = r24
        L_0x003b:
            r0 = 0
            androidx.compose.runtime.CompositionContext r11 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r8, r0)
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.ComposedModifierKt.materialize(r8, r9)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r2 = 6
            r3 = 0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r5)
            java.lang.Object r13 = r8.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r2 = 6
            r3 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r5)
            java.lang.Object r14 = r8.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.unit.LayoutDirection r14 = (androidx.compose.ui.unit.LayoutDirection) r14
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r2 = 6
            r3 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r5)
            java.lang.Object r4 = r8.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r15 = r4
            androidx.compose.ui.platform.ViewConfiguration r15 = (androidx.compose.ui.platform.ViewConfiguration) r15
            androidx.compose.ui.node.LayoutNode$Companion r1 = androidx.compose.ui.node.LayoutNode.Companion
            kotlin.jvm.functions.Function0 r1 = r1.getConstructor$ui_release()
            r2 = 6
            r3 = r2
            r4 = 0
            r5 = 1886828752(0x7076b8d0, float:3.0542695E29)
            r8.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(ComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r5)
            androidx.compose.runtime.Applier r5 = r8.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x00a6
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00a6:
            r8.startNode()
            boolean r5 = r8.getInserting()
            if (r5 == 0) goto L_0x00ba
            androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$$inlined$ComposeNode$1 r5 = new androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$$inlined$ComposeNode$1
            r5.<init>(r1)
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r8.createNode(r5)
            goto L_0x00bd
        L_0x00ba:
            r8.useNode()
        L_0x00bd:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m2787constructorimpl(r8)
            r16 = 0
            kotlin.jvm.functions.Function2 r2 = r20.getSetRoot$ui_release()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r5, r6, r2)
            kotlin.jvm.functions.Function2 r2 = r20.getSetCompositionContext$ui_release()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r5, r11, r2)
            kotlin.jvm.functions.Function2 r2 = r20.getSetMeasurePolicy$ui_release()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r5, r7, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r5, r13, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r5, r14, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r5, r15, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetModifier()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r5, r12, r2)
            r8.endNode()
            r8.endReplaceableGroup()
            r1 = -607848778(0xffffffffdbc4f6b6, float:-1.10880714E17)
            r8.startReplaceableGroup(r1)
            java.lang.String r1 = "126@5670L65"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            boolean r1 = r8.getSkipping()
            if (r1 != 0) goto L_0x0120
            androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$4 r1 = new androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$4
            r1.<init>(r6)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            androidx.compose.runtime.EffectsKt.SideEffect(r1, r8, r0)
        L_0x0120:
            r8.endReplaceableGroup()
            r0 = 8
            androidx.compose.runtime.State r5 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r6, r8, r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r1 = 0
            r2 = 0
            r3 = 1157296644(0x44faf204, float:2007.563)
            r8.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            boolean r3 = r8.changed((java.lang.Object) r5)
            r4 = r8
            r16 = 0
            r23 = r1
            java.lang.Object r1 = r4.rememberedValue()
            r17 = 0
            if (r3 != 0) goto L_0x0157
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r19 = r2
            java.lang.Object r2 = r18.getEmpty()
            if (r1 != r2) goto L_0x0154
            goto L_0x0159
        L_0x0154:
            r18 = r1
            goto L_0x0168
        L_0x0157:
            r19 = r2
        L_0x0159:
            r2 = 0
            r18 = r1
            androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$5$1 r1 = new androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$5$1
            r1.<init>(r5)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r4.updateRememberedValue(r1)
        L_0x0168:
            r8.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r2 = 6
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r1, (androidx.compose.runtime.Composer) r8, (int) r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x017c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x017c:
            androidx.compose.runtime.ScopeUpdateScope r4 = r8.endRestartGroup()
            if (r4 != 0) goto L_0x0185
            r17 = r5
            goto L_0x019f
        L_0x0185:
            androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$6 r16 = new androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$6
            r0 = r16
            r1 = r20
            r2 = r9
            r3 = r22
            r6 = r4
            r4 = r24
            r17 = r5
            r5 = r25
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r6.updateScope(r0)
        L_0x019f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout(androidx.compose.ui.layout.SubcomposeLayoutState, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final SubcomposeSlotReusePolicy SubcomposeSlotReusePolicy(int maxSlotsToRetainForReuse) {
        return new FixedCountSubcomposeSlotReusePolicy(maxSlotsToRetainForReuse);
    }
}
