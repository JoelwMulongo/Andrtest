package androidx.compose.foundation.gestures;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a&\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"detectZoom", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "panZoomLock", "Landroidx/compose/runtime/State;", "", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/runtime/State;Lkotlinx/coroutines/channels/Channel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "lockRotationOnZoomPan", "enabled", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transformable.kt */
public final class TransformableKt {
    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, z, z2);
    }

    public static final Modifier transformable(Modifier $this$transformable, TransformableState state, boolean lockRotationOnZoomPan, boolean enabled) {
        Intrinsics.checkNotNullParameter($this$transformable, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        return ComposedModifierKt.composed($this$transformable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TransformableKt$transformable$$inlined$debugInspectorInfo$1(state, enabled, lockRotationOnZoomPan) : InspectableValueKt.getNoInspectorInfo(), new TransformableKt$transformable$2(lockRotationOnZoomPan, enabled, state));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01c6, code lost:
        if (androidx.compose.ui.geometry.Offset.m2912equalsimpl0(r1, androidx.compose.ui.geometry.Offset.Companion.m2931getZeroF1C5BW0()) == false) goto L_0x01d2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00e0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope r27, androidx.compose.runtime.State<java.lang.Boolean> r28, kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r29, kotlin.coroutines.Continuation<? super kotlin.Unit> r30) {
        /*
            r0 = r30
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.TransformableKt$detectZoom$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.TransformableKt$detectZoom$1 r1 = (androidx.compose.foundation.gestures.TransformableKt$detectZoom$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.TransformableKt$detectZoom$1 r1 = new androidx.compose.foundation.gestures.TransformableKt$detectZoom$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r7 = r0.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r9 = 1
            switch(r1) {
                case 0: goto L_0x006f;
                case 1: goto L_0x0053;
                case 2: goto L_0x0030;
                default: goto L_0x0028;
            }
        L_0x0028:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0030:
            int r1 = r0.I$1
            float r2 = r0.F$2
            int r3 = r0.I$0
            long r4 = r0.J$0
            float r6 = r0.F$1
            float r10 = r0.F$0
            java.lang.Object r11 = r0.L$2
            kotlinx.coroutines.channels.Channel r11 = (kotlinx.coroutines.channels.Channel) r11
            java.lang.Object r12 = r0.L$1
            androidx.compose.runtime.State r12 = (androidx.compose.runtime.State) r12
            java.lang.Object r13 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            kotlin.ResultKt.throwOnFailure(r7)
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r8
            r8 = r7
            goto L_0x00eb
        L_0x0053:
            int r1 = r0.I$1
            float r2 = r0.F$2
            int r3 = r0.I$0
            long r4 = r0.J$0
            float r6 = r0.F$1
            float r10 = r0.F$0
            java.lang.Object r11 = r0.L$2
            kotlinx.coroutines.channels.Channel r11 = (kotlinx.coroutines.channels.Channel) r11
            java.lang.Object r12 = r0.L$1
            androidx.compose.runtime.State r12 = (androidx.compose.runtime.State) r12
            java.lang.Object r13 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x00c3
        L_0x006f:
            kotlin.ResultKt.throwOnFailure(r7)
            r13 = r27
            r11 = r29
            r12 = r28
            r10 = 0
            r14 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.Companion
            long r5 = r1.m2931getZeroF1C5BW0()
            r15 = 0
            androidx.compose.ui.platform.ViewConfiguration r1 = r13.getViewConfiguration()
            float r4 = r1.getTouchSlop()
            r3 = 0
            r2 = 0
            r16 = 0
            r17 = 2
            r18 = 0
            r0.L$0 = r13
            r0.L$1 = r12
            r0.L$2 = r11
            r0.F$0 = r10
            r0.F$1 = r14
            r0.J$0 = r5
            r0.I$0 = r15
            r0.F$2 = r4
            r0.I$1 = r3
            r0.label = r9
            r1 = r13
            r19 = r3
            r3 = r16
            r16 = r4
            r4 = r0
            r20 = r5
            r5 = r17
            r6 = r18
            java.lang.Object r1 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r1, r2, r3, r4, r5, r6)
            if (r1 != r8) goto L_0x00bb
            return r8
        L_0x00bb:
            r6 = r14
            r3 = r15
            r2 = r16
            r1 = r19
            r4 = r20
        L_0x00c3:
        L_0x00c4:
            r0.L$0 = r13
            r0.L$1 = r12
            r0.L$2 = r11
            r0.F$0 = r10
            r0.F$1 = r6
            r0.J$0 = r4
            r0.I$0 = r3
            r0.F$2 = r2
            r0.I$1 = r1
            r14 = 2
            r0.label = r14
            r14 = 0
            java.lang.Object r14 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r13, r14, r0, r9, r14)
            if (r14 != r8) goto L_0x00e1
            return r8
        L_0x00e1:
            r26 = r8
            r8 = r7
            r7 = r14
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r26
        L_0x00eb:
            androidx.compose.ui.input.pointer.PointerEvent r7 = (androidx.compose.ui.input.pointer.PointerEvent) r7
            java.util.List r15 = r7.getChanges()
            r16 = 0
            r17 = 0
            r18 = 0
            int r9 = r15.size()
            r27 = r0
            r0 = r18
        L_0x0102:
            r28 = r1
            if (r0 >= r9) goto L_0x0122
            java.lang.Object r18 = r15.get(r0)
            r19 = r18
            r20 = 0
            r21 = r19
            androidx.compose.ui.input.pointer.PointerInputChange r21 = (androidx.compose.ui.input.pointer.PointerInputChange) r21
            r22 = 0
            boolean r21 = r21.isConsumed()
            if (r21 == 0) goto L_0x011c
            r0 = 1
            goto L_0x0124
        L_0x011c:
            int r0 = r0 + 1
            r1 = r28
            goto L_0x0102
        L_0x0122:
            r0 = 0
        L_0x0124:
            if (r0 != 0) goto L_0x0210
            float r9 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateZoom(r7)
            float r15 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateRotation(r7)
            r29 = r2
            long r1 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculatePan(r7)
            if (r3 != 0) goto L_0x0192
            float r6 = r6 * r9
            float r11 = r11 + r15
            long r4 = androidx.compose.ui.geometry.Offset.m2920plusMKHz9U(r4, r1)
            r16 = r3
            r3 = 0
            float r17 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateCentroidSize(r7, r3)
            r30 = r8
            r3 = 1
            float r8 = (float) r3
            float r8 = r8 - r6
            float r8 = java.lang.Math.abs(r8)
            float r8 = r8 * r17
            r18 = 1078530011(0x40490fdb, float:3.1415927)
            float r18 = r18 * r11
            float r18 = r18 * r17
            r17 = 1127481344(0x43340000, float:180.0)
            float r18 = r18 / r17
            float r17 = java.lang.Math.abs(r18)
            float r18 = androidx.compose.ui.geometry.Offset.m2913getDistanceimpl(r4)
            int r19 = (r8 > r29 ? 1 : (r8 == r29 ? 0 : -1))
            if (r19 > 0) goto L_0x0174
            int r8 = (r17 > r29 ? 1 : (r17 == r29 ? 0 : -1))
            if (r8 > 0) goto L_0x0174
            int r8 = (r18 > r29 ? 1 : (r18 == r29 ? 0 : -1))
            if (r8 <= 0) goto L_0x016f
            goto L_0x0174
        L_0x016f:
            r3 = r28
            r8 = r16
            goto L_0x019a
        L_0x0174:
            r8 = 1
            java.lang.Object r16 = r13.getValue()
            java.lang.Boolean r16 = (java.lang.Boolean) r16
            boolean r16 = r16.booleanValue()
            if (r16 == 0) goto L_0x0188
            int r16 = (r17 > r29 ? 1 : (r17 == r29 ? 0 : -1))
            if (r16 >= 0) goto L_0x0188
            r16 = r3
            goto L_0x018a
        L_0x0188:
            r16 = 0
        L_0x018a:
            androidx.compose.foundation.gestures.TransformEvent$TransformStarted r3 = androidx.compose.foundation.gestures.TransformEvent.TransformStarted.INSTANCE
            r12.m252trySendJP2dKIU(r3)
            r3 = r16
            goto L_0x019a
        L_0x0192:
            r16 = r3
            r30 = r8
            r3 = r28
            r8 = r16
        L_0x019a:
            if (r8 == 0) goto L_0x0206
            r16 = 0
            if (r3 == 0) goto L_0x01a2
            r15 = r16
        L_0x01a2:
            r23 = r15
            int r15 = (r23 > r16 ? 1 : (r23 == r16 ? 0 : -1))
            if (r15 != 0) goto L_0x01aa
            r15 = 1
            goto L_0x01ab
        L_0x01aa:
            r15 = 0
        L_0x01ab:
            if (r15 == 0) goto L_0x01ce
            r15 = 1065353216(0x3f800000, float:1.0)
            int r15 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r15 != 0) goto L_0x01b5
            r15 = 1
            goto L_0x01b6
        L_0x01b5:
            r15 = 0
        L_0x01b6:
            if (r15 == 0) goto L_0x01c9
            androidx.compose.ui.geometry.Offset$Companion r15 = androidx.compose.ui.geometry.Offset.Companion
            r28 = r3
            r24 = r4
            long r3 = r15.m2931getZeroF1C5BW0()
            boolean r3 = androidx.compose.ui.geometry.Offset.m2912equalsimpl0(r1, r3)
            if (r3 != 0) goto L_0x01e3
            goto L_0x01d2
        L_0x01c9:
            r28 = r3
            r24 = r4
            goto L_0x01d2
        L_0x01ce:
            r28 = r3
            r24 = r4
        L_0x01d2:
            androidx.compose.foundation.gestures.TransformEvent$TransformDelta r3 = new androidx.compose.foundation.gestures.TransformEvent$TransformDelta
            r20 = 0
            r15 = r3
            r16 = r9
            r17 = r1
            r19 = r23
            r15.<init>(r16, r17, r19, r20)
            r12.m252trySendJP2dKIU(r3)
        L_0x01e3:
            java.util.List r1 = r7.getChanges()
            r2 = 0
            r3 = 0
            int r4 = r1.size()
        L_0x01ee:
            if (r3 >= r4) goto L_0x0205
            java.lang.Object r5 = r1.get(r3)
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            r9 = 0
            boolean r15 = androidx.compose.ui.input.pointer.PointerEventKt.positionChanged(r5)
            if (r15 == 0) goto L_0x0200
            r5.consume()
        L_0x0200:
            int r3 = r3 + 1
            goto L_0x01ee
        L_0x0205:
            goto L_0x020a
        L_0x0206:
            r28 = r3
            r24 = r4
        L_0x020a:
            r1 = r28
            r3 = r8
            r4 = r24
            goto L_0x0218
        L_0x0210:
            r29 = r2
            r16 = r3
            r30 = r8
            r1 = r28
        L_0x0218:
            if (r0 != 0) goto L_0x0259
            java.util.List r0 = r7.getChanges()
            r2 = 0
            r7 = 0
            r8 = 0
            int r9 = r0.size()
        L_0x0228:
            if (r8 >= r9) goto L_0x0245
            java.lang.Object r15 = r0.get(r8)
            r16 = r15
            r17 = 0
            r18 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            r19 = 0
            boolean r18 = r18.getPressed()
            if (r18 == 0) goto L_0x0241
            r21 = 1
            goto L_0x0248
        L_0x0241:
            int r8 = r8 + 1
            goto L_0x0228
        L_0x0245:
            r21 = 0
        L_0x0248:
            if (r21 != 0) goto L_0x024b
            goto L_0x0259
        L_0x024b:
            r0 = r27
            r2 = r29
            r7 = r30
            r8 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r9 = 1
            goto L_0x00c4
        L_0x0259:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.runtime.State, kotlinx.coroutines.channels.Channel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
