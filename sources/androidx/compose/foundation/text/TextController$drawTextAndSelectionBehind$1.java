package androidx.compose.foundation.text;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreText.kt */
final class TextController$drawTextAndSelectionBehind$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ TextController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextController$drawTextAndSelectionBehind$1(TextController textController) {
        super(1);
        this.this$0 = textController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((DrawScope) p1);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0025, code lost:
        r3 = r3.getSubselections();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.ui.graphics.drawscope.DrawScope r40) {
        /*
            r39 = this;
            r0 = r39
            java.lang.String r1 = "$this$drawBehind"
            r12 = r40
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            androidx.compose.foundation.text.TextController r1 = r0.this$0
            androidx.compose.foundation.text.TextState r1 = r1.getState()
            androidx.compose.ui.text.TextLayoutResult r1 = r1.getLayoutResult()
            if (r1 == 0) goto L_0x0167
            androidx.compose.foundation.text.TextController r2 = r0.this$0
            r13 = 0
            androidx.compose.foundation.text.TextState r3 = r2.getState()
            r3.getDrawScopeInvalidation()
            androidx.compose.foundation.text.selection.SelectionRegistrar r3 = r2.selectionRegistrar
            if (r3 == 0) goto L_0x003e
            java.util.Map r3 = r3.getSubselections()
            if (r3 == 0) goto L_0x003e
            androidx.compose.foundation.text.TextState r4 = r2.getState()
            long r4 = r4.getSelectableId()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.Object r3 = r3.get(r4)
            androidx.compose.foundation.text.selection.Selection r3 = (androidx.compose.foundation.text.selection.Selection) r3
            goto L_0x003f
        L_0x003e:
            r3 = 0
        L_0x003f:
            r14 = r3
            androidx.compose.foundation.text.TextState r3 = r2.getState()
            androidx.compose.foundation.text.selection.Selectable r3 = r3.getSelectable()
            r4 = 0
            if (r3 == 0) goto L_0x0050
            int r3 = r3.getLastVisibleOffset()
            goto L_0x0051
        L_0x0050:
            r3 = r4
        L_0x0051:
            r15 = r3
            if (r14 == 0) goto L_0x0152
            boolean r3 = r14.getHandlesCrossed()
            if (r3 != 0) goto L_0x0063
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r3 = r14.getStart()
            int r3 = r3.getOffset()
            goto L_0x006b
        L_0x0063:
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r3 = r14.getEnd()
            int r3 = r3.getOffset()
        L_0x006b:
            int r3 = kotlin.ranges.RangesKt.coerceIn((int) r3, (int) r4, (int) r15)
            r11 = r3
            boolean r3 = r14.getHandlesCrossed()
            if (r3 != 0) goto L_0x007f
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r3 = r14.getEnd()
            int r3 = r3.getOffset()
            goto L_0x0087
        L_0x007f:
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r3 = r14.getStart()
            int r3 = r3.getOffset()
        L_0x0087:
            int r3 = kotlin.ranges.RangesKt.coerceIn((int) r3, (int) r4, (int) r15)
            r10 = r3
            if (r11 == r10) goto L_0x014e
            androidx.compose.ui.text.MultiParagraph r3 = r1.getMultiParagraph()
            androidx.compose.ui.graphics.Path r26 = r3.getPathForRange(r11, r10)
            androidx.compose.ui.text.TextLayoutInput r3 = r1.getLayoutInput()
            int r3 = r3.m5443getOverflowgIe3tQ8()
            androidx.compose.ui.text.style.TextOverflow$Companion r4 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r4 = r4.m5900getVisiblegIe3tQ8()
            boolean r3 = androidx.compose.ui.text.style.TextOverflow.m5891equalsimpl0(r3, r4)
            if (r3 == 0) goto L_0x00cb
            androidx.compose.foundation.text.TextState r2 = r2.getState()
            long r4 = r2.m1237getSelectionBackgroundColor0d7_KjU()
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r16 = 60
            r17 = 0
            r2 = r40
            r3 = r26
            r27 = r10
            r10 = r16
            r28 = r11
            r11 = r17
            androidx.compose.ui.graphics.drawscope.DrawScope.m3744drawPathLG529CI$default(r2, r3, r4, r6, r7, r8, r9, r10, r11)
            goto L_0x0152
        L_0x00cb:
            r27 = r10
            r28 = r11
            r3 = r40
            r10 = 0
            r11 = 0
            long r4 = r3.m3772getSizeNHjbRc()
            float r29 = androidx.compose.ui.geometry.Size.m2984getWidthimpl(r4)
            long r4 = r3.m3772getSizeNHjbRc()
            float r30 = androidx.compose.ui.geometry.Size.m2981getHeightimpl(r4)
            androidx.compose.ui.graphics.ClipOp$Companion r4 = androidx.compose.ui.graphics.ClipOp.Companion
            int r31 = r4.m3153getIntersectrtfAjoo()
            r32 = 0
            r33 = r3
            r34 = 0
            androidx.compose.ui.graphics.drawscope.DrawContext r9 = r33.getDrawContext()
            r35 = 0
            long r7 = r9.m3715getSizeNHjbRc()
            androidx.compose.ui.graphics.Canvas r4 = r9.getCanvas()
            r4.save()
            androidx.compose.ui.graphics.drawscope.DrawTransform r16 = r9.getTransform()
            r17 = 0
            r4 = r16
            r5 = r10
            r6 = r11
            r36 = r10
            r37 = r11
            r10 = r7
            r7 = r29
            r8 = r30
            r38 = r9
            r9 = r31
            r4.m3827clipRectN_I0leg(r5, r6, r7, r8, r9)
            r16 = r33
            r4 = 0
            androidx.compose.foundation.text.TextState r2 = r2.getState()
            long r18 = r2.m1237getSelectionBackgroundColor0d7_KjU()
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 60
            r25 = 0
            r17 = r26
            androidx.compose.ui.graphics.drawscope.DrawScope.m3744drawPathLG529CI$default(r16, r17, r18, r20, r21, r22, r23, r24, r25)
            androidx.compose.ui.graphics.Canvas r2 = r38.getCanvas()
            r2.restore()
            r2 = r38
            r2.m3716setSizeuvyYCjk(r10)
            goto L_0x0152
        L_0x014e:
            r27 = r10
            r28 = r11
        L_0x0152:
            r2 = r40
            r3 = 0
            androidx.compose.ui.graphics.drawscope.DrawContext r4 = r2.getDrawContext()
            androidx.compose.ui.graphics.Canvas r4 = r4.getCanvas()
            r5 = 0
            androidx.compose.foundation.text.TextDelegate$Companion r6 = androidx.compose.foundation.text.TextDelegate.Companion
            r6.paint(r4, r1)
        L_0x0167:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextController$drawTextAndSelectionBehind$1.invoke(androidx.compose.ui.graphics.drawscope.DrawScope):void");
    }
}
