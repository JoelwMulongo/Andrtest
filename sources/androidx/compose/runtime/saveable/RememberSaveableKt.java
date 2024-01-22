package androidx.compose.runtime.saveable;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0002\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0004\b\u0000\u0010\u00052\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u0002H\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u0003H\u0002\u001aa\u0010\b\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\n\"\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ag\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\n\"\u0004\u0018\u00010\u00062\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\u000fH\u0007¢\u0006\u0002\u0010\u0012\u001a\u0016\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"MaxSupportedRadix", "", "mutableStateSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/runtime/MutableState;", "T", "", "inner", "rememberSaveable", "inputs", "", "saver", "key", "", "init", "Lkotlin/Function0;", "([Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Ljava/lang/Object;", "stateSaver", "([Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/MutableState;", "requireCanBeSaved", "", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "value", "runtime-saveable_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: RememberSaveable.kt */
public final class RememberSaveableKt {
    private static final int MaxSupportedRadix = 36;

    /* renamed from: rememberSaveable  reason: collision with other method in class */
    public static final <T> T m2803rememberSaveable(Object[] inputs, Saver<T, ? extends Object> saver, String key, Function0<? extends T> init, Composer $composer, int $changed, int i) {
        String key2;
        String finalKey;
        Object value$iv$iv;
        Object it;
        Object[] objArr = inputs;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(objArr, "inputs");
        Intrinsics.checkNotNullParameter(init, "init");
        composer.startReplaceableGroup(441892779);
        ComposerKt.sourceInformation(composer, "C(rememberSaveable)P(1,3,2)80@3500L7,82@3597L244,95@4209L27,96@4262L27,98@4299L441:RememberSaveable.kt#r2ddri");
        Saver saver2 = (i & 2) != 0 ? SaverKt.autoSaver() : saver;
        if ((i & 4) != 0) {
            key2 = null;
        } else {
            key2 = key;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(441892779, $changed, -1, "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:65)");
        } else {
            int i2 = $changed;
        }
        composer.startReplaceableGroup(1059366469);
        ComposerKt.sourceInformation(composer, "*75@3334L23");
        CharSequence charSequence = key2;
        if (!(charSequence == null || charSequence.length() == 0)) {
            finalKey = key2;
        } else {
            finalKey = Integer.toString(ComposablesKt.getCurrentCompositeKeyHash(composer, 0), CharsKt.checkRadix(MaxSupportedRadix));
            Intrinsics.checkNotNullExpressionValue(finalKey, "toString(this, checkRadix(radix))");
        }
        $composer.endReplaceableGroup();
        Intrinsics.checkNotNull(saver2, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable, kotlin.Any>");
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(SaveableStateRegistryKt.getLocalSaveableStateRegistry());
        ComposerKt.sourceInformationMarkerEnd($composer);
        SaveableStateRegistry registry = (SaveableStateRegistry) consume;
        Object[] keys$iv = Arrays.copyOf(objArr, objArr.length);
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= composer.changed(key$iv);
        }
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            if (registry == null || (it = registry.consumeRestored(finalKey)) == null) {
                value$iv$iv = null;
            } else {
                value$iv$iv = saver2.restore(it);
            }
            if (value$iv$iv == null) {
                value$iv$iv = init.invoke();
            }
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        if (registry != null) {
            EffectsKt.DisposableEffect(registry, finalKey, new RememberSaveableKt$rememberSaveable$1(registry, finalKey, SnapshotStateKt.rememberUpdatedState(saver2, composer, 0), SnapshotStateKt.rememberUpdatedState(value$iv$iv, composer, 0)), composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return value$iv$iv;
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [androidx.compose.runtime.saveable.Saver, androidx.compose.runtime.saveable.Saver<T, ? extends java.lang.Object>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> androidx.compose.runtime.MutableState<T> rememberSaveable(java.lang.Object[] r8, androidx.compose.runtime.saveable.Saver<T, ? extends java.lang.Object> r9, java.lang.String r10, kotlin.jvm.functions.Function0<? extends androidx.compose.runtime.MutableState<T>> r11, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            java.lang.String r0 = "inputs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "stateSaver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "init"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -202053668(0xfffffffff3f4e7dc, float:-3.8806857E31)
            r12.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberSaveable)P(1,3,2)141@6040L106:RememberSaveable.kt#r2ddri"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r14 = r14 & 4
            if (r14 == 0) goto L_0x0022
            r10 = 0
        L_0x0022:
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x002e
            r14 = -1
            java.lang.String r1 = "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:136)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r14, r1)
        L_0x002e:
            int r14 = r8.length
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r8, r14)
            androidx.compose.runtime.saveable.Saver r2 = mutableStateSaver(r9)
            r14 = r13 & 896(0x380, float:1.256E-42)
            r14 = r14 | 8
            r0 = r13 & 7168(0x1c00, float:1.0045E-41)
            r6 = r14 | r0
            r7 = 0
            r3 = r10
            r4 = r11
            r5 = r12
            java.lang.Object r14 = rememberSaveable((java.lang.Object[]) r1, r2, (java.lang.String) r3, r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            androidx.compose.runtime.MutableState r14 = (androidx.compose.runtime.MutableState) r14
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0053
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0053:
            r12.endReplaceableGroup()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable(java.lang.Object[], androidx.compose.runtime.saveable.Saver, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):androidx.compose.runtime.MutableState");
    }

    private static final <T> Saver<MutableState<T>, MutableState<Object>> mutableStateSaver(Saver<T, ? extends Object> inner) {
        Intrinsics.checkNotNull(inner, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver, kotlin.Any>");
        Saver $this$mutableStateSaver_u24lambda_u242 = inner;
        return SaverKt.Saver(new RememberSaveableKt$mutableStateSaver$1$1($this$mutableStateSaver_u24lambda_u242), new RememberSaveableKt$mutableStateSaver$1$2($this$mutableStateSaver_u24lambda_u242));
    }

    /* access modifiers changed from: private */
    public static final void requireCanBeSaved(SaveableStateRegistry $this$requireCanBeSaved, Object value) {
        String str;
        if (value != null && !$this$requireCanBeSaved.canBeSaved(value)) {
            if (!(value instanceof SnapshotMutableState)) {
                str = value + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().";
            } else if (((SnapshotMutableState) value).getPolicy() == SnapshotStateKt.neverEqualPolicy() || ((SnapshotMutableState) value).getPolicy() == SnapshotStateKt.structuralEqualityPolicy() || ((SnapshotMutableState) value).getPolicy() == SnapshotStateKt.referentialEqualityPolicy()) {
                str = "MutableState containing " + ((SnapshotMutableState) value).getValue() + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().";
            } else {
                str = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
            }
            throw new IllegalArgumentException(str);
        }
    }
}
