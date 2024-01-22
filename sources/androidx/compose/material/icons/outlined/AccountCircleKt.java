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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_accountCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccountCircle", "Landroidx/compose/material/icons/Icons$Outlined;", "getAccountCircle", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AccountCircle.kt */
public final class AccountCircleKt {
    private static ImageVector _accountCircle;

    public static final ImageVector getAccountCircle(Icons.Outlined $this$AccountCircle) {
        Intrinsics.checkNotNullParameter($this$AccountCircle, "<this>");
        ImageVector imageVector = _accountCircle;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_AccountCircle__u24lambda_u242 = new ImageVector.Builder("Outlined.AccountCircle", Dp.m5986constructorimpl(24.0f), Dp.m5986constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, (DefaultConstructorMarker) null);
        ImageVector.Builder $this$materialPath_u2dYwgOQQI_u24default$iv = $this$_get_AccountCircle__u24lambda_u242;
        int strokeLineCap$iv$iv = StrokeCap.Companion.m3547getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.Companion.m3557getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        Object obj = "Outlined.AccountCircle";
        PathBuilder $this$_get_AccountCircle__u24lambda_u242_u24lambda_u240 = $this$PathData_u24lambda_u2d0$iv$iv$iv;
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u240.moveTo(12.0f, 2.0f);
        PathBuilder pathBuilder = $this$_get_AccountCircle__u24lambda_u242_u24lambda_u240;
        pathBuilder.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u240.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u240.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u240.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u240.close();
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u240.moveTo(7.35f, 18.5f);
        pathBuilder.curveTo(8.66f, 17.56f, 10.26f, 17.0f, 12.0f, 17.0f);
        ImageVector.Builder builder = $this$materialPath_u2dYwgOQQI_u24default$iv;
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u240.reflectiveCurveToRelative(3.34f, 0.56f, 4.65f, 1.5f);
        pathBuilder.curveTo(15.34f, 19.44f, 13.74f, 20.0f, 12.0f, 20.0f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u240.reflectiveCurveTo(8.66f, 19.44f, 7.35f, 18.5f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u240.close();
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u240.moveTo(18.14f, 17.12f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u240.lineTo(18.14f, 17.12f);
        pathBuilder.curveTo(16.45f, 15.8f, 14.32f, 15.0f, 12.0f, 15.0f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u240.reflectiveCurveToRelative(-4.45f, 0.8f, -6.14f, 2.12f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u240.lineToRelative(0.0f, 0.0f);
        pathBuilder.curveTo(4.7f, 15.73f, 4.0f, 13.95f, 4.0f, 12.0f);
        pathBuilder.curveToRelative(0.0f, -4.42f, 3.58f, -8.0f, 8.0f, -8.0f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u240.reflectiveCurveToRelative(8.0f, 3.58f, 8.0f, 8.0f);
        pathBuilder.curveTo(20.0f, 13.95f, 19.3f, 15.73f, 18.14f, 17.12f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u240.close();
        List<PathNode> nodes = $this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes();
        ImageVector.Builder.m3873addPathoIyEayM$default($this$materialPath_u2dYwgOQQI_u24default$iv, nodes, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3190getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        ImageVector.Builder $this$materialPath_u2dYwgOQQI_u24default$iv2 = $this$_get_AccountCircle__u24lambda_u242;
        int strokeLineCap$iv$iv2 = StrokeCap.Companion.m3547getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.Companion.m3557getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        PathBuilder $this$_get_AccountCircle__u24lambda_u242_u24lambda_u241 = $this$PathData_u24lambda_u2d0$iv$iv$iv2;
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u241.moveTo(12.0f, 6.0f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u241.curveToRelative(-1.93f, 0.0f, -3.5f, 1.57f, -3.5f, 3.5f);
        ImageVector.Builder builder2 = $this$materialPath_u2dYwgOQQI_u24default$iv2;
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u241.reflectiveCurveTo(10.07f, 13.0f, 12.0f, 13.0f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u241.reflectiveCurveToRelative(3.5f, -1.57f, 3.5f, -3.5f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u241.reflectiveCurveTo(13.93f, 6.0f, 12.0f, 6.0f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u241.close();
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u241.moveTo(12.0f, 11.0f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u241.curveToRelative(-0.83f, 0.0f, -1.5f, -0.67f, -1.5f, -1.5f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u241.reflectiveCurveTo(11.17f, 8.0f, 12.0f, 8.0f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u241.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u241.reflectiveCurveTo(12.83f, 11.0f, 12.0f, 11.0f);
        $this$_get_AccountCircle__u24lambda_u242_u24lambda_u241.close();
        List<PathNode> nodes2 = $this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes();
        ImageVector build = ImageVector.Builder.m3873addPathoIyEayM$default($this$materialPath_u2dYwgOQQI_u24default$iv2, nodes2, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3190getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv2, strokeLineJoin$iv$iv2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _accountCircle = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
