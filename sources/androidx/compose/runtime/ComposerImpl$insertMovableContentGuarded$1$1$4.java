package androidx.compose.runtime;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composer.kt */
final class ComposerImpl$insertMovableContentGuarded$1$1$4 extends Lambda implements Function3<Applier<?>, SlotWriter, RememberManager, Unit> {
    final /* synthetic */ MovableContentStateReference $from;
    final /* synthetic */ MovableContentState $resolvedState;
    final /* synthetic */ MovableContentStateReference $to;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComposerImpl$insertMovableContentGuarded$1$1$4(MovableContentState movableContentState, ComposerImpl composerImpl, MovableContentStateReference movableContentStateReference, MovableContentStateReference movableContentStateReference2) {
        super(3);
        this.$resolvedState = movableContentState;
        this.this$0 = composerImpl;
        this.$from = movableContentStateReference;
        this.$to = movableContentStateReference2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((Applier<?>) (Applier) p1, (SlotWriter) p2, (RememberManager) p3);
        return Unit.INSTANCE;
    }

    public final void invoke(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
        Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(slots, "slots");
        Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
        MovableContentState state = this.$resolvedState;
        if (state == null && (state = this.this$0.parentContext.movableContentStateResolve$runtime_release(this.$from)) == null) {
            ComposerKt.composeRuntimeError("Could not resolve state for movable content");
            throw new KotlinNothingValueException();
        }
        List moveIntoGroupFrom = slots.moveIntoGroupFrom(1, state.getSlotTable$runtime_release(), 2);
        if (!moveIntoGroupFrom.isEmpty()) {
            ControlledComposition composition$runtime_release = this.$to.getComposition$runtime_release();
            Intrinsics.checkNotNull(composition$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            CompositionImpl toComposition = (CompositionImpl) composition$runtime_release;
            List $this$fastForEach$iv = moveIntoGroupFrom;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object slot = slots.slot($this$fastForEach$iv.get(index$iv), 0);
                RecomposeScopeImpl recomposeScope = slot instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) slot : null;
                if (recomposeScope != null) {
                    recomposeScope.adoptedBy(toComposition);
                }
            }
        }
    }
}
