package androidx.compose.runtime;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composer.kt */
final class ComposerImpl$insertMovableContentGuarded$1$1$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> $offsetChanges;
    final /* synthetic */ SlotReader $reader;
    final /* synthetic */ MovableContentStateReference $to;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComposerImpl$insertMovableContentGuarded$1$1$2$1(ComposerImpl composerImpl, List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list, SlotReader slotReader, MovableContentStateReference movableContentStateReference) {
        super(0);
        this.this$0 = composerImpl;
        this.$offsetChanges = list;
        this.$reader = slotReader;
        this.$to = movableContentStateReference;
    }

    public final void invoke() {
        ComposerImpl this_$iv;
        SlotReader savedReader$iv;
        int[] savedCountOverrides$iv;
        ComposerImpl this_$iv2 = this.this$0;
        List newChanges$iv = this.$offsetChanges;
        ComposerImpl composerImpl = this.this$0;
        SlotReader slotReader = this.$reader;
        MovableContentStateReference movableContentStateReference = this.$to;
        List savedChanges$iv = this_$iv2.changes;
        try {
            this_$iv2.changes = newChanges$iv;
            this_$iv = composerImpl;
            savedReader$iv = this_$iv.reader;
            savedCountOverrides$iv = this_$iv.nodeCountOverrides;
            this_$iv.nodeCountOverrides = null;
            this_$iv.reader = slotReader;
            composerImpl.invokeMovableContentLambda(movableContentStateReference.getContent$runtime_release(), movableContentStateReference.getLocals$runtime_release(), movableContentStateReference.getParameter$runtime_release(), true);
            Unit unit = Unit.INSTANCE;
            this_$iv.reader = savedReader$iv;
            this_$iv.nodeCountOverrides = savedCountOverrides$iv;
            Unit unit2 = Unit.INSTANCE;
            this_$iv2.changes = savedChanges$iv;
        } catch (Throwable th) {
            this_$iv2.changes = savedChanges$iv;
            throw th;
        }
    }
}
