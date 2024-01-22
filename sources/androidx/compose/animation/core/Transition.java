package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0004hijkB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B!\b\u0001\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ'\u0010I\u001a\u00020\u00192\u0018\u0010J\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\fR\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\bKJ\u0019\u0010L\u001a\u00020\u00192\n\u0010M\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0002\bNJ\u0017\u0010O\u001a\u00020P2\u0006\u0010;\u001a\u00028\u0000H\u0001¢\u0006\u0004\bQ\u0010RJ\b\u0010S\u001a\u00020PH\u0002J\u001d\u0010T\u001a\u00020P2\u0006\u0010U\u001a\u00020&2\u0006\u0010V\u001a\u00020WH\u0000¢\u0006\u0002\bXJ\r\u0010Y\u001a\u00020PH\u0000¢\u0006\u0002\bZJ\u0015\u0010[\u001a\u00020P2\u0006\u0010U\u001a\u00020&H\u0000¢\u0006\u0002\b\\J'\u0010]\u001a\u00020P2\u0018\u0010^\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030_R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\b`J'\u0010]\u001a\u00020P2\u0018\u0010J\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\fR\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\b`J\u0019\u0010a\u001a\u00020\u00192\n\u0010M\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0002\bbJ'\u0010c\u001a\u00020P2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010;\u001a\u00028\u00002\u0006\u0010+\u001a\u00020&H\u0007¢\u0006\u0004\bd\u0010eJ\u0017\u0010f\u001a\u00020P2\u0006\u0010;\u001a\u00028\u0000H\u0001¢\u0006\u0004\bg\u0010RR&\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\fR\b\u0012\u0004\u0012\u00028\u00000\u00000\u000bX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u000bX\u0004¢\u0006\u0002\n\u0000R)\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\fR\b\u0012\u0004\u0012\u00028\u00000\u00000\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00008F@@X\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR1\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00198F@@X\u0002¢\u0006\u0018\n\u0004\b!\u0010\"\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001c\u0010\u001a\"\u0004\b\u001f\u0010 R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R1\u0010+\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020&8F@FX\u0002¢\u0006\u0018\n\u0004\b/\u0010\"\u0012\u0004\b,\u0010\u001e\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R7\u00101\u001a\b\u0012\u0004\u0012\u00028\u0000002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u0000008F@BX\u0002¢\u0006\u0012\n\u0004\b6\u0010\"\u001a\u0004\b2\u00103\"\u0004\b4\u00105R+\u00107\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020&8B@BX\u0002¢\u0006\u0012\n\u0004\b:\u0010\"\u001a\u0004\b8\u0010(\"\u0004\b9\u0010*R+\u0010;\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u00008F@@X\u0002¢\u0006\u0012\n\u0004\b>\u0010\"\u001a\u0004\b<\u0010\u0015\"\u0004\b=\u0010\u0017R\u001b\u0010?\u001a\u00020&8FX\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\b@\u0010(R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010C\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u000f8F¢\u0006\u0006\u001a\u0004\bD\u0010\u0011R+\u0010E\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00198@@@X\u0002¢\u0006\u0012\n\u0004\bH\u0010\"\u001a\u0004\bF\u0010\u001a\"\u0004\bG\u0010 ¨\u0006l"}, d2 = {"Landroidx/compose/animation/core/Transition;", "S", "", "initialState", "label", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "transitionState", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;)V", "_animations", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "_transitions", "animations", "", "getAnimations", "()Ljava/util/List;", "value", "currentState", "getCurrentState", "()Ljava/lang/Object;", "setCurrentState$animation_core_release", "(Ljava/lang/Object;)V", "isRunning", "", "()Z", "<set-?>", "isSeeking", "isSeeking$annotations", "()V", "setSeeking$animation_core_release", "(Z)V", "isSeeking$delegate", "Landroidx/compose/runtime/MutableState;", "getLabel", "()Ljava/lang/String;", "lastSeekedTimeNanos", "", "getLastSeekedTimeNanos$animation_core_release", "()J", "setLastSeekedTimeNanos$animation_core_release", "(J)V", "playTimeNanos", "getPlayTimeNanos$annotations", "getPlayTimeNanos", "setPlayTimeNanos", "playTimeNanos$delegate", "Landroidx/compose/animation/core/Transition$Segment;", "segment", "getSegment", "()Landroidx/compose/animation/core/Transition$Segment;", "setSegment", "(Landroidx/compose/animation/core/Transition$Segment;)V", "segment$delegate", "startTimeNanos", "getStartTimeNanos", "setStartTimeNanos", "startTimeNanos$delegate", "targetState", "getTargetState", "setTargetState$animation_core_release", "targetState$delegate", "totalDurationNanos", "getTotalDurationNanos", "totalDurationNanos$delegate", "Landroidx/compose/runtime/State;", "transitions", "getTransitions", "updateChildrenNeeded", "getUpdateChildrenNeeded$animation_core_release", "setUpdateChildrenNeeded$animation_core_release", "updateChildrenNeeded$delegate", "addAnimation", "animation", "addAnimation$animation_core_release", "addTransition", "transition", "addTransition$animation_core_release", "animateTo", "", "animateTo$animation_core_release", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "onChildAnimationUpdated", "onFrame", "frameTimeNanos", "durationScale", "", "onFrame$animation_core_release", "onTransitionEnd", "onTransitionEnd$animation_core_release", "onTransitionStart", "onTransitionStart$animation_core_release", "removeAnimation", "deferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "removeAnimation$animation_core_release", "removeTransition", "removeTransition$animation_core_release", "setPlaytimeAfterInitialAndTargetStateEstablished", "seek", "(Ljava/lang/Object;Ljava/lang/Object;J)V", "updateTarget", "updateTarget$animation_core_release", "DeferredAnimation", "Segment", "SegmentImpl", "TransitionAnimationState", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
public final class Transition<S> {
    public static final int $stable = 0;
    /* access modifiers changed from: private */
    public final SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> _animations;
    /* access modifiers changed from: private */
    public final SnapshotStateList<Transition<?>> _transitions;
    private final MutableState isSeeking$delegate;
    private final String label;
    private long lastSeekedTimeNanos;
    private final MutableState playTimeNanos$delegate;
    private final MutableState segment$delegate;
    private final MutableState startTimeNanos$delegate;
    private final MutableState targetState$delegate;
    private final State totalDurationNanos$delegate;
    private final MutableTransitionState<S> transitionState;
    private final MutableState updateChildrenNeeded$delegate;

