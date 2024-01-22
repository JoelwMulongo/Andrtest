package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u000fH$J\b\u0010\u0013\u001a\u00020\u000fH\u0016J*\u0010\u0014\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0004J\"\u0010\u0019\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0004R&\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000@TX\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/AbstractApplier;", "T", "Landroidx/compose/runtime/Applier;", "root", "(Ljava/lang/Object;)V", "<set-?>", "current", "getCurrent", "()Ljava/lang/Object;", "setCurrent", "Ljava/lang/Object;", "getRoot", "stack", "", "clear", "", "down", "node", "onClear", "up", "move", "from", "", "to", "count", "remove", "index", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Applier.kt */
public abstract class AbstractApplier<T> implements Applier<T> {
    public static final int $stable = 8;
    private T current;
    private final T root;
    private final List<T> stack = new ArrayList();

    /* access modifiers changed from: protected */
    public abstract void onClear();

    public AbstractApplier(T root2) {
        this.root = root2;
        this.current = root2;
    }

    public final T getRoot() {
        return this.root;
    }

    public T getCurrent() {
        return this.current;
    }

    /* access modifiers changed from: protected */
    public void setCurrent(T t) {
        this.current = t;
    }

    public void down(T node) {
        this.stack.add(getCurrent());
        setCurrent(node);
    }

    public void up() {
        if (!this.stack.isEmpty()) {
            List<T> list = this.stack;
            setCurrent(list.remove(list.size() - 1));
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void clear() {
        this.stack.clear();
        setCurrent(this.root);
        onClear();
    }

    /* access modifiers changed from: protected */
    public final void remove(List<T> $this$remove, int index, int count) {
        Intrinsics.checkNotNullParameter($this$remove, "<this>");
        if (count == 1) {
            $this$remove.remove(index);
        } else {
            $this$remove.subList(index, index + count).clear();
        }
    }

    /* access modifiers changed from: protected */
    public final void move(List<T> $this$move, int from, int to, int count) {
        Intrinsics.checkNotNullParameter($this$move, "<this>");
        int dest = from > to ? to : to - count;
        if (count != 1) {
            List<T> subList = $this$move.subList(from, from + count);
            List subCopy = CollectionsKt.toMutableList(subList);
            subList.clear();
            $this$move.addAll(dest, subCopy);
        } else if (from == to + 1 || from == to - 1) {
            $this$move.set(from, $this$move.set(to, $this$move.get(from)));
        } else {
            $this$move.add(dest, $this$move.remove(from));
        }
    }
}
