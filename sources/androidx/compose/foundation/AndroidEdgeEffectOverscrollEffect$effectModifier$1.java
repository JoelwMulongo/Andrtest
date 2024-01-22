package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1", f = "AndroidOverscroll.kt", i = {}, l = {316}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AndroidOverscroll.kt */
final class AndroidEdgeEffectOverscrollEffect$effectModifier$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidEdgeEffectOverscrollEffect$effectModifier$1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Continuation<? super AndroidEdgeEffectOverscrollEffect$effectModifier$1> continuation) {
        super(2, continuation);
        this.this$0 = androidEdgeEffectOverscrollEffect;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidEdgeEffectOverscrollEffect$effectModifier$1 androidEdgeEffectOverscrollEffect$effectModifier$1 = new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this.this$0, continuation);
        androidEdgeEffectOverscrollEffect$effectModifier$1.L$0 = obj;
        return androidEdgeEffectOverscrollEffect$effectModifier$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((AndroidEdgeEffectOverscrollEffect$effectModifier$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1$1", f = "AndroidOverscroll.kt", i = {0, 1}, l = {317, 321}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture"}, s = {"L$0", "L$0"})
    /* renamed from: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1$1  reason: invalid class name */
    /* compiled from: AndroidOverscroll.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(androidEdgeEffectOverscrollEffect, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v1, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v4, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v6, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0056, code lost:
            r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5;
            androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.access$setPointerId$p(r4, androidx.compose.ui.input.pointer.PointerId.m4649boximpl(r5.m4666getIdJ3iCeTQ()));
            androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.access$setPointerPosition$p(r4, androidx.compose.ui.geometry.Offset.m2904boximpl(r5.m4667getPositionF1C5BW0()));
            r5 = r6;
            r6 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0074, code lost:
            r2.L$0 = r6;
            r2.label = 2;
            r7 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r6, r3, r2, r4, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0080, code lost:
            if (r7 != r0) goto L_0x0083;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0082, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0083, code lost:
            r19 = r6;
            r6 = r5;
            r5 = r7;
            r7 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0089, code lost:
            r5 = ((androidx.compose.ui.input.pointer.PointerEvent) r5).getChanges();
            r9 = new java.util.ArrayList(r5.size());
            r11 = 0;
            r12 = r5.size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x00a2, code lost:
            if (r11 >= r12) goto L_0x00c0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a4, code lost:
            r13 = r5.get(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b3, code lost:
            if (r13.getPressed() == false) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x00b5, code lost:
            r9.add(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00bb, code lost:
            r11 = r11 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c0, code lost:
            r5 = r9;
            r8 = r5;
            r9 = r4;
            r12 = 0;
            r13 = r8.size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d2, code lost:
            if (r12 >= r13) goto L_0x00fa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d4, code lost:
            r15 = r8.get(r12);
            r21 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ef, code lost:
            if (androidx.compose.ui.input.pointer.PointerId.m4651equalsimpl(r15.m4666getIdJ3iCeTQ(), androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.access$getPointerId$p(r9)) == false) goto L_0x00f2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00f2, code lost:
            r12 = r12 + 1;
            r0 = r21;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00fa, code lost:
            r21 = r0;
            r15 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00fe, code lost:
            r15 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0100, code lost:
            if (r15 != null) goto L_0x0109;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0102, code lost:
            r15 = kotlin.collections.CollectionsKt.firstOrNull(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0109, code lost:
            r0 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x010a, code lost:
            if (r0 == null) goto L_0x0126;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x010c, code lost:
            androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.access$setPointerId$p(r4, androidx.compose.ui.input.pointer.PointerId.m4649boximpl(r0.m4666getIdJ3iCeTQ()));
            androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.access$setPointerPosition$p(r4, androidx.compose.ui.geometry.Offset.m2904boximpl(r0.m4667getPositionF1C5BW0()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0130, code lost:
            if ((!r5.isEmpty()) != false) goto L_0x013b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0132, code lost:
            androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.access$setPointerId$p(r4, (androidx.compose.ui.input.pointer.PointerId) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x013a, code lost:
            return kotlin.Unit.INSTANCE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x013b, code lost:
            r0 = r21;
            r5 = r6;
            r6 = r7;
            r4 = 1;
            r3 = null;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                r20 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                r1 = r20
                int r2 = r1.label
                r3 = 0
                r4 = 1
                switch(r2) {
                    case 0: goto L_0x0032;
                    case 1: goto L_0x0024;
                    case 2: goto L_0x0015;
                    default: goto L_0x000d;
                }
            L_0x000d:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0015:
                r2 = r20
                r5 = r21
                java.lang.Object r6 = r2.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
                kotlin.ResultKt.throwOnFailure(r5)
                r7 = r6
                r6 = r5
                goto L_0x0089
            L_0x0024:
                r2 = r20
                r5 = r21
                java.lang.Object r6 = r2.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
                kotlin.ResultKt.throwOnFailure(r5)
                r7 = r6
                r6 = r5
                goto L_0x0056
            L_0x0032:
                kotlin.ResultKt.throwOnFailure(r21)
                r2 = r20
                r5 = r21
                java.lang.Object r6 = r2.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
                r8 = 0
                r9 = 0
                r10 = r2
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                r11 = 2
                r12 = 0
                r2.L$0 = r6
                r2.label = r4
                r7 = r6
                java.lang.Object r7 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r7, r8, r9, r10, r11, r12)
                if (r7 != r0) goto L_0x0050
                return r0
            L_0x0050:
                r19 = r6
                r6 = r5
                r5 = r7
                r7 = r19
            L_0x0056:
                androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r8 = r4
                long r9 = r5.m4666getIdJ3iCeTQ()
                androidx.compose.ui.input.pointer.PointerId r9 = androidx.compose.ui.input.pointer.PointerId.m4649boximpl(r9)
                r8.pointerId = r9
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r8 = r4
                long r9 = r5.m4667getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r9 = androidx.compose.ui.geometry.Offset.m2904boximpl(r9)
                r8.pointerPosition = r9
                r5 = r6
                r6 = r7
            L_0x0074:
                r7 = r2
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r2.L$0 = r6
                r8 = 2
                r2.label = r8
                java.lang.Object r7 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r6, r3, r7, r4, r3)
                if (r7 != r0) goto L_0x0083
                return r0
            L_0x0083:
                r19 = r6
                r6 = r5
                r5 = r7
                r7 = r19
            L_0x0089:
                androidx.compose.ui.input.pointer.PointerEvent r5 = (androidx.compose.ui.input.pointer.PointerEvent) r5
                java.util.List r5 = r5.getChanges()
                r8 = 0
                java.util.ArrayList r9 = new java.util.ArrayList
                int r10 = r5.size()
                r9.<init>(r10)
                r10 = 0
                r11 = 0
                int r12 = r5.size()
            L_0x00a2:
                if (r11 >= r12) goto L_0x00c0
                java.lang.Object r13 = r5.get(r11)
                r14 = 0
                r15 = r13
                androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
                r16 = 0
                boolean r15 = r15.getPressed()
                if (r15 == 0) goto L_0x00bb
                r15 = r9
                java.util.Collection r15 = (java.util.Collection) r15
                r15.add(r13)
            L_0x00bb:
                int r11 = r11 + 1
                goto L_0x00a2
            L_0x00c0:
                r5 = r9
                java.util.List r5 = (java.util.List) r5
                r8 = r5
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r9 = r4
                r10 = 0
                r11 = 0
                r12 = 0
                int r13 = r8.size()
            L_0x00d2:
                if (r12 >= r13) goto L_0x00fa
                java.lang.Object r14 = r8.get(r12)
                r15 = r14
                r16 = 0
                r17 = r15
                androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
                r18 = 0
                long r3 = r17.m4666getIdJ3iCeTQ()
                r21 = r0
                androidx.compose.ui.input.pointer.PointerId r0 = r9.pointerId
                boolean r0 = androidx.compose.ui.input.pointer.PointerId.m4651equalsimpl(r3, r0)
                if (r0 == 0) goto L_0x00f2
                goto L_0x00fe
            L_0x00f2:
                int r12 = r12 + 1
                r0 = r21
                r3 = 0
                r4 = 1
                goto L_0x00d2
            L_0x00fa:
                r21 = r0
                r15 = 0
            L_0x00fe:
                androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
                if (r15 != 0) goto L_0x0109
                java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r5)
                r15 = r0
                androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            L_0x0109:
                r0 = r15
                if (r0 == 0) goto L_0x0126
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r3 = r4
                long r8 = r0.m4666getIdJ3iCeTQ()
                androidx.compose.ui.input.pointer.PointerId r4 = androidx.compose.ui.input.pointer.PointerId.m4649boximpl(r8)
                r3.pointerId = r4
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r3 = r4
                long r8 = r0.m4667getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m2904boximpl(r8)
                r3.pointerPosition = r4
            L_0x0126:
                r0 = r5
                java.util.Collection r0 = (java.util.Collection) r0
                boolean r0 = r0.isEmpty()
                r3 = 1
                r0 = r0 ^ r3
                if (r0 != 0) goto L_0x013b
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r0 = r4
                r4 = 0
                r0.pointerId = r4
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L_0x013b:
                r4 = 0
                r0 = r21
                r5 = r6
                r6 = r7
                r19 = r4
                r4 = r3
                r3 = r19
                goto L_0x0074
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = this.this$0;
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture((PointerInputScope) this.L$0, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
