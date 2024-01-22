package androidx.compose.ui.text.input;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.ui.platform.AndroidComposeView_androidKt;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/input/AndroidTextInputServicePlugin;", "Landroidx/compose/ui/text/input/PlatformTextInputPlugin;", "Landroidx/compose/ui/text/input/AndroidTextInputServicePlugin$Adapter;", "()V", "createAdapter", "platformTextInput", "Landroidx/compose/ui/text/input/PlatformTextInput;", "view", "Landroid/view/View;", "Adapter", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidTextInputServicePlugin.kt */
public final class AndroidTextInputServicePlugin implements PlatformTextInputPlugin<Adapter> {
    public static final AndroidTextInputServicePlugin INSTANCE = new AndroidTextInputServicePlugin();

    private AndroidTextInputServicePlugin() {
    }

    public Adapter createAdapter(PlatformTextInput platformTextInput, View view) {
        Intrinsics.checkNotNullParameter(platformTextInput, "platformTextInput");
        Intrinsics.checkNotNullParameter(view, "view");
        TextInputServiceAndroid platformService = new TextInputServiceAndroid(view, platformTextInput);
        return new Adapter(AndroidComposeView_androidKt.getTextInputServiceFactory().invoke(platformService), platformService);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/input/AndroidTextInputServicePlugin$Adapter;", "Landroidx/compose/ui/text/input/PlatformTextInputAdapter;", "service", "Landroidx/compose/ui/text/input/TextInputService;", "androidService", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "(Landroidx/compose/ui/text/input/TextInputService;Landroidx/compose/ui/text/input/TextInputServiceAndroid;)V", "inputForTests", "Landroidx/compose/ui/text/input/TextInputForTests;", "getInputForTests", "()Landroidx/compose/ui/text/input/TextInputForTests;", "getService", "()Landroidx/compose/ui/text/input/TextInputService;", "createInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidTextInputServicePlugin.kt */
    public static final class Adapter implements PlatformTextInputAdapter {
        public static final int $stable = 8;
        private final TextInputServiceAndroid androidService;
        private final TextInputService service;

        public Adapter(TextInputService service2, TextInputServiceAndroid androidService2) {
            Intrinsics.checkNotNullParameter(service2, NotificationCompat.CATEGORY_SERVICE);
            Intrinsics.checkNotNullParameter(androidService2, "androidService");
            this.service = service2;
            this.androidService = androidService2;
        }

        public final TextInputService getService() {
            return this.service;
        }

        public TextInputForTests getInputForTests() {
            TextInputService textInputService = this.service;
            TextInputForTests textInputForTests = textInputService instanceof TextInputForTests ? (TextInputForTests) textInputService : null;
            if (textInputForTests != null) {
                return textInputForTests;
            }
            throw new IllegalStateException("Text input service wrapper not set up! Did you use ComposeTestRule?".toString());
        }

        public InputConnection createInputConnection(EditorInfo outAttrs) {
            Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
            return this.androidService.createInputConnection(outAttrs);
        }
    }
}
