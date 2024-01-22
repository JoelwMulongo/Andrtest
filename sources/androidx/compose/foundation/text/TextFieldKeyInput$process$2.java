package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.core.view.MotionEventCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/text/selection/TextFieldPreparedSelection;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldKeyInput.kt */
final class TextFieldKeyInput$process$2 extends Lambda implements Function1<TextFieldPreparedSelection, Unit> {
    final /* synthetic */ KeyCommand $command;
    final /* synthetic */ Ref.BooleanRef $consumed;
    final /* synthetic */ TextFieldKeyInput this$0;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldKeyInput.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KeyCommand.values().length];
            try {
                iArr[KeyCommand.COPY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[KeyCommand.PASTE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[KeyCommand.CUT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[KeyCommand.LEFT_CHAR.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[KeyCommand.RIGHT_CHAR.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[KeyCommand.LEFT_WORD.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[KeyCommand.RIGHT_WORD.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[KeyCommand.PREV_PARAGRAPH.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[KeyCommand.NEXT_PARAGRAPH.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[KeyCommand.UP.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[KeyCommand.DOWN.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[KeyCommand.PAGE_UP.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[KeyCommand.PAGE_DOWN.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[KeyCommand.LINE_START.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[KeyCommand.LINE_END.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr[KeyCommand.LINE_LEFT.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr[KeyCommand.LINE_RIGHT.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr[KeyCommand.HOME.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                iArr[KeyCommand.END.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                iArr[KeyCommand.DELETE_PREV_CHAR.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                iArr[KeyCommand.DELETE_NEXT_CHAR.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
            try {
                iArr[KeyCommand.DELETE_PREV_WORD.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
            try {
                iArr[KeyCommand.DELETE_NEXT_WORD.ordinal()] = 23;
            } catch (NoSuchFieldError e23) {
            }
            try {
                iArr[KeyCommand.DELETE_FROM_LINE_START.ordinal()] = 24;
            } catch (NoSuchFieldError e24) {
            }
            try {
                iArr[KeyCommand.DELETE_TO_LINE_END.ordinal()] = 25;
            } catch (NoSuchFieldError e25) {
            }
            try {
                iArr[KeyCommand.NEW_LINE.ordinal()] = 26;
            } catch (NoSuchFieldError e26) {
            }
            try {
                iArr[KeyCommand.TAB.ordinal()] = 27;
            } catch (NoSuchFieldError e27) {
            }
            try {
                iArr[KeyCommand.SELECT_ALL.ordinal()] = 28;
            } catch (NoSuchFieldError e28) {
            }
            try {
                iArr[KeyCommand.SELECT_LEFT_CHAR.ordinal()] = 29;
            } catch (NoSuchFieldError e29) {
            }
            try {
                iArr[KeyCommand.SELECT_RIGHT_CHAR.ordinal()] = 30;
            } catch (NoSuchFieldError e30) {
            }
            try {
                iArr[KeyCommand.SELECT_LEFT_WORD.ordinal()] = 31;
            } catch (NoSuchFieldError e31) {
            }
            try {
                iArr[KeyCommand.SELECT_RIGHT_WORD.ordinal()] = 32;
            } catch (NoSuchFieldError e32) {
            }
            try {
                iArr[KeyCommand.SELECT_PREV_PARAGRAPH.ordinal()] = 33;
            } catch (NoSuchFieldError e33) {
            }
            try {
                iArr[KeyCommand.SELECT_NEXT_PARAGRAPH.ordinal()] = 34;
            } catch (NoSuchFieldError e34) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_START.ordinal()] = 35;
            } catch (NoSuchFieldError e35) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_END.ordinal()] = 36;
            } catch (NoSuchFieldError e36) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_LEFT.ordinal()] = 37;
            } catch (NoSuchFieldError e37) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_RIGHT.ordinal()] = 38;
            } catch (NoSuchFieldError e38) {
            }
            try {
                iArr[KeyCommand.SELECT_UP.ordinal()] = 39;
            } catch (NoSuchFieldError e39) {
            }
            try {
                iArr[KeyCommand.SELECT_DOWN.ordinal()] = 40;
            } catch (NoSuchFieldError e40) {
            }
            try {
                iArr[KeyCommand.SELECT_PAGE_UP.ordinal()] = 41;
            } catch (NoSuchFieldError e41) {
            }
            try {
                iArr[KeyCommand.SELECT_PAGE_DOWN.ordinal()] = 42;
            } catch (NoSuchFieldError e42) {
            }
            try {
                iArr[KeyCommand.SELECT_HOME.ordinal()] = 43;
            } catch (NoSuchFieldError e43) {
            }
            try {
                iArr[KeyCommand.SELECT_END.ordinal()] = 44;
            } catch (NoSuchFieldError e44) {
            }
            try {
                iArr[KeyCommand.DESELECT.ordinal()] = 45;
            } catch (NoSuchFieldError e45) {
            }
            try {
                iArr[KeyCommand.UNDO.ordinal()] = 46;
            } catch (NoSuchFieldError e46) {
            }
            try {
                iArr[KeyCommand.REDO.ordinal()] = 47;
            } catch (NoSuchFieldError e47) {
            }
            try {
                iArr[KeyCommand.CHARACTER_PALETTE.ordinal()] = 48;
            } catch (NoSuchFieldError e48) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldKeyInput$process$2(KeyCommand keyCommand, TextFieldKeyInput textFieldKeyInput, Ref.BooleanRef booleanRef) {
        super(1);
        this.$command = keyCommand;
        this.this$0 = textFieldKeyInput;
        this.$consumed = booleanRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((TextFieldPreparedSelection) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(TextFieldPreparedSelection $this$commandExecutionContext) {
        TextFieldValue it;
        TextFieldValue it2;
        Intrinsics.checkNotNullParameter($this$commandExecutionContext, "$this$commandExecutionContext");
        switch (WhenMappings.$EnumSwitchMapping$0[this.$command.ordinal()]) {
            case 1:
                this.this$0.getSelectionManager().copy$foundation_release(false);
                return;
            case 2:
                this.this$0.getSelectionManager().paste$foundation_release();
                return;
            case 3:
                this.this$0.getSelectionManager().cut$foundation_release();
                return;
            case 4:
                $this$commandExecutionContext.collapseLeftOr(AnonymousClass1.INSTANCE);
                return;
            case 5:
                $this$commandExecutionContext.collapseRightOr(AnonymousClass2.INSTANCE);
                return;
            case 6:
                $this$commandExecutionContext.moveCursorLeftByWord();
                return;
            case 7:
                $this$commandExecutionContext.moveCursorRightByWord();
                return;
            case 8:
                $this$commandExecutionContext.moveCursorPrevByParagraph();
                return;
            case 9:
                $this$commandExecutionContext.moveCursorNextByParagraph();
                return;
            case 10:
                $this$commandExecutionContext.moveCursorUpByLine();
                return;
            case 11:
                $this$commandExecutionContext.moveCursorDownByLine();
                return;
            case 12:
                $this$commandExecutionContext.moveCursorUpByPage();
                return;
            case 13:
                $this$commandExecutionContext.moveCursorDownByPage();
                return;
            case 14:
                $this$commandExecutionContext.moveCursorToLineStart();
                return;
            case 15:
                $this$commandExecutionContext.moveCursorToLineEnd();
                return;
            case 16:
                $this$commandExecutionContext.moveCursorToLineLeftSide();
                return;
            case 17:
                $this$commandExecutionContext.moveCursorToLineRightSide();
                return;
            case 18:
                $this$commandExecutionContext.moveCursorToHome();
                return;
            case 19:
                $this$commandExecutionContext.moveCursorToEnd();
                return;
            case 20:
                List<EditCommand> deleteIfSelectedOr = $this$commandExecutionContext.deleteIfSelectedOr(AnonymousClass3.INSTANCE);
                if (deleteIfSelectedOr != null) {
                    this.this$0.apply((List<? extends EditCommand>) deleteIfSelectedOr);
                    return;
                }
                return;
            case 21:
                List<EditCommand> deleteIfSelectedOr2 = $this$commandExecutionContext.deleteIfSelectedOr(AnonymousClass4.INSTANCE);
                if (deleteIfSelectedOr2 != null) {
                    this.this$0.apply((List<? extends EditCommand>) deleteIfSelectedOr2);
                    return;
                }
                return;
            case 22:
                List<EditCommand> deleteIfSelectedOr3 = $this$commandExecutionContext.deleteIfSelectedOr(AnonymousClass5.INSTANCE);
                if (deleteIfSelectedOr3 != null) {
                    this.this$0.apply((List<? extends EditCommand>) deleteIfSelectedOr3);
                    return;
                }
                return;
            case 23:
                List<EditCommand> deleteIfSelectedOr4 = $this$commandExecutionContext.deleteIfSelectedOr(AnonymousClass6.INSTANCE);
                if (deleteIfSelectedOr4 != null) {
                    this.this$0.apply((List<? extends EditCommand>) deleteIfSelectedOr4);
                    return;
                }
                return;
            case 24:
                List<EditCommand> deleteIfSelectedOr5 = $this$commandExecutionContext.deleteIfSelectedOr(AnonymousClass7.INSTANCE);
                if (deleteIfSelectedOr5 != null) {
                    this.this$0.apply((List<? extends EditCommand>) deleteIfSelectedOr5);
                    return;
                }
                return;
            case 25:
                List<EditCommand> deleteIfSelectedOr6 = $this$commandExecutionContext.deleteIfSelectedOr(AnonymousClass8.INSTANCE);
                if (deleteIfSelectedOr6 != null) {
                    this.this$0.apply((List<? extends EditCommand>) deleteIfSelectedOr6);
                    return;
                }
                return;
            case 26:
                if (!this.this$0.getSingleLine()) {
                    this.this$0.apply((EditCommand) new CommitTextCommand("\n", 1));
                    return;
                } else {
                    this.$consumed.element = false;
                    return;
                }
            case MotionEventCompat.AXIS_RELATIVE_X /*27*/:
                if (!this.this$0.getSingleLine()) {
                    this.this$0.apply((EditCommand) new CommitTextCommand("\t", 1));
                    return;
                } else {
                    this.$consumed.element = false;
                    return;
                }
            case MotionEventCompat.AXIS_RELATIVE_Y /*28*/:
                $this$commandExecutionContext.selectAll();
                return;
            case 29:
                ((TextFieldPreparedSelection) $this$commandExecutionContext.moveCursorLeft()).selectMovement();
                return;
            case 30:
                ((TextFieldPreparedSelection) $this$commandExecutionContext.moveCursorRight()).selectMovement();
                return;
            case 31:
                ((TextFieldPreparedSelection) $this$commandExecutionContext.moveCursorLeftByWord()).selectMovement();
                return;
            case 32:
                ((TextFieldPreparedSelection) $this$commandExecutionContext.moveCursorRightByWord()).selectMovement();
                return;
            case 33:
                ((TextFieldPreparedSelection) $this$commandExecutionContext.moveCursorPrevByParagraph()).selectMovement();
                return;
            case MotionEventCompat.AXIS_GENERIC_3 /*34*/:
                ((TextFieldPreparedSelection) $this$commandExecutionContext.moveCursorNextByParagraph()).selectMovement();
                return;
            case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
                ((TextFieldPreparedSelection) $this$commandExecutionContext.moveCursorToLineStart()).selectMovement();
                return;
            case 36:
                ((TextFieldPreparedSelection) $this$commandExecutionContext.moveCursorToLineEnd()).selectMovement();
                return;
            case MotionEventCompat.AXIS_GENERIC_6 /*37*/:
                ((TextFieldPreparedSelection) $this$commandExecutionContext.moveCursorToLineLeftSide()).selectMovement();
                return;
            case MotionEventCompat.AXIS_GENERIC_7 /*38*/:
                ((TextFieldPreparedSelection) $this$commandExecutionContext.moveCursorToLineRightSide()).selectMovement();
                return;
            case MotionEventCompat.AXIS_GENERIC_8 /*39*/:
                ((TextFieldPreparedSelection) $this$commandExecutionContext.moveCursorUpByLine()).selectMovement();
                return;
            case MotionEventCompat.AXIS_GENERIC_9 /*40*/:
                ((TextFieldPreparedSelection) $this$commandExecutionContext.moveCursorDownByLine()).selectMovement();
                return;
            case MotionEventCompat.AXIS_GENERIC_10 /*41*/:
                $this$commandExecutionContext.moveCursorUpByPage().selectMovement();
                return;
            case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                $this$commandExecutionContext.moveCursorDownByPage().selectMovement();
                return;
            case MotionEventCompat.AXIS_GENERIC_12 /*43*/:
                ((TextFieldPreparedSelection) $this$commandExecutionContext.moveCursorToHome()).selectMovement();
                return;
            case MotionEventCompat.AXIS_GENERIC_13 /*44*/:
                ((TextFieldPreparedSelection) $this$commandExecutionContext.moveCursorToEnd()).selectMovement();
                return;
            case MotionEventCompat.AXIS_GENERIC_14 /*45*/:
                $this$commandExecutionContext.deselect();
                return;
            case MotionEventCompat.AXIS_GENERIC_15 /*46*/:
                UndoManager undoManager = this.this$0.getUndoManager();
                if (undoManager != null) {
                    undoManager.makeSnapshot($this$commandExecutionContext.getValue());
                }
                UndoManager undoManager2 = this.this$0.getUndoManager();
                if (undoManager2 != null && (it = undoManager2.undo()) != null) {
                    this.this$0.onValueChange.invoke(it);
                    return;
                }
                return;
            case MotionEventCompat.AXIS_GENERIC_16 /*47*/:
                UndoManager undoManager3 = this.this$0.getUndoManager();
                if (undoManager3 != null && (it2 = undoManager3.redo()) != null) {
                    this.this$0.onValueChange.invoke(it2);
                    return;
                }
                return;
            case 48:
                KeyEventHelpers_androidKt.showCharacterPalette();
                return;
            default:
                return;
        }
    }
}
