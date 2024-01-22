package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB&\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR'\u0010\u0002\u001a\u00020\u00038\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0010\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000fR'\u0010\u0004\u001a\u00020\u00058\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0010\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/graphics/Shadow;", "", "color", "Landroidx/compose/ui/graphics/Color;", "offset", "Landroidx/compose/ui/geometry/Offset;", "blurRadius", "", "(JJFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBlurRadius$annotations", "()V", "getBlurRadius", "()F", "getColor-0d7_KjU$annotations", "getColor-0d7_KjU", "()J", "J", "getOffset-F1C5BW0$annotations", "getOffset-F1C5BW0", "copy", "copy-qcb84PM", "(JJF)Landroidx/compose/ui/graphics/Shadow;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Shadow.kt */
public final class Shadow {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Shadow None = new Shadow(0, 0, 0.0f, 7, (DefaultConstructorMarker) null);
    private final float blurRadius;
    private final long color;
    private final long offset;

    public /* synthetic */ Shadow(long j, long j2, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, f);
    }

    public static /* synthetic */ void getBlurRadius$annotations() {
    }

    /* renamed from: getColor-0d7_KjU$annotations  reason: not valid java name */
    public static /* synthetic */ void m3513getColor0d7_KjU$annotations() {
    }

    /* renamed from: getOffset-F1C5BW0$annotations  reason: not valid java name */
    public static /* synthetic */ void m3514getOffsetF1C5BW0$annotations() {
    }

    private Shadow(long color2, long offset2, float blurRadius2) {
        this.color = color2;
        this.offset = offset2;
        this.blurRadius = blurRadius2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Shadow(long r8, long r10, float r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x000f
            r8 = 4278190080(0xff000000, double:2.113706745E-314)
            long r8 = androidx.compose.ui.graphics.ColorKt.Color((long) r8)
            r1 = r8
            goto L_0x0010
        L_0x000f:
            r1 = r8
        L_0x0010:
            r8 = r13 & 2
            if (r8 == 0) goto L_0x001c
            androidx.compose.ui.geometry.Offset$Companion r8 = androidx.compose.ui.geometry.Offset.Companion
            long r10 = r8.m2931getZeroF1C5BW0()
            r3 = r10
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r8 = r13 & 4
            if (r8 == 0) goto L_0x0024
            r12 = 0
            r5 = r12
            goto L_0x0025
        L_0x0024:
            r5 = r12
        L_0x0025:
            r6 = 0
            r0 = r7
            r0.<init>(r1, r3, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.Shadow.<init>(long, long, float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m3516getColor0d7_KjU() {
        return this.color;
    }

    /* renamed from: getOffset-F1C5BW0  reason: not valid java name */
    public final long m3517getOffsetF1C5BW0() {
        return this.offset;
    }

    public final float getBlurRadius() {
        return this.blurRadius;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/graphics/Shadow$Companion;", "", "()V", "None", "Landroidx/compose/ui/graphics/Shadow;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/graphics/Shadow;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Shadow.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getNone$annotations() {
        }

        private Companion() {
        }

        public final Shadow getNone() {
            return Shadow.None;
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Shadow) || !Color.m3165equalsimpl0(this.color, ((Shadow) other).color) || !Offset.m2912equalsimpl0(this.offset, ((Shadow) other).offset)) {
            return false;
        }
        if (!(this.blurRadius == ((Shadow) other).blurRadius)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((Color.m3171hashCodeimpl(this.color) * 31) + Offset.m2917hashCodeimpl(this.offset)) * 31) + Float.hashCode(this.blurRadius);
    }

    public String toString() {
        return "Shadow(color=" + Color.m3172toStringimpl(this.color) + ", offset=" + Offset.m2923toStringimpl(this.offset) + ", blurRadius=" + this.blurRadius + ')';
    }

    /* renamed from: copy-qcb84PM$default  reason: not valid java name */
    public static /* synthetic */ Shadow m3512copyqcb84PM$default(Shadow shadow, long j, long j2, float f, int i, Object obj) {
        long j3;
        long j4;
        float f2;
        if ((i & 1) != 0) {
            j3 = shadow.color;
        } else {
            j3 = j;
        }
        if ((i & 2) != 0) {
            j4 = shadow.offset;
        } else {
            j4 = j2;
        }
        if ((i & 4) != 0) {
            f2 = shadow.blurRadius;
        } else {
            f2 = f;
        }
        return shadow.m3515copyqcb84PM(j3, j4, f2);
    }

    /* renamed from: copy-qcb84PM  reason: not valid java name */
    public final Shadow m3515copyqcb84PM(long color2, long offset2, float blurRadius2) {
        return new Shadow(color2, offset2, blurRadius2, (DefaultConstructorMarker) null);
    }
}
