package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
final class AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeeded$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ScrollObservationScope $scrollObservationScope;
    final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeeded$1(ScrollObservationScope scrollObservationScope, AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        super(0);
        this.$scrollObservationScope = scrollObservationScope;
        this.this$0 = androidComposeViewAccessibilityDelegateCompat;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005f, code lost:
        if (r9 == false) goto L_0x0061;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r18 = this;
            r0 = r18
            androidx.compose.ui.platform.ScrollObservationScope r1 = r0.$scrollObservationScope
            androidx.compose.ui.semantics.ScrollAxisRange r1 = r1.getHorizontalScrollAxisRange()
            androidx.compose.ui.platform.ScrollObservationScope r2 = r0.$scrollObservationScope
            androidx.compose.ui.semantics.ScrollAxisRange r2 = r2.getVerticalScrollAxisRange()
            androidx.compose.ui.platform.ScrollObservationScope r3 = r0.$scrollObservationScope
            java.lang.Float r3 = r3.getOldXValue()
            androidx.compose.ui.platform.ScrollObservationScope r4 = r0.$scrollObservationScope
            java.lang.Float r4 = r4.getOldYValue()
            r5 = 0
            if (r1 == 0) goto L_0x0033
            if (r3 == 0) goto L_0x0033
            kotlin.jvm.functions.Function0 r6 = r1.getValue()
            java.lang.Object r6 = r6.invoke()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            float r7 = r3.floatValue()
            float r6 = r6 - r7
            goto L_0x0034
        L_0x0033:
            r6 = r5
        L_0x0034:
            if (r2 == 0) goto L_0x004d
            if (r4 == 0) goto L_0x004d
            kotlin.jvm.functions.Function0 r7 = r2.getValue()
            java.lang.Object r7 = r7.invoke()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            float r8 = r4.floatValue()
            float r7 = r7 - r8
            goto L_0x004e
        L_0x004d:
            r7 = r5
        L_0x004e:
            int r8 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            r9 = 0
            r10 = 1
            if (r8 != 0) goto L_0x0057
            r8 = r10
            goto L_0x0058
        L_0x0057:
            r8 = r9
        L_0x0058:
            if (r8 == 0) goto L_0x0061
            int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x005f
            r9 = r10
        L_0x005f:
            if (r9 != 0) goto L_0x00e0
        L_0x0061:
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r5 = r0.this$0
            androidx.compose.ui.platform.ScrollObservationScope r8 = r0.$scrollObservationScope
            int r8 = r8.getSemanticsNodeId()
            int r5 = r5.semanticsNodeIdToAccessibilityVirtualNodeId(r8)
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r11 = r0.this$0
            r13 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r10)
            r15 = 0
            r16 = 8
            r17 = 0
            r12 = r5
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(r11, r12, r13, r14, r15, r16, r17)
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r8 = r0.this$0
            r9 = 4096(0x1000, float:5.74E-42)
            android.view.accessibility.AccessibilityEvent r8 = r8.createEvent$ui_release(r5, r9)
            if (r1 == 0) goto L_0x00af
            kotlin.jvm.functions.Function0 r9 = r1.getValue()
            java.lang.Object r9 = r9.invoke()
            java.lang.Number r9 = (java.lang.Number) r9
            float r9 = r9.floatValue()
            int r9 = (int) r9
            r8.setScrollX(r9)
            kotlin.jvm.functions.Function0 r9 = r1.getMaxValue()
            java.lang.Object r9 = r9.invoke()
            java.lang.Number r9 = (java.lang.Number) r9
            float r9 = r9.floatValue()
            int r9 = (int) r9
            r8.setMaxScrollX(r9)
        L_0x00af:
            if (r2 == 0) goto L_0x00d5
            kotlin.jvm.functions.Function0 r9 = r2.getValue()
            java.lang.Object r9 = r9.invoke()
            java.lang.Number r9 = (java.lang.Number) r9
            float r9 = r9.floatValue()
            int r9 = (int) r9
            r8.setScrollY(r9)
            kotlin.jvm.functions.Function0 r9 = r2.getMaxValue()
            java.lang.Object r9 = r9.invoke()
            java.lang.Number r9 = (java.lang.Number) r9
            float r9 = r9.floatValue()
            int r9 = (int) r9
            r8.setMaxScrollY(r9)
        L_0x00d5:
            int r9 = (int) r6
            int r10 = (int) r7
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.Api28Impl.setScrollEventDelta(r8, r9, r10)
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r9 = r0.this$0
            boolean unused = r9.sendEvent(r8)
        L_0x00e0:
            if (r1 == 0) goto L_0x00f1
            androidx.compose.ui.platform.ScrollObservationScope r5 = r0.$scrollObservationScope
            kotlin.jvm.functions.Function0 r8 = r1.getValue()
            java.lang.Object r8 = r8.invoke()
            java.lang.Float r8 = (java.lang.Float) r8
            r5.setOldXValue(r8)
        L_0x00f1:
            if (r2 == 0) goto L_0x0102
            androidx.compose.ui.platform.ScrollObservationScope r5 = r0.$scrollObservationScope
            kotlin.jvm.functions.Function0 r8 = r2.getValue()
            java.lang.Object r8 = r8.invoke()
            java.lang.Float r8 = (java.lang.Float) r8
            r5.setOldYValue(r8)
        L_0x0102:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeeded$1.invoke():void");
    }
}
