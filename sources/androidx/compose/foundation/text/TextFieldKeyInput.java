package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\b\u0000\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\u0010\u0018J!\u0010(\u001a\u00020\u00172\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b+H\u0002J\u001b\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020.ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100J\u001f\u00101\u001a\u0004\u0018\u0001022\u0006\u0010-\u001a\u00020.H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104J\f\u00105\u001a\u00020\u0017*\u000206H\u0002J\u0012\u00105\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020607H\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00068"}, d2 = {"Landroidx/compose/foundation/text/TextFieldKeyInput;", "", "state", "Landroidx/compose/foundation/text/TextFieldState;", "selectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "editable", "", "singleLine", "preparedSelectionState", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "keyCombiner", "Landroidx/compose/foundation/text/DeadKeyCombiner;", "keyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "onValueChange", "Lkotlin/Function1;", "", "(Landroidx/compose/foundation/text/TextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/ui/text/input/TextFieldValue;ZZLandroidx/compose/foundation/text/selection/TextPreparedSelectionState;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/UndoManager;Landroidx/compose/foundation/text/DeadKeyCombiner;Landroidx/compose/foundation/text/KeyMapping;Lkotlin/jvm/functions/Function1;)V", "getEditable", "()Z", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "getPreparedSelectionState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "getSelectionManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "getSingleLine", "getState", "()Landroidx/compose/foundation/text/TextFieldState;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "getValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "commandExecutionContext", "block", "Landroidx/compose/foundation/text/selection/TextFieldPreparedSelection;", "Lkotlin/ExtensionFunctionType;", "process", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "process-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "typedCommand", "Landroidx/compose/ui/text/input/CommitTextCommand;", "typedCommand-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/text/input/CommitTextCommand;", "apply", "Landroidx/compose/ui/text/input/EditCommand;", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldKeyInput.kt */
public final class TextFieldKeyInput {
    private final boolean editable;
    private final DeadKeyCombiner keyCombiner;
    private final KeyMapping keyMapping;
    private final OffsetMapping offsetMapping;
    /* access modifiers changed from: private */
    public final Function1<TextFieldValue, Unit> onValueChange;
    private final TextPreparedSelectionState preparedSelectionState;
    private final TextFieldSelectionManager selectionManager;
    private final boolean singleLine;
    private final TextFieldState state;
    private final UndoManager undoManager;
    private final TextFieldValue value;

    public TextFieldKeyInput(TextFieldState state2, TextFieldSelectionManager selectionManager2, TextFieldValue value2, boolean editable2, boolean singleLine2, TextPreparedSelectionState preparedSelectionState2, OffsetMapping offsetMapping2, UndoManager undoManager2, DeadKeyCombiner keyCombiner2, KeyMapping keyMapping2, Function1<? super TextFieldValue, Unit> onValueChange2) {
        Intrinsics.checkNotNullParameter(state2, "state");
        Intrinsics.checkNotNullParameter(selectionManager2, "selectionManager");
        Intrinsics.checkNotNullParameter(value2, "value");
        Intrinsics.checkNotNullParameter(preparedSelectionState2, "preparedSelectionState");
        Intrinsics.checkNotNullParameter(offsetMapping2, "offsetMapping");
        Intrinsics.checkNotNullParameter(keyCombiner2, "keyCombiner");
        Intrinsics.checkNotNullParameter(keyMapping2, "keyMapping");
        Intrinsics.checkNotNullParameter(onValueChange2, "onValueChange");
        this.state = state2;
        this.selectionManager = selectionManager2;
        this.value = value2;
        this.editable = editable2;
        this.singleLine = singleLine2;
        this.preparedSelectionState = preparedSelectionState2;
        this.offsetMapping = offsetMapping2;
        this.undoManager = undoManager2;
        this.keyCombiner = keyCombiner2;
        this.keyMapping = keyMapping2;
        this.onValueChange = onValueChange2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextFieldKeyInput(androidx.compose.foundation.text.TextFieldState r22, androidx.compose.foundation.text.selection.TextFieldSelectionManager r23, androidx.compose.ui.text.input.TextFieldValue r24, boolean r25, boolean r26, androidx.compose.foundation.text.selection.TextPreparedSelectionState r27, androidx.compose.ui.text.input.OffsetMapping r28, androidx.compose.foundation.text.UndoManager r29, androidx.compose.foundation.text.DeadKeyCombiner r30, androidx.compose.foundation.text.KeyMapping r31, kotlin.jvm.functions.Function1 r32, int r33, kotlin.jvm.internal.DefaultConstructorMarker r34) {
        /*
            r21 = this;
            r0 = r33
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0014
            androidx.compose.ui.text.input.TextFieldValue r1 = new androidx.compose.ui.text.input.TextFieldValue
            r3 = 0
            r4 = 0
            r6 = 0
            r7 = 7
            r8 = 0
            r2 = r1
            r2.<init>((java.lang.String) r3, (long) r4, (androidx.compose.ui.text.TextRange) r6, (int) r7, (kotlin.jvm.internal.DefaultConstructorMarker) r8)
            r12 = r1
            goto L_0x0016
        L_0x0014:
            r12 = r24
        L_0x0016:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x001d
            r1 = 1
            r13 = r1
            goto L_0x001f
        L_0x001d:
            r13 = r25
        L_0x001f:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0026
            r1 = 0
            r14 = r1
            goto L_0x0028
        L_0x0026:
            r14 = r26
        L_0x0028:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0035
            androidx.compose.ui.text.input.OffsetMapping$Companion r1 = androidx.compose.ui.text.input.OffsetMapping.Companion
            androidx.compose.ui.text.input.OffsetMapping r1 = r1.getIdentity()
            r16 = r1
            goto L_0x0037
        L_0x0035:
            r16 = r28
        L_0x0037:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x003f
            r1 = 0
            r17 = r1
            goto L_0x0041
        L_0x003f:
            r17 = r29
        L_0x0041:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x004c
            androidx.compose.foundation.text.KeyMapping r1 = androidx.compose.foundation.text.KeyMapping_androidKt.getPlatformDefaultKeyMapping()
            r19 = r1
            goto L_0x004e
        L_0x004c:
            r19 = r31
        L_0x004e:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0059
            androidx.compose.foundation.text.TextFieldKeyInput$1 r0 = androidx.compose.foundation.text.TextFieldKeyInput.AnonymousClass1.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r20 = r0
            goto L_0x005b
        L_0x0059:
            r20 = r32
        L_0x005b:
            r9 = r21
            r10 = r22
            r11 = r23
            r15 = r27
            r18 = r30
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldKeyInput.<init>(androidx.compose.foundation.text.TextFieldState, androidx.compose.foundation.text.selection.TextFieldSelectionManager, androidx.compose.ui.text.input.TextFieldValue, boolean, boolean, androidx.compose.foundation.text.selection.TextPreparedSelectionState, androidx.compose.ui.text.input.OffsetMapping, androidx.compose.foundation.text.UndoManager, androidx.compose.foundation.text.DeadKeyCombiner, androidx.compose.foundation.text.KeyMapping, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final TextFieldState getState() {
        return this.state;
    }

    public final TextFieldSelectionManager getSelectionManager() {
        return this.selectionManager;
    }

    public final TextFieldValue getValue() {
        return this.value;
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final TextPreparedSelectionState getPreparedSelectionState() {
        return this.preparedSelectionState;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    /* access modifiers changed from: private */
    public final void apply(List<? extends EditCommand> $this$apply) {
        EditProcessor processor = this.state.getProcessor();
        List $this$apply_u24lambda_u240 = CollectionsKt.toMutableList($this$apply);
        $this$apply_u24lambda_u240.add(0, new FinishComposingTextCommand());
        this.onValueChange.invoke(processor.apply($this$apply_u24lambda_u240));
    }

    /* access modifiers changed from: private */
    public final void apply(EditCommand $this$apply) {
        apply((List<? extends EditCommand>) CollectionsKt.listOf($this$apply));
    }

    /* renamed from: typedCommand-ZmokQxo  reason: not valid java name */
    private final CommitTextCommand m1212typedCommandZmokQxo(KeyEvent event) {
        Integer r0;
        if (!TextFieldKeyInput_androidKt.m1215isTypedEventZmokQxo(event) || (r0 = this.keyCombiner.m1146consumeZmokQxo(event)) == null) {
            return null;
        }
        String text = StringHelpers_jvmKt.appendCodePointX(new StringBuilder(), r0.intValue()).toString();
        Intrinsics.checkNotNullExpressionValue(text, "StringBuilder().appendCo…ntX(codePoint).toString()");
        return new CommitTextCommand(text, 1);
    }

    /* renamed from: process-ZmokQxo  reason: not valid java name */
    public final boolean m1213processZmokQxo(KeyEvent event) {
        KeyCommand command;
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        CommitTextCommand it = m1212typedCommandZmokQxo(event);
        if (it != null) {
            if (!this.editable) {
                return false;
            }
            apply((EditCommand) it);
            this.preparedSelectionState.resetCachedX();
            return true;
        } else if (!KeyEventType.m4517equalsimpl0(KeyEvent_androidKt.m4525getTypeZmokQxo(event), KeyEventType.Companion.m4521getKeyDownCS__XNY()) || (command = this.keyMapping.m1149mapZmokQxo(event)) == null || (command.getEditsText() && !this.editable)) {
            return false;
        } else {
            Ref.BooleanRef consumed = new Ref.BooleanRef();
            consumed.element = true;
            commandExecutionContext(new TextFieldKeyInput$process$2(command, this, consumed));
            UndoManager undoManager2 = this.undoManager;
            if (undoManager2 != null) {
                undoManager2.forceNextSnapshot();
            }
            return consumed.element;
        }
    }

    private final void commandExecutionContext(Function1<? super TextFieldPreparedSelection, Unit> block) {
        TextFieldPreparedSelection preparedSelection = new TextFieldPreparedSelection(this.value, this.offsetMapping, this.state.getLayoutResult(), this.preparedSelectionState);
        block.invoke(preparedSelection);
        if (!TextRange.m5467equalsimpl0(preparedSelection.m1244getSelectiond9O1mEE(), this.value.m5695getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) preparedSelection.getAnnotatedString(), (Object) this.value.getAnnotatedString())) {
            this.onValueChange.invoke(preparedSelection.getValue());
        }
    }
}
