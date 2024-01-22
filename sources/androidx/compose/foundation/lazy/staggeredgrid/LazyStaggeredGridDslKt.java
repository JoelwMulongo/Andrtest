package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0001\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a?\u0010 \u001a\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0!¢\u0006\u0002\b\u00162\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0001¢\u0006\u0002\u0010%\u001a?\u0010&\u001a\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0!¢\u0006\u0002\b\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0001¢\u0006\u0002\u0010'\u001aÓ\u0001\u0010(\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0*2%\b\n\u0010+\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\u00142%\b\u0006\u00100\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\u00142%\b\n\u00101\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010\u001423\b\u0004\u00103\u001a-\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\bø\u0001\u0002¢\u0006\u0002\u00106\u001aÓ\u0001\u0010(\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)072%\b\n\u0010+\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\u00142%\b\u0006\u00100\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\u00142%\b\n\u00101\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010\u001423\b\u0004\u00103\u001a-\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\bø\u0001\u0002¢\u0006\u0002\u00108\u001a§\u0002\u00109\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0*2:\b\n\u0010+\u001a4\u0012\u0013\u0012\u00110:¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010!2:\b\u0006\u00100\u001a4\u0012\u0013\u0012\u00110:¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0!2:\b\n\u00101\u001a4\u0012\u0013\u0012\u00110:¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010!2H\b\u0004\u00103\u001aB\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u00110:¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010<¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\bø\u0001\u0002¢\u0006\u0002\u0010=\u001a§\u0002\u00109\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)072:\b\n\u0010+\u001a4\u0012\u0013\u0012\u00110:¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010!2:\b\u0006\u00100\u001a4\u0012\u0013\u0012\u00110:¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0!2:\b\n\u00101\u001a4\u0012\u0013\u0012\u00110:¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010!2H\b\u0004\u00103\u001aB\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u00110:¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010<¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\bø\u0001\u0002¢\u0006\u0002\u0010>\u0002\u0012\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006?"}, d2 = {"LazyHorizontalStaggeredGrid", "", "rows", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalItemSpacing", "Landroidx/compose/ui/unit/Dp;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyHorizontalStaggeredGrid-cJHQLPU", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalStaggeredGrid", "columns", "verticalItemSpacing", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "LazyVerticalStaggeredGrid-zadm560", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZFLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberColumnWidthSums", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "contentType", "span", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "itemContent", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridDsl.kt */
public final class LazyStaggeredGridDslKt {
    /* JADX WARNING: Removed duplicated region for block: B:106:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0297  */
    /* renamed from: LazyVerticalStaggeredGrid-zadm560  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1037LazyVerticalStaggeredGridzadm560(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells r29, androidx.compose.ui.Modifier r30, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r31, androidx.compose.foundation.layout.PaddingValues r32, boolean r33, float r34, androidx.compose.foundation.layout.Arrangement.Horizontal r35, androidx.compose.foundation.gestures.FlingBehavior r36, boolean r37, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r13 = r29
            r12 = r38
            r11 = r40
            r10 = r41
            java.lang.String r0 = "columns"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 1695323794(0x650c9692, float:4.1494302E22)
            r1 = r39
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LazyVerticalStaggeredGrid)P(!1,5,7,2,6,9:c#ui.unit.Dp,4,3,8)61@3004L32,66@3301L15,80@3822L71,70@3412L514:LazyStaggeredGridDsl.kt#fzvcnm"
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
            r4 = r30
            goto L_0x0055
        L_0x0040:
            r4 = r11 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0053
            r4 = r30
            boolean r5 = r9.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004f
            r5 = 32
            goto L_0x0051
        L_0x004f:
            r5 = 16
        L_0x0051:
            r1 = r1 | r5
            goto L_0x0055
        L_0x0053:
            r4 = r30
        L_0x0055:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x005b
            r1 = r1 | 128(0x80, float:1.794E-43)
        L_0x005b:
            r6 = r10 & 8
            if (r6 == 0) goto L_0x0064
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r32
            goto L_0x0079
        L_0x0064:
            r7 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0077
            r7 = r32
            boolean r8 = r9.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0073
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0075
        L_0x0073:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0075:
            r1 = r1 | r8
            goto L_0x0079
        L_0x0077:
            r7 = r32
        L_0x0079:
            r8 = r10 & 16
            r14 = 57344(0xe000, float:8.0356E-41)
            if (r8 == 0) goto L_0x0085
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r15 = r33
            goto L_0x009b
        L_0x0085:
            r15 = r11 & r14
            if (r15 != 0) goto L_0x0099
            r15 = r33
            boolean r16 = r9.changed((boolean) r15)
            if (r16 == 0) goto L_0x0094
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r1 = r1 | r16
            goto L_0x009b
        L_0x0099:
            r15 = r33
        L_0x009b:
            r16 = r10 & 32
            r17 = 458752(0x70000, float:6.42848E-40)
            if (r16 == 0) goto L_0x00a8
            r18 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r18
            r14 = r34
            goto L_0x00be
        L_0x00a8:
            r18 = r11 & r17
            if (r18 != 0) goto L_0x00bc
            r14 = r34
            boolean r18 = r9.changed((float) r14)
            if (r18 == 0) goto L_0x00b7
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00b7:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00b9:
            r1 = r1 | r18
            goto L_0x00be
        L_0x00bc:
            r14 = r34
        L_0x00be:
            r18 = r10 & 64
            r19 = 3670016(0x380000, float:5.142788E-39)
            if (r18 == 0) goto L_0x00cb
            r20 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r20
            r0 = r35
            goto L_0x00e1
        L_0x00cb:
            r20 = r11 & r19
            if (r20 != 0) goto L_0x00df
            r0 = r35
            boolean r21 = r9.changed((java.lang.Object) r0)
            if (r21 == 0) goto L_0x00da
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00dc
        L_0x00da:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x00dc:
            r1 = r1 | r21
            goto L_0x00e1
        L_0x00df:
            r0 = r35
        L_0x00e1:
            r21 = 29360128(0x1c00000, float:7.052966E-38)
            r22 = r11 & r21
            if (r22 != 0) goto L_0x00fd
            r3 = r10 & 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x00f6
            r3 = r36
            boolean r23 = r9.changed((java.lang.Object) r3)
            if (r23 == 0) goto L_0x00f8
            r23 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fa
        L_0x00f6:
            r3 = r36
        L_0x00f8:
            r23 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fa:
            r1 = r1 | r23
            goto L_0x00ff
        L_0x00fd:
            r3 = r36
        L_0x00ff:
            r0 = r10 & 256(0x100, float:3.59E-43)
            r23 = 234881024(0xe000000, float:1.5777218E-30)
            if (r0 == 0) goto L_0x010c
            r24 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r24
            r3 = r37
            goto L_0x0122
        L_0x010c:
            r24 = r11 & r23
            if (r24 != 0) goto L_0x0120
            r3 = r37
            boolean r24 = r9.changed((boolean) r3)
            if (r24 == 0) goto L_0x011b
            r24 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011d
        L_0x011b:
            r24 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011d:
            r1 = r1 | r24
            goto L_0x0122
        L_0x0120:
            r3 = r37
        L_0x0122:
            r3 = r10 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x012a
            r3 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0128:
            r1 = r1 | r3
            goto L_0x013b
        L_0x012a:
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r11
            if (r3 != 0) goto L_0x013b
            boolean r3 = r9.changedInstance(r12)
            if (r3 == 0) goto L_0x0138
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0128
        L_0x0138:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0128
        L_0x013b:
            r3 = 4
            if (r5 != r3) goto L_0x0165
            r3 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r3 & r1
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r4) goto L_0x0165
            boolean r3 = r9.getSkipping()
            if (r3 != 0) goto L_0x014e
            goto L_0x0165
        L_0x014e:
            r9.skipToGroupEnd()
            r19 = r35
            r20 = r36
            r21 = r37
            r22 = r1
            r16 = r7
            r18 = r14
            r17 = r15
            r14 = r30
            r15 = r31
            goto L_0x028e
        L_0x0165:
            r9.startDefaults()
            r3 = r11 & 1
            r4 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            if (r3 == 0) goto L_0x01a2
            boolean r3 = r9.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0176
            goto L_0x01a2
        L_0x0176:
            r9.skipToGroupEnd()
            if (r5 == 0) goto L_0x017d
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x017d:
            r0 = r10 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0193
            r0 = r1 & r4
            r2 = r30
            r3 = r31
            r8 = r36
            r1 = r0
            r4 = r7
            r6 = r14
            r5 = r15
            r7 = r35
            r0 = r37
            goto L_0x0203
        L_0x0193:
            r2 = r30
            r3 = r31
            r8 = r36
            r0 = r37
            r4 = r7
            r6 = r14
            r5 = r15
            r7 = r35
            goto L_0x0203
        L_0x01a2:
            if (r2 == 0) goto L_0x01a9
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x01ab
        L_0x01a9:
            r2 = r30
        L_0x01ab:
            if (r5 == 0) goto L_0x01b6
            r3 = 0
            r5 = 3
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r3 = androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(r3, r3, r9, r3, r5)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01b8
        L_0x01b6:
            r3 = r31
        L_0x01b8:
            if (r6 == 0) goto L_0x01c6
            r5 = 0
            r6 = 0
            float r4 = (float) r5
            float r4 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r4)
            androidx.compose.foundation.layout.PaddingValues r4 = androidx.compose.foundation.layout.PaddingKt.m753PaddingValues0680j_4(r4)
            goto L_0x01c7
        L_0x01c6:
            r4 = r7
        L_0x01c7:
            if (r8 == 0) goto L_0x01cb
            r5 = 0
            goto L_0x01cc
        L_0x01cb:
            r5 = r15
        L_0x01cc:
            if (r16 == 0) goto L_0x01d6
            r6 = 0
            r7 = 0
            float r8 = (float) r6
            float r6 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r8)
            goto L_0x01d7
        L_0x01d6:
            r6 = r14
        L_0x01d7:
            if (r18 == 0) goto L_0x01e9
            androidx.compose.foundation.layout.Arrangement r7 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            r8 = 0
            r14 = 0
            float r15 = (float) r8
            float r8 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r15)
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r7 = r7.m677spacedBy0680j_4(r8)
            androidx.compose.foundation.layout.Arrangement$Horizontal r7 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r7
            goto L_0x01eb
        L_0x01e9:
            r7 = r35
        L_0x01eb:
            r8 = r10 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x01fb
            androidx.compose.foundation.gestures.ScrollableDefaults r8 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r14 = 6
            androidx.compose.foundation.gestures.FlingBehavior r8 = r8.flingBehavior(r9, r14)
            r14 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r14
            goto L_0x01fd
        L_0x01fb:
            r8 = r36
        L_0x01fd:
            if (r0 == 0) goto L_0x0201
            r0 = 1
            goto L_0x0203
        L_0x0201:
            r0 = r37
        L_0x0203:
            r9.endDefaults()
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x0215
            r14 = -1
            java.lang.String r15 = "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:58)"
            r10 = 1695323794(0x650c9692, float:4.1494302E22)
            androidx.compose.runtime.ComposerKt.traceEventStart(r10, r1, r14, r15)
        L_0x0215:
            androidx.compose.foundation.gestures.Orientation r15 = androidx.compose.foundation.gestures.Orientation.Vertical
            float r10 = r7.m685getSpacingD9Ej5fM()
            r14 = r1 & 14
            int r16 = r1 >> 15
            r16 = r16 & 112(0x70, float:1.57E-43)
            r14 = r14 | r16
            int r11 = r1 >> 3
            r11 = r11 & 896(0x380, float:1.256E-42)
            r11 = r11 | r14
            kotlin.jvm.functions.Function2 r16 = rememberColumnWidthSums(r13, r7, r4, r9, r11)
            int r11 = r1 << 6
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | 56
            int r14 = r1 << 3
            r18 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r18
            r11 = r11 | r14
            int r14 = r1 << 3
            r14 = r14 & r17
            r11 = r11 | r14
            int r14 = r1 >> 3
            r14 = r14 & r19
            r11 = r11 | r14
            int r14 = r1 >> 3
            r14 = r14 & r21
            r11 = r11 | r14
            int r14 = r1 << 9
            r14 = r14 & r23
            r26 = r11 | r14
            int r11 = r1 >> 27
            r27 = r11 & 14
            r28 = 0
            r14 = r3
            r17 = r2
            r18 = r4
            r19 = r5
            r20 = r8
            r21 = r0
            r22 = r6
            r23 = r10
            r24 = r38
            r25 = r9
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt.m1042LazyStaggeredGridLJWHXA8(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x027e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x027e:
            r21 = r0
            r22 = r1
            r14 = r2
            r15 = r3
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
        L_0x028e:
            androidx.compose.runtime.ScopeUpdateScope r11 = r9.endRestartGroup()
            if (r11 != 0) goto L_0x0297
            r24 = r9
            goto L_0x02be
        L_0x0297:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1 r23 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1
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
            r10 = r38
            r13 = r11
            r11 = r40
            r12 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r23
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x02be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.m1037LazyVerticalStaggeredGridzadm560(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState, androidx.compose.foundation.layout.PaddingValues, boolean, float, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Function2<Density, Constraints, int[]> rememberColumnWidthSums(StaggeredGridCells columns, Arrangement.Horizontal horizontalArrangement, PaddingValues contentPadding, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(1426908594);
        ComposerKt.sourceInformation($composer, "C(rememberColumnWidthSums)P(!1,2)92@4215L920:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1426908594, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberColumnWidthSums (LazyStaggeredGridDsl.kt:88)");
        }
        int i = ($changed & 14) | ($changed & 112) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) columns) | $composer.changed((Object) horizontalArrangement) | $composer.changed((Object) contentPadding);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function2) new LazyStaggeredGridDslKt$rememberColumnWidthSums$1$1(contentPadding, columns, horizontalArrangement);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function2<Density, Constraints, int[]> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0298  */
    /* renamed from: LazyHorizontalStaggeredGrid-cJHQLPU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1036LazyHorizontalStaggeredGridcJHQLPU(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells r29, androidx.compose.ui.Modifier r30, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r31, androidx.compose.foundation.layout.PaddingValues r32, boolean r33, androidx.compose.foundation.layout.Arrangement.Vertical r34, float r35, androidx.compose.foundation.gestures.FlingBehavior r36, boolean r37, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r13 = r29
            r12 = r38
            r11 = r40
            r10 = r41
            java.lang.String r0 = "rows"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -8666074(0xffffffffff7bc426, float:-3.3465469E38)
            r1 = r39
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LazyHorizontalStaggeredGrid)P(6,4,7,1,5,9,3:c#ui.unit.Dp,2,8)146@6608L32,151@6903L15,165@7426L64,155@7014L509:LazyStaggeredGridDsl.kt#fzvcnm"
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
            r4 = r30
            goto L_0x0056
        L_0x0041:
            r4 = r11 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0054
            r4 = r30
            boolean r5 = r9.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0050
            r5 = 32
            goto L_0x0052
        L_0x0050:
            r5 = 16
        L_0x0052:
            r1 = r1 | r5
            goto L_0x0056
        L_0x0054:
            r4 = r30
        L_0x0056:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x005c
            r1 = r1 | 128(0x80, float:1.794E-43)
        L_0x005c:
            r6 = r10 & 8
            if (r6 == 0) goto L_0x0065
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r32
            goto L_0x007a
        L_0x0065:
            r7 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0078
            r7 = r32
            boolean r8 = r9.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0074
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0076
        L_0x0074:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0076:
            r1 = r1 | r8
            goto L_0x007a
        L_0x0078:
            r7 = r32
        L_0x007a:
            r8 = r10 & 16
            r14 = 57344(0xe000, float:8.0356E-41)
            if (r8 == 0) goto L_0x0086
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r15 = r33
            goto L_0x009c
        L_0x0086:
            r15 = r11 & r14
            if (r15 != 0) goto L_0x009a
            r15 = r33
            boolean r16 = r9.changed((boolean) r15)
            if (r16 == 0) goto L_0x0095
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r1 = r1 | r16
            goto L_0x009c
        L_0x009a:
            r15 = r33
        L_0x009c:
            r16 = r10 & 32
            r17 = 458752(0x70000, float:6.42848E-40)
            if (r16 == 0) goto L_0x00a9
            r18 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r18
            r14 = r34
            goto L_0x00bf
        L_0x00a9:
            r18 = r11 & r17
            if (r18 != 0) goto L_0x00bd
            r14 = r34
            boolean r18 = r9.changed((java.lang.Object) r14)
            if (r18 == 0) goto L_0x00b8
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ba
        L_0x00b8:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00ba:
            r1 = r1 | r18
            goto L_0x00bf
        L_0x00bd:
            r14 = r34
        L_0x00bf:
            r18 = r10 & 64
            r19 = 3670016(0x380000, float:5.142788E-39)
            if (r18 == 0) goto L_0x00cc
            r20 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r20
            r0 = r35
            goto L_0x00e2
        L_0x00cc:
            r20 = r11 & r19
            if (r20 != 0) goto L_0x00e0
            r0 = r35
            boolean r21 = r9.changed((float) r0)
            if (r21 == 0) goto L_0x00db
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00dd
        L_0x00db:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x00dd:
            r1 = r1 | r21
            goto L_0x00e2
        L_0x00e0:
            r0 = r35
        L_0x00e2:
            r21 = 29360128(0x1c00000, float:7.052966E-38)
            r22 = r11 & r21
            if (r22 != 0) goto L_0x00fe
            r3 = r10 & 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x00f7
            r3 = r36
            boolean r23 = r9.changed((java.lang.Object) r3)
            if (r23 == 0) goto L_0x00f9
            r23 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fb
        L_0x00f7:
            r3 = r36
        L_0x00f9:
            r23 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fb:
            r1 = r1 | r23
            goto L_0x0100
        L_0x00fe:
            r3 = r36
        L_0x0100:
            r0 = r10 & 256(0x100, float:3.59E-43)
            r23 = 234881024(0xe000000, float:1.5777218E-30)
            if (r0 == 0) goto L_0x010d
            r24 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r24
            r3 = r37
            goto L_0x0123
        L_0x010d:
            r24 = r11 & r23
            if (r24 != 0) goto L_0x0121
            r3 = r37
            boolean r24 = r9.changed((boolean) r3)
            if (r24 == 0) goto L_0x011c
            r24 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011e
        L_0x011c:
            r24 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011e:
            r1 = r1 | r24
            goto L_0x0123
        L_0x0121:
            r3 = r37
        L_0x0123:
            r3 = r10 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x012b
            r3 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0129:
            r1 = r1 | r3
            goto L_0x013c
        L_0x012b:
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r11
            if (r3 != 0) goto L_0x013c
            boolean r3 = r9.changedInstance(r12)
            if (r3 == 0) goto L_0x0139
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0129
        L_0x0139:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0129
        L_0x013c:
            r3 = 4
            if (r5 != r3) goto L_0x0166
            r3 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r3 & r1
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r4) goto L_0x0166
            boolean r3 = r9.getSkipping()
            if (r3 != 0) goto L_0x014f
            goto L_0x0166
        L_0x014f:
            r9.skipToGroupEnd()
            r19 = r35
            r20 = r36
            r21 = r37
            r22 = r1
            r16 = r7
            r18 = r14
            r17 = r15
            r14 = r30
            r15 = r31
            goto L_0x028f
        L_0x0166:
            r9.startDefaults()
            r3 = r11 & 1
            r4 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            if (r3 == 0) goto L_0x01a3
            boolean r3 = r9.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0177
            goto L_0x01a3
        L_0x0177:
            r9.skipToGroupEnd()
            if (r5 == 0) goto L_0x017e
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x017e:
            r0 = r10 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0194
            r0 = r1 & r4
            r2 = r30
            r3 = r31
            r8 = r36
            r1 = r0
            r4 = r7
            r6 = r14
            r5 = r15
            r7 = r35
            r0 = r37
            goto L_0x0204
        L_0x0194:
            r2 = r30
            r3 = r31
            r8 = r36
            r0 = r37
            r4 = r7
            r6 = r14
            r5 = r15
            r7 = r35
            goto L_0x0204
        L_0x01a3:
            if (r2 == 0) goto L_0x01aa
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x01ac
        L_0x01aa:
            r2 = r30
        L_0x01ac:
            if (r5 == 0) goto L_0x01b7
            r3 = 0
            r5 = 3
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r3 = androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(r3, r3, r9, r3, r5)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01b9
        L_0x01b7:
            r3 = r31
        L_0x01b9:
            if (r6 == 0) goto L_0x01c7
            r5 = 0
            r6 = 0
            float r4 = (float) r5
            float r4 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r4)
            androidx.compose.foundation.layout.PaddingValues r4 = androidx.compose.foundation.layout.PaddingKt.m753PaddingValues0680j_4(r4)
            goto L_0x01c8
        L_0x01c7:
            r4 = r7
        L_0x01c8:
            if (r8 == 0) goto L_0x01cc
            r5 = 0
            goto L_0x01cd
        L_0x01cc:
            r5 = r15
        L_0x01cd:
            if (r16 == 0) goto L_0x01df
            androidx.compose.foundation.layout.Arrangement r6 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            r7 = 0
            r8 = 0
            float r15 = (float) r7
            float r7 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r15)
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r6 = r6.m677spacedBy0680j_4(r7)
            androidx.compose.foundation.layout.Arrangement$Vertical r6 = (androidx.compose.foundation.layout.Arrangement.Vertical) r6
            goto L_0x01e0
        L_0x01df:
            r6 = r14
        L_0x01e0:
            if (r18 == 0) goto L_0x01ea
            r7 = 0
            r8 = 0
            float r14 = (float) r7
            float r7 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r14)
            goto L_0x01ec
        L_0x01ea:
            r7 = r35
        L_0x01ec:
            r8 = r10 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x01fc
            androidx.compose.foundation.gestures.ScrollableDefaults r8 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r14 = 6
            androidx.compose.foundation.gestures.FlingBehavior r8 = r8.flingBehavior(r9, r14)
            r14 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r14
            goto L_0x01fe
        L_0x01fc:
            r8 = r36
        L_0x01fe:
            if (r0 == 0) goto L_0x0202
            r0 = 1
            goto L_0x0204
        L_0x0202:
            r0 = r37
        L_0x0204:
            r9.endDefaults()
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x0216
            r14 = -1
            java.lang.String r15 = "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:143)"
            r10 = -8666074(0xffffffffff7bc426, float:-3.3465469E38)
            androidx.compose.runtime.ComposerKt.traceEventStart(r10, r1, r14, r15)
        L_0x0216:
            androidx.compose.foundation.gestures.Orientation r15 = androidx.compose.foundation.gestures.Orientation.Horizontal
            float r10 = r6.m699getSpacingD9Ej5fM()
            r14 = r1 & 14
            int r16 = r1 >> 12
            r16 = r16 & 112(0x70, float:1.57E-43)
            r14 = r14 | r16
            int r11 = r1 >> 3
            r11 = r11 & 896(0x380, float:1.256E-42)
            r11 = r11 | r14
            kotlin.jvm.functions.Function2 r16 = rememberRowHeightSums(r13, r6, r4, r9, r11)
            int r11 = r1 << 6
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | 56
            int r14 = r1 << 3
            r18 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r18
            r11 = r11 | r14
            int r14 = r1 << 3
            r14 = r14 & r17
            r11 = r11 | r14
            int r14 = r1 >> 3
            r14 = r14 & r19
            r11 = r11 | r14
            int r14 = r1 >> 3
            r14 = r14 & r21
            r11 = r11 | r14
            int r14 = r1 << 6
            r14 = r14 & r23
            r26 = r11 | r14
            int r11 = r1 >> 27
            r27 = r11 & 14
            r28 = 0
            r14 = r3
            r17 = r2
            r18 = r4
            r19 = r5
            r20 = r8
            r21 = r0
            r22 = r7
            r23 = r10
            r24 = r38
            r25 = r9
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt.m1042LazyStaggeredGridLJWHXA8(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x027f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x027f:
            r21 = r0
            r22 = r1
            r14 = r2
            r15 = r3
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
        L_0x028f:
            androidx.compose.runtime.ScopeUpdateScope r11 = r9.endRestartGroup()
            if (r11 != 0) goto L_0x0298
            r24 = r9
            goto L_0x02bf
        L_0x0298:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1 r23 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1
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
            r10 = r38
            r13 = r11
            r11 = r40
            r12 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r23
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x02bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.m1036LazyHorizontalStaggeredGridcJHQLPU(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, float, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Function2<Density, Constraints, int[]> rememberRowHeightSums(StaggeredGridCells rows, Arrangement.Vertical verticalArrangement, PaddingValues contentPadding, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(-1665208491);
        ComposerKt.sourceInformation($composer, "C(rememberRowHeightSums)P(1,2)177@7800L860:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1665208491, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberRowHeightSums (LazyStaggeredGridDsl.kt:173)");
        }
        int i = ($changed & 14) | ($changed & 112) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) rows) | $composer.changed((Object) verticalArrangement) | $composer.changed((Object) contentPadding);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function2) new LazyStaggeredGridDslKt$rememberRowHeightSums$1$1(contentPadding, rows, verticalArrangement);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function2<Density, Constraints, int[]> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope $this$items_u24default, List items, Function1 key, Function1 contentType, Function1 span, Function4 itemContent, int i, Object obj) {
        Function1 function1;
        Function1 function12;
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            contentType = LazyStaggeredGridDslKt$items$1.INSTANCE;
        }
        if ((i & 8) != 0) {
            span = null;
        }
        Intrinsics.checkNotNullParameter($this$items_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (key != null) {
            Function1 function13 = key;
            function1 = new LazyStaggeredGridDslKt$items$2$1(key, items);
        } else {
            function1 = null;
        }
        Function1 lazyStaggeredGridDslKt$items$3 = new LazyStaggeredGridDslKt$items$3(contentType, items);
        if (span != null) {
            Function1 function14 = span;
            function12 = new LazyStaggeredGridDslKt$items$4$1(span, items);
        } else {
            function12 = null;
        }
        $this$items_u24default.items(size, function1, lazyStaggeredGridDslKt$items$3, function12, ComposableLambdaKt.composableLambdaInstance(-886456479, true, new LazyStaggeredGridDslKt$items$5(itemContent, items)));
    }

    public static final <T> void items(LazyStaggeredGridScope $this$items, List<? extends T> items, Function1<? super T, ? extends Object> key, Function1<? super T, ? extends Object> contentType, Function1<? super T, StaggeredGridItemSpan> span, Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Function1 it;
        Function1 function1;
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (key != null) {
            Function1<? super T, ? extends Object> function12 = key;
            it = new LazyStaggeredGridDslKt$items$2$1(key, items);
        } else {
            it = null;
        }
        Function1 lazyStaggeredGridDslKt$items$3 = new LazyStaggeredGridDslKt$items$3(contentType, items);
        if (span != null) {
            Function1<? super T, StaggeredGridItemSpan> function13 = span;
            function1 = new LazyStaggeredGridDslKt$items$4$1(span, items);
        } else {
            function1 = null;
        }
        $this$items.items(size, it, lazyStaggeredGridDslKt$items$3, function1, ComposableLambdaKt.composableLambdaInstance(-886456479, true, new LazyStaggeredGridDslKt$items$5(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope $this$itemsIndexed_u24default, List items, Function2 key, Function2 contentType, Function2 span, Function5 itemContent, int i, Object obj) {
        Function1 function1;
        Function1 function12;
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            contentType = LazyStaggeredGridDslKt$itemsIndexed$1.INSTANCE;
        }
        if ((i & 8) != 0) {
            span = null;
        }
        Intrinsics.checkNotNullParameter($this$itemsIndexed_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (key != null) {
            Function2 function2 = key;
            function1 = new LazyStaggeredGridDslKt$itemsIndexed$2$1(key, items);
        } else {
            function1 = null;
        }
        Function1 lazyStaggeredGridDslKt$itemsIndexed$3 = new LazyStaggeredGridDslKt$itemsIndexed$3(contentType, items);
        if (span != null) {
            Function2 function22 = span;
            function12 = new LazyStaggeredGridDslKt$itemsIndexed$4$1(span, items);
        } else {
            function12 = null;
        }
        $this$itemsIndexed_u24default.items(size, function1, lazyStaggeredGridDslKt$itemsIndexed$3, function12, ComposableLambdaKt.composableLambdaInstance(284833944, true, new LazyStaggeredGridDslKt$itemsIndexed$5(itemContent, items)));
    }

    public static final <T> void itemsIndexed(LazyStaggeredGridScope $this$itemsIndexed, List<? extends T> items, Function2<? super Integer, ? super T, ? extends Object> key, Function2<? super Integer, ? super T, ? extends Object> contentType, Function2<? super Integer, ? super T, StaggeredGridItemSpan> span, Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Function1 function1;
        Function1 function12;
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (key != null) {
            Function2<? super Integer, ? super T, ? extends Object> function2 = key;
            function1 = new LazyStaggeredGridDslKt$itemsIndexed$2$1(key, items);
        } else {
            function1 = null;
        }
        Function1 lazyStaggeredGridDslKt$itemsIndexed$3 = new LazyStaggeredGridDslKt$itemsIndexed$3(contentType, items);
        if (span != null) {
            Function2<? super Integer, ? super T, StaggeredGridItemSpan> function22 = span;
            function12 = new LazyStaggeredGridDslKt$itemsIndexed$4$1(span, items);
        } else {
            function12 = null;
        }
        $this$itemsIndexed.items(size, function1, lazyStaggeredGridDslKt$itemsIndexed$3, function12, ComposableLambdaKt.composableLambdaInstance(284833944, true, new LazyStaggeredGridDslKt$itemsIndexed$5(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope $this$items_u24default, Object[] items, Function1 key, Function1 contentType, Function1 span, Function4 itemContent, int i, Object obj) {
        Function1 function1;
        Function1 function12;
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            contentType = LazyStaggeredGridDslKt$items$6.INSTANCE;
        }
        if ((i & 8) != 0) {
            span = null;
        }
        Intrinsics.checkNotNullParameter($this$items_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (key != null) {
            Function1 function13 = key;
            function1 = new LazyStaggeredGridDslKt$items$7$1(key, items);
        } else {
            function1 = null;
        }
        Function1 lazyStaggeredGridDslKt$items$8 = new LazyStaggeredGridDslKt$items$8(contentType, items);
        if (span != null) {
            Function1 function14 = span;
            function12 = new LazyStaggeredGridDslKt$items$9$1(span, items);
        } else {
            function12 = null;
        }
        $this$items_u24default.items(length, function1, lazyStaggeredGridDslKt$items$8, function12, ComposableLambdaKt.composableLambdaInstance(2101296000, true, new LazyStaggeredGridDslKt$items$10(itemContent, items)));
    }

    public static final <T> void items(LazyStaggeredGridScope $this$items, T[] items, Function1<? super T, ? extends Object> key, Function1<? super T, ? extends Object> contentType, Function1<? super T, StaggeredGridItemSpan> span, Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Function1 it;
        Function1 function1;
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (key != null) {
            Function1<? super T, ? extends Object> function12 = key;
            it = new LazyStaggeredGridDslKt$items$7$1(key, items);
        } else {
            it = null;
        }
        Function1 lazyStaggeredGridDslKt$items$8 = new LazyStaggeredGridDslKt$items$8(contentType, items);
        if (span != null) {
            Function1<? super T, StaggeredGridItemSpan> function13 = span;
            function1 = new LazyStaggeredGridDslKt$items$9$1(span, items);
        } else {
            function1 = null;
        }
        $this$items.items(length, it, lazyStaggeredGridDslKt$items$8, function1, ComposableLambdaKt.composableLambdaInstance(2101296000, true, new LazyStaggeredGridDslKt$items$10(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope $this$itemsIndexed_u24default, Object[] items, Function2 key, Function2 contentType, Function2 span, Function5 itemContent, int i, Object obj) {
        Function1 function1;
        Function1 function12;
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            contentType = LazyStaggeredGridDslKt$itemsIndexed$6.INSTANCE;
        }
        if ((i & 8) != 0) {
            span = null;
        }
        Intrinsics.checkNotNullParameter($this$itemsIndexed_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (key != null) {
            Function2 function2 = key;
            function1 = new LazyStaggeredGridDslKt$itemsIndexed$7$1(key, items);
        } else {
            function1 = null;
        }
        Function1 lazyStaggeredGridDslKt$itemsIndexed$8 = new LazyStaggeredGridDslKt$itemsIndexed$8(contentType, items);
        if (span != null) {
            Function2 function22 = span;
            function12 = new LazyStaggeredGridDslKt$itemsIndexed$9$1(span, items);
        } else {
            function12 = null;
        }
        $this$itemsIndexed_u24default.items(length, function1, lazyStaggeredGridDslKt$itemsIndexed$8, function12, ComposableLambdaKt.composableLambdaInstance(-804487775, true, new LazyStaggeredGridDslKt$itemsIndexed$10(itemContent, items)));
    }

    public static final <T> void itemsIndexed(LazyStaggeredGridScope $this$itemsIndexed, T[] items, Function2<? super Integer, ? super T, ? extends Object> key, Function2<? super Integer, ? super T, ? extends Object> contentType, Function2<? super Integer, ? super T, StaggeredGridItemSpan> span, Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Function1 function1;
        Function1 function12;
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (key != null) {
            Function2<? super Integer, ? super T, ? extends Object> function2 = key;
            function1 = new LazyStaggeredGridDslKt$itemsIndexed$7$1(key, items);
        } else {
            function1 = null;
        }
        Function1 lazyStaggeredGridDslKt$itemsIndexed$8 = new LazyStaggeredGridDslKt$itemsIndexed$8(contentType, items);
        if (span != null) {
            Function2<? super Integer, ? super T, StaggeredGridItemSpan> function22 = span;
            function12 = new LazyStaggeredGridDslKt$itemsIndexed$9$1(span, items);
        } else {
            function12 = null;
        }
        $this$itemsIndexed.items(length, function1, lazyStaggeredGridDslKt$itemsIndexed$8, function12, ComposableLambdaKt.composableLambdaInstance(-804487775, true, new LazyStaggeredGridDslKt$itemsIndexed$10(itemContent, items)));
    }
}
