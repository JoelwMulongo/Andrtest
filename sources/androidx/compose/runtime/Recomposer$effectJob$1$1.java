package androidx.compose.runtime;

import androidx.compose.runtime.Recomposer;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "throwable", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Recomposer.kt */
final class Recomposer$effectJob$1$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$effectJob$1$1(Recomposer recomposer) {
        super(1);
        this.this$0 = recomposer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Throwable) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable throwable) {
        CancellationException cancellation = ExceptionsKt.CancellationException("Recomposer effect job completed", throwable);
        Object continuationToResume = null;
        Object lock$iv = this.this$0.stateLock;
        Recomposer recomposer = this.this$0;
        synchronized (lock$iv) {
            Job runnerJob = recomposer.runnerJob;
            if (runnerJob != null) {
                recomposer._state.setValue(Recomposer.State.ShuttingDown);
                if (!recomposer.isClosed) {
                    runnerJob.cancel(cancellation);
                } else if (recomposer.workContinuation != null) {
                    continuationToResume = recomposer.workContinuation;
                }
                recomposer.workContinuation = null;
                runnerJob.invokeOnCompletion(new Recomposer$effectJob$1$1$1$1(recomposer, throwable));
            } else {
                recomposer.closeCause = cancellation;
                recomposer._state.setValue(Recomposer.State.ShutDown);
                Unit unit = Unit.INSTANCE;
            }
        }
        if (continuationToResume != null) {
            Result.Companion companion = Result.Companion;
            ((Continuation) continuationToResume).resumeWith(Result.m6273constructorimpl(Unit.INSTANCE));
        }
    }
}
