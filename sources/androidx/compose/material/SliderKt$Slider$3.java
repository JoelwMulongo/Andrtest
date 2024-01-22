package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$Slider$3 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ State<Function1<Float, Unit>> $onValueChangeState;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ float $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$Slider$3(ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, float f, MutableInteractionSource mutableInteractionSource, boolean z, List<Float> list, SliderColors sliderColors, State<? extends Function1<? super Float, Unit>> state, Function0<Unit> function0) {
        super(3);
        this.$valueRange = closedFloatingPointRange;
        this.$$dirty = i;
        this.$value = f;
        this.$interactionSource = mutableInteractionSource;
        this.$enabled = z;
        this.$tickFractions = list;
        this.$colors = sliderColors;
        this.$onValueChangeState = state;
        this.$onValueChangeFinished = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((BoxWithConstraintsScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: androidx.compose.material.SliderDraggableState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v2, resolved type: kotlin.jvm.functions.Function3} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v39, resolved type: androidx.compose.material.SliderDraggableState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x02ba  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x02c8  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0372  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r36, androidx.compose.runtime.Composer r37, int r38) {
        /*
            r35 = this;
            r0 = r35
            r1 = r36
            r11 = r37
            r12 = r38
            java.lang.String r2 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "C175@8165L7,*180@8326L7,191@8740L24,192@8789L49,193@8865L31,195@8927L367,204@9304L83,206@9420L618,235@10532L55,242@10873L209:Slider.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            r2 = r38
            r3 = r12 & 14
            if (r3 != 0) goto L_0x0022
            boolean r3 = r11.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0020
            r3 = 4
            goto L_0x0021
        L_0x0020:
            r3 = 2
        L_0x0021:
            r2 = r2 | r3
        L_0x0022:
            r13 = r2
            r2 = r13 & 91
            r3 = 18
            if (r2 != r3) goto L_0x0035
            boolean r2 = r37.getSkipping()
            if (r2 != 0) goto L_0x0030
            goto L_0x0035
        L_0x0030:
            r37.skipToGroupEnd()
            goto L_0x0375
        L_0x0035:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0044
            r2 = -1
            java.lang.String r3 = "androidx.compose.material.Slider.<anonymous> (Slider.kt:174)"
            r5 = 2085116814(0x7c485b8e, float:4.1612653E36)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r12, r2, r3)
        L_0x0044:
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 0
            r5 = 0
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r6, r7)
            java.lang.Object r8 = r11.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r37)
            androidx.compose.ui.unit.LayoutDirection r2 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r9 = 0
            if (r8 != r2) goto L_0x0064
            r2 = 1
            r18 = r2
            goto L_0x0066
        L_0x0064:
            r18 = r9
        L_0x0066:
            long r2 = r36.m714getConstraintsmsEJaDk()
            int r2 = androidx.compose.ui.unit.Constraints.m5930getMaxWidthimpl(r2)
            float r10 = (float) r2
            kotlin.jvm.internal.Ref$FloatRef r2 = new kotlin.jvm.internal.Ref$FloatRef
            r2.<init>()
            r15 = r2
            kotlin.jvm.internal.Ref$FloatRef r2 = new kotlin.jvm.internal.Ref$FloatRef
            r2.<init>()
            r14 = r2
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 0
            r5 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r6, r7)
            java.lang.Object r6 = r11.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r37)
            r2 = r6
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            r3 = 0
            float r5 = androidx.compose.material.SliderKt.getThumbRadius()
            float r5 = r2.m5967toPx0680j_4(r5)
            float r5 = r10 - r5
            r6 = 0
            float r5 = java.lang.Math.max(r5, r6)
            r15.element = r5
            float r5 = androidx.compose.material.SliderKt.getThumbRadius()
            float r5 = r2.m5967toPx0680j_4(r5)
            float r7 = r15.element
            float r5 = java.lang.Math.min(r5, r7)
            r14.element = r5
            r2 = r9
            r3 = 0
            r5 = 773894976(0x2e20b340, float:3.6538994E-11)
            r11.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r5)
            r5 = r37
            r7 = r9
            r8 = 0
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r6)
            java.lang.String r9 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r9)
            r17 = 0
            r19 = r37
            r20 = 0
            java.lang.Object r4 = r19.rememberedValue()
            r22 = 0
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r23.getEmpty()
            if (r4 != r6) goto L_0x0102
            r6 = 0
            r23 = 0
            kotlin.coroutines.EmptyCoroutineContext r23 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r1 = r23
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            kotlinx.coroutines.CoroutineScope r1 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r1, r5)
            r23 = r2
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r2.<init>(r1)
            r1 = r2
            r2 = r19
            r2.updateRememberedValue(r1)
            goto L_0x0107
        L_0x0102:
            r23 = r2
            r2 = r19
            r1 = r4
        L_0x0107:
            r37.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r1
            kotlinx.coroutines.CoroutineScope r31 = r1.getCoroutineScope()
            r37.endReplaceableGroup()
            float r1 = r0.$value
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            r3 = 0
            r4 = 0
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r9)
            r5 = 0
            r6 = r37
            r7 = 0
            java.lang.Object r8 = r6.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r20 = r3
            java.lang.Object r3 = r19.getEmpty()
            r12 = 0
            if (r8 != r3) goto L_0x014e
            r3 = 0
            float r1 = invoke$scaleToOffset(r2, r14, r15, r1)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r2 = 2
            androidx.compose.runtime.MutableState r1 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r12, r2, r12)
            r6.updateRememberedValue(r1)
            goto L_0x014f
        L_0x014e:
            r1 = r8
        L_0x014f:
            r37.endReplaceableGroup()
            androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.MutableState) r1
            r2 = 0
            r3 = r2
            r2 = 0
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r9)
            r4 = 0
            r5 = r37
            r6 = 0
            java.lang.Object r7 = r5.rememberedValue()
            r8 = 0
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r7 != r9) goto L_0x0189
            r9 = 0
            r17 = r2
            r16 = 0
            java.lang.Float r2 = java.lang.Float.valueOf(r16)
            r16 = r3
            r3 = 2
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r12, r3, r12)
            r5.updateRememberedValue(r2)
            goto L_0x018e
        L_0x0189:
            r17 = r2
            r16 = r3
            r2 = r7
        L_0x018e:
            r37.endReplaceableGroup()
            r34 = r2
            androidx.compose.runtime.MutableState r34 = (androidx.compose.runtime.MutableState) r34
            float r2 = r14.element
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            float r3 = r15.element
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$valueRange
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit>> r5 = r0.$onValueChangeState
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.$valueRange
            int r7 = r0.$$dirty
            int r7 = r7 >> 6
            r7 = r7 & 896(0x380, float:1.256E-42)
            r8 = 0
            r9 = 1618982084(0x607fb4c4, float:7.370227E19)
            r11.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r9)
            boolean r9 = r11.changed((java.lang.Object) r2)
            boolean r16 = r11.changed((java.lang.Object) r3)
            r9 = r9 | r16
            boolean r16 = r11.changed((java.lang.Object) r4)
            r9 = r9 | r16
            r16 = r37
            r17 = 0
            java.lang.Object r12 = r16.rememberedValue()
            r26 = 0
            if (r9 != 0) goto L_0x01e7
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r27 = r2
            java.lang.Object r2 = r19.getEmpty()
            if (r12 != r2) goto L_0x01e3
            goto L_0x01e9
        L_0x01e3:
            r2 = r12
            r5 = r16
            goto L_0x020f
        L_0x01e7:
            r27 = r2
        L_0x01e9:
            r2 = 0
            r28 = r2
            androidx.compose.material.SliderDraggableState r2 = new androidx.compose.material.SliderDraggableState
            androidx.compose.material.SliderKt$Slider$3$draggableState$1$1 r29 = new androidx.compose.material.SliderKt$Slider$3$draggableState$1$1
            r19 = r29
            r20 = r1
            r21 = r34
            r22 = r14
            r23 = r15
            r24 = r5
            r25 = r6
            r19.<init>(r20, r21, r22, r23, r24, r25)
            r5 = r29
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r2.<init>(r5)
            r5 = r16
            r5.updateRememberedValue(r2)
        L_0x020f:
            r37.endReplaceableGroup()
            r12 = r2
            androidx.compose.material.SliderDraggableState r12 = (androidx.compose.material.SliderDraggableState) r12
            androidx.compose.material.SliderKt$Slider$3$2 r2 = new androidx.compose.material.SliderKt$Slider$3$2
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            r2.<init>(r3, r14, r15)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            float r4 = r14.element
            float r5 = r15.element
            kotlin.ranges.ClosedFloatingPointRange r4 = kotlin.ranges.RangesKt.rangeTo((float) r4, (float) r5)
            float r6 = r0.$value
            int r5 = r0.$$dirty
            int r7 = r5 >> 9
            r7 = r7 & 112(0x70, float:1.57E-43)
            r7 = r7 | 3072(0xc00, float:4.305E-42)
            int r5 = r5 << 12
            r8 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r8
            r8 = r7 | r5
            r5 = r1
            r7 = r37
            androidx.compose.material.SliderKt.CorrectValueSideEffect(r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1 r2 = new androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1
            java.util.List<java.lang.Float> r3 = r0.$tickFractions
            kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r0.$onValueChangeFinished
            r26 = r2
            r27 = r1
            r28 = r3
            r29 = r14
            r30 = r15
            r32 = r12
            r33 = r4
            r26.<init>(r27, r28, r29, r30, r31, r32, r33)
            r3 = 0
            androidx.compose.runtime.State r9 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r2, r11, r3)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r3 = r12
            androidx.compose.foundation.gestures.DraggableState r3 = (androidx.compose.foundation.gestures.DraggableState) r3
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r0.$interactionSource
            r19 = r1
            androidx.compose.runtime.State r19 = (androidx.compose.runtime.State) r19
            boolean r5 = r0.$enabled
            r8 = r14
            r14 = r2
            r7 = r15
            r15 = r3
            r16 = r4
            r17 = r10
            r20 = r9
            r21 = r34
            r22 = r5
            androidx.compose.ui.Modifier r14 = androidx.compose.material.SliderKt.sliderTapModifier(r14, r15, r16, r17, r18, r19, r20, r21, r22)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r21 = androidx.compose.foundation.gestures.Orientation.Horizontal
            boolean r24 = r12.isDragging()
            r19 = r2
            androidx.compose.ui.Modifier r19 = (androidx.compose.ui.Modifier) r19
            r20 = r12
            androidx.compose.foundation.gestures.DraggableState r20 = (androidx.compose.foundation.gestures.DraggableState) r20
            boolean r2 = r0.$enabled
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r0.$interactionSource
            r25 = 0
            r4 = 0
            r5 = 0
            r6 = 1157296644(0x44faf204, float:2007.563)
            r11.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r6)
            boolean r6 = r11.changed((java.lang.Object) r9)
            r15 = r37
            r16 = 0
            r17 = r1
            java.lang.Object r1 = r15.rememberedValue()
            r22 = 0
            if (r6 != 0) goto L_0x02c8
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r26 = r4
            java.lang.Object r4 = r23.getEmpty()
            if (r1 != r4) goto L_0x02c5
            goto L_0x02ca
        L_0x02c5:
            r23 = r1
            goto L_0x02dc
        L_0x02c8:
            r26 = r4
        L_0x02ca:
            r4 = 0
            r23 = r1
            androidx.compose.material.SliderKt$Slider$3$drag$1$1 r1 = new androidx.compose.material.SliderKt$Slider$3$drag$1$1
            r27 = r4
            r4 = 0
            r1.<init>(r9, r4)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r15.updateRememberedValue(r1)
        L_0x02dc:
            r37.endReplaceableGroup()
            r26 = r1
            kotlin.jvm.functions.Function3 r26 = (kotlin.jvm.functions.Function3) r26
            r28 = 32
            r29 = 0
            r22 = r2
            r23 = r3
            r27 = r18
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            float r2 = r0.$value
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            java.lang.Comparable r3 = r3.getStart()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$valueRange
            java.lang.Comparable r4 = r4.getEndInclusive()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            float r15 = kotlin.ranges.RangesKt.coerceIn((float) r2, (float) r3, (float) r4)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            java.lang.Comparable r2 = r2.getStart()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            java.lang.Comparable r3 = r3.getEndInclusive()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            float r16 = androidx.compose.material.SliderKt.calcFraction(r2, r3, r15)
            boolean r2 = r0.$enabled
            java.util.List<java.lang.Float> r4 = r0.$tickFractions
            androidx.compose.material.SliderColors r5 = r0.$colors
            float r3 = r7.element
            float r6 = r8.element
            float r6 = r3 - r6
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r0.$interactionSource
            androidx.compose.ui.Modifier r19 = r14.then(r1)
            r20 = r1
            int r1 = r0.$$dirty
            int r21 = r1 >> 9
            r0 = r21 & 14
            r0 = r0 | 512(0x200, float:7.175E-43)
            r21 = r3
            int r3 = r1 >> 15
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            int r1 = r1 >> 6
            r1 = r1 & r3
            r0 = r0 | r1
            r1 = r21
            r3 = r16
            r21 = r7
            r7 = r1
            r1 = r8
            r8 = r19
            r19 = r9
            r9 = r37
            r22 = r10
            r10 = r0
            androidx.compose.material.SliderKt.SliderImpl(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0375
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0375:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt$Slider$3.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final float invoke$scaleToUserValue(Ref.FloatRef minPx, Ref.FloatRef maxPx, ClosedFloatingPointRange<Float> $valueRange2, float offset) {
        return SliderKt.scale(minPx.element, maxPx.element, offset, $valueRange2.getStart().floatValue(), $valueRange2.getEndInclusive().floatValue());
    }

    /* access modifiers changed from: private */
    public static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> $valueRange2, Ref.FloatRef minPx, Ref.FloatRef maxPx, float userValue) {
        return SliderKt.scale($valueRange2.getStart().floatValue(), $valueRange2.getEndInclusive().floatValue(), userValue, minPx.element, maxPx.element);
    }
}
