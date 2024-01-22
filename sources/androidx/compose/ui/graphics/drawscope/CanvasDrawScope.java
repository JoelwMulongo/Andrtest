package androidx.compose.ui.graphics.drawscope;

import android.graphics.Shader;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0002JK\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&JI\u0010\u0019\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*Jm\u0010+\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105Jk\u0010+\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00107JR\u00108\u001a\u0002092\u0006\u0010\u0003\u001a\u00020:2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0017\u0010?\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002090@¢\u0006\u0002\bAH\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u0010CJg\u0010D\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bK\u0010LJg\u0010D\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bM\u0010NJO\u0010O\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020J2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bR\u0010SJO\u0010O\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020J2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bT\u0010UJG\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010I\u001a\u00020J2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bY\u0010ZJ_\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\\2\u0006\u0010`\u001a\u00020^2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\ba\u0010bJg\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\\2\u0006\u0010`\u001a\u00020^2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bc\u0010dJa\u0010e\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010f\u001a\u00020J2\u0006\u0010g\u001a\u00020J2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bh\u0010iJa\u0010e\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010f\u001a\u00020J2\u0006\u0010g\u001a\u00020J2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bj\u0010kJO\u0010l\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bm\u0010nJO\u0010l\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bo\u0010pJG\u0010q\u001a\u0002092\u0006\u0010r\u001a\u00020s2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bt\u0010uJG\u0010q\u001a\u0002092\u0006\u0010r\u001a\u00020s2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bv\u0010wJg\u0010x\u001a\u0002092\f\u0010y\u001a\b\u0012\u0004\u0012\u00020J0z2\u0006\u0010{\u001a\u00020|2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b}\u0010~Jh\u0010x\u001a\u0002092\f\u0010y\u001a\b\u0012\u0004\u0012\u00020J0z2\u0006\u0010{\u001a\u00020|2\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u0010\u0001JQ\u0010\u0001\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u0001\u0010nJQ\u0010\u0001\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u0001\u0010pJ\\\u0010\u0001\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\\\u0010\u0001\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\t\u0010\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010\u0001\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u001dH\u0002J$\u0010\u0001\u001a\u00020(*\u00020(2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\f8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000\u0002\u0012\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "()V", "density", "", "getDensity", "()F", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawParams", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "getDrawParams$annotations", "getDrawParams", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "fillPaint", "Landroidx/compose/ui/graphics/Paint;", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "strokePaint", "configurePaint", "brush", "Landroidx/compose/ui/graphics/Brush;", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "alpha", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "configurePaint-swdJneE", "(Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "color", "Landroidx/compose/ui/graphics/Color;", "configurePaint-2qPWKa0", "(JLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configureStrokePaint", "strokeWidth", "miter", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "join", "Landroidx/compose/ui/graphics/StrokeJoin;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "configureStrokePaint-ho4zsrM", "(Landroidx/compose/ui/graphics/Brush;FFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configureStrokePaint-Q_0CZUI", "(JFFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "draw", "", "Landroidx/compose/ui/unit/Density;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "draw-yzxVdVo", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/functions/Function1;)V", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "center", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "obtainFillPaint", "obtainStrokePaint", "selectPaint", "drawStyle", "modulate", "modulate-5vOe2sY", "(JF)J", "DrawParams", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CanvasDrawScope.kt */
public final class CanvasDrawScope implements DrawScope {
    private final DrawContext drawContext = new CanvasDrawScope$drawContext$1(this);
    private final DrawParams drawParams = new DrawParams((Density) null, (LayoutDirection) null, (Canvas) null, 0, 15, (DefaultConstructorMarker) null);
    private Paint fillPaint;
    private Paint strokePaint;

    public static /* synthetic */ void getDrawParams$annotations() {
    }

    public final DrawParams getDrawParams() {
        return this.drawParams;
    }

    public LayoutDirection getLayoutDirection() {
        return this.drawParams.getLayoutDirection();
    }

    public float getDensity() {
        return this.drawParams.getDensity().getDensity();
    }

    public float getFontScale() {
        return this.drawParams.getDensity().getFontScale();
    }

    public DrawContext getDrawContext() {
        return this.drawContext;
    }

    /* renamed from: drawLine-1RTmtNc  reason: not valid java name */
    public void m3659drawLine1RTmtNc(Brush brush, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        this.drawParams.getCanvas().m3136drawLineWko1d7g(start, end, m3649configureStrokePaintho4zsrM$default(this, brush, strokeWidth, 4.0f, cap, StrokeJoin.Companion.m3558getMiterLxFBmk8(), pathEffect, alpha, colorFilter, blendMode, 0, 512, (Object) null));
    }

    /* renamed from: drawLine-NGM6Ib0  reason: not valid java name */
    public void m3660drawLineNGM6Ib0(long color, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().m3136drawLineWko1d7g(start, end, m3647configureStrokePaintQ_0CZUI$default(this, color, strokeWidth, 4.0f, cap, StrokeJoin.Companion.m3558getMiterLxFBmk8(), pathEffect, alpha, colorFilter, blendMode, 0, 512, (Object) null));
    }

    /* renamed from: drawRect-AsUm42w  reason: not valid java name */
    public void m3667drawRectAsUm42w(Brush brush, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.getCanvas().drawRect(Offset.m2915getXimpl(topLeft), Offset.m2916getYimpl(topLeft), Offset.m2915getXimpl(topLeft) + Size.m2984getWidthimpl(size), Offset.m2916getYimpl(topLeft) + Size.m2981getHeightimpl(size), m3645configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, (Object) null));
    }

    /* renamed from: drawRect-n-J9OG0  reason: not valid java name */
    public void m3668drawRectnJ9OG0(long color, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.getCanvas().drawRect(Offset.m2915getXimpl(topLeft), Offset.m2916getYimpl(topLeft), Offset.m2915getXimpl(topLeft) + Size.m2984getWidthimpl(size), Offset.m2916getYimpl(topLeft) + Size.m2981getHeightimpl(size), m3643configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, (Object) null));
    }

    /* renamed from: drawImage-gbVJVH8  reason: not valid java name */
    public void m3658drawImagegbVJVH8(ImageBitmap image, long topLeft, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        ImageBitmap imageBitmap = image;
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.getCanvas().m3134drawImaged4ec7I(image, topLeft, m3645configurePaintswdJneE$default(this, (Brush) null, style, alpha, colorFilter, blendMode, 0, 32, (Object) null));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* renamed from: drawImage-9jGpkUE  reason: not valid java name */
    public /* synthetic */ void m3656drawImage9jGpkUE(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        ImageBitmap imageBitmap = image;
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.getCanvas().m3135drawImageRectHPBpro0(image, srcOffset, srcSize, dstOffset, dstSize, m3645configurePaintswdJneE$default(this, (Brush) null, style, alpha, colorFilter, blendMode, 0, 32, (Object) null));
    }

    /* renamed from: drawImage-AZ2fEMs  reason: not valid java name */
    public void m3657drawImageAZ2fEMs(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
        ImageBitmap imageBitmap = image;
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.getCanvas().m3135drawImageRectHPBpro0(image, srcOffset, srcSize, dstOffset, dstSize, m3644configurePaintswdJneE((Brush) null, style, alpha, colorFilter, blendMode, filterQuality));
    }

    /* renamed from: drawRoundRect-ZuiqVtQ  reason: not valid java name */
    public void m3669drawRoundRectZuiqVtQ(Brush brush, long topLeft, long size, long cornerRadius, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.getCanvas().drawRoundRect(Offset.m2915getXimpl(topLeft), Offset.m2916getYimpl(topLeft), Offset.m2915getXimpl(topLeft) + Size.m2984getWidthimpl(size), Offset.m2916getYimpl(topLeft) + Size.m2981getHeightimpl(size), CornerRadius.m2890getXimpl(cornerRadius), CornerRadius.m2891getYimpl(cornerRadius), m3645configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, (Object) null));
    }

    /* renamed from: drawRoundRect-u-Aw5IA  reason: not valid java name */
    public void m3670drawRoundRectuAw5IA(long color, long topLeft, long size, long cornerRadius, DrawStyle style, float alpha, ColorFilter colorFilter, int blendMode) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.getCanvas().drawRoundRect(Offset.m2915getXimpl(topLeft), Offset.m2916getYimpl(topLeft), Offset.m2915getXimpl(topLeft) + Size.m2984getWidthimpl(size), Offset.m2916getYimpl(topLeft) + Size.m2981getHeightimpl(size), CornerRadius.m2890getXimpl(cornerRadius), CornerRadius.m2891getYimpl(cornerRadius), m3643configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, (Object) null));
    }

    /* renamed from: drawCircle-V9BoPsw  reason: not valid java name */
    public void m3654drawCircleV9BoPsw(Brush brush, float radius, long center, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        Brush brush2 = brush;
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(style, "style");
        float f = radius;
        this.drawParams.getCanvas().m3133drawCircle9KIMszo(center, radius, m3645configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, (Object) null));
    }

    /* renamed from: drawCircle-VaOC9Bg  reason: not valid java name */
    public void m3655drawCircleVaOC9Bg(long color, float radius, long center, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        Intrinsics.checkNotNullParameter(style, "style");
        long j = center;
        this.drawParams.getCanvas().m3133drawCircle9KIMszo(j, radius, m3643configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, (Object) null));
    }

    /* renamed from: drawOval-AsUm42w  reason: not valid java name */
    public void m3661drawOvalAsUm42w(Brush brush, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.getCanvas().drawOval(Offset.m2915getXimpl(topLeft), Offset.m2916getYimpl(topLeft), Offset.m2915getXimpl(topLeft) + Size.m2984getWidthimpl(size), Offset.m2916getYimpl(topLeft) + Size.m2981getHeightimpl(size), m3645configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, (Object) null));
    }

    /* renamed from: drawOval-n-J9OG0  reason: not valid java name */
    public void m3662drawOvalnJ9OG0(long color, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.getCanvas().drawOval(Offset.m2915getXimpl(topLeft), Offset.m2916getYimpl(topLeft), Offset.m2915getXimpl(topLeft) + Size.m2984getWidthimpl(size), Offset.m2916getYimpl(topLeft) + Size.m2981getHeightimpl(size), m3643configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, (Object) null));
    }

    /* renamed from: drawArc-illE91I  reason: not valid java name */
    public void m3652drawArcillE91I(Brush brush, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.getCanvas().drawArc(Offset.m2915getXimpl(topLeft), Offset.m2916getYimpl(topLeft), Offset.m2915getXimpl(topLeft) + Size.m2984getWidthimpl(size), Offset.m2916getYimpl(topLeft) + Size.m2981getHeightimpl(size), startAngle, sweepAngle, useCenter, m3645configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, (Object) null));
    }

    /* renamed from: drawArc-yD3GUKo  reason: not valid java name */
    public void m3653drawArcyD3GUKo(long color, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.getCanvas().drawArc(Offset.m2915getXimpl(topLeft), Offset.m2916getYimpl(topLeft), Offset.m2915getXimpl(topLeft) + Size.m2984getWidthimpl(size), Offset.m2916getYimpl(topLeft) + Size.m2981getHeightimpl(size), startAngle, sweepAngle, useCenter, m3643configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, (Object) null));
    }

    /* renamed from: drawPath-LG529CI  reason: not valid java name */
    public void m3664drawPathLG529CI(Path path, long color, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        Path path2 = path;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.getCanvas().drawPath(path, m3643configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, (Object) null));
    }

    /* renamed from: drawPath-GBMwjPU  reason: not valid java name */
    public void m3663drawPathGBMwjPU(Path path, Brush brush, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        Path path2 = path;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.getCanvas().drawPath(path, m3645configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, (Object) null));
    }

    /* renamed from: drawPoints-F8ZwMP8  reason: not valid java name */
    public void m3665drawPointsF8ZwMP8(List<Offset> points, int pointMode, long color, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        List<Offset> list = points;
        Intrinsics.checkNotNullParameter(list, "points");
        this.drawParams.getCanvas().m3137drawPointsO7TthRY(pointMode, list, m3647configureStrokePaintQ_0CZUI$default(this, color, strokeWidth, 4.0f, cap, StrokeJoin.Companion.m3558getMiterLxFBmk8(), pathEffect, alpha, colorFilter, blendMode, 0, 512, (Object) null));
    }

    /* renamed from: drawPoints-Gsft0Ws  reason: not valid java name */
    public void m3666drawPointsGsft0Ws(List<Offset> points, int pointMode, Brush brush, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        List<Offset> list = points;
        Intrinsics.checkNotNullParameter(list, "points");
        Intrinsics.checkNotNullParameter(brush, "brush");
        this.drawParams.getCanvas().m3137drawPointsO7TthRY(pointMode, list, m3649configureStrokePaintho4zsrM$default(this, brush, strokeWidth, 4.0f, cap, StrokeJoin.Companion.m3558getMiterLxFBmk8(), pathEffect, alpha, colorFilter, blendMode, 0, 512, (Object) null));
    }

    /* renamed from: draw-yzxVdVo  reason: not valid java name */
    public final void m3651drawyzxVdVo(Density density, LayoutDirection layoutDirection, Canvas canvas, long size, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawParams drawParams2 = getDrawParams();
        Density prevDensity = drawParams2.component1();
        LayoutDirection prevLayoutDirection = drawParams2.component2();
        Canvas prevCanvas = drawParams2.component3();
        long prevSize = drawParams2.m3672component4NHjbRc();
        DrawParams $this$draw_yzxVdVo_u24lambda_u240 = getDrawParams();
        $this$draw_yzxVdVo_u24lambda_u240.setDensity(density);
        $this$draw_yzxVdVo_u24lambda_u240.setLayoutDirection(layoutDirection);
        $this$draw_yzxVdVo_u24lambda_u240.setCanvas(canvas);
        $this$draw_yzxVdVo_u24lambda_u240.m3675setSizeuvyYCjk(size);
        canvas.save();
        block.invoke(this);
        canvas.restore();
        DrawParams $this$draw_yzxVdVo_u24lambda_u241 = getDrawParams();
        $this$draw_yzxVdVo_u24lambda_u241.setDensity(prevDensity);
        $this$draw_yzxVdVo_u24lambda_u241.setLayoutDirection(prevLayoutDirection);
        $this$draw_yzxVdVo_u24lambda_u241.setCanvas(prevCanvas);
        $this$draw_yzxVdVo_u24lambda_u241.m3675setSizeuvyYCjk(prevSize);
    }

    private final Paint obtainFillPaint() {
        Paint paint = this.fillPaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint it = Paint;
        it.m3431setStylek9PVt8s(PaintingStyle.Companion.m3439getFillTiuSbCo());
        this.fillPaint = it;
        return Paint;
    }

    private final Paint obtainStrokePaint() {
        Paint paint = this.strokePaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint $this$obtainStrokePaint_u24lambda_u244 = Paint;
        $this$obtainStrokePaint_u24lambda_u244.m3431setStylek9PVt8s(PaintingStyle.Companion.m3440getStrokeTiuSbCo());
        this.strokePaint = $this$obtainStrokePaint_u24lambda_u244;
        return Paint;
    }

    private final Paint selectPaint(DrawStyle drawStyle) {
        if (Intrinsics.areEqual((Object) drawStyle, (Object) Fill.INSTANCE)) {
            return obtainFillPaint();
        }
        if (drawStyle instanceof Stroke) {
            Paint obtainStrokePaint = obtainStrokePaint();
            Paint $this$selectPaint_u24lambda_u246 = obtainStrokePaint;
            boolean z = true;
            if (!($this$selectPaint_u24lambda_u246.getStrokeWidth() == ((Stroke) drawStyle).getWidth())) {
                $this$selectPaint_u24lambda_u246.setStrokeWidth(((Stroke) drawStyle).getWidth());
            }
            if (!StrokeCap.m3543equalsimpl0($this$selectPaint_u24lambda_u246.m3423getStrokeCapKaPHkGw(), ((Stroke) drawStyle).m3852getCapKaPHkGw())) {
                $this$selectPaint_u24lambda_u246.m3429setStrokeCapBeK7IIE(((Stroke) drawStyle).m3852getCapKaPHkGw());
            }
            if ($this$selectPaint_u24lambda_u246.getStrokeMiterLimit() != ((Stroke) drawStyle).getMiter()) {
                z = false;
            }
            if (!z) {
                $this$selectPaint_u24lambda_u246.setStrokeMiterLimit(((Stroke) drawStyle).getMiter());
            }
            if (!StrokeJoin.m3553equalsimpl0($this$selectPaint_u24lambda_u246.m3424getStrokeJoinLxFBmk8(), ((Stroke) drawStyle).m3853getJoinLxFBmk8())) {
                $this$selectPaint_u24lambda_u246.m3430setStrokeJoinWw9F2mQ(((Stroke) drawStyle).m3853getJoinLxFBmk8());
            }
            if (Intrinsics.areEqual((Object) $this$selectPaint_u24lambda_u246.getPathEffect(), (Object) ((Stroke) drawStyle).getPathEffect())) {
                return obtainStrokePaint;
            }
            $this$selectPaint_u24lambda_u246.setPathEffect(((Stroke) drawStyle).getPathEffect());
            return obtainStrokePaint;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: configurePaint-swdJneE$default  reason: not valid java name */
    static /* synthetic */ Paint m3645configurePaintswdJneE$default(CanvasDrawScope canvasDrawScope, Brush brush, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
        return canvasDrawScope.m3644configurePaintswdJneE(brush, drawStyle, f, colorFilter, i, (i3 & 32) != 0 ? DrawScope.Companion.m3774getDefaultFilterQualityfv9h1I() : i2);
    }

    /* renamed from: configurePaint-swdJneE  reason: not valid java name */
    private final Paint m3644configurePaintswdJneE(Brush brush, DrawStyle style, float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        Paint selectPaint = selectPaint(style);
        Paint $this$configurePaint_swdJneE_u24lambda_u247 = selectPaint;
        if (brush != null) {
            brush.m3101applyToPq9zytI(m3772getSizeNHjbRc(), $this$configurePaint_swdJneE_u24lambda_u247, alpha);
        } else {
            if (!($this$configurePaint_swdJneE_u24lambda_u247.getAlpha() == alpha)) {
                $this$configurePaint_swdJneE_u24lambda_u247.setAlpha(alpha);
            }
        }
        if (!Intrinsics.areEqual((Object) $this$configurePaint_swdJneE_u24lambda_u247.getColorFilter(), (Object) colorFilter)) {
            $this$configurePaint_swdJneE_u24lambda_u247.setColorFilter(colorFilter);
        }
        if (!BlendMode.m3066equalsimpl0($this$configurePaint_swdJneE_u24lambda_u247.m3420getBlendMode0nO6VwU(), blendMode)) {
            $this$configurePaint_swdJneE_u24lambda_u247.m3426setBlendModes9anfk8(blendMode);
        }
        if (!FilterQuality.m3254equalsimpl0($this$configurePaint_swdJneE_u24lambda_u247.m3422getFilterQualityfv9h1I(), filterQuality)) {
            $this$configurePaint_swdJneE_u24lambda_u247.m3428setFilterQualityvDHp3xo(filterQuality);
        }
        return selectPaint;
    }

    /* renamed from: configurePaint-2qPWKa0$default  reason: not valid java name */
    static /* synthetic */ Paint m3643configurePaint2qPWKa0$default(CanvasDrawScope canvasDrawScope, long j, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
        return canvasDrawScope.m3642configurePaint2qPWKa0(j, drawStyle, f, colorFilter, i, (i3 & 32) != 0 ? DrawScope.Companion.m3774getDefaultFilterQualityfv9h1I() : i2);
    }

    /* renamed from: configurePaint-2qPWKa0  reason: not valid java name */
    private final Paint m3642configurePaint2qPWKa0(long color, DrawStyle style, float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        Paint selectPaint = selectPaint(style);
        Paint $this$configurePaint_2qPWKa0_u24lambda_u248 = selectPaint;
        long targetColor = m3650modulate5vOe2sY(color, alpha);
        if (!Color.m3165equalsimpl0($this$configurePaint_2qPWKa0_u24lambda_u248.m3421getColor0d7_KjU(), targetColor)) {
            $this$configurePaint_2qPWKa0_u24lambda_u248.m3427setColor8_81llA(targetColor);
        }
        if ($this$configurePaint_2qPWKa0_u24lambda_u248.getShader() != null) {
            $this$configurePaint_2qPWKa0_u24lambda_u248.setShader((Shader) null);
        }
        if (!Intrinsics.areEqual((Object) $this$configurePaint_2qPWKa0_u24lambda_u248.getColorFilter(), (Object) colorFilter)) {
            $this$configurePaint_2qPWKa0_u24lambda_u248.setColorFilter(colorFilter);
        }
        if (!BlendMode.m3066equalsimpl0($this$configurePaint_2qPWKa0_u24lambda_u248.m3420getBlendMode0nO6VwU(), blendMode)) {
            $this$configurePaint_2qPWKa0_u24lambda_u248.m3426setBlendModes9anfk8(blendMode);
        }
        if (!FilterQuality.m3254equalsimpl0($this$configurePaint_2qPWKa0_u24lambda_u248.m3422getFilterQualityfv9h1I(), filterQuality)) {
            $this$configurePaint_2qPWKa0_u24lambda_u248.m3428setFilterQualityvDHp3xo(filterQuality);
        }
        return selectPaint;
    }

    /* renamed from: configureStrokePaint-Q_0CZUI$default  reason: not valid java name */
    static /* synthetic */ Paint m3647configureStrokePaintQ_0CZUI$default(CanvasDrawScope canvasDrawScope, long j, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4, int i5, Object obj) {
        return canvasDrawScope.m3646configureStrokePaintQ_0CZUI(j, f, f2, i, i2, pathEffect, f3, colorFilter, i3, (i5 & 512) != 0 ? DrawScope.Companion.m3774getDefaultFilterQualityfv9h1I() : i4);
    }

    /* renamed from: configureStrokePaint-Q_0CZUI  reason: not valid java name */
    private final Paint m3646configureStrokePaintQ_0CZUI(long color, float strokeWidth, float miter, int cap, int join, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        float f = strokeWidth;
        float f2 = miter;
        int i = cap;
        int i2 = join;
        PathEffect pathEffect2 = pathEffect;
        ColorFilter colorFilter2 = colorFilter;
        int i3 = blendMode;
        int i4 = filterQuality;
        Paint obtainStrokePaint = obtainStrokePaint();
        Paint $this$configureStrokePaint_Q_0CZUI_u24lambda_u249 = obtainStrokePaint;
        Paint paint = obtainStrokePaint;
        long targetColor = m3650modulate5vOe2sY(color, alpha);
        if (!Color.m3165equalsimpl0($this$configureStrokePaint_Q_0CZUI_u24lambda_u249.m3421getColor0d7_KjU(), targetColor)) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.m3427setColor8_81llA(targetColor);
        }
        if ($this$configureStrokePaint_Q_0CZUI_u24lambda_u249.getShader() != null) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.setShader((Shader) null);
        }
        if (!Intrinsics.areEqual((Object) $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.getColorFilter(), (Object) colorFilter2)) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.setColorFilter(colorFilter2);
        }
        if (!BlendMode.m3066equalsimpl0($this$configureStrokePaint_Q_0CZUI_u24lambda_u249.m3420getBlendMode0nO6VwU(), i3)) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.m3426setBlendModes9anfk8(i3);
        }
        boolean z = true;
        if (!($this$configureStrokePaint_Q_0CZUI_u24lambda_u249.getStrokeWidth() == f)) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.setStrokeWidth(f);
        }
        if ($this$configureStrokePaint_Q_0CZUI_u24lambda_u249.getStrokeMiterLimit() != f2) {
            z = false;
        }
        if (!z) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.setStrokeMiterLimit(f2);
        }
        if (!StrokeCap.m3543equalsimpl0($this$configureStrokePaint_Q_0CZUI_u24lambda_u249.m3423getStrokeCapKaPHkGw(), i)) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.m3429setStrokeCapBeK7IIE(i);
        }
        if (!StrokeJoin.m3553equalsimpl0($this$configureStrokePaint_Q_0CZUI_u24lambda_u249.m3424getStrokeJoinLxFBmk8(), i2)) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.m3430setStrokeJoinWw9F2mQ(i2);
        }
        if (!Intrinsics.areEqual((Object) $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.getPathEffect(), (Object) pathEffect2)) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.setPathEffect(pathEffect2);
        }
        long j = targetColor;
        int i5 = filterQuality;
        if (!FilterQuality.m3254equalsimpl0($this$configureStrokePaint_Q_0CZUI_u24lambda_u249.m3422getFilterQualityfv9h1I(), i5)) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.m3428setFilterQualityvDHp3xo(i5);
        }
        return paint;
    }

    /* renamed from: configureStrokePaint-ho4zsrM$default  reason: not valid java name */
    static /* synthetic */ Paint m3649configureStrokePaintho4zsrM$default(CanvasDrawScope canvasDrawScope, Brush brush, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4, int i5, Object obj) {
        return canvasDrawScope.m3648configureStrokePaintho4zsrM(brush, f, f2, i, i2, pathEffect, f3, colorFilter, i3, (i5 & 512) != 0 ? DrawScope.Companion.m3774getDefaultFilterQualityfv9h1I() : i4);
    }

    /* renamed from: configureStrokePaint-ho4zsrM  reason: not valid java name */
    private final Paint m3648configureStrokePaintho4zsrM(Brush brush, float strokeWidth, float miter, int cap, int join, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        Brush brush2 = brush;
        float f = strokeWidth;
        float f2 = miter;
        int i = cap;
        int i2 = join;
        PathEffect pathEffect2 = pathEffect;
        float f3 = alpha;
        ColorFilter colorFilter2 = colorFilter;
        int i3 = blendMode;
        int i4 = filterQuality;
        Paint obtainStrokePaint = obtainStrokePaint();
        Paint $this$configureStrokePaint_ho4zsrM_u24lambda_u2410 = obtainStrokePaint;
        if (brush2 != null) {
            brush2.m3101applyToPq9zytI(m3772getSizeNHjbRc(), $this$configureStrokePaint_ho4zsrM_u24lambda_u2410, f3);
        } else {
            if (!($this$configureStrokePaint_ho4zsrM_u24lambda_u2410.getAlpha() == f3)) {
                $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.setAlpha(f3);
            }
        }
        if (!Intrinsics.areEqual((Object) $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.getColorFilter(), (Object) colorFilter2)) {
            $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.setColorFilter(colorFilter2);
        }
        if (!BlendMode.m3066equalsimpl0($this$configureStrokePaint_ho4zsrM_u24lambda_u2410.m3420getBlendMode0nO6VwU(), i3)) {
            $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.m3426setBlendModes9anfk8(i3);
        }
        if (!($this$configureStrokePaint_ho4zsrM_u24lambda_u2410.getStrokeWidth() == f)) {
            $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.setStrokeWidth(f);
        }
        if (!($this$configureStrokePaint_ho4zsrM_u24lambda_u2410.getStrokeMiterLimit() == f2)) {
            $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.setStrokeMiterLimit(f2);
        }
        if (!StrokeCap.m3543equalsimpl0($this$configureStrokePaint_ho4zsrM_u24lambda_u2410.m3423getStrokeCapKaPHkGw(), i)) {
            $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.m3429setStrokeCapBeK7IIE(i);
        }
        if (!StrokeJoin.m3553equalsimpl0($this$configureStrokePaint_ho4zsrM_u24lambda_u2410.m3424getStrokeJoinLxFBmk8(), i2)) {
            $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.m3430setStrokeJoinWw9F2mQ(i2);
        }
        if (!Intrinsics.areEqual((Object) $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.getPathEffect(), (Object) pathEffect2)) {
            $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.setPathEffect(pathEffect2);
        }
        if (!FilterQuality.m3254equalsimpl0($this$configureStrokePaint_ho4zsrM_u24lambda_u2410.m3422getFilterQualityfv9h1I(), i4)) {
            $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.m3428setFilterQualityvDHp3xo(i4);
        }
        return obtainStrokePaint;
    }

    /* renamed from: modulate-5vOe2sY  reason: not valid java name */
    private final long m3650modulate5vOe2sY(long $this$modulate_u2d5vOe2sY, float alpha) {
        if (alpha == 1.0f) {
            return $this$modulate_u2d5vOe2sY;
        }
        return Color.m3163copywmQWz5c$default($this$modulate_u2d5vOe2sY, Color.m3166getAlphaimpl($this$modulate_u2d5vOe2sY) * alpha, 0.0f, 0.0f, 0.0f, 14, (Object) null);
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B0\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0002\u0010\nJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u0019\u0010\u001f\u001a\u00020\tHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J>\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R%\u0010\b\u001a\u00020\tX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCanvas", "()Landroidx/compose/ui/graphics/Canvas;", "setCanvas", "(Landroidx/compose/ui/graphics/Canvas;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "J", "component1", "component2", "component3", "component4", "component4-NH-jbRc", "copy", "copy-Ug5Nnss", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;J)Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CanvasDrawScope.kt */
    public static final class DrawParams {
        private Canvas canvas;
        private Density density;
        private LayoutDirection layoutDirection;
        private long size;

        public /* synthetic */ DrawParams(Density density2, LayoutDirection layoutDirection2, Canvas canvas2, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(density2, layoutDirection2, canvas2, j);
        }

        /* renamed from: copy-Ug5Nnss$default  reason: not valid java name */
        public static /* synthetic */ DrawParams m3671copyUg5Nnss$default(DrawParams drawParams, Density density2, LayoutDirection layoutDirection2, Canvas canvas2, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                density2 = drawParams.density;
            }
            if ((i & 2) != 0) {
                layoutDirection2 = drawParams.layoutDirection;
            }
            LayoutDirection layoutDirection3 = layoutDirection2;
            if ((i & 4) != 0) {
                canvas2 = drawParams.canvas;
            }
            Canvas canvas3 = canvas2;
            if ((i & 8) != 0) {
                j = drawParams.size;
            }
            return drawParams.m3673copyUg5Nnss(density2, layoutDirection3, canvas3, j);
        }

        public final Density component1() {
            return this.density;
        }

        public final LayoutDirection component2() {
            return this.layoutDirection;
        }

        public final Canvas component3() {
            return this.canvas;
        }

        /* renamed from: component4-NH-jbRc  reason: not valid java name */
        public final long m3672component4NHjbRc() {
            return this.size;
        }

        /* renamed from: copy-Ug5Nnss  reason: not valid java name */
        public final DrawParams m3673copyUg5Nnss(Density density2, LayoutDirection layoutDirection2, Canvas canvas2, long j) {
            Intrinsics.checkNotNullParameter(density2, "density");
            Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
            Intrinsics.checkNotNullParameter(canvas2, "canvas");
            return new DrawParams(density2, layoutDirection2, canvas2, j, (DefaultConstructorMarker) null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrawParams)) {
                return false;
            }
            DrawParams drawParams = (DrawParams) obj;
            return Intrinsics.areEqual((Object) this.density, (Object) drawParams.density) && this.layoutDirection == drawParams.layoutDirection && Intrinsics.areEqual((Object) this.canvas, (Object) drawParams.canvas) && Size.m2980equalsimpl0(this.size, drawParams.size);
        }

        public int hashCode() {
            return (((((this.density.hashCode() * 31) + this.layoutDirection.hashCode()) * 31) + this.canvas.hashCode()) * 31) + Size.m2985hashCodeimpl(this.size);
        }

        public String toString() {
            return "DrawParams(density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", canvas=" + this.canvas + ", size=" + Size.m2988toStringimpl(this.size) + ')';
        }

        private DrawParams(Density density2, LayoutDirection layoutDirection2, Canvas canvas2, long size2) {
            this.density = density2;
            this.layoutDirection = layoutDirection2;
            this.canvas = canvas2;
            this.size = size2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ DrawParams(androidx.compose.ui.unit.Density r8, androidx.compose.ui.unit.LayoutDirection r9, androidx.compose.ui.graphics.Canvas r10, long r11, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
            /*
                r7 = this;
                r14 = r13 & 1
                if (r14 == 0) goto L_0x000a
                androidx.compose.ui.unit.Density r8 = androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt.DefaultDensity
                r1 = r8
                goto L_0x000b
            L_0x000a:
                r1 = r8
            L_0x000b:
                r8 = r13 & 2
                if (r8 == 0) goto L_0x0013
                androidx.compose.ui.unit.LayoutDirection r9 = androidx.compose.ui.unit.LayoutDirection.Ltr
                r2 = r9
                goto L_0x0014
            L_0x0013:
                r2 = r9
            L_0x0014:
                r8 = r13 & 4
                if (r8 == 0) goto L_0x0022
                androidx.compose.ui.graphics.drawscope.EmptyCanvas r8 = new androidx.compose.ui.graphics.drawscope.EmptyCanvas
                r8.<init>()
                r10 = r8
                androidx.compose.ui.graphics.Canvas r10 = (androidx.compose.ui.graphics.Canvas) r10
                r3 = r10
                goto L_0x0023
            L_0x0022:
                r3 = r10
            L_0x0023:
                r8 = r13 & 8
                if (r8 == 0) goto L_0x002f
                androidx.compose.ui.geometry.Size$Companion r8 = androidx.compose.ui.geometry.Size.Companion
                long r11 = r8.m2993getZeroNHjbRc()
                r4 = r11
                goto L_0x0030
            L_0x002f:
                r4 = r11
            L_0x0030:
                r6 = 0
                r0 = r7
                r0.<init>(r1, r2, r3, r4, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.drawscope.CanvasDrawScope.DrawParams.<init>(androidx.compose.ui.unit.Density, androidx.compose.ui.unit.LayoutDirection, androidx.compose.ui.graphics.Canvas, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final Density getDensity() {
            return this.density;
        }

        public final void setDensity(Density density2) {
            Intrinsics.checkNotNullParameter(density2, "<set-?>");
            this.density = density2;
        }

        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public final void setLayoutDirection(LayoutDirection layoutDirection2) {
            Intrinsics.checkNotNullParameter(layoutDirection2, "<set-?>");
            this.layoutDirection = layoutDirection2;
        }

        public final Canvas getCanvas() {
            return this.canvas;
        }

        public final void setCanvas(Canvas canvas2) {
            Intrinsics.checkNotNullParameter(canvas2, "<set-?>");
            this.canvas = canvas2;
        }

        /* renamed from: getSize-NH-jbRc  reason: not valid java name */
        public final long m3674getSizeNHjbRc() {
            return this.size;
        }

        /* renamed from: setSize-uvyYCjk  reason: not valid java name */
        public final void m3675setSizeuvyYCjk(long j) {
            this.size = j;
        }
    }
}
