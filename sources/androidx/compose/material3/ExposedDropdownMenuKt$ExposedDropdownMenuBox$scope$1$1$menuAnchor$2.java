package androidx.compose.material3;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Ref<LayoutCoordinates> $coordinates;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ MutableState<Integer> $menuHeight$delegate;
    final /* synthetic */ Function1<Boolean, Unit> $onExpandedChange;
    final /* synthetic */ int $verticalMarginInPx;
    final /* synthetic */ View $view;
    final /* synthetic */ MutableState<Integer> $width$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2(boolean z, Function1<? super Boolean, Unit> function1, int i, FocusRequester focusRequester, Ref<LayoutCoordinates> ref, View view, int i2, MutableState<Integer> mutableState, MutableState<Integer> mutableState2) {
        super(3);
        this.$expanded = z;
        this.$onExpandedChange = function1;
        this.$$dirty = i;
        this.$focusRequester = focusRequester;
        this.$coordinates = ref;
        this.$view = view;
        this.$verticalMarginInPx = i2;
        this.$width$delegate = mutableState;
        this.$menuHeight$delegate = mutableState2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        Object value$iv$iv;
        Modifier modifier = $this$composed;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(1714866713);
        ComposerKt.sourceInformation(composer, "C129@6165L31,127@6065L154:ExposedDropdownMenu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1714866713, $changed, -1, "androidx.compose.material3.ExposedDropdownMenuBox.<anonymous>.<no name provided>.menuAnchor.<anonymous> (ExposedDropdownMenu.kt:120)");
        } else {
            int i = $changed;
        }
        final Ref<LayoutCoordinates> ref = this.$coordinates;
        final View view = this.$view;
        final int i2 = this.$verticalMarginInPx;
        final MutableState<Integer> mutableState = this.$width$delegate;
        final MutableState<Integer> mutableState2 = this.$menuHeight$delegate;
        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, new Function1<LayoutCoordinates, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((LayoutCoordinates) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(LayoutCoordinates it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ExposedDropdownMenuKt.m1915ExposedDropdownMenuBox$lambda2(mutableState, IntSize.m6146getWidthimpl(it.m4839getSizeYbymL2g()));
                ref.setValue(it);
                View rootView = view.getRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
                int i = i2;
                final MutableState<Integer> mutableState = mutableState2;
                ExposedDropdownMenuKt.updateHeight(rootView, ref.getValue(), i, new Function1<Integer, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke(((Number) p1).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int newHeight) {
                        ExposedDropdownMenuKt.m1917ExposedDropdownMenuBox$lambda5(mutableState, newHeight);
                    }
                });
            }
        });
        boolean z = this.$expanded;
        Object key1$iv = this.$onExpandedChange;
        Object key2$iv = Boolean.valueOf(z);
        Function1<Boolean, Unit> function1 = this.$onExpandedChange;
        boolean z2 = this.$expanded;
        int i3 = this.$$dirty;
        int i4 = ((i3 << 3) & 112) | ((i3 >> 3) & 14);
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed(key1$iv) | composer.changed(key2$iv);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function0) new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2$2$1(function1, z2);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Modifier focusRequester = FocusRequesterModifierKt.focusRequester(ExposedDropdownMenuKt.expandable(onGloballyPositioned, z, value$iv$iv, (String) null, (String) null, (String) null, $composer, (this.$$dirty << 3) & 112, 28), this.$focusRequester);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return focusRequester;
    }
}
