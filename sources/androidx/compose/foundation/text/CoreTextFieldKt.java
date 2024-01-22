package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aî\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001323\b\u0002\u0010\u001d\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001fH\u0001¢\u0006\u0002\u0010#\u001a0\u0010$\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001fH\u0003¢\u0006\u0002\u0010(\u001a\u001d\u0010)\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010+\u001a\u0015\u0010,\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\u0010-\u001a \u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00101\u001a\u000202H\u0002\u001a0\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u0002052\u0006\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00101\u001a\u000202H\u0002\u001a\u0010\u00106\u001a\u00020\u00012\u0006\u0010/\u001a\u000200H\u0002\u001a \u00107\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0013H\u0002\u001a5\u0010;\u001a\u00020\u0001*\u00020<2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\r2\u0006\u00101\u001a\u000202H@ø\u0001\u0000¢\u0006\u0002\u0010@\u001a\u001c\u0010A\u001a\u00020\u0007*\u00020\u00072\u0006\u0010/\u001a\u0002002\u0006\u0010%\u001a\u00020&H\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "notifyFocusedRect", "state", "Landroidx/compose/foundation/text/TextFieldState;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "notifyTextInputServiceOnFocusChange", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "onBlur", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewKeyEventToDeselectOnBack", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
public final class CoreTextFieldKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v0, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v1, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r69v1, resolved type: androidx.compose.runtime.saveable.Saver<androidx.compose.foundation.text.TextFieldScrollerPosition, java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: androidx.compose.ui.text.input.TransformedText} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r43v1, resolved type: androidx.compose.ui.text.input.TransformedText} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v92, resolved type: androidx.compose.ui.text.input.TransformedText} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: androidx.compose.ui.text.input.TextInputService} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: androidx.compose.ui.focus.FocusRequester} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v2, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v3, resolved type: kotlin.jvm.functions.Function3<kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v4, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v5, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x0544, code lost:
        if (r2 == null) goto L_0x054d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x0590  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x05d1  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x0634  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x064d  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0692  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x06a2  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x0758  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x0777  */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x07b1  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x07bc  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x080e  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0844  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0935  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0938  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x0999  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x09a4  */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x09fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CoreTextField(androidx.compose.ui.text.input.TextFieldValue r66, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r67, androidx.compose.ui.Modifier r68, androidx.compose.ui.text.TextStyle r69, androidx.compose.ui.text.input.VisualTransformation r70, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r71, androidx.compose.foundation.interaction.MutableInteractionSource r72, androidx.compose.ui.graphics.Brush r73, boolean r74, int r75, int r76, androidx.compose.ui.text.input.ImeOptions r77, androidx.compose.foundation.text.KeyboardActions r78, boolean r79, boolean r80, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r81, androidx.compose.runtime.Composer r82, int r83, int r84, int r85) {
        /*
            r15 = r66
            r14 = r67
            r13 = r83
            r12 = r84
            r11 = r85
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -958708118(0xffffffffc6db466a, float:-28067.207)
            r1 = r82
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(CoreTextField)P(14,10,8,13,15,9,4!1,12,6,7,3,5,2,11)199@11108L29,204@11381L7,205@11442L7,206@11510L7,207@11575L7,215@11884L42,212@11791L135,218@11967L268,230@12540L21,231@12578L324,259@13301L26,262@13387L51,268@13690L7,269@13741L7,270@13798L7,274@13909L24,275@13967L37,512@23161L86,516@23253L515,563@24957L4554:CoreTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r83
            r2 = r84
            r3 = r11 & 1
            if (r3 == 0) goto L_0x002f
            r1 = r1 | 6
            goto L_0x003d
        L_0x002f:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x003d
            boolean r3 = r10.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x003b
            r3 = 4
            goto L_0x003c
        L_0x003b:
            r3 = 2
        L_0x003c:
            r1 = r1 | r3
        L_0x003d:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x0044
            r1 = r1 | 48
            goto L_0x0054
        L_0x0044:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0054
            boolean r3 = r10.changedInstance(r14)
            if (r3 == 0) goto L_0x0051
            r3 = 32
            goto L_0x0053
        L_0x0051:
            r3 = 16
        L_0x0053:
            r1 = r1 | r3
        L_0x0054:
            r3 = r11 & 4
            if (r3 == 0) goto L_0x005d
            r1 = r1 | 384(0x180, float:5.38E-43)
            r4 = r68
            goto L_0x0073
        L_0x005d:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0071
            r4 = r68
            boolean r16 = r10.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x006c
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r16 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r1 = r1 | r16
            goto L_0x0073
        L_0x0071:
            r4 = r68
        L_0x0073:
            r16 = r11 & 8
            r17 = 1024(0x400, float:1.435E-42)
            r18 = 2048(0x800, float:2.87E-42)
            if (r16 == 0) goto L_0x0080
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r6 = r69
            goto L_0x0096
        L_0x0080:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0094
            r6 = r69
            boolean r20 = r10.changed((java.lang.Object) r6)
            if (r20 == 0) goto L_0x008f
            r20 = r18
            goto L_0x0091
        L_0x008f:
            r20 = r17
        L_0x0091:
            r1 = r1 | r20
            goto L_0x0096
        L_0x0094:
            r6 = r69
        L_0x0096:
            r20 = r11 & 16
            r21 = 16384(0x4000, float:2.2959E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            if (r20 == 0) goto L_0x00a3
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r7 = r70
            goto L_0x00bc
        L_0x00a3:
            r23 = 57344(0xe000, float:8.0356E-41)
            r23 = r13 & r23
            if (r23 != 0) goto L_0x00ba
            r7 = r70
            boolean r24 = r10.changed((java.lang.Object) r7)
            if (r24 == 0) goto L_0x00b5
            r24 = r21
            goto L_0x00b7
        L_0x00b5:
            r24 = r22
        L_0x00b7:
            r1 = r1 | r24
            goto L_0x00bc
        L_0x00ba:
            r7 = r70
        L_0x00bc:
            r24 = r11 & 32
            if (r24 == 0) goto L_0x00c7
            r25 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r25
            r8 = r71
            goto L_0x00df
        L_0x00c7:
            r25 = 458752(0x70000, float:6.42848E-40)
            r25 = r13 & r25
            if (r25 != 0) goto L_0x00dd
            r8 = r71
            boolean r26 = r10.changedInstance(r8)
            if (r26 == 0) goto L_0x00d8
            r26 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00da
        L_0x00d8:
            r26 = 65536(0x10000, float:9.18355E-41)
        L_0x00da:
            r1 = r1 | r26
            goto L_0x00df
        L_0x00dd:
            r8 = r71
        L_0x00df:
            r26 = r11 & 64
            if (r26 == 0) goto L_0x00ea
            r27 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r27
            r9 = r72
            goto L_0x0102
        L_0x00ea:
            r27 = 3670016(0x380000, float:5.142788E-39)
            r27 = r13 & r27
            if (r27 != 0) goto L_0x0100
            r9 = r72
            boolean r28 = r10.changed((java.lang.Object) r9)
            if (r28 == 0) goto L_0x00fb
            r28 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fd
        L_0x00fb:
            r28 = 524288(0x80000, float:7.34684E-40)
        L_0x00fd:
            r1 = r1 | r28
            goto L_0x0102
        L_0x0100:
            r9 = r72
        L_0x0102:
            r5 = r11 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x010d
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r29
            r0 = r73
            goto L_0x0125
        L_0x010d:
            r29 = 29360128(0x1c00000, float:7.052966E-38)
            r29 = r13 & r29
            if (r29 != 0) goto L_0x0123
            r0 = r73
            boolean r30 = r10.changed((java.lang.Object) r0)
            if (r30 == 0) goto L_0x011e
            r30 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0120
        L_0x011e:
            r30 = 4194304(0x400000, float:5.877472E-39)
        L_0x0120:
            r1 = r1 | r30
            goto L_0x0125
        L_0x0123:
            r0 = r73
        L_0x0125:
            r0 = r11 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0130
            r30 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r30
            r4 = r74
            goto L_0x0148
        L_0x0130:
            r30 = 234881024(0xe000000, float:1.5777218E-30)
            r30 = r13 & r30
            if (r30 != 0) goto L_0x0146
            r4 = r74
            boolean r30 = r10.changed((boolean) r4)
            if (r30 == 0) goto L_0x0141
            r30 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0143
        L_0x0141:
            r30 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0143:
            r1 = r1 | r30
            goto L_0x0148
        L_0x0146:
            r4 = r74
        L_0x0148:
            r4 = r11 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0153
            r30 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r30
            r6 = r75
            goto L_0x016b
        L_0x0153:
            r30 = 1879048192(0x70000000, float:1.58456325E29)
            r30 = r13 & r30
            if (r30 != 0) goto L_0x0169
            r6 = r75
            boolean r30 = r10.changed((int) r6)
            if (r30 == 0) goto L_0x0164
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0166
        L_0x0164:
            r30 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0166:
            r1 = r1 | r30
            goto L_0x016b
        L_0x0169:
            r6 = r75
        L_0x016b:
            r6 = r11 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x0174
            r2 = r2 | 6
            r7 = r76
            goto L_0x018a
        L_0x0174:
            r30 = r12 & 14
            if (r30 != 0) goto L_0x0188
            r7 = r76
            boolean r30 = r10.changed((int) r7)
            if (r30 == 0) goto L_0x0183
            r30 = 4
            goto L_0x0185
        L_0x0183:
            r30 = 2
        L_0x0185:
            r2 = r2 | r30
            goto L_0x018a
        L_0x0188:
            r7 = r76
        L_0x018a:
            r30 = r12 & 112(0x70, float:1.57E-43)
            if (r30 != 0) goto L_0x01a4
            r7 = r11 & 2048(0x800, float:2.87E-42)
            if (r7 != 0) goto L_0x019d
            r7 = r77
            boolean r30 = r10.changed((java.lang.Object) r7)
            if (r30 == 0) goto L_0x019f
            r19 = 32
            goto L_0x01a1
        L_0x019d:
            r7 = r77
        L_0x019f:
            r19 = 16
        L_0x01a1:
            r2 = r2 | r19
            goto L_0x01a6
        L_0x01a4:
            r7 = r77
        L_0x01a6:
            r7 = r11 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x01af
            r2 = r2 | 384(0x180, float:5.38E-43)
            r8 = r78
            goto L_0x01c5
        L_0x01af:
            r8 = r12 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x01c3
            r8 = r78
            boolean r19 = r10.changed((java.lang.Object) r8)
            if (r19 == 0) goto L_0x01be
            r25 = 256(0x100, float:3.59E-43)
            goto L_0x01c0
        L_0x01be:
            r25 = 128(0x80, float:1.794E-43)
        L_0x01c0:
            r2 = r2 | r25
            goto L_0x01c5
        L_0x01c3:
            r8 = r78
        L_0x01c5:
            r8 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r8 == 0) goto L_0x01ce
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r9 = r79
            goto L_0x01e1
        L_0x01ce:
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x01df
            r9 = r79
            boolean r19 = r10.changed((boolean) r9)
            if (r19 == 0) goto L_0x01dc
            r17 = r18
        L_0x01dc:
            r2 = r2 | r17
            goto L_0x01e1
        L_0x01df:
            r9 = r79
        L_0x01e1:
            r9 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r9 == 0) goto L_0x01ea
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r14 = r80
            goto L_0x0201
        L_0x01ea:
            r17 = 57344(0xe000, float:8.0356E-41)
            r17 = r12 & r17
            if (r17 != 0) goto L_0x01ff
            r14 = r80
            boolean r17 = r10.changed((boolean) r14)
            if (r17 == 0) goto L_0x01fa
            goto L_0x01fc
        L_0x01fa:
            r21 = r22
        L_0x01fc:
            r2 = r2 | r21
            goto L_0x0201
        L_0x01ff:
            r14 = r80
        L_0x0201:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r11 & r17
            if (r17 == 0) goto L_0x020f
            r18 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r18
            r12 = r81
            goto L_0x0227
        L_0x020f:
            r18 = 458752(0x70000, float:6.42848E-40)
            r18 = r12 & r18
            if (r18 != 0) goto L_0x0225
            r12 = r81
            boolean r18 = r10.changedInstance(r12)
            if (r18 == 0) goto L_0x0220
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0222
        L_0x0220:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x0222:
            r2 = r2 | r18
            goto L_0x0227
        L_0x0225:
            r12 = r81
        L_0x0227:
            r18 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r12 = r1 & r18
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r12 != r14) goto L_0x0267
            r12 = 374491(0x5b6db, float:5.24774E-40)
            r12 = r12 & r2
            r14 = 74898(0x12492, float:1.04954E-40)
            if (r12 != r14) goto L_0x0267
            boolean r12 = r10.getSkipping()
            if (r12 != 0) goto L_0x0241
            goto L_0x0267
        L_0x0241:
            r10.skipToGroupEnd()
            r63 = r68
            r30 = r69
            r55 = r70
            r31 = r71
            r20 = r72
            r32 = r73
            r33 = r74
            r53 = r75
            r34 = r76
            r57 = r77
            r35 = r78
            r54 = r79
            r36 = r80
            r37 = r81
            r48 = r1
            r52 = r2
            r6 = r10
            goto L_0x0a01
        L_0x0267:
            r10.startDefaults()
            r12 = r13 & 1
            r14 = 0
            if (r12 == 0) goto L_0x029e
            boolean r12 = r10.getDefaultsInvalid()
            if (r12 == 0) goto L_0x0276
            goto L_0x029e
        L_0x0276:
            r10.skipToGroupEnd()
            r0 = r11 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x027f
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
        L_0x027f:
            r13 = r68
            r30 = r69
            r12 = r70
            r31 = r71
            r9 = r72
            r32 = r73
            r33 = r74
            r8 = r75
            r34 = r76
            r7 = r77
            r35 = r78
            r6 = r79
            r36 = r80
            r37 = r81
            r5 = r2
            goto L_0x0358
        L_0x029e:
            if (r3 == 0) goto L_0x02a5
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x02a7
        L_0x02a5:
            r3 = r68
        L_0x02a7:
            if (r16 == 0) goto L_0x02b0
            androidx.compose.ui.text.TextStyle$Companion r12 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r12 = r12.getDefault()
            goto L_0x02b2
        L_0x02b0:
            r12 = r69
        L_0x02b2:
            if (r20 == 0) goto L_0x02bb
            androidx.compose.ui.text.input.VisualTransformation$Companion r16 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r16 = r16.getNone()
            goto L_0x02bd
        L_0x02bb:
            r16 = r70
        L_0x02bd:
            if (r24 == 0) goto L_0x02c4
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1 r18 = androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1.INSTANCE
            kotlin.jvm.functions.Function1 r18 = (kotlin.jvm.functions.Function1) r18
            goto L_0x02c6
        L_0x02c4:
            r18 = r71
        L_0x02c6:
            if (r26 == 0) goto L_0x02cb
            r19 = 0
            goto L_0x02cd
        L_0x02cb:
            r19 = r72
        L_0x02cd:
            if (r5 == 0) goto L_0x02df
            androidx.compose.ui.graphics.SolidColor r5 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r20 = androidx.compose.ui.graphics.Color.Companion
            r68 = r12
            long r12 = r20.m3200getUnspecified0d7_KjU()
            r5.<init>(r12, r14)
            androidx.compose.ui.graphics.Brush r5 = (androidx.compose.ui.graphics.Brush) r5
            goto L_0x02e3
        L_0x02df:
            r68 = r12
            r5 = r73
        L_0x02e3:
            if (r0 == 0) goto L_0x02e7
            r0 = 1
            goto L_0x02e9
        L_0x02e7:
            r0 = r74
        L_0x02e9:
            if (r4 == 0) goto L_0x02ef
            r4 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x02f1
        L_0x02ef:
            r4 = r75
        L_0x02f1:
            if (r6 == 0) goto L_0x02f5
            r6 = 1
            goto L_0x02f7
        L_0x02f5:
            r6 = r76
        L_0x02f7:
            r12 = r11 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x0304
            androidx.compose.ui.text.input.ImeOptions$Companion r12 = androidx.compose.ui.text.input.ImeOptions.Companion
            androidx.compose.ui.text.input.ImeOptions r12 = r12.getDefault()
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x0306
        L_0x0304:
            r12 = r77
        L_0x0306:
            if (r7 == 0) goto L_0x030f
            androidx.compose.foundation.text.KeyboardActions$Companion r7 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r7 = r7.getDefault()
            goto L_0x0311
        L_0x030f:
            r7 = r78
        L_0x0311:
            if (r8 == 0) goto L_0x0315
            r8 = 1
            goto L_0x0317
        L_0x0315:
            r8 = r79
        L_0x0317:
            if (r9 == 0) goto L_0x031b
            r9 = 0
            goto L_0x031d
        L_0x031b:
            r9 = r80
        L_0x031d:
            if (r17 == 0) goto L_0x033f
            androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt r13 = androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r13 = r13.m1137getLambda1$foundation_release()
            r30 = r68
            r33 = r0
            r32 = r5
            r34 = r6
            r35 = r7
            r6 = r8
            r36 = r9
            r7 = r12
            r37 = r13
            r12 = r16
            r31 = r18
            r9 = r19
            r5 = r2
            r13 = r3
            r8 = r4
            goto L_0x0358
        L_0x033f:
            r30 = r68
            r37 = r81
            r33 = r0
            r13 = r3
            r32 = r5
            r34 = r6
            r35 = r7
            r6 = r8
            r36 = r9
            r7 = r12
            r12 = r16
            r31 = r18
            r9 = r19
            r5 = r2
            r8 = r4
        L_0x0358:
            r10.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0369
            java.lang.String r0 = "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:180)"
            r2 = -958708118(0xffffffffc6db466a, float:-28067.207)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r5, r0)
        L_0x0369:
            r4 = 0
            r0 = r4
            r2 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r3)
            java.lang.String r14 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            r16 = 0
            r68 = r10
            r17 = 0
            java.lang.Object r3 = r68.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r19.getEmpty()
            if (r3 != r4) goto L_0x039d
            r4 = 0
            androidx.compose.ui.focus.FocusRequester r19 = new androidx.compose.ui.focus.FocusRequester
            r19.<init>()
            r4 = r19
            r69 = r0
            r0 = r68
            r0.updateRememberedValue(r4)
            goto L_0x03a2
        L_0x039d:
            r69 = r0
            r0 = r68
            r4 = r3
        L_0x03a2:
            r10.endReplaceableGroup()
            androidx.compose.ui.focus.FocusRequester r4 = (androidx.compose.ui.focus.FocusRequester) r4
            r0 = -55012947(0xfffffffffcb891ad, float:-7.666698E36)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "203@11342L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            java.lang.String r0 = "CC:CompositionLocal.kt#9igjgp"
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            if (r6 == 0) goto L_0x03d7
            if (r36 == 0) goto L_0x03be
            goto L_0x03d7
        L_0x03be:
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalTextInputService()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r16 = 0
            r17 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r2, r0)
            java.lang.Object r18 = r10.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r3 = r18
            androidx.compose.ui.text.input.TextInputService r3 = (androidx.compose.ui.text.input.TextInputService) r3
            goto L_0x03d8
        L_0x03d7:
            r3 = 0
        L_0x03d8:
            r10.endReplaceableGroup()
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r2 = r16
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r16 = 0
            r18 = 0
            r19 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r0)
            java.lang.Object r5 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r38 = r5
            androidx.compose.ui.unit.Density r38 = (androidx.compose.ui.unit.Density) r38
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r5 = 0
            r16 = 0
            r68 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r0)
            java.lang.Object r5 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r39 = r5
            androidx.compose.ui.text.font.FontFamily$Resolver r39 = (androidx.compose.ui.text.font.FontFamily.Resolver) r39
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r5 = 6
            r16 = 0
            r68 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r0)
            java.lang.Object r5 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.foundation.text.selection.TextSelectionColors r5 = (androidx.compose.foundation.text.selection.TextSelectionColors) r5
            long r40 = r5.m1357getBackgroundColor0d7_KjU()
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r5 = 0
            r16 = 0
            r68 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r0)
            java.lang.Object r5 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.focus.FocusManager r5 = (androidx.compose.ui.focus.FocusManager) r5
            r2 = 1
            if (r8 != r2) goto L_0x045c
            if (r33 != 0) goto L_0x045c
            boolean r16 = r7.getSingleLine()
            if (r16 == 0) goto L_0x045c
            r16 = r2
            goto L_0x045e
        L_0x045c:
            r16 = 0
        L_0x045e:
            r42 = r16
            if (r42 == 0) goto L_0x0465
            androidx.compose.foundation.gestures.Orientation r16 = androidx.compose.foundation.gestures.Orientation.Horizontal
            goto L_0x0467
        L_0x0465:
            androidx.compose.foundation.gestures.Orientation r16 = androidx.compose.foundation.gestures.Orientation.Vertical
        L_0x0467:
            r43 = r16
            java.lang.Object[] r16 = new java.lang.Object[]{r43}
            androidx.compose.foundation.text.TextFieldScrollerPosition$Companion r18 = androidx.compose.foundation.text.TextFieldScrollerPosition.Companion
            androidx.compose.runtime.saveable.Saver r18 = r18.getSaver()
            r20 = 0
            r21 = 0
            r22 = r21
            r21 = 0
            r2 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            r2 = r43
            boolean r24 = r10.changed((java.lang.Object) r2)
            r68 = r10
            r25 = 0
            r26 = r8
            java.lang.Object r8 = r68.rememberedValue()
            r27 = 0
            if (r24 != 0) goto L_0x04a8
            androidx.compose.runtime.Composer$Companion r29 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r29.getEmpty()
            if (r8 != r11) goto L_0x04a3
            goto L_0x04a8
        L_0x04a3:
            r11 = r68
            r69 = r8
            goto L_0x04b9
        L_0x04a8:
            r11 = 0
            r69 = r8
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1 r8 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
            r8.<init>(r2)
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r11 = r68
            r11.updateRememberedValue(r8)
        L_0x04b9:
            r10.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r11 = 72
            r21 = 4
            r68 = r16
            r69 = r18
            r70 = r20
            r71 = r8
            r72 = r10
            r73 = r11
            r74 = r21
            java.lang.Object r8 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r68, r69, (java.lang.String) r70, r71, (androidx.compose.runtime.Composer) r72, (int) r73, (int) r74)
            r11 = r8
            androidx.compose.foundation.text.TextFieldScrollerPosition r11 = (androidx.compose.foundation.text.TextFieldScrollerPosition) r11
            r8 = r1 & 14
            int r16 = r1 >> 9
            r16 = r16 & 112(0x70, float:1.57E-43)
            r8 = r8 | r16
            r16 = 0
            r18 = r1
            r1 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            boolean r1 = r10.changed((java.lang.Object) r15)
            boolean r20 = r10.changed((java.lang.Object) r12)
            r1 = r1 | r20
            r68 = r10
            r20 = 0
            r21 = r2
            java.lang.Object r2 = r68.rememberedValue()
            r22 = 0
            if (r1 != 0) goto L_0x051f
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r69 = r1
            java.lang.Object r1 = r24.getEmpty()
            if (r2 != r1) goto L_0x0514
            goto L_0x0521
        L_0x0514:
            r72 = r2
            r1 = r72
            r71 = r8
            r25 = r9
            r2 = r68
            goto L_0x0556
        L_0x051f:
            r69 = r1
        L_0x0521:
            r1 = 0
            r70 = r1
            androidx.compose.ui.text.AnnotatedString r1 = r66.getAnnotatedString()
            androidx.compose.ui.text.input.TransformedText r1 = androidx.compose.foundation.text.ValidatingOffsetMappingKt.filterWithValidation(r12, r1)
            androidx.compose.ui.text.TextRange r24 = r66.m5694getCompositionMzsxiRA()
            if (r24 == 0) goto L_0x0547
            r71 = r8
            r25 = r9
            long r8 = r24.m5478unboximpl()
            r24 = 0
            r72 = r2
            androidx.compose.foundation.text.TextFieldDelegate$Companion r2 = androidx.compose.foundation.text.TextFieldDelegate.Companion
            androidx.compose.ui.text.input.TransformedText r2 = r2.m1208applyCompositionDecoration72CqOWE(r8, r1)
            if (r2 != 0) goto L_0x054e
            goto L_0x054d
        L_0x0547:
            r72 = r2
            r71 = r8
            r25 = r9
        L_0x054d:
            r2 = r1
        L_0x054e:
            r1 = r2
            r2 = r68
            r2.updateRememberedValue(r1)
        L_0x0556:
            r10.endReplaceableGroup()
            r43 = r1
            androidx.compose.ui.text.input.TransformedText r43 = (androidx.compose.ui.text.input.TransformedText) r43
            androidx.compose.ui.text.AnnotatedString r44 = r43.getText()
            androidx.compose.ui.text.input.OffsetMapping r9 = r43.getOffsetMapping()
            r1 = 0
            androidx.compose.runtime.RecomposeScope r8 = androidx.compose.runtime.ComposablesKt.getCurrentRecomposeScope(r10, r1)
            r2 = r1
            r1 = 0
            r16 = r1
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            r1 = 0
            r20 = r10
            r22 = 0
            r24 = r1
            java.lang.Object r1 = r20.rememberedValue()
            r27 = 0
            androidx.compose.runtime.Composer$Companion r29 = androidx.compose.runtime.Composer.Companion
            r45 = r2
            java.lang.Object r2 = r29.getEmpty()
            if (r1 != r2) goto L_0x05d1
            r2 = 0
            r29 = r1
            androidx.compose.foundation.text.TextFieldState r1 = new androidx.compose.foundation.text.TextFieldState
            r46 = r2
            androidx.compose.foundation.text.TextDelegate r2 = new androidx.compose.foundation.text.TextDelegate
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 300(0x12c, float:4.2E-43)
            r52 = 0
            r68 = r2
            r69 = r44
            r70 = r30
            r71 = r47
            r72 = r48
            r73 = r33
            r74 = r49
            r75 = r38
            r76 = r39
            r77 = r50
            r78 = r51
            r79 = r52
            r68.<init>(r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79)
            r1.<init>(r2, r8)
            r2 = r20
            r2.updateRememberedValue(r1)
            goto L_0x05d5
        L_0x05d1:
            r29 = r1
            r2 = r20
        L_0x05d5:
            r10.endReplaceableGroup()
            r2 = r1
            androidx.compose.foundation.text.TextFieldState r2 = (androidx.compose.foundation.text.TextFieldState) r2
            androidx.compose.ui.text.AnnotatedString r1 = r66.getAnnotatedString()
            r68 = r2
            r69 = r1
            r70 = r44
            r71 = r30
            r72 = r33
            r73 = r38
            r74 = r39
            r75 = r67
            r76 = r35
            r77 = r5
            r78 = r40
            r68.m1226updatefnh65Uc(r69, r70, r71, r72, r73, r74, r75, r76, r77, r78)
            androidx.compose.ui.text.input.EditProcessor r1 = r2.getProcessor()
            androidx.compose.ui.text.input.TextInputSession r5 = r2.getInputSession()
            r1.reset(r15, r5)
            r1 = 0
            r5 = r1
            r1 = 0
            r68 = r1
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            r1 = 0
            r69 = r10
            r16 = 0
            r70 = r1
            java.lang.Object r1 = r69.rememberedValue()
            r20 = 0
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r71 = r5
            java.lang.Object r5 = r22.getEmpty()
            if (r1 != r5) goto L_0x064d
            r5 = 0
            r72 = r1
            androidx.compose.foundation.text.UndoManager r1 = new androidx.compose.foundation.text.UndoManager
            r73 = r5
            r78 = r8
            r79 = r11
            r5 = 0
            r8 = 0
            r11 = 1
            r1.<init>(r8, r11, r5)
            r5 = r69
            r5.updateRememberedValue(r1)
            goto L_0x0656
        L_0x064d:
            r5 = r69
            r72 = r1
            r78 = r8
            r79 = r11
            r11 = 1
        L_0x0656:
            r10.endReplaceableGroup()
            r8 = r1
            androidx.compose.foundation.text.UndoManager r8 = (androidx.compose.foundation.text.UndoManager) r8
            r22 = 0
            r1 = 2
            r5 = 0
            r68 = r8
            r69 = r66
            r70 = r22
            r72 = r1
            r73 = r5
            androidx.compose.foundation.text.UndoManager.snapshotIfNeeded$default(r68, r69, r70, r72, r73)
            r1 = 0
            r5 = r1
            r1 = 0
            r11 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            r11 = 0
            r68 = r10
            r16 = 0
            r69 = r1
            java.lang.Object r1 = r68.rememberedValue()
            r20 = 0
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r70 = r5
            java.lang.Object r5 = r22.getEmpty()
            if (r1 != r5) goto L_0x06a2
            r5 = 0
            r71 = r1
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r1 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager
            r1.<init>(r8)
            r5 = r68
            r5.updateRememberedValue(r1)
            goto L_0x06a6
        L_0x06a2:
            r5 = r68
            r71 = r1
        L_0x06a6:
            r10.endReplaceableGroup()
            r11 = r1
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r11 = (androidx.compose.foundation.text.selection.TextFieldSelectionManager) r11
            r11.setOffsetMapping$foundation_release(r9)
            r11.setVisualTransformation$foundation_release(r12)
            kotlin.jvm.functions.Function1 r1 = r2.getOnValueChange()
            r11.setOnValueChange$foundation_release(r1)
            r11.setState$foundation_release(r2)
            r11.setValue$foundation_release(r15)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalClipboardManager()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r5 = 0
            r16 = 0
            r68 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r0)
            java.lang.Object r5 = r10.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.platform.ClipboardManager r5 = (androidx.compose.ui.platform.ClipboardManager) r5
            r11.setClipboardManager$foundation_release(r5)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalTextToolbar()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r5 = 0
            r16 = 0
            r68 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r0)
            java.lang.Object r5 = r10.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.platform.TextToolbar r5 = (androidx.compose.ui.platform.TextToolbar) r5
            r11.setTextToolbar(r5)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalHapticFeedback()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r5 = 0
            r16 = 0
            r68 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r0)
            java.lang.Object r0 = r10.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.hapticfeedback.HapticFeedback r0 = (androidx.compose.ui.hapticfeedback.HapticFeedback) r0
            r11.setHapticFeedBack(r0)
            r11.setFocusRequester(r4)
            r0 = r36 ^ 1
            r11.setEditable(r0)
            r0 = 0
            r1 = r0
            r5 = 0
            r0 = 773894976(0x2e20b340, float:3.6538994E-11)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = r10
            r16 = 0
            r17 = r16
            r16 = 0
            r68 = r1
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            r1 = 0
            r69 = r10
            r20 = 0
            r70 = r1
            java.lang.Object r1 = r69.rememberedValue()
            r22 = 0
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r71 = r5
            java.lang.Object r5 = r24.getEmpty()
            if (r1 != r5) goto L_0x0777
            r5 = 0
            r24 = 0
            kotlin.coroutines.EmptyCoroutineContext r24 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r72 = r1
            r1 = r24
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            kotlinx.coroutines.CoroutineScope r1 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r1, r0)
            r73 = r0
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r0.<init>(r1)
            r1 = r69
            r1.updateRememberedValue(r0)
            goto L_0x077f
        L_0x0777:
            r73 = r0
            r72 = r1
            r1 = r69
            r0 = r72
        L_0x077f:
            r10.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r1 = r0.getCoroutineScope()
            r10.endReplaceableGroup()
            r75 = r1
            r0 = 0
            r1 = r0
            r0 = 0
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            r5 = 0
            r14 = r10
            r16 = 0
            r68 = r0
            java.lang.Object r0 = r14.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r69 = r1
            java.lang.Object r1 = r20.getEmpty()
            if (r0 != r1) goto L_0x07bc
            r1 = 0
            androidx.compose.foundation.relocation.BringIntoViewRequester r1 = androidx.compose.foundation.relocation.BringIntoViewRequesterKt.BringIntoViewRequester()
            r14.updateRememberedValue(r1)
            goto L_0x07bd
        L_0x07bc:
            r1 = r0
        L_0x07bd:
            r10.endReplaceableGroup()
            r45 = r1
            androidx.compose.foundation.relocation.BringIntoViewRequester r45 = (androidx.compose.foundation.relocation.BringIntoViewRequester) r45
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1 r1 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1
            r68 = r1
            r69 = r2
            r70 = r3
            r71 = r66
            r72 = r7
            r73 = r9
            r74 = r11
            r76 = r45
            r68.<init>(r69, r70, r71, r72, r73, r74, r75, r76)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r14 = r25
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.text.TextFieldGestureModifiersKt.textFieldFocusModifier(r0, r6, r4, r14, r1)
            r0 = -55008430(0xfffffffffcb8a352, float:-7.669561E36)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "324@16009L163"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r1 = 8
            if (r6 == 0) goto L_0x0805
            if (r36 != 0) goto L_0x0805
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2
            r0.<init>(r2)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r2, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r10, (int) r1)
        L_0x0805:
            r10.endReplaceableGroup()
            boolean r0 = androidx.compose.foundation.text.TouchMode_androidKt.isInTouchMode()
            if (r0 == 0) goto L_0x0844
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.foundation.text.TextDragObserver r1 = r11.getTouchSelectionObserver$foundation_release()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.text.TextFieldGestureModifiersKt.longPressDragGestureFilter(r0, r1, r6)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1 r16 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1
            r68 = r16
            r69 = r2
            r70 = r4
            r71 = r36
            r72 = r11
            r73 = r9
            r68.<init>(r69, r70, r71, r72, r73)
            r76 = r3
            r3 = r16
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.text.TextFieldPressGestureFilterKt.tapPressTextFieldModifier(r1, r14, r6, r3)
            androidx.compose.ui.Modifier r0 = r1.then(r0)
            r80 = r4
            r81 = r5
            r5 = 0
            goto L_0x0862
        L_0x0844:
            r76 = r3
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.foundation.text.selection.MouseSelectionObserver r1 = r11.getMouseSelectionObserver$foundation_release()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.text.TextFieldGestureModifiersKt.mouseDragGestureDetector(r0, r1, r6)
            androidx.compose.ui.input.pointer.PointerIcon r1 = androidx.compose.foundation.text.TextPointerIcon_androidKt.getTextPointerIcon()
            r80 = r4
            r81 = r5
            r3 = 0
            r4 = 2
            r5 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.input.pointer.PointerIconKt.pointerHoverIcon$default(r0, r1, r5, r4, r3)
        L_0x0862:
            r4 = r0
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1 r1 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1
            r1.<init>(r2, r15, r9)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.ui.Modifier r46 = androidx.compose.ui.draw.DrawModifierKt.drawBehind(r0, r1)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1 r1 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1
            r68 = r1
            r69 = r2
            r70 = r6
            r71 = r11
            r72 = r66
            r73 = r9
            r68.<init>(r69, r70, r71, r72, r73)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.ui.Modifier r47 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r0, r1)
            boolean r3 = r12 instanceof androidx.compose.ui.text.input.PasswordVisualTransformation
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r1 = r0
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1 r16 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1
            r0 = r16
            r17 = r12
            r25 = r14
            r48 = r18
            r14 = 8
            r12 = r1
            r1 = r7
            r74 = r2
            r49 = r21
            r14 = 1
            r2 = r43
            r53 = r76
            r50 = r3
            r3 = r66
            r51 = r80
            r20 = r5
            r5 = r4
            r4 = r6
            r54 = r77
            r55 = r81
            r56 = r5
            r52 = r19
            r5 = r50
            r57 = r6
            r6 = r36
            r58 = r7
            r7 = r74
            r60 = r78
            r61 = r8
            r59 = r26
            r8 = r9
            r62 = r9
            r63 = r25
            r9 = r11
            r64 = r10
            r10 = r51
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r16
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r12, r14, r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r10 = r57
            if (r10 == 0) goto L_0x08ee
            if (r36 != 0) goto L_0x08ee
            r1 = r14
            goto L_0x08f0
        L_0x08ee:
            r1 = r20
        L_0x08f0:
            r68 = r0
            r69 = r74
            r70 = r66
            r71 = r62
            r72 = r32
            r73 = r1
            androidx.compose.ui.Modifier r19 = androidx.compose.foundation.text.TextFieldCursorKt.cursor(r68, r69, r70, r71, r72, r73)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3
            r0.<init>(r11)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r9 = r64
            r1 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r9, (int) r1)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4
            r6 = r74
            r8 = r53
            r7 = r58
            r0.<init>(r8, r6, r15, r7)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            int r1 = r52 >> 3
            r1 = r1 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r7, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r9, (int) r1)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            kotlin.jvm.functions.Function1 r4 = r6.getOnValueChange()
            r5 = r36 ^ 1
            r3 = r59
            if (r3 != r14) goto L_0x0938
            r16 = r14
            goto L_0x093a
        L_0x0938:
            r16 = r20
        L_0x093a:
            r1 = r6
            r2 = r11
            r53 = r3
            r3 = r66
            r15 = r6
            r6 = r16
            r57 = r7
            r7 = r62
            r58 = r8
            r8 = r61
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.text.TextFieldKeyInputKt.textFieldKeyInput(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r1 = r55
            androidx.compose.ui.Modifier r2 = r13.then(r1)
            r3 = r54
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.text.TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(r2, r15, r3)
            androidx.compose.ui.Modifier r2 = previewKeyEventToDeselectOnBack(r2, r15, r11)
            androidx.compose.ui.Modifier r2 = r2.then(r0)
            r4 = r79
            r5 = r63
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.text.TextFieldScrollKt.textFieldScrollable(r2, r4, r5, r10)
            r6 = r56
            androidx.compose.ui.Modifier r2 = r2.then(r6)
            androidx.compose.ui.Modifier r2 = r2.then(r12)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1 r7 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
            r7.<init>(r15)
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r2, r7)
            if (r10 == 0) goto L_0x0995
            boolean r7 = r15.getHasFocus()
            if (r7 == 0) goto L_0x0995
            boolean r7 = androidx.compose.foundation.text.TouchMode_androidKt.isInTouchMode()
            if (r7 == 0) goto L_0x0995
            r20 = r14
        L_0x0995:
            r7 = r20
            if (r7 == 0) goto L_0x09a4
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt.textFieldMagnifier(r8, r11)
            r22 = r8
            goto L_0x09aa
        L_0x09a4:
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            r22 = r8
        L_0x09aa:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5 r8 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
            r56 = r6
            r6 = r9
            r9 = r8
            r54 = r10
            r10 = r37
            r68 = r11
            r11 = r52
            r59 = r12
            r55 = r17
            r12 = r15
            r63 = r13
            r13 = r30
            r69 = r0
            r0 = r14
            r14 = r34
            r64 = r15
            r15 = r53
            r16 = r4
            r17 = r66
            r18 = r55
            r20 = r46
            r21 = r47
            r23 = r45
            r24 = r68
            r25 = r7
            r26 = r36
            r27 = r31
            r28 = r62
            r29 = r38
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            r9 = -374338080(0xffffffffe9b00de0, float:-2.6604558E25)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r6, r9, r0, r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8 = 448(0x1c0, float:6.28E-43)
            r9 = r68
            CoreTextFieldRootBox(r2, r9, r0, r6, r8)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x09ff
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x09ff:
            r20 = r5
        L_0x0a01:
            androidx.compose.runtime.ScopeUpdateScope r15 = r6.endRestartGroup()
            if (r15 != 0) goto L_0x0a0a
            r22 = r6
            goto L_0x0a44
        L_0x0a0a:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$6 r21 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$6
            r0 = r21
            r1 = r66
            r2 = r67
            r3 = r63
            r4 = r30
            r5 = r55
            r22 = r6
            r6 = r31
            r7 = r20
            r8 = r32
            r9 = r33
            r10 = r53
            r11 = r34
            r12 = r57
            r13 = r35
            r14 = r54
            r65 = r15
            r15 = r36
            r16 = r37
            r17 = r83
            r18 = r84
            r19 = r85
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = r21
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r65
            r1.updateScope(r0)
        L_0x0a44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, boolean, int, int, androidx.compose.ui.text.input.ImeOptions, androidx.compose.foundation.text.KeyboardActions, boolean, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void CoreTextFieldRootBox(Modifier modifier, TextFieldSelectionManager manager, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        TextFieldSelectionManager textFieldSelectionManager = manager;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        Composer $composer2 = $composer.startRestartGroup(-20551815);
        ComposerKt.sourceInformation($composer2, "C(CoreTextFieldRootBox)P(2,1)668@29669L95:CoreTextField.kt#423gt5");
        int $dirty = $changed;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-20551815, $dirty, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:663)");
        }
        int $changed$iv = ($dirty & 14) | 384;
        $composer2.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, true, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
        $composer2.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer2);
        Density density$iv$iv = (Density) consume;
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd($composer2);
        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd($composer2);
        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
        Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
        Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier);
        int $changed$iv$iv$iv = (((($changed$iv << 3) & 112) << 9) & 7168) | 6;
        if (!($composer2.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer2.startReusableNode();
        if ($composer2.getInserting()) {
            $composer2.createNode(factory$iv$iv$iv);
        } else {
            $composer2.useNode();
        }
        $composer2.disableReusing();
        Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer2);
        Alignment alignment = contentAlignment$iv;
        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
        $composer2.enableReusing();
        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
        $composer2.startReplaceableGroup(2058660585);
        Composer $composer$iv = $composer2;
        int i = $changed$iv$iv$iv;
        int i2 = ($changed$iv$iv$iv >> 9) & 14;
        ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        int i3 = $changed$iv;
        int i4 = (($changed$iv >> 6) & 112) | 6;
        Composer $composer3 = $composer$iv;
        ComposerKt.sourceInformationMarkerStart($composer3, -1087272644, "C669@29725L33:CoreTextField.kt#423gt5");
        ContextMenu_androidKt.ContextMenuArea(textFieldSelectionManager, function2, $composer3, (($dirty >> 3) & 112) | 8);
        ComposerKt.sourceInformationMarkerEnd($composer3);
        ComposerKt.sourceInformationMarkerEnd($composer$iv);
        $composer2.endReplaceableGroup();
        $composer2.endNode();
        $composer2.endReplaceableGroup();
        $composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Modifier modifier2 = modifier;
            int i5 = $changed;
            return;
        }
        endRestartGroup.updateScope(new CoreTextFieldKt$CoreTextFieldRootBox$2(modifier, textFieldSelectionManager, function2, $changed));
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier $this$previewKeyEventToDeselectOnBack, TextFieldState state, TextFieldSelectionManager manager) {
        return KeyInputModifierKt.onPreviewKeyEvent($this$previewKeyEventToDeselectOnBack, new CoreTextFieldKt$previewKeyEventToDeselectOnBack$1(state, manager));
    }

    /* access modifiers changed from: private */
    public static final void tapToFocus(TextFieldState state, FocusRequester focusRequester, boolean allowKeyboard) {
        TextInputSession inputSession;
        if (!state.getHasFocus()) {
            focusRequester.requestFocus();
        } else if (allowKeyboard && (inputSession = state.getInputSession()) != null) {
            inputSession.showSoftwareKeyboard();
        }
    }

    /* access modifiers changed from: private */
    public static final void notifyTextInputServiceOnFocusChange(TextInputService textInputService, TextFieldState state, TextFieldValue value, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        if (state.getHasFocus()) {
            state.setInputSession(TextFieldDelegate.Companion.onFocus$foundation_release(textInputService, value, state.getProcessor(), imeOptions, state.getOnValueChange(), state.getOnImeActionPerformed()));
            notifyFocusedRect(state, value, offsetMapping);
            return;
        }
        onBlur(state);
    }

    /* access modifiers changed from: private */
    public static final void onBlur(TextFieldState state) {
        TextInputSession session = state.getInputSession();
        if (session != null) {
            TextFieldDelegate.Companion.onBlur$foundation_release(session, state.getProcessor(), state.getOnValueChange());
        }
        state.setInputSession((TextInputSession) null);
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester $this$bringSelectionEndIntoView, TextFieldValue value, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> $completion) {
        Rect selectionEndBounds;
        int selectionEndInTransformed = offsetMapping.originalToTransformed(TextRange.m5471getMaximpl(value.m5695getSelectiond9O1mEE()));
        if (selectionEndInTransformed < textLayoutResult.getLayoutInput().getText().length()) {
            selectionEndBounds = textLayoutResult.getBoundingBox(selectionEndInTransformed);
        } else if (selectionEndInTransformed != 0) {
            selectionEndBounds = textLayoutResult.getBoundingBox(selectionEndInTransformed - 1);
        } else {
            selectionEndBounds = new Rect(0.0f, 0.0f, 1.0f, (float) IntSize.m6145getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), (String) null, 0, 24, (Object) null)));
        }
        Object bringIntoView = $this$bringSelectionEndIntoView.bringIntoView(selectionEndBounds, $completion);
        return bringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? bringIntoView : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void SelectionToolbarAndHandles(TextFieldSelectionManager manager, boolean show, Composer $composer, int $changed) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer $composer2 = $composer.startRestartGroup(626339208);
        ComposerKt.sourceInformation($composer2, "C(SelectionToolbarAndHandles)1010@43460L202:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(626339208, $changed, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:991)");
        }
        TextFieldSelectionManager $this$SelectionToolbarAndHandles_u24lambda_u2413 = manager;
        if (show) {
            TextFieldState state$foundation_release = $this$SelectionToolbarAndHandles_u24lambda_u2413.getState$foundation_release();
            TextLayoutResult textLayoutResult = null;
            boolean z = true;
            if (!(state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null || (value = layoutResult.getValue()) == null)) {
                TextLayoutResult textLayoutResult2 = value;
                TextFieldState state$foundation_release2 = $this$SelectionToolbarAndHandles_u24lambda_u2413.getState$foundation_release();
                if (!(state$foundation_release2 != null ? state$foundation_release2.isLayoutResultStale() : true)) {
                    textLayoutResult = value;
                }
            }
            if (textLayoutResult != null) {
                TextLayoutResult it = textLayoutResult;
                if (!TextRange.m5468getCollapsedimpl($this$SelectionToolbarAndHandles_u24lambda_u2413.getValue$foundation_release().m5695getSelectiond9O1mEE())) {
                    int startOffset = $this$SelectionToolbarAndHandles_u24lambda_u2413.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m5474getStartimpl($this$SelectionToolbarAndHandles_u24lambda_u2413.getValue$foundation_release().m5695getSelectiond9O1mEE()));
                    int endOffset = $this$SelectionToolbarAndHandles_u24lambda_u2413.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m5469getEndimpl($this$SelectionToolbarAndHandles_u24lambda_u2413.getValue$foundation_release().m5695getSelectiond9O1mEE()));
                    ResolvedTextDirection startDirection = it.getBidiRunDirection(startOffset);
                    ResolvedTextDirection endDirection = it.getBidiRunDirection(Math.max(endOffset - 1, 0));
                    $composer2.startReplaceableGroup(-498391544);
                    ComposerKt.sourceInformation($composer2, "1003@43137L203");
                    TextFieldState state$foundation_release3 = manager.getState$foundation_release();
                    if (state$foundation_release3 != null && state$foundation_release3.getShowSelectionHandleStart()) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, startDirection, manager, $composer2, 518);
                    }
                    $composer2.endReplaceableGroup();
                    TextFieldState state$foundation_release4 = manager.getState$foundation_release();
                    if (state$foundation_release4 == null || !state$foundation_release4.getShowSelectionHandleEnd()) {
                        z = false;
                    }
                    if (z) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, endDirection, manager, $composer2, 518);
                    }
                }
                TextFieldState textFieldState = $this$SelectionToolbarAndHandles_u24lambda_u2413.getState$foundation_release();
                if (textFieldState != null) {
                    if ($this$SelectionToolbarAndHandles_u24lambda_u2413.isTextChanged$foundation_release()) {
                        textFieldState.setShowFloatingToolbar(false);
                    }
                    if (textFieldState.getHasFocus()) {
                        if (textFieldState.getShowFloatingToolbar()) {
                            $this$SelectionToolbarAndHandles_u24lambda_u2413.showSelectionToolbar$foundation_release();
                        } else {
                            $this$SelectionToolbarAndHandles_u24lambda_u2413.hideSelectionToolbar$foundation_release();
                        }
                    }
                }
            }
        } else {
            $this$SelectionToolbarAndHandles_u24lambda_u2413.hideSelectionToolbar$foundation_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CoreTextFieldKt$SelectionToolbarAndHandles$2(manager, show, $changed));
        }
    }

    public static final void TextFieldCursorHandle(TextFieldSelectionManager manager, Composer $composer, int $changed) {
        TextDragObserver value$iv$iv;
        Object value$iv$iv2;
        TextFieldSelectionManager textFieldSelectionManager = manager;
        int i = $changed;
        Intrinsics.checkNotNullParameter(textFieldSelectionManager, "manager");
        Composer $composer2 = $composer.startRestartGroup(-1436003720);
        ComposerKt.sourceInformation($composer2, "C(TextFieldCursorHandle)1036@44505L50,1037@44618L7,1044@44875L205,1038@44635L483:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1436003720, i, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1034)");
        }
        TextFieldState state$foundation_release = manager.getState$foundation_release();
        if (state$foundation_release != null && state$foundation_release.getShowCursorHandle()) {
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed((Object) textFieldSelectionManager);
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = manager.cursorDragObserver$foundation_release();
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            TextDragObserver observer = value$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            long position = textFieldSelectionManager.m1338getCursorPositiontuRUvjQ$foundation_release((Density) consume);
            Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) observer, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new CoreTextFieldKt$TextFieldCursorHandle$1(observer, (Continuation<? super CoreTextFieldKt$TextFieldCursorHandle$1>) null));
            Object key1$iv = Offset.m2904boximpl(position);
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv2 = $composer2.changed(key1$iv);
            Composer $this$cache$iv$iv2 = $composer2;
            Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
            if (invalid$iv$iv2 || it$iv$iv2 == Composer.Companion.getEmpty()) {
                value$iv$iv2 = (Function1) new CoreTextFieldKt$TextFieldCursorHandle$2$1(position);
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            AndroidCursorHandle_androidKt.m1121CursorHandleULxng0E(position, SemanticsModifierKt.semantics$default(pointerInput, false, (Function1) value$iv$iv2, 1, (Object) null), (Function2<? super Composer, ? super Integer, Unit>) null, $composer2, 384);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CoreTextFieldKt$TextFieldCursorHandle$3(textFieldSelectionManager, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void notifyFocusedRect(TextFieldState state, TextFieldValue value, OffsetMapping offsetMapping) {
        Snapshot previous$iv$iv;
        Snapshot snapshot$iv = Snapshot.Companion.createNonObservableSnapshot();
        Snapshot this_$iv$iv = snapshot$iv;
        try {
            previous$iv$iv = this_$iv$iv.makeCurrent();
            TextLayoutResultProxy layoutResult = state.getLayoutResult();
            if (layoutResult != null) {
                TextInputSession inputSession = state.getInputSession();
                if (inputSession != null) {
                    LayoutCoordinates layoutCoordinates = state.getLayoutCoordinates();
                    if (layoutCoordinates != null) {
                        TextFieldDelegate.Companion.notifyFocusedRect$foundation_release(value, state.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, state.getHasFocus(), offsetMapping);
                        Unit unit = Unit.INSTANCE;
                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                        snapshot$iv.dispose();
                        return;
                    }
                }
            }
            try {
                this_$iv$iv.restoreCurrent(previous$iv$iv);
                snapshot$iv.dispose();
            } catch (Throwable th) {
                th = th;
                snapshot$iv.dispose();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            snapshot$iv.dispose();
            throw th;
        }
    }
}
