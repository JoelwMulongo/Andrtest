package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.MagnifierKt;
import androidx.compose.foundation.MagnifierStyle;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.android.kt */
final class TextFieldSelectionManager_androidKt$textFieldMagnifier$1$2$1 extends Lambda implements Function1<Function0<? extends Offset>, Modifier> {
    final /* synthetic */ Density $density;
    final /* synthetic */ MutableState<IntSize> $magnifierSize$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionManager_androidKt$textFieldMagnifier$1$2$1(Density density, MutableState<IntSize> mutableState) {
        super(1);
        this.$density = density;
        this.$magnifierSize$delegate = mutableState;
    }

    public final Modifier invoke(final Function0<Offset> center) {
        Intrinsics.checkNotNullParameter(center, "center");
        Modifier.Companion companion = Modifier.Companion;
        MagnifierStyle textDefault = MagnifierStyle.Companion.getTextDefault();
        final Density density = this.$density;
        final MutableState<IntSize> mutableState = this.$magnifierSize$delegate;
        return MagnifierKt.magnifier$default(companion, new Function1<Density, Offset>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return Offset.m2904boximpl(m1355invoketuRUvjQ((Density) p1));
            }

            /* renamed from: invoke-tuRUvjQ  reason: not valid java name */
            public final long m1355invoketuRUvjQ(Density $this$magnifier) {
                Intrinsics.checkNotNullParameter($this$magnifier, "$this$magnifier");
                return center.invoke().m2925unboximpl();
            }
        }, (Function1) null, 0.0f, textDefault, new Function1<DpSize, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                m1356invokeEaSLcWc(((DpSize) p1).m6092unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-EaSLcWc  reason: not valid java name */
            public final void m1356invokeEaSLcWc(long size) {
                MutableState<IntSize> mutableState = mutableState;
                Density $this$invoke_EaSLcWc_u24lambda_u240 = density;
                TextFieldSelectionManager_androidKt$textFieldMagnifier$1.invoke$lambda$2(mutableState, IntSizeKt.IntSize($this$invoke_EaSLcWc_u24lambda_u240.m5961roundToPx0680j_4(DpSize.m6084getWidthD9Ej5fM(size)), $this$invoke_EaSLcWc_u24lambda_u240.m5961roundToPx0680j_4(DpSize.m6082getHeightD9Ej5fM(size))));
            }
        }, 6, (Object) null);
    }
}
