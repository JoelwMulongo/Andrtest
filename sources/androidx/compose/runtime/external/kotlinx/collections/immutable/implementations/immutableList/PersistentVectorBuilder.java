package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010)\n\u0000\n\u0002\u0010*\n\u0000\n\u0002\u0010+\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0018\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B=\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\u001d\u0010\u001c\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u001e\u0010#\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u000b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u0016\u0010#\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u001d\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J=\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010+\u001a\u00020\u000b2\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0-H\u0002¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0002\u00100J\r\u00101\u001a\u00020\u000bH\u0000¢\u0006\u0002\b2JG\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u000206H\u0002¢\u0006\u0002\u00107J[\u00103\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010!\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0016\u00109\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010:\u001a\u00020\u000b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010<J/\u0010=\u001a\u00020 2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010>J\u001d\u0010?\u001a\u00020\u001d2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010@J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000BH\u0002J\u001e\u0010C\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070D2\u0006\u0010!\u001a\u00020\u000bH\u0002J\u000e\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000FH\u0016J\u0016\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000F2\u0006\u0010!\u001a\u00020\u000bH\u0016J'\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010HJ-\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010J\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010KJ\u0015\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010\u0012J\u001f\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010NJ5\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010!\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010PJ?\u0010Q\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000b2\u0006\u0010S\u001a\u000206H\u0002¢\u0006\u0002\u0010TJ/\u0010U\u001a\u00020 2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010VJM\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0014\u0010X\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070-H\u0002¢\u0006\u0002\u0010YJE\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0014\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0007H\u0002¢\u0006\u0002\u0010[J?\u0010\\\u001a\u00020 2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010]\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010^\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010_J?\u0010`\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010aJu\u0010b\u001a\u00020\u000b2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0d2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010e\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u000b2\u0006\u0010g\u001a\u0002062\u0014\u0010h\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070i2\u0014\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070iH\u0002¢\u0006\u0002\u0010jJ\u001c\u0010k\u001a\u00020\u001d2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0dH\u0002JA\u0010k\u001a\u00020\u000b2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0d2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010e\u001a\u00020\u000b2\u0006\u0010g\u001a\u000206H\u0002¢\u0006\u0002\u0010lJ\u0016\u0010k\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J,\u0010m\u001a\u00020\u000b2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0d2\u0006\u0010n\u001a\u00020\u000b2\u0006\u0010g\u001a\u000206H\u0002J\u001a\u0010o\u001a\u00020\u001d2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0dJ\u0015\u0010p\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000bH\u0016¢\u0006\u0002\u00100J=\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010S\u001a\u000206H\u0002¢\u0006\u0002\u0010TJ9\u0010r\u001a\u0004\u0018\u00010\b2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010sJ/\u0010t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u0018\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010KJ\b\u0010R\u001a\u00020\u000bH\u0002J\u001e\u0010u\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010vJE\u0010w\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010x\u001a\u00028\u00002\u0006\u0010y\u001a\u000206H\u0002¢\u0006\u0002\u00107JU\u0010z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010{\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0016\u00109\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010:\u001a\u00020\u000b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010|Jl\u0010}\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010!\u001a\u00020\u000b2\u000e\u0010~\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u001a\u00020\u000b2\u0016\u00109\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010:\u001a\u00020\u000b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0003\u0010\u0001J\b\u0010n\u001a\u00020\u000bH\u0002J\u0010\u0010n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R4\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007@BX\u000e¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R0\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007@BX\u000e¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", "E", "Lkotlin/collections/AbstractMutableList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList$Builder;", "vector", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "vectorRoot", "", "", "vectorTail", "rootShift", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;[Ljava/lang/Object;[Ljava/lang/Object;I)V", "ownership", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "<set-?>", "root", "getRoot$runtime_release", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "getRootShift$runtime_release", "()I", "setRootShift$runtime_release", "(I)V", "size", "getSize", "tail", "getTail$runtime_release", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "bufferFor", "(I)[Ljava/lang/Object;", "build", "copyToBuffer", "buffer", "bufferIndex", "sourceIterator", "", "([Ljava/lang/Object;ILjava/util/Iterator;)[Ljava/lang/Object;", "get", "(I)Ljava/lang/Object;", "getModCount", "getModCount$runtime_release", "insertIntoRoot", "shift", "elementCarry", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;", "([Ljava/lang/Object;IILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "rightShift", "buffers", "nullBuffers", "nextBuffer", "(Ljava/util/Collection;II[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "insertIntoTail", "([Ljava/lang/Object;ILjava/lang/Object;)V", "isMutable", "([Ljava/lang/Object;)Z", "iterator", "", "leafBufferIterator", "", "listIterator", "", "makeMutable", "([Ljava/lang/Object;)[Ljava/lang/Object;", "makeMutableShiftingRight", "distance", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "mutableBuffer", "mutableBufferWith", "(Ljava/lang/Object;)[Ljava/lang/Object;", "nullifyAfter", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "pullLastBuffer", "rootSize", "tailCarry", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "pullLastBufferFromRoot", "([Ljava/lang/Object;II)V", "pushBuffers", "buffersIterator", "([Ljava/lang/Object;IILjava/util/Iterator;)[Ljava/lang/Object;", "pushBuffersIncreasingHeightIfNeeded", "([Ljava/lang/Object;I[[Ljava/lang/Object;)[Ljava/lang/Object;", "pushFilledTail", "filledTail", "newTail", "([Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)V", "pushTail", "([Ljava/lang/Object;[Ljava/lang/Object;I)[Ljava/lang/Object;", "recyclableRemoveAll", "predicate", "Lkotlin/Function1;", "bufferSize", "toBufferSize", "bufferRef", "recyclableBuffers", "", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;Ljava/util/List;Ljava/util/List;)I", "removeAll", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)I", "removeAllFromTail", "tailSize", "removeAllWithPredicate", "removeAt", "removeFromRootAt", "removeFromTailAt", "([Ljava/lang/Object;III)Ljava/lang/Object;", "retainFirst", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "setInRoot", "e", "oldElementCarry", "shiftLeafBuffers", "startLeafIndex", "(II[[Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;", "splitToBuffers", "startBuffer", "startBufferSize", "(Ljava/util/Collection;I[Ljava/lang/Object;I[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PersistentVectorBuilder.kt */
public final class PersistentVectorBuilder<E> extends AbstractMutableList<E> implements PersistentList.Builder<E> {
    private MutabilityOwnership ownership = new MutabilityOwnership();
    private Object[] root = this.vectorRoot;
    private int rootShift;
    private int size = this.vector.size();
    private Object[] tail = this.vectorTail;
    private PersistentList<? extends E> vector;
    private Object[] vectorRoot;
    private Object[] vectorTail;

