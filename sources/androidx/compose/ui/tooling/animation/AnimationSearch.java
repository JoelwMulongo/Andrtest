package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.DecayAnimation;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.tooling.PreviewUtilsKt;
import androidx.compose.ui.tooling.data.CallGroup;
import androidx.compose.ui.tooling.data.Group;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001:\f!\"#$%&'()*+,B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u0014\u0010\u001a\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0011H\u0002J\u0016\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00120\u0011H\u0002J\u0006\u0010\u001f\u001a\u00020\u0006J\u0016\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00120\u0018H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch;", "", "clock", "Lkotlin/Function0;", "Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "onSeek", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "animatedContentSearch", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimatedContentSearch;", "animatedVisibilitySearch", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimatedVisibilitySearch;", "hasAnimations", "", "getHasAnimations", "()Z", "setToSearch", "", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "setToTrack", "supportedSearch", "transitionSearch", "Landroidx/compose/ui/tooling/animation/AnimationSearch$TransitionSearch;", "animateXAsStateSearch", "", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearch;", "findAll", "slotTrees", "Landroidx/compose/ui/tooling/data/Group;", "infiniteTransitionSearch", "Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearch;", "trackAll", "unsupportedSearch", "AnimateContentSizeSearch", "AnimateXAsStateSearch", "AnimateXAsStateSearchInfo", "AnimatedContentSearch", "AnimatedVisibilitySearch", "DecaySearch", "InfiniteTransitionSearch", "InfiniteTransitionSearchInfo", "RememberSearch", "Search", "TargetBasedSearch", "TransitionSearch", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimationSearch.kt */
public final class AnimationSearch {
    private final AnimatedContentSearch animatedContentSearch;
    private final AnimatedVisibilitySearch animatedVisibilitySearch;
    /* access modifiers changed from: private */
    public final Function0<PreviewAnimationClock> clock;
    /* access modifiers changed from: private */
    public final Function0<Unit> onSeek;
    private final Set<Search<? extends Object>> setToSearch;
    private final Set<Search<? extends Object>> setToTrack;
    private final Set<Search<? extends Object>> supportedSearch;
    private final TransitionSearch transitionSearch = new TransitionSearch(new AnimationSearch$transitionSearch$1(this));

    public AnimationSearch(Function0<? extends PreviewAnimationClock> clock2, Function0<Unit> onSeek2) {
        Intrinsics.checkNotNullParameter(clock2, "clock");
        Intrinsics.checkNotNullParameter(onSeek2, "onSeek");
        this.clock = clock2;
        this.onSeek = onSeek2;
        AnimatedContentSearch animatedContentSearch2 = new AnimatedContentSearch(new AnimationSearch$animatedContentSearch$1(this));
        this.animatedContentSearch = animatedContentSearch2;
        this.animatedVisibilitySearch = new AnimatedVisibilitySearch(new AnimationSearch$animatedVisibilitySearch$1(this));
        Set<Search<? extends Object>> supportedSearch2 = supportedSearch();
        this.supportedSearch = supportedSearch2;
        Set<Search<? extends Object>> plus = SetsKt.plus(supportedSearch2, unsupportedSearch());
        this.setToTrack = plus;
        this.setToSearch = SetsKt.plus(plus, SetsKt.setOf(animatedContentSearch2));
    }

    private final Collection<AnimateXAsStateSearch> animateXAsStateSearch() {
        if (AnimateXAsStateComposeAnimation.Companion.getApiAvailable()) {
            return SetsKt.setOf(new AnimateXAsStateSearch(new AnimationSearch$animateXAsStateSearch$1(this)));
        }
        return CollectionsKt.emptyList();
    }

    private final Set<InfiniteTransitionSearch> infiniteTransitionSearch() {
        if (InfiniteTransitionComposeAnimation.Companion.getApiAvailable()) {
            return SetsKt.setOf(new InfiniteTransitionSearch(new AnimationSearch$infiniteTransitionSearch$1(this)));
        }
        return SetsKt.emptySet();
    }

