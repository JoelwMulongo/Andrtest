package androidx.compose.foundation.layout;

import android.graphics.Insets;
import android.os.CancellationSignal;
import android.view.View;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020!H\u0002J\u0006\u0010$\u001a\u00020!J1\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0017H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001a\u0004\u0018\u00010\rH@ø\u0001\u0001¢\u0006\u0002\u0010-J\u0012\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u00100\u001a\u00020!2\u0006\u0010/\u001a\u00020\rH\u0016J)\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u0010'\u001a\u00020&H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b3\u00104J-\u00105\u001a\u0002062\u0006\u00102\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:J!\u0010;\u001a\u00020&2\u0006\u0010'\u001a\u00020&H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b<\u0010=J%\u0010>\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010@J\u0018\u0010A\u001a\u00020!2\u0006\u0010/\u001a\u00020\r2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020!H\u0002J%\u0010E\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u0010F\u001a\u00020\u0019H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010HR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006I"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroid/view/WindowInsetsAnimationControlListener;", "windowInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "view", "Landroid/view/View;", "sideCalculator", "Landroidx/compose/foundation/layout/SideCalculator;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/layout/AndroidWindowInsets;Landroid/view/View;Landroidx/compose/foundation/layout/SideCalculator;Landroidx/compose/ui/unit/Density;)V", "animationController", "Landroid/view/WindowInsetsAnimationController;", "animationJob", "Lkotlinx/coroutines/Job;", "cancellationSignal", "Landroid/os/CancellationSignal;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "isControllerRequested", "", "partialConsumption", "", "getSideCalculator", "()Landroidx/compose/foundation/layout/SideCalculator;", "getView", "()Landroid/view/View;", "getWindowInsets", "()Landroidx/compose/foundation/layout/AndroidWindowInsets;", "adjustInsets", "", "inset", "animationEnded", "dispose", "fling", "Landroidx/compose/ui/unit/Velocity;", "available", "flingAmount", "towardShown", "fling-huYlsQE", "(JFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnimationController", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCancelled", "controller", "onFinished", "onPostFling", "consumed", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "onReady", "types", "", "requestAnimationController", "scroll", "scrollAmount", "scroll-8S9VItk", "(JF)J", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsetsConnection.android.kt */
final class WindowInsetsNestedScrollConnection implements NestedScrollConnection, WindowInsetsAnimationControlListener {
    /* access modifiers changed from: private */
    public WindowInsetsAnimationController animationController;
    /* access modifiers changed from: private */
    public Job animationJob;
    private final CancellationSignal cancellationSignal = new CancellationSignal();
    /* access modifiers changed from: private */
    public CancellableContinuation<? super WindowInsetsAnimationController> continuation;
    private final Density density;
    private boolean isControllerRequested;
    private float partialConsumption;
    private final SideCalculator sideCalculator;
    private final View view;
    private final AndroidWindowInsets windowInsets;

    public WindowInsetsNestedScrollConnection(AndroidWindowInsets windowInsets2, View view2, SideCalculator sideCalculator2, Density density2) {
        Intrinsics.checkNotNullParameter(windowInsets2, "windowInsets");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(sideCalculator2, "sideCalculator");
        Intrinsics.checkNotNullParameter(density2, "density");
        this.windowInsets = windowInsets2;
        this.view = view2;
        this.sideCalculator = sideCalculator2;
        this.density = density2;
    }

    public final AndroidWindowInsets getWindowInsets() {
        return this.windowInsets;
    }

    public final View getView() {
        return this.view;
    }

    public final SideCalculator getSideCalculator() {
        return this.sideCalculator;
    }

    public final Density getDensity() {
        return this.density;
    }

    /* access modifiers changed from: private */
    public final void requestAnimationController() {
        if (!this.isControllerRequested) {
            this.isControllerRequested = true;
            WindowInsetsController windowInsetsController = this.view.getWindowInsetsController();
            if (windowInsetsController != null) {
                windowInsetsController.controlWindowInsetsAnimation(this.windowInsets.getType$foundation_layout_release(), -1, (Interpolator) null, this.cancellationSignal, (WindowInsetsAnimationControlListener) this);
            }
        }
    }

    /* access modifiers changed from: private */
    public final Object getAnimationController(Continuation<? super WindowInsetsAnimationController> $completion) {
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (windowInsetsAnimationController != null) {
            return windowInsetsAnimationController;
        }
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellable$iv.initCancellability();
        this.continuation = cancellable$iv;
        requestAnimationController();
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return result;
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m857onPreScrollOzD1aCk(long available, int source) {
        return m853scroll8S9VItk(available, this.sideCalculator.hideMotion(Offset.m2915getXimpl(available), Offset.m2916getYimpl(available)));
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m855onPostScrollDzOQY0M(long consumed, long available, int source) {
        return m853scroll8S9VItk(available, this.sideCalculator.showMotion(Offset.m2915getXimpl(available), Offset.m2916getYimpl(available)));
    }

    /* renamed from: scroll-8S9VItk  reason: not valid java name */
    private final long m853scroll8S9VItk(long available, float scrollAmount) {
        Job it = this.animationJob;
        boolean z = true;
        if (it != null) {
            Job.DefaultImpls.cancel$default(it, (CancellationException) null, 1, (Object) null);
            this.animationJob = null;
        }
        WindowInsetsAnimationController animationController2 = this.animationController;
        if (!(scrollAmount == 0.0f)) {
            boolean isVisible = this.windowInsets.isVisible();
            if (scrollAmount <= 0.0f) {
                z = false;
            }
            if (!(isVisible == z && animationController2 == null)) {
                if (animationController2 == null) {
                    this.partialConsumption = 0.0f;
                    requestAnimationController();
                    return this.sideCalculator.m803consumedOffsetsMKHz9U(available);
                }
                SideCalculator sideCalculator2 = this.sideCalculator;
                Insets hiddenStateInsets = animationController2.getHiddenStateInsets();
                Intrinsics.checkNotNullExpressionValue(hiddenStateInsets, "animationController.hiddenStateInsets");
                int hidden = sideCalculator2.valueOf(hiddenStateInsets);
                SideCalculator sideCalculator3 = this.sideCalculator;
                Insets shownStateInsets = animationController2.getShownStateInsets();
                Intrinsics.checkNotNullExpressionValue(shownStateInsets, "animationController.shownStateInsets");
                int shown = sideCalculator3.valueOf(shownStateInsets);
                Insets currentInsets = animationController2.getCurrentInsets();
                Intrinsics.checkNotNullExpressionValue(currentInsets, "animationController.currentInsets");
                int current = this.sideCalculator.valueOf(currentInsets);
                if (current == (scrollAmount > 0.0f ? shown : hidden)) {
                    this.partialConsumption = 0.0f;
                    return Offset.Companion.m2931getZeroF1C5BW0();
                }
                float total = ((float) current) + scrollAmount + this.partialConsumption;
                int next = RangesKt.coerceIn(MathKt.roundToInt(total), hidden, shown);
                this.partialConsumption = total - ((float) MathKt.roundToInt(total));
                if (next != current) {
                    animationController2.setInsetsAndAlpha(this.sideCalculator.adjustInsets(currentInsets, next), 1.0f, 0.0f);
                }
                return this.sideCalculator.m803consumedOffsetsMKHz9U(available);
            }
        }
        return Offset.Companion.m2931getZeroF1C5BW0();
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public Object m856onPreFlingQWom1Mo(long available, Continuation<? super Velocity> $completion) {
        return m852flinghuYlsQE(available, this.sideCalculator.hideMotion(Velocity.m6211getXimpl(available), Velocity.m6212getYimpl(available)), false, $completion);
    }

    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public Object m854onPostFlingRZ2iAVY(long consumed, long available, Continuation<? super Velocity> $completion) {
        return m852flinghuYlsQE(available, this.sideCalculator.showMotion(Velocity.m6211getXimpl(available), Velocity.m6212getYimpl(available)), true, $completion);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* renamed from: fling-huYlsQE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m852flinghuYlsQE(long r27, float r29, boolean r30, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r31) {
        /*
            r26 = this;
            r0 = r31
            boolean r1 = r0 instanceof androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1
            if (r1 == 0) goto L_0x0019
            r1 = r0
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1 r1 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0019
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r26
            goto L_0x0021
        L_0x0019:
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1 r1 = new androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1
            r2 = r26
            r1.<init>(r2, r0)
            r0 = r1
        L_0x0021:
            java.lang.Object r1 = r0.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r0.label
            r5 = 0
            r7 = 0
            r8 = 1
            switch(r4) {
                case 0: goto L_0x0063;
                case 1: goto L_0x0051;
                case 2: goto L_0x0042;
                case 3: goto L_0x0037;
                default: goto L_0x002f;
            }
        L_0x002f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0037:
            long r3 = r0.J$0
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r5 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection) r5
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0169
        L_0x0042:
            long r3 = r0.J$0
            java.lang.Object r5 = r0.L$1
            kotlin.jvm.internal.Ref$FloatRef r5 = (kotlin.jvm.internal.Ref.FloatRef) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r6 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection) r6
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x01b3
        L_0x0051:
            float r4 = r0.F$0
            long r9 = r0.J$0
            java.lang.Object r11 = r0.L$0
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r11 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection) r11
            kotlin.ResultKt.throwOnFailure(r1)
            r12 = r1
            r24 = r9
            r9 = r11
            r10 = r24
            goto L_0x00b0
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            r4 = r26
            r9 = r30
            r10 = r27
            r12 = r29
            kotlinx.coroutines.Job r13 = r4.animationJob
            if (r13 == 0) goto L_0x0075
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r13, (java.util.concurrent.CancellationException) r5, (int) r8, (java.lang.Object) r5)
        L_0x0075:
            r4.animationJob = r5
            r4.partialConsumption = r7
            int r13 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r13 != 0) goto L_0x007f
            r13 = r8
            goto L_0x0080
        L_0x007f:
            r13 = 0
        L_0x0080:
            if (r13 == 0) goto L_0x0084
            if (r9 == 0) goto L_0x0090
        L_0x0084:
            android.view.WindowInsetsAnimationController r13 = r4.animationController
            if (r13 != 0) goto L_0x009b
            androidx.compose.foundation.layout.AndroidWindowInsets r13 = r4.windowInsets
            boolean r13 = r13.isVisible()
            if (r13 != r9) goto L_0x009b
        L_0x0090:
            androidx.compose.ui.unit.Velocity$Companion r3 = androidx.compose.ui.unit.Velocity.Companion
            long r3 = r3.m6222getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r3 = androidx.compose.ui.unit.Velocity.m6202boximpl(r3)
            return r3
        L_0x009b:
            r0.L$0 = r4
            r0.J$0 = r10
            r0.F$0 = r12
            r0.label = r8
            java.lang.Object r9 = r4.getAnimationController(r0)
            if (r9 != r3) goto L_0x00aa
            return r3
        L_0x00aa:
            r24 = r9
            r9 = r4
            r4 = r12
            r12 = r24
        L_0x00b0:
            android.view.WindowInsetsAnimationController r12 = (android.view.WindowInsetsAnimationController) r12
            if (r12 != 0) goto L_0x00bf
            androidx.compose.ui.unit.Velocity$Companion r3 = androidx.compose.ui.unit.Velocity.Companion
            long r3 = r3.m6222getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r3 = androidx.compose.ui.unit.Velocity.m6202boximpl(r3)
            return r3
        L_0x00bf:
            r14 = r12
            androidx.compose.foundation.layout.SideCalculator r12 = r9.sideCalculator
            android.graphics.Insets r13 = r14.getHiddenStateInsets()
            java.lang.String r15 = "animationController.hiddenStateInsets"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r15)
            int r13 = r12.valueOf(r13)
            androidx.compose.foundation.layout.SideCalculator r12 = r9.sideCalculator
            android.graphics.Insets r15 = r14.getShownStateInsets()
            java.lang.String r6 = "animationController.shownStateInsets"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r6)
            int r6 = r12.valueOf(r15)
            android.graphics.Insets r12 = r14.getCurrentInsets()
            java.lang.String r15 = "animationController.currentInsets"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r15)
            androidx.compose.foundation.layout.SideCalculator r15 = r9.sideCalculator
            int r12 = r15.valueOf(r12)
            int r15 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r15 > 0) goto L_0x00f3
            if (r12 == r13) goto L_0x00f9
        L_0x00f3:
            int r15 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r15 < 0) goto L_0x010e
            if (r12 != r6) goto L_0x010e
        L_0x00f9:
            if (r12 != r6) goto L_0x00fd
            r6 = r8
            goto L_0x00fe
        L_0x00fd:
            r6 = 0
        L_0x00fe:
            r14.finish(r6)
            r9.animationController = r5
            androidx.compose.ui.unit.Velocity$Companion r3 = androidx.compose.ui.unit.Velocity.Companion
            long r3 = r3.m6222getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r3 = androidx.compose.ui.unit.Velocity.m6202boximpl(r3)
            return r3
        L_0x010e:
            androidx.compose.foundation.layout.SplineBasedFloatDecayAnimationSpec r5 = new androidx.compose.foundation.layout.SplineBasedFloatDecayAnimationSpec
            androidx.compose.ui.unit.Density r15 = r9.density
            r5.<init>(r15)
            float r15 = (float) r12
            float r16 = r5.flingDistance(r4)
            float r16 = r15 + r16
            float r15 = (float) r13
            float r15 = r16 - r15
            int r8 = r6 - r13
            float r8 = (float) r8
            float r15 = r15 / r8
            r8 = 1056964608(0x3f000000, float:0.5)
            int r8 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x012b
            r8 = 1
            goto L_0x012c
        L_0x012b:
            r8 = 0
        L_0x012c:
            if (r8 == 0) goto L_0x0130
            r15 = r6
            goto L_0x0131
        L_0x0130:
            r15 = r13
        L_0x0131:
            float r7 = (float) r6
            int r7 = (r16 > r7 ? 1 : (r16 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x0175
            float r7 = (float) r13
            int r7 = (r16 > r7 ? 1 : (r16 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x013f
            r7 = r12
            r21 = r14
            goto L_0x0178
        L_0x013f:
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$3 r5 = new androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$3
            if (r8 == 0) goto L_0x0146
            r18 = 1
            goto L_0x0148
        L_0x0146:
            r18 = 0
        L_0x0148:
            r19 = 0
            r7 = r12
            r12 = r5
            r13 = r9
            r21 = r14
            r14 = r7
            r16 = r4
            r17 = r21
            r12.<init>(r13, r14, r15, r16, r17, r18, r19)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r0.L$0 = r9
            r0.J$0 = r10
            r4 = 3
            r0.label = r4
            java.lang.Object r4 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r5, r0)
            if (r4 != r3) goto L_0x0167
            return r3
        L_0x0167:
            r5 = r9
            r3 = r10
        L_0x0169:
            androidx.compose.foundation.layout.SideCalculator r6 = r5.sideCalculator
            r7 = 0
            long r6 = r6.m804consumedVelocityQWom1Mo(r3, r7)
            androidx.compose.ui.unit.Velocity r6 = androidx.compose.ui.unit.Velocity.m6202boximpl(r6)
            return r6
        L_0x0175:
            r7 = r12
            r21 = r14
        L_0x0178:
            kotlin.jvm.internal.Ref$FloatRef r12 = new kotlin.jvm.internal.Ref$FloatRef
            r12.<init>()
            r15 = r12
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2 r23 = new androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2
            if (r8 == 0) goto L_0x0184
            r8 = 1
            goto L_0x0185
        L_0x0184:
            r8 = 0
        L_0x0185:
            r22 = 0
            r12 = r23
            r17 = r13
            r13 = r9
            r14 = r7
            r7 = r15
            r15 = r4
            r16 = r5
            r18 = r6
            r19 = r7
            r20 = r21
            r21 = r8
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r4 = r23
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r9
            r0.L$1 = r7
            r0.J$0 = r10
            r5 = 2
            r0.label = r5
            java.lang.Object r4 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r4, r0)
            if (r4 != r3) goto L_0x01b0
            return r3
        L_0x01b0:
            r5 = r7
            r6 = r9
            r3 = r10
        L_0x01b3:
            androidx.compose.foundation.layout.SideCalculator r7 = r6.sideCalculator
            float r8 = r5.element
            long r7 = r7.m804consumedVelocityQWom1Mo(r3, r8)
            androidx.compose.ui.unit.Velocity r7 = androidx.compose.ui.unit.Velocity.m6202boximpl(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.m852flinghuYlsQE(long, float, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void adjustInsets(float inset) {
        WindowInsetsAnimationController it = this.animationController;
        if (it != null) {
            Insets currentInsets = it.getCurrentInsets();
            Intrinsics.checkNotNullExpressionValue(currentInsets, "it.currentInsets");
            it.setInsetsAndAlpha(this.sideCalculator.adjustInsets(currentInsets, MathKt.roundToInt(inset)), 1.0f, 0.0f);
        }
    }

    public void onReady(WindowInsetsAnimationController controller, int types) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.animationController = controller;
        this.isControllerRequested = false;
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume(controller, WindowInsetsNestedScrollConnection$onReady$1.INSTANCE);
        }
        this.continuation = null;
    }

    public final void dispose() {
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume(null, WindowInsetsNestedScrollConnection$dispose$1.INSTANCE);
        }
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        WindowInsetsAnimationController animationController2 = this.animationController;
        if (animationController2 != null) {
            animationController2.finish(!Intrinsics.areEqual((Object) animationController2.getCurrentInsets(), (Object) animationController2.getHiddenStateInsets()));
        }
    }

    public void onFinished(WindowInsetsAnimationController controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        animationEnded();
    }

    public void onCancelled(WindowInsetsAnimationController controller) {
        animationEnded();
    }

    private final void animationEnded() {
        WindowInsetsAnimationController windowInsetsAnimationController;
        WindowInsetsAnimationController windowInsetsAnimationController2 = this.animationController;
        if ((windowInsetsAnimationController2 != null && windowInsetsAnimationController2.isReady()) && (windowInsetsAnimationController = this.animationController) != null) {
            windowInsetsAnimationController.finish(this.windowInsets.isVisible());
        }
        this.animationController = null;
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume(null, WindowInsetsNestedScrollConnection$animationEnded$1.INSTANCE);
        }
        this.continuation = null;
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.animationJob = null;
        this.partialConsumption = 0.0f;
        this.isControllerRequested = false;
    }
}
