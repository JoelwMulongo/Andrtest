package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bø\u0001\u0001¢\u0006\u0002\u0010\t\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u000b\u001a\u00020\u0002*\u00020\u0006ø\u0001\u0001¢\u0006\u0002\u0010\f\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0006\u001a\u0001\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\b2`\u0010\u0013\u001a\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00100\u0014H@ø\u0001\u0001ø\u0001\u0001¢\u0006\u0002\u0010\u001b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"angle", "", "Landroidx/compose/ui/geometry/Offset;", "angle-k-4lQ0M", "(J)F", "calculateCentroid", "Landroidx/compose/ui/input/pointer/PointerEvent;", "useCurrent", "", "(Landroidx/compose/ui/input/pointer/PointerEvent;Z)J", "calculateCentroidSize", "calculatePan", "(Landroidx/compose/ui/input/pointer/PointerEvent;)J", "calculateRotation", "calculateZoom", "detectTransformGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "panZoomLock", "onGesture", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "centroid", "pan", "zoom", "rotation", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TransformGestureDetector.kt */
public final class TransformGestureDetectorKt {
    public static /* synthetic */ Object detectTransformGestures$default(PointerInputScope pointerInputScope, boolean z, Function4 function4, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return detectTransformGestures(pointerInputScope, z, function4, continuation);
    }

    public static final Object detectTransformGestures(PointerInputScope $this$detectTransformGestures, boolean panZoomLock, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> onGesture, Continuation<? super Unit> $completion) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectTransformGestures, new TransformGestureDetectorKt$detectTransformGestures$2(panZoomLock, onGesture, (Continuation<? super TransformGestureDetectorKt$detectTransformGestures$2>) null), $completion);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    public static final float calculateRotation(PointerEvent $this$calculateRotation) {
        long currentCentroid;
        int pointerCount;
        long currentCentroid2;
        float f;
        PointerEvent pointerEvent = $this$calculateRotation;
        Intrinsics.checkNotNullParameter(pointerEvent, "<this>");
        int sum$iv = 0;
        List $this$fastForEach$iv$iv = $this$calculateRotation.getChanges();
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (true) {
            int i = 0;
            if (index$iv$iv >= size) {
                break;
            }
            PointerInputChange it = (PointerInputChange) $this$fastForEach$iv$iv.get(index$iv$iv);
            if (it.getPreviousPressed() && it.getPressed()) {
                i = 1;
            }
            sum$iv += i;
            index$iv$iv++;
        }
        int pointerCount2 = sum$iv;
        if (pointerCount2 < 2) {
            return 0.0f;
        }
        long currentCentroid3 = calculateCentroid(pointerEvent, true);
        long previousCentroid = calculateCentroid(pointerEvent, false);
        float rotation = 0.0f;
        float rotationWeight = 0.0f;
        List $this$fastForEach$iv = $this$calculateRotation.getChanges();
        int index$iv = 0;
        int size2 = $this$fastForEach$iv.size();
        while (index$iv < size2) {
            PointerInputChange change = $this$fastForEach$iv.get(index$iv);
            if (!change.getPressed() || !change.getPreviousPressed()) {
                currentCentroid2 = currentCentroid3;
                currentCentroid = previousCentroid;
                pointerCount = pointerCount2;
            } else {
                long currentPosition = change.m4667getPositionF1C5BW0();
                long previousPosition = change.m4668getPreviousPositionF1C5BW0();
                long previousOffset = Offset.m2919minusMKHz9U(previousPosition, previousCentroid);
                long j = previousPosition;
                currentCentroid2 = currentCentroid3;
                currentCentroid = previousCentroid;
                pointerCount = pointerCount2;
                long currentOffset = Offset.m2919minusMKHz9U(currentPosition, currentCentroid2);
                float angleDiff = m642anglek4lQ0M(currentOffset) - m642anglek4lQ0M(previousOffset);
                float weight = Offset.m2913getDistanceimpl(Offset.m2920plusMKHz9U(currentOffset, previousOffset)) / 2.0f;
                if (angleDiff > 180.0f) {
                    f = angleDiff - 360.0f;
                } else if (angleDiff < -180.0f) {
                    f = angleDiff + 360.0f;
                } else {
                    f = angleDiff;
                }
                rotation += f * weight;
                rotationWeight += weight;
            }
            index$iv++;
            PointerEvent pointerEvent2 = $this$calculateRotation;
            currentCentroid3 = currentCentroid2;
            pointerCount2 = pointerCount;
            previousCentroid = currentCentroid;
        }
        long j2 = previousCentroid;
        int i2 = pointerCount2;
        if (rotationWeight == 0.0f) {
            return 0.0f;
        }
        return rotation / rotationWeight;
    }

    /* renamed from: angle-k-4lQ0M  reason: not valid java name */
    private static final float m642anglek4lQ0M(long $this$angle_u2dk_u2d4lQ0M) {
        boolean z = true;
        if (Offset.m2915getXimpl($this$angle_u2dk_u2d4lQ0M) == 0.0f) {
            if (Offset.m2916getYimpl($this$angle_u2dk_u2d4lQ0M) != 0.0f) {
                z = false;
            }
            if (z) {
                return 0.0f;
            }
        }
        return ((-((float) Math.atan2((double) Offset.m2915getXimpl($this$angle_u2dk_u2d4lQ0M), (double) Offset.m2916getYimpl($this$angle_u2dk_u2d4lQ0M)))) * 180.0f) / 3.1415927f;
    }

    public static final float calculateZoom(PointerEvent $this$calculateZoom) {
        Intrinsics.checkNotNullParameter($this$calculateZoom, "<this>");
        boolean z = true;
        float currentCentroidSize = calculateCentroidSize($this$calculateZoom, true);
        float previousCentroidSize = calculateCentroidSize($this$calculateZoom, false);
        if (currentCentroidSize == 0.0f) {
            return 1.0f;
        }
        if (previousCentroidSize != 0.0f) {
            z = false;
        }
        if (z) {
            return 1.0f;
        }
        return currentCentroidSize / previousCentroidSize;
    }

    public static final long calculatePan(PointerEvent $this$calculatePan) {
        Intrinsics.checkNotNullParameter($this$calculatePan, "<this>");
        long currentCentroid = calculateCentroid($this$calculatePan, true);
        if (Offset.m2912equalsimpl0(currentCentroid, Offset.Companion.m2930getUnspecifiedF1C5BW0())) {
            return Offset.Companion.m2931getZeroF1C5BW0();
        }
        return Offset.m2919minusMKHz9U(currentCentroid, calculateCentroid($this$calculatePan, false));
    }

    public static /* synthetic */ float calculateCentroidSize$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroidSize(pointerEvent, z);
    }

    public static final float calculateCentroidSize(PointerEvent $this$calculateCentroidSize, boolean useCurrent) {
        Intrinsics.checkNotNullParameter($this$calculateCentroidSize, "<this>");
        long centroid = calculateCentroid($this$calculateCentroidSize, useCurrent);
        if (Offset.m2912equalsimpl0(centroid, Offset.Companion.m2930getUnspecifiedF1C5BW0())) {
            return 0.0f;
        }
        float distanceToCentroid = 0.0f;
        int distanceWeight = 0;
        List $this$fastForEach$iv = $this$calculateCentroidSize.getChanges();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            PointerInputChange change = $this$fastForEach$iv.get(index$iv);
            if (change.getPressed() && change.getPreviousPressed()) {
                distanceToCentroid += Offset.m2913getDistanceimpl(Offset.m2919minusMKHz9U(useCurrent ? change.m4667getPositionF1C5BW0() : change.m4668getPreviousPositionF1C5BW0(), centroid));
                distanceWeight++;
            }
        }
        return distanceToCentroid / ((float) distanceWeight);
    }

    public static /* synthetic */ long calculateCentroid$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroid(pointerEvent, z);
    }

    public static final long calculateCentroid(PointerEvent $this$calculateCentroid, boolean useCurrent) {
        Intrinsics.checkNotNullParameter($this$calculateCentroid, "<this>");
        long centroid = Offset.Companion.m2931getZeroF1C5BW0();
        int centroidWeight = 0;
        List $this$fastForEach$iv = $this$calculateCentroid.getChanges();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            PointerInputChange change = $this$fastForEach$iv.get(index$iv);
            if (change.getPressed() && change.getPreviousPressed()) {
                centroid = Offset.m2920plusMKHz9U(centroid, useCurrent ? change.m4667getPositionF1C5BW0() : change.m4668getPreviousPositionF1C5BW0());
                centroidWeight++;
            }
        }
        if (centroidWeight == 0) {
            return Offset.Companion.m2930getUnspecifiedF1C5BW0();
        }
        return Offset.m2910divtuRUvjQ(centroid, (float) centroidWeight);
    }
}
