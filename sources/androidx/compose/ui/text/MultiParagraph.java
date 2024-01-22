package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidMultiParagraphDrawKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B+\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nBY\b\u0017\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017BY\b\u0017\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u001aB\\\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001dB,\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u000e\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0005J\u000e\u0010@\u001a\u00020:2\u0006\u0010?\u001a\u00020\u0005J\u000e\u0010A\u001a\u00020:2\u0006\u0010?\u001a\u00020\u0005J\u0016\u0010B\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0007J\u000e\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005J\u0018\u0010F\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\b\b\u0002\u0010G\u001a\u00020\u0007J\u000e\u0010H\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005J\u000e\u0010I\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\tJ\u000e\u0010K\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005J\u000e\u0010L\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005J\u000e\u0010M\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005J\u000e\u0010N\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u0005J\u000e\u0010O\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005J\u000e\u0010P\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005J\u001b\u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020Sø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\u000e\u0010V\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0005J\u0016\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\u0005J\u001e\u0010[\u001a\u00020\\2\u0006\u0010?\u001a\u00020\u0005ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b]\u0010^J\u000e\u0010_\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0005J]\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020e2\b\b\u0002\u0010f\u001a\u00020\t2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010h2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010j2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010l2\b\b\u0002\u0010m\u001a\u00020nH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bo\u0010pJ=\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\b\b\u0002\u0010q\u001a\u00020r2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010h2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010jø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bs\u0010tJU\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\b\b\u0002\u0010q\u001a\u00020r2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010h2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010j2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010l2\b\b\u0002\u0010m\u001a\u00020nH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bu\u0010vJ\u0010\u0010w\u001a\u00020a2\u0006\u0010?\u001a\u00020\u0005H\u0002J\u0010\u0010x\u001a\u00020a2\u0006\u0010?\u001a\u00020\u0005H\u0002J\u0010\u0010y\u001a\u00020a2\u0006\u0010E\u001a\u00020\u0005H\u0002R\u0014\u0010\u000b\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b,\u0010&R\u0011\u0010-\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u00100\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b1\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0011\u00103\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b4\u0010&R\u001a\u00105\u001a\b\u0012\u0004\u0012\u0002060\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0019\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:0\u0010¢\u0006\b\n\u0000\u001a\u0004\b;\u00108R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b<\u0010&\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006z"}, d2 = {"Landroidx/compose/ui/text/MultiParagraph;", "", "intrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "maxLines", "", "ellipsis", "", "width", "", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;IZF)V", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZFLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;IZ)V", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;JIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "firstBaseline", "getFirstBaseline", "()F", "height", "getHeight", "getIntrinsics", "()Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "lastBaseline", "getLastBaseline", "lineCount", "getLineCount", "()I", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "paragraphInfoList", "Landroidx/compose/ui/text/ParagraphInfo;", "getParagraphInfoList$ui_text_release", "()Ljava/util/List;", "placeholderRects", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "getWidth", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineBottom", "lineIndex", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineWidth", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getWordBoundary", "Landroidx/compose/ui/text/TextRange;", "getWordBoundary--jx7JFs", "(I)J", "isLineEllipsized", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "decoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "requireIndexInRange", "requireIndexInRangeInclusiveEnd", "requireLineIndexInRange", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MultiParagraph.kt */
public final class MultiParagraph {
    public static final int $stable = 8;
    private final boolean didExceedMaxLines;
    private final float height;
    private final MultiParagraphIntrinsics intrinsics;
    private final int lineCount;
    private final int maxLines;
    private final List<ParagraphInfo> paragraphInfoList;
    private final List<Rect> placeholderRects;
    private final float width;

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j, Density density, FontFamily.Resolver resolver, List list, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, j, density, resolver, (List<AnnotatedString.Range<Placeholder>>) list, i, z);
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, j, i, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00cb, code lost:
        r6 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private MultiParagraph(androidx.compose.ui.text.MultiParagraphIntrinsics r35, long r36, int r38, boolean r39) {
        /*
            r34 = this;
            r0 = r34
            r34.<init>()
            r1 = r35
            r0.intrinsics = r1
            r2 = r38
            r0.maxLines = r2
            int r3 = androidx.compose.ui.unit.Constraints.m5932getMinWidthimpl(r36)
            r4 = 0
            if (r3 != 0) goto L_0x001d
            int r3 = androidx.compose.ui.unit.Constraints.m5931getMinHeightimpl(r36)
            if (r3 != 0) goto L_0x001d
            r3 = 1
            goto L_0x001e
        L_0x001d:
            r3 = r4
        L_0x001e:
            if (r3 == 0) goto L_0x01d1
            r3 = 0
            r5 = 0
            r6 = 0
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            java.util.List r8 = r35.getInfoList$ui_text_release()
            r9 = 0
            int r10 = r8.size()
        L_0x0033:
            if (r9 >= r10) goto L_0x00cd
            java.lang.Object r11 = r8.get(r9)
            r19 = r11
            androidx.compose.ui.text.ParagraphIntrinsicInfo r19 = (androidx.compose.ui.text.ParagraphIntrinsicInfo) r19
            androidx.compose.ui.text.ParagraphIntrinsics r11 = r19.getIntrinsics()
            r12 = 0
            int r13 = androidx.compose.ui.unit.Constraints.m5930getMaxWidthimpl(r36)
            r14 = 0
            boolean r15 = androidx.compose.ui.unit.Constraints.m5925getHasBoundedHeightimpl(r36)
            if (r15 == 0) goto L_0x005c
            int r15 = androidx.compose.ui.unit.Constraints.m5929getMaxHeightimpl(r36)
            int r16 = androidx.compose.ui.text.ParagraphKt.ceilToInt(r3)
            int r15 = r15 - r16
            int r15 = kotlin.ranges.RangesKt.coerceAtLeast((int) r15, (int) r4)
            goto L_0x0060
        L_0x005c:
            int r15 = androidx.compose.ui.unit.Constraints.m5929getMaxHeightimpl(r36)
        L_0x0060:
            r16 = 5
            r17 = 0
            long r12 = androidx.compose.ui.unit.ConstraintsKt.Constraints$default(r12, r13, r14, r15, r16, r17)
            int r14 = r0.maxLines
            int r14 = r14 - r5
            r15 = r39
            androidx.compose.ui.text.Paragraph r20 = androidx.compose.ui.text.ParagraphKt.m5376Paragraph_EkL_Y(r11, r12, r14, r15)
            r17 = r3
            float r11 = r20.getHeight()
            float r21 = r3 + r11
            r3 = r21
            r22 = r5
            int r11 = r20.getLineCount()
            int r14 = r22 + r11
            r5 = r14
            androidx.compose.ui.text.ParagraphInfo r13 = new androidx.compose.ui.text.ParagraphInfo
            int r16 = r19.getStartIndex()
            int r18 = r19.getEndIndex()
            r11 = r13
            r12 = r20
            r4 = r13
            r13 = r16
            r23 = r14
            r14 = r18
            r15 = r22
            r16 = r23
            r18 = r21
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)
            r7.add(r4)
            boolean r4 = r20.getDidExceedMaxLines()
            if (r4 != 0) goto L_0x00c9
            int r4 = r0.maxLines
            r11 = r23
            if (r11 != r4) goto L_0x00c4
            androidx.compose.ui.text.MultiParagraphIntrinsics r4 = r0.intrinsics
            java.util.List r4 = r4.getInfoList$ui_text_release()
            int r4 = kotlin.collections.CollectionsKt.getLastIndex(r4)
            if (r9 == r4) goto L_0x00c4
            goto L_0x00cb
        L_0x00c4:
            int r9 = r9 + 1
            r4 = 0
            goto L_0x0033
        L_0x00c9:
            r11 = r23
        L_0x00cb:
            r6 = 1
        L_0x00cd:
            r0.height = r3
            r0.lineCount = r5
            r0.didExceedMaxLines = r6
            r0.paragraphInfoList = r7
            int r4 = androidx.compose.ui.unit.Constraints.m5930getMaxWidthimpl(r36)
            float r4 = (float) r4
            r0.width = r4
            r4 = r7
            r9 = 0
            java.util.ArrayList r10 = new java.util.ArrayList
            int r11 = r4.size()
            r10.<init>(r11)
            r11 = r4
            r12 = 0
            r13 = 0
            int r14 = r11.size()
        L_0x00f0:
            if (r13 >= r14) goto L_0x0182
            java.lang.Object r16 = r11.get(r13)
            r17 = r16
            r18 = 0
            r19 = r17
            androidx.compose.ui.text.ParagraphInfo r19 = (androidx.compose.ui.text.ParagraphInfo) r19
            r20 = 0
            r21 = r19
            r22 = 0
            androidx.compose.ui.text.Paragraph r23 = r21.getParagraph()
            java.util.List r23 = r23.getPlaceholderRects()
            r24 = 0
            java.util.ArrayList r15 = new java.util.ArrayList
            int r1 = r23.size()
            r15.<init>(r1)
            r1 = r15
            r15 = r23
            r25 = 0
            r26 = 0
            int r2 = r15.size()
            r27 = r3
            r3 = r26
        L_0x0128:
            if (r3 >= r2) goto L_0x0161
            java.lang.Object r26 = r15.get(r3)
            r28 = r26
            r29 = 0
            r30 = r2
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            r31 = r4
            r4 = r28
            androidx.compose.ui.geometry.Rect r4 = (androidx.compose.ui.geometry.Rect) r4
            r32 = 0
            if (r4 == 0) goto L_0x014c
            r33 = r5
            r5 = r21
            androidx.compose.ui.geometry.Rect r21 = r5.toGlobal((androidx.compose.ui.geometry.Rect) r4)
            r4 = r21
            goto L_0x0151
        L_0x014c:
            r33 = r5
            r5 = r21
            r4 = 0
        L_0x0151:
            r2.add(r4)
            int r3 = r3 + 1
            r21 = r5
            r2 = r30
            r4 = r31
            r5 = r33
            goto L_0x0128
        L_0x0161:
            r31 = r4
            r33 = r5
            r5 = r21
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            r2 = r10
            java.util.Collection r2 = (java.util.Collection) r2
            kotlin.collections.CollectionsKt.addAll(r2, r1)
            int r13 = r13 + 1
            r1 = r35
            r2 = r38
            r3 = r27
            r5 = r33
            goto L_0x00f0
        L_0x0182:
            r27 = r3
            r31 = r4
            r33 = r5
            r1 = r10
            java.util.List r1 = (java.util.List) r1
            r2 = 0
            int r3 = r1.size()
            androidx.compose.ui.text.MultiParagraphIntrinsics r4 = r0.intrinsics
            java.util.List r4 = r4.getPlaceholders()
            int r4 = r4.size()
            if (r3 >= r4) goto L_0x01ca
            r3 = r1
            java.util.Collection r3 = (java.util.Collection) r3
            androidx.compose.ui.text.MultiParagraphIntrinsics r4 = r0.intrinsics
            java.util.List r4 = r4.getPlaceholders()
            int r4 = r4.size()
            int r5 = r1.size()
            int r4 = r4 - r5
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r4)
            r9 = 0
        L_0x01b6:
            if (r9 >= r4) goto L_0x01c1
            r10 = r9
            r11 = 0
            r10 = 0
            r5.add(r10)
            int r9 = r9 + 1
            goto L_0x01b6
        L_0x01c1:
            java.util.List r5 = (java.util.List) r5
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.List r3 = kotlin.collections.CollectionsKt.plus(r3, r5)
            goto L_0x01cb
        L_0x01ca:
            r3 = r1
        L_0x01cb:
            r0.placeholderRects = r3
            return
        L_0x01d1:
            r1 = 0
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.MultiParagraph.<init>(androidx.compose.ui.text.MultiParagraphIntrinsics, long, int, boolean):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MultiParagraph(androidx.compose.ui.text.MultiParagraphIntrinsics r8, long r9, int r11, boolean r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 4
            if (r14 == 0) goto L_0x0009
            r11 = 2147483647(0x7fffffff, float:NaN)
            r4 = r11
            goto L_0x000a
        L_0x0009:
            r4 = r11
        L_0x000a:
            r11 = r13 & 8
            if (r11 == 0) goto L_0x0011
            r12 = 0
            r5 = r12
            goto L_0x0012
        L_0x0011:
            r5 = r12
        L_0x0012:
            r6 = 0
            r0 = r7
            r1 = r8
            r2 = r9
            r0.<init>(r1, r2, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.MultiParagraph.<init>(androidx.compose.ui.text.MultiParagraphIntrinsics, long, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MultiParagraphIntrinsics getIntrinsics() {
        return this.intrinsics;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, int i, boolean z, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, (i2 & 2) != 0 ? Integer.MAX_VALUE : i, (i2 & 4) != 0 ? false : z, f);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "MultiParagraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(expression = "MultiParagraph(intrinsics, Constraints(maxWidth = ceil(width).toInt()), maxLines, ellipsis)", imports = {"kotlin.math.ceil", "androidx.compose.ui.unit.Constraints"}))
    public MultiParagraph(MultiParagraphIntrinsics intrinsics2, int maxLines2, boolean ellipsis, float width2) {
        this(intrinsics2, ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(width2), 0, 0, 13, (Object) null), maxLines2, ellipsis, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(intrinsics2, "intrinsics");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MultiParagraph(androidx.compose.ui.text.AnnotatedString r11, androidx.compose.ui.text.TextStyle r12, java.util.List r13, int r14, boolean r15, float r16, androidx.compose.ui.unit.Density r17, androidx.compose.ui.text.font.Font.ResourceLoader r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r10 = this;
            r0 = r19 & 4
            if (r0 == 0) goto L_0x000a
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r4 = r0
            goto L_0x000b
        L_0x000a:
            r4 = r13
        L_0x000b:
            r0 = r19 & 8
            if (r0 == 0) goto L_0x0014
            r0 = 2147483647(0x7fffffff, float:NaN)
            r5 = r0
            goto L_0x0015
        L_0x0014:
            r5 = r14
        L_0x0015:
            r0 = r19 & 16
            if (r0 == 0) goto L_0x001c
            r0 = 0
            r6 = r0
            goto L_0x001d
        L_0x001c:
            r6 = r15
        L_0x001d:
            r1 = r10
            r2 = r11
            r3 = r12
            r7 = r16
            r8 = r17
            r9 = r18
            r1.<init>((androidx.compose.ui.text.AnnotatedString) r2, (androidx.compose.ui.text.TextStyle) r3, (java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>>) r4, (int) r5, (boolean) r6, (float) r7, (androidx.compose.ui.unit.Density) r8, (androidx.compose.ui.text.font.Font.ResourceLoader) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.MultiParagraph.<init>(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, java.util.List, int, boolean, float, androidx.compose.ui.unit.Density, androidx.compose.ui.text.font.Font$ResourceLoader, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Font.ResourceLoader is deprecated, use fontFamilyResolver instead", replaceWith = @ReplaceWith(expression = "MultiParagraph(annotatedString, style, placeholders, maxLines, ellipsis, width, density, fontFamilyResolver)", imports = {}))
    public MultiParagraph(AnnotatedString annotatedString, TextStyle style, List<AnnotatedString.Range<Placeholder>> placeholders, int maxLines2, boolean ellipsis, float width2, Density density, Font.ResourceLoader resourceLoader) {
        this(new MultiParagraphIntrinsics(annotatedString, style, placeholders, density, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader)), ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(width2), 0, 0, 13, (Object) null), maxLines2, ellipsis, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(annotatedString, "annotatedString");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resourceLoader, "resourceLoader");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MultiParagraph(androidx.compose.ui.text.AnnotatedString r12, androidx.compose.ui.text.TextStyle r13, float r14, androidx.compose.ui.unit.Density r15, androidx.compose.ui.text.font.FontFamily.Resolver r16, java.util.List r17, int r18, boolean r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r11 = this;
            r0 = r20
            r1 = r0 & 32
            if (r1 == 0) goto L_0x000c
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r8 = r1
            goto L_0x000e
        L_0x000c:
            r8 = r17
        L_0x000e:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0017
            r1 = 2147483647(0x7fffffff, float:NaN)
            r9 = r1
            goto L_0x0019
        L_0x0017:
            r9 = r18
        L_0x0019:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0020
            r0 = 0
            r10 = r0
            goto L_0x0022
        L_0x0020:
            r10 = r19
        L_0x0022:
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r2.<init>((androidx.compose.ui.text.AnnotatedString) r3, (androidx.compose.ui.text.TextStyle) r4, (float) r5, (androidx.compose.ui.unit.Density) r6, (androidx.compose.ui.text.font.FontFamily.Resolver) r7, (java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>>) r8, (int) r9, (boolean) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.MultiParagraph.<init>(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, float, androidx.compose.ui.unit.Density, androidx.compose.ui.text.font.FontFamily$Resolver, java.util.List, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "MultiParagraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(expression = "MultiParagraph(annotatedString, style, Constraints(maxWidth = ceil(width).toInt()), density, fontFamilyResolver, placeholders, maxLines, ellipsis)", imports = {"kotlin.math.ceil", "androidx.compose.ui.unit.Constraints"}))
    public MultiParagraph(AnnotatedString annotatedString, TextStyle style, float width2, Density density, FontFamily.Resolver fontFamilyResolver, List<AnnotatedString.Range<Placeholder>> placeholders, int maxLines2, boolean ellipsis) {
        this(new MultiParagraphIntrinsics(annotatedString, style, placeholders, density, fontFamilyResolver), ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(width2), 0, 0, 13, (Object) null), maxLines2, ellipsis, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(annotatedString, "annotatedString");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MultiParagraph(androidx.compose.ui.text.AnnotatedString r14, androidx.compose.ui.text.TextStyle r15, long r16, androidx.compose.ui.unit.Density r18, androidx.compose.ui.text.font.FontFamily.Resolver r19, java.util.List r20, int r21, boolean r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 32
            if (r1 == 0) goto L_0x000c
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r9 = r1
            goto L_0x000e
        L_0x000c:
            r9 = r20
        L_0x000e:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0017
            r1 = 2147483647(0x7fffffff, float:NaN)
            r10 = r1
            goto L_0x0019
        L_0x0017:
            r10 = r21
        L_0x0019:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0020
            r0 = 0
            r11 = r0
            goto L_0x0022
        L_0x0020:
            r11 = r22
        L_0x0022:
            r12 = 0
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r7 = r18
            r8 = r19
            r2.<init>(r3, r4, r5, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.MultiParagraph.<init>(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, long, androidx.compose.ui.unit.Density, androidx.compose.ui.text.font.FontFamily$Resolver, java.util.List, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private MultiParagraph(AnnotatedString annotatedString, TextStyle style, long constraints, Density density, FontFamily.Resolver fontFamilyResolver, List<AnnotatedString.Range<Placeholder>> placeholders, int maxLines2, boolean ellipsis) {
        this(new MultiParagraphIntrinsics(annotatedString, style, placeholders, density, fontFamilyResolver), constraints, maxLines2, ellipsis, (DefaultConstructorMarker) null);
    }

    private final AnnotatedString getAnnotatedString() {
        return this.intrinsics.getAnnotatedString();
    }

    public final float getMinIntrinsicWidth() {
        return this.intrinsics.getMaxIntrinsicWidth();
    }

    public final float getMaxIntrinsicWidth() {
        return this.intrinsics.getMaxIntrinsicWidth();
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getFirstBaseline() {
        if (this.paragraphInfoList.isEmpty()) {
            return 0.0f;
        }
        return this.paragraphInfoList.get(0).getParagraph().getFirstBaseline();
    }

    public final float getLastBaseline() {
        if (this.paragraphInfoList.isEmpty()) {
            return 0.0f;
        }
        ParagraphInfo $this$_get_lastBaseline__u24lambda_u240 = (ParagraphInfo) CollectionsKt.last(this.paragraphInfoList);
        return $this$_get_lastBaseline__u24lambda_u240.toGlobalYPosition($this$_get_lastBaseline__u24lambda_u240.getParagraph().getLastBaseline());
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    public final List<ParagraphInfo> getParagraphInfoList$ui_text_release() {
        return this.paragraphInfoList;
    }

    /* renamed from: paint-RPmYEkk$default  reason: not valid java name */
    public static /* synthetic */ void m5357paintRPmYEkk$default(MultiParagraph multiParagraph, Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, int i, Object obj) {
        long j2;
        Shadow shadow2;
        TextDecoration textDecoration2;
        if ((i & 2) != 0) {
            j2 = Color.Companion.m3200getUnspecified0d7_KjU();
        } else {
            j2 = j;
        }
        if ((i & 4) != 0) {
            shadow2 = null;
        } else {
            shadow2 = shadow;
        }
        if ((i & 8) != 0) {
            textDecoration2 = null;
        } else {
            textDecoration2 = textDecoration;
        }
        multiParagraph.m5362paintRPmYEkk(canvas, j2, shadow2, textDecoration2);
    }

    /* renamed from: paint-RPmYEkk  reason: not valid java name */
    public final void m5362paintRPmYEkk(Canvas canvas, long color, Shadow shadow, TextDecoration decoration) {
        Canvas canvas2 = canvas;
        Intrinsics.checkNotNullParameter(canvas2, "canvas");
        canvas.save();
        List $this$fastForEach$iv = this.paragraphInfoList;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            ParagraphInfo it = $this$fastForEach$iv.get(index$iv);
            it.getParagraph().m5370paintRPmYEkk(canvas, color, shadow, decoration);
            canvas2.translate(0.0f, it.getParagraph().getHeight());
        }
        canvas.restore();
    }

    /* renamed from: paint-LG529CI$default  reason: not valid java name */
    public static /* synthetic */ void m5356paintLG529CI$default(MultiParagraph multiParagraph, Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i, int i2, Object obj) {
        long j2;
        Shadow shadow2;
        TextDecoration textDecoration2;
        if ((i2 & 2) != 0) {
            j2 = Color.Companion.m3200getUnspecified0d7_KjU();
        } else {
            j2 = j;
        }
        DrawStyle drawStyle2 = null;
        if ((i2 & 4) != 0) {
            shadow2 = null;
        } else {
            shadow2 = shadow;
        }
        if ((i2 & 8) != 0) {
            textDecoration2 = null;
        } else {
            textDecoration2 = textDecoration;
        }
        if ((i2 & 16) == 0) {
            drawStyle2 = drawStyle;
        }
        multiParagraph.m5361paintLG529CI(canvas, j2, shadow2, textDecoration2, drawStyle2, (i2 & 32) != 0 ? DrawScope.Companion.m3773getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: paint-LG529CI  reason: not valid java name */
    public final void m5361paintLG529CI(Canvas canvas, long color, Shadow shadow, TextDecoration decoration, DrawStyle drawStyle, int blendMode) {
        Canvas canvas2 = canvas;
        Intrinsics.checkNotNullParameter(canvas2, "canvas");
        canvas.save();
        List $this$fastForEach$iv = this.paragraphInfoList;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            ParagraphInfo it = $this$fastForEach$iv.get(index$iv);
            it.getParagraph().m5369paintLG529CI(canvas, color, shadow, decoration, drawStyle, blendMode);
            canvas2.translate(0.0f, it.getParagraph().getHeight());
        }
        canvas.restore();
    }

    /* renamed from: paint-hn5TExg$default  reason: not valid java name */
    public static /* synthetic */ void m5358painthn5TExg$default(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i, int i2, Object obj) {
        float f2;
        Shadow shadow2;
        TextDecoration textDecoration2;
        DrawStyle drawStyle2;
        if ((i2 & 4) != 0) {
            f2 = Float.NaN;
        } else {
            f2 = f;
        }
        if ((i2 & 8) != 0) {
            shadow2 = null;
        } else {
            shadow2 = shadow;
        }
        if ((i2 & 16) != 0) {
            textDecoration2 = null;
        } else {
            textDecoration2 = textDecoration;
        }
        if ((i2 & 32) != 0) {
            drawStyle2 = null;
        } else {
            drawStyle2 = drawStyle;
        }
        multiParagraph.m5363painthn5TExg(canvas, brush, f2, shadow2, textDecoration2, drawStyle2, (i2 & 64) != 0 ? DrawScope.Companion.m3773getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: paint-hn5TExg  reason: not valid java name */
    public final void m5363painthn5TExg(Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration decoration, DrawStyle drawStyle, int blendMode) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(brush, "brush");
        AndroidMultiParagraphDrawKt.m5703drawMultiParagraph7AXcY_I(this, canvas, brush, alpha, shadow, decoration, drawStyle, blendMode);
    }

    public final Path getPathForRange(int start, int end) {
        boolean z = true;
        if (!(start >= 0 && start <= end) || end > getAnnotatedString().getText().length()) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException(("Start(" + start + ") or End(" + end + ") is out of range [0.." + getAnnotatedString().getText().length() + "), or start > end!").toString());
        } else if (start == end) {
            return AndroidPath_androidKt.Path();
        } else {
            int paragraphIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, start);
            Path path = AndroidPath_androidKt.Path();
            int size = this.paragraphInfoList.size();
            for (int i = paragraphIndex; i < size; i++) {
                ParagraphInfo p = this.paragraphInfoList.get(i);
                if (p.getStartIndex() >= end) {
                    break;
                }
                if (p.getStartIndex() != p.getEndIndex()) {
                    ParagraphInfo $this$getPathForRange_u24lambda_u2410 = p;
                    Path.m3441addPathUv8p0NA$default(path, $this$getPathForRange_u24lambda_u2410.toGlobal($this$getPathForRange_u24lambda_u2410.getParagraph().getPathForRange($this$getPathForRange_u24lambda_u2410.toLocalIndex(start), $this$getPathForRange_u24lambda_u2410.toLocalIndex(end))), 0, 2, (Object) null);
                }
            }
            return path;
        }
    }

    public final int getLineForVerticalPosition(float vertical) {
        int paragraphIndex;
        if (vertical <= 0.0f) {
            paragraphIndex = 0;
        } else if (vertical >= this.height) {
            paragraphIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            paragraphIndex = MultiParagraphKt.findParagraphByY(this.paragraphInfoList, vertical);
        }
        ParagraphInfo $this$getLineForVerticalPosition_u24lambda_u2411 = this.paragraphInfoList.get(paragraphIndex);
        if ($this$getLineForVerticalPosition_u24lambda_u2411.getLength() == 0) {
            return Math.max(0, $this$getLineForVerticalPosition_u24lambda_u2411.getStartIndex() - 1);
        }
        return $this$getLineForVerticalPosition_u24lambda_u2411.toGlobalLineIndex($this$getLineForVerticalPosition_u24lambda_u2411.getParagraph().getLineForVerticalPosition($this$getLineForVerticalPosition_u24lambda_u2411.toLocalYPosition(vertical)));
    }

    /* renamed from: getOffsetForPosition-k-4lQ0M  reason: not valid java name */
    public final int m5359getOffsetForPositionk4lQ0M(long position) {
        int paragraphIndex;
        if (Offset.m2916getYimpl(position) <= 0.0f) {
            paragraphIndex = 0;
        } else if (Offset.m2916getYimpl(position) >= this.height) {
            paragraphIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            paragraphIndex = MultiParagraphKt.findParagraphByY(this.paragraphInfoList, Offset.m2916getYimpl(position));
        }
        ParagraphInfo $this$getOffsetForPosition_k_4lQ0M_u24lambda_u2412 = this.paragraphInfoList.get(paragraphIndex);
        if ($this$getOffsetForPosition_k_4lQ0M_u24lambda_u2412.getLength() == 0) {
            return Math.max(0, $this$getOffsetForPosition_k_4lQ0M_u24lambda_u2412.getStartIndex() - 1);
        }
        return $this$getOffsetForPosition_k_4lQ0M_u24lambda_u2412.toGlobalIndex($this$getOffsetForPosition_k_4lQ0M_u24lambda_u2412.getParagraph().m5367getOffsetForPositionk4lQ0M($this$getOffsetForPosition_k_4lQ0M_u24lambda_u2412.m5373toLocalMKHz9U(position)));
    }

    public final Rect getBoundingBox(int offset) {
        requireIndexInRange(offset);
        ParagraphInfo $this$getBoundingBox_u24lambda_u2413 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return $this$getBoundingBox_u24lambda_u2413.toGlobal($this$getBoundingBox_u24lambda_u2413.getParagraph().getBoundingBox($this$getBoundingBox_u24lambda_u2413.toLocalIndex(offset)));
    }

    public final float getHorizontalPosition(int offset, boolean usePrimaryDirection) {
        int paragraphIndex;
        requireIndexInRangeInclusiveEnd(offset);
        if (offset == getAnnotatedString().length()) {
            paragraphIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            paragraphIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
        }
        ParagraphInfo $this$getHorizontalPosition_u24lambda_u2414 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getHorizontalPosition_u24lambda_u2414.getParagraph().getHorizontalPosition($this$getHorizontalPosition_u24lambda_u2414.toLocalIndex(offset), usePrimaryDirection);
    }

    public final ResolvedTextDirection getParagraphDirection(int offset) {
        int paragraphIndex;
        requireIndexInRangeInclusiveEnd(offset);
        if (offset == getAnnotatedString().length()) {
            paragraphIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            paragraphIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
        }
        ParagraphInfo $this$getParagraphDirection_u24lambda_u2415 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getParagraphDirection_u24lambda_u2415.getParagraph().getParagraphDirection($this$getParagraphDirection_u24lambda_u2415.toLocalIndex(offset));
    }

    public final ResolvedTextDirection getBidiRunDirection(int offset) {
        int paragraphIndex;
        requireIndexInRangeInclusiveEnd(offset);
        if (offset == getAnnotatedString().length()) {
            paragraphIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            paragraphIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
        }
        ParagraphInfo $this$getBidiRunDirection_u24lambda_u2416 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getBidiRunDirection_u24lambda_u2416.getParagraph().getBidiRunDirection($this$getBidiRunDirection_u24lambda_u2416.toLocalIndex(offset));
    }

    /* renamed from: getWordBoundary--jx7JFs  reason: not valid java name */
    public final long m5360getWordBoundaryjx7JFs(int offset) {
        int paragraphIndex;
        requireIndexInRangeInclusiveEnd(offset);
        if (offset == getAnnotatedString().length()) {
            paragraphIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            paragraphIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
        }
        ParagraphInfo $this$getWordBoundary__jx7JFs_u24lambda_u2417 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getWordBoundary__jx7JFs_u24lambda_u2417.m5372toGlobalGEjPoXI($this$getWordBoundary__jx7JFs_u24lambda_u2417.getParagraph().m5368getWordBoundaryjx7JFs($this$getWordBoundary__jx7JFs_u24lambda_u2417.toLocalIndex(offset)));
    }

    public final Rect getCursorRect(int offset) {
        int paragraphIndex;
        requireIndexInRangeInclusiveEnd(offset);
        if (offset == getAnnotatedString().length()) {
            paragraphIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            paragraphIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
        }
        ParagraphInfo $this$getCursorRect_u24lambda_u2418 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getCursorRect_u24lambda_u2418.toGlobal($this$getCursorRect_u24lambda_u2418.getParagraph().getCursorRect($this$getCursorRect_u24lambda_u2418.toLocalIndex(offset)));
    }

    public final int getLineForOffset(int offset) {
        int paragraphIndex;
        if (offset >= getAnnotatedString().length()) {
            paragraphIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else if (offset < 0) {
            paragraphIndex = 0;
        } else {
            paragraphIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
        }
        ParagraphInfo $this$getLineForOffset_u24lambda_u2419 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getLineForOffset_u24lambda_u2419.toGlobalLineIndex($this$getLineForOffset_u24lambda_u2419.getParagraph().getLineForOffset($this$getLineForOffset_u24lambda_u2419.toLocalIndex(offset)));
    }

    public final float getLineLeft(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo $this$getLineLeft_u24lambda_u2420 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return $this$getLineLeft_u24lambda_u2420.getParagraph().getLineLeft($this$getLineLeft_u24lambda_u2420.toLocalLineIndex(lineIndex));
    }

    public final float getLineRight(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo $this$getLineRight_u24lambda_u2421 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return $this$getLineRight_u24lambda_u2421.getParagraph().getLineRight($this$getLineRight_u24lambda_u2421.toLocalLineIndex(lineIndex));
    }

    public final float getLineTop(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo $this$getLineTop_u24lambda_u2422 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return $this$getLineTop_u24lambda_u2422.toGlobalYPosition($this$getLineTop_u24lambda_u2422.getParagraph().getLineTop($this$getLineTop_u24lambda_u2422.toLocalLineIndex(lineIndex)));
    }

    public final float getLineBottom(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo $this$getLineBottom_u24lambda_u2423 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return $this$getLineBottom_u24lambda_u2423.toGlobalYPosition($this$getLineBottom_u24lambda_u2423.getParagraph().getLineBottom($this$getLineBottom_u24lambda_u2423.toLocalLineIndex(lineIndex)));
    }

    public final float getLineHeight(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo $this$getLineHeight_u24lambda_u2424 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return $this$getLineHeight_u24lambda_u2424.getParagraph().getLineHeight($this$getLineHeight_u24lambda_u2424.toLocalLineIndex(lineIndex));
    }

    public final float getLineWidth(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo $this$getLineWidth_u24lambda_u2425 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return $this$getLineWidth_u24lambda_u2425.getParagraph().getLineWidth($this$getLineWidth_u24lambda_u2425.toLocalLineIndex(lineIndex));
    }

    public final int getLineStart(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo $this$getLineStart_u24lambda_u2426 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return $this$getLineStart_u24lambda_u2426.toGlobalIndex($this$getLineStart_u24lambda_u2426.getParagraph().getLineStart($this$getLineStart_u24lambda_u2426.toLocalLineIndex(lineIndex)));
    }

    public static /* synthetic */ int getLineEnd$default(MultiParagraph multiParagraph, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return multiParagraph.getLineEnd(i, z);
    }

    public final int getLineEnd(int lineIndex, boolean visibleEnd) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo $this$getLineEnd_u24lambda_u2427 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return $this$getLineEnd_u24lambda_u2427.toGlobalIndex($this$getLineEnd_u24lambda_u2427.getParagraph().getLineEnd($this$getLineEnd_u24lambda_u2427.toLocalLineIndex(lineIndex), visibleEnd));
    }

    public final boolean isLineEllipsized(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        return this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex)).getParagraph().isLineEllipsized(lineIndex);
    }

    private final void requireIndexInRange(int offset) {
        boolean z = false;
        if (offset >= 0 && offset < getAnnotatedString().getText().length()) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException(("offset(" + offset + ") is out of bounds [0, " + getAnnotatedString().length() + ')').toString());
        }
    }

    private final void requireIndexInRangeInclusiveEnd(int offset) {
        boolean z = false;
        if (offset >= 0 && offset <= getAnnotatedString().getText().length()) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException(("offset(" + offset + ") is out of bounds [0, " + getAnnotatedString().length() + ']').toString());
        }
    }

    private final void requireLineIndexInRange(int lineIndex) {
        boolean z = false;
        if (lineIndex >= 0 && lineIndex < this.lineCount) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException(("lineIndex(" + lineIndex + ") is out of bounds [0, " + this.lineCount + ')').toString());
        }
    }
}