    public PersistentVectorBuilder(PersistentList<? extends E> vector2, Object[] vectorRoot2, Object[] vectorTail2, int rootShift2) {
        Intrinsics.checkNotNullParameter(vector2, "vector");
        Intrinsics.checkNotNullParameter(vectorTail2, "vectorTail");
        this.vector = vector2;
        this.vectorRoot = vectorRoot2;
        this.vectorTail = vectorTail2;
        this.rootShift = rootShift2;
    }

    public final int getRootShift$runtime_release() {
        return this.rootShift;
    }

    public final void setRootShift$runtime_release(int i) {
        this.rootShift = i;
    }

    public final Object[] getRoot$runtime_release() {
        return this.root;
    }

    public final Object[] getTail$runtime_release() {
        return this.tail;
    }

    public int getSize() {
        return this.size;
    }

    public final int getModCount$runtime_release() {
        return this.modCount;
    }

    public PersistentList<E> build() {
        PersistentList<? extends E> persistentList;
        if (this.root == this.vectorRoot && this.tail == this.vectorTail) {
            persistentList = this.vector;
        } else {
            this.ownership = new MutabilityOwnership();
            Object[] objArr = this.root;
            this.vectorRoot = objArr;
            Object[] objArr2 = this.tail;
            this.vectorTail = objArr2;
            if (objArr == null) {
                if (objArr2.length == 0) {
                    persistentList = UtilsKt.persistentVectorOf();
                } else {
                    Object[] copyOf = Arrays.copyOf(this.tail, size());
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                    persistentList = new SmallPersistentVector<>(copyOf);
                }
            } else {
                Object[] objArr3 = this.root;
                Intrinsics.checkNotNull(objArr3);
                persistentList = new PersistentVector<>(objArr3, this.tail, size(), this.rootShift);
            }
        }
        this.vector = persistentList;
        return persistentList;
    }

    private final int rootSize() {
        if (size() <= 32) {
            return 0;
        }
        return UtilsKt.rootSize(size());
    }

    private final int tailSize(int size2) {
        if (size2 <= 32) {
            return size2;
        }
        return size2 - UtilsKt.rootSize(size2);
    }

    private final int tailSize() {
        return tailSize(size());
    }

    private final boolean isMutable(Object[] buffer) {
        return buffer.length == 33 && buffer[32] == this.ownership;
    }

    private final Object[] makeMutable(Object[] buffer) {
        if (buffer == null) {
            return mutableBuffer();
        }
        if (isMutable(buffer)) {
            return buffer;
        }
        return ArraysKt.copyInto$default(buffer, mutableBuffer(), 0, 0, RangesKt.coerceAtMost(buffer.length, 32), 6, (Object) null);
    }

