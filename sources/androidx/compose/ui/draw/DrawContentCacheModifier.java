package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\u00020\u0001B&\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001a\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007HÆ\u0003J.\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0019\b\u0002\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\f\u0010\u001c\u001a\u00020\u0017*\u00020\u001dH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/draw/DrawContentCacheModifier;", "Landroidx/compose/ui/draw/DrawCacheModifier;", "cacheDrawScope", "Landroidx/compose/ui/draw/CacheDrawScope;", "onBuildDrawCache", "Lkotlin/Function1;", "Landroidx/compose/ui/draw/DrawResult;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/draw/CacheDrawScope;Lkotlin/jvm/functions/Function1;)V", "getCacheDrawScope", "()Landroidx/compose/ui/draw/CacheDrawScope;", "getOnBuildDrawCache", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "onBuildCache", "", "params", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "toString", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DrawModifier.kt */
final class DrawContentCacheModifier implements DrawCacheModifier {
    private final CacheDrawScope cacheDrawScope;
    private final Function1<CacheDrawScope, DrawResult> onBuildDrawCache;

    public static /* synthetic */ DrawContentCacheModifier copy$default(DrawContentCacheModifier drawContentCacheModifier, CacheDrawScope cacheDrawScope2, Function1<CacheDrawScope, DrawResult> function1, int i, Object obj) {
        if ((i & 1) != 0) {
            cacheDrawScope2 = drawContentCacheModifier.cacheDrawScope;
        }
        if ((i & 2) != 0) {
            function1 = drawContentCacheModifier.onBuildDrawCache;
        }
        return drawContentCacheModifier.copy(cacheDrawScope2, function1);
    }

    public final CacheDrawScope component1() {
        return this.cacheDrawScope;
    }

    public final Function1<CacheDrawScope, DrawResult> component2() {
        return this.onBuildDrawCache;
    }

    public final DrawContentCacheModifier copy(CacheDrawScope cacheDrawScope2, Function1<? super CacheDrawScope, DrawResult> function1) {
        Intrinsics.checkNotNullParameter(cacheDrawScope2, "cacheDrawScope");
        Intrinsics.checkNotNullParameter(function1, "onBuildDrawCache");
        return new DrawContentCacheModifier(cacheDrawScope2, function1);
    }

    public String toString() {
        return "DrawContentCacheModifier(cacheDrawScope=" + this.cacheDrawScope + ", onBuildDrawCache=" + this.onBuildDrawCache + ')';
    }

    public DrawContentCacheModifier(CacheDrawScope cacheDrawScope2, Function1<? super CacheDrawScope, DrawResult> onBuildDrawCache2) {
        Intrinsics.checkNotNullParameter(cacheDrawScope2, "cacheDrawScope");
        Intrinsics.checkNotNullParameter(onBuildDrawCache2, "onBuildDrawCache");
        this.cacheDrawScope = cacheDrawScope2;
        this.onBuildDrawCache = onBuildDrawCache2;
    }

    public final CacheDrawScope getCacheDrawScope() {
        return this.cacheDrawScope;
    }

    public final Function1<CacheDrawScope, DrawResult> getOnBuildDrawCache() {
        return this.onBuildDrawCache;
    }

    public void onBuildCache(BuildDrawCacheParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        CacheDrawScope $this$onBuildCache_u24lambda_u241 = this.cacheDrawScope;
        $this$onBuildCache_u24lambda_u241.setCacheParams$ui_release(params);
        $this$onBuildCache_u24lambda_u241.setDrawResult$ui_release((DrawResult) null);
        this.onBuildDrawCache.invoke($this$onBuildCache_u24lambda_u241);
        if ($this$onBuildCache_u24lambda_u241.getDrawResult$ui_release() == null) {
            throw new IllegalStateException("DrawResult not defined, did you forget to call onDraw?".toString());
        }
    }

    public void draw(ContentDrawScope $this$draw) {
        Intrinsics.checkNotNullParameter($this$draw, "<this>");
        DrawResult drawResult$ui_release = this.cacheDrawScope.getDrawResult$ui_release();
        Intrinsics.checkNotNull(drawResult$ui_release);
        drawResult$ui_release.getBlock$ui_release().invoke($this$draw);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof DrawContentCacheModifier) && Intrinsics.areEqual((Object) this.cacheDrawScope, (Object) ((DrawContentCacheModifier) other).cacheDrawScope) && Intrinsics.areEqual((Object) this.onBuildDrawCache, (Object) ((DrawContentCacheModifier) other).onBuildDrawCache)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.cacheDrawScope.hashCode() * 31) + this.onBuildDrawCache.hashCode();
    }
}
