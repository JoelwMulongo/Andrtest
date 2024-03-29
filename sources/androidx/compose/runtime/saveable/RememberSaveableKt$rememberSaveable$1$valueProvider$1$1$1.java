package androidx.compose.runtime.saveable;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: RememberSaveable.kt */
final class RememberSaveableKt$rememberSaveable$1$valueProvider$1$1$1 implements SaverScope {
    final /* synthetic */ SaveableStateRegistry $registry;

    RememberSaveableKt$rememberSaveable$1$valueProvider$1$1$1(SaveableStateRegistry saveableStateRegistry) {
        this.$registry = saveableStateRegistry;
    }

    public final boolean canBeSaved(Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this.$registry.canBeSaved(it);
    }
}
