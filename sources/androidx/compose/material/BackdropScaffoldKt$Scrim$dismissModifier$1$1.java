package androidx.compose.material;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.BackdropScaffoldKt$Scrim$dismissModifier$1$1", f = "BackdropScaffold.kt", i = {}, l = {394}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BackdropScaffold.kt */
final class BackdropScaffoldKt$Scrim$dismissModifier$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onDismiss;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackdropScaffoldKt$Scrim$dismissModifier$1$1(Function0<Unit> function0, Continuation<? super BackdropScaffoldKt$Scrim$dismissModifier$1$1> continuation) {
        super(2, continuation);
        this.$onDismiss = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BackdropScaffoldKt$Scrim$dismissModifier$1$1 backdropScaffoldKt$Scrim$dismissModifier$1$1 = new BackdropScaffoldKt$Scrim$dismissModifier$1$1(this.$onDismiss, continuation);
        backdropScaffoldKt$Scrim$dismissModifier$1$1.L$0 = obj;
        return backdropScaffoldKt$Scrim$dismissModifier$1$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((BackdropScaffoldKt$Scrim$dismissModifier$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final Function0<Unit> function0 = this.$onDismiss;
                this.label = 1;
                if (TapGestureDetectorKt.detectTapGestures$default((PointerInputScope) this.L$0, (Function1) null, (Function1) null, (Function3) null, new Function1<Offset, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        m1383invokek4lQ0M(((Offset) p1).m2925unboximpl());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                    public final void m1383invokek4lQ0M(long it) {
                        function0.invoke();
                    }
                }, this, 7, (Object) null) != coroutine_suspended) {
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
}
