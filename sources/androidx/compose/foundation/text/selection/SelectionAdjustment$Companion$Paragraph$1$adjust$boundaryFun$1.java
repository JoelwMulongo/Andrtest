package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionAdjustment.kt */
/* synthetic */ class SelectionAdjustment$Companion$Paragraph$1$adjust$boundaryFun$1 extends FunctionReferenceImpl implements Function1<Integer, TextRange> {
    SelectionAdjustment$Companion$Paragraph$1$adjust$boundaryFun$1(Object obj) {
        super(1, obj, StringHelpersKt.class, "getParagraphBoundary", "getParagraphBoundary(Ljava/lang/CharSequence;I)J", 1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return TextRange.m5462boximpl(m1271invokejx7JFs(((Number) p1).intValue()));
    }

    /* renamed from: invoke--jx7JFs  reason: not valid java name */
    public final long m1271invokejx7JFs(int p0) {
        return StringHelpersKt.getParagraphBoundary((CharSequence) this.receiver, p0);
    }
}
