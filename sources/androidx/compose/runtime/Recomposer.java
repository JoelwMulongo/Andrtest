package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.tooling.CompositionData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 ¦\u00012\u00020\u0001:\n¦\u0001§\u0001¨\u0001©\u0001ª\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020QH\u0002J\u0006\u0010R\u001a\u00020SJ\u0011\u0010T\u001a\u00020NH@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u0011\u0010V\u001a\u00020NH@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u0006\u0010W\u001a\u00020NJ\u0006\u0010X\u001a\u00020NJ*\u0010Y\u001a\u00020N2\u0006\u0010Z\u001a\u00020\u00172\u0011\u0010[\u001a\r\u0012\u0004\u0012\u00020N0\\¢\u0006\u0002\b]H\u0010¢\u0006\u0004\b^\u0010_J:\u0010`\u001a\u0002Ha\"\u0004\b\u0000\u0010a2\u0006\u0010Z\u001a\u00020\u00172\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010c2\f\u0010d\u001a\b\u0012\u0004\u0012\u0002Ha0\\H\b¢\u0006\u0002\u0010eJ\u0015\u0010f\u001a\u00020N2\u0006\u0010g\u001a\u00020\u001aH\u0010¢\u0006\u0002\bhJ\u0010\u0010i\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010MH\u0002J\b\u0010j\u001a\u00020NH\u0002J\u0015\u0010k\u001a\u00020N2\u0006\u0010g\u001a\u00020\u001aH\u0010¢\u0006\u0002\blJ\u0015\u0010m\u001a\u00020N2\u0006\u0010Z\u001a\u00020\u0017H\u0010¢\u0006\u0002\bnJ\u0015\u0010o\u001a\u00020N2\u0006\u0010p\u001a\u00020qH\u0010¢\u0006\u0002\brJ\u0011\u0010s\u001a\u00020NH@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u001d\u0010t\u001a\u00020N2\u0006\u0010g\u001a\u00020\u001a2\u0006\u0010u\u001a\u00020\u001bH\u0010¢\u0006\u0002\bvJ\u0017\u0010w\u001a\u0004\u0018\u00010\u001b2\u0006\u0010g\u001a\u00020\u001aH\u0010¢\u0006\u0002\bxJ\u0010\u0010y\u001a\u00020N2\u0006\u0010Z\u001a\u00020\u0017H\u0002J,\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00170{2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020\u001a0{2\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010cH\u0002J\"\u0010}\u001a\u0004\u0018\u00010\u00172\u0006\u0010Z\u001a\u00020\u00172\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010cH\u0002J.\u0010~\u001a\u00020N2\f\u0010\u001a\b0\u0001j\u0003`\u00012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00172\t\b\u0002\u0010\u0001\u001a\u00020\u0012H\u0002J\u001e\u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020N0\u00012\u0006\u0010Z\u001a\u00020\u0017H\u0002JY\u0010\u0001\u001a\u00020N2D\u0010d\u001a@\b\u0001\u0012\u0005\u0012\u00030\u0001\u0012\u0017\u0012\u00150\u0001¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020N0\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0001¢\u0006\u0003\b\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020NH\u0002J \u0010\u0001\u001a\u00020N2\u0014\u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020N0\u0001H\bJ\u001f\u0010\u0001\u001a\u00020N2\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010DH\u0010¢\u0006\u0003\b\u0001J\u0017\u0010\u0001\u001a\u00020N2\u0006\u0010Z\u001a\u00020\u0017H\u0010¢\u0006\u0003\b\u0001J\u0012\u0010\u0001\u001a\u00020N2\u0007\u0010\u0001\u001a\u00020@H\u0002J\u000b\u0010\u0001\u001a\u0004\u0018\u00010/H\u0002J\t\u0010\u0001\u001a\u00020NH\u0002J'\u0010\u0001\u001a\u00020N2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u0012\u0010 \u0001\u001a\u00020NH@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u001b\u0010¡\u0001\u001a\u00020N2\u0006\u0010;\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0003\u0010¢\u0001J\u0017\u0010£\u0001\u001a\u00020N2\u0006\u0010Z\u001a\u00020\u0017H\u0010¢\u0006\u0003\b¤\u0001J.\u0010¥\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020N0\u00012\u0006\u0010Z\u001a\u00020\u00172\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010cH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128PX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016X\u0004¢\u0006\u0002\n\u0000R(\u0010\u001d\u001a\u001c\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00160\u0019X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\"8PX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070'8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0016\u00100\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0014R\u0014\u00103\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0014R\u0011\u00105\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b6\u0010\u0014R\u0014\u00107\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0014R\u000e\u00109\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u00020\u00038PX\u0004¢\u0006\u0006\u001a\u0004\b<\u0010+R\u0012\u0010=\u001a\u00060>R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u0014R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001f0DX\u000e¢\u0006\u0002\n\u0000R \u0010E\u001a\b\u0012\u0004\u0012\u00020\u00070F8FX\u0004¢\u0006\f\u0012\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u000e\u0010K\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010L\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010MX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006«\u0001"}, d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$State;", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "<set-?>", "", "changeCount", "getChangeCount", "()J", "closeCause", "", "collectingParameterInformation", "", "getCollectingParameterInformation$runtime_release", "()Z", "compositionInvalidations", "", "Landroidx/compose/runtime/ControlledComposition;", "compositionValueStatesAvailable", "", "Landroidx/compose/runtime/MovableContentStateReference;", "Landroidx/compose/runtime/MovableContentState;", "compositionValuesAwaitingInsert", "compositionValuesRemoved", "Landroidx/compose/runtime/MovableContent;", "", "compositionsAwaitingApply", "compoundHashKey", "", "getCompoundHashKey$runtime_release", "()I", "concurrentCompositionsOutstanding", "currentState", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentState", "()Lkotlinx/coroutines/flow/StateFlow;", "getEffectCoroutineContext$runtime_release", "()Lkotlin/coroutines/CoroutineContext;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "errorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "failedCompositions", "hasConcurrentFrameWorkLocked", "getHasConcurrentFrameWorkLocked", "hasFrameWorkLocked", "getHasFrameWorkLocked", "hasPendingWork", "getHasPendingWork", "hasSchedulingWork", "getHasSchedulingWork", "isClosed", "knownCompositions", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "runnerJob", "Lkotlinx/coroutines/Job;", "shouldKeepRecomposing", "getShouldKeepRecomposing", "snapshotInvalidations", "", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "()V", "getState", "()Lkotlinx/coroutines/flow/Flow;", "stateLock", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "applyAndCheck", "snapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "asRecomposerInfo", "Landroidx/compose/runtime/RecomposerInfo;", "awaitIdle", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitWorkAvailable", "cancel", "close", "composeInitial", "composition", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composing", "T", "modifiedValues", "Landroidx/compose/runtime/collection/IdentityArraySet;", "block", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/collection/IdentityArraySet;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "deletedMovableContent", "reference", "deletedMovableContent$runtime_release", "deriveStateLocked", "discardUnusedValues", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "join", "movableContentStateReleased", "data", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "performInitialMovableContentInserts", "performInsertValues", "", "references", "performRecompose", "processCompositionError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "failedInitialComposition", "recoverable", "readObserverOf", "Lkotlin/Function1;", "recompositionRunner", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/ParameterName;", "name", "parentFrameClock", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordComposerModificationsLocked", "onEachInvalidComposition", "recordInspectionTable", "table", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime_release", "registerComposition", "registerComposition$runtime_release", "registerRunnerJob", "callingJob", "resetErrorState", "retryFailedCompositions", "runFrameLoop", "frameSignal", "Landroidx/compose/runtime/ProduceFrameSignal;", "(Landroidx/compose/runtime/MonotonicFrameClock;Landroidx/compose/runtime/ProduceFrameSignal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runRecomposeAndApplyChanges", "runRecomposeConcurrentlyAndApplyChanges", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterComposition", "unregisterComposition$runtime_release", "writeObserverOf", "Companion", "HotReloadable", "RecomposerErrorState", "RecomposerInfoImpl", "State", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Recomposer.kt */
public final class Recomposer extends CompositionContext {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AtomicReference<Boolean> _hotReloadEnabled = new AtomicReference<>(false);
    /* access modifiers changed from: private */
    public static final MutableStateFlow<PersistentSet<RecomposerInfoImpl>> _runningRecomposers = StateFlowKt.MutableStateFlow(ExtensionsKt.persistentSetOf());
    /* access modifiers changed from: private */
    public final MutableStateFlow<State> _state = StateFlowKt.MutableStateFlow(State.Inactive);
    /* access modifiers changed from: private */
    public final BroadcastFrameClock broadcastFrameClock;
    /* access modifiers changed from: private */
    public long changeCount;
    /* access modifiers changed from: private */
    public Throwable closeCause;
    /* access modifiers changed from: private */
    public final List<ControlledComposition> compositionInvalidations = new ArrayList();
    private final Map<MovableContentStateReference, MovableContentState> compositionValueStatesAvailable = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final List<MovableContentStateReference> compositionValuesAwaitingInsert = new ArrayList();
    private final Map<MovableContent<Object>, List<MovableContentStateReference>> compositionValuesRemoved = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final List<ControlledComposition> compositionsAwaitingApply = new ArrayList();
    /* access modifiers changed from: private */
    public int concurrentCompositionsOutstanding;
    private final CoroutineContext effectCoroutineContext;
    private final CompletableJob effectJob;
    /* access modifiers changed from: private */
    public RecomposerErrorState errorState;
    private List<ControlledComposition> failedCompositions;
    /* access modifiers changed from: private */
    public boolean isClosed;
    /* access modifiers changed from: private */
    public final List<ControlledComposition> knownCompositions = new ArrayList();
    /* access modifiers changed from: private */
    public final RecomposerInfoImpl recomposerInfo;
    /* access modifiers changed from: private */
    public Job runnerJob;
    /* access modifiers changed from: private */
    public Set<Object> snapshotInvalidations = new LinkedHashSet();
    /* access modifiers changed from: private */
    public final Object stateLock = new Object();
    /* access modifiers changed from: private */
    public CancellableContinuation<? super Unit> workContinuation;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Recomposer.kt */
    public enum State {
        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork
    }

