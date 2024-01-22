package androidx.compose.runtime.saveable;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "Original", "Saveable", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "invoke", "(Landroidx/compose/runtime/saveable/SaverScope;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListSaver.kt */
final class ListSaverKt$listSaver$1 extends Lambda implements Function2<SaverScope, Original, Object> {
    final /* synthetic */ Function2<SaverScope, Original, List<Saveable>> $save;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListSaverKt$listSaver$1(Function2<? super SaverScope, ? super Original, ? extends List<? extends Saveable>> function2) {
        super(2);
        this.$save = function2;
    }

    public final Object invoke(SaverScope $this$Saver, Original it) {
        Intrinsics.checkNotNullParameter($this$Saver, "$this$Saver");
        List list = this.$save.invoke($this$Saver, it);
        int index = 0;
        int size = list.size();
        while (index < size) {
            Object item = list.get(index);
            if (item == null || $this$Saver.canBeSaved(item)) {
                index++;
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
        if (!list.isEmpty()) {
            return new ArrayList(list);
        }
        return null;
    }
}
