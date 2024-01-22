package androidx.compose.ui.text.style;

import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001c\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0005J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/text/style/TextIndent;", "", "firstLine", "Landroidx/compose/ui/unit/TextUnit;", "restLine", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFirstLine-XSAIIZE", "()J", "J", "getRestLine-XSAIIZE", "copy", "copy-NB67dxo", "(JJ)Landroidx/compose/ui/text/style/TextIndent;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextIndent.kt */
public final class TextIndent {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TextIndent None = new TextIndent(0, 0, 3, (DefaultConstructorMarker) null);
    private final long firstLine;
    private final long restLine;

    public /* synthetic */ TextIndent(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    private TextIndent(long firstLine2, long restLine2) {
        this.firstLine = firstLine2;
        this.restLine = restLine2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextIndent(long r8, long r10, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r7 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x000b
            long r8 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r0)
            r2 = r8
            goto L_0x000c
        L_0x000b:
            r2 = r8
        L_0x000c:
            r8 = r12 & 2
            if (r8 == 0) goto L_0x0016
            long r10 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r0)
            r4 = r10
            goto L_0x0017
        L_0x0016:
            r4 = r10
        L_0x0017:
            r6 = 0
            r1 = r7
            r1.<init>(r2, r4, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.style.TextIndent.<init>(long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getFirstLine-XSAIIZE  reason: not valid java name */
    public final long m5873getFirstLineXSAIIZE() {
        return this.firstLine;
    }

    /* renamed from: getRestLine-XSAIIZE  reason: not valid java name */
    public final long m5874getRestLineXSAIIZE() {
        return this.restLine;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/style/TextIndent$Companion;", "", "()V", "None", "Landroidx/compose/ui/text/style/TextIndent;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/text/style/TextIndent;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextIndent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getNone$annotations() {
        }

        private Companion() {
        }

        public final TextIndent getNone() {
            return TextIndent.None;
        }
    }

    /* renamed from: copy-NB67dxo$default  reason: not valid java name */
    public static /* synthetic */ TextIndent m5871copyNB67dxo$default(TextIndent textIndent, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = textIndent.firstLine;
        }
        if ((i & 2) != 0) {
            j2 = textIndent.restLine;
        }
        return textIndent.m5872copyNB67dxo(j, j2);
    }

    /* renamed from: copy-NB67dxo  reason: not valid java name */
    public final TextIndent m5872copyNB67dxo(long firstLine2, long restLine2) {
        return new TextIndent(firstLine2, restLine2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof TextIndent) && TextUnit.m6164equalsimpl0(this.firstLine, ((TextIndent) other).firstLine) && TextUnit.m6164equalsimpl0(this.restLine, ((TextIndent) other).restLine)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (TextUnit.m6168hashCodeimpl(this.firstLine) * 31) + TextUnit.m6168hashCodeimpl(this.restLine);
    }

    public String toString() {
        return "TextIndent(firstLine=" + TextUnit.m6174toStringimpl(this.firstLine) + ", restLine=" + TextUnit.m6174toStringimpl(this.restLine) + ')';
    }
}
