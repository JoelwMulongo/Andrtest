package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&JX\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/platform/TextToolbar;", "", "status", "Landroidx/compose/ui/platform/TextToolbarStatus;", "getStatus", "()Landroidx/compose/ui/platform/TextToolbarStatus;", "hide", "", "showMenu", "rect", "Landroidx/compose/ui/geometry/Rect;", "onCopyRequested", "Lkotlin/Function0;", "onPasteRequested", "onCutRequested", "onSelectAllRequested", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextToolbar.kt */
public interface TextToolbar {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextToolbar.kt */
    public static final class DefaultImpls {
    }

    TextToolbarStatus getStatus();

    void hide();

    void showMenu(Rect rect, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04);

    static /* synthetic */ void showMenu$default(TextToolbar textToolbar, Rect rect, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i, Object obj) {
        Function0 function05;
        Function0 function06;
        Function0 function07;
        Function0 function08;
        if (obj == null) {
            if ((i & 2) != 0) {
                function05 = null;
            } else {
                function05 = function0;
            }
            if ((i & 4) != 0) {
                function06 = null;
            } else {
                function06 = function02;
            }
            if ((i & 8) != 0) {
                function07 = null;
            } else {
                function07 = function03;
            }
            if ((i & 16) != 0) {
                function08 = null;
            } else {
                function08 = function04;
            }
            textToolbar.showMenu(rect, function05, function06, function07, function08);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMenu");
    }
}
