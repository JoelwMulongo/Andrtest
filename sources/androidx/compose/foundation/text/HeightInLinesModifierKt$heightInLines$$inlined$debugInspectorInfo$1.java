package androidx.compose.foundation.text;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: InspectableValue.kt */
public final class HeightInLinesModifierKt$heightInLines$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ int $maxLines$inlined;
    final /* synthetic */ int $minLines$inlined;
    final /* synthetic */ TextStyle $textStyle$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeightInLinesModifierKt$heightInLines$$inlined$debugInspectorInfo$1(int i, int i2, TextStyle textStyle) {
        super(1);
        this.$minLines$inlined = i;
        this.$maxLines$inlined = i2;
        this.$textStyle$inlined = textStyle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((InspectorInfo) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo $this$null) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        InspectorInfo $this$heightInLines_u24lambda_u240 = $this$null;
        $this$heightInLines_u24lambda_u240.setName("heightInLines");
        $this$heightInLines_u24lambda_u240.getProperties().set("minLines", Integer.valueOf(this.$minLines$inlined));
        $this$heightInLines_u24lambda_u240.getProperties().set("maxLines", Integer.valueOf(this.$maxLines$inlined));
        $this$heightInLines_u24lambda_u240.getProperties().set("textStyle", this.$textStyle$inlined);
    }
}
