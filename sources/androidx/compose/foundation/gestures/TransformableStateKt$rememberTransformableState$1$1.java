package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TransformableState.kt */
final class TransformableStateKt$rememberTransformableState$1$1 extends Lambda implements Function3<Float, Offset, Float, Unit> {
    final /* synthetic */ State<Function3<Float, Offset, Float, Unit>> $lambdaState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransformableStateKt$rememberTransformableState$1$1(State<? extends Function3<? super Float, ? super Offset, ? super Float, Unit>> state) {
        super(3);
        this.$lambdaState = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        m649invoked4ec7I(((Number) p1).floatValue(), ((Offset) p2).m2925unboximpl(), ((Number) p3).floatValue());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-d-4ec7I  reason: not valid java name */
    public final void m649invoked4ec7I(float z, long p, float r) {
        this.$lambdaState.getValue().invoke(Float.valueOf(z), Offset.m2904boximpl(p), Float.valueOf(r));
    }
}
