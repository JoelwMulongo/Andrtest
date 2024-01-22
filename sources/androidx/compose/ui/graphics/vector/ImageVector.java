package androidx.compose.ui.graphics.vector;

import androidx.autofill.HintConstants;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002)*BR\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0013\u0010%\u001a\u00020\u00112\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010'\u001a\u00020(H\u0016R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\f\u001a\u00020\rø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector;", "", "name", "", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "root", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "autoMirror", "", "(Ljava/lang/String;FFFFLandroidx/compose/ui/graphics/vector/VectorGroup;JIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoMirror", "()Z", "getDefaultHeight-D9Ej5fM", "()F", "F", "getDefaultWidth-D9Ej5fM", "getName", "()Ljava/lang/String;", "getRoot", "()Landroidx/compose/ui/graphics/vector/VectorGroup;", "getTintBlendMode-0nO6VwU", "()I", "I", "getTintColor-0d7_KjU", "()J", "J", "getViewportHeight", "getViewportWidth", "equals", "other", "hashCode", "", "Builder", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ImageVector.kt */
public final class ImageVector {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean autoMirror;
    private final float defaultHeight;
    private final float defaultWidth;
    private final String name;
    private final VectorGroup root;
    private final int tintBlendMode;
    private final long tintColor;
    private final float viewportHeight;
    private final float viewportWidth;

