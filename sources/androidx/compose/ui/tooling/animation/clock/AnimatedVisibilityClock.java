package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimatedProperty;
import androidx.compose.animation.tooling.TransitionInfo;
import androidx.compose.ui.tooling.animation.AnimatedVisibilityComposeAnimation;
import androidx.compose.ui.tooling.animation.states.AnimatedVisibilityState;
import androidx.compose.ui.tooling.animation.states.ComposeAnimationState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00102\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u001a\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J%\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0 *\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0004\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R/\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@VX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/compose/ui/tooling/animation/clock/AnimatedVisibilityClock;", "Landroidx/compose/ui/tooling/animation/clock/ComposeAnimationClock;", "Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;", "Landroidx/compose/ui/tooling/animation/states/AnimatedVisibilityState;", "animation", "(Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;)V", "getAnimation", "()Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;", "value", "state", "getState-jXw82LU", "()Ljava/lang/String;", "setState-7IW2chM", "(Ljava/lang/String;)V", "Ljava/lang/String;", "getAnimatedProperties", "", "Landroidx/compose/animation/tooling/ComposeAnimatedProperty;", "getMaxDuration", "", "getMaxDurationPerIteration", "getTransitions", "Landroidx/compose/animation/tooling/TransitionInfo;", "stepMillis", "setClockTime", "", "animationTimeNanos", "setStateParameters", "par1", "", "par2", "toCurrentTargetPair", "Lkotlin/Pair;", "", "toCurrentTargetPair-7IW2chM", "(Ljava/lang/String;)Lkotlin/Pair;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedVisibilityClock.kt */
public final class AnimatedVisibilityClock implements ComposeAnimationClock<AnimatedVisibilityComposeAnimation, AnimatedVisibilityState> {
    private final AnimatedVisibilityComposeAnimation animation;
    private String state;

    public AnimatedVisibilityClock(AnimatedVisibilityComposeAnimation animation2) {
        String str;
        Intrinsics.checkNotNullParameter(animation2, "animation");
        this.animation = animation2;
        if (getAnimation().getAnimationObject().getCurrentState().booleanValue()) {
            str = AnimatedVisibilityState.Companion.m5917getExitjXw82LU();
        } else {
            str = AnimatedVisibilityState.Companion.m5916getEnterjXw82LU();
        }
        this.state = str;
    }

    public AnimatedVisibilityComposeAnimation getAnimation() {
        return this.animation;
    }

    public /* bridge */ /* synthetic */ ComposeAnimationState getState() {
        return AnimatedVisibilityState.m5909boximpl(m5907getStatejXw82LU());
    }

    public /* bridge */ /* synthetic */ void setState(ComposeAnimationState composeAnimationState) {
        m5908setState7IW2chM(((AnimatedVisibilityState) composeAnimationState).m5915unboximpl());
    }

    /* renamed from: getState-jXw82LU  reason: not valid java name */
    public String m5907getStatejXw82LU() {
        return this.state;
    }

    /* renamed from: setState-7IW2chM  reason: not valid java name */
    public void m5908setState7IW2chM(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.state = value;
        setClockTime(0);
    }

    public void setStateParameters(Object par1, Object par2) {
        Intrinsics.checkNotNullParameter(par1, "par1");
        m5908setState7IW2chM(((AnimatedVisibilityState) par1).m5915unboximpl());
    }

    public long getMaxDurationPerIteration() {
        Transition<Object> childTransition = getAnimation().getChildTransition();
        if (childTransition != null) {
            return UtilsKt.nanosToMillis(childTransition.getTotalDurationNanos());
        }
        return 0;
    }

    public long getMaxDuration() {
        Transition<Object> childTransition = getAnimation().getChildTransition();
        if (childTransition != null) {
            return UtilsKt.nanosToMillis(childTransition.getTotalDurationNanos());
        }
        return 0;
    }

    public void setClockTime(long animationTimeNanos) {
        Transition it = getAnimation().getAnimationObject();
        Pair<Boolean, Boolean> r2 = m5906toCurrentTargetPair7IW2chM(m5907getStatejXw82LU());
        it.seek(Boolean.valueOf(r2.component1().booleanValue()), Boolean.valueOf(r2.component2().booleanValue()), animationTimeNanos);
    }

    public List<TransitionInfo> getTransitions(long stepMillis) {
        Transition child = getAnimation().getChildTransition();
        if (child == null) {
            return CollectionsKt.emptyList();
        }
        Iterable<Transition.TransitionAnimationState> $this$map$iv = UtilsKt.allAnimations(child);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Transition.TransitionAnimationState it : $this$map$iv) {
            destination$iv$iv.add(UtilsKt.createTransitionInfo(it, stepMillis));
        }
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : CollectionsKt.sortedWith((List) destination$iv$iv, new AnimatedVisibilityClock$getTransitions$lambda$4$$inlined$sortedBy$1())) {
            if (!UtilsKt.getIGNORE_TRANSITIONS().contains(((TransitionInfo) element$iv$iv).getLabel())) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv2;
    }

    public List<ComposeAnimatedProperty> getAnimatedProperties() {
        int i;
        Object it$iv$iv;
        Transition child = getAnimation().getChildTransition();
        if (child == null) {
            return CollectionsKt.emptyList();
        }
        int i2 = false;
        Collection destination$iv$iv = new ArrayList();
        for (Transition.TransitionAnimationState it : UtilsKt.allAnimations(child)) {
            String label = it.getLabel();
            Transition child2 = child;
            Object value = it.getValue();
            if (value == null) {
                it$iv$iv = null;
                i = i2;
            } else {
                i = i2;
                it$iv$iv = new ComposeAnimatedProperty(label, value);
            }
            if (it$iv$iv != null) {
                destination$iv$iv.add(it$iv$iv);
            }
            child = child2;
            i2 = i;
        }
        int i3 = i2;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : CollectionsKt.sortedWith((List) destination$iv$iv, new AnimatedVisibilityClock$getAnimatedProperties$lambda$8$$inlined$sortedBy$1())) {
            if (!UtilsKt.getIGNORE_TRANSITIONS().contains(((ComposeAnimatedProperty) element$iv$iv).getLabel())) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv2;
    }

    /* renamed from: toCurrentTargetPair-7IW2chM  reason: not valid java name */
    private final Pair<Boolean, Boolean> m5906toCurrentTargetPair7IW2chM(String $this$toCurrentTargetPair_u2d7IW2chM) {
        return AnimatedVisibilityState.m5912equalsimpl0($this$toCurrentTargetPair_u2d7IW2chM, AnimatedVisibilityState.Companion.m5916getEnterjXw82LU()) ? TuplesKt.to(false, true) : TuplesKt.to(true, false);
    }
}
