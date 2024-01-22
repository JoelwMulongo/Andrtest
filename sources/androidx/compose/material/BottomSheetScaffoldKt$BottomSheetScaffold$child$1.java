package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffold$child$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ int $$dirty2;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ float $peekHeightPx;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
    final /* synthetic */ long $sheetBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ float $sheetElevation;
    final /* synthetic */ boolean $sheetGesturesEnabled;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffold$child$1(BottomSheetScaffoldState bottomSheetScaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, float f, int i, int i2, int i3, int i4, boolean z, float f2, Shape shape, float f3, long j, long j2, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function33) {
        super(2);
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$topBar = function2;
        this.$content = function3;
        this.$floatingActionButton = function22;
        this.$sheetPeekHeight = f;
        this.$floatingActionButtonPosition = i;
        this.$$dirty = i2;
        this.$$dirty2 = i3;
        this.$$dirty1 = i4;
        this.$sheetGesturesEnabled = z;
        this.$peekHeightPx = f2;
        this.$sheetShape = shape;
        this.$sheetElevation = f3;
        this.$sheetBackgroundColor = j;
        this.$sheetContentColor = j2;
        this.$sheetContent = function32;
        this.$snackbarHost = function33;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r32, int r33) {
        /*
            r31 = this;
            r0 = r31
            r12 = r32
            r13 = r33
            java.lang.String r1 = "C368@15802L50,329@13939L2100:BottomSheetScaffold.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r13 & 11
            r2 = 2
            if (r1 != r2) goto L_0x001c
            boolean r1 = r32.getSkipping()
            if (r1 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r32.skipToGroupEnd()
            goto L_0x0110
        L_0x001c:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x002b
            r1 = -1
            java.lang.String r2 = "androidx.compose.material.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:328)"
            r3 = 893101063(0x353ba407, float:6.990162E-7)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r13, r1, r2)
        L_0x002b:
            androidx.compose.material.BottomSheetScaffoldState r1 = r0.$scaffoldState
            androidx.compose.material.BottomSheetState r9 = r1.getBottomSheetState()
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r1 = r0.$topBar
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r2 = r0.$content
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1 r3 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1
            androidx.compose.material.BottomSheetScaffoldState r15 = r0.$scaffoldState
            float r4 = r0.$sheetPeekHeight
            boolean r5 = r0.$sheetGesturesEnabled
            float r6 = r0.$peekHeightPx
            androidx.compose.ui.graphics.Shape r7 = r0.$sheetShape
            float r8 = r0.$sheetElevation
            long r10 = r0.$sheetBackgroundColor
            r28 = r1
            r29 = r2
            long r1 = r0.$sheetContentColor
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r14 = r0.$sheetContent
            int r13 = r0.$$dirty
            r30 = r9
            int r9 = r0.$$dirty1
            r25 = r14
            r14 = r3
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
            r21 = r10
            r23 = r1
            r26 = r13
            r27 = r9
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r23, r25, r26, r27)
            r1 = -1378534681(0xffffffffadd53ae7, float:-2.4241454E-11)
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r1, r2, r3)
            r3 = r1
            kotlin.jvm.functions.Function3 r3 = (kotlin.jvm.functions.Function3) r3
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r4 = r0.$floatingActionButton
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1$2 r1 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1$2
            kotlin.jvm.functions.Function3<androidx.compose.material.SnackbarHostState, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.$snackbarHost
            androidx.compose.material.BottomSheetScaffoldState r6 = r0.$scaffoldState
            int r7 = r0.$$dirty
            r1.<init>(r5, r6, r7)
            r5 = -486138068(0xffffffffe3061f2c, float:-2.47411E21)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r5, r2, r1)
            r5 = r1
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            float r6 = r0.$sheetPeekHeight
            int r7 = r0.$floatingActionButtonPosition
            androidx.compose.material.BottomSheetScaffoldState r1 = r0.$scaffoldState
            androidx.compose.material.BottomSheetScaffoldState r2 = r0.$scaffoldState
            int r8 = r0.$$dirty
            int r8 = r8 >> 6
            r8 = r8 & 14
            r9 = 0
            r10 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r10)
            boolean r10 = r12.changed((java.lang.Object) r1)
            r11 = r32
            r13 = 0
            java.lang.Object r14 = r11.rememberedValue()
            r15 = 0
            if (r10 != 0) goto L_0x00c2
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r17 = r1
            java.lang.Object r1 = r16.getEmpty()
            if (r14 != r1) goto L_0x00c0
            goto L_0x00c4
        L_0x00c0:
            r1 = r14
            goto L_0x00d3
        L_0x00c2:
            r17 = r1
        L_0x00c4:
            r1 = 0
            r16 = r1
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1$3$1 r1 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1$3$1
            r1.<init>(r2)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r11.updateRememberedValue(r1)
        L_0x00d3:
            r32.endReplaceableGroup()
            r8 = r1
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            int r1 = r0.$$dirty
            int r2 = r1 >> 9
            r2 = r2 & 14
            r2 = r2 | 24960(0x6180, float:3.4976E-41)
            int r9 = r0.$$dirty2
            int r9 = r9 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            r2 = r2 | r9
            int r9 = r1 >> 6
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r9
            int r9 = r0.$$dirty1
            int r9 = r9 << 9
            r10 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r10
            r2 = r2 | r9
            r9 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r9
            r11 = r2 | r1
            r1 = r28
            r2 = r29
            r9 = r30
            r10 = r32
            androidx.compose.material.BottomSheetScaffoldKt.m1401BottomSheetScaffoldLayoutKCBPh4w(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0110
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0110:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
