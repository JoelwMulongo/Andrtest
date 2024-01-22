package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: MultiParagraphIntrinsics.kt */
final class MultiParagraphIntrinsics$minIntrinsicWidth$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ MultiParagraphIntrinsics this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultiParagraphIntrinsics$minIntrinsicWidth$2(MultiParagraphIntrinsics multiParagraphIntrinsics) {
        super(0);
        this.this$0 = multiParagraphIntrinsics;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004c, code lost:
        r0 = r2.getIntrinsics();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Float invoke() {
        /*
            r10 = this;
            androidx.compose.ui.text.MultiParagraphIntrinsics r0 = r10.this$0
            java.util.List r0 = r0.getInfoList$ui_text_release()
            r1 = 0
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x0010
            r2 = 0
            goto L_0x0048
        L_0x0010:
            r2 = 0
            java.lang.Object r2 = r0.get(r2)
            r3 = r2
            androidx.compose.ui.text.ParagraphIntrinsicInfo r3 = (androidx.compose.ui.text.ParagraphIntrinsicInfo) r3
            r4 = 0
            androidx.compose.ui.text.ParagraphIntrinsics r5 = r3.getIntrinsics()
            float r3 = r5.getMinIntrinsicWidth()
            r4 = 1
            int r5 = kotlin.collections.CollectionsKt.getLastIndex(r0)
            if (r4 > r5) goto L_0x0047
        L_0x0029:
            java.lang.Object r6 = r0.get(r4)
            r7 = r6
            androidx.compose.ui.text.ParagraphIntrinsicInfo r7 = (androidx.compose.ui.text.ParagraphIntrinsicInfo) r7
            r8 = 0
            androidx.compose.ui.text.ParagraphIntrinsics r9 = r7.getIntrinsics()
            float r7 = r9.getMinIntrinsicWidth()
            int r8 = java.lang.Float.compare(r3, r7)
            if (r8 >= 0) goto L_0x0042
            r2 = r6
            r3 = r7
        L_0x0042:
            if (r4 == r5) goto L_0x0047
            int r4 = r4 + 1
            goto L_0x0029
        L_0x0047:
        L_0x0048:
            androidx.compose.ui.text.ParagraphIntrinsicInfo r2 = (androidx.compose.ui.text.ParagraphIntrinsicInfo) r2
            if (r2 == 0) goto L_0x0058
            androidx.compose.ui.text.ParagraphIntrinsics r0 = r2.getIntrinsics()
            if (r0 == 0) goto L_0x0058
            float r0 = r0.getMinIntrinsicWidth()
            goto L_0x0059
        L_0x0058:
            r0 = 0
        L_0x0059:
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.MultiParagraphIntrinsics$minIntrinsicWidth$2.invoke():java.lang.Float");
    }
}
