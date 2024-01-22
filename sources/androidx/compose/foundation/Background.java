package androidx.compose.foundation;

import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BK\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\f\u0010\u001f\u001a\u00020\u000e*\u00020 H\u0016J\f\u0010!\u001a\u00020\u000e*\u00020 H\u0002J\f\u0010\"\u001a\u00020\u000e*\u00020 H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/foundation/Background;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "color", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "lastLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastOutline", "Landroidx/compose/ui/graphics/Outline;", "lastSize", "Landroidx/compose/ui/geometry/Size;", "equals", "", "other", "", "hashCode", "", "toString", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawOutline", "drawRect", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Background.kt */
final class Background extends InspectorValueInfo implements DrawModifier {
    private final float alpha;
    private final Brush brush;
    private final Color color;
    private LayoutDirection lastLayoutDirection;
    private Outline lastOutline;
    private Size lastSize;
    private final Shape shape;

    public /* synthetic */ Background(Color color2, Brush brush2, float f, Shape shape2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(color2, brush2, f, shape2, function1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Background(androidx.compose.ui.graphics.Color r9, androidx.compose.ui.graphics.Brush r10, float r11, androidx.compose.ui.graphics.Shape r12, kotlin.jvm.functions.Function1 r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r8 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r2 = r0
            goto L_0x0008
        L_0x0007:
            r2 = r9
        L_0x0008:
            r9 = r14 & 2
            if (r9 == 0) goto L_0x000e
            r3 = r0
            goto L_0x000f
        L_0x000e:
            r3 = r10
        L_0x000f:
            r9 = r14 & 4
            if (r9 == 0) goto L_0x0017
            r11 = 1065353216(0x3f800000, float:1.0)
            r4 = r11
            goto L_0x0018
        L_0x0017:
            r4 = r11
        L_0x0018:
            r7 = 0
            r1 = r8
            r5 = r12
            r6 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.Background.<init>(androidx.compose.ui.graphics.Color, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Shape, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private Background(Color color2, Brush brush2, float alpha2, Shape shape2, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        this.color = color2;
        this.brush = brush2;
        this.alpha = alpha2;
        this.shape = shape2;
    }

    public void draw(ContentDrawScope $this$draw) {
        Intrinsics.checkNotNullParameter($this$draw, "<this>");
        if (this.shape == RectangleShapeKt.getRectangleShape()) {
            drawRect($this$draw);
        } else {
            drawOutline($this$draw);
        }
        $this$draw.drawContent();
    }

    private final void drawRect(ContentDrawScope $this$drawRect) {
        Color color2 = this.color;
        if (color2 != null) {
            DrawScope.m3748drawRectnJ9OG0$default($this$drawRect, color2.m3174unboximpl(), 0, 0, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 126, (Object) null);
        }
        Brush it = this.brush;
        if (it != null) {
            DrawScope.m3747drawRectAsUm42w$default($this$drawRect, it, 0, 0, this.alpha, (DrawStyle) null, (ColorFilter) null, 0, 118, (Object) null);
        }
    }

    private final void drawOutline(ContentDrawScope $this$drawOutline) {
        Outline outline;
        if (!Size.m2979equalsimpl($this$drawOutline.m3772getSizeNHjbRc(), this.lastSize) || $this$drawOutline.getLayoutDirection() != this.lastLayoutDirection) {
            outline = this.shape.m3518createOutlinePq9zytI($this$drawOutline.m3772getSizeNHjbRc(), $this$drawOutline.getLayoutDirection(), $this$drawOutline);
        } else {
            outline = this.lastOutline;
            Intrinsics.checkNotNull(outline);
        }
        Color color2 = this.color;
        if (color2 != null) {
            long r11 = color2.m3174unboximpl();
            OutlineKt.m3419drawOutlinewDX37Ww$default($this$drawOutline, outline, this.color.m3174unboximpl(), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
        }
        Brush brush2 = this.brush;
        if (brush2 != null) {
            Brush brush3 = brush2;
            OutlineKt.m3417drawOutlinehn5TExg$default($this$drawOutline, outline, brush2, this.alpha, (DrawStyle) null, (ColorFilter) null, 0, 56, (Object) null);
        }
        this.lastOutline = outline;
        this.lastSize = Size.m2972boximpl($this$drawOutline.m3772getSizeNHjbRc());
        this.lastLayoutDirection = $this$drawOutline.getLayoutDirection();
    }

    public int hashCode() {
        Color color2 = this.color;
        int i = 0;
        int r2 = (color2 != null ? Color.m3171hashCodeimpl(color2.m3174unboximpl()) : 0) * 31;
        Brush brush2 = this.brush;
        if (brush2 != null) {
            i = brush2.hashCode();
        }
        return ((((r2 + i) * 31) + Float.hashCode(this.alpha)) * 31) + this.shape.hashCode();
    }

    public boolean equals(Object other) {
        Background otherModifier = other instanceof Background ? (Background) other : null;
        if (otherModifier == null || !Intrinsics.areEqual((Object) this.color, (Object) otherModifier.color) || !Intrinsics.areEqual((Object) this.brush, (Object) otherModifier.brush)) {
            return false;
        }
        if (!(this.alpha == otherModifier.alpha) || !Intrinsics.areEqual((Object) this.shape, (Object) otherModifier.shape)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "Background(color=" + this.color + ", brush=" + this.brush + ", alpha = " + this.alpha + ", shape=" + this.shape + ')';
    }
}
