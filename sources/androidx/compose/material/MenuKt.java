package androidx.compose.material;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aT\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00100\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001aa\u0010\u001f\u001a\u00020\u00102\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100!2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\"\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00100\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0001¢\u0006\u0002\u0010(\u001a \u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0000ø\u0001\u0000¢\u0006\u0002\u0010-\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0006\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0007\u0010\b\"\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u0013\u0010\u000b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\f\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\r\u0010\b\"\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"DropdownMenuItemDefaultMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "DropdownMenuItemDefaultMinHeight", "DropdownMenuItemDefaultMinWidth", "DropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "()F", "InTransitionDuration", "", "MenuElevation", "MenuVerticalMargin", "getMenuVerticalMargin", "OutTransitionDuration", "DropdownMenuContent", "", "expandedStates", "Landroidx/compose/animation/core/MutableTransitionState;", "", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItemContent", "onClick", "Lkotlin/Function0;", "enabled", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "calculateTransformOrigin", "parentBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Menu.kt */
public final class MenuKt {
    private static final float DropdownMenuItemDefaultMaxWidth = Dp.m5986constructorimpl((float) 280);
    private static final float DropdownMenuItemDefaultMinHeight = Dp.m5986constructorimpl((float) 48);
    private static final float DropdownMenuItemDefaultMinWidth = Dp.m5986constructorimpl((float) 112);
    /* access modifiers changed from: private */
    public static final float DropdownMenuItemHorizontalPadding = Dp.m5986constructorimpl((float) 16);
    private static final float DropdownMenuVerticalPadding = Dp.m5986constructorimpl((float) 8);
    public static final int InTransitionDuration = 120;
    private static final float MenuElevation = Dp.m5986constructorimpl((float) 8);
    private static final float MenuVerticalMargin = Dp.m5986constructorimpl((float) 48);
    public static final int OutTransitionDuration = 75;

