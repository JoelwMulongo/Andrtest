package androidx.compose.material.icons.sharp;

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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_search", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Search", "Landroidx/compose/material/icons/Icons$Sharp;", "getSearch", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Search.kt */
public final class SearchKt {
    private static ImageVector _search;

    public static final ImageVector getSearch(Icons.Sharp $this$Search) {
        Intrinsics.checkNotNullParameter($this$Search, "<this>");
        ImageVector imageVector = _search;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Search__u24lambda_u241 = new ImageVector.Builder("Sharp.Search", Dp.m5986constructorimpl(24.0f), Dp.m5986constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, (DefaultConstructorMarker) null);
        int strokeLineCap$iv$iv = StrokeCap.Companion.m3547getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.Companion.m3557getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        Object obj = "Sharp.Search";
        ImageVector.Builder builder = $this$_get_Search__u24lambda_u241;
        PathBuilder $this$_get_Search__u24lambda_u241_u24lambda_u240 = $this$PathData_u24lambda_u2d0$iv$iv$iv;
        $this$_get_Search__u24lambda_u241_u24lambda_u240.moveTo(15.5f, 14.0f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.horizontalLineToRelative(-0.79f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.lineToRelative(-0.28f, -0.27f);
        PathBuilder pathBuilder = $this$_get_Search__u24lambda_u241_u24lambda_u240;
        pathBuilder.curveTo(15.41f, 12.59f, 16.0f, 11.11f, 16.0f, 9.5f);
        pathBuilder.curveTo(16.0f, 5.91f, 13.09f, 3.0f, 9.5f, 3.0f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.reflectiveCurveTo(3.0f, 5.91f, 3.0f, 9.5f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.reflectiveCurveTo(5.91f, 16.0f, 9.5f, 16.0f);
        pathBuilder.curveToRelative(1.61f, 0.0f, 3.09f, -0.59f, 4.23f, -1.57f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.lineToRelative(0.27f, 0.28f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.verticalLineToRelative(0.79f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.lineToRelative(5.0f, 4.99f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.lineTo(20.49f, 19.0f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.lineToRelative(-4.99f, -5.0f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.close();
        $this$_get_Search__u24lambda_u241_u24lambda_u240.moveTo(9.5f, 14.0f);
        pathBuilder.curveTo(7.01f, 14.0f, 5.0f, 11.99f, 5.0f, 9.5f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.reflectiveCurveTo(7.01f, 5.0f, 9.5f, 5.0f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.reflectiveCurveTo(14.0f, 7.01f, 14.0f, 9.5f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.reflectiveCurveTo(11.99f, 14.0f, 9.5f, 14.0f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.close();
        List<PathNode> nodes = $this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes();
        ImageVector build = ImageVector.Builder.m3873addPathoIyEayM$default($this$_get_Search__u24lambda_u241, nodes, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3190getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _search = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
