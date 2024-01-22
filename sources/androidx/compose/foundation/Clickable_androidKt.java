package androidx.compose.foundation;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0001¢\u0006\u0002\u0010\u000f\u001a\f\u0010\u0010\u001a\u00020\u0005*\u00020\u0011H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0004\u001a\u00020\u0005*\u00020\u00068@X\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u001b\u0010\t\u001a\u00020\u0005*\u00020\u00068BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\n\u0010\b\"\u001b\u0010\u000b\u001a\u00020\u0005*\u00020\u00068@X\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\f\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"TapIndicationDelay", "", "getTapIndicationDelay", "()J", "isClick", "", "Landroidx/compose/ui/input/key/KeyEvent;", "isClick-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isEnter", "isEnter-ZmokQxo", "isPress", "isPress-ZmokQxo", "isComposeRootInScrollableContainer", "Lkotlin/Function0;", "(Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "isInScrollableViewGroup", "Landroid/view/View;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.android.kt */
public final class Clickable_androidKt {
    private static final long TapIndicationDelay = ((long) ViewConfiguration.getTapTimeout());

    public static final Function0<Boolean> isComposeRootInScrollableContainer(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1990508712);
        ComposerKt.sourceInformation($composer, "C(isComposeRootInScrollableContainer)35@1404L7:Clickable.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1990508712, $changed, -1, "androidx.compose.foundation.isComposeRootInScrollableContainer (Clickable.android.kt:34)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Function0<Boolean> clickable_androidKt$isComposeRootInScrollableContainer$1 = new Clickable_androidKt$isComposeRootInScrollableContainer$1((View) consume);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return clickable_androidKt$isComposeRootInScrollableContainer$1;
    }

    /* access modifiers changed from: private */
    public static final boolean isInScrollableViewGroup(View $this$isInScrollableViewGroup) {
        ViewParent p = $this$isInScrollableViewGroup.getParent();
        while (p != null && (p instanceof ViewGroup)) {
            if (((ViewGroup) p).shouldDelayChildPressedState()) {
                return true;
            }
            p = ((ViewGroup) p).getParent();
        }
        return false;
    }

    public static final long getTapIndicationDelay() {
        return TapIndicationDelay;
    }

    /* renamed from: isPress-ZmokQxo  reason: not valid java name */
    public static final boolean m490isPressZmokQxo(KeyEvent $this$isPress) {
        Intrinsics.checkNotNullParameter($this$isPress, "$this$isPress");
        return KeyEventType.m4517equalsimpl0(KeyEvent_androidKt.m4525getTypeZmokQxo($this$isPress), KeyEventType.Companion.m4521getKeyDownCS__XNY()) && m489isEnterZmokQxo($this$isPress);
    }

    /* renamed from: isClick-ZmokQxo  reason: not valid java name */
    public static final boolean m488isClickZmokQxo(KeyEvent $this$isClick) {
        Intrinsics.checkNotNullParameter($this$isClick, "$this$isClick");
        return KeyEventType.m4517equalsimpl0(KeyEvent_androidKt.m4525getTypeZmokQxo($this$isClick), KeyEventType.Companion.m4522getKeyUpCS__XNY()) && m489isEnterZmokQxo($this$isClick);
    }

    /* renamed from: isEnter-ZmokQxo  reason: not valid java name */
    private static final boolean m489isEnterZmokQxo(KeyEvent $this$isEnter) {
        switch (Key_androidKt.m4535getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m4524getKeyZmokQxo($this$isEnter))) {
            case 23:
            case 66:
            case 160:
                return true;
            default:
                return false;
        }
    }
}
