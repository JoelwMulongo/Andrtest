package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u001d\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"ClicksSlop", "", "awaitMouseEventDown", "Landroidx/compose/ui/input/pointer/PointerEvent;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelectionDetector", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "observer", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextSelectionMouseDetector.kt */
public final class TextSelectionMouseDetectorKt {
    public static final double ClicksSlop = 100.0d;

    public static final Object mouseSelectionDetector(PointerInputScope $this$mouseSelectionDetector, MouseSelectionObserver observer, Continuation<? super Unit> $completion) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$mouseSelectionDetector, new TextSelectionMouseDetectorKt$mouseSelectionDetector$2(observer, (Continuation<? super TextSelectionMouseDetectorKt$mouseSelectionDetector$2>) null), $completion);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object awaitMouseEventDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerEvent> r18) {
        /*
            r0 = r18
            boolean r1 = r0 instanceof androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$awaitMouseEventDown$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$awaitMouseEventDown$1 r1 = (androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$awaitMouseEventDown$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$awaitMouseEventDown$1 r1 = new androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$awaitMouseEventDown$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 1
            switch(r3) {
                case 0: goto L_0x003b;
                case 1: goto L_0x0030;
                default: goto L_0x0028;
            }
        L_0x0028:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0030:
            java.lang.Object r3 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
            kotlin.ResultKt.throwOnFailure(r1)
            r5 = r3
            r3 = r2
            r2 = r1
            goto L_0x0054
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r17
        L_0x0040:
            androidx.compose.ui.input.pointer.PointerEventPass r5 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r5 = r3.awaitPointerEvent(r5, r0)
            if (r5 != r2) goto L_0x004d
            return r2
        L_0x004d:
            r16 = r2
            r2 = r1
            r1 = r5
            r5 = r3
            r3 = r16
        L_0x0054:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            int r6 = r1.m4610getButtonsry648PA()
            boolean r6 = androidx.compose.ui.input.pointer.PointerEvent_androidKt.m4643isPrimaryPressedaHzCxE(r6)
            if (r6 == 0) goto L_0x00a0
            java.util.List r6 = r1.getChanges()
            r7 = 0
            r8 = 0
            r9 = 0
            int r10 = r6.size()
        L_0x006f:
            if (r9 >= r10) goto L_0x009b
            java.lang.Object r11 = r6.get(r9)
            r12 = 0
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            r13 = 0
            int r14 = r11.m4670getTypeT8wyACA()
            androidx.compose.ui.input.pointer.PointerType$Companion r15 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r15 = r15.m4744getMouseT8wyACA()
            boolean r14 = androidx.compose.ui.input.pointer.PointerType.m4739equalsimpl0(r14, r15)
            r15 = 0
            if (r14 == 0) goto L_0x0093
            boolean r14 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDown(r11)
            if (r14 == 0) goto L_0x0093
            r11 = r4
            goto L_0x0094
        L_0x0093:
            r11 = r15
        L_0x0094:
            if (r11 != 0) goto L_0x0097
            goto L_0x009d
        L_0x0097:
            int r9 = r9 + 1
            goto L_0x006f
        L_0x009b:
            r15 = r4
        L_0x009d:
            if (r15 == 0) goto L_0x00a0
            return r1
        L_0x00a0:
            r1 = r2
            r2 = r3
            r3 = r5
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt.awaitMouseEventDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
