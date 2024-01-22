package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB:\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0002\u0010\u000bJE\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/text/input/ImeOptions;", "", "singleLine", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "autoCorrect", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "(ZIZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoCorrect", "()Z", "getCapitalization-IUNYP9k", "()I", "I", "getImeAction-eUduSuo", "getKeyboardType-PjHm6EE", "getSingleLine", "copy", "copy-uxg59PA", "(ZIZII)Landroidx/compose/ui/text/input/ImeOptions;", "equals", "other", "hashCode", "", "toString", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ImeOptions.kt */
public final class ImeOptions {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ImeOptions Default = new ImeOptions(false, 0, false, 0, 0, 31, (DefaultConstructorMarker) null);
    private final boolean autoCorrect;
    private final int capitalization;
    private final int imeAction;
    private final int keyboardType;
    private final boolean singleLine;

    public /* synthetic */ ImeOptions(boolean z, int i, boolean z2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, z2, i2, i3);
    }

    private ImeOptions(boolean singleLine2, int capitalization2, boolean autoCorrect2, int keyboardType2, int imeAction2) {
        this.singleLine = singleLine2;
        this.capitalization = capitalization2;
        this.autoCorrect = autoCorrect2;
        this.keyboardType = keyboardType2;
        this.imeAction = imeAction2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ImeOptions(boolean r8, int r9, boolean r10, int r11, int r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x0007
            r8 = 0
            r1 = r8
            goto L_0x0008
        L_0x0007:
            r1 = r8
        L_0x0008:
            r8 = r13 & 2
            if (r8 == 0) goto L_0x0014
            androidx.compose.ui.text.input.KeyboardCapitalization$Companion r8 = androidx.compose.ui.text.input.KeyboardCapitalization.Companion
            int r9 = r8.m5662getNoneIUNYP9k()
            r2 = r9
            goto L_0x0015
        L_0x0014:
            r2 = r9
        L_0x0015:
            r8 = r13 & 4
            if (r8 == 0) goto L_0x001c
            r10 = 1
            r3 = r10
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r8 = r13 & 8
            if (r8 == 0) goto L_0x0029
            androidx.compose.ui.text.input.KeyboardType$Companion r8 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r11 = r8.m5688getTextPjHm6EE()
            r4 = r11
            goto L_0x002a
        L_0x0029:
            r4 = r11
        L_0x002a:
            r8 = r13 & 16
            if (r8 == 0) goto L_0x0036
            androidx.compose.ui.text.input.ImeAction$Companion r8 = androidx.compose.ui.text.input.ImeAction.Companion
            int r12 = r8.m5634getDefaulteUduSuo()
            r5 = r12
            goto L_0x0037
        L_0x0036:
            r5 = r12
        L_0x0037:
            r6 = 0
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.ImeOptions.<init>(boolean, int, boolean, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public final int m5644getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    /* renamed from: getKeyboardType-PjHm6EE  reason: not valid java name */
    public final int m5646getKeyboardTypePjHm6EE() {
        return this.keyboardType;
    }

    /* renamed from: getImeAction-eUduSuo  reason: not valid java name */
    public final int m5645getImeActioneUduSuo() {
        return this.imeAction;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/input/ImeOptions$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/input/ImeOptions;", "getDefault", "()Landroidx/compose/ui/text/input/ImeOptions;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ImeOptions.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImeOptions getDefault() {
            return ImeOptions.Default;
        }
    }

    /* renamed from: copy-uxg59PA$default  reason: not valid java name */
    public static /* synthetic */ ImeOptions m5642copyuxg59PA$default(ImeOptions imeOptions, boolean z, int i, boolean z2, int i2, int i3, int i4, Object obj) {
        int i5;
        boolean z3;
        int i6;
        int i7;
        if ((i4 & 1) != 0) {
            z = imeOptions.singleLine;
        }
        if ((i4 & 2) != 0) {
            i5 = imeOptions.capitalization;
        } else {
            i5 = i;
        }
        if ((i4 & 4) != 0) {
            z3 = imeOptions.autoCorrect;
        } else {
            z3 = z2;
        }
        if ((i4 & 8) != 0) {
            i6 = imeOptions.keyboardType;
        } else {
            i6 = i2;
        }
        if ((i4 & 16) != 0) {
            i7 = imeOptions.imeAction;
        } else {
            i7 = i3;
        }
        return imeOptions.m5643copyuxg59PA(z, i5, z3, i6, i7);
    }

    /* renamed from: copy-uxg59PA  reason: not valid java name */
    public final ImeOptions m5643copyuxg59PA(boolean singleLine2, int capitalization2, boolean autoCorrect2, int keyboardType2, int imeAction2) {
        return new ImeOptions(singleLine2, capitalization2, autoCorrect2, keyboardType2, imeAction2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ImeOptions) && this.singleLine == ((ImeOptions) other).singleLine && KeyboardCapitalization.m5653equalsimpl0(this.capitalization, ((ImeOptions) other).capitalization) && this.autoCorrect == ((ImeOptions) other).autoCorrect && KeyboardType.m5668equalsimpl0(this.keyboardType, ((ImeOptions) other).keyboardType) && ImeAction.m5622equalsimpl0(this.imeAction, ((ImeOptions) other).imeAction)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.singleLine) * 31) + KeyboardCapitalization.m5654hashCodeimpl(this.capitalization)) * 31) + Boolean.hashCode(this.autoCorrect)) * 31) + KeyboardType.m5669hashCodeimpl(this.keyboardType)) * 31) + ImeAction.m5623hashCodeimpl(this.imeAction);
    }

    public String toString() {
        return "ImeOptions(singleLine=" + this.singleLine + ", capitalization=" + KeyboardCapitalization.m5655toStringimpl(this.capitalization) + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + KeyboardType.m5670toStringimpl(this.keyboardType) + ", imeAction=" + ImeAction.m5624toStringimpl(this.imeAction) + ')';
    }
}
