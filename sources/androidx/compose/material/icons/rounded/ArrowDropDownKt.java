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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_arrowDropDown", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ArrowDropDown", "Landroidx/compose/material/icons/Icons$Rounded;", "getArrowDropDown", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ArrowDropDown.kt */
public final class ArrowDropDownKt {
    private static ImageVector _arrowDropDown;

    public static final ImageVector getArrowDropDown(Icons.Rounded $this$ArrowDropDown) {
        Intrinsics.checkNotNullParameter($this$ArrowDropDown, "<this>");
        ImageVector imageVector = _arrowDropDown;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_ArrowDropDown__u24lambda_u241 = new ImageVector.Builder("Rounded.ArrowDropDown", Dp.m5986constructorimpl(24.0f), Dp.m5986constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, (DefaultConstructorMarker) null);
        int strokeLineCap$iv$iv = StrokeCap.Companion.m3547getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.Companion.m3557getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        Object obj = "Rounded.ArrowDropDown";
        ImageVector.Builder builder = $this$_get_ArrowDropDown__u24lambda_u241;
        PathBuilder $this$_get_ArrowDropDown__u24lambda_u241_u24lambda_u240 = $this$PathData_u24lambda_u2d0$iv$iv$iv;
        $this$_get_ArrowDropDown__u24lambda_u241_u24lambda_u240.moveTo(8.71f, 11.71f);
        $this$_get_ArrowDropDown__u24lambda_u241_u24lambda_u240.lineToRelative(2.59f, 2.59f);
        PathBuilder pathBuilder = $this$_get_ArrowDropDown__u24lambda_u241_u24lambda_u240;
        pathBuilder.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0.0f);
        $this$_get_ArrowDropDown__u24lambda_u241_u24lambda_u240.lineToRelative(2.59f, -2.59f);
        pathBuilder.curveToRelative(0.63f, -0.63f, 0.18f, -1.71f, -0.71f, -1.71f);
        $this$_get_ArrowDropDown__u24lambda_u241_u24lambda_u240.horizontalLineTo(9.41f);
        pathBuilder.curveToRelative(-0.89f, 0.0f, -1.33f, 1.08f, -0.7f, 1.71f);
        $this$_get_ArrowDropDown__u24lambda_u241_u24lambda_u240.close();
        List<PathNode> nodes = $this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes();
        ImageVector build = ImageVector.Builder.m3873addPathoIyEayM$default($this$_get_ArrowDropDown__u24lambda_u241, nodes, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3190getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _arrowDropDown = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
