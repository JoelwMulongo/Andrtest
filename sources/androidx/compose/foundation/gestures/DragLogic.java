package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B¡\u0001\u0012<\u0010\u0002\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\b\u000b\u0012<\u0010\f\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\b\u000b\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0015\u0010\u001d\u001a\u00020\n*\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\n*\u00020\u00042\u0006\u0010 \u001a\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u001d\u0010#\u001a\u00020\n*\u00020\u00042\u0006\u0010 \u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u0010%R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018RO\u0010\u0002\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\b\u000bø\u0001\u0000ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aRO\u0010\f\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\b\u000bø\u0001\u0000ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001a\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Landroidx/compose/foundation/gestures/DragLogic;", "", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "Landroidx/compose/ui/unit/Velocity;", "velocity", "dragStartInteraction", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/MutableState;Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "getDragStartInteraction", "()Landroidx/compose/runtime/MutableState;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getOnDragStarted", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "getOnDragStopped", "processDragCancel", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStart", "event", "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/DragEvent$DragStarted;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStop", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/DragEvent$DragStopped;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable.kt */
final class DragLogic {
    private final MutableState<DragInteraction.Start> dragStartInteraction;
    private final MutableInteractionSource interactionSource;
    private final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> onDragStarted;
    private final Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> onDragStopped;

    public DragLogic(Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted2, Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> onDragStopped2, MutableState<DragInteraction.Start> dragStartInteraction2, MutableInteractionSource interactionSource2) {
        Intrinsics.checkNotNullParameter(onDragStarted2, "onDragStarted");
        Intrinsics.checkNotNullParameter(onDragStopped2, "onDragStopped");
        Intrinsics.checkNotNullParameter(dragStartInteraction2, "dragStartInteraction");
        this.onDragStarted = onDragStarted2;
        this.onDragStopped = onDragStopped2;
        this.dragStartInteraction = dragStartInteraction2;
        this.interactionSource = interactionSource2;
    }

    public final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> getOnDragStarted() {
        return this.onDragStarted;
    }

    public final Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> getOnDragStopped() {
        return this.onDragStopped;
    }

