package androidx.activity.compose;

import androidx.activity.FullyDrawnReporter;
import androidx.activity.FullyDrawnReporterOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a.\u0010\u0003\u001a\u00020\u00012\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"ReportDrawn", "", "(Landroidx/compose/runtime/Composer;I)V", "ReportDrawnAfter", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ReportDrawnWhen", "predicate", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "activity-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ReportDrawn.kt */
public final class ReportDrawnKt {
    public static final void ReportDrawnWhen(Function0<Boolean> predicate, Composer $composer, int $changed) {
        FullyDrawnReporter fullyDrawnReporter;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Composer $composer2 = $composer.startRestartGroup(-2047119994);
        ComposerKt.sourceInformation($composer2, "C(ReportDrawnWhen)131@4432L7,132@4474L339:ReportDrawn.kt#q1dkbc");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) predicate) ? 4 : 2;
        }
        if (($dirty & 11) != 2 || !$composer2.getSkipping()) {
            FullyDrawnReporterOwner current = LocalFullyDrawnReporterOwner.INSTANCE.getCurrent($composer2, 6);
            if (current == null || (fullyDrawnReporter = current.getFullyDrawnReporter()) == null) {
                ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new ReportDrawnKt$ReportDrawnWhen$fullyDrawnReporter$1(predicate, $changed));
                    return;
                }
                return;
            }
            EffectsKt.DisposableEffect(fullyDrawnReporter, predicate, new ReportDrawnKt$ReportDrawnWhen$1(fullyDrawnReporter, predicate), $composer2, (($dirty << 3) & 112) | 8);
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new ReportDrawnKt$ReportDrawnWhen$2(predicate, $changed));
        }
    }

    public static final void ReportDrawn(Composer $composer, int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1357012904);
        ComposerKt.sourceInformation($composer2, "C(ReportDrawn)152@5068L24:ReportDrawn.kt#q1dkbc");
        if ($changed != 0 || !$composer2.getSkipping()) {
            ReportDrawnWhen(ReportDrawnKt$ReportDrawn$1.INSTANCE, $composer2, 6);
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ReportDrawnKt$ReportDrawn$2($changed));
        }
    }

    public static final void ReportDrawnAfter(Function1<? super Continuation<? super Unit>, ? extends Object> block, Composer $composer, int $changed) {
        FullyDrawnReporter fullyDrawnReporter;
        Intrinsics.checkNotNullParameter(block, "block");
        Composer $composer2 = $composer.startRestartGroup(945311272);
        ComposerKt.sourceInformation($composer2, "C(ReportDrawnAfter)170@5599L7,171@5641L102:ReportDrawn.kt#q1dkbc");
        FullyDrawnReporterOwner current = LocalFullyDrawnReporterOwner.INSTANCE.getCurrent($composer2, 6);
        if (current == null || (fullyDrawnReporter = current.getFullyDrawnReporter()) == null) {
            ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new ReportDrawnKt$ReportDrawnAfter$fullyDrawnReporter$1(block, $changed));
                return;
            }
            return;
        }
        EffectsKt.LaunchedEffect(block, fullyDrawnReporter, new ReportDrawnKt$ReportDrawnAfter$1(fullyDrawnReporter, block, (Continuation<? super ReportDrawnKt$ReportDrawnAfter$1>) null), $composer2, 584);
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new ReportDrawnKt$ReportDrawnAfter$2(block, $changed));
        }
    }
}
