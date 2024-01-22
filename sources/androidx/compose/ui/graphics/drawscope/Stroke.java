package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB<\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/Stroke;", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "width", "", "miter", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "join", "Landroidx/compose/ui/graphics/StrokeJoin;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "(FFIILandroidx/compose/ui/graphics/PathEffect;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCap-KaPHkGw", "()I", "I", "getJoin-LxFBmk8", "getMiter", "()F", "getPathEffect", "()Landroidx/compose/ui/graphics/PathEffect;", "getWidth", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DrawScope.kt */
public final class Stroke extends DrawStyle {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int DefaultCap = StrokeCap.Companion.m3547getButtKaPHkGw();
    /* access modifiers changed from: private */
    public static final int DefaultJoin = StrokeJoin.Companion.m3558getMiterLxFBmk8();
    public static final float DefaultMiter = 4.0f;
    public static final float HairlineWidth = 0.0f;
    private final int cap;
    private final int join;
    private final float miter;
    private final PathEffect pathEffect;
    private final float width;

    public /* synthetic */ Stroke(float f, float f2, int i, int i2, PathEffect pathEffect2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, i, i2, pathEffect2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Stroke(float r8, float r9, int r10, int r11, androidx.compose.ui.graphics.PathEffect r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x0007
            r8 = 0
            r1 = r8
            goto L_0x0008
        L_0x0007:
            r1 = r8
        L_0x0008:
            r8 = r13 & 2
            if (r8 == 0) goto L_0x0010
            r9 = 1082130432(0x40800000, float:4.0)
            r2 = r9
            goto L_0x0011
        L_0x0010:
            r2 = r9
        L_0x0011:
            r8 = r13 & 4
            if (r8 == 0) goto L_0x0019
            int r10 = DefaultCap
            r3 = r10
            goto L_0x001a
        L_0x0019:
            r3 = r10
        L_0x001a:
            r8 = r13 & 8
            if (r8 == 0) goto L_0x0022
            int r11 = DefaultJoin
            r4 = r11
            goto L_0x0023
        L_0x0022:
            r4 = r11
        L_0x0023:
            r8 = r13 & 16
            if (r8 == 0) goto L_0x002a
            r12 = 0
            r5 = r12
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r6 = 0
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.drawscope.Stroke.<init>(float, float, int, int, androidx.compose.ui.graphics.PathEffect, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getMiter() {
        return this.miter;
    }

    /* renamed from: getCap-KaPHkGw  reason: not valid java name */
    public final int m3852getCapKaPHkGw() {
        return this.cap;
    }

    /* renamed from: getJoin-LxFBmk8  reason: not valid java name */
    public final int m3853getJoinLxFBmk8() {
        return this.join;
    }

    public final PathEffect getPathEffect() {
        return this.pathEffect;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXT¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/Stroke$Companion;", "", "()V", "DefaultCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getDefaultCap-KaPHkGw", "()I", "I", "DefaultJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getDefaultJoin-LxFBmk8", "DefaultMiter", "", "HairlineWidth", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DrawScope.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getDefaultCap-KaPHkGw  reason: not valid java name */
        public final int m3854getDefaultCapKaPHkGw() {
            return Stroke.DefaultCap;
        }

        /* renamed from: getDefaultJoin-LxFBmk8  reason: not valid java name */
        public final int m3855getDefaultJoinLxFBmk8() {
            return Stroke.DefaultJoin;
        }
    }

    private Stroke(float width2, float miter2, int cap2, int join2, PathEffect pathEffect2) {
        super((DefaultConstructorMarker) null);
        this.width = width2;
        this.miter = miter2;
        this.cap = cap2;
        this.join = join2;
        this.pathEffect = pathEffect2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Stroke)) {
            return false;
        }
        if (!(this.width == ((Stroke) other).width)) {
            return false;
        }
        if ((this.miter == ((Stroke) other).miter) && StrokeCap.m3543equalsimpl0(this.cap, ((Stroke) other).cap) && StrokeJoin.m3553equalsimpl0(this.join, ((Stroke) other).join) && Intrinsics.areEqual((Object) this.pathEffect, (Object) ((Stroke) other).pathEffect)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = ((((((Float.hashCode(this.width) * 31) + Float.hashCode(this.miter)) * 31) + StrokeCap.m3544hashCodeimpl(this.cap)) * 31) + StrokeJoin.m3554hashCodeimpl(this.join)) * 31;
        PathEffect pathEffect2 = this.pathEffect;
        return result + (pathEffect2 != null ? pathEffect2.hashCode() : 0);
    }

    public String toString() {
        return "Stroke(width=" + this.width + ", miter=" + this.miter + ", cap=" + StrokeCap.m3545toStringimpl(this.cap) + ", join=" + StrokeJoin.m3555toStringimpl(this.join) + ", pathEffect=" + this.pathEffect + ')';
    }
}
