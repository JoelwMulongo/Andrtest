package androidx.compose.ui.modifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007\u001a)\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006\"\u0006\u0012\u0002\b\u00030\u0004H\u0007¢\u0006\u0002\u0010\u0007\u001aA\u0010\u0000\u001a\u00020\u000122\u0010\b\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\n0\t0\u0006\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\u0010\u000b\u001a(\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u0002H\u00020\tH\u0007¨\u0006\r"}, d2 = {"modifierLocalMapOf", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "T", "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "keys", "", "([Landroidx/compose/ui/modifier/ModifierLocal;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "entries", "Lkotlin/Pair;", "", "([Lkotlin/Pair;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "entry", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModifierLocalNode.kt */
public final class ModifierLocalNodeKt {
    public static final ModifierLocalMap modifierLocalMapOf() {
        return EmptyMap.INSTANCE;
    }

    public static final <T> ModifierLocalMap modifierLocalMapOf(ModifierLocal<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new SingleLocalMap(key);
    }

    public static final <T> ModifierLocalMap modifierLocalMapOf(Pair<? extends ModifierLocal<T>, ? extends T> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        SingleLocalMap it = new SingleLocalMap((ModifierLocal) entry.getFirst());
        it.set$ui_release((ModifierLocal) entry.getFirst(), entry.getSecond());
        return it;
    }

    public static final ModifierLocalMap modifierLocalMapOf(ModifierLocal<?>... keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        ModifierLocal[] $this$mapTo$iv$iv = keys;
        Collection destination$iv$iv = new ArrayList($this$mapTo$iv$iv.length);
        for (ModifierLocal item$iv$iv : $this$mapTo$iv$iv) {
            destination$iv$iv.add(TuplesKt.to(item$iv$iv, null));
        }
        Collection thisCollection$iv = (List) destination$iv$iv;
        Collection collection = thisCollection$iv;
        Pair[] pairArr = (Pair[]) thisCollection$iv.toArray(new Pair[0]);
        return new MultiLocalMap((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    public static final ModifierLocalMap modifierLocalMapOf(Pair<? extends ModifierLocal<?>, ? extends Object>... entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new MultiLocalMap((Pair[]) Arrays.copyOf(entries, entries.length));
    }
}
