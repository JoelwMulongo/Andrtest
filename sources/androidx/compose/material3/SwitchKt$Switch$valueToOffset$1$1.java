package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Switch.kt */
final class SwitchKt$Switch$valueToOffset$1$1 extends Lambda implements Function1<Boolean, Float> {
    final /* synthetic */ float $maxBound;
    final /* synthetic */ float $minBound;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwitchKt$Switch$valueToOffset$1$1(float f, float f2) {
        super(1);
        this.$maxBound = f;
        this.$minBound = f2;
    }

    public final Float invoke(boolean value) {
        return Float.valueOf(value ? this.$maxBound : this.$minBound);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Boolean) p1).booleanValue());
    }
}
