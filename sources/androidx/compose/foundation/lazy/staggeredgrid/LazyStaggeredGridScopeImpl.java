package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JI\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0016¢\u0006\u0002\u0010\u0014J·\u0001\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172#\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00102#\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00102#\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001021\u0010\u001b\u001a-\u0012\u0004\u0012\u00020\u0011\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\t0\u001c¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0016¢\u0006\u0002\u0010\u001dR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScopeImpl;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "()V", "intervals", "Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridIntervalContent;", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "item", "", "key", "", "contentType", "span", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/ParameterName;", "name", "index", "itemContent", "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridScope.kt */
public final class LazyStaggeredGridScopeImpl implements LazyStaggeredGridScope {
    private final MutableIntervalList<LazyStaggeredGridIntervalContent> intervals = new MutableIntervalList<>();

    public final MutableIntervalList<LazyStaggeredGridIntervalContent> getIntervals() {
        return this.intervals;
    }

    public void item(Object key, Object contentType, StaggeredGridItemSpan span, Function3<? super LazyStaggeredGridItemScope, ? super Composer, ? super Integer, Unit> content) {
        Function1 function1;
        Function1 function12;
        Intrinsics.checkNotNullParameter(content, "content");
        if (key != null) {
            Object obj = key;
            function1 = new LazyStaggeredGridScopeImpl$item$1$1(key);
        } else {
            function1 = null;
        }
        Function1 lazyStaggeredGridScopeImpl$item$2 = new LazyStaggeredGridScopeImpl$item$2(contentType);
        if (span != null) {
            StaggeredGridItemSpan staggeredGridItemSpan = span;
            function12 = new LazyStaggeredGridScopeImpl$item$3$1(span);
        } else {
            function12 = null;
        }
        items(1, function1, lazyStaggeredGridScopeImpl$item$2, function12, ComposableLambdaKt.composableLambdaInstance(1700162468, true, new LazyStaggeredGridScopeImpl$item$4(content)));
    }

    public void items(int count, Function1<? super Integer, ? extends Object> key, Function1<? super Integer, ? extends Object> contentType, Function1<? super Integer, StaggeredGridItemSpan> span, Function4<? super LazyStaggeredGridItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        this.intervals.addInterval(count, new LazyStaggeredGridIntervalContent(key, contentType, span, itemContent));
    }
}
