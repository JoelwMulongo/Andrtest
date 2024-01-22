package androidx.compose.ui.tooling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Landroidx/compose/ui/tooling/ShadowViewInfo;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.tooling.ShadowViewInfo$allNodes$1", f = "ShadowViewInfo.kt", i = {0, 1}, l = {45, 46}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence"}, s = {"L$0", "L$0"})
/* compiled from: ShadowViewInfo.kt */
final class ShadowViewInfo$allNodes$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super ShadowViewInfo>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ShadowViewInfo this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShadowViewInfo$allNodes$1(ShadowViewInfo shadowViewInfo, Continuation<? super ShadowViewInfo$allNodes$1> continuation) {
        super(2, continuation);
        this.this$0 = shadowViewInfo;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ShadowViewInfo$allNodes$1 shadowViewInfo$allNodes$1 = new ShadowViewInfo$allNodes$1(this.this$0, continuation);
        shadowViewInfo$allNodes$1.L$0 = obj;
        return shadowViewInfo$allNodes$1;
    }

    public final Object invoke(SequenceScope<? super ShadowViewInfo> sequenceScope, Continuation<? super Unit> continuation) {
        return ((ShadowViewInfo$allNodes$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        SequenceScope $this$sequence;
        Iterator it;
        ShadowViewInfo$allNodes$1 shadowViewInfo$allNodes$1;
        SequenceScope $this$sequence2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                shadowViewInfo$allNodes$1 = this;
                $this$sequence2 = (SequenceScope) shadowViewInfo$allNodes$1.L$0;
                shadowViewInfo$allNodes$1.L$0 = $this$sequence2;
                shadowViewInfo$allNodes$1.label = 1;
                if ($this$sequence2.yield(shadowViewInfo$allNodes$1.this$0, shadowViewInfo$allNodes$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                shadowViewInfo$allNodes$1 = this;
                $this$sequence2 = (SequenceScope) shadowViewInfo$allNodes$1.L$0;
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                shadowViewInfo$allNodes$1 = this;
                it = (Iterator) shadowViewInfo$allNodes$1.L$1;
                $this$sequence = (SequenceScope) shadowViewInfo$allNodes$1.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Collection destination$iv$iv = new ArrayList();
        for (ShadowViewInfo it2 : shadowViewInfo$allNodes$1.this$0.getChildren()) {
            CollectionsKt.addAll(destination$iv$iv, it2.getAllNodes());
        }
        Iterator it3 = ((List) destination$iv$iv).iterator();
        $this$sequence = $this$sequence2;
        it = it3;
        while (it.hasNext()) {
            shadowViewInfo$allNodes$1.L$0 = $this$sequence;
            shadowViewInfo$allNodes$1.L$1 = it;
            shadowViewInfo$allNodes$1.label = 2;
            if ($this$sequence.yield((ShadowViewInfo) it.next(), shadowViewInfo$allNodes$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
