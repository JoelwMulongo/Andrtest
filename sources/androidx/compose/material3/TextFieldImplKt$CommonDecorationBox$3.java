package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldImplKt$CommonDecorationBox$3 extends Lambda implements Function6<Float, Color, Color, Float, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ TextStyle $bodySmall;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $container;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $innerTextField;
    final /* synthetic */ InteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ boolean $shouldOverrideTextStyleColor;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
    final /* synthetic */ String $transformedText;
    final /* synthetic */ TextFieldType $type;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TextFieldImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextFieldType.values().length];
            iArr[TextFieldType.Filled.ordinal()] = 1;
            iArr[TextFieldType.Outlined.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$CommonDecorationBox$3(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, String str, boolean z, int i, TextFieldColors textFieldColors, boolean z2, InteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, TextFieldType textFieldType, Function2<? super Composer, ? super Integer, Unit> function26, boolean z3, PaddingValues paddingValues, int i2, boolean z4, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function27) {
        super(6);
        this.$label = function2;
        this.$placeholder = function22;
        this.$transformedText = str;
        this.$isError = z;
        this.$$dirty1 = i;
        this.$colors = textFieldColors;
        this.$enabled = z2;
        this.$interactionSource = interactionSource;
        this.$leadingIcon = function23;
        this.$trailingIcon = function24;
        this.$supportingText = function25;
        this.$type = textFieldType;
        this.$innerTextField = function26;
        this.$singleLine = z3;
        this.$contentPadding = paddingValues;
        this.$$dirty = i2;
        this.$shouldOverrideTextStyleColor = z4;
        this.$bodySmall = textStyle;
        this.$container = function27;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        m2164invokeRIQooxk(((Number) p1).floatValue(), ((Color) p2).m3174unboximpl(), ((Color) p3).m3174unboximpl(), ((Number) p4).floatValue(), (Composer) p5, ((Number) p6).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v31, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x023e  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x03bf  */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* renamed from: invoke-RIQooxk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2164invokeRIQooxk(float r37, long r38, long r40, float r42, androidx.compose.runtime.Composer r43, int r44) {
        /*
            r36 = this;
            r0 = r36
            r15 = r37
            r14 = r43
            r13 = r44
            java.lang.String r1 = "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)143@5979L30,144@6065L43,146@6148L53,153@6449L54,161@6768L56:TextFieldImpl.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r44
            r2 = r13 & 14
            if (r2 != 0) goto L_0x001d
            boolean r2 = r14.changed((float) r15)
            if (r2 == 0) goto L_0x001b
            r2 = 4
            goto L_0x001c
        L_0x001b:
            r2 = 2
        L_0x001c:
            r1 = r1 | r2
        L_0x001d:
            r2 = r13 & 112(0x70, float:1.57E-43)
            r10 = r38
            if (r2 != 0) goto L_0x002f
            boolean r2 = r14.changed((long) r10)
            if (r2 == 0) goto L_0x002c
            r2 = 32
            goto L_0x002e
        L_0x002c:
            r2 = 16
        L_0x002e:
            r1 = r1 | r2
        L_0x002f:
            r2 = r13 & 896(0x380, float:1.256E-42)
            r8 = r40
            if (r2 != 0) goto L_0x0041
            boolean r2 = r14.changed((long) r8)
            if (r2 == 0) goto L_0x003e
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0040
        L_0x003e:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0040:
            r1 = r1 | r2
        L_0x0041:
            r2 = r13 & 7168(0x1c00, float:1.0045E-41)
            r7 = r42
            if (r2 != 0) goto L_0x0053
            boolean r2 = r14.changed((float) r7)
            if (r2 == 0) goto L_0x0050
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0052
        L_0x0050:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0052:
            r1 = r1 | r2
        L_0x0053:
            r6 = r1
            r1 = 46811(0xb6db, float:6.5596E-41)
            r1 = r1 & r6
            r2 = 9362(0x2492, float:1.3119E-41)
            if (r1 != r2) goto L_0x006b
            boolean r1 = r43.getSkipping()
            if (r1 != 0) goto L_0x0063
            goto L_0x006b
        L_0x0063:
            r43.skipToGroupEnd()
            r27 = r6
            r2 = r14
            goto L_0x03c2
        L_0x006b:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x007a
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:112)"
            r3 = 1915872767(0x7231e5ff, float:3.5236413E30)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r6, r1, r2)
        L_0x007a:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.$label
            r3 = 0
            r4 = 1
            if (r5 == 0) goto L_0x00a5
            boolean r2 = r0.$shouldOverrideTextStyleColor
            r16 = 0
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1 r1 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
            r17 = r1
            r18 = r2
            r2 = r37
            r13 = r4
            r3 = r40
            r27 = r6
            r7 = r18
            r8 = r38
            r1.<init>(r2, r3, r5, r6, r7, r8)
            r1 = 1199990137(0x47866579, float:68810.945)
            r2 = r17
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r1, r13, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r4 = r1
            goto L_0x00a9
        L_0x00a5:
            r13 = r4
            r27 = r6
            r4 = 0
        L_0x00a9:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r1 = r0.$placeholder
            if (r1 == 0) goto L_0x00e4
            java.lang.String r1 = r0.$transformedText
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 != 0) goto L_0x00b9
            r1 = r13
            goto L_0x00ba
        L_0x00b9:
            r1 = 0
        L_0x00ba:
            if (r1 == 0) goto L_0x00e4
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1 r1 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
            androidx.compose.material3.TextFieldColors r3 = r0.$colors
            boolean r5 = r0.$enabled
            int r6 = r0.$$dirty1
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r7 = r0.$placeholder
            int r8 = r0.$$dirty
            r16 = r1
            r17 = r42
            r18 = r3
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r16.<init>(r17, r18, r19, r20, r21, r22)
            r3 = 1472145357(0x57bf27cd, float:4.20355328E14)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r3, r13, r1)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r3 = r1
            goto L_0x00e5
        L_0x00e4:
            r3 = 0
        L_0x00e5:
            androidx.compose.material3.Strings$Companion r1 = androidx.compose.material3.Strings.Companion
            int r1 = r1.m2081getDefaultErrorMessageadMyvUU()
            r9 = 6
            java.lang.String r1 = androidx.compose.material3.Strings_androidKt.m2089getStringNWtq28(r1, r14, r9)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            boolean r6 = r0.$isError
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            boolean r7 = r0.$isError
            int r8 = r0.$$dirty1
            int r8 = r8 >> 3
            r8 = r8 & 14
            r16 = 0
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r14.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            boolean r19 = r14.changed((java.lang.Object) r6)
            boolean r20 = r14.changed((java.lang.Object) r1)
            r19 = r19 | r20
            r20 = r43
            r21 = 0
            java.lang.Object r9 = r20.rememberedValue()
            r23 = 0
            if (r19 != 0) goto L_0x0135
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r24.getEmpty()
            if (r9 != r12) goto L_0x0131
            goto L_0x0135
        L_0x0131:
            r7 = r9
            r12 = r20
            goto L_0x0144
        L_0x0135:
            r12 = 0
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1 r13 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1
            r13.<init>(r7, r1)
            r7 = r13
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r12 = r20
            r12.updateRememberedValue(r7)
        L_0x0144:
            r43.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r6 = 0
            r8 = 1
            r13 = 0
            androidx.compose.ui.Modifier r26 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r5, r6, r7, r8, r13)
            androidx.compose.material3.TextFieldColors r5 = r0.$colors
            boolean r6 = r0.$enabled
            boolean r7 = r0.$isError
            androidx.compose.foundation.interaction.InteractionSource r8 = r0.$interactionSource
            int r9 = r0.$$dirty1
            r12 = r9 & 14
            r16 = r9 & 112(0x70, float:1.57E-43)
            r12 = r12 | r16
            r13 = r9 & 896(0x380, float:1.256E-42)
            r12 = r12 | r13
            int r9 = r9 >> 3
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r12 = r12 | r9
            r13 = 6
            r9 = r43
            r10 = r12
            androidx.compose.runtime.State r5 = r5.leadingIconColor$material3_release(r6, r7, r8, r9, r10)
            java.lang.Object r5 = r5.getValue()
            androidx.compose.ui.graphics.Color r5 = (androidx.compose.ui.graphics.Color) r5
            long r11 = r5.m3174unboximpl()
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.$leadingIcon
            if (r5 == 0) goto L_0x0192
            r6 = 0
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1 r7 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
            r7.<init>(r11, r5)
            r8 = 175497959(0xa75e2e7, float:1.18389965E-32)
            r9 = 1
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r8, r9, r7)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r5 = r7
            goto L_0x0193
        L_0x0192:
            r5 = 0
        L_0x0193:
            androidx.compose.material3.TextFieldColors r6 = r0.$colors
            boolean r7 = r0.$enabled
            boolean r8 = r0.$isError
            androidx.compose.foundation.interaction.InteractionSource r9 = r0.$interactionSource
            int r10 = r0.$$dirty1
            r19 = r10 & 14
            r20 = r10 & 112(0x70, float:1.57E-43)
            r19 = r19 | r20
            r13 = r10 & 896(0x380, float:1.256E-42)
            r13 = r19 | r13
            int r10 = r10 >> 3
            r10 = r10 & 7168(0x1c00, float:1.0045E-41)
            r13 = r13 | r10
            r10 = r43
            r28 = r11
            r11 = r13
            androidx.compose.runtime.State r6 = r6.trailingIconColor$material3_release(r7, r8, r9, r10, r11)
            java.lang.Object r6 = r6.getValue()
            androidx.compose.ui.graphics.Color r6 = (androidx.compose.ui.graphics.Color) r6
            long r12 = r6.m3174unboximpl()
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r6 = r0.$trailingIcon
            if (r6 == 0) goto L_0x01d5
            r7 = 0
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1 r8 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
            r8.<init>(r12, r6)
            r9 = -432498573(0xffffffffe6389873, float:-2.179319E23)
            r10 = 1
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r9, r10, r8)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r6 = r8
            goto L_0x01d6
        L_0x01d5:
            r6 = 0
        L_0x01d6:
            androidx.compose.material3.TextFieldColors r7 = r0.$colors
            boolean r8 = r0.$enabled
            boolean r9 = r0.$isError
            androidx.compose.foundation.interaction.InteractionSource r10 = r0.$interactionSource
            int r11 = r0.$$dirty1
            r19 = r11 & 14
            r20 = r11 & 112(0x70, float:1.57E-43)
            r19 = r19 | r20
            r20 = r1
            r1 = r11 & 896(0x380, float:1.256E-42)
            r1 = r19 | r1
            int r11 = r11 >> 3
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r11
            r11 = r43
            r30 = r12
            r13 = 2
            r12 = r1
            androidx.compose.runtime.State r1 = r7.supportingTextColor$material3_release(r8, r9, r10, r11, r12)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r7 = r1.m3174unboximpl()
            r9 = r7
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r1 = r0.$supportingText
            if (r1 == 0) goto L_0x021e
            androidx.compose.ui.text.TextStyle r7 = r0.$bodySmall
            r8 = 0
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1 r11 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
            r11.<init>(r9, r7, r1)
            r7 = -1269483524(0xffffffffb45537fc, float:-1.9857538E-7)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r7, r12, r11)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r11 = r7
            goto L_0x021f
        L_0x021e:
            r11 = 0
        L_0x021f:
            androidx.compose.material3.TextFieldType r1 = r0.$type
            int[] r7 = androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r7[r1]
            switch(r1) {
                case 1: goto L_0x034d;
                case 2: goto L_0x023e;
                default: goto L_0x022c;
            }
        L_0x022c:
            r33 = r9
            r2 = r14
            r32 = r20
            r1 = 404044016(0x181538f0, float:1.9286545E-24)
            r2.startReplaceableGroup(r1)
            r43.endReplaceableGroup()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x03b9
        L_0x023e:
            r1 = 404042394(0x1815329a, float:1.9283346E-24)
            r14.startReplaceableGroup(r1)
            java.lang.String r1 = "193@8107L38,214@9036L420,205@8574L1062"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = 0
            r12 = 0
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r14.startReplaceableGroup(r7)
            java.lang.String r7 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r7)
            r7 = 0
            r19 = r43
            r21 = 0
            java.lang.Object r8 = r19.rememberedValue()
            r25 = 0
            androidx.compose.runtime.Composer$Companion r32 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r32.getEmpty()
            if (r8 != r13) goto L_0x0287
            r13 = 0
            androidx.compose.ui.geometry.Size$Companion r32 = androidx.compose.ui.geometry.Size.Companion
            long r34 = r32.m2993getZeroNHjbRc()
            r32 = r1
            androidx.compose.ui.geometry.Size r1 = androidx.compose.ui.geometry.Size.m2972boximpl(r34)
            r34 = r7
            r16 = r8
            r7 = 2
            r8 = 0
            androidx.compose.runtime.MutableState r1 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r8, r7, r8)
            r7 = r19
            r7.updateRememberedValue(r1)
            goto L_0x0291
        L_0x0287:
            r32 = r1
            r34 = r7
            r16 = r8
            r7 = r19
            r1 = r16
        L_0x0291:
            r43.endReplaceableGroup()
            r13 = r1
            androidx.compose.runtime.MutableState r13 = (androidx.compose.runtime.MutableState) r13
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1 r1 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
            androidx.compose.foundation.layout.PaddingValues r7 = r0.$contentPadding
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r8 = r0.$container
            int r12 = r0.$$dirty1
            r1.<init>(r13, r7, r8, r12)
            r7 = 787383072(0x2eee8320, float:1.08462794E-10)
            r8 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r7, r8, r1)
            r16 = r1
            kotlin.jvm.functions.Function2 r16 = (kotlin.jvm.functions.Function2) r16
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r7 = r0.$innerTextField
            boolean r8 = r0.$singleLine
            java.lang.Float r1 = java.lang.Float.valueOf(r37)
            r12 = r27 & 14
            r12 = r12 | 48
            r19 = 0
            r24 = r9
            r9 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r14.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            boolean r2 = r14.changed((java.lang.Object) r1)
            boolean r9 = r14.changed((java.lang.Object) r13)
            r2 = r2 | r9
            r9 = r43
            r10 = 0
            r18 = r1
            java.lang.Object r1 = r9.rememberedValue()
            r21 = 0
            if (r2 != 0) goto L_0x02f3
            androidx.compose.runtime.Composer$Companion r32 = androidx.compose.runtime.Composer.Companion
            r33 = r2
            java.lang.Object r2 = r32.getEmpty()
            if (r1 != r2) goto L_0x02f0
            goto L_0x02f5
        L_0x02f0:
            r32 = r1
            goto L_0x0303
        L_0x02f3:
            r33 = r2
        L_0x02f5:
            r2 = 0
            r32 = r1
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1 r1 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1
            r1.<init>(r15, r13)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r9.updateRememberedValue(r1)
        L_0x0303:
            r43.endReplaceableGroup()
            r9 = r1
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            androidx.compose.foundation.layout.PaddingValues r12 = r0.$contentPadding
            int r1 = r0.$$dirty
            int r2 = r1 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r10 = 805306368(0x30000000, float:4.656613E-10)
            r2 = r2 | r10
            int r1 = r1 >> 9
            r10 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r10
            r1 = r1 | r2
            int r2 = r27 << 21
            r10 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r10
            r17 = r1 | r2
            int r1 = r0.$$dirty1
            r2 = 6
            int r1 = r1 >> r2
            r18 = r1 & 112(0x70, float:1.57E-43)
            r32 = r20
            r1 = r26
            r2 = r7
            r7 = r8
            r8 = r37
            r33 = r24
            r10 = r16
            r19 = r13
            r13 = r43
            r0 = r14
            r14 = r17
            r15 = r18
            androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextFieldLayout(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r43.endReplaceableGroup()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r2 = r0
            r0 = r36
            goto L_0x03b9
        L_0x034d:
            r33 = r9
            r0 = r14
            r32 = r20
            r1 = 404041480(0x18152f08, float:1.9281543E-24)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "177@7397L588"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1 r1 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
            r2 = r0
            r0 = r36
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r7 = r0.$container
            int r8 = r0.$$dirty1
            r1.<init>(r7, r8)
            r7 = 1566950173(0x5d65c31d, float:1.03475678E18)
            r8 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r7, r8, r1)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r13 = r0.$innerTextField
            boolean r7 = r0.$singleLine
            androidx.compose.foundation.layout.PaddingValues r8 = r0.$contentPadding
            int r9 = r0.$$dirty
            int r10 = r9 >> 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            r12 = 100663296(0x6000000, float:2.4074124E-35)
            r10 = r10 | r12
            int r9 = r9 >> 9
            r12 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r12
            r9 = r9 | r10
            int r10 = r27 << 21
            r12 = 29360128(0x1c00000, float:7.052966E-38)
            r10 = r10 & r12
            r24 = r9 | r10
            int r9 = r0.$$dirty1
            int r9 = r9 >> 9
            r25 = r9 & 14
            r12 = r26
            r14 = r4
            r15 = r3
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r37
            r20 = r1
            r21 = r11
            r22 = r8
            r23 = r43
            androidx.compose.material3.TextFieldKt.TextFieldLayout(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r43.endReplaceableGroup()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x03b9:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x03c2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3.m2164invokeRIQooxk(float, long, long, float, androidx.compose.runtime.Composer, int):void");
    }
}
