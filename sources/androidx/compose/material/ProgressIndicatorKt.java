package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a3\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0005H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001aG\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020#2\b\b\u0002\u0010(\u001a\u00020)H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a;\u0010\u001e\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0005H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001aO\u0010\u001e\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020#2\b\b\u0002\u0010(\u001a\u00020)H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a3\u00101\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010'\u001a\u00020#H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a=\u00101\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010'\u001a\u00020#2\b\b\u0002\u0010(\u001a\u00020)H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a;\u00101\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010'\u001a\u00020#H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001aE\u00101\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010'\u001a\u00020#2\b\b\u0002\u0010(\u001a\u00020)H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a9\u0010:\u001a\u00020\u001f*\u00020;2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a)\u0010B\u001a\u00020\u001f*\u00020;2\u0006\u0010\"\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a9\u0010E\u001a\u00020\u001f*\u00020;2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010A\u001aA\u0010G\u001a\u00020\u001f*\u00020;2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001aA\u0010J\u001a\u00020\u001f*\u00020;2\u0006\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010(\u001a\u00020)H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a1\u0010O\u001a\u00020\u001f*\u00020;2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010(\u001a\u00020)H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0012\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0013\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006R"}, d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "LinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "StartAngleOffset", "CircularProgressIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "backgroundColor", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "progress", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-DUhRLBM", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-_5eSR-E", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorBackground", "drawCircularIndicatorBackground-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "drawLinearIndicatorBackground", "drawLinearIndicatorBackground-AZGd3zU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFI)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
    private static final float CircularIndicatorDiameter = Dp.m5986constructorimpl((float) 40);
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float LinearIndicatorHeight = ProgressIndicatorDefaults.INSTANCE.m1568getStrokeWidthD9Ej5fM();
    private static final float LinearIndicatorWidth = Dp.m5986constructorimpl((float) 240);
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);
    private static final float StartAngleOffset = -90.0f;

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01cf  */
    /* renamed from: LinearProgressIndicator-_5eSR-E  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1575LinearProgressIndicator_5eSRE(float r23, androidx.compose.ui.Modifier r24, long r25, long r27, int r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r10 = r23
            r11 = r31
            r0 = -531984864(0xffffffffe04a8e20, float:-5.8382555E19)
            r1 = r30
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LinearProgressIndicator)P(3,2,1:c#ui.graphics.Color,0:c#ui.graphics.Color,4:c#ui.graphics.StrokeCap)76@3573L6,85@3911L204,81@3769L346:ProgressIndicator.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r31
            r2 = r32 & 1
            if (r2 == 0) goto L_0x001b
            r1 = r1 | 6
            goto L_0x0029
        L_0x001b:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0029
            boolean r2 = r12.changed((float) r10)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r1 = r1 | r2
        L_0x0029:
            r2 = r32 & 2
            if (r2 == 0) goto L_0x0032
            r1 = r1 | 48
            r3 = r24
            goto L_0x0047
        L_0x0032:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0045
            r3 = r24
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0041
            r4 = 32
            goto L_0x0043
        L_0x0041:
            r4 = 16
        L_0x0043:
            r1 = r1 | r4
            goto L_0x0047
        L_0x0045:
            r3 = r24
        L_0x0047:
            r4 = r11 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0060
            r4 = r32 & 4
            if (r4 != 0) goto L_0x005a
            r4 = r25
            boolean r6 = r12.changed((long) r4)
            if (r6 == 0) goto L_0x005c
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r4 = r25
        L_0x005c:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r1 = r1 | r6
            goto L_0x0062
        L_0x0060:
            r4 = r25
        L_0x0062:
            r6 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x007b
            r6 = r32 & 8
            if (r6 != 0) goto L_0x0075
            r6 = r27
            boolean r8 = r12.changed((long) r6)
            if (r8 == 0) goto L_0x0077
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0075:
            r6 = r27
        L_0x0077:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r1 = r1 | r8
            goto L_0x007d
        L_0x007b:
            r6 = r27
        L_0x007d:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r11
            if (r8 != 0) goto L_0x0098
            r8 = r32 & 16
            if (r8 != 0) goto L_0x0092
            r8 = r29
            boolean r9 = r12.changed((int) r8)
            if (r9 == 0) goto L_0x0094
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0092:
            r8 = r29
        L_0x0094:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r1 = r1 | r9
            goto L_0x009a
        L_0x0098:
            r8 = r29
        L_0x009a:
            r9 = 46811(0xb6db, float:6.5596E-41)
            r9 = r9 & r1
            r13 = 9362(0x2492, float:1.3119E-41)
            if (r9 != r13) goto L_0x00b6
            boolean r9 = r12.getSkipping()
            if (r9 != 0) goto L_0x00a9
            goto L_0x00b6
        L_0x00a9:
            r12.skipToGroupEnd()
            r19 = r1
            r17 = r3
            r13 = r4
            r15 = r6
            r18 = r8
            goto L_0x01d8
        L_0x00b6:
            r12.startDefaults()
            r9 = r11 & 1
            r13 = -57345(0xffffffffffff1fff, float:NaN)
            if (r9 == 0) goto L_0x00de
            boolean r9 = r12.getDefaultsInvalid()
            if (r9 == 0) goto L_0x00c7
            goto L_0x00de
        L_0x00c7:
            r12.skipToGroupEnd()
            r2 = r32 & 4
            if (r2 == 0) goto L_0x00d0
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00d0:
            r2 = r32 & 8
            if (r2 == 0) goto L_0x00d6
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00d6:
            r2 = r32 & 16
            if (r2 == 0) goto L_0x00db
            r1 = r1 & r13
        L_0x00db:
            r2 = r3
            r3 = r4
            goto L_0x011e
        L_0x00de:
            if (r2 == 0) goto L_0x00e5
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00e6
        L_0x00e5:
            r2 = r3
        L_0x00e6:
            r3 = r32 & 4
            if (r3 == 0) goto L_0x00f8
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            r9 = 6
            androidx.compose.material.Colors r3 = r3.getColors(r12, r9)
            long r3 = r3.m1445getPrimary0d7_KjU()
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x00f9
        L_0x00f8:
            r3 = r4
        L_0x00f9:
            r5 = r32 & 8
            if (r5 == 0) goto L_0x0112
            r16 = 1047904911(0x3e75c28f, float:0.24)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 14
            r21 = 0
            r14 = r3
            long r5 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r14, r16, r17, r18, r19, r20, r21)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r6 = r5
        L_0x0112:
            r5 = r32 & 16
            if (r5 == 0) goto L_0x011e
            androidx.compose.ui.graphics.StrokeCap$Companion r5 = androidx.compose.ui.graphics.StrokeCap.Companion
            int r5 = r5.m3547getButtKaPHkGw()
            r1 = r1 & r13
            r8 = r5
        L_0x011e:
            r12.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x012d
            r5 = -1
            java.lang.String r9 = "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:72)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r11, r5, r9)
        L_0x012d:
            r0 = 0
            r5 = 1065353216(0x3f800000, float:1.0)
            float r0 = kotlin.ranges.RangesKt.coerceIn((float) r10, (float) r0, (float) r5)
            r5 = 0
            r9 = 0
            r13 = 6
            r14 = 0
            r24 = r2
            r25 = r0
            r26 = r5
            r27 = r9
            r28 = r13
            r29 = r14
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.ProgressSemanticsKt.progressSemantics$default(r24, r25, r26, r27, r28, r29)
            float r9 = LinearIndicatorWidth
            float r13 = LinearIndicatorHeight
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.m832sizeVpY3zN4(r5, r9, r13)
            androidx.compose.ui.graphics.Color r9 = androidx.compose.ui.graphics.Color.m3154boximpl(r6)
            androidx.compose.ui.graphics.StrokeCap r13 = androidx.compose.ui.graphics.StrokeCap.m3540boximpl(r8)
            java.lang.Float r14 = java.lang.Float.valueOf(r0)
            androidx.compose.ui.graphics.Color r15 = androidx.compose.ui.graphics.Color.m3154boximpl(r3)
            java.lang.Object[] r9 = new java.lang.Object[]{r9, r13, r14, r15}
            r13 = 8
            r14 = 0
            r15 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r12.startReplaceableGroup(r15)
            java.lang.String r15 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r15)
            r15 = 0
            r16 = r1
            int r1 = r9.length
            r17 = r2
            r2 = 0
        L_0x017a:
            if (r2 >= r1) goto L_0x018b
            r19 = r1
            r1 = r9[r2]
            boolean r20 = r12.changed((java.lang.Object) r1)
            r15 = r15 | r20
            int r2 = r2 + 1
            r1 = r19
            goto L_0x017a
        L_0x018b:
            r1 = r12
            r2 = 0
            r19 = r2
            java.lang.Object r2 = r1.rememberedValue()
            r20 = 0
            if (r15 != 0) goto L_0x01a4
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r22 = r9
            java.lang.Object r9 = r21.getEmpty()
            if (r2 != r9) goto L_0x01a2
            goto L_0x01a6
        L_0x01a2:
            r9 = r2
            goto L_0x01be
        L_0x01a4:
            r22 = r9
        L_0x01a6:
            r9 = 0
            androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$1$1 r21 = new androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$1$1
            r24 = r21
            r25 = r6
            r27 = r8
            r28 = r0
            r29 = r3
            r24.<init>(r25, r27, r28, r29)
            kotlin.jvm.functions.Function1 r21 = (kotlin.jvm.functions.Function1) r21
            r9 = r21
            r1.updateRememberedValue(r9)
        L_0x01be:
            r12.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r1 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r5, r9, r12, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01d2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01d2:
            r13 = r3
            r18 = r8
            r19 = r16
            r15 = r6
        L_0x01d8:
            androidx.compose.runtime.ScopeUpdateScope r9 = r12.endRestartGroup()
            if (r9 != 0) goto L_0x01df
            goto L_0x01fa
        L_0x01df:
            androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$2 r20 = new androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$2
            r0 = r20
            r1 = r23
            r2 = r17
            r3 = r13
            r5 = r15
            r7 = r18
            r8 = r31
            r10 = r9
            r9 = r32
            r0.<init>(r1, r2, r3, r5, r7, r8, r9)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x01fa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.m1575LinearProgressIndicator_5eSRE(float, androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: LinearProgressIndicator-2cYBFYY  reason: not valid java name */
    public static final void m1573LinearProgressIndicator2cYBFYY(Modifier modifier, long color, long backgroundColor, int strokeCap, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        long j2;
        int strokeCap2;
        int strokeCap3;
        long backgroundColor2;
        long color2;
        Modifier modifier3;
        long backgroundColor3;
        long color3;
        Modifier modifier4;
        int $dirty;
        Modifier modifier5;
        int i2;
        int i3;
        int i4;
        int i5 = $changed;
        Composer $composer2 = $composer.startRestartGroup(1501635280);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(2,1:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)108@5031L6,112@5200L28,116@5482L319,127@5846L319,138@6211L323,149@6580L323,164@7035L624,160@6908L751:ProgressIndicator.kt#jmzs0o");
        int $dirty2 = $changed;
        int i6 = i & 1;
        if (i6 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if ((i5 & 14) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i5 & 112) == 0) {
            if ((i & 2) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i4 = 32;
                    $dirty2 |= i4;
                }
            } else {
                j = color;
            }
            i4 = 16;
            $dirty2 |= i4;
        } else {
            j = color;
        }
        if ((i5 & 896) == 0) {
            if ((i & 4) == 0) {
                j2 = backgroundColor;
                if ($composer2.changed(j2)) {
                    i3 = 256;
                    $dirty2 |= i3;
                }
            } else {
                j2 = backgroundColor;
            }
            i3 = 128;
            $dirty2 |= i3;
        } else {
            j2 = backgroundColor;
        }
        if ((i5 & 7168) == 0) {
            if ((i & 8) == 0) {
                strokeCap2 = strokeCap;
                if ($composer2.changed(strokeCap2)) {
                    i2 = 2048;
                    $dirty2 |= i2;
                }
            } else {
                strokeCap2 = strokeCap;
            }
            i2 = 1024;
            $dirty2 |= i2;
        } else {
            strokeCap2 = strokeCap;
        }
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i5 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 2) != 0) {
                    color3 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1445getPrimary0d7_KjU();
                    $dirty2 &= -113;
                } else {
                    color3 = j;
                }
                if ((i & 4) != 0) {
                    backgroundColor3 = Color.m3163copywmQWz5c$default(color3, 0.24f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    $dirty2 &= -897;
                } else {
                    backgroundColor3 = j2;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    strokeCap2 = StrokeCap.Companion.m3547getButtKaPHkGw();
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                modifier4 = modifier2;
                color3 = j;
                backgroundColor3 = j2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1501635280, i5, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:106)");
            }
            InfiniteTransition infiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition($composer2, 0);
            State firstLineHead$delegate = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m389infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$2.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            State firstLineTail$delegate = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m389infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$2.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            State secondLineHead$delegate = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m389infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$2.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            State secondLineTail$delegate = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m389infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$2.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            Modifier r15 = SizeKt.m832sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(modifier4), LinearIndicatorWidth, LinearIndicatorHeight);
            Object[] keys$iv = {Color.m3154boximpl(backgroundColor3), StrokeCap.m3540boximpl(strokeCap2), firstLineHead$delegate, firstLineTail$delegate, Color.m3154boximpl(color3), secondLineHead$delegate, secondLineTail$delegate};
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : keys$iv) {
                invalid$iv |= $composer2.changed(key$iv);
            }
            Composer $this$cache$iv$iv = $composer2;
            Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv || value$iv$iv == Composer.Companion.getEmpty()) {
                Object obj = value$iv$iv;
                Object[] objArr = keys$iv;
                $dirty = $dirty2;
                modifier5 = r15;
                value$iv$iv = new ProgressIndicatorKt$LinearProgressIndicator$3$1(backgroundColor3, strokeCap2, color3, firstLineHead$delegate, firstLineTail$delegate, secondLineHead$delegate, secondLineTail$delegate);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                $dirty = $dirty2;
                Composer composer = $this$cache$iv$iv;
                Object obj2 = value$iv$iv;
                Object[] objArr2 = keys$iv;
                modifier5 = r15;
            }
            $composer2.endReplaceableGroup();
            CanvasKt.Canvas(modifier5, (Function1) value$iv$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i7 = $dirty;
            modifier3 = modifier4;
            color2 = color3;
            backgroundColor2 = backgroundColor3;
            strokeCap3 = strokeCap2;
        } else {
            $composer2.skipToGroupEnd();
            int i8 = $dirty2;
            modifier3 = modifier2;
            color2 = j;
            backgroundColor2 = j2;
            strokeCap3 = strokeCap2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ProgressIndicatorKt$LinearProgressIndicator$4(modifier3, color2, backgroundColor2, strokeCap3, $changed, i));
        }
    }

    /* access modifiers changed from: private */
    public static final float LinearProgressIndicator_2cYBFYY$lambda$1(State<Float> $firstLineHead$delegate) {
        return ((Number) $firstLineHead$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final float LinearProgressIndicator_2cYBFYY$lambda$2(State<Float> $firstLineTail$delegate) {
        return ((Number) $firstLineTail$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final float LinearProgressIndicator_2cYBFYY$lambda$3(State<Float> $secondLineHead$delegate) {
        return ((Number) $secondLineHead$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final float LinearProgressIndicator_2cYBFYY$lambda$4(State<Float> $secondLineTail$delegate) {
        return ((Number) $secondLineTail$delegate.getValue()).floatValue();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: LinearProgressIndicator-eaDK9VM  reason: not valid java name */
    public static final /* synthetic */ void m1576LinearProgressIndicatoreaDK9VM(float progress, Modifier modifier, long color, long backgroundColor, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        long j2;
        long backgroundColor2;
        long color2;
        Modifier modifier3;
        long backgroundColor3;
        long color3;
        Modifier modifier4;
        int i2;
        int i3;
        int i4 = $changed;
        Composer $composer2 = $composer.startRestartGroup(-850309746);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(3,2,1:c#ui.graphics.Color,0:c#ui.graphics.Color)193@7877L6,195@7973L118:ProgressIndicator.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            float f = progress;
        } else if ((i4 & 14) == 0) {
            $dirty |= $composer2.changed(progress) ? 4 : 2;
        } else {
            float f2 = progress;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i4 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i4 & 896) == 0) {
            if ((i & 4) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i3 = 256;
                    $dirty |= i3;
                }
            } else {
                j = color;
            }
            i3 = 128;
            $dirty |= i3;
        } else {
            j = color;
        }
        if ((i4 & 7168) == 0) {
            if ((i & 8) == 0) {
                j2 = backgroundColor;
                if ($composer2.changed(j2)) {
                    i2 = 2048;
                    $dirty |= i2;
                }
            } else {
                j2 = backgroundColor;
            }
            i2 = 1024;
            $dirty |= i2;
        } else {
            j2 = backgroundColor;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i4 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 4) != 0) {
                    color3 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1445getPrimary0d7_KjU();
                    $dirty &= -897;
                } else {
                    color3 = j;
                }
                if ((i & 8) != 0) {
                    backgroundColor3 = Color.m3163copywmQWz5c$default(color3, 0.24f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    $dirty &= -7169;
                } else {
                    backgroundColor3 = j2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                modifier4 = modifier2;
                color3 = j;
                backgroundColor3 = j2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-850309746, $dirty, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:190)");
            }
            m1575LinearProgressIndicator_5eSRE(progress, modifier4, color3, backgroundColor3, StrokeCap.Companion.m3547getButtKaPHkGw(), $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i6 = $dirty;
            modifier3 = modifier4;
            color2 = color3;
            backgroundColor2 = backgroundColor3;
        } else {
            $composer2.skipToGroupEnd();
            int i7 = $dirty;
            backgroundColor2 = j2;
            modifier3 = modifier2;
            color2 = j;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new ProgressIndicatorKt$LinearProgressIndicator$5(progress, modifier3, color2, backgroundColor2, $changed, i));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: LinearProgressIndicator-RIQooxk  reason: not valid java name */
    public static final /* synthetic */ void m1574LinearProgressIndicatorRIQooxk(Modifier modifier, long color, long backgroundColor, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        long j2;
        long backgroundColor2;
        long color2;
        Modifier modifier3;
        long backgroundColor3;
        long color3;
        Modifier modifier4;
        int i2;
        int i3;
        int i4 = $changed;
        Composer $composer2 = $composer.startRestartGroup(-819397058);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(2,1:c#ui.graphics.Color,0:c#ui.graphics.Color)207@8286L6,209@8382L104:ProgressIndicator.kt#jmzs0o");
        int $dirty = $changed;
        int i5 = i & 1;
        if (i5 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if ((i4 & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i4 & 112) == 0) {
            if ((i & 2) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i3 = 32;
                    $dirty |= i3;
                }
            } else {
                j = color;
            }
            i3 = 16;
            $dirty |= i3;
        } else {
            j = color;
        }
        if ((i4 & 896) == 0) {
            if ((i & 4) == 0) {
                j2 = backgroundColor;
                if ($composer2.changed(j2)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                j2 = backgroundColor;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            j2 = backgroundColor;
        }
        if (($dirty & 731) != 146 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i4 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 2) != 0) {
                    color3 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1445getPrimary0d7_KjU();
                    $dirty &= -113;
                } else {
                    color3 = j;
                }
                if ((i & 4) != 0) {
                    backgroundColor3 = Color.m3163copywmQWz5c$default(color3, 0.24f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    $dirty &= -897;
                } else {
                    backgroundColor3 = j2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier4 = modifier2;
                color3 = j;
                backgroundColor3 = j2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-819397058, $dirty, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:205)");
            }
            m1573LinearProgressIndicator2cYBFYY(modifier4, color3, backgroundColor3, StrokeCap.Companion.m3547getButtKaPHkGw(), $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i6 = $dirty;
            modifier3 = modifier4;
            color2 = color3;
            backgroundColor2 = backgroundColor3;
        } else {
            $composer2.skipToGroupEnd();
            int i7 = $dirty;
            backgroundColor2 = j2;
            modifier3 = modifier2;
            color2 = j;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new ProgressIndicatorKt$LinearProgressIndicator$6(modifier3, color2, backgroundColor2, $changed, i));
    }

    /* access modifiers changed from: private */
    /* renamed from: drawLinearIndicator-qYKTg0g  reason: not valid java name */
    public static final void m1586drawLinearIndicatorqYKTg0g(DrawScope $this$drawLinearIndicator_u2dqYKTg0g, float startFraction, float endFraction, long color, float strokeWidth, int strokeCap) {
        float width = Size.m2984getWidthimpl($this$drawLinearIndicator_u2dqYKTg0g.m3772getSizeNHjbRc());
        float height = Size.m2981getHeightimpl($this$drawLinearIndicator_u2dqYKTg0g.m3772getSizeNHjbRc());
        float f = (float) 2;
        float yOffset = height / f;
        boolean isLtr = $this$drawLinearIndicator_u2dqYKTg0g.getLayoutDirection() == LayoutDirection.Ltr;
        float barStart = (isLtr ? startFraction : 1.0f - endFraction) * width;
        float barEnd = (isLtr ? endFraction : 1.0f - startFraction) * width;
        if (StrokeCap.m3543equalsimpl0(strokeCap, StrokeCap.Companion.m3547getButtKaPHkGw()) || height > width) {
            DrawScope.m3740drawLineNGM6Ib0$default($this$drawLinearIndicator_u2dqYKTg0g, color, OffsetKt.Offset(barStart, yOffset), OffsetKt.Offset(barEnd, yOffset), strokeWidth, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
            return;
        }
        float strokeCapOffset = strokeWidth / f;
        ClosedFloatingPointRange coerceRange = RangesKt.rangeTo(strokeCapOffset, width - strokeCapOffset);
        float adjustedBarStart = ((Number) RangesKt.coerceIn(Float.valueOf(barStart), coerceRange)).floatValue();
        float adjustedBarEnd = ((Number) RangesKt.coerceIn(Float.valueOf(barEnd), coerceRange)).floatValue();
        if (Math.abs(endFraction - startFraction) > 0.0f) {
            float f2 = adjustedBarStart;
            float f3 = adjustedBarEnd;
            DrawScope.m3740drawLineNGM6Ib0$default($this$drawLinearIndicator_u2dqYKTg0g, color, OffsetKt.Offset(adjustedBarStart, yOffset), OffsetKt.Offset(adjustedBarEnd, yOffset), strokeWidth, strokeCap, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
            return;
        }
        float f4 = adjustedBarEnd;
    }

    /* access modifiers changed from: private */
    /* renamed from: drawLinearIndicatorBackground-AZGd3zU  reason: not valid java name */
    public static final void m1587drawLinearIndicatorBackgroundAZGd3zU(DrawScope $this$drawLinearIndicatorBackground_u2dAZGd3zU, long color, float strokeWidth, int strokeCap) {
        m1586drawLinearIndicatorqYKTg0g($this$drawLinearIndicatorBackground_u2dAZGd3zU, 0.0f, 1.0f, color, strokeWidth, strokeCap);
    }

    /* renamed from: CircularProgressIndicator-DUhRLBM  reason: not valid java name */
    public static final void m1569CircularProgressIndicatorDUhRLBM(float progress, Modifier modifier, long color, float strokeWidth, long backgroundColor, int strokeCap, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        float strokeWidth2;
        long backgroundColor2;
        int i2;
        int strokeCap2;
        long backgroundColor3;
        float strokeWidth3;
        long color2;
        Modifier modifier3;
        int $dirty;
        int strokeCap3;
        long backgroundColor4;
        float strokeWidth4;
        long color3;
        Modifier modifier4;
        long color4;
        int i3;
        int i4;
        float f = progress;
        int i5 = $changed;
        Composer $composer2 = $composer.startRestartGroup(1746618448);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(3,2,1:c#ui.graphics.Color,5:c#ui.unit.Dp,0:c#ui.graphics.Color,4:c#ui.graphics.StrokeCap)289@11632L6,*295@11891L7,298@11972L375:ProgressIndicator.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i5 & 14) == 0) {
            $dirty2 |= $composer2.changed(f) ? 4 : 2;
        }
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if ((i5 & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i5 & 896) == 0) {
            if ((i & 4) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i4 = 256;
                    $dirty2 |= i4;
                }
            } else {
                j = color;
            }
            i4 = 128;
            $dirty2 |= i4;
        } else {
            j = color;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            strokeWidth2 = strokeWidth;
        } else if ((i5 & 7168) == 0) {
            strokeWidth2 = strokeWidth;
            $dirty2 |= $composer2.changed(strokeWidth2) ? 2048 : 1024;
        } else {
            strokeWidth2 = strokeWidth;
        }
        int i8 = i & 16;
        if (i8 != 0) {
            $dirty2 |= 24576;
            backgroundColor2 = backgroundColor;
        } else if ((57344 & i5) == 0) {
            backgroundColor2 = backgroundColor;
            $dirty2 |= $composer2.changed(backgroundColor2) ? 16384 : 8192;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((458752 & i5) == 0) {
            if ((i & 32) == 0) {
                i2 = strokeCap;
                if ($composer2.changed(i2)) {
                    i3 = 131072;
                    $dirty2 |= i3;
                }
            } else {
                i2 = strokeCap;
            }
            i3 = 65536;
            $dirty2 |= i3;
        } else {
            i2 = strokeCap;
        }
        if ((374491 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i5 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 4) != 0) {
                    color4 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1445getPrimary0d7_KjU();
                    $dirty2 &= -897;
                } else {
                    color4 = j;
                }
                if (i7 != 0) {
                    strokeWidth2 = ProgressIndicatorDefaults.INSTANCE.m1568getStrokeWidthD9Ej5fM();
                }
                if (i8 != 0) {
                    backgroundColor2 = Color.Companion.m3199getTransparent0d7_KjU();
                }
                if ((i & 32) != 0) {
                    $dirty = $dirty2 & -458753;
                    strokeCap3 = StrokeCap.Companion.m3547getButtKaPHkGw();
                    backgroundColor4 = backgroundColor2;
                    color3 = color4;
                    strokeWidth4 = strokeWidth2;
                } else {
                    $dirty = $dirty2;
                    strokeCap3 = i2;
                    backgroundColor4 = backgroundColor2;
                    color3 = color4;
                    strokeWidth4 = strokeWidth2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 32) != 0) {
                    $dirty = $dirty2 & -458753;
                    modifier4 = modifier2;
                    strokeCap3 = i2;
                    backgroundColor4 = backgroundColor2;
                    color3 = j;
                    strokeWidth4 = strokeWidth2;
                } else {
                    $dirty = $dirty2;
                    modifier4 = modifier2;
                    strokeCap3 = i2;
                    backgroundColor4 = backgroundColor2;
                    color3 = j;
                    strokeWidth4 = strokeWidth2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1746618448, i5, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:285)");
            }
            float coercedProgress = RangesKt.coerceIn(f, 0.0f, 1.0f);
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier5 = modifier4;
            CanvasKt.Canvas(SizeKt.m830size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier5, coercedProgress, (ClosedFloatingPointRange) null, 0, 6, (Object) null), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$1(coercedProgress, backgroundColor4, new Stroke(((Density) consume).m5967toPx0680j_4(strokeWidth4), 0.0f, strokeCap3, 0, (PathEffect) null, 26, (DefaultConstructorMarker) null), color3), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            strokeCap2 = strokeCap3;
            int i9 = $dirty;
            strokeWidth3 = strokeWidth4;
            backgroundColor3 = backgroundColor4;
            modifier3 = modifier5;
            color2 = color3;
        } else {
            $composer2.skipToGroupEnd();
            int i10 = $dirty2;
            color2 = j;
            strokeWidth3 = strokeWidth2;
            backgroundColor3 = backgroundColor2;
            strokeCap2 = i2;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$2(progress, modifier3, color2, strokeWidth3, backgroundColor3, strokeCap2, $changed, i));
        }
    }

    /* renamed from: CircularProgressIndicator-LxG7B9w  reason: not valid java name */
    public static final void m1570CircularProgressIndicatorLxG7B9w(Modifier modifier, long color, float strokeWidth, long backgroundColor, int strokeCap, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        float strokeWidth2;
        long backgroundColor2;
        int i2;
        int strokeCap2;
        long backgroundColor3;
        float strokeWidth3;
        long color2;
        Modifier modifier3;
        int $dirty;
        long backgroundColor4;
        long color3;
        Modifier modifier4;
        int $dirty2;
        int i3;
        int i4;
        int i5 = $changed;
        Composer $composer2 = $composer.startRestartGroup(-1119119072);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(2,1:c#ui.graphics.Color,4:c#ui.unit.Dp,0:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)328@13340L6,*333@13549L7,337@13648L28,339@13806L278,351@14199L230,362@14547L345,374@14927L354,385@15286L647:ProgressIndicator.kt#jmzs0o");
        int $dirty3 = $changed;
        int i6 = i & 1;
        if (i6 != 0) {
            $dirty3 |= 6;
            modifier2 = modifier;
        } else if ((i5 & 14) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i5 & 112) == 0) {
            if ((i & 2) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i4 = 32;
                    $dirty3 |= i4;
                }
            } else {
                j = color;
            }
            i4 = 16;
            $dirty3 |= i4;
        } else {
            j = color;
        }
        int i7 = i & 4;
        if (i7 != 0) {
            $dirty3 |= 384;
            strokeWidth2 = strokeWidth;
        } else if ((i5 & 896) == 0) {
            strokeWidth2 = strokeWidth;
            $dirty3 |= $composer2.changed(strokeWidth2) ? 256 : 128;
        } else {
            strokeWidth2 = strokeWidth;
        }
        int i8 = i & 8;
        if (i8 != 0) {
            $dirty3 |= 3072;
            backgroundColor2 = backgroundColor;
        } else if ((i5 & 7168) == 0) {
            backgroundColor2 = backgroundColor;
            $dirty3 |= $composer2.changed(backgroundColor2) ? 2048 : 1024;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((57344 & i5) == 0) {
            if ((i & 16) == 0) {
                i2 = strokeCap;
                if ($composer2.changed(i2)) {
                    i3 = 16384;
                    $dirty3 |= i3;
                }
            } else {
                i2 = strokeCap;
            }
            i3 = 8192;
            $dirty3 |= i3;
        } else {
            i2 = strokeCap;
        }
        if ((46811 & $dirty3) != 9362 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i5 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 2) != 0) {
                    color3 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1445getPrimary0d7_KjU();
                    $dirty3 &= -113;
                } else {
                    color3 = j;
                }
                if (i7 != 0) {
                    strokeWidth2 = ProgressIndicatorDefaults.INSTANCE.m1568getStrokeWidthD9Ej5fM();
                }
                if (i8 != 0) {
                    backgroundColor2 = Color.Companion.m3199getTransparent0d7_KjU();
                }
                if ((i & 16) != 0) {
                    $dirty = $dirty3 & -57345;
                    $dirty2 = StrokeCap.Companion.m3549getSquareKaPHkGw();
                    backgroundColor4 = backgroundColor2;
                } else {
                    $dirty = $dirty3;
                    backgroundColor4 = backgroundColor2;
                    $dirty2 = i2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty3 &= -113;
                }
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                $dirty = $dirty3;
                modifier4 = modifier2;
                color3 = j;
                backgroundColor4 = backgroundColor2;
                $dirty2 = i2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1119119072, i5, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:326)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            InfiniteTransition transition = InfiniteTransitionKt.rememberInfiniteTransition($composer2, 0);
            TwoWayConverter<Integer, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE);
            strokeCap2 = $dirty2;
            int i9 = $dirty;
            Stroke stroke = new Stroke(((Density) consume).m5967toPx0680j_4(strokeWidth2), 0.0f, $dirty2, 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
            State currentRotation$delegate = InfiniteTransitionKt.animateValue(transition, (Object) null, 5, vectorConverter, AnimationSpecKt.m389infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0, 6, (Object) null), $composer2, InfiniteTransition.$stable | 4528 | (InfiniteRepeatableSpec.$stable << 12));
            State state = currentRotation$delegate;
            CanvasKt.Canvas(SizeKt.m830size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier4), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$3(backgroundColor4, stroke, strokeWidth2, color3, currentRotation$delegate, InfiniteTransitionKt.animateFloat(transition, 0.0f, JumpRotationAngle, AnimationSpecKt.m389infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$endAngle$2.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9)), InfiniteTransitionKt.animateFloat(transition, 0.0f, JumpRotationAngle, AnimationSpecKt.m389infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$startAngle$2.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9)), InfiniteTransitionKt.animateFloat(transition, 0.0f, BaseRotationAngle, AnimationSpecKt.m389infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0, 6, (Object) null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9))), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            color2 = color3;
            backgroundColor3 = backgroundColor4;
            strokeWidth3 = strokeWidth2;
        } else {
            $composer2.skipToGroupEnd();
            int i10 = $dirty3;
            modifier3 = modifier2;
            backgroundColor3 = backgroundColor2;
            strokeCap2 = i2;
            color2 = j;
            strokeWidth3 = strokeWidth2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Modifier modifier5 = modifier3;
            return;
        }
        Modifier modifier6 = modifier3;
        endRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$4(modifier3, color2, strokeWidth3, backgroundColor3, strokeCap2, $changed, i));
    }

    /* access modifiers changed from: private */
    public static final int CircularProgressIndicator_LxG7B9w$lambda$8(State<Integer> $currentRotation$delegate) {
        return ((Number) $currentRotation$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public static final float CircularProgressIndicator_LxG7B9w$lambda$9(State<Float> $baseRotation$delegate) {
        return ((Number) $baseRotation$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final float CircularProgressIndicator_LxG7B9w$lambda$10(State<Float> $endAngle$delegate) {
        return ((Number) $endAngle$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final float CircularProgressIndicator_LxG7B9w$lambda$11(State<Float> $startAngle$delegate) {
        return ((Number) $startAngle$delegate.getValue()).floatValue();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-MBs18nI  reason: not valid java name */
    public static final /* synthetic */ void m1571CircularProgressIndicatorMBs18nI(float progress, Modifier modifier, long color, float strokeWidth, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        float f;
        float strokeWidth2;
        long color2;
        Modifier modifier3;
        float strokeWidth3;
        long color3;
        Modifier modifier4;
        int i2;
        int i3 = $changed;
        Composer $composer2 = $composer.startRestartGroup(-409649739);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.unit.Dp)408@16153L6,410@16233L157:ProgressIndicator.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            float f2 = progress;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer2.changed(progress) ? 4 : 2;
        } else {
            float f3 = progress;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i3 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i3 & 896) == 0) {
            if ((i & 4) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                j = color;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            j = color;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            f = strokeWidth;
        } else if ((i3 & 7168) == 0) {
            f = strokeWidth;
            $dirty |= $composer2.changed(f) ? 2048 : 1024;
        } else {
            f = strokeWidth;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i3 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 4) != 0) {
                    color3 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1445getPrimary0d7_KjU();
                    $dirty &= -897;
                } else {
                    color3 = j;
                }
                strokeWidth3 = i5 != 0 ? ProgressIndicatorDefaults.INSTANCE.m1568getStrokeWidthD9Ej5fM() : f;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier4 = modifier2;
                color3 = j;
                strokeWidth3 = f;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-409649739, $dirty, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:405)");
            }
            m1569CircularProgressIndicatorDUhRLBM(progress, modifier4, color3, strokeWidth3, Color.Companion.m3199getTransparent0d7_KjU(), StrokeCap.Companion.m3547getButtKaPHkGw(), $composer2, ($dirty & 14) | 24576 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i6 = $dirty;
            modifier3 = modifier4;
            color2 = color3;
            strokeWidth2 = strokeWidth3;
        } else {
            $composer2.skipToGroupEnd();
            int i7 = $dirty;
            modifier3 = modifier2;
            strokeWidth2 = f;
            color2 = j;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$5(progress, modifier3, color2, strokeWidth2, $changed, i));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-aM-cp0Q  reason: not valid java name */
    public static final /* synthetic */ void m1572CircularProgressIndicatoraMcp0Q(Modifier modifier, long color, float strokeWidth, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        float f;
        float strokeWidth2;
        long color2;
        Modifier modifier3;
        float strokeWidth3;
        long color3;
        Modifier modifier4;
        int i2;
        int i3 = $changed;
        Composer $composer2 = $composer.startRestartGroup(-392089979);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.unit.Dp)423@16587L6,425@16667L145:ProgressIndicator.kt#jmzs0o");
        int $dirty = $changed;
        int i4 = i & 1;
        if (i4 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if ((i3 & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i3 & 112) == 0) {
            if ((i & 2) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i2 = 32;
                    $dirty |= i2;
                }
            } else {
                j = color;
            }
            i2 = 16;
            $dirty |= i2;
        } else {
            j = color;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            f = strokeWidth;
        } else if ((i3 & 896) == 0) {
            f = strokeWidth;
            $dirty |= $composer2.changed(f) ? 256 : 128;
        } else {
            f = strokeWidth;
        }
        if (($dirty & 731) != 146 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i3 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 2) != 0) {
                    color3 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1445getPrimary0d7_KjU();
                    $dirty &= -113;
                } else {
                    color3 = j;
                }
                strokeWidth3 = i5 != 0 ? ProgressIndicatorDefaults.INSTANCE.m1568getStrokeWidthD9Ej5fM() : f;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                modifier4 = modifier2;
                color3 = j;
                strokeWidth3 = f;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-392089979, $dirty, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:421)");
            }
            m1570CircularProgressIndicatorLxG7B9w(modifier4, color3, strokeWidth3, Color.Companion.m3199getTransparent0d7_KjU(), StrokeCap.Companion.m3549getSquareKaPHkGw(), $composer2, ($dirty & 14) | 3072 | ($dirty & 112) | ($dirty & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i6 = $dirty;
            modifier3 = modifier4;
            color2 = color3;
            strokeWidth2 = strokeWidth3;
        } else {
            $composer2.skipToGroupEnd();
            int i7 = $dirty;
            modifier3 = modifier2;
            strokeWidth2 = f;
            color2 = j;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$6(modifier3, color2, strokeWidth2, $changed, i));
    }

    /* renamed from: drawCircularIndicator-42QJj7c  reason: not valid java name */
    private static final void m1582drawCircularIndicator42QJj7c(DrawScope $this$drawCircularIndicator_u2d42QJj7c, float startAngle, float sweep, long color, Stroke stroke) {
        float f = (float) 2;
        float diameterOffset = stroke.getWidth() / f;
        float arcDimen = Size.m2984getWidthimpl($this$drawCircularIndicator_u2d42QJj7c.m3772getSizeNHjbRc()) - (f * diameterOffset);
        DrawScope.m3733drawArcyD3GUKo$default($this$drawCircularIndicator_u2d42QJj7c, color, startAngle, sweep, false, OffsetKt.Offset(diameterOffset, diameterOffset), androidx.compose.ui.geometry.SizeKt.Size(arcDimen, arcDimen), 0.0f, stroke, (ColorFilter) null, 0, 832, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawCircularIndicatorBackground-bw27NRU  reason: not valid java name */
    public static final void m1583drawCircularIndicatorBackgroundbw27NRU(DrawScope $this$drawCircularIndicatorBackground_u2dbw27NRU, long color, Stroke stroke) {
        m1582drawCircularIndicator42QJj7c($this$drawCircularIndicatorBackground_u2dbw27NRU, 0.0f, 360.0f, color, stroke);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawDeterminateCircularIndicator-42QJj7c  reason: not valid java name */
    public static final void m1584drawDeterminateCircularIndicator42QJj7c(DrawScope $this$drawDeterminateCircularIndicator_u2d42QJj7c, float startAngle, float sweep, long color, Stroke stroke) {
        m1582drawCircularIndicator42QJj7c($this$drawDeterminateCircularIndicator_u2d42QJj7c, startAngle, sweep, color, stroke);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawIndeterminateCircularIndicator-hrjfTZI  reason: not valid java name */
    public static final void m1585drawIndeterminateCircularIndicatorhrjfTZI(DrawScope $this$drawIndeterminateCircularIndicator_u2dhrjfTZI, float startAngle, float strokeWidth, float sweep, long color, Stroke stroke) {
        float strokeCapOffset;
        if (StrokeCap.m3543equalsimpl0(stroke.m3852getCapKaPHkGw(), StrokeCap.Companion.m3547getButtKaPHkGw())) {
            strokeCapOffset = 0.0f;
        } else {
            strokeCapOffset = ((strokeWidth / Dp.m5986constructorimpl(CircularIndicatorDiameter / ((float) 2))) * 57.29578f) / 2.0f;
        }
        m1582drawCircularIndicator42QJj7c($this$drawIndeterminateCircularIndicator_u2dhrjfTZI, startAngle + strokeCapOffset, Math.max(sweep, 0.1f), color, stroke);
    }
}
