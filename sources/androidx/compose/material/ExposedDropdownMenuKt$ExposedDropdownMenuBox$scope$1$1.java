package androidx.compose.material;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
public final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 implements ExposedDropdownMenuBoxScope {
    final /* synthetic */ Density $density;
    final /* synthetic */ MutableState<Integer> $menuHeight$delegate;
    final /* synthetic */ MutableState<Integer> $width$delegate;

    ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1(Density $density2, MutableState<Integer> $menuHeight$delegate2, MutableState<Integer> $width$delegate2) {
        this.$density = $density2;
        this.$menuHeight$delegate = $menuHeight$delegate2;
        this.$width$delegate = $width$delegate2;
    }

    public Modifier exposedDropdownSize(Modifier $this$exposedDropdownSize, boolean matchTextFieldWidth) {
        Intrinsics.checkNotNullParameter($this$exposedDropdownSize, "<this>");
        Density $this$exposedDropdownSize_u24lambda_u241 = this.$density;
        MutableState<Integer> mutableState = this.$menuHeight$delegate;
        MutableState<Integer> mutableState2 = this.$width$delegate;
        Modifier it = SizeKt.m818heightInVpY3zN4$default($this$exposedDropdownSize, 0.0f, $this$exposedDropdownSize_u24lambda_u241.m5964toDpu2uoSUM(ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$4(mutableState)), 1, (Object) null);
        if (matchTextFieldWidth) {
            return SizeKt.m835width3ABfNKs(it, $this$exposedDropdownSize_u24lambda_u241.m5964toDpu2uoSUM(ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$1(mutableState2)));
        }
        return it;
    }
}
