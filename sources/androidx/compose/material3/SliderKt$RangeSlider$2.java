package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSlider$2 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $endInteractionSource;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
    final /* synthetic */ MutableInteractionSource $startInteractionSource;
    final /* synthetic */ int $steps;
    final /* synthetic */ float[] $tickFractions;
    final /* synthetic */ ClosedFloatingPointRange<Float> $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$2(Function0<Unit> function0, int i, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i2, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, float[] fArr, SliderColors sliderColors) {
        super(3);
        this.$onValueChangeFinished = function0;
        this.$$dirty = i;
        this.$startInteractionSource = mutableInteractionSource;
        this.$endInteractionSource = mutableInteractionSource2;
        this.$enabled = z;
        this.$valueRange = closedFloatingPointRange;
        this.$value = closedFloatingPointRange2;
        this.$steps = i2;
        this.$onValueChangeState = state;
        this.$tickFractions = fArr;
        this.$colors = sliderColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((BoxWithConstraintsScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r38v0, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x02be  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x02ce  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x034c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x03de  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r43, androidx.compose.runtime.Composer r44, int r45) {
        /*
            r42 = this;
            r0 = r42
            r1 = r43
            r15 = r44
            r14 = r45
            java.lang.String r2 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "C413@19202L7,*418@19363L7,429@19797L55,430@19880L62,432@20015L55,432@19975L95,436@20093L1026,479@22137L63,487@22427L65,493@22620L340:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = r45
            r3 = r14 & 14
            r4 = 2
            if (r3 != 0) goto L_0x0023
            boolean r3 = r15.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0021
            r3 = 4
            goto L_0x0022
        L_0x0021:
            r3 = r4
        L_0x0022:
            r2 = r2 | r3
        L_0x0023:
            r16 = r2
            r2 = r16 & 91
            r3 = 18
            if (r2 != r3) goto L_0x0037
            boolean r2 = r44.getSkipping()
            if (r2 != 0) goto L_0x0032
            goto L_0x0037
        L_0x0032:
            r44.skipToGroupEnd()
            goto L_0x03e1
        L_0x0037:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0046
            r2 = -1
            java.lang.String r5 = "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:412)"
            r6 = -990606702(0xffffffffc4f48a92, float:-1956.3303)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r14, r2, r5)
        L_0x0046:
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r5 = 0
            r6 = 0
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r7, r8)
            java.lang.Object r9 = r15.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r44)
            androidx.compose.ui.unit.LayoutDirection r2 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r9 != r2) goto L_0x0065
            r2 = 1
            r23 = r2
            goto L_0x0067
        L_0x0065:
            r23 = 0
        L_0x0067:
            long r9 = r43.m714getConstraintsmsEJaDk()
            int r2 = androidx.compose.ui.unit.Constraints.m5930getMaxWidthimpl(r9)
            float r13 = (float) r2
            kotlin.jvm.internal.Ref$FloatRef r2 = new kotlin.jvm.internal.Ref$FloatRef
            r2.<init>()
            r12 = r2
            kotlin.jvm.internal.Ref$FloatRef r2 = new kotlin.jvm.internal.Ref$FloatRef
            r2.<init>()
            r11 = r2
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r6 = 0
            r9 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r7, r8)
            java.lang.Object r7 = r15.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r44)
            r2 = r7
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            r6 = 0
            float r7 = androidx.compose.material3.SliderKt.getThumbWidth()
            float r7 = r2.m5967toPx0680j_4(r7)
            float r8 = (float) r4
            float r7 = r7 / r8
            float r7 = r13 - r7
            r12.element = r7
            float r7 = androidx.compose.material3.SliderKt.getThumbWidth()
            float r7 = r2.m5967toPx0680j_4(r7)
            float r7 = r7 / r8
            r11.element = r7
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$value
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.$valueRange
            r7 = 0
            r8 = 0
            r9 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r9)
            java.lang.String r10 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r10)
            r17 = 0
            r18 = r44
            r19 = 0
            java.lang.Object r5 = r18.rememberedValue()
            r21 = 0
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r22.getEmpty()
            r9 = 0
            if (r5 != r3) goto L_0x00f3
            r3 = 0
            java.lang.Comparable r2 = r2.getStart()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            float r2 = invoke$scaleToOffset(r6, r11, r12, r2)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r9, r4, r9)
            r3 = r18
            r3.updateRememberedValue(r2)
            goto L_0x00f6
        L_0x00f3:
            r3 = r18
            r2 = r5
        L_0x00f6:
            r44.endReplaceableGroup()
            r33 = r2
            androidx.compose.runtime.MutableState r33 = (androidx.compose.runtime.MutableState) r33
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$value
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            r5 = 0
            r6 = 0
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r10)
            r7 = 0
            r8 = r44
            r10 = 0
            java.lang.Object r4 = r8.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r19.getEmpty()
            if (r4 != r9) goto L_0x013e
            r9 = 0
            java.lang.Comparable r2 = r2.getEndInclusive()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            float r2 = invoke$scaleToOffset(r3, r11, r12, r2)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r1 = 2
            r3 = 0
            androidx.compose.runtime.MutableState r1 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r3, r1, r3)
            r8.updateRememberedValue(r1)
            goto L_0x013f
        L_0x013e:
            r1 = r4
        L_0x013f:
            r44.endReplaceableGroup()
            androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.MutableState) r1
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = r0.$onValueChangeFinished
            kotlin.jvm.functions.Function0<kotlin.Unit> r3 = r0.$onValueChangeFinished
            int r4 = r0.$$dirty
            r5 = 18
            int r4 = r4 >> r5
            r4 = r4 & 14
            r5 = 0
            r6 = 1157296644(0x44faf204, float:2007.563)
            r15.startReplaceableGroup(r6)
            java.lang.String r6 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r6)
            boolean r6 = r15.changed((java.lang.Object) r2)
            r7 = r44
            r8 = 0
            java.lang.Object r9 = r7.rememberedValue()
            r10 = 0
            if (r6 != 0) goto L_0x0178
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r18 = r2
            java.lang.Object r2 = r17.getEmpty()
            if (r9 != r2) goto L_0x0176
            goto L_0x017a
        L_0x0176:
            r2 = r9
            goto L_0x0188
        L_0x0178:
            r18 = r2
        L_0x017a:
            r2 = 0
            r17 = r2
            androidx.compose.material3.SliderKt$RangeSlider$2$gestureEndAction$1$1 r2 = new androidx.compose.material3.SliderKt$RangeSlider$2$gestureEndAction$1$1
            r2.<init>(r3)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r7.updateRememberedValue(r2)
        L_0x0188:
            r44.endReplaceableGroup()
            r3 = 0
            androidx.compose.runtime.State r34 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r2, r15, r3)
            androidx.compose.material3.SliderKt$RangeSlider$2$onDrag$1 r2 = new androidx.compose.material3.SliderKt$RangeSlider$2$onDrag$1
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$value
            float[] r4 = r0.$tickFractions
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r5 = r0.$onValueChangeState
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.$valueRange
            r24 = r2
            r25 = r33
            r26 = r1
            r27 = r3
            r28 = r11
            r29 = r4
            r30 = r12
            r31 = r5
            r32 = r6
            r24.<init>(r25, r26, r27, r28, r29, r30, r31, r32)
            r3 = 0
            androidx.compose.runtime.State r28 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r2, r15, r3)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r17 = r2
            androidx.compose.ui.Modifier r17 = (androidx.compose.ui.Modifier) r17
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r0.$startInteractionSource
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r0.$endInteractionSource
            r20 = r33
            androidx.compose.runtime.State r20 = (androidx.compose.runtime.State) r20
            r21 = r1
            androidx.compose.runtime.State r21 = (androidx.compose.runtime.State) r21
            boolean r4 = r0.$enabled
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r5 = r0.$valueRange
            r18 = r2
            r19 = r3
            r22 = r4
            r24 = r13
            r25 = r5
            r26 = r34
            r27 = r28
            androidx.compose.ui.Modifier r17 = androidx.compose.material3.SliderKt.rangeSliderPressDragModifier(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$value
            java.lang.Comparable r2 = r2.getStart()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            java.lang.Comparable r3 = r3.getStart()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$value
            java.lang.Comparable r4 = r4.getEndInclusive()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            float r10 = kotlin.ranges.RangesKt.coerceIn((float) r2, (float) r3, (float) r4)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$value
            java.lang.Comparable r2 = r2.getEndInclusive()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$value
            java.lang.Comparable r3 = r3.getStart()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$valueRange
            java.lang.Comparable r4 = r4.getEndInclusive()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            float r9 = kotlin.ranges.RangesKt.coerceIn((float) r2, (float) r3, (float) r4)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            java.lang.Comparable r2 = r2.getStart()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            java.lang.Comparable r3 = r3.getEndInclusive()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            float r18 = androidx.compose.material3.SliderKt.calcFraction(r2, r3, r10)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            java.lang.Comparable r2 = r2.getStart()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            java.lang.Comparable r3 = r3.getEndInclusive()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            float r19 = androidx.compose.material3.SliderKt.calcFraction(r2, r3, r9)
            int r2 = r0.$steps
            float r2 = (float) r2
            float r2 = r2 * r19
            double r2 = (double) r2
            double r2 = java.lang.Math.floor(r2)
            float r2 = (float) r2
            int r8 = (int) r2
            int r2 = r0.$steps
            float r2 = (float) r2
            r3 = 1065353216(0x3f800000, float:1.0)
            float r3 = r3 - r18
            float r2 = r2 * r3
            double r2 = (double) r2
            double r2 = java.lang.Math.floor(r2)
            float r2 = (float) r2
            int r7 = (int) r2
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r35 = r2
            androidx.compose.ui.Modifier r35 = (androidx.compose.ui.Modifier) r35
            boolean r2 = r0.$enabled
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r3 = r0.$onValueChangeState
            java.lang.Float r4 = java.lang.Float.valueOf(r9)
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r5 = r0.$onValueChangeState
            r6 = 0
            r20 = 0
            r21 = r1
            r1 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r15.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            boolean r24 = r15.changed((java.lang.Object) r3)
            boolean r25 = r15.changed((java.lang.Object) r4)
            r24 = r24 | r25
            r25 = r44
            r26 = 0
            r27 = r3
            java.lang.Object r3 = r25.rememberedValue()
            r29 = 0
            if (r24 != 0) goto L_0x02ce
            androidx.compose.runtime.Composer$Companion r30 = androidx.compose.runtime.Composer.Companion
            r31 = r4
            java.lang.Object r4 = r30.getEmpty()
            if (r3 != r4) goto L_0x02c9
            goto L_0x02d0
        L_0x02c9:
            r30 = r3
            r4 = r25
            goto L_0x02e0
        L_0x02ce:
            r31 = r4
        L_0x02d0:
            r4 = 0
            r30 = r3
            androidx.compose.material3.SliderKt$RangeSlider$2$startThumbSemantics$1$1 r3 = new androidx.compose.material3.SliderKt$RangeSlider$2$startThumbSemantics$1$1
            r3.<init>(r5, r9)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r4 = r25
            r4.updateRememberedValue(r3)
        L_0x02e0:
            r44.endReplaceableGroup()
            r38 = r3
            kotlin.jvm.functions.Function1 r38 = (kotlin.jvm.functions.Function1) r38
            kotlin.jvm.functions.Function0<kotlin.Unit> r3 = r0.$onValueChangeFinished
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$valueRange
            java.lang.Comparable r4 = r4.getStart()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r40 = kotlin.ranges.RangesKt.rangeTo((float) r4, (float) r9)
            r36 = r10
            r37 = r2
            r39 = r3
            r41 = r8
            androidx.compose.ui.Modifier r20 = androidx.compose.material3.SliderKt.sliderSemantics(r35, r36, r37, r38, r39, r40, r41)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r35 = r2
            androidx.compose.ui.Modifier r35 = (androidx.compose.ui.Modifier) r35
            boolean r2 = r0.$enabled
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r3 = r0.$onValueChangeState
            java.lang.Float r4 = java.lang.Float.valueOf(r10)
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r5 = r0.$onValueChangeState
            r6 = 0
            r24 = 0
            r25 = r6
            r6 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r15.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            boolean r1 = r15.changed((java.lang.Object) r3)
            boolean r6 = r15.changed((java.lang.Object) r4)
            r1 = r1 | r6
            r6 = r44
            r22 = 0
            r26 = r3
            java.lang.Object r3 = r6.rememberedValue()
            r27 = 0
            if (r1 != 0) goto L_0x034c
            androidx.compose.runtime.Composer$Companion r29 = androidx.compose.runtime.Composer.Companion
            r30 = r1
            java.lang.Object r1 = r29.getEmpty()
            if (r3 != r1) goto L_0x034a
            goto L_0x034e
        L_0x034a:
            r1 = r3
            goto L_0x035c
        L_0x034c:
            r30 = r1
        L_0x034e:
            r1 = 0
            r29 = r1
            androidx.compose.material3.SliderKt$RangeSlider$2$endThumbSemantics$1$1 r1 = new androidx.compose.material3.SliderKt$RangeSlider$2$endThumbSemantics$1$1
            r1.<init>(r5, r10)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r6.updateRememberedValue(r1)
        L_0x035c:
            r44.endReplaceableGroup()
            r38 = r1
            kotlin.jvm.functions.Function1 r38 = (kotlin.jvm.functions.Function1) r38
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r0.$onValueChangeFinished
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            java.lang.Comparable r3 = r3.getEndInclusive()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r40 = kotlin.ranges.RangesKt.rangeTo((float) r10, (float) r3)
            r36 = r9
            r37 = r2
            r39 = r1
            r41 = r7
            androidx.compose.ui.Modifier r1 = androidx.compose.material3.SliderKt.sliderSemantics(r35, r36, r37, r38, r39, r40, r41)
            boolean r2 = r0.$enabled
            float[] r5 = r0.$tickFractions
            androidx.compose.material3.SliderColors r6 = r0.$colors
            float r3 = r12.element
            float r4 = r11.element
            float r22 = r3 - r4
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r0.$startInteractionSource
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r0.$endInteractionSource
            r24 = r3
            int r3 = r0.$$dirty
            int r25 = r3 >> 9
            r25 = r25 & 14
            r26 = 14159872(0xd81000, float:1.9842207E-38)
            r25 = r25 | r26
            r26 = 57344(0xe000, float:8.0356E-41)
            int r3 = r3 >> 9
            r3 = r3 & r26
            r25 = r25 | r3
            r26 = 0
            r3 = r18
            r27 = r4
            r4 = r19
            r29 = r7
            r7 = r22
            r22 = r8
            r8 = r27
            r27 = r9
            r9 = r24
            r24 = r10
            r10 = r17
            r30 = r11
            r11 = r20
            r31 = r12
            r12 = r1
            r32 = r13
            r13 = r44
            r14 = r25
            r15 = r26
            androidx.compose.material3.SliderKt.RangeSliderImpl(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x03e1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt$RangeSlider$2.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> invoke$scaleToUserValue(Ref.FloatRef minPx, Ref.FloatRef maxPx, ClosedFloatingPointRange<Float> $valueRange2, ClosedFloatingPointRange<Float> offset) {
        return SliderKt.scale(minPx.element, maxPx.element, offset, $valueRange2.getStart().floatValue(), $valueRange2.getEndInclusive().floatValue());
    }

    /* access modifiers changed from: private */
    public static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> $valueRange2, Ref.FloatRef minPx, Ref.FloatRef maxPx, float userValue) {
        return SliderKt.scale($valueRange2.getStart().floatValue(), $valueRange2.getEndInclusive().floatValue(), userValue, minPx.element, maxPx.element);
    }
}
