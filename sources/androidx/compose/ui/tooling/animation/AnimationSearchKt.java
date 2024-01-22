package androidx.compose.ui.tooling.animation;

import androidx.compose.ui.tooling.PreviewUtilsKt;
import androidx.compose.ui.tooling.data.Group;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001e\n\u0000\u001a&\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0006\b\u0000\u0010\n\u0018\u0001*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\b¢\u0006\u0002\u0010\u000e\u001a!\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010\"\u0006\b\u0000\u0010\n\u0018\u0001*\b\u0012\u0004\u0012\u00020\u000b0\u0011H\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"ANIMATED_CONTENT", "", "ANIMATED_VISIBILITY", "ANIMATE_VALUE_AS_STATE", "REMEMBER", "REMEMBER_INFINITE_TRANSITION", "REMEMBER_UPDATED_STATE", "SIZE_ANIMATION_MODIFIER", "UPDATE_TRANSITION", "findData", "T", "Landroidx/compose/ui/tooling/data/Group;", "includeGrandchildren", "", "(Landroidx/compose/ui/tooling/data/Group;Z)Ljava/lang/Object;", "findRememberedData", "", "", "ui-tooling_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimationSearch.kt */
public final class AnimationSearchKt {
    private static final String ANIMATED_CONTENT = "AnimatedContent";
    private static final String ANIMATED_VISIBILITY = "AnimatedVisibility";
    private static final String ANIMATE_VALUE_AS_STATE = "animateValueAsState";
    private static final String REMEMBER = "remember";
    private static final String REMEMBER_INFINITE_TRANSITION = "rememberInfiniteTransition";
    private static final String REMEMBER_UPDATED_STATE = "rememberUpdatedState";
    private static final String SIZE_ANIMATION_MODIFIER = "androidx.compose.animation.SizeAnimationModifier";
    private static final String UPDATE_TRANSITION = "updateTransition";

    private static final /* synthetic */ <T> List<T> findRememberedData(Collection<? extends Group> $this$findRememberedData) {
        int $i$f$findRememberedData;
        Object element$iv;
        Object it$iv$iv;
        int $i$f$findRememberedData2 = 0;
        Collection destination$iv$iv = new ArrayList();
        for (Group it : $this$findRememberedData) {
            Iterator it2 = it.getData().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    it$iv$iv = null;
                    break;
                }
                Object element$iv2 = it2.next();
                Intrinsics.reifiedOperationMarker(3, "T");
                if (element$iv2 instanceof Object) {
                    it$iv$iv = element$iv2;
                    break;
                }
            }
            Intrinsics.reifiedOperationMarker(2, "T");
            Object obj = it$iv$iv;
            if (it$iv$iv != null) {
                destination$iv$iv.add(it$iv$iv);
            }
        }
        Iterable $this$mapNotNull$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (Group it3 : $this$findRememberedData) {
            Group it4 = PreviewUtilsKt.firstOrNull(it3, AnimationSearchKt$findRememberedData$rememberCalls$1$1.INSTANCE);
            if (it4 != null) {
                destination$iv$iv2.add(it4);
            }
        }
        Collection collection = (Collection) $this$mapNotNull$iv;
        Collection destination$iv$iv3 = new ArrayList();
        for (Group it5 : (List) destination$iv$iv2) {
            Iterator it6 = it5.getData().iterator();
            while (true) {
                if (!it6.hasNext()) {
                    $i$f$findRememberedData = $i$f$findRememberedData2;
                    element$iv = null;
                    break;
                }
                element$iv = it6.next();
                $i$f$findRememberedData = $i$f$findRememberedData2;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (element$iv instanceof Object) {
                    break;
                }
                $i$f$findRememberedData2 = $i$f$findRememberedData;
            }
            Intrinsics.reifiedOperationMarker(2, "T");
            Object obj2 = element$iv;
            if (element$iv != null) {
                destination$iv$iv3.add(element$iv);
            }
            $i$f$findRememberedData2 = $i$f$findRememberedData;
        }
        return CollectionsKt.plus(collection, (List) destination$iv$iv3);
    }

    static /* synthetic */ Object findData$default(Group $this$findData_u24default, boolean includeGrandchildren, int i, Object obj) {
        Object element$iv;
        if ((i & 1) != 0) {
            includeGrandchildren = false;
        }
        Collection<Object> data = $this$findData_u24default.getData();
        Collection<Group> it = $this$findData_u24default.getChildren();
        if (includeGrandchildren) {
            Collection destination$iv$iv = new ArrayList();
            for (Group child : it) {
                CollectionsKt.addAll(destination$iv$iv, child.getChildren());
            }
            it = CollectionsKt.plus(it, (List) destination$iv$iv);
        }
        Collection destination$iv$iv2 = new ArrayList();
        for (Group it2 : it) {
            CollectionsKt.addAll(destination$iv$iv2, it2.getData());
        }
        Iterator it3 = CollectionsKt.plus(data, (List) destination$iv$iv2).iterator();
        while (true) {
            if (!it3.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it3.next();
            Intrinsics.reifiedOperationMarker(3, "T");
            if (element$iv instanceof Object) {
                break;
            }
        }
        Intrinsics.reifiedOperationMarker(2, "T");
        Object obj2 = element$iv;
        return element$iv;
    }

    private static final /* synthetic */ <T> T findData(Group $this$findData, boolean includeGrandchildren) {
        Object element$iv;
        Collection<Object> data = $this$findData.getData();
        Collection<Group> it = $this$findData.getChildren();
        if (includeGrandchildren) {
            Collection destination$iv$iv = new ArrayList();
            for (Group child : it) {
                CollectionsKt.addAll(destination$iv$iv, child.getChildren());
            }
            it = CollectionsKt.plus(it, (List) destination$iv$iv);
        }
        Collection destination$iv$iv2 = new ArrayList();
        for (Group it2 : it) {
            CollectionsKt.addAll(destination$iv$iv2, it2.getData());
        }
        Iterator it3 = CollectionsKt.plus(data, (List) destination$iv$iv2).iterator();
        while (true) {
            if (!it3.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it3.next();
            Intrinsics.reifiedOperationMarker(3, "T");
            if (element$iv instanceof Object) {
                break;
            }
        }
        Intrinsics.reifiedOperationMarker(2, "T");
        Object obj = element$iv;
        return element$iv;
    }
}
