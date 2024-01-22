package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutItemContentFactory.kt */
final class LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ LazyLayoutItemContentFactory this$0;
    final /* synthetic */ LazyLayoutItemContentFactory.CachedItemContent this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, LazyLayoutItemContentFactory.CachedItemContent cachedItemContent) {
        super(2);
        this.this$0 = lazyLayoutItemContentFactory;
        this.this$1 = cachedItemContent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        final int index;
        ComposerKt.sourceInformation($composer, "C102@3898L219:LazyLayoutItemContentFactory.kt#wow0x6");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1403994769, $changed, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.<anonymous> (LazyLayoutItemContentFactory.kt:89)");
            }
            final LazyLayoutItemProvider itemProvider = this.this$0.getItemProvider().invoke();
            Integer num = itemProvider.getKeyToIndexMap().get(this.this$1.getKey());
            if (num != null) {
                Number number = num;
                this.this$1.setLastKnownIndex(number.intValue());
                index = number.intValue();
            } else {
                index = this.this$1.getLastKnownIndex();
            }
            $composer.startReplaceableGroup(-715770513);
            ComposerKt.sourceInformation($composer, "97@3754L99");
            if (index < itemProvider.getItemCount()) {
                Object key = itemProvider.getKey(index);
                if (Intrinsics.areEqual(key, this.this$1.getKey())) {
                    this.this$0.saveableStateHolder.SaveableStateProvider(key, ComposableLambdaKt.composableLambda($composer, -1238863364, true, new Function2<Composer, Integer, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                            invoke((Composer) p1, ((Number) p2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer, int $changed) {
                            ComposerKt.sourceInformation($composer, "C98@3820L11:LazyLayoutItemContentFactory.kt#wow0x6");
                            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1238863364, $changed, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.<anonymous>.<anonymous> (LazyLayoutItemContentFactory.kt:97)");
                                }
                                itemProvider.Item(index, $composer, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer.skipToGroupEnd();
                        }
                    }), $composer, 568);
                }
            }
            $composer.endReplaceableGroup();
            Object key2 = this.this$1.getKey();
            final LazyLayoutItemContentFactory.CachedItemContent cachedItemContent = this.this$1;
            EffectsKt.DisposableEffect(key2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new Function1<DisposableEffectScope, DisposableEffectResult>() {
                public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                    Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
                    DisposableEffectScope disposableEffectScope = $this$DisposableEffect;
                    return new LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1$2$invoke$$inlined$onDispose$1(cachedItemContent);
                }
            }, $composer, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
