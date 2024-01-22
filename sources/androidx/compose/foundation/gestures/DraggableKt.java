package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u001a!\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0007\u001ad\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t*\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u00030\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00110\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001aS\u0010\u0017\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001aé\u0001\u0010 \u001a\u00020!*\u00020!2\u0006\u0010\"\u001a\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020\u000f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112>\b\u0002\u0010&\u001a8\b\u0001\u0012\u0004\u0012\u00020(\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050,\u0012\u0006\u0012\u0004\u0018\u00010-0'¢\u0006\u0002\b.2>\b\u0002\u0010/\u001a8\b\u0001\u0012\u0004\u0012\u00020(\u0012\u0013\u0012\u001100¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(1\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050,\u0012\u0006\u0012\u0004\u0018\u00010-0'¢\u0006\u0002\b.2\b\b\u0002\u0010\u001d\u001a\u00020\u000fH\u0000ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u00102\u001aÏ\u0001\u0010 \u001a\u00020!*\u00020!2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020\u000f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2>\b\u0002\u0010&\u001a8\b\u0001\u0012\u0004\u0012\u00020(\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050,\u0012\u0006\u0012\u0004\u0018\u00010-0'¢\u0006\u0002\b.2>\b\u0002\u0010/\u001a8\b\u0001\u0012\u0004\u0012\u00020(\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(1\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050,\u0012\u0006\u0012\u0004\u0018\u00010-0'¢\u0006\u0002\b.2\b\b\u0002\u0010\u001d\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u00103\u001aA\u00104\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00105\u001a\u0002062\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u0003H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a!\u0010:\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a!\u0010:\u001a\u00020\u0004*\u0002002\u0006\u0010\u0014\u001a\u00020\u0015H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010<\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006>"}, d2 = {"DraggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "onDelta", "Lkotlin/Function1;", "", "", "rememberDraggableState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/DraggableState;", "awaitDownAndSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "canDrag", "Landroidx/compose/runtime/State;", "", "startDragImmediately", "Lkotlin/Function0;", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/ui/input/pointer/util/VelocityTracker;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDrag", "startEvent", "initialDelta", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "Landroidx/compose/foundation/gestures/DragEvent;", "reverseDirection", "awaitDrag-Su4bsnU", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;JLandroidx/compose/ui/input/pointer/util/VelocityTracker;Lkotlinx/coroutines/channels/SendChannel;ZLandroidx/compose/foundation/gestures/Orientation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "draggable", "Landroidx/compose/ui/Modifier;", "state", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "Landroidx/compose/ui/unit/Velocity;", "velocity", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/DraggableState;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/DraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "onDragOrUp", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "onDrag", "onDragOrUp-Axegvzg", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/gestures/Orientation;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toFloat", "toFloat-3MmeM6k", "(JLandroidx/compose/foundation/gestures/Orientation;)F", "toFloat-sF-c-tU", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable.kt */
public final class DraggableKt {
    public static final DraggableState DraggableState(Function1<? super Float, Unit> onDelta) {
        Intrinsics.checkNotNullParameter(onDelta, "onDelta");
        return new DefaultDraggableState(onDelta);
    }

    public static final DraggableState rememberDraggableState(Function1<? super Float, Unit> onDelta, Composer $composer, int $changed) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(onDelta, "onDelta");
        $composer.startReplaceableGroup(-183245213);
        ComposerKt.sourceInformation($composer, "C(rememberDraggableState)139@5983L29,140@6024L61:Draggable.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-183245213, $changed, -1, "androidx.compose.foundation.gestures.rememberDraggableState (Draggable.kt:138)");
        }
        State onDeltaState = SnapshotStateKt.rememberUpdatedState(onDelta, $composer, $changed & 14);
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = DraggableState(new DraggableKt$rememberDraggableState$1$1(onDeltaState));
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        DraggableState draggableState = (DraggableState) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return draggableState;
    }

    public static /* synthetic */ Modifier draggable$default(Modifier modifier, DraggableState draggableState, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function3 function3, Function3 function32, boolean z3, int i, Object obj) {
        boolean z4;
        MutableInteractionSource mutableInteractionSource2;
        boolean z5;
        boolean z6;
        int i2 = i;
        if ((i2 & 4) != 0) {
            z4 = true;
        } else {
            z4 = z;
        }
        if ((i2 & 8) != 0) {
            mutableInteractionSource2 = null;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if ((i2 & 16) != 0) {
            z5 = false;
        } else {
            z5 = z2;
        }
        Function3 draggableKt$draggable$1 = (i2 & 32) != 0 ? new DraggableKt$draggable$1((Continuation<? super DraggableKt$draggable$1>) null) : function3;
        Function3 draggableKt$draggable$2 = (i2 & 64) != 0 ? new DraggableKt$draggable$2((Continuation<? super DraggableKt$draggable$2>) null) : function32;
        if ((i2 & 128) != 0) {
            z6 = false;
        } else {
            z6 = z3;
        }
        return draggable(modifier, draggableState, orientation, z4, mutableInteractionSource2, z5, draggableKt$draggable$1, draggableKt$draggable$2, z6);
    }

    public static final Modifier draggable(Modifier $this$draggable, DraggableState state, Orientation orientation, boolean enabled, MutableInteractionSource interactionSource, boolean startDragImmediately, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, boolean reverseDirection) {
        Orientation orientation2 = orientation;
        Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> function3 = onDragStopped;
        Intrinsics.checkNotNullParameter($this$draggable, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        Intrinsics.checkNotNullParameter(onDragStarted, "onDragStarted");
        Intrinsics.checkNotNullParameter(function3, "onDragStopped");
        return draggable($this$draggable, state, DraggableKt$draggable$3.INSTANCE, orientation, enabled, interactionSource, new DraggableKt$draggable$4(startDragImmediately), onDragStarted, new DraggableKt$draggable$5(function3, orientation2, (Continuation<? super DraggableKt$draggable$5>) null), reverseDirection);
    }

    public static /* synthetic */ Modifier draggable$default(Modifier modifier, DraggableState draggableState, Function1 function1, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, Function0 function0, Function3 function3, Function3 function32, boolean z2, int i, Object obj) {
        boolean z3;
        MutableInteractionSource mutableInteractionSource2;
        int i2 = i;
        if ((i2 & 8) != 0) {
            z3 = true;
        } else {
            z3 = z;
        }
        if ((i2 & 16) != 0) {
            mutableInteractionSource2 = null;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        return draggable(modifier, draggableState, function1, orientation, z3, mutableInteractionSource2, function0, (i2 & 64) != 0 ? new DraggableKt$draggable$6((Continuation<? super DraggableKt$draggable$6>) null) : function3, (i2 & 128) != 0 ? new DraggableKt$draggable$7((Continuation<? super DraggableKt$draggable$7>) null) : function32, (i2 & 256) != 0 ? false : z2);
    }

    public static final Modifier draggable(Modifier $this$draggable, DraggableState state, Function1<? super PointerInputChange, Boolean> canDrag, Orientation orientation, boolean enabled, MutableInteractionSource interactionSource, Function0<Boolean> startDragImmediately, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, boolean reverseDirection) {
        Modifier modifier = $this$draggable;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(canDrag, "canDrag");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(startDragImmediately, "startDragImmediately");
        Intrinsics.checkNotNullParameter(onDragStarted, "onDragStarted");
        Intrinsics.checkNotNullParameter(onDragStopped, "onDragStopped");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new DraggableKt$draggable$$inlined$debugInspectorInfo$1(canDrag, orientation, enabled, reverseDirection, interactionSource, startDragImmediately, onDragStarted, onDragStopped, state) : InspectableValueKt.getNoInspectorInfo(), new DraggableKt$draggable$9(interactionSource, startDragImmediately, canDrag, onDragStarted, onDragStopped, state, orientation, enabled, reverseDirection));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ec, code lost:
        r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00ff, code lost:
        if (((java.lang.Boolean) ((kotlin.jvm.functions.Function1) r8.getValue()).invoke(r10)).booleanValue() != false) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0113, code lost:
        if (((java.lang.Boolean) ((kotlin.jvm.functions.Function0) r7.getValue()).invoke()).booleanValue() == false) goto L_0x012b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0115, code lost:
        r10.consume();
        androidx.compose.ui.input.pointer.util.VelocityTrackerKt.addPointerInputChange(r6, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x012b, code lost:
        r0.L$0 = r9;
        r0.L$1 = r6;
        r0.L$2 = r3;
        r0.L$3 = null;
        r0.L$4 = null;
        r0.label = 2;
        r7 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r9, false, (androidx.compose.ui.input.pointer.PointerEventPass) null, r0, 2, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x014c, code lost:
        if (r7 != r2) goto L_0x014f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x014e, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x014f, code lost:
        r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7;
        androidx.compose.ui.input.pointer.util.VelocityTrackerKt.addPointerInputChange(r6, r7);
        r8 = new kotlin.jvm.internal.Ref.LongRef();
        r8.element = androidx.compose.ui.geometry.Offset.Companion.m2931getZeroF1C5BW0();
        r6 = new androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$postPointerSlop$1(r6, r8);
        r10 = r7.m4666getIdJ3iCeTQ();
        r7 = r7.m4670getTypeT8wyACA();
        r3 = androidx.compose.foundation.gestures.DragGestureDetectorKt.toPointerDirectionConfig(r3);
        r12 = 1;
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0182, code lost:
        if (androidx.compose.foundation.gestures.DragGestureDetectorKt.m556isPointerUpDmW0f2w(r9.getCurrentEvent(), r10) == false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0184, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0187, code lost:
        r7 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m557pointerSlopE8SPZFQ(r9.getViewConfiguration(), r7);
        r14 = new kotlin.jvm.internal.Ref.LongRef();
        r14.element = r10;
        r10 = 0.0f;
        r11 = 0.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0198, code lost:
        r0.L$0 = r8;
        r0.L$1 = r6;
        r0.L$2 = r9;
        r0.L$3 = r3;
        r0.L$4 = r14;
        r0.L$5 = r5;
        r0.I$0 = r12;
        r0.F$0 = r7;
        r0.F$1 = r10;
        r0.F$2 = r11;
        r0.label = 3;
        r15 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r9, r5, r0, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x01b4, code lost:
        if (r15 != r2) goto L_0x01b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x01b6, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x01b7, code lost:
        r23 = r2;
        r2 = r1;
        r1 = r15;
        r15 = r14;
        r14 = r13;
        r13 = r12;
        r12 = r11;
        r11 = r3;
        r3 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x01c2, code lost:
        r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1;
        r25 = r1.getChanges();
        r4 = r25.size();
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x01d8, code lost:
        if (r5 >= r4) goto L_0x020f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x01da, code lost:
        r26 = r2;
        r2 = r25;
        r19 = r2.get(r5);
        r27 = r2;
        r25 = r3;
        r28 = r8;
        r29 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x01fe, code lost:
        if (androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(((androidx.compose.ui.input.pointer.PointerInputChange) r19).m4666getIdJ3iCeTQ(), r15.element) == false) goto L_0x0201;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0201, code lost:
        r5 = r5 + 1;
        r3 = r25;
        r2 = r26;
        r25 = r27;
        r8 = r28;
        r9 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x020f, code lost:
        r27 = r25;
        r26 = r2;
        r25 = r3;
        r28 = r8;
        r29 = r9;
        r19 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x021c, code lost:
        r19 = (androidx.compose.ui.input.pointer.PointerInputChange) r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x021e, code lost:
        if (r19 != null) goto L_0x0227;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0220, code lost:
        r1 = r26;
        r8 = r28;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0227, code lost:
        r2 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x022d, code lost:
        if (r2.isConsumed() == false) goto L_0x0236;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x022f, code lost:
        r1 = r26;
        r8 = r28;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x023a, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r2) == false) goto L_0x0289;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x023c, code lost:
        r1 = r1.getChanges();
        r4 = 0;
        r5 = r1.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x024a, code lost:
        if (r4 >= r5) goto L_0x0264;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x024c, code lost:
        r9 = r1.get(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x025d, code lost:
        if (((androidx.compose.ui.input.pointer.PointerInputChange) r9).getPressed() == false) goto L_0x0260;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0260, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0264, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0266, code lost:
        r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0269, code lost:
        if (r1 != null) goto L_0x0272;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x026b, code lost:
        r1 = r26;
        r8 = r28;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0272, code lost:
        r15.element = r1.m4666getIdJ3iCeTQ();
        r2 = r25;
        r1 = r26;
        r8 = r28;
        r9 = r29;
        r3 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r4 = 1;
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0289, code lost:
        r3 = r2.m4667getPositionF1C5BW0();
        r8 = r2.m4668getPreviousPositionF1C5BW0();
        r1 = (r11.m583mainAxisDeltak4lQ0M(r3) - r11.m583mainAxisDeltak4lQ0M(r8)) + r10;
        r3 = (r11.m582crossAxisDeltak4lQ0M(r3) - r11.m582crossAxisDeltak4lQ0M(r8)) + r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x02a5, code lost:
        if (r13 == 0) goto L_0x02ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x02a7, code lost:
        r4 = java.lang.Math.abs(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x02ac, code lost:
        r4 = androidx.compose.ui.geometry.Offset.m2913getDistanceimpl(r11.m584offsetFromChangesdBAh8RU(r1, r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x02ba, code lost:
        if (r4 >= r7) goto L_0x02fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x02bc, code lost:
        r4 = androidx.compose.ui.input.pointer.PointerEventPass.Final;
        r8 = r28;
        r0.L$0 = r8;
        r0.L$1 = r6;
        r12 = r29;
        r0.L$2 = r12;
        r0.L$3 = r11;
        r0.L$4 = r15;
        r0.L$5 = r2;
        r0.I$0 = r13;
        r0.F$0 = r7;
        r0.F$1 = r1;
        r0.F$2 = r3;
        r0.label = 4;
        r5 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x02df, code lost:
        if (r12.awaitPointerEvent(r4, r0) != r5) goto L_0x02e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x02e1, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x02e2, code lost:
        r4 = r1;
        r10 = r2;
        r2 = r5;
        r9 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r1 = r26;
        r23 = r11;
        r11 = r3;
        r3 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x02f4, code lost:
        if (r10.isConsumed() == false) goto L_0x02f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x02f6, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x02f8, code lost:
        r10 = r4;
        r4 = 1;
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x02fd, code lost:
        r5 = r25;
        r8 = r28;
        r12 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0303, code lost:
        if (r13 == 0) goto L_0x0317;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0305, code lost:
        r16 = r11.m584offsetFromChangesdBAh8RU(r1 - (java.lang.Math.signum(r1) * r7), r3);
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0317, code lost:
        r9 = r11.m584offsetFromChangesdBAh8RU(r1, r3);
        r3 = r0;
        r16 = androidx.compose.ui.geometry.Offset.m2919minusMKHz9U(r9, androidx.compose.ui.geometry.Offset.m2922timestuRUvjQ(androidx.compose.ui.geometry.Offset.m2910divtuRUvjQ(r9, r4), r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x032b, code lost:
        r6.invoke(r2, androidx.compose.ui.geometry.Offset.m2904boximpl(r16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x033a, code lost:
        if (r2.isConsumed() == false) goto L_0x034f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x033c, code lost:
        r1 = r26;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0340, code lost:
        if (r2 == null) goto L_0x034d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x034d, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x034f, code lost:
        r10 = 0.0f;
        r1 = r26;
        r2 = r5;
        r9 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r4 = 1;
        r5 = null;
        r23 = r11;
        r11 = 0.0f;
        r0 = r3;
        r3 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        return kotlin.TuplesKt.to(r10, androidx.compose.ui.geometry.Offset.m2904boximpl(androidx.compose.ui.geometry.Offset.Companion.m2931getZeroF1C5BW0()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        return kotlin.TuplesKt.to(r2, androidx.compose.ui.geometry.Offset.m2904boximpl(r8.element));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object awaitDownAndSlop(androidx.compose.ui.input.pointer.AwaitPointerEventScope r25, androidx.compose.runtime.State<? extends kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Boolean>> r26, androidx.compose.runtime.State<? extends kotlin.jvm.functions.Function0<java.lang.Boolean>> r27, androidx.compose.ui.input.pointer.util.VelocityTracker r28, androidx.compose.foundation.gestures.Orientation r29, kotlin.coroutines.Continuation<? super kotlin.Pair<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset>> r30) {
        /*
            r0 = r30
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$1 r1 = (androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$1 r1 = new androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 1
            r5 = 0
            switch(r3) {
                case 0: goto L_0x00c3;
                case 1: goto L_0x00aa;
                case 2: goto L_0x0097;
                case 3: goto L_0x0067;
                case 4: goto L_0x0031;
                default: goto L_0x0029;
            }
        L_0x0029:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0031:
            r3 = 0
            float r6 = r0.F$2
            float r7 = r0.F$1
            float r8 = r0.F$0
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$5
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            java.lang.Object r11 = r0.L$4
            kotlin.jvm.internal.Ref$LongRef r11 = (kotlin.jvm.internal.Ref.LongRef) r11
            java.lang.Object r12 = r0.L$3
            androidx.compose.foundation.gestures.PointerDirectionConfig r12 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r12
            java.lang.Object r13 = r0.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            java.lang.Object r14 = r0.L$1
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            java.lang.Object r15 = r0.L$0
            kotlin.jvm.internal.Ref$LongRef r15 = (kotlin.jvm.internal.Ref.LongRef) r15
            kotlin.ResultKt.throwOnFailure(r1)
            r4 = r7
            r7 = r8
            r8 = r15
            r23 = r13
            r13 = r3
            r3 = r12
            r12 = r9
            r9 = r23
            r24 = r11
            r11 = r6
            r6 = r14
            r14 = r24
            goto L_0x02f0
        L_0x0067:
            r3 = 0
            float r6 = r0.F$2
            float r7 = r0.F$1
            float r8 = r0.F$0
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$4
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r11 = r0.L$3
            androidx.compose.foundation.gestures.PointerDirectionConfig r11 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r11
            java.lang.Object r12 = r0.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
            java.lang.Object r13 = r0.L$1
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            java.lang.Object r14 = r0.L$0
            kotlin.jvm.internal.Ref$LongRef r14 = (kotlin.jvm.internal.Ref.LongRef) r14
            kotlin.ResultKt.throwOnFailure(r1)
            r15 = r10
            r10 = r7
            r7 = r8
            r8 = r14
            r14 = r3
            r3 = r2
            r2 = r1
            r23 = r12
            r12 = r6
            r6 = r13
            r13 = r9
            r9 = r23
            goto L_0x01c2
        L_0x0097:
            java.lang.Object r3 = r0.L$2
            androidx.compose.foundation.gestures.Orientation r3 = (androidx.compose.foundation.gestures.Orientation) r3
            java.lang.Object r6 = r0.L$1
            androidx.compose.ui.input.pointer.util.VelocityTracker r6 = (androidx.compose.ui.input.pointer.util.VelocityTracker) r6
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r1)
            r9 = r7
            r7 = r1
            goto L_0x014f
        L_0x00aa:
            java.lang.Object r3 = r0.L$4
            androidx.compose.foundation.gestures.Orientation r3 = (androidx.compose.foundation.gestures.Orientation) r3
            java.lang.Object r6 = r0.L$3
            androidx.compose.ui.input.pointer.util.VelocityTracker r6 = (androidx.compose.ui.input.pointer.util.VelocityTracker) r6
            java.lang.Object r7 = r0.L$2
            androidx.compose.runtime.State r7 = (androidx.compose.runtime.State) r7
            java.lang.Object r8 = r0.L$1
            androidx.compose.runtime.State r8 = (androidx.compose.runtime.State) r8
            java.lang.Object r9 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            kotlin.ResultKt.throwOnFailure(r1)
            r10 = r1
            goto L_0x00ec
        L_0x00c3:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r25
            r7 = r27
            r6 = r29
            r8 = r26
            r9 = r28
            androidx.compose.ui.input.pointer.PointerEventPass r10 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
            r0.L$0 = r3
            r0.L$1 = r8
            r0.L$2 = r7
            r0.L$3 = r9
            r0.L$4 = r6
            r0.label = r4
            r11 = 0
            java.lang.Object r10 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r3, r11, r10, r0)
            if (r10 != r2) goto L_0x00e6
            return r2
        L_0x00e6:
            r23 = r9
            r9 = r3
            r3 = r6
            r6 = r23
        L_0x00ec:
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            java.lang.Object r11 = r8.getValue()
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            java.lang.Object r11 = r11.invoke(r10)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L_0x0103
            goto L_0x034e
        L_0x0103:
            java.lang.Object r8 = r7.getValue()
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            java.lang.Object r8 = r8.invoke()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x012b
            r10.consume()
            androidx.compose.ui.input.pointer.util.VelocityTrackerKt.addPointerInputChange(r6, r10)
            androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.ui.geometry.Offset.Companion
            long r4 = r2.m2931getZeroF1C5BW0()
            androidx.compose.ui.geometry.Offset r2 = androidx.compose.ui.geometry.Offset.m2904boximpl(r4)
            kotlin.Pair r5 = kotlin.TuplesKt.to(r10, r2)
            goto L_0x034e
        L_0x012b:
            r7 = 0
            r8 = 0
            r10 = 2
            r11 = 0
            r0.L$0 = r9
            r0.L$1 = r6
            r0.L$2 = r3
            r0.L$3 = r5
            r0.L$4 = r5
            r12 = 2
            r0.label = r12
            r25 = r9
            r26 = r7
            r27 = r8
            r28 = r0
            r29 = r10
            r30 = r11
            java.lang.Object r7 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r25, r26, r27, r28, r29, r30)
            if (r7 != r2) goto L_0x014f
            return r2
        L_0x014f:
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            androidx.compose.ui.input.pointer.util.VelocityTrackerKt.addPointerInputChange(r6, r7)
            kotlin.jvm.internal.Ref$LongRef r8 = new kotlin.jvm.internal.Ref$LongRef
            r8.<init>()
            androidx.compose.ui.geometry.Offset$Companion r10 = androidx.compose.ui.geometry.Offset.Companion
            long r10 = r10.m2931getZeroF1C5BW0()
            r8.element = r10
            androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$postPointerSlop$1 r10 = new androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$postPointerSlop$1
            r10.<init>(r6, r8)
            r6 = r10
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            long r10 = r7.m4666getIdJ3iCeTQ()
            int r7 = r7.m4670getTypeT8wyACA()
            androidx.compose.foundation.gestures.PointerDirectionConfig r3 = androidx.compose.foundation.gestures.DragGestureDetectorKt.toPointerDirectionConfig(r3)
            r12 = 1
            r13 = 0
            androidx.compose.ui.input.pointer.PointerEvent r14 = r9.getCurrentEvent()
            boolean r14 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m556isPointerUpDmW0f2w(r14, r10)
            if (r14 == 0) goto L_0x0187
            r2 = r5
            goto L_0x033f
        L_0x0187:
            androidx.compose.ui.platform.ViewConfiguration r14 = r9.getViewConfiguration()
            float r7 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m557pointerSlopE8SPZFQ(r14, r7)
            kotlin.jvm.internal.Ref$LongRef r14 = new kotlin.jvm.internal.Ref$LongRef
            r14.<init>()
            r14.element = r10
            r10 = 0
            r11 = 0
        L_0x0198:
            r0.L$0 = r8
            r0.L$1 = r6
            r0.L$2 = r9
            r0.L$3 = r3
            r0.L$4 = r14
            r0.L$5 = r5
            r0.I$0 = r12
            r0.F$0 = r7
            r0.F$1 = r10
            r0.F$2 = r11
            r15 = 3
            r0.label = r15
            java.lang.Object r15 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r9, r5, r0, r4, r5)
            if (r15 != r2) goto L_0x01b7
            return r2
        L_0x01b7:
            r23 = r2
            r2 = r1
            r1 = r15
            r15 = r14
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r3
            r3 = r23
        L_0x01c2:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            java.util.List r16 = r1.getChanges()
            r17 = 0
            r25 = r16
            r16 = 0
            r18 = 0
            int r4 = r25.size()
            r5 = r18
        L_0x01d8:
            if (r5 >= r4) goto L_0x020f
            r26 = r2
            r2 = r25
            java.lang.Object r18 = r2.get(r5)
            r19 = r18
            r20 = 0
            r21 = r19
            androidx.compose.ui.input.pointer.PointerInputChange r21 = (androidx.compose.ui.input.pointer.PointerInputChange) r21
            r22 = 0
            r27 = r2
            r25 = r3
            long r2 = r21.m4666getIdJ3iCeTQ()
            r28 = r8
            r29 = r9
            long r8 = r15.element
            boolean r2 = androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r2, r8)
            if (r2 == 0) goto L_0x0201
            goto L_0x021c
        L_0x0201:
            int r5 = r5 + 1
            r3 = r25
            r2 = r26
            r25 = r27
            r8 = r28
            r9 = r29
            goto L_0x01d8
        L_0x020f:
            r27 = r25
            r26 = r2
            r25 = r3
            r28 = r8
            r29 = r9
            r19 = 0
        L_0x021c:
            androidx.compose.ui.input.pointer.PointerInputChange r19 = (androidx.compose.ui.input.pointer.PointerInputChange) r19
            if (r19 != 0) goto L_0x0227
            r1 = r26
            r8 = r28
            r2 = 0
            goto L_0x033f
        L_0x0227:
            r2 = r19
            boolean r3 = r2.isConsumed()
            if (r3 == 0) goto L_0x0236
            r1 = r26
            r8 = r28
            r2 = 0
            goto L_0x033f
        L_0x0236:
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r2)
            if (r3 == 0) goto L_0x0289
            java.util.List r1 = r1.getChanges()
            r2 = 0
            r3 = 0
            r4 = 0
            int r5 = r1.size()
        L_0x024a:
            if (r4 >= r5) goto L_0x0264
            java.lang.Object r8 = r1.get(r4)
            r9 = r8
            r16 = 0
            r17 = r9
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            r18 = 0
            boolean r17 = r17.getPressed()
            if (r17 == 0) goto L_0x0260
            goto L_0x0266
        L_0x0260:
            int r4 = r4 + 1
            goto L_0x024a
        L_0x0264:
            r9 = 0
        L_0x0266:
            r1 = r9
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            if (r1 != 0) goto L_0x0272
            r1 = r26
            r8 = r28
            r2 = 0
            goto L_0x033f
        L_0x0272:
            long r2 = r1.m4666getIdJ3iCeTQ()
            r15.element = r2
            r2 = r25
            r1 = r26
            r8 = r28
            r9 = r29
            r3 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r4 = 1
            r5 = 0
            goto L_0x0198
        L_0x0289:
            long r3 = r2.m4667getPositionF1C5BW0()
            long r8 = r2.m4668getPreviousPositionF1C5BW0()
            float r1 = r11.m583mainAxisDeltak4lQ0M(r3)
            float r5 = r11.m583mainAxisDeltak4lQ0M(r8)
            float r1 = r1 - r5
            float r3 = r11.m582crossAxisDeltak4lQ0M(r3)
            float r4 = r11.m582crossAxisDeltak4lQ0M(r8)
            float r3 = r3 - r4
            float r1 = r1 + r10
            float r3 = r3 + r12
            if (r13 == 0) goto L_0x02ac
            float r4 = java.lang.Math.abs(r1)
            goto L_0x02b7
        L_0x02ac:
            long r4 = r11.m584offsetFromChangesdBAh8RU(r1, r3)
            float r4 = androidx.compose.ui.geometry.Offset.m2913getDistanceimpl(r4)
        L_0x02b7:
            int r5 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r5 >= 0) goto L_0x02fd
            androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r8 = r28
            r0.L$0 = r8
            r0.L$1 = r6
            r12 = r29
            r0.L$2 = r12
            r0.L$3 = r11
            r0.L$4 = r15
            r0.L$5 = r2
            r0.I$0 = r13
            r0.F$0 = r7
            r0.F$1 = r1
            r0.F$2 = r3
            r5 = 4
            r0.label = r5
            java.lang.Object r4 = r12.awaitPointerEvent(r4, r0)
            r5 = r25
            if (r4 != r5) goto L_0x02e2
            return r5
        L_0x02e2:
            r4 = r1
            r10 = r2
            r2 = r5
            r9 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r1 = r26
            r23 = r11
            r11 = r3
            r3 = r23
        L_0x02f0:
            boolean r5 = r10.isConsumed()
            if (r5 == 0) goto L_0x02f8
            r2 = 0
            goto L_0x033f
        L_0x02f8:
            r10 = r4
            r4 = 1
            r5 = 0
            goto L_0x0198
        L_0x02fd:
            r5 = r25
            r8 = r28
            r12 = r29
            if (r13 == 0) goto L_0x0317
            float r4 = java.lang.Math.signum(r1)
            float r4 = r4 * r7
            float r1 = r1 - r4
            long r3 = r11.m584offsetFromChangesdBAh8RU(r1, r3)
            r16 = r3
            r3 = r0
            goto L_0x032b
        L_0x0317:
            long r9 = r11.m584offsetFromChangesdBAh8RU(r1, r3)
            r3 = r0
            long r0 = androidx.compose.ui.geometry.Offset.m2910divtuRUvjQ(r9, r4)
            long r0 = androidx.compose.ui.geometry.Offset.m2922timestuRUvjQ(r0, r7)
            long r16 = androidx.compose.ui.geometry.Offset.m2919minusMKHz9U(r9, r0)
        L_0x032b:
            r0 = r16
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m2904boximpl(r0)
            r6.invoke(r2, r4)
            boolean r4 = r2.isConsumed()
            if (r4 == 0) goto L_0x034f
            r1 = r26
            r0 = r3
        L_0x033f:
            if (r2 == 0) goto L_0x034d
            long r3 = r8.element
            androidx.compose.ui.geometry.Offset r3 = androidx.compose.ui.geometry.Offset.m2904boximpl(r3)
            kotlin.Pair r5 = kotlin.TuplesKt.to(r2, r3)
            goto L_0x034e
        L_0x034d:
            r5 = 0
        L_0x034e:
            return r5
        L_0x034f:
            r10 = 0
            r0 = 0
            r1 = r26
            r2 = r5
            r9 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r4 = 1
            r5 = 0
            r23 = r11
            r11 = r0
            r0 = r3
            r3 = r23
            goto L_0x0198
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.awaitDownAndSlop(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.runtime.State, androidx.compose.runtime.State, androidx.compose.ui.input.pointer.util.VelocityTracker, androidx.compose.foundation.gestures.Orientation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* renamed from: awaitDrag-Su4bsnU  reason: not valid java name */
    public static final Object m573awaitDragSu4bsnU(AwaitPointerEventScope $this$awaitDrag_u2dSu4bsnU, PointerInputChange startEvent, long initialDelta, VelocityTracker velocityTracker, SendChannel<? super DragEvent> channel, boolean reverseDirection, Orientation orientation, Continuation<? super Boolean> $completion) {
        SendChannel<? super DragEvent> sendChannel = channel;
        boolean z = reverseDirection;
        long overSlopOffset = initialDelta;
        sendChannel.m252trySendJP2dKIU(new DragEvent.DragStarted(Offset.m2919minusMKHz9U(startEvent.m4667getPositionF1C5BW0(), OffsetKt.Offset(Offset.m2915getXimpl(overSlopOffset) * Math.signum(Offset.m2915getXimpl(startEvent.m4667getPositionF1C5BW0())), Offset.m2916getYimpl(overSlopOffset) * Math.signum(Offset.m2916getYimpl(startEvent.m4667getPositionF1C5BW0())))), (DefaultConstructorMarker) null));
        sendChannel.m252trySendJP2dKIU(new DragEvent.DragDelta(z ? Offset.m2922timestuRUvjQ(initialDelta, -1.0f) : initialDelta, (DefaultConstructorMarker) null));
        return m574onDragOrUpAxegvzg($this$awaitDrag_u2dSu4bsnU, orientation, startEvent.m4666getIdJ3iCeTQ(), new DraggableKt$awaitDrag$2(velocityTracker, sendChannel, z), $completion);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x015f, code lost:
        if ((!(((java.lang.Number) r12.invoke(r2)).floatValue() == 0.0f)) != false) goto L_0x0162;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: onDragOrUp-Axegvzg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m574onDragOrUpAxegvzg(androidx.compose.ui.input.pointer.AwaitPointerEventScope r23, androidx.compose.foundation.gestures.Orientation r24, long r25, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r27, kotlin.coroutines.Continuation<? super java.lang.Boolean> r28) {
        /*
            r0 = r28
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DraggableKt$onDragOrUp$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DraggableKt$onDragOrUp$1 r1 = (androidx.compose.foundation.gestures.DraggableKt$onDragOrUp$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DraggableKt$onDragOrUp$1 r1 = new androidx.compose.foundation.gestures.DraggableKt$onDragOrUp$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r5 = 1
            r6 = 0
            switch(r3) {
                case 0: goto L_0x0055;
                case 1: goto L_0x0031;
                default: goto L_0x0029;
            }
        L_0x0029:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0031:
            r3 = 0
            r7 = 0
            java.lang.Object r8 = r0.L$4
            kotlin.jvm.internal.Ref$LongRef r8 = (kotlin.jvm.internal.Ref.LongRef) r8
            java.lang.Object r9 = r0.L$3
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            java.lang.Object r10 = r0.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r0.L$1
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            java.lang.Object r12 = r0.L$0
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            kotlin.ResultKt.throwOnFailure(r1)
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r3
            r3 = r2
            r2 = r1
            goto L_0x00b7
        L_0x0055:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r23
            r7 = r25
            r9 = r27
            r10 = r24
            androidx.compose.foundation.gestures.Orientation r11 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r10 != r11) goto L_0x0069
            androidx.compose.foundation.gestures.DraggableKt$onDragOrUp$motionFromChange$1 r11 = androidx.compose.foundation.gestures.DraggableKt$onDragOrUp$motionFromChange$1.INSTANCE
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            goto L_0x006e
        L_0x0069:
            androidx.compose.foundation.gestures.DraggableKt$onDragOrUp$motionFromChange$2 r10 = androidx.compose.foundation.gestures.DraggableKt$onDragOrUp$motionFromChange$2.INSTANCE
            r11 = r10
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
        L_0x006e:
            r10 = r11
            r11 = 0
            androidx.compose.ui.input.pointer.PointerEvent r12 = r3.getCurrentEvent()
            boolean r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m556isPointerUpDmW0f2w(r12, r7)
            if (r12 == 0) goto L_0x0081
            r2 = r1
            r3 = r5
            r1 = r6
            goto L_0x0180
        L_0x0081:
            r12 = r7
        L_0x0082:
            r7 = r3
            r8 = 0
            kotlin.jvm.internal.Ref$LongRef r14 = new kotlin.jvm.internal.Ref$LongRef
            r14.<init>()
            r14.element = r12
            r12 = r9
            r9 = r7
            r7 = r8
            r8 = r14
            r22 = r10
            r10 = r3
            r3 = r11
            r11 = r22
        L_0x0096:
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r10
            r0.L$3 = r9
            r0.L$4 = r8
            r0.label = r5
            java.lang.Object r13 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r9, r6, r0, r5, r6)
            if (r13 != r2) goto L_0x00aa
            return r2
        L_0x00aa:
            r22 = r2
            r2 = r1
            r1 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r3
            r3 = r22
        L_0x00b7:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            java.util.List r14 = r1.getChanges()
            r15 = 0
            r16 = 0
            r17 = 0
            int r4 = r14.size()
            r6 = r17
        L_0x00cb:
            if (r6 >= r4) goto L_0x00f7
            java.lang.Object r17 = r14.get(r6)
            r18 = r17
            r19 = 0
            r20 = r18
            androidx.compose.ui.input.pointer.PointerInputChange r20 = (androidx.compose.ui.input.pointer.PointerInputChange) r20
            r21 = 0
            r23 = r6
            long r5 = r20.m4666getIdJ3iCeTQ()
            r24 = r2
            r25 = r3
            long r2 = r9.element
            boolean r2 = androidx.compose.ui.input.pointer.PointerId.m4652equalsimpl0(r5, r2)
            if (r2 == 0) goto L_0x00ee
            goto L_0x0100
        L_0x00ee:
            int r6 = r23 + 1
            r2 = r24
            r3 = r25
            r5 = 1
            goto L_0x00cb
        L_0x00f7:
            r24 = r2
            r25 = r3
            r23 = r6
            r18 = 0
        L_0x0100:
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            if (r18 != 0) goto L_0x0107
            r2 = 0
            r3 = 1
            goto L_0x0162
        L_0x0107:
            r2 = r18
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r2)
            if (r3 == 0) goto L_0x0149
            java.util.List r1 = r1.getChanges()
            r3 = 0
            r4 = 0
            r5 = 0
            int r6 = r1.size()
        L_0x011d:
            if (r5 >= r6) goto L_0x0137
            java.lang.Object r14 = r1.get(r5)
            r15 = r14
            r16 = 0
            r17 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            r18 = 0
            boolean r17 = r17.getPressed()
            if (r17 == 0) goto L_0x0133
            goto L_0x0139
        L_0x0133:
            int r5 = r5 + 1
            goto L_0x011d
        L_0x0137:
            r15 = 0
        L_0x0139:
            r1 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            if (r1 != 0) goto L_0x0140
            r3 = 1
            goto L_0x0162
        L_0x0140:
            long r2 = r1.m4666getIdJ3iCeTQ()
            r9.element = r2
            r3 = 1
            goto L_0x01a9
        L_0x0149:
            r1 = r2
            r3 = 0
            java.lang.Object r4 = r12.invoke(r1)
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x015c
            r1 = 1
            goto L_0x015d
        L_0x015c:
            r1 = 0
        L_0x015d:
            r3 = 1
            r1 = r1 ^ r3
            if (r1 == 0) goto L_0x01a9
        L_0x0162:
            if (r2 != 0) goto L_0x0169
            r2 = r24
            r9 = r13
            r1 = 0
            goto L_0x0180
        L_0x0169:
            r1 = r2
            r4 = 0
            boolean r2 = r2.isConsumed()
            if (r2 == 0) goto L_0x0177
            r2 = r24
            r9 = r13
            r1 = 0
            goto L_0x0180
        L_0x0177:
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r1)
            if (r2 == 0) goto L_0x0195
            r2 = r24
            r9 = r13
        L_0x0180:
            if (r1 == 0) goto L_0x018a
            r9.invoke(r1)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            goto L_0x018b
        L_0x018a:
            r6 = 0
        L_0x018b:
            if (r6 == 0) goto L_0x018f
            r4 = r3
            goto L_0x0190
        L_0x018f:
            r4 = 0
        L_0x0190:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r1
        L_0x0195:
            r13.invoke(r1)
            long r1 = r1.m4666getIdJ3iCeTQ()
            r5 = r3
            r3 = r11
            r10 = r12
            r9 = r13
            r6 = 0
            r12 = r1
            r11 = r7
            r1 = r24
            r2 = r25
            goto L_0x0082
        L_0x01a9:
            r1 = r24
            r2 = r25
            r5 = r3
            r3 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r6 = 0
            goto L_0x0096
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.m574onDragOrUpAxegvzg(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.gestures.Orientation, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* renamed from: toFloat-3MmeM6k  reason: not valid java name */
    public static final float m575toFloat3MmeM6k(long $this$toFloat_u2d3MmeM6k, Orientation orientation) {
        return orientation == Orientation.Vertical ? Offset.m2916getYimpl($this$toFloat_u2d3MmeM6k) : Offset.m2915getXimpl($this$toFloat_u2d3MmeM6k);
    }

    /* access modifiers changed from: private */
    /* renamed from: toFloat-sF-c-tU  reason: not valid java name */
    public static final float m576toFloatsFctU(long $this$toFloat_u2dsF_u2dc_u2dtU, Orientation orientation) {
        return orientation == Orientation.Vertical ? Velocity.m6212getYimpl($this$toFloat_u2dsF_u2dc_u2dtU) : Velocity.m6211getXimpl($this$toFloat_u2dsF_u2dc_u2dtU);
    }
}
