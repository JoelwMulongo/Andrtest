package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aT\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001aT\u0010\u001b\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b0\u0016H\u0007ø\u0001\u0000\u001aT\u0010\u001f\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0011\u001a\u00020 2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a\"\u0010#\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010$\u001a\u00020\u0002H\u0007\u001a\"\u0010%\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010'\u001a\u00020\u0002H\u0007\u001a9\u0010(\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u000bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a9\u0010-\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010.\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u000bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001aT\u00101\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u00102\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u00103\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001aT\u00104\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u00102\u001a\u00020\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u00105\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b0\u0016H\u0007ø\u0001\u0000\u001aT\u00106\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u00102\u001a\u00020 2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a>\u00108\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102!\u00109\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00060\u0016H\u0007ø\u0001\u0000\u001a@\u0010:\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a@\u0010<\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010=\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a>\u0010>\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102!\u0010?\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00060\u0016H\u0007ø\u0001\u0000\u001a@\u0010@\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010A\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a@\u0010B\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010C\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a/\u0010D\u001a\u00020E*\b\u0012\u0004\u0012\u00020G0F2\u0006\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020&2\u0006\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\u0010L\u001aB\u0010M\u001a\u00020E*\u00020E2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020G0F2\u000e\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0P2\u000e\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0P2\u0006\u0010S\u001a\u00020KH\u0002\u001aB\u0010T\u001a\u00020E*\u00020E2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020G0F2\u000e\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0P2\u000e\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0P2\u0006\u0010S\u001a\u00020KH\u0002\u001a\f\u0010V\u001a\u00020\u001c*\u00020\u0012H\u0002\u001a\f\u0010V\u001a\u00020\u001c*\u00020 H\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006W"}, d2 = {"DefaultAlpha", "Landroidx/compose/runtime/MutableState;", "", "DefaultAlphaAndScaleSpring", "Landroidx/compose/animation/core/SpringSpec;", "DefaultOffsetAnimationSpec", "Landroidx/compose/ui/unit/IntOffset;", "DefaultSizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "TransformOriginVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/graphics/TransformOrigin;", "Landroidx/compose/animation/core/AnimationVector2D;", "expandHorizontally", "Landroidx/compose/animation/EnterTransition;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "expandFrom", "Landroidx/compose/ui/Alignment$Horizontal;", "clip", "", "initialWidth", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "fullWidth", "expandIn", "Landroidx/compose/ui/Alignment;", "initialSize", "fullSize", "expandVertically", "Landroidx/compose/ui/Alignment$Vertical;", "initialHeight", "fullHeight", "fadeIn", "initialAlpha", "fadeOut", "Landroidx/compose/animation/ExitTransition;", "targetAlpha", "scaleIn", "initialScale", "transformOrigin", "scaleIn-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/EnterTransition;", "scaleOut", "targetScale", "scaleOut-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/ExitTransition;", "shrinkHorizontally", "shrinkTowards", "targetWidth", "shrinkOut", "targetSize", "shrinkVertically", "targetHeight", "slideIn", "initialOffset", "slideInHorizontally", "initialOffsetX", "slideInVertically", "initialOffsetY", "slideOut", "targetOffset", "slideOutHorizontally", "targetOffsetX", "slideOutVertically", "targetOffsetY", "createModifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "enter", "exit", "label", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "shrinkExpand", "transition", "expand", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/ChangeSize;", "shrink", "labelPrefix", "slideInOut", "Landroidx/compose/animation/Slide;", "toAlignment", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
public final class EnterExitTransitionKt {
    private static final MutableState<Float> DefaultAlpha = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
    /* access modifiers changed from: private */
    public static final SpringSpec<Float> DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
    /* access modifiers changed from: private */
    public static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6095boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
    /* access modifiers changed from: private */
    public static final SpringSpec<IntSize> DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6138boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
    private static final TwoWayConverter<TransformOrigin, AnimationVector2D> TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(EnterExitTransitionKt$TransformOriginVectorConverter$1.INSTANCE, EnterExitTransitionKt$TransformOriginVectorConverter$2.INSTANCE);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: EnterExitTransition.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            try {
                iArr[EnterExitState.Visible.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[EnterExitState.PreEnter.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EnterExitState.PostExit.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ EnterTransition fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeIn(finiteAnimationSpec, f);
    }

    public static final EnterTransition fadeIn(FiniteAnimationSpec<Float> animationSpec, float initialAlpha) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData(new Fade(initialAlpha, animationSpec), (Slide) null, (ChangeSize) null, (Scale) null, 14, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ ExitTransition fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeOut(finiteAnimationSpec, f);
    }

    public static final ExitTransition fadeOut(FiniteAnimationSpec<Float> animationSpec, float targetAlpha) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData(new Fade(targetAlpha, animationSpec), (Slide) null, (ChangeSize) null, (Scale) null, 14, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ EnterTransition slideIn$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6095boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        return slideIn(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideIn(FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super IntSize, IntOffset> initialOffset) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(initialOffset, "initialOffset");
        return new EnterTransitionImpl(new TransitionData((Fade) null, new Slide(initialOffset, animationSpec), (ChangeSize) null, (Scale) null, 13, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ ExitTransition slideOut$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6095boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        return slideOut(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOut(FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super IntSize, IntOffset> targetOffset) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(targetOffset, "targetOffset");
        return new ExitTransitionImpl(new TransitionData((Fade) null, new Slide(targetOffset, animationSpec), (ChangeSize) null, (Scale) null, 13, (DefaultConstructorMarker) null));
    }

    /* renamed from: scaleIn-L8ZKh-E$default  reason: not valid java name */
    public static /* synthetic */ EnterTransition m337scaleInL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.Companion.m3586getCenterSzJe1aQ();
        }
        return m336scaleInL8ZKhE(finiteAnimationSpec, f, j);
    }

    /* renamed from: scaleIn-L8ZKh-E  reason: not valid java name */
    public static final EnterTransition m336scaleInL8ZKhE(FiniteAnimationSpec<Float> animationSpec, float initialScale, long transformOrigin) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData((Fade) null, (Slide) null, (ChangeSize) null, new Scale(initialScale, transformOrigin, animationSpec, (DefaultConstructorMarker) null), 7, (DefaultConstructorMarker) null));
    }

    /* renamed from: scaleOut-L8ZKh-E$default  reason: not valid java name */
    public static /* synthetic */ ExitTransition m339scaleOutL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.Companion.m3586getCenterSzJe1aQ();
        }
        return m338scaleOutL8ZKhE(finiteAnimationSpec, f, j);
    }

    /* renamed from: scaleOut-L8ZKh-E  reason: not valid java name */
    public static final ExitTransition m338scaleOutL8ZKhE(FiniteAnimationSpec<Float> animationSpec, float targetScale, long transformOrigin) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData((Fade) null, (Slide) null, (ChangeSize) null, new Scale(targetScale, transformOrigin, animationSpec, (DefaultConstructorMarker) null), 7, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ EnterTransition expandIn$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6138boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.Companion.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$expandIn$1.INSTANCE;
        }
        return expandIn(finiteAnimationSpec, alignment, z, function1);
    }

    public static final EnterTransition expandIn(FiniteAnimationSpec<IntSize> animationSpec, Alignment expandFrom, boolean clip, Function1<? super IntSize, IntSize> initialSize) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(expandFrom, "expandFrom");
        Intrinsics.checkNotNullParameter(initialSize, "initialSize");
        return new EnterTransitionImpl(new TransitionData((Fade) null, (Slide) null, new ChangeSize(expandFrom, initialSize, animationSpec, clip), (Scale) null, 11, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ ExitTransition shrinkOut$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6138boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.Companion.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$shrinkOut$1.INSTANCE;
        }
        return shrinkOut(finiteAnimationSpec, alignment, z, function1);
    }

    public static final ExitTransition shrinkOut(FiniteAnimationSpec<IntSize> animationSpec, Alignment shrinkTowards, boolean clip, Function1<? super IntSize, IntSize> targetSize) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(shrinkTowards, "shrinkTowards");
        Intrinsics.checkNotNullParameter(targetSize, "targetSize");
        return new ExitTransitionImpl(new TransitionData((Fade) null, (Slide) null, new ChangeSize(shrinkTowards, targetSize, animationSpec, clip), (Scale) null, 11, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ EnterTransition expandHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6138boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.Companion.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$expandHorizontally$1.INSTANCE;
        }
        return expandHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final EnterTransition expandHorizontally(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Horizontal expandFrom, boolean clip, Function1<? super Integer, Integer> initialWidth) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(expandFrom, "expandFrom");
        Intrinsics.checkNotNullParameter(initialWidth, "initialWidth");
        return expandIn(animationSpec, toAlignment(expandFrom), clip, new EnterExitTransitionKt$expandHorizontally$2(initialWidth));
    }

    public static /* synthetic */ EnterTransition expandVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6138boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.Companion.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$expandVertically$1.INSTANCE;
        }
        return expandVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final EnterTransition expandVertically(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Vertical expandFrom, boolean clip, Function1<? super Integer, Integer> initialHeight) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(expandFrom, "expandFrom");
        Intrinsics.checkNotNullParameter(initialHeight, "initialHeight");
        return expandIn(animationSpec, toAlignment(expandFrom), clip, new EnterExitTransitionKt$expandVertically$2(initialHeight));
    }

    public static /* synthetic */ ExitTransition shrinkHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6138boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.Companion.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$shrinkHorizontally$1.INSTANCE;
        }
        return shrinkHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final ExitTransition shrinkHorizontally(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Horizontal shrinkTowards, boolean clip, Function1<? super Integer, Integer> targetWidth) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(shrinkTowards, "shrinkTowards");
        Intrinsics.checkNotNullParameter(targetWidth, "targetWidth");
        return shrinkOut(animationSpec, toAlignment(shrinkTowards), clip, new EnterExitTransitionKt$shrinkHorizontally$2(targetWidth));
    }

    public static /* synthetic */ ExitTransition shrinkVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6138boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.Companion.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$shrinkVertically$1.INSTANCE;
        }
        return shrinkVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final ExitTransition shrinkVertically(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Vertical shrinkTowards, boolean clip, Function1<? super Integer, Integer> targetHeight) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(shrinkTowards, "shrinkTowards");
        Intrinsics.checkNotNullParameter(targetHeight, "targetHeight");
        return shrinkOut(animationSpec, toAlignment(shrinkTowards), clip, new EnterExitTransitionKt$shrinkVertically$2(targetHeight));
    }

    public static /* synthetic */ EnterTransition slideInHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6095boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = EnterExitTransitionKt$slideInHorizontally$1.INSTANCE;
        }
        return slideInHorizontally(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInHorizontally(FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super Integer, Integer> initialOffsetX) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(initialOffsetX, "initialOffsetX");
        return slideIn(animationSpec, new EnterExitTransitionKt$slideInHorizontally$2(initialOffsetX));
    }

    public static /* synthetic */ EnterTransition slideInVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6095boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = EnterExitTransitionKt$slideInVertically$1.INSTANCE;
        }
        return slideInVertically(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInVertically(FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super Integer, Integer> initialOffsetY) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(initialOffsetY, "initialOffsetY");
        return slideIn(animationSpec, new EnterExitTransitionKt$slideInVertically$2(initialOffsetY));
    }

    public static /* synthetic */ ExitTransition slideOutHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6095boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = EnterExitTransitionKt$slideOutHorizontally$1.INSTANCE;
        }
        return slideOutHorizontally(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutHorizontally(FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super Integer, Integer> targetOffsetX) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(targetOffsetX, "targetOffsetX");
        return slideOut(animationSpec, new EnterExitTransitionKt$slideOutHorizontally$2(targetOffsetX));
    }

    public static /* synthetic */ ExitTransition slideOutVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6095boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = EnterExitTransitionKt$slideOutVertically$1.INSTANCE;
        }
        return slideOutVertically(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutVertically(FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super Integer, Integer> targetOffsetY) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(targetOffsetY, "targetOffsetY");
        return slideOut(animationSpec, new EnterExitTransitionKt$slideOutVertically$2(targetOffsetY));
    }

    private static final Alignment toAlignment(Alignment.Horizontal $this$toAlignment) {
        if (Intrinsics.areEqual((Object) $this$toAlignment, (Object) Alignment.Companion.getStart())) {
            return Alignment.Companion.getCenterStart();
        }
        if (Intrinsics.areEqual((Object) $this$toAlignment, (Object) Alignment.Companion.getEnd())) {
            return Alignment.Companion.getCenterEnd();
        }
        return Alignment.Companion.getCenter();
    }

    private static final Alignment toAlignment(Alignment.Vertical $this$toAlignment) {
        if (Intrinsics.areEqual((Object) $this$toAlignment, (Object) Alignment.Companion.getTop())) {
            return Alignment.Companion.getTopCenter();
        }
        if (Intrinsics.areEqual((Object) $this$toAlignment, (Object) Alignment.Companion.getBottom())) {
            return Alignment.Companion.getBottomCenter();
        }
        return Alignment.Companion.getCenter();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:126:0x051e, code lost:
        r0 = r39.getData$animation_release().getScale();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.Modifier createModifier(androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r37, androidx.compose.animation.EnterTransition r38, androidx.compose.animation.ExitTransition r39, java.lang.String r40, androidx.compose.runtime.Composer r41, int r42) {
        /*
            r8 = r37
            r9 = r38
            r10 = r39
            r11 = r40
            r12 = r41
            r13 = r42
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "enter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "exit"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "label"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 914000546(0x367a8aa2, float:3.7333598E-6)
            r12.startReplaceableGroup(r0)
            java.lang.String r1 = "C(createModifier)832@36300L38,833@36348L37,837@36443L43,838@36496L42,845@36867L40,846@36938L40:EnterExitTransition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r14 = -1
            if (r1 == 0) goto L_0x0038
            java.lang.String r1 = "androidx.compose.animation.createModifier (EnterExitTransition.kt:820)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r14, r1)
        L_0x0038:
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.animation.TransitionData r1 = r38.getData$animation_release()
            androidx.compose.animation.Slide r1 = r1.getSlide()
            r15 = 0
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r1, r12, r15)
            androidx.compose.animation.TransitionData r2 = r39.getData$animation_release()
            androidx.compose.animation.Slide r2 = r2.getSlide()
            androidx.compose.runtime.State r2 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r2, r12, r15)
            androidx.compose.ui.Modifier r1 = slideInOut(r0, r8, r1, r2, r11)
            androidx.compose.animation.TransitionData r2 = r38.getData$animation_release()
            androidx.compose.animation.ChangeSize r2 = r2.getChangeSize()
            androidx.compose.runtime.State r2 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r2, r12, r15)
            androidx.compose.animation.TransitionData r3 = r39.getData$animation_release()
            androidx.compose.animation.ChangeSize r3 = r3.getChangeSize()
            androidx.compose.runtime.State r3 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r3, r12, r15)
            androidx.compose.ui.Modifier r1 = shrinkExpand(r1, r8, r2, r3, r11)
            r7 = r1
            r0 = r13 & 14
            r1 = 0
            r6 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r6)
            java.lang.String r4 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r4)
            boolean r2 = r12.changed((java.lang.Object) r8)
            r3 = r41
            r5 = 0
            java.lang.Object r14 = r3.rememberedValue()
            r16 = 0
            if (r2 != 0) goto L_0x00a9
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r19.getEmpty()
            if (r14 != r6) goto L_0x00a3
            goto L_0x00a9
        L_0x00a3:
            r19 = r0
            r22 = r1
            r0 = r14
            goto L_0x00bd
        L_0x00a9:
            r6 = 0
            r19 = r0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r15)
            r22 = r1
            r1 = 0
            r15 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r1, r15, r1)
            r3.updateRememberedValue(r0)
        L_0x00bd:
            r41.endReplaceableGroup()
            r14 = r0
            androidx.compose.runtime.MutableState r14 = (androidx.compose.runtime.MutableState) r14
            r0 = r13 & 14
            r1 = 0
            r6 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r4)
            boolean r2 = r12.changed((java.lang.Object) r8)
            r3 = r41
            r5 = 0
            java.lang.Object r15 = r3.rememberedValue()
            r16 = 0
            if (r2 != 0) goto L_0x00f1
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r17.getEmpty()
            if (r15 != r6) goto L_0x00ea
            goto L_0x00f1
        L_0x00ea:
            r22 = r0
            r23 = r1
            r0 = r15
            r6 = 0
            goto L_0x0109
        L_0x00f1:
            r6 = 0
            r22 = r0
            r17 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r17)
            r23 = r1
            r17 = r6
            r1 = 2
            r6 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r6, r1, r6)
            r3.updateRememberedValue(r0)
        L_0x0109:
            r41.endReplaceableGroup()
            r15 = r0
            androidx.compose.runtime.MutableState r15 = (androidx.compose.runtime.MutableState) r15
            java.lang.Object r0 = r37.getCurrentState()
            java.lang.Object r1 = r37.getTargetState()
            if (r0 != r1) goto L_0x0129
            boolean r0 = r37.isSeeking()
            if (r0 != 0) goto L_0x0129
            r0 = 0
            createModifier$lambda$2(r14, r0)
            createModifier$lambda$5(r15, r0)
            goto L_0x0158
        L_0x0129:
            androidx.compose.animation.TransitionData r0 = r38.getData$animation_release()
            androidx.compose.animation.Fade r0 = r0.getFade()
            r1 = 1
            if (r0 != 0) goto L_0x013e
            androidx.compose.animation.TransitionData r0 = r39.getData$animation_release()
            androidx.compose.animation.Fade r0 = r0.getFade()
            if (r0 == 0) goto L_0x0141
        L_0x013e:
            createModifier$lambda$2(r14, r1)
        L_0x0141:
            androidx.compose.animation.TransitionData r0 = r38.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 != 0) goto L_0x0155
            androidx.compose.animation.TransitionData r0 = r39.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 == 0) goto L_0x0158
        L_0x0155:
            createModifier$lambda$5(r15, r1)
        L_0x0158:
            r0 = 1657241561(0x62c77fd9, float:1.8400572E21)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "870@37922L27,860@37401L796"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            boolean r0 = createModifier$lambda$1(r14)
            r16 = 458752(0x70000, float:6.42848E-40)
            java.lang.String r3 = "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli"
            r17 = 57344(0xe000, float:8.0356E-41)
            java.lang.String r1 = "C:EnterExitTransition.kt#xbi5r1"
            r18 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L_0x032d
            androidx.compose.animation.EnterExitTransitionKt$createModifier$alpha$2 r0 = new androidx.compose.animation.EnterExitTransitionKt$createModifier$alpha$2
            r0.<init>(r9, r10)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r5 = 0
            r20 = r5
            r5 = 0
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r6)
            java.lang.String r6 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r6)
            r6 = 0
            r23 = r41
            r24 = 0
            java.lang.Object r2 = r23.rememberedValue()
            r26 = 0
            androidx.compose.runtime.Composer$Companion r27 = androidx.compose.runtime.Composer.Companion
            r28 = r4
            java.lang.Object r4 = r27.getEmpty()
            if (r2 != r4) goto L_0x01bf
            r4 = 0
            r27 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r2 = r2.append(r11)
            r29 = r4
            java.lang.String r4 = " alpha"
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r2 = r2.toString()
            r4 = r23
            r4.updateRememberedValue(r2)
            goto L_0x01c3
        L_0x01bf:
            r27 = r2
            r4 = r23
        L_0x01c3:
            r41.endReplaceableGroup()
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            r2 = r13 & 14
            r2 = r2 | 384(0x180, float:5.38E-43)
            r20 = r2
            r6 = r0
            r23 = r37
            r24 = 0
            r0 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(animateFloat)P(2)938@37489L78:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            kotlin.jvm.internal.FloatCompanionObject r0 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r26 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r0)
            r0 = r20 & 14
            int r2 = r20 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            int r2 = r20 << 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r20 << 3
            r2 = r2 & r17
            r2 = r2 | r0
            r0 = r23
            r27 = r2
            r29 = 0
            r2 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r12.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            java.lang.Object r4 = r0.getCurrentState()
            int r25 = r27 >> 9
            r2 = r25 & 112(0x70, float:1.57E-43)
            androidx.compose.animation.EnterExitState r4 = (androidx.compose.animation.EnterExitState) r4
            r25 = r41
            r30 = 0
            r31 = r3
            r3 = 755689166(0x2d0ae6ce, float:7.895641E-12)
            r32 = r7
            r7 = r25
            r7.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            boolean r25 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r25 == 0) goto L_0x0233
            r25 = r1
            java.lang.String r1 = "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:871)"
            r8 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r2, r8, r1)
            goto L_0x0235
        L_0x0233:
            r25 = r1
        L_0x0235:
            int[] r1 = androidx.compose.animation.EnterExitTransitionKt.WhenMappings.$EnumSwitchMapping$0
            int r8 = r4.ordinal()
            r1 = r1[r8]
            switch(r1) {
                case 1: goto L_0x026a;
                case 2: goto L_0x0258;
                case 3: goto L_0x0246;
                default: goto L_0x0240;
            }
        L_0x0240:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x0246:
            androidx.compose.animation.TransitionData r1 = r39.getData$animation_release()
            androidx.compose.animation.Fade r1 = r1.getFade()
            if (r1 == 0) goto L_0x0255
            float r1 = r1.getAlpha()
            goto L_0x026c
        L_0x0255:
            r1 = r18
            goto L_0x026c
        L_0x0258:
            androidx.compose.animation.TransitionData r1 = r38.getData$animation_release()
            androidx.compose.animation.Fade r1 = r1.getFade()
            if (r1 == 0) goto L_0x0267
            float r1 = r1.getAlpha()
            goto L_0x026c
        L_0x0267:
            r1 = r18
            goto L_0x026c
        L_0x026a:
            r1 = r18
        L_0x026c:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x0275
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0275:
            r7.endReplaceableGroup()
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r8 = r25
            java.lang.Object r2 = r0.getTargetState()
            int r4 = r27 >> 9
            r4 = r4 & 112(0x70, float:1.57E-43)
            androidx.compose.animation.EnterExitState r2 = (androidx.compose.animation.EnterExitState) r2
            r7 = r41
            r25 = 0
            r7.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r8)
            boolean r30 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r30 == 0) goto L_0x02a3
            r33 = r14
            java.lang.String r14 = "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:871)"
            r30 = r8
            r8 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r4, r8, r14)
            goto L_0x02a7
        L_0x02a3:
            r30 = r8
            r33 = r14
        L_0x02a7:
            int[] r3 = androidx.compose.animation.EnterExitTransitionKt.WhenMappings.$EnumSwitchMapping$0
            int r8 = r2.ordinal()
            r3 = r3[r8]
            switch(r3) {
                case 1: goto L_0x02dc;
                case 2: goto L_0x02ca;
                case 3: goto L_0x02b8;
                default: goto L_0x02b2;
            }
        L_0x02b2:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        L_0x02b8:
            androidx.compose.animation.TransitionData r3 = r39.getData$animation_release()
            androidx.compose.animation.Fade r3 = r3.getFade()
            if (r3 == 0) goto L_0x02c7
            float r3 = r3.getAlpha()
            goto L_0x02de
        L_0x02c7:
            r3 = r18
            goto L_0x02de
        L_0x02ca:
            androidx.compose.animation.TransitionData r3 = r38.getData$animation_release()
            androidx.compose.animation.Fade r3 = r3.getFade()
            if (r3 == 0) goto L_0x02d9
            float r3 = r3.getAlpha()
            goto L_0x02de
        L_0x02d9:
            r3 = r18
            goto L_0x02de
        L_0x02dc:
            r3 = r18
        L_0x02de:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x02e7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02e7:
            r7.endReplaceableGroup()
            java.lang.Float r2 = java.lang.Float.valueOf(r3)
            r8 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            androidx.compose.animation.core.Transition$Segment r3 = r0.getSegment()
            int r4 = r27 >> 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r3 = r6.invoke(r3, r12, r4)
            r14 = r3
            androidx.compose.animation.core.FiniteAnimationSpec r14 = (androidx.compose.animation.core.FiniteAnimationSpec) r14
            r3 = r27 & 14
            int r4 = r27 << 9
            r4 = r4 & r17
            r3 = r3 | r4
            int r4 = r27 << 6
            r4 = r4 & r16
            r7 = r3 | r4
            r4 = r31
            r3 = r14
            r34 = r4
            r35 = r28
            r4 = r26
            r22 = r6
            r19 = 0
            r6 = r41
            r36 = r32
            androidx.compose.runtime.State r3 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r0, r1, r2, r3, r4, r5, r6, r7)
            r41.endReplaceableGroup()
            r41.endReplaceableGroup()
            goto L_0x0341
        L_0x032d:
            r30 = r1
            r34 = r3
            r35 = r4
            r19 = r6
            r36 = r7
            r33 = r14
            r8 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            androidx.compose.runtime.MutableState<java.lang.Float> r0 = DefaultAlpha
            r3 = r0
            androidx.compose.runtime.State r3 = (androidx.compose.runtime.State) r3
        L_0x0341:
            r41.endReplaceableGroup()
            r14 = r3
            boolean r0 = createModifier$lambda$4(r15)
            if (r0 == 0) goto L_0x0717
            r0 = 1657242461(0x62c7835d, float:1.8401839E21)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "893@38813L27,883@38290L800,909@39583L536,922@40163L157"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            androidx.compose.animation.EnterExitTransitionKt$createModifier$scale$2 r0 = new androidx.compose.animation.EnterExitTransitionKt$createModifier$scale$2
            r0.<init>(r9, r10)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r1 = 0
            r2 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            r3 = 0
            r4 = r41
            r5 = 0
            java.lang.Object r6 = r4.rememberedValue()
            r7 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r20.getEmpty()
            if (r6 != r8) goto L_0x0399
            r8 = 0
            r20 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r11)
            r21 = r2
            java.lang.String r2 = " scale"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r4.updateRememberedValue(r1)
            goto L_0x039e
        L_0x0399:
            r20 = r1
            r21 = r2
            r1 = r6
        L_0x039e:
            r41.endReplaceableGroup()
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5
            r1 = r13 & 14
            r1 = r1 | 384(0x180, float:5.38E-43)
            r8 = r1
            r7 = r0
            r20 = r37
            r21 = 0
            r0 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(animateFloat)P(2)938@37489L78:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            kotlin.jvm.internal.FloatCompanionObject r0 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r22 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r0)
            r0 = r8 & 14
            int r1 = r8 << 3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r8 << 3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r8 << 3
            r1 = r1 & r17
            r1 = r1 | r0
            r0 = r20
            r23 = r1
            r24 = 0
            r1 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r12.startReplaceableGroup(r1)
            r6 = r34
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r6)
            java.lang.Object r1 = r0.getCurrentState()
            int r2 = r23 >> 9
            r2 = r2 & 112(0x70, float:1.57E-43)
            androidx.compose.animation.EnterExitState r1 = (androidx.compose.animation.EnterExitState) r1
            r3 = r41
            r4 = 0
            r26 = r4
            r4 = -596129937(0xffffffffdc77c76f, float:-2.78974395E17)
            r3.startReplaceableGroup(r4)
            r4 = r30
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            boolean r28 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r28 == 0) goto L_0x0411
            r31 = r6
            java.lang.String r6 = "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:894)"
            r28 = r8
            r8 = -596129937(0xffffffffdc77c76f, float:-2.78974395E17)
            r9 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r2, r9, r6)
            goto L_0x0415
        L_0x0411:
            r31 = r6
            r28 = r8
        L_0x0415:
            int[] r6 = androidx.compose.animation.EnterExitTransitionKt.WhenMappings.$EnumSwitchMapping$0
            int r8 = r1.ordinal()
            r6 = r6[r8]
            switch(r6) {
                case 1: goto L_0x044a;
                case 2: goto L_0x0438;
                case 3: goto L_0x0426;
                default: goto L_0x0420;
            }
        L_0x0420:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        L_0x0426:
            androidx.compose.animation.TransitionData r6 = r39.getData$animation_release()
            androidx.compose.animation.Scale r6 = r6.getScale()
            if (r6 == 0) goto L_0x0435
            float r6 = r6.getScale()
            goto L_0x044c
        L_0x0435:
            r6 = r18
            goto L_0x044c
        L_0x0438:
            androidx.compose.animation.TransitionData r6 = r38.getData$animation_release()
            androidx.compose.animation.Scale r6 = r6.getScale()
            if (r6 == 0) goto L_0x0447
            float r6 = r6.getScale()
            goto L_0x044c
        L_0x0447:
            r6 = r18
            goto L_0x044c
        L_0x044a:
            r6 = r18
        L_0x044c:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x0455
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0455:
            r3.endReplaceableGroup()
            java.lang.Float r1 = java.lang.Float.valueOf(r6)
            java.lang.Object r2 = r0.getTargetState()
            int r3 = r23 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            androidx.compose.animation.EnterExitState r2 = (androidx.compose.animation.EnterExitState) r2
            r6 = r41
            r8 = 0
            r9 = -596129937(0xffffffffdc77c76f, float:-2.78974395E17)
            r6.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r4)
            boolean r26 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r26 == 0) goto L_0x0484
            r30 = r4
            java.lang.String r4 = "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:894)"
            r26 = r8
            r8 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r9, r3, r8, r4)
            goto L_0x0488
        L_0x0484:
            r30 = r4
            r26 = r8
        L_0x0488:
            int[] r4 = androidx.compose.animation.EnterExitTransitionKt.WhenMappings.$EnumSwitchMapping$0
            int r8 = r2.ordinal()
            r4 = r4[r8]
            switch(r4) {
                case 1: goto L_0x04b7;
                case 2: goto L_0x04a8;
                case 3: goto L_0x0499;
                default: goto L_0x0493;
            }
        L_0x0493:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        L_0x0499:
            androidx.compose.animation.TransitionData r4 = r39.getData$animation_release()
            androidx.compose.animation.Scale r4 = r4.getScale()
            if (r4 == 0) goto L_0x04b8
            float r18 = r4.getScale()
            goto L_0x04b8
        L_0x04a8:
            androidx.compose.animation.TransitionData r4 = r38.getData$animation_release()
            androidx.compose.animation.Scale r4 = r4.getScale()
            if (r4 == 0) goto L_0x04b8
            float r18 = r4.getScale()
            goto L_0x04b8
        L_0x04b7:
        L_0x04b8:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x04c1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04c1:
            r6.endReplaceableGroup()
            java.lang.Float r2 = java.lang.Float.valueOf(r18)
            androidx.compose.animation.core.Transition$Segment r3 = r0.getSegment()
            int r4 = r23 >> 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r3 = r7.invoke(r3, r12, r4)
            r8 = r3
            androidx.compose.animation.core.FiniteAnimationSpec r8 = (androidx.compose.animation.core.FiniteAnimationSpec) r8
            r3 = r23 & 14
            int r4 = r23 << 9
            r4 = r4 & r17
            r3 = r3 | r4
            int r4 = r23 << 6
            r4 = r4 & r16
            r9 = r3 | r4
            r3 = r8
            r6 = r30
            r4 = r22
            r10 = r6
            r18 = r8
            r8 = r31
            r6 = r41
            r27 = r7
            r7 = r9
            androidx.compose.runtime.State r3 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r0, r1, r2, r3, r4, r5, r6, r7)
            r41.endReplaceableGroup()
            r41.endReplaceableGroup()
            r9 = r3
            java.lang.Object r0 = r37.getCurrentState()
            androidx.compose.animation.EnterExitState r1 = androidx.compose.animation.EnterExitState.PreEnter
            if (r0 != r1) goto L_0x052c
            androidx.compose.animation.TransitionData r0 = r38.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 == 0) goto L_0x051e
        L_0x0515:
            long r0 = r0.m360getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r6 = androidx.compose.ui.graphics.TransformOrigin.m3573boximpl(r0)
            goto L_0x054c
        L_0x051e:
            androidx.compose.animation.TransitionData r0 = r39.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 == 0) goto L_0x0529
            goto L_0x0515
        L_0x0529:
            r6 = r19
            goto L_0x054c
        L_0x052c:
            androidx.compose.animation.TransitionData r0 = r39.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 == 0) goto L_0x053f
        L_0x0536:
            long r0 = r0.m360getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r6 = androidx.compose.ui.graphics.TransformOrigin.m3573boximpl(r0)
            goto L_0x054c
        L_0x053f:
            androidx.compose.animation.TransitionData r0 = r38.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 == 0) goto L_0x054a
            goto L_0x0536
        L_0x054a:
            r6 = r19
        L_0x054c:
            r18 = r6
            androidx.compose.animation.core.TwoWayConverter<androidx.compose.ui.graphics.TransformOrigin, androidx.compose.animation.core.AnimationVector2D> r4 = TransformOriginVectorConverter
            r0 = r13 & 14
            r1 = r0 | 3136(0xc40, float:4.394E-42)
            r0 = r37
            java.lang.String r5 = "TransformOriginInterruptionHandling"
            r20 = r1
            r21 = 0
            r1 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r12.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r8)
            androidx.compose.animation.EnterExitTransitionKt$createModifier$$inlined$animateValue$1 r1 = androidx.compose.animation.EnterExitTransitionKt$createModifier$$inlined$animateValue$1.INSTANCE
            r8 = r1
            kotlin.jvm.functions.Function3 r8 = (kotlin.jvm.functions.Function3) r8
            java.lang.Object r1 = r0.getCurrentState()
            int r2 = r20 >> 9
            r2 = r2 & 112(0x70, float:1.57E-43)
            androidx.compose.animation.EnterExitState r1 = (androidx.compose.animation.EnterExitState) r1
            r3 = r41
            r6 = 0
            r7 = -288165413(0xffffffffeed2f1db, float:-3.2642119E28)
            r3.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r10)
            boolean r22 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r22 == 0) goto L_0x0592
            r22 = r6
            java.lang.String r6 = "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:912)"
            r11 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r2, r11, r6)
            goto L_0x0594
        L_0x0592:
            r22 = r6
        L_0x0594:
            int[] r6 = androidx.compose.animation.EnterExitTransitionKt.WhenMappings.$EnumSwitchMapping$0
            int r11 = r1.ordinal()
            r6 = r6[r11]
            switch(r6) {
                case 1: goto L_0x05e7;
                case 2: goto L_0x05c6;
                case 3: goto L_0x05a5;
                default: goto L_0x059f;
            }
        L_0x059f:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L_0x05a5:
            androidx.compose.animation.TransitionData r6 = r39.getData$animation_release()
            androidx.compose.animation.Scale r6 = r6.getScale()
            if (r6 == 0) goto L_0x05b8
        L_0x05af:
            long r23 = r6.m360getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r6 = androidx.compose.ui.graphics.TransformOrigin.m3573boximpl(r23)
            goto L_0x05e9
        L_0x05b8:
            androidx.compose.animation.TransitionData r6 = r38.getData$animation_release()
            androidx.compose.animation.Scale r6 = r6.getScale()
            if (r6 == 0) goto L_0x05c3
            goto L_0x05af
        L_0x05c3:
            r6 = r19
            goto L_0x05e9
        L_0x05c6:
            androidx.compose.animation.TransitionData r6 = r38.getData$animation_release()
            androidx.compose.animation.Scale r6 = r6.getScale()
            if (r6 == 0) goto L_0x05d9
        L_0x05d0:
            long r23 = r6.m360getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r6 = androidx.compose.ui.graphics.TransformOrigin.m3573boximpl(r23)
            goto L_0x05e9
        L_0x05d9:
            androidx.compose.animation.TransitionData r6 = r39.getData$animation_release()
            androidx.compose.animation.Scale r6 = r6.getScale()
            if (r6 == 0) goto L_0x05e4
            goto L_0x05d0
        L_0x05e4:
            r6 = r19
            goto L_0x05e9
        L_0x05e7:
            r6 = r18
        L_0x05e9:
            if (r6 == 0) goto L_0x05f0
            long r23 = r6.m3585unboximpl()
            goto L_0x05f6
        L_0x05f0:
            androidx.compose.ui.graphics.TransformOrigin$Companion r6 = androidx.compose.ui.graphics.TransformOrigin.Companion
            long r23 = r6.m3586getCenterSzJe1aQ()
        L_0x05f6:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x05ff
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x05ff:
            r3.endReplaceableGroup()
            androidx.compose.ui.graphics.TransformOrigin r1 = androidx.compose.ui.graphics.TransformOrigin.m3573boximpl(r23)
            java.lang.Object r2 = r0.getTargetState()
            int r3 = r20 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            androidx.compose.animation.EnterExitState r2 = (androidx.compose.animation.EnterExitState) r2
            r6 = r41
            r11 = 0
            r6.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r10)
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x0629
            java.lang.String r10 = "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:912)"
            r22 = r11
            r11 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r3, r11, r10)
            goto L_0x062b
        L_0x0629:
            r22 = r11
        L_0x062b:
            int[] r7 = androidx.compose.animation.EnterExitTransitionKt.WhenMappings.$EnumSwitchMapping$0
            int r10 = r2.ordinal()
            r7 = r7[r10]
            switch(r7) {
                case 1: goto L_0x067e;
                case 2: goto L_0x065d;
                case 3: goto L_0x063c;
                default: goto L_0x0636;
            }
        L_0x0636:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        L_0x063c:
            androidx.compose.animation.TransitionData r7 = r39.getData$animation_release()
            androidx.compose.animation.Scale r7 = r7.getScale()
            if (r7 == 0) goto L_0x064f
        L_0x0646:
            long r10 = r7.m360getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r7 = androidx.compose.ui.graphics.TransformOrigin.m3573boximpl(r10)
            goto L_0x0680
        L_0x064f:
            androidx.compose.animation.TransitionData r7 = r38.getData$animation_release()
            androidx.compose.animation.Scale r7 = r7.getScale()
            if (r7 == 0) goto L_0x065a
            goto L_0x0646
        L_0x065a:
            r7 = r19
            goto L_0x0680
        L_0x065d:
            androidx.compose.animation.TransitionData r7 = r38.getData$animation_release()
            androidx.compose.animation.Scale r7 = r7.getScale()
            if (r7 == 0) goto L_0x0670
        L_0x0667:
            long r10 = r7.m360getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r7 = androidx.compose.ui.graphics.TransformOrigin.m3573boximpl(r10)
            goto L_0x0680
        L_0x0670:
            androidx.compose.animation.TransitionData r7 = r39.getData$animation_release()
            androidx.compose.animation.Scale r7 = r7.getScale()
            if (r7 == 0) goto L_0x067b
            goto L_0x0667
        L_0x067b:
            r7 = r19
            goto L_0x0680
        L_0x067e:
            r7 = r18
        L_0x0680:
            if (r7 == 0) goto L_0x0687
            long r10 = r7.m3585unboximpl()
            goto L_0x068d
        L_0x0687:
            androidx.compose.ui.graphics.TransformOrigin$Companion r7 = androidx.compose.ui.graphics.TransformOrigin.Companion
            long r10 = r7.m3586getCenterSzJe1aQ()
        L_0x068d:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0696
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0696:
            r6.endReplaceableGroup()
            androidx.compose.ui.graphics.TransformOrigin r2 = androidx.compose.ui.graphics.TransformOrigin.m3573boximpl(r10)
            androidx.compose.animation.core.Transition$Segment r3 = r0.getSegment()
            int r6 = r20 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r3 = r8.invoke(r3, r12, r6)
            r10 = r3
            androidx.compose.animation.core.FiniteAnimationSpec r10 = (androidx.compose.animation.core.FiniteAnimationSpec) r10
            r3 = r20 & 14
            int r6 = r20 << 9
            r6 = r6 & r17
            r3 = r3 | r6
            int r6 = r20 << 6
            r6 = r6 & r16
            r7 = r3 | r6
            r3 = r10
            r6 = r41
            androidx.compose.runtime.State r3 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r0, r1, r2, r3, r4, r5, r6, r7)
            r41.endReplaceableGroup()
            r0 = r3
            r1 = 0
            r2 = 0
            r3 = 1618982084(0x607fb4c4, float:7.370227E19)
            r12.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            boolean r3 = r12.changed((java.lang.Object) r14)
            boolean r4 = r12.changed((java.lang.Object) r9)
            r3 = r3 | r4
            boolean r4 = r12.changed((java.lang.Object) r0)
            r3 = r3 | r4
            r4 = r41
            r5 = 0
            java.lang.Object r6 = r4.rememberedValue()
            r7 = 0
            if (r3 != 0) goto L_0x06f9
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r6 != r8) goto L_0x06f7
            goto L_0x06f9
        L_0x06f7:
            r8 = r6
            goto L_0x0706
        L_0x06f9:
            r8 = 0
            androidx.compose.animation.EnterExitTransitionKt$createModifier$1$1 r10 = new androidx.compose.animation.EnterExitTransitionKt$createModifier$1$1
            r10.<init>(r14, r9, r0)
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r8 = r10
            r4.updateRememberedValue(r8)
        L_0x0706:
            r41.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r7 = r36
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.graphicsLayer(r7, r8)
            r41.endReplaceableGroup()
            goto L_0x0775
        L_0x0717:
            r7 = r36
            boolean r0 = createModifier$lambda$1(r33)
            if (r0 == 0) goto L_0x076c
            r0 = 1657244550(0x62c78b86, float:1.8404779E21)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "929@40400L42"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            r0 = 0
            r1 = 0
            r2 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r2)
            r2 = r35
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r2)
            boolean r2 = r12.changed((java.lang.Object) r14)
            r3 = r41
            r4 = 0
            java.lang.Object r5 = r3.rememberedValue()
            r6 = 0
            if (r2 != 0) goto L_0x0750
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r5 != r8) goto L_0x074e
            goto L_0x0750
        L_0x074e:
            r8 = r5
            goto L_0x075d
        L_0x0750:
            r8 = 0
            androidx.compose.animation.EnterExitTransitionKt$createModifier$2$1 r9 = new androidx.compose.animation.EnterExitTransitionKt$createModifier$2$1
            r9.<init>(r14)
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r8 = r9
            r3.updateRememberedValue(r8)
        L_0x075d:
            r41.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.graphicsLayer(r7, r8)
            r41.endReplaceableGroup()
            goto L_0x0775
        L_0x076c:
            r0 = 1657244642(0x62c78be2, float:1.8404908E21)
            r12.startReplaceableGroup(r0)
            r41.endReplaceableGroup()
        L_0x0775:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x077e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x077e:
            r41.endReplaceableGroup()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt.createModifier(androidx.compose.animation.core.Transition, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }

    private static final boolean createModifier$lambda$1(MutableState<Boolean> $shouldAnimateAlpha$delegate) {
        return ((Boolean) $shouldAnimateAlpha$delegate.getValue()).booleanValue();
    }

    private static final void createModifier$lambda$2(MutableState<Boolean> $shouldAnimateAlpha$delegate, boolean value) {
        $shouldAnimateAlpha$delegate.setValue(Boolean.valueOf(value));
    }

    private static final boolean createModifier$lambda$4(MutableState<Boolean> $shouldAnimateScale$delegate) {
        return ((Boolean) $shouldAnimateScale$delegate.getValue()).booleanValue();
    }

    private static final void createModifier$lambda$5(MutableState<Boolean> $shouldAnimateScale$delegate, boolean value) {
        $shouldAnimateScale$delegate.setValue(Boolean.valueOf(value));
    }

    /* access modifiers changed from: private */
    public static final float createModifier$lambda$8(State<Float> $alpha$delegate) {
        return ((Number) $alpha$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final float createModifier$lambda$11(State<Float> $scale$delegate) {
        return ((Number) $scale$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final long createModifier$lambda$13(State<TransformOrigin> $transformOrigin$delegate) {
        return ((TransformOrigin) $transformOrigin$delegate.getValue()).m3585unboximpl();
    }

    private static final Modifier slideInOut(Modifier $this$slideInOut, Transition<EnterExitState> transition, State<Slide> slideIn, State<Slide> slideOut, String labelPrefix) {
        return ComposedModifierKt.composed$default($this$slideInOut, (Function1) null, new EnterExitTransitionKt$slideInOut$1(transition, slideIn, slideOut, labelPrefix), 1, (Object) null);
    }

    private static final Modifier shrinkExpand(Modifier $this$shrinkExpand, Transition<EnterExitState> transition, State<ChangeSize> expand, State<ChangeSize> shrink, String labelPrefix) {
        return ComposedModifierKt.composed$default($this$shrinkExpand, (Function1) null, new EnterExitTransitionKt$shrinkExpand$1(transition, expand, shrink, labelPrefix), 1, (Object) null);
    }
}
