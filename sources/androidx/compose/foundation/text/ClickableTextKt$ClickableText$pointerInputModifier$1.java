package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1", f = "ClickableText.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ClickableText.kt */
final class ClickableTextKt$ClickableText$pointerInputModifier$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;
    final /* synthetic */ Function1<Integer, Unit> $onClick;
    final /* synthetic */ Function1<Integer, Unit> $onHover;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableTextKt$ClickableText$pointerInputModifier$1(CoroutineScope coroutineScope, Function1<? super Integer, Unit> function1, MutableState<TextLayoutResult> mutableState, Function1<? super Integer, Unit> function12, Continuation<? super ClickableTextKt$ClickableText$pointerInputModifier$1> continuation) {
        super(2, continuation);
        this.$coroutineScope = coroutineScope;
        this.$onHover = function1;
        this.$layoutResult = mutableState;
        this.$onClick = function12;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ClickableTextKt$ClickableText$pointerInputModifier$1 clickableTextKt$ClickableText$pointerInputModifier$1 = new ClickableTextKt$ClickableText$pointerInputModifier$1(this.$coroutineScope, this.$onHover, this.$layoutResult, this.$onClick, continuation);
        clickableTextKt$ClickableText$pointerInputModifier$1.L$0 = obj;
        return clickableTextKt$ClickableText$pointerInputModifier$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((ClickableTextKt$ClickableText$pointerInputModifier$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1$1", f = "ClickableText.kt", i = {}, l = {165}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1$1  reason: invalid class name */
    /* compiled from: ClickableText.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1($this$pointerInput, function1, mutableState, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final Ref.ObjectRef previousIndex = new Ref.ObjectRef();
                    PointerInputScope pointerInputScope = $this$pointerInput;
                    PointerEventPass pointerEventPass = PointerEventPass.Main;
                    final Function1<Integer, Unit> function1 = function1;
                    final MutableState<TextLayoutResult> mutableState = mutableState;
                    this.label = 1;
                    if (PointerMoveDetectorKt.detectMoves(pointerInputScope, pointerEventPass, new Function1<Offset, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            m1129invokek4lQ0M(((Offset) p1).m2925unboximpl());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                        public final void m1129invokek4lQ0M(long pos) {
                            Integer index = ClickableTextKt.ClickableText_03UYbkw$getOffset(mutableState, pos);
                            if (!Intrinsics.areEqual((Object) previousIndex.element, (Object) index)) {
                                previousIndex.element = index;
                                function1.invoke(index);
                            }
                        }
                    }, this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                CoroutineScope coroutineScope = this.$coroutineScope;
                final Function1<Integer, Unit> function1 = this.$onHover;
                final MutableState<TextLayoutResult> mutableState = this.$layoutResult;
                Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
                final Function1<Integer, Unit> function12 = this.$onClick;
                final MutableState<TextLayoutResult> mutableState2 = this.$layoutResult;
                this.label = 1;
                if (TapGestureDetectorKt.detectTapGestures$default($this$pointerInput, (Function1) null, (Function1) null, (Function3) null, new Function1<Offset, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        m1130invokek4lQ0M(((Offset) p1).m2925unboximpl());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                    public final void m1130invokek4lQ0M(long pos) {
                        Integer access$ClickableText_03UYbkw$getOffset = ClickableTextKt.ClickableText_03UYbkw$getOffset(mutableState2, pos);
                        if (access$ClickableText_03UYbkw$getOffset != null) {
                            function12.invoke(access$ClickableText_03UYbkw$getOffset);
                        }
                    }
                }, this, 7, (Object) null) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
