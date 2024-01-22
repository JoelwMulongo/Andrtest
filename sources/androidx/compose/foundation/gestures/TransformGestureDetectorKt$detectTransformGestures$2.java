package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2", f = "TransformGestureDetector.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {59, 61}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$awaitEachGesture", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom"}, s = {"L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1"})
/* compiled from: TransformGestureDetector.kt */
final class TransformGestureDetectorKt$detectTransformGestures$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function4<Offset, Offset, Float, Float, Unit> $onGesture;
    final /* synthetic */ boolean $panZoomLock;
    float F$0;
    float F$1;
    float F$2;
    int I$0;
    int I$1;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransformGestureDetectorKt$detectTransformGestures$2(boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super TransformGestureDetectorKt$detectTransformGestures$2> continuation) {
        super(2, continuation);
        this.$panZoomLock = z;
        this.$onGesture = function4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformGestureDetectorKt$detectTransformGestures$2 transformGestureDetectorKt$detectTransformGestures$2 = new TransformGestureDetectorKt$detectTransformGestures$2(this.$panZoomLock, this.$onGesture, continuation);
        transformGestureDetectorKt$detectTransformGestures$2.L$0 = obj;
        return transformGestureDetectorKt$detectTransformGestures$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((TransformGestureDetectorKt$detectTransformGestures$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: androidx.compose.ui.input.pointer.AwaitPointerEventScope} */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0195, code lost:
        if (androidx.compose.ui.geometry.Offset.m2912equalsimpl0(r1, androidx.compose.ui.geometry.Offset.Companion.m2931getZeroF1C5BW0()) == false) goto L_0x019d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x015a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) {
        /*
            r26 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r26
            int r2 = r1.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x004d;
                case 1: goto L_0x0035;
                case 2: goto L_0x0014;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0014:
            r2 = r26
            r4 = r27
            int r5 = r2.I$1
            float r6 = r2.F$2
            int r7 = r2.I$0
            long r8 = r2.J$0
            float r10 = r2.F$1
            float r11 = r2.F$0
            java.lang.Object r12 = r2.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
            kotlin.ResultKt.throwOnFailure(r4)
            r13 = r12
            r12 = r11
            r11 = r10
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            goto L_0x00cc
        L_0x0035:
            r2 = r26
            r4 = r27
            int r5 = r2.I$1
            float r6 = r2.F$2
            int r7 = r2.I$0
            long r8 = r2.J$0
            float r10 = r2.F$1
            float r11 = r2.F$0
            java.lang.Object r12 = r2.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x00a3
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r27)
            r2 = r26
            r4 = r27
            java.lang.Object r5 = r2.L$0
            r12 = r5
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
            r5 = 0
            r13 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.ui.geometry.Offset$Companion r6 = androidx.compose.ui.geometry.Offset.Companion
            long r14 = r6.m2931getZeroF1C5BW0()
            r11 = 0
            androidx.compose.ui.platform.ViewConfiguration r6 = r12.getViewConfiguration()
            float r10 = r6.getTouchSlop()
            r9 = 0
            r7 = 0
            r8 = 0
            r16 = r2
            kotlin.coroutines.Continuation r16 = (kotlin.coroutines.Continuation) r16
            r17 = 2
            r18 = 0
            r2.L$0 = r12
            r2.F$0 = r5
            r2.F$1 = r13
            r2.J$0 = r14
            r2.I$0 = r11
            r2.F$2 = r10
            r2.I$1 = r9
            r2.label = r3
            r6 = r12
            r19 = r9
            r9 = r16
            r16 = r10
            r10 = r17
            r17 = r11
            r11 = r18
            java.lang.Object r6 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r6, r7, r8, r9, r10, r11)
            if (r6 != r0) goto L_0x009a
            return r0
        L_0x009a:
            r11 = r5
            r10 = r13
            r8 = r14
            r6 = r16
            r7 = r17
            r5 = r19
        L_0x00a3:
        L_0x00a4:
            r13 = r2
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r2.L$0 = r12
            r2.F$0 = r11
            r2.F$1 = r10
            r2.J$0 = r8
            r2.I$0 = r7
            r2.F$2 = r6
            r2.I$1 = r5
            r14 = 2
            r2.label = r14
            r14 = 0
            java.lang.Object r13 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r12, r14, r13, r3, r14)
            if (r13 != r0) goto L_0x00c0
            return r0
        L_0x00c0:
            r25 = r5
            r5 = r4
            r4 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r25
        L_0x00cc:
            androidx.compose.ui.input.pointer.PointerEvent r4 = (androidx.compose.ui.input.pointer.PointerEvent) r4
            java.util.List r14 = r4.getChanges()
            r15 = 0
            r16 = 0
            r17 = 0
            int r3 = r14.size()
            r27 = r0
            r0 = r17
        L_0x00e2:
            if (r0 >= r3) goto L_0x0100
            java.lang.Object r17 = r14.get(r0)
            r19 = r17
            r20 = 0
            r21 = r19
            androidx.compose.ui.input.pointer.PointerInputChange r21 = (androidx.compose.ui.input.pointer.PointerInputChange) r21
            r22 = 0
            boolean r21 = r21.isConsumed()
            if (r21 == 0) goto L_0x00fa
            r0 = 1
            goto L_0x0102
        L_0x00fa:
            int r0 = r0 + 1
            r1 = r26
            goto L_0x00e2
        L_0x0100:
            r0 = 0
        L_0x0102:
            if (r0 != 0) goto L_0x01e0
            float r3 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateZoom(r4)
            float r14 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateRotation(r4)
            r15 = r2
            long r1 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculatePan(r4)
            if (r8 != 0) goto L_0x015e
            float r11 = r11 * r3
            float r12 = r12 + r14
            long r9 = androidx.compose.ui.geometry.Offset.m2920plusMKHz9U(r9, r1)
            r17 = r5
            r5 = 0
            float r19 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateCentroidSize(r4, r5)
            r18 = r6
            r5 = 1
            float r6 = (float) r5
            float r6 = r6 - r11
            float r6 = java.lang.Math.abs(r6)
            float r6 = r6 * r19
            r20 = 1078530011(0x40490fdb, float:3.1415927)
            float r20 = r20 * r12
            float r20 = r20 * r19
            r19 = 1127481344(0x43340000, float:180.0)
            float r20 = r20 / r19
            float r19 = java.lang.Math.abs(r20)
            float r20 = androidx.compose.ui.geometry.Offset.m2913getDistanceimpl(r9)
            int r21 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r21 > 0) goto L_0x014e
            int r6 = (r19 > r7 ? 1 : (r19 == r7 ? 0 : -1))
            if (r6 > 0) goto L_0x014e
            int r6 = (r20 > r7 ? 1 : (r20 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x014c
            goto L_0x014e
        L_0x014c:
            r6 = r15
            goto L_0x0164
        L_0x014e:
            r8 = 1
            r6 = r15
            boolean r15 = r6.$panZoomLock
            if (r15 == 0) goto L_0x015a
            int r15 = (r19 > r7 ? 1 : (r19 == r7 ? 0 : -1))
            if (r15 >= 0) goto L_0x015a
            r15 = r5
            goto L_0x015b
        L_0x015a:
            r15 = 0
        L_0x015b:
            r18 = r15
            goto L_0x0164
        L_0x015e:
            r17 = r5
            r18 = r6
            r6 = r15
            r5 = 1
        L_0x0164:
            if (r8 == 0) goto L_0x01d9
            r15 = 0
            long r19 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateCentroid(r4, r15)
            r16 = 0
            if (r18 == 0) goto L_0x0171
            r14 = r16
        L_0x0171:
            int r16 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r16 != 0) goto L_0x0178
            r16 = r5
            goto L_0x017a
        L_0x0178:
            r16 = r15
        L_0x017a:
            if (r16 == 0) goto L_0x019b
            r16 = 1065353216(0x3f800000, float:1.0)
            int r16 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r16 != 0) goto L_0x0185
            r16 = r5
            goto L_0x0187
        L_0x0185:
            r16 = r15
        L_0x0187:
            if (r16 == 0) goto L_0x0198
            androidx.compose.ui.geometry.Offset$Companion r16 = androidx.compose.ui.geometry.Offset.Companion
            r22 = r6
            long r5 = r16.m2931getZeroF1C5BW0()
            boolean r5 = androidx.compose.ui.geometry.Offset.m2912equalsimpl0(r1, r5)
            if (r5 != 0) goto L_0x01b6
            goto L_0x019d
        L_0x0198:
            r22 = r6
            goto L_0x019d
        L_0x019b:
            r22 = r6
        L_0x019d:
            r5 = r22
            kotlin.jvm.functions.Function4<androidx.compose.ui.geometry.Offset, androidx.compose.ui.geometry.Offset, java.lang.Float, java.lang.Float, kotlin.Unit> r6 = r5.$onGesture
            androidx.compose.ui.geometry.Offset r15 = androidx.compose.ui.geometry.Offset.m2904boximpl(r19)
            androidx.compose.ui.geometry.Offset r5 = androidx.compose.ui.geometry.Offset.m2904boximpl(r1)
            r23 = r1
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r3)
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r14)
            r6.invoke(r15, r5, r1, r2)
        L_0x01b6:
            java.util.List r1 = r4.getChanges()
            r2 = 0
            r3 = 0
            int r5 = r1.size()
        L_0x01c1:
            if (r3 >= r5) goto L_0x01d8
            java.lang.Object r6 = r1.get(r3)
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            r14 = 0
            boolean r15 = androidx.compose.ui.input.pointer.PointerEventKt.positionChanged(r6)
            if (r15 == 0) goto L_0x01d3
            r6.consume()
        L_0x01d3:
            int r3 = r3 + 1
            goto L_0x01c1
        L_0x01d8:
            goto L_0x01dd
        L_0x01d9:
            r23 = r1
            r22 = r6
        L_0x01dd:
            r5 = r18
            goto L_0x01e8
        L_0x01e0:
            r22 = r2
            r17 = r5
            r18 = r6
            r5 = r18
        L_0x01e8:
            if (r0 != 0) goto L_0x0228
            java.util.List r0 = r4.getChanges()
            r1 = 0
            r2 = 0
            r3 = 0
            int r4 = r0.size()
        L_0x01f8:
            if (r3 >= r4) goto L_0x0212
            java.lang.Object r6 = r0.get(r3)
            r14 = r6
            r15 = 0
            r18 = r14
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            r19 = 0
            boolean r18 = r18.getPressed()
            if (r18 == 0) goto L_0x020e
            r1 = 1
            goto L_0x0214
        L_0x020e:
            int r3 = r3 + 1
            goto L_0x01f8
        L_0x0212:
            r1 = 0
        L_0x0214:
            if (r1 != 0) goto L_0x0217
            goto L_0x0228
        L_0x0217:
            r1 = r26
            r0 = r27
            r6 = r7
            r7 = r8
            r8 = r9
            r10 = r11
            r11 = r12
            r12 = r13
            r4 = r17
            r2 = r22
            r3 = 1
            goto L_0x00a4
        L_0x0228:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
