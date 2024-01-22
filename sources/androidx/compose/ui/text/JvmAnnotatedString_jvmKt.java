package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u001a,\u0010\b\u001a\u00020\t*\u00020\t2\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nH\u0000¨\u0006\f"}, d2 = {"collectRangeTransitions", "", "ranges", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "target", "Ljava/util/SortedSet;", "", "transform", "Landroidx/compose/ui/text/AnnotatedString;", "Lkotlin/Function3;", "", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: JvmAnnotatedString.jvm.kt */
public final class JvmAnnotatedString_jvmKt {
    public static final AnnotatedString transform(AnnotatedString $this$transform, Function3<? super String, ? super Integer, ? super Integer, String> transform) {
        List newSpanStyles;
        List newParaStyles;
        List newAnnotations;
        AnnotatedString annotatedString = $this$transform;
        Function3<? super String, ? super Integer, ? super Integer, String> function3 = transform;
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(function3, "transform");
        TreeSet transitions = SetsKt.sortedSetOf(0, Integer.valueOf($this$transform.getText().length()));
        collectRangeTransitions($this$transform.getSpanStylesOrNull$ui_text_release(), transitions);
        collectRangeTransitions($this$transform.getParagraphStylesOrNull$ui_text_release(), transitions);
        collectRangeTransitions($this$transform.getAnnotations$ui_text_release(), transitions);
        Ref.ObjectRef resultStr = new Ref.ObjectRef();
        resultStr.element = "";
        Map offsetMap = MapsKt.mutableMapOf(TuplesKt.to(0, 0));
        CollectionsKt.windowed$default(transitions, 2, 0, false, new JvmAnnotatedString_jvmKt$transform$1(resultStr, function3, annotatedString, offsetMap), 6, (Object) null);
        List $this$fastMap$iv = $this$transform.getSpanStylesOrNull$ui_text_release();
        if ($this$fastMap$iv != null) {
            ArrayList target$iv = new ArrayList($this$fastMap$iv.size());
            List $this$fastForEach$iv$iv = $this$fastMap$iv;
            int index$iv$iv = 0;
            int size = $this$fastForEach$iv$iv.size();
            while (index$iv$iv < size) {
                AnnotatedString.Range it = (AnnotatedString.Range) $this$fastForEach$iv$iv.get(index$iv$iv);
                Object item = it.getItem();
                TreeSet transitions2 = transitions;
                Object obj = offsetMap.get(Integer.valueOf(it.getStart()));
                Intrinsics.checkNotNull(obj);
                int intValue = ((Number) obj).intValue();
                List $this$fastMap$iv2 = $this$fastMap$iv;
                Object obj2 = offsetMap.get(Integer.valueOf(it.getEnd()));
                Intrinsics.checkNotNull(obj2);
                target$iv.add(new AnnotatedString.Range(item, intValue, ((Number) obj2).intValue()));
                index$iv$iv++;
                AnnotatedString annotatedString2 = $this$transform;
                Function3<? super String, ? super Integer, ? super Integer, String> function32 = transform;
                transitions = transitions2;
                $this$fastMap$iv = $this$fastMap$iv2;
            }
            List list = $this$fastMap$iv;
            newSpanStyles = target$iv;
        } else {
            newSpanStyles = null;
        }
        List $this$fastMap$iv3 = $this$transform.getParagraphStylesOrNull$ui_text_release();
        if ($this$fastMap$iv3 != null) {
            int $i$f$fastMap = false;
            ArrayList target$iv2 = new ArrayList($this$fastMap$iv3.size());
            List $this$fastForEach$iv$iv2 = $this$fastMap$iv3;
            int $i$f$fastForEach = false;
            int index$iv$iv2 = 0;
            int size2 = $this$fastForEach$iv$iv2.size();
            while (index$iv$iv2 < size2) {
                AnnotatedString.Range it2 = (AnnotatedString.Range) $this$fastForEach$iv$iv2.get(index$iv$iv2);
                int $i$f$fastMap2 = $i$f$fastMap;
                Object item2 = it2.getItem();
                List $this$fastForEach$iv$iv3 = $this$fastForEach$iv$iv2;
                Object obj3 = offsetMap.get(Integer.valueOf(it2.getStart()));
                Intrinsics.checkNotNull(obj3);
                int intValue2 = ((Number) obj3).intValue();
                int $i$f$fastForEach2 = $i$f$fastForEach;
                Object obj4 = offsetMap.get(Integer.valueOf(it2.getEnd()));
                Intrinsics.checkNotNull(obj4);
                target$iv2.add(new AnnotatedString.Range(item2, intValue2, ((Number) obj4).intValue()));
                index$iv$iv2++;
                $this$fastMap$iv3 = $this$fastMap$iv3;
                $i$f$fastMap = $i$f$fastMap2;
                $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv3;
                $i$f$fastForEach = $i$f$fastForEach2;
            }
            int i = $i$f$fastMap;
            List list2 = $this$fastForEach$iv$iv2;
            int i2 = $i$f$fastForEach;
            newParaStyles = target$iv2;
        } else {
            newParaStyles = null;
        }
        List $this$fastMap$iv4 = $this$transform.getAnnotations$ui_text_release();
        if ($this$fastMap$iv4 != null) {
            int $i$f$fastMap3 = false;
            ArrayList target$iv3 = new ArrayList($this$fastMap$iv4.size());
            List $this$fastForEach$iv$iv4 = $this$fastMap$iv4;
            int $i$f$fastForEach3 = false;
            int index$iv$iv3 = 0;
            int size3 = $this$fastForEach$iv$iv4.size();
            while (index$iv$iv3 < size3) {
                AnnotatedString.Range it3 = (AnnotatedString.Range) $this$fastForEach$iv$iv4.get(index$iv$iv3);
                int $i$f$fastMap4 = $i$f$fastMap3;
                Object item3 = it3.getItem();
                List $this$fastForEach$iv$iv5 = $this$fastForEach$iv$iv4;
                Object obj5 = offsetMap.get(Integer.valueOf(it3.getStart()));
                Intrinsics.checkNotNull(obj5);
                int intValue3 = ((Number) obj5).intValue();
                int $i$f$fastForEach4 = $i$f$fastForEach3;
                Object obj6 = offsetMap.get(Integer.valueOf(it3.getEnd()));
                Intrinsics.checkNotNull(obj6);
                target$iv3.add(new AnnotatedString.Range(item3, intValue3, ((Number) obj6).intValue()));
                index$iv$iv3++;
                $this$fastMap$iv4 = $this$fastMap$iv4;
                $i$f$fastMap3 = $i$f$fastMap4;
                $this$fastForEach$iv$iv4 = $this$fastForEach$iv$iv5;
                $i$f$fastForEach3 = $i$f$fastForEach4;
            }
            int i3 = $i$f$fastMap3;
            List list3 = $this$fastForEach$iv$iv4;
            int i4 = $i$f$fastForEach3;
            newAnnotations = target$iv3;
        } else {
            newAnnotations = null;
        }
        return new AnnotatedString((String) resultStr.element, newSpanStyles, newParaStyles, newAnnotations);
    }

    private static final void collectRangeTransitions(List<? extends AnnotatedString.Range<?>> ranges, SortedSet<Integer> target) {
        if (ranges != null) {
            SortedSet acc = target;
            List $this$fastForEach$iv$iv = ranges;
            int size = $this$fastForEach$iv$iv.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                AnnotatedString.Range range = (AnnotatedString.Range) $this$fastForEach$iv$iv.get(index$iv$iv);
                SortedSet $this$collectRangeTransitions_u24lambda_u244_u24lambda_u243 = acc;
                $this$collectRangeTransitions_u24lambda_u244_u24lambda_u243.add(Integer.valueOf(range.getStart()));
                $this$collectRangeTransitions_u24lambda_u244_u24lambda_u243.add(Integer.valueOf(range.getEnd()));
            }
        }
    }
}
