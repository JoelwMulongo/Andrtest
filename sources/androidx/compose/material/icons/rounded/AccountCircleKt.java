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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_accountCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccountCircle", "Landroidx/compose/material/icons/Icons$Rounded;", "getAccountCircle", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AccountCircle.kt */
public final class AccountCircleKt {
    private static ImageVector _accountCircle;

    public static final ImageVector getAccountCircle(Icons.Rounded $this$AccountCircle) {
        Intrinsics.checkNotNullParameter($this$AccountCircle, "<this>");
        ImageVector imageVector = _accountCircle;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_AccountCircle__u24lambda_u241 = new ImageVector.Builder("Rounded.AccountCircle", Dp.m5986constructorimpl(24.0f), Dp.m5986constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, (DefaultConstructorMarker) null);
        ImageVector.Builder $this$materialPath_u2dYwgOQQI_u24default$iv = $this$_get_AccountCircle__u24lambda_u241;
        int strokeLineCap$iv$iv = StrokeCap.Companion.m3547getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.Companion.m3557getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        Object obj = "Rounded.AccountCircle";
        ImageVector.Builder builder = $this$_get_AccountCircle__u24lambda_u241;
        PathBuilder $this$_get_AccountCircle__u24lambda_u241_u24lambda_u240 = $this$PathData_u24lambda_u2d0$iv$iv$iv;
        $this$_get_AccountCircle__u24lambda_u241_u24lambda_u240.moveTo(12.0f, 2.0f);
        PathBuilder pathBuilder = $this$_get_AccountCircle__u24lambda_u241_u24lambda_u240;
        pathBuilder.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        $this$_get_AccountCircle__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
        $this$_get_AccountCircle__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        $this$_get_AccountCircle__u24lambda_u241_u24lambda_u240.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
        $this$_get_AccountCircle__u24lambda_u241_u24lambda_u240.close();
        $this$_get_AccountCircle__u24lambda_u241_u24lambda_u240.moveTo(12.0f, 6.0f);
        pathBuilder.curveToRelative(1.93f, 0.0f, 3.5f, 1.57f, 3.5f, 3.5f);
        $this$_get_AccountCircle__u24lambda_u241_u24lambda_u240.reflectiveCurveTo(13.93f, 13.0f, 12.0f, 13.0f);
        $this$_get_AccountCircle__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(-3.5f, -1.57f, -3.5f, -3.5f);
        $this$_get_AccountCircle__u24lambda_u241_u24lambda_u240.reflectiveCurveTo(10.07f, 6.0f, 12.0f, 6.0f);
        $this$_get_AccountCircle__u24lambda_u241_u24lambda_u240.close();
        $this$_get_AccountCircle__u24lambda_u241_u24lambda_u240.moveTo(12.0f, 20.0f);
        pathBuilder.curveToRelative(-2.03f, 0.0f, -4.43f, -0.82f, -6.14f, -2.88f);
        pathBuilder.curveTo(7.55f, 15.8f, 9.68f, 15.0f, 12.0f, 15.0f);
        ImageVector.Builder builder2 = $this$materialPath_u2dYwgOQQI_u24default$iv;
        $this$_get_AccountCircle__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(4.45f, 0.8f, 6.14f, 2.12f);
        pathBuilder.curveTo(16.43f, 19.18f, 14.03f, 20.0f, 12.0f, 20.0f);
        $this$_get_AccountCircle__u24lambda_u241_u24lambda_u240.close();
        List<PathNode> nodes = $this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes();
        ImageVector build = ImageVector.Builder.m3873addPathoIyEayM$default($this$materialPath_u2dYwgOQQI_u24default$iv, nodes, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3190getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _accountCircle = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
