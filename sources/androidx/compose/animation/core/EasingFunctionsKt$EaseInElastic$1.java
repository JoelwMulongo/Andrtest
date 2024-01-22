package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "fraction"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: EasingFunctions.kt */
final class EasingFunctionsKt$EaseInElastic$1 implements Easing {
    public static final EasingFunctionsKt$EaseInElastic$1 INSTANCE = new EasingFunctionsKt$EaseInElastic$1();

    EasingFunctionsKt$EaseInElastic$1() {
    }

    public final float transform(float fraction) {
        boolean z = true;
        if (fraction == 0.0f) {
            return 0.0f;
        }
        if (fraction != 1.0f) {
            z = false;
        }
        if (z) {
            return 1.0f;
        }
        return (float) (((double) (-((float) Math.pow((double) 2.0f, (double) ((fraction * 10.0f) - 10.0f))))) * Math.sin(((double) ((10.0f * fraction) - 10.75f)) * 2.0943951023931953d));
    }
}
