package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a&\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\"\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a&\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\"\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a+\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a&\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\"\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0005\u001a+\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b'\u0010\b\u001a&\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010\f\u001a\"\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010\u000f\u001a+\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0011\u001a&\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010\u0014\u001a\"\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010\u0017\u001a+\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\bø\u0001\u0000¢\u0006\u0004\b-\u0010\u0019\u001a&\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010\u001c\u001a\"\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u001f\u001a+\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\bø\u0001\u0000¢\u0006\u0004\b0\u0010!\u001a&\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010$\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"maxOf", "Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "c", "maxOf-b33U2AM", "(BBB)B", "other", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-Kr8caGY", "minOf-b33U2AM", "minOf-Wr6uiD8", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-Md2H83M", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-R03FKyM", "minOf-5PvTz6A", "minOf-VKSA0NQ", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {1, 8, 0}, xi = 49, xs = "kotlin/comparisons/UComparisonsKt")
/* compiled from: _UComparisons.kt */
class UComparisonsKt___UComparisonsKt {
    /* renamed from: maxOf-J1ME1BU  reason: not valid java name */
    public static final int m7463maxOfJ1ME1BU(int a, int b) {
        return Integer.compareUnsigned(a, b) >= 0 ? a : b;
    }

    /* renamed from: maxOf-eb3DHEI  reason: not valid java name */
    public static final long m7471maxOfeb3DHEI(long a, long b) {
        return Long.compareUnsigned(a, b) >= 0 ? a : b;
    }

    /* renamed from: maxOf-Kr8caGY  reason: not valid java name */
    public static final byte m7464maxOfKr8caGY(byte a, byte b) {
        return Intrinsics.compare((int) a & UByte.MAX_VALUE, (int) b & UByte.MAX_VALUE) >= 0 ? a : b;
    }

    /* renamed from: maxOf-5PvTz6A  reason: not valid java name */
    public static final short m7462maxOf5PvTz6A(short a, short b) {
        return Intrinsics.compare((int) a & UShort.MAX_VALUE, (int) 65535 & b) >= 0 ? a : b;
    }

    /* renamed from: maxOf-WZ9TVnA  reason: not valid java name */
    private static final int m7468maxOfWZ9TVnA(int a, int b, int c) {
        return UComparisonsKt.m7463maxOfJ1ME1BU(a, UComparisonsKt.m7463maxOfJ1ME1BU(b, c));
    }

    /* renamed from: maxOf-sambcqE  reason: not valid java name */
    private static final long m7472maxOfsambcqE(long a, long b, long c) {
        return UComparisonsKt.m7471maxOfeb3DHEI(a, UComparisonsKt.m7471maxOfeb3DHEI(b, c));
    }

    /* renamed from: maxOf-b33U2AM  reason: not valid java name */
    private static final byte m7470maxOfb33U2AM(byte a, byte b, byte c) {
        return UComparisonsKt.m7464maxOfKr8caGY(a, UComparisonsKt.m7464maxOfKr8caGY(b, c));
    }

    /* renamed from: maxOf-VKSA0NQ  reason: not valid java name */
    private static final short m7467maxOfVKSA0NQ(short a, short b, short c) {
        return UComparisonsKt.m7462maxOf5PvTz6A(a, UComparisonsKt.m7462maxOf5PvTz6A(b, c));
    }

    /* renamed from: maxOf-Md2H83M  reason: not valid java name */
    public static final int m7465maxOfMd2H83M(int a, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int max = a;
        int r1 = UIntArray.m6429getSizeimpl(other);
        for (int i = 0; i < r1; i++) {
            max = UComparisonsKt.m7463maxOfJ1ME1BU(max, UIntArray.m6428getpVg5ArA(other, i));
        }
        return max;
    }

    /* renamed from: maxOf-R03FKyM  reason: not valid java name */
    public static final long m7466maxOfR03FKyM(long a, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long max = a;
        int r2 = ULongArray.m6508getSizeimpl(other);
        for (int i = 0; i < r2; i++) {
            max = UComparisonsKt.m7471maxOfeb3DHEI(max, ULongArray.m6507getsVKNKU(other, i));
        }
        return max;
    }

    /* renamed from: maxOf-Wr6uiD8  reason: not valid java name */
    public static final byte m7469maxOfWr6uiD8(byte a, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        byte max = a;
        int r1 = UByteArray.m6350getSizeimpl(other);
        for (int i = 0; i < r1; i++) {
            max = UComparisonsKt.m7464maxOfKr8caGY(max, UByteArray.m6349getw2LRezQ(other, i));
        }
        return max;
    }

