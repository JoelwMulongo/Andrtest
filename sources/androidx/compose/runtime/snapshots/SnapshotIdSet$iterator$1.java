package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", i = {0, 0, 1, 1, 2, 2}, l = {295, 300, 307}, m = "invokeSuspend", n = {"$this$sequence", "belowBound", "$this$sequence", "index", "$this$sequence", "index"}, s = {"L$0", "L$1", "L$0", "I$0", "L$0", "I$0"})
/* compiled from: SnapshotIdSet.kt */
final class SnapshotIdSet$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SnapshotIdSet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotIdSet$iterator$1(SnapshotIdSet snapshotIdSet, Continuation<? super SnapshotIdSet$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = snapshotIdSet;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotIdSet$iterator$1 snapshotIdSet$iterator$1 = new SnapshotIdSet$iterator$1(this.this$0, continuation);
        snapshotIdSet$iterator$1.L$0 = obj;
        return snapshotIdSet$iterator$1;
    }

    public final Object invoke(SequenceScope<? super Integer> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SnapshotIdSet$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0069, code lost:
        if (r12 >= r11) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x006b, code lost:
        r2.L$0 = r14;
        r2.L$1 = r13;
        r2.I$0 = r12;
        r2.I$1 = r11;
        r2.label = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0082, code lost:
        if (r14.yield(kotlin.coroutines.jvm.internal.Boxing.boxInt(r13[r12]), r2) != r0) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0084, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0085, code lost:
        r12 = r12 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0087, code lost:
        r11 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0090, code lost:
        if (r2.this$0.lowerSet == 0) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0092, code lost:
        r12 = r11;
        r11 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0095, code lost:
        if (r11 >= 64) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a5, code lost:
        if ((r2.this$0.lowerSet & (1 << r11)) == 0) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a7, code lost:
        r2.L$0 = r12;
        r2.L$1 = null;
        r2.I$0 = r11;
        r2.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00c3, code lost:
        if (r12.yield(kotlin.coroutines.jvm.internal.Boxing.boxInt(r2.this$0.lowerBound + r11), r2) != r0) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c5, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c7, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c9, code lost:
        r11 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d2, code lost:
        if (r2.this$0.upperSet == 0) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d4, code lost:
        r12 = r11;
        r11 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d7, code lost:
        if (r11 >= 64) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e7, code lost:
        if ((r2.this$0.upperSet & (1 << r11)) == 0) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e9, code lost:
        r2.L$0 = r12;
        r2.L$1 = null;
        r2.I$0 = r11;
        r2.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0107, code lost:
        if (r12.yield(kotlin.coroutines.jvm.internal.Boxing.boxInt((r11 + 64) + r2.this$0.lowerBound), r2) != r0) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0109, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x010c, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0110, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            r21 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r21
            int r2 = r1.label
            r6 = 64
            r7 = 1
            r8 = 0
            switch(r2) {
                case 0: goto L_0x004d;
                case 1: goto L_0x0039;
                case 2: goto L_0x002a;
                case 3: goto L_0x0018;
                default: goto L_0x0010;
            }
        L_0x0010:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0018:
            r2 = r21
            r10 = r22
            int r11 = r2.I$0
            java.lang.Object r12 = r2.L$0
            kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
            kotlin.ResultKt.throwOnFailure(r10)
            r5 = 0
            r13 = 1
            goto L_0x010a
        L_0x002a:
            r2 = r21
            r10 = r22
            int r11 = r2.I$0
            java.lang.Object r12 = r2.L$0
            kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00c6
        L_0x0039:
            r2 = r21
            r10 = r22
            int r11 = r2.I$1
            int r12 = r2.I$0
            java.lang.Object r13 = r2.L$1
            int[] r13 = (int[]) r13
            java.lang.Object r14 = r2.L$0
            kotlin.sequences.SequenceScope r14 = (kotlin.sequences.SequenceScope) r14
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0085
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r22)
            r2 = r21
            r10 = r22
            java.lang.Object r11 = r2.L$0
            kotlin.sequences.SequenceScope r11 = (kotlin.sequences.SequenceScope) r11
            androidx.compose.runtime.snapshots.SnapshotIdSet r12 = r2.this$0
            int[] r12 = r12.belowBound
            if (r12 == 0) goto L_0x0088
            int r13 = r12.length
            r14 = 0
            r20 = r14
            r14 = r11
            r11 = r13
            r13 = r12
            r12 = r20
        L_0x0069:
            if (r12 >= r11) goto L_0x0087
            r15 = r13[r12]
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r15)
            r4 = r2
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r2.L$0 = r14
            r2.L$1 = r13
            r2.I$0 = r12
            r2.I$1 = r11
            r2.label = r7
            java.lang.Object r3 = r14.yield(r3, r4)
            if (r3 != r0) goto L_0x0085
            return r0
        L_0x0085:
            int r12 = r12 + r7
            goto L_0x0069
        L_0x0087:
            r11 = r14
        L_0x0088:
            androidx.compose.runtime.snapshots.SnapshotIdSet r3 = r2.this$0
            long r3 = r3.lowerSet
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x00ca
            r3 = 0
            r12 = r11
            r11 = r3
        L_0x0095:
            if (r11 >= r6) goto L_0x00c9
            androidx.compose.runtime.snapshots.SnapshotIdSet r3 = r2.this$0
            long r3 = r3.lowerSet
            r13 = 1
            long r18 = r13 << r11
            long r3 = r3 & r18
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x00c7
            androidx.compose.runtime.snapshots.SnapshotIdSet r3 = r2.this$0
            int r3 = r3.lowerBound
            int r3 = r3 + r11
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            r4 = r2
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r2.L$0 = r12
            r5 = 0
            r2.L$1 = r5
            r2.I$0 = r11
            r5 = 2
            r2.label = r5
            java.lang.Object r3 = r12.yield(r3, r4)
            if (r3 != r0) goto L_0x00c6
            return r0
        L_0x00c6:
        L_0x00c7:
            int r11 = r11 + r7
            goto L_0x0095
        L_0x00c9:
            r11 = r12
        L_0x00ca:
            androidx.compose.runtime.snapshots.SnapshotIdSet r3 = r2.this$0
            long r3 = r3.upperSet
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x010e
            r3 = 0
            r12 = r11
            r11 = r3
        L_0x00d7:
            if (r11 >= r6) goto L_0x010e
            androidx.compose.runtime.snapshots.SnapshotIdSet r3 = r2.this$0
            long r3 = r3.upperSet
            r13 = 1
            long r16 = r13 << r11
            long r3 = r3 & r16
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x010b
            int r3 = r11 + 64
            androidx.compose.runtime.snapshots.SnapshotIdSet r4 = r2.this$0
            int r4 = r4.lowerBound
            int r3 = r3 + r4
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            r4 = r2
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r2.L$0 = r12
            r5 = 0
            r2.L$1 = r5
            r2.I$0 = r11
            r15 = 3
            r2.label = r15
            java.lang.Object r3 = r12.yield(r3, r4)
            if (r3 != r0) goto L_0x010a
            return r0
        L_0x010a:
            goto L_0x010c
        L_0x010b:
            r5 = 0
        L_0x010c:
            int r11 = r11 + r7
            goto L_0x00d7
        L_0x010e:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
