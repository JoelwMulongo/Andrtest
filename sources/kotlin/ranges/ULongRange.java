package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001cB\u0018\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001b\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R \u0010\b\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0005\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001d"}, d2 = {"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "endExclusive", "getEndExclusive-s-VKNKU$annotations", "()V", "getEndExclusive-s-VKNKU", "()J", "getEndInclusive-s-VKNKU", "getStart-s-VKNKU", "contains", "", "value", "contains-VKZWuLQ", "(J)Z", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ULongRange.kt */
public final class ULongRange extends ULongProgression implements ClosedRange<ULong>, OpenEndRange<ULong> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ULongRange EMPTY = new ULongRange(-1, 0, (DefaultConstructorMarker) null);

    public /* synthetic */ ULongRange(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with ULong type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    /* renamed from: getEndExclusive-s-VKNKU$annotations  reason: not valid java name */
    public static /* synthetic */ void m7517getEndExclusivesVKNKU$annotations() {
    }

    public /* bridge */ /* synthetic */ boolean contains(Comparable value) {
        return m7518containsVKZWuLQ(((ULong) value).m6499unboximpl());
    }

    public /* bridge */ /* synthetic */ Comparable getEndExclusive() {
        return ULong.m6441boximpl(m7519getEndExclusivesVKNKU());
    }

    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return ULong.m6441boximpl(m7520getEndInclusivesVKNKU());
    }

    public /* bridge */ /* synthetic */ Comparable getStart() {
        return ULong.m6441boximpl(m7521getStartsVKNKU());
    }

    private ULongRange(long start, long endInclusive) {
        super(start, endInclusive, 1, (DefaultConstructorMarker) null);
    }

    /* renamed from: getStart-s-VKNKU  reason: not valid java name */
    public long m7521getStartsVKNKU() {
        return m7513getFirstsVKNKU();
    }

    /* renamed from: getEndInclusive-s-VKNKU  reason: not valid java name */
    public long m7520getEndInclusivesVKNKU() {
        return m7514getLastsVKNKU();
    }

    /* renamed from: getEndExclusive-s-VKNKU  reason: not valid java name */
    public long m7519getEndExclusivesVKNKU() {
        if (m7514getLastsVKNKU() != -1) {
            return ULong.m6447constructorimpl(m7514getLastsVKNKU() + ULong.m6447constructorimpl(((long) 1) & 4294967295L));
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    /* renamed from: contains-VKZWuLQ  reason: not valid java name */
    public boolean m7518containsVKZWuLQ(long value) {
        return Long.compareUnsigned(m7513getFirstsVKNKU(), value) <= 0 && Long.compareUnsigned(value, m7514getLastsVKNKU()) <= 0;
    }

    public boolean isEmpty() {
        return Long.compareUnsigned(m7513getFirstsVKNKU(), m7514getLastsVKNKU()) > 0;
    }

    public boolean equals(Object other) {
        return (other instanceof ULongRange) && ((isEmpty() && ((ULongRange) other).isEmpty()) || (m7513getFirstsVKNKU() == ((ULongRange) other).m7513getFirstsVKNKU() && m7514getLastsVKNKU() == ((ULongRange) other).m7514getLastsVKNKU()));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((int) ULong.m6447constructorimpl(m7513getFirstsVKNKU() ^ ULong.m6447constructorimpl(m7513getFirstsVKNKU() >>> 32))) * 31) + ((int) ULong.m6447constructorimpl(m7514getLastsVKNKU() ^ ULong.m6447constructorimpl(m7514getLastsVKNKU() >>> 32)));
    }

    public String toString() {
        return ULong.m6493toStringimpl(m7513getFirstsVKNKU()) + ".." + ULong.m6493toStringimpl(m7514getLastsVKNKU());
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/ranges/ULongRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/ULongRange;", "getEMPTY", "()Lkotlin/ranges/ULongRange;", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ULongRange.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ULongRange getEMPTY() {
            return ULongRange.EMPTY;
        }
    }
}
