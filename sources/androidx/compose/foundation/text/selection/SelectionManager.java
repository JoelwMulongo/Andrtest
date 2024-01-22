package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010f\u001a\u00020L2\u0006\u0010g\u001a\u00020\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bh\u0010\"J'\u0010i\u001a\u0004\u0018\u00010\u00162\u0006\u0010j\u001a\u00020\u000f2\u0006\u0010k\u001a\u00020\u0016H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bl\u0010mJ\r\u0010n\u001a\u00020LH\u0000¢\u0006\u0002\boJ\u0017\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010r\u001a\u00020sH\u0000¢\u0006\u0002\btJ\b\u0010u\u001a\u00020vH\u0002J\u000f\u0010w\u001a\u0004\u0018\u00010xH\u0000¢\u0006\u0002\byJ\u000e\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020?J\r\u0010}\u001a\u00020LH\u0000¢\u0006\u0002\b~J\u0006\u0010\u001a\u00020LJ\u000f\u0010\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0003\b\u0001JA\u0010\u0001\u001a\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020\u00070\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020LH\u0000¢\u0006\u0003\b\u0001J2\u0010\u0001\u001a\u00020L2\u0006\u0010g\u001a\u00020\u00162\u0006\u0010|\u001a\u00020?2\b\u0010\u0001\u001a\u00030\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\t\u0010\u0001\u001a\u00020LH\u0002JE\u0010\u0001\u001a\u00020?2\u0006\u0010Y\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00162\t\u0010\u0001\u001a\u0004\u0018\u00010\u00162\u0006\u0010|\u001a\u00020?2\b\u0010\u0001\u001a\u00030\u0001H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J<\u0010\u0001\u001a\u00020?2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00162\b\u0010Q\u001a\u0004\u0018\u00010\u00162\u0006\u0010|\u001a\u00020?2\b\u0010\u0001\u001a\u00030\u0001H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0003\b\u0001J\t\u0010\u0001\u001a\u00020LH\u0002J0\u0010\u0001\u001a\u00020L*\u00030\u00012\u0013\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020L0KH@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u001d\u0010\u0001\u001a\u00020G*\u00020G2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020L0\u0001H\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R8\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR4\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168@@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R4\u0010$\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168@@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b'\u0010\u001d\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R/\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u0015\u001a\u0004\u0018\u00010(8F@BX\u0002¢\u0006\u0012\n\u0004\b.\u0010\u001d\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R8\u0010/\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b2\u0010\u001d\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\u001bR\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R+\u0010@\u001a\u00020?2\u0006\u0010\u0015\u001a\u00020?8F@FX\u0002¢\u0006\u0012\n\u0004\bE\u0010\u001d\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0011\u0010F\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bH\u0010IR(\u0010J\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020L0KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0019\u0010Q\u001a\u0004\u0018\u00010\u0016X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R(\u0010R\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00078F@FX\u000e¢\u0006\f\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010W\u001a\u00020?8BX\u0004¢\u0006\u0006\u001a\u0004\bX\u0010BR8\u0010Y\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\\\u0010\u001d\u001a\u0004\bZ\u0010\u0019\"\u0004\b[\u0010\u001bR\u001c\u0010]\u001a\u0004\u0018\u00010^X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001a\u0010c\u001a\u00020?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010B\"\u0004\be\u0010D\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionManager;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "(Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;)V", "_selection", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/selection/Selection;", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/ClipboardManager;", "setClipboardManager", "(Landroidx/compose/ui/platform/ClipboardManager;)V", "value", "Landroidx/compose/ui/layout/LayoutCoordinates;", "containerLayoutCoordinates", "getContainerLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setContainerLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "Landroidx/compose/runtime/MutableState;", "dragBeginPosition", "getDragBeginPosition-F1C5BW0$foundation_release", "()J", "setDragBeginPosition-k-4lQ0M", "(J)V", "dragBeginPosition$delegate", "dragTotalDistance", "getDragTotalDistance-F1C5BW0$foundation_release", "setDragTotalDistance-k-4lQ0M", "dragTotalDistance$delegate", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "endHandlePosition", "getEndHandlePosition-_m7T9-E", "setEndHandlePosition-_kEHs6E", "endHandlePosition$delegate", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "onSelectionChange", "Lkotlin/Function1;", "", "getOnSelectionChange", "()Lkotlin/jvm/functions/Function1;", "setOnSelectionChange", "(Lkotlin/jvm/functions/Function1;)V", "previousPosition", "selection", "getSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "setSelection", "(Landroidx/compose/foundation/text/selection/Selection;)V", "shouldShowMagnifier", "getShouldShowMagnifier", "startHandlePosition", "getStartHandlePosition-_m7T9-E", "setStartHandlePosition-_kEHs6E", "startHandlePosition$delegate", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "touchMode", "getTouchMode", "setTouchMode", "contextMenuOpenAdjustment", "position", "contextMenuOpenAdjustment-k-4lQ0M", "convertToContainerCoordinates", "layoutCoordinates", "offset", "convertToContainerCoordinates-Q7Q5hAU", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)Landroidx/compose/ui/geometry/Offset;", "copy", "copy$foundation_release", "getAnchorSelectable", "Landroidx/compose/foundation/text/selection/Selectable;", "anchor", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getAnchorSelectable$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getSelectedText", "Landroidx/compose/ui/text/AnnotatedString;", "getSelectedText$foundation_release", "handleDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "isStartHandle", "hideSelectionToolbar", "hideSelectionToolbar$foundation_release", "onRelease", "requireContainerCoordinates", "requireContainerCoordinates$foundation_release", "selectAll", "Lkotlin/Pair;", "", "", "selectableId", "previousSelection", "selectAll$foundation_release", "showSelectionToolbar", "showSelectionToolbar$foundation_release", "startSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "startSelection-9KIMszo", "(JZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)V", "updateHandleOffsets", "updateSelection", "previousHandlePosition", "updateSelection-3R_-tFg$foundation_release", "(JJLandroidx/compose/ui/geometry/Offset;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "newPosition", "updateSelection-RHHTvR4$foundation_release", "updateSelectionToolbarPosition", "detectNonConsumingTap", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onTap", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClearSelectionRequested", "block", "Lkotlin/Function0;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionManager.kt */
public final class SelectionManager {
    private final MutableState<Selection> _selection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private ClipboardManager clipboardManager;
    private LayoutCoordinates containerLayoutCoordinates;
    private final MutableState currentDragPosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState dragBeginPosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2904boximpl(Offset.Companion.m2931getZeroF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState dragTotalDistance$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2904boximpl(Offset.Companion.m2931getZeroF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState draggingHandle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState endHandlePosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private FocusRequester focusRequester = new FocusRequester();
    private HapticFeedback hapticFeedBack;
    private final MutableState hasFocus$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private Function1<? super Selection, Unit> onSelectionChange = SelectionManager$onSelectionChange$1.INSTANCE;
    private Offset previousPosition;
    /* access modifiers changed from: private */
    public final SelectionRegistrarImpl selectionRegistrar;
    private final MutableState startHandlePosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private TextToolbar textToolbar;
    private boolean touchMode = true;

    public SelectionManager(SelectionRegistrarImpl selectionRegistrar2) {
        Intrinsics.checkNotNullParameter(selectionRegistrar2, "selectionRegistrar");
        this.selectionRegistrar = selectionRegistrar2;
        selectionRegistrar2.setOnPositionChangeCallback$foundation_release(new Function1<Long, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r2;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke(((Number) p1).longValue());
                return Unit.INSTANCE;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
                r0 = r0.getStart();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(long r6) {
                /*
                    r5 = this;
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.this$0
                    androidx.compose.foundation.text.selection.Selection r0 = r0.getSelection()
                    r1 = 1
                    r2 = 0
                    if (r0 == 0) goto L_0x001b
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r0 = r0.getStart()
                    if (r0 == 0) goto L_0x001b
                    long r3 = r0.getSelectableId()
                    int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                    if (r0 != 0) goto L_0x001b
                    r0 = r1
                    goto L_0x001c
                L_0x001b:
                    r0 = r2
                L_0x001c:
                    if (r0 != 0) goto L_0x0038
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.this$0
                    androidx.compose.foundation.text.selection.Selection r0 = r0.getSelection()
                    if (r0 == 0) goto L_0x0035
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r0 = r0.getEnd()
                    if (r0 == 0) goto L_0x0035
                    long r3 = r0.getSelectableId()
                    int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                    if (r0 != 0) goto L_0x0035
                    goto L_0x0036
                L_0x0035:
                    r1 = r2
                L_0x0036:
                    if (r1 == 0) goto L_0x0042
                L_0x0038:
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.this$0
                    r0.updateHandleOffsets()
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.this$0
                    r0.updateSelectionToolbarPosition()
                L_0x0042:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.AnonymousClass1.invoke(long):void");
            }
        });
        selectionRegistrar2.setOnSelectionUpdateStartCallback$foundation_release(new Function3<LayoutCoordinates, Offset, SelectionAdjustment, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r2;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                m1306invoked4ec7I((LayoutCoordinates) p1, ((Offset) p2).m2925unboximpl(), (SelectionAdjustment) p3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-d-4ec7I  reason: not valid java name */
            public final void m1306invoked4ec7I(LayoutCoordinates layoutCoordinates, long position, SelectionAdjustment selectionMode) {
                Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
                Intrinsics.checkNotNullParameter(selectionMode, "selectionMode");
                Offset positionInContainer = this.this$0.m1291convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, position);
                if (positionInContainer != null) {
                    this.this$0.m1297startSelection9KIMszo(positionInContainer.m2925unboximpl(), false, selectionMode);
                    this.this$0.getFocusRequester().requestFocus();
                    this.this$0.hideSelectionToolbar$foundation_release();
                }
            }
        });
        selectionRegistrar2.setOnSelectionUpdateSelectAll$foundation_release(new Function1<Long, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r2;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke(((Number) p1).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long selectableId) {
                SelectionManager selectionManager = this.this$0;
                Pair<Selection, Map<Long, Selection>> selectAll$foundation_release = selectionManager.selectAll$foundation_release(selectableId, selectionManager.getSelection());
                Selection newSelection = selectAll$foundation_release.component1();
                Map newSubselection = selectAll$foundation_release.component2();
                if (!Intrinsics.areEqual((Object) newSelection, (Object) this.this$0.getSelection())) {
                    this.this$0.selectionRegistrar.setSubselections(newSubselection);
                    this.this$0.getOnSelectionChange().invoke(newSelection);
                }
                this.this$0.getFocusRequester().requestFocus();
                this.this$0.hideSelectionToolbar$foundation_release();
            }
        });
        selectionRegistrar2.setOnSelectionUpdateCallback$foundation_release(new Function5<LayoutCoordinates, Offset, Offset, Boolean, SelectionAdjustment, Boolean>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r2;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5) {
                return m1307invoke5iVPX68((LayoutCoordinates) p1, ((Offset) p2).m2925unboximpl(), ((Offset) p3).m2925unboximpl(), ((Boolean) p4).booleanValue(), (SelectionAdjustment) p5);
            }

            /* renamed from: invoke-5iVPX68  reason: not valid java name */
            public final Boolean m1307invoke5iVPX68(LayoutCoordinates layoutCoordinates, long newPosition, long previousPosition, boolean isStartHandle, SelectionAdjustment selectionMode) {
                Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
                Intrinsics.checkNotNullParameter(selectionMode, "selectionMode");
                return Boolean.valueOf(this.this$0.m1305updateSelectionRHHTvR4$foundation_release(this.this$0.m1291convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, newPosition), this.this$0.m1291convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, previousPosition), isStartHandle, selectionMode));
            }
        });
        selectionRegistrar2.setOnSelectionUpdateEndCallback$foundation_release(new Function0<Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r2;
            }

            public final void invoke() {
                this.this$0.showSelectionToolbar$foundation_release();
                this.this$0.setDraggingHandle((Handle) null);
                this.this$0.m1292setCurrentDragPosition_kEHs6E((Offset) null);
            }
        });
        selectionRegistrar2.setOnSelectableChangeCallback$foundation_release(new Function1<Long, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r2;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke(((Number) p1).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long selectableKey) {
                if (this.this$0.selectionRegistrar.getSubselections().containsKey(Long.valueOf(selectableKey))) {
                    this.this$0.onRelease();
                    this.this$0.setSelection((Selection) null);
                }
            }
        });
        selectionRegistrar2.setAfterSelectableUnsubscribe$foundation_release(new Function1<Long, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r2;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke(((Number) p1).longValue());
                return Unit.INSTANCE;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
                r0 = r0.getStart();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(long r6) {
                /*
                    r5 = this;
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.this$0
                    androidx.compose.foundation.text.selection.Selection r0 = r0.getSelection()
                    r1 = 1
                    r2 = 0
                    if (r0 == 0) goto L_0x001b
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r0 = r0.getStart()
                    if (r0 == 0) goto L_0x001b
                    long r3 = r0.getSelectableId()
                    int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                    if (r0 != 0) goto L_0x001b
                    r0 = r1
                    goto L_0x001c
                L_0x001b:
                    r0 = r2
                L_0x001c:
                    if (r0 != 0) goto L_0x0038
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.this$0
                    androidx.compose.foundation.text.selection.Selection r0 = r0.getSelection()
                    if (r0 == 0) goto L_0x0035
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r0 = r0.getEnd()
                    if (r0 == 0) goto L_0x0035
                    long r3 = r0.getSelectableId()
                    int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                    if (r0 != 0) goto L_0x0035
                    goto L_0x0036
                L_0x0035:
                    r1 = r2
                L_0x0036:
                    if (r1 == 0) goto L_0x0043
                L_0x0038:
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.this$0
                    r1 = 0
                    r0.m1296setStartHandlePosition_kEHs6E(r1)
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.this$0
                    r0.m1295setEndHandlePosition_kEHs6E(r1)
                L_0x0043:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.AnonymousClass7.invoke(long):void");
            }
        });
    }

    public final Selection getSelection() {
        return this._selection.getValue();
    }

    public final void setSelection(Selection value) {
        this._selection.setValue(value);
        if (value != null) {
            updateHandleOffsets();
        }
    }

    public final boolean getTouchMode() {
        return this.touchMode;
    }

    public final void setTouchMode(boolean z) {
        this.touchMode = z;
    }

    public final Function1<Selection, Unit> getOnSelectionChange() {
        return this.onSelectionChange;
    }

    public final void setOnSelectionChange(Function1<? super Selection, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onSelectionChange = function1;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final ClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    public final void setClipboardManager(ClipboardManager clipboardManager2) {
        this.clipboardManager = clipboardManager2;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final void setTextToolbar(TextToolbar textToolbar2) {
        this.textToolbar = textToolbar2;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final void setFocusRequester(FocusRequester focusRequester2) {
        Intrinsics.checkNotNullParameter(focusRequester2, "<set-?>");
        this.focusRequester = focusRequester2;
    }

    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    public final void setHasFocus(boolean z) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(z));
    }

    public final Modifier getModifier() {
        return KeyInputModifierKt.onKeyEvent(FocusableKt.focusable$default(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(OnGloballyPositionedModifierKt.onGloballyPositioned(onClearSelectionRequested(Modifier.Companion, new SelectionManager$modifier$1(this)), new SelectionManager$modifier$2(this)), this.focusRequester), new SelectionManager$modifier$3(this)), false, (MutableInteractionSource) null, 3, (Object) null), new SelectionManager$modifier$4(this)).then(getShouldShowMagnifier() ? SelectionManager_androidKt.selectionMagnifier(Modifier.Companion, this) : Modifier.Companion);
    }

    public final LayoutCoordinates getContainerLayoutCoordinates() {
        return this.containerLayoutCoordinates;
    }

    public final void setContainerLayoutCoordinates(LayoutCoordinates value) {
        this.containerLayoutCoordinates = value;
        if (getHasFocus() && getSelection() != null) {
            Offset positionInWindow = value != null ? Offset.m2904boximpl(LayoutCoordinatesKt.positionInWindow(value)) : null;
            if (!Intrinsics.areEqual((Object) this.previousPosition, (Object) positionInWindow)) {
                this.previousPosition = positionInWindow;
                updateHandleOffsets();
                updateSelectionToolbarPosition();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setDragBeginPosition-k-4lQ0M  reason: not valid java name */
    public final void m1293setDragBeginPositionk4lQ0M(long j) {
        this.dragBeginPosition$delegate.setValue(Offset.m2904boximpl(j));
    }

    /* renamed from: getDragBeginPosition-F1C5BW0$foundation_release  reason: not valid java name */
    public final long m1300getDragBeginPositionF1C5BW0$foundation_release() {
        return ((Offset) this.dragBeginPosition$delegate.getValue()).m2925unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: setDragTotalDistance-k-4lQ0M  reason: not valid java name */
    public final void m1294setDragTotalDistancek4lQ0M(long j) {
        this.dragTotalDistance$delegate.setValue(Offset.m2904boximpl(j));
    }

    /* renamed from: getDragTotalDistance-F1C5BW0$foundation_release  reason: not valid java name */
    public final long m1301getDragTotalDistanceF1C5BW0$foundation_release() {
        return ((Offset) this.dragTotalDistance$delegate.getValue()).m2925unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: setStartHandlePosition-_kEHs6E  reason: not valid java name */
    public final void m1296setStartHandlePosition_kEHs6E(Offset offset) {
        this.startHandlePosition$delegate.setValue(offset);
    }

    /* renamed from: getStartHandlePosition-_m7T9-E  reason: not valid java name */
    public final Offset m1303getStartHandlePosition_m7T9E() {
        return (Offset) this.startHandlePosition$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: setEndHandlePosition-_kEHs6E  reason: not valid java name */
    public final void m1295setEndHandlePosition_kEHs6E(Offset offset) {
        this.endHandlePosition$delegate.setValue(offset);
    }

    /* renamed from: getEndHandlePosition-_m7T9-E  reason: not valid java name */
    public final Offset m1302getEndHandlePosition_m7T9E() {
        return (Offset) this.endHandlePosition$delegate.getValue();
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
    public final void m1292setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition$delegate.setValue(offset);
    }

    /* renamed from: getCurrentDragPosition-_m7T9-E  reason: not valid java name */
    public final Offset m1299getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition$delegate.getValue();
    }

    private final boolean getShouldShowMagnifier() {
        return getDraggingHandle() != null;
    }

    public final Selectable getAnchorSelectable$foundation_release(Selection.AnchorInfo anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(anchor.getSelectableId()));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r4 = r1.getStart();
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateHandleOffsets() {
        /*
            r20 = this;
            r0 = r20
            androidx.compose.foundation.text.selection.Selection r1 = r20.getSelection()
            androidx.compose.ui.layout.LayoutCoordinates r2 = r0.containerLayoutCoordinates
            if (r1 == 0) goto L_0x0016
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r4 = r1.getStart()
            if (r4 == 0) goto L_0x0016
            r5 = 0
            androidx.compose.foundation.text.selection.Selectable r4 = r0.getAnchorSelectable$foundation_release(r4)
            goto L_0x0017
        L_0x0016:
            r4 = 0
        L_0x0017:
            if (r1 == 0) goto L_0x0025
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r5 = r1.getEnd()
            if (r5 == 0) goto L_0x0025
            r6 = 0
            androidx.compose.foundation.text.selection.Selectable r5 = r0.getAnchorSelectable$foundation_release(r5)
            goto L_0x0026
        L_0x0025:
            r5 = 0
        L_0x0026:
            if (r4 == 0) goto L_0x002d
            androidx.compose.ui.layout.LayoutCoordinates r6 = r4.getLayoutCoordinates()
            goto L_0x002e
        L_0x002d:
            r6 = 0
        L_0x002e:
            if (r5 == 0) goto L_0x0035
            androidx.compose.ui.layout.LayoutCoordinates r7 = r5.getLayoutCoordinates()
            goto L_0x0036
        L_0x0035:
            r7 = 0
        L_0x0036:
            if (r1 == 0) goto L_0x00c1
            if (r2 == 0) goto L_0x00be
            boolean r8 = r2.isAttached()
            if (r8 == 0) goto L_0x00bb
            if (r6 == 0) goto L_0x00b8
            if (r7 != 0) goto L_0x0049
            r18 = r1
            goto L_0x00c3
        L_0x0049:
            r8 = 1
            long r9 = r4.m1260getHandlePositiondBAh8RU(r1, r8)
            long r9 = r2.m4840localPositionOfR5De75A(r6, r9)
            r11 = 0
            long r12 = r5.m1260getHandlePositiondBAh8RU(r1, r11)
            long r12 = r2.m4840localPositionOfR5De75A(r7, r12)
            androidx.compose.ui.geometry.Rect r14 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r2)
            androidx.compose.ui.geometry.Offset r15 = androidx.compose.ui.geometry.Offset.m2904boximpl(r9)
            long r16 = r15.m2925unboximpl()
            r18 = 0
            boolean r19 = androidx.compose.foundation.text.selection.SelectionManagerKt.m1314containsInclusiveUv8p0NA(r14, r9)
            if (r19 != 0) goto L_0x0084
            androidx.compose.foundation.text.Handle r8 = r20.getDraggingHandle()
            androidx.compose.foundation.text.Handle r11 = androidx.compose.foundation.text.Handle.SelectionStart
            if (r8 != r11) goto L_0x0082
            goto L_0x0084
        L_0x0082:
            r8 = 0
            goto L_0x0085
        L_0x0084:
            r8 = 1
        L_0x0085:
            if (r8 == 0) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r15 = 0
        L_0x008a:
            r0.m1296setStartHandlePosition_kEHs6E(r15)
            androidx.compose.ui.geometry.Offset r8 = androidx.compose.ui.geometry.Offset.m2904boximpl(r12)
            long r15 = r8.m2925unboximpl()
            r11 = 0
            boolean r17 = androidx.compose.foundation.text.selection.SelectionManagerKt.m1314containsInclusiveUv8p0NA(r14, r12)
            if (r17 != 0) goto L_0x00aa
            androidx.compose.foundation.text.Handle r3 = r20.getDraggingHandle()
            r18 = r1
            androidx.compose.foundation.text.Handle r1 = androidx.compose.foundation.text.Handle.SelectionEnd
            if (r3 != r1) goto L_0x00a7
            goto L_0x00ac
        L_0x00a7:
            r19 = 0
            goto L_0x00ae
        L_0x00aa:
            r18 = r1
        L_0x00ac:
            r19 = 1
        L_0x00ae:
            if (r19 == 0) goto L_0x00b3
            r3 = r8
            goto L_0x00b4
        L_0x00b3:
            r3 = 0
        L_0x00b4:
            r0.m1295setEndHandlePosition_kEHs6E(r3)
            return
        L_0x00b8:
            r18 = r1
            goto L_0x00c3
        L_0x00bb:
            r18 = r1
            goto L_0x00c3
        L_0x00be:
            r18 = r1
            goto L_0x00c3
        L_0x00c1:
            r18 = r1
        L_0x00c3:
            r1 = 0
            r0.m1296setStartHandlePosition_kEHs6E(r1)
            r0.m1295setEndHandlePosition_kEHs6E(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.updateHandleOffsets():void");
    }

    public final LayoutCoordinates requireContainerCoordinates$foundation_release() {
        LayoutCoordinates coordinates = this.containerLayoutCoordinates;
        if (!(coordinates != null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (coordinates.isAttached()) {
            return coordinates;
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final Pair<Selection, Map<Long, Selection>> selectAll$foundation_release(long selectableId, Selection previousSelection) {
        HapticFeedback hapticFeedback;
        Object initial$iv;
        int $i$f$fastFold;
        Map subselections = new LinkedHashMap();
        List $this$fastFold$iv = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        Object initial$iv2 = null;
        int $i$f$fastFold2 = false;
        Selection selection = null;
        List $this$fastForEach$iv$iv = $this$fastFold$iv;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size) {
            Selectable selectable = (Selectable) $this$fastForEach$iv$iv.get(index$iv$iv);
            Selection mergedSelection = selection;
            List $this$fastFold$iv2 = $this$fastFold$iv;
            Selection selection2 = selectable.getSelectableId() == selectableId ? selectable.getSelectAllSelection() : null;
            if (selection2 != null) {
                initial$iv = initial$iv2;
                $i$f$fastFold = $i$f$fastFold2;
                subselections.put(Long.valueOf(selectable.getSelectableId()), selection2);
            } else {
                initial$iv = initial$iv2;
                $i$f$fastFold = $i$f$fastFold2;
            }
            selection = SelectionManagerKt.merge(mergedSelection, selection2);
            index$iv$iv++;
            $this$fastFold$iv = $this$fastFold$iv2;
            $i$f$fastFold2 = $i$f$fastFold;
            initial$iv2 = initial$iv;
        }
        Object obj = initial$iv2;
        int i = $i$f$fastFold2;
        Selection newSelection = selection;
        if (!Intrinsics.areEqual((Object) newSelection, (Object) previousSelection) && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.m3899performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m3908getTextHandleMove5zf0vsI());
        }
        return new Pair<>(newSelection, subselections);
    }

    public final AnnotatedString getSelectedText$foundation_release() {
        AnnotatedString annotatedString;
        List selectables = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        AnnotatedString annotatedString2 = null;
        Selection it = getSelection();
        if (it != null) {
            int size = selectables.size();
            for (int i = 0; i < size; i++) {
                Selectable selectable = selectables.get(i);
                if (selectable.getSelectableId() == it.getStart().getSelectableId() || selectable.getSelectableId() == it.getEnd().getSelectableId() || annotatedString2 != null) {
                    AnnotatedString currentSelectedText = SelectionManagerKt.getCurrentSelectedText(selectable, it);
                    if (annotatedString2 == null || (annotatedString = annotatedString2.plus(currentSelectedText)) == null) {
                        annotatedString = currentSelectedText;
                    }
                    annotatedString2 = annotatedString;
                    if (selectable.getSelectableId() == it.getEnd().getSelectableId()) {
                        if (!it.getHandlesCrossed()) {
                            break;
                        }
                    }
                    if (selectable.getSelectableId() == it.getStart().getSelectableId() && it.getHandlesCrossed()) {
                        break;
                    }
                }
            }
        }
        return annotatedString2;
    }

    public final void copy$foundation_release() {
        AnnotatedString selectedText = getSelectedText$foundation_release();
        if (selectedText != null) {
            AnnotatedString it = selectedText;
            ClipboardManager clipboardManager2 = this.clipboardManager;
            if (clipboardManager2 != null) {
                clipboardManager2.setText(it);
            }
        }
    }

    public final void showSelectionToolbar$foundation_release() {
        TextToolbar textToolbar2;
        if (getHasFocus() && getSelection() != null && (textToolbar2 = this.textToolbar) != null) {
            TextToolbar.showMenu$default(textToolbar2, getContentRect(), new SelectionManager$showSelectionToolbar$1$1(this), (Function0) null, (Function0) null, (Function0) null, 28, (Object) null);
        }
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar2;
        if (getHasFocus()) {
            TextToolbar textToolbar3 = this.textToolbar;
            if ((textToolbar3 != null ? textToolbar3.getStatus() : null) == TextToolbarStatus.Shown && (textToolbar2 = this.textToolbar) != null) {
                textToolbar2.hide();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateSelectionToolbarPosition() {
        if (getHasFocus()) {
            TextToolbar textToolbar2 = this.textToolbar;
            if ((textToolbar2 != null ? textToolbar2.getStatus() : null) == TextToolbarStatus.Shown) {
                showSelectionToolbar$foundation_release();
            }
        }
    }

    private final Rect getContentRect() {
        Selection selection = getSelection();
        if (selection == null) {
            return Rect.Companion.getZero();
        }
        Selectable startSelectable = getAnchorSelectable$foundation_release(selection.getStart());
        Selectable endSelectable = getAnchorSelectable$foundation_release(selection.getEnd());
        if (startSelectable != null) {
            LayoutCoordinates startLayoutCoordinates = startSelectable.getLayoutCoordinates();
            if (startLayoutCoordinates == null) {
                Selection selection2 = selection;
                Selectable selectable = startSelectable;
                Selectable selectable2 = endSelectable;
            } else {
                if (endSelectable != null) {
                    LayoutCoordinates endLayoutCoordinates = endSelectable.getLayoutCoordinates();
                    if (endLayoutCoordinates == null) {
                        Selection selection3 = selection;
                        Selectable selectable3 = startSelectable;
                        Selectable selectable4 = endSelectable;
                    } else {
                        LayoutCoordinates localLayoutCoordinates = this.containerLayoutCoordinates;
                        if (localLayoutCoordinates == null || !localLayoutCoordinates.isAttached()) {
                            Selectable selectable5 = startSelectable;
                            Selectable selectable6 = endSelectable;
                            return Rect.Companion.getZero();
                        }
                        long startOffset = localLayoutCoordinates.m4840localPositionOfR5De75A(startLayoutCoordinates, startSelectable.m1260getHandlePositiondBAh8RU(selection, true));
                        long endOffset = localLayoutCoordinates.m4840localPositionOfR5De75A(endLayoutCoordinates, endSelectable.m1260getHandlePositiondBAh8RU(selection, false));
                        long startOffset2 = localLayoutCoordinates.m4841localToRootMKHz9U(startOffset);
                        long endOffset2 = localLayoutCoordinates.m4841localToRootMKHz9U(endOffset);
                        float left = Math.min(Offset.m2915getXimpl(startOffset2), Offset.m2915getXimpl(endOffset2));
                        float right = Math.max(Offset.m2915getXimpl(startOffset2), Offset.m2915getXimpl(endOffset2));
                        float left2 = left;
                        long startTop = localLayoutCoordinates.m4840localPositionOfR5De75A(startLayoutCoordinates, OffsetKt.Offset(0.0f, startSelectable.getBoundingBox(selection.getStart().getOffset()).getTop()));
                        long endTop = localLayoutCoordinates.m4840localPositionOfR5De75A(endLayoutCoordinates, OffsetKt.Offset(0.0f, endSelectable.getBoundingBox(selection.getEnd().getOffset()).getTop()));
                        Selection selection4 = selection;
                        Selectable selectable7 = startSelectable;
                        Selectable selectable8 = endSelectable;
                        return new Rect(left2, Math.min(Offset.m2916getYimpl(localLayoutCoordinates.m4841localToRootMKHz9U(startTop)), Offset.m2916getYimpl(localLayoutCoordinates.m4841localToRootMKHz9U(endTop))), right, Math.max(Offset.m2916getYimpl(startOffset2), Offset.m2916getYimpl(endOffset2)) + ((float) (((double) SelectionHandlesKt.getHandleHeight()) * 4.0d)));
                    }
                } else {
                    Selectable selectable9 = startSelectable;
                    Selectable selectable10 = endSelectable;
                }
                return Rect.Companion.getZero();
            }
        } else {
            Selectable selectable11 = startSelectable;
            Selectable selectable12 = endSelectable;
        }
        return Rect.Companion.getZero();
    }

    public final void onRelease() {
        this.selectionRegistrar.setSubselections(MapsKt.emptyMap());
        hideSelectionToolbar$foundation_release();
        if (getSelection() != null) {
            this.onSelectionChange.invoke(null);
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.m3899performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m3908getTextHandleMove5zf0vsI());
            }
        }
    }

    public final TextDragObserver handleDragObserver(boolean isStartHandle) {
        return new SelectionManager$handleDragObserver$1(this, isStartHandle);
    }

    /* access modifiers changed from: private */
    public final Object detectNonConsumingTap(PointerInputScope $this$detectNonConsumingTap, Function1<? super Offset, Unit> onTap, Continuation<? super Unit> $completion) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectNonConsumingTap, new SelectionManager$detectNonConsumingTap$2(onTap, (Continuation<? super SelectionManager$detectNonConsumingTap$2>) null), $completion);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    private final Modifier onClearSelectionRequested(Modifier $this$onClearSelectionRequested, Function0<Unit> block) {
        return getHasFocus() ? SuspendingPointerInputFilterKt.pointerInput($this$onClearSelectionRequested, (Object) Unit.INSTANCE, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SelectionManager$onClearSelectionRequested$1(this, block, (Continuation<? super SelectionManager$onClearSelectionRequested$1>) null)) : $this$onClearSelectionRequested;
    }

    /* access modifiers changed from: private */
    /* renamed from: convertToContainerCoordinates-Q7Q5hAU  reason: not valid java name */
    public final Offset m1291convertToContainerCoordinatesQ7Q5hAU(LayoutCoordinates layoutCoordinates, long offset) {
        LayoutCoordinates coordinates = this.containerLayoutCoordinates;
        if (coordinates == null || !coordinates.isAttached()) {
            return null;
        }
        return Offset.m2904boximpl(requireContainerCoordinates$foundation_release().m4840localPositionOfR5De75A(layoutCoordinates, offset));
    }

    /* access modifiers changed from: private */
    /* renamed from: startSelection-9KIMszo  reason: not valid java name */
    public final void m1297startSelection9KIMszo(long position, boolean isStartHandle, SelectionAdjustment adjustment) {
        m1304updateSelection3R_tFg$foundation_release(position, position, (Offset) null, isStartHandle, adjustment);
    }

    /* renamed from: updateSelection-RHHTvR4$foundation_release  reason: not valid java name */
    public final boolean m1305updateSelectionRHHTvR4$foundation_release(Offset newPosition, Offset previousPosition2, boolean isStartHandle, SelectionAdjustment adjustment) {
        Selection selection;
        long otherSelectableId;
        Offset offset;
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        if (!(newPosition == null || (selection = getSelection()) == null)) {
            if (isStartHandle) {
                otherSelectableId = selection.getEnd().getSelectableId();
            } else {
                otherSelectableId = selection.getStart().getSelectableId();
            }
            Selectable otherSelectable = this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(otherSelectableId));
            if (otherSelectable == null) {
                offset = null;
            } else {
                LayoutCoordinates layoutCoordinates = otherSelectable.getLayoutCoordinates();
                Intrinsics.checkNotNull(layoutCoordinates);
                offset = m1291convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, SelectionHandlesKt.m1278getAdjustedCoordinatesk4lQ0M(otherSelectable.m1260getHandlePositiondBAh8RU(selection, !isStartHandle)));
            }
            if (offset != null) {
                long otherHandlePosition = offset.m2925unboximpl();
                return m1304updateSelection3R_tFg$foundation_release(isStartHandle ? newPosition.m2925unboximpl() : otherHandlePosition, isStartHandle ? otherHandlePosition : newPosition.m2925unboximpl(), previousPosition2, isStartHandle, adjustment);
            }
        }
        return false;
    }

    /* renamed from: updateSelection-3R_-tFg$foundation_release  reason: not valid java name */
    public final boolean m1304updateSelection3R_tFg$foundation_release(long startHandlePosition, long endHandlePosition, Offset previousHandlePosition, boolean isStartHandle, SelectionAdjustment adjustment) {
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        setDraggingHandle(isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
        m1292setCurrentDragPosition_kEHs6E(isStartHandle ? Offset.m2904boximpl(startHandlePosition) : Offset.m2904boximpl(endHandlePosition));
        Map newSubselections = new LinkedHashMap();
        List $this$fastForEach$iv$iv = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = $this$fastForEach$iv$iv.size();
        boolean moveConsumed = false;
        Selection mergedSelection = null;
        int index$iv$iv = 0;
        while (index$iv$iv < size) {
            Selectable selectable = (Selectable) $this$fastForEach$iv$iv.get(index$iv$iv);
            Selection mergedSelection2 = mergedSelection;
            int index$iv$iv2 = index$iv$iv;
            int i = size;
            List $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
            Pair<Selection, Boolean> r1 = selectable.m1262updateSelectionqCDeeow(startHandlePosition, endHandlePosition, previousHandlePosition, isStartHandle, requireContainerCoordinates$foundation_release(), adjustment, this.selectionRegistrar.getSubselections().get(Long.valueOf(selectable.getSelectableId())));
            Selection selection = r1.component1();
            moveConsumed = moveConsumed || r1.component2().booleanValue();
            if (selection != null) {
                newSubselections.put(Long.valueOf(selectable.getSelectableId()), selection);
            }
            mergedSelection = SelectionManagerKt.merge(mergedSelection2, selection);
            index$iv$iv = index$iv$iv2 + 1;
            SelectionAdjustment selectionAdjustment = adjustment;
            $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
            size = i;
        }
        int i2 = index$iv$iv;
        List list = $this$fastForEach$iv$iv;
        Selection newSelection = mergedSelection;
        if (!Intrinsics.areEqual((Object) newSelection, (Object) getSelection())) {
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.m3899performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m3908getTextHandleMove5zf0vsI());
            }
            this.selectionRegistrar.setSubselections(newSubselections);
            this.onSelectionChange.invoke(newSelection);
        }
        return moveConsumed;
    }

    /* renamed from: contextMenuOpenAdjustment-k-4lQ0M  reason: not valid java name */
    public final void m1298contextMenuOpenAdjustmentk4lQ0M(long position) {
        Selection selection = getSelection();
        if (selection != null ? TextRange.m5468getCollapsedimpl(selection.m1263toTextRanged9O1mEE()) : true) {
            m1297startSelection9KIMszo(position, true, SelectionAdjustment.Companion.getWord());
        }
    }
}
