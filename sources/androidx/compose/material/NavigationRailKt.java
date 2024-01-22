package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationConstants;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a}\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012 \b\u0002\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0001\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001f2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\f0\u001f¢\u0006\u0002\b\u00162\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u001d2\u0015\b\u0002\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f¢\u0006\u0002\b\u00162\b\b\u0002\u0010#\u001a\u00020\u001d2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\u00102\b\b\u0002\u0010'\u001a\u00020\u0010H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a=\u0010*\u001a\u00020\f2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\f0\u001f¢\u0006\u0002\b\u00162\u0013\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f¢\u0006\u0002\b\u00162\u0006\u0010+\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010,\u001aU\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2&\u0010\u0018\u001a\"\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\f0\u0014¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a)\u00105\u001a\u000206*\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a9\u0010>\u001a\u000206*\u0002072\u0006\u0010?\u001a\u0002092\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010+\u001a\u00020\u0007H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010A\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\n\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006B"}, d2 = {"HeaderPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ItemIconTopOffset", "ItemLabelBaselineBottomOffset", "NavigationRailAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "NavigationRailItemCompactSize", "NavigationRailItemSize", "NavigationRailPadding", "NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "NavigationRail-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "NavigationRailItem-0S3VyRs", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "NavigationRailItemBaselineLayout", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "NavigationRailTransition", "activeColor", "inactiveColor", "Lkotlin/ParameterName;", "name", "animationProgress", "NavigationRailTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationRail.kt */
public final class NavigationRailKt {
    /* access modifiers changed from: private */
    public static final float HeaderPadding = Dp.m5986constructorimpl((float) 8);
    private static final float ItemIconTopOffset = Dp.m5986constructorimpl((float) 14);
    private static final float ItemLabelBaselineBottomOffset = Dp.m5986constructorimpl((float) 16);
    private static final TweenSpec<Float> NavigationRailAnimationSpec = new TweenSpec(AnimationConstants.DefaultDurationMillis, 0, EasingKt.getFastOutSlowInEasing(), 2, (DefaultConstructorMarker) null);
    private static final float NavigationRailItemCompactSize = Dp.m5986constructorimpl((float) 56);
    private static final float NavigationRailItemSize = Dp.m5986constructorimpl((float) 72);
    /* access modifiers changed from: private */
    public static final float NavigationRailPadding = Dp.m5986constructorimpl((float) 8);

