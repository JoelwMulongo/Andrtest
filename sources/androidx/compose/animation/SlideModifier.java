package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001BF\u0012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tø\u0001\u0000¢\u0006\u0002\u0010\fJ#\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'R*\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R\b\u0012\u0004\u0012\u00020\u00070\u0006ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R1\u0010\u0012\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00150\u0013¢\u0006\u0002\b\u0016ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"Landroidx/compose/animation/SlideModifier;", "Landroidx/compose/animation/LayoutModifierWithPassThroughIntrinsics;", "lazyAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "slideIn", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/Slide;", "slideOut", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;)V", "getLazyAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "getSlideIn", "()Landroidx/compose/runtime/State;", "getSlideOut", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "getTransitionSpec", "()Lkotlin/jvm/functions/Function1;", "targetValueByState", "targetState", "fullSize", "Landroidx/compose/ui/unit/IntSize;", "targetValueByState-oFUgxo0", "(Landroidx/compose/animation/EnterExitState;J)J", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class SlideModifier extends LayoutModifierWithPassThroughIntrinsics {
    private final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> lazyAnimation;
    private final State<Slide> slideIn;
    private final State<Slide> slideOut;
    private final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> transitionSpec = new SlideModifier$transitionSpec$1(this);

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

    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getLazyAnimation() {
        return this.lazyAnimation;
    }

    public final State<Slide> getSlideIn() {
        return this.slideIn;
    }

    public final State<Slide> getSlideOut() {
        return this.slideOut;
    }

    public SlideModifier(Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> lazyAnimation2, State<Slide> slideIn2, State<Slide> slideOut2) {
        Intrinsics.checkNotNullParameter(lazyAnimation2, "lazyAnimation");
        Intrinsics.checkNotNullParameter(slideIn2, "slideIn");
        Intrinsics.checkNotNullParameter(slideOut2, "slideOut");
        this.lazyAnimation = lazyAnimation2;
        this.slideIn = slideIn2;
        this.slideOut = slideOut2;
    }

    public final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> getTransitionSpec() {
        return this.transitionSpec;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0010, code lost:
        r0 = r0.getSlideOffset();
     */
    /* renamed from: targetValueByState-oFUgxo0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long m374targetValueByStateoFUgxo0(androidx.compose.animation.EnterExitState r7, long r8) {
        /*
            r6 = this;
            java.lang.String r0 = "targetState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            androidx.compose.runtime.State<androidx.compose.animation.Slide> r0 = r6.slideIn
            java.lang.Object r0 = r0.getValue()
            androidx.compose.animation.Slide r0 = (androidx.compose.animation.Slide) r0
            if (r0 == 0) goto L_0x0025
            kotlin.jvm.functions.Function1 r0 = r0.getSlideOffset()
            if (r0 == 0) goto L_0x0025
            androidx.compose.ui.unit.IntSize r1 = androidx.compose.ui.unit.IntSize.m6138boximpl(r8)
            java.lang.Object r0 = r0.invoke(r1)
            androidx.compose.ui.unit.IntOffset r0 = (androidx.compose.ui.unit.IntOffset) r0
            long r0 = r0.m6113unboximpl()
            goto L_0x002b
        L_0x0025:
            androidx.compose.ui.unit.IntOffset$Companion r0 = androidx.compose.ui.unit.IntOffset.Companion
            long r0 = r0.m6114getZeronOccac()
        L_0x002b:
            androidx.compose.runtime.State<androidx.compose.animation.Slide> r2 = r6.slideOut
            java.lang.Object r2 = r2.getValue()
            androidx.compose.animation.Slide r2 = (androidx.compose.animation.Slide) r2
            if (r2 == 0) goto L_0x004a
            kotlin.jvm.functions.Function1 r2 = r2.getSlideOffset()
            if (r2 == 0) goto L_0x004a
            androidx.compose.ui.unit.IntSize r3 = androidx.compose.ui.unit.IntSize.m6138boximpl(r8)
            java.lang.Object r2 = r2.invoke(r3)
            androidx.compose.ui.unit.IntOffset r2 = (androidx.compose.ui.unit.IntOffset) r2
            long r2 = r2.m6113unboximpl()
            goto L_0x0050
        L_0x004a:
            androidx.compose.ui.unit.IntOffset$Companion r2 = androidx.compose.ui.unit.IntOffset.Companion
            long r2 = r2.m6114getZeronOccac()
        L_0x0050:
            int[] r4 = androidx.compose.animation.SlideModifier.WhenMappings.$EnumSwitchMapping$0
            int r5 = r7.ordinal()
            r4 = r4[r5]
            switch(r4) {
                case 1: goto L_0x0065;
                case 2: goto L_0x0063;
                case 3: goto L_0x0061;
                default: goto L_0x005b;
            }
        L_0x005b:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        L_0x0061:
            r4 = r2
            goto L_0x006b
        L_0x0063:
            r4 = r0
            goto L_0x006b
        L_0x0065:
            androidx.compose.ui.unit.IntOffset$Companion r4 = androidx.compose.ui.unit.IntOffset.Companion
            long r4 = r4.m6114getZeronOccac()
        L_0x006b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.SlideModifier.m374targetValueByStateoFUgxo0(androidx.compose.animation.EnterExitState, long):long");
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m373measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Placeable placeable = measurable.m4863measureBRTryo0(constraints);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, placeable.getWidth(), placeable.getHeight(), (Map) null, new SlideModifier$measure$1(this, placeable, IntSizeKt.IntSize(placeable.getWidth(), placeable.getHeight())), 4, (Object) null);
    }
}
