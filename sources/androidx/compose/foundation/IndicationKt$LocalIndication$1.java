package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/Indication;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Indication.kt */
final class IndicationKt$LocalIndication$1 extends Lambda implements Function0<Indication> {
    public static final IndicationKt$LocalIndication$1 INSTANCE = new IndicationKt$LocalIndication$1();

    IndicationKt$LocalIndication$1() {
        super(0);
    }

    public final Indication invoke() {
        return DefaultDebugIndication.INSTANCE;
    }
}
