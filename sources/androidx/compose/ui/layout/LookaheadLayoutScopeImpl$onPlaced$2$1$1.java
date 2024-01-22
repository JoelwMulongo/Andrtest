package androidx.compose.ui.layout;

import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadLayout.kt */
final class LookaheadLayoutScopeImpl$onPlaced$2$1$1 extends Lambda implements Function0<LookaheadLayoutCoordinates> {
    final /* synthetic */ LookaheadLayoutScopeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LookaheadLayoutScopeImpl$onPlaced$2$1$1(LookaheadLayoutScopeImpl lookaheadLayoutScopeImpl) {
        super(0);
        this.this$0 = lookaheadLayoutScopeImpl;
    }

    public final LookaheadLayoutCoordinates invoke() {
        NodeCoordinator $this$invoke_u24lambda_u240 = this.this$0.getRoot();
        if ($this$invoke_u24lambda_u240 != null) {
            LookaheadDelegate lookaheadDelegate$ui_release = $this$invoke_u24lambda_u240.getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinates = lookaheadDelegate$ui_release.getLookaheadLayoutCoordinates();
            if (lookaheadLayoutCoordinates != null) {
                return lookaheadLayoutCoordinates;
            }
        }
        throw new IllegalStateException("Lookahead root has not been set up yet".toString());
    }
}
