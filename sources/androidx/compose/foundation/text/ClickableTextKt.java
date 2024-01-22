package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001ay\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a!\u0010\u0017\u001a\u00020\f*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"ClickableText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "onHover", "Lkotlin/Function1;", "", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "onClick", "ClickableText-03UYbkw", "(Landroidx/compose/ui/text/AnnotatedString;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ClickableText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "containsWithinBounds", "Landroidx/compose/ui/text/MultiParagraph;", "positionOffset", "Landroidx/compose/ui/geometry/Offset;", "containsWithinBounds-Uv8p0NA", "(Landroidx/compose/ui/text/MultiParagraph;J)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ClickableText.kt */
public final class ClickableTextKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0139  */
    /* renamed from: ClickableText-4YKlhWE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1127ClickableText4YKlhWE(androidx.compose.ui.text.AnnotatedString r27, androidx.compose.ui.Modifier r28, androidx.compose.ui.text.TextStyle r29, boolean r30, int r31, int r32, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r33, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r12 = r27
            r13 = r34
            r14 = r36
            r15 = r37
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -246609449(0xfffffffff14d09d7, float:-1.0153012E30)
            r1 = r35
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ClickableText)P(7,1,6,5,4:c#ui.text.style.TextOverflow!1,3)79@3637L52,80@3746L184,95@4151L76,88@3936L297:ClickableText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r36
            r2 = r15 & 1
            if (r2 == 0) goto L_0x002b
            r1 = r1 | 6
            goto L_0x0039
        L_0x002b:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x0039
            boolean r2 = r11.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x0037
            r2 = 4
            goto L_0x0038
        L_0x0037:
            r2 = 2
        L_0x0038:
            r1 = r1 | r2
        L_0x0039:
            r2 = r15 & 2
            if (r2 == 0) goto L_0x0042
            r1 = r1 | 48
            r4 = r28
            goto L_0x0057
        L_0x0042:
            r4 = r14 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0055
            r4 = r28
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0051
            r5 = 32
            goto L_0x0053
        L_0x0051:
            r5 = 16
        L_0x0053:
            r1 = r1 | r5
            goto L_0x0057
        L_0x0055:
            r4 = r28
        L_0x0057:
            r5 = r15 & 4
            if (r5 == 0) goto L_0x0060
            r1 = r1 | 384(0x180, float:5.38E-43)
            r6 = r29
            goto L_0x0075
        L_0x0060:
            r6 = r14 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0073
            r6 = r29
            boolean r7 = r11.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x006f
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0071
        L_0x006f:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0071:
            r1 = r1 | r7
            goto L_0x0075
        L_0x0073:
            r6 = r29
        L_0x0075:
            r7 = r15 & 8
            if (r7 == 0) goto L_0x007e
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r8 = r30
            goto L_0x0093
        L_0x007e:
            r8 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0091
            r8 = r30
            boolean r9 = r11.changed((boolean) r8)
            if (r9 == 0) goto L_0x008d
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x008f
        L_0x008d:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x008f:
            r1 = r1 | r9
            goto L_0x0093
        L_0x0091:
            r8 = r30
        L_0x0093:
            r9 = r15 & 16
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x009f
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r10 = r31
            goto L_0x00b5
        L_0x009f:
            r16 = r14 & r10
            if (r16 != 0) goto L_0x00b3
            r10 = r31
            boolean r16 = r11.changed((int) r10)
            if (r16 == 0) goto L_0x00ae
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b0
        L_0x00ae:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00b0:
            r1 = r1 | r16
            goto L_0x00b5
        L_0x00b3:
            r10 = r31
        L_0x00b5:
            r16 = r15 & 32
            r17 = 458752(0x70000, float:6.42848E-40)
            if (r16 == 0) goto L_0x00c2
            r18 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r18
            r3 = r32
            goto L_0x00d8
        L_0x00c2:
            r18 = r14 & r17
            if (r18 != 0) goto L_0x00d6
            r3 = r32
            boolean r19 = r11.changed((int) r3)
            if (r19 == 0) goto L_0x00d1
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d3
        L_0x00d1:
            r19 = 65536(0x10000, float:9.18355E-41)
        L_0x00d3:
            r1 = r1 | r19
            goto L_0x00d8
        L_0x00d6:
            r3 = r32
        L_0x00d8:
            r19 = r15 & 64
            r20 = 3670016(0x380000, float:5.142788E-39)
            if (r19 == 0) goto L_0x00e5
            r21 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r21
            r0 = r33
            goto L_0x00fb
        L_0x00e5:
            r21 = r14 & r20
            if (r21 != 0) goto L_0x00f9
            r0 = r33
            boolean r22 = r11.changedInstance(r0)
            if (r22 == 0) goto L_0x00f4
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00f6
        L_0x00f4:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x00f6:
            r1 = r1 | r22
            goto L_0x00fb
        L_0x00f9:
            r0 = r33
        L_0x00fb:
            r0 = r15 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0103
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x0101:
            r1 = r1 | r0
            goto L_0x0114
        L_0x0103:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r14
            if (r0 != 0) goto L_0x0114
            boolean r0 = r11.changedInstance(r13)
            if (r0 == 0) goto L_0x0111
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0101
        L_0x0111:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x0101
        L_0x0114:
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r0 & r1
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x0139
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x0124
            goto L_0x0139
        L_0x0124:
            r11.skipToGroupEnd()
            r16 = r32
            r26 = r33
            r20 = r1
            r21 = r4
            r22 = r6
            r23 = r8
            r24 = r10
            r17 = r11
            goto L_0x02b2
        L_0x0139:
            if (r2 == 0) goto L_0x0140
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r4 = r0
        L_0x0140:
            if (r5 == 0) goto L_0x014b
            androidx.compose.ui.text.TextStyle$Companion r0 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r0 = r0.getDefault()
            r22 = r0
            goto L_0x014d
        L_0x014b:
            r22 = r6
        L_0x014d:
            if (r7 == 0) goto L_0x0153
            r0 = 1
            r23 = r0
            goto L_0x0155
        L_0x0153:
            r23 = r8
        L_0x0155:
            if (r9 == 0) goto L_0x0160
            androidx.compose.ui.text.style.TextOverflow$Companion r0 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r0 = r0.m5898getClipgIe3tQ8()
            r24 = r0
            goto L_0x0162
        L_0x0160:
            r24 = r10
        L_0x0162:
            if (r16 == 0) goto L_0x016a
            r0 = 2147483647(0x7fffffff, float:NaN)
            r16 = r0
            goto L_0x016c
        L_0x016a:
            r16 = r32
        L_0x016c:
            if (r19 == 0) goto L_0x0174
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$1 r0 = androidx.compose.foundation.text.ClickableTextKt$ClickableText$1.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r10 = r0
            goto L_0x0176
        L_0x0174:
            r10 = r33
        L_0x0176:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0185
            r0 = -1
            java.lang.String r2 = "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)"
            r3 = -246609449(0xfffffffff14d09d7, float:-1.0153012E30)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r0, r2)
        L_0x0185:
            r0 = 0
            r2 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
            r3 = 0
            r5 = r11
            r6 = 0
            java.lang.Object r7 = r5.rememberedValue()
            r8 = 0
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            r28 = r0
            r0 = 0
            if (r7 != r9) goto L_0x01b4
            r9 = 0
            r29 = r2
            r2 = 2
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r0, r2, r0)
            r5.updateRememberedValue(r2)
            goto L_0x01b7
        L_0x01b4:
            r29 = r2
            r2 = r7
        L_0x01b7:
            r11.endReplaceableGroup()
            r9 = r2
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            int r3 = r1 >> 18
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | 6
            r5 = 0
            r6 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r6)
            java.lang.String r7 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r7)
            boolean r8 = r11.changed((java.lang.Object) r9)
            boolean r18 = r11.changed((java.lang.Object) r13)
            r8 = r8 | r18
            r28 = r11
            r18 = 0
            java.lang.Object r6 = r28.rememberedValue()
            r19 = 0
            if (r8 != 0) goto L_0x01fa
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r21.getEmpty()
            if (r6 != r0) goto L_0x01f4
            goto L_0x01fa
        L_0x01f4:
            r32 = r3
            r0 = r6
            r3 = r28
            goto L_0x020e
        L_0x01fa:
            r0 = 0
            r31 = r0
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$pressIndicator$1$1 r0 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$pressIndicator$1$1
            r32 = r3
            r3 = 0
            r0.<init>(r9, r13, r3)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r3 = r28
            r3.updateRememberedValue(r0)
        L_0x020e:
            r11.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            androidx.compose.ui.Modifier r8 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput((androidx.compose.ui.Modifier) r2, (java.lang.Object) r13, (kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r0)
            androidx.compose.ui.Modifier r2 = r4.then(r8)
            int r0 = r1 >> 15
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | 6
            r3 = 0
            r5 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r7)
            boolean r5 = r11.changed((java.lang.Object) r9)
            boolean r6 = r11.changed((java.lang.Object) r10)
            r5 = r5 | r6
            r6 = r11
            r7 = 0
            r28 = r0
            java.lang.Object r0 = r6.rememberedValue()
            r18 = 0
            if (r5 != 0) goto L_0x0253
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r29 = r3
            java.lang.Object r3 = r19.getEmpty()
            if (r0 != r3) goto L_0x0250
            goto L_0x0255
        L_0x0250:
            r30 = r0
            goto L_0x0264
        L_0x0253:
            r29 = r3
        L_0x0255:
            r3 = 0
            r30 = r0
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1 r0 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
            r0.<init>(r9, r10)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r6.updateRememberedValue(r0)
        L_0x0264:
            r11.endReplaceableGroup()
            r3 = r0
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r7 = 0
            r18 = 0
            r0 = r1 & 14
            r5 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r5
            r5 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r1
            r0 = r0 | r5
            int r5 = r1 << 6
            r5 = r5 & r17
            r0 = r0 | r5
            int r5 = r1 << 3
            r5 = r5 & r20
            r17 = r0 | r5
            r19 = 384(0x180, float:5.38E-43)
            r0 = r27
            r20 = r1
            r1 = r2
            r2 = r22
            r21 = r4
            r4 = r24
            r5 = r23
            r6 = r16
            r25 = r8
            r8 = r18
            r18 = r9
            r9 = r11
            r26 = r10
            r10 = r17
            r17 = r11
            r11 = r19
            androidx.compose.foundation.text.BasicTextKt.m1125BasicTextVhcvRP8(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02b2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02b2:
            androidx.compose.runtime.ScopeUpdateScope r11 = r17.endRestartGroup()
            if (r11 != 0) goto L_0x02b9
            goto L_0x02db
        L_0x02b9:
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$3 r18 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$3
            r0 = r18
            r1 = r27
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r24
            r6 = r16
            r7 = r26
            r8 = r34
            r9 = r36
            r10 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x02db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.ClickableTextKt.m1127ClickableText4YKlhWE(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, boolean, int, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x030e  */
    /* JADX WARNING: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* renamed from: ClickableText-03UYbkw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1126ClickableText03UYbkw(androidx.compose.ui.text.AnnotatedString r28, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.ui.Modifier r30, androidx.compose.ui.text.TextStyle r31, boolean r32, int r33, int r34, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r35, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r12 = r28
            r13 = r29
            r14 = r36
            r15 = r38
            r11 = r39
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "onHover"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1020774372(0x3cd7c7e4, float:0.026340432)
            r1 = r37
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ClickableText)P(8,3,1,7,6,5:c#ui.text.style.TextOverflow!1,4)153@6860L52,154@6938L24,183@7878L76,176@7657L303:ClickableText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r38
            r2 = r11 & 1
            if (r2 == 0) goto L_0x0033
            r1 = r1 | 6
            goto L_0x0041
        L_0x0033:
            r2 = r15 & 14
            if (r2 != 0) goto L_0x0041
            boolean r2 = r10.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x003f
            r2 = 4
            goto L_0x0040
        L_0x003f:
            r2 = 2
        L_0x0040:
            r1 = r1 | r2
        L_0x0041:
            r2 = r11 & 2
            if (r2 == 0) goto L_0x0048
            r1 = r1 | 48
            goto L_0x0058
        L_0x0048:
            r2 = r15 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0058
            boolean r2 = r10.changedInstance(r13)
            if (r2 == 0) goto L_0x0055
            r2 = 32
            goto L_0x0057
        L_0x0055:
            r2 = 16
        L_0x0057:
            r1 = r1 | r2
        L_0x0058:
            r2 = r11 & 4
            if (r2 == 0) goto L_0x0061
            r1 = r1 | 384(0x180, float:5.38E-43)
            r4 = r30
            goto L_0x0076
        L_0x0061:
            r4 = r15 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0074
            r4 = r30
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0070
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0072
        L_0x0070:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0072:
            r1 = r1 | r5
            goto L_0x0076
        L_0x0074:
            r4 = r30
        L_0x0076:
            r5 = r11 & 8
            if (r5 == 0) goto L_0x007f
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r6 = r31
            goto L_0x0094
        L_0x007f:
            r6 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0092
            r6 = r31
            boolean r7 = r10.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x008e
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0090
        L_0x008e:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0090:
            r1 = r1 | r7
            goto L_0x0094
        L_0x0092:
            r6 = r31
        L_0x0094:
            r7 = r11 & 16
            r8 = 57344(0xe000, float:8.0356E-41)
            if (r7 == 0) goto L_0x00a0
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r9 = r32
            goto L_0x00b6
        L_0x00a0:
            r9 = r15 & r8
            if (r9 != 0) goto L_0x00b4
            r9 = r32
            boolean r16 = r10.changed((boolean) r9)
            if (r16 == 0) goto L_0x00af
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b1
        L_0x00af:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00b1:
            r1 = r1 | r16
            goto L_0x00b6
        L_0x00b4:
            r9 = r32
        L_0x00b6:
            r16 = r11 & 32
            r17 = 458752(0x70000, float:6.42848E-40)
            if (r16 == 0) goto L_0x00c3
            r18 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r18
            r8 = r33
            goto L_0x00d9
        L_0x00c3:
            r18 = r15 & r17
            if (r18 != 0) goto L_0x00d7
            r8 = r33
            boolean r18 = r10.changed((int) r8)
            if (r18 == 0) goto L_0x00d2
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d4
        L_0x00d2:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00d4:
            r1 = r1 | r18
            goto L_0x00d9
        L_0x00d7:
            r8 = r33
        L_0x00d9:
            r18 = r11 & 64
            r19 = 3670016(0x380000, float:5.142788E-39)
            if (r18 == 0) goto L_0x00e6
            r20 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r20
            r3 = r34
            goto L_0x00fc
        L_0x00e6:
            r20 = r15 & r19
            if (r20 != 0) goto L_0x00fa
            r3 = r34
            boolean r21 = r10.changed((int) r3)
            if (r21 == 0) goto L_0x00f5
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00f7
        L_0x00f5:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x00f7:
            r1 = r1 | r21
            goto L_0x00fc
        L_0x00fa:
            r3 = r34
        L_0x00fc:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0107
            r22 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r22
            r3 = r35
            goto L_0x011f
        L_0x0107:
            r22 = 29360128(0x1c00000, float:7.052966E-38)
            r22 = r15 & r22
            if (r22 != 0) goto L_0x011d
            r3 = r35
            boolean r22 = r10.changedInstance(r3)
            if (r22 == 0) goto L_0x0118
            r22 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x011a
        L_0x0118:
            r22 = 4194304(0x400000, float:5.877472E-39)
        L_0x011a:
            r1 = r1 | r22
            goto L_0x011f
        L_0x011d:
            r3 = r35
        L_0x011f:
            r3 = r11 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0127
            r3 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x0125:
            r1 = r1 | r3
            goto L_0x0138
        L_0x0127:
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r15
            if (r3 != 0) goto L_0x0138
            boolean r3 = r10.changedInstance(r14)
            if (r3 == 0) goto L_0x0135
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0125
        L_0x0135:
            r3 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x0125
        L_0x0138:
            r3 = r1
            r1 = 191739611(0xb6db6db, float:4.5782105E-32)
            r1 = r1 & r3
            r4 = 38347922(0x2492492, float:1.4777643E-37)
            if (r1 != r4) goto L_0x015e
            boolean r1 = r10.getSkipping()
            if (r1 != 0) goto L_0x0149
            goto L_0x015e
        L_0x0149:
            r10.skipToGroupEnd()
            r25 = r30
            r18 = r34
            r21 = r35
            r24 = r3
            r22 = r6
            r16 = r8
            r23 = r9
            r27 = r10
            goto L_0x0307
        L_0x015e:
            if (r2 == 0) goto L_0x0166
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r4 = r1
            goto L_0x0168
        L_0x0166:
            r4 = r30
        L_0x0168:
            if (r5 == 0) goto L_0x0173
            androidx.compose.ui.text.TextStyle$Companion r1 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r1 = r1.getDefault()
            r22 = r1
            goto L_0x0175
        L_0x0173:
            r22 = r6
        L_0x0175:
            if (r7 == 0) goto L_0x017b
            r1 = 1
            r23 = r1
            goto L_0x017d
        L_0x017b:
            r23 = r9
        L_0x017d:
            if (r16 == 0) goto L_0x0188
            androidx.compose.ui.text.style.TextOverflow$Companion r1 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r1 = r1.m5898getClipgIe3tQ8()
            r16 = r1
            goto L_0x018a
        L_0x0188:
            r16 = r8
        L_0x018a:
            if (r18 == 0) goto L_0x0192
            r1 = 2147483647(0x7fffffff, float:NaN)
            r18 = r1
            goto L_0x0194
        L_0x0192:
            r18 = r34
        L_0x0194:
            if (r0 == 0) goto L_0x019c
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$4 r0 = androidx.compose.foundation.text.ClickableTextKt$ClickableText$4.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r9 = r0
            goto L_0x019e
        L_0x019c:
            r9 = r35
        L_0x019e:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01ad
            r0 = -1
            java.lang.String r1 = "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)"
            r2 = 1020774372(0x3cd7c7e4, float:0.026340432)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r3, r0, r1)
        L_0x01ad:
            r0 = 0
            r1 = r0
            r2 = 0
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r5)
            java.lang.String r6 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r6)
            r7 = 0
            r8 = r10
            r21 = 0
            java.lang.Object r5 = r8.rememberedValue()
            r24 = 0
            androidx.compose.runtime.Composer$Companion r25 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r25.getEmpty()
            if (r5 != r0) goto L_0x01df
            r0 = 0
            r32 = r0
            r0 = 0
            r33 = r1
            r1 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r0, r1, r0)
            r8.updateRememberedValue(r0)
            goto L_0x01e2
        L_0x01df:
            r33 = r1
            r0 = r5
        L_0x01e2:
            r10.endReplaceableGroup()
            r8 = r0
            androidx.compose.runtime.MutableState r8 = (androidx.compose.runtime.MutableState) r8
            r0 = 0
            r1 = r0
            r2 = 0
            r5 = 773894976(0x2e20b340, float:3.6538994E-11)
            r10.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r5)
            r5 = r10
            r7 = 0
            r31 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r6)
            r0 = 0
            r6 = r10
            r20 = 0
            r30 = r0
            java.lang.Object r0 = r6.rememberedValue()
            r21 = 0
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r32 = r1
            java.lang.Object r1 = r24.getEmpty()
            if (r0 != r1) goto L_0x023a
            r1 = 0
            r24 = 0
            kotlin.coroutines.EmptyCoroutineContext r24 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r33 = r0
            r0 = r24
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r5)
            r34 = r1
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r0 = r1
            r6.updateRememberedValue(r0)
            goto L_0x023c
        L_0x023a:
            r33 = r0
        L_0x023c:
            r10.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r1 = r0.getCoroutineScope()
            r10.endReplaceableGroup()
            r31 = r1
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1 r1 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1
            r2 = 0
            r30 = r1
            r32 = r29
            r33 = r8
            r34 = r36
            r35 = r2
            r30.<init>(r31, r32, r33, r34, r35)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput(r0, r14, r13, r1)
            androidx.compose.ui.Modifier r1 = r4.then(r7)
            int r0 = r3 >> 18
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | 6
            r2 = 0
            r5 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r10.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r5)
            boolean r5 = r10.changed((java.lang.Object) r8)
            boolean r6 = r10.changed((java.lang.Object) r9)
            r5 = r5 | r6
            r6 = r10
            r20 = 0
            r30 = r0
            java.lang.Object r0 = r6.rememberedValue()
            r21 = 0
            if (r5 != 0) goto L_0x02a3
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r32 = r2
            java.lang.Object r2 = r24.getEmpty()
            if (r0 != r2) goto L_0x02a0
            goto L_0x02a5
        L_0x02a0:
            r33 = r0
            goto L_0x02b4
        L_0x02a3:
            r32 = r2
        L_0x02a5:
            r2 = 0
            r33 = r0
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$5$1 r0 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$5$1
            r0.<init>(r8, r9)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r6.updateRememberedValue(r0)
        L_0x02b4:
            r10.endReplaceableGroup()
            r5 = r0
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r20 = 0
            r21 = 0
            r0 = r3 & 14
            int r2 = r3 >> 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            int r2 = r3 >> 3
            r6 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r6
            r0 = r0 | r2
            int r2 = r3 << 3
            r2 = r2 & r17
            r0 = r0 | r2
            r2 = r3 & r19
            r17 = r0 | r2
            r19 = 384(0x180, float:5.38E-43)
            r0 = r28
            r2 = r22
            r24 = r3
            r3 = r5
            r25 = r4
            r4 = r16
            r5 = r23
            r6 = r18
            r26 = r7
            r7 = r20
            r20 = r8
            r8 = r21
            r21 = r9
            r9 = r10
            r27 = r10
            r10 = r17
            r11 = r19
            androidx.compose.foundation.text.BasicTextKt.m1125BasicTextVhcvRP8(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0307
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0307:
            androidx.compose.runtime.ScopeUpdateScope r11 = r27.endRestartGroup()
            if (r11 != 0) goto L_0x030e
            goto L_0x0333
        L_0x030e:
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$6 r17 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$6
            r0 = r17
            r1 = r28
            r2 = r29
            r3 = r25
            r4 = r22
            r5 = r23
            r6 = r16
            r7 = r18
            r8 = r21
            r9 = r36
            r10 = r38
            r12 = r11
            r11 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x0333:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.ClickableTextKt.m1126ClickableText03UYbkw(androidx.compose.ui.text.AnnotatedString, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, boolean, int, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final Integer ClickableText_03UYbkw$getOffset(MutableState<TextLayoutResult> layoutResult, long positionOffset) {
        MultiParagraph it;
        TextLayoutResult value = layoutResult.getValue();
        if (value == null || (it = value.getMultiParagraph()) == null) {
            return null;
        }
        if (!m1128containsWithinBoundsUv8p0NA(it, positionOffset)) {
            it = null;
        }
        if (it != null) {
            return Integer.valueOf(it.m5359getOffsetForPositionk4lQ0M(positionOffset));
        }
        return null;
    }

    /* renamed from: containsWithinBounds-Uv8p0NA  reason: not valid java name */
    private static final boolean m1128containsWithinBoundsUv8p0NA(MultiParagraph $this$containsWithinBounds_u2dUv8p0NA, long positionOffset) {
        float x = Offset.m2905component1impl(positionOffset);
        float y = Offset.m2906component2impl(positionOffset);
        return x > 0.0f && y >= 0.0f && x <= $this$containsWithinBounds_u2dUv8p0NA.getWidth() && y <= $this$containsWithinBounds_u2dUv8p0NA.getHeight();
    }
}
