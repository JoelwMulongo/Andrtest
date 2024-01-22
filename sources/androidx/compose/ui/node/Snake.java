package androidx.compose.ui.node;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u001a\u0010\"\u001a\u00020\u00112\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b'\u0010\u000bJ\u000f\u0010(\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000bR\u0011\u0010\u001a\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000b\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Landroidx/compose/ui/node/Snake;", "", "data", "", "constructor-impl", "([I)[I", "getData", "()[I", "diagonalSize", "", "getDiagonalSize-impl", "([I)I", "endX", "getEndX-impl", "endY", "getEndY-impl", "hasAdditionOrRemoval", "", "getHasAdditionOrRemoval-impl", "([I)Z", "isAddition", "isAddition-impl", "reverse", "getReverse-impl", "startX", "getStartX-impl", "startY", "getStartY-impl", "addDiagonalToStack", "", "diagonals", "Landroidx/compose/ui/node/IntStack;", "addDiagonalToStack-impl", "([ILandroidx/compose/ui/node/IntStack;)V", "equals", "other", "equals-impl", "([ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "([I)Ljava/lang/String;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: MyersDiff.kt */
final class Snake {
    private final int[] data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Snake m5180boximpl(int[] iArr) {
        return new Snake(iArr);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int[] m5181constructorimpl(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "data");
        return iArr;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5182equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof Snake) && Intrinsics.areEqual((Object) iArr, (Object) ((Snake) obj).m5194unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5183equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual((Object) iArr, (Object) iArr2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5191hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public boolean equals(Object obj) {
        return m5182equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m5191hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int[] m5194unboximpl() {
        return this.data;
    }

    private /* synthetic */ Snake(int[] data2) {
        this.data = data2;
    }

    public final int[] getData() {
        return this.data;
    }

    /* renamed from: getStartX-impl  reason: not valid java name */
    public static final int m5189getStartXimpl(int[] arg0) {
        return arg0[0];
    }

    /* renamed from: getStartY-impl  reason: not valid java name */
    public static final int m5190getStartYimpl(int[] arg0) {
        return arg0[1];
    }

    /* renamed from: getEndX-impl  reason: not valid java name */
    public static final int m5185getEndXimpl(int[] arg0) {
        return arg0[2];
    }

    /* renamed from: getEndY-impl  reason: not valid java name */
    public static final int m5186getEndYimpl(int[] arg0) {
        return arg0[3];
    }

    /* renamed from: getReverse-impl  reason: not valid java name */
    public static final boolean m5188getReverseimpl(int[] arg0) {
        return arg0[4] != 0;
    }

    /* renamed from: getDiagonalSize-impl  reason: not valid java name */
    public static final int m5184getDiagonalSizeimpl(int[] arg0) {
        return Math.min(m5185getEndXimpl(arg0) - m5189getStartXimpl(arg0), m5186getEndYimpl(arg0) - m5190getStartYimpl(arg0));
    }

    /* renamed from: getHasAdditionOrRemoval-impl  reason: not valid java name */
    private static final boolean m5187getHasAdditionOrRemovalimpl(int[] arg0) {
        return m5186getEndYimpl(arg0) - m5190getStartYimpl(arg0) != m5185getEndXimpl(arg0) - m5189getStartXimpl(arg0);
    }

    /* renamed from: isAddition-impl  reason: not valid java name */
    private static final boolean m5192isAdditionimpl(int[] arg0) {
        return m5186getEndYimpl(arg0) - m5190getStartYimpl(arg0) > m5185getEndXimpl(arg0) - m5189getStartXimpl(arg0);
    }

    /* renamed from: addDiagonalToStack-impl  reason: not valid java name */
    public static final void m5179addDiagonalToStackimpl(int[] arg0, IntStack diagonals) {
        Intrinsics.checkNotNullParameter(diagonals, "diagonals");
        if (!m5187getHasAdditionOrRemovalimpl(arg0)) {
            diagonals.pushDiagonal(m5189getStartXimpl(arg0), m5190getStartYimpl(arg0), m5185getEndXimpl(arg0) - m5189getStartXimpl(arg0));
        } else if (m5188getReverseimpl(arg0)) {
            diagonals.pushDiagonal(m5189getStartXimpl(arg0), m5190getStartYimpl(arg0), m5184getDiagonalSizeimpl(arg0));
        } else if (m5192isAdditionimpl(arg0)) {
            diagonals.pushDiagonal(m5189getStartXimpl(arg0), m5190getStartYimpl(arg0) + 1, m5184getDiagonalSizeimpl(arg0));
        } else {
            diagonals.pushDiagonal(m5189getStartXimpl(arg0) + 1, m5190getStartYimpl(arg0), m5184getDiagonalSizeimpl(arg0));
        }
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5193toStringimpl(int[] arg0) {
        return "Snake(" + m5189getStartXimpl(arg0) + ',' + m5190getStartYimpl(arg0) + ',' + m5185getEndXimpl(arg0) + ',' + m5186getEndYimpl(arg0) + ',' + m5188getReverseimpl(arg0) + ')';
    }

    public String toString() {
        return m5193toStringimpl(this.data);
    }
}
