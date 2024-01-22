package androidx.compose.foundation;

import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Image.kt */
final class ImageKt$Image$semantics$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ String $contentDescription;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageKt$Image$semantics$1$1(String str) {
        super(1);
        this.$contentDescription = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SemanticsPropertyReceiver) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver $this$semantics) {
        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription($this$semantics, this.$contentDescription);
        SemanticsPropertiesKt.m5327setRolekuIjeqM($this$semantics, Role.Companion.m5316getImageo7Vup1c());
    }
}
