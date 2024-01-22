package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.UtilsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\u0010%\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aQ\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a-\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0001¢\u0006\u0002\u0010\f\u001a\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\nH\u0001\u001a-\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0001¢\u0006\u0002\u0010\u000f\u001aQ\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\nH\u0001\u001a-\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0001¢\u0006\u0002\u0010\f\u001a \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0000\u001aQ\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\u0000¢\u0006\u0002\u0010\u0007\u001a\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\nH\u0000\u001a-\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0000¢\u0006\u0002\u0010\f\u001a\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\nH\u0000\u001a-\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0000¢\u0006\u0002\u0010\u000f\u001a \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0000\u001aQ\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\u0000¢\u0006\u0002\u0010\u0007\u001a\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\nH\u0000\u001a-\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0000¢\u0006\u0002\u0010\f\u001a-\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0004\u001a-\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0004\u001a,\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\u0006\u0010\u001b\u001a\u0002H\nH\n¢\u0006\u0002\u0010\u001c\u001a4\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005H\u0002¢\u0006\u0002\u0010\u001d\u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0002\u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001eH\u0002\u001a,\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\u0006\u0010\u001b\u001a\u0002H\nH\n¢\u0006\u0002\u0010\u001f\u001a4\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005H\u0002¢\u0006\u0002\u0010 \u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0002\u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001eH\u0002\u001a@\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010!\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u0010\"\u001aH\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u000e\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005H\u0002¢\u0006\u0002\u0010$\u001aA\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0019H\u0002\u001aA\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001eH\u0002\u001a,\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\u0006\u0010\u001b\u001a\u0002H\nH\n¢\u0006\u0002\u0010%\u001a4\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005H\u0002¢\u0006\u0002\u0010&\u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0002\u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001eH\u0002\u001a<\u0010'\u001a\b\u0012\u0004\u0012\u0002H(0\u000e\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u000e2\u0018\u0010)\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H(0+\u0012\u0004\u0012\u00020,0*H\bø\u0001\u0000\u001aV\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030-\u0012\u0004\u0012\u00020,0*H\bø\u0001\u0000\u001a<\u0010'\u001a\b\u0012\u0004\u0012\u0002H(0\t\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\t2\u0018\u0010)\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H(0.\u0012\u0004\u0012\u00020,0*H\bø\u0001\u0000\u001a,\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\u0006\u0010\u001b\u001a\u0002H\nH\n¢\u0006\u0002\u0010\u001c\u001a4\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005H\u0002¢\u0006\u0002\u0010\u001d\u001a-\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0002\u001a-\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001eH\u0002\u001a,\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\u0006\u0010\u001b\u001a\u0002H\nH\n¢\u0006\u0002\u0010\u001f\u001a4\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005H\u0002¢\u0006\u0002\u0010 \u001a-\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0002\u001a-\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001eH\u0002\u001aT\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001a\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005H\n¢\u0006\u0002\u00100\u001aG\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\n\u001aM\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0019H\n\u001aI\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0014\u00102\u001a\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\n\u001aM\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u001eH\n\u001a,\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\u0006\u0010\u001b\u001a\u0002H\nH\n¢\u0006\u0002\u0010%\u001a4\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005H\u0002¢\u0006\u0002\u0010&\u001a-\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0002\u001a-\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001eH\u0002\u001aS\u00104\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001a\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005H\u0000¢\u0006\u0002\u00100\u001aL\u00104\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0019H\u0000\u001aH\u00104\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0014\u00102\u001a\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0000\u001aL\u00104\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u001eH\u0000\u001a\u0012\u00105\u001a\b\u0012\u0004\u0012\u00020706*\u000208H\u0000\u001a\u001e\u00105\u001a\b\u0012\u0004\u0012\u0002H(06\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u00105\u001a\b\u0012\u0004\u0012\u0002H(06\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u001eH\u0000\u001a0\u00109\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030:\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0000\u001a\u0012\u0010;\u001a\b\u0012\u0004\u0012\u0002070\t*\u000208H\u0000\u001a\u001e\u0010;\u001a\b\u0012\u0004\u0012\u0002H(0<\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u0010;\u001a\b\u0012\u0004\u0012\u0002H(0<\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u001eH\u0000\u001a0\u0010=\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0000\u001a\u0012\u0010>\u001a\b\u0012\u0004\u0012\u0002070\t*\u000208H\u0000\u001a\u001e\u0010>\u001a\b\u0012\u0004\u0012\u0002H(0\t\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u0010>\u001a\b\u0012\u0004\u0012\u0002H(0\t\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u001eH\u0000\u001a\u0012\u0010?\u001a\b\u0012\u0004\u0012\u0002070\u000e*\u000208H\u0000\u001a\u001e\u0010?\u001a\b\u0012\u0004\u0012\u0002H(0\u000e\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u0010?\u001a\b\u0012\u0004\u0012\u0002H(0\u000e\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u001eH\u0000\u001a0\u0010@\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0000\u001a\u0012\u0010A\u001a\b\u0012\u0004\u0012\u0002070\t*\u000208H\u0000\u001a\u001e\u0010A\u001a\b\u0012\u0004\u0012\u0002H(0\t\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u0010A\u001a\b\u0012\u0004\u0012\u0002H(0\t\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u001eH\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006B"}, d2 = {"immutableHashMapOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "K", "V", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "immutableHashSetOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "E", "elements", "([Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "immutableListOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "([Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "immutableMapOf", "immutableSetOf", "persistentHashMapOf", "persistentHashSetOf", "persistentListOf", "persistentMapOf", "persistentSetOf", "intersect", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "", "minus", "element", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "Lkotlin/sequences/Sequence;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "key", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "keys", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "mutate", "T", "mutator", "Lkotlin/Function1;", "", "", "", "", "plus", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;[Lkotlin/Pair;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "pair", "map", "", "putAll", "toImmutableList", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "", "", "toImmutableMap", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableMap;", "toImmutableSet", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "toPersistentHashMap", "toPersistentHashSet", "toPersistentList", "toPersistentMap", "toPersistentSet", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: extensions.kt */
public final class ExtensionsKt {
    public static final <T> PersistentSet<T> mutate(PersistentSet<? extends T> $this$mutate, Function1<? super Set<T>, Unit> mutator) {
        Intrinsics.checkNotNullParameter($this$mutate, "<this>");
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        PersistentSet.Builder<? extends T> builder = $this$mutate.builder();
        mutator.invoke(builder);
        return builder.build();
    }

    public static final <T> PersistentList<T> mutate(PersistentList<? extends T> $this$mutate, Function1<? super List<T>, Unit> mutator) {
        Intrinsics.checkNotNullParameter($this$mutate, "<this>");
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        PersistentList.Builder<? extends T> builder = $this$mutate.builder();
        mutator.invoke(builder);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> mutate(PersistentMap<? extends K, ? extends V> $this$mutate, Function1<? super Map<K, V>, Unit> mutator) {
        Intrinsics.checkNotNullParameter($this$mutate, "<this>");
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        PersistentMap.Builder<? extends K, ? extends V> builder = $this$mutate.builder();
        mutator.invoke(builder);
        return builder.build();
    }

    public static final <E> PersistentCollection<E> plus(PersistentCollection<? extends E> $this$plus, E element) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        return $this$plus.add(element);
    }

    public static final <E> PersistentCollection<E> minus(PersistentCollection<? extends E> $this$minus, E element) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        return $this$minus.remove(element);
    }

    public static final <E> PersistentCollection<E> plus(PersistentCollection<? extends E> $this$plus, Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return $this$plus.addAll((Collection) elements);
        }
        PersistentCollection.Builder it = $this$plus.builder();
        CollectionsKt.addAll(it, elements);
        return it.build();
    }

    public static final <E> PersistentCollection<E> plus(PersistentCollection<? extends E> $this$plus, E[] elements) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentCollection.Builder it = $this$plus.builder();
        CollectionsKt.addAll(it, (T[]) elements);
        return it.build();
    }

    public static final <E> PersistentCollection<E> plus(PersistentCollection<? extends E> $this$plus, Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentCollection.Builder it = $this$plus.builder();
        CollectionsKt.addAll(it, elements);
        return it.build();
    }

    public static final <E> PersistentCollection<E> minus(PersistentCollection<? extends E> $this$minus, Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return $this$minus.removeAll((Collection<? extends Object>) (Collection) elements);
        }
        PersistentCollection.Builder it = $this$minus.builder();
        CollectionsKt.removeAll(it, elements);
        return it.build();
    }

    public static final <E> PersistentCollection<E> minus(PersistentCollection<? extends E> $this$minus, E[] elements) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentCollection.Builder it = $this$minus.builder();
        CollectionsKt.removeAll(it, (T[]) elements);
        return it.build();
    }

    public static final <E> PersistentCollection<E> minus(PersistentCollection<? extends E> $this$minus, Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentCollection.Builder it = $this$minus.builder();
        CollectionsKt.removeAll(it, elements);
        return it.build();
    }

    public static final <E> PersistentList<E> plus(PersistentList<? extends E> $this$plus, E element) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        return $this$plus.add(element);
    }

    public static final <E> PersistentList<E> minus(PersistentList<? extends E> $this$minus, E element) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        return $this$minus.remove(element);
    }

    public static final <E> PersistentList<E> plus(PersistentList<? extends E> $this$plus, Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return $this$plus.addAll((Collection) elements);
        }
        PersistentList.Builder<? extends E> it = $this$plus.builder();
        CollectionsKt.addAll(it, elements);
        return it.build();
    }

    public static final <E> PersistentList<E> plus(PersistentList<? extends E> $this$plus, E[] elements) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentList.Builder<? extends E> it = $this$plus.builder();
        CollectionsKt.addAll(it, (T[]) elements);
        return it.build();
    }

    public static final <E> PersistentList<E> plus(PersistentList<? extends E> $this$plus, Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentList.Builder<? extends E> it = $this$plus.builder();
        CollectionsKt.addAll(it, elements);
        return it.build();
    }

    public static final <E> PersistentList<E> minus(PersistentList<? extends E> $this$minus, Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return $this$minus.removeAll((Collection<? extends Object>) (Collection) elements);
        }
        PersistentList.Builder<? extends E> it = $this$minus.builder();
        CollectionsKt.removeAll(it, elements);
        return it.build();
    }

    public static final <E> PersistentList<E> minus(PersistentList<? extends E> $this$minus, E[] elements) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentList.Builder<? extends E> it = $this$minus.builder();
        CollectionsKt.removeAll(it, (T[]) elements);
        return it.build();
    }

    public static final <E> PersistentList<E> minus(PersistentList<? extends E> $this$minus, Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentList.Builder<? extends E> it = $this$minus.builder();
        CollectionsKt.removeAll(it, elements);
        return it.build();
    }

    public static final <E> PersistentSet<E> plus(PersistentSet<? extends E> $this$plus, E element) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        return $this$plus.add(element);
    }

    public static final <E> PersistentSet<E> minus(PersistentSet<? extends E> $this$minus, E element) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        return $this$minus.remove(element);
    }

    public static final <E> PersistentSet<E> plus(PersistentSet<? extends E> $this$plus, Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return $this$plus.addAll((Collection) elements);
        }
        PersistentSet.Builder<? extends E> it = $this$plus.builder();
        CollectionsKt.addAll(it, elements);
        return it.build();
    }

    public static final <E> PersistentSet<E> plus(PersistentSet<? extends E> $this$plus, E[] elements) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentSet.Builder<? extends E> it = $this$plus.builder();
        CollectionsKt.addAll(it, (T[]) elements);
        return it.build();
    }

    public static final <E> PersistentSet<E> plus(PersistentSet<? extends E> $this$plus, Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentSet.Builder<? extends E> it = $this$plus.builder();
        CollectionsKt.addAll(it, elements);
        return it.build();
    }

    public static final <E> PersistentSet<E> minus(PersistentSet<? extends E> $this$minus, Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return $this$minus.removeAll((Collection<? extends Object>) (Collection) elements);
        }
        PersistentSet.Builder<? extends E> it = $this$minus.builder();
        CollectionsKt.removeAll(it, elements);
        return it.build();
    }

    public static final <E> PersistentSet<E> minus(PersistentSet<? extends E> $this$minus, E[] elements) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentSet.Builder<? extends E> it = $this$minus.builder();
        CollectionsKt.removeAll(it, (T[]) elements);
        return it.build();
    }

    public static final <E> PersistentSet<E> minus(PersistentSet<? extends E> $this$minus, Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentSet.Builder<? extends E> it = $this$minus.builder();
        CollectionsKt.removeAll(it, elements);
        return it.build();
    }

    public static final <E> PersistentSet<E> intersect(PersistentSet<? extends E> $this$intersect, Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter($this$intersect, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return $this$intersect.retainAll((Collection) elements);
        }
        PersistentSet.Builder<? extends E> it = $this$intersect.builder();
        CollectionsKt.retainAll(it, elements);
        return it.build();
    }

    public static final <E> PersistentSet<E> intersect(PersistentCollection<? extends E> $this$intersect, Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter($this$intersect, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return intersect(toPersistentSet($this$intersect), elements);
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> $this$plus, Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(pair, "pair");
        return $this$plus.put(pair.getFirst(), pair.getSecond());
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> $this$plus, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        return putAll($this$plus, pairs);
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> $this$plus, Pair<? extends K, ? extends V>[] pairs) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        return putAll($this$plus, pairs);
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> $this$plus, Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        return putAll($this$plus, pairs);
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> $this$plus, Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        return putAll($this$plus, map);
    }

    public static final <K, V> PersistentMap<K, V> putAll(PersistentMap<? extends K, ? extends V> $this$putAll, Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter($this$putAll, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        return $this$putAll.putAll(map);
    }

    public static final <K, V> PersistentMap<K, V> putAll(PersistentMap<? extends K, ? extends V> $this$putAll, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter($this$putAll, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        PersistentMap.Builder<? extends K, ? extends V> it = $this$putAll.builder();
        MapsKt.putAll(it, pairs);
        return it.build();
    }

    public static final <K, V> PersistentMap<K, V> putAll(PersistentMap<? extends K, ? extends V> $this$putAll, Pair<? extends K, ? extends V>[] pairs) {
        Intrinsics.checkNotNullParameter($this$putAll, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        PersistentMap.Builder<? extends K, ? extends V> it = $this$putAll.builder();
        MapsKt.putAll(it, pairs);
        return it.build();
    }

    public static final <K, V> PersistentMap<K, V> putAll(PersistentMap<? extends K, ? extends V> $this$putAll, Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter($this$putAll, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        PersistentMap.Builder<? extends K, ? extends V> it = $this$putAll.builder();
        MapsKt.putAll(it, pairs);
        return it.build();
    }

    public static final <K, V> PersistentMap<K, V> minus(PersistentMap<? extends K, ? extends V> $this$minus, K key) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        return $this$minus.remove(key);
    }

    public static final <K, V> PersistentMap<K, V> minus(PersistentMap<? extends K, ? extends V> $this$minus, Iterable<? extends K> keys) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        PersistentMap.Builder<? extends K, ? extends V> it = $this$minus.builder();
        CollectionsKt.removeAll(it.keySet(), keys);
        return it.build();
    }

    public static final <K, V> PersistentMap<K, V> minus(PersistentMap<? extends K, ? extends V> $this$minus, K[] keys) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        PersistentMap.Builder<? extends K, ? extends V> it = $this$minus.builder();
        CollectionsKt.removeAll(it.keySet(), (T[]) keys);
        return it.build();
    }

    public static final <K, V> PersistentMap<K, V> minus(PersistentMap<? extends K, ? extends V> $this$minus, Sequence<? extends K> keys) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        PersistentMap.Builder<? extends K, ? extends V> it = $this$minus.builder();
        CollectionsKt.removeAll(it.keySet(), keys);
        return it.build();
    }

    public static final <E> PersistentList<E> persistentListOf(E... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return UtilsKt.persistentVectorOf().addAll(ArraysKt.asList((T[]) elements));
    }

    public static final <E> PersistentList<E> persistentListOf() {
        return UtilsKt.persistentVectorOf();
    }

    public static final <E> PersistentSet<E> persistentSetOf(E... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return PersistentOrderedSet.Companion.emptyOf$runtime_release().addAll(ArraysKt.asList((T[]) elements));
    }

    public static final <E> PersistentSet<E> persistentSetOf() {
        return PersistentOrderedSet.Companion.emptyOf$runtime_release();
    }

    public static final <E> PersistentSet<E> persistentHashSetOf(E... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return PersistentHashSet.Companion.emptyOf$runtime_release().addAll(ArraysKt.asList((T[]) elements));
    }

    public static final <E> PersistentSet<E> persistentHashSetOf() {
        return PersistentHashSet.Companion.emptyOf$runtime_release();
    }

    public static final <K, V> PersistentMap<K, V> persistentMapOf(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        PersistentMap $this$mutate$iv = PersistentOrderedMap.Companion.emptyOf$runtime_release();
        Intrinsics.checkNotNull($this$mutate$iv, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        PersistentMap.Builder it = $this$mutate$iv.builder();
        MapsKt.putAll(it, pairs);
        return it.build();
    }

    public static final <K, V> PersistentMap<K, V> persistentMapOf() {
        return PersistentOrderedMap.Companion.emptyOf$runtime_release();
    }

    public static final <K, V> PersistentMap<K, V> persistentHashMapOf(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        PersistentMap $this$mutate$iv = PersistentHashMap.Companion.emptyOf$runtime_release();
        Intrinsics.checkNotNull($this$mutate$iv, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        PersistentMap.Builder it = $this$mutate$iv.builder();
        MapsKt.putAll(it, pairs);
        return it.build();
    }

    public static final <K, V> PersistentMap<K, V> persistentHashMapOf() {
        return PersistentHashMap.Companion.emptyOf$runtime_release();
    }

    @Deprecated(message = "Use persistentListOf instead.", replaceWith = @ReplaceWith(expression = "persistentListOf(*elements)", imports = {}))
    public static final <E> PersistentList<E> immutableListOf(E... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return persistentListOf(Arrays.copyOf(elements, elements.length));
    }

    @Deprecated(message = "Use persistentListOf instead.", replaceWith = @ReplaceWith(expression = "persistentListOf()", imports = {}))
    public static final <E> PersistentList<E> immutableListOf() {
        return persistentListOf();
    }

    @Deprecated(message = "Use persistentSetOf instead.", replaceWith = @ReplaceWith(expression = "persistentSetOf(*elements)", imports = {}))
    public static final <E> PersistentSet<E> immutableSetOf(E... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return persistentSetOf(Arrays.copyOf(elements, elements.length));
    }

    @Deprecated(message = "Use persistentSetOf instead.", replaceWith = @ReplaceWith(expression = "persistentSetOf()", imports = {}))
    public static final <E> PersistentSet<E> immutableSetOf() {
        return persistentSetOf();
    }

    @Deprecated(message = "Use persistentHashSetOf instead.", replaceWith = @ReplaceWith(expression = "persistentHashSetOf(*elements)", imports = {}))
    public static final <E> PersistentSet<E> immutableHashSetOf(E... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return persistentHashSetOf(Arrays.copyOf(elements, elements.length));
    }

    @Deprecated(message = "Use persistentMapOf instead.", replaceWith = @ReplaceWith(expression = "persistentMapOf(*pairs)", imports = {}))
    public static final <K, V> PersistentMap<K, V> immutableMapOf(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        return persistentMapOf((Pair[]) Arrays.copyOf(pairs, pairs.length));
    }

    @Deprecated(message = "Use persistentHashMapOf instead.", replaceWith = @ReplaceWith(expression = "persistentHashMapOf(*pairs)", imports = {}))
    public static final <K, V> PersistentMap<K, V> immutableHashMapOf(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        return persistentHashMapOf((Pair[]) Arrays.copyOf(pairs, pairs.length));
    }

    public static final <T> ImmutableList<T> toImmutableList(Iterable<? extends T> $this$toImmutableList) {
        Intrinsics.checkNotNullParameter($this$toImmutableList, "<this>");
        ImmutableList<T> immutableList = $this$toImmutableList instanceof ImmutableList ? (ImmutableList) $this$toImmutableList : null;
        return immutableList == null ? toPersistentList($this$toImmutableList) : immutableList;
    }

    public static final <T> ImmutableList<T> toImmutableList(Sequence<? extends T> $this$toImmutableList) {
        Intrinsics.checkNotNullParameter($this$toImmutableList, "<this>");
        return toPersistentList($this$toImmutableList);
    }

    public static final ImmutableList<Character> toImmutableList(CharSequence $this$toImmutableList) {
        Intrinsics.checkNotNullParameter($this$toImmutableList, "<this>");
        return toPersistentList($this$toImmutableList);
    }

    public static final <T> PersistentList<T> toPersistentList(Iterable<? extends T> $this$toPersistentList) {
        Intrinsics.checkNotNullParameter($this$toPersistentList, "<this>");
        PersistentList<T> persistentList = null;
        PersistentList<T> persistentList2 = $this$toPersistentList instanceof PersistentList ? (PersistentList) $this$toPersistentList : null;
        if (persistentList2 != null) {
            return persistentList2;
        }
        PersistentList.Builder builder = $this$toPersistentList instanceof PersistentList.Builder ? (PersistentList.Builder) $this$toPersistentList : null;
        if (builder != null) {
            persistentList = builder.build();
        }
        if (persistentList == null) {
            return plus(persistentListOf(), $this$toPersistentList);
        }
        return persistentList;
    }

    public static final <T> PersistentList<T> toPersistentList(Sequence<? extends T> $this$toPersistentList) {
        Intrinsics.checkNotNullParameter($this$toPersistentList, "<this>");
        return plus(persistentListOf(), $this$toPersistentList);
    }

    public static final PersistentList<Character> toPersistentList(CharSequence $this$toPersistentList) {
        Intrinsics.checkNotNullParameter($this$toPersistentList, "<this>");
        PersistentList.Builder it = persistentListOf().builder();
        StringsKt.toCollection($this$toPersistentList, it);
        return it.build();
    }

    public static final <T> ImmutableSet<T> toImmutableSet(Iterable<? extends T> $this$toImmutableSet) {
        Intrinsics.checkNotNullParameter($this$toImmutableSet, "<this>");
        PersistentSet persistentSet = null;
        ImmutableSet<T> immutableSet = $this$toImmutableSet instanceof ImmutableSet ? (ImmutableSet) $this$toImmutableSet : null;
        if (immutableSet != null) {
            return immutableSet;
        }
        PersistentSet.Builder builder = $this$toImmutableSet instanceof PersistentSet.Builder ? (PersistentSet.Builder) $this$toImmutableSet : null;
        if (builder != null) {
            persistentSet = builder.build();
        }
        if (persistentSet != null) {
            return persistentSet;
        }
        return plus(persistentSetOf(), $this$toImmutableSet);
    }

    public static final <T> ImmutableSet<T> toImmutableSet(Sequence<? extends T> $this$toImmutableSet) {
        Intrinsics.checkNotNullParameter($this$toImmutableSet, "<this>");
        return toPersistentSet($this$toImmutableSet);
    }

    public static final PersistentSet<Character> toImmutableSet(CharSequence $this$toImmutableSet) {
        Intrinsics.checkNotNullParameter($this$toImmutableSet, "<this>");
        return toPersistentSet($this$toImmutableSet);
    }

    public static final <T> PersistentSet<T> toPersistentSet(Iterable<? extends T> $this$toPersistentSet) {
        Intrinsics.checkNotNullParameter($this$toPersistentSet, "<this>");
        PersistentSet<T> persistentSet = null;
        PersistentOrderedSet persistentOrderedSet = $this$toPersistentSet instanceof PersistentOrderedSet ? (PersistentOrderedSet) $this$toPersistentSet : null;
        if (persistentOrderedSet != null) {
            return persistentOrderedSet;
        }
        PersistentOrderedSetBuilder persistentOrderedSetBuilder = $this$toPersistentSet instanceof PersistentOrderedSetBuilder ? (PersistentOrderedSetBuilder) $this$toPersistentSet : null;
        if (persistentOrderedSetBuilder != null) {
            persistentSet = persistentOrderedSetBuilder.build();
        }
        if (persistentSet == null) {
            return plus(PersistentOrderedSet.Companion.emptyOf$runtime_release(), $this$toPersistentSet);
        }
        return persistentSet;
    }

    public static final <T> PersistentSet<T> toPersistentSet(Sequence<? extends T> $this$toPersistentSet) {
        Intrinsics.checkNotNullParameter($this$toPersistentSet, "<this>");
        return plus(persistentSetOf(), $this$toPersistentSet);
    }

    public static final PersistentSet<Character> toPersistentSet(CharSequence $this$toPersistentSet) {
        Intrinsics.checkNotNullParameter($this$toPersistentSet, "<this>");
        PersistentSet.Builder it = persistentSetOf().builder();
        StringsKt.toCollection($this$toPersistentSet, it);
        return it.build();
    }

    public static final <T> PersistentSet<T> toPersistentHashSet(Iterable<? extends T> $this$toPersistentHashSet) {
        Intrinsics.checkNotNullParameter($this$toPersistentHashSet, "<this>");
        PersistentHashSet persistentHashSet = null;
        PersistentHashSet persistentHashSet2 = $this$toPersistentHashSet instanceof PersistentHashSet ? (PersistentHashSet) $this$toPersistentHashSet : null;
        if (persistentHashSet2 != null) {
            return persistentHashSet2;
        }
        PersistentHashSetBuilder persistentHashSetBuilder = $this$toPersistentHashSet instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) $this$toPersistentHashSet : null;
        if (persistentHashSetBuilder != null) {
            persistentHashSet = persistentHashSetBuilder.build();
        }
        if (persistentHashSet != null) {
            return persistentHashSet;
        }
        return plus(PersistentHashSet.Companion.emptyOf$runtime_release(), $this$toPersistentHashSet);
    }

    public static final <T> PersistentSet<T> toPersistentHashSet(Sequence<? extends T> $this$toPersistentHashSet) {
        Intrinsics.checkNotNullParameter($this$toPersistentHashSet, "<this>");
        return plus(persistentHashSetOf(), $this$toPersistentHashSet);
    }

    public static final PersistentSet<Character> toPersistentHashSet(CharSequence $this$toPersistentHashSet) {
        Intrinsics.checkNotNullParameter($this$toPersistentHashSet, "<this>");
        PersistentSet.Builder it = persistentHashSetOf().builder();
        StringsKt.toCollection($this$toPersistentHashSet, it);
        return it.build();
    }

    public static final <K, V> ImmutableMap<K, V> toImmutableMap(Map<K, ? extends V> $this$toImmutableMap) {
        Intrinsics.checkNotNullParameter($this$toImmutableMap, "<this>");
        PersistentMap persistentMap = null;
        ImmutableMap<K, V> immutableMap = $this$toImmutableMap instanceof ImmutableMap ? (ImmutableMap) $this$toImmutableMap : null;
        if (immutableMap != null) {
            return immutableMap;
        }
        PersistentMap.Builder builder = $this$toImmutableMap instanceof PersistentMap.Builder ? (PersistentMap.Builder) $this$toImmutableMap : null;
        if (builder != null) {
            persistentMap = builder.build();
        }
        if (persistentMap != null) {
            return persistentMap;
        }
        return persistentMapOf().putAll($this$toImmutableMap);
    }

    public static final <K, V> PersistentMap<K, V> toPersistentMap(Map<K, ? extends V> $this$toPersistentMap) {
        Intrinsics.checkNotNullParameter($this$toPersistentMap, "<this>");
        PersistentMap<K, V> persistentMap = null;
        PersistentOrderedMap persistentOrderedMap = $this$toPersistentMap instanceof PersistentOrderedMap ? (PersistentOrderedMap) $this$toPersistentMap : null;
        if (persistentOrderedMap != null) {
            return persistentOrderedMap;
        }
        PersistentOrderedMapBuilder persistentOrderedMapBuilder = $this$toPersistentMap instanceof PersistentOrderedMapBuilder ? (PersistentOrderedMapBuilder) $this$toPersistentMap : null;
        if (persistentOrderedMapBuilder != null) {
            persistentMap = persistentOrderedMapBuilder.build();
        }
        if (persistentMap == null) {
            return PersistentOrderedMap.Companion.emptyOf$runtime_release().putAll($this$toPersistentMap);
        }
        return persistentMap;
    }

    public static final <K, V> PersistentMap<K, V> toPersistentHashMap(Map<K, ? extends V> $this$toPersistentHashMap) {
        Intrinsics.checkNotNullParameter($this$toPersistentHashMap, "<this>");
        PersistentHashMap persistentHashMap = null;
        PersistentHashMap persistentHashMap2 = $this$toPersistentHashMap instanceof PersistentHashMap ? (PersistentHashMap) $this$toPersistentHashMap : null;
        if (persistentHashMap2 != null) {
            return persistentHashMap2;
        }
        PersistentHashMapBuilder persistentHashMapBuilder = $this$toPersistentHashMap instanceof PersistentHashMapBuilder ? (PersistentHashMapBuilder) $this$toPersistentHashMap : null;
        if (persistentHashMapBuilder != null) {
            persistentHashMap = persistentHashMapBuilder.build();
        }
        if (persistentHashMap != null) {
            return persistentHashMap;
        }
        return PersistentHashMap.Companion.emptyOf$runtime_release().putAll($this$toPersistentHashMap);
    }
}
