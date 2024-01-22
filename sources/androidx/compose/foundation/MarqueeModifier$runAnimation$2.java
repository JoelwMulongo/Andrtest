package androidx.compose.foundation;

import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.MarqueeModifier$runAnimation$2", f = "BasicMarquee.kt", i = {}, l = {272}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BasicMarquee.kt */
final class MarqueeModifier$runAnimation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MarqueeModifier this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MarqueeModifier$runAnimation$2(MarqueeModifier marqueeModifier, Continuation<? super MarqueeModifier$runAnimation$2> continuation) {
        super(2, continuation);
        this.this$0 = marqueeModifier;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MarqueeModifier$runAnimation$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MarqueeModifier$runAnimation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final MarqueeModifier marqueeModifier = this.this$0;
                Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Float>() {
                    public final Float invoke() {
                        if (marqueeModifier.getContentWidth() <= marqueeModifier.getContainerWidth()) {
                            return null;
                        }
                        if (!MarqueeAnimationMode.m504equalsimpl0(marqueeModifier.m512getAnimationModeZbEOnfQ(), MarqueeAnimationMode.Companion.m511getWhileFocusedZbEOnfQ()) || marqueeModifier.getHasFocus()) {
                            return Float.valueOf((float) (marqueeModifier.getContentWidth() + marqueeModifier.getSpacingPx()));
                        }
                        return null;
                    }
                });
                final MarqueeModifier marqueeModifier2 = this.this$0;
                this.label = 1;
                if (FlowKt.collectLatest(snapshotFlow, new AnonymousClass2((Continuation<? super AnonymousClass2>) null), this) != coroutine_suspended) {
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

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H@"}, d2 = {"<anonymous>", "", "contentWithSpacingWidth", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.MarqueeModifier$runAnimation$2$2", f = "BasicMarquee.kt", i = {0, 0}, l = {285, 287, 289, 289}, m = "invokeSuspend", n = {"contentWithSpacingWidth", "spec"}, s = {"L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.MarqueeModifier$runAnimation$2$2  reason: invalid class name */
    /* compiled from: BasicMarquee.kt */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Float, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 r0 = new AnonymousClass2(marqueeModifier2, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(Float f, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(f, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r1.L$0 = null;
            r1.L$1 = null;
            r1.label = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a8, code lost:
            if (androidx.compose.animation.core.Animatable.animateTo$default(r4.offset, r13, r12, (java.lang.Object) null, (kotlin.jvm.functions.Function1) null, r1, 12, (java.lang.Object) null) != r0) goto L_0x00ab;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00aa, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ab, code lost:
            r1.label = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00bf, code lost:
            if (r4.offset.snapTo(kotlin.coroutines.jvm.internal.Boxing.boxFloat(0.0f), r1) != r0) goto L_0x00c2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c1, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c2, code lost:
            r0 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c6, code lost:
            return kotlin.Unit.INSTANCE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e4, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r14.label
                r2 = 0
                r3 = 0
                switch(r1) {
                    case 0: goto L_0x003b;
                    case 1: goto L_0x002c;
                    case 2: goto L_0x0023;
                    case 3: goto L_0x001d;
                    case 4: goto L_0x0013;
                    default: goto L_0x000b;
                }
            L_0x000b:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L_0x0013:
                r0 = r14
                java.lang.Object r1 = r0.L$0
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                kotlin.ResultKt.throwOnFailure(r15)
                goto L_0x00e4
            L_0x001d:
                r0 = r14
                kotlin.ResultKt.throwOnFailure(r15)
                goto L_0x00c3
            L_0x0023:
                r1 = r14
                kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x0029 }
                goto L_0x00ab
            L_0x0029:
                r4 = move-exception
                goto L_0x00c7
            L_0x002c:
                r1 = r14
                java.lang.Object r4 = r1.L$1
                androidx.compose.animation.core.AnimationSpec r4 = (androidx.compose.animation.core.AnimationSpec) r4
                java.lang.Object r5 = r1.L$0
                java.lang.Float r5 = (java.lang.Float) r5
                kotlin.ResultKt.throwOnFailure(r15)
                r12 = r4
                r13 = r5
                goto L_0x008c
            L_0x003b:
                kotlin.ResultKt.throwOnFailure(r15)
                r1 = r14
                java.lang.Object r4 = r1.L$0
                r5 = r4
                java.lang.Float r5 = (java.lang.Float) r5
                if (r5 != 0) goto L_0x0049
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L_0x0049:
                androidx.compose.foundation.MarqueeModifier r4 = r4
                int r6 = r4.iterations
                float r7 = r5.floatValue()
                androidx.compose.foundation.MarqueeModifier r4 = r4
                int r8 = r4.initialDelayMillis
                androidx.compose.foundation.MarqueeModifier r4 = r4
                int r9 = r4.delayMillis
                androidx.compose.foundation.MarqueeModifier r4 = r4
                float r10 = r4.velocity
                androidx.compose.foundation.MarqueeModifier r4 = r4
                androidx.compose.ui.unit.Density r11 = r4.density
                androidx.compose.animation.core.AnimationSpec r4 = androidx.compose.foundation.BasicMarqueeKt.m454createMarqueeAnimationSpecZ4HSEVQ(r6, r7, r8, r9, r10, r11)
                androidx.compose.foundation.MarqueeModifier r6 = r4
                androidx.compose.animation.core.Animatable r6 = r6.offset
                java.lang.Float r7 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r3)
                r8 = r1
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r1.L$0 = r5
                r1.L$1 = r4
                r9 = 1
                r1.label = r9
                java.lang.Object r6 = r6.snapTo(r7, r8)
                if (r6 != r0) goto L_0x008a
                return r0
            L_0x008a:
                r12 = r4
                r13 = r5
            L_0x008c:
                androidx.compose.foundation.MarqueeModifier r4 = r4     // Catch:{ all -> 0x0029 }
                androidx.compose.animation.core.Animatable r4 = r4.offset     // Catch:{ all -> 0x0029 }
                r7 = 0
                r8 = 0
                r9 = r1
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch:{ all -> 0x0029 }
                r10 = 12
                r11 = 0
                r1.L$0 = r2     // Catch:{ all -> 0x0029 }
                r1.L$1 = r2     // Catch:{ all -> 0x0029 }
                r5 = 2
                r1.label = r5     // Catch:{ all -> 0x0029 }
                r5 = r13
                r6 = r12
                java.lang.Object r2 = androidx.compose.animation.core.Animatable.animateTo$default(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0029 }
                if (r2 != r0) goto L_0x00ab
                return r0
            L_0x00ab:
                androidx.compose.foundation.MarqueeModifier r2 = r4
                androidx.compose.animation.core.Animatable r2 = r2.offset
                java.lang.Float r3 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r3)
                r4 = r1
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r5 = 3
                r1.label = r5
                java.lang.Object r2 = r2.snapTo(r3, r4)
                if (r2 != r0) goto L_0x00c2
                return r0
            L_0x00c2:
                r0 = r1
            L_0x00c3:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            L_0x00c7:
                androidx.compose.foundation.MarqueeModifier r5 = r4
                androidx.compose.animation.core.Animatable r5 = r5.offset
                java.lang.Float r3 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r3)
                r6 = r1
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r1.L$0 = r4
                r1.L$1 = r2
                r2 = 4
                r1.label = r2
                java.lang.Object r2 = r5.snapTo(r3, r6)
                if (r2 != r0) goto L_0x00e2
                return r0
            L_0x00e2:
                r0 = r1
                r1 = r4
            L_0x00e4:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MarqueeModifier$runAnimation$2.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
