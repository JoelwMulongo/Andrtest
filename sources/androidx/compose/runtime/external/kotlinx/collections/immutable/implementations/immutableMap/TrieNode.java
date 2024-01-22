package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b(\b\u0000\u0018\u0000 }*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0002}~B'\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b¢\u0006\u0002\u0010\tB/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0001\u0010\u0011\u001a\u00020\u00122\u0001\u0010\u0013\u001a}\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00120\u0014H\u0000¢\u0006\u0002\b\u001aJ\u0001\u0010\u0011\u001a\u00020\u00122\u0001\u0010\u0013\u001a}\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001cH\u0002J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001cH\u0002JO\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0005H\u0002J\u0015\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010*J\u0017\u0010+\u001a\u0004\u0018\u00018\u00012\u0006\u0010)\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010,J+\u0010-\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001c2\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010/J#\u00100\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00101J+\u00100\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u00102J\u001e\u00103\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00104\u001a\u00020\u0005H\u0002J#\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u00107J\u001c\u00108\u001a\u00020(2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002J\r\u0010:\u001a\u00020\u0005H\u0000¢\u0006\u0002\b;J\u0015\u0010<\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0000¢\u0006\u0002\b=J%\u0010>\u001a\u0004\u0018\u00018\u00012\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010?J\u0015\u0010@\u001a\u00020(2\u0006\u0010 \u001a\u00020\u0005H\u0000¢\u0006\u0002\bAJ\u0010\u0010B\u001a\u00020(2\u0006\u0010 \u001a\u00020\u0005H\u0002J1\u0010C\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010 \u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010DJ\u0015\u0010E\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010FJ[\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00028\u00002\u0006\u0010J\u001a\u00028\u00012\u0006\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00028\u00002\u0006\u0010M\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010NJI\u0010O\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010PJ=\u0010Q\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010TJ8\u0010U\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010V\u001a\u00020W2\u0006\u0010$\u001a\u00020\u000bH\u0002J?\u0010X\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010TJ7\u0010X\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010YJ2\u0010Z\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00104\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002J9\u0010[\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010 \u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010$\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\\JQ\u0010]\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010^JK\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010S¢\u0006\u0002\u0010`JJ\u0010a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010V\u001a\u00020W2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SJT\u0010b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010V\u001a\u00020W2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002JM\u0010c\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010S¢\u0006\u0002\u0010`JE\u0010c\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010S¢\u0006\u0002\u0010dJ:\u0010e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002J.\u0010f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000bH\u0002JX\u0010h\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u0010j\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000bH\u0002J8\u0010k\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0012\u0010j\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010$\u001a\u00020\u000bH\u0002J=\u0010l\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010.\u001a\u00028\u00012\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010mJ!\u0010n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010g\u001a\u00020\u0005H\u0000¢\u0006\u0002\boJ\u0015\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0000¢\u0006\u0002\bpJ9\u0010q\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001c2\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010rJ9\u0010s\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010tJ1\u0010s\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010uJ&\u0010v\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002J&\u0010w\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002JP\u0010x\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u0010j\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002J8\u0010y\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0012\u0010j\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002J)\u0010z\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010{J\u0015\u0010|\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010FR0\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b@BX\u000e¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "K", "V", "", "dataMap", "", "nodeMap", "buffer", "", "(II[Ljava/lang/Object;)V", "ownedBy", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "(II[Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "<set-?>", "getBuffer$runtime_release", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "accept", "", "visitor", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "node", "shift", "hash", "accept$runtime_release", "asInsertResult", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "asUpdateResult", "bufferMoveEntryToNode", "keyIndex", "positionMask", "newKeyHash", "newKey", "newValue", "owner", "(IIILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)[Ljava/lang/Object;", "calculateSize", "collisionContainsKey", "", "key", "(Ljava/lang/Object;)Z", "collisionGet", "(Ljava/lang/Object;)Ljava/lang/Object;", "collisionPut", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "collisionRemove", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "collisionRemoveEntryAtIndex", "i", "containsKey", "keyHash", "(ILjava/lang/Object;I)Z", "elementsIdentityEquals", "otherNode", "entryCount", "entryCount$runtime_release", "entryKeyIndex", "entryKeyIndex$runtime_release", "get", "(ILjava/lang/Object;I)Ljava/lang/Object;", "hasEntryAt", "hasEntryAt$runtime_release", "hasNodeAt", "insertEntryAt", "(ILjava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "keyAtIndex", "(I)Ljava/lang/Object;", "makeNode", "keyHash1", "key1", "value1", "keyHash2", "key2", "value2", "(ILjava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "moveEntryToNode", "(IIILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionPut", "mutator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionPutAll", "intersectionCounter", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "mutableCollisionRemove", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionRemoveEntryAtIndex", "mutableInsertEntryAt", "(ILjava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableMoveEntryToNode", "(IIILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutablePut", "(ILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutablePutAll", "mutablePutAllFromOtherNodeCell", "mutableRemove", "(ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableRemoveEntryAtIndex", "mutableRemoveNodeAtIndex", "nodeIndex", "mutableReplaceNode", "targetNode", "newNode", "mutableUpdateNodeAtIndex", "mutableUpdateValueAtIndex", "(ILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "nodeAtIndex", "nodeAtIndex$runtime_release", "nodeIndex$runtime_release", "put", "(ILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "remove", "(ILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "(ILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "removeEntryAtIndex", "removeNodeAtIndex", "replaceNode", "updateNodeAtIndex", "updateValueAtIndex", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "valueAtKeyIndex", "Companion", "ModificationResult", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TrieNode.kt */
public final class TrieNode<K, V> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TrieNode EMPTY = new TrieNode(0, 0, new Object[0]);
    private Object[] buffer;
    private int dataMap;
    private int nodeMap;
    private final MutabilityOwnership ownedBy;

    public TrieNode(int dataMap2, int nodeMap2, Object[] buffer2, MutabilityOwnership ownedBy2) {
        Intrinsics.checkNotNullParameter(buffer2, "buffer");
        this.dataMap = dataMap2;
        this.nodeMap = nodeMap2;
        this.ownedBy = ownedBy2;
        this.buffer = buffer2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TrieNode(int dataMap2, int nodeMap2, Object[] buffer2) {
        this(dataMap2, nodeMap2, buffer2, (MutabilityOwnership) null);
        Intrinsics.checkNotNullParameter(buffer2, "buffer");
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJD\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002*\u0010\u0010\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u0011H\bø\u0001\u0000R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "K", "V", "", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "sizeDelta", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;I)V", "getNode", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "setNode", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)V", "getSizeDelta", "()I", "replaceNode", "operation", "Lkotlin/Function1;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TrieNode.kt */
    public static final class ModificationResult<K, V> {
        private TrieNode<K, V> node;
        private final int sizeDelta;

        public ModificationResult(TrieNode<K, V> node2, int sizeDelta2) {
            Intrinsics.checkNotNullParameter(node2, "node");
            this.node = node2;
            this.sizeDelta = sizeDelta2;
        }

        public final TrieNode<K, V> getNode() {
            return this.node;
        }

        public final int getSizeDelta() {
            return this.sizeDelta;
        }

        public final void setNode(TrieNode<K, V> trieNode) {
            Intrinsics.checkNotNullParameter(trieNode, "<set-?>");
            this.node = trieNode;
        }

        public final ModificationResult<K, V> replaceNode(Function1<? super TrieNode<K, V>, TrieNode<K, V>> operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            ModificationResult $this$replaceNode_u24lambda_u240 = this;
            $this$replaceNode_u24lambda_u240.setNode(operation.invoke($this$replaceNode_u24lambda_u240.getNode()));
            return this;
        }
    }

    private final ModificationResult<K, V> asInsertResult() {
        return new ModificationResult<>(this, 1);
    }

    private final ModificationResult<K, V> asUpdateResult() {
        return new ModificationResult<>(this, 0);
    }

    public final Object[] getBuffer$runtime_release() {
        return this.buffer;
    }

    public final int entryCount$runtime_release() {
        return Integer.bitCount(this.dataMap);
    }

    public final boolean hasEntryAt$runtime_release(int positionMask) {
        return (this.dataMap & positionMask) != 0;
    }

    private final boolean hasNodeAt(int positionMask) {
        return (this.nodeMap & positionMask) != 0;
    }

    public final int entryKeyIndex$runtime_release(int positionMask) {
        return Integer.bitCount(this.dataMap & (positionMask - 1)) * 2;
    }

    public final int nodeIndex$runtime_release(int positionMask) {
        return (this.buffer.length - 1) - Integer.bitCount(this.nodeMap & (positionMask - 1));
    }

    private final K keyAtIndex(int keyIndex) {
        return this.buffer[keyIndex];
    }

    private final V valueAtKeyIndex(int keyIndex) {
        return this.buffer[keyIndex + 1];
    }

    public final TrieNode<K, V> nodeAtIndex$runtime_release(int nodeIndex) {
        Object obj = this.buffer[nodeIndex];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return (TrieNode) obj;
    }

    private final TrieNode<K, V> insertEntryAt(int positionMask, K key, V value) {
        return new TrieNode<>(this.dataMap | positionMask, this.nodeMap, TrieNodeKt.insertEntryAtIndex(this.buffer, entryKeyIndex$runtime_release(positionMask), key, value));
    }

    private final TrieNode<K, V> mutableInsertEntryAt(int positionMask, K key, V value, MutabilityOwnership owner) {
        int keyIndex = entryKeyIndex$runtime_release(positionMask);
        if (this.ownedBy == owner) {
            this.buffer = TrieNodeKt.insertEntryAtIndex(this.buffer, keyIndex, key, value);
            this.dataMap |= positionMask;
            return this;
        }
        return new TrieNode<>(this.dataMap | positionMask, this.nodeMap, TrieNodeKt.insertEntryAtIndex(this.buffer, keyIndex, key, value), owner);
    }

    private final TrieNode<K, V> updateValueAtIndex(int keyIndex, V value) {
        Object[] objArr = this.buffer;
        Object[] newBuffer = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(newBuffer, "copyOf(this, size)");
        newBuffer[keyIndex + 1] = value;
        return new TrieNode<>(this.dataMap, this.nodeMap, newBuffer);
    }

    private final TrieNode<K, V> mutableUpdateValueAtIndex(int keyIndex, V value, PersistentHashMapBuilder<K, V> mutator) {
        if (this.ownedBy == mutator.getOwnership$runtime_release()) {
            this.buffer[keyIndex + 1] = value;
            return this;
        }
        mutator.setModCount$runtime_release(mutator.getModCount$runtime_release() + 1);
        Object[] objArr = this.buffer;
        Object[] newBuffer = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(newBuffer, "copyOf(this, size)");
        newBuffer[keyIndex + 1] = value;
        return new TrieNode<>(this.dataMap, this.nodeMap, newBuffer, mutator.getOwnership$runtime_release());
    }

    private final TrieNode<K, V> updateNodeAtIndex(int nodeIndex, int positionMask, TrieNode<K, V> newNode) {
        Object[] newNodeBuffer = newNode.buffer;
        if (newNodeBuffer.length != 2 || newNode.nodeMap != 0) {
            Object[] objArr = this.buffer;
            Object[] newBuffer = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.checkNotNullExpressionValue(newBuffer, "copyOf(this, newSize)");
            newBuffer[nodeIndex] = newNode;
            return new TrieNode<>(this.dataMap, this.nodeMap, newBuffer);
        } else if (this.buffer.length == 1) {
            newNode.dataMap = this.nodeMap;
            return newNode;
        } else {
            return new TrieNode<>(this.dataMap ^ positionMask, this.nodeMap ^ positionMask, TrieNodeKt.replaceNodeWithEntry(this.buffer, nodeIndex, entryKeyIndex$runtime_release(positionMask), newNodeBuffer[0], newNodeBuffer[1]));
        }
    }

    private final TrieNode<K, V> mutableUpdateNodeAtIndex(int nodeIndex, TrieNode<K, V> newNode, MutabilityOwnership owner) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1 && newNode.buffer.length == 2 && newNode.nodeMap == 0) {
            newNode.dataMap = this.nodeMap;
            return newNode;
        } else if (this.ownedBy == owner) {
            objArr[nodeIndex] = newNode;
            return this;
        } else {
            Object[] newBuffer = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.checkNotNullExpressionValue(newBuffer, "copyOf(this, size)");
            newBuffer[nodeIndex] = newNode;
            return new TrieNode<>(this.dataMap, this.nodeMap, newBuffer, owner);
        }
    }

    private final TrieNode<K, V> removeNodeAtIndex(int nodeIndex, int positionMask) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1) {
            return null;
        }
        return new TrieNode<>(this.dataMap, this.nodeMap ^ positionMask, TrieNodeKt.removeNodeAtIndex(objArr, nodeIndex));
    }

    private final TrieNode<K, V> mutableRemoveNodeAtIndex(int nodeIndex, int positionMask, MutabilityOwnership owner) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1) {
            return null;
        }
        if (this.ownedBy == owner) {
            this.buffer = TrieNodeKt.removeNodeAtIndex(objArr, nodeIndex);
            this.nodeMap ^= positionMask;
            return this;
        }
        return new TrieNode<>(this.dataMap, this.nodeMap ^ positionMask, TrieNodeKt.removeNodeAtIndex(objArr, nodeIndex), owner);
    }

    private final Object[] bufferMoveEntryToNode(int keyIndex, int positionMask, int newKeyHash, K newKey, V newValue, int shift, MutabilityOwnership owner) {
        Object storedKey = keyAtIndex(keyIndex);
        int i = positionMask;
        int i2 = keyIndex;
        return TrieNodeKt.replaceEntryWithNode(this.buffer, keyIndex, nodeIndex$runtime_release(positionMask) + 1, makeNode(storedKey != null ? storedKey.hashCode() : 0, storedKey, valueAtKeyIndex(keyIndex), newKeyHash, newKey, newValue, shift + 5, owner));
    }

    private final TrieNode<K, V> moveEntryToNode(int keyIndex, int positionMask, int newKeyHash, K newKey, V newValue, int shift) {
        return new TrieNode<>(this.dataMap ^ positionMask, this.nodeMap | positionMask, bufferMoveEntryToNode(keyIndex, positionMask, newKeyHash, newKey, newValue, shift, (MutabilityOwnership) null));
    }

    private final TrieNode<K, V> mutableMoveEntryToNode(int keyIndex, int positionMask, int newKeyHash, K newKey, V newValue, int shift, MutabilityOwnership owner) {
        if (this.ownedBy == owner) {
            this.buffer = bufferMoveEntryToNode(keyIndex, positionMask, newKeyHash, newKey, newValue, shift, owner);
            this.dataMap ^= positionMask;
            this.nodeMap |= positionMask;
            return this;
        }
        return new TrieNode<>(this.dataMap ^ positionMask, this.nodeMap | positionMask, bufferMoveEntryToNode(keyIndex, positionMask, newKeyHash, newKey, newValue, shift, owner), owner);
    }

    private final TrieNode<K, V> makeNode(int keyHash1, K key1, V value1, int keyHash2, K key2, V value2, int shift, MutabilityOwnership owner) {
        Object[] nodeBuffer;
        K k = key1;
        V v = value1;
        K k2 = key2;
        V v2 = value2;
        int i = shift;
        MutabilityOwnership mutabilityOwnership = owner;
        if (i > 30) {
            return new TrieNode<>(0, 0, new Object[]{k, v, k2, v2}, mutabilityOwnership);
        }
        int setBit1 = TrieNodeKt.indexSegment(keyHash1, i);
        int setBit2 = TrieNodeKt.indexSegment(keyHash2, i);
        if (setBit1 != setBit2) {
            if (setBit1 < setBit2) {
                nodeBuffer = new Object[]{k, v, k2, v2};
            } else {
                nodeBuffer = new Object[]{k2, v2, k, v};
            }
            return new TrieNode<>((1 << setBit1) | (1 << setBit2), 0, nodeBuffer, mutabilityOwnership);
        }
        int i2 = setBit2;
        return new TrieNode<>(0, 1 << setBit1, new Object[]{makeNode(keyHash1, key1, value1, keyHash2, key2, value2, i + 5, owner)}, mutabilityOwnership);
    }

    private final TrieNode<K, V> removeEntryAtIndex(int keyIndex, int positionMask) {
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        return new TrieNode<>(this.dataMap ^ positionMask, this.nodeMap, TrieNodeKt.removeEntryAtIndex(objArr, keyIndex));
    }

    private final TrieNode<K, V> mutableRemoveEntryAtIndex(int keyIndex, int positionMask, PersistentHashMapBuilder<K, V> mutator) {
        mutator.setSize(mutator.size() - 1);
        mutator.setOperationResult$runtime_release(valueAtKeyIndex(keyIndex));
        if (this.buffer.length == 2) {
            return null;
        }
        if (this.ownedBy == mutator.getOwnership$runtime_release()) {
            this.buffer = TrieNodeKt.removeEntryAtIndex(this.buffer, keyIndex);
            this.dataMap ^= positionMask;
            return this;
        }
        return new TrieNode<>(this.dataMap ^ positionMask, this.nodeMap, TrieNodeKt.removeEntryAtIndex(this.buffer, keyIndex), mutator.getOwnership$runtime_release());
    }

    private final TrieNode<K, V> collisionRemoveEntryAtIndex(int i) {
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        return new TrieNode<>(0, 0, TrieNodeKt.removeEntryAtIndex(objArr, i));
    }

    private final TrieNode<K, V> mutableCollisionRemoveEntryAtIndex(int i, PersistentHashMapBuilder<K, V> mutator) {
        mutator.setSize(mutator.size() - 1);
        mutator.setOperationResult$runtime_release(valueAtKeyIndex(i));
        if (this.buffer.length == 2) {
            return null;
        }
        if (this.ownedBy != mutator.getOwnership$runtime_release()) {
            return new TrieNode<>(0, 0, TrieNodeKt.removeEntryAtIndex(this.buffer, i), mutator.getOwnership$runtime_release());
        }
        this.buffer = TrieNodeKt.removeEntryAtIndex(this.buffer, i);
        return this;
    }

    private final boolean collisionContainsKey(K key) {
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, this.buffer.length), 2);
        int i = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && i <= last) || (step2 < 0 && last <= i)) {
            while (!Intrinsics.areEqual((Object) key, this.buffer[i])) {
                if (i != last) {
                    i += step2;
                }
            }
            return true;
        }
        return false;
    }

    private final V collisionGet(K key) {
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, this.buffer.length), 2);
        int i = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 <= 0 || i > last) && (step2 >= 0 || last > i)) {
            return null;
        }
        while (!Intrinsics.areEqual((Object) key, keyAtIndex(i))) {
            if (i == last) {
                return null;
            }
            i += step2;
        }
        return valueAtKeyIndex(i);
    }

    private final ModificationResult<K, V> collisionPut(K key, V value) {
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, this.buffer.length), 2);
        int i = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && i <= last) || (step2 < 0 && last <= i)) {
            while (!Intrinsics.areEqual((Object) key, keyAtIndex(i))) {
                if (i != last) {
                    i += step2;
                }
            }
            if (value == valueAtKeyIndex(i)) {
                return null;
            }
            Object[] objArr = this.buffer;
            Object[] newBuffer = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.checkNotNullExpressionValue(newBuffer, "copyOf(this, size)");
            newBuffer[i + 1] = value;
            return new TrieNode(0, 0, newBuffer).asUpdateResult();
        }
        return new TrieNode(0, 0, TrieNodeKt.insertEntryAtIndex(this.buffer, 0, key, value)).asInsertResult();
    }

    private final TrieNode<K, V> mutableCollisionPut(K key, V value, PersistentHashMapBuilder<K, V> mutator) {
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, this.buffer.length), 2);
        int i = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && i <= last) || (step2 < 0 && last <= i)) {
            while (!Intrinsics.areEqual((Object) key, keyAtIndex(i))) {
                if (i != last) {
                    i += step2;
                }
            }
            mutator.setOperationResult$runtime_release(valueAtKeyIndex(i));
            if (this.ownedBy == mutator.getOwnership$runtime_release()) {
                this.buffer[i + 1] = value;
                return this;
            }
            mutator.setModCount$runtime_release(mutator.getModCount$runtime_release() + 1);
            Object[] objArr = this.buffer;
            Object[] newBuffer = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.checkNotNullExpressionValue(newBuffer, "copyOf(this, size)");
            newBuffer[i + 1] = value;
            return new TrieNode<>(0, 0, newBuffer, mutator.getOwnership$runtime_release());
        }
        mutator.setSize(mutator.size() + 1);
        return new TrieNode<>(0, 0, TrieNodeKt.insertEntryAtIndex(this.buffer, 0, key, value), mutator.getOwnership$runtime_release());
    }

    private final TrieNode<K, V> collisionRemove(K key) {
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, this.buffer.length), 2);
        int i = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && i <= last) || (step2 < 0 && last <= i)) {
            while (!Intrinsics.areEqual((Object) key, keyAtIndex(i))) {
                if (i != last) {
                    i += step2;
                }
            }
            return collisionRemoveEntryAtIndex(i);
        }
        return this;
    }

    private final TrieNode<K, V> mutableCollisionRemove(K key, PersistentHashMapBuilder<K, V> mutator) {
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, this.buffer.length), 2);
        int i = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && i <= last) || (step2 < 0 && last <= i)) {
            while (!Intrinsics.areEqual((Object) key, keyAtIndex(i))) {
                if (i != last) {
                    i += step2;
                }
            }
            return mutableCollisionRemoveEntryAtIndex(i, mutator);
        }
        return this;
    }

    private final TrieNode<K, V> collisionRemove(K key, V value) {
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, this.buffer.length), 2);
        int i = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && i <= last) || (step2 < 0 && last <= i)) {
            while (true) {
                if (!Intrinsics.areEqual((Object) key, keyAtIndex(i)) || !Intrinsics.areEqual((Object) value, valueAtKeyIndex(i))) {
                    if (i == last) {
                        break;
                    }
                    i += step2;
                } else {
                    return collisionRemoveEntryAtIndex(i);
                }
            }
        }
        return this;
    }

    private final TrieNode<K, V> mutableCollisionRemove(K key, V value, PersistentHashMapBuilder<K, V> mutator) {
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, this.buffer.length), 2);
        int i = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && i <= last) || (step2 < 0 && last <= i)) {
            while (true) {
                if (!Intrinsics.areEqual((Object) key, keyAtIndex(i)) || !Intrinsics.areEqual((Object) value, valueAtKeyIndex(i))) {
                    if (i == last) {
                        break;
                    }
                    i += step2;
                } else {
                    return mutableCollisionRemoveEntryAtIndex(i, mutator);
                }
            }
        }
        return this;
    }

    private final TrieNode<K, V> mutableCollisionPutAll(TrieNode<K, V> otherNode, DeltaCounter intersectionCounter, MutabilityOwnership owner) {
        CommonFunctionsKt.m2802assert(this.nodeMap == 0);
        CommonFunctionsKt.m2802assert(this.dataMap == 0);
        CommonFunctionsKt.m2802assert(otherNode.nodeMap == 0);
        CommonFunctionsKt.m2802assert(otherNode.dataMap == 0);
        Object[] objArr = this.buffer;
        Object[] tempBuffer = Arrays.copyOf(objArr, objArr.length + otherNode.buffer.length);
        Intrinsics.checkNotNullExpressionValue(tempBuffer, "copyOf(this, newSize)");
        int i = this.buffer.length;
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, otherNode.buffer.length), 2);
        int j = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && j <= last) || (step2 < 0 && last <= j)) {
            while (true) {
                if (!collisionContainsKey(otherNode.buffer[j])) {
                    Object[] objArr2 = otherNode.buffer;
                    tempBuffer[i] = objArr2[j];
                    tempBuffer[i + 1] = objArr2[j + 1];
                    i += 2;
                } else {
                    intersectionCounter.setCount(intersectionCounter.getCount() + 1);
                }
                if (j == last) {
                    break;
                }
                j += step2;
            }
        }
        int newSize = i;
        if (newSize == this.buffer.length) {
            return this;
        }
        if (newSize == otherNode.buffer.length) {
            return otherNode;
        }
        if (newSize == tempBuffer.length) {
            return new TrieNode<>(0, 0, tempBuffer, owner);
        }
        Object[] copyOf = Arrays.copyOf(tempBuffer, newSize);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return new TrieNode<>(0, 0, copyOf, owner);
    }

    private final TrieNode<K, V> mutablePutAllFromOtherNodeCell(TrieNode<K, V> otherNode, int positionMask, int shift, DeltaCounter intersectionCounter, PersistentHashMapBuilder<K, V> mutator) {
        TrieNode<K, V> trieNode = otherNode;
        int i = positionMask;
        DeltaCounter deltaCounter = intersectionCounter;
        int i2 = 0;
        if (hasNodeAt(i)) {
            TrieNode<K, V> nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(i));
            if (otherNode.hasNodeAt(positionMask)) {
                return nodeAtIndex$runtime_release.mutablePutAll(trieNode.nodeAtIndex$runtime_release(otherNode.nodeIndex$runtime_release(positionMask)), shift + 5, deltaCounter, mutator);
            }
            PersistentHashMapBuilder<K, V> persistentHashMapBuilder = mutator;
            if (!otherNode.hasEntryAt$runtime_release(positionMask)) {
                return nodeAtIndex$runtime_release;
            }
            int keyIndex = otherNode.entryKeyIndex$runtime_release(positionMask);
            Object key = trieNode.keyAtIndex(keyIndex);
            V valueAtKeyIndex = trieNode.valueAtKeyIndex(keyIndex);
            int oldSize = mutator.size();
            if (key != null) {
                i2 = key.hashCode();
            }
            int oldSize2 = oldSize;
            TrieNode targetNode = nodeAtIndex$runtime_release.mutablePut(i2, key, valueAtKeyIndex, shift + 5, mutator);
            TrieNode trieNode2 = targetNode;
            if (mutator.size() == oldSize2) {
                deltaCounter.setCount(intersectionCounter.getCount() + 1);
            }
            return targetNode;
        }
        PersistentHashMapBuilder<K, V> persistentHashMapBuilder2 = mutator;
        if (otherNode.hasNodeAt(positionMask)) {
            TrieNode<K, V> nodeAtIndex$runtime_release2 = trieNode.nodeAtIndex$runtime_release(otherNode.nodeIndex$runtime_release(positionMask));
            if (!hasEntryAt$runtime_release(i)) {
                return nodeAtIndex$runtime_release2;
            }
            int keyIndex2 = entryKeyIndex$runtime_release(i);
            Object key2 = keyAtIndex(keyIndex2);
            if (nodeAtIndex$runtime_release2.containsKey(key2 != null ? key2.hashCode() : 0, key2, shift + 5)) {
                deltaCounter.setCount(intersectionCounter.getCount() + 1);
                return nodeAtIndex$runtime_release2;
            }
            Object value = valueAtKeyIndex(keyIndex2);
            if (key2 != null) {
                i2 = key2.hashCode();
            }
            return nodeAtIndex$runtime_release2.mutablePut(i2, key2, value, shift + 5, mutator);
        }
        int thisKeyIndex = entryKeyIndex$runtime_release(i);
        Object thisKey = keyAtIndex(thisKeyIndex);
        Object thisValue = valueAtKeyIndex(thisKeyIndex);
        int otherKeyIndex = otherNode.entryKeyIndex$runtime_release(positionMask);
        Object otherKey = trieNode.keyAtIndex(otherKeyIndex);
        int i3 = otherKeyIndex;
        return makeNode(thisKey != null ? thisKey.hashCode() : 0, thisKey, thisValue, otherKey != null ? otherKey.hashCode() : 0, otherKey, trieNode.valueAtKeyIndex(otherKeyIndex), shift + 5, mutator.getOwnership$runtime_release());
    }

    private final int calculateSize() {
        if (this.nodeMap == 0) {
            return this.buffer.length / 2;
        }
        int numValues = Integer.bitCount(this.dataMap);
        int result = numValues;
        int length = this.buffer.length;
        for (int i = numValues * 2; i < length; i++) {
            result += nodeAtIndex$runtime_release(i).calculateSize();
        }
        return result;
    }

    private final boolean elementsIdentityEquals(TrieNode<K, V> otherNode) {
        if (this == otherNode) {
            return true;
        }
        if (this.nodeMap != otherNode.nodeMap || this.dataMap != otherNode.dataMap) {
            return false;
        }
        int length = this.buffer.length;
        for (int i = 0; i < length; i++) {
            if (this.buffer[i] != otherNode.buffer[i]) {
                return false;
            }
        }
        return true;
    }

    public final boolean containsKey(int keyHash, K key, int shift) {
        int keyPositionMask = 1 << TrieNodeKt.indexSegment(keyHash, shift);
        if (hasEntryAt$runtime_release(keyPositionMask)) {
            return Intrinsics.areEqual((Object) key, keyAtIndex(entryKeyIndex$runtime_release(keyPositionMask)));
        }
        if (!hasNodeAt(keyPositionMask)) {
            return false;
        }
        TrieNode targetNode = nodeAtIndex$runtime_release(nodeIndex$runtime_release(keyPositionMask));
        if (shift == 30) {
            return targetNode.collisionContainsKey(key);
        }
        return targetNode.containsKey(keyHash, key, shift + 5);
    }

    public final V get(int keyHash, K key, int shift) {
        int keyPositionMask = 1 << TrieNodeKt.indexSegment(keyHash, shift);
        if (hasEntryAt$runtime_release(keyPositionMask)) {
            int keyIndex = entryKeyIndex$runtime_release(keyPositionMask);
            if (Intrinsics.areEqual((Object) key, keyAtIndex(keyIndex))) {
                return valueAtKeyIndex(keyIndex);
            }
            return null;
        } else if (hasNodeAt(keyPositionMask) == 0) {
            return null;
        } else {
            TrieNode targetNode = nodeAtIndex$runtime_release(nodeIndex$runtime_release(keyPositionMask));
            if (shift == 30) {
                return targetNode.collisionGet(key);
            }
            return targetNode.get(keyHash, key, shift + 5);
        }
    }

    public final TrieNode<K, V> mutablePutAll(TrieNode<K, V> otherNode, int shift, DeltaCounter intersectionCounter, PersistentHashMapBuilder<K, V> mutator) {
        TrieNode trieNode;
        int $this$forEachOneBit$iv;
        boolean z;
        TrieNode<K, V> trieNode2 = otherNode;
        DeltaCounter deltaCounter = intersectionCounter;
        Intrinsics.checkNotNullParameter(trieNode2, "otherNode");
        Intrinsics.checkNotNullParameter(deltaCounter, "intersectionCounter");
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        if (this == trieNode2) {
            deltaCounter.plusAssign(calculateSize());
            return this;
        } else if (shift > 30) {
            return mutableCollisionPutAll(trieNode2, deltaCounter, mutator.getOwnership$runtime_release());
        } else {
            int newNodeMap = this.nodeMap | trieNode2.nodeMap;
            int i = this.dataMap;
            int i2 = trieNode2.dataMap;
            int mask$iv = i & i2;
            int index$iv = 0;
            int newNodeMap2 = newNodeMap;
            int newDataMap = (i ^ i2) & (~newNodeMap);
            while (mask$iv != 0) {
                int bit$iv = Integer.lowestOneBit(mask$iv);
                int positionMask = bit$iv;
                if (Intrinsics.areEqual(keyAtIndex(entryKeyIndex$runtime_release(positionMask)), trieNode2.keyAtIndex(trieNode2.entryKeyIndex$runtime_release(positionMask)))) {
                    newDataMap |= positionMask;
                } else {
                    newNodeMap2 |= positionMask;
                }
                index$iv++;
                mask$iv ^= bit$iv;
            }
            if ((newNodeMap2 & newDataMap) == 0) {
                if (Intrinsics.areEqual((Object) this.ownedBy, (Object) mutator.getOwnership$runtime_release()) && this.dataMap == newDataMap && this.nodeMap == newNodeMap2) {
                    trieNode = this;
                } else {
                    trieNode = new TrieNode(newDataMap, newNodeMap2, new Object[((Integer.bitCount(newDataMap) * 2) + Integer.bitCount(newNodeMap2))]);
                }
                TrieNode mutableNode = trieNode;
                int mask$iv2 = newNodeMap2;
                int index$iv2 = 0;
                while (mask$iv2 != 0) {
                    int bit$iv2 = Integer.lowestOneBit(mask$iv2);
                    Object[] objArr = mutableNode.buffer;
                    objArr[(objArr.length - 1) - index$iv2] = mutablePutAllFromOtherNodeCell(otherNode, bit$iv2, shift, intersectionCounter, mutator);
                    index$iv2++;
                    mask$iv2 ^= bit$iv2;
                }
                int $this$forEachOneBit$iv2 = newDataMap;
                int mask$iv3 = $this$forEachOneBit$iv2;
                int index$iv3 = 0;
                while (mask$iv3 != 0) {
                    int bit$iv3 = Integer.lowestOneBit(mask$iv3);
                    int positionMask2 = bit$iv3;
                    int newKeyIndex = index$iv3 * 2;
                    if (!trieNode2.hasEntryAt$runtime_release(positionMask2)) {
                        int oldKeyIndex = entryKeyIndex$runtime_release(positionMask2);
                        $this$forEachOneBit$iv = $this$forEachOneBit$iv2;
                        mutableNode.buffer[newKeyIndex] = keyAtIndex(oldKeyIndex);
                        mutableNode.buffer[newKeyIndex + 1] = valueAtKeyIndex(oldKeyIndex);
                        z = true;
                    } else {
                        $this$forEachOneBit$iv = $this$forEachOneBit$iv2;
                        int oldKeyIndex2 = trieNode2.entryKeyIndex$runtime_release(positionMask2);
                        mutableNode.buffer[newKeyIndex] = trieNode2.keyAtIndex(oldKeyIndex2);
                        mutableNode.buffer[newKeyIndex + 1] = trieNode2.valueAtKeyIndex(oldKeyIndex2);
                        if (hasEntryAt$runtime_release(positionMask2)) {
                            z = true;
                            deltaCounter.setCount(intersectionCounter.getCount() + 1);
                        } else {
                            z = true;
                        }
                    }
                    index$iv3++;
                    mask$iv3 ^= bit$iv3;
                    boolean z2 = z;
                    $this$forEachOneBit$iv2 = $this$forEachOneBit$iv;
                }
                if (elementsIdentityEquals(mutableNode)) {
                    return this;
                }
                if (trieNode2.elementsIdentityEquals(mutableNode)) {
                    return trieNode2;
                }
                return mutableNode;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final ModificationResult<K, V> put(int keyHash, K key, V value, int shift) {
        ModificationResult modificationResult;
        int keyPositionMask = 1 << TrieNodeKt.indexSegment(keyHash, shift);
        if (hasEntryAt$runtime_release(keyPositionMask)) {
            int keyIndex = entryKeyIndex$runtime_release(keyPositionMask);
            if (!Intrinsics.areEqual((Object) key, keyAtIndex(keyIndex))) {
                return moveEntryToNode(keyIndex, keyPositionMask, keyHash, key, value, shift).asInsertResult();
            }
            if (valueAtKeyIndex(keyIndex) == value) {
                return null;
            }
            return updateValueAtIndex(keyIndex, value).asUpdateResult();
        } else if (hasNodeAt(keyPositionMask) == 0) {
            return insertEntryAt(keyPositionMask, key, value).asInsertResult();
        } else {
            int nodeIndex = nodeIndex$runtime_release(keyPositionMask);
            TrieNode targetNode = nodeAtIndex$runtime_release(nodeIndex);
            if (shift == 30) {
                modificationResult = targetNode.collisionPut(key, value);
                if (modificationResult == null) {
                    return null;
                }
            } else {
                modificationResult = targetNode.put(keyHash, key, value, shift + 5);
                if (modificationResult == null) {
                    return null;
                }
            }
            ModificationResult modificationResult2 = modificationResult;
            ModificationResult $this$replaceNode_u24lambda_u240$iv = modificationResult;
            $this$replaceNode_u24lambda_u240$iv.setNode(updateNodeAtIndex(nodeIndex, keyPositionMask, $this$replaceNode_u24lambda_u240$iv.getNode()));
            return modificationResult;
        }
    }

    public final TrieNode<K, V> mutablePut(int keyHash, K key, V value, int shift, PersistentHashMapBuilder<K, V> mutator) {
        TrieNode newNode;
        K k = key;
        V v = value;
        int i = shift;
        PersistentHashMapBuilder<K, V> persistentHashMapBuilder = mutator;
        Intrinsics.checkNotNullParameter(persistentHashMapBuilder, "mutator");
        int keyPositionMask = 1 << TrieNodeKt.indexSegment(keyHash, i);
        if (hasEntryAt$runtime_release(keyPositionMask)) {
            int keyIndex = entryKeyIndex$runtime_release(keyPositionMask);
            if (Intrinsics.areEqual((Object) k, keyAtIndex(keyIndex))) {
                persistentHashMapBuilder.setOperationResult$runtime_release(valueAtKeyIndex(keyIndex));
                if (valueAtKeyIndex(keyIndex) == v) {
                    return this;
                }
                return mutableUpdateValueAtIndex(keyIndex, v, persistentHashMapBuilder);
            }
            persistentHashMapBuilder.setSize(mutator.size() + 1);
            return mutableMoveEntryToNode(keyIndex, keyPositionMask, keyHash, key, value, shift, mutator.getOwnership$runtime_release());
        } else if (hasNodeAt(keyPositionMask)) {
            int nodeIndex = nodeIndex$runtime_release(keyPositionMask);
            TrieNode targetNode = nodeAtIndex$runtime_release(nodeIndex);
            if (i == 30) {
                newNode = targetNode.mutableCollisionPut(k, v, persistentHashMapBuilder);
            } else {
                newNode = targetNode.mutablePut(keyHash, key, value, i + 5, mutator);
            }
            if (targetNode == newNode) {
                return this;
            }
            return mutableUpdateNodeAtIndex(nodeIndex, newNode, mutator.getOwnership$runtime_release());
        } else {
            persistentHashMapBuilder.setSize(mutator.size() + 1);
            return mutableInsertEntryAt(keyPositionMask, k, v, mutator.getOwnership$runtime_release());
        }
    }

    public final TrieNode<K, V> remove(int keyHash, K key, int shift) {
        TrieNode newNode;
        int keyPositionMask = 1 << TrieNodeKt.indexSegment(keyHash, shift);
        if (hasEntryAt$runtime_release(keyPositionMask)) {
            int keyIndex = entryKeyIndex$runtime_release(keyPositionMask);
            if (Intrinsics.areEqual((Object) key, keyAtIndex(keyIndex))) {
                return removeEntryAtIndex(keyIndex, keyPositionMask);
            }
            return this;
        } else if (hasNodeAt(keyPositionMask) == 0) {
            return this;
        } else {
            int nodeIndex = nodeIndex$runtime_release(keyPositionMask);
            TrieNode targetNode = nodeAtIndex$runtime_release(nodeIndex);
            if (shift == 30) {
                newNode = targetNode.collisionRemove(key);
            } else {
                newNode = targetNode.remove(keyHash, key, shift + 5);
            }
            return replaceNode(targetNode, newNode, nodeIndex, keyPositionMask);
        }
    }

    private final TrieNode<K, V> replaceNode(TrieNode<K, V> targetNode, TrieNode<K, V> newNode, int nodeIndex, int positionMask) {
        if (newNode == null) {
            return removeNodeAtIndex(nodeIndex, positionMask);
        }
        if (targetNode != newNode) {
            return updateNodeAtIndex(nodeIndex, positionMask, newNode);
        }
        return this;
    }

    public final TrieNode<K, V> mutableRemove(int keyHash, K key, int shift, PersistentHashMapBuilder<K, V> mutator) {
        TrieNode newNode;
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        int keyPositionMask = 1 << TrieNodeKt.indexSegment(keyHash, shift);
        if (hasEntryAt$runtime_release(keyPositionMask)) {
            int keyIndex = entryKeyIndex$runtime_release(keyPositionMask);
            if (Intrinsics.areEqual((Object) key, keyAtIndex(keyIndex))) {
                return mutableRemoveEntryAtIndex(keyIndex, keyPositionMask, mutator);
            }
            return this;
        } else if (hasNodeAt(keyPositionMask) == 0) {
            return this;
        } else {
            int nodeIndex = nodeIndex$runtime_release(keyPositionMask);
            TrieNode targetNode = nodeAtIndex$runtime_release(nodeIndex);
            if (shift == 30) {
                newNode = targetNode.mutableCollisionRemove(key, mutator);
            } else {
                newNode = targetNode.mutableRemove(keyHash, key, shift + 5, mutator);
            }
            return mutableReplaceNode(targetNode, newNode, nodeIndex, keyPositionMask, mutator.getOwnership$runtime_release());
        }
    }

    private final TrieNode<K, V> mutableReplaceNode(TrieNode<K, V> targetNode, TrieNode<K, V> newNode, int nodeIndex, int positionMask, MutabilityOwnership owner) {
        if (newNode == null) {
            return mutableRemoveNodeAtIndex(nodeIndex, positionMask, owner);
        }
        if (this.ownedBy == owner || targetNode != newNode) {
            return mutableUpdateNodeAtIndex(nodeIndex, newNode, owner);
        }
        return this;
    }

    public final TrieNode<K, V> remove(int keyHash, K key, V value, int shift) {
        TrieNode newNode;
        int keyPositionMask = 1 << TrieNodeKt.indexSegment(keyHash, shift);
        if (hasEntryAt$runtime_release(keyPositionMask)) {
            int keyIndex = entryKeyIndex$runtime_release(keyPositionMask);
            if (!Intrinsics.areEqual((Object) key, keyAtIndex(keyIndex)) || !Intrinsics.areEqual((Object) value, valueAtKeyIndex(keyIndex))) {
                return this;
            }
            return removeEntryAtIndex(keyIndex, keyPositionMask);
        } else if (hasNodeAt(keyPositionMask) == 0) {
            return this;
        } else {
            int nodeIndex = nodeIndex$runtime_release(keyPositionMask);
            TrieNode targetNode = nodeAtIndex$runtime_release(nodeIndex);
            if (shift == 30) {
                newNode = targetNode.collisionRemove(key, value);
            } else {
                newNode = targetNode.remove(keyHash, key, value, shift + 5);
            }
            return replaceNode(targetNode, newNode, nodeIndex, keyPositionMask);
        }
    }

    public final TrieNode<K, V> mutableRemove(int keyHash, K key, V value, int shift, PersistentHashMapBuilder<K, V> mutator) {
        TrieNode newNode;
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        int keyPositionMask = 1 << TrieNodeKt.indexSegment(keyHash, shift);
        if (hasEntryAt$runtime_release(keyPositionMask)) {
            int keyIndex = entryKeyIndex$runtime_release(keyPositionMask);
            if (!Intrinsics.areEqual((Object) key, keyAtIndex(keyIndex)) || !Intrinsics.areEqual((Object) value, valueAtKeyIndex(keyIndex))) {
                return this;
            }
            return mutableRemoveEntryAtIndex(keyIndex, keyPositionMask, mutator);
        } else if (hasNodeAt(keyPositionMask) == 0) {
            return this;
        } else {
            int nodeIndex = nodeIndex$runtime_release(keyPositionMask);
            TrieNode targetNode = nodeAtIndex$runtime_release(nodeIndex);
            if (shift == 30) {
                newNode = targetNode.mutableCollisionRemove(key, value, mutator);
            } else {
                newNode = targetNode.mutableRemove(keyHash, key, value, shift + 5, mutator);
            }
            return mutableReplaceNode(targetNode, newNode, nodeIndex, keyPositionMask, mutator.getOwnership$runtime_release());
        }
    }

    public final void accept$runtime_release(Function5<? super TrieNode<K, V>, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        accept(visitor, 0, 0);
    }

    private final void accept(Function5<? super TrieNode<K, V>, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> visitor, int hash, int shift) {
        visitor.invoke(this, Integer.valueOf(shift), Integer.valueOf(hash), Integer.valueOf(this.dataMap), Integer.valueOf(this.nodeMap));
        int nodePositions = this.nodeMap;
        while (nodePositions != 0) {
            int mask = Integer.lowestOneBit(nodePositions);
            nodeAtIndex$runtime_release(nodeIndex$runtime_release(mask)).accept(visitor, (Integer.numberOfTrailingZeros(mask) << shift) + hash, shift + 5);
            nodePositions -= mask;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "", "getEMPTY$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TrieNode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TrieNode getEMPTY$runtime_release() {
            return TrieNode.EMPTY;
        }
    }
}
