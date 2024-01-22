package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_locationOn", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocationOn", "Landroidx/compose/material/icons/Icons$Outlined;", "getLocationOn", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LocationOn.kt */
public final class LocationOnKt {
    private static ImageVector _locationOn;

    public static final ImageVector getLocationOn(Icons.Outlined $this$LocationOn) {
        Intrinsics.checkNotNullParameter($this$LocationOn, "<this>");
        ImageVector imageVector = _locationOn;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_LocationOn__u24lambda_u242 = new ImageVector.Builder("Outlined.LocationOn", Dp.m5986constructorimpl(24.0f), Dp.m5986constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, (DefaultConstructorMarker) null);
        int strokeLineCap$iv$iv = StrokeCap.Companion.m3547getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.Companion.m3557getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        Object obj = "Outlined.LocationOn";
        PathBuilder $this$_get_LocationOn__u24lambda_u242_u24lambda_u240 = $this$PathData_u24lambda_u2d0$iv$iv$iv;
        $this$_get_LocationOn__u24lambda_u242_u24lambda_u240.moveTo(12.0f, 2.0f);
        PathBuilder pathBuilder = $this$_get_LocationOn__u24lambda_u242_u24lambda_u240;
        pathBuilder.curveTo(8.13f, 2.0f, 5.0f, 5.13f, 5.0f, 9.0f);
        pathBuilder.curveToRelative(0.0f, 5.25f, 7.0f, 13.0f, 7.0f, 13.0f);
        $this$_get_LocationOn__u24lambda_u242_u24lambda_u240.reflectiveCurveToRelative(7.0f, -7.75f, 7.0f, -13.0f);
        pathBuilder.curveToRelative(0.0f, -3.87f, -3.13f, -7.0f, -7.0f, -7.0f);
        $this$_get_LocationOn__u24lambda_u242_u24lambda_u240.close();
        $this$_get_LocationOn__u24lambda_u242_u24lambda_u240.moveTo(7.0f, 9.0f);
        pathBuilder.curveToRelative(0.0f, -2.76f, 2.24f, -5.0f, 5.0f, -5.0f);
        $this$_get_LocationOn__u24lambda_u242_u24lambda_u240.reflectiveCurveToRelative(5.0f, 2.24f, 5.0f, 5.0f);
        pathBuilder.curveToRelative(0.0f, 2.88f, -2.88f, 7.19f, -5.0f, 9.88f);
        pathBuilder.curveTo(9.92f, 16.21f, 7.0f, 11.85f, 7.0f, 9.0f);
        $this$_get_LocationOn__u24lambda_u242_u24lambda_u240.close();
        List<PathNode> nodes = $this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes();
        ImageVector.Builder.m3873addPathoIyEayM$default($this$_get_LocationOn__u24lambda_u242, nodes, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3190getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int strokeLineCap$iv$iv2 = StrokeCap.Companion.m3547getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.Companion.m3557getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        PathBuilder $this$_get_LocationOn__u24lambda_u242_u24lambda_u241 = $this$PathData_u24lambda_u2d0$iv$iv$iv2;
        $this$_get_LocationOn__u24lambda_u242_u24lambda_u241.moveTo(12.0f, 9.0f);
        $this$_get_LocationOn__u24lambda_u242_u24lambda_u241.moveToRelative(-2.5f, 0.0f);
        PathBuilder pathBuilder2 = $this$_get_LocationOn__u24lambda_u242_u24lambda_u241;
        pathBuilder2.arcToRelative(2.5f, 2.5f, 0.0f, true, true, 5.0f, 0.0f);
        pathBuilder2.arcToRelative(2.5f, 2.5f, 0.0f, true, true, -5.0f, 0.0f);
        List<PathNode> nodes2 = $this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes();
        ImageVector build = ImageVector.Builder.m3873addPathoIyEayM$default($this$_get_LocationOn__u24lambda_u242, nodes2, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3190getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv2, strokeLineJoin$iv$iv2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _locationOn = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
