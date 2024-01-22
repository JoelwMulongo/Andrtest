package androidx.compose.material3;

import androidx.compose.ui.platform.AccessibilityManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SnackbarHostKt$SnackbarHost$1", f = "SnackbarHost.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SnackbarHost.kt */
final class SnackbarHostKt$SnackbarHost$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AccessibilityManager $accessibilityManager;
    final /* synthetic */ SnackbarData $currentSnackbarData;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarHostKt$SnackbarHost$1(SnackbarData snackbarData, AccessibilityManager accessibilityManager, Continuation<? super SnackbarHostKt$SnackbarHost$1> continuation) {
        super(2, continuation);
        this.$currentSnackbarData = snackbarData;
        this.$accessibilityManager = accessibilityManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SnackbarHostKt$SnackbarHost$1(this.$currentSnackbarData, this.$accessibilityManager, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SnackbarHostKt$SnackbarHost$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            switch(r1) {
                case 0: goto L_0x0016;
                case 1: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0011:
            r0 = r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0049
        L_0x0016:
            kotlin.ResultKt.throwOnFailure(r7)
            r1 = r6
            androidx.compose.material3.SnackbarData r2 = r1.$currentSnackbarData
            if (r2 == 0) goto L_0x004f
            androidx.compose.material3.SnackbarVisuals r2 = r2.getVisuals()
            androidx.compose.material3.SnackbarDuration r2 = r2.getDuration()
            androidx.compose.material3.SnackbarData r3 = r1.$currentSnackbarData
            androidx.compose.material3.SnackbarVisuals r3 = r3.getVisuals()
            java.lang.String r3 = r3.getActionLabel()
            r4 = 1
            if (r3 == 0) goto L_0x0035
            r3 = r4
            goto L_0x0036
        L_0x0035:
            r3 = 0
        L_0x0036:
            androidx.compose.ui.platform.AccessibilityManager r5 = r1.$accessibilityManager
            long r2 = androidx.compose.material3.SnackbarHostKt.toMillis(r2, r3, r5)
            r5 = r1
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r1.label = r4
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.delay(r2, r5)
            if (r2 != r0) goto L_0x0048
            return r0
        L_0x0048:
            r0 = r1
        L_0x0049:
            androidx.compose.material3.SnackbarData r1 = r0.$currentSnackbarData
            r1.dismiss()
            r1 = r0
        L_0x004f:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarHostKt$SnackbarHost$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
