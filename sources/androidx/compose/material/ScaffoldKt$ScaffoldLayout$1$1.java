package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scaffold.kt */
final class ScaffoldKt$ScaffoldLayout$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $bottomBar;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ Function2<Composer, Integer, Unit> $fab;
    final /* synthetic */ int $fabPosition;
    final /* synthetic */ boolean $isFabDocked;
    final /* synthetic */ Function2<Composer, Integer, Unit> $snackbar;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScaffoldKt$ScaffoldLayout$1$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i, boolean z, Function2<? super Composer, ? super Integer, Unit> function24, int i2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$topBar = function2;
        this.$snackbar = function22;
        this.$fab = function23;
        this.$fabPosition = i;
        this.$isFabDocked = z;
        this.$bottomBar = function24;
        this.$$dirty = i2;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m1592invoke0kLqBqw((SubcomposeMeasureScope) p1, ((Constraints) p2).m5936unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m1592invoke0kLqBqw(SubcomposeMeasureScope $this$SubcomposeLayout, long constraints) {
        SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
        int layoutWidth = Constraints.m5930getMaxWidthimpl(constraints);
        int layoutHeight = Constraints.m5929getMaxHeightimpl(constraints);
        long looseConstraints = Constraints.m5921copyZbe2FdA$default(constraints, 0, 0, 0, 0, 10, (Object) null);
        final Function2<Composer, Integer, Unit> function2 = this.$topBar;
        final Function2<Composer, Integer, Unit> function22 = this.$snackbar;
        final Function2<Composer, Integer, Unit> function23 = this.$fab;
        final int i = this.$fabPosition;
        final boolean z = this.$isFabDocked;
        final Function2<Composer, Integer, Unit> function24 = this.$bottomBar;
        final int i2 = this.$$dirty;
        final Function3<PaddingValues, Composer, Integer, Unit> function3 = this.$content;
        final SubcomposeMeasureScope subcomposeMeasureScope2 = $this$SubcomposeLayout;
        final int i3 = layoutWidth;
        final int i4 = layoutHeight;
        final long j = looseConstraints;
        return MeasureScope.layout$default(subcomposeMeasureScope, layoutWidth, layoutHeight, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((Placeable.PlacementScope) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope $this$layout) {
                Object maxElem$iv;
                Object maxElem$iv2;
                FabPlacement fabPlacement;
                Object maxElem$iv3;
                Integer num;
                int i;
                int i2;
                Object maxElem$iv4;
                Object maxElem$iv5;
                int fabLeftOffset;
                Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
                List subcompose = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.TopBar, function2);
                long j = j;
                List target$iv = new ArrayList(subcompose.size());
                List $this$fastForEach$iv$iv = subcompose;
                int size = $this$fastForEach$iv$iv.size();
                for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                    target$iv.add(((Measurable) $this$fastForEach$iv$iv.get(index$iv$iv)).m4863measureBRTryo0(j));
                }
                List topBarPlaceables = target$iv;
                List $this$fastMaxBy$iv = topBarPlaceables;
                if ($this$fastMaxBy$iv.isEmpty()) {
                    maxElem$iv = null;
                } else {
                    maxElem$iv = $this$fastMaxBy$iv.get(0);
                    int maxValue$iv = ((Placeable) maxElem$iv).getHeight();
                    int i$iv = 1;
                    int lastIndex = CollectionsKt.getLastIndex($this$fastMaxBy$iv);
                    if (1 <= lastIndex) {
                        while (true) {
                            Object e$iv = $this$fastMaxBy$iv.get(i$iv);
                            int v$iv = ((Placeable) e$iv).getHeight();
                            if (maxValue$iv < v$iv) {
                                maxElem$iv = e$iv;
                                maxValue$iv = v$iv;
                            }
                            if (i$iv == lastIndex) {
                                break;
                            }
                            i$iv++;
                        }
                    }
                }
                Placeable placeable = (Placeable) maxElem$iv;
                int topBarHeight = placeable != null ? placeable.getHeight() : 0;
                List subcompose2 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.Snackbar, function22);
                long j2 = j;
                List target$iv2 = new ArrayList(subcompose2.size());
                List $this$fastForEach$iv$iv2 = subcompose2;
                int size2 = $this$fastForEach$iv$iv2.size();
                for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                    target$iv2.add(((Measurable) $this$fastForEach$iv$iv2.get(index$iv$iv2)).m4863measureBRTryo0(j2));
                }
                List $this$fastMaxBy$iv2 = target$iv2;
                List snackbarPlaceables = $this$fastMaxBy$iv2;
                if ($this$fastMaxBy$iv2.isEmpty()) {
                    maxElem$iv2 = null;
                } else {
                    maxElem$iv2 = $this$fastMaxBy$iv2.get(0);
                    int maxValue$iv2 = ((Placeable) maxElem$iv2).getHeight();
                    int i$iv2 = 1;
                    int lastIndex2 = CollectionsKt.getLastIndex($this$fastMaxBy$iv2);
                    if (1 <= lastIndex2) {
                        while (true) {
                            Object e$iv2 = $this$fastMaxBy$iv2.get(i$iv2);
                            int v$iv2 = ((Placeable) e$iv2).getHeight();
                            if (maxValue$iv2 < v$iv2) {
                                maxElem$iv2 = e$iv2;
                                maxValue$iv2 = v$iv2;
                            }
                            if (i$iv2 == lastIndex2) {
                                break;
                            }
                            i$iv2++;
                        }
                    }
                }
                Placeable placeable2 = (Placeable) maxElem$iv2;
                int snackbarHeight = placeable2 != null ? placeable2.getHeight() : 0;
                List $this$fastMap$iv = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.Fab, function23);
                long j3 = j;
                int $i$f$fastMap = false;
                List target$iv3 = new ArrayList($this$fastMap$iv.size());
                List $this$fastForEach$iv$iv3 = $this$fastMap$iv;
                int index$iv$iv3 = 0;
                int size3 = $this$fastForEach$iv$iv3.size();
                while (index$iv$iv3 < size3) {
                    target$iv3.add(((Measurable) $this$fastForEach$iv$iv3.get(index$iv$iv3)).m4863measureBRTryo0(j3));
                    index$iv$iv3++;
                    $this$fastMap$iv = $this$fastMap$iv;
                    $i$f$fastMap = $i$f$fastMap;
                }
                int i3 = $i$f$fastMap;
                List fabPlaceables = target$iv3;
                if (!fabPlaceables.isEmpty()) {
                    List $this$fastMaxBy$iv3 = fabPlaceables;
                    if ($this$fastMaxBy$iv3.isEmpty()) {
                        maxElem$iv4 = null;
                    } else {
                        maxElem$iv4 = $this$fastMaxBy$iv3.get(0);
                        int maxValue$iv3 = ((Placeable) maxElem$iv4).getWidth();
                        int i$iv3 = 1;
                        int lastIndex3 = CollectionsKt.getLastIndex($this$fastMaxBy$iv3);
                        if (1 <= lastIndex3) {
                            while (true) {
                                Object e$iv3 = $this$fastMaxBy$iv3.get(i$iv3);
                                int v$iv3 = ((Placeable) e$iv3).getWidth();
                                if (maxValue$iv3 < v$iv3) {
                                    maxElem$iv4 = e$iv3;
                                    maxValue$iv3 = v$iv3;
                                }
                                if (i$iv3 == lastIndex3) {
                                    break;
                                }
                                i$iv3++;
                            }
                        }
                    }
                    Placeable placeable3 = (Placeable) maxElem$iv4;
                    int fabWidth = placeable3 != null ? placeable3.getWidth() : 0;
                    List $this$fastMaxBy$iv4 = fabPlaceables;
                    if ($this$fastMaxBy$iv4.isEmpty()) {
                        maxElem$iv5 = null;
                    } else {
                        maxElem$iv5 = $this$fastMaxBy$iv4.get(0);
                        int maxValue$iv4 = ((Placeable) maxElem$iv5).getHeight();
                        int i$iv4 = 1;
                        int lastIndex4 = CollectionsKt.getLastIndex($this$fastMaxBy$iv4);
                        if (1 <= lastIndex4) {
                            while (true) {
                                Object e$iv4 = $this$fastMaxBy$iv4.get(i$iv4);
                                int v$iv4 = ((Placeable) e$iv4).getHeight();
                                if (maxValue$iv4 < v$iv4) {
                                    maxElem$iv5 = e$iv4;
                                    maxValue$iv4 = v$iv4;
                                }
                                if (i$iv4 == lastIndex4) {
                                    break;
                                }
                                i$iv4++;
                            }
                        }
                    }
                    Placeable placeable4 = (Placeable) maxElem$iv5;
                    int fabHeight = placeable4 != null ? placeable4.getHeight() : 0;
                    if (fabWidth == 0 || fabHeight == 0) {
                        fabPlacement = null;
                    } else {
                        if (!FabPosition.m1513equalsimpl0(i, FabPosition.Companion.m1518getEnd5ygKITE())) {
                            fabLeftOffset = (i3 - fabWidth) / 2;
                        } else if (subcomposeMeasureScope2.getLayoutDirection() == LayoutDirection.Ltr) {
                            fabLeftOffset = (i3 - subcomposeMeasureScope2.m5961roundToPx0680j_4(ScaffoldKt.FabSpacing)) - fabWidth;
                        } else {
                            fabLeftOffset = subcomposeMeasureScope2.m5961roundToPx0680j_4(ScaffoldKt.FabSpacing);
                        }
                        fabPlacement = new FabPlacement(z, fabLeftOffset, fabWidth, fabHeight);
                    }
                } else {
                    fabPlacement = null;
                }
                FabPlacement fabPlacement2 = fabPlacement;
                List subcompose3 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.BottomBar, ComposableLambdaKt.composableLambdaInstance(1529070963, true, new ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1(fabPlacement2, function24, i2)));
                long j4 = j;
                int $i$f$fastMap2 = 0;
                ArrayList target$iv4 = new ArrayList(subcompose3.size());
                List $this$fastForEach$iv$iv4 = subcompose3;
                int index$iv$iv4 = 0;
                List<Measurable> list = subcompose3;
                int size4 = $this$fastForEach$iv$iv4.size();
                while (index$iv$iv4 < size4) {
                    target$iv4.add(((Measurable) $this$fastForEach$iv$iv4.get(index$iv$iv4)).m4863measureBRTryo0(j4));
                    index$iv$iv4++;
                    size4 = size4;
                    $i$f$fastMap2 = $i$f$fastMap2;
                }
                List $this$fastMaxBy$iv5 = target$iv4;
                List bottomBarPlaceables = $this$fastMaxBy$iv5;
                if ($this$fastMaxBy$iv5.isEmpty()) {
                    maxElem$iv3 = null;
                } else {
                    maxElem$iv3 = $this$fastMaxBy$iv5.get(0);
                    int maxValue$iv5 = ((Placeable) maxElem$iv3).getHeight();
                    int i$iv5 = 1;
                    int lastIndex5 = CollectionsKt.getLastIndex($this$fastMaxBy$iv5);
                    if (1 <= lastIndex5) {
                        while (true) {
                            Object e$iv5 = $this$fastMaxBy$iv5.get(i$iv5);
                            int v$iv5 = ((Placeable) e$iv5).getHeight();
                            if (maxValue$iv5 < v$iv5) {
                                maxElem$iv3 = e$iv5;
                                maxValue$iv5 = v$iv5;
                            }
                            if (i$iv5 == lastIndex5) {
                                break;
                            }
                            i$iv5++;
                        }
                    }
                }
                Placeable placeable5 = (Placeable) maxElem$iv3;
                int bottomBarHeight = placeable5 != null ? placeable5.getHeight() : 0;
                if (fabPlacement2 != null) {
                    SubcomposeMeasureScope subcomposeMeasureScope = subcomposeMeasureScope2;
                    boolean z = z;
                    FabPlacement it = fabPlacement2;
                    if (bottomBarHeight == 0) {
                        i2 = it.getHeight() + subcomposeMeasureScope.m5961roundToPx0680j_4(ScaffoldKt.FabSpacing);
                    } else if (z) {
                        i2 = bottomBarHeight + (it.getHeight() / 2);
                    } else {
                        i2 = it.getHeight() + bottomBarHeight + subcomposeMeasureScope.m5961roundToPx0680j_4(ScaffoldKt.FabSpacing);
                    }
                    num = Integer.valueOf(i2);
                } else {
                    num = null;
                }
                Integer fabOffsetFromBottom = num;
                if (snackbarHeight != 0) {
                    i = snackbarHeight + (fabOffsetFromBottom != null ? fabOffsetFromBottom.intValue() : bottomBarHeight);
                } else {
                    i = 0;
                }
                int snackbarOffsetFromBottom = i;
                int bodyContentHeight = i4 - topBarHeight;
                List subcompose4 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.MainContent, ComposableLambdaKt.composableLambdaInstance(-1132241596, true, new ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1(subcomposeMeasureScope2, bottomBarHeight, function3, i2)));
                long j5 = j;
                ArrayList target$iv5 = new ArrayList(subcompose4.size());
                List $this$fastForEach$iv$iv5 = subcompose4;
                List<Measurable> list2 = subcompose4;
                int size5 = $this$fastForEach$iv$iv5.size();
                int index$iv$iv5 = 0;
                while (index$iv$iv5 < size5) {
                    target$iv5.add(((Measurable) $this$fastForEach$iv$iv5.get(index$iv$iv5)).m4863measureBRTryo0(Constraints.m5921copyZbe2FdA$default(j5, 0, 0, 0, bodyContentHeight, 7, (Object) null)));
                    index$iv$iv5++;
                    size5 = size5;
                    $this$fastForEach$iv$iv5 = $this$fastForEach$iv$iv5;
                    j5 = j5;
                }
                List $this$fastForEach$iv = target$iv5;
                int index$iv = 0;
                for (int size6 = $this$fastForEach$iv.size(); index$iv < size6; size6 = size6) {
                    Placeable.PlacementScope.place$default($this$layout, (Placeable) $this$fastForEach$iv.get(index$iv), 0, topBarHeight, 0.0f, 4, (Object) null);
                    index$iv++;
                    bottomBarHeight = bottomBarHeight;
                    $this$fastForEach$iv = $this$fastForEach$iv;
                }
                int i4 = index$iv;
                List list3 = $this$fastForEach$iv;
                int bottomBarHeight2 = bottomBarHeight;
                List $this$fastForEach$iv2 = topBarPlaceables;
                int size7 = $this$fastForEach$iv2.size();
                int index$iv2 = 0;
                while (index$iv2 < size7) {
                    Placeable.PlacementScope.place$default($this$layout, (Placeable) $this$fastForEach$iv2.get(index$iv2), 0, 0, 0.0f, 4, (Object) null);
                    index$iv2++;
                    size7 = size7;
                    $this$fastForEach$iv2 = $this$fastForEach$iv2;
                }
                int i5 = index$iv2;
                List list4 = $this$fastForEach$iv2;
                int i6 = i4;
                List $this$fastForEach$iv3 = snackbarPlaceables;
                int size8 = $this$fastForEach$iv3.size();
                int index$iv3 = 0;
                while (index$iv3 < size8) {
                    Placeable.PlacementScope.place$default($this$layout, (Placeable) $this$fastForEach$iv3.get(index$iv3), 0, i6 - snackbarOffsetFromBottom, 0.0f, 4, (Object) null);
                    index$iv3++;
                    size8 = size8;
                    $this$fastForEach$iv3 = $this$fastForEach$iv3;
                    i6 = i6;
                }
                int i7 = index$iv3;
                List list5 = $this$fastForEach$iv3;
                int i8 = i4;
                List $this$fastForEach$iv4 = bottomBarPlaceables;
                int size9 = $this$fastForEach$iv4.size();
                int index$iv4 = 0;
                while (index$iv4 < size9) {
                    Placeable.PlacementScope.place$default($this$layout, (Placeable) $this$fastForEach$iv4.get(index$iv4), 0, i8 - bottomBarHeight2, 0.0f, 4, (Object) null);
                    index$iv4++;
                    size9 = size9;
                    $this$fastForEach$iv4 = $this$fastForEach$iv4;
                    i8 = i8;
                }
                int i9 = index$iv4;
                List list6 = $this$fastForEach$iv4;
                int i10 = i4;
                List $this$fastForEach$iv5 = fabPlaceables;
                int size10 = $this$fastForEach$iv5.size();
                int index$iv5 = 0;
                while (index$iv5 < size10) {
                    Placeable.PlacementScope.place$default($this$layout, (Placeable) $this$fastForEach$iv5.get(index$iv5), fabPlacement2 != null ? fabPlacement2.getLeft() : 0, i10 - (fabOffsetFromBottom != null ? fabOffsetFromBottom.intValue() : 0), 0.0f, 4, (Object) null);
                    index$iv5++;
                    size10 = size10;
                    $this$fastForEach$iv5 = $this$fastForEach$iv5;
                    i10 = i10;
                }
            }
        }, 4, (Object) null);
    }
}
