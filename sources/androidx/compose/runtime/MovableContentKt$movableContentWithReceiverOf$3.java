package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u0002H\u00022\u0006\u0010\u0005\u001a\u0002H\u00032\u0006\u0010\u0006\u001a\u0002H\u0004H\u000b¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "R", "P1", "P2", "p1", "p2", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: MovableContent.kt */
final class MovableContentKt$movableContentWithReceiverOf$3 extends Lambda implements Function5<R, P1, P2, Composer, Integer, Unit> {
    final /* synthetic */ MovableContent<Pair<Pair<R, P1>, P2>> $movableContent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MovableContentKt$movableContentWithReceiverOf$3(MovableContent<Pair<Pair<R, P1>, P2>> movableContent) {
        super(5);
        this.$movableContent = movableContent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5) {
        Object obj = p1;
        Object obj2 = p2;
        Object obj3 = p3;
        invoke(obj, obj2, obj3, (Composer) p4, ((Number) p5).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(R $this$null, P1 p1, P2 p2, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:MovableContent.kt#9igjgp");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer.changed((Object) $this$null) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer.changed((Object) p1) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer.changed((Object) p2) ? 256 : 128;
        }
        if (($dirty & 5851) != 1170 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(583402949, $changed, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:227)");
            }
            $composer.insertMovableContent(this.$movableContent, TuplesKt.to(TuplesKt.to($this$null, p1), p2));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}