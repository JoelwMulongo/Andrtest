package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.PausableMonotonicFrameClock;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.R;
import androidx.core.os.HandlerCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0017\u001a\u00020\u0002H\u0002\u001a\"\u0010\u0018\u001a\u00020\u0011*\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007\u001a\f\u0010\u001d\u001a\u0004\u0018\u00010\u0006*\u00020\b\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0004¢\u0006\u0002\n\u0000\",\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\"\u0018\u0010\r\u001a\u00020\b*\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u001e\u0010\u0010\u001a\u00020\u0011*\u00020\b8@X\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"animationScale", "", "Landroid/content/Context;", "Lkotlinx/coroutines/flow/StateFlow;", "", "value", "Landroidx/compose/runtime/CompositionContext;", "compositionContext", "Landroid/view/View;", "getCompositionContext", "(Landroid/view/View;)Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "(Landroid/view/View;Landroidx/compose/runtime/CompositionContext;)V", "contentChild", "getContentChild", "(Landroid/view/View;)Landroid/view/View;", "windowRecomposer", "Landroidx/compose/runtime/Recomposer;", "getWindowRecomposer$annotations", "(Landroid/view/View;)V", "getWindowRecomposer", "(Landroid/view/View;)Landroidx/compose/runtime/Recomposer;", "getAnimationScaleFlowFor", "applicationContext", "createLifecycleAwareWindowRecomposer", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "findViewTreeCompositionContext", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowRecomposer.android.kt */
public final class WindowRecomposer_androidKt {
    private static final Map<Context, StateFlow<Float>> animationScale = new LinkedHashMap();

    public static /* synthetic */ void getWindowRecomposer$annotations(View view) {
    }

    public static final CompositionContext getCompositionContext(View $this$compositionContext) {
        Intrinsics.checkNotNullParameter($this$compositionContext, "<this>");
        Object tag = $this$compositionContext.getTag(R.id.androidx_compose_ui_view_composition_context);
        if (tag instanceof CompositionContext) {
            return (CompositionContext) tag;
        }
        return null;
    }

    public static final void setCompositionContext(View $this$compositionContext, CompositionContext value) {
        Intrinsics.checkNotNullParameter($this$compositionContext, "<this>");
        $this$compositionContext.setTag(R.id.androidx_compose_ui_view_composition_context, value);
    }

    public static final CompositionContext findViewTreeCompositionContext(View $this$findViewTreeCompositionContext) {
        Intrinsics.checkNotNullParameter($this$findViewTreeCompositionContext, "<this>");
        CompositionContext found = getCompositionContext($this$findViewTreeCompositionContext);
        if (found != null) {
            return found;
        }
        ViewParent parent = $this$findViewTreeCompositionContext.getParent();
        while (found == null && (parent instanceof View)) {
            found = getCompositionContext((View) parent);
            parent = parent.getParent();
        }
        return found;
    }

    /* access modifiers changed from: private */
    public static final StateFlow<Float> getAnimationScaleFlowFor(Context applicationContext) {
        Object answer$iv;
        StateFlow<Float> stateFlow;
        Context context = applicationContext;
        synchronized (animationScale) {
            Map $this$getOrPut$iv = animationScale;
            Object value$iv = $this$getOrPut$iv.get(context);
            if (value$iv == null) {
                ContentResolver resolver = applicationContext.getContentResolver();
                Uri animationScaleUri = Settings.Global.getUriFor("animator_duration_scale");
                Channel channel = ChannelKt.Channel$default(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
                ContentResolver contentResolver = resolver;
                answer$iv = FlowKt.stateIn(FlowKt.flow(new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(resolver, animationScaleUri, new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1(channel, HandlerCompat.createAsync(Looper.getMainLooper())), channel, applicationContext, (Continuation<? super WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1>) null)), CoroutineScopeKt.MainScope(), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0, 0, 3, (Object) null), Float.valueOf(Settings.Global.getFloat(applicationContext.getContentResolver(), "animator_duration_scale", 1.0f)));
                $this$getOrPut$iv.put(context, answer$iv);
            } else {
                answer$iv = value$iv;
            }
            stateFlow = (StateFlow) answer$iv;
        }
        return stateFlow;
    }

    private static final View getContentChild(View $this$contentChild) {
        View self = $this$contentChild;
        ViewParent parent = self.getParent();
        while ((parent instanceof View) && ((View) parent).getId() != 16908290) {
            self = (View) parent;
            parent = self.getParent();
        }
        return self;
    }

