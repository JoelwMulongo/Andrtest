package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u000b\u001a\u00020\f*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u000b\u001a\u00020\f*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\r*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0013\u001a\u00020\r*\u00020\u0003H\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0013\u001a\u00020\r*\u00020\fH\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u001a*\u00020\u001bH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u0003*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u0019\u0010\u001e\u001a\u00020\u0003*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0015J\f\u0010!\u001a\u00020\"*\u00020#H\u0017J\u0019\u0010$\u001a\u00020\u001b*\u00020\u001aH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010\u001dJ\u0019\u0010&\u001a\u00020\u0010*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\u001c\u0010&\u001a\u00020\u0010*\u00020\u0003H\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010(J\u001c\u0010&\u001a\u00020\u0010*\u00020\fH\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007ø\u0001\u0003\u0002\u0015\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!\n\u0004\b!0\u0001¨\u0006+À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "fontScale", "getFontScale$annotations", "getFontScale", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Density.kt */
public interface Density {
    float getDensity();

    float getFontScale();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Density.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        public static /* synthetic */ void getFontScale$annotations() {
        }

        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m5979toPx0680j_4(Density $this, float $receiver) {
            return Density.super.m5967toPx0680j_4($receiver);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m5973roundToPx0680j_4(Density $this, float $receiver) {
            return Density.super.m5961roundToPx0680j_4($receiver);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m5981toSp0xMU5do(Density $this, float $receiver) {
            return Density.super.m5969toSp0xMU5do($receiver);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m5978toPxR2X_6o(Density $this, long $receiver) {
            return Density.super.m5966toPxR2X_6o($receiver);
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m5972roundToPxR2X_6o(Density $this, long $receiver) {
            return Density.super.m5960roundToPxR2X_6o($receiver);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m5974toDpGaN1DYA(Density $this, long $receiver) {
            return Density.super.m5962toDpGaN1DYA($receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m5976toDpu2uoSUM(Density $this, int $receiver) {
            return Density.super.m5964toDpu2uoSUM($receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m5983toSpkPz2Gy4(Density $this, int $receiver) {
            return Density.super.m5971toSpkPz2Gy4($receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m5975toDpu2uoSUM(Density $this, float $receiver) {
            return Density.super.m5963toDpu2uoSUM($receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m5982toSpkPz2Gy4(Density $this, float $receiver) {
            return Density.super.m5970toSpkPz2Gy4($receiver);
        }

        @Deprecated
        public static Rect toRect(Density $this, DpRect $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return Density.super.toRect($receiver);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m5980toSizeXkaWNTQ(Density $this, long $receiver) {
            return Density.super.m5968toSizeXkaWNTQ($receiver);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m5977toDpSizekrfVVM(Density $this, long $receiver) {
            return Density.super.m5965toDpSizekrfVVM($receiver);
        }
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    float m5967toPx0680j_4(float $this$toPx_u2d0680j_4) {
        return getDensity() * $this$toPx_u2d0680j_4;
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    int m5961roundToPx0680j_4(float $this$roundToPx_u2d0680j_4) {
        float px = m5967toPx0680j_4($this$roundToPx_u2d0680j_4);
        if (Float.isInfinite(px)) {
            return Integer.MAX_VALUE;
        }
        return MathKt.roundToInt(px);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    long m5969toSp0xMU5do(float $this$toSp_u2d0xMU5do) {
        return TextUnitKt.getSp($this$toSp_u2d0xMU5do / getFontScale());
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    float m5966toPxR2X_6o(long $this$toPx_u2d_u2dR2X_6o) {
        if (TextUnitType.m6195equalsimpl0(TextUnit.m6166getTypeUIouoOA($this$toPx_u2d_u2dR2X_6o), TextUnitType.Companion.m6200getSpUIouoOA())) {
            return TextUnit.m6167getValueimpl($this$toPx_u2d_u2dR2X_6o) * getFontScale() * getDensity();
        }
        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    int m5960roundToPxR2X_6o(long $this$roundToPx_u2d_u2dR2X_6o) {
        return MathKt.roundToInt(m5966toPxR2X_6o($this$roundToPx_u2d_u2dR2X_6o));
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    float m5962toDpGaN1DYA(long $this$toDp_u2dGaN1DYA) {
        if (TextUnitType.m6195equalsimpl0(TextUnit.m6166getTypeUIouoOA($this$toDp_u2dGaN1DYA), TextUnitType.Companion.m6200getSpUIouoOA())) {
            return Dp.m5986constructorimpl(TextUnit.m6167getValueimpl($this$toDp_u2dGaN1DYA) * getFontScale());
        }
        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    float m5964toDpu2uoSUM(int $this$toDp_u2du2uoSUM) {
        return Dp.m5986constructorimpl(((float) $this$toDp_u2du2uoSUM) / getDensity());
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    long m5971toSpkPz2Gy4(int $this$toSp_u2dkPz2Gy4) {
        return TextUnitKt.getSp(((float) $this$toSp_u2dkPz2Gy4) / (getFontScale() * getDensity()));
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    float m5963toDpu2uoSUM(float $this$toDp_u2du2uoSUM) {
        return Dp.m5986constructorimpl($this$toDp_u2du2uoSUM / getDensity());
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    long m5970toSpkPz2Gy4(float $this$toSp_u2dkPz2Gy4) {
        return TextUnitKt.getSp($this$toSp_u2dkPz2Gy4 / (getFontScale() * getDensity()));
    }

    Rect toRect(DpRect $this$toRect) {
        Intrinsics.checkNotNullParameter($this$toRect, "<this>");
        return new Rect(m5967toPx0680j_4($this$toRect.m6069getLeftD9Ej5fM()), m5967toPx0680j_4($this$toRect.m6071getTopD9Ej5fM()), m5967toPx0680j_4($this$toRect.m6070getRightD9Ej5fM()), m5967toPx0680j_4($this$toRect.m6068getBottomD9Ej5fM()));
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    long m5968toSizeXkaWNTQ(long $this$toSize_u2dXkaWNTQ) {
        if ($this$toSize_u2dXkaWNTQ != DpSize.Companion.m6093getUnspecifiedMYxV2XQ()) {
            return SizeKt.Size(m5967toPx0680j_4(DpSize.m6084getWidthD9Ej5fM($this$toSize_u2dXkaWNTQ)), m5967toPx0680j_4(DpSize.m6082getHeightD9Ej5fM($this$toSize_u2dXkaWNTQ)));
        }
        return Size.Companion.m2992getUnspecifiedNHjbRc();
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    long m5965toDpSizekrfVVM(long $this$toDpSize_u2dk_u2drfVVM) {
        if ($this$toDpSize_u2dk_u2drfVVM != Size.Companion.m2992getUnspecifiedNHjbRc()) {
            return DpKt.m6008DpSizeYgX7TsA(m5963toDpu2uoSUM(Size.m2984getWidthimpl($this$toDpSize_u2dk_u2drfVVM)), m5963toDpu2uoSUM(Size.m2981getHeightimpl($this$toDpSize_u2dk_u2drfVVM)));
        }
        return DpSize.Companion.m6093getUnspecifiedMYxV2XQ();
    }
}
