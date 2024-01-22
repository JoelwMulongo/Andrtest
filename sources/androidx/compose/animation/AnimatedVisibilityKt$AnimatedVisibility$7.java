package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedVisibility.kt */
final class AnimatedVisibilityKt$AnimatedVisibility$7 extends Lambda implements Function1<Boolean, Boolean> {
    public static final AnimatedVisibilityKt$AnimatedVisibility$7 INSTANCE = new AnimatedVisibilityKt$AnimatedVisibility$7();

    AnimatedVisibilityKt$AnimatedVisibility$7() {
        super(1);
    }

    public final Boolean invoke(boolean it) {
        return Boolean.valueOf(it);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Boolean) p1).booleanValue());
    }
}
