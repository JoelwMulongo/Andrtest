package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J/\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/compose/material/SnackbarHostState;", "", "()V", "<set-?>", "Landroidx/compose/material/SnackbarData;", "currentSnackbarData", "getCurrentSnackbarData", "()Landroidx/compose/material/SnackbarData;", "setCurrentSnackbarData", "(Landroidx/compose/material/SnackbarData;)V", "currentSnackbarData$delegate", "Landroidx/compose/runtime/MutableState;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "showSnackbar", "Landroidx/compose/material/SnackbarResult;", "message", "", "actionLabel", "duration", "Landroidx/compose/material/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/material/SnackbarDuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SnackbarDataImpl", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnackbarHost.kt */
public final class SnackbarHostState {
    public static final int $stable = 0;
    private final MutableState currentSnackbarData$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);

    /* access modifiers changed from: private */
    public final void setCurrentSnackbarData(SnackbarData snackbarData) {
        this.currentSnackbarData$delegate.setValue(snackbarData);
    }

    public final SnackbarData getCurrentSnackbarData() {
        return (SnackbarData) this.currentSnackbarData$delegate.getValue();
    }

    public static /* synthetic */ Object showSnackbar$default(SnackbarHostState snackbarHostState, String str, String str2, SnackbarDuration snackbarDuration, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            snackbarDuration = SnackbarDuration.Short;
        }
        return snackbarHostState.showSnackbar(str, str2, snackbarDuration, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f5 A[Catch:{ all -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00fa A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object showSnackbar(java.lang.String r21, java.lang.String r22, androidx.compose.material.SnackbarDuration r23, kotlin.coroutines.Continuation<? super androidx.compose.material.SnackbarResult> r24) {
        /*
            r20 = this;
            r0 = r24
            boolean r1 = r0 instanceof androidx.compose.material.SnackbarHostState$showSnackbar$1
            if (r1 == 0) goto L_0x0019
            r1 = r0
            androidx.compose.material.SnackbarHostState$showSnackbar$1 r1 = (androidx.compose.material.SnackbarHostState$showSnackbar$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0019
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r20
            goto L_0x0021
        L_0x0019:
            androidx.compose.material.SnackbarHostState$showSnackbar$1 r1 = new androidx.compose.material.SnackbarHostState$showSnackbar$1
            r2 = r20
            r1.<init>(r2, r0)
            r0 = r1
        L_0x0021:
            java.lang.Object r3 = r1.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 1
            r6 = 0
            switch(r4) {
                case 0: goto L_0x0088;
                case 1: goto L_0x0066;
                case 2: goto L_0x0038;
                default: goto L_0x002e;
            }
        L_0x002e:
            r18 = r1
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0038:
            r4 = 0
            r5 = 0
            r0 = 0
            java.lang.Object r7 = r1.L$5
            androidx.compose.material.SnackbarHostState$showSnackbar$1 r7 = (androidx.compose.material.SnackbarHostState$showSnackbar$1) r7
            java.lang.Object r7 = r1.L$4
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r8 = r1.L$3
            androidx.compose.material.SnackbarDuration r8 = (androidx.compose.material.SnackbarDuration) r8
            java.lang.Object r8 = r1.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r1.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r1.L$0
            androidx.compose.material.SnackbarHostState r8 = (androidx.compose.material.SnackbarHostState) r8
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x005e }
            r18 = r1
            r2 = r3
            r17 = r2
            r10 = r6
            goto L_0x00fd
        L_0x005e:
            r0 = move-exception
            r9 = r6
            r18 = r1
            r17 = r3
            goto L_0x011c
        L_0x0066:
            r4 = 0
            r7 = 0
            java.lang.Object r8 = r1.L$4
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r9 = r1.L$3
            androidx.compose.material.SnackbarDuration r9 = (androidx.compose.material.SnackbarDuration) r9
            java.lang.Object r10 = r1.L$2
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r1.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r1.L$0
            androidx.compose.material.SnackbarHostState r12 = (androidx.compose.material.SnackbarHostState) r12
            kotlin.ResultKt.throwOnFailure(r3)
            r19 = r10
            r10 = r7
            r7 = r8
            r8 = r12
            r12 = r11
            r11 = r19
            goto L_0x00b3
        L_0x0088:
            kotlin.ResultKt.throwOnFailure(r3)
            r4 = r20
            r10 = r22
            r11 = r21
            r9 = r23
            kotlinx.coroutines.sync.Mutex r7 = r4.mutex
            r8 = 0
            r12 = 0
            r1.L$0 = r4
            r1.L$1 = r11
            r1.L$2 = r10
            r1.L$3 = r9
            r1.L$4 = r7
            r1.label = r5
            java.lang.Object r13 = r7.lock(r8, r1)
            if (r13 != r0) goto L_0x00ab
            return r0
        L_0x00ab:
            r19 = r8
            r8 = r4
            r4 = r12
            r12 = r11
            r11 = r10
            r10 = r19
        L_0x00b3:
            r13 = 0
            r14 = r1
            r15 = 0
            r1.L$0 = r8     // Catch:{ all -> 0x0115 }
            r1.L$1 = r12     // Catch:{ all -> 0x0115 }
            r1.L$2 = r11     // Catch:{ all -> 0x0115 }
            r1.L$3 = r9     // Catch:{ all -> 0x0115 }
            r1.L$4 = r7     // Catch:{ all -> 0x0115 }
            r1.L$5 = r14     // Catch:{ all -> 0x0115 }
            r6 = 2
            r1.label = r6     // Catch:{ all -> 0x0115 }
            r6 = r14
            r16 = 0
            kotlinx.coroutines.CancellableContinuationImpl r5 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ all -> 0x0115 }
            r18 = r1
            kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r6)     // Catch:{ all -> 0x010f }
            r2 = 1
            r5.<init>(r1, r2)     // Catch:{ all -> 0x010f }
            r1 = r5
            r1.initCancellability()     // Catch:{ all -> 0x010f }
            r2 = r1
            kotlinx.coroutines.CancellableContinuation r2 = (kotlinx.coroutines.CancellableContinuation) r2     // Catch:{ all -> 0x010f }
            r5 = 0
            r17 = r3
            androidx.compose.material.SnackbarHostState$SnackbarDataImpl r3 = new androidx.compose.material.SnackbarHostState$SnackbarDataImpl     // Catch:{ all -> 0x010b }
            r3.<init>(r12, r11, r9, r2)     // Catch:{ all -> 0x010b }
            androidx.compose.material.SnackbarData r3 = (androidx.compose.material.SnackbarData) r3     // Catch:{ all -> 0x010b }
            r8.setCurrentSnackbarData(r3)     // Catch:{ all -> 0x010b }
            java.lang.Object r2 = r1.getResult()     // Catch:{ all -> 0x010b }
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x010b }
            if (r2 != r1) goto L_0x00f8
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r14)     // Catch:{ all -> 0x010b }
        L_0x00f8:
            if (r2 != r0) goto L_0x00fb
            return r0
        L_0x00fb:
            r5 = r13
            r0 = r15
        L_0x00fd:
            r1 = 0
            r8.setCurrentSnackbarData(r1)     // Catch:{ all -> 0x0107 }
            r7.unlock(r10)
            return r2
        L_0x0107:
            r0 = move-exception
            r1 = r10
            r2 = r7
            goto L_0x0124
        L_0x010b:
            r0 = move-exception
            r9 = r10
            r5 = r13
            goto L_0x011c
        L_0x010f:
            r0 = move-exception
            r17 = r3
            r9 = r10
            r5 = r13
            goto L_0x011c
        L_0x0115:
            r0 = move-exception
            r18 = r1
            r17 = r3
            r9 = r10
            r5 = r13
        L_0x011c:
            r1 = 0
            r8.setCurrentSnackbarData(r1)     // Catch:{ all -> 0x0121 }
            throw r0     // Catch:{ all -> 0x0121 }
        L_0x0121:
            r0 = move-exception
            r2 = r7
            r1 = r9
        L_0x0124:
            r2.unlock(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarHostState.showSnackbar(java.lang.String, java.lang.String, androidx.compose.material.SnackbarDuration, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Landroidx/compose/material/SnackbarHostState$SnackbarDataImpl;", "Landroidx/compose/material/SnackbarData;", "message", "", "actionLabel", "duration", "Landroidx/compose/material/SnackbarDuration;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/compose/material/SnackbarResult;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/material/SnackbarDuration;Lkotlinx/coroutines/CancellableContinuation;)V", "getActionLabel", "()Ljava/lang/String;", "getDuration", "()Landroidx/compose/material/SnackbarDuration;", "getMessage", "dismiss", "", "performAction", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnackbarHost.kt */
    private static final class SnackbarDataImpl implements SnackbarData {
        private final String actionLabel;
        private final CancellableContinuation<SnackbarResult> continuation;
        private final SnackbarDuration duration;
        private final String message;

        public SnackbarDataImpl(String message2, String actionLabel2, SnackbarDuration duration2, CancellableContinuation<? super SnackbarResult> continuation2) {
            Intrinsics.checkNotNullParameter(message2, "message");
            Intrinsics.checkNotNullParameter(duration2, "duration");
            Intrinsics.checkNotNullParameter(continuation2, "continuation");
            this.message = message2;
            this.actionLabel = actionLabel2;
            this.duration = duration2;
            this.continuation = continuation2;
        }

        public String getMessage() {
            return this.message;
        }

        public String getActionLabel() {
            return this.actionLabel;
        }

        public SnackbarDuration getDuration() {
            return this.duration;
        }

        public void performAction() {
            if (this.continuation.isActive()) {
                Result.Companion companion = Result.Companion;
                this.continuation.resumeWith(Result.m6273constructorimpl(SnackbarResult.ActionPerformed));
            }
        }

        public void dismiss() {
            if (this.continuation.isActive()) {
                Result.Companion companion = Result.Companion;
                this.continuation.resumeWith(Result.m6273constructorimpl(SnackbarResult.Dismissed));
            }
        }
    }
}
