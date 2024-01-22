package androidx.compose.material.icons.rounded;

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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_search", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Search", "Landroidx/compose/material/icons/Icons$Rounded;", "getSearch", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Search.kt */
public final class SearchKt {
    private static ImageVector _search;

    public static final ImageVector getSearch(Icons.Rounded $this$Search) {
        Intrinsics.checkNotNullParameter($this$Search, "<this>");
        ImageVector imageVector = _search;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Search__u24lambda_u241 = new ImageVector.Builder("Rounded.Search", Dp.m5986constructorimpl(24.0f), Dp.m5986constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, (DefaultConstructorMarker) null);
        int strokeLineCap$iv$iv = StrokeCap.Companion.m3547getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.Companion.m3557getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        Object obj = "Rounded.Search";
        ImageVector.Builder builder = $this$_get_Search__u24lambda_u241;
        PathBuilder $this$_get_Search__u24lambda_u241_u24lambda_u240 = $this$PathData_u24lambda_u2d0$iv$iv$iv;
        $this$_get_Search__u24lambda_u241_u24lambda_u240.moveTo(15.5f, 14.0f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.horizontalLineToRelative(-0.79f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.lineToRelative(-0.28f, -0.27f);
        PathBuilder pathBuilder = $this$_get_Search__u24lambda_u241_u24lambda_u240;
        pathBuilder.curveToRelative(1.2f, -1.4f, 1.82f, -3.31f, 1.48f, -5.34f);
        pathBuilder.curveToRelative(-0.47f, -2.78f, -2.79f, -5.0f, -5.59f, -5.34f);
        pathBuilder.curveToRelative(-4.23f, -0.52f, -7.79f, 3.04f, -7.27f, 7.27f);
        pathBuilder.curveToRelative(0.34f, 2.8f, 2.56f, 5.12f, 5.34f, 5.59f);
        pathBuilder.curveToRelative(2.03f, 0.34f, 3.94f, -0.28f, 5.34f, -1.48f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.lineToRelative(0.27f, 0.28f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.verticalLineToRelative(0.79f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.lineToRelative(4.25f, 4.25f);
        pathBuilder.curveToRelative(0.41f, 0.41f, 1.08f, 0.41f, 1.49f, 0.0f);
        pathBuilder.curveToRelative(0.41f, -0.41f, 0.41f, -1.08f, 0.0f, -1.49f);
        $this$_get_Search__u24lambda_u241_u24lambda_u240.lineTo(15.5f, 14.0f);
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
