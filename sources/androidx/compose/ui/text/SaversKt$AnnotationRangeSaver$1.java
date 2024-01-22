package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/ui/text/AnnotatedString$Range;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$AnnotationRangeSaver$1 extends Lambda implements Function2<SaverScope, AnnotatedString.Range<? extends Object>, Object> {
    public static final SaversKt$AnnotationRangeSaver$1 INSTANCE = new SaversKt$AnnotationRangeSaver$1();

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

    SaversKt$AnnotationRangeSaver$1() {
        super(2);
    }

    public final Object invoke(SaverScope $this$Saver, AnnotatedString.Range<? extends Object> it) {
        AnnotationType marker;
        Object item;
        Intrinsics.checkNotNullParameter($this$Saver, "$this$Saver");
        Intrinsics.checkNotNullParameter(it, "it");
        Object item2 = it.getItem();
        if (item2 instanceof ParagraphStyle) {
            marker = AnnotationType.Paragraph;
        } else if (item2 instanceof SpanStyle) {
            marker = AnnotationType.Span;
        } else if (item2 instanceof VerbatimTtsAnnotation) {
            marker = AnnotationType.VerbatimTts;
        } else if (item2 instanceof UrlAnnotation) {
            marker = AnnotationType.Url;
        } else {
            marker = AnnotationType.String;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[marker.ordinal()]) {
            case 1:
                Object item3 = it.getItem();
                Intrinsics.checkNotNull(item3, "null cannot be cast to non-null type androidx.compose.ui.text.ParagraphStyle");
                item = SaversKt.save((ParagraphStyle) item3, SaversKt.getParagraphStyleSaver(), $this$Saver);
                break;
            case 2:
                Object item4 = it.getItem();
                Intrinsics.checkNotNull(item4, "null cannot be cast to non-null type androidx.compose.ui.text.SpanStyle");
                item = SaversKt.save((SpanStyle) item4, SaversKt.getSpanStyleSaver(), $this$Saver);
                break;
            case 3:
                Object item5 = it.getItem();
                Intrinsics.checkNotNull(item5, "null cannot be cast to non-null type androidx.compose.ui.text.VerbatimTtsAnnotation");
                item = SaversKt.save((VerbatimTtsAnnotation) item5, SaversKt.VerbatimTtsAnnotationSaver, $this$Saver);
                break;
            case 4:
                Object item6 = it.getItem();
                Intrinsics.checkNotNull(item6, "null cannot be cast to non-null type androidx.compose.ui.text.UrlAnnotation");
                item = SaversKt.save((UrlAnnotation) item6, SaversKt.UrlAnnotationSaver, $this$Saver);
                break;
            case 5:
                item = SaversKt.save(it.getItem());
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return CollectionsKt.arrayListOf(SaversKt.save(marker), item, SaversKt.save(Integer.valueOf(it.getStart())), SaversKt.save(Integer.valueOf(it.getEnd())), SaversKt.save(it.getTag()));
    }
}
