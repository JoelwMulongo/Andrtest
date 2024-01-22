package androidx.compose.ui.text.input;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB*\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0007B&\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0002\u0010\nJ3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/text/input/TextFieldValue;", "", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "(Ljava/lang/String;JLandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "getSelection-d9O1mEE", "()J", "J", "getText", "()Ljava/lang/String;", "copy", "copy-3r_uNRQ", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/ui/text/input/TextFieldValue;", "(Ljava/lang/String;JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/ui/text/input/TextFieldValue;", "equals", "", "other", "hashCode", "", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldValue.kt */
public final class TextFieldValue {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Saver<TextFieldValue, Object> Saver = SaverKt.Saver(TextFieldValue$Companion$Saver$1.INSTANCE, TextFieldValue$Companion$Saver$2.INSTANCE);
    private final AnnotatedString annotatedString;
    private final TextRange composition;
    private final long selection;

    public /* synthetic */ TextFieldValue(AnnotatedString annotatedString2, long j, TextRange textRange, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString2, j, textRange);
    }

    public /* synthetic */ TextFieldValue(String str, long j, TextRange textRange, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, textRange);
    }

    private TextFieldValue(AnnotatedString annotatedString2, long selection2, TextRange composition2) {
        this.annotatedString = annotatedString2;
        this.selection = TextRangeKt.m5480constrain8ffj60Q(selection2, 0, getText().length());
        this.composition = composition2 != null ? TextRange.m5462boximpl(TextRangeKt.m5480constrain8ffj60Q(composition2.m5478unboximpl(), 0, getText().length())) : null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextFieldValue(androidx.compose.ui.text.AnnotatedString r7, long r8, androidx.compose.ui.text.TextRange r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r6 = this;
            r12 = r11 & 2
            if (r12 == 0) goto L_0x000c
            androidx.compose.ui.text.TextRange$Companion r8 = androidx.compose.ui.text.TextRange.Companion
            long r8 = r8.m5479getZerod9O1mEE()
            r2 = r8
            goto L_0x000d
        L_0x000c:
            r2 = r8
        L_0x000d:
            r8 = r11 & 4
            if (r8 == 0) goto L_0x0014
            r10 = 0
            r4 = r10
            goto L_0x0015
        L_0x0014:
            r4 = r10
        L_0x0015:
            r5 = 0
            r0 = r6
            r1 = r7
            r0.<init>((androidx.compose.ui.text.AnnotatedString) r1, (long) r2, (androidx.compose.ui.text.TextRange) r4, (kotlin.jvm.internal.DefaultConstructorMarker) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.TextFieldValue.<init>(androidx.compose.ui.text.AnnotatedString, long, androidx.compose.ui.text.TextRange, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextFieldValue(java.lang.String r7, long r8, androidx.compose.ui.text.TextRange r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r6 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0008
            java.lang.String r7 = ""
            r1 = r7
            goto L_0x0009
        L_0x0008:
            r1 = r7
        L_0x0009:
            r7 = r11 & 2
            if (r7 == 0) goto L_0x0015
            androidx.compose.ui.text.TextRange$Companion r7 = androidx.compose.ui.text.TextRange.Companion
            long r8 = r7.m5479getZerod9O1mEE()
            r2 = r8
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r7 = r11 & 4
            if (r7 == 0) goto L_0x001d
            r10 = 0
            r4 = r10
            goto L_0x001e
        L_0x001d:
            r4 = r10
        L_0x001e:
            r5 = 0
            r0 = r6
            r0.<init>((java.lang.String) r1, (long) r2, (androidx.compose.ui.text.TextRange) r4, (kotlin.jvm.internal.DefaultConstructorMarker) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.TextFieldValue.<init>(java.lang.String, long, androidx.compose.ui.text.TextRange, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private TextFieldValue(String text, long selection2, TextRange composition2) {
        this(new AnnotatedString(text, (List) null, (List) null, 6, (DefaultConstructorMarker) null), selection2, composition2, (DefaultConstructorMarker) null);
    }

    public final String getText() {
        return this.annotatedString.getText();
    }

    /* renamed from: getSelection-d9O1mEE  reason: not valid java name */
    public final long m5695getSelectiond9O1mEE() {
        return this.selection;
    }

    /* renamed from: getComposition-MzsxiRA  reason: not valid java name */
    public final TextRange m5694getCompositionMzsxiRA() {
        return this.composition;
    }

    /* renamed from: copy-3r_uNRQ$default  reason: not valid java name */
    public static /* synthetic */ TextFieldValue m5690copy3r_uNRQ$default(TextFieldValue textFieldValue, AnnotatedString annotatedString2, long j, TextRange textRange, int i, Object obj) {
        if ((i & 1) != 0) {
            annotatedString2 = textFieldValue.annotatedString;
        }
        if ((i & 2) != 0) {
            j = textFieldValue.selection;
        }
        if ((i & 4) != 0) {
            textRange = textFieldValue.composition;
        }
        return textFieldValue.m5692copy3r_uNRQ(annotatedString2, j, textRange);
    }

    /* renamed from: copy-3r_uNRQ  reason: not valid java name */
    public final TextFieldValue m5692copy3r_uNRQ(AnnotatedString annotatedString2, long selection2, TextRange composition2) {
        Intrinsics.checkNotNullParameter(annotatedString2, "annotatedString");
        return new TextFieldValue(annotatedString2, selection2, composition2, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-3r_uNRQ$default  reason: not valid java name */
    public static /* synthetic */ TextFieldValue m5691copy3r_uNRQ$default(TextFieldValue textFieldValue, String str, long j, TextRange textRange, int i, Object obj) {
        if ((i & 2) != 0) {
            j = textFieldValue.selection;
        }
        if ((i & 4) != 0) {
            textRange = textFieldValue.composition;
        }
        return textFieldValue.m5693copy3r_uNRQ(str, j, textRange);
    }

    /* renamed from: copy-3r_uNRQ  reason: not valid java name */
    public final TextFieldValue m5693copy3r_uNRQ(String text, long selection2, TextRange composition2) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new TextFieldValue(new AnnotatedString(text, (List) null, (List) null, 6, (DefaultConstructorMarker) null), selection2, composition2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextFieldValue)) {
            return false;
        }
        if (!TextRange.m5467equalsimpl0(this.selection, ((TextFieldValue) other).selection) || !Intrinsics.areEqual((Object) this.composition, (Object) ((TextFieldValue) other).composition) || !Intrinsics.areEqual((Object) this.annotatedString, (Object) ((TextFieldValue) other).annotatedString)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int result = ((this.annotatedString.hashCode() * 31) + TextRange.m5475hashCodeimpl(this.selection)) * 31;
        TextRange textRange = this.composition;
        return result + (textRange != null ? TextRange.m5475hashCodeimpl(textRange.m5478unboximpl()) : 0);
    }

    public String toString() {
        return "TextFieldValue(text='" + this.annotatedString + "', selection=" + TextRange.m5477toStringimpl(this.selection) + ", composition=" + this.composition + ')';
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/input/TextFieldValue$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/input/TextFieldValue;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldValue.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<TextFieldValue, Object> getSaver() {
            return TextFieldValue.Saver;
        }
    }
}
