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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_star", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Star", "Landroidx/compose/material/icons/Icons$Sharp;", "getStar", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Star.kt */
public final class StarKt {
    private static ImageVector _star;

    public static final ImageVector getStar(Icons.Sharp $this$Star) {
        Intrinsics.checkNotNullParameter($this$Star, "<this>");
        ImageVector imageVector = _star;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Star__u24lambda_u241 = new ImageVector.Builder("Sharp.Star", Dp.m5986constructorimpl(24.0f), Dp.m5986constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, (DefaultConstructorMarker) null);
        int strokeLineCap$iv$iv = StrokeCap.Companion.m3547getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.Companion.m3557getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        Object obj = "Sharp.Star";
        ImageVector.Builder builder = $this$_get_Star__u24lambda_u241;
        PathBuilder $this$_get_Star__u24lambda_u241_u24lambda_u240 = $this$PathData_u24lambda_u2d0$iv$iv$iv;
        $this$_get_Star__u24lambda_u241_u24lambda_u240.moveTo(12.0f, 17.27f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineTo(18.18f, 21.0f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineToRelative(-1.64f, -7.03f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineTo(22.0f, 9.24f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineToRelative(-7.19f, -0.61f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineTo(12.0f, 2.0f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineTo(9.19f, 8.63f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineTo(2.0f, 9.24f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineToRelative(5.46f, 4.73f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineTo(5.82f, 21.0f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineTo(12.0f, 17.27f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.close();
        List<PathNode> nodes = $this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes();
        ImageVector build = ImageVector.Builder.m3873addPathoIyEayM$default($this$_get_Star__u24lambda_u241, nodes, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3190getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _star = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
