package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\bH\u0002\u001a\u0015\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\"\u0010\u0017\u001a\u00020\u0018*\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0002\u001aO\u0010\u001c\u001a\u00020\u0018*\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u0012\u001a\u00020\bH\u0003¢\u0006\u0002\u0010(\u001aR\u0010)\u001a\u00020\u0018*\u00020\u00182\u0006\u0010*\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007\u001aF\u0010)\u001a\u00020\u0018*\u00020\u00182\u0006\u0010*\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"DefaultScrollMotionDurationScale", "Landroidx/compose/ui/MotionDurationScale;", "getDefaultScrollMotionDurationScale", "()Landroidx/compose/ui/MotionDurationScale;", "DefaultScrollMotionDurationScaleFactor", "", "ModifierLocalScrollableContainer", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "", "getModifierLocalScrollableContainer", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "NoOpScrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "scrollableNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "scrollLogic", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "enabled", "awaitScrollEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseWheelScroll", "Landroidx/compose/ui/Modifier;", "scrollingLogicState", "mouseWheelScrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "pointerScrollable", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "controller", "Landroidx/compose/foundation/gestures/ScrollableState;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/OverscrollEffect;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "scrollable", "state", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
public final class ScrollableKt {
    private static final MotionDurationScale DefaultScrollMotionDurationScale = new ScrollableKt$DefaultScrollMotionDurationScale$1();
    private static final float DefaultScrollMotionDurationScaleFactor = 1.0f;
    private static final ProvidableModifierLocal<Boolean> ModifierLocalScrollableContainer = ModifierLocalKt.modifierLocalOf(ScrollableKt$ModifierLocalScrollableContainer$1.INSTANCE);
    /* access modifiers changed from: private */
    public static final ScrollScope NoOpScrollScope = new ScrollableKt$NoOpScrollScope$1();

