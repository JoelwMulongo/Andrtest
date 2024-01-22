package androidx.compose.material3;

import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u001a}\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0001\u0010\n\u001a\u00020\u000b2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001c2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001c2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001ar\u0010&\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001cH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001ar\u0010)\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001cH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010(\u001ar\u0010+\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001cH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010(\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"ExtendedFabCollapseAnimation", "Landroidx/compose/animation/ExitTransition;", "ExtendedFabEndIconPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExtendedFabExpandAnimation", "Landroidx/compose/animation/EnterTransition;", "ExtendedFabMinimumWidth", "ExtendedFabStartIconPadding", "ExtendedFabTextPadding", "ExtendedFloatingActionButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material3/FloatingActionButtonElevation;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "ExtendedFloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "text", "icon", "expanded", "", "ExtendedFloatingActionButton-ElI5-7k", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "FloatingActionButton", "FloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "LargeFloatingActionButton", "LargeFloatingActionButton-X-z6DiA", "SmallFloatingActionButton", "SmallFloatingActionButton-X-z6DiA", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: FloatingActionButton.kt */
public final class FloatingActionButtonKt {
    /* access modifiers changed from: private */
    public static final ExitTransition ExtendedFabCollapseAnimation = EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(100, 0, MotionTokens.INSTANCE.getEasingLinearCubicBezier(), 2, (Object) null), 0.0f, 2, (Object) null).plus(EnterExitTransitionKt.shrinkHorizontally$default(AnimationSpecKt.tween$default(500, 0, MotionTokens.INSTANCE.getEasingEmphasizedCubicBezier(), 2, (Object) null), Alignment.Companion.getStart(), false, (Function1) null, 12, (Object) null));
    /* access modifiers changed from: private */
    public static final float ExtendedFabEndIconPadding = Dp.m5986constructorimpl((float) 12);
    /* access modifiers changed from: private */
    public static final EnterTransition ExtendedFabExpandAnimation = EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween(ComposerKt.invocationKey, 100, MotionTokens.INSTANCE.getEasingLinearCubicBezier()), 0.0f, 2, (Object) null).plus(EnterExitTransitionKt.expandHorizontally$default(AnimationSpecKt.tween$default(500, 0, MotionTokens.INSTANCE.getEasingEmphasizedCubicBezier(), 2, (Object) null), Alignment.Companion.getStart(), false, (Function1) null, 12, (Object) null));
    /* access modifiers changed from: private */
    public static final float ExtendedFabMinimumWidth = Dp.m5986constructorimpl((float) 80);
    /* access modifiers changed from: private */
    public static final float ExtendedFabStartIconPadding = Dp.m5986constructorimpl((float) 16);
    /* access modifiers changed from: private */
    public static final float ExtendedFabTextPadding = Dp.m5986constructorimpl((float) 20);

    /* JADX WARNING: Removed duplicated region for block: B:139:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0128  */
    /* renamed from: FloatingActionButton-X-z6DiA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1948FloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0<kotlin.Unit> r27, androidx.compose.ui.Modifier r28, androidx.compose.ui.graphics.Shape r29, long r30, long r32, androidx.compose.material3.FloatingActionButtonElevation r34, androidx.compose.foundation.interaction.MutableInteractionSource r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r13 = r27
            r11 = r36
            r6 = r38
            r7 = r39
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -731723913(0xffffffffd462c777, float:-3.89603629E12)
            r1 = r37
            androidx.compose.runtime.Composer r4 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(FloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)96@4796L5,97@4860L14,98@4902L31,99@5011L11,100@5074L39,109@5352L53,110@5449L54,103@5160L1353:FloatingActionButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r1)
            r1 = r38
            r2 = r7 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            goto L_0x0038
        L_0x002a:
            r2 = r6 & 14
            if (r2 != 0) goto L_0x0038
            boolean r2 = r4.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x0036
            r2 = 4
            goto L_0x0037
        L_0x0036:
            r2 = 2
        L_0x0037:
            r1 = r1 | r2
        L_0x0038:
            r2 = r7 & 2
            if (r2 == 0) goto L_0x0041
            r1 = r1 | 48
            r3 = r28
            goto L_0x0056
        L_0x0041:
            r3 = r6 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0054
            r3 = r28
            boolean r5 = r4.changed((java.lang.Object) r3)
            if (r5 == 0) goto L_0x0050
            r5 = 32
            goto L_0x0052
        L_0x0050:
            r5 = 16
        L_0x0052:
            r1 = r1 | r5
            goto L_0x0056
        L_0x0054:
            r3 = r28
        L_0x0056:
            r5 = r6 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x006f
            r5 = r7 & 4
            if (r5 != 0) goto L_0x0069
            r5 = r29
            boolean r8 = r4.changed((java.lang.Object) r5)
            if (r8 == 0) goto L_0x006b
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x006d
        L_0x0069:
            r5 = r29
        L_0x006b:
            r8 = 128(0x80, float:1.794E-43)
        L_0x006d:
            r1 = r1 | r8
            goto L_0x0071
        L_0x006f:
            r5 = r29
        L_0x0071:
            r8 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x008a
            r8 = r7 & 8
            if (r8 != 0) goto L_0x0084
            r8 = r30
            boolean r10 = r4.changed((long) r8)
            if (r10 == 0) goto L_0x0086
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0088
        L_0x0084:
            r8 = r30
        L_0x0086:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0088:
            r1 = r1 | r10
            goto L_0x008c
        L_0x008a:
            r8 = r30
        L_0x008c:
            r22 = 57344(0xe000, float:8.0356E-41)
            r10 = r6 & r22
            if (r10 != 0) goto L_0x00a8
            r10 = r7 & 16
            if (r10 != 0) goto L_0x00a2
            r14 = r32
            boolean r10 = r4.changed((long) r14)
            if (r10 == 0) goto L_0x00a4
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a6
        L_0x00a2:
            r14 = r32
        L_0x00a4:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x00a6:
            r1 = r1 | r10
            goto L_0x00aa
        L_0x00a8:
            r14 = r32
        L_0x00aa:
            r23 = 458752(0x70000, float:6.42848E-40)
            r10 = r6 & r23
            if (r10 != 0) goto L_0x00c5
            r10 = r7 & 32
            if (r10 != 0) goto L_0x00bf
            r10 = r34
            boolean r12 = r4.changed((java.lang.Object) r10)
            if (r12 == 0) goto L_0x00c1
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c3
        L_0x00bf:
            r10 = r34
        L_0x00c1:
            r12 = 65536(0x10000, float:9.18355E-41)
        L_0x00c3:
            r1 = r1 | r12
            goto L_0x00c7
        L_0x00c5:
            r10 = r34
        L_0x00c7:
            r12 = r7 & 64
            if (r12 == 0) goto L_0x00d2
            r16 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r16
            r0 = r35
            goto L_0x00ea
        L_0x00d2:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r6 & r16
            if (r16 != 0) goto L_0x00e8
            r0 = r35
            boolean r16 = r4.changed((java.lang.Object) r0)
            if (r16 == 0) goto L_0x00e3
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e5
        L_0x00e3:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00e5:
            r1 = r1 | r16
            goto L_0x00ea
        L_0x00e8:
            r0 = r35
        L_0x00ea:
            r0 = r7 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00f2
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00f0:
            r1 = r1 | r0
            goto L_0x0103
        L_0x00f2:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r6
            if (r0 != 0) goto L_0x0103
            boolean r0 = r4.changed((java.lang.Object) r11)
            if (r0 == 0) goto L_0x0100
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f0
        L_0x0100:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00f0
        L_0x0103:
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r0 & r1
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x0128
            boolean r0 = r4.getSkipping()
            if (r0 != 0) goto L_0x0113
            goto L_0x0128
        L_0x0113:
            r4.skipToGroupEnd()
            r17 = r28
            r21 = r35
            r24 = r1
            r25 = r4
            r18 = r5
            r19 = r8
            r26 = r10
            r22 = r14
            goto L_0x02bd
        L_0x0128:
            r4.startDefaults()
            r0 = r6 & 1
            r3 = -458753(0xfffffffffff8ffff, float:NaN)
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0171
            boolean r0 = r4.getDefaultsInvalid()
            if (r0 == 0) goto L_0x013c
            goto L_0x0171
        L_0x013c:
            r4.skipToGroupEnd()
            r0 = r7 & 4
            if (r0 == 0) goto L_0x0145
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0145:
            r0 = r7 & 8
            if (r0 == 0) goto L_0x014b
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x014b:
            r0 = r7 & 16
            if (r0 == 0) goto L_0x0151
            r1 = r1 & r16
        L_0x0151:
            r0 = r7 & 32
            if (r0 == 0) goto L_0x0164
            r0 = r1 & r3
            r17 = r28
            r21 = r35
            r3 = r0
            r18 = r5
            r19 = r8
            r5 = r10
            r0 = r14
            goto L_0x021f
        L_0x0164:
            r17 = r28
            r21 = r35
            r3 = r1
            r18 = r5
            r19 = r8
            r5 = r10
            r0 = r14
            goto L_0x021f
        L_0x0171:
            if (r2 == 0) goto L_0x0178
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x017a
        L_0x0178:
            r0 = r28
        L_0x017a:
            r2 = r7 & 4
            r3 = 6
            if (r2 == 0) goto L_0x0188
            androidx.compose.material3.FloatingActionButtonDefaults r2 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getShape(r4, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r5 = r2
        L_0x0188:
            r2 = r7 & 8
            if (r2 == 0) goto L_0x0195
            androidx.compose.material3.FloatingActionButtonDefaults r2 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            long r2 = r2.getContainerColor(r4, r3)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r8 = r2
        L_0x0195:
            r2 = r7 & 16
            if (r2 == 0) goto L_0x01a4
            int r2 = r1 >> 9
            r2 = r2 & 14
            long r2 = androidx.compose.material3.ColorSchemeKt.m1854contentColorForek8zF_U(r8, r4, r2)
            r1 = r1 & r16
            goto L_0x01a5
        L_0x01a4:
            r2 = r14
        L_0x01a5:
            r14 = r7 & 32
            if (r14 == 0) goto L_0x01c0
            androidx.compose.material3.FloatingActionButtonDefaults r14 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 24576(0x6000, float:3.4438E-41)
            r21 = 15
            r19 = r4
            androidx.compose.material3.FloatingActionButtonElevation r10 = r14.m1943elevationxZ9QkE(r15, r16, r17, r18, r19, r20, r21)
            r14 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r14
        L_0x01c0:
            if (r12 == 0) goto L_0x020f
            r12 = 0
            r14 = 0
            r15 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r4.startReplaceableGroup(r15)
            java.lang.String r15 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r15)
            r15 = 0
            r28 = r4
            r16 = 0
            r37 = r0
            java.lang.Object r0 = r28.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r29 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r0 != r1) goto L_0x01f4
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r30 = r0
            r0 = r28
            r0.updateRememberedValue(r1)
            goto L_0x01fa
        L_0x01f4:
            r30 = r0
            r0 = r28
            r1 = r30
        L_0x01fa:
            r4.endReplaceableGroup()
            r0 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r17 = r37
            r21 = r0
            r0 = r2
            r18 = r5
            r19 = r8
            r5 = r10
            r3 = r29
            goto L_0x021f
        L_0x020f:
            r37 = r0
            r29 = r1
            r21 = r35
            r17 = r37
            r0 = r2
            r18 = r5
            r19 = r8
            r5 = r10
            r3 = r29
        L_0x021f:
            r4.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0231
            r2 = -1
            java.lang.String r8 = "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:93)"
            r9 = -731723913(0xffffffffd462c777, float:-3.89603629E12)
            androidx.compose.runtime.ComposerKt.traceEventStart(r9, r3, r2, r8)
        L_0x0231:
            r2 = 0
            r8 = r21
            androidx.compose.foundation.interaction.InteractionSource r8 = (androidx.compose.foundation.interaction.InteractionSource) r8
            int r9 = r3 >> 18
            r9 = r9 & 14
            int r10 = r3 >> 12
            r10 = r10 & 112(0x70, float:1.57E-43)
            r9 = r9 | r10
            androidx.compose.runtime.State r8 = r5.tonalElevation$material3_release(r8, r4, r9)
            java.lang.Object r8 = r8.getValue()
            androidx.compose.ui.unit.Dp r8 = (androidx.compose.ui.unit.Dp) r8
            float r8 = r8.m6000unboximpl()
            r9 = r21
            androidx.compose.foundation.interaction.InteractionSource r9 = (androidx.compose.foundation.interaction.InteractionSource) r9
            int r10 = r3 >> 18
            r10 = r10 & 14
            int r12 = r3 >> 12
            r12 = r12 & 112(0x70, float:1.57E-43)
            r10 = r10 | r12
            androidx.compose.runtime.State r9 = r5.shadowElevation$material3_release(r9, r4, r10)
            java.lang.Object r9 = r9.getValue()
            androidx.compose.ui.unit.Dp r9 = (androidx.compose.ui.unit.Dp) r9
            float r9 = r9.m6000unboximpl()
            r10 = 0
            androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$2 r12 = new androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$2
            r12.<init>(r0, r11, r3)
            r14 = 1249316354(0x4a770e02, float:4047744.5)
            r15 = 1
            androidx.compose.runtime.internal.ComposableLambda r12 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r4, r14, r15, r12)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r14 = r3 & 14
            r15 = r3 & 112(0x70, float:1.57E-43)
            r14 = r14 | r15
            int r15 = r3 << 3
            r15 = r15 & 7168(0x1c00, float:1.0045E-41)
            r14 = r14 | r15
            int r15 = r3 << 3
            r15 = r15 & r22
            r14 = r14 | r15
            int r15 = r3 << 3
            r15 = r15 & r23
            r14 = r14 | r15
            r15 = 1879048192(0x70000000, float:1.58456325E29)
            int r16 = r3 << 9
            r15 = r16 & r15
            r14 = r14 | r15
            r15 = 6
            r16 = 260(0x104, float:3.64E-43)
            r22 = r0
            r0 = r27
            r1 = r17
            r24 = r3
            r3 = r18
            r25 = r4
            r26 = r5
            r4 = r19
            r6 = r22
            r11 = r21
            r13 = r25
            androidx.compose.material3.SurfaceKt.m2100Surfaceo_FOJdg(r0, r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02bd
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02bd:
            androidx.compose.runtime.ScopeUpdateScope r13 = r25.endRestartGroup()
            if (r13 != 0) goto L_0x02c4
            goto L_0x02e3
        L_0x02c4:
            androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$3 r14 = new androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$3
            r0 = r14
            r1 = r27
            r2 = r17
            r3 = r18
            r4 = r19
            r6 = r22
            r8 = r26
            r9 = r21
            r10 = r36
            r11 = r38
            r12 = r39
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x02e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m1948FloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:141:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x012a  */
    /* renamed from: SmallFloatingActionButton-X-z6DiA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1950SmallFloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0<kotlin.Unit> r29, androidx.compose.ui.Modifier r30, androidx.compose.ui.graphics.Shape r31, long r32, long r34, androidx.compose.material3.FloatingActionButtonElevation r36, androidx.compose.foundation.interaction.MutableInteractionSource r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r13 = r29
            r14 = r38
            r15 = r40
            r12 = r41
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1444748300(0x561d1c0c, float:4.3185946E13)
            r1 = r39
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SmallFloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)164@8359L10,165@8428L14,166@8470L31,167@8579L11,168@8642L39,171@8728L431:FloatingActionButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r40
            r2 = r12 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            goto L_0x0038
        L_0x002a:
            r2 = r15 & 14
            if (r2 != 0) goto L_0x0038
            boolean r2 = r11.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x0036
            r2 = 4
            goto L_0x0037
        L_0x0036:
            r2 = 2
        L_0x0037:
            r1 = r1 | r2
        L_0x0038:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0041
            r1 = r1 | 48
            r3 = r30
            goto L_0x0056
        L_0x0041:
            r3 = r15 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0054
            r3 = r30
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0050
            r4 = 32
            goto L_0x0052
        L_0x0050:
            r4 = 16
        L_0x0052:
            r1 = r1 | r4
            goto L_0x0056
        L_0x0054:
            r3 = r30
        L_0x0056:
            r4 = r15 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x006f
            r4 = r12 & 4
            if (r4 != 0) goto L_0x0069
            r4 = r31
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x006b
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x006d
        L_0x0069:
            r4 = r31
        L_0x006b:
            r5 = 128(0x80, float:1.794E-43)
        L_0x006d:
            r1 = r1 | r5
            goto L_0x0071
        L_0x006f:
            r4 = r31
        L_0x0071:
            r5 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x008a
            r5 = r12 & 8
            if (r5 != 0) goto L_0x0084
            r5 = r32
            boolean r7 = r11.changed((long) r5)
            if (r7 == 0) goto L_0x0086
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0088
        L_0x0084:
            r5 = r32
        L_0x0086:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0088:
            r1 = r1 | r7
            goto L_0x008c
        L_0x008a:
            r5 = r32
        L_0x008c:
            r9 = 57344(0xe000, float:8.0356E-41)
            r7 = r15 & r9
            if (r7 != 0) goto L_0x00a8
            r7 = r12 & 16
            if (r7 != 0) goto L_0x00a2
            r7 = r34
            boolean r10 = r11.changed((long) r7)
            if (r10 == 0) goto L_0x00a4
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a6
        L_0x00a2:
            r7 = r34
        L_0x00a4:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x00a6:
            r1 = r1 | r10
            goto L_0x00aa
        L_0x00a8:
            r7 = r34
        L_0x00aa:
            r10 = 458752(0x70000, float:6.42848E-40)
            r16 = r15 & r10
            if (r16 != 0) goto L_0x00c6
            r16 = r12 & 32
            if (r16 != 0) goto L_0x00bf
            r10 = r36
            boolean r16 = r11.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x00c1
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c3
        L_0x00bf:
            r10 = r36
        L_0x00c1:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c3:
            r1 = r1 | r16
            goto L_0x00c8
        L_0x00c6:
            r10 = r36
        L_0x00c8:
            r16 = r12 & 64
            r17 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00d5
            r18 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r18
            r9 = r37
            goto L_0x00eb
        L_0x00d5:
            r18 = r15 & r17
            if (r18 != 0) goto L_0x00e9
            r9 = r37
            boolean r19 = r11.changed((java.lang.Object) r9)
            if (r19 == 0) goto L_0x00e4
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e6
        L_0x00e4:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00e6:
            r1 = r1 | r19
            goto L_0x00eb
        L_0x00e9:
            r9 = r37
        L_0x00eb:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            if (r0 == 0) goto L_0x00f5
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00f3:
            r1 = r1 | r0
            goto L_0x0105
        L_0x00f5:
            r0 = r15 & r20
            if (r0 != 0) goto L_0x0105
            boolean r0 = r11.changed((java.lang.Object) r14)
            if (r0 == 0) goto L_0x0102
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f3
        L_0x0102:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00f3
        L_0x0105:
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r0 & r1
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x012a
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x0115
            goto L_0x012a
        L_0x0115:
            r11.skipToGroupEnd()
            r16 = r30
            r19 = r1
            r23 = r4
            r27 = r5
            r24 = r7
            r22 = r9
            r21 = r10
            r20 = r11
            goto L_0x0292
        L_0x012a:
            r11.startDefaults()
            r0 = r15 & 1
            r21 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0176
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x013e
            goto L_0x0176
        L_0x013e:
            r11.skipToGroupEnd()
            r0 = r12 & 4
            if (r0 == 0) goto L_0x0147
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0147:
            r0 = r12 & 8
            if (r0 == 0) goto L_0x014d
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x014d:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0152
            r1 = r1 & r3
        L_0x0152:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0167
            r0 = r1 & r21
            r16 = r30
            r23 = r4
            r27 = r5
            r24 = r7
            r22 = r9
            r21 = r10
            r10 = r0
            goto L_0x0219
        L_0x0167:
            r16 = r30
            r23 = r4
            r27 = r5
            r24 = r7
            r22 = r9
            r21 = r10
            r10 = r1
            goto L_0x0219
        L_0x0176:
            if (r2 == 0) goto L_0x017d
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x017f
        L_0x017d:
            r0 = r30
        L_0x017f:
            r2 = r12 & 4
            r3 = 6
            if (r2 == 0) goto L_0x018f
            androidx.compose.material3.FloatingActionButtonDefaults r2 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getSmallShape(r11, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r23 = r2
            goto L_0x0191
        L_0x018f:
            r23 = r4
        L_0x0191:
            r2 = r12 & 8
            if (r2 == 0) goto L_0x019e
            androidx.compose.material3.FloatingActionButtonDefaults r2 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            long r2 = r2.getContainerColor(r11, r3)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r5 = r2
        L_0x019e:
            r2 = r12 & 16
            if (r2 == 0) goto L_0x01b3
            int r2 = r1 >> 9
            r2 = r2 & 14
            long r2 = androidx.compose.material3.ColorSchemeKt.m1854contentColorForek8zF_U(r5, r11, r2)
            r4 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r4
            r22 = r1
            r24 = r2
            goto L_0x01b7
        L_0x01b3:
            r22 = r1
            r24 = r7
        L_0x01b7:
            r1 = r12 & 32
            if (r1 == 0) goto L_0x01d4
            androidx.compose.material3.FloatingActionButtonDefaults r1 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            r2 = 0
            r3 = 0
            r4 = 0
            r7 = 0
            r8 = 24576(0x6000, float:3.4438E-41)
            r26 = 15
            r27 = r5
            r5 = r7
            r6 = r11
            r7 = r8
            r8 = r26
            androidx.compose.material3.FloatingActionButtonElevation r1 = r1.m1943elevationxZ9QkE(r2, r3, r4, r5, r6, r7, r8)
            r22 = r22 & r21
            r10 = r1
            goto L_0x01d6
        L_0x01d4:
            r27 = r5
        L_0x01d6:
            if (r16 == 0) goto L_0x0211
            r1 = 0
            r2 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
            r3 = 0
            r4 = r11
            r5 = 0
            java.lang.Object r6 = r4.rememberedValue()
            r7 = 0
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r6 != r8) goto L_0x01ff
            r8 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r4.updateRememberedValue(r8)
            goto L_0x0200
        L_0x01ff:
            r8 = r6
        L_0x0200:
            r11.endReplaceableGroup()
            r1 = r8
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r16 = r0
            r21 = r10
            r10 = r22
            r22 = r1
            goto L_0x0219
        L_0x0211:
            r16 = r0
            r21 = r10
            r10 = r22
            r22 = r9
        L_0x0219:
            r11.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x022b
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:161)"
            r2 = 1444748300(0x561d1c0c, float:4.3185946E13)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r10, r0, r1)
        L_0x022b:
            androidx.compose.material3.tokens.FabPrimarySmallTokens r0 = androidx.compose.material3.tokens.FabPrimarySmallTokens.INSTANCE
            float r0 = r0.m2401getContainerWidthD9Ej5fM()
            androidx.compose.material3.tokens.FabPrimarySmallTokens r1 = androidx.compose.material3.tokens.FabPrimarySmallTokens.INSTANCE
            float r1 = r1.m2400getContainerHeightD9Ej5fM()
            r2 = 0
            r3 = 0
            r4 = 12
            r5 = 0
            r30 = r16
            r31 = r0
            r32 = r1
            r33 = r2
            r34 = r3
            r35 = r4
            r36 = r5
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m834sizeInqDBjuR0$default(r30, r31, r32, r33, r34, r35, r36)
            r0 = r10 & 14
            r2 = r10 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r2 = r10 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r10
            r0 = r0 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r10
            r0 = r0 | r2
            r2 = r10 & r17
            r0 = r0 | r2
            r2 = r10 & r20
            r17 = r0 | r2
            r18 = 0
            r0 = r29
            r2 = r23
            r3 = r27
            r5 = r24
            r7 = r21
            r8 = r22
            r9 = r38
            r19 = r10
            r10 = r11
            r20 = r11
            r11 = r17
            r12 = r18
            m1948FloatingActionButtonXz6DiA(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0292
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0292:
            androidx.compose.runtime.ScopeUpdateScope r12 = r20.endRestartGroup()
            if (r12 != 0) goto L_0x0299
            goto L_0x02bc
        L_0x0299:
            androidx.compose.material3.FloatingActionButtonKt$SmallFloatingActionButton$2 r17 = new androidx.compose.material3.FloatingActionButtonKt$SmallFloatingActionButton$2
            r0 = r17
            r1 = r29
            r2 = r16
            r3 = r23
            r4 = r27
            r6 = r24
            r8 = r21
            r9 = r22
            r10 = r38
            r11 = r40
            r13 = r12
            r12 = r41
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x02bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m1950SmallFloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:141:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x012a  */
    /* renamed from: LargeFloatingActionButton-X-z6DiA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1949LargeFloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0<kotlin.Unit> r29, androidx.compose.ui.Modifier r30, androidx.compose.ui.graphics.Shape r31, long r32, long r34, androidx.compose.material3.FloatingActionButtonElevation r36, androidx.compose.foundation.interaction.MutableInteractionSource r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r13 = r29
            r14 = r38
            r15 = r40
            r12 = r41
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -1650866856(0xffffffff9d99c558, float:-4.070281E-21)
            r1 = r39
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LargeFloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)216@11005L10,217@11074L14,218@11116L31,219@11225L11,220@11288L39,223@11374L431:FloatingActionButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r40
            r2 = r12 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            goto L_0x0038
        L_0x002a:
            r2 = r15 & 14
            if (r2 != 0) goto L_0x0038
            boolean r2 = r11.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x0036
            r2 = 4
            goto L_0x0037
        L_0x0036:
            r2 = 2
        L_0x0037:
            r1 = r1 | r2
        L_0x0038:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0041
            r1 = r1 | 48
            r3 = r30
            goto L_0x0056
        L_0x0041:
            r3 = r15 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0054
            r3 = r30
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0050
            r4 = 32
            goto L_0x0052
        L_0x0050:
            r4 = 16
        L_0x0052:
            r1 = r1 | r4
            goto L_0x0056
        L_0x0054:
            r3 = r30
        L_0x0056:
            r4 = r15 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x006f
            r4 = r12 & 4
            if (r4 != 0) goto L_0x0069
            r4 = r31
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x006b
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x006d
        L_0x0069:
            r4 = r31
        L_0x006b:
            r5 = 128(0x80, float:1.794E-43)
        L_0x006d:
            r1 = r1 | r5
            goto L_0x0071
        L_0x006f:
            r4 = r31
        L_0x0071:
            r5 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x008a
            r5 = r12 & 8
            if (r5 != 0) goto L_0x0084
            r5 = r32
            boolean r7 = r11.changed((long) r5)
            if (r7 == 0) goto L_0x0086
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0088
        L_0x0084:
            r5 = r32
        L_0x0086:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0088:
            r1 = r1 | r7
            goto L_0x008c
        L_0x008a:
            r5 = r32
        L_0x008c:
            r9 = 57344(0xe000, float:8.0356E-41)
            r7 = r15 & r9
            if (r7 != 0) goto L_0x00a8
            r7 = r12 & 16
            if (r7 != 0) goto L_0x00a2
            r7 = r34
            boolean r10 = r11.changed((long) r7)
            if (r10 == 0) goto L_0x00a4
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a6
        L_0x00a2:
            r7 = r34
        L_0x00a4:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x00a6:
            r1 = r1 | r10
            goto L_0x00aa
        L_0x00a8:
            r7 = r34
        L_0x00aa:
            r10 = 458752(0x70000, float:6.42848E-40)
            r16 = r15 & r10
            if (r16 != 0) goto L_0x00c6
            r16 = r12 & 32
            if (r16 != 0) goto L_0x00bf
            r10 = r36
            boolean r16 = r11.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x00c1
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c3
        L_0x00bf:
            r10 = r36
        L_0x00c1:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c3:
            r1 = r1 | r16
            goto L_0x00c8
        L_0x00c6:
            r10 = r36
        L_0x00c8:
            r16 = r12 & 64
            r17 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00d5
            r18 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r18
            r9 = r37
            goto L_0x00eb
        L_0x00d5:
            r18 = r15 & r17
            if (r18 != 0) goto L_0x00e9
            r9 = r37
            boolean r19 = r11.changed((java.lang.Object) r9)
            if (r19 == 0) goto L_0x00e4
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e6
        L_0x00e4:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00e6:
            r1 = r1 | r19
            goto L_0x00eb
        L_0x00e9:
            r9 = r37
        L_0x00eb:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            if (r0 == 0) goto L_0x00f5
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00f3:
            r1 = r1 | r0
            goto L_0x0105
        L_0x00f5:
            r0 = r15 & r20
            if (r0 != 0) goto L_0x0105
            boolean r0 = r11.changed((java.lang.Object) r14)
            if (r0 == 0) goto L_0x0102
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f3
        L_0x0102:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00f3
        L_0x0105:
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r0 & r1
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x012a
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x0115
            goto L_0x012a
        L_0x0115:
            r11.skipToGroupEnd()
            r16 = r30
            r19 = r1
            r23 = r4
            r27 = r5
            r24 = r7
            r22 = r9
            r21 = r10
            r20 = r11
            goto L_0x0292
        L_0x012a:
            r11.startDefaults()
            r0 = r15 & 1
            r21 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0176
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x013e
            goto L_0x0176
        L_0x013e:
            r11.skipToGroupEnd()
            r0 = r12 & 4
            if (r0 == 0) goto L_0x0147
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0147:
            r0 = r12 & 8
            if (r0 == 0) goto L_0x014d
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x014d:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0152
            r1 = r1 & r3
        L_0x0152:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0167
            r0 = r1 & r21
            r16 = r30
            r23 = r4
            r27 = r5
            r24 = r7
            r22 = r9
            r21 = r10
            r10 = r0
            goto L_0x0219
        L_0x0167:
            r16 = r30
            r23 = r4
            r27 = r5
            r24 = r7
            r22 = r9
            r21 = r10
            r10 = r1
            goto L_0x0219
        L_0x0176:
            if (r2 == 0) goto L_0x017d
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x017f
        L_0x017d:
            r0 = r30
        L_0x017f:
            r2 = r12 & 4
            r3 = 6
            if (r2 == 0) goto L_0x018f
            androidx.compose.material3.FloatingActionButtonDefaults r2 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getLargeShape(r11, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r23 = r2
            goto L_0x0191
        L_0x018f:
            r23 = r4
        L_0x0191:
            r2 = r12 & 8
            if (r2 == 0) goto L_0x019e
            androidx.compose.material3.FloatingActionButtonDefaults r2 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            long r2 = r2.getContainerColor(r11, r3)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r5 = r2
        L_0x019e:
            r2 = r12 & 16
            if (r2 == 0) goto L_0x01b3
            int r2 = r1 >> 9
            r2 = r2 & 14
            long r2 = androidx.compose.material3.ColorSchemeKt.m1854contentColorForek8zF_U(r5, r11, r2)
            r4 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r4
            r22 = r1
            r24 = r2
            goto L_0x01b7
        L_0x01b3:
            r22 = r1
            r24 = r7
        L_0x01b7:
            r1 = r12 & 32
            if (r1 == 0) goto L_0x01d4
            androidx.compose.material3.FloatingActionButtonDefaults r1 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            r2 = 0
            r3 = 0
            r4 = 0
            r7 = 0
            r8 = 24576(0x6000, float:3.4438E-41)
            r26 = 15
            r27 = r5
            r5 = r7
            r6 = r11
            r7 = r8
            r8 = r26
            androidx.compose.material3.FloatingActionButtonElevation r1 = r1.m1943elevationxZ9QkE(r2, r3, r4, r5, r6, r7, r8)
            r22 = r22 & r21
            r10 = r1
            goto L_0x01d6
        L_0x01d4:
            r27 = r5
        L_0x01d6:
            if (r16 == 0) goto L_0x0211
            r1 = 0
            r2 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
            r3 = 0
            r4 = r11
            r5 = 0
            java.lang.Object r6 = r4.rememberedValue()
            r7 = 0
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r6 != r8) goto L_0x01ff
            r8 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r4.updateRememberedValue(r8)
            goto L_0x0200
        L_0x01ff:
            r8 = r6
        L_0x0200:
            r11.endReplaceableGroup()
            r1 = r8
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r16 = r0
            r21 = r10
            r10 = r22
            r22 = r1
            goto L_0x0219
        L_0x0211:
            r16 = r0
            r21 = r10
            r10 = r22
            r22 = r9
        L_0x0219:
            r11.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x022b
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:213)"
            r2 = -1650866856(0xffffffff9d99c558, float:-4.070281E-21)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r10, r0, r1)
        L_0x022b:
            androidx.compose.material3.tokens.FabPrimaryLargeTokens r0 = androidx.compose.material3.tokens.FabPrimaryLargeTokens.INSTANCE
            float r0 = r0.m2390getContainerWidthD9Ej5fM()
            androidx.compose.material3.tokens.FabPrimaryLargeTokens r1 = androidx.compose.material3.tokens.FabPrimaryLargeTokens.INSTANCE
            float r1 = r1.m2389getContainerHeightD9Ej5fM()
            r2 = 0
            r3 = 0
            r4 = 12
            r5 = 0
            r30 = r16
            r31 = r0
            r32 = r1
            r33 = r2
            r34 = r3
            r35 = r4
            r36 = r5
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m834sizeInqDBjuR0$default(r30, r31, r32, r33, r34, r35, r36)
            r0 = r10 & 14
            r2 = r10 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r2 = r10 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r10
            r0 = r0 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r10
            r0 = r0 | r2
            r2 = r10 & r17
            r0 = r0 | r2
            r2 = r10 & r20
            r17 = r0 | r2
            r18 = 0
            r0 = r29
            r2 = r23
            r3 = r27
            r5 = r24
            r7 = r21
            r8 = r22
            r9 = r38
            r19 = r10
            r10 = r11
            r20 = r11
            r11 = r17
            r12 = r18
            m1948FloatingActionButtonXz6DiA(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0292
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0292:
            androidx.compose.runtime.ScopeUpdateScope r12 = r20.endRestartGroup()
            if (r12 != 0) goto L_0x0299
            goto L_0x02bc
        L_0x0299:
            androidx.compose.material3.FloatingActionButtonKt$LargeFloatingActionButton$2 r17 = new androidx.compose.material3.FloatingActionButtonKt$LargeFloatingActionButton$2
            r0 = r17
            r1 = r29
            r2 = r16
            r3 = r23
            r4 = r27
            r6 = r24
            r8 = r21
            r9 = r22
            r10 = r38
            r11 = r40
            r13 = r12
            r12 = r41
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x02bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m1949LargeFloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: ExtendedFloatingActionButton-X-z6DiA  reason: not valid java name */
    public static final void m1947ExtendedFloatingActionButtonXz6DiA(Function0<Unit> onClick, Modifier modifier, Shape shape, long containerColor, long contentColor, FloatingActionButtonElevation elevation, MutableInteractionSource interactionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Shape shape2;
        long containerColor2;
        long j;
        FloatingActionButtonElevation elevation2;
        MutableInteractionSource mutableInteractionSource;
        long containerColor3;
        long contentColor2;
        Shape shape3;
        MutableInteractionSource interactionSource2;
        FloatingActionButtonElevation elevation3;
        Composer $composer2;
        Modifier modifier2;
        int $dirty;
        Modifier modifier3;
        int $dirty2;
        MutableInteractionSource mutableInteractionSource2;
        int i2;
        int i3;
        int i4;
        int i5;
        Function0<Unit> function0 = onClick;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
        int i6 = $changed;
        int i7 = i;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer3 = $composer.startRestartGroup(-326283107);
        ComposerKt.sourceInformation($composer3, "C(ExtendedFloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)271@13789L16,272@13864L14,273@13906L31,274@14015L11,275@14078L39,278@14173L595:FloatingActionButton.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i7 & 1) != 0) {
            $dirty3 |= 6;
        } else if ((i6 & 14) == 0) {
            $dirty3 |= $composer3.changed((Object) function0) ? 4 : 2;
        }
        int i8 = i7 & 2;
        if (i8 != 0) {
            $dirty3 |= 48;
            Modifier modifier4 = modifier;
        } else if ((i6 & 112) == 0) {
            $dirty3 |= $composer3.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier5 = modifier;
        }
        if ((i6 & 896) == 0) {
            if ((i7 & 4) == 0) {
                shape2 = shape;
                if ($composer3.changed((Object) shape2)) {
                    i5 = 256;
                    $dirty3 |= i5;
                }
            } else {
                shape2 = shape;
            }
            i5 = 128;
            $dirty3 |= i5;
        } else {
            shape2 = shape;
        }
        if ((i6 & 7168) == 0) {
            if ((i7 & 8) == 0) {
                containerColor2 = containerColor;
                if ($composer3.changed(containerColor2)) {
                    i4 = 2048;
                    $dirty3 |= i4;
                }
            } else {
                containerColor2 = containerColor;
            }
            i4 = 1024;
            $dirty3 |= i4;
        } else {
            containerColor2 = containerColor;
        }
        if ((i6 & 57344) == 0) {
            if ((i7 & 16) == 0) {
                j = contentColor;
                if ($composer3.changed(j)) {
                    i3 = 16384;
                    $dirty3 |= i3;
                }
            } else {
                j = contentColor;
            }
            i3 = 8192;
            $dirty3 |= i3;
        } else {
            j = contentColor;
        }
        if ((i6 & 458752) == 0) {
            if ((i7 & 32) == 0) {
                elevation2 = elevation;
                if ($composer3.changed((Object) elevation2)) {
                    i2 = 131072;
                    $dirty3 |= i2;
                }
            } else {
                elevation2 = elevation;
            }
            i2 = 65536;
            $dirty3 |= i2;
        } else {
            elevation2 = elevation;
        }
        int i9 = i7 & 64;
        if (i9 != 0) {
            $dirty3 |= 1572864;
            mutableInteractionSource = interactionSource;
        } else if ((i6 & 3670016) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty3 |= $composer3.changed((Object) mutableInteractionSource) ? 1048576 : 524288;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((i7 & 128) != 0) {
            $dirty3 |= 12582912;
        } else if ((29360128 & i6) == 0) {
            $dirty3 |= $composer3.changed((Object) function3) ? 8388608 : 4194304;
        }
        if ((23967451 & $dirty3) != 4793490 || !$composer3.getSkipping()) {
            $composer3.startDefaults();
            if ((i6 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i8 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if ((i7 & 4) != 0) {
                    $dirty3 &= -897;
                    shape3 = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape($composer3, 6);
                } else {
                    shape3 = shape2;
                }
                if ((i7 & 8) != 0) {
                    $dirty3 &= -7169;
                    containerColor2 = FloatingActionButtonDefaults.INSTANCE.getContainerColor($composer3, 6);
                }
                if ((i7 & 16) != 0) {
                    $dirty2 = $dirty3 & -57345;
                    contentColor2 = ColorSchemeKt.m1854contentColorForek8zF_U(containerColor2, $composer3, ($dirty3 >> 9) & 14);
                } else {
                    $dirty2 = $dirty3;
                    contentColor2 = j;
                }
                if ((i7 & 32) != 0) {
                    containerColor3 = containerColor2;
                    $dirty2 &= -458753;
                    elevation2 = FloatingActionButtonDefaults.INSTANCE.m1943elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, $composer3, 24576, 15);
                } else {
                    containerColor3 = containerColor2;
                }
                if (i9 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        mutableInteractionSource2 = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource2);
                    } else {
                        mutableInteractionSource2 = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    modifier2 = modifier3;
                    elevation3 = elevation2;
                    $dirty = $dirty2;
                    interactionSource2 = mutableInteractionSource2;
                } else {
                    modifier2 = modifier3;
                    elevation3 = elevation2;
                    $dirty = $dirty2;
                    interactionSource2 = mutableInteractionSource;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i7 & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i7 & 8) != 0) {
                    $dirty3 &= -7169;
                }
                if ((i7 & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i7 & 32) != 0) {
                    modifier2 = modifier;
                    shape3 = shape2;
                    containerColor3 = containerColor2;
                    contentColor2 = j;
                    interactionSource2 = mutableInteractionSource;
                    elevation3 = elevation2;
                    $dirty = $dirty3 & -458753;
                } else {
                    modifier2 = modifier;
                    shape3 = shape2;
                    containerColor3 = containerColor2;
                    contentColor2 = j;
                    interactionSource2 = mutableInteractionSource;
                    elevation3 = elevation2;
                    $dirty = $dirty3;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-326283107, $dirty, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:268)");
            }
            int i10 = $dirty;
            $composer2 = $composer3;
            m1948FloatingActionButtonXz6DiA(onClick, modifier2, shape3, containerColor3, contentColor2, elevation3, interactionSource2, ComposableLambdaKt.composableLambda($composer3, 398457247, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(function3, $dirty)), $composer3, ($dirty & 14) | 12582912 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | ($dirty & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            int i11 = $dirty3;
            shape3 = shape2;
            containerColor3 = containerColor2;
            contentColor2 = j;
            interactionSource2 = mutableInteractionSource;
            elevation3 = elevation2;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new FloatingActionButtonKt$ExtendedFloatingActionButton$3(onClick, modifier2, shape3, containerColor3, contentColor2, elevation3, interactionSource2, content, $changed, i));
        }
    }

    /* renamed from: ExtendedFloatingActionButton-ElI5-7k  reason: not valid java name */
    public static final void m1946ExtendedFloatingActionButtonElI57k(Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, Function0<Unit> onClick, Modifier modifier, boolean expanded, Shape shape, long containerColor, long contentColor, FloatingActionButtonElevation elevation, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        boolean z;
        Shape shape2;
        int $dirty;
        FloatingActionButtonElevation floatingActionButtonElevation;
        MutableInteractionSource mutableInteractionSource;
        long containerColor2;
        boolean expanded2;
        MutableInteractionSource interactionSource2;
        FloatingActionButtonElevation elevation2;
        long contentColor2;
        Shape shape3;
        Composer $composer2;
        Modifier modifier3;
        boolean expanded3;
        int $dirty2;
        Modifier modifier4;
        boolean expanded4;
        Shape shape4;
        int $dirty3;
        long containerColor3;
        int $dirty4;
        int i2;
        FloatingActionButtonElevation elevation3;
        MutableInteractionSource mutableInteractionSource2;
        int i3;
        int i4;
        int $dirty5;
        int i5;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function2 = text;
        Function2<? super Composer, ? super Integer, Unit> function22 = icon;
        Function0<Unit> function0 = onClick;
        int i7 = $changed;
        int i8 = i;
        Intrinsics.checkNotNullParameter(function2, "text");
        Intrinsics.checkNotNullParameter(function22, "icon");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer3 = $composer.startRestartGroup(-1387401842);
        ComposerKt.sourceInformation($composer3, "C(ExtendedFloatingActionButton)P(9,4,7,6,3,8,0:c#ui.graphics.Color,1:c#ui.graphics.Color)341@17331L16,342@17406L14,343@17448L31,344@17557L11,345@17620L39,347@17669L1269:FloatingActionButton.kt#uh7d8r");
        int $dirty6 = $changed;
        if ((i8 & 1) != 0) {
            $dirty6 |= 6;
        } else if ((i7 & 14) == 0) {
            $dirty6 |= $composer3.changed((Object) function2) ? 4 : 2;
        }
        if ((i8 & 2) != 0) {
            $dirty6 |= 48;
        } else if ((i7 & 112) == 0) {
            $dirty6 |= $composer3.changed((Object) function22) ? 32 : 16;
        }
        if ((i8 & 4) != 0) {
            $dirty6 |= 384;
        } else if ((i7 & 896) == 0) {
            $dirty6 |= $composer3.changed((Object) function0) ? 256 : 128;
        }
        int i9 = i8 & 8;
        if (i9 != 0) {
            $dirty6 |= 3072;
            modifier2 = modifier;
        } else if ((i7 & 7168) == 0) {
            modifier2 = modifier;
            $dirty6 |= $composer3.changed((Object) modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i10 = i8 & 16;
        if (i10 != 0) {
            $dirty6 |= 24576;
            z = expanded;
        } else if ((i7 & 57344) == 0) {
            z = expanded;
            $dirty6 |= $composer3.changed(z) ? 16384 : 8192;
        } else {
            z = expanded;
        }
        if ((i7 & 458752) == 0) {
            if ((i8 & 32) == 0) {
                shape2 = shape;
                if ($composer3.changed((Object) shape2)) {
                    i6 = 131072;
                    $dirty6 |= i6;
                }
            } else {
                shape2 = shape;
            }
            i6 = 65536;
            $dirty6 |= i6;
        } else {
            shape2 = shape;
        }
        if ((i7 & 3670016) == 0) {
            if ((i8 & 64) != 0) {
                long j = containerColor;
            } else if ($composer3.changed(containerColor)) {
                i5 = 1048576;
                $dirty6 |= i5;
            }
            i5 = 524288;
            $dirty6 |= i5;
        } else {
            long j2 = containerColor;
        }
        if ((i7 & 29360128) == 0) {
            if ((i8 & 128) == 0) {
                $dirty5 = $dirty6;
                if ($composer3.changed(contentColor)) {
                    i4 = 8388608;
                    $dirty = $dirty5 | i4;
                }
            } else {
                $dirty5 = $dirty6;
                long j3 = contentColor;
            }
            i4 = 4194304;
            $dirty = $dirty5 | i4;
        } else {
            $dirty = $dirty6;
            long j4 = contentColor;
        }
        if ((i7 & 234881024) == 0) {
            if ((i8 & 256) == 0) {
                floatingActionButtonElevation = elevation;
                if ($composer3.changed((Object) floatingActionButtonElevation)) {
                    i3 = 67108864;
                    $dirty |= i3;
                }
            } else {
                floatingActionButtonElevation = elevation;
            }
            i3 = 33554432;
            $dirty |= i3;
        } else {
            floatingActionButtonElevation = elevation;
        }
        int i11 = i8 & 512;
        if (i11 != 0) {
            $dirty |= 805306368;
            mutableInteractionSource = interactionSource;
        } else if ((1879048192 & i7) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty |= $composer3.changed((Object) mutableInteractionSource) ? 536870912 : 268435456;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if (($dirty & 1533916891) != 306783378 || !$composer3.getSkipping()) {
            $composer3.startDefaults();
            if ((i7 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i9 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i10 != 0) {
                    expanded4 = true;
                } else {
                    expanded4 = z;
                }
                if ((i8 & 32) != 0) {
                    int i12 = $dirty & -458753;
                    shape4 = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape($composer3, 6);
                    $dirty3 = i12;
                } else {
                    $dirty3 = $dirty;
                    shape4 = shape2;
                }
                if ((i8 & 64) != 0) {
                    $dirty3 &= -3670017;
                    containerColor3 = FloatingActionButtonDefaults.INSTANCE.getContainerColor($composer3, 6);
                } else {
                    containerColor3 = containerColor;
                }
                if ((i8 & 128) != 0) {
                    $dirty4 = $dirty3 & -29360129;
                    contentColor2 = ColorSchemeKt.m1854contentColorForek8zF_U(containerColor3, $composer3, ($dirty3 >> 18) & 14);
                } else {
                    contentColor2 = contentColor;
                    $dirty4 = $dirty3;
                }
                if ((i8 & 256) != 0) {
                    containerColor2 = containerColor3;
                    i2 = i11;
                    elevation3 = FloatingActionButtonDefaults.INSTANCE.m1943elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, $composer3, 24576, 15);
                    $dirty4 &= -234881025;
                } else {
                    containerColor2 = containerColor3;
                    i2 = i11;
                    elevation3 = floatingActionButtonElevation;
                }
                if (i2 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        mutableInteractionSource2 = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource2);
                    } else {
                        mutableInteractionSource2 = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    shape3 = shape4;
                    expanded3 = expanded4;
                    $dirty2 = $dirty4;
                    modifier3 = modifier4;
                    elevation2 = elevation3;
                    interactionSource2 = mutableInteractionSource2;
                } else {
                    shape3 = shape4;
                    expanded3 = expanded4;
                    $dirty2 = $dirty4;
                    interactionSource2 = interactionSource;
                    modifier3 = modifier4;
                    elevation2 = elevation3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i8 & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i8 & 64) != 0) {
                    $dirty &= -3670017;
                }
                if ((i8 & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i8 & 256) != 0) {
                    containerColor2 = containerColor;
                    contentColor2 = contentColor;
                    $dirty2 = $dirty & -234881025;
                    modifier3 = modifier2;
                    shape3 = shape2;
                    interactionSource2 = mutableInteractionSource;
                    elevation2 = floatingActionButtonElevation;
                    expanded3 = z;
                } else {
                    containerColor2 = containerColor;
                    contentColor2 = contentColor;
                    shape3 = shape2;
                    interactionSource2 = mutableInteractionSource;
                    elevation2 = floatingActionButtonElevation;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                    expanded3 = z;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1387401842, $dirty2, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:335)");
            }
            int i13 = $dirty2;
            expanded2 = expanded3;
            $composer2 = $composer3;
            m1948FloatingActionButtonXz6DiA(onClick, modifier3, shape3, containerColor2, contentColor2, elevation2, interactionSource2, ComposableLambdaKt.composableLambda($composer3, 1172118032, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$5(expanded3, function22, $dirty2, function2)), $composer3, (($dirty2 >> 6) & 14) | 12582912 | (($dirty2 >> 6) & 112) | (($dirty2 >> 9) & 896) | (($dirty2 >> 9) & 7168) | (($dirty2 >> 9) & 57344) | (($dirty2 >> 9) & 458752) | (($dirty2 >> 9) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            containerColor2 = containerColor;
            contentColor2 = contentColor;
            expanded2 = z;
            shape3 = shape2;
            interactionSource2 = mutableInteractionSource;
            elevation2 = floatingActionButtonElevation;
            $composer2 = $composer3;
            int i14 = $dirty;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new FloatingActionButtonKt$ExtendedFloatingActionButton$6(text, icon, onClick, modifier3, expanded2, shape3, containerColor2, contentColor2, elevation2, interactionSource2, $changed, i));
        }
    }
}
