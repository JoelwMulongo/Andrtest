package androidx.compose.material3;

import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidAlertDialog.android.kt */
final class AndroidAlertDialog_androidKt$AlertDialog$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ Function2<Composer, Integer, Unit> $confirmButton;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dismissButton;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ long $iconContentColor;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;
    final /* synthetic */ long $textContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
    final /* synthetic */ long $titleContentColor;
    final /* synthetic */ float $tonalElevation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidAlertDialog_androidKt$AlertDialog$1(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, long j, float f, long j2, long j3, long j4, int i, int i2, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25) {
        super(2);
        this.$modifier = modifier;
        this.$icon = function2;
        this.$title = function22;
        this.$text = function23;
        this.$shape = shape;
        this.$containerColor = j;
        this.$tonalElevation = f;
        this.$iconContentColor = j2;
        this.$titleContentColor = j3;
        this.$textContentColor = j4;
        this.$$dirty = i;
        this.$$dirty1 = i2;
        this.$dismissButton = function24;
        this.$confirmButton = function25;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Object value$iv$iv;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C93@4608L25,105@5053L37,117@5696L9,94@4642L1223:AndroidAlertDialog.android.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1218806937, i, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:92)");
            }
            String dialogPaneDescription = Strings_androidKt.m2089getStringNWtq28(Strings.Companion.m2082getDialogadMyvUU(), composer, 6);
            final Function2<Composer, Integer, Unit> function2 = this.$dismissButton;
            final int i2 = this.$$dirty;
            final Function2<Composer, Integer, Unit> function22 = this.$confirmButton;
            Function2 composableLambda = ComposableLambdaKt.composableLambda(composer, 2094788745, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C96@4702L262:AndroidAlertDialog.android.kt#uh7d8r");
                    if (($changed & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2094788745, $changed, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:95)");
                        }
                        float access$getButtonsMainAxisSpacing$p = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                        float access$getButtonsCrossAxisSpacing$p = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final int i = i2;
                        final Function2<Composer, Integer, Unit> function22 = function22;
                        AlertDialogKt.m1738AlertDialogFlowRowixp7dh8(access$getButtonsMainAxisSpacing$p, access$getButtonsCrossAxisSpacing$p, ComposableLambdaKt.composableLambda($composer, -1243689536, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                                invoke((Composer) p1, ((Number) p2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer, int $changed) {
                                ComposerKt.sourceInformation($composer, "C101@4931L15:AndroidAlertDialog.android.kt#uh7d8r");
                                if (($changed & 11) != 2 || !$composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1243689536, $changed, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                    }
                                    Function2<Composer, Integer, Unit> function2 = function2;
                                    $composer.startReplaceableGroup(-1969500760);
                                    ComposerKt.sourceInformation($composer, "100@4902L8");
                                    if (function2 != null) {
                                        function2.invoke($composer, Integer.valueOf((i >> 9) & 14));
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    $composer.endReplaceableGroup();
                                    function22.invoke($composer, Integer.valueOf((i >> 3) & 14));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer.skipToGroupEnd();
                            }
                        }), $composer, 438);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            });
            Modifier modifier = this.$modifier;
            Modifier modifier2 = Modifier.Companion;
            composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = composer.changed((Object) dialogPaneDescription);
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = (Function1) new AndroidAlertDialog_androidKt$AlertDialog$1$2$1(dialogPaneDescription);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            Modifier then = modifier.then(SemanticsModifierKt.semantics$default(modifier2, false, (Function1) value$iv$iv, 1, (Object) null));
            Function2<Composer, Integer, Unit> function23 = this.$icon;
            Function2<Composer, Integer, Unit> function24 = this.$title;
            Function2<Composer, Integer, Unit> function25 = this.$text;
            Shape shape = this.$shape;
            long j = this.$containerColor;
            float f = this.$tonalElevation;
            long color = ColorSchemeKt.toColor(DialogTokens.INSTANCE.getActionLabelTextColor(), composer, 6);
            String dialogPaneDescription2 = dialogPaneDescription;
            long j2 = this.$iconContentColor;
            String str = dialogPaneDescription2;
            long j3 = this.$titleContentColor;
            Modifier modifier3 = then;
            long j4 = this.$textContentColor;
            int i3 = this.$$dirty;
            Function2<Composer, Integer, Unit> function26 = function23;
            int i4 = this.$$dirty1;
            int i5 = ((i3 >> 6) & 896) | 6 | ((i3 >> 6) & 7168) | ((i3 >> 6) & 57344) | ((i3 >> 6) & 458752) | ((i3 >> 6) & 3670016) | ((i4 << 15) & 29360128) | (i3 & 1879048192);
            int i6 = (i4 & 14) | (i4 & 112);
            AlertDialogKt.m1737AlertDialogContent4hvqGtA(composableLambda, modifier3, function26, function24, function25, shape, j, f, color, j2, j3, j4, $composer, i5, i6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
