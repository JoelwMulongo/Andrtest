package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005B\u001f\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u001f\u001a\u00020\u001aH\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\fJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u001e\u0010\"\u001a\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u001c\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0014\u0010\fR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168@X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R/\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@@X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u001e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEvent;", "", "changes", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "(Ljava/util/List;)V", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "(Ljava/util/List;Landroidx/compose/ui/input/pointer/InternalPointerEvent;)V", "buttons", "Landroidx/compose/ui/input/pointer/PointerButtons;", "getButtons-ry648PA", "()I", "I", "getChanges", "()Ljava/util/List;", "getInternalPointerEvent$ui_release", "()Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "keyboardModifiers", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "getKeyboardModifiers-k7X9c1A", "motionEvent", "Landroid/view/MotionEvent;", "getMotionEvent$ui_release", "()Landroid/view/MotionEvent;", "<set-?>", "Landroidx/compose/ui/input/pointer/PointerEventType;", "type", "getType-7fucELk", "setType-EhbLWgg$ui_release", "(I)V", "calculatePointerEventType", "calculatePointerEventType-7fucELk", "component1", "copy", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerEvent.android.kt */
public final class PointerEvent {
    public static final int $stable = 8;
    private final int buttons;
    private final List<PointerInputChange> changes;
    private final InternalPointerEvent internalPointerEvent;
    private final int keyboardModifiers;
    private int type;

    public PointerEvent(List<PointerInputChange> changes2, InternalPointerEvent internalPointerEvent2) {
        Intrinsics.checkNotNullParameter(changes2, "changes");
        this.changes = changes2;
        this.internalPointerEvent = internalPointerEvent2;
        MotionEvent motionEvent$ui_release = getMotionEvent$ui_release();
        int i = 0;
        this.buttons = PointerButtons.m4603constructorimpl(motionEvent$ui_release != null ? motionEvent$ui_release.getButtonState() : 0);
        MotionEvent motionEvent$ui_release2 = getMotionEvent$ui_release();
        this.keyboardModifiers = PointerKeyboardModifiers.m4730constructorimpl(motionEvent$ui_release2 != null ? motionEvent$ui_release2.getMetaState() : i);
        this.type = m4609calculatePointerEventType7fucELk();
    }

    public final List<PointerInputChange> getChanges() {
        return this.changes;
    }

    public final InternalPointerEvent getInternalPointerEvent$ui_release() {
        return this.internalPointerEvent;
    }

