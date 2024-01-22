package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.TypefaceResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJB\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n0\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00190\u0016H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;", "Landroidx/compose/ui/text/font/FontFamilyTypefaceAdapter;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "injectedContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/coroutines/CoroutineContext;)V", "asyncLoadScope", "Lkotlinx/coroutines/CoroutineScope;", "preload", "", "family", "Landroidx/compose/ui/text/font/FontFamily;", "resourceLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/PlatformFontLoader;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "Landroidx/compose/ui/text/font/TypefaceResult;", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "platformFontLoader", "onAsyncCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "createDefaultTypeface", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
public final class FontListFontFamilyTypefaceAdapter implements FontFamilyTypefaceAdapter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final CoroutineExceptionHandler DropExceptionHandler = new FontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
    /* access modifiers changed from: private */
    public static final FontMatcher fontMatcher = new FontMatcher();
    private CoroutineScope asyncLoadScope;
    /* access modifiers changed from: private */
    public final AsyncTypefaceCache asyncTypefaceCache;

    public FontListFontFamilyTypefaceAdapter() {
        this((AsyncTypefaceCache) null, (CoroutineContext) null, 3, (DefaultConstructorMarker) null);
    }

    public FontListFontFamilyTypefaceAdapter(AsyncTypefaceCache asyncTypefaceCache2, CoroutineContext injectedContext) {
        Intrinsics.checkNotNullParameter(asyncTypefaceCache2, "asyncTypefaceCache");
        Intrinsics.checkNotNullParameter(injectedContext, "injectedContext");
        this.asyncTypefaceCache = asyncTypefaceCache2;
        this.asyncLoadScope = CoroutineScopeKt.CoroutineScope(DropExceptionHandler.plus(injectedContext).plus(SupervisorKt.SupervisorJob((Job) injectedContext.get(Job.Key))));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FontListFontFamilyTypefaceAdapter(AsyncTypefaceCache asyncTypefaceCache2, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new AsyncTypefaceCache() : asyncTypefaceCache2, (i & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext);
    }

    public final Object preload(FontFamily family, PlatformFontLoader resourceLoader, Continuation<? super Unit> $completion) {
        List $this$fastDistinctBy$iv;
        FontFamily fontFamily = family;
        PlatformFontLoader platformFontLoader = resourceLoader;
        if (!(fontFamily instanceof FontListFontFamily)) {
            return Unit.INSTANCE;
        }
        List allFonts = ((FontListFontFamily) fontFamily).getFonts();
        List $this$fastFilter$iv = ((FontListFontFamily) fontFamily).getFonts();
        int $i$f$fastFilter = false;
        ArrayList target$iv = new ArrayList($this$fastFilter$iv.size());
        List $this$fastForEach$iv$iv = $this$fastFilter$iv;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size) {
            Object it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            List $this$fastFilter$iv2 = $this$fastFilter$iv;
            int $i$f$fastFilter2 = $i$f$fastFilter;
            if (FontLoadingStrategy.m5550equalsimpl0(((Font) it$iv).m5534getLoadingStrategyPKNRLFQ(), FontLoadingStrategy.Companion.m5554getAsyncPKNRLFQ())) {
                target$iv.add(it$iv);
            }
            index$iv$iv++;
            $this$fastFilter$iv = $this$fastFilter$iv2;
            $i$f$fastFilter = $i$f$fastFilter2;
        }
        int i = $i$f$fastFilter;
        List $this$fastMap$iv = target$iv;
        int $i$f$fastMap = false;
        ArrayList target$iv2 = new ArrayList($this$fastMap$iv.size());
        List $this$fastForEach$iv$iv2 = $this$fastMap$iv;
        int index$iv$iv2 = 0;
        int size2 = $this$fastForEach$iv$iv2.size();
        while (index$iv$iv2 < size2) {
            Font it = (Font) $this$fastForEach$iv$iv2.get(index$iv$iv2);
            target$iv2.add(TuplesKt.to(it.getWeight(), FontStyle.m5560boximpl(it.m5535getStyle_LCdwA())));
            index$iv$iv2++;
            $this$fastMap$iv = $this$fastMap$iv;
            $i$f$fastMap = $i$f$fastMap;
        }
        int i2 = $i$f$fastMap;
        List $this$fastDistinctBy$iv2 = target$iv2;
        HashSet set$iv = new HashSet($this$fastDistinctBy$iv2.size());
        List target$iv3 = new ArrayList($this$fastDistinctBy$iv2.size());
        List $this$fastForEach$iv$iv3 = $this$fastDistinctBy$iv2;
        int index$iv$iv3 = 0;
        int size3 = $this$fastForEach$iv$iv3.size();
        while (index$iv$iv3 < size3) {
            Object e$iv = $this$fastForEach$iv$iv3.get(index$iv$iv3);
            if (set$iv.add((Pair) e$iv)) {
                $this$fastDistinctBy$iv = $this$fastDistinctBy$iv2;
                target$iv3.add(e$iv);
            } else {
                $this$fastDistinctBy$iv = $this$fastDistinctBy$iv2;
            }
            index$iv$iv3++;
            $this$fastDistinctBy$iv2 = $this$fastDistinctBy$iv;
        }
        List asyncLoads = new ArrayList();
        List $this$fastForEach$iv = target$iv3;
        int size4 = $this$fastForEach$iv.size();
        int index$iv = 0;
        while (index$iv < size4) {
            Pair pair = (Pair) $this$fastForEach$iv.get(index$iv);
            FontWeight fontWeight = (FontWeight) pair.component1();
            int fontStyle = ((FontStyle) pair.component2()).m5566unboximpl();
            int i3 = fontStyle;
            FontWeight fontWeight2 = fontWeight;
            int index$iv2 = index$iv;
            List asyncFontsToLoad = (List) FontListFontFamilyTypefaceAdapterKt.firstImmediatelyAvailable(fontMatcher.m5559matchFontRetOiIg((List<? extends Font>) allFonts, fontWeight, fontStyle), new TypefaceRequest(family, fontWeight, fontStyle, FontSynthesis.Companion.m5578getAllGVVA2EU(), resourceLoader.getCacheKey(), (DefaultConstructorMarker) null), this.asyncTypefaceCache, platformFontLoader, FontListFontFamilyTypefaceAdapter$preload$2$1.INSTANCE).component1();
            if (asyncFontsToLoad != null) {
                asyncLoads.add(CollectionsKt.first(asyncFontsToLoad));
            }
            index$iv = index$iv2 + 1;
        }
        int i4 = index$iv;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new FontListFontFamilyTypefaceAdapter$preload$3(asyncLoads, this, platformFontLoader, (Continuation<? super FontListFontFamilyTypefaceAdapter$preload$3>) null), $completion);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public TypefaceResult resolve(TypefaceRequest typefaceRequest, PlatformFontLoader platformFontLoader, Function1<? super TypefaceResult.Immutable, Unit> onAsyncCompletion, Function1<? super TypefaceRequest, ? extends Object> createDefaultTypeface) {
        TypefaceRequest typefaceRequest2 = typefaceRequest;
        PlatformFontLoader platformFontLoader2 = platformFontLoader;
        Function1<? super TypefaceRequest, ? extends Object> function1 = createDefaultTypeface;
        Intrinsics.checkNotNullParameter(typefaceRequest2, "typefaceRequest");
        Intrinsics.checkNotNullParameter(platformFontLoader2, "platformFontLoader");
        Intrinsics.checkNotNullParameter(onAsyncCompletion, "onAsyncCompletion");
        Intrinsics.checkNotNullParameter(function1, "createDefaultTypeface");
        if (!(typefaceRequest.getFontFamily() instanceof FontListFontFamily)) {
            return null;
        }
        Pair access$firstImmediatelyAvailable = FontListFontFamilyTypefaceAdapterKt.firstImmediatelyAvailable(fontMatcher.m5559matchFontRetOiIg((List<? extends Font>) ((FontListFontFamily) typefaceRequest.getFontFamily()).getFonts(), typefaceRequest.getFontWeight(), typefaceRequest.m5614getFontStyle_LCdwA()), typefaceRequest2, this.asyncTypefaceCache, platformFontLoader2, function1);
        List asyncFontsToLoad = (List) access$firstImmediatelyAvailable.component1();
        Object synthesizedTypeface = access$firstImmediatelyAvailable.component2();
        if (asyncFontsToLoad == null) {
            return new TypefaceResult.Immutable(synthesizedTypeface, false, 2, (DefaultConstructorMarker) null);
        }
        AsyncFontListLoader asyncLoader = new AsyncFontListLoader(asyncFontsToLoad, synthesizedTypeface, typefaceRequest, this.asyncTypefaceCache, onAsyncCompletion, platformFontLoader);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.asyncLoadScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new FontListFontFamilyTypefaceAdapter$resolve$1(asyncLoader, (Continuation<? super FontListFontFamilyTypefaceAdapter$resolve$1>) null), 1, (Object) null);
        return new TypefaceResult.Async(asyncLoader);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter$Companion;", "", "()V", "DropExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getDropExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FontListFontFamilyTypefaceAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FontMatcher getFontMatcher() {
            return FontListFontFamilyTypefaceAdapter.fontMatcher;
        }

        public final CoroutineExceptionHandler getDropExceptionHandler() {
            return FontListFontFamilyTypefaceAdapter.DropExceptionHandler;
        }
    }
}
