package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a©\u0001\u0010\u0014\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006("}, d2 = {"Group", "", "name", "", "rotation", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Path", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "Path-9cdaXJ4", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLandroidx/compose/runtime/Composer;III)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorCompose.kt */
public final class VectorComposeKt {
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Group(java.lang.String r27, float r28, float r29, float r30, float r31, float r32, float r33, float r34, java.util.List<? extends androidx.compose.ui.graphics.vector.PathNode> r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r13 = r36
            r14 = r38
            r12 = r39
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -213417674(0xfffffffff3478136, float:-1.5806393E31)
            r1 = r37
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Group)P(2,5,3,4,6,7,8,9)58@2500L585:VectorCompose.kt#huu6hf"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r38
            r2 = r12 & 1
            if (r2 == 0) goto L_0x0024
            r1 = r1 | 6
            r3 = r27
            goto L_0x0037
        L_0x0024:
            r3 = r14 & 14
            if (r3 != 0) goto L_0x0035
            r3 = r27
            boolean r4 = r15.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0032
            r4 = 4
            goto L_0x0033
        L_0x0032:
            r4 = 2
        L_0x0033:
            r1 = r1 | r4
            goto L_0x0037
        L_0x0035:
            r3 = r27
        L_0x0037:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x0040
            r1 = r1 | 48
            r5 = r28
            goto L_0x0055
        L_0x0040:
            r5 = r14 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0053
            r5 = r28
            boolean r6 = r15.changed((float) r5)
            if (r6 == 0) goto L_0x004f
            r6 = 32
            goto L_0x0051
        L_0x004f:
            r6 = 16
        L_0x0051:
            r1 = r1 | r6
            goto L_0x0055
        L_0x0053:
            r5 = r28
        L_0x0055:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x005e
            r1 = r1 | 384(0x180, float:5.38E-43)
            r8 = r29
            goto L_0x0073
        L_0x005e:
            r8 = r14 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0071
            r8 = r29
            boolean r9 = r15.changed((float) r8)
            if (r9 == 0) goto L_0x006d
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x006f
        L_0x006d:
            r9 = 128(0x80, float:1.794E-43)
        L_0x006f:
            r1 = r1 | r9
            goto L_0x0073
        L_0x0071:
            r8 = r29
        L_0x0073:
            r9 = r12 & 8
            if (r9 == 0) goto L_0x007c
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r10 = r30
            goto L_0x0091
        L_0x007c:
            r10 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x008f
            r10 = r30
            boolean r11 = r15.changed((float) r10)
            if (r11 == 0) goto L_0x008b
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x008d
        L_0x008b:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x008d:
            r1 = r1 | r11
            goto L_0x0091
        L_0x008f:
            r10 = r30
        L_0x0091:
            r11 = r12 & 16
            if (r11 == 0) goto L_0x009a
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r0 = r31
            goto L_0x00b3
        L_0x009a:
            r16 = 57344(0xe000, float:8.0356E-41)
            r16 = r14 & r16
            if (r16 != 0) goto L_0x00b1
            r0 = r31
            boolean r17 = r15.changed((float) r0)
            if (r17 == 0) goto L_0x00ac
            r17 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ae
        L_0x00ac:
            r17 = 8192(0x2000, float:1.14794E-41)
        L_0x00ae:
            r1 = r1 | r17
            goto L_0x00b3
        L_0x00b1:
            r0 = r31
        L_0x00b3:
            r17 = r12 & 32
            if (r17 == 0) goto L_0x00be
            r18 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r18
            r7 = r32
            goto L_0x00d6
        L_0x00be:
            r18 = 458752(0x70000, float:6.42848E-40)
            r18 = r14 & r18
            if (r18 != 0) goto L_0x00d4
            r7 = r32
            boolean r18 = r15.changed((float) r7)
            if (r18 == 0) goto L_0x00cf
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d1
        L_0x00cf:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00d1:
            r1 = r1 | r18
            goto L_0x00d6
        L_0x00d4:
            r7 = r32
        L_0x00d6:
            r18 = r12 & 64
            if (r18 == 0) goto L_0x00e1
            r19 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r19
            r0 = r33
            goto L_0x00f9
        L_0x00e1:
            r19 = 3670016(0x380000, float:5.142788E-39)
            r19 = r14 & r19
            if (r19 != 0) goto L_0x00f7
            r0 = r33
            boolean r19 = r15.changed((float) r0)
            if (r19 == 0) goto L_0x00f2
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00f4
        L_0x00f2:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00f4:
            r1 = r1 | r19
            goto L_0x00f9
        L_0x00f7:
            r0 = r33
        L_0x00f9:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0104
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r19
            r3 = r34
            goto L_0x011c
        L_0x0104:
            r19 = 29360128(0x1c00000, float:7.052966E-38)
            r19 = r14 & r19
            if (r19 != 0) goto L_0x011a
            r3 = r34
            boolean r19 = r15.changed((float) r3)
            if (r19 == 0) goto L_0x0115
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0117
        L_0x0115:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x0117:
            r1 = r1 | r19
            goto L_0x011c
        L_0x011a:
            r3 = r34
        L_0x011c:
            r3 = r12 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0124
            r19 = 33554432(0x2000000, float:9.403955E-38)
            r1 = r1 | r19
        L_0x0124:
            r5 = r12 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x012c
            r5 = 805306368(0x30000000, float:4.656613E-10)
        L_0x012a:
            r1 = r1 | r5
            goto L_0x013d
        L_0x012c:
            r5 = 1879048192(0x70000000, float:1.58456325E29)
            r5 = r5 & r14
            if (r5 != 0) goto L_0x013d
            boolean r5 = r15.changedInstance(r13)
            if (r5 == 0) goto L_0x013a
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012a
        L_0x013a:
            r5 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x012a
        L_0x013d:
            r5 = 256(0x100, float:3.59E-43)
            if (r3 != r5) goto L_0x016a
            r5 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r5 = r5 & r1
            r7 = 306783378(0x12492492, float:6.3469493E-28)
            if (r5 != r7) goto L_0x016a
            boolean r5 = r15.getSkipping()
            if (r5 != 0) goto L_0x0151
            goto L_0x016a
        L_0x0151:
            r15.skipToGroupEnd()
            r18 = r27
            r16 = r28
            r20 = r31
            r21 = r32
            r22 = r33
            r23 = r34
            r24 = r35
            r25 = r1
            r17 = r8
            r19 = r10
            goto L_0x02d0
        L_0x016a:
            r15.startDefaults()
            r5 = r14 & 1
            r7 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            if (r5 == 0) goto L_0x01a6
            boolean r5 = r15.getDefaultsInvalid()
            if (r5 == 0) goto L_0x017b
            goto L_0x01a6
        L_0x017b:
            r15.skipToGroupEnd()
            if (r3 == 0) goto L_0x0195
            r0 = r1 & r7
            r2 = r27
            r4 = r28
            r9 = r32
            r3 = r35
            r1 = r0
            r5 = r8
            r6 = r10
            r8 = r31
            r10 = r33
            r0 = r34
            goto L_0x01e1
        L_0x0195:
            r2 = r27
            r4 = r28
            r9 = r32
            r0 = r34
            r3 = r35
            r5 = r8
            r6 = r10
            r8 = r31
            r10 = r33
            goto L_0x01e1
        L_0x01a6:
            if (r2 == 0) goto L_0x01ab
            java.lang.String r2 = ""
            goto L_0x01ad
        L_0x01ab:
            r2 = r27
        L_0x01ad:
            if (r4 == 0) goto L_0x01b1
            r4 = 0
            goto L_0x01b3
        L_0x01b1:
            r4 = r28
        L_0x01b3:
            if (r6 == 0) goto L_0x01b7
            r5 = 0
            goto L_0x01b8
        L_0x01b7:
            r5 = r8
        L_0x01b8:
            if (r9 == 0) goto L_0x01bc
            r6 = 0
            goto L_0x01bd
        L_0x01bc:
            r6 = r10
        L_0x01bd:
            if (r11 == 0) goto L_0x01c2
            r8 = 1065353216(0x3f800000, float:1.0)
            goto L_0x01c4
        L_0x01c2:
            r8 = r31
        L_0x01c4:
            if (r17 == 0) goto L_0x01c9
            r9 = 1065353216(0x3f800000, float:1.0)
            goto L_0x01cb
        L_0x01c9:
            r9 = r32
        L_0x01cb:
            if (r18 == 0) goto L_0x01cf
            r10 = 0
            goto L_0x01d1
        L_0x01cf:
            r10 = r33
        L_0x01d1:
            if (r0 == 0) goto L_0x01d5
            r0 = 0
            goto L_0x01d7
        L_0x01d5:
            r0 = r34
        L_0x01d7:
            if (r3 == 0) goto L_0x01df
            java.util.List r3 = androidx.compose.ui.graphics.vector.VectorKt.getEmptyPath()
            r1 = r1 & r7
            goto L_0x01e1
        L_0x01df:
            r3 = r35
        L_0x01e1:
            r15.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x01f3
            r7 = -1
            java.lang.String r11 = "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)"
            r12 = -213417674(0xfffffffff3478136, float:-1.5806393E31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r1, r7, r11)
        L_0x01f3:
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1 r7 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1.INSTANCE
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r11 = 6
            r12 = 0
            r27 = r12
            r12 = -548224868(0xffffffffdf52c09c, float:-1.518631E19)
            r15.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r12)
            androidx.compose.runtime.Applier r12 = r15.getApplier()
            boolean r12 = r12 instanceof androidx.compose.ui.graphics.vector.VectorApplier
            if (r12 != 0) goto L_0x0211
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0211:
            r15.startNode()
            boolean r12 = r15.getInserting()
            if (r12 == 0) goto L_0x021e
            r15.createNode(r7)
            goto L_0x0221
        L_0x021e:
            r15.useNode()
        L_0x0221:
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m2787constructorimpl(r15)
            r16 = 0
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1 r17 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1.INSTANCE
            r28 = r7
            r7 = r17
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r12, r2, r7)
            java.lang.Float r7 = java.lang.Float.valueOf(r4)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2 r17 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2.INSTANCE
            r18 = r2
            r2 = r17
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r12, r7, r2)
            java.lang.Float r2 = java.lang.Float.valueOf(r5)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3 r7 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3.INSTANCE
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r12, r2, r7)
            java.lang.Float r2 = java.lang.Float.valueOf(r6)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4 r7 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4.INSTANCE
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r12, r2, r7)
            java.lang.Float r2 = java.lang.Float.valueOf(r8)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5 r7 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5.INSTANCE
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r12, r2, r7)
            java.lang.Float r2 = java.lang.Float.valueOf(r9)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6 r7 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6.INSTANCE
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r12, r2, r7)
            java.lang.Float r2 = java.lang.Float.valueOf(r10)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7 r7 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7.INSTANCE
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r12, r2, r7)
            java.lang.Float r2 = java.lang.Float.valueOf(r0)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8 r7 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8.INSTANCE
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r12, r2, r7)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9 r2 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9.INSTANCE
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r12, r3, r2)
            int r2 = r11 >> 6
            r2 = r2 & 14
            r7 = r15
            r12 = 0
            r29 = r0
            r0 = -1894406143(0xffffffff8f15a801, float:-7.3786236E-30)
            r30 = r2
            java.lang.String r2 = "C72@3070L9:VectorCompose.kt#huu6hf"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r0, r2)
            int r0 = r1 >> 27
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r13.invoke(r7, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r15.endNode()
            r15.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02be
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02be:
            r23 = r29
            r25 = r1
            r24 = r3
            r16 = r4
            r17 = r5
            r19 = r6
            r20 = r8
            r21 = r9
            r22 = r10
        L_0x02d0:
            androidx.compose.runtime.ScopeUpdateScope r12 = r15.endRestartGroup()
            if (r12 != 0) goto L_0x02d7
            goto L_0x02fe
        L_0x02d7:
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$4 r26 = new androidx.compose.ui.graphics.vector.VectorComposeKt$Group$4
            r0 = r26
            r1 = r18
            r2 = r16
            r3 = r17
            r4 = r19
            r5 = r20
            r6 = r21
            r7 = r22
            r8 = r23
            r9 = r24
            r10 = r36
            r11 = r38
            r13 = r12
            r12 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r26
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x02fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorComposeKt.Group(java.lang.String, float, float, float, float, float, float, float, java.util.List, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: Path-9cdaXJ4  reason: not valid java name */
    public static final void m3883Path9cdaXJ4(List<? extends PathNode> pathData, int pathFillType, String name, Brush fill, float fillAlpha, Brush stroke, float strokeAlpha, float strokeLineWidth, int strokeLineCap, int strokeLineJoin, float strokeLineMiter, float trimPathStart, float trimPathEnd, float trimPathOffset, Composer $composer, int $changed, int $changed1, int i) {
        int pathFillType2;
        String name2;
        Brush fill2;
        float fillAlpha2;
        Brush stroke2;
        float strokeAlpha2;
        float strokeLineWidth2;
        int strokeLineCap2;
        int strokeLineJoin2;
        float strokeLineMiter2;
        float trimPathStart2;
        float trimPathEnd2;
        float trimPathOffset2;
        List<? extends PathNode> list = pathData;
        int i2 = i;
        Intrinsics.checkNotNullParameter(list, "pathData");
        Composer $composer2 = $composer.startRestartGroup(-1478270750);
        ComposerKt.sourceInformation($composer2, "C(Path)P(3,4:c#ui.graphics.PathFillType,2!4,10,7:c#ui.graphics.StrokeCap,8:c#ui.graphics.StrokeJoin!1,13)115@5068L876:VectorCompose.kt#huu6hf");
        if ((i2 & 2) != 0) {
            pathFillType2 = VectorKt.getDefaultFillType();
        } else {
            pathFillType2 = pathFillType;
        }
        if ((i2 & 4) != 0) {
            name2 = "";
        } else {
            name2 = name;
        }
        if ((i2 & 8) != 0) {
            fill2 = null;
        } else {
            fill2 = fill;
        }
        if ((i2 & 16) != 0) {
            fillAlpha2 = 1.0f;
        } else {
            fillAlpha2 = fillAlpha;
        }
        if ((i2 & 32) != 0) {
            stroke2 = null;
        } else {
            stroke2 = stroke;
        }
        if ((i2 & 64) != 0) {
            strokeAlpha2 = 1.0f;
        } else {
            strokeAlpha2 = strokeAlpha;
        }
        if ((i2 & 128) != 0) {
            strokeLineWidth2 = 0.0f;
        } else {
            strokeLineWidth2 = strokeLineWidth;
        }
        if ((i2 & 256) != 0) {
            strokeLineCap2 = VectorKt.getDefaultStrokeLineCap();
        } else {
            strokeLineCap2 = strokeLineCap;
        }
        if ((i2 & 512) != 0) {
            strokeLineJoin2 = VectorKt.getDefaultStrokeLineJoin();
        } else {
            strokeLineJoin2 = strokeLineJoin;
        }
        if ((i2 & 1024) != 0) {
            strokeLineMiter2 = 4.0f;
        } else {
            strokeLineMiter2 = strokeLineMiter;
        }
        if ((i2 & 2048) != 0) {
            trimPathStart2 = 0.0f;
        } else {
            trimPathStart2 = trimPathStart;
        }
        if ((i2 & 4096) != 0) {
            trimPathEnd2 = 1.0f;
        } else {
            trimPathEnd2 = trimPathEnd;
        }
        if ((i2 & 8192) != 0) {
            trimPathOffset2 = 0.0f;
        } else {
            trimPathOffset2 = trimPathOffset;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1478270750, $changed, $changed1, "androidx.compose.ui.graphics.vector.Path (VectorCompose.kt:99)");
        } else {
            int i3 = $changed;
            int i4 = $changed1;
        }
        Function0 factory$iv = VectorComposeKt$Path$1.INSTANCE;
        $composer2.startReplaceableGroup(1886828752);
        ComposerKt.sourceInformation($composer2, "CC(ComposeNode):Composables.kt#9igjgp");
        if (!($composer2.getApplier() instanceof VectorApplier)) {
            ComposablesKt.invalidApplier();
        }
        $composer2.startNode();
        if ($composer2.getInserting()) {
            $composer2.createNode(new VectorComposeKt$Path9cdaXJ4$$inlined$ComposeNode$1(factory$iv));
        } else {
            $composer2.useNode();
        }
        Composer $this$Path_9cdaXJ4_u24lambda_u242 = Updater.m2787constructorimpl($composer2);
        Updater.m2794setimpl($this$Path_9cdaXJ4_u24lambda_u242, name2, VectorComposeKt$Path$2$1.INSTANCE);
        Updater.m2794setimpl($this$Path_9cdaXJ4_u24lambda_u242, list, VectorComposeKt$Path$2$2.INSTANCE);
        Updater.m2794setimpl($this$Path_9cdaXJ4_u24lambda_u242, PathFillType.m3450boximpl(pathFillType2), VectorComposeKt$Path$2$3.INSTANCE);
        Updater.m2794setimpl($this$Path_9cdaXJ4_u24lambda_u242, fill2, VectorComposeKt$Path$2$4.INSTANCE);
        Updater.m2794setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(fillAlpha2), VectorComposeKt$Path$2$5.INSTANCE);
        Updater.m2794setimpl($this$Path_9cdaXJ4_u24lambda_u242, stroke2, VectorComposeKt$Path$2$6.INSTANCE);
        Updater.m2794setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(strokeAlpha2), VectorComposeKt$Path$2$7.INSTANCE);
        Updater.m2794setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(strokeLineWidth2), VectorComposeKt$Path$2$8.INSTANCE);
        Updater.m2794setimpl($this$Path_9cdaXJ4_u24lambda_u242, StrokeJoin.m3550boximpl(strokeLineJoin2), VectorComposeKt$Path$2$9.INSTANCE);
        Updater.m2794setimpl($this$Path_9cdaXJ4_u24lambda_u242, StrokeCap.m3540boximpl(strokeLineCap2), VectorComposeKt$Path$2$10.INSTANCE);
        Updater.m2794setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(strokeLineMiter2), VectorComposeKt$Path$2$11.INSTANCE);
        Updater.m2794setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(trimPathStart2), VectorComposeKt$Path$2$12.INSTANCE);
        Updater.m2794setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(trimPathEnd2), VectorComposeKt$Path$2$13.INSTANCE);
        Updater.m2794setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(trimPathOffset2), VectorComposeKt$Path$2$14.INSTANCE);
        $composer2.endNode();
        $composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Brush brush = stroke2;
            Brush brush2 = fill2;
            String str = name2;
            Composer composer = $composer2;
            return;
        }
        Brush brush3 = stroke2;
        Brush brush4 = fill2;
        String str2 = name2;
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new VectorComposeKt$Path$3(pathData, pathFillType2, name2, fill2, fillAlpha2, stroke2, strokeAlpha2, strokeLineWidth2, strokeLineCap2, strokeLineJoin2, strokeLineMiter2, trimPathStart2, trimPathEnd2, trimPathOffset2, $changed, $changed1, i));
    }
}
