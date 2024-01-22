package androidx.compose.ui.text.intl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0003\b\u0007\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0007\"\u00020\u0002¢\u0006\u0002\u0010\bB\u0013\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0016\u0010\u0015\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016J\u0013\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0011\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0004H\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Landroidx/compose/ui/text/intl/LocaleList;", "", "Landroidx/compose/ui/text/intl/Locale;", "languageTags", "", "(Ljava/lang/String;)V", "locales", "", "([Landroidx/compose/ui/text/intl/Locale;)V", "localeList", "", "(Ljava/util/List;)V", "getLocaleList", "()Ljava/util/List;", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "equals", "other", "", "get", "i", "hashCode", "isEmpty", "iterator", "", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LocaleList.kt */
public final class LocaleList implements Collection<Locale>, KMappedMarker {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<Locale> localeList;
    private final int size;

    public boolean add(Locale locale) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends Locale> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeIf(Predicate<? super Locale> predicate) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.toArray(this, tArr);
    }

    public LocaleList(List<Locale> localeList2) {
        Intrinsics.checkNotNullParameter(localeList2, "localeList");
        this.localeList = localeList2;
        this.size = localeList2.size();
    }

    public final /* bridge */ boolean contains(Object element) {
        if (!(element instanceof Locale)) {
            return false;
        }
        return contains((Locale) element);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/intl/LocaleList$Companion;", "", "()V", "current", "Landroidx/compose/ui/text/intl/LocaleList;", "getCurrent", "()Landroidx/compose/ui/text/intl/LocaleList;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LocaleList.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LocaleList getCurrent() {
            return PlatformLocaleKt.getPlatformLocaleDelegate().getCurrent();
        }
    }

    public final List<Locale> getLocaleList() {
        return this.localeList;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LocaleList(java.lang.String r15) {
        /*
            r14 = this;
            java.lang.String r0 = "languageTags"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r1 = r15
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r0 = ","
            java.lang.String[] r2 = new java.lang.String[]{r0}
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            java.util.List r0 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r1, (java.lang.String[]) r2, (boolean) r3, (int) r4, (int) r5, (java.lang.Object) r6)
            r1 = 0
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r0.size()
            r2.<init>(r3)
            r3 = r0
            r4 = 0
            r5 = 0
            int r6 = r3.size()
        L_0x002a:
            if (r5 >= r6) goto L_0x004c
            java.lang.Object r7 = r3.get(r5)
            r8 = r7
            r9 = 0
            r10 = r2
            java.util.Collection r10 = (java.util.Collection) r10
            r11 = r8
            java.lang.String r11 = (java.lang.String) r11
            r12 = 0
            r13 = r11
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            java.lang.CharSequence r13 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r13)
            java.lang.String r13 = r13.toString()
            r10.add(r13)
            int r5 = r5 + 1
            goto L_0x002a
        L_0x004c:
            r0 = r2
            java.util.List r0 = (java.util.List) r0
            r1 = 0
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r0.size()
            r2.<init>(r3)
            r3 = r0
            r4 = 0
            r5 = 0
            int r6 = r3.size()
        L_0x0064:
            if (r5 >= r6) goto L_0x0080
            java.lang.Object r7 = r3.get(r5)
            r8 = r7
            r9 = 0
            r10 = r2
            java.util.Collection r10 = (java.util.Collection) r10
            r11 = r8
            java.lang.String r11 = (java.lang.String) r11
            r12 = 0
            androidx.compose.ui.text.intl.Locale r13 = new androidx.compose.ui.text.intl.Locale
            r13.<init>((java.lang.String) r11)
            r10.add(r13)
            int r5 = r5 + 1
            goto L_0x0064
        L_0x0080:
            r0 = r2
            java.util.List r0 = (java.util.List) r0
            r14.<init>((java.util.List<androidx.compose.ui.text.intl.Locale>) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.intl.LocaleList.<init>(java.lang.String):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LocaleList(Locale... locales) {
        this((List<Locale>) ArraysKt.toList((T[]) locales));
        Intrinsics.checkNotNullParameter(locales, "locales");
    }

    public final Locale get(int i) {
        return this.localeList.get(i);
    }

    public int getSize() {
        return this.size;
    }

    public boolean contains(Locale element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.localeList.contains(element);
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.localeList.containsAll(elements);
    }

    public boolean isEmpty() {
        return this.localeList.isEmpty();
    }

    public Iterator<Locale> iterator() {
        return this.localeList.iterator();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof LocaleList) && Intrinsics.areEqual((Object) this.localeList, (Object) ((LocaleList) other).localeList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.localeList.hashCode();
    }

    public String toString() {
        return "LocaleList(localeList=" + this.localeList + ')';
    }
}
