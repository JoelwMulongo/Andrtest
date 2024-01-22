package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0001\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001ar\u0010\u001a\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\nH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"ExtendedFabIconPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExtendedFabSize", "ExtendedFabTextPadding", "FabSize", "ExtendedFloatingActionButton", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "onClick", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "ExtendedFloatingActionButton-wqdebIU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Landroidx/compose/runtime/Composer;II)V", "FloatingActionButton", "content", "FloatingActionButton-bogVsAg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FloatingActionButton.kt */
public final class FloatingActionButtonKt {
    /* access modifiers changed from: private */
    public static final float ExtendedFabIconPadding = Dp.m5986constructorimpl((float) 12);
    private static final float ExtendedFabSize = Dp.m5986constructorimpl((float) 48);
    /* access modifiers changed from: private */
    public static final float ExtendedFabTextPadding = Dp.m5986constructorimpl((float) 20);
    /* access modifiers changed from: private */
    public static final float FabSize = Dp.m5986constructorimpl((float) 56);

    /* JADX WARNING: Removed duplicated region for block: B:141:0x02d5  */
    /* JADX WARNING: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0127  */
    /* renamed from: FloatingActionButton-bogVsAg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1525FloatingActionButtonbogVsAg(kotlin.jvm.functions.Function0<kotlin.Unit> r29, androidx.compose.ui.Modifier r30, androidx.compose.foundation.interaction.MutableInteractionSource r31, androidx.compose.ui.graphics.Shape r32, long r33, long r35, androidx.compose.material.FloatingActionButtonElevation r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r15 = r29
            r14 = r38
            r13 = r40
            r12 = r41
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1028985328(0x3d5511f0, float:0.05201906)
            r1 = r39
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(FloatingActionButton)P(6,5,4,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)84@3963L39,85@4037L6,86@4125L6,87@4169L32,88@4279L11,97@4557L28,91@4336L718:FloatingActionButton.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r40
            r2 = r12 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            goto L_0x0038
        L_0x002a:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x0038
            boolean r2 = r11.changedInstance(r15)
            if (r2 == 0) goto L_0x0036
            r2 = 4
            goto L_0x0037
        L_0x0036:
            r2 = 2
        L_0x0037:
            r1 = r1 | r2
        L_0x0038:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0041
            r1 = r1 | 48
            r3 = r30
            goto L_0x0056
        L_0x0041:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0054
            r3 = r30
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0050
            r4 = 32
            goto L_0x0052
        L_0x0050:
            r4 = 16
        L_0x0052:
            r1 = r1 | r4
            goto L_0x0056
        L_0x0054:
            r3 = r30
        L_0x0056:
            r4 = r12 & 4
            if (r4 == 0) goto L_0x005f
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r31
            goto L_0x0074
        L_0x005f:
            r5 = r13 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0072
            r5 = r31
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x006e
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0070
        L_0x006e:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0070:
            r1 = r1 | r6
            goto L_0x0074
        L_0x0072:
            r5 = r31
        L_0x0074:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x008d
            r6 = r12 & 8
            if (r6 != 0) goto L_0x0087
            r6 = r32
            boolean r7 = r11.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0089
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x008b
        L_0x0087:
            r6 = r32
        L_0x0089:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x008b:
            r1 = r1 | r7
            goto L_0x008f
        L_0x008d:
            r6 = r32
        L_0x008f:
            r9 = 57344(0xe000, float:8.0356E-41)
            r7 = r13 & r9
            if (r7 != 0) goto L_0x00ab
            r7 = r12 & 16
            if (r7 != 0) goto L_0x00a5
            r7 = r33
            boolean r10 = r11.changed((long) r7)
            if (r10 == 0) goto L_0x00a7
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a9
        L_0x00a5:
            r7 = r33
        L_0x00a7:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x00a9:
            r1 = r1 | r10
            goto L_0x00ad
        L_0x00ab:
            r7 = r33
        L_0x00ad:
            r10 = 458752(0x70000, float:6.42848E-40)
            r16 = r13 & r10
            if (r16 != 0) goto L_0x00c9
            r16 = r12 & 32
            if (r16 != 0) goto L_0x00c2
            r9 = r35
            boolean r17 = r11.changed((long) r9)
            if (r17 == 0) goto L_0x00c4
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c6
        L_0x00c2:
            r9 = r35
        L_0x00c4:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00c6:
            r1 = r1 | r17
            goto L_0x00cb
        L_0x00c9:
            r9 = r35
        L_0x00cb:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r13 & r17
            if (r17 != 0) goto L_0x00e7
            r17 = r12 & 64
            if (r17 != 0) goto L_0x00e0
            r0 = r37
            boolean r18 = r11.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00e2
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e4
        L_0x00e0:
            r0 = r37
        L_0x00e2:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00e4:
            r1 = r1 | r18
            goto L_0x00e9
        L_0x00e7:
            r0 = r37
        L_0x00e9:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00f1
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00ef:
            r1 = r1 | r0
            goto L_0x0102
        L_0x00f1:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r13
            if (r0 != 0) goto L_0x0102
            boolean r0 = r11.changedInstance(r14)
            if (r0 == 0) goto L_0x00ff
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00ff:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00ef
        L_0x0102:
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r0 & r1
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x0127
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x0112
            goto L_0x0127
        L_0x0112:
            r11.skipToGroupEnd()
            r17 = r30
            r26 = r37
            r23 = r1
            r18 = r5
            r21 = r6
            r24 = r7
            r27 = r9
            r19 = r11
            goto L_0x02ce
        L_0x0127:
            r11.startDefaults()
            r0 = r13 & 1
            r18 = -3670017(0xffffffffffc7ffff, float:NaN)
            r3 = -458753(0xfffffffffff8ffff, float:NaN)
            r19 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0174
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x013e
            goto L_0x0174
        L_0x013e:
            r11.skipToGroupEnd()
            r0 = r12 & 8
            if (r0 == 0) goto L_0x0147
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0147:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x014d
            r1 = r1 & r19
        L_0x014d:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0152
            r1 = r1 & r3
        L_0x0152:
            r0 = r12 & 64
            if (r0 == 0) goto L_0x0166
            r0 = r1 & r18
            r18 = r5
            r21 = r6
            r24 = r7
            r8 = r9
            r10 = r30
            r6 = r37
            r7 = r0
            goto L_0x023b
        L_0x0166:
            r18 = r5
            r21 = r6
            r24 = r7
            r8 = r9
            r10 = r30
            r6 = r37
            r7 = r1
            goto L_0x023b
        L_0x0174:
            if (r2 == 0) goto L_0x017b
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x017d
        L_0x017b:
            r0 = r30
        L_0x017d:
            if (r4 == 0) goto L_0x01c1
            r2 = 0
            r4 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
            r3 = 0
            r30 = r11
            r21 = 0
            r22 = r0
            java.lang.Object r0 = r30.rememberedValue()
            r23 = 0
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r25 = r2
            java.lang.Object r2 = r24.getEmpty()
            if (r0 != r2) goto L_0x01b2
            r2 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r24 = r0
            r0 = r30
            r0.updateRememberedValue(r2)
            goto L_0x01b8
        L_0x01b2:
            r24 = r0
            r0 = r30
            r2 = r24
        L_0x01b8:
            r11.endReplaceableGroup()
            r0 = r2
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x01c4
        L_0x01c1:
            r22 = r0
            r0 = r5
        L_0x01c4:
            r2 = r12 & 8
            r3 = 6
            if (r2 == 0) goto L_0x01e4
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r2 = r2.getShapes(r11, r3)
            androidx.compose.foundation.shape.CornerBasedShape r2 = r2.getSmall()
            r4 = 50
            androidx.compose.foundation.shape.CornerSize r4 = androidx.compose.foundation.shape.CornerSizeKt.CornerSize((int) r4)
            androidx.compose.foundation.shape.CornerBasedShape r2 = r2.copy(r4)
            androidx.compose.ui.graphics.Shape r2 = (androidx.compose.ui.graphics.Shape) r2
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r21 = r2
            goto L_0x01e6
        L_0x01e4:
            r21 = r6
        L_0x01e6:
            r2 = r12 & 16
            if (r2 == 0) goto L_0x01f7
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r2 = r2.getColors(r11, r3)
            long r2 = r2.m1447getSecondary0d7_KjU()
            r1 = r1 & r19
            r7 = r2
        L_0x01f7:
            r2 = r12 & 32
            if (r2 == 0) goto L_0x020b
            int r2 = r1 >> 12
            r2 = r2 & 14
            long r2 = androidx.compose.material.ColorsKt.m1463contentColorForek8zF_U(r7, r11, r2)
            r4 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r4
            r19 = r1
            r9 = r2
            goto L_0x020d
        L_0x020b:
            r19 = r1
        L_0x020d:
            r1 = r12 & 64
            if (r1 == 0) goto L_0x0230
            androidx.compose.material.FloatingActionButtonDefaults r1 = androidx.compose.material.FloatingActionButtonDefaults.INSTANCE
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r20 = 24576(0x6000, float:3.4438E-41)
            r23 = 15
            r6 = r11
            r24 = r7
            r7 = r20
            r8 = r23
            androidx.compose.material.FloatingActionButtonElevation r1 = r1.m1523elevationxZ9QkE(r2, r3, r4, r5, r6, r7, r8)
            r2 = r19 & r18
            r18 = r0
            r6 = r1
            r7 = r2
            r8 = r9
            r10 = r22
            goto L_0x023b
        L_0x0230:
            r24 = r7
            r6 = r37
            r18 = r0
            r8 = r9
            r7 = r19
            r10 = r22
        L_0x023b:
            r11.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x024d
            r0 = -1
            java.lang.String r1 = "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:81)"
            r2 = 1028985328(0x3d5511f0, float:0.05201906)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r7, r0, r1)
        L_0x024d:
            androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2 r0 = androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r1 = 0
            r2 = 0
            r3 = 1
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r10, r2, r0, r3, r1)
            r17 = 0
            r0 = r18
            androidx.compose.foundation.interaction.InteractionSource r0 = (androidx.compose.foundation.interaction.InteractionSource) r0
            int r4 = r7 >> 6
            r4 = r4 & 14
            int r5 = r7 >> 15
            r5 = r5 & 112(0x70, float:1.57E-43)
            r4 = r4 | r5
            androidx.compose.runtime.State r0 = r6.elevation(r0, r11, r4)
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.unit.Dp r0 = (androidx.compose.ui.unit.Dp) r0
            float r19 = r0.m6000unboximpl()
            androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3 r0 = new androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3
            r0.<init>(r8, r14, r7)
            r4 = 1972871863(0x7597a2b7, float:3.8444193E32)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r4, r3, r0)
            r20 = r0
            kotlin.jvm.functions.Function2 r20 = (kotlin.jvm.functions.Function2) r20
            r0 = r7 & 14
            r3 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r3
            r3 = r7 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r7
            r0 = r0 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r7
            r0 = r0 | r3
            int r3 = r7 << 18
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r4
            r16 = r0 | r3
            r22 = 68
            r0 = r29
            r3 = r21
            r4 = r24
            r26 = r6
            r23 = r7
            r6 = r8
            r27 = r8
            r8 = r17
            r9 = r19
            r17 = r10
            r10 = r18
            r19 = r11
            r11 = r20
            r12 = r19
            r13 = r16
            r14 = r22
            androidx.compose.material.SurfaceKt.m1621SurfaceLPr_se0(r0, r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13, r14)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02ce
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02ce:
            androidx.compose.runtime.ScopeUpdateScope r13 = r19.endRestartGroup()
            if (r13 != 0) goto L_0x02d5
            goto L_0x02f4
        L_0x02d5:
            androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$4 r14 = new androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$4
            r0 = r14
            r1 = r29
            r2 = r17
            r3 = r18
            r4 = r21
            r5 = r24
            r7 = r27
            r9 = r26
            r10 = r38
            r11 = r40
            r12 = r41
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x02f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.FloatingActionButtonKt.m1525FloatingActionButtonbogVsAg(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material.FloatingActionButtonElevation, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: ExtendedFloatingActionButton-wqdebIU  reason: not valid java name */
    public static final void m1524ExtendedFloatingActionButtonwqdebIU(Function2<? super Composer, ? super Integer, Unit> text, Function0<Unit> onClick, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> icon, MutableInteractionSource interactionSource, Shape shape, long backgroundColor, long contentColor, FloatingActionButtonElevation elevation, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Function2 icon2;
        MutableInteractionSource interactionSource2;
        long backgroundColor2;
        int $dirty;
        FloatingActionButtonElevation floatingActionButtonElevation;
        Composer $composer2;
        FloatingActionButtonElevation elevation2;
        long contentColor2;
        long backgroundColor3;
        Shape shape2;
        MutableInteractionSource interactionSource3;
        Function2 icon3;
        Modifier modifier3;
        Function2 icon4;
        int $dirty2;
        Shape shape3;
        long contentColor3;
        Object value$iv$iv;
        int i2;
        int i3;
        int $dirty3;
        int i4;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function2 = text;
        Function0<Unit> function0 = onClick;
        int i6 = $changed;
        int i7 = i;
        Intrinsics.checkNotNullParameter(function2, "text");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer3 = $composer.startRestartGroup(-1555720195);
        ComposerKt.sourceInformation($composer3, "C(ExtendedFloatingActionButton)P(8,6,5,3,4,7,0:c#ui.graphics.Color,1:c#ui.graphics.Color)151@7254L39,152@7328L6,153@7416L6,154@7460L32,155@7570L11,157@7590L849:FloatingActionButton.kt#jmzs0o");
        int $dirty4 = $changed;
        if ((i7 & 1) != 0) {
            $dirty4 |= 6;
        } else if ((i6 & 14) == 0) {
            $dirty4 |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if ((i7 & 2) != 0) {
            $dirty4 |= 48;
        } else if ((i6 & 112) == 0) {
            $dirty4 |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int i8 = i7 & 4;
        if (i8 != 0) {
            $dirty4 |= 384;
            modifier2 = modifier;
        } else if ((i6 & 896) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed((Object) modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i9 = i7 & 8;
        if (i9 != 0) {
            $dirty4 |= 3072;
            icon2 = icon;
        } else if ((i6 & 7168) == 0) {
            icon2 = icon;
            $dirty4 |= $composer3.changedInstance(icon2) ? 2048 : 1024;
        } else {
            icon2 = icon;
        }
        int i10 = i7 & 16;
        if (i10 != 0) {
            $dirty4 |= 24576;
            interactionSource2 = interactionSource;
        } else if ((i6 & 57344) == 0) {
            interactionSource2 = interactionSource;
            $dirty4 |= $composer3.changed((Object) interactionSource2) ? 16384 : 8192;
        } else {
            interactionSource2 = interactionSource;
        }
        if ((i6 & 458752) == 0) {
            if ((i7 & 32) != 0) {
                Shape shape4 = shape;
            } else if ($composer3.changed((Object) shape)) {
                i5 = 131072;
                $dirty4 |= i5;
            }
            i5 = 65536;
            $dirty4 |= i5;
        } else {
            Shape shape5 = shape;
        }
        if ((i6 & 3670016) == 0) {
            if ((i7 & 64) == 0) {
                backgroundColor2 = backgroundColor;
                if ($composer3.changed(backgroundColor2)) {
                    i4 = 1048576;
                    $dirty4 |= i4;
                }
            } else {
                backgroundColor2 = backgroundColor;
            }
            i4 = 524288;
            $dirty4 |= i4;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((i6 & 29360128) == 0) {
            if ((i7 & 128) == 0) {
                $dirty3 = $dirty4;
                if ($composer3.changed(contentColor)) {
                    i3 = 8388608;
                    $dirty = $dirty3 | i3;
                }
            } else {
                $dirty3 = $dirty4;
                long j = contentColor;
            }
            i3 = 4194304;
            $dirty = $dirty3 | i3;
        } else {
            $dirty = $dirty4;
            long j2 = contentColor;
        }
        if ((i6 & 234881024) == 0) {
            if ((i7 & 256) == 0) {
                floatingActionButtonElevation = elevation;
                if ($composer3.changed((Object) floatingActionButtonElevation)) {
                    i2 = 67108864;
                    $dirty |= i2;
                }
            } else {
                floatingActionButtonElevation = elevation;
            }
            i2 = 33554432;
            $dirty |= i2;
        } else {
            floatingActionButtonElevation = elevation;
        }
        if (($dirty & 191739611) != 38347922 || !$composer3.getSkipping()) {
            $composer3.startDefaults();
            if ((i6 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i9 != 0) {
                    icon2 = null;
                }
                if (i10 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                }
                if ((i7 & 32) != 0) {
                    shape3 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    $dirty &= -458753;
                } else {
                    shape3 = shape;
                }
                if ((i7 & 64) != 0) {
                    $dirty &= -3670017;
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1447getSecondary0d7_KjU();
                }
                if ((i7 & 128) != 0) {
                    contentColor3 = ColorsKt.m1463contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty >> 18) & 14);
                    $dirty &= -29360129;
                } else {
                    contentColor3 = contentColor;
                }
                if ((i7 & 256) != 0) {
                    int i11 = $dirty & -234881025;
                    shape2 = shape3;
                    contentColor2 = contentColor3;
                    modifier3 = modifier2;
                    elevation2 = FloatingActionButtonDefaults.INSTANCE.m1523elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, $composer3, 24576, 15);
                    interactionSource3 = interactionSource2;
                    backgroundColor3 = backgroundColor2;
                    icon4 = icon2;
                    $dirty2 = i11;
                } else {
                    shape2 = shape3;
                    contentColor2 = contentColor3;
                    elevation2 = floatingActionButtonElevation;
                    interactionSource3 = interactionSource2;
                    backgroundColor3 = backgroundColor2;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                    icon4 = icon2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i7 & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i7 & 64) != 0) {
                    $dirty &= -3670017;
                }
                if ((i7 & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i7 & 256) != 0) {
                    int i12 = $dirty & -234881025;
                    shape2 = shape;
                    contentColor2 = contentColor;
                    modifier3 = modifier2;
                    elevation2 = floatingActionButtonElevation;
                    interactionSource3 = interactionSource2;
                    backgroundColor3 = backgroundColor2;
                    $dirty2 = i12;
                    icon4 = icon2;
                } else {
                    shape2 = shape;
                    contentColor2 = contentColor;
                    elevation2 = floatingActionButtonElevation;
                    interactionSource3 = interactionSource2;
                    backgroundColor3 = backgroundColor2;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                    icon4 = icon2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1555720195, $dirty2, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:146)");
            }
            float f = ExtendedFabSize;
            int i13 = $dirty2;
            icon3 = icon4;
            $composer2 = $composer3;
            m1525FloatingActionButtonbogVsAg(onClick, SizeKt.m834sizeInqDBjuR0$default(modifier3, f, f, 0.0f, 0.0f, 12, (Object) null), interactionSource3, shape2, backgroundColor3, contentColor2, elevation2, ComposableLambdaKt.composableLambda($composer3, 1418981691, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(icon4, $dirty2, function2)), $composer3, (($dirty2 >> 3) & 14) | 12582912 | (($dirty2 >> 6) & 896) | (($dirty2 >> 6) & 7168) | (($dirty2 >> 6) & 57344) | (($dirty2 >> 6) & 458752) | (($dirty2 >> 6) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            shape2 = shape;
            contentColor2 = contentColor;
            icon3 = icon2;
            elevation2 = floatingActionButtonElevation;
            interactionSource3 = interactionSource2;
            backgroundColor3 = backgroundColor2;
            $composer2 = $composer3;
            int i14 = $dirty;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new FloatingActionButtonKt$ExtendedFloatingActionButton$3(text, onClick, modifier3, icon3, interactionSource3, shape2, backgroundColor3, contentColor2, elevation2, $changed, i));
        }
    }
}
