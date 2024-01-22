package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 *2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0002:\u0001*B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ@\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0019\u0010\u001e\u001a\u0015\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u0001H\u001d0\u001f¢\u0006\u0002\b!H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#J!\u0010$\u001a\u00020\b*\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&J\u0019\u0010'\u001a\u00020\b*\u00020\u0019H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006+"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocal;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "state", "Landroidx/compose/foundation/lazy/layout/BeyondBoundsState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "reverseLayout", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/foundation/lazy/layout/BeyondBoundsState;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;ZLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/foundation/gestures/Orientation;)V", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "getValue", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "addNextInterval", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;", "currentInterval", "direction", "Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "addNextInterval-FR3nfPY", "(Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;I)Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;", "layout", "T", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "layout-o7g1Pn8", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "hasMoreContent", "hasMoreContent-FR3nfPY", "(Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;I)Z", "isOppositeToOrientation", "isOppositeToOrientation-4vf7U8o", "(I)Z", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutBeyondBoundsModifierLocal.kt */
public final class LazyLayoutBeyondBoundsModifierLocal implements ModifierLocalProvider<BeyondBoundsLayout>, BeyondBoundsLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1 emptyBeyondBoundsScope = new LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1();
    private final LazyListBeyondBoundsInfo beyondBoundsInfo;
    private final LayoutDirection layoutDirection;
    private final Orientation orientation;
    private final boolean reverseLayout;
    private final BeyondBoundsState state;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyLayoutBeyondBoundsModifierLocal.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LazyLayoutBeyondBoundsModifierLocal(BeyondBoundsState state2, LazyListBeyondBoundsInfo beyondBoundsInfo2, boolean reverseLayout2, LayoutDirection layoutDirection2, Orientation orientation2) {
        Intrinsics.checkNotNullParameter(state2, "state");
        Intrinsics.checkNotNullParameter(beyondBoundsInfo2, "beyondBoundsInfo");
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        this.state = state2;
        this.beyondBoundsInfo = beyondBoundsInfo2;
        this.reverseLayout = reverseLayout2;
        this.layoutDirection = layoutDirection2;
        this.orientation = orientation2;
    }

    public ProvidableModifierLocal<BeyondBoundsLayout> getKey() {
        return BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout();
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocal$Companion;", "", "()V", "emptyBeyondBoundsScope", "androidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyLayoutBeyondBoundsModifierLocal.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public BeyondBoundsLayout getValue() {
        return this;
    }

    /* renamed from: layout-o7g1Pn8  reason: not valid java name */
    public <T> T m1007layouto7g1Pn8(int direction, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.state.getItemCount() <= 0 || !this.state.getHasVisibleItems()) {
            return block.invoke(emptyBeyondBoundsScope);
        }
        Ref.ObjectRef interval = new Ref.ObjectRef();
        interval.element = this.beyondBoundsInfo.addInterval(this.state.getFirstVisibleIndex(), this.state.getLastVisibleIndex());
        Object found = null;
        while (found == null && m1005hasMoreContentFR3nfPY((LazyListBeyondBoundsInfo.Interval) interval.element, direction)) {
            T r2 = m1004addNextIntervalFR3nfPY((LazyListBeyondBoundsInfo.Interval) interval.element, direction);
            T t = r2;
            this.beyondBoundsInfo.removeInterval((LazyListBeyondBoundsInfo.Interval) interval.element);
            interval.element = r2;
            this.state.remeasure();
            found = block.invoke(new LazyLayoutBeyondBoundsModifierLocal$layout$2(this, interval, direction));
        }
        this.beyondBoundsInfo.removeInterval((LazyListBeyondBoundsInfo.Interval) interval.element);
        this.state.remeasure();
        return found;
    }

    /* renamed from: addNextInterval-FR3nfPY  reason: not valid java name */
    private final LazyListBeyondBoundsInfo.Interval m1004addNextIntervalFR3nfPY(LazyListBeyondBoundsInfo.Interval currentInterval, int direction) {
        int start = currentInterval.getStart();
        int end = currentInterval.getEnd();
        if (BeyondBoundsLayout.LayoutDirection.m4795equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.Companion.m4801getBeforehoxUOeE())) {
            start--;
        } else if (BeyondBoundsLayout.LayoutDirection.m4795equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.Companion.m4800getAfterhoxUOeE())) {
            end++;
        } else if (BeyondBoundsLayout.LayoutDirection.m4795equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.Companion.m4799getAbovehoxUOeE())) {
            if (this.reverseLayout) {
                end++;
            } else {
                start--;
            }
        } else if (BeyondBoundsLayout.LayoutDirection.m4795equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.Companion.m4802getBelowhoxUOeE())) {
            if (this.reverseLayout) {
                start--;
            } else {
                end++;
            }
        } else if (BeyondBoundsLayout.LayoutDirection.m4795equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.Companion.m4803getLefthoxUOeE())) {
            switch (WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()]) {
                case 1:
                    if (!this.reverseLayout) {
                        start--;
                        break;
                    } else {
                        end++;
                        break;
                    }
                case 2:
                    if (!this.reverseLayout) {
                        end++;
                        break;
                    } else {
                        start--;
                        break;
                    }
            }
        } else if (BeyondBoundsLayout.LayoutDirection.m4795equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.Companion.m4804getRighthoxUOeE())) {
            switch (WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()]) {
                case 1:
                    if (!this.reverseLayout) {
                        end++;
                        break;
                    } else {
                        start--;
                        break;
                    }
                case 2:
                    if (!this.reverseLayout) {
                        start--;
                        break;
                    } else {
                        end++;
                        break;
                    }
            }
        } else {
            Void unused = LazyLayoutBeyondBoundsModifierLocalKt.unsupportedDirection();
            throw new KotlinNothingValueException();
        }
        return this.beyondBoundsInfo.addInterval(start, end);
    }

    private static final boolean hasMoreContent_FR3nfPY$hasMoreItemsBefore(LazyListBeyondBoundsInfo.Interval $this_hasMoreContent) {
        return $this_hasMoreContent.getStart() > 0;
    }

    private static final boolean hasMoreContent_FR3nfPY$hasMoreItemsAfter(LazyListBeyondBoundsInfo.Interval $this_hasMoreContent, LazyLayoutBeyondBoundsModifierLocal this$0) {
        return $this_hasMoreContent.getEnd() < this$0.state.getItemCount() - 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: hasMoreContent-FR3nfPY  reason: not valid java name */
    public final boolean m1005hasMoreContentFR3nfPY(LazyListBeyondBoundsInfo.Interval $this$hasMoreContent_u2dFR3nfPY, int direction) {
        if (m1006isOppositeToOrientation4vf7U8o(direction)) {
            return false;
        }
        if (BeyondBoundsLayout.LayoutDirection.m4795equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.Companion.m4801getBeforehoxUOeE())) {
            return hasMoreContent_FR3nfPY$hasMoreItemsBefore($this$hasMoreContent_u2dFR3nfPY);
        }
        if (BeyondBoundsLayout.LayoutDirection.m4795equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.Companion.m4800getAfterhoxUOeE())) {
            return hasMoreContent_FR3nfPY$hasMoreItemsAfter($this$hasMoreContent_u2dFR3nfPY, this);
        }
        if (BeyondBoundsLayout.LayoutDirection.m4795equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.Companion.m4799getAbovehoxUOeE())) {
            return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsAfter($this$hasMoreContent_u2dFR3nfPY, this) : hasMoreContent_FR3nfPY$hasMoreItemsBefore($this$hasMoreContent_u2dFR3nfPY);
        }
        if (BeyondBoundsLayout.LayoutDirection.m4795equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.Companion.m4802getBelowhoxUOeE())) {
            return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsBefore($this$hasMoreContent_u2dFR3nfPY) : hasMoreContent_FR3nfPY$hasMoreItemsAfter($this$hasMoreContent_u2dFR3nfPY, this);
        }
        if (BeyondBoundsLayout.LayoutDirection.m4795equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.Companion.m4803getLefthoxUOeE())) {
            switch (WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()]) {
                case 1:
                    return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsAfter($this$hasMoreContent_u2dFR3nfPY, this) : hasMoreContent_FR3nfPY$hasMoreItemsBefore($this$hasMoreContent_u2dFR3nfPY);
                case 2:
                    return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsBefore($this$hasMoreContent_u2dFR3nfPY) : hasMoreContent_FR3nfPY$hasMoreItemsAfter($this$hasMoreContent_u2dFR3nfPY, this);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else if (BeyondBoundsLayout.LayoutDirection.m4795equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.Companion.m4804getRighthoxUOeE())) {
            switch (WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()]) {
                case 1:
                    return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsBefore($this$hasMoreContent_u2dFR3nfPY) : hasMoreContent_FR3nfPY$hasMoreItemsAfter($this$hasMoreContent_u2dFR3nfPY, this);
                case 2:
                    return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsAfter($this$hasMoreContent_u2dFR3nfPY, this) : hasMoreContent_FR3nfPY$hasMoreItemsBefore($this$hasMoreContent_u2dFR3nfPY);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else {
            Void unused = LazyLayoutBeyondBoundsModifierLocalKt.unsupportedDirection();
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: isOppositeToOrientation-4vf7U8o  reason: not valid java name */
    private final boolean m1006isOppositeToOrientation4vf7U8o(int $this$isOppositeToOrientation_u2d4vf7U8o) {
        boolean z = true;
        if (BeyondBoundsLayout.LayoutDirection.m4795equalsimpl0($this$isOppositeToOrientation_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.m4799getAbovehoxUOeE()) ? true : BeyondBoundsLayout.LayoutDirection.m4795equalsimpl0($this$isOppositeToOrientation_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.m4802getBelowhoxUOeE())) {
            return this.orientation == Orientation.Horizontal;
        }
        if (!(BeyondBoundsLayout.LayoutDirection.m4795equalsimpl0($this$isOppositeToOrientation_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.m4803getLefthoxUOeE()) ? true : BeyondBoundsLayout.LayoutDirection.m4795equalsimpl0($this$isOppositeToOrientation_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.m4804getRighthoxUOeE()))) {
            if (!BeyondBoundsLayout.LayoutDirection.m4795equalsimpl0($this$isOppositeToOrientation_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.m4801getBeforehoxUOeE())) {
                z = BeyondBoundsLayout.LayoutDirection.m4795equalsimpl0($this$isOppositeToOrientation_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.m4800getAfterhoxUOeE());
            }
            if (z) {
                return false;
            }
            Void unused = LazyLayoutBeyondBoundsModifierLocalKt.unsupportedDirection();
            throw new KotlinNothingValueException();
        } else if (this.orientation == Orientation.Vertical) {
            return true;
        } else {
            return false;
        }
    }
}
