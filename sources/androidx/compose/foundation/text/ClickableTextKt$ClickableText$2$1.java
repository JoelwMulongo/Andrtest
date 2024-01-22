package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ClickableText.kt */
final class ClickableTextKt$ClickableText$2$1 extends Lambda implements Function1<TextLayoutResult, Unit> {
    final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;
    final /* synthetic */ Function1<TextLayoutResult, Unit> $onTextLayout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableTextKt$ClickableText$2$1(MutableState<TextLayoutResult> mutableState, Function1<? super TextLayoutResult, Unit> function1) {
        super(1);
        this.$layoutResult = mutableState;
        this.$onTextLayout = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((TextLayoutResult) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(TextLayoutResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this.$layoutResult.setValue(it);
        this.$onTextLayout.invoke(it);
    }
}
