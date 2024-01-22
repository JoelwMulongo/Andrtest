package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0003ø\u0001\u0000¢\u0006\u0002\u0010\r\u001aF\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\f2'\u0010\u0011\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00020\f¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000f0\u0012H\u0000ø\u0001\u0000\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0002X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\"\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\bX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"MagnifierSpringSpec", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/geometry/Offset;", "OffsetDisplacementThreshold", "J", "UnspecifiedAnimationVector2D", "Landroidx/compose/animation/core/AnimationVector2D;", "UnspecifiedSafeOffsetVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "rememberAnimatedMagnifierPosition", "Landroidx/compose/runtime/State;", "targetCalculation", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animatedSelectionMagnifier", "Landroidx/compose/ui/Modifier;", "magnifierCenter", "platformMagnifier", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animatedCenter", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionMagnifier.kt */
public final class SelectionMagnifierKt {
    /* access modifiers changed from: private */
    public static final SpringSpec<Offset> MagnifierSpringSpec;
    /* access modifiers changed from: private */
    public static final long OffsetDisplacementThreshold;
    /* access modifiers changed from: private */
    public static final AnimationVector2D UnspecifiedAnimationVector2D = new AnimationVector2D(Float.NaN, Float.NaN);
    /* access modifiers changed from: private */
    public static final TwoWayConverter<Offset, AnimationVector2D> UnspecifiedSafeOffsetVectorConverter = VectorConvertersKt.TwoWayConverter(SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1.INSTANCE, SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$2.INSTANCE);

    static {
        long Offset = OffsetKt.Offset(0.01f, 0.01f);
        OffsetDisplacementThreshold = Offset;
        MagnifierSpringSpec = new SpringSpec(0.0f, 0.0f, Offset.m2904boximpl(Offset), 3, (DefaultConstructorMarker) null);
    }

    public static final Modifier animatedSelectionMagnifier(Modifier $this$animatedSelectionMagnifier, Function0<Offset> magnifierCenter, Function1<? super Function0<Offset>, ? extends Modifier> platformMagnifier) {
        Intrinsics.checkNotNullParameter($this$animatedSelectionMagnifier, "<this>");
        Intrinsics.checkNotNullParameter(magnifierCenter, "magnifierCenter");
        Intrinsics.checkNotNullParameter(platformMagnifier, "platformMagnifier");
        return ComposedModifierKt.composed$default($this$animatedSelectionMagnifier, (Function1) null, new SelectionMagnifierKt$animatedSelectionMagnifier$1(magnifierCenter, platformMagnifier), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final State<Offset> rememberAnimatedMagnifierPosition(Function0<Offset> targetCalculation, Composer $composer, int $changed) {
        State<T> state;
        Object value$iv$iv;
        Composer composer = $composer;
        composer.startReplaceableGroup(-1589795249);
        ComposerKt.sourceInformation(composer, "C(rememberAnimatedMagnifierPosition)79@3044L46,80@3112L208,84@3325L1186:SelectionMagnifier.kt#eksfi3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1589795249, $changed, -1, "androidx.compose.foundation.text.selection.rememberAnimatedMagnifierPosition (SelectionMagnifier.kt:76)");
        } else {
            int i = $changed;
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            state = SnapshotStateKt.derivedStateOf(targetCalculation);
            $this$cache$iv$iv.updateRememberedValue(state);
        } else {
            state = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        State targetValue$delegate = state;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv = new Animatable(Offset.m2904boximpl(rememberAnimatedMagnifierPosition$lambda$1(targetValue$delegate)), UnspecifiedSafeOffsetVectorConverter, Offset.m2904boximpl(OffsetDisplacementThreshold));
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        Animatable animatable = (Animatable) value$iv$iv;
        EffectsKt.LaunchedEffect((Object) Unit.INSTANCE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1(targetValue$delegate, animatable, (Continuation<? super SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1>) null), composer, 70);
        State<Offset> asState = animatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return asState;
    }

    /* access modifiers changed from: private */
    public static final long rememberAnimatedMagnifierPosition$lambda$1(State<Offset> $targetValue$delegate) {
        return ((Offset) $targetValue$delegate.getValue()).m2925unboximpl();
    }
}
