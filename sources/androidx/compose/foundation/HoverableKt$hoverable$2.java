package androidx.compose.foundation;

import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Hoverable.kt */
final class HoverableKt$hoverable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HoverableKt$hoverable$2(MutableInteractionSource mutableInteractionSource, boolean z) {
        super(3);
        this.$interactionSource = mutableInteractionSource;
        this.$enabled = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0186  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r21, androidx.compose.runtime.Composer r22, int r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r22
            java.lang.String r2 = "$this$composed"
            r3 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            r2 = 1294013553(0x4d211471, float:1.68904464E8)
            r1.startReplaceableGroup(r2)
            java.lang.String r4 = "C55@2170L24,56@2223L58,82@3026L43,82@2990L79,85@3098L64,85@3074L88:Hoverable.kt#71ulvw"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r4)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0025
            r4 = -1
            java.lang.String r5 = "androidx.compose.foundation.hoverable.<anonymous> (Hoverable.kt:54)"
            r6 = r23
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r6, r4, r5)
            goto L_0x0027
        L_0x0025:
            r6 = r23
        L_0x0027:
            r2 = 0
            r4 = 0
            r5 = 773894976(0x2e20b340, float:3.6538994E-11)
            r1.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r5)
            r5 = r22
            r7 = 0
            r8 = r7
            r9 = 0
            r10 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r10)
            java.lang.String r11 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            r12 = 0
            r13 = r22
            r14 = 0
            java.lang.Object r15 = r13.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r17.getEmpty()
            if (r15 != r10) goto L_0x0072
            r10 = 0
            r17 = 0
            kotlin.coroutines.EmptyCoroutineContext r17 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r7 = r17
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            kotlinx.coroutines.CoroutineScope r7 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r7, r5)
            r17 = r2
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r2.<init>(r7)
            r13.updateRememberedValue(r2)
            goto L_0x0075
        L_0x0072:
            r17 = r2
            r2 = r15
        L_0x0075:
            r22.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r2
            kotlinx.coroutines.CoroutineScope r7 = r2.getCoroutineScope()
            r22.endReplaceableGroup()
            r2 = r7
            r4 = 0
            r5 = r4
            r4 = 0
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            r7 = 0
            r8 = r22
            r9 = 0
            java.lang.Object r10 = r8.rememberedValue()
            r11 = 0
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            r13 = 0
            if (r10 != r12) goto L_0x00ae
            r12 = 0
            r14 = 2
            androidx.compose.runtime.MutableState r12 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r13, r13, r14, r13)
            r8.updateRememberedValue(r12)
            goto L_0x00af
        L_0x00ae:
            r12 = r10
        L_0x00af:
            r22.endReplaceableGroup()
            r4 = r12
            androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = r0.$interactionSource
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = r0.$interactionSource
            r8 = 6
            r9 = 0
            r10 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r1.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r10)
            boolean r10 = r1.changed((java.lang.Object) r4)
            boolean r11 = r1.changed((java.lang.Object) r7)
            r10 = r10 | r11
            r11 = r22
            r12 = 0
            java.lang.Object r14 = r11.rememberedValue()
            r15 = 0
            if (r10 != 0) goto L_0x00e7
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r16.getEmpty()
            if (r14 != r13) goto L_0x00e5
            goto L_0x00e7
        L_0x00e5:
            r3 = r14
            goto L_0x00f4
        L_0x00e7:
            r13 = 0
            androidx.compose.foundation.HoverableKt$hoverable$2$1$1 r3 = new androidx.compose.foundation.HoverableKt$hoverable$2$1$1
            r3.<init>(r4, r5)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r11.updateRememberedValue(r3)
        L_0x00f4:
            r22.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r7 = 0
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r5, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r3, (androidx.compose.runtime.Composer) r1, (int) r7)
            boolean r3 = r0.$enabled
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            boolean r5 = r0.$enabled
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = r0.$interactionSource
            boolean r8 = r0.$enabled
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = r0.$interactionSource
            r10 = 48
            r11 = 0
            r12 = 1618982084(0x607fb4c4, float:7.370227E19)
            r1.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r12)
            boolean r12 = r1.changed((java.lang.Object) r5)
            boolean r13 = r1.changed((java.lang.Object) r4)
            r12 = r12 | r13
            boolean r13 = r1.changed((java.lang.Object) r7)
            r12 = r12 | r13
            r13 = r22
            r14 = 0
            java.lang.Object r15 = r13.rememberedValue()
            r16 = 0
            if (r12 != 0) goto L_0x0145
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r19 = r5
            java.lang.Object r5 = r18.getEmpty()
            if (r15 != r5) goto L_0x0143
            goto L_0x0147
        L_0x0143:
            r5 = r15
            goto L_0x0157
        L_0x0145:
            r19 = r5
        L_0x0147:
            r5 = 0
            r18 = r5
            androidx.compose.foundation.HoverableKt$hoverable$2$2$1 r5 = new androidx.compose.foundation.HoverableKt$hoverable$2$2$1
            r6 = 0
            r5.<init>(r8, r4, r9, r6)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r13.updateRememberedValue(r5)
        L_0x0157:
            r22.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = 64
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r3, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r5, (androidx.compose.runtime.Composer) r1, (int) r6)
            boolean r3 = r0.$enabled
            if (r3 == 0) goto L_0x017c
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = r0.$interactionSource
            androidx.compose.foundation.HoverableKt$hoverable$2$3 r6 = new androidx.compose.foundation.HoverableKt$hoverable$2$3
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = r0.$interactionSource
            r8 = 0
            r6.<init>(r2, r7, r4, r8)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput((androidx.compose.ui.Modifier) r3, (java.lang.Object) r5, (kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r6)
            goto L_0x0180
        L_0x017c:
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
        L_0x0180:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0189
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0189:
            r22.endReplaceableGroup()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.HoverableKt$hoverable$2.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }

    private static final HoverInteraction.Enter invoke$lambda$1(MutableState<HoverInteraction.Enter> $hoverInteraction$delegate) {
        return (HoverInteraction.Enter) $hoverInteraction$delegate.getValue();
    }

    private static final void invoke$lambda$2(MutableState<HoverInteraction.Enter> $hoverInteraction$delegate, HoverInteraction.Enter value) {
        $hoverInteraction$delegate.setValue(value);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Incorrect type for immutable var: ssa=androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.HoverInteraction$Enter>, code=androidx.compose.runtime.MutableState, for r6v0, types: [java.lang.Object, androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.HoverInteraction$Enter>, androidx.compose.runtime.MutableState] */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object invoke$emitEnter(androidx.compose.foundation.interaction.MutableInteractionSource r5, androidx.compose.runtime.MutableState r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitEnter$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitEnter$1 r0 = (androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitEnter$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitEnter$1 r0 = new androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitEnter$1
            r0.<init>(r7)
        L_0x0019:
            r7 = r0
            java.lang.Object r0 = r7.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            switch(r2) {
                case 0: goto L_0x0039;
                case 1: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x002d:
            java.lang.Object r5 = r7.L$1
            androidx.compose.foundation.interaction.HoverInteraction$Enter r5 = (androidx.compose.foundation.interaction.HoverInteraction.Enter) r5
            java.lang.Object r6 = r7.L$0
            androidx.compose.runtime.MutableState r6 = (androidx.compose.runtime.MutableState) r6
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0059
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.compose.foundation.interaction.HoverInteraction$Enter r2 = invoke$lambda$1(r6)
            if (r2 != 0) goto L_0x005c
            androidx.compose.foundation.interaction.HoverInteraction$Enter r2 = new androidx.compose.foundation.interaction.HoverInteraction$Enter
            r2.<init>()
            r3 = r2
            androidx.compose.foundation.interaction.Interaction r3 = (androidx.compose.foundation.interaction.Interaction) r3
            r7.L$0 = r6
            r7.L$1 = r2
            r4 = 1
            r7.label = r4
            java.lang.Object r5 = r5.emit(r3, r7)
            if (r5 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r5 = r2
        L_0x0059:
            invoke$lambda$2(r6, r5)
        L_0x005c:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.HoverableKt$hoverable$2.invoke$emitEnter(androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.MutableState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object invoke$emitExit(androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.HoverInteraction.Enter> r6, androidx.compose.foundation.interaction.MutableInteractionSource r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitExit$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitExit$1 r0 = (androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitExit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitExit$1 r0 = new androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitExit$1
            r0.<init>(r8)
        L_0x0019:
            r8 = r0
            java.lang.Object r0 = r8.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r8.label
            switch(r2) {
                case 0: goto L_0x0036;
                case 1: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x002d:
            r6 = 0
            java.lang.Object r7 = r8.L$0
            androidx.compose.runtime.MutableState r7 = (androidx.compose.runtime.MutableState) r7
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0057
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.compose.foundation.interaction.HoverInteraction$Enter r2 = invoke$lambda$1(r6)
            if (r2 == 0) goto L_0x005d
            r3 = 0
            androidx.compose.foundation.interaction.HoverInteraction$Exit r4 = new androidx.compose.foundation.interaction.HoverInteraction$Exit
            r4.<init>(r2)
            r2 = r4
            r4 = r2
            androidx.compose.foundation.interaction.Interaction r4 = (androidx.compose.foundation.interaction.Interaction) r4
            r8.L$0 = r6
            r5 = 1
            r8.label = r5
            java.lang.Object r7 = r7.emit(r4, r8)
            if (r7 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r7 = r6
            r6 = r3
        L_0x0057:
            r1 = 0
            invoke$lambda$2(r7, r1)
        L_0x005d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.HoverableKt$hoverable$2.invoke$emitExit(androidx.compose.runtime.MutableState, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void invoke$tryEmitExit(MutableState<HoverInteraction.Enter> hoverInteraction$delegate, MutableInteractionSource $interactionSource2) {
        HoverInteraction.Enter oldValue = invoke$lambda$1(hoverInteraction$delegate);
        if (oldValue != null) {
            $interactionSource2.tryEmit(new HoverInteraction.Exit(oldValue));
            invoke$lambda$2(hoverInteraction$delegate, (HoverInteraction.Enter) null);
        }
    }
}
