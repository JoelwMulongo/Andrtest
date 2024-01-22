package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u0015*\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\t*\u00020\u0015H\u0002ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0018\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0019"}, d2 = {"androidx/compose/material3/SwipeableKt$PreUpPostDownNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "(J)F", "toOffset", "(F)J", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Swipeable.kt */
public final class SwipeableKt$PreUpPostDownNestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ SwipeableState<T> $this_PreUpPostDownNestedScrollConnection;

    SwipeableKt$PreUpPostDownNestedScrollConnection$1(SwipeableState<T> $receiver) {
        this.$this_PreUpPostDownNestedScrollConnection = $receiver;
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m2112onPreScrollOzD1aCk(long available, int source) {
        float delta = toFloat(available);
        if (delta >= 0.0f || !NestedScrollSource.m4561equalsimpl0(source, NestedScrollSource.Companion.m4566getDragWNlRxjI())) {
            return Offset.Companion.m2931getZeroF1C5BW0();
        }
        return toOffset(this.$this_PreUpPostDownNestedScrollConnection.performDrag$material3_release(delta));
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m2110onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (NestedScrollSource.m4561equalsimpl0(source, NestedScrollSource.Companion.m4566getDragWNlRxjI())) {
            return toOffset(this.$this_PreUpPostDownNestedScrollConnection.performDrag$material3_release(toFloat(available)));
        }
        return Offset.Companion.m2931getZeroF1C5BW0();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m2111onPreFlingQWom1Mo(long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1 r0 = (androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1 r0 = new androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1
            r0.<init>(r6, r9)
        L_0x0019:
            r9 = r0
            java.lang.Object r0 = r9.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r9.label
            switch(r2) {
                case 0: goto L_0x0033;
                case 1: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x002d:
            long r7 = r9.J$0
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0074
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r6
            float r3 = androidx.compose.ui.unit.Velocity.m6211getXimpl(r7)
            float r4 = androidx.compose.ui.unit.Velocity.m6212getYimpl(r7)
            long r3 = androidx.compose.ui.geometry.OffsetKt.Offset(r3, r4)
            float r3 = r2.toFloat(r3)
            r4 = 0
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x0075
            androidx.compose.material3.SwipeableState<T> r4 = r2.$this_PreUpPostDownNestedScrollConnection
            androidx.compose.runtime.State r4 = r4.getOffset()
            java.lang.Object r4 = r4.getValue()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            androidx.compose.material3.SwipeableState<T> r5 = r2.$this_PreUpPostDownNestedScrollConnection
            float r5 = r5.getMinBound$material3_release()
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x0075
            androidx.compose.material3.SwipeableState<T> r4 = r2.$this_PreUpPostDownNestedScrollConnection
            r9.J$0 = r7
            r5 = 1
            r9.label = r5
            java.lang.Object r2 = r4.performFling$material3_release(r3, r9)
            if (r2 != r1) goto L_0x0074
            return r1
        L_0x0074:
            goto L_0x007b
        L_0x0075:
            androidx.compose.ui.unit.Velocity$Companion r7 = androidx.compose.ui.unit.Velocity.Companion
            long r7 = r7.m6222getZero9UxMQ8M()
        L_0x007b:
            androidx.compose.ui.unit.Velocity r7 = androidx.compose.ui.unit.Velocity.m6202boximpl(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1.m2111onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m2109onPostFlingRZ2iAVY(long r5, long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
        /*
            r4 = this;
            boolean r5 = r9 instanceof androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1
            if (r5 == 0) goto L_0x0014
            r5 = r9
            androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1 r5 = (androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1) r5
            int r6 = r5.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r6 & r0
            if (r6 == 0) goto L_0x0014
            int r6 = r5.label
            int r6 = r6 - r0
            r5.label = r6
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1 r5 = new androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1
            r5.<init>(r4, r9)
        L_0x0019:
            java.lang.Object r6 = r5.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r5.label
            switch(r0) {
                case 0: goto L_0x0032;
                case 1: goto L_0x002c;
                default: goto L_0x0024;
            }
        L_0x0024:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x002c:
            long r7 = r5.J$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0054
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            r0 = r4
            androidx.compose.material3.SwipeableState<T> r1 = r0.$this_PreUpPostDownNestedScrollConnection
            float r2 = androidx.compose.ui.unit.Velocity.m6211getXimpl(r7)
            float r3 = androidx.compose.ui.unit.Velocity.m6212getYimpl(r7)
            long r2 = androidx.compose.ui.geometry.OffsetKt.Offset(r2, r3)
            float r2 = r0.toFloat(r2)
            r5.J$0 = r7
            r3 = 1
            r5.label = r3
            java.lang.Object r0 = r1.performFling$material3_release(r2, r5)
            if (r0 != r9) goto L_0x0054
            return r9
        L_0x0054:
            androidx.compose.ui.unit.Velocity r9 = androidx.compose.ui.unit.Velocity.m6202boximpl(r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1.m2109onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final long toOffset(float $this$toOffset) {
        return OffsetKt.Offset(0.0f, $this$toOffset);
    }

    private final float toFloat(long $this$toFloat) {
        return Offset.m2916getYimpl($this$toFloat);
    }
}
