package androidx.compose.ui.input.pointer;

import android.os.SystemClock;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInteropFilter;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\tH\u0016J-\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\tH\u0002R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"androidx/compose/ui/input/pointer/PointerInteropFilter$pointerInputFilter$1", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "shareWithSiblings", "", "getShareWithSiblings", "()Z", "state", "Landroidx/compose/ui/input/pointer/PointerInteropFilter$DispatchToViewState;", "dispatchToView", "", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "onCancel", "onPointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "reset", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerInteropFilter.android.kt */
public final class PointerInteropFilter$pointerInputFilter$1 extends PointerInputFilter {
    /* access modifiers changed from: private */
    public PointerInteropFilter.DispatchToViewState state = PointerInteropFilter.DispatchToViewState.Unknown;
    final /* synthetic */ PointerInteropFilter this$0;

    PointerInteropFilter$pointerInputFilter$1(PointerInteropFilter $receiver) {
        this.this$0 = $receiver;
    }

    public boolean getShareWithSiblings() {
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m4725onPointerEventH0pRuoY(androidx.compose.ui.input.pointer.PointerEvent r19, androidx.compose.ui.input.pointer.PointerEventPass r20, long r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            java.lang.String r2 = "pointerEvent"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            java.lang.String r2 = "pass"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.util.List r2 = r19.getChanges()
            androidx.compose.ui.input.pointer.PointerInteropFilter r4 = r0.this$0
            boolean r4 = r4.getDisallowIntercept$ui_release()
            r5 = 0
            r6 = 1
            if (r4 != 0) goto L_0x0057
            r4 = r2
            r7 = 0
            r8 = r4
            r9 = 0
            r10 = 0
            int r11 = r8.size()
        L_0x002b:
            if (r10 >= r11) goto L_0x0050
            java.lang.Object r12 = r8.get(r10)
            r13 = r12
            r14 = 0
            r15 = r13
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            r16 = 0
            boolean r17 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r15)
            if (r17 != 0) goto L_0x0047
            boolean r17 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r15)
            if (r17 == 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r15 = r5
            goto L_0x0048
        L_0x0047:
            r15 = r6
        L_0x0048:
            if (r15 == 0) goto L_0x004c
            r4 = r6
            goto L_0x0052
        L_0x004c:
            int r10 = r10 + 1
            goto L_0x002b
        L_0x0050:
            r4 = r5
        L_0x0052:
            if (r4 == 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r4 = r5
            goto L_0x0058
        L_0x0057:
            r4 = r6
        L_0x0058:
            androidx.compose.ui.input.pointer.PointerInteropFilter$DispatchToViewState r7 = r0.state
            androidx.compose.ui.input.pointer.PointerInteropFilter$DispatchToViewState r8 = androidx.compose.ui.input.pointer.PointerInteropFilter.DispatchToViewState.NotDispatching
            if (r7 == r8) goto L_0x0071
            androidx.compose.ui.input.pointer.PointerEventPass r7 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
            if (r1 != r7) goto L_0x0068
            if (r4 == 0) goto L_0x0068
            r18.dispatchToView(r19)
        L_0x0068:
            androidx.compose.ui.input.pointer.PointerEventPass r7 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            if (r1 != r7) goto L_0x0071
            if (r4 != 0) goto L_0x0071
            r18.dispatchToView(r19)
        L_0x0071:
            androidx.compose.ui.input.pointer.PointerEventPass r7 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            if (r1 != r7) goto L_0x00a0
            r7 = r2
            r8 = 0
            r9 = r7
            r10 = 0
            r11 = 0
            int r12 = r9.size()
        L_0x0080:
            if (r11 >= r12) goto L_0x0099
            java.lang.Object r13 = r9.get(r11)
            r14 = r13
            r15 = 0
            r16 = r14
            androidx.compose.ui.input.pointer.PointerInputChange r16 = (androidx.compose.ui.input.pointer.PointerInputChange) r16
            r17 = 0
            boolean r16 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r16)
            if (r16 != 0) goto L_0x0095
            goto L_0x009b
        L_0x0095:
            int r11 = r11 + 1
            goto L_0x0080
        L_0x0099:
            r5 = r6
        L_0x009b:
            if (r5 == 0) goto L_0x00a0
            r18.reset()
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1.m4725onPointerEventH0pRuoY(androidx.compose.ui.input.pointer.PointerEvent, androidx.compose.ui.input.pointer.PointerEventPass, long):void");
    }

    public void onCancel() {
        if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
            PointerInteropUtils_androidKt.emptyCancelMotionEventScope(SystemClock.uptimeMillis(), new PointerInteropFilter$pointerInputFilter$1$onCancel$1(this.this$0));
            reset();
        }
    }

    private final void reset() {
        this.state = PointerInteropFilter.DispatchToViewState.Unknown;
        this.this$0.setDisallowIntercept$ui_release(false);
    }

    private final void dispatchToView(PointerEvent pointerEvent) {
        List $this$fastForEach$iv$iv;
        List $this$fastAny$iv = pointerEvent.getChanges();
        List $this$fastForEach$iv$iv2 = $this$fastAny$iv;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv2.size();
        while (true) {
            if (index$iv$iv >= size) {
                $this$fastForEach$iv$iv = null;
                break;
            } else if (((PointerInputChange) $this$fastForEach$iv$iv2.get(index$iv$iv)).isConsumed()) {
                $this$fastForEach$iv$iv = 1;
                break;
            } else {
                index$iv$iv++;
            }
        }
        if ($this$fastForEach$iv$iv != null) {
            if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
                LayoutCoordinates layoutCoordinates$ui_release = getLayoutCoordinates$ui_release();
                if (layoutCoordinates$ui_release != null) {
                    PointerInteropUtils_androidKt.m4726toCancelMotionEventScoped4ec7I(pointerEvent, layoutCoordinates$ui_release.m4841localToRootMKHz9U(Offset.Companion.m2931getZeroF1C5BW0()), new PointerInteropFilter$pointerInputFilter$1$dispatchToView$2(this.this$0));
                } else {
                    throw new IllegalStateException("layoutCoordinates not set".toString());
                }
            }
            this.state = PointerInteropFilter.DispatchToViewState.NotDispatching;
            return;
        }
        LayoutCoordinates layoutCoordinates$ui_release2 = getLayoutCoordinates$ui_release();
        if (layoutCoordinates$ui_release2 != null) {
            PointerInteropUtils_androidKt.m4727toMotionEventScoped4ec7I(pointerEvent, layoutCoordinates$ui_release2.m4841localToRootMKHz9U(Offset.Companion.m2931getZeroF1C5BW0()), new PointerInteropFilter$pointerInputFilter$1$dispatchToView$3(this, this.this$0));
            if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
                List $this$fastForEach$iv = $this$fastAny$iv;
                int size2 = $this$fastForEach$iv.size();
                for (int index$iv = 0; index$iv < size2; index$iv++) {
                    $this$fastForEach$iv.get(index$iv).consume();
                }
                InternalPointerEvent internalPointerEvent$ui_release = pointerEvent.getInternalPointerEvent$ui_release();
                if (internalPointerEvent$ui_release != null) {
                    internalPointerEvent$ui_release.setSuppressMovementConsumption(!this.this$0.getDisallowIntercept$ui_release());
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("layoutCoordinates not set".toString());
    }
}
