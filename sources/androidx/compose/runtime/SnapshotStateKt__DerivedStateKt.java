package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000e\u001a.\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000e\u001a0\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u000eH\b¢\u0006\u0004\b\u0015\u0010\u0016\u001aj\u0010\u0017\u001a\u00020\b\"\u0004\b\u0000\u0010\u00122%\u0010\u0018\u001a!\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000b¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b0\u00062%\u0010\u001b\u001a!\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000b¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u000eH\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"J\u0010\u0003\u001a>\u0012:\u00128\u00124\u00122\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005j\u0002`\t0\u00040\u0001X\u0004¢\u0006\u0002\n\u0000*d\b\u0002\u0010\u001c\".\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\b0\u00060\u00052.\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005¨\u0006\u001d"}, d2 = {"calculationBlockNestedLevel", "Landroidx/compose/runtime/SnapshotThreadLocal;", "", "derivedStateObservers", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Pair;", "Lkotlin/Function1;", "Landroidx/compose/runtime/DerivedState;", "", "Landroidx/compose/runtime/DerivedStateObservers;", "derivedStateOf", "Landroidx/compose/runtime/State;", "T", "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "notifyObservers", "R", "derivedState", "block", "notifyObservers$SnapshotStateKt__DerivedStateKt", "(Landroidx/compose/runtime/DerivedState;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "observeDerivedStateRecalculations", "start", "Lkotlin/ParameterName;", "name", "done", "DerivedStateObservers", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
/* compiled from: DerivedState.kt */
final /* synthetic */ class SnapshotStateKt__DerivedStateKt {
    /* access modifiers changed from: private */
    public static final SnapshotThreadLocal<Integer> calculationBlockNestedLevel = new SnapshotThreadLocal<>();
    /* access modifiers changed from: private */
    public static final SnapshotThreadLocal<MutableVector<Pair<Function1<DerivedState<?>, Unit>, Function1<DerivedState<?>, Unit>>>> derivedStateObservers = new SnapshotThreadLocal<>();

    public static final <T> State<T> derivedStateOf(Function0<? extends T> calculation) {
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        return new DerivedSnapshotState<>(calculation, (SnapshotMutationPolicy) null);
    }

    public static final <T> State<T> derivedStateOf(SnapshotMutationPolicy<T> policy, Function0<? extends T> calculation) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        return new DerivedSnapshotState<>(calculation, policy);
    }

    private static final <R> R notifyObservers$SnapshotStateKt__DerivedStateKt(DerivedState<?> derivedState, Function0<? extends R> block) {
        MutableVector observers = (MutableVector) derivedStateObservers.get();
        if (observers == null) {
            observers = new MutableVector(new Pair[0], 0);
        }
        MutableVector this_$iv = observers;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                ((Function1) ((Pair) content$iv[i$iv]).component1()).invoke(derivedState);
                i$iv++;
            } while (i$iv < size$iv);
        }
        try {
            R invoke = block.invoke();
            InlineMarker.finallyStart(1);
            MutableVector this_$iv2 = observers;
            int size$iv2 = this_$iv2.getSize();
            if (size$iv2 > 0) {
                int i$iv2 = 0;
                Object[] content$iv2 = this_$iv2.getContent();
                do {
                    ((Function1) ((Pair) content$iv2[i$iv2]).component2()).invoke(derivedState);
                    i$iv2++;
                } while (i$iv2 < size$iv2);
            }
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            MutableVector this_$iv3 = observers;
            int size$iv3 = this_$iv3.getSize();
            if (size$iv3 > 0) {
                int i$iv3 = 0;
                Object[] content$iv3 = this_$iv3.getContent();
                do {
                    ((Function1) ((Pair) content$iv3[i$iv3]).component2()).invoke(derivedState);
                    i$iv3++;
                } while (i$iv3 < size$iv3);
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    public static final <R> void observeDerivedStateRecalculations(Function1<? super State<?>, Unit> start, Function1<? super State<?>, Unit> done, Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(done, "done");
        Intrinsics.checkNotNullParameter(block, "block");
        SnapshotThreadLocal<MutableVector<Pair<Function1<DerivedState<?>, Unit>, Function1<DerivedState<?>, Unit>>>> snapshotThreadLocal = derivedStateObservers;
        MutableVector it = snapshotThreadLocal.get();
        if (it == null) {
            it = new MutableVector(new Pair[16], 0);
            snapshotThreadLocal.set(it);
        }
        MutableVector observers = it;
        try {
            observers.add(TuplesKt.to(start, done));
            block.invoke();
        } finally {
            observers.removeAt(observers.getSize() - 1);
        }
    }
}
