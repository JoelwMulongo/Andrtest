package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1", f = "GlobalSnapshotManager.android.kt", i = {0}, l = {63}, m = "invokeSuspend", n = {"$this$consume$iv$iv"}, s = {"L$0"})
/* compiled from: GlobalSnapshotManager.android.kt */
final class GlobalSnapshotManager$ensureStarted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Unit> $channel;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalSnapshotManager$ensureStarted$1(Channel<Unit> channel, Continuation<? super GlobalSnapshotManager$ensureStarted$1> continuation) {
        super(2, continuation);
        this.$channel = channel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlobalSnapshotManager$ensureStarted$1(this.$channel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GlobalSnapshotManager$ensureStarted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r1.L$0 = r7;
        r1.L$1 = r5;
        r1.label = 1;
        r8 = r5.hasNext(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        if (r8 != r0) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0054, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0055, code lost:
        r11 = r0;
        r0 = r13;
        r13 = r8;
        r8 = r7;
        r7 = r6;
        r6 = r5;
        r5 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r1;
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
        if (((java.lang.Boolean) r13).booleanValue() == false) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0068, code lost:
        r9 = (kotlin.Unit) r6.next();
        androidx.compose.runtime.snapshots.Snapshot.Companion.sendApplyNotifications();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0075, code lost:
        r13 = r0;
        r0 = r1;
        r1 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0080, code lost:
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r8, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0089, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        r1 = r2;
        r2 = r3;
        r3 = r4;
        r6 = r7;
        r7 = r8;
        r11 = r0;
        r0 = r13;
        r13 = r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            switch(r1) {
                case 0: goto L_0x002e;
                case 1: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0011:
            r1 = r12
            r2 = 0
            r3 = 0
            r4 = 0
            java.lang.Object r5 = r1.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            r6 = 0
            java.lang.Object r7 = r1.L$0
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x002b }
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r13
            goto L_0x0060
        L_0x002b:
            r0 = move-exception
            goto L_0x0097
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r13)
            r1 = r12
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r2 = r1.$channel
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            r3 = 0
            r7 = r2
            r2 = 0
            r6 = 0
            r4 = r7
            r5 = 0
            kotlinx.coroutines.channels.ChannelIterator r8 = r4.iterator()     // Catch:{ all -> 0x0093 }
            r4 = r5
            r5 = r8
            r11 = r3
            r3 = r2
            r2 = r11
        L_0x0047:
            r1.L$0 = r7     // Catch:{ all -> 0x002b }
            r1.L$1 = r5     // Catch:{ all -> 0x002b }
            r8 = 1
            r1.label = r8     // Catch:{ all -> 0x002b }
            java.lang.Object r8 = r5.hasNext(r1)     // Catch:{ all -> 0x002b }
            if (r8 != r0) goto L_0x0055
            return r0
        L_0x0055:
            r11 = r0
            r0 = r13
            r13 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r1 = r11
        L_0x0060:
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ all -> 0x0089 }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x0089 }
            if (r13 == 0) goto L_0x0080
            java.lang.Object r13 = r6.next()     // Catch:{ all -> 0x0089 }
            r9 = r13
            kotlin.Unit r9 = (kotlin.Unit) r9     // Catch:{ all -> 0x0089 }
            r9 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r10 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0089 }
            r10.sendApplyNotifications()     // Catch:{ all -> 0x0089 }
            r13 = r0
            r0 = r1
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            goto L_0x0047
        L_0x0080:
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r8, r7)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x0089:
            r13 = move-exception
            r1 = r2
            r2 = r3
            r3 = r4
            r6 = r7
            r7 = r8
            r11 = r0
            r0 = r13
            r13 = r11
            goto L_0x0097
        L_0x0093:
            r0 = move-exception
            r11 = r3
            r3 = r2
            r2 = r11
        L_0x0097:
            r4 = r0
            throw r0     // Catch:{ all -> 0x009a }
        L_0x009a:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
