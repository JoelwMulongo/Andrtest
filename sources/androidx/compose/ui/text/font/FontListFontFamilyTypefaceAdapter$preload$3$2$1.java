package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1", f = "FontListFontFamilyTypefaceAdapter.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
final class FontListFontFamilyTypefaceAdapter$preload$3$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ Font $font;
    final /* synthetic */ PlatformFontLoader $resourceLoader;
    int label;
    final /* synthetic */ FontListFontFamilyTypefaceAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FontListFontFamilyTypefaceAdapter$preload$3$2$1(FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, Font font, PlatformFontLoader platformFontLoader, Continuation<? super FontListFontFamilyTypefaceAdapter$preload$3$2$1> continuation) {
        super(2, continuation);
        this.this$0 = fontListFontFamilyTypefaceAdapter;
        this.$font = font;
        this.$resourceLoader = platformFontLoader;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FontListFontFamilyTypefaceAdapter$preload$3$2$1(this.this$0, this.$font, this.$resourceLoader, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((FontListFontFamilyTypefaceAdapter$preload$3$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1", f = "FontListFontFamilyTypefaceAdapter.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1  reason: invalid class name */
    /* compiled from: FontListFontFamilyTypefaceAdapter.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {
        int label;

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(font2, platformFontLoader2, continuation);
        }

        public final Object invoke(Continuation<Object> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
            if (r9 == null) goto L_0x0042;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
            return r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x005a, code lost:
            throw new java.lang.IllegalStateException("Unable to load font " + r7);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                java.lang.String r2 = "Unable to load font "
                switch(r1) {
                    case 0: goto L_0x001c;
                    case 1: goto L_0x0013;
                    default: goto L_0x000b;
                }
            L_0x000b:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x0013:
                r0 = r8
                kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ Exception -> 0x001a }
                r1 = r0
                r0 = r9
                goto L_0x003e
            L_0x001a:
                r1 = move-exception
                goto L_0x005f
            L_0x001c:
                kotlin.ResultKt.throwOnFailure(r9)
                r1 = r8
                androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1$1 r3 = new androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1$1     // Catch:{ Exception -> 0x005b }
                androidx.compose.ui.text.font.PlatformFontLoader r4 = r8     // Catch:{ Exception -> 0x005b }
                androidx.compose.ui.text.font.Font r5 = r7     // Catch:{ Exception -> 0x005b }
                r6 = 0
                r3.<init>(r4, r5, r6)     // Catch:{ Exception -> 0x005b }
                kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3     // Catch:{ Exception -> 0x005b }
                r4 = r1
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch:{ Exception -> 0x005b }
                r5 = 1
                r1.label = r5     // Catch:{ Exception -> 0x005b }
                r5 = 15000(0x3a98, double:7.411E-320)
                java.lang.Object r3 = kotlinx.coroutines.TimeoutKt.withTimeout(r5, r3, r4)     // Catch:{ Exception -> 0x005b }
                if (r3 != r0) goto L_0x003c
                return r0
            L_0x003c:
                r0 = r9
                r9 = r3
            L_0x003e:
                if (r9 == 0) goto L_0x0042
                return r9
            L_0x0042:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.StringBuilder r2 = r3.append(r2)
                androidx.compose.ui.text.font.Font r3 = r7
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r2 = r2.toString()
                r9.<init>(r2)
                throw r9
            L_0x005b:
                r0 = move-exception
                r7 = r1
                r1 = r0
                r0 = r7
            L_0x005f:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.StringBuilder r2 = r4.append(r2)
                androidx.compose.ui.text.font.Font r4 = r7
                java.lang.StringBuilder r2 = r2.append(r4)
                java.lang.String r2 = r2.toString()
                r4 = r1
                java.lang.Throwable r4 = (java.lang.Throwable) r4
                r3.<init>(r2, r4)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AsyncTypefaceCache access$getAsyncTypefaceCache$p = this.this$0.asyncTypefaceCache;
                Font font = this.$font;
                PlatformFontLoader platformFontLoader = this.$resourceLoader;
                final Font font2 = this.$font;
                final PlatformFontLoader platformFontLoader2 = this.$resourceLoader;
                this.label = 1;
                Object runCached = access$getAsyncTypefaceCache$p.runCached(font, platformFontLoader, true, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this);
                if (runCached == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return runCached;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
