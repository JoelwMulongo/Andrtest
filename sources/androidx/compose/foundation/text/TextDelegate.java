package androidx.compose.foundation.text;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 G2\u00020\u0001:\u0001GBf\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012ø\u0001\u0000¢\u0006\u0002\u0010\u0015J/\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u001b2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010:ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u000e\u0010A\u001a\u00020B2\u0006\u0010=\u001a\u00020\u001bJ%\u0010C\u001a\u00020D2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u001bH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010FR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010$\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b%\u0010\"R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020(8BX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u001c\u0010\u000b\u001a\u00020\fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010,\u001a\u0004\b+\u0010\"R\u001c\u0010-\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u00100R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u00108\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006H"}, d2 = {"Landroidx/compose/foundation/text/TextDelegate;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "maxLines", "", "minLines", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;IIZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getIntrinsicsLayoutDirection$foundation_release", "()Landroidx/compose/ui/unit/LayoutDirection;", "setIntrinsicsLayoutDirection$foundation_release", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "()I", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "getMinLines", "nonNullIntrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "getNonNullIntrinsics", "()Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "getOverflow-gIe3tQ8", "I", "paragraphIntrinsics", "getParagraphIntrinsics$foundation_release", "setParagraphIntrinsics$foundation_release", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;)V", "getPlaceholders", "()Ljava/util/List;", "getSoftWrap", "()Z", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getText", "()Landroidx/compose/ui/text/AnnotatedString;", "layout", "Landroidx/compose/ui/text/TextLayoutResult;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "prevResult", "layout-NN6Ew-U", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextLayoutResult;)Landroidx/compose/ui/text/TextLayoutResult;", "layoutIntrinsics", "", "layoutText", "Landroidx/compose/ui/text/MultiParagraph;", "layoutText-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/MultiParagraph;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextDelegate.kt */
public final class TextDelegate {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Density density;
    private final FontFamily.Resolver fontFamilyResolver;
    private LayoutDirection intrinsicsLayoutDirection;
    private final int maxLines;
    private final int minLines;
    private final int overflow;
    private MultiParagraphIntrinsics paragraphIntrinsics;
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    private final boolean softWrap;
    private final TextStyle style;
    private final AnnotatedString text;

