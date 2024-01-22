package androidx.compose.foundation.pager;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Pager.kt */
final class PagerKt$Pager$4 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ int $beyondBoundsPageCount;
    final /* synthetic */ float $calculatedContentPaddings;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Density $density;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Function1<Integer, Object> $key;
    final /* synthetic */ Function3<Integer, Composer, Integer, Unit> $pageContent;
    final /* synthetic */ int $pageCount;
    final /* synthetic */ NestedScrollConnection $pageNestedScrollConnection;
    final /* synthetic */ PageSize $pageSize;
    final /* synthetic */ float $pageSpacing;
    final /* synthetic */ PagerWrapperFlingBehavior $pagerFlingBehavior;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ PagerState $state;
    final /* synthetic */ boolean $userScrollEnabled;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerKt$Pager$4(boolean z, Density density, float f, float f2, boolean z2, PagerState pagerState, int i, PaddingValues paddingValues, PagerWrapperFlingBehavior pagerWrapperFlingBehavior, boolean z3, int i2, Alignment.Horizontal horizontal, Alignment.Vertical vertical, int i3, PageSize pageSize, int i4, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection nestedScrollConnection, Function3<? super Integer, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.$isVertical = z;
        this.$density = density;
        this.$pageSpacing = f;
        this.$calculatedContentPaddings = f2;
        this.$reverseLayout = z2;
        this.$state = pagerState;
        this.$$dirty = i;
        this.$contentPadding = paddingValues;
        this.$pagerFlingBehavior = pagerWrapperFlingBehavior;
        this.$userScrollEnabled = z3;
        this.$beyondBoundsPageCount = i2;
        this.$horizontalAlignment = horizontal;
        this.$verticalAlignment = vertical;
        this.$$dirty1 = i3;
        this.$pageSize = pageSize;
        this.$pageCount = i4;
        this.$key = function1;
        this.$pageNestedScrollConnection = nestedScrollConnection;
        this.$pageContent = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((BoxWithConstraintsScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r37, androidx.compose.runtime.Composer r38, int r39) {
        /*
            r36 = this;
            r0 = r36
            r1 = r37
            r15 = r38
            r14 = r39
            java.lang.String r2 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "C298@14092L550,321@14914L298,329@15222L1387:Pager.kt#g6yjnt"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = r39
            r3 = r14 & 14
            if (r3 != 0) goto L_0x0022
            boolean r3 = r15.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0020
            r3 = 4
            goto L_0x0021
        L_0x0020:
            r3 = 2
        L_0x0021:
            r2 = r2 | r3
        L_0x0022:
            r19 = r2
            r2 = r19 & 91
            r3 = 18
            if (r2 != r3) goto L_0x0036
            boolean r2 = r38.getSkipping()
            if (r2 != 0) goto L_0x0031
            goto L_0x0036
        L_0x0031:
            r38.skipToGroupEnd()
            goto L_0x0226
        L_0x0036:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0045
            r2 = -1
            java.lang.String r3 = "androidx.compose.foundation.pager.Pager.<anonymous> (Pager.kt:295)"
            r4 = -1677736225(0xffffffff9bffc6df, float:-4.2314729E-22)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r14, r2, r3)
        L_0x0045:
            boolean r2 = r0.$isVertical
            if (r2 == 0) goto L_0x0052
            long r2 = r37.m714getConstraintsmsEJaDk()
            int r2 = androidx.compose.ui.unit.Constraints.m5929getMaxHeightimpl(r2)
            goto L_0x005a
        L_0x0052:
            long r2 = r37.m714getConstraintsmsEJaDk()
            int r2 = androidx.compose.ui.unit.Constraints.m5930getMaxWidthimpl(r2)
        L_0x005a:
            r20 = r2
            androidx.compose.ui.unit.Density r2 = r0.$density
            java.lang.Integer r3 = java.lang.Integer.valueOf(r20)
            float r4 = r0.$pageSpacing
            androidx.compose.ui.unit.Dp r4 = androidx.compose.ui.unit.Dp.m5984boximpl(r4)
            float r5 = r0.$calculatedContentPaddings
            androidx.compose.ui.unit.Dp r5 = androidx.compose.ui.unit.Dp.m5984boximpl(r5)
            java.lang.Object[] r2 = new java.lang.Object[]{r2, r3, r4, r5}
            androidx.compose.ui.unit.Density r3 = r0.$density
            float r4 = r0.$pageSpacing
            float r5 = r0.$calculatedContentPaddings
            androidx.compose.foundation.pager.PageSize r6 = r0.$pageSize
            r7 = 8
            r8 = 0
            r9 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r15.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r9)
            r10 = 0
            int r11 = r2.length
            r12 = 0
        L_0x008e:
            if (r12 >= r11) goto L_0x009b
            r13 = r2[r12]
            boolean r16 = r15.changed((java.lang.Object) r13)
            r10 = r10 | r16
            int r12 = r12 + 1
            goto L_0x008e
        L_0x009b:
            r11 = r38
            r12 = 0
            java.lang.Object r13 = r11.rememberedValue()
            r16 = 0
            if (r10 != 0) goto L_0x00b3
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r17.getEmpty()
            if (r13 != r1) goto L_0x00af
            goto L_0x00b3
        L_0x00af:
            r22 = r2
            r1 = r13
            goto L_0x00ea
        L_0x00b3:
            r1 = 0
            r17 = r3
            r18 = 0
            r21 = r1
            r1 = r17
            int r4 = r1.m5961roundToPx0680j_4(r4)
            int r5 = r1.m5961roundToPx0680j_4(r5)
            r17 = 0
            r22 = r2
            int r2 = r20 - r5
            int r2 = r6.calculateMainAxisPageSize(r3, r2, r4)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            float r1 = r1.m5964toDpu2uoSUM((int) r2)
            androidx.compose.ui.unit.Dp r1 = androidx.compose.ui.unit.Dp.m5984boximpl(r1)
            r11.updateRememberedValue(r1)
        L_0x00ea:
            r38.endReplaceableGroup()
            androidx.compose.ui.unit.Dp r1 = (androidx.compose.ui.unit.Dp) r1
            float r1 = r1.m6000unboximpl()
            boolean r2 = r0.$reverseLayout
            if (r2 != 0) goto L_0x0100
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r2 = r2.getStart()
            goto L_0x0106
        L_0x0100:
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r2 = r2.getEnd()
        L_0x0106:
            r12 = r2
            boolean r2 = r0.$reverseLayout
            if (r2 != 0) goto L_0x0112
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r2 = r2.getTop()
            goto L_0x0118
        L_0x0112:
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r2 = r2.getBottom()
        L_0x0118:
            r10 = r2
            androidx.compose.foundation.pager.PagerState r2 = r0.$state
            androidx.compose.ui.unit.Density r3 = r0.$density
            androidx.compose.foundation.pager.PagerState r4 = r0.$state
            int r5 = r0.$$dirty
            int r5 = r5 >> 3
            r5 = r5 & 14
            r6 = 0
            r7 = 1157296644(0x44faf204, float:2007.563)
            r15.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r9)
            boolean r7 = r15.changed((java.lang.Object) r2)
            r8 = r38
            r9 = 0
            java.lang.Object r11 = r8.rememberedValue()
            r13 = 0
            if (r7 != 0) goto L_0x014e
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r17 = r2
            java.lang.Object r2 = r16.getEmpty()
            if (r11 != r2) goto L_0x0148
            goto L_0x0150
        L_0x0148:
            r18 = r5
            r21 = r6
            r2 = r11
            goto L_0x017f
        L_0x014e:
            r17 = r2
        L_0x0150:
            r2 = 0
            r16 = 0
            int r3 = r3.m5961roundToPx0680j_4(r1)
            float r3 = (float) r3
            float r16 = r4.getInitialPageOffsetFraction()
            float r3 = r3 * r16
            r16 = r2
            androidx.compose.foundation.lazy.LazyListState r2 = new androidx.compose.foundation.lazy.LazyListState
            r18 = r5
            int r5 = r4.getInitialPage()
            r21 = r6
            int r6 = kotlin.math.MathKt.roundToInt((float) r3)
            r2.<init>(r5, r6)
            r5 = r2
            r6 = 0
            r4.loadNewState$foundation_release(r5)
            r8.updateRememberedValue(r2)
        L_0x017f:
            r38.endReplaceableGroup()
            r29 = r2
            androidx.compose.foundation.lazy.LazyListState r29 = (androidx.compose.foundation.lazy.LazyListState) r29
            r3 = r29
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.layout.Arrangement r4 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            float r5 = r0.$pageSpacing
            androidx.compose.foundation.layout.Arrangement$Horizontal r13 = r4.m678spacedByD5KLDUw((float) r5, (androidx.compose.ui.Alignment.Horizontal) r12)
            androidx.compose.foundation.layout.Arrangement r4 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            float r5 = r0.$pageSpacing
            androidx.compose.foundation.layout.Arrangement$Vertical r11 = r4.m679spacedByD5KLDUw((float) r5, (androidx.compose.ui.Alignment.Vertical) r10)
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.foundation.layout.PaddingValues r4 = r0.$contentPadding
            boolean r5 = r0.$reverseLayout
            boolean r6 = r0.$isVertical
            androidx.compose.foundation.pager.PagerWrapperFlingBehavior r7 = r0.$pagerFlingBehavior
            androidx.compose.foundation.gestures.FlingBehavior r7 = (androidx.compose.foundation.gestures.FlingBehavior) r7
            boolean r8 = r0.$userScrollEnabled
            int r9 = r0.$beyondBoundsPageCount
            r16 = r10
            androidx.compose.ui.Alignment$Horizontal r10 = r0.$horizontalAlignment
            r30 = r16
            r16 = r12
            androidx.compose.ui.Alignment$Vertical r12 = r0.$verticalAlignment
            r31 = r16
            androidx.compose.foundation.pager.PagerKt$Pager$4$1 r16 = new androidx.compose.foundation.pager.PagerKt$Pager$4$1
            int r14 = r0.$pageCount
            kotlin.jvm.functions.Function1<java.lang.Integer, java.lang.Object> r15 = r0.$key
            r32 = r2
            boolean r2 = r0.$isVertical
            r33 = r3
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r3 = r0.$pageNestedScrollConnection
            r34 = r4
            kotlin.jvm.functions.Function3<java.lang.Integer, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r4 = r0.$pageContent
            r35 = r5
            int r5 = r0.$$dirty1
            r21 = r16
            r22 = r14
            r23 = r15
            r24 = r2
            r25 = r1
            r26 = r3
            r27 = r4
            r28 = r5
            r21.<init>(r22, r23, r24, r25, r26, r27, r28)
            r14 = r16
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            int r2 = r0.$$dirty
            int r3 = r2 >> 21
            r3 = r3 & 896(0x380, float:1.256E-42)
            r3 = r3 | 6
            int r4 = r0.$$dirty1
            int r5 = r4 << 3
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r5
            int r4 = r4 << 15
            r5 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r5
            r3 = r3 | r4
            int r4 = r2 << 3
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r5
            r3 = r3 | r4
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r4 = r4 & r2
            r16 = r3 | r4
            int r2 = r2 >> 21
            r17 = r2 & 14
            r18 = 0
            r15 = r38
            r2 = r32
            r3 = r33
            r4 = r34
            r5 = r35
            androidx.compose.foundation.lazy.LazyListKt.LazyList(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0226
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0226:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt$Pager$4.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }
}
