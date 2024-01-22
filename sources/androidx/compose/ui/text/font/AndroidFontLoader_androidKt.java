package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001d\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"load", "Landroid/graphics/Typeface;", "Landroidx/compose/ui/text/font/ResourceFont;", "context", "Landroid/content/Context;", "loadAsync", "(Landroidx/compose/ui/text/font/ResourceFont;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidFontLoader.android.kt */
public final class AndroidFontLoader_androidKt {
    /* access modifiers changed from: private */
    public static final Typeface load(ResourceFont $this$load, Context context) {
        return ResourceFontHelper.INSTANCE.load(context, $this$load);
    }

    /* access modifiers changed from: private */
    public static final Object loadAsync(ResourceFont $this$loadAsync, Context context, Continuation<? super Typeface> $completion) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AndroidFontLoader_androidKt$loadAsync$2($this$loadAsync, context, (Continuation<? super AndroidFontLoader_androidKt$loadAsync$2>) null), $completion);
    }
}
