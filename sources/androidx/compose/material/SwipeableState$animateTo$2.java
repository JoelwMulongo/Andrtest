package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "anchors", "", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Swipeable.kt */
final class SwipeableState$animateTo$2 implements FlowCollector<Map<Float, ? extends T>> {
    final /* synthetic */ AnimationSpec<Float> $anim;
    final /* synthetic */ T $targetValue;
    final /* synthetic */ SwipeableState<T> this$0;

    SwipeableState$animateTo$2(T t, SwipeableState<T> swipeableState, AnimationSpec<Float> animationSpec) {
        this.$targetValue = t;
        this.this$0 = swipeableState;
        this.$anim = animationSpec;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: java.util.Map<java.lang.Float, ? extends T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: androidx.compose.material.SwipeableState$animateTo$2} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(java.util.Map<java.lang.Float, ? extends T> r17, kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            r16 = this;
            r0 = r18
            boolean r1 = r0 instanceof androidx.compose.material.SwipeableState$animateTo$2$emit$1
            if (r1 == 0) goto L_0x0019
            r1 = r0
            androidx.compose.material.SwipeableState$animateTo$2$emit$1 r1 = (androidx.compose.material.SwipeableState$animateTo$2$emit$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0019
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r16
            goto L_0x0021
        L_0x0019:
            androidx.compose.material.SwipeableState$animateTo$2$emit$1 r1 = new androidx.compose.material.SwipeableState$animateTo$2$emit$1
            r2 = r16
            r1.<init>(r2, r0)
            r0 = r1
        L_0x0021:
            java.lang.Object r3 = r1.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 0
            r6 = 1056964608(0x3f000000, float:0.5)
            r7 = 1
            switch(r4) {
                case 0: goto L_0x0046;
                case 1: goto L_0x0038;
                default: goto L_0x0030;
            }
        L_0x0030:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0038:
            java.lang.Object r0 = r1.L$1
            r4 = r0
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r0 = r1.L$0
            r8 = r0
            androidx.compose.material.SwipeableState$animateTo$2 r8 = (androidx.compose.material.SwipeableState$animateTo$2) r8
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x00e9 }
            goto L_0x006b
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r3)
            r8 = r16
            r4 = r17
            T r9 = r8.$targetValue     // Catch:{ all -> 0x00e9 }
            java.lang.Float r9 = androidx.compose.material.SwipeableKt.getOffset(r4, r9)     // Catch:{ all -> 0x00e9 }
            if (r9 == 0) goto L_0x00dc
            androidx.compose.material.SwipeableState<T> r10 = r8.this$0     // Catch:{ all -> 0x00e9 }
            float r11 = r9.floatValue()     // Catch:{ all -> 0x00e9 }
            androidx.compose.animation.core.AnimationSpec<java.lang.Float> r12 = r8.$anim     // Catch:{ all -> 0x00e9 }
            r1.L$0 = r8     // Catch:{ all -> 0x00e9 }
            r1.L$1 = r4     // Catch:{ all -> 0x00e9 }
            r1.label = r7     // Catch:{ all -> 0x00e9 }
            java.lang.Object r10 = r10.animateInternalToOffset(r11, r12, r1)     // Catch:{ all -> 0x00e9 }
            if (r10 != r0) goto L_0x006b
            return r0
        L_0x006b:
            androidx.compose.material.SwipeableState<T> r0 = r8.this$0
            androidx.compose.runtime.MutableState r0 = r0.absoluteOffset
            java.lang.Object r0 = r0.getValue()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            r9 = 0
            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap
            r10.<init>()
            java.util.Set r11 = r4.entrySet()
            java.util.Iterator r4 = r11.iterator()
        L_0x008a:
            boolean r11 = r4.hasNext()
            if (r11 == 0) goto L_0x00bc
            java.lang.Object r11 = r4.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r12 = r11.getKey()
            java.lang.Number r12 = (java.lang.Number) r12
            float r12 = r12.floatValue()
            r13 = 0
            float r14 = r12 - r0
            float r12 = java.lang.Math.abs(r14)
            int r12 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r12 >= 0) goto L_0x00ad
            r12 = r7
            goto L_0x00ae
        L_0x00ad:
            r12 = r5
        L_0x00ae:
            if (r12 == 0) goto L_0x008a
            java.lang.Object r12 = r11.getKey()
            java.lang.Object r13 = r11.getValue()
            r10.put(r12, r13)
            goto L_0x008a
        L_0x00bc:
            r0 = r10
            java.util.Map r0 = (java.util.Map) r0
            java.util.Collection r0 = r0.values()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            if (r0 != 0) goto L_0x00d2
            androidx.compose.material.SwipeableState<T> r0 = r8.this$0
            java.lang.Object r0 = r0.getCurrentValue()
        L_0x00d2:
            androidx.compose.material.SwipeableState<T> r4 = r8.this$0
            r4.setCurrentValue(r0)
            r0 = r8
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x00dc:
            r0 = 0
            java.lang.String r9 = "The target value must have an associated anchor."
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00e9 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00e9 }
            r0.<init>(r9)     // Catch:{ all -> 0x00e9 }
            throw r0     // Catch:{ all -> 0x00e9 }
        L_0x00e9:
            r0 = move-exception
            androidx.compose.material.SwipeableState<T> r9 = r8.this$0
            androidx.compose.runtime.MutableState r9 = r9.absoluteOffset
            java.lang.Object r9 = r9.getValue()
            java.lang.Number r9 = (java.lang.Number) r9
            float r9 = r9.floatValue()
            r10 = 0
            java.util.LinkedHashMap r11 = new java.util.LinkedHashMap
            r11.<init>()
            java.util.Set r12 = r4.entrySet()
            java.util.Iterator r4 = r12.iterator()
        L_0x0109:
            boolean r12 = r4.hasNext()
            if (r12 == 0) goto L_0x013b
            java.lang.Object r12 = r4.next()
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12
            java.lang.Object r13 = r12.getKey()
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            r14 = 0
            float r15 = r13 - r9
            float r13 = java.lang.Math.abs(r15)
            int r13 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r13 >= 0) goto L_0x012c
            r13 = r7
            goto L_0x012d
        L_0x012c:
            r13 = r5
        L_0x012d:
            if (r13 == 0) goto L_0x0109
            java.lang.Object r13 = r12.getKey()
            java.lang.Object r14 = r12.getValue()
            r11.put(r13, r14)
            goto L_0x0109
        L_0x013b:
            r4 = r11
            java.util.Map r4 = (java.util.Map) r4
            java.util.Collection r4 = r4.values()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.lang.Object r4 = kotlin.collections.CollectionsKt.firstOrNull(r4)
            if (r4 != 0) goto L_0x0151
            androidx.compose.material.SwipeableState<T> r4 = r8.this$0
            java.lang.Object r4 = r4.getCurrentValue()
        L_0x0151:
            androidx.compose.material.SwipeableState<T> r5 = r8.this$0
            r5.setCurrentValue(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableState$animateTo$2.emit(java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