    /* renamed from: maxOf-t1qELG4  reason: not valid java name */
    public static final short m7473maxOft1qELG4(short a, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        short max = a;
        int r1 = UShortArray.m6613getSizeimpl(other);
        for (int i = 0; i < r1; i++) {
            max = UComparisonsKt.m7462maxOf5PvTz6A(max, UShortArray.m6612getMh2AYeg(other, i));
        }
        return max;
    }

    /* renamed from: minOf-J1ME1BU  reason: not valid java name */
    public static final int m7475minOfJ1ME1BU(int a, int b) {
        return Integer.compareUnsigned(a, b) <= 0 ? a : b;
    }

    /* renamed from: minOf-eb3DHEI  reason: not valid java name */
    public static final long m7483minOfeb3DHEI(long a, long b) {
        return Long.compareUnsigned(a, b) <= 0 ? a : b;
    }

    /* renamed from: minOf-Kr8caGY  reason: not valid java name */
    public static final byte m7476minOfKr8caGY(byte a, byte b) {
        return Intrinsics.compare((int) a & UByte.MAX_VALUE, (int) b & UByte.MAX_VALUE) <= 0 ? a : b;
    }

    /* renamed from: minOf-5PvTz6A  reason: not valid java name */
    public static final short m7474minOf5PvTz6A(short a, short b) {
        return Intrinsics.compare((int) a & UShort.MAX_VALUE, (int) 65535 & b) <= 0 ? a : b;
    }

    /* renamed from: minOf-WZ9TVnA  reason: not valid java name */
    private static final int m7480minOfWZ9TVnA(int a, int b, int c) {
        return UComparisonsKt.m7475minOfJ1ME1BU(a, UComparisonsKt.m7475minOfJ1ME1BU(b, c));
    }

    /* renamed from: minOf-sambcqE  reason: not valid java name */
    private static final long m7484minOfsambcqE(long a, long b, long c) {
        return UComparisonsKt.m7483minOfeb3DHEI(a, UComparisonsKt.m7483minOfeb3DHEI(b, c));
    }

    /* renamed from: minOf-b33U2AM  reason: not valid java name */
    private static final byte m7482minOfb33U2AM(byte a, byte b, byte c) {
        return UComparisonsKt.m7476minOfKr8caGY(a, UComparisonsKt.m7476minOfKr8caGY(b, c));
    }

    /* renamed from: minOf-VKSA0NQ  reason: not valid java name */
    private static final short m7479minOfVKSA0NQ(short a, short b, short c) {
        return UComparisonsKt.m7474minOf5PvTz6A(a, UComparisonsKt.m7474minOf5PvTz6A(b, c));
    }

    /* renamed from: minOf-Md2H83M  reason: not valid java name */
    public static final int m7477minOfMd2H83M(int a, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int min = a;
        int r1 = UIntArray.m6429getSizeimpl(other);
        for (int i = 0; i < r1; i++) {
            min = UComparisonsKt.m7475minOfJ1ME1BU(min, UIntArray.m6428getpVg5ArA(other, i));
        }
        return min;
    }

    /* renamed from: minOf-R03FKyM  reason: not valid java name */
    public static final long m7478minOfR03FKyM(long a, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long min = a;
        int r2 = ULongArray.m6508getSizeimpl(other);
        for (int i = 0; i < r2; i++) {
            min = UComparisonsKt.m7483minOfeb3DHEI(min, ULongArray.m6507getsVKNKU(other, i));
        }
        return min;
    }

    /* renamed from: minOf-Wr6uiD8  reason: not valid java name */
    public static final byte m7481minOfWr6uiD8(byte a, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        byte min = a;
        int r1 = UByteArray.m6350getSizeimpl(other);
        for (int i = 0; i < r1; i++) {
            min = UComparisonsKt.m7476minOfKr8caGY(min, UByteArray.m6349getw2LRezQ(other, i));
        }
        return min;
    }

    /* renamed from: minOf-t1qELG4  reason: not valid java name */
    public static final short m7485minOft1qELG4(short a, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        short min = a;
        int r1 = UShortArray.m6613getSizeimpl(other);
        for (int i = 0; i < r1; i++) {
            min = UComparisonsKt.m7474minOf5PvTz6A(min, UShortArray.m6612getMh2AYeg(other, i));
        }
        return min;
    }
}
