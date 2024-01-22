package androidx.compose.material;

import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Text.kt */
final class TextKt$Text$3 extends Lambda implements Function1<TextLayoutResult, Unit> {
    public static final TextKt$Text$3 INSTANCE = new TextKt$Text$3();

    TextKt$Text$3() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((TextLayoutResult) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(TextLayoutResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
    }
}
