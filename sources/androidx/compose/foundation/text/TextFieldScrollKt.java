package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002\u001a4\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0000\u001a*\u0010\u0017\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0000¨\u0006\u001b"}, d2 = {"getCursorRectInScroller", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/Density;", "cursorOffset", "", "transformedText", "Landroidx/compose/ui/text/input/TransformedText;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "rtl", "", "textFieldWidth", "textFieldScroll", "Landroidx/compose/ui/Modifier;", "scrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "textLayoutResultProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "textFieldScrollable", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldScroll.kt */
public final class TextFieldScrollKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldScroll.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ Modifier textFieldScrollable$default(Modifier modifier, TextFieldScrollerPosition textFieldScrollerPosition, MutableInteractionSource mutableInteractionSource, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            mutableInteractionSource = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return textFieldScrollable(modifier, textFieldScrollerPosition, mutableInteractionSource, z);
    }

    public static final Modifier textFieldScrollable(Modifier $this$textFieldScrollable, TextFieldScrollerPosition scrollerPosition, MutableInteractionSource interactionSource, boolean enabled) {
        Intrinsics.checkNotNullParameter($this$textFieldScrollable, "<this>");
        Intrinsics.checkNotNullParameter(scrollerPosition, "scrollerPosition");
        return ComposedModifierKt.composed($this$textFieldScrollable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TextFieldScrollKt$textFieldScrollable$$inlined$debugInspectorInfo$1(scrollerPosition, interactionSource, enabled) : InspectableValueKt.getNoInspectorInfo(), new TextFieldScrollKt$textFieldScrollable$2(scrollerPosition, enabled, interactionSource));
    }

    public static final Modifier textFieldScroll(Modifier $this$textFieldScroll, TextFieldScrollerPosition scrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Function0<TextLayoutResultProxy> textLayoutResultProvider) {
        LayoutModifier layout;
        Intrinsics.checkNotNullParameter($this$textFieldScroll, "<this>");
        Intrinsics.checkNotNullParameter(scrollerPosition, "scrollerPosition");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        Intrinsics.checkNotNullParameter(visualTransformation, "visualTransformation");
        Intrinsics.checkNotNullParameter(textLayoutResultProvider, "textLayoutResultProvider");
        Orientation orientation = scrollerPosition.getOrientation();
        int cursorOffset = scrollerPosition.m1218getOffsetToFollow5zctL8(textFieldValue.m5695getSelectiond9O1mEE());
        scrollerPosition.m1220setPreviousSelection5zctL8(textFieldValue.m5695getSelectiond9O1mEE());
        TransformedText transformedText = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation, textFieldValue.getAnnotatedString());
        switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
                layout = new VerticalScrollLayoutModifier(scrollerPosition, cursorOffset, transformedText, textLayoutResultProvider);
                break;
            case 2:
                layout = new HorizontalScrollLayoutModifier(scrollerPosition, cursorOffset, transformedText, textLayoutResultProvider);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return ClipKt.clipToBounds($this$textFieldScroll).then(layout);
    }

    /* access modifiers changed from: private */
    public static final Rect getCursorRectInScroller(Density $this$getCursorRectInScroller, int cursorOffset, TransformedText transformedText, TextLayoutResult textLayoutResult, boolean rtl, int textFieldWidth) {
        Rect cursorRect;
        float cursorLeft;
        float cursorRight;
        Rect cursorRect2;
        if (textLayoutResult == null || (cursorRect2 = textLayoutResult.getCursorRect(transformedText.getOffsetMapping().originalToTransformed(cursorOffset))) == null) {
            cursorRect = Rect.Companion.getZero();
        } else {
            cursorRect = cursorRect2;
        }
        int thickness = $this$getCursorRectInScroller.m5961roundToPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
        if (rtl) {
            cursorLeft = (((float) textFieldWidth) - cursorRect.getLeft()) - ((float) thickness);
        } else {
            cursorLeft = cursorRect.getLeft();
        }
        if (rtl) {
            cursorRight = ((float) textFieldWidth) - cursorRect.getLeft();
        } else {
            cursorRight = cursorRect.getLeft() + ((float) thickness);
        }
        return Rect.copy$default(cursorRect, cursorLeft, 0.0f, cursorRight, 0.0f, 10, (Object) null);
    }
}
