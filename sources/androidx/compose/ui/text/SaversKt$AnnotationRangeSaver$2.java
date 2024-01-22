package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/AnnotatedString$Range;", "", "it", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$AnnotationRangeSaver$2 extends Lambda implements Function1<Object, AnnotatedString.Range<? extends Object>> {
    public static final SaversKt$AnnotationRangeSaver$2 INSTANCE = new SaversKt$AnnotationRangeSaver$2();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Savers.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            try {
                iArr[AnnotationType.Paragraph.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[AnnotationType.Span.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[AnnotationType.Url.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[AnnotationType.String.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    SaversKt$AnnotationRangeSaver$2() {
        super(1);
    }

    public final AnnotatedString.Range<? extends Object> invoke(Object it) {
        AnnotationType annotationType;
        Object it$iv;
        Object it$iv2;
        String str;
        Intrinsics.checkNotNullParameter(it, "it");
        List list = (List) it;
        Object value$iv = list.get(0);
        Object it$iv3 = null;
        if (value$iv != null) {
            annotationType = (AnnotationType) value$iv;
        } else {
            annotationType = null;
        }
        Intrinsics.checkNotNull(annotationType);
        AnnotationType marker = annotationType;
        Object value$iv2 = list.get(2);
        if (value$iv2 != null) {
            it$iv = (Integer) value$iv2;
        } else {
            it$iv = null;
        }
        Intrinsics.checkNotNull(it$iv);
        int start = ((Number) it$iv).intValue();
        Object value$iv3 = list.get(3);
        if (value$iv3 != null) {
            it$iv2 = (Integer) value$iv3;
        } else {
            it$iv2 = null;
        }
        Intrinsics.checkNotNull(it$iv2);
        int end = ((Number) it$iv2).intValue();
        Object value$iv4 = list.get(4);
        if (value$iv4 != null) {
            str = (String) value$iv4;
        } else {
            str = null;
        }
        Intrinsics.checkNotNull(str);
        String tag = str;
        switch (WhenMappings.$EnumSwitchMapping$0[marker.ordinal()]) {
            case 1:
                Object value$iv5 = list.get(1);
                Saver $this$restore_u24lambda_u243_u24lambda_u242$iv = SaversKt.getParagraphStyleSaver();
                if (!Intrinsics.areEqual(value$iv5, (Object) false) && value$iv5 != null) {
                    Object obj = value$iv5;
                    it$iv3 = (ParagraphStyle) $this$restore_u24lambda_u243_u24lambda_u242$iv.restore(value$iv5);
                }
                Intrinsics.checkNotNull(it$iv3);
                return new AnnotatedString.Range<>(it$iv3, start, end, tag);
            case 2:
                Object value$iv6 = list.get(1);
                Saver $this$restore_u24lambda_u243_u24lambda_u242$iv2 = SaversKt.getSpanStyleSaver();
                if (!Intrinsics.areEqual(value$iv6, (Object) false) && value$iv6 != null) {
                    Object obj2 = value$iv6;
                    it$iv3 = (SpanStyle) $this$restore_u24lambda_u243_u24lambda_u242$iv2.restore(value$iv6);
                }
                Intrinsics.checkNotNull(it$iv3);
                return new AnnotatedString.Range<>(it$iv3, start, end, tag);
            case 3:
                Object value$iv7 = list.get(1);
                Saver saver$iv = SaversKt.VerbatimTtsAnnotationSaver;
                if (!Intrinsics.areEqual(value$iv7, (Object) false) && value$iv7 != null) {
                    Object obj3 = value$iv7;
                    it$iv3 = (VerbatimTtsAnnotation) saver$iv.restore(value$iv7);
                }
                Intrinsics.checkNotNull(it$iv3);
                return new AnnotatedString.Range<>(it$iv3, start, end, tag);
            case 4:
                Object value$iv8 = list.get(1);
                Saver saver$iv2 = SaversKt.UrlAnnotationSaver;
                if (!Intrinsics.areEqual(value$iv8, (Object) false) && value$iv8 != null) {
                    Object obj4 = value$iv8;
                    it$iv3 = (UrlAnnotation) saver$iv2.restore(value$iv8);
                }
                Intrinsics.checkNotNull(it$iv3);
                return new AnnotatedString.Range<>(it$iv3, start, end, tag);
            case 5:
                Object value$iv9 = list.get(1);
                if (value$iv9 != null) {
                    it$iv3 = (String) value$iv9;
                }
                Intrinsics.checkNotNull(it$iv3);
                return new AnnotatedString.Range<>(it$iv3, start, end, tag);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
