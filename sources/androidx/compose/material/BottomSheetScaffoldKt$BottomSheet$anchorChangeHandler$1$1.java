package androidx.compose.material;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheet$anchorChangeHandler$1$1 extends Lambda implements Function1<BottomSheetValue, Unit> {
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ BottomSheetState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheet$anchorChangeHandler$1$1(CoroutineScope coroutineScope, BottomSheetState bottomSheetState) {
        super(1);
        this.$scope = coroutineScope;
        this.$state = bottomSheetState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((BottomSheetValue) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(final BottomSheetValue target) {
        Intrinsics.checkNotNullParameter(target, "target");
        CoroutineScope coroutineScope = this.$scope;
        final BottomSheetState bottomSheetState = this.$state;
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$anchorChangeHandler$1$1$1", f = "BottomSheetScaffold.kt", i = {}, l = {415}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$anchorChangeHandler$1$1$1  reason: invalid class name */
    /* compiled from: BottomSheetScaffold.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(bottomSheetState, target, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (BottomSheetState.animateTo$material_release$default(bottomSheetState, target, 0.0f, this, 2, (Object) null) != coroutine_suspended) {
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
}
