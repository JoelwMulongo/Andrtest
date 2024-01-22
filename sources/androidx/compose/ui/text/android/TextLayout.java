package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001BÅ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ&\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\tJ\u000e\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\tJ\u0010\u0010Z\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\tH\u0002J\u000e\u0010\\\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\tJ\u000e\u0010]\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\tJ\u000e\u0010^\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\tJ\u000e\u0010_\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\tJ\u000e\u0010`\u001a\u00020\t2\u0006\u0010a\u001a\u00020\tJ\u000e\u0010b\u001a\u00020\t2\u0006\u0010a\u001a\u00020\tJ\u000e\u0010c\u001a\u00020\t2\u0006\u0010a\u001a\u00020\tJ\u000e\u0010d\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\tJ\u000e\u0010e\u001a\u00020\t2\u0006\u0010f\u001a\u00020\tJ\u000e\u0010g\u001a\u00020\u00052\u0006\u0010a\u001a\u00020\tJ\u000e\u0010h\u001a\u00020\u00052\u0006\u0010a\u001a\u00020\tJ\u000e\u0010i\u001a\u00020\u00052\u0006\u0010a\u001a\u00020\tJ\u000e\u0010j\u001a\u00020\t2\u0006\u0010a\u001a\u00020\tJ\u000e\u0010k\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\tJ\u000e\u0010l\u001a\u00020\t2\u0006\u0010a\u001a\u00020\tJ\u000e\u0010m\u001a\u00020\u00052\u0006\u0010a\u001a\u00020\tJ\u0016\u0010n\u001a\u00020\t2\u0006\u0010[\u001a\u00020\t2\u0006\u0010o\u001a\u00020\u0005J\u000e\u0010p\u001a\u00020\t2\u0006\u0010[\u001a\u00020\tJ\u0018\u0010q\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\t2\b\b\u0002\u0010r\u001a\u00020\u0010J\u0018\u0010s\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\t2\b\b\u0002\u0010r\u001a\u00020\u0010J\u001e\u0010t\u001a\u00020Q2\u0006\u0010u\u001a\u00020\t2\u0006\u0010v\u001a\u00020\t2\u0006\u0010w\u001a\u00020xJ\r\u0010y\u001a\u00020\u0010H\u0000¢\u0006\u0002\bzJ\u000e\u0010{\u001a\u00020\u00102\u0006\u0010a\u001a\u00020\tJ\u000e\u0010|\u001a\u00020\u00102\u0006\u0010Y\u001a\u00020\tJ\u000e\u0010}\u001a\u00020Q2\u0006\u0010~\u001a\u00020R\u001c\u0010\u001e\u001a\u00020\t8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010'\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b(\u0010\"R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u000e\u0010*\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u00020/8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010 \u001a\u0004\b1\u00102R\u001b\u00103\u001a\u0002048BX\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010<\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\"R\u0016\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?X\u0004¢\u0006\u0004\n\u0002\u0010AR\u0011\u0010B\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0011\u0010E\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bF\u0010DR\u000e\u0010G\u001a\u00020HX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010J\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bK\u0010LR\u001c\u0010M\u001a\u00020\t8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bN\u0010 \u001a\u0004\bO\u0010\"¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/android/TextLayout;", "", "charSequence", "", "width", "", "textPaint", "Landroid/text/TextPaint;", "alignment", "", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "textDirectionHeuristic", "lineSpacingMultiplier", "lineSpacingExtra", "includePadding", "", "fallbackLineSpacing", "maxLines", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "hyphenationFrequency", "justificationMode", "leftIndents", "", "rightIndents", "layoutIntrinsics", "Landroidx/compose/ui/text/android/LayoutIntrinsics;", "(Ljava/lang/CharSequence;FLandroid/text/TextPaint;ILandroid/text/TextUtils$TruncateAt;IFFZZIIIIII[I[ILandroidx/compose/ui/text/android/LayoutIntrinsics;)V", "bottomPadding", "getBottomPadding$ui_text_release$annotations", "()V", "getBottomPadding$ui_text_release", "()I", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "getFallbackLineSpacing", "height", "getHeight", "getIncludePadding", "isBoringLayout", "lastLineExtra", "lastLineFontMetrics", "Landroid/graphics/Paint$FontMetricsInt;", "layout", "Landroid/text/Layout;", "getLayout$annotations", "getLayout", "()Landroid/text/Layout;", "layoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "getLayoutHelper", "()Landroidx/compose/ui/text/android/LayoutHelper;", "layoutHelper$delegate", "Lkotlin/Lazy;", "getLayoutIntrinsics", "()Landroidx/compose/ui/text/android/LayoutIntrinsics;", "leftPadding", "lineCount", "getLineCount", "lineHeightSpans", "", "Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "()F", "minIntrinsicWidth", "getMinIntrinsicWidth", "rect", "Landroid/graphics/Rect;", "rightPadding", "text", "getText", "()Ljava/lang/CharSequence;", "topPadding", "getTopPadding$ui_text_release$annotations", "getTopPadding$ui_text_release", "fillBoundingBoxes", "", "startOffset", "endOffset", "array", "", "arrayStart", "getBoundingBox", "Landroid/graphics/RectF;", "offset", "getHorizontalPadding", "line", "getLineAscent", "getLineBaseline", "getLineBottom", "getLineDescent", "getLineEllipsisCount", "lineIndex", "getLineEllipsisOffset", "getLineEnd", "getLineForOffset", "getLineForVertical", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineVisibleEnd", "getLineWidth", "getOffsetForHorizontal", "horizontal", "getParagraphDirection", "getPrimaryHorizontal", "upstream", "getSecondaryHorizontal", "getSelectionPath", "start", "end", "dest", "Landroid/graphics/Path;", "isFallbackLinespacingApplied", "isFallbackLinespacingApplied$ui_text_release", "isLineEllipsized", "isRtlCharAt", "paint", "canvas", "Landroid/graphics/Canvas;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextLayout.kt */
public final class TextLayout {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int bottomPadding;
    private final boolean didExceedMaxLines;
    private final boolean fallbackLineSpacing;
    private final boolean includePadding;
    private final boolean isBoringLayout;
    private final int lastLineExtra;
    private final Paint.FontMetricsInt lastLineFontMetrics;
    private final Layout layout;
    private final Lazy layoutHelper$delegate;
    private final LayoutIntrinsics layoutIntrinsics;
    private final float leftPadding;
    private final int lineCount;
    private final LineHeightStyleSpan[] lineHeightSpans;
    private final Rect rect;
    private final float rightPadding;
    private final int topPadding;

    public static /* synthetic */ void getBottomPadding$ui_text_release$annotations() {
    }

    public static /* synthetic */ void getLayout$annotations() {
    }

    public static /* synthetic */ void getTopPadding$ui_text_release$annotations() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextLayout(java.lang.CharSequence r32, float r33, android.text.TextPaint r34, int r35, android.text.TextUtils.TruncateAt r36, int r37, float r38, float r39, boolean r40, boolean r41, int r42, int r43, int r44, int r45, int r46, int r47, int[] r48, int[] r49, androidx.compose.ui.text.android.LayoutIntrinsics r50) {
        /*
            r31 = this;
            r1 = r31
            r15 = r32
            r14 = r33
            r13 = r34
            r12 = r42
            r11 = r50
            java.lang.String r0 = "charSequence"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "textPaint"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "layoutIntrinsics"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r31.<init>()
            r10 = r40
            r1.includePadding = r10
            r9 = r41
            r1.fallbackLineSpacing = r9
            r1.layoutIntrinsics = r11
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r1.rect = r0
            int r8 = r32.length()
            android.text.TextDirectionHeuristic r7 = androidx.compose.ui.text.android.TextLayoutKt.getTextDirectionHeuristic(r37)
            androidx.compose.ui.text.android.TextAlignmentAdapter r0 = androidx.compose.ui.text.android.TextAlignmentAdapter.INSTANCE
            r6 = r35
            android.text.Layout$Alignment r24 = r0.get(r6)
            boolean r0 = r15 instanceof android.text.Spanned
            r5 = 0
            r4 = 1
            if (r0 == 0) goto L_0x0058
            r0 = r15
            android.text.Spanned r0 = (android.text.Spanned) r0
            r2 = -1
            java.lang.Class<androidx.compose.ui.text.android.style.BaselineShiftSpan> r3 = androidx.compose.ui.text.android.style.BaselineShiftSpan.class
            int r0 = r0.nextSpanTransition(r2, r8, r3)
            if (r0 >= r8) goto L_0x0056
            r0 = r4
            goto L_0x0059
        L_0x0056:
            r0 = r5
            goto L_0x0059
        L_0x0058:
            r0 = r5
        L_0x0059:
            r25 = r0
            java.lang.String r0 = "TextLayout:initLayout"
            android.os.Trace.beginSection(r0)
            android.text.BoringLayout$Metrics r0 = r50.getBoringMetrics()     // Catch:{ all -> 0x01e1 }
            double r2 = (double) r14     // Catch:{ all -> 0x01e1 }
            double r2 = java.lang.Math.ceil(r2)     // Catch:{ all -> 0x01e1 }
            float r2 = (float) r2
            int r3 = (int) r2
            if (r0 == 0) goto L_0x00c5
            float r2 = r50.getMaxIntrinsicWidth()     // Catch:{ all -> 0x00ba }
            int r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r2 > 0) goto L_0x00c5
            if (r25 != 0) goto L_0x00b0
            r1.isBoringLayout = r4     // Catch:{ all -> 0x00ba }
            androidx.compose.ui.text.android.BoringLayoutFactory r2 = androidx.compose.ui.text.android.BoringLayoutFactory.INSTANCE     // Catch:{ all -> 0x00ba }
            r26 = r3
            r3 = r32
            r27 = r4
            r4 = r34
            r15 = r5
            r5 = r26
            r6 = r0
            r28 = r7
            r7 = r24
            r29 = r8
            r8 = r40
            r9 = r41
            r10 = r36
            r11 = r26
            android.text.BoringLayout r2 = r2.create(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00a9 }
            android.text.Layout r2 = (android.text.Layout) r2     // Catch:{ all -> 0x00a9 }
            r30 = r15
            goto L_0x0120
        L_0x00a9:
            r0 = move-exception
            r3 = r12
            r7 = r13
            r8 = r28
            goto L_0x01e7
        L_0x00b0:
            r26 = r3
            r27 = r4
            r15 = r5
            r28 = r7
            r29 = r8
            goto L_0x00ce
        L_0x00ba:
            r0 = move-exception
            r28 = r7
            r29 = r8
            r3 = r12
            r7 = r13
            r8 = r28
            goto L_0x01e7
        L_0x00c5:
            r26 = r3
            r27 = r4
            r15 = r5
            r28 = r7
            r29 = r8
        L_0x00ce:
            r1.isBoringLayout = r15     // Catch:{ all -> 0x01db }
            androidx.compose.ui.text.android.StaticLayoutFactory r2 = androidx.compose.ui.text.android.StaticLayoutFactory.INSTANCE     // Catch:{ all -> 0x01db }
            r4 = 0
            int r5 = r32.length()     // Catch:{ all -> 0x01db }
            double r6 = (double) r14     // Catch:{ all -> 0x01db }
            double r6 = java.lang.Math.ceil(r6)     // Catch:{ all -> 0x01db }
            float r3 = (float) r6
            int r11 = (int) r3
            r3 = r32
            r6 = r34
            r7 = r26
            r8 = r28
            r9 = r24
            r10 = r42
            r16 = r11
            r11 = r36
            r12 = r16
            r13 = r38
            r14 = r39
            r30 = r15
            r15 = r47
            r16 = r40
            r17 = r41
            r18 = r43
            r19 = r44
            r20 = r45
            r21 = r46
            r22 = r48
            r23 = r49
            android.text.StaticLayout r2 = r2.create(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x01d5 }
            android.text.Layout r2 = (android.text.Layout) r2     // Catch:{ all -> 0x01d5 }
        L_0x0120:
            r1.layout = r2     // Catch:{ all -> 0x01d5 }
            android.os.Trace.endSection()
            int r0 = r2.getLineCount()
            r3 = r42
            int r0 = java.lang.Math.min(r0, r3)
            r1.lineCount = r0
            if (r0 >= r3) goto L_0x0138
            r5 = r30
            goto L_0x0152
        L_0x0138:
            int r4 = r0 + -1
            int r4 = r2.getEllipsisCount(r4)
            if (r4 > 0) goto L_0x0150
            int r4 = r0 + -1
            int r4 = r2.getLineEnd(r4)
            int r5 = r32.length()
            if (r4 == r5) goto L_0x014d
            goto L_0x0150
        L_0x014d:
            r5 = r30
            goto L_0x0152
        L_0x0150:
            r5 = r27
        L_0x0152:
            r1.didExceedMaxLines = r5
            kotlin.Pair r4 = androidx.compose.ui.text.android.TextLayoutKt.getVerticalPaddings(r31)
            androidx.compose.ui.text.android.style.LineHeightStyleSpan[] r5 = androidx.compose.ui.text.android.TextLayoutKt.getLineHeightSpans(r31)
            r1.lineHeightSpans = r5
            kotlin.Pair r6 = androidx.compose.ui.text.android.TextLayoutKt.getLineHeightPaddings(r1, r5)
            java.lang.Object r7 = r4.getFirst()
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            java.lang.Object r8 = r6.getFirst()
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            int r7 = java.lang.Math.max(r7, r8)
            r1.topPadding = r7
            java.lang.Object r7 = r4.getSecond()
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            java.lang.Object r8 = r6.getSecond()
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            int r7 = java.lang.Math.max(r7, r8)
            r1.bottomPadding = r7
            r7 = r34
            r8 = r28
            kotlin.Pair r5 = androidx.compose.ui.text.android.TextLayoutKt.getLastLineMetrics(r1, r7, r8, r5)
            java.lang.Object r9 = r5.getFirst()
            android.graphics.Paint$FontMetricsInt r9 = (android.graphics.Paint.FontMetricsInt) r9
            r1.lastLineFontMetrics = r9
            java.lang.Object r9 = r5.getSecond()
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            r1.lastLineExtra = r9
            int r9 = r0 + -1
            r10 = 0
            r11 = 2
            float r9 = androidx.compose.ui.text.android.style.IndentationFixSpanKt.getEllipsizedLeftPadding$default(r2, r9, r10, r11, r10)
            r1.leftPadding = r9
            int r0 = r0 + -1
            float r0 = androidx.compose.ui.text.android.style.IndentationFixSpanKt.getEllipsizedRightPadding$default(r2, r0, r10, r11, r10)
            r1.rightPadding = r0
            kotlin.LazyThreadSafetyMode r0 = kotlin.LazyThreadSafetyMode.NONE
            androidx.compose.ui.text.android.TextLayout$layoutHelper$2 r2 = new androidx.compose.ui.text.android.TextLayout$layoutHelper$2
            r2.<init>(r1)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            kotlin.Lazy r0 = kotlin.LazyKt.lazy((kotlin.LazyThreadSafetyMode) r0, r2)
            r1.layoutHelper$delegate = r0
            return
        L_0x01d5:
            r0 = move-exception
            r7 = r34
            r3 = r42
            goto L_0x01de
        L_0x01db:
            r0 = move-exception
            r3 = r12
            r7 = r13
        L_0x01de:
            r8 = r28
            goto L_0x01e7
        L_0x01e1:
            r0 = move-exception
            r29 = r8
            r3 = r12
            r8 = r7
            r7 = r13
        L_0x01e7:
            android.os.Trace.endSection()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.android.TextLayout.<init>(java.lang.CharSequence, float, android.text.TextPaint, int, android.text.TextUtils$TruncateAt, int, float, float, boolean, boolean, int, int, int, int, int, int, int[], int[], androidx.compose.ui.text.android.LayoutIntrinsics):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextLayout(java.lang.CharSequence r24, float r25, android.text.TextPaint r26, int r27, android.text.TextUtils.TruncateAt r28, int r29, float r30, float r31, boolean r32, boolean r33, int r34, int r35, int r36, int r37, int r38, int r39, int[] r40, int[] r41, androidx.compose.ui.text.android.LayoutIntrinsics r42, int r43, kotlin.jvm.internal.DefaultConstructorMarker r44) {
        /*
            r23 = this;
            r0 = r43
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r5 = r2
            goto L_0x000b
        L_0x0009:
            r5 = r25
        L_0x000b:
            r1 = r0 & 8
            r3 = 0
            if (r1 == 0) goto L_0x0012
            r7 = r3
            goto L_0x0014
        L_0x0012:
            r7 = r27
        L_0x0014:
            r1 = r0 & 16
            r4 = 0
            if (r1 == 0) goto L_0x001b
            r8 = r4
            goto L_0x001d
        L_0x001b:
            r8 = r28
        L_0x001d:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0024
            r1 = 2
            r9 = r1
            goto L_0x0026
        L_0x0024:
            r9 = r29
        L_0x0026:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002e
            r1 = 1065353216(0x3f800000, float:1.0)
            r10 = r1
            goto L_0x0030
        L_0x002e:
            r10 = r30
        L_0x0030:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0036
            r11 = r2
            goto L_0x0038
        L_0x0036:
            r11 = r31
        L_0x0038:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x003e
            r12 = r3
            goto L_0x0040
        L_0x003e:
            r12 = r32
        L_0x0040:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0047
            r1 = 1
            r13 = r1
            goto L_0x0049
        L_0x0047:
            r13 = r33
        L_0x0049:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0052
            r1 = 2147483647(0x7fffffff, float:NaN)
            r14 = r1
            goto L_0x0054
        L_0x0052:
            r14 = r34
        L_0x0054:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x005a
            r15 = r3
            goto L_0x005c
        L_0x005a:
            r15 = r35
        L_0x005c:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0063
            r16 = r3
            goto L_0x0065
        L_0x0063:
            r16 = r36
        L_0x0065:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x006c
            r17 = r3
            goto L_0x006e
        L_0x006c:
            r17 = r37
        L_0x006e:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0075
            r18 = r3
            goto L_0x0077
        L_0x0075:
            r18 = r38
        L_0x0077:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0080
            r19 = r3
            goto L_0x0082
        L_0x0080:
            r19 = r39
        L_0x0082:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x008a
            r20 = r4
            goto L_0x008c
        L_0x008a:
            r20 = r40
        L_0x008c:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0094
            r21 = r4
            goto L_0x0096
        L_0x0094:
            r21 = r41
        L_0x0096:
            r1 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00aa
            androidx.compose.ui.text.android.LayoutIntrinsics r0 = new androidx.compose.ui.text.android.LayoutIntrinsics
            r1 = r24
            r2 = r26
            r0.<init>(r1, r2, r9)
            r22 = r0
            goto L_0x00b0
        L_0x00aa:
            r1 = r24
            r2 = r26
            r22 = r42
        L_0x00b0:
            r3 = r23
            r4 = r24
            r6 = r26
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.android.TextLayout.<init>(java.lang.CharSequence, float, android.text.TextPaint, int, android.text.TextUtils$TruncateAt, int, float, float, boolean, boolean, int, int, int, int, int, int, int[], int[], androidx.compose.ui.text.android.LayoutIntrinsics, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean getIncludePadding() {
        return this.includePadding;
    }

    public final boolean getFallbackLineSpacing() {
        return this.fallbackLineSpacing;
    }

    public final LayoutIntrinsics getLayoutIntrinsics() {
        return this.layoutIntrinsics;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/android/TextLayout$Companion;", "", "()V", "constructStaticLayout", "Landroid/text/StaticLayout;", "charSequence", "", "width", "", "textPaint", "Landroid/text/TextPaint;", "hyphenationFrequency", "lineBreakStyle", "breakStrategy", "lineBreakWordStyle", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextLayout.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StaticLayout constructStaticLayout(CharSequence charSequence, int width, TextPaint textPaint, int hyphenationFrequency, int lineBreakStyle, int breakStrategy, int lineBreakWordStyle) {
            TextPaint textPaint2 = textPaint;
            int i = lineBreakStyle;
            int i2 = breakStrategy;
            int i3 = lineBreakWordStyle;
            Intrinsics.checkNotNullParameter(charSequence, "charSequence");
            Intrinsics.checkNotNullParameter(textPaint, "textPaint");
            return StaticLayoutFactory.create$default(StaticLayoutFactory.INSTANCE, charSequence, 0, 0, textPaint2, width, (TextDirectionHeuristic) null, (Layout.Alignment) null, 0, (TextUtils.TruncateAt) null, 0, 0.0f, 0.0f, 0, false, false, i2, i, i3, hyphenationFrequency, (int[]) null, (int[]) null, 1605606, (Object) null);
        }
    }

    public final float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    public final float getMinIntrinsicWidth() {
        return this.layoutIntrinsics.getMinIntrinsicWidth();
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final Layout getLayout() {
        return this.layout;
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final int getTopPadding$ui_text_release() {
        return this.topPadding;
    }

    public final int getBottomPadding$ui_text_release() {
        return this.bottomPadding;
    }

    private final LayoutHelper getLayoutHelper() {
        return (LayoutHelper) this.layoutHelper$delegate.getValue();
    }

    public final CharSequence getText() {
        CharSequence text = this.layout.getText();
        Intrinsics.checkNotNullExpressionValue(text, "layout.text");
        return text;
    }

    public final int getHeight() {
        int i;
        if (this.didExceedMaxLines) {
            i = this.layout.getLineBottom(this.lineCount - 1);
        } else {
            i = this.layout.getHeight();
        }
        return i + this.topPadding + this.bottomPadding + this.lastLineExtra;
    }

    private final float getHorizontalPadding(int line) {
        if (line == this.lineCount - 1) {
            return this.leftPadding + this.rightPadding;
        }
        return 0.0f;
    }

    public final float getLineLeft(int lineIndex) {
        return this.layout.getLineLeft(lineIndex) + (lineIndex == this.lineCount + -1 ? this.leftPadding : 0.0f);
    }

    public final float getLineRight(int lineIndex) {
        return this.layout.getLineRight(lineIndex) + (lineIndex == this.lineCount + -1 ? this.rightPadding : 0.0f);
    }

    public final float getLineTop(int line) {
        return ((float) (line == 0 ? 0 : this.topPadding)) + ((float) this.layout.getLineTop(line));
    }

    public final float getLineBottom(int line) {
        if (line == this.lineCount - 1 && this.lastLineFontMetrics != null) {
            return ((float) this.layout.getLineBottom(line - 1)) + ((float) this.lastLineFontMetrics.bottom);
        }
        return ((float) this.topPadding) + ((float) this.layout.getLineBottom(line)) + ((float) (line == this.lineCount + -1 ? this.bottomPadding : 0));
    }

    public final float getLineAscent(int line) {
        Paint.FontMetricsInt fontMetricsInt;
        if (line != this.lineCount - 1 || (fontMetricsInt = this.lastLineFontMetrics) == null) {
            return (float) this.layout.getLineAscent(line);
        }
        return (float) fontMetricsInt.ascent;
    }

    public final float getLineBaseline(int line) {
        float f;
        float f2 = (float) this.topPadding;
        if (line != this.lineCount - 1 || this.lastLineFontMetrics == null) {
            f = (float) this.layout.getLineBaseline(line);
        } else {
            f = getLineTop(line) - ((float) this.lastLineFontMetrics.ascent);
        }
        return f2 + f;
    }

    public final float getLineDescent(int line) {
        Paint.FontMetricsInt fontMetricsInt;
        if (line != this.lineCount - 1 || (fontMetricsInt = this.lastLineFontMetrics) == null) {
            return (float) this.layout.getLineDescent(line);
        }
        return (float) fontMetricsInt.descent;
    }

    public final float getLineHeight(int lineIndex) {
        return getLineBottom(lineIndex) - getLineTop(lineIndex);
    }

    public final float getLineWidth(int lineIndex) {
        return this.layout.getLineWidth(lineIndex);
    }

    public final int getLineStart(int lineIndex) {
        return this.layout.getLineStart(lineIndex);
    }

    public final int getLineEnd(int lineIndex) {
        if (this.layout.getEllipsisStart(lineIndex) == 0) {
            return this.layout.getLineEnd(lineIndex);
        }
        return this.layout.getText().length();
    }

    public final int getLineVisibleEnd(int lineIndex) {
        if (this.layout.getEllipsisStart(lineIndex) == 0) {
            return this.layout.getLineVisibleEnd(lineIndex);
        }
        return this.layout.getLineStart(lineIndex) + this.layout.getEllipsisStart(lineIndex);
    }

    public final boolean isLineEllipsized(int lineIndex) {
        return TextLayoutKt.isLineEllipsized(this.layout, lineIndex);
    }

    public final int getLineEllipsisOffset(int lineIndex) {
        return this.layout.getEllipsisStart(lineIndex);
    }

    public final int getLineEllipsisCount(int lineIndex) {
        return this.layout.getEllipsisCount(lineIndex);
    }

    public final int getLineForVertical(int vertical) {
        return this.layout.getLineForVertical(this.topPadding + vertical);
    }

    public final int getOffsetForHorizontal(int line, float horizontal) {
        return this.layout.getOffsetForHorizontal(line, (((float) -1) * getHorizontalPadding(line)) + horizontal);
    }

    public static /* synthetic */ float getPrimaryHorizontal$default(TextLayout textLayout, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return textLayout.getPrimaryHorizontal(i, z);
    }

    public final float getPrimaryHorizontal(int offset, boolean upstream) {
        return getLayoutHelper().getHorizontalPosition(offset, true, upstream) + getHorizontalPadding(getLineForOffset(offset));
    }

    public static /* synthetic */ float getSecondaryHorizontal$default(TextLayout textLayout, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return textLayout.getSecondaryHorizontal(i, z);
    }

    public final float getSecondaryHorizontal(int offset, boolean upstream) {
        return getLayoutHelper().getHorizontalPosition(offset, false, upstream) + getHorizontalPadding(getLineForOffset(offset));
    }

    public final int getLineForOffset(int offset) {
        return this.layout.getLineForOffset(offset);
    }

    public final boolean isRtlCharAt(int offset) {
        return this.layout.isRtlCharAt(offset);
    }

    public final int getParagraphDirection(int line) {
        return this.layout.getParagraphDirection(line);
    }

    public final void getSelectionPath(int start, int end, Path dest) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        this.layout.getSelectionPath(start, end, dest);
        if (this.topPadding != 0 && !dest.isEmpty()) {
            dest.offset(0.0f, (float) this.topPadding);
        }
    }

    public final void fillBoundingBoxes(int startOffset, int endOffset, float[] array, int arrayStart) {
        float left;
        float right;
        TextLayout textLayout = this;
        int i = startOffset;
        int i2 = endOffset;
        float[] fArr = array;
        Intrinsics.checkNotNullParameter(fArr, "array");
        int textLength = getText().length();
        boolean z = true;
        if (i >= 0) {
            if (i < textLength) {
                if (i2 > i) {
                    if (i2 <= textLength) {
                        if (fArr.length - arrayStart >= (i2 - i) * 4) {
                            int firstLine = getLineForOffset(startOffset);
                            int lastLine = textLayout.getLineForOffset(i2 - 1);
                            HorizontalPositionCache cache = new HorizontalPositionCache(textLayout);
                            int arrayOffset = arrayStart;
                            int line = firstLine;
                            if (line <= lastLine) {
                                while (true) {
                                    int lineStartOffset = textLayout.getLineStart(line);
                                    int lineEndOffset = textLayout.getLineEnd(line);
                                    int actualStartOffset = Math.max(i, lineStartOffset);
                                    int actualEndOffset = Math.min(i2, lineEndOffset);
                                    float lineTop = textLayout.getLineTop(line);
                                    float lineBottom = textLayout.getLineBottom(line);
                                    boolean isLtrLine = textLayout.getParagraphDirection(line) == z ? z : false;
                                    boolean isRtlLine = !isLtrLine ? z : false;
                                    int offset = actualStartOffset;
                                    while (offset < actualEndOffset) {
                                        boolean isRtlChar = textLayout.isRtlCharAt(offset);
                                        if (isLtrLine && !isRtlChar) {
                                            left = cache.getPrimaryDownstream(offset);
                                            right = cache.getPrimaryUpstream(offset + 1);
                                        } else if (isLtrLine && isRtlChar) {
                                            float right2 = cache.getSecondaryDownstream(offset);
                                            left = cache.getSecondaryUpstream(offset + 1);
                                            right = right2;
                                        } else if (!isRtlLine || !isRtlChar) {
                                            left = cache.getSecondaryDownstream(offset);
                                            right = cache.getSecondaryUpstream(offset + 1);
                                        } else {
                                            float right3 = cache.getPrimaryDownstream(offset);
                                            left = cache.getPrimaryUpstream(offset + 1);
                                            right = right3;
                                        }
                                        fArr[arrayOffset] = left;
                                        fArr[arrayOffset + 1] = lineTop;
                                        fArr[arrayOffset + 2] = right;
                                        fArr[arrayOffset + 3] = lineBottom;
                                        arrayOffset += 4;
                                        offset++;
                                        textLayout = this;
                                    }
                                    if (line != lastLine) {
                                        line++;
                                        z = true;
                                        textLayout = this;
                                        i = startOffset;
                                    } else {
                                        return;
                                    }
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 4".toString());
                        }
                    } else {
                        throw new IllegalArgumentException("endOffset must be smaller or equal to text length".toString());
                    }
                } else {
                    throw new IllegalArgumentException("endOffset must be greater than startOffset".toString());
                }
            } else {
                throw new IllegalArgumentException("startOffset must be less than text length".toString());
            }
        } else {
            throw new IllegalArgumentException("startOffset must be > 0".toString());
        }
    }

    public final RectF getBoundingBox(int offset) {
        float right;
        float left;
        int line = getLineForOffset(offset);
        float lineTop = getLineTop(line);
        float lineBottom = getLineBottom(line);
        boolean isLtrLine = getParagraphDirection(line) == 1;
        boolean isRtlChar = this.layout.isRtlCharAt(offset);
        if (isLtrLine && !isRtlChar) {
            left = getPrimaryHorizontal(offset, false);
            right = getPrimaryHorizontal(offset + 1, true);
        } else if (isLtrLine && isRtlChar) {
            right = getSecondaryHorizontal(offset, false);
            left = getSecondaryHorizontal(offset + 1, true);
        } else if (isRtlChar) {
            right = getPrimaryHorizontal(offset, false);
            left = getPrimaryHorizontal(offset + 1, true);
        } else {
            left = getSecondaryHorizontal(offset, false);
            right = getSecondaryHorizontal(offset + 1, true);
        }
        return new RectF(left, lineTop, right, lineBottom);
    }

    public final void paint(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (canvas.getClipBounds(this.rect)) {
            int i = this.topPadding;
            if (i != 0) {
                canvas.translate(0.0f, (float) i);
            }
            TextAndroidCanvas $this$paint_u24lambda_u245 = TextLayoutKt.SharedTextAndroidCanvas;
            $this$paint_u24lambda_u245.setCanvas(canvas);
            this.layout.draw($this$paint_u24lambda_u245);
            int i2 = this.topPadding;
            if (i2 != 0) {
                canvas.translate(0.0f, ((float) -1) * ((float) i2));
            }
        }
    }

    public final boolean isFallbackLinespacingApplied$ui_text_release() {
        if (this.isBoringLayout) {
            BoringLayoutFactory boringLayoutFactory = BoringLayoutFactory.INSTANCE;
            Layout layout2 = this.layout;
            Intrinsics.checkNotNull(layout2, "null cannot be cast to non-null type android.text.BoringLayout");
            return boringLayoutFactory.isFallbackLineSpacingEnabled((BoringLayout) layout2);
        }
        StaticLayoutFactory staticLayoutFactory = StaticLayoutFactory.INSTANCE;
        Layout layout3 = this.layout;
        Intrinsics.checkNotNull(layout3, "null cannot be cast to non-null type android.text.StaticLayout");
        return staticLayoutFactory.isFallbackLineSpacingEnabled((StaticLayout) layout3, this.fallbackLineSpacing);
    }
}
