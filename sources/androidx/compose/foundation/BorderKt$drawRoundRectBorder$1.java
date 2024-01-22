package androidx.compose.foundation;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Border.kt */
final class BorderKt$drawRoundRectBorder$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ long $borderSize;
    final /* synthetic */ Stroke $borderStroke;
    final /* synthetic */ Brush $brush;
    final /* synthetic */ long $cornerRadius;
    final /* synthetic */ boolean $fillArea;
    final /* synthetic */ float $halfStroke;
    final /* synthetic */ float $strokeWidth;
    final /* synthetic */ long $topLeft;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BorderKt$drawRoundRectBorder$1(boolean z, Brush brush, long j, float f, float f2, long j2, long j3, Stroke stroke) {
        super(1);
        this.$fillArea = z;
        this.$brush = brush;
        this.$cornerRadius = j;
        this.$halfStroke = f;
        this.$strokeWidth = f2;
        this.$topLeft = j2;
        this.$borderSize = j3;
        this.$borderStroke = stroke;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((ContentDrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope $this$onDrawWithContent) {
        ContentDrawScope contentDrawScope = $this$onDrawWithContent;
        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
        $this$onDrawWithContent.drawContent();
        if (this.$fillArea) {
            DrawScope.m3749drawRoundRectZuiqVtQ$default(contentDrawScope, this.$brush, 0, 0, this.$cornerRadius, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 246, (Object) null);
            return;
        }
        float r2 = CornerRadius.m2890getXimpl(this.$cornerRadius);
        float f = this.$halfStroke;
        if (r2 < f) {
            DrawScope $this$clipRect_u2drOu3jXo$iv = contentDrawScope;
            float left$iv = this.$strokeWidth;
            float right$iv = Size.m2984getWidthimpl($this$onDrawWithContent.m3772getSizeNHjbRc()) - this.$strokeWidth;
            float bottom$iv = Size.m2981getHeightimpl($this$onDrawWithContent.m3772getSizeNHjbRc()) - this.$strokeWidth;
            int clipOp$iv = ClipOp.Companion.m3152getDifferencertfAjoo();
            Brush brush = this.$brush;
            long j = this.$cornerRadius;
            DrawScope $this$withTransform$iv$iv = $this$clipRect_u2drOu3jXo$iv;
            DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform$iv$iv.getDrawContext();
            long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.m3715getSizeNHjbRc();
            $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
            $this$withTransform_u24lambda_u246$iv$iv.getTransform().m3827clipRectN_I0leg(left$iv, left$iv, right$iv, bottom$iv, clipOp$iv);
            DrawScope drawScope = $this$clipRect_u2drOu3jXo$iv;
            DrawContext $this$withTransform_u24lambda_u246$iv$iv2 = $this$withTransform_u24lambda_u246$iv$iv;
            DrawScope.m3749drawRoundRectZuiqVtQ$default($this$withTransform$iv$iv, brush, 0, 0, j, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 246, (Object) null);
            $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv$iv2.m3716setSizeuvyYCjk(previousSize$iv$iv);
            return;
        }
        Brush brush2 = this.$brush;
        long j2 = this.$topLeft;
        DrawScope.m3749drawRoundRectZuiqVtQ$default(contentDrawScope, brush2, j2, this.$borderSize, BorderKt.m464shrinkKibmq7A(this.$cornerRadius, f), 0.0f, this.$borderStroke, (ColorFilter) null, 0, 208, (Object) null);
    }
}
