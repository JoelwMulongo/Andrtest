package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1", f = "ContentInViewModifier.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ContentInViewModifier.kt */
final class ContentInViewModifier$launchAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ContentInViewModifier this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContentInViewModifier$launchAnimation$1(ContentInViewModifier contentInViewModifier, Continuation<? super ContentInViewModifier$launchAnimation$1> continuation) {
        super(2, continuation);
        this.this$0 = contentInViewModifier;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ContentInViewModifier$launchAnimation$1 contentInViewModifier$launchAnimation$1 = new ContentInViewModifier$launchAnimation$1(this.this$0, continuation);
        contentInViewModifier$launchAnimation$1.L$0 = obj;
        return contentInViewModifier$launchAnimation$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ContentInViewModifier$launchAnimation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        androidx.compose.foundation.gestures.ContentInViewModifier.access$getBringIntoViewRequests$p(r0.this$0).resumeAndRemoveAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0061, code lost:
        androidx.compose.foundation.gestures.ContentInViewModifier.access$setAnimationRunning$p(r0.this$0, false);
        androidx.compose.foundation.gestures.ContentInViewModifier.access$getBringIntoViewRequests$p(r0.this$0).cancelAndRemoveAll(r1);
        androidx.compose.foundation.gestures.ContentInViewModifier.access$setTrackingFocusedChild$p(r0.this$0, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0078, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 0
            switch(r1) {
                case 0: goto L_0x001d;
                case 1: goto L_0x0012;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0012:
            r0 = r13
            r1 = 0
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ CancellationException -> 0x001b }
            goto L_0x0057
        L_0x0018:
            r3 = move-exception
            goto L_0x0083
        L_0x001b:
            r3 = move-exception
            goto L_0x0080
        L_0x001d:
            kotlin.ResultKt.throwOnFailure(r14)
            r1 = r13
            java.lang.Object r3 = r1.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            r4 = 0
            kotlin.coroutines.CoroutineContext r5 = r3.getCoroutineContext()
            kotlinx.coroutines.Job r5 = kotlinx.coroutines.JobKt.getJob(r5)
            androidx.compose.foundation.gestures.ContentInViewModifier r3 = r1.this$0     // Catch:{ CancellationException -> 0x007d, all -> 0x0079 }
            r6 = 1
            r3.isAnimationRunning = r6     // Catch:{ CancellationException -> 0x007d, all -> 0x0079 }
            androidx.compose.foundation.gestures.ContentInViewModifier r3 = r1.this$0     // Catch:{ CancellationException -> 0x007d, all -> 0x0079 }
            androidx.compose.foundation.gestures.ScrollableState r7 = r3.scrollState     // Catch:{ CancellationException -> 0x007d, all -> 0x0079 }
            r8 = 0
            androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1$1 r3 = new androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1$1     // Catch:{ CancellationException -> 0x007d, all -> 0x0079 }
            androidx.compose.foundation.gestures.ContentInViewModifier r9 = r1.this$0     // Catch:{ CancellationException -> 0x007d, all -> 0x0079 }
            r10 = 0
            r3.<init>(r9, r5, r10)     // Catch:{ CancellationException -> 0x007d, all -> 0x0079 }
            r9 = r3
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9     // Catch:{ CancellationException -> 0x007d, all -> 0x0079 }
            r10 = r1
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10     // Catch:{ CancellationException -> 0x007d, all -> 0x0079 }
            r11 = 1
            r12 = 0
            r1.label = r6     // Catch:{ CancellationException -> 0x007d, all -> 0x0079 }
            java.lang.Object r3 = androidx.compose.foundation.gestures.ScrollableState.scroll$default(r7, r8, r9, r10, r11, r12)     // Catch:{ CancellationException -> 0x007d, all -> 0x0079 }
            if (r3 != r0) goto L_0x0055
            return r0
        L_0x0055:
            r0 = r1
            r1 = r4
        L_0x0057:
            androidx.compose.foundation.gestures.ContentInViewModifier r3 = r0.this$0     // Catch:{ CancellationException -> 0x001b }
            androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue r3 = r3.bringIntoViewRequests     // Catch:{ CancellationException -> 0x001b }
            r3.resumeAndRemoveAll()     // Catch:{ CancellationException -> 0x001b }
            androidx.compose.foundation.gestures.ContentInViewModifier r3 = r0.this$0
            r3.isAnimationRunning = r2
            androidx.compose.foundation.gestures.ContentInViewModifier r3 = r0.this$0
            androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue r3 = r3.bringIntoViewRequests
            r3.cancelAndRemoveAll(r1)
            androidx.compose.foundation.gestures.ContentInViewModifier r3 = r0.this$0
            r3.trackingFocusedChild = r2
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            return r2
        L_0x0079:
            r3 = move-exception
            r0 = r1
            r1 = r4
            goto L_0x0083
        L_0x007d:
            r3 = move-exception
            r0 = r1
            r1 = r4
        L_0x0080:
            r1 = r3
            throw r3     // Catch:{ all -> 0x0018 }
        L_0x0083:
            androidx.compose.foundation.gestures.ContentInViewModifier r4 = r0.this$0
            r4.isAnimationRunning = r2
            androidx.compose.foundation.gestures.ContentInViewModifier r4 = r0.this$0
            androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue r4 = r4.bringIntoViewRequests
            r5 = r1
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r4.cancelAndRemoveAll(r5)
            androidx.compose.foundation.gestures.ContentInViewModifier r4 = r0.this$0
            r4.trackingFocusedChild = r2
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
