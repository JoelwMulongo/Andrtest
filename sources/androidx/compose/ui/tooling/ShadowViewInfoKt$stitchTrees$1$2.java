package androidx.compose.ui.tooling;

import androidx.compose.ui.layout.LayoutInfo;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "Landroidx/compose/ui/layout/LayoutInfo;", "Landroidx/compose/ui/tooling/ShadowViewInfo;", "invoke", "(Lkotlin/Pair;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ShadowViewInfo.kt */
final class ShadowViewInfoKt$stitchTrees$1$2 extends Lambda implements Function1<Pair<? extends LayoutInfo, ? extends ShadowViewInfo>, Boolean> {
    final /* synthetic */ ShadowViewInfo $rootToAttach;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShadowViewInfoKt$stitchTrees$1$2(ShadowViewInfo shadowViewInfo) {
        super(1);
        this.$rootToAttach = shadowViewInfo;
    }

    public final Boolean invoke(Pair<? extends LayoutInfo, ShadowViewInfo> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(!Intrinsics.areEqual((Object) it.getSecond().findRoot(), (Object) this.$rootToAttach));
    }
}
