package androidx.compose.ui.focus;

import androidx.compose.ui.layout.BeyondBoundsLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006¢\u0006\u0002\b\bH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"searchBeyondBounds", "T", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "searchBeyondBounds--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetModifierNode;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BeyondBoundsLayout.kt */
public final class BeyondBoundsLayoutKt {
    /* renamed from: searchBeyondBounds--OM-vw8  reason: not valid java name */
    public static final <T> T m2835searchBeyondBoundsOMvw8(FocusTargetModifierNode $this$searchBeyondBounds_u2d_u2dOM_u2dvw8, int direction, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> block) {
        int i;
        Intrinsics.checkNotNullParameter($this$searchBeyondBounds_u2d_u2dOM_u2dvw8, "$this$searchBeyondBounds");
        Intrinsics.checkNotNullParameter(block, "block");
        BeyondBoundsLayout beyondBoundsLayoutParent$ui_release = $this$searchBeyondBounds_u2d_u2dOM_u2dvw8.getBeyondBoundsLayoutParent$ui_release();
        if (beyondBoundsLayoutParent$ui_release == null) {
            return null;
        }
        if (FocusDirection.m2839equalsimpl0(direction, FocusDirection.Companion.m2856getUpdhqQ8s())) {
            i = BeyondBoundsLayout.LayoutDirection.Companion.m4799getAbovehoxUOeE();
        } else if (FocusDirection.m2839equalsimpl0(direction, FocusDirection.Companion.m2847getDowndhqQ8s())) {
            i = BeyondBoundsLayout.LayoutDirection.Companion.m4802getBelowhoxUOeE();
        } else if (FocusDirection.m2839equalsimpl0(direction, FocusDirection.Companion.m2851getLeftdhqQ8s())) {
            i = BeyondBoundsLayout.LayoutDirection.Companion.m4803getLefthoxUOeE();
        } else if (FocusDirection.m2839equalsimpl0(direction, FocusDirection.Companion.m2855getRightdhqQ8s())) {
            i = BeyondBoundsLayout.LayoutDirection.Companion.m4804getRighthoxUOeE();
        } else if (FocusDirection.m2839equalsimpl0(direction, FocusDirection.Companion.m2852getNextdhqQ8s())) {
            i = BeyondBoundsLayout.LayoutDirection.Companion.m4800getAfterhoxUOeE();
        } else if (FocusDirection.m2839equalsimpl0(direction, FocusDirection.Companion.m2854getPreviousdhqQ8s())) {
            i = BeyondBoundsLayout.LayoutDirection.Companion.m4801getBeforehoxUOeE();
        } else {
            throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
        }
        return beyondBoundsLayoutParent$ui_release.m4791layouto7g1Pn8(i, block);
    }
}
