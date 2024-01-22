package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a>\u0010\b\u001a\u00020\u0004*\u00020\u00062'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n¢\u0006\u0002\b\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a>\u0010\u000f\u001a\u00020\u0004*\u00020\u00062'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n¢\u0006\u0002\b\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"allPointersUp", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "awaitAllPointersUp", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitEachGesture", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forEachGesture", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ForEachGesture.kt */
public final class ForEachGestureKt {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>, code=kotlin.jvm.functions.Function2, for r7v0, types: [kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>] */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076 A[SYNTHETIC, Splitter:B:22:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @kotlin.Deprecated(message = "Use awaitEachGesture instead. forEachGesture() can drop events between gestures.", replaceWith = @kotlin.ReplaceWith(expression = "awaitEachGesture(block)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object forEachGesture(androidx.compose.ui.input.pointer.PointerInputScope r6, kotlin.jvm.functions.Function2 r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1 r0 = (androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1 r0 = new androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1
            r0.<init>(r8)
        L_0x0019:
            r8 = r0
            java.lang.Object r0 = r8.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r8.label
            switch(r2) {
                case 0: goto L_0x0066;
                case 1: goto L_0x0054;
                case 2: goto L_0x0041;
                case 3: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x002d:
            java.lang.Object r6 = r8.L$2
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
            java.lang.Object r7 = r8.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r2 = r8.L$0
            androidx.compose.ui.input.pointer.PointerInputScope r2 = (androidx.compose.ui.input.pointer.PointerInputScope) r2
            kotlin.ResultKt.throwOnFailure(r0)
            r5 = r2
            r2 = r6
            r6 = r5
            goto L_0x00ba
        L_0x0041:
            java.lang.Object r6 = r8.L$2
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
            java.lang.Object r7 = r8.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r2 = r8.L$0
            androidx.compose.ui.input.pointer.PointerInputScope r2 = (androidx.compose.ui.input.pointer.PointerInputScope) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ CancellationException -> 0x0064 }
            r5 = r2
            r2 = r6
            r6 = r5
            goto L_0x009c
        L_0x0054:
            java.lang.Object r6 = r8.L$2
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
            java.lang.Object r7 = r8.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r2 = r8.L$0
            androidx.compose.ui.input.pointer.PointerInputScope r2 = (androidx.compose.ui.input.pointer.PointerInputScope) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ CancellationException -> 0x0064 }
            goto L_0x0089
        L_0x0064:
            r3 = move-exception
            goto L_0x00a1
        L_0x0066:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = 0
            kotlin.coroutines.CoroutineContext r3 = r8.getContext()
            r2 = r3
        L_0x006f:
            boolean r3 = kotlinx.coroutines.JobKt.isActive(r2)
            if (r3 == 0) goto L_0x00bc
            r8.L$0 = r6     // Catch:{ CancellationException -> 0x009d }
            r8.L$1 = r7     // Catch:{ CancellationException -> 0x009d }
            r8.L$2 = r2     // Catch:{ CancellationException -> 0x009d }
            r3 = 1
            r8.label = r3     // Catch:{ CancellationException -> 0x009d }
            java.lang.Object r3 = r7.invoke(r6, r8)     // Catch:{ CancellationException -> 0x009d }
            if (r3 != r1) goto L_0x0086
            return r1
        L_0x0086:
            r5 = r2
            r2 = r6
            r6 = r5
        L_0x0089:
            r8.L$0 = r2     // Catch:{ CancellationException -> 0x0064 }
            r8.L$1 = r7     // Catch:{ CancellationException -> 0x0064 }
            r8.L$2 = r6     // Catch:{ CancellationException -> 0x0064 }
            r3 = 2
            r8.label = r3     // Catch:{ CancellationException -> 0x0064 }
            java.lang.Object r3 = awaitAllPointersUp((androidx.compose.ui.input.pointer.PointerInputScope) r2, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r8)     // Catch:{ CancellationException -> 0x0064 }
            if (r3 != r1) goto L_0x0099
            return r1
        L_0x0099:
            r5 = r2
            r2 = r6
            r6 = r5
        L_0x009c:
            goto L_0x006f
        L_0x009d:
            r3 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
        L_0x00a1:
            boolean r4 = kotlinx.coroutines.JobKt.isActive(r6)
            if (r4 == 0) goto L_0x00bb
            r8.L$0 = r2
            r8.L$1 = r7
            r8.L$2 = r6
            r3 = 3
            r8.label = r3
            java.lang.Object r3 = awaitAllPointersUp((androidx.compose.ui.input.pointer.PointerInputScope) r2, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r8)
            if (r3 != r1) goto L_0x00b7
            return r1
        L_0x00b7:
            r5 = r2
            r2 = r6
            r6 = r5
        L_0x00ba:
            goto L_0x006f
        L_0x00bb:
            throw r3
        L_0x00bc:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ForEachGestureKt.forEachGesture(androidx.compose.ui.input.pointer.PointerInputScope, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final boolean allPointersUp(AwaitPointerEventScope $this$allPointersUp) {
        boolean z;
        Intrinsics.checkNotNullParameter($this$allPointersUp, "<this>");
        List $this$fastForEach$iv$iv = $this$allPointersUp.getCurrentEvent().getChanges();
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (true) {
            if (index$iv$iv >= size) {
                z = false;
                break;
            } else if (((PointerInputChange) $this$fastForEach$iv$iv.get(index$iv$iv)).getPressed()) {
                z = true;
                break;
            } else {
                index$iv$iv++;
            }
        }
        return !z;
    }

    public static final Object awaitAllPointersUp(PointerInputScope $this$awaitAllPointersUp, Continuation<? super Unit> $completion) {
        Object awaitPointerEventScope = $this$awaitAllPointersUp.awaitPointerEventScope(new ForEachGestureKt$awaitAllPointersUp$2((Continuation<? super ForEachGestureKt$awaitAllPointersUp$2>) null), $completion);
        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        if (allPointersUp(r14) == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        r2 = androidx.compose.ui.input.pointer.PointerEventPass.Final;
        r15.L$0 = r14;
        r15.label = 1;
        r2 = r14.awaitPointerEvent(r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004b, code lost:
        if (r2 != r1) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        r13 = r1;
        r1 = r0;
        r0 = r2;
        r2 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        r0 = ((androidx.compose.ui.input.pointer.PointerEvent) r0).getChanges();
        r6 = 0;
        r7 = r0.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0062, code lost:
        if (r6 >= r7) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        if (((androidx.compose.ui.input.pointer.PointerInputChange) r0.get(r6)).getPressed() == false) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0074, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0076, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007a, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007c, code lost:
        if (r0 != null) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007e, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0080, code lost:
        r0 = r1;
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0085, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object awaitAllPointersUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            boolean r0 = r15 instanceof androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3
            if (r0 == 0) goto L_0x0014
            r0 = r15
            androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3 r0 = (androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3 r0 = new androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3
            r0.<init>(r15)
        L_0x0019:
            r15 = r0
            java.lang.Object r0 = r15.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r15.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x0038;
                case 1: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x002e:
            java.lang.Object r14 = r15.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r1
            r1 = r0
            goto L_0x0052
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r0)
            boolean r2 = allPointersUp(r14)
            if (r2 != 0) goto L_0x0083
        L_0x0041:
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r15.L$0 = r14
            r15.label = r3
            java.lang.Object r2 = r14.awaitPointerEvent(r2, r15)
            if (r2 != r1) goto L_0x004e
            return r1
        L_0x004e:
            r13 = r1
            r1 = r0
            r0 = r2
            r2 = r13
        L_0x0052:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            java.util.List r0 = r0.getChanges()
            r4 = 0
            r5 = 0
            r6 = 0
            int r7 = r0.size()
        L_0x0062:
            if (r6 >= r7) goto L_0x007a
            java.lang.Object r8 = r0.get(r6)
            r9 = r8
            r10 = 0
            r11 = r9
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            r12 = 0
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L_0x0076
            r0 = r3
            goto L_0x007c
        L_0x0076:
            int r6 = r6 + 1
            goto L_0x0062
        L_0x007a:
            r0 = 0
        L_0x007c:
            if (r0 != 0) goto L_0x0080
            r0 = r1
            goto L_0x0083
        L_0x0080:
            r0 = r1
            r1 = r2
            goto L_0x0041
        L_0x0083:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ForEachGestureKt.awaitAllPointersUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object awaitEachGesture(PointerInputScope $this$awaitEachGesture, Function2<? super AwaitPointerEventScope, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        Object awaitPointerEventScope = $this$awaitEachGesture.awaitPointerEventScope(new ForEachGestureKt$awaitEachGesture$2($completion.getContext(), block, (Continuation<? super ForEachGestureKt$awaitEachGesture$2>) null), $completion);
        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
    }
}
