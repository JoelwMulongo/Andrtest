package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a%\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"TextFieldSelectionHandle", "", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "(ZLandroidx/compose/ui/text/style/ResolvedTextDirection;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;J)J", "isSelectionHandleInVisibleBound", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.kt */
public final class TextFieldSelectionManagerKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldSelectionManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            try {
                iArr[Handle.Cursor.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Handle.SelectionStart.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Handle.SelectionEnd.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void TextFieldSelectionHandle(boolean isStartHandle, ResolvedTextDirection direction, TextFieldSelectionManager manager, Composer $composer, int $changed) {
        TextDragObserver value$iv$iv;
        boolean z = isStartHandle;
        ResolvedTextDirection resolvedTextDirection = direction;
        TextFieldSelectionManager textFieldSelectionManager = manager;
        Intrinsics.checkNotNullParameter(resolvedTextDirection, "direction");
        Intrinsics.checkNotNullParameter(textFieldSelectionManager, "manager");
        Composer $composer2 = $composer.startRestartGroup(-1344558920);
        ComposerKt.sourceInformation($composer2, "C(TextFieldSelectionHandle)P(1)808@30733L90,813@30889L327:TextFieldSelectionManager.kt#eksfi3");
        int $dirty = $changed;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1344558920, $dirty, -1, "androidx.compose.foundation.text.selection.TextFieldSelectionHandle (TextFieldSelectionManager.kt:803)");
        }
        Object key1$iv = Boolean.valueOf(isStartHandle);
        int i = ($dirty & 14) | 64;
        $composer2.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer2.changed(key1$iv) | $composer2.changed((Object) textFieldSelectionManager);
        Composer $this$cache$iv$iv = $composer2;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = textFieldSelectionManager.handleDragObserver$foundation_release(z);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer2.endReplaceableGroup();
        TextDragObserver observer = value$iv$iv;
        AndroidSelectionHandles_androidKt.m1242SelectionHandle8fL75g(textFieldSelectionManager.m1339getHandlePositiontuRUvjQ$foundation_release(z), isStartHandle, direction, TextRange.m5473getReversedimpl(manager.getValue$foundation_release().m5695getSelectiond9O1mEE()), SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) observer, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new TextFieldSelectionManagerKt$TextFieldSelectionHandle$1(observer, (Continuation<? super TextFieldSelectionManagerKt$TextFieldSelectionHandle$1>) null)), (Function2<? super Composer, ? super Integer, Unit>) null, $composer2, (($dirty << 3) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (($dirty << 3) & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i2 = $changed;
        } else {
            endRestartGroup.updateScope(new TextFieldSelectionManagerKt$TextFieldSelectionHandle$2(z, resolvedTextDirection, textFieldSelectionManager, $changed));
        }
    }

    public static final boolean isSelectionHandleInVisibleBound(TextFieldSelectionManager $this$isSelectionHandleInVisibleBound, boolean isStartHandle) {
        LayoutCoordinates layoutCoordinates;
        Rect visibleBounds;
        Intrinsics.checkNotNullParameter($this$isSelectionHandleInVisibleBound, "<this>");
        TextFieldState state$foundation_release = $this$isSelectionHandleInVisibleBound.getState$foundation_release();
        if (state$foundation_release == null || (layoutCoordinates = state$foundation_release.getLayoutCoordinates()) == null || (visibleBounds = SelectionManagerKt.visibleBounds(layoutCoordinates)) == null) {
            return false;
        }
        return SelectionManagerKt.m1314containsInclusiveUv8p0NA(visibleBounds, $this$isSelectionHandleInVisibleBound.m1339getHandlePositiontuRUvjQ$foundation_release(isStartHandle));
    }

    /* renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c  reason: not valid java name */
    public static final long m1353calculateSelectionMagnifierCenterAndroidO0kMr_c(TextFieldSelectionManager manager, long magnifierSize) {
        int rawTextOffset;
        TextLayoutResultProxy layoutResult;
        TextDelegate textDelegate;
        TextLayoutResultProxy layoutResult2;
        Intrinsics.checkNotNullParameter(manager, "manager");
        if (manager.getValue$foundation_release().getText().length() == 0) {
            return Offset.Companion.m2930getUnspecifiedF1C5BW0();
        }
        Handle draggingHandle = manager.getDraggingHandle();
        switch (draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()]) {
            case -1:
                return Offset.Companion.m2930getUnspecifiedF1C5BW0();
            case 1:
            case 2:
                rawTextOffset = TextRange.m5474getStartimpl(manager.getValue$foundation_release().m5695getSelectiond9O1mEE());
                break;
            case 3:
                rawTextOffset = TextRange.m5469getEndimpl(manager.getValue$foundation_release().m5695getSelectiond9O1mEE());
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        int textOffset = manager.getOffsetMapping$foundation_release().originalToTransformed(rawTextOffset);
        TextFieldState state$foundation_release = manager.getState$foundation_release();
        if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
        } else {
            TextLayoutResult layoutResult3 = layoutResult.getValue();
            if (layoutResult3 == null) {
                int i = rawTextOffset;
            } else {
                TextFieldState state$foundation_release2 = manager.getState$foundation_release();
                if (state$foundation_release2 == null || (textDelegate = state$foundation_release2.getTextDelegate()) == null) {
                } else {
                    AnnotatedString transformedText = textDelegate.getText();
                    if (transformedText == null) {
                        int i2 = rawTextOffset;
                    } else {
                        int textOffset2 = RangesKt.coerceIn(textOffset, (ClosedRange<Integer>) StringsKt.getIndices(transformedText));
                        long offsetCenter = layoutResult3.getBoundingBox(textOffset2).m2945getCenterF1C5BW0();
                        TextFieldState state$foundation_release3 = manager.getState$foundation_release();
                        if (state$foundation_release3 != null) {
                            LayoutCoordinates containerCoordinates = state$foundation_release3.getLayoutCoordinates();
                            if (containerCoordinates == null) {
                                int i3 = rawTextOffset;
                            } else {
                                TextFieldState state$foundation_release4 = manager.getState$foundation_release();
                                if (state$foundation_release4 == null || (layoutResult2 = state$foundation_release4.getLayoutResult()) == null) {
                                } else {
                                    LayoutCoordinates fieldCoordinates = layoutResult2.getInnerTextFieldCoordinates();
                                    if (fieldCoordinates == null) {
                                        int i4 = rawTextOffset;
                                    } else {
                                        Offset r11 = manager.m1337getCurrentDragPosition_m7T9E();
                                        if (r11 != null) {
                                            float dragX = Offset.m2915getXimpl(fieldCoordinates.m4840localPositionOfR5De75A(containerCoordinates, r11.m2925unboximpl()));
                                            int line = layoutResult3.getLineForOffset(textOffset2);
                                            int lineStartOffset = layoutResult3.getLineStart(line);
                                            int lineEndOffset = layoutResult3.getLineEnd(line, true);
                                            int i5 = rawTextOffset;
                                            boolean areHandlesCrossed = TextRange.m5474getStartimpl(manager.getValue$foundation_release().m5695getSelectiond9O1mEE()) > TextRange.m5469getEndimpl(manager.getValue$foundation_release().m5695getSelectiond9O1mEE());
                                            float lineStart = TextSelectionDelegateKt.getHorizontalPosition(layoutResult3, lineStartOffset, true, areHandlesCrossed);
                                            float lineEnd = TextSelectionDelegateKt.getHorizontalPosition(layoutResult3, lineEndOffset, false, areHandlesCrossed);
                                            boolean z = areHandlesCrossed;
                                            float lineMin = Math.min(lineStart, lineEnd);
                                            int i6 = lineEndOffset;
                                            float lineMax = Math.max(lineStart, lineEnd);
                                            float f = lineEnd;
                                            float centerX = RangesKt.coerceIn(dragX, lineMin, lineMax);
                                            float f2 = lineMin;
                                            if (Math.abs(dragX - centerX) > ((float) (IntSize.m6146getWidthimpl(magnifierSize) / 2))) {
                                                return Offset.Companion.m2930getUnspecifiedF1C5BW0();
                                            }
                                            float f3 = lineMax;
                                            float f4 = lineStart;
                                            return containerCoordinates.m4840localPositionOfR5De75A(fieldCoordinates, OffsetKt.Offset(centerX, Offset.m2916getYimpl(offsetCenter)));
                                        }
                                        return Offset.Companion.m2930getUnspecifiedF1C5BW0();
                                    }
                                }
                                return Offset.Companion.m2930getUnspecifiedF1C5BW0();
                            }
                        }
                        return Offset.Companion.m2930getUnspecifiedF1C5BW0();
                    }
                }
                return Offset.Companion.m2930getUnspecifiedF1C5BW0();
            }
        }
        return Offset.Companion.m2930getUnspecifiedF1C5BW0();
    }
}
