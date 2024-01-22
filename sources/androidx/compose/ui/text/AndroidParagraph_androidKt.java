package androidx.compose.ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u001d\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\t\u001a\u001d\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\r\u001a\u001d\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0011\u001a\u001d\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0015\u001a\u001d\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0019\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\u001bH\u0002\u001a\u0014\u0010\u001c\u001a\u00020\u0006*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"shouldAttachIndentationFixSpan", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "ellipsis", "toLayoutAlign", "", "align", "Landroidx/compose/ui/text/style/TextAlign;", "toLayoutAlign-AMY3VfE", "toLayoutBreakStrategy", "breakStrategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "toLayoutBreakStrategy-u6PBz3U", "toLayoutHyphenationFrequency", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "toLayoutHyphenationFrequency-0_XeFpE", "toLayoutLineBreakStyle", "lineBreakStrictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "toLayoutLineBreakStyle-4a2g8L8", "toLayoutLineBreakWordStyle", "lineBreakWordStyle", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "toLayoutLineBreakWordStyle-gvcdTPQ", "attachIndentationFixSpan", "", "numberOfLinesThatFitMaxHeight", "Landroidx/compose/ui/text/android/TextLayout;", "maxHeight", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidParagraph.android.kt */
public final class AndroidParagraph_androidKt {
    /* access modifiers changed from: private */
    /* renamed from: toLayoutAlign-AMY3VfE  reason: not valid java name */
    public static final int m5341toLayoutAlignAMY3VfE(TextAlign align) {
        if (align == null ? false : TextAlign.m5845equalsimpl0(align.m5848unboximpl(), TextAlign.Companion.m5852getLefte0LSkKk())) {
            return 3;
        }
        if (align == null ? false : TextAlign.m5845equalsimpl0(align.m5848unboximpl(), TextAlign.Companion.m5853getRighte0LSkKk())) {
            return 4;
        }
        if (align == null ? false : TextAlign.m5845equalsimpl0(align.m5848unboximpl(), TextAlign.Companion.m5849getCentere0LSkKk())) {
            return 2;
        }
        if (align == null ? false : TextAlign.m5845equalsimpl0(align.m5848unboximpl(), TextAlign.Companion.m5854getStarte0LSkKk())) {
            return 0;
        }
        if (align == null ? false : TextAlign.m5845equalsimpl0(align.m5848unboximpl(), TextAlign.Companion.m5850getEnde0LSkKk())) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: toLayoutHyphenationFrequency-0_XeFpE  reason: not valid java name */
    public static final int m5343toLayoutHyphenationFrequency0_XeFpE(Hyphens hyphens) {
        if (!(hyphens == null ? false : Hyphens.m5760equalsimpl0(hyphens.m5763unboximpl(), Hyphens.Companion.m5764getAutovmbZdU8()))) {
            int r0 = Hyphens.Companion.m5765getNonevmbZdU8();
            if (hyphens == null) {
                return 0;
            }
            Hyphens.m5760equalsimpl0(hyphens.m5763unboximpl(), r0);
            return 0;
        } else if (Build.VERSION.SDK_INT <= 32) {
            return 1;
        } else {
            return 3;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: toLayoutBreakStrategy-u6PBz3U  reason: not valid java name */
    public static final int m5342toLayoutBreakStrategyu6PBz3U(LineBreak.Strategy breakStrategy) {
        if (breakStrategy == null ? false : LineBreak.Strategy.m5785equalsimpl0(breakStrategy.m5788unboximpl(), LineBreak.Strategy.Companion.m5791getSimplefcGXIks())) {
            return 0;
        }
        if (breakStrategy == null ? false : LineBreak.Strategy.m5785equalsimpl0(breakStrategy.m5788unboximpl(), LineBreak.Strategy.Companion.m5790getHighQualityfcGXIks())) {
            return 1;
        }
        if (breakStrategy == null ? false : LineBreak.Strategy.m5785equalsimpl0(breakStrategy.m5788unboximpl(), LineBreak.Strategy.Companion.m5789getBalancedfcGXIks())) {
            return 2;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakStyle-4a2g8L8  reason: not valid java name */
    public static final int m5344toLayoutLineBreakStyle4a2g8L8(LineBreak.Strictness lineBreakStrictness) {
        if (lineBreakStrictness == null ? false : LineBreak.Strictness.m5795equalsimpl0(lineBreakStrictness.m5798unboximpl(), LineBreak.Strictness.Companion.m5799getDefaultusljTpc())) {
            return 0;
        }
        if (lineBreakStrictness == null ? false : LineBreak.Strictness.m5795equalsimpl0(lineBreakStrictness.m5798unboximpl(), LineBreak.Strictness.Companion.m5800getLooseusljTpc())) {
            return 1;
        }
        if (lineBreakStrictness == null ? false : LineBreak.Strictness.m5795equalsimpl0(lineBreakStrictness.m5798unboximpl(), LineBreak.Strictness.Companion.m5801getNormalusljTpc())) {
            return 2;
        }
        if (lineBreakStrictness == null ? false : LineBreak.Strictness.m5795equalsimpl0(lineBreakStrictness.m5798unboximpl(), LineBreak.Strictness.Companion.m5802getStrictusljTpc())) {
            return 3;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakWordStyle-gvcdTPQ  reason: not valid java name */
    public static final int m5345toLayoutLineBreakWordStylegvcdTPQ(LineBreak.WordBreak lineBreakWordStyle) {
        if (lineBreakWordStyle == null ? false : LineBreak.WordBreak.m5806equalsimpl0(lineBreakWordStyle.m5809unboximpl(), LineBreak.WordBreak.Companion.m5810getDefaultjp8hJ3c())) {
            return 0;
        }
        if (lineBreakWordStyle == null ? false : LineBreak.WordBreak.m5806equalsimpl0(lineBreakWordStyle.m5809unboximpl(), LineBreak.WordBreak.Companion.m5811getPhrasejp8hJ3c())) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout $this$numberOfLinesThatFitMaxHeight, int maxHeight) {
        int lineCount = $this$numberOfLinesThatFitMaxHeight.getLineCount();
        for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
            if ($this$numberOfLinesThatFitMaxHeight.getLineBottom(lineIndex) > ((float) maxHeight)) {
                return lineIndex;
            }
        }
        return $this$numberOfLinesThatFitMaxHeight.getLineCount();
    }

    /* access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean ellipsis) {
        TextStyle $this$shouldAttachIndentationFixSpan_u24lambda_u240 = textStyle;
        if (!ellipsis || TextUnit.m6164equalsimpl0($this$shouldAttachIndentationFixSpan_u24lambda_u240.m5499getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) || TextUnit.m6164equalsimpl0($this$shouldAttachIndentationFixSpan_u24lambda_u240.m5499getLetterSpacingXSAIIZE(), TextUnit.Companion.m6178getUnspecifiedXSAIIZE()) || $this$shouldAttachIndentationFixSpan_u24lambda_u240.m5502getTextAlignbuA522U() == null) {
            return false;
        }
        TextAlign r3 = $this$shouldAttachIndentationFixSpan_u24lambda_u240.m5502getTextAlignbuA522U();
        if (r3 == null ? false : TextAlign.m5845equalsimpl0(r3.m5848unboximpl(), TextAlign.Companion.m5854getStarte0LSkKk())) {
            return false;
        }
        TextAlign r32 = $this$shouldAttachIndentationFixSpan_u24lambda_u240.m5502getTextAlignbuA522U();
        if (!(r32 == null ? false : TextAlign.m5845equalsimpl0(r32.m5848unboximpl(), TextAlign.Companion.m5851getJustifye0LSkKk()))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence $this$attachIndentationFixSpan) {
        if ($this$attachIndentationFixSpan.length() == 0) {
            return $this$attachIndentationFixSpan;
        }
        Spannable spannable = $this$attachIndentationFixSpan instanceof Spannable ? (Spannable) $this$attachIndentationFixSpan : new SpannableString($this$attachIndentationFixSpan);
        SpannableExtensions_androidKt.setSpan(spannable, new IndentationFixSpan(), spannable.length() - 1, spannable.length() - 1);
        return spannable;
    }
}
