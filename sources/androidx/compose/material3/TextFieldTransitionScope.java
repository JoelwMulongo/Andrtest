package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jµ\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2e\u0010\u000f\u001aa\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/TextFieldTransitionScope;", "", "()V", "Transition", "", "inputState", "Landroidx/compose/material3/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "showLabel", "", "content", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "Transition-DTcfvLk", "(Landroidx/compose/material3/InputPhase;JJLkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function6;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldTransitionScope {
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TextFieldImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputPhase.values().length];
            iArr[InputPhase.Focused.ordinal()] = 1;
            iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TextFieldTransitionScope() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:130:0x03fa  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0409  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x040c  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0414  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x043b  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x044a  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x044d  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0455  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x04eb  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x04f8  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x05c4  */
    /* renamed from: Transition-DTcfvLk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2176TransitionDTcfvLk(androidx.compose.material3.InputPhase r35, long r36, long r38, kotlin.jvm.functions.Function3<? super androidx.compose.material3.InputPhase, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, androidx.compose.ui.graphics.Color> r40, boolean r41, kotlin.jvm.functions.Function6<? super java.lang.Float, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.ui.graphics.Color, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, androidx.compose.runtime.Composer r43, int r44) {
        /*
            r34 = this;
            r11 = r35
            r12 = r40
            r13 = r41
            r14 = r42
            r15 = r44
            java.lang.String r0 = "inputState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "contentColor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -1933643487(0xffffffff8cbef121, float:-2.941926E-31)
            r1 = r43
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Transition)P(3,2:c#ui.graphics.Color,5:c#ui.graphics.Color,1,4)271@11066L59,273@11167L325,284@11539L1101,312@12688L299,322@13033L186,328@13229L140:TextFieldImpl.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r44
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
            r8 = r36
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
            r8 = r36
        L_0x004d:
            r2 = r15 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0060
            r4 = r38
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
            r4 = r38
        L_0x0062:
            r2 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0072
            boolean r2 = r10.changed((java.lang.Object) r12)
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
            boolean r2 = r10.changed((java.lang.Object) r14)
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
            goto L_0x05c7
        L_0x00ae:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r3 = -1
            if (r1 == 0) goto L_0x00ba
            java.lang.String r1 = "androidx.compose.material3.TextFieldTransitionScope.Transition (TextFieldImpl.kt:255)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r7, r3, r1)
        L_0x00ba:
            r0 = r7 & 14
            r0 = r0 | 48
            r1 = 0
            java.lang.String r2 = "TextFieldInputState"
            androidx.compose.animation.core.Transition r18 = androidx.compose.animation.core.TransitionKt.updateTransition(r11, (java.lang.String) r2, (androidx.compose.runtime.Composer) r10, (int) r0, (int) r1)
            androidx.compose.material3.TextFieldTransitionScope$Transition$labelProgress$2 r0 = androidx.compose.material3.TextFieldTransitionScope$Transition$labelProgress$2.INSTANCE
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r19 = r18
            java.lang.String r6 = "LabelProgress"
            r2 = 384(0x180, float:5.38E-43)
            r20 = r2
            r21 = 0
            r1 = 1399891485(0x5370a61d, float:1.03357907E12)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli"
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
            r23 = r1 | r2
            r1 = r19
            r24 = 0
            r2 = 1847725064(0x6e220c08, float:1.2537779E28)
            r10.startReplaceableGroup(r2)
            java.lang.String r3 = "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r3)
            java.lang.Object r26 = r1.getCurrentState()
            int r27 = r23 >> 9
            r2 = r27 & 112(0x70, float:1.57E-43)
            androidx.compose.material3.InputPhase r26 = (androidx.compose.material3.InputPhase) r26
            r27 = r10
            r29 = 0
            r30 = r3
            r3 = -698152717(0xffffffffd66308f3, float:-6.2406894E13)
            r4 = r27
            r4.startReplaceableGroup(r3)
            java.lang.String r5 = "C:TextFieldImpl.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            boolean r27 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r27 == 0) goto L_0x0133
            r27 = r7
            java.lang.String r7 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:276)"
            r8 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r2, r8, r7)
            goto L_0x0135
        L_0x0133:
            r27 = r7
        L_0x0135:
            int[] r7 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r8 = r26.ordinal()
            r7 = r7[r8]
            r31 = 1065353216(0x3f800000, float:1.0)
            switch(r7) {
                case 1: goto L_0x014f;
                case 2: goto L_0x014d;
                case 3: goto L_0x014a;
                default: goto L_0x0142;
            }
        L_0x0142:
            r43 = r0
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x014a:
            r7 = r31
            goto L_0x0151
        L_0x014d:
            r7 = 0
            goto L_0x0151
        L_0x014f:
            r7 = r31
        L_0x0151:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x015a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x015a:
            r4.endReplaceableGroup()
            java.lang.Float r26 = java.lang.Float.valueOf(r7)
            java.lang.Object r2 = r1.getTargetState()
            int r4 = r23 >> 9
            r4 = r4 & 112(0x70, float:1.57E-43)
            androidx.compose.material3.InputPhase r2 = (androidx.compose.material3.InputPhase) r2
            r7 = r10
            r8 = 0
            r7.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r5)
            boolean r29 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r29 == 0) goto L_0x0182
            java.lang.String r9 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:276)"
            r33 = r5
            r5 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r4, r5, r9)
            goto L_0x0185
        L_0x0182:
            r33 = r5
            r5 = -1
        L_0x0185:
            int[] r3 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r9 = r2.ordinal()
            r3 = r3[r9]
            switch(r3) {
                case 1: goto L_0x019d;
                case 2: goto L_0x019b;
                case 3: goto L_0x0198;
                default: goto L_0x0190;
            }
        L_0x0190:
            r43 = r0
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0198:
            r3 = r31
            goto L_0x019f
        L_0x019b:
            r3 = 0
            goto L_0x019f
        L_0x019d:
            r3 = r31
        L_0x019f:
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x01a8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01a8:
            r7.endReplaceableGroup()
            java.lang.Float r9 = java.lang.Float.valueOf(r3)
            androidx.compose.animation.core.Transition$Segment r2 = r1.getSegment()
            int r3 = r23 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r2 = r0.invoke(r2, r10, r3)
            r25 = r2
            androidx.compose.animation.core.FiniteAnimationSpec r25 = (androidx.compose.animation.core.FiniteAnimationSpec) r25
            r2 = r23 & 14
            int r3 = r23 << 9
            r3 = r3 & r16
            r2 = r2 | r3
            int r3 = r23 << 6
            r3 = r3 & r17
            r8 = r2 | r3
            r4 = 384(0x180, float:5.38E-43)
            r7 = 1847725064(0x6e220c08, float:1.2537779E28)
            r2 = r26
            r43 = r0
            r0 = r5
            r5 = r30
            r3 = r9
            r28 = r4
            r4 = r25
            r0 = r5
            r30 = r9
            r9 = r33
            r5 = r22
            r14 = r7
            r11 = r27
            r7 = r10
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            r19 = r2
            androidx.compose.material3.TextFieldTransitionScope$Transition$placeholderOpacity$2 r1 = androidx.compose.material3.TextFieldTransitionScope$Transition$placeholderOpacity$2.INSTANCE
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r20 = r18
            r8 = r1
            java.lang.String r6 = "PlaceholderOpacity"
            r21 = r28
            r22 = 0
            r1 = 1399891485(0x5370a61d, float:1.03357907E12)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli"
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
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            java.lang.Object r2 = r1.getCurrentState()
            int r3 = r24 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            androidx.compose.material3.InputPhase r2 = (androidx.compose.material3.InputPhase) r2
            r4 = r10
            r5 = 0
            r7 = 1128980564(0x434ae054, float:202.87628)
            r4.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r9)
            boolean r26 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r26 == 0) goto L_0x0257
            java.lang.String r14 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:304)"
            r43 = r5
            r5 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r3, r5, r14)
            goto L_0x0259
        L_0x0257:
            r43 = r5
        L_0x0259:
            int[] r5 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r14 = r2.ordinal()
            r5 = r5[r14]
            switch(r5) {
                case 1: goto L_0x0273;
                case 2: goto L_0x026c;
                case 3: goto L_0x026a;
                default: goto L_0x0264;
            }
        L_0x0264:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x026a:
            r5 = 0
            goto L_0x0275
        L_0x026c:
            if (r13 == 0) goto L_0x0270
            r5 = 0
            goto L_0x0275
        L_0x0270:
            r5 = r31
            goto L_0x0275
        L_0x0273:
            r5 = r31
        L_0x0275:
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x027e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x027e:
            r4.endReplaceableGroup()
            java.lang.Float r14 = java.lang.Float.valueOf(r5)
            java.lang.Object r2 = r1.getTargetState()
            int r3 = r24 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            androidx.compose.material3.InputPhase r2 = (androidx.compose.material3.InputPhase) r2
            r4 = r10
            r5 = 0
            r4.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r9)
            boolean r26 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r26 == 0) goto L_0x02a6
            r43 = r5
            java.lang.String r5 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:304)"
            r15 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r3, r15, r5)
            goto L_0x02a8
        L_0x02a6:
            r43 = r5
        L_0x02a8:
            int[] r5 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r7 = r2.ordinal()
            r5 = r5[r7]
            switch(r5) {
                case 1: goto L_0x02c1;
                case 2: goto L_0x02bc;
                case 3: goto L_0x02b9;
                default: goto L_0x02b3;
            }
        L_0x02b3:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x02b9:
            r31 = 0
            goto L_0x02c2
        L_0x02bc:
            if (r13 == 0) goto L_0x02c2
            r31 = 0
            goto L_0x02c2
        L_0x02c1:
        L_0x02c2:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x02cb
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02cb:
            r4.endReplaceableGroup()
            java.lang.Float r15 = java.lang.Float.valueOf(r31)
            androidx.compose.animation.core.Transition$Segment r2 = r1.getSegment()
            int r3 = r24 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r2 = r8.invoke(r2, r10, r3)
            r26 = r2
            androidx.compose.animation.core.FiniteAnimationSpec r26 = (androidx.compose.animation.core.FiniteAnimationSpec) r26
            r2 = r24 & 14
            int r3 = r24 << 9
            r3 = r3 & r16
            r2 = r2 | r3
            int r3 = r24 << 6
            r3 = r3 & r17
            r30 = r2 | r3
            r2 = r14
            r3 = r15
            r4 = r26
            r5 = r23
            r7 = r10
            r31 = r8
            r8 = r30
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            r14 = r2
            androidx.compose.material3.TextFieldTransitionScope$Transition$labelTextStyleColor$2 r1 = androidx.compose.material3.TextFieldTransitionScope$Transition$labelTextStyleColor$2.INSTANCE
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r15 = r18
            r8 = r1
            r20 = r28
            java.lang.String r6 = "LabelTextStyleColor"
            r21 = 0
            r1 = -1462136984(0xffffffffa8d98f68, float:-2.4154032E-14)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "C(animateColor)P(2)68@3224L31,69@3291L70,73@3374L70:Transition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            java.lang.Object r1 = r15.getTargetState()
            int r2 = r20 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            androidx.compose.material3.InputPhase r1 = (androidx.compose.material3.InputPhase) r1
            r3 = r10
            r4 = 0
            r5 = 1888369619(0x708e3bd3, float:3.5215356E29)
            r3.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r9)
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            java.lang.String r5 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:315)"
            if (r7 == 0) goto L_0x0349
            r22 = r4
            r4 = -1
            r7 = 1888369619(0x708e3bd3, float:3.5215356E29)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r2, r4, r5)
            goto L_0x034b
        L_0x0349:
            r22 = r4
        L_0x034b:
            int[] r4 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r7 = r1.ordinal()
            r4 = r4[r7]
            r7 = 1
            if (r4 != r7) goto L_0x0359
            r23 = r36
            goto L_0x035b
        L_0x0359:
            r23 = r38
        L_0x035b:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0364
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0364:
            r3.endReplaceableGroup()
            androidx.compose.ui.graphics.colorspace.ColorSpace r4 = androidx.compose.ui.graphics.Color.m3168getColorSpaceimpl(r23)
            r1 = 8
            r2 = 0
            r3 = -3686930(0xffffffffffc7bdee, float:NaN)
            r10.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r3)
            boolean r3 = r10.changed((java.lang.Object) r4)
            r22 = r10
            r23 = 0
            java.lang.Object r7 = r22.rememberedValue()
            r25 = 0
            if (r3 != 0) goto L_0x039a
            androidx.compose.runtime.Composer$Companion r26 = androidx.compose.runtime.Composer.Companion
            r30 = r1
            java.lang.Object r1 = r26.getEmpty()
            if (r7 != r1) goto L_0x0394
            goto L_0x039c
        L_0x0394:
            r26 = r2
            r1 = r7
            r2 = r22
            goto L_0x03b3
        L_0x039a:
            r30 = r1
        L_0x039c:
            r1 = 0
            androidx.compose.ui.graphics.Color$Companion r26 = androidx.compose.ui.graphics.Color.Companion
            r31 = r1
            kotlin.jvm.functions.Function1 r1 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r26)
            java.lang.Object r1 = r1.invoke(r4)
            androidx.compose.animation.core.TwoWayConverter r1 = (androidx.compose.animation.core.TwoWayConverter) r1
            r26 = r2
            r2 = r22
            r2.updateRememberedValue(r1)
        L_0x03b3:
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
            r25 = 0
            r2 = 1847725064(0x6e220c08, float:1.2537779E28)
            r10.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            java.lang.Object r2 = r1.getCurrentState()
            int r3 = r23 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            androidx.compose.material3.InputPhase r2 = (androidx.compose.material3.InputPhase) r2
            r7 = r10
            r26 = 0
            r30 = r4
            r4 = 1888369619(0x708e3bd3, float:3.5215356E29)
            r7.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r9)
            boolean r31 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r31 == 0) goto L_0x03fe
            r13 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r3, r13, r5)
        L_0x03fe:
            int[] r4 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r13 = r2.ordinal()
            r4 = r4[r13]
            r13 = 1
            if (r4 != r13) goto L_0x040c
            r31 = r36
            goto L_0x040e
        L_0x040c:
            r31 = r38
        L_0x040e:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0417
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0417:
            r7.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r13 = androidx.compose.ui.graphics.Color.m3154boximpl(r31)
            java.lang.Object r2 = r1.getTargetState()
            int r3 = r23 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            androidx.compose.material3.InputPhase r2 = (androidx.compose.material3.InputPhase) r2
            r4 = r10
            r7 = 0
            r26 = r7
            r7 = 1888369619(0x708e3bd3, float:3.5215356E29)
            r4.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r9)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x043f
            r9 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r3, r9, r5)
        L_0x043f:
            int[] r5 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r7 = r2.ordinal()
            r5 = r5[r7]
            r7 = 1
            if (r5 != r7) goto L_0x044d
            r31 = r36
            goto L_0x044f
        L_0x044d:
            r31 = r38
        L_0x044f:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0458
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0458:
            r4.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r9 = androidx.compose.ui.graphics.Color.m3154boximpl(r31)
            androidx.compose.animation.core.Transition$Segment r2 = r1.getSegment()
            int r3 = r23 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r2 = r8.invoke(r2, r10, r3)
            r24 = r2
            androidx.compose.animation.core.FiniteAnimationSpec r24 = (androidx.compose.animation.core.FiniteAnimationSpec) r24
            r2 = r23 & 14
            int r3 = r23 << 9
            r3 = r3 & r16
            r2 = r2 | r3
            int r3 = r23 << 6
            r3 = r3 & r17
            r26 = r2 | r3
            r2 = r13
            r3 = r9
            r29 = r30
            r4 = r24
            r5 = r22
            r7 = r10
            r30 = r8
            r8 = r26
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            r9 = r2
            androidx.compose.material3.TextFieldTransitionScope$Transition$labelContentColor$2 r1 = androidx.compose.material3.TextFieldTransitionScope$Transition$labelContentColor$2.INSTANCE
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r2 = r11 & 7168(0x1c00, float:1.0045E-41)
            r3 = r28
            r2 = r2 | r3
            r13 = r18
            java.lang.String r6 = "LabelContentColor"
            r15 = r1
            r20 = r2
            r21 = 0
            r1 = -1462136984(0xffffffffa8d98f68, float:-2.4154032E-14)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "C(animateColor)P(2)68@3224L31,69@3291L70,73@3374L70:Transition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            java.lang.Object r1 = r13.getTargetState()
            int r2 = r20 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r1 = r12.invoke(r1, r10, r2)
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m3174unboximpl()
            androidx.compose.ui.graphics.colorspace.ColorSpace r8 = androidx.compose.ui.graphics.Color.m3168getColorSpaceimpl(r1)
            r1 = 8
            r2 = 0
            r3 = -3686930(0xffffffffffc7bdee, float:NaN)
            r10.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r3)
            boolean r3 = r10.changed((java.lang.Object) r8)
            r4 = r10
            r5 = 0
            java.lang.Object r7 = r4.rememberedValue()
            r22 = 0
            if (r3 != 0) goto L_0x04f8
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r43 = r1
            java.lang.Object r1 = r23.getEmpty()
            if (r7 != r1) goto L_0x04f6
            goto L_0x04fa
        L_0x04f6:
            r1 = r7
            goto L_0x050d
        L_0x04f8:
            r43 = r1
        L_0x04fa:
            r1 = 0
            androidx.compose.ui.graphics.Color$Companion r23 = androidx.compose.ui.graphics.Color.Companion
            r24 = r1
            kotlin.jvm.functions.Function1 r1 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r23)
            java.lang.Object r1 = r1.invoke(r8)
            androidx.compose.animation.core.TwoWayConverter r1 = (androidx.compose.animation.core.TwoWayConverter) r1
            r4.updateRememberedValue(r1)
        L_0x050d:
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
            r2 = r2 | r1
            r1 = r13
            r23 = r2
            r24 = 0
            r2 = 1847725064(0x6e220c08, float:1.2537779E28)
            r10.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            java.lang.Object r0 = r1.getCurrentState()
            int r2 = r23 >> 9
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r0 = r12.invoke(r0, r10, r2)
            java.lang.Object r2 = r1.getTargetState()
            int r3 = r23 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r25 = r12.invoke(r2, r10, r3)
            androidx.compose.animation.core.Transition$Segment r2 = r1.getSegment()
            int r3 = r23 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r2 = r15.invoke(r2, r10, r3)
            r26 = r2
            androidx.compose.animation.core.FiniteAnimationSpec r26 = (androidx.compose.animation.core.FiniteAnimationSpec) r26
            r2 = r23 & 14
            int r3 = r23 << 9
            r3 = r3 & r16
            r2 = r2 | r3
            int r3 = r23 << 6
            r3 = r3 & r17
            r17 = r2 | r3
            r2 = r0
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
            float r0 = m2172Transition_DTcfvLk$lambda1(r19)
            java.lang.Float r1 = java.lang.Float.valueOf(r0)
            long r2 = m2174Transition_DTcfvLk$lambda5(r9)
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m3154boximpl(r2)
            long r3 = m2175Transition_DTcfvLk$lambda6(r7)
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m3154boximpl(r3)
            float r0 = m2173Transition_DTcfvLk$lambda3(r14)
            java.lang.Float r4 = java.lang.Float.valueOf(r0)
            int r0 = r11 >> 3
            r0 = r0 & r16
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
            r0 = r42
            r5 = r10
            r0.invoke(r1, r2, r3, r4, r5, r6)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x05c7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x05c7:
            androidx.compose.runtime.ScopeUpdateScope r13 = r10.endRestartGroup()
            if (r13 != 0) goto L_0x05cf
            r15 = r10
            goto L_0x05eb
        L_0x05cf:
            androidx.compose.material3.TextFieldTransitionScope$Transition$1 r14 = new androidx.compose.material3.TextFieldTransitionScope$Transition$1
            r0 = r14
            r1 = r34
            r2 = r35
            r3 = r36
            r5 = r38
            r7 = r40
            r8 = r41
            r9 = r42
            r15 = r10
            r10 = r44
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x05eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldTransitionScope.m2176TransitionDTcfvLk(androidx.compose.material3.InputPhase, long, long, kotlin.jvm.functions.Function3, boolean, kotlin.jvm.functions.Function6, androidx.compose.runtime.Composer, int):void");
    }

    /* renamed from: Transition_DTcfvLk$lambda-1  reason: not valid java name */
    private static final float m2172Transition_DTcfvLk$lambda1(State<Float> $labelProgress$delegate) {
        return ((Number) $labelProgress$delegate.getValue()).floatValue();
    }

    /* renamed from: Transition_DTcfvLk$lambda-3  reason: not valid java name */
    private static final float m2173Transition_DTcfvLk$lambda3(State<Float> $placeholderOpacity$delegate) {
        return ((Number) $placeholderOpacity$delegate.getValue()).floatValue();
    }

    /* renamed from: Transition_DTcfvLk$lambda-5  reason: not valid java name */
    private static final long m2174Transition_DTcfvLk$lambda5(State<Color> $labelTextStyleColor$delegate) {
        return ((Color) $labelTextStyleColor$delegate.getValue()).m3174unboximpl();
    }

    /* renamed from: Transition_DTcfvLk$lambda-6  reason: not valid java name */
    private static final long m2175Transition_DTcfvLk$lambda6(State<Color> $labelContentColor$delegate) {
        return ((Color) $labelContentColor$delegate.getValue()).m3174unboximpl();
    }
}
