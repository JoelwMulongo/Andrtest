package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.ScopeUpdateScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.FunctionN;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J(\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u0013\"\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\tR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/internal/ComposableLambdaNImpl;", "Landroidx/compose/runtime/internal/ComposableLambdaN;", "key", "", "tracked", "", "arity", "(IZI)V", "_block", "", "getArity", "()I", "getKey", "scope", "Landroidx/compose/runtime/RecomposeScope;", "scopes", "", "invoke", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "realParamCount", "params", "trackRead", "", "composer", "Landroidx/compose/runtime/Composer;", "trackWrite", "update", "block", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposableLambdaN.jvm.kt */
public final class ComposableLambdaNImpl implements ComposableLambdaN {
    private Object _block;
    private final int arity;
    private final int key;
    private RecomposeScope scope;
    private List<RecomposeScope> scopes;
    private final boolean tracked;

    public ComposableLambdaNImpl(int key2, boolean tracked2, int arity2) {
        this.key = key2;
        this.tracked = tracked2;
        this.arity = arity2;
    }

    public final int getKey() {
        return this.key;
    }

    public int getArity() {
        return this.arity;
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
        if (!Intrinsics.areEqual(block, this._block)) {
            boolean oldBlockNull = this._block == null;
            this._block = (FunctionN) block;
            if (!oldBlockNull) {
                trackWrite();
            }
        }
    }

    private final int realParamCount(int params) {
        int realParams = (params - 1) - 1;
        for (int changedParams = 1; changedParams * 10 < realParams; changedParams++) {
            realParams--;
        }
        return realParams;
    }

    public Object invoke(Object... args) {
        int i;
        Intrinsics.checkNotNullParameter(args, "args");
        int realParams = realParamCount(args.length);
        Composer c = args[realParams];
        Intrinsics.checkNotNull(c, "null cannot be cast to non-null type androidx.compose.runtime.Composer");
        Object[] allArgsButLast = ArraysKt.slice((T[]) args, RangesKt.until(0, args.length - 1)).toArray(new Object[0]);
        Integer num = args[args.length - 1];
        Intrinsics.checkNotNull(num, "null cannot be cast to non-null type kotlin.Int");
        int lastChanged = num.intValue();
        Composer c2 = c.startRestartGroup(this.key);
        trackRead(c2);
        if (c2.changed((Object) this)) {
            i = ComposableLambdaKt.differentBits(realParams);
        } else {
            i = ComposableLambdaKt.sameBits(realParams);
        }
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.jvm.functions.FunctionN<*>");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.addSpread(allArgsButLast);
        spreadBuilder.add(Integer.valueOf(i | lastChanged));
        Object result = ((FunctionN) obj).invoke(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
        ScopeUpdateScope endRestartGroup = c2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ComposableLambdaNImpl$invoke$1(args, realParams, this));
        }
        return result;
    }
}
