package androidx.compose.ui.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u000256B;\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0005¢\u0006\u0002\u0010\nBY\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000eH\u0002J\u0011\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013H\u0002J\"\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u00052\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0013J*\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u00052\u0006\u0010%\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0013J\"\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u00060\u00052\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0013J$\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u00060\u00052\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0013H\u0007J\u001e\u0010*\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0013J\b\u0010+\u001a\u00020\u0013H\u0016J\u0011\u0010,\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\u0002J\u001b\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101J\u0018\u0010-\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0013H\u0016J\b\u00104\u001a\u00020\u0003H\u0016R$\u0010\r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0006\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0011R\"\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0011R\"\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00067"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString;", "", "text", "", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyles", "Landroidx/compose/ui/text/ParagraphStyle;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "spanStylesOrNull", "paragraphStylesOrNull", "annotations", "", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAnnotations$ui_text_release", "()Ljava/util/List;", "length", "", "getLength", "()I", "getParagraphStyles", "getParagraphStylesOrNull$ui_text_release", "getSpanStyles", "getSpanStylesOrNull$ui_text_release", "getText", "()Ljava/lang/String;", "equals", "", "other", "get", "", "index", "getStringAnnotations", "start", "end", "tag", "getTtsAnnotations", "Landroidx/compose/ui/text/TtsAnnotation;", "getUrlAnnotations", "Landroidx/compose/ui/text/UrlAnnotation;", "hasStringAnnotations", "hashCode", "plus", "subSequence", "range", "Landroidx/compose/ui/text/TextRange;", "subSequence-5zc-tL8", "(J)Landroidx/compose/ui/text/AnnotatedString;", "startIndex", "endIndex", "toString", "Builder", "Range", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnnotatedString.kt */
public final class AnnotatedString implements CharSequence {
    public static final int $stable = 0;
    private final List<Range<? extends Object>> annotations;
    private final List<Range<ParagraphStyle>> paragraphStylesOrNull;
    private final List<Range<SpanStyle>> spanStylesOrNull;
    private final String text;

