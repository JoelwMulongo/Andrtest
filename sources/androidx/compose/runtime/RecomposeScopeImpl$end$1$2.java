package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "composition", "Landroidx/compose/runtime/Composition;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: RecomposeScopeImpl.kt */
final class RecomposeScopeImpl$end$1$2 extends Lambda implements Function1<Composition, Unit> {
    final /* synthetic */ IdentityArrayIntMap $instances;
    final /* synthetic */ int $token;
    final /* synthetic */ RecomposeScopeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecomposeScopeImpl$end$1$2(RecomposeScopeImpl recomposeScopeImpl, int i, IdentityArrayIntMap identityArrayIntMap) {
        super(1);
        this.this$0 = recomposeScopeImpl;
        this.$token = i;
        this.$instances = identityArrayIntMap;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Composition) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Composition composition) {
        int i;
        Composition composition2 = composition;
        Intrinsics.checkNotNullParameter(composition2, "composition");
        if (this.this$0.currentToken == this.$token && Intrinsics.areEqual((Object) this.$instances, (Object) this.this$0.trackedInstances) && (composition2 instanceof CompositionImpl)) {
            IdentityArrayIntMap this_$iv = this.$instances;
            int i2 = this.$token;
            RecomposeScopeImpl recomposeScopeImpl = this.this$0;
            int destinationIndex$iv = 0;
            int i$iv = 0;
            int size = this_$iv.getSize();
            while (i$iv < size) {
                Object key$iv = this_$iv.getKeys()[i$iv];
                Intrinsics.checkNotNull(key$iv, "null cannot be cast to non-null type kotlin.Any");
                int value$iv = this_$iv.getValues()[i$iv];
                Object instance = key$iv;
                boolean remove = value$iv != i2;
                if (remove) {
                    ((CompositionImpl) composition2).removeObservation$runtime_release(instance, recomposeScopeImpl);
                    DerivedState it = instance instanceof DerivedState ? (DerivedState) instance : null;
                    if (it != null) {
                        i = i2;
                        ((CompositionImpl) composition2).removeDerivedStateObservation$runtime_release(it);
                        IdentityArrayMap dependencies = recomposeScopeImpl.trackedDependencies;
                        if (dependencies != null) {
                            dependencies.remove(it);
                            if (dependencies.getSize$runtime_release() == 0) {
                                recomposeScopeImpl.trackedDependencies = null;
                            }
                        }
                    } else {
                        i = i2;
                    }
                } else {
                    i = i2;
                }
                if (!remove) {
                    if (destinationIndex$iv != i$iv) {
                        this_$iv.getKeys()[destinationIndex$iv] = key$iv;
                        this_$iv.getValues()[destinationIndex$iv] = value$iv;
                    }
                    destinationIndex$iv++;
                }
                i$iv++;
                composition2 = composition;
                i2 = i;
            }
            int size2 = this_$iv.getSize();
            for (int i$iv2 = destinationIndex$iv; i$iv2 < size2; i$iv2++) {
                this_$iv.getKeys()[i$iv2] = null;
            }
            this_$iv.setSize(destinationIndex$iv);
            if (this.$instances.getSize() == 0) {
                this.this$0.trackedInstances = null;
            }
        }
    }
}
