package androidx.compose.foundation.layout;

import android.os.Build;
import android.view.ViewConfiguration;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0015H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"DecelMinusOne", "", "DecelerationRate", "EndTension", "", "GravityEarth", "InchesPerMeter", "Inflection", "P1", "P2", "PlatformFlingScrollFriction", "StartTension", "rememberWindowInsetsConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "windowInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "side", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "rememberWindowInsetsConnection-VRgvIgI", "(Landroidx/compose/foundation/layout/AndroidWindowInsets;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "imeNestedScroll", "Landroidx/compose/ui/Modifier;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsetsConnection.android.kt */
public final class WindowInsetsConnection_androidKt {
    /* access modifiers changed from: private */
    public static final double DecelMinusOne;
    /* access modifiers changed from: private */
    public static final double DecelerationRate;
    private static final float EndTension = 1.0f;
    private static final float GravityEarth = 9.80665f;
    private static final float InchesPerMeter = 39.37f;
    private static final float Inflection = 0.35f;
    private static final float P1 = 0.175f;
    private static final float P2 = 0.35000002f;
    /* access modifiers changed from: private */
    public static final float PlatformFlingScrollFriction = ViewConfiguration.getScrollFriction();
    private static final float StartTension = 0.5f;

    public static final Modifier imeNestedScroll(Modifier $this$imeNestedScroll) {
        Intrinsics.checkNotNullParameter($this$imeNestedScroll, "<this>");
        if (Build.VERSION.SDK_INT < 30) {
            return $this$imeNestedScroll;
        }
        return ComposedModifierKt.composed($this$imeNestedScroll, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsConnection_androidKt$imeNestedScroll$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), WindowInsetsConnection_androidKt$imeNestedScroll$2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e8  */
    /* renamed from: rememberWindowInsetsConnection-VRgvIgI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.input.nestedscroll.NestedScrollConnection m847rememberWindowInsetsConnectionVRgvIgI(androidx.compose.foundation.layout.AndroidWindowInsets r18, int r19, androidx.compose.runtime.Composer r20, int r21) {
        /*
            r0 = r18
            r1 = r20
            java.lang.String r2 = "windowInsets"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r2 = -1011341039(0xffffffffc3b82911, float:-368.32083)
            r1.startReplaceableGroup(r2)
            java.lang.String r3 = "C(rememberWindowInsetsConnection)P(1,0:c#foundation.layout.WindowInsetsSides)111@4499L7,113@4612L7,114@4651L7,115@4680L149,118@4834L99:WindowInsetsConnection.android.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0024
            r3 = -1
            java.lang.String r4 = "androidx.compose.foundation.layout.rememberWindowInsetsConnection (WindowInsetsConnection.android.kt:104)"
            r5 = r21
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r5, r3, r4)
            goto L_0x0026
        L_0x0024:
            r5 = r21
        L_0x0026:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 30
            if (r2 >= r3) goto L_0x003d
            androidx.compose.foundation.layout.DoNothingNestedScrollConnection r2 = androidx.compose.foundation.layout.DoNothingNestedScrollConnection.INSTANCE
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0037
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0037:
            r20.endReplaceableGroup()
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r2 = (androidx.compose.ui.input.nestedscroll.NestedScrollConnection) r2
            return r2
        L_0x003d:
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 0
            r4 = 0
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r6, r7)
            java.lang.Object r8 = r1.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r20)
            r2 = r8
            androidx.compose.ui.unit.LayoutDirection r2 = (androidx.compose.ui.unit.LayoutDirection) r2
            androidx.compose.foundation.layout.SideCalculator$Companion r3 = androidx.compose.foundation.layout.SideCalculator.Companion
            r4 = r19
            androidx.compose.foundation.layout.SideCalculator r3 = r3.m805chooseCalculatorni1skBw(r4, r2)
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r9 = 0
            r10 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r6, r7)
            java.lang.Object r11 = r1.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r20)
            r8 = r11
            android.view.View r8 = (android.view.View) r8
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r10 = 0
            r11 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r6, r7)
            java.lang.Object r6 = r1.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r20)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            java.lang.Object[] r7 = new java.lang.Object[]{r0, r8, r3, r6}
            r9 = 8
            r10 = 0
            r11 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r1.startReplaceableGroup(r11)
            java.lang.String r11 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            r11 = 0
            int r12 = r7.length
            r13 = 0
        L_0x009d:
            if (r13 >= r12) goto L_0x00a9
            r14 = r7[r13]
            boolean r15 = r1.changed((java.lang.Object) r14)
            r11 = r11 | r15
            int r13 = r13 + 1
            goto L_0x009d
        L_0x00a9:
            r12 = r20
            r13 = 0
            java.lang.Object r14 = r12.rememberedValue()
            r15 = 0
            if (r11 != 0) goto L_0x00c0
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r17 = r2
            java.lang.Object r2 = r16.getEmpty()
            if (r14 != r2) goto L_0x00be
            goto L_0x00c2
        L_0x00be:
            r2 = r14
            goto L_0x00cf
        L_0x00c0:
            r17 = r2
        L_0x00c2:
            r2 = 0
            r16 = r2
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r2 = new androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection
            r2.<init>(r0, r8, r3, r6)
            r12.updateRememberedValue(r2)
        L_0x00cf:
            r20.endReplaceableGroup()
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r2 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection) r2
            androidx.compose.foundation.layout.WindowInsetsConnection_androidKt$rememberWindowInsetsConnection$1 r7 = new androidx.compose.foundation.layout.WindowInsetsConnection_androidKt$rememberWindowInsetsConnection$1
            r7.<init>(r2)
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r9 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r2, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r7, (androidx.compose.runtime.Composer) r1, (int) r9)
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x00eb
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00eb:
            r20.endReplaceableGroup()
            r7 = r2
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r7 = (androidx.compose.ui.input.nestedscroll.NestedScrollConnection) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.WindowInsetsConnection_androidKt.m847rememberWindowInsetsConnectionVRgvIgI(androidx.compose.foundation.layout.AndroidWindowInsets, int, androidx.compose.runtime.Composer, int):androidx.compose.ui.input.nestedscroll.NestedScrollConnection");
    }

    static {
        double log = Math.log(0.78d) / Math.log(0.9d);
        DecelerationRate = log;
        DecelMinusOne = log - 1.0d;
    }
}
