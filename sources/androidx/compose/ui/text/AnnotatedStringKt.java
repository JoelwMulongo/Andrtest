package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.intl.LocaleList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0016\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\"\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a%\u0010\t\u001a\u00020\u00012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000\u001a(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0000\u001a\b\u0010\u0016\u001a\u00020\u0001H\u0000\u001aD\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001a0\u0019\u0018\u00010\u0018\"\u0004\b\u0000\u0010\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u001a0\u0019\u0018\u00010\u00182\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001a(\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0012H\u0000\u001a\u0014\u0010#\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%\u001a\u0014\u0010&\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%\u001a,\u0010'\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020(0\u0019\u0018\u00010\u0018*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001a*\u0010)\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0019\u0018\u00010\u0018*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001a*\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0019\u0018\u00010\u0018*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001ad\u0010+\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0018\"\u0004\b\u0000\u0010\u001a*\u00020\u00012\u0006\u0010,\u001a\u00020\u00062>\b\u0004\u0010-\u001a8\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0019¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u0002H\u001a0.H\bø\u0001\u0000\u001a \u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00190\u0018*\u00020\u00012\u0006\u0010,\u001a\u00020\u0006H\u0000\u001a\u001c\u00103\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001a\u0014\u00104\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%\u001a\u0014\u00105\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%\u001aB\u00106\u001a\u0002H7\"\b\b\u0000\u00107*\u00020(*\u00020\f2\u0006\u00108\u001a\u0002092\u0019\b\u0004\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H70\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000¢\u0006\u0002\u0010:\u001aB\u00106\u001a\u0002H7\"\b\b\u0000\u00107*\u00020(*\u00020\f2\u0006\u0010;\u001a\u00020<2\u0019\b\u0004\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H70\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000¢\u0006\u0002\u0010=\u001aJ\u00106\u001a\u0002H7\"\b\b\u0000\u00107*\u00020(*\u00020\f2\u0006\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\u0019\b\u0004\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H70\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000¢\u0006\u0002\u0010@\u001aB\u0010A\u001a\u0002H7\"\b\b\u0000\u00107*\u00020(*\u00020\f2\u0006\u0010B\u001a\u00020\u00062\u0019\b\u0004\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H70\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000¢\u0006\u0002\u0010C\u001a@\u0010A\u001a\u0002H7\"\b\b\u0000\u00107*\u00020(*\u00020\f2\u0006\u0010B\u001a\u00020\b2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H70\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000¢\u0006\u0002\u0010D\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006E"}, d2 = {"EmptyAnnotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "AnnotatedString", "text", "", "paragraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "buildAnnotatedString", "builder", "Lkotlin/Function1;", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "", "Lkotlin/ExtensionFunctionType;", "contains", "", "baseStart", "", "baseEnd", "targetStart", "targetEnd", "emptyAnnotatedString", "filterRanges", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "T", "ranges", "start", "end", "intersect", "lStart", "lEnd", "rStart", "rEnd", "capitalize", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "decapitalize", "getLocalAnnotations", "", "getLocalParagraphStyles", "getLocalSpanStyles", "mapEachParagraphStyle", "defaultParagraphStyle", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "annotatedString", "normalizedParagraphStyles", "substringWithoutParagraphStyles", "toLowerCase", "toUpperCase", "withAnnotation", "R", "ttsAnnotation", "Landroidx/compose/ui/text/TtsAnnotation;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/TtsAnnotation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "urlAnnotation", "Landroidx/compose/ui/text/UrlAnnotation;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/UrlAnnotation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "tag", "annotation", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withStyle", "style", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/ParagraphStyle;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/SpanStyle;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnnotatedString.kt */
public final class AnnotatedStringKt {
    private static final AnnotatedString EmptyAnnotatedString = new AnnotatedString("", (List) null, (List) null, 6, (DefaultConstructorMarker) null);

    public static final List<AnnotatedString.Range<ParagraphStyle>> normalizedParagraphStyles(AnnotatedString $this$normalizedParagraphStyles, ParagraphStyle defaultParagraphStyle) {
        ParagraphStyle paragraphStyle = defaultParagraphStyle;
        Intrinsics.checkNotNullParameter($this$normalizedParagraphStyles, "<this>");
        Intrinsics.checkNotNullParameter(paragraphStyle, "defaultParagraphStyle");
        int length = $this$normalizedParagraphStyles.getText().length();
        List paragraphStyles = $this$normalizedParagraphStyles.getParagraphStylesOrNull$ui_text_release();
        if (paragraphStyles == null) {
            paragraphStyles = CollectionsKt.emptyList();
        }
        int lastOffset = 0;
        List result = new ArrayList();
        List $this$fastForEach$iv = paragraphStyles;
        int index$iv = 0;
        int size = $this$fastForEach$iv.size();
        while (index$iv < size) {
            AnnotatedString.Range range = $this$fastForEach$iv.get(index$iv);
            ParagraphStyle style = (ParagraphStyle) range.component1();
            int start = range.component2();
            int end = range.component3();
            if (start != lastOffset) {
                result.add(new AnnotatedString.Range(paragraphStyle, lastOffset, start));
            }
            result.add(new AnnotatedString.Range(paragraphStyle.merge(style), start, end));
            lastOffset = end;
            index$iv++;
            AnnotatedString annotatedString = $this$normalizedParagraphStyles;
        }
        if (lastOffset != length) {
            result.add(new AnnotatedString.Range(paragraphStyle, lastOffset, length));
        }
        if (result.isEmpty()) {
            result.add(new AnnotatedString.Range(paragraphStyle, 0, 0));
        }
        return result;
    }

    /* access modifiers changed from: private */
    public static final List<AnnotatedString.Range<SpanStyle>> getLocalSpanStyles(AnnotatedString $this$getLocalSpanStyles, int start, int end) {
        List spanStylesOrNull$ui_text_release;
        int i = start;
        int i2 = end;
        if (i == i2 || (spanStylesOrNull$ui_text_release = $this$getLocalSpanStyles.getSpanStylesOrNull$ui_text_release()) == null) {
            return null;
        }
        List spanStyles = spanStylesOrNull$ui_text_release;
        if (i == 0 && i2 >= $this$getLocalSpanStyles.getText().length()) {
            return spanStyles;
        }
        List $this$fastFilter$iv = spanStyles;
        ArrayList target$iv = new ArrayList($this$fastFilter$iv.size());
        List $this$fastForEach$iv$iv = $this$fastFilter$iv;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size) {
            Object it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            AnnotatedString.Range it = (AnnotatedString.Range) it$iv;
            List spanStyles2 = spanStyles;
            if (intersect(i, i2, it.getStart(), it.getEnd())) {
                target$iv.add(it$iv);
            }
            index$iv$iv++;
            spanStyles = spanStyles2;
        }
        List $this$fastMap$iv = target$iv;
        int $i$f$fastMap = 0;
        ArrayList target$iv2 = new ArrayList($this$fastMap$iv.size());
        List $this$fastForEach$iv$iv2 = $this$fastMap$iv;
        int index$iv$iv2 = 0;
        int size2 = $this$fastForEach$iv$iv2.size();
        while (index$iv$iv2 < size2) {
            AnnotatedString.Range it2 = (AnnotatedString.Range) $this$fastForEach$iv$iv2.get(index$iv$iv2);
            target$iv2.add(new AnnotatedString.Range(it2.getItem(), RangesKt.coerceIn(it2.getStart(), i, i2) - i, RangesKt.coerceIn(it2.getEnd(), i, i2) - i));
            index$iv$iv2++;
            $this$fastMap$iv = $this$fastMap$iv;
            $i$f$fastMap = $i$f$fastMap;
            $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv2;
        }
        return target$iv2;
    }

    /* access modifiers changed from: private */
    public static final List<AnnotatedString.Range<ParagraphStyle>> getLocalParagraphStyles(AnnotatedString $this$getLocalParagraphStyles, int start, int end) {
        List paragraphStylesOrNull$ui_text_release;
        int i = start;
        int i2 = end;
        if (i == i2 || (paragraphStylesOrNull$ui_text_release = $this$getLocalParagraphStyles.getParagraphStylesOrNull$ui_text_release()) == null) {
            return null;
        }
        List paragraphStyles = paragraphStylesOrNull$ui_text_release;
        if (i == 0 && i2 >= $this$getLocalParagraphStyles.getText().length()) {
            return paragraphStyles;
        }
        List $this$fastFilter$iv = paragraphStyles;
        ArrayList target$iv = new ArrayList($this$fastFilter$iv.size());
        List $this$fastForEach$iv$iv = $this$fastFilter$iv;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size) {
            Object it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            AnnotatedString.Range it = (AnnotatedString.Range) it$iv;
            List paragraphStyles2 = paragraphStyles;
            if (intersect(i, i2, it.getStart(), it.getEnd())) {
                target$iv.add(it$iv);
            }
            index$iv$iv++;
            paragraphStyles = paragraphStyles2;
        }
        List $this$fastMap$iv = target$iv;
        int $i$f$fastMap = 0;
        ArrayList target$iv2 = new ArrayList($this$fastMap$iv.size());
        List $this$fastForEach$iv$iv2 = $this$fastMap$iv;
        int index$iv$iv2 = 0;
        int size2 = $this$fastForEach$iv$iv2.size();
        while (index$iv$iv2 < size2) {
            AnnotatedString.Range it2 = (AnnotatedString.Range) $this$fastForEach$iv$iv2.get(index$iv$iv2);
            target$iv2.add(new AnnotatedString.Range(it2.getItem(), RangesKt.coerceIn(it2.getStart(), i, i2) - i, RangesKt.coerceIn(it2.getEnd(), i, i2) - i));
            index$iv$iv2++;
            $this$fastMap$iv = $this$fastMap$iv;
            $i$f$fastMap = $i$f$fastMap;
            $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv2;
        }
        return target$iv2;
    }

    /* access modifiers changed from: private */
    public static final List<AnnotatedString.Range<? extends Object>> getLocalAnnotations(AnnotatedString $this$getLocalAnnotations, int start, int end) {
        List annotations$ui_text_release;
        int i = start;
        int i2 = end;
        if (i == i2 || (annotations$ui_text_release = $this$getLocalAnnotations.getAnnotations$ui_text_release()) == null) {
            return null;
        }
        List annotations = annotations$ui_text_release;
        if (i == 0 && i2 >= $this$getLocalAnnotations.getText().length()) {
            return annotations;
        }
        List $this$fastFilter$iv = annotations;
        ArrayList target$iv = new ArrayList($this$fastFilter$iv.size());
        List $this$fastForEach$iv$iv = $this$fastFilter$iv;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size) {
            Object it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            AnnotatedString.Range it = (AnnotatedString.Range) it$iv;
            List annotations2 = annotations;
            if (intersect(i, i2, it.getStart(), it.getEnd())) {
                target$iv.add(it$iv);
            }
            index$iv$iv++;
            annotations = annotations2;
        }
        List $this$fastMap$iv = target$iv;
        int $i$f$fastMap = 0;
        ArrayList target$iv2 = new ArrayList($this$fastMap$iv.size());
        List $this$fastForEach$iv$iv2 = $this$fastMap$iv;
        int index$iv$iv2 = 0;
        int size2 = $this$fastForEach$iv$iv2.size();
        while (index$iv$iv2 < size2) {
            AnnotatedString.Range it2 = (AnnotatedString.Range) $this$fastForEach$iv$iv2.get(index$iv$iv2);
            target$iv2.add(new AnnotatedString.Range(it2.getItem(), RangesKt.coerceIn(it2.getStart(), i, i2) - i, RangesKt.coerceIn(it2.getEnd(), i, i2) - i, it2.getTag()));
            index$iv$iv2++;
            i = start;
            $this$fastMap$iv = $this$fastMap$iv;
            $i$f$fastMap = $i$f$fastMap;
            $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv2;
        }
        return target$iv2;
    }

    /* access modifiers changed from: private */
    public static final AnnotatedString substringWithoutParagraphStyles(AnnotatedString $this$substringWithoutParagraphStyles, int start, int end) {
        String str;
        if (start != end) {
            str = $this$substringWithoutParagraphStyles.getText().substring(start, end);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            str = "";
        }
        return new AnnotatedString(str, getLocalSpanStyles($this$substringWithoutParagraphStyles, start, end), (List) null, (List) null, 12, (DefaultConstructorMarker) null);
    }

    public static final <T> List<T> mapEachParagraphStyle(AnnotatedString $this$mapEachParagraphStyle, ParagraphStyle defaultParagraphStyle, Function2<? super AnnotatedString, ? super AnnotatedString.Range<ParagraphStyle>, ? extends T> block) {
        AnnotatedString annotatedString = $this$mapEachParagraphStyle;
        Function2<? super AnnotatedString, ? super AnnotatedString.Range<ParagraphStyle>, ? extends T> function2 = block;
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(defaultParagraphStyle, "defaultParagraphStyle");
        Intrinsics.checkNotNullParameter(function2, "block");
        int $i$f$mapEachParagraphStyle = 0;
        List normalizedParagraphStyles = normalizedParagraphStyles($this$mapEachParagraphStyle, defaultParagraphStyle);
        ArrayList target$iv = new ArrayList(normalizedParagraphStyles.size());
        List $this$fastForEach$iv$iv = normalizedParagraphStyles;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size) {
            AnnotatedString.Range paragraphStyleRange = (AnnotatedString.Range) $this$fastForEach$iv$iv.get(index$iv$iv);
            target$iv.add(function2.invoke(substringWithoutParagraphStyles(annotatedString, paragraphStyleRange.getStart(), paragraphStyleRange.getEnd()), paragraphStyleRange));
            index$iv$iv++;
            ParagraphStyle paragraphStyle = defaultParagraphStyle;
            $i$f$mapEachParagraphStyle = $i$f$mapEachParagraphStyle;
        }
        return target$iv;
    }

    public static /* synthetic */ AnnotatedString toUpperCase$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return toUpperCase(annotatedString, localeList);
    }

    public static final AnnotatedString toUpperCase(AnnotatedString $this$toUpperCase, LocaleList localeList) {
        Intrinsics.checkNotNullParameter($this$toUpperCase, "<this>");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform($this$toUpperCase, new AnnotatedStringKt$toUpperCase$1(localeList));
    }

    public static /* synthetic */ AnnotatedString toLowerCase$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return toLowerCase(annotatedString, localeList);
    }

    public static final AnnotatedString toLowerCase(AnnotatedString $this$toLowerCase, LocaleList localeList) {
        Intrinsics.checkNotNullParameter($this$toLowerCase, "<this>");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform($this$toLowerCase, new AnnotatedStringKt$toLowerCase$1(localeList));
    }

    public static /* synthetic */ AnnotatedString capitalize$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return capitalize(annotatedString, localeList);
    }

    public static final AnnotatedString capitalize(AnnotatedString $this$capitalize, LocaleList localeList) {
        Intrinsics.checkNotNullParameter($this$capitalize, "<this>");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform($this$capitalize, new AnnotatedStringKt$capitalize$1(localeList));
    }

    public static /* synthetic */ AnnotatedString decapitalize$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return decapitalize(annotatedString, localeList);
    }

    public static final AnnotatedString decapitalize(AnnotatedString $this$decapitalize, LocaleList localeList) {
        Intrinsics.checkNotNullParameter($this$decapitalize, "<this>");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform($this$decapitalize, new AnnotatedStringKt$decapitalize$1(localeList));
    }

    public static final <R> R withStyle(AnnotatedString.Builder $this$withStyle, SpanStyle style, Function1<? super AnnotatedString.Builder, ? extends R> block) {
        Intrinsics.checkNotNullParameter($this$withStyle, "<this>");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(block, "block");
        int index = $this$withStyle.pushStyle(style);
        try {
            return block.invoke($this$withStyle);
        } finally {
            InlineMarker.finallyStart(1);
            $this$withStyle.pop(index);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final <R> R withStyle(AnnotatedString.Builder $this$withStyle, ParagraphStyle style, Function1<? super AnnotatedString.Builder, ? extends R> block) {
        Intrinsics.checkNotNullParameter($this$withStyle, "<this>");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(block, "block");
        int index = $this$withStyle.pushStyle(style);
        try {
            return block.invoke($this$withStyle);
        } finally {
            InlineMarker.finallyStart(1);
            $this$withStyle.pop(index);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final <R> R withAnnotation(AnnotatedString.Builder $this$withAnnotation, String tag, String annotation, Function1<? super AnnotatedString.Builder, ? extends R> block) {
        Intrinsics.checkNotNullParameter($this$withAnnotation, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        Intrinsics.checkNotNullParameter(block, "block");
        int index = $this$withAnnotation.pushStringAnnotation(tag, annotation);
        try {
            return block.invoke($this$withAnnotation);
        } finally {
            InlineMarker.finallyStart(1);
            $this$withAnnotation.pop(index);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final <R> R withAnnotation(AnnotatedString.Builder $this$withAnnotation, TtsAnnotation ttsAnnotation, Function1<? super AnnotatedString.Builder, ? extends R> block) {
        Intrinsics.checkNotNullParameter($this$withAnnotation, "<this>");
        Intrinsics.checkNotNullParameter(ttsAnnotation, "ttsAnnotation");
        Intrinsics.checkNotNullParameter(block, "block");
        int index = $this$withAnnotation.pushTtsAnnotation(ttsAnnotation);
        try {
            return block.invoke($this$withAnnotation);
        } finally {
            InlineMarker.finallyStart(1);
            $this$withAnnotation.pop(index);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final <R> R withAnnotation(AnnotatedString.Builder $this$withAnnotation, UrlAnnotation urlAnnotation, Function1<? super AnnotatedString.Builder, ? extends R> block) {
        Intrinsics.checkNotNullParameter($this$withAnnotation, "<this>");
        Intrinsics.checkNotNullParameter(urlAnnotation, "urlAnnotation");
        Intrinsics.checkNotNullParameter(block, "block");
        int index = $this$withAnnotation.pushUrlAnnotation(urlAnnotation);
        try {
            return block.invoke($this$withAnnotation);
        } finally {
            InlineMarker.finallyStart(1);
            $this$withAnnotation.pop(index);
            InlineMarker.finallyEnd(1);
        }
    }

    /* access modifiers changed from: private */
    public static final <T> List<AnnotatedString.Range<T>> filterRanges(List<? extends AnnotatedString.Range<? extends T>> ranges, int start, int end) {
        int i = start;
        int i2 = end;
        if (!(i <= i2)) {
            throw new IllegalArgumentException(("start (" + i + ") should be less than or equal to end (" + i2 + ')').toString());
        } else if (ranges == null) {
            return null;
        } else {
            List nonNullRange = ranges;
            List $this$fastFilter$iv = nonNullRange;
            ArrayList target$iv = new ArrayList($this$fastFilter$iv.size());
            List $this$fastForEach$iv$iv = $this$fastFilter$iv;
            int index$iv$iv = 0;
            int size = $this$fastForEach$iv$iv.size();
            while (index$iv$iv < size) {
                Object it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
                AnnotatedString.Range it = (AnnotatedString.Range) it$iv;
                List nonNullRange2 = nonNullRange;
                if (intersect(i, i2, it.getStart(), it.getEnd())) {
                    target$iv.add(it$iv);
                }
                index$iv$iv++;
                nonNullRange = nonNullRange2;
            }
            List $this$fastMap$iv = target$iv;
            int $i$f$fastMap = false;
            ArrayList target$iv2 = new ArrayList($this$fastMap$iv.size());
            List $this$fastForEach$iv$iv2 = $this$fastMap$iv;
            int $i$f$fastForEach = false;
            int index$iv$iv2 = 0;
            int size2 = $this$fastForEach$iv$iv2.size();
            while (index$iv$iv2 < size2) {
                AnnotatedString.Range it2 = (AnnotatedString.Range) $this$fastForEach$iv$iv2.get(index$iv$iv2);
                target$iv2.add(new AnnotatedString.Range(it2.getItem(), Math.max(i, it2.getStart()) - i, Math.min(i2, it2.getEnd()) - i, it2.getTag()));
                index$iv$iv2++;
                $this$fastMap$iv = $this$fastMap$iv;
                $i$f$fastMap = $i$f$fastMap;
                $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv2;
                $i$f$fastForEach = $i$f$fastForEach;
            }
            int i3 = $i$f$fastMap;
            List list = $this$fastForEach$iv$iv2;
            int i4 = $i$f$fastForEach;
            Collection collection = target$iv2;
            if (collection.isEmpty()) {
                collection = null;
            }
            return (List) collection;
        }
    }

    public static /* synthetic */ AnnotatedString AnnotatedString$default(String str, SpanStyle spanStyle, ParagraphStyle paragraphStyle, int i, Object obj) {
        if ((i & 4) != 0) {
            paragraphStyle = null;
        }
        return AnnotatedString(str, spanStyle, paragraphStyle);
    }

    public static final AnnotatedString AnnotatedString(String text, SpanStyle spanStyle, ParagraphStyle paragraphStyle) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
        return new AnnotatedString(text, CollectionsKt.listOf(new AnnotatedString.Range(spanStyle, 0, text.length())), paragraphStyle == null ? CollectionsKt.emptyList() : CollectionsKt.listOf(new AnnotatedString.Range(paragraphStyle, 0, text.length())));
    }

    public static final AnnotatedString AnnotatedString(String text, ParagraphStyle paragraphStyle) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paragraphStyle, "paragraphStyle");
        return new AnnotatedString(text, CollectionsKt.emptyList(), CollectionsKt.listOf(new AnnotatedString.Range(paragraphStyle, 0, text.length())));
    }

    public static final AnnotatedString buildAnnotatedString(Function1<? super AnnotatedString.Builder, Unit> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        AnnotatedString.Builder builder2 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
        builder.invoke(builder2);
        return builder2.toAnnotatedString();
    }

    public static final boolean contains(int baseStart, int baseEnd, int targetStart, int targetEnd) {
        if (baseStart > targetStart || targetEnd > baseEnd) {
            return false;
        }
        if (baseEnd == targetEnd) {
            if ((targetStart == targetEnd) != (baseStart == baseEnd)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean intersect(int lStart, int lEnd, int rStart, int rEnd) {
        return Math.max(lStart, rStart) < Math.min(lEnd, rEnd) || contains(lStart, lEnd, rStart, rEnd) || contains(rStart, rEnd, lStart, lEnd);
    }

    public static final AnnotatedString emptyAnnotatedString() {
        return EmptyAnnotatedString;
    }
}
