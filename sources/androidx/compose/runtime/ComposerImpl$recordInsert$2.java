package androidx.compose.runtime;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composer.kt */
final class ComposerImpl$recordInsert$2 extends Lambda implements Function3<Applier<?>, SlotWriter, RememberManager, Unit> {
    final /* synthetic */ Anchor $anchor;
    final /* synthetic */ List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> $fixups;
    final /* synthetic */ SlotTable $insertTable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComposerImpl$recordInsert$2(SlotTable slotTable, Anchor anchor, List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list) {
        super(3);
        this.$insertTable = slotTable;
        this.$anchor = anchor;
        this.$fixups = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((Applier<?>) (Applier) p1, (SlotWriter) p2, (RememberManager) p3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: finally extract failed */
    public final void invoke(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
        Applier<?> applier2 = applier;
        SlotWriter slotWriter = slots;
        RememberManager rememberManager2 = rememberManager;
        Intrinsics.checkNotNullParameter(applier2, "applier");
        Intrinsics.checkNotNullParameter(slotWriter, "slots");
        Intrinsics.checkNotNullParameter(rememberManager2, "rememberManager");
        SlotTable this_$iv = this.$insertTable;
        List $this$fastForEach$iv = this.$fixups;
        SlotWriter writer$iv = this_$iv.openWriter();
        SlotWriter writer = writer$iv;
        try {
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                $this$fastForEach$iv.get(index$iv).invoke(applier2, writer, rememberManager2);
            }
            Unit unit = Unit.INSTANCE;
            writer$iv.close();
            slots.beginInsert();
            SlotTable slotTable = this.$insertTable;
            slotWriter.moveFrom(slotTable, this.$anchor.toIndexFor(slotTable));
            slots.endInsert();
        } catch (Throwable th) {
            writer$iv.close();
            throw th;
        }
    }
}
