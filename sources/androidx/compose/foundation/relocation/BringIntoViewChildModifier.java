package androidx.compose.foundation.relocation;

import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078D@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u00048DX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewChildModifier;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/layout/OnPlacedModifier;", "defaultParent", "Landroidx/compose/foundation/relocation/BringIntoViewParent;", "(Landroidx/compose/foundation/relocation/BringIntoViewParent;)V", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutCoordinates", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "localParent", "parent", "getParent", "()Landroidx/compose/foundation/relocation/BringIntoViewParent;", "onModifierLocalsUpdated", "", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "onPlaced", "coordinates", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BringIntoView.kt */
public abstract class BringIntoViewChildModifier implements ModifierLocalConsumer, OnPlacedModifier {
    private final BringIntoViewParent defaultParent;
    private LayoutCoordinates layoutCoordinates;
    private BringIntoViewParent localParent;

    public BringIntoViewChildModifier(BringIntoViewParent defaultParent2) {
        Intrinsics.checkNotNullParameter(defaultParent2, "defaultParent");
        this.defaultParent = defaultParent2;
    }

    /* access modifiers changed from: protected */
    public final LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates it = this.layoutCoordinates;
        if (it == null || !it.isAttached()) {
            return null;
        }
        return it;
    }

    /* access modifiers changed from: protected */
    public final BringIntoViewParent getParent() {
        BringIntoViewParent bringIntoViewParent = this.localParent;
        return bringIntoViewParent == null ? this.defaultParent : bringIntoViewParent;
    }

    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.localParent = (BringIntoViewParent) scope.getCurrent(BringIntoViewKt.getModifierLocalBringIntoViewParent());
    }

    public void onPlaced(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        this.layoutCoordinates = coordinates;
    }
}
