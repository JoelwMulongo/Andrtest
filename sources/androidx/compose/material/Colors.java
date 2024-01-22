package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b1\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bp\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\b\u0010A\u001a\u00020BH\u0016R4\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R4\u0010\t\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R+\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00108F@@X\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b\u000f\u0010\u001c\"\u0004\b\u001d\u0010\u001eR4\u0010\f\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0018\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R4\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0018\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R4\u0010\n\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0018\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R4\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0018\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R4\u0010\r\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0018\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010\u0016R4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0018\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R4\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0018\u001a\u0004\b2\u0010\u0014\"\u0004\b3\u0010\u0016R4\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b7\u0010\u0018\u001a\u0004\b5\u0010\u0014\"\u0004\b6\u0010\u0016R4\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b:\u0010\u0018\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010\u0016R4\u0010\b\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b=\u0010\u0018\u001a\u0004\b;\u0010\u0014\"\u0004\b<\u0010\u0016\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006C"}, d2 = {"Landroidx/compose/material/Colors;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "isLight", "", "(JJJJJJJJJJJJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "getBackground-0d7_KjU", "()J", "setBackground-8_81llA$material_release", "(J)V", "background$delegate", "Landroidx/compose/runtime/MutableState;", "getError-0d7_KjU", "setError-8_81llA$material_release", "error$delegate", "()Z", "setLight$material_release", "(Z)V", "isLight$delegate", "getOnBackground-0d7_KjU", "setOnBackground-8_81llA$material_release", "onBackground$delegate", "getOnError-0d7_KjU", "setOnError-8_81llA$material_release", "onError$delegate", "getOnPrimary-0d7_KjU", "setOnPrimary-8_81llA$material_release", "onPrimary$delegate", "getOnSecondary-0d7_KjU", "setOnSecondary-8_81llA$material_release", "onSecondary$delegate", "getOnSurface-0d7_KjU", "setOnSurface-8_81llA$material_release", "onSurface$delegate", "getPrimary-0d7_KjU", "setPrimary-8_81llA$material_release", "primary$delegate", "getPrimaryVariant-0d7_KjU", "setPrimaryVariant-8_81llA$material_release", "primaryVariant$delegate", "getSecondary-0d7_KjU", "setSecondary-8_81llA$material_release", "secondary$delegate", "getSecondaryVariant-0d7_KjU", "setSecondaryVariant-8_81llA$material_release", "secondaryVariant$delegate", "getSurface-0d7_KjU", "setSurface-8_81llA$material_release", "surface$delegate", "copy", "copy-pvPzIIM", "(JJJJJJJJJJJJZ)Landroidx/compose/material/Colors;", "toString", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Colors.kt */
public final class Colors {
    public static final int $stable = 0;
    private final MutableState background$delegate;
    private final MutableState error$delegate;
    private final MutableState isLight$delegate;
    private final MutableState onBackground$delegate;
    private final MutableState onError$delegate;
    private final MutableState onPrimary$delegate;
    private final MutableState onSecondary$delegate;
    private final MutableState onSurface$delegate;
    private final MutableState primary$delegate;
    private final MutableState primaryVariant$delegate;
    private final MutableState secondary$delegate;
    private final MutableState secondaryVariant$delegate;
    private final MutableState surface$delegate;

    public /* synthetic */ Colors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, z);
    }

    private Colors(long primary, long primaryVariant, long secondary, long secondaryVariant, long background, long surface, long error, long onPrimary, long onSecondary, long onBackground, long onSurface, long onError, boolean isLight) {
        this.primary$delegate = SnapshotStateKt.mutableStateOf(Color.m3154boximpl(primary), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m3154boximpl(primaryVariant), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary$delegate = SnapshotStateKt.mutableStateOf(Color.m3154boximpl(secondary), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m3154boximpl(secondaryVariant), SnapshotStateKt.structuralEqualityPolicy());
        this.background$delegate = SnapshotStateKt.mutableStateOf(Color.m3154boximpl(background), SnapshotStateKt.structuralEqualityPolicy());
        this.surface$delegate = SnapshotStateKt.mutableStateOf(Color.m3154boximpl(surface), SnapshotStateKt.structuralEqualityPolicy());
        this.error$delegate = SnapshotStateKt.mutableStateOf(Color.m3154boximpl(error), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary$delegate = SnapshotStateKt.mutableStateOf(Color.m3154boximpl(onPrimary), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary$delegate = SnapshotStateKt.mutableStateOf(Color.m3154boximpl(onSecondary), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground$delegate = SnapshotStateKt.mutableStateOf(Color.m3154boximpl(onBackground), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface$delegate = SnapshotStateKt.mutableStateOf(Color.m3154boximpl(onSurface), SnapshotStateKt.structuralEqualityPolicy());
        this.onError$delegate = SnapshotStateKt.mutableStateOf(Color.m3154boximpl(onError), SnapshotStateKt.structuralEqualityPolicy());
        this.isLight$delegate = SnapshotStateKt.mutableStateOf(Boolean.valueOf(isLight), SnapshotStateKt.structuralEqualityPolicy());
    }

    /* renamed from: getPrimary-0d7_KjU  reason: not valid java name */
    public final long m1445getPrimary0d7_KjU() {
        return ((Color) this.primary$delegate.getValue()).m3174unboximpl();
    }

    /* renamed from: setPrimary-8_81llA$material_release  reason: not valid java name */
    public final void m1457setPrimary8_81llA$material_release(long j) {
        this.primary$delegate.setValue(Color.m3154boximpl(j));
    }

    /* renamed from: getPrimaryVariant-0d7_KjU  reason: not valid java name */
    public final long m1446getPrimaryVariant0d7_KjU() {
        return ((Color) this.primaryVariant$delegate.getValue()).m3174unboximpl();
    }

    /* renamed from: setPrimaryVariant-8_81llA$material_release  reason: not valid java name */
    public final void m1458setPrimaryVariant8_81llA$material_release(long j) {
        this.primaryVariant$delegate.setValue(Color.m3154boximpl(j));
    }

    /* renamed from: getSecondary-0d7_KjU  reason: not valid java name */
    public final long m1447getSecondary0d7_KjU() {
        return ((Color) this.secondary$delegate.getValue()).m3174unboximpl();
    }

    /* renamed from: setSecondary-8_81llA$material_release  reason: not valid java name */
    public final void m1459setSecondary8_81llA$material_release(long j) {
        this.secondary$delegate.setValue(Color.m3154boximpl(j));
    }

    /* renamed from: getSecondaryVariant-0d7_KjU  reason: not valid java name */
    public final long m1448getSecondaryVariant0d7_KjU() {
        return ((Color) this.secondaryVariant$delegate.getValue()).m3174unboximpl();
    }

    /* renamed from: setSecondaryVariant-8_81llA$material_release  reason: not valid java name */
    public final void m1460setSecondaryVariant8_81llA$material_release(long j) {
        this.secondaryVariant$delegate.setValue(Color.m3154boximpl(j));
    }

    /* renamed from: getBackground-0d7_KjU  reason: not valid java name */
    public final long m1438getBackground0d7_KjU() {
        return ((Color) this.background$delegate.getValue()).m3174unboximpl();
    }

    /* renamed from: setBackground-8_81llA$material_release  reason: not valid java name */
    public final void m1450setBackground8_81llA$material_release(long j) {
        this.background$delegate.setValue(Color.m3154boximpl(j));
    }

    /* renamed from: getSurface-0d7_KjU  reason: not valid java name */
    public final long m1449getSurface0d7_KjU() {
        return ((Color) this.surface$delegate.getValue()).m3174unboximpl();
    }

    /* renamed from: setSurface-8_81llA$material_release  reason: not valid java name */
    public final void m1461setSurface8_81llA$material_release(long j) {
        this.surface$delegate.setValue(Color.m3154boximpl(j));
    }

    /* renamed from: getError-0d7_KjU  reason: not valid java name */
    public final long m1439getError0d7_KjU() {
        return ((Color) this.error$delegate.getValue()).m3174unboximpl();
    }

    /* renamed from: setError-8_81llA$material_release  reason: not valid java name */
    public final void m1451setError8_81llA$material_release(long j) {
        this.error$delegate.setValue(Color.m3154boximpl(j));
    }

    /* renamed from: getOnPrimary-0d7_KjU  reason: not valid java name */
    public final long m1442getOnPrimary0d7_KjU() {
        return ((Color) this.onPrimary$delegate.getValue()).m3174unboximpl();
    }

    /* renamed from: setOnPrimary-8_81llA$material_release  reason: not valid java name */
    public final void m1454setOnPrimary8_81llA$material_release(long j) {
        this.onPrimary$delegate.setValue(Color.m3154boximpl(j));
    }

    /* renamed from: getOnSecondary-0d7_KjU  reason: not valid java name */
    public final long m1443getOnSecondary0d7_KjU() {
        return ((Color) this.onSecondary$delegate.getValue()).m3174unboximpl();
    }

    /* renamed from: setOnSecondary-8_81llA$material_release  reason: not valid java name */
    public final void m1455setOnSecondary8_81llA$material_release(long j) {
        this.onSecondary$delegate.setValue(Color.m3154boximpl(j));
    }

    /* renamed from: getOnBackground-0d7_KjU  reason: not valid java name */
    public final long m1440getOnBackground0d7_KjU() {
        return ((Color) this.onBackground$delegate.getValue()).m3174unboximpl();
    }

    /* renamed from: setOnBackground-8_81llA$material_release  reason: not valid java name */
    public final void m1452setOnBackground8_81llA$material_release(long j) {
        this.onBackground$delegate.setValue(Color.m3154boximpl(j));
    }

    /* renamed from: getOnSurface-0d7_KjU  reason: not valid java name */
    public final long m1444getOnSurface0d7_KjU() {
        return ((Color) this.onSurface$delegate.getValue()).m3174unboximpl();
    }

    /* renamed from: setOnSurface-8_81llA$material_release  reason: not valid java name */
    public final void m1456setOnSurface8_81llA$material_release(long j) {
        this.onSurface$delegate.setValue(Color.m3154boximpl(j));
    }

    /* renamed from: getOnError-0d7_KjU  reason: not valid java name */
    public final long m1441getOnError0d7_KjU() {
        return ((Color) this.onError$delegate.getValue()).m3174unboximpl();
    }

    /* renamed from: setOnError-8_81llA$material_release  reason: not valid java name */
    public final void m1453setOnError8_81llA$material_release(long j) {
        this.onError$delegate.setValue(Color.m3154boximpl(j));
    }

    public final boolean isLight() {
        return ((Boolean) this.isLight$delegate.getValue()).booleanValue();
    }

    public final void setLight$material_release(boolean z) {
        this.isLight$delegate.setValue(Boolean.valueOf(z));
    }

    /* renamed from: copy-pvPzIIM$default  reason: not valid java name */
    public static /* synthetic */ Colors m1436copypvPzIIM$default(Colors colors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z, int i, Object obj) {
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        long j19;
        long j20;
        long j21;
        long j22;
        long j23;
        long j24;
        boolean z2;
        int i2 = i;
        if ((i2 & 1) != 0) {
            j13 = colors.m1445getPrimary0d7_KjU();
        } else {
            j13 = j;
        }
        if ((i2 & 2) != 0) {
            j14 = colors.m1446getPrimaryVariant0d7_KjU();
        } else {
            j14 = j2;
        }
        if ((i2 & 4) != 0) {
            j15 = colors.m1447getSecondary0d7_KjU();
        } else {
            j15 = j3;
        }
        if ((i2 & 8) != 0) {
            j16 = colors.m1448getSecondaryVariant0d7_KjU();
        } else {
            j16 = j4;
        }
        if ((i2 & 16) != 0) {
            j17 = colors.m1438getBackground0d7_KjU();
        } else {
            j17 = j5;
        }
        if ((i2 & 32) != 0) {
            j18 = colors.m1449getSurface0d7_KjU();
        } else {
            j18 = j6;
        }
        if ((i2 & 64) != 0) {
            j19 = colors.m1439getError0d7_KjU();
        } else {
            j19 = j7;
        }
        if ((i2 & 128) != 0) {
            j20 = colors.m1442getOnPrimary0d7_KjU();
        } else {
            j20 = j8;
        }
        long j25 = j20;
        if ((i2 & 256) != 0) {
            j21 = colors.m1443getOnSecondary0d7_KjU();
        } else {
            j21 = j9;
        }
        long j26 = j21;
        if ((i2 & 512) != 0) {
            j22 = colors.m1440getOnBackground0d7_KjU();
        } else {
            j22 = j10;
        }
        long j27 = j22;
        if ((i2 & 1024) != 0) {
            j23 = colors.m1444getOnSurface0d7_KjU();
        } else {
            j23 = j11;
        }
        long j28 = j23;
        if ((i2 & 2048) != 0) {
            j24 = colors.m1441getOnError0d7_KjU();
        } else {
            j24 = j12;
        }
        if ((i2 & 4096) != 0) {
            z2 = colors.isLight();
        } else {
            z2 = z;
        }
        return colors.m1437copypvPzIIM(j13, j14, j15, j16, j17, j18, j19, j25, j26, j27, j28, j24, z2);
    }

    /* renamed from: copy-pvPzIIM  reason: not valid java name */
    public final Colors m1437copypvPzIIM(long primary, long primaryVariant, long secondary, long secondaryVariant, long background, long surface, long error, long onPrimary, long onSecondary, long onBackground, long onSurface, long onError, boolean isLight) {
        return new Colors(primary, primaryVariant, secondary, secondaryVariant, background, surface, error, onPrimary, onSecondary, onBackground, onSurface, onError, isLight, (DefaultConstructorMarker) null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Colors(primary=").append(Color.m3172toStringimpl(m1445getPrimary0d7_KjU())).append(", primaryVariant=").append(Color.m3172toStringimpl(m1446getPrimaryVariant0d7_KjU())).append(", secondary=").append(Color.m3172toStringimpl(m1447getSecondary0d7_KjU())).append(", secondaryVariant=").append(Color.m3172toStringimpl(m1448getSecondaryVariant0d7_KjU())).append(", background=").append(Color.m3172toStringimpl(m1438getBackground0d7_KjU())).append(", surface=").append(Color.m3172toStringimpl(m1449getSurface0d7_KjU())).append(", error=").append(Color.m3172toStringimpl(m1439getError0d7_KjU())).append(", onPrimary=").append(Color.m3172toStringimpl(m1442getOnPrimary0d7_KjU())).append(", onSecondary=").append(Color.m3172toStringimpl(m1443getOnSecondary0d7_KjU())).append(", onBackground=").append(Color.m3172toStringimpl(m1440getOnBackground0d7_KjU())).append(", onSurface=").append(Color.m3172toStringimpl(m1444getOnSurface0d7_KjU())).append(", onError=");
        sb.append(Color.m3172toStringimpl(m1441getOnError0d7_KjU())).append(", isLight=").append(isLight()).append(')');
        return sb.toString();
    }
}
