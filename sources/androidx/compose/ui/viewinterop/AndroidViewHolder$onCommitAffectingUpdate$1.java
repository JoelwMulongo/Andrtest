package androidx.compose.ui.viewinterop;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidViewHolder.android.kt */
final class AndroidViewHolder$onCommitAffectingUpdate$1 extends Lambda implements Function1<AndroidViewHolder, Unit> {
    final /* synthetic */ AndroidViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$onCommitAffectingUpdate$1(AndroidViewHolder androidViewHolder) {
        super(1);
        this.this$0 = androidViewHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((AndroidViewHolder) p1);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(Function0 $tmp0) {
        Intrinsics.checkNotNullParameter($tmp0, "$tmp0");
        $tmp0.invoke();
    }

    public final void invoke(AndroidViewHolder it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this.this$0.getHandler().post(new AndroidViewHolder$onCommitAffectingUpdate$1$$ExternalSyntheticLambda0(this.this$0.runUpdate));
    }
}
