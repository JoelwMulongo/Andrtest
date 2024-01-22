package androidx.compose.material3;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.R;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"getString", "", "string", "Landroidx/compose/material3/Strings;", "getString-NWtq2-8", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Strings.android.kt */
public final class Strings_androidKt {
    /* renamed from: getString-NWtq2-8  reason: not valid java name */
    public static final String m2089getStringNWtq28(int string, Composer $composer, int $changed) {
        String str;
        $composer.startReplaceableGroup(-176762646);
        ComposerKt.sourceInformation($composer, "C(getString)P(0:c#material3.Strings)25@922L7,26@963L7:Strings.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-176762646, $changed, -1, "androidx.compose.material3.getString (Strings.android.kt:24)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        $composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Resources resources = ((Context) consume).getResources();
        if (Strings.m2075equalsimpl0(string, Strings.Companion.m2086getNavigationMenuadMyvUU())) {
            str = resources.getString(R.string.navigation_menu);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.navigation_menu)");
        } else if (Strings.m2075equalsimpl0(string, Strings.Companion.m2079getCloseDraweradMyvUU())) {
            str = resources.getString(R.string.close_drawer);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.close_drawer)");
        } else if (Strings.m2075equalsimpl0(string, Strings.Companion.m2080getCloseSheetadMyvUU())) {
            str = resources.getString(R.string.close_sheet);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.close_sheet)");
        } else if (Strings.m2075equalsimpl0(string, Strings.Companion.m2081getDefaultErrorMessageadMyvUU())) {
            str = resources.getString(R.string.default_error_message);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.st…ng.default_error_message)");
        } else if (Strings.m2075equalsimpl0(string, Strings.Companion.m2083getExposedDropdownMenuadMyvUU())) {
            str = resources.getString(R.string.dropdown_menu);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.dropdown_menu)");
        } else if (Strings.m2075equalsimpl0(string, Strings.Companion.m2088getSliderRangeStartadMyvUU())) {
            str = resources.getString(R.string.range_start);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.range_start)");
        } else if (Strings.m2075equalsimpl0(string, Strings.Companion.m2087getSliderRangeEndadMyvUU())) {
            str = resources.getString(R.string.range_end);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.range_end)");
        } else if (Strings.m2075equalsimpl0(string, Strings.Companion.m2082getDialogadMyvUU())) {
            str = resources.getString(R.string.dialog);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(andr…aterial3.R.string.dialog)");
        } else if (Strings.m2075equalsimpl0(string, Strings.Companion.m2085getMenuExpandedadMyvUU())) {
            str = resources.getString(R.string.expanded);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(andr…erial3.R.string.expanded)");
        } else if (Strings.m2075equalsimpl0(string, Strings.Companion.m2084getMenuCollapsedadMyvUU())) {
            str = resources.getString(R.string.collapsed);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(andr…rial3.R.string.collapsed)");
        } else {
            str = "";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return str;
    }
}
