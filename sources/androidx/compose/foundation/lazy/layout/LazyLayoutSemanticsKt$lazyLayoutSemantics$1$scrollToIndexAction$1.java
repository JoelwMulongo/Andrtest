package androidx.compose.foundation.lazy.layout;

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
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutSemantics.kt */
final class LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1 extends Lambda implements Function1<Integer, Boolean> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ LazyLayoutItemProvider $itemProvider;
    final /* synthetic */ LazyLayoutSemanticState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1(LazyLayoutItemProvider lazyLayoutItemProvider, CoroutineScope coroutineScope, LazyLayoutSemanticState lazyLayoutSemanticState) {
        super(1);
        this.$itemProvider = lazyLayoutItemProvider;
        this.$coroutineScope = coroutineScope;
        this.$state = lazyLayoutSemanticState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).intValue());
    }

    public final Boolean invoke(final int index) {
        boolean z = index >= 0 && index < this.$itemProvider.getItemCount();
        LazyLayoutItemProvider lazyLayoutItemProvider = this.$itemProvider;
        if (z) {
            CoroutineScope coroutineScope = this.$coroutineScope;
            final LazyLayoutSemanticState lazyLayoutSemanticState = this.$state;
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2((Continuation<? super AnonymousClass2>) null), 3, (Object) null);
            return true;
        }
        throw new IllegalArgumentException(("Can't scroll to index " + index + ", it is out of bounds [0, " + lazyLayoutItemProvider.getItemCount() + ')').toString());
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1$2", f = "LazyLayoutSemantics.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1$2  reason: invalid class name */
    /* compiled from: LazyLayoutSemantics.kt */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(lazyLayoutSemanticState, index, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (lazyLayoutSemanticState.scrollToItem(index, this) != coroutine_suspended) {
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
