package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: OutlinedTextField.kt */
final class OutlinedTextFieldKt$outlineCutout$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ long $labelSize;
    final /* synthetic */ PaddingValues $paddingValues;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OutlinedTextField.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Rtl.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutlinedTextFieldKt$outlineCutout$1(long j, PaddingValues paddingValues) {
        super(1);
        this.$labelSize = j;
        this.$paddingValues = paddingValues;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((ContentDrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope $this$drawWithContent) {
        float left;
        float right;
        ContentDrawScope $this$clipRect_u2drOu3jXo$iv = $this$drawWithContent;
        Intrinsics.checkNotNullParameter($this$clipRect_u2drOu3jXo$iv, "$this$drawWithContent");
        float labelWidth = Size.m2984getWidthimpl(this.$labelSize);
        if (labelWidth > 0.0f) {
            float innerPadding = $this$clipRect_u2drOu3jXo$iv.m5967toPx0680j_4(OutlinedTextFieldKt.OutlinedTextFieldInnerPadding);
            float leftLtr = $this$clipRect_u2drOu3jXo$iv.m5967toPx0680j_4(this.$paddingValues.m771calculateLeftPaddingu2uoSUM($this$drawWithContent.getLayoutDirection())) - innerPadding;
            float f = (float) 2;
            float rightLtr = leftLtr + labelWidth + (f * innerPadding);
            if (WhenMappings.$EnumSwitchMapping$0[$this$drawWithContent.getLayoutDirection().ordinal()] == 1) {
                left = Size.m2984getWidthimpl($this$drawWithContent.m3772getSizeNHjbRc()) - rightLtr;
            } else {
                left = RangesKt.coerceAtLeast(leftLtr, 0.0f);
            }
            if (WhenMappings.$EnumSwitchMapping$0[$this$drawWithContent.getLayoutDirection().ordinal()] == 1) {
                right = Size.m2984getWidthimpl($this$drawWithContent.m3772getSizeNHjbRc()) - RangesKt.coerceAtLeast(leftLtr, 0.0f);
            } else {
                right = rightLtr;
            }
            float labelHeight = Size.m2981getHeightimpl(this.$labelSize);
            int clipOp$iv = ClipOp.Companion.m3152getDifferencertfAjoo();
            DrawScope $this$withTransform$iv$iv = $this$clipRect_u2drOu3jXo$iv;
            DrawContext $this$withTransform_u24lambda_u2d6$iv$iv = $this$withTransform$iv$iv.getDrawContext();
            long previousSize$iv$iv = $this$withTransform_u24lambda_u2d6$iv$iv.m3715getSizeNHjbRc();
            $this$withTransform_u24lambda_u2d6$iv$iv.getCanvas().save();
            DrawContext $this$withTransform_u24lambda_u2d6$iv$iv2 = $this$withTransform_u24lambda_u2d6$iv$iv;
            $this$withTransform_u24lambda_u2d6$iv$iv.getTransform().m3827clipRectN_I0leg(left, (-labelHeight) / f, right, labelHeight / f, clipOp$iv);
            DrawScope drawScope = $this$withTransform$iv$iv;
            $this$drawWithContent.drawContent();
            $this$withTransform_u24lambda_u2d6$iv$iv2.getCanvas().restore();
            $this$withTransform_u24lambda_u2d6$iv$iv2.m3716setSizeuvyYCjk(previousSize$iv$iv);
            return;
        }
        $this$drawWithContent.drawContent();
    }
}
