package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.FontFamily;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J=\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\u0006\u0010\"\u001a\u00020\u000fH\u0002R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"Landroidx/compose/ui/text/font/FontFamilyResolverImpl;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "platformResolveInterceptor", "Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "typefaceRequestCache", "Landroidx/compose/ui/text/font/TypefaceRequestCache;", "fontListFontFamilyTypefaceAdapter", "Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;", "platformFamilyTypefaceAdapter", "Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;", "(Landroidx/compose/ui/text/font/PlatformFontLoader;Landroidx/compose/ui/text/font/PlatformResolveInterceptor;Landroidx/compose/ui/text/font/TypefaceRequestCache;Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;)V", "createDefaultTypeface", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceRequest;", "", "getPlatformFontLoader$ui_text_release", "()Landroidx/compose/ui/text/font/PlatformFontLoader;", "preload", "", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "(Landroidx/compose/ui/text/font/FontFamily;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "Landroidx/compose/runtime/State;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "resolve-DPcqOEQ", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/runtime/State;", "typefaceRequest", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontFamilyResolver.kt */
public final class FontFamilyResolverImpl implements FontFamily.Resolver {
    /* access modifiers changed from: private */
    public final Function1<TypefaceRequest, Object> createDefaultTypeface;
    /* access modifiers changed from: private */
    public final FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter;
    /* access modifiers changed from: private */
    public final PlatformFontFamilyTypefaceAdapter platformFamilyTypefaceAdapter;
    private final PlatformFontLoader platformFontLoader;
    private final PlatformResolveInterceptor platformResolveInterceptor;
    private final TypefaceRequestCache typefaceRequestCache;

