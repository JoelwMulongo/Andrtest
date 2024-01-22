package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.ScopeUpdateScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J%\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J/\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J9\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0002JC\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0002JM\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0002JW\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0002Ja\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0002Jk\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0002Ju\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\u0001\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u0001\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u0001\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J¥\u0001\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J¯\u0001\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010 \u001a\u0004\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J¹\u0001\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010 \u001a\u0004\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010\b2\b\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0002JÃ\u0001\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010 \u001a\u0004\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010\b2\b\u0010\"\u001a\u0004\u0018\u00010\b2\b\u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0002JÍ\u0001\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010 \u001a\u0004\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010\b2\b\u0010\"\u001a\u0004\u0018\u00010\b2\b\u0010#\u001a\u0004\u0018\u00010\b2\b\u0010$\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J×\u0001\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010 \u001a\u0004\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010\b2\b\u0010\"\u001a\u0004\u0018\u00010\b2\b\u0010#\u001a\u0004\u0018\u00010\b2\b\u0010$\u001a\u0004\u0018\u00010\b2\b\u0010%\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0011H\u0002J\b\u0010)\u001a\u00020'H\u0002J\u000e\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020\bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Landroidx/compose/runtime/internal/ComposableLambdaImpl;", "Landroidx/compose/runtime/internal/ComposableLambda;", "key", "", "tracked", "", "(IZ)V", "_block", "", "getKey", "()I", "scope", "Landroidx/compose/runtime/RecomposeScope;", "scopes", "", "invoke", "c", "Landroidx/compose/runtime/Composer;", "changed", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "changed1", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "trackRead", "", "composer", "trackWrite", "update", "block", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposableLambda.jvm.kt */
public final class ComposableLambdaImpl implements ComposableLambda {
    private Object _block;
    private final int key;
    private RecomposeScope scope;
    private List<RecomposeScope> scopes;
    private final boolean tracked;

