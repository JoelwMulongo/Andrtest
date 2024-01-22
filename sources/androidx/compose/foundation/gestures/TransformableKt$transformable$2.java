package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transformable.kt */
final class TransformableKt$transformable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ boolean $lockRotationOnZoomPan;
    final /* synthetic */ TransformableState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransformableKt$transformable$2(boolean z, boolean z2, TransformableState transformableState) {
        super(3);
        this.$lockRotationOnZoomPan = z;
        this.$enabled = z2;
        this.$state = transformableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        composer.startReplaceableGroup(1509335853);
        ComposerKt.sourceInformation(composer, "C66@2992L43,67@3058L66,88@4051L509:Transformable.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1509335853, $changed, -1, "androidx.compose.foundation.gestures.transformable.<anonymous> (Transformable.kt:65)");
        } else {
            int i = $changed;
        }
        State updatePanZoomLock = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(this.$lockRotationOnZoomPan), composer, 0);
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = ChannelKt.Channel$default(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        final Channel channel = (Channel) value$iv$iv;
        composer.startReplaceableGroup(-2015617726);
        ComposerKt.sourceInformation(composer, "69@3160L822");
        if (this.$enabled) {
            TransformableState transformableState = this.$state;
            final TransformableState transformableState2 = this.$state;
            EffectsKt.LaunchedEffect((Object) transformableState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1((Continuation<? super AnonymousClass1>) null), composer, 64);
        }
        $composer.endReplaceableGroup();
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv2 = (Function2) new TransformableKt$transformable$2$block$1$1(updatePanZoomLock, channel, (Continuation<? super TransformableKt$transformable$2$block$1$1>) null);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        Modifier pointerInput = this.$enabled ? SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) Unit.INSTANCE, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) value$iv$iv2) : Modifier.Companion;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return pointerInput;
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$transformable$2$1", f = "Transformable.kt", i = {0, 0, 1}, l = {72, 75}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "event", "$this$LaunchedEffect"}, s = {"L$0", "L$1", "L$0"})
    /* renamed from: androidx.compose.foundation.gestures.TransformableKt$transformable$2$1  reason: invalid class name */
    /* compiled from: Transformable.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(channel, transformableState2, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r10.label
                switch(r1) {
                    case 0: goto L_0x0033;
                    case 1: goto L_0x001d;
                    case 2: goto L_0x0011;
                    default: goto L_0x0009;
                }
            L_0x0009:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x0011:
                r1 = r10
                java.lang.Object r2 = r1.L$0
                kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CancellationException -> 0x001b }
                goto L_0x0090
            L_0x001b:
                r3 = move-exception
                goto L_0x003b
            L_0x001d:
                r1 = r10
                java.lang.Object r2 = r1.L$2
                kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
                java.lang.Object r3 = r1.L$1
                kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
                java.lang.Object r4 = r1.L$0
                kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
                kotlin.ResultKt.throwOnFailure(r11)
                r5 = r3
                r3 = r2
                r2 = r1
                r1 = r0
                r0 = r11
                goto L_0x0062
            L_0x0033:
                kotlin.ResultKt.throwOnFailure(r11)
                r1 = r10
                java.lang.Object r2 = r1.L$0
                kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            L_0x003b:
                boolean r3 = kotlinx.coroutines.CoroutineScopeKt.isActive(r2)
                if (r3 == 0) goto L_0x009c
                kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
                r3.<init>()
                kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r4 = r3
                r5 = r1
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r1.L$0 = r2
                r1.L$1 = r3
                r1.L$2 = r3
                r6 = 1
                r1.label = r6
                java.lang.Object r4 = r4.receive(r5)
                if (r4 != r0) goto L_0x005b
                return r0
            L_0x005b:
                r5 = r3
                r9 = r0
                r0 = r11
                r11 = r4
                r4 = r2
                r2 = r1
                r1 = r9
            L_0x0062:
                r3.element = r11
                T r11 = r5.element
                boolean r11 = r11 instanceof androidx.compose.foundation.gestures.TransformEvent.TransformStarted
                if (r11 == 0) goto L_0x0097
                androidx.compose.foundation.gestures.TransformableState r11 = r7     // Catch:{ CancellationException -> 0x0091 }
                androidx.compose.foundation.MutatePriority r3 = androidx.compose.foundation.MutatePriority.UserInput     // Catch:{ CancellationException -> 0x0091 }
                androidx.compose.foundation.gestures.TransformableKt$transformable$2$1$1 r6 = new androidx.compose.foundation.gestures.TransformableKt$transformable$2$1$1     // Catch:{ CancellationException -> 0x0091 }
                kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r7 = r3     // Catch:{ CancellationException -> 0x0091 }
                r8 = 0
                r6.<init>(r5, r7, r8)     // Catch:{ CancellationException -> 0x0091 }
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch:{ CancellationException -> 0x0091 }
                r7 = r2
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch:{ CancellationException -> 0x0091 }
                r2.L$0 = r4     // Catch:{ CancellationException -> 0x0091 }
                r2.L$1 = r8     // Catch:{ CancellationException -> 0x0091 }
                r2.L$2 = r8     // Catch:{ CancellationException -> 0x0091 }
                r8 = 2
                r2.label = r8     // Catch:{ CancellationException -> 0x0091 }
                java.lang.Object r11 = r11.transform(r3, r6, r7)     // Catch:{ CancellationException -> 0x0091 }
                if (r11 != r1) goto L_0x008c
                return r1
            L_0x008c:
                r11 = r0
                r0 = r1
                r1 = r2
                r2 = r4
            L_0x0090:
                goto L_0x003b
            L_0x0091:
                r11 = move-exception
                r11 = r0
                r0 = r1
                r1 = r2
                r2 = r4
                goto L_0x003b
            L_0x0097:
                r11 = r0
                r0 = r1
                r1 = r2
                r2 = r4
                goto L_0x003b
            L_0x009c:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt$transformable$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
