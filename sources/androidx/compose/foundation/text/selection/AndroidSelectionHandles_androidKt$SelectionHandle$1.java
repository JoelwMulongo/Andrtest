package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
final class AndroidSelectionHandles_androidKt$SelectionHandle$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ ResolvedTextDirection $direction;
    final /* synthetic */ boolean $handlesCrossed;
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ long $position;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidSelectionHandles_androidKt$SelectionHandle$1(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z, long j, int i, ResolvedTextDirection resolvedTextDirection, boolean z2) {
        super(2);
        this.$content = function2;
        this.$modifier = modifier;
        this.$isStartHandle = z;
        this.$position = j;
        this.$$dirty = i;
        this.$direction = resolvedTextDirection;
        this.$handlesCrossed = z2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Object value$iv$iv;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C:AndroidSelectionHandles.android.kt#eksfi3");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(732099485, i, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:69)");
            }
            if (this.$content == null) {
                composer.startReplaceableGroup(386443790);
                ComposerKt.sourceInformation(composer, "73@3009L405,71@2918L645");
                Modifier modifier = this.$modifier;
                Object valueOf = Boolean.valueOf(this.$isStartHandle);
                Object key2$iv = Offset.m2904boximpl(this.$position);
                boolean z = this.$isStartHandle;
                long j = this.$position;
                int i2 = this.$$dirty;
                int i3 = ((i2 << 3) & 112) | ((i2 >> 3) & 14);
                composer.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv = composer.changed(valueOf) | composer.changed(key2$iv);
                Composer $this$cache$iv$iv = $composer;
                Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                if (!invalid$iv$iv) {
                    Boolean bool = valueOf;
                    if (it$iv$iv != Composer.Companion.getEmpty()) {
                        value$iv$iv = it$iv$iv;
                        $composer.endReplaceableGroup();
                        Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, (Function1) value$iv$iv, 1, (Object) null);
                        boolean z2 = this.$isStartHandle;
                        ResolvedTextDirection resolvedTextDirection = this.$direction;
                        boolean z3 = this.$handlesCrossed;
                        int i4 = this.$$dirty;
                        AndroidSelectionHandles_androidKt.DefaultSelectionHandle(semantics$default, z2, resolvedTextDirection, z3, $composer, (i4 & 112) | (i4 & 896) | (i4 & 7168));
                        $composer.endReplaceableGroup();
                    }
                } else {
                    Object key1$iv = valueOf;
                }
                value$iv$iv = (Function1) new AndroidSelectionHandles_androidKt$SelectionHandle$1$1$1(z, j);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                $composer.endReplaceableGroup();
                Modifier semantics$default2 = SemanticsModifierKt.semantics$default(modifier, false, (Function1) value$iv$iv, 1, (Object) null);
                boolean z22 = this.$isStartHandle;
                ResolvedTextDirection resolvedTextDirection2 = this.$direction;
                boolean z32 = this.$handlesCrossed;
                int i42 = this.$$dirty;
                AndroidSelectionHandles_androidKt.DefaultSelectionHandle(semantics$default2, z22, resolvedTextDirection2, z32, $composer, (i42 & 112) | (i42 & 896) | (i42 & 7168));
                $composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(386444465);
                ComposerKt.sourceInformation(composer, "88@3593L9");
                this.$content.invoke(composer, Integer.valueOf((this.$$dirty >> 15) & 14));
                $composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
