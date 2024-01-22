package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\n\u0018\u00002\u00020\u0001BH\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\u001a\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0002ø\u0001\u0000J\u0019\u0010\u001b\u001a\u00020\u00132\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002ø\u0001\u0000R\u0011\u0010\b\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/graphics/Vertices;", "", "vertexMode", "Landroidx/compose/ui/graphics/VertexMode;", "positions", "", "Landroidx/compose/ui/geometry/Offset;", "textureCoordinates", "colors", "Landroidx/compose/ui/graphics/Color;", "indices", "", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "getColors", "()[I", "", "getIndices", "()[S", "", "getPositions", "()[F", "getTextureCoordinates", "getVertexMode-c2xauaI", "()I", "I", "encodeColorList", "encodePointList", "points", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Vertices.kt */
public final class Vertices {
    private final int[] colors;
    private final short[] indices;
    private final float[] positions;
    private final float[] textureCoordinates;
    private final int vertexMode;

    public /* synthetic */ Vertices(int i, List list, List list2, List list3, List list4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, list2, list3, list4);
    }

    private Vertices(int vertexMode2, List<Offset> positions2, List<Offset> textureCoordinates2, List<Color> colors2, List<Integer> indices2) {
        int i;
        boolean z;
        List<Offset> list = positions2;
        this.vertexMode = vertexMode2;
        Function1 outOfBounds = new Vertices$outOfBounds$1(list);
        if (textureCoordinates2.size() != positions2.size()) {
            List<Offset> list2 = textureCoordinates2;
            List<Color> list3 = colors2;
            List<Integer> list4 = indices2;
            throw new IllegalArgumentException("positions and textureCoordinates lengths must match.");
        } else if (colors2.size() == positions2.size()) {
            List $this$fastForEach$iv$iv = indices2;
            int index$iv$iv = 0;
            int size = $this$fastForEach$iv$iv.size();
            while (true) {
                if (index$iv$iv >= size) {
                    z = false;
                    break;
                } else if (((Boolean) outOfBounds.invoke($this$fastForEach$iv$iv.get(index$iv$iv))).booleanValue()) {
                    z = true;
                    break;
                } else {
                    index$iv$iv++;
                }
            }
            if (!z) {
                this.positions = encodePointList(list);
                this.textureCoordinates = encodePointList(textureCoordinates2);
                this.colors = encodeColorList(colors2);
                int size2 = indices2.size();
                short[] sArr = new short[size2];
                for (i = 0; i < size2; i++) {
                    sArr[i] = (short) indices2.get(i).intValue();
                }
                List<Integer> list5 = indices2;
                this.indices = sArr;
                return;
            }
            List<Offset> list6 = textureCoordinates2;
            List<Color> list7 = colors2;
            List<Integer> list8 = indices2;
            throw new IllegalArgumentException("indices values must be valid indices in the positions list.");
        } else {
            List<Offset> list9 = textureCoordinates2;
            List<Color> list10 = colors2;
            List<Integer> list11 = indices2;
            throw new IllegalArgumentException("positions and colors lengths must match.");
        }
    }

    /* renamed from: getVertexMode-c2xauaI  reason: not valid java name */
    public final int m3597getVertexModec2xauaI() {
        return this.vertexMode;
    }

    public final float[] getPositions() {
        return this.positions;
    }

    public final float[] getTextureCoordinates() {
        return this.textureCoordinates;
    }

    public final int[] getColors() {
        return this.colors;
    }

    public final short[] getIndices() {
        return this.indices;
    }

    private final int[] encodeColorList(List<Color> colors2) {
        int size = colors2.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ColorKt.m3218toArgb8_81llA(colors2.get(i).m3174unboximpl());
        }
        return iArr;
    }

    private final float[] encodePointList(List<Offset> points) {
        float f;
        int size = points.size() * 2;
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            long point = points.get(i / 2).m2925unboximpl();
            if (i % 2 == 0) {
                f = Offset.m2915getXimpl(point);
            } else {
                f = Offset.m2916getYimpl(point);
            }
            fArr[i] = f;
        }
        return fArr;
    }
}
