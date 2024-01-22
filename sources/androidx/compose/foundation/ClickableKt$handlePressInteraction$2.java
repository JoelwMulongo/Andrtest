package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.ClickableKt$handlePressInteraction$2", f = "Clickable.kt", i = {0, 1, 2}, l = {445, 447, 454, 455, 464}, m = "invokeSuspend", n = {"delayJob", "success", "releaseInteraction"}, s = {"L$0", "Z$0", "L$0"})
/* compiled from: Clickable.kt */
final class ClickableKt$handlePressInteraction$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function0<Boolean>> $delayPressInteraction;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $pressPoint;
    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
    final /* synthetic */ PressGestureScope $this_handlePressInteraction;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableKt$handlePressInteraction$2(PressGestureScope pressGestureScope, long j, MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState, State<? extends Function0<Boolean>> state, Continuation<? super ClickableKt$handlePressInteraction$2> continuation) {
        super(2, continuation);
        this.$this_handlePressInteraction = pressGestureScope;
        this.$pressPoint = j;
        this.$interactionSource = mutableInteractionSource;
        this.$pressedInteraction = mutableState;
        this.$delayPressInteraction = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ClickableKt$handlePressInteraction$2 clickableKt$handlePressInteraction$2 = new ClickableKt$handlePressInteraction$2(this.$this_handlePressInteraction, this.$pressPoint, this.$interactionSource, this.$pressedInteraction, this.$delayPressInteraction, continuation);
        clickableKt$handlePressInteraction$2.L$0 = obj;
        return clickableKt$handlePressInteraction$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClickableKt$handlePressInteraction$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0082, code lost:
        r6 = ((java.lang.Boolean) r6).booleanValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x008c, code lost:
        if (r5.isActive() == false) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x008e, code lost:
        r2.L$0 = null;
        r2.Z$0 = r6;
        r2.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x009c, code lost:
        if (kotlinx.coroutines.JobKt.cancelAndJoin(r5, r2) != r0) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x009e, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009f, code lost:
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a0, code lost:
        if (r5 == false) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a2, code lost:
        r5 = new androidx.compose.foundation.interaction.PressInteraction.Press(r2.$pressPoint, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        r6 = new androidx.compose.foundation.interaction.PressInteraction.Release(r5);
        r2.L$0 = r6;
        r2.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00bf, code lost:
        if (r2.$interactionSource.emit(r5, r2) != r0) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c1, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c2, code lost:
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00c3, code lost:
        r2.L$0 = null;
        r2.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d4, code lost:
        if (r2.$interactionSource.emit(r5, r2) != r0) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d6, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00d7, code lost:
        r0 = r2;
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00d9, code lost:
        r4 = r2;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00dc, code lost:
        r5 = r2.$pressedInteraction.getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e4, code lost:
        if (r5 == null) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e6, code lost:
        r7 = r2.$interactionSource;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ea, code lost:
        if (r6 == false) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ec, code lost:
        r6 = new androidx.compose.foundation.interaction.PressInteraction.Release(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f4, code lost:
        r6 = new androidx.compose.foundation.interaction.PressInteraction.Cancel(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00fb, code lost:
        r2.L$0 = null;
        r2.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0108, code lost:
        if (r7.emit(r6, r2) != r0) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x010a, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x010b, code lost:
        r0 = r2;
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x010e, code lost:
        r4 = r2;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0112, code lost:
        r2.$pressedInteraction.setValue(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0119, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r16
            int r2 = r1.label
            r3 = 0
            switch(r2) {
                case 0: goto L_0x004b;
                case 1: goto L_0x003e;
                case 2: goto L_0x0034;
                case 3: goto L_0x0027;
                case 4: goto L_0x001e;
                case 5: goto L_0x0014;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0014:
            r0 = r16
            r2 = r17
            r4 = 0
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x010e
        L_0x001e:
            r0 = r16
            r2 = r17
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x00d9
        L_0x0027:
            r2 = r16
            r4 = r17
            java.lang.Object r5 = r2.L$0
            androidx.compose.foundation.interaction.PressInteraction$Release r5 = (androidx.compose.foundation.interaction.PressInteraction.Release) r5
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x00c3
        L_0x0034:
            r2 = r16
            r4 = r17
            boolean r5 = r2.Z$0
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x00a0
        L_0x003e:
            r2 = r16
            r4 = r17
            java.lang.Object r5 = r2.L$0
            kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5
            kotlin.ResultKt.throwOnFailure(r4)
            r6 = r4
            goto L_0x0082
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r17)
            r2 = r16
            r4 = r17
            java.lang.Object r5 = r2.L$0
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            r7 = 0
            r8 = 0
            androidx.compose.foundation.ClickableKt$handlePressInteraction$2$delayJob$1 r6 = new androidx.compose.foundation.ClickableKt$handlePressInteraction$2$delayJob$1
            androidx.compose.runtime.State<kotlin.jvm.functions.Function0<java.lang.Boolean>> r10 = r2.$delayPressInteraction
            long r11 = r2.$pressPoint
            androidx.compose.foundation.interaction.MutableInteractionSource r13 = r2.$interactionSource
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r14 = r2.$pressedInteraction
            r15 = 0
            r9 = r6
            r9.<init>(r10, r11, r13, r14, r15)
            r9 = r6
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r10 = 3
            r11 = 0
            r6 = r5
            kotlinx.coroutines.Job r5 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r6, r7, r8, r9, r10, r11)
            androidx.compose.foundation.gestures.PressGestureScope r6 = r2.$this_handlePressInteraction
            r7 = r2
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r2.L$0 = r5
            r8 = 1
            r2.label = r8
            java.lang.Object r6 = r6.tryAwaitRelease(r7)
            if (r6 != r0) goto L_0x0082
            return r0
        L_0x0082:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            boolean r7 = r5.isActive()
            if (r7 == 0) goto L_0x00dc
            r7 = r2
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r2.L$0 = r3
            r2.Z$0 = r6
            r8 = 2
            r2.label = r8
            java.lang.Object r5 = kotlinx.coroutines.JobKt.cancelAndJoin(r5, r7)
            if (r5 != r0) goto L_0x009f
            return r0
        L_0x009f:
            r5 = r6
        L_0x00a0:
            if (r5 == 0) goto L_0x0112
            androidx.compose.foundation.interaction.PressInteraction$Press r5 = new androidx.compose.foundation.interaction.PressInteraction$Press
            long r6 = r2.$pressPoint
            r5.<init>(r6, r3)
            androidx.compose.foundation.interaction.PressInteraction$Release r6 = new androidx.compose.foundation.interaction.PressInteraction$Release
            r6.<init>(r5)
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = r2.$interactionSource
            r8 = r5
            androidx.compose.foundation.interaction.Interaction r8 = (androidx.compose.foundation.interaction.Interaction) r8
            r9 = r2
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r2.L$0 = r6
            r10 = 3
            r2.label = r10
            java.lang.Object r5 = r7.emit(r8, r9)
            if (r5 != r0) goto L_0x00c2
            return r0
        L_0x00c2:
            r5 = r6
        L_0x00c3:
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = r2.$interactionSource
            r7 = r5
            androidx.compose.foundation.interaction.Interaction r7 = (androidx.compose.foundation.interaction.Interaction) r7
            r8 = r2
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r2.L$0 = r3
            r9 = 4
            r2.label = r9
            java.lang.Object r5 = r6.emit(r7, r8)
            if (r5 != r0) goto L_0x00d7
            return r0
        L_0x00d7:
            r0 = r2
            r2 = r4
        L_0x00d9:
            r4 = r2
            r2 = r0
            goto L_0x0112
        L_0x00dc:
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r5 = r2.$pressedInteraction
            java.lang.Object r5 = r5.getValue()
            androidx.compose.foundation.interaction.PressInteraction$Press r5 = (androidx.compose.foundation.interaction.PressInteraction.Press) r5
            if (r5 == 0) goto L_0x0112
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = r2.$interactionSource
            r8 = 0
            if (r6 == 0) goto L_0x00f4
            androidx.compose.foundation.interaction.PressInteraction$Release r6 = new androidx.compose.foundation.interaction.PressInteraction$Release
            r6.<init>(r5)
            androidx.compose.foundation.interaction.PressInteraction r6 = (androidx.compose.foundation.interaction.PressInteraction) r6
            goto L_0x00fb
        L_0x00f4:
            androidx.compose.foundation.interaction.PressInteraction$Cancel r6 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
            r6.<init>(r5)
            androidx.compose.foundation.interaction.PressInteraction r6 = (androidx.compose.foundation.interaction.PressInteraction) r6
        L_0x00fb:
            r5 = r6
            r6 = r5
            androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
            r2.L$0 = r3
            r9 = 5
            r2.label = r9
            java.lang.Object r5 = r7.emit(r6, r2)
            if (r5 != r0) goto L_0x010b
            return r0
        L_0x010b:
            r0 = r2
            r2 = r4
            r4 = r8
        L_0x010e:
            r4 = r2
            r2 = r0
        L_0x0112:
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r0 = r2.$pressedInteraction
            r0.setValue(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableKt$handlePressInteraction$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
