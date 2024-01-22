package androidx.compose.runtime;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f¨\u0006\u0004"}, d2 = {"rol", "", "other", "ror", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BitwiseOperators.kt */
public final class BitwiseOperatorsKt {
    public static final int ror(int $this$ror, int other) {
        return Integer.rotateRight($this$ror, other);
    }

    public static final int rol(int $this$rol, int other) {
        return Integer.rotateLeft($this$rol, other);
    }
}
