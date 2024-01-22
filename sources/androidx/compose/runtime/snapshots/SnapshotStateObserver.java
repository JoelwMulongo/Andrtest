package androidx.compose.runtime.snapshots;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.compose.runtime.collection.MutableVector;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0001\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u00014B.\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\tJ\u0016\u0010\u001b\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0002J\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0001J)\u0010\u001f\u001a\u00020\u00052!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00130\u0003J\b\u0010!\u001a\u00020\u0013H\u0002J&\u0010\"\u001a\u00020\u0011\"\b\b\u0000\u0010#*\u00020\u00012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u001d\u0010%\u001a\u00020\u00052\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0003H\bJ\u001c\u0010'\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010)\u001a\u00020\rJ?\u0010*\u001a\u00020\u0005\"\b\b\u0000\u0010#*\u00020\u00012\u0006\u0010\u001e\u001a\u0002H#2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0002J\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\u0005H\u0002J\u0006\u00101\u001a\u00020\u0005J\u0006\u00102\u001a\u00020\u0005J\u0016\u00103\u001a\u00020\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007R&\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015X\u0004¢\u0006\u0002\n\u0000R/\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0018X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "(Lkotlin/jvm/functions/Function1;)V", "applyObserver", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "currentMap", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "isPaused", "", "observedScopeMaps", "Landroidx/compose/runtime/collection/MutableVector;", "pendingChanges", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "readObserver", "sendingNotifications", "addChanges", "set", "clear", "scope", "clearIf", "predicate", "drainChanges", "ensureMap", "T", "onChanged", "forEachScopeMap", "block", "notifyChanges", "changes", "snapshot", "observeReads", "onValueChangedForScope", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "removeChanges", "report", "", "sendNotifications", "start", "stop", "withNoObservations", "ObservedScopeMap", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotStateObserver.kt */
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver = new SnapshotStateObserver$applyObserver$1(this);
    private ObserverHandle applyUnsubscribe;
    /* access modifiers changed from: private */
    public ObservedScopeMap currentMap;
    /* access modifiers changed from: private */
    public boolean isPaused;
    /* access modifiers changed from: private */
    public final MutableVector<ObservedScopeMap> observedScopeMaps = new MutableVector<>(new ObservedScopeMap[16], 0);
    private final Function1<Function0<Unit>, Unit> onChangedExecutor;
    private final AtomicReference<Object> pendingChanges = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */
    public final Function1<Object, Unit> readObserver = new SnapshotStateObserver$readObserver$1(this);
    /* access modifiers changed from: private */
    public boolean sendingNotifications;

    public SnapshotStateObserver(Function1<? super Function0<Unit>, Unit> onChangedExecutor2) {
        Intrinsics.checkNotNullParameter(onChangedExecutor2, "onChangedExecutor");
        this.onChangedExecutor = onChangedExecutor2;
    }

    /* access modifiers changed from: private */
    public final boolean drainChanges() {
        boolean z;
        boolean z2;
        synchronized (this.observedScopeMaps) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean hasValues = false;
        while (true) {
            Set notifications = removeChanges();
            if (notifications == null) {
                return hasValues;
            }
            synchronized (this.observedScopeMaps) {
                MutableVector this_$iv$iv = this.observedScopeMaps;
                int size$iv$iv = this_$iv$iv.getSize();
                if (size$iv$iv > 0) {
                    int i$iv$iv = 0;
                    Object[] content$iv$iv = this_$iv$iv.getContent();
                    do {
                        if (!((ObservedScopeMap) content$iv$iv[i$iv$iv]).recordInvalidation(notifications)) {
                            if (!hasValues) {
                                z2 = false;
                                hasValues = z2;
                                i$iv$iv++;
                            }
                        }
                        z2 = true;
                        hasValues = z2;
                        i$iv$iv++;
                    } while (i$iv$iv < size$iv$iv);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void sendNotifications() {
        this.onChangedExecutor.invoke(new SnapshotStateObserver$sendNotifications$1(this));
    }

    /* access modifiers changed from: private */
    public final void addChanges(Set<? extends Object> set) {
        Object old;
        Collection collection;
        do {
            old = this.pendingChanges.get();
            if (old == null) {
                collection = set;
            } else if (old instanceof Set) {
                collection = CollectionsKt.listOf((Set) old, set);
            } else if (old instanceof List) {
                collection = CollectionsKt.plus((Collection) old, CollectionsKt.listOf(set));
            } else {
                report();
                throw new KotlinNothingValueException();
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, old, collection));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.util.Set<java.lang.Object>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.Set<java.lang.Object> removeChanges() {
        /*
            r7 = this;
        L_0x0001:
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r7.pendingChanges
            java.lang.Object r0 = r0.get()
            r1 = 0
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L_0x000f
            return r3
        L_0x000f:
            boolean r4 = r0 instanceof java.util.Set
            if (r4 == 0) goto L_0x0018
            r1 = r0
            java.util.Set r1 = (java.util.Set) r1
            r2 = 0
            goto L_0x0055
        L_0x0018:
            boolean r4 = r0 instanceof java.util.List
            if (r4 == 0) goto L_0x005e
            r4 = r0
            java.util.List r4 = (java.util.List) r4
            r5 = 0
            java.lang.Object r4 = r4.get(r5)
            r1 = r4
            java.util.Set r1 = (java.util.Set) r1
            r4 = r0
            java.util.List r4 = (java.util.List) r4
            int r4 = r4.size()
            r5 = 1
            r6 = 2
            if (r4 != r6) goto L_0x003b
            r3 = r0
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r3 = r3.get(r5)
            goto L_0x0054
        L_0x003b:
            r4 = r0
            java.util.List r4 = (java.util.List) r4
            int r4 = r4.size()
            if (r4 <= r6) goto L_0x0053
            r3 = r0
            java.util.List r3 = (java.util.List) r3
            r4 = r0
            java.util.List r4 = (java.util.List) r4
            int r4 = r4.size()
            java.util.List r3 = r3.subList(r5, r4)
            goto L_0x0054
        L_0x0053:
        L_0x0054:
            r2 = r3
        L_0x0055:
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r3 = r7.pendingChanges
            boolean r3 = androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(r3, r0, r2)
            if (r3 == 0) goto L_0x0001
            return r1
        L_0x005e:
            r7.report()
            kotlin.KotlinNothingValueException r3 = new kotlin.KotlinNothingValueException
            r3.<init>()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.removeChanges():java.util.Set");
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    private final void forEachScopeMap(Function1<? super ObservedScopeMap, Unit> block) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector this_$iv = this.observedScopeMaps;
                int size$iv = this_$iv.getSize();
                if (size$iv > 0) {
                    int i$iv = 0;
                    Object[] content$iv = this_$iv.getContent();
                    do {
                        block.invoke(content$iv[i$iv]);
                        i$iv++;
                    } while (i$iv < size$iv);
                }
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
    }

    public final <T> void observeReads(T scope, Function1<? super T, Unit> onValueChangedForScope, Function0<Unit> block) {
        ObservedScopeMap ensureMap;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onValueChangedForScope, "onValueChangedForScope");
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (this.observedScopeMaps) {
            ensureMap = ensureMap(onValueChangedForScope);
        }
        ObservedScopeMap scopeMap = ensureMap;
        boolean oldPaused = this.isPaused;
        ObservedScopeMap oldMap = this.currentMap;
        try {
            this.isPaused = false;
            this.currentMap = scopeMap;
            ObservedScopeMap this_$iv = scopeMap;
            Object previousScope$iv = this_$iv.currentScope;
            IdentityArrayIntMap previousReads$iv = this_$iv.currentScopeReads;
            int previousToken$iv = this_$iv.currentToken;
            this_$iv.currentScope = scope;
            this_$iv.currentScopeReads = (IdentityArrayIntMap) this_$iv.scopeToValues.get(scope);
            if (this_$iv.currentToken == -1) {
                this_$iv.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            SnapshotStateKt.observeDerivedStateRecalculations(scopeMap.getDerivedStateEnterObserver(), scopeMap.getDerivedStateExitObserver(), new SnapshotStateObserver$observeReads$1$1(this, block));
            Object access$getCurrentScope$p = this_$iv.currentScope;
            Intrinsics.checkNotNull(access$getCurrentScope$p);
            this_$iv.clearObsoleteStateReads(access$getCurrentScope$p);
            this_$iv.currentScope = previousScope$iv;
            this_$iv.currentScopeReads = previousReads$iv;
            this_$iv.currentToken = previousToken$iv;
        } finally {
            this.currentMap = oldMap;
            this.isPaused = oldPaused;
        }
    }

    @Deprecated(message = "Replace with Snapshot.withoutReadObservation()", replaceWith = @ReplaceWith(expression = "Snapshot.withoutReadObservation(block)", imports = {"androidx.compose.runtime.snapshots.Snapshot"}))
    public final void withNoObservations(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        boolean oldPaused = this.isPaused;
        this.isPaused = true;
        try {
            block.invoke();
        } finally {
            this.isPaused = oldPaused;
        }
    }

    public final void clear(Object scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        synchronized (this.observedScopeMaps) {
            MutableVector this_$iv$iv = this.observedScopeMaps;
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    ((ObservedScopeMap) content$iv$iv[i$iv$iv]).clearScopeObservations(scope);
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearIf(Function1<Object, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        synchronized (this.observedScopeMaps) {
            MutableVector this_$iv$iv = this.observedScopeMaps;
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    ((ObservedScopeMap) content$iv$iv[i$iv$iv]).removeScopeIf(predicate);
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.Companion.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    public final void notifyChanges(Set<? extends Object> changes, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.applyObserver.invoke(changes, snapshot);
    }

    public final void clear() {
        synchronized (this.observedScopeMaps) {
            MutableVector this_$iv$iv = this.observedScopeMaps;
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    ((ObservedScopeMap) content$iv$iv[i$iv$iv]).clear();
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap ensureMap(kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r11) {
        /*
            r10 = this;
            androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap> r0 = r10.observedScopeMaps
            r1 = 0
            int r2 = r0.getSize()
            r3 = 1
            if (r2 <= 0) goto L_0x0027
            r4 = 0
            java.lang.Object[] r5 = r0.getContent()
        L_0x0010:
            r6 = r5[r4]
            r7 = r6
            androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap r7 = (androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap) r7
            r8 = 0
            kotlin.jvm.functions.Function1 r9 = r7.getOnChanged()
            if (r9 != r11) goto L_0x001e
            r9 = r3
            goto L_0x001f
        L_0x001e:
            r9 = 0
        L_0x001f:
            if (r9 == 0) goto L_0x0022
            goto L_0x0028
        L_0x0022:
            int r4 = r4 + 1
            if (r4 < r2) goto L_0x0010
        L_0x0027:
            r6 = 0
        L_0x0028:
            r0 = r6
            androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap r0 = (androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap) r0
            if (r0 != 0) goto L_0x0046
            androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap r1 = new androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11, r2)
            java.lang.Object r2 = kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(r11, r3)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r1.<init>(r2)
            androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap> r2 = r10.observedScopeMaps
            r3 = 0
            r2.add(r1)
            return r1
        L_0x0046:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.ensureMap(kotlin.jvm.functions.Function1):androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap");
    }

    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001e\u001a\u00020\u0004J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0001H\u0002J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0001J\u0006\u0010\"\u001a\u00020\u0004J\"\u0010#\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040%H\bø\u0001\u0000J\u0014\u0010&\u001a\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010)J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0001J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u0001H\u0002J)\u0010-\u001a\u00020\u00042!\u0010.\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b( \u0012\u0004\u0012\u00020'0\u0003R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R!\u0010\u000f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0013\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R6\u0010\u0018\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u001aX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u001cX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\fX\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u00061"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "", "onChanged", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "currentScope", "currentScopeReads", "Landroidx/compose/runtime/collection/IdentityArrayIntMap;", "currentToken", "", "dependencyToDerivedStates", "Landroidx/compose/runtime/collection/IdentityScopeMap;", "Landroidx/compose/runtime/DerivedState;", "deriveStateScopeCount", "derivedStateEnterObserver", "Landroidx/compose/runtime/State;", "getDerivedStateEnterObserver", "()Lkotlin/jvm/functions/Function1;", "derivedStateExitObserver", "getDerivedStateExitObserver", "invalidated", "Landroidx/compose/runtime/collection/IdentityArraySet;", "getOnChanged", "recordedDerivedStateValues", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "scopeToValues", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "valueToScopes", "clear", "clearObsoleteStateReads", "scope", "clearScopeObservations", "notifyInvalidatedScopes", "observe", "block", "Lkotlin/Function0;", "recordInvalidation", "", "changes", "", "recordRead", "value", "removeObservation", "removeScopeIf", "predicate", "Lkotlin/ParameterName;", "name", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnapshotStateObserver.kt */
    private static final class ObservedScopeMap {
        /* access modifiers changed from: private */
        public Object currentScope;
        /* access modifiers changed from: private */
        public IdentityArrayIntMap currentScopeReads;
        /* access modifiers changed from: private */
        public int currentToken = -1;
        private final IdentityScopeMap<DerivedState<?>> dependencyToDerivedStates = new IdentityScopeMap<>();
        /* access modifiers changed from: private */
        public int deriveStateScopeCount;
        private final Function1<State<?>, Unit> derivedStateEnterObserver = new SnapshotStateObserver$ObservedScopeMap$derivedStateEnterObserver$1(this);
        private final Function1<State<?>, Unit> derivedStateExitObserver = new SnapshotStateObserver$ObservedScopeMap$derivedStateExitObserver$1(this);
        private final IdentityArraySet<Object> invalidated = new IdentityArraySet<>();
        private final Function1<Object, Unit> onChanged;
        private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues = new HashMap<>();
        /* access modifiers changed from: private */
        public final IdentityArrayMap<Object, IdentityArrayIntMap> scopeToValues = new IdentityArrayMap<>(0, 1, (DefaultConstructorMarker) null);
        private final IdentityScopeMap<Object> valueToScopes = new IdentityScopeMap<>();

        public ObservedScopeMap(Function1<Object, Unit> onChanged2) {
            Intrinsics.checkNotNullParameter(onChanged2, "onChanged");
            this.onChanged = onChanged2;
        }

        public final Function1<Object, Unit> getOnChanged() {
            return this.onChanged;
        }

        public final Function1<State<?>, Unit> getDerivedStateEnterObserver() {
            return this.derivedStateEnterObserver;
        }

        public final Function1<State<?>, Unit> getDerivedStateExitObserver() {
            return this.derivedStateExitObserver;
        }

        public final void recordRead(Object value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (this.deriveStateScopeCount <= 0) {
                Object scope = this.currentScope;
                Intrinsics.checkNotNull(scope);
                IdentityArrayIntMap recordedValues = this.currentScopeReads;
                if (recordedValues == null) {
                    recordedValues = new IdentityArrayIntMap();
                    IdentityArrayIntMap it = recordedValues;
                    this.currentScopeReads = it;
                    this.scopeToValues.set(scope, it);
                }
                int previousValue = recordedValues.add(value, this.currentToken);
                if ((value instanceof DerivedState) && previousValue != this.currentToken) {
                    for (Object dependency : ((DerivedState) value).getDependencies()) {
                        if (dependency == null) {
                            break;
                        }
                        this.dependencyToDerivedStates.add(dependency, value);
                    }
                    this.recordedDerivedStateValues.put(value, ((DerivedState) value).getCurrentValue());
                }
                if (previousValue == -1) {
                    this.valueToScopes.add(value, scope);
                }
            }
        }

        public final void observe(Object scope, Function0<Unit> block) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(block, "block");
            Object previousScope = this.currentScope;
            IdentityArrayIntMap previousReads = this.currentScopeReads;
            int previousToken = this.currentToken;
            this.currentScope = scope;
            this.currentScopeReads = (IdentityArrayIntMap) this.scopeToValues.get(scope);
            if (this.currentToken == -1) {
                this.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            block.invoke();
            Object access$getCurrentScope$p = this.currentScope;
            Intrinsics.checkNotNull(access$getCurrentScope$p);
            clearObsoleteStateReads(access$getCurrentScope$p);
            this.currentScope = previousScope;
            this.currentScopeReads = previousReads;
            this.currentToken = previousToken;
        }

        /* access modifiers changed from: private */
        public final void clearObsoleteStateReads(Object scope) {
            IdentityArrayIntMap this_$iv = this.currentScopeReads;
            if (this_$iv != null) {
                int destinationIndex$iv = 0;
                int size = this_$iv.getSize();
                for (int i$iv = 0; i$iv < size; i$iv++) {
                    Object key$iv = this_$iv.getKeys()[i$iv];
                    Intrinsics.checkNotNull(key$iv, "null cannot be cast to non-null type kotlin.Any");
                    int value$iv = this_$iv.getValues()[i$iv];
                    Object value = key$iv;
                    boolean willRemove = value$iv != this.currentToken;
                    if (willRemove) {
                        removeObservation(scope, value);
                    }
                    if (!willRemove) {
                        if (destinationIndex$iv != i$iv) {
                            this_$iv.getKeys()[destinationIndex$iv] = key$iv;
                            this_$iv.getValues()[destinationIndex$iv] = value$iv;
                        }
                        destinationIndex$iv++;
                    }
                }
                int size2 = this_$iv.getSize();
                for (int i$iv2 = destinationIndex$iv; i$iv2 < size2; i$iv2++) {
                    this_$iv.getKeys()[i$iv2] = null;
                }
                this_$iv.setSize(destinationIndex$iv);
            }
        }

        public final void clearScopeObservations(Object scope) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            IdentityArrayIntMap recordedValues = this.scopeToValues.remove(scope);
            if (recordedValues != null) {
                IdentityArrayIntMap this_$iv = recordedValues;
                int size = this_$iv.getSize();
                for (int i$iv = 0; i$iv < size; i$iv++) {
                    Object value = this_$iv.getKeys()[i$iv];
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Any");
                    int i = this_$iv.getValues()[i$iv];
                    removeObservation(scope, value);
                }
            }
        }

        public final void removeScopeIf(Function1<Object, Boolean> predicate) {
            int $i$f$removeIf;
            int i;
            Function1<Object, Boolean> function1 = predicate;
            Intrinsics.checkNotNullParameter(function1, "predicate");
            IdentityArrayMap this_$iv = this.scopeToValues;
            int $i$f$removeIf2 = 0;
            int current$iv = 0;
            int index$iv = 0;
            int size$runtime_release = this_$iv.getSize$runtime_release();
            while (index$iv < size$runtime_release) {
                Object key$iv = this_$iv.getKeys$runtime_release()[index$iv];
                Intrinsics.checkNotNull(key$iv, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                IdentityArrayIntMap valueSet = (IdentityArrayIntMap) this_$iv.getValues$runtime_release()[index$iv];
                Object scope = key$iv;
                Boolean invoke = function1.invoke(scope);
                if (invoke.booleanValue()) {
                    IdentityArrayIntMap this_$iv2 = valueSet;
                    int size = this_$iv2.getSize();
                    $i$f$removeIf = $i$f$removeIf2;
                    int i$iv = 0;
                    while (i$iv < size) {
                        int i2 = size;
                        Object value = this_$iv2.getKeys()[i$iv];
                        int i3 = size$runtime_release;
                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Any");
                        int i4 = this_$iv2.getValues()[i$iv];
                        removeObservation(scope, value);
                        i$iv++;
                        size$runtime_release = i3;
                        size = i2;
                    }
                    i = size$runtime_release;
                } else {
                    $i$f$removeIf = $i$f$removeIf2;
                    i = size$runtime_release;
                }
                if (!invoke.booleanValue()) {
                    if (current$iv != index$iv) {
                        this_$iv.getKeys$runtime_release()[current$iv] = key$iv;
                        this_$iv.getValues$runtime_release()[current$iv] = this_$iv.getValues$runtime_release()[index$iv];
                    }
                    current$iv++;
                }
                index$iv++;
                function1 = predicate;
                size$runtime_release = i;
                $i$f$removeIf2 = $i$f$removeIf;
            }
            if (this_$iv.getSize$runtime_release() > current$iv) {
                int size$runtime_release2 = this_$iv.getSize$runtime_release();
                for (int index$iv2 = current$iv; index$iv2 < size$runtime_release2; index$iv2++) {
                    this_$iv.getKeys$runtime_release()[index$iv2] = null;
                    this_$iv.getValues$runtime_release()[index$iv2] = null;
                }
                this_$iv.setSize$runtime_release(current$iv);
            }
        }

        private final void removeObservation(Object scope, Object value) {
            this.valueToScopes.remove(value, scope);
            if ((value instanceof DerivedState) && !this.valueToScopes.contains(value)) {
                this.dependencyToDerivedStates.removeScope(value);
                this.recordedDerivedStateValues.remove(value);
            }
        }

        public final void clear() {
            this.valueToScopes.clear();
            this.scopeToValues.clear();
            this.dependencyToDerivedStates.clear();
            this.recordedDerivedStateValues.clear();
        }

        public final boolean recordInvalidation(Set<? extends Object> changes) {
            Iterator<? extends Object> it;
            Iterator<? extends Object> it2;
            Intrinsics.checkNotNullParameter(changes, "changes");
            boolean hasValues = false;
            Iterator<? extends Object> it3 = changes.iterator();
            while (it3.hasNext()) {
                Object value = it3.next();
                if (this.dependencyToDerivedStates.contains(value)) {
                    IdentityScopeMap this_$iv = this.dependencyToDerivedStates;
                    int index$iv = this_$iv.find(value);
                    if (index$iv >= 0) {
                        IdentityArraySet this_$iv$iv = this_$iv.scopeSetAt(index$iv);
                        int i$iv$iv = 0;
                        int size = this_$iv$iv.size();
                        while (i$iv$iv < size) {
                            DerivedState derivedState = (DerivedState) this_$iv$iv.get(i$iv$iv);
                            Intrinsics.checkNotNull(derivedState, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                            Object previousValue = this.recordedDerivedStateValues.get(derivedState);
                            SnapshotMutationPolicy policy = derivedState.getPolicy();
                            if (policy == null) {
                                policy = SnapshotStateKt.structuralEqualityPolicy();
                            }
                            boolean hasValues2 = hasValues;
                            if (!policy.equivalent(derivedState.getCurrentValue(), previousValue)) {
                                IdentityScopeMap identityScopeMap = this.valueToScopes;
                                int index$iv2 = identityScopeMap.find(derivedState);
                                if (index$iv2 >= 0) {
                                    it2 = it3;
                                    IdentityArraySet this_$iv$iv2 = identityScopeMap.scopeSetAt(index$iv2);
                                    IdentityScopeMap<Object> identityScopeMap2 = identityScopeMap;
                                    int size2 = this_$iv$iv2.size();
                                    int i$iv$iv2 = index$iv2;
                                    int i$iv$iv3 = 0;
                                    while (i$iv$iv3 < size2) {
                                        this.invalidated.add(this_$iv$iv2.get(i$iv$iv3));
                                        hasValues2 = true;
                                        i$iv$iv3++;
                                        size2 = size2;
                                        this_$iv$iv2 = this_$iv$iv2;
                                    }
                                } else {
                                    IdentityScopeMap this_$iv2 = identityScopeMap;
                                    int i = index$iv2;
                                    it2 = it3;
                                }
                            } else {
                                it2 = it3;
                            }
                            hasValues = hasValues2;
                            i$iv$iv++;
                            Set<? extends Object> set = changes;
                            it3 = it2;
                        }
                        boolean z = hasValues;
                        it = it3;
                    } else {
                        it = it3;
                    }
                } else {
                    it = it3;
                }
                IdentityScopeMap this_$iv3 = this.valueToScopes;
                int index$iv3 = this_$iv3.find(value);
                if (index$iv3 >= 0) {
                    IdentityArraySet this_$iv$iv3 = this_$iv3.scopeSetAt(index$iv3);
                    int size3 = this_$iv$iv3.size();
                    for (int i$iv$iv4 = 0; i$iv$iv4 < size3; i$iv$iv4++) {
                        this.invalidated.add(this_$iv$iv3.get(i$iv$iv4));
                        hasValues = true;
                    }
                }
                Set<? extends Object> set2 = changes;
                it3 = it;
            }
            return hasValues;
        }

        public final void notifyInvalidatedScopes() {
            IdentityArraySet this_$iv = this.invalidated;
            Function1 block$iv = this.onChanged;
            int size = this_$iv.size();
            for (int i$iv = 0; i$iv < size; i$iv++) {
                block$iv.invoke(this_$iv.get(i$iv));
            }
            this.invalidated.clear();
        }
    }
}
