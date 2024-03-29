package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.SemanticsModifierNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"androidx/compose/ui/semantics/SemanticsNode$fakeSemanticsNode$fakeNode$1", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getSemanticsConfiguration", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SemanticsNode.kt */
public final class SemanticsNode$fakeSemanticsNode$fakeNode$1 extends Modifier.Node implements SemanticsModifierNode {
    private final SemanticsConfiguration semanticsConfiguration;

    SemanticsNode$fakeSemanticsNode$fakeNode$1(Function1<? super SemanticsPropertyReceiver, Unit> $properties) {
        SemanticsConfiguration semanticsConfiguration2 = new SemanticsConfiguration();
        SemanticsConfiguration it = semanticsConfiguration2;
        it.setMergingSemanticsOfDescendants(false);
        it.setClearingSemantics(false);
        $properties.invoke(it);
        this.semanticsConfiguration = semanticsConfiguration2;
    }

    public SemanticsConfiguration getSemanticsConfiguration() {
        return this.semanticsConfiguration;
    }
}
