package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $body;
    final /* synthetic */ Function3<Integer, Composer, Integer, Unit> $bottomSheet;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ Function0<Float> $sheetOffset;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ BottomSheetState $sheetState;
    final /* synthetic */ Function2<Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

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
    BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(Function0<Float> function0, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i, float f, Function2<? super Composer, ? super Integer, Unit> function23, BottomSheetState bottomSheetState, Function3<? super Integer, ? super Composer, ? super Integer, Unit> function3, int i2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32) {
        super(2);
        this.$sheetOffset = function0;
        this.$topBar = function2;
        this.$floatingActionButton = function22;
        this.$floatingActionButtonPosition = i;
        this.$sheetPeekHeight = f;
        this.$snackbarHost = function23;
        this.$sheetState = bottomSheetState;
        this.$bottomSheet = function3;
        this.$$dirty = i2;
        this.$body = function32;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m1405invoke0kLqBqw((SubcomposeMeasureScope) p1, ((Constraints) p2).m5936unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m1405invoke0kLqBqw(SubcomposeMeasureScope $this$SubcomposeLayout, long constraints) {
        Placeable placeable;
        Placeable placeable2;
        final int fabOffsetX;
        int i;
        final int snackbarOffsetY;
        SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
        int layoutWidth = Constraints.m5930getMaxWidthimpl(constraints);
        int layoutHeight = Constraints.m5929getMaxHeightimpl(constraints);
        long looseConstraints = Constraints.m5921copyZbe2FdA$default(constraints, 0, 0, 0, 0, 10, (Object) null);
        final Placeable sheetPlaceable = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Sheet, ComposableLambdaKt.composableLambdaInstance(-2120029209, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$sheetPlaceable$1(this.$bottomSheet, layoutHeight, this.$$dirty))).get(0).m4863measureBRTryo0(looseConstraints);
        int sheetOffsetY = MathKt.roundToInt(this.$sheetOffset.invoke().floatValue());
        Function2<Composer, Integer, Unit> function2 = this.$topBar;
        if (function2 != null) {
            Function2<Composer, Integer, Unit> function22 = function2;
            placeable = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.TopBar, ComposableLambdaKt.composableLambdaInstance(1477114206, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$topBarPlaceable$1$1(function2, this.$$dirty))).get(0).m4863measureBRTryo0(looseConstraints);
        } else {
            placeable = null;
        }
        Placeable topBarPlaceable = placeable;
        int topBarHeight = topBarPlaceable != null ? topBarPlaceable.getHeight() : 0;
        long bodyConstraints = Constraints.m5921copyZbe2FdA$default(looseConstraints, 0, 0, 0, layoutHeight - topBarHeight, 7, (Object) null);
        final Placeable bodyPlaceable = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Body, ComposableLambdaKt.composableLambdaInstance(2078633916, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$bodyPlaceable$1(this.$body, this.$sheetPeekHeight, this.$$dirty))).get(0).m4863measureBRTryo0(bodyConstraints);
        Function2 fab = this.$floatingActionButton;
        if (fab != null) {
            placeable2 = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Fab, fab).get(0).m4863measureBRTryo0(looseConstraints);
        } else {
            placeable2 = null;
        }
        Placeable fabPlaceable = placeable2;
        int fabWidth = fabPlaceable != null ? fabPlaceable.getWidth() : 0;
        int fabHeight = fabPlaceable != null ? fabPlaceable.getHeight() : 0;
        if (FabPosition.m1513equalsimpl0(this.$floatingActionButtonPosition, FabPosition.Companion.m1517getCenter5ygKITE())) {
            fabOffsetX = (layoutWidth - fabWidth) / 2;
        } else {
            fabOffsetX = (layoutWidth - fabWidth) - subcomposeMeasureScope.m5961roundToPx0680j_4(BottomSheetScaffoldKt.FabSpacing);
        }
        if (subcomposeMeasureScope.m5967toPx0680j_4(this.$sheetPeekHeight) < ((float) (fabHeight / 2))) {
            i = (sheetOffsetY - fabHeight) - subcomposeMeasureScope.m5961roundToPx0680j_4(BottomSheetScaffoldKt.FabSpacing);
        } else {
            i = sheetOffsetY - (fabHeight / 2);
        }
        int fabOffsetY = i;
        final Placeable snackbarPlaceable = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Snackbar, this.$snackbarHost).get(0).m4863measureBRTryo0(looseConstraints);
        int snackbarOffsetX = (layoutWidth - snackbarPlaceable.getWidth()) / 2;
        switch (WhenMappings.$EnumSwitchMapping$0[this.$sheetState.getCurrentValue().ordinal()]) {
            case 1:
                snackbarOffsetY = fabOffsetY - snackbarPlaceable.getHeight();
                break;
            case 2:
                snackbarOffsetY = layoutHeight - snackbarPlaceable.getHeight();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        final int i2 = topBarHeight;
        final Placeable placeable3 = topBarPlaceable;
        final int i3 = sheetOffsetY;
        final Placeable placeable4 = fabPlaceable;
        final int i4 = fabOffsetY;
        final int i5 = snackbarOffsetX;
        long j = bodyConstraints;
        return MeasureScope.layout$default(subcomposeMeasureScope, layoutWidth, layoutHeight, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((Placeable.PlacementScope) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope $this$layout) {
                Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
                Placeable.PlacementScope.placeRelative$default($this$layout, bodyPlaceable, 0, i2, 0.0f, 4, (Object) null);
                Placeable placeable = placeable3;
                if (placeable != null) {
                    Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, 0, 0.0f, 4, (Object) null);
                }
                Placeable.PlacementScope.placeRelative$default($this$layout, sheetPlaceable, 0, i3, 0.0f, 4, (Object) null);
                Placeable placeable2 = placeable4;
                if (placeable2 != null) {
                    Placeable.PlacementScope.placeRelative$default($this$layout, placeable2, fabOffsetX, i4, 0.0f, 4, (Object) null);
                }
                Placeable.PlacementScope.placeRelative$default($this$layout, snackbarPlaceable, i5, snackbarOffsetY, 0.0f, 4, (Object) null);
            }
        }, 4, (Object) null);
    }
}
