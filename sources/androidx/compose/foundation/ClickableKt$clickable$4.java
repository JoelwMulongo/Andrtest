package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.Role;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class ClickableKt$clickable$4 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Indication $indication;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ String $onClickLabel;
    final /* synthetic */ Role $role;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableKt$clickable$4(Function0<Unit> function0, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, String str, Role role) {
        super(3);
        this.$onClick = function0;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
        this.$indication = indication;
        this.$onClickLabel = str;
        this.$role = role;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Object value$iv$iv4;
        Object value$iv$iv5;
        String str;
        Object value$iv$iv6;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        composer.startReplaceableGroup(92076020);
        ComposerKt.sourceInformation(composer, "C136@5787L29,137@5850L58,138@5951L56,146@6266L36,147@6350L33,148@6441L95,148@6420L116,151@6564L40,153@6678L550,171@7281L445,186@7960L24:Clickable.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(92076020, $changed, -1, "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:135)");
        } else {
            int i = $changed;
        }
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$onClick, composer, 0);
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        MutableState pressedInteraction = (MutableState) value$iv$iv;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv2 = (Map) new LinkedHashMap();
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        Map currentKeyPressInteractions = (Map) value$iv$iv2;
        composer.startReplaceableGroup(1841981561);
        ComposerKt.sourceInformation(composer, "140@6043L170");
        if (this.$enabled) {
            ClickableKt.PressedInteractionSourceDisposableEffect(this.$interactionSource, pressedInteraction, currentKeyPressInteractions, composer, 560);
        }
        $composer.endReplaceableGroup();
        Function0<Boolean> isComposeRootInScrollableContainer = Clickable_androidKt.isComposeRootInScrollableContainer(composer, 0);
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv3 = $composer;
        Object it$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
        if (it$iv$iv3 == Composer.Companion.getEmpty()) {
            value$iv$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
            $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
        } else {
            value$iv$iv3 = it$iv$iv3;
        }
        $composer.endReplaceableGroup();
        MutableState isClickableInScrollableContainer = (MutableState) value$iv$iv3;
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) isClickableInScrollableContainer) | composer.changed((Object) isComposeRootInScrollableContainer);
        Composer $this$cache$iv$iv4 = $composer;
        Object it$iv$iv4 = $this$cache$iv$iv4.rememberedValue();
        if (invalid$iv$iv || it$iv$iv4 == Composer.Companion.getEmpty()) {
            value$iv$iv4 = new ClickableKt$clickable$4$delayPressInteraction$1$1(isClickableInScrollableContainer, isComposeRootInScrollableContainer);
            $this$cache$iv$iv4.updateRememberedValue(value$iv$iv4);
        } else {
            value$iv$iv4 = it$iv$iv4;
        }
        $composer.endReplaceableGroup();
        State delayPressInteraction = SnapshotStateKt.rememberUpdatedState(value$iv$iv4, composer, 0);
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv5 = $composer;
        Object it$iv$iv5 = $this$cache$iv$iv5.rememberedValue();
        if (it$iv$iv5 == Composer.Companion.getEmpty()) {
            value$iv$iv5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2904boximpl(Offset.Companion.m2931getZeroF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
            $this$cache$iv$iv5.updateRememberedValue(value$iv$iv5);
        } else {
            value$iv$iv5 = it$iv$iv5;
        }
        $composer.endReplaceableGroup();
        MutableState centreOffset = (MutableState) value$iv$iv5;
        MutableInteractionSource mutableInteractionSource = this.$interactionSource;
        Boolean valueOf = Boolean.valueOf(this.$enabled);
        Boolean valueOf2 = Boolean.valueOf(this.$enabled);
        MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
        MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
        Boolean bool = valueOf;
        MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource;
        Modifier modifier = Modifier.Companion;
        Object[] objArr = {centreOffset, valueOf2, mutableInteractionSource2, pressedInteraction, delayPressInteraction, rememberUpdatedState};
        boolean z = this.$enabled;
        Object[] keys$iv = objArr;
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= composer.changed(key$iv);
        }
        Composer $this$cache$iv$iv6 = $composer;
        Object value$iv$iv7 = $this$cache$iv$iv6.rememberedValue();
        if (invalid$iv || value$iv$iv7 == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv7;
            Object[] objArr2 = keys$iv;
            Function0<Boolean> function0 = isComposeRootInScrollableContainer;
            State<T> state = rememberUpdatedState;
            State<T> state2 = rememberUpdatedState;
            str = "CC(remember):Composables.kt#9igjgp";
            value$iv$iv7 = new ClickableKt$clickable$4$gesture$1$1(centreOffset, z, mutableInteractionSource3, pressedInteraction, delayPressInteraction, state, (Continuation<? super ClickableKt$clickable$4$gesture$1$1>) null);
            $this$cache$iv$iv6.updateRememberedValue(value$iv$iv7);
        } else {
            State<T> state3 = rememberUpdatedState;
            Object obj2 = value$iv$iv7;
            Composer composer2 = $this$cache$iv$iv6;
            Object[] objArr3 = keys$iv;
            Function0<Boolean> function02 = isComposeRootInScrollableContainer;
            str = "CC(remember):Composables.kt#9igjgp";
        }
        $composer.endReplaceableGroup();
        Modifier gesture = SuspendingPointerInputFilterKt.pointerInput(modifier, mutableInteractionSource4, bool, (Function2) value$iv$iv7);
        Modifier.Companion companion = Modifier.Companion;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, str);
        Composer $this$cache$iv$iv7 = $composer;
        Object it$iv$iv6 = $this$cache$iv$iv7.rememberedValue();
        MutableState mutableState = pressedInteraction;
        if (it$iv$iv6 == Composer.Companion.getEmpty()) {
            value$iv$iv6 = new ClickableKt$clickable$4$1$1(isClickableInScrollableContainer);
            $this$cache$iv$iv7.updateRememberedValue(value$iv$iv6);
        } else {
            value$iv$iv6 = it$iv$iv6;
        }
        $composer.endReplaceableGroup();
        Modifier then = companion.then((Modifier) value$iv$iv6);
        MutableInteractionSource mutableInteractionSource5 = this.$interactionSource;
        Indication indication = this.$indication;
        composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
        Composer composer$iv = $composer;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, str);
        Composer $this$cache$iv$iv$iv = $composer;
        Object value$iv$iv$iv = $this$cache$iv$iv$iv.rememberedValue();
        if (value$iv$iv$iv == Composer.Companion.getEmpty()) {
            Object obj3 = value$iv$iv$iv;
            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext) EmptyCoroutineContext.INSTANCE, composer$iv));
            $this$cache$iv$iv$iv.updateRememberedValue(value$iv$iv$iv);
        } else {
            Object it$iv$iv$iv = value$iv$iv$iv;
        }
        $composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv).getCoroutineScope();
        $composer.endReplaceableGroup();
        Modifier r1 = ClickableKt.m478genericClickableWithoutGesturebdNGguI(then, gesture, mutableInteractionSource5, indication, coroutineScope, currentKeyPressInteractions, centreOffset, this.$enabled, this.$onClickLabel, this.$role, (String) null, (Function0<Unit>) null, this.$onClick);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r1;
    }
}
