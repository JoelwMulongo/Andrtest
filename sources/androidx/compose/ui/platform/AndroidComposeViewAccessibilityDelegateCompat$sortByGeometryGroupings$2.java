package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.semantics.SemanticsNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Rect;", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
final class AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2 extends Lambda implements Function1<Pair<? extends Rect, ? extends List<SemanticsNode>>, Comparable<?>> {
    public static final AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2 INSTANCE = new AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2();

    AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2() {
        super(1);
    }

    public final Comparable<?> invoke(Pair<Rect, ? extends List<SemanticsNode>> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Float.valueOf(it.getFirst().getBottom());
    }
}
