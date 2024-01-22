package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2", f = "LazyAnimateScroll.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1}, l = {137, 233}, m = "invokeSuspend", n = {"$this$scroll", "loop", "anim", "loops", "targetDistancePx", "boundDistancePx", "minDistancePx", "forward", "$this$scroll"}, s = {"L$0", "L$1", "L$2", "L$3", "F$0", "F$1", "F$2", "I$0", "L$0"})
/* compiled from: LazyAnimateScroll.kt */
final class LazyAnimateScrollKt$animateScrollToItem$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ int $scrollOffset;
    final /* synthetic */ LazyAnimateScrollScope $this_animateScrollToItem;
    float F$0;
    float F$1;
    float F$2;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyAnimateScrollKt$animateScrollToItem$2(int i, LazyAnimateScrollScope lazyAnimateScrollScope, int i2, Continuation<? super LazyAnimateScrollKt$animateScrollToItem$2> continuation) {
        super(2, continuation);
        this.$index = i;
        this.$this_animateScrollToItem = lazyAnimateScrollScope;
        this.$scrollOffset = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LazyAnimateScrollKt$animateScrollToItem$2 lazyAnimateScrollKt$animateScrollToItem$2 = new LazyAnimateScrollKt$animateScrollToItem$2(this.$index, this.$this_animateScrollToItem, this.$scrollOffset, continuation);
        lazyAnimateScrollKt$animateScrollToItem$2.L$0 = obj;
        return lazyAnimateScrollKt$animateScrollToItem$2;
    }

    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((LazyAnimateScrollKt$animateScrollToItem$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: androidx.compose.foundation.gestures.ScrollScope} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00dd, code lost:
        if (r9.element == false) goto L_0x01de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e5, code lost:
        if (r6.$this_animateScrollToItem.getItemCount() <= 0) goto L_0x01de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e7, code lost:
        r4 = r6.$this_animateScrollToItem.expectedDistanceTo(r6.$index, r6.$scrollOffset);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f7, code lost:
        if (java.lang.Math.abs(r4) >= r14) goto L_0x0108;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r4 = java.lang.Math.max(java.lang.Math.abs(r4), r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0101, code lost:
        if (r0 == 0) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0103, code lost:
        r12 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0105, code lost:
        r12 = -r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0108, code lost:
        if (r0 == 0) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x010a, code lost:
        r12 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010c, code lost:
        r12 = -r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r4 = r6.$index;
        r4 = r6.$scrollOffset;
        r4 = r6.$this_animateScrollToItem;
        r10.element = androidx.compose.animation.core.AnimationStateKt.copy$default(r10.element, 0.0f, 0.0f, 0, 0, false, 30, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0137, code lost:
        r5 = r13;
        r13 = new kotlin.jvm.internal.Ref.FloatRef();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r22 = r10.element;
        r23 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0155, code lost:
        if (((java.lang.Number) r10.element.getVelocity()).floatValue() != r3) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0157, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0159, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x015a, code lost:
        if (r4 != false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x015c, code lost:
        r25 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x015f, code lost:
        r25 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0161, code lost:
        r3 = r6.$this_animateScrollToItem;
        r2 = r6.$index;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0167, code lost:
        if (r0 == 0) goto L_0x016c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0169, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x016c, code lost:
        r16 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x016e, code lost:
        r35 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r31 = r9;
        r32 = r10;
        r10 = r3;
        r3 = r11;
        r11 = r2;
        r2 = r14;
        r14 = r5;
        r33 = r15;
        r15 = r31;
        r17 = r33;
        r18 = r3;
        r19 = r6.$scrollOffset;
        r20 = r32;
        r6.L$0 = r5;
        r11 = r31;
        r6.L$1 = r11;
        r12 = r32;
        r6.L$2 = r12;
        r6.L$3 = r3;
        r6.F$0 = r2;
        r9 = r33;
        r6.F$1 = r9;
        r6.F$2 = r8;
        r6.I$0 = r0;
        r6.label = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01b4, code lost:
        if (androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r22, r23, (androidx.compose.animation.core.AnimationSpec) null, r25, new androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.AnonymousClass3(), r6, 2, (java.lang.Object) null) != r1) goto L_0x01b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01b6, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01b7, code lost:
        r7 = r35;
        r14 = r2;
        r13 = r5;
        r15 = r9;
        r9 = r11;
        r10 = r12;
        r11 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r11.element++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01c5, code lost:
        r2 = r34;
        r3 = 0.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01cb, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01cc, code lost:
        r2 = r0;
        r0 = r6;
        r3 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01d0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01d1, code lost:
        r7 = r35;
        r2 = r0;
        r3 = r5;
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01d7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01d8, code lost:
        r35 = r7;
        r2 = r0;
        r3 = r5;
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01de, code lost:
        r12 = r10;
        r3 = r11;
        r5 = r13;
        r2 = r14;
        r11 = r9;
        r9 = r15;
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01ea, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01eb, code lost:
        r35 = r7;
        r2 = r0;
        r3 = r13;
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x023c, code lost:
        r21 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x023f, code lost:
        r21 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0267, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0268, code lost:
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0269, code lost:
        r0.$this_animateScrollToItem.snapToItem(r3, r0.$index, r0.$scrollOffset);
        r6 = r0;
        r7 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0276, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0267 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0268  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r35) {
        /*
            r34 = this;
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r2 = r34
            int r0 = r2.label
            r3 = 0
            r5 = 1
            switch(r0) {
                case 0: goto L_0x004e;
                case 1: goto L_0x0022;
                case 2: goto L_0x0015;
                default: goto L_0x000d;
            }
        L_0x000d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0015:
            r0 = r34
            r1 = r35
            java.lang.Object r3 = r0.L$0
            androidx.compose.foundation.gestures.ScrollScope r3 = (androidx.compose.foundation.gestures.ScrollScope) r3
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0269
        L_0x0022:
            r6 = r34
            r7 = r35
            int r0 = r6.I$0
            float r8 = r6.F$2
            float r9 = r6.F$1
            float r10 = r6.F$0
            java.lang.Object r11 = r6.L$3
            kotlin.jvm.internal.Ref$IntRef r11 = (kotlin.jvm.internal.Ref.IntRef) r11
            java.lang.Object r12 = r6.L$2
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r6.L$1
            kotlin.jvm.internal.Ref$BooleanRef r13 = (kotlin.jvm.internal.Ref.BooleanRef) r13
            java.lang.Object r14 = r6.L$0
            androidx.compose.foundation.gestures.ScrollScope r14 = (androidx.compose.foundation.gestures.ScrollScope) r14
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ ItemFoundInScroll -> 0x0048 }
            r15 = r9
            r9 = r13
            r13 = r14
            r14 = r10
            r10 = r12
            goto L_0x01bf
        L_0x0048:
            r0 = move-exception
            r2 = r0
            r0 = r6
            r3 = r14
            goto L_0x0204
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r35)
            r6 = r34
            r7 = r35
            java.lang.Object r0 = r6.L$0
            r8 = r0
            androidx.compose.foundation.gestures.ScrollScope r8 = (androidx.compose.foundation.gestures.ScrollScope) r8
            int r0 = r6.$index
            float r9 = (float) r0
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 < 0) goto L_0x0063
            r9 = r5
            goto L_0x0064
        L_0x0063:
            r9 = 0
        L_0x0064:
            if (r9 == 0) goto L_0x0277
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r0 = r6.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x0200 }
            androidx.compose.ui.unit.Density r0 = r0.getDensity()     // Catch:{ ItemFoundInScroll -> 0x0200 }
            r9 = 0
            float r10 = androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.TargetDistance     // Catch:{ ItemFoundInScroll -> 0x0200 }
            float r10 = r0.m5967toPx0680j_4(r10)     // Catch:{ ItemFoundInScroll -> 0x0200 }
            r0 = r10
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r9 = r6.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x0200 }
            androidx.compose.ui.unit.Density r9 = r9.getDensity()     // Catch:{ ItemFoundInScroll -> 0x0200 }
            r10 = 0
            float r11 = androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.BoundDistance     // Catch:{ ItemFoundInScroll -> 0x0200 }
            float r11 = r9.m5967toPx0680j_4(r11)     // Catch:{ ItemFoundInScroll -> 0x0200 }
            r9 = r11
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r10 = r6.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x0200 }
            androidx.compose.ui.unit.Density r10 = r10.getDensity()     // Catch:{ ItemFoundInScroll -> 0x0200 }
            r11 = 0
            float r12 = androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.MinimumDistance     // Catch:{ ItemFoundInScroll -> 0x0200 }
            float r12 = r10.m5967toPx0680j_4(r12)     // Catch:{ ItemFoundInScroll -> 0x0200 }
            r10 = r12
            kotlin.jvm.internal.Ref$BooleanRef r11 = new kotlin.jvm.internal.Ref$BooleanRef     // Catch:{ ItemFoundInScroll -> 0x0200 }
            r11.<init>()     // Catch:{ ItemFoundInScroll -> 0x0200 }
            r11.element = r5     // Catch:{ ItemFoundInScroll -> 0x0200 }
            kotlin.jvm.internal.Ref$ObjectRef r12 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ ItemFoundInScroll -> 0x0200 }
            r12.<init>()     // Catch:{ ItemFoundInScroll -> 0x0200 }
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r20 = 30
            r21 = 0
            androidx.compose.animation.core.AnimationState r13 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r13, r14, r15, r17, r19, r20, r21)     // Catch:{ ItemFoundInScroll -> 0x0200 }
            r12.element = r13     // Catch:{ ItemFoundInScroll -> 0x0200 }
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r13 = r6.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x0200 }
            int r14 = r6.$index     // Catch:{ ItemFoundInScroll -> 0x0200 }
            java.lang.Integer r13 = r13.getTargetItemOffset(r14)     // Catch:{ ItemFoundInScroll -> 0x0200 }
            if (r13 != 0) goto L_0x01f2
            int r13 = r6.$index     // Catch:{ ItemFoundInScroll -> 0x0200 }
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r14 = r6.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x0200 }
            int r14 = r14.getFirstVisibleItemIndex()     // Catch:{ ItemFoundInScroll -> 0x0200 }
            if (r13 <= r14) goto L_0x00cb
            r13 = r5
            goto L_0x00cc
        L_0x00cb:
            r13 = 0
        L_0x00cc:
            kotlin.jvm.internal.Ref$IntRef r14 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ ItemFoundInScroll -> 0x0200 }
            r14.<init>()     // Catch:{ ItemFoundInScroll -> 0x0200 }
            r14.element = r5     // Catch:{ ItemFoundInScroll -> 0x0200 }
            r15 = r9
            r9 = r11
            r11 = r14
            r14 = r0
            r0 = r13
            r13 = r8
            r8 = r10
            r10 = r12
        L_0x00db:
            boolean r12 = r9.element     // Catch:{ ItemFoundInScroll -> 0x01ea }
            if (r12 == 0) goto L_0x01de
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r12 = r6.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01ea }
            int r12 = r12.getItemCount()     // Catch:{ ItemFoundInScroll -> 0x01ea }
            if (r12 <= 0) goto L_0x01de
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r12 = r6.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01ea }
            int r4 = r6.$index     // Catch:{ ItemFoundInScroll -> 0x01ea }
            int r5 = r6.$scrollOffset     // Catch:{ ItemFoundInScroll -> 0x01ea }
            float r4 = r12.expectedDistanceTo(r4, r5)     // Catch:{ ItemFoundInScroll -> 0x01ea }
            float r5 = java.lang.Math.abs(r4)     // Catch:{ ItemFoundInScroll -> 0x01ea }
            int r5 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r5 >= 0) goto L_0x0108
            float r5 = java.lang.Math.abs(r4)     // Catch:{ ItemFoundInScroll -> 0x01cb }
            float r4 = java.lang.Math.max(r5, r8)     // Catch:{ ItemFoundInScroll -> 0x01cb }
            if (r0 == 0) goto L_0x0105
            r12 = r4
            goto L_0x010e
        L_0x0105:
            float r4 = -r4
            r12 = r4
            goto L_0x010e
        L_0x0108:
            if (r0 == 0) goto L_0x010c
            r12 = r14
            goto L_0x010e
        L_0x010c:
            float r4 = -r14
            r12 = r4
        L_0x010e:
            int r4 = r6.$index     // Catch:{ ItemFoundInScroll -> 0x01ea }
            int r4 = r6.$scrollOffset     // Catch:{ ItemFoundInScroll -> 0x01ea }
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r4 = r6.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01ea }
            r4 = 0
            T r4 = r10.element     // Catch:{ ItemFoundInScroll -> 0x01ea }
            r22 = r4
            androidx.compose.animation.core.AnimationState r22 = (androidx.compose.animation.core.AnimationState) r22     // Catch:{ ItemFoundInScroll -> 0x01ea }
            r23 = 0
            r24 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r30 = 30
            r31 = 0
            androidx.compose.animation.core.AnimationState r4 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r22, (float) r23, (float) r24, (long) r25, (long) r27, (boolean) r29, (int) r30, (java.lang.Object) r31)     // Catch:{ ItemFoundInScroll -> 0x01ea }
            r10.element = r4     // Catch:{ ItemFoundInScroll -> 0x01ea }
            kotlin.jvm.internal.Ref$FloatRef r4 = new kotlin.jvm.internal.Ref$FloatRef     // Catch:{ ItemFoundInScroll -> 0x01ea }
            r4.<init>()     // Catch:{ ItemFoundInScroll -> 0x01ea }
            r5 = r13
            r13 = r4
            T r4 = r10.element     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            r22 = r4
            androidx.compose.animation.core.AnimationState r22 = (androidx.compose.animation.core.AnimationState) r22     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            java.lang.Float r23 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r12)     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            r24 = 0
            T r4 = r10.element     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            androidx.compose.animation.core.AnimationState r4 = (androidx.compose.animation.core.AnimationState) r4     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            java.lang.Object r4 = r4.getVelocity()     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            java.lang.Number r4 = (java.lang.Number) r4     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            float r4 = r4.floatValue()     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 != 0) goto L_0x0159
            r4 = 1
            goto L_0x015a
        L_0x0159:
            r4 = 0
        L_0x015a:
            if (r4 != 0) goto L_0x015f
            r25 = 1
            goto L_0x0161
        L_0x015f:
            r25 = 0
        L_0x0161:
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$3 r4 = new androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$3     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r3 = r6.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            int r2 = r6.$index     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            if (r0 == 0) goto L_0x016c
            r16 = 1
            goto L_0x016e
        L_0x016c:
            r16 = 0
        L_0x016e:
            r35 = r7
            int r7 = r6.$scrollOffset     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r31 = r9
            r9 = r4
            r32 = r10
            r10 = r3
            r3 = r11
            r11 = r2
            r2 = r14
            r14 = r5
            r33 = r15
            r15 = r31
            r17 = r33
            r18 = r3
            r19 = r7
            r20 = r32
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r26 = r4
            kotlin.jvm.functions.Function1 r26 = (kotlin.jvm.functions.Function1) r26     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r27 = r6
            kotlin.coroutines.Continuation r27 = (kotlin.coroutines.Continuation) r27     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r28 = 2
            r29 = 0
            r6.L$0 = r5     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r11 = r31
            r6.L$1 = r11     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r12 = r32
            r6.L$2 = r12     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r6.L$3 = r3     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r6.F$0 = r2     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r9 = r33
            r6.F$1 = r9     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r6.F$2 = r8     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r6.I$0 = r0     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r4 = 1
            r6.label = r4     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            java.lang.Object r4 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r22, r23, r24, r25, r26, r27, r28, r29)     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            if (r4 != r1) goto L_0x01b7
            return r1
        L_0x01b7:
            r7 = r35
            r14 = r2
            r13 = r5
            r15 = r9
            r9 = r11
            r10 = r12
            r11 = r3
        L_0x01bf:
            int r2 = r11.element     // Catch:{ ItemFoundInScroll -> 0x01cb }
            r3 = 1
            int r2 = r2 + r3
            r11.element = r2     // Catch:{ ItemFoundInScroll -> 0x01cb }
            r2 = r34
            r3 = 0
            r5 = 1
            goto L_0x00db
        L_0x01cb:
            r0 = move-exception
            r2 = r0
            r0 = r6
            r3 = r13
            goto L_0x0204
        L_0x01d0:
            r0 = move-exception
            r7 = r35
            r2 = r0
            r3 = r5
            r0 = r6
            goto L_0x0204
        L_0x01d7:
            r0 = move-exception
            r35 = r7
            r2 = r0
            r3 = r5
            r0 = r6
            goto L_0x0204
        L_0x01de:
            r35 = r7
            r12 = r10
            r3 = r11
            r5 = r13
            r2 = r14
            r11 = r9
            r9 = r15
            r7 = r35
            goto L_0x0274
        L_0x01ea:
            r0 = move-exception
            r35 = r7
            r5 = r13
            r2 = r0
            r3 = r5
            r0 = r6
            goto L_0x0204
        L_0x01f2:
            androidx.compose.foundation.lazy.layout.ItemFoundInScroll r0 = new androidx.compose.foundation.lazy.layout.ItemFoundInScroll     // Catch:{ ItemFoundInScroll -> 0x0200 }
            int r2 = r13.intValue()     // Catch:{ ItemFoundInScroll -> 0x0200 }
            T r3 = r12.element     // Catch:{ ItemFoundInScroll -> 0x0200 }
            androidx.compose.animation.core.AnimationState r3 = (androidx.compose.animation.core.AnimationState) r3     // Catch:{ ItemFoundInScroll -> 0x0200 }
            r0.<init>(r2, r3)     // Catch:{ ItemFoundInScroll -> 0x0200 }
            throw r0     // Catch:{ ItemFoundInScroll -> 0x0200 }
        L_0x0200:
            r0 = move-exception
            r2 = r0
            r0 = r6
            r3 = r8
        L_0x0204:
            androidx.compose.animation.core.AnimationState r8 = r2.getPreviousAnimation()
            r9 = 0
            r10 = 0
            r11 = 0
            r13 = 0
            r15 = 0
            r16 = 30
            r17 = 0
            androidx.compose.animation.core.AnimationState r22 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r8, (float) r9, (float) r10, (long) r11, (long) r13, (boolean) r15, (int) r16, (java.lang.Object) r17)
            int r4 = r2.getItemOffset()
            int r5 = r0.$scrollOffset
            int r4 = r4 + r5
            float r2 = (float) r4
            kotlin.jvm.internal.Ref$FloatRef r4 = new kotlin.jvm.internal.Ref$FloatRef
            r4.<init>()
            r5 = 0
            java.lang.Float r23 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r24 = 0
            java.lang.Object r5 = r22.getVelocity()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 != 0) goto L_0x023f
            r21 = 1
            goto L_0x0241
        L_0x023f:
            r21 = 0
        L_0x0241:
            r5 = 1
            r25 = r21 ^ 1
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$5 r5 = new androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$5
            r5.<init>(r2, r4, r3)
            r26 = r5
            kotlin.jvm.functions.Function1 r26 = (kotlin.jvm.functions.Function1) r26
            r27 = r0
            kotlin.coroutines.Continuation r27 = (kotlin.coroutines.Continuation) r27
            r28 = 2
            r29 = 0
            r0.L$0 = r3
            r5 = 0
            r0.L$1 = r5
            r0.L$2 = r5
            r0.L$3 = r5
            r5 = 2
            r0.label = r5
            java.lang.Object r2 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r22, r23, r24, r25, r26, r27, r28, r29)
            if (r2 != r1) goto L_0x0268
            return r1
        L_0x0268:
            r1 = r7
        L_0x0269:
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r2 = r0.$this_animateScrollToItem
            int r4 = r0.$index
            int r5 = r0.$scrollOffset
            r2.snapToItem(r3, r4, r5)
            r6 = r0
            r7 = r1
        L_0x0274:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0277:
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Index should be non-negative ("
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r0 = r2.append(r0)
            r2 = 41
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final boolean invokeSuspend$isOvershot(boolean forward, LazyAnimateScrollScope $this_animateScrollToItem2, int $index2, int $scrollOffset2) {
        if (forward) {
            if ($this_animateScrollToItem2.getFirstVisibleItemIndex() > $index2) {
                return true;
            }
            if ($this_animateScrollToItem2.getFirstVisibleItemIndex() != $index2 || $this_animateScrollToItem2.getFirstVisibleItemScrollOffset() <= $scrollOffset2) {
                return false;
            }
            return true;
        } else if ($this_animateScrollToItem2.getFirstVisibleItemIndex() < $index2) {
            return true;
        } else {
            if ($this_animateScrollToItem2.getFirstVisibleItemIndex() != $index2 || $this_animateScrollToItem2.getFirstVisibleItemScrollOffset() >= $scrollOffset2) {
                return false;
            }
            return true;
        }
    }
}