    public static /* synthetic */ Modifier scrollable$default(Modifier modifier, ScrollableState scrollableState, Orientation orientation, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        boolean z3;
        boolean z4;
        FlingBehavior flingBehavior2;
        MutableInteractionSource mutableInteractionSource2;
        if ((i & 4) != 0) {
            z3 = true;
        } else {
            z3 = z;
        }
        if ((i & 8) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        if ((i & 16) != 0) {
            flingBehavior2 = null;
        } else {
            flingBehavior2 = flingBehavior;
        }
        if ((i & 32) != 0) {
            mutableInteractionSource2 = null;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        return scrollable(modifier, scrollableState, orientation, z3, z4, flingBehavior2, mutableInteractionSource2);
    }

    public static final Modifier scrollable(Modifier $this$scrollable, ScrollableState state, Orientation orientation, boolean enabled, boolean reverseDirection, FlingBehavior flingBehavior, MutableInteractionSource interactionSource) {
        Intrinsics.checkNotNullParameter($this$scrollable, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return scrollable($this$scrollable, state, orientation, (OverscrollEffect) null, enabled, reverseDirection, flingBehavior, interactionSource);
    }

    public static /* synthetic */ Modifier scrollable$default(Modifier modifier, ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        boolean z3;
        FlingBehavior flingBehavior2;
        MutableInteractionSource mutableInteractionSource2;
        if ((i & 8) != 0) {
            z3 = true;
        } else {
            z3 = z;
        }
        boolean z4 = (i & 16) != 0 ? false : z2;
        if ((i & 32) != 0) {
            flingBehavior2 = null;
        } else {
            flingBehavior2 = flingBehavior;
        }
        if ((i & 64) != 0) {
            mutableInteractionSource2 = null;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        return scrollable(modifier, scrollableState, orientation, overscrollEffect, z3, z4, flingBehavior2, mutableInteractionSource2);
    }

    public static final Modifier scrollable(Modifier $this$scrollable, ScrollableState state, Orientation orientation, OverscrollEffect overscrollEffect, boolean enabled, boolean reverseDirection, FlingBehavior flingBehavior, MutableInteractionSource interactionSource) {
        Modifier modifier = $this$scrollable;
        Intrinsics.checkNotNullParameter($this$scrollable, "<this>");
        ScrollableState scrollableState = state;
        Intrinsics.checkNotNullParameter(state, "state");
        Orientation orientation2 = orientation;
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return ComposedModifierKt.composed($this$scrollable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ScrollableKt$scrollable$$inlined$debugInspectorInfo$1(orientation, state, overscrollEffect, enabled, reverseDirection, flingBehavior, interactionSource) : InspectableValueKt.getNoInspectorInfo(), new ScrollableKt$scrollable$2(orientation, state, reverseDirection, interactionSource, flingBehavior, overscrollEffect, enabled));
    }

    /* access modifiers changed from: private */
    public static final Modifier pointerScrollable(Modifier $this$pointerScrollable, MutableInteractionSource interactionSource, Orientation orientation, boolean reverseDirection, ScrollableState controller, FlingBehavior flingBehavior, OverscrollEffect overscrollEffect, boolean enabled, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Function0 function0;
        Object value$iv$iv4;
        Composer composer = $composer;
        int i = $changed;
        composer.startReplaceableGroup(-2012025036);
        ComposerKt.sourceInformation(composer, "C(pointerScrollable)P(3,4,6!1,2,5)251@10630L53,252@10706L224,262@10964L88,265@11078L46,266@11148L22,274@11392L47,275@11465L160:Scrollable.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2012025036, i, -1, "androidx.compose.foundation.gestures.pointerScrollable (Scrollable.kt:241)");
        }
        composer.startReplaceableGroup(-1730186281);
        ComposerKt.sourceInformation(composer, "250@10581L15");
        FlingBehavior fling = flingBehavior == null ? ScrollableDefaults.INSTANCE.flingBehavior(composer, 6) : flingBehavior;
        $composer.endReplaceableGroup();
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new NestedScrollDispatcher(), (SnapshotMutationPolicy) null, 2, (Object) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        MutableState nestedScrollDispatcher = (MutableState) value$iv$iv;
        State scrollLogic = SnapshotStateKt.rememberUpdatedState(new ScrollingLogic(orientation, reverseDirection, nestedScrollDispatcher, controller, fling, overscrollEffect), composer, 0);
        Object key1$iv = Boolean.valueOf(enabled);
        int i2 = (i >> 21) & 14;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed(key1$iv);
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv2 = scrollableNestedScrollConnection(scrollLogic, enabled);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            boolean z = enabled;
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        NestedScrollConnection nestedScrollConnection = value$iv$iv2;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv3 = $composer;
        Object it$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
        if (it$iv$iv3 == Composer.Companion.getEmpty()) {
            value$iv$iv3 = new ScrollDraggableState(scrollLogic);
            $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
        } else {
            value$iv$iv3 = it$iv$iv3;
        }
        $composer.endReplaceableGroup();
        ScrollDraggableState draggableState = (ScrollDraggableState) value$iv$iv3;
        ScrollConfig scrollConfig = AndroidScrollable_androidKt.platformScrollConfig(composer, 0);
        DraggableState draggableState2 = draggableState;
        Function1 function1 = ScrollableKt$pointerScrollable$1.INSTANCE;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = composer.changed((Object) scrollLogic);
        Composer $this$cache$iv$iv4 = $composer;
        Object it$iv$iv4 = $this$cache$iv$iv4.rememberedValue();
        if (invalid$iv$iv2 || it$iv$iv4 == Composer.Companion.getEmpty()) {
            ScrollDraggableState scrollDraggableState = draggableState;
            function0 = new ScrollableKt$pointerScrollable$2$1(scrollLogic);
            $this$cache$iv$iv4.updateRememberedValue(function0);
        } else {
            ScrollDraggableState scrollDraggableState2 = draggableState;
            function0 = it$iv$iv4;
        }
        $composer.endReplaceableGroup();
        Function0 function02 = function0;
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv3 = composer.changed((Object) nestedScrollDispatcher) | composer.changed((Object) scrollLogic);
        Composer $this$cache$iv$iv5 = $composer;
        Object it$iv$iv5 = $this$cache$iv$iv5.rememberedValue();
        if (invalid$iv$iv3 || it$iv$iv5 == Composer.Companion.getEmpty()) {
            value$iv$iv4 = (Function3) new ScrollableKt$pointerScrollable$3$1(nestedScrollDispatcher, scrollLogic, (Continuation<? super ScrollableKt$pointerScrollable$3$1>) null);
            $this$cache$iv$iv5.updateRememberedValue(value$iv$iv4);
        } else {
            value$iv$iv4 = it$iv$iv5;
        }
        $composer.endReplaceableGroup();
        Modifier nestedScroll = NestedScrollModifierKt.nestedScroll(mouseWheelScroll(DraggableKt.draggable$default($this$pointerScrollable, draggableState2, function1, orientation, enabled, interactionSource, function02, (Function3) null, (Function3) value$iv$iv4, false, 64, (Object) null), scrollLogic, scrollConfig), nestedScrollConnection, (NestedScrollDispatcher) nestedScrollDispatcher.getValue());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return nestedScroll;
    }

    private static final Modifier mouseWheelScroll(Modifier $this$mouseWheelScroll, State<ScrollingLogic> scrollingLogicState, ScrollConfig mouseWheelScrollConfig) {
        return SuspendingPointerInputFilterKt.pointerInput($this$mouseWheelScroll, scrollingLogicState, mouseWheelScrollConfig, new ScrollableKt$mouseWheelScroll$1(mouseWheelScrollConfig, scrollingLogicState, (Continuation<? super ScrollableKt$mouseWheelScroll$1>) null));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object awaitScrollEvent(androidx.compose.ui.input.pointer.AwaitPointerEventScope r6, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerEvent> r7) {
        /*
            boolean r0 = r7 instanceof androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1 r0 = (androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1 r0 = new androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1
            r0.<init>(r7)
        L_0x0019:
            r7 = r0
            java.lang.Object r0 = r7.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            switch(r2) {
                case 0: goto L_0x0037;
                case 1: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x002d:
            java.lang.Object r6 = r7.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r1
            r1 = r0
            goto L_0x004b
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r0)
        L_0x003a:
            r7.L$0 = r6
            r2 = 1
            r7.label = r2
            r3 = 0
            java.lang.Object r2 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r6, r3, r7, r2, r3)
            if (r2 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r5 = r1
            r1 = r0
            r0 = r2
            r2 = r5
        L_0x004b:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            int r3 = r0.m4612getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r4 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r4 = r4.m4628getScroll7fucELk()
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventType.m4619equalsimpl0(r3, r4)
            if (r3 == 0) goto L_0x005e
            return r0
        L_0x005e:
            r0 = r1
            r1 = r2
            goto L_0x003a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.awaitScrollEvent(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final NestedScrollConnection scrollableNestedScrollConnection(State<ScrollingLogic> scrollLogic, boolean enabled) {
        return new ScrollableKt$scrollableNestedScrollConnection$1(scrollLogic, enabled);
    }

    public static final ProvidableModifierLocal<Boolean> getModifierLocalScrollableContainer() {
        return ModifierLocalScrollableContainer;
    }

    public static final MotionDurationScale getDefaultScrollMotionDurationScale() {
        return DefaultScrollMotionDurationScale;
    }
}
