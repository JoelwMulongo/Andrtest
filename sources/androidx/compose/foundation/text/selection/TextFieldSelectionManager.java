package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010e\u001a\u00020B2\u0006\u0010f\u001a\u00020\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bg\u0010hJ\u0017\u0010i\u001a\u00020B2\b\b\u0002\u0010j\u001a\u00020!H\u0000¢\u0006\u0002\bkJ%\u0010l\u001a\u00020?2\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020pH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bq\u0010rJ\r\u0010s\u001a\u00020TH\u0000¢\u0006\u0002\btJ\r\u0010u\u001a\u00020BH\u0000¢\u0006\u0002\bvJ\u001f\u0010w\u001a\u00020B2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\fH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\bxJ\r\u0010y\u001a\u00020BH\u0000¢\u0006\u0002\bzJ\r\u0010{\u001a\u00020BH\u0000¢\u0006\u0002\b|J\b\u0010}\u001a\u00020~H\u0002J$\u0010\u001a\u00020\f2\b\u0010\u0001\u001a\u00030\u0001H\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J$\u0010\u0001\u001a\u00020\f2\u0007\u0010\u0001\u001a\u00020!H\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0018\u0010\u0001\u001a\u00020T2\u0007\u0010\u0001\u001a\u00020!H\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020!H\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u0001J\u0013\u0010\u0001\u001a\u00020B2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u000f\u0010\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u0001J6\u0010\u0001\u001a\u00020B2\u0006\u0010Y\u001a\u00020?2\u0007\u0010\u0001\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030\u0001H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR8\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8F@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0019\u0010\u0017\u001a\u00020\fX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0018R\u0019\u0010\u0019\u001a\u00020\fX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0018R/\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001a8F@BX\u0002¢\u0006\u0012\n\u0004\b \u0010\u0013\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR+\u0010\"\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!8F@FX\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0013\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00104\u001a\u000205X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001a\u00108\u001a\u000209X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020?X\u000e¢\u0006\u0002\n\u0000R&\u0010@\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020B0AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010HX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010M\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020TX\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR+\u0010Y\u001a\u00020?2\u0006\u0010\u000b\u001a\u00020?8@@@X\u0002¢\u0006\u0012\n\u0004\b^\u0010\u0013\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010_\u001a\u00020`X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010d\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "(Landroidx/compose/foundation/text/UndoManager;)V", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager$foundation_release", "()Landroidx/compose/ui/platform/ClipboardManager;", "setClipboardManager$foundation_release", "(Landroidx/compose/ui/platform/ClipboardManager;)V", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "Landroidx/compose/runtime/MutableState;", "dragBeginOffsetInText", "", "Ljava/lang/Integer;", "dragBeginPosition", "J", "dragTotalDistance", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "", "editable", "getEditable", "()Z", "setEditable", "(Z)V", "editable$delegate", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getMouseSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping$foundation_release", "()Landroidx/compose/ui/text/input/OffsetMapping;", "setOffsetMapping$foundation_release", "(Landroidx/compose/ui/text/input/OffsetMapping;)V", "oldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "", "getOnValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "state", "Landroidx/compose/foundation/text/TextFieldState;", "getState$foundation_release", "()Landroidx/compose/foundation/text/TextFieldState;", "setState$foundation_release", "(Landroidx/compose/foundation/text/TextFieldState;)V", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "touchSelectionObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getTouchSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/TextDragObserver;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "value", "getValue$foundation_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue$foundation_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "value$delegate", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation$foundation_release", "()Landroidx/compose/ui/text/input/VisualTransformation;", "setVisualTransformation$foundation_release", "(Landroidx/compose/ui/text/input/VisualTransformation;)V", "contextMenuOpenAdjustment", "position", "contextMenuOpenAdjustment-k-4lQ0M", "(J)V", "copy", "cancelSelection", "copy$foundation_release", "createTextFieldValue", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "selection", "Landroidx/compose/ui/text/TextRange;", "createTextFieldValue-FDrldGo", "(Landroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/input/TextFieldValue;", "cursorDragObserver", "cursorDragObserver$foundation_release", "cut", "cut$foundation_release", "deselect", "deselect-_kEHs6E$foundation_release", "enterSelectionMode", "enterSelectionMode$foundation_release", "exitSelectionMode", "exitSelectionMode$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getCursorPosition", "density", "Landroidx/compose/ui/unit/Density;", "getCursorPosition-tuRUvjQ$foundation_release", "(Landroidx/compose/ui/unit/Density;)J", "getHandlePosition", "isStartHandle", "getHandlePosition-tuRUvjQ$foundation_release", "(Z)J", "handleDragObserver", "handleDragObserver$foundation_release", "hideSelectionToolbar", "hideSelectionToolbar$foundation_release", "isTextChanged", "isTextChanged$foundation_release", "paste", "paste$foundation_release", "selectAll", "selectAll$foundation_release", "setHandleState", "handleState", "Landroidx/compose/foundation/text/HandleState;", "showSelectionToolbar", "showSelectionToolbar$foundation_release", "updateSelection", "transformedStartOffset", "transformedEndOffset", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.kt */
public final class TextFieldSelectionManager {
    private ClipboardManager clipboardManager;
    private final MutableState currentDragPosition$delegate;
    /* access modifiers changed from: private */
    public Integer dragBeginOffsetInText;
    /* access modifiers changed from: private */
    public long dragBeginPosition;
    /* access modifiers changed from: private */
    public long dragTotalDistance;
    private final MutableState draggingHandle$delegate;
    private final MutableState editable$delegate;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private final MouseSelectionObserver mouseSelectionObserver;
    private OffsetMapping offsetMapping;
    private TextFieldValue oldValue;
    private Function1<? super TextFieldValue, Unit> onValueChange;
    private TextFieldState state;
    private TextToolbar textToolbar;
    private final TextDragObserver touchSelectionObserver;
    private final UndoManager undoManager;
    private final MutableState value$delegate;
    private VisualTransformation visualTransformation;

