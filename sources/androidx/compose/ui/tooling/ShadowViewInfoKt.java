package androidx.compose.ui.tooling;

import androidx.compose.ui.layout.LayoutInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"stitchTrees", "", "Landroidx/compose/ui/tooling/ViewInfo;", "allViewInfoRoots", "ui-tooling_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ShadowViewInfo.kt */
public final class ShadowViewInfoKt {
    public static final List<ViewInfo> stitchTrees(List<ViewInfo> allViewInfoRoots) {
        Object answer$iv$iv$iv;
        Intrinsics.checkNotNullParameter(allViewInfoRoots, "allViewInfoRoots");
        if (allViewInfoRoots.size() < 2) {
            return allViewInfoRoots;
        }
        Iterable<ViewInfo> $this$map$iv = allViewInfoRoots;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (ViewInfo it : $this$map$iv) {
            destination$iv$iv.add(new ShadowViewInfo(it));
        }
        List<ShadowViewInfo> shadowTreeRoots = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (ShadowViewInfo it2 : shadowTreeRoots) {
            CollectionsKt.addAll(destination$iv$iv2, it2.getAllNodes());
        }
        Iterable<ShadowViewInfo> $this$map$iv2 = (List) destination$iv$iv2;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (ShadowViewInfo it3 : $this$map$iv2) {
            destination$iv$iv3.add(TuplesKt.to(it3.getLayoutInfo(), it3));
        }
        Iterable $this$filter$iv = (List) destination$iv$iv3;
        Collection destination$iv$iv4 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (((Pair) element$iv$iv).getFirst() != null) {
                destination$iv$iv4.add(element$iv$iv);
            }
        }
        Iterable $this$groupBy$iv = (List) destination$iv$iv4;
        Map destination$iv$iv5 = new LinkedHashMap();
        for (Object element$iv$iv2 : $this$groupBy$iv) {
            Object key$iv$iv = (LayoutInfo) ((Pair) element$iv$iv2).getFirst();
            Map $this$getOrPut$iv$iv$iv = destination$iv$iv5;
            Object value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv);
            if (value$iv$iv$iv == null) {
                answer$iv$iv$iv = (List) new ArrayList();
                $this$getOrPut$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
            } else {
                answer$iv$iv$iv = value$iv$iv$iv;
            }
            ((List) answer$iv$iv$iv).add(element$iv$iv2);
        }
        Map shadowNodesWithLayoutInfo = destination$iv$iv5;
        LinkedHashSet currentRoots = new LinkedHashSet(shadowTreeRoots);
        for (ShadowViewInfo rootToAttach : shadowTreeRoots) {
            ShadowViewInfo nodeToAttachTo = (ShadowViewInfo) SequencesKt.firstOrNull(SequencesKt.map(SequencesKt.filter(SequencesKt.flatMapIterable(rootToAttach.getAllNodes(), new ShadowViewInfoKt$stitchTrees$1$1(shadowNodesWithLayoutInfo)), new ShadowViewInfoKt$stitchTrees$1$2(rootToAttach)), ShadowViewInfoKt$stitchTrees$1$3.INSTANCE));
            if (nodeToAttachTo != null) {
                rootToAttach.setNewParent(nodeToAttachTo);
                currentRoots.remove(rootToAttach);
            }
        }
        Iterable<ShadowViewInfo> $this$map$iv3 = currentRoots;
        Collection destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
        for (ShadowViewInfo it4 : $this$map$iv3) {
            destination$iv$iv6.add(it4.toViewInfo());
        }
        return (List) destination$iv$iv6;
    }
}
