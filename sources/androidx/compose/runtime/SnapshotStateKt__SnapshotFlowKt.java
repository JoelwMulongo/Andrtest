package androidx.compose.runtime;

import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\"\n\u0002\b\u0003\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0000\u0010\u0002*\u0002H\u0007\"\u0004\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\b\u001a\u0002H\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001a-\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010H\u0002¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2 = {"snapshotFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "block", "Lkotlin/Function0;", "collectAsState", "Landroidx/compose/runtime/State;", "R", "initial", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Lkotlinx/coroutines/flow/StateFlow;", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "intersects", "", "", "other", "intersects$SnapshotStateKt__SnapshotFlowKt", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
/* compiled from: SnapshotFlow.kt */
final /* synthetic */ class SnapshotStateKt__SnapshotFlowKt {
    public static final <T> State<T> collectAsState(StateFlow<? extends T> $this$collectAsState, CoroutineContext context, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter($this$collectAsState, "<this>");
        $composer.startReplaceableGroup(-1439883919);
        ComposerKt.sourceInformation($composer, "C(collectAsState)47@1801L30:SnapshotFlow.kt#9igjgp");
        if ((i & 1) != 0) {
            context = EmptyCoroutineContext.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1439883919, $changed, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:45)");
        }
        State<T> collectAsState = SnapshotStateKt.collectAsState($this$collectAsState, $this$collectAsState.getValue(), context, $composer, 520, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return collectAsState;
    }

    public static final <T extends R, R> State<R> collectAsState(Flow<? extends T> $this$collectAsState, R initial, CoroutineContext context, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter($this$collectAsState, "<this>");
        $composer.startReplaceableGroup(-606625098);
        ComposerKt.sourceInformation($composer, "C(collectAsState)P(1)62@2343L186:SnapshotFlow.kt#9igjgp");
        if ((i & 2) != 0) {
            context = EmptyCoroutineContext.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-606625098, $changed, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:59)");
        }
        State<R> produceState = SnapshotStateKt.produceState(initial, $this$collectAsState, context, new SnapshotStateKt__SnapshotFlowKt$collectAsState$1(context, $this$collectAsState, (Continuation<? super SnapshotStateKt__SnapshotFlowKt$collectAsState$1>) null), $composer, (($changed >> 3) & 8) | 4672 | (($changed >> 3) & 14));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return produceState;
    }

    public static final <T> Flow<T> snapshotFlow(Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return FlowKt.flow(new SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(block, (Continuation<? super SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1>) null));
    }

    /* access modifiers changed from: private */
    public static final <T> boolean intersects$SnapshotStateKt__SnapshotFlowKt(Set<? extends T> $this$intersects, Set<? extends T> other) {
        if ($this$intersects.size() < other.size()) {
            Iterable<Object> $this$any$iv = $this$intersects;
            if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                for (Object element$iv : $this$any$iv) {
                    if (other.contains(element$iv)) {
                        return true;
                    }
                }
                return false;
            }
        } else {
            Iterable<Object> $this$any$iv2 = other;
            if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                for (Object element$iv2 : $this$any$iv2) {
                    if ($this$intersects.contains(element$iv2)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
