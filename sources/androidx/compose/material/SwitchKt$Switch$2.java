package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
final class SwitchKt$Switch$2 extends Lambda implements Function2<Boolean, Boolean, ThresholdConfig> {
    public static final SwitchKt$Switch$2 INSTANCE = new SwitchKt$Switch$2();

    SwitchKt$Switch$2() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return invoke(((Boolean) p1).booleanValue(), ((Boolean) p2).booleanValue());
    }

    public final ThresholdConfig invoke(boolean z, boolean z2) {
        return new FractionalThreshold(0.5f);
    }
}
