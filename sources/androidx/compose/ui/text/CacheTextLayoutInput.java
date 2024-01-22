package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Landroidx/compose/ui/text/CacheTextLayoutInput;", "", "textLayoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "(Landroidx/compose/ui/text/TextLayoutInput;)V", "getTextLayoutInput", "()Landroidx/compose/ui/text/TextLayoutInput;", "equals", "", "other", "hashCode", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextMeasurer.kt */
public final class CacheTextLayoutInput {
    private final TextLayoutInput textLayoutInput;

    public CacheTextLayoutInput(TextLayoutInput textLayoutInput2) {
        Intrinsics.checkNotNullParameter(textLayoutInput2, "textLayoutInput");
        this.textLayoutInput = textLayoutInput2;
    }

    public final TextLayoutInput getTextLayoutInput() {
        return this.textLayoutInput;
    }

    public int hashCode() {
        TextLayoutInput $this$hashCode_u24lambda_u240 = this.textLayoutInput;
        return ((((((((((((((((((($this$hashCode_u24lambda_u240.getText().hashCode() * 31) + $this$hashCode_u24lambda_u240.getStyle().hashCodeLayoutAffectingAttributes$ui_text_release()) * 31) + $this$hashCode_u24lambda_u240.getPlaceholders().hashCode()) * 31) + $this$hashCode_u24lambda_u240.getMaxLines()) * 31) + Boolean.hashCode($this$hashCode_u24lambda_u240.getSoftWrap())) * 31) + TextOverflow.m5892hashCodeimpl($this$hashCode_u24lambda_u240.m5443getOverflowgIe3tQ8())) * 31) + $this$hashCode_u24lambda_u240.getDensity().hashCode()) * 31) + $this$hashCode_u24lambda_u240.getLayoutDirection().hashCode()) * 31) + $this$hashCode_u24lambda_u240.getFontFamilyResolver().hashCode()) * 31) + Integer.hashCode(Constraints.m5930getMaxWidthimpl($this$hashCode_u24lambda_u240.m5442getConstraintsmsEJaDk()))) * 31) + Integer.hashCode(Constraints.m5929getMaxHeightimpl($this$hashCode_u24lambda_u240.m5442getConstraintsmsEJaDk()));
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CacheTextLayoutInput)) {
            return false;
        }
        TextLayoutInput $this$equals_u24lambda_u241 = this.textLayoutInput;
        if (Intrinsics.areEqual((Object) $this$equals_u24lambda_u241.getText(), (Object) ((CacheTextLayoutInput) other).textLayoutInput.getText()) && $this$equals_u24lambda_u241.getStyle().hasSameLayoutAffectingAttributes(((CacheTextLayoutInput) other).textLayoutInput.getStyle()) && Intrinsics.areEqual((Object) $this$equals_u24lambda_u241.getPlaceholders(), (Object) ((CacheTextLayoutInput) other).textLayoutInput.getPlaceholders()) && $this$equals_u24lambda_u241.getMaxLines() == ((CacheTextLayoutInput) other).textLayoutInput.getMaxLines() && $this$equals_u24lambda_u241.getSoftWrap() == ((CacheTextLayoutInput) other).textLayoutInput.getSoftWrap() && TextOverflow.m5891equalsimpl0($this$equals_u24lambda_u241.m5443getOverflowgIe3tQ8(), ((CacheTextLayoutInput) other).textLayoutInput.m5443getOverflowgIe3tQ8()) && Intrinsics.areEqual((Object) $this$equals_u24lambda_u241.getDensity(), (Object) ((CacheTextLayoutInput) other).textLayoutInput.getDensity()) && $this$equals_u24lambda_u241.getLayoutDirection() == ((CacheTextLayoutInput) other).textLayoutInput.getLayoutDirection() && $this$equals_u24lambda_u241.getFontFamilyResolver() == ((CacheTextLayoutInput) other).textLayoutInput.getFontFamilyResolver() && Constraints.m5930getMaxWidthimpl($this$equals_u24lambda_u241.m5442getConstraintsmsEJaDk()) == Constraints.m5930getMaxWidthimpl(((CacheTextLayoutInput) other).textLayoutInput.m5442getConstraintsmsEJaDk()) && Constraints.m5929getMaxHeightimpl($this$equals_u24lambda_u241.m5442getConstraintsmsEJaDk()) == Constraints.m5929getMaxHeightimpl(((CacheTextLayoutInput) other).textLayoutInput.m5442getConstraintsmsEJaDk())) {
            return true;
        }
        return false;
    }
}