    public ComposableLambdaImpl(int key2, boolean tracked2) {
        this.key = key2;
        this.tracked = tracked2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return invoke((Composer) p1, ((Number) p2).intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke(p1, (Composer) p2, ((Number) p3).intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
        return invoke(p1, p2, (Composer) p3, ((Number) p4).intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5) {
        return invoke(p1, p2, p3, (Composer) p4, ((Number) p5).intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        return invoke(p1, p2, p3, p4, (Composer) p5, ((Number) p6).intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        return invoke(p1, p2, p3, p4, p5, (Composer) p6, ((Number) p7).intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        return invoke(p1, p2, p3, p4, p5, p6, (Composer) p7, ((Number) p8).intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        return invoke(p1, p2, p3, p4, p5, p6, p7, (Composer) p8, ((Number) p9).intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10) {
        return invoke(p1, p2, p3, p4, p5, p6, p7, p8, (Composer) p9, ((Number) p10).intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11) {
        return invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, (Composer) p10, ((Number) p11).intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13) {
        return invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, (Composer) p11, ((Number) p12).intValue(), ((Number) p13).intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14) {
        return invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, (Composer) p12, ((Number) p13).intValue(), ((Number) p14).intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15) {
        return invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, (Composer) p13, ((Number) p14).intValue(), ((Number) p15).intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16) {
        return invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, (Composer) p14, ((Number) p15).intValue(), ((Number) p16).intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17) {
        return invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, (Composer) p15, ((Number) p16).intValue(), ((Number) p17).intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18) {
        return invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, (Composer) p16, ((Number) p17).intValue(), ((Number) p18).intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Object p19) {
        return invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, (Composer) p17, ((Number) p18).intValue(), ((Number) p19).intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Object p19, Object p20) {
        return invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, (Composer) p18, ((Number) p19).intValue(), ((Number) p20).intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Object p19, Object p20, Object p21) {
        return invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, (Composer) p19, ((Number) p20).intValue(), ((Number) p21).intValue());
    }

    public final int getKey() {
        return this.key;
    }

    private final void trackWrite() {
        if (this.tracked) {
            RecomposeScope scope2 = this.scope;
            if (scope2 != null) {
                scope2.invalidate();
                this.scope = null;
            }
            List scopes2 = this.scopes;
            if (scopes2 != null) {
                int size = scopes2.size();
                for (int index = 0; index < size; index++) {
                    scopes2.get(index).invalidate();
                }
                scopes2.clear();
            }
        }
    }

    private final void trackRead(Composer composer) {
        RecomposeScope scope2;
        if (this.tracked && (scope2 = composer.getRecomposeScope()) != null) {
            composer.recordUsed(scope2);
            if (ComposableLambdaKt.replacableWith(this.scope, scope2)) {
                this.scope = scope2;
                return;
            }
            List lastScopes = this.scopes;
            if (lastScopes == null) {
                List newScopes = new ArrayList();
                this.scopes = newScopes;
                newScopes.add(scope2);
                return;
            }
            int size = lastScopes.size();
            for (int index = 0; index < size; index++) {
                if (ComposableLambdaKt.replacableWith(lastScopes.get(index), scope2)) {
                    lastScopes.set(index, scope2);
                    return;
                }
            }
            lastScopes.add(scope2);
        }
    }

    public final void update(Object block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (!Intrinsics.areEqual(this._block, block)) {
            boolean oldBlockNull = this._block == null;
            this._block = block;
            if (!oldBlockNull) {
                trackWrite();
            }
        }
    }

    public Object invoke(Composer c, int changed) {
        Intrinsics.checkNotNullParameter(c, "c");
        Composer c2 = c.startRestartGroup(this.key);
        trackRead(c2);
        int differentBits = c2.changed((Object) this) ? ComposableLambdaKt.differentBits(0) : ComposableLambdaKt.sameBits(0);
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function2<@[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object result = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 2)).invoke(c2, Integer.valueOf(differentBits | changed));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.Function2<androidx.compose.runtime.Composer, kotlin.Int, kotlin.Unit>");
            endRestartGroup.updateScope((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(this, 2));
        }
        return result;
    }

    public Object invoke(Object p1, Composer c, int changed) {
        Intrinsics.checkNotNullParameter(c, "c");
        Composer c2 = c.startRestartGroup(this.key);
        trackRead(c2);
        int differentBits = c2.changed((Object) this) ? ComposableLambdaKt.differentBits(1) : ComposableLambdaKt.sameBits(1);
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object result = ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 3)).invoke(p1, c2, Integer.valueOf(differentBits | changed));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ComposableLambdaImpl$invoke$1(this, p1, changed));
        }
        return result;
    }

    public Object invoke(Object p1, Object p2, Composer c, int changed) {
        Intrinsics.checkNotNullParameter(c, "c");
        Composer c2 = c.startRestartGroup(this.key);
        trackRead(c2);
        int differentBits = c2.changed((Object) this) ? ComposableLambdaKt.differentBits(2) : ComposableLambdaKt.sameBits(2);
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function4<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object result = ((Function4) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 4)).invoke(p1, p2, c2, Integer.valueOf(differentBits | changed));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ComposableLambdaImpl$invoke$2(this, p1, p2, changed));
        }
        return result;
    }

