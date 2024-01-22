package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a\u0017\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001a%\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\f\u0010\u0014\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0015\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a\u0019\u0010\u0016\u001a\u00020\u0003*\u00020\u0017H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\u0001*\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u001b\u0010\u0002\u001a\u00020\u0003*\u00020\u00048BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"ScrollingAxesThreshold", "", "scrollAxes", "", "Landroidx/compose/ui/geometry/Offset;", "getScrollAxes-k-4lQ0M", "(J)I", "composeToViewOffset", "offset", "rememberNestedScrollInteropConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "hostView", "Landroid/view/View;", "(Landroid/view/View;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "toOffset", "consumed", "", "available", "toOffset-Uv8p0NA", "([IJ)J", "ceilAwayFromZero", "reverseAxis", "toViewType", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "toViewType-GyEprt8", "(I)I", "toViewVelocity", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NestedScrollInteropConnection.kt */
public final class NestedScrollInteropConnectionKt {
    private static final float ScrollingAxesThreshold = 0.5f;

    private static final float ceilAwayFromZero(float $this$ceilAwayFromZero) {
        return (float) ($this$ceilAwayFromZero >= 0.0f ? Math.ceil((double) $this$ceilAwayFromZero) : Math.floor((double) $this$ceilAwayFromZero));
    }

    public static final int composeToViewOffset(float offset) {
        return ((int) ceilAwayFromZero(offset)) * -1;
    }

    private static final float reverseAxis(int $this$reverseAxis) {
        return ((float) $this$reverseAxis) * -1.0f;
    }

    /* access modifiers changed from: private */
    public static final float toViewVelocity(float $this$toViewVelocity) {
        return -1.0f * $this$toViewVelocity;
    }

    /* access modifiers changed from: private */
    /* renamed from: toOffset-Uv8p0NA  reason: not valid java name */
    public static final long m5264toOffsetUv8p0NA(int[] consumed, long available) {
        float offsetX;
        float offsetY;
        if (Offset.m2915getXimpl(available) >= 0.0f) {
            offsetX = RangesKt.coerceAtMost(reverseAxis(consumed[0]), Offset.m2915getXimpl(available));
        } else {
            offsetX = RangesKt.coerceAtLeast(reverseAxis(consumed[0]), Offset.m2915getXimpl(available));
        }
        if (Offset.m2916getYimpl(available) >= 0.0f) {
            offsetY = RangesKt.coerceAtMost(reverseAxis(consumed[1]), Offset.m2916getYimpl(available));
        } else {
            offsetY = RangesKt.coerceAtLeast(reverseAxis(consumed[1]), Offset.m2916getYimpl(available));
        }
        return OffsetKt.Offset(offsetX, offsetY);
    }

    /* access modifiers changed from: private */
    /* renamed from: toViewType-GyEprt8  reason: not valid java name */
    public static final int m5265toViewTypeGyEprt8(int $this$toViewType_u2dGyEprt8) {
        if (NestedScrollSource.m4561equalsimpl0($this$toViewType_u2dGyEprt8, NestedScrollSource.Companion.m4566getDragWNlRxjI())) {
            return 0;
        }
        return 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: getScrollAxes-k-4lQ0M  reason: not valid java name */
    public static final int m5263getScrollAxesk4lQ0M(long $this$scrollAxes) {
        int axes = 0;
        if (Math.abs(Offset.m2915getXimpl($this$scrollAxes)) >= 0.5f) {
            axes = 0 | 1;
        }
        if (Math.abs(Offset.m2916getYimpl($this$scrollAxes)) >= 0.5f) {
            return axes | 2;
        }
        return axes;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: androidx.compose.ui.platform.NestedScrollInteropConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: androidx.compose.ui.platform.NestedScrollInteropConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.input.nestedscroll.NestedScrollConnection rememberNestedScrollInteropConnection(android.view.View r8, androidx.compose.runtime.Composer r9, int r10, int r11) {
        /*
            r0 = 1260107652(0x4b1bb784, float:1.020506E7)
            r9.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberNestedScrollInteropConnection)232@8144L7,233@8180L66:NestedScrollInteropConnection.kt#itgzvw"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r11 = r11 & 1
            if (r11 == 0) goto L_0x0029
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            r1 = 6
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r3, r4)
            java.lang.Object r3 = r9.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r8 = r3
            android.view.View r8 = (android.view.View) r8
        L_0x0029:
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x0035
            r11 = -1
            java.lang.String r1 = "androidx.compose.ui.platform.rememberNestedScrollInteropConnection (NestedScrollInteropConnection.kt:231)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r10, r11, r1)
        L_0x0035:
            r11 = 8
            r0 = 0
            r1 = 1157296644(0x44faf204, float:2007.563)
            r9.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            boolean r1 = r9.changed((java.lang.Object) r8)
            r2 = r9
            r3 = 0
            java.lang.Object r4 = r2.rememberedValue()
            r5 = 0
            if (r1 != 0) goto L_0x005b
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r4 != r6) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            r6 = r4
            goto L_0x0066
        L_0x005b:
            r6 = 0
            androidx.compose.ui.platform.NestedScrollInteropConnection r7 = new androidx.compose.ui.platform.NestedScrollInteropConnection
            r7.<init>(r8)
            r6 = r7
            r2.updateRememberedValue(r6)
        L_0x0066:
            r9.endReplaceableGroup()
            androidx.compose.ui.platform.NestedScrollInteropConnection r6 = (androidx.compose.ui.platform.NestedScrollInteropConnection) r6
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x0076
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0076:
            r9.endReplaceableGroup()
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r6 = (androidx.compose.ui.input.nestedscroll.NestedScrollConnection) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.NestedScrollInteropConnectionKt.rememberNestedScrollInteropConnection(android.view.View, androidx.compose.runtime.Composer, int, int):androidx.compose.ui.input.nestedscroll.NestedScrollConnection");
    }
}
