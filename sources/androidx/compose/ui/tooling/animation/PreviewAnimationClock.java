package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.DecayAnimation;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.ui.tooling.animation.AnimationSearch;
import androidx.compose.ui.tooling.animation.clock.AnimateXAsStateClock;
import androidx.compose.ui.tooling.animation.clock.AnimatedVisibilityClock;
import androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock;
import androidx.compose.ui.tooling.animation.clock.InfiniteTransitionClock;
import androidx.compose.ui.tooling.animation.clock.TransitionClock;
import androidx.compose.ui.tooling.animation.clock.UtilsKt;
import androidx.compose.ui.tooling.animation.states.AnimatedVisibilityState;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0010\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u00105\u001a\u00020\u0004J\u001a\u00106\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\f2\u0006\u00107\u001a\u000208H\u0002J\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u000b2\u0006\u00107\u001a\u000208J\u001e\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u000208ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b>\u0010?J\u0006\u0010@\u001a\u00020AJ\u0006\u0010B\u001a\u00020AJ\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u000b2\u0006\u00107\u001a\u0002082\u0006\u0010E\u001a\u00020AJ\u0010\u0010F\u001a\u00020\u00042\u0006\u00107\u001a\u000208H\u0015J\u0010\u0010G\u001a\u00020\u00042\u0006\u00107\u001a\u000208H\u0015J\u000e\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020AJ\u001a\u0010J\u001a\u00020\u00042\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020A0KJ\u000e\u0010L\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0001J\u0016\u0010M\u001a\u00020\u00042\u000e\u00107\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030NJ\u0012\u0010O\u001a\u00020\u00042\n\u00107\u001a\u0006\u0012\u0002\b\u00030PJ\"\u0010Q\u001a\u00020\u00042\n\u00107\u001a\u0006\u0012\u0002\b\u00030P2\u000e\b\u0002\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J$\u0010S\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00012\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040UH\u0002J\u0016\u0010V\u001a\u00020\u00042\u000e\u00107\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030WJ\u000e\u0010X\u001a\u00020\u00042\u0006\u00107\u001a\u00020YJ\u0016\u0010Z\u001a\u00020\u00042\u000e\u00107\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030[J\u0012\u0010\\\u001a\u00020\u00042\n\u00107\u001a\u0006\u0012\u0002\b\u00030PJ\u0018\u0010]\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00012\u0006\u0010^\u001a\u00020\tH\u0002J\u0016\u0010_\u001a\u00020\u00042\u0006\u0010=\u001a\u0002082\u0006\u0010`\u001a\u00020\u0001J\u001e\u0010a\u001a\u00020\u00042\u0006\u0010=\u001a\u0002082\u0006\u0010b\u001a\u00020\u00012\u0006\u0010c\u001a\u00020\u0001R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f0\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f0\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR8\u0010\u0011\u001a\u001e\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0013\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00140\u00128\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R0\u0010\u0019\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u00128\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018R(\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u00128\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018R(\u0010#\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0\u00128\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010\u0018R\u000e\u0010(\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00010*j\b\u0012\u0004\u0012\u00020\u0001`+X\u0004¢\u0006\u0002\n\u0000R,\u0010,\u001a\u0012\u0012\u0004\u0012\u00020-0*j\b\u0012\u0004\u0012\u00020-`+8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0016\u001a\u0004\b/\u00100R0\u00101\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u000302\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u00128\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u0016\u001a\u0004\b4\u0010\u0018\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006d"}, d2 = {"Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "", "setAnimationsTimeCallback", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "DEBUG", "", "TAG", "", "allClocks", "", "Landroidx/compose/ui/tooling/animation/clock/ComposeAnimationClock;", "getAllClocks", "()Ljava/util/List;", "allClocksExceptInfinite", "getAllClocksExceptInfinite", "animateXAsStateClocks", "", "Landroidx/compose/ui/tooling/animation/AnimateXAsStateComposeAnimation;", "Landroidx/compose/ui/tooling/animation/clock/AnimateXAsStateClock;", "getAnimateXAsStateClocks$ui_tooling_release$annotations", "()V", "getAnimateXAsStateClocks$ui_tooling_release", "()Ljava/util/Map;", "animatedContentClocks", "Landroidx/compose/ui/tooling/animation/AnimatedContentComposeAnimation;", "Landroidx/compose/ui/tooling/animation/clock/TransitionClock;", "getAnimatedContentClocks$ui_tooling_release$annotations", "getAnimatedContentClocks$ui_tooling_release", "animatedVisibilityClocks", "Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;", "Landroidx/compose/ui/tooling/animation/clock/AnimatedVisibilityClock;", "getAnimatedVisibilityClocks$ui_tooling_release$annotations", "getAnimatedVisibilityClocks$ui_tooling_release", "infiniteTransitionClocks", "Landroidx/compose/ui/tooling/animation/InfiniteTransitionComposeAnimation;", "Landroidx/compose/ui/tooling/animation/clock/InfiniteTransitionClock;", "getInfiniteTransitionClocks$ui_tooling_release$annotations", "getInfiniteTransitionClocks$ui_tooling_release", "lock", "trackedAnimations", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "trackedUnsupportedAnimations", "Landroidx/compose/ui/tooling/animation/UnsupportedComposeAnimation;", "getTrackedUnsupportedAnimations$annotations", "getTrackedUnsupportedAnimations", "()Ljava/util/LinkedHashSet;", "transitionClocks", "Landroidx/compose/ui/tooling/animation/TransitionComposeAnimation;", "getTransitionClocks$ui_tooling_release$annotations", "getTransitionClocks$ui_tooling_release", "dispose", "findClock", "animation", "Landroidx/compose/animation/tooling/ComposeAnimation;", "getAnimatedProperties", "Landroidx/compose/animation/tooling/ComposeAnimatedProperty;", "getAnimatedVisibilityState", "Landroidx/compose/ui/tooling/animation/states/AnimatedVisibilityState;", "composeAnimation", "getAnimatedVisibilityState-cc2g1to", "(Landroidx/compose/animation/tooling/ComposeAnimation;)Ljava/lang/String;", "getMaxDuration", "", "getMaxDurationPerIteration", "getTransitions", "Landroidx/compose/animation/tooling/TransitionInfo;", "stepMillis", "notifySubscribe", "notifyUnsubscribe", "setClockTime", "animationTimeMillis", "setClockTimes", "", "trackAnimateContentSize", "trackAnimateXAsState", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearchInfo;", "trackAnimatedContent", "Landroidx/compose/animation/core/Transition;", "trackAnimatedVisibility", "onSeek", "trackAnimation", "createClockAndSubscribe", "Lkotlin/Function1;", "trackDecayAnimations", "Landroidx/compose/animation/core/DecayAnimation;", "trackInfiniteTransition", "Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearchInfo;", "trackTargetBasedAnimations", "Landroidx/compose/animation/core/TargetBasedAnimation;", "trackTransition", "trackUnsupported", "label", "updateAnimatedVisibilityState", "state", "updateFromAndToStates", "fromState", "toState", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PreviewAnimationClock.kt */
public class PreviewAnimationClock {
    private final boolean DEBUG;
    private final String TAG;
    private final Map<AnimateXAsStateComposeAnimation<?, ?>, AnimateXAsStateClock<?, ?>> animateXAsStateClocks;
    private final Map<AnimatedContentComposeAnimation<?>, TransitionClock<?>> animatedContentClocks;
    private final Map<AnimatedVisibilityComposeAnimation, AnimatedVisibilityClock> animatedVisibilityClocks;
    private final Map<InfiniteTransitionComposeAnimation, InfiniteTransitionClock> infiniteTransitionClocks;
    private final Object lock;
    private final Function0<Unit> setAnimationsTimeCallback;
    private final LinkedHashSet<Object> trackedAnimations;
    private final LinkedHashSet<UnsupportedComposeAnimation> trackedUnsupportedAnimations;
    private final Map<TransitionComposeAnimation<?>, TransitionClock<?>> transitionClocks;

    public PreviewAnimationClock() {
        this((Function0) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ void getAnimateXAsStateClocks$ui_tooling_release$annotations() {
    }

    public static /* synthetic */ void getAnimatedContentClocks$ui_tooling_release$annotations() {
    }

    public static /* synthetic */ void getAnimatedVisibilityClocks$ui_tooling_release$annotations() {
    }

    public static /* synthetic */ void getInfiniteTransitionClocks$ui_tooling_release$annotations() {
    }

    public static /* synthetic */ void getTrackedUnsupportedAnimations$annotations() {
    }

    public static /* synthetic */ void getTransitionClocks$ui_tooling_release$annotations() {
    }

    public PreviewAnimationClock(Function0<Unit> setAnimationsTimeCallback2) {
        Intrinsics.checkNotNullParameter(setAnimationsTimeCallback2, "setAnimationsTimeCallback");
        this.setAnimationsTimeCallback = setAnimationsTimeCallback2;
        this.TAG = "PreviewAnimationClock";
        this.transitionClocks = new LinkedHashMap();
        this.animatedVisibilityClocks = new LinkedHashMap();
        this.animateXAsStateClocks = new LinkedHashMap();
        this.infiniteTransitionClocks = new LinkedHashMap();
        this.animatedContentClocks = new LinkedHashMap();
        this.trackedUnsupportedAnimations = new LinkedHashSet<>();
        this.trackedAnimations = new LinkedHashSet<>();
        this.lock = new Object();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PreviewAnimationClock(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AnonymousClass1.INSTANCE : function0);
    }

    public final Map<TransitionComposeAnimation<?>, TransitionClock<?>> getTransitionClocks$ui_tooling_release() {
        return this.transitionClocks;
    }

    public final Map<AnimatedVisibilityComposeAnimation, AnimatedVisibilityClock> getAnimatedVisibilityClocks$ui_tooling_release() {
        return this.animatedVisibilityClocks;
    }

    public final Map<AnimateXAsStateComposeAnimation<?, ?>, AnimateXAsStateClock<?, ?>> getAnimateXAsStateClocks$ui_tooling_release() {
        return this.animateXAsStateClocks;
    }

    public final Map<InfiniteTransitionComposeAnimation, InfiniteTransitionClock> getInfiniteTransitionClocks$ui_tooling_release() {
        return this.infiniteTransitionClocks;
    }

    public final Map<AnimatedContentComposeAnimation<?>, TransitionClock<?>> getAnimatedContentClocks$ui_tooling_release() {
        return this.animatedContentClocks;
    }

    /* access modifiers changed from: private */
    public final List<ComposeAnimationClock<?, ?>> getAllClocksExceptInfinite() {
        return CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(this.transitionClocks.values(), this.animatedVisibilityClocks.values()), this.animateXAsStateClocks.values()), this.animatedContentClocks.values());
    }

    private final List<ComposeAnimationClock<?, ?>> getAllClocks() {
        return CollectionsKt.plus(getAllClocksExceptInfinite(), this.infiniteTransitionClocks.values());
    }

    private final ComposeAnimationClock<?, ?> findClock(ComposeAnimation animation) {
        ComposeAnimationClock<?, ?> composeAnimationClock = this.transitionClocks.get(animation);
        if (composeAnimationClock == null && (composeAnimationClock = this.animatedVisibilityClocks.get(animation)) == null && (composeAnimationClock = this.animateXAsStateClocks.get(animation)) == null && (composeAnimationClock = this.infiniteTransitionClocks.get(animation)) == null) {
            return this.animatedContentClocks.get(animation);
        }
        return composeAnimationClock;
    }

    public final void trackTransition(Transition<?> animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        trackAnimation(animation, new PreviewAnimationClock$trackTransition$1(animation, this));
    }

    public static /* synthetic */ void trackAnimatedVisibility$default(PreviewAnimationClock previewAnimationClock, Transition transition, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = PreviewAnimationClock$trackAnimatedVisibility$1.INSTANCE;
            }
            previewAnimationClock.trackAnimatedVisibility(transition, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackAnimatedVisibility");
    }

    public final void trackAnimatedVisibility(Transition<?> animation, Function0<Unit> onSeek) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(onSeek, "onSeek");
        if (animation.getCurrentState() instanceof Boolean) {
            trackAnimation(animation, new PreviewAnimationClock$trackAnimatedVisibility$2(animation, onSeek, this));
        }
    }

    public final void trackAnimateXAsState(AnimationSearch.AnimateXAsStateSearchInfo<?, ?> animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        trackAnimation(animation.getAnimatable(), new PreviewAnimationClock$trackAnimateXAsState$1(animation, this));
    }

    public final void trackAnimateContentSize(Object animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        trackUnsupported(animation, "animateContentSize");
    }

    public final void trackTargetBasedAnimations(TargetBasedAnimation<?, ?> animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        trackUnsupported(animation, "TargetBasedAnimation");
    }

    public final void trackDecayAnimations(DecayAnimation<?, ?> animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        trackUnsupported(animation, "DecayAnimation");
    }

    public final void trackAnimatedContent(Transition<?> animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        trackAnimation(animation, new PreviewAnimationClock$trackAnimatedContent$1(animation, this));
    }

    public final void trackInfiniteTransition(AnimationSearch.InfiniteTransitionSearchInfo animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        trackAnimation(animation.getInfiniteTransition(), new PreviewAnimationClock$trackInfiniteTransition$1(animation, this));
    }

    public final LinkedHashSet<UnsupportedComposeAnimation> getTrackedUnsupportedAnimations() {
        return this.trackedUnsupportedAnimations;
    }

    private final void trackUnsupported(Object animation, String label) {
        trackAnimation(animation, new PreviewAnimationClock$trackUnsupported$1(label, this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
        r7.invoke(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r5.DEBUG == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        android.util.Log.d(r5.TAG, "Animation " + r6 + " is now tracked");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean trackAnimation(java.lang.Object r6, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.lock
            monitor-enter(r0)
            r1 = 0
            java.util.LinkedHashSet<java.lang.Object> r2 = r5.trackedAnimations     // Catch:{ all -> 0x005f }
            boolean r2 = r2.contains(r6)     // Catch:{ all -> 0x005f }
            if (r2 == 0) goto L_0x0032
            boolean r2 = r5.DEBUG     // Catch:{ all -> 0x005f }
            if (r2 == 0) goto L_0x002e
            java.lang.String r2 = r5.TAG     // Catch:{ all -> 0x005f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
            r3.<init>()     // Catch:{ all -> 0x005f }
            java.lang.String r4 = "Animation "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x005f }
            java.lang.StringBuilder r3 = r3.append(r6)     // Catch:{ all -> 0x005f }
            java.lang.String r4 = " is already being tracked"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x005f }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x005f }
            android.util.Log.d(r2, r3)     // Catch:{ all -> 0x005f }
        L_0x002e:
            monitor-exit(r0)
            r0 = 0
            return r0
        L_0x0032:
            java.util.LinkedHashSet<java.lang.Object> r2 = r5.trackedAnimations     // Catch:{ all -> 0x005f }
            r2.add(r6)     // Catch:{ all -> 0x005f }
            monitor-exit(r0)
            r7.invoke(r6)
            boolean r0 = r5.DEBUG
            if (r0 == 0) goto L_0x005d
            java.lang.String r0 = r5.TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Animation "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.String r2 = " is now tracked"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
        L_0x005d:
            r0 = 1
            return r0
        L_0x005f:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.animation.PreviewAnimationClock.trackAnimation(java.lang.Object, kotlin.jvm.functions.Function1):boolean");
    }

    /* access modifiers changed from: protected */
    public void notifySubscribe(ComposeAnimation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    /* access modifiers changed from: protected */
    public void notifyUnsubscribe(ComposeAnimation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    public final void updateFromAndToStates(ComposeAnimation composeAnimation, Object fromState, Object toState) {
        Intrinsics.checkNotNullParameter(composeAnimation, "composeAnimation");
        Intrinsics.checkNotNullParameter(fromState, "fromState");
        Intrinsics.checkNotNullParameter(toState, "toState");
        ComposeAnimationClock<?, ?> findClock = findClock(composeAnimation);
        if (findClock != null) {
            findClock.setStateParameters(fromState, toState);
        }
    }

    public final void updateAnimatedVisibilityState(ComposeAnimation composeAnimation, Object state) {
        Intrinsics.checkNotNullParameter(composeAnimation, "composeAnimation");
        Intrinsics.checkNotNullParameter(state, "state");
        AnimatedVisibilityClock animatedVisibilityClock = this.animatedVisibilityClocks.get(composeAnimation);
        if (animatedVisibilityClock != null) {
            ComposeAnimationClock.setStateParameters$default(animatedVisibilityClock, state, (Object) null, 2, (Object) null);
        }
    }

    /* renamed from: getAnimatedVisibilityState-cc2g1to  reason: not valid java name */
    public final String m5905getAnimatedVisibilityStatecc2g1to(ComposeAnimation composeAnimation) {
        Intrinsics.checkNotNullParameter(composeAnimation, "composeAnimation");
        AnimatedVisibilityClock animatedVisibilityClock = this.animatedVisibilityClocks.get(composeAnimation);
        return animatedVisibilityClock != null ? animatedVisibilityClock.m5907getStatejXw82LU() : AnimatedVisibilityState.Companion.m5916getEnterjXw82LU();
    }

    public final long getMaxDuration() {
        Comparable comparable;
        Iterator it = getAllClocks().iterator();
        if (!it.hasNext()) {
            comparable = null;
        } else {
            Comparable valueOf = Long.valueOf(((ComposeAnimationClock) it.next()).getMaxDuration());
            while (it.hasNext()) {
                Comparable valueOf2 = Long.valueOf(((ComposeAnimationClock) it.next()).getMaxDuration());
                if (valueOf.compareTo(valueOf2) < 0) {
                    valueOf = valueOf2;
                }
            }
            comparable = valueOf;
        }
        Long l = (Long) comparable;
        if (l != null) {
            return l.longValue();
        }
        return 0;
    }

    public final long getMaxDurationPerIteration() {
        Comparable comparable;
        Iterator it = getAllClocks().iterator();
        if (!it.hasNext()) {
            comparable = null;
        } else {
            Comparable valueOf = Long.valueOf(((ComposeAnimationClock) it.next()).getMaxDurationPerIteration());
            while (it.hasNext()) {
                Comparable valueOf2 = Long.valueOf(((ComposeAnimationClock) it.next()).getMaxDurationPerIteration());
                if (valueOf.compareTo(valueOf2) < 0) {
                    valueOf = valueOf2;
                }
            }
            comparable = valueOf;
        }
        Long l = (Long) comparable;
        if (l != null) {
            return l.longValue();
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = r0.getAnimatedProperties();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<androidx.compose.animation.tooling.ComposeAnimatedProperty> getAnimatedProperties(androidx.compose.animation.tooling.ComposeAnimation r2) {
        /*
            r1 = this;
            java.lang.String r0 = "animation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock r0 = r1.findClock(r2)
            if (r0 == 0) goto L_0x0011
            java.util.List r0 = r0.getAnimatedProperties()
            if (r0 != 0) goto L_0x0015
        L_0x0011:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0015:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.animation.PreviewAnimationClock.getAnimatedProperties(androidx.compose.animation.tooling.ComposeAnimation):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = r0.getTransitions(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<androidx.compose.animation.tooling.TransitionInfo> getTransitions(androidx.compose.animation.tooling.ComposeAnimation r2, long r3) {
        /*
            r1 = this;
            java.lang.String r0 = "animation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock r0 = r1.findClock(r2)
            if (r0 == 0) goto L_0x0011
            java.util.List r0 = r0.getTransitions(r3)
            if (r0 != 0) goto L_0x0015
        L_0x0011:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0015:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.animation.PreviewAnimationClock.getTransitions(androidx.compose.animation.tooling.ComposeAnimation, long):java.util.List");
    }

    public final void setClockTime(long animationTimeMillis) {
        long timeNanos = UtilsKt.millisToNanos(animationTimeMillis);
        for (ComposeAnimationClock it : getAllClocks()) {
            it.setClockTime(timeNanos);
        }
        this.setAnimationsTimeCallback.invoke();
    }

    public final void setClockTimes(Map<ComposeAnimation, Long> animationTimeMillis) {
        Intrinsics.checkNotNullParameter(animationTimeMillis, "animationTimeMillis");
        for (Map.Entry element$iv : animationTimeMillis.entrySet()) {
            long millis = ((Number) element$iv.getValue()).longValue();
            ComposeAnimationClock<?, ?> findClock = findClock((ComposeAnimation) element$iv.getKey());
            if (findClock != null) {
                findClock.setClockTime(UtilsKt.millisToNanos(millis));
            }
        }
        this.setAnimationsTimeCallback.invoke();
    }

    public final void dispose() {
        for (ComposeAnimationClock it : getAllClocks()) {
            notifyUnsubscribe(it.getAnimation());
        }
        for (ComposeAnimation notifyUnsubscribe : this.trackedUnsupportedAnimations) {
            notifyUnsubscribe(notifyUnsubscribe);
        }
        this.trackedUnsupportedAnimations.clear();
        this.transitionClocks.clear();
        this.animatedVisibilityClocks.clear();
        this.trackedAnimations.clear();
    }
}
