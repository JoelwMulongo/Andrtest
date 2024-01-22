package androidx.compose.material;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J$\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/compose/material/Shapes;", "", "small", "Landroidx/compose/foundation/shape/CornerBasedShape;", "medium", "large", "(Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;)V", "getLarge", "()Landroidx/compose/foundation/shape/CornerBasedShape;", "getMedium", "getSmall", "copy", "equals", "", "other", "hashCode", "", "toString", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Shapes.kt */
public final class Shapes {
    public static final int $stable = 0;
    private final CornerBasedShape large;
    private final CornerBasedShape medium;
    private final CornerBasedShape small;

    public Shapes() {
        this((CornerBasedShape) null, (CornerBasedShape) null, (CornerBasedShape) null, 7, (DefaultConstructorMarker) null);
    }

    public Shapes(CornerBasedShape small2, CornerBasedShape medium2, CornerBasedShape large2) {
        Intrinsics.checkNotNullParameter(small2, "small");
        Intrinsics.checkNotNullParameter(medium2, "medium");
        Intrinsics.checkNotNullParameter(large2, "large");
        this.small = small2;
        this.medium = medium2;
        this.large = large2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Shapes(CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoundedCornerShapeKt.m1118RoundedCornerShape0680j_4(Dp.m5986constructorimpl((float) 4)) : cornerBasedShape, (i & 2) != 0 ? RoundedCornerShapeKt.m1118RoundedCornerShape0680j_4(Dp.m5986constructorimpl((float) 4)) : cornerBasedShape2, (i & 4) != 0 ? RoundedCornerShapeKt.m1118RoundedCornerShape0680j_4(Dp.m5986constructorimpl((float) 0)) : cornerBasedShape3);
    }

    public final CornerBasedShape getSmall() {
        return this.small;
    }

    public final CornerBasedShape getMedium() {
        return this.medium;
    }

    public final CornerBasedShape getLarge() {
        return this.large;
    }

    public static /* synthetic */ Shapes copy$default(Shapes shapes, CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, int i, Object obj) {
        if ((i & 1) != 0) {
            cornerBasedShape = shapes.small;
        }
        if ((i & 2) != 0) {
            cornerBasedShape2 = shapes.medium;
        }
        if ((i & 4) != 0) {
            cornerBasedShape3 = shapes.large;
        }
        return shapes.copy(cornerBasedShape, cornerBasedShape2, cornerBasedShape3);
    }

    public final Shapes copy(CornerBasedShape small2, CornerBasedShape medium2, CornerBasedShape large2) {
        Intrinsics.checkNotNullParameter(small2, "small");
        Intrinsics.checkNotNullParameter(medium2, "medium");
        Intrinsics.checkNotNullParameter(large2, "large");
        return new Shapes(small2, medium2, large2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof Shapes) && Intrinsics.areEqual((Object) this.small, (Object) ((Shapes) other).small) && Intrinsics.areEqual((Object) this.medium, (Object) ((Shapes) other).medium) && Intrinsics.areEqual((Object) this.large, (Object) ((Shapes) other).large)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.small.hashCode() * 31) + this.medium.hashCode()) * 31) + this.large.hashCode();
    }

    public String toString() {
        return "Shapes(small=" + this.small + ", medium=" + this.medium + ", large=" + this.large + ')';
    }
}
