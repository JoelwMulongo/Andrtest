package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.CircularProgressIndicatorTokens;
import androidx.compose.material3.tokens.LinearProgressIndicatorTokens;
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
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a3\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u0005H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a;\u0010\"\u001a\u00020#2\u0006\u0010+\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u0005H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a3\u0010.\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010/\u001a\u00020'H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a;\u0010.\u001a\u00020#2\u0006\u0010+\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010/\u001a\u00020'H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a9\u00104\u001a\u00020#*\u0002052\u0006\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a9\u0010<\u001a\u00020#*\u0002052\u0006\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010;\u001aA\u0010>\u001a\u00020#*\u0002052\u0006\u00106\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a9\u0010A\u001a\u00020#*\u0002052\u0006\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001a)\u0010F\u001a\u00020#*\u0002052\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010H\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0014\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0015\u0010\u0007\"\u0019\u0010\u0016\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0007\"\u000e\u0010\u0018\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006I"}, d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "getCircularIndicatorDiameter", "()F", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "getLinearIndicatorHeight", "LinearIndicatorWidth", "getLinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "StartAngleOffset", "CircularProgressIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "progress", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "trackColor", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJF)V", "drawLinearIndicatorTrack", "drawLinearIndicatorTrack-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JF)V", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ProgressIndicator.kt */
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
    private static final float CircularIndicatorDiameter = Dp.m5986constructorimpl(CircularProgressIndicatorTokens.INSTANCE.m2296getSizeD9Ej5fM() - Dp.m5986constructorimpl(((float) 2) * CircularProgressIndicatorTokens.INSTANCE.m2295getActiveIndicatorWidthD9Ej5fM()));
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
    private static final float LinearIndicatorHeight = LinearProgressIndicatorTokens.INSTANCE.m2502getTrackHeightD9Ej5fM();
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

    /* JADX WARNING: Removed duplicated region for block: B:82:0x018c  */
    /* renamed from: LinearProgressIndicator-eaDK9VM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2039LinearProgressIndicatoreaDK9VM(float r22, androidx.compose.ui.Modifier r23, long r24, long r26, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r9 = r29
            r0 = -372717133(0xffffffffe9c8c9b3, float:-3.0342208E25)
            r1 = r28
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.graphics.Color)74@3452L11,75@3515L16,81@3676L165,77@3541L300:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r29
            r2 = r30 & 1
            if (r2 == 0) goto L_0x001b
            r1 = r1 | 6
            r11 = r22
            goto L_0x002e
        L_0x001b:
            r2 = r9 & 14
            if (r2 != 0) goto L_0x002c
            r11 = r22
            boolean r2 = r10.changed((float) r11)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r1 = r1 | r2
            goto L_0x002e
        L_0x002c:
            r11 = r22
        L_0x002e:
            r2 = r30 & 2
            if (r2 == 0) goto L_0x0037
            r1 = r1 | 48
            r3 = r23
            goto L_0x004c
        L_0x0037:
            r3 = r9 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004a
            r3 = r23
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0046
            r4 = 32
            goto L_0x0048
        L_0x0046:
            r4 = 16
        L_0x0048:
            r1 = r1 | r4
            goto L_0x004c
        L_0x004a:
            r3 = r23
        L_0x004c:
            r4 = r9 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0065
            r4 = r30 & 4
            if (r4 != 0) goto L_0x005f
            r4 = r24
            boolean r6 = r10.changed((long) r4)
            if (r6 == 0) goto L_0x0061
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x005f:
            r4 = r24
        L_0x0061:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r1 = r1 | r6
            goto L_0x0067
        L_0x0065:
            r4 = r24
        L_0x0067:
            r6 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0080
            r6 = r30 & 8
            if (r6 != 0) goto L_0x007a
            r6 = r26
            boolean r8 = r10.changed((long) r6)
            if (r8 == 0) goto L_0x007c
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007a:
            r6 = r26
        L_0x007c:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r1 = r1 | r8
            goto L_0x0082
        L_0x0080:
            r6 = r26
        L_0x0082:
            r8 = r1 & 5851(0x16db, float:8.199E-42)
            r12 = 1170(0x492, float:1.64E-42)
            if (r8 != r12) goto L_0x009a
            boolean r8 = r10.getSkipping()
            if (r8 != 0) goto L_0x008f
            goto L_0x009a
        L_0x008f:
            r10.skipToGroupEnd()
            r18 = r1
            r21 = r3
            r12 = r4
            r14 = r6
            goto L_0x0191
        L_0x009a:
            r10.startDefaults()
            r8 = r9 & 1
            if (r8 == 0) goto L_0x00ba
            boolean r8 = r10.getDefaultsInvalid()
            if (r8 == 0) goto L_0x00a8
            goto L_0x00ba
        L_0x00a8:
            r10.skipToGroupEnd()
            r2 = r30 & 4
            if (r2 == 0) goto L_0x00b1
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00b1:
            r2 = r30 & 8
            if (r2 == 0) goto L_0x00b7
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00b7:
            r2 = r3
            r3 = r4
            goto L_0x00de
        L_0x00ba:
            if (r2 == 0) goto L_0x00c1
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00c2
        L_0x00c1:
            r2 = r3
        L_0x00c2:
            r3 = r30 & 4
            r8 = 6
            if (r3 == 0) goto L_0x00d0
            androidx.compose.material3.ProgressIndicatorDefaults r3 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r3 = r3.getLinearColor(r10, r8)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x00d1
        L_0x00d0:
            r3 = r4
        L_0x00d1:
            r5 = r30 & 8
            if (r5 == 0) goto L_0x00de
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r5 = r5.getLinearTrackColor(r10, r8)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r6 = r5
        L_0x00de:
            r10.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x00ed
            r5 = -1
            java.lang.String r8 = "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:71)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r5, r8)
        L_0x00ed:
            r0 = 0
            r5 = 0
            r8 = 6
            r12 = 0
            r23 = r2
            r24 = r22
            r25 = r0
            r26 = r5
            r27 = r8
            r28 = r12
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ProgressSemanticsKt.progressSemantics$default(r23, r24, r25, r26, r27, r28)
            float r5 = LinearIndicatorWidth
            float r8 = LinearIndicatorHeight
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m832sizeVpY3zN4(r0, r5, r8)
            androidx.compose.ui.graphics.Color r5 = androidx.compose.ui.graphics.Color.m3154boximpl(r6)
            java.lang.Float r8 = java.lang.Float.valueOf(r22)
            androidx.compose.ui.graphics.Color r12 = androidx.compose.ui.graphics.Color.m3154boximpl(r3)
            int r13 = r1 >> 9
            r13 = r13 & 14
            int r14 = r1 << 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            r13 = r13 | r14
            r14 = r1 & 896(0x380, float:1.256E-42)
            r13 = r13 | r14
            r14 = 0
            r15 = 1618982084(0x607fb4c4, float:7.370227E19)
            r10.startReplaceableGroup(r15)
            java.lang.String r15 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r15)
            boolean r15 = r10.changed((java.lang.Object) r5)
            boolean r16 = r10.changed((java.lang.Object) r8)
            r15 = r15 | r16
            boolean r16 = r10.changed((java.lang.Object) r12)
            r15 = r15 | r16
            r16 = r10
            r17 = 0
            r18 = r1
            java.lang.Object r1 = r16.rememberedValue()
            r19 = 0
            if (r15 != 0) goto L_0x015f
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r2
            java.lang.Object r2 = r20.getEmpty()
            if (r1 != r2) goto L_0x0158
            goto L_0x0161
        L_0x0158:
            r23 = r1
            r2 = r23
            r1 = r16
            goto L_0x017b
        L_0x015f:
            r21 = r2
        L_0x0161:
            r2 = 0
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$1$1 r20 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$1$1
            r23 = r20
            r24 = r6
            r26 = r22
            r27 = r3
            r23.<init>(r24, r26, r27)
            r2 = r20
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r23 = r1
            r1 = r16
            r1.updateRememberedValue(r2)
        L_0x017b:
            r10.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r1 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r0, r2, r10, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x018f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x018f:
            r12 = r3
            r14 = r6
        L_0x0191:
            androidx.compose.runtime.ScopeUpdateScope r8 = r10.endRestartGroup()
            if (r8 != 0) goto L_0x0198
            goto L_0x01b1
        L_0x0198:
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$2 r16 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$2
            r0 = r16
            r1 = r22
            r2 = r21
            r3 = r12
            r5 = r14
            r7 = r29
            r9 = r8
            r8 = r30
            r0.<init>(r1, r2, r3, r5, r7, r8)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x01b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2039LinearProgressIndicatoreaDK9VM(float, androidx.compose.ui.Modifier, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: LinearProgressIndicator-RIQooxk  reason: not valid java name */
    public static final void m2038LinearProgressIndicatorRIQooxk(Modifier modifier, long color, long trackColor, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        long trackColor2;
        long trackColor3;
        long color2;
        Modifier modifier3;
        long color3;
        Modifier modifier4;
        int $dirty;
        Modifier modifier5;
        int i2;
        int i3;
        int i4 = $changed;
        Composer $composer2 = $composer.startRestartGroup(585576195);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.graphics.Color)105@4751L11,106@4814L16,108@4865L28,112@5147L319,123@5510L319,134@5874L323,145@6242L323,160@6697L593,156@6570L720:ProgressIndicator.kt#uh7d8r");
        int $dirty2 = $changed;
        int i5 = i & 1;
        if (i5 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if ((i4 & 14) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i4 & 112) == 0) {
            if ((i & 2) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i3 = 32;
                    $dirty2 |= i3;
                }
            } else {
                j = color;
            }
            i3 = 16;
            $dirty2 |= i3;
        } else {
            j = color;
        }
        if ((i4 & 896) == 0) {
            if ((i & 4) == 0) {
                trackColor2 = trackColor;
                if ($composer2.changed(trackColor2)) {
                    i2 = 256;
                    $dirty2 |= i2;
                }
            } else {
                trackColor2 = trackColor;
            }
            i2 = 128;
            $dirty2 |= i2;
        } else {
            trackColor2 = trackColor;
        }
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i4 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 2) != 0) {
                    color3 = ProgressIndicatorDefaults.INSTANCE.getLinearColor($composer2, 6);
                    $dirty2 &= -113;
                } else {
                    color3 = j;
                }
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                    trackColor2 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor($composer2, 6);
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                modifier4 = modifier2;
                color3 = j;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(585576195, i4, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:103)");
            }
            InfiniteTransition infiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition($composer2, 0);
            State firstLineHead = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m389infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$1.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            State firstLineTail = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m389infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$1.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            State secondLineHead = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m389infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            State secondLineTail = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m389infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            Modifier r15 = SizeKt.m832sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(modifier4), LinearIndicatorWidth, LinearIndicatorHeight);
            Object[] keys$iv = {Color.m3154boximpl(trackColor2), firstLineHead, firstLineTail, Color.m3154boximpl(color3), secondLineHead, secondLineTail};
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
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
                value$iv$iv = new ProgressIndicatorKt$LinearProgressIndicator$3$1(trackColor2, firstLineHead, firstLineTail, color3, secondLineHead, secondLineTail);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                $dirty = $dirty2;
                Object obj2 = value$iv$iv;
                Composer composer = $this$cache$iv$iv;
                Object[] objArr2 = keys$iv;
                modifier5 = r15;
            }
            $composer2.endReplaceableGroup();
            CanvasKt.Canvas(modifier5, (Function1) value$iv$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i6 = $dirty;
            modifier3 = modifier4;
            color2 = color3;
            trackColor3 = trackColor2;
        } else {
            $composer2.skipToGroupEnd();
            int i7 = $dirty2;
            modifier3 = modifier2;
            color2 = j;
            trackColor3 = trackColor2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ProgressIndicatorKt$LinearProgressIndicator$4(modifier3, color2, trackColor3, $changed, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: drawLinearIndicator-42QJj7c  reason: not valid java name */
    public static final void m2047drawLinearIndicator42QJj7c(DrawScope $this$drawLinearIndicator_u2d42QJj7c, float startFraction, float endFraction, long color, float strokeWidth) {
        float width = Size.m2984getWidthimpl($this$drawLinearIndicator_u2d42QJj7c.m3772getSizeNHjbRc());
        float yOffset = Size.m2981getHeightimpl($this$drawLinearIndicator_u2d42QJj7c.m3772getSizeNHjbRc()) / ((float) 2);
        boolean isLtr = $this$drawLinearIndicator_u2d42QJj7c.getLayoutDirection() == LayoutDirection.Ltr;
        DrawScope.m3740drawLineNGM6Ib0$default($this$drawLinearIndicator_u2d42QJj7c, color, OffsetKt.Offset((isLtr ? startFraction : 1.0f - endFraction) * width, yOffset), OffsetKt.Offset((isLtr ? endFraction : 1.0f - startFraction) * width, yOffset), strokeWidth, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawLinearIndicatorTrack-bw27NRU  reason: not valid java name */
    public static final void m2048drawLinearIndicatorTrackbw27NRU(DrawScope $this$drawLinearIndicatorTrack_u2dbw27NRU, long color, float strokeWidth) {
        m2047drawLinearIndicator42QJj7c($this$drawLinearIndicatorTrack_u2dbw27NRU, 0.0f, 1.0f, color, strokeWidth);
    }

    /* renamed from: CircularProgressIndicator-MBs18nI  reason: not valid java name */
    public static final void m2036CircularProgressIndicatorMBs18nI(float progress, Modifier modifier, long color, float strokeWidth, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        float strokeWidth2;
        float strokeWidth3;
        long color2;
        Modifier modifier3;
        int $dirty;
        long color3;
        Modifier modifier4;
        Modifier modifier5;
        long color4;
        int i2;
        float f = progress;
        int i3 = $changed;
        Composer $composer2 = $composer.startRestartGroup(402841196);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.unit.Dp)229@9297L13,*232@9419L7,235@9505L296:ProgressIndicator.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty2 |= $composer2.changed(f) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if ((i3 & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i3 & 896) == 0) {
            if ((i & 4) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i2 = 256;
                    $dirty2 |= i2;
                }
            } else {
                j = color;
            }
            i2 = 128;
            $dirty2 |= i2;
        } else {
            j = color;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            strokeWidth2 = strokeWidth;
        } else if ((i3 & 7168) == 0) {
            strokeWidth2 = strokeWidth;
            $dirty2 |= $composer2.changed(strokeWidth2) ? 2048 : 1024;
        } else {
            strokeWidth2 = strokeWidth;
        }
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i3 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier5 = Modifier.Companion;
                } else {
                    modifier5 = modifier2;
                }
                if ((i & 4) != 0) {
                    color4 = ProgressIndicatorDefaults.INSTANCE.getCircularColor($composer2, 6);
                    $dirty2 &= -897;
                } else {
                    color4 = j;
                }
                if (i5 != 0) {
                    $dirty = $dirty2;
                    modifier4 = modifier5;
                    color3 = color4;
                    strokeWidth2 = ProgressIndicatorDefaults.INSTANCE.m2035getCircularStrokeWidthD9Ej5fM();
                } else {
                    $dirty = $dirty2;
                    modifier4 = modifier5;
                    color3 = color4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                $dirty = $dirty2;
                modifier4 = modifier2;
                color3 = j;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(402841196, i3, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:226)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(SizeKt.m830size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier4, progress, (ClosedFloatingPointRange) null, 0, 6, (Object) null), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$1(f, color3, new Stroke(((Density) consume).m5967toPx0680j_4(strokeWidth2), 0.0f, StrokeCap.Companion.m3547getButtKaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null)), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            strokeWidth3 = strokeWidth2;
            int i6 = $dirty;
            color2 = color3;
            modifier3 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
            int i7 = $dirty2;
            modifier3 = modifier2;
            color2 = j;
            strokeWidth3 = strokeWidth2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$2(progress, modifier3, color2, strokeWidth3, $changed, i));
        }
    }

    /* renamed from: CircularProgressIndicator-aM-cp0Q  reason: not valid java name */
    public static final void m2037CircularProgressIndicatoraMcp0Q(Modifier modifier, long color, float strokeWidth, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        float strokeWidth2;
        long color2;
        Modifier modifier3;
        float strokeWidth3;
        Modifier modifier4;
        long color3;
        int i2;
        int i3 = $changed;
        Composer $composer2 = $composer.startRestartGroup(947193756);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.unit.Dp)263@10638L13,*266@10760L7,270@10866L28,272@11023L278,284@11415L230,295@11762L345,306@12140L354,317@12499L681:ProgressIndicator.kt#uh7d8r");
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
            strokeWidth2 = strokeWidth;
        } else if ((i3 & 896) == 0) {
            strokeWidth2 = strokeWidth;
            $dirty |= $composer2.changed(strokeWidth2) ? 256 : 128;
        } else {
            strokeWidth2 = strokeWidth;
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
                    color3 = ProgressIndicatorDefaults.INSTANCE.getCircularColor($composer2, 6);
                    $dirty &= -113;
                } else {
                    color3 = j;
                }
                if (i5 != 0) {
                    strokeWidth3 = ProgressIndicatorDefaults.INSTANCE.m2035getCircularStrokeWidthD9Ej5fM();
                    int i6 = $dirty;
                    modifier3 = modifier4;
                    color2 = color3;
                } else {
                    int i7 = $dirty;
                    modifier3 = modifier4;
                    color2 = color3;
                    strokeWidth3 = strokeWidth2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                int i8 = $dirty;
                modifier3 = modifier2;
                color2 = j;
                strokeWidth3 = strokeWidth2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(947193756, i3, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:261)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Stroke stroke = new Stroke(((Density) consume).m5967toPx0680j_4(strokeWidth3), 0.0f, StrokeCap.Companion.m3549getSquareKaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
            InfiniteTransition transition = InfiniteTransitionKt.rememberInfiniteTransition($composer2, 0);
            float strokeWidth4 = strokeWidth3;
            CanvasKt.Canvas(SizeKt.m830size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$3(InfiniteTransitionKt.animateValue(transition, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m389infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0, 6, (Object) null), $composer2, InfiniteTransition.$stable | 4528 | (InfiniteRepeatableSpec.$stable << 12)), InfiniteTransitionKt.animateFloat(transition, 0.0f, JumpRotationAngle, AnimationSpecKt.m389infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$endAngle$1.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9)), InfiniteTransitionKt.animateFloat(transition, 0.0f, JumpRotationAngle, AnimationSpecKt.m389infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$startAngle$1.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9)), InfiniteTransitionKt.animateFloat(transition, 0.0f, BaseRotationAngle, AnimationSpecKt.m389infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0, 6, (Object) null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9)), strokeWidth4, color2, stroke), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            strokeWidth2 = strokeWidth4;
        } else {
            $composer2.skipToGroupEnd();
            int i9 = $dirty;
            modifier3 = modifier2;
            color2 = j;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$4(modifier3, color2, strokeWidth2, $changed, i));
        }
    }

    /* renamed from: drawCircularIndicator-42QJj7c  reason: not valid java name */
    private static final void m2044drawCircularIndicator42QJj7c(DrawScope $this$drawCircularIndicator_u2d42QJj7c, float startAngle, float sweep, long color, Stroke stroke) {
        float f = (float) 2;
        float diameterOffset = stroke.getWidth() / f;
        float arcDimen = Size.m2984getWidthimpl($this$drawCircularIndicator_u2d42QJj7c.m3772getSizeNHjbRc()) - (f * diameterOffset);
        DrawScope.m3733drawArcyD3GUKo$default($this$drawCircularIndicator_u2d42QJj7c, color, startAngle, sweep, false, OffsetKt.Offset(diameterOffset, diameterOffset), androidx.compose.ui.geometry.SizeKt.Size(arcDimen, arcDimen), 0.0f, stroke, (ColorFilter) null, 0, 832, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawDeterminateCircularIndicator-42QJj7c  reason: not valid java name */
    public static final void m2045drawDeterminateCircularIndicator42QJj7c(DrawScope $this$drawDeterminateCircularIndicator_u2d42QJj7c, float startAngle, float sweep, long color, Stroke stroke) {
        m2044drawCircularIndicator42QJj7c($this$drawDeterminateCircularIndicator_u2d42QJj7c, startAngle, sweep, color, stroke);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawIndeterminateCircularIndicator-hrjfTZI  reason: not valid java name */
    public static final void m2046drawIndeterminateCircularIndicatorhrjfTZI(DrawScope $this$drawIndeterminateCircularIndicator_u2dhrjfTZI, float startAngle, float strokeWidth, float sweep, long color, Stroke stroke) {
        m2044drawCircularIndicator42QJj7c($this$drawIndeterminateCircularIndicator_u2dhrjfTZI, startAngle + (((strokeWidth / Dp.m5986constructorimpl(CircularIndicatorDiameter / ((float) 2))) * 57.29578f) / 2.0f), Math.max(sweep, 0.1f), color, stroke);
    }

    public static final float getLinearIndicatorWidth() {
        return LinearIndicatorWidth;
    }

    public static final float getLinearIndicatorHeight() {
        return LinearIndicatorHeight;
    }

    public static final float getCircularIndicatorDiameter() {
        return CircularIndicatorDiameter;
    }
}
