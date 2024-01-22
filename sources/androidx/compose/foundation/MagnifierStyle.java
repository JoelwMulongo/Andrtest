package androidx.compose.foundation;

import android.os.Build;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB<\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\bø\u0001\u0000¢\u0006\u0002\u0010\nB:\b\u0000\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\bø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0006\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\t\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0014\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u001f\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u000b\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/foundation/MagnifierStyle;", "", "size", "Landroidx/compose/ui/unit/DpSize;", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "", "fishEyeEnabled", "(JFFZZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "useTextDefault", "(ZJFFZZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getClippingEnabled$foundation_release", "()Z", "getCornerRadius-D9Ej5fM$foundation_release", "()F", "F", "getElevation-D9Ej5fM$foundation_release", "getFishEyeEnabled$foundation_release", "isSupported", "getSize-MYxV2XQ$foundation_release", "()J", "J", "getUseTextDefault$foundation_release", "equals", "other", "hashCode", "", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Magnifier.kt */
public final class MagnifierStyle {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final MagnifierStyle Default;
    /* access modifiers changed from: private */
    public static final MagnifierStyle TextDefault;
    private final boolean clippingEnabled;
    private final float cornerRadius;
    private final float elevation;
    private final boolean fishEyeEnabled;
    private final long size;
    private final boolean useTextDefault;

    public /* synthetic */ MagnifierStyle(long j, float f, float f2, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, f, f2, z, z2);
    }

    public /* synthetic */ MagnifierStyle(boolean z, long j, float f, float f2, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, j, f, f2, z2, z3);
    }

    private MagnifierStyle(boolean useTextDefault2, long size2, float cornerRadius2, float elevation2, boolean clippingEnabled2, boolean fishEyeEnabled2) {
        this.useTextDefault = useTextDefault2;
        this.size = size2;
        this.cornerRadius = cornerRadius2;
        this.elevation = elevation2;
        this.clippingEnabled = clippingEnabled2;
        this.fishEyeEnabled = fishEyeEnabled2;
    }

    public final boolean getUseTextDefault$foundation_release() {
        return this.useTextDefault;
    }

    /* renamed from: getSize-MYxV2XQ$foundation_release  reason: not valid java name */
    public final long m500getSizeMYxV2XQ$foundation_release() {
        return this.size;
    }

    /* renamed from: getCornerRadius-D9Ej5fM$foundation_release  reason: not valid java name */
    public final float m498getCornerRadiusD9Ej5fM$foundation_release() {
        return this.cornerRadius;
    }

    /* renamed from: getElevation-D9Ej5fM$foundation_release  reason: not valid java name */
    public final float m499getElevationD9Ej5fM$foundation_release() {
        return this.elevation;
    }

    public final boolean getClippingEnabled$foundation_release() {
        return this.clippingEnabled;
    }

    public final boolean getFishEyeEnabled$foundation_release() {
        return this.fishEyeEnabled;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MagnifierStyle(long r8, float r10, float r11, boolean r12, boolean r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r0 = r14 & 1
            if (r0 == 0) goto L_0x000b
            androidx.compose.ui.unit.DpSize$Companion r0 = androidx.compose.ui.unit.DpSize.Companion
            long r0 = r0.m6093getUnspecifiedMYxV2XQ()
            goto L_0x000c
        L_0x000b:
            r0 = r8
        L_0x000c:
            r2 = r14 & 2
            if (r2 == 0) goto L_0x0017
            androidx.compose.ui.unit.Dp$Companion r2 = androidx.compose.ui.unit.Dp.Companion
            float r2 = r2.m6006getUnspecifiedD9Ej5fM()
            goto L_0x0018
        L_0x0017:
            r2 = r10
        L_0x0018:
            r3 = r14 & 4
            if (r3 == 0) goto L_0x0023
            androidx.compose.ui.unit.Dp$Companion r3 = androidx.compose.ui.unit.Dp.Companion
            float r3 = r3.m6006getUnspecifiedD9Ej5fM()
            goto L_0x0024
        L_0x0023:
            r3 = r11
        L_0x0024:
            r4 = r14 & 8
            if (r4 == 0) goto L_0x002a
            r4 = 1
            goto L_0x002b
        L_0x002a:
            r4 = r12
        L_0x002b:
            r5 = r14 & 16
            if (r5 == 0) goto L_0x0031
            r5 = 0
            goto L_0x0032
        L_0x0031:
            r5 = r13
        L_0x0032:
            r6 = 0
            r8 = r7
            r9 = r0
            r11 = r2
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r8.<init>((long) r9, (float) r11, (float) r12, (boolean) r13, (boolean) r14, (kotlin.jvm.internal.DefaultConstructorMarker) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierStyle.<init>(long, float, float, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private MagnifierStyle(long size2, float cornerRadius2, float elevation2, boolean clippingEnabled2, boolean fishEyeEnabled2) {
        this(false, size2, cornerRadius2, elevation2, clippingEnabled2, fishEyeEnabled2, (DefaultConstructorMarker) null);
    }

    public final boolean isSupported() {
        return Companion.isStyleSupported$foundation_release$default(Companion, this, 0, 2, (Object) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof MagnifierStyle) && this.useTextDefault == ((MagnifierStyle) other).useTextDefault && DpSize.m6081equalsimpl0(this.size, ((MagnifierStyle) other).size) && Dp.m5991equalsimpl0(this.cornerRadius, ((MagnifierStyle) other).cornerRadius) && Dp.m5991equalsimpl0(this.elevation, ((MagnifierStyle) other).elevation) && this.clippingEnabled == ((MagnifierStyle) other).clippingEnabled && this.fishEyeEnabled == ((MagnifierStyle) other).fishEyeEnabled) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.useTextDefault) * 31) + DpSize.m6086hashCodeimpl(this.size)) * 31) + Dp.m5992hashCodeimpl(this.cornerRadius)) * 31) + Dp.m5992hashCodeimpl(this.elevation)) * 31) + Boolean.hashCode(this.clippingEnabled)) * 31) + Boolean.hashCode(this.fishEyeEnabled);
    }

    public String toString() {
        if (this.useTextDefault) {
            return "MagnifierStyle.TextDefault";
        }
        return "MagnifierStyle(size=" + DpSize.m6091toStringimpl(this.size) + ", cornerRadius=" + Dp.m5997toStringimpl(this.cornerRadius) + ", elevation=" + Dp.m5997toStringimpl(this.elevation) + ", clippingEnabled=" + this.clippingEnabled + ", fishEyeEnabled=" + this.fishEyeEnabled + ')';
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/MagnifierStyle$Companion;", "", "()V", "Default", "Landroidx/compose/foundation/MagnifierStyle;", "getDefault$annotations", "getDefault", "()Landroidx/compose/foundation/MagnifierStyle;", "TextDefault", "getTextDefault$annotations", "getTextDefault", "isStyleSupported", "", "style", "sdkVersion", "", "isStyleSupported$foundation_release", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Magnifier.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDefault$annotations() {
        }

        public static /* synthetic */ void getTextDefault$annotations() {
        }

        private Companion() {
        }

        public final MagnifierStyle getDefault() {
            return MagnifierStyle.Default;
        }

        public final MagnifierStyle getTextDefault() {
            return MagnifierStyle.TextDefault;
        }

        public static /* synthetic */ boolean isStyleSupported$foundation_release$default(Companion companion, MagnifierStyle magnifierStyle, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = Build.VERSION.SDK_INT;
            }
            return companion.isStyleSupported$foundation_release(magnifierStyle, i);
        }

        public final boolean isStyleSupported$foundation_release(MagnifierStyle style, int sdkVersion) {
            Intrinsics.checkNotNullParameter(style, "style");
            if (!MagnifierKt.isPlatformMagnifierSupported(sdkVersion) || style.getFishEyeEnabled$foundation_release()) {
                return false;
            }
            if (style.getUseTextDefault$foundation_release() || Intrinsics.areEqual((Object) style, (Object) getDefault())) {
                return true;
            }
            if (sdkVersion >= 29) {
                return true;
            }
            return false;
        }
    }

    static {
        MagnifierStyle magnifierStyle = new MagnifierStyle(0, 0.0f, 0.0f, false, false, 31, (DefaultConstructorMarker) null);
        Default = magnifierStyle;
        TextDefault = new MagnifierStyle(true, magnifierStyle.size, magnifierStyle.cornerRadius, magnifierStyle.elevation, magnifierStyle.clippingEnabled, magnifierStyle.fishEyeEnabled, (DefaultConstructorMarker) null);
    }
}
