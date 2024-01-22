package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a~\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001a\u001a&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0002\u001aE\u0010!\u001a\u001f\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\"¢\u0006\u0002\b\u00162\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010%\u001aE\u0010&\u001a\u001f\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\"¢\u0006\u0002\b\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010'\u001aá\u0001\u0010(\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0*2%\b\n\u0010+\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\u001420\b\n\u00100\u001a*\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010\"¢\u0006\u0002\b\u00162%\b\n\u00103\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\u001423\b\u0004\u00104\u001a-\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u00107\u001aá\u0001\u0010(\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0\u001c2%\b\n\u0010+\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\u001420\b\n\u00100\u001a*\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010\"¢\u0006\u0002\b\u00162%\b\n\u00103\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\u001423\b\u0004\u00104\u001a-\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u00108\u001aµ\u0002\u00109\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0*2:\b\n\u0010+\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\"2E\b\n\u00100\u001a?\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010;¢\u0006\u0002\b\u00162:\b\u0006\u00103\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\"2H\b\u0004\u00104\u001aB\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010<\u001aµ\u0002\u00109\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0\u001c2:\b\n\u0010+\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\"2E\b\n\u00100\u001a?\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010;¢\u0006\u0002\b\u00162:\b\u0006\u00103\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\"2H\b\u0004\u00104\u001aB\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010=\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006>"}, d2 = {"LazyHorizontalGrid", "", "rows", "Landroidx/compose/foundation/lazy/grid/GridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalGrid", "columns", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "calculateCellsCrossAxisSizeImpl", "", "", "gridSize", "slotCount", "spacing", "rememberColumnWidthSums", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "span", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "itemContent", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridDsl.kt */
public final class LazyGridDslKt {
    /* JADX WARNING: Removed duplicated region for block: B:112:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x02ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyVerticalGrid(androidx.compose.foundation.lazy.grid.GridCells r29, androidx.compose.ui.Modifier r30, androidx.compose.foundation.lazy.grid.LazyGridState r31, androidx.compose.foundation.layout.PaddingValues r32, boolean r33, androidx.compose.foundation.layout.Arrangement.Vertical r34, androidx.compose.foundation.layout.Arrangement.Horizontal r35, androidx.compose.foundation.gestures.FlingBehavior r36, boolean r37, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r13 = r29
            r12 = r38
            r11 = r40
            r10 = r41
            java.lang.String r0 = "columns"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 1485410512(0x588990d0, float:1.21004046E15)
            r1 = r39
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LazyVerticalGrid)P(!1,5,7,2,6,9,4,3,8)65@3041L23,71@3401L15,75@3523L71,76@3599L431:LazyGridDsl.kt#7791vq"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r40
            r2 = r10 & 1
            if (r2 == 0) goto L_0x0029
            r1 = r1 | 6
            goto L_0x0037
        L_0x0029:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0037
            boolean r2 = r9.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x0035
            r2 = 4
            goto L_0x0036
        L_0x0035:
            r2 = 2
        L_0x0036:
            r1 = r1 | r2
        L_0x0037:
            r2 = r10 & 2
            if (r2 == 0) goto L_0x0040
            r1 = r1 | 48
            r3 = r30
            goto L_0x0055
        L_0x0040:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0053
            r3 = r30
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x004f
            r4 = 32
            goto L_0x0051
        L_0x004f:
            r4 = 16
        L_0x0051:
            r1 = r1 | r4
            goto L_0x0055
        L_0x0053:
            r3 = r30
        L_0x0055:
            r4 = r11 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x006e
            r4 = r10 & 4
            if (r4 != 0) goto L_0x0068
            r4 = r31
            boolean r5 = r9.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x006a
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x006c
        L_0x0068:
            r4 = r31
        L_0x006a:
            r5 = 128(0x80, float:1.794E-43)
        L_0x006c:
            r1 = r1 | r5
            goto L_0x0070
        L_0x006e:
            r4 = r31
        L_0x0070:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x0079
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r6 = r32
            goto L_0x008e
        L_0x0079:
            r6 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x008c
            r6 = r32
            boolean r7 = r9.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0088
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x008a
        L_0x0088:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x008a:
            r1 = r1 | r7
            goto L_0x008e
        L_0x008c:
            r6 = r32
        L_0x008e:
            r7 = r10 & 16
            r8 = 57344(0xe000, float:8.0356E-41)
            if (r7 == 0) goto L_0x009a
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r14 = r33
            goto L_0x00af
        L_0x009a:
            r14 = r11 & r8
            if (r14 != 0) goto L_0x00ad
            r14 = r33
            boolean r15 = r9.changed((boolean) r14)
            if (r15 == 0) goto L_0x00a9
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ab
        L_0x00a9:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00ab:
            r1 = r1 | r15
            goto L_0x00af
        L_0x00ad:
            r14 = r33
        L_0x00af:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r11
            if (r15 != 0) goto L_0x00ca
            r15 = r10 & 32
            if (r15 != 0) goto L_0x00c3
            r15 = r34
            boolean r16 = r9.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00c5
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c7
        L_0x00c3:
            r15 = r34
        L_0x00c5:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c7:
            r1 = r1 | r16
            goto L_0x00cc
        L_0x00ca:
            r15 = r34
        L_0x00cc:
            r16 = r10 & 64
            r17 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00d9
            r18 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r18
            r8 = r35
            goto L_0x00ef
        L_0x00d9:
            r18 = r11 & r17
            if (r18 != 0) goto L_0x00ed
            r8 = r35
            boolean r18 = r9.changed((java.lang.Object) r8)
            if (r18 == 0) goto L_0x00e8
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ea
        L_0x00e8:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00ea:
            r1 = r1 | r18
            goto L_0x00ef
        L_0x00ed:
            r8 = r35
        L_0x00ef:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r19 = r11 & r18
            if (r19 != 0) goto L_0x010b
            r0 = r10 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x0104
            r0 = r36
            boolean r20 = r9.changed((java.lang.Object) r0)
            if (r20 == 0) goto L_0x0106
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0108
        L_0x0104:
            r0 = r36
        L_0x0106:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x0108:
            r1 = r1 | r20
            goto L_0x010d
        L_0x010b:
            r0 = r36
        L_0x010d:
            r0 = r10 & 256(0x100, float:3.59E-43)
            r20 = 234881024(0xe000000, float:1.5777218E-30)
            if (r0 == 0) goto L_0x011a
            r21 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r21
            r3 = r37
            goto L_0x0130
        L_0x011a:
            r21 = r11 & r20
            if (r21 != 0) goto L_0x012e
            r3 = r37
            boolean r21 = r9.changed((boolean) r3)
            if (r21 == 0) goto L_0x0129
            r21 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012b
        L_0x0129:
            r21 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012b:
            r1 = r1 | r21
            goto L_0x0130
        L_0x012e:
            r3 = r37
        L_0x0130:
            r3 = r10 & 512(0x200, float:7.175E-43)
            r21 = 1879048192(0x70000000, float:1.58456325E29)
            if (r3 == 0) goto L_0x013a
            r3 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0138:
            r1 = r1 | r3
            goto L_0x014a
        L_0x013a:
            r3 = r11 & r21
            if (r3 != 0) goto L_0x014a
            boolean r3 = r9.changedInstance(r12)
            if (r3 == 0) goto L_0x0147
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0138
        L_0x0147:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0138
        L_0x014a:
            r3 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r3 & r1
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r4) goto L_0x0171
            boolean r3 = r9.getSkipping()
            if (r3 != 0) goto L_0x015a
            goto L_0x0171
        L_0x015a:
            r9.skipToGroupEnd()
            r20 = r36
            r21 = r37
            r22 = r1
            r16 = r6
            r19 = r8
            r17 = r14
            r18 = r15
            r14 = r30
            r15 = r31
            goto L_0x02b1
        L_0x0171:
            r9.startDefaults()
            r3 = r11 & 1
            r4 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r3 == 0) goto L_0x01b2
            boolean r3 = r9.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0182
            goto L_0x01b2
        L_0x0182:
            r9.skipToGroupEnd()
            r0 = r10 & 4
            if (r0 == 0) goto L_0x018b
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x018b:
            r0 = r10 & 32
            if (r0 == 0) goto L_0x0190
            r1 = r1 & r4
        L_0x0190:
            r0 = r10 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01a5
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r0 = r0 & r1
            r3 = r31
            r4 = r36
            r5 = r37
            r7 = r0
            r1 = r14
            r2 = r15
            r0 = r30
            goto L_0x0225
        L_0x01a5:
            r0 = r30
            r3 = r31
            r4 = r36
            r5 = r37
            r7 = r1
            r1 = r14
            r2 = r15
            goto L_0x0225
        L_0x01b2:
            if (r2 == 0) goto L_0x01b9
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x01bb
        L_0x01b9:
            r2 = r30
        L_0x01bb:
            r3 = r10 & 4
            if (r3 == 0) goto L_0x01c8
            r3 = 0
            r4 = 3
            androidx.compose.foundation.lazy.grid.LazyGridState r3 = androidx.compose.foundation.lazy.grid.LazyGridStateKt.rememberLazyGridState(r3, r3, r9, r3, r4)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01ca
        L_0x01c8:
            r3 = r31
        L_0x01ca:
            if (r5 == 0) goto L_0x01db
            r4 = 0
            r5 = 0
            r30 = r2
            float r2 = (float) r4
            float r2 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r2)
            androidx.compose.foundation.layout.PaddingValues r2 = androidx.compose.foundation.layout.PaddingKt.m753PaddingValues0680j_4(r2)
            r6 = r2
            goto L_0x01dd
        L_0x01db:
            r30 = r2
        L_0x01dd:
            if (r7 == 0) goto L_0x01e1
            r2 = 0
            r14 = r2
        L_0x01e1:
            r2 = r10 & 32
            if (r2 == 0) goto L_0x01f7
            androidx.compose.foundation.layout.Arrangement r2 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            if (r14 != 0) goto L_0x01ee
            androidx.compose.foundation.layout.Arrangement$Vertical r2 = r2.getTop()
            goto L_0x01f2
        L_0x01ee:
            androidx.compose.foundation.layout.Arrangement$Vertical r2 = r2.getBottom()
        L_0x01f2:
            r4 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r4
            r15 = r2
        L_0x01f7:
            if (r16 == 0) goto L_0x0200
            androidx.compose.foundation.layout.Arrangement r2 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r2 = r2.getStart()
            r8 = r2
        L_0x0200:
            r2 = r10 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x0210
            androidx.compose.foundation.gestures.ScrollableDefaults r2 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r4 = 6
            androidx.compose.foundation.gestures.FlingBehavior r2 = r2.flingBehavior(r9, r4)
            r4 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r4
            goto L_0x0212
        L_0x0210:
            r2 = r36
        L_0x0212:
            if (r0 == 0) goto L_0x021d
            r0 = 1
            r5 = r0
            r7 = r1
            r4 = r2
            r1 = r14
            r2 = r15
            r0 = r30
            goto L_0x0225
        L_0x021d:
            r0 = r30
            r5 = r37
            r7 = r1
            r4 = r2
            r1 = r14
            r2 = r15
        L_0x0225:
            r9.endDefaults()
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x0237
            r14 = -1
            java.lang.String r15 = "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:62)"
            r10 = 1485410512(0x588990d0, float:1.21004046E15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r10, r7, r14, r15)
        L_0x0237:
            r10 = r7 & 14
            int r14 = r7 >> 15
            r14 = r14 & 112(0x70, float:1.57E-43)
            r10 = r10 | r14
            int r14 = r7 >> 3
            r14 = r14 & 896(0x380, float:1.256E-42)
            r10 = r10 | r14
            kotlin.jvm.functions.Function2 r10 = rememberColumnWidthSums(r13, r8, r6, r9, r10)
            r19 = 1
            int r14 = r7 >> 3
            r14 = r14 & 14
            r15 = 196608(0x30000, float:2.75506E-40)
            r14 = r14 | r15
            int r15 = r7 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r14 = r14 | r15
            r15 = r7 & 7168(0x1c00, float:1.0045E-41)
            r14 = r14 | r15
            r15 = 57344(0xe000, float:8.0356E-41)
            r15 = r15 & r7
            r14 = r14 | r15
            int r15 = r7 >> 3
            r15 = r15 & r17
            r14 = r14 | r15
            int r15 = r7 >> 3
            r15 = r15 & r18
            r14 = r14 | r15
            int r15 = r7 << 9
            r15 = r15 & r20
            r14 = r14 | r15
            int r15 = r7 << 9
            r15 = r15 & r21
            r26 = r14 | r15
            int r14 = r7 >> 27
            r27 = r14 & 14
            r28 = 0
            r14 = r0
            r15 = r3
            r16 = r10
            r17 = r6
            r18 = r1
            r20 = r4
            r21 = r5
            r22 = r2
            r23 = r8
            r24 = r38
            r25 = r9
            androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x02a1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02a1:
            r14 = r0
            r17 = r1
            r18 = r2
            r15 = r3
            r20 = r4
            r21 = r5
            r16 = r6
            r22 = r7
            r19 = r8
        L_0x02b1:
            androidx.compose.runtime.ScopeUpdateScope r10 = r9.endRestartGroup()
            if (r10 != 0) goto L_0x02ba
            r24 = r9
            goto L_0x02e1
        L_0x02ba:
            androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyVerticalGrid$1 r23 = new androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyVerticalGrid$1
            r0 = r23
            r1 = r29
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r24 = r9
            r9 = r21
            r13 = r10
            r10 = r38
            r11 = r40
            r12 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r23
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x02e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid(androidx.compose.foundation.lazy.grid.GridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x02bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyHorizontalGrid(androidx.compose.foundation.lazy.grid.GridCells r29, androidx.compose.ui.Modifier r30, androidx.compose.foundation.lazy.grid.LazyGridState r31, androidx.compose.foundation.layout.PaddingValues r32, boolean r33, androidx.compose.foundation.layout.Arrangement.Horizontal r34, androidx.compose.foundation.layout.Arrangement.Vertical r35, androidx.compose.foundation.gestures.FlingBehavior r36, boolean r37, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r13 = r29
            r12 = r38
            r11 = r40
            r10 = r41
            java.lang.String r0 = "rows"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 2123608858(0x7e93b31a, float:9.816323E37)
            r1 = r39
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LazyHorizontalGrid)P(6,4,7,1,5,3,9,2,8)119@5584L23,125@5941L15,129@6063L64,130@6132L432:LazyGridDsl.kt#7791vq"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r40
            r2 = r10 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            goto L_0x0038
        L_0x002a:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0038
            boolean r2 = r9.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x0036
            r2 = 4
            goto L_0x0037
        L_0x0036:
            r2 = 2
        L_0x0037:
            r1 = r1 | r2
        L_0x0038:
            r2 = r10 & 2
            if (r2 == 0) goto L_0x0041
            r1 = r1 | 48
            r3 = r30
            goto L_0x0056
        L_0x0041:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0054
            r3 = r30
            boolean r4 = r9.changed((java.lang.Object) r3)
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
            r4 = r11 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x006f
            r4 = r10 & 4
            if (r4 != 0) goto L_0x0069
            r4 = r31
            boolean r5 = r9.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x006b
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x006d
        L_0x0069:
            r4 = r31
        L_0x006b:
            r5 = 128(0x80, float:1.794E-43)
        L_0x006d:
            r1 = r1 | r5
            goto L_0x0071
        L_0x006f:
            r4 = r31
        L_0x0071:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x007a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r6 = r32
            goto L_0x008f
        L_0x007a:
            r6 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x008d
            r6 = r32
            boolean r7 = r9.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0089
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x008b
        L_0x0089:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x008b:
            r1 = r1 | r7
            goto L_0x008f
        L_0x008d:
            r6 = r32
        L_0x008f:
            r7 = r10 & 16
            r8 = 57344(0xe000, float:8.0356E-41)
            if (r7 == 0) goto L_0x009b
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r14 = r33
            goto L_0x00b0
        L_0x009b:
            r14 = r11 & r8
            if (r14 != 0) goto L_0x00ae
            r14 = r33
            boolean r15 = r9.changed((boolean) r14)
            if (r15 == 0) goto L_0x00aa
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ac
        L_0x00aa:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00ac:
            r1 = r1 | r15
            goto L_0x00b0
        L_0x00ae:
            r14 = r33
        L_0x00b0:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r11
            if (r15 != 0) goto L_0x00cb
            r15 = r10 & 32
            if (r15 != 0) goto L_0x00c4
            r15 = r34
            boolean r16 = r9.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00c6
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c8
        L_0x00c4:
            r15 = r34
        L_0x00c6:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c8:
            r1 = r1 | r16
            goto L_0x00cd
        L_0x00cb:
            r15 = r34
        L_0x00cd:
            r16 = r10 & 64
            r17 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00da
            r18 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r18
            r8 = r35
            goto L_0x00f0
        L_0x00da:
            r18 = r11 & r17
            if (r18 != 0) goto L_0x00ee
            r8 = r35
            boolean r18 = r9.changed((java.lang.Object) r8)
            if (r18 == 0) goto L_0x00e9
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00eb
        L_0x00e9:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00eb:
            r1 = r1 | r18
            goto L_0x00f0
        L_0x00ee:
            r8 = r35
        L_0x00f0:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r19 = r11 & r18
            if (r19 != 0) goto L_0x010c
            r0 = r10 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x0105
            r0 = r36
            boolean r20 = r9.changed((java.lang.Object) r0)
            if (r20 == 0) goto L_0x0107
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0109
        L_0x0105:
            r0 = r36
        L_0x0107:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x0109:
            r1 = r1 | r20
            goto L_0x010e
        L_0x010c:
            r0 = r36
        L_0x010e:
            r0 = r10 & 256(0x100, float:3.59E-43)
            r20 = 234881024(0xe000000, float:1.5777218E-30)
            if (r0 == 0) goto L_0x011b
            r21 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r21
            r3 = r37
            goto L_0x0131
        L_0x011b:
            r21 = r11 & r20
            if (r21 != 0) goto L_0x012f
            r3 = r37
            boolean r21 = r9.changed((boolean) r3)
            if (r21 == 0) goto L_0x012a
            r21 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012c
        L_0x012a:
            r21 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012c:
            r1 = r1 | r21
            goto L_0x0131
        L_0x012f:
            r3 = r37
        L_0x0131:
            r3 = r10 & 512(0x200, float:7.175E-43)
            r21 = 1879048192(0x70000000, float:1.58456325E29)
            if (r3 == 0) goto L_0x013b
            r3 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0139:
            r1 = r1 | r3
            goto L_0x014b
        L_0x013b:
            r3 = r11 & r21
            if (r3 != 0) goto L_0x014b
            boolean r3 = r9.changedInstance(r12)
            if (r3 == 0) goto L_0x0148
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0139
        L_0x0148:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0139
        L_0x014b:
            r3 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r3 & r1
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r4) goto L_0x0172
            boolean r3 = r9.getSkipping()
            if (r3 != 0) goto L_0x015b
            goto L_0x0172
        L_0x015b:
            r9.skipToGroupEnd()
            r20 = r36
            r21 = r37
            r22 = r1
            r16 = r6
            r19 = r8
            r17 = r14
            r18 = r15
            r14 = r30
            r15 = r31
            goto L_0x02b2
        L_0x0172:
            r9.startDefaults()
            r3 = r11 & 1
            r4 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r3 == 0) goto L_0x01b3
            boolean r3 = r9.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0183
            goto L_0x01b3
        L_0x0183:
            r9.skipToGroupEnd()
            r0 = r10 & 4
            if (r0 == 0) goto L_0x018c
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x018c:
            r0 = r10 & 32
            if (r0 == 0) goto L_0x0191
            r1 = r1 & r4
        L_0x0191:
            r0 = r10 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01a6
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r0 = r0 & r1
            r3 = r31
            r4 = r36
            r5 = r37
            r7 = r0
            r1 = r14
            r2 = r15
            r0 = r30
            goto L_0x0226
        L_0x01a6:
            r0 = r30
            r3 = r31
            r4 = r36
            r5 = r37
            r7 = r1
            r1 = r14
            r2 = r15
            goto L_0x0226
        L_0x01b3:
            if (r2 == 0) goto L_0x01ba
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x01bc
        L_0x01ba:
            r2 = r30
        L_0x01bc:
            r3 = r10 & 4
            if (r3 == 0) goto L_0x01c9
            r3 = 0
            r4 = 3
            androidx.compose.foundation.lazy.grid.LazyGridState r3 = androidx.compose.foundation.lazy.grid.LazyGridStateKt.rememberLazyGridState(r3, r3, r9, r3, r4)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01cb
        L_0x01c9:
            r3 = r31
        L_0x01cb:
            if (r5 == 0) goto L_0x01dc
            r4 = 0
            r5 = 0
            r30 = r2
            float r2 = (float) r4
            float r2 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r2)
            androidx.compose.foundation.layout.PaddingValues r2 = androidx.compose.foundation.layout.PaddingKt.m753PaddingValues0680j_4(r2)
            r6 = r2
            goto L_0x01de
        L_0x01dc:
            r30 = r2
        L_0x01de:
            if (r7 == 0) goto L_0x01e2
            r2 = 0
            r14 = r2
        L_0x01e2:
            r2 = r10 & 32
            if (r2 == 0) goto L_0x01f8
            androidx.compose.foundation.layout.Arrangement r2 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            if (r14 != 0) goto L_0x01ef
            androidx.compose.foundation.layout.Arrangement$Horizontal r2 = r2.getStart()
            goto L_0x01f3
        L_0x01ef:
            androidx.compose.foundation.layout.Arrangement$Horizontal r2 = r2.getEnd()
        L_0x01f3:
            r4 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r4
            r15 = r2
        L_0x01f8:
            if (r16 == 0) goto L_0x0201
            androidx.compose.foundation.layout.Arrangement r2 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r2 = r2.getTop()
            r8 = r2
        L_0x0201:
            r2 = r10 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x0211
            androidx.compose.foundation.gestures.ScrollableDefaults r2 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r4 = 6
            androidx.compose.foundation.gestures.FlingBehavior r2 = r2.flingBehavior(r9, r4)
            r4 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r4
            goto L_0x0213
        L_0x0211:
            r2 = r36
        L_0x0213:
            if (r0 == 0) goto L_0x021e
            r0 = 1
            r5 = r0
            r7 = r1
            r4 = r2
            r1 = r14
            r2 = r15
            r0 = r30
            goto L_0x0226
        L_0x021e:
            r0 = r30
            r5 = r37
            r7 = r1
            r4 = r2
            r1 = r14
            r2 = r15
        L_0x0226:
            r9.endDefaults()
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x0238
            r14 = -1
            java.lang.String r15 = "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:116)"
            r10 = 2123608858(0x7e93b31a, float:9.816323E37)
            androidx.compose.runtime.ComposerKt.traceEventStart(r10, r7, r14, r15)
        L_0x0238:
            r10 = r7 & 14
            int r14 = r7 >> 15
            r14 = r14 & 112(0x70, float:1.57E-43)
            r10 = r10 | r14
            int r14 = r7 >> 3
            r14 = r14 & 896(0x380, float:1.256E-42)
            r10 = r10 | r14
            kotlin.jvm.functions.Function2 r10 = rememberRowHeightSums(r13, r8, r6, r9, r10)
            r19 = 0
            int r14 = r7 >> 3
            r14 = r14 & 14
            r15 = 196608(0x30000, float:2.75506E-40)
            r14 = r14 | r15
            int r15 = r7 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r14 = r14 | r15
            r15 = r7 & 7168(0x1c00, float:1.0045E-41)
            r14 = r14 | r15
            r15 = 57344(0xe000, float:8.0356E-41)
            r15 = r15 & r7
            r14 = r14 | r15
            int r15 = r7 >> 3
            r15 = r15 & r17
            r14 = r14 | r15
            int r15 = r7 >> 3
            r15 = r15 & r18
            r14 = r14 | r15
            int r15 = r7 << 6
            r15 = r15 & r20
            r14 = r14 | r15
            int r15 = r7 << 12
            r15 = r15 & r21
            r26 = r14 | r15
            int r14 = r7 >> 27
            r27 = r14 & 14
            r28 = 0
            r14 = r0
            r15 = r3
            r16 = r10
            r17 = r6
            r18 = r1
            r20 = r4
            r21 = r5
            r22 = r8
            r23 = r2
            r24 = r38
            r25 = r9
            androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x02a2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02a2:
            r14 = r0
            r17 = r1
            r18 = r2
            r15 = r3
            r20 = r4
            r21 = r5
            r16 = r6
            r22 = r7
            r19 = r8
        L_0x02b2:
            androidx.compose.runtime.ScopeUpdateScope r10 = r9.endRestartGroup()
            if (r10 != 0) goto L_0x02bb
            r24 = r9
            goto L_0x02e2
        L_0x02bb:
            androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyHorizontalGrid$1 r23 = new androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyHorizontalGrid$1
            r0 = r23
            r1 = r29
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r24 = r9
            r9 = r21
            r13 = r10
            r10 = r38
            r11 = r40
            r12 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r23
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x02e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid(androidx.compose.foundation.lazy.grid.GridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Function2<Density, Constraints, List<Integer>> rememberColumnWidthSums(GridCells columns, Arrangement.Horizontal horizontalArrangement, PaddingValues contentPadding, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(-1355301804);
        ComposerKt.sourceInformation($composer, "C(rememberColumnWidthSums)P(!1,2)152@6816L830:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1355301804, $changed, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:148)");
        }
        int i = ($changed & 14) | ($changed & 112) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) columns) | $composer.changed((Object) horizontalArrangement) | $composer.changed((Object) contentPadding);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function2) new LazyGridDslKt$rememberColumnWidthSums$1$1(contentPadding, columns, horizontalArrangement);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function2<Density, Constraints, List<Integer>> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }

    private static final Function2<Density, Constraints, List<Integer>> rememberRowHeightSums(GridCells rows, Arrangement.Vertical verticalArrangement, PaddingValues contentPadding, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(239683573);
        ComposerKt.sourceInformation($composer, "C(rememberRowHeightSums)P(1,2)184@7885L786:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(239683573, $changed, -1, "androidx.compose.foundation.lazy.grid.rememberRowHeightSums (LazyGridDsl.kt:180)");
        }
        int i = ($changed & 14) | ($changed & 112) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) rows) | $composer.changed((Object) verticalArrangement) | $composer.changed((Object) contentPadding);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function2) new LazyGridDslKt$rememberRowHeightSums$1$1(contentPadding, rows, verticalArrangement);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function2<Density, Constraints, List<Integer>> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }

    /* access modifiers changed from: private */
    public static final List<Integer> calculateCellsCrossAxisSizeImpl(int gridSize, int slotCount, int spacing) {
        int gridSizeWithoutSpacing = gridSize - ((slotCount - 1) * spacing);
        int slotSize = gridSizeWithoutSpacing / slotCount;
        int remainingPixels = gridSizeWithoutSpacing % slotCount;
        ArrayList arrayList = new ArrayList(slotCount);
        int it = 0;
        while (it < slotCount) {
            arrayList.add(Integer.valueOf((it < remainingPixels ? 1 : 0) + slotSize));
            it++;
        }
        return arrayList;
    }

    public static /* synthetic */ void items$default(LazyGridScope $this$items_u24default, List items, Function1 key, Function2 span, Function1 contentType, Function4 itemContent, int i, Object obj) {
        Function1 function1;
        Function2 function2;
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            span = null;
        }
        if ((i & 8) != 0) {
            contentType = LazyGridDslKt$items$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter($this$items_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (key != null) {
            function1 = new LazyGridDslKt$items$2(key, items);
        } else {
            function1 = null;
        }
        if (span != null) {
            function2 = new LazyGridDslKt$items$3(span, items);
        } else {
            function2 = null;
        }
        $this$items_u24default.items(size, function1, function2, new LazyGridDslKt$items$4(contentType, items), ComposableLambdaKt.composableLambdaInstance(699646206, true, new LazyGridDslKt$items$5(itemContent, items)));
    }

    public static final <T> void items(LazyGridScope $this$items, List<? extends T> items, Function1<? super T, ? extends Object> key, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> span, Function1<? super T, ? extends Object> contentType, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Function1 function1;
        Function2 function2;
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (key != null) {
            function1 = new LazyGridDslKt$items$2(key, items);
        } else {
            function1 = null;
        }
        if (span != null) {
            function2 = new LazyGridDslKt$items$3(span, items);
        } else {
            function2 = null;
        }
        $this$items.items(size, function1, function2, new LazyGridDslKt$items$4(contentType, items), ComposableLambdaKt.composableLambdaInstance(699646206, true, new LazyGridDslKt$items$5(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope $this$itemsIndexed_u24default, List items, Function2 key, Function3 span, Function2 contentType, Function5 itemContent, int i, Object obj) {
        Function1 function1;
        Function2 function2;
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            span = null;
        }
        if ((i & 8) != 0) {
            contentType = LazyGridDslKt$itemsIndexed$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter($this$itemsIndexed_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (key != null) {
            function1 = new LazyGridDslKt$itemsIndexed$2(key, items);
        } else {
            function1 = null;
        }
        if (span != null) {
            function2 = new LazyGridDslKt$itemsIndexed$3(span, items);
        } else {
            function2 = null;
        }
        $this$itemsIndexed_u24default.items(size, function1, function2, new LazyGridDslKt$itemsIndexed$4(contentType, items), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new LazyGridDslKt$itemsIndexed$5(itemContent, items)));
    }

    public static final <T> void itemsIndexed(LazyGridScope $this$itemsIndexed, List<? extends T> items, Function2<? super Integer, ? super T, ? extends Object> key, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> span, Function2<? super Integer, ? super T, ? extends Object> contentType, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Function1 function1;
        Function2 function2;
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (key != null) {
            function1 = new LazyGridDslKt$itemsIndexed$2(key, items);
        } else {
            function1 = null;
        }
        if (span != null) {
            function2 = new LazyGridDslKt$itemsIndexed$3(span, items);
        } else {
            function2 = null;
        }
        $this$itemsIndexed.items(size, function1, function2, new LazyGridDslKt$itemsIndexed$4(contentType, items), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new LazyGridDslKt$itemsIndexed$5(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyGridScope $this$items_u24default, Object[] items, Function1 key, Function2 span, Function1 contentType, Function4 itemContent, int i, Object obj) {
        Function1 function1;
        Function2 function2;
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            span = null;
        }
        if ((i & 8) != 0) {
            contentType = LazyGridDslKt$items$6.INSTANCE;
        }
        Intrinsics.checkNotNullParameter($this$items_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (key != null) {
            function1 = new LazyGridDslKt$items$7(key, items);
        } else {
            function1 = null;
        }
        if (span != null) {
            function2 = new LazyGridDslKt$items$8(span, items);
        } else {
            function2 = null;
        }
        $this$items_u24default.items(length, function1, function2, new LazyGridDslKt$items$9(contentType, items), ComposableLambdaKt.composableLambdaInstance(407562193, true, new LazyGridDslKt$items$10(itemContent, items)));
    }

    public static final <T> void items(LazyGridScope $this$items, T[] items, Function1<? super T, ? extends Object> key, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> span, Function1<? super T, ? extends Object> contentType, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Function1 function1;
        Function2 function2;
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (key != null) {
            function1 = new LazyGridDslKt$items$7(key, items);
        } else {
            function1 = null;
        }
        if (span != null) {
            function2 = new LazyGridDslKt$items$8(span, items);
        } else {
            function2 = null;
        }
        $this$items.items(length, function1, function2, new LazyGridDslKt$items$9(contentType, items), ComposableLambdaKt.composableLambdaInstance(407562193, true, new LazyGridDslKt$items$10(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope $this$itemsIndexed_u24default, Object[] items, Function2 key, Function3 span, Function2 contentType, Function5 itemContent, int i, Object obj) {
        Function1 function1;
        Function2 function2;
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            span = null;
        }
        if ((i & 8) != 0) {
            contentType = LazyGridDslKt$itemsIndexed$6.INSTANCE;
        }
        Intrinsics.checkNotNullParameter($this$itemsIndexed_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (key != null) {
            function1 = new LazyGridDslKt$itemsIndexed$7(key, items);
        } else {
            function1 = null;
        }
        if (span != null) {
            function2 = new LazyGridDslKt$itemsIndexed$8(span, items);
        } else {
            function2 = null;
        }
        $this$itemsIndexed_u24default.items(length, function1, function2, new LazyGridDslKt$itemsIndexed$9(contentType, items), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new LazyGridDslKt$itemsIndexed$10(itemContent, items)));
    }

    public static final <T> void itemsIndexed(LazyGridScope $this$itemsIndexed, T[] items, Function2<? super Integer, ? super T, ? extends Object> key, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> span, Function2<? super Integer, ? super T, ? extends Object> contentType, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Function1 function1;
        Function2 function2;
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (key != null) {
            function1 = new LazyGridDslKt$itemsIndexed$7(key, items);
        } else {
            function1 = null;
        }
        if (span != null) {
            function2 = new LazyGridDslKt$itemsIndexed$8(span, items);
        } else {
            function2 = null;
        }
        $this$itemsIndexed.items(length, function1, function2, new LazyGridDslKt$itemsIndexed$9(contentType, items), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new LazyGridDslKt$itemsIndexed$10(itemContent, items)));
    }
}
