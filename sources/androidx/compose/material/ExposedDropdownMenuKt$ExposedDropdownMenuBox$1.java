package androidx.compose.material;

import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ Ref<LayoutCoordinates> $coordinates;
    final /* synthetic */ MutableState<Integer> $menuHeight$delegate;
    final /* synthetic */ int $verticalMarginInPx;
    final /* synthetic */ View $view;
    final /* synthetic */ MutableState<Integer> $width$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenuKt$ExposedDropdownMenuBox$1(Ref<LayoutCoordinates> ref, View view, int i, MutableState<Integer> mutableState, MutableState<Integer> mutableState2) {
        super(1);
        this.$coordinates = ref;
        this.$view = view;
        this.$verticalMarginInPx = i;
        this.$width$delegate = mutableState;
        this.$menuHeight$delegate = mutableState2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((LayoutCoordinates) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$2(this.$width$delegate, IntSize.m6146getWidthimpl(it.m4839getSizeYbymL2g()));
        this.$coordinates.setValue(it);
        View rootView = this.$view.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
        int i = this.$verticalMarginInPx;
        final MutableState<Integer> mutableState = this.$menuHeight$delegate;
        ExposedDropdownMenuKt.updateHeight(rootView, this.$coordinates.getValue(), i, new Function1<Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke(((Number) p1).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int newHeight) {
                ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$5(mutableState, newHeight);
            }
        });
    }
}
