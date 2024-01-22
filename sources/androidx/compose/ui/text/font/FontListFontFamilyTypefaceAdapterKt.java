package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.AsyncTypefaceCache;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\fH\u0002¨\u0006\r"}, d2 = {"firstImmediatelyAvailable", "Lkotlin/Pair;", "", "Landroidx/compose/ui/text/font/Font;", "", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "createDefaultTypeface", "Lkotlin/Function1;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
public final class FontListFontFamilyTypefaceAdapterKt {
    /* access modifiers changed from: private */
    public static final Pair<List<Font>, Object> firstImmediatelyAvailable(List<? extends Font> $this$firstImmediatelyAvailable, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, PlatformFontLoader platformFontLoader, Function1<? super TypefaceRequest, ? extends Object> createDefaultTypeface) {
        Object result;
        Object obj;
        Object it$iv;
        PlatformFontLoader platformFontLoader2 = platformFontLoader;
        int size = $this$firstImmediatelyAvailable.size();
        List asyncFontsToLoad = null;
        for (int idx = 0; idx < size; idx++) {
            Font font = (Font) $this$firstImmediatelyAvailable.get(idx);
            int r0 = font.m5534getLoadingStrategyPKNRLFQ();
            if (FontLoadingStrategy.m5550equalsimpl0(r0, FontLoadingStrategy.Companion.m5555getBlockingPKNRLFQ())) {
                AsyncTypefaceCache this_$iv = asyncTypefaceCache;
                synchronized (this_$iv.cacheLock) {
                    AsyncTypefaceCache.Key key$iv = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                    AsyncTypefaceCache.AsyncTypefaceResult priorResult$iv = (AsyncTypefaceCache.AsyncTypefaceResult) this_$iv.resultCache.get(key$iv);
                    if (priorResult$iv == null) {
                        priorResult$iv = (AsyncTypefaceCache.AsyncTypefaceResult) this_$iv.permanentCache.get(key$iv);
                    }
                    if (priorResult$iv != null) {
                        result = priorResult$iv.m5523unboximpl();
                    } else {
                        Unit unit = Unit.INSTANCE;
                        try {
                            Object it$iv2 = platformFontLoader2.loadBlocking(font);
                            AsyncTypefaceCache.put$default(this_$iv, font, platformFontLoader, it$iv2, false, 8, (Object) null);
                            result = it$iv2;
                        } catch (Exception e) {
                            throw new IllegalStateException("Unable to load font " + font, e);
                        }
                    }
                }
                if (result != null) {
                    return TuplesKt.to(asyncFontsToLoad, FontSynthesis_androidKt.m5582synthesizeTypefaceFxwP2eA(typefaceRequest.m5615getFontSynthesisGVVA2EU(), result, font, typefaceRequest.getFontWeight(), typefaceRequest.m5614getFontStyle_LCdwA()));
                }
                throw new IllegalStateException("Unable to load font " + font);
            }
            if (FontLoadingStrategy.m5550equalsimpl0(r0, FontLoadingStrategy.Companion.m5556getOptionalLocalPKNRLFQ())) {
                AsyncTypefaceCache this_$iv2 = asyncTypefaceCache;
                synchronized (this_$iv2.cacheLock) {
                    AsyncTypefaceCache.Key key$iv2 = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                    AsyncTypefaceCache.AsyncTypefaceResult priorResult$iv2 = (AsyncTypefaceCache.AsyncTypefaceResult) this_$iv2.resultCache.get(key$iv2);
                    if (priorResult$iv2 == null) {
                        priorResult$iv2 = (AsyncTypefaceCache.AsyncTypefaceResult) this_$iv2.permanentCache.get(key$iv2);
                    }
                    if (priorResult$iv2 != null) {
                        obj = priorResult$iv2.m5523unboximpl();
                    } else {
                        Unit unit2 = Unit.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            it$iv = Result.m6273constructorimpl(platformFontLoader2.loadBlocking(font));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            it$iv = Result.m6273constructorimpl(ResultKt.createFailure(th));
                        }
                        if (Result.m6279isFailureimpl(it$iv)) {
                            it$iv = null;
                        }
                        AsyncTypefaceCache.put$default(this_$iv2, font, platformFontLoader, it$iv, false, 8, (Object) null);
                        obj = it$iv;
                    }
                }
                Object result2 = obj;
                if (result2 != null) {
                    return TuplesKt.to(asyncFontsToLoad, FontSynthesis_androidKt.m5582synthesizeTypefaceFxwP2eA(typefaceRequest.m5615getFontSynthesisGVVA2EU(), result2, font, typefaceRequest.getFontWeight(), typefaceRequest.m5614getFontStyle_LCdwA()));
                }
                AsyncTypefaceCache asyncTypefaceCache2 = asyncTypefaceCache;
            } else if (FontLoadingStrategy.m5550equalsimpl0(r0, FontLoadingStrategy.Companion.m5554getAsyncPKNRLFQ())) {
                AsyncTypefaceCache.AsyncTypefaceResult cacheResult = asyncTypefaceCache.m5515get1ASDuI8(font, platformFontLoader2);
                if (cacheResult == null) {
                    if (asyncFontsToLoad == null) {
                        asyncFontsToLoad = CollectionsKt.mutableListOf(font);
                    } else {
                        asyncFontsToLoad.add(font);
                    }
                } else if (!AsyncTypefaceCache.AsyncTypefaceResult.m5521isPermanentFailureimpl(cacheResult.m5523unboximpl()) && cacheResult.m5523unboximpl() != null) {
                    return TuplesKt.to(asyncFontsToLoad, FontSynthesis_androidKt.m5582synthesizeTypefaceFxwP2eA(typefaceRequest.m5615getFontSynthesisGVVA2EU(), cacheResult.m5523unboximpl(), font, typefaceRequest.getFontWeight(), typefaceRequest.m5614getFontStyle_LCdwA()));
                }
            } else {
                AsyncTypefaceCache asyncTypefaceCache3 = asyncTypefaceCache;
                throw new IllegalStateException("Unknown font type " + font);
            }
        }
        List<? extends Font> list = $this$firstImmediatelyAvailable;
        AsyncTypefaceCache asyncTypefaceCache4 = asyncTypefaceCache;
        return TuplesKt.to(asyncFontsToLoad, createDefaultTypeface.invoke(typefaceRequest));
    }
}
