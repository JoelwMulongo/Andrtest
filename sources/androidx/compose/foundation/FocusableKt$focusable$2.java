package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.PinnableContainer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Focusable.kt */
final class FocusableKt$focusable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusableKt$focusable$2(MutableInteractionSource mutableInteractionSource, boolean z) {
        super(3);
        this.$interactionSource = mutableInteractionSource;
        this.$enabled = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x02ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r28, androidx.compose.runtime.Composer r29, int r30) {
        /*
            r27 = this;
            r0 = r27
            r1 = r29
            java.lang.String r2 = "$this$composed"
            r3 = r28
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            r2 = 1871352361(0x6f8a9229, float:8.577126E28)
            r1.startReplaceableGroup(r2)
            java.lang.String r4 = "C68@2856L24,69@2910L58,70@2990L34,71@3050L29,83@3823L37,84@3901L280,84@3865L316,93@4186L390,116@5029L7,117@5062L66,118@5173L215,118@5137L251,129@5430L185:Focusable.kt#71ulvw"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r4)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0025
            r4 = -1
            java.lang.String r5 = "androidx.compose.foundation.focusable.<anonymous> (Focusable.kt:67)"
            r6 = r30
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r6, r4, r5)
            goto L_0x0027
        L_0x0025:
            r6 = r30
        L_0x0027:
            r2 = 0
            r4 = 0
            r5 = 773894976(0x2e20b340, float:3.6538994E-11)
            r1.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r5)
            r5 = r29
            r7 = 0
            r8 = r7
            r9 = 0
            r10 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r10)
            java.lang.String r11 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            r12 = 0
            r13 = r29
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
            r29.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r2
            kotlinx.coroutines.CoroutineScope r7 = r2.getCoroutineScope()
            r29.endReplaceableGroup()
            r2 = r7
            r4 = 0
            r5 = r4
            r4 = 0
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            r7 = 0
            r8 = r29
            r9 = 0
            java.lang.Object r10 = r8.rememberedValue()
            r12 = 0
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            r14 = 2
            r15 = 0
            if (r10 != r13) goto L_0x00ae
            r13 = 0
            androidx.compose.runtime.MutableState r13 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r15, r15, r14, r15)
            r8.updateRememberedValue(r13)
            goto L_0x00af
        L_0x00ae:
            r13 = r10
        L_0x00af:
            r29.endReplaceableGroup()
            r4 = r13
            androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
            r5 = 0
            r7 = r5
            r5 = 0
            r8 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            r8 = 0
            r9 = r29
            r10 = 0
            java.lang.Object r12 = r9.rememberedValue()
            r13 = 0
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r16.getEmpty()
            if (r12 != r14) goto L_0x00e8
            r14 = 0
            r16 = 0
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r16)
            r19 = r5
            r5 = 2
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r15, r5, r15)
            r9.updateRememberedValue(r3)
            goto L_0x00eb
        L_0x00e8:
            r19 = r5
            r3 = r12
        L_0x00eb:
            r29.endReplaceableGroup()
            androidx.compose.runtime.MutableState r3 = (androidx.compose.runtime.MutableState) r3
            r5 = 0
            r7 = r5
            r5 = 0
            r8 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            r8 = 0
            r9 = r29
            r10 = 0
            java.lang.Object r12 = r9.rememberedValue()
            r13 = 0
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r12 != r14) goto L_0x011c
            r14 = 0
            androidx.compose.ui.focus.FocusRequester r16 = new androidx.compose.ui.focus.FocusRequester
            r16.<init>()
            r14 = r16
            r9.updateRememberedValue(r14)
            goto L_0x011d
        L_0x011c:
            r14 = r12
        L_0x011d:
            r29.endReplaceableGroup()
            r5 = r14
            androidx.compose.ui.focus.FocusRequester r5 = (androidx.compose.ui.focus.FocusRequester) r5
            r7 = 0
            r8 = r7
            r7 = 0
            r9 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            r9 = 0
            r10 = r29
            r12 = 0
            java.lang.Object r13 = r10.rememberedValue()
            r14 = 0
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r16.getEmpty()
            if (r13 != r15) goto L_0x014d
            r15 = 0
            androidx.compose.foundation.relocation.BringIntoViewRequester r15 = androidx.compose.foundation.relocation.BringIntoViewRequesterKt.BringIntoViewRequester()
            r10.updateRememberedValue(r15)
            goto L_0x014e
        L_0x014d:
            r15 = r13
        L_0x014e:
            r29.endReplaceableGroup()
            r7 = r15
            androidx.compose.foundation.relocation.BringIntoViewRequester r7 = (androidx.compose.foundation.relocation.BringIntoViewRequester) r7
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = r0.$interactionSource
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = r0.$interactionSource
            r10 = 6
            r12 = 0
            r13 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r1.startReplaceableGroup(r13)
            java.lang.String r14 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r14)
            boolean r15 = r1.changed((java.lang.Object) r4)
            boolean r16 = r1.changed((java.lang.Object) r9)
            r15 = r15 | r16
            r16 = r29
            r20 = 0
            java.lang.Object r13 = r16.rememberedValue()
            r22 = 0
            if (r15 != 0) goto L_0x018d
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r23.getEmpty()
            if (r13 != r6) goto L_0x0187
            goto L_0x018d
        L_0x0187:
            r23 = r9
            r6 = r13
            r9 = r16
            goto L_0x01a0
        L_0x018d:
            r6 = 0
            r23 = r6
            androidx.compose.foundation.FocusableKt$focusable$2$1$1 r6 = new androidx.compose.foundation.FocusableKt$focusable$2$1$1
            r6.<init>(r4, r8)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r23 = r9
            r9 = r16
            r9.updateRememberedValue(r6)
        L_0x01a0:
            r29.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r9 = 0
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r8, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r6, (androidx.compose.runtime.Composer) r1, (int) r9)
            boolean r6 = r0.$enabled
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            androidx.compose.foundation.FocusableKt$focusable$2$2 r8 = new androidx.compose.foundation.FocusableKt$focusable$2$2
            boolean r10 = r0.$enabled
            androidx.compose.foundation.interaction.MutableInteractionSource r12 = r0.$interactionSource
            r8.<init>(r10, r2, r4, r12)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r6, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r8, (androidx.compose.runtime.Composer) r1, (int) r9)
            boolean r6 = r0.$enabled
            if (r6 == 0) goto L_0x0337
            r6 = 1407540673(0x53e55dc1, float:1.97024088E12)
            r1.startReplaceableGroup(r6)
            java.lang.String r6 = "108@4661L36"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r6)
            boolean r6 = invoke$lambda$2(r3)
            if (r6 == 0) goto L_0x0209
            r6 = 0
            r8 = r6
            r6 = 0
            r9 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            r9 = 0
            r10 = r29
            r12 = 0
            java.lang.Object r13 = r10.rememberedValue()
            r15 = 0
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r20 = r6
            java.lang.Object r6 = r16.getEmpty()
            if (r13 != r6) goto L_0x0200
            r6 = 0
            androidx.compose.foundation.FocusedBoundsModifier r16 = new androidx.compose.foundation.FocusedBoundsModifier
            r16.<init>()
            r6 = r16
            r10.updateRememberedValue(r6)
            goto L_0x0201
        L_0x0200:
            r6 = r13
        L_0x0201:
            r29.endReplaceableGroup()
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            goto L_0x020d
        L_0x0209:
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
        L_0x020d:
            r29.endReplaceableGroup()
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.layout.PinnableContainerKt.getLocalPinnableContainer()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r9 = 0
            r10 = 0
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r13 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r12, r13)
            java.lang.Object r12 = r1.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r29)
            r8 = r12
            androidx.compose.ui.layout.PinnableContainer r8 = (androidx.compose.ui.layout.PinnableContainer) r8
            r9 = 0
            r10 = r9
            r9 = 0
            r12 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            r11 = 0
            r12 = r29
            r13 = 0
            java.lang.Object r15 = r12.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r20 = r9
            java.lang.Object r9 = r18.getEmpty()
            if (r15 != r9) goto L_0x025b
            r9 = 0
            r18 = r9
            r17 = r10
            r9 = 2
            r10 = 0
            androidx.compose.runtime.MutableState r9 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r10, r10, r9, r10)
            r12.updateRememberedValue(r9)
            goto L_0x025e
        L_0x025b:
            r17 = r10
            r9 = r15
        L_0x025e:
            r29.endReplaceableGroup()
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            r10 = 54
            r11 = 0
            r12 = 1618982084(0x607fb4c4, float:7.370227E19)
            r1.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r12)
            boolean r12 = r1.changed((java.lang.Object) r3)
            boolean r13 = r1.changed((java.lang.Object) r9)
            r12 = r12 | r13
            boolean r13 = r1.changed((java.lang.Object) r8)
            r12 = r12 | r13
            r13 = r29
            r15 = 0
            r16 = r10
            java.lang.Object r10 = r13.rememberedValue()
            r17 = 0
            if (r12 != 0) goto L_0x029c
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r20 = r11
            java.lang.Object r11 = r18.getEmpty()
            if (r10 != r11) goto L_0x0299
            goto L_0x029e
        L_0x0299:
            r18 = r10
            goto L_0x02ad
        L_0x029c:
            r20 = r11
        L_0x029e:
            r11 = 0
            r18 = r10
            androidx.compose.foundation.FocusableKt$focusable$2$3$1 r10 = new androidx.compose.foundation.FocusableKt$focusable$2$3$1
            r10.<init>(r8, r3, r9)
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r13.updateRememberedValue(r10)
        L_0x02ad:
            r29.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r11 = 0
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r8, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r10, (androidx.compose.runtime.Composer) r1, (int) r11)
            androidx.compose.ui.Modifier$Companion r10 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r10 = (androidx.compose.ui.Modifier) r10
            r11 = 54
            r12 = 0
            r13 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r1.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r14)
            boolean r13 = r1.changed((java.lang.Object) r3)
            boolean r14 = r1.changed((java.lang.Object) r5)
            r13 = r13 | r14
            r14 = r29
            r15 = 0
            java.lang.Object r1 = r14.rememberedValue()
            r16 = 0
            if (r13 != 0) goto L_0x02ea
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r18 = r11
            java.lang.Object r11 = r17.getEmpty()
            if (r1 != r11) goto L_0x02e7
            goto L_0x02ec
        L_0x02e7:
            r17 = r1
            goto L_0x02fb
        L_0x02ea:
            r18 = r11
        L_0x02ec:
            r11 = 0
            r17 = r1
            androidx.compose.foundation.FocusableKt$focusable$2$4$1 r1 = new androidx.compose.foundation.FocusableKt$focusable$2$4$1
            r1.<init>(r3, r5)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r14.updateRememberedValue(r1)
        L_0x02fb:
            r29.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r11 = 1
            r12 = 0
            r13 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r10, r13, r1, r11, r12)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.relocation.BringIntoViewRequesterKt.bringIntoViewRequester(r1, r7)
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.focus.FocusRequesterModifierKt.focusRequester(r1, r5)
            androidx.compose.ui.Modifier r1 = r1.then(r6)
            androidx.compose.foundation.FocusableKt$focusable$2$5 r10 = new androidx.compose.foundation.FocusableKt$focusable$2$5
            androidx.compose.foundation.interaction.MutableInteractionSource r11 = r0.$interactionSource
            r19 = r10
            r20 = r8
            r21 = r2
            r22 = r3
            r23 = r9
            r24 = r4
            r25 = r11
            r26 = r7
            r19.<init>(r20, r21, r22, r23, r24, r25, r26)
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.focus.FocusChangedModifierKt.onFocusChanged(r1, r10)
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.focus.FocusModifierKt.focusTarget(r1)
            goto L_0x033b
        L_0x0337:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
        L_0x033b:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x0344
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0344:
            r29.endReplaceableGroup()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.FocusableKt$focusable$2.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }

    /* access modifiers changed from: private */
    public static final boolean invoke$lambda$2(MutableState<Boolean> $isFocused$delegate) {
        return ((Boolean) $isFocused$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$3(MutableState<Boolean> $isFocused$delegate, boolean value) {
        $isFocused$delegate.setValue(Boolean.valueOf(value));
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$10(MutableState<PinnableContainer.PinnedHandle> $pinHandle$delegate, PinnableContainer.PinnedHandle value) {
        $pinHandle$delegate.setValue(value);
    }

    /* access modifiers changed from: private */
    public static final PinnableContainer.PinnedHandle invoke$lambda$9(MutableState<PinnableContainer.PinnedHandle> $pinHandle$delegate) {
        return (PinnableContainer.PinnedHandle) $pinHandle$delegate.getValue();
    }
}
