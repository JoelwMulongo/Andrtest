package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0005EFGHIB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020$H\u0007J-\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b.J%\u0010/\u001a\u00020&2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b0J-\u00101\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b2J-\u00103\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b4J-\u00105\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b6J-\u00107\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b8J\u001d\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020;H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010=J%\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;2\u0006\u0010\"\u001a\u00020#H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010?J%\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020;2\u0006\u0010\"\u001a\u00020$H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010@J/\u0010A\u001a\u00020&*\u00020*2\u0006\u0010B\u001a\u00020-2\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020&0DH\bR\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\fR\u001c\u0010\u0015\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\fR\u001c\u0010\u0018\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\fR\u001c\u0010\u001b\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\u0011R\u001c\u0010\u001e\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006J"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement;", "", "()V", "Bottom", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getBottom$annotations", "getBottom", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Center", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "getCenter$annotations", "getCenter", "()Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "End", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getEnd$annotations", "getEnd", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "SpaceAround", "getSpaceAround$annotations", "getSpaceAround", "SpaceBetween", "getSpaceBetween$annotations", "getSpaceBetween", "SpaceEvenly", "getSpaceEvenly$annotations", "getSpaceEvenly", "Start", "getStart$annotations", "getStart", "Top", "getTop$annotations", "getTop", "aligned", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "Landroidx/compose/ui/Alignment$Vertical;", "placeCenter", "", "totalSize", "", "size", "", "outPosition", "reverseInput", "", "placeCenter$foundation_layout_release", "placeLeftOrTop", "placeLeftOrTop$foundation_layout_release", "placeRightOrBottom", "placeRightOrBottom$foundation_layout_release", "placeSpaceAround", "placeSpaceAround$foundation_layout_release", "placeSpaceBetween", "placeSpaceBetween$foundation_layout_release", "placeSpaceEvenly", "placeSpaceEvenly$foundation_layout_release", "spacedBy", "space", "Landroidx/compose/ui/unit/Dp;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacedBy-D5KLDUw", "(FLandroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "(FLandroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/foundation/layout/Arrangement$Vertical;", "forEachIndexed", "reversed", "action", "Lkotlin/Function2;", "Absolute", "Horizontal", "HorizontalOrVertical", "SpacedAligned", "Vertical", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Arrangement.kt */
public final class Arrangement {
    public static final int $stable = 0;
    private static final Vertical Bottom = new Arrangement$Bottom$1();
    private static final HorizontalOrVertical Center = new Arrangement$Center$1();
    private static final Horizontal End = new Arrangement$End$1();
    public static final Arrangement INSTANCE = new Arrangement();
    private static final HorizontalOrVertical SpaceAround = new Arrangement$SpaceAround$1();
    private static final HorizontalOrVertical SpaceBetween = new Arrangement$SpaceBetween$1();
    private static final HorizontalOrVertical SpaceEvenly = new Arrangement$SpaceEvenly$1();
    private static final Horizontal Start = new Arrangement$Start$1();
    private static final Vertical Top = new Arrangement$Top$1();

    public static /* synthetic */ void getBottom$annotations() {
    }

    public static /* synthetic */ void getCenter$annotations() {
    }

    public static /* synthetic */ void getEnd$annotations() {
    }

    public static /* synthetic */ void getSpaceAround$annotations() {
    }

    public static /* synthetic */ void getSpaceBetween$annotations() {
    }

    public static /* synthetic */ void getSpaceEvenly$annotations() {
    }

    public static /* synthetic */ void getStart$annotations() {
    }

    public static /* synthetic */ void getTop$annotations() {
    }

    private Arrangement() {
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J,\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH&R\u001d\u0010\u0002\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0003\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Arrangement.kt */
    public interface Horizontal {
        void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2);

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* compiled from: Arrangement.kt */
        public static final class DefaultImpls {
            @Deprecated
            /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
            public static float m686getSpacingD9Ej5fM(Horizontal $this) {
                return Horizontal.super.m685getSpacingD9Ej5fM();
            }
        }

        /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
        float m685getSpacingD9Ej5fM() {
            return Dp.m5986constructorimpl((float) 0);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J$\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&R\u001d\u0010\u0002\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0003\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Vertical;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Arrangement.kt */
    public interface Vertical {
        void arrange(Density density, int i, int[] iArr, int[] iArr2);

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* compiled from: Arrangement.kt */
        public static final class DefaultImpls {
            @Deprecated
            /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
            public static float m700getSpacingD9Ej5fM(Vertical $this) {
                return Vertical.super.m699getSpacingD9Ej5fM();
            }
        }

        /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
        float m699getSpacingD9Ej5fM() {
            return Dp.m5986constructorimpl((float) 0);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u0002R\u001d\u0010\u0003\u001a\u00020\u00048VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0003\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Arrangement.kt */
    public interface HorizontalOrVertical extends Horizontal, Vertical {

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* compiled from: Arrangement.kt */
        public static final class DefaultImpls {
            @Deprecated
            /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
            public static float m689getSpacingD9Ej5fM(HorizontalOrVertical $this) {
                return HorizontalOrVertical.super.m688getSpacingD9Ej5fM();
            }
        }

        /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
        float m688getSpacingD9Ej5fM() {
            return Dp.m5986constructorimpl((float) 0);
        }
    }

    public final Horizontal getStart() {
        return Start;
    }

    public final Horizontal getEnd() {
        return End;
    }

    public final Vertical getTop() {
        return Top;
    }

    public final Vertical getBottom() {
        return Bottom;
    }

    public final HorizontalOrVertical getCenter() {
        return Center;
    }

    public final HorizontalOrVertical getSpaceEvenly() {
        return SpaceEvenly;
    }

    public final HorizontalOrVertical getSpaceBetween() {
        return SpaceBetween;
    }

    public final HorizontalOrVertical getSpaceAround() {
        return SpaceAround;
    }

    /* renamed from: spacedBy-0680j_4  reason: not valid java name */
    public final HorizontalOrVertical m677spacedBy0680j_4(float space) {
        return new SpacedAligned(space, true, Arrangement$spacedBy$1.INSTANCE, (DefaultConstructorMarker) null);
    }

    /* renamed from: spacedBy-D5KLDUw  reason: not valid java name */
    public final Horizontal m678spacedByD5KLDUw(float space, Alignment.Horizontal alignment) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return new SpacedAligned(space, true, new Arrangement$spacedBy$2(alignment), (DefaultConstructorMarker) null);
    }

    /* renamed from: spacedBy-D5KLDUw  reason: not valid java name */
    public final Vertical m679spacedByD5KLDUw(float space, Alignment.Vertical alignment) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return new SpacedAligned(space, false, new Arrangement$spacedBy$3(alignment), (DefaultConstructorMarker) null);
    }

    public final Horizontal aligned(Alignment.Horizontal alignment) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return new SpacedAligned(Dp.m5986constructorimpl((float) 0), true, new Arrangement$aligned$1(alignment), (DefaultConstructorMarker) null);
    }

    public final Vertical aligned(Alignment.Vertical alignment) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return new SpacedAligned(Dp.m5986constructorimpl((float) 0), false, new Arrangement$aligned$2(alignment), (DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u001d\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ%\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!J%\u0010\u001a\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020#H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010$R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006%"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Absolute;", "", "()V", "Center", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getCenter$annotations", "getCenter", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Left", "getLeft$annotations", "getLeft", "Right", "getRight$annotations", "getRight", "SpaceAround", "getSpaceAround$annotations", "getSpaceAround", "SpaceBetween", "getSpaceBetween$annotations", "getSpaceBetween", "SpaceEvenly", "getSpaceEvenly$annotations", "getSpaceEvenly", "aligned", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "spacedBy", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "space", "Landroidx/compose/ui/unit/Dp;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacedBy-D5KLDUw", "(FLandroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Landroidx/compose/ui/Alignment$Vertical;", "(FLandroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/foundation/layout/Arrangement$Vertical;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Arrangement.kt */
    public static final class Absolute {
        public static final int $stable = 0;
        private static final Horizontal Center = new Arrangement$Absolute$Center$1();
        public static final Absolute INSTANCE = new Absolute();
        private static final Horizontal Left = new Arrangement$Absolute$Left$1();
        private static final Horizontal Right = new Arrangement$Absolute$Right$1();
        private static final Horizontal SpaceAround = new Arrangement$Absolute$SpaceAround$1();
        private static final Horizontal SpaceBetween = new Arrangement$Absolute$SpaceBetween$1();
        private static final Horizontal SpaceEvenly = new Arrangement$Absolute$SpaceEvenly$1();

        public static /* synthetic */ void getCenter$annotations() {
        }

        public static /* synthetic */ void getLeft$annotations() {
        }

        public static /* synthetic */ void getRight$annotations() {
        }

        public static /* synthetic */ void getSpaceAround$annotations() {
        }

        public static /* synthetic */ void getSpaceBetween$annotations() {
        }

        public static /* synthetic */ void getSpaceEvenly$annotations() {
        }

        private Absolute() {
        }

        public final Horizontal getLeft() {
            return Left;
        }

        public final Horizontal getCenter() {
            return Center;
        }

        public final Horizontal getRight() {
            return Right;
        }

        public final Horizontal getSpaceBetween() {
            return SpaceBetween;
        }

        public final Horizontal getSpaceEvenly() {
            return SpaceEvenly;
        }

        public final Horizontal getSpaceAround() {
            return SpaceAround;
        }

        /* renamed from: spacedBy-0680j_4  reason: not valid java name */
        public final HorizontalOrVertical m680spacedBy0680j_4(float space) {
            return new SpacedAligned(space, false, (Function2) null, (DefaultConstructorMarker) null);
        }

        /* renamed from: spacedBy-D5KLDUw  reason: not valid java name */
        public final Horizontal m681spacedByD5KLDUw(float space, Alignment.Horizontal alignment) {
            Intrinsics.checkNotNullParameter(alignment, "alignment");
            return new SpacedAligned(space, false, new Arrangement$Absolute$spacedBy$1(alignment), (DefaultConstructorMarker) null);
        }

        /* renamed from: spacedBy-D5KLDUw  reason: not valid java name */
        public final Vertical m682spacedByD5KLDUw(float space, Alignment.Vertical alignment) {
            Intrinsics.checkNotNullParameter(alignment, "alignment");
            return new SpacedAligned(space, false, new Arrangement$Absolute$spacedBy$2(alignment), (DefaultConstructorMarker) null);
        }

        public final Horizontal aligned(Alignment.Horizontal alignment) {
            Intrinsics.checkNotNullParameter(alignment, "alignment");
            return new SpacedAligned(Dp.m5986constructorimpl((float) 0), false, new Arrangement$Absolute$aligned$1(alignment), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u0014\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0010J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003JH\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\b\u0010\u001f\u001a\u00020 H\u0016J,\u0010!\u001a\u00020\"*\u00020#2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020&H\u0016J$\u0010!\u001a\u00020\"*\u00020#2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016R%\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0012\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "space", "Landroidx/compose/ui/unit/Dp;", "rtlMirror", "", "alignment", "Lkotlin/Function2;", "", "Landroidx/compose/ui/unit/LayoutDirection;", "(FZLkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment", "()Lkotlin/jvm/functions/Function2;", "getRtlMirror", "()Z", "getSpace-D9Ej5fM", "()F", "F", "spacing", "getSpacing-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component3", "copy", "copy-8Feqmps", "(FZLkotlin/jvm/functions/Function2;)Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "equals", "other", "", "hashCode", "toString", "", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "sizes", "", "layoutDirection", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Arrangement.kt */
    public static final class SpacedAligned implements HorizontalOrVertical {
        private final Function2<Integer, LayoutDirection, Integer> alignment;
        private final boolean rtlMirror;
        private final float space;
        private final float spacing;

        public /* synthetic */ SpacedAligned(float f, boolean z, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, z, function2);
        }

        /* renamed from: copy-8Feqmps$default  reason: not valid java name */
        public static /* synthetic */ SpacedAligned m693copy8Feqmps$default(SpacedAligned spacedAligned, float f, boolean z, Function2<Integer, LayoutDirection, Integer> function2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = spacedAligned.space;
            }
            if ((i & 2) != 0) {
                z = spacedAligned.rtlMirror;
            }
            if ((i & 4) != 0) {
                function2 = spacedAligned.alignment;
            }
            return spacedAligned.m695copy8Feqmps(f, z, function2);
        }

        /* renamed from: component1-D9Ej5fM  reason: not valid java name */
        public final float m694component1D9Ej5fM() {
            return this.space;
        }

        public final boolean component2() {
            return this.rtlMirror;
        }

        public final Function2<Integer, LayoutDirection, Integer> component3() {
            return this.alignment;
        }

        /* renamed from: copy-8Feqmps  reason: not valid java name */
        public final SpacedAligned m695copy8Feqmps(float f, boolean z, Function2<? super Integer, ? super LayoutDirection, Integer> function2) {
            return new SpacedAligned(f, z, function2, (DefaultConstructorMarker) null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SpacedAligned)) {
                return false;
            }
            SpacedAligned spacedAligned = (SpacedAligned) obj;
            return Dp.m5991equalsimpl0(this.space, spacedAligned.space) && this.rtlMirror == spacedAligned.rtlMirror && Intrinsics.areEqual((Object) this.alignment, (Object) spacedAligned.alignment);
        }

        public int hashCode() {
            int r1 = Dp.m5992hashCodeimpl(this.space) * 31;
            boolean z = this.rtlMirror;
            if (z) {
                z = true;
            }
            int i = (r1 + (z ? 1 : 0)) * 31;
            Function2<Integer, LayoutDirection, Integer> function2 = this.alignment;
            return i + (function2 == null ? 0 : function2.hashCode());
        }

        private SpacedAligned(float space2, boolean rtlMirror2, Function2<? super Integer, ? super LayoutDirection, Integer> alignment2) {
            this.space = space2;
            this.rtlMirror = rtlMirror2;
            this.alignment = alignment2;
            this.spacing = space2;
        }

        /* renamed from: getSpace-D9Ej5fM  reason: not valid java name */
        public final float m696getSpaceD9Ej5fM() {
            return this.space;
        }

        public final boolean getRtlMirror() {
            return this.rtlMirror;
        }

        public final Function2<Integer, LayoutDirection, Integer> getAlignment() {
            return this.alignment;
        }

        /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
        public float m697getSpacingD9Ej5fM() {
            return this.spacing;
        }

        public void arrange(Density $this$arrange, int totalSize, int[] sizes, LayoutDirection layoutDirection, int[] outPositions) {
            int lastSpace;
            int occupied;
            Density density = $this$arrange;
            int i = totalSize;
            int[] iArr = sizes;
            LayoutDirection layoutDirection2 = layoutDirection;
            int[] iArr2 = outPositions;
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(iArr, "sizes");
            Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
            Intrinsics.checkNotNullParameter(iArr2, "outPositions");
            if (!(iArr.length == 0)) {
                int spacePx = density.m5961roundToPx0680j_4(this.space);
                int occupied2 = 0;
                int lastSpace2 = 0;
                boolean reversed = this.rtlMirror && layoutDirection2 == LayoutDirection.Rtl;
                Arrangement arrangement = Arrangement.INSTANCE;
                int[] $this$forEachIndexed$iv = sizes;
                if (!reversed) {
                    int[] $this$forEachIndexed$iv$iv = $this$forEachIndexed$iv;
                    int length = $this$forEachIndexed$iv$iv.length;
                    int index$iv$iv = 0;
                    lastSpace = 0;
                    occupied = 0;
                    int occupied3 = 0;
                    while (occupied3 < length) {
                        int it = $this$forEachIndexed$iv$iv[occupied3];
                        iArr2[index$iv$iv] = Math.min(occupied, i - it);
                        lastSpace = Math.min(spacePx, (i - iArr2[index$iv$iv]) - it);
                        occupied = iArr2[index$iv$iv] + it + lastSpace;
                        occupied3++;
                        Density density2 = $this$arrange;
                        index$iv$iv++;
                    }
                } else {
                    int i$iv = $this$forEachIndexed$iv.length - 1;
                    while (-1 < i$iv) {
                        int it2 = $this$forEachIndexed$iv[i$iv];
                        int index = i$iv;
                        iArr2[index] = Math.min(occupied2, i - it2);
                        lastSpace2 = Math.min(spacePx, (i - iArr2[index]) - it2);
                        occupied2 = iArr2[index] + it2 + lastSpace2;
                        i$iv--;
                        int[] iArr3 = sizes;
                    }
                    lastSpace = lastSpace2;
                    occupied = occupied2;
                }
                int occupied4 = occupied - lastSpace;
                Function2<Integer, LayoutDirection, Integer> function2 = this.alignment;
                if (function2 != null && occupied4 < i) {
                    int groupPosition = function2.invoke(Integer.valueOf(i - occupied4), layoutDirection2).intValue();
                    int length2 = iArr2.length;
                    for (int index2 = 0; index2 < length2; index2++) {
                        iArr2[index2] = iArr2[index2] + groupPosition;
                    }
                }
            }
        }

        public void arrange(Density $this$arrange, int totalSize, int[] sizes, int[] outPositions) {
            Intrinsics.checkNotNullParameter($this$arrange, "<this>");
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            Intrinsics.checkNotNullParameter(outPositions, "outPositions");
            arrange($this$arrange, totalSize, sizes, LayoutDirection.Ltr, outPositions);
        }

        public String toString() {
            return (this.rtlMirror ? "" : "Absolute") + "Arrangement#spacedAligned(" + Dp.m5997toStringimpl(this.space) + ", " + this.alignment + ')';
        }
    }

    public final void placeRightOrBottom$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        int[] iArr = outPosition;
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(iArr, "outPosition");
        int accumulator$iv = 0;
        int i = 0;
        for (int element$iv : size) {
            accumulator$iv += element$iv;
        }
        int current = totalSize - accumulator$iv;
        int[] $this$forEachIndexed$iv = size;
        if (!reverseInput) {
            int[] $this$forEachIndexed$iv$iv = $this$forEachIndexed$iv;
            int index$iv$iv = 0;
            int length = $this$forEachIndexed$iv$iv.length;
            while (i < length) {
                iArr[index$iv$iv] = current;
                current += $this$forEachIndexed$iv$iv[i];
                i++;
                index$iv$iv++;
            }
            return;
        }
        int i$iv = $this$forEachIndexed$iv.length;
        while (true) {
            i$iv--;
            if (-1 < i$iv) {
                int it = $this$forEachIndexed$iv[i$iv];
                iArr[i$iv] = current;
                current += it;
            } else {
                return;
            }
        }
    }

    public final void placeLeftOrTop$foundation_layout_release(int[] size, int[] outPosition, boolean reverseInput) {
        int[] iArr = outPosition;
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(iArr, "outPosition");
        int current = 0;
        int[] $this$forEachIndexed$iv = size;
        if (!reverseInput) {
            int[] $this$forEachIndexed$iv$iv = $this$forEachIndexed$iv;
            int index$iv$iv = 0;
            int length = $this$forEachIndexed$iv$iv.length;
            int i = 0;
            while (i < length) {
                iArr[index$iv$iv] = current;
                current += $this$forEachIndexed$iv$iv[i];
                i++;
                index$iv$iv++;
            }
            return;
        }
        int i$iv = $this$forEachIndexed$iv.length;
        while (true) {
            i$iv--;
            if (-1 < i$iv) {
                int it = $this$forEachIndexed$iv[i$iv];
                iArr[i$iv] = current;
                current += it;
            } else {
                return;
            }
        }
    }

    public final void placeCenter$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        int[] iArr = outPosition;
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(iArr, "outPosition");
        int accumulator$iv = 0;
        int i = 0;
        for (int element$iv : size) {
            accumulator$iv += element$iv;
        }
        int consumedSize = accumulator$iv;
        float current = ((float) (totalSize - consumedSize)) / ((float) 2);
        int[] $this$forEachIndexed$iv = size;
        if (!reverseInput) {
            int[] $this$forEachIndexed$iv$iv = $this$forEachIndexed$iv;
            int index$iv$iv = 0;
            int length = $this$forEachIndexed$iv$iv.length;
            while (i < length) {
                iArr[index$iv$iv] = MathKt.roundToInt(current);
                current += (float) $this$forEachIndexed$iv$iv[i];
                i++;
                index$iv$iv++;
                consumedSize = consumedSize;
            }
            return;
        }
        int i$iv = $this$forEachIndexed$iv.length;
        while (true) {
            i$iv--;
            if (-1 < i$iv) {
                int it = $this$forEachIndexed$iv[i$iv];
                iArr[i$iv] = MathKt.roundToInt(current);
                current += (float) it;
            } else {
                return;
            }
        }
    }

    public final void placeSpaceEvenly$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        int[] iArr = size;
        int[] iArr2 = outPosition;
        Intrinsics.checkNotNullParameter(iArr, "size");
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int accumulator$iv = 0;
        int i = 0;
        for (int element$iv : size) {
            accumulator$iv += element$iv;
        }
        float gapSize = ((float) (totalSize - accumulator$iv)) / ((float) (iArr.length + 1));
        float current = gapSize;
        int[] $this$forEachIndexed$iv = size;
        if (!reverseInput) {
            int[] $this$forEachIndexed$iv$iv = $this$forEachIndexed$iv;
            int index$iv$iv = 0;
            int length = $this$forEachIndexed$iv$iv.length;
            while (i < length) {
                iArr2[index$iv$iv] = MathKt.roundToInt(current);
                current += ((float) $this$forEachIndexed$iv$iv[i]) + gapSize;
                i++;
                int[] iArr3 = size;
                index$iv$iv++;
            }
            return;
        }
        int i$iv = $this$forEachIndexed$iv.length;
        while (true) {
            i$iv--;
            if (-1 < i$iv) {
                int it = $this$forEachIndexed$iv[i$iv];
                iArr2[i$iv] = MathKt.roundToInt(current);
                current += ((float) it) + gapSize;
            } else {
                return;
            }
        }
    }

    public final void placeSpaceBetween$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        float gapSize;
        int[] iArr = size;
        int[] iArr2 = outPosition;
        Intrinsics.checkNotNullParameter(iArr, "size");
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int accumulator$iv = 0;
        int i = 0;
        for (int element$iv : size) {
            accumulator$iv += element$iv;
        }
        int initial$iv = accumulator$iv;
        if (iArr.length > 1) {
            gapSize = ((float) (totalSize - initial$iv)) / ((float) (iArr.length - 1));
        } else {
            gapSize = 0.0f;
        }
        float current = 0.0f;
        int[] $this$forEachIndexed$iv = size;
        if (!reverseInput) {
            int[] $this$forEachIndexed$iv$iv = $this$forEachIndexed$iv;
            int index$iv$iv = 0;
            int length = $this$forEachIndexed$iv$iv.length;
            while (i < length) {
                iArr2[index$iv$iv] = MathKt.roundToInt(current);
                current += ((float) $this$forEachIndexed$iv$iv[i]) + gapSize;
                i++;
                int[] iArr3 = size;
                index$iv$iv++;
            }
            return;
        }
        for (int i$iv = $this$forEachIndexed$iv.length - 1; -1 < i$iv; i$iv--) {
            int it = $this$forEachIndexed$iv[i$iv];
            iArr2[i$iv] = MathKt.roundToInt(current);
            current += ((float) it) + gapSize;
        }
    }

    public final void placeSpaceAround$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        float gapSize;
        int[] iArr = size;
        int[] iArr2 = outPosition;
        Intrinsics.checkNotNullParameter(iArr, "size");
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int accumulator$iv = 0;
        int i = 0;
        for (int element$iv : size) {
            accumulator$iv += element$iv;
        }
        int initial$iv = accumulator$iv;
        if (!(iArr.length == 0)) {
            gapSize = ((float) (totalSize - initial$iv)) / ((float) iArr.length);
        } else {
            gapSize = 0.0f;
        }
        float current = gapSize / ((float) 2);
        int[] $this$forEachIndexed$iv = size;
        if (!reverseInput) {
            int[] $this$forEachIndexed$iv$iv = $this$forEachIndexed$iv;
            int index$iv$iv = 0;
            int length = $this$forEachIndexed$iv$iv.length;
            while (i < length) {
                iArr2[index$iv$iv] = MathKt.roundToInt(current);
                current += ((float) $this$forEachIndexed$iv$iv[i]) + gapSize;
                i++;
                int[] iArr3 = size;
                index$iv$iv++;
            }
            return;
        }
        for (int i$iv = $this$forEachIndexed$iv.length - 1; -1 < i$iv; i$iv--) {
            int it = $this$forEachIndexed$iv[i$iv];
            iArr2[i$iv] = MathKt.roundToInt(current);
            current += ((float) it) + gapSize;
        }
    }

    private final void forEachIndexed(int[] $this$forEachIndexed, boolean reversed, Function2<? super Integer, ? super Integer, Unit> action) {
        if (!reversed) {
            int[] $this$forEachIndexed$iv = $this$forEachIndexed;
            int index$iv = 0;
            int length = $this$forEachIndexed$iv.length;
            int i = 0;
            while (i < length) {
                action.invoke(Integer.valueOf(index$iv), Integer.valueOf($this$forEachIndexed$iv[i]));
                i++;
                index$iv++;
            }
            return;
        }
        int i2 = $this$forEachIndexed.length;
        while (true) {
            i2--;
            if (-1 < i2) {
                action.invoke(Integer.valueOf(i2), Integer.valueOf($this$forEachIndexed[i2]));
            } else {
                return;
            }
        }
    }
}
