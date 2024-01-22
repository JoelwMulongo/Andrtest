package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class EnterExitTransitionKt$shrinkExpand$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ State<ChangeSize> $expand;
    final /* synthetic */ String $labelPrefix;
    final /* synthetic */ State<ChangeSize> $shrink;
    final /* synthetic */ Transition<EnterExitState> $transition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EnterExitTransitionKt$shrinkExpand$1(Transition<EnterExitState> transition, State<ChangeSize> state, State<ChangeSize> state2, String str) {
        super(3);
        this.$transition = transition;
        this.$expand = state;
        this.$shrink = state2;
        this.$labelPrefix = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    private static final boolean invoke$lambda$1(MutableState<Boolean> $shouldAnimate$delegate) {
        return ((Boolean) $shouldAnimate$delegate.getValue()).booleanValue();
    }

    private static final void invoke$lambda$2(MutableState<Boolean> $shouldAnimate$delegate, boolean value) {
        $shouldAnimate$delegate.setValue(Boolean.valueOf(value));
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0288  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r27, androidx.compose.runtime.Composer r28, int r29) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            r8 = r28
            java.lang.String r2 = "$this$composed"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = -140634085(0xfffffffff79e181b, float:-6.413061E33)
            r8.startReplaceableGroup(r2)
            java.lang.String r3 = "C1037@44387L46,1047@44741L396,1060@45251L41,1058@45177L125,1069@45612L218:EnterExitTransition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0025
            r3 = -1
            java.lang.String r4 = "androidx.compose.animation.shrinkExpand.<anonymous> (EnterExitTransition.kt:1033)"
            r9 = r29
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r9, r3, r4)
            goto L_0x0027
        L_0x0025:
            r9 = r29
        L_0x0027:
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r2 = r0.$transition
            r3 = 0
            r4 = 0
            r10 = 1157296644(0x44faf204, float:2007.563)
            r8.startReplaceableGroup(r10)
            java.lang.String r11 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r11)
            boolean r5 = r8.changed((java.lang.Object) r2)
            r6 = r28
            r7 = 0
            java.lang.Object r12 = r6.rememberedValue()
            r13 = 0
            r14 = 0
            r15 = 0
            if (r5 != 0) goto L_0x0053
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r16.getEmpty()
            if (r12 != r10) goto L_0x004f
            goto L_0x0053
        L_0x004f:
            r16 = r2
            r2 = r12
            goto L_0x0064
        L_0x0053:
            r10 = 0
            r16 = r2
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r15)
            r15 = 2
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r14, r15, r14)
            r6.updateRememberedValue(r2)
        L_0x0064:
            r28.endReplaceableGroup()
            r10 = r2
            androidx.compose.runtime.MutableState r10 = (androidx.compose.runtime.MutableState) r10
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r2 = r0.$transition
            java.lang.Object r2 = r2.getCurrentState()
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r3 = r0.$transition
            java.lang.Object r3 = r3.getTargetState()
            r12 = 1
            if (r2 != r3) goto L_0x0088
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r2 = r0.$transition
            boolean r2 = r2.isSeeking()
            if (r2 != 0) goto L_0x0088
            r2 = 0
            invoke$lambda$2(r10, r2)
            goto L_0x009b
        L_0x0088:
            androidx.compose.runtime.State<androidx.compose.animation.ChangeSize> r2 = r0.$expand
            java.lang.Object r2 = r2.getValue()
            if (r2 != 0) goto L_0x0098
            androidx.compose.runtime.State<androidx.compose.animation.ChangeSize> r2 = r0.$shrink
            java.lang.Object r2 = r2.getValue()
            if (r2 == 0) goto L_0x009b
        L_0x0098:
            invoke$lambda$2(r10, r12)
        L_0x009b:
            boolean r2 = invoke$lambda$1(r10)
            if (r2 == 0) goto L_0x0298
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r2 = r0.$transition
            androidx.compose.animation.core.Transition$Segment r2 = r2.getSegment()
            r3 = 0
            androidx.compose.animation.EnterExitState r4 = androidx.compose.animation.EnterExitState.PreEnter
            androidx.compose.animation.EnterExitState r5 = androidx.compose.animation.EnterExitState.Visible
            boolean r2 = r2.isTransitioningTo(r4, r5)
            androidx.compose.runtime.State<androidx.compose.animation.ChangeSize> r3 = r0.$expand
            androidx.compose.runtime.State<androidx.compose.animation.ChangeSize> r4 = r0.$shrink
            r5 = 0
            if (r2 == 0) goto L_0x00d5
            java.lang.Object r3 = r3.getValue()
            androidx.compose.animation.ChangeSize r3 = (androidx.compose.animation.ChangeSize) r3
            if (r3 == 0) goto L_0x00c6
            androidx.compose.ui.Alignment r3 = r3.getAlignment()
            if (r3 != 0) goto L_0x00f4
        L_0x00c6:
            java.lang.Object r3 = r4.getValue()
            androidx.compose.animation.ChangeSize r3 = (androidx.compose.animation.ChangeSize) r3
            if (r3 == 0) goto L_0x00d3
            androidx.compose.ui.Alignment r3 = r3.getAlignment()
            goto L_0x00f4
        L_0x00d3:
            r3 = r14
            goto L_0x00f4
        L_0x00d5:
            java.lang.Object r4 = r4.getValue()
            androidx.compose.animation.ChangeSize r4 = (androidx.compose.animation.ChangeSize) r4
            if (r4 == 0) goto L_0x00e6
            androidx.compose.ui.Alignment r4 = r4.getAlignment()
            if (r4 != 0) goto L_0x00e4
            goto L_0x00e6
        L_0x00e4:
            r3 = r4
            goto L_0x00f4
        L_0x00e6:
            java.lang.Object r3 = r3.getValue()
            androidx.compose.animation.ChangeSize r3 = (androidx.compose.animation.ChangeSize) r3
            if (r3 == 0) goto L_0x00f3
            androidx.compose.ui.Alignment r3 = r3.getAlignment()
            goto L_0x00f4
        L_0x00f3:
            r3 = r14
        L_0x00f4:
            r13 = 0
            androidx.compose.runtime.State r15 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r3, r8, r13)
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r2 = r0.$transition
            androidx.compose.ui.unit.IntSize$Companion r3 = androidx.compose.ui.unit.IntSize.Companion
            androidx.compose.animation.core.TwoWayConverter r3 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((androidx.compose.ui.unit.IntSize.Companion) r3)
            java.lang.String r4 = r0.$labelPrefix
            r5 = 0
            r6 = 0
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r8.startReplaceableGroup(r7)
            java.lang.String r12 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r12)
            r18 = 0
            r19 = r28
            r20 = 0
            java.lang.Object r7 = r19.rememberedValue()
            r22 = 0
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r23.getEmpty()
            if (r7 != r13) goto L_0x0142
            r13 = 0
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.StringBuilder r4 = r14.append(r4)
            java.lang.String r14 = " shrink/expand"
            java.lang.StringBuilder r4 = r4.append(r14)
            java.lang.String r4 = r4.toString()
            r13 = r19
            r13.updateRememberedValue(r4)
            goto L_0x0145
        L_0x0142:
            r13 = r19
            r4 = r7
        L_0x0145:
            r28.endReplaceableGroup()
            java.lang.String r4 = (java.lang.String) r4
            r6 = 448(0x1c0, float:6.28E-43)
            r7 = 0
            r5 = r28
            r13 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            androidx.compose.animation.core.Transition$DeferredAnimation r14 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(r2, r3, r4, r5, r6, r7)
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r2 = r0.$transition
            java.lang.Object r2 = r2.getCurrentState()
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r3 = r0.$transition
            java.lang.Object r3 = r3.getTargetState()
            if (r2 != r3) goto L_0x0168
            r2 = 1
            goto L_0x0169
        L_0x0168:
            r2 = 0
        L_0x0169:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r3 = -1553213624(0xffffffffa36bd748, float:-1.2784963E-17)
            r8.startMovableGroup(r3, r2)
            java.lang.String r2 = "1065@45497L54,1063@45413L152"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r2 = r0.$transition
            androidx.compose.ui.unit.IntOffset$Companion r3 = androidx.compose.ui.unit.IntOffset.Companion
            androidx.compose.animation.core.TwoWayConverter r3 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((androidx.compose.ui.unit.IntOffset.Companion) r3)
            java.lang.String r4 = r0.$labelPrefix
            r5 = 0
            r6 = 0
            r8.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r12)
            r7 = 0
            r12 = r28
            r13 = 0
            r18 = r5
            java.lang.Object r5 = r12.rememberedValue()
            r19 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r6
            java.lang.Object r6 = r20.getEmpty()
            if (r5 != r6) goto L_0x01bc
            r6 = 0
            r20 = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r5 = " InterruptionHandlingOffset"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r12.updateRememberedValue(r4)
            goto L_0x01c0
        L_0x01bc:
            r20 = r5
            r4 = r20
        L_0x01c0:
            r28.endReplaceableGroup()
            java.lang.String r4 = (java.lang.String) r4
            r6 = 448(0x1c0, float:6.28E-43)
            r7 = 0
            r5 = r28
            androidx.compose.animation.core.Transition$DeferredAnimation r20 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(r2, r3, r4, r5, r6, r7)
            r28.endMovableGroup()
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r2 = r0.$transition
            androidx.compose.runtime.State<androidx.compose.animation.ChangeSize> r3 = r0.$expand
            androidx.compose.runtime.State<androidx.compose.animation.ChangeSize> r4 = r0.$shrink
            r5 = 0
            r6 = 0
            r7 = 1157296644(0x44faf204, float:2007.563)
            r8.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r11)
            boolean r7 = r8.changed((java.lang.Object) r2)
            r11 = r28
            r12 = 0
            java.lang.Object r13 = r11.rememberedValue()
            r17 = 0
            if (r7 != 0) goto L_0x0201
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r24 = r2
            java.lang.Object r2 = r18.getEmpty()
            if (r13 != r2) goto L_0x01ff
            goto L_0x0203
        L_0x01ff:
            r2 = r13
            goto L_0x021e
        L_0x0201:
            r24 = r2
        L_0x0203:
            r2 = 0
            androidx.compose.animation.ExpandShrinkModifier r25 = new androidx.compose.animation.ExpandShrinkModifier
            r18 = r25
            r19 = r14
            r21 = r3
            r22 = r4
            r23 = r15
            r18.<init>(r19, r20, r21, r22, r23)
            r2 = r25
            r11.updateRememberedValue(r2)
        L_0x021e:
            r28.endReplaceableGroup()
            androidx.compose.animation.ExpandShrinkModifier r2 = (androidx.compose.animation.ExpandShrinkModifier) r2
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r3 = r0.$transition
            java.lang.Object r3 = r3.getCurrentState()
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r4 = r0.$transition
            java.lang.Object r4 = r4.getTargetState()
            if (r3 != r4) goto L_0x0238
            r3 = 0
            r2.setCurrentAlignment(r3)
            goto L_0x024f
        L_0x0238:
            androidx.compose.ui.Alignment r3 = r2.getCurrentAlignment()
            if (r3 != 0) goto L_0x024f
            java.lang.Object r3 = r15.getValue()
            androidx.compose.ui.Alignment r3 = (androidx.compose.ui.Alignment) r3
            if (r3 != 0) goto L_0x024c
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getTopStart()
        L_0x024c:
            r2.setCurrentAlignment(r3)
        L_0x024f:
            androidx.compose.runtime.State<androidx.compose.animation.ChangeSize> r3 = r0.$expand
            java.lang.Object r3 = r3.getValue()
            androidx.compose.animation.ChangeSize r3 = (androidx.compose.animation.ChangeSize) r3
            if (r3 == 0) goto L_0x0261
            boolean r3 = r3.getClip()
            if (r3 != 0) goto L_0x0261
            r3 = 1
            goto L_0x0262
        L_0x0261:
            r3 = 0
        L_0x0262:
            if (r3 != 0) goto L_0x027d
            androidx.compose.runtime.State<androidx.compose.animation.ChangeSize> r3 = r0.$shrink
            java.lang.Object r3 = r3.getValue()
            androidx.compose.animation.ChangeSize r3 = (androidx.compose.animation.ChangeSize) r3
            if (r3 == 0) goto L_0x0276
            boolean r3 = r3.getClip()
            if (r3 != 0) goto L_0x0276
            r3 = 1
            goto L_0x0277
        L_0x0276:
            r3 = 0
        L_0x0277:
            if (r3 == 0) goto L_0x027a
            goto L_0x027d
        L_0x027a:
            r16 = 0
            goto L_0x027f
        L_0x027d:
            r16 = 1
        L_0x027f:
            r3 = r16
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            if (r3 == 0) goto L_0x0288
            goto L_0x028c
        L_0x0288:
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.draw.ClipKt.clipToBounds(r4)
        L_0x028c:
            androidx.compose.ui.Modifier r4 = r1.then(r4)
            r5 = r2
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            androidx.compose.ui.Modifier r2 = r4.then(r5)
            goto L_0x0299
        L_0x0298:
            r2 = r1
        L_0x0299:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x02a2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02a2:
            r28.endReplaceableGroup()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
