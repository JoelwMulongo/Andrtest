package androidx.compose.foundation.text;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a(\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"DefaultMinLines", "", "validateMinMaxLines", "", "minLines", "maxLines", "heightInLines", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: HeightInLinesModifier.kt */
public final class HeightInLinesModifierKt {
    public static final int DefaultMinLines = 1;

    public static /* synthetic */ Modifier heightInLines$default(Modifier modifier, TextStyle textStyle, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 1;
        }
        if ((i3 & 4) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return heightInLines(modifier, textStyle, i, i2);
    }

    public static final Modifier heightInLines(Modifier $this$heightInLines, TextStyle textStyle, int minLines, int maxLines) {
        Intrinsics.checkNotNullParameter($this$heightInLines, "<this>");
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        return ComposedModifierKt.composed($this$heightInLines, InspectableValueKt.isDebugInspectorInfoEnabled() ? new HeightInLinesModifierKt$heightInLines$$inlined$debugInspectorInfo$1(minLines, maxLines, textStyle) : InspectableValueKt.getNoInspectorInfo(), new HeightInLinesModifierKt$heightInLines$2(minLines, maxLines, textStyle));
    }

    public static final void validateMinMaxLines(int minLines, int maxLines) {
        boolean z = true;
        if (minLines > 0 && maxLines > 0) {
            if (minLines > maxLines) {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException(("minLines " + minLines + " must be less than or equal to maxLines " + maxLines).toString());
            }
            return;
        }
        throw new IllegalArgumentException(("both minLines " + minLines + " and maxLines " + maxLines + " must be greater than zero").toString());
    }
}