    /* JADX WARNING: Removed duplicated region for block: B:105:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e2  */
    /* renamed from: NavigationRail-HsRjFd4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1553NavigationRailHsRjFd4(androidx.compose.ui.Modifier r25, long r26, long r28, float r30, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r11 = r32
            r12 = r34
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 1790971523(0x6ac00e83, float:1.1609114E26)
            r1 = r33
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(NavigationRail)P(5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp,4)94@4333L6,95@4375L32,100@4577L552:NavigationRail.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r34
            r2 = r35 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            r3 = r25
            goto L_0x0035
        L_0x0022:
            r3 = r12 & 14
            if (r3 != 0) goto L_0x0033
            r3 = r25
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0030
            r4 = 4
            goto L_0x0031
        L_0x0030:
            r4 = 2
        L_0x0031:
            r1 = r1 | r4
            goto L_0x0035
        L_0x0033:
            r3 = r25
        L_0x0035:
            r4 = r12 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004e
            r4 = r35 & 2
            if (r4 != 0) goto L_0x0048
            r4 = r26
            boolean r6 = r10.changed((long) r4)
            if (r6 == 0) goto L_0x004a
            r6 = 32
            goto L_0x004c
        L_0x0048:
            r4 = r26
        L_0x004a:
            r6 = 16
        L_0x004c:
            r1 = r1 | r6
            goto L_0x0050
        L_0x004e:
            r4 = r26
        L_0x0050:
            r6 = r12 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0069
            r6 = r35 & 4
            if (r6 != 0) goto L_0x0063
            r6 = r28
            boolean r8 = r10.changed((long) r6)
            if (r8 == 0) goto L_0x0065
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0063:
            r6 = r28
        L_0x0065:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r1 = r1 | r8
            goto L_0x006b
        L_0x0069:
            r6 = r28
        L_0x006b:
            r8 = r35 & 8
            if (r8 == 0) goto L_0x0074
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r9 = r30
            goto L_0x0089
        L_0x0074:
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0087
            r9 = r30
            boolean r13 = r10.changed((float) r9)
            if (r13 == 0) goto L_0x0083
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0083:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r1 = r1 | r13
            goto L_0x0089
        L_0x0087:
            r9 = r30
        L_0x0089:
            r13 = r35 & 16
            if (r13 == 0) goto L_0x0092
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r14 = r31
            goto L_0x00a9
        L_0x0092:
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r12
            if (r14 != 0) goto L_0x00a7
            r14 = r31
            boolean r15 = r10.changedInstance(r14)
            if (r15 == 0) goto L_0x00a3
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a5
        L_0x00a3:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00a5:
            r1 = r1 | r15
            goto L_0x00a9
        L_0x00a7:
            r14 = r31
        L_0x00a9:
            r15 = r35 & 32
            r16 = 458752(0x70000, float:6.42848E-40)
            if (r15 == 0) goto L_0x00b3
            r15 = 196608(0x30000, float:2.75506E-40)
        L_0x00b1:
            r1 = r1 | r15
            goto L_0x00c3
        L_0x00b3:
            r15 = r12 & r16
            if (r15 != 0) goto L_0x00c3
            boolean r15 = r10.changedInstance(r11)
            if (r15 == 0) goto L_0x00c0
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00c0:
            r15 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b1
        L_0x00c3:
            r15 = 374491(0x5b6db, float:5.24774E-40)
            r15 = r15 & r1
            r0 = 74898(0x12492, float:1.04954E-40)
            if (r15 != r0) goto L_0x00e2
            boolean r0 = r10.getSkipping()
            if (r0 != 0) goto L_0x00d3
            goto L_0x00e2
        L_0x00d3:
            r10.skipToGroupEnd()
            r20 = r1
            r13 = r3
            r16 = r6
            r18 = r9
            r19 = r14
            r14 = r4
            goto L_0x019d
        L_0x00e2:
            r10.startDefaults()
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0108
            boolean r0 = r10.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00f0
            goto L_0x0108
        L_0x00f0:
            r10.skipToGroupEnd()
            r0 = r35 & 2
            if (r0 == 0) goto L_0x00f9
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00f9:
            r0 = r35 & 4
            if (r0 == 0) goto L_0x0104
            r0 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r1 = r0
            r0 = r3
            r2 = r4
            r4 = r14
            goto L_0x0140
        L_0x0104:
            r0 = r3
            r2 = r4
            r4 = r14
            goto L_0x0140
        L_0x0108:
            if (r2 == 0) goto L_0x010f
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0110
        L_0x010f:
            r0 = r3
        L_0x0110:
            r2 = r35 & 2
            if (r2 == 0) goto L_0x0122
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r3 = 6
            androidx.compose.material.Colors r2 = r2.getColors(r10, r3)
            long r2 = r2.m1449getSurface0d7_KjU()
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x0123
        L_0x0122:
            r2 = r4
        L_0x0123:
            r4 = r35 & 4
            if (r4 == 0) goto L_0x0132
            int r4 = r1 >> 3
            r4 = r4 & 14
            long r4 = androidx.compose.material.ColorsKt.m1463contentColorForek8zF_U(r2, r10, r4)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r6 = r4
        L_0x0132:
            if (r8 == 0) goto L_0x013b
            androidx.compose.material.NavigationRailDefaults r4 = androidx.compose.material.NavigationRailDefaults.INSTANCE
            float r4 = r4.m1552getElevationD9Ej5fM()
            r9 = r4
        L_0x013b:
            if (r13 == 0) goto L_0x013f
            r4 = 0
            goto L_0x0140
        L_0x013f:
            r4 = r14
        L_0x0140:
            r10.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0152
            r5 = -1
            java.lang.String r8 = "androidx.compose.material.NavigationRail (NavigationRail.kt:92)"
            r13 = 1790971523(0x6ac00e83, float:1.1609114E26)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r1, r5, r8)
        L_0x0152:
            r14 = 0
            r19 = 0
            androidx.compose.material.NavigationRailKt$NavigationRail$1 r5 = new androidx.compose.material.NavigationRailKt$NavigationRail$1
            r5.<init>(r4, r1, r11)
            r8 = -1571506489(0xffffffffa254b6c7, float:-2.882812E-18)
            r13 = 1
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r8, r13, r5)
            r21 = r5
            kotlin.jvm.functions.Function2 r21 = (kotlin.jvm.functions.Function2) r21
            r5 = r1 & 14
            r8 = 1572864(0x180000, float:2.204052E-39)
            r5 = r5 | r8
            int r8 = r1 << 3
            r8 = r8 & 896(0x380, float:1.256E-42)
            r5 = r5 | r8
            int r8 = r1 << 3
            r8 = r8 & 7168(0x1c00, float:1.0045E-41)
            r5 = r5 | r8
            int r8 = r1 << 6
            r8 = r8 & r16
            r23 = r5 | r8
            r24 = 18
            r13 = r0
            r15 = r2
            r17 = r6
            r20 = r9
            r22 = r10
            androidx.compose.material.SurfaceKt.m1620SurfaceFjzlyU(r13, r14, r15, r17, r19, r20, r21, r22, r23, r24)
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0193
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0193:
            r13 = r0
            r20 = r1
            r14 = r2
            r19 = r4
            r16 = r6
            r18 = r9
        L_0x019d:
            androidx.compose.runtime.ScopeUpdateScope r9 = r10.endRestartGroup()
            if (r9 != 0) goto L_0x01a6
            r22 = r10
            goto L_0x01c5
        L_0x01a6:
            androidx.compose.material.NavigationRailKt$NavigationRail$2 r21 = new androidx.compose.material.NavigationRailKt$NavigationRail$2
            r0 = r21
            r1 = r13
            r2 = r14
            r4 = r16
            r6 = r18
            r7 = r19
            r8 = r32
            r11 = r9
            r9 = r34
            r22 = r10
            r10 = r35
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10)
            r0 = r21
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x01c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.NavigationRailKt.m1553NavigationRailHsRjFd4(androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: NavigationRailItem-0S3VyRs  reason: not valid java name */
    public static final void m1554NavigationRailItem0S3VyRs(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> icon, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> label, boolean alwaysShowLabel, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, Composer $composer, int $changed, int i) {
        Function2 function2;
        long unselectedContentColor2;
        long unselectedContentColor3;
        Function2 label2;
        Modifier modifier2;
        MutableInteractionSource interactionSource2;
        long selectedContentColor2;
        boolean alwaysShowLabel2;
        boolean enabled2;
        long selectedContentColor3;
        boolean alwaysShowLabel3;
        Function2 label3;
        int $dirty;
        MutableInteractionSource interactionSource3;
        boolean enabled3;
        Function2 styledLabel;
        Modifier modifier3;
        boolean enabled4;
        MutableInteractionSource interactionSource4;
        Object value$iv$iv;
        int i2;
        int i3;
        Function0<Unit> function0 = onClick;
        Function2<? super Composer, ? super Integer, Unit> function22 = icon;
        int i4 = $changed;
        int i5 = i;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function22, "icon");
        Composer $composer2 = $composer.startRestartGroup(-1813548445);
        ComposerKt.sourceInformation($composer2, "C(NavigationRailItem)P(7,6,2,5,1,4!2,8:c#ui.graphics.Color,9:c#ui.graphics.Color)154@6931L39,155@7020L6,156@7090L7,156@7124L6,171@7922L83,175@8010L791:NavigationRail.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i5 & 1) != 0) {
            $dirty2 |= 6;
            boolean z = selected;
        } else if ((i4 & 14) == 0) {
            $dirty2 |= $composer2.changed(selected) ? 4 : 2;
        } else {
            boolean z2 = selected;
        }
        if ((i5 & 2) != 0) {
            $dirty2 |= 48;
        } else if ((i4 & 112) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if ((i5 & 4) != 0) {
            $dirty2 |= 384;
        } else if ((i4 & 896) == 0) {
            $dirty2 |= $composer2.changedInstance(function22) ? 256 : 128;
        }
        int i6 = i5 & 8;
        if (i6 != 0) {
            $dirty2 |= 3072;
            Modifier modifier4 = modifier;
        } else if ((i4 & 7168) == 0) {
            $dirty2 |= $composer2.changed((Object) modifier) ? 2048 : 1024;
        } else {
            Modifier modifier5 = modifier;
        }
        int i7 = i5 & 16;
        if (i7 != 0) {
            $dirty2 |= 24576;
            boolean z3 = enabled;
        } else if ((57344 & i4) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 16384 : 8192;
        } else {
            boolean z4 = enabled;
        }
        int i8 = i5 & 32;
        if (i8 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function2 = label;
        } else if ((458752 & i4) == 0) {
            function2 = label;
            $dirty2 |= $composer2.changedInstance(function2) ? 131072 : 65536;
        } else {
            function2 = label;
        }
        int i9 = i5 & 64;
        if (i9 != 0) {
            $dirty2 |= 1572864;
            boolean z5 = alwaysShowLabel;
        } else if ((3670016 & i4) == 0) {
            $dirty2 |= $composer2.changed(alwaysShowLabel) ? 1048576 : 524288;
        } else {
            boolean z6 = alwaysShowLabel;
        }
        int i10 = i5 & 128;
        if (i10 != 0) {
            $dirty2 |= 12582912;
            MutableInteractionSource mutableInteractionSource = interactionSource;
        } else if ((i4 & 29360128) == 0) {
            $dirty2 |= $composer2.changed((Object) interactionSource) ? 8388608 : 4194304;
        } else {
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
        }
        if ((i4 & 234881024) == 0) {
            if ((i5 & 256) != 0) {
                long j = selectedContentColor;
            } else if ($composer2.changed(selectedContentColor)) {
                i3 = 67108864;
                $dirty2 |= i3;
            }
            i3 = 33554432;
            $dirty2 |= i3;
        } else {
            long j2 = selectedContentColor;
        }
        if ((1879048192 & i4) == 0) {
            if ((i5 & 512) == 0) {
                unselectedContentColor2 = unselectedContentColor;
                if ($composer2.changed(unselectedContentColor2)) {
                    i2 = 536870912;
                    $dirty2 |= i2;
                }
            } else {
                unselectedContentColor2 = unselectedContentColor;
            }
            i2 = 268435456;
            $dirty2 |= i2;
        } else {
            unselectedContentColor2 = unselectedContentColor;
        }
        if ((1533916891 & $dirty2) != 306783378 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i4 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i7 != 0) {
                    enabled4 = true;
                } else {
                    enabled4 = enabled;
                }
                if (i8 != 0) {
                    label3 = null;
                } else {
                    label3 = function2;
                }
                if (i9 != 0) {
                    alwaysShowLabel3 = true;
                } else {
                    alwaysShowLabel3 = alwaysShowLabel;
                }
                if (i10 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer2;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        modifier2 = modifier3;
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        modifier2 = modifier3;
                        Composer composer = $this$cache$iv$iv;
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    interactionSource4 = (MutableInteractionSource) value$iv$iv;
                } else {
                    modifier2 = modifier3;
                    interactionSource4 = interactionSource;
                }
                if ((i5 & 256) != 0) {
                    selectedContentColor3 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1445getPrimary0d7_KjU();
                    $dirty2 &= -234881025;
                } else {
                    selectedContentColor3 = selectedContentColor;
                }
                if ((i5 & 512) != 0) {
                    MutableInteractionSource interactionSource5 = interactionSource4;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(ContentColorKt.getLocalContentColor());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    int i11 = -1879048193 & $dirty2;
                    interactionSource3 = interactionSource5;
                    unselectedContentColor2 = Color.m3163copywmQWz5c$default(((Color) consume).m3174unboximpl(), ContentAlpha.INSTANCE.getMedium($composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    $dirty = i11;
                    enabled3 = enabled4;
                } else {
                    MutableInteractionSource interactionSource6 = interactionSource4;
                    enabled3 = enabled4;
                    $dirty = $dirty2;
                    interactionSource3 = interactionSource6;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i5 & 256) != 0) {
                    $dirty2 &= -234881025;
                }
                if ((i5 & 512) != 0) {
                    int i12 = -1879048193 & $dirty2;
                    modifier2 = modifier;
                    alwaysShowLabel3 = alwaysShowLabel;
                    interactionSource3 = interactionSource;
                    $dirty = i12;
                    label3 = function2;
                    enabled3 = enabled;
                    selectedContentColor3 = selectedContentColor;
                } else {
                    modifier2 = modifier;
                    enabled3 = enabled;
                    alwaysShowLabel3 = alwaysShowLabel;
                    $dirty = $dirty2;
                    label3 = function2;
                    interactionSource3 = interactionSource;
                    selectedContentColor3 = selectedContentColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1813548445, $dirty, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:146)");
            }
            if (label3 != null) {
                Function2 function23 = label3;
                styledLabel = ComposableLambdaKt.composableLambda($composer2, -180398615, true, new NavigationRailKt$NavigationRailItem$styledLabel$1$1(label3, $dirty));
            } else {
                styledLabel = null;
            }
            float itemSize = label3 == null ? NavigationRailItemCompactSize : NavigationRailItemSize;
            Indication ripple = RippleKt.m1729rememberRipple9IZ8Weo(false, 0.0f, selectedContentColor3, $composer2, (($dirty >> 18) & 896) | 6, 2);
            boolean enabled5 = enabled3;
            Modifier modifier$iv = SizeKt.m830size3ABfNKs(SelectableKt.m1079selectableO2vRcR0(modifier2, selected, interactionSource3, ripple, enabled3, Role.m5306boximpl(Role.Companion.m5319getTabo7Vup1c()), onClick), itemSize);
            interactionSource2 = interactionSource3;
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            label2 = label3;
            float f = itemSize;
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Alignment alignment = contentAlignment$iv;
            Indication indication = ripple;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier6 = modifier$iv;
            int $changed$iv$iv$iv = ((((48 << 3) & 112) << 9) & 7168) | 6;
            unselectedContentColor3 = unselectedContentColor2;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer2);
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i13 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer2;
            int i14 = $changed$iv$iv$iv;
            Density density = density$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i15 = ((48 >> 6) & 112) | 6;
            MeasurePolicy measurePolicy = measurePolicy$iv;
            Composer $composer3 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, -1714406692, "C187@8378L417:NavigationRail.kt#jmzs0o");
            Function2 function24 = styledLabel;
            m1555NavigationRailTransitionKlgxPg(selectedContentColor3, unselectedContentColor3, selected, ComposableLambdaKt.composableLambda($composer3, 670576792, true, new NavigationRailKt$NavigationRailItem$2$1(alwaysShowLabel3, function22, styledLabel, $dirty)), $composer3, (($dirty >> 24) & 14) | 3072 | (($dirty >> 24) & 112) | (($dirty << 6) & 896));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            enabled2 = enabled5;
            int i16 = $dirty;
            alwaysShowLabel2 = alwaysShowLabel3;
            selectedContentColor2 = selectedContentColor3;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            enabled2 = enabled;
            alwaysShowLabel2 = alwaysShowLabel;
            interactionSource2 = interactionSource;
            selectedContentColor2 = selectedContentColor;
            int i17 = $dirty2;
            label2 = function2;
            unselectedContentColor3 = unselectedContentColor2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer2 = $composer2;
            boolean z7 = enabled2;
            return;
        }
        Composer composer3 = $composer2;
        boolean z8 = enabled2;
        endRestartGroup.updateScope(new NavigationRailKt$NavigationRailItem$3(selected, onClick, icon, modifier2, enabled2, label2, alwaysShowLabel2, interactionSource2, selectedContentColor2, unselectedContentColor3, $changed, i));
    }

    /* access modifiers changed from: private */
    /* renamed from: NavigationRailTransition-Klgx-Pg  reason: not valid java name */
    public static final void m1555NavigationRailTransitionKlgxPg(long activeColor, long inactiveColor, boolean selected, Function3<? super Float, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int $dirty;
        long j = activeColor;
        long j2 = inactiveColor;
        boolean z = selected;
        Function3<? super Float, ? super Composer, ? super Integer, Unit> function3 = content;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-207161906);
        ComposerKt.sourceInformation($composer2, "C(NavigationRailTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)232@9909L126,239@10110L181:NavigationRail.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 14) == 0) {
            $dirty2 |= $composer2.changed(j) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty2 |= $composer2.changed(j2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty2 |= $composer2.changed(z) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        int $dirty3 = $dirty2;
        if (($dirty3 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-207161906, $dirty3, -1, "androidx.compose.material.NavigationRailTransition (NavigationRail.kt:226)");
            }
            State animationProgress$delegate = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, NavigationRailAnimationSpec, 0.0f, (Function1) null, $composer2, 48, 12);
            long color = ColorKt.m3215lerpjxsXWHM(j2, j, NavigationRailTransition_Klgx_Pg$lambda$3(animationProgress$delegate));
            $dirty = $dirty3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(Color.m3163copywmQWz5c$default(color, 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3166getAlphaimpl(color)))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, -1688205042, true, new NavigationRailKt$NavigationRailTransition$1(function3, $dirty, animationProgress$delegate)), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            $dirty = $dirty3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i2 = $dirty;
            return;
        }
        int i3 = $dirty;
        endRestartGroup.updateScope(new NavigationRailKt$NavigationRailTransition$2(activeColor, inactiveColor, selected, content, $changed));
    }

    /* access modifiers changed from: private */
    public static final float NavigationRailTransition_Klgx_Pg$lambda$3(State<Float> $animationProgress$delegate) {
        return ((Number) $animationProgress$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final void NavigationRailItemBaselineLayout(Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> label, float iconPositionAnimationProgress, Composer $composer, int $changed) {
        Function2<? super Composer, ? super Integer, Unit> function2 = icon;
        Function2<? super Composer, ? super Integer, Unit> function22 = label;
        float f = iconPositionAnimationProgress;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-1903861684);
        ComposerKt.sourceInformation($composer2, "C(NavigationRailItemBaselineLayout)P(!1,2)264@10960L1118:NavigationRail.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changed(f) ? 256 : 128;
        }
        if (($dirty & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1903861684, $dirty, -1, "androidx.compose.material.NavigationRailItemBaselineLayout (NavigationRail.kt:258)");
            }
            MeasurePolicy measurePolicy$iv = new NavigationRailKt$NavigationRailItemBaselineLayout$2(function22, f);
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m2787constructorimpl($composer2);
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            MeasurePolicy measurePolicy = measurePolicy$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            function3.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            ViewConfiguration viewConfiguration = viewConfiguration$iv;
            Composer $composer3 = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer3, 116750785, "C266@10990L41:NavigationRail.kt#jmzs0o");
            Modifier modifier$iv2 = LayoutIdKt.layoutId(Modifier.Companion, "icon");
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            int i2 = ($changed$iv$iv >> 9) & 14;
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            Modifier modifier = modifier$iv;
            Density density = density$iv;
            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            Alignment alignment = contentAlignment$iv;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            LayoutDirection layoutDirection = layoutDirection$iv;
            Function0<ComposeUiNode> function0 = constructor;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv = (Density) consume4;
            int i3 = $changed$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume5;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(modifier$iv2);
            Modifier modifier2 = modifier$iv2;
            int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = materializerOf2;
            String str = "C:CompositionLocal.kt#9igjgp";
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor2);
            } else {
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer3);
            Function0<ComposeUiNode> function02 = constructor2;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer3.enableReusing();
            ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = function33;
            function34.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i4 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer3;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function35 = function34;
            int i5 = $changed$iv$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            int i6 = ((6 >> 6) & 112) | 6;
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            Density density2 = density$iv$iv;
            Composer $composer4 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer4, 2053494659, "C266@11023L6:NavigationRail.kt#jmzs0o");
            function2.invoke($composer4, Integer.valueOf($dirty & 14));
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            $composer2.startReplaceableGroup(286683862);
            ComposerKt.sourceInformation($composer2, "268@11081L168");
            if (function22 != null) {
                Modifier modifier$iv3 = AlphaKt.alpha(LayoutIdKt.layoutId(Modifier.Companion, "label"), f);
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv2 = (0 << 3) & 112;
                Alignment alignment2 = contentAlignment$iv2;
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                String str2 = str;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str2);
                Object consume7 = $composer3.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv2 = (Density) consume7;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str2);
                Object consume8 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume8;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str2);
                Object consume9 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume9;
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv3);
                Modifier modifier3 = modifier$iv3;
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                int i7 = $changed$iv$iv2;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(constructor3);
                } else {
                    $composer3.useNode();
                }
                $composer3.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2787constructorimpl($composer3);
                Function0<ComposeUiNode> function03 = constructor3;
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer3.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i8 = ($changed$iv$iv$iv2 >> 9) & 14;
                Composer $composer$iv2 = $composer3;
                int i9 = $changed$iv$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i10 = ((0 >> 6) & 112) | 6;
                Composer $composer5 = $composer$iv2;
                ComposerKt.sourceInformationMarkerStart($composer5, 2053494876, "C272@11240L7:NavigationRail.kt#jmzs0o");
                function22.invoke($composer5, Integer.valueOf(($dirty >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            }
            $composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i11 = $changed;
        } else {
            endRestartGroup.updateScope(new NavigationRailKt$NavigationRailItemBaselineLayout$3(function2, function22, f, $changed));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: placeIcon-3p2s80s  reason: not valid java name */
    public static final MeasureResult m1559placeIcon3p2s80s(MeasureScope $this$placeIcon_u2d3p2s80s, Placeable iconPlaceable, long constraints) {
        return MeasureScope.layout$default($this$placeIcon_u2d3p2s80s, Constraints.m5930getMaxWidthimpl(constraints), Constraints.m5929getMaxHeightimpl(constraints), (Map) null, new NavigationRailKt$placeIcon$1(iconPlaceable, Math.max(0, (Constraints.m5930getMaxWidthimpl(constraints) - iconPlaceable.getWidth()) / 2), Math.max(0, (Constraints.m5929getMaxHeightimpl(constraints) - iconPlaceable.getHeight()) / 2)), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-DIyivk0  reason: not valid java name */
    public static final MeasureResult m1560placeLabelAndIconDIyivk0(MeasureScope $this$placeLabelAndIcon_u2dDIyivk0, Placeable labelPlaceable, Placeable iconPlaceable, long constraints, float iconPositionAnimationProgress) {
        MeasureScope measureScope = $this$placeLabelAndIcon_u2dDIyivk0;
        int baseline = labelPlaceable.get(AlignmentLineKt.getLastBaseline());
        int labelY = (Constraints.m5929getMaxHeightimpl(constraints) - baseline) - measureScope.m5961roundToPx0680j_4(ItemLabelBaselineBottomOffset);
        int labelX = (Constraints.m5930getMaxWidthimpl(constraints) - labelPlaceable.getWidth()) / 2;
        int selectedIconY = measureScope.m5961roundToPx0680j_4(ItemIconTopOffset);
        int unselectedIconY = (Constraints.m5929getMaxHeightimpl(constraints) - iconPlaceable.getHeight()) / 2;
        int iconX = (Constraints.m5930getMaxWidthimpl(constraints) - iconPlaceable.getWidth()) / 2;
        int iconDistance = unselectedIconY - selectedIconY;
        int i = iconDistance;
        return MeasureScope.layout$default($this$placeLabelAndIcon_u2dDIyivk0, Constraints.m5930getMaxWidthimpl(constraints), Constraints.m5929getMaxHeightimpl(constraints), (Map) null, new NavigationRailKt$placeLabelAndIcon$1(iconPositionAnimationProgress, labelPlaceable, labelX, labelY, MathKt.roundToInt(((float) iconDistance) * (((float) 1) - iconPositionAnimationProgress)), iconPlaceable, iconX, selectedIconY), 4, (Object) null);
    }
}
