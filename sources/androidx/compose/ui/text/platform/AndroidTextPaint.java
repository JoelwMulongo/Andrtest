package androidx.compose.ui.text.platform;

import android.graphics.Shader;
import android.text.TextPaint;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J/\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0005ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u001f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010-\u001a\u00020\u001f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010.\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dR4\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f*\u0004\b\n\u0010\u000bR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u00158\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006/"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidTextPaint;", "Landroid/text/TextPaint;", "flags", "", "density", "", "(IF)V", "<set-?>", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU$delegate", "(Landroidx/compose/ui/text/platform/AndroidTextPaint;)Ljava/lang/Object;", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "composePaint", "Landroidx/compose/ui/graphics/Paint;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "getShadow$ui_text_release$annotations", "()V", "getShadow$ui_text_release", "()Landroidx/compose/ui/graphics/Shadow;", "setShadow$ui_text_release", "(Landroidx/compose/ui/graphics/Shadow;)V", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "setBrush", "", "brush", "Landroidx/compose/ui/graphics/Brush;", "size", "Landroidx/compose/ui/geometry/Size;", "alpha", "setBrush-12SF9DM", "(Landroidx/compose/ui/graphics/Brush;JF)V", "setColor", "color", "Landroidx/compose/ui/graphics/Color;", "setColor-8_81llA", "(J)V", "setDrawStyle", "setShadow", "setTextDecoration", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidTextPaint.android.kt */
public final class AndroidTextPaint extends TextPaint {
    private final Paint composePaint = AndroidPaint_androidKt.toComposePaint(this);
    private DrawStyle drawStyle;
    private Shadow shadow = Shadow.Companion.getNone();
    private TextDecoration textDecoration = TextDecoration.Companion.getNone();

    public static /* synthetic */ void getShadow$ui_text_release$annotations() {
    }

    public AndroidTextPaint(int flags, float density) {
        super(flags);
        this.density = density;
    }

    public final Shadow getShadow$ui_text_release() {
        return this.shadow;
    }

    public final void setShadow$ui_text_release(Shadow shadow2) {
        Intrinsics.checkNotNullParameter(shadow2, "<set-?>");
        this.shadow = shadow2;
    }

    public final void setTextDecoration(TextDecoration textDecoration2) {
        if (textDecoration2 != null && !Intrinsics.areEqual((Object) this.textDecoration, (Object) textDecoration2)) {
            this.textDecoration = textDecoration2;
            setUnderlineText(textDecoration2.contains(TextDecoration.Companion.getUnderline()));
            setStrikeThruText(this.textDecoration.contains(TextDecoration.Companion.getLineThrough()));
        }
    }

    public final void setShadow(Shadow shadow2) {
        if (shadow2 != null && !Intrinsics.areEqual((Object) this.shadow, (Object) shadow2)) {
            this.shadow = shadow2;
            if (Intrinsics.areEqual((Object) shadow2, (Object) Shadow.Companion.getNone())) {
                clearShadowLayer();
            } else {
                setShadowLayer(TextPaintExtensions_androidKt.correctBlurRadius(this.shadow.getBlurRadius()), Offset.m2915getXimpl(this.shadow.m3517getOffsetF1C5BW0()), Offset.m2916getYimpl(this.shadow.m3517getOffsetF1C5BW0()), ColorKt.m3218toArgb8_81llA(this.shadow.m3516getColor0d7_KjU()));
            }
        }
    }

    /* renamed from: setColor-8_81llA  reason: not valid java name */
    public final void m5716setColor8_81llA(long color) {
        if (color != Color.Companion.m3200getUnspecified0d7_KjU()) {
            this.composePaint.m3427setColor8_81llA(color);
            this.composePaint.setShader((Shader) null);
        }
    }