    @Deprecated(message = "Replaced by currentState as a StateFlow", replaceWith = @ReplaceWith(expression = "currentState", imports = {}))
    public static /* synthetic */ void getState$annotations() {
    }

    public Recomposer(CoroutineContext effectCoroutineContext2) {
        Intrinsics.checkNotNullParameter(effectCoroutineContext2, "effectCoroutineContext");
        BroadcastFrameClock broadcastFrameClock2 = new BroadcastFrameClock(new Recomposer$broadcastFrameClock$1(this));
        this.broadcastFrameClock = broadcastFrameClock2;
        CompletableJob $this$effectJob_u24lambda_u240 = JobKt.Job((Job) effectCoroutineContext2.get(Job.Key));
        $this$effectJob_u24lambda_u240.invokeOnCompletion(new Recomposer$effectJob$1$1(this));
        this.effectJob = $this$effectJob_u24lambda_u240;
        this.effectCoroutineContext = effectCoroutineContext2.plus(broadcastFrameClock2).plus($this$effectJob_u24lambda_u240);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    public CoroutineContext getEffectCoroutineContext$runtime_release() {
        return this.effectCoroutineContext;
    }

    public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
        return EmptyCoroutineContext.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final CancellableContinuation<Unit> deriveStateLocked() {
        State newState;
        if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
            this.knownCompositions.clear();
            this.snapshotInvalidations = new LinkedHashSet();
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.compositionValuesAwaitingInsert.clear();
            this.failedCompositions = null;
            CancellableContinuation<? super Unit> cancellableContinuation = this.workContinuation;
            if (cancellableContinuation != null) {
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, (Throwable) null, 1, (Object) null);
            }
            this.workContinuation = null;
            this.errorState = null;
            return null;
        }
        if (this.errorState != null) {
            newState = State.Inactive;
        } else if (this.runnerJob == null) {
            this.snapshotInvalidations = new LinkedHashSet();
            this.compositionInvalidations.clear();
            newState = this.broadcastFrameClock.getHasAwaiters() ? State.InactivePendingWork : State.Inactive;
        } else if ((!this.compositionInvalidations.isEmpty()) || (!this.snapshotInvalidations.isEmpty()) || (!this.compositionsAwaitingApply.isEmpty()) || (!this.compositionValuesAwaitingInsert.isEmpty()) || this.concurrentCompositionsOutstanding > 0 || this.broadcastFrameClock.getHasAwaiters()) {
            newState = State.PendingWork;
        } else {
            newState = State.Idle;
        }
        this._state.setValue(newState);
        if (newState != State.PendingWork) {
            return null;
        }
        CancellableContinuation<? super Unit> cancellableContinuation2 = this.workContinuation;
        CancellableContinuation<? super Unit> cancellableContinuation3 = cancellableContinuation2;
        this.workContinuation = null;
        return cancellableContinuation2;
    }

    /* access modifiers changed from: private */
    public final boolean getShouldKeepRecomposing() {
        boolean z;
        Sequence $this$any$iv;
        synchronized (this.stateLock) {
            z = !this.isClosed;
        }
        if (z) {
            return true;
        }
        Iterator<Job> it = this.effectJob.getChildren().iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().isActive()) {
                    $this$any$iv = 1;
                    break;
                }
            } else {
                $this$any$iv = null;
                break;
            }
        }
        if ($this$any$iv != null) {
            return true;
        }
        return false;
    }

    public final Flow<State> getState() {
        return getCurrentState();
    }

    public final StateFlow<State> getCurrentState() {
        return this._state;
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001a\u001a\u00020\u0015J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", "(Landroidx/compose/runtime/Recomposer;)V", "changeCount", "", "getChangeCount", "()J", "currentError", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentError", "()Landroidx/compose/runtime/RecomposerErrorInfo;", "hasPendingWork", "", "getHasPendingWork", "()Z", "state", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "invalidateGroupsWithKey", "", "key", "", "resetErrorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "retryFailedCompositions", "saveStateAndDisposeForHotReload", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Recomposer.kt */
    private final class RecomposerInfoImpl implements RecomposerInfo {
        public RecomposerInfoImpl() {
        }

        public Flow<State> getState() {
            return Recomposer.this.getCurrentState();
        }

        public boolean getHasPendingWork() {
            return Recomposer.this.getHasPendingWork();
        }

        public long getChangeCount() {
            return Recomposer.this.getChangeCount();
        }

        public final RecomposerErrorInfo getCurrentError() {
            RecomposerErrorState access$getErrorState$p;
            Object lock$iv = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (lock$iv) {
                access$getErrorState$p = recomposer.errorState;
            }
            return access$getErrorState$p;
        }

        public final void invalidateGroupsWithKey(int key) {
            List $this$fastMapNotNull$iv;
            Object lock$iv = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (lock$iv) {
                $this$fastMapNotNull$iv = CollectionsKt.toMutableList(recomposer.knownCompositions);
            }
            Object lock$iv2 = $this$fastMapNotNull$iv;
            List target$iv = new ArrayList($this$fastMapNotNull$iv.size());
            List $this$fastForEach$iv$iv = $this$fastMapNotNull$iv;
            int size = $this$fastForEach$iv$iv.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                Object it = (ControlledComposition) $this$fastForEach$iv$iv.get(index$iv$iv);
                Object it$iv = it instanceof CompositionImpl ? (CompositionImpl) it : null;
                if (it$iv != null) {
                    target$iv.add(it$iv);
                }
            }
            List $this$fastForEach$iv = target$iv;
            int size2 = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size2; index$iv++) {
                ((CompositionImpl) $this$fastForEach$iv.get(index$iv)).invalidateGroupsWithKey(key);
            }
        }

        public final List<HotReloadable> saveStateAndDisposeForHotReload() {
            List compositions;
            Object lock$iv = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (lock$iv) {
                compositions = CollectionsKt.toMutableList(recomposer.knownCompositions);
            }
            List $this$fastMapNotNull$iv = compositions;
            List target$iv = new ArrayList($this$fastMapNotNull$iv.size());
            List $this$fastForEach$iv$iv = $this$fastMapNotNull$iv;
            int size = $this$fastForEach$iv$iv.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                Object it = (ControlledComposition) $this$fastForEach$iv$iv.get(index$iv$iv);
                Object it$iv = it instanceof CompositionImpl ? (CompositionImpl) it : null;
                if (it$iv != null) {
                    target$iv.add(it$iv);
                }
            }
            List $this$fastMapNotNull$iv2 = target$iv;
            List target$iv2 = new ArrayList($this$fastMapNotNull$iv2.size());
            List $this$fastForEach$iv$iv2 = $this$fastMapNotNull$iv2;
            int size2 = $this$fastForEach$iv$iv2.size();
            for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                HotReloadable $this$saveStateAndDisposeForHotReload_u24lambda_u247_u24lambda_u246 = new HotReloadable((CompositionImpl) $this$fastForEach$iv$iv2.get(index$iv$iv2));
                $this$saveStateAndDisposeForHotReload_u24lambda_u247_u24lambda_u246.clearContent();
                target$iv2.add($this$saveStateAndDisposeForHotReload_u24lambda_u247_u24lambda_u246);
            }
            return target$iv2;
        }

        public final RecomposerErrorState resetErrorState() {
            return Recomposer.this.resetErrorState();
        }

        public final void retryFailedCompositions() {
            Recomposer.this.retryFailedCompositions();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007R\u001b\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/Recomposer$HotReloadable;", "", "composition", "Landroidx/compose/runtime/CompositionImpl;", "(Landroidx/compose/runtime/CompositionImpl;)V", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "clearContent", "recompose", "resetContent", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Recomposer.kt */
    private static final class HotReloadable {
        private Function2<? super Composer, ? super Integer, Unit> composable;
        private final CompositionImpl composition;

        public HotReloadable(CompositionImpl composition2) {
            Intrinsics.checkNotNullParameter(composition2, "composition");
            this.composition = composition2;
            this.composable = composition2.getComposable();
        }

        public final void clearContent() {
            if (this.composition.isRoot()) {
                this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.m2764getLambda1$runtime_release());
            }
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }

        public final void recompose() {
            if (this.composition.isRoot()) {
                this.composition.setContent(this.composable);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "Landroidx/compose/runtime/RecomposerErrorInfo;", "recoverable", "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(ZLjava/lang/Exception;)V", "getCause", "()Ljava/lang/Exception;", "getRecoverable", "()Z", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Recomposer.kt */
    private static final class RecomposerErrorState implements RecomposerErrorInfo {
        private final Exception cause;
        private final boolean recoverable;

        public RecomposerErrorState(boolean recoverable2, Exception cause2) {
            Intrinsics.checkNotNullParameter(cause2, "cause");
            this.recoverable = recoverable2;
            this.cause = cause2;
        }

        public boolean getRecoverable() {
            return this.recoverable;
        }

        public Exception getCause() {
            return this.cause;
        }
    }

    public final RecomposerInfo asRecomposerInfo() {
        return this.recomposerInfo;
    }

    /* access modifiers changed from: private */
    public final void recordComposerModificationsLocked() {
        Set<Object> set = this.snapshotInvalidations;
        if (!set.isEmpty()) {
            Recomposer $this$recordComposerModificationsLocked_u24lambda_u245 = this;
            List $this$fastForEach$iv = $this$recordComposerModificationsLocked_u24lambda_u245.knownCompositions;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                $this$fastForEach$iv.get(index$iv).recordModificationsOf(set);
                if ($this$recordComposerModificationsLocked_u24lambda_u245._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                    break;
                }
            }
            this.snapshotInvalidations = new LinkedHashSet();
            if (deriveStateLocked() != null) {
                throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
            }
        }
    }

    private final void recordComposerModificationsLocked(Function1<? super ControlledComposition, Unit> onEachInvalidComposition) {
        Set changes = this.snapshotInvalidations;
        if (!changes.isEmpty()) {
            List $this$fastForEach$iv = this.knownCompositions;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                ((ControlledComposition) $this$fastForEach$iv.get(index$iv)).recordModificationsOf(changes);
            }
            this.snapshotInvalidations = new LinkedHashSet();
        }
        List $this$fastForEach$iv2 = this.compositionInvalidations;
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            onEachInvalidComposition.invoke($this$fastForEach$iv2.get(index$iv2));
        }
        this.compositionInvalidations.clear();
        if (deriveStateLocked() != null) {
            throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
        }
    }

    /* access modifiers changed from: private */
    public final void registerRunnerJob(Job callingJob) {
        synchronized (this.stateLock) {
            Throwable it = this.closeCause;
            if (it != null) {
                throw it;
            } else if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down".toString());
            } else if (this.runnerJob == null) {
                this.runnerJob = callingJob;
                deriveStateLocked();
            } else {
                throw new IllegalStateException("Recomposer already running".toString());
            }
        }
    }

    public final Object runRecomposeAndApplyChanges(Continuation<? super Unit> $completion) {
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeAndApplyChanges$2(this, (Continuation<? super Recomposer$runRecomposeAndApplyChanges$2>) null), $completion);
        return recompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? recompositionRunner : Unit.INSTANCE;
    }

    static /* synthetic */ void processCompositionError$default(Recomposer recomposer, Exception exc, ControlledComposition controlledComposition, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            controlledComposition = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        recomposer.processCompositionError(exc, controlledComposition, z);
    }

    private final void processCompositionError(Exception e, ControlledComposition failedInitialComposition, boolean recoverable) {
        Boolean bool = _hotReloadEnabled.get();
        Intrinsics.checkNotNullExpressionValue(bool, "_hotReloadEnabled.get()");
        if (!bool.booleanValue() || (e instanceof ComposeRuntimeError)) {
            throw e;
        }
        synchronized (this.stateLock) {
            ActualAndroid_androidKt.logError("Error was captured in composition while live edit was enabled.", e);
            this.compositionsAwaitingApply.clear();
            this.compositionInvalidations.clear();
            this.snapshotInvalidations = new LinkedHashSet();
            this.compositionValuesAwaitingInsert.clear();
            this.compositionValuesRemoved.clear();
            this.compositionValueStatesAvailable.clear();
            this.errorState = new RecomposerErrorState(recoverable, e);
            if (failedInitialComposition != null) {
                List failedCompositions2 = this.failedCompositions;
                if (failedCompositions2 == null) {
                    failedCompositions2 = new ArrayList();
                    this.failedCompositions = failedCompositions2;
                }
                if (!failedCompositions2.contains(failedInitialComposition)) {
                    failedCompositions2.add(failedInitialComposition);
                }
                this.knownCompositions.remove(failedInitialComposition);
            }
            deriveStateLocked();
        }
    }

    /* access modifiers changed from: private */
    public final RecomposerErrorState resetErrorState() {
        RecomposerErrorState error;
        synchronized (this.stateLock) {
            error = this.errorState;
            if (error != null) {
                this.errorState = null;
                deriveStateLocked();
            }
        }
        return error;
    }

    /* access modifiers changed from: private */
    public final void retryFailedCompositions() {
        synchronized (this.stateLock) {
            List failedCompositions2 = this.failedCompositions;
            if (failedCompositions2 != null) {
                while (!failedCompositions2.isEmpty()) {
                    ControlledComposition composition = (ControlledComposition) CollectionsKt.removeLast(failedCompositions2);
                    if (composition instanceof CompositionImpl) {
                        composition.invalidateAll();
                        composition.setContent(((CompositionImpl) composition).getComposable());
                        if (this.errorState != null) {
                            break;
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final Object runRecomposeConcurrentlyAndApplyChanges(CoroutineContext recomposeCoroutineContext, Continuation<? super Unit> $completion) {
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(recomposeCoroutineContext, this, (Continuation<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2>) null), $completion);
        return recompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? recompositionRunner : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x008c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runFrameLoop(androidx.compose.runtime.MonotonicFrameClock r9, androidx.compose.runtime.ProduceFrameSignal r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.compose.runtime.Recomposer$runFrameLoop$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = (androidx.compose.runtime.Recomposer$runFrameLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = new androidx.compose.runtime.Recomposer$runFrameLoop$1
            r0.<init>(r8, r11)
        L_0x0019:
            r11 = r0
            java.lang.Object r0 = r11.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r11.label
            switch(r2) {
                case 0: goto L_0x0064;
                case 1: goto L_0x004c;
                case 2: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x002d:
            java.lang.Object r9 = r11.L$4
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r10 = r11.L$3
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r2 = r11.L$2
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r3 = r11.L$1
            androidx.compose.runtime.MonotonicFrameClock r3 = (androidx.compose.runtime.MonotonicFrameClock) r3
            java.lang.Object r4 = r11.L$0
            androidx.compose.runtime.Recomposer r4 = (androidx.compose.runtime.Recomposer) r4
            kotlin.ResultKt.throwOnFailure(r0)
            r7 = r4
            r4 = r9
            r9 = r3
            r3 = r10
            r10 = r2
            r2 = r7
            goto L_0x00b4
        L_0x004c:
            java.lang.Object r9 = r11.L$4
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r10 = r11.L$3
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r2 = r11.L$2
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r3 = r11.L$1
            androidx.compose.runtime.MonotonicFrameClock r3 = (androidx.compose.runtime.MonotonicFrameClock) r3
            java.lang.Object r4 = r11.L$0
            androidx.compose.runtime.Recomposer r4 = (androidx.compose.runtime.Recomposer) r4
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0093
        L_0x0064:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r8
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = (java.util.List) r4
        L_0x0076:
            java.lang.Object r5 = r2.stateLock
            r11.L$0 = r2
            r11.L$1 = r9
            r11.L$2 = r10
            r11.L$3 = r3
            r11.L$4 = r4
            r6 = 1
            r11.label = r6
            java.lang.Object r5 = r10.awaitFrameRequest(r5, r11)
            if (r5 != r1) goto L_0x008d
            return r1
        L_0x008d:
            r7 = r3
            r3 = r9
            r9 = r4
            r4 = r2
            r2 = r10
            r10 = r7
        L_0x0093:
            androidx.compose.runtime.Recomposer$runFrameLoop$2 r5 = new androidx.compose.runtime.Recomposer$runFrameLoop$2
            r5.<init>(r4, r10, r9, r2)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r11.L$0 = r4
            r11.L$1 = r3
            r11.L$2 = r2
            r11.L$3 = r10
            r11.L$4 = r9
            r6 = 2
            r11.label = r6
            java.lang.Object r5 = r3.withFrameNanos(r5, r11)
            if (r5 != r1) goto L_0x00ae
            return r1
        L_0x00ae:
            r7 = r4
            r4 = r9
            r9 = r3
            r3 = r10
            r10 = r2
            r2 = r7
        L_0x00b4:
            goto L_0x0076
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.runFrameLoop(androidx.compose.runtime.MonotonicFrameClock, androidx.compose.runtime.ProduceFrameSignal, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final boolean getHasSchedulingWork() {
        boolean z;
        synchronized (this.stateLock) {
            z = true;
            if (!(!this.snapshotInvalidations.isEmpty()) && !(!this.compositionInvalidations.isEmpty()) && !this.broadcastFrameClock.getHasAwaiters()) {
                z = false;
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    public final Object awaitWorkAvailable(Continuation<? super Unit> $completion) {
        if (getHasSchedulingWork()) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellable$iv.initCancellability();
        CancellableContinuation co = cancellable$iv;
        synchronized (this.stateLock) {
            if (getHasSchedulingWork()) {
                Result.Companion companion = Result.Companion;
                co.resumeWith(Result.m6273constructorimpl(Unit.INSTANCE));
            } else {
                this.workContinuation = co;
            }
            Unit unit = Unit.INSTANCE;
        }
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object recompositionRunner(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        Object withContext = BuildersKt.withContext(this.broadcastFrameClock, new Recomposer$recompositionRunner$2(this, block, MonotonicFrameClockKt.getMonotonicFrameClock($completion.getContext()), (Continuation<? super Recomposer$recompositionRunner$2>) null), $completion);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            if (this._state.getValue().compareTo(State.Idle) >= 0) {
                this._state.setValue(State.ShuttingDown);
            }
            Unit unit = Unit.INSTANCE;
        }
        Job.DefaultImpls.cancel$default((Job) this.effectJob, (CancellationException) null, 1, (Object) null);
    }

    public final void close() {
        if (this.effectJob.complete()) {
            synchronized (this.stateLock) {
                this.isClosed = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final Object join(Continuation<? super Unit> $completion) {
        Object first = FlowKt.first(getCurrentState(), new Recomposer$join$2((Continuation<? super Recomposer$join$2>) null), $completion);
        return first == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? first : Unit.INSTANCE;
    }

    public void composeInitial$runtime_release(ControlledComposition composition, Function2<? super Composer, ? super Integer, Unit> content) {
        Snapshot this_$iv$iv;
        Snapshot previous$iv$iv;
        Intrinsics.checkNotNullParameter(composition, "composition");
        Intrinsics.checkNotNullParameter(content, "content");
        boolean composerWasComposing = composition.isComposing();
        try {
            MutableSnapshot snapshot$iv = Snapshot.Companion.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, (IdentityArraySet<Object>) null));
            try {
                this_$iv$iv = snapshot$iv;
                previous$iv$iv = this_$iv$iv.makeCurrent();
                composition.composeContent(content);
                Unit unit = Unit.INSTANCE;
                this_$iv$iv.restoreCurrent(previous$iv$iv);
                applyAndCheck(snapshot$iv);
                if (!composerWasComposing) {
                    Snapshot.Companion.notifyObjectsInitialized();
                }
                synchronized (this.stateLock) {
                    if (this._state.getValue().compareTo(State.ShuttingDown) > 0 && !this.knownCompositions.contains(composition)) {
                        this.knownCompositions.add(composition);
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
                try {
                    performInitialMovableContentInserts(composition);
                    try {
                        composition.applyChanges();
                        composition.applyLateChanges();
                        if (!composerWasComposing) {
                            Snapshot.Companion.notifyObjectsInitialized();
                        }
                    } catch (Exception e) {
                        processCompositionError$default(this, e, (ControlledComposition) null, false, 6, (Object) null);
                    }
                } catch (Exception e2) {
                    processCompositionError(e2, composition, true);
                }
            } catch (Throwable th) {
                applyAndCheck(snapshot$iv);
                throw th;
            }
        } catch (Exception e3) {
            processCompositionError(e3, composition, true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        r0 = new java.util.ArrayList();
        performInitialMovableContentInserts$fillToInsert(r0, r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        if ((!r0.isEmpty()) == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        performInsertValues(r0, (androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object>) null);
        performInitialMovableContentInserts$fillToInsert(r0, r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void performInitialMovableContentInserts(androidx.compose.runtime.ControlledComposition r18) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            java.lang.Object r3 = r1.stateLock
            r4 = 0
            monitor-enter(r3)
            r0 = 0
            java.util.List<androidx.compose.runtime.MovableContentStateReference> r5 = r1.compositionValuesAwaitingInsert     // Catch:{ all -> 0x005b }
            r6 = 0
            r7 = r5
            r8 = 0
            r9 = 0
            int r10 = r7.size()     // Catch:{ all -> 0x005b }
        L_0x0015:
            if (r9 >= r10) goto L_0x0033
            java.lang.Object r12 = r7.get(r9)     // Catch:{ all -> 0x005b }
            r13 = r12
            r14 = 0
            r15 = r13
            androidx.compose.runtime.MovableContentStateReference r15 = (androidx.compose.runtime.MovableContentStateReference) r15     // Catch:{ all -> 0x005b }
            r16 = 0
            androidx.compose.runtime.ControlledComposition r11 = r15.getComposition$runtime_release()     // Catch:{ all -> 0x005b }
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r2)     // Catch:{ all -> 0x005b }
            if (r11 == 0) goto L_0x002e
            r7 = 1
            goto L_0x0035
        L_0x002e:
            int r9 = r9 + 1
            goto L_0x0015
        L_0x0033:
            r7 = 0
        L_0x0035:
            if (r7 != 0) goto L_0x0039
            monitor-exit(r3)
            return
        L_0x0039:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005b }
            monitor-exit(r3)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            performInitialMovableContentInserts$fillToInsert(r0, r1, r2)
        L_0x0047:
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r4 = 1
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x005a
            r3 = 0
            r1.performInsertValues(r0, r3)
            performInitialMovableContentInserts$fillToInsert(r0, r1, r2)
            goto L_0x0047
        L_0x005a:
            return
        L_0x005b:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.performInitialMovableContentInserts(androidx.compose.runtime.ControlledComposition):void");
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<MovableContentStateReference> toInsert, Recomposer this$0, ControlledComposition $composition) {
        toInsert.clear();
        synchronized (this$0.stateLock) {
            Iterator iterator = this$0.compositionValuesAwaitingInsert.iterator();
            while (iterator.hasNext()) {
                MovableContentStateReference value = iterator.next();
                if (Intrinsics.areEqual((Object) value.getComposition$runtime_release(), (Object) $composition)) {
                    toInsert.add(value);
                    iterator.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final ControlledComposition performRecompose(ControlledComposition composition, IdentityArraySet<Object> modifiedValues) {
        Snapshot this_$iv$iv;
        Snapshot previous$iv$iv;
        if (composition.isComposing() || composition.isDisposed()) {
            return null;
        }
        MutableSnapshot snapshot$iv = Snapshot.Companion.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            this_$iv$iv = snapshot$iv;
            previous$iv$iv = this_$iv$iv.makeCurrent();
            boolean z = false;
            if (modifiedValues != null) {
                if (modifiedValues.isNotEmpty()) {
                    z = true;
                }
            }
            if (z) {
                composition.prepareCompose(new Recomposer$performRecompose$1$1(modifiedValues, composition));
            }
            boolean recompose = composition.recompose();
            this_$iv$iv.restoreCurrent(previous$iv$iv);
            applyAndCheck(snapshot$iv);
            if (recompose) {
                return composition;
            }
            return null;
        } catch (Throwable th) {
            applyAndCheck(snapshot$iv);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00fe, code lost:
        r4.insertMovableContent(r1);
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r8.restoreCurrent(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0109, code lost:
        applyAndCheck(r7);
        r1 = r29;
        r0 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x012b, code lost:
        r0 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<androidx.compose.runtime.ControlledComposition> performInsertValues(java.util.List<androidx.compose.runtime.MovableContentStateReference> r30, androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object> r31) {
        /*
            r29 = this;
            r1 = r29
            r0 = r30
            r2 = 0
            java.util.HashMap r3 = new java.util.HashMap
            int r4 = r0.size()
            r3.<init>(r4)
            r4 = r0
            r5 = 0
            r6 = 0
            int r7 = r4.size()
        L_0x0017:
            if (r6 >= r7) goto L_0x004c
            java.lang.Object r8 = r4.get(r6)
            r9 = r8
            r10 = 0
            r11 = r9
            androidx.compose.runtime.MovableContentStateReference r11 = (androidx.compose.runtime.MovableContentStateReference) r11
            r12 = 0
            androidx.compose.runtime.ControlledComposition r11 = r11.getComposition$runtime_release()
            r12 = r3
            java.util.Map r12 = (java.util.Map) r12
            r13 = 0
            java.lang.Object r14 = r12.get(r11)
            if (r14 != 0) goto L_0x003f
            r15 = 0
            java.util.ArrayList r16 = new java.util.ArrayList
            r16.<init>()
            r15 = r16
            r12.put(r11, r15)
            goto L_0x0040
        L_0x003f:
            r15 = r14
        L_0x0040:
            r12 = r15
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            r12.add(r9)
            int r6 = r6 + 1
            goto L_0x0017
        L_0x004c:
            r0 = r3
            java.util.Map r0 = (java.util.Map) r0
            r2 = r0
            java.util.Set r0 = r2.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0059:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0136
            java.lang.Object r3 = r0.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            androidx.compose.runtime.ControlledComposition r4 = (androidx.compose.runtime.ControlledComposition) r4
            java.lang.Object r3 = r3.getValue()
            java.util.List r3 = (java.util.List) r3
            boolean r5 = r4.isComposing()
            r5 = r5 ^ 1
            androidx.compose.runtime.ComposerKt.runtimeCheck(r5)
            r5 = r29
            r6 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r7 = androidx.compose.runtime.snapshots.Snapshot.Companion
            kotlin.jvm.functions.Function1 r8 = r5.readObserverOf(r4)
            r9 = r31
            kotlin.jvm.functions.Function1 r10 = r5.writeObserverOf(r4, r9)
            androidx.compose.runtime.snapshots.MutableSnapshot r7 = r7.takeMutableSnapshot(r8, r10)
            r8 = r7
            androidx.compose.runtime.snapshots.Snapshot r8 = (androidx.compose.runtime.snapshots.Snapshot) r8     // Catch:{ all -> 0x012d }
            r10 = 0
            androidx.compose.runtime.snapshots.Snapshot r11 = r8.makeCurrent()     // Catch:{ all -> 0x012d }
            r12 = 0
            java.lang.Object r13 = r1.stateLock     // Catch:{ all -> 0x0122 }
            r14 = 0
            monitor-enter(r13)     // Catch:{ all -> 0x0122 }
            r15 = 0
            r16 = r3
            r17 = 0
            r18 = r0
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0119 }
            r19 = r3
            int r3 = r16.size()     // Catch:{ all -> 0x0115 }
            r0.<init>(r3)     // Catch:{ all -> 0x0115 }
            r3 = r16
            r20 = 0
            r21 = 0
            r22 = r6
            int r6 = r3.size()     // Catch:{ all -> 0x0113 }
            r9 = r21
        L_0x00be:
            if (r9 >= r6) goto L_0x00f6
            java.lang.Object r21 = r3.get(r9)     // Catch:{ all -> 0x0113 }
            r23 = r21
            r24 = 0
            r25 = r3
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ all -> 0x0113 }
            r26 = r23
            androidx.compose.runtime.MovableContentStateReference r26 = (androidx.compose.runtime.MovableContentStateReference) r26     // Catch:{ all -> 0x0113 }
            r27 = r26
            r26 = 0
            r28 = r6
            java.util.Map<androidx.compose.runtime.MovableContent<java.lang.Object>, java.util.List<androidx.compose.runtime.MovableContentStateReference>> r6 = r1.compositionValuesRemoved     // Catch:{ all -> 0x0113 }
            androidx.compose.runtime.MovableContent r1 = r27.getContent$runtime_release()     // Catch:{ all -> 0x0113 }
            java.lang.Object r1 = androidx.compose.runtime.RecomposerKt.removeLastMultiValue(r6, r1)     // Catch:{ all -> 0x0113 }
            r6 = r27
            kotlin.Pair r1 = kotlin.TuplesKt.to(r6, r1)     // Catch:{ all -> 0x0113 }
            r3.add(r1)     // Catch:{ all -> 0x0113 }
            int r9 = r9 + 1
            r1 = r29
            r3 = r25
            r6 = r28
            goto L_0x00be
        L_0x00f6:
            r25 = r3
            r1 = r0
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0113 }
            monitor-exit(r13)     // Catch:{ all -> 0x0120 }
            r0 = r1
            r4.insertMovableContent(r0)     // Catch:{ all -> 0x0120 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0120 }
            r8.restoreCurrent(r11)     // Catch:{ all -> 0x012b }
            r5.applyAndCheck(r7)
            r1 = r29
            r0 = r18
            goto L_0x0059
        L_0x0113:
            r0 = move-exception
            goto L_0x011e
        L_0x0115:
            r0 = move-exception
            r22 = r6
            goto L_0x011e
        L_0x0119:
            r0 = move-exception
            r19 = r3
            r22 = r6
        L_0x011e:
            monitor-exit(r13)     // Catch:{ all -> 0x0120 }
            throw r0     // Catch:{ all -> 0x0120 }
        L_0x0120:
            r0 = move-exception
            goto L_0x0127
        L_0x0122:
            r0 = move-exception
            r19 = r3
            r22 = r6
        L_0x0127:
            r8.restoreCurrent(r11)     // Catch:{ all -> 0x012b }
            throw r0     // Catch:{ all -> 0x012b }
        L_0x012b:
            r0 = move-exception
            goto L_0x0132
        L_0x012d:
            r0 = move-exception
            r19 = r3
            r22 = r6
        L_0x0132:
            r5.applyAndCheck(r7)
            throw r0
        L_0x0136:
            java.util.Set r0 = r2.keySet()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.List r0 = kotlin.collections.CollectionsKt.toList(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.performInsertValues(java.util.List, androidx.compose.runtime.collection.IdentityArraySet):java.util.List");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007f, code lost:
        r2 = r0;
        r4 = 0;
        r5 = r2.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0088, code lost:
        if (r4 >= r5) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x008a, code lost:
        r7 = (kotlin.Pair) r2.get(r4);
        r9 = (androidx.compose.runtime.MovableContentStateReference) r7.component1();
        r7 = (androidx.compose.runtime.MovableContentState) r7.component2();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x009e, code lost:
        if (r7 == null) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a0, code lost:
        r9.getComposition$runtime_release().disposeUnusedMovableContent(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a7, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ad, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void discardUnusedValues() {
        /*
            r20 = this;
            r1 = r20
            java.lang.Object r2 = r1.stateLock
            r3 = 0
            monitor-enter(r2)
            r0 = 0
            java.util.Map<androidx.compose.runtime.MovableContent<java.lang.Object>, java.util.List<androidx.compose.runtime.MovableContentStateReference>> r4 = r1.compositionValuesRemoved     // Catch:{ all -> 0x00b0 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x00b0 }
            r4 = r4 ^ 1
            if (r4 == 0) goto L_0x0075
            java.util.Map<androidx.compose.runtime.MovableContent<java.lang.Object>, java.util.List<androidx.compose.runtime.MovableContentStateReference>> r4 = r1.compositionValuesRemoved     // Catch:{ all -> 0x00b0 }
            java.util.Collection r4 = r4.values()     // Catch:{ all -> 0x00b0 }
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch:{ all -> 0x00b0 }
            java.util.List r4 = kotlin.collections.CollectionsKt.flatten(r4)     // Catch:{ all -> 0x00b0 }
            java.util.Map<androidx.compose.runtime.MovableContent<java.lang.Object>, java.util.List<androidx.compose.runtime.MovableContentStateReference>> r5 = r1.compositionValuesRemoved     // Catch:{ all -> 0x00b0 }
            r5.clear()     // Catch:{ all -> 0x00b0 }
            r5 = r4
            r6 = 0
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x00b0 }
            int r8 = r5.size()     // Catch:{ all -> 0x00b0 }
            r7.<init>(r8)     // Catch:{ all -> 0x00b0 }
            r8 = r5
            r9 = 0
            r10 = 0
            int r11 = r8.size()     // Catch:{ all -> 0x00b0 }
        L_0x0036:
            if (r10 >= r11) goto L_0x0065
            java.lang.Object r12 = r8.get(r10)     // Catch:{ all -> 0x00b0 }
            r13 = r12
            r14 = 0
            r15 = r7
            java.util.Collection r15 = (java.util.Collection) r15     // Catch:{ all -> 0x00b0 }
            r16 = r13
            androidx.compose.runtime.MovableContentStateReference r16 = (androidx.compose.runtime.MovableContentStateReference) r16     // Catch:{ all -> 0x00b0 }
            r17 = r16
            r16 = 0
            r18 = r0
            java.util.Map<androidx.compose.runtime.MovableContentStateReference, androidx.compose.runtime.MovableContentState> r0 = r1.compositionValueStatesAvailable     // Catch:{ all -> 0x00b0 }
            r19 = r3
            r3 = r17
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x00ae }
            kotlin.Pair r0 = kotlin.TuplesKt.to(r3, r0)     // Catch:{ all -> 0x00ae }
            r15.add(r0)     // Catch:{ all -> 0x00ae }
            int r10 = r10 + 1
            r0 = r18
            r3 = r19
            goto L_0x0036
        L_0x0065:
            r18 = r0
            r19 = r3
            r0 = r7
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x00ae }
            java.util.Map<androidx.compose.runtime.MovableContentStateReference, androidx.compose.runtime.MovableContentState> r3 = r1.compositionValueStatesAvailable     // Catch:{ all -> 0x00ae }
            r3.clear()     // Catch:{ all -> 0x00ae }
            goto L_0x007d
        L_0x0075:
            r18 = r0
            r19 = r3
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()     // Catch:{ all -> 0x00ae }
        L_0x007d:
            monitor-exit(r2)
            r2 = r0
            r3 = 0
            r4 = 0
            int r5 = r2.size()
        L_0x0088:
            if (r4 >= r5) goto L_0x00ac
            java.lang.Object r6 = r2.get(r4)
            r7 = r6
            kotlin.Pair r7 = (kotlin.Pair) r7
            r8 = 0
            java.lang.Object r9 = r7.component1()
            androidx.compose.runtime.MovableContentStateReference r9 = (androidx.compose.runtime.MovableContentStateReference) r9
            java.lang.Object r7 = r7.component2()
            androidx.compose.runtime.MovableContentState r7 = (androidx.compose.runtime.MovableContentState) r7
            if (r7 == 0) goto L_0x00a7
            androidx.compose.runtime.ControlledComposition r10 = r9.getComposition$runtime_release()
            r10.disposeUnusedMovableContent(r7)
        L_0x00a7:
            int r4 = r4 + 1
            goto L_0x0088
        L_0x00ac:
            return
        L_0x00ae:
            r0 = move-exception
            goto L_0x00b3
        L_0x00b0:
            r0 = move-exception
            r19 = r3
        L_0x00b3:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.discardUnusedValues():void");
    }

    private final Function1<Object, Unit> readObserverOf(ControlledComposition composition) {
        return new Recomposer$readObserverOf$1(composition);
    }

    private final Function1<Object, Unit> writeObserverOf(ControlledComposition composition, IdentityArraySet<Object> modifiedValues) {
        return new Recomposer$writeObserverOf$1(composition, modifiedValues);
    }

    private final <T> T composing(ControlledComposition composition, IdentityArraySet<Object> modifiedValues, Function0<? extends T> block) {
        Snapshot this_$iv;
        Snapshot previous$iv;
        MutableSnapshot snapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            this_$iv = snapshot;
            previous$iv = this_$iv.makeCurrent();
            T invoke = block.invoke();
            InlineMarker.finallyStart(1);
            this_$iv.restoreCurrent(previous$iv);
            InlineMarker.finallyEnd(1);
            InlineMarker.finallyStart(1);
            applyAndCheck(snapshot);
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            applyAndCheck(snapshot);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    private final void applyAndCheck(MutableSnapshot snapshot) {
        try {
            if (snapshot.apply() instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
            }
        } finally {
            snapshot.dispose();
        }
    }

    public final boolean getHasPendingWork() {
        boolean z;
        synchronized (this.stateLock) {
            z = true;
            if (!(!this.snapshotInvalidations.isEmpty()) && !(!this.compositionInvalidations.isEmpty()) && this.concurrentCompositionsOutstanding <= 0 && !(!this.compositionsAwaitingApply.isEmpty()) && !this.broadcastFrameClock.getHasAwaiters()) {
                z = false;
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    public final boolean getHasFrameWorkLocked() {
        return (this.compositionInvalidations.isEmpty() ^ true) || this.broadcastFrameClock.getHasAwaiters();
    }

    /* access modifiers changed from: private */
    public final boolean getHasConcurrentFrameWorkLocked() {
        return (this.compositionsAwaitingApply.isEmpty() ^ true) || this.broadcastFrameClock.getHasAwaiters();
    }

    public final Object awaitIdle(Continuation<? super Unit> $completion) {
        Object collect = FlowKt.collect(FlowKt.takeWhile(getCurrentState(), new Recomposer$awaitIdle$2((Continuation<? super Recomposer$awaitIdle$2>) null)), $completion);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public int getCompoundHashKey$runtime_release() {
        return 1000;
    }

    public boolean getCollectingParameterInformation$runtime_release() {
        return false;
    }

    public void recordInspectionTable$runtime_release(Set<CompositionData> table) {
        Intrinsics.checkNotNullParameter(table, "table");
    }

    public void registerComposition$runtime_release(ControlledComposition composition) {
        Intrinsics.checkNotNullParameter(composition, "composition");
    }

    public void unregisterComposition$runtime_release(ControlledComposition composition) {
        Intrinsics.checkNotNullParameter(composition, "composition");
        synchronized (this.stateLock) {
            this.knownCompositions.remove(composition);
            this.compositionInvalidations.remove(composition);
            this.compositionsAwaitingApply.remove(composition);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void invalidate$runtime_release(ControlledComposition composition) {
        CancellableContinuation<Unit> cancellableContinuation;
        Intrinsics.checkNotNullParameter(composition, "composition");
        synchronized (this.stateLock) {
            if (!this.compositionInvalidations.contains(composition)) {
                this.compositionInvalidations.add(composition);
                cancellableContinuation = deriveStateLocked();
            } else {
                cancellableContinuation = null;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m6273constructorimpl(Unit.INSTANCE));
        }
    }

    public void invalidateScope$runtime_release(RecomposeScopeImpl scope) {
        CancellableContinuation<Unit> deriveStateLocked;
        Intrinsics.checkNotNullParameter(scope, "scope");
        synchronized (this.stateLock) {
            this.snapshotInvalidations.add(scope);
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            deriveStateLocked.resumeWith(Result.m6273constructorimpl(Unit.INSTANCE));
        }
    }

    public void insertMovableContent$runtime_release(MovableContentStateReference reference) {
        CancellableContinuation<Unit> deriveStateLocked;
        Intrinsics.checkNotNullParameter(reference, "reference");
        synchronized (this.stateLock) {
            this.compositionValuesAwaitingInsert.add(reference);
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            deriveStateLocked.resumeWith(Result.m6273constructorimpl(Unit.INSTANCE));
        }
    }

    public void deletedMovableContent$runtime_release(MovableContentStateReference reference) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        synchronized (this.stateLock) {
            RecomposerKt.addMultiValue(this.compositionValuesRemoved, reference.getContent$runtime_release(), reference);
        }
    }

    public void movableContentStateReleased$runtime_release(MovableContentStateReference reference, MovableContentState data) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        Intrinsics.checkNotNullParameter(data, "data");
        synchronized (this.stateLock) {
            this.compositionValueStatesAvailable.put(reference, data);
            Unit unit = Unit.INSTANCE;
        }
    }

    public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference reference) {
        MovableContentState remove;
        Intrinsics.checkNotNullParameter(reference, "reference");
        synchronized (this.stateLock) {
            remove = this.compositionValueStatesAvailable.remove(reference);
        }
        return remove;
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010\u0016\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0017J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\u0015\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\"J\u0014\u0010#\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010$\u001a\u00020\u0001H\u0000¢\u0006\u0002\b%J\u0015\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0005H\u0000¢\u0006\u0002\b(R.\u0010\u0003\u001a\"\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004j\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005`\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000bR\u00020\f0\n0\tX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", "", "()V", "_hotReloadEnabled", "Ljava/util/concurrent/atomic/AtomicReference;", "", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "runningRecomposers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/compose/runtime/RecomposerInfo;", "getRunningRecomposers", "()Lkotlinx/coroutines/flow/StateFlow;", "addRunning", "", "info", "clearErrors", "clearErrors$runtime_release", "getCurrentErrors", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors$runtime_release", "invalidateGroupsWithKey", "key", "", "invalidateGroupsWithKey$runtime_release", "loadStateAndComposeForHotReload", "token", "loadStateAndComposeForHotReload$runtime_release", "removeRunning", "saveStateAndDisposeForHotReload", "saveStateAndDisposeForHotReload$runtime_release", "setHotReloadEnabled", "value", "setHotReloadEnabled$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Recomposer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StateFlow<Set<RecomposerInfo>> getRunningRecomposers() {
            return Recomposer._runningRecomposers;
        }

        public final void setHotReloadEnabled$runtime_release(boolean value) {
            Recomposer._hotReloadEnabled.set(Boolean.valueOf(value));
        }

        /* access modifiers changed from: private */
        public final void addRunning(RecomposerInfoImpl info) {
            PersistentSet old;
            PersistentSet add;
            do {
                old = (PersistentSet) Recomposer._runningRecomposers.getValue();
                add = old.add(info);
                if (old == add || Recomposer._runningRecomposers.compareAndSet(old, add)) {
                }
                old = (PersistentSet) Recomposer._runningRecomposers.getValue();
                add = old.add(info);
                return;
            } while (Recomposer._runningRecomposers.compareAndSet(old, add));
        }

        /* access modifiers changed from: private */
        public final void removeRunning(RecomposerInfoImpl info) {
            PersistentSet old;
            PersistentSet remove;
            do {
                old = (PersistentSet) Recomposer._runningRecomposers.getValue();
                remove = old.remove(info);
                if (old == remove || Recomposer._runningRecomposers.compareAndSet(old, remove)) {
                }
                old = (PersistentSet) Recomposer._runningRecomposers.getValue();
                remove = old.remove(info);
                return;
            } while (Recomposer._runningRecomposers.compareAndSet(old, remove));
        }

        public final Object saveStateAndDisposeForHotReload$runtime_release() {
            Recomposer._hotReloadEnabled.set(true);
            Collection destination$iv$iv = new ArrayList();
            for (RecomposerInfoImpl it : (Iterable) Recomposer._runningRecomposers.getValue()) {
                CollectionsKt.addAll(destination$iv$iv, it.saveStateAndDisposeForHotReload());
            }
            return (List) destination$iv$iv;
        }

        public final void loadStateAndComposeForHotReload$runtime_release(Object token) {
            Intrinsics.checkNotNullParameter(token, "token");
            Recomposer._hotReloadEnabled.set(true);
            for (RecomposerInfoImpl it : (Iterable) Recomposer._runningRecomposers.getValue()) {
                it.resetErrorState();
            }
            List holders = (List) token;
            List $this$fastForEach$iv = holders;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                ((HotReloadable) $this$fastForEach$iv.get(index$iv)).resetContent();
            }
            List $this$fastForEach$iv2 = holders;
            int size2 = $this$fastForEach$iv2.size();
            for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                ((HotReloadable) $this$fastForEach$iv2.get(index$iv2)).recompose();
            }
            for (RecomposerInfoImpl it2 : (Iterable) Recomposer._runningRecomposers.getValue()) {
                it2.retryFailedCompositions();
            }
        }

        public final void invalidateGroupsWithKey$runtime_release(int key) {
            Recomposer._hotReloadEnabled.set(true);
            for (RecomposerInfoImpl it : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorInfo currentError = it.getCurrentError();
                boolean z = false;
                if (currentError != null && !currentError.getRecoverable()) {
                    z = true;
                }
                if (!z) {
                    it.resetErrorState();
                    it.invalidateGroupsWithKey(key);
                    it.retryFailedCompositions();
                }
            }
        }

        public final List<RecomposerErrorInfo> getCurrentErrors$runtime_release() {
            Collection destination$iv$iv = new ArrayList();
            for (RecomposerInfoImpl it : (Iterable) Recomposer._runningRecomposers.getValue()) {
                Object it$iv$iv = it.getCurrentError();
                if (it$iv$iv != null) {
                    destination$iv$iv.add(it$iv$iv);
                }
            }
            return (List) destination$iv$iv;
        }

        public final void clearErrors$runtime_release() {
            Collection destination$iv$iv = new ArrayList();
            for (RecomposerInfoImpl it : (Iterable) Recomposer._runningRecomposers.getValue()) {
                Object it$iv$iv = it.resetErrorState();
                if (it$iv$iv != null) {
                    destination$iv$iv.add(it$iv$iv);
                }
            }
            Collection destination$iv$iv2 = (List) destination$iv$iv;
        }
    }
}
