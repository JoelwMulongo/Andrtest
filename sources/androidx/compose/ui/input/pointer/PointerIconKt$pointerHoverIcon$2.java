package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerIcon.kt */
final class PointerIconKt$pointerHoverIcon$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ PointerIcon $icon;
    final /* synthetic */ boolean $overrideDescendants;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PointerIconKt$pointerHoverIcon$2(PointerIcon pointerIcon, boolean z) {
        super(3);
        this.$icon = pointerIcon;
        this.$overrideDescendants = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        Modifier modifier;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        $composer.startReplaceableGroup(811087536);
        ComposerKt.sourceInformation($composer, "C79@2743L7:PointerIcon.kt#a556rk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(811087536, $changed, -1, "androidx.compose.ui.input.pointer.pointerHoverIcon.<anonymous> (PointerIcon.kt:78)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(CompositionLocalsKt.getLocalPointerIconService());
        ComposerKt.sourceInformationMarkerEnd($composer);
        final PointerIconService pointerIconService = (PointerIconService) consume;
        if (pointerIconService == null) {
            modifier = Modifier.Companion;
        } else {
            PointerIcon pointerIcon = this.$icon;
            Boolean valueOf = Boolean.valueOf(this.$overrideDescendants);
            final boolean z = this.$overrideDescendants;
            final PointerIcon pointerIcon2 = this.$icon;
            modifier = SuspendingPointerInputFilterKt.pointerInput($this$composed, pointerIcon, valueOf, new AnonymousClass1((Continuation<? super AnonymousClass1>) null));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return modifier;
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1", f = "PointerIcon.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1  reason: invalid class name */
    /* compiled from: PointerIcon.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(z, pointerIconService, pointerIcon2, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final boolean z = z;
                    final PointerIconService pointerIconService = pointerIconService;
                    final PointerIcon pointerIcon = pointerIcon2;
                    this.label = 1;
                    if (((PointerInputScope) this.L$0).awaitPointerEventScope(new Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                        private /* synthetic */ Object L$0;
                        int label;

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            AnonymousClass1 r0 = 
                        }