    public static /* synthetic */ void getPlayTimeNanos$annotations() {
    }

    public static /* synthetic */ void isSeeking$annotations() {
    }

    public Transition(MutableTransitionState<S> transitionState2, String label2) {
        Intrinsics.checkNotNullParameter(transitionState2, "transitionState");
        this.transitionState = transitionState2;
        this.label = label2;
        this.targetState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getCurrentState(), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.segment$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new SegmentImpl(getCurrentState(), getCurrentState()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.playTimeNanos$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.startTimeNanos$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Long.MIN_VALUE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.updateChildrenNeeded$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
        this._animations = SnapshotStateKt.mutableStateListOf();
        this._transitions = SnapshotStateKt.mutableStateListOf();
        this.isSeeking$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.totalDurationNanos$delegate = SnapshotStateKt.derivedStateOf(new Transition$totalDurationNanos$2(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Transition(MutableTransitionState mutableTransitionState, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableTransitionState, (i & 2) != 0 ? null : str);
    }

    public final String getLabel() {
        return this.label;
    }

    public Transition(S initialState, String label2) {
        this(new MutableTransitionState(initialState), label2);
    }

    public final S getCurrentState() {
        return this.transitionState.getCurrentState();
    }

    public final void setCurrentState$animation_core_release(S value) {
        this.transitionState.setCurrentState$animation_core_release(value);
    }

    public final S getTargetState() {
        return this.targetState$delegate.getValue();
    }

    public final void setTargetState$animation_core_release(S s) {
        this.targetState$delegate.setValue(s);
    }

    private final void setSegment(Segment<S> segment) {
        this.segment$delegate.setValue(segment);
    }

    public final Segment<S> getSegment() {
        return (Segment) this.segment$delegate.getValue();
    }

    public final boolean isRunning() {
        return getStartTimeNanos() != Long.MIN_VALUE;
    }

    public final long getPlayTimeNanos() {
        return ((Number) this.playTimeNanos$delegate.getValue()).longValue();
    }

    public final void setPlayTimeNanos(long j) {
        this.playTimeNanos$delegate.setValue(Long.valueOf(j));
    }

    private final long getStartTimeNanos() {
        return ((Number) this.startTimeNanos$delegate.getValue()).longValue();
    }

    private final void setStartTimeNanos(long j) {
        this.startTimeNanos$delegate.setValue(Long.valueOf(j));
    }

    public final boolean getUpdateChildrenNeeded$animation_core_release() {
        return ((Boolean) this.updateChildrenNeeded$delegate.getValue()).booleanValue();
    }

    public final void setUpdateChildrenNeeded$animation_core_release(boolean z) {
        this.updateChildrenNeeded$delegate.setValue(Boolean.valueOf(z));
    }

    public final List<Transition<?>> getTransitions() {
        return this._transitions;
    }

    public final List<Transition<S>.TransitionAnimationState<?, ?>> getAnimations() {
        return this._animations;
    }

    public final boolean isSeeking() {
        return ((Boolean) this.isSeeking$delegate.getValue()).booleanValue();
    }

    public final void setSeeking$animation_core_release(boolean z) {
        this.isSeeking$delegate.setValue(Boolean.valueOf(z));
    }

    public final long getLastSeekedTimeNanos$animation_core_release() {
        return this.lastSeekedTimeNanos;
    }

    public final void setLastSeekedTimeNanos$animation_core_release(long j) {
        this.lastSeekedTimeNanos = j;
    }

    public final long getTotalDurationNanos() {
        return ((Number) this.totalDurationNanos$delegate.getValue()).longValue();
    }

    public final void onFrame$animation_core_release(long frameTimeNanos, float durationScale) {
        if (getStartTimeNanos() == Long.MIN_VALUE) {
            onTransitionStart$animation_core_release(frameTimeNanos);
        }
        setUpdateChildrenNeeded$animation_core_release(false);
        setPlayTimeNanos(frameTimeNanos - getStartTimeNanos());
        boolean allFinished = true;
        for (TransitionAnimationState it : this._animations) {
            if (!it.isFinished$animation_core_release()) {
                it.onPlayTimeChanged$animation_core_release(getPlayTimeNanos(), durationScale);
            }
            if (!it.isFinished$animation_core_release()) {
                allFinished = false;
            }
        }
        for (Transition it2 : this._transitions) {
            if (!Intrinsics.areEqual(it2.getTargetState(), it2.getCurrentState())) {
                it2.onFrame$animation_core_release(getPlayTimeNanos(), durationScale);
            }
            if (!Intrinsics.areEqual(it2.getTargetState(), it2.getCurrentState())) {
                allFinished = false;
            }
        }
        if (allFinished) {
            onTransitionEnd$animation_core_release();
        }
    }

    public final void onTransitionStart$animation_core_release(long frameTimeNanos) {
        setStartTimeNanos(frameTimeNanos);
        this.transitionState.setRunning$animation_core_release(true);
    }

    public final void onTransitionEnd$animation_core_release() {
        setStartTimeNanos(Long.MIN_VALUE);
        setCurrentState$animation_core_release(getTargetState());
        setPlayTimeNanos(0);
        this.transitionState.setRunning$animation_core_release(false);
    }

    public final void seek(S initialState, S targetState, long playTimeNanos) {
        setStartTimeNanos(Long.MIN_VALUE);
        this.transitionState.setRunning$animation_core_release(false);
        if (!isSeeking() || !Intrinsics.areEqual(getCurrentState(), (Object) initialState) || !Intrinsics.areEqual(getTargetState(), (Object) targetState)) {
            setCurrentState$animation_core_release(initialState);
            setTargetState$animation_core_release(targetState);
            setSeeking$animation_core_release(true);
            setSegment(new SegmentImpl(initialState, targetState));
        }
        for (Transition it : this._transitions) {
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Any>");
            Transition it2 = it;
            if (it2.isSeeking()) {
                it2.seek(it2.getCurrentState(), it2.getTargetState(), playTimeNanos);
            }
        }
        for (TransitionAnimationState it3 : this._animations) {
            it3.seekTo$animation_core_release(playTimeNanos);
        }
        this.lastSeekedTimeNanos = playTimeNanos;
    }

    public final boolean addTransition$animation_core_release(Transition<?> transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        return this._transitions.add(transition);
    }

    public final boolean removeTransition$animation_core_release(Transition<?> transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        return this._transitions.remove((Object) transition);
    }

    public final boolean addAnimation$animation_core_release(Transition<S>.TransitionAnimationState<?, ?> animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        return this._animations.add(animation);
    }

    public final void removeAnimation$animation_core_release(Transition<S>.TransitionAnimationState<?, ?> animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this._animations.remove((Object) animation);
    }

    public final void updateTarget$animation_core_release(S targetState, Composer $composer, int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-583974681);
        ComposerKt.sourceInformation($composer2, "C(updateTarget):Transition.kt#pdpnli");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) targetState) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed((Object) this) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-583974681, $changed, -1, "androidx.compose.animation.core.Transition.updateTarget (Transition.kt:399)");
            }
            if (!isSeeking() && !Intrinsics.areEqual(getTargetState(), (Object) targetState)) {
                setSegment(new SegmentImpl(getTargetState(), targetState));
                setCurrentState$animation_core_release(getTargetState());
                setTargetState$animation_core_release(targetState);
                if (!isRunning()) {
                    setUpdateChildrenNeeded$animation_core_release(true);
                }
                for (TransitionAnimationState it : this._animations) {
                    it.resetAnimation$animation_core_release();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Transition$updateTarget$2(this, targetState, $changed));
        }
    }

    public final void animateTo$animation_core_release(S targetState, Composer $composer, int $changed) {
        Object value$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1493585151);
        ComposerKt.sourceInformation($composer2, "C(animateTo)426@16622L25,430@16892L655,430@16871L676:Transition.kt#pdpnli");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) targetState) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed((Object) this) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1493585151, $dirty, -1, "androidx.compose.animation.core.Transition.animateTo (Transition.kt:424)");
            }
            if (!isSeeking()) {
                updateTarget$animation_core_release(targetState, $composer2, ($dirty & 14) | ($dirty & 112));
                if (!Intrinsics.areEqual((Object) targetState, getCurrentState()) || isRunning() || getUpdateChildrenNeeded$animation_core_release()) {
                    int i = ($dirty >> 3) & 14;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer2.changed((Object) this);
                    Composer $this$cache$iv$iv = $composer2;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = (Function2) new Transition$animateTo$1$1(this, (Continuation<? super Transition$animateTo$1$1>) null);
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    EffectsKt.LaunchedEffect((Object) this, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) value$iv$iv, $composer2, (($dirty >> 3) & 14) | 64);
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Transition$animateTo$2(this, targetState, $changed));
        }
    }

    /* access modifiers changed from: private */
    public final void onChildAnimationUpdated() {
        setUpdateChildrenNeeded$animation_core_release(true);
        if (isSeeking()) {
            long maxDurationNanos = 0;
            for (TransitionAnimationState it : this._animations) {
                maxDurationNanos = Math.max(maxDurationNanos, it.getDurationNanos$animation_core_release());
                it.seekTo$animation_core_release(this.lastSeekedTimeNanos);
            }
            setUpdateChildrenNeeded$animation_core_release(false);
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\b\b\u0002\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B3\b\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\u0006\u0010\u0006\u001a\u00028\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001d\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020EH\u0000¢\u0006\u0002\bFJ\r\u0010G\u001a\u00020BH\u0000¢\u0006\u0002\bHJ\u0015\u0010I\u001a\u00020B2\u0006\u0010C\u001a\u00020\u001dH\u0000¢\u0006\u0002\bJJ!\u0010K\u001a\u00020B2\b\b\u0002\u0010\u0005\u001a\u00028\u00012\b\b\u0002\u0010L\u001a\u00020!H\u0002¢\u0006\u0002\u0010MJ-\u0010N\u001a\u00020B2\u0006\u0010\u0005\u001a\u00028\u00012\u0006\u00103\u001a\u00028\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0000¢\u0006\u0004\bO\u0010PJ%\u0010Q\u001a\u00020B2\u0006\u00103\u001a\u00028\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0000¢\u0006\u0004\bR\u0010SRC\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r8F@BX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R7\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00158F@BX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001d8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u0015X\u0004¢\u0006\u0002\n\u0000R+\u0010\"\u001a\u00020!2\u0006\u0010\f\u001a\u00020!8@@@X\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0014\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R+\u0010*\u001a\u00020!2\u0006\u0010\f\u001a\u00020!8B@BX\u0002¢\u0006\u0012\n\u0004\b-\u0010\u0014\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R+\u0010.\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u001d8B@BX\u0002¢\u0006\u0012\n\u0004\b2\u0010\u0014\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u00101R+\u00103\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u00018B@BX\u0002¢\u0006\u0012\n\u0004\b8\u0010\u0014\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R+\u0010;\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u00018V@PX\u0002¢\u0006\u0012\n\u0004\b>\u0010\u0014\u001a\u0004\b<\u00105\"\u0004\b=\u00107R\u0010\u0010?\u001a\u00028\u0002X\u000e¢\u0006\u0004\n\u0002\u0010@¨\u0006T"}, d2 = {"Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "initialValue", "initialVelocityVector", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "label", "", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "<set-?>", "Landroidx/compose/animation/core/TargetBasedAnimation;", "animation", "getAnimation", "()Landroidx/compose/animation/core/TargetBasedAnimation;", "setAnimation", "(Landroidx/compose/animation/core/TargetBasedAnimation;)V", "animation$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "animationSpec", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animationSpec$delegate", "durationNanos", "", "getDurationNanos$animation_core_release", "()J", "interruptionSpec", "", "isFinished", "isFinished$animation_core_release", "()Z", "setFinished$animation_core_release", "(Z)V", "isFinished$delegate", "getLabel", "()Ljava/lang/String;", "needsReset", "getNeedsReset", "setNeedsReset", "needsReset$delegate", "offsetTimeNanos", "getOffsetTimeNanos", "setOffsetTimeNanos", "(J)V", "offsetTimeNanos$delegate", "targetValue", "getTargetValue", "()Ljava/lang/Object;", "setTargetValue", "(Ljava/lang/Object;)V", "targetValue$delegate", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "value", "getValue", "setValue$animation_core_release", "value$delegate", "velocityVector", "Landroidx/compose/animation/core/AnimationVector;", "onPlayTimeChanged", "", "playTimeNanos", "durationScale", "", "onPlayTimeChanged$animation_core_release", "resetAnimation", "resetAnimation$animation_core_release", "seekTo", "seekTo$animation_core_release", "updateAnimation", "isInterrupted", "(Ljava/lang/Object;Z)V", "updateInitialAndTargetValue", "updateInitialAndTargetValue$animation_core_release", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "updateTargetValue", "updateTargetValue$animation_core_release", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Transition.kt */
    public final class TransitionAnimationState<T, V extends AnimationVector> implements State<T> {
        private final MutableState animation$delegate;
        private final MutableState animationSpec$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null), (SnapshotMutationPolicy) null, 2, (Object) null);
        private final FiniteAnimationSpec<T> interruptionSpec;
        private final MutableState isFinished$delegate;
        private final String label;
        private final MutableState needsReset$delegate;
        private final MutableState offsetTimeNanos$delegate;
        private final MutableState targetValue$delegate;
        final /* synthetic */ Transition<S> this$0;
        private final TwoWayConverter<T, V> typeConverter;
        private final MutableState value$delegate;
        private V velocityVector;

        public TransitionAnimationState(Transition this$02, T initialValue, V initialVelocityVector, TwoWayConverter<T, V> typeConverter2, String label2) {
            Object visibilityThreshold;
            Intrinsics.checkNotNullParameter(initialVelocityVector, "initialVelocityVector");
            Intrinsics.checkNotNullParameter(typeConverter2, "typeConverter");
            Intrinsics.checkNotNullParameter(label2, "label");
            this.this$0 = this$02;
            this.typeConverter = typeConverter2;
            this.label = label2;
            this.targetValue$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialValue, (SnapshotMutationPolicy) null, 2, (Object) null);
            this.animation$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TargetBasedAnimation(getAnimationSpec(), typeConverter2, initialValue, getTargetValue(), initialVelocityVector), (SnapshotMutationPolicy) null, 2, (Object) null);
            this.isFinished$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
            this.offsetTimeNanos$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, (SnapshotMutationPolicy) null, 2, (Object) null);
            this.needsReset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
            this.value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialValue, (SnapshotMutationPolicy) null, 2, (Object) null);
            this.velocityVector = initialVelocityVector;
            Float f = (Float) VisibilityThresholdsKt.getVisibilityThresholdMap().get(typeConverter2);
            if (f != null) {
                float it = f.floatValue();
                AnimationVector vector = (AnimationVector) typeConverter2.getConvertToVector().invoke(initialValue);
                int size$animation_core_release = vector.getSize$animation_core_release();
                for (int id = 0; id < size$animation_core_release; id++) {
                    vector.set$animation_core_release(id, it);
                }
                visibilityThreshold = this.typeConverter.getConvertFromVector().invoke(vector);
            } else {
                visibilityThreshold = null;
            }
            this.interruptionSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, visibilityThreshold, 3, (Object) null);
        }

        public final TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        public final String getLabel() {
            return this.label;
        }

        private final T getTargetValue() {
            return this.targetValue$delegate.getValue();
        }

        private final void setTargetValue(T t) {
            this.targetValue$delegate.setValue(t);
        }

        private final void setAnimationSpec(FiniteAnimationSpec<T> finiteAnimationSpec) {
            this.animationSpec$delegate.setValue(finiteAnimationSpec);
        }

        public final FiniteAnimationSpec<T> getAnimationSpec() {
            return (FiniteAnimationSpec) this.animationSpec$delegate.getValue();
        }

        private final void setAnimation(TargetBasedAnimation<T, V> targetBasedAnimation) {
            this.animation$delegate.setValue(targetBasedAnimation);
        }

        public final TargetBasedAnimation<T, V> getAnimation() {
            return (TargetBasedAnimation) this.animation$delegate.getValue();
        }

        public final boolean isFinished$animation_core_release() {
            return ((Boolean) this.isFinished$delegate.getValue()).booleanValue();
        }

        public final void setFinished$animation_core_release(boolean z) {
            this.isFinished$delegate.setValue(Boolean.valueOf(z));
        }

        private final long getOffsetTimeNanos() {
            return ((Number) this.offsetTimeNanos$delegate.getValue()).longValue();
        }

        private final void setOffsetTimeNanos(long j) {
            this.offsetTimeNanos$delegate.setValue(Long.valueOf(j));
        }

        private final boolean getNeedsReset() {
            return ((Boolean) this.needsReset$delegate.getValue()).booleanValue();
        }

        private final void setNeedsReset(boolean z) {
            this.needsReset$delegate.setValue(Boolean.valueOf(z));
        }

        public T getValue() {
            return this.value$delegate.getValue();
        }

        public void setValue$animation_core_release(T t) {
            this.value$delegate.setValue(t);
        }

        public final long getDurationNanos$animation_core_release() {
            return getAnimation().getDurationNanos();
        }

        public final void onPlayTimeChanged$animation_core_release(long playTimeNanos, float durationScale) {
            long playTime;
            if (durationScale > 0.0f) {
                float scaledTime = ((float) (playTimeNanos - getOffsetTimeNanos())) / durationScale;
                if (!Float.isNaN(scaledTime)) {
                    playTime = (long) scaledTime;
                } else {
                    throw new IllegalStateException(("Duration scale adjusted time is NaN. Duration scale: " + durationScale + ",playTimeNanos: " + playTimeNanos + ", offsetTimeNanos: " + getOffsetTimeNanos()).toString());
                }
            } else {
                playTime = getAnimation().getDurationNanos();
            }
            setValue$animation_core_release(getAnimation().getValueFromNanos(playTime));
            this.velocityVector = getAnimation().getVelocityVectorFromNanos(playTime);
            if (getAnimation().isFinishedFromNanos(playTime)) {
                setFinished$animation_core_release(true);
                setOffsetTimeNanos(0);
            }
        }

        public final void seekTo$animation_core_release(long playTimeNanos) {
            setValue$animation_core_release(getAnimation().getValueFromNanos(playTimeNanos));
            this.velocityVector = getAnimation().getVelocityVectorFromNanos(playTimeNanos);
        }

        static /* synthetic */ void updateAnimation$default(TransitionAnimationState transitionAnimationState, Object obj, boolean z, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = transitionAnimationState.getValue();
            }
            if ((i & 2) != 0) {
                z = false;
            }
            transitionAnimationState.updateAnimation(obj, z);
        }

        private final void updateAnimation(T initialValue, boolean isInterrupted) {
            FiniteAnimationSpec<T> finiteAnimationSpec;
            if (isInterrupted) {
                finiteAnimationSpec = getAnimationSpec() instanceof SpringSpec ? getAnimationSpec() : this.interruptionSpec;
            } else {
                finiteAnimationSpec = getAnimationSpec();
            }
            setAnimation(new TargetBasedAnimation(finiteAnimationSpec, this.typeConverter, initialValue, getTargetValue(), this.velocityVector));
            this.this$0.onChildAnimationUpdated();
        }

        public final void resetAnimation$animation_core_release() {
            setNeedsReset(true);
        }

        public final void updateTargetValue$animation_core_release(T targetValue, FiniteAnimationSpec<T> animationSpec) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            if (!Intrinsics.areEqual(getTargetValue(), (Object) targetValue) || getNeedsReset()) {
                setTargetValue(targetValue);
                setAnimationSpec(animationSpec);
                updateAnimation$default(this, (Object) null, !isFinished$animation_core_release(), 1, (Object) null);
                setFinished$animation_core_release(false);
                setOffsetTimeNanos(this.this$0.getPlayTimeNanos());
                setNeedsReset(false);
            }
        }

        public final void updateInitialAndTargetValue$animation_core_release(T initialValue, T targetValue, FiniteAnimationSpec<T> animationSpec) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            setTargetValue(targetValue);
            setAnimationSpec(animationSpec);
            if (!Intrinsics.areEqual(getAnimation().getInitialValue(), (Object) initialValue) || !Intrinsics.areEqual(getAnimation().getTargetValue(), (Object) targetValue)) {
                updateAnimation$default(this, initialValue, false, 2, (Object) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0003\u001a\u00028\u0001X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00028\u0001X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/compose/animation/core/Transition$SegmentImpl;", "S", "Landroidx/compose/animation/core/Transition$Segment;", "initialState", "targetState", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getInitialState", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTargetState", "equals", "", "other", "", "hashCode", "", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Transition.kt */
    private static final class SegmentImpl<S> implements Segment<S> {
        private final S initialState;
        private final S targetState;

        public SegmentImpl(S initialState2, S targetState2) {
            this.initialState = initialState2;
            this.targetState = targetState2;
        }

        public S getInitialState() {
            return this.initialState;
        }

        public S getTargetState() {
            return this.targetState;
        }

        public boolean equals(Object other) {
            return (other instanceof Segment) && Intrinsics.areEqual(getInitialState(), ((Segment) other).getInitialState()) && Intrinsics.areEqual(getTargetState(), ((Segment) other).getTargetState());
        }

        public int hashCode() {
            Object initialState2 = getInitialState();
            int i = 0;
            int hashCode = (initialState2 != null ? initialState2.hashCode() : 0) * 31;
            Object targetState2 = getTargetState();
            if (targetState2 != null) {
                i = targetState2.hashCode();
            }
            return hashCode + i;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u001a\u0010\b\u001a\u00020\t*\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0001H\u0004¢\u0006\u0002\u0010\nR\u0012\u0010\u0003\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Landroidx/compose/animation/core/Transition$Segment;", "S", "", "initialState", "getInitialState", "()Ljava/lang/Object;", "targetState", "getTargetState", "isTransitioningTo", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Transition.kt */
    public interface Segment<S> {
        S getInitialState();

        S getTargetState();

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* compiled from: Transition.kt */
        public static final class DefaultImpls {
            @Deprecated
            public static <S> boolean isTransitioningTo(Segment<S> $this, S $receiver, S targetState) {
                return Segment.super.isTransitioningTo($receiver, targetState);
            }
        }

        boolean isTransitioningTo(S $this$isTransitioningTo, S targetState) {
            return Intrinsics.areEqual((Object) $this$isTransitioningTo, getInitialState()) && Intrinsics.areEqual((Object) targetState, getTargetState());
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\b\b\u0002\u0010\u0002*\u00020\u00032\u00020\u0004:\u0001&B#\b\u0000\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJT\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00192#\u0010\u001a\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001d0\u001b¢\u0006\u0002\b\u001e2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00028\u00010\u001bJ\r\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%R{\u0010\r\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000bR\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000R\b\u0012\u0004\u0012\u00028\u00000\f2.\u0010\n\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000bR\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000R\b\u0012\u0004\u0012\u00028\u00000\f8@@@X\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Landroidx/compose/animation/core/Transition$DeferredAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "label", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "<set-?>", "Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "Landroidx/compose/animation/core/Transition;", "data", "getData$animation_core_release", "()Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "setData$animation_core_release", "(Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;)V", "data$delegate", "Landroidx/compose/runtime/MutableState;", "getLabel", "()Ljava/lang/String;", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "animate", "Landroidx/compose/runtime/State;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "setupSeeking", "", "setupSeeking$animation_core_release", "DeferredAnimationData", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Transition.kt */
    public final class DeferredAnimation<T, V extends AnimationVector> {
        private final MutableState data$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        private final String label;
        final /* synthetic */ Transition<S> this$0;
        private final TwoWayConverter<T, V> typeConverter;

        public DeferredAnimation(Transition this$02, TwoWayConverter<T, V> typeConverter2, String label2) {
            Intrinsics.checkNotNullParameter(typeConverter2, "typeConverter");
            Intrinsics.checkNotNullParameter(label2, "label");
            this.this$0 = this$02;
            this.typeConverter = typeConverter2;
            this.label = label2;
        }

        public final TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        public final String getLabel() {
            return this.label;
        }

        public final Transition<S>.DeferredAnimation<T, V>.DeferredAnimationData<T, V> getData$animation_core_release() {
            return (DeferredAnimationData) this.data$delegate.getValue();
        }

        public final void setData$animation_core_release(Transition<S>.DeferredAnimation<T, V>.DeferredAnimationData<T, V> deferredAnimationData) {
            this.data$delegate.setValue(deferredAnimationData);
        }

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u0000*\u0004\b\u0003\u0010\u0001*\b\b\u0004\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004Bk\u0012\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012#\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000b0\t¢\u0006\u0002\b\f\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00030\t¢\u0006\u0002\u0010\u0011J\u0014\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\nR'\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R5\u0010\r\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00030\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R7\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000b0\t¢\u0006\u0002\b\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00028\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "animation", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "Landroidx/compose/animation/core/Transition;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$TransitionAnimationState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getAnimation", "()Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "getTargetValueByState", "()Lkotlin/jvm/functions/Function1;", "setTargetValueByState", "(Lkotlin/jvm/functions/Function1;)V", "getTransitionSpec", "setTransitionSpec", "value", "getValue", "()Ljava/lang/Object;", "updateAnimationStates", "", "segment", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: Transition.kt */
        public final class DeferredAnimationData<T, V extends AnimationVector> implements State<T> {
            private final Transition<S>.TransitionAnimationState<T, V> animation;
            private Function1<? super S, ? extends T> targetValueByState;
            final /* synthetic */ Transition<S>.DeferredAnimation<T, V> this$0;
            private Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> transitionSpec;

            public DeferredAnimationData(DeferredAnimation this$02, Transition<S>.TransitionAnimationState<T, V> animation2, Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> transitionSpec2, Function1<? super S, ? extends T> targetValueByState2) {
                Intrinsics.checkNotNullParameter(animation2, "animation");
                Intrinsics.checkNotNullParameter(transitionSpec2, "transitionSpec");
                Intrinsics.checkNotNullParameter(targetValueByState2, "targetValueByState");
                this.this$0 = this$02;
                this.animation = animation2;
                this.transitionSpec = transitionSpec2;
                this.targetValueByState = targetValueByState2;
            }

            public final Transition<S>.TransitionAnimationState<T, V> getAnimation() {
                return this.animation;
            }

            public final Function1<Segment<S>, FiniteAnimationSpec<T>> getTransitionSpec() {
                return this.transitionSpec;
            }

            public final void setTransitionSpec(Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> function1) {
                Intrinsics.checkNotNullParameter(function1, "<set-?>");
                this.transitionSpec = function1;
            }

            public final Function1<S, T> getTargetValueByState() {
                return this.targetValueByState;
            }

            public final void setTargetValueByState(Function1<? super S, ? extends T> function1) {
                Intrinsics.checkNotNullParameter(function1, "<set-?>");
                this.targetValueByState = function1;
            }

            public final void updateAnimationStates(Segment<S> segment) {
                Intrinsics.checkNotNullParameter(segment, "segment");
                Object targetValue = this.targetValueByState.invoke(segment.getTargetState());
                if (this.this$0.this$0.isSeeking()) {
                    this.animation.updateInitialAndTargetValue$animation_core_release(this.targetValueByState.invoke(segment.getInitialState()), targetValue, (FiniteAnimationSpec) this.transitionSpec.invoke(segment));
                    return;
                }
                this.animation.updateTargetValue$animation_core_release(targetValue, (FiniteAnimationSpec) this.transitionSpec.invoke(segment));
            }

            public T getValue() {
                updateAnimationStates(this.this$0.this$0.getSegment());
                return this.animation.getValue();
            }
        }

        public final State<T> animate(Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> transitionSpec, Function1<? super S, ? extends T> targetValueByState) {
            Intrinsics.checkNotNullParameter(transitionSpec, "transitionSpec");
            Intrinsics.checkNotNullParameter(targetValueByState, "targetValueByState");
            DeferredAnimationData animData = getData$animation_core_release();
            if (animData == null) {
                Transition<S> transition = this.this$0;
                animData = new DeferredAnimationData(this, new TransitionAnimationState(transition, targetValueByState.invoke(transition.getCurrentState()), AnimationStateKt.createZeroVectorFrom(this.typeConverter, targetValueByState.invoke(this.this$0.getCurrentState())), this.typeConverter, this.label), transitionSpec, targetValueByState);
                Transition<S> transition2 = this.this$0;
                DeferredAnimationData $this$animate_u24lambda_u240 = animData;
                setData$animation_core_release($this$animate_u24lambda_u240);
                transition2.addAnimation$animation_core_release($this$animate_u24lambda_u240.getAnimation());
            }
            Transition<S> transition3 = this.this$0;
            DeferredAnimationData $this$animate_u24lambda_u241 = animData;
            $this$animate_u24lambda_u241.setTargetValueByState(targetValueByState);
            $this$animate_u24lambda_u241.setTransitionSpec(transitionSpec);
            $this$animate_u24lambda_u241.updateAnimationStates(transition3.getSegment());
            return animData;
        }

        public final void setupSeeking$animation_core_release() {
            DeferredAnimationData $this$setupSeeking_u24lambda_u242 = getData$animation_core_release();
            if ($this$setupSeeking_u24lambda_u242 != null) {
                Transition<S> transition = this.this$0;
                $this$setupSeeking_u24lambda_u242.getAnimation().updateInitialAndTargetValue$animation_core_release($this$setupSeeking_u24lambda_u242.getTargetValueByState().invoke(transition.getSegment().getInitialState()), $this$setupSeeking_u24lambda_u242.getTargetValueByState().invoke(transition.getSegment().getTargetState()), (FiniteAnimationSpec) $this$setupSeeking_u24lambda_u242.getTransitionSpec().invoke(transition.getSegment()));
            }
        }
    }

    public final void removeAnimation$animation_core_release(Transition<S>.DeferredAnimation<?, ?> deferredAnimation) {
        TransitionAnimationState it;
        Intrinsics.checkNotNullParameter(deferredAnimation, "deferredAnimation");
        DeferredAnimation.DeferredAnimationData<?, ?> data$animation_core_release = deferredAnimation.getData$animation_core_release();
        if (data$animation_core_release != null && (it = data$animation_core_release.getAnimation()) != null) {
            removeAnimation$animation_core_release((Transition<S>.TransitionAnimationState<?, ?>) it);
        }
    }
}
