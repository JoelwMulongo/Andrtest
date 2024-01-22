package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eRE\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00122\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00128W@WX\u000eø\u0001\u0000¢\u0006\u0012\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aRE\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00122\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00128W@WX\u000eø\u0001\u0000¢\u0006\u0012\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR$\u0010\u001f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR$\u0010\"\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR$\u0010%\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR$\u0010(\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR$\u0010+\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b,\u0010\f\"\u0004\b-\u0010\u000eR$\u0010.\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b/\u0010\f\"\u0004\b0\u0010\u000eø\u0001\u0001\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u00061À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/focus/FocusProperties;", "", "canFocus", "", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "<anonymous parameter 0>", "Landroidx/compose/ui/focus/FocusRequester;", "down", "getDown", "()Landroidx/compose/ui/focus/FocusRequester;", "setDown", "(Landroidx/compose/ui/focus/FocusRequester;)V", "end", "getEnd", "setEnd", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusDirection;", "enter", "getEnter$annotations", "()V", "getEnter", "()Lkotlin/jvm/functions/Function1;", "setEnter", "(Lkotlin/jvm/functions/Function1;)V", "exit", "getExit$annotations", "getExit", "setExit", "left", "getLeft", "setLeft", "next", "getNext", "setNext", "previous", "getPrevious", "setPrevious", "right", "getRight", "setRight", "start", "getStart", "setStart", "up", "getUp", "setUp", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusProperties.kt */
public interface FocusProperties {
    static /* synthetic */ void getEnter$annotations() {
    }

    static /* synthetic */ void getExit$annotations() {
    }

    boolean getCanFocus();

    void setCanFocus(boolean z);

    FocusRequester getNext() {
        return FocusRequester.Companion.getDefault();
    }

    void setNext(FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
    }

    FocusRequester getPrevious() {
        return FocusRequester.Companion.getDefault();
    }

    void setPrevious(FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
    }

    FocusRequester getUp() {
        return FocusRequester.Companion.getDefault();
    }

    void setUp(FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
    }

    FocusRequester getDown() {
        return FocusRequester.Companion.getDefault();
    }

    void setDown(FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
    }

    FocusRequester getLeft() {
        return FocusRequester.Companion.getDefault();
    }

    void setLeft(FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
    }

    FocusRequester getRight() {
        return FocusRequester.Companion.getDefault();
    }

    void setRight(FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
    }

    FocusRequester getStart() {
        return FocusRequester.Companion.getDefault();
    }

    void setStart(FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
    }

    FocusRequester getEnd() {
        return FocusRequester.Companion.getDefault();
    }

    void setEnd(FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
    }

    Function1<FocusDirection, FocusRequester> getEnter() {
        return FocusProperties$enter$1.INSTANCE;
    }

    void setEnter(Function1<? super FocusDirection, FocusRequester> function1) {
        Intrinsics.checkNotNullParameter(function1, "<anonymous parameter 0>");
    }

    Function1<FocusDirection, FocusRequester> getExit() {
        return FocusProperties$exit$1.INSTANCE;
    }

    void setExit(Function1<? super FocusDirection, FocusRequester> function1) {
        Intrinsics.checkNotNullParameter(function1, "<anonymous parameter 0>");
    }
}