    public FontFamilyResolverImpl(PlatformFontLoader platformFontLoader2, PlatformResolveInterceptor platformResolveInterceptor2, TypefaceRequestCache typefaceRequestCache2, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter2, PlatformFontFamilyTypefaceAdapter platformFamilyTypefaceAdapter2) {
        Intrinsics.checkNotNullParameter(platformFontLoader2, "platformFontLoader");
        Intrinsics.checkNotNullParameter(platformResolveInterceptor2, "platformResolveInterceptor");
        Intrinsics.checkNotNullParameter(typefaceRequestCache2, "typefaceRequestCache");
        Intrinsics.checkNotNullParameter(fontListFontFamilyTypefaceAdapter2, "fontListFontFamilyTypefaceAdapter");
        Intrinsics.checkNotNullParameter(platformFamilyTypefaceAdapter2, "platformFamilyTypefaceAdapter");
        this.platformFontLoader = platformFontLoader2;
        this.platformResolveInterceptor = platformResolveInterceptor2;
        this.typefaceRequestCache = typefaceRequestCache2;
        this.fontListFontFamilyTypefaceAdapter = fontListFontFamilyTypefaceAdapter2;
        this.platformFamilyTypefaceAdapter = platformFamilyTypefaceAdapter2;
        this.createDefaultTypeface = new FontFamilyResolverImpl$createDefaultTypeface$1(this);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FontFamilyResolverImpl(androidx.compose.ui.text.font.PlatformFontLoader r7, androidx.compose.ui.text.font.PlatformResolveInterceptor r8, androidx.compose.ui.text.font.TypefaceRequestCache r9, androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter r10, androidx.compose.ui.text.font.PlatformFontFamilyTypefaceAdapter r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 2
            if (r13 == 0) goto L_0x000c
            androidx.compose.ui.text.font.PlatformResolveInterceptor$Companion r8 = androidx.compose.ui.text.font.PlatformResolveInterceptor.Companion
            androidx.compose.ui.text.font.PlatformResolveInterceptor r8 = r8.getDefault$ui_text_release()
            r2 = r8
            goto L_0x000d
        L_0x000c:
            r2 = r8
        L_0x000d:
            r8 = r12 & 4
            if (r8 == 0) goto L_0x0017
            androidx.compose.ui.text.font.TypefaceRequestCache r9 = androidx.compose.ui.text.font.FontFamilyResolverKt.getGlobalTypefaceRequestCache()
            r3 = r9
            goto L_0x0018
        L_0x0017:
            r3 = r9
        L_0x0018:
            r8 = r12 & 8
            if (r8 == 0) goto L_0x0029
            androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter r10 = new androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter
            androidx.compose.ui.text.font.AsyncTypefaceCache r8 = androidx.compose.ui.text.font.FontFamilyResolverKt.getGlobalAsyncTypefaceCache()
            r9 = 0
            r13 = 2
            r10.<init>(r8, r9, r13, r9)
            r4 = r10
            goto L_0x002a
        L_0x0029:
            r4 = r10
        L_0x002a:
            r8 = r12 & 16
            if (r8 == 0) goto L_0x0035
            androidx.compose.ui.text.font.PlatformFontFamilyTypefaceAdapter r11 = new androidx.compose.ui.text.font.PlatformFontFamilyTypefaceAdapter
            r11.<init>()
            r5 = r11
            goto L_0x0036
        L_0x0035:
            r5 = r11
        L_0x0036:
            r0 = r6
            r1 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontFamilyResolverImpl.<init>(androidx.compose.ui.text.font.PlatformFontLoader, androidx.compose.ui.text.font.PlatformResolveInterceptor, androidx.compose.ui.text.font.TypefaceRequestCache, androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter, androidx.compose.ui.text.font.PlatformFontFamilyTypefaceAdapter, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final PlatformFontLoader getPlatformFontLoader$ui_text_release() {
        return this.platformFontLoader;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0081 A[LOOP:0: B:20:0x007f->B:21:0x0081, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object preload(androidx.compose.ui.text.font.FontFamily r26, kotlin.coroutines.Continuation<? super kotlin.Unit> r27) {
        /*
            r25 = this;
            r0 = r27
            boolean r1 = r0 instanceof androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1
            if (r1 == 0) goto L_0x0019
            r1 = r0
            androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1 r1 = (androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0019
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r25
            goto L_0x0021
        L_0x0019:
            androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1 r1 = new androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1
            r2 = r25
            r1.<init>(r2, r0)
            r0 = r1
        L_0x0021:
            java.lang.Object r1 = r0.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r0.label
            switch(r4) {
                case 0: goto L_0x0044;
                case 1: goto L_0x0038;
                default: goto L_0x002c;
            }
        L_0x002c:
            r27 = r0
            r24 = r1
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0038:
            java.lang.Object r3 = r0.L$1
            androidx.compose.ui.text.font.FontFamily r3 = (androidx.compose.ui.text.font.FontFamily) r3
            java.lang.Object r4 = r0.L$0
            androidx.compose.ui.text.font.FontFamilyResolverImpl r4 = (androidx.compose.ui.text.font.FontFamilyResolverImpl) r4
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0065
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r1)
            r4 = r25
            r5 = r26
            boolean r6 = r5 instanceof androidx.compose.ui.text.font.FontListFontFamily
            if (r6 != 0) goto L_0x0052
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        L_0x0052:
            androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter r6 = r4.fontListFontFamilyTypefaceAdapter
            androidx.compose.ui.text.font.PlatformFontLoader r7 = r4.platformFontLoader
            r0.L$0 = r4
            r0.L$1 = r5
            r8 = 1
            r0.label = r8
            java.lang.Object r6 = r6.preload(r5, r7, r0)
            if (r6 != r3) goto L_0x0064
            return r3
        L_0x0064:
            r3 = r5
        L_0x0065:
            r5 = r3
            androidx.compose.ui.text.font.FontListFontFamily r5 = (androidx.compose.ui.text.font.FontListFontFamily) r5
            java.util.List r5 = r5.getFonts()
            r6 = 0
            java.util.ArrayList r7 = new java.util.ArrayList
            int r8 = r5.size()
            r7.<init>(r8)
            r8 = 0
            r9 = 0
            int r10 = r5.size()
        L_0x007f:
            if (r9 >= r10) goto L_0x00d0
            java.lang.Object r11 = r5.get(r9)
            r12 = r11
            r13 = 0
            r14 = r7
            java.util.Collection r14 = (java.util.Collection) r14
            r15 = r12
            androidx.compose.ui.text.font.Font r15 = (androidx.compose.ui.text.font.Font) r15
            r16 = 0
            r27 = r0
            androidx.compose.ui.text.font.TypefaceRequest r0 = new androidx.compose.ui.text.font.TypefaceRequest
            r24 = r1
            androidx.compose.ui.text.font.PlatformResolveInterceptor r1 = r4.platformResolveInterceptor
            androidx.compose.ui.text.font.FontFamily r18 = r1.interceptFontFamily(r3)
            androidx.compose.ui.text.font.PlatformResolveInterceptor r1 = r4.platformResolveInterceptor
            androidx.compose.ui.text.font.FontWeight r2 = r15.getWeight()
            androidx.compose.ui.text.font.FontWeight r19 = r1.interceptFontWeight(r2)
            androidx.compose.ui.text.font.PlatformResolveInterceptor r1 = r4.platformResolveInterceptor
            int r2 = r15.m5535getStyle_LCdwA()
            int r20 = r1.m5586interceptFontStyleT2F_aPo(r2)
            androidx.compose.ui.text.font.FontSynthesis$Companion r1 = androidx.compose.ui.text.font.FontSynthesis.Companion
            int r21 = r1.m5578getAllGVVA2EU()
            androidx.compose.ui.text.font.PlatformFontLoader r1 = r4.platformFontLoader
            java.lang.Object r22 = r1.getCacheKey()
            r23 = 0
            r17 = r0
            r17.<init>(r18, r19, r20, r21, r22, r23)
            r14.add(r0)
            int r9 = r9 + 1
            r2 = r25
            r0 = r27
            r1 = r24
            goto L_0x007f
        L_0x00d0:
            r27 = r0
            r24 = r1
            r0 = r7
            java.util.List r0 = (java.util.List) r0
            androidx.compose.ui.text.font.TypefaceRequestCache r1 = r4.typefaceRequestCache
            androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2 r2 = new androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2
            r2.<init>(r4)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r1.preWarmCache(r0, r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontFamilyResolverImpl.preload(androidx.compose.ui.text.font.FontFamily, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: resolve-DPcqOEQ  reason: not valid java name */
    public State<Object> m5538resolveDPcqOEQ(FontFamily fontFamily, FontWeight fontWeight, int fontStyle, int fontSynthesis) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return resolve(new TypefaceRequest(this.platformResolveInterceptor.interceptFontFamily(fontFamily), this.platformResolveInterceptor.interceptFontWeight(fontWeight), this.platformResolveInterceptor.m5586interceptFontStyleT2F_aPo(fontStyle), this.platformResolveInterceptor.m5587interceptFontSynthesisMscr08Y(fontSynthesis), this.platformFontLoader.getCacheKey(), (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    public final State<Object> resolve(TypefaceRequest typefaceRequest) {
        return this.typefaceRequestCache.runCached(typefaceRequest, new FontFamilyResolverImpl$resolve$result$1(this, typefaceRequest));
    }
}
