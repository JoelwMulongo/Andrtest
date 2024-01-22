package androidx.compose.foundation.pager;

import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/foundation/pager/PagerState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerState.kt */
final class PagerState$Companion$Saver$1 extends Lambda implements Function2<SaverScope, PagerState, List<? extends Object>> {
    public static final PagerState$Companion$Saver$1 INSTANCE = new PagerState$Companion$Saver$1();

    PagerState$Companion$Saver$1() {
        super(2);
    }

    public final List<Object> invoke(SaverScope $this$listSaver, PagerState it) {
        Intrinsics.checkNotNullParameter($this$listSaver, "$this$listSaver");
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.listOf(Integer.valueOf(it.getCurrentPage()), Float.valueOf(it.getCurrentPageOffsetFraction()));
    }
}
