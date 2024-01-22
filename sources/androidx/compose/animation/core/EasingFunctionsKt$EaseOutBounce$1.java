package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "fraction"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: EasingFunctions.kt */
final class EasingFunctionsKt$EaseOutBounce$1 implements Easing {
    public static final EasingFunctionsKt$EaseOutBounce$1 INSTANCE = new EasingFunctionsKt$EaseOutBounce$1();

    EasingFunctionsKt$EaseOutBounce$1() {
    }

    public final float transform(float fraction) {
        float newFraction = fraction;
        if (newFraction < 1.0f / 2.75f) {
            return 7.5625f * newFraction * newFraction;
        }
        if (newFraction < 2.0f / 2.75f) {
            float newFraction2 = newFraction - (1.5f / 2.75f);
            return (7.5625f * newFraction2 * newFraction2) + 0.75f;
        } else if (newFraction < 2.5f / 2.75f) {
            float newFraction3 = newFraction - (2.25f / 2.75f);
            return (7.5625f * newFraction3 * newFraction3) + 0.9375f;
        } else {
            float newFraction4 = newFraction - (2.625f / 2.75f);
            return (7.5625f * newFraction4 * newFraction4) + 0.984375f;
        }
    }
}
