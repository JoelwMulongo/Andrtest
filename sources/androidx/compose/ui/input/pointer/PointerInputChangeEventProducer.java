package androidx.compose.ui.input.pointer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer;", "", "()V", "previousPointerInputData", "", "Landroidx/compose/ui/input/pointer/PointerId;", "Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer$PointerInputData;", "clear", "", "produce", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "pointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "PointerInputData", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerInputEventProcessor.kt */
final class PointerInputChangeEventProducer {
    private final Map<PointerId, PointerInputData> previousPointerInputData = new LinkedHashMap();

    public final InternalPointerEvent produce(PointerInputEvent pointerInputEvent, PositionCalculator positionCalculator) {
        int i;
        long previousPosition;
        long previousTime;
        boolean previousDown;
        PointerInputEvent pointerInputEvent2 = pointerInputEvent;
        PositionCalculator positionCalculator2 = positionCalculator;
        Intrinsics.checkNotNullParameter(pointerInputEvent2, "pointerInputEvent");
        Intrinsics.checkNotNullParameter(positionCalculator2, "positionCalculator");
        Map changes = new LinkedHashMap(pointerInputEvent.getPointers().size());
        List $this$fastForEach$iv = pointerInputEvent.getPointers();
        int $i$f$fastForEach = 0;
        int index$iv = 0;
        int size = $this$fastForEach$iv.size();
        while (index$iv < size) {
            PointerInputEventData pointerInputEventData = $this$fastForEach$iv.get(index$iv);
            PointerInputEventData it = pointerInputEventData;
            List $this$fastForEach$iv2 = $this$fastForEach$iv;
            int $i$f$fastForEach2 = $i$f$fastForEach;
            PointerInputData previousData = this.previousPointerInputData.get(PointerId.m4649boximpl(it.m4680getIdJ3iCeTQ()));
            if (previousData == null) {
                previousTime = it.getUptime();
                previousPosition = it.m4681getPositionF1C5BW0();
                previousDown = false;
                i = size;
                PointerInputEventData pointerInputEventData2 = pointerInputEventData;
            } else {
                previousTime = previousData.getUptime();
                previousDown = previousData.getDown();
                i = size;
                PointerInputEventData pointerInputEventData3 = pointerInputEventData;
                previousPosition = positionCalculator2.m4749screenToLocalMKHz9U(previousData.m4671getPositionOnScreenF1C5BW0());
            }
            changes.put(PointerId.m4649boximpl(it.m4680getIdJ3iCeTQ()), new PointerInputChange(it.m4680getIdJ3iCeTQ(), it.getUptime(), it.m4681getPositionF1C5BW0(), it.getDown(), it.getPressure(), previousTime, previousPosition, previousDown, false, it.m4684getTypeT8wyACA(), (List) it.getHistorical(), it.m4683getScrollDeltaF1C5BW0(), (DefaultConstructorMarker) null));
            if (it.getDown()) {
                this.previousPointerInputData.put(PointerId.m4649boximpl(it.m4680getIdJ3iCeTQ()), new PointerInputData(it.getUptime(), it.m4682getPositionOnScreenF1C5BW0(), it.getDown(), it.m4684getTypeT8wyACA(), (DefaultConstructorMarker) null));
            } else {
                this.previousPointerInputData.remove(PointerId.m4649boximpl(it.m4680getIdJ3iCeTQ()));
            }
            index$iv++;
            positionCalculator2 = positionCalculator;
            size = i;
            $this$fastForEach$iv = $this$fastForEach$iv2;
            $i$f$fastForEach = $i$f$fastForEach2;
        }
        return new InternalPointerEvent(changes, pointerInputEvent2);
    }

    public final void clear() {
        this.previousPointerInputData.clear();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B(\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer$PointerInputData;", "", "uptime", "", "positionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "down", "", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "(JJZILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDown", "()Z", "getPositionOnScreen-F1C5BW0", "()J", "J", "getType-T8wyACA", "()I", "I", "getUptime", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PointerInputEventProcessor.kt */
    private static final class PointerInputData {
        private final boolean down;
        private final long positionOnScreen;
        private final int type;
        private final long uptime;

        public /* synthetic */ PointerInputData(long j, long j2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, z, i);
        }

        private PointerInputData(long uptime2, long positionOnScreen2, boolean down2, int type2) {
            this.uptime = uptime2;
            this.positionOnScreen = positionOnScreen2;
            this.down = down2;
            this.type = type2;
        }

        public final long getUptime() {
            return this.uptime;
        }

        /* renamed from: getPositionOnScreen-F1C5BW0  reason: not valid java name */
        public final long m4671getPositionOnScreenF1C5BW0() {
            return this.positionOnScreen;
        }

        public final boolean getDown() {
            return this.down;
        }

        /* renamed from: getType-T8wyACA  reason: not valid java name */
        public final int m4672getTypeT8wyACA() {
            return this.type;
        }
    }
}
