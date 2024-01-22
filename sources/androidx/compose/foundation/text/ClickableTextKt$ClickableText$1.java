package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ClickableText.kt */
final class ClickableTextKt$ClickableText$1 extends Lambda implements Function1<TextLayoutResult, Unit> {
    public static final ClickableTextKt$ClickableText$1 INSTANCE = new ClickableTextKt$ClickableText$1();

    ClickableTextKt$ClickableText$1() {
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
