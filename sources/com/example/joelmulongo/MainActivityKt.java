package com.example.joelmulongo;

import androidx.autofill.HintConstants;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.example.joelmulongo.ui.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Greeting", "", "name", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Welcome_to_my_1st_project", "(Landroidx/compose/runtime/Composer;I)V", "app_debug"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: MainActivity.kt */
public final class MainActivityKt {
    public static final void Greeting(String name, Modifier modifier, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Composer $composer2;
        String str = name;
        int i2 = $changed;
        int i3 = i;
        Intrinsics.checkNotNullParameter(str, HintConstants.AUTOFILL_HINT_NAME);
        Composer $composer3 = $composer.startRestartGroup(128341491);
        ComposerKt.sourceInformation($composer3, "C(Greeting)P(1)31@1069L79:MainActivity.kt#e5a1pq");
        int $dirty = $changed;
        if ((i3 & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer3.changed((Object) str) ? 4 : 2;
        }
        int i4 = i3 & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer3.getSkipping()) {
            Modifier modifier3 = i4 != 0 ? Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(128341491, $dirty2, -1, "com.example.joelmulongo.Greeting (MainActivity.kt:30)");
            }
            $composer2 = $composer3;
            TextKt.m2178TextfLXpl1I(LiveLiterals$MainActivityKt.INSTANCE.m291String$0$str$arg0$callText$funGreeting() + str + LiveLiterals$MainActivityKt.INSTANCE.m292String$2$str$arg0$callText$funGreeting(), modifier3, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, $dirty2 & 112, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            int i5 = $dirty2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new MainActivityKt$Greeting$1(str, modifier2, i2, i3));
        }
    }

    public static final void Welcome_to_my_1st_project(Composer $composer, int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-95589640);
        ComposerKt.sourceInformation($composer2, "C(Welcome_to_my_1st_project)40@1234L60:MainActivity.kt#e5a1pq");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-95589640, $changed, -1, "com.example.joelmulongo.Welcome_to_my_1st_project (MainActivity.kt:39)");
            }
            ThemeKt.JoelMulongoTheme(false, false, ComposableSingletons$MainActivityKt.INSTANCE.m289getLambda4$app_debug(), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new MainActivityKt$Welcome_to_my_1st_project$1($changed));
        }
    }
}
