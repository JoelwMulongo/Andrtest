package androidx.compose.ui.window;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/window/DialogProperties;", "", "dismissOnBackPress", "", "dismissOnClickOutside", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;)V", "usePlatformDefaultWidth", "decorFitsSystemWindows", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "getDecorFitsSystemWindows", "()Z", "getDismissOnBackPress", "getDismissOnClickOutside", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getUsePlatformDefaultWidth", "equals", "other", "hashCode", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidDialog.android.kt */
public final class DialogProperties {
    public static final int $stable = 0;
    private final boolean decorFitsSystemWindows;
    private final boolean dismissOnBackPress;
    private final boolean dismissOnClickOutside;
    private final SecureFlagPolicy securePolicy;
    private final boolean usePlatformDefaultWidth;

    public DialogProperties() {
        this(false, false, (SecureFlagPolicy) null, false, false, 31, (DefaultConstructorMarker) null);
    }

    public DialogProperties(boolean dismissOnBackPress2, boolean dismissOnClickOutside2, SecureFlagPolicy securePolicy2, boolean usePlatformDefaultWidth2, boolean decorFitsSystemWindows2) {
        Intrinsics.checkNotNullParameter(securePolicy2, "securePolicy");
        this.dismissOnBackPress = dismissOnBackPress2;
        this.dismissOnClickOutside = dismissOnClickOutside2;
        this.securePolicy = securePolicy2;
        this.usePlatformDefaultWidth = usePlatformDefaultWidth2;
        this.decorFitsSystemWindows = decorFitsSystemWindows2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DialogProperties(boolean r5, boolean r6, androidx.compose.ui.window.SecureFlagPolicy r7, boolean r8, boolean r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 1
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0017
            androidx.compose.ui.window.SecureFlagPolicy r7 = androidx.compose.ui.window.SecureFlagPolicy.Inherit
            r2 = r7
            goto L_0x0018
        L_0x0017:
            r2 = r7
        L_0x0018:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001e
            r3 = r0
            goto L_0x001f
        L_0x001e:
            r3 = r8
        L_0x001f:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0025
            r10 = r0
            goto L_0x0026
        L_0x0025:
            r10 = r9
        L_0x0026:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>((boolean) r6, (boolean) r7, (androidx.compose.ui.window.SecureFlagPolicy) r8, (boolean) r9, (boolean) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.DialogProperties.<init>(boolean, boolean, androidx.compose.ui.window.SecureFlagPolicy, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean getDismissOnBackPress() {
        return this.dismissOnBackPress;
    }

    public final boolean getDismissOnClickOutside() {
        return this.dismissOnClickOutside;
    }

    public final SecureFlagPolicy getSecurePolicy() {
        return this.securePolicy;
    }

    public final boolean getUsePlatformDefaultWidth() {
        return this.usePlatformDefaultWidth;
    }

    public final boolean getDecorFitsSystemWindows() {
        return this.decorFitsSystemWindows;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DialogProperties(boolean z, boolean z2, SecureFlagPolicy secureFlagPolicy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DialogProperties(boolean dismissOnBackPress2, boolean dismissOnClickOutside2, SecureFlagPolicy securePolicy2) {
        this(dismissOnBackPress2, dismissOnClickOutside2, securePolicy2, true, true);
        Intrinsics.checkNotNullParameter(securePolicy2, "securePolicy");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof DialogProperties) && this.dismissOnBackPress == ((DialogProperties) other).dismissOnBackPress && this.dismissOnClickOutside == ((DialogProperties) other).dismissOnClickOutside && this.securePolicy == ((DialogProperties) other).securePolicy && this.usePlatformDefaultWidth == ((DialogProperties) other).usePlatformDefaultWidth && this.decorFitsSystemWindows == ((DialogProperties) other).decorFitsSystemWindows) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.dismissOnBackPress) * 31) + Boolean.hashCode(this.dismissOnClickOutside)) * 31) + this.securePolicy.hashCode()) * 31) + Boolean.hashCode(this.usePlatformDefaultWidth)) * 31) + Boolean.hashCode(this.decorFitsSystemWindows);
    }
}
