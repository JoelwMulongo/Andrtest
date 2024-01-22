package androidx.compose.ui.platform.accessibility;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.CollectionItemInfo;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0004\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\f\u0010\u000e\u001a\u00020\u0001*\u00020\u0007H\u0000\u001a\u0014\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010*\u00020\u0002H\u0002\u001a\u001c\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00130\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0016"}, d2 = {"isLazyCollection", "", "Landroidx/compose/ui/semantics/CollectionInfo;", "(Landroidx/compose/ui/semantics/CollectionInfo;)Z", "calculateIfHorizontallyStacked", "items", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "setCollectionInfo", "", "node", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "setCollectionItemInfo", "hasCollectionInfo", "toAccessibilityCollectionInfo", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$CollectionInfoCompat;", "kotlin.jvm.PlatformType", "toAccessibilityCollectionItemInfo", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$CollectionItemInfoCompat;", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "itemNode", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: CollectionInfo.kt */
public final class CollectionInfoKt {
    public static final void setCollectionInfo(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(info, "info");
        CollectionInfo collectionInfo = (CollectionInfo) SemanticsConfigurationKt.getOrNull(node.getConfig(), SemanticsProperties.INSTANCE.getCollectionInfo());
        if (collectionInfo != null) {
            info.setCollectionInfo(toAccessibilityCollectionInfo(collectionInfo));
            return;
        }
        List groupedChildren = new ArrayList();
        if (SemanticsConfigurationKt.getOrNull(node.getConfig(), SemanticsProperties.INSTANCE.getSelectableGroup()) != null) {
            List $this$fastForEach$iv = node.getReplacedChildren$ui_release();
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                SemanticsNode childNode = $this$fastForEach$iv.get(index$iv);
                if (childNode.getConfig().contains(SemanticsProperties.INSTANCE.getSelected())) {
                    groupedChildren.add(childNode);
                }
            }
        }
        int i = 1;
        if (!groupedChildren.isEmpty()) {
            boolean isHorizontal = calculateIfHorizontallyStacked(groupedChildren);
            int size2 = isHorizontal ? 1 : groupedChildren.size();
            if (isHorizontal) {
                i = groupedChildren.size();
            }
            info.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(size2, i, false, 0));
        }
    }

    public static final void setCollectionItemInfo(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(info, "info");
        CollectionItemInfo collectionItemInfo = (CollectionItemInfo) SemanticsConfigurationKt.getOrNull(node.getConfig(), SemanticsProperties.INSTANCE.getCollectionItemInfo());
        if (collectionItemInfo != null) {
            info.setCollectionItemInfo(toAccessibilityCollectionItemInfo(collectionItemInfo, node));
        }
        SemanticsNode parentNode = node.getParent();
        if (parentNode != null && SemanticsConfigurationKt.getOrNull(parentNode.getConfig(), SemanticsProperties.INSTANCE.getSelectableGroup()) != null) {
            CollectionInfo collectionInfo = (CollectionInfo) SemanticsConfigurationKt.getOrNull(parentNode.getConfig(), SemanticsProperties.INSTANCE.getCollectionInfo());
            if ((collectionInfo == null || !isLazyCollection(collectionInfo)) && node.getConfig().contains(SemanticsProperties.INSTANCE.getSelected())) {
                List groupedChildren = new ArrayList();
                int index = 0;
                List $this$fastForEach$iv = parentNode.getReplacedChildren$ui_release();
                int size = $this$fastForEach$iv.size();
                for (int index$iv = 0; index$iv < size; index$iv++) {
                    SemanticsNode childNode = $this$fastForEach$iv.get(index$iv);
                    if (childNode.getConfig().contains(SemanticsProperties.INSTANCE.getSelected())) {
                        groupedChildren.add(childNode);
                        if (childNode.getLayoutNode$ui_release().getPlaceOrder$ui_release() < node.getLayoutNode$ui_release().getPlaceOrder$ui_release()) {
                            index++;
                        }
                    }
                }
                if (!groupedChildren.isEmpty()) {
                    boolean isHorizontal = calculateIfHorizontallyStacked(groupedChildren);
                    AccessibilityNodeInfoCompat.CollectionItemInfoCompat itemInfo = AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(isHorizontal ? 0 : index, 1, isHorizontal ? index : 0, 1, false, ((Boolean) node.getConfig().getOrElse(SemanticsProperties.INSTANCE.getSelected(), CollectionInfoKt$setCollectionItemInfo$itemInfo$1.INSTANCE)).booleanValue());
                    if (itemInfo != null) {
                        info.setCollectionItemInfo(itemInfo);
                    }
                }
            }
        }
    }

    public static final boolean hasCollectionInfo(SemanticsNode $this$hasCollectionInfo) {
        Intrinsics.checkNotNullParameter($this$hasCollectionInfo, "<this>");
        return (SemanticsConfigurationKt.getOrNull($this$hasCollectionInfo.getConfig(), SemanticsProperties.INSTANCE.getCollectionInfo()) == null && SemanticsConfigurationKt.getOrNull($this$hasCollectionInfo.getConfig(), SemanticsProperties.INSTANCE.getSelectableGroup()) == null) ? false : true;
    }

    private static final boolean calculateIfHorizontallyStacked(List<SemanticsNode> items) {
        List result$iv;
        long j;
        if (items.size() < 2) {
            return true;
        }
        List $this$fastZipWithNext$iv = items;
        if ($this$fastZipWithNext$iv.size() == 0 || $this$fastZipWithNext$iv.size() == 1) {
            result$iv = CollectionsKt.emptyList();
        } else {
            result$iv = new ArrayList();
            Object current$iv = $this$fastZipWithNext$iv.get(0);
            int lastIndex = CollectionsKt.getLastIndex($this$fastZipWithNext$iv);
            for (int i$iv = 0; i$iv < lastIndex; i$iv++) {
                Object next$iv = $this$fastZipWithNext$iv.get(i$iv + 1);
                SemanticsNode el2 = (SemanticsNode) next$iv;
                SemanticsNode el1 = (SemanticsNode) current$iv;
                result$iv.add(Offset.m2904boximpl(OffsetKt.Offset(Math.abs(Offset.m2915getXimpl(el1.getBoundsInRoot().m2945getCenterF1C5BW0()) - Offset.m2915getXimpl(el2.getBoundsInRoot().m2945getCenterF1C5BW0())), Math.abs(Offset.m2916getYimpl(el1.getBoundsInRoot().m2945getCenterF1C5BW0()) - Offset.m2916getYimpl(el2.getBoundsInRoot().m2945getCenterF1C5BW0())))));
                current$iv = next$iv;
            }
        }
        List deltas = result$iv;
        if (deltas.size() == 1) {
            j = ((Offset) CollectionsKt.first(deltas)).m2925unboximpl();
        } else {
            List $this$fastReduce$iv = deltas;
            if (!$this$fastReduce$iv.isEmpty()) {
                Object accumulator$iv = CollectionsKt.first($this$fastReduce$iv);
                int i$iv2 = 1;
                int lastIndex2 = CollectionsKt.getLastIndex($this$fastReduce$iv);
                if (1 <= lastIndex2) {
                    while (true) {
                        accumulator$iv = Offset.m2904boximpl(Offset.m2920plusMKHz9U(((Offset) accumulator$iv).m2925unboximpl(), ((Offset) $this$fastReduce$iv.get(i$iv2)).m2925unboximpl()));
                        if (i$iv2 == lastIndex2) {
                            break;
                        }
                        i$iv2++;
                    }
                }
                j = ((Offset) accumulator$iv).m2925unboximpl();
            } else {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
        }
        if (Offset.m2906component2impl(j) < Offset.m2905component1impl(j)) {
            return true;
        }
        return false;
    }

    private static final boolean isLazyCollection(CollectionInfo $this$isLazyCollection) {
        return $this$isLazyCollection.getRowCount() < 0 || $this$isLazyCollection.getColumnCount() < 0;
    }

    private static final AccessibilityNodeInfoCompat.CollectionInfoCompat toAccessibilityCollectionInfo(CollectionInfo $this$toAccessibilityCollectionInfo) {
        return AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain($this$toAccessibilityCollectionInfo.getRowCount(), $this$toAccessibilityCollectionInfo.getColumnCount(), false, 0);
    }

    private static final AccessibilityNodeInfoCompat.CollectionItemInfoCompat toAccessibilityCollectionItemInfo(CollectionItemInfo $this$toAccessibilityCollectionItemInfo, SemanticsNode itemNode) {
        return AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain($this$toAccessibilityCollectionItemInfo.getRowIndex(), $this$toAccessibilityCollectionItemInfo.getRowSpan(), $this$toAccessibilityCollectionItemInfo.getColumnIndex(), $this$toAccessibilityCollectionItemInfo.getColumnSpan(), false, ((Boolean) itemNode.getConfig().getOrElse(SemanticsProperties.INSTANCE.getSelected(), CollectionInfoKt$toAccessibilityCollectionItemInfo$1.INSTANCE)).booleanValue());
    }
}