    public TextFieldSelectionManager() {
        this((UndoManager) null, 1, (DefaultConstructorMarker) null);
    }

    public TextFieldSelectionManager(UndoManager undoManager2) {
        this.undoManager = undoManager2;
        this.offsetMapping = ValidatingOffsetMappingKt.getValidatingEmptyOffsetMappingIdentity();
        this.onValueChange = TextFieldSelectionManager$onValueChange$1.INSTANCE;
        this.value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0, (TextRange) null, 7, (DefaultConstructorMarker) null), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.visualTransformation = VisualTransformation.Companion.getNone();
        this.editable$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.dragBeginPosition = Offset.Companion.m2931getZeroF1C5BW0();
        this.dragTotalDistance = Offset.Companion.m2931getZeroF1C5BW0();
        this.draggingHandle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.currentDragPosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.oldValue = new TextFieldValue((String) null, 0, (TextRange) null, 7, (DefaultConstructorMarker) null);
        this.touchSelectionObserver = new TextFieldSelectionManager$touchSelectionObserver$1(this);
        this.mouseSelectionObserver = new TextFieldSelectionManager$mouseSelectionObserver$1(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldSelectionManager(UndoManager undoManager2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : undoManager2);
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    public final OffsetMapping getOffsetMapping$foundation_release() {
        return this.offsetMapping;
    }

    public final void setOffsetMapping$foundation_release(OffsetMapping offsetMapping2) {
        Intrinsics.checkNotNullParameter(offsetMapping2, "<set-?>");
        this.offsetMapping = offsetMapping2;
    }

    public final Function1<TextFieldValue, Unit> getOnValueChange$foundation_release() {
        return this.onValueChange;
    }

    public final void setOnValueChange$foundation_release(Function1<? super TextFieldValue, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onValueChange = function1;
    }

    public final TextFieldState getState$foundation_release() {
        return this.state;
    }

    public final void setState$foundation_release(TextFieldState textFieldState) {
        this.state = textFieldState;
    }

    public final TextFieldValue getValue$foundation_release() {
        return (TextFieldValue) this.value$delegate.getValue();
    }

    public final void setValue$foundation_release(TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(textFieldValue, "<set-?>");
        this.value$delegate.setValue(textFieldValue);
    }

    public final VisualTransformation getVisualTransformation$foundation_release() {
        return this.visualTransformation;
    }

    public final void setVisualTransformation$foundation_release(VisualTransformation visualTransformation2) {
        Intrinsics.checkNotNullParameter(visualTransformation2, "<set-?>");
        this.visualTransformation = visualTransformation2;
    }

    public final ClipboardManager getClipboardManager$foundation_release() {
        return this.clipboardManager;
    }

    public final void setClipboardManager$foundation_release(ClipboardManager clipboardManager2) {
        this.clipboardManager = clipboardManager2;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final void setTextToolbar(TextToolbar textToolbar2) {
        this.textToolbar = textToolbar2;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final void setFocusRequester(FocusRequester focusRequester2) {
        this.focusRequester = focusRequester2;
    }

    public final boolean getEditable() {
        return ((Boolean) this.editable$delegate.getValue()).booleanValue();
    }

    public final void setEditable(boolean z) {
        this.editable$delegate.setValue(Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle$delegate.setValue(handle);
    }

    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: setCurrentDragPosition-_kEHs6E  reason: not valid java name */
    public final void m1334setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition$delegate.setValue(offset);
    }

    /* renamed from: getCurrentDragPosition-_m7T9-E  reason: not valid java name */
    public final Offset m1337getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition$delegate.getValue();
    }

    public final TextDragObserver getTouchSelectionObserver$foundation_release() {
        return this.touchSelectionObserver;
    }

    public final MouseSelectionObserver getMouseSelectionObserver$foundation_release() {
        return this.mouseSelectionObserver;
    }

    public final TextDragObserver handleDragObserver$foundation_release(boolean isStartHandle) {
        return new TextFieldSelectionManager$handleDragObserver$1(this, isStartHandle);
    }

    public final TextDragObserver cursorDragObserver$foundation_release() {
        return new TextFieldSelectionManager$cursorDragObserver$1(this);
    }

    public final void enterSelectionMode$foundation_release() {
        FocusRequester focusRequester2;
        TextFieldState textFieldState = this.state;
        boolean z = false;
        if (textFieldState != null && !textFieldState.getHasFocus()) {
            z = true;
        }
        if (z && (focusRequester2 = this.focusRequester) != null) {
            focusRequester2.requestFocus();
        }
        this.oldValue = getValue$foundation_release();
        TextFieldState textFieldState2 = this.state;
        if (textFieldState2 != null) {
            textFieldState2.setShowFloatingToolbar(true);
        }
        setHandleState(HandleState.Selection);
    }

    public final void exitSelectionMode$foundation_release() {
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            textFieldState.setShowFloatingToolbar(false);
        }
        setHandleState(HandleState.None);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release$default  reason: not valid java name */
    public static /* synthetic */ void m1333deselect_kEHs6E$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, Offset offset, int i, Object obj) {
        if ((i & 1) != 0) {
            offset = null;
        }
        textFieldSelectionManager.m1336deselect_kEHs6E$foundation_release(offset);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release  reason: not valid java name */
    public final void m1336deselect_kEHs6E$foundation_release(Offset position) {
        HandleState selectionMode;
        int newCursorOffset;
        if (!TextRange.m5468getCollapsedimpl(getValue$foundation_release().m5695getSelectiond9O1mEE())) {
            TextFieldState textFieldState = this.state;
            TextLayoutResultProxy layoutResult = textFieldState != null ? textFieldState.getLayoutResult() : null;
            if (position == null || layoutResult == null) {
                newCursorOffset = TextRange.m5471getMaximpl(getValue$foundation_release().m5695getSelectiond9O1mEE());
            } else {
                newCursorOffset = this.offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1230getOffsetForPosition3MmeM6k$default(layoutResult, position.m2925unboximpl(), false, 2, (Object) null));
            }
            this.onValueChange.invoke(TextFieldValue.m5690copy3r_uNRQ$default(getValue$foundation_release(), (AnnotatedString) null, TextRangeKt.TextRange(newCursorOffset), (TextRange) null, 5, (Object) null));
        }
        if (position != null) {
            if (getValue$foundation_release().getText().length() > 0) {
                selectionMode = HandleState.Cursor;
                setHandleState(selectionMode);
                hideSelectionToolbar$foundation_release();
            }
        }
        selectionMode = HandleState.None;
        setHandleState(selectionMode);
        hideSelectionToolbar$foundation_release();
    }

    public static /* synthetic */ void copy$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionManager.copy$foundation_release(z);
    }

