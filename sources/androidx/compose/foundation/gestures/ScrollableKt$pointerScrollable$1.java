package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
final class ScrollableKt$pointerScrollable$1 extends Lambda implements Function1<PointerInputChange, Boolean> {
    public static final ScrollableKt$pointerScrollable$1 INSTANCE = new ScrollableKt$pointerScrollable$1();

    ScrollableKt$pointerScrollable$1() {
        super(1);
    }

    public final Boolean invoke(PointerInputChange down) {
        Intrinsics.checkNotNullParameter(down, "down");
        return Boolean.valueOf(!PointerType.m4739equalsimpl0(down.m4670getTypeT8wyACA(), PointerType.Companion.m4744getMouseT8wyACA()));
    }
}
