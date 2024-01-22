package androidx.compose.material.pullrefresh;

import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullRefreshIndicatorTransform.kt */
final class PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    public static final PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2$1 INSTANCE = new PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2$1();

    PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((ContentDrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope $this$drawWithContent) {
        ContentDrawScope $this$clipRect_u2drOu3jXo_u24default$iv = $this$drawWithContent;
        Intrinsics.checkNotNullParameter($this$clipRect_u2drOu3jXo_u24default$iv, "$this$drawWithContent");
        int clipOp$iv = ClipOp.Companion.m3153getIntersectrtfAjoo();
        DrawScope $this$withTransform$iv$iv = $this$clipRect_u2drOu3jXo_u24default$iv;
        DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform$iv$iv.getDrawContext();
        long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
        $this$withTransform_u24lambda_u246$iv$iv.getTransform().m3827clipRectN_I0leg(-3.4028235E38f, 0.0f, Float.MAX_VALUE, Float.MAX_VALUE, clipOp$iv);
        DrawScope drawScope = $this$withTransform$iv$iv;
        $this$drawWithContent.drawContent();
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv$iv.m3716setSizeuvyYCjk(previousSize$iv$iv);
    }
}
