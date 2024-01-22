package androidx.compose.animation;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001ak\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0003¢\u0006\u0002\u0010\u0012\u001aR\u0010\u0000\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\b¢\u0006\u0002\u0010\u0014\u001aa\u0010\u0015\u001a\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u001a\u001aJ\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00072\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001d\u001a[\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u001e\u001am\u0010\u0015\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u001f\u001ae\u0010\u0015\u001a\u00020\u0001*\u00020 2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010!\u001a_\u0010\u0015\u001a\u00020\u0001*\u00020 2\u0006\u0010\u0005\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\"\u001ae\u0010\u0015\u001a\u00020\u0001*\u00020#2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010$\u001a_\u0010\u0015\u001a\u00020\u0001*\u00020#2\u0006\u0010\u0005\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010%\u001a9\u0010&\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010'\u001a\u0002H\u0002H\u0003¢\u0006\u0002\u0010(¨\u0006)"}, d2 = {"AnimatedEnterExitImpl", "", "T", "transition", "Landroidx/compose/animation/core/Transition;", "visible", "Lkotlin/Function1;", "", "modifier", "Landroidx/compose/ui/Modifier;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "content", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/animation/EnterExitState;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "AnimatedVisibility", "visibleState", "Landroidx/compose/animation/core/MutableTransitionState;", "label", "", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "initiallyVisible", "Lkotlin/Function0;", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/ColumnScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/RowScope;", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/RowScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "targetEnterExit", "targetState", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterExitState;", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedVisibility.kt */
public final class AnimatedVisibilityKt {
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(boolean r29, androidx.compose.ui.Modifier r30, androidx.compose.animation.EnterTransition r31, androidx.compose.animation.ExitTransition r32, java.lang.String r33, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r9 = r34
            r10 = r36
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 2088733774(0x7c7f8c4e, float:5.3075257E36)
            r1 = r35
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AnimatedVisibility)P(5,4,1,2,3)127@6727L32,128@6764L73:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r36
            r2 = r37 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            r12 = r29
            goto L_0x0035
        L_0x0022:
            r2 = r10 & 14
            if (r2 != 0) goto L_0x0033
            r12 = r29
            boolean r2 = r11.changed((boolean) r12)
            if (r2 == 0) goto L_0x0030
            r2 = 4
            goto L_0x0031
        L_0x0030:
            r2 = 2
        L_0x0031:
            r1 = r1 | r2
            goto L_0x0035
        L_0x0033:
            r12 = r29
        L_0x0035:
            r2 = r37 & 2
            if (r2 == 0) goto L_0x003e
            r1 = r1 | 48
            r3 = r30
            goto L_0x0053
        L_0x003e:
            r3 = r10 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0051
            r3 = r30
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x004d
            r4 = 32
            goto L_0x004f
        L_0x004d:
            r4 = 16
        L_0x004f:
            r1 = r1 | r4
            goto L_0x0053
        L_0x0051:
            r3 = r30
        L_0x0053:
            r4 = r37 & 4
            if (r4 == 0) goto L_0x005c
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r31
            goto L_0x0071
        L_0x005c:
            r5 = r10 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x006f
            r5 = r31
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x006b
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x006d
        L_0x006b:
            r6 = 128(0x80, float:1.794E-43)
        L_0x006d:
            r1 = r1 | r6
            goto L_0x0071
        L_0x006f:
            r5 = r31
        L_0x0071:
            r6 = r37 & 8
            if (r6 == 0) goto L_0x007a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r32
            goto L_0x008f
        L_0x007a:
            r7 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x008d
            r7 = r32
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0089
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x008b
        L_0x0089:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x008b:
            r1 = r1 | r8
            goto L_0x008f
        L_0x008d:
            r7 = r32
        L_0x008f:
            r8 = r37 & 16
            r13 = 57344(0xe000, float:8.0356E-41)
            if (r8 == 0) goto L_0x009b
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r14 = r33
            goto L_0x00b0
        L_0x009b:
            r14 = r10 & r13
            if (r14 != 0) goto L_0x00ae
            r14 = r33
            boolean r15 = r11.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00aa
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ac
        L_0x00aa:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00ac:
            r1 = r1 | r15
            goto L_0x00b0
        L_0x00ae:
            r14 = r33
        L_0x00b0:
            r15 = r37 & 32
            r16 = 458752(0x70000, float:6.42848E-40)
            if (r15 == 0) goto L_0x00ba
            r15 = 196608(0x30000, float:2.75506E-40)
        L_0x00b8:
            r1 = r1 | r15
            goto L_0x00ca
        L_0x00ba:
            r15 = r10 & r16
            if (r15 != 0) goto L_0x00ca
            boolean r15 = r11.changed((java.lang.Object) r9)
            if (r15 == 0) goto L_0x00c7
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00c7:
            r15 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b8
        L_0x00ca:
            r15 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r15
            r13 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r13) goto L_0x00e5
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L_0x00db
            goto L_0x00e5
        L_0x00db:
            r11.skipToGroupEnd()
            r13 = r3
            r17 = r5
            r18 = r7
            goto L_0x0183
        L_0x00e5:
            if (r2 == 0) goto L_0x00ed
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r13 = r1
            goto L_0x00ee
        L_0x00ed:
            r13 = r3
        L_0x00ee:
            r1 = 0
            r2 = 0
            r3 = 3
            if (r4 == 0) goto L_0x010e
            androidx.compose.animation.EnterTransition r4 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r2, r1, r3, r2)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 15
            r22 = 0
            androidx.compose.animation.EnterTransition r0 = androidx.compose.animation.EnterExitTransitionKt.expandIn$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.EnterTransition r0 = r4.plus(r0)
            r17 = r0
            goto L_0x0110
        L_0x010e:
            r17 = r5
        L_0x0110:
            if (r6 == 0) goto L_0x012d
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 15
            r28 = 0
            androidx.compose.animation.ExitTransition r0 = androidx.compose.animation.EnterExitTransitionKt.shrinkOut$default(r23, r24, r25, r26, r27, r28)
            androidx.compose.animation.ExitTransition r1 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r2, r1, r3, r2)
            androidx.compose.animation.ExitTransition r0 = r0.plus(r1)
            r18 = r0
            goto L_0x012f
        L_0x012d:
            r18 = r7
        L_0x012f:
            if (r8 == 0) goto L_0x0134
            java.lang.String r0 = "AnimatedVisibility"
            r14 = r0
        L_0x0134:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0143
            r0 = -1
            java.lang.String r1 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:119)"
            r2 = 2088733774(0x7c7f8c4e, float:5.3075257E36)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r15, r0, r1)
        L_0x0143:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r29)
            r1 = r15 & 14
            int r2 = r15 >> 9
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = 0
            androidx.compose.animation.core.Transition r8 = androidx.compose.animation.core.TransitionKt.updateTransition(r0, (java.lang.String) r14, (androidx.compose.runtime.Composer) r11, (int) r1, (int) r2)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1 r0 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1.INSTANCE
            r1 = r0
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            int r0 = r15 << 3
            r0 = r0 & 896(0x380, float:1.256E-42)
            r0 = r0 | 48
            int r2 = r15 << 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r15 << 3
            r3 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r3
            r0 = r0 | r2
            r2 = r15 & r16
            r7 = r0 | r2
            r0 = r8
            r2 = r13
            r3 = r17
            r4 = r18
            r5 = r34
            r6 = r11
            AnimatedEnterExitImpl(r0, r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0183
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0183:
            androidx.compose.runtime.ScopeUpdateScope r8 = r11.endRestartGroup()
            if (r8 != 0) goto L_0x018a
            goto L_0x01a7
        L_0x018a:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$2 r16 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$2
            r0 = r16
            r1 = r29
            r2 = r13
            r3 = r17
            r4 = r18
            r5 = r14
            r6 = r34
            r7 = r36
            r9 = r8
            r8 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x01a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.foundation.layout.RowScope r25, boolean r26, androidx.compose.ui.Modifier r27, androidx.compose.animation.EnterTransition r28, androidx.compose.animation.ExitTransition r29, java.lang.String r30, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r10 = r31
            r11 = r33
            java.lang.String r0 = "<this>"
            r12 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -1741346906(0xffffffff983527a6, float:-2.341372E-24)
            r1 = r32
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AnimatedVisibility)P(5,4,1,2,3)202@11021L32,203@11058L73:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r33
            r2 = r34 & 1
            if (r2 == 0) goto L_0x0029
            r1 = r1 | 48
            r14 = r26
            goto L_0x003e
        L_0x0029:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x003c
            r14 = r26
            boolean r2 = r13.changed((boolean) r14)
            if (r2 == 0) goto L_0x0038
            r2 = 32
            goto L_0x003a
        L_0x0038:
            r2 = 16
        L_0x003a:
            r1 = r1 | r2
            goto L_0x003e
        L_0x003c:
            r14 = r26
        L_0x003e:
            r2 = r34 & 2
            if (r2 == 0) goto L_0x0047
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r27
            goto L_0x005c
        L_0x0047:
            r3 = r11 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x005a
            r3 = r27
            boolean r4 = r13.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0056
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0058
        L_0x0056:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0058:
            r1 = r1 | r4
            goto L_0x005c
        L_0x005a:
            r3 = r27
        L_0x005c:
            r4 = r34 & 4
            if (r4 == 0) goto L_0x0065
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r28
            goto L_0x007a
        L_0x0065:
            r5 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0078
            r5 = r28
            boolean r6 = r13.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0074
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0076
        L_0x0074:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0076:
            r1 = r1 | r6
            goto L_0x007a
        L_0x0078:
            r5 = r28
        L_0x007a:
            r6 = r34 & 8
            r7 = 57344(0xe000, float:8.0356E-41)
            if (r6 == 0) goto L_0x0086
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r8 = r29
            goto L_0x009b
        L_0x0086:
            r8 = r11 & r7
            if (r8 != 0) goto L_0x0099
            r8 = r29
            boolean r9 = r13.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0095
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r1 = r1 | r9
            goto L_0x009b
        L_0x0099:
            r8 = r29
        L_0x009b:
            r9 = r34 & 16
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r9 == 0) goto L_0x00a8
            r16 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r16
            r15 = r30
            goto L_0x00be
        L_0x00a8:
            r16 = r11 & r15
            if (r16 != 0) goto L_0x00bc
            r15 = r30
            boolean r16 = r13.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00b7
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00b7:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b9:
            r1 = r1 | r16
            goto L_0x00be
        L_0x00bc:
            r15 = r30
        L_0x00be:
            r16 = r34 & 32
            if (r16 == 0) goto L_0x00c7
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00c4:
            r1 = r1 | r16
            goto L_0x00d9
        L_0x00c7:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r11 & r16
            if (r16 != 0) goto L_0x00d9
            boolean r16 = r13.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x00d6
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c4
        L_0x00d6:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00c4
        L_0x00d9:
            r16 = 2995921(0x2db6d1, float:4.19818E-39)
            r7 = r1 & r16
            r0 = 599184(0x92490, float:8.39636E-40)
            if (r7 != r0) goto L_0x00f8
            boolean r0 = r13.getSkipping()
            if (r0 != 0) goto L_0x00ea
            goto L_0x00f8
        L_0x00ea:
            r13.skipToGroupEnd()
            r16 = r1
            r18 = r3
            r19 = r5
            r17 = r15
            r15 = r8
            goto L_0x0194
        L_0x00f8:
            if (r2 == 0) goto L_0x0101
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r18 = r0
            goto L_0x0103
        L_0x0101:
            r18 = r3
        L_0x0103:
            r0 = 0
            r2 = 3
            r3 = 0
            if (r4 == 0) goto L_0x0123
            androidx.compose.animation.EnterTransition r4 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r3, r0, r2, r3)
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 15
            r24 = 0
            androidx.compose.animation.EnterTransition r7 = androidx.compose.animation.EnterExitTransitionKt.expandHorizontally$default(r19, r20, r21, r22, r23, r24)
            androidx.compose.animation.EnterTransition r4 = r4.plus(r7)
            r19 = r4
            goto L_0x0125
        L_0x0123:
            r19 = r5
        L_0x0125:
            if (r6 == 0) goto L_0x013b
            androidx.compose.animation.ExitTransition r0 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r3, r0, r2, r3)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 15
            r7 = 0
            androidx.compose.animation.ExitTransition r2 = androidx.compose.animation.EnterExitTransitionKt.shrinkHorizontally$default(r2, r3, r4, r5, r6, r7)
            androidx.compose.animation.ExitTransition r0 = r0.plus(r2)
            r8 = r0
        L_0x013b:
            if (r9 == 0) goto L_0x0140
            java.lang.String r0 = "AnimatedVisibility"
            r15 = r0
        L_0x0140:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x014f
            r0 = -1
            java.lang.String r2 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:194)"
            r3 = -1741346906(0xffffffff983527a6, float:-2.341372E-24)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r0, r2)
        L_0x014f:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r26)
            int r2 = r1 >> 3
            r2 = r2 & 14
            int r3 = r1 >> 12
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r3 = 0
            androidx.compose.animation.core.Transition r9 = androidx.compose.animation.core.TransitionKt.updateTransition(r0, (java.lang.String) r15, (androidx.compose.runtime.Composer) r13, (int) r2, (int) r3)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3 r0 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3.INSTANCE
            r2 = r0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r0 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | 48
            r3 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r1
            r0 = r0 | r3
            int r3 = r1 >> 3
            r4 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r4
            r7 = r0 | r3
            r0 = r9
            r16 = r1
            r1 = r2
            r2 = r18
            r3 = r19
            r4 = r8
            r5 = r31
            r6 = r13
            AnimatedEnterExitImpl(r0, r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0191
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0191:
            r17 = r15
            r15 = r8
        L_0x0194:
            androidx.compose.runtime.ScopeUpdateScope r9 = r13.endRestartGroup()
            if (r9 != 0) goto L_0x019b
            goto L_0x01bb
        L_0x019b:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$4 r20 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$4
            r0 = r20
            r1 = r25
            r2 = r26
            r3 = r18
            r4 = r19
            r5 = r15
            r6 = r17
            r7 = r31
            r8 = r33
            r10 = r9
            r9 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x01bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.RowScope, boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.foundation.layout.ColumnScope r25, boolean r26, androidx.compose.ui.Modifier r27, androidx.compose.animation.EnterTransition r28, androidx.compose.animation.ExitTransition r29, java.lang.String r30, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r10 = r31
            r11 = r33
            java.lang.String r0 = "<this>"
            r12 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 1766503102(0x694ab2be, float:1.5315444E25)
            r1 = r32
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AnimatedVisibility)P(5,4,1,2,3)275@15293L32,276@15330L73:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r33
            r2 = r34 & 1
            if (r2 == 0) goto L_0x0029
            r1 = r1 | 48
            r14 = r26
            goto L_0x003e
        L_0x0029:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x003c
            r14 = r26
            boolean r2 = r13.changed((boolean) r14)
            if (r2 == 0) goto L_0x0038
            r2 = 32
            goto L_0x003a
        L_0x0038:
            r2 = 16
        L_0x003a:
            r1 = r1 | r2
            goto L_0x003e
        L_0x003c:
            r14 = r26
        L_0x003e:
            r2 = r34 & 2
            if (r2 == 0) goto L_0x0047
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r27
            goto L_0x005c
        L_0x0047:
            r3 = r11 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x005a
            r3 = r27
            boolean r4 = r13.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0056
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0058
        L_0x0056:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0058:
            r1 = r1 | r4
            goto L_0x005c
        L_0x005a:
            r3 = r27
        L_0x005c:
            r4 = r34 & 4
            if (r4 == 0) goto L_0x0065
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r28
            goto L_0x007a
        L_0x0065:
            r5 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0078
            r5 = r28
            boolean r6 = r13.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0074
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0076
        L_0x0074:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0076:
            r1 = r1 | r6
            goto L_0x007a
        L_0x0078:
            r5 = r28
        L_0x007a:
            r6 = r34 & 8
            r7 = 57344(0xe000, float:8.0356E-41)
            if (r6 == 0) goto L_0x0086
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r8 = r29
            goto L_0x009b
        L_0x0086:
            r8 = r11 & r7
            if (r8 != 0) goto L_0x0099
            r8 = r29
            boolean r9 = r13.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0095
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r1 = r1 | r9
            goto L_0x009b
        L_0x0099:
            r8 = r29
        L_0x009b:
            r9 = r34 & 16
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r9 == 0) goto L_0x00a8
            r16 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r16
            r15 = r30
            goto L_0x00be
        L_0x00a8:
            r16 = r11 & r15
            if (r16 != 0) goto L_0x00bc
            r15 = r30
            boolean r16 = r13.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00b7
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00b7:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b9:
            r1 = r1 | r16
            goto L_0x00be
        L_0x00bc:
            r15 = r30
        L_0x00be:
            r16 = r34 & 32
            if (r16 == 0) goto L_0x00c7
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00c4:
            r1 = r1 | r16
            goto L_0x00d9
        L_0x00c7:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r11 & r16
            if (r16 != 0) goto L_0x00d9
            boolean r16 = r13.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x00d6
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c4
        L_0x00d6:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00c4
        L_0x00d9:
            r16 = 2995921(0x2db6d1, float:4.19818E-39)
            r7 = r1 & r16
            r0 = 599184(0x92490, float:8.39636E-40)
            if (r7 != r0) goto L_0x00f8
            boolean r0 = r13.getSkipping()
            if (r0 != 0) goto L_0x00ea
            goto L_0x00f8
        L_0x00ea:
            r13.skipToGroupEnd()
            r16 = r1
            r18 = r3
            r19 = r5
            r17 = r15
            r15 = r8
            goto L_0x0194
        L_0x00f8:
            if (r2 == 0) goto L_0x0101
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r18 = r0
            goto L_0x0103
        L_0x0101:
            r18 = r3
        L_0x0103:
            r0 = 0
            r2 = 3
            r3 = 0
            if (r4 == 0) goto L_0x0123
            androidx.compose.animation.EnterTransition r4 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r3, r0, r2, r3)
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 15
            r24 = 0
            androidx.compose.animation.EnterTransition r7 = androidx.compose.animation.EnterExitTransitionKt.expandVertically$default(r19, r20, r21, r22, r23, r24)
            androidx.compose.animation.EnterTransition r4 = r4.plus(r7)
            r19 = r4
            goto L_0x0125
        L_0x0123:
            r19 = r5
        L_0x0125:
            if (r6 == 0) goto L_0x013b
            androidx.compose.animation.ExitTransition r0 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r3, r0, r2, r3)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 15
            r7 = 0
            androidx.compose.animation.ExitTransition r2 = androidx.compose.animation.EnterExitTransitionKt.shrinkVertically$default(r2, r3, r4, r5, r6, r7)
            androidx.compose.animation.ExitTransition r0 = r0.plus(r2)
            r8 = r0
        L_0x013b:
            if (r9 == 0) goto L_0x0140
            java.lang.String r0 = "AnimatedVisibility"
            r15 = r0
        L_0x0140:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x014f
            r0 = -1
            java.lang.String r2 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:267)"
            r3 = 1766503102(0x694ab2be, float:1.5315444E25)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r0, r2)
        L_0x014f:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r26)
            int r2 = r1 >> 3
            r2 = r2 & 14
            int r3 = r1 >> 12
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r3 = 0
            androidx.compose.animation.core.Transition r9 = androidx.compose.animation.core.TransitionKt.updateTransition(r0, (java.lang.String) r15, (androidx.compose.runtime.Composer) r13, (int) r2, (int) r3)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5 r0 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5.INSTANCE
            r2 = r0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r0 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | 48
            r3 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r1
            r0 = r0 | r3
            int r3 = r1 >> 3
            r4 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r4
            r7 = r0 | r3
            r0 = r9
            r16 = r1
            r1 = r2
            r2 = r18
            r3 = r19
            r4 = r8
            r5 = r31
            r6 = r13
            AnimatedEnterExitImpl(r0, r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0191
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0191:
            r17 = r15
            r15 = r8
        L_0x0194:
            androidx.compose.runtime.ScopeUpdateScope r9 = r13.endRestartGroup()
            if (r9 != 0) goto L_0x019b
            goto L_0x01bb
        L_0x019b:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$6 r20 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$6
            r0 = r20
            r1 = r25
            r2 = r26
            r3 = r18
            r4 = r19
            r5 = r15
            r6 = r17
            r7 = r31
            r8 = r33
            r10 = r9
            r9 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x01bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.ColumnScope, boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r23, androidx.compose.ui.Modifier r24, androidx.compose.animation.EnterTransition r25, androidx.compose.animation.ExitTransition r26, java.lang.String r27, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r9 = r23
            r10 = r28
            r11 = r30
            java.lang.String r0 = "visibleState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -222898426(0xfffffffff2b6d706, float:-7.243036E30)
            r1 = r29
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AnimatedVisibility)P(5,4,1,2,3)381@20708L37,382@20750L73:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r30
            r2 = r31 & 1
            if (r2 == 0) goto L_0x0028
            r1 = r1 | 6
            goto L_0x0036
        L_0x0028:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0036
            boolean r2 = r12.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x0034
            r2 = 4
            goto L_0x0035
        L_0x0034:
            r2 = 2
        L_0x0035:
            r1 = r1 | r2
        L_0x0036:
            r2 = r31 & 2
            if (r2 == 0) goto L_0x003f
            r1 = r1 | 48
            r3 = r24
            goto L_0x0054
        L_0x003f:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0052
            r3 = r24
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x004e
            r4 = 32
            goto L_0x0050
        L_0x004e:
            r4 = 16
        L_0x0050:
            r1 = r1 | r4
            goto L_0x0054
        L_0x0052:
            r3 = r24
        L_0x0054:
            r4 = r31 & 4
            if (r4 == 0) goto L_0x005d
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r25
            goto L_0x0072
        L_0x005d:
            r5 = r11 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0070
            r5 = r25
            boolean r6 = r12.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x006c
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r6 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r1 = r1 | r6
            goto L_0x0072
        L_0x0070:
            r5 = r25
        L_0x0072:
            r6 = r31 & 8
            if (r6 == 0) goto L_0x007b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r26
            goto L_0x0090
        L_0x007b:
            r7 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x008e
            r7 = r26
            boolean r8 = r12.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x008a
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x008c
        L_0x008a:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x008c:
            r1 = r1 | r8
            goto L_0x0090
        L_0x008e:
            r7 = r26
        L_0x0090:
            r8 = r31 & 16
            r13 = 57344(0xe000, float:8.0356E-41)
            if (r8 == 0) goto L_0x009c
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r14 = r27
            goto L_0x00b1
        L_0x009c:
            r14 = r11 & r13
            if (r14 != 0) goto L_0x00af
            r14 = r27
            boolean r15 = r12.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00ab
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ad
        L_0x00ab:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00ad:
            r1 = r1 | r15
            goto L_0x00b1
        L_0x00af:
            r14 = r27
        L_0x00b1:
            r15 = r31 & 32
            r16 = 458752(0x70000, float:6.42848E-40)
            if (r15 == 0) goto L_0x00bb
            r15 = 196608(0x30000, float:2.75506E-40)
        L_0x00b9:
            r1 = r1 | r15
            goto L_0x00cb
        L_0x00bb:
            r15 = r11 & r16
            if (r15 != 0) goto L_0x00cb
            boolean r15 = r12.changed((java.lang.Object) r10)
            if (r15 == 0) goto L_0x00c8
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00c8:
            r15 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b9
        L_0x00cb:
            r15 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r15
            r13 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r13) goto L_0x00e6
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x00dc
            goto L_0x00e6
        L_0x00dc:
            r12.skipToGroupEnd()
            r13 = r3
            r17 = r5
            r18 = r7
            goto L_0x017e
        L_0x00e6:
            if (r2 == 0) goto L_0x00ee
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r13 = r1
            goto L_0x00ef
        L_0x00ee:
            r13 = r3
        L_0x00ef:
            r1 = 0
            r2 = 0
            r3 = 3
            if (r4 == 0) goto L_0x010f
            androidx.compose.animation.EnterTransition r4 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r2, r1, r3, r2)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 15
            r22 = 0
            androidx.compose.animation.EnterTransition r0 = androidx.compose.animation.EnterExitTransitionKt.expandIn$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.EnterTransition r0 = r4.plus(r0)
            r17 = r0
            goto L_0x0111
        L_0x010f:
            r17 = r5
        L_0x0111:
            if (r6 == 0) goto L_0x0129
            androidx.compose.animation.ExitTransition r0 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r2, r1, r3, r2)
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 15
            r6 = 0
            androidx.compose.animation.ExitTransition r1 = androidx.compose.animation.EnterExitTransitionKt.shrinkOut$default(r1, r2, r3, r4, r5, r6)
            androidx.compose.animation.ExitTransition r0 = r0.plus(r1)
            r18 = r0
            goto L_0x012b
        L_0x0129:
            r18 = r7
        L_0x012b:
            if (r8 == 0) goto L_0x0130
            java.lang.String r0 = "AnimatedVisibility"
            r14 = r0
        L_0x0130:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x013f
            r0 = -1
            java.lang.String r1 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:373)"
            r2 = -222898426(0xfffffffff2b6d706, float:-7.243036E30)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r15, r0, r1)
        L_0x013f:
            int r0 = androidx.compose.animation.core.MutableTransitionState.$stable
            r1 = r15 & 14
            r0 = r0 | r1
            int r1 = r15 >> 9
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = 0
            androidx.compose.animation.core.Transition r8 = androidx.compose.animation.core.TransitionKt.updateTransition(r9, (java.lang.String) r14, (androidx.compose.runtime.Composer) r12, (int) r0, (int) r1)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7 r0 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7.INSTANCE
            r1 = r0
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            int r0 = r15 << 3
            r0 = r0 & 896(0x380, float:1.256E-42)
            r0 = r0 | 48
            int r2 = r15 << 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r15 << 3
            r3 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r3
            r0 = r0 | r2
            r2 = r15 & r16
            r7 = r0 | r2
            r0 = r8
            r2 = r13
            r3 = r17
            r4 = r18
            r5 = r28
            r6 = r12
            AnimatedEnterExitImpl(r0, r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x017e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x017e:
            androidx.compose.runtime.ScopeUpdateScope r8 = r12.endRestartGroup()
            if (r8 != 0) goto L_0x0185
            goto L_0x01a2
        L_0x0185:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$8 r16 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$8
            r0 = r16
            r1 = r23
            r2 = r13
            r3 = r17
            r4 = r18
            r5 = r14
            r6 = r28
            r7 = r30
            r9 = r8
            r8 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x01a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.animation.core.MutableTransitionState, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.foundation.layout.RowScope r26, androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r27, androidx.compose.ui.Modifier r28, androidx.compose.animation.EnterTransition r29, androidx.compose.animation.ExitTransition r30, java.lang.String r31, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r10 = r27
            r11 = r32
            r12 = r34
            java.lang.String r0 = "<this>"
            r13 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "visibleState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 836509870(0x31dc20ae, float:6.406558E-9)
            r1 = r33
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AnimatedVisibility)P(5,4,1,2,3)456@25058L37,457@25100L73:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r34
            r2 = r35 & 1
            if (r2 == 0) goto L_0x002f
            r1 = r1 | 48
            goto L_0x003f
        L_0x002f:
            r2 = r12 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x003f
            boolean r2 = r14.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x003c
            r2 = 32
            goto L_0x003e
        L_0x003c:
            r2 = 16
        L_0x003e:
            r1 = r1 | r2
        L_0x003f:
            r2 = r35 & 2
            if (r2 == 0) goto L_0x0048
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r28
            goto L_0x005d
        L_0x0048:
            r3 = r12 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x005b
            r3 = r28
            boolean r4 = r14.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0057
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0059
        L_0x0057:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0059:
            r1 = r1 | r4
            goto L_0x005d
        L_0x005b:
            r3 = r28
        L_0x005d:
            r4 = r35 & 4
            if (r4 == 0) goto L_0x0066
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r29
            goto L_0x007b
        L_0x0066:
            r5 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0079
            r5 = r29
            boolean r6 = r14.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0075
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r1 = r1 | r6
            goto L_0x007b
        L_0x0079:
            r5 = r29
        L_0x007b:
            r6 = r35 & 8
            r7 = 57344(0xe000, float:8.0356E-41)
            if (r6 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r8 = r30
            goto L_0x009c
        L_0x0087:
            r8 = r12 & r7
            if (r8 != 0) goto L_0x009a
            r8 = r30
            boolean r9 = r14.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0096
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r9
            goto L_0x009c
        L_0x009a:
            r8 = r30
        L_0x009c:
            r9 = r35 & 16
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r9 == 0) goto L_0x00a9
            r16 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r16
            r15 = r31
            goto L_0x00bf
        L_0x00a9:
            r16 = r12 & r15
            if (r16 != 0) goto L_0x00bd
            r15 = r31
            boolean r16 = r14.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00b8
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ba
        L_0x00b8:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00ba:
            r1 = r1 | r16
            goto L_0x00bf
        L_0x00bd:
            r15 = r31
        L_0x00bf:
            r16 = r35 & 32
            if (r16 == 0) goto L_0x00c8
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00c5:
            r1 = r1 | r16
            goto L_0x00da
        L_0x00c8:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x00da
            boolean r16 = r14.changed((java.lang.Object) r11)
            if (r16 == 0) goto L_0x00d7
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c5
        L_0x00d7:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00c5
        L_0x00da:
            r16 = 2995921(0x2db6d1, float:4.19818E-39)
            r7 = r1 & r16
            r0 = 599184(0x92490, float:8.39636E-40)
            if (r7 != r0) goto L_0x00f9
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x00eb
            goto L_0x00f9
        L_0x00eb:
            r14.skipToGroupEnd()
            r16 = r1
            r18 = r3
            r19 = r5
            r17 = r15
            r15 = r8
            goto L_0x0199
        L_0x00f9:
            if (r2 == 0) goto L_0x0102
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r18 = r0
            goto L_0x0104
        L_0x0102:
            r18 = r3
        L_0x0104:
            r0 = 0
            r2 = 3
            r3 = 0
            if (r4 == 0) goto L_0x0124
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 15
            r24 = 0
            androidx.compose.animation.EnterTransition r4 = androidx.compose.animation.EnterExitTransitionKt.expandHorizontally$default(r19, r20, r21, r22, r23, r24)
            androidx.compose.animation.EnterTransition r7 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r3, r0, r2, r3)
            androidx.compose.animation.EnterTransition r4 = r4.plus(r7)
            r19 = r4
            goto L_0x0126
        L_0x0124:
            r19 = r5
        L_0x0126:
            if (r6 == 0) goto L_0x0141
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 15
            r25 = 0
            androidx.compose.animation.ExitTransition r4 = androidx.compose.animation.EnterExitTransitionKt.shrinkHorizontally$default(r20, r21, r22, r23, r24, r25)
            androidx.compose.animation.ExitTransition r0 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r3, r0, r2, r3)
            androidx.compose.animation.ExitTransition r0 = r4.plus(r0)
            r8 = r0
        L_0x0141:
            if (r9 == 0) goto L_0x0146
            java.lang.String r0 = "AnimatedVisibility"
            r15 = r0
        L_0x0146:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0155
            r0 = -1
            java.lang.String r2 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)"
            r3 = 836509870(0x31dc20ae, float:6.406558E-9)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r0, r2)
        L_0x0155:
            int r0 = androidx.compose.animation.core.MutableTransitionState.$stable
            int r2 = r1 >> 3
            r2 = r2 & 14
            r0 = r0 | r2
            int r2 = r1 >> 12
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r2 = 0
            androidx.compose.animation.core.Transition r9 = androidx.compose.animation.core.TransitionKt.updateTransition(r10, (java.lang.String) r15, (androidx.compose.runtime.Composer) r14, (int) r0, (int) r2)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9 r0 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9.INSTANCE
            r2 = r0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r0 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | 48
            r3 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r1
            r0 = r0 | r3
            int r3 = r1 >> 3
            r4 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r4
            r7 = r0 | r3
            r0 = r9
            r16 = r1
            r1 = r2
            r2 = r18
            r3 = r19
            r4 = r8
            r5 = r32
            r6 = r14
            AnimatedEnterExitImpl(r0, r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0196
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0196:
            r17 = r15
            r15 = r8
        L_0x0199:
            androidx.compose.runtime.ScopeUpdateScope r9 = r14.endRestartGroup()
            if (r9 != 0) goto L_0x01a0
            goto L_0x01c0
        L_0x01a0:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$10 r20 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$10
            r0 = r20
            r1 = r26
            r2 = r27
            r3 = r18
            r4 = r19
            r5 = r15
            r6 = r17
            r7 = r32
            r8 = r34
            r10 = r9
            r9 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x01c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.RowScope, androidx.compose.animation.core.MutableTransitionState, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.foundation.layout.ColumnScope r26, androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r27, androidx.compose.ui.Modifier r28, androidx.compose.animation.EnterTransition r29, androidx.compose.animation.ExitTransition r30, java.lang.String r31, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r10 = r27
            r11 = r32
            r12 = r34
            java.lang.String r0 = "<this>"
            r13 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "visibleState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -850656618(0xffffffffcd4c0296, float:-2.13920096E8)
            r1 = r33
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AnimatedVisibility)P(5,4,1,2,3)532@29500L37,533@29542L73:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r34
            r2 = r35 & 1
            if (r2 == 0) goto L_0x002f
            r1 = r1 | 48
            goto L_0x003f
        L_0x002f:
            r2 = r12 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x003f
            boolean r2 = r14.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x003c
            r2 = 32
            goto L_0x003e
        L_0x003c:
            r2 = 16
        L_0x003e:
            r1 = r1 | r2
        L_0x003f:
            r2 = r35 & 2
            if (r2 == 0) goto L_0x0048
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r28
            goto L_0x005d
        L_0x0048:
            r3 = r12 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x005b
            r3 = r28
            boolean r4 = r14.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0057
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0059
        L_0x0057:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0059:
            r1 = r1 | r4
            goto L_0x005d
        L_0x005b:
            r3 = r28
        L_0x005d:
            r4 = r35 & 4
            if (r4 == 0) goto L_0x0066
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r29
            goto L_0x007b
        L_0x0066:
            r5 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0079
            r5 = r29
            boolean r6 = r14.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0075
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r1 = r1 | r6
            goto L_0x007b
        L_0x0079:
            r5 = r29
        L_0x007b:
            r6 = r35 & 8
            r7 = 57344(0xe000, float:8.0356E-41)
            if (r6 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r8 = r30
            goto L_0x009c
        L_0x0087:
            r8 = r12 & r7
            if (r8 != 0) goto L_0x009a
            r8 = r30
            boolean r9 = r14.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0096
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r9
            goto L_0x009c
        L_0x009a:
            r8 = r30
        L_0x009c:
            r9 = r35 & 16
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r9 == 0) goto L_0x00a9
            r16 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r16
            r15 = r31
            goto L_0x00bf
        L_0x00a9:
            r16 = r12 & r15
            if (r16 != 0) goto L_0x00bd
            r15 = r31
            boolean r16 = r14.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00b8
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ba
        L_0x00b8:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00ba:
            r1 = r1 | r16
            goto L_0x00bf
        L_0x00bd:
            r15 = r31
        L_0x00bf:
            r16 = r35 & 32
            if (r16 == 0) goto L_0x00c8
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00c5:
            r1 = r1 | r16
            goto L_0x00da
        L_0x00c8:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x00da
            boolean r16 = r14.changed((java.lang.Object) r11)
            if (r16 == 0) goto L_0x00d7
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c5
        L_0x00d7:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00c5
        L_0x00da:
            r16 = 2995921(0x2db6d1, float:4.19818E-39)
            r7 = r1 & r16
            r0 = 599184(0x92490, float:8.39636E-40)
            if (r7 != r0) goto L_0x00f9
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x00eb
            goto L_0x00f9
        L_0x00eb:
            r14.skipToGroupEnd()
            r16 = r1
            r18 = r3
            r19 = r5
            r17 = r15
            r15 = r8
            goto L_0x0199
        L_0x00f9:
            if (r2 == 0) goto L_0x0102
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r18 = r0
            goto L_0x0104
        L_0x0102:
            r18 = r3
        L_0x0104:
            r0 = 0
            r2 = 3
            r3 = 0
            if (r4 == 0) goto L_0x0124
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 15
            r24 = 0
            androidx.compose.animation.EnterTransition r4 = androidx.compose.animation.EnterExitTransitionKt.expandVertically$default(r19, r20, r21, r22, r23, r24)
            androidx.compose.animation.EnterTransition r7 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r3, r0, r2, r3)
            androidx.compose.animation.EnterTransition r4 = r4.plus(r7)
            r19 = r4
            goto L_0x0126
        L_0x0124:
            r19 = r5
        L_0x0126:
            if (r6 == 0) goto L_0x0141
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 15
            r25 = 0
            androidx.compose.animation.ExitTransition r4 = androidx.compose.animation.EnterExitTransitionKt.shrinkVertically$default(r20, r21, r22, r23, r24, r25)
            androidx.compose.animation.ExitTransition r0 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r3, r0, r2, r3)
            androidx.compose.animation.ExitTransition r0 = r4.plus(r0)
            r8 = r0
        L_0x0141:
            if (r9 == 0) goto L_0x0146
            java.lang.String r0 = "AnimatedVisibility"
            r15 = r0
        L_0x0146:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0155
            r0 = -1
            java.lang.String r2 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:524)"
            r3 = -850656618(0xffffffffcd4c0296, float:-2.13920096E8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r0, r2)
        L_0x0155:
            int r0 = androidx.compose.animation.core.MutableTransitionState.$stable
            int r2 = r1 >> 3
            r2 = r2 & 14
            r0 = r0 | r2
            int r2 = r1 >> 12
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r2 = 0
            androidx.compose.animation.core.Transition r9 = androidx.compose.animation.core.TransitionKt.updateTransition(r10, (java.lang.String) r15, (androidx.compose.runtime.Composer) r14, (int) r0, (int) r2)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11 r0 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11.INSTANCE
            r2 = r0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r0 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | 48
            r3 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r1
            r0 = r0 | r3
            int r3 = r1 >> 3
            r4 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r4
            r7 = r0 | r3
            r0 = r9
            r16 = r1
            r1 = r2
            r2 = r18
            r3 = r19
            r4 = r8
            r5 = r32
            r6 = r14
            AnimatedEnterExitImpl(r0, r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0196
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0196:
            r17 = r15
            r15 = r8
        L_0x0199:
            androidx.compose.runtime.ScopeUpdateScope r9 = r14.endRestartGroup()
            if (r9 != 0) goto L_0x01a0
            goto L_0x01c0
        L_0x01a0:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$12 r20 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$12
            r0 = r20
            r1 = r26
            r2 = r27
            r3 = r18
            r4 = r19
            r5 = r15
            r6 = r17
            r7 = r32
            r8 = r34
            r10 = r9
            r9 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x01c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.ColumnScope, androidx.compose.animation.core.MutableTransitionState, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void AnimatedVisibility(androidx.compose.animation.core.Transition<T> r28, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r29, androidx.compose.ui.Modifier r30, androidx.compose.animation.EnterTransition r31, androidx.compose.animation.ExitTransition r32, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r9 = r28
            r10 = r29
            r11 = r33
            r12 = r35
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "visible"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 1031950689(0x3d825161, float:0.06363178)
            r1 = r34
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AnimatedVisibility)P(4,3,1,2)606@33860L68:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r35
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r36 & r2
            if (r2 == 0) goto L_0x0031
            r1 = r1 | 6
            goto L_0x003f
        L_0x0031:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x003f
            boolean r2 = r13.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x003d
            r2 = 4
            goto L_0x003e
        L_0x003d:
            r2 = 2
        L_0x003e:
            r1 = r1 | r2
        L_0x003f:
            r2 = r36 & 1
            if (r2 == 0) goto L_0x0046
            r1 = r1 | 48
            goto L_0x0056
        L_0x0046:
            r2 = r12 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0056
            boolean r2 = r13.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x0053
            r2 = 32
            goto L_0x0055
        L_0x0053:
            r2 = 16
        L_0x0055:
            r1 = r1 | r2
        L_0x0056:
            r2 = r36 & 2
            if (r2 == 0) goto L_0x005f
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r30
            goto L_0x0074
        L_0x005f:
            r3 = r12 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0072
            r3 = r30
            boolean r4 = r13.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x006e
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0070
        L_0x006e:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0070:
            r1 = r1 | r4
            goto L_0x0074
        L_0x0072:
            r3 = r30
        L_0x0074:
            r4 = r36 & 4
            if (r4 == 0) goto L_0x007d
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r31
            goto L_0x0092
        L_0x007d:
            r5 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0090
            r5 = r31
            boolean r6 = r13.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x008c
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x008e
        L_0x008c:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x008e:
            r1 = r1 | r6
            goto L_0x0092
        L_0x0090:
            r5 = r31
        L_0x0092:
            r6 = r36 & 8
            r7 = 57344(0xe000, float:8.0356E-41)
            if (r6 == 0) goto L_0x009e
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r8 = r32
            goto L_0x00b3
        L_0x009e:
            r8 = r12 & r7
            if (r8 != 0) goto L_0x00b1
            r8 = r32
            boolean r14 = r13.changed((java.lang.Object) r8)
            if (r14 == 0) goto L_0x00ad
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00af
        L_0x00ad:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x00af:
            r1 = r1 | r14
            goto L_0x00b3
        L_0x00b1:
            r8 = r32
        L_0x00b3:
            r14 = r36 & 16
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x00bd
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x00bb:
            r1 = r1 | r14
            goto L_0x00cd
        L_0x00bd:
            r14 = r12 & r15
            if (r14 != 0) goto L_0x00cd
            boolean r14 = r13.changed((java.lang.Object) r11)
            if (r14 == 0) goto L_0x00ca
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00ca:
            r14 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00bb
        L_0x00cd:
            r14 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r14
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r15) goto L_0x00e8
            boolean r1 = r13.getSkipping()
            if (r1 != 0) goto L_0x00de
            goto L_0x00e8
        L_0x00de:
            r13.skipToGroupEnd()
            r15 = r3
            r16 = r5
            r17 = r8
            goto L_0x0168
        L_0x00e8:
            if (r2 == 0) goto L_0x00f0
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r15 = r1
            goto L_0x00f1
        L_0x00f0:
            r15 = r3
        L_0x00f1:
            r1 = 3
            r2 = 0
            r3 = 0
            if (r4 == 0) goto L_0x0111
            androidx.compose.animation.EnterTransition r4 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r3, r2, r1, r3)
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 15
            r21 = 0
            androidx.compose.animation.EnterTransition r7 = androidx.compose.animation.EnterExitTransitionKt.expandIn$default(r16, r17, r18, r19, r20, r21)
            androidx.compose.animation.EnterTransition r4 = r4.plus(r7)
            r16 = r4
            goto L_0x0113
        L_0x0111:
            r16 = r5
        L_0x0113:
            if (r6 == 0) goto L_0x012e
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 15
            r27 = 0
            androidx.compose.animation.ExitTransition r4 = androidx.compose.animation.EnterExitTransitionKt.shrinkOut$default(r22, r23, r24, r25, r26, r27)
            androidx.compose.animation.ExitTransition r1 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r3, r2, r1, r3)
            androidx.compose.animation.ExitTransition r1 = r4.plus(r1)
            r8 = r1
        L_0x012e:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x013a
            r1 = -1
            java.lang.String r2 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:600)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r1, r2)
        L_0x013a:
            r0 = r14 & 14
            r1 = r14 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r14 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r14 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r14
            r0 = r0 | r1
            r1 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r14
            r7 = r0 | r1
            r0 = r28
            r1 = r29
            r2 = r15
            r3 = r16
            r4 = r8
            r5 = r33
            r6 = r13
            AnimatedEnterExitImpl(r0, r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0166
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0166:
            r17 = r8
        L_0x0168:
            androidx.compose.runtime.ScopeUpdateScope r8 = r13.endRestartGroup()
            if (r8 != 0) goto L_0x016f
            goto L_0x018d
        L_0x016f:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$13 r18 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$13
            r0 = r18
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r33
            r7 = r35
            r9 = r8
            r8 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x018d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.animation.core.Transition, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    @Deprecated(message = "AnimatedVisibility no longer accepts initiallyVisible as a parameter, please use AnimatedVisibility(MutableTransitionState, Modifier, ...) API instead", replaceWith = @ReplaceWith(expression = "AnimatedVisibility(transitionState = remember { MutableTransitionState(initiallyVisible) }\n.apply { targetState = visible },\nmodifier = modifier,\nenter = enter,\nexit = exit) {\ncontent() \n}", imports = {"androidx.compose.animation.core.MutableTransitionState"}))
    public static final void AnimatedVisibility(boolean visible, Modifier modifier, EnterTransition enter, ExitTransition exit, boolean initiallyVisible, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Modifier modifier3;
        Object value$iv$iv;
        EnterTransition enterTransition = enter;
        ExitTransition exitTransition = exit;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(enterTransition, "enter");
        Intrinsics.checkNotNullParameter(exitTransition, "exit");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(1121582420);
        ComposerKt.sourceInformation($composer2, "C(AnimatedVisibility)P(5,4,1,2,3)*709@38686L53,708@38647L214:AnimatedVisibility.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            boolean z = visible;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed(visible) ? 4 : 2;
        } else {
            boolean z2 = visible;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if ((i2 & 896) == 0) {
            $dirty |= $composer2.changed((Object) enterTransition) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if ((i2 & 7168) == 0) {
            $dirty |= $composer2.changed((Object) exitTransition) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
            boolean z3 = initiallyVisible;
        } else if ((57344 & i2) == 0) {
            $dirty |= $composer2.changed(initiallyVisible) ? 16384 : 8192;
        } else {
            boolean z4 = initiallyVisible;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((458752 & i2) == 0) {
            $dirty |= $composer2.changed((Object) function2) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((374491 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1121582420, $dirty2, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:701)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = new MutableTransitionState(Boolean.valueOf(initiallyVisible));
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            ((MutableTransitionState) value$iv$iv).setTargetState(Boolean.valueOf(visible));
            int i4 = $dirty2;
            AnimatedVisibility((MutableTransitionState<Boolean>) (MutableTransitionState) value$iv$iv, modifier3, enter, exit, (String) null, (Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, 1996320812, true, new AnimatedVisibilityKt$AnimatedVisibility$16(function2, $dirty2)), $composer2, MutableTransitionState.$stable | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            int i5 = $dirty2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AnimatedVisibilityKt$AnimatedVisibility$17(visible, modifier3, enter, exit, initiallyVisible, content, $changed, i));
        }
    }

    /* access modifiers changed from: private */
    public static final <T> void AnimatedEnterExitImpl(Transition<T> transition, Function1<? super T, Boolean> visible, Modifier modifier, EnterTransition enter, ExitTransition exit, Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv$iv;
        String str;
        Object value$iv$iv2;
        Object value$iv$iv$iv2;
        Object value$iv$iv$iv3;
        Transition<T> transition2 = transition;
        Function1<? super T, Boolean> function1 = visible;
        Modifier modifier2 = modifier;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3 = content;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(808253933);
        ComposerKt.sourceInformation($composer2, "C(AnimatedEnterExitImpl)P(4,5,3,1,2)734@39380L85,739@39603L116,743@39761L270,743@39729L302,752@40041L165:AnimatedVisibility.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed((Object) transition2) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changed((Object) function1) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changed((Object) modifier2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer2.changed((Object) enter) ? 2048 : 1024;
        } else {
            EnterTransition enterTransition = enter;
        }
        if ((i & 57344) == 0) {
            $dirty |= $composer2.changed((Object) exit) ? 16384 : 8192;
        } else {
            ExitTransition exitTransition = exit;
        }
        if ((458752 & i) == 0) {
            $dirty |= $composer2.changed((Object) function3) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((374491 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(808253933, $dirty2, -1, "androidx.compose.animation.AnimatedEnterExitImpl (AnimatedVisibility.kt:726)");
            }
            int $changed$iv = $dirty2 & 14;
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed((Object) transition2);
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                int i2 = $changed$iv;
                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(function1.invoke(transition.getCurrentState()), (SnapshotMutationPolicy) null, 2, (Object) null);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                Composer composer = $this$cache$iv$iv;
                int i3 = $changed$iv;
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            MutableState isAnimationVisible = (MutableState) value$iv$iv;
            if (function1.invoke(transition.getTargetState()).booleanValue() || ((Boolean) isAnimationVisible.getValue()).booleanValue() || transition.isSeeking()) {
                int $changed$iv2 = ($dirty2 & 14) | 48;
                Transition<T> transition3 = transition;
                $composer2.startReplaceableGroup(1215497572);
                ComposerKt.sourceInformation($composer2, "CC(createChildTransition)785@31111L36,786@31171L74,787@31268L39,788@31319L63:Transition.kt#pdpnli");
                int $changed$iv$iv = $changed$iv2 & 14;
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv$iv = $composer2.changed((Object) transition3);
                Composer $this$cache$iv$iv$iv = $composer2;
                Object rememberedValue = $this$cache$iv$iv$iv.rememberedValue();
                if (invalid$iv$iv$iv || rememberedValue == Composer.Companion.getEmpty()) {
                    value$iv$iv$iv = transition3.getCurrentState();
                    int i4 = $changed$iv$iv;
                    $this$cache$iv$iv$iv.updateRememberedValue(value$iv$iv$iv);
                } else {
                    int i5 = $changed$iv$iv;
                    value$iv$iv$iv = rememberedValue;
                    Composer composer2 = $this$cache$iv$iv$iv;
                }
                $composer2.endReplaceableGroup();
                Object it = transition3.isSeeking() ? transition3.getCurrentState() : value$iv$iv$iv;
                int $changed2 = ($changed$iv2 >> 3) & 112;
                Composer $composer3 = $composer2;
                Object obj = value$iv$iv$iv;
                $composer3.startReplaceableGroup(-1220581778);
                ComposerKt.sourceInformation($composer3, "C740@39681L28:AnimatedVisibility.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    str = "C(remember)P(1):Composables.kt#9igjgp";
                    ComposerKt.traceEventStart(-1220581778, $changed2, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:739)");
                } else {
                    str = "C(remember)P(1):Composables.kt#9igjgp";
                }
                Object initialState$iv = targetEnterExit(transition2, function1, it, $composer3, ($dirty2 & 14) | ($dirty2 & 112) | (($changed2 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer3.endReplaceableGroup();
                String str2 = str;
                Object it2 = transition3.getTargetState();
                int $changed3 = ($changed$iv2 >> 3) & 112;
                Composer $composer4 = $composer2;
                $composer4.startReplaceableGroup(-1220581778);
                ComposerKt.sourceInformation($composer4, "C740@39681L28:AnimatedVisibility.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1220581778, $changed3, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:739)");
                }
                Object targetState$iv = targetEnterExit(transition2, function1, it2, $composer4, ($dirty2 & 14) | ($dirty2 & 112) | (($changed3 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer4.endReplaceableGroup();
                Transition<T> transition4 = transition3;
                int $dirty3 = $dirty2;
                Transition<T> createChildTransitionInternal = TransitionKt.createChildTransitionInternal(transition3, initialState$iv, targetState$iv, "EnterExitTransition", $composer2, ($changed$iv2 & 14) | (($changed$iv2 << 6) & 7168));
                $composer2.endReplaceableGroup();
                Transition<T> transition5 = createChildTransitionInternal;
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv2 = $composer2.changed((Object) transition5) | $composer2.changed((Object) isAnimationVisible);
                Composer $this$cache$iv$iv2 = $composer2;
                Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
                if (invalid$iv$iv2 || it$iv$iv2 == Composer.Companion.getEmpty()) {
                    value$iv$iv2 = (Function2) new AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1(transition5, isAnimationVisible, (Continuation<? super AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1>) null);
                    $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
                } else {
                    value$iv$iv2 = it$iv$iv2;
                }
                $composer2.endReplaceableGroup();
                EffectsKt.LaunchedEffect((Object) transition5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) value$iv$iv2, $composer2, 64);
                int $changed$iv3 = (($dirty3 >> 3) & 112) | (($dirty3 >> 3) & 896) | (($dirty3 >> 3) & 7168) | (($dirty3 >> 3) & 57344);
                $composer2.startReplaceableGroup(-1967270694);
                ComposerKt.sourceInformation($composer2, "CC(AnimatedEnterExitImpl)P(4,3,1,2)777@40847L64,780@41019L39,781@41089L50,778@40920L229:AnimatedVisibility.kt#xbi5r1");
                if (transition5.getCurrentState() == EnterExitState.Visible || transition5.getTargetState() == EnterExitState.Visible) {
                    int i6 = $changed$iv3 & 14;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, str2);
                    boolean invalid$iv$iv$iv2 = $composer2.changed((Object) transition5);
                    Composer $this$cache$iv$iv$iv2 = $composer2;
                    Object it$iv$iv$iv = $this$cache$iv$iv$iv2.rememberedValue();
                    if (invalid$iv$iv$iv2 || it$iv$iv$iv == Composer.Companion.getEmpty()) {
                        MutableState mutableState = isAnimationVisible;
                        value$iv$iv$iv2 = new AnimatedVisibilityScopeImpl(transition5);
                        $this$cache$iv$iv$iv2.updateRememberedValue(value$iv$iv$iv2);
                    } else {
                        MutableState mutableState2 = isAnimationVisible;
                        value$iv$iv$iv2 = it$iv$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    AnimatedVisibilityScopeImpl scope$iv = (AnimatedVisibilityScopeImpl) value$iv$iv$iv2;
                    Composer $this$cache$iv$iv$iv3 = $composer2;
                    Modifier modifier$iv$iv = modifier2.then(EnterExitTransitionKt.createModifier(transition5, enter, exit, "Built-in", $this$cache$iv$iv$iv3, ($changed$iv3 & 14) | 3072 | (($changed$iv3 >> 3) & 112) | (($changed$iv3 >> 3) & 896)));
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                    Object it$iv$iv$iv2 = $this$cache$iv$iv$iv3.rememberedValue();
                    if (it$iv$iv$iv2 == Composer.Companion.getEmpty()) {
                        value$iv$iv$iv3 = new AnimatedEnterExitMeasurePolicy(scope$iv);
                        $this$cache$iv$iv$iv3.updateRememberedValue(value$iv$iv$iv3);
                    } else {
                        value$iv$iv$iv3 = it$iv$iv$iv2;
                    }
                    $composer2.endReplaceableGroup();
                    MeasurePolicy measurePolicy$iv$iv = (MeasurePolicy) value$iv$iv$iv3;
                    $composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Density density$iv$iv = (Density) consume;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                    Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv$iv);
                    Modifier modifier3 = modifier$iv$iv;
                    int $changed$iv$iv$iv = ((384 << 9) & 7168) | 6;
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
                    Transition<T> transition6 = transition5;
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
                    $composer2.enableReusing();
                    skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                    $composer2.startReplaceableGroup(2058660585);
                    int i7 = ($changed$iv$iv$iv >> 9) & 14;
                    Composer $composer$iv = $composer2;
                    int i8 = $changed$iv$iv$iv;
                    MeasurePolicy measurePolicy = measurePolicy$iv$iv;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -174037743, "C779@40958L9:AnimatedVisibility.kt#xbi5r1");
                    content.invoke(scope$iv, $composer$iv, Integer.valueOf((($changed$iv3 >> 9) & 112) | 8));
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer2.endReplaceableGroup();
                    $composer2.endNode();
                    $composer2.endReplaceableGroup();
                } else {
                    Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32 = content;
                    MutableState mutableState3 = isAnimationVisible;
                    Transition<T> transition7 = transition5;
                }
                $composer2.endReplaceableGroup();
            } else {
                MutableState mutableState4 = isAnimationVisible;
                int i9 = $dirty2;
                Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function33 = function3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            int i10 = $dirty2;
            Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function34 = function3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AnimatedVisibilityKt$AnimatedEnterExitImpl$2(transition, visible, modifier, enter, exit, content, $changed));
        }
    }

    private static final void AnimatedEnterExitImpl(Transition<EnterExitState> transition, Modifier modifier, EnterTransition enter, ExitTransition exit, Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Transition<EnterExitState> transition2 = transition;
        Composer composer = $composer;
        composer.startReplaceableGroup(-1967270694);
        ComposerKt.sourceInformation(composer, "CC(AnimatedEnterExitImpl)P(4,3,1,2)777@40847L64,780@41019L39,781@41089L50,778@40920L229:AnimatedVisibility.kt#xbi5r1");
        if (transition.getCurrentState() == EnterExitState.Visible || transition.getTargetState() == EnterExitState.Visible) {
            int i = $changed & 14;
            composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = composer.changed((Object) transition2);
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = new AnimatedVisibilityScopeImpl(transition2);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            AnimatedVisibilityScopeImpl scope = (AnimatedVisibilityScopeImpl) value$iv$iv;
            Modifier modifier$iv = modifier.then(EnterExitTransitionKt.createModifier(transition, enter, exit, "Built-in", $composer, ($changed & 14) | 3072 | (($changed >> 3) & 112) | (($changed >> 3) & 896)));
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv2 = $composer;
            Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
            if (it$iv$iv2 == Composer.Companion.getEmpty()) {
                value$iv$iv2 = new AnimatedEnterExitMeasurePolicy(scope);
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer.endReplaceableGroup();
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) value$iv$iv2;
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            Function0 factory$iv$iv = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv = ((384 << 9) & 7168) | 6;
            Modifier modifier2 = modifier$iv;
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                composer.createNode(factory$iv$iv);
            } else {
                $composer.useNode();
            }
            $composer.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv = Updater.m2787constructorimpl($composer);
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer.enableReusing();
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            Composer $composer2 = $composer;
            int i2 = ($changed$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -174037743, "C779@40958L9:AnimatedVisibility.kt#xbi5r1");
            content.invoke(scope, $composer2, Integer.valueOf((($changed >> 9) & 112) | 8));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer.endReplaceableGroup();
            $composer.endNode();
            $composer.endReplaceableGroup();
        } else {
            Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3 = content;
        }
        $composer.endReplaceableGroup();
    }

    private static final <T> EnterExitState targetEnterExit(Transition<T> $this$targetEnterExit, Function1<? super T, Boolean> visible, T targetState, Composer $composer, int $changed) {
        EnterExitState enterExitState;
        Object value$iv$iv;
        $composer.startReplaceableGroup(361571134);
        ComposerKt.sourceInformation($composer, "C(targetEnterExit)P(1):AnimatedVisibility.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(361571134, $changed, -1, "androidx.compose.animation.targetEnterExit (AnimatedVisibility.kt:830)");
        }
        $composer.startMovableGroup(-721837504, $this$targetEnterExit);
        ComposerKt.sourceInformation($composer, "846@43297L34");
        if (!$this$targetEnterExit.isSeeking()) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            MutableState hasBeenVisible = (MutableState) value$iv$iv;
            if (visible.invoke($this$targetEnterExit.getCurrentState()).booleanValue()) {
                hasBeenVisible.setValue(true);
            }
            if (visible.invoke(targetState).booleanValue()) {
                enterExitState = EnterExitState.Visible;
            } else if (((Boolean) hasBeenVisible.getValue()).booleanValue()) {
                enterExitState = EnterExitState.PostExit;
            } else {
                enterExitState = EnterExitState.PreEnter;
            }
        } else if (visible.invoke(targetState).booleanValue()) {
            enterExitState = EnterExitState.Visible;
        } else if (visible.invoke($this$targetEnterExit.getCurrentState()).booleanValue()) {
            enterExitState = EnterExitState.PostExit;
        } else {
            enterExitState = EnterExitState.PreEnter;
        }
        $composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return enterExitState;
    }
}
