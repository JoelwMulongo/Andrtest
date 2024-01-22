package androidx.compose.foundation;

import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.BorderKt$border-ziNgDLE$$inlined$debugInspectorInfo$1  reason: invalid class name */
/* compiled from: InspectableValue.kt */
public final class BorderKt$borderziNgDLE$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ Brush $brush$inlined;
    final /* synthetic */ Shape $shape$inlined;
    final /* synthetic */ float $width$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BorderKt$borderziNgDLE$$inlined$debugInspectorInfo$1(float f, Brush brush, Shape shape) {
        super(1);
        this.$width$inlined = f;
        this.$brush$inlined = brush;
        this.$shape$inlined = shape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((InspectorInfo) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo $this$null) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        InspectorInfo $this$border_ziNgDLE_u24lambda_u240 = $this$null;
        $this$border_ziNgDLE_u24lambda_u240.setName(OutlinedTextFieldKt.BorderId);
        $this$border_ziNgDLE_u24lambda_u240.getProperties().set("width", Dp.m5984boximpl(this.$width$inlined));
        if (this.$brush$inlined instanceof SolidColor) {
            $this$border_ziNgDLE_u24lambda_u240.getProperties().set("color", Color.m3154boximpl(((SolidColor) this.$brush$inlined).m3529getValue0d7_KjU()));
            $this$border_ziNgDLE_u24lambda_u240.setValue(Color.m3154boximpl(((SolidColor) this.$brush$inlined).m3529getValue0d7_KjU()));
        } else {
            $this$border_ziNgDLE_u24lambda_u240.getProperties().set("brush", this.$brush$inlined);
        }
        $this$border_ziNgDLE_u24lambda_u240.getProperties().set("shape", this.$shape$inlined);
    }
}
