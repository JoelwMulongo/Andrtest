package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/OnPlacedModifier;", "Landroidx/compose/ui/Modifier$Element;", "onPlaced", "", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OnPlacedModifier.kt */
public interface OnPlacedModifier extends Modifier.Element {
    void onPlaced(LayoutCoordinates layoutCoordinates);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: OnPlacedModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(OnPlacedModifier $this, Function1<? super Modifier.Element, Boolean> predicate) {
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            return OnPlacedModifier.super.all(predicate);
        }

        @Deprecated
        public static boolean any(OnPlacedModifier $this, Function1<? super Modifier.Element, Boolean> predicate) {
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            return OnPlacedModifier.super.any(predicate);
        }

        @Deprecated
        public static <R> R foldIn(OnPlacedModifier $this, R initial, Function2<? super R, ? super Modifier.Element, ? extends R> operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            return OnPlacedModifier.super.foldIn(initial, operation);
        }

        @Deprecated
        public static <R> R foldOut(OnPlacedModifier $this, R initial, Function2<? super Modifier.Element, ? super R, ? extends R> operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            return OnPlacedModifier.super.foldOut(initial, operation);
        }

        @Deprecated
        public static Modifier then(OnPlacedModifier $this, Modifier other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return OnPlacedModifier.super.then(other);
        }
    }
}