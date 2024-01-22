package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aX\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001aD\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001a(\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0018\u001a+\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0013\b\b\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\b¢\u0006\u0002\u0010\u001c\u001a\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u001a\f\u0010\"\u001a\u00020\u001e*\u00020 H\u0000\u001a\f\u0010#\u001a\u00020$*\u00020%H\u0002\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006&"}, d2 = {"LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Popup", "", "alignment", "Landroidx/compose/ui/Alignment;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Landroidx/compose/runtime/Composable;", "Popup-K5zGePQ", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PopupTestTag", "tag", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isPopupLayout", "", "view", "Landroid/view/View;", "testTag", "isFlagSecureEnabled", "toIntBounds", "Landroidx/compose/ui/unit/IntRect;", "Landroid/graphics/Rect;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
public final class AndroidPopup_androidKt {
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, AndroidPopup_androidKt$LocalPopupTestTag$1.INSTANCE, 1, (Object) null);

    /* JADX WARNING: Removed duplicated region for block: B:80:0x017c  */
    /* renamed from: Popup-K5zGePQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m6230PopupK5zGePQ(androidx.compose.ui.Alignment r25, long r26, kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.window.PopupProperties r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r9 = r30
            r10 = r32
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 295309329(0x119a1011, float:2.4306818E-28)
            r1 = r31
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Popup)P(!1,2:c#ui.unit.IntOffset,3,4)193@8637L128,200@8771L165:AndroidPopup.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r32
            r2 = r33 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            r3 = r25
            goto L_0x0035
        L_0x0022:
            r3 = r10 & 14
            if (r3 != 0) goto L_0x0033
            r3 = r25
            boolean r4 = r11.changed((java.lang.Object) r3)
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
            r4 = r33 & 2
            if (r4 == 0) goto L_0x003e
            r1 = r1 | 48
            r5 = r26
            goto L_0x0053
        L_0x003e:
            r5 = r10 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0051
            r5 = r26
            boolean r7 = r11.changed((long) r5)
            if (r7 == 0) goto L_0x004d
            r7 = 32
            goto L_0x004f
        L_0x004d:
            r7 = 16
        L_0x004f:
            r1 = r1 | r7
            goto L_0x0053
        L_0x0051:
            r5 = r26
        L_0x0053:
            r7 = r33 & 4
            if (r7 == 0) goto L_0x005c
            r1 = r1 | 384(0x180, float:5.38E-43)
            r8 = r28
            goto L_0x0071
        L_0x005c:
            r8 = r10 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x006f
            r8 = r28
            boolean r12 = r11.changedInstance(r8)
            if (r12 == 0) goto L_0x006b
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x006d
        L_0x006b:
            r12 = 128(0x80, float:1.794E-43)
        L_0x006d:
            r1 = r1 | r12
            goto L_0x0071
        L_0x006f:
            r8 = r28
        L_0x0071:
            r12 = r33 & 8
            if (r12 == 0) goto L_0x007a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r13 = r29
            goto L_0x008f
        L_0x007a:
            r13 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r13 != 0) goto L_0x008d
            r13 = r29
            boolean r14 = r11.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x0089
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x008b
        L_0x0089:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x008b:
            r1 = r1 | r14
            goto L_0x008f
        L_0x008d:
            r13 = r29
        L_0x008f:
            r14 = r33 & 16
            if (r14 == 0) goto L_0x0096
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a8
        L_0x0096:
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00a8
            boolean r14 = r11.changedInstance(r9)
            if (r14 == 0) goto L_0x00a5
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a7
        L_0x00a5:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x00a7:
            r1 = r1 | r14
        L_0x00a8:
            r14 = r1
            r1 = 46811(0xb6db, float:6.5596E-41)
            r1 = r1 & r14
            r15 = 9362(0x2492, float:1.3119E-41)
            if (r1 != r15) goto L_0x00c1
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L_0x00b8
            goto L_0x00c1
        L_0x00b8:
            r11.skipToGroupEnd()
            r15 = r3
            r17 = r5
            r12 = r8
            goto L_0x0180
        L_0x00c1:
            if (r2 == 0) goto L_0x00cb
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getTopStart()
            r15 = r1
            goto L_0x00cc
        L_0x00cb:
            r15 = r3
        L_0x00cc:
            if (r4 == 0) goto L_0x00d4
            r1 = 0
            long r1 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r1, r1)
            r5 = r1
        L_0x00d4:
            if (r7 == 0) goto L_0x00d8
            r1 = 0
            r8 = r1
        L_0x00d8:
            if (r12 == 0) goto L_0x00f2
            androidx.compose.ui.window.PopupProperties r1 = new androidx.compose.ui.window.PopupProperties
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 63
            r24 = 0
            r16 = r1
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)
            r13 = r1
        L_0x00f2:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00fe
            r1 = -1
            java.lang.String r2 = "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:186)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r1, r2)
        L_0x00fe:
            androidx.compose.ui.unit.IntOffset r0 = androidx.compose.ui.unit.IntOffset.m6095boximpl(r5)
            r1 = r14 & 14
            r2 = r14 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = 0
            r3 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
            boolean r3 = r11.changed((java.lang.Object) r15)
            boolean r4 = r11.changed((java.lang.Object) r0)
            r3 = r3 | r4
            r4 = r11
            r7 = 0
            java.lang.Object r12 = r4.rememberedValue()
            r16 = 0
            if (r3 != 0) goto L_0x0137
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r25 = r0
            java.lang.Object r0 = r17.getEmpty()
            if (r12 != r0) goto L_0x0133
            goto L_0x0139
        L_0x0133:
            r27 = r1
            r0 = r12
            goto L_0x014b
        L_0x0137:
            r25 = r0
        L_0x0139:
            r0 = 0
            r26 = r0
            androidx.compose.ui.window.AlignmentOffsetPositionProvider r0 = new androidx.compose.ui.window.AlignmentOffsetPositionProvider
            r27 = r1
            r1 = 0
            r0.<init>(r15, r5, r1)
            r4.updateRememberedValue(r0)
        L_0x014b:
            r11.endReplaceableGroup()
            r7 = r0
            androidx.compose.ui.window.AlignmentOffsetPositionProvider r7 = (androidx.compose.ui.window.AlignmentOffsetPositionProvider) r7
            r0 = r7
            androidx.compose.ui.window.PopupPositionProvider r0 = (androidx.compose.ui.window.PopupPositionProvider) r0
            int r1 = r14 >> 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            int r2 = r14 >> 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r14 >> 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r12 = r1 | r2
            r16 = 0
            r1 = r8
            r2 = r13
            r3 = r30
            r4 = r11
            r17 = r5
            r5 = r12
            r6 = r16
            Popup(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x017f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x017f:
            r12 = r8
        L_0x0180:
            androidx.compose.runtime.ScopeUpdateScope r8 = r11.endRestartGroup()
            if (r8 != 0) goto L_0x0187
            goto L_0x01a1
        L_0x0187:
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$1 r16 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$1
            r0 = r16
            r1 = r15
            r2 = r17
            r4 = r12
            r5 = r13
            r6 = r30
            r7 = r32
            r9 = r8
            r8 = r33
            r0.<init>(r1, r2, r4, r5, r6, r7, r8)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x01a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt.m6230PopupK5zGePQ(androidx.compose.ui.Alignment, long, kotlin.jvm.functions.Function0, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void Popup(PopupPositionProvider popupPositionProvider, Function0<Unit> onDismissRequest, PopupProperties properties, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Function0 function0;
        PopupProperties popupProperties;
        PopupProperties properties2;
        Function0 onDismissRequest2;
        LayoutDirection layoutDirection;
        String str;
        int i2;
        State<T> state;
        PopupPositionProvider popupPositionProvider2 = popupPositionProvider;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i3 = $changed;
        Intrinsics.checkNotNullParameter(popupPositionProvider2, "popupPositionProvider");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(-830247068);
        ComposerKt.sourceInformation($composer2, "C(Popup)P(2,1,3)227@9660L7,228@9699L7,229@9743L7,230@9798L7,231@9834L28,232@9889L29,233@9937L38,234@9998L944,262@10948L417,277@11371L229,286@11606L166,298@12335L175,308@12688L771:AndroidPopup.android.kt#2oxthz");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer2.changed((Object) popupPositionProvider2) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            function0 = onDismissRequest;
        } else if ((i3 & 112) == 0) {
            function0 = onDismissRequest;
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        } else {
            function0 = onDismissRequest;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            popupProperties = properties;
        } else if ((i3 & 896) == 0) {
            popupProperties = properties;
            $dirty |= $composer2.changed((Object) popupProperties) ? 256 : 128;
        } else {
            popupProperties = properties;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if ((i3 & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (i4 != 0) {
                onDismissRequest2 = null;
            } else {
                onDismissRequest2 = function0;
            }
            if (i5 != 0) {
                properties2 = new PopupProperties(false, false, false, (SecureFlagPolicy) null, false, false, 63, (DefaultConstructorMarker) null);
            } else {
                properties2 = popupProperties;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-830247068, $dirty2, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:221)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(AndroidCompositionLocals_androidKt.getLocalView());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            View view = (View) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(LocalPopupTestTag);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            String testTag = (String) consume3;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume4;
            CompositionContext parentComposition = ComposablesKt.rememberCompositionContext($composer2, 0);
            State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, $composer2, ($dirty2 >> 9) & 14);
            CompositionContext parentComposition2 = parentComposition;
            UUID popupId = (UUID) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, AndroidPopup_androidKt$Popup$popupId$1.INSTANCE, $composer2, 3080, 6);
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                Intrinsics.checkNotNullExpressionValue(popupId, "popupId");
                Object obj = value$iv$iv;
                UUID uuid = popupId;
                layoutDirection = layoutDirection2;
                str = "CC:CompositionLocal.kt#9igjgp";
                i2 = 2023513938;
                PopupLayout $this$Popup_u24lambda_u243_u24lambda_u242 = new PopupLayout(onDismissRequest2, properties2, testTag, view, density, popupPositionProvider, popupId, (PopupLayoutHelper) null, 128, (DefaultConstructorMarker) null);
                state = rememberUpdatedState;
                $this$Popup_u24lambda_u243_u24lambda_u242.setContent(parentComposition2, ComposableLambdaKt.composableLambdaInstance(1302892335, true, new AndroidPopup_androidKt$Popup$popupLayout$1$1$1($this$Popup_u24lambda_u243_u24lambda_u242, state)));
                value$iv$iv = $this$Popup_u24lambda_u243_u24lambda_u242;
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                Object it$iv$iv = value$iv$iv;
                Composer composer = $this$cache$iv$iv;
                UUID uuid2 = popupId;
                layoutDirection = layoutDirection2;
                str = "CC:CompositionLocal.kt#9igjgp";
                i2 = 2023513938;
                state = rememberUpdatedState;
                CompositionContext compositionContext = parentComposition2;
            }
            $composer2.endReplaceableGroup();
            PopupLayout popupLayout = (PopupLayout) value$iv$iv;
            PopupLayout popupLayout2 = popupLayout;
            Function0 function02 = onDismissRequest2;
            PopupProperties popupProperties2 = properties2;
            String str2 = testTag;
            LayoutDirection layoutDirection3 = layoutDirection;
            EffectsKt.DisposableEffect((Object) popupLayout, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new AndroidPopup_androidKt$Popup$2(popupLayout2, function02, popupProperties2, str2, layoutDirection3), $composer2, 8);
            EffectsKt.SideEffect(new AndroidPopup_androidKt$Popup$3(popupLayout2, function02, popupProperties2, str2, layoutDirection3), $composer2, 0);
            EffectsKt.DisposableEffect((Object) popupPositionProvider2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new AndroidPopup_androidKt$Popup$4(popupLayout, popupPositionProvider2), $composer2, $dirty2 & 14);
            EffectsKt.LaunchedEffect((Object) popupLayout, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AndroidPopup_androidKt$Popup$5(popupLayout, (Continuation<? super AndroidPopup_androidKt$Popup$5>) null), $composer2, 72);
            Modifier modifier$iv = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.Companion, new AndroidPopup_androidKt$Popup$7(popupLayout));
            MeasurePolicy measurePolicy$iv = new AndroidPopup_androidKt$Popup$8(popupLayout, layoutDirection);
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            PopupLayout popupLayout3 = popupLayout;
            String str3 = str;
            ComposerKt.sourceInformationMarkerStart($composer2, i2, str3);
            Object consume5 = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv = (Density) consume5;
            ComposerKt.sourceInformationMarkerStart($composer2, i2, str3);
            Object consume6 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume6;
            ComposerKt.sourceInformationMarkerStart($composer2, i2, str3);
            Object consume7 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume7;
            Function0 factory$iv$iv = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m2787constructorimpl($composer2);
            State<T> state2 = state;
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i6 = ($changed$iv$iv >> 9) & 14;
            Composer $composer3 = $composer2;
            ViewConfiguration viewConfiguration = viewConfiguration$iv;
            int i7 = $changed$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 1097164901, "C:AndroidPopup.android.kt#2oxthz");
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            onDismissRequest2 = function0;
            properties2 = popupProperties;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidPopup_androidKt$Popup$9(popupPositionProvider, onDismissRequest2, properties2, content, $changed, i));
        }
    }

    /* access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> Popup$lambda$1(State<? extends Function2<? super Composer, ? super Integer, Unit>> $currentContent$delegate) {
        return (Function2) $currentContent$delegate.getValue();
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    public static final void PopupTestTag(String tag, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-498879600);
        ComposerKt.sourceInformation($composer2, "C(PopupTestTag)P(1)332@13834L75:AndroidPopup.android.kt#2oxthz");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) tag) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-498879600, $dirty, -1, "androidx.compose.ui.window.PopupTestTag (AndroidPopup.android.kt:331)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{LocalPopupTestTag.provides(tag)}, content, $composer2, ($dirty & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidPopup_androidKt$PopupTestTag$1(tag, content, $changed));
        }
    }

    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Composer composer = $composer;
        composer.startReplaceableGroup(1406149896);
        ComposerKt.sourceInformation(composer, "CC(SimpleStack)P(1)340@14172L979:AndroidPopup.android.kt#2oxthz");
        MeasurePolicy measurePolicy$iv = AndroidPopup_androidKt$SimpleStack$1.INSTANCE;
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density$iv = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd($composer);
        LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd($composer);
        ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
        Function0 factory$iv$iv = ComposeUiNode.Companion.getConstructor();
        Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier);
        int $changed$iv$iv = ((((($changed >> 3) & 14) | (($changed << 3) & 112)) << 9) & 7168) | 6;
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            composer.createNode(factory$iv$iv);
        } else {
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv = Updater.m2787constructorimpl($composer);
        Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
        Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
        skippableUpdate$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        content.invoke(composer, Integer.valueOf(($changed$iv$iv >> 9) & 14));
        $composer.endReplaceableGroup();
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
    }

    public static final boolean isFlagSecureEnabled(View $this$isFlagSecureEnabled) {
        Intrinsics.checkNotNullParameter($this$isFlagSecureEnabled, "<this>");
        ViewGroup.LayoutParams layoutParams = $this$isFlagSecureEnabled.getRootView().getLayoutParams();
        WindowManager.LayoutParams windowParams = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        if (windowParams == null || (windowParams.flags & 8192) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final IntRect toIntBounds(Rect $this$toIntBounds) {
        return new IntRect($this$toIntBounds.left, $this$toIntBounds.top, $this$toIntBounds.right, $this$toIntBounds.bottom);
    }

    public static /* synthetic */ boolean isPopupLayout$default(View view, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return isPopupLayout(view, str);
    }

    public static final boolean isPopupLayout(View view, String testTag) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (view instanceof PopupLayout) && (testTag == null || Intrinsics.areEqual((Object) testTag, (Object) ((PopupLayout) view).getTestTag()));
    }
}
