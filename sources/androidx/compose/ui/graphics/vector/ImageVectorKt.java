package androidx.compose.ui.graphics.vector;

import androidx.autofill.HintConstants;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.vector.ImageVector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\b\u0012H\bø\u0001\u0000\u001a\u0001\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\b\u0012H\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b#\u0010$\u001a'\u0010%\u001a\u0002H&\"\u0004\b\u0000\u0010&*\u0012\u0012\u0004\u0012\u0002H&0'j\b\u0012\u0004\u0012\u0002H&`(H\u0002¢\u0006\u0002\u0010)\u001a'\u0010*\u001a\u0002H&\"\u0004\b\u0000\u0010&*\u0012\u0012\u0004\u0012\u0002H&0'j\b\u0012\u0004\u0012\u0002H&`(H\u0002¢\u0006\u0002\u0010)\u001a/\u0010+\u001a\u00020,\"\u0004\b\u0000\u0010&*\u0012\u0012\u0004\u0012\u0002H&0'j\b\u0012\u0004\u0012\u0002H&`(2\u0006\u0010-\u001a\u0002H&H\u0002¢\u0006\u0002\u0010.\u0002\u0012\n\u0005\b20\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006/"}, d2 = {"group", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "name", "", "rotate", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "path", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "pathBuilder", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "path-R_LF-3I", "(Landroidx/compose/ui/graphics/vector/ImageVector$Builder;Ljava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "peek", "T", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)Ljava/lang/Object;", "pop", "push", "", "value", "(Ljava/util/ArrayList;Ljava/lang/Object;)Z", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ImageVector.kt */
public final class ImageVectorKt {
    /* renamed from: path-R_LF-3I$default  reason: not valid java name */
    public static /* synthetic */ ImageVector.Builder m3876pathR_LF3I$default(ImageVector.Builder $this$path_u2dR_LF_u2d3I_u24default, String name, Brush fill, float fillAlpha, Brush stroke, float strokeAlpha, float strokeLineWidth, int strokeLineCap, int strokeLineJoin, float strokeLineMiter, int pathFillType, Function1 pathBuilder, int i, Object obj) {
        String name2;
        Brush fill2;
        float fillAlpha2;
        Brush stroke2;
        float strokeAlpha2;
        float strokeLineWidth2;
        int strokeLineCap2;
        int strokeLineJoin2;
        float strokeLineMiter2;
        int pathFillType2;
        Function1 function1 = pathBuilder;
        int i2 = i;
        if ((i2 & 1) != 0) {
            name2 = "";
        } else {
            name2 = name;
        }
        if ((i2 & 2) != 0) {
            fill2 = null;
        } else {
            fill2 = fill;
        }
        if ((i2 & 4) != 0) {
            fillAlpha2 = 1.0f;
        } else {
            fillAlpha2 = fillAlpha;
        }
        if ((i2 & 8) != 0) {
            stroke2 = null;
        } else {
            stroke2 = stroke;
        }
        if ((i2 & 16) != 0) {
            strokeAlpha2 = 1.0f;
        } else {
            strokeAlpha2 = strokeAlpha;
        }
        if ((i2 & 32) != 0) {
            strokeLineWidth2 = 0.0f;
        } else {
            strokeLineWidth2 = strokeLineWidth;
        }
        if ((i2 & 64) != 0) {
            strokeLineCap2 = VectorKt.getDefaultStrokeLineCap();
        } else {
            strokeLineCap2 = strokeLineCap;
        }
        if ((i2 & 128) != 0) {
            strokeLineJoin2 = VectorKt.getDefaultStrokeLineJoin();
        } else {
            strokeLineJoin2 = strokeLineJoin;
        }
        if ((i2 & 256) != 0) {
            strokeLineMiter2 = 4.0f;
        } else {
            strokeLineMiter2 = strokeLineMiter;
        }
        if ((i2 & 512) != 0) {
            pathFillType2 = VectorKt.getDefaultFillType();
        } else {
            pathFillType2 = pathFillType;
        }
        Intrinsics.checkNotNullParameter($this$path_u2dR_LF_u2d3I_u24default, "$this$path");
        Intrinsics.checkNotNullParameter(name2, HintConstants.AUTOFILL_HINT_NAME);
        Intrinsics.checkNotNullParameter(function1, "pathBuilder");
        PathBuilder $this$PathData_u24lambda_u240$iv = new PathBuilder();
        function1.invoke($this$PathData_u24lambda_u240$iv);
        return ImageVector.Builder.m3873addPathoIyEayM$default($this$path_u2dR_LF_u2d3I_u24default, $this$PathData_u24lambda_u240$iv.getNodes(), pathFillType2, name2, fill2, fillAlpha2, stroke2, strokeAlpha2, strokeLineWidth2, strokeLineCap2, strokeLineJoin2, strokeLineMiter2, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
    }

    /* renamed from: path-R_LF-3I  reason: not valid java name */
    public static final ImageVector.Builder m3875pathR_LF3I(ImageVector.Builder $this$path_u2dR_LF_u2d3I, String name, Brush fill, float fillAlpha, Brush stroke, float strokeAlpha, float strokeLineWidth, int strokeLineCap, int strokeLineJoin, float strokeLineMiter, int pathFillType, Function1<? super PathBuilder, Unit> pathBuilder) {
        Function1<? super PathBuilder, Unit> function1 = pathBuilder;
        int i = pathFillType;
        Intrinsics.checkNotNullParameter($this$path_u2dR_LF_u2d3I, "$this$path");
        Intrinsics.checkNotNullParameter(name, HintConstants.AUTOFILL_HINT_NAME);
        Intrinsics.checkNotNullParameter(function1, "pathBuilder");
        PathBuilder $this$PathData_u24lambda_u240$iv = new PathBuilder();
        function1.invoke($this$PathData_u24lambda_u240$iv);
        return ImageVector.Builder.m3873addPathoIyEayM$default($this$path_u2dR_LF_u2d3I, $this$PathData_u24lambda_u240$iv.getNodes(), i, name, fill, fillAlpha, stroke, strokeAlpha, strokeLineWidth, strokeLineCap, strokeLineJoin, strokeLineMiter, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
    }

    public static /* synthetic */ ImageVector.Builder group$default(ImageVector.Builder $this$group_u24default, String name, float rotate, float pivotX, float pivotY, float scaleX, float scaleY, float translationX, float translationY, List clipPathData, Function1 block, int i, Object obj) {
        String name2;
        float rotate2;
        float pivotX2;
        float pivotY2;
        float scaleX2;
        float scaleY2;
        float translationX2;
        float translationY2;
        List clipPathData2;
        ImageVector.Builder builder = $this$group_u24default;
        Function1 function1 = block;
        int i2 = i;
        if ((i2 & 1) != 0) {
            name2 = "";
        } else {
            name2 = name;
        }
        if ((i2 & 2) != 0) {
            rotate2 = 0.0f;
        } else {
            rotate2 = rotate;
        }
        if ((i2 & 4) != 0) {
            pivotX2 = 0.0f;
        } else {
            pivotX2 = pivotX;
        }
        if ((i2 & 8) != 0) {
            pivotY2 = 0.0f;
        } else {
            pivotY2 = pivotY;
        }
        if ((i2 & 16) != 0) {
            scaleX2 = 1.0f;
        } else {
            scaleX2 = scaleX;
        }
        if ((i2 & 32) != 0) {
            scaleY2 = 1.0f;
        } else {
            scaleY2 = scaleY;
        }
        if ((i2 & 64) != 0) {
            translationX2 = 0.0f;
        } else {
            translationX2 = translationX;
        }
        if ((i2 & 128) != 0) {
            translationY2 = 0.0f;
        } else {
            translationY2 = translationY;
        }
        if ((i2 & 256) != 0) {
            clipPathData2 = VectorKt.getEmptyPath();
        } else {
            clipPathData2 = clipPathData;
        }
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name2, HintConstants.AUTOFILL_HINT_NAME);
        Intrinsics.checkNotNullParameter(clipPathData2, "clipPathData");
        Intrinsics.checkNotNullParameter(function1, "block");
        ImageVector.Builder $this$group_u24lambda_u240 = $this$group_u24default;
        String str = name2;
        ImageVector.Builder $this$group_u24lambda_u2402 = $this$group_u24lambda_u240;
        $this$group_u24lambda_u240.addGroup(name2, rotate2, pivotX2, pivotY2, scaleX2, scaleY2, translationX2, translationY2, clipPathData2);
        function1.invoke($this$group_u24lambda_u2402);
        $this$group_u24lambda_u2402.clearGroup();
        return builder;
    }

    public static final ImageVector.Builder group(ImageVector.Builder $this$group, String name, float rotate, float pivotX, float pivotY, float scaleX, float scaleY, float translationX, float translationY, List<? extends PathNode> clipPathData, Function1<? super ImageVector.Builder, Unit> block) {
        ImageVector.Builder builder = $this$group;
        Function1<? super ImageVector.Builder, Unit> function1 = block;
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, HintConstants.AUTOFILL_HINT_NAME);
        Intrinsics.checkNotNullParameter(clipPathData, "clipPathData");
        Intrinsics.checkNotNullParameter(function1, "block");
        ImageVector.Builder $this$group_u24lambda_u240 = $this$group;
        $this$group_u24lambda_u240.addGroup(name, rotate, pivotX, pivotY, scaleX, scaleY, translationX, translationY, clipPathData);
        function1.invoke($this$group_u24lambda_u240);
        $this$group_u24lambda_u240.clearGroup();
        return builder;
    }

    /* access modifiers changed from: private */
    public static final <T> boolean push(ArrayList<T> $this$push, T value) {
        return $this$push.add(value);
    }

    /* access modifiers changed from: private */
    public static final <T> T pop(ArrayList<T> $this$pop) {
        return $this$pop.remove($this$pop.size() - 1);
    }

    /* access modifiers changed from: private */
    public static final <T> T peek(ArrayList<T> $this$peek) {
        return $this$peek.get($this$peek.size() - 1);
    }
}
