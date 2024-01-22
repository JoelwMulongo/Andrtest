package androidx.compose.ui.tooling;

import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"androidx/compose/ui/tooling/ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1", "Landroidx/activity/OnBackPressedDispatcherOwner;", "lifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycle", "()Landroidx/lifecycle/LifecycleRegistry;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "getOnBackPressedDispatcher", "()Landroidx/activity/OnBackPressedDispatcher;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposeViewAdapter.kt */
public final class ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1 implements OnBackPressedDispatcherOwner {
    private final OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher((Runnable) null, 1, (DefaultConstructorMarker) null);
    final /* synthetic */ ComposeViewAdapter this$0;

    ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1(ComposeViewAdapter $receiver) {
        this.this$0 = $receiver;
    }

    public OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    public LifecycleRegistry getLifecycle() {
        return this.this$0.FakeSavedStateRegistryOwner.getLifecycleRegistry();
    }
}
