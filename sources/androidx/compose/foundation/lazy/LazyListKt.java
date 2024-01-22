package androidx.compose.foundation.lazy;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u001bH\u0001¢\u0006\u0002\u0010\u001c\u001a\u001d\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010 \u001a\u0001\u0010!\u001a\u0019\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0\"¢\u0006\u0002\b\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010(\u001a\u00020)H\u0003ø\u0001\u0000¢\u0006\u0002\u0010*\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "beyondBoundsItemCount", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "(Landroidx/compose/foundation/lazy/LazyListItemProvider;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)V", "rememberLazyListMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "placementAnimator", "Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "(Landroidx/compose/foundation/lazy/LazyListItemProvider;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;Landroidx/compose/foundation/layout/PaddingValues;ZZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;Landroidx/compose/runtime/Composer;III)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyList.kt */
public final class LazyListKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v68, resolved type: androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03b3  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x047c  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0489  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0490  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x014d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyList(androidx.compose.ui.Modifier r41, androidx.compose.foundation.lazy.LazyListState r42, androidx.compose.foundation.layout.PaddingValues r43, boolean r44, boolean r45, androidx.compose.foundation.gestures.FlingBehavior r46, boolean r47, int r48, androidx.compose.ui.Alignment.Horizontal r49, androidx.compose.foundation.layout.Arrangement.Vertical r50, androidx.compose.ui.Alignment.Vertical r51, androidx.compose.foundation.layout.Arrangement.Horizontal r52, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r53, androidx.compose.runtime.Composer r54, int r55, int r56, int r57) {
        /*
            r15 = r41
            r14 = r42
            r13 = r43
            r12 = r44
            r11 = r45
            r10 = r46
            r9 = r53
            r8 = r55
            r7 = r56
            r6 = r57
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "contentPadding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "flingBehavior"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 620764179(0x25001c13, float:1.1111742E-16)
            r1 = r54
            androidx.compose.runtime.Composer r5 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LazyList)P(7,9,2,8,6,3,10!1,4,12,11,5)77@3628L18,78@3670L44,79@3739L48,80@3815L39,81@3871L24,82@3924L92,87@4090L340,102@4436L42,109@4716L265,117@5045L81,122@5350L7,105@4571L1258:LazyList.kt#428nma"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r1)
            r1 = r55
            r2 = r56
            r3 = r6 & 1
            r16 = 2
            if (r3 == 0) goto L_0x004a
            r1 = r1 | 6
            goto L_0x0059
        L_0x004a:
            r3 = r8 & 14
            if (r3 != 0) goto L_0x0059
            boolean r3 = r5.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x0056
            r3 = 4
            goto L_0x0058
        L_0x0056:
            r3 = r16
        L_0x0058:
            r1 = r1 | r3
        L_0x0059:
            r3 = r6 & 2
            r17 = 32
            r18 = 16
            if (r3 == 0) goto L_0x0064
            r1 = r1 | 48
            goto L_0x0074
        L_0x0064:
            r3 = r8 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0074
            boolean r3 = r5.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x0071
            r3 = r17
            goto L_0x0073
        L_0x0071:
            r3 = r18
        L_0x0073:
            r1 = r1 | r3
        L_0x0074:
            r3 = r6 & 4
            r19 = 256(0x100, float:3.59E-43)
            r20 = 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x007f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x008f
        L_0x007f:
            r3 = r8 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x008f
            boolean r3 = r5.changed((java.lang.Object) r13)
            if (r3 == 0) goto L_0x008c
            r3 = r19
            goto L_0x008e
        L_0x008c:
            r3 = r20
        L_0x008e:
            r1 = r1 | r3
        L_0x008f:
            r3 = r6 & 8
            if (r3 == 0) goto L_0x0096
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x00a6
        L_0x0096:
            r3 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x00a6
            boolean r3 = r5.changed((boolean) r12)
            if (r3 == 0) goto L_0x00a3
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x00a5
        L_0x00a3:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x00a5:
            r1 = r1 | r3
        L_0x00a6:
            r3 = r6 & 16
            r32 = 57344(0xe000, float:8.0356E-41)
            if (r3 == 0) goto L_0x00b0
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00c0
        L_0x00b0:
            r3 = r8 & r32
            if (r3 != 0) goto L_0x00c0
            boolean r3 = r5.changed((boolean) r11)
            if (r3 == 0) goto L_0x00bd
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00bf
        L_0x00bd:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x00bf:
            r1 = r1 | r3
        L_0x00c0:
            r3 = r6 & 32
            r33 = 458752(0x70000, float:6.42848E-40)
            if (r3 == 0) goto L_0x00ca
            r3 = 196608(0x30000, float:2.75506E-40)
        L_0x00c8:
            r1 = r1 | r3
            goto L_0x00da
        L_0x00ca:
            r3 = r8 & r33
            if (r3 != 0) goto L_0x00da
            boolean r3 = r5.changed((java.lang.Object) r10)
            if (r3 == 0) goto L_0x00d7
            r3 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c8
        L_0x00d7:
            r3 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00c8
        L_0x00da:
            r3 = r6 & 64
            r21 = 3670016(0x380000, float:5.142788E-39)
            if (r3 == 0) goto L_0x00e6
            r3 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r3
            r3 = r47
            goto L_0x00fc
        L_0x00e6:
            r3 = r8 & r21
            if (r3 != 0) goto L_0x00fa
            r3 = r47
            boolean r22 = r5.changed((boolean) r3)
            if (r22 == 0) goto L_0x00f5
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00f7
        L_0x00f5:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x00f7:
            r1 = r1 | r22
            goto L_0x00fc
        L_0x00fa:
            r3 = r47
        L_0x00fc:
            r4 = r6 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0107
            r22 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r22
            r0 = r48
            goto L_0x011f
        L_0x0107:
            r22 = 29360128(0x1c00000, float:7.052966E-38)
            r22 = r8 & r22
            if (r22 != 0) goto L_0x011d
            r0 = r48
            boolean r23 = r5.changed((int) r0)
            if (r23 == 0) goto L_0x0118
            r23 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x011a
        L_0x0118:
            r23 = 4194304(0x400000, float:5.877472E-39)
        L_0x011a:
            r1 = r1 | r23
            goto L_0x011f
        L_0x011d:
            r0 = r48
        L_0x011f:
            r0 = r6 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x012a
            r23 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r23
            r3 = r49
            goto L_0x0142
        L_0x012a:
            r23 = 234881024(0xe000000, float:1.5777218E-30)
            r23 = r8 & r23
            if (r23 != 0) goto L_0x0140
            r3 = r49
            boolean r23 = r5.changed((java.lang.Object) r3)
            if (r23 == 0) goto L_0x013b
            r23 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x013d
        L_0x013b:
            r23 = 33554432(0x2000000, float:9.403955E-38)
        L_0x013d:
            r1 = r1 | r23
            goto L_0x0142
        L_0x0140:
            r3 = r49
        L_0x0142:
            r3 = r6 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x014d
            r23 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r23
            r8 = r50
            goto L_0x0165
        L_0x014d:
            r23 = 1879048192(0x70000000, float:1.58456325E29)
            r23 = r8 & r23
            if (r23 != 0) goto L_0x0163
            r8 = r50
            boolean r23 = r5.changed((java.lang.Object) r8)
            if (r23 == 0) goto L_0x015e
            r23 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0160
        L_0x015e:
            r23 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0160:
            r1 = r1 | r23
            goto L_0x0165
        L_0x0163:
            r8 = r50
        L_0x0165:
            r8 = r6 & 1024(0x400, float:1.435E-42)
            if (r8 == 0) goto L_0x016e
            r2 = r2 | 6
            r10 = r51
            goto L_0x0181
        L_0x016e:
            r23 = r7 & 14
            if (r23 != 0) goto L_0x017f
            r10 = r51
            boolean r23 = r5.changed((java.lang.Object) r10)
            if (r23 == 0) goto L_0x017c
            r16 = 4
        L_0x017c:
            r2 = r2 | r16
            goto L_0x0181
        L_0x017f:
            r10 = r51
        L_0x0181:
            r10 = r6 & 2048(0x800, float:2.87E-42)
            if (r10 == 0) goto L_0x018a
            r2 = r2 | 48
            r13 = r52
            goto L_0x019e
        L_0x018a:
            r16 = r7 & 112(0x70, float:1.57E-43)
            if (r16 != 0) goto L_0x019c
            r13 = r52
            boolean r16 = r5.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x0197
            goto L_0x0199
        L_0x0197:
            r17 = r18
        L_0x0199:
            r2 = r2 | r17
            goto L_0x019e
        L_0x019c:
            r13 = r52
        L_0x019e:
            r13 = r6 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x01a5
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x01b4
        L_0x01a5:
            r13 = r7 & 896(0x380, float:1.256E-42)
            if (r13 != 0) goto L_0x01b4
            boolean r13 = r5.changedInstance(r9)
            if (r13 == 0) goto L_0x01b0
            goto L_0x01b2
        L_0x01b0:
            r19 = r20
        L_0x01b2:
            r2 = r2 | r19
        L_0x01b4:
            r13 = r2
            r2 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r2 = r2 & r1
            r6 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r6) goto L_0x01dd
            r2 = r13 & 731(0x2db, float:1.024E-42)
            r6 = 146(0x92, float:2.05E-43)
            if (r2 != r6) goto L_0x01dd
            boolean r2 = r5.getSkipping()
            if (r2 != 0) goto L_0x01cb
            goto L_0x01dd
        L_0x01cb:
            r5.skipToGroupEnd()
            r34 = r48
            r35 = r49
            r36 = r50
            r17 = r51
            r18 = r52
            r49 = r1
            r15 = r5
            goto L_0x0483
        L_0x01dd:
            if (r4 == 0) goto L_0x01e3
            r2 = 0
            r34 = r2
            goto L_0x01e5
        L_0x01e3:
            r34 = r48
        L_0x01e5:
            if (r0 == 0) goto L_0x01eb
            r0 = 0
            r35 = r0
            goto L_0x01ed
        L_0x01eb:
            r35 = r49
        L_0x01ed:
            if (r3 == 0) goto L_0x01f3
            r0 = 0
            r36 = r0
            goto L_0x01f5
        L_0x01f3:
            r36 = r50
        L_0x01f5:
            if (r8 == 0) goto L_0x01fa
            r0 = 0
            r8 = r0
            goto L_0x01fc
        L_0x01fa:
            r8 = r51
        L_0x01fc:
            if (r10 == 0) goto L_0x0201
            r0 = 0
            r10 = r0
            goto L_0x0203
        L_0x0201:
            r10 = r52
        L_0x0203:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0211
            java.lang.String r0 = "androidx.compose.foundation.lazy.LazyList (LazyList.kt:49)"
            r2 = 620764179(0x25001c13, float:1.1111742E-16)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r13, r0)
        L_0x0211:
            androidx.compose.foundation.gestures.ScrollableDefaults r0 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r6 = 6
            androidx.compose.foundation.OverscrollEffect r4 = r0.overscrollEffect(r5, r6)
            int r0 = r1 >> 3
            r0 = r0 & 14
            int r2 = r13 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            androidx.compose.foundation.lazy.LazyListItemProvider r3 = androidx.compose.foundation.lazy.LazyListItemProviderKt.rememberLazyListItemProvider(r14, r9, r5, r0)
            int r0 = r1 >> 3
            r0 = r0 & 14
            int r2 = r1 >> 9
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState r37 = androidx.compose.foundation.lazy.LazyListSemanticsKt.rememberLazyListSemanticState(r14, r11, r5, r0)
            r0 = 0
            r2 = r0
            r16 = 0
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r5.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            r6 = 0
            r49 = r5
            r17 = 0
            java.lang.Object r0 = r49.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r51 = r2
            java.lang.Object r2 = r19.getEmpty()
            if (r0 != r2) goto L_0x0267
            r2 = 0
            androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo r19 = new androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo
            r19.<init>()
            r2 = r19
            r52 = r0
            r0 = r49
            r0.updateRememberedValue(r2)
            goto L_0x026d
        L_0x0267:
            r52 = r0
            r0 = r49
            r2 = r52
        L_0x026d:
            r5.endReplaceableGroup()
            r38 = r2
            androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo r38 = (androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo) r38
            r0 = 0
            r2 = r0
            r6 = 0
            r0 = 773894976(0x2e20b340, float:3.6538994E-11)
            r5.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r0)
            r0 = r5
            r16 = 0
            r17 = 0
            r49 = r2
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r5.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            r2 = 0
            r50 = r5
            r18 = 0
            r51 = r2
            java.lang.Object r2 = r50.rememberedValue()
            r19 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r52 = r4
            java.lang.Object r4 = r20.getEmpty()
            if (r2 != r4) goto L_0x02cd
            r4 = 0
            r20 = 0
            kotlin.coroutines.EmptyCoroutineContext r20 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r54 = r2
            r2 = r20
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            kotlinx.coroutines.CoroutineScope r2 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r2, r0)
            r20 = r0
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r0.<init>(r2)
            r2 = r50
            r2.updateRememberedValue(r0)
            goto L_0x02d5
        L_0x02cd:
            r20 = r0
            r54 = r2
            r2 = r50
            r0 = r54
        L_0x02d5:
            r5.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r2 = r0.getCoroutineScope()
            r5.endReplaceableGroup()
            r6 = r2
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r45)
            int r2 = r1 >> 3
            r2 = r2 & 14
            int r4 = r1 >> 9
            r4 = r4 & 112(0x70, float:1.57E-43)
            r2 = r2 | r4
            r4 = 0
            r49 = r2
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r5.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            boolean r2 = r5.changed((java.lang.Object) r14)
            boolean r16 = r5.changed((java.lang.Object) r0)
            r2 = r2 | r16
            r50 = r5
            r16 = 0
            r51 = r0
            java.lang.Object r0 = r50.rememberedValue()
            r17 = 0
            if (r2 != 0) goto L_0x0329
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r54 = r2
            java.lang.Object r2 = r18.getEmpty()
            if (r0 != r2) goto L_0x0324
            goto L_0x032b
        L_0x0324:
            r2 = r50
            r18 = r0
            goto L_0x033a
        L_0x0329:
            r54 = r2
        L_0x032b:
            r2 = 0
            r18 = r0
            androidx.compose.foundation.lazy.LazyListItemPlacementAnimator r0 = new androidx.compose.foundation.lazy.LazyListItemPlacementAnimator
            r0.<init>(r6, r11)
            r2 = r50
            r2.updateRememberedValue(r0)
        L_0x033a:
            r5.endReplaceableGroup()
            r4 = r0
            androidx.compose.foundation.lazy.LazyListItemPlacementAnimator r4 = (androidx.compose.foundation.lazy.LazyListItemPlacementAnimator) r4
            r14.setPlacementAnimator$foundation_release(r4)
            r0 = r1 & 112(0x70, float:1.57E-43)
            int r2 = androidx.compose.runtime.collection.MutableVector.$stable
            r39 = 6
            int r2 = r2 << 6
            r0 = r0 | r2
            int r2 = r1 << 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r1 << 3
            r2 = r2 & r32
            r0 = r0 | r2
            int r2 = r1 << 3
            r2 = r2 & r33
            r0 = r0 | r2
            int r2 = r1 >> 3
            r2 = r2 & r21
            r0 = r0 | r2
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            int r16 = r1 >> 3
            r2 = r16 & r2
            r0 = r0 | r2
            int r2 = r13 << 24
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r16
            r0 = r0 | r2
            int r2 = r13 << 24
            r16 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r16
            r29 = r0 | r2
            int r0 = r1 >> 27
            r0 = r0 & 14
            r30 = r0 | 64
            r31 = 0
            r16 = r3
            r17 = r42
            r18 = r38
            r19 = r43
            r20 = r44
            r21 = r45
            r22 = r34
            r23 = r35
            r24 = r8
            r25 = r10
            r26 = r36
            r27 = r4
            r28 = r5
            kotlin.jvm.functions.Function2 r16 = rememberLazyListMeasurePolicy(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            r0 = r1 & 112(0x70, float:1.57E-43)
            ScrollPositionUpdater(r3, r14, r5, r0)
            if (r11 == 0) goto L_0x03b3
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x03b5
        L_0x03b3:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x03b5:
            r2 = r0
            androidx.compose.ui.layout.RemeasurementModifier r0 = r42.getRemeasurementModifier$foundation_release()
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Modifier r0 = r15.then(r0)
            androidx.compose.foundation.lazy.AwaitFirstLayoutModifier r17 = r42.getAwaitLayoutModifier$foundation_release()
            r48 = r2
            r2 = r17
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Modifier r0 = r0.then(r2)
            r2 = r3
            androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider r2 = (androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider) r2
            int r17 = r1 >> 6
            r17 = r17 & r32
            int r18 = r1 << 6
            r18 = r18 & r33
            r17 = r17 | r18
            r15 = r1
            r1 = r2
            r49 = r48
            r2 = r37
            r18 = r3
            r3 = r49
            r19 = r4
            r48 = r8
            r8 = r52
            r4 = r47
            r50 = r5
            r5 = r44
            r20 = r6
            r21 = r39
            r6 = r50
            r7 = r17
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt.lazyLayoutSemantics(r0, r1, r2, r3, r4, r5, r6, r7)
            r7 = r49
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ClipScrollableContainerKt.clipScrollableContainer(r0, r7)
            r1 = r15 & 112(0x70, float:1.57E-43)
            int r2 = androidx.compose.runtime.collection.MutableVector.$stable
            int r2 = r2 << 6
            r1 = r1 | r2
            r2 = r15 & 7168(0x1c00, float:1.0045E-41)
            r6 = r1 | r2
            r1 = r42
            r2 = r38
            r3 = r44
            r4 = r7
            r5 = r50
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.OverscrollKt.overscroll(r0, r8)
            androidx.compose.foundation.gestures.ScrollableDefaults r1 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 0
            r4 = 0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            r49 = r15
            r15 = r50
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r5, r6)
            java.lang.Object r5 = r15.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            boolean r5 = r1.reverseDirection(r5, r7, r12)
            androidx.compose.foundation.interaction.MutableInteractionSource r17 = r42.getInternalInteractionSource$foundation_release()
            r1 = r14
            androidx.compose.foundation.gestures.ScrollableState r1 = (androidx.compose.foundation.gestures.ScrollableState) r1
            r2 = r7
            r3 = r8
            r4 = r47
            r6 = r46
            r21 = r7
            r7 = r17
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.gestures.ScrollableKt.scrollable(r0, r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r3 = r42.getPrefetchState$foundation_release()
            r1 = r18
            androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider r1 = (androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider) r1
            r6 = 0
            r7 = 0
            r4 = r16
            r5 = r15
            androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x047f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x047f:
            r17 = r48
            r18 = r10
        L_0x0483:
            androidx.compose.runtime.ScopeUpdateScope r10 = r15.endRestartGroup()
            if (r10 != 0) goto L_0x0490
            r22 = r49
            r20 = r13
            r21 = r15
            goto L_0x04c8
        L_0x0490:
            androidx.compose.foundation.lazy.LazyListKt$LazyList$1 r19 = new androidx.compose.foundation.lazy.LazyListKt$LazyList$1
            r0 = r19
            r1 = r41
            r2 = r42
            r3 = r43
            r4 = r44
            r5 = r45
            r6 = r46
            r7 = r47
            r8 = r34
            r9 = r35
            r40 = r10
            r10 = r36
            r11 = r17
            r12 = r18
            r20 = r13
            r13 = r53
            r14 = r55
            r22 = r49
            r21 = r15
            r15 = r56
            r16 = r57
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r0 = r19
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r40
            r1.updateScope(r0)
        L_0x04c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListKt.LazyList(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, int, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void ScrollPositionUpdater(LazyListItemProvider itemProvider, LazyListState state, Composer $composer, int $changed) {
        Composer $composer2 = $composer.startRestartGroup(3173830);
        ComposerKt.sourceInformation($composer2, "C(ScrollPositionUpdater):LazyList.kt#428nma");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) itemProvider) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed((Object) state) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(3173830, $changed, -1, "androidx.compose.foundation.lazy.ScrollPositionUpdater (LazyList.kt:141)");
            }
            if (itemProvider.getItemCount() > 0) {
                state.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(itemProvider);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyListKt$ScrollPositionUpdater$1(itemProvider, state, $changed));
        }
    }

    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy(LazyListItemProvider itemProvider, LazyListState state, LazyListBeyondBoundsInfo beyondBoundsInfo, PaddingValues contentPadding, boolean reverseLayout, boolean isVertical, int beyondBoundsItemCount, Alignment.Horizontal horizontalAlignment, Alignment.Vertical verticalAlignment, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, LazyListItemPlacementAnimator placementAnimator, Composer $composer, int $changed, int $changed1, int i) {
        Alignment.Vertical verticalAlignment2;
        Arrangement.Horizontal horizontalArrangement2;
        Arrangement.Vertical verticalArrangement2;
        Composer composer = $composer;
        int i2 = i;
        composer.startReplaceableGroup(-966179815);
        ComposerKt.sourceInformation(composer, "C(rememberLazyListMeasurePolicy)P(6,9!1,2,8,5!2,10!1,11)177@7597L6680:LazyList.kt#428nma");
        Alignment.Horizontal horizontalAlignment2 = (i2 & 128) != 0 ? null : horizontalAlignment;
        if ((i2 & 256) != 0) {
            verticalAlignment2 = null;
        } else {
            verticalAlignment2 = verticalAlignment;
        }
        if ((i2 & 512) != 0) {
            horizontalArrangement2 = null;
        } else {
            horizontalArrangement2 = horizontalArrangement;
        }
        if ((i2 & 1024) != 0) {
            verticalArrangement2 = null;
        } else {
            verticalArrangement2 = verticalArrangement;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-966179815, $changed, $changed1, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:152)");
        } else {
            int i3 = $changed;
            int i4 = $changed1;
        }
        Object[] keys$iv = {state, beyondBoundsInfo, contentPadding, Boolean.valueOf(reverseLayout), Boolean.valueOf(isVertical), horizontalAlignment2, verticalAlignment2, horizontalArrangement2, verticalArrangement2, placementAnimator};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= composer.changed(key$iv);
        }
        Composer $this$cache$iv$iv = $composer;
        Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv || value$iv$iv == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv;
            value$iv$iv = new LazyListKt$rememberLazyListMeasurePolicy$1$1(isVertical, contentPadding, reverseLayout, state, itemProvider, verticalArrangement2, horizontalArrangement2, placementAnimator, beyondBoundsInfo, beyondBoundsItemCount, horizontalAlignment2, verticalAlignment2);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            Object obj2 = value$iv$iv;
            Composer composer2 = $this$cache$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }
}