    public static final Recomposer getWindowRecomposer(View $this$windowRecomposer) {
        Intrinsics.checkNotNullParameter($this$windowRecomposer, "<this>");
        if ($this$windowRecomposer.isAttachedToWindow()) {
            View rootView = getContentChild($this$windowRecomposer);
            CompositionContext rootParentRef = getCompositionContext(rootView);
            if (rootParentRef == null) {
                return WindowRecomposerPolicy.INSTANCE.createAndInstallWindowRecomposer$ui_release(rootView);
            }
            if (rootParentRef instanceof Recomposer) {
                return (Recomposer) rootParentRef;
            }
            throw new IllegalStateException("root viewTreeParentCompositionContext is not a Recomposer".toString());
        }
        throw new IllegalStateException(("Cannot locate windowRecomposer; View " + $this$windowRecomposer + " is not attached to a window").toString());
    }

    public static /* synthetic */ Recomposer createLifecycleAwareWindowRecomposer$default(View view, CoroutineContext coroutineContext, Lifecycle lifecycle, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            lifecycle = null;
        }
        return createLifecycleAwareWindowRecomposer(view, coroutineContext, lifecycle);
    }

    public static final Recomposer createLifecycleAwareWindowRecomposer(View $this$createLifecycleAwareWindowRecomposer, CoroutineContext coroutineContext, Lifecycle lifecycle) {
        CoroutineContext coroutineContext2;
        PausableMonotonicFrameClock $this$createLifecycleAwareWindowRecomposer_u24lambda_u244_u24lambda_u243;
        View view = $this$createLifecycleAwareWindowRecomposer;
        CoroutineContext coroutineContext3 = coroutineContext;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext3, "coroutineContext");
        if (coroutineContext3.get(ContinuationInterceptor.Key) == null || coroutineContext3.get(MonotonicFrameClock.Key) == null) {
            coroutineContext2 = AndroidUiDispatcher.Companion.getCurrentThread().plus(coroutineContext3);
        } else {
            coroutineContext2 = coroutineContext3;
        }
        CoroutineContext baseContext = coroutineContext2;
        MonotonicFrameClock it = (MonotonicFrameClock) baseContext.get(MonotonicFrameClock.Key);
        Lifecycle viewTreeLifecycle = null;
        if (it != null) {
            $this$createLifecycleAwareWindowRecomposer_u24lambda_u244_u24lambda_u243 = new PausableMonotonicFrameClock(it);
            $this$createLifecycleAwareWindowRecomposer_u24lambda_u244_u24lambda_u243.pause();
        } else {
            $this$createLifecycleAwareWindowRecomposer_u24lambda_u244_u24lambda_u243 = null;
        }
        PausableMonotonicFrameClock pausableClock = $this$createLifecycleAwareWindowRecomposer_u24lambda_u244_u24lambda_u243;
        Ref.ObjectRef systemDurationScaleSettingConsumer = new Ref.ObjectRef();
        MotionDurationScale motionDurationScale = (MotionDurationScale) baseContext.get(MotionDurationScale.Key);
        if (motionDurationScale == null) {
            MotionDurationScaleImpl it2 = new MotionDurationScaleImpl();
            systemDurationScaleSettingConsumer.element = it2;
            motionDurationScale = it2;
        }
        CoroutineContext contextWithClockAndMotionScale = baseContext.plus(pausableClock != null ? pausableClock : EmptyCoroutineContext.INSTANCE).plus(motionDurationScale);
        Recomposer recomposer = new Recomposer(contextWithClockAndMotionScale);
        CoroutineScope runRecomposeScope = CoroutineScopeKt.CoroutineScope(contextWithClockAndMotionScale);
        if (lifecycle == null) {
            LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get($this$createLifecycleAwareWindowRecomposer);
            if (lifecycleOwner != null) {
                viewTreeLifecycle = lifecycleOwner.getLifecycle();
            }
        } else {
            viewTreeLifecycle = lifecycle;
        }
        if (viewTreeLifecycle != null) {
            view.addOnAttachStateChangeListener(new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$1(view, recomposer));
            viewTreeLifecycle.addObserver(new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2(runRecomposeScope, pausableClock, recomposer, systemDurationScaleSettingConsumer, $this$createLifecycleAwareWindowRecomposer));
            return recomposer;
        }
        throw new IllegalStateException(("ViewTreeLifecycleOwner not found from " + view).toString());
    }
}
