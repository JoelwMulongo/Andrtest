package androidx.compose.ui.text.font;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3", f = "FontListFontFamilyTypefaceAdapter.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
final class FontListFontFamilyTypefaceAdapter$preload$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Font> $asyncLoads;
    final /* synthetic */ PlatformFontLoader $resourceLoader;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FontListFontFamilyTypefaceAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FontListFontFamilyTypefaceAdapter$preload$3(List<Font> list, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, PlatformFontLoader platformFontLoader, Continuation<? super FontListFontFamilyTypefaceAdapter$preload$3> continuation) {
        super(2, continuation);
        this.$asyncLoads = list;
        this.this$0 = fontListFontFamilyTypefaceAdapter;
        this.$resourceLoader = platformFontLoader;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FontListFontFamilyTypefaceAdapter$preload$3 fontListFontFamilyTypefaceAdapter$preload$3 = new FontListFontFamilyTypefaceAdapter$preload$3(this.$asyncLoads, this.this$0, this.$resourceLoader, continuation);
        fontListFontFamilyTypefaceAdapter$preload$3.L$0 = obj;
        return fontListFontFamilyTypefaceAdapter$preload$3;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FontListFontFamilyTypefaceAdapter$preload$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Object $result2 = $result;
                CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                List $this$fastDistinctBy$iv = this.$asyncLoads;
                HashSet set$iv = new HashSet($this$fastDistinctBy$iv.size());
                List target$iv = new ArrayList($this$fastDistinctBy$iv.size());
                int size = $this$fastDistinctBy$iv.size();
                for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                    Object obj = $this$fastDistinctBy$iv.get(index$iv$iv);
                    if (set$iv.add((Font) obj)) {
                        target$iv.add(obj);
                    }
                }
                List $this$fastMap$iv = target$iv;
                FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter = this.this$0;
                PlatformFontLoader platformFontLoader = this.$resourceLoader;
                ArrayList target$iv2 = new ArrayList($this$fastMap$iv.size());
                List $this$fastForEach$iv$iv = $this$fastMap$iv;
                int index$iv$iv2 = 0;
                for (int size2 = $this$fastForEach$iv$iv.size(); index$iv$iv2 < size2; size2 = size2) {
                    Font font = (Font) $this$fastForEach$iv$iv.get(index$iv$iv2);
                    Font font2 = font;
                    target$iv2.add(BuildersKt__Builders_commonKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new FontListFontFamilyTypefaceAdapter$preload$3$2$1(fontListFontFamilyTypefaceAdapter, font, platformFontLoader, (Continuation<? super FontListFontFamilyTypefaceAdapter$preload$3$2$1>) null), 3, (Object) null));
                    index$iv$iv2++;
                }
                int i = index$iv$iv2;
                this.label = 1;
                if (AwaitKt.joinAll((Collection<? extends Job>) target$iv2, (Continuation<? super Unit>) this) != coroutine_suspended) {
                    Object obj2 = $result2;
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
