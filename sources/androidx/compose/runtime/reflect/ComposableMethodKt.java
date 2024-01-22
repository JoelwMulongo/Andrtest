package androidx.compose.runtime.reflect;

import androidx.compose.runtime.Composer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b\u001a(\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u0002H\u000b2\u0006\u0010\f\u001a\u00020\u0001H\b¢\u0006\u0002\u0010\r\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\bH\u0002\u001a7\u0010\u0010\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u001a\u0010\u0014\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00110\n\"\u0006\u0012\u0002\b\u00030\u0011¢\u0006\u0002\u0010\u0015\u001a\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u0006\u0012\u0002\b\u00030\u0011H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"BITS_PER_INT", "", "changedParamCount", "realValueParams", "thisParams", "defaultParamCount", "asComposableMethod", "Landroidx/compose/runtime/reflect/ComposableMethod;", "Ljava/lang/reflect/Method;", "dup", "", "T", "count", "(Ljava/lang/Object;I)[Ljava/lang/Object;", "getComposableInfo", "Landroidx/compose/runtime/reflect/ComposableInfo;", "getDeclaredComposableMethod", "Ljava/lang/Class;", "methodName", "", "args", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Landroidx/compose/runtime/reflect/ComposableMethod;", "getDefaultValue", "", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposableMethod.kt */
public final class ComposableMethodKt {
    private static final int BITS_PER_INT = 31;

    private static final int changedParamCount(int realValueParams, int thisParams) {
        if (realValueParams == 0) {
            return 1;
        }
        return (int) Math.ceil(((double) (realValueParams + thisParams)) / 10.0d);
    }

    private static final int defaultParamCount(int realValueParams) {
        return (int) Math.ceil(((double) realValueParams) / 31.0d);
    }

    private static final ComposableInfo getComposableInfo(Method $this$getComposableInfo) {
        int index$iv;
        int defaultParams;
        Class[] parameterTypes = $this$getComposableInfo.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "parameterTypes");
        Object[] $this$indexOfLast$iv = (Object[]) parameterTypes;
        int length = $this$indexOfLast$iv.length - 1;
        if (length >= 0) {
            while (true) {
                index$iv = length;
                length--;
                if (!Intrinsics.areEqual((Object) (Class) $this$indexOfLast$iv[index$iv], (Object) Composer.class)) {
                    if (length < 0) {
                        break;
                    }
                } else {
                    break;
                }
            }
        } else {
            index$iv = -1;
        }
        int realParamsCount = index$iv;
        boolean z = false;
        if (realParamsCount == -1) {
            return new ComposableInfo(false, $this$getComposableInfo.getParameterTypes().length, 0, 0);
        }
        int changedParams = changedParamCount(realParamsCount, (int) (Modifier.isStatic($this$getComposableInfo.getModifiers()) ^ 1));
        int totalParamsWithoutDefaults = realParamsCount + 1 + changedParams;
        int totalParams = $this$getComposableInfo.getParameterTypes().length;
        if (totalParams != totalParamsWithoutDefaults) {
            defaultParams = defaultParamCount(realParamsCount);
        } else {
            defaultParams = 0;
        }
        if (totalParamsWithoutDefaults + defaultParams == totalParams) {
            z = true;
        }
        return new ComposableInfo(z, realParamsCount, changedParams, defaultParams);
    }

    /* access modifiers changed from: private */
    public static final Object getDefaultValue(Class<?> $this$getDefaultValue) {
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

    public static final ComposableMethod asComposableMethod(Method $this$asComposableMethod) {
        Intrinsics.checkNotNullParameter($this$asComposableMethod, "<this>");
        ComposableInfo composableInfo = getComposableInfo($this$asComposableMethod);
        if (composableInfo.isComposable()) {
            return new ComposableMethod($this$asComposableMethod, composableInfo);
        }
        return null;
    }

    private static final /* synthetic */ <T> T[] dup(T $this$dup, int count) {
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

    public static final ComposableMethod getDeclaredComposableMethod(Class<?> $this$getDeclaredComposableMethod, String methodName, Class<?>... args) throws NoSuchMethodException {
        Method method;
        Class<?> cls = $this$getDeclaredComposableMethod;
        String str = methodName;
        Class<?>[] clsArr = args;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(str, "methodName");
        Intrinsics.checkNotNullParameter(clsArr, "args");
        int changedParams = changedParamCount(clsArr.length, 0);
        try {
            SpreadBuilder spreadBuilder = new SpreadBuilder(3);
            spreadBuilder.addSpread(clsArr);
            spreadBuilder.add(Composer.class);
            Object $this$dup$iv = Integer.TYPE;
            Iterable $this$map$iv$iv = RangesKt.until(0, changedParams);
            Collection destination$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv, 10));
            Iterator it = $this$map$iv$iv.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                destination$iv$iv$iv.add($this$dup$iv);
            }
            Collection thisCollection$iv$iv = (List) destination$iv$iv$iv;
            Collection collection = thisCollection$iv$iv;
            spreadBuilder.addSpread(thisCollection$iv$iv.toArray(new Class[0]));
            method = cls.getDeclaredMethod(str, (Class[]) spreadBuilder.toArray(new Class[spreadBuilder.size()]));
        } catch (ReflectiveOperationException e) {
            ReflectiveOperationException reflectiveOperationException = e;
            int defaultParams = defaultParamCount(clsArr.length);
            try {
                SpreadBuilder spreadBuilder2 = new SpreadBuilder(4);
                spreadBuilder2.addSpread(clsArr);
                spreadBuilder2.add(Composer.class);
                Object $this$dup$iv2 = Integer.TYPE;
                Iterable $this$map$iv$iv2 = RangesKt.until(0, changedParams);
                Collection destination$iv$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv2, 10));
                Iterator it2 = $this$map$iv$iv2.iterator();
                while (it2.hasNext()) {
                    int nextInt2 = ((IntIterator) it2).nextInt();
                    destination$iv$iv$iv2.add($this$dup$iv2);
                }
                Collection thisCollection$iv$iv2 = (List) destination$iv$iv$iv2;
                Collection collection2 = thisCollection$iv$iv2;
                spreadBuilder2.addSpread(thisCollection$iv$iv2.toArray(new Class[0]));
                Object $this$dup$iv3 = Integer.TYPE;
                Iterable $this$map$iv$iv3 = RangesKt.until(0, defaultParams);
                Collection destination$iv$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv3, 10));
                Iterator it3 = $this$map$iv$iv3.iterator();
                while (it3.hasNext()) {
                    int nextInt3 = ((IntIterator) it3).nextInt();
                    destination$iv$iv$iv3.add($this$dup$iv3);
                }
                spreadBuilder2.addSpread(((List) destination$iv$iv$iv3).toArray(new Class[0]));
                method = cls.getDeclaredMethod(str, (Class[]) spreadBuilder2.toArray(new Class[spreadBuilder2.size()]));
            } catch (ReflectiveOperationException e2) {
                method = null;
            }
        }
        if (method != null) {
            ComposableMethod asComposableMethod = asComposableMethod(method);
            Intrinsics.checkNotNull(asComposableMethod);
            return asComposableMethod;
        }
        throw new NoSuchMethodException($this$getDeclaredComposableMethod.getName() + '.' + str);
    }
}
