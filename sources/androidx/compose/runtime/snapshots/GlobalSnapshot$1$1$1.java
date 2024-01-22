package androidx.compose.runtime.snapshots;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "state", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snapshot.kt */
final class GlobalSnapshot$1$1$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ List<Function1<Object, Unit>> $it;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalSnapshot$1$1$1(List<Function1<Object, Unit>> list) {
        super(1);
        this.$it = list;
    }

    public final void invoke(Object state) {
        Intrinsics.checkNotNullParameter(state, "state");
        List $this$fastForEach$iv = this.$it;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            $this$fastForEach$iv.get(index$iv).invoke(state);
        }
    }
}
