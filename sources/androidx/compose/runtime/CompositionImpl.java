package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010T\u001a\u00020\u001bH\u0002J\u001e\u0010U\u001a\u00020\u001b2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020.0W2\u0006\u0010X\u001a\u00020\u000fH\u0002J\b\u0010Y\u001a\u00020\u001bH\u0016Jc\u0010Z\u001a\u00020\u001b2Y\u0010\u0012\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0014j\u0002`\u001c0\u0013H\u0002J\b\u0010[\u001a\u00020\u001bH\u0016J\b\u0010\\\u001a\u00020\u001bH\u0016J\b\u0010]\u001a\u00020\u001bH\u0002J \u0010^\u001a\u00020\u001b2\u0011\u0010_\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001e¢\u0006\u0002\b\u001fH\u0016¢\u0006\u0002\u0010#J3\u0010`\u001a\u0002Ha\"\u0004\b\u0000\u0010a2\b\u0010b\u001a\u0004\u0018\u00010\u00012\u0006\u0010c\u001a\u00020:2\f\u0010d\u001a\b\u0012\u0004\u0012\u0002Ha0\u001eH\u0016¢\u0006\u0002\u0010eJ\b\u0010f\u001a\u00020\u001bH\u0016J\u0010\u0010g\u001a\u00020\u001b2\u0006\u0010h\u001a\u00020iH\u0016J\b\u0010j\u001a\u00020\u001bH\u0002J\b\u0010k\u001a\u00020\u001bH\u0002J\"\u0010l\u001a\u0002Hm\"\u0004\b\u0000\u0010m2\f\u0010d\u001a\b\u0012\u0004\u0012\u0002Hm0\u001eH\b¢\u0006\u0002\u0010nJK\u0010o\u001a\u0002Hm\"\u0004\b\u0000\u0010m25\u0010d\u001a1\u0012'\u0012%\u0012\u0004\u0012\u00020)\u0012\f\u0012\n\u0012\u0004\u0012\u00020.\u0018\u00010=0<¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002Hm0pH\b¢\u0006\u0002\u0010qJ$\u0010r\u001a\u00020\u001b2\u001a\u0010s\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020u\u0012\u0006\u0012\u0004\u0018\u00010u0t0(H\u0016J\u0018\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020)2\b\u0010y\u001a\u0004\u0018\u00010.J\b\u0010z\u001a\u00020\u001bH\u0016J\"\u0010{\u001a\u00020w2\u0006\u0010x\u001a\u00020)2\u0006\u0010|\u001a\u00020}2\b\u0010y\u001a\u0004\u0018\u00010.H\u0002J\u000e\u0010~\u001a\u00020\u001b2\u0006\u0010\u001a\u00020:J\u0012\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020.H\u0002J\u0017\u0010\u0001\u001a\u00020\u000f2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020.0WH\u0016J\u0017\u0010\u0001\u001a\u00020\u001b2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001eH\u0016J\t\u0010\u0001\u001a\u00020\u000fH\u0016J\u0017\u0010\u0001\u001a\u00020\u001b2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020.0WH\u0016J\u0012\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020.H\u0016J\u0012\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020.H\u0016J\u001b\u0010\u0001\u001a\u00020\u001b2\n\u0010h\u001a\u0006\u0012\u0002\b\u000302H\u0000¢\u0006\u0003\b\u0001J\u001f\u0010\u0001\u001a\u00020\u001b2\u0006\u0010y\u001a\u00020.2\u0006\u0010x\u001a\u00020)H\u0000¢\u0006\u0003\b\u0001J!\u0010\u0001\u001a\u00020\u001b2\u0011\u0010_\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001e¢\u0006\u0002\b\u001fH\u0016¢\u0006\u0002\u0010#J\u001d\u0010\u0001\u001a\u0016\u0012\u0004\u0012\u00020)\u0012\f\u0012\n\u0012\u0004\u0012\u00020.\u0018\u00010=0<H\u0002J#\u0010\u0001\u001a\u0002Hm\"\u0004\b\u0000\u0010m2\f\u0010d\u001a\b\u0012\u0004\u0012\u0002Hm0\u001eH\b¢\u0006\u0002\u0010nJ\u0011\u0010\u0001\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020QH\u0002J\t\u0010\u0001\u001a\u00020\u001bH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011Ra\u0010\u0012\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0014j\u0002`\u001c0\u0013X\u0004¢\u0006\u0002\n\u0000R'\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001e¢\u0006\u0002\b\u001fX\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(8@X\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001e\u0010,\u001a\u0012\u0012\u0004\u0012\u00020)0\u000bj\b\u0012\u0004\u0012\u00020)`\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020.0(8@X\u0004¢\u0006\u0006\u001a\u0004\b/\u0010+R\u0018\u00100\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030201X\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0011R\u0014\u00106\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0011R\u0010\u00108\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u000e¢\u0006\u0002\n\u0000R\"\u0010;\u001a\u0016\u0012\u0004\u0012\u00020)\u0012\f\u0012\n\u0012\u0004\u0012\u00020.\u0018\u00010=0<X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0011R\u0014\u0010?\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0011R\u0011\u0010@\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0011Ra\u0010A\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0014j\u0002`\u001c0\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020)01X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020)01X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020.0(8@X\u0004¢\u0006\u0006\u001a\u0004\bF\u0010+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010G\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0011\"\u0004\bI\u0010JR\"\u0010K\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010.0Lj\n\u0012\u0006\u0012\u0004\u0018\u00010.`MX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010P\u001a\u00020QX\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010S¨\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "parent", "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "recomposeContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "_recomposeContext", "abandonSet", "Ljava/util/HashSet;", "Landroidx/compose/runtime/RememberObserver;", "Lkotlin/collections/HashSet;", "areChildrenComposing", "", "getAreChildrenComposing", "()Z", "changes", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "composable", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "conditionalScopes", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getConditionalScopes$runtime_release", "()Ljava/util/List;", "conditionallyInvalidatedScopes", "derivedStateDependencies", "", "getDerivedStateDependencies$runtime_release", "derivedStates", "Landroidx/compose/runtime/collection/IdentityScopeMap;", "Landroidx/compose/runtime/DerivedState;", "disposed", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges", "invalidationDelegate", "invalidationDelegateGroup", "", "invalidations", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "isComposing", "isDisposed", "isRoot", "lateChanges", "lock", "observations", "observationsProcessed", "observedObjects", "getObservedObjects$runtime_release", "pendingInvalidScopes", "getPendingInvalidScopes$runtime_release", "setPendingInvalidScopes$runtime_release", "(Z)V", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "getRecomposeContext", "()Lkotlin/coroutines/CoroutineContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "abandonChanges", "addPendingInvalidationsLocked", "values", "", "forgetConditionalScopes", "applyChanges", "applyChangesInLocked", "applyLateChanges", "changesApplied", "cleanUpDerivedStateObservations", "composeContent", "content", "delegateInvalidations", "R", "to", "groupIndex", "block", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "dispose", "disposeUnusedMovableContent", "state", "Landroidx/compose/runtime/MovableContentState;", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "guardChanges", "T", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "guardInvalidationsLocked", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "insertMovableContent", "references", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "invalidateAll", "invalidateChecked", "anchor", "Landroidx/compose/runtime/Anchor;", "invalidateGroupsWithKey", "key", "invalidateScopeOfLocked", "value", "observesAnyOf", "prepareCompose", "recompose", "recordModificationsOf", "recordReadOf", "recordWriteOf", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime_release", "removeObservation", "removeObservation$runtime_release", "setContent", "takeInvalidations", "trackAbandonedValues", "validateRecomposeScopeAnchors", "verifyConsistent", "RememberEventDispatcher", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composition.kt */
public final class CompositionImpl implements ControlledComposition {
    private final CoroutineContext _recomposeContext;
    private final HashSet<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final ComposerImpl composer;
    private final HashSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final IdentityScopeMap<DerivedState<?>> derivedStates;
    private boolean disposed;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidations;
    private final boolean isRoot;
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> lateChanges;
    private final Object lock;
    private final IdentityScopeMap<RecomposeScopeImpl> observations;
    private final IdentityScopeMap<RecomposeScopeImpl> observationsProcessed;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private final SlotTable slotTable;

