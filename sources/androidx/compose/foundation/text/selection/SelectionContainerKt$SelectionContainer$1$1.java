package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionContainer.kt */
final class SelectionContainerKt$SelectionContainer$1$1 extends Lambda implements Function1<Selection, Unit> {
    final /* synthetic */ MutableState<Selection> $selection$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionContainerKt$SelectionContainer$1$1(MutableState<Selection> mutableState) {
        super(1);
        this.$selection$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Selection) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Selection it) {
        SelectionContainerKt.SelectionContainer$lambda$2(this.$selection$delegate, it);
    }
}
