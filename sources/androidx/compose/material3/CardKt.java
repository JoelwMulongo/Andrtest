package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a_\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0018\u001au\u0010\u0019\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001a\u001aS\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001b\u001a\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a]\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u001d"}, d2 = {"Card", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/CardColors;", "elevation", "Landroidx/compose/material3/CardElevation;", "border", "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedCard", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedCard", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Card.kt */
public final class CardKt {
    /* JADX WARNING: Removed duplicated region for block: B:111:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Card(androidx.compose.ui.Modifier r24, androidx.compose.ui.graphics.Shape r25, androidx.compose.material3.CardColors r26, androidx.compose.material3.CardElevation r27, androidx.compose.foundation.BorderStroke r28, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r9 = r29
            r10 = r31
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 1179621553(0x464f98b1, float:13286.173)
            r1 = r30
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Card)P(4,5,1,3)77@3629L5,78@3674L12,79@3732L15,86@3923L30,87@3991L28,88@4062L56,89@4162L57,83@3839L460:Card.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r31
            r2 = r32 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            r3 = r24
            goto L_0x0035
        L_0x0022:
            r3 = r10 & 14
            if (r3 != 0) goto L_0x0033
            r3 = r24
            boolean r4 = r8.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0030
            r4 = 4
            goto L_0x0031
        L_0x0030:
            r4 = 2
        L_0x0031:
            r1 = r1 | r4
            goto L_0x0035
        L_0x0033:
            r3 = r24
        L_0x0035:
            r4 = r10 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004e
            r4 = r32 & 2
            if (r4 != 0) goto L_0x0048
            r4 = r25
            boolean r5 = r8.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004a
            r5 = 32
            goto L_0x004c
        L_0x0048:
            r4 = r25
        L_0x004a:
            r5 = 16
        L_0x004c:
            r1 = r1 | r5
            goto L_0x0050
        L_0x004e:
            r4 = r25
        L_0x0050:
            r5 = r10 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0069
            r5 = r32 & 4
            if (r5 != 0) goto L_0x0063
            r5 = r26
            boolean r6 = r8.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0065
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0063:
            r5 = r26
        L_0x0065:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r1 = r1 | r6
            goto L_0x006b
        L_0x0069:
            r5 = r26
        L_0x006b:
            r6 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0084
            r6 = r32 & 8
            if (r6 != 0) goto L_0x007e
            r6 = r27
            boolean r7 = r8.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0080
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x007e:
            r6 = r27
        L_0x0080:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r1 = r1 | r7
            goto L_0x0086
        L_0x0084:
            r6 = r27
        L_0x0086:
            r7 = r32 & 16
            if (r7 == 0) goto L_0x008f
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r14 = r28
            goto L_0x00a6
        L_0x008f:
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r10
            if (r11 != 0) goto L_0x00a4
            r14 = r28
            boolean r11 = r8.changed((java.lang.Object) r14)
            if (r11 == 0) goto L_0x00a0
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a2
        L_0x00a0:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x00a2:
            r1 = r1 | r11
            goto L_0x00a6
        L_0x00a4:
            r14 = r28
        L_0x00a6:
            r11 = r32 & 32
            if (r11 == 0) goto L_0x00ae
            r11 = 196608(0x30000, float:2.75506E-40)
        L_0x00ac:
            r1 = r1 | r11
            goto L_0x00bf
        L_0x00ae:
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r10
            if (r11 != 0) goto L_0x00bf
            boolean r11 = r8.changed((java.lang.Object) r9)
            if (r11 == 0) goto L_0x00bc
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ac
        L_0x00bc:
            r11 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00ac
        L_0x00bf:
            r11 = 374491(0x5b6db, float:5.24774E-40)
            r11 = r11 & r1
            r12 = 74898(0x12492, float:1.04954E-40)
            if (r11 != r12) goto L_0x00db
            boolean r11 = r8.getSkipping()
            if (r11 != 0) goto L_0x00cf
            goto L_0x00db
        L_0x00cf:
            r8.skipToGroupEnd()
            r16 = r1
            r11 = r3
            r12 = r4
            r13 = r5
            r15 = r14
            r14 = r6
            goto L_0x0206
        L_0x00db:
            r8.startDefaults()
            r11 = r10 & 1
            r15 = 6
            if (r11 == 0) goto L_0x0108
            boolean r11 = r8.getDefaultsInvalid()
            if (r11 == 0) goto L_0x00ea
            goto L_0x0108
        L_0x00ea:
            r8.skipToGroupEnd()
            r2 = r32 & 2
            if (r2 == 0) goto L_0x00f3
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00f3:
            r2 = r32 & 4
            if (r2 == 0) goto L_0x00f9
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00f9:
            r2 = r32 & 8
            if (r2 == 0) goto L_0x00ff
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00ff:
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r14
            r23 = r15
            goto L_0x0168
        L_0x0108:
            if (r2 == 0) goto L_0x010f
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0110
        L_0x010f:
            r2 = r3
        L_0x0110:
            r3 = r32 & 2
            if (r3 == 0) goto L_0x011d
            androidx.compose.material3.CardDefaults r3 = androidx.compose.material3.CardDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r3 = r3.getShape(r8, r15)
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x011e
        L_0x011d:
            r3 = r4
        L_0x011e:
            r4 = r32 & 4
            if (r4 == 0) goto L_0x0143
            androidx.compose.material3.CardDefaults r11 = androidx.compose.material3.CardDefaults.INSTANCE
            r12 = 0
            r16 = 0
            r18 = 0
            r20 = 0
            r4 = 24576(0x6000, float:3.4438E-41)
            r22 = 15
            r23 = r15
            r14 = r16
            r16 = r18
            r18 = r20
            r20 = r8
            r21 = r4
            androidx.compose.material3.CardColors r4 = r11.m1774cardColorsro_MJ88(r12, r14, r16, r18, r20, r21, r22)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0146
        L_0x0143:
            r23 = r15
            r4 = r5
        L_0x0146:
            r5 = r32 & 8
            if (r5 == 0) goto L_0x0161
            androidx.compose.material3.CardDefaults r11 = androidx.compose.material3.CardDefaults.INSTANCE
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r19 = 1572864(0x180000, float:2.204052E-39)
            r20 = 63
            r18 = r8
            androidx.compose.material3.CardElevation r5 = r11.m1775cardElevationaqJV_2Y(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0162
        L_0x0161:
            r5 = r6
        L_0x0162:
            if (r7 == 0) goto L_0x0166
            r6 = 0
            goto L_0x0168
        L_0x0166:
            r6 = r28
        L_0x0168:
            r8.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0177
            r7 = -1
            java.lang.String r11 = "androidx.compose.material3.Card (Card.kt:75)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r7, r11)
        L_0x0177:
            int r0 = r1 >> 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | 6
            r7 = 1
            androidx.compose.runtime.State r0 = r4.containerColor$material3_release(r7, r8, r0)
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r13 = r0.m3174unboximpl()
            int r0 = r1 >> 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | 6
            androidx.compose.runtime.State r0 = r4.contentColor$material3_release(r7, r8, r0)
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r15 = r0.m3174unboximpl()
            int r0 = r1 >> 3
            r0 = r0 & 896(0x380, float:1.256E-42)
            r0 = r0 | 54
            r11 = 0
            androidx.compose.runtime.State r0 = r5.tonalElevation$material3_release(r7, r11, r8, r0)
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.unit.Dp r0 = (androidx.compose.ui.unit.Dp) r0
            float r17 = r0.m6000unboximpl()
            int r0 = r1 >> 3
            r0 = r0 & 896(0x380, float:1.256E-42)
            r0 = r0 | 54
            androidx.compose.runtime.State r0 = r5.shadowElevation$material3_release(r7, r11, r8, r0)
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.unit.Dp r0 = (androidx.compose.ui.unit.Dp) r0
            float r18 = r0.m6000unboximpl()
            androidx.compose.material3.CardKt$Card$1 r0 = new androidx.compose.material3.CardKt$Card$1
            r0.<init>(r9, r1)
            r11 = 664103990(0x27956c36, float:4.147313E-15)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r11, r7, r0)
            r20 = r0
            kotlin.jvm.functions.Function2 r20 = (kotlin.jvm.functions.Function2) r20
            r0 = 12582912(0xc00000, float:1.7632415E-38)
            r7 = r1 & 14
            r0 = r0 | r7
            r7 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r7
            int r7 = r1 << 6
            r11 = 3670016(0x380000, float:5.142788E-39)
            r7 = r7 & r11
            r22 = r0 | r7
            r23 = 0
            r11 = r2
            r12 = r3
            r19 = r6
            r21 = r8
            androidx.compose.material3.SurfaceKt.m2097SurfaceT9BRK9s(r11, r12, r13, r15, r17, r18, r19, r20, r21, r22, r23)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01ff
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ff:
            r16 = r1
            r11 = r2
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
        L_0x0206:
            androidx.compose.runtime.ScopeUpdateScope r7 = r8.endRestartGroup()
            if (r7 != 0) goto L_0x020f
            r18 = r8
            goto L_0x022b
        L_0x020f:
            androidx.compose.material3.CardKt$Card$2 r17 = new androidx.compose.material3.CardKt$Card$2
            r0 = r17
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r29
            r9 = r7
            r7 = r31
            r18 = r8
            r8 = r32
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x022b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CardKt.Card(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, androidx.compose.material3.CardColors, androidx.compose.material3.CardElevation, androidx.compose.foundation.BorderStroke, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x032e  */
    /* JADX WARNING: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Card(kotlin.jvm.functions.Function0<kotlin.Unit> r29, androidx.compose.ui.Modifier r30, boolean r31, androidx.compose.ui.graphics.Shape r32, androidx.compose.material3.CardColors r33, androidx.compose.material3.CardElevation r34, androidx.compose.foundation.BorderStroke r35, androidx.compose.foundation.interaction.MutableInteractionSource r36, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r13 = r29
            r11 = r37
            r10 = r39
            r3 = r40
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -2024281376(0xffffffff8757eae0, float:-1.6243826E-34)
            r1 = r38
            androidx.compose.runtime.Composer r2 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Card)P(7,6,4,8,1,3!1,5)135@6366L5,136@6411L12,137@6469L15,139@6570L39,147@6805L23,148@6866L21,149@6930L42,150@7016L43,142@6667L519:Card.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r1)
            r1 = r39
            r4 = r3 & 1
            if (r4 == 0) goto L_0x002a
            r1 = r1 | 6
            goto L_0x0038
        L_0x002a:
            r4 = r10 & 14
            if (r4 != 0) goto L_0x0038
            boolean r4 = r2.changed((java.lang.Object) r13)
            if (r4 == 0) goto L_0x0036
            r4 = 4
            goto L_0x0037
        L_0x0036:
            r4 = 2
        L_0x0037:
            r1 = r1 | r4
        L_0x0038:
            r4 = r3 & 2
            if (r4 == 0) goto L_0x0041
            r1 = r1 | 48
            r5 = r30
            goto L_0x0056
        L_0x0041:
            r5 = r10 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0054
            r5 = r30
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0050
            r6 = 32
            goto L_0x0052
        L_0x0050:
            r6 = 16
        L_0x0052:
            r1 = r1 | r6
            goto L_0x0056
        L_0x0054:
            r5 = r30
        L_0x0056:
            r6 = r3 & 4
            if (r6 == 0) goto L_0x005f
            r1 = r1 | 384(0x180, float:5.38E-43)
            r7 = r31
            goto L_0x0074
        L_0x005f:
            r7 = r10 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0072
            r7 = r31
            boolean r8 = r2.changed((boolean) r7)
            if (r8 == 0) goto L_0x006e
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0070
        L_0x006e:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0070:
            r1 = r1 | r8
            goto L_0x0074
        L_0x0072:
            r7 = r31
        L_0x0074:
            r8 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x008d
            r8 = r3 & 8
            if (r8 != 0) goto L_0x0087
            r8 = r32
            boolean r9 = r2.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0089
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x008b
        L_0x0087:
            r8 = r32
        L_0x0089:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x008b:
            r1 = r1 | r9
            goto L_0x008f
        L_0x008d:
            r8 = r32
        L_0x008f:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r10
            if (r9 != 0) goto L_0x00aa
            r9 = r3 & 16
            if (r9 != 0) goto L_0x00a4
            r9 = r33
            boolean r12 = r2.changed((java.lang.Object) r9)
            if (r12 == 0) goto L_0x00a6
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a8
        L_0x00a4:
            r9 = r33
        L_0x00a6:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x00a8:
            r1 = r1 | r12
            goto L_0x00ac
        L_0x00aa:
            r9 = r33
        L_0x00ac:
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r10
            if (r12 != 0) goto L_0x00c6
            r12 = r3 & 32
            if (r12 != 0) goto L_0x00c0
            r12 = r34
            boolean r14 = r2.changed((java.lang.Object) r12)
            if (r14 == 0) goto L_0x00c2
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c4
        L_0x00c0:
            r12 = r34
        L_0x00c2:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00c4:
            r1 = r1 | r14
            goto L_0x00c8
        L_0x00c6:
            r12 = r34
        L_0x00c8:
            r26 = r3 & 64
            if (r26 == 0) goto L_0x00d2
            r14 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r14
            r15 = r35
            goto L_0x00e8
        L_0x00d2:
            r14 = 3670016(0x380000, float:5.142788E-39)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00e6
            r15 = r35
            boolean r14 = r2.changed((java.lang.Object) r15)
            if (r14 == 0) goto L_0x00e2
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e4
        L_0x00e2:
            r14 = 524288(0x80000, float:7.34684E-40)
        L_0x00e4:
            r1 = r1 | r14
            goto L_0x00e8
        L_0x00e6:
            r15 = r35
        L_0x00e8:
            r14 = r3 & 128(0x80, float:1.794E-43)
            if (r14 == 0) goto L_0x00f3
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r16
            r0 = r36
            goto L_0x010b
        L_0x00f3:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r10 & r16
            if (r16 != 0) goto L_0x0109
            r0 = r36
            boolean r16 = r2.changed((java.lang.Object) r0)
            if (r16 == 0) goto L_0x0104
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0106
        L_0x0104:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x0106:
            r1 = r1 | r16
            goto L_0x010b
        L_0x0109:
            r0 = r36
        L_0x010b:
            r0 = r3 & 256(0x100, float:3.59E-43)
            r27 = 234881024(0xe000000, float:1.5777218E-30)
            if (r0 == 0) goto L_0x0115
            r0 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x0113:
            r1 = r1 | r0
            goto L_0x0125
        L_0x0115:
            r0 = r10 & r27
            if (r0 != 0) goto L_0x0125
            boolean r0 = r2.changed((java.lang.Object) r11)
            if (r0 == 0) goto L_0x0122
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0113
        L_0x0122:
            r0 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x0113
        L_0x0125:
            r0 = 191739611(0xb6db6db, float:4.5782105E-32)
            r0 = r0 & r1
            r5 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r5) goto L_0x014a
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x0135
            goto L_0x014a
        L_0x0135:
            r2.skipToGroupEnd()
            r17 = r30
            r20 = r36
            r23 = r1
            r25 = r2
            r22 = r7
            r18 = r8
            r21 = r9
            r24 = r12
            goto L_0x0327
        L_0x014a:
            r2.startDefaults()
            r0 = r10 & 1
            r5 = -458753(0xfffffffffff8ffff, float:NaN)
            r28 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x018f
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x015e
            goto L_0x018f
        L_0x015e:
            r2.skipToGroupEnd()
            r0 = r3 & 8
            if (r0 == 0) goto L_0x0167
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0167:
            r0 = r3 & 16
            if (r0 == 0) goto L_0x016d
            r1 = r1 & r28
        L_0x016d:
            r0 = r3 & 32
            if (r0 == 0) goto L_0x0181
            r0 = r1 & r5
            r17 = r30
            r20 = r36
            r14 = r0
            r1 = r7
            r18 = r8
            r0 = r9
            r19 = r15
            r15 = r12
            goto L_0x024e
        L_0x0181:
            r17 = r30
            r20 = r36
            r14 = r1
            r1 = r7
            r18 = r8
            r0 = r9
            r19 = r15
            r15 = r12
            goto L_0x024e
        L_0x018f:
            if (r4 == 0) goto L_0x0196
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0198
        L_0x0196:
            r0 = r30
        L_0x0198:
            if (r6 == 0) goto L_0x019c
            r4 = 1
            goto L_0x019d
        L_0x019c:
            r4 = r7
        L_0x019d:
            r6 = r3 & 8
            if (r6 == 0) goto L_0x01ab
            androidx.compose.material3.CardDefaults r6 = androidx.compose.material3.CardDefaults.INSTANCE
            r7 = 6
            androidx.compose.ui.graphics.Shape r6 = r6.getShape(r2, r7)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x01ac
        L_0x01ab:
            r6 = r8
        L_0x01ac:
            r7 = r3 & 16
            if (r7 == 0) goto L_0x01d1
            androidx.compose.material3.CardDefaults r7 = androidx.compose.material3.CardDefaults.INSTANCE
            r16 = 0
            r18 = 0
            r20 = 0
            r22 = 0
            r24 = 24576(0x6000, float:3.4438E-41)
            r25 = 15
            r8 = r14
            r14 = r7
            r15 = r16
            r17 = r18
            r19 = r20
            r21 = r22
            r23 = r2
            androidx.compose.material3.CardColors r7 = r14.m1774cardColorsro_MJ88(r15, r17, r19, r21, r23, r24, r25)
            r1 = r1 & r28
            goto L_0x01d3
        L_0x01d1:
            r8 = r14
            r7 = r9
        L_0x01d3:
            r9 = r3 & 32
            if (r9 == 0) goto L_0x01f0
            androidx.compose.material3.CardDefaults r14 = androidx.compose.material3.CardDefaults.INSTANCE
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = 1572864(0x180000, float:2.204052E-39)
            r23 = 63
            r21 = r2
            androidx.compose.material3.CardElevation r9 = r14.m1775cardElevationaqJV_2Y(r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r1 = r1 & r5
            goto L_0x01f1
        L_0x01f0:
            r9 = r12
        L_0x01f1:
            if (r26 == 0) goto L_0x01f5
            r5 = 0
            goto L_0x01f7
        L_0x01f5:
            r5 = r35
        L_0x01f7:
            if (r8 == 0) goto L_0x023d
            r8 = 0
            r12 = 0
            r14 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r2.startReplaceableGroup(r14)
            java.lang.String r14 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r14)
            r14 = 0
            r15 = r2
            r16 = 0
            r30 = r0
            java.lang.Object r0 = r15.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r31 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r0 != r1) goto L_0x0226
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r15.updateRememberedValue(r1)
            goto L_0x0227
        L_0x0226:
            r1 = r0
        L_0x0227:
            r2.endReplaceableGroup()
            r0 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r17 = r30
            r14 = r31
            r20 = r0
            r1 = r4
            r19 = r5
            r18 = r6
            r0 = r7
            r15 = r9
            goto L_0x024e
        L_0x023d:
            r30 = r0
            r31 = r1
            r17 = r30
            r14 = r31
            r20 = r36
            r1 = r4
            r19 = r5
            r18 = r6
            r0 = r7
            r15 = r9
        L_0x024e:
            r2.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0260
            r4 = -1
            java.lang.String r5 = "androidx.compose.material3.Card (Card.kt:131)"
            r6 = -2024281376(0xffffffff8757eae0, float:-1.6243826E-34)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r14, r4, r5)
        L_0x0260:
            int r4 = r14 >> 6
            r4 = r4 & 14
            int r5 = r14 >> 9
            r5 = r5 & 112(0x70, float:1.57E-43)
            r4 = r4 | r5
            androidx.compose.runtime.State r4 = r0.containerColor$material3_release(r1, r2, r4)
            java.lang.Object r4 = r4.getValue()
            androidx.compose.ui.graphics.Color r4 = (androidx.compose.ui.graphics.Color) r4
            long r4 = r4.m3174unboximpl()
            int r6 = r14 >> 6
            r6 = r6 & 14
            int r7 = r14 >> 9
            r7 = r7 & 112(0x70, float:1.57E-43)
            r6 = r6 | r7
            androidx.compose.runtime.State r6 = r0.contentColor$material3_release(r1, r2, r6)
            java.lang.Object r6 = r6.getValue()
            androidx.compose.ui.graphics.Color r6 = (androidx.compose.ui.graphics.Color) r6
            long r6 = r6.m3174unboximpl()
            r8 = r20
            androidx.compose.foundation.interaction.InteractionSource r8 = (androidx.compose.foundation.interaction.InteractionSource) r8
            int r9 = r14 >> 6
            r9 = r9 & 14
            int r12 = r14 >> 18
            r12 = r12 & 112(0x70, float:1.57E-43)
            r9 = r9 | r12
            int r12 = r14 >> 9
            r12 = r12 & 896(0x380, float:1.256E-42)
            r9 = r9 | r12
            androidx.compose.runtime.State r8 = r15.tonalElevation$material3_release(r1, r8, r2, r9)
            java.lang.Object r8 = r8.getValue()
            androidx.compose.ui.unit.Dp r8 = (androidx.compose.ui.unit.Dp) r8
            float r8 = r8.m6000unboximpl()
            r9 = r20
            androidx.compose.foundation.interaction.InteractionSource r9 = (androidx.compose.foundation.interaction.InteractionSource) r9
            int r12 = r14 >> 6
            r12 = r12 & 14
            int r16 = r14 >> 18
            r16 = r16 & 112(0x70, float:1.57E-43)
            r12 = r12 | r16
            r21 = r0
            int r0 = r14 >> 9
            r0 = r0 & 896(0x380, float:1.256E-42)
            r0 = r0 | r12
            androidx.compose.runtime.State r0 = r15.shadowElevation$material3_release(r1, r9, r2, r0)
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.unit.Dp r0 = (androidx.compose.ui.unit.Dp) r0
            float r9 = r0.m6000unboximpl()
            androidx.compose.material3.CardKt$Card$4 r0 = new androidx.compose.material3.CardKt$Card$4
            r0.<init>(r11, r14)
            r12 = 776921067(0x2e4edfeb, float:4.7037856E-11)
            r22 = r1
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r12, r1, r0)
            r12 = r0
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r0 = r14 & 14
            r1 = r14 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r14 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r14 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r14 << 6
            r1 = r1 & r27
            r0 = r0 | r1
            int r1 = r14 << 6
            r16 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r16
            r0 = r0 | r1
            r23 = r14
            r14 = r0
            r0 = 6
            r24 = r15
            r15 = r0
            r16 = 0
            r0 = r29
            r1 = r17
            r25 = r2
            r2 = r22
            r3 = r18
            r10 = r19
            r11 = r20
            r13 = r25
            androidx.compose.material3.SurfaceKt.m2100Surfaceo_FOJdg(r0, r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0325
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0325:
            r15 = r19
        L_0x0327:
            androidx.compose.runtime.ScopeUpdateScope r12 = r25.endRestartGroup()
            if (r12 != 0) goto L_0x032e
            goto L_0x034e
        L_0x032e:
            androidx.compose.material3.CardKt$Card$5 r13 = new androidx.compose.material3.CardKt$Card$5
            r0 = r13
            r1 = r29
            r2 = r17
            r3 = r22
            r4 = r18
            r5 = r21
            r6 = r24
            r7 = r15
            r8 = r20
            r9 = r37
            r10 = r39
            r11 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x034e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CardKt.Card(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, androidx.compose.material3.CardColors, androidx.compose.material3.CardElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void ElevatedCard(Modifier modifier, Shape shape, CardColors colors, CardElevation elevation, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Shape shape2;
        CardColors cardColors;
        CardElevation cardElevation;
        Composer $composer2;
        CardElevation elevation2;
        CardColors colors2;
        Shape shape3;
        Modifier modifier3;
        int $dirty;
        Modifier modifier4;
        Shape shape4;
        CardColors colors3;
        int i2;
        int i3;
        int i4;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3 = content;
        int i5 = $changed;
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer3 = $composer.startRestartGroup(895940201);
        ComposerKt.sourceInformation($composer3, "C(ElevatedCard)P(3,4!1,2)185@8633L13,186@8686L20,187@8752L23,189@8829L140:Card.kt#uh7d8r");
        int $dirty2 = $changed;
        int i6 = i & 1;
        if (i6 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if ((i5 & 14) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i5 & 112) == 0) {
            if ((i & 2) == 0) {
                shape2 = shape;
                if ($composer3.changed((Object) shape2)) {
                    i4 = 32;
                    $dirty2 |= i4;
                }
            } else {
                shape2 = shape;
            }
            i4 = 16;
            $dirty2 |= i4;
        } else {
            shape2 = shape;
        }
        if ((i5 & 896) == 0) {
            if ((i & 4) == 0) {
                cardColors = colors;
                if ($composer3.changed((Object) cardColors)) {
                    i3 = 256;
                    $dirty2 |= i3;
                }
            } else {
                cardColors = colors;
            }
            i3 = 128;
            $dirty2 |= i3;
        } else {
            cardColors = colors;
        }
        if ((i5 & 7168) == 0) {
            if ((i & 8) == 0) {
                cardElevation = elevation;
                if ($composer3.changed((Object) cardElevation)) {
                    i2 = 2048;
                    $dirty2 |= i2;
                }
            } else {
                cardElevation = elevation;
            }
            i2 = 1024;
            $dirty2 |= i2;
        } else {
            cardElevation = elevation;
        }
        if ((i & 16) != 0) {
            $dirty2 |= 24576;
        } else if ((57344 & i5) == 0) {
            $dirty2 |= $composer3.changed((Object) function3) ? 16384 : 8192;
        }
        if ((46811 & $dirty2) != 9362 || !$composer3.getSkipping()) {
            $composer3.startDefaults();
            if ((i5 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 2) != 0) {
                    shape4 = CardDefaults.INSTANCE.getElevatedShape($composer3, 6);
                    $dirty2 &= -113;
                } else {
                    shape4 = shape2;
                }
                if ((i & 4) != 0) {
                    colors3 = CardDefaults.INSTANCE.m1776elevatedCardColorsro_MJ88(0, 0, 0, 0, $composer3, 24576, 15);
                    $dirty2 &= -897;
                } else {
                    colors3 = cardColors;
                }
                if ((i & 8) != 0) {
                    $dirty = $dirty2 & -7169;
                    modifier3 = modifier4;
                    shape3 = shape4;
                    colors2 = colors3;
                    elevation2 = CardDefaults.INSTANCE.m1777elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    shape3 = shape4;
                    colors2 = colors3;
                    elevation2 = cardElevation;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                shape3 = shape2;
                colors2 = cardColors;
                elevation2 = cardElevation;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(895940201, $dirty, -1, "androidx.compose.material3.ElevatedCard (Card.kt:183)");
            }
            $composer2 = $composer3;
            Card(modifier3, shape3, colors2, elevation2, (BorderStroke) null, content, $composer3, ($dirty & 14) | 24576 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty << 3) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            int i7 = $dirty2;
            modifier3 = modifier2;
            shape3 = shape2;
            colors2 = cardColors;
            elevation2 = cardElevation;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CardKt$ElevatedCard$1(modifier3, shape3, colors2, elevation2, content, $changed, i));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:138:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x012a  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ElevatedCard(kotlin.jvm.functions.Function0<kotlin.Unit> r36, androidx.compose.ui.Modifier r37, boolean r38, androidx.compose.ui.graphics.Shape r39, androidx.compose.material3.CardColors r40, androidx.compose.material3.CardElevation r41, androidx.compose.foundation.interaction.MutableInteractionSource r42, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, androidx.compose.runtime.Composer r44, int r45, int r46) {
        /*
            r12 = r36
            r13 = r43
            r14 = r45
            r15 = r46
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -1850977784(0xffffffff91ac5208, float:-2.718737E-28)
            r1 = r44
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ElevatedCard)P(6,5,3,7!1,2,4)234@10976L13,235@11029L20,236@11095L23,237@11170L39,239@11263L229:Card.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r45
            r2 = r15 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            goto L_0x0038
        L_0x002a:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x0038
            boolean r2 = r11.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x0036
            r2 = 4
            goto L_0x0037
        L_0x0036:
            r2 = 2
        L_0x0037:
            r1 = r1 | r2
        L_0x0038:
            r2 = r15 & 2
            if (r2 == 0) goto L_0x0041
            r1 = r1 | 48
            r3 = r37
            goto L_0x0056
        L_0x0041:
            r3 = r14 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0054
            r3 = r37
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
            r3 = r37
        L_0x0056:
            r4 = r15 & 4
            if (r4 == 0) goto L_0x005f
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r38
            goto L_0x0074
        L_0x005f:
            r5 = r14 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0072
            r5 = r38
            boolean r6 = r11.changed((boolean) r5)
            if (r6 == 0) goto L_0x006e
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0070
        L_0x006e:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0070:
            r1 = r1 | r6
            goto L_0x0074
        L_0x0072:
            r5 = r38
        L_0x0074:
            r6 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x008d
            r6 = r15 & 8
            if (r6 != 0) goto L_0x0087
            r6 = r39
            boolean r7 = r11.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0089
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x008b
        L_0x0087:
            r6 = r39
        L_0x0089:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x008b:
            r1 = r1 | r7
            goto L_0x008f
        L_0x008d:
            r6 = r39
        L_0x008f:
            r28 = 57344(0xe000, float:8.0356E-41)
            r7 = r14 & r28
            if (r7 != 0) goto L_0x00ab
            r7 = r15 & 16
            if (r7 != 0) goto L_0x00a5
            r7 = r40
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x00a7
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a9
        L_0x00a5:
            r7 = r40
        L_0x00a7:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x00a9:
            r1 = r1 | r8
            goto L_0x00ad
        L_0x00ab:
            r7 = r40
        L_0x00ad:
            r29 = 458752(0x70000, float:6.42848E-40)
            r8 = r14 & r29
            if (r8 != 0) goto L_0x00c8
            r8 = r15 & 32
            if (r8 != 0) goto L_0x00c2
            r10 = r41
            boolean r8 = r11.changed((java.lang.Object) r10)
            if (r8 == 0) goto L_0x00c4
            r8 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c6
        L_0x00c2:
            r10 = r41
        L_0x00c4:
            r8 = 65536(0x10000, float:9.18355E-41)
        L_0x00c6:
            r1 = r1 | r8
            goto L_0x00ca
        L_0x00c8:
            r10 = r41
        L_0x00ca:
            r30 = r15 & 64
            r31 = 1572864(0x180000, float:2.204052E-39)
            if (r30 == 0) goto L_0x00d5
            r1 = r1 | r31
            r9 = r42
            goto L_0x00eb
        L_0x00d5:
            r8 = 3670016(0x380000, float:5.142788E-39)
            r8 = r8 & r14
            if (r8 != 0) goto L_0x00e9
            r9 = r42
            boolean r8 = r11.changed((java.lang.Object) r9)
            if (r8 == 0) goto L_0x00e5
            r8 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e7
        L_0x00e5:
            r8 = 524288(0x80000, float:7.34684E-40)
        L_0x00e7:
            r1 = r1 | r8
            goto L_0x00eb
        L_0x00e9:
            r9 = r42
        L_0x00eb:
            r8 = r15 & 128(0x80, float:1.794E-43)
            r32 = 29360128(0x1c00000, float:7.052966E-38)
            if (r8 == 0) goto L_0x00f5
            r8 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00f3:
            r1 = r1 | r8
            goto L_0x0105
        L_0x00f5:
            r8 = r14 & r32
            if (r8 != 0) goto L_0x0105
            boolean r8 = r11.changed((java.lang.Object) r13)
            if (r8 == 0) goto L_0x0102
            r8 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f3
        L_0x0102:
            r8 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00f3
        L_0x0105:
            r8 = 23967451(0x16db6db, float:4.3661218E-38)
            r8 = r8 & r1
            r0 = 4793490(0x492492, float:6.71711E-39)
            if (r8 != r0) goto L_0x012a
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x0115
            goto L_0x012a
        L_0x0115:
            r11.skipToGroupEnd()
            r22 = r1
            r16 = r3
            r34 = r5
            r35 = r6
            r17 = r7
            r19 = r9
            r18 = r10
            r20 = r11
            goto L_0x0279
        L_0x012a:
            r11.startDefaults()
            r0 = r14 & 1
            r33 = -458753(0xfffffffffff8ffff, float:NaN)
            r8 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0170
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x013e
            goto L_0x0170
        L_0x013e:
            r11.skipToGroupEnd()
            r0 = r15 & 8
            if (r0 == 0) goto L_0x0147
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0147:
            r0 = r15 & 16
            if (r0 == 0) goto L_0x014c
            r1 = r1 & r8
        L_0x014c:
            r0 = r15 & 32
            if (r0 == 0) goto L_0x0161
            r0 = r1 & r33
            r16 = r3
            r34 = r5
            r35 = r6
            r17 = r7
            r19 = r9
            r18 = r10
            r10 = r0
            goto L_0x0219
        L_0x0161:
            r16 = r3
            r34 = r5
            r35 = r6
            r17 = r7
            r19 = r9
            r18 = r10
            r10 = r1
            goto L_0x0219
        L_0x0170:
            if (r2 == 0) goto L_0x0177
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0178
        L_0x0177:
            r0 = r3
        L_0x0178:
            if (r4 == 0) goto L_0x017e
            r2 = 1
            r34 = r2
            goto L_0x0180
        L_0x017e:
            r34 = r5
        L_0x0180:
            r2 = r15 & 8
            if (r2 == 0) goto L_0x0190
            androidx.compose.material3.CardDefaults r2 = androidx.compose.material3.CardDefaults.INSTANCE
            r3 = 6
            androidx.compose.ui.graphics.Shape r2 = r2.getElevatedShape(r11, r3)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r35 = r2
            goto L_0x0192
        L_0x0190:
            r35 = r6
        L_0x0192:
            r2 = r15 & 16
            if (r2 == 0) goto L_0x01b0
            androidx.compose.material3.CardDefaults r16 = androidx.compose.material3.CardDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r26 = 24576(0x6000, float:3.4438E-41)
            r27 = 15
            r25 = r11
            androidx.compose.material3.CardColors r2 = r16.m1776elevatedCardColorsro_MJ88(r17, r19, r21, r23, r25, r26, r27)
            r1 = r1 & r8
            r17 = r1
            r16 = r2
            goto L_0x01b4
        L_0x01b0:
            r17 = r1
            r16 = r7
        L_0x01b4:
            r1 = r15 & 32
            if (r1 == 0) goto L_0x01d0
            androidx.compose.material3.CardDefaults r1 = androidx.compose.material3.CardDefaults.INSTANCE
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r18 = 1572864(0x180000, float:2.204052E-39)
            r19 = 63
            r8 = r11
            r9 = r18
            r10 = r19
            androidx.compose.material3.CardElevation r1 = r1.m1777elevatedCardElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r17 = r17 & r33
            goto L_0x01d2
        L_0x01d0:
            r1 = r41
        L_0x01d2:
            if (r30 == 0) goto L_0x020f
            r2 = 0
            r3 = 0
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r4)
            java.lang.String r4 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            r4 = 0
            r5 = r11
            r6 = 0
            java.lang.Object r7 = r5.rememberedValue()
            r8 = 0
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r7 != r9) goto L_0x01fb
            r9 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r5.updateRememberedValue(r9)
            goto L_0x01fc
        L_0x01fb:
            r9 = r7
        L_0x01fc:
            r11.endReplaceableGroup()
            r2 = r9
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            r18 = r1
            r19 = r2
            r10 = r17
            r17 = r16
            r16 = r0
            goto L_0x0219
        L_0x020f:
            r19 = r42
            r18 = r1
            r10 = r17
            r17 = r16
            r16 = r0
        L_0x0219:
            r11.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x022b
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.ElevatedCard (Card.kt:230)"
            r2 = -1850977784(0xffffffff91ac5208, float:-2.718737E-28)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r10, r0, r1)
        L_0x022b:
            r6 = 0
            r0 = r10 & 14
            r0 = r0 | r31
            r1 = r10 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r10 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r10 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = r10 & r28
            r0 = r0 | r1
            r1 = r10 & r29
            r0 = r0 | r1
            int r1 = r10 << 3
            r1 = r1 & r32
            r0 = r0 | r1
            r1 = 234881024(0xe000000, float:1.5777218E-30)
            int r2 = r10 << 3
            r1 = r1 & r2
            r20 = r0 | r1
            r21 = 0
            r0 = r36
            r1 = r16
            r2 = r34
            r3 = r35
            r4 = r17
            r5 = r18
            r7 = r19
            r8 = r43
            r9 = r11
            r22 = r10
            r10 = r20
            r20 = r11
            r11 = r21
            Card(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0279
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0279:
            androidx.compose.runtime.ScopeUpdateScope r11 = r20.endRestartGroup()
            if (r11 != 0) goto L_0x0280
            goto L_0x02a2
        L_0x0280:
            androidx.compose.material3.CardKt$ElevatedCard$3 r21 = new androidx.compose.material3.CardKt$ElevatedCard$3
            r0 = r21
            r1 = r36
            r2 = r16
            r3 = r34
            r4 = r35
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r43
            r9 = r45
            r10 = r46
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r21
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x02a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CardKt.ElevatedCard(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, androidx.compose.material3.CardColors, androidx.compose.material3.CardElevation, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void OutlinedCard(androidx.compose.ui.Modifier r25, androidx.compose.ui.graphics.Shape r26, androidx.compose.material3.CardColors r27, androidx.compose.material3.CardElevation r28, androidx.compose.foundation.BorderStroke r29, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r9 = r30
            r10 = r32
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 740336179(0x2c20a233, float:2.2827406E-12)
            r1 = r31
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(OutlinedCard)P(4,5,1,3)279@13027L13,280@13080L20,281@13146L23,282@13211L20,284@13285L142:Card.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r32
            r2 = r33 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            r3 = r25
            goto L_0x0035
        L_0x0022:
            r3 = r10 & 14
            if (r3 != 0) goto L_0x0033
            r3 = r25
            boolean r4 = r8.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0030
            r4 = 4
            goto L_0x0031
        L_0x0030:
            r4 = 2
        L_0x0031:
            r1 = r1 | r4
            goto L_0x0035
        L_0x0033:
            r3 = r25
        L_0x0035:
            r4 = r10 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004e
            r4 = r33 & 2
            if (r4 != 0) goto L_0x0048
            r4 = r26
            boolean r5 = r8.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004a
            r5 = 32
            goto L_0x004c
        L_0x0048:
            r4 = r26
        L_0x004a:
            r5 = 16
        L_0x004c:
            r1 = r1 | r5
            goto L_0x0050
        L_0x004e:
            r4 = r26
        L_0x0050:
            r5 = r10 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0069
            r5 = r33 & 4
            if (r5 != 0) goto L_0x0063
            r5 = r27
            boolean r6 = r8.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0065
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0063:
            r5 = r27
        L_0x0065:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r1 = r1 | r6
            goto L_0x006b
        L_0x0069:
            r5 = r27
        L_0x006b:
            r6 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0084
            r6 = r33 & 8
            if (r6 != 0) goto L_0x007e
            r6 = r28
            boolean r7 = r8.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0080
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x007e:
            r6 = r28
        L_0x0080:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r1 = r1 | r7
            goto L_0x0086
        L_0x0084:
            r6 = r28
        L_0x0086:
            r7 = 57344(0xe000, float:8.0356E-41)
            r11 = r10 & r7
            if (r11 != 0) goto L_0x00a2
            r11 = r33 & 16
            if (r11 != 0) goto L_0x009c
            r14 = r29
            boolean r11 = r8.changed((java.lang.Object) r14)
            if (r11 == 0) goto L_0x009e
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a0
        L_0x009c:
            r14 = r29
        L_0x009e:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x00a0:
            r1 = r1 | r11
            goto L_0x00a4
        L_0x00a2:
            r14 = r29
        L_0x00a4:
            r11 = r33 & 32
            r23 = 458752(0x70000, float:6.42848E-40)
            if (r11 == 0) goto L_0x00ae
            r11 = 196608(0x30000, float:2.75506E-40)
        L_0x00ac:
            r1 = r1 | r11
            goto L_0x00be
        L_0x00ae:
            r11 = r10 & r23
            if (r11 != 0) goto L_0x00be
            boolean r11 = r8.changed((java.lang.Object) r9)
            if (r11 == 0) goto L_0x00bb
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ac
        L_0x00bb:
            r11 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00ac
        L_0x00be:
            r11 = 374491(0x5b6db, float:5.24774E-40)
            r11 = r11 & r1
            r12 = 74898(0x12492, float:1.04954E-40)
            if (r11 != r12) goto L_0x00dc
            boolean r11 = r8.getSkipping()
            if (r11 != 0) goto L_0x00ce
            goto L_0x00dc
        L_0x00ce:
            r8.skipToGroupEnd()
            r17 = r1
            r11 = r3
            r12 = r4
            r13 = r5
            r18 = r8
            r15 = r14
            r14 = r6
            goto L_0x01cc
        L_0x00dc:
            r8.startDefaults()
            r11 = r10 & 1
            r24 = -57345(0xffffffffffff1fff, float:NaN)
            if (r11 == 0) goto L_0x0118
            boolean r11 = r8.getDefaultsInvalid()
            if (r11 == 0) goto L_0x00ed
            goto L_0x0118
        L_0x00ed:
            r8.skipToGroupEnd()
            r2 = r33 & 2
            if (r2 == 0) goto L_0x00f6
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00f6:
            r2 = r33 & 4
            if (r2 == 0) goto L_0x00fc
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00fc:
            r2 = r33 & 8
            if (r2 == 0) goto L_0x0102
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0102:
            r2 = r33 & 16
            if (r2 == 0) goto L_0x0110
            r1 = r1 & r24
            r11 = r3
            r12 = r4
            r13 = r5
            r15 = r14
            r14 = r6
            r6 = r1
            goto L_0x018a
        L_0x0110:
            r11 = r3
            r12 = r4
            r13 = r5
            r15 = r14
            r14 = r6
            r6 = r1
            goto L_0x018a
        L_0x0118:
            if (r2 == 0) goto L_0x011f
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0120
        L_0x011f:
            r2 = r3
        L_0x0120:
            r3 = r33 & 2
            if (r3 == 0) goto L_0x012e
            androidx.compose.material3.CardDefaults r3 = androidx.compose.material3.CardDefaults.INSTANCE
            r11 = 6
            androidx.compose.ui.graphics.Shape r3 = r3.getOutlinedShape(r8, r11)
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x012f
        L_0x012e:
            r3 = r4
        L_0x012f:
            r4 = r33 & 4
            if (r4 == 0) goto L_0x014f
            androidx.compose.material3.CardDefaults r11 = androidx.compose.material3.CardDefaults.INSTANCE
            r12 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r21 = 24576(0x6000, float:3.4438E-41)
            r22 = 15
            r14 = r15
            r16 = r17
            r18 = r19
            r20 = r8
            androidx.compose.material3.CardColors r4 = r11.m1778outlinedCardColorsro_MJ88(r12, r14, r16, r18, r20, r21, r22)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0150
        L_0x014f:
            r4 = r5
        L_0x0150:
            r5 = r33 & 8
            if (r5 == 0) goto L_0x016b
            androidx.compose.material3.CardDefaults r11 = androidx.compose.material3.CardDefaults.INSTANCE
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r19 = 1572864(0x180000, float:2.204052E-39)
            r20 = 63
            r18 = r8
            androidx.compose.material3.CardElevation r5 = r11.m1779outlinedCardElevationaqJV_2Y(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x016c
        L_0x016b:
            r5 = r6
        L_0x016c:
            r6 = r33 & 16
            if (r6 == 0) goto L_0x0183
            androidx.compose.material3.CardDefaults r6 = androidx.compose.material3.CardDefaults.INSTANCE
            r11 = 0
            r12 = 48
            r13 = 1
            androidx.compose.foundation.BorderStroke r6 = r6.outlinedCardBorder(r11, r8, r12, r13)
            r1 = r1 & r24
            r11 = r2
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r6 = r1
            goto L_0x018a
        L_0x0183:
            r15 = r29
            r6 = r1
            r11 = r2
            r12 = r3
            r13 = r4
            r14 = r5
        L_0x018a:
            r8.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0199
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.OutlinedCard (Card.kt:277)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r1, r2)
        L_0x0199:
            r0 = r6 & 14
            r1 = r6 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r6 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r6 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = r6 & r7
            r0 = r0 | r1
            r1 = r6 & r23
            r7 = r0 | r1
            r16 = 0
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r30
            r17 = r6
            r6 = r8
            r18 = r8
            r8 = r16
            Card(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01cc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01cc:
            androidx.compose.runtime.ScopeUpdateScope r8 = r18.endRestartGroup()
            if (r8 != 0) goto L_0x01d3
            goto L_0x01ed
        L_0x01d3:
            androidx.compose.material3.CardKt$OutlinedCard$1 r16 = new androidx.compose.material3.CardKt$OutlinedCard$1
            r0 = r16
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r30
            r7 = r32
            r9 = r8
            r8 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x01ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CardKt.OutlinedCard(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, androidx.compose.material3.CardColors, androidx.compose.material3.CardElevation, androidx.compose.foundation.BorderStroke, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02e2  */
    /* JADX WARNING: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void OutlinedCard(kotlin.jvm.functions.Function0<kotlin.Unit> r35, androidx.compose.ui.Modifier r36, boolean r37, androidx.compose.ui.graphics.Shape r38, androidx.compose.material3.CardColors r39, androidx.compose.material3.CardElevation r40, androidx.compose.foundation.BorderStroke r41, androidx.compose.foundation.interaction.MutableInteractionSource r42, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, androidx.compose.runtime.Composer r44, int r45, int r46) {
        /*
            r12 = r35
            r13 = r43
            r14 = r45
            r15 = r46
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -727137250(0xffffffffd4a8c41e, float:-5.7987584E12)
            r1 = r44
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(OutlinedCard)P(7,6,4,8,1,3!1,5)330@15524L13,331@15577L20,332@15643L23,333@15708L27,334@15787L39,336@15880L231:Card.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r45
            r2 = r15 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            goto L_0x0038
        L_0x002a:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x0038
            boolean r2 = r11.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x0036
            r2 = 4
            goto L_0x0037
        L_0x0036:
            r2 = 2
        L_0x0037:
            r1 = r1 | r2
        L_0x0038:
            r2 = r15 & 2
            if (r2 == 0) goto L_0x0041
            r1 = r1 | 48
            r3 = r36
            goto L_0x0056
        L_0x0041:
            r3 = r14 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0054
            r3 = r36
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
            r3 = r36
        L_0x0056:
            r4 = r15 & 4
            if (r4 == 0) goto L_0x005f
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r37
            goto L_0x0074
        L_0x005f:
            r5 = r14 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0072
            r5 = r37
            boolean r6 = r11.changed((boolean) r5)
            if (r6 == 0) goto L_0x006e
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0070
        L_0x006e:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0070:
            r1 = r1 | r6
            goto L_0x0074
        L_0x0072:
            r5 = r37
        L_0x0074:
            r6 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x008d
            r6 = r15 & 8
            if (r6 != 0) goto L_0x0087
            r6 = r38
            boolean r7 = r11.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0089
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x008b
        L_0x0087:
            r6 = r38
        L_0x0089:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x008b:
            r1 = r1 | r7
            goto L_0x008f
        L_0x008d:
            r6 = r38
        L_0x008f:
            r28 = 57344(0xe000, float:8.0356E-41)
            r7 = r14 & r28
            if (r7 != 0) goto L_0x00ab
            r7 = r15 & 16
            if (r7 != 0) goto L_0x00a5
            r7 = r39
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x00a7
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a9
        L_0x00a5:
            r7 = r39
        L_0x00a7:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x00a9:
            r1 = r1 | r8
            goto L_0x00ad
        L_0x00ab:
            r7 = r39
        L_0x00ad:
            r29 = 458752(0x70000, float:6.42848E-40)
            r8 = r14 & r29
            if (r8 != 0) goto L_0x00c8
            r8 = r15 & 32
            if (r8 != 0) goto L_0x00c2
            r10 = r40
            boolean r8 = r11.changed((java.lang.Object) r10)
            if (r8 == 0) goto L_0x00c4
            r8 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c6
        L_0x00c2:
            r10 = r40
        L_0x00c4:
            r8 = 65536(0x10000, float:9.18355E-41)
        L_0x00c6:
            r1 = r1 | r8
            goto L_0x00ca
        L_0x00c8:
            r10 = r40
        L_0x00ca:
            r30 = 3670016(0x380000, float:5.142788E-39)
            r8 = r14 & r30
            if (r8 != 0) goto L_0x00e5
            r8 = r15 & 64
            if (r8 != 0) goto L_0x00df
            r9 = r41
            boolean r8 = r11.changed((java.lang.Object) r9)
            if (r8 == 0) goto L_0x00e1
            r8 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e3
        L_0x00df:
            r9 = r41
        L_0x00e1:
            r8 = 524288(0x80000, float:7.34684E-40)
        L_0x00e3:
            r1 = r1 | r8
            goto L_0x00e7
        L_0x00e5:
            r9 = r41
        L_0x00e7:
            r8 = r15 & 128(0x80, float:1.794E-43)
            r31 = 29360128(0x1c00000, float:7.052966E-38)
            if (r8 == 0) goto L_0x00f4
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r16
            r0 = r42
            goto L_0x010a
        L_0x00f4:
            r16 = r14 & r31
            if (r16 != 0) goto L_0x0108
            r0 = r42
            boolean r16 = r11.changed((java.lang.Object) r0)
            if (r16 == 0) goto L_0x0103
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0105
        L_0x0103:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x0105:
            r1 = r1 | r16
            goto L_0x010a
        L_0x0108:
            r0 = r42
        L_0x010a:
            r0 = r15 & 256(0x100, float:3.59E-43)
            r32 = 234881024(0xe000000, float:1.5777218E-30)
            if (r0 == 0) goto L_0x0114
            r0 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x0112:
            r1 = r1 | r0
            goto L_0x0124
        L_0x0114:
            r0 = r14 & r32
            if (r0 != 0) goto L_0x0124
            boolean r0 = r11.changed((java.lang.Object) r13)
            if (r0 == 0) goto L_0x0121
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0112
        L_0x0121:
            r0 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x0112
        L_0x0124:
            r0 = 191739611(0xb6db6db, float:4.5782105E-32)
            r0 = r0 & r1
            r3 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r3) goto L_0x014b
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x0134
            goto L_0x014b
        L_0x0134:
            r11.skipToGroupEnd()
            r16 = r36
            r21 = r42
            r24 = r1
            r17 = r5
            r33 = r6
            r18 = r7
            r20 = r9
            r19 = r10
            r22 = r11
            goto L_0x02db
        L_0x014b:
            r11.startDefaults()
            r0 = r14 & 1
            if (r0 == 0) goto L_0x019c
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0159
            goto L_0x019c
        L_0x0159:
            r11.skipToGroupEnd()
            r0 = r15 & 8
            if (r0 == 0) goto L_0x0162
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0162:
            r0 = r15 & 16
            if (r0 == 0) goto L_0x016a
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r0
        L_0x016a:
            r0 = r15 & 32
            if (r0 == 0) goto L_0x0172
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r0
        L_0x0172:
            r0 = r15 & 64
            if (r0 == 0) goto L_0x018b
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r0 = r0 & r1
            r16 = r36
            r21 = r42
            r17 = r5
            r33 = r6
            r18 = r7
            r20 = r9
            r19 = r10
            r10 = r0
            goto L_0x027d
        L_0x018b:
            r16 = r36
            r21 = r42
            r17 = r5
            r33 = r6
            r18 = r7
            r20 = r9
            r19 = r10
            r10 = r1
            goto L_0x027d
        L_0x019c:
            if (r2 == 0) goto L_0x01a3
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01a5
        L_0x01a3:
            r0 = r36
        L_0x01a5:
            if (r4 == 0) goto L_0x01a9
            r2 = 1
            r5 = r2
        L_0x01a9:
            r2 = r15 & 8
            if (r2 == 0) goto L_0x01b9
            androidx.compose.material3.CardDefaults r2 = androidx.compose.material3.CardDefaults.INSTANCE
            r3 = 6
            androidx.compose.ui.graphics.Shape r2 = r2.getOutlinedShape(r11, r3)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r33 = r2
            goto L_0x01bb
        L_0x01b9:
            r33 = r6
        L_0x01bb:
            r2 = r15 & 16
            if (r2 == 0) goto L_0x01dc
            androidx.compose.material3.CardDefaults r16 = androidx.compose.material3.CardDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r26 = 24576(0x6000, float:3.4438E-41)
            r27 = 15
            r25 = r11
            androidx.compose.material3.CardColors r2 = r16.m1778outlinedCardColorsro_MJ88(r17, r19, r21, r23, r25, r26, r27)
            r3 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r3
            r17 = r1
            r16 = r2
            goto L_0x01e0
        L_0x01dc:
            r17 = r1
            r16 = r7
        L_0x01e0:
            r1 = r15 & 32
            if (r1 == 0) goto L_0x0208
            androidx.compose.material3.CardDefaults r1 = androidx.compose.material3.CardDefaults.INSTANCE
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            r18 = 0
            r19 = 1572864(0x180000, float:2.204052E-39)
            r20 = 63
            r34 = r5
            r5 = r6
            r6 = r7
            r7 = r18
            r18 = r8
            r8 = r11
            r9 = r19
            r10 = r20
            androidx.compose.material3.CardElevation r1 = r1.m1779outlinedCardElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r17 = r17 & r2
            goto L_0x020e
        L_0x0208:
            r34 = r5
            r18 = r8
            r1 = r40
        L_0x020e:
            r2 = r15 & 64
            if (r2 == 0) goto L_0x0227
            androidx.compose.material3.CardDefaults r2 = androidx.compose.material3.CardDefaults.INSTANCE
            int r3 = r17 >> 6
            r3 = r3 & 14
            r3 = r3 | 48
            r4 = 0
            r5 = r34
            androidx.compose.foundation.BorderStroke r2 = r2.outlinedCardBorder(r5, r11, r3, r4)
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r17 = r17 & r3
            goto L_0x022b
        L_0x0227:
            r5 = r34
            r2 = r41
        L_0x022b:
            if (r18 == 0) goto L_0x026d
            r3 = 0
            r4 = 0
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r6)
            java.lang.String r6 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r6)
            r6 = 0
            r7 = r11
            r8 = 0
            java.lang.Object r9 = r7.rememberedValue()
            r10 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r36 = r0
            java.lang.Object r0 = r18.getEmpty()
            if (r9 != r0) goto L_0x0256
            r0 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r7.updateRememberedValue(r0)
            goto L_0x0257
        L_0x0256:
            r0 = r9
        L_0x0257:
            r11.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r21 = r0
            r19 = r1
            r20 = r2
            r18 = r16
            r10 = r17
            r16 = r36
            r17 = r5
            goto L_0x027d
        L_0x026d:
            r36 = r0
            r21 = r42
            r19 = r1
            r20 = r2
            r18 = r16
            r10 = r17
            r16 = r36
            r17 = r5
        L_0x027d:
            r11.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x028f
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.OutlinedCard (Card.kt:326)"
            r2 = -727137250(0xffffffffd4a8c41e, float:-5.7987584E12)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r10, r0, r1)
        L_0x028f:
            r0 = r10 & 14
            r1 = r10 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r10 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r10 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = r10 & r28
            r0 = r0 | r1
            r1 = r10 & r29
            r0 = r0 | r1
            r1 = r10 & r30
            r0 = r0 | r1
            r1 = r10 & r31
            r0 = r0 | r1
            r1 = r10 & r32
            r22 = r0 | r1
            r23 = 0
            r0 = r35
            r1 = r16
            r2 = r17
            r3 = r33
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r43
            r9 = r11
            r24 = r10
            r10 = r22
            r22 = r11
            r11 = r23
            Card(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02db
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02db:
            androidx.compose.runtime.ScopeUpdateScope r11 = r22.endRestartGroup()
            if (r11 != 0) goto L_0x02e2
            goto L_0x0307
        L_0x02e2:
            androidx.compose.material3.CardKt$OutlinedCard$3 r23 = new androidx.compose.material3.CardKt$OutlinedCard$3
            r0 = r23
            r1 = r35
            r2 = r16
            r3 = r17
            r4 = r33
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r43
            r10 = r45
            r12 = r11
            r11 = r46
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r23
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x0307:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CardKt.OutlinedCard(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, androidx.compose.material3.CardColors, androidx.compose.material3.CardElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
