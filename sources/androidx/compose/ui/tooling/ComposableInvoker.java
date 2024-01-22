package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.tooling.PreviewLogger;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J1\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fH\u0002¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J=\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0019J(\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\f\"\u0006\b\u0000\u0010\u001b\u0018\u0001*\u0002H\u001b2\u0006\u0010\u001c\u001a\u00020\u0004H\b¢\u0006\u0002\u0010\u001dJ5\u0010\u001e\u001a\u00020\u001f*\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010 J9\u0010!\u001a\u00020\u001f*\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0015\u001a\u00020\u00142\u001a\u0010\u0018\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\r0\f\"\u0006\u0012\u0002\b\u00030\rH\u0002¢\u0006\u0002\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\rH\u0002J=\u0010$\u001a\u0004\u0018\u00010\u0001*\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010&R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/compose/ui/tooling/ComposableInvoker;", "", "()V", "BITS_PER_INT", "", "SLOTS_PER_INT", "changedParamCount", "realValueParams", "thisParams", "compatibleTypes", "", "methodTypes", "", "Ljava/lang/Class;", "actualTypes", "([Ljava/lang/Class;[Ljava/lang/Class;)Z", "defaultParamCount", "invokeComposable", "", "className", "", "methodName", "composer", "Landroidx/compose/runtime/Composer;", "args", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;[Ljava/lang/Object;)V", "dup", "T", "count", "(Ljava/lang/Object;I)[Ljava/lang/Object;", "findComposableMethod", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/reflect/Method;", "getDeclaredCompatibleMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getDefaultValue", "invokeComposableMethod", "instance", "(Ljava/lang/reflect/Method;Ljava/lang/Object;Landroidx/compose/runtime/Composer;[Ljava/lang/Object;)Ljava/lang/Object;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(message = "Use androidx.compose.runtime.reflect.ComposableMethodInvoker instead")
/* compiled from: ComposableInvoker.kt */
public final class ComposableInvoker {
    public static final int $stable = 0;
    private static final int BITS_PER_INT = 31;
    public static final ComposableInvoker INSTANCE = new ComposableInvoker();
    private static final int SLOTS_PER_INT = 10;

    private ComposableInvoker() {
    }

    private final boolean compatibleTypes(Class<?>[] methodTypes, Class<?>[] actualTypes) {
        Iterable $this$all$iv;
        Class<?>[] clsArr = actualTypes;
        if (methodTypes.length != clsArr.length) {
            return false;
        }
        Class[] clsArr2 = methodTypes;
        Collection destination$iv$iv = new ArrayList(clsArr2.length);
        Class[] clsArr3 = clsArr2;
        int index$iv$iv = 0;
        int length = clsArr3.length;
        int i = 0;
        while (i < length) {
            destination$iv$iv.add(Boolean.valueOf(clsArr3[i].isAssignableFrom(clsArr[index$iv$iv])));
            i++;
            index$iv$iv++;
        }
        Iterable $this$all$iv2 = (List) destination$iv$iv;
        if (!($this$all$iv2 instanceof Collection) || !((Collection) $this$all$iv2).isEmpty()) {
            Iterator it = $this$all$iv2.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!((Boolean) it.next()).booleanValue()) {
                        $this$all$iv = null;
                        break;
                    }
                } else {
                    $this$all$iv = 1;
                    break;
                }
            }
        } else {
            $this$all$iv = 1;
        }
        if ($this$all$iv != null) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x004f, code lost:
        if (kotlin.text.StringsKt.startsWith$default(r12, r0 + '-', false, 2, (java.lang.Object) null) != false) goto L_0x0051;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006b A[LOOP:0: B:1:0x001a->B:13:0x006b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.reflect.Method getDeclaredCompatibleMethod(java.lang.Class<?> r16, java.lang.String r17, java.lang.Class<?>... r18) {
        /*
            r15 = this;
            r0 = r17
            r1 = r18
            int r2 = r1.length
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r1, r2)
            java.lang.Class[] r2 = (java.lang.Class[]) r2
            java.lang.reflect.Method[] r3 = r16.getDeclaredMethods()
            java.lang.String r4 = "declaredMethods"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            r4 = 0
            int r5 = r3.length
            r6 = 0
            r7 = r6
        L_0x001a:
            r8 = 0
            if (r7 >= r5) goto L_0x006e
            r9 = r3[r7]
            r10 = r9
            java.lang.reflect.Method r10 = (java.lang.reflect.Method) r10
            r11 = 0
            java.lang.String r12 = r10.getName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r12)
            if (r12 != 0) goto L_0x0051
            java.lang.String r12 = r10.getName()
            java.lang.String r13 = "it.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.StringBuilder r13 = r13.append(r0)
            r14 = 45
            java.lang.StringBuilder r13 = r13.append(r14)
            java.lang.String r13 = r13.toString()
            r14 = 2
            boolean r8 = kotlin.text.StringsKt.startsWith$default(r12, r13, r6, r14, r8)
            if (r8 == 0) goto L_0x0065
        L_0x0051:
            androidx.compose.ui.tooling.ComposableInvoker r8 = INSTANCE
            java.lang.Class[] r12 = r10.getParameterTypes()
            java.lang.String r13 = "it.parameterTypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            boolean r8 = r8.compatibleTypes(r12, r2)
            if (r8 == 0) goto L_0x0065
            r8 = 1
            goto L_0x0066
        L_0x0065:
            r8 = r6
        L_0x0066:
            if (r8 == 0) goto L_0x006b
            r8 = r9
            goto L_0x006f
        L_0x006b:
            int r7 = r7 + 1
            goto L_0x001a
        L_0x006e:
        L_0x006f:
            java.lang.reflect.Method r8 = (java.lang.reflect.Method) r8
            if (r8 == 0) goto L_0x0074
            return r8
        L_0x0074:
            java.lang.NoSuchMethodException r3 = new java.lang.NoSuchMethodException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r4 = r4.append(r0)
            java.lang.String r5 = " not found"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ComposableInvoker.getDeclaredCompatibleMethod(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    private final /* synthetic */ <T> T[] dup(T $this$dup, int count) {
        Iterable $this$map$iv = RangesKt.until(0, count);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        Iterator it = $this$map$iv.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            destination$iv$iv.add($this$dup);
        }
        Intrinsics.reifiedOperationMarker(0, "T?");
        return ((List) destination$iv$iv).toArray(new Object[0]);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d3 A[Catch:{ ReflectiveOperationException -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0111 A[Catch:{ ReflectiveOperationException -> 0x011a }, LOOP:2: B:25:0x00d1->B:39:0x0111, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0110 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0114 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.reflect.Method findComposableMethod(java.lang.Class<?> r23, java.lang.String r24, java.lang.Object... r25) {
        /*
            r22 = this;
            r1 = r22
            r2 = r24
            r4 = 0
            r5 = r25
            int r0 = r5.length     // Catch:{ ReflectiveOperationException -> 0x00bf }
            int r0 = r1.changedParamCount(r0, r4)     // Catch:{ ReflectiveOperationException -> 0x00bf }
            kotlin.jvm.internal.SpreadBuilder r6 = new kotlin.jvm.internal.SpreadBuilder     // Catch:{ ReflectiveOperationException -> 0x00bf }
            r7 = 3
            r6.<init>(r7)     // Catch:{ ReflectiveOperationException -> 0x00bf }
            r7 = r25
            r8 = 0
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ ReflectiveOperationException -> 0x00bf }
            r9.<init>()     // Catch:{ ReflectiveOperationException -> 0x00bf }
            java.util.Collection r9 = (java.util.Collection) r9     // Catch:{ ReflectiveOperationException -> 0x00bf }
            r10 = r7
            r11 = 0
            r12 = r10
            r13 = 0
            int r14 = r12.length     // Catch:{ ReflectiveOperationException -> 0x00bf }
            r15 = r4
        L_0x0024:
            if (r15 >= r14) goto L_0x0048
            r16 = r12[r15]     // Catch:{ ReflectiveOperationException -> 0x00bf }
            r17 = r16
            r18 = 0
            r19 = r17
            r20 = 0
            if (r19 == 0) goto L_0x0037
            java.lang.Class r21 = r19.getClass()     // Catch:{ ReflectiveOperationException -> 0x00bf }
            goto L_0x0039
        L_0x0037:
            r21 = 0
        L_0x0039:
            if (r21 == 0) goto L_0x0044
            r19 = r21
            r20 = 0
            r3 = r19
            r9.add(r3)     // Catch:{ ReflectiveOperationException -> 0x00bf }
        L_0x0044:
            int r15 = r15 + 1
            goto L_0x0024
        L_0x0048:
            r3 = r9
            java.util.List r3 = (java.util.List) r3     // Catch:{ ReflectiveOperationException -> 0x00bf }
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ ReflectiveOperationException -> 0x00bf }
            r7 = 0
            r8 = r3
            java.lang.Class[] r9 = new java.lang.Class[r4]     // Catch:{ ReflectiveOperationException -> 0x00bf }
            java.lang.Object[] r9 = r8.toArray(r9)     // Catch:{ ReflectiveOperationException -> 0x00bf }
            r6.addSpread(r9)     // Catch:{ ReflectiveOperationException -> 0x00bf }
            java.lang.Class<androidx.compose.runtime.Composer> r3 = androidx.compose.runtime.Composer.class
            r6.add(r3)     // Catch:{ ReflectiveOperationException -> 0x00bf }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ ReflectiveOperationException -> 0x00bf }
            r7 = r22
            r8 = 0
            kotlin.ranges.IntRange r9 = kotlin.ranges.RangesKt.until((int) r4, (int) r0)     // Catch:{ ReflectiveOperationException -> 0x00bf }
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch:{ ReflectiveOperationException -> 0x00bf }
            r10 = 0
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ ReflectiveOperationException -> 0x00bf }
            r12 = 10
            int r12 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r12)     // Catch:{ ReflectiveOperationException -> 0x00bf }
            r11.<init>(r12)     // Catch:{ ReflectiveOperationException -> 0x00bf }
            java.util.Collection r11 = (java.util.Collection) r11     // Catch:{ ReflectiveOperationException -> 0x00bf }
            r12 = r9
            r13 = 0
            java.util.Iterator r14 = r12.iterator()     // Catch:{ ReflectiveOperationException -> 0x00bf }
        L_0x007f:
            boolean r15 = r14.hasNext()     // Catch:{ ReflectiveOperationException -> 0x00bf }
            if (r15 == 0) goto L_0x0095
            r15 = r14
            kotlin.collections.IntIterator r15 = (kotlin.collections.IntIterator) r15     // Catch:{ ReflectiveOperationException -> 0x00bf }
            int r15 = r15.nextInt()     // Catch:{ ReflectiveOperationException -> 0x00bf }
            r16 = r15
            r17 = 0
            r11.add(r3)     // Catch:{ ReflectiveOperationException -> 0x00bf }
            goto L_0x007f
        L_0x0095:
            java.util.List r11 = (java.util.List) r11     // Catch:{ ReflectiveOperationException -> 0x00bf }
            java.util.Collection r11 = (java.util.Collection) r11     // Catch:{ ReflectiveOperationException -> 0x00bf }
            r9 = r11
            r10 = 0
            java.lang.Class[] r12 = new java.lang.Class[r4]     // Catch:{ ReflectiveOperationException -> 0x00bf }
            java.lang.Object[] r12 = r11.toArray(r12)     // Catch:{ ReflectiveOperationException -> 0x00bf }
            r6.addSpread(r12)     // Catch:{ ReflectiveOperationException -> 0x00bf }
            int r3 = r6.size()     // Catch:{ ReflectiveOperationException -> 0x00bf }
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ ReflectiveOperationException -> 0x00bf }
            java.lang.Object[] r3 = r6.toArray(r3)     // Catch:{ ReflectiveOperationException -> 0x00bf }
            java.lang.Class[] r3 = (java.lang.Class[]) r3     // Catch:{ ReflectiveOperationException -> 0x00bf }
            r6 = r23
            java.lang.reflect.Method r3 = r1.getDeclaredCompatibleMethod(r6, r2, r3)     // Catch:{ ReflectiveOperationException -> 0x00bd }
            goto L_0x0120
        L_0x00bd:
            r0 = move-exception
            goto L_0x00c2
        L_0x00bf:
            r0 = move-exception
            r6 = r23
        L_0x00c2:
            r3 = r0
            java.lang.reflect.Method[] r0 = r23.getDeclaredMethods()     // Catch:{ ReflectiveOperationException -> 0x011c }
            java.lang.String r7 = "declaredMethods"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r7)     // Catch:{ ReflectiveOperationException -> 0x011c }
            java.lang.Object[] r0 = (java.lang.Object[]) r0     // Catch:{ ReflectiveOperationException -> 0x011c }
            int r7 = r0.length     // Catch:{ ReflectiveOperationException -> 0x011c }
            r8 = r4
        L_0x00d1:
            if (r8 >= r7) goto L_0x0114
            r9 = r0[r8]     // Catch:{ ReflectiveOperationException -> 0x011c }
            r10 = r9
            java.lang.reflect.Method r10 = (java.lang.reflect.Method) r10     // Catch:{ ReflectiveOperationException -> 0x011c }
            r11 = 0
            java.lang.String r12 = r10.getName()     // Catch:{ ReflectiveOperationException -> 0x011c }
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r2)     // Catch:{ ReflectiveOperationException -> 0x011c }
            if (r12 != 0) goto L_0x010b
            java.lang.String r12 = r10.getName()     // Catch:{ ReflectiveOperationException -> 0x011c }
            java.lang.String r13 = "it.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)     // Catch:{ ReflectiveOperationException -> 0x011c }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ ReflectiveOperationException -> 0x011c }
            r13.<init>()     // Catch:{ ReflectiveOperationException -> 0x011c }
            java.lang.StringBuilder r13 = r13.append(r2)     // Catch:{ ReflectiveOperationException -> 0x011c }
            r14 = 45
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ ReflectiveOperationException -> 0x011c }
            java.lang.String r13 = r13.toString()     // Catch:{ ReflectiveOperationException -> 0x011c }
            r14 = 2
            r15 = 0
            boolean r12 = kotlin.text.StringsKt.startsWith$default(r12, r13, r4, r14, r15)     // Catch:{ ReflectiveOperationException -> 0x011a }
            if (r12 == 0) goto L_0x0109
            goto L_0x010c
        L_0x0109:
            r12 = r4
            goto L_0x010d
        L_0x010b:
            r15 = 0
        L_0x010c:
            r12 = 1
        L_0x010d:
            if (r12 == 0) goto L_0x0111
            goto L_0x0116
        L_0x0111:
            int r8 = r8 + 1
            goto L_0x00d1
        L_0x0114:
            r15 = 0
            r9 = r15
        L_0x0116:
            java.lang.reflect.Method r9 = (java.lang.reflect.Method) r9     // Catch:{ ReflectiveOperationException -> 0x011a }
            r15 = r9
            goto L_0x011f
        L_0x011a:
            r0 = move-exception
            goto L_0x011e
        L_0x011c:
            r0 = move-exception
            r15 = 0
        L_0x011e:
        L_0x011f:
            r3 = r15
        L_0x0120:
            if (r3 == 0) goto L_0x0124
            r0 = r3
            return r0
        L_0x0124:
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r23.getName()
            java.lang.StringBuilder r3 = r3.append(r4)
            r4 = 46
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r2)
            java.lang.String r3 = r3.toString()
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ComposableInvoker.findComposableMethod(java.lang.Class, java.lang.String, java.lang.Object[]):java.lang.reflect.Method");
    }

    private final Object getDefaultValue(Class<?> $this$getDefaultValue) {
        String name = $this$getDefaultValue.getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.valueOf(0.0d);
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return 0;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return (byte) 0;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return 0;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return 0L;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return false;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.valueOf(0.0f);
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return (short) 0;
                    }
                    break;
            }
        }
        return null;
    }

    private final Object invokeComposableMethod(Method $this$invokeComposableMethod, Object instance, Composer composer, Object... args) {
        int defaultParams;
        int realParams;
        int i;
        Object obj = instance;
        Class[] parameterTypes = $this$invokeComposableMethod.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "parameterTypes");
        Object[] $this$indexOfLast$iv = (Object[]) parameterTypes;
        int i2 = -1;
        int length = $this$indexOfLast$iv.length - 1;
        if (length >= 0) {
            while (true) {
                int index$iv = length;
                length--;
                if (!Intrinsics.areEqual((Object) (Class) $this$indexOfLast$iv[index$iv], (Object) Composer.class)) {
                    if (length < 0) {
                        break;
                    }
                } else {
                    i2 = index$iv;
                    break;
                }
            }
        }
        int composerIndex = i2;
        int realParams2 = composerIndex;
        int changedParams = changedParamCount(realParams2, obj != null ? 1 : 0);
        int totalParamsWithoutDefaults = realParams2 + 1 + changedParams;
        int totalParams = $this$invokeComposableMethod.getParameterTypes().length;
        if (totalParams != totalParamsWithoutDefaults) {
            defaultParams = defaultParamCount(realParams2);
        } else {
            defaultParams = 0;
        }
        if (((realParams2 + 1) + changedParams) + defaultParams == totalParams) {
            int changedStartIndex = composerIndex + 1;
            int defaultStartIndex = changedStartIndex + changedParams;
            Object[] objArr = new Object[totalParams];
            int i3 = 0;
            while (i3 < totalParams) {
                if (!(i3 >= 0 && i3 < realParams2)) {
                    realParams = realParams2;
                    if (i3 == composerIndex) {
                        i = composer;
                    } else {
                        if (changedStartIndex <= i3 && i3 < defaultStartIndex) {
                            i = 0;
                        } else {
                            if (defaultStartIndex <= i3 && i3 < totalParams) {
                                i = 2097151;
                            } else {
                                throw new IllegalStateException("Unexpected index".toString());
                            }
                        }
                    }
                } else if (i3 < 0 || i3 > ArraysKt.getLastIndex((T[]) args)) {
                    int i4 = i3;
                    ComposableInvoker composableInvoker = INSTANCE;
                    Class cls = $this$invokeComposableMethod.getParameterTypes()[i3];
                    realParams = realParams2;
                    Intrinsics.checkNotNullExpressionValue(cls, "parameterTypes[idx]");
                    i = composableInvoker.getDefaultValue(cls);
                } else {
                    i = args[i3];
                    realParams = realParams2;
                }
                objArr[i3] = i;
                i3++;
                realParams2 = realParams;
            }
            Object[] arguments = objArr;
            return $this$invokeComposableMethod.invoke(obj, Arrays.copyOf(arguments, arguments.length));
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final int changedParamCount(int realValueParams, int thisParams) {
        if (realValueParams == 0) {
            return 1;
        }
        return (int) Math.ceil(((double) (realValueParams + thisParams)) / 10.0d);
    }

    private final int defaultParamCount(int realValueParams) {
        return (int) Math.ceil(((double) realValueParams) / 31.0d);
    }

    public final void invokeComposable(String className, String methodName, Composer composer, Object... args) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            Class composableClass = Class.forName(className);
            Intrinsics.checkNotNullExpressionValue(composableClass, "composableClass");
            Method method = findComposableMethod(composableClass, methodName, Arrays.copyOf(args, args.length));
            method.setAccessible(true);
            if (Modifier.isStatic(method.getModifiers())) {
                invokeComposableMethod(method, (Object) null, composer, Arrays.copyOf(args, args.length));
            } else {
                invokeComposableMethod(method, composableClass.getConstructor(new Class[0]).newInstance(new Object[0]), composer, Arrays.copyOf(args, args.length));
            }
        } catch (ReflectiveOperationException e) {
            PreviewLogger.Companion.logWarning$ui_tooling_release$default(PreviewLogger.Companion, "Failed to invoke Composable Method '" + className + '.' + methodName + '\'', (Throwable) null, 2, (Object) null);
            throw e;
        }
    }
}
