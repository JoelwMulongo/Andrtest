package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a,\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002\u001a2\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\u0011\u001a\u00020\u0001H\u0000\u001a\u0012\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016\u001a1\u0010\u0017\u001a\u00020\u0013*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u001d\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"AssumePointerMoveStoppedMilliseconds", "", "DefaultWeight", "", "HistorySize", "HorizonMilliseconds", "calculateImpulseVelocity", "dataPoints", "", "time", "isDataDifferential", "", "kineticEnergyToVelocity", "kineticEnergy", "polyFitLeastSquares", "x", "y", "degree", "addPointerInputChange", "", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "event", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "set", "", "Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "index", "", "dataPoint", "([Landroidx/compose/ui/input/pointer/util/DataPointAtTime;IJF)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: VelocityTracker.kt */
public final class VelocityTrackerKt {
    private static final int AssumePointerMoveStoppedMilliseconds = 40;
    private static final float DefaultWeight = 1.0f;
    private static final int HistorySize = 20;
    private static final int HorizonMilliseconds = 100;

    /* access modifiers changed from: private */
    public static final void set(DataPointAtTime[] $this$set, int index, long time, float dataPoint) {
        DataPointAtTime currentEntry = $this$set[index];
        if (currentEntry == null) {
            $this$set[index] = new DataPointAtTime(time, dataPoint);
            return;
        }
        currentEntry.setTime(time);
        currentEntry.setDataPoint(dataPoint);
    }

    public static final void addPointerInputChange(VelocityTracker $this$addPointerInputChange, PointerInputChange event) {
        VelocityTracker velocityTracker = $this$addPointerInputChange;
        Intrinsics.checkNotNullParameter(velocityTracker, "<this>");
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (PointerEventKt.changedToDownIgnoreConsumed(event)) {
            velocityTracker.m4790setCurrentPointerPositionAccumulatork4lQ0M$ui_release(event.m4667getPositionF1C5BW0());
            $this$addPointerInputChange.resetTracking();
        }
        long previousPointerPosition = event.m4668getPreviousPositionF1C5BW0();
        List $this$fastForEach$iv = event.getHistorical();
        int index$iv = 0;
        int size = $this$fastForEach$iv.size();
        while (index$iv < size) {
            HistoricalChange it = $this$fastForEach$iv.get(index$iv);
            long historicalDelta = Offset.m2919minusMKHz9U(it.m4597getPositionF1C5BW0(), previousPointerPosition);
            previousPointerPosition = it.m4597getPositionF1C5BW0();
            velocityTracker.m4790setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m2920plusMKHz9U($this$addPointerInputChange.m4789getCurrentPointerPositionAccumulatorF1C5BW0$ui_release(), historicalDelta));
            velocityTracker.m4787addPositionUv8p0NA(it.getUptimeMillis(), $this$addPointerInputChange.m4789getCurrentPointerPositionAccumulatorF1C5BW0$ui_release());
            index$iv++;
            PointerInputChange pointerInputChange = event;
            $this$fastForEach$iv = $this$fastForEach$iv;
        }
        velocityTracker.m4790setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m2920plusMKHz9U($this$addPointerInputChange.m4789getCurrentPointerPositionAccumulatorF1C5BW0$ui_release(), Offset.m2919minusMKHz9U(event.m4667getPositionF1C5BW0(), previousPointerPosition)));
        velocityTracker.m4787addPositionUv8p0NA(event.getUptimeMillis(), $this$addPointerInputChange.m4789getCurrentPointerPositionAccumulatorF1C5BW0$ui_release());
    }

    public static final List<Float> polyFitLeastSquares(List<Float> x, List<Float> y, int degree) {
        int i;
        float f;
        List<Float> list = x;
        List<Float> list2 = y;
        int i2 = degree;
        Intrinsics.checkNotNullParameter(list, "x");
        Intrinsics.checkNotNullParameter(list2, "y");
        if (i2 < 1) {
            throw new IllegalArgumentException("The degree must be at positive integer");
        } else if (x.size() != y.size()) {
            throw new IllegalArgumentException("x and y must be the same length");
        } else if (!x.isEmpty()) {
            if (i2 >= x.size()) {
                i = x.size() - 1;
            } else {
                i = i2;
            }
            int truncatedDegree = i;
            int i3 = i2 + 1;
            ArrayList arrayList = new ArrayList(i3);
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = i4;
                arrayList.add(Float.valueOf(0.0f));
            }
            List coefficients = arrayList;
            int m = x.size();
            int n = truncatedDegree + 1;
            Matrix a = new Matrix(n, m);
            int h = 0;
            while (true) {
                f = 1.0f;
                if (h >= m) {
                    break;
                }
                a.set(0, h, 1.0f);
                for (int i6 = 1; i6 < n; i6++) {
                    a.set(i6, h, a.get(i6 - 1, h) * list.get(h).floatValue());
                }
                h++;
            }
            Matrix q = new Matrix(n, m);
            Matrix r = new Matrix(n, n);
            int j = 0;
            while (j < n) {
                for (int h2 = 0; h2 < m; h2++) {
                    q.set(j, h2, a.get(j, h2));
                }
                for (int i7 = 0; i7 < j; i7++) {
                    float dot = q.getRow(j).times(q.getRow(i7));
                    for (int h3 = 0; h3 < m; h3++) {
                        q.set(j, h3, q.get(j, h3) - (q.get(i7, h3) * dot));
                    }
                }
                float norm = q.getRow(j).norm();
                if (((double) norm) >= 1.0E-6d) {
                    float inverseNorm = f / norm;
                    for (int h4 = 0; h4 < m; h4++) {
                        q.set(j, h4, q.get(j, h4) * inverseNorm);
                    }
                    int i8 = 0;
                    while (i8 < n) {
                        r.set(j, i8, i8 < j ? 0.0f : q.getRow(j).times(a.getRow(i8)));
                        i8++;
                    }
                    j++;
                    f = 1.0f;
                } else {
                    throw new IllegalArgumentException("Vectors are linearly dependent or zero so no solution. TODO(shepshapard), actually determine what this means");
                }
            }
            Vector wy = new Vector(m);
            for (int h5 = 0; h5 < m; h5++) {
                wy.set(h5, list2.get(h5).floatValue() * 1.0f);
            }
            for (int i9 = n - 1; -1 < i9; i9--) {
                coefficients.set(i9, Float.valueOf(q.getRow(i9).times(wy)));
                int j2 = n - 1;
                int i10 = i9 + 1;
                if (i10 <= j2) {
                    while (true) {
                        coefficients.set(i9, Float.valueOf(coefficients.get(i9).floatValue() - (r.get(i9, j2) * coefficients.get(j2).floatValue())));
                        if (j2 == i10) {
                            break;
                        }
                        j2--;
                    }
                }
                coefficients.set(i9, Float.valueOf(coefficients.get(i9).floatValue() / r.get(i9, i9)));
            }
            return coefficients;
        } else {
            throw new IllegalArgumentException("At least one point must be provided");
        }
    }

    /* access modifiers changed from: private */
    public static final float calculateImpulseVelocity(List<Float> dataPoints, List<Float> time, boolean isDataDifferential) {
        float dataPointsDelta;
        float dataPointsDelta2;
        int numDataPoints = dataPoints.size();
        if (numDataPoints < 2) {
            return 0.0f;
        }
        if (numDataPoints == 2) {
            if (time.get(0).floatValue() == time.get(1).floatValue()) {
                return 0.0f;
            }
            if (isDataDifferential) {
                dataPointsDelta2 = dataPoints.get(0).floatValue();
            } else {
                dataPointsDelta2 = dataPoints.get(0).floatValue() - dataPoints.get(1).floatValue();
            }
            return dataPointsDelta2 / (time.get(0).floatValue() - time.get(1).floatValue());
        }
        float work = 0.0f;
        for (int i = numDataPoints - 1; i > 0; i--) {
            if (!(time.get(i).floatValue() == time.get(i + -1).floatValue())) {
                float vPrev = kineticEnergyToVelocity(work);
                if (isDataDifferential) {
                    dataPointsDelta = -dataPoints.get(i - 1).floatValue();
                } else {
                    dataPointsDelta = dataPoints.get(i).floatValue() - dataPoints.get(i - 1).floatValue();
                }
                float vCurr = dataPointsDelta / (time.get(i).floatValue() - time.get(i - 1).floatValue());
                work += (vCurr - vPrev) * Math.abs(vCurr);
                if (i == numDataPoints - 1) {
                    work *= 0.5f;
                }
            }
        }
        return kineticEnergyToVelocity(work);
    }

    private static final float kineticEnergyToVelocity(float kineticEnergy) {
        return Math.signum(kineticEnergy) * ((float) Math.sqrt((double) (((float) 2) * Math.abs(kineticEnergy))));
    }
}
