package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ)\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0019\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0015¢\u0006\u0002\b\u0016J\u0006\u0010\u0017\u001a\u00020\u0000J\u0006\u0010\u0018\u001a\u00020\u0000J\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldPreparedSelection;", "Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "currentValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "layoutResultProxy", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/TextLayoutResultProxy;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;)V", "getCurrentValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "getLayoutResultProxy", "()Landroidx/compose/foundation/text/TextLayoutResultProxy;", "value", "getValue", "deleteIfSelectedOr", "", "Landroidx/compose/ui/text/input/EditCommand;", "or", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "moveCursorDownByPage", "moveCursorUpByPage", "jumpByPagesOffset", "", "pagesAmount", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextPreparedSelection.kt */
public final class TextFieldPreparedSelection extends BaseTextPreparedSelection<TextFieldPreparedSelection> {
    private final TextFieldValue currentValue;
    private final TextLayoutResultProxy layoutResultProxy;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldPreparedSelection(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResultProxy textLayoutResultProxy, TextPreparedSelectionState textPreparedSelectionState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textFieldValue, (i & 2) != 0 ? OffsetMapping.Companion.getIdentity() : offsetMapping, textLayoutResultProxy, (i & 8) != 0 ? new TextPreparedSelectionState() : textPreparedSelectionState);
    }

    public final TextFieldValue getCurrentValue() {
        return this.currentValue;
    }

    public final TextLayoutResultProxy getLayoutResultProxy() {
        return this.layoutResultProxy;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldPreparedSelection(TextFieldValue currentValue2, OffsetMapping offsetMapping, TextLayoutResultProxy layoutResultProxy2, TextPreparedSelectionState state) {
        super(currentValue2.getAnnotatedString(), currentValue2.m5695getSelectiond9O1mEE(), layoutResultProxy2 != null ? layoutResultProxy2.getValue() : null, offsetMapping, state, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(currentValue2, "currentValue");
        Intrinsics.checkNotNullParameter(offsetMapping, "offsetMapping");
        Intrinsics.checkNotNullParameter(state, "state");
        this.currentValue = currentValue2;
        this.layoutResultProxy = layoutResultProxy2;
    }

    public final TextFieldValue getValue() {
        return TextFieldValue.m5690copy3r_uNRQ$default(this.currentValue, getAnnotatedString(), m1244getSelectiond9O1mEE(), (TextRange) null, 4, (Object) null);
    }

    public final List<EditCommand> deleteIfSelectedOr(Function1<? super TextFieldPreparedSelection, ? extends EditCommand> or) {
        Intrinsics.checkNotNullParameter(or, "or");
        if (TextRange.m5468getCollapsedimpl(m1244getSelectiond9O1mEE())) {
            EditCommand it = (EditCommand) or.invoke(this);
            if (it != null) {
                return CollectionsKt.listOf(it);
            }
            return null;
        }
        return CollectionsKt.listOf(new CommitTextCommand("", 0), new SetSelectionCommand(TextRange.m5472getMinimpl(m1244getSelectiond9O1mEE()), TextRange.m5472getMinimpl(m1244getSelectiond9O1mEE())));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0019: MOVE  (r4v6 '$this$moveCursorUpByPage_u24lambda_u242' androidx.compose.foundation.text.selection.TextFieldPreparedSelection) = 
          (r2v0 'this' androidx.compose.foundation.text.selection.BaseTextPreparedSelection A[D('$this$apply$iv' java.lang.Object), THIS])
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final androidx.compose.foundation.text.selection.TextFieldPreparedSelection moveCursorUpByPage() {
        /*
            r8 = this;
            r0 = r8
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            r1 = 0
            r2 = r8
            r3 = 0
            java.lang.String r4 = r0.getText$foundation_release()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x0015
            r4 = 1
            goto L_0x0016
        L_0x0015:
            r4 = 0
        L_0x0016:
            if (r4 == 0) goto L_0x002b
            r4 = r2
            androidx.compose.foundation.text.selection.TextFieldPreparedSelection r4 = (androidx.compose.foundation.text.selection.TextFieldPreparedSelection) r4
            r5 = 0
            androidx.compose.foundation.text.TextLayoutResultProxy r6 = r4.layoutResultProxy
            if (r6 == 0) goto L_0x0029
            r7 = -1
            int r6 = r4.jumpByPagesOffset(r6, r7)
            r7 = 0
            r4.setCursor(r6)
        L_0x0029:
        L_0x002b:
            java.lang.String r4 = "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r4)
            r0 = r2
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            androidx.compose.foundation.text.selection.TextFieldPreparedSelection r0 = (androidx.compose.foundation.text.selection.TextFieldPreparedSelection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldPreparedSelection.moveCursorUpByPage():androidx.compose.foundation.text.selection.TextFieldPreparedSelection");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x001a: MOVE  (r4v6 '$this$moveCursorDownByPage_u24lambda_u244' androidx.compose.foundation.text.selection.TextFieldPreparedSelection) = 
          (r2v0 'this' androidx.compose.foundation.text.selection.BaseTextPreparedSelection A[D('$this$apply$iv' java.lang.Object), THIS])
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final androidx.compose.foundation.text.selection.TextFieldPreparedSelection moveCursorDownByPage() {
        /*
            r8 = this;
            r0 = r8
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            r1 = 0
            r2 = r8
            r3 = 0
            java.lang.String r4 = r0.getText$foundation_release()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            r5 = 1
            if (r4 <= 0) goto L_0x0016
            r4 = r5
            goto L_0x0017
        L_0x0016:
            r4 = 0
        L_0x0017:
            if (r4 == 0) goto L_0x002b
            r4 = r2
            androidx.compose.foundation.text.selection.TextFieldPreparedSelection r4 = (androidx.compose.foundation.text.selection.TextFieldPreparedSelection) r4
            r6 = 0
            androidx.compose.foundation.text.TextLayoutResultProxy r7 = r4.layoutResultProxy
            if (r7 == 0) goto L_0x0029
            int r5 = r4.jumpByPagesOffset(r7, r5)
            r7 = 0
            r4.setCursor(r5)
        L_0x0029:
        L_0x002b:
            java.lang.String r4 = "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r4)
            r0 = r2
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            androidx.compose.foundation.text.selection.TextFieldPreparedSelection r0 = (androidx.compose.foundation.text.selection.TextFieldPreparedSelection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldPreparedSelection.moveCursorDownByPage():androidx.compose.foundation.text.selection.TextFieldPreparedSelection");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        if (r3 == null) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int jumpByPagesOffset(androidx.compose.foundation.text.TextLayoutResultProxy r10, int r11) {
        /*
            r9 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r10.getInnerTextFieldCoordinates()
            if (r0 == 0) goto L_0x0016
            r1 = 0
            androidx.compose.ui.layout.LayoutCoordinates r2 = r10.getDecorationBoxCoordinates()
            r3 = 0
            if (r2 == 0) goto L_0x0014
            r4 = 0
            r5 = 2
            androidx.compose.ui.geometry.Rect r3 = androidx.compose.ui.layout.LayoutCoordinates.localBoundingBoxOf$default(r2, r0, r4, r5, r3)
        L_0x0014:
            if (r3 != 0) goto L_0x001c
        L_0x0016:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.ui.geometry.Rect r3 = r0.getZero()
        L_0x001c:
            r0 = r3
            androidx.compose.ui.text.input.OffsetMapping r1 = r9.getOffsetMapping()
            androidx.compose.ui.text.input.TextFieldValue r2 = r9.currentValue
            long r2 = r2.m5695getSelectiond9O1mEE()
            int r2 = androidx.compose.ui.text.TextRange.m5469getEndimpl(r2)
            int r1 = r1.originalToTransformed(r2)
            androidx.compose.ui.text.TextLayoutResult r2 = r10.getValue()
            androidx.compose.ui.geometry.Rect r2 = r2.getCursorRect(r1)
            float r3 = r2.getLeft()
            float r4 = r2.getTop()
            long r5 = r0.m2948getSizeNHjbRc()
            float r5 = androidx.compose.ui.geometry.Size.m2981getHeightimpl(r5)
            float r6 = (float) r11
            float r5 = r5 * r6
            float r4 = r4 + r5
            androidx.compose.ui.text.input.OffsetMapping r5 = r9.getOffsetMapping()
            androidx.compose.ui.text.TextLayoutResult r6 = r10.getValue()
            long r7 = androidx.compose.ui.geometry.OffsetKt.Offset(r3, r4)
            int r6 = r6.m5446getOffsetForPositionk4lQ0M(r7)
            int r5 = r5.transformedToOriginal(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldPreparedSelection.jumpByPagesOffset(androidx.compose.foundation.text.TextLayoutResultProxy, int):int");
    }
}
