package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001f\u0010\t\u001a\u00020\n*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a)\u0010\t\u001a\u00020\n*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u001f\u0010\u0012\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u0015\u0010\u0015\u001a\u00020\u0005*\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001aa\u0010\u0017\u001a\u00020\u0005*\u00020\u00182/\b\u0002\u0010\u0019\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001bH@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u0001\u0010\u001d\u001a\u00020\u0005*\u00020\u00182\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2/\b\u0002\u0010\u0019\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001bH@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010 \u001a\u0017\u0010!\u001a\u0004\u0018\u00010\n*\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a!\u0010!\u001a\u0004\u0018\u00010\n*\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\"\"=\u0010\u0000\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u0007X\u0004ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"NoPressGesture", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "awaitFirstDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "requireUnconsumed", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLandroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSecondDown", "firstUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeUntilUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapAndPress", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onPress", "onTap", "Lkotlin/Function1;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapGestures", "onDoubleTap", "onLongPress", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForUpOrCancellation", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TapGestureDetector.kt */
public final class TapGestureDetectorKt {
    /* access modifiers changed from: private */
    public static final Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> NoPressGesture = new TapGestureDetectorKt$NoPressGesture$1((Continuation<? super TapGestureDetectorKt$NoPressGesture$1>) null);

    public static /* synthetic */ Object detectTapGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function1 function12, Function3 function3, Function1 function13, Continuation continuation, int i, Object obj) {
        Function1 function14;
        Function1 function15;
        Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function32;
        Function1 function16;
        if ((i & 1) != 0) {
            function14 = null;
        } else {
            function14 = function1;
        }
        if ((i & 2) != 0) {
            function15 = null;
        } else {
            function15 = function12;
        }
        if ((i & 4) != 0) {
            function32 = NoPressGesture;
        } else {
            function32 = function3;
        }
        if ((i & 8) != 0) {
            function16 = null;
        } else {
            function16 = function13;
        }
        return detectTapGestures(pointerInputScope, function14, function15, function32, function16, continuation);
    }

    public static final Object detectTapGestures(PointerInputScope $this$detectTapGestures, Function1<? super Offset, Unit> onDoubleTap, Function1<? super Offset, Unit> onLongPress, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onPress, Function1<? super Offset, Unit> onTap, Continuation<? super Unit> $completion) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TapGestureDetectorKt$detectTapGestures$2($this$detectTapGestures, onPress, onLongPress, onDoubleTap, onTap, (Continuation<? super TapGestureDetectorKt$detectTapGestures$2>) null), $completion);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object consumeUntilUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            boolean r0 = r15 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1
            r0.<init>(r15)
        L_0x0019:
            r15 = r0
            java.lang.Object r0 = r15.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r15.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x0038;
                case 1: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x002e:
            java.lang.Object r14 = r15.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r1
            r1 = r0
            goto L_0x004b
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r0)
        L_0x003b:
            r15.L$0 = r14
            r15.label = r3
            r2 = 0
            java.lang.Object r2 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r14, r2, r15, r3, r2)
            if (r2 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r13 = r1
            r1 = r0
            r0 = r2
            r2 = r13
        L_0x004b:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            java.util.List r4 = r0.getChanges()
            r5 = 0
            r6 = 0
            int r7 = r4.size()
        L_0x0058:
            if (r6 >= r7) goto L_0x0069
            java.lang.Object r8 = r4.get(r6)
            r9 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            r10 = 0
            r9.consume()
            int r6 = r6 + 1
            goto L_0x0058
        L_0x0069:
            java.util.List r0 = r0.getChanges()
            r4 = 0
            r5 = 0
            r6 = 0
            int r7 = r0.size()
        L_0x0078:
            if (r6 >= r7) goto L_0x0090
            java.lang.Object r8 = r0.get(r6)
            r9 = r8
            r10 = 0
            r11 = r9
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            r12 = 0
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L_0x008c
            r0 = r3
            goto L_0x0092
        L_0x008c:
            int r6 = r6 + 1
            goto L_0x0078
        L_0x0090:
            r0 = 0
        L_0x0092:
            if (r0 != 0) goto L_0x0097
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0097:
            r0 = r1
            r1 = r2
            goto L_0x003b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final Object awaitSecondDown(AwaitPointerEventScope $this$awaitSecondDown, PointerInputChange firstUp, Continuation<? super PointerInputChange> $completion) {
        return $this$awaitSecondDown.withTimeoutOrNull($this$awaitSecondDown.getViewConfiguration().getDoubleTapTimeoutMillis(), new TapGestureDetectorKt$awaitSecondDown$2(firstUp, (Continuation<? super TapGestureDetectorKt$awaitSecondDown$2>) null), $completion);
    }

    public static /* synthetic */ Object detectTapAndPress$default(PointerInputScope pointerInputScope, Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function3 = NoPressGesture;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        return detectTapAndPress(pointerInputScope, function3, function1, continuation);
    }

    public static final Object detectTapAndPress(PointerInputScope $this$detectTapAndPress, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onPress, Function1<? super Offset, Unit> onTap, Continuation<? super Unit> $completion) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TapGestureDetectorKt$detectTapAndPress$2($this$detectTapAndPress, onPress, onTap, new PressGestureScopeImpl($this$detectTapAndPress), (Continuation<? super TapGestureDetectorKt$detectTapAndPress$2>) null), $completion);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return awaitFirstDown(awaitPointerEventScope, z, PointerEventPass.Main, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object awaitFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, boolean r20, androidx.compose.ui.input.pointer.PointerEventPass r21, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r22) {
        /*
            r0 = r22
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r1 = (androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r1 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 1
            switch(r3) {
                case 0: goto L_0x0043;
                case 1: goto L_0x0030;
                default: goto L_0x0028;
            }
        L_0x0028:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0030:
            boolean r3 = r0.Z$0
            java.lang.Object r5 = r0.L$1
            androidx.compose.ui.input.pointer.PointerEventPass r5 = (androidx.compose.ui.input.pointer.PointerEventPass) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
            kotlin.ResultKt.throwOnFailure(r1)
            r7 = r6
            r6 = r5
            r5 = r3
            r3 = r2
            r2 = r1
            goto L_0x0069
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r19
            r5 = r21
            r6 = r20
            r18 = r6
            r6 = r3
            r3 = r18
        L_0x0051:
            r0.L$0 = r6
            r0.L$1 = r5
            r0.Z$0 = r3
            r0.label = r4
            java.lang.Object r7 = r6.awaitPointerEvent(r5, r0)
            if (r7 != r2) goto L_0x0060
            return r2
        L_0x0060:
            r18 = r2
            r2 = r1
            r1 = r7
            r7 = r6
            r6 = r5
            r5 = r3
            r3 = r18
        L_0x0069:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            java.util.List r8 = r1.getChanges()
            r9 = 0
            r10 = 0
            r11 = 0
            int r12 = r8.size()
        L_0x0079:
            r13 = 0
            if (r11 >= r12) goto L_0x0099
            java.lang.Object r14 = r8.get(r11)
            r15 = 0
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            r16 = 0
            if (r5 == 0) goto L_0x008d
            boolean r17 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDown(r14)
            goto L_0x0091
        L_0x008d:
            boolean r17 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r14)
        L_0x0091:
            if (r17 != 0) goto L_0x0095
            r8 = r13
            goto L_0x009b
        L_0x0095:
            int r11 = r11 + 1
            goto L_0x0079
        L_0x0099:
            r8 = r4
        L_0x009b:
            if (r8 == 0) goto L_0x00a6
            java.util.List r3 = r1.getChanges()
            java.lang.Object r3 = r3.get(r13)
            return r3
        L_0x00a6:
            r1 = r2
            r2 = r3
            r3 = r5
            r5 = r6
            r6 = r7
            goto L_0x0051
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return awaitFirstDown(awaitPointerEventScope, z, pointerEventPass, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0136 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0132 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object waitForUpOrCancellation(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, androidx.compose.ui.input.pointer.PointerEventPass r21, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r22) {
        /*
            r0 = r22
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2 r1 = (androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2 r1 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 0
            r5 = 0
            r6 = 1
            switch(r3) {
                case 0: goto L_0x0052;
                case 1: goto L_0x0042;
                case 2: goto L_0x0032;
                default: goto L_0x002a;
            }
        L_0x002a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0032:
            java.lang.Object r3 = r0.L$1
            androidx.compose.ui.input.pointer.PointerEventPass r3 = (androidx.compose.ui.input.pointer.PointerEventPass) r3
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r1)
            r5 = r3
            r3 = r2
            r2 = r1
            goto L_0x010a
        L_0x0042:
            java.lang.Object r3 = r0.L$1
            androidx.compose.ui.input.pointer.PointerEventPass r3 = (androidx.compose.ui.input.pointer.PointerEventPass) r3
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r1)
            r8 = r7
            r7 = r3
            r3 = r2
            r2 = r1
            goto L_0x006e
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r20
            r7 = r21
        L_0x0059:
            r0.L$0 = r3
            r0.L$1 = r7
            r0.label = r6
            java.lang.Object r8 = r3.awaitPointerEvent(r7, r0)
            if (r8 != r2) goto L_0x0067
            return r2
        L_0x0067:
            r19 = r2
            r2 = r1
            r1 = r8
            r8 = r3
            r3 = r19
        L_0x006e:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            java.util.List r9 = r1.getChanges()
            r10 = 0
            r11 = 0
            r12 = 0
            int r13 = r9.size()
        L_0x007e:
            if (r12 >= r13) goto L_0x0099
            java.lang.Object r14 = r9.get(r12)
            r15 = r14
            r16 = 0
            r17 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            r18 = 0
            boolean r17 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r17)
            if (r17 != 0) goto L_0x0095
            r9 = r5
            goto L_0x009b
        L_0x0095:
            int r12 = r12 + 1
            goto L_0x007e
        L_0x0099:
            r9 = r6
        L_0x009b:
            if (r9 == 0) goto L_0x00a6
            java.util.List r3 = r1.getChanges()
            java.lang.Object r3 = r3.get(r5)
            return r3
        L_0x00a6:
            java.util.List r1 = r1.getChanges()
            r9 = 0
            r10 = 0
            r11 = 0
            int r12 = r1.size()
        L_0x00b4:
            if (r11 >= r12) goto L_0x00ed
            java.lang.Object r13 = r1.get(r11)
            r14 = 0
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            r15 = 0
            boolean r16 = r13.isConsumed()
            if (r16 != 0) goto L_0x00da
            long r5 = r8.m4583getSizeYbymL2g()
            r21 = r1
            r20 = r2
            long r1 = r8.m4582getExtendedTouchPaddingNHjbRc()
            boolean r1 = androidx.compose.ui.input.pointer.PointerEventKt.m4615isOutOfBoundsjwHxaWs(r13, r5, r1)
            if (r1 == 0) goto L_0x00d8
            goto L_0x00de
        L_0x00d8:
            r1 = 0
            goto L_0x00df
        L_0x00da:
            r21 = r1
            r20 = r2
        L_0x00de:
            r1 = 1
        L_0x00df:
            if (r1 == 0) goto L_0x00e3
            r1 = 1
            goto L_0x00f3
        L_0x00e3:
            int r11 = r11 + 1
            r2 = r20
            r1 = r21
            r5 = 0
            r6 = 1
            goto L_0x00b4
        L_0x00ed:
            r21 = r1
            r20 = r2
            r1 = 0
        L_0x00f3:
            if (r1 == 0) goto L_0x00f6
            return r4
        L_0x00f6:
            androidx.compose.ui.input.pointer.PointerEventPass r1 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r0.L$0 = r8
            r0.L$1 = r7
            r2 = 2
            r0.label = r2
            java.lang.Object r1 = r8.awaitPointerEvent(r1, r0)
            if (r1 != r3) goto L_0x0106
            return r3
        L_0x0106:
            r2 = r20
            r5 = r7
            r7 = r8
        L_0x010a:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            java.util.List r1 = r1.getChanges()
            r6 = 0
            r8 = 0
            r9 = 0
            int r10 = r1.size()
        L_0x011a:
            if (r9 >= r10) goto L_0x0132
            java.lang.Object r11 = r1.get(r9)
            r12 = r11
            r13 = 0
            r14 = r12
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            r15 = 0
            boolean r14 = r14.isConsumed()
            if (r14 == 0) goto L_0x012e
            r1 = 1
            goto L_0x0134
        L_0x012e:
            int r9 = r9 + 1
            goto L_0x011a
        L_0x0132:
            r1 = 0
        L_0x0134:
            if (r1 == 0) goto L_0x0137
            return r4
        L_0x0137:
            r1 = r2
            r2 = r3
            r3 = r7
            r6 = 1
            r7 = r5
            r5 = 0
            goto L_0x0059
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object waitForUpOrCancellation$default(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return waitForUpOrCancellation(awaitPointerEventScope, pointerEventPass, continuation);
    }
}