    public final MutableState<DragInteraction.Start> getDragStartInteraction() {
        return this.dragStartInteraction;
    }

    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0084, code lost:
        r9 = new androidx.compose.foundation.interaction.DragInteraction.Start();
        r4 = r3.interactionSource;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008c, code lost:
        if (r4 == null) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        r11.L$0 = r3;
        r11.L$1 = r2;
        r11.L$2 = r10;
        r11.L$3 = r9;
        r11.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a0, code lost:
        if (r4.emit(r9, r11) != r1) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a2, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a3, code lost:
        r3.dragStartInteraction.setValue(r9);
        r9 = r3.onDragStarted;
        r4 = androidx.compose.ui.geometry.Offset.m2904boximpl(r10.m536getStartPointF1C5BW0());
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.L$3 = null;
        r11.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c3, code lost:
        if (r9.invoke(r2, r4, r11) != r1) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c5, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c8, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processDragStart(kotlinx.coroutines.CoroutineScope r9, androidx.compose.foundation.gestures.DragEvent.DragStarted r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.compose.foundation.gestures.DragLogic$processDragStart$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.foundation.gestures.DragLogic$processDragStart$1 r0 = (androidx.compose.foundation.gestures.DragLogic$processDragStart$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.DragLogic$processDragStart$1 r0 = new androidx.compose.foundation.gestures.DragLogic$processDragStart$1
            r0.<init>(r8, r11)
        L_0x0019:
            r11 = r0
            java.lang.Object r0 = r11.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r11.label
            switch(r2) {
                case 0: goto L_0x0057;
                case 1: goto L_0x0046;
                case 2: goto L_0x0032;
                case 3: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00c6
        L_0x0032:
            java.lang.Object r9 = r11.L$3
            androidx.compose.foundation.interaction.DragInteraction$Start r9 = (androidx.compose.foundation.interaction.DragInteraction.Start) r9
            java.lang.Object r10 = r11.L$2
            androidx.compose.foundation.gestures.DragEvent$DragStarted r10 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r10
            java.lang.Object r2 = r11.L$1
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            java.lang.Object r3 = r11.L$0
            androidx.compose.foundation.gestures.DragLogic r3 = (androidx.compose.foundation.gestures.DragLogic) r3
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00a3
        L_0x0046:
            r9 = 0
            java.lang.Object r10 = r11.L$2
            androidx.compose.foundation.gestures.DragEvent$DragStarted r10 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r10
            java.lang.Object r2 = r11.L$1
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            java.lang.Object r3 = r11.L$0
            androidx.compose.foundation.gestures.DragLogic r3 = (androidx.compose.foundation.gestures.DragLogic) r3
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0083
        L_0x0057:
            kotlin.ResultKt.throwOnFailure(r0)
            r3 = r8
            r2 = r9
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.DragInteraction$Start> r9 = r3.dragStartInteraction
            java.lang.Object r9 = r9.getValue()
            androidx.compose.foundation.interaction.DragInteraction$Start r9 = (androidx.compose.foundation.interaction.DragInteraction.Start) r9
            if (r9 == 0) goto L_0x0084
            r4 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = r3.interactionSource
            if (r5 == 0) goto L_0x0084
            androidx.compose.foundation.interaction.DragInteraction$Cancel r6 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r6.<init>(r9)
            androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
            r11.L$0 = r3
            r11.L$1 = r2
            r11.L$2 = r10
            r7 = 1
            r11.label = r7
            java.lang.Object r9 = r5.emit(r6, r11)
            if (r9 != r1) goto L_0x0082
            return r1
        L_0x0082:
            r9 = r4
        L_0x0083:
        L_0x0084:
            androidx.compose.foundation.interaction.DragInteraction$Start r9 = new androidx.compose.foundation.interaction.DragInteraction$Start
            r9.<init>()
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r3.interactionSource
            if (r4 == 0) goto L_0x00a3
            r5 = r9
            androidx.compose.foundation.interaction.Interaction r5 = (androidx.compose.foundation.interaction.Interaction) r5
            r11.L$0 = r3
            r11.L$1 = r2
            r11.L$2 = r10
            r11.L$3 = r9
            r6 = 2
            r11.label = r6
            java.lang.Object r4 = r4.emit(r5, r11)
            if (r4 != r1) goto L_0x00a3
            return r1
        L_0x00a3:
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.DragInteraction$Start> r4 = r3.dragStartInteraction
            r4.setValue(r9)
            kotlin.jvm.functions.Function3<kotlinx.coroutines.CoroutineScope, androidx.compose.ui.geometry.Offset, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r9 = r3.onDragStarted
            long r4 = r10.m536getStartPointF1C5BW0()
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m2904boximpl(r4)
            r5 = 0
            r11.L$0 = r5
            r11.L$1 = r5
            r11.L$2 = r5
            r11.L$3 = r5
            r5 = 3
            r11.label = r5
            java.lang.Object r9 = r9.invoke(r2, r4, r11)
            if (r9 != r1) goto L_0x00c6
            return r1
        L_0x00c6:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragLogic.processDragStart(kotlinx.coroutines.CoroutineScope, androidx.compose.foundation.gestures.DragEvent$DragStarted, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006f, code lost:
        r5 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0071, code lost:
        r4.dragStartInteraction.setValue(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0078, code lost:
        r10 = r4.onDragStopped;
        r5 = androidx.compose.ui.unit.Velocity.m6202boximpl(r11.m537getVelocity9UxMQ8M());
        r12.L$0 = null;
        r12.L$1 = null;
        r12.L$2 = null;
        r12.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008f, code lost:
        if (r10.invoke(r2, r5, r12) != r1) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0091, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0094, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processDragStop(kotlinx.coroutines.CoroutineScope r10, androidx.compose.foundation.gestures.DragEvent.DragStopped r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof androidx.compose.foundation.gestures.DragLogic$processDragStop$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.foundation.gestures.DragLogic$processDragStop$1 r0 = (androidx.compose.foundation.gestures.DragLogic$processDragStop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.DragLogic$processDragStop$1 r0 = new androidx.compose.foundation.gestures.DragLogic$processDragStop$1
            r0.<init>(r9, r12)
        L_0x0019:
            r12 = r0
            java.lang.Object r0 = r12.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r12.label
            r3 = 0
            switch(r2) {
                case 0: goto L_0x0043;
                case 1: goto L_0x0032;
                case 2: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0092
        L_0x0032:
            r10 = 0
            java.lang.Object r11 = r12.L$2
            androidx.compose.foundation.gestures.DragEvent$DragStopped r11 = (androidx.compose.foundation.gestures.DragEvent.DragStopped) r11
            java.lang.Object r2 = r12.L$1
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            java.lang.Object r4 = r12.L$0
            androidx.compose.foundation.gestures.DragLogic r4 = (androidx.compose.foundation.gestures.DragLogic) r4
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x006f
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r0)
            r4 = r9
            r2 = r10
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.DragInteraction$Start> r10 = r4.dragStartInteraction
            java.lang.Object r10 = r10.getValue()
            androidx.compose.foundation.interaction.DragInteraction$Start r10 = (androidx.compose.foundation.interaction.DragInteraction.Start) r10
            if (r10 == 0) goto L_0x0078
            r5 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = r4.interactionSource
            if (r6 == 0) goto L_0x0071
            androidx.compose.foundation.interaction.DragInteraction$Stop r7 = new androidx.compose.foundation.interaction.DragInteraction$Stop
            r7.<init>(r10)
            androidx.compose.foundation.interaction.Interaction r7 = (androidx.compose.foundation.interaction.Interaction) r7
            r12.L$0 = r4
            r12.L$1 = r2
            r12.L$2 = r11
            r8 = 1
            r12.label = r8
            java.lang.Object r10 = r6.emit(r7, r12)
            if (r10 != r1) goto L_0x006e
            return r1
        L_0x006e:
            r10 = r5
        L_0x006f:
            r5 = r10
        L_0x0071:
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.DragInteraction$Start> r10 = r4.dragStartInteraction
            r10.setValue(r3)
        L_0x0078:
            kotlin.jvm.functions.Function3<kotlinx.coroutines.CoroutineScope, androidx.compose.ui.unit.Velocity, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r10 = r4.onDragStopped
            long r5 = r11.m537getVelocity9UxMQ8M()
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.m6202boximpl(r5)
            r12.L$0 = r3
            r12.L$1 = r3
            r12.L$2 = r3
            r3 = 2
            r12.label = r3
            java.lang.Object r10 = r10.invoke(r2, r5, r12)
            if (r10 != r1) goto L_0x0092
            return r1
        L_0x0092:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragLogic.processDragStop(kotlinx.coroutines.CoroutineScope, androidx.compose.foundation.gestures.DragEvent$DragStopped, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
        r5 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006b, code lost:
        r4.dragStartInteraction.setValue(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0072, code lost:
        r10 = r4.onDragStopped;
        r5 = androidx.compose.ui.unit.Velocity.m6202boximpl(androidx.compose.ui.unit.Velocity.Companion.m6222getZero9UxMQ8M());
        r11.L$0 = null;
        r11.L$1 = null;
        r11.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0089, code lost:
        if (r10.invoke(r2, r5, r11) != r1) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008e, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processDragCancel(kotlinx.coroutines.CoroutineScope r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.compose.foundation.gestures.DragLogic$processDragCancel$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.foundation.gestures.DragLogic$processDragCancel$1 r0 = (androidx.compose.foundation.gestures.DragLogic$processDragCancel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.DragLogic$processDragCancel$1 r0 = new androidx.compose.foundation.gestures.DragLogic$processDragCancel$1
            r0.<init>(r9, r11)
        L_0x0019:
            r11 = r0
            java.lang.Object r0 = r11.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r11.label
            r3 = 0
            switch(r2) {
                case 0: goto L_0x003f;
                case 1: goto L_0x0032;
                case 2: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x008c
        L_0x0032:
            r10 = 0
            java.lang.Object r2 = r11.L$1
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            java.lang.Object r4 = r11.L$0
            androidx.compose.foundation.gestures.DragLogic r4 = (androidx.compose.foundation.gestures.DragLogic) r4
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0069
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r0)
            r4 = r9
            r2 = r10
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.DragInteraction$Start> r10 = r4.dragStartInteraction
            java.lang.Object r10 = r10.getValue()
            androidx.compose.foundation.interaction.DragInteraction$Start r10 = (androidx.compose.foundation.interaction.DragInteraction.Start) r10
            if (r10 == 0) goto L_0x0072
            r5 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = r4.interactionSource
            if (r6 == 0) goto L_0x006b
            androidx.compose.foundation.interaction.DragInteraction$Cancel r7 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r7.<init>(r10)
            androidx.compose.foundation.interaction.Interaction r7 = (androidx.compose.foundation.interaction.Interaction) r7
            r11.L$0 = r4
            r11.L$1 = r2
            r8 = 1
            r11.label = r8
            java.lang.Object r10 = r6.emit(r7, r11)
            if (r10 != r1) goto L_0x0068
            return r1
        L_0x0068:
            r10 = r5
        L_0x0069:
            r5 = r10
        L_0x006b:
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.DragInteraction$Start> r10 = r4.dragStartInteraction
            r10.setValue(r3)
        L_0x0072:
            kotlin.jvm.functions.Function3<kotlinx.coroutines.CoroutineScope, androidx.compose.ui.unit.Velocity, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r10 = r4.onDragStopped
            androidx.compose.ui.unit.Velocity$Companion r5 = androidx.compose.ui.unit.Velocity.Companion
            long r5 = r5.m6222getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.m6202boximpl(r5)
            r11.L$0 = r3
            r11.L$1 = r3
            r3 = 2
            r11.label = r3
            java.lang.Object r10 = r10.invoke(r2, r5, r11)
            if (r10 != r1) goto L_0x008c
            return r1
        L_0x008c:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragLogic.processDragCancel(kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
