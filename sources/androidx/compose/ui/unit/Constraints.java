package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 02\u00020\u0001:\u00010B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J>\u0010#\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u001a\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b+\u0010\tJ\u000f\u0010,\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u000b8FX\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000b8FX\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\u000b8FX\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\rR\u0011\u0010\u001a\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\tR\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\tR\u0011\u0010\u001e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\tR\u0011\u0010 \u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b!\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u0012\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"Landroidx/compose/ui/unit/Constraints;", "", "value", "", "constructor-impl", "(J)J", "focusIndex", "", "getFocusIndex-impl", "(J)I", "hasBoundedHeight", "", "getHasBoundedHeight-impl", "(J)Z", "hasBoundedWidth", "getHasBoundedWidth-impl", "hasFixedHeight", "getHasFixedHeight$annotations", "()V", "getHasFixedHeight-impl", "hasFixedWidth", "getHasFixedWidth$annotations", "getHasFixedWidth-impl", "isZero", "isZero$annotations", "isZero-impl", "maxHeight", "getMaxHeight-impl", "maxWidth", "getMaxWidth-impl", "minHeight", "getMinHeight-impl", "minWidth", "getMinWidth-impl", "getValue$annotations", "copy", "copy-Zbe2FdA", "(JIIII)J", "equals", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: Constraints.kt */
public final class Constraints {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long FocusMask = 3;
    private static final int[] HeightMask = {MinNonFocusMask, MaxNonFocusMask, 65535, MaxFocusMask};
    public static final int Infinity = Integer.MAX_VALUE;
    private static final int MaxFocusBits = 18;
    private static final long MaxFocusHeight = 3;
    private static final int MaxFocusMask = 262143;
    private static final long MaxFocusWidth = 1;
    private static final int MaxNonFocusBits = 13;
    private static final int MaxNonFocusMask = 8191;
    private static final int MinFocusBits = 16;
    private static final long MinFocusHeight = 2;
    private static final int MinFocusMask = 65535;
    private static final long MinFocusWidth = 0;
    /* access modifiers changed from: private */
    public static final int[] MinHeightOffsets = {18, 20, 17, 15};
    private static final int MinNonFocusBits = 15;
    private static final int MinNonFocusMask = 32767;
    private static final int[] WidthMask = {65535, MaxFocusMask, MinNonFocusMask, MaxNonFocusMask};
    private final long value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Constraints m5918boximpl(long j) {
        return new Constraints(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m5919constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5922equalsimpl(long j, Object obj) {
        return (obj instanceof Constraints) && j == ((Constraints) obj).m5936unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5923equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getHasFixedHeight$annotations() {
    }

    public static /* synthetic */ void getHasFixedWidth$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5933hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public static /* synthetic */ void isZero$annotations() {
    }

    public boolean equals(Object obj) {
        return m5922equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5933hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m5936unboximpl() {
        return this.value;
    }

    private /* synthetic */ Constraints(long value2) {
        this.value = value2;
    }

    /* renamed from: getFocusIndex-impl  reason: not valid java name */
    private static final int m5924getFocusIndeximpl(long arg0) {
        return (int) (3 & arg0);
    }

    /* renamed from: getMinWidth-impl  reason: not valid java name */
    public static final int m5932getMinWidthimpl(long arg0) {
        return ((int) (arg0 >> MinFocusHeight)) & WidthMask[m5924getFocusIndeximpl(arg0)];
    }

    /* renamed from: getMaxWidth-impl  reason: not valid java name */
    public static final int m5930getMaxWidthimpl(long arg0) {
        int width = ((int) (arg0 >> 33)) & WidthMask[m5924getFocusIndeximpl(arg0)];
        if (width == 0) {
            return Integer.MAX_VALUE;
        }
        return width - 1;
    }

    /* renamed from: getMinHeight-impl  reason: not valid java name */
    public static final int m5931getMinHeightimpl(long arg0) {
        int focus = m5924getFocusIndeximpl(arg0);
        return ((int) (arg0 >> MinHeightOffsets[focus])) & HeightMask[focus];
    }

    /* renamed from: getMaxHeight-impl  reason: not valid java name */
    public static final int m5929getMaxHeightimpl(long arg0) {
        int focus = m5924getFocusIndeximpl(arg0);
        int height = ((int) (arg0 >> (MinHeightOffsets[focus] + 31))) & HeightMask[focus];
        if (height == 0) {
            return Integer.MAX_VALUE;
        }
        return height - 1;
    }

    /* renamed from: getHasBoundedWidth-impl  reason: not valid java name */
    public static final boolean m5926getHasBoundedWidthimpl(long arg0) {
        return (((int) (arg0 >> 33)) & WidthMask[m5924getFocusIndeximpl(arg0)]) != 0;
    }

    /* renamed from: getHasBoundedHeight-impl  reason: not valid java name */
    public static final boolean m5925getHasBoundedHeightimpl(long arg0) {
        int focus = m5924getFocusIndeximpl(arg0);
        return (((int) (arg0 >> (MinHeightOffsets[focus] + 31))) & HeightMask[focus]) != 0;
    }

    /* renamed from: getHasFixedWidth-impl  reason: not valid java name */
    public static final boolean m5928getHasFixedWidthimpl(long arg0) {
        return m5930getMaxWidthimpl(arg0) == m5932getMinWidthimpl(arg0);
    }

    /* renamed from: getHasFixedHeight-impl  reason: not valid java name */
    public static final boolean m5927getHasFixedHeightimpl(long arg0) {
        return m5929getMaxHeightimpl(arg0) == m5931getMinHeightimpl(arg0);
    }

    /* renamed from: isZero-impl  reason: not valid java name */
    public static final boolean m5934isZeroimpl(long arg0) {
        return m5930getMaxWidthimpl(arg0) == 0 || m5929getMaxHeightimpl(arg0) == 0;
    }

    /* renamed from: copy-Zbe2FdA$default  reason: not valid java name */
    public static /* synthetic */ long m5921copyZbe2FdA$default(long j, int i, int i2, int i3, int i4, int i5, Object obj) {
        int i6;
        int i7;
        int i8;
        int i9;
        if ((i5 & 1) != 0) {
            i6 = m5932getMinWidthimpl(j);
        } else {
            i6 = i;
        }
        if ((i5 & 2) != 0) {
            i7 = m5930getMaxWidthimpl(j);
        } else {
            i7 = i2;
        }
        if ((i5 & 4) != 0) {
            i8 = m5931getMinHeightimpl(j);
        } else {
            i8 = i3;
        }
        if ((i5 & 8) != 0) {
            i9 = m5929getMaxHeightimpl(j);
        } else {
            i9 = i4;
        }
        return m5920copyZbe2FdA(j, i6, i7, i8, i9);
    }

    /* renamed from: copy-Zbe2FdA  reason: not valid java name */
    public static final long m5920copyZbe2FdA(long arg0, int minWidth, int maxWidth, int minHeight, int maxHeight) {
        boolean z = true;
        if (minHeight >= 0 && minWidth >= 0) {
            if (maxWidth >= minWidth || maxWidth == Integer.MAX_VALUE) {
                if (maxHeight < minHeight && maxHeight != Integer.MAX_VALUE) {
                    z = false;
                }
                if (z) {
                    return Companion.m5937createConstraintsZbe2FdA$ui_unit_release(minWidth, maxWidth, minHeight, maxHeight);
                }
                throw new IllegalArgumentException(("maxHeight(" + maxHeight + ") must be >= minHeight(" + minHeight + ')').toString());
            }
            throw new IllegalArgumentException(("maxWidth(" + maxWidth + ") must be >= minWidth(" + minWidth + ')').toString());
        }
        throw new IllegalArgumentException(("minHeight(" + minHeight + ") and minWidth(" + minWidth + ") must be >= 0").toString());
    }

    public String toString() {
        return m5935toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5935toStringimpl(long arg0) {
        int maxWidth = m5930getMaxWidthimpl(arg0);
        String maxHeightStr = "Infinity";
        String maxWidthStr = maxWidth == Integer.MAX_VALUE ? maxHeightStr : String.valueOf(maxWidth);
        int maxHeight = m5929getMaxHeightimpl(arg0);
        if (maxHeight != Integer.MAX_VALUE) {
            maxHeightStr = String.valueOf(maxHeight);
        }
        return "Constraints(minWidth = " + m5932getMinWidthimpl(arg0) + ", maxWidth = " + maxWidthStr + ", minHeight = " + m5931getMinHeightimpl(arg0) + ", maxHeight = " + maxHeightStr + ')';
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002J8\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001f\u0010 J(\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b$\u0010%J \u0010&\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b'\u0010(J \u0010)\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b*\u0010(R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006+"}, d2 = {"Landroidx/compose/ui/unit/Constraints$Companion;", "", "()V", "FocusMask", "", "HeightMask", "", "Infinity", "", "MaxFocusBits", "MaxFocusHeight", "MaxFocusMask", "MaxFocusWidth", "MaxNonFocusBits", "MaxNonFocusMask", "MinFocusBits", "MinFocusHeight", "MinFocusMask", "MinFocusWidth", "MinHeightOffsets", "MinNonFocusBits", "MinNonFocusMask", "WidthMask", "bitsNeedForSize", "size", "createConstraints", "Landroidx/compose/ui/unit/Constraints;", "minWidth", "maxWidth", "minHeight", "maxHeight", "createConstraints-Zbe2FdA$ui_unit_release", "(IIII)J", "fixed", "width", "height", "fixed-JhjzzOo", "(II)J", "fixedHeight", "fixedHeight-OenEA2s", "(I)J", "fixedWidth", "fixedWidth-OenEA2s", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Constraints.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: fixed-JhjzzOo  reason: not valid java name */
        public final long m5938fixedJhjzzOo(int width, int height) {
            if (width >= 0 && height >= 0) {
                return m5937createConstraintsZbe2FdA$ui_unit_release(width, width, height, height);
            }
            throw new IllegalArgumentException(("width(" + width + ") and height(" + height + ") must be >= 0").toString());
        }

        /* renamed from: fixedWidth-OenEA2s  reason: not valid java name */
        public final long m5940fixedWidthOenEA2s(int width) {
            if (width >= 0) {
                return m5937createConstraintsZbe2FdA$ui_unit_release(width, width, 0, Integer.MAX_VALUE);
            }
            throw new IllegalArgumentException(("width(" + width + ") must be >= 0").toString());
        }

        /* renamed from: fixedHeight-OenEA2s  reason: not valid java name */
        public final long m5939fixedHeightOenEA2s(int height) {
            if (height >= 0) {
                return m5937createConstraintsZbe2FdA$ui_unit_release(0, Integer.MAX_VALUE, height, height);
            }
            throw new IllegalArgumentException(("height(" + height + ") must be >= 0").toString());
        }

        /* renamed from: createConstraints-Zbe2FdA$ui_unit_release  reason: not valid java name */
        public final long m5937createConstraintsZbe2FdA$ui_unit_release(int minWidth, int maxWidth, int minHeight, int maxHeight) {
            long focus;
            int i = maxWidth;
            int i2 = maxHeight;
            int heightVal = i2 == Integer.MAX_VALUE ? minHeight : i2;
            int heightBits = bitsNeedForSize(heightVal);
            int widthVal = i == Integer.MAX_VALUE ? minWidth : i;
            int widthBits = bitsNeedForSize(widthVal);
            if (widthBits + heightBits <= 31) {
                switch (widthBits) {
                    case 13:
                        focus = 3;
                        break;
                    case 15:
                        focus = Constraints.MinFocusHeight;
                        break;
                    case 16:
                        focus = 0;
                        break;
                    case 18:
                        focus = Constraints.MaxFocusWidth;
                        break;
                    default:
                        throw new IllegalStateException("Should only have the provided constants.");
                }
                int i3 = 0;
                int maxWidthValue = i == Integer.MAX_VALUE ? 0 : i + 1;
                if (i2 != Integer.MAX_VALUE) {
                    i3 = i2 + 1;
                }
                int maxHeightValue = i3;
                int minHeightOffset = Constraints.MinHeightOffsets[(int) focus];
                int i4 = widthBits;
                long j = focus;
                return Constraints.m5919constructorimpl((((long) maxWidthValue) << 33) | (((long) minWidth) << Constraints.MinFocusHeight) | focus | (((long) minHeight) << minHeightOffset) | (((long) maxHeightValue) << (minHeightOffset + 31)));
            }
            throw new IllegalArgumentException("Can't represent a width of " + widthVal + " and height of " + heightVal + " in Constraints");
        }

        private final int bitsNeedForSize(int size) {
            if (size < Constraints.MaxNonFocusMask) {
                return 13;
            }
            if (size < Constraints.MinNonFocusMask) {
                return 15;
            }
            if (size < 65535) {
                return 16;
            }
            if (size < Constraints.MaxFocusMask) {
                return 18;
            }
            throw new IllegalArgumentException("Can't represent a size of " + size + " in Constraints");
        }
    }
}
