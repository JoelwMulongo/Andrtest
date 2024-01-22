package androidx.compose.ui.tooling;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/tooling/PreviewActivity;", "Landroidx/activity/ComponentActivity;", "()V", "TAG", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setComposableContent", "composableFqn", "setParameterizedContent", "className", "methodName", "parameterProvider", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PreviewActivity.kt */
public final class PreviewActivity extends ComponentActivity {
    public static final int $stable = 0;
    private final String TAG = "PreviewActivity";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        String it;
        super.onCreate(savedInstanceState);
        if ((getApplicationInfo().flags & 2) == 0) {
            Log.d(this.TAG, "Application is not debuggable. Compose Preview not allowed.");
            finish();
            return;
        }
        Intent intent = getIntent();
        if (intent != null && (it = intent.getStringExtra("composable")) != null) {
            setComposableContent(it);
        }
    }

    private final void setComposableContent(String composableFqn) {
        Log.d(this.TAG, "PreviewActivity has composable " + composableFqn);
        String className = StringsKt.substringBeforeLast$default(composableFqn, '.', (String) null, 2, (Object) null);
        String methodName = StringsKt.substringAfterLast$default(composableFqn, '.', (String) null, 2, (Object) null);
        String parameterProvider = getIntent().getStringExtra("parameterProviderClassName");
        if (parameterProvider != null) {
            setParameterizedContent(className, methodName, parameterProvider);
            return;
        }
        Log.d(this.TAG, "Previewing '" + methodName + "' without a parameter provider.");
        ComponentActivityKt.setContent$default(this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(-161032931, true, new PreviewActivity$setComposableContent$2(className, methodName)), 1, (Object) null);
    }

    private final void setParameterizedContent(String className, String methodName, String parameterProvider) {
        Log.d(this.TAG, "Previewing '" + methodName + "' with parameter provider: '" + parameterProvider + '\'');
        Object[] previewParameters = PreviewUtilsKt.getPreviewProviderParameters(PreviewUtilsKt.asPreviewProviderClass(parameterProvider), getIntent().getIntExtra("parameterProviderIndex", -1));
        if (previewParameters.length > 1) {
            ComponentActivityKt.setContent$default(this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(-1735847170, true, new PreviewActivity$setParameterizedContent$1(previewParameters, className, methodName)), 1, (Object) null);
        } else {
            ComponentActivityKt.setContent$default(this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(1507674311, true, new PreviewActivity$setParameterizedContent$2(className, methodName, previewParameters)), 1, (Object) null);
        }
    }
}
