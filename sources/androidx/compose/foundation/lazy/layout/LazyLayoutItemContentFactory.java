package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0015B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J&\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u000e0\u0005¢\u0006\u0002\b\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0001¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u00060\fR\u00020\u00000\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "", "saveableStateHolder", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "itemProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "(Landroidx/compose/runtime/saveable/SaveableStateHolder;Lkotlin/jvm/functions/Function0;)V", "getItemProvider", "()Lkotlin/jvm/functions/Function0;", "lambdasCache", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory$CachedItemContent;", "getContent", "", "Landroidx/compose/runtime/Composable;", "index", "", "key", "(ILjava/lang/Object;)Lkotlin/jvm/functions/Function2;", "getContentType", "CachedItemContent", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutItemContentFactory.kt */
public final class LazyLayoutItemContentFactory {
    private final Function0<LazyLayoutItemProvider> itemProvider;
    private final Map<Object, CachedItemContent> lambdasCache = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final SaveableStateHolder saveableStateHolder;

    public LazyLayoutItemContentFactory(SaveableStateHolder saveableStateHolder2, Function0<? extends LazyLayoutItemProvider> itemProvider2) {
        Intrinsics.checkNotNullParameter(saveableStateHolder2, "saveableStateHolder");
        Intrinsics.checkNotNullParameter(itemProvider2, "itemProvider");
        this.saveableStateHolder = saveableStateHolder2;
        this.itemProvider = itemProvider2;
    }

    public final Function0<LazyLayoutItemProvider> getItemProvider() {
        return this.itemProvider;
    }

    public final Object getContentType(Object key) {
        CachedItemContent cachedContent = this.lambdasCache.get(key);
        if (cachedContent != null) {
            return cachedContent.getType();
        }
        LazyLayoutItemProvider itemProvider2 = this.itemProvider.invoke();
        Integer index = itemProvider2.getKeyToIndexMap().get(key);
        if (index != null) {
            return itemProvider2.getContentType(index.intValue());
        }
        return null;
    }

    public final Function2<Composer, Integer, Unit> getContent(int index, Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        CachedItemContent cached = this.lambdasCache.get(key);
        Object type = this.itemProvider.invoke().getContentType(index);
        if (cached != null && cached.getLastKnownIndex() == index && Intrinsics.areEqual(cached.getType(), type)) {
            return cached.getContent();
        }
        CachedItemContent newContent = new CachedItemContent(this, index, key, type);
        this.lambdasCache.put(key, newContent);
        return newContent.getContent();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0002¢\u0006\u0002\u0010\u000eR\u001d\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\b\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u001c\u0010\f\u001a\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R+\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00038F@BX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory$CachedItemContent;", "", "initialIndex", "", "key", "type", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;ILjava/lang/Object;Ljava/lang/Object;)V", "_content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "getKey", "()Ljava/lang/Object;", "<set-?>", "lastKnownIndex", "getLastKnownIndex", "()I", "setLastKnownIndex", "(I)V", "lastKnownIndex$delegate", "Landroidx/compose/runtime/MutableState;", "getType", "createContentLambda", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyLayoutItemContentFactory.kt */
    private final class CachedItemContent {
        /* access modifiers changed from: private */
        public Function2<? super Composer, ? super Integer, Unit> _content;
        private final Object key;
        private final MutableState lastKnownIndex$delegate;
        final /* synthetic */ LazyLayoutItemContentFactory this$0;
        private final Object type;

        public CachedItemContent(LazyLayoutItemContentFactory this$02, int initialIndex, Object key2, Object type2) {
            Intrinsics.checkNotNullParameter(key2, "key");
            this.this$0 = this$02;
            this.key = key2;
            this.type = type2;
            this.lastKnownIndex$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(initialIndex), (SnapshotMutationPolicy) null, 2, (Object) null);
        }

        public final Object getKey() {
            return this.key;
        }

        public final Object getType() {
            return this.type;
        }

        /* access modifiers changed from: private */
        public final void setLastKnownIndex(int i) {
            this.lastKnownIndex$delegate.setValue(Integer.valueOf(i));
        }

        public final int getLastKnownIndex() {
            return ((Number) this.lastKnownIndex$delegate.getValue()).intValue();
        }

        public final Function2<Composer, Integer, Unit> getContent() {
            Function2<? super Composer, ? super Integer, Unit> function2 = this._content;
            if (function2 != null) {
                return function2;
            }
            Function2 it = createContentLambda();
            this._content = it;
            return it;
        }

        private final Function2<Composer, Integer, Unit> createContentLambda() {
            return ComposableLambdaKt.composableLambdaInstance(1403994769, true, new LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1(this.this$0, this));
        }
    }
}
