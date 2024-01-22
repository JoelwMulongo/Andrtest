package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class ClickableKt$combinedClickable$4 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Indication $indication;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ String $onClickLabel;
    final /* synthetic */ Function0<Unit> $onDoubleClick;
    final /* synthetic */ Function0<Unit> $onLongClick;
    final /* synthetic */ String $onLongClickLabel;
    final /* synthetic */ Role $role;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableKt$combinedClickable$4(Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, String str, Role role, String str2) {
        super(3);
        this.$onClick = function0;
        this.$onLongClick = function02;
        this.$onDoubleClick = function03;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
        this.$indication = indication;
        this.$onClickLabel = str;
        this.$role = role;
        this.$onLongClickLabel = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x025a A[LOOP:0: B:45:0x0258->B:46:0x025a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x02ca  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x033a  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0378  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r50, androidx.compose.runtime.Composer r51, int r52) {
        /*
            r49 = this;
            r0 = r49
            r1 = r51
            java.lang.String r2 = "$this$composed"
            r3 = r50
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            r2 = 1841718000(0x6dc662f0, float:7.674705E27)
            r1.startReplaceableGroup(r2)
            java.lang.String r4 = "C307@13021L29,308@13082L33,309@13149L35,312@13316L58,313@13417L56,332@14268L36,333@14352L33,334@14443L95,334@14422L116,337@14566L40,340@14722L1028,368@15803L445,383@16482L24:Clickable.kt#71ulvw"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r4)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0025
            r4 = -1
            java.lang.String r5 = "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:306)"
            r6 = r52
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r6, r4, r5)
            goto L_0x0027
        L_0x0025:
            r6 = r52
        L_0x0027:
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = r0.$onClick
            r4 = 0
            androidx.compose.runtime.State r2 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r2, r1, r4)
            kotlin.jvm.functions.Function0<kotlin.Unit> r5 = r0.$onLongClick
            androidx.compose.runtime.State r5 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r5, r1, r4)
            kotlin.jvm.functions.Function0<kotlin.Unit> r7 = r0.$onDoubleClick
            androidx.compose.runtime.State r29 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r7, r1, r4)
            kotlin.jvm.functions.Function0<kotlin.Unit> r7 = r0.$onLongClick
            if (r7 == 0) goto L_0x0041
            r21 = 1
            goto L_0x0043
        L_0x0041:
            r21 = r4
        L_0x0043:
            kotlin.jvm.functions.Function0<kotlin.Unit> r7 = r0.$onDoubleClick
            if (r7 == 0) goto L_0x004a
            r19 = 1
            goto L_0x004c
        L_0x004a:
            r19 = r4
        L_0x004c:
            r7 = r4
            r9 = 0
            r15 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r15)
            java.lang.String r14 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r14)
            r10 = 0
            r11 = r51
            r12 = 0
            java.lang.Object r13 = r11.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r17.getEmpty()
            r15 = 2
            r4 = 0
            if (r13 != r8) goto L_0x0078
            r8 = 0
            androidx.compose.runtime.MutableState r8 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r4, r15, r4)
            r11.updateRememberedValue(r8)
            goto L_0x0079
        L_0x0078:
            r8 = r13
        L_0x0079:
            r51.endReplaceableGroup()
            r13 = r8
            androidx.compose.runtime.MutableState r13 = (androidx.compose.runtime.MutableState) r13
            r7 = 0
            r8 = r7
            r7 = 0
            r9 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r14)
            r9 = 0
            r10 = r51
            r11 = 0
            java.lang.Object r12 = r10.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r20.getEmpty()
            if (r12 != r4) goto L_0x00ae
            r4 = 0
            java.util.LinkedHashMap r20 = new java.util.LinkedHashMap
            r20.<init>()
            java.util.Map r20 = (java.util.Map) r20
            r4 = r20
            r10.updateRememberedValue(r4)
            goto L_0x00af
        L_0x00ae:
            r4 = r12
        L_0x00af:
            r51.endReplaceableGroup()
            java.util.Map r4 = (java.util.Map) r4
            r7 = 1321107720(0x4ebe8108, float:1.59806362E9)
            r1.startReplaceableGroup(r7)
            java.lang.String r7 = "317@13690L342,317@13659L373,326@14045L170"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r7)
            boolean r7 = r0.$enabled
            java.lang.String r8 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            r9 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            if (r7 == 0) goto L_0x0121
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r21)
            androidx.compose.foundation.interaction.MutableInteractionSource r10 = r0.$interactionSource
            androidx.compose.foundation.interaction.MutableInteractionSource r11 = r0.$interactionSource
            r12 = 6
            r16 = 0
            r1.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r8)
            boolean r20 = r1.changed((java.lang.Object) r13)
            boolean r23 = r1.changed((java.lang.Object) r10)
            r20 = r20 | r23
            r23 = r51
            r24 = 0
            java.lang.Object r9 = r23.rememberedValue()
            r26 = 0
            if (r20 != 0) goto L_0x00fe
            androidx.compose.runtime.Composer$Companion r27 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r27.getEmpty()
            if (r9 != r15) goto L_0x00fa
            goto L_0x00fe
        L_0x00fa:
            r3 = r9
            r11 = r23
            goto L_0x010d
        L_0x00fe:
            r15 = 0
            androidx.compose.foundation.ClickableKt$combinedClickable$4$1$1 r3 = new androidx.compose.foundation.ClickableKt$combinedClickable$4$1$1
            r3.<init>(r13, r11)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r11 = r23
            r11.updateRememberedValue(r3)
        L_0x010d:
            r51.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r9 = 0
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r7, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r3, (androidx.compose.runtime.Composer) r1, (int) r9)
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r0.$interactionSource
            r7 = 560(0x230, float:7.85E-43)
            androidx.compose.foundation.ClickableKt.PressedInteractionSourceDisposableEffect(r3, r13, r4, r1, r7)
        L_0x0121:
            r51.endReplaceableGroup()
            r3 = 0
            kotlin.jvm.functions.Function0 r15 = androidx.compose.foundation.Clickable_androidKt.isComposeRootInScrollableContainer(r1, r3)
            r7 = r3
            r3 = 0
            r9 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r14)
            r9 = 0
            r10 = r51
            r11 = 0
            java.lang.Object r12 = r10.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r23 = r3
            java.lang.Object r3 = r20.getEmpty()
            if (r12 != r3) goto L_0x015f
            r3 = 0
            r20 = r3
            r18 = 1
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r18)
            r18 = r7
            r6 = 2
            r7 = 0
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r7, r6, r7)
            r10.updateRememberedValue(r3)
            goto L_0x0162
        L_0x015f:
            r18 = r7
            r3 = r12
        L_0x0162:
            r51.endReplaceableGroup()
            androidx.compose.runtime.MutableState r3 = (androidx.compose.runtime.MutableState) r3
            r6 = 6
            r7 = 0
            r9 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r1.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r8)
            boolean r8 = r1.changed((java.lang.Object) r3)
            boolean r9 = r1.changed((java.lang.Object) r15)
            r8 = r8 | r9
            r9 = r51
            r10 = 0
            java.lang.Object r11 = r9.rememberedValue()
            r12 = 0
            if (r8 != 0) goto L_0x0194
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r18 = r6
            java.lang.Object r6 = r16.getEmpty()
            if (r11 != r6) goto L_0x0192
            goto L_0x0196
        L_0x0192:
            r6 = r11
            goto L_0x01a5
        L_0x0194:
            r18 = r6
        L_0x0196:
            r6 = 0
            r16 = r6
            androidx.compose.foundation.ClickableKt$combinedClickable$4$delayPressInteraction$1$1 r6 = new androidx.compose.foundation.ClickableKt$combinedClickable$4$delayPressInteraction$1$1
            r6.<init>(r3, r15)
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r9.updateRememberedValue(r6)
        L_0x01a5:
            r51.endReplaceableGroup()
            r7 = 0
            androidx.compose.runtime.State r6 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r6, r1, r7)
            r8 = r7
            r7 = 0
            r12 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r14)
            r9 = 0
            r10 = r51
            r11 = 0
            java.lang.Object r12 = r10.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r20 = r7
            java.lang.Object r7 = r18.getEmpty()
            if (r12 != r7) goto L_0x01eb
            r7 = 0
            androidx.compose.ui.geometry.Offset$Companion r18 = androidx.compose.ui.geometry.Offset.Companion
            long r23 = r18.m2931getZeroF1C5BW0()
            r18 = r7
            androidx.compose.ui.geometry.Offset r7 = androidx.compose.ui.geometry.Offset.m2904boximpl(r23)
            r23 = r8
            r22 = r9
            r8 = 2
            r9 = 0
            androidx.compose.runtime.MutableState r7 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r7, r9, r8, r9)
            r10.updateRememberedValue(r7)
            goto L_0x01f0
        L_0x01eb:
            r23 = r8
            r22 = r9
            r7 = r12
        L_0x01f0:
            r51.endReplaceableGroup()
            r43 = r7
            androidx.compose.runtime.MutableState r43 = (androidx.compose.runtime.MutableState) r43
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            r12 = r7
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = r0.$interactionSource
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r21)
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r19)
            boolean r10 = r0.$enabled
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            java.lang.Object[] r11 = new java.lang.Object[]{r7, r8, r9, r10}
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r19)
            boolean r7 = r0.$enabled
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r7)
            java.lang.Boolean r16 = java.lang.Boolean.valueOf(r21)
            androidx.compose.foundation.interaction.MutableInteractionSource r10 = r0.$interactionSource
            r7 = r43
            r24 = r10
            r10 = r29
            r44 = r4
            r4 = r11
            r11 = r16
            r45 = r3
            r3 = r12
            r16 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12 = r5
            r46 = r13
            r13 = r24
            r47 = r14
            r14 = r46
            r48 = r15
            r15 = r6
            r16 = r2
            java.lang.Object[] r7 = new java.lang.Object[]{r7, r8, r9, r10, r11, r12, r13, r14, r15, r16}
            boolean r8 = r0.$enabled
            r9 = 8
            r10 = 0
            r11 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r1.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            r11 = 0
            int r12 = r7.length
            r13 = 0
        L_0x0258:
            if (r13 >= r12) goto L_0x0264
            r14 = r7[r13]
            boolean r15 = r1.changed((java.lang.Object) r14)
            r11 = r11 | r15
            int r13 = r13 + 1
            goto L_0x0258
        L_0x0264:
            r12 = r51
            r13 = 0
            java.lang.Object r14 = r12.rememberedValue()
            r15 = 0
            if (r11 != 0) goto L_0x027b
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r30 = r7
            java.lang.Object r7 = r16.getEmpty()
            if (r14 != r7) goto L_0x0279
            goto L_0x027d
        L_0x0279:
            r7 = r14
            goto L_0x029d
        L_0x027b:
            r30 = r7
        L_0x027d:
            r7 = 0
            androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$1 r16 = new androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$1
            r28 = 0
            r17 = r16
            r18 = r43
            r20 = r8
            r22 = r29
            r23 = r5
            r25 = r46
            r26 = r6
            r27 = r2
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            kotlin.jvm.functions.Function2 r16 = (kotlin.jvm.functions.Function2) r16
            r7 = r16
            r12.updateRememberedValue(r7)
        L_0x029d:
            r51.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            androidx.compose.ui.Modifier r31 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput((androidx.compose.ui.Modifier) r3, (java.lang.Object[]) r4, (kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r7)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            r4 = 0
            r7 = r4
            r4 = 0
            r8 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r8)
            r9 = r47
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r9)
            r10 = 0
            r11 = r51
            r12 = 0
            java.lang.Object r13 = r11.rememberedValue()
            r14 = 0
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r13 != r15) goto L_0x02da
            r15 = 0
            androidx.compose.foundation.ClickableKt$combinedClickable$4$2$1 r8 = new androidx.compose.foundation.ClickableKt$combinedClickable$4$2$1
            r16 = r2
            r2 = r45
            r8.<init>(r2)
            r11.updateRememberedValue(r8)
            goto L_0x02df
        L_0x02da:
            r16 = r2
            r2 = r45
            r8 = r13
        L_0x02df:
            r51.endReplaceableGroup()
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            androidx.compose.ui.Modifier r30 = r3.then(r8)
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r0.$interactionSource
            androidx.compose.foundation.Indication r4 = r0.$indication
            r7 = 0
            r8 = r7
            r10 = 0
            r11 = 773894976(0x2e20b340, float:3.6538994E-11)
            r1.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            r11 = r51
            r12 = 0
            r13 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r9)
            r9 = 0
            r13 = r51
            r14 = 0
            java.lang.Object r15 = r13.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r18.getEmpty()
            if (r15 != r1) goto L_0x033a
            r1 = 0
            r18 = 0
            kotlin.coroutines.EmptyCoroutineContext r18 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r20 = r1
            r1 = r18
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            kotlinx.coroutines.CoroutineScope r1 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r1, r11)
            r45 = r2
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r2.<init>(r1)
            r1 = r2
            r13.updateRememberedValue(r1)
            goto L_0x033d
        L_0x033a:
            r45 = r2
            r1 = r15
        L_0x033d:
            r51.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r1
            kotlinx.coroutines.CoroutineScope r34 = r1.getCoroutineScope()
            r51.endReplaceableGroup()
            r36 = r43
            androidx.compose.runtime.State r36 = (androidx.compose.runtime.State) r36
            boolean r1 = r0.$enabled
            java.lang.String r2 = r0.$onClickLabel
            androidx.compose.ui.semantics.Role r7 = r0.$role
            java.lang.String r8 = r0.$onLongClickLabel
            kotlin.jvm.functions.Function0<kotlin.Unit> r9 = r0.$onLongClick
            kotlin.jvm.functions.Function0<kotlin.Unit> r10 = r0.$onClick
            r32 = r3
            r33 = r4
            r35 = r44
            r37 = r1
            r38 = r2
            r39 = r7
            r40 = r8
            r41 = r9
            r42 = r10
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.ClickableKt.m478genericClickableWithoutGesturebdNGguI(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x037b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x037b:
            r51.endReplaceableGroup()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableKt$combinedClickable$4.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
