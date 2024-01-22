package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.DegreesKt;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aH\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000b\u001ah\u0010\f\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a$\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\bH\bø\u0001\u0000\u001a1\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000\u001a=\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000\u001aI\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000\u001aH\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001aH\u0010\u001f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b!\u0010\u001e\u001aH\u0010\"\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b#\u0010\u001e\u001aP\u0010\"\u001a\u00020\u0001*\u00020\u00022\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b&\u0010'\u001a=\u0010(\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000\u001aB\u0010)\u001a\u00020\u0001*\u00020\u00022\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\t2\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000\u0002\u0012\n\u0005\b20\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006-"}, d2 = {"clipPath", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "clipPath-KD09W0M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;ILkotlin/jvm/functions/Function1;)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-rOu3jXo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFFILkotlin/jvm/functions/Function1;)V", "drawIntoCanvas", "Landroidx/compose/ui/graphics/Canvas;", "inset", "horizontal", "vertical", "rotate", "degrees", "pivot", "Landroidx/compose/ui/geometry/Offset;", "rotate-Rg1IO4c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJLkotlin/jvm/functions/Function1;)V", "rotateRad", "radians", "rotateRad-Rg1IO4c", "scale", "scale-Rg1IO4c", "scaleX", "scaleY", "scale-Fgt4K4Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLkotlin/jvm/functions/Function1;)V", "translate", "withTransform", "transformBlock", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "drawBlock", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DrawScope.kt */
public final class DrawScopeKt {
    public static final void inset(DrawScope $this$inset, float left, float top, float right, float bottom, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter($this$inset, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        $this$inset.getDrawContext().getTransform().inset(left, top, right, bottom);
        block.invoke($this$inset);
        $this$inset.getDrawContext().getTransform().inset(-left, -top, -right, -bottom);
    }

    public static final void inset(DrawScope $this$inset, float inset, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter($this$inset, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        $this$inset.getDrawContext().getTransform().inset(inset, inset, inset, inset);
        block.invoke($this$inset);
        $this$inset.getDrawContext().getTransform().inset(-inset, -inset, -inset, -inset);
    }

    public static /* synthetic */ void inset$default(DrawScope $this$inset_u24default, float horizontal, float vertical, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            horizontal = 0.0f;
        }
        if ((i & 2) != 0) {
            vertical = 0.0f;
        }
        Intrinsics.checkNotNullParameter($this$inset_u24default, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawScope $this$inset$iv = $this$inset_u24default;
        $this$inset$iv.getDrawContext().getTransform().inset(horizontal, vertical, horizontal, vertical);
        block.invoke($this$inset$iv);
        $this$inset$iv.getDrawContext().getTransform().inset(-horizontal, -vertical, -horizontal, -vertical);
    }

    public static final void inset(DrawScope $this$inset, float horizontal, float vertical, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter($this$inset, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawScope $this$inset$iv = $this$inset;
        $this$inset$iv.getDrawContext().getTransform().inset(horizontal, vertical, horizontal, vertical);
        block.invoke($this$inset$iv);
        $this$inset$iv.getDrawContext().getTransform().inset(-horizontal, -vertical, -horizontal, -vertical);
    }

    public static /* synthetic */ void translate$default(DrawScope $this$translate_u24default, float left, float top, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            left = 0.0f;
        }
        if ((i & 2) != 0) {
            top = 0.0f;
        }
        Intrinsics.checkNotNullParameter($this$translate_u24default, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        $this$translate_u24default.getDrawContext().getTransform().translate(left, top);
        block.invoke($this$translate_u24default);
        $this$translate_u24default.getDrawContext().getTransform().translate(-left, -top);
    }

    public static final void translate(DrawScope $this$translate, float left, float top, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter($this$translate, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        $this$translate.getDrawContext().getTransform().translate(left, top);
        block.invoke($this$translate);
        $this$translate.getDrawContext().getTransform().translate(-left, -top);
    }

    /* renamed from: rotate-Rg1IO4c$default  reason: not valid java name */
    public static /* synthetic */ void m3814rotateRg1IO4c$default(DrawScope $this$rotate_u2dRg1IO4c_u24default, float degrees, long pivot, Function1 block, int i, Object obj) {
        if ((i & 2) != 0) {
            pivot = $this$rotate_u2dRg1IO4c_u24default.m3771getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter($this$rotate_u2dRg1IO4c_u24default, "$this$rotate");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawScope $this$withTransform$iv = $this$rotate_u2dRg1IO4c_u24default;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        $this$withTransform_u24lambda_u246$iv.getTransform().m3830rotateUv8p0NA(degrees, pivot);
        block.invoke($this$withTransform$iv);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.m3716setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: rotate-Rg1IO4c  reason: not valid java name */
    public static final void m3813rotateRg1IO4c(DrawScope $this$rotate_u2dRg1IO4c, float degrees, long pivot, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter($this$rotate_u2dRg1IO4c, "$this$rotate");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawScope $this$withTransform$iv = $this$rotate_u2dRg1IO4c;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        $this$withTransform_u24lambda_u246$iv.getTransform().m3830rotateUv8p0NA(degrees, pivot);
        block.invoke($this$withTransform$iv);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.m3716setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: rotateRad-Rg1IO4c$default  reason: not valid java name */
    public static /* synthetic */ void m3816rotateRadRg1IO4c$default(DrawScope $this$rotateRad_u2dRg1IO4c_u24default, float radians, long pivot, Function1 block, int i, Object obj) {
        if ((i & 2) != 0) {
            pivot = $this$rotateRad_u2dRg1IO4c_u24default.m3771getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter($this$rotateRad_u2dRg1IO4c_u24default, "$this$rotateRad");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawScope $this$withTransform$iv = $this$rotateRad_u2dRg1IO4c_u24default;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        $this$withTransform_u24lambda_u246$iv.getTransform().m3830rotateUv8p0NA(DegreesKt.degrees(radians), pivot);
        block.invoke($this$withTransform$iv);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.m3716setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: rotateRad-Rg1IO4c  reason: not valid java name */
    public static final void m3815rotateRadRg1IO4c(DrawScope $this$rotateRad_u2dRg1IO4c, float radians, long pivot, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter($this$rotateRad_u2dRg1IO4c, "$this$rotateRad");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawScope $this$withTransform$iv = $this$rotateRad_u2dRg1IO4c;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        $this$withTransform_u24lambda_u246$iv.getTransform().m3830rotateUv8p0NA(DegreesKt.degrees(radians), pivot);
        block.invoke($this$withTransform$iv);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.m3716setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: scale-Fgt4K4Q$default  reason: not valid java name */
    public static /* synthetic */ void m3818scaleFgt4K4Q$default(DrawScope $this$scale_u2dFgt4K4Q_u24default, float scaleX, float scaleY, long pivot, Function1 block, int i, Object obj) {
        if ((i & 4) != 0) {
            pivot = $this$scale_u2dFgt4K4Q_u24default.m3771getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter($this$scale_u2dFgt4K4Q_u24default, "$this$scale");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawScope $this$withTransform$iv = $this$scale_u2dFgt4K4Q_u24default;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        $this$withTransform_u24lambda_u246$iv.getTransform().m3831scale0AR0LA0(scaleX, scaleY, pivot);
        block.invoke($this$withTransform$iv);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.m3716setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: scale-Fgt4K4Q  reason: not valid java name */
    public static final void m3817scaleFgt4K4Q(DrawScope $this$scale_u2dFgt4K4Q, float scaleX, float scaleY, long pivot, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter($this$scale_u2dFgt4K4Q, "$this$scale");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawScope $this$withTransform$iv = $this$scale_u2dFgt4K4Q;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        $this$withTransform_u24lambda_u246$iv.getTransform().m3831scale0AR0LA0(scaleX, scaleY, pivot);
        block.invoke($this$withTransform$iv);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.m3716setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: scale-Rg1IO4c$default  reason: not valid java name */
    public static /* synthetic */ void m3820scaleRg1IO4c$default(DrawScope $this$scale_u2dRg1IO4c_u24default, float scale, long pivot, Function1 block, int i, Object obj) {
        if ((i & 2) != 0) {
            pivot = $this$scale_u2dRg1IO4c_u24default.m3771getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter($this$scale_u2dRg1IO4c_u24default, "$this$scale");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawScope $this$withTransform$iv = $this$scale_u2dRg1IO4c_u24default;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        $this$withTransform_u24lambda_u246$iv.getTransform().m3831scale0AR0LA0(scale, scale, pivot);
        block.invoke($this$withTransform$iv);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.m3716setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: scale-Rg1IO4c  reason: not valid java name */
    public static final void m3819scaleRg1IO4c(DrawScope $this$scale_u2dRg1IO4c, float scale, long pivot, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter($this$scale_u2dRg1IO4c, "$this$scale");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawScope $this$withTransform$iv = $this$scale_u2dRg1IO4c;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        $this$withTransform_u24lambda_u246$iv.getTransform().m3831scale0AR0LA0(scale, scale, pivot);
        block.invoke($this$withTransform$iv);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.m3716setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: clipRect-rOu3jXo$default  reason: not valid java name */
    public static /* synthetic */ void m3812clipRectrOu3jXo$default(DrawScope $this$clipRect_u2drOu3jXo_u24default, float left, float top, float right, float bottom, int clipOp, Function1 block, int i, Object obj) {
        float left2;
        float top2;
        float right2;
        float bottom2;
        int clipOp2;
        Function1 function1 = block;
        if ((i & 1) != 0) {
            left2 = 0.0f;
        } else {
            left2 = left;
        }
        if ((i & 2) != 0) {
            top2 = 0.0f;
        } else {
            top2 = top;
        }
        if ((i & 4) != 0) {
            right2 = Size.m2984getWidthimpl($this$clipRect_u2drOu3jXo_u24default.m3772getSizeNHjbRc());
        } else {
            right2 = right;
        }
        if ((i & 8) != 0) {
            bottom2 = Size.m2981getHeightimpl($this$clipRect_u2drOu3jXo_u24default.m3772getSizeNHjbRc());
        } else {
            bottom2 = bottom;
        }
        if ((i & 16) != 0) {
            clipOp2 = ClipOp.Companion.m3153getIntersectrtfAjoo();
        } else {
            clipOp2 = clipOp;
        }
        Intrinsics.checkNotNullParameter($this$clipRect_u2drOu3jXo_u24default, "$this$clipRect");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawScope $this$withTransform$iv = $this$clipRect_u2drOu3jXo_u24default;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawContext $this$withTransform_u24lambda_u246$iv2 = $this$withTransform_u24lambda_u246$iv;
        $this$withTransform_u24lambda_u246$iv.getTransform().m3827clipRectN_I0leg(left2, top2, right2, bottom2, clipOp2);
        function1.invoke($this$withTransform$iv);
        $this$withTransform_u24lambda_u246$iv2.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv2.m3716setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: clipRect-rOu3jXo  reason: not valid java name */
    public static final void m3811clipRectrOu3jXo(DrawScope $this$clipRect_u2drOu3jXo, float left, float top, float right, float bottom, int clipOp, Function1<? super DrawScope, Unit> block) {
        Function1<? super DrawScope, Unit> function1 = block;
        Intrinsics.checkNotNullParameter($this$clipRect_u2drOu3jXo, "$this$clipRect");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawScope $this$withTransform$iv = $this$clipRect_u2drOu3jXo;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        $this$withTransform_u24lambda_u246$iv.getTransform().m3827clipRectN_I0leg(left, top, right, bottom, clipOp);
        function1.invoke($this$withTransform$iv);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.m3716setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: clipPath-KD09W0M$default  reason: not valid java name */
    public static /* synthetic */ void m3810clipPathKD09W0M$default(DrawScope $this$clipPath_u2dKD09W0M_u24default, Path path, int clipOp, Function1 block, int i, Object obj) {
        if ((i & 2) != 0) {
            clipOp = ClipOp.Companion.m3153getIntersectrtfAjoo();
        }
        Intrinsics.checkNotNullParameter($this$clipPath_u2dKD09W0M_u24default, "$this$clipPath");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawScope $this$withTransform$iv = $this$clipPath_u2dKD09W0M_u24default;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        $this$withTransform_u24lambda_u246$iv.getTransform().m3826clipPathmtrdDE(path, clipOp);
        block.invoke($this$withTransform$iv);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.m3716setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: clipPath-KD09W0M  reason: not valid java name */
    public static final void m3809clipPathKD09W0M(DrawScope $this$clipPath_u2dKD09W0M, Path path, int clipOp, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter($this$clipPath_u2dKD09W0M, "$this$clipPath");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawScope $this$withTransform$iv = $this$clipPath_u2dKD09W0M;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        $this$withTransform_u24lambda_u246$iv.getTransform().m3826clipPathmtrdDE(path, clipOp);
        block.invoke($this$withTransform$iv);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.m3716setSizeuvyYCjk(previousSize$iv);
    }

    public static final void drawIntoCanvas(DrawScope $this$drawIntoCanvas, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter($this$drawIntoCanvas, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke($this$drawIntoCanvas.getDrawContext().getCanvas());
    }

    public static final void withTransform(DrawScope $this$withTransform, Function1<? super DrawTransform, Unit> transformBlock, Function1<? super DrawScope, Unit> drawBlock) {
        Intrinsics.checkNotNullParameter($this$withTransform, "<this>");
        Intrinsics.checkNotNullParameter(transformBlock, "transformBlock");
        Intrinsics.checkNotNullParameter(drawBlock, "drawBlock");
        DrawContext $this$withTransform_u24lambda_u246 = $this$withTransform.getDrawContext();
        long previousSize = $this$withTransform_u24lambda_u246.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246.getCanvas().save();
        transformBlock.invoke($this$withTransform_u24lambda_u246.getTransform());
        drawBlock.invoke($this$withTransform);
        $this$withTransform_u24lambda_u246.getCanvas().restore();
        $this$withTransform_u24lambda_u246.m3716setSizeuvyYCjk(previousSize);
    }
}