    private final Object[] makeMutableShiftingRight(Object[] buffer, int distance) {
        if (isMutable(buffer)) {
            return ArraysKt.copyInto((T[]) buffer, (T[]) buffer, distance, 0, 32 - distance);
        }
        return ArraysKt.copyInto((T[]) buffer, (T[]) mutableBuffer(), distance, 0, 32 - distance);
    }

    private final Object[] mutableBufferWith(Object element) {
        Object[] buffer = new Object[33];
        buffer[0] = element;
        buffer[32] = this.ownership;
        return buffer;
    }

    private final Object[] mutableBuffer() {
        Object[] buffer = new Object[33];
        buffer[32] = this.ownership;
        return buffer;
    }

    public boolean add(E element) {
        this.modCount++;
        int tailSize = tailSize();
        if (tailSize < 32) {
            Object[] mutableTail = makeMutable(this.tail);
            mutableTail[tailSize] = element;
            this.tail = mutableTail;
            this.size = size() + 1;
        } else {
            pushFilledTail(this.root, this.tail, mutableBufferWith(element));
        }
        return true;
    }

    private final void pushFilledTail(Object[] root2, Object[] filledTail, Object[] newTail) {
        int size2 = size() >> 5;
        int i = this.rootShift;
        if (size2 > (1 << i)) {
            this.root = pushTail(mutableBufferWith(root2), filledTail, this.rootShift + 5);
            this.tail = newTail;
            this.rootShift += 5;
            this.size = size() + 1;
        } else if (root2 == null) {
            this.root = filledTail;
            this.tail = newTail;
            this.size = size() + 1;
        } else {
            this.root = pushTail(root2, filledTail, i);
            this.tail = newTail;
            this.size = size() + 1;
        }
    }

