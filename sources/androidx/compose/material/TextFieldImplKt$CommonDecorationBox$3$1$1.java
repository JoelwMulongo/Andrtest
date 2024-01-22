package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldImplKt$CommonDecorationBox$3$1$1 extends Lambda implements Function1<Size, Unit> {
    final /* synthetic */ float $labelProgress;
    final /* synthetic */ MutableState<Size> $labelSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$CommonDecorationBox$3$1$1(float f, MutableState<Size> mutableState) {
        super(1);
        this.$labelProgress = f;
        this.$labelSize = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        m1685invokeuvyYCjk(((Size) p1).m2989unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-uvyYCjk  reason: not valid java name */
    public final void m1685invokeuvyYCjk(long it) {
        float labelWidth = Size.m2984getWidthimpl(it) * this.$labelProgress;
        float labelHeight = Size.m2981getHeightimpl(it) * this.$labelProgress;
        boolean z = true;
        if (Size.m2984getWidthimpl(this.$labelSize.getValue().m2989unboximpl()) == labelWidth) {
            if (Size.m2981getHeightimpl(this.$labelSize.getValue().m2989unboximpl()) != labelHeight) {
                z = false;
            }
            if (z) {
                return;
            }
        }
        this.$labelSize.setValue(Size.m2972boximpl(SizeKt.Size(labelWidth, labelHeight)));
    }
}
