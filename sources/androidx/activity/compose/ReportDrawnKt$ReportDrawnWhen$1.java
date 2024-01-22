package androidx.activity.compose;

import androidx.activity.FullyDrawnReporter;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ReportDrawn.kt */
final class ReportDrawnKt$ReportDrawnWhen$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ FullyDrawnReporter $fullyDrawnReporter;
    final /* synthetic */ Function0<Boolean> $predicate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReportDrawnKt$ReportDrawnWhen$1(FullyDrawnReporter fullyDrawnReporter, Function0<Boolean> function0) {
        super(1);
        this.$fullyDrawnReporter = fullyDrawnReporter;
        this.$predicate = function0;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        if (this.$fullyDrawnReporter.isFullyDrawnReported()) {
            DisposableEffectScope disposableEffectScope = $this$DisposableEffect;
            return new ReportDrawnKt$ReportDrawnWhen$1$invoke$$inlined$onDispose$1();
        }
        DisposableEffectScope disposableEffectScope2 = $this$DisposableEffect;
        return new ReportDrawnKt$ReportDrawnWhen$1$invoke$$inlined$onDispose$2(new ReportDrawnComposition(this.$fullyDrawnReporter, this.$predicate));
    }
}