    public final MotionEvent getMotionEvent$ui_release() {
        InternalPointerEvent internalPointerEvent2 = this.internalPointerEvent;
        if (internalPointerEvent2 != null) {
            return internalPointerEvent2.getMotionEvent();
        }
        return null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PointerEvent(List<PointerInputChange> changes2) {
        this(changes2, (InternalPointerEvent) null);
        Intrinsics.checkNotNullParameter(changes2, "changes");
    }

    /* renamed from: getButtons-ry648PA  reason: not valid java name */
    public final int m4610getButtonsry648PA() {
        return this.buttons;
    }

    /* renamed from: getKeyboardModifiers-k7X9c1A  reason: not valid java name */
    public final int m4611getKeyboardModifiersk7X9c1A() {
        return this.keyboardModifiers;
    }

    /* renamed from: getType-7fucELk  reason: not valid java name */
    public final int m4612getType7fucELk() {
        return this.type;
    }

    /* renamed from: setType-EhbLWgg$ui_release  reason: not valid java name */
    public final void m4613setTypeEhbLWgg$ui_release(int i) {
        this.type = i;
    }

    /* renamed from: calculatePointerEventType-7fucELk  reason: not valid java name */
    private final int m4609calculatePointerEventType7fucELk() {
        MotionEvent motionEvent = getMotionEvent$ui_release();
        if (motionEvent != null) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                case 5:
                    return PointerEventType.Companion.m4626getPress7fucELk();
                case 1:
                case 6:
                    return PointerEventType.Companion.m4627getRelease7fucELk();
                case 2:
                case 7:
                    return PointerEventType.Companion.m4625getMove7fucELk();
                case 8:
                    return PointerEventType.Companion.m4628getScroll7fucELk();
                case 9:
                    return PointerEventType.Companion.m4623getEnter7fucELk();
                case 10:
                    return PointerEventType.Companion.m4624getExit7fucELk();
                default:
                    return PointerEventType.Companion.m4629getUnknown7fucELk();
            }
        } else {
            List $this$fastForEach$iv = this.changes;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                PointerInputChange it = $this$fastForEach$iv.get(index$iv);
                if (PointerEventKt.changedToUpIgnoreConsumed(it)) {
                    return PointerEventType.Companion.m4627getRelease7fucELk();
                }
                if (PointerEventKt.changedToDownIgnoreConsumed(it)) {
                    return PointerEventType.Companion.m4626getPress7fucELk();
                }
            }
            return PointerEventType.Companion.m4625getMove7fucELk();
        }
    }

    public final List<PointerInputChange> component1() {
        return this.changes;
    }

    public final PointerEvent copy(List<PointerInputChange> changes2, MotionEvent motionEvent) {
        int $i$f$fastForEach;
        List $this$fastForEach$iv$iv;
        boolean z;
        List<PointerInputChange> list = changes2;
        MotionEvent motionEvent2 = motionEvent;
        Intrinsics.checkNotNullParameter(list, "changes");
        if (motionEvent2 == null) {
            return new PointerEvent(list, (InternalPointerEvent) null);
        }
        if (Intrinsics.areEqual((Object) motionEvent2, (Object) getMotionEvent$ui_release())) {
            return new PointerEvent(list, this.internalPointerEvent);
        }
        Map map = new LinkedHashMap();
        List $this$fastForEach$iv = changes2;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            PointerInputChange change = $this$fastForEach$iv.get(index$iv);
            map.put(PointerId.m4649boximpl(change.m4666getIdJ3iCeTQ()), change);
        }
        List $this$fastMap$iv = changes2;
        int $i$f$fastMap = false;
        ArrayList target$iv = new ArrayList($this$fastMap$iv.size());
        List $this$fastForEach$iv$iv2 = $this$fastMap$iv;
        int $i$f$fastForEach2 = false;
        int index$iv$iv = 0;
        int size2 = $this$fastForEach$iv$iv2.size();
        while (index$iv$iv < size2) {
            Collection collection = target$iv;
            PointerInputChange it = (PointerInputChange) $this$fastForEach$iv$iv2.get(index$iv$iv);
            List $this$fastMap$iv2 = $this$fastMap$iv;
            long r18 = it.m4666getIdJ3iCeTQ();
            long uptimeMillis = it.getUptimeMillis();
            long r22 = it.m4667getPositionF1C5BW0();
            long r24 = it.m4667getPositionF1C5BW0();
            boolean pressed = it.getPressed();
            float pressure = it.getPressure();
            int r28 = it.m4670getTypeT8wyACA();
            int $i$f$fastMap2 = $i$f$fastMap;
            InternalPointerEvent internalPointerEvent2 = this.internalPointerEvent;
            if (internalPointerEvent2 != null) {
                $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                $i$f$fastForEach = $i$f$fastForEach2;
                if (internalPointerEvent2.m4599issuesEnterExitEvent0FcD4WY(it.m4666getIdJ3iCeTQ())) {
                    z = true;
                    collection.add(new PointerInputEventData(r18, uptimeMillis, r22, r24, pressed, pressure, r28, z, (List) null, 0, 768, (DefaultConstructorMarker) null));
                    index$iv$iv++;
                    $this$fastMap$iv = $this$fastMap$iv2;
                    $i$f$fastMap = $i$f$fastMap2;
                    $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                    $i$f$fastForEach2 = $i$f$fastForEach;
                }
            } else {
                $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                $i$f$fastForEach = $i$f$fastForEach2;
            }
            z = false;
            collection.add(new PointerInputEventData(r18, uptimeMillis, r22, r24, pressed, pressure, r28, z, (List) null, 0, 768, (DefaultConstructorMarker) null));
            index$iv$iv++;
            $this$fastMap$iv = $this$fastMap$iv2;
            $i$f$fastMap = $i$f$fastMap2;
            $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
            $i$f$fastForEach2 = $i$f$fastForEach;
        }
        int i = $i$f$fastMap;
        List list2 = $this$fastForEach$iv$iv2;
        int i2 = $i$f$fastForEach2;
        return new PointerEvent(list, new InternalPointerEvent(map, new PointerInputEvent(motionEvent.getEventTime(), target$iv, motionEvent2)));
    }
}
