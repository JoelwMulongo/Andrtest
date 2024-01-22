package androidx.compose.material.icons.filled;

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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_checkCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CheckCircle", "Landroidx/compose/material/icons/Icons$Filled;", "getCheckCircle", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: CheckCircle.kt */
public final class CheckCircleKt {
    private static ImageVector _checkCircle;

    public static final ImageVector getCheckCircle(Icons.Filled $this$CheckCircle) {
        Intrinsics.checkNotNullParameter($this$CheckCircle, "<this>");
        ImageVector imageVector = _checkCircle;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_CheckCircle__u24lambda_u241 = new ImageVector.Builder("Filled.CheckCircle", Dp.m5986constructorimpl(24.0f), Dp.m5986constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, (DefaultConstructorMarker) null);
        int strokeLineCap$iv$iv = StrokeCap.Companion.m3547getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.Companion.m3557getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        Object obj = "Filled.CheckCircle";
        ImageVector.Builder builder = $this$_get_CheckCircle__u24lambda_u241;
        PathBuilder $this$_get_CheckCircle__u24lambda_u241_u24lambda_u240 = $this$PathData_u24lambda_u2d0$iv$iv$iv;
        $this$_get_CheckCircle__u24lambda_u241_u24lambda_u240.moveTo(12.0f, 2.0f);
        $this$_get_CheckCircle__u24lambda_u241_u24lambda_u240.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        $this$_get_CheckCircle__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
        $this$_get_CheckCircle__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        $this$_get_CheckCircle__u24lambda_u241_u24lambda_u240.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
        $this$_get_CheckCircle__u24lambda_u241_u24lambda_u240.close();
        $this$_get_CheckCircle__u24lambda_u241_u24lambda_u240.moveTo(10.0f, 17.0f);
        $this$_get_CheckCircle__u24lambda_u241_u24lambda_u240.lineToRelative(-5.0f, -5.0f);
        $this$_get_CheckCircle__u24lambda_u241_u24lambda_u240.lineToRelative(1.41f, -1.41f);
        $this$_get_CheckCircle__u24lambda_u241_u24lambda_u240.lineTo(10.0f, 14.17f);
        $this$_get_CheckCircle__u24lambda_u241_u24lambda_u240.lineToRelative(7.59f, -7.59f);
        $this$_get_CheckCircle__u24lambda_u241_u24lambda_u240.lineTo(19.0f, 8.0f);
        $this$_get_CheckCircle__u24lambda_u241_u24lambda_u240.lineToRelative(-9.0f, 9.0f);
        $this$_get_CheckCircle__u24lambda_u241_u24lambda_u240.close();
        List<PathNode> nodes = $this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes();
        ImageVector build = ImageVector.Builder.m3873addPathoIyEayM$default($this$_get_CheckCircle__u24lambda_u241, nodes, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3190getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _checkCircle = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