    private final Set<Search<? extends Object>> supportedSearch() {
        return SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.setOf(this.transitionSearch, this.animatedVisibilitySearch), animateXAsStateSearch()), infiniteTransitionSearch()), AnimatedContentComposeAnimation.Companion.getApiAvailable() ? SetsKt.setOf(this.animatedContentSearch) : SetsKt.emptySet());
    }

    private final Collection<Search<? extends Object>> unsupportedSearch() {
        if (!UnsupportedComposeAnimation.Companion.getApiAvailable()) {
            return CollectionsKt.emptyList();
        }
        return SetsKt.setOf(new AnimateContentSizeSearch(new AnimationSearch$unsupportedSearch$1(this)), new TargetBasedSearch(new AnimationSearch$unsupportedSearch$2(this)), new DecaySearch(new AnimationSearch$unsupportedSearch$3(this)));
    }

    public final boolean getHasAnimations() {
        Iterable<Search> $this$any$iv = this.supportedSearch;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Search it : $this$any$iv) {
            if (it.hasAnimations()) {
                return true;
            }
        }
        return false;
    }

    public final void findAll(Collection<? extends Group> slotTrees) {
        Intrinsics.checkNotNullParameter(slotTrees, "slotTrees");
        for (Group tree : slotTrees) {
            List<Group> findAll = PreviewUtilsKt.findAll(tree, AnimationSearch$findAll$1$groupsWithLocation$1.INSTANCE);
            for (Search it : this.setToSearch) {
                it.addAnimations(findAll);
            }
            this.transitionSearch.getAnimations().removeAll(this.animatedVisibilitySearch.getAnimations());
            this.transitionSearch.getAnimations().removeAll(this.animatedContentSearch.getAnimations());
        }
    }

    public final void trackAll() {
        if (getHasAnimations()) {
            for (Search it : this.setToTrack) {
                it.track();
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0005R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "T", "", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "animations", "", "getAnimations", "()Ljava/util/Set;", "addAnimations", "groupsWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "hasAnimations", "", "track", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnimationSearch.kt */
    public static class Search<T> {
        public static final int $stable = 8;
        private final Set<T> animations = new LinkedHashSet();
        private final Function1<T, Unit> trackAnimation;

        public Search(Function1<? super T, Unit> trackAnimation2) {
            Intrinsics.checkNotNullParameter(trackAnimation2, "trackAnimation");
            this.trackAnimation = trackAnimation2;
        }

        public final Set<T> getAnimations() {
            return this.animations;
        }

        public void addAnimations(Collection<? extends Group> groupsWithLocation) {
            Intrinsics.checkNotNullParameter(groupsWithLocation, "groupsWithLocation");
        }

        public final boolean hasAnimations() {
            return !this.animations.isEmpty();
        }

        public final void track() {
            Function1 action$iv = this.trackAnimation;
            for (Object element$iv : CollectionsKt.reversed(this.animations)) {
                action$iv.invoke(element$iv);
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J0\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000f\"\b\b\u0001\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$RememberSearch;", "T", "", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "clazz", "Lkotlin/reflect/KClass;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groupsWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "findRememberCallWithType", "", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnimationSearch.kt */
    public static class RememberSearch<T> extends Search<T> {
        public static final int $stable = 8;
        private final KClass<T> clazz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RememberSearch(KClass<T> clazz2, Function1<? super T, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(clazz2, "clazz");
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
            this.clazz = clazz2;
        }

        public void addAnimations(Collection<? extends Group> groupsWithLocation) {
            Intrinsics.checkNotNullParameter(groupsWithLocation, "groupsWithLocation");
            getAnimations().addAll(CollectionsKt.toSet(findRememberCallWithType(groupsWithLocation, this.clazz)));
        }

        private final <T> List<T> findRememberCallWithType(Collection<? extends Group> $this$findRememberCallWithType, KClass<T> clazz2) {
            Iterable $this$mapNotNull$iv;
            Object obj;
            Class<?> cls;
            KClass<T> kClass = clazz2;
            Iterable<Group> $this$mapNotNull$iv2 = $this$findRememberCallWithType;
            Collection destination$iv$iv = new ArrayList();
            for (Group it : $this$mapNotNull$iv2) {
                Iterator it2 = it.getData().iterator();
                while (true) {
                    KClass<?> kClass2 = null;
                    if (!it2.hasNext()) {
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        obj = null;
                        break;
                    }
                    Object element$iv = it2.next();
                    Object data = element$iv;
                    if (!(data == null || (cls = data.getClass()) == null)) {
                        kClass2 = JvmClassMappingKt.getKotlinClass(cls);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    if (Intrinsics.areEqual((Object) kClass2, (Object) kClass)) {
                        obj = element$iv;
                        break;
                    }
                    $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                }
                Object it$iv$iv = KClasses.safeCast(kClass, obj);
                if (it$iv$iv != null) {
                    destination$iv$iv.add(it$iv$iv);
                }
                $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            }
            return (List) destination$iv$iv;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B!\u0012\u001a\u0010\u0003\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$TargetBasedSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$RememberSearch;", "Landroidx/compose/animation/core/TargetBasedAnimation;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnimationSearch.kt */
    public static final class TargetBasedSearch extends RememberSearch<TargetBasedAnimation<?, ?>> {
        public static final int $stable = 0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TargetBasedSearch(Function1<? super TargetBasedAnimation<?, ?>, Unit> trackAnimation) {
            super(Reflection.getOrCreateKotlinClass(TargetBasedAnimation.class), trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B!\u0012\u001a\u0010\u0003\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$DecaySearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$RememberSearch;", "Landroidx/compose/animation/core/DecayAnimation;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnimationSearch.kt */
    public static final class DecaySearch extends RememberSearch<DecayAnimation<?, ?>> {
        public static final int $stable = 0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DecaySearch(Function1<? super DecayAnimation<?, ?>, Unit> trackAnimation) {
            super(Reflection.getOrCreateKotlinClass(DecayAnimation.class), trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearchInfo;", "", "infiniteTransition", "Landroidx/compose/animation/core/InfiniteTransition;", "toolingState", "Landroidx/compose/ui/tooling/animation/ToolingState;", "", "(Landroidx/compose/animation/core/InfiniteTransition;Landroidx/compose/ui/tooling/animation/ToolingState;)V", "getInfiniteTransition", "()Landroidx/compose/animation/core/InfiniteTransition;", "getToolingState", "()Landroidx/compose/ui/tooling/animation/ToolingState;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnimationSearch.kt */
    public static final class InfiniteTransitionSearchInfo {
        public static final int $stable = InfiniteTransition.$stable;
        private final InfiniteTransition infiniteTransition;
        private final ToolingState<Long> toolingState;

        public static /* synthetic */ InfiniteTransitionSearchInfo copy$default(InfiniteTransitionSearchInfo infiniteTransitionSearchInfo, InfiniteTransition infiniteTransition2, ToolingState<Long> toolingState2, int i, Object obj) {
            if ((i & 1) != 0) {
                infiniteTransition2 = infiniteTransitionSearchInfo.infiniteTransition;
            }
            if ((i & 2) != 0) {
                toolingState2 = infiniteTransitionSearchInfo.toolingState;
            }
            return infiniteTransitionSearchInfo.copy(infiniteTransition2, toolingState2);
        }

        public final InfiniteTransition component1() {
            return this.infiniteTransition;
        }

        public final ToolingState<Long> component2() {
            return this.toolingState;
        }

        public final InfiniteTransitionSearchInfo copy(InfiniteTransition infiniteTransition2, ToolingState<Long> toolingState2) {
            Intrinsics.checkNotNullParameter(infiniteTransition2, "infiniteTransition");
            Intrinsics.checkNotNullParameter(toolingState2, "toolingState");
            return new InfiniteTransitionSearchInfo(infiniteTransition2, toolingState2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InfiniteTransitionSearchInfo)) {
                return false;
            }
            InfiniteTransitionSearchInfo infiniteTransitionSearchInfo = (InfiniteTransitionSearchInfo) obj;
            return Intrinsics.areEqual((Object) this.infiniteTransition, (Object) infiniteTransitionSearchInfo.infiniteTransition) && Intrinsics.areEqual((Object) this.toolingState, (Object) infiniteTransitionSearchInfo.toolingState);
        }

        public int hashCode() {
            return (this.infiniteTransition.hashCode() * 31) + this.toolingState.hashCode();
        }

        public String toString() {
            return "InfiniteTransitionSearchInfo(infiniteTransition=" + this.infiniteTransition + ", toolingState=" + this.toolingState + ')';
        }

        public InfiniteTransitionSearchInfo(InfiniteTransition infiniteTransition2, ToolingState<Long> toolingState2) {
            Intrinsics.checkNotNullParameter(infiniteTransition2, "infiniteTransition");
            Intrinsics.checkNotNullParameter(toolingState2, "toolingState");
            this.infiniteTransition = infiniteTransition2;
            this.toolingState = toolingState2;
        }

        public final InfiniteTransition getInfiniteTransition() {
            return this.infiniteTransition;
        }

        public final ToolingState<Long> getToolingState() {
            return this.toolingState;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¨\u0006\r"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearchInfo;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groupsWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "findAnimations", "", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnimationSearch.kt */
    public static final class InfiniteTransitionSearch extends Search<InfiniteTransitionSearchInfo> {
        public static final int $stable = 0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InfiniteTransitionSearch(Function1<? super InfiniteTransitionSearchInfo, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
        }

        public void addAnimations(Collection<? extends Group> groupsWithLocation) {
            Intrinsics.checkNotNullParameter(groupsWithLocation, "groupsWithLocation");
            getAnimations().addAll(findAnimations(groupsWithLocation));
        }

        private final List<InfiniteTransitionSearchInfo> findAnimations(Collection<? extends Group> groupsWithLocation) {
            Object it$iv$iv;
            Object obj;
            Object obj2;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : groupsWithLocation) {
                if (Intrinsics.areEqual((Object) ((Group) element$iv$iv).getName(), (Object) "rememberInfiniteTransition")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$filterIsInstance$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv2 : $this$filterIsInstance$iv) {
                if (element$iv$iv2 instanceof CallGroup) {
                    destination$iv$iv2.add(element$iv$iv2);
                }
            }
            Object it$iv$iv2 = (List) destination$iv$iv2;
            Iterable $this$mapNotNull$iv = (Iterable) it$iv$iv2;
            Iterable list$iv$iv$iv = null;
            Collection destination$iv$iv3 = new ArrayList();
            Iterable<CallGroup> $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
            for (CallGroup it : $this$mapNotNullTo$iv$iv) {
                Group $this$findData_u24default$iv = it;
                Object groups = it$iv$iv2;
                Collection<Object> data = $this$findData_u24default$iv.getData();
                Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                Collection destination$iv$iv$iv = (Collection) new ArrayList();
                for (Group it$iv : $this$findData_u24default$iv.getChildren()) {
                    CollectionsKt.addAll(destination$iv$iv$iv, it$iv.getData());
                    list$iv$iv$iv = list$iv$iv$iv;
                }
                Iterable $i$f$mapNotNull = list$iv$iv$iv;
                List dataToSearch$iv = CollectionsKt.plus(data, (List) destination$iv$iv$iv);
                Iterator it2 = dataToSearch$iv.iterator();
                while (true) {
                    it$iv$iv = null;
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object element$iv$iv3 = it2.next();
                    List dataToSearch$iv2 = dataToSearch$iv;
                    if (element$iv$iv3 instanceof InfiniteTransition) {
                        obj = element$iv$iv3;
                        break;
                    }
                    dataToSearch$iv = dataToSearch$iv2;
                }
                if (!(obj instanceof InfiniteTransition)) {
                    obj = null;
                }
                InfiniteTransition infiniteTransition = (InfiniteTransition) obj;
                Group $this$findData$iv = it;
                Collection<Object> data2 = $this$findData$iv.getData();
                Collection<Group> $this$flatMap$iv$iv = $this$findData$iv.getChildren();
                Iterable destination$iv$iv$iv2 = (Collection) new ArrayList();
                for (Group child$iv : $this$flatMap$iv$iv) {
                    CollectionsKt.addAll(destination$iv$iv$iv2, child$iv.getChildren());
                    $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                    $this$findData$iv = $this$findData$iv;
                }
                Iterable $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
                Iterable<Group> list$iv$iv$iv2 = CollectionsKt.plus($this$flatMap$iv$iv, (List) destination$iv$iv$iv2);
                Collection destination$iv$iv$iv3 = new ArrayList();
                for (Group it$iv2 : list$iv$iv$iv2) {
                    CollectionsKt.addAll(destination$iv$iv$iv3, it$iv2.getData());
                    list$iv$iv$iv2 = list$iv$iv$iv2;
                }
                Iterable $this$flatMap$iv$iv2 = list$iv$iv$iv2;
                List dataToSearch$iv3 = CollectionsKt.plus(data2, (List) destination$iv$iv$iv3);
                Iterator it3 = dataToSearch$iv3.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    Object element$iv$iv4 = it3.next();
                    List dataToSearch$iv4 = dataToSearch$iv3;
                    if (element$iv$iv4 instanceof MutableState) {
                        obj2 = element$iv$iv4;
                        break;
                    }
                    dataToSearch$iv3 = dataToSearch$iv4;
                }
                if (!(obj2 instanceof MutableState)) {
                    obj2 = null;
                }
                MutableState toolingOverride = (MutableState) obj2;
                if (!(infiniteTransition == null || toolingOverride == null)) {
                    if (toolingOverride.getValue() == null) {
                        toolingOverride.setValue(new ToolingState(0L));
                    }
                    Object value = toolingOverride.getValue();
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.ui.tooling.animation.ToolingState<kotlin.Long>");
                    it$iv$iv = new InfiniteTransitionSearchInfo(infiniteTransition, (ToolingState) value);
                }
                if (it$iv$iv != null) {
                    destination$iv$iv3.add(it$iv$iv);
                }
                it$iv$iv2 = groups;
                $this$mapNotNull$iv = $this$mapNotNull$iv2;
                list$iv$iv$iv = $i$f$mapNotNull;
                $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
            }
            Object groups2 = it$iv$iv2;
            return (List) destination$iv$iv3;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B5\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\bHÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\nHÆ\u0003JK\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearchInfo;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "animatable", "Landroidx/compose/animation/core/Animatable;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "toolingState", "Landroidx/compose/ui/tooling/animation/ToolingState;", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/ui/tooling/animation/ToolingState;)V", "getAnimatable", "()Landroidx/compose/animation/core/Animatable;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getToolingState", "()Landroidx/compose/ui/tooling/animation/ToolingState;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnimationSearch.kt */
    public static final class AnimateXAsStateSearchInfo<T, V extends AnimationVector> {
        public static final int $stable = 8;
        private final Animatable<T, V> animatable;
        private final AnimationSpec<T> animationSpec;
        private final ToolingState<T> toolingState;

        public static /* synthetic */ AnimateXAsStateSearchInfo copy$default(AnimateXAsStateSearchInfo animateXAsStateSearchInfo, Animatable<T, V> animatable2, AnimationSpec<T> animationSpec2, ToolingState<T> toolingState2, int i, Object obj) {
            if ((i & 1) != 0) {
                animatable2 = animateXAsStateSearchInfo.animatable;
            }
            if ((i & 2) != 0) {
                animationSpec2 = animateXAsStateSearchInfo.animationSpec;
            }
            if ((i & 4) != 0) {
                toolingState2 = animateXAsStateSearchInfo.toolingState;
            }
            return animateXAsStateSearchInfo.copy(animatable2, animationSpec2, toolingState2);
        }

        public final Animatable<T, V> component1() {
            return this.animatable;
        }

        public final AnimationSpec<T> component2() {
            return this.animationSpec;
        }

        public final ToolingState<T> component3() {
            return this.toolingState;
        }

        public final AnimateXAsStateSearchInfo<T, V> copy(Animatable<T, V> animatable2, AnimationSpec<T> animationSpec2, ToolingState<T> toolingState2) {
            Intrinsics.checkNotNullParameter(animatable2, "animatable");
            Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
            Intrinsics.checkNotNullParameter(toolingState2, "toolingState");
            return new AnimateXAsStateSearchInfo<>(animatable2, animationSpec2, toolingState2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnimateXAsStateSearchInfo)) {
                return false;
            }
            AnimateXAsStateSearchInfo animateXAsStateSearchInfo = (AnimateXAsStateSearchInfo) obj;
            return Intrinsics.areEqual((Object) this.animatable, (Object) animateXAsStateSearchInfo.animatable) && Intrinsics.areEqual((Object) this.animationSpec, (Object) animateXAsStateSearchInfo.animationSpec) && Intrinsics.areEqual((Object) this.toolingState, (Object) animateXAsStateSearchInfo.toolingState);
        }

        public int hashCode() {
            return (((this.animatable.hashCode() * 31) + this.animationSpec.hashCode()) * 31) + this.toolingState.hashCode();
        }

        public String toString() {
            return "AnimateXAsStateSearchInfo(animatable=" + this.animatable + ", animationSpec=" + this.animationSpec + ", toolingState=" + this.toolingState + ')';
        }

        public AnimateXAsStateSearchInfo(Animatable<T, V> animatable2, AnimationSpec<T> animationSpec2, ToolingState<T> toolingState2) {
            Intrinsics.checkNotNullParameter(animatable2, "animatable");
            Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
            Intrinsics.checkNotNullParameter(toolingState2, "toolingState");
            this.animatable = animatable2;
            this.animationSpec = animationSpec2;
            this.toolingState = toolingState2;
        }

        public final Animatable<T, V> getAnimatable() {
            return this.animatable;
        }

        public final AnimationSpec<T> getAnimationSpec() {
            return this.animationSpec;
        }

        public final ToolingState<T> getToolingState() {
            return this.toolingState;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B!\u0012\u001a\u0010\u0003\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J$\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u0002H\r\u0018\u00010\u0012\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J.\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u000e0\u00020\u0014\"\u0004\b\u0000\u0010\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearchInfo;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groupsWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "findAnimatable", "Landroidx/compose/animation/core/Animatable;", "T", "Landroidx/compose/animation/core/AnimationVector;", "group", "Landroidx/compose/ui/tooling/data/CallGroup;", "findAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "findAnimations", "", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnimationSearch.kt */
    public static final class AnimateXAsStateSearch extends Search<AnimateXAsStateSearchInfo<?, ?>> {
        public static final int $stable = 0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AnimateXAsStateSearch(Function1<? super AnimateXAsStateSearchInfo<?, ?>, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
        }

        public void addAnimations(Collection<? extends Group> groupsWithLocation) {
            Intrinsics.checkNotNullParameter(groupsWithLocation, "groupsWithLocation");
            getAnimations().addAll(findAnimations(groupsWithLocation));
        }

        private final <T> List<AnimateXAsStateSearchInfo<T, AnimationVector>> findAnimations(Collection<? extends Group> groupsWithLocation) {
            Object it$iv$iv;
            List rememberCalls$iv;
            Object obj;
            Iterable $this$mapNotNull$iv;
            Object obj2;
            AnimateXAsStateSearch animateXAsStateSearch = this;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : groupsWithLocation) {
                if (Intrinsics.areEqual((Object) ((Group) element$iv$iv).getName(), (Object) "animateValueAsState")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$filterIsInstance$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv2 : $this$filterIsInstance$iv) {
                if (element$iv$iv2 instanceof CallGroup) {
                    destination$iv$iv2.add(element$iv$iv2);
                }
            }
            List groups = (List) destination$iv$iv2;
            Iterable $this$mapNotNull$iv2 = groups;
            int $i$f$mapNotNull = 0;
            Collection destination$iv$iv3 = new ArrayList();
            Iterable<CallGroup> $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv2;
            for (CallGroup it : $this$mapNotNullTo$iv$iv) {
                Animatable animatable = animateXAsStateSearch.findAnimatable(it);
                List groups2 = groups;
                AnimationSpec spec = animateXAsStateSearch.findAnimationSpec(it);
                Object children = it.getChildren();
                Collection destination$iv$iv$iv = new ArrayList();
                Iterator it2 = ((Iterable) children).iterator();
                while (true) {
                    it$iv$iv = null;
                    if (!it2.hasNext()) {
                        break;
                    }
                    Iterator it3 = ((Group) it2.next()).getData().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            $this$mapNotNull$iv = $this$mapNotNull$iv2;
                            obj2 = null;
                            break;
                        }
                        Object element$iv$iv3 = it3.next();
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        if (element$iv$iv3 instanceof MutableState) {
                            obj2 = element$iv$iv3;
                            break;
                        }
                        $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                    }
                    int $this$firstOrNull$iv$iv = $i$f$mapNotNull;
                    if ((obj2 instanceof MutableState) != 0) {
                        it$iv$iv = obj2;
                    }
                    Object it$iv$iv$iv = (MutableState) it$iv$iv;
                    if (it$iv$iv$iv != null) {
                        destination$iv$iv$iv.add(it$iv$iv$iv);
                    }
                    $i$f$mapNotNull = $this$firstOrNull$iv$iv;
                    $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                }
                Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv2;
                int $i$f$mapNotNull2 = $i$f$mapNotNull;
                List selfData$iv = (List) destination$iv$iv$iv;
                Object<Group> it$iv$iv$iv2 = (Iterable) children;
                Collection destination$iv$iv$iv2 = new ArrayList();
                for (Group it$iv : it$iv$iv$iv2) {
                    Object $this$mapNotNull$iv$iv = it$iv$iv$iv2;
                    Iterable $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
                    Object it$iv$iv$iv3 = PreviewUtilsKt.firstOrNull(it$iv, AnimationSearchKt$findRememberedData$rememberCalls$1$1.INSTANCE);
                    if (it$iv$iv$iv3 != null) {
                        destination$iv$iv$iv2.add(it$iv$iv$iv3);
                    }
                    it$iv$iv$iv2 = $this$mapNotNull$iv$iv;
                    $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                }
                Object $this$mapNotNull$iv$iv2 = it$iv$iv$iv2;
                Iterable $this$mapNotNullTo$iv$iv3 = $this$mapNotNullTo$iv$iv;
                List rememberCalls$iv2 = (List) destination$iv$iv$iv2;
                Collection collection = selfData$iv;
                Iterable<Group> $this$mapNotNull$iv$iv3 = rememberCalls$iv2;
                List list = selfData$iv;
                Collection destination$iv$iv$iv3 = new ArrayList();
                for (Group it$iv2 : $this$mapNotNull$iv$iv3) {
                    Iterator it4 = it$iv2.getData().iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            rememberCalls$iv = rememberCalls$iv2;
                            obj = null;
                            break;
                        }
                        Object element$iv$iv4 = it4.next();
                        rememberCalls$iv = rememberCalls$iv2;
                        if (element$iv$iv4 instanceof MutableState) {
                            obj = element$iv$iv4;
                            break;
                        }
                        rememberCalls$iv2 = rememberCalls$iv;
                    }
                    Iterable $this$firstOrNull$iv$iv2 = $this$mapNotNull$iv$iv3;
                    if (!(obj instanceof MutableState)) {
                        obj = null;
                    }
                    Object it$iv$iv$iv4 = (MutableState) obj;
                    if (it$iv$iv$iv4 != null) {
                        destination$iv$iv$iv3.add(it$iv$iv$iv4);
                    }
                    $this$mapNotNull$iv$iv3 = $this$firstOrNull$iv$iv2;
                    rememberCalls$iv2 = rememberCalls$iv;
                }
                Iterable iterable = $this$mapNotNull$iv$iv3;
                MutableState toolingOverride = (MutableState) CollectionsKt.firstOrNull(CollectionsKt.plus(collection, (List) destination$iv$iv$iv3));
                if (!(animatable == null || spec == null || toolingOverride == null)) {
                    if (toolingOverride.getValue() == null) {
                        toolingOverride.setValue(new ToolingState(animatable.getValue()));
                    }
                    Object value = toolingOverride.getValue();
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.ui.tooling.animation.ToolingState<T of androidx.compose.ui.tooling.animation.AnimationSearch.AnimateXAsStateSearch.findAnimations$lambda$1>");
                    it$iv$iv = new AnimateXAsStateSearchInfo(animatable, spec, (ToolingState) value);
                }
                if (it$iv$iv != null) {
                    destination$iv$iv3.add(it$iv$iv);
                }
                animateXAsStateSearch = this;
                groups = groups2;
                $i$f$mapNotNull = $i$f$mapNotNull2;
                $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv3;
                $this$mapNotNull$iv2 = $this$mapNotNull$iv3;
            }
            return (List) destination$iv$iv3;
        }

        private final <T> AnimationSpec<T> findAnimationSpec(CallGroup group) {
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : group.getChildren()) {
                if (Intrinsics.areEqual((Object) ((Group) element$iv$iv).getName(), (Object) "rememberUpdatedState")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            List<Group> rememberStates = (List) destination$iv$iv;
            Collection collection = rememberStates;
            Collection destination$iv$iv2 = new ArrayList();
            for (Group it : rememberStates) {
                CollectionsKt.addAll(destination$iv$iv2, it.getChildren());
            }
            Collection destination$iv$iv3 = new ArrayList();
            for (Group it2 : CollectionsKt.plus(collection, (List) destination$iv$iv2)) {
                CollectionsKt.addAll(destination$iv$iv3, it2.getData());
            }
            Iterable $this$filterIsInstance$iv = (List) destination$iv$iv3;
            Collection destination$iv$iv4 = new ArrayList();
            for (Object element$iv$iv2 : $this$filterIsInstance$iv) {
                if (element$iv$iv2 instanceof State) {
                    destination$iv$iv4.add(element$iv$iv2);
                }
            }
            Iterable<State> $this$map$iv = (List) destination$iv$iv4;
            Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (State it3 : $this$map$iv) {
                destination$iv$iv5.add(it3.getValue());
            }
            Iterable $this$filterIsInstance$iv2 = (List) destination$iv$iv5;
            Collection destination$iv$iv6 = new ArrayList();
            for (Object element$iv$iv3 : $this$filterIsInstance$iv2) {
                if (element$iv$iv3 instanceof AnimationSpec) {
                    destination$iv$iv6.add(element$iv$iv3);
                }
            }
            return (AnimationSpec) CollectionsKt.firstOrNull((List) destination$iv$iv6);
        }

        private final <T> Animatable<T, AnimationVector> findAnimatable(CallGroup group) {
            Collection $this$findRememberedData$iv;
            Object obj;
            Object obj2;
            Collection<Group> $this$findRememberedData$iv2 = group.getChildren();
            int i = 0;
            Collection destination$iv$iv$iv = new ArrayList();
            for (Group it$iv : $this$findRememberedData$iv2) {
                Iterator it = it$iv.getData().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    Object element$iv$iv = it.next();
                    if (element$iv$iv instanceof Animatable) {
                        obj2 = element$iv$iv;
                        break;
                    }
                }
                int $i$f$findRememberedData = i;
                if ((obj2 instanceof Animatable) == 0) {
                    obj2 = null;
                }
                Object it$iv$iv$iv = (Animatable) obj2;
                if (it$iv$iv$iv != null) {
                    destination$iv$iv$iv.add(it$iv$iv$iv);
                }
                i = $i$f$findRememberedData;
            }
            int $i$f$findRememberedData2 = i;
            Iterable selfData$iv = (List) destination$iv$iv$iv;
            Collection destination$iv$iv$iv2 = new ArrayList();
            for (Group it$iv2 : $this$findRememberedData$iv2) {
                Object it$iv$iv$iv2 = PreviewUtilsKt.firstOrNull(it$iv2, AnimationSearchKt$findRememberedData$rememberCalls$1$1.INSTANCE);
                if (it$iv$iv$iv2 != null) {
                    destination$iv$iv$iv2.add(it$iv$iv$iv2);
                }
            }
            Collection collection = (Collection) selfData$iv;
            Collection destination$iv$iv$iv3 = new ArrayList();
            for (Group it$iv3 : (List) destination$iv$iv$iv2) {
                Iterator it2 = it$iv3.getData().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        $this$findRememberedData$iv = $this$findRememberedData$iv2;
                        obj = null;
                        break;
                    }
                    Object element$iv$iv2 = it2.next();
                    $this$findRememberedData$iv = $this$findRememberedData$iv2;
                    if (element$iv$iv2 instanceof Animatable) {
                        obj = element$iv$iv2;
                        break;
                    }
                    $this$findRememberedData$iv2 = $this$findRememberedData$iv;
                }
                Iterable $this$firstOrNull$iv$iv = selfData$iv;
                if (!(obj instanceof Animatable)) {
                    obj = null;
                }
                Object it$iv$iv$iv3 = (Animatable) obj;
                if (it$iv$iv$iv3 != null) {
                    destination$iv$iv$iv3.add(it$iv$iv$iv3);
                }
                selfData$iv = $this$firstOrNull$iv$iv;
                $this$findRememberedData$iv2 = $this$findRememberedData$iv;
            }
            return (Animatable) CollectionsKt.firstOrNull(CollectionsKt.plus(collection, (List) destination$iv$iv$iv3));
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateContentSizeSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groupsWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnimationSearch.kt */
    public static final class AnimateContentSizeSearch extends Search<Object> {
        public static final int $stable = 0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AnimateContentSizeSearch(Function1<Object, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
        }

        public void addAnimations(Collection<? extends Group> groupsWithLocation) {
            Object it$iv$iv;
            Iterable $this$mapNotNull$iv;
            Class<?> cls;
            Collection<? extends Group> $this$filter$iv = groupsWithLocation;
            Intrinsics.checkNotNullParameter($this$filter$iv, "groupsWithLocation");
            Set animations = getAnimations();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                if (Intrinsics.areEqual((Object) ((Group) element$iv$iv).getName(), (Object) "remember")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable<Group> $this$mapNotNull$iv2 = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList();
            for (Group it : $this$mapNotNull$iv2) {
                Iterator it2 = it.getData().iterator();
                while (true) {
                    it$iv$iv = null;
                    if (!it2.hasNext()) {
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        break;
                    }
                    Object element$iv = it2.next();
                    Object data = element$iv;
                    if (!(data == null || (cls = data.getClass()) == null)) {
                        it$iv$iv = cls.getName();
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    if (Intrinsics.areEqual((Object) it$iv$iv, (Object) "androidx.compose.animation.SizeAnimationModifier")) {
                        it$iv$iv = element$iv;
                        break;
                    } else {
                        Collection<? extends Group> collection = groupsWithLocation;
                        $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                    }
                }
                if (it$iv$iv != null) {
                    destination$iv$iv2.add(it$iv$iv);
                }
                Object it$iv$iv2 = groupsWithLocation;
                $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            }
            animations.addAll(CollectionsKt.toSet((List) destination$iv$iv2));
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$TransitionSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/animation/core/Transition;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groupsWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnimationSearch.kt */
    public static final class TransitionSearch extends Search<Transition<?>> {
        public static final int $stable = 0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TransitionSearch(Function1<? super Transition<?>, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
        }

        public void addAnimations(Collection<? extends Group> groupsWithLocation) {
            List selfData$iv;
            Object obj;
            Object obj2;
            Collection<? extends Group> $this$filter$iv = groupsWithLocation;
            Intrinsics.checkNotNullParameter($this$filter$iv, "groupsWithLocation");
            Set animations = getAnimations();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                if (Intrinsics.areEqual((Object) ((Group) element$iv$iv).getName(), (Object) "updateTransition")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Object it$iv$iv$iv = (Collection) ((List) destination$iv$iv);
            Collection destination$iv$iv$iv = new ArrayList();
            for (Group it$iv : (Iterable) it$iv$iv$iv) {
                Iterator it = it$iv.getData().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    Object element$iv$iv2 = it.next();
                    if (element$iv$iv2 instanceof Transition) {
                        obj2 = element$iv$iv2;
                        break;
                    }
                }
                if (!(obj2 instanceof Transition)) {
                    obj2 = null;
                }
                Object it$iv$iv$iv2 = (Transition) obj2;
                if (it$iv$iv$iv2 != null) {
                    destination$iv$iv$iv.add(it$iv$iv$iv2);
                }
                Object it$iv$iv$iv3 = groupsWithLocation;
            }
            List selfData$iv2 = (List) destination$iv$iv$iv;
            Collection destination$iv$iv$iv2 = new ArrayList();
            for (Group it$iv2 : (Iterable) it$iv$iv$iv) {
                Object $this$findRememberedData$iv = it$iv$iv$iv;
                Object it$iv$iv$iv4 = PreviewUtilsKt.firstOrNull(it$iv2, AnimationSearchKt$findRememberedData$rememberCalls$1$1.INSTANCE);
                if (it$iv$iv$iv4 != null) {
                    destination$iv$iv$iv2.add(it$iv$iv$iv4);
                }
                it$iv$iv$iv = $this$findRememberedData$iv;
            }
            Object $this$findRememberedData$iv2 = it$iv$iv$iv;
            Iterable<Group> rememberCalls$iv = (List) destination$iv$iv$iv2;
            Collection collection = selfData$iv2;
            Collection destination$iv$iv$iv3 = new ArrayList();
            for (Group it$iv3 : rememberCalls$iv) {
                Iterator it2 = it$iv3.getData().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        selfData$iv = selfData$iv2;
                        obj = null;
                        break;
                    }
                    Object element$iv$iv3 = it2.next();
                    selfData$iv = selfData$iv2;
                    if (element$iv$iv3 instanceof Transition) {
                        obj = element$iv$iv3;
                        break;
                    }
                    selfData$iv2 = selfData$iv;
                }
                Iterable $this$firstOrNull$iv$iv = rememberCalls$iv;
                if (!(obj instanceof Transition)) {
                    obj = null;
                }
                Object it$iv$iv$iv5 = (Transition) obj;
                if (it$iv$iv$iv5 != null) {
                    destination$iv$iv$iv3.add(it$iv$iv$iv5);
                }
                rememberCalls$iv = $this$firstOrNull$iv$iv;
                selfData$iv2 = selfData$iv;
            }
            animations.addAll(CollectionsKt.plus(collection, (List) destination$iv$iv$iv3));
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimatedVisibilitySearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/animation/core/Transition;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groupsWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnimationSearch.kt */
    public static final class AnimatedVisibilitySearch extends Search<Transition<?>> {
        public static final int $stable = 0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AnimatedVisibilitySearch(Function1<? super Transition<?>, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: androidx.compose.ui.tooling.data.Group} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: androidx.compose.ui.tooling.data.Group} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v2, resolved type: androidx.compose.ui.tooling.data.Group} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: androidx.compose.ui.tooling.data.Group} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void addAnimations(java.util.Collection<? extends androidx.compose.ui.tooling.data.Group> r27) {
            /*
                r26 = this;
                r0 = r27
                java.lang.String r1 = "groupsWithLocation"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                java.util.Set r1 = r26.getAnimations()
                r2 = r0
                java.lang.Iterable r2 = (java.lang.Iterable) r2
                r3 = 0
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                java.util.Collection r4 = (java.util.Collection) r4
                r5 = r2
                r6 = 0
                java.util.Iterator r7 = r5.iterator()
            L_0x001d:
                boolean r8 = r7.hasNext()
                if (r8 == 0) goto L_0x003b
                java.lang.Object r8 = r7.next()
                r9 = r8
                androidx.compose.ui.tooling.data.Group r9 = (androidx.compose.ui.tooling.data.Group) r9
                r10 = 0
                java.lang.String r11 = r9.getName()
                java.lang.String r12 = "AnimatedVisibility"
                boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)
                if (r9 == 0) goto L_0x001d
                r4.add(r8)
                goto L_0x001d
            L_0x003b:
                java.util.List r4 = (java.util.List) r4
                java.lang.Iterable r4 = (java.lang.Iterable) r4
                r2 = r4
                r3 = 0
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                java.util.Collection r4 = (java.util.Collection) r4
                r5 = r2
                r6 = 0
                r7 = r5
                r8 = 0
                java.util.Iterator r9 = r7.iterator()
            L_0x0052:
                boolean r10 = r9.hasNext()
                if (r10 == 0) goto L_0x009f
                java.lang.Object r10 = r9.next()
                r12 = r10
                r13 = 0
                r14 = r12
                androidx.compose.ui.tooling.data.Group r14 = (androidx.compose.ui.tooling.data.Group) r14
                r15 = 0
                java.util.Collection r16 = r14.getChildren()
                java.lang.Iterable r16 = (java.lang.Iterable) r16
                r17 = 0
                java.util.Iterator r18 = r16.iterator()
            L_0x006e:
                boolean r19 = r18.hasNext()
                if (r19 == 0) goto L_0x0091
                java.lang.Object r19 = r18.next()
                r20 = r19
                androidx.compose.ui.tooling.data.Group r20 = (androidx.compose.ui.tooling.data.Group) r20
                r21 = 0
                java.lang.String r11 = r20.getName()
                java.lang.String r0 = "updateTransition"
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r0)
                if (r0 == 0) goto L_0x008e
                r11 = r19
                goto L_0x0092
            L_0x008e:
                r0 = r27
                goto L_0x006e
            L_0x0091:
                r11 = 0
            L_0x0092:
                androidx.compose.ui.tooling.data.Group r11 = (androidx.compose.ui.tooling.data.Group) r11
                if (r11 == 0) goto L_0x009c
                r0 = r11
                r11 = 0
                r4.add(r0)
            L_0x009c:
                r0 = r27
                goto L_0x0052
            L_0x009f:
                r0 = r4
                java.util.List r0 = (java.util.List) r0
                java.util.Collection r0 = (java.util.Collection) r0
                r2 = 0
                r3 = r0
                java.lang.Iterable r3 = (java.lang.Iterable) r3
                r4 = 0
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                java.util.Collection r5 = (java.util.Collection) r5
                r6 = r3
                r7 = 0
                r8 = r6
                r9 = 0
                java.util.Iterator r10 = r8.iterator()
            L_0x00bc:
                boolean r11 = r10.hasNext()
                if (r11 == 0) goto L_0x010c
                java.lang.Object r11 = r10.next()
                r12 = r11
                r13 = 0
                r14 = r12
                androidx.compose.ui.tooling.data.Group r14 = (androidx.compose.ui.tooling.data.Group) r14
                r15 = 0
                java.util.Collection r16 = r14.getData()
                java.lang.Iterable r16 = (java.lang.Iterable) r16
                r17 = 0
                java.util.Iterator r18 = r16.iterator()
            L_0x00d8:
                boolean r19 = r18.hasNext()
                if (r19 == 0) goto L_0x00f4
                java.lang.Object r19 = r18.next()
                r20 = r19
                r21 = 0
                r22 = r2
                r2 = r20
                boolean r2 = r2 instanceof androidx.compose.animation.core.Transition
                if (r2 == 0) goto L_0x00f1
                r2 = r19
                goto L_0x00f7
            L_0x00f1:
                r2 = r22
                goto L_0x00d8
            L_0x00f4:
                r22 = r2
                r2 = 0
            L_0x00f7:
                r16 = r3
                boolean r3 = r2 instanceof androidx.compose.animation.core.Transition
                if (r3 != 0) goto L_0x00fe
                r2 = 0
            L_0x00fe:
                androidx.compose.animation.core.Transition r2 = (androidx.compose.animation.core.Transition) r2
                if (r2 == 0) goto L_0x0107
                r3 = 0
                r5.add(r2)
            L_0x0107:
                r3 = r16
                r2 = r22
                goto L_0x00bc
            L_0x010c:
                r22 = r2
                r16 = r3
                r2 = r5
                java.util.List r2 = (java.util.List) r2
                r3 = r0
                java.lang.Iterable r3 = (java.lang.Iterable) r3
                r4 = 0
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                java.util.Collection r5 = (java.util.Collection) r5
                r6 = r3
                r7 = 0
                r8 = r6
                r9 = 0
                java.util.Iterator r10 = r8.iterator()
            L_0x0129:
                boolean r11 = r10.hasNext()
                if (r11 == 0) goto L_0x014e
                java.lang.Object r11 = r10.next()
                r12 = r11
                r13 = 0
                r14 = r12
                androidx.compose.ui.tooling.data.Group r14 = (androidx.compose.ui.tooling.data.Group) r14
                r15 = 0
                androidx.compose.ui.tooling.animation.AnimationSearchKt$findRememberedData$rememberCalls$1$1 r16 = androidx.compose.ui.tooling.animation.AnimationSearchKt$findRememberedData$rememberCalls$1$1.INSTANCE
                r17 = r0
                r0 = r16
                kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
                androidx.compose.ui.tooling.data.Group r0 = androidx.compose.ui.tooling.PreviewUtilsKt.firstOrNull(r14, r0)
                if (r0 == 0) goto L_0x014b
                r14 = 0
                r5.add(r0)
            L_0x014b:
                r0 = r17
                goto L_0x0129
            L_0x014e:
                r17 = r0
                r0 = r5
                java.util.List r0 = (java.util.List) r0
                r3 = r2
                java.util.Collection r3 = (java.util.Collection) r3
                r4 = r0
                java.lang.Iterable r4 = (java.lang.Iterable) r4
                r5 = 0
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                java.util.Collection r6 = (java.util.Collection) r6
                r7 = r4
                r8 = 0
                r9 = r7
                r10 = 0
                java.util.Iterator r11 = r9.iterator()
            L_0x016c:
                boolean r12 = r11.hasNext()
                if (r12 == 0) goto L_0x01bd
                java.lang.Object r12 = r11.next()
                r13 = r12
                r14 = 0
                r15 = r13
                androidx.compose.ui.tooling.data.Group r15 = (androidx.compose.ui.tooling.data.Group) r15
                r16 = 0
                java.util.Collection r18 = r15.getData()
                java.lang.Iterable r18 = (java.lang.Iterable) r18
                r19 = 0
                java.util.Iterator r20 = r18.iterator()
            L_0x0189:
                boolean r21 = r20.hasNext()
                if (r21 == 0) goto L_0x01a5
                java.lang.Object r21 = r20.next()
                r23 = r21
                r24 = 0
                r25 = r0
                r0 = r23
                boolean r0 = r0 instanceof androidx.compose.animation.core.Transition
                if (r0 == 0) goto L_0x01a2
                r0 = r21
                goto L_0x01a8
            L_0x01a2:
                r0 = r25
                goto L_0x0189
            L_0x01a5:
                r25 = r0
                r0 = 0
            L_0x01a8:
                r18 = r2
                boolean r2 = r0 instanceof androidx.compose.animation.core.Transition
                if (r2 != 0) goto L_0x01af
                r0 = 0
            L_0x01af:
                androidx.compose.animation.core.Transition r0 = (androidx.compose.animation.core.Transition) r0
                if (r0 == 0) goto L_0x01b8
                r2 = 0
                r6.add(r0)
            L_0x01b8:
                r2 = r18
                r0 = r25
                goto L_0x016c
            L_0x01bd:
                r25 = r0
                r0 = r6
                java.util.List r0 = (java.util.List) r0
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.List r0 = kotlin.collections.CollectionsKt.plus(r3, r0)
                java.util.Collection r0 = (java.util.Collection) r0
                r1.addAll(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.animation.AnimationSearch.AnimatedVisibilitySearch.addAnimations(java.util.Collection):void");
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimatedContentSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/animation/core/Transition;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groupsWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnimationSearch.kt */
    public static final class AnimatedContentSearch extends Search<Transition<?>> {
        public static final int $stable = 0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AnimatedContentSearch(Function1<? super Transition<?>, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: androidx.compose.ui.tooling.data.Group} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: androidx.compose.ui.tooling.data.Group} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v2, resolved type: androidx.compose.ui.tooling.data.Group} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: androidx.compose.ui.tooling.data.Group} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void addAnimations(java.util.Collection<? extends androidx.compose.ui.tooling.data.Group> r27) {
            /*
                r26 = this;
                r0 = r27
                java.lang.String r1 = "groupsWithLocation"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                java.util.Set r1 = r26.getAnimations()
                r2 = r0
                java.lang.Iterable r2 = (java.lang.Iterable) r2
                r3 = 0
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                java.util.Collection r4 = (java.util.Collection) r4
                r5 = r2
                r6 = 0
                java.util.Iterator r7 = r5.iterator()
            L_0x001d:
                boolean r8 = r7.hasNext()
                if (r8 == 0) goto L_0x003b
                java.lang.Object r8 = r7.next()
                r9 = r8
                androidx.compose.ui.tooling.data.Group r9 = (androidx.compose.ui.tooling.data.Group) r9
                r10 = 0
                java.lang.String r11 = r9.getName()
                java.lang.String r12 = "AnimatedContent"
                boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)
                if (r9 == 0) goto L_0x001d
                r4.add(r8)
                goto L_0x001d
            L_0x003b:
                java.util.List r4 = (java.util.List) r4
                java.lang.Iterable r4 = (java.lang.Iterable) r4
                r2 = r4
                r3 = 0
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                java.util.Collection r4 = (java.util.Collection) r4
                r5 = r2
                r6 = 0
                r7 = r5
                r8 = 0
                java.util.Iterator r9 = r7.iterator()
            L_0x0052:
                boolean r10 = r9.hasNext()
                if (r10 == 0) goto L_0x009f
                java.lang.Object r10 = r9.next()
                r12 = r10
                r13 = 0
                r14 = r12
                androidx.compose.ui.tooling.data.Group r14 = (androidx.compose.ui.tooling.data.Group) r14
                r15 = 0
                java.util.Collection r16 = r14.getChildren()
                java.lang.Iterable r16 = (java.lang.Iterable) r16
                r17 = 0
                java.util.Iterator r18 = r16.iterator()
            L_0x006e:
                boolean r19 = r18.hasNext()
                if (r19 == 0) goto L_0x0091
                java.lang.Object r19 = r18.next()
                r20 = r19
                androidx.compose.ui.tooling.data.Group r20 = (androidx.compose.ui.tooling.data.Group) r20
                r21 = 0
                java.lang.String r11 = r20.getName()
                java.lang.String r0 = "updateTransition"
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r0)
                if (r0 == 0) goto L_0x008e
                r11 = r19
                goto L_0x0092
            L_0x008e:
                r0 = r27
                goto L_0x006e
            L_0x0091:
                r11 = 0
            L_0x0092:
                androidx.compose.ui.tooling.data.Group r11 = (androidx.compose.ui.tooling.data.Group) r11
                if (r11 == 0) goto L_0x009c
                r0 = r11
                r11 = 0
                r4.add(r0)
            L_0x009c:
                r0 = r27
                goto L_0x0052
            L_0x009f:
                r0 = r4
                java.util.List r0 = (java.util.List) r0
                java.util.Collection r0 = (java.util.Collection) r0
                r2 = 0
                r3 = r0
                java.lang.Iterable r3 = (java.lang.Iterable) r3
                r4 = 0
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                java.util.Collection r5 = (java.util.Collection) r5
                r6 = r3
                r7 = 0
                r8 = r6
                r9 = 0
                java.util.Iterator r10 = r8.iterator()
            L_0x00bc:
                boolean r11 = r10.hasNext()
                if (r11 == 0) goto L_0x010c
                java.lang.Object r11 = r10.next()
                r12 = r11
                r13 = 0
                r14 = r12
                androidx.compose.ui.tooling.data.Group r14 = (androidx.compose.ui.tooling.data.Group) r14
                r15 = 0
                java.util.Collection r16 = r14.getData()
                java.lang.Iterable r16 = (java.lang.Iterable) r16
                r17 = 0
                java.util.Iterator r18 = r16.iterator()
            L_0x00d8:
                boolean r19 = r18.hasNext()
                if (r19 == 0) goto L_0x00f4
                java.lang.Object r19 = r18.next()
                r20 = r19
                r21 = 0
                r22 = r2
                r2 = r20
                boolean r2 = r2 instanceof androidx.compose.animation.core.Transition
                if (r2 == 0) goto L_0x00f1
                r2 = r19
                goto L_0x00f7
            L_0x00f1:
                r2 = r22
                goto L_0x00d8
            L_0x00f4:
                r22 = r2
                r2 = 0
            L_0x00f7:
                r16 = r3
                boolean r3 = r2 instanceof androidx.compose.animation.core.Transition
                if (r3 != 0) goto L_0x00fe
                r2 = 0
            L_0x00fe:
                androidx.compose.animation.core.Transition r2 = (androidx.compose.animation.core.Transition) r2
                if (r2 == 0) goto L_0x0107
                r3 = 0
                r5.add(r2)
            L_0x0107:
                r3 = r16
                r2 = r22
                goto L_0x00bc
            L_0x010c:
                r22 = r2
                r16 = r3
                r2 = r5
                java.util.List r2 = (java.util.List) r2
                r3 = r0
                java.lang.Iterable r3 = (java.lang.Iterable) r3
                r4 = 0
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                java.util.Collection r5 = (java.util.Collection) r5
                r6 = r3
                r7 = 0
                r8 = r6
                r9 = 0
                java.util.Iterator r10 = r8.iterator()
            L_0x0129:
                boolean r11 = r10.hasNext()
                if (r11 == 0) goto L_0x014e
                java.lang.Object r11 = r10.next()
                r12 = r11
                r13 = 0
                r14 = r12
                androidx.compose.ui.tooling.data.Group r14 = (androidx.compose.ui.tooling.data.Group) r14
                r15 = 0
                androidx.compose.ui.tooling.animation.AnimationSearchKt$findRememberedData$rememberCalls$1$1 r16 = androidx.compose.ui.tooling.animation.AnimationSearchKt$findRememberedData$rememberCalls$1$1.INSTANCE
                r17 = r0
                r0 = r16
                kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
                androidx.compose.ui.tooling.data.Group r0 = androidx.compose.ui.tooling.PreviewUtilsKt.firstOrNull(r14, r0)
                if (r0 == 0) goto L_0x014b
                r14 = 0
                r5.add(r0)
            L_0x014b:
                r0 = r17
                goto L_0x0129
            L_0x014e:
                r17 = r0
                r0 = r5
                java.util.List r0 = (java.util.List) r0
                r3 = r2
                java.util.Collection r3 = (java.util.Collection) r3
                r4 = r0
                java.lang.Iterable r4 = (java.lang.Iterable) r4
                r5 = 0
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                java.util.Collection r6 = (java.util.Collection) r6
                r7 = r4
                r8 = 0
                r9 = r7
                r10 = 0
                java.util.Iterator r11 = r9.iterator()
            L_0x016c:
                boolean r12 = r11.hasNext()
                if (r12 == 0) goto L_0x01bd
                java.lang.Object r12 = r11.next()
                r13 = r12
                r14 = 0
                r15 = r13
                androidx.compose.ui.tooling.data.Group r15 = (androidx.compose.ui.tooling.data.Group) r15
                r16 = 0
                java.util.Collection r18 = r15.getData()
                java.lang.Iterable r18 = (java.lang.Iterable) r18
                r19 = 0
                java.util.Iterator r20 = r18.iterator()
            L_0x0189:
                boolean r21 = r20.hasNext()
                if (r21 == 0) goto L_0x01a5
                java.lang.Object r21 = r20.next()
                r23 = r21
                r24 = 0
                r25 = r0
                r0 = r23
                boolean r0 = r0 instanceof androidx.compose.animation.core.Transition
                if (r0 == 0) goto L_0x01a2
                r0 = r21
                goto L_0x01a8
            L_0x01a2:
                r0 = r25
                goto L_0x0189
            L_0x01a5:
                r25 = r0
                r0 = 0
            L_0x01a8:
                r18 = r2
                boolean r2 = r0 instanceof androidx.compose.animation.core.Transition
                if (r2 != 0) goto L_0x01af
                r0 = 0
            L_0x01af:
                androidx.compose.animation.core.Transition r0 = (androidx.compose.animation.core.Transition) r0
                if (r0 == 0) goto L_0x01b8
                r2 = 0
                r6.add(r0)
            L_0x01b8:
                r2 = r18
                r0 = r25
                goto L_0x016c
            L_0x01bd:
                r25 = r0
                r0 = r6
                java.util.List r0 = (java.util.List) r0
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.List r0 = kotlin.collections.CollectionsKt.plus(r3, r0)
                java.util.Collection r0 = (java.util.Collection) r0
                r1.addAll(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.animation.AnimationSearch.AnimatedContentSearch.addAnimations(java.util.Collection):void");
        }
    }
}
