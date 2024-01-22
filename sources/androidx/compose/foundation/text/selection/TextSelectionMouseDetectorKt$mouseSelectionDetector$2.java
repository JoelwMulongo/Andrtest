package androidx.compose.foundation.text.selection;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2", f = "TextSelectionMouseDetector.kt", i = {0, 0, 1, 1, 2, 2}, l = {89, 96, 111}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "clicksCounter", "$this$awaitEachGesture", "clicksCounter", "$this$awaitEachGesture", "clicksCounter"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
/* compiled from: TextSelectionMouseDetector.kt */
final class TextSelectionMouseDetectorKt$mouseSelectionDetector$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MouseSelectionObserver $observer;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextSelectionMouseDetectorKt$mouseSelectionDetector$2(MouseSelectionObserver mouseSelectionObserver, Continuation<? super TextSelectionMouseDetectorKt$mouseSelectionDetector$2> continuation) {
        super(2, continuation);
        this.$observer = mouseSelectionObserver;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TextSelectionMouseDetectorKt$mouseSelectionDetector$2 textSelectionMouseDetectorKt$mouseSelectionDetector$2 = new TextSelectionMouseDetectorKt$mouseSelectionDetector$2(this.$observer, continuation);
        textSelectionMouseDetectorKt$mouseSelectionDetector$2.L$0 = obj;
        return textSelectionMouseDetectorKt$mouseSelectionDetector$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((TextSelectionMouseDetectorKt$mouseSelectionDetector$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0066 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            switch(r1) {
                case 0: goto L_0x0044;
                case 1: goto L_0x0033;
                case 2: goto L_0x0022;
                case 3: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0011:
            r1 = r12
            java.lang.Object r2 = r1.L$1
            androidx.compose.foundation.text.selection.ClicksCounter r2 = (androidx.compose.foundation.text.selection.ClicksCounter) r2
            java.lang.Object r3 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
            kotlin.ResultKt.throwOnFailure(r13)
            r11 = r3
            r3 = r2
            r2 = r11
            goto L_0x0105
        L_0x0022:
            r1 = r12
            java.lang.Object r2 = r1.L$1
            androidx.compose.foundation.text.selection.ClicksCounter r2 = (androidx.compose.foundation.text.selection.ClicksCounter) r2
            java.lang.Object r3 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
            kotlin.ResultKt.throwOnFailure(r13)
            r11 = r3
            r3 = r2
            r2 = r11
            goto L_0x00b6
        L_0x0033:
            r1 = r12
            java.lang.Object r2 = r1.L$1
            androidx.compose.foundation.text.selection.ClicksCounter r2 = (androidx.compose.foundation.text.selection.ClicksCounter) r2
            java.lang.Object r3 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
            kotlin.ResultKt.throwOnFailure(r13)
            r4 = r2
            r2 = r1
            r1 = r0
            r0 = r13
            goto L_0x006e
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r13)
            r1 = r12
            java.lang.Object r2 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            androidx.compose.foundation.text.selection.ClicksCounter r3 = new androidx.compose.foundation.text.selection.ClicksCounter
            androidx.compose.ui.platform.ViewConfiguration r4 = r2.getViewConfiguration()
            r3.<init>(r4)
        L_0x0055:
            r4 = r1
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r1.L$0 = r2
            r1.L$1 = r3
            r5 = 1
            r1.label = r5
            java.lang.Object r4 = androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt.awaitMouseEventDown(r2, r4)
            if (r4 != r0) goto L_0x0067
            return r0
        L_0x0067:
            r11 = r0
            r0 = r13
            r13 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r1 = r11
        L_0x006e:
            androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
            r4.update(r13)
            java.util.List r5 = r13.getChanges()
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            boolean r6 = androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt.isShiftPressed(r13)
            if (r6 == 0) goto L_0x00b7
            androidx.compose.foundation.text.selection.MouseSelectionObserver r13 = r2.$observer
            long r6 = r5.m4667getPositionF1C5BW0()
            boolean r13 = r13.m1248onExtendk4lQ0M(r6)
            if (r13 == 0) goto L_0x0107
            r5.consume()
            long r6 = r5.m4666getIdJ3iCeTQ()
            androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$1 r13 = new androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$1
            androidx.compose.foundation.text.selection.MouseSelectionObserver r8 = r2.$observer
            r13.<init>(r8)
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r8 = r2
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r2.L$0 = r3
            r2.L$1 = r4
            r9 = 2
            r2.label = r9
            java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m554dragjO51t88(r3, r6, r13, r8)
            if (r13 != r1) goto L_0x00b1
            return r1
        L_0x00b1:
            r13 = r0
            r0 = r1
            r1 = r2
            r2 = r3
            r3 = r4
        L_0x00b6:
            goto L_0x0055
        L_0x00b7:
            int r13 = r4.getClicks()
            switch(r13) {
                case 1: goto L_0x00cc;
                case 2: goto L_0x00c5;
                default: goto L_0x00be;
            }
        L_0x00be:
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r13 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
            androidx.compose.foundation.text.selection.SelectionAdjustment r13 = r13.getParagraph()
            goto L_0x00d2
        L_0x00c5:
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r13 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
            androidx.compose.foundation.text.selection.SelectionAdjustment r13 = r13.getWord()
            goto L_0x00d2
        L_0x00cc:
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r13 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
            androidx.compose.foundation.text.selection.SelectionAdjustment r13 = r13.getNone()
        L_0x00d2:
            androidx.compose.foundation.text.selection.MouseSelectionObserver r6 = r2.$observer
            long r7 = r5.m4667getPositionF1C5BW0()
            boolean r6 = r6.m1250onStart3MmeM6k(r7, r13)
            if (r6 == 0) goto L_0x0107
            r5.consume()
            long r6 = r5.m4666getIdJ3iCeTQ()
            androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$2 r8 = new androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$2
            androidx.compose.foundation.text.selection.MouseSelectionObserver r9 = r2.$observer
            r8.<init>(r9, r13)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r9 = r2
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r2.L$0 = r3
            r2.L$1 = r4
            r10 = 3
            r2.label = r10
            java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m554dragjO51t88(r3, r6, r8, r9)
            if (r13 != r1) goto L_0x0100
            return r1
        L_0x0100:
            r13 = r0
            r0 = r1
            r1 = r2
            r2 = r3
            r3 = r4
        L_0x0105:
            goto L_0x0055
        L_0x0107:
            r13 = r0
            r0 = r1
            r1 = r2
            r2 = r3
            r3 = r4
            goto L_0x0055
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
