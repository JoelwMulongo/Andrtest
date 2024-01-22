package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ActualKt;
import androidx.compose.ui.CombinedModifier;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u001a\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000\u001a \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f*\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0002\u001a$\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\u0011*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u00110\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0014"}, d2 = {"ActionReplace", "", "ActionReuse", "ActionUpdate", "SentinelHead", "androidx/compose/ui/node/NodeChainKt$SentinelHead$1", "Landroidx/compose/ui/node/NodeChainKt$SentinelHead$1;", "actionForModifiers", "prev", "Landroidx/compose/ui/Modifier$Element;", "next", "fillVector", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier;", "result", "updateUnsafe", "Landroidx/compose/ui/Modifier$Node;", "T", "Landroidx/compose/ui/node/ModifierNodeElement;", "node", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeChain.kt */
public final class NodeChainKt {
    private static final int ActionReplace = 0;
    private static final int ActionReuse = 2;
    private static final int ActionUpdate = 1;
    /* access modifiers changed from: private */
    public static final NodeChainKt$SentinelHead$1 SentinelHead;

    static {
        NodeChainKt$SentinelHead$1 $this$SentinelHead_u24lambda_u240 = new NodeChainKt$SentinelHead$1();
        $this$SentinelHead_u24lambda_u240.setAggregateChildKindSet$ui_release(-1);
        SentinelHead = $this$SentinelHead_u24lambda_u240;
    }

    public static final int actionForModifiers(Modifier.Element prev, Modifier.Element next) {
        Intrinsics.checkNotNullParameter(prev, "prev");
        Intrinsics.checkNotNullParameter(next, "next");
        if (Intrinsics.areEqual((Object) prev, (Object) next)) {
            return 2;
        }
        if (ActualKt.areObjectsOfSameType(prev, next)) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public static final <T extends Modifier.Node> Modifier.Node updateUnsafe(ModifierNodeElement<T> $this$updateUnsafe, Modifier.Node node) {
        Intrinsics.checkNotNull(node, "null cannot be cast to non-null type T of androidx.compose.ui.node.NodeChainKt.updateUnsafe");
        return $this$updateUnsafe.update(node);
    }

    /* access modifiers changed from: private */
    public static final MutableVector<Modifier.Element> fillVector(Modifier $this$fillVector, MutableVector<Modifier.Element> result) {
        MutableVector stack = new MutableVector(new Modifier[result.getSize()], 0);
        stack.add($this$fillVector);
        while (stack.isNotEmpty() != 0) {
            Modifier next = (Modifier) stack.removeAt(stack.getSize() - 1);
            if (next instanceof CombinedModifier) {
                stack.add(((CombinedModifier) next).getInner$ui_release());
                stack.add(((CombinedModifier) next).getOuter$ui_release());
            } else if (next instanceof Modifier.Element) {
                result.add(next);
            } else {
                next.all(new NodeChainKt$fillVector$1(result));
            }
        }
        return result;
    }
}