    public AnnotatedString(String text2, List<Range<SpanStyle>> spanStylesOrNull2, List<Range<ParagraphStyle>> paragraphStylesOrNull2, List<? extends Range<? extends Object>> annotations2) {
        List $this$fastForEach$iv;
        String str = text2;
        List<Range<ParagraphStyle>> $this$sortedBy$iv = paragraphStylesOrNull2;
        Intrinsics.checkNotNullParameter(str, "text");
        this.text = str;
        this.spanStylesOrNull = spanStylesOrNull2;
        this.paragraphStylesOrNull = $this$sortedBy$iv;
        this.annotations = annotations2;
        int lastStyleEnd = -1;
        if ($this$sortedBy$iv != null && ($this$fastForEach$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new AnnotatedString$special$$inlined$sortedBy$1())) != null) {
            int index$iv = 0;
            int size = $this$fastForEach$iv.size();
            while (index$iv < size) {
                Range paragraphStyle = (Range) $this$fastForEach$iv.get(index$iv);
                if (paragraphStyle.getStart() >= lastStyleEnd) {
                    if (paragraphStyle.getEnd() <= this.text.length()) {
                        lastStyleEnd = paragraphStyle.getEnd();
                        index$iv++;
                    } else {
                        throw new IllegalArgumentException(("ParagraphStyle range [" + paragraphStyle.getStart() + ", " + paragraphStyle.getEnd() + ") is out of boundary").toString());
                    }
                } else {
                    throw new IllegalArgumentException("ParagraphStyle should not overlap".toString());
                }
            }
        }
    }

    public final /* bridge */ char charAt(int index) {
        return get(index);
    }

    public final /* bridge */ int length() {
        return getLength();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnnotatedString(String str, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : list3);
    }

    public final String getText() {
        return this.text;
    }

    public final List<Range<SpanStyle>> getSpanStylesOrNull$ui_text_release() {
        return this.spanStylesOrNull;
    }

    public final List<Range<ParagraphStyle>> getParagraphStylesOrNull$ui_text_release() {
        return this.paragraphStylesOrNull;
    }

    public final List<Range<? extends Object>> getAnnotations$ui_text_release() {
        return this.annotations;
    }

    public final List<Range<SpanStyle>> getSpanStyles() {
        List<Range<SpanStyle>> list = this.spanStylesOrNull;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final List<Range<ParagraphStyle>> getParagraphStyles() {
        List<Range<ParagraphStyle>> list = this.paragraphStylesOrNull;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnnotatedString(String str, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AnnotatedString(java.lang.String r5, java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>> r6, java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.ParagraphStyle>> r7) {
        /*
            r4 = this;
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "spanStyles"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "paragraphStyles"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = r6
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r1 = r0.isEmpty()
            r2 = 0
            if (r1 == 0) goto L_0x0020
            r0 = 0
            r0 = r2
        L_0x0020:
            java.util.List r0 = (java.util.List) r0
            r1 = r7
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r3 = r1.isEmpty()
            if (r3 == 0) goto L_0x002d
            r1 = 0
            r1 = r2
        L_0x002d:
            java.util.List r1 = (java.util.List) r1
            r4.<init>(r5, r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.AnnotatedString.<init>(java.lang.String, java.util.List, java.util.List):void");
    }

    public int getLength() {
        return this.text.length();
    }

    public char get(int index) {
        return this.text.charAt(index);
    }

    public AnnotatedString subSequence(int startIndex, int endIndex) {
        if (!(startIndex <= endIndex)) {
            throw new IllegalArgumentException(("start (" + startIndex + ") should be less or equal to end (" + endIndex + ')').toString());
        } else if (startIndex == 0 && endIndex == this.text.length()) {
            return this;
        } else {
            String text2 = this.text.substring(startIndex, endIndex);
            Intrinsics.checkNotNullExpressionValue(text2, "this as java.lang.String…ing(startIndex, endIndex)");
            return new AnnotatedString(text2, AnnotatedStringKt.filterRanges(this.spanStylesOrNull, startIndex, endIndex), AnnotatedStringKt.filterRanges(this.paragraphStylesOrNull, startIndex, endIndex), AnnotatedStringKt.filterRanges(this.annotations, startIndex, endIndex));
        }
    }

    /* renamed from: subSequence-5zc-tL8  reason: not valid java name */
    public final AnnotatedString m5346subSequence5zctL8(long range) {
        return subSequence(TextRange.m5472getMinimpl(range), TextRange.m5471getMaximpl(range));
    }

    public final AnnotatedString plus(AnnotatedString other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Builder $this$plus_u24lambda_u247 = new Builder(this);
        $this$plus_u24lambda_u247.append(other);
        return $this$plus_u24lambda_u247.toAnnotatedString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<androidx.compose.ui.text.AnnotatedString.Range<java.lang.String>> getStringAnnotations(java.lang.String r17, int r18, int r19) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r1 = "tag"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = r16
            java.util.List<androidx.compose.ui.text.AnnotatedString$Range<? extends java.lang.Object>> r2 = r1.annotations
            if (r2 == 0) goto L_0x0072
            r3 = 0
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = r2.size()
            r4.<init>(r5)
            r5 = r2
            r6 = 0
            r7 = 0
            int r8 = r5.size()
        L_0x0021:
            if (r7 >= r8) goto L_0x0069
            java.lang.Object r9 = r5.get(r7)
            r10 = r9
            r11 = 0
            r12 = r10
            androidx.compose.ui.text.AnnotatedString$Range r12 = (androidx.compose.ui.text.AnnotatedString.Range) r12
            r13 = 0
            java.lang.Object r14 = r12.getItem()
            boolean r14 = r14 instanceof java.lang.String
            if (r14 == 0) goto L_0x0053
            java.lang.String r14 = r12.getTag()
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r14)
            if (r14 == 0) goto L_0x0053
            int r14 = r12.getStart()
            int r15 = r12.getEnd()
            r0 = r18
            r1 = r19
            boolean r14 = androidx.compose.ui.text.AnnotatedStringKt.intersect(r0, r1, r14, r15)
            if (r14 == 0) goto L_0x0057
            r14 = 1
            goto L_0x0058
        L_0x0053:
            r0 = r18
            r1 = r19
        L_0x0057:
            r14 = 0
        L_0x0058:
            if (r14 == 0) goto L_0x0060
            r12 = r4
            java.util.Collection r12 = (java.util.Collection) r12
            r12.add(r10)
        L_0x0060:
            int r7 = r7 + 1
            r1 = r16
            r0 = r17
            goto L_0x0021
        L_0x0069:
            r0 = r18
            r1 = r19
            r2 = r4
            java.util.List r2 = (java.util.List) r2
            goto L_0x007a
        L_0x0072:
            r0 = r18
            r1 = r19
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L_0x007a:
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<kotlin.String>>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.AnnotatedString.getStringAnnotations(java.lang.String, int, int):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0053 A[LOOP:0: B:3:0x0018->B:15:0x0053, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasStringAnnotations(java.lang.String r17, int r18, int r19) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r1 = "tag"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = r16
            java.util.List<androidx.compose.ui.text.AnnotatedString$Range<? extends java.lang.Object>> r2 = r1.annotations
            if (r2 == 0) goto L_0x0060
            r4 = 0
            r5 = r2
            r6 = 0
            r7 = 0
            int r8 = r5.size()
        L_0x0018:
            if (r7 >= r8) goto L_0x0059
            java.lang.Object r9 = r5.get(r7)
            r10 = r9
            r11 = 0
            r12 = r10
            androidx.compose.ui.text.AnnotatedString$Range r12 = (androidx.compose.ui.text.AnnotatedString.Range) r12
            r13 = 0
            java.lang.Object r14 = r12.getItem()
            boolean r14 = r14 instanceof java.lang.String
            if (r14 == 0) goto L_0x004a
            java.lang.String r14 = r12.getTag()
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r14)
            if (r14 == 0) goto L_0x004a
            int r14 = r12.getStart()
            int r3 = r12.getEnd()
            r15 = r18
            r0 = r19
            boolean r3 = androidx.compose.ui.text.AnnotatedStringKt.intersect(r15, r0, r14, r3)
            if (r3 == 0) goto L_0x004e
            r3 = 1
            goto L_0x004f
        L_0x004a:
            r15 = r18
            r0 = r19
        L_0x004e:
            r3 = 0
        L_0x004f:
            if (r3 == 0) goto L_0x0053
            r3 = 1
            goto L_0x005f
        L_0x0053:
            int r7 = r7 + 1
            r0 = r17
            goto L_0x0018
        L_0x0059:
            r15 = r18
            r0 = r19
            r3 = 0
        L_0x005f:
            goto L_0x0065
        L_0x0060:
            r15 = r18
            r0 = r19
            r3 = 0
        L_0x0065:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.AnnotatedString.hasStringAnnotations(java.lang.String, int, int):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<androidx.compose.ui.text.AnnotatedString.Range<java.lang.String>> getStringAnnotations(int r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            java.util.List<androidx.compose.ui.text.AnnotatedString$Range<? extends java.lang.Object>> r1 = r0.annotations
            if (r1 == 0) goto L_0x005e
            r2 = 0
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = r1.size()
            r3.<init>(r4)
            r4 = r1
            r5 = 0
            r6 = 0
            int r7 = r4.size()
        L_0x0019:
            if (r6 >= r7) goto L_0x0055
            java.lang.Object r8 = r4.get(r6)
            r9 = r8
            r10 = 0
            r11 = r9
            androidx.compose.ui.text.AnnotatedString$Range r11 = (androidx.compose.ui.text.AnnotatedString.Range) r11
            r12 = 0
            java.lang.Object r13 = r11.getItem()
            boolean r13 = r13 instanceof java.lang.String
            if (r13 == 0) goto L_0x0041
            int r13 = r11.getStart()
            int r14 = r11.getEnd()
            r15 = r17
            r0 = r18
            boolean r13 = androidx.compose.ui.text.AnnotatedStringKt.intersect(r15, r0, r13, r14)
            if (r13 == 0) goto L_0x0045
            r13 = 1
            goto L_0x0046
        L_0x0041:
            r15 = r17
            r0 = r18
        L_0x0045:
            r13 = 0
        L_0x0046:
            if (r13 == 0) goto L_0x004e
            r11 = r3
            java.util.Collection r11 = (java.util.Collection) r11
            r11.add(r9)
        L_0x004e:
            int r6 = r6 + 1
            r0 = r16
            goto L_0x0019
        L_0x0055:
            r15 = r17
            r0 = r18
            r1 = r3
            java.util.List r1 = (java.util.List) r1
            goto L_0x0066
        L_0x005e:
            r15 = r17
            r0 = r18
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0066:
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<kotlin.String>>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.AnnotatedString.getStringAnnotations(int, int):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.TtsAnnotation>> getTtsAnnotations(int r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            java.util.List<androidx.compose.ui.text.AnnotatedString$Range<? extends java.lang.Object>> r1 = r0.annotations
            if (r1 == 0) goto L_0x005e
            r2 = 0
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = r1.size()
            r3.<init>(r4)
            r4 = r1
            r5 = 0
            r6 = 0
            int r7 = r4.size()
        L_0x0019:
            if (r6 >= r7) goto L_0x0055
            java.lang.Object r8 = r4.get(r6)
            r9 = r8
            r10 = 0
            r11 = r9
            androidx.compose.ui.text.AnnotatedString$Range r11 = (androidx.compose.ui.text.AnnotatedString.Range) r11
            r12 = 0
            java.lang.Object r13 = r11.getItem()
            boolean r13 = r13 instanceof androidx.compose.ui.text.TtsAnnotation
            if (r13 == 0) goto L_0x0041
            int r13 = r11.getStart()
            int r14 = r11.getEnd()
            r15 = r17
            r0 = r18
            boolean r13 = androidx.compose.ui.text.AnnotatedStringKt.intersect(r15, r0, r13, r14)
            if (r13 == 0) goto L_0x0045
            r13 = 1
            goto L_0x0046
        L_0x0041:
            r15 = r17
            r0 = r18
        L_0x0045:
            r13 = 0
        L_0x0046:
            if (r13 == 0) goto L_0x004e
            r11 = r3
            java.util.Collection r11 = (java.util.Collection) r11
            r11.add(r9)
        L_0x004e:
            int r6 = r6 + 1
            r0 = r16
            goto L_0x0019
        L_0x0055:
            r15 = r17
            r0 = r18
            r1 = r3
            java.util.List r1 = (java.util.List) r1
            goto L_0x0066
        L_0x005e:
            r15 = r17
            r0 = r18
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0066:
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.TtsAnnotation>>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.AnnotatedString.getTtsAnnotations(int, int):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.UrlAnnotation>> getUrlAnnotations(int r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            java.util.List<androidx.compose.ui.text.AnnotatedString$Range<? extends java.lang.Object>> r1 = r0.annotations
            if (r1 == 0) goto L_0x005e
            r2 = 0
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = r1.size()
            r3.<init>(r4)
            r4 = r1
            r5 = 0
            r6 = 0
            int r7 = r4.size()
        L_0x0019:
            if (r6 >= r7) goto L_0x0055
            java.lang.Object r8 = r4.get(r6)
            r9 = r8
            r10 = 0
            r11 = r9
            androidx.compose.ui.text.AnnotatedString$Range r11 = (androidx.compose.ui.text.AnnotatedString.Range) r11
            r12 = 0
            java.lang.Object r13 = r11.getItem()
            boolean r13 = r13 instanceof androidx.compose.ui.text.UrlAnnotation
            if (r13 == 0) goto L_0x0041
            int r13 = r11.getStart()
            int r14 = r11.getEnd()
            r15 = r17
            r0 = r18
            boolean r13 = androidx.compose.ui.text.AnnotatedStringKt.intersect(r15, r0, r13, r14)
            if (r13 == 0) goto L_0x0045
            r13 = 1
            goto L_0x0046
        L_0x0041:
            r15 = r17
            r0 = r18
        L_0x0045:
            r13 = 0
        L_0x0046:
            if (r13 == 0) goto L_0x004e
            r11 = r3
            java.util.Collection r11 = (java.util.Collection) r11
            r11.add(r9)
        L_0x004e:
            int r6 = r6 + 1
            r0 = r16
            goto L_0x0019
        L_0x0055:
            r15 = r17
            r0 = r18
            r1 = r3
            java.util.List r1 = (java.util.List) r1
            goto L_0x0066
        L_0x005e:
            r15 = r17
            r0 = r18
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0066:
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.UrlAnnotation>>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.AnnotatedString.getUrlAnnotations(int, int):java.util.List");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof AnnotatedString) && Intrinsics.areEqual((Object) this.text, (Object) ((AnnotatedString) other).text) && Intrinsics.areEqual((Object) this.spanStylesOrNull, (Object) ((AnnotatedString) other).spanStylesOrNull) && Intrinsics.areEqual((Object) this.paragraphStylesOrNull, (Object) ((AnnotatedString) other).paragraphStylesOrNull) && Intrinsics.areEqual((Object) this.annotations, (Object) ((AnnotatedString) other).annotations)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.text.hashCode() * 31;
        List<Range<SpanStyle>> list = this.spanStylesOrNull;
        int i = 0;
        int result = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<Range<ParagraphStyle>> list2 = this.paragraphStylesOrNull;
        int result2 = (result + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Range<? extends Object>> list3 = this.annotations;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return result2 + i;
    }

    public String toString() {
        return this.text;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B%\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0013\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J<\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Range;", "T", "", "item", "start", "", "end", "(Ljava/lang/Object;II)V", "tag", "", "(Ljava/lang/Object;IILjava/lang/String;)V", "getEnd", "()I", "getItem", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStart", "getTag", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;IILjava/lang/String;)Landroidx/compose/ui/text/AnnotatedString$Range;", "equals", "", "other", "hashCode", "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnnotatedString.kt */
    public static final class Range<T> {
        public static final int $stable = 0;
        private final int end;
        private final T item;
        private final int start;
        private final String tag;

        public static /* synthetic */ Range copy$default(Range range, T t, int i, int i2, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                t = range.item;
            }
            if ((i3 & 2) != 0) {
                i = range.start;
            }
            if ((i3 & 4) != 0) {
                i2 = range.end;
            }
            if ((i3 & 8) != 0) {
                str = range.tag;
            }
            return range.copy(t, i, i2, str);
        }

        public final T component1() {
            return this.item;
        }

        public final int component2() {
            return this.start;
        }

        public final int component3() {
            return this.end;
        }

        public final String component4() {
            return this.tag;
        }

        public final Range<T> copy(T t, int i, int i2, String str) {
            Intrinsics.checkNotNullParameter(str, "tag");
            return new Range<>(t, i, i2, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Range)) {
                return false;
            }
            Range range = (Range) obj;
            return Intrinsics.areEqual((Object) this.item, (Object) range.item) && this.start == range.start && this.end == range.end && Intrinsics.areEqual((Object) this.tag, (Object) range.tag);
        }

        public int hashCode() {
            T t = this.item;
            return ((((((t == null ? 0 : t.hashCode()) * 31) + Integer.hashCode(this.start)) * 31) + Integer.hashCode(this.end)) * 31) + this.tag.hashCode();
        }

        public String toString() {
            return "Range(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ')';
        }

        public Range(T item2, int start2, int end2, String tag2) {
            Intrinsics.checkNotNullParameter(tag2, "tag");
            this.item = item2;
            this.start = start2;
            this.end = end2;
            this.tag = tag2;
            if (!(start2 <= end2)) {
                throw new IllegalArgumentException("Reversed range is not supported".toString());
            }
        }

        public final int getEnd() {
            return this.end;
        }

        public final T getItem() {
            return this.item;
        }

        public final int getStart() {
            return this.start;
        }

        public final String getTag() {
            return this.tag;
        }

        public Range(T item2, int start2, int end2) {
            this(item2, start2, end2, "");
        }
    }

    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\u0010\r\n\u0002\b\n\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u00013B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tJ\u001e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tJ\u001e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tJ \u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0007J \u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0007J\u000e\u0010'\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0006J\u001e\u0010'\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tJ\u0010\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)H\u0016J\u0012\u0010'\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010*H\u0016J\"\u0010'\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010*2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0016J\u000e\u0010'\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0004J\u0015\u0010+\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020)H\u0007¢\u0006\u0002\b'J\u0006\u0010,\u001a\u00020\u001aJ\u000e\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\tJ\u0016\u0010.\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010/\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0013J\u000e\u0010/\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0015J\u000e\u00100\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#J\u0010\u00101\u001a\u00020\t2\u0006\u0010%\u001a\u00020&H\u0007J\u0006\u00102\u001a\u00020\u0006R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00060\u0017j\u0002`\u0018X\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Builder;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "text", "", "(Ljava/lang/String;)V", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;)V", "capacity", "", "(I)V", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "", "length", "getLength", "()I", "paragraphStyles", "Landroidx/compose/ui/text/ParagraphStyle;", "spanStyles", "Landroidx/compose/ui/text/SpanStyle;", "styleStack", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "addStringAnnotation", "", "tag", "annotation", "start", "end", "addStyle", "style", "addTtsAnnotation", "ttsAnnotation", "Landroidx/compose/ui/text/TtsAnnotation;", "addUrlAnnotation", "urlAnnotation", "Landroidx/compose/ui/text/UrlAnnotation;", "append", "char", "", "", "deprecated_append_returning_void", "pop", "index", "pushStringAnnotation", "pushStyle", "pushTtsAnnotation", "pushUrlAnnotation", "toAnnotatedString", "MutableRange", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnnotatedString.kt */
    public static final class Builder implements Appendable {
        public static final int $stable = 8;
        private final List<MutableRange<? extends Object>> annotations;
        private final List<MutableRange<ParagraphStyle>> paragraphStyles;
        private final List<MutableRange<SpanStyle>> spanStyles;
        private final List<MutableRange<? extends Object>> styleStack;
        private final StringBuilder text;

        public Builder() {
            this(0, 1, (DefaultConstructorMarker) null);
        }

        public Builder(int capacity) {
            this.text = new StringBuilder(capacity);
            this.spanStyles = new ArrayList();
            this.paragraphStyles = new ArrayList();
            this.annotations = new ArrayList();
            this.styleStack = new ArrayList();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 16 : i);
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0014\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J<\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\b\b\u0002\u0010 \u001a\u00020\u0005J\t\u0010!\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "T", "", "item", "start", "", "end", "tag", "", "(Ljava/lang/Object;IILjava/lang/String;)V", "getEnd", "()I", "setEnd", "(I)V", "getItem", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStart", "getTag", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;IILjava/lang/String;)Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "equals", "", "other", "hashCode", "toRange", "Landroidx/compose/ui/text/AnnotatedString$Range;", "defaultEnd", "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnnotatedString.kt */
        private static final class MutableRange<T> {
            private int end;
            private final T item;
            private final int start;
            private final String tag;

            public static /* synthetic */ MutableRange copy$default(MutableRange mutableRange, T t, int i, int i2, String str, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    t = mutableRange.item;
                }
                if ((i3 & 2) != 0) {
                    i = mutableRange.start;
                }
                if ((i3 & 4) != 0) {
                    i2 = mutableRange.end;
                }
                if ((i3 & 8) != 0) {
                    str = mutableRange.tag;
                }
                return mutableRange.copy(t, i, i2, str);
            }

            public final T component1() {
                return this.item;
            }

            public final int component2() {
                return this.start;
            }

            public final int component3() {
                return this.end;
            }

            public final String component4() {
                return this.tag;
            }

            public final MutableRange<T> copy(T t, int i, int i2, String str) {
                Intrinsics.checkNotNullParameter(str, "tag");
                return new MutableRange<>(t, i, i2, str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MutableRange)) {
                    return false;
                }
                MutableRange mutableRange = (MutableRange) obj;
                return Intrinsics.areEqual((Object) this.item, (Object) mutableRange.item) && this.start == mutableRange.start && this.end == mutableRange.end && Intrinsics.areEqual((Object) this.tag, (Object) mutableRange.tag);
            }

            public int hashCode() {
                T t = this.item;
                return ((((((t == null ? 0 : t.hashCode()) * 31) + Integer.hashCode(this.start)) * 31) + Integer.hashCode(this.end)) * 31) + this.tag.hashCode();
            }

            public String toString() {
                return "MutableRange(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ')';
            }

            public MutableRange(T item2, int start2, int end2, String tag2) {
                Intrinsics.checkNotNullParameter(tag2, "tag");
                this.item = item2;
                this.start = start2;
                this.end = end2;
                this.tag = tag2;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ MutableRange(Object obj, int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(obj, i, (i3 & 4) != 0 ? Integer.MIN_VALUE : i2, (i3 & 8) != 0 ? "" : str);
            }

            public final T getItem() {
                return this.item;
            }

            public final int getStart() {
                return this.start;
            }

            public final int getEnd() {
                return this.end;
            }

            public final void setEnd(int i) {
                this.end = i;
            }

            public final String getTag() {
                return this.tag;
            }

            public static /* synthetic */ Range toRange$default(MutableRange mutableRange, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = Integer.MIN_VALUE;
                }
                return mutableRange.toRange(i);
            }

            public final Range<T> toRange(int defaultEnd) {
                int end2 = this.end;
                if (end2 == Integer.MIN_VALUE) {
                    end2 = defaultEnd;
                }
                if (end2 != Integer.MIN_VALUE) {
                    return new Range<>(this.item, this.start, end2, this.tag);
                }
                throw new IllegalStateException("Item.end should be set first".toString());
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(String text2) {
            this(0, 1, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(text2, "text");
            append(text2);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(AnnotatedString text2) {
            this(0, 1, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(text2, "text");
            append(text2);
        }

        public final int getLength() {
            return this.text.length();
        }

        public final void append(String text2) {
            Intrinsics.checkNotNullParameter(text2, "text");
            this.text.append(text2);
        }

        public Builder append(CharSequence text2) {
            if (text2 instanceof AnnotatedString) {
                append((AnnotatedString) text2);
            } else {
                this.text.append(text2);
            }
            return this;
        }

        public Builder append(CharSequence text2, int start, int end) {
            if (text2 instanceof AnnotatedString) {
                append((AnnotatedString) text2, start, end);
            } else {
                this.text.append(text2, start, end);
            }
            return this;
        }

        public Builder append(char c) {
            this.text.append(c);
            return this;
        }

        public final void append(AnnotatedString text2) {
            Intrinsics.checkNotNullParameter(text2, "text");
            int start = this.text.length();
            this.text.append(text2.getText());
            List $this$fastForEach$iv = text2.getSpanStylesOrNull$ui_text_release();
            if ($this$fastForEach$iv != null) {
                int size = $this$fastForEach$iv.size();
                for (int index$iv = 0; index$iv < size; index$iv++) {
                    Range it = $this$fastForEach$iv.get(index$iv);
                    addStyle((SpanStyle) it.getItem(), it.getStart() + start, it.getEnd() + start);
                }
            }
            List $this$fastForEach$iv2 = text2.getParagraphStylesOrNull$ui_text_release();
            if ($this$fastForEach$iv2 != null) {
                int size2 = $this$fastForEach$iv2.size();
                for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                    Range it2 = $this$fastForEach$iv2.get(index$iv2);
                    addStyle((ParagraphStyle) it2.getItem(), it2.getStart() + start, it2.getEnd() + start);
                }
            }
            List $this$fastForEach$iv3 = text2.getAnnotations$ui_text_release();
            if ($this$fastForEach$iv3 != null) {
                int size3 = $this$fastForEach$iv3.size();
                for (int index$iv3 = 0; index$iv3 < size3; index$iv3++) {
                    Range it3 = $this$fastForEach$iv3.get(index$iv3);
                    this.annotations.add(new MutableRange(it3.getItem(), it3.getStart() + start, it3.getEnd() + start, it3.getTag()));
                }
            }
        }

        public final void append(AnnotatedString text2, int start, int end) {
            Builder builder = this;
            Intrinsics.checkNotNullParameter(text2, "text");
            int insertionStart = builder.text.length();
            builder.text.append(text2.getText(), start, end);
            List $this$fastForEach$iv = AnnotatedStringKt.getLocalSpanStyles(text2, start, end);
            if ($this$fastForEach$iv != null) {
                int size = $this$fastForEach$iv.size();
                for (int index$iv = 0; index$iv < size; index$iv++) {
                    Range it = (Range) $this$fastForEach$iv.get(index$iv);
                    builder.addStyle((SpanStyle) it.getItem(), it.getStart() + insertionStart, it.getEnd() + insertionStart);
                }
            }
            List $this$fastForEach$iv2 = AnnotatedStringKt.getLocalParagraphStyles(text2, start, end);
            if ($this$fastForEach$iv2 != null) {
                int size2 = $this$fastForEach$iv2.size();
                for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                    Range it2 = (Range) $this$fastForEach$iv2.get(index$iv2);
                    builder.addStyle((ParagraphStyle) it2.getItem(), it2.getStart() + insertionStart, it2.getEnd() + insertionStart);
                }
            }
            List $this$fastForEach$iv3 = AnnotatedStringKt.getLocalAnnotations(text2, start, end);
            if ($this$fastForEach$iv3 != null) {
                int index$iv3 = 0;
                int size3 = $this$fastForEach$iv3.size();
                while (index$iv3 < size3) {
                    Range it3 = (Range) $this$fastForEach$iv3.get(index$iv3);
                    builder.annotations.add(new MutableRange(it3.getItem(), it3.getStart() + insertionStart, insertionStart + it3.getEnd(), it3.getTag()));
                    index$iv3++;
                    builder = this;
                    insertionStart = insertionStart;
                }
                return;
            }
        }

        public final void addStyle(SpanStyle style, int start, int end) {
            Intrinsics.checkNotNullParameter(style, "style");
            this.spanStyles.add(new MutableRange(style, start, end, (String) null, 8, (DefaultConstructorMarker) null));
        }

        public final void addStyle(ParagraphStyle style, int start, int end) {
            Intrinsics.checkNotNullParameter(style, "style");
            this.paragraphStyles.add(new MutableRange(style, start, end, (String) null, 8, (DefaultConstructorMarker) null));
        }

        public final void addStringAnnotation(String tag, String annotation, int start, int end) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            this.annotations.add(new MutableRange(annotation, start, end, tag));
        }

        public final void addTtsAnnotation(TtsAnnotation ttsAnnotation, int start, int end) {
            Intrinsics.checkNotNullParameter(ttsAnnotation, "ttsAnnotation");
            this.annotations.add(new MutableRange(ttsAnnotation, start, end, (String) null, 8, (DefaultConstructorMarker) null));
        }

        public final void addUrlAnnotation(UrlAnnotation urlAnnotation, int start, int end) {
            Intrinsics.checkNotNullParameter(urlAnnotation, "urlAnnotation");
            this.annotations.add(new MutableRange(urlAnnotation, start, end, (String) null, 8, (DefaultConstructorMarker) null));
        }

        public final int pushStyle(SpanStyle style) {
            Intrinsics.checkNotNullParameter(style, "style");
            MutableRange mutableRange = new MutableRange(style, this.text.length(), 0, (String) null, 12, (DefaultConstructorMarker) null);
            this.styleStack.add(mutableRange);
            this.spanStyles.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final int pushStyle(ParagraphStyle style) {
            Intrinsics.checkNotNullParameter(style, "style");
            MutableRange mutableRange = new MutableRange(style, this.text.length(), 0, (String) null, 12, (DefaultConstructorMarker) null);
            this.styleStack.add(mutableRange);
            this.paragraphStyles.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final int pushStringAnnotation(String tag, String annotation) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            MutableRange mutableRange = new MutableRange(annotation, this.text.length(), 0, tag, 4, (DefaultConstructorMarker) null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final int pushTtsAnnotation(TtsAnnotation ttsAnnotation) {
            Intrinsics.checkNotNullParameter(ttsAnnotation, "ttsAnnotation");
            MutableRange mutableRange = new MutableRange(ttsAnnotation, this.text.length(), 0, (String) null, 12, (DefaultConstructorMarker) null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final int pushUrlAnnotation(UrlAnnotation urlAnnotation) {
            Intrinsics.checkNotNullParameter(urlAnnotation, "urlAnnotation");
            MutableRange mutableRange = new MutableRange(urlAnnotation, this.text.length(), 0, (String) null, 12, (DefaultConstructorMarker) null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final void pop() {
            if (!this.styleStack.isEmpty()) {
                List<MutableRange<? extends Object>> list = this.styleStack;
                list.remove(list.size() - 1).setEnd(this.text.length());
                return;
            }
            throw new IllegalStateException("Nothing to pop.".toString());
        }

        public final void pop(int index) {
            if (index < this.styleStack.size()) {
                while (this.styleStack.size() - 1 >= index) {
                    pop();
                }
                return;
            }
            throw new IllegalStateException((index + " should be less than " + this.styleStack.size()).toString());
        }

        public final AnnotatedString toAnnotatedString() {
            String sb = this.text.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "text.toString()");
            List list = this.spanStyles;
            List target$iv = new ArrayList(list.size());
            List $this$fastForEach$iv$iv = list;
            int size = $this$fastForEach$iv$iv.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                target$iv.add(((MutableRange) $this$fastForEach$iv$iv.get(index$iv$iv)).toRange(this.text.length()));
            }
            Collection collection = target$iv;
            if (collection.isEmpty()) {
                collection = null;
            }
            List list2 = (List) collection;
            List list3 = this.paragraphStyles;
            List target$iv2 = new ArrayList(list3.size());
            List $this$fastForEach$iv$iv2 = list3;
            int size2 = $this$fastForEach$iv$iv2.size();
            for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                target$iv2.add(((MutableRange) $this$fastForEach$iv$iv2.get(index$iv$iv2)).toRange(this.text.length()));
            }
            Collection collection2 = target$iv2;
            if (collection2.isEmpty()) {
                collection2 = null;
            }
            List list4 = (List) collection2;
            List $this$fastMap$iv = this.annotations;
            ArrayList target$iv3 = new ArrayList($this$fastMap$iv.size());
            List $this$fastForEach$iv$iv3 = $this$fastMap$iv;
            int index$iv$iv3 = 0;
            int size3 = $this$fastForEach$iv$iv3.size();
            while (index$iv$iv3 < size3) {
                target$iv3.add(((MutableRange) $this$fastForEach$iv$iv3.get(index$iv$iv3)).toRange(this.text.length()));
                index$iv$iv3++;
                $this$fastMap$iv = $this$fastMap$iv;
            }
            Collection collection3 = target$iv3;
            if (collection3.isEmpty()) {
                collection3 = null;
            }
            return new AnnotatedString(sb, list2, list4, (List) collection3);
        }
    }
}