    public static final void DropdownMenuContent(MutableTransitionState<Boolean> expandedStates, MutableState<TransformOrigin> transformOriginState, Modifier modifier, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        float f;
        String str;
        String str2;
        float f2;
        Modifier modifier5;
        float f3;
        float f4;
        Object value$iv$iv;
        MutableTransitionState<Boolean> mutableTransitionState = expandedStates;
        MutableState<TransformOrigin> mutableState = transformOriginState;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(mutableTransitionState, "expandedStates");
        Intrinsics.checkNotNullParameter(mutableState, "transformOriginState");
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(1164283597);
        ComposerKt.sourceInformation($composer2, "C(DropdownMenuContent)P(1,3,2)68@2881L48,70@2959L666,96@3655L477,116@4185L153,115@4137L501:Menu.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed((Object) mutableTransitionState) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if ((i2 & 112) == 0) {
            $dirty |= $composer2.changed((Object) mutableState) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if ((i2 & 896) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if ((i2 & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1164283597, $dirty2, -1, "androidx.compose.material.DropdownMenuContent (Menu.kt:61)");
            }
            Transition $this$animateFloat$iv = TransitionKt.updateTransition(mutableTransitionState, "DropDownMenu", $composer2, MutableTransitionState.$stable | 48 | ($dirty2 & 14), 0);
            Function3 transitionSpec$iv = MenuKt$DropdownMenuContent$scale$2.INSTANCE;
            $composer2.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation($composer2, "C(animateFloat)P(2)933@37134L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            Transition $this$animateValue$iv$iv = $this$animateFloat$iv;
            int $changed$iv$iv = ((0 << 3) & 57344) | (0 & 14) | ((0 << 3) & 896) | ((0 << 3) & 7168);
            $composer2.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)851@33724L32,852@33779L31,853@33835L23,855@33871L89:Transition.kt#pdpnli");
            int $changed2 = ($changed$iv$iv >> 9) & 112;
            boolean it = ((Boolean) $this$animateValue$iv$iv.getCurrentState()).booleanValue();
            Composer $composer3 = $composer2;
            $composer3.startReplaceableGroup(-1958825495);
            ComposerKt.sourceInformation($composer3, "C:Menu.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1958825495, $changed2, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:86)");
            }
            if (it) {
                f = 1.0f;
            } else {
                f = 0.8f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer3.endReplaceableGroup();
            Object valueOf = Float.valueOf(f);
            String str3 = "C(animateValue)P(3,2)851@33724L32,852@33779L31,853@33835L23,855@33871L89:Transition.kt#pdpnli";
            Object initialValue$iv$iv = valueOf;
            int $changed3 = ($changed$iv$iv >> 9) & 112;
            boolean it2 = ((Boolean) $this$animateValue$iv$iv.getTargetState()).booleanValue();
            Composer $composer4 = $composer2;
            $composer4.startReplaceableGroup(-1958825495);
            ComposerKt.sourceInformation($composer4, "C:Menu.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                str = "C(animateFloat)P(2)933@37134L78:Transition.kt#pdpnli";
                str2 = "C:Menu.kt#jmzs0o";
                ComposerKt.traceEventStart(-1958825495, $changed3, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:86)");
            } else {
                str = "C(animateFloat)P(2)933@37134L78:Transition.kt#pdpnli";
                str2 = "C:Menu.kt#jmzs0o";
            }
            if (it2) {
                f2 = 1.0f;
            } else {
                f2 = 0.8f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer4.endReplaceableGroup();
            String str4 = str;
            Function3 function32 = transitionSpec$iv;
            State createTransitionAnimation = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv, initialValue$iv$iv, Float.valueOf(f2), (FiniteAnimationSpec) transitionSpec$iv.invoke($this$animateValue$iv$iv.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112)), vectorConverter, "FloatAnimation", $composer2, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            State scale$delegate = createTransitionAnimation;
            Function3 transitionSpec$iv2 = MenuKt$DropdownMenuContent$alpha$2.INSTANCE;
            $composer2.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation($composer2, str4);
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            Transition $this$animateValue$iv$iv2 = $this$animateFloat$iv;
            int $changed$iv$iv2 = ((0 << 3) & 57344) | (0 & 14) | ((0 << 3) & 896) | ((0 << 3) & 7168);
            $composer2.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation($composer2, str3);
            int $changed4 = ($changed$iv$iv2 >> 9) & 112;
            boolean it3 = ((Boolean) $this$animateValue$iv$iv2.getCurrentState()).booleanValue();
            Composer $composer5 = $composer2;
            $composer5.startReplaceableGroup(-1541356035);
            String str5 = str2;
            ComposerKt.sourceInformation($composer5, str5);
            if (ComposerKt.isTraceInProgress()) {
                Transition<T> transition = $this$animateFloat$iv;
                modifier5 = modifier4;
                ComposerKt.traceEventStart(-1541356035, $changed4, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:106)");
            } else {
                Transition transition2 = $this$animateFloat$iv;
                modifier5 = modifier4;
            }
            if (it3) {
                f3 = 1.0f;
            } else {
                f3 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer5.endReplaceableGroup();
            Object initialValue$iv$iv2 = Float.valueOf(f3);
            int $changed5 = ($changed$iv$iv2 >> 9) & 112;
            boolean it4 = ((Boolean) $this$animateValue$iv$iv2.getTargetState()).booleanValue();
            Composer $composer6 = $composer2;
            $composer6.startReplaceableGroup(-1541356035);
            ComposerKt.sourceInformation($composer6, str5);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1541356035, $changed5, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:106)");
            }
            if (it4) {
                f4 = 1.0f;
            } else {
                f4 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer6.endReplaceableGroup();
            State createTransitionAnimation2 = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv2, initialValue$iv$iv2, Float.valueOf(f4), (FiniteAnimationSpec) transitionSpec$iv2.invoke($this$animateValue$iv$iv2.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv2 >> 3) & 112)), vectorConverter2, "FloatAnimation", $composer2, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (458752 & ($changed$iv$iv2 << 6)));
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            State alpha$delegate = createTransitionAnimation2;
            Modifier modifier6 = Modifier.Companion;
            int i4 = ($dirty2 << 3) & 896;
            $composer2.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed((Object) scale$delegate) | $composer2.changed((Object) alpha$delegate) | $composer2.changed((Object) mutableState);
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = (Function1) new MenuKt$DropdownMenuContent$1$1(mutableState, scale$delegate, alpha$delegate);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            Modifier modifier7 = modifier5;
            CardKt.m1421CardFjzlyU(GraphicsLayerModifierKt.graphicsLayer(modifier6, (Function1) value$iv$iv), (Shape) null, 0, 0, (BorderStroke) null, MenuElevation, ComposableLambdaKt.composableLambda($composer2, -242468534, true, new MenuKt$DropdownMenuContent$2(modifier7, function3, $dirty2)), $composer2, 1769472, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier7;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i5 = $dirty2;
            Composer composer = $composer2;
            return;
        }
        int i6 = $dirty2;
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new MenuKt$DropdownMenuContent$3(expandedStates, transformOriginState, modifier3, content, $changed, i));
    }

    /* access modifiers changed from: private */
    public static final float DropdownMenuContent$lambda$1(State<Float> $scale$delegate) {
        return ((Number) $scale$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final float DropdownMenuContent$lambda$3(State<Float> $alpha$delegate) {
        return ((Number) $alpha$delegate.getValue()).floatValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0315  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0318  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DropdownMenuItemContent(kotlin.jvm.functions.Function0<kotlin.Unit> r35, androidx.compose.ui.Modifier r36, boolean r37, androidx.compose.foundation.layout.PaddingValues r38, androidx.compose.foundation.interaction.MutableInteractionSource r39, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r9 = r35
            r10 = r40
            r11 = r42
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 87134531(0x5319143, float:8.3491804E-36)
            r1 = r41
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DropdownMenuItemContent)P(5,4,2,1,3)140@4912L39,150@5295L20,144@5084L996:Menu.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r42
            r2 = r43 & 1
            if (r2 == 0) goto L_0x0028
            r1 = r1 | 6
            goto L_0x0036
        L_0x0028:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0036
            boolean r2 = r12.changedInstance(r9)
            if (r2 == 0) goto L_0x0034
            r2 = 4
            goto L_0x0035
        L_0x0034:
            r2 = 2
        L_0x0035:
            r1 = r1 | r2
        L_0x0036:
            r2 = r43 & 2
            if (r2 == 0) goto L_0x003f
            r1 = r1 | 48
            r3 = r36
            goto L_0x0054
        L_0x003f:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0052
            r3 = r36
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
            r3 = r36
        L_0x0054:
            r4 = r43 & 4
            if (r4 == 0) goto L_0x005d
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r37
            goto L_0x0072
        L_0x005d:
            r5 = r11 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0070
            r5 = r37
            boolean r6 = r12.changed((boolean) r5)
            if (r6 == 0) goto L_0x006c
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r6 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r1 = r1 | r6
            goto L_0x0072
        L_0x0070:
            r5 = r37
        L_0x0072:
            r6 = r43 & 8
            if (r6 == 0) goto L_0x007b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r38
            goto L_0x0090
        L_0x007b:
            r7 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x008e
            r7 = r38
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
            r7 = r38
        L_0x0090:
            r8 = r43 & 16
            if (r8 == 0) goto L_0x0099
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r13 = r39
            goto L_0x00b0
        L_0x0099:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r11
            if (r13 != 0) goto L_0x00ae
            r13 = r39
            boolean r14 = r12.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00aa
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ac
        L_0x00aa:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x00ac:
            r1 = r1 | r14
            goto L_0x00b0
        L_0x00ae:
            r13 = r39
        L_0x00b0:
            r14 = r43 & 32
            if (r14 == 0) goto L_0x00b8
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x00b6:
            r1 = r1 | r14
            goto L_0x00c9
        L_0x00b8:
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r11
            if (r14 != 0) goto L_0x00c9
            boolean r14 = r12.changedInstance(r10)
            if (r14 == 0) goto L_0x00c6
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00c6:
            r14 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b6
        L_0x00c9:
            r14 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r14
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r15) goto L_0x00e3
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x00da
            goto L_0x00e3
        L_0x00da:
            r12.skipToGroupEnd()
            r15 = r3
            r16 = r5
            r9 = r7
            goto L_0x030f
        L_0x00e3:
            if (r2 == 0) goto L_0x00eb
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r15 = r1
            goto L_0x00ec
        L_0x00eb:
            r15 = r3
        L_0x00ec:
            if (r4 == 0) goto L_0x00f2
            r1 = 1
            r16 = r1
            goto L_0x00f4
        L_0x00f2:
            r16 = r5
        L_0x00f4:
            if (r6 == 0) goto L_0x00fd
            androidx.compose.material.MenuDefaults r1 = androidx.compose.material.MenuDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r1 = r1.getDropdownMenuItemContentPadding()
            r7 = r1
        L_0x00fd:
            if (r8 == 0) goto L_0x0130
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
            r8 = 0
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r17.getEmpty()
            if (r6 != r0) goto L_0x0127
            r0 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r4.updateRememberedValue(r0)
            goto L_0x0128
        L_0x0127:
            r0 = r6
        L_0x0128:
            r12.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r13 = r0
        L_0x0130:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x013f
            r0 = -1
            java.lang.String r1 = "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)"
            r2 = 87134531(0x5319143, float:8.3491804E-36)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r14, r0, r1)
        L_0x013f:
            r1 = 1
            r2 = 0
            r3 = 0
            r6 = 6
            r0 = 6
            r5 = r12
            r8 = r7
            r7 = r0
            androidx.compose.foundation.Indication r2 = androidx.compose.material.ripple.RippleKt.m1729rememberRipple9IZ8Weo(r1, r2, r3, r5, r6, r7)
            r4 = 0
            r5 = 0
            r7 = 24
            r17 = 0
            r0 = r15
            r1 = r13
            r3 = r16
            r6 = r35
            r9 = r8
            r8 = r17
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ClickableKt.m471clickableO2vRcR0$default(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r1 = 0
            r2 = 0
            r6 = 1
            androidx.compose.ui.Modifier r17 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r0, r1, r6, r2)
            float r18 = DropdownMenuItemDefaultMinWidth
            float r20 = DropdownMenuItemDefaultMaxWidth
            float r19 = DropdownMenuItemDefaultMinHeight
            r21 = 0
            r22 = 8
            r23 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m834sizeInqDBjuR0$default(r17, r18, r19, r20, r21, r22, r23)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.PaddingKt.padding(r0, r9)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r1 = r1.getCenterVertically()
            r7 = r1
            r1 = 384(0x180, float:5.38E-43)
            r8 = r1
            r17 = r0
            r18 = 0
            r0 = 693286680(0x2952b718, float:4.6788176E-14)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            androidx.compose.foundation.layout.Arrangement r0 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r5 = r0.getStart()
            int r0 = r8 >> 3
            r0 = r0 & 14
            int r1 = r8 >> 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r5, r7, r12, r0)
            int r0 = r8 << 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r19 = r0
            r20 = 0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r3, r6)
            java.lang.Object r21 = r12.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r2 = r21
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r21 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r3, r6)
            java.lang.Object r22 = r12.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r1 = r22
            androidx.compose.ui.unit.LayoutDirection r1 = (androidx.compose.ui.unit.LayoutDirection) r1
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r21 = 6
            r22 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r3, r6)
            java.lang.Object r3 = r12.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r6 = r3
            androidx.compose.ui.platform.ViewConfiguration r6 = (androidx.compose.ui.platform.ViewConfiguration) r6
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r0 = r0.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.materializerOf(r17)
            r37 = r5
            int r5 = r19 << 9
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r38 = r7
            r7 = 6
            r5 = r5 | r7
            r21 = r5
            r5 = r3
            r22 = 0
            androidx.compose.runtime.Applier r3 = r12.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x022f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x022f:
            r12.startReusableNode()
            boolean r3 = r12.getInserting()
            if (r3 == 0) goto L_0x023c
            r12.createNode(r0)
            goto L_0x023f
        L_0x023c:
            r12.useNode()
        L_0x023f:
            r12.disableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m2787constructorimpl(r12)
            r23 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r24 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r24.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r4, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r2, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r1, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r6, r7)
            r12.enableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r12)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r3)
            int r7 = r21 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r5.invoke(r3, r12, r7)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r12.startReplaceableGroup(r3)
            int r3 = r21 >> 9
            r7 = r3 & 14
            r3 = r12
            r23 = 0
            r41 = r0
            r0 = -326682283(0xffffffffec873955, float:-1.3078058E27)
            r24 = r1
            java.lang.String r1 = "C80@4021L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r1)
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r1 = r8 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r25 = r2
            r2 = 6
            r26 = r1 | 6
            androidx.compose.foundation.layout.RowScope r0 = (androidx.compose.foundation.layout.RowScope) r0
            r1 = r3
            r27 = r3
            r3 = r0
            r28 = 0
            r0 = 1610783382(0x60029a96, float:3.7643997E19)
            java.lang.String r2 = "C162@5796L10,163@5815L259:Menu.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r2)
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            r2 = 6
            androidx.compose.material.Typography r29 = r0.getTypography(r1, r2)
            androidx.compose.ui.text.TextStyle r2 = r29.getSubtitle1()
            androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1 r0 = new androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
            r30 = r41
            r39 = r0
            r41 = r6
            r6 = r1
            r1 = r16
            r31 = r7
            r7 = r2
            r2 = r40
            r32 = r4
            r4 = r26
            r33 = r37
            r34 = r5
            r5 = r14
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = 1190489496(0x46f56d98, float:31414.797)
            r1 = r39
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r6, r0, r2, r1)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 48
            androidx.compose.material.TextKt.ProvideTextStyle(r7, r0, r6, r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r27)
            r12.endReplaceableGroup()
            r12.endNode()
            r12.endReplaceableGroup()
            r12.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x030f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x030f:
            androidx.compose.runtime.ScopeUpdateScope r8 = r12.endRestartGroup()
            if (r8 != 0) goto L_0x0318
            r36 = r9
            goto L_0x0336
        L_0x0318:
            androidx.compose.material.MenuKt$DropdownMenuItemContent$3 r17 = new androidx.compose.material.MenuKt$DropdownMenuItemContent$3
            r0 = r17
            r1 = r35
            r2 = r15
            r3 = r16
            r4 = r9
            r5 = r13
            r6 = r40
            r7 = r42
            r36 = r9
            r9 = r8
            r8 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0336:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.MenuKt.DropdownMenuItemContent(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final float getMenuVerticalMargin() {
        return MenuVerticalMargin;
    }

    public static final float getDropdownMenuVerticalPadding() {
        return DropdownMenuVerticalPadding;
    }

    public static final long calculateTransformOrigin(IntRect parentBounds, IntRect menuBounds) {
        float f;
        Intrinsics.checkNotNullParameter(parentBounds, "parentBounds");
        Intrinsics.checkNotNullParameter(menuBounds, "menuBounds");
        float pivotY = 1.0f;
        if (menuBounds.getLeft() >= parentBounds.getRight()) {
            f = 0.0f;
        } else if (menuBounds.getRight() <= parentBounds.getLeft()) {
            f = 1.0f;
        } else if (menuBounds.getWidth() == 0) {
            f = 0.0f;
        } else {
            f = ((float) (((Math.max(parentBounds.getLeft(), menuBounds.getLeft()) + Math.min(parentBounds.getRight(), menuBounds.getRight())) / 2) - menuBounds.getLeft())) / ((float) menuBounds.getWidth());
        }
        float pivotX = f;
        if (menuBounds.getTop() >= parentBounds.getBottom()) {
            pivotY = 0.0f;
        } else if (menuBounds.getBottom() > parentBounds.getTop()) {
            if (menuBounds.getHeight() == 0) {
                pivotY = 0.0f;
            } else {
                pivotY = ((float) (((Math.max(parentBounds.getTop(), menuBounds.getTop()) + Math.min(parentBounds.getBottom(), menuBounds.getBottom())) / 2) - menuBounds.getTop())) / ((float) menuBounds.getHeight());
            }
        }
        return TransformOriginKt.TransformOrigin(pivotX, pivotY);
    }
}
