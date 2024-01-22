package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\r2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0014\u001a\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002\u001a-\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00172\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\rH\u0007¢\u0006\u0002\u0010\u001d\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"DISMISS_THRESHOLD", "Landroidx/compose/ui/unit/Dp;", "F", "SwipeToDismiss", "", "state", "Landroidx/compose/material/DismissState;", "modifier", "Landroidx/compose/ui/Modifier;", "directions", "", "Landroidx/compose/material/DismissDirection;", "dismissThresholds", "Lkotlin/Function1;", "Landroidx/compose/material/ThresholdConfig;", "background", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "dismissContent", "(Landroidx/compose/material/DismissState;Landroidx/compose/ui/Modifier;Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "getDismissDirection", "from", "Landroidx/compose/material/DismissValue;", "to", "rememberDismissState", "initialValue", "confirmStateChange", "", "(Landroidx/compose/material/DismissValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DismissState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismiss.kt */
public final class SwipeToDismissKt {
    /* access modifiers changed from: private */
    public static final float DISMISS_THRESHOLD = Dp.m5986constructorimpl((float) 56);

    public static final DismissState rememberDismissState(DismissValue initialValue, Function1<? super DismissValue, Boolean> confirmStateChange, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(-1753522702);
        ComposerKt.sourceInformation($composer, "C(rememberDismissState)P(1)152@5427L62,152@5362L127:SwipeToDismiss.kt#jmzs0o");
        if ((i & 1) != 0) {
            initialValue = DismissValue.Default;
        }
        Function1<? super DismissValue, Boolean> confirmStateChange2 = confirmStateChange;
        if ((i & 2) != 0) {
            confirmStateChange2 = SwipeToDismissKt$rememberDismissState$1.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1753522702, $changed, -1, "androidx.compose.material.rememberDismissState (SwipeToDismiss.kt:148)");
        }
        Object[] objArr = new Object[0];
        Saver<DismissState, DismissValue> Saver = DismissState.Companion.Saver(confirmStateChange2);
        int i2 = ($changed & 14) | ($changed & 112);
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) initialValue) | $composer.changed((Object) confirmStateChange2);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function0) new SwipeToDismissKt$rememberDismissState$2$1(initialValue, confirmStateChange2);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        DismissState dismissState = (DismissState) RememberSaveableKt.rememberSaveable(objArr, Saver, (String) null, (Function0) value$iv$iv, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return dismissState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SwipeToDismiss(androidx.compose.material.DismissState r19, androidx.compose.ui.Modifier r20, java.util.Set<? extends androidx.compose.material.DismissDirection> r21, kotlin.jvm.functions.Function1<? super androidx.compose.material.DismissDirection, ? extends androidx.compose.material.ThresholdConfig> r22, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r9 = r19
            r10 = r23
            r11 = r24
            r12 = r26
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "background"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "dismissContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 634380143(0x25cfdf6f, float:3.606018E-16)
            r1 = r25
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SwipeToDismiss)P(5,4,1,3)181@6582L1407:SwipeToDismiss.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r26
            r2 = r27 & 1
            r3 = 4
            r4 = 2
            if (r2 == 0) goto L_0x0031
            r1 = r1 | 6
            goto L_0x003f
        L_0x0031:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x003f
            boolean r2 = r13.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x003d
            r2 = r3
            goto L_0x003e
        L_0x003d:
            r2 = r4
        L_0x003e:
            r1 = r1 | r2
        L_0x003f:
            r2 = r27 & 2
            if (r2 == 0) goto L_0x0048
            r1 = r1 | 48
            r5 = r20
            goto L_0x005d
        L_0x0048:
            r5 = r12 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x005b
            r5 = r20
            boolean r6 = r13.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0057
            r6 = 32
            goto L_0x0059
        L_0x0057:
            r6 = 16
        L_0x0059:
            r1 = r1 | r6
            goto L_0x005d
        L_0x005b:
            r5 = r20
        L_0x005d:
            r6 = r27 & 4
            if (r6 == 0) goto L_0x0063
            r1 = r1 | 128(0x80, float:1.794E-43)
        L_0x0063:
            r7 = r27 & 8
            if (r7 == 0) goto L_0x006c
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r8 = r22
            goto L_0x0081
        L_0x006c:
            r8 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x007f
            r8 = r22
            boolean r14 = r13.changedInstance(r8)
            if (r14 == 0) goto L_0x007b
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r1 = r1 | r14
            goto L_0x0081
        L_0x007f:
            r8 = r22
        L_0x0081:
            r14 = r27 & 16
            if (r14 == 0) goto L_0x0088
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0088:
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r12
            if (r14 != 0) goto L_0x009a
            boolean r14 = r13.changedInstance(r10)
            if (r14 == 0) goto L_0x0097
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r1 = r1 | r14
        L_0x009a:
            r14 = r27 & 32
            if (r14 == 0) goto L_0x00a2
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x00a0:
            r1 = r1 | r14
            goto L_0x00b3
        L_0x00a2:
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r12
            if (r14 != 0) goto L_0x00b3
            boolean r14 = r13.changedInstance(r11)
            if (r14 == 0) goto L_0x00b0
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a0
        L_0x00b0:
            r14 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00a0
        L_0x00b3:
            r14 = r1
            if (r6 != r3) goto L_0x00d0
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r14
            r3 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r3) goto L_0x00d0
            boolean r1 = r13.getSkipping()
            if (r1 != 0) goto L_0x00c6
            goto L_0x00d0
        L_0x00c6:
            r13.skipToGroupEnd()
            r16 = r21
            r15 = r5
            r17 = r8
            goto L_0x013e
        L_0x00d0:
            if (r2 == 0) goto L_0x00d8
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r15 = r1
            goto L_0x00d9
        L_0x00d8:
            r15 = r5
        L_0x00d9:
            r5 = 1
            if (r6 == 0) goto L_0x00ee
            androidx.compose.material.DismissDirection[] r1 = new androidx.compose.material.DismissDirection[r4]
            r2 = 0
            androidx.compose.material.DismissDirection r3 = androidx.compose.material.DismissDirection.EndToStart
            r1[r2] = r3
            androidx.compose.material.DismissDirection r2 = androidx.compose.material.DismissDirection.StartToEnd
            r1[r5] = r2
            java.util.Set r1 = kotlin.collections.SetsKt.setOf(r1)
            r16 = r1
            goto L_0x00f0
        L_0x00ee:
            r16 = r21
        L_0x00f0:
            if (r7 == 0) goto L_0x00f7
            androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$1 r1 = androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$1.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r8 = r1
        L_0x00f7:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0103
            r1 = -1
            java.lang.String r2 = "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:172)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r1, r2)
        L_0x0103:
            r17 = 0
            androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2 r6 = new androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2
            r0 = r6
            r1 = r16
            r2 = r8
            r3 = r14
            r4 = r19
            r7 = r5
            r5 = r23
            r21 = r8
            r8 = r6
            r6 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = 338007641(0x14259659, float:8.360022E-27)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r0, r7, r8)
            r4 = r0
            kotlin.jvm.functions.Function3 r4 = (kotlin.jvm.functions.Function3) r4
            int r0 = r14 >> 3
            r0 = r0 & 14
            r6 = r0 | 3072(0xc00, float:4.305E-42)
            r7 = 6
            r1 = r15
            r0 = 0
            r2 = r0
            r3 = r17
            r5 = r13
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x013c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x013c:
            r17 = r21
        L_0x013e:
            androidx.compose.runtime.ScopeUpdateScope r8 = r13.endRestartGroup()
            if (r8 != 0) goto L_0x0145
            goto L_0x0163
        L_0x0145:
            androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$3 r18 = new androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$3
            r0 = r18
            r1 = r19
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r23
            r6 = r24
            r7 = r26
            r9 = r8
            r8 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0163:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeToDismissKt.SwipeToDismiss(androidx.compose.material.DismissState, androidx.compose.ui.Modifier, java.util.Set, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final DismissDirection getDismissDirection(DismissValue from, DismissValue to) {
        if (from == to && from == DismissValue.Default) {
            return null;
        }
        if (from == to && from == DismissValue.DismissedToEnd) {
            return DismissDirection.StartToEnd;
        }
        if (from == to && from == DismissValue.DismissedToStart) {
            return DismissDirection.EndToStart;
        }
        if (from == DismissValue.Default && to == DismissValue.DismissedToEnd) {
            return DismissDirection.StartToEnd;
        }
        if (from == DismissValue.Default && to == DismissValue.DismissedToStart) {
            return DismissDirection.EndToStart;
        }
        if (from == DismissValue.DismissedToEnd && to == DismissValue.Default) {
            return DismissDirection.StartToEnd;
        }
        if (from == DismissValue.DismissedToStart && to == DismissValue.Default) {
            return DismissDirection.EndToStart;
        }
        return null;
    }
}
