package androidx.compose.material;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aL\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001aZ\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u00132\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u0014\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"RippleRadius", "Landroidx/compose/ui/unit/Dp;", "F", "IconButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconToggleButton", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: IconButton.kt */
public final class IconButtonKt {
    private static final float RippleRadius = Dp.m5986constructorimpl((float) 24);

    public static final void IconButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        boolean z;
        MutableInteractionSource mutableInteractionSource;
        MutableInteractionSource interactionSource2;
        boolean enabled2;
        Modifier modifier3;
        float contentAlpha;
        Object value$iv$iv;
        Function0<Unit> function0 = onClick;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(-111063634);
        ComposerKt.sourceInformation($composer2, "C(IconButton)P(4,3,1,2)62@2761L39,73@3140L54,65@2846L607:IconButton.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
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
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            z = enabled;
        } else if ((i2 & 896) == 0) {
            z = enabled;
            $dirty |= $composer2.changed(z) ? 256 : 128;
        } else {
            z = enabled;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            mutableInteractionSource = interactionSource;
        } else if ((i2 & 7168) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty |= $composer2.changed((Object) mutableInteractionSource) ? 2048 : 1024;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if ((57344 & i2) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if ((46811 & $dirty2) != 9362 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                enabled2 = true;
            } else {
                enabled2 = z;
            }
            if (i5 != 0) {
                $composer2.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                Composer $this$cache$iv$iv = $composer2;
                Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                if (it$iv$iv == Composer.Companion.getEmpty()) {
                    value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                    $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer2.endReplaceableGroup();
                interactionSource2 = (MutableInteractionSource) value$iv$iv;
            } else {
                interactionSource2 = mutableInteractionSource;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-111063634, $dirty2, -1, "androidx.compose.material.IconButton (IconButton.kt:58)");
            }
            Modifier modifier$iv = ClickableKt.m471clickableO2vRcR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), interactionSource2, RippleKt.m1729rememberRipple9IZ8Weo(false, RippleRadius, 0, $composer2, 54, 4), enabled2, (String) null, Role.m5306boximpl(Role.Companion.m5313getButtono7Vup1c()), onClick, 8, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Alignment alignment = contentAlignment$iv;
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
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier4 = modifier$iv;
            int i6 = $changed$iv$iv;
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer2);
            Function0<ComposeUiNode> function02 = constructor;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer2;
            int i7 = $changed$iv$iv$iv;
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i8 = ((48 >> 6) & 112) | 6;
            Composer $composer3 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 753555734, "C78@3363L84:IconButton.kt#jmzs0o");
            if (enabled2) {
                $composer3.startReplaceableGroup(753555784);
                ComposerKt.sourceInformation($composer3, "77@3320L7");
                ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer3.consume(ContentAlphaKt.getLocalContentAlpha());
                ComposerKt.sourceInformationMarkerEnd($composer3);
                contentAlpha = ((Number) consume4).floatValue();
            } else {
                $composer3.startReplaceableGroup(753555810);
                ComposerKt.sourceInformation($composer3, "77@3346L8");
                contentAlpha = ContentAlpha.INSTANCE.getDisabled($composer3, 6);
            }
            $composer3.endReplaceableGroup();
            int i9 = $changed$iv;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(contentAlpha))}, function2, $composer3, (($dirty2 >> 9) & 112) | 8);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            enabled2 = z;
            interactionSource2 = mutableInteractionSource;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new IconButtonKt$IconButton$3(onClick, modifier3, enabled2, interactionSource2, content, $changed, i));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0332  */
    /* JADX WARNING: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void IconToggleButton(boolean r33, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r34, androidx.compose.ui.Modifier r35, boolean r36, androidx.compose.foundation.interaction.MutableInteractionSource r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r9 = r34
            r10 = r38
            r11 = r40
            java.lang.String r0 = "onCheckedChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -54657793(0xfffffffffcbdfcff, float:-7.891804E36)
            r1 = r39
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(IconToggleButton)P(!1,5,4,2,3)106@4699L39,118@5104L54,109@4784L629:IconButton.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r40
            r2 = r41 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            r13 = r33
            goto L_0x003d
        L_0x002a:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x003b
            r13 = r33
            boolean r2 = r12.changed((boolean) r13)
            if (r2 == 0) goto L_0x0038
            r2 = 4
            goto L_0x0039
        L_0x0038:
            r2 = 2
        L_0x0039:
            r1 = r1 | r2
            goto L_0x003d
        L_0x003b:
            r13 = r33
        L_0x003d:
            r2 = r41 & 2
            if (r2 == 0) goto L_0x0044
            r1 = r1 | 48
            goto L_0x0054
        L_0x0044:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0054
            boolean r2 = r12.changedInstance(r9)
            if (r2 == 0) goto L_0x0051
            r2 = 32
            goto L_0x0053
        L_0x0051:
            r2 = 16
        L_0x0053:
            r1 = r1 | r2
        L_0x0054:
            r2 = r41 & 4
            if (r2 == 0) goto L_0x005d
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r35
            goto L_0x0072
        L_0x005d:
            r3 = r11 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0070
            r3 = r35
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x006c
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r4 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r1 = r1 | r4
            goto L_0x0072
        L_0x0070:
            r3 = r35
        L_0x0072:
            r4 = r41 & 8
            if (r4 == 0) goto L_0x007b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r36
            goto L_0x0090
        L_0x007b:
            r5 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x008e
            r5 = r36
            boolean r6 = r12.changed((boolean) r5)
            if (r6 == 0) goto L_0x008a
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x008c
        L_0x008a:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x008c:
            r1 = r1 | r6
            goto L_0x0090
        L_0x008e:
            r5 = r36
        L_0x0090:
            r6 = r41 & 16
            if (r6 == 0) goto L_0x0099
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r7 = r37
            goto L_0x00b0
        L_0x0099:
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r11
            if (r7 != 0) goto L_0x00ae
            r7 = r37
            boolean r8 = r12.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x00aa
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ac
        L_0x00aa:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x00ac:
            r1 = r1 | r8
            goto L_0x00b0
        L_0x00ae:
            r7 = r37
        L_0x00b0:
            r8 = r41 & 32
            if (r8 == 0) goto L_0x00b8
            r8 = 196608(0x30000, float:2.75506E-40)
        L_0x00b6:
            r1 = r1 | r8
            goto L_0x00c9
        L_0x00b8:
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r11
            if (r8 != 0) goto L_0x00c9
            boolean r8 = r12.changedInstance(r10)
            if (r8 == 0) goto L_0x00c6
            r8 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00c6:
            r8 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b6
        L_0x00c9:
            r14 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r14
            r8 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r8) goto L_0x00e4
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x00da
            goto L_0x00e4
        L_0x00da:
            r12.skipToGroupEnd()
            r20 = r3
            r15 = r5
            r16 = r7
            goto L_0x032b
        L_0x00e4:
            if (r2 == 0) goto L_0x00ec
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r8 = r1
            goto L_0x00ed
        L_0x00ec:
            r8 = r3
        L_0x00ed:
            if (r4 == 0) goto L_0x00f2
            r1 = 1
            r15 = r1
            goto L_0x00f3
        L_0x00f2:
            r15 = r5
        L_0x00f3:
            if (r6 == 0) goto L_0x0129
            r1 = 0
            r2 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            r3 = 0
            r4 = r12
            r5 = 0
            java.lang.Object r6 = r4.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r17.getEmpty()
            if (r6 != r0) goto L_0x011e
            r0 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r4.updateRememberedValue(r0)
            goto L_0x011f
        L_0x011e:
            r0 = r6
        L_0x011f:
            r12.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r16 = r0
            goto L_0x012b
        L_0x0129:
            r16 = r7
        L_0x012b:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x013a
            r0 = -1
            java.lang.String r1 = "androidx.compose.material.IconToggleButton (IconButton.kt:101)"
            r2 = -54657793(0xfffffffffcbdfcff, float:-7.891804E36)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r14, r0, r1)
        L_0x013a:
            androidx.compose.ui.Modifier r0 = androidx.compose.material.InteractiveComponentSizeKt.minimumInteractiveComponentSize(r8)
            androidx.compose.ui.semantics.Role$Companion r1 = androidx.compose.ui.semantics.Role.Companion
            int r17 = r1.m5314getCheckboxo7Vup1c()
            r1 = 0
            float r2 = RippleRadius
            r3 = 0
            r6 = 54
            r7 = 4
            r5 = r12
            androidx.compose.foundation.Indication r3 = androidx.compose.material.ripple.RippleKt.m1729rememberRipple9IZ8Weo(r1, r2, r3, r5, r6, r7)
            androidx.compose.ui.semantics.Role r5 = androidx.compose.ui.semantics.Role.m5306boximpl(r17)
            r1 = r33
            r2 = r16
            r4 = r15
            r6 = r34
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.ToggleableKt.m1083toggleableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getCenter()
            r2 = 48
            r3 = 0
            r4 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r12.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r4)
            r4 = 0
            int r5 = r2 >> 3
            r5 = r5 & 14
            int r6 = r2 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r5 = r5 | r6
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r1, r4, r12, r5)
            int r6 = r2 << 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r7 = 0
            r35 = r1
            r1 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r12.startReplaceableGroup(r1)
            java.lang.String r1 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r17 = 6
            r18 = 0
            r36 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            r37 = r4
            java.lang.String r4 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r3, r4)
            java.lang.Object r19 = r12.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r1 = r19
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r3 = r17
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r17 = 6
            r18 = 0
            r19 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r7, r4)
            java.lang.Object r7 = r12.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r3 = r7
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r17 = 6
            r18 = 0
            r20 = r8
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r8, r4)
            java.lang.Object r4 = r12.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r8 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            r17 = r0
            int r0 = r6 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r18 = r6
            r6 = 6
            r0 = r0 | r6
            r21 = 0
            androidx.compose.runtime.Applier r6 = r12.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x0218
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0218:
            r12.startReusableNode()
            boolean r6 = r12.getInserting()
            if (r6 == 0) goto L_0x0225
            r12.createNode(r7)
            goto L_0x0228
        L_0x0225:
            r12.useNode()
        L_0x0228:
            r12.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m2787constructorimpl(r12)
            r23 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r24 = androidx.compose.ui.node.ComposeUiNode.Companion
            r25 = r7
            kotlin.jvm.functions.Function2 r7 = r24.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r6, r5, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r6, r1, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r6, r3, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r6, r4, r7)
            r12.enableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r12)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r6)
            int r7 = r0 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r8.invoke(r6, r12, r7)
            r6 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r12.startReplaceableGroup(r6)
            int r6 = r0 >> 9
            r6 = r6 & 14
            r7 = r12
            r23 = 0
            r24 = r0
            r0 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r26 = r1
            java.lang.String r1 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r2 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r22 = 6
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r27 = r7
            r28 = 0
            r29 = r0
            r0 = -1866758134(0xffffffff90bb880a, float:-7.3968096E-29)
            r30 = r1
            java.lang.String r1 = "C123@5323L84:IconButton.kt#jmzs0o"
            r31 = r2
            r2 = r27
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            if (r15 == 0) goto L_0x02d7
            r0 = -1866758084(0xffffffff90bb883c, float:-7.3968397E-29)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "122@5280L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r22 = 0
            r27 = r1
            java.lang.String r1 = "CC:CompositionLocal.kt#9igjgp"
            r32 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r3, r1)
            java.lang.Object r1 = r2.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            java.lang.Number r1 = (java.lang.Number) r1
            float r0 = r1.floatValue()
            goto L_0x02eb
        L_0x02d7:
            r32 = r3
            r0 = -1866758058(0xffffffff90bb8856, float:-7.3968553E-29)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "122@5306L8"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            androidx.compose.material.ContentAlpha r0 = androidx.compose.material.ContentAlpha.INSTANCE
            r1 = 6
            float r0 = r0.getDisabled(r2, r1)
        L_0x02eb:
            r2.endReplaceableGroup()
            r1 = 1
            androidx.compose.runtime.ProvidedValue[] r1 = new androidx.compose.runtime.ProvidedValue[r1]
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            r39 = r4
            java.lang.Float r4 = java.lang.Float.valueOf(r0)
            androidx.compose.runtime.ProvidedValue r3 = r3.provides(r4)
            r4 = 0
            r1[r4] = r3
            int r3 = r14 >> 12
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | 8
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r1, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r10, (androidx.compose.runtime.Composer) r2, (int) r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r12.endReplaceableGroup()
            r12.endNode()
            r12.endReplaceableGroup()
            r12.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x032b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x032b:
            androidx.compose.runtime.ScopeUpdateScope r8 = r12.endRestartGroup()
            if (r8 != 0) goto L_0x0332
            goto L_0x0350
        L_0x0332:
            androidx.compose.material.IconButtonKt$IconToggleButton$3 r17 = new androidx.compose.material.IconButtonKt$IconToggleButton$3
            r0 = r17
            r1 = r33
            r2 = r34
            r3 = r20
            r4 = r15
            r5 = r16
            r6 = r38
            r7 = r40
            r9 = r8
            r8 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0350:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.IconButtonKt.IconToggleButton(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
