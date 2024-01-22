package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "velocity"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1", f = "Scrollable.kt", i = {0, 1, 1, 2, 2}, l = {406, 408, 410}, m = "invokeSuspend", n = {"velocity", "velocity", "available", "velocity", "velocityLeft"}, s = {"J$0", "J$0", "J$1", "J$0", "J$1"})
/* compiled from: Scrollable.kt */
final class ScrollingLogic$onDragStopped$performFling$1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
    /* synthetic */ long J$0;
    long J$1;
    int label;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollingLogic$onDragStopped$performFling$1(ScrollingLogic scrollingLogic, Continuation<? super ScrollingLogic$onDragStopped$performFling$1> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1 = new ScrollingLogic$onDragStopped$performFling$1(this.this$0, continuation);
        scrollingLogic$onDragStopped$performFling$1.J$0 = ((Velocity) obj).m6220unboximpl();
        return scrollingLogic$onDragStopped$performFling$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m639invokesFctU(((Velocity) obj).m6220unboximpl(), (Continuation) obj2);
    }

    /* renamed from: invoke-sF-c-tU  reason: not valid java name */
    public final Object m639invokesFctU(long j, Continuation<? super Velocity> continuation) {
        return ((ScrollingLogic$onDragStopped$performFling$1) create(Velocity.m6202boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x006a, code lost:
        r7 = androidx.compose.ui.unit.Velocity.m6214minusAH228Gc(r5, ((androidx.compose.ui.unit.Velocity) r3).m6220unboximpl());
        r2.J$0 = r5;
        r2.J$1 = r7;
        r2.label = 2;
        r3 = r2.this$0.m627doFlingAnimationQWom1Mo(r7, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0085, code lost:
        if (r3 != r0) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0087, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0088, code lost:
        r16 = r4;
        r4 = r3;
        r3 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x008d, code lost:
        r14 = ((androidx.compose.ui.unit.Velocity) r4).m6220unboximpl();
        r10 = androidx.compose.ui.unit.Velocity.m6214minusAH228Gc(r7, r14);
        r2.J$0 = r5;
        r2.J$1 = r14;
        r2.label = 3;
        r7 = r14;
        r4 = r2.this$0.getNestedScrollDispatcher().getValue().m4550dispatchPostFlingRZ2iAVY(r10, r14, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00b5, code lost:
        if (r4 != r0) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00b7, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b8, code lost:
        r0 = r2;
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00cd, code lost:
        return androidx.compose.ui.unit.Velocity.m6202boximpl(androidx.compose.ui.unit.Velocity.m6214minusAH228Gc(r5, androidx.compose.ui.unit.Velocity.m6214minusAH228Gc(r7, ((androidx.compose.ui.unit.Velocity) r2).m6220unboximpl())));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r18
            int r2 = r1.label
            switch(r2) {
                case 0: goto L_0x0040;
                case 1: goto L_0x0034;
                case 2: goto L_0x0022;
                case 3: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0013:
            r0 = r18
            r2 = r19
            long r3 = r0.J$1
            long r5 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r2)
            r7 = r3
            r3 = r2
            goto L_0x00ba
        L_0x0022:
            r2 = r18
            r3 = r19
            long r4 = r2.J$1
            long r6 = r2.J$0
            kotlin.ResultKt.throwOnFailure(r3)
            r16 = r4
            r4 = r3
            r5 = r6
            r7 = r16
            goto L_0x008d
        L_0x0034:
            r2 = r18
            r3 = r19
            long r4 = r2.J$0
            kotlin.ResultKt.throwOnFailure(r3)
            r5 = r4
            r4 = r3
            goto L_0x006a
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r19)
            r2 = r18
            r3 = r19
            long r4 = r2.J$0
            androidx.compose.foundation.gestures.ScrollingLogic r6 = r2.this$0
            androidx.compose.runtime.State r6 = r6.getNestedScrollDispatcher()
            java.lang.Object r6 = r6.getValue()
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r6 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r6
            r7 = r2
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r2.J$0 = r4
            r8 = 1
            r2.label = r8
            java.lang.Object r6 = r6.m4552dispatchPreFlingQWom1Mo(r4, r7)
            if (r6 != r0) goto L_0x0064
            return r0
        L_0x0064:
            r16 = r4
            r4 = r3
            r3 = r6
            r5 = r16
        L_0x006a:
            androidx.compose.ui.unit.Velocity r3 = (androidx.compose.ui.unit.Velocity) r3
            long r7 = r3.m6220unboximpl()
            long r7 = androidx.compose.ui.unit.Velocity.m6214minusAH228Gc(r5, r7)
            androidx.compose.foundation.gestures.ScrollingLogic r3 = r2.this$0
            r9 = r2
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r2.J$0 = r5
            r2.J$1 = r7
            r10 = 2
            r2.label = r10
            java.lang.Object r3 = r3.m627doFlingAnimationQWom1Mo(r7, r9)
            if (r3 != r0) goto L_0x0088
            return r0
        L_0x0088:
            r16 = r4
            r4 = r3
            r3 = r16
        L_0x008d:
            androidx.compose.ui.unit.Velocity r4 = (androidx.compose.ui.unit.Velocity) r4
            long r14 = r4.m6220unboximpl()
            androidx.compose.foundation.gestures.ScrollingLogic r4 = r2.this$0
            androidx.compose.runtime.State r4 = r4.getNestedScrollDispatcher()
            java.lang.Object r4 = r4.getValue()
            r9 = r4
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r9 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r9
            long r10 = androidx.compose.ui.unit.Velocity.m6214minusAH228Gc(r7, r14)
            r4 = r2
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r2.J$0 = r5
            r2.J$1 = r14
            r7 = 3
            r2.label = r7
            r12 = r14
            r7 = r14
            r14 = r4
            java.lang.Object r4 = r9.m4550dispatchPostFlingRZ2iAVY(r10, r12, r14)
            if (r4 != r0) goto L_0x00b8
            return r0
        L_0x00b8:
            r0 = r2
            r2 = r4
        L_0x00ba:
            androidx.compose.ui.unit.Velocity r2 = (androidx.compose.ui.unit.Velocity) r2
            long r9 = r2.m6220unboximpl()
            long r11 = androidx.compose.ui.unit.Velocity.m6214minusAH228Gc(r7, r9)
            long r13 = androidx.compose.ui.unit.Velocity.m6214minusAH228Gc(r5, r11)
            androidx.compose.ui.unit.Velocity r2 = androidx.compose.ui.unit.Velocity.m6202boximpl(r13)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