    public Object invoke(Object p1, Object p2, Object p3, Composer c, int changed) {
        Composer composer = c;
        Intrinsics.checkNotNullParameter(composer, "c");
        Composer c2 = composer.startRestartGroup(this.key);
        trackRead(c2);
        int dirty = changed | (c2.changed((Object) this) ? ComposableLambdaKt.differentBits(3) : ComposableLambdaKt.sameBits(3));
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function5<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object result = ((Function5) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 5)).invoke(p1, p2, p3, c2, Integer.valueOf(dirty));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ComposableLambdaImpl$invoke$3(this, p1, p2, p3, changed));
        }
        return result;
    }

    public Object invoke(Object p1, Object p2, Object p3, Object p4, Composer c, int changed) {
        Composer composer = c;
        Intrinsics.checkNotNullParameter(composer, "c");
        Composer c2 = composer.startRestartGroup(this.key);
        trackRead(c2);
        int dirty = changed | (c2.changed((Object) this) ? ComposableLambdaKt.differentBits(4) : ComposableLambdaKt.sameBits(4));
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function6<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object result = ((Function6) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 6)).invoke(p1, p2, p3, p4, c2, Integer.valueOf(dirty));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            Composer composer2 = c2;
            endRestartGroup.updateScope(new ComposableLambdaImpl$invoke$4(this, p1, p2, p3, p4, changed));
        }
        return result;
    }

    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Composer c, int changed) {
        Composer composer = c;
        Intrinsics.checkNotNullParameter(composer, "c");
        Composer c2 = composer.startRestartGroup(this.key);
        trackRead(c2);
        int dirty = changed | (c2.changed((Object) this) ? ComposableLambdaKt.differentBits(5) : ComposableLambdaKt.sameBits(5));
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function7<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object result = ((Function7) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 7)).invoke(p1, p2, p3, p4, p5, c2, Integer.valueOf(dirty));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            Composer composer2 = c2;
            endRestartGroup.updateScope(new ComposableLambdaImpl$invoke$5(this, p1, p2, p3, p4, p5, changed));
        }
        return result;
    }

    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Composer c, int changed) {
        Composer composer = c;
        Intrinsics.checkNotNullParameter(composer, "c");
        Composer c2 = composer.startRestartGroup(this.key);
        trackRead(c2);
        int dirty = changed | (c2.changed((Object) this) ? ComposableLambdaKt.differentBits(6) : ComposableLambdaKt.sameBits(6));
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function8<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object result = ((Function8) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 8)).invoke(p1, p2, p3, p4, p5, p6, c2, Integer.valueOf(dirty));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            Composer composer2 = c2;
            endRestartGroup.updateScope(new ComposableLambdaImpl$invoke$6(this, p1, p2, p3, p4, p5, p6, changed));
        }
        return result;
    }

    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Composer c, int changed) {
        Composer composer = c;
        Intrinsics.checkNotNullParameter(composer, "c");
        Composer c2 = composer.startRestartGroup(this.key);
        trackRead(c2);
        int dirty = changed | (c2.changed((Object) this) ? ComposableLambdaKt.differentBits(7) : ComposableLambdaKt.sameBits(7));
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function9<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object result = ((Function9) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 9)).invoke(p1, p2, p3, p4, p5, p6, p7, c2, Integer.valueOf(dirty));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            Composer composer2 = c2;
            endRestartGroup.updateScope(new ComposableLambdaImpl$invoke$7(this, p1, p2, p3, p4, p5, p6, p7, changed));
        }
        return result;
    }

    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Composer c, int changed) {
        Composer composer = c;
        Intrinsics.checkNotNullParameter(composer, "c");
        Composer c2 = composer.startRestartGroup(this.key);
        trackRead(c2);
        int dirty = changed | (c2.changed((Object) this) ? ComposableLambdaKt.differentBits(8) : ComposableLambdaKt.sameBits(8));
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function10<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object result = ((Function10) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 10)).invoke(p1, p2, p3, p4, p5, p6, p7, p8, c2, Integer.valueOf(dirty));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            Composer composer2 = c2;
            endRestartGroup.updateScope(new ComposableLambdaImpl$invoke$8(this, p1, p2, p3, p4, p5, p6, p7, p8, changed));
        }
        return result;
    }

    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Composer c, int changed) {
        Composer composer = c;
        Intrinsics.checkNotNullParameter(composer, "c");
        Composer c2 = composer.startRestartGroup(this.key);
        trackRead(c2);
        int dirty = changed | (c2.changed((Object) this) ? ComposableLambdaKt.differentBits(9) : ComposableLambdaKt.sameBits(9));
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function11<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object result = ((Function11) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 11)).invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, c2, Integer.valueOf(dirty));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            Composer composer2 = c2;
            endRestartGroup.updateScope(new ComposableLambdaImpl$invoke$9(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, changed));
        }
        return result;
    }

    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Composer c, int changed, int changed1) {
        Composer composer = c;
        Intrinsics.checkNotNullParameter(composer, "c");
        Composer c2 = composer.startRestartGroup(this.key);
        trackRead(c2);
        int dirty = changed1 | (c2.changed((Object) this) ? ComposableLambdaKt.differentBits(10) : ComposableLambdaKt.sameBits(10));
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function13<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
        Object result = ((Function13) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 13)).invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, c2, Integer.valueOf(changed), Integer.valueOf(dirty));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            Composer composer2 = c2;
            endRestartGroup.updateScope(new ComposableLambdaImpl$invoke$10(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, changed));
        }
        return result;
    }

    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Composer c, int changed, int changed1) {
        Composer composer = c;
        Intrinsics.checkNotNullParameter(composer, "c");
        Composer c2 = composer.startRestartGroup(this.key);
        trackRead(c2);
        int dirty = changed1 | (c2.changed((Object) this) ? ComposableLambdaKt.differentBits(11) : ComposableLambdaKt.sameBits(11));
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function14<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'p11')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
        Object result = ((Function14) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 14)).invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, c2, Integer.valueOf(changed), Integer.valueOf(dirty));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            Composer composer2 = c2;
            endRestartGroup.updateScope(new ComposableLambdaImpl$invoke$11(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, changed, changed1));
        }
        return result;
    }

    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Composer c, int changed, int changed1) {
        Composer composer = c;
        Intrinsics.checkNotNullParameter(composer, "c");
        Composer c2 = composer.startRestartGroup(this.key);
        trackRead(c2);
        int dirty = changed1 | (c2.changed((Object) this) ? ComposableLambdaKt.differentBits(12) : ComposableLambdaKt.sameBits(12));
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function15<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'p11')] kotlin.Any?, @[ParameterName(name = 'p12')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
        Object result = ((Function15) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 15)).invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, c2, Integer.valueOf(changed), Integer.valueOf(dirty));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            Composer composer2 = c2;
            endRestartGroup.updateScope(new ComposableLambdaImpl$invoke$12(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, changed, changed1));
        }
        return result;
    }

    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Composer c, int changed, int changed1) {
        Composer composer = c;
        Intrinsics.checkNotNullParameter(composer, "c");
        Composer c2 = composer.startRestartGroup(this.key);
        trackRead(c2);
        int dirty = changed1 | (c2.changed((Object) this) ? ComposableLambdaKt.differentBits(13) : ComposableLambdaKt.sameBits(13));
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function16<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'p11')] kotlin.Any?, @[ParameterName(name = 'p12')] kotlin.Any?, @[ParameterName(name = 'p13')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
        Object result = ((Function16) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 16)).invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, c2, Integer.valueOf(changed), Integer.valueOf(dirty));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            Composer composer2 = c2;
            endRestartGroup.updateScope(new ComposableLambdaImpl$invoke$13(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, changed, changed1));
        }
        return result;
    }

    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Composer c, int changed, int changed1) {
        Composer composer = c;
        Intrinsics.checkNotNullParameter(composer, "c");
        Composer c2 = composer.startRestartGroup(this.key);
        trackRead(c2);
        int dirty = changed1 | (c2.changed((Object) this) ? ComposableLambdaKt.differentBits(14) : ComposableLambdaKt.sameBits(14));
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function17<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'p11')] kotlin.Any?, @[ParameterName(name = 'p12')] kotlin.Any?, @[ParameterName(name = 'p13')] kotlin.Any?, @[ParameterName(name = 'p14')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
        Object result = ((Function17) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 17)).invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, c2, Integer.valueOf(changed), Integer.valueOf(dirty));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            Composer composer2 = c2;
            endRestartGroup.updateScope(new ComposableLambdaImpl$invoke$14(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, changed, changed1));
        }
        return result;
    }

    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Composer c, int changed, int changed1) {
        Composer composer = c;
        Intrinsics.checkNotNullParameter(composer, "c");
        Composer c2 = composer.startRestartGroup(this.key);
        trackRead(c2);
        int dirty = changed1 | (c2.changed((Object) this) ? ComposableLambdaKt.differentBits(15) : ComposableLambdaKt.sameBits(15));
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function18<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'p11')] kotlin.Any?, @[ParameterName(name = 'p12')] kotlin.Any?, @[ParameterName(name = 'p13')] kotlin.Any?, @[ParameterName(name = 'p14')] kotlin.Any?, @[ParameterName(name = 'p15')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
        Object result = ((Function18) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 18)).invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, c2, Integer.valueOf(changed), Integer.valueOf(dirty));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            Composer composer2 = c2;
            endRestartGroup.updateScope(new ComposableLambdaImpl$invoke$15(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, changed, changed1));
        }
        return result;
    }

    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Composer c, int changed, int changed1) {
        Composer composer = c;
        Intrinsics.checkNotNullParameter(composer, "c");
        Composer c2 = composer.startRestartGroup(this.key);
        trackRead(c2);
        int dirty = changed1 | (c2.changed((Object) this) ? ComposableLambdaKt.differentBits(16) : ComposableLambdaKt.sameBits(16));
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function19<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'p11')] kotlin.Any?, @[ParameterName(name = 'p12')] kotlin.Any?, @[ParameterName(name = 'p13')] kotlin.Any?, @[ParameterName(name = 'p14')] kotlin.Any?, @[ParameterName(name = 'p15')] kotlin.Any?, @[ParameterName(name = 'p16')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
        Object result = ((Function19) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 19)).invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, c2, Integer.valueOf(changed), Integer.valueOf(dirty));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            Composer composer2 = c2;
            endRestartGroup.updateScope(new ComposableLambdaImpl$invoke$16(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, changed, changed1));
        }
        return result;
    }

    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Composer c, int changed, int changed1) {
        Composer composer = c;
        Intrinsics.checkNotNullParameter(composer, "c");
        Composer c2 = composer.startRestartGroup(this.key);
        trackRead(c2);
        int dirty = changed1 | (c2.changed((Object) this) ? ComposableLambdaKt.differentBits(17) : ComposableLambdaKt.sameBits(17));
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function20<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'p11')] kotlin.Any?, @[ParameterName(name = 'p12')] kotlin.Any?, @[ParameterName(name = 'p13')] kotlin.Any?, @[ParameterName(name = 'p14')] kotlin.Any?, @[ParameterName(name = 'p15')] kotlin.Any?, @[ParameterName(name = 'p16')] kotlin.Any?, @[ParameterName(name = 'p17')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
        Object result = ((Function20) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 20)).invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, c2, Integer.valueOf(changed), Integer.valueOf(dirty));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            Composer composer2 = c2;
            endRestartGroup.updateScope(new ComposableLambdaImpl$invoke$17(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, changed, changed1));
        }
        return result;
    }

    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Composer c, int changed, int changed1) {
        Composer composer = c;
        Intrinsics.checkNotNullParameter(composer, "c");
        Composer c2 = composer.startRestartGroup(this.key);
        trackRead(c2);
        int dirty = changed1 | (c2.changed((Object) this) ? ComposableLambdaKt.differentBits(18) : ComposableLambdaKt.sameBits(18));
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function21<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'p11')] kotlin.Any?, @[ParameterName(name = 'p12')] kotlin.Any?, @[ParameterName(name = 'p13')] kotlin.Any?, @[ParameterName(name = 'p14')] kotlin.Any?, @[ParameterName(name = 'p15')] kotlin.Any?, @[ParameterName(name = 'p16')] kotlin.Any?, @[ParameterName(name = 'p17')] kotlin.Any?, @[ParameterName(name = 'p18')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
        Object result = ((Function21) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 21)).invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, c2, Integer.valueOf(changed), Integer.valueOf(dirty));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            Composer composer2 = c2;
            endRestartGroup.updateScope(new ComposableLambdaImpl$invoke$18(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, changed, changed1));
        }
        return result;
    }
}
