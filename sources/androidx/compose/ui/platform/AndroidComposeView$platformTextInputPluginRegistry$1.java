package androidx.compose.ui.platform;

import androidx.compose.ui.text.input.PlatformTextInput;
import androidx.compose.ui.text.input.PlatformTextInputAdapter;
import androidx.compose.ui.text.input.PlatformTextInputPlugin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/input/PlatformTextInputAdapter;", "factory", "Landroidx/compose/ui/text/input/PlatformTextInputPlugin;", "platformTextInput", "Landroidx/compose/ui/text/input/PlatformTextInput;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
final class AndroidComposeView$platformTextInputPluginRegistry$1 extends Lambda implements Function2<PlatformTextInputPlugin<?>, PlatformTextInput, PlatformTextInputAdapter> {
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidComposeView$platformTextInputPluginRegistry$1(AndroidComposeView androidComposeView) {
        super(2);
        this.this$0 = androidComposeView;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [androidx.compose.ui.text.input.PlatformTextInputPlugin<?>, androidx.compose.ui.text.input.PlatformTextInputPlugin, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.text.input.PlatformTextInputAdapter invoke(androidx.compose.ui.text.input.PlatformTextInputPlugin<?> r2, androidx.compose.ui.text.input.PlatformTextInput r3) {
        /*
            r1 = this;
            java.lang.String r0 = "factory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "platformTextInput"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            androidx.compose.ui.platform.AndroidComposeView r0 = r1.this$0
            android.view.View r0 = (android.view.View) r0
            androidx.compose.ui.text.input.PlatformTextInputAdapter r0 = r2.createAdapter(r3, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$platformTextInputPluginRegistry$1.invoke(androidx.compose.ui.text.input.PlatformTextInputPlugin, androidx.compose.ui.text.input.PlatformTextInput):androidx.compose.ui.text.input.PlatformTextInputAdapter");
    }
}
