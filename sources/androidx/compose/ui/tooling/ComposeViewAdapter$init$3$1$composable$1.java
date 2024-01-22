package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposeViewAdapter.kt */
final class ComposeViewAdapter$init$3$1$composable$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $className;
    final /* synthetic */ Composer $composer;
    final /* synthetic */ String $methodName;
    final /* synthetic */ Class<? extends PreviewParameterProvider<?>> $parameterProvider;
    final /* synthetic */ int $parameterProviderIndex;
    final /* synthetic */ ComposeViewAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComposeViewAdapter$init$3$1$composable$1(String str, String str2, Composer composer, Class<? extends PreviewParameterProvider<?>> cls, int i, ComposeViewAdapter composeViewAdapter) {
        super(0);
        this.$className = str;
        this.$methodName = str2;
        this.$composer = composer;
        this.$parameterProvider = cls;
        this.$parameterProviderIndex = i;
        this.this$0 = composeViewAdapter;
    }

    public final void invoke() {
        Throwable cause;
        try {
            ComposableInvoker composableInvoker = ComposableInvoker.INSTANCE;
            String str = this.$className;
            String str2 = this.$methodName;
            Composer composer = this.$composer;
            Object[] previewProviderParameters = PreviewUtilsKt.getPreviewProviderParameters(this.$parameterProvider, this.$parameterProviderIndex);
            composableInvoker.invokeComposable(str, str2, composer, Arrays.copyOf(previewProviderParameters, previewProviderParameters.length));
        } catch (Throwable t) {
            Throwable exception = t;
            while ((exception instanceof ReflectiveOperationException) && (cause = exception.getCause()) != null) {
                exception = cause;
            }
            this.this$0.delayedException.set(exception);
            throw t;
        }
    }
}