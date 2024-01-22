package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSize;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001cB\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ@\u0010/\u001a\u0002H0\"\u0004\b\u0000\u001002'\u00101\u001a#\b\u0001\u0012\u0004\u0012\u000203\u0012\n\u0012\b\u0012\u0004\u0012\u0002H004\u0012\u0006\u0012\u0004\u0018\u00010502¢\u0006\u0002\b6H@ø\u0001\u0000¢\u0006\u0002\u00107J\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<H\u0002J-\u0010=\u001a\u0002092\u0006\u0010;\u001a\u00020<2\u001a\u00101\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u00030\u001bR\u00020\u0000\u0012\u0004\u0012\u0002090>H\bJ\b\u0010?\u001a\u000209H\u0016J-\u0010@\u001a\u0002092\u0006\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<2\u0006\u0010A\u001a\u00020\nH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\u001a\u0010D\u001a\u00020E*\u00020FH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u001a\u0010D\u001a\u00020E*\u00020IH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ\u001a\u0010L\u001a\u00020F*\u00020IH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ\u001d\u0010L\u001a\u00020F*\u00020\u0016H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001d\u0010L\u001a\u00020F*\u00020EH\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010QJ\u001a\u0010R\u001a\u00020S*\u00020\u001dH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\u001a\u0010V\u001a\u00020\u0016*\u00020FH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010PJ\u001a\u0010V\u001a\u00020\u0016*\u00020IH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010NJ\r\u0010Y\u001a\u00020Z*\u00020[H\u0001J\u001a\u0010\\\u001a\u00020\u001d*\u00020SH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b]\u0010UJ\u001a\u0010^\u001a\u00020I*\u00020FH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b_\u0010`J\u001d\u0010^\u001a\u00020I*\u00020\u0016H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\ba\u0010`J\u001d\u0010^\u001a\u00020I*\u00020EH\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\ba\u0010bR\u0019\u0010\t\u001a\u00020\nX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR \u0010\f\u001a\u00020\rX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00168\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u001bR\u00020\u00000\u001aX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u00020\u001d8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00168\u0016X\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\u0018R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u001bR\u00020\u00000\u001aX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006d"}, d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilter;", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "Landroidx/compose/ui/input/pointer/PointerInputModifier;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Landroidx/compose/ui/unit/Density;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "density", "(Landroidx/compose/ui/platform/ViewConfiguration;Landroidx/compose/ui/unit/Density;)V", "boundsSize", "Landroidx/compose/ui/unit/IntSize;", "J", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$annotations", "()V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "", "getDensity", "()F", "dispatchingPointerHandlers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilter$PointerEventHandlerCoroutine;", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "fontScale", "getFontScale", "interceptOutOfBoundsChildEvents", "", "getInterceptOutOfBoundsChildEvents", "()Z", "setInterceptOutOfBoundsChildEvents", "(Z)V", "lastPointerEvent", "pointerHandlers", "pointerInputFilter", "getPointerInputFilter", "()Landroidx/compose/ui/input/pointer/PointerInputFilter;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEventScope", "R", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPointerEvent", "", "pointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "forEachCurrentPointerHandler", "Lkotlin/Function1;", "onCancel", "onPointerEvent", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "PointerEventHandlerCoroutine", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SuspendingPointerInputFilter.kt */
public final class SuspendingPointerInputFilter extends PointerInputFilter implements PointerInputModifier, PointerInputScope, Density {
    private final /* synthetic */ Density $$delegate_0;
    /* access modifiers changed from: private */
    public long boundsSize;
    private CoroutineScope coroutineScope;
    /* access modifiers changed from: private */
    public PointerEvent currentEvent;
    private final MutableVector<PointerEventHandlerCoroutine<?>> dispatchingPointerHandlers;
    private boolean interceptOutOfBoundsChildEvents;
    private PointerEvent lastPointerEvent;
    /* access modifiers changed from: private */
    public final MutableVector<PointerEventHandlerCoroutine<?>> pointerHandlers;
    private final ViewConfiguration viewConfiguration;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SuspendingPointerInputFilter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PointerEventPass.values().length];
            try {
                iArr[PointerEventPass.Initial.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PointerEventPass.Final.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PointerEventPass.Main.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getCoroutineScope$annotations() {
    }

    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public int m4761roundToPxR2X_6o(long j) {
        return this.$$delegate_0.m5960roundToPxR2X_6o(j);
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public int m4762roundToPx0680j_4(float f) {
        return this.$$delegate_0.m5961roundToPx0680j_4(f);
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public float m4763toDpGaN1DYA(long j) {
        return this.$$delegate_0.m5962toDpGaN1DYA(j);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m4764toDpu2uoSUM(float f) {
        return this.$$delegate_0.m5963toDpu2uoSUM(f);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m4765toDpu2uoSUM(int i) {
        return this.$$delegate_0.m5964toDpu2uoSUM(i);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public long m4766toDpSizekrfVVM(long j) {
        return this.$$delegate_0.m5965toDpSizekrfVVM(j);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public float m4767toPxR2X_6o(long j) {
        return this.$$delegate_0.m5966toPxR2X_6o(j);
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public float m4768toPx0680j_4(float f) {
        return this.$$delegate_0.m5967toPx0680j_4(f);
    }

    public Rect toRect(DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.$$delegate_0.toRect(dpRect);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public long m4769toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.m5968toSizeXkaWNTQ(j);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public long m4770toSp0xMU5do(float f) {
        return this.$$delegate_0.m5969toSp0xMU5do(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m4771toSpkPz2Gy4(float f) {
        return this.$$delegate_0.m5970toSpkPz2Gy4(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m4772toSpkPz2Gy4(int i) {
        return this.$$delegate_0.m5971toSpkPz2Gy4(i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuspendingPointerInputFilter(ViewConfiguration viewConfiguration2, Density density, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewConfiguration2, (i & 2) != 0 ? DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null) : density);
    }

    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public SuspendingPointerInputFilter(ViewConfiguration viewConfiguration2, Density density) {
        Intrinsics.checkNotNullParameter(viewConfiguration2, "viewConfiguration");
        Intrinsics.checkNotNullParameter(density, "density");
        this.viewConfiguration = viewConfiguration2;
        this.$$delegate_0 = density;
        this.currentEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
        this.pointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
        this.dispatchingPointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
        this.boundsSize = IntSize.Companion.m6151getZeroYbymL2g();
        this.coroutineScope = GlobalScope.INSTANCE;
    }

    public PointerInputFilter getPointerInputFilter() {
        return this;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final void setCoroutineScope(CoroutineScope coroutineScope2) {
        Intrinsics.checkNotNullParameter(coroutineScope2, "<set-?>");
        this.coroutineScope = coroutineScope2;
    }

    /* renamed from: getExtendedTouchPadding-NH-jbRc  reason: not valid java name */
    public long m4759getExtendedTouchPaddingNHjbRc() {
        long minimumTouchTargetSize = m4769toSizeXkaWNTQ(getViewConfiguration().m5282getMinimumTouchTargetSizeMYxV2XQ());
        long size = m4687getSizeYbymL2g();
        return SizeKt.Size(Math.max(0.0f, Size.m2984getWidthimpl(minimumTouchTargetSize) - ((float) IntSize.m6146getWidthimpl(size))) / 2.0f, Math.max(0.0f, Size.m2981getHeightimpl(minimumTouchTargetSize) - ((float) IntSize.m6145getHeightimpl(size))) / 2.0f);
    }

    public boolean getInterceptOutOfBoundsChildEvents() {
        return this.interceptOutOfBoundsChildEvents;
    }

    public void setInterceptOutOfBoundsChildEvents(boolean z) {
        this.interceptOutOfBoundsChildEvents = z;
    }

    /* JADX INFO: finally extract failed */
    private final void forEachCurrentPointerHandler(PointerEventPass pass, Function1<? super PointerEventHandlerCoroutine<?>, Unit> block) {
        synchronized (this.pointerHandlers) {
            try {
                MutableVector this_$iv = this.dispatchingPointerHandlers;
                this_$iv.addAll(this_$iv.getSize(), this.pointerHandlers);
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        try {
            switch (WhenMappings.$EnumSwitchMapping$0[pass.ordinal()]) {
                case 1:
                case 2:
                    MutableVector this_$iv2 = this.dispatchingPointerHandlers;
                    int size$iv = this_$iv2.getSize();
                    if (size$iv > 0) {
                        int i$iv = 0;
                        Object[] content$iv = this_$iv2.getContent();
                        do {
                            block.invoke(content$iv[i$iv]);
                            i$iv++;
                        } while (i$iv < size$iv);
                        break;
                    }
                    break;
                case 3:
                    MutableVector this_$iv3 = this.dispatchingPointerHandlers;
                    int size$iv2 = this_$iv3.getSize();
                    if (size$iv2 > 0) {
                        int i$iv2 = size$iv2 - 1;
                        Object[] content$iv2 = this_$iv3.getContent();
                        do {
                            block.invoke(content$iv2[i$iv2]);
                            i$iv2--;
                        } while (i$iv2 >= 0);
                    }
                    break;
            }
        } finally {
            InlineMarker.finallyStart(1);
            this.dispatchingPointerHandlers.clear();
            InlineMarker.finallyEnd(1);
        }
    }

    private final void dispatchPointerEvent(PointerEvent pointerEvent, PointerEventPass pass) {
        synchronized (this.pointerHandlers) {
            MutableVector this_$iv$iv = this.dispatchingPointerHandlers;
            this_$iv$iv.addAll(this_$iv$iv.getSize(), this.pointerHandlers);
        }
        try {
            switch (WhenMappings.$EnumSwitchMapping$0[pass.ordinal()]) {
                case 1:
                case 2:
                    MutableVector this_$iv$iv2 = this.dispatchingPointerHandlers;
                    int size$iv$iv = this_$iv$iv2.getSize();
                    if (size$iv$iv > 0) {
                        int i$iv$iv = 0;
                        Object[] content$iv$iv = this_$iv$iv2.getContent();
                        do {
                            ((PointerEventHandlerCoroutine) content$iv$iv[i$iv$iv]).offerPointerEvent(pointerEvent, pass);
                            i$iv$iv++;
                        } while (i$iv$iv < size$iv$iv);
                        break;
                    }
                    break;
                case 3:
                    MutableVector this_$iv$iv3 = this.dispatchingPointerHandlers;
                    int size$iv$iv2 = this_$iv$iv3.getSize();
                    if (size$iv$iv2 > 0) {
                        int i$iv$iv2 = size$iv$iv2 - 1;
                        Object[] content$iv$iv2 = this_$iv$iv3.getContent();
                        do {
                            ((PointerEventHandlerCoroutine) content$iv$iv2[i$iv$iv2]).offerPointerEvent(pointerEvent, pass);
                            i$iv$iv2--;
                        } while (i$iv$iv2 >= 0);
                    }
                    break;
            }
        } finally {
            this.dispatchingPointerHandlers.clear();
        }
    }

    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void m4760onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        boolean z;
        PointerEvent pointerEvent2 = pointerEvent;
        PointerEventPass pointerEventPass = pass;
        Intrinsics.checkNotNullParameter(pointerEvent2, "pointerEvent");
        Intrinsics.checkNotNullParameter(pointerEventPass, "pass");
        this.boundsSize = bounds;
        if (pointerEventPass == PointerEventPass.Initial) {
            this.currentEvent = pointerEvent2;
        }
        dispatchPointerEvent(pointerEvent, pass);
        List $this$fastForEach$iv$iv = pointerEvent.getChanges();
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (true) {
            if (index$iv$iv >= size) {
                z = true;
                break;
            } else if (!PointerEventKt.changedToUpIgnoreConsumed((PointerInputChange) $this$fastForEach$iv$iv.get(index$iv$iv))) {
                z = false;
                break;
            } else {
                index$iv$iv++;
            }
        }
        this.lastPointerEvent = z ^ true ? pointerEvent2 : null;
    }

    public void onCancel() {
        boolean z;
        PointerEvent lastEvent = this.lastPointerEvent;
        if (lastEvent != null) {
            List $this$fastForEach$iv$iv = lastEvent.getChanges();
            int index$iv$iv = 0;
            int size = $this$fastForEach$iv$iv.size();
            while (true) {
                z = true;
                if (index$iv$iv >= size) {
                    break;
                } else if (!(true ^ ((PointerInputChange) $this$fastForEach$iv$iv.get(index$iv$iv)).getPressed())) {
                    z = false;
                    break;
                } else {
                    index$iv$iv++;
                }
            }
            if (!z) {
                List changes = lastEvent.getChanges();
                List target$iv = new ArrayList(changes.size());
                List $this$fastForEach$iv$iv2 = changes;
                int size2 = $this$fastForEach$iv$iv2.size();
                for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                    PointerInputChange old = (PointerInputChange) $this$fastForEach$iv$iv2.get(index$iv$iv2);
                    long r15 = old.m4666getIdJ3iCeTQ();
                    long r19 = old.m4667getPositionF1C5BW0();
                    target$iv.add(new PointerInputChange(r15, old.getUptimeMillis(), r19, false, old.getPressure(), old.getUptimeMillis(), old.m4667getPositionF1C5BW0(), old.getPressed(), old.getPressed(), 0, 0, 1536, (DefaultConstructorMarker) null));
                }
                PointerEvent cancelEvent = new PointerEvent(target$iv);
                this.currentEvent = cancelEvent;
                dispatchPointerEvent(cancelEvent, PointerEventPass.Initial);
                dispatchPointerEvent(cancelEvent, PointerEventPass.Main);
                dispatchPointerEvent(cancelEvent, PointerEventPass.Final);
                this.lastPointerEvent = null;
            }
        }
    }

    public <R> Object awaitPointerEventScope(Function2<? super AwaitPointerEventScope, ? super Continuation<? super R>, ? extends Object> block, Continuation<? super R> $completion) {
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellable$iv.initCancellability();
        CancellableContinuation continuation = cancellable$iv;
        PointerEventHandlerCoroutine handlerCoroutine = new PointerEventHandlerCoroutine(this, continuation);
        synchronized (this.pointerHandlers) {
            this.pointerHandlers.add(handlerCoroutine);
            Continuation<Unit> createCoroutine = ContinuationKt.createCoroutine(block, handlerCoroutine, handlerCoroutine);
            Result.Companion companion = Result.Companion;
            createCoroutine.resumeWith(Result.m6273constructorimpl(Unit.INSTANCE));
            Unit unit = Unit.INSTANCE;
        }
        continuation.invokeOnCancellation(new SuspendingPointerInputFilter$awaitPointerEventScope$2$2(handlerCoroutine));
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return result;
    }

    @Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0006J\u0019\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*J\u0016\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\bJ\u001e\u0010-\u001a\u00020(2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0016ø\u0001\u0000¢\u0006\u0002\u00100JH\u00101\u001a\u0002H2\"\u0004\b\u0001\u001022\u0006\u00103\u001a\u0002042'\u00105\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H20\u0004\u0012\u0006\u0012\u0004\u0018\u00010706¢\u0006\u0002\b8H@ø\u0001\u0000¢\u0006\u0002\u00109JJ\u0010:\u001a\u0004\u0018\u0001H2\"\u0004\b\u0001\u001022\u0006\u00103\u001a\u0002042'\u00105\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H20\u0004\u0012\u0006\u0012\u0004\u0018\u00010706¢\u0006\u0002\b8H@ø\u0001\u0000¢\u0006\u0002\u00109J\u001a\u0010;\u001a\u00020<*\u00020=H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u001a\u0010;\u001a\u00020<*\u00020@H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u001a\u0010C\u001a\u00020=*\u00020@H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u001d\u0010C\u001a\u00020=*\u00020\u0012H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001d\u0010C\u001a\u00020=*\u00020<H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010HJ\u001a\u0010I\u001a\u00020J*\u00020\u0016H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u001a\u0010M\u001a\u00020\u0012*\u00020=H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010GJ\u001a\u0010M\u001a\u00020\u0012*\u00020@H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010EJ\r\u0010P\u001a\u00020Q*\u00020RH\u0001J\u001a\u0010S\u001a\u00020\u0016*\u00020JH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010LJ\u001a\u0010U\u001a\u00020@*\u00020=H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\u001d\u0010U\u001a\u00020@*\u00020\u0012H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010WJ\u001d\u0010U\u001a\u00020@*\u00020<H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010YR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u00020\u00168VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00128\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u00020\u001e8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0018R\u0014\u0010 \u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilter$PointerEventHandlerCoroutine;", "R", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/coroutines/Continuation;", "completion", "(Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilter;Lkotlin/coroutines/Continuation;)V", "awaitPass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "getCurrentEvent", "()Landroidx/compose/ui/input/pointer/PointerEvent;", "density", "", "getDensity", "()F", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "fontScale", "getFontScale", "pointerAwaiter", "Lkotlinx/coroutines/CancellableContinuation;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEvent", "pass", "(Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "cause", "", "offerPointerEvent", "event", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "withTimeout", "T", "timeMillis", "", "block", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SuspendingPointerInputFilter.kt */
    private final class PointerEventHandlerCoroutine<R> implements AwaitPointerEventScope, Density, Continuation<R> {
        private final /* synthetic */ SuspendingPointerInputFilter $$delegate_0;
        /* access modifiers changed from: private */
        public PointerEventPass awaitPass = PointerEventPass.Main;
        private final Continuation<R> completion;
        private final CoroutineContext context = EmptyCoroutineContext.INSTANCE;
        /* access modifiers changed from: private */
        public CancellableContinuation<? super PointerEvent> pointerAwaiter;
        final /* synthetic */ SuspendingPointerInputFilter this$0;

        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public int m4775roundToPxR2X_6o(long j) {
            return this.$$delegate_0.m4761roundToPxR2X_6o(j);
        }

        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public int m4776roundToPx0680j_4(float f) {
            return this.$$delegate_0.m4762roundToPx0680j_4(f);
        }

        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public float m4777toDpGaN1DYA(long j) {
            return this.$$delegate_0.m4763toDpGaN1DYA(j);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public float m4778toDpu2uoSUM(float f) {
            return this.$$delegate_0.m4764toDpu2uoSUM(f);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public float m4779toDpu2uoSUM(int i) {
            return this.$$delegate_0.m4765toDpu2uoSUM(i);
        }

        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public long m4780toDpSizekrfVVM(long j) {
            return this.$$delegate_0.m4766toDpSizekrfVVM(j);
        }

        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public float m4781toPxR2X_6o(long j) {
            return this.$$delegate_0.m4767toPxR2X_6o(j);
        }

        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public float m4782toPx0680j_4(float f) {
            return this.$$delegate_0.m4768toPx0680j_4(f);
        }

        public Rect toRect(DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "<this>");
            return this.$$delegate_0.toRect(dpRect);
        }

        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public long m4783toSizeXkaWNTQ(long j) {
            return this.$$delegate_0.m4769toSizeXkaWNTQ(j);
        }

        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public long m4784toSp0xMU5do(float f) {
            return this.$$delegate_0.m4770toSp0xMU5do(f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public long m4785toSpkPz2Gy4(float f) {
            return this.$$delegate_0.m4771toSpkPz2Gy4(f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public long m4786toSpkPz2Gy4(int i) {
            return this.$$delegate_0.m4772toSpkPz2Gy4(i);
        }

        public PointerEventHandlerCoroutine(SuspendingPointerInputFilter this$02, Continuation<? super R> completion2) {
            Intrinsics.checkNotNullParameter(completion2, "completion");
            this.this$0 = this$02;
            this.completion = completion2;
            this.$$delegate_0 = this$02;
        }

        public PointerEvent getCurrentEvent() {
            return this.this$0.currentEvent;
        }

        /* renamed from: getSize-YbymL2g  reason: not valid java name */
        public long m4774getSizeYbymL2g() {
            return this.this$0.boundsSize;
        }

        public ViewConfiguration getViewConfiguration() {
            return this.this$0.getViewConfiguration();
        }

        /* renamed from: getExtendedTouchPadding-NH-jbRc  reason: not valid java name */
        public long m4773getExtendedTouchPaddingNHjbRc() {
            return this.this$0.m4759getExtendedTouchPaddingNHjbRc();
        }

        public final void offerPointerEvent(PointerEvent event, PointerEventPass pass) {
            CancellableContinuation $this$offerPointerEvent_u24lambda_u240;
            Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
            Intrinsics.checkNotNullParameter(pass, "pass");
            if (pass == this.awaitPass && ($this$offerPointerEvent_u24lambda_u240 = this.pointerAwaiter) != null) {
                this.pointerAwaiter = null;
                Result.Companion companion = Result.Companion;
                $this$offerPointerEvent_u24lambda_u240.resumeWith(Result.m6273constructorimpl(event));
            }
        }

        public final void cancel(Throwable cause) {
            CancellableContinuation<? super PointerEvent> cancellableContinuation = this.pointerAwaiter;
            if (cancellableContinuation != null) {
                cancellableContinuation.cancel(cause);
            }
            this.pointerAwaiter = null;
        }

        public CoroutineContext getContext() {
            return this.context;
        }

        public void resumeWith(Object result) {
            Object lock$iv = this.this$0.pointerHandlers;
            SuspendingPointerInputFilter suspendingPointerInputFilter = this.this$0;
            synchronized (lock$iv) {
                suspendingPointerInputFilter.pointerHandlers.remove(this);
                Unit unit = Unit.INSTANCE;
            }
            this.completion.resumeWith(result);
        }

        public Object awaitPointerEvent(PointerEventPass pass, Continuation<? super PointerEvent> $completion) {
            CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
            cancellable$iv.initCancellability();
            this.awaitPass = pass;
            this.pointerAwaiter = cancellable$iv;
            Object result = cancellable$iv.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended($completion);
            }
            return result;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x002d A[SYNTHETIC, Splitter:B:10:0x002d] */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T> java.lang.Object withTimeoutOrNull(long r5, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super T> r8) {
            /*
                r4 = this;
                boolean r0 = r8 instanceof androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1
                if (r0 == 0) goto L_0x0014
                r0 = r8
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1 r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L_0x0014
                int r8 = r0.label
                int r8 = r8 - r2
                r0.label = r8
                goto L_0x0019
            L_0x0014:
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1 r0 = new androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1
                r0.<init>(r4, r8)
            L_0x0019:
                r8 = r0
                java.lang.Object r0 = r8.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r8.label
                switch(r2) {
                    case 0: goto L_0x0034;
                    case 1: goto L_0x002d;
                    default: goto L_0x0025;
                }
            L_0x0025:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x002d:
                kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0032 }
                r3 = r0
                goto L_0x0043
            L_0x0032:
                r5 = move-exception
                goto L_0x0044
            L_0x0034:
                kotlin.ResultKt.throwOnFailure(r0)
                r2 = r4
                r3 = 1
                r8.label = r3     // Catch:{ PointerEventTimeoutCancellationException -> 0x0032 }
                java.lang.Object r3 = r2.withTimeout(r5, r7, r8)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0032 }
                if (r3 != r1) goto L_0x0043
                return r1
            L_0x0043:
                goto L_0x0045
            L_0x0044:
                r3 = 0
            L_0x0045:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputFilter.PointerEventHandlerCoroutine.withTimeoutOrNull(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: kotlinx.coroutines.Job} */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x008f, code lost:
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r4, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0092, code lost:
            return r7;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T> java.lang.Object withTimeout(long r18, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r20, kotlin.coroutines.Continuation<? super T> r21) {
            /*
                r17 = this;
                r0 = r21
                boolean r1 = r0 instanceof androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1
                if (r1 == 0) goto L_0x0019
                r1 = r0
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1 r1 = (androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1) r1
                int r2 = r1.label
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r2 & r3
                if (r2 == 0) goto L_0x0019
                int r0 = r1.label
                int r0 = r0 - r3
                r1.label = r0
                r0 = r1
                r2 = r17
                goto L_0x0021
            L_0x0019:
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1 r1 = new androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1
                r2 = r17
                r1.<init>(r2, r0)
                r0 = r1
            L_0x0021:
                java.lang.Object r3 = r1.result
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r4 = r1.label
                r5 = 1
                r6 = 0
                switch(r4) {
                    case 0: goto L_0x0042;
                    case 1: goto L_0x0036;
                    default: goto L_0x002e;
                }
            L_0x002e:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x0036:
                java.lang.Object r0 = r1.L$0
                r4 = r0
                kotlinx.coroutines.Job r4 = (kotlinx.coroutines.Job) r4
                kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x0040 }
                r7 = r3
                goto L_0x008f
            L_0x0040:
                r0 = move-exception
                goto L_0x0095
            L_0x0042:
                kotlin.ResultKt.throwOnFailure(r3)
                r4 = r17
                r7 = r18
                r9 = r20
                r10 = 0
                int r10 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
                if (r10 > 0) goto L_0x006b
                kotlinx.coroutines.CancellableContinuation<? super androidx.compose.ui.input.pointer.PointerEvent> r10 = r4.pointerAwaiter
                if (r10 == 0) goto L_0x006b
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                kotlin.Result$Companion r11 = kotlin.Result.Companion
                androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException r11 = new androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException
                r11.<init>(r7)
                java.lang.Throwable r11 = (java.lang.Throwable) r11
                java.lang.Object r11 = kotlin.ResultKt.createFailure(r11)
                java.lang.Object r11 = kotlin.Result.m6273constructorimpl(r11)
                r10.resumeWith(r11)
            L_0x006b:
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter r10 = r4.this$0
                kotlinx.coroutines.CoroutineScope r11 = r10.getCoroutineScope()
                r12 = 0
                r13 = 0
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1 r10 = new androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1
                r10.<init>(r7, r4, r6)
                r14 = r10
                kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
                r15 = 3
                r16 = 0
                kotlinx.coroutines.Job r10 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r11, r12, r13, r14, r15, r16)
                r1.L$0 = r10     // Catch:{ all -> 0x0093 }
                r1.label = r5     // Catch:{ all -> 0x0093 }
                java.lang.Object r7 = r9.invoke(r4, r1)     // Catch:{ all -> 0x0093 }
                if (r7 != r0) goto L_0x008e
                return r0
            L_0x008e:
                r4 = r10
            L_0x008f:
                kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r4, (java.util.concurrent.CancellationException) r6, (int) r5, (java.lang.Object) r6)
                return r7
            L_0x0093:
                r0 = move-exception
                r4 = r10
            L_0x0095:
                kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r4, (java.util.concurrent.CancellationException) r6, (int) r5, (java.lang.Object) r6)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputFilter.PointerEventHandlerCoroutine.withTimeout(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
