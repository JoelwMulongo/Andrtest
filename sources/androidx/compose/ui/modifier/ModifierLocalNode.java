package androidx.compose.ui.modifier;

import androidx.compose.ui.node.DelegatableNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u00012\u00020\u0002J)\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\b0\t2\u0006\u0010\u000f\u001a\u0002H\bH\u0016¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/modifier/ModifierLocalNode;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/ui/node/DelegatableNode;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "current", "T", "Landroidx/compose/ui/modifier/ModifierLocal;", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "provide", "", "key", "value", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModifierLocalNode.kt */
public interface ModifierLocalNode extends ModifierLocalReadScope, DelegatableNode {
    ModifierLocalMap getProvidedValues() {
        return EmptyMap.INSTANCE;
    }

    <T> void provide(ModifierLocal<T> key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!(getProvidedValues() != EmptyMap.INSTANCE)) {
            throw new IllegalArgumentException("In order to provide locals you must override providedValues: ModifierLocalMap".toString());
        } else if (getProvidedValues().contains$ui_release(key)) {
            getProvidedValues().set$ui_release(key, value);
        } else {
            throw new IllegalArgumentException(("Any provided key must be initially provided in the overridden providedValues: ModifierLocalMap property. Key " + key + " was not found.").toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007e, code lost:
        r11 = r9.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    <T> T getCurrent(androidx.compose.ui.modifier.ModifierLocal<T> r17) {
        /*
            r16 = this;
            java.lang.String r0 = "<this>"
            r1 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            androidx.compose.ui.Modifier$Node r0 = r16.getNode()
            boolean r0 = r0.isAttached()
            if (r0 == 0) goto L_0x00a3
            r0 = r17
            r2 = r16
            androidx.compose.ui.node.DelegatableNode r2 = (androidx.compose.ui.node.DelegatableNode) r2
            r3 = 0
            r4 = 32
            int r3 = androidx.compose.ui.node.NodeKind.m5123constructorimpl(r4)
            r4 = 0
            r5 = r3
            r6 = r2
            r7 = 0
            androidx.compose.ui.Modifier$Node r8 = r6.getNode()
            boolean r8 = r8.isAttached()
            if (r8 == 0) goto L_0x0097
            androidx.compose.ui.Modifier$Node r8 = r6.getNode()
            androidx.compose.ui.Modifier$Node r8 = r8.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r9 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r6)
        L_0x0039:
            if (r9 == 0) goto L_0x008c
            androidx.compose.ui.node.NodeChain r10 = r9.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r10 = r10.getHead$ui_release()
            int r11 = r10.getAggregateChildKindSet$ui_release()
            r11 = r11 & r5
            if (r11 == 0) goto L_0x0078
        L_0x004a:
            if (r8 == 0) goto L_0x0078
            int r11 = r8.getKindSet$ui_release()
            r11 = r11 & r5
            if (r11 == 0) goto L_0x0073
            r11 = r8
            r12 = 0
            boolean r13 = r11 instanceof androidx.compose.ui.modifier.ModifierLocalNode
            if (r13 == 0) goto L_0x0072
            r13 = r11
            androidx.compose.ui.modifier.ModifierLocalNode r13 = (androidx.compose.ui.modifier.ModifierLocalNode) r13
            r14 = 0
            androidx.compose.ui.modifier.ModifierLocalMap r15 = r13.getProvidedValues()
            boolean r15 = r15.contains$ui_release(r0)
            if (r15 == 0) goto L_0x0070
            androidx.compose.ui.modifier.ModifierLocalMap r15 = r13.getProvidedValues()
            java.lang.Object r15 = r15.get$ui_release(r0)
            return r15
        L_0x0070:
        L_0x0072:
        L_0x0073:
            androidx.compose.ui.Modifier$Node r8 = r8.getParent$ui_release()
            goto L_0x004a
        L_0x0078:
            androidx.compose.ui.node.LayoutNode r9 = r9.getParent$ui_release()
            if (r9 == 0) goto L_0x0089
            androidx.compose.ui.node.NodeChain r11 = r9.getNodes$ui_release()
            if (r11 == 0) goto L_0x0089
            androidx.compose.ui.Modifier$Node r11 = r11.getTail$ui_release()
            goto L_0x008a
        L_0x0089:
            r11 = 0
        L_0x008a:
            r8 = r11
            goto L_0x0039
        L_0x008c:
            kotlin.jvm.functions.Function0 r2 = r0.getDefaultFactory$ui_release()
            java.lang.Object r2 = r2.invoke()
            return r2
        L_0x0097:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Check failed."
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x00a3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Failed requirement."
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.modifier.ModifierLocalNode.getCurrent(androidx.compose.ui.modifier.ModifierLocal):java.lang.Object");
    }
}
