package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "fraction"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: EasingFunctions.kt */
final class EasingFunctionsKt$EaseInBounce$1 implements Easing {
    public static final EasingFunctionsKt$EaseInBounce$1 INSTANCE = new EasingFunctionsKt$EaseInBounce$1();

    EasingFunctionsKt$EaseInBounce$1() {
    }

    public final float transform(float fraction) {
        return ((float) 1) - EasingFunctionsKt.getEaseOutBounce().transform(1.0f - fraction);
    }
}
