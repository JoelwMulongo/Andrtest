package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackdropScaffold.kt */
final class BackdropScaffoldKt$BackdropStack$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $backLayer;
    final /* synthetic */ Function1<Constraints, Constraints> $calculateBackLayerConstraints;
    final /* synthetic */ Function4<Constraints, Float, Composer, Integer, Unit> $frontLayer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackdropScaffoldKt$BackdropStack$1$1(Function2<? super Composer, ? super Integer, Unit> function2, Function1<? super Constraints, Constraints> function1, Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> function4, int i) {
        super(2);
        this.$backLayer = function2;
        this.$calculateBackLayerConstraints = function1;
        this.$frontLayer = function4;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m1382invoke0kLqBqw((SubcomposeMeasureScope) p1, ((Constraints) p2).m5936unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m1382invoke0kLqBqw(SubcomposeMeasureScope $this$SubcomposeLayout, long constraints) {
        SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
        final Placeable backLayerPlaceable = ((Measurable) CollectionsKt.first(subcomposeMeasureScope.subcompose(BackdropLayers.Back, this.$backLayer))).m4863measureBRTryo0(this.$calculateBackLayerConstraints.invoke(Constraints.m5918boximpl(constraints)).m5936unboximpl());
        float backLayerHeight = (float) backLayerPlaceable.getHeight();
        List subcompose = subcomposeMeasureScope.subcompose(BackdropLayers.Front, ComposableLambdaKt.composableLambdaInstance(-1222642649, true, new BackdropScaffoldKt$BackdropStack$1$1$placeables$1(this.$frontLayer, constraints, backLayerHeight, this.$$dirty)));
        ArrayList target$iv = new ArrayList(subcompose.size());
        List $this$fastForEach$iv$iv = subcompose;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size) {
            target$iv.add(((Measurable) $this$fastForEach$iv$iv.get(index$iv$iv)).m4863measureBRTryo0(constraints));
            index$iv$iv++;
            backLayerHeight = backLayerHeight;
            subcompose = subcompose;
        }
        List<Measurable> list = subcompose;
        long j = constraints;
        final List placeables = target$iv;
        int maxWidth = Math.max(Constraints.m5932getMinWidthimpl(constraints), backLayerPlaceable.getWidth());
        int maxHeight = Math.max(Constraints.m5931getMinHeightimpl(constraints), backLayerPlaceable.getHeight());
        List $this$fastForEach$iv = placeables;
        int size2 = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size2; index$iv++) {
            Placeable it = (Placeable) $this$fastForEach$iv.get(index$iv);
            maxWidth = Math.max(maxWidth, it.getWidth());
            maxHeight = Math.max(maxHeight, it.getHeight());
        }
        return MeasureScope.layout$default(subcomposeMeasureScope, maxWidth, maxHeight, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((Placeable.PlacementScope) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope $this$layout) {
                Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
                Placeable.PlacementScope.placeRelative$default($this$layout, backLayerPlaceable, 0, 0, 0.0f, 4, (Object) null);
                List $this$fastForEach$iv = placeables;
                int size = $this$fastForEach$iv.size();
                for (int index$iv = 0; index$iv < size; index$iv++) {
                    Placeable.PlacementScope.placeRelative$default($this$layout, $this$fastForEach$iv.get(index$iv), 0, 0, 0.0f, 4, (Object) null);
                }
            }
        }, 4, (Object) null);
    }
}
