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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_accountBox", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccountBox", "Landroidx/compose/material/icons/Icons$Sharp;", "getAccountBox", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AccountBox.kt */
public final class AccountBoxKt {
    private static ImageVector _accountBox;

    public static final ImageVector getAccountBox(Icons.Sharp $this$AccountBox) {
        Intrinsics.checkNotNullParameter($this$AccountBox, "<this>");
        ImageVector imageVector = _accountBox;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_AccountBox__u24lambda_u241 = new ImageVector.Builder("Sharp.AccountBox", Dp.m5986constructorimpl(24.0f), Dp.m5986constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, (DefaultConstructorMarker) null);
        ImageVector.Builder $this$materialPath_u2dYwgOQQI_u24default$iv = $this$_get_AccountBox__u24lambda_u241;
        int strokeLineCap$iv$iv = StrokeCap.Companion.m3547getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.Companion.m3557getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        Object obj = "Sharp.AccountBox";
        ImageVector.Builder builder = $this$_get_AccountBox__u24lambda_u241;
        PathBuilder $this$_get_AccountBox__u24lambda_u241_u24lambda_u240 = $this$PathData_u24lambda_u2d0$iv$iv$iv;
        $this$_get_AccountBox__u24lambda_u241_u24lambda_u240.moveTo(21.0f, 3.0f);
        $this$_get_AccountBox__u24lambda_u241_u24lambda_u240.horizontalLineTo(3.0f);
        $this$_get_AccountBox__u24lambda_u241_u24lambda_u240.verticalLineToRelative(18.0f);
        $this$_get_AccountBox__u24lambda_u241_u24lambda_u240.horizontalLineToRelative(18.0f);
        $this$_get_AccountBox__u24lambda_u241_u24lambda_u240.verticalLineTo(3.0f);
        $this$_get_AccountBox__u24lambda_u241_u24lambda_u240.close();
        $this$_get_AccountBox__u24lambda_u241_u24lambda_u240.moveTo(12.0f, 6.0f);
        PathBuilder pathBuilder = $this$_get_AccountBox__u24lambda_u241_u24lambda_u240;
        pathBuilder.curveToRelative(1.93f, 0.0f, 3.5f, 1.57f, 3.5f, 3.5f);
        pathBuilder.curveToRelative(0.0f, 1.93f, -1.57f, 3.5f, -3.5f, 3.5f);
        $this$_get_AccountBox__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(-3.5f, -1.57f, -3.5f, -3.5f);
        pathBuilder.curveTo(8.5f, 7.57f, 10.07f, 6.0f, 12.0f, 6.0f);
        $this$_get_AccountBox__u24lambda_u241_u24lambda_u240.close();
        $this$_get_AccountBox__u24lambda_u241_u24lambda_u240.moveTo(19.0f, 19.0f);
        $this$_get_AccountBox__u24lambda_u241_u24lambda_u240.horizontalLineTo(5.0f);
        $this$_get_AccountBox__u24lambda_u241_u24lambda_u240.verticalLineToRelative(-0.23f);
        pathBuilder.curveToRelative(0.0f, -0.62f, 0.28f, -1.2f, 0.76f, -1.58f);
        pathBuilder.curveTo(7.47f, 15.82f, 9.64f, 15.0f, 12.0f, 15.0f);
        ImageVector.Builder builder2 = $this$materialPath_u2dYwgOQQI_u24default$iv;
        $this$_get_AccountBox__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(4.53f, 0.82f, 6.24f, 2.19f);
        pathBuilder.curveToRelative(0.48f, 0.38f, 0.76f, 0.97f, 0.76f, 1.58f);
        $this$_get_AccountBox__u24lambda_u241_u24lambda_u240.verticalLineTo(19.0f);
        $this$_get_AccountBox__u24lambda_u241_u24lambda_u240.close();
        List<PathNode> nodes = $this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes();
        ImageVector build = ImageVector.Builder.m3873addPathoIyEayM$default($this$materialPath_u2dYwgOQQI_u24default$iv, nodes, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3190getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _accountBox = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
