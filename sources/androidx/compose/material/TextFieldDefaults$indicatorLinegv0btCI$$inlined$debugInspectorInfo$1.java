package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.material.TextFieldDefaults$indicatorLine-gv0btCI$$inlined$debugInspectorInfo$1  reason: invalid class name */
/* compiled from: InspectableValue.kt */
public final class TextFieldDefaults$indicatorLinegv0btCI$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ TextFieldColors $colors$inlined;
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ float $focusedIndicatorLineThickness$inlined;
    final /* synthetic */ InteractionSource $interactionSource$inlined;
    final /* synthetic */ boolean $isError$inlined;
    final /* synthetic */ float $unfocusedIndicatorLineThickness$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldDefaults$indicatorLinegv0btCI$$inlined$debugInspectorInfo$1(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2) {
        super(1);
        this.$enabled$inlined = z;
        this.$isError$inlined = z2;
        this.$interactionSource$inlined = interactionSource;
        this.$colors$inlined = textFieldColors;
        this.$focusedIndicatorLineThickness$inlined = f;
        this.$unfocusedIndicatorLineThickness$inlined = f2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((InspectorInfo) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo $this$null) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        InspectorInfo $this$indicatorLine_gv0btCI_u24lambda_u240 = $this$null;
        $this$indicatorLine_gv0btCI_u24lambda_u240.setName("indicatorLine");
        $this$indicatorLine_gv0btCI_u24lambda_u240.getProperties().set("enabled", Boolean.valueOf(this.$enabled$inlined));
        $this$indicatorLine_gv0btCI_u24lambda_u240.getProperties().set("isError", Boolean.valueOf(this.$isError$inlined));
        $this$indicatorLine_gv0btCI_u24lambda_u240.getProperties().set("interactionSource", this.$interactionSource$inlined);
        $this$indicatorLine_gv0btCI_u24lambda_u240.getProperties().set("colors", this.$colors$inlined);
        $this$indicatorLine_gv0btCI_u24lambda_u240.getProperties().set("focusedIndicatorLineThickness", Dp.m5984boximpl(this.$focusedIndicatorLineThickness$inlined));
        $this$indicatorLine_gv0btCI_u24lambda_u240.getProperties().set("unfocusedIndicatorLineThickness", Dp.m5984boximpl(this.$unfocusedIndicatorLineThickness$inlined));
    }
}
