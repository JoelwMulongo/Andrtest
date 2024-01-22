package androidx.compose.material3;

import android.view.View;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
public final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 implements ExposedDropdownMenuBoxScope {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Ref<LayoutCoordinates> $coordinates;
    final /* synthetic */ Density $density;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ MutableState<Integer> $menuHeight$delegate;
    final /* synthetic */ Function1<Boolean, Unit> $onExpandedChange;
    final /* synthetic */ int $verticalMarginInPx;
    final /* synthetic */ View $view;
    final /* synthetic */ MutableState<Integer> $width$delegate;

    ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1(boolean $expanded2, Function1<? super Boolean, Unit> $onExpandedChange2, int $$dirty2, FocusRequester $focusRequester2, Ref<LayoutCoordinates> $coordinates2, View $view2, int $verticalMarginInPx2, MutableState<Integer> $width$delegate2, MutableState<Integer> $menuHeight$delegate2, Density $density2) {
        this.$expanded = $expanded2;
        this.$onExpandedChange = $onExpandedChange2;
        this.$$dirty = $$dirty2;
        this.$focusRequester = $focusRequester2;
        this.$coordinates = $coordinates2;
        this.$view = $view2;
        this.$verticalMarginInPx = $verticalMarginInPx2;
        this.$width$delegate = $width$delegate2;
        this.$menuHeight$delegate = $menuHeight$delegate2;
        this.$density = $density2;
    }

    public Modifier menuAnchor(Modifier $this$menuAnchor) {
        Intrinsics.checkNotNullParameter($this$menuAnchor, "<this>");
        return ComposedModifierKt.composed($this$menuAnchor, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2(this.$expanded, this.$onExpandedChange, this.$$dirty, this.$focusRequester, this.$coordinates, this.$view, this.$verticalMarginInPx, this.$width$delegate, this.$menuHeight$delegate));
    }

    public Modifier exposedDropdownSize(Modifier $this$exposedDropdownSize, boolean matchTextFieldWidth) {
        Intrinsics.checkNotNullParameter($this$exposedDropdownSize, "<this>");
        Density $this$exposedDropdownSize_u24lambda_u2d2 = this.$density;
        MutableState<Integer> mutableState = this.$menuHeight$delegate;
        MutableState<Integer> mutableState2 = this.$width$delegate;
        Modifier it = SizeKt.m818heightInVpY3zN4$default($this$exposedDropdownSize, 0.0f, $this$exposedDropdownSize_u24lambda_u2d2.m5964toDpu2uoSUM(ExposedDropdownMenuKt.m1916ExposedDropdownMenuBox$lambda4(mutableState)), 1, (Object) null);
        if (matchTextFieldWidth) {
            return SizeKt.m835width3ABfNKs(it, $this$exposedDropdownSize_u24lambda_u2d2.m5964toDpu2uoSUM(ExposedDropdownMenuKt.m1914ExposedDropdownMenuBox$lambda1(mutableState2)));
        }
        return it;
    }
}
