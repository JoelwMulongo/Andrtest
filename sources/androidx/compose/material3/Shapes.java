package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ8\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/Shapes;", "", "extraSmall", "Landroidx/compose/foundation/shape/CornerBasedShape;", "small", "medium", "large", "extraLarge", "(Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;)V", "getExtraLarge", "()Landroidx/compose/foundation/shape/CornerBasedShape;", "getExtraSmall", "getLarge", "getMedium", "getSmall", "copy", "equals", "", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Shapes.kt */
public final class Shapes {
    private final CornerBasedShape extraLarge;
    private final CornerBasedShape extraSmall;
    private final CornerBasedShape large;
    private final CornerBasedShape medium;
    private final CornerBasedShape small;

    public Shapes() {
        this((CornerBasedShape) null, (CornerBasedShape) null, (CornerBasedShape) null, (CornerBasedShape) null, (CornerBasedShape) null, 31, (DefaultConstructorMarker) null);
    }

    public Shapes(CornerBasedShape extraSmall2, CornerBasedShape small2, CornerBasedShape medium2, CornerBasedShape large2, CornerBasedShape extraLarge2) {
        Intrinsics.checkNotNullParameter(extraSmall2, "extraSmall");
        Intrinsics.checkNotNullParameter(small2, "small");
        Intrinsics.checkNotNullParameter(medium2, "medium");
        Intrinsics.checkNotNullParameter(large2, "large");
        Intrinsics.checkNotNullParameter(extraLarge2, "extraLarge");
        this.extraSmall = extraSmall2;
        this.small = small2;
        this.medium = medium2;
        this.large = large2;
        this.extraLarge = extraLarge2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Shapes(androidx.compose.foundation.shape.CornerBasedShape r4, androidx.compose.foundation.shape.CornerBasedShape r5, androidx.compose.foundation.shape.CornerBasedShape r6, androidx.compose.foundation.shape.CornerBasedShape r7, androidx.compose.foundation.shape.CornerBasedShape r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x000a
            androidx.compose.material3.ShapeDefaults r4 = androidx.compose.material3.ShapeDefaults.INSTANCE
            androidx.compose.foundation.shape.CornerBasedShape r4 = r4.getExtraSmall()
        L_0x000a:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x0016
            androidx.compose.material3.ShapeDefaults r5 = androidx.compose.material3.ShapeDefaults.INSTANCE
            androidx.compose.foundation.shape.CornerBasedShape r5 = r5.getSmall()
            r10 = r5
            goto L_0x0017
        L_0x0016:
            r10 = r5
        L_0x0017:
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0023
            androidx.compose.material3.ShapeDefaults r5 = androidx.compose.material3.ShapeDefaults.INSTANCE
            androidx.compose.foundation.shape.CornerBasedShape r6 = r5.getMedium()
            r0 = r6
            goto L_0x0024
        L_0x0023:
            r0 = r6
        L_0x0024:
            r5 = r9 & 8
            if (r5 == 0) goto L_0x0030
            androidx.compose.material3.ShapeDefaults r5 = androidx.compose.material3.ShapeDefaults.INSTANCE
            androidx.compose.foundation.shape.CornerBasedShape r7 = r5.getLarge()
            r1 = r7
            goto L_0x0031
        L_0x0030:
            r1 = r7
        L_0x0031:
            r5 = r9 & 16
            if (r5 == 0) goto L_0x003d
            androidx.compose.material3.ShapeDefaults r5 = androidx.compose.material3.ShapeDefaults.INSTANCE
            androidx.compose.foundation.shape.CornerBasedShape r8 = r5.getExtraLarge()
            r2 = r8
            goto L_0x003e
        L_0x003d:
            r2 = r8
        L_0x003e:
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.Shapes.<init>(androidx.compose.foundation.shape.CornerBasedShape, androidx.compose.foundation.shape.CornerBasedShape, androidx.compose.foundation.shape.CornerBasedShape, androidx.compose.foundation.shape.CornerBasedShape, androidx.compose.foundation.shape.CornerBasedShape, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final CornerBasedShape getExtraSmall() {
        return this.extraSmall;
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

    public final CornerBasedShape getExtraLarge() {
        return this.extraLarge;
    }

    public static /* synthetic */ Shapes copy$default(Shapes shapes, CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, CornerBasedShape cornerBasedShape4, CornerBasedShape cornerBasedShape5, int i, Object obj) {
        CornerBasedShape cornerBasedShape6;
        CornerBasedShape cornerBasedShape7;
        CornerBasedShape cornerBasedShape8;
        CornerBasedShape cornerBasedShape9;
        if ((i & 1) != 0) {
            cornerBasedShape = shapes.extraSmall;
        }
        if ((i & 2) != 0) {
            cornerBasedShape6 = shapes.small;
        } else {
            cornerBasedShape6 = cornerBasedShape2;
        }
        if ((i & 4) != 0) {
            cornerBasedShape7 = shapes.medium;
        } else {
            cornerBasedShape7 = cornerBasedShape3;
        }
        if ((i & 8) != 0) {
            cornerBasedShape8 = shapes.large;
        } else {
            cornerBasedShape8 = cornerBasedShape4;
        }
        if ((i & 16) != 0) {
            cornerBasedShape9 = shapes.extraLarge;
        } else {
            cornerBasedShape9 = cornerBasedShape5;
        }
        return shapes.copy(cornerBasedShape, cornerBasedShape6, cornerBasedShape7, cornerBasedShape8, cornerBasedShape9);
    }

    public final Shapes copy(CornerBasedShape extraSmall2, CornerBasedShape small2, CornerBasedShape medium2, CornerBasedShape large2, CornerBasedShape extraLarge2) {
        Intrinsics.checkNotNullParameter(extraSmall2, "extraSmall");
        Intrinsics.checkNotNullParameter(small2, "small");
        Intrinsics.checkNotNullParameter(medium2, "medium");
        Intrinsics.checkNotNullParameter(large2, "large");
        Intrinsics.checkNotNullParameter(extraLarge2, "extraLarge");
        return new Shapes(extraSmall2, small2, medium2, large2, extraLarge2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof Shapes) && Intrinsics.areEqual((Object) this.extraSmall, (Object) ((Shapes) other).extraSmall) && Intrinsics.areEqual((Object) this.small, (Object) ((Shapes) other).small) && Intrinsics.areEqual((Object) this.medium, (Object) ((Shapes) other).medium) && Intrinsics.areEqual((Object) this.large, (Object) ((Shapes) other).large) && Intrinsics.areEqual((Object) this.extraLarge, (Object) ((Shapes) other).extraLarge)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.extraSmall.hashCode() * 31) + this.small.hashCode()) * 31) + this.medium.hashCode()) * 31) + this.large.hashCode()) * 31) + this.extraLarge.hashCode();
    }

    public String toString() {
        return "Shapes(extraSmall=" + this.extraSmall + ", small=" + this.small + ", medium=" + this.medium + ", large=" + this.large + ", extraLarge=" + this.extraLarge + ')';
    }
}
