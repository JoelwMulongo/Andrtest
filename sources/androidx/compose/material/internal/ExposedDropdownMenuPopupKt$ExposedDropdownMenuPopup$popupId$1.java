package androidx.compose.material.internal;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenuPopup.kt */
final class ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupId$1 extends Lambda implements Function0<UUID> {
    public static final ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupId$1 INSTANCE = new ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupId$1();

    ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupId$1() {
        super(0);
    }

    public final UUID invoke() {
        return UUID.randomUUID();
    }
}