    public CompositionImpl(CompositionContext parent2, Applier<?> applier2, CoroutineContext recomposeContext) {
        Intrinsics.checkNotNullParameter(parent2, "parent");
        Intrinsics.checkNotNullParameter(applier2, "applier");
        this.parent = parent2;
        this.applier = applier2;
        this.pendingModifications = new AtomicReference<>((Object) null);
        this.lock = new Object();
        HashSet<RememberObserver> hashSet = new HashSet<>();
        this.abandonSet = hashSet;
        SlotTable slotTable2 = new SlotTable();
        this.slotTable = slotTable2;
        this.observations = new IdentityScopeMap<>();
        this.conditionallyInvalidatedScopes = new HashSet<>();
        this.derivedStates = new IdentityScopeMap<>();
        List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> arrayList = new ArrayList<>();
        this.changes = arrayList;
        List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> arrayList2 = new ArrayList<>();
        this.lateChanges = arrayList2;
        this.observationsProcessed = new IdentityScopeMap<>();
        this.invalidations = new IdentityArrayMap<>(0, 1, (DefaultConstructorMarker) null);
        ComposerImpl it = new ComposerImpl(applier2, parent2, slotTable2, hashSet, arrayList, arrayList2, this);
        parent2.registerComposer$runtime_release(it);
        this.composer = it;
        this._recomposeContext = recomposeContext;
        this.isRoot = parent2 instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m2762getLambda1$runtime_release();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier2, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier2, (i & 4) != 0 ? null : coroutineContext);
    }

    public final SlotTable getSlotTable$runtime_release() {
        return this.slotTable;
    }

    public final List<Object> getObservedObjects$runtime_release() {
        return ArraysKt.filterNotNull(this.observations.getValues());
    }

    public final List<Object> getDerivedStateDependencies$runtime_release() {
        return ArraysKt.filterNotNull(this.derivedStates.getValues());
    }

    public final List<RecomposeScopeImpl> getConditionalScopes$runtime_release() {
        return CollectionsKt.toList(this.conditionallyInvalidatedScopes);
    }

    public final boolean getPendingInvalidScopes$runtime_release() {
        return this.pendingInvalidScopes;
    }

    public final void setPendingInvalidScopes$runtime_release(boolean z) {
        this.pendingInvalidScopes = z;
    }

    public final CoroutineContext getRecomposeContext() {
        CoroutineContext coroutineContext = this._recomposeContext;
        return coroutineContext == null ? this.parent.getRecomposeCoroutineContext$runtime_release() : coroutineContext;
    }

    public final boolean isRoot() {
        return this.isRoot;
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    public final void setComposable(Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.composable = function2;
    }

    public boolean isComposing() {
        return this.composer.isComposing$runtime_release();
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime_release;
        synchronized (this.lock) {
            hasPendingChanges$runtime_release = this.composer.getHasPendingChanges$runtime_release();
        }
        return hasPendingChanges$runtime_release;
    }

    public void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (!this.disposed) {
            this.composable = content;
            this.parent.composeInitial$runtime_release(this, content);
            return;
        }
        throw new IllegalStateException("The composition is disposed".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
        if (r0 == null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        r6 = r0;
        r8 = 0;
        r9 = r6.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r8 >= r9) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (((androidx.compose.runtime.RecomposeScopeImpl) r6.get(r8)).invalidateForResult((java.lang.Object) null) != androidx.compose.runtime.InvalidationResult.IGNORED) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        if (r2 == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
        if (r2 == false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (r2 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0050, code lost:
        if (r1.composer.forceRecomposeScopes$runtime_release() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0052, code lost:
        r1.parent.invalidate$runtime_release(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        r0 = r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invalidateGroupsWithKey(int r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.Object r2 = r1.lock
            r3 = 0
            monitor-enter(r2)
            r0 = 0
            androidx.compose.runtime.SlotTable r4 = r1.slotTable     // Catch:{ all -> 0x005d }
            r5 = r17
            java.util.List r4 = r4.invalidateGroupsWithKey$runtime_release(r5)     // Catch:{ all -> 0x005b }
            monitor-exit(r2)
            r0 = r4
            if (r0 == 0) goto L_0x0046
            r3 = r0
            r4 = 0
            r6 = r3
            r7 = 0
            r8 = 0
            int r9 = r6.size()
        L_0x001e:
            if (r8 >= r9) goto L_0x003f
            java.lang.Object r11 = r6.get(r8)
            r12 = r11
            r13 = 0
            r14 = r12
            androidx.compose.runtime.RecomposeScopeImpl r14 = (androidx.compose.runtime.RecomposeScopeImpl) r14
            r15 = 0
            r2 = 0
            androidx.compose.runtime.InvalidationResult r2 = r14.invalidateForResult(r2)
            androidx.compose.runtime.InvalidationResult r10 = androidx.compose.runtime.InvalidationResult.IGNORED
            if (r2 != r10) goto L_0x0035
            r2 = 1
            goto L_0x0036
        L_0x0035:
            r2 = 0
        L_0x0036:
            if (r2 == 0) goto L_0x003a
            r2 = 1
            goto L_0x0041
        L_0x003a:
            int r8 = r8 + 1
            goto L_0x001e
        L_0x003f:
            r2 = 0
        L_0x0041:
            if (r2 == 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r2 = 0
            goto L_0x0047
        L_0x0046:
            r2 = 1
        L_0x0047:
            if (r2 == 0) goto L_0x005a
            androidx.compose.runtime.ComposerImpl r3 = r1.composer
            boolean r3 = r3.forceRecomposeScopes$runtime_release()
            if (r3 == 0) goto L_0x005a
            androidx.compose.runtime.CompositionContext r3 = r1.parent
            r4 = r1
            androidx.compose.runtime.ControlledComposition r4 = (androidx.compose.runtime.ControlledComposition) r4
            r3.invalidate$runtime_release(r4)
        L_0x005a:
            return
        L_0x005b:
            r0 = move-exception
            goto L_0x0060
        L_0x005d:
            r0 = move-exception
            r5 = r17
        L_0x0060:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.invalidateGroupsWithKey(int):void");
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object toRecord = this.pendingModifications.getAndSet(CompositionKt.PendingApplyNoModifications);
        if (toRecord == null) {
            return;
        }
        if (Intrinsics.areEqual(toRecord, CompositionKt.PendingApplyNoModifications)) {
            ComposerKt.composeRuntimeError("pending composition has not been applied");
            throw new KotlinNothingValueException();
        } else if (toRecord instanceof Set) {
            addPendingInvalidationsLocked((Set) toRecord, true);
        } else if (toRecord instanceof Object[]) {
            for (Set changed : (Set[]) toRecord) {
                addPendingInvalidationsLocked(changed, true);
            }
        } else {
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
    }

    private final void drainPendingModificationsLocked() {
        Object toRecord = this.pendingModifications.getAndSet((Object) null);
        if (Intrinsics.areEqual(toRecord, CompositionKt.PendingApplyNoModifications)) {
            return;
        }
        if (toRecord instanceof Set) {
            addPendingInvalidationsLocked((Set) toRecord, false);
        } else if (toRecord instanceof Object[]) {
            for (Set changed : (Set[]) toRecord) {
                addPendingInvalidationsLocked(changed, false);
            }
        } else if (toRecord == null) {
            ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
            throw new KotlinNothingValueException();
        } else {
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0056 A[SYNTHETIC, Splitter:B:31:0x0056] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void composeContent(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r18) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r3 = r17
            r4 = 0
            r5 = r3
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.Object r0 = r1.lock     // Catch:{ all -> 0x0051 }
            r9 = r0
            r10 = 0
            monitor-enter(r9)     // Catch:{ all -> 0x0051 }
            r11 = 0
            r17.drainPendingModificationsForCompositionLocked()     // Catch:{ all -> 0x004a }
            r12 = r17
            r13 = 0
            androidx.compose.runtime.collection.IdentityArrayMap r0 = r12.takeInvalidations()     // Catch:{ all -> 0x004a }
            r14 = r0
            r0 = r14
            r15 = 0
            r16 = r4
            androidx.compose.runtime.ComposerImpl r4 = r1.composer     // Catch:{ Exception -> 0x0045 }
            r4.composeContent$runtime_release(r0, r2)     // Catch:{ Exception -> 0x0045 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0045 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0043 }
            monitor-exit(r9)     // Catch:{ all -> 0x004f }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004f }
            r4 = 0
            r7 = 1
            return
        L_0x0043:
            r0 = move-exception
            goto L_0x004d
        L_0x0045:
            r0 = move-exception
            r12.invalidations = r14     // Catch:{ all -> 0x0043 }
            throw r0     // Catch:{ all -> 0x0043 }
        L_0x004a:
            r0 = move-exception
            r16 = r4
        L_0x004d:
            monitor-exit(r9)     // Catch:{ all -> 0x004f }
            throw r0     // Catch:{ all -> 0x004f }
        L_0x004f:
            r0 = move-exception
            goto L_0x0054
        L_0x0051:
            r0 = move-exception
            r16 = r4
        L_0x0054:
            if (r7 != 0) goto L_0x006e
            java.util.HashSet<androidx.compose.runtime.RememberObserver> r4 = r5.abandonSet     // Catch:{ Exception -> 0x0070 }
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ Exception -> 0x0070 }
            boolean r4 = r4.isEmpty()     // Catch:{ Exception -> 0x0070 }
            r4 = r4 ^ 1
            if (r4 == 0) goto L_0x006e
            androidx.compose.runtime.CompositionImpl$RememberEventDispatcher r4 = new androidx.compose.runtime.CompositionImpl$RememberEventDispatcher     // Catch:{ Exception -> 0x0070 }
            java.util.HashSet<androidx.compose.runtime.RememberObserver> r8 = r5.abandonSet     // Catch:{ Exception -> 0x0070 }
            java.util.Set r8 = (java.util.Set) r8     // Catch:{ Exception -> 0x0070 }
            r4.<init>(r8)     // Catch:{ Exception -> 0x0070 }
            r4.dispatchAbandons()     // Catch:{ Exception -> 0x0070 }
        L_0x006e:
            throw r0     // Catch:{ Exception -> 0x0070 }
        L_0x0070:
            r0 = move-exception
            r3.abandonChanges()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.composeContent(kotlin.jvm.functions.Function2):void");
    }

    /* JADX INFO: finally extract failed */
    public void dispose() {
        synchronized (this.lock) {
            if (!this.disposed) {
                this.disposed = true;
                this.composable = ComposableSingletons$CompositionKt.INSTANCE.m2763getLambda2$runtime_release();
                List deferredChanges = this.composer.getDeferredChanges$runtime_release();
                if (deferredChanges != null) {
                    applyChangesInLocked(deferredChanges);
                }
                boolean nonEmptySlotTable = this.slotTable.getGroupsSize() > 0;
                if (nonEmptySlotTable || (true ^ this.abandonSet.isEmpty())) {
                    RememberEventDispatcher manager = new RememberEventDispatcher(this.abandonSet);
                    if (nonEmptySlotTable) {
                        SlotWriter writer$iv = this.slotTable.openWriter();
                        try {
                            ComposerKt.removeCurrentGroup(writer$iv, manager);
                            Unit unit = Unit.INSTANCE;
                            writer$iv.close();
                            this.applier.clear();
                            manager.dispatchRememberObservers();
                            manager.dispatchNodeCallbacks();
                        } catch (Throwable th) {
                            writer$iv.close();
                            throw th;
                        }
                    }
                    manager.dispatchAbandons();
                }
                this.composer.dispose$runtime_release();
            }
            Unit unit2 = Unit.INSTANCE;
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    public boolean getHasInvalidations() {
        boolean z;
        synchronized (this.lock) {
            z = this.invalidations.getSize$runtime_release() > 0;
        }
        return z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX WARNING: type inference failed for: r2v13, types: [java.util.Set[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void recordModificationsOf(java.util.Set<? extends java.lang.Object> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "values"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
        L_0x0006:
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r5.pendingModifications
            java.lang.Object r0 = r0.get()
            r1 = 1
            if (r0 != 0) goto L_0x0013
            r2 = r1
            goto L_0x001b
        L_0x0013:
            java.lang.Object r2 = androidx.compose.runtime.CompositionKt.PendingApplyNoModifications
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
        L_0x001b:
            if (r2 == 0) goto L_0x001f
            r2 = r6
            goto L_0x0040
        L_0x001f:
            boolean r2 = r0 instanceof java.util.Set
            if (r2 == 0) goto L_0x002f
            r2 = 2
            java.util.Set[] r2 = new java.util.Set[r2]
            r3 = 0
            r4 = r0
            java.util.Set r4 = (java.util.Set) r4
            r2[r3] = r4
            r2[r1] = r6
            goto L_0x0040
        L_0x002f:
            boolean r1 = r0 instanceof java.lang.Object[]
            if (r1 == 0) goto L_0x005d
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            r1 = r0
            java.util.Set[] r1 = (java.util.Set[]) r1
            java.lang.Object[] r2 = kotlin.collections.ArraysKt.plus((T[]) r1, r6)
        L_0x0040:
            r1 = r2
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r2 = r5.pendingModifications
            boolean r2 = androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(r2, r0, r1)
            if (r2 == 0) goto L_0x0006
            if (r0 != 0) goto L_0x005b
            java.lang.Object r2 = r5.lock
            r3 = 0
            monitor-enter(r2)
            r4 = 0
            r5.drainPendingModificationsLocked()     // Catch:{ all -> 0x0058 }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0058 }
            monitor-exit(r2)
            goto L_0x005b
        L_0x0058:
            r4 = move-exception
            monitor-exit(r2)
            throw r4
        L_0x005b:
            return
        L_0x005d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "corrupt pendingModifications: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r3 = r5.pendingModifications
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.recordModificationsOf(java.util.Set):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean observesAnyOf(java.util.Set<? extends java.lang.Object> r4) {
        /*
            r3 = this;
            java.lang.String r0 = "values"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.Iterator r0 = r4.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0026
            java.lang.Object r1 = r0.next()
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.RecomposeScopeImpl> r2 = r3.observations
            boolean r2 = r2.contains(r1)
            if (r2 != 0) goto L_0x0024
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.DerivedState<?>> r2 = r3.derivedStates
            boolean r2 = r2.contains(r1)
            if (r2 == 0) goto L_0x000a
        L_0x0024:
            r0 = 1
            return r0
        L_0x0026:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.observesAnyOf(java.util.Set):boolean");
    }

    public void prepareCompose(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.composer.prepareCompose$runtime_release(block);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c4, code lost:
        if (r5 == false) goto L_0x00cc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void addPendingInvalidationsLocked(java.util.Set<? extends java.lang.Object> r28, boolean r29) {
        /*
            r27 = this;
            r0 = r27
            r1 = r29
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            java.util.Iterator r3 = r28.iterator()
        L_0x000d:
            boolean r4 = r3.hasNext()
            r5 = 0
            if (r4 == 0) goto L_0x004e
            java.lang.Object r4 = r3.next()
            boolean r6 = r4 instanceof androidx.compose.runtime.RecomposeScopeImpl
            if (r6 == 0) goto L_0x0023
            r6 = r4
            androidx.compose.runtime.RecomposeScopeImpl r6 = (androidx.compose.runtime.RecomposeScopeImpl) r6
            r6.invalidateForResult(r5)
            goto L_0x000d
        L_0x0023:
            addPendingInvalidationsLocked$invalidate(r0, r1, r2, r4)
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.DerivedState<?>> r5 = r0.derivedStates
            r6 = 0
            int r7 = r5.find(r4)
            if (r7 < 0) goto L_0x004c
            androidx.compose.runtime.collection.IdentityArraySet r8 = r5.scopeSetAt(r7)
            r9 = 0
            r10 = 0
            int r11 = r8.size()
        L_0x003a:
            if (r10 >= r11) goto L_0x004b
            java.lang.Object r12 = r8.get(r10)
            androidx.compose.runtime.DerivedState r12 = (androidx.compose.runtime.DerivedState) r12
            r13 = 0
            addPendingInvalidationsLocked$invalidate(r0, r1, r2, r12)
            int r10 = r10 + 1
            goto L_0x003a
        L_0x004b:
        L_0x004c:
            goto L_0x000d
        L_0x004e:
            java.lang.String r3 = "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet"
            if (r1 == 0) goto L_0x0155
            java.util.HashSet<androidx.compose.runtime.RecomposeScopeImpl> r4 = r0.conditionallyInvalidatedScopes
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r6 = 1
            r4 = r4 ^ r6
            if (r4 == 0) goto L_0x0155
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.RecomposeScopeImpl> r4 = r0.observations
            r7 = 0
            r8 = r4
            r9 = 0
            r10 = 0
            r11 = 0
            int r12 = r8.getSize()
        L_0x006a:
            if (r11 >= r12) goto L_0x012b
            int[] r13 = r8.getValueOrder()
            r13 = r13[r11]
            androidx.compose.runtime.collection.IdentityArraySet[] r14 = r8.getScopeSets()
            r14 = r14[r13]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            r15 = r14
            r16 = 0
            r17 = r15
            r18 = 0
            r19 = 0
            r20 = 0
            int r5 = r17.size()
            r22 = r19
            r6 = r20
        L_0x008e:
            if (r6 >= r5) goto L_0x00e6
            java.lang.Object[] r20 = r17.getValues()
            r1 = r20[r6]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r3)
            r20 = r4
            r4 = r1
            androidx.compose.runtime.RecomposeScopeImpl r4 = (androidx.compose.runtime.RecomposeScopeImpl) r4
            r23 = 0
            r24 = r5
            java.util.HashSet<androidx.compose.runtime.RecomposeScopeImpl> r5 = r0.conditionallyInvalidatedScopes
            boolean r5 = r5.contains(r4)
            if (r5 != 0) goto L_0x00c7
            T r5 = r2.element
            java.util.HashSet r5 = (java.util.HashSet) r5
            r25 = 0
            if (r5 == 0) goto L_0x00bf
            r26 = 0
            boolean r5 = r5.contains(r4)
            r26 = r4
            r4 = 1
            if (r5 != r4) goto L_0x00c2
            r5 = r4
            goto L_0x00c4
        L_0x00bf:
            r26 = r4
            r4 = 1
        L_0x00c2:
            r5 = r25
        L_0x00c4:
            if (r5 == 0) goto L_0x00cc
            goto L_0x00ca
        L_0x00c7:
            r26 = r4
            r4 = 1
        L_0x00ca:
            r25 = r4
        L_0x00cc:
            if (r25 != 0) goto L_0x00db
            r5 = r22
            if (r5 == r6) goto L_0x00d8
            java.lang.Object[] r19 = r17.getValues()
            r19[r5] = r1
        L_0x00d8:
            int r22 = r5 + 1
            goto L_0x00dd
        L_0x00db:
            r5 = r22
        L_0x00dd:
            int r6 = r6 + 1
            r1 = r29
            r4 = r20
            r5 = r24
            goto L_0x008e
        L_0x00e6:
            r20 = r4
            r5 = r22
            r4 = 1
            r1 = r5
            int r6 = r17.size()
        L_0x00f0:
            if (r1 >= r6) goto L_0x00fd
            java.lang.Object[] r19 = r17.getValues()
            r21 = 0
            r19[r1] = r21
            int r1 = r1 + 1
            goto L_0x00f0
        L_0x00fd:
            r1 = r17
            r1.setSize(r5)
            int r1 = r14.size()
            if (r1 <= 0) goto L_0x0121
            if (r10 == r11) goto L_0x011f
            int[] r1 = r8.getValueOrder()
            r1 = r1[r10]
            int[] r5 = r8.getValueOrder()
            r5[r10] = r13
            int[] r5 = r8.getValueOrder()
            r5[r11] = r1
        L_0x011f:
            int r10 = r10 + 1
        L_0x0121:
            int r11 = r11 + 1
            r1 = r29
            r6 = r4
            r4 = r20
            r5 = 0
            goto L_0x006a
        L_0x012b:
            r20 = r4
            r1 = r10
            int r3 = r8.getSize()
        L_0x0132:
            if (r1 >= r3) goto L_0x0144
            java.lang.Object[] r4 = r8.getValues()
            int[] r5 = r8.getValueOrder()
            r5 = r5[r1]
            r6 = 0
            r4[r5] = r6
            int r1 = r1 + 1
            goto L_0x0132
        L_0x0144:
            r8.setSize(r10)
            r27.cleanUpDerivedStateObservations()
            java.util.HashSet<androidx.compose.runtime.RecomposeScopeImpl> r1 = r0.conditionallyInvalidatedScopes
            r1.clear()
            r20 = r2
            goto L_0x0225
        L_0x0155:
            T r1 = r2.element
            java.util.HashSet r1 = (java.util.HashSet) r1
            if (r1 == 0) goto L_0x0222
            r4 = 0
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.RecomposeScopeImpl> r5 = r0.observations
            r6 = 0
            r7 = r5
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r7.getSize()
        L_0x0167:
            if (r10 >= r11) goto L_0x01fd
            int[] r12 = r7.getValueOrder()
            r12 = r12[r10]
            androidx.compose.runtime.collection.IdentityArraySet[] r13 = r7.getScopeSets()
            r13 = r13[r12]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            r14 = r13
            r15 = 0
            r16 = r14
            r17 = 0
            r18 = 0
            r19 = 0
            int r0 = r16.size()
            r20 = r2
            r2 = r18
            r18 = r4
            r4 = r19
        L_0x018e:
            if (r4 >= r0) goto L_0x01b9
            java.lang.Object[] r19 = r16.getValues()
            r22 = r0
            r0 = r19[r4]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r3)
            r19 = r3
            r3 = r0
            androidx.compose.runtime.RecomposeScopeImpl r3 = (androidx.compose.runtime.RecomposeScopeImpl) r3
            r23 = 0
            boolean r3 = r1.contains(r3)
            if (r3 != 0) goto L_0x01b2
            if (r2 == r4) goto L_0x01b0
            java.lang.Object[] r3 = r16.getValues()
            r3[r2] = r0
        L_0x01b0:
            int r2 = r2 + 1
        L_0x01b2:
            int r4 = r4 + 1
            r3 = r19
            r0 = r22
            goto L_0x018e
        L_0x01b9:
            r19 = r3
            r0 = r2
            int r3 = r16.size()
        L_0x01c0:
            if (r0 >= r3) goto L_0x01cd
            java.lang.Object[] r4 = r16.getValues()
            r21 = 0
            r4[r0] = r21
            int r0 = r0 + 1
            goto L_0x01c0
        L_0x01cd:
            r0 = r16
            r0.setSize(r2)
            int r0 = r13.size()
            if (r0 <= 0) goto L_0x01f1
            if (r9 == r10) goto L_0x01ef
            int[] r0 = r7.getValueOrder()
            r0 = r0[r9]
            int[] r2 = r7.getValueOrder()
            r2[r9] = r12
            int[] r2 = r7.getValueOrder()
            r2[r10] = r0
        L_0x01ef:
            int r9 = r9 + 1
        L_0x01f1:
            int r10 = r10 + 1
            r0 = r27
            r4 = r18
            r3 = r19
            r2 = r20
            goto L_0x0167
        L_0x01fd:
            r20 = r2
            r18 = r4
            r0 = r9
            int r2 = r7.getSize()
        L_0x0206:
            if (r0 >= r2) goto L_0x0218
            java.lang.Object[] r3 = r7.getValues()
            int[] r4 = r7.getValueOrder()
            r4 = r4[r0]
            r10 = 0
            r3[r4] = r10
            int r0 = r0 + 1
            goto L_0x0206
        L_0x0218:
            r7.setSize(r9)
            r27.cleanUpDerivedStateObservations()
            goto L_0x0224
        L_0x0222:
            r20 = r2
        L_0x0224:
        L_0x0225:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.addPendingInvalidationsLocked(java.util.Set, boolean):void");
    }

    private static final void addPendingInvalidationsLocked$invalidate(CompositionImpl this$0, boolean $forgetConditionalScopes, Ref.ObjectRef<HashSet<RecomposeScopeImpl>> invalidated, Object value) {
        IdentityScopeMap this_$iv = this$0.observations;
        int index$iv = this_$iv.find(value);
        if (index$iv >= 0) {
            IdentityArraySet this_$iv$iv = this_$iv.scopeSetAt(index$iv);
            int size = this_$iv$iv.size();
            for (int i$iv$iv = 0; i$iv$iv < size; i$iv$iv++) {
                RecomposeScopeImpl scope = (RecomposeScopeImpl) this_$iv$iv.get(i$iv$iv);
                if (!this$0.observationsProcessed.remove(value, scope) && scope.invalidateForResult(value) != InvalidationResult.IGNORED) {
                    if (!scope.isConditional() || $forgetConditionalScopes) {
                        HashSet set = invalidated.element;
                        if (set == null) {
                            set = new HashSet();
                            invalidated.element = set;
                        }
                        set.add(scope);
                    } else {
                        this$0.conditionallyInvalidatedScopes.add(scope);
                    }
                }
            }
        }
    }

    private final void cleanUpDerivedStateObservations() {
        IdentityScopeMap this_$iv = this.derivedStates;
        int $i$f$removeValueIf = false;
        IdentityScopeMap this_$iv$iv = this_$iv;
        int $i$f$removingScopes = false;
        int destinationIndex$iv$iv = 0;
        int i$iv$iv = 0;
        int size = this_$iv$iv.getSize();
        while (i$iv$iv < size) {
            int valueIndex$iv$iv = this_$iv$iv.getValueOrder()[i$iv$iv];
            IdentityArraySet set$iv$iv = this_$iv$iv.getScopeSets()[valueIndex$iv$iv];
            Intrinsics.checkNotNull(set$iv$iv);
            IdentityArraySet this_$iv$iv2 = set$iv$iv;
            int destinationIndex$iv$iv2 = 0;
            int size2 = this_$iv$iv2.size();
            IdentityScopeMap this_$iv2 = this_$iv;
            int i$iv$iv2 = 0;
            while (i$iv$iv2 < size2) {
                int $i$f$removeValueIf2 = $i$f$removeValueIf;
                Object item$iv$iv = this_$iv$iv2.getValues()[i$iv$iv2];
                int $i$f$removingScopes2 = $i$f$removingScopes;
                Intrinsics.checkNotNull(item$iv$iv, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                int i = size;
                if (!(!this.observations.contains((DerivedState) item$iv$iv))) {
                    if (destinationIndex$iv$iv2 != i$iv$iv2) {
                        this_$iv$iv2.getValues()[destinationIndex$iv$iv2] = item$iv$iv;
                    }
                    destinationIndex$iv$iv2++;
                }
                i$iv$iv2++;
                $i$f$removingScopes = $i$f$removingScopes2;
                $i$f$removeValueIf = $i$f$removeValueIf2;
                size = i;
            }
            int $i$f$removeValueIf3 = $i$f$removeValueIf;
            int $i$f$removingScopes3 = $i$f$removingScopes;
            int i2 = size;
            int size3 = this_$iv$iv2.size();
            for (int i$iv$iv3 = destinationIndex$iv$iv2; i$iv$iv3 < size3; i$iv$iv3++) {
                this_$iv$iv2.getValues()[i$iv$iv3] = null;
            }
            this_$iv$iv2.setSize(destinationIndex$iv$iv2);
            if (set$iv$iv.size() > 0) {
                if (destinationIndex$iv$iv != i$iv$iv) {
                    int destinationKeyOrder$iv$iv = this_$iv$iv.getValueOrder()[destinationIndex$iv$iv];
                    this_$iv$iv.getValueOrder()[destinationIndex$iv$iv] = valueIndex$iv$iv;
                    this_$iv$iv.getValueOrder()[i$iv$iv] = destinationKeyOrder$iv$iv;
                }
                destinationIndex$iv$iv++;
            }
            i$iv$iv++;
            this_$iv = this_$iv2;
            $i$f$removingScopes = $i$f$removingScopes3;
            $i$f$removeValueIf = $i$f$removeValueIf3;
            size = i2;
        }
        int i3 = $i$f$removeValueIf;
        int i4 = $i$f$removingScopes;
        int size4 = this_$iv$iv.getSize();
        for (int i$iv$iv4 = destinationIndex$iv$iv; i$iv$iv4 < size4; i$iv$iv4++) {
            this_$iv$iv.getValues()[this_$iv$iv.getValueOrder()[i$iv$iv4]] = null;
        }
        this_$iv$iv.setSize(destinationIndex$iv$iv);
        Iterator iter$iv = this.conditionallyInvalidatedScopes.iterator();
        Intrinsics.checkNotNullExpressionValue(iter$iv, "iterator()");
        while (iter$iv.hasNext()) {
            if (!iter$iv.next().isConditional()) {
                iter$iv.remove();
            }
        }
    }

    public void recordReadOf(Object value) {
        RecomposeScopeImpl it;
        Intrinsics.checkNotNullParameter(value, "value");
        if (!getAreChildrenComposing() && (it = this.composer.getCurrentRecomposeScope$runtime_release()) != null) {
            it.setUsed(true);
            this.observations.add(value, it);
            if (value instanceof DerivedState) {
                this.derivedStates.removeScope(value);
                for (Object dependency : ((DerivedState) value).getDependencies()) {
                    if (dependency == null) {
                        break;
                    }
                    this.derivedStates.add(dependency, value);
                }
            }
            it.recordRead(value);
        }
    }

    private final void invalidateScopeOfLocked(Object value) {
        IdentityScopeMap this_$iv = this.observations;
        int index$iv = this_$iv.find(value);
        if (index$iv >= 0) {
            IdentityArraySet this_$iv$iv = this_$iv.scopeSetAt(index$iv);
            int size = this_$iv$iv.size();
            for (int i$iv$iv = 0; i$iv$iv < size; i$iv$iv++) {
                RecomposeScopeImpl scope = (RecomposeScopeImpl) this_$iv$iv.get(i$iv$iv);
                if (scope.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                    this.observationsProcessed.add(value, scope);
                }
            }
        }
    }

    public void recordWriteOf(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.lock) {
            invalidateScopeOfLocked(value);
            IdentityScopeMap this_$iv = this.derivedStates;
            int index$iv = this_$iv.find(value);
            if (index$iv >= 0) {
                IdentityArraySet this_$iv$iv = this_$iv.scopeSetAt(index$iv);
                int size = this_$iv$iv.size();
                for (int i$iv$iv = 0; i$iv$iv < size; i$iv$iv++) {
                    invalidateScopeOfLocked((DerivedState) this_$iv$iv.get(i$iv$iv));
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public boolean recompose() {
        IdentityArrayMap invalidations$iv;
        boolean shouldDrain;
        synchronized (this.lock) {
            drainPendingModificationsForCompositionLocked();
            try {
                invalidations$iv = takeInvalidations();
                shouldDrain = this.composer.recompose$runtime_release(invalidations$iv);
                if (!shouldDrain) {
                    drainPendingModificationsLocked();
                }
                boolean z = shouldDrain;
            } catch (Exception e$iv) {
                this.invalidations = invalidations$iv;
                throw e$iv;
            } catch (Throwable e$iv2) {
                if (0 == 0) {
                    try {
                        if (!this.abandonSet.isEmpty()) {
                            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                        }
                    } catch (Exception e$iv3) {
                        abandonChanges();
                        throw e$iv3;
                    }
                }
                throw e$iv2;
            }
        }
        return shouldDrain;
    }

    public void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        boolean z;
        Intrinsics.checkNotNullParameter(references, "references");
        List $this$fastForEach$iv$iv = references;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (true) {
            if (index$iv$iv >= size) {
                z = true;
                break;
            } else if (!Intrinsics.areEqual((Object) ((MovableContentStateReference) ((Pair) $this$fastForEach$iv$iv.get(index$iv$iv)).getFirst()).getComposition$runtime_release(), (Object) this)) {
                z = false;
                break;
            } else {
                index$iv$iv++;
            }
        }
        ComposerKt.runtimeCheck(z);
        try {
            this.composer.insertMovableContentReferences(references);
            Unit unit = Unit.INSTANCE;
        } catch (Exception e$iv) {
            abandonChanges();
            throw e$iv;
        } catch (Throwable th) {
            if (0 == 0) {
                if (true ^ this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
            }
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public void disposeUnusedMovableContent(MovableContentState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        RememberEventDispatcher manager = new RememberEventDispatcher(this.abandonSet);
        SlotWriter writer$iv = state.getSlotTable$runtime_release().openWriter();
        try {
            ComposerKt.removeCurrentGroup(writer$iv, manager);
            Unit unit = Unit.INSTANCE;
            writer$iv.close();
            manager.dispatchRememberObservers();
            manager.dispatchNodeCallbacks();
        } catch (Throwable th) {
            writer$iv.close();
            throw th;
        }
    }

    private final void applyChangesInLocked(List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes2) {
        String sectionName$iv;
        Object token$iv;
        RememberEventDispatcher manager = new RememberEventDispatcher(this.abandonSet);
        try {
            if (!changes2.isEmpty()) {
                String sectionName$iv2 = "Compose:applyChanges";
                Object token$iv2 = Trace.INSTANCE.beginSection(sectionName$iv2);
                try {
                    this.applier.onBeginChanges();
                    SlotWriter writer$iv = this.slotTable.openWriter();
                    SlotWriter slots = writer$iv;
                    try {
                        Applier applier2 = this.applier;
                        List $this$fastForEach$iv = changes2;
                        int index$iv = 0;
                        String str = sectionName$iv2;
                        try {
                            for (int size = $this$fastForEach$iv.size(); index$iv < size; size = size) {
                                $this$fastForEach$iv.get(index$iv).invoke(applier2, slots, manager);
                                index$iv++;
                            }
                            changes2.clear();
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th) {
                            th = th;
                            writer$iv.close();
                            throw th;
                        }
                        try {
                            writer$iv.close();
                            this.applier.onEndChanges();
                            Unit unit2 = Unit.INSTANCE;
                            Trace.INSTANCE.endSection(token$iv2);
                            manager.dispatchRememberObservers();
                            manager.dispatchNodeCallbacks();
                            manager.dispatchSideEffects();
                            if (this.pendingInvalidScopes) {
                                sectionName$iv = "Compose:unobserve";
                                int $i$f$trace = false;
                                token$iv = Trace.INSTANCE.beginSection(sectionName$iv);
                                int i = 0;
                                this.pendingInvalidScopes = false;
                                IdentityScopeMap this_$iv = this.observations;
                                IdentityScopeMap this_$iv$iv = this_$iv;
                                int destinationIndex$iv$iv = 0;
                                int i$iv$iv = 0;
                                int size2 = this_$iv$iv.getSize();
                                while (i$iv$iv < size2) {
                                    int valueIndex$iv$iv = this_$iv$iv.getValueOrder()[i$iv$iv];
                                    IdentityArraySet set$iv$iv = this_$iv$iv.getScopeSets()[valueIndex$iv$iv];
                                    Intrinsics.checkNotNull(set$iv$iv);
                                    IdentityArraySet this_$iv$iv2 = set$iv$iv;
                                    int size3 = this_$iv$iv2.size();
                                    int i2 = i;
                                    int destinationIndex$iv$iv2 = 0;
                                    String sectionName$iv3 = sectionName$iv;
                                    int i$iv$iv2 = 0;
                                    while (i$iv$iv2 < size3) {
                                        try {
                                            int $i$f$trace2 = $i$f$trace;
                                            Object item$iv$iv = this_$iv$iv2.getValues()[i$iv$iv2];
                                            IdentityScopeMap this_$iv2 = this_$iv;
                                            Intrinsics.checkNotNull(item$iv$iv, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                            if (!(!((RecomposeScopeImpl) item$iv$iv).getValid())) {
                                                if (destinationIndex$iv$iv2 != i$iv$iv2) {
                                                    this_$iv$iv2.getValues()[destinationIndex$iv$iv2] = item$iv$iv;
                                                }
                                                destinationIndex$iv$iv2++;
                                            }
                                            i$iv$iv2++;
                                            this_$iv = this_$iv2;
                                            $i$f$trace = $i$f$trace2;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            Trace.INSTANCE.endSection(token$iv);
                                            throw th;
                                        }
                                    }
                                    int $i$f$trace3 = $i$f$trace;
                                    IdentityScopeMap identityScopeMap = this_$iv;
                                    int size4 = this_$iv$iv2.size();
                                    for (int i$iv$iv3 = destinationIndex$iv$iv2; i$iv$iv3 < size4; i$iv$iv3++) {
                                        this_$iv$iv2.getValues()[i$iv$iv3] = null;
                                    }
                                    this_$iv$iv2.setSize(destinationIndex$iv$iv2);
                                    if (set$iv$iv.size() > 0) {
                                        if (destinationIndex$iv$iv != i$iv$iv) {
                                            int destinationKeyOrder$iv$iv = this_$iv$iv.getValueOrder()[destinationIndex$iv$iv];
                                            this_$iv$iv.getValueOrder()[destinationIndex$iv$iv] = valueIndex$iv$iv;
                                            this_$iv$iv.getValueOrder()[i$iv$iv] = destinationKeyOrder$iv$iv;
                                        }
                                        destinationIndex$iv$iv++;
                                    }
                                    i$iv$iv++;
                                    sectionName$iv = sectionName$iv3;
                                    this_$iv = identityScopeMap;
                                    i = i2;
                                    $i$f$trace = $i$f$trace3;
                                }
                                int i3 = i;
                                String str2 = sectionName$iv;
                                int i4 = $i$f$trace;
                                IdentityScopeMap identityScopeMap2 = this_$iv;
                                int size5 = this_$iv$iv.getSize();
                                for (int i$iv$iv4 = destinationIndex$iv$iv; i$iv$iv4 < size5; i$iv$iv4++) {
                                    this_$iv$iv.getValues()[this_$iv$iv.getValueOrder()[i$iv$iv4]] = null;
                                }
                                this_$iv$iv.setSize(destinationIndex$iv$iv);
                                cleanUpDerivedStateObservations();
                                Unit unit3 = Unit.INSTANCE;
                                Trace.INSTANCE.endSection(token$iv);
                            }
                            if (this.lateChanges.isEmpty()) {
                                manager.dispatchAbandons();
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        String str3 = sectionName$iv2;
                        writer$iv.close();
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    String str4 = sectionName$iv2;
                    Trace.INSTANCE.endSection(token$iv2);
                    throw th;
                }
            } else if (this.lateChanges.isEmpty()) {
                manager.dispatchAbandons();
            }
        } catch (Throwable th6) {
            if (this.lateChanges.isEmpty()) {
                manager.dispatchAbandons();
            }
            throw th6;
        }
    }

    public void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Exception e$iv) {
                abandonChanges();
                throw e$iv;
            } catch (Throwable th) {
                if (0 == 0) {
                    if (!this.abandonSet.isEmpty()) {
                        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                    }
                }
                throw th;
            }
        }
    }

    public void applyLateChanges() {
        synchronized (this.lock) {
            try {
                if (!this.lateChanges.isEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Exception e$iv) {
                abandonChanges();
                throw e$iv;
            } catch (Throwable th) {
                if (0 == 0) {
                    if (!this.abandonSet.isEmpty()) {
                        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                    }
                }
                throw th;
            }
        }
    }

    public void changesApplied() {
        synchronized (this.lock) {
            try {
                this.composer.changesApplied$runtime_release();
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Exception e$iv) {
                abandonChanges();
                throw e$iv;
            } catch (Throwable th) {
                if (0 == 0) {
                    if (!this.abandonSet.isEmpty()) {
                        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                    }
                }
                throw th;
            }
        }
    }

    private final <T> T guardInvalidationsLocked(Function1<? super IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>>, ? extends T> block) {
        IdentityArrayMap invalidations2 = takeInvalidations();
        try {
            return block.invoke(invalidations2);
        } catch (Exception e) {
            this.invalidations = invalidations2;
            throw e;
        }
    }

    private final <T> T guardChanges(Function0<? extends T> block) {
        try {
            T invoke = block.invoke();
            T t = invoke;
            InlineMarker.finallyStart(1);
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Exception e) {
            abandonChanges();
            throw e;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            if (0 == 0 && (!this.abandonSet.isEmpty())) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    private final void abandonChanges() {
        this.pendingModifications.set((Object) null);
        this.changes.clear();
        this.lateChanges.clear();
        this.abandonSet.clear();
    }

    public void invalidateAll() {
        synchronized (this.lock) {
            for (Object it : this.slotTable.getSlots()) {
                RecomposeScopeImpl recomposeScopeImpl = it instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) it : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.invalidate();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void verifyConsistent() {
        synchronized (this.lock) {
            if (!isComposing()) {
                this.composer.verifyConsistent$runtime_release();
                this.slotTable.verifyWellFormed();
                validateRecomposeScopeAnchors(this.slotTable);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public <R> R delegateInvalidations(ControlledComposition to, int groupIndex, Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (to == null || Intrinsics.areEqual((Object) to, (Object) this) || groupIndex < 0) {
            return block.invoke();
        }
        this.invalidationDelegate = (CompositionImpl) to;
        this.invalidationDelegateGroup = groupIndex;
        try {
            return block.invoke();
        } finally {
            this.invalidationDelegate = null;
            this.invalidationDelegateGroup = 0;
        }
    }

    public final InvalidationResult invalidate(RecomposeScopeImpl scope, Object instance) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (scope.getDefaultsInScope()) {
            scope.setDefaultsInvalid(true);
        }
        Anchor anchor = scope.getAnchor();
        if (anchor == null || !this.slotTable.ownsAnchor(anchor) || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (!anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (!scope.getCanRecompose()) {
            return InvalidationResult.IGNORED;
        }
        return invalidateChecked(scope, anchor, instance);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003f, code lost:
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0040, code lost:
        if (r0 == null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0046, code lost:
        return r0.invalidateChecked(r9, r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0047, code lost:
        r8.parent.invalidate$runtime_release(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0053, code lost:
        if (isComposing() == false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return androidx.compose.runtime.InvalidationResult.SCHEDULED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return androidx.compose.runtime.InvalidationResult.DEFERRED;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.InvalidationResult invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl r9, androidx.compose.runtime.Anchor r10, java.lang.Object r11) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.lock
            r1 = 0
            monitor-enter(r0)
            r2 = 0
            androidx.compose.runtime.CompositionImpl r3 = r8.invalidationDelegate     // Catch:{ all -> 0x005b }
            r4 = 0
            if (r3 == 0) goto L_0x001a
            r5 = 0
            androidx.compose.runtime.SlotTable r6 = r8.slotTable     // Catch:{ all -> 0x005b }
            int r7 = r8.invalidationDelegateGroup     // Catch:{ all -> 0x005b }
            boolean r6 = r6.groupContainsAnchor(r7, r10)     // Catch:{ all -> 0x005b }
            if (r6 == 0) goto L_0x0017
            r6 = r3
            goto L_0x0018
        L_0x0017:
            r6 = r4
        L_0x0018:
            goto L_0x001b
        L_0x001a:
            r6 = r4
        L_0x001b:
            r3 = r6
            if (r3 != 0) goto L_0x003d
            boolean r5 = r8.isComposing()     // Catch:{ all -> 0x005b }
            if (r5 == 0) goto L_0x0030
            androidx.compose.runtime.ComposerImpl r5 = r8.composer     // Catch:{ all -> 0x005b }
            boolean r5 = r5.tryImminentInvalidation$runtime_release(r9, r11)     // Catch:{ all -> 0x005b }
            if (r5 == 0) goto L_0x0030
            androidx.compose.runtime.InvalidationResult r4 = androidx.compose.runtime.InvalidationResult.IMMINENT     // Catch:{ all -> 0x005b }
            monitor-exit(r0)
            return r4
        L_0x0030:
            if (r11 != 0) goto L_0x0038
            androidx.compose.runtime.collection.IdentityArrayMap<androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object>> r5 = r8.invalidations     // Catch:{ all -> 0x005b }
            r5.set(r9, r4)     // Catch:{ all -> 0x005b }
            goto L_0x003d
        L_0x0038:
            androidx.compose.runtime.collection.IdentityArrayMap<androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object>> r4 = r8.invalidations     // Catch:{ all -> 0x005b }
            androidx.compose.runtime.CompositionKt.addValue(r4, r9, r11)     // Catch:{ all -> 0x005b }
        L_0x003d:
            monitor-exit(r0)
            r0 = r3
            if (r0 == 0) goto L_0x0047
            androidx.compose.runtime.InvalidationResult r1 = r0.invalidateChecked(r9, r10, r11)
            return r1
        L_0x0047:
            androidx.compose.runtime.CompositionContext r1 = r8.parent
            r2 = r8
            androidx.compose.runtime.ControlledComposition r2 = (androidx.compose.runtime.ControlledComposition) r2
            r1.invalidate$runtime_release(r2)
            boolean r1 = r8.isComposing()
            if (r1 == 0) goto L_0x0058
            androidx.compose.runtime.InvalidationResult r1 = androidx.compose.runtime.InvalidationResult.DEFERRED
            goto L_0x005a
        L_0x0058:
            androidx.compose.runtime.InvalidationResult r1 = androidx.compose.runtime.InvalidationResult.SCHEDULED
        L_0x005a:
            return r1
        L_0x005b:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.Anchor, java.lang.Object):androidx.compose.runtime.InvalidationResult");
    }

    public final void removeObservation$runtime_release(Object instance, RecomposeScopeImpl scope) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.observations.remove(instance, scope);
    }

    public final void removeDerivedStateObservation$runtime_release(DerivedState<?> state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (!this.observations.contains(state)) {
            this.derivedStates.removeScope(state);
        }
    }

    private final IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations() {
        IdentityArrayMap invalidations2 = this.invalidations;
        this.invalidations = new IdentityArrayMap<>(0, 1, (DefaultConstructorMarker) null);
        return invalidations2;
    }

    private final void validateRecomposeScopeAnchors(SlotTable slotTable2) {
        SlotTable slotTable3 = slotTable2;
        Object[] $this$mapNotNull$iv = slotTable2.getSlots();
        Collection destination$iv$iv = new ArrayList();
        for (Object it : $this$mapNotNull$iv) {
            Object it$iv$iv = it instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) it : null;
            if (it$iv$iv != null) {
                destination$iv$iv.add(it$iv$iv);
            }
        }
        List $this$fastForEach$iv = (List) destination$iv$iv;
        int index$iv = 0;
        int size = $this$fastForEach$iv.size();
        while (index$iv < size) {
            RecomposeScopeImpl scope = (RecomposeScopeImpl) $this$fastForEach$iv.get(index$iv);
            Anchor anchor = scope.getAnchor();
            if (anchor == null || slotTable3.slotsOf$runtime_release(anchor.toIndexFor(slotTable3)).contains(scope)) {
                index$iv++;
            } else {
                throw new IllegalStateException(("Misaligned anchor " + anchor + " in scope " + scope + " encountered, scope found at " + ArraysKt.indexOf((T[]) slotTable2.getSlots(), scope)).toString());
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private final <T> T trackAbandonedValues(Function0<? extends T> block) {
        try {
            T invoke = block.invoke();
            T t = invoke;
            InlineMarker.finallyStart(1);
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            if (0 == 0 && (!this.abandonSet.isEmpty())) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eJ\u0010\u0010\t\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0016\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/CompositionImpl$RememberEventDispatcher;", "Landroidx/compose/runtime/RememberManager;", "abandoning", "", "Landroidx/compose/runtime/RememberObserver;", "(Ljava/util/Set;)V", "deactivating", "", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "forgetting", "releasing", "remembering", "sideEffects", "Lkotlin/Function0;", "", "instance", "dispatchAbandons", "dispatchNodeCallbacks", "dispatchRememberObservers", "dispatchSideEffects", "sideEffect", "effect", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Composition.kt */
    private static final class RememberEventDispatcher implements RememberManager {
        private final Set<RememberObserver> abandoning;
        private List<ComposeNodeLifecycleCallback> deactivating;
        private final List<RememberObserver> forgetting = new ArrayList();
        private List<ComposeNodeLifecycleCallback> releasing;
        private final List<RememberObserver> remembering = new ArrayList();
        private final List<Function0<Unit>> sideEffects = new ArrayList();

        public RememberEventDispatcher(Set<RememberObserver> abandoning2) {
            Intrinsics.checkNotNullParameter(abandoning2, "abandoning");
            this.abandoning = abandoning2;
        }

        public void remembering(RememberObserver instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            int index = this.forgetting.lastIndexOf(instance);
            if (index >= 0) {
                this.forgetting.remove(index);
                this.abandoning.remove(instance);
                return;
            }
            this.remembering.add(instance);
        }

        public void forgetting(RememberObserver instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            int index = this.remembering.lastIndexOf(instance);
            if (index >= 0) {
                this.remembering.remove(index);
                this.abandoning.remove(instance);
                return;
            }
            this.forgetting.add(instance);
        }

        public void sideEffect(Function0<Unit> effect) {
            Intrinsics.checkNotNullParameter(effect, "effect");
            this.sideEffects.add(effect);
        }

        public void deactivating(ComposeNodeLifecycleCallback instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            List it = this.deactivating;
            if (it == null) {
                it = new ArrayList();
                this.deactivating = it;
            }
            it.add(instance);
        }

        public void releasing(ComposeNodeLifecycleCallback instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            List it = this.releasing;
            if (it == null) {
                it = new ArrayList();
                this.releasing = it;
            }
            it.add(instance);
        }

        public final void dispatchRememberObservers() {
            if (!this.forgetting.isEmpty()) {
                Object token$iv = Trace.INSTANCE.beginSection("Compose:onForgotten");
                try {
                    for (int i = this.forgetting.size() - 1; -1 < i; i--) {
                        RememberObserver instance = this.forgetting.get(i);
                        if (!this.abandoning.contains(instance)) {
                            instance.onForgotten();
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(token$iv);
                }
            }
            if (!this.remembering.isEmpty()) {
                Object token$iv2 = Trace.INSTANCE.beginSection("Compose:onRemembered");
                try {
                    List $this$fastForEach$iv = this.remembering;
                    int size = $this$fastForEach$iv.size();
                    for (int index$iv = 0; index$iv < size; index$iv++) {
                        RememberObserver instance2 = $this$fastForEach$iv.get(index$iv);
                        this.abandoning.remove(instance2);
                        instance2.onRemembered();
                    }
                    Unit unit2 = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(token$iv2);
                }
            }
        }

        public final void dispatchSideEffects() {
            if (!this.sideEffects.isEmpty()) {
                Object token$iv = Trace.INSTANCE.beginSection("Compose:sideeffects");
                try {
                    List $this$fastForEach$iv = this.sideEffects;
                    int size = $this$fastForEach$iv.size();
                    for (int index$iv = 0; index$iv < size; index$iv++) {
                        $this$fastForEach$iv.get(index$iv).invoke();
                    }
                    this.sideEffects.clear();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(token$iv);
                }
            }
        }

        public final void dispatchAbandons() {
            if (!this.abandoning.isEmpty()) {
                Object token$iv = Trace.INSTANCE.beginSection("Compose:abandons");
                try {
                    Iterator iterator = this.abandoning.iterator();
                    while (iterator.hasNext()) {
                        iterator.remove();
                        iterator.next().onAbandoned();
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(token$iv);
                }
            }
        }

        /* JADX INFO: finally extract failed */
        public final void dispatchNodeCallbacks() {
            List<ComposeNodeLifecycleCallback> list = this.deactivating;
            Collection collection = list;
            boolean z = false;
            if (!(collection == null || collection.isEmpty())) {
                Object token$iv = Trace.INSTANCE.beginSection("Compose:deactivations");
                try {
                    for (int i = list.size() - 1; -1 < i; i--) {
                        list.get(i).onDeactivate();
                    }
                    Unit unit = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(token$iv);
                    list.clear();
                } catch (Throwable th) {
                    Trace.INSTANCE.endSection(token$iv);
                    throw th;
                }
            }
            List<ComposeNodeLifecycleCallback> list2 = this.releasing;
            Collection collection2 = list2;
            if (collection2 == null || collection2.isEmpty()) {
                z = true;
            }
            if (!z) {
                Object token$iv2 = Trace.INSTANCE.beginSection("Compose:releases");
                try {
                    for (int i2 = list2.size() - 1; -1 < i2; i2--) {
                        list2.get(i2).onRelease();
                    }
                    Unit unit2 = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(token$iv2);
                    list2.clear();
                } catch (Throwable th2) {
                    Trace.INSTANCE.endSection(token$iv2);
                    throw th2;
                }
            }
        }
    }
}
