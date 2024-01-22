package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material3.internal.ExposedDropdownMenuPopupKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001JK\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0017¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u0005H&J\f\u0010\u0012\u001a\u00020\t*\u00020\tH&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "", "ExposedDropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "exposedDropdownSize", "matchTextFieldWidth", "menuAnchor", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
/* compiled from: ExposedDropdownMenu.kt */
public interface ExposedDropdownMenuBoxScope {
    Modifier exposedDropdownSize(Modifier modifier, boolean z);

    Modifier menuAnchor(Modifier modifier);

    static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
    }

    void ExposedDropdownMenu(boolean expanded, Function0<Unit> onDismissRequest, Modifier modifier, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Object value$iv$iv;
        Modifier modifier5;
        Object value$iv$iv2;
        Function2 value$iv$iv3;
        Function0<Unit> function0 = onDismissRequest;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(-1658683708);
        ComposerKt.sourceInformation($composer2, "C(ExposedDropdownMenu)P(1,3,2)257@10817L42,261@11019L51,262@11110L7,266@11257L139,270@11410L444:ExposedDropdownMenu.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            boolean z = expanded;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed(expanded) ? 4 : 2;
        } else {
            boolean z2 = expanded;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if ((i2 & 112) == 0) {
            $dirty |= $composer2.changed((Object) function0) ? 32 : 16;
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
            $dirty |= $composer2.changed((Object) function3) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if ((57344 & i2) == 0) {
            $dirty |= $composer2.changed((Object) this) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if ((46811 & $dirty2) != 9362 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1658683708, $dirty2, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:242)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = new MutableTransitionState(false);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            MutableTransitionState expandedStates = (MutableTransitionState) value$iv$iv;
            expandedStates.setTargetState(Boolean.valueOf(expanded));
            if (((Boolean) expandedStates.getCurrentState()).booleanValue() || ((Boolean) expandedStates.getTargetState()).booleanValue()) {
                $composer2.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                Composer $this$cache$iv$iv2 = $composer2;
                Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
                if (it$iv$iv2 == Composer.Companion.getEmpty()) {
                    value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3573boximpl(TransformOrigin.Companion.m3586getCenterSzJe1aQ()), (SnapshotMutationPolicy) null, 2, (Object) null);
                    $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
                } else {
                    value$iv$iv2 = it$iv$iv2;
                }
                $composer2.endReplaceableGroup();
                MutableState transformOriginState = (MutableState) value$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density density = (Density) consume;
                long r17 = DpOffset.Companion.m6057getZeroRKDOV3M();
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer2.changed((Object) transformOriginState);
                Composer $this$cache$iv$iv3 = $composer2;
                Object it$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
                if (!invalid$iv$iv) {
                    if (it$iv$iv3 != Composer.Companion.getEmpty()) {
                        value$iv$iv3 = it$iv$iv3;
                        $composer2.endReplaceableGroup();
                        Modifier modifier6 = modifier4;
                        modifier5 = modifier4;
                        ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1 exposedDropdownMenuBoxScope$ExposedDropdownMenu$1 = r0;
                        MutableState mutableState = transformOriginState;
                        ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1 exposedDropdownMenuBoxScope$ExposedDropdownMenu$12 = new ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1(expandedStates, transformOriginState, this, modifier6, content, $dirty2);
                        ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(onDismissRequest, new DropdownMenuPositionProvider(r17, density, value$iv$iv3, (DefaultConstructorMarker) null), ComposableLambdaKt.composableLambda($composer2, 395026654, true, exposedDropdownMenuBoxScope$ExposedDropdownMenu$1), $composer2, (($dirty2 >> 3) & 14) | 384, 0);
                    }
                }
                value$iv$iv3 = new ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1(transformOriginState);
                $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
                $composer2.endReplaceableGroup();
                Modifier modifier62 = modifier4;
                modifier5 = modifier4;
                ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1 exposedDropdownMenuBoxScope$ExposedDropdownMenu$13 = exposedDropdownMenuBoxScope$ExposedDropdownMenu$12;
                MutableState mutableState2 = transformOriginState;
                ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1 exposedDropdownMenuBoxScope$ExposedDropdownMenu$122 = new ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1(expandedStates, transformOriginState, this, modifier62, content, $dirty2);
                ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(onDismissRequest, new DropdownMenuPositionProvider(r17, density, value$iv$iv3, (DefaultConstructorMarker) null), ComposableLambdaKt.composableLambda($composer2, 395026654, true, exposedDropdownMenuBoxScope$ExposedDropdownMenu$13), $composer2, (($dirty2 >> 3) & 14) | 384, 0);
            } else {
                modifier5 = modifier4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2(this, expanded, onDismissRequest, modifier3, content, $changed, i));
        }
    }
}
