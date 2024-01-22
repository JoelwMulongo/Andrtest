package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1", f = "WindowRecomposer.android.kt", i = {0}, l = {392}, m = "invokeSuspend", n = {"durationScaleJob"}, s = {"L$0"})
/* compiled from: WindowRecomposer.android.kt */
final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Recomposer $recomposer;
    final /* synthetic */ WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 $self;
    final /* synthetic */ LifecycleOwner $source;
    final /* synthetic */ Ref.ObjectRef<MotionDurationScaleImpl> $systemDurationScaleSettingConsumer;
    final /* synthetic */ View $this_createLifecycleAwareWindowRecomposer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(Ref.ObjectRef<MotionDurationScaleImpl> objectRef, Recomposer recomposer, LifecycleOwner lifecycleOwner, WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2, View view, Continuation<? super WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1> continuation) {
        super(2, continuation);
        this.$systemDurationScaleSettingConsumer = objectRef;
        this.$recomposer = recomposer;
        this.$source = lifecycleOwner;
        this.$self = windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2;
        this.$this_createLifecycleAwareWindowRecomposer = view;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 = new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(this.$systemDurationScaleSettingConsumer, this.$recomposer, this.$source, this.$self, this.$this_createLifecycleAwareWindowRecomposer, continuation);
        windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1.L$0 = obj;
        return windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: kotlinx.coroutines.Job} */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0087, code lost:
        if (r6 == null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0089, code lost:
        kotlinx.coroutines.Job.DefaultImpls.cancel$default(r6, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
        r2.$source.getLifecycle().removeObserver(r2.$self);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x009c, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r18
            int r2 = r1.label
            r3 = 1
            r4 = 0
            switch(r2) {
                case 0: goto L_0x0025;
                case 1: goto L_0x0015;
                default: goto L_0x000d;
            }
        L_0x000d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0015:
            r2 = r18
            r5 = r19
            java.lang.Object r0 = r2.L$0
            r6 = r0
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x0022 }
            goto L_0x0086
        L_0x0022:
            r0 = move-exception
            goto L_0x009f
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r19)
            r2 = r18
            r5 = r19
            java.lang.Object r6 = r2.L$0
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            r13 = 0
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.platform.MotionDurationScaleImpl> r7 = r2.$systemDurationScaleSettingConsumer     // Catch:{ all -> 0x009d }
            T r7 = r7.element     // Catch:{ all -> 0x009d }
            androidx.compose.ui.platform.MotionDurationScaleImpl r7 = (androidx.compose.ui.platform.MotionDurationScaleImpl) r7     // Catch:{ all -> 0x009d }
            if (r7 == 0) goto L_0x0074
            android.view.View r8 = r2.$this_createLifecycleAwareWindowRecomposer     // Catch:{ all -> 0x009d }
            r14 = r7
            r15 = 0
            android.content.Context r7 = r8.getContext()     // Catch:{ all -> 0x009d }
            android.content.Context r7 = r7.getApplicationContext()     // Catch:{ all -> 0x009d }
            java.lang.String r8 = "context.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)     // Catch:{ all -> 0x009d }
            kotlinx.coroutines.flow.StateFlow r7 = androidx.compose.ui.platform.WindowRecomposer_androidKt.getAnimationScaleFlowFor(r7)     // Catch:{ all -> 0x009d }
            r12 = r7
            java.lang.Object r7 = r12.getValue()     // Catch:{ all -> 0x009d }
            java.lang.Number r7 = (java.lang.Number) r7     // Catch:{ all -> 0x009d }
            float r7 = r7.floatValue()     // Catch:{ all -> 0x009d }
            r14.setScaleFactor(r7)     // Catch:{ all -> 0x009d }
            r8 = 0
            r9 = 0
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1 r7 = new androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1     // Catch:{ all -> 0x009d }
            r7.<init>(r12, r14, r4)     // Catch:{ all -> 0x009d }
            r10 = r7
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10     // Catch:{ all -> 0x009d }
            r11 = 3
            r16 = 0
            r7 = r6
            r17 = r12
            r12 = r16
            kotlinx.coroutines.Job r7 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x009d }
            goto L_0x0075
        L_0x0074:
            r7 = r4
        L_0x0075:
            r6 = r7
            androidx.compose.runtime.Recomposer r7 = r2.$recomposer     // Catch:{ all -> 0x0022 }
            r8 = r2
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8     // Catch:{ all -> 0x0022 }
            r2.L$0 = r6     // Catch:{ all -> 0x0022 }
            r2.label = r3     // Catch:{ all -> 0x0022 }
            java.lang.Object r7 = r7.runRecomposeAndApplyChanges(r8)     // Catch:{ all -> 0x0022 }
            if (r7 != r0) goto L_0x0086
            return r0
        L_0x0086:
            if (r6 == 0) goto L_0x008c
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r6, (java.util.concurrent.CancellationException) r4, (int) r3, (java.lang.Object) r4)
        L_0x008c:
            androidx.lifecycle.LifecycleOwner r0 = r2.$source
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 r3 = r2.$self
            androidx.lifecycle.LifecycleObserver r3 = (androidx.lifecycle.LifecycleObserver) r3
            r0.removeObserver(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x009d:
            r0 = move-exception
            r6 = r13
        L_0x009f:
            if (r6 == 0) goto L_0x00a4
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r6, (java.util.concurrent.CancellationException) r4, (int) r3, (java.lang.Object) r4)
        L_0x00a4:
            androidx.lifecycle.LifecycleOwner r3 = r2.$source
            androidx.lifecycle.Lifecycle r3 = r3.getLifecycle()
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 r4 = r2.$self
            androidx.lifecycle.LifecycleObserver r4 = (androidx.lifecycle.LifecycleObserver) r4
            r3.removeObserver(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
