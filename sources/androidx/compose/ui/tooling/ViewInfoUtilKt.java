package androidx.compose.ui.tooling;

import androidx.compose.ui.tooling.data.SourceLocation;
import androidx.compose.ui.unit.IntRect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u001a2\u0010\u0006\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¨\u0006\n"}, d2 = {"filterTree", "", "Landroidx/compose/ui/tooling/ViewInfo;", "filter", "Lkotlin/Function1;", "", "toDebugString", "", "indentation", "", "ui-tooling_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewInfoUtil.kt */
public final class ViewInfoUtilKt {
    static /* synthetic */ List filterTree$default(List list, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ViewInfoUtilKt$filterTree$1.INSTANCE;
        }
        return filterTree(list, function1);
    }

    private static final List<ViewInfo> filterTree(List<ViewInfo> $this$filterTree, Function1<? super ViewInfo, Boolean> filter) {
        List list$iv$iv;
        Iterable $this$flatMap$iv;
        Function1<? super ViewInfo, Boolean> function1 = filter;
        Iterable<ViewInfo> list$iv$iv2 = $this$filterTree;
        Collection destination$iv$iv = new ArrayList();
        for (ViewInfo it : list$iv$iv2) {
            Collection destination$iv$iv2 = new ArrayList();
            for (ViewInfo child : filterTree(it.getChildren(), function1)) {
                if (child.getLocation() == null) {
                    $this$flatMap$iv = child.getChildren();
                } else {
                    $this$flatMap$iv = CollectionsKt.listOf(child);
                }
                CollectionsKt.addAll(destination$iv$iv2, $this$flatMap$iv);
                list$iv$iv2 = list$iv$iv2;
            }
            Iterable $this$flatMap$iv2 = list$iv$iv2;
            List acceptedNodes = (List) destination$iv$iv2;
            if (function1.invoke(it).booleanValue()) {
                list$iv$iv = CollectionsKt.listOf(new ViewInfo(it.getFileName(), it.getLineNumber(), it.getBounds(), it.getLocation(), acceptedNodes, it.getLayoutInfo()));
            } else {
                list$iv$iv = CollectionsKt.listOf(new ViewInfo("<root>", -1, IntRect.Companion.getZero(), (SourceLocation) null, acceptedNodes, (Object) null));
            }
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            list$iv$iv2 = $this$flatMap$iv2;
        }
        Iterable $this$flatMap$iv3 = list$iv$iv2;
        return (List) destination$iv$iv;
    }

    public static /* synthetic */ String toDebugString$default(List list, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            function1 = ViewInfoUtilKt$toDebugString$1.INSTANCE;
        }
        return toDebugString(list, i, function1);
    }

    public static final String toDebugString(List<ViewInfo> $this$toDebugString, int indentation, Function1<? super ViewInfo, Boolean> filter) {
        List<ViewInfo> list = $this$toDebugString;
        int i = indentation;
        Function1<? super ViewInfo, Boolean> function1 = filter;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "filter");
        String indentString = StringsKt.repeat(".", i);
        StringBuilder builder = new StringBuilder();
        for (ViewInfo it : CollectionsKt.sortedWith(filterTree(list, function1), ComparisonsKt.compareBy((Function1<? super T, ? extends Comparable<?>>[]) new Function1[]{ViewInfoUtilKt$toDebugString$2.INSTANCE, ViewInfoUtilKt$toDebugString$3.INSTANCE, ViewInfoUtilKt$toDebugString$4.INSTANCE}))) {
            if (it.getLocation() != null) {
                StringBuilder append = builder.append(indentString + '|' + it.getFileName() + ':' + it.getLineNumber());
                Intrinsics.checkNotNullExpressionValue(append, "append(value)");
                Intrinsics.checkNotNullExpressionValue(append.append(10), "append('\\n')");
            } else {
                StringBuilder append2 = builder.append(indentString + "|<root>");
                Intrinsics.checkNotNullExpressionValue(append2, "append(value)");
                Intrinsics.checkNotNullExpressionValue(append2.append(10), "append('\\n')");
            }
            String childrenString = StringsKt.trim((CharSequence) toDebugString(it.getChildren(), i + 1, function1)).toString();
            if (childrenString.length() > 0) {
                StringBuilder append3 = builder.append(childrenString);
                Intrinsics.checkNotNullExpressionValue(append3, "append(value)");
                Intrinsics.checkNotNullExpressionValue(append3.append(10), "append('\\n')");
            }
        }
        String sb = builder.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "builder.toString()");
        return sb;
    }
}