    public /* synthetic */ TextDelegate(AnnotatedString annotatedString, TextStyle textStyle, int i, int i2, boolean z, int i3, Density density2, FontFamily.Resolver resolver, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, i, i2, z, i3, density2, resolver, list);
    }

    private TextDelegate(AnnotatedString text2, TextStyle style2, int maxLines2, int minLines2, boolean softWrap2, int overflow2, Density density2, FontFamily.Resolver fontFamilyResolver2, List<AnnotatedString.Range<Placeholder>> placeholders2) {
        this.text = text2;
        this.style = style2;
        this.maxLines = maxLines2;
        this.minLines = minLines2;
        this.softWrap = softWrap2;
        this.overflow = overflow2;
        this.density = density2;
        this.fontFamilyResolver = fontFamilyResolver2;
        this.placeholders = placeholders2;
        boolean z = true;
        if (maxLines2 > 0) {
            if (minLines2 > 0) {
                if (!(minLines2 > maxLines2 ? false : z)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextDelegate(androidx.compose.ui.text.AnnotatedString r14, androidx.compose.ui.text.TextStyle r15, int r16, int r17, boolean r18, int r19, androidx.compose.ui.unit.Density r20, androidx.compose.ui.text.font.FontFamily.Resolver r21, java.util.List r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 4
            if (r1 == 0) goto L_0x000b
            r1 = 2147483647(0x7fffffff, float:NaN)
            r5 = r1
            goto L_0x000d
        L_0x000b:
            r5 = r16
        L_0x000d:
            r1 = r0 & 8
            r2 = 1
            if (r1 == 0) goto L_0x0014
            r6 = r2
            goto L_0x0016
        L_0x0014:
            r6 = r17
        L_0x0016:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x001c
            r7 = r2
            goto L_0x001e
        L_0x001c:
            r7 = r18
        L_0x001e:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x002a
            androidx.compose.ui.text.style.TextOverflow$Companion r1 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r1 = r1.m5898getClipgIe3tQ8()
            r8 = r1
            goto L_0x002c
        L_0x002a:
            r8 = r19
        L_0x002c:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0036
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r11 = r0
            goto L_0x0038
        L_0x0036:
            r11 = r22
        L_0x0038:
            r12 = 0
            r2 = r13
            r3 = r14
            r4 = r15
            r9 = r20
            r10 = r21
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextDelegate.<init>(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, int, int, boolean, int, androidx.compose.ui.unit.Density, androidx.compose.ui.text.font.FontFamily$Resolver, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final AnnotatedString getText() {
        return this.text;
    }

    public final TextStyle getStyle() {
        return this.style;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final int getMinLines() {
        return this.minLines;
    }

    public final boolean getSoftWrap() {
        return this.softWrap;
    }

    /* renamed from: getOverflow-gIe3tQ8  reason: not valid java name */
    public final int m1200getOverflowgIe3tQ8() {
        return this.overflow;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    public final MultiParagraphIntrinsics getParagraphIntrinsics$foundation_release() {
        return this.paragraphIntrinsics;
    }

    public final void setParagraphIntrinsics$foundation_release(MultiParagraphIntrinsics multiParagraphIntrinsics) {
        this.paragraphIntrinsics = multiParagraphIntrinsics;
    }

    public final LayoutDirection getIntrinsicsLayoutDirection$foundation_release() {
        return this.intrinsicsLayoutDirection;
    }

    public final void setIntrinsicsLayoutDirection$foundation_release(LayoutDirection layoutDirection) {
        this.intrinsicsLayoutDirection = layoutDirection;
    }

    private final MultiParagraphIntrinsics getNonNullIntrinsics() {
        MultiParagraphIntrinsics multiParagraphIntrinsics = this.paragraphIntrinsics;
        if (multiParagraphIntrinsics != null) {
            return multiParagraphIntrinsics;
        }
        throw new IllegalStateException("layoutIntrinsics must be called first");
    }

    public final int getMinIntrinsicWidth() {
        return TextDelegateKt.ceilToIntPx(getNonNullIntrinsics().getMinIntrinsicWidth());
    }

    public final int getMaxIntrinsicWidth() {
        return TextDelegateKt.ceilToIntPx(getNonNullIntrinsics().getMaxIntrinsicWidth());
    }

    public final void layoutIntrinsics(LayoutDirection layoutDirection) {
        MultiParagraphIntrinsics intrinsics;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        MultiParagraphIntrinsics localIntrinsics = this.paragraphIntrinsics;
        if (localIntrinsics == null || layoutDirection != this.intrinsicsLayoutDirection || localIntrinsics.getHasStaleResolvedFonts()) {
            this.intrinsicsLayoutDirection = layoutDirection;
            intrinsics = new MultiParagraphIntrinsics(this.text, TextStyleKt.resolveDefaults(this.style, layoutDirection), this.placeholders, this.density, this.fontFamilyResolver);
        } else {
            intrinsics = localIntrinsics;
        }
        this.paragraphIntrinsics = intrinsics;
    }

    /* renamed from: layoutText-K40F9xA  reason: not valid java name */
    private final MultiParagraph m1199layoutTextK40F9xA(long constraints, LayoutDirection layoutDirection) {
        int maxWidth;
        int width;
        layoutIntrinsics(layoutDirection);
        int minWidth = Constraints.m5932getMinWidthimpl(constraints);
        boolean overwriteMaxLines = false;
        int i = 1;
        if (!(this.softWrap || TextOverflow.m5891equalsimpl0(this.overflow, TextOverflow.Companion.m5899getEllipsisgIe3tQ8())) || !Constraints.m5926getHasBoundedWidthimpl(constraints)) {
            maxWidth = Integer.MAX_VALUE;
        } else {
            maxWidth = Constraints.m5930getMaxWidthimpl(constraints);
        }
        if (!this.softWrap && TextOverflow.m5891equalsimpl0(this.overflow, TextOverflow.Companion.m5899getEllipsisgIe3tQ8())) {
            overwriteMaxLines = true;
        }
        if (!overwriteMaxLines) {
            i = this.maxLines;
        }
        int finalMaxLines = i;
        if (minWidth == maxWidth) {
            width = maxWidth;
        } else {
            width = RangesKt.coerceIn(getMaxIntrinsicWidth(), minWidth, maxWidth);
        }
        return new MultiParagraph(getNonNullIntrinsics(), ConstraintsKt.Constraints$default(0, width, 0, Constraints.m5929getMaxHeightimpl(constraints), 5, (Object) null), finalMaxLines, TextOverflow.m5891equalsimpl0(this.overflow, TextOverflow.Companion.m5899getEllipsisgIe3tQ8()), (DefaultConstructorMarker) null);
    }

    /* renamed from: layout-NN6Ew-U$default  reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m1198layoutNN6EwU$default(TextDelegate textDelegate, long j, LayoutDirection layoutDirection, TextLayoutResult textLayoutResult, int i, Object obj) {
        if ((i & 4) != 0) {
            textLayoutResult = null;
        }
        return textDelegate.m1201layoutNN6EwU(j, layoutDirection, textLayoutResult);
    }

    /* renamed from: layout-NN6Ew-U  reason: not valid java name */
    public final TextLayoutResult m1201layoutNN6EwU(long constraints, LayoutDirection layoutDirection, TextLayoutResult prevResult) {
        long j = constraints;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (prevResult != null) {
            if (TextLayoutHelperKt.m1228canReuse7_7YC6M(prevResult, this.text, this.style, this.placeholders, this.maxLines, this.softWrap, this.overflow, this.density, layoutDirection, this.fontFamilyResolver, constraints)) {
                TextLayoutResult $this$layout_NN6Ew_U_u24lambda_u240 = prevResult;
                TextLayoutResult $this$layout_NN6Ew_U_u24lambda_u2402 = $this$layout_NN6Ew_U_u24lambda_u240;
                TextLayoutInput textLayoutInput = r1;
                TextLayoutInput textLayoutInput2 = new TextLayoutInput($this$layout_NN6Ew_U_u24lambda_u240.getLayoutInput().getText(), this.style, (List) $this$layout_NN6Ew_U_u24lambda_u240.getLayoutInput().getPlaceholders(), $this$layout_NN6Ew_U_u24lambda_u240.getLayoutInput().getMaxLines(), $this$layout_NN6Ew_U_u24lambda_u240.getLayoutInput().getSoftWrap(), $this$layout_NN6Ew_U_u24lambda_u240.getLayoutInput().m5443getOverflowgIe3tQ8(), $this$layout_NN6Ew_U_u24lambda_u240.getLayoutInput().getDensity(), $this$layout_NN6Ew_U_u24lambda_u240.getLayoutInput().getLayoutDirection(), $this$layout_NN6Ew_U_u24lambda_u240.getLayoutInput().getFontFamilyResolver(), constraints, (DefaultConstructorMarker) null);
                return $this$layout_NN6Ew_U_u24lambda_u2402.m5445copyO0kMr_c(textLayoutInput, ConstraintsKt.m5941constrain4WqzIAM(j, IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx($this$layout_NN6Ew_U_u24lambda_u2402.getMultiParagraph().getWidth()), TextDelegateKt.ceilToIntPx($this$layout_NN6Ew_U_u24lambda_u2402.getMultiParagraph().getHeight()))));
            }
        }
        MultiParagraph multiParagraph = m1199layoutTextK40F9xA(constraints, layoutDirection);
        return new TextLayoutResult(new TextLayoutInput(this.text, this.style, (List) this.placeholders, this.maxLines, this.softWrap, this.overflow, this.density, layoutDirection, this.fontFamilyResolver, constraints, (DefaultConstructorMarker) null), multiParagraph, ConstraintsKt.m5941constrain4WqzIAM(j, IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(multiParagraph.getWidth()), TextDelegateKt.ceilToIntPx(multiParagraph.getHeight()))), (DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/text/TextDelegate$Companion;", "", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextDelegate.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void paint(Canvas canvas, TextLayoutResult textLayoutResult) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
            TextPainter.INSTANCE.paint(canvas, textLayoutResult);
        }
    }
}
