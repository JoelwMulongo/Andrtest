package androidx.compose.foundation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Magnifier.kt */
final class MagnifierKt$magnifier$4$sourceCenterInRoot$2$1 extends Lambda implements Function0<Offset> {
    final /* synthetic */ MutableState<Offset> $anchorPositionInRoot$delegate;
    final /* synthetic */ Density $density;
    final /* synthetic */ State<Function1<Density, Offset>> $updatedSourceCenter$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MagnifierKt$magnifier$4$sourceCenterInRoot$2$1(Density density, State<? extends Function1<? super Density, Offset>> state, MutableState<Offset> mutableState) {
        super(0);
        this.$density = density;
        this.$updatedSourceCenter$delegate = state;
        this.$anchorPositionInRoot$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Offset.m2904boximpl(m497invokeF1C5BW0());
    }

    /* renamed from: invoke-F1C5BW0  reason: not valid java name */
    public final long m497invokeF1C5BW0() {
        long sourceCenterOffset = ((Offset) MagnifierKt$magnifier$4.invoke$lambda$3(this.$updatedSourceCenter$delegate).invoke(this.$density)).m2925unboximpl();
        if (!OffsetKt.m2934isSpecifiedk4lQ0M(MagnifierKt$magnifier$4.invoke$lambda$1(this.$anchorPositionInRoot$delegate)) || !OffsetKt.m2934isSpecifiedk4lQ0M(sourceCenterOffset)) {
            return Offset.Companion.m2930getUnspecifiedF1C5BW0();
        }
        return Offset.m2920plusMKHz9U(MagnifierKt$magnifier$4.invoke$lambda$1(this.$anchorPositionInRoot$delegate), sourceCenterOffset);
    }
}
