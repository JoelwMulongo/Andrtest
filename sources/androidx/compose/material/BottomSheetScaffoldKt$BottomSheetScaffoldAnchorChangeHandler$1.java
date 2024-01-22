package androidx.compose.material;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\n"}, d2 = {"<anonymous>", "", "previousTarget", "Landroidx/compose/material/BottomSheetValue;", "previousAnchors", "", "", "newAnchors"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeHandler$1 implements AnchorChangeHandler<BottomSheetValue> {
    final /* synthetic */ Function1<BottomSheetValue, Unit> $animateTo;
    final /* synthetic */ Function1<BottomSheetValue, Unit> $snapTo;
    final /* synthetic */ BottomSheetState $state;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BottomSheetScaffold.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BottomSheetValue.values().length];
            try {
                iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[BottomSheetValue.Expanded.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeHandler$1(BottomSheetState bottomSheetState, Function1<? super BottomSheetValue, Unit> function1, Function1<? super BottomSheetValue, Unit> function12) {
        this.$state = bottomSheetState;
        this.$animateTo = function1;
        this.$snapTo = function12;
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [java.util.Map<androidx.compose.material.BottomSheetValue, java.lang.Float>, java.util.Map, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onAnchorsChanged(androidx.compose.material.BottomSheetValue r5, java.util.Map<androidx.compose.material.BottomSheetValue, java.lang.Float> r6, java.util.Map<androidx.compose.material.BottomSheetValue, java.lang.Float> r7) {
        /*
            r4 = this;
            java.lang.String r0 = "previousTarget"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "previousAnchors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "newAnchors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.Object r0 = r6.get(r5)
            java.lang.Float r0 = (java.lang.Float) r0
            int[] r1 = androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeHandler$1.WhenMappings.$EnumSwitchMapping$0
            int r2 = r5.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto L_0x0037;
                case 2: goto L_0x0029;
                default: goto L_0x0023;
            }
        L_0x0023:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x0029:
            androidx.compose.material.BottomSheetValue r1 = androidx.compose.material.BottomSheetValue.Expanded
            boolean r1 = r7.containsKey(r1)
            if (r1 == 0) goto L_0x0034
            androidx.compose.material.BottomSheetValue r1 = androidx.compose.material.BottomSheetValue.Expanded
            goto L_0x0039
        L_0x0034:
            androidx.compose.material.BottomSheetValue r1 = androidx.compose.material.BottomSheetValue.Collapsed
            goto L_0x0039
        L_0x0037:
            androidx.compose.material.BottomSheetValue r1 = androidx.compose.material.BottomSheetValue.Collapsed
        L_0x0039:
            java.lang.Object r2 = kotlin.collections.MapsKt.getValue(r7, r1)
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((float) r2, (java.lang.Float) r0)
            if (r3 != 0) goto L_0x005d
            androidx.compose.material.BottomSheetState r3 = r4.$state
            boolean r3 = r3.isAnimationRunning$material_release()
            if (r3 == 0) goto L_0x0058
            kotlin.jvm.functions.Function1<androidx.compose.material.BottomSheetValue, kotlin.Unit> r3 = r4.$animateTo
            r3.invoke(r1)
            goto L_0x005d
        L_0x0058:
            kotlin.jvm.functions.Function1<androidx.compose.material.BottomSheetValue, kotlin.Unit> r3 = r4.$snapTo
            r3.invoke(r1)
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeHandler$1.onAnchorsChanged(androidx.compose.material.BottomSheetValue, java.util.Map, java.util.Map):void");
    }
}
