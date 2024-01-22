package androidx.compose.material;

import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Drawer.kt */
final class DrawerKt$ModalDrawer$1$1$1 extends Lambda implements Function2<DrawerValue, IntSize, Float> {
    final /* synthetic */ float $maxValue;
    final /* synthetic */ float $minValue;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Drawer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DrawerValue.values().length];
            try {
                iArr[DrawerValue.Closed.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DrawerValue.Open.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerKt$ModalDrawer$1$1$1(float f, float f2) {
        super(2);
        this.$minValue = f;
        this.$maxValue = f2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m1494invokeO0kMr_c((DrawerValue) p1, ((IntSize) p2).m6150unboximpl());
    }

    /* renamed from: invoke-O0kMr_c  reason: not valid java name */
    public final Float m1494invokeO0kMr_c(DrawerValue value, long j) {
        Intrinsics.checkNotNullParameter(value, "value");
        switch (WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
            case 1:
                return Float.valueOf(this.$minValue);
            case 2:
                return Float.valueOf(this.$maxValue);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
