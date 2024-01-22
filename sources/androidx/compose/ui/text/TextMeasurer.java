package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#Jw\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020$2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006("}, d2 = {"Landroidx/compose/ui/text/TextMeasurer;", "", "fallbackFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fallbackDensity", "Landroidx/compose/ui/unit/Density;", "fallbackLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "cacheSize", "", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;I)V", "textLayoutCache", "Landroidx/compose/ui/text/TextLayoutCache;", "measure", "Landroidx/compose/ui/text/TextLayoutResult;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "density", "fontFamilyResolver", "skipCache", "measure-xDpz5zY", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;IZILjava/util/List;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "", "measure-wNUYSr0", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;IZIJLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextMeasurer.kt */
public final class TextMeasurer {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int cacheSize;
    private final Density fallbackDensity;
    private final FontFamily.Resolver fallbackFontFamilyResolver;
    private final LayoutDirection fallbackLayoutDirection;
    private final TextLayoutCache textLayoutCache;

    public TextMeasurer(FontFamily.Resolver fallbackFontFamilyResolver2, Density fallbackDensity2, LayoutDirection fallbackLayoutDirection2, int cacheSize2) {
        TextLayoutCache textLayoutCache2;
        Intrinsics.checkNotNullParameter(fallbackFontFamilyResolver2, "fallbackFontFamilyResolver");
        Intrinsics.checkNotNullParameter(fallbackDensity2, "fallbackDensity");
        Intrinsics.checkNotNullParameter(fallbackLayoutDirection2, "fallbackLayoutDirection");
        this.fallbackFontFamilyResolver = fallbackFontFamilyResolver2;
        this.fallbackDensity = fallbackDensity2;
        this.fallbackLayoutDirection = fallbackLayoutDirection2;
        this.cacheSize = cacheSize2;
        if (cacheSize2 > 0) {
            textLayoutCache2 = new TextLayoutCache(cacheSize2);
        } else {
            textLayoutCache2 = null;
        }
        this.textLayoutCache = textLayoutCache2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextMeasurer(FontFamily.Resolver resolver, Density density, LayoutDirection layoutDirection, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(resolver, density, layoutDirection, (i2 & 8) != 0 ? TextMeasurerKt.DefaultCacheSize : i);
    }

    /* renamed from: measure-xDpz5zY$default  reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m5450measurexDpz5zY$default(TextMeasurer textMeasurer, AnnotatedString annotatedString, TextStyle textStyle, int i, boolean z, int i2, List list, long j, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z2, int i3, Object obj) {
        TextStyle textStyle2;
        int i4;
        boolean z3;
        int i5;
        List list2;
        LayoutDirection layoutDirection2;
        Density density2;
        FontFamily.Resolver resolver2;
        boolean z4;
        TextMeasurer textMeasurer2 = textMeasurer;
        int i6 = i3;
        if ((i6 & 2) != 0) {
            textStyle2 = TextStyle.Companion.getDefault();
        } else {
            textStyle2 = textStyle;
        }
        if ((i6 & 4) != 0) {
            i4 = TextOverflow.Companion.m5898getClipgIe3tQ8();
        } else {
            i4 = i;
        }
        if ((i6 & 8) != 0) {
            z3 = true;
        } else {
            z3 = z;
        }
        if ((i6 & 16) != 0) {
            i5 = Integer.MAX_VALUE;
        } else {
            i5 = i2;
        }
        if ((i6 & 32) != 0) {
            list2 = CollectionsKt.emptyList();
        } else {
            list2 = list;
        }
        long Constraints$default = (i6 & 64) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null) : j;
        if ((i6 & 128) != 0) {
            layoutDirection2 = textMeasurer2.fallbackLayoutDirection;
        } else {
            layoutDirection2 = layoutDirection;
        }
        if ((i6 & 256) != 0) {
            density2 = textMeasurer2.fallbackDensity;
        } else {
            density2 = density;
        }
        if ((i6 & 512) != 0) {
            resolver2 = textMeasurer2.fallbackFontFamilyResolver;
        } else {
            resolver2 = resolver;
        }
        if ((i6 & 1024) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        return textMeasurer.m5452measurexDpz5zY(annotatedString, textStyle2, i4, z3, i5, list2, Constraints$default, layoutDirection2, density2, resolver2, z4);
    }

    /* renamed from: measure-xDpz5zY  reason: not valid java name */
    public final TextLayoutResult m5452measurexDpz5zY(AnnotatedString text, TextStyle style, int overflow, boolean softWrap, int maxLines, List<AnnotatedString.Range<Placeholder>> placeholders, long constraints, LayoutDirection layoutDirection, Density density, FontFamily.Resolver fontFamilyResolver, boolean skipCache) {
        TextLayoutResult cacheResult;
        TextLayoutCache textLayoutCache2;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        TextLayoutInput textLayoutInput = new TextLayoutInput(text, style, (List) placeholders, maxLines, softWrap, overflow, density, layoutDirection, fontFamilyResolver, constraints, (DefaultConstructorMarker) null);
        if (skipCache || (textLayoutCache2 = this.textLayoutCache) == null) {
            cacheResult = null;
        } else {
            cacheResult = textLayoutCache2.get(textLayoutInput);
        }
        if (cacheResult != null) {
            return cacheResult.m5445copyO0kMr_c(textLayoutInput, ConstraintsKt.m5941constrain4WqzIAM(constraints, IntSizeKt.IntSize(ParagraphKt.ceilToInt(cacheResult.getMultiParagraph().getWidth()), ParagraphKt.ceilToInt(cacheResult.getMultiParagraph().getHeight()))));
        }
        long j = constraints;
        TextLayoutResult access$layout = Companion.layout(textLayoutInput);
        TextLayoutResult it = access$layout;
        TextLayoutCache textLayoutCache3 = this.textLayoutCache;
        if (textLayoutCache3 == null) {
            return access$layout;
        }
        textLayoutCache3.put(textLayoutInput, it);
        return access$layout;
    }

    /* renamed from: measure-wNUYSr0$default  reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m5449measurewNUYSr0$default(TextMeasurer textMeasurer, String str, TextStyle textStyle, int i, boolean z, int i2, long j, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z2, int i3, Object obj) {
        TextStyle textStyle2;
        int i4;
        boolean z3;
        int i5;
        LayoutDirection layoutDirection2;
        Density density2;
        FontFamily.Resolver resolver2;
        boolean z4;
        TextMeasurer textMeasurer2 = textMeasurer;
        int i6 = i3;
        if ((i6 & 2) != 0) {
            textStyle2 = TextStyle.Companion.getDefault();
        } else {
            textStyle2 = textStyle;
        }
        if ((i6 & 4) != 0) {
            i4 = TextOverflow.Companion.m5898getClipgIe3tQ8();
        } else {
            i4 = i;
        }
        if ((i6 & 8) != 0) {
            z3 = true;
        } else {
            z3 = z;
        }
        if ((i6 & 16) != 0) {
            i5 = Integer.MAX_VALUE;
        } else {
            i5 = i2;
        }
        long Constraints$default = (i6 & 32) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null) : j;
        if ((i6 & 64) != 0) {
            layoutDirection2 = textMeasurer2.fallbackLayoutDirection;
        } else {
            layoutDirection2 = layoutDirection;
        }
        if ((i6 & 128) != 0) {
            density2 = textMeasurer2.fallbackDensity;
        } else {
            density2 = density;
        }
        if ((i6 & 256) != 0) {
            resolver2 = textMeasurer2.fallbackFontFamilyResolver;
        } else {
            resolver2 = resolver;
        }
        if ((i6 & 512) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        return textMeasurer.m5451measurewNUYSr0(str, textStyle2, i4, z3, i5, Constraints$default, layoutDirection2, density2, resolver2, z4);
    }

    /* renamed from: measure-wNUYSr0  reason: not valid java name */
    public final TextLayoutResult m5451measurewNUYSr0(String text, TextStyle style, int overflow, boolean softWrap, int maxLines, long constraints, LayoutDirection layoutDirection, Density density, FontFamily.Resolver fontFamilyResolver, boolean skipCache) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        return m5450measurexDpz5zY$default(this, new AnnotatedString(text, (List) null, (List) null, 6, (DefaultConstructorMarker) null), style, overflow, softWrap, maxLines, (List) null, constraints, layoutDirection, density, fontFamilyResolver, skipCache, 32, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/TextMeasurer$Companion;", "", "()V", "layout", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextMeasurer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final TextLayoutResult layout(TextLayoutInput textLayoutInput) {
            int maxWidth;
            int width;
            TextLayoutInput $this$layout_u24lambda_u240 = textLayoutInput;
            MultiParagraphIntrinsics multiParagraphIntrinsics = new MultiParagraphIntrinsics($this$layout_u24lambda_u240.getText(), TextStyleKt.resolveDefaults($this$layout_u24lambda_u240.getStyle(), $this$layout_u24lambda_u240.getLayoutDirection()), $this$layout_u24lambda_u240.getPlaceholders(), $this$layout_u24lambda_u240.getDensity(), $this$layout_u24lambda_u240.getFontFamilyResolver());
            int minWidth = Constraints.m5932getMinWidthimpl($this$layout_u24lambda_u240.m5442getConstraintsmsEJaDk());
            boolean overwriteMaxLines = false;
            int i = 1;
            if (!($this$layout_u24lambda_u240.getSoftWrap() || TextOverflow.m5891equalsimpl0($this$layout_u24lambda_u240.m5443getOverflowgIe3tQ8(), TextOverflow.Companion.m5899getEllipsisgIe3tQ8())) || !Constraints.m5926getHasBoundedWidthimpl($this$layout_u24lambda_u240.m5442getConstraintsmsEJaDk())) {
                maxWidth = Integer.MAX_VALUE;
            } else {
                maxWidth = Constraints.m5930getMaxWidthimpl($this$layout_u24lambda_u240.m5442getConstraintsmsEJaDk());
            }
            if (!$this$layout_u24lambda_u240.getSoftWrap() && TextOverflow.m5891equalsimpl0($this$layout_u24lambda_u240.m5443getOverflowgIe3tQ8(), TextOverflow.Companion.m5899getEllipsisgIe3tQ8())) {
                overwriteMaxLines = true;
            }
            if (!overwriteMaxLines) {
                i = $this$layout_u24lambda_u240.getMaxLines();
            }
            int finalMaxLines = i;
            if (minWidth == maxWidth) {
                width = maxWidth;
            } else {
                width = RangesKt.coerceIn(ParagraphKt.ceilToInt(multiParagraphIntrinsics.getMaxIntrinsicWidth()), minWidth, maxWidth);
            }
            MultiParagraph multiParagraph = new MultiParagraph(multiParagraphIntrinsics, ConstraintsKt.Constraints$default(0, width, 0, Constraints.m5929getMaxHeightimpl($this$layout_u24lambda_u240.m5442getConstraintsmsEJaDk()), 5, (Object) null), finalMaxLines, TextOverflow.m5891equalsimpl0($this$layout_u24lambda_u240.m5443getOverflowgIe3tQ8(), TextOverflow.Companion.m5899getEllipsisgIe3tQ8()), (DefaultConstructorMarker) null);
            return new TextLayoutResult(textLayoutInput, multiParagraph, ConstraintsKt.m5941constrain4WqzIAM($this$layout_u24lambda_u240.m5442getConstraintsmsEJaDk(), IntSizeKt.IntSize((int) ((float) Math.ceil((double) multiParagraph.getWidth())), (int) ((float) Math.ceil((double) multiParagraph.getHeight())))), (DefaultConstructorMarker) null);
        }
    }
}
