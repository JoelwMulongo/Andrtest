package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001f\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ(\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0010J \u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0010H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0014\u0010(\u001a\u00020\u001f*\u00020\u00152\u0006\u0010!\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u00068\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006)"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "", "()V", "canHover", "Landroid/util/SparseBooleanArray;", "motionEventToComposePointerIdMap", "Landroid/util/SparseLongArray;", "getMotionEventToComposePointerIdMap$ui_release$annotations", "getMotionEventToComposePointerIdMap$ui_release", "()Landroid/util/SparseLongArray;", "nextId", "", "pointers", "", "Landroidx/compose/ui/input/pointer/PointerInputEventData;", "previousSource", "", "previousToolType", "addFreshIds", "", "motionEvent", "Landroid/view/MotionEvent;", "clearOnDeviceChange", "convertToPointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "convertToPointerInputEvent$ui_release", "createPointerInputEventData", "index", "pressed", "", "endStream", "pointerId", "getComposePointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "motionEventPointerId", "getComposePointerId-_I2yYro", "(I)J", "removeStaleIds", "hasPointerId", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MotionEventAdapter.android.kt */
public final class MotionEventAdapter {
    private final SparseBooleanArray canHover = new SparseBooleanArray();
    private final SparseLongArray motionEventToComposePointerIdMap = new SparseLongArray();
    private long nextId;
    private final List<PointerInputEventData> pointers = new ArrayList();
    private int previousSource = -1;
    private int previousToolType = -1;

    public static /* synthetic */ void getMotionEventToComposePointerIdMap$ui_release$annotations() {
    }

    public final SparseLongArray getMotionEventToComposePointerIdMap$ui_release() {
        return this.motionEventToComposePointerIdMap;
    }

    public final PointerInputEvent convertToPointerInputEvent$ui_release(MotionEvent motionEvent, PositionCalculator positionCalculator) {
        int upIndex;
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        Intrinsics.checkNotNullParameter(positionCalculator, "positionCalculator");
        int action = motionEvent.getActionMasked();
        if (action == 3) {
            this.motionEventToComposePointerIdMap.clear();
            this.canHover.clear();
            return null;
        }
        clearOnDeviceChange(motionEvent);
        addFreshIds(motionEvent);
        boolean isHover = action == 10 || action == 7 || action == 9;
        boolean isScroll = action == 8;
        if (isHover) {
            this.canHover.put(motionEvent.getPointerId(motionEvent.getActionIndex()), true);
        }
        switch (action) {
            case 1:
                upIndex = 0;
                break;
            case 6:
                upIndex = motionEvent.getActionIndex();
                break;
            default:
                upIndex = -1;
                break;
        }
        this.pointers.clear();
        int i = 0;
        int pointerCount = motionEvent.getPointerCount();
        while (i < pointerCount) {
            this.pointers.add(createPointerInputEventData(positionCalculator, motionEvent, i, !isHover && i != upIndex && (!isScroll || motionEvent.getButtonState() != 0)));
            i++;
        }
        removeStaleIds(motionEvent);
        return new PointerInputEvent(motionEvent.getEventTime(), this.pointers, motionEvent);
    }

    public final void endStream(int pointerId) {
        this.canHover.delete(pointerId);
        this.motionEventToComposePointerIdMap.delete(pointerId);
    }

    private final void addFreshIds(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                int pointerId = motionEvent.getPointerId(actionIndex);
                if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId) < 0) {
                    SparseLongArray sparseLongArray = this.motionEventToComposePointerIdMap;
                    long j = this.nextId;
                    this.nextId = 1 + j;
                    sparseLongArray.put(pointerId, j);
                    if (motionEvent.getToolType(actionIndex) == 3) {
                        this.canHover.put(pointerId, true);
                        return;
                    }
                    return;
                }
                return;
            case 9:
                int pointerId2 = motionEvent.getPointerId(0);
                if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId2) < 0) {
                    SparseLongArray sparseLongArray2 = this.motionEventToComposePointerIdMap;
                    long j2 = this.nextId;
                    this.nextId = 1 + j2;
                    sparseLongArray2.put(pointerId2, j2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void removeStaleIds(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 1:
            case 6:
                int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                if (!this.canHover.get(pointerId, false)) {
                    this.motionEventToComposePointerIdMap.delete(pointerId);
                    this.canHover.delete(pointerId);
                    break;
                }
                break;
        }
        if (this.motionEventToComposePointerIdMap.size() > motionEvent.getPointerCount()) {
            int i = this.motionEventToComposePointerIdMap.size();
            while (true) {
                i--;
                if (-1 < i) {
                    int pointerId2 = this.motionEventToComposePointerIdMap.keyAt(i);
                    if (!hasPointerId(motionEvent, pointerId2)) {
                        this.motionEventToComposePointerIdMap.removeAt(i);
                        this.canHover.delete(pointerId2);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private final boolean hasPointerId(MotionEvent $this$hasPointerId, int pointerId) {
        int pointerCount = $this$hasPointerId.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            if ($this$hasPointerId.getPointerId(i) == pointerId) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: getComposePointerId-_I2yYro  reason: not valid java name */
    private final long m4600getComposePointerId_I2yYro(int motionEventPointerId) {
        long newId;
        int pointerIndex = this.motionEventToComposePointerIdMap.indexOfKey(motionEventPointerId);
        if (pointerIndex >= 0) {
            newId = this.motionEventToComposePointerIdMap.valueAt(pointerIndex);
        } else {
            newId = this.nextId;
            this.nextId = 1 + newId;
            this.motionEventToComposePointerIdMap.put(motionEventPointerId, newId);
        }
        return PointerId.m4650constructorimpl(newId);
    }

    private final void clearOnDeviceChange(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 1) {
            int toolType = motionEvent.getToolType(0);
            int source = motionEvent.getSource();
            if (toolType != this.previousToolType || source != this.previousSource) {
                this.previousToolType = toolType;
                this.previousSource = source;
                this.canHover.clear();
                this.motionEventToComposePointerIdMap.clear();
            }
        }
    }

    private final PointerInputEventData createPointerInputEventData(PositionCalculator positionCalculator, MotionEvent motionEvent, int index, boolean pressed) {
        long rawPosition;
        long position;
        int toolType;
        long scrollDelta;
        PositionCalculator positionCalculator2 = positionCalculator;
        MotionEvent motionEvent2 = motionEvent;
        int i = index;
        long pointerId = m4600getComposePointerId_I2yYro(motionEvent.getPointerId(index));
        float pressure = motionEvent.getPressure(index);
        long position2 = OffsetKt.Offset(motionEvent.getX(index), motionEvent.getY(index));
        if (i == 0) {
            long rawPosition2 = OffsetKt.Offset(motionEvent.getRawX(), motionEvent.getRawY());
            position = positionCalculator2.m4749screenToLocalMKHz9U(rawPosition2);
            rawPosition = rawPosition2;
        } else if (Build.VERSION.SDK_INT >= 29) {
            long rawPosition3 = MotionEventHelper.INSTANCE.m4601toRawOffsetdBAh8RU(motionEvent2, i);
            position = positionCalculator2.m4749screenToLocalMKHz9U(rawPosition3);
            rawPosition = rawPosition3;
        } else {
            position = position2;
            rawPosition = positionCalculator2.m4748localToScreenMKHz9U(position2);
        }
        switch (motionEvent.getToolType(index)) {
            case 0:
                toolType = PointerType.Companion.m4747getUnknownT8wyACA();
                break;
            case 1:
                toolType = PointerType.Companion.m4746getTouchT8wyACA();
                break;
            case 2:
                toolType = PointerType.Companion.m4745getStylusT8wyACA();
                break;
            case 3:
                toolType = PointerType.Companion.m4744getMouseT8wyACA();
                break;
            case 4:
                toolType = PointerType.Companion.m4743getEraserT8wyACA();
                break;
            default:
                toolType = PointerType.Companion.m4747getUnknownT8wyACA();
                break;
        }
        List historical = new ArrayList();
        MotionEvent $this$createPointerInputEventData_u24lambda_u241 = motionEvent;
        int historySize = $this$createPointerInputEventData_u24lambda_u241.getHistorySize();
        for (int i2 = 0; i2 < historySize; i2++) {
            int pos = i2;
            float x = $this$createPointerInputEventData_u24lambda_u241.getHistoricalX(i, pos);
            float y = $this$createPointerInputEventData_u24lambda_u241.getHistoricalY(i, pos);
            boolean z = true;
            if (!Float.isInfinite(x) && !Float.isNaN(x)) {
                if (Float.isInfinite(y) || Float.isNaN(y)) {
                    z = false;
                }
                if (z) {
                    historical.add(new HistoricalChange($this$createPointerInputEventData_u24lambda_u241.getHistoricalEventTime(pos), OffsetKt.Offset(x, y), (DefaultConstructorMarker) null));
                }
            }
        }
        if (motionEvent.getActionMasked() == 8) {
            scrollDelta = OffsetKt.Offset(motionEvent2.getAxisValue(10), (-motionEvent2.getAxisValue(9)) + 0.0f);
        } else {
            scrollDelta = Offset.Companion.m2931getZeroF1C5BW0();
        }
        return new PointerInputEventData(pointerId, motionEvent.getEventTime(), rawPosition, position, pressed, pressure, toolType, this.canHover.get(motionEvent.getPointerId(index), false), historical, scrollDelta, (DefaultConstructorMarker) null);
    }
}
