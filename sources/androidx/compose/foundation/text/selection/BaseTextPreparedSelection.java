package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.selection.BaseTextPreparedSelection;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b)\b \u0018\u0000 c*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002:\u0001cB2\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\fø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002J$\u0010(\u001a\u00028\u00002\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,¢\u0006\u0002\u0010-J$\u0010.\u001a\u00028\u00002\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,¢\u0006\u0002\u0010-J\u000b\u0010/\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u00101\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\r\u00103\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\u0006\u00104\u001a\u00020&J\r\u00105\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\b\u00106\u001a\u00020&H\u0002J\b\u00107\u001a\u00020&H\u0002J\u0006\u00108\u001a\u00020&J\r\u00109\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\b\u0010:\u001a\u00020;H\u0002J\u000b\u0010<\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010=\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010>\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u0010?\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\u000b\u0010@\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u0010A\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\r\u0010B\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\u000b\u0010C\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u0010D\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\u000b\u0010E\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010F\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010G\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010H\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010I\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010J\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010K\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010L\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010M\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010N\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010O\u001a\u00028\u0000¢\u0006\u0002\u00100J\u0010\u0010P\u001a\u00020+2\u0006\u0010'\u001a\u00020&H\u0004J\u0018\u0010Q\u001a\u00020+2\u0006\u0010R\u001a\u00020&2\u0006\u0010S\u001a\u00020&H\u0004J\b\u0010T\u001a\u00020&H\u0002J\b\u0010U\u001a\u00020&H\u0002J\b\u0010V\u001a\u00020&H\u0002J>\u0010W\u001a\u00028\u0000\"\u0004\b\u0001\u0010X*\u0002HX2\b\b\u0002\u0010Y\u001a\u00020;2\u0017\u0010Z\u001a\u0013\u0012\u0004\u0012\u0002HX\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,H\bø\u0001\u0003¢\u0006\u0002\u0010[J\u0016\u0010\\\u001a\u00020&*\u00020\b2\b\b\u0002\u0010]\u001a\u00020&H\u0002J\u0016\u0010^\u001a\u00020&*\u00020\b2\b\b\u0002\u0010]\u001a\u00020&H\u0002J\u0017\u0010_\u001a\u00020&*\u00020\b2\b\b\u0002\u0010]\u001a\u00020&H\u0010J\u0017\u0010`\u001a\u00020&*\u00020\b2\b\b\u0002\u0010]\u001a\u00020&H\u0010J\u0014\u0010a\u001a\u00020&*\u00020\b2\u0006\u0010b\u001a\u00020&H\u0002R\u001a\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R%\u0010\u001b\u001a\u00020\u0006X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8@X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b20\u0001¨\u0006d"}, d2 = {"Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "T", "", "originalText", "Landroidx/compose/ui/text/AnnotatedString;", "originalSelection", "Landroidx/compose/ui/text/TextRange;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "annotatedString", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "setAnnotatedString", "(Landroidx/compose/ui/text/AnnotatedString;)V", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "getOriginalSelection-d9O1mEE", "()J", "J", "getOriginalText", "selection", "getSelection-d9O1mEE", "setSelection-5zc-tL8", "(J)V", "getState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "text", "", "getText$foundation_release", "()Ljava/lang/String;", "charOffset", "", "offset", "collapseLeftOr", "or", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "collapseRightOr", "deselect", "()Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "getLineEndByOffset", "()Ljava/lang/Integer;", "getLineStartByOffset", "getNextCharacterIndex", "getNextWordOffset", "getParagraphEnd", "getParagraphStart", "getPrecedingCharacterIndex", "getPreviousWordOffset", "isLtr", "", "moveCursorDownByLine", "moveCursorLeft", "moveCursorLeftByWord", "moveCursorNext", "moveCursorNextByParagraph", "moveCursorNextByWord", "moveCursorPrev", "moveCursorPrevByParagraph", "moveCursorPrevByWord", "moveCursorRight", "moveCursorRightByWord", "moveCursorToEnd", "moveCursorToHome", "moveCursorToLineEnd", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "moveCursorToLineStart", "moveCursorUpByLine", "selectAll", "selectMovement", "setCursor", "setSelection", "start", "end", "transformedEndOffset", "transformedMaxOffset", "transformedMinOffset", "apply", "U", "resetCachedX", "block", "(Ljava/lang/Object;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "getLineEndByOffsetForLayout", "currentOffset", "getLineStartByOffsetForLayout", "getNextWordOffsetForLayout", "getPrevWordOffset", "jumpByLinesOffset", "linesAmount", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextPreparedSelection.kt */
public abstract class BaseTextPreparedSelection<T extends BaseTextPreparedSelection<T>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int NoCharacterFound = -1;
    private AnnotatedString annotatedString;
    private final TextLayoutResult layoutResult;
    private final OffsetMapping offsetMapping;
    private final long originalSelection;
    private final AnnotatedString originalText;
    private long selection;
    private final TextPreparedSelectionState state;

    public /* synthetic */ BaseTextPreparedSelection(AnnotatedString annotatedString2, long j, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping2, TextPreparedSelectionState textPreparedSelectionState, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString2, j, textLayoutResult, offsetMapping2, textPreparedSelectionState);
    }

    private BaseTextPreparedSelection(AnnotatedString originalText2, long originalSelection2, TextLayoutResult layoutResult2, OffsetMapping offsetMapping2, TextPreparedSelectionState state2) {
        this.originalText = originalText2;
        this.originalSelection = originalSelection2;
        this.layoutResult = layoutResult2;
        this.offsetMapping = offsetMapping2;
        this.state = state2;
        this.selection = originalSelection2;
        this.annotatedString = originalText2;
    }

    public final AnnotatedString getOriginalText() {
        return this.originalText;
    }

    /* renamed from: getOriginalSelection-d9O1mEE  reason: not valid java name */
    public final long m1243getOriginalSelectiond9O1mEE() {
        return this.originalSelection;
    }

    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final TextPreparedSelectionState getState() {
        return this.state;
    }

    /* renamed from: getSelection-d9O1mEE  reason: not valid java name */
    public final long m1244getSelectiond9O1mEE() {
        return this.selection;
    }

    /* renamed from: setSelection-5zc-tL8  reason: not valid java name */
    public final void m1245setSelection5zctL8(long j) {
        this.selection = j;
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final void setAnnotatedString(AnnotatedString annotatedString2) {
        Intrinsics.checkNotNullParameter(annotatedString2, "<set-?>");
        this.annotatedString = annotatedString2;
    }

    public final String getText$foundation_release() {
        return this.annotatedString.getText();
    }

    public static /* synthetic */ BaseTextPreparedSelection apply$default(BaseTextPreparedSelection $this, Object $receiver, boolean resetCachedX, Function1 block, int i, Object obj) {
        if (obj == null) {
            boolean z = true;
            if ((i & 1) != 0) {
                resetCachedX = true;
            }
            Intrinsics.checkNotNullParameter(block, "block");
            if (resetCachedX) {
                $this.getState().resetCachedX();
            }
            if ($this.getText$foundation_release().length() <= 0) {
                z = false;
            }
            if (z) {
                block.invoke($receiver);
            }
            Intrinsics.checkNotNull($receiver, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
            return (BaseTextPreparedSelection) $receiver;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: apply");
    }

    /* access modifiers changed from: protected */
    public final <U> T apply(U $this$apply, boolean resetCachedX, Function1<? super U, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (resetCachedX) {
            getState().resetCachedX();
        }
        if (getText$foundation_release().length() > 0) {
            block.invoke($this$apply);
        }
        Intrinsics.checkNotNull($this$apply, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection) $this$apply;
    }

    /* access modifiers changed from: protected */
    public final void setCursor(int offset) {
        setSelection(offset, offset);
    }

    /* access modifiers changed from: protected */
    public final void setSelection(int start, int end) {
        this.selection = TextRangeKt.TextRange(start, end);
    }

    public final T selectAll() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection $this$selectAll_u24lambda_u240 = this;
            $this$selectAll_u24lambda_u240.setSelection(0, $this$selectAll_u24lambda_u240.getText$foundation_release().length());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T deselect() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection $this$deselect_u24lambda_u241 = this;
            $this$deselect_u24lambda_u241.setCursor(TextRange.m5469getEndimpl($this$deselect_u24lambda_u241.selection));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorLeft() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection $this$moveCursorLeft_u24lambda_u242 = this;
            if ($this$moveCursorLeft_u24lambda_u242.isLtr()) {
                $this$moveCursorLeft_u24lambda_u242.moveCursorPrev();
            } else {
                $this$moveCursorLeft_u24lambda_u242.moveCursorNext();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorRight() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection $this$moveCursorRight_u24lambda_u243 = this;
            if ($this$moveCursorRight_u24lambda_u243.isLtr()) {
                $this$moveCursorRight_u24lambda_u243.moveCursorNext();
            } else {
                $this$moveCursorRight_u24lambda_u243.moveCursorPrev();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T collapseLeftOr(Function1<? super T, Unit> or) {
        Intrinsics.checkNotNullParameter(or, "or");
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection $this$collapseLeftOr_u24lambda_u244 = this;
            if (TextRange.m5468getCollapsedimpl($this$collapseLeftOr_u24lambda_u244.selection)) {
                Intrinsics.checkNotNull($this$collapseLeftOr_u24lambda_u244, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection.collapseLeftOr$lambda$4");
                or.invoke($this$collapseLeftOr_u24lambda_u244);
            } else if ($this$collapseLeftOr_u24lambda_u244.isLtr()) {
                $this$collapseLeftOr_u24lambda_u244.setCursor(TextRange.m5472getMinimpl($this$collapseLeftOr_u24lambda_u244.selection));
            } else {
                $this$collapseLeftOr_u24lambda_u244.setCursor(TextRange.m5471getMaximpl($this$collapseLeftOr_u24lambda_u244.selection));
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T collapseRightOr(Function1<? super T, Unit> or) {
        Intrinsics.checkNotNullParameter(or, "or");
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection $this$collapseRightOr_u24lambda_u245 = this;
            if (TextRange.m5468getCollapsedimpl($this$collapseRightOr_u24lambda_u245.selection)) {
                Intrinsics.checkNotNull($this$collapseRightOr_u24lambda_u245, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection.collapseRightOr$lambda$5");
                or.invoke($this$collapseRightOr_u24lambda_u245);
            } else if ($this$collapseRightOr_u24lambda_u245.isLtr()) {
                $this$collapseRightOr_u24lambda_u245.setCursor(TextRange.m5471getMaximpl($this$collapseRightOr_u24lambda_u245.selection));
            } else {
                $this$collapseRightOr_u24lambda_u245.setCursor(TextRange.m5472getMinimpl($this$collapseRightOr_u24lambda_u245.selection));
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final int getPrecedingCharacterIndex() {
        return StringHelpers_androidKt.findPrecedingBreak(this.annotatedString.getText(), TextRange.m5469getEndimpl(this.selection));
    }

    public final int getNextCharacterIndex() {
        return StringHelpers_androidKt.findFollowingBreak(this.annotatedString.getText(), TextRange.m5469getEndimpl(this.selection));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x001d: MOVE  (r2v7 '$this$moveCursorPrev_u24lambda_u246' androidx.compose.foundation.text.selection.BaseTextPreparedSelection) = 
          (r6v0 'this' androidx.compose.foundation.text.selection.BaseTextPreparedSelection A[THIS])
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    private final T moveCursorPrev() {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            androidx.compose.foundation.text.selection.TextPreparedSelectionState r2 = r6.getState()
            r2.resetCachedX()
            java.lang.String r2 = r6.getText$foundation_release()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0019
            r2 = 1
            goto L_0x001a
        L_0x0019:
            r2 = 0
        L_0x001a:
            if (r2 == 0) goto L_0x002c
            r2 = r6
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r2 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r2
            r3 = 0
            int r4 = r2.getPrecedingCharacterIndex()
            r5 = -1
            if (r4 == r5) goto L_0x002a
            r2.setCursor(r4)
        L_0x002a:
        L_0x002c:
            java.lang.String r2 = "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r2)
            r0 = r6
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.BaseTextPreparedSelection.moveCursorPrev():androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x001d: MOVE  (r2v7 '$this$moveCursorNext_u24lambda_u247' androidx.compose.foundation.text.selection.BaseTextPreparedSelection) = 
          (r6v0 'this' androidx.compose.foundation.text.selection.BaseTextPreparedSelection A[THIS])
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    private final T moveCursorNext() {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            androidx.compose.foundation.text.selection.TextPreparedSelectionState r2 = r6.getState()
            r2.resetCachedX()
            java.lang.String r2 = r6.getText$foundation_release()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0019
            r2 = 1
            goto L_0x001a
        L_0x0019:
            r2 = 0
        L_0x001a:
            if (r2 == 0) goto L_0x002c
            r2 = r6
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r2 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r2
            r3 = 0
            int r4 = r2.getNextCharacterIndex()
            r5 = -1
            if (r4 == r5) goto L_0x002a
            r2.setCursor(r4)
        L_0x002a:
        L_0x002c:
            java.lang.String r2 = "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r2)
            r0 = r6
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.BaseTextPreparedSelection.moveCursorNext():androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
    }

    public final T moveCursorToHome() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            setCursor(0);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorToEnd() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection $this$moveCursorToEnd_u24lambda_u249 = this;
            $this$moveCursorToEnd_u24lambda_u249.setCursor($this$moveCursorToEnd_u24lambda_u249.getText$foundation_release().length());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorLeftByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection $this$moveCursorLeftByWord_u24lambda_u2410 = this;
            if ($this$moveCursorLeftByWord_u24lambda_u2410.isLtr()) {
                $this$moveCursorLeftByWord_u24lambda_u2410.moveCursorPrevByWord();
            } else {
                $this$moveCursorLeftByWord_u24lambda_u2410.moveCursorNextByWord();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorRightByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection $this$moveCursorRightByWord_u24lambda_u2411 = this;
            if ($this$moveCursorRightByWord_u24lambda_u2411.isLtr()) {
                $this$moveCursorRightByWord_u24lambda_u2411.moveCursorNextByWord();
            } else {
                $this$moveCursorRightByWord_u24lambda_u2411.moveCursorPrevByWord();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final Integer getNextWordOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getNextWordOffsetForLayout$default(this, textLayoutResult, 0, 1, (Object) null));
        }
        return null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x001d: MOVE  (r2v7 '$this$moveCursorNextByWord_u24lambda_u2413' androidx.compose.foundation.text.selection.BaseTextPreparedSelection) = 
          (r6v0 'this' androidx.compose.foundation.text.selection.BaseTextPreparedSelection A[THIS])
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    private final T moveCursorNextByWord() {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            androidx.compose.foundation.text.selection.TextPreparedSelectionState r2 = r6.getState()
            r2.resetCachedX()
            java.lang.String r2 = r6.getText$foundation_release()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0019
            r2 = 1
            goto L_0x001a
        L_0x0019:
            r2 = 0
        L_0x001a:
            if (r2 == 0) goto L_0x0032
            r2 = r6
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r2 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r2
            r3 = 0
            java.lang.Integer r4 = r2.getNextWordOffset()
            if (r4 == 0) goto L_0x0030
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r5 = 0
            r2.setCursor(r4)
        L_0x0030:
        L_0x0032:
            java.lang.String r2 = "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r2)
            r0 = r6
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.BaseTextPreparedSelection.moveCursorNextByWord():androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
    }

    public final Integer getPreviousWordOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getPrevWordOffset$default(this, textLayoutResult, 0, 1, (Object) null));
        }
        return null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x001d: MOVE  (r2v7 '$this$moveCursorPrevByWord_u24lambda_u2415' androidx.compose.foundation.text.selection.BaseTextPreparedSelection) = 
          (r6v0 'this' androidx.compose.foundation.text.selection.BaseTextPreparedSelection A[THIS])
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    private final T moveCursorPrevByWord() {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            androidx.compose.foundation.text.selection.TextPreparedSelectionState r2 = r6.getState()
            r2.resetCachedX()
            java.lang.String r2 = r6.getText$foundation_release()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0019
            r2 = 1
            goto L_0x001a
        L_0x0019:
            r2 = 0
        L_0x001a:
            if (r2 == 0) goto L_0x0032
            r2 = r6
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r2 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r2
            r3 = 0
            java.lang.Integer r4 = r2.getPreviousWordOffset()
            if (r4 == 0) goto L_0x0030
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r5 = 0
            r2.setCursor(r4)
        L_0x0030:
        L_0x0032:
            java.lang.String r2 = "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r2)
            r0 = r6
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.BaseTextPreparedSelection.moveCursorPrevByWord():androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
    }

    public final T moveCursorPrevByParagraph() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection $this$moveCursorPrevByParagraph_u24lambda_u2416 = this;
            $this$moveCursorPrevByParagraph_u24lambda_u2416.setCursor($this$moveCursorPrevByParagraph_u24lambda_u2416.getParagraphStart());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorNextByParagraph() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection $this$moveCursorNextByParagraph_u24lambda_u2417 = this;
            $this$moveCursorNextByParagraph_u24lambda_u2417.setCursor($this$moveCursorNextByParagraph_u24lambda_u2417.getParagraphEnd());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0017: MOVE  (r4v6 '$this$moveCursorUpByLine_u24lambda_u2419' androidx.compose.foundation.text.selection.BaseTextPreparedSelection) = 
          (r1v0 'this' androidx.compose.foundation.text.selection.BaseTextPreparedSelection A[D('$this$apply$iv' java.lang.Object), THIS])
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final T moveCursorUpByLine() {
        /*
            r8 = this;
            r0 = 0
            r1 = r8
            r2 = r8
            r3 = 0
            java.lang.String r4 = r2.getText$foundation_release()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x0013
            r4 = 1
            goto L_0x0014
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 == 0) goto L_0x0029
            r4 = r1
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r4 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r4
            r5 = 0
            androidx.compose.ui.text.TextLayoutResult r6 = r4.layoutResult
            if (r6 == 0) goto L_0x0027
            r7 = -1
            int r6 = r4.jumpByLinesOffset(r6, r7)
            r7 = 0
            r4.setCursor(r6)
        L_0x0027:
        L_0x0029:
            java.lang.String r4 = "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r4)
            r0 = r1
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.BaseTextPreparedSelection.moveCursorUpByLine():androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0018: MOVE  (r4v6 '$this$moveCursorDownByLine_u24lambda_u2421' androidx.compose.foundation.text.selection.BaseTextPreparedSelection) = 
          (r1v0 'this' androidx.compose.foundation.text.selection.BaseTextPreparedSelection A[D('$this$apply$iv' java.lang.Object), THIS])
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final T moveCursorDownByLine() {
        /*
            r8 = this;
            r0 = 0
            r1 = r8
            r2 = r8
            r3 = 0
            java.lang.String r4 = r2.getText$foundation_release()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            r5 = 1
            if (r4 <= 0) goto L_0x0014
            r4 = r5
            goto L_0x0015
        L_0x0014:
            r4 = 0
        L_0x0015:
            if (r4 == 0) goto L_0x0029
            r4 = r1
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r4 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r4
            r6 = 0
            androidx.compose.ui.text.TextLayoutResult r7 = r4.layoutResult
            if (r7 == 0) goto L_0x0027
            int r5 = r4.jumpByLinesOffset(r7, r5)
            r7 = 0
            r4.setCursor(r5)
        L_0x0027:
        L_0x0029:
            java.lang.String r4 = "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r4)
            r0 = r1
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.BaseTextPreparedSelection.moveCursorDownByLine():androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
    }

    public final Integer getLineStartByOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getLineStartByOffsetForLayout$default(this, textLayoutResult, 0, 1, (Object) null));
        }
        return null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x001d: MOVE  (r2v7 '$this$moveCursorToLineStart_u24lambda_u2423' androidx.compose.foundation.text.selection.BaseTextPreparedSelection) = 
          (r6v0 'this' androidx.compose.foundation.text.selection.BaseTextPreparedSelection A[THIS])
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final T moveCursorToLineStart() {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            androidx.compose.foundation.text.selection.TextPreparedSelectionState r2 = r6.getState()
            r2.resetCachedX()
            java.lang.String r2 = r6.getText$foundation_release()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0019
            r2 = 1
            goto L_0x001a
        L_0x0019:
            r2 = 0
        L_0x001a:
            if (r2 == 0) goto L_0x0032
            r2 = r6
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r2 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r2
            r3 = 0
            java.lang.Integer r4 = r2.getLineStartByOffset()
            if (r4 == 0) goto L_0x0030
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r5 = 0
            r2.setCursor(r4)
        L_0x0030:
        L_0x0032:
            java.lang.String r2 = "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r2)
            r0 = r6
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.BaseTextPreparedSelection.moveCursorToLineStart():androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
    }

    public final Integer getLineEndByOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getLineEndByOffsetForLayout$default(this, textLayoutResult, 0, 1, (Object) null));
        }
        return null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x001d: MOVE  (r2v7 '$this$moveCursorToLineEnd_u24lambda_u2425' androidx.compose.foundation.text.selection.BaseTextPreparedSelection) = 
          (r6v0 'this' androidx.compose.foundation.text.selection.BaseTextPreparedSelection A[THIS])
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final T moveCursorToLineEnd() {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            androidx.compose.foundation.text.selection.TextPreparedSelectionState r2 = r6.getState()
            r2.resetCachedX()
            java.lang.String r2 = r6.getText$foundation_release()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0019
            r2 = 1
            goto L_0x001a
        L_0x0019:
            r2 = 0
        L_0x001a:
            if (r2 == 0) goto L_0x0032
            r2 = r6
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r2 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r2
            r3 = 0
            java.lang.Integer r4 = r2.getLineEndByOffset()
            if (r4 == 0) goto L_0x0030
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r5 = 0
            r2.setCursor(r4)
        L_0x0030:
        L_0x0032:
            java.lang.String r2 = "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r2)
            r0 = r6
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.BaseTextPreparedSelection.moveCursorToLineEnd():androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
    }

    public final T moveCursorToLineLeftSide() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection $this$moveCursorToLineLeftSide_u24lambda_u2426 = this;
            if ($this$moveCursorToLineLeftSide_u24lambda_u2426.isLtr()) {
                $this$moveCursorToLineLeftSide_u24lambda_u2426.moveCursorToLineStart();
            } else {
                $this$moveCursorToLineLeftSide_u24lambda_u2426.moveCursorToLineEnd();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorToLineRightSide() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection $this$moveCursorToLineRightSide_u24lambda_u2427 = this;
            if ($this$moveCursorToLineRightSide_u24lambda_u2427.isLtr()) {
                $this$moveCursorToLineRightSide_u24lambda_u2427.moveCursorToLineEnd();
            } else {
                $this$moveCursorToLineRightSide_u24lambda_u2427.moveCursorToLineStart();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T selectMovement() {
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection $this$selectMovement_u24lambda_u2428 = this;
            $this$selectMovement_u24lambda_u2428.selection = TextRangeKt.TextRange(TextRange.m5474getStartimpl($this$selectMovement_u24lambda_u2428.originalSelection), TextRange.m5469getEndimpl($this$selectMovement_u24lambda_u2428.selection));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final boolean isLtr() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        return (textLayoutResult != null ? textLayoutResult.getParagraphDirection(transformedEndOffset()) : null) != ResolvedTextDirection.Rtl;
    }

    static /* synthetic */ int getNextWordOffsetForLayout$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = baseTextPreparedSelection.transformedEndOffset();
            }
            return baseTextPreparedSelection.getNextWordOffsetForLayout(textLayoutResult, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNextWordOffsetForLayout");
    }

    private final int getNextWordOffsetForLayout(TextLayoutResult $this$getNextWordOffsetForLayout, int currentOffset) {
        while (currentOffset < this.originalText.length()) {
            long currentWord = $this$getNextWordOffsetForLayout.m5448getWordBoundaryjx7JFs(charOffset(currentOffset));
            if (TextRange.m5469getEndimpl(currentWord) > currentOffset) {
                return this.offsetMapping.transformedToOriginal(TextRange.m5469getEndimpl(currentWord));
            }
            currentOffset++;
        }
        return this.originalText.length();
    }

    static /* synthetic */ int getPrevWordOffset$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = baseTextPreparedSelection.transformedEndOffset();
            }
            return baseTextPreparedSelection.getPrevWordOffset(textLayoutResult, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrevWordOffset");
    }

    private final int getPrevWordOffset(TextLayoutResult $this$getPrevWordOffset, int currentOffset) {
        while (currentOffset > 0) {
            long currentWord = $this$getPrevWordOffset.m5448getWordBoundaryjx7JFs(charOffset(currentOffset));
            if (TextRange.m5474getStartimpl(currentWord) < currentOffset) {
                return this.offsetMapping.transformedToOriginal(TextRange.m5474getStartimpl(currentWord));
            }
            currentOffset--;
        }
        return 0;
    }

    static /* synthetic */ int getLineStartByOffsetForLayout$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = baseTextPreparedSelection.transformedMinOffset();
            }
            return baseTextPreparedSelection.getLineStartByOffsetForLayout(textLayoutResult, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineStartByOffsetForLayout");
    }

    private final int getLineStartByOffsetForLayout(TextLayoutResult $this$getLineStartByOffsetForLayout, int currentOffset) {
        return this.offsetMapping.transformedToOriginal($this$getLineStartByOffsetForLayout.getLineStart($this$getLineStartByOffsetForLayout.getLineForOffset(currentOffset)));
    }

    static /* synthetic */ int getLineEndByOffsetForLayout$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = baseTextPreparedSelection.transformedMaxOffset();
            }
            return baseTextPreparedSelection.getLineEndByOffsetForLayout(textLayoutResult, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineEndByOffsetForLayout");
    }

    private final int getLineEndByOffsetForLayout(TextLayoutResult $this$getLineEndByOffsetForLayout, int currentOffset) {
        return this.offsetMapping.transformedToOriginal($this$getLineEndByOffsetForLayout.getLineEnd($this$getLineEndByOffsetForLayout.getLineForOffset(currentOffset), true));
    }

    private final int jumpByLinesOffset(TextLayoutResult $this$jumpByLinesOffset, int linesAmount) {
        int currentOffset = transformedEndOffset();
        if (this.state.getCachedX() == null) {
            this.state.setCachedX(Float.valueOf($this$jumpByLinesOffset.getCursorRect(currentOffset).getLeft()));
        }
        int targetLine = $this$jumpByLinesOffset.getLineForOffset(currentOffset) + linesAmount;
        if (targetLine < 0) {
            return 0;
        }
        if (targetLine >= $this$jumpByLinesOffset.getLineCount()) {
            return getText$foundation_release().length();
        }
        float y = $this$jumpByLinesOffset.getLineBottom(targetLine) - ((float) 1);
        Float cachedX = this.state.getCachedX();
        Intrinsics.checkNotNull(cachedX);
        Number number = cachedX;
        float it = number.floatValue();
        if ((isLtr() && it >= $this$jumpByLinesOffset.getLineRight(targetLine)) || (!isLtr() && it <= $this$jumpByLinesOffset.getLineLeft(targetLine))) {
            return $this$jumpByLinesOffset.getLineEnd(targetLine, true);
        }
        return this.offsetMapping.transformedToOriginal($this$jumpByLinesOffset.m5446getOffsetForPositionk4lQ0M(OffsetKt.Offset(number.floatValue(), y)));
    }

    private final int transformedEndOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m5469getEndimpl(this.selection));
    }

    private final int transformedMinOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m5472getMinimpl(this.selection));
    }

    private final int transformedMaxOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m5471getMaximpl(this.selection));
    }

    private final int charOffset(int offset) {
        return RangesKt.coerceAtMost(offset, getText$foundation_release().length() - 1);
    }

    private final int getParagraphStart() {
        return StringHelpersKt.findParagraphStart(getText$foundation_release(), TextRange.m5472getMinimpl(this.selection));
    }

    private final int getParagraphEnd() {
        return StringHelpersKt.findParagraphEnd(getText$foundation_release(), TextRange.m5471getMaximpl(this.selection));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection$Companion;", "", "()V", "NoCharacterFound", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextPreparedSelection.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
