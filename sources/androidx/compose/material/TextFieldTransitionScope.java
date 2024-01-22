package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jµ\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2e\u0010\u000f\u001aa\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/material/TextFieldTransitionScope;", "", "()V", "Transition", "", "inputState", "Landroidx/compose/material/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "showLabel", "", "content", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "Transition-DTcfvLk", "(Landroidx/compose/material/InputPhase;JJLkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function6;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldTransitionScope {
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputPhase.values().length];
            try {
                iArr[InputPhase.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TextFieldTransitionScope() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:129:0x03ee  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03fd  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0400  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0408  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0430  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x043f  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0442  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x044a  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x04d9  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x04e6  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x05b1  */
    /* renamed from: Transition-DTcfvLk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1692TransitionDTcfvLk(androidx.compose.material.InputPhase r34, long r35, long r37, kotlin.jvm.functions.Function3<? super androidx.compose.material.InputPhase, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, androidx.compose.ui.graphics.Color> r39, boolean r40, kotlin.jvm.functions.Function6<? super java.lang.Float, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.ui.graphics.Color, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, int r43) {
        /*
            r33 = this;
            r11 = r34
            r12 = r39
            r13 = r40
            r14 = r41
            r15 = r43
            java.lang.String r0 = "inputState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "contentColor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1988729962(0x76899c6a, float:1.3955413E33)
            r1 = r42
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Transition)P(3,2:c#ui.graphics.Color,5:c#ui.graphics.Color,1,4)276@11184L59,278@11285L325,289@11657L1101,317@12806L299,327@13151L186,333@13347L140:TextFieldImpl.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r43
            r2 = r15 & 14
            if (r2 != 0) goto L_0x0038
            boolean r2 = r10.changed((java.lang.Object) r11)
            if (r2 == 0) goto L_0x0036
            r2 = 4
            goto L_0x0037
        L_0x0036:
            r2 = 2
        L_0x0037:
            r1 = r1 | r2
        L_0x0038:
            r2 = r15 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004b
            r8 = r35
            boolean r2 = r10.changed((long) r8)
            if (r2 == 0) goto L_0x0047
            r2 = 32
            goto L_0x0049
        L_0x0047:
            r2 = 16
        L_0x0049:
            r1 = r1 | r2
            goto L_0x004d
        L_0x004b:
            r8 = r35
        L_0x004d:
            r2 = r15 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0060
            r4 = r37
            boolean r2 = r10.changed((long) r4)
            if (r2 == 0) goto L_0x005c
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r2 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r1 = r1 | r2
            goto L_0x0062
        L_0x0060:
            r4 = r37
        L_0x0062:
            r2 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0072
            boolean r2 = r10.changedInstance(r12)
            if (r2 == 0) goto L_0x006f
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0071
        L_0x006f:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0071:
            r1 = r1 | r2
        L_0x0072:
            r16 = 57344(0xe000, float:8.0356E-41)
            r2 = r15 & r16
            if (r2 != 0) goto L_0x0085
            boolean r2 = r10.changed((boolean) r13)
            if (r2 == 0) goto L_0x0082
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0084
        L_0x0082:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x0084:
            r1 = r1 | r2
        L_0x0085:
            r17 = 458752(0x70000, float:6.42848E-40)
            r2 = r15 & r17
            if (r2 != 0) goto L_0x0097
            boolean r2 = r10.changedInstance(r14)
            if (r2 == 0) goto L_0x0094
            r2 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0096
        L_0x0094:
            r2 = 65536(0x10000, float:9.18355E-41)
        L_0x0096:
            r1 = r1 | r2
        L_0x0097:
            r7 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r7
            r2 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r2) goto L_0x00ae
            boolean r1 = r10.getSkipping()
            if (r1 != 0) goto L_0x00a8
            goto L_0x00ae
        L_0x00a8:
            r10.skipToGroupEnd()
            r11 = r7
            goto L_0x05b4
        L_0x00ae:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r3 = -1
            if (r1 == 0) goto L_0x00ba
            java.lang.String r1 = "androidx.compose.material.TextFieldTransitionScope.Transition (TextFieldImpl.kt:260)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r7, r3, r1)
        L_0x00ba:
            r0 = r7 & 14
            r0 = r0 | 48
            r1 = 0
            java.lang.String r2 = "TextFieldInputState"
            androidx.compose.animation.core.Transition r18 = androidx.compose.animation.core.TransitionKt.updateTransition(r11, (java.lang.String) r2, (androidx.compose.runtime.Composer) r10, (int) r0, (int) r1)
            androidx.compose.material.TextFieldTransitionScope$Transition$labelProgress$2 r0 = androidx.compose.material.TextFieldTransitionScope$Transition$labelProgress$2.INSTANCE
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r19 = r18
            java.lang.String r6 = "LabelProgress"
            r2 = 384(0x180, float:5.38E-43)
            r20 = r2
            r21 = 0
            r1 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "C(animateFloat)P(2)933@37134L78:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            kotlin.jvm.internal.FloatCompanionObject r1 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r22 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r1)
            r1 = r20 & 14
            int r2 = r20 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r20 << 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r20 << 3
            r2 = r2 & r16
            r2 = r2 | r1
            r1 = r19
            r23 = r2
            r24 = 0
            r2 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r10.startReplaceableGroup(r2)
            java.lang.String r3 = "C(animateValue)P(3,2)851@33724L32,852@33779L31,853@33835L23,855@33871L89:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r3)
            java.lang.Object r26 = r1.getCurrentState()
            int r27 = r23 >> 9
            r2 = r27 & 112(0x70, float:1.57E-43)
            androidx.compose.material.InputPhase r26 = (androidx.compose.material.InputPhase) r26
            r27 = r10
            r29 = 0
            r30 = r3
            r3 = -1158004136(0xffffffffbafa4258, float:-0.0019093258)
            r4 = r27
            r4.startReplaceableGroup(r3)
            java.lang.String r5 = "C:TextFieldImpl.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            boolean r27 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r27 == 0) goto L_0x0134
            r27 = r7
            java.lang.String r7 = "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:281)"
            r8 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r2, r8, r7)
            goto L_0x0136
        L_0x0134:
            r27 = r7
        L_0x0136:
            int[] r7 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r8 = r26.ordinal()
            r7 = r7[r8]
            r31 = 1065353216(0x3f800000, float:1.0)
            switch(r7) {
                case 1: goto L_0x0152;
                case 2: goto L_0x0150;
                case 3: goto L_0x014d;
                default: goto L_0x0143;
            }
        L_0x0143:
            r11 = r27
            r27 = r0
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x014d:
            r7 = r31
            goto L_0x0154
        L_0x0150:
            r7 = 0
            goto L_0x0154
        L_0x0152:
            r7 = r31
        L_0x0154:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x015d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x015d:
            r4.endReplaceableGroup()
            java.lang.Float r2 = java.lang.Float.valueOf(r7)
            r7 = 384(0x180, float:5.38E-43)
            r8 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            java.lang.Object r4 = r1.getTargetState()
            int r26 = r23 >> 9
            r7 = r26 & 112(0x70, float:1.57E-43)
            androidx.compose.material.InputPhase r4 = (androidx.compose.material.InputPhase) r4
            r26 = r10
            r28 = 0
            r8 = r26
            r8.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r5)
            boolean r26 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r26 == 0) goto L_0x018e
            java.lang.String r9 = "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:281)"
            r32 = r5
            r5 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r7, r5, r9)
            goto L_0x0191
        L_0x018e:
            r32 = r5
            r5 = -1
        L_0x0191:
            int[] r3 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r9 = r4.ordinal()
            r3 = r3[r9]
            switch(r3) {
                case 1: goto L_0x01ab;
                case 2: goto L_0x01a9;
                case 3: goto L_0x01a6;
                default: goto L_0x019c;
            }
        L_0x019c:
            r11 = r27
            r27 = r0
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01a6:
            r3 = r31
            goto L_0x01ad
        L_0x01a9:
            r3 = 0
            goto L_0x01ad
        L_0x01ab:
            r3 = r31
        L_0x01ad:
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x01b6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01b6:
            r8.endReplaceableGroup()
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            r8 = r5
            r9 = r30
            androidx.compose.animation.core.Transition$Segment r4 = r1.getSegment()
            int r5 = r23 >> 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r4 = r0.invoke(r4, r10, r5)
            r25 = r4
            androidx.compose.animation.core.FiniteAnimationSpec r25 = (androidx.compose.animation.core.FiniteAnimationSpec) r25
            r4 = r23 & 14
            int r5 = r23 << 9
            r5 = r5 & r16
            r4 = r4 | r5
            int r5 = r23 << 6
            r5 = r5 & r17
            r26 = r4 | r5
            r4 = r25
            r7 = r32
            r5 = r22
            r11 = r27
            r42 = 384(0x180, float:5.38E-43)
            r27 = r0
            r0 = r7
            r7 = r10
            r14 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r8 = r26
            androidx.compose.runtime.State r4 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            r19 = r4
            androidx.compose.material.TextFieldTransitionScope$Transition$placeholderOpacity$2 r1 = androidx.compose.material.TextFieldTransitionScope$Transition$placeholderOpacity$2.INSTANCE
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r20 = r18
            r8 = r1
            java.lang.String r6 = "PlaceholderOpacity"
            r21 = r42
            r22 = 0
            r1 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "C(animateFloat)P(2)933@37134L78:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            kotlin.jvm.internal.FloatCompanionObject r1 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r23 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r1)
            r1 = r21 & 14
            int r2 = r21 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r21 << 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r21 << 3
            r2 = r2 & r16
            r24 = r1 | r2
            r1 = r20
            r25 = 0
            r10.startReplaceableGroup(r14)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r9)
            java.lang.Object r2 = r1.getCurrentState()
            int r3 = r24 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            androidx.compose.material.InputPhase r2 = (androidx.compose.material.InputPhase) r2
            r4 = r10
            r5 = 0
            r7 = -1376159017(0xffffffffadf97ad7, float:-2.8362574E-11)
            r4.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r0)
            boolean r26 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r26 == 0) goto L_0x025d
            java.lang.String r14 = "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:309)"
            r15 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r3, r15, r14)
            goto L_0x025e
        L_0x025d:
            r15 = -1
        L_0x025e:
            int[] r14 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r26 = r2.ordinal()
            r14 = r14[r26]
            switch(r14) {
                case 1: goto L_0x0278;
                case 2: goto L_0x0271;
                case 3: goto L_0x026f;
                default: goto L_0x0269;
            }
        L_0x0269:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x026f:
            r14 = 0
            goto L_0x027a
        L_0x0271:
            if (r13 == 0) goto L_0x0275
            r14 = 0
            goto L_0x027a
        L_0x0275:
            r14 = r31
            goto L_0x027a
        L_0x0278:
            r14 = r31
        L_0x027a:
            boolean r26 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r26 == 0) goto L_0x0283
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0283:
            r4.endReplaceableGroup()
            java.lang.Float r2 = java.lang.Float.valueOf(r14)
            java.lang.Object r3 = r1.getTargetState()
            int r4 = r24 >> 9
            r4 = r4 & 112(0x70, float:1.57E-43)
            androidx.compose.material.InputPhase r3 = (androidx.compose.material.InputPhase) r3
            r5 = r10
            r14 = 0
            r5.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r0)
            boolean r26 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r26 == 0) goto L_0x02ab
            r26 = r14
            java.lang.String r14 = "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:309)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r4, r15, r14)
            goto L_0x02ad
        L_0x02ab:
            r26 = r14
        L_0x02ad:
            int[] r7 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r14 = r3.ordinal()
            r7 = r7[r14]
            switch(r7) {
                case 1: goto L_0x02c6;
                case 2: goto L_0x02c1;
                case 3: goto L_0x02be;
                default: goto L_0x02b8;
            }
        L_0x02b8:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x02be:
            r31 = 0
            goto L_0x02c7
        L_0x02c1:
            if (r13 == 0) goto L_0x02c7
            r31 = 0
            goto L_0x02c7
        L_0x02c6:
        L_0x02c7:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x02d0
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02d0:
            r5.endReplaceableGroup()
            java.lang.Float r3 = java.lang.Float.valueOf(r31)
            androidx.compose.animation.core.Transition$Segment r4 = r1.getSegment()
            int r5 = r24 >> 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r4 = r8.invoke(r4, r10, r5)
            r14 = r4
            androidx.compose.animation.core.FiniteAnimationSpec r14 = (androidx.compose.animation.core.FiniteAnimationSpec) r14
            r4 = r24 & 14
            int r5 = r24 << 9
            r5 = r5 & r16
            r4 = r4 | r5
            int r5 = r24 << 6
            r5 = r5 & r17
            r26 = r4 | r5
            r4 = r14
            r5 = r23
            r7 = r10
            r27 = r8
            r8 = r26
            androidx.compose.runtime.State r4 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            r14 = r4
            androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2 r1 = androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2.INSTANCE
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r20 = r18
            r8 = r1
            r21 = r42
            java.lang.String r6 = "LabelTextStyleColor"
            r22 = 0
            r1 = -1939694975(0xffffffff8c629a81, float:-1.7456901E-31)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "C(animateColor)P(2)68@3224L31,69@3291L70,73@3374L70:Transition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            java.lang.Object r1 = r20.getTargetState()
            int r2 = r21 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            androidx.compose.material.InputPhase r1 = (androidx.compose.material.InputPhase) r1
            r3 = r10
            r4 = 0
            r5 = -1490209928(0xffffffffa72d3378, float:-2.4036474E-15)
            r3.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r0)
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            java.lang.String r5 = "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:320)"
            if (r7 == 0) goto L_0x0347
            r7 = -1490209928(0xffffffffa72d3378, float:-2.4036474E-15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r2, r15, r5)
        L_0x0347:
            int[] r7 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r24 = r1.ordinal()
            r7 = r7[r24]
            r15 = 1
            if (r7 != r15) goto L_0x0355
            r24 = r35
            goto L_0x0357
        L_0x0355:
            r24 = r37
        L_0x0357:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0360
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0360:
            r3.endReplaceableGroup()
            androidx.compose.ui.graphics.colorspace.ColorSpace r7 = androidx.compose.ui.graphics.Color.m3168getColorSpaceimpl(r24)
            r1 = 8
            r2 = 0
            r3 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r3)
            boolean r3 = r10.changed((java.lang.Object) r7)
            r4 = r10
            r24 = 0
            java.lang.Object r15 = r4.rememberedValue()
            r26 = 0
            if (r3 != 0) goto L_0x0391
            androidx.compose.runtime.Composer$Companion r27 = androidx.compose.runtime.Composer.Companion
            r29 = r1
            java.lang.Object r1 = r27.getEmpty()
            if (r15 != r1) goto L_0x038f
            goto L_0x0393
        L_0x038f:
            r1 = r15
            goto L_0x03a6
        L_0x0391:
            r29 = r1
        L_0x0393:
            r1 = 0
            androidx.compose.ui.graphics.Color$Companion r27 = androidx.compose.ui.graphics.Color.Companion
            r30 = r1
            kotlin.jvm.functions.Function1 r1 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r27)
            java.lang.Object r1 = r1.invoke(r7)
            androidx.compose.animation.core.TwoWayConverter r1 = (androidx.compose.animation.core.TwoWayConverter) r1
            r4.updateRememberedValue(r1)
        L_0x03a6:
            r10.endReplaceableGroup()
            r15 = r1
            androidx.compose.animation.core.TwoWayConverter r15 = (androidx.compose.animation.core.TwoWayConverter) r15
            r1 = r21 & 14
            r1 = r1 | 64
            int r2 = r21 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r21 << 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r21 << 3
            r2 = r2 & r16
            r2 = r2 | r1
            r1 = r20
            r24 = r2
            r26 = 0
            r2 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r10.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r9)
            java.lang.Object r2 = r1.getCurrentState()
            int r3 = r24 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            androidx.compose.material.InputPhase r2 = (androidx.compose.material.InputPhase) r2
            r4 = r10
            r27 = 0
            r29 = r7
            r7 = -1490209928(0xffffffffa72d3378, float:-2.4036474E-15)
            r4.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r0)
            boolean r23 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r23 == 0) goto L_0x03f2
            r13 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r3, r13, r5)
        L_0x03f2:
            int[] r7 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r13 = r2.ordinal()
            r7 = r7[r13]
            r13 = 1
            if (r7 != r13) goto L_0x0400
            r30 = r35
            goto L_0x0402
        L_0x0400:
            r30 = r37
        L_0x0402:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x040b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x040b:
            r4.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m3154boximpl(r30)
            java.lang.Object r3 = r1.getTargetState()
            int r4 = r24 >> 9
            r4 = r4 & 112(0x70, float:1.57E-43)
            androidx.compose.material.InputPhase r3 = (androidx.compose.material.InputPhase) r3
            r7 = r10
            r13 = 0
            r27 = r13
            r13 = -1490209928(0xffffffffa72d3378, float:-2.4036474E-15)
            r7.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0434
            r0 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r4, r0, r5)
        L_0x0434:
            int[] r0 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r5 = r3.ordinal()
            r0 = r0[r5]
            r5 = 1
            if (r0 != r5) goto L_0x0442
            r30 = r35
            goto L_0x0444
        L_0x0442:
            r30 = r37
        L_0x0444:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x044d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x044d:
            r7.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m3154boximpl(r30)
            androidx.compose.animation.core.Transition$Segment r0 = r1.getSegment()
            int r4 = r24 >> 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r0 = r8.invoke(r0, r10, r4)
            androidx.compose.animation.core.FiniteAnimationSpec r0 = (androidx.compose.animation.core.FiniteAnimationSpec) r0
            r4 = r24 & 14
            int r5 = r24 << 9
            r5 = r5 & r16
            r4 = r4 | r5
            int r5 = r24 << 6
            r5 = r5 & r17
            r13 = r4 | r5
            r4 = r0
            r5 = r15
            r23 = r29
            r7 = r10
            r25 = r8
            r8 = r13
            androidx.compose.runtime.State r4 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            r13 = r4
            androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2 r0 = androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2.INSTANCE
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r1 = r11 & 7168(0x1c00, float:1.0045E-41)
            r2 = r42
            r1 = r1 | r2
            r15 = r18
            java.lang.String r6 = "LabelContentColor"
            r20 = r1
            r21 = 0
            r1 = -1939694975(0xffffffff8c629a81, float:-1.7456901E-31)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "C(animateColor)P(2)68@3224L31,69@3291L70,73@3374L70:Transition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            java.lang.Object r1 = r15.getTargetState()
            int r2 = r20 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r1 = r12.invoke(r1, r10, r2)
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m3174unboximpl()
            androidx.compose.ui.graphics.colorspace.ColorSpace r8 = androidx.compose.ui.graphics.Color.m3168getColorSpaceimpl(r1)
            r1 = 8
            r2 = 0
            r3 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r3)
            boolean r3 = r10.changed((java.lang.Object) r8)
            r4 = r10
            r5 = 0
            java.lang.Object r7 = r4.rememberedValue()
            r22 = 0
            if (r3 != 0) goto L_0x04e6
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r42 = r1
            java.lang.Object r1 = r23.getEmpty()
            if (r7 != r1) goto L_0x04e4
            goto L_0x04e8
        L_0x04e4:
            r1 = r7
            goto L_0x04fb
        L_0x04e6:
            r42 = r1
        L_0x04e8:
            r1 = 0
            androidx.compose.ui.graphics.Color$Companion r23 = androidx.compose.ui.graphics.Color.Companion
            r24 = r1
            kotlin.jvm.functions.Function1 r1 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r23)
            java.lang.Object r1 = r1.invoke(r8)
            androidx.compose.animation.core.TwoWayConverter r1 = (androidx.compose.animation.core.TwoWayConverter) r1
            r4.updateRememberedValue(r1)
        L_0x04fb:
            r10.endReplaceableGroup()
            r22 = r1
            androidx.compose.animation.core.TwoWayConverter r22 = (androidx.compose.animation.core.TwoWayConverter) r22
            r1 = r20 & 14
            r1 = r1 | 64
            int r2 = r20 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r20 << 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r20 << 3
            r2 = r2 & r16
            r23 = r1 | r2
            r1 = r15
            r24 = 0
            r2 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r10.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r9)
            java.lang.Object r2 = r1.getCurrentState()
            int r3 = r23 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r9 = r12.invoke(r2, r10, r3)
            java.lang.Object r2 = r1.getTargetState()
            int r3 = r23 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r25 = r12.invoke(r2, r10, r3)
            androidx.compose.animation.core.Transition$Segment r2 = r1.getSegment()
            int r3 = r23 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r2 = r0.invoke(r2, r10, r3)
            r26 = r2
            androidx.compose.animation.core.FiniteAnimationSpec r26 = (androidx.compose.animation.core.FiniteAnimationSpec) r26
            r2 = r23 & 14
            int r3 = r23 << 9
            r3 = r3 & r16
            r2 = r2 | r3
            int r3 = r23 << 6
            r3 = r3 & r17
            r17 = r2 | r3
            r2 = r9
            r3 = r25
            r4 = r26
            r5 = r22
            r7 = r10
            r27 = r8
            r8 = r17
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            r7 = r2
            float r0 = Transition_DTcfvLk$lambda$1(r19)
            java.lang.Float r1 = java.lang.Float.valueOf(r0)
            long r2 = Transition_DTcfvLk$lambda$5(r13)
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m3154boximpl(r2)
            long r3 = Transition_DTcfvLk$lambda$6(r7)
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m3154boximpl(r3)
            float r0 = Transition_DTcfvLk$lambda$3(r14)
            java.lang.Float r4 = java.lang.Float.valueOf(r0)
            int r0 = r11 >> 3
            r0 = r0 & r16
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
            r0 = r41
            r5 = r10
            r0.invoke(r1, r2, r3, r4, r5, r6)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x05b4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x05b4:
            androidx.compose.runtime.ScopeUpdateScope r13 = r10.endRestartGroup()
            if (r13 != 0) goto L_0x05bc
            r15 = r10
            goto L_0x05d8
        L_0x05bc:
            androidx.compose.material.TextFieldTransitionScope$Transition$1 r14 = new androidx.compose.material.TextFieldTransitionScope$Transition$1
            r0 = r14
            r1 = r33
            r2 = r34
            r3 = r35
            r5 = r37
            r7 = r39
            r8 = r40
            r9 = r41
            r15 = r10
            r10 = r43
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x05d8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldTransitionScope.m1692TransitionDTcfvLk(androidx.compose.material.InputPhase, long, long, kotlin.jvm.functions.Function3, boolean, kotlin.jvm.functions.Function6, androidx.compose.runtime.Composer, int):void");
    }

    private static final float Transition_DTcfvLk$lambda$1(State<Float> $labelProgress$delegate) {
        return ((Number) $labelProgress$delegate.getValue()).floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$3(State<Float> $placeholderOpacity$delegate) {
        return ((Number) $placeholderOpacity$delegate.getValue()).floatValue();
    }

    private static final long Transition_DTcfvLk$lambda$5(State<Color> $labelTextStyleColor$delegate) {
        return ((Color) $labelTextStyleColor$delegate.getValue()).m3174unboximpl();
    }

    private static final long Transition_DTcfvLk$lambda$6(State<Color> $labelContentColor$delegate) {
        return ((Color) $labelContentColor$delegate.getValue()).m3174unboximpl();
    }
}
