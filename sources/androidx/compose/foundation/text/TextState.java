package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@BX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R+\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@BX\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\rR(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R&\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\b0\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R%\u0010'\u001a\u00020(X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010*R%\u00105\u001a\u000206X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b7\u0010*\"\u0004\b8\u0010,R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006="}, d2 = {"Landroidx/compose/foundation/text/TextState;", "", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "selectableId", "", "(Landroidx/compose/foundation/text/TextDelegate;J)V", "<set-?>", "", "drawScopeInvalidation", "getDrawScopeInvalidation", "()Lkotlin/Unit;", "setDrawScopeInvalidation", "(Lkotlin/Unit;)V", "drawScopeInvalidation$delegate", "Landroidx/compose/runtime/MutableState;", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "layoutInvalidation", "getLayoutInvalidation", "setLayoutInvalidation", "layoutInvalidation$delegate", "value", "Landroidx/compose/ui/text/TextLayoutResult;", "layoutResult", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "setLayoutResult", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "onTextLayout", "Lkotlin/Function1;", "getOnTextLayout", "()Lkotlin/jvm/functions/Function1;", "setOnTextLayout", "(Lkotlin/jvm/functions/Function1;)V", "previousGlobalPosition", "Landroidx/compose/ui/geometry/Offset;", "getPreviousGlobalPosition-F1C5BW0", "()J", "setPreviousGlobalPosition-k-4lQ0M", "(J)V", "J", "selectable", "Landroidx/compose/foundation/text/selection/Selectable;", "getSelectable", "()Landroidx/compose/foundation/text/selection/Selectable;", "setSelectable", "(Landroidx/compose/foundation/text/selection/Selectable;)V", "getSelectableId", "selectionBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "getSelectionBackgroundColor-0d7_KjU", "setSelectionBackgroundColor-8_81llA", "getTextDelegate", "()Landroidx/compose/foundation/text/TextDelegate;", "setTextDelegate", "(Landroidx/compose/foundation/text/TextDelegate;)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreText.kt */
public final class TextState {
    private final MutableState drawScopeInvalidation$delegate;
    private LayoutCoordinates layoutCoordinates;
    private final MutableState layoutInvalidation$delegate;
    private TextLayoutResult layoutResult;
    private Function1<? super TextLayoutResult, Unit> onTextLayout = TextState$onTextLayout$1.INSTANCE;
    private long previousGlobalPosition;
    private Selectable selectable;
    private final long selectableId;
    private long selectionBackgroundColor;
    private TextDelegate textDelegate;

    public TextState(TextDelegate textDelegate2, long selectableId2) {
        Intrinsics.checkNotNullParameter(textDelegate2, "textDelegate");
        this.selectableId = selectableId2;
        this.textDelegate = textDelegate2;
        this.previousGlobalPosition = Offset.Companion.m2931getZeroF1C5BW0();
        this.selectionBackgroundColor = Color.Companion.m3200getUnspecified0d7_KjU();
        this.drawScopeInvalidation$delegate = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        this.layoutInvalidation$delegate = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
    }

    public final long getSelectableId() {
        return this.selectableId;
    }

    public final Function1<TextLayoutResult, Unit> getOnTextLayout() {
        return this.onTextLayout;
    }

    public final void setOnTextLayout(Function1<? super TextLayoutResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onTextLayout = function1;
    }

    public final Selectable getSelectable() {
        return this.selectable;
    }

    public final void setSelectable(Selectable selectable2) {
        this.selectable = selectable2;
    }

    public final LayoutCoordinates getLayoutCoordinates() {
        return this.layoutCoordinates;
    }

    public final void setLayoutCoordinates(LayoutCoordinates layoutCoordinates2) {
        this.layoutCoordinates = layoutCoordinates2;
    }

    public final TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public final void setTextDelegate(TextDelegate value) {
        Intrinsics.checkNotNullParameter(value, "value");
        setLayoutInvalidation(Unit.INSTANCE);
        this.textDelegate = value;
    }

    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult;
    }

    public final void setLayoutResult(TextLayoutResult value) {
        setDrawScopeInvalidation(Unit.INSTANCE);
        this.layoutResult = value;
    }

    /* renamed from: getPreviousGlobalPosition-F1C5BW0  reason: not valid java name */
    public final long m1236getPreviousGlobalPositionF1C5BW0() {
        return this.previousGlobalPosition;
    }

    /* renamed from: setPreviousGlobalPosition-k-4lQ0M  reason: not valid java name */
    public final void m1238setPreviousGlobalPositionk4lQ0M(long j) {
        this.previousGlobalPosition = j;
    }

    /* renamed from: getSelectionBackgroundColor-0d7_KjU  reason: not valid java name */
    public final long m1237getSelectionBackgroundColor0d7_KjU() {
        return this.selectionBackgroundColor;
    }

    /* renamed from: setSelectionBackgroundColor-8_81llA  reason: not valid java name */
    public final void m1239setSelectionBackgroundColor8_81llA(long j) {
        this.selectionBackgroundColor = j;
    }

    private final void setDrawScopeInvalidation(Unit unit) {
        this.drawScopeInvalidation$delegate.setValue(unit);
    }

    public final Unit getDrawScopeInvalidation() {
        this.drawScopeInvalidation$delegate.getValue();
        return Unit.INSTANCE;
    }

    private final void setLayoutInvalidation(Unit unit) {
        this.layoutInvalidation$delegate.setValue(unit);
    }

    public final Unit getLayoutInvalidation() {
        this.layoutInvalidation$delegate.getValue();
        return Unit.INSTANCE;
    }
}
