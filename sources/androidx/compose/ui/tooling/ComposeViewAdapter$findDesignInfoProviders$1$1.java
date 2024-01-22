package androidx.compose.ui.tooling;

import androidx.compose.ui.tooling.data.Group;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "group", "Landroidx/compose/ui/tooling/data/Group;", "invoke", "(Landroidx/compose/ui/tooling/data/Group;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposeViewAdapter.kt */
final class ComposeViewAdapter$findDesignInfoProviders$1$1 extends Lambda implements Function1<Group, Boolean> {
    final /* synthetic */ ComposeViewAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComposeViewAdapter$findDesignInfoProviders$1$1(ComposeViewAdapter composeViewAdapter) {
        super(1);
        this.this$0 = composeViewAdapter;
    }

    public final Boolean invoke(Group group) {
        Iterable $this$any$iv;
        Group child;
        Intrinsics.checkNotNullParameter(group, "group");
        boolean z = true;
        if (Intrinsics.areEqual((Object) group.getName(), (Object) "remember") || !this.this$0.hasDesignInfo(group)) {
            Iterable $this$any$iv2 = group.getChildren();
            ComposeViewAdapter composeViewAdapter = this.this$0;
            if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                Iterator it = $this$any$iv2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        $this$any$iv = null;
                        break;
                    }
                    Group child2 = (Group) it.next();
                    if (!Intrinsics.areEqual((Object) child2.getName(), (Object) "remember") || !composeViewAdapter.hasDesignInfo(child2)) {
                        child = null;
                        continue;
                    } else {
                        child = 1;
                        continue;
                    }
                    if (child != null) {
                        $this$any$iv = 1;
                        break;
                    }
                }
            } else {
                $this$any$iv = null;
            }
            if ($this$any$iv == null) {
                z = false;
            }
        }
        return Boolean.valueOf(z);
    }
}
