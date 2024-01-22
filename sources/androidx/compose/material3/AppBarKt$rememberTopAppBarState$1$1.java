package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$rememberTopAppBarState$1$1 extends Lambda implements Function0<TopAppBarState> {
    final /* synthetic */ float $initialContentOffset;
    final /* synthetic */ float $initialHeightOffset;
    final /* synthetic */ float $initialHeightOffsetLimit;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$rememberTopAppBarState$1$1(float f, float f2, float f3) {
        super(0);
        this.$initialHeightOffsetLimit = f;
        this.$initialHeightOffset = f2;
        this.$initialContentOffset = f3;
    }

    public final TopAppBarState invoke() {
        return new TopAppBarState(this.$initialHeightOffsetLimit, this.$initialHeightOffset, this.$initialContentOffset);
    }
}
