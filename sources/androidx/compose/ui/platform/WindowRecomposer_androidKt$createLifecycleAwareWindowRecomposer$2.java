package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.PausableMonotonicFrameClock;
import androidx.compose.runtime.Recomposer;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/compose/ui/platform/WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowRecomposer.android.kt */
public final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 implements LifecycleEventObserver {
    final /* synthetic */ PausableMonotonicFrameClock $pausableClock;
    final /* synthetic */ Recomposer $recomposer;
    final /* synthetic */ CoroutineScope $runRecomposeScope;
    final /* synthetic */ Ref.ObjectRef<MotionDurationScaleImpl> $systemDurationScaleSettingConsumer;
    final /* synthetic */ View $this_createLifecycleAwareWindowRecomposer;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: WindowRecomposer.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2(CoroutineScope $runRecomposeScope2, PausableMonotonicFrameClock $pausableClock2, Recomposer $recomposer2, Ref.ObjectRef<MotionDurationScaleImpl> $systemDurationScaleSettingConsumer2, View $receiver) {
        this.$runRecomposeScope = $runRecomposeScope2;
        this.$pausableClock = $pausableClock2;
        this.$recomposer = $recomposer2;
        this.$systemDurationScaleSettingConsumer = $systemDurationScaleSettingConsumer2;
        this.$this_createLifecycleAwareWindowRecomposer = $receiver;
    }

    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        switch (WhenMappings.$EnumSwitchMapping$0[event.ordinal()]) {
            case 1:
                Job unused = BuildersKt__Builders_commonKt.launch$default(this.$runRecomposeScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(this.$systemDurationScaleSettingConsumer, this.$recomposer, source, this, this.$this_createLifecycleAwareWindowRecomposer, (Continuation<? super WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1>) null), 1, (Object) null);
                return;
            case 2:
                PausableMonotonicFrameClock pausableMonotonicFrameClock = this.$pausableClock;
                if (pausableMonotonicFrameClock != null) {
                    pausableMonotonicFrameClock.resume();
                    return;
                }
                return;
            case 3:
                PausableMonotonicFrameClock pausableMonotonicFrameClock2 = this.$pausableClock;
                if (pausableMonotonicFrameClock2 != null) {
                    pausableMonotonicFrameClock2.pause();
                    return;
                }
                return;
            case 4:
                this.$recomposer.cancel();
                return;
            default:
                return;
        }
    }
}
