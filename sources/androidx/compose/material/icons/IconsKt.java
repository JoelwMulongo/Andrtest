package androidx.compose.material.icons;

import androidx.autofill.HintConstants;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a-\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\bø\u0001\u0000\u001aT\u0010\f\u001a\u00020\n*\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\t¢\u0006\u0002\b\u000bH\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u0002\u0012\n\u0005\b20\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"MaterialIconDimension", "", "getMaterialIconDimension$annotations", "()V", "materialIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "name", "", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "Lkotlin/ExtensionFunctionType;", "materialPath", "fillAlpha", "strokeAlpha", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "pathBuilder", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "", "materialPath-YwgOQQI", "(Landroidx/compose/ui/graphics/vector/ImageVector$Builder;FFILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Icons.kt */
public final class IconsKt {
    public static final float MaterialIconDimension = 24.0f;

    public static /* synthetic */ void getMaterialIconDimension$annotations() {
    }

    public static final ImageVector materialIcon(String name, Function1<? super ImageVector.Builder, ImageVector.Builder> block) {
        Intrinsics.checkNotNullParameter(name, HintConstants.AUTOFILL_HINT_NAME);
        Intrinsics.checkNotNullParameter(block, "block");
        return block.invoke(new ImageVector.Builder(name, Dp.m5986constructorimpl(24.0f), Dp.m5986constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, (DefaultConstructorMarker) null)).build();
    }

    /* renamed from: materialPath-YwgOQQI$default  reason: not valid java name */
    public static /* synthetic */ ImageVector.Builder m1698materialPathYwgOQQI$default(ImageVector.Builder $this$materialPath_u2dYwgOQQI_u24default, float fillAlpha, float strokeAlpha, int pathFillType, Function1 pathBuilder, int i, Object obj) {
        float fillAlpha2;
        float strokeAlpha2;
        int pathFillType2;
        Function1 function1 = pathBuilder;
        if ((i & 1) != 0) {
            fillAlpha2 = 1.0f;
        } else {
            fillAlpha2 = fillAlpha;
        }
        if ((i & 2) != 0) {
            strokeAlpha2 = 1.0f;
        } else {
            strokeAlpha2 = strokeAlpha;
        }
        if ((i & 4) != 0) {
            pathFillType2 = VectorKt.getDefaultFillType();
        } else {
            pathFillType2 = pathFillType;
        }
        Intrinsics.checkNotNullParameter($this$materialPath_u2dYwgOQQI_u24default, "$this$materialPath");
        Intrinsics.checkNotNullParameter(function1, "pathBuilder");
        int strokeLineCap$iv = StrokeCap.Companion.m3547getButtKaPHkGw();
        int strokeLineJoin$iv = StrokeJoin.Companion.m3557getBevelLxFBmk8();
        ImageVector.Builder $this$path_u2dR_LF_u2d3I_u24default$iv = $this$materialPath_u2dYwgOQQI_u24default;
        String str = "";
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv = new PathBuilder();
        function1.invoke($this$PathData_u24lambda_u2d0$iv$iv);
        return ImageVector.Builder.m3873addPathoIyEayM$default($this$path_u2dR_LF_u2d3I_u24default$iv, $this$PathData_u24lambda_u2d0$iv$iv.getNodes(), pathFillType2, str, new SolidColor(Color.Companion.m3190getBlack0d7_KjU(), (DefaultConstructorMarker) null), fillAlpha2, (Brush) null, strokeAlpha2, 1.0f, strokeLineCap$iv, strokeLineJoin$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
    }

    /* renamed from: materialPath-YwgOQQI  reason: not valid java name */
    public static final ImageVector.Builder m1697materialPathYwgOQQI(ImageVector.Builder $this$materialPath_u2dYwgOQQI, float fillAlpha, float strokeAlpha, int pathFillType, Function1<? super PathBuilder, Unit> pathBuilder) {
        Function1<? super PathBuilder, Unit> function1 = pathBuilder;
        int i = pathFillType;
        Intrinsics.checkNotNullParameter($this$materialPath_u2dYwgOQQI, "$this$materialPath");
        Intrinsics.checkNotNullParameter(function1, "pathBuilder");
        Brush fill$iv = new SolidColor(Color.Companion.m3190getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        int strokeLineCap$iv = StrokeCap.Companion.m3547getButtKaPHkGw();
        int strokeLineJoin$iv = StrokeJoin.Companion.m3557getBevelLxFBmk8();
        ImageVector.Builder $this$path_u2dR_LF_u2d3I_u24default$iv = $this$materialPath_u2dYwgOQQI;
        String str = "";
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv = new PathBuilder();
        function1.invoke($this$PathData_u24lambda_u2d0$iv$iv);
        return ImageVector.Builder.m3873addPathoIyEayM$default($this$path_u2dR_LF_u2d3I_u24default$iv, $this$PathData_u24lambda_u2d0$iv$iv.getNodes(), i, str, fill$iv, fillAlpha, (Brush) null, strokeAlpha, 1.0f, strokeLineCap$iv, strokeLineJoin$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
    }
}