    /* renamed from: setBrush-12SF9DM$default  reason: not valid java name */
    public static /* synthetic */ void m5712setBrush12SF9DM$default(AndroidTextPaint androidTextPaint, Brush brush, long j, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            f = Float.NaN;
        }
        androidTextPaint.m5715setBrush12SF9DM(brush, j, f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        if (r1 != false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        r0 = r7.composePaint;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        if (java.lang.Float.isNaN(r11) == false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003b, code lost:
        r1 = r7.composePaint.getAlpha();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r1 = kotlin.ranges.RangesKt.coerceIn(r11, 0.0f, 1.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        r8.m3101applyToPq9zytI(r9, r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        if ((((androidx.compose.ui.graphics.SolidColor) r8).m3529getValue0d7_KjU() != androidx.compose.ui.graphics.Color.Companion.m3200getUnspecified0d7_KjU() ? 1 : 0) == 0) goto L_0x001d;
     */
    /* renamed from: setBrush-12SF9DM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m5715setBrush12SF9DM(androidx.compose.ui.graphics.Brush r8, long r9, float r11) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.compose.ui.graphics.SolidColor
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001d
            r0 = r8
            androidx.compose.ui.graphics.SolidColor r0 = (androidx.compose.ui.graphics.SolidColor) r0
            long r3 = r0.m3529getValue0d7_KjU()
            r0 = 0
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.Companion
            long r5 = r5.m3200getUnspecified0d7_KjU()
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x001a
            r0 = r1
            goto L_0x001b
        L_0x001a:
            r0 = r2
        L_0x001b:
            if (r0 != 0) goto L_0x0031
        L_0x001d:
            boolean r0 = r8 instanceof androidx.compose.ui.graphics.ShaderBrush
            if (r0 == 0) goto L_0x004d
            r3 = r9
            r0 = 0
            androidx.compose.ui.geometry.Size$Companion r5 = androidx.compose.ui.geometry.Size.Companion
            long r5 = r5.m2992getUnspecifiedNHjbRc()
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r1 = r2
        L_0x002f:
            if (r1 == 0) goto L_0x004d
        L_0x0031:
            androidx.compose.ui.graphics.Paint r0 = r7.composePaint
            boolean r1 = java.lang.Float.isNaN(r11)
            if (r1 == 0) goto L_0x0042
            androidx.compose.ui.graphics.Paint r1 = r7.composePaint
            float r1 = r1.getAlpha()
            goto L_0x0049
        L_0x0042:
            r1 = 0
            r2 = 1065353216(0x3f800000, float:1.0)
            float r1 = kotlin.ranges.RangesKt.coerceIn((float) r11, (float) r1, (float) r2)
        L_0x0049:
            r8.m3101applyToPq9zytI(r9, r0, r1)
            goto L_0x0055
        L_0x004d:
            if (r8 != 0) goto L_0x0055
            androidx.compose.ui.graphics.Paint r0 = r7.composePaint
            r1 = 0
            r0.setShader(r1)
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidTextPaint.m5715setBrush12SF9DM(androidx.compose.ui.graphics.Brush, long, float):void");
    }

    public final void setDrawStyle(DrawStyle drawStyle2) {
        if (drawStyle2 != null && !Intrinsics.areEqual((Object) this.drawStyle, (Object) drawStyle2)) {
            this.drawStyle = drawStyle2;
            if (Intrinsics.areEqual((Object) drawStyle2, (Object) Fill.INSTANCE)) {
                this.composePaint.m3431setStylek9PVt8s(PaintingStyle.Companion.m3439getFillTiuSbCo());
            } else if (drawStyle2 instanceof Stroke) {
                this.composePaint.m3431setStylek9PVt8s(PaintingStyle.Companion.m3440getStrokeTiuSbCo());
                this.composePaint.setStrokeWidth(((Stroke) drawStyle2).getWidth());
                this.composePaint.setStrokeMiterLimit(((Stroke) drawStyle2).getMiter());
                this.composePaint.m3430setStrokeJoinWw9F2mQ(((Stroke) drawStyle2).m3853getJoinLxFBmk8());
                this.composePaint.m3429setStrokeCapBeK7IIE(((Stroke) drawStyle2).m3852getCapKaPHkGw());
                this.composePaint.setPathEffect(((Stroke) drawStyle2).getPathEffect());
            }
        }
    }

    /* renamed from: getBlendMode-0nO6VwU$delegate  reason: not valid java name */
    private static Object m5711getBlendMode0nO6VwU$delegate(AndroidTextPaint androidTextPaint) {
        return Reflection.mutableProperty0(new MutablePropertyReference0Impl(androidTextPaint.composePaint, Paint.class, "blendMode", "getBlendMode-0nO6VwU()I", 0));
    }

    /* renamed from: getBlendMode-0nO6VwU  reason: not valid java name */
    public final int m5713getBlendMode0nO6VwU() {
        return this.composePaint.m3420getBlendMode0nO6VwU();
    }

    /* renamed from: setBlendMode-s9anfk8  reason: not valid java name */
    public final void m5714setBlendModes9anfk8(int i) {
        this.composePaint.m3426setBlendModes9anfk8(i);
    }
}
