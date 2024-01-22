package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0000\u001aG\u0010\b\u001a\u00020\t*\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\nj\u0002`\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001aO\u0010\u0013\u001a\u00020\t*\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\nj\u0002`\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a[\u0010\u0017\u001a\u00020\t*\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\nj\u0002`\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0019\"\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001aU\u0010\u0017\u001a\u00020\t*\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\nj\u0002`\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\b\b\u0002\u0010\u0010\u001a\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001d\u001a(\u0010\u001e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u0006H\u0000\u001a(\u0010!\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u0014\u0010\"\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000*<\b\u0000\u0010#\"\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\n2\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\n\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006$"}, d2 = {"down", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "id", "", "durationMillis", "x", "", "y", "invokeOverAllPasses", "", "Lkotlin/Function3;", "Landroidx/compose/ui/input/pointer/PointerEvent;", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/input/pointer/PointerInputHandler;", "pointerEvent", "size", "invokeOverAllPasses-H0pRuoY", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;J)V", "invokeOverPass", "pointerEventPass", "invokeOverPass-hUlJWOE", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "invokeOverPasses", "pointerEventPasses", "", "invokeOverPasses-hUlJWOE", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;[Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;Ljava/util/List;J)V", "moveBy", "dx", "dy", "moveTo", "up", "PointerInputHandler", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerInputTestUtil.kt */
public final class PointerInputTestUtilKt {
    public static /* synthetic */ PointerInputChange down$default(long j, long j2, float f, float f2, int i, Object obj) {
        long j3;
        float f3;
        float f4;
        if ((i & 2) != 0) {
            j3 = 0;
        } else {
            j3 = j2;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        } else {
            f3 = f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        } else {
            f4 = f2;
        }
        return down(j, j3, f3, f4);
    }

    public static final PointerInputChange down(long id, long durationMillis, float x, float y) {
        return new PointerInputChange(PointerId.m4650constructorimpl(id), durationMillis, OffsetKt.Offset(x, y), true, 1.0f, durationMillis, OffsetKt.Offset(x, y), false, false, 0, 0, 1536, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PointerInputChange moveTo$default(PointerInputChange pointerInputChange, long j, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        return moveTo(pointerInputChange, j, f, f2);
    }

    public static final PointerInputChange moveTo(PointerInputChange $this$moveTo, long durationMillis, float x, float y) {
        Intrinsics.checkNotNullParameter($this$moveTo, "<this>");
        long r1 = $this$moveTo.m4666getIdJ3iCeTQ();
        long uptimeMillis = $this$moveTo.getUptimeMillis();
        boolean pressed = $this$moveTo.getPressed();
        return new PointerInputChange(r1, durationMillis, OffsetKt.Offset(x, y), true, 1.0f, uptimeMillis, $this$moveTo.m4667getPositionF1C5BW0(), pressed, false, 0, 0, 1536, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PointerInputChange moveBy$default(PointerInputChange pointerInputChange, long j, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        return moveBy(pointerInputChange, j, f, f2);
    }

    public static final PointerInputChange moveBy(PointerInputChange $this$moveBy, long durationMillis, float dx, float dy) {
        Intrinsics.checkNotNullParameter($this$moveBy, "<this>");
        long r3 = $this$moveBy.m4666getIdJ3iCeTQ();
        long uptimeMillis = $this$moveBy.getUptimeMillis();
        boolean pressed = $this$moveBy.getPressed();
        return new PointerInputChange(r3, $this$moveBy.getUptimeMillis() + durationMillis, OffsetKt.Offset(Offset.m2915getXimpl($this$moveBy.m4667getPositionF1C5BW0()) + dx, Offset.m2916getYimpl($this$moveBy.m4667getPositionF1C5BW0()) + dy), true, 1.0f, uptimeMillis, $this$moveBy.m4667getPositionF1C5BW0(), pressed, false, 0, 0, 1536, (DefaultConstructorMarker) null);
    }

    public static final PointerInputChange up(PointerInputChange $this$up, long durationMillis) {
        Intrinsics.checkNotNullParameter($this$up, "<this>");
        long r1 = $this$up.m4666getIdJ3iCeTQ();
        long uptimeMillis = $this$up.getUptimeMillis();
        boolean pressed = $this$up.getPressed();
        return new PointerInputChange(r1, durationMillis, $this$up.m4667getPositionF1C5BW0(), false, 1.0f, uptimeMillis, $this$up.m4667getPositionF1C5BW0(), pressed, false, 0, 0, 1536, (DefaultConstructorMarker) null);
    }

    /* renamed from: invokeOverAllPasses-H0pRuoY$default  reason: not valid java name */
    public static /* synthetic */ void m4718invokeOverAllPassesH0pRuoY$default(Function3 function3, PointerEvent pointerEvent, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m4717invokeOverAllPassesH0pRuoY(function3, pointerEvent, j);
    }

    /* renamed from: invokeOverAllPasses-H0pRuoY  reason: not valid java name */
    public static final void m4717invokeOverAllPassesH0pRuoY(Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> $this$invokeOverAllPasses_u2dH0pRuoY, PointerEvent pointerEvent, long size) {
        Intrinsics.checkNotNullParameter($this$invokeOverAllPasses_u2dH0pRuoY, "$this$invokeOverAllPasses");
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        m4721invokeOverPasseshUlJWOE($this$invokeOverAllPasses_u2dH0pRuoY, pointerEvent, (List<? extends PointerEventPass>) CollectionsKt.listOf(PointerEventPass.Initial, PointerEventPass.Main, PointerEventPass.Final), size);
    }

    /* renamed from: invokeOverPass-hUlJWOE$default  reason: not valid java name */
    public static /* synthetic */ void m4720invokeOverPasshUlJWOE$default(Function3 function3, PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m4719invokeOverPasshUlJWOE(function3, pointerEvent, pointerEventPass, j);
    }

    /* renamed from: invokeOverPass-hUlJWOE  reason: not valid java name */
    public static final void m4719invokeOverPasshUlJWOE(Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> $this$invokeOverPass_u2dhUlJWOE, PointerEvent pointerEvent, PointerEventPass pointerEventPass, long size) {
        Intrinsics.checkNotNullParameter($this$invokeOverPass_u2dhUlJWOE, "$this$invokeOverPass");
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pointerEventPass, "pointerEventPass");
        m4721invokeOverPasseshUlJWOE($this$invokeOverPass_u2dhUlJWOE, pointerEvent, (List<? extends PointerEventPass>) CollectionsKt.listOf(pointerEventPass), size);
    }

    /* renamed from: invokeOverPasses-hUlJWOE$default  reason: not valid java name */
    public static /* synthetic */ void m4724invokeOverPasseshUlJWOE$default(Function3 function3, PointerEvent pointerEvent, PointerEventPass[] pointerEventPassArr, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m4722invokeOverPasseshUlJWOE((Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit>) function3, pointerEvent, pointerEventPassArr, j);
    }

    /* renamed from: invokeOverPasses-hUlJWOE  reason: not valid java name */
    public static final void m4722invokeOverPasseshUlJWOE(Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> $this$invokeOverPasses_u2dhUlJWOE, PointerEvent pointerEvent, PointerEventPass[] pointerEventPasses, long size) {
        Intrinsics.checkNotNullParameter($this$invokeOverPasses_u2dhUlJWOE, "$this$invokeOverPasses");
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pointerEventPasses, "pointerEventPasses");
        m4721invokeOverPasseshUlJWOE($this$invokeOverPasses_u2dhUlJWOE, pointerEvent, (List<? extends PointerEventPass>) ArraysKt.toList((T[]) pointerEventPasses), size);
    }

    /* renamed from: invokeOverPasses-hUlJWOE$default  reason: not valid java name */
    public static /* synthetic */ void m4723invokeOverPasseshUlJWOE$default(Function3 function3, PointerEvent pointerEvent, List list, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m4721invokeOverPasseshUlJWOE((Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit>) function3, pointerEvent, (List<? extends PointerEventPass>) list, j);
    }

    /* renamed from: invokeOverPasses-hUlJWOE  reason: not valid java name */
    public static final void m4721invokeOverPasseshUlJWOE(Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> $this$invokeOverPasses_u2dhUlJWOE, PointerEvent pointerEvent, List<? extends PointerEventPass> pointerEventPasses, long size) {
        Intrinsics.checkNotNullParameter($this$invokeOverPasses_u2dhUlJWOE, "$this$invokeOverPasses");
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pointerEventPasses, "pointerEventPasses");
        if (!(!pointerEvent.getChanges().isEmpty())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!pointerEventPasses.isEmpty()) {
            List $this$fastForEach$iv = pointerEventPasses;
            int size2 = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size2; index$iv++) {
                $this$invokeOverPasses_u2dhUlJWOE.invoke(pointerEvent, (PointerEventPass) $this$fastForEach$iv.get(index$iv), IntSize.m6138boximpl(size));
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }
}
