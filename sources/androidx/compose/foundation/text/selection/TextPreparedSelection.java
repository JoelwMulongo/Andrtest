package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/text/selection/TextPreparedSelection;", "Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "originalText", "Landroidx/compose/ui/text/AnnotatedString;", "originalSelection", "Landroidx/compose/ui/text/TextRange;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextPreparedSelection.kt */
public final class TextPreparedSelection extends BaseTextPreparedSelection<TextPreparedSelection> {
    public /* synthetic */ TextPreparedSelection(AnnotatedString annotatedString, long j, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, TextPreparedSelectionState textPreparedSelectionState, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, j, textLayoutResult, offsetMapping, textPreparedSelectionState);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextPreparedSelection(androidx.compose.ui.text.AnnotatedString r10, long r11, androidx.compose.ui.text.TextLayoutResult r13, androidx.compose.ui.text.input.OffsetMapping r14, androidx.compose.foundation.text.selection.TextPreparedSelectionState r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r9 = this;
            r0 = r16 & 4
            if (r0 == 0) goto L_0x0007
            r0 = 0
            r5 = r0
            goto L_0x0008
        L_0x0007:
            r5 = r13
        L_0x0008:
            r0 = r16 & 8
            if (r0 == 0) goto L_0x0014
            androidx.compose.ui.text.input.OffsetMapping$Companion r0 = androidx.compose.ui.text.input.OffsetMapping.Companion
            androidx.compose.ui.text.input.OffsetMapping r0 = r0.getIdentity()
            r6 = r0
            goto L_0x0015
        L_0x0014:
            r6 = r14
        L_0x0015:
            r0 = r16 & 16
            if (r0 == 0) goto L_0x0020
            androidx.compose.foundation.text.selection.TextPreparedSelectionState r0 = new androidx.compose.foundation.text.selection.TextPreparedSelectionState
            r0.<init>()
            r7 = r0
            goto L_0x0021
        L_0x0020:
            r7 = r15
        L_0x0021:
            r8 = 0
            r1 = r9
            r2 = r10
            r3 = r11
            r1.<init>(r2, r3, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextPreparedSelection.<init>(androidx.compose.ui.text.AnnotatedString, long, androidx.compose.ui.text.TextLayoutResult, androidx.compose.ui.text.input.OffsetMapping, androidx.compose.foundation.text.selection.TextPreparedSelectionState, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private TextPreparedSelection(AnnotatedString originalText, long originalSelection, TextLayoutResult layoutResult, OffsetMapping offsetMapping, TextPreparedSelectionState state) {
        super(originalText, originalSelection, layoutResult, offsetMapping, state, (DefaultConstructorMarker) null);
    }
}
