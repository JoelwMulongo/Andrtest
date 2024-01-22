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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_warning", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Warning", "Landroidx/compose/material/icons/Icons$Rounded;", "getWarning", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Warning.kt */
public final class WarningKt {
    private static ImageVector _warning;

    public static final ImageVector getWarning(Icons.Rounded $this$Warning) {
        Intrinsics.checkNotNullParameter($this$Warning, "<this>");
        ImageVector imageVector = _warning;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        int strokeLineCap$iv$iv = StrokeCap.Companion.m3547getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.Companion.m3557getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        Object obj = "Rounded.Warning";
        PathBuilder $this$_get_Warning__u24lambda_u241_u24lambda_u240 = $this$PathData_u24lambda_u2d0$iv$iv$iv;
        $this$_get_Warning__u24lambda_u241_u24lambda_u240.moveTo(4.47f, 21.0f);
        $this$_get_Warning__u24lambda_u241_u24lambda_u240.horizontalLineToRelative(15.06f);
        PathBuilder pathBuilder = $this$_get_Warning__u24lambda_u241_u24lambda_u240;
        pathBuilder.curveToRelative(1.54f, 0.0f, 2.5f, -1.67f, 1.73f, -3.0f);
        $this$_get_Warning__u24lambda_u241_u24lambda_u240.lineTo(13.73f, 4.99f);
        pathBuilder.curveToRelative(-0.77f, -1.33f, -2.69f, -1.33f, -3.46f, 0.0f);
        $this$_get_Warning__u24lambda_u241_u24lambda_u240.lineTo(2.74f, 18.0f);
        pathBuilder.curveToRelative(-0.77f, 1.33f, 0.19f, 3.0f, 1.73f, 3.0f);
        $this$_get_Warning__u24lambda_u241_u24lambda_u240.close();
        $this$_get_Warning__u24lambda_u241_u24lambda_u240.moveTo(12.0f, 14.0f);
        pathBuilder.curveToRelative(-0.55f, 0.0f, -1.0f, -0.45f, -1.0f, -1.0f);
        $this$_get_Warning__u24lambda_u241_u24lambda_u240.verticalLineToRelative(-2.0f);
        pathBuilder.curveToRelative(0.0f, -0.55f, 0.45f, -1.0f, 1.0f, -1.0f);
        $this$_get_Warning__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(1.0f, 0.45f, 1.0f, 1.0f);
        $this$_get_Warning__u24lambda_u241_u24lambda_u240.verticalLineToRelative(2.0f);
        pathBuilder.curveToRelative(0.0f, 0.55f, -0.45f, 1.0f, -1.0f, 1.0f);
        $this$_get_Warning__u24lambda_u241_u24lambda_u240.close();
        $this$_get_Warning__u24lambda_u241_u24lambda_u240.moveTo(13.0f, 18.0f);
        $this$_get_Warning__u24lambda_u241_u24lambda_u240.horizontalLineToRelative(-2.0f);
        $this$_get_Warning__u24lambda_u241_u24lambda_u240.verticalLineToRelative(-2.0f);
        $this$_get_Warning__u24lambda_u241_u24lambda_u240.horizontalLineToRelative(2.0f);
        $this$_get_Warning__u24lambda_u241_u24lambda_u240.verticalLineToRelative(2.0f);
        $this$_get_Warning__u24lambda_u241_u24lambda_u240.close();
        List<PathNode> nodes = $this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes();
        ImageVector build = ImageVector.Builder.m3873addPathoIyEayM$default(new ImageVector.Builder("Rounded.Warning", Dp.m5986constructorimpl(24.0f), Dp.m5986constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, (DefaultConstructorMarker) null), nodes, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3190getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _warning = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