    public /* synthetic */ ImageVector(String str, float f, float f2, float f3, float f4, VectorGroup vectorGroup, long j, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f, f2, f3, f4, vectorGroup, j, i, z);
    }

    private ImageVector(String name2, float defaultWidth2, float defaultHeight2, float viewportWidth2, float viewportHeight2, VectorGroup root2, long tintColor2, int tintBlendMode2, boolean autoMirror2) {
        this.name = name2;
        this.defaultWidth = defaultWidth2;
        this.defaultHeight = defaultHeight2;
        this.viewportWidth = viewportWidth2;
        this.viewportHeight = viewportHeight2;
        this.root = root2;
        this.tintColor = tintColor2;
        this.tintBlendMode = tintBlendMode2;
        this.autoMirror = autoMirror2;
    }

    public final String getName() {
        return this.name;
    }

    /* renamed from: getDefaultWidth-D9Ej5fM  reason: not valid java name */
    public final float m3870getDefaultWidthD9Ej5fM() {
        return this.defaultWidth;
    }

    /* renamed from: getDefaultHeight-D9Ej5fM  reason: not valid java name */
    public final float m3869getDefaultHeightD9Ej5fM() {
        return this.defaultHeight;
    }

    public final float getViewportWidth() {
        return this.viewportWidth;
    }

    public final float getViewportHeight() {
        return this.viewportHeight;
    }

    public final VectorGroup getRoot() {
        return this.root;
    }

    /* renamed from: getTintColor-0d7_KjU  reason: not valid java name */
    public final long m3872getTintColor0d7_KjU() {
        return this.tintColor;
    }

    /* renamed from: getTintBlendMode-0nO6VwU  reason: not valid java name */
    public final int m3871getTintBlendMode0nO6VwU() {
        return this.tintBlendMode;
    }

    public final boolean getAutoMirror() {
        return this.autoMirror;
    }

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001DBH\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\rø\u0001\u0000¢\u0006\u0002\u0010\u000eBP\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0002\u0010\u0011Jf\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'J§\u0001\u0010)\u001a\u00020\u00002\f\u0010*\u001a\b\u0012\u0004\u0012\u00020(0'2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010/\u001a\u00020\b2\n\b\u0002\u00100\u001a\u0004\u0018\u00010.2\b\b\u0002\u00101\u001a\u00020\b2\b\b\u0002\u00102\u001a\u00020\b2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\b2\b\b\u0002\u00108\u001a\u00020\b2\b\b\u0002\u00109\u001a\u00020\b2\b\b\u0002\u0010:\u001a\u00020\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020\u0000J\b\u0010@\u001a\u00020AH\u0002J\f\u0010B\u001a\u00020C*\u00020\u0013H\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0006\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0016R\u0019\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0019j\b\u0012\u0004\u0012\u00020\u0013`\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\u00020\rX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001cR\u0019\u0010\n\u001a\u00020\u000bX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006E"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "", "name", "", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "(Ljava/lang/String;FFFFJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "autoMirror", "", "(Ljava/lang/String;FFFFJIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "currentGroup", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "getCurrentGroup", "()Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "F", "isConsumed", "nodes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "root", "I", "J", "addGroup", "rotate", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "addPath", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "addPath-oIyEayM", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFF)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "build", "Landroidx/compose/ui/graphics/vector/ImageVector;", "clearGroup", "ensureNotConsumed", "", "asVectorGroup", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "GroupParams", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ImageVector.kt */
    public static final class Builder {
        public static final int $stable = 8;
        private final boolean autoMirror;
        private final float defaultHeight;
        private final float defaultWidth;
        private boolean isConsumed;
        private final String name;
        private final ArrayList<GroupParams> nodes;
        private GroupParams root;
        private final int tintBlendMode;
        private final long tintColor;
        private final float viewportHeight;
        private final float viewportWidth;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with ImageVector.Builder that consumes an optional auto mirror parameter", replaceWith = @ReplaceWith(expression = "Builder(name, defaultWidth, defaultHeight, viewportWidth, viewportHeight, tintColor, tintBlendMode, false)", imports = {"androidx.compose.ui.graphics.vector"}))
        public /* synthetic */ Builder(String str, float f, float f2, float f3, float f4, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, f, f2, f3, f4, j, i);
        }

        public /* synthetic */ Builder(String str, float f, float f2, float f3, float f4, long j, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, f, f2, f3, f4, j, i, z);
        }

        private Builder(String name2, float defaultWidth2, float defaultHeight2, float viewportWidth2, float viewportHeight2, long tintColor2, int tintBlendMode2, boolean autoMirror2) {
            this.name = name2;
            this.defaultWidth = defaultWidth2;
            this.defaultHeight = defaultHeight2;
            this.viewportWidth = viewportWidth2;
            this.viewportHeight = viewportHeight2;
            this.tintColor = tintColor2;
            this.tintBlendMode = tintBlendMode2;
            this.autoMirror = autoMirror2;
            ArrayList<GroupParams> arrayList = new ArrayList<>();
            this.nodes = arrayList;
            GroupParams groupParams = r11;
            GroupParams groupParams2 = new GroupParams((String) null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, (List) null, (List) null, 1023, (DefaultConstructorMarker) null);
            GroupParams groupParams3 = groupParams;
            this.root = groupParams3;
            boolean unused = ImageVectorKt.push(arrayList, groupParams3);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Builder(java.lang.String r14, float r15, float r16, float r17, float r18, long r19, int r21, boolean r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
            /*
                r13 = this;
                r0 = r23
                r1 = r0 & 1
                if (r1 == 0) goto L_0x000a
                java.lang.String r1 = ""
                r3 = r1
                goto L_0x000b
            L_0x000a:
                r3 = r14
            L_0x000b:
                r1 = r0 & 32
                if (r1 == 0) goto L_0x0017
                androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
                long r1 = r1.m3200getUnspecified0d7_KjU()
                r8 = r1
                goto L_0x0019
            L_0x0017:
                r8 = r19
            L_0x0019:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x0025
                androidx.compose.ui.graphics.BlendMode$Companion r1 = androidx.compose.ui.graphics.BlendMode.Companion
                int r1 = r1.m3095getSrcIn0nO6VwU()
                r10 = r1
                goto L_0x0027
            L_0x0025:
                r10 = r21
            L_0x0027:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x002e
                r0 = 0
                r11 = r0
                goto L_0x0030
            L_0x002e:
                r11 = r22
            L_0x0030:
                r12 = 0
                r2 = r13
                r4 = r15
                r5 = r16
                r6 = r17
                r7 = r18
                r2.<init>((java.lang.String) r3, (float) r4, (float) r5, (float) r6, (float) r7, (long) r8, (int) r10, (boolean) r11, (kotlin.jvm.internal.DefaultConstructorMarker) r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.ImageVector.Builder.<init>(java.lang.String, float, float, float, float, long, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Builder(java.lang.String r12, float r13, float r14, float r15, float r16, long r17, int r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
            /*
                r11 = this;
                r0 = r20 & 1
                if (r0 == 0) goto L_0x0008
                java.lang.String r0 = ""
                r2 = r0
                goto L_0x0009
            L_0x0008:
                r2 = r12
            L_0x0009:
                r0 = r20 & 32
                if (r0 == 0) goto L_0x0015
                androidx.compose.ui.graphics.Color$Companion r0 = androidx.compose.ui.graphics.Color.Companion
                long r0 = r0.m3200getUnspecified0d7_KjU()
                r7 = r0
                goto L_0x0017
            L_0x0015:
                r7 = r17
            L_0x0017:
                r0 = r20 & 64
                if (r0 == 0) goto L_0x0023
                androidx.compose.ui.graphics.BlendMode$Companion r0 = androidx.compose.ui.graphics.BlendMode.Companion
                int r0 = r0.m3095getSrcIn0nO6VwU()
                r9 = r0
                goto L_0x0025
            L_0x0023:
                r9 = r19
            L_0x0025:
                r10 = 0
                r1 = r11
                r3 = r13
                r4 = r14
                r5 = r15
                r6 = r16
                r1.<init>((java.lang.String) r2, (float) r3, (float) r4, (float) r5, (float) r6, (long) r7, (int) r9, (kotlin.jvm.internal.DefaultConstructorMarker) r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.ImageVector.Builder.<init>(java.lang.String, float, float, float, float, long, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        private Builder(String name2, float defaultWidth2, float defaultHeight2, float viewportWidth2, float viewportHeight2, long tintColor2, int tintBlendMode2) {
            this(name2, defaultWidth2, defaultHeight2, viewportWidth2, viewportHeight2, tintColor2, tintBlendMode2, false, (DefaultConstructorMarker) null);
        }

        private final GroupParams getCurrentGroup() {
            return (GroupParams) ImageVectorKt.peek(this.nodes);
        }

        public static /* synthetic */ Builder addGroup$default(Builder builder, String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List list, int i, Object obj) {
            String str2;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            List list2;
            int i2 = i;
            if ((i2 & 1) != 0) {
                str2 = "";
            } else {
                str2 = str;
            }
            float f13 = 0.0f;
            if ((i2 & 2) != 0) {
                f8 = 0.0f;
            } else {
                f8 = f;
            }
            if ((i2 & 4) != 0) {
                f9 = 0.0f;
            } else {
                f9 = f2;
            }
            if ((i2 & 8) != 0) {
                f10 = 0.0f;
            } else {
                f10 = f3;
            }
            float f14 = 1.0f;
            if ((i2 & 16) != 0) {
                f11 = 1.0f;
            } else {
                f11 = f4;
            }
            if ((i2 & 32) == 0) {
                f14 = f5;
            }
            if ((i2 & 64) != 0) {
                f12 = 0.0f;
            } else {
                f12 = f6;
            }
            if ((i2 & 128) == 0) {
                f13 = f7;
            }
            if ((i2 & 256) != 0) {
                list2 = VectorKt.getEmptyPath();
            } else {
                list2 = list;
            }
            return builder.addGroup(str2, f8, f9, f10, f11, f14, f12, f13, list2);
        }

        public final Builder addGroup(String name2, float rotate, float pivotX, float pivotY, float scaleX, float scaleY, float translationX, float translationY, List<? extends PathNode> clipPathData) {
            Intrinsics.checkNotNullParameter(name2, HintConstants.AUTOFILL_HINT_NAME);
            Intrinsics.checkNotNullParameter(clipPathData, "clipPathData");
            ensureNotConsumed();
            boolean unused = ImageVectorKt.push(this.nodes, new GroupParams(name2, rotate, pivotX, pivotY, scaleX, scaleY, translationX, translationY, clipPathData, (List) null, 512, (DefaultConstructorMarker) null));
            return this;
        }

        public final Builder clearGroup() {
            ensureNotConsumed();
            getCurrentGroup().getChildren().add(asVectorGroup((GroupParams) ImageVectorKt.pop(this.nodes)));
            return this;
        }

        /* renamed from: addPath-oIyEayM$default  reason: not valid java name */
        public static /* synthetic */ Builder m3873addPathoIyEayM$default(Builder builder, List list, int i, String str, Brush brush, float f, Brush brush2, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7, int i4, Object obj) {
            int i5;
            String str2;
            Brush brush3;
            float f8;
            float f9;
            float f10;
            int i6;
            int i7;
            float f11;
            float f12;
            int i8 = i4;
            if ((i8 & 2) != 0) {
                i5 = VectorKt.getDefaultFillType();
            } else {
                i5 = i;
            }
            if ((i8 & 4) != 0) {
                str2 = "";
            } else {
                str2 = str;
            }
            Brush brush4 = null;
            if ((i8 & 8) != 0) {
                brush3 = null;
            } else {
                brush3 = brush;
            }
            float f13 = 1.0f;
            if ((i8 & 16) != 0) {
                f8 = 1.0f;
            } else {
                f8 = f;
            }
            if ((i8 & 32) == 0) {
                brush4 = brush2;
            }
            if ((i8 & 64) != 0) {
                f9 = 1.0f;
            } else {
                f9 = f2;
            }
            float f14 = 0.0f;
            if ((i8 & 128) != 0) {
                f10 = 0.0f;
            } else {
                f10 = f3;
            }
            if ((i8 & 256) != 0) {
                i6 = VectorKt.getDefaultStrokeLineCap();
            } else {
                i6 = i2;
            }
            if ((i8 & 512) != 0) {
                i7 = VectorKt.getDefaultStrokeLineJoin();
            } else {
                i7 = i3;
            }
            if ((i8 & 1024) != 0) {
                f11 = 4.0f;
            } else {
                f11 = f4;
            }
            if ((i8 & 2048) != 0) {
                f12 = 0.0f;
            } else {
                f12 = f5;
            }
            if ((i8 & 4096) == 0) {
                f13 = f6;
            }
            if ((i8 & 8192) == 0) {
                f14 = f7;
            }
            return builder.m3874addPathoIyEayM(list, i5, str2, brush3, f8, brush4, f9, f10, i6, i7, f11, f12, f13, f14);
        }

        /* renamed from: addPath-oIyEayM  reason: not valid java name */
        public final Builder m3874addPathoIyEayM(List<? extends PathNode> pathData, int pathFillType, String name2, Brush fill, float fillAlpha, Brush stroke, float strokeAlpha, float strokeLineWidth, int strokeLineCap, int strokeLineJoin, float strokeLineMiter, float trimPathStart, float trimPathEnd, float trimPathOffset) {
            Intrinsics.checkNotNullParameter(pathData, "pathData");
            Intrinsics.checkNotNullParameter(name2, HintConstants.AUTOFILL_HINT_NAME);
            ensureNotConsumed();
            List<VectorNode> children = getCurrentGroup().getChildren();
            VectorPath vectorPath = r1;
            VectorPath vectorPath2 = new VectorPath(name2, pathData, pathFillType, fill, fillAlpha, stroke, strokeAlpha, strokeLineWidth, strokeLineCap, strokeLineJoin, strokeLineMiter, trimPathStart, trimPathEnd, trimPathOffset, (DefaultConstructorMarker) null);
            children.add(vectorPath);
            return this;
        }

        public final ImageVector build() {
            ensureNotConsumed();
            while (this.nodes.size() > 1) {
                clearGroup();
            }
            ImageVector imageVector = new ImageVector(this.name, this.defaultWidth, this.defaultHeight, this.viewportWidth, this.viewportHeight, asVectorGroup(this.root), this.tintColor, this.tintBlendMode, this.autoMirror, (DefaultConstructorMarker) null);
            this.isConsumed = true;
            return imageVector;
        }

        private final void ensureNotConsumed() {
            if (!(!this.isConsumed)) {
                throw new IllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector".toString());
            }
        }

        private final VectorGroup asVectorGroup(GroupParams $this$asVectorGroup) {
            return new VectorGroup($this$asVectorGroup.getName(), $this$asVectorGroup.getRotate(), $this$asVectorGroup.getPivotX(), $this$asVectorGroup.getPivotY(), $this$asVectorGroup.getScaleX(), $this$asVectorGroup.getScaleY(), $this$asVectorGroup.getTranslationX(), $this$asVectorGroup.getTranslationY(), $this$asVectorGroup.getClipPathData(), $this$asVectorGroup.getChildren());
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0002\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0010\u0012R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\u001a\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 ¨\u0006-"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "", "name", "", "rotate", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "children", "", "Landroidx/compose/ui/graphics/vector/VectorNode;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Ljava/util/List;)V", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "getClipPathData", "setClipPathData", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPivotX", "()F", "setPivotX", "(F)V", "getPivotY", "setPivotY", "getRotate", "setRotate", "getScaleX", "setScaleX", "getScaleY", "setScaleY", "getTranslationX", "setTranslationX", "getTranslationY", "setTranslationY", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: ImageVector.kt */
        private static final class GroupParams {
            private List<VectorNode> children;
            private List<? extends PathNode> clipPathData;
            private String name;
            private float pivotX;
            private float pivotY;
            private float rotate;
            private float scaleX;
            private float scaleY;
            private float translationX;
            private float translationY;

            public GroupParams() {
                this((String) null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, (List) null, (List) null, 1023, (DefaultConstructorMarker) null);
            }

            public GroupParams(String name2, float rotate2, float pivotX2, float pivotY2, float scaleX2, float scaleY2, float translationX2, float translationY2, List<? extends PathNode> clipPathData2, List<VectorNode> children2) {
                Intrinsics.checkNotNullParameter(name2, HintConstants.AUTOFILL_HINT_NAME);
                Intrinsics.checkNotNullParameter(clipPathData2, "clipPathData");
                Intrinsics.checkNotNullParameter(children2, "children");
                this.name = name2;
                this.rotate = rotate2;
                this.pivotX = pivotX2;
                this.pivotY = pivotY2;
                this.scaleX = scaleX2;
                this.scaleY = scaleY2;
                this.translationX = translationX2;
                this.translationY = translationY2;
                this.clipPathData = clipPathData2;
                this.children = children2;
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ GroupParams(java.lang.String r11, float r12, float r13, float r14, float r15, float r16, float r17, float r18, java.util.List r19, java.util.List r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
                /*
                    r10 = this;
                    r0 = r21
                    r1 = r0 & 1
                    if (r1 == 0) goto L_0x0009
                    java.lang.String r1 = ""
                    goto L_0x000a
                L_0x0009:
                    r1 = r11
                L_0x000a:
                    r2 = r0 & 2
                    r3 = 0
                    if (r2 == 0) goto L_0x0011
                    r2 = r3
                    goto L_0x0012
                L_0x0011:
                    r2 = r12
                L_0x0012:
                    r4 = r0 & 4
                    if (r4 == 0) goto L_0x0018
                    r4 = r3
                    goto L_0x0019
                L_0x0018:
                    r4 = r13
                L_0x0019:
                    r5 = r0 & 8
                    if (r5 == 0) goto L_0x001f
                    r5 = r3
                    goto L_0x0020
                L_0x001f:
                    r5 = r14
                L_0x0020:
                    r6 = r0 & 16
                    r7 = 1065353216(0x3f800000, float:1.0)
                    if (r6 == 0) goto L_0x0028
                    r6 = r7
                    goto L_0x0029
                L_0x0028:
                    r6 = r15
                L_0x0029:
                    r8 = r0 & 32
                    if (r8 == 0) goto L_0x002e
                    goto L_0x0030
                L_0x002e:
                    r7 = r16
                L_0x0030:
                    r8 = r0 & 64
                    if (r8 == 0) goto L_0x0036
                    r8 = r3
                    goto L_0x0038
                L_0x0036:
                    r8 = r17
                L_0x0038:
                    r9 = r0 & 128(0x80, float:1.794E-43)
                    if (r9 == 0) goto L_0x003d
                    goto L_0x003f
                L_0x003d:
                    r3 = r18
                L_0x003f:
                    r9 = r0 & 256(0x100, float:3.59E-43)
                    if (r9 == 0) goto L_0x0048
                    java.util.List r9 = androidx.compose.ui.graphics.vector.VectorKt.getEmptyPath()
                    goto L_0x004a
                L_0x0048:
                    r9 = r19
                L_0x004a:
                    r0 = r0 & 512(0x200, float:7.175E-43)
                    if (r0 == 0) goto L_0x0056
                    java.util.ArrayList r0 = new java.util.ArrayList
                    r0.<init>()
                    java.util.List r0 = (java.util.List) r0
                    goto L_0x0058
                L_0x0056:
                    r0 = r20
                L_0x0058:
                    r11 = r10
                    r12 = r1
                    r13 = r2
                    r14 = r4
                    r15 = r5
                    r16 = r6
                    r17 = r7
                    r18 = r8
                    r19 = r3
                    r20 = r9
                    r21 = r0
                    r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.ImageVector.Builder.GroupParams.<init>(java.lang.String, float, float, float, float, float, float, float, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
            }

            public final String getName() {
                return this.name;
            }

            public final void setName(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.name = str;
            }

            public final float getRotate() {
                return this.rotate;
            }

            public final void setRotate(float f) {
                this.rotate = f;
            }

            public final float getPivotX() {
                return this.pivotX;
            }

            public final void setPivotX(float f) {
                this.pivotX = f;
            }

            public final float getPivotY() {
                return this.pivotY;
            }

            public final void setPivotY(float f) {
                this.pivotY = f;
            }

            public final float getScaleX() {
                return this.scaleX;
            }

            public final void setScaleX(float f) {
                this.scaleX = f;
            }

            public final float getScaleY() {
                return this.scaleY;
            }

            public final void setScaleY(float f) {
                this.scaleY = f;
            }

            public final float getTranslationX() {
                return this.translationX;
            }

            public final void setTranslationX(float f) {
                this.translationX = f;
            }

            public final float getTranslationY() {
                return this.translationY;
            }

            public final void setTranslationY(float f) {
                this.translationY = f;
            }

            public final List<PathNode> getClipPathData() {
                return this.clipPathData;
            }

            public final void setClipPathData(List<? extends PathNode> list) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.clipPathData = list;
            }

            public final List<VectorNode> getChildren() {
                return this.children;
            }

            public final void setChildren(List<VectorNode> list) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.children = list;
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector$Companion;", "", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ImageVector.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageVector) || !Intrinsics.areEqual((Object) this.name, (Object) ((ImageVector) other).name) || !Dp.m5991equalsimpl0(this.defaultWidth, ((ImageVector) other).defaultWidth) || !Dp.m5991equalsimpl0(this.defaultHeight, ((ImageVector) other).defaultHeight)) {
            return false;
        }
        if (!(this.viewportWidth == ((ImageVector) other).viewportWidth)) {
            return false;
        }
        if ((this.viewportHeight == ((ImageVector) other).viewportHeight) && Intrinsics.areEqual((Object) this.root, (Object) ((ImageVector) other).root) && Color.m3165equalsimpl0(this.tintColor, ((ImageVector) other).tintColor) && BlendMode.m3066equalsimpl0(this.tintBlendMode, ((ImageVector) other).tintBlendMode) && this.autoMirror == ((ImageVector) other).autoMirror) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.name.hashCode() * 31) + Dp.m5992hashCodeimpl(this.defaultWidth)) * 31) + Dp.m5992hashCodeimpl(this.defaultHeight)) * 31) + Float.hashCode(this.viewportWidth)) * 31) + Float.hashCode(this.viewportHeight)) * 31) + this.root.hashCode()) * 31) + Color.m3171hashCodeimpl(this.tintColor)) * 31) + BlendMode.m3067hashCodeimpl(this.tintBlendMode)) * 31) + Boolean.hashCode(this.autoMirror);
    }
}
