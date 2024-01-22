package androidx.compose.ui.platform;

import android.content.res.Configuration;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidCompositionLocals.android.kt */
final class AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$1$1 extends Lambda implements Function1<Configuration, Unit> {
    final /* synthetic */ MutableState<Configuration> $configuration$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$1$1(MutableState<Configuration> mutableState) {
        super(1);
        this.$configuration$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Configuration) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Configuration it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals$lambda$2(this.$configuration$delegate, it);
    }
}
