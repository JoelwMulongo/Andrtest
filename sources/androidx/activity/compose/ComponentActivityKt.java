package androidx.activity.compose;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\b\t¢\u0006\u0002\u0010\n\u001a\f\u0010\u000b\u001a\u00020\u0003*\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"DefaultActivityContentLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "setContent", "", "Landroidx/activity/ComponentActivity;", "parent", "Landroidx/compose/runtime/CompositionContext;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/activity/ComponentActivity;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setOwners", "activity-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComponentActivity.kt */
public final class ComponentActivityKt {
    private static final ViewGroup.LayoutParams DefaultActivityContentLayoutParams = new ViewGroup.LayoutParams(-2, -2);

    public static /* synthetic */ void setContent$default(ComponentActivity componentActivity, CompositionContext compositionContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            compositionContext = null;
        }
        setContent(componentActivity, compositionContext, function2);
    }

    public static final void setContent(ComponentActivity $this$setContent, CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter($this$setContent, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        View childAt = ((ViewGroup) $this$setContent.getWindow().getDecorView().findViewById(16908290)).getChildAt(0);
        ComposeView existingComposeView = childAt instanceof ComposeView ? (ComposeView) childAt : null;
        if (existingComposeView != null) {
            ComposeView $this$setContent_u24lambda_u240 = existingComposeView;
            $this$setContent_u24lambda_u240.setParentCompositionContext(parent);
            $this$setContent_u24lambda_u240.setContent(content);
            return;
        }
        ComposeView composeView = new ComposeView($this$setContent, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        composeView.setParentCompositionContext(parent);
        composeView.setContent(content);
        setOwners($this$setContent);
        $this$setContent.setContentView(composeView, DefaultActivityContentLayoutParams);
    }

    private static final void setOwners(ComponentActivity $this$setOwners) {
        View decorView = $this$setOwners.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        if (ViewTreeLifecycleOwner.get(decorView) == null) {
            ViewTreeLifecycleOwner.set(decorView, $this$setOwners);
        }
        if (ViewTreeViewModelStoreOwner.get(decorView) == null) {
            ViewTreeViewModelStoreOwner.set(decorView, $this$setOwners);
        }
        if (ViewTreeSavedStateRegistryOwner.get(decorView) == null) {
            ViewTreeSavedStateRegistryOwner.set(decorView, $this$setOwners);
        }
    }
}
