package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u0002H\u00032\u0006\u0010\b\u001a\u0002H\u00042\u0006\u0010\t\u001a\u0002H\u0005H\u000b¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "", "P1", "P2", "P3", "P4", "p1", "p2", "p3", "p4", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: MovableContent.kt */
final class MovableContentKt$movableContentOf$5 extends Lambda implements Function6<P1, P2, P3, P4, Composer, Integer, Unit> {
    final /* synthetic */ MovableContent<Pair<Pair<P1, P2>, Pair<P3, P4>>> $movableContent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MovableContentKt$movableContentOf$5(MovableContent<Pair<Pair<P1, P2>, Pair<P3, P4>>> movableContent) {
        super(6);
        this.$movableContent = movableContent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        Object obj = p1;
        Object obj2 = p2;
        Object obj3 = p3;
        Object obj4 = p4;
        invoke(obj, obj2, obj3, obj4, (Composer) p5, ((Number) p6).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(P1 p1, P2 p2, P3 p3, P4 p4, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:MovableContent.kt#9igjgp");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer.changed((Object) p1) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer.changed((Object) p2) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer.changed((Object) p3) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer.changed((Object) p4) ? 2048 : 1024;
        }
        if ((46811 & $dirty) != 9362 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1741877681, $changed, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:146)");
            }
            $composer.insertMovableContent(this.$movableContent, TuplesKt.to(TuplesKt.to(p1, p2), TuplesKt.to(p3, p4)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
