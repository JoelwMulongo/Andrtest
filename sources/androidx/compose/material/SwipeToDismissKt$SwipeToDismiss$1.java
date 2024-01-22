package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismiss.kt */
final class SwipeToDismissKt$SwipeToDismiss$1 extends Lambda implements Function1<DismissDirection, FixedThreshold> {
    public static final SwipeToDismissKt$SwipeToDismiss$1 INSTANCE = new SwipeToDismissKt$SwipeToDismiss$1();

    SwipeToDismissKt$SwipeToDismiss$1() {
        super(1);
    }

    public final FixedThreshold invoke(DismissDirection it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new FixedThreshold(SwipeToDismissKt.DISMISS_THRESHOLD, (DefaultConstructorMarker) null);
    }
}
