package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "T", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeableV2.kt */
final class SwipeableV2State$progress$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeableV2State$progress$2(SwipeableV2State<T> swipeableV2State) {
        super(0);
        this.this$0 = swipeableV2State;
    }

    public final Float invoke() {
        Float f = this.this$0.getAnchors$material_release().get(this.this$0.getCurrentValue());
        float f2 = 0.0f;
        float a = f != null ? f.floatValue() : 0.0f;
        Float f3 = this.this$0.getAnchors$material_release().get(this.this$0.getTargetValue());
        float b = f3 != null ? f3.floatValue() : 0.0f;
        if (Math.abs(b - a) > 1.0E-6f) {
            float progress = (this.this$0.requireOffset() - a) / (b - a);
            if (progress >= 1.0E-6f) {
                f2 = progress > 0.999999f ? 1.0f : progress;
            }
        } else {
            f2 = 1.0f;
        }
        return Float.valueOf(f2);
    }
}
