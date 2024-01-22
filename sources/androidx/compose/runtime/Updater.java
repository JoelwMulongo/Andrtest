package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J&\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\u0002\b\u0016¢\u0006\u0004\b\u0017\u0010\u0018J&\u0010\u0019\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\u0002\b\u0016¢\u0006\u0004\b\u001a\u0010\u0018JI\u0010\u001b\u001a\u00020\u0013\"\u0004\b\u0001\u0010\u001c2\u0006\u0010\u001d\u001a\u0002H\u001c2,\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u001e¢\u0006\u0002\b\u0016¢\u0006\u0004\b!\u0010\"JK\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u000f2.\b\b\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u001e¢\u0006\u0002\b\u0016H\bø\u0001\u0001¢\u0006\u0004\b!\u0010#J\u0010\u0010$\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'JI\u0010(\u001a\u00020\u0013\"\u0004\b\u0001\u0010\u001c2\u0006\u0010\u001d\u001a\u0002H\u001c2,\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u001e¢\u0006\u0002\b\u0016¢\u0006\u0004\b)\u0010\"JK\u0010(\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u000f2.\b\b\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u001e¢\u0006\u0002\b\u0016H\bø\u0001\u0001¢\u0006\u0004\b)\u0010#R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\b\u0001\u0003\u0001\u00020\u0004ø\u0001\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006*"}, d2 = {"Landroidx/compose/runtime/Updater;", "T", "", "composer", "Landroidx/compose/runtime/Composer;", "constructor-impl", "(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;", "getComposer$annotations", "()V", "equals", "", "other", "equals-impl", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/compose/runtime/Composer;)I", "init", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "init-impl", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function1;)V", "reconcile", "reconcile-impl", "set", "V", "value", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "set-impl", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Landroidx/compose/runtime/Composer;ILkotlin/jvm/functions/Function2;)V", "toString", "", "toString-impl", "(Landroidx/compose/runtime/Composer;)Ljava/lang/String;", "update", "update-impl", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: Composer.kt */
public final class Updater<T> {
    private final Composer composer;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Updater m2786boximpl(Composer composer2) {
        return new Updater(composer2);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static <T> Composer m2787constructorimpl(Composer composer2) {
        Intrinsics.checkNotNullParameter(composer2, "composer");
        return composer2;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2788equalsimpl(Composer composer2, Object obj) {
        return (obj instanceof Updater) && Intrinsics.areEqual((Object) composer2, (Object) ((Updater) obj).m2798unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2789equalsimpl0(Composer composer2, Composer composer3) {
        return Intrinsics.areEqual((Object) composer2, (Object) composer3);
    }

    public static /* synthetic */ void getComposer$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2790hashCodeimpl(Composer composer2) {
        return composer2.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2795toStringimpl(Composer composer2) {
        return "Updater(composer=" + composer2 + ')';
    }

    public boolean equals(Object obj) {
        return m2788equalsimpl(this.composer, obj);
    }

    public int hashCode() {
        return m2790hashCodeimpl(this.composer);
    }

    public String toString() {
        return m2795toStringimpl(this.composer);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Composer m2798unboximpl() {
        return this.composer;
    }

    private /* synthetic */ Updater(Composer composer2) {
        this.composer = composer2;
    }

    /* renamed from: set-impl  reason: not valid java name */
    public static final void m2793setimpl(Composer arg0, int value, Function2<? super T, ? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Composer $this$set_impl_u24lambda_u240 = arg0;
        if ($this$set_impl_u24lambda_u240.getInserting() || !Intrinsics.areEqual($this$set_impl_u24lambda_u240.rememberedValue(), (Object) Integer.valueOf(value))) {
            $this$set_impl_u24lambda_u240.updateRememberedValue(Integer.valueOf(value));
            arg0.apply(Integer.valueOf(value), block);
        }
    }

    /* renamed from: set-impl  reason: not valid java name */
    public static final <V> void m2794setimpl(Composer arg0, V value, Function2<? super T, ? super V, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Composer $this$set_impl_u24lambda_u241 = arg0;
        if ($this$set_impl_u24lambda_u241.getInserting() || !Intrinsics.areEqual($this$set_impl_u24lambda_u241.rememberedValue(), (Object) value)) {
            $this$set_impl_u24lambda_u241.updateRememberedValue(value);
            arg0.apply(value, block);
        }
    }

    /* renamed from: update-impl  reason: not valid java name */
    public static final void m2796updateimpl(Composer arg0, int value, Function2<? super T, ? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Composer $this$update_impl_u24lambda_u242 = arg0;
        boolean inserting = $this$update_impl_u24lambda_u242.getInserting();
        if (inserting || !Intrinsics.areEqual($this$update_impl_u24lambda_u242.rememberedValue(), (Object) Integer.valueOf(value))) {
            $this$update_impl_u24lambda_u242.updateRememberedValue(Integer.valueOf(value));
            if (!inserting) {
                $this$update_impl_u24lambda_u242.apply(Integer.valueOf(value), block);
            }
        }
    }

    /* renamed from: update-impl  reason: not valid java name */
    public static final <V> void m2797updateimpl(Composer arg0, V value, Function2<? super T, ? super V, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Composer $this$update_impl_u24lambda_u243 = arg0;
        boolean inserting = $this$update_impl_u24lambda_u243.getInserting();
        if (inserting || !Intrinsics.areEqual($this$update_impl_u24lambda_u243.rememberedValue(), (Object) value)) {
            $this$update_impl_u24lambda_u243.updateRememberedValue(value);
            if (!inserting) {
                $this$update_impl_u24lambda_u243.apply(value, block);
            }
        }
    }

    /* renamed from: init-impl  reason: not valid java name */
    public static final void m2791initimpl(Composer arg0, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (arg0.getInserting()) {
            arg0.apply(Unit.INSTANCE, new Updater$init$1(block));
        }
    }

    /* renamed from: reconcile-impl  reason: not valid java name */
    public static final void m2792reconcileimpl(Composer arg0, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        arg0.apply(Unit.INSTANCE, new Updater$reconcile$1(block));
    }
}
