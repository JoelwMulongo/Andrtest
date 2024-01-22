package androidx.compose.ui.input.nestedscroll;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J)\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b&\u0010'J-\u0010(\u001a\u00020)2\u0006\u0010$\u001a\u00020)2\u0006\u0010%\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-J!\u0010.\u001a\u00020#2\u0006\u0010%\u001a\u00020#H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b/\u00100J%\u00101\u001a\u00020)2\u0006\u0010%\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R/\u0010\u0015\u001a\u0004\u0018\u00010\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u00008B@BX\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00064"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollModifierLocal;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "connection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getDispatcher", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "nestedCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getNestedCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "<set-?>", "parent", "getParent", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollModifierLocal;", "setParent", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollModifierLocal;)V", "parent$delegate", "Landroidx/compose/runtime/MutableState;", "value", "getValue", "onModifierLocalsUpdated", "", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NestedScrollModifierLocal.kt */
public final class NestedScrollModifierLocal implements ModifierLocalConsumer, ModifierLocalProvider<NestedScrollModifierLocal>, NestedScrollConnection {
    private final NestedScrollConnection connection;
    private final NestedScrollDispatcher dispatcher;
    private final MutableState parent$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);

    public NestedScrollModifierLocal(NestedScrollDispatcher dispatcher2, NestedScrollConnection connection2) {
        Intrinsics.checkNotNullParameter(dispatcher2, "dispatcher");
        Intrinsics.checkNotNullParameter(connection2, "connection");
        this.dispatcher = dispatcher2;
        this.connection = connection2;
        dispatcher2.setCalculateNestedScrollScope$ui_release(new Function0<CoroutineScope>(this) {
            final /* synthetic */ NestedScrollModifierLocal this$0;

            {
                this.this$0 = r2;
            }

            public final CoroutineScope invoke() {
                return this.this$0.getNestedCoroutineScope();
            }
        });
    }

    public final NestedScrollDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final NestedScrollConnection getConnection() {
        return this.connection;
    }

    private final NestedScrollModifierLocal getParent() {
        return (NestedScrollModifierLocal) this.parent$delegate.getValue();
    }

    private final void setParent(NestedScrollModifierLocal nestedScrollModifierLocal) {
        this.parent$delegate.setValue(nestedScrollModifierLocal);
    }

    /* access modifiers changed from: private */
    public final CoroutineScope getNestedCoroutineScope() {
        CoroutineScope coroutineScope;
        NestedScrollModifierLocal parent = getParent();
        if ((parent != null && (coroutineScope = parent.getNestedCoroutineScope()) != null) || (coroutineScope = this.dispatcher.getOriginNestedScrollScope$ui_release()) != null) {
            return coroutineScope;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    public ProvidableModifierLocal<NestedScrollModifierLocal> getKey() {
        return NestedScrollModifierLocalKt.getModifierLocalNestedScroll();
    }

    public NestedScrollModifierLocal getValue() {
        return this;
    }

    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        setParent((NestedScrollModifierLocal) scope.getCurrent(NestedScrollModifierLocalKt.getModifierLocalNestedScroll()));
        this.dispatcher.setParent$ui_release(getParent());
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m4557onPreScrollOzD1aCk(long available, int source) {
        NestedScrollModifierLocal parent = getParent();
        long parentPreConsumed = parent != null ? parent.m4557onPreScrollOzD1aCk(available, source) : Offset.Companion.m2931getZeroF1C5BW0();
        return Offset.m2920plusMKHz9U(parentPreConsumed, this.connection.m4545onPreScrollOzD1aCk(Offset.m2919minusMKHz9U(available, parentPreConsumed), source));
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m4555onPostScrollDzOQY0M(long consumed, long available, int source) {
        long parentConsumed;
        long selfConsumed = this.connection.m4543onPostScrollDzOQY0M(consumed, available, source);
        NestedScrollModifierLocal parent = getParent();
        if (parent != null) {
            parentConsumed = parent.m4555onPostScrollDzOQY0M(Offset.m2920plusMKHz9U(consumed, selfConsumed), Offset.m2919minusMKHz9U(available, selfConsumed), source);
        } else {
            parentConsumed = Offset.Companion.m2931getZeroF1C5BW0();
        }
        return Offset.m2920plusMKHz9U(selfConsumed, parentConsumed);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0065, code lost:
        r5 = r2.connection;
        r6 = androidx.compose.ui.unit.Velocity.m6214minusAH228Gc(r10, r3);
        r12.L$0 = null;
        r12.J$0 = r3;
        r12.label = 2;
        r10 = r5.m4544onPreFlingQWom1Mo(r6, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0077, code lost:
        if (r10 != r1) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0079, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0088, code lost:
        return androidx.compose.ui.unit.Velocity.m6202boximpl(androidx.compose.ui.unit.Velocity.m6215plusAH228Gc(r3, ((androidx.compose.ui.unit.Velocity) r10).m6220unboximpl()));
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m4556onPreFlingQWom1Mo(long r10, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPreFling$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPreFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPreFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPreFling$1
            r0.<init>(r9, r12)
        L_0x0019:
            r12 = r0
            java.lang.Object r0 = r12.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r12.label
            switch(r2) {
                case 0: goto L_0x0040;
                case 1: goto L_0x0035;
                case 2: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x002d:
            long r10 = r12.J$0
            kotlin.ResultKt.throwOnFailure(r0)
            r3 = r10
            r10 = r0
            goto L_0x007a
        L_0x0035:
            long r10 = r12.J$0
            java.lang.Object r2 = r12.L$0
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal r2 = (androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal) r2
            kotlin.ResultKt.throwOnFailure(r0)
            r3 = r0
            goto L_0x0058
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r9
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal r3 = r2.getParent()
            if (r3 == 0) goto L_0x005f
            r12.L$0 = r2
            r12.J$0 = r10
            r4 = 1
            r12.label = r4
            java.lang.Object r3 = r3.m4556onPreFlingQWom1Mo(r10, r12)
            if (r3 != r1) goto L_0x0058
            return r1
        L_0x0058:
            androidx.compose.ui.unit.Velocity r3 = (androidx.compose.ui.unit.Velocity) r3
            long r3 = r3.m6220unboximpl()
            goto L_0x0065
        L_0x005f:
            androidx.compose.ui.unit.Velocity$Companion r3 = androidx.compose.ui.unit.Velocity.Companion
            long r3 = r3.m6222getZero9UxMQ8M()
        L_0x0065:
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r5 = r2.connection
            long r6 = androidx.compose.ui.unit.Velocity.m6214minusAH228Gc(r10, r3)
            r8 = 0
            r12.L$0 = r8
            r12.J$0 = r3
            r8 = 2
            r12.label = r8
            java.lang.Object r10 = r5.m4544onPreFlingQWom1Mo(r6, r12)
            if (r10 != r1) goto L_0x007a
            return r1
        L_0x007a:
            androidx.compose.ui.unit.Velocity r10 = (androidx.compose.ui.unit.Velocity) r10
            long r10 = r10.m6220unboximpl()
            long r1 = androidx.compose.ui.unit.Velocity.m6215plusAH228Gc(r3, r10)
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m6202boximpl(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal.m4556onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m4554onPostFlingRZ2iAVY(long r20, long r22, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r24) {
        /*
            r19 = this;
            r0 = r24
            boolean r1 = r0 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPostFling$1
            if (r1 == 0) goto L_0x0019
            r1 = r0
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPostFling$1 r1 = (androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPostFling$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0019
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r19
            goto L_0x0021
        L_0x0019:
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPostFling$1 r1 = new androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPostFling$1
            r2 = r19
            r1.<init>(r2, r0)
            r0 = r1
        L_0x0021:
            java.lang.Object r1 = r0.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            switch(r3) {
                case 0: goto L_0x004c;
                case 1: goto L_0x003d;
                case 2: goto L_0x0034;
                default: goto L_0x002c;
            }
        L_0x002c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0034:
            long r3 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r1)
            r17 = r3
            r3 = r1
            goto L_0x0093
        L_0x003d:
            long r3 = r0.J$1
            long r5 = r0.J$0
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal r7 = (androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal) r7
            kotlin.ResultKt.throwOnFailure(r1)
            r13 = r3
            r11 = r5
            r3 = r1
            goto L_0x006b
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r1)
            r10 = r19
            r11 = r20
            r13 = r22
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r3 = r10.connection
            r0.L$0 = r10
            r0.J$0 = r11
            r0.J$1 = r13
            r4 = 1
            r0.label = r4
            r4 = r11
            r6 = r13
            r8 = r0
            java.lang.Object r3 = r3.m4542onPostFlingRZ2iAVY(r4, r6, r8)
            if (r3 != r9) goto L_0x006a
            return r9
        L_0x006a:
            r7 = r10
        L_0x006b:
            androidx.compose.ui.unit.Velocity r3 = (androidx.compose.ui.unit.Velocity) r3
            long r4 = r3.m6220unboximpl()
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal r3 = r7.getParent()
            if (r3 == 0) goto L_0x009c
            long r6 = androidx.compose.ui.unit.Velocity.m6215plusAH228Gc(r11, r4)
            long r15 = androidx.compose.ui.unit.Velocity.m6214minusAH228Gc(r13, r4)
            r8 = 0
            r0.L$0 = r8
            r0.J$0 = r4
            r8 = 2
            r0.label = r8
            r17 = r4
            r4 = r6
            r6 = r15
            r8 = r0
            java.lang.Object r3 = r3.m4554onPostFlingRZ2iAVY(r4, r6, r8)
            if (r3 != r9) goto L_0x0093
            return r9
        L_0x0093:
            androidx.compose.ui.unit.Velocity r3 = (androidx.compose.ui.unit.Velocity) r3
            long r3 = r3.m6220unboximpl()
        L_0x0099:
            r5 = r17
            goto L_0x00a5
        L_0x009c:
            r17 = r4
            androidx.compose.ui.unit.Velocity$Companion r3 = androidx.compose.ui.unit.Velocity.Companion
            long r3 = r3.m6222getZero9UxMQ8M()
            goto L_0x0099
        L_0x00a5:
            long r7 = androidx.compose.ui.unit.Velocity.m6215plusAH228Gc(r5, r3)
            androidx.compose.ui.unit.Velocity r7 = androidx.compose.ui.unit.Velocity.m6202boximpl(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal.m4554onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
