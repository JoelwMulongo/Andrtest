package androidx.compose.ui.modifier;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.BackwardsCompatNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tJ\u0006\u0010\u0015\u001a\u00020\u0012J*\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00172\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tJ\u0006\u0010\u001b\u001a\u00020\u0012J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/modifier/ModifierLocalManager;", "", "owner", "Landroidx/compose/ui/node/Owner;", "(Landroidx/compose/ui/node/Owner;)V", "inserted", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/BackwardsCompatNode;", "insertedLocal", "Landroidx/compose/ui/modifier/ModifierLocal;", "invalidated", "", "getOwner", "()Landroidx/compose/ui/node/Owner;", "removed", "Landroidx/compose/ui/node/LayoutNode;", "removedLocal", "insertedProvider", "", "node", "key", "invalidate", "invalidateConsumersOfNodeForKey", "Landroidx/compose/ui/Modifier$Node;", "set", "", "removedProvider", "triggerUpdates", "updatedProvider", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModifierLocalManager.kt */
public final class ModifierLocalManager {
    private final MutableVector<BackwardsCompatNode> inserted = new MutableVector<>(new BackwardsCompatNode[16], 0);
    private final MutableVector<ModifierLocal<?>> insertedLocal = new MutableVector<>(new ModifierLocal[16], 0);
    private boolean invalidated;
    private final Owner owner;
    private final MutableVector<LayoutNode> removed = new MutableVector<>(new LayoutNode[16], 0);
    private final MutableVector<ModifierLocal<?>> removedLocal = new MutableVector<>(new ModifierLocal[16], 0);

    public ModifierLocalManager(Owner owner2) {
        Intrinsics.checkNotNullParameter(owner2, "owner");
        this.owner = owner2;
    }

    public final Owner getOwner() {
        return this.owner;
    }

    public final void invalidate() {
        if (!this.invalidated) {
            this.invalidated = true;
            this.owner.registerOnEndApplyChangesListener(new ModifierLocalManager$invalidate$1(this));
        }
    }

    public final void triggerUpdates() {
        this.invalidated = false;
        HashSet<BackwardsCompatNode> toUpdate = new HashSet<>();
        MutableVector this_$iv = this.removed;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                LayoutNode layout = (LayoutNode) content$iv[i$iv];
                ModifierLocal key = (ModifierLocal) this.removedLocal.getContent()[i$iv];
                if (layout.getNodes$ui_release().getHead$ui_release().isAttached()) {
                    invalidateConsumersOfNodeForKey(layout.getNodes$ui_release().getHead$ui_release(), key, toUpdate);
                }
                i$iv++;
            } while (i$iv < size$iv);
        }
        this.removed.clear();
        this.removedLocal.clear();
        MutableVector this_$iv2 = this.inserted;
        int size$iv2 = this_$iv2.getSize();
        if (size$iv2 > 0) {
            int i$iv2 = 0;
            Object[] content$iv2 = this_$iv2.getContent();
            do {
                BackwardsCompatNode node = (BackwardsCompatNode) content$iv2[i$iv2];
                ModifierLocal key2 = (ModifierLocal) this.insertedLocal.getContent()[i$iv2];
                if (node.isAttached()) {
                    invalidateConsumersOfNodeForKey(node, key2, toUpdate);
                }
                i$iv2++;
            } while (i$iv2 < size$iv2);
        }
        this.inserted.clear();
        this.insertedLocal.clear();
        for (BackwardsCompatNode it : toUpdate) {
            it.updateModifierLocalConsumer();
        }
    }

    private final void invalidateConsumersOfNodeForKey(Modifier.Node node, ModifierLocal<?> key, Set<BackwardsCompatNode> set) {
        DelegatableNode $this$visitSubtreeIf_u2d6rFNWt0$iv;
        boolean z;
        boolean diveDeeper$iv$iv;
        ModifierLocal<?> modifierLocal = key;
        DelegatableNode $this$visitSubtreeIf_u2d6rFNWt0$iv2 = node;
        int mask$iv$iv = NodeKind.m5123constructorimpl(32);
        DelegatableNode $this$visitSubtreeIf$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
        if ($this$visitSubtreeIf$iv$iv.getNode().isAttached()) {
            MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$iv$iv = $this$visitSubtreeIf$iv$iv.getNode().getChild$ui_release();
            if (child$iv$iv == null) {
                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitSubtreeIf$iv$iv.getNode());
            } else {
                branches$iv$iv.add(child$iv$iv);
            }
            while (branches$iv$iv.isNotEmpty()) {
                boolean z2 = true;
                Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
                if ((branch$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                    Modifier.Node node$iv$iv = branch$iv$iv;
                    while (true) {
                        if (node$iv$iv == null) {
                            break;
                        }
                        if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                            Modifier.Node it$iv = node$iv$iv;
                            if (it$iv instanceof ModifierLocalNode) {
                                ModifierLocalNode it = (ModifierLocalNode) it$iv;
                                if (!(it instanceof BackwardsCompatNode) || !(((BackwardsCompatNode) it).getElement() instanceof ModifierLocalConsumer)) {
                                    Set<BackwardsCompatNode> set2 = set;
                                } else if (((BackwardsCompatNode) it).getReadValues().contains(modifierLocal)) {
                                    set.add(it);
                                } else {
                                    Set<BackwardsCompatNode> set3 = set;
                                }
                                $this$visitSubtreeIf_u2d6rFNWt0$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                                z = true;
                                diveDeeper$iv$iv = !it.getProvidedValues().contains$ui_release(modifierLocal);
                            } else {
                                $this$visitSubtreeIf_u2d6rFNWt0$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                                z = z2;
                                Set<BackwardsCompatNode> set4 = set;
                                diveDeeper$iv$iv = z;
                            }
                            if (!diveDeeper$iv$iv) {
                                $this$visitSubtreeIf_u2d6rFNWt0$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                                break;
                            }
                        } else {
                            $this$visitSubtreeIf_u2d6rFNWt0$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                            z = z2;
                            Set<BackwardsCompatNode> set5 = set;
                        }
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        z2 = z;
                        $this$visitSubtreeIf_u2d6rFNWt0$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                    }
                }
                Set<BackwardsCompatNode> set6 = set;
                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                $this$visitSubtreeIf_u2d6rFNWt0$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
            }
            return;
        }
        DelegatableNode delegatableNode = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void updatedProvider(BackwardsCompatNode node, ModifierLocal<?> key) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(key, "key");
        this.inserted.add(node);
        this.insertedLocal.add(key);
        invalidate();
    }

    public final void insertedProvider(BackwardsCompatNode node, ModifierLocal<?> key) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(key, "key");
        this.inserted.add(node);
        this.insertedLocal.add(key);
        invalidate();
    }

    public final void removedProvider(BackwardsCompatNode node, ModifierLocal<?> key) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(key, "key");
        this.removed.add(DelegatableNodeKt.requireLayoutNode(node));
        this.removedLocal.add(key);
        invalidate();
    }
}
