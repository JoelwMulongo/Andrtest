package androidx.compose.material3;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u001c\u0010\u000f\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/FractionalThreshold;", "Landroidx/compose/material3/ThresholdConfig;", "fraction", "", "(F)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "computeThreshold", "Landroidx/compose/ui/unit/Density;", "fromValue", "toValue", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
/* compiled from: Swipeable.kt */
public final class FractionalThreshold implements ThresholdConfig {
    private final float fraction;

    private final float component1() {
        return this.fraction;
    }

    public static /* synthetic */ FractionalThreshold copy$default(FractionalThreshold fractionalThreshold, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = fractionalThreshold.fraction;
        }
        return fractionalThreshold.copy(f);
    }

    public final FractionalThreshold copy(float f) {
        return new FractionalThreshold(f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FractionalThreshold) && Intrinsics.areEqual((Object) Float.valueOf(this.fraction), (Object) Float.valueOf(((FractionalThreshold) obj).fraction));
    }

    public int hashCode() {
        return Float.hashCode(this.fraction);
    }

    public String toString() {
        return "FractionalThreshold(fraction=" + this.fraction + ')';
    }

    public FractionalThreshold(float fraction2) {
        this.fraction = fraction2;
    }

    public float computeThreshold(Density $this$computeThreshold, float fromValue, float toValue) {
        Intrinsics.checkNotNullParameter($this$computeThreshold, "<this>");
        return MathHelpersKt.lerp(fromValue, toValue, this.fraction);
    }
}
