package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a©\u0001\u0010\t\u001a\u00020\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\u0002\b\r2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\u0002\b\r2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\u0002\b\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a8\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\rH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"DialogPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "IconPadding", "MaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "MinWidth", "TextPadding", "TitlePadding", "AlertDialogContent", "", "buttons", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "buttonContentColor", "iconContentColor", "titleContentColor", "textContentColor", "AlertDialogContent-4hvqGtA", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JFJJJJLandroidx/compose/runtime/Composer;III)V", "AlertDialogFlowRow", "mainAxisSpacing", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: AlertDialog.kt */
public final class AlertDialogKt {
    /* access modifiers changed from: private */
    public static final PaddingValues DialogPadding = PaddingKt.m753PaddingValues0680j_4(Dp.m5986constructorimpl((float) 24));
    /* access modifiers changed from: private */
    public static final PaddingValues IconPadding = PaddingKt.m757PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m5986constructorimpl((float) 16), 7, (Object) null);
    /* access modifiers changed from: private */
    public static final float MaxWidth = Dp.m5986constructorimpl((float) 560);
    /* access modifiers changed from: private */
    public static final float MinWidth = Dp.m5986constructorimpl((float) 280);
    /* access modifiers changed from: private */
    public static final PaddingValues TextPadding = PaddingKt.m757PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m5986constructorimpl((float) 24), 7, (Object) null);
    /* access modifiers changed from: private */
    public static final PaddingValues TitlePadding = PaddingKt.m757PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m5986constructorimpl((float) 16), 7, (Object) null);

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x013d  */
    /* renamed from: AlertDialogContent-4hvqGtA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1737AlertDialogContent4hvqGtA(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.ui.Modifier r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.ui.graphics.Shape r32, long r33, float r35, long r36, long r38, long r40, long r42, androidx.compose.runtime.Composer r44, int r45, int r46, int r47) {
        /*
            r14 = r27
            r15 = r32
            r13 = r45
            r11 = r47
            java.lang.String r0 = "buttons"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "shape"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = 1522575799(0x5ac0a9b7, float:2.71148995E16)
            r1 = r44
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AlertDialogContent)P(1,5,3,9,7,6,2:c#ui.graphics.Color,11:c#ui.unit.Dp,0:c#ui.graphics.Color,4:c#ui.graphics.Color,10:c#ui.graphics.Color,8:c#ui.graphics.Color)52@1872L2730:AlertDialog.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r45
            r2 = r46
            r3 = r11 & 1
            if (r3 == 0) goto L_0x002c
            r1 = r1 | 6
            goto L_0x003a
        L_0x002c:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x003a
            boolean r3 = r12.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x0038
            r3 = 4
            goto L_0x0039
        L_0x0038:
            r3 = 2
        L_0x0039:
            r1 = r1 | r3
        L_0x003a:
            r3 = r11 & 2
            r6 = 32
            r7 = 16
            if (r3 == 0) goto L_0x0047
            r1 = r1 | 48
            r8 = r28
            goto L_0x005a
        L_0x0047:
            r8 = r13 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0058
            r8 = r28
            boolean r9 = r12.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0055
            r9 = r6
            goto L_0x0056
        L_0x0055:
            r9 = r7
        L_0x0056:
            r1 = r1 | r9
            goto L_0x005a
        L_0x0058:
            r8 = r28
        L_0x005a:
            r9 = r11 & 4
            if (r9 == 0) goto L_0x0063
            r1 = r1 | 384(0x180, float:5.38E-43)
            r9 = r29
            goto L_0x0078
        L_0x0063:
            r9 = r13 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0076
            r9 = r29
            boolean r10 = r12.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0072
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0074
        L_0x0072:
            r10 = 128(0x80, float:1.794E-43)
        L_0x0074:
            r1 = r1 | r10
            goto L_0x0078
        L_0x0076:
            r9 = r29
        L_0x0078:
            r10 = r11 & 8
            if (r10 == 0) goto L_0x0081
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r10 = r30
            goto L_0x0097
        L_0x0081:
            r10 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x0095
            r10 = r30
            boolean r16 = r12.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x0090
            r16 = 2048(0x800, float:2.87E-42)
            goto L_0x0092
        L_0x0090:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x0092:
            r1 = r1 | r16
            goto L_0x0097
        L_0x0095:
            r10 = r30
        L_0x0097:
            r16 = r11 & 16
            r17 = 57344(0xe000, float:8.0356E-41)
            if (r16 == 0) goto L_0x00a3
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r0 = r31
            goto L_0x00b9
        L_0x00a3:
            r16 = r13 & r17
            if (r16 != 0) goto L_0x00b7
            r0 = r31
            boolean r18 = r12.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00b2
            r18 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b4
        L_0x00b2:
            r18 = 8192(0x2000, float:1.14794E-41)
        L_0x00b4:
            r1 = r1 | r18
            goto L_0x00b9
        L_0x00b7:
            r0 = r31
        L_0x00b9:
            r18 = r11 & 32
            if (r18 == 0) goto L_0x00c2
            r18 = 196608(0x30000, float:2.75506E-40)
        L_0x00bf:
            r1 = r1 | r18
            goto L_0x00d4
        L_0x00c2:
            r18 = 458752(0x70000, float:6.42848E-40)
            r18 = r13 & r18
            if (r18 != 0) goto L_0x00d4
            boolean r18 = r12.changed((java.lang.Object) r15)
            if (r18 == 0) goto L_0x00d1
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bf
        L_0x00d1:
            r18 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00bf
        L_0x00d4:
            r18 = r11 & 64
            if (r18 == 0) goto L_0x00df
            r18 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r18
            r14 = r33
            goto L_0x00f7
        L_0x00df:
            r18 = 3670016(0x380000, float:5.142788E-39)
            r18 = r13 & r18
            if (r18 != 0) goto L_0x00f5
            r14 = r33
            boolean r18 = r12.changed((long) r14)
            if (r18 == 0) goto L_0x00f0
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00f2
        L_0x00f0:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00f2:
            r1 = r1 | r18
            goto L_0x00f7
        L_0x00f5:
            r14 = r33
        L_0x00f7:
            r4 = r11 & 128(0x80, float:1.794E-43)
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            if (r4 == 0) goto L_0x0102
            r1 = r1 | r18
            r4 = r35
            goto L_0x0119
        L_0x0102:
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r13
            if (r4 != 0) goto L_0x0117
            r4 = r35
            boolean r19 = r12.changed((float) r4)
            if (r19 == 0) goto L_0x0112
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0114
        L_0x0112:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x0114:
            r1 = r1 | r19
            goto L_0x0119
        L_0x0117:
            r4 = r35
        L_0x0119:
            r5 = r11 & 256(0x100, float:3.59E-43)
            if (r5 == 0) goto L_0x0123
            r5 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r5
            r14 = r36
            goto L_0x0139
        L_0x0123:
            r5 = 234881024(0xe000000, float:1.5777218E-30)
            r5 = r5 & r13
            if (r5 != 0) goto L_0x0137
            r14 = r36
            boolean r5 = r12.changed((long) r14)
            if (r5 == 0) goto L_0x0133
            r5 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0135
        L_0x0133:
            r5 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0135:
            r1 = r1 | r5
            goto L_0x0139
        L_0x0137:
            r14 = r36
        L_0x0139:
            r5 = r11 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x0143
            r5 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r5
            r14 = r38
            goto L_0x0159
        L_0x0143:
            r5 = 1879048192(0x70000000, float:1.58456325E29)
            r5 = r5 & r13
            if (r5 != 0) goto L_0x0157
            r14 = r38
            boolean r5 = r12.changed((long) r14)
            if (r5 == 0) goto L_0x0153
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0155
        L_0x0153:
            r5 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0155:
            r1 = r1 | r5
            goto L_0x0159
        L_0x0157:
            r14 = r38
        L_0x0159:
            r5 = r1
            r1 = r11 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0163
            r2 = r2 | 6
            r14 = r40
            goto L_0x0179
        L_0x0163:
            r1 = r46 & 14
            if (r1 != 0) goto L_0x0177
            r14 = r40
            boolean r1 = r12.changed((long) r14)
            if (r1 == 0) goto L_0x0172
            r19 = 4
            goto L_0x0174
        L_0x0172:
            r19 = 2
        L_0x0174:
            r2 = r2 | r19
            goto L_0x0179
        L_0x0177:
            r14 = r40
        L_0x0179:
            r1 = r11 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0182
            r2 = r2 | 48
            r14 = r42
            goto L_0x0194
        L_0x0182:
            r1 = r46 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0192
            r14 = r42
            boolean r1 = r12.changed((long) r14)
            if (r1 == 0) goto L_0x018f
            goto L_0x0190
        L_0x018f:
            r6 = r7
        L_0x0190:
            r2 = r2 | r6
            goto L_0x0194
        L_0x0192:
            r14 = r42
        L_0x0194:
            r7 = r2
            r1 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r1 & r5
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x01b7
            r1 = r7 & 91
            r2 = 18
            if (r1 != r2) goto L_0x01b7
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x01ab
            goto L_0x01b7
        L_0x01ab:
            r12.skipToGroupEnd()
            r23 = r5
            r24 = r7
            r21 = r8
            r15 = r12
            goto L_0x0236
        L_0x01b7:
            if (r3 == 0) goto L_0x01c0
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r19 = r1
            goto L_0x01c2
        L_0x01c0:
            r19 = r8
        L_0x01c2:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01d0
            java.lang.String r1 = "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:38)"
            r2 = 1522575799(0x5ac0a9b7, float:2.71148995E16)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r5, r7, r1)
        L_0x01d0:
            r20 = 0
            r16 = 0
            r22 = 0
            androidx.compose.material3.AlertDialogKt$AlertDialogContent$1 r8 = new androidx.compose.material3.AlertDialogKt$AlertDialogContent$1
            r0 = r8
            r1 = r29
            r2 = r30
            r3 = r31
            r23 = r5
            r4 = r38
            r6 = r23
            r24 = r7
            r14 = r8
            r7 = r40
            r9 = r42
            r15 = r12
            r11 = r36
            r13 = r27
            r0.<init>(r1, r2, r3, r4, r6, r7, r9, r11, r13)
            r0 = -2126308228(0xffffffff81431c7c, float:-3.583628E-38)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r1, r14)
            r9 = r0
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            int r0 = r23 >> 3
            r0 = r0 & 14
            r0 = r0 | r18
            int r1 = r23 >> 12
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r23 >> 12
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r23 >> 9
            r1 = r1 & r17
            r11 = r0 | r1
            r12 = 104(0x68, float:1.46E-43)
            r0 = r19
            r1 = r32
            r2 = r33
            r4 = r20
            r6 = r35
            r7 = r16
            r8 = r22
            r10 = r15
            androidx.compose.material3.SurfaceKt.m2097SurfaceT9BRK9s(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0234
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0234:
            r21 = r19
        L_0x0236:
            androidx.compose.runtime.ScopeUpdateScope r14 = r15.endRestartGroup()
            if (r14 != 0) goto L_0x023f
            r25 = r15
            goto L_0x0271
        L_0x023f:
            androidx.compose.material3.AlertDialogKt$AlertDialogContent$2 r22 = new androidx.compose.material3.AlertDialogKt$AlertDialogContent$2
            r0 = r22
            r1 = r27
            r2 = r21
            r3 = r29
            r4 = r30
            r5 = r31
            r6 = r32
            r7 = r33
            r9 = r35
            r10 = r36
            r12 = r38
            r26 = r14
            r25 = r15
            r14 = r40
            r16 = r42
            r18 = r45
            r19 = r46
            r20 = r47
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r10, r12, r14, r16, r18, r19, r20)
            r0 = r22
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r26
            r1.updateScope(r0)
        L_0x0271:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AlertDialogKt.m1737AlertDialogContent4hvqGtA(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, long, float, long, long, long, long, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* renamed from: AlertDialogFlowRow-ixp7dh8  reason: not valid java name */
    public static final void m1738AlertDialogFlowRowixp7dh8(float mainAxisSpacing, float crossAxisSpacing, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        float f = mainAxisSpacing;
        float f2 = crossAxisSpacing;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i = $changed;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(586821353);
        ComposerKt.sourceInformation($composer2, "C(AlertDialogFlowRow)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp)132@4860L3239:AlertDialog.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed(f) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changed(f2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changed((Object) function2) ? 256 : 128;
        }
        if (($dirty & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(586821353, $dirty, -1, "androidx.compose.material3.AlertDialogFlowRow (AlertDialog.kt:127)");
            }
            MeasurePolicy measurePolicy$iv = new AlertDialogKt$AlertDialogFlowRow$1(f, f2);
            int $changed$iv = ($dirty >> 6) & 14;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2907L7,75@2962L7,76@3021L7,77@3033L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            Function0 factory$iv$iv = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(Modifier.Companion);
            int $changed$iv$iv = (($changed$iv << 9) & 7168) | 6;
            int i2 = $dirty;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv = Updater.m2787constructorimpl($composer2);
            int i3 = $changed$iv;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            function2.invoke($composer2, Integer.valueOf(($changed$iv$iv >> 9) & 14));
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            int i4 = $dirty;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AlertDialogKt$AlertDialogFlowRow$2(f, f2, function2, i));
        }
    }
}