    public final void copy$foundation_release(boolean cancelSelection) {
        if (!TextRange.m5468getCollapsedimpl(getValue$foundation_release().m5695getSelectiond9O1mEE())) {
            ClipboardManager clipboardManager2 = this.clipboardManager;
            if (clipboardManager2 != null) {
                clipboardManager2.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
            }
            if (cancelSelection) {
                int newCursorOffset = TextRange.m5471getMaximpl(getValue$foundation_release().m5695getSelectiond9O1mEE());
                this.onValueChange.invoke(m1332createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(newCursorOffset, newCursorOffset)));
                setHandleState(HandleState.None);
            }
        }
    }

    public final void paste$foundation_release() {
        AnnotatedString text;
        ClipboardManager clipboardManager2 = this.clipboardManager;
        if (clipboardManager2 != null && (text = clipboardManager2.getText()) != null) {
            AnnotatedString newText = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(text).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
            int newCursorOffset = TextRange.m5472getMinimpl(getValue$foundation_release().m5695getSelectiond9O1mEE()) + text.length();
            this.onValueChange.invoke(m1332createTextFieldValueFDrldGo(newText, TextRangeKt.TextRange(newCursorOffset, newCursorOffset)));
            setHandleState(HandleState.None);
            UndoManager undoManager2 = this.undoManager;
            if (undoManager2 != null) {
                undoManager2.forceNextSnapshot();
            }
        }
    }

    public final void cut$foundation_release() {
        if (!TextRange.m5468getCollapsedimpl(getValue$foundation_release().m5695getSelectiond9O1mEE())) {
            ClipboardManager clipboardManager2 = this.clipboardManager;
            if (clipboardManager2 != null) {
                clipboardManager2.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
            }
            AnnotatedString newText = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
            int newCursorOffset = TextRange.m5472getMinimpl(getValue$foundation_release().m5695getSelectiond9O1mEE());
            this.onValueChange.invoke(m1332createTextFieldValueFDrldGo(newText, TextRangeKt.TextRange(newCursorOffset, newCursorOffset)));
            setHandleState(HandleState.None);
            UndoManager undoManager2 = this.undoManager;
            if (undoManager2 != null) {
                undoManager2.forceNextSnapshot();
            }
        }
    }

    public final void selectAll$foundation_release() {
        TextFieldValue newValue = m1332createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(0, getValue$foundation_release().getText().length()));
        this.onValueChange.invoke(newValue);
        this.oldValue = TextFieldValue.m5690copy3r_uNRQ$default(this.oldValue, (AnnotatedString) null, newValue.m5695getSelectiond9O1mEE(), (TextRange) null, 5, (Object) null);
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            textFieldState.setShowFloatingToolbar(true);
        }
    }

    /* renamed from: getHandlePosition-tuRUvjQ$foundation_release  reason: not valid java name */
    public final long m1339getHandlePositiontuRUvjQ$foundation_release(boolean isStartHandle) {
        long r0 = getValue$foundation_release().m5695getSelectiond9O1mEE();
        int offset = isStartHandle ? TextRange.m5474getStartimpl(r0) : TextRange.m5469getEndimpl(r0);
        TextFieldState textFieldState = this.state;
        TextLayoutResultProxy layoutResult = textFieldState != null ? textFieldState.getLayoutResult() : null;
        Intrinsics.checkNotNull(layoutResult);
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(layoutResult.getValue(), this.offsetMapping.originalToTransformed(offset), isStartHandle, TextRange.m5473getReversedimpl(getValue$foundation_release().m5695getSelectiond9O1mEE()));
    }

    /* renamed from: getCursorPosition-tuRUvjQ$foundation_release  reason: not valid java name */
    public final long m1338getCursorPositiontuRUvjQ$foundation_release(Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        int offset = this.offsetMapping.originalToTransformed(TextRange.m5474getStartimpl(getValue$foundation_release().m5695getSelectiond9O1mEE()));
        TextFieldState textFieldState = this.state;
        TextLayoutResultProxy layoutResult = textFieldState != null ? textFieldState.getLayoutResult() : null;
        Intrinsics.checkNotNull(layoutResult);
        TextLayoutResult layoutResult2 = layoutResult.getValue();
        Rect cursorRect = layoutResult2.getCursorRect(RangesKt.coerceIn(offset, 0, layoutResult2.getLayoutInput().getText().length()));
        return OffsetKt.Offset(cursorRect.getLeft() + (density.m5967toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness()) / ((float) 2)), cursorRect.getBottom());
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showSelectionToolbar$foundation_release() {
        /*
            r9 = this;
            androidx.compose.ui.text.input.VisualTransformation r0 = r9.visualTransformation
            boolean r0 = r0 instanceof androidx.compose.ui.text.input.PasswordVisualTransformation
            androidx.compose.ui.text.input.TextFieldValue r1 = r9.getValue$foundation_release()
            long r1 = r1.m5695getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m5468getCollapsedimpl(r1)
            r2 = 0
            if (r1 != 0) goto L_0x001e
            if (r0 != 0) goto L_0x001e
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$copy$1 r1 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$copy$1
            r1.<init>(r9)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r5 = r1
            goto L_0x001f
        L_0x001e:
            r5 = r2
        L_0x001f:
            androidx.compose.ui.text.input.TextFieldValue r1 = r9.getValue$foundation_release()
            long r3 = r1.m5695getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m5468getCollapsedimpl(r3)
            if (r1 != 0) goto L_0x003f
            boolean r1 = r9.getEditable()
            if (r1 == 0) goto L_0x003f
            if (r0 != 0) goto L_0x003f
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$cut$1 r1 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$cut$1
            r1.<init>(r9)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r7 = r1
            goto L_0x0040
        L_0x003f:
            r7 = r2
        L_0x0040:
            boolean r1 = r9.getEditable()
            if (r1 == 0) goto L_0x005f
            androidx.compose.ui.platform.ClipboardManager r1 = r9.clipboardManager
            r3 = 0
            if (r1 == 0) goto L_0x0054
            boolean r1 = r1.hasText()
            r4 = 1
            if (r1 != r4) goto L_0x0054
            r3 = r4
        L_0x0054:
            if (r3 == 0) goto L_0x005f
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$paste$1 r1 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$paste$1
            r1.<init>(r9)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r6 = r1
            goto L_0x0060
        L_0x005f:
            r6 = r2
        L_0x0060:
            androidx.compose.ui.text.input.TextFieldValue r1 = r9.getValue$foundation_release()
            long r3 = r1.m5695getSelectiond9O1mEE()
            int r1 = androidx.compose.ui.text.TextRange.m5470getLengthimpl(r3)
            androidx.compose.ui.text.input.TextFieldValue r3 = r9.getValue$foundation_release()
            java.lang.String r3 = r3.getText()
            int r3 = r3.length()
            if (r1 == r3) goto L_0x0085
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$selectAll$1 r1 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$selectAll$1
            r1.<init>(r9)
            r2 = r1
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r8 = r2
            goto L_0x0086
        L_0x0085:
            r8 = r2
        L_0x0086:
            androidx.compose.ui.platform.TextToolbar r3 = r9.textToolbar
            if (r3 == 0) goto L_0x0096
            androidx.compose.ui.geometry.Rect r4 = r9.getContentRect()
            r3.showMenu(r4, r5, r6, r7, r8)
        L_0x0096:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager.showSelectionToolbar$foundation_release():void");
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar2;
        TextToolbar textToolbar3 = this.textToolbar;
        if ((textToolbar3 != null ? textToolbar3.getStatus() : null) == TextToolbarStatus.Shown && (textToolbar2 = this.textToolbar) != null) {
            textToolbar2.hide();
        }
    }

    /* renamed from: contextMenuOpenAdjustment-k-4lQ0M  reason: not valid java name */
    public final void m1335contextMenuOpenAdjustmentk4lQ0M(long position) {
        TextLayoutResultProxy layoutResult;
        TextFieldState textFieldState = this.state;
        if (textFieldState != null && (layoutResult = textFieldState.getLayoutResult()) != null) {
            int offset = TextLayoutResultProxy.m1230getOffsetForPosition3MmeM6k$default(layoutResult, position, false, 2, (Object) null);
            if (!TextRange.m5465containsimpl(getValue$foundation_release().m5695getSelectiond9O1mEE(), offset)) {
                updateSelection(getValue$foundation_release(), offset, offset, false, SelectionAdjustment.Companion.getWord());
            }
        }
    }

    public final boolean isTextChanged$foundation_release() {
        return !Intrinsics.areEqual((Object) this.oldValue.getText(), (Object) getValue$foundation_release().getText());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0089, code lost:
        r11 = (r11 = r11.getValue()).getCursorRect(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.ui.geometry.Rect getContentRect() {
        /*
            r17 = this;
            r0 = r17
            androidx.compose.foundation.text.TextFieldState r1 = r0.state
            if (r1 == 0) goto L_0x0121
            r2 = r1
            r3 = 0
            boolean r4 = r2.isLayoutResultStale()
            r2 = 1
            r3 = r4 ^ 1
            if (r3 == 0) goto L_0x0012
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            if (r1 == 0) goto L_0x0121
            r3 = 0
            androidx.compose.ui.text.input.OffsetMapping r4 = r0.offsetMapping
            androidx.compose.ui.text.input.TextFieldValue r5 = r17.getValue$foundation_release()
            long r5 = r5.m5695getSelectiond9O1mEE()
            int r5 = androidx.compose.ui.text.TextRange.m5474getStartimpl(r5)
            int r4 = r4.originalToTransformed(r5)
            androidx.compose.ui.text.input.OffsetMapping r5 = r0.offsetMapping
            androidx.compose.ui.text.input.TextFieldValue r6 = r17.getValue$foundation_release()
            long r6 = r6.m5695getSelectiond9O1mEE()
            int r6 = androidx.compose.ui.text.TextRange.m5469getEndimpl(r6)
            int r5 = r5.originalToTransformed(r6)
            androidx.compose.foundation.text.TextFieldState r6 = r0.state
            if (r6 == 0) goto L_0x004d
            androidx.compose.ui.layout.LayoutCoordinates r6 = r6.getLayoutCoordinates()
            if (r6 == 0) goto L_0x004d
            long r7 = r0.m1339getHandlePositiontuRUvjQ$foundation_release(r2)
            long r6 = r6.m4841localToRootMKHz9U(r7)
            goto L_0x0053
        L_0x004d:
            androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.ui.geometry.Offset.Companion
            long r6 = r2.m2931getZeroF1C5BW0()
        L_0x0053:
            androidx.compose.foundation.text.TextFieldState r2 = r0.state
            if (r2 == 0) goto L_0x0069
            androidx.compose.ui.layout.LayoutCoordinates r2 = r2.getLayoutCoordinates()
            if (r2 == 0) goto L_0x0069
            r8 = 0
            long r8 = r0.m1339getHandlePositiontuRUvjQ$foundation_release(r8)
            long r8 = r2.m4841localToRootMKHz9U(r8)
            goto L_0x006f
        L_0x0069:
            androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.ui.geometry.Offset.Companion
            long r8 = r2.m2931getZeroF1C5BW0()
        L_0x006f:
            androidx.compose.foundation.text.TextFieldState r2 = r0.state
            r10 = 0
            if (r2 == 0) goto L_0x00a4
            androidx.compose.ui.layout.LayoutCoordinates r2 = r2.getLayoutCoordinates()
            if (r2 == 0) goto L_0x00a4
            androidx.compose.foundation.text.TextLayoutResultProxy r11 = r1.getLayoutResult()
            if (r11 == 0) goto L_0x0094
            androidx.compose.ui.text.TextLayoutResult r11 = r11.getValue()
            if (r11 == 0) goto L_0x0094
            androidx.compose.ui.geometry.Rect r11 = r11.getCursorRect(r4)
            if (r11 == 0) goto L_0x0094
            float r11 = r11.getTop()
            goto L_0x0095
        L_0x0094:
            r11 = r10
        L_0x0095:
            long r11 = androidx.compose.ui.geometry.OffsetKt.Offset(r10, r11)
            long r11 = r2.m4841localToRootMKHz9U(r11)
            float r2 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r11)
            goto L_0x00a5
        L_0x00a4:
            r2 = r10
        L_0x00a5:
            androidx.compose.foundation.text.TextFieldState r11 = r0.state
            if (r11 == 0) goto L_0x00d9
            androidx.compose.ui.layout.LayoutCoordinates r11 = r11.getLayoutCoordinates()
            if (r11 == 0) goto L_0x00d9
            androidx.compose.foundation.text.TextLayoutResultProxy r12 = r1.getLayoutResult()
            if (r12 == 0) goto L_0x00c9
            androidx.compose.ui.text.TextLayoutResult r12 = r12.getValue()
            if (r12 == 0) goto L_0x00c9
            androidx.compose.ui.geometry.Rect r12 = r12.getCursorRect(r5)
            if (r12 == 0) goto L_0x00c9
            float r12 = r12.getTop()
            goto L_0x00ca
        L_0x00c9:
            r12 = r10
        L_0x00ca:
            long r12 = androidx.compose.ui.geometry.OffsetKt.Offset(r10, r12)
            long r10 = r11.m4841localToRootMKHz9U(r12)
            float r10 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r10)
            goto L_0x00da
        L_0x00d9:
        L_0x00da:
            float r11 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r6)
            float r12 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r8)
            float r11 = java.lang.Math.min(r11, r12)
            float r12 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r6)
            float r13 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r8)
            float r12 = java.lang.Math.max(r12, r13)
            float r13 = java.lang.Math.min(r2, r10)
            float r14 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r6)
            float r15 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r8)
            float r14 = java.lang.Math.max(r14, r15)
            r15 = 25
            r16 = 0
            float r0 = (float) r15
            float r0 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r0)
            androidx.compose.foundation.text.TextDelegate r15 = r1.getTextDelegate()
            androidx.compose.ui.unit.Density r15 = r15.getDensity()
            float r15 = r15.getDensity()
            float r0 = r0 * r15
            float r14 = r14 + r0
            androidx.compose.ui.geometry.Rect r0 = new androidx.compose.ui.geometry.Rect
            r0.<init>(r11, r13, r12, r14)
            return r0
        L_0x0121:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.ui.geometry.Rect r0 = r0.getZero()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager.getContentRect():androidx.compose.ui.geometry.Rect");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0025, code lost:
        r2 = r2.getLayoutResult();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateSelection(androidx.compose.ui.text.input.TextFieldValue r11, int r12, int r13, boolean r14, androidx.compose.foundation.text.selection.SelectionAdjustment r15) {
        /*
            r10 = this;
            androidx.compose.ui.text.input.OffsetMapping r0 = r10.offsetMapping
            long r1 = r11.m5695getSelectiond9O1mEE()
            int r1 = androidx.compose.ui.text.TextRange.m5474getStartimpl(r1)
            int r0 = r0.originalToTransformed(r1)
            androidx.compose.ui.text.input.OffsetMapping r1 = r10.offsetMapping
            long r2 = r11.m5695getSelectiond9O1mEE()
            int r2 = androidx.compose.ui.text.TextRange.m5469getEndimpl(r2)
            int r1 = r1.originalToTransformed(r2)
            long r0 = androidx.compose.ui.text.TextRangeKt.TextRange(r0, r1)
            androidx.compose.foundation.text.TextFieldState r2 = r10.state
            r3 = 0
            if (r2 == 0) goto L_0x0031
            androidx.compose.foundation.text.TextLayoutResultProxy r2 = r2.getLayoutResult()
            if (r2 == 0) goto L_0x0031
            androidx.compose.ui.text.TextLayoutResult r2 = r2.getValue()
            r4 = r2
            goto L_0x0032
        L_0x0031:
            r4 = r3
        L_0x0032:
            boolean r2 = androidx.compose.ui.text.TextRange.m5468getCollapsedimpl(r0)
            if (r2 == 0) goto L_0x003b
            goto L_0x003f
        L_0x003b:
            androidx.compose.ui.text.TextRange r3 = androidx.compose.ui.text.TextRange.m5462boximpl(r0)
        L_0x003f:
            r7 = r3
            r5 = r12
            r6 = r13
            r8 = r14
            r9 = r15
            long r2 = androidx.compose.foundation.text.selection.TextFieldSelectionDelegateKt.m1329getTextFieldSelectionbb3KNj8(r4, r5, r6, r7, r8, r9)
            androidx.compose.ui.text.input.OffsetMapping r4 = r10.offsetMapping
            int r5 = androidx.compose.ui.text.TextRange.m5474getStartimpl(r2)
            int r4 = r4.transformedToOriginal(r5)
            androidx.compose.ui.text.input.OffsetMapping r5 = r10.offsetMapping
            int r6 = androidx.compose.ui.text.TextRange.m5469getEndimpl(r2)
            int r5 = r5.transformedToOriginal(r6)
            long r4 = androidx.compose.ui.text.TextRangeKt.TextRange(r4, r5)
            long r6 = r11.m5695getSelectiond9O1mEE()
            boolean r6 = androidx.compose.ui.text.TextRange.m5467equalsimpl0(r4, r6)
            if (r6 == 0) goto L_0x006d
            return
        L_0x006d:
            androidx.compose.ui.hapticfeedback.HapticFeedback r6 = r10.hapticFeedBack
            if (r6 == 0) goto L_0x007a
            androidx.compose.ui.hapticfeedback.HapticFeedbackType$Companion r7 = androidx.compose.ui.hapticfeedback.HapticFeedbackType.Companion
            int r7 = r7.m3908getTextHandleMove5zf0vsI()
            r6.m3899performHapticFeedbackCdsT49E(r7)
        L_0x007a:
            androidx.compose.ui.text.AnnotatedString r6 = r11.getAnnotatedString()
            androidx.compose.ui.text.input.TextFieldValue r6 = r10.m1332createTextFieldValueFDrldGo(r6, r4)
            kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r7 = r10.onValueChange
            r7.invoke(r6)
            androidx.compose.foundation.text.TextFieldState r7 = r10.state
            if (r7 != 0) goto L_0x008e
            goto L_0x0096
        L_0x008e:
            r8 = 1
            boolean r8 = androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(r10, r8)
            r7.setShowSelectionHandleStart(r8)
        L_0x0096:
            androidx.compose.foundation.text.TextFieldState r7 = r10.state
            if (r7 != 0) goto L_0x009b
            goto L_0x00a3
        L_0x009b:
            r8 = 0
            boolean r8 = androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(r10, r8)
            r7.setShowSelectionHandleEnd(r8)
        L_0x00a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager.updateSelection(androidx.compose.ui.text.input.TextFieldValue, int, int, boolean, androidx.compose.foundation.text.selection.SelectionAdjustment):void");
    }

    private final void setHandleState(HandleState handleState) {
        TextFieldState it = this.state;
        if (it != null) {
            it.setHandleState(handleState);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: createTextFieldValue-FDrldGo  reason: not valid java name */
    public final TextFieldValue m1332createTextFieldValueFDrldGo(AnnotatedString annotatedString, long selection) {
        return new TextFieldValue(annotatedString, selection, (TextRange) null, 4, (DefaultConstructorMarker) null);
    }
}
