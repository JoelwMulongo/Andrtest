package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"ThreadLocal", "Landroidx/compose/runtime/ThreadLocal;", "T", "postIncrement", "", "Landroidx/compose/runtime/AtomicInt;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Expect.kt */
public final class ExpectKt {
    public static final <T> ThreadLocal<T> ThreadLocal() {
        return new ThreadLocal<>(ExpectKt$ThreadLocal$1.INSTANCE);
    }

    public static final int postIncrement(AtomicInt $this$postIncrement) {
        Intrinsics.checkNotNullParameter($this$postIncrement, "<this>");
        return $this$postIncrement.add(1) - 1;
    }
}
