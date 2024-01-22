package androidx.compose.material;

import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1$2$1 extends Lambda implements Function2<BottomSheetValue, IntSize, Float> {
    final /* synthetic */ int $layoutHeight;
    final /* synthetic */ float $peekHeightPx;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BottomSheetScaffold.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BottomSheetValue.values().length];
            try {
                iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[BottomSheetValue.Expanded.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1$2$1(int i, float f) {
        super(2);
        this.$layoutHeight = i;
        this.$peekHeightPx = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m1404invokeO0kMr_c((BottomSheetValue) p1, ((IntSize) p2).m6150unboximpl());
    }

    /* renamed from: invoke-O0kMr_c  reason: not valid java name */
    public final Float m1404invokeO0kMr_c(BottomSheetValue state, long sheetSize) {
        Intrinsics.checkNotNullParameter(state, "state");
        switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
            case 1:
                return Float.valueOf(((float) this.$layoutHeight) - this.$peekHeightPx);
            case 2:
                if (IntSize.m6145getHeightimpl(sheetSize) == MathKt.roundToInt(this.$peekHeightPx)) {
                    return null;
                }
                return Float.valueOf(((float) this.$layoutHeight) - ((float) IntSize.m6145getHeightimpl(sheetSize)));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
