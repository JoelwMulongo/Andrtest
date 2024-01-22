package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001+B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!J:\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010$\u001a\u00020%2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J\b\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010*\u001a\u00020'H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u0004\u0018\u00018\u00008G¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000b¨\u0006,"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState;", "T", "Landroidx/compose/runtime/snapshots/StateObject;", "Landroidx/compose/runtime/DerivedState;", "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "()V", "getDebuggerDisplayValue", "dependencies", "", "", "getDependencies", "()[Ljava/lang/Object;", "first", "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "value", "getValue", "current", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "currentRecord", "readable", "forceDependencyReads", "", "displayValue", "", "prependStateRecord", "", "toString", "ResultRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DerivedState.kt */
final class DerivedSnapshotState<T> implements StateObject, DerivedState<T> {
    private final Function0<T> calculation;
    private ResultRecord<T> first = new ResultRecord<>();
    private final SnapshotMutationPolicy<T> policy;

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public DerivedSnapshotState(Function0<? extends T> calculation2, SnapshotMutationPolicy<T> policy2) {
        Intrinsics.checkNotNullParameter(calculation2, "calculation");
        this.calculation = calculation2;
        this.policy = policy2;
    }

    public SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \"*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0001\"B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\u001f\u001a\u00020 J\u001a\u0010!\u001a\u00020\u00072\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\u001f\u001a\u00020 R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "()V", "dependencies", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/snapshots/StateObject;", "", "getDependencies", "()Landroidx/compose/runtime/collection/IdentityArrayMap;", "setDependencies", "(Landroidx/compose/runtime/collection/IdentityArrayMap;)V", "result", "", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "resultHash", "getResultHash", "()I", "setResultHash", "(I)V", "assign", "", "value", "create", "isValid", "", "derivedState", "Landroidx/compose/runtime/DerivedState;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readableHash", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DerivedState.kt */
    public static final class ResultRecord<T> extends StateRecord {
        public static final int $stable = 8;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final Object Unset = new Object();
        private IdentityArrayMap<StateObject, Integer> dependencies;
        private Object result = Unset;
        private int resultHash;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord$Companion;", "", "()V", "Unset", "getUnset", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: DerivedState.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Object getUnset() {
                return ResultRecord.Unset;
            }
        }

        public final IdentityArrayMap<StateObject, Integer> getDependencies() {
            return this.dependencies;
        }

        public final void setDependencies(IdentityArrayMap<StateObject, Integer> identityArrayMap) {
            this.dependencies = identityArrayMap;
        }

        public final Object getResult() {
            return this.result;
        }

        public final void setResult(Object obj) {
            this.result = obj;
        }

        public final int getResultHash() {
            return this.resultHash;
        }

        public final void setResultHash(int i) {
            this.resultHash = i;
        }

        public void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ResultRecord other = (ResultRecord) value;
            this.dependencies = other.dependencies;
            this.result = other.result;
            this.resultHash = other.resultHash;
        }

        public StateRecord create() {
            return new ResultRecord();
        }

        public final boolean isValid(DerivedState<?> derivedState, Snapshot snapshot) {
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            return this.result != Unset && this.resultHash == readableHash(derivedState, snapshot);
        }

        /* JADX INFO: finally extract failed */
        public final int readableHash(DerivedState<?> derivedState, Snapshot snapshot) {
            IdentityArrayMap identityArrayMap;
            StateRecord record;
            DerivedState<?> derivedState2 = derivedState;
            Snapshot snapshot2 = snapshot;
            Intrinsics.checkNotNullParameter(derivedState2, "derivedState");
            Intrinsics.checkNotNullParameter(snapshot2, "snapshot");
            int hash = 7;
            synchronized (SnapshotKt.getLock()) {
                try {
                    identityArrayMap = this.dependencies;
                } catch (Throwable th) {
                    throw th;
                }
            }
            IdentityArrayMap dependencies2 = identityArrayMap;
            if (dependencies2 != null) {
                MutableVector this_$iv$iv = (MutableVector) SnapshotStateKt__DerivedStateKt.derivedStateObservers.get();
                if (this_$iv$iv == null) {
                    this_$iv$iv = new MutableVector(new Pair[0], 0);
                }
                MutableVector observers$iv = this_$iv$iv;
                int size$iv$iv = this_$iv$iv.getSize();
                int i = 1;
                if (size$iv$iv > 0) {
                    int i$iv$iv = 0;
                    Object[] content$iv$iv = this_$iv$iv.getContent();
                    do {
                        ((Function1) ((Pair) content$iv$iv[i$iv$iv]).component1()).invoke(derivedState2);
                        i$iv$iv++;
                    } while (i$iv$iv < size$iv$iv);
                }
                IdentityArrayMap this_$iv = dependencies2;
                int index$iv = 0;
                try {
                    int size$runtime_release = this_$iv.getSize$runtime_release();
                    while (index$iv < size$runtime_release) {
                        Object obj = this_$iv.getKeys$runtime_release()[index$iv];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                        StateObject stateObject = (StateObject) obj;
                        if (((Number) this_$iv.getValues$runtime_release()[index$iv]).intValue() == i) {
                            if (stateObject instanceof DerivedSnapshotState) {
                                record = ((DerivedSnapshotState) stateObject).current(snapshot2);
                            } else {
                                record = SnapshotKt.current(stateObject.getFirstStateRecord(), snapshot2);
                            }
                            hash = (((hash * 31) + ActualJvm_jvmKt.identityHashCode(record)) * 31) + record.getSnapshotId$runtime_release();
                        }
                        index$iv++;
                        i = 1;
                    }
                    Unit unit = Unit.INSTANCE;
                    MutableVector this_$iv$iv2 = observers$iv;
                    int size$iv$iv2 = this_$iv$iv2.getSize();
                    if (size$iv$iv2 > 0) {
                        int i$iv$iv2 = 0;
                        Object[] content$iv$iv2 = this_$iv$iv2.getContent();
                        do {
                            ((Function1) ((Pair) content$iv$iv2[i$iv$iv2]).component2()).invoke(derivedState2);
                            i$iv$iv2++;
                        } while (i$iv$iv2 < size$iv$iv2);
                    }
                } catch (Throwable th2) {
                    MutableVector this_$iv$iv3 = observers$iv;
                    int size$iv$iv3 = this_$iv$iv3.getSize();
                    if (size$iv$iv3 > 0) {
                        int i$iv$iv3 = 0;
                        Object[] content$iv$iv3 = this_$iv$iv3.getContent();
                        do {
                            ((Function1) ((Pair) content$iv$iv3[i$iv$iv3]).component2()).invoke(derivedState2);
                            i$iv$iv3++;
                        } while (i$iv$iv3 < size$iv$iv3);
                    }
                    throw th2;
                }
            }
            return hash;
        }
    }

    public final StateRecord current(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshot), snapshot, false, this.calculation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:94:0x0247  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T> currentRecord(androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T> r19, androidx.compose.runtime.snapshots.Snapshot r20, boolean r21, kotlin.jvm.functions.Function0<? extends T> r22) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r0 = r1
            androidx.compose.runtime.DerivedState r0 = (androidx.compose.runtime.DerivedState) r0
            r3 = r20
            boolean r0 = r2.isValid(r0, r3)
            r4 = 0
            r5 = 1
            if (r0 == 0) goto L_0x0110
            if (r21 == 0) goto L_0x010f
            r6 = 0
            androidx.compose.runtime.SnapshotThreadLocal r0 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.derivedStateObservers
            java.lang.Object r0 = r0.get()
            androidx.compose.runtime.collection.MutableVector r0 = (androidx.compose.runtime.collection.MutableVector) r0
            if (r0 != 0) goto L_0x002a
            r0 = 0
            r7 = 0
            androidx.compose.runtime.collection.MutableVector r8 = new androidx.compose.runtime.collection.MutableVector
            kotlin.Pair[] r9 = new kotlin.Pair[r0]
            r8.<init>(r9, r4)
            r0 = r8
        L_0x002a:
            r7 = r0
            r8 = 0
            int r9 = r0.getSize()
            if (r9 <= 0) goto L_0x004e
            r10 = 0
            java.lang.Object[] r11 = r0.getContent()
        L_0x0039:
            r12 = r11[r10]
            kotlin.Pair r12 = (kotlin.Pair) r12
            r13 = 0
            java.lang.Object r12 = r12.component1()
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r14 = r1
            androidx.compose.runtime.DerivedState r14 = (androidx.compose.runtime.DerivedState) r14
            r12.invoke(r14)
            int r10 = r10 + r5
            if (r10 < r9) goto L_0x0039
        L_0x004e:
            r0 = 0
            androidx.compose.runtime.collection.IdentityArrayMap r8 = r19.getDependencies()     // Catch:{ all -> 0x00e7 }
            androidx.compose.runtime.SnapshotThreadLocal r9 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel     // Catch:{ all -> 0x00e7 }
            java.lang.Object r9 = r9.get()     // Catch:{ all -> 0x00e7 }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ all -> 0x00e7 }
            if (r9 == 0) goto L_0x0065
            int r4 = r9.intValue()     // Catch:{ all -> 0x00e7 }
        L_0x0065:
            if (r8 == 0) goto L_0x00af
            r9 = r8
            r10 = 0
            r11 = 0
            int r12 = r9.getSize$runtime_release()     // Catch:{ all -> 0x00e7 }
        L_0x006e:
            if (r11 >= r12) goto L_0x00ab
            java.lang.Object[] r13 = r9.getKeys$runtime_release()     // Catch:{ all -> 0x00e7 }
            r13 = r13[r11]     // Catch:{ all -> 0x00e7 }
            java.lang.String r14 = "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r14)     // Catch:{ all -> 0x00e7 }
            java.lang.Object[] r14 = r9.getValues$runtime_release()     // Catch:{ all -> 0x00e7 }
            r14 = r14[r11]     // Catch:{ all -> 0x00e7 }
            java.lang.Number r14 = (java.lang.Number) r14     // Catch:{ all -> 0x00e7 }
            int r14 = r14.intValue()     // Catch:{ all -> 0x00e7 }
            androidx.compose.runtime.snapshots.StateObject r13 = (androidx.compose.runtime.snapshots.StateObject) r13     // Catch:{ all -> 0x00e7 }
            r15 = 0
            androidx.compose.runtime.SnapshotThreadLocal r5 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel     // Catch:{ all -> 0x00e7 }
            int r16 = r14 + r4
            r17 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x00e7 }
            r5.set(r0)     // Catch:{ all -> 0x00e7 }
            kotlin.jvm.functions.Function1 r0 = r20.getReadObserver$runtime_release()     // Catch:{ all -> 0x00e7 }
            if (r0 == 0) goto L_0x00a3
            r0.invoke(r13)     // Catch:{ all -> 0x00e7 }
        L_0x00a3:
            int r11 = r11 + 1
            r0 = r17
            r5 = 1
            goto L_0x006e
        L_0x00ab:
            r17 = r0
            goto L_0x00b1
        L_0x00af:
            r17 = r0
        L_0x00b1:
            androidx.compose.runtime.SnapshotThreadLocal r0 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel     // Catch:{ all -> 0x00e7 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00e7 }
            r0.set(r5)     // Catch:{ all -> 0x00e7 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e7 }
            r0 = r7
            r4 = 0
            int r5 = r0.getSize()
            if (r5 <= 0) goto L_0x00e4
            r8 = 0
            java.lang.Object[] r9 = r0.getContent()
        L_0x00ce:
            r10 = r9[r8]
            kotlin.Pair r10 = (kotlin.Pair) r10
            r11 = 0
            java.lang.Object r10 = r10.component2()
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r12 = r1
            androidx.compose.runtime.DerivedState r12 = (androidx.compose.runtime.DerivedState) r12
            r10.invoke(r12)
            r10 = 1
            int r8 = r8 + r10
            if (r8 < r5) goto L_0x00ce
        L_0x00e4:
            goto L_0x010f
        L_0x00e7:
            r0 = move-exception
            r4 = r7
            r5 = 0
            int r8 = r4.getSize()
            if (r8 <= 0) goto L_0x010d
            r9 = 0
            java.lang.Object[] r10 = r4.getContent()
        L_0x00f6:
            r11 = r10[r9]
            kotlin.Pair r11 = (kotlin.Pair) r11
            r12 = 0
            java.lang.Object r11 = r11.component2()
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r13 = r1
            androidx.compose.runtime.DerivedState r13 = (androidx.compose.runtime.DerivedState) r13
            r11.invoke(r13)
            r11 = 1
            int r9 = r9 + r11
            if (r9 >= r8) goto L_0x010d
            goto L_0x00f6
        L_0x010d:
            throw r0
        L_0x010f:
            return r2
        L_0x0110:
            androidx.compose.runtime.SnapshotThreadLocal r0 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel
            java.lang.Object r0 = r0.get()
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 == 0) goto L_0x0121
            int r0 = r0.intValue()
            goto L_0x0122
        L_0x0121:
            r0 = r4
        L_0x0122:
            r5 = r0
            androidx.compose.runtime.collection.IdentityArrayMap r0 = new androidx.compose.runtime.collection.IdentityArrayMap
            r6 = 0
            r7 = 1
            r0.<init>(r4, r7, r6)
            r7 = r0
            r8 = 0
            androidx.compose.runtime.SnapshotThreadLocal r0 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.derivedStateObservers
            java.lang.Object r0 = r0.get()
            androidx.compose.runtime.collection.MutableVector r0 = (androidx.compose.runtime.collection.MutableVector) r0
            if (r0 != 0) goto L_0x0142
            r0 = 0
            r9 = 0
            androidx.compose.runtime.collection.MutableVector r10 = new androidx.compose.runtime.collection.MutableVector
            kotlin.Pair[] r11 = new kotlin.Pair[r0]
            r10.<init>(r11, r4)
            r0 = r10
        L_0x0142:
            r9 = r0
            r10 = 0
            int r11 = r0.getSize()
            if (r11 <= 0) goto L_0x016a
            r12 = 0
            java.lang.Object[] r13 = r0.getContent()
        L_0x0151:
            r14 = r13[r12]
            kotlin.Pair r14 = (kotlin.Pair) r14
            r15 = 0
            java.lang.Object r14 = r14.component1()
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r4 = r1
            androidx.compose.runtime.DerivedState r4 = (androidx.compose.runtime.DerivedState) r4
            r14.invoke(r4)
            r4 = 1
            int r12 = r12 + r4
            if (r12 < r11) goto L_0x0168
            goto L_0x016a
        L_0x0168:
            r4 = 0
            goto L_0x0151
        L_0x016a:
            r0 = 0
            androidx.compose.runtime.SnapshotThreadLocal r4 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel     // Catch:{ all -> 0x023b }
            int r10 = r5 + 1
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x023b }
            r4.set(r10)     // Catch:{ all -> 0x023b }
            androidx.compose.runtime.snapshots.Snapshot$Companion r4 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x023b }
            androidx.compose.runtime.DerivedSnapshotState$currentRecord$result$1$result$1 r10 = new androidx.compose.runtime.DerivedSnapshotState$currentRecord$result$1$result$1     // Catch:{ all -> 0x023b }
            r10.<init>(r1, r7, r5)     // Catch:{ all -> 0x023b }
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10     // Catch:{ all -> 0x023b }
            r11 = r22
            java.lang.Object r4 = r4.observe(r10, r6, r11)     // Catch:{ all -> 0x0239 }
            androidx.compose.runtime.SnapshotThreadLocal r6 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel     // Catch:{ all -> 0x0239 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0239 }
            r6.set(r10)     // Catch:{ all -> 0x0239 }
            r0 = r9
            r6 = 0
            int r10 = r0.getSize()
            if (r10 <= 0) goto L_0x01c1
            r12 = 0
            java.lang.Object[] r13 = r0.getContent()
        L_0x01a5:
            r14 = r13[r12]
            kotlin.Pair r14 = (kotlin.Pair) r14
            r15 = 0
            java.lang.Object r14 = r14.component2()
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r17 = r0
            r0 = r1
            androidx.compose.runtime.DerivedState r0 = (androidx.compose.runtime.DerivedState) r0
            r14.invoke(r0)
            r14 = 1
            int r12 = r12 + r14
            if (r12 < r10) goto L_0x01be
            goto L_0x01c3
        L_0x01be:
            r0 = r17
            goto L_0x01a5
        L_0x01c1:
            r17 = r0
        L_0x01c3:
            r6 = 0
            java.lang.Object r8 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r9 = 0
            monitor-enter(r8)
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r10 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0236 }
            androidx.compose.runtime.snapshots.Snapshot r10 = r10.getCurrent()     // Catch:{ all -> 0x0236 }
            java.lang.Object r12 = r19.getResult()     // Catch:{ all -> 0x0236 }
            androidx.compose.runtime.DerivedSnapshotState$ResultRecord$Companion r13 = androidx.compose.runtime.DerivedSnapshotState.ResultRecord.Companion     // Catch:{ all -> 0x0236 }
            java.lang.Object r13 = r13.getUnset()     // Catch:{ all -> 0x0236 }
            if (r12 == r13) goto L_0x020c
            androidx.compose.runtime.SnapshotMutationPolicy r12 = r18.getPolicy()     // Catch:{ all -> 0x0236 }
            if (r12 == 0) goto L_0x01f9
            java.lang.Object r13 = r19.getResult()     // Catch:{ all -> 0x0236 }
            boolean r12 = r12.equivalent(r4, r13)     // Catch:{ all -> 0x0236 }
            r13 = 1
            if (r12 != r13) goto L_0x01f6
            r16 = 1
            goto L_0x01fb
        L_0x01f6:
            r16 = 0
            goto L_0x01fb
        L_0x01f9:
            r16 = 0
        L_0x01fb:
            if (r16 == 0) goto L_0x020c
            r2.setDependencies(r7)     // Catch:{ all -> 0x0236 }
            r12 = r1
            androidx.compose.runtime.DerivedState r12 = (androidx.compose.runtime.DerivedState) r12     // Catch:{ all -> 0x0236 }
            int r12 = r2.readableHash(r12, r10)     // Catch:{ all -> 0x0236 }
            r2.setResultHash(r12)     // Catch:{ all -> 0x0236 }
            r12 = r2
            goto L_0x022a
        L_0x020c:
            androidx.compose.runtime.DerivedSnapshotState$ResultRecord<T> r12 = r1.first     // Catch:{ all -> 0x0236 }
            androidx.compose.runtime.snapshots.StateRecord r12 = (androidx.compose.runtime.snapshots.StateRecord) r12     // Catch:{ all -> 0x0236 }
            r13 = r1
            androidx.compose.runtime.snapshots.StateObject r13 = (androidx.compose.runtime.snapshots.StateObject) r13     // Catch:{ all -> 0x0236 }
            androidx.compose.runtime.snapshots.StateRecord r12 = androidx.compose.runtime.snapshots.SnapshotKt.newWritableRecord(r12, r13, r10)     // Catch:{ all -> 0x0236 }
            androidx.compose.runtime.DerivedSnapshotState$ResultRecord r12 = (androidx.compose.runtime.DerivedSnapshotState.ResultRecord) r12     // Catch:{ all -> 0x0236 }
            r12.setDependencies(r7)     // Catch:{ all -> 0x0236 }
            r13 = r1
            androidx.compose.runtime.DerivedState r13 = (androidx.compose.runtime.DerivedState) r13     // Catch:{ all -> 0x0236 }
            int r13 = r12.readableHash(r13, r10)     // Catch:{ all -> 0x0236 }
            r12.setResultHash(r13)     // Catch:{ all -> 0x0236 }
            r12.setResult(r4)     // Catch:{ all -> 0x0236 }
        L_0x022a:
            monitor-exit(r8)
            r0 = r12
            if (r5 != 0) goto L_0x0235
            androidx.compose.runtime.snapshots.Snapshot$Companion r6 = androidx.compose.runtime.snapshots.Snapshot.Companion
            r6.notifyObjectsInitialized()
        L_0x0235:
            return r0
        L_0x0236:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        L_0x0239:
            r0 = move-exception
            goto L_0x023e
        L_0x023b:
            r0 = move-exception
            r11 = r22
        L_0x023e:
            r4 = r9
            r6 = 0
            int r10 = r4.getSize()
            if (r10 <= 0) goto L_0x0265
            r12 = 0
            java.lang.Object[] r13 = r4.getContent()
        L_0x024c:
            r14 = r13[r12]
            kotlin.Pair r14 = (kotlin.Pair) r14
            r15 = 0
            java.lang.Object r14 = r14.component2()
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r2 = r1
            androidx.compose.runtime.DerivedState r2 = (androidx.compose.runtime.DerivedState) r2
            r14.invoke(r2)
            r2 = 1
            int r12 = r12 + r2
            if (r12 >= r10) goto L_0x0265
            r2 = r19
            goto L_0x024c
        L_0x0265:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.DerivedSnapshotState.currentRecord(androidx.compose.runtime.DerivedSnapshotState$ResultRecord, androidx.compose.runtime.snapshots.Snapshot, boolean, kotlin.jvm.functions.Function0):androidx.compose.runtime.DerivedSnapshotState$ResultRecord");
    }

    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.first = (ResultRecord) value;
    }

    public T getValue() {
        Function1<Object, Unit> readObserver$runtime_release = Snapshot.Companion.getCurrent().getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(this);
        }
        return currentRecord((ResultRecord) SnapshotKt.current(this.first), Snapshot.Companion.getCurrent(), true, this.calculation).getResult();
    }

    public T getCurrentValue() {
        return currentRecord((ResultRecord) SnapshotKt.current(this.first), Snapshot.Companion.getCurrent(), false, this.calculation).getResult();
    }

    public Object[] getDependencies() {
        Object[] keys$runtime_release;
        IdentityArrayMap<StateObject, Integer> dependencies = currentRecord((ResultRecord) SnapshotKt.current(this.first), Snapshot.Companion.getCurrent(), false, this.calculation).getDependencies();
        if (dependencies == null || (keys$runtime_release = dependencies.getKeys$runtime_release()) == null) {
            return new Object[0];
        }
        return keys$runtime_release;
    }

    public String toString() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }

    public final T getDebuggerDisplayValue() {
        ResultRecord it = (ResultRecord) SnapshotKt.current(this.first);
        if (it.isValid(this, Snapshot.Companion.getCurrent())) {
            return it.getResult();
        }
        return null;
    }

    private final String displayValue() {
        ResultRecord it = (ResultRecord) SnapshotKt.current(this.first);
        if (it.isValid(this, Snapshot.Companion.getCurrent())) {
            return String.valueOf(it.getResult());
        }
        return "<Not calculated>";
    }
}
