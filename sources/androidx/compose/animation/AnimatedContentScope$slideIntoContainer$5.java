package androidx.compose.animation;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "S", "it", "invoke", "(I)Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
final class AnimatedContentScope$slideIntoContainer$5 extends Lambda implements Function1<Integer, Integer> {
    final /* synthetic */ Function1<Integer, Integer> $initialOffset;
    final /* synthetic */ AnimatedContentScope<S> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimatedContentScope$slideIntoContainer$5(Function1<? super Integer, Integer> function1, AnimatedContentScope<S> animatedContentScope) {
        super(1);
        this.$initialOffset = function1;
        this.this$0 = animatedContentScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).intValue());
    }

    public final Integer invoke(int it) {
        return this.$initialOffset.invoke(Integer.valueOf((-IntOffset.m6105getYimpl(this.this$0.m307calculateOffsetemnUabE(IntSizeKt.IntSize(it, it), this.this$0.m308getCurrentSizeYbymL2g()))) - it));
    }
}
