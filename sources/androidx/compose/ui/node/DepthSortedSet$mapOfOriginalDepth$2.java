package androidx.compose.ui.node;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/node/LayoutNode;", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DepthSortedSet.kt */
final class DepthSortedSet$mapOfOriginalDepth$2 extends Lambda implements Function0<Map<LayoutNode, Integer>> {
    public static final DepthSortedSet$mapOfOriginalDepth$2 INSTANCE = new DepthSortedSet$mapOfOriginalDepth$2();

    DepthSortedSet$mapOfOriginalDepth$2() {
        super(0);
    }

    public final Map<LayoutNode, Integer> invoke() {
        return new LinkedHashMap<>();
    }
}
