package androidx.compose.runtime.saveable;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0018\u00010\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u0007\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u001c\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u0003H\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000eH\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u000bX\u0004¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e0\r0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/saveable/SaveableStateRegistryImpl;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "restored", "", "", "", "", "canBeSaved", "Lkotlin/Function1;", "", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "", "valueProviders", "", "Lkotlin/Function0;", "value", "consumeRestored", "key", "performSave", "registerProvider", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "valueProvider", "runtime-saveable_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SaveableStateRegistry.kt */
final class SaveableStateRegistryImpl implements SaveableStateRegistry {
    private final Function1<Object, Boolean> canBeSaved;
    private final Map<String, List<Object>> restored;
    /* access modifiers changed from: private */
    public final Map<String, List<Function0<Object>>> valueProviders;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r0 = kotlin.collections.MapsKt.toMutableMap(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SaveableStateRegistryImpl(java.util.Map<java.lang.String, ? extends java.util.List<? extends java.lang.Object>> r2, kotlin.jvm.functions.Function1<java.lang.Object, java.lang.Boolean> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "canBeSaved"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r1.<init>()
            r1.canBeSaved = r3
            if (r2 == 0) goto L_0x0012
            java.util.Map r0 = kotlin.collections.MapsKt.toMutableMap(r2)
            if (r0 != 0) goto L_0x0019
        L_0x0012:
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Map r0 = (java.util.Map) r0
        L_0x0019:
            r1.restored = r0
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Map r0 = (java.util.Map) r0
            r1.valueProviders = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.saveable.SaveableStateRegistryImpl.<init>(java.util.Map, kotlin.jvm.functions.Function1):void");
    }

    public boolean canBeSaved(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return this.canBeSaved.invoke(value).booleanValue();
    }

    public Object consumeRestored(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        List list = this.restored.remove(key);
        if (list == null || !(!list.isEmpty())) {
            return null;
        }
        if (list.size() > 1) {
            this.restored.put(key, list.subList(1, list.size()));
        }
        return list.get(0);
    }

    public SaveableStateRegistry.Entry registerProvider(String key, Function0<? extends Object> valueProvider) {
        Object answer$iv;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(valueProvider, "valueProvider");
        if (!StringsKt.isBlank(key)) {
            Map $this$getOrPut$iv = this.valueProviders;
            Object value$iv = $this$getOrPut$iv.get(key);
            if (value$iv == null) {
                answer$iv = (List) new ArrayList();
                $this$getOrPut$iv.put(key, answer$iv);
            } else {
                answer$iv = value$iv;
            }
            ((List) answer$iv).add(valueProvider);
            return new SaveableStateRegistryImpl$registerProvider$3(this, key, valueProvider);
        }
        throw new IllegalArgumentException("Registered key is empty or blank".toString());
    }

    public Map<String, List<Object>> performSave() {
        Map map = MapsKt.toMutableMap(this.restored);
        for (Map.Entry element$iv : this.valueProviders.entrySet()) {
            String key = (String) element$iv.getKey();
            List list = (List) element$iv.getValue();
            int index = 0;
            if (list.size() == 1) {
                Object value = ((Function0) list.get(0)).invoke();
                if (value == null) {
                    continue;
                } else if (canBeSaved(value)) {
                    map.put(key, CollectionsKt.arrayListOf(value));
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                int size = list.size();
                ArrayList arrayList = new ArrayList(size);
                while (index < size) {
                    Object value2 = ((Function0) list.get(index)).invoke();
                    if (value2 == null || canBeSaved(value2)) {
                        arrayList.add(value2);
                        index++;
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                }
                map.put(key, arrayList);
            }
        }
        return map;
    }
}
