package androidx.compose.material.icons.twotone;

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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_playArrow", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PlayArrow", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPlayArrow", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PlayArrow.kt */
public final class PlayArrowKt {
    private static ImageVector _playArrow;

    public static final ImageVector getPlayArrow(Icons.TwoTone $this$PlayArrow) {
        Intrinsics.checkNotNullParameter($this$PlayArrow, "<this>");
        ImageVector imageVector = _playArrow;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_PlayArrow__u24lambda_u242 = new ImageVector.Builder("TwoTone.PlayArrow", Dp.m5986constructorimpl(24.0f), Dp.m5986constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, (DefaultConstructorMarker) null);
        int strokeLineCap$iv$iv = StrokeCap.Companion.m3547getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.Companion.m3557getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        Object obj = "TwoTone.PlayArrow";
        PathBuilder $this$_get_PlayArrow__u24lambda_u242_u24lambda_u240 = $this$PathData_u24lambda_u2d0$iv$iv$iv;
        $this$_get_PlayArrow__u24lambda_u242_u24lambda_u240.moveTo(10.0f, 8.64f);
        $this$_get_PlayArrow__u24lambda_u242_u24lambda_u240.verticalLineToRelative(6.72f);
        $this$_get_PlayArrow__u24lambda_u242_u24lambda_u240.lineTo(15.27f, 12.0f);
        $this$_get_PlayArrow__u24lambda_u242_u24lambda_u240.close();
        List<PathNode> nodes = $this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes();
        ImageVector.Builder.m3873addPathoIyEayM$default($this$_get_PlayArrow__u24lambda_u242, nodes, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3190getBlack0d7_KjU(), (DefaultConstructorMarker) null), 0.3f, (Brush) null, 0.3f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int strokeLineCap$iv$iv2 = StrokeCap.Companion.m3547getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.Companion.m3557getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        PathBuilder $this$_get_PlayArrow__u24lambda_u242_u24lambda_u241 = $this$PathData_u24lambda_u2d0$iv$iv$iv2;
        $this$_get_PlayArrow__u24lambda_u242_u24lambda_u241.moveTo(8.0f, 19.0f);
        $this$_get_PlayArrow__u24lambda_u242_u24lambda_u241.lineToRelative(11.0f, -7.0f);
        $this$_get_PlayArrow__u24lambda_u242_u24lambda_u241.lineTo(8.0f, 5.0f);
        $this$_get_PlayArrow__u24lambda_u242_u24lambda_u241.verticalLineToRelative(14.0f);
        $this$_get_PlayArrow__u24lambda_u242_u24lambda_u241.close();
        $this$_get_PlayArrow__u24lambda_u242_u24lambda_u241.moveTo(10.0f, 8.64f);
        $this$_get_PlayArrow__u24lambda_u242_u24lambda_u241.lineTo(15.27f, 12.0f);
        $this$_get_PlayArrow__u24lambda_u242_u24lambda_u241.lineTo(10.0f, 15.36f);
        $this$_get_PlayArrow__u24lambda_u242_u24lambda_u241.lineTo(10.0f, 8.64f);
        $this$_get_PlayArrow__u24lambda_u242_u24lambda_u241.close();
        List<PathNode> nodes2 = $this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes();
        ImageVector build = ImageVector.Builder.m3873addPathoIyEayM$default($this$_get_PlayArrow__u24lambda_u242, nodes2, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3190getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv2, strokeLineJoin$iv$iv2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _playArrow = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
