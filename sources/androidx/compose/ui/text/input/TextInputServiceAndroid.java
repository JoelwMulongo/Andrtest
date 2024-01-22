package androidx.compose.ui.text.input;

import android.graphics.Rect;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.TextRange;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0001DB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201J\b\u00102\u001a\u00020!H\u0016J\u0010\u00103\u001a\u00020!2\u0006\u00104\u001a\u000205H\u0017J\b\u00106\u001a\u00020!H\u0002J\b\u00107\u001a\u00020!H\u0002J\u0010\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020+H\u0002J\u0010\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u00020!H\u0016JI\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u001c2\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0004\u0012\u00020!0\u001e2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020!0\u001eH\u0016ø\u0001\u0000J\b\u0010@\u001a\u00020!H\u0016J\u001a\u0010A\u001a\u00020!2\b\u0010B\u001a\u0004\u0018\u00010%2\u0006\u0010C\u001a\u00020%H\u0016R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R \u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0004\u0012\u00020!0\u001eX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020!0\u001eX\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020%@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-\u0002\u0004\n\u0002\b\u0019¨\u0006E"}, d2 = {"Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "view", "Landroid/view/View;", "context", "Landroidx/compose/ui/text/input/PlatformTextInput;", "(Landroid/view/View;Landroidx/compose/ui/text/input/PlatformTextInput;)V", "inputMethodManager", "Landroidx/compose/ui/text/input/InputMethodManager;", "platformTextInput", "inputCommandProcessorExecutor", "Ljava/util/concurrent/Executor;", "(Landroid/view/View;Landroidx/compose/ui/text/input/InputMethodManager;Landroidx/compose/ui/text/input/PlatformTextInput;Ljava/util/concurrent/Executor;)V", "baseInputConnection", "Landroid/view/inputmethod/BaseInputConnection;", "getBaseInputConnection", "()Landroid/view/inputmethod/BaseInputConnection;", "baseInputConnection$delegate", "Lkotlin/Lazy;", "focusedRect", "Landroid/graphics/Rect;", "frameCallback", "Ljava/lang/Runnable;", "ics", "", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/text/input/RecordingInputConnection;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onEditCommand", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/input/EditCommand;", "", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "<set-?>", "Landroidx/compose/ui/text/input/TextFieldValue;", "state", "getState$ui_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "textInputCommandQueue", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/text/input/TextInputServiceAndroid$TextInputCommand;", "getView", "()Landroid/view/View;", "createInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "hideSoftwareKeyboard", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "processInputCommands", "restartInputImmediately", "sendInputCommand", "command", "setKeyboardVisibleImmediately", "visible", "", "showSoftwareKeyboard", "startInput", "value", "stopInput", "updateState", "oldValue", "newValue", "TextInputCommand", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextInputServiceAndroid.android.kt */
public final class TextInputServiceAndroid implements PlatformTextInputService {
    private final Lazy baseInputConnection$delegate;
    private Rect focusedRect;
    private Runnable frameCallback;
    /* access modifiers changed from: private */
    public List<WeakReference<RecordingInputConnection>> ics;
    private ImeOptions imeOptions;
    private final Executor inputCommandProcessorExecutor;
    private final InputMethodManager inputMethodManager;
    /* access modifiers changed from: private */
    public Function1<? super List<? extends EditCommand>, Unit> onEditCommand;
    /* access modifiers changed from: private */
    public Function1<? super ImeAction, Unit> onImeActionPerformed;
    private final PlatformTextInput platformTextInput;
    private TextFieldValue state;
    private final MutableVector<TextInputCommand> textInputCommandQueue;
    private final View view;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/input/TextInputServiceAndroid$TextInputCommand;", "", "(Ljava/lang/String;I)V", "StartInput", "StopInput", "ShowKeyboard", "HideKeyboard", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextInputServiceAndroid.android.kt */
    private enum TextInputCommand {
        StartInput,
        StopInput,
        ShowKeyboard,
        HideKeyboard
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextInputServiceAndroid.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextInputCommand.values().length];
            try {
                iArr[TextInputCommand.StartInput.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[TextInputCommand.StopInput.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[TextInputCommand.ShowKeyboard.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[TextInputCommand.HideKeyboard.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TextInputServiceAndroid(View view2, InputMethodManager inputMethodManager2, PlatformTextInput platformTextInput2, Executor inputCommandProcessorExecutor2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(inputMethodManager2, "inputMethodManager");
        Intrinsics.checkNotNullParameter(inputCommandProcessorExecutor2, "inputCommandProcessorExecutor");
        this.view = view2;
        this.inputMethodManager = inputMethodManager2;
        this.platformTextInput = platformTextInput2;
        this.inputCommandProcessorExecutor = inputCommandProcessorExecutor2;
        this.onEditCommand = TextInputServiceAndroid$onEditCommand$1.INSTANCE;
        this.onImeActionPerformed = TextInputServiceAndroid$onImeActionPerformed$1.INSTANCE;
        this.state = new TextFieldValue("", TextRange.Companion.m5479getZerod9O1mEE(), (TextRange) null, 4, (DefaultConstructorMarker) null);
        this.imeOptions = ImeOptions.Companion.getDefault();
        this.ics = new ArrayList();
        this.baseInputConnection$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new TextInputServiceAndroid$baseInputConnection$2(this));
        this.textInputCommandQueue = new MutableVector<>(new TextInputCommand[16], 0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextInputServiceAndroid(android.view.View r1, androidx.compose.ui.text.input.InputMethodManager r2, androidx.compose.ui.text.input.PlatformTextInput r3, java.util.concurrent.Executor r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r6 = r5 & 4
            if (r6 == 0) goto L_0x0005
            r3 = 0
        L_0x0005:
            r5 = r5 & 8
            if (r5 == 0) goto L_0x0016
            android.view.Choreographer r4 = android.view.Choreographer.getInstance()
            java.lang.String r5 = "getInstance()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.util.concurrent.Executor r4 = androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt.asExecutor(r4)
        L_0x0016:
            r0.<init>((android.view.View) r1, (androidx.compose.ui.text.input.InputMethodManager) r2, (androidx.compose.ui.text.input.PlatformTextInput) r3, (java.util.concurrent.Executor) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.TextInputServiceAndroid.<init>(android.view.View, androidx.compose.ui.text.input.InputMethodManager, androidx.compose.ui.text.input.PlatformTextInput, java.util.concurrent.Executor, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final View getView() {
        return this.view;
    }

    public final TextFieldValue getState$ui_release() {
        return this.state;
    }

    /* access modifiers changed from: private */
    public final BaseInputConnection getBaseInputConnection() {
        return (BaseInputConnection) this.baseInputConnection$delegate.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TextInputServiceAndroid(View view2, PlatformTextInput context) {
        this(view2, new InputMethodManagerImpl(view2), context, (Executor) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextInputServiceAndroid(View view2, PlatformTextInput platformTextInput2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view2, (i & 2) != 0 ? null : platformTextInput2);
    }

    public final InputConnection createInputConnection(EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        TextInputServiceAndroid_androidKt.update(outAttrs, this.imeOptions, this.state);
        TextInputServiceAndroid_androidKt.updateWithEmojiCompat(outAttrs);
        RecordingInputConnection it = new RecordingInputConnection(this.state, new TextInputServiceAndroid$createInputConnection$1(this), this.imeOptions.getAutoCorrect());
        this.ics.add(new WeakReference(it));
        return it;
    }

    public void startInput(TextFieldValue value, ImeOptions imeOptions2, Function1<? super List<? extends EditCommand>, Unit> onEditCommand2, Function1<? super ImeAction, Unit> onImeActionPerformed2) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(imeOptions2, "imeOptions");
        Intrinsics.checkNotNullParameter(onEditCommand2, "onEditCommand");
        Intrinsics.checkNotNullParameter(onImeActionPerformed2, "onImeActionPerformed");
        PlatformTextInput platformTextInput2 = this.platformTextInput;
        if (platformTextInput2 != null) {
            platformTextInput2.requestInputFocus();
        }
        this.state = value;
        this.imeOptions = imeOptions2;
        this.onEditCommand = onEditCommand2;
        this.onImeActionPerformed = onImeActionPerformed2;
        sendInputCommand(TextInputCommand.StartInput);
    }

    public void stopInput() {
        PlatformTextInput platformTextInput2 = this.platformTextInput;
        if (platformTextInput2 != null) {
            platformTextInput2.releaseInputFocus();
        }
        this.onEditCommand = TextInputServiceAndroid$stopInput$1.INSTANCE;
        this.onImeActionPerformed = TextInputServiceAndroid$stopInput$2.INSTANCE;
        this.focusedRect = null;
        sendInputCommand(TextInputCommand.StopInput);
    }

    public void showSoftwareKeyboard() {
        sendInputCommand(TextInputCommand.ShowKeyboard);
    }

    public void hideSoftwareKeyboard() {
        sendInputCommand(TextInputCommand.HideKeyboard);
    }

    private final void sendInputCommand(TextInputCommand command) {
        this.textInputCommandQueue.add(command);
        if (this.frameCallback == null) {
            Runnable p0 = new TextInputServiceAndroid$$ExternalSyntheticLambda0(this);
            this.inputCommandProcessorExecutor.execute(p0);
            this.frameCallback = p0;
        }
    }

    /* access modifiers changed from: private */
    public static final void sendInputCommand$lambda$1(TextInputServiceAndroid this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.frameCallback = null;
        this$0.processInputCommands();
    }

    private final void processInputCommands() {
        if (!this.view.isFocused()) {
            this.textInputCommandQueue.clear();
            return;
        }
        Ref.ObjectRef startInput = new Ref.ObjectRef();
        Ref.ObjectRef showKeyboard = new Ref.ObjectRef();
        MutableVector this_$iv = this.textInputCommandQueue;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                processInputCommands$applyToState((TextInputCommand) content$iv[i$iv], startInput, showKeyboard);
                i$iv++;
            } while (i$iv < size$iv);
        }
        if (Intrinsics.areEqual((Object) startInput.element, (Object) true)) {
            restartInputImmediately();
        }
        Boolean bool = (Boolean) showKeyboard.element;
        if (bool != null) {
            setKeyboardVisibleImmediately(bool.booleanValue());
        }
        if (Intrinsics.areEqual((Object) startInput.element, (Object) false)) {
            restartInputImmediately();
        }
    }

    private static final void processInputCommands$applyToState(TextInputCommand $this$processInputCommands_u24applyToState, Ref.ObjectRef<Boolean> startInput, Ref.ObjectRef<Boolean> showKeyboard) {
        boolean z = true;
        switch (WhenMappings.$EnumSwitchMapping$0[$this$processInputCommands_u24applyToState.ordinal()]) {
            case 1:
                startInput.element = true;
                showKeyboard.element = true;
                return;
            case 2:
                startInput.element = false;
                showKeyboard.element = false;
                return;
            case 3:
            case 4:
                if (!Intrinsics.areEqual((Object) startInput.element, (Object) false)) {
                    if ($this$processInputCommands_u24applyToState != TextInputCommand.ShowKeyboard) {
                        z = false;
                    }
                    showKeyboard.element = Boolean.valueOf(z);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void updateState(TextFieldValue oldValue, TextFieldValue newValue) {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        boolean restartInput = false;
        boolean needUpdateSelection = !TextRange.m5467equalsimpl0(this.state.m5695getSelectiond9O1mEE(), newValue.m5695getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) this.state.m5694getCompositionMzsxiRA(), (Object) newValue.m5694getCompositionMzsxiRA());
        this.state = newValue;
        int size = this.ics.size();
        for (int i = 0; i < size; i++) {
            RecordingInputConnection recordingInputConnection = (RecordingInputConnection) this.ics.get(i).get();
            if (recordingInputConnection != null) {
                recordingInputConnection.setMTextFieldValue$ui_release(newValue);
            }
        }
        if (Intrinsics.areEqual((Object) oldValue, (Object) newValue) == 0) {
            if (oldValue != null) {
                TextFieldValue it = oldValue;
                if (!Intrinsics.areEqual((Object) it.getText(), (Object) newValue.getText()) || (TextRange.m5467equalsimpl0(it.m5695getSelectiond9O1mEE(), newValue.m5695getSelectiond9O1mEE()) && !Intrinsics.areEqual((Object) it.m5694getCompositionMzsxiRA(), (Object) newValue.m5694getCompositionMzsxiRA()))) {
                    restartInput = true;
                }
            }
            if (restartInput) {
                restartInputImmediately();
                return;
            }
            int size2 = this.ics.size();
            for (int i2 = 0; i2 < size2; i2++) {
                RecordingInputConnection recordingInputConnection2 = (RecordingInputConnection) this.ics.get(i2).get();
                if (recordingInputConnection2 != null) {
                    recordingInputConnection2.updateInputState(this.state, this.inputMethodManager);
                }
            }
        } else if (needUpdateSelection) {
            InputMethodManager inputMethodManager2 = this.inputMethodManager;
            int r2 = TextRange.m5472getMinimpl(newValue.m5695getSelectiond9O1mEE());
            int r3 = TextRange.m5471getMaximpl(newValue.m5695getSelectiond9O1mEE());
            TextRange r4 = this.state.m5694getCompositionMzsxiRA();
            int i3 = -1;
            int r42 = r4 != null ? TextRange.m5472getMinimpl(r4.m5478unboximpl()) : -1;
            TextRange r6 = this.state.m5694getCompositionMzsxiRA();
            if (r6 != null) {
                i3 = TextRange.m5471getMaximpl(r6.m5478unboximpl());
            }
            inputMethodManager2.updateSelection(r2, r3, r42, i3);
        }
    }

    @Deprecated(message = "This method should not be called, used BringIntoViewRequester instead.")
    public void notifyFocusedRect(androidx.compose.ui.geometry.Rect rect) {
        Rect it;
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.focusedRect = new Rect(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()), MathKt.roundToInt(rect.getRight()), MathKt.roundToInt(rect.getBottom()));
        if (this.ics.isEmpty() && (it = this.focusedRect) != null) {
            this.view.requestRectangleOnScreen(new Rect(it));
        }
    }

    private final void restartInputImmediately() {
        this.inputMethodManager.restartInput();
    }

    private final void setKeyboardVisibleImmediately(boolean visible) {
        if (visible) {
            this.inputMethodManager.showSoftInput();
        } else {
            this.inputMethodManager.hideSoftInput();
        }
    }
}