    private final Object[] pushTail(Object[] root2, Object[] tail2, int shift) {
        int index = UtilsKt.indexSegment(size() - 1, shift);
        Object[] mutableRoot = makeMutable(root2);
        if (shift == 5) {
            mutableRoot[index] = tail2;
        } else {
            mutableRoot[index] = pushTail((Object[]) mutableRoot[index], tail2, shift - 5);
        }
        return mutableRoot;
    }

    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        this.modCount++;
        int tailSize = tailSize();
        Iterator elementsIterator = elements.iterator();
        if (32 - tailSize >= elements.size()) {
            this.tail = copyToBuffer(makeMutable(this.tail), tailSize, elementsIterator);
            this.size = size() + elements.size();
        } else {
            int buffersSize = ((elements.size() + tailSize) - 1) / 32;
            Object[][] buffers = new Object[buffersSize][];
            buffers[0] = copyToBuffer(makeMutable(this.tail), tailSize, elementsIterator);
            for (int index = 1; index < buffersSize; index++) {
                buffers[index] = copyToBuffer(mutableBuffer(), 0, elementsIterator);
            }
            this.root = pushBuffersIncreasingHeightIfNeeded(this.root, rootSize(), buffers);
            this.tail = copyToBuffer(mutableBuffer(), 0, elementsIterator);
            this.size = size() + elements.size();
        }
        return true;
    }

    private final Object[] copyToBuffer(Object[] buffer, int bufferIndex, Iterator<? extends Object> sourceIterator) {
        for (int index = bufferIndex; index < 32 && sourceIterator.hasNext(); index++) {
            buffer[index] = sourceIterator.next();
        }
        return buffer;
    }

    private final Object[] pushBuffersIncreasingHeightIfNeeded(Object[] root2, int rootSize, Object[][] buffers) {
        Object[] mutableRoot;
        Iterator buffersIterator = ArrayIteratorKt.iterator((Object[]) buffers);
        int i = rootSize >> 5;
        int i2 = this.rootShift;
        if (i < (1 << i2)) {
            mutableRoot = pushBuffers(root2, rootSize, i2, buffersIterator);
        } else {
            mutableRoot = makeMutable(root2);
        }
        while (buffersIterator.hasNext()) {
            this.rootShift += 5;
            mutableRoot = mutableBufferWith(mutableRoot);
            int i3 = this.rootShift;
            pushBuffers(mutableRoot, 1 << i3, i3, buffersIterator);
        }
        return mutableRoot;
    }

    private final Object[] pushBuffers(Object[] root2, int rootSize, int shift, Iterator<Object[]> buffersIterator) {
        if (buffersIterator.hasNext()) {
            if (!(shift >= 0)) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (shift == 0) {
                return buffersIterator.next();
            } else {
                Object[] mutableRoot = makeMutable(root2);
                int index = UtilsKt.indexSegment(rootSize, shift);
                mutableRoot[index] = pushBuffers((Object[]) mutableRoot[index], rootSize, shift - 5, buffersIterator);
                while (true) {
                    index++;
                    if (index >= 32 || !buffersIterator.hasNext()) {
                        return mutableRoot;
                    }
                    mutableRoot[index] = pushBuffers((Object[]) mutableRoot[index], 0, shift - 5, buffersIterator);
                }
                return mutableRoot;
            }
        } else {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public void add(int index, E element) {
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        if (index == size()) {
            add(element);
            return;
        }
        this.modCount++;
        int rootSize = rootSize();
        if (index >= rootSize) {
            insertIntoTail(this.root, index - rootSize, element);
            return;
        }
        ObjectRef elementCarry = new ObjectRef((Object) null);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        insertIntoTail(insertIntoRoot(objArr, this.rootShift, index, element, elementCarry), 0, elementCarry.getValue());
    }

    private final void insertIntoTail(Object[] root2, int index, E element) {
        int tailSize = tailSize();
        Object[] mutableTail = makeMutable(this.tail);
        if (tailSize < 32) {
            ArraysKt.copyInto((T[]) this.tail, (T[]) mutableTail, index + 1, index, tailSize);
            mutableTail[index] = element;
            this.root = root2;
            this.tail = mutableTail;
            this.size = size() + 1;
            return;
        }
        Object[] objArr = this.tail;
        Object lastElement = objArr[31];
        ArraysKt.copyInto((T[]) objArr, (T[]) mutableTail, index + 1, index, 31);
        mutableTail[index] = element;
        pushFilledTail(root2, mutableTail, mutableBufferWith(lastElement));
    }

    private final Object[] insertIntoRoot(Object[] root2, int shift, int index, Object element, ObjectRef elementCarry) {
        Object[] objArr = root2;
        int i = shift;
        int bufferIndex = UtilsKt.indexSegment(index, i);
        if (i == 0) {
            elementCarry.setValue(objArr[31]);
            Object[] mutableRoot = ArraysKt.copyInto((T[]) objArr, (T[]) makeMutable(root2), bufferIndex + 1, bufferIndex, 31);
            mutableRoot[bufferIndex] = element;
            return mutableRoot;
        }
        ObjectRef objectRef = elementCarry;
        Object[] mutableRoot2 = makeMutable(root2);
        int lowerLevelShift = i - 5;
        Object obj = mutableRoot2[bufferIndex];
        String str = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>";
        Intrinsics.checkNotNull(obj, str);
        mutableRoot2[bufferIndex] = insertIntoRoot((Object[]) obj, lowerLevelShift, index, element, elementCarry);
        int i2 = bufferIndex + 1;
        while (i2 < 32 && mutableRoot2[i2] != null) {
            Object obj2 = mutableRoot2[i2];
            Intrinsics.checkNotNull(obj2, str);
            mutableRoot2[i2] = insertIntoRoot((Object[]) obj2, lowerLevelShift, 0, elementCarry.getValue(), elementCarry);
            i2++;
            str = str;
        }
        return mutableRoot2;
    }

    public boolean addAll(int index, Collection<? extends E> elements) {
        Object[] newTail;
        int i = index;
        Collection<? extends E> collection = elements;
        Intrinsics.checkNotNullParameter(collection, "elements");
        ListImplementation.checkPositionIndex$runtime_release(i, size());
        if (i == size()) {
            return addAll(collection);
        }
        boolean z = false;
        if (elements.isEmpty()) {
            return false;
        }
        this.modCount++;
        int unaffectedElementsCount = (i >> 5) << 5;
        int buffersSize = (((size() - unaffectedElementsCount) + elements.size()) - 1) / 32;
        if (buffersSize == 0) {
            if (i >= rootSize()) {
                z = true;
            }
            CommonFunctionsKt.m2802assert(z);
            int startIndex = i & 31;
            Object[] objArr = this.tail;
            Object[] newTail2 = ArraysKt.copyInto((T[]) objArr, (T[]) makeMutable(objArr), (((elements.size() + i) - 1) & 31) + 1, startIndex, tailSize());
            copyToBuffer(newTail2, startIndex, elements.iterator());
            this.tail = newTail2;
            this.size = size() + elements.size();
            return true;
        }
        Object[][] buffers = new Object[buffersSize][];
        int tailSize = tailSize();
        int newTailSize = tailSize(size() + elements.size());
        if (i >= rootSize()) {
            Object[] newTail3 = mutableBuffer();
            int i2 = newTailSize;
            splitToBuffers(elements, index, this.tail, tailSize, buffers, buffersSize, newTail3);
            newTail = newTail3;
        } else {
            int newTailSize2 = newTailSize;
            if (newTailSize2 > tailSize) {
                int rightShift = newTailSize2 - tailSize;
                Object[] newTail4 = makeMutableShiftingRight(this.tail, rightShift);
                insertIntoRoot(elements, index, rightShift, buffers, buffersSize, newTail4);
                newTail = newTail4;
            } else {
                Object[] newTail5 = ArraysKt.copyInto((T[]) this.tail, (T[]) mutableBuffer(), 0, tailSize - newTailSize2, tailSize);
                int rightShift2 = 32 - (tailSize - newTailSize2);
                Object[] lastBuffer = makeMutableShiftingRight(this.tail, rightShift2);
                buffers[buffersSize - 1] = lastBuffer;
                insertIntoRoot(elements, index, rightShift2, buffers, buffersSize - 1, lastBuffer);
                newTail = newTail5;
            }
        }
        this.root = pushBuffersIncreasingHeightIfNeeded(this.root, unaffectedElementsCount, buffers);
        this.tail = newTail;
        this.size = size() + elements.size();
        return true;
    }

    private final void insertIntoRoot(Collection<? extends E> elements, int index, int rightShift, Object[][] buffers, int nullBuffers, Object[] nextBuffer) {
        Object[] newNextBuffer;
        int i = nullBuffers;
        if (this.root != null) {
            int startLeafIndex = index >> 5;
            Object[] startLeaf = shiftLeafBuffers(startLeafIndex, rightShift, buffers, nullBuffers, nextBuffer);
            int newNullBuffers = i - (((rootSize() >> 5) - 1) - startLeafIndex);
            if (newNullBuffers < i) {
                Object[] objArr = buffers[newNullBuffers];
                Intrinsics.checkNotNull(objArr);
                newNextBuffer = objArr;
            } else {
                newNextBuffer = nextBuffer;
            }
            splitToBuffers(elements, index, startLeaf, 32, buffers, newNullBuffers, newNextBuffer);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final Object[] shiftLeafBuffers(int startLeafIndex, int rightShift, Object[][] buffers, int nullBuffers, Object[] nextBuffer) {
        if (this.root != null) {
            ListIterator leafBufferIterator = leafBufferIterator(rootSize() >> 5);
            int bufferIndex = nullBuffers;
            Object[] buffer = nextBuffer;
            while (leafBufferIterator.previousIndex() != startLeafIndex) {
                Object[] currentBuffer = leafBufferIterator.previous();
                ArraysKt.copyInto((T[]) currentBuffer, (T[]) buffer, 0, 32 - rightShift, 32);
                buffer = makeMutableShiftingRight(currentBuffer, rightShift);
                bufferIndex--;
                buffers[bufferIndex] = buffer;
            }
            return leafBufferIterator.previous();
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final void splitToBuffers(Collection<? extends E> elements, int index, Object[] startBuffer, int startBufferSize, Object[][] buffers, int nullBuffers, Object[] nextBuffer) {
        int i = startBufferSize;
        int i2 = nullBuffers;
        if (i2 >= 1) {
            Object[] firstBuffer = makeMutable(startBuffer);
            buffers[0] = firstBuffer;
            Object[] newNextBuffer = nextBuffer;
            int newNullBuffers = nullBuffers;
            int startBufferStartIndex = index & 31;
            int endBufferEndIndex = ((index + elements.size()) - 1) & 31;
            int elementsToShift = i - startBufferStartIndex;
            if (endBufferEndIndex + elementsToShift < 32) {
                ArraysKt.copyInto((T[]) firstBuffer, (T[]) newNextBuffer, endBufferEndIndex + 1, startBufferStartIndex, i);
                Object[] objArr = nextBuffer;
            } else {
                int toCopyToLast = ((endBufferEndIndex + elementsToShift) - 32) + 1;
                if (i2 == 1) {
                    newNextBuffer = firstBuffer;
                } else {
                    Object[] newNextBuffer2 = mutableBuffer();
                    newNullBuffers--;
                    buffers[newNullBuffers] = newNextBuffer2;
                    newNextBuffer = newNextBuffer2;
                }
                ArraysKt.copyInto((T[]) firstBuffer, (T[]) nextBuffer, 0, i - toCopyToLast, i);
                ArraysKt.copyInto((T[]) firstBuffer, (T[]) newNextBuffer, endBufferEndIndex + 1, startBufferStartIndex, i - toCopyToLast);
            }
            Iterator elementsIterator = elements.iterator();
            copyToBuffer(firstBuffer, startBufferStartIndex, elementsIterator);
            for (int i3 = 1; i3 < newNullBuffers; i3++) {
                buffers[i3] = copyToBuffer(mutableBuffer(), 0, elementsIterator);
            }
            copyToBuffer(newNextBuffer, 0, elementsIterator);
            return;
        }
        Object[] objArr2 = startBuffer;
        Object[] objArr3 = nextBuffer;
        throw new IllegalStateException("Check failed.".toString());
    }

    public E get(int index) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        return bufferFor(index)[index & 31];
    }

    private final Object[] bufferFor(int index) {
        if (rootSize() <= index) {
            return this.tail;
        }
        Object[] buffer = this.root;
        Intrinsics.checkNotNull(buffer);
        for (int shift = this.rootShift; shift > 0; shift -= 5) {
            Object[] buffer2 = buffer[UtilsKt.indexSegment(index, shift)];
            Intrinsics.checkNotNull(buffer2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            buffer = buffer2;
        }
        return buffer;
    }

    public E removeAt(int index) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        this.modCount++;
        int rootSize = rootSize();
        if (index >= rootSize) {
            return removeFromTailAt(this.root, rootSize, this.rootShift, index - rootSize);
        }
        ObjectRef elementCarry = new ObjectRef(this.tail[0]);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        removeFromTailAt(removeFromRootAt(objArr, this.rootShift, index, elementCarry), rootSize, this.rootShift, 0);
        return elementCarry.getValue();
    }

    private final Object removeFromTailAt(Object[] root2, int rootSize, int shift, int index) {
        int tailSize = size() - rootSize;
        CommonFunctionsKt.m2802assert(index < tailSize);
        if (tailSize == 1) {
            Object removedElement = this.tail[0];
            pullLastBufferFromRoot(root2, rootSize, shift);
            return removedElement;
        }
        Object[] objArr = this.tail;
        Object removedElement2 = objArr[index];
        Object[] mutableTail = ArraysKt.copyInto((T[]) objArr, (T[]) makeMutable(objArr), index, index + 1, tailSize);
        mutableTail[tailSize - 1] = null;
        this.root = root2;
        this.tail = mutableTail;
        this.size = (rootSize + tailSize) - 1;
        this.rootShift = shift;
        return removedElement2;
    }

    private final Object[] removeFromRootAt(Object[] root2, int shift, int index, ObjectRef tailCarry) {
        int bufferIndex = UtilsKt.indexSegment(index, shift);
        if (shift == 0) {
            Object removedElement = root2[bufferIndex];
            Object[] mutableRoot = ArraysKt.copyInto((T[]) root2, (T[]) makeMutable(root2), bufferIndex, bufferIndex + 1, 32);
            mutableRoot[31] = tailCarry.getValue();
            tailCarry.setValue(removedElement);
            return mutableRoot;
        }
        int bufferLastIndex = 31;
        if (root2[31] == null) {
            bufferLastIndex = UtilsKt.indexSegment(rootSize() - 1, shift);
        }
        Object[] mutableRoot2 = makeMutable(root2);
        int lowerLevelShift = shift - 5;
        int i = bufferLastIndex;
        int i2 = bufferIndex + 1;
        if (i2 <= i) {
            while (true) {
                Object obj = mutableRoot2[i];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                mutableRoot2[i] = removeFromRootAt((Object[]) obj, lowerLevelShift, 0, tailCarry);
                if (i == i2) {
                    break;
                }
                i--;
            }
        }
        Object obj2 = mutableRoot2[bufferIndex];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        mutableRoot2[bufferIndex] = removeFromRootAt((Object[]) obj2, lowerLevelShift, index, tailCarry);
        return mutableRoot2;
    }

    private final void pullLastBufferFromRoot(Object[] root2, int rootSize, int shift) {
        Object[] objArr;
        if (shift == 0) {
            this.root = null;
            if (root2 == null) {
                objArr = new Object[0];
            } else {
                objArr = root2;
            }
            this.tail = objArr;
            this.size = rootSize;
            this.rootShift = shift;
            return;
        }
        ObjectRef tailCarry = new ObjectRef((Object) null);
        Intrinsics.checkNotNull(root2);
        Object[] newRoot = pullLastBuffer(root2, shift, rootSize, tailCarry);
        Intrinsics.checkNotNull(newRoot);
        Object value = tailCarry.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        this.tail = (Object[]) value;
        this.size = rootSize;
        if (newRoot[1] == null) {
            this.root = (Object[]) newRoot[0];
            this.rootShift = shift - 5;
            return;
        }
        this.root = newRoot;
        this.rootShift = shift;
    }

    private final Object[] pullLastBuffer(Object[] root2, int shift, int rootSize, ObjectRef tailCarry) {
        Object[] newBufferAtIndex;
        int bufferIndex = UtilsKt.indexSegment(rootSize - 1, shift);
        if (shift == 5) {
            tailCarry.setValue(root2[bufferIndex]);
            newBufferAtIndex = null;
        } else {
            Object[] objArr = root2[bufferIndex];
            Intrinsics.checkNotNull(objArr, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            newBufferAtIndex = pullLastBuffer(objArr, shift - 5, rootSize, tailCarry);
        }
        if (newBufferAtIndex == null && bufferIndex == 0) {
            return null;
        }
        Object[] mutableRoot = makeMutable(root2);
        mutableRoot[bufferIndex] = newBufferAtIndex;
        return mutableRoot;
    }

    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return removeAllWithPredicate(new PersistentVectorBuilder$removeAll$1(elements));
    }

    public final boolean removeAllWithPredicate(Function1<? super E, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean anyRemoved = removeAll(predicate);
        if (anyRemoved) {
            this.modCount++;
        }
        return anyRemoved;
    }

    private final boolean removeAll(Function1<? super E, Boolean> predicate) {
        Object[] newRoot;
        Function1<? super E, Boolean> function1 = predicate;
        int tailSize = tailSize();
        ObjectRef bufferRef = new ObjectRef((Object) null);
        if (this.root != null) {
            ListIterator leafIterator = leafBufferIterator(0);
            int bufferSize = 32;
            while (bufferSize == 32 && leafIterator.hasNext()) {
                bufferSize = removeAll(function1, leafIterator.next(), 32, bufferRef);
            }
            if (bufferSize == 32) {
                CommonFunctionsKt.m2802assert(!leafIterator.hasNext());
                int newTailSize = removeAllFromTail(function1, tailSize, bufferRef);
                if (newTailSize == 0) {
                    pullLastBufferFromRoot(this.root, size(), this.rootShift);
                }
                if (newTailSize != tailSize) {
                    return true;
                }
                return false;
            }
            int unaffectedElementsCount = leafIterator.previousIndex() << 5;
            List buffers = new ArrayList();
            List recyclableBuffers = new ArrayList();
            int bufferSize2 = bufferSize;
            while (leafIterator.hasNext() != 0) {
                bufferSize2 = recyclableRemoveAll(predicate, leafIterator.next(), 32, bufferSize2, bufferRef, recyclableBuffers, buffers);
                unaffectedElementsCount = unaffectedElementsCount;
            }
            int unaffectedElementsCount2 = unaffectedElementsCount;
            int newTailSize2 = recyclableRemoveAll(predicate, this.tail, tailSize, bufferSize2, bufferRef, recyclableBuffers, buffers);
            Object value = bufferRef.getValue();
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            Object[] newTail = (Object[]) value;
            ArraysKt.fill((T[]) newTail, null, newTailSize2, 32);
            if (buffers.isEmpty()) {
                newRoot = this.root;
                Intrinsics.checkNotNull(newRoot);
            } else {
                newRoot = pushBuffers(this.root, unaffectedElementsCount2, this.rootShift, buffers.iterator());
            }
            int newRootSize = unaffectedElementsCount2 + (buffers.size() << 5);
            this.root = retainFirst(newRoot, newRootSize);
            this.tail = newTail;
            this.size = newRootSize + newTailSize2;
            return true;
        } else if (removeAllFromTail(function1, tailSize, bufferRef) != tailSize) {
            return true;
        } else {
            return false;
        }
    }

    private final Object[] retainFirst(Object[] root2, int size2) {
        if (!((size2 & 31) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (size2 == 0) {
            this.rootShift = 0;
            return null;
        } else {
            int lastIndex = size2 - 1;
            Object[] newRoot = root2;
            while (true) {
                int i = this.rootShift;
                if ((lastIndex >> i) != 0) {
                    return nullifyAfter(newRoot, lastIndex, i);
                }
                this.rootShift = i - 5;
                Object[] newRoot2 = newRoot[0];
                Intrinsics.checkNotNull(newRoot2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                newRoot = newRoot2;
            }
        }
    }

    private final Object[] nullifyAfter(Object[] root2, int index, int shift) {
        if (!(shift >= 0)) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (shift == 0) {
            return root2;
        } else {
            int lastIndex = UtilsKt.indexSegment(index, shift);
            Object[] objArr = root2[lastIndex];
            Intrinsics.checkNotNull(objArr, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            Object nullifyAfter = nullifyAfter(objArr, index, shift - 5);
            Object[] newRoot = root2;
            if (lastIndex < 31 && newRoot[lastIndex + 1] != null) {
                if (isMutable(newRoot)) {
                    ArraysKt.fill((T[]) newRoot, null, lastIndex + 1, 32);
                }
                newRoot = ArraysKt.copyInto((T[]) newRoot, (T[]) mutableBuffer(), 0, 0, lastIndex + 1);
            }
            if (nullifyAfter == newRoot[lastIndex]) {
                return newRoot;
            }
            Object[] newRoot2 = makeMutable(newRoot);
            newRoot2[lastIndex] = nullifyAfter;
            return newRoot2;
        }
    }

    private final int removeAllFromTail(Function1<? super E, Boolean> predicate, int tailSize, ObjectRef bufferRef) {
        int newTailSize = removeAll(predicate, this.tail, tailSize, bufferRef);
        if (newTailSize == tailSize) {
            CommonFunctionsKt.m2802assert(bufferRef.getValue() == this.tail);
            return tailSize;
        }
        Object value = bufferRef.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] newTail = (Object[]) value;
        ArraysKt.fill((T[]) newTail, null, newTailSize, tailSize);
        this.tail = newTail;
        this.size = size() - (tailSize - newTailSize);
        return newTailSize;
    }

    private final int removeAll(Function1<? super E, Boolean> predicate, Object[] buffer, int bufferSize, ObjectRef bufferRef) {
        Object[] newBuffer = buffer;
        int newBufferSize = bufferSize;
        boolean anyRemoved = false;
        for (int index = 0; index < bufferSize; index++) {
            Object element = buffer[index];
            if (predicate.invoke(element).booleanValue()) {
                if (!anyRemoved) {
                    newBuffer = makeMutable(buffer);
                    newBufferSize = index;
                    anyRemoved = true;
                }
            } else if (anyRemoved) {
                newBuffer[newBufferSize] = element;
                newBufferSize++;
            }
        }
        bufferRef.setValue(newBuffer);
        return newBufferSize;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Object} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int recyclableRemoveAll(kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r7, java.lang.Object[] r8, int r9, int r10, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef r11, java.util.List<java.lang.Object[]> r12, java.util.List<java.lang.Object[]> r13) {
        /*
            r6 = this;
            boolean r0 = r6.isMutable(r8)
            if (r0 == 0) goto L_0x0009
            r12.add(r8)
        L_0x0009:
            java.lang.Object r0 = r11.getValue()
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r1 = r0
            r2 = r10
            r3 = 0
        L_0x0018:
            if (r3 >= r9) goto L_0x0052
            r4 = r8[r3]
            java.lang.Object r5 = r7.invoke(r4)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x004f
            r5 = 32
            if (r2 != r5) goto L_0x004a
            r5 = r12
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ 1
            if (r5 == 0) goto L_0x0044
            int r5 = r12.size()
            int r5 = r5 + -1
            java.lang.Object r5 = r12.remove(r5)
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            goto L_0x0048
        L_0x0044:
            java.lang.Object[] r5 = r6.mutableBuffer()
        L_0x0048:
            r1 = r5
            r2 = 0
        L_0x004a:
            int r5 = r2 + 1
            r1[r2] = r4
            r2 = r5
        L_0x004f:
            int r3 = r3 + 1
            goto L_0x0018
        L_0x0052:
            r11.setValue(r1)
            java.lang.Object r3 = r11.getValue()
            if (r0 == r3) goto L_0x005e
            r13.add(r0)
        L_0x005e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder.recyclableRemoveAll(kotlin.jvm.functions.Function1, java.lang.Object[], int, int, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef, java.util.List, java.util.List):int");
    }

    public E set(int index, E element) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        if (rootSize() <= index) {
            Object[] mutableTail = makeMutable(this.tail);
            if (mutableTail != this.tail) {
                this.modCount++;
            }
            int tailIndex = index & 31;
            Object oldElement = mutableTail[tailIndex];
            mutableTail[tailIndex] = element;
            this.tail = mutableTail;
            return oldElement;
        }
        ObjectRef oldElementCarry = new ObjectRef((Object) null);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        this.root = setInRoot(objArr, this.rootShift, index, element, oldElementCarry);
        return oldElementCarry.getValue();
    }

    private final Object[] setInRoot(Object[] root2, int shift, int index, E e, ObjectRef oldElementCarry) {
        int bufferIndex = UtilsKt.indexSegment(index, shift);
        Object[] mutableRoot = makeMutable(root2);
        if (shift == 0) {
            if (mutableRoot != root2) {
                this.modCount++;
            }
            oldElementCarry.setValue(mutableRoot[bufferIndex]);
            mutableRoot[bufferIndex] = e;
            return mutableRoot;
        }
        Object obj = mutableRoot[bufferIndex];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        mutableRoot[bufferIndex] = setInRoot((Object[]) obj, shift - 5, index, e, oldElementCarry);
        return mutableRoot;
    }

    public Iterator<E> iterator() {
        return listIterator();
    }

    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public ListIterator<E> listIterator(int index) {
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        return new PersistentVectorMutableIterator<>(this, index);
    }

    private final ListIterator<Object[]> leafBufferIterator(int index) {
        if (this.root != null) {
            int leafCount = rootSize() >> 5;
            ListImplementation.checkPositionIndex$runtime_release(index, leafCount);
            int i = this.rootShift;
            if (i == 0) {
                Object[] objArr = this.root;
                Intrinsics.checkNotNull(objArr);
                return new SingleElementListIterator<>(objArr, index);
            }
            Object[] objArr2 = this.root;
            Intrinsics.checkNotNull(objArr2);
            return new TrieIterator<>(objArr2, index, leafCount, i / 5);
        }
        throw new IllegalStateException("Required value was null.".toString());
    }
}
