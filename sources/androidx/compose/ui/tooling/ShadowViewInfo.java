package androidx.compose.ui.tooling;

import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.tooling.data.SourceLocation;
import androidx.compose.ui.unit.IntRect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0019\u001a\u00020\u0000J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0000J\u0006\u0010\u001c\u001a\u00020\u0003R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/tooling/ShadowViewInfo;", "", "viewInfo", "Landroidx/compose/ui/tooling/ViewInfo;", "(Landroidx/compose/ui/tooling/ViewInfo;)V", "parent", "(Landroidx/compose/ui/tooling/ShadowViewInfo;Landroidx/compose/ui/tooling/ViewInfo;)V", "_children", "", "allNodes", "Lkotlin/sequences/Sequence;", "getAllNodes", "()Lkotlin/sequences/Sequence;", "children", "", "getChildren", "()Ljava/util/List;", "layoutInfo", "Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "getParent", "()Landroidx/compose/ui/tooling/ShadowViewInfo;", "setParent", "(Landroidx/compose/ui/tooling/ShadowViewInfo;)V", "findRoot", "setNewParent", "", "toViewInfo", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ShadowViewInfo.kt */
final class ShadowViewInfo {
    private final List<ShadowViewInfo> _children;
    private final Sequence<ShadowViewInfo> allNodes;
    private ShadowViewInfo parent;
    private final ViewInfo viewInfo;

    private ShadowViewInfo(ShadowViewInfo parent2, ViewInfo viewInfo2) {
        this.parent = parent2;
        this.viewInfo = viewInfo2;
        Iterable<ViewInfo> $this$map$iv = viewInfo2.getChildren();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (ViewInfo it : $this$map$iv) {
            destination$iv$iv.add(new ShadowViewInfo(this, it));
        }
        this._children = CollectionsKt.toMutableList((List) destination$iv$iv);
        this.allNodes = SequencesKt.sequence(new ShadowViewInfo$allNodes$1(this, (Continuation<? super ShadowViewInfo$allNodes$1>) null));
    }

    public final ShadowViewInfo getParent() {
        return this.parent;
    }

    public final void setParent(ShadowViewInfo shadowViewInfo) {
        this.parent = shadowViewInfo;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShadowViewInfo(ViewInfo viewInfo2) {
        this((ShadowViewInfo) null, viewInfo2);
        Intrinsics.checkNotNullParameter(viewInfo2, "viewInfo");
    }

    public final List<ShadowViewInfo> getChildren() {
        return this._children;
    }

    public final LayoutInfo getLayoutInfo() {
        Object layoutInfo = this.viewInfo.getLayoutInfo();
        if (layoutInfo instanceof LayoutInfo) {
            return (LayoutInfo) layoutInfo;
        }
        return null;
    }

    public final Sequence<ShadowViewInfo> getAllNodes() {
        return this.allNodes;
    }

    public final void setNewParent(ShadowViewInfo parent2) {
        List<ShadowViewInfo> list;
        Intrinsics.checkNotNullParameter(parent2, "parent");
        ShadowViewInfo shadowViewInfo = this.parent;
        if (!(shadowViewInfo == null || (list = shadowViewInfo._children) == null)) {
            list.remove(this);
        }
        parent2._children.add(this);
        this.parent = parent2;
    }

    public final ShadowViewInfo findRoot() {
        ShadowViewInfo shadowViewInfo = this.parent;
        if (shadowViewInfo == null) {
            return this;
        }
        Intrinsics.checkNotNull(shadowViewInfo);
        return shadowViewInfo.findRoot();
    }

    public final ViewInfo toViewInfo() {
        String fileName = this.viewInfo.getFileName();
        int lineNumber = this.viewInfo.getLineNumber();
        IntRect bounds = this.viewInfo.getBounds();
        SourceLocation location = this.viewInfo.getLocation();
        Iterable<ShadowViewInfo> $this$map$iv = this._children;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (ShadowViewInfo it : $this$map$iv) {
            destination$iv$iv.add(it.toViewInfo());
        }
        return new ViewInfo(fileName, lineNumber, bounds, location, (List) destination$iv$iv, this.viewInfo.getLayoutInfo());
    }
}
