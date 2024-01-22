package androidx.compose.material;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
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
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aS\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010 \u001a?\u0010!\u001a\u00020\u0014*\u00020\"2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020$2\u0006\u0010\u001c\u001a\u00020%H\u0003¢\u0006\u0002\u0010&\u001a1\u0010'\u001a\u00020\u0014*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\b\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\t\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\n\u0010\u000b\"\u0013\u0010\f\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\r\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u000e\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\u000f\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0010\u0010\u000b\"\u0019\u0010\u0011\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\u000b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006/"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DefaultSwitchPadding", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchHeight", "SwitchWidth", "ThumbDefaultElevation", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPathLength", "ThumbPressedElevation", "ThumbRippleRadius", "TrackStrokeWidth", "getTrackStrokeWidth", "TrackWidth", "getTrackWidth", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/SwitchColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SwitchColors;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material/SwitchColors;Landroidx/compose/runtime/State;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)V", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "trackColor", "Landroidx/compose/ui/graphics/Color;", "trackWidth", "strokeWidth", "drawTrack-RPmYEkk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFF)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec(100, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    private static final float DefaultSwitchPadding = Dp.m5986constructorimpl((float) 2);
    private static final float SwitchHeight;
    private static final float SwitchWidth;
    private static final float ThumbDefaultElevation = Dp.m5986constructorimpl((float) 1);
    private static final float ThumbDiameter;
    private static final float ThumbPathLength = Dp.m5986constructorimpl(TrackWidth - ThumbDiameter);
    private static final float ThumbPressedElevation = Dp.m5986constructorimpl((float) 6);
    private static final float ThumbRippleRadius = Dp.m5986constructorimpl((float) 24);
    private static final float TrackStrokeWidth = Dp.m5986constructorimpl((float) 14);
    private static final float TrackWidth;

    public static final void Switch(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, SwitchColors colors, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        boolean z;
        MutableInteractionSource interactionSource2;
        SwitchColors colors2;
        boolean enabled2;
        Modifier modifier3;
        SwitchColors colors3;
        MutableInteractionSource interactionSource3;
        int $dirty;
        Modifier modifier4;
        Modifier toggleableModifier;
        Modifier modifier5;
        Modifier modifier6;
        boolean enabled3;
        MutableInteractionSource interactionSource4;
        Object value$iv$iv;
        int i2;
        Function1<? super Boolean, Unit> function1 = onCheckedChange;
        int i3 = $changed;
        Composer $composer2 = $composer.startRestartGroup(25866825);
        ComposerKt.sourceInformation($composer2, "C(Switch)P(!1,5,4,2,3)93@4344L39,94@4427L8,*97@4499L7,98@4560L72,99@4670L7,114@5111L1113:Switch.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
            boolean z2 = checked;
        } else if ((i3 & 14) == 0) {
            $dirty2 |= $composer2.changed(checked) ? 4 : 2;
        } else {
            boolean z3 = checked;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if ((i3 & 112) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if ((i3 & 896) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed((Object) modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            z = enabled;
        } else if ((i3 & 7168) == 0) {
            z = enabled;
            $dirty2 |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
            interactionSource2 = interactionSource;
        } else if ((57344 & i3) == 0) {
            interactionSource2 = interactionSource;
            $dirty2 |= $composer2.changed((Object) interactionSource2) ? 16384 : 8192;
        } else {
            interactionSource2 = interactionSource;
        }
        if ((i3 & 458752) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                if ($composer2.changed((Object) colors2)) {
                    i2 = 131072;
                    $dirty2 |= i2;
                }
            } else {
                colors2 = colors;
            }
            i2 = 65536;
            $dirty2 |= i2;
        } else {
            colors2 = colors;
        }
        if ((374491 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i3 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier6 = Modifier.Companion;
                } else {
                    modifier6 = modifier2;
                }
                if (i5 != 0) {
                    enabled3 = true;
                } else {
                    enabled3 = z;
                }
                if (i6 != 0) {
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
                    interactionSource4 = (MutableInteractionSource) value$iv$iv;
                } else {
                    interactionSource4 = interactionSource2;
                }
                if ((i & 32) != 0) {
                    interactionSource3 = interactionSource4;
                    $dirty = $dirty2 & -458753;
                    modifier4 = modifier6;
                    enabled2 = enabled3;
                    colors3 = SwitchDefaults.INSTANCE.m1644colorsSQMK_m0(0, 0, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, $composer2, 0, 6, 1023);
                } else {
                    colors3 = colors;
                    interactionSource3 = interactionSource4;
                    $dirty = $dirty2;
                    modifier4 = modifier6;
                    enabled2 = enabled3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                $dirty = $dirty2;
                modifier4 = modifier2;
                enabled2 = z;
                interactionSource3 = interactionSource2;
                colors3 = colors2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(25866825, $dirty, -1, "androidx.compose.material.Switch (Switch.kt:88)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float maxBound = ((Density) consume).m5967toPx0680j_4(ThumbPathLength);
            SwipeableState<T> rememberSwipeableStateFor = SwipeableKt.rememberSwipeableStateFor(Boolean.valueOf(checked), function1 == null ? SwitchKt$Switch$swipeableState$1.INSTANCE : function1, AnimationSpec, $composer2, ($dirty & 14) | 384, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            boolean isRtl = consume2 == LayoutDirection.Rtl;
            if (function1 != null) {
                toggleableModifier = ToggleableKt.m1083toggleableO2vRcR0(Modifier.Companion, checked, interactionSource3, (Indication) null, enabled2, Role.m5306boximpl(Role.Companion.m5318getSwitcho7Vup1c()), onCheckedChange);
            } else {
                toggleableModifier = Modifier.Companion;
            }
            if (function1 != null) {
                modifier5 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
            } else {
                modifier5 = Modifier.Companion;
            }
            Modifier modifier$iv = SizeKt.m824requiredSizeVpY3zN4(PaddingKt.m760padding3ABfNKs(SizeKt.wrapContentSize$default(SwipeableKt.m1633swipeablepPrIpRY$default(modifier4.then(modifier5).then(toggleableModifier), rememberSwipeableStateFor, MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), false), TuplesKt.to(Float.valueOf(maxBound), true)), Orientation.Horizontal, enabled2 && function1 != null, isRtl, interactionSource3, SwitchKt$Switch$2.INSTANCE, (ResistanceConfig) null, 0.0f, 256, (Object) null), Alignment.Companion.getCenter(), false, 2, (Object) null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Modifier modifier7 = toggleableModifier;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume3;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume4;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume5;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier8 = modifier$iv;
            int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
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
            Alignment alignment = contentAlignment$iv;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            Composer $composer$iv = $composer2;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            int i7 = $changed$iv$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            int $changed2 = ((0 >> 6) & 112) | 6;
            int i8 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer3 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, -1229339329, "C138@6008L210:Switch.kt#jmzs0o");
            int i9 = $changed2;
            int i10 = (($dirty >> 3) & 896) | ($changed2 & 14) | (($dirty << 3) & 112) | (($dirty >> 6) & 7168) | (($dirty << 3) & 458752);
            Function0<ComposeUiNode> function0 = constructor;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            Density density = density$iv$iv;
            int i11 = $dirty;
            SwitchImpl(BoxScopeInstance.INSTANCE, checked, enabled2, colors3, rememberSwipeableStateFor.getOffset(), interactionSource3, $composer3, i10);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            interactionSource2 = interactionSource3;
            colors2 = colors3;
        } else {
            $composer2.skipToGroupEnd();
            int i12 = $dirty2;
            modifier3 = modifier2;
            enabled2 = z;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new SwitchKt$Switch$4(checked, onCheckedChange, modifier3, enabled2, interactionSource2, colors2, $changed, i));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SwitchImpl(androidx.compose.foundation.layout.BoxScope r39, boolean r40, boolean r41, androidx.compose.material.SwitchColors r42, androidx.compose.runtime.State<java.lang.Float> r43, androidx.compose.foundation.interaction.InteractionSource r44, androidx.compose.runtime.Composer r45, int r46) {
        /*
            r8 = r39
            r9 = r40
            r10 = r41
            r11 = r42
            r12 = r43
            r13 = r44
            r14 = r46
            r0 = -1834839253(0xffffffff92a2932b, float:-1.0259917E-27)
            r1 = r45
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SwitchImpl)P(!1,2!1,4)184@7307L46,186@7393L614,186@7359L648,205@8210L28,207@8307L81,206@8243L145,210@8418L28,211@8496L7,*212@8555L7,214@8644L6,222@8897L47,225@9054L59,219@8810L479:Switch.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = r46
            r2 = r14 & 14
            if (r2 != 0) goto L_0x002c
            boolean r2 = r7.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x002a
            r2 = 4
            goto L_0x002b
        L_0x002a:
            r2 = 2
        L_0x002b:
            r1 = r1 | r2
        L_0x002c:
            r2 = r14 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x003c
            boolean r2 = r7.changed((boolean) r9)
            if (r2 == 0) goto L_0x0039
            r2 = 32
            goto L_0x003b
        L_0x0039:
            r2 = 16
        L_0x003b:
            r1 = r1 | r2
        L_0x003c:
            r2 = r14 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x004c
            boolean r2 = r7.changed((boolean) r10)
            if (r2 == 0) goto L_0x0049
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x004b
        L_0x0049:
            r2 = 128(0x80, float:1.794E-43)
        L_0x004b:
            r1 = r1 | r2
        L_0x004c:
            r2 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x005c
            boolean r2 = r7.changed((java.lang.Object) r11)
            if (r2 == 0) goto L_0x0059
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x005b
        L_0x0059:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x005b:
            r1 = r1 | r2
        L_0x005c:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r14
            if (r2 != 0) goto L_0x006e
            boolean r2 = r7.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x006b
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x006d
        L_0x006b:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x006d:
            r1 = r1 | r2
        L_0x006e:
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r14
            if (r2 != 0) goto L_0x007f
            boolean r2 = r7.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x007c
            r2 = 131072(0x20000, float:1.83671E-40)
            goto L_0x007e
        L_0x007c:
            r2 = 65536(0x10000, float:9.18355E-41)
        L_0x007e:
            r1 = r1 | r2
        L_0x007f:
            r15 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r15
            r2 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r2) goto L_0x0096
            boolean r1 = r7.getSkipping()
            if (r1 != 0) goto L_0x0090
            goto L_0x0096
        L_0x0090:
            r7.skipToGroupEnd()
            r9 = r15
            goto L_0x02ea
        L_0x0096:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00a2
            r1 = -1
            java.lang.String r2 = "androidx.compose.material.SwitchImpl (Switch.kt:177)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r15, r1, r2)
        L_0x00a2:
            r0 = 0
            r1 = r0
            r2 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r7.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r3)
            r3 = 0
            r4 = r7
            r5 = 0
            java.lang.Object r6 = r4.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r17.getEmpty()
            if (r6 != r0) goto L_0x00cc
            r0 = 0
            androidx.compose.runtime.snapshots.SnapshotStateList r0 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf()
            r4.updateRememberedValue(r0)
            goto L_0x00cd
        L_0x00cc:
            r0 = r6
        L_0x00cd:
            r7.endReplaceableGroup()
            androidx.compose.runtime.snapshots.SnapshotStateList r0 = (androidx.compose.runtime.snapshots.SnapshotStateList) r0
            int r1 = r15 >> 15
            r1 = r1 & 14
            r1 = r1 | 48
            r2 = 0
            r3 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r7.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r3)
            boolean r3 = r7.changed((java.lang.Object) r13)
            boolean r4 = r7.changed((java.lang.Object) r0)
            r3 = r3 | r4
            r4 = r7
            r5 = 0
            java.lang.Object r6 = r4.rememberedValue()
            r16 = 0
            r17 = r1
            if (r3 != 0) goto L_0x0108
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r18.getEmpty()
            if (r6 != r1) goto L_0x0104
            goto L_0x0108
        L_0x0104:
            r20 = r2
            r1 = r6
            goto L_0x011a
        L_0x0108:
            r1 = 0
            r18 = r1
            androidx.compose.material.SwitchKt$SwitchImpl$1$1 r1 = new androidx.compose.material.SwitchKt$SwitchImpl$1$1
            r20 = r2
            r2 = 0
            r1.<init>(r13, r0, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r4.updateRememberedValue(r1)
        L_0x011a:
            r7.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            int r2 = r15 >> 15
            r2 = r2 & 14
            r2 = r2 | 64
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r13, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r1, (androidx.compose.runtime.Composer) r7, (int) r2)
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r2 = 1
            r1 = r1 ^ r2
            r22 = r1
            if (r22 == 0) goto L_0x013a
            float r1 = ThumbPressedElevation
            goto L_0x013c
        L_0x013a:
            float r1 = ThumbDefaultElevation
        L_0x013c:
            r33 = r1
            int r1 = r15 >> 6
            r1 = r1 & 14
            r3 = r15 & 112(0x70, float:1.57E-43)
            r1 = r1 | r3
            int r3 = r15 >> 3
            r3 = r3 & 896(0x380, float:1.256E-42)
            r1 = r1 | r3
            androidx.compose.runtime.State r6 = r11.trackColor(r10, r9, r7, r1)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getCenter()
            androidx.compose.ui.Modifier r1 = r8.align(r1, r3)
            r3 = 0
            r4 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r1, r3, r2, r4)
            r2 = 0
            r3 = 0
            r5 = 1157296644(0x44faf204, float:2007.563)
            r7.startReplaceableGroup(r5)
            java.lang.String r4 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r4)
            boolean r16 = r7.changed((java.lang.Object) r6)
            r17 = r7
            r18 = 0
            java.lang.Object r5 = r17.rememberedValue()
            r20 = 0
            if (r16 != 0) goto L_0x0190
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r34 = r0
            java.lang.Object r0 = r21.getEmpty()
            if (r5 != r0) goto L_0x018a
            goto L_0x0192
        L_0x018a:
            r21 = r2
            r0 = r5
            r2 = r17
            goto L_0x01a5
        L_0x0190:
            r34 = r0
        L_0x0192:
            r0 = 0
            r21 = r0
            androidx.compose.material.SwitchKt$SwitchImpl$2$1 r0 = new androidx.compose.material.SwitchKt$SwitchImpl$2$1
            r0.<init>(r6)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r21 = r2
            r2 = r17
            r2.updateRememberedValue(r0)
        L_0x01a5:
            r7.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r2 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r1, r0, r7, r2)
            int r0 = r15 >> 6
            r0 = r0 & 14
            r1 = r15 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r15 >> 3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            androidx.compose.runtime.State r0 = r11.thumbColor(r10, r9, r7, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.material.ElevationOverlayKt.getLocalElevationOverlay()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r2 = 6
            r3 = 0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            r16 = r2
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r5, r2)
            java.lang.Object r17 = r7.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r35 = r17
            androidx.compose.material.ElevationOverlay r35 = (androidx.compose.material.ElevationOverlay) r35
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r3 = 6
            r16 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r5, r2)
            java.lang.Object r2 = r7.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.ui.unit.Dp r2 = (androidx.compose.ui.unit.Dp) r2
            float r1 = r2.m6000unboximpl()
            r2 = 0
            float r3 = r1 + r33
            float r1 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r3)
            r5 = r4
            r4 = r1
            r1 = -539245302(0xffffffffdfdbc50a, float:-3.167215E19)
            r7.startReplaceableGroup(r1)
            java.lang.String r1 = "215@8719L36"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            long r1 = SwitchImpl$lambda$7(r0)
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            r16 = r5
            r5 = 6
            androidx.compose.material.Colors r3 = r3.getColors(r7, r5)
            r17 = r6
            long r5 = r3.m1449getSurface0d7_KjU()
            boolean r1 = androidx.compose.ui.graphics.Color.m3165equalsimpl0(r1, r5)
            if (r1 == 0) goto L_0x023a
            if (r35 == 0) goto L_0x023a
            long r2 = SwitchImpl$lambda$7(r0)
            r6 = 0
            r1 = r35
            r9 = r16
            r10 = 1157296644(0x44faf204, float:2007.563)
            r5 = r7
            r36 = r17
            long r1 = r1.m1504apply7g2Lkgo(r2, r4, r5, r6)
            goto L_0x0245
        L_0x023a:
            r9 = r16
            r36 = r17
            r10 = 1157296644(0x44faf204, float:2007.563)
            long r1 = SwitchImpl$lambda$7(r0)
        L_0x0245:
            r7.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getCenterStart()
            androidx.compose.ui.Modifier r3 = r8.align(r3, r5)
            int r5 = r15 >> 12
            r5 = r5 & 14
            r6 = 0
            r7.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r9)
            boolean r9 = r7.changed((java.lang.Object) r12)
            r10 = r7
            r16 = 0
            r37 = r0
            java.lang.Object r0 = r10.rememberedValue()
            r17 = 0
            if (r9 != 0) goto L_0x0283
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r38 = r4
            java.lang.Object r4 = r18.getEmpty()
            if (r0 != r4) goto L_0x0280
            goto L_0x0285
        L_0x0280:
            r18 = r0
            goto L_0x0294
        L_0x0283:
            r38 = r4
        L_0x0285:
            r4 = 0
            r18 = r0
            androidx.compose.material.SwitchKt$SwitchImpl$3$1 r0 = new androidx.compose.material.SwitchKt$SwitchImpl$3$1
            r0.<init>(r12)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r10.updateRememberedValue(r0)
        L_0x0294:
            r7.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.OffsetKt.offset(r3, r0)
            r3 = 0
            float r16 = ThumbRippleRadius
            r17 = 0
            r20 = 54
            r21 = 4
            r9 = r15
            r15 = r3
            r19 = r7
            androidx.compose.foundation.Indication r3 = androidx.compose.material.ripple.RippleKt.m1729rememberRipple9IZ8Weo(r15, r16, r17, r19, r20, r21)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.IndicationKt.indication(r0, r13, r3)
            float r3 = ThumbDiameter
            androidx.compose.ui.Modifier r23 = androidx.compose.foundation.layout.SizeKt.m822requiredSize3ABfNKs(r0, r3)
            androidx.compose.foundation.shape.RoundedCornerShape r0 = androidx.compose.foundation.shape.RoundedCornerShapeKt.getCircleShape()
            r25 = r0
            androidx.compose.ui.graphics.Shape r25 = (androidx.compose.ui.graphics.Shape) r25
            r26 = 0
            r27 = 0
            r29 = 0
            r31 = 24
            r32 = 0
            r24 = r33
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.draw.ShadowKt.m2832shadows4CzXII$default(r23, r24, r25, r26, r27, r29, r31, r32)
            androidx.compose.foundation.shape.RoundedCornerShape r3 = androidx.compose.foundation.shape.RoundedCornerShapeKt.getCircleShape()
            androidx.compose.ui.graphics.Shape r3 = (androidx.compose.ui.graphics.Shape) r3
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BackgroundKt.m448backgroundbw27NRU(r0, r1, r3)
            r3 = 0
            androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r7, r3)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02ea
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02ea:
            androidx.compose.runtime.ScopeUpdateScope r10 = r7.endRestartGroup()
            if (r10 != 0) goto L_0x02f3
            r16 = r7
            goto L_0x030e
        L_0x02f3:
            androidx.compose.material.SwitchKt$SwitchImpl$4 r15 = new androidx.compose.material.SwitchKt$SwitchImpl$4
            r0 = r15
            r1 = r39
            r2 = r40
            r3 = r41
            r4 = r42
            r5 = r43
            r6 = r44
            r16 = r7
            r7 = r46
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r10.updateScope(r15)
        L_0x030e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwitchKt.SwitchImpl(androidx.compose.foundation.layout.BoxScope, boolean, boolean, androidx.compose.material.SwitchColors, androidx.compose.runtime.State, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final long SwitchImpl$lambda$5(State<Color> $trackColor$delegate) {
        return ((Color) $trackColor$delegate.getValue()).m3174unboximpl();
    }

    private static final long SwitchImpl$lambda$7(State<Color> $thumbColor$delegate) {
        return ((Color) $thumbColor$delegate.getValue()).m3174unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: drawTrack-RPmYEkk  reason: not valid java name */
    public static final void m1646drawTrackRPmYEkk(DrawScope $this$drawTrack_u2dRPmYEkk, long trackColor, float trackWidth, float strokeWidth) {
        float strokeRadius = strokeWidth / ((float) 2);
        DrawScope.m3740drawLineNGM6Ib0$default($this$drawTrack_u2dRPmYEkk, trackColor, OffsetKt.Offset(strokeRadius, Offset.m2916getYimpl($this$drawTrack_u2dRPmYEkk.m3771getCenterF1C5BW0())), OffsetKt.Offset(trackWidth - strokeRadius, Offset.m2916getYimpl($this$drawTrack_u2dRPmYEkk.m3771getCenterF1C5BW0())), strokeWidth, StrokeCap.Companion.m3548getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
    }

    static {
        float r0 = Dp.m5986constructorimpl((float) 34);
        TrackWidth = r0;
        float r1 = Dp.m5986constructorimpl((float) 20);
        ThumbDiameter = r1;
        SwitchWidth = r0;
        SwitchHeight = r1;
    }

    public static final float getTrackWidth() {
        return TrackWidth;
    }

    public static final float getTrackStrokeWidth() {
        return TrackStrokeWidth;
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }
}
