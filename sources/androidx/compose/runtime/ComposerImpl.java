package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IntMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000ê\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0011\n\u0002\b7\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b)\b\u0000\u0018\u00002\u00020\u0001:\u0004ï\u0002ð\u0002Bí\u0001\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012Y\u0010\u000b\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\f\u0012Y\u0010\u0016\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\f\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\t\u0010\u0001\u001a\u00020\u0014H\u0002J\t\u0010\u0001\u001a\u00020\u0014H\u0002JK\u0010\u0001\u001a\u00020\u0014\"\u0005\b\u0000\u0010\u0001\"\u0005\b\u0001\u0010\u00012\b\u0010\u0001\u001a\u0003H\u00012\"\u0010\u0001\u001a\u001d\u0012\u0005\u0012\u0003H\u0001\u0012\u0005\u0012\u0003H\u0001\u0012\u0004\u0012\u00020\u00140\u0001¢\u0006\u0003\b\u0001H\u0016¢\u0006\u0003\u0010 \u0001J\t\u0010¡\u0001\u001a\u00020\u0005H\u0016J5\u0010¢\u0001\u001a\u0003H\u0001\"\u0005\b\u0000\u0010\u00012\u0007\u0010£\u0001\u001a\u00020!2\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010¤\u0001H\bø\u0001\u0000¢\u0006\u0003\u0010¥\u0001J\u0014\u0010¦\u0001\u001a\u00020!2\t\u0010\u0001\u001a\u0004\u0018\u00010EH\u0017J\u0012\u0010¦\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020!H\u0017J\u0013\u0010¦\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030§\u0001H\u0017J\u0013\u0010¦\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030¨\u0001H\u0017J\u0013\u0010¦\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030©\u0001H\u0017J\u0013\u0010¦\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030ª\u0001H\u0017J\u0012\u0010¦\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020%H\u0017J\u0013\u0010¦\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030«\u0001H\u0017J\u0013\u0010¦\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030¬\u0001H\u0017J\u0014\u0010­\u0001\u001a\u00020!2\t\u0010\u0001\u001a\u0004\u0018\u00010EH\u0017J\u000f\u0010®\u0001\u001a\u00020\u0014H\u0000¢\u0006\u0003\b¯\u0001J\t\u0010°\u0001\u001a\u00020\u0014H\u0002J\t\u0010±\u0001\u001a\u00020\u0014H\u0002J\t\u0010²\u0001\u001a\u00020\u0014H\u0016JG\u0010³\u0001\u001a\u00020\u00142\u001d\u0010´\u0001\u001a\u0018\u0012\u0004\u0012\u000208\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020E\u0018\u00010¶\u00010µ\u00012\u0014\u0010·\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u00140¤\u0001¢\u0006\u0003\b¸\u0001H\u0000¢\u0006\u0006\b¹\u0001\u0010º\u0001J$\u0010»\u0001\u001a\u00020%2\u0007\u0010¼\u0001\u001a\u00020%2\u0007\u0010½\u0001\u001a\u00020%2\u0007\u0010¾\u0001\u001a\u00020%H\u0002J'\u0010¿\u0001\u001a\u0003H\u0001\"\u0005\b\u0000\u0010\u00012\u000e\u0010À\u0001\u001a\t\u0012\u0005\u0012\u0003H\u00010nH\u0017¢\u0006\u0003\u0010Á\u0001J\t\u0010Â\u0001\u001a\u00020\u0014H\u0002J!\u0010Ã\u0001\u001a\u00020\u0014\"\u0005\b\u0000\u0010\u00012\u000f\u0010Ä\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010¤\u0001H\u0016J)\u0010Å\u0001\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0o0mj\u0002`pH\u0002J2\u0010Å\u0001\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0o0mj\u0002`p2\u0007\u0010¼\u0001\u001a\u00020%H\u0002J\u0012\u0010Æ\u0001\u001a\u00020\u00142\u0007\u0010¦\u0001\u001a\u00020!H\u0017J\t\u0010Ç\u0001\u001a\u00020\u0014H\u0016J\t\u0010È\u0001\u001a\u00020\u0014H\u0016J\u000f\u0010É\u0001\u001a\u00020\u0014H\u0000¢\u0006\u0003\bÊ\u0001JF\u0010Ë\u0001\u001a\u00020\u00142\u001d\u0010´\u0001\u001a\u0018\u0012\u0004\u0012\u000208\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020E\u0018\u00010¶\u00010µ\u00012\u0016\u0010·\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0014\u0018\u00010¤\u0001¢\u0006\u0003\b¸\u0001H\u0002¢\u0006\u0003\u0010º\u0001J\u001b\u0010Ì\u0001\u001a\u00020\u00142\u0007\u0010¼\u0001\u001a\u00020%2\u0007\u0010Í\u0001\u001a\u00020%H\u0002J\t\u0010Î\u0001\u001a\u00020\u0014H\u0016J\u0012\u0010Ï\u0001\u001a\u00020\u00142\u0007\u0010Ð\u0001\u001a\u00020!H\u0002J\t\u0010Ñ\u0001\u001a\u00020\u0014H\u0017J\t\u0010Ò\u0001\u001a\u00020\u0014H\u0002J\t\u0010Ó\u0001\u001a\u00020\u0014H\u0017J\t\u0010Ô\u0001\u001a\u00020\u0014H\u0016J\t\u0010Õ\u0001\u001a\u00020\u0014H\u0017J\t\u0010Ö\u0001\u001a\u00020\u0014H\u0017J\f\u0010×\u0001\u001a\u0005\u0018\u00010Ø\u0001H\u0017J\t\u0010Ù\u0001\u001a\u00020\u0014H\u0016J\t\u0010Ú\u0001\u001a\u00020\u0014H\u0002J\u0012\u0010Û\u0001\u001a\u00020\u00142\u0007\u0010Ü\u0001\u001a\u00020%H\u0016J\t\u0010Ý\u0001\u001a\u00020\u0014H\u0002J\u001d\u0010Þ\u0001\u001a\u00020\u00142\u0007\u0010Ð\u0001\u001a\u00020!2\t\u0010ß\u0001\u001a\u0004\u0018\u00010rH\u0002J\u001a\u0010à\u0001\u001a\u00020\u00142\u0007\u0010á\u0001\u001a\u00020%2\u0006\u0010Z\u001a\u00020!H\u0002J\t\u0010â\u0001\u001a\u00020\u0014H\u0002J\u000e\u0010H\u001a\u00020!H\u0000¢\u0006\u0003\bã\u0001J\"\u0010ä\u0001\u001a\u00020\u00142\f\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030å\u00012\t\u0010æ\u0001\u001a\u0004\u0018\u00010EH\u0017J*\u0010ç\u0001\u001a\u00020\u00142\u001f\u0010è\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030ë\u0001\u0012\u0007\u0012\u0005\u0018\u00010ë\u00010ê\u00010é\u0001H\u0002J*\u0010ì\u0001\u001a\u00020\u00142\u001f\u0010è\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030ë\u0001\u0012\u0007\u0012\u0005\u0018\u00010ë\u00010ê\u00010é\u0001H\u0017J\u0012\u0010í\u0001\u001a\u00020%2\u0007\u0010î\u0001\u001a\u00020%H\u0002JX\u0010ï\u0001\u001a\u00020\u00142\u0010\u0010·\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010E0å\u00012'\u0010ð\u0001\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0o0mj\u0002`p2\t\u0010æ\u0001\u001a\u0004\u0018\u00010E2\u0007\u0010ñ\u0001\u001a\u00020!H\u0002J\u001f\u0010ò\u0001\u001a\u00020E2\t\u0010ó\u0001\u001a\u0004\u0018\u00010E2\t\u0010ô\u0001\u001a\u0004\u0018\u00010EH\u0017J\u000b\u0010õ\u0001\u001a\u0004\u0018\u00010EH\u0001J-\u0010ö\u0001\u001a\u00020%2\u0007\u0010÷\u0001\u001a\u00020%2\u0007\u0010¼\u0001\u001a\u00020%2\u0007\u0010½\u0001\u001a\u00020%2\u0007\u0010ø\u0001\u001a\u00020%H\u0002J\u000f\u0010ù\u0001\u001a\u00020%H\u0000¢\u0006\u0003\bú\u0001J\u001f\u0010û\u0001\u001a\u00020\u00142\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00140¤\u0001H\u0000¢\u0006\u0003\bü\u0001J\t\u0010ý\u0001\u001a\u00020\u0014H\u0002J!\u0010ý\u0001\u001a\u00020\u00142\u0010\u0010þ\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010E0ÿ\u0001H\u0002¢\u0006\u0003\u0010\u0002J\t\u0010\u0002\u001a\u00020\u0014H\u0002J\u0014\u0010\u0002\u001a\u00020\u00142\t\b\u0002\u0010\u0002\u001a\u00020!H\u0002J\t\u0010\u0002\u001a\u00020\u0014H\u0002J.\u0010\u0002\u001a\u00020!2\u001d\u0010´\u0001\u001a\u0018\u0012\u0004\u0012\u000208\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020E\u0018\u00010¶\u00010µ\u0001H\u0000¢\u0006\u0003\b\u0002Jv\u0010\u0002\u001a\u0003H\u0002\"\u0005\b\u0000\u0010\u00022\u000b\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00182\u000b\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00182\u000b\b\u0002\u0010î\u0001\u001a\u0004\u0018\u00010%2%\b\u0002\u0010^\u001a\u001f\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u000208\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020E\u0018\u00010¶\u00010ê\u00010é\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00020¤\u0001H\u0002¢\u0006\u0003\u0010\u0002J\t\u0010\u0002\u001a\u00020\u0014H\u0002J_\u0010\u0002\u001a\u00020\u00142T\u0010\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J_\u0010\u0002\u001a\u00020\u00142T\u0010\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J\t\u0010\u0002\u001a\u00020\u0014H\u0002J\u0014\u0010\u0002\u001a\u00020\u00142\t\u0010\u0001\u001a\u0004\u0018\u00010EH\u0002J\t\u0010\u0002\u001a\u00020\u0014H\u0002J\t\u0010\u0002\u001a\u00020\u0014H\u0002J_\u0010\u0002\u001a\u00020\u00142T\u0010\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J\u0012\u0010\u0002\u001a\u00020\u00142\u0007\u0010\u0002\u001a\u00020RH\u0002J_\u0010\u0002\u001a\u00020\u00142T\u0010\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J$\u0010\u0002\u001a\u00020\u00142\u0007\u0010\u0002\u001a\u00020%2\u0007\u0010\u0002\u001a\u00020%2\u0007\u0010\u0002\u001a\u00020%H\u0002J\u0012\u0010\u0002\u001a\u00020\u00142\u0007\u0010\u0002\u001a\u00020%H\u0002J\u001a\u0010\u0002\u001a\u00020\u00142\u0006\u0010j\u001a\u00020%2\u0007\u0010\u0002\u001a\u00020%H\u0002J\u0019\u0010\u0002\u001a\u00020\u00142\u000e\u0010\u0002\u001a\t\u0012\u0004\u0012\u00020\u00140¤\u0001H\u0016J\t\u0010\u0002\u001a\u00020\u0014H\u0002J_\u0010 \u0002\u001a\u00020\u00142T\u0010\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002Jj\u0010¡\u0002\u001a\u00020\u00142\t\b\u0002\u0010\u0002\u001a\u00020!2T\u0010\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J\t\u0010¢\u0002\u001a\u00020\u0014H\u0002J$\u0010£\u0002\u001a\u00020\u00142\u0007\u0010¤\u0002\u001a\u00020%2\u0007\u0010¥\u0002\u001a\u00020%2\u0007\u0010¦\u0002\u001a\u00020%H\u0002J\u0013\u0010§\u0002\u001a\u00020\u00142\b\u0010¨\u0002\u001a\u00030\u0001H\u0016J\t\u0010©\u0002\u001a\u00020\u0014H\u0002J\u001b\u0010ª\u0002\u001a\u00020\u00142\b\u0010«\u0002\u001a\u00030ë\u00012\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u000b\u0010¬\u0002\u001a\u0004\u0018\u00010EH\u0016J\t\u0010­\u0002\u001a\u00020\u0014H\u0002J\u0012\u0010®\u0002\u001a\u00020\u00142\u0007\u0010¯\u0002\u001a\u00020%H\u0002JP\u0010°\u0002\u001a\u0003H\u0001\"\u0005\b\u0000\u0010\u00012\u000e\u0010À\u0001\u001a\t\u0012\u0005\u0012\u0003H\u00010n2'\u0010¨\u0002\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0o0mj\u0002`pH\u0002¢\u0006\u0003\u0010±\u0002J\t\u0010²\u0002\u001a\u00020\u0014H\u0017J\t\u0010³\u0002\u001a\u00020\u0014H\u0002J\t\u0010´\u0002\u001a\u00020\u0014H\u0002J\t\u0010µ\u0002\u001a\u00020\u0014H\u0017J\u0013\u0010¶\u0002\u001a\u00020\u00142\b\u0010¶\u0002\u001a\u00030·\u0002H\u0017J\t\u0010¸\u0002\u001a\u00020\u0014H\u0017J\u001c\u0010¹\u0002\u001a\u00020\u00142\u0007\u0010À\u0001\u001a\u00020%2\b\u0010¶\u0002\u001a\u00030·\u0002H\u0017JA\u0010º\u0002\u001a\u00020\u00142\u0007\u0010À\u0001\u001a\u00020%2\t\u0010»\u0002\u001a\u0004\u0018\u00010E2\b\u0010¼\u0002\u001a\u00030½\u00022\t\u0010¾\u0002\u001a\u0004\u0018\u00010EH\u0002ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\b¿\u0002\u0010À\u0002J\t\u0010Á\u0002\u001a\u00020\u0014H\u0017J\u0012\u0010Â\u0002\u001a\u00020\u00142\u0007\u0010À\u0001\u001a\u00020%H\u0002J\u001d\u0010Â\u0002\u001a\u00020\u00142\u0007\u0010À\u0001\u001a\u00020%2\t\u0010Ã\u0002\u001a\u0004\u0018\u00010EH\u0002J\u001d\u0010Ä\u0002\u001a\u00020\u00142\u0007\u0010À\u0001\u001a\u00020%2\t\u0010Ã\u0002\u001a\u0004\u0018\u00010EH\u0017J\t\u0010Å\u0002\u001a\u00020\u0014H\u0016J&\u0010Æ\u0002\u001a\u00020\u00142\u0015\u0010Ç\u0002\u001a\u0010\u0012\u000b\b\u0001\u0012\u0007\u0012\u0002\b\u00030È\u00020ÿ\u0001H\u0017¢\u0006\u0003\u0010É\u0002J\u001d\u0010Ê\u0002\u001a\u00020\u00142\u0007\u0010Ð\u0001\u001a\u00020!2\t\u0010¾\u0002\u001a\u0004\u0018\u00010EH\u0002J\u0012\u0010Ë\u0002\u001a\u00020\u00142\u0007\u0010À\u0001\u001a\u00020%H\u0017J\u0012\u0010Ì\u0002\u001a\u00020\u00012\u0007\u0010À\u0001\u001a\u00020%H\u0017J\u001d\u0010Í\u0002\u001a\u00020\u00142\u0007\u0010À\u0001\u001a\u00020%2\t\u0010Ã\u0002\u001a\u0004\u0018\u00010EH\u0016J\t\u0010Î\u0002\u001a\u00020\u0014H\u0016J\t\u0010Ï\u0002\u001a\u00020\u0014H\u0002J#\u0010Ð\u0002\u001a\u00020!2\u0007\u0010¨\u0002\u001a\u0002082\t\u0010Ñ\u0002\u001a\u0004\u0018\u00010EH\u0000¢\u0006\u0003\bÒ\u0002J\u0014\u0010Ó\u0002\u001a\u00020\u00142\t\u0010\u0001\u001a\u0004\u0018\u00010EH\u0001J(\u0010Ô\u0002\u001a\u00020\u00142\u0007\u0010Õ\u0002\u001a\u00020%2\t\u0010Ã\u0002\u001a\u0004\u0018\u00010E2\t\u0010¾\u0002\u001a\u0004\u0018\u00010EH\u0002J\u0012\u0010Ö\u0002\u001a\u00020\u00142\u0007\u0010×\u0002\u001a\u00020%H\u0002J(\u0010Ø\u0002\u001a\u00020\u00142\u0007\u0010Õ\u0002\u001a\u00020%2\t\u0010Ã\u0002\u001a\u0004\u0018\u00010E2\t\u0010¾\u0002\u001a\u0004\u0018\u00010EH\u0002J\u0012\u0010Ù\u0002\u001a\u00020\u00142\u0007\u0010Õ\u0002\u001a\u00020%H\u0002J\u001b\u0010Ú\u0002\u001a\u00020\u00142\u0007\u0010¼\u0001\u001a\u00020%2\u0007\u0010\u0002\u001a\u00020%H\u0002J\u001b\u0010Û\u0002\u001a\u00020\u00142\u0007\u0010¼\u0001\u001a\u00020%2\u0007\u0010Ü\u0002\u001a\u00020%H\u0002J{\u0010Ý\u0002\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0o0mj\u0002`p2'\u0010Þ\u0002\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0o0mj\u0002`p2'\u0010ß\u0002\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0o0mj\u0002`pH\u0002J\u0014\u0010à\u0002\u001a\u00020\u00142\t\u0010\u0001\u001a\u0004\u0018\u00010EH\u0016J\u0014\u0010á\u0002\u001a\u00020\u00142\t\u0010\u0001\u001a\u0004\u0018\u00010EH\u0001J\u0012\u0010â\u0002\u001a\u00020%2\u0007\u0010¼\u0001\u001a\u00020%H\u0002J\t\u0010ã\u0002\u001a\u00020\u0014H\u0016J\t\u0010ä\u0002\u001a\u00020\u0014H\u0002J\t\u0010å\u0002\u001a\u00020\u0014H\u0002J\u000f\u0010æ\u0002\u001a\u00020\u0014H\u0000¢\u0006\u0003\bç\u0002J\u0001\u0010è\u0002\u001a\u0003H\u0002\"\u0005\b\u0000\u0010\u00022Z\u0010é\u0002\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\f2\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00020¤\u0001H\b¢\u0006\u0003\u0010ê\u0002J1\u0010ë\u0002\u001a\u0003H\u0002\"\u0005\b\u0000\u0010\u00022\u0006\u0010~\u001a\u000202\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00020¤\u0001H\b¢\u0006\u0003\u0010ì\u0002J\u0016\u0010í\u0002\u001a\u00020%*\u000202\u0007\u0010¼\u0001\u001a\u00020%H\u0002J\u0018\u0010î\u0002\u001a\u0004\u0018\u00010E*\u000202\u0007\u0010î\u0001\u001a\u00020%H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8@X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8@X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'Ra\u0010\u000b\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R&\u00101\u001a\u00020%2\u0006\u00100\u001a\u00020%8\u0016@RX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b2\u00103\u001a\u0004\b4\u0010'R\u0014\u00105\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b6\u0010'R\u0016\u00107\u001a\u0004\u0018\u0001088@X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020!8VX\u0004¢\u0006\f\u0012\u0004\b<\u00103\u001a\u0004\b=\u0010#Ro\u0010>\u001aW\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010E0DX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020GX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010L\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\bM\u0010#R\u0014\u0010N\u001a\u00020!8@X\u0004¢\u0006\u0006\u001a\u0004\bO\u0010#R\u000e\u0010P\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u000e¢\u0006\u0002\n\u0000Ra\u0010S\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010T\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XRa\u0010Y\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150DX\u0004¢\u0006\u0002\n\u0000R&\u0010Z\u001a\u00020!2\u0006\u00100\u001a\u00020!8\u0016@RX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b[\u00103\u001a\u0004\b\\\u0010#R\u0014\u0010]\u001a\b\u0012\u0004\u0012\u0002080DX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010^\u001a\b\u0012\u0004\u0012\u00020_0\fX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010`\u001a\u00020!2\u0006\u00100\u001a\u00020!@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\ba\u0010#R\u001e\u0010b\u001a\u00020!2\u0006\u00100\u001a\u00020!@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bc\u0010#Ra\u0010\u0016\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010d\u001a\u0004\u0018\u00010eX\u000e¢\u0006\u0002\n\u0000R.\u0010f\u001a\"\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u00010gj\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u0001`hX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020GX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R.\u0010l\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0o0mj\u0002`pX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010q\u001a\u0004\u0018\u00010rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010s\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010r0DX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R2\u0010y\u001a&\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0o\u0018\u00010mj\u0004\u0018\u0001`pX\u000e¢\u0006\u0002\n\u0000R4\u0010z\u001a(\u0012$\u0012\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0o0mj\u0002`p0{X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020GX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0001\u001a\u0005\u0018\u00010\u00018VX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u0004\u0018\u00010E8VX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u000f\u0010\u0001\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u00020!8VX\u0004¢\u0006\u000e\u0012\u0005\b\u0001\u00103\u001a\u0005\b\u0001\u0010#R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020GX\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u0004\u0018\u00010E*\u000208BX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001\u0002\u0012\n\u0005\b20\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006ñ\u0002"}, d2 = {"Landroidx/compose/runtime/ComposerImpl;", "Landroidx/compose/runtime/Composer;", "applier", "Landroidx/compose/runtime/Applier;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "changes", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "lateChanges", "composition", "Landroidx/compose/runtime/ControlledComposition;", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/SlotTable;Ljava/util/Set;Ljava/util/List;Ljava/util/List;Landroidx/compose/runtime/ControlledComposition;)V", "getApplier", "()Landroidx/compose/runtime/Applier;", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "areChildrenComposing", "", "getAreChildrenComposing$runtime_release", "()Z", "changeCount", "", "getChangeCount$runtime_release", "()I", "childrenComposing", "getComposition", "()Landroidx/compose/runtime/ControlledComposition;", "compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "compositionToken", "<set-?>", "compoundKeyHash", "getCompoundKeyHash$annotations", "()V", "getCompoundKeyHash", "currentMarker", "getCurrentMarker", "currentRecomposeScope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getCurrentRecomposeScope$runtime_release", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "defaultsInvalid", "getDefaultsInvalid$annotations", "getDefaultsInvalid", "deferredChanges", "getDeferredChanges$runtime_release", "()Ljava/util/List;", "setDeferredChanges$runtime_release", "(Ljava/util/List;)V", "downNodes", "Landroidx/compose/runtime/Stack;", "", "entersStack", "Landroidx/compose/runtime/IntStack;", "forceRecomposeScopes", "forciblyRecompose", "groupNodeCount", "groupNodeCountStack", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges$runtime_release", "implicitRootStart", "insertAnchor", "Landroidx/compose/runtime/Anchor;", "insertFixups", "insertTable", "getInsertTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "setInsertTable$runtime_release", "(Landroidx/compose/runtime/SlotTable;)V", "insertUpFixups", "inserting", "getInserting$annotations", "getInserting", "invalidateStack", "invalidations", "Landroidx/compose/runtime/Invalidation;", "isComposing", "isComposing$runtime_release", "isDisposed", "isDisposed$runtime_release", "nodeCountOverrides", "", "nodeCountVirtualOverrides", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "nodeExpected", "nodeIndex", "nodeIndexStack", "parentProvider", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "pending", "Landroidx/compose/runtime/Pending;", "pendingStack", "pendingUps", "previousCount", "previousMoveFrom", "previousMoveTo", "previousRemove", "providerCache", "providerUpdates", "Landroidx/compose/runtime/collection/IntMap;", "providersInvalid", "providersInvalidStack", "reader", "Landroidx/compose/runtime/SlotReader;", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScopeIdentity", "getRecomposeScopeIdentity", "()Ljava/lang/Object;", "reusing", "reusingGroup", "skipping", "getSkipping$annotations", "getSkipping", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "sourceInformationEnabled", "startedGroup", "startedGroups", "writer", "writerHasAProvider", "writersReaderDelta", "node", "getNode", "(Landroidx/compose/runtime/SlotReader;)Ljava/lang/Object;", "abortRoot", "addRecomposeScope", "apply", "V", "T", "value", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "buildContext", "cache", "invalid", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "changed", "", "", "", "", "", "", "changedInstance", "changesApplied", "changesApplied$runtime_release", "cleanUpCompose", "clearUpdatedNodeCounts", "collectParameterInformation", "composeContent", "invalidationsRequested", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "content", "Landroidx/compose/runtime/Composable;", "composeContent$runtime_release", "(Landroidx/compose/runtime/collection/IdentityArrayMap;Lkotlin/jvm/functions/Function2;)V", "compoundKeyOf", "group", "recomposeGroup", "recomposeKey", "consume", "key", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "createFreshInsertTable", "createNode", "factory", "currentCompositionLocalScope", "deactivateToEndGroup", "disableReusing", "disableSourceInformation", "dispose", "dispose$runtime_release", "doCompose", "doRecordDownsFor", "nearestCommonRoot", "enableReusing", "end", "isNode", "endDefaults", "endGroup", "endMovableGroup", "endNode", "endProviders", "endReplaceableGroup", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "endReusableGroup", "endRoot", "endToMarker", "marker", "ensureWriter", "enterGroup", "newPending", "exitGroup", "expectedNodeCount", "finalizeCompose", "forceRecomposeScopes$runtime_release", "insertMovableContent", "Landroidx/compose/runtime/MovableContent;", "parameter", "insertMovableContentGuarded", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "insertMovableContentReferences", "insertedGroupVirtualIndex", "index", "invokeMovableContentLambda", "locals", "force", "joinKey", "left", "right", "nextSlot", "nodeIndexOf", "groupLocation", "recomposeIndex", "parentKey", "parentKey$runtime_release", "prepareCompose", "prepareCompose$runtime_release", "realizeDowns", "nodes", "", "([Ljava/lang/Object;)V", "realizeMovement", "realizeOperationLocation", "forParent", "realizeUps", "recompose", "recompose$runtime_release", "recomposeMovableContent", "R", "from", "to", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ControlledComposition;Ljava/lang/Integer;Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "recomposeToGroupEnd", "record", "change", "recordApplierOperation", "recordDelete", "recordDown", "recordEndGroup", "recordEndRoot", "recordFixup", "recordInsert", "anchor", "recordInsertUpFixup", "recordMoveNode", "count", "recordReaderMoving", "location", "recordRemoveNode", "recordSideEffect", "effect", "recordSlotEditing", "recordSlotEditingOperation", "recordSlotTableOperation", "recordUp", "recordUpsAndDowns", "oldGroup", "newGroup", "commonRoot", "recordUsed", "scope", "registerInsertUpFixup", "releaseMovableGroupAtCurrent", "reference", "rememberedValue", "reportAllMovableContent", "reportFreeMovableContent", "groupBeingRemoved", "resolveCompositionLocal", "(Landroidx/compose/runtime/CompositionLocal;Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)Ljava/lang/Object;", "skipCurrentGroup", "skipGroup", "skipReaderToGroupEnd", "skipToGroupEnd", "sourceInformation", "", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "start", "objectKey", "kind", "Landroidx/compose/runtime/GroupKind;", "data", "start-BaiHCIY", "(ILjava/lang/Object;ILjava/lang/Object;)V", "startDefaults", "startGroup", "dataKey", "startMovableGroup", "startNode", "startProviders", "values", "Landroidx/compose/runtime/ProvidedValue;", "([Landroidx/compose/runtime/ProvidedValue;)V", "startReaderGroup", "startReplaceableGroup", "startRestartGroup", "startReusableGroup", "startReusableNode", "startRoot", "tryImminentInvalidation", "instance", "tryImminentInvalidation$runtime_release", "updateCachedValue", "updateCompoundKeyWhenWeEnterGroup", "groupKey", "updateCompoundKeyWhenWeEnterGroupKeyHash", "keyHash", "updateCompoundKeyWhenWeExitGroup", "updateCompoundKeyWhenWeExitGroupKeyHash", "updateNodeCount", "updateNodeCountOverrides", "newCount", "updateProviderMapGroup", "parentScope", "currentProviders", "updateRememberedValue", "updateValue", "updatedNodeCount", "useNode", "validateNodeExpected", "validateNodeNotExpected", "verifyConsistent", "verifyConsistent$runtime_release", "withChanges", "newChanges", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withReader", "(Landroidx/compose/runtime/SlotReader;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "groupCompoundKeyPart", "nodeAt", "CompositionContextHolder", "CompositionContextImpl", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composer.kt */
public final class ComposerImpl implements Composer {
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    /* access modifiers changed from: private */
    public List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes;
    /* access modifiers changed from: private */
    public int childrenComposing;
    private final ControlledComposition composition;
    private int compositionToken;
    private int compoundKeyHash;
    private List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> deferredChanges;
    private Stack<Object> downNodes;
    private final IntStack entersStack = new IntStack();
    private boolean forceRecomposeScopes;
    /* access modifiers changed from: private */
    public boolean forciblyRecompose;
    private int groupNodeCount;
    private IntStack groupNodeCountStack = new IntStack();
    private boolean implicitRootStart;
    private Anchor insertAnchor;
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> insertFixups;
    private SlotTable insertTable;
    private final Stack<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> insertUpFixups;
    private boolean inserting;
    private final Stack<RecomposeScopeImpl> invalidateStack = new Stack<>();
    private final List<Invalidation> invalidations = new ArrayList();
    private boolean isComposing;
    private boolean isDisposed;
    private List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> lateChanges;
    /* access modifiers changed from: private */
    public int[] nodeCountOverrides;
    private HashMap<Integer, Integer> nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;
    private IntStack nodeIndexStack = new IntStack();
    /* access modifiers changed from: private */
    public final CompositionContext parentContext;
    private PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> parentProvider = ExtensionsKt.persistentHashMapOf();
    private Pending pending;
    private final Stack<Pending> pendingStack = new Stack<>();
    private int pendingUps;
    private int previousCount;
    private int previousMoveFrom;
    private int previousMoveTo;
    private int previousRemove;
    private PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> providerCache;
    private final IntMap<PersistentMap<CompositionLocal<Object>, State<Object>>> providerUpdates = new IntMap<>(0, 1, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public boolean providersInvalid;
    private final IntStack providersInvalidStack = new IntStack();
    /* access modifiers changed from: private */
    public SlotReader reader;
    private boolean reusing;
    private int reusingGroup = -1;
    /* access modifiers changed from: private */
    public final SlotTable slotTable;
    private Snapshot snapshot = SnapshotKt.currentSnapshot();
    private boolean sourceInformationEnabled = true;
    private boolean startedGroup;
    private final IntStack startedGroups;
    private SlotWriter writer;
    private boolean writerHasAProvider;
    private int writersReaderDelta;

    public static /* synthetic */ void getCompoundKeyHash$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getDefaultsInvalid$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getInserting$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getSkipping$annotations() {
    }

    public ComposerImpl(Applier<?> applier2, CompositionContext parentContext2, SlotTable slotTable2, Set<RememberObserver> abandonSet2, List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes2, List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> lateChanges2, ControlledComposition composition2) {
        Applier<?> applier3 = applier2;
        CompositionContext compositionContext = parentContext2;
        SlotTable slotTable3 = slotTable2;
        Set<RememberObserver> set = abandonSet2;
        List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list = changes2;
        List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list2 = lateChanges2;
        ControlledComposition controlledComposition = composition2;
        Intrinsics.checkNotNullParameter(applier3, "applier");
        Intrinsics.checkNotNullParameter(compositionContext, "parentContext");
        Intrinsics.checkNotNullParameter(slotTable3, "slotTable");
        Intrinsics.checkNotNullParameter(set, "abandonSet");
        Intrinsics.checkNotNullParameter(list, "changes");
        Intrinsics.checkNotNullParameter(list2, "lateChanges");
        Intrinsics.checkNotNullParameter(controlledComposition, "composition");
        this.applier = applier3;
        this.parentContext = compositionContext;
        this.slotTable = slotTable3;
        this.abandonSet = set;
        this.changes = list;
        this.lateChanges = list2;
        this.composition = controlledComposition;
        SlotReader it = slotTable2.openReader();
        it.close();
        this.reader = it;
        SlotTable slotTable4 = new SlotTable();
        this.insertTable = slotTable4;
        SlotWriter it2 = slotTable4.openWriter();
        it2.close();
        this.writer = it2;
        SlotReader reader$iv = this.insertTable.openReader();
        try {
            Anchor anchor = reader$iv.anchor(0);
            reader$iv.close();
            this.insertAnchor = anchor;
            this.insertFixups = new ArrayList();
            this.downNodes = new Stack<>();
            this.implicitRootStart = true;
            this.startedGroups = new IntStack();
            this.insertUpFixups = new Stack<>();
            this.previousRemove = -1;
            this.previousMoveFrom = -1;
            this.previousMoveTo = -1;
        } catch (Throwable th) {
            Throwable th2 = th;
            reader$iv.close();
            throw th2;
        }
    }

    public Applier<?> getApplier() {
        return this.applier;
    }

    public ControlledComposition getComposition() {
        return this.composition;
    }

    public final boolean isComposing$runtime_release() {
        return this.isComposing;
    }

    public final boolean isDisposed$runtime_release() {
        return this.isDisposed;
    }

    public final boolean getAreChildrenComposing$runtime_release() {
        return this.childrenComposing > 0;
    }

    public final boolean getHasPendingChanges$runtime_release() {
        return !this.changes.isEmpty();
    }

    public final SlotTable getInsertTable$runtime_release() {
        return this.insertTable;
    }

    public final void setInsertTable$runtime_release(SlotTable slotTable2) {
        Intrinsics.checkNotNullParameter(slotTable2, "<set-?>");
        this.insertTable = slotTable2;
    }

    public final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> getDeferredChanges$runtime_release() {
        return this.deferredChanges;
    }

    public final void setDeferredChanges$runtime_release(List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list) {
        this.deferredChanges = list;
    }

    public CoroutineContext getApplyCoroutineContext() {
        return this.parentContext.getEffectCoroutineContext$runtime_release();
    }

    @ComposeCompilerApi
    public void startReplaceableGroup(int key) {
        m2765startBaiHCIY(key, (Object) null, GroupKind.Companion.m2775getGroupULZAiWs(), (Object) null);
    }

    @ComposeCompilerApi
    public void endReplaceableGroup() {
        endGroup();
    }

    @ComposeCompilerApi
    public void startDefaults() {
        m2765startBaiHCIY(-127, (Object) null, GroupKind.Companion.m2775getGroupULZAiWs(), (Object) null);
    }

    @ComposeCompilerApi
    public void endDefaults() {
        endGroup();
        RecomposeScopeImpl scope = getCurrentRecomposeScope$runtime_release();
        if (scope != null && scope.getUsed()) {
            scope.setDefaultsInScope(true);
        }
    }

    public boolean getDefaultsInvalid() {
        if (this.providersInvalid) {
            return true;
        }
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        return currentRecomposeScope$runtime_release != null && currentRecomposeScope$runtime_release.getDefaultsInvalid();
    }

    @ComposeCompilerApi
    public void startMovableGroup(int key, Object dataKey) {
        m2765startBaiHCIY(key, dataKey, GroupKind.Companion.m2775getGroupULZAiWs(), (Object) null);
    }

    @ComposeCompilerApi
    public void endMovableGroup() {
        endGroup();
    }

    private final void startRoot() {
        this.reader = this.slotTable.openReader();
        startGroup(100);
        this.parentContext.startComposing$runtime_release();
        this.parentProvider = this.parentContext.getCompositionLocalScope$runtime_release();
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = changed((Object) this.parentProvider);
        this.providerCache = null;
        if (!this.forceRecomposeScopes) {
            this.forceRecomposeScopes = this.parentContext.getCollectingParameterInformation$runtime_release();
        }
        Set it = (Set) resolveCompositionLocal(InspectionTablesKt.getLocalInspectionTables(), this.parentProvider);
        if (it != null) {
            it.add(this.slotTable);
            this.parentContext.recordInspectionTable$runtime_release(it);
        }
        startGroup(this.parentContext.getCompoundHashKey$runtime_release());
    }

    private final void endRoot() {
        endGroup();
        this.parentContext.doneComposing$runtime_release();
        endGroup();
        recordEndRoot();
        finalizeCompose();
        this.reader.close();
        this.forciblyRecompose = false;
    }

    private final void abortRoot() {
        cleanUpCompose();
        this.pendingStack.clear();
        this.nodeIndexStack.clear();
        this.groupNodeCountStack.clear();
        this.entersStack.clear();
        this.providersInvalidStack.clear();
        this.providerUpdates.clear();
        if (!this.reader.getClosed()) {
            this.reader.close();
        }
        if (!this.writer.getClosed()) {
            this.writer.close();
        }
        createFreshInsertTable();
        this.compoundKeyHash = 0;
        this.childrenComposing = 0;
        this.nodeExpected = false;
        this.inserting = false;
        this.reusing = false;
        this.isComposing = false;
        this.forciblyRecompose = false;
    }

    public final void changesApplied$runtime_release() {
        this.providerUpdates.clear();
    }

    public boolean getInserting() {
        return this.inserting;
    }

    public boolean getSkipping() {
        if (getInserting() || this.reusing || this.providersInvalid) {
            return false;
        }
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (!(currentRecomposeScope$runtime_release != null && !currentRecomposeScope$runtime_release.getRequiresRecompose()) || this.forciblyRecompose) {
            return false;
        }
        return true;
    }

    public int getCompoundKeyHash() {
        return this.compoundKeyHash;
    }

    public void collectParameterInformation() {
        this.forceRecomposeScopes = true;
    }

    public final void dispose$runtime_release() {
        Object token$iv = Trace.INSTANCE.beginSection("Compose:Composer.dispose");
        try {
            this.parentContext.unregisterComposer$runtime_release(this);
            this.invalidateStack.clear();
            this.invalidations.clear();
            this.changes.clear();
            this.providerUpdates.clear();
            getApplier().clear();
            this.isDisposed = true;
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.INSTANCE.endSection(token$iv);
        }
    }

    public final boolean forceRecomposeScopes$runtime_release() {
        if (this.forceRecomposeScopes) {
            return false;
        }
        this.forceRecomposeScopes = true;
        this.forciblyRecompose = true;
        return true;
    }

    private final void startGroup(int key) {
        m2765startBaiHCIY(key, (Object) null, GroupKind.Companion.m2775getGroupULZAiWs(), (Object) null);
    }

    /* access modifiers changed from: private */
    public final void startGroup(int key, Object dataKey) {
        m2765startBaiHCIY(key, dataKey, GroupKind.Companion.m2775getGroupULZAiWs(), (Object) null);
    }

    /* access modifiers changed from: private */
    public final void endGroup() {
        end(false);
    }

    private final void skipGroup() {
        this.groupNodeCount += this.reader.skipGroup();
    }

    public void startNode() {
        m2765startBaiHCIY(125, (Object) null, GroupKind.Companion.m2776getNodeULZAiWs(), (Object) null);
        this.nodeExpected = true;
    }

    public void startReusableNode() {
        m2765startBaiHCIY(125, (Object) null, GroupKind.Companion.m2777getReusableNodeULZAiWs(), (Object) null);
        this.nodeExpected = true;
    }

    public <T> void createNode(Function0<? extends T> factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        validateNodeExpected();
        if (getInserting()) {
            int insertIndex = this.nodeIndexStack.peek();
            SlotWriter slotWriter = this.writer;
            Anchor groupAnchor = slotWriter.anchor(slotWriter.getParent());
            this.groupNodeCount++;
            recordFixup(new ComposerImpl$createNode$2(factory, groupAnchor, insertIndex));
            recordInsertUpFixup(new ComposerImpl$createNode$3(groupAnchor, insertIndex));
            return;
        }
        ComposerKt.composeRuntimeError("createNode() can only be called when inserting".toString());
        throw new KotlinNothingValueException();
    }

    public void useNode() {
        validateNodeExpected();
        if (!getInserting()) {
            Object node = getNode(this.reader);
            recordDown(node);
            if (this.reusing && (node instanceof ComposeNodeLifecycleCallback)) {
                recordApplierOperation(ComposerImpl$useNode$2.INSTANCE);
                return;
            }
            return;
        }
        ComposerKt.composeRuntimeError("useNode() called while inserting".toString());
        throw new KotlinNothingValueException();
    }

    public void endNode() {
        end(true);
    }

    public void startReusableGroup(int key, Object dataKey) {
        if (this.reader.getGroupKey() == key && !Intrinsics.areEqual(this.reader.getGroupAux(), dataKey) && this.reusingGroup < 0) {
            this.reusingGroup = this.reader.getCurrentGroup();
            this.reusing = true;
        }
        m2765startBaiHCIY(key, (Object) null, GroupKind.Companion.m2775getGroupULZAiWs(), dataKey);
    }

    public void endReusableGroup() {
        if (this.reusing && this.reader.getParent() == this.reusingGroup) {
            this.reusingGroup = -1;
            this.reusing = false;
        }
        end(false);
    }

    public void disableReusing() {
        this.reusing = false;
    }

    public void enableReusing() {
        this.reusing = this.reusingGroup >= 0;
    }

    public int getCurrentMarker() {
        return getInserting() ? -this.writer.getParent() : this.reader.getParent();
    }

    public void endToMarker(int marker) {
        if (marker < 0) {
            int writerLocation = -marker;
            while (this.writer.getParent() > writerLocation) {
                end(false);
            }
            return;
        }
        while (this.reader.getParent() > marker) {
            end(false);
        }
    }

    public <V, T> void apply(V value, Function2<? super T, ? super V, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Function3 operation = new ComposerImpl$apply$operation$1(block, value);
        if (getInserting()) {
            recordFixup(operation);
        } else {
            recordApplierOperation(operation);
        }
    }

    @ComposeCompilerApi
    public Object joinKey(Object left, Object right) {
        Object access$getKey = ComposerKt.getKey(this.reader.getGroupObjectKey(), left, right);
        return access$getKey == null ? new JoinedKey(left, right) : access$getKey;
    }

    public final Object nextSlot() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.Companion.getEmpty();
        }
        return this.reusing ? Composer.Companion.getEmpty() : this.reader.next();
    }

    @ComposeCompilerApi
    public boolean changed(Object value) {
        if (Intrinsics.areEqual(nextSlot(), value)) {
            return false;
        }
        updateValue(value);
        return true;
    }

    @ComposeCompilerApi
    public boolean changedInstance(Object value) {
        if (nextSlot() == value) {
            return false;
        }
        updateValue(value);
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(char value) {
        Object next = nextSlot();
        if ((next instanceof Character) && value == ((Character) next).charValue()) {
            return false;
        }
        updateValue(Character.valueOf(value));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(byte value) {
        Object next = nextSlot();
        if ((next instanceof Byte) && value == ((Number) next).byteValue()) {
            return false;
        }
        updateValue(Byte.valueOf(value));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(short value) {
        Object next = nextSlot();
        if ((next instanceof Short) && value == ((Number) next).shortValue()) {
            return false;
        }
        updateValue(Short.valueOf(value));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(boolean value) {
        Object next = nextSlot();
        if ((next instanceof Boolean) && value == ((Boolean) next).booleanValue()) {
            return false;
        }
        updateValue(Boolean.valueOf(value));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(float value) {
        Object next = nextSlot();
        if (next instanceof Float) {
            if (value == ((Number) next).floatValue()) {
                return false;
            }
        }
        updateValue(Float.valueOf(value));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(long value) {
        Object next = nextSlot();
        if ((next instanceof Long) && value == ((Number) next).longValue()) {
            return false;
        }
        updateValue(Long.valueOf(value));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(double value) {
        Object next = nextSlot();
        if (next instanceof Double) {
            if (value == ((Number) next).doubleValue()) {
                return false;
            }
        }
        updateValue(Double.valueOf(value));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(int value) {
        Object next = nextSlot();
        if ((next instanceof Integer) && value == ((Number) next).intValue()) {
            return false;
        }
        updateValue(Integer.valueOf(value));
        return true;
    }

    @ComposeCompilerApi
    public final <T> T cache(boolean invalid, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Object result = nextSlot();
        if (result != Composer.Companion.getEmpty() && !invalid) {
            return result;
        }
        Object value = block.invoke();
        updateValue(value);
        return value;
    }

    public final void updateValue(Object value) {
        if (getInserting()) {
            this.writer.update(value);
            if (value instanceof RememberObserver) {
                record(new ComposerImpl$updateValue$1(value));
                this.abandonSet.add(value);
                return;
            }
            return;
        }
        int groupSlotIndex = this.reader.getGroupSlotIndex() - 1;
        if (value instanceof RememberObserver) {
            this.abandonSet.add(value);
        }
        recordSlotTableOperation(true, new ComposerImpl$updateValue$2(value, groupSlotIndex));
    }

    public final void updateCachedValue(Object value) {
        updateValue(value);
    }

    public CompositionData getCompositionData() {
        return this.slotTable;
    }

    public void recordSideEffect(Function0<Unit> effect) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        record(new ComposerImpl$recordSideEffect$1(effect));
    }

    private final PersistentMap<CompositionLocal<Object>, State<Object>> currentCompositionLocalScope() {
        PersistentMap it = this.providerCache;
        if (it != null) {
            return it;
        }
        return currentCompositionLocalScope(this.reader.getParent());
    }

    private final PersistentMap<CompositionLocal<Object>, State<Object>> currentCompositionLocalScope(int group) {
        if (getInserting() && this.writerHasAProvider) {
            int current = this.writer.getParent();
            while (current > 0) {
                if (this.writer.groupKey(current) != 202 || !Intrinsics.areEqual(this.writer.groupObjectKey(current), ComposerKt.getCompositionLocalMap())) {
                    current = this.writer.parent(current);
                } else {
                    Object groupAux = this.writer.groupAux(current);
                    Intrinsics.checkNotNull(groupAux, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
                    PersistentMap providers = (PersistentMap) groupAux;
                    this.providerCache = providers;
                    return providers;
                }
            }
        }
        if (this.reader.getSize() > 0) {
            int current2 = group;
            while (current2 > 0) {
                if (this.reader.groupKey(current2) != 202 || !Intrinsics.areEqual(this.reader.groupObjectKey(current2), ComposerKt.getCompositionLocalMap())) {
                    current2 = this.reader.parent(current2);
                } else {
                    PersistentMap persistentMap = this.providerUpdates.get(current2);
                    if (persistentMap == null) {
                        Object groupAux2 = this.reader.groupAux(current2);
                        Intrinsics.checkNotNull(groupAux2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
                        persistentMap = (PersistentMap) groupAux2;
                    }
                    PersistentMap providers2 = persistentMap;
                    this.providerCache = providers2;
                    return providers2;
                }
            }
        }
        PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap2 = this.parentProvider;
        this.providerCache = persistentMap2;
        return persistentMap2;
    }

    private final PersistentMap<CompositionLocal<Object>, State<Object>> updateProviderMapGroup(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> parentScope, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> currentProviders) {
        PersistentMap.Builder<CompositionLocal<Object>, ? extends State<? extends Object>> it = parentScope.builder();
        it.putAll(currentProviders);
        PersistentMap providerScope = it.build();
        startGroup(ComposerKt.providerMapsKey, ComposerKt.getProviderMaps());
        changed((Object) providerScope);
        changed((Object) currentProviders);
        endGroup();
        return providerScope;
    }

    public void startProviders(ProvidedValue<?>[] values) {
        boolean invalid;
        PersistentMap providers;
        Intrinsics.checkNotNullParameter(values, "values");
        PersistentMap parentScope = currentCompositionLocalScope();
        startGroup(ComposerKt.providerKey, ComposerKt.getProvider());
        startGroup(ComposerKt.providerValuesKey, ComposerKt.getProviderValues());
        PersistentMap currentProviders = (PersistentMap) ActualJvm_jvmKt.invokeComposableForResult(this, new ComposerImpl$startProviders$currentProviders$1(values, parentScope));
        endGroup();
        if (getInserting()) {
            providers = updateProviderMapGroup(parentScope, currentProviders);
            invalid = false;
            this.writerHasAProvider = true;
        } else {
            Object groupGet = this.reader.groupGet(0);
            Intrinsics.checkNotNull(groupGet, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
            PersistentMap oldScope = (PersistentMap) groupGet;
            Object groupGet2 = this.reader.groupGet(1);
            Intrinsics.checkNotNull(groupGet2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
            PersistentMap oldValues = (PersistentMap) groupGet2;
            if (!getSkipping() || !Intrinsics.areEqual((Object) oldValues, (Object) currentProviders)) {
                providers = updateProviderMapGroup(parentScope, currentProviders);
                invalid = true ^ Intrinsics.areEqual((Object) providers, (Object) oldScope);
            } else {
                skipGroup();
                providers = oldScope;
                invalid = false;
            }
        }
        if (invalid && !getInserting()) {
            this.providerUpdates.set(this.reader.getCurrentGroup(), providers);
        }
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = invalid;
        this.providerCache = providers;
        m2765startBaiHCIY(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.m2775getGroupULZAiWs(), providers);
    }

    public void endProviders() {
        endGroup();
        endGroup();
        this.providersInvalid = ComposerKt.asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    public <T> T consume(CompositionLocal<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return resolveCompositionLocal(key, currentCompositionLocalScope());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: androidx.compose.runtime.ComposerImpl$CompositionContextHolder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.runtime.CompositionContext buildContext() {
        /*
            r5 = this;
            r0 = 206(0xce, float:2.89E-43)
            java.lang.Object r1 = androidx.compose.runtime.ComposerKt.getReference()
            r5.startGroup(r0, r1)
            boolean r0 = r5.getInserting()
            r1 = 0
            if (r0 == 0) goto L_0x0017
            androidx.compose.runtime.SlotWriter r0 = r5.writer
            r2 = 0
            r3 = 1
            androidx.compose.runtime.SlotWriter.markGroup$default(r0, r2, r3, r1)
        L_0x0017:
            java.lang.Object r0 = r5.nextSlot()
            boolean r2 = r0 instanceof androidx.compose.runtime.ComposerImpl.CompositionContextHolder
            if (r2 == 0) goto L_0x0022
            r1 = r0
            androidx.compose.runtime.ComposerImpl$CompositionContextHolder r1 = (androidx.compose.runtime.ComposerImpl.CompositionContextHolder) r1
        L_0x0022:
            r0 = r1
            if (r0 != 0) goto L_0x0039
            androidx.compose.runtime.ComposerImpl$CompositionContextHolder r1 = new androidx.compose.runtime.ComposerImpl$CompositionContextHolder
            androidx.compose.runtime.ComposerImpl$CompositionContextImpl r2 = new androidx.compose.runtime.ComposerImpl$CompositionContextImpl
            int r3 = r5.getCompoundKeyHash()
            boolean r4 = r5.forceRecomposeScopes
            r2.<init>(r3, r4)
            r1.<init>(r2)
            r0 = r1
            r5.updateValue(r0)
        L_0x0039:
            androidx.compose.runtime.ComposerImpl$CompositionContextImpl r1 = r0.getRef()
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r2 = r5.currentCompositionLocalScope()
            r1.updateCompositionLocalScope(r2)
            r5.endGroup()
            androidx.compose.runtime.ComposerImpl$CompositionContextImpl r1 = r0.getRef()
            androidx.compose.runtime.CompositionContext r1 = (androidx.compose.runtime.CompositionContext) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.buildContext():androidx.compose.runtime.CompositionContext");
    }

    private final <T> T resolveCompositionLocal(CompositionLocal<T> key, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> scope) {
        if (ComposerKt.contains(scope, key)) {
            return ComposerKt.getValueOf(scope, key);
        }
        return key.getDefaultValueHolder$runtime_release().getValue();
    }

    public final int getChangeCount$runtime_release() {
        return this.changes.size();
    }

    public final RecomposeScopeImpl getCurrentRecomposeScope$runtime_release() {
        Stack it = this.invalidateStack;
        if (this.childrenComposing != 0 || !it.isNotEmpty()) {
            return null;
        }
        return it.peek();
    }

    private final void ensureWriter() {
        if (this.writer.getClosed()) {
            SlotWriter openWriter = this.insertTable.openWriter();
            this.writer = openWriter;
            openWriter.skipToGroupEnd();
            this.writerHasAProvider = false;
            this.providerCache = null;
        }
    }

    private final void createFreshInsertTable() {
        ComposerKt.runtimeCheck(this.writer.getClosed());
        SlotTable slotTable2 = new SlotTable();
        this.insertTable = slotTable2;
        SlotWriter it = slotTable2.openWriter();
        it.close();
        this.writer = it;
    }

    private final void startReaderGroup(boolean isNode, Object data) {
        if (isNode) {
            this.reader.startNode();
            return;
        }
        if (!(data == null || this.reader.getGroupAux() == data)) {
            recordSlotTableOperation$default(this, false, new ComposerImpl$startReaderGroup$1(data), 1, (Object) null);
        }
        this.reader.startGroup();
    }

    /* renamed from: start-BaiHCIY  reason: not valid java name */
    private final void m2765startBaiHCIY(int key, Object objectKey, int kind, Object data) {
        Pending newPending;
        int i = key;
        Object obj = objectKey;
        int i2 = kind;
        Object obj2 = data;
        validateNodeNotExpected();
        updateCompoundKeyWhenWeEnterGroup(i, obj, obj2);
        int i3 = 0;
        boolean isNode = i2 != GroupKind.Companion.m2775getGroupULZAiWs();
        if (getInserting()) {
            this.reader.beginEmpty();
            int startIndex = this.writer.getCurrentGroup();
            if (isNode) {
                this.writer.startNode(i, Composer.Companion.getEmpty());
            } else if (obj2 != null) {
                this.writer.startData(i, obj == null ? Composer.Companion.getEmpty() : obj, obj2);
            } else {
                this.writer.startGroup(i, obj == null ? Composer.Companion.getEmpty() : obj);
            }
            Pending pending2 = this.pending;
            if (pending2 != null) {
                Pending pending3 = pending2;
                KeyInfo insertKeyInfo = new KeyInfo(key, -1, insertedGroupVirtualIndex(startIndex), -1, 0);
                pending3.registerInsert(insertKeyInfo, this.nodeIndex - pending3.getStartIndex());
                pending3.recordUsed(insertKeyInfo);
            }
            enterGroup(isNode, (Pending) null);
            return;
        }
        boolean forceReplace = (i2 != GroupKind.Companion.m2776getNodeULZAiWs() ? 1 : 0) == 0 && this.reusing;
        if (this.pending == null) {
            int slotKey = this.reader.getGroupKey();
            if (forceReplace || slotKey != i || !Intrinsics.areEqual(obj, this.reader.getGroupObjectKey())) {
                this.pending = new Pending(this.reader.extractKeys(), this.nodeIndex);
            } else {
                startReaderGroup(isNode, obj2);
            }
        }
        Pending pending4 = this.pending;
        if (pending4 != null) {
            KeyInfo keyInfo = pending4.getNext(i, obj);
            if (forceReplace || keyInfo == null) {
                this.reader.beginEmpty();
                this.inserting = true;
                this.providerCache = null;
                ensureWriter();
                this.writer.beginInsert();
                int startIndex2 = this.writer.getCurrentGroup();
                if (isNode) {
                    this.writer.startNode(i, Composer.Companion.getEmpty());
                } else if (obj2 != null) {
                    this.writer.startData(i, obj == null ? Composer.Companion.getEmpty() : obj, obj2);
                } else {
                    this.writer.startGroup(i, obj == null ? Composer.Companion.getEmpty() : obj);
                }
                this.insertAnchor = this.writer.anchor(startIndex2);
                KeyInfo keyInfo2 = keyInfo;
                KeyInfo insertKeyInfo2 = new KeyInfo(key, -1, insertedGroupVirtualIndex(startIndex2), -1, 0);
                pending4.registerInsert(insertKeyInfo2, this.nodeIndex - pending4.getStartIndex());
                pending4.recordUsed(insertKeyInfo2);
                List arrayList = new ArrayList();
                if (!isNode) {
                    i3 = this.nodeIndex;
                }
                newPending = new Pending(arrayList, i3);
                enterGroup(isNode, newPending);
            }
            pending4.recordUsed(keyInfo);
            int location = keyInfo.getLocation();
            this.nodeIndex = pending4.nodePositionOf(keyInfo) + pending4.getStartIndex();
            int relativePosition = pending4.slotPositionOf(keyInfo);
            int currentRelativePosition = relativePosition - pending4.getGroupIndex();
            pending4.registerMoveSlot(relativePosition, pending4.getGroupIndex());
            recordReaderMoving(location);
            this.reader.reposition(location);
            if (currentRelativePosition > 0) {
                recordSlotEditingOperation(new ComposerImpl$start$2(currentRelativePosition));
            }
            startReaderGroup(isNode, obj2);
        }
        newPending = null;
        enterGroup(isNode, newPending);
    }

    private final void enterGroup(boolean isNode, Pending newPending) {
        this.pendingStack.push(this.pending);
        this.pending = newPending;
        this.nodeIndexStack.push(this.nodeIndex);
        if (isNode) {
            this.nodeIndex = 0;
        }
        this.groupNodeCountStack.push(this.groupNodeCount);
        this.groupNodeCount = 0;
    }

    private final void exitGroup(int expectedNodeCount, boolean inserting2) {
        Pending previousPending = this.pendingStack.pop();
        if (previousPending != null && !inserting2) {
            previousPending.setGroupIndex(previousPending.getGroupIndex() + 1);
        }
        this.pending = previousPending;
        this.nodeIndex = this.nodeIndexStack.pop() + expectedNodeCount;
        this.groupNodeCount = this.groupNodeCountStack.pop() + expectedNodeCount;
    }

    private final void end(boolean isNode) {
        if (getInserting()) {
            int parent = this.writer.getParent();
            updateCompoundKeyWhenWeExitGroup(this.writer.groupKey(parent), this.writer.groupObjectKey(parent), this.writer.groupAux(parent));
        } else {
            int parent2 = this.reader.getParent();
            updateCompoundKeyWhenWeExitGroup(this.reader.groupKey(parent2), this.reader.groupObjectKey(parent2), this.reader.groupAux(parent2));
        }
        int expectedNodeCount = this.groupNodeCount;
        Pending pending2 = this.pending;
        if (pending2 != null && pending2.getKeyInfos().size() > 0) {
            List previous = pending2.getKeyInfos();
            List current = pending2.getUsed();
            Set usedKeys = ListUtilsKt.fastToSet(current);
            Set placedKeys = new LinkedHashSet();
            int currentIndex = 0;
            int currentEnd = current.size();
            int previousIndex = 0;
            int previousEnd = previous.size();
            int nodeOffset = 0;
            while (previousIndex < previousEnd) {
                KeyInfo previousInfo = previous.get(previousIndex);
                if (!usedKeys.contains(previousInfo)) {
                    recordRemoveNode(pending2.getStartIndex() + pending2.nodePositionOf(previousInfo), previousInfo.getNodes());
                    pending2.updateNodeCount(previousInfo.getLocation(), 0);
                    recordReaderMoving(previousInfo.getLocation());
                    this.reader.reposition(previousInfo.getLocation());
                    recordDelete();
                    this.reader.skipGroup();
                    ComposerKt.removeRange(this.invalidations, previousInfo.getLocation(), previousInfo.getLocation() + this.reader.groupSize(previousInfo.getLocation()));
                    previousIndex++;
                    usedKeys = usedKeys;
                    previousEnd = previousEnd;
                } else {
                    Set usedKeys2 = usedKeys;
                    int previousEnd2 = previousEnd;
                    if (placedKeys.contains(previousInfo)) {
                        previousIndex++;
                        usedKeys = usedKeys2;
                        previousEnd = previousEnd2;
                    } else if (currentIndex < currentEnd) {
                        KeyInfo currentInfo = current.get(currentIndex);
                        if (currentInfo != previousInfo) {
                            int nodePosition = pending2.nodePositionOf(currentInfo);
                            placedKeys.add(currentInfo);
                            if (nodePosition != nodeOffset) {
                                int updatedCount = pending2.updatedNodeCountOf(currentInfo);
                                recordMoveNode(pending2.getStartIndex() + nodePosition, pending2.getStartIndex() + nodeOffset, updatedCount);
                                pending2.registerMoveNode(nodePosition, nodeOffset, updatedCount);
                            }
                        } else {
                            previousIndex++;
                        }
                        currentIndex++;
                        nodeOffset += pending2.updatedNodeCountOf(currentInfo);
                        usedKeys = usedKeys2;
                        previousEnd = previousEnd2;
                    } else {
                        usedKeys = usedKeys2;
                        previousEnd = previousEnd2;
                    }
                }
            }
            int i = previousEnd;
            realizeMovement();
            if (previous.size() > 0) {
                recordReaderMoving(this.reader.getGroupEnd());
                this.reader.skipToGroupEnd();
            }
        }
        int removeIndex = this.nodeIndex;
        while (!this.reader.isGroupEnd()) {
            int startSlot = this.reader.getCurrentGroup();
            recordDelete();
            recordRemoveNode(removeIndex, this.reader.skipGroup());
            ComposerKt.removeRange(this.invalidations, startSlot, this.reader.getCurrentGroup());
        }
        boolean inserting2 = getInserting();
        if (inserting2) {
            if (isNode) {
                registerInsertUpFixup();
                expectedNodeCount = 1;
            }
            this.reader.endEmpty();
            int parentGroup = this.writer.getParent();
            this.writer.endGroup();
            if (!this.reader.getInEmpty()) {
                int virtualIndex = insertedGroupVirtualIndex(parentGroup);
                this.writer.endInsert();
                this.writer.close();
                recordInsert(this.insertAnchor);
                this.inserting = false;
                if (!this.slotTable.isEmpty()) {
                    updateNodeCount(virtualIndex, 0);
                    updateNodeCountOverrides(virtualIndex, expectedNodeCount);
                }
            }
        } else {
            if (isNode) {
                recordUp();
            }
            recordEndGroup();
            int parentGroup2 = this.reader.getParent();
            if (expectedNodeCount != updatedNodeCount(parentGroup2)) {
                updateNodeCountOverrides(parentGroup2, expectedNodeCount);
            }
            if (isNode) {
                expectedNodeCount = 1;
            }
            this.reader.endGroup();
            realizeMovement();
        }
        exitGroup(expectedNodeCount, inserting2);
    }

    private final void recomposeToGroupEnd() {
        boolean wasComposing = this.isComposing;
        this.isComposing = true;
        boolean recomposed = false;
        int parent = this.reader.getParent();
        int end = this.reader.groupSize(parent) + parent;
        int recomposeIndex = this.nodeIndex;
        int recomposeCompoundKey = getCompoundKeyHash();
        int oldGroupNodeCount = this.groupNodeCount;
        int oldGroup = parent;
        Invalidation firstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), end);
        while (firstInRange != null) {
            int location = firstInRange.getLocation();
            Invalidation unused = ComposerKt.removeLocation(this.invalidations, location);
            if (firstInRange.isInvalid()) {
                recomposed = true;
                this.reader.reposition(location);
                int newGroup = this.reader.getCurrentGroup();
                recordUpsAndDowns(oldGroup, newGroup, parent);
                oldGroup = newGroup;
                this.nodeIndex = nodeIndexOf(location, newGroup, parent, recomposeIndex);
                this.compoundKeyHash = compoundKeyOf(this.reader.parent(newGroup), parent, recomposeCompoundKey);
                this.providerCache = null;
                firstInRange.getScope().compose(this);
                this.providerCache = null;
                this.reader.restoreParent(parent);
            } else {
                this.invalidateStack.push(firstInRange.getScope());
                firstInRange.getScope().rereadTrackedInstances();
                this.invalidateStack.pop();
            }
            firstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), end);
        }
        if (recomposed) {
            recordUpsAndDowns(oldGroup, parent, parent);
            this.reader.skipToGroupEnd();
            int parentGroupNodes = updatedNodeCount(parent);
            this.nodeIndex = recomposeIndex + parentGroupNodes;
            this.groupNodeCount = oldGroupNodeCount + parentGroupNodes;
        } else {
            skipReaderToGroupEnd();
        }
        this.compoundKeyHash = recomposeCompoundKey;
        this.isComposing = wasComposing;
    }

    private final int insertedGroupVirtualIndex(int index) {
        return -2 - index;
    }

    private final void updateNodeCountOverrides(int group, int newCount) {
        int currentCount = updatedNodeCount(group);
        if (currentCount != newCount) {
            int delta = newCount - currentCount;
            int current = group;
            int minPending = this.pendingStack.getSize() - 1;
            while (current != -1) {
                int newCurrentNodes = updatedNodeCount(current) + delta;
                updateNodeCount(current, newCurrentNodes);
                int pendingIndex = minPending;
                while (true) {
                    if (-1 < pendingIndex) {
                        Pending pending2 = this.pendingStack.peek(pendingIndex);
                        if (pending2 != null && pending2.updateNodeCount(current, newCurrentNodes)) {
                            minPending = pendingIndex - 1;
                            break;
                        }
                        pendingIndex--;
                    } else {
                        break;
                    }
                }
                if (current < 0) {
                    current = this.reader.getParent();
                } else if (!this.reader.isNode(current)) {
                    current = this.reader.parent(current);
                } else {
                    return;
                }
            }
        }
    }

    private final int nodeIndexOf(int groupLocation, int group, int recomposeGroup, int recomposeIndex) {
        int anchorGroup = this.reader.parent(group);
        while (anchorGroup != recomposeGroup && !this.reader.isNode(anchorGroup)) {
            anchorGroup = this.reader.parent(anchorGroup);
        }
        int index = this.reader.isNode(anchorGroup) ? 0 : recomposeIndex;
        if (anchorGroup == group) {
            return index;
        }
        int current = anchorGroup;
        int nodeIndexLimit = (updatedNodeCount(anchorGroup) - this.reader.nodeCount(group)) + index;
        loop1:
        while (index < nodeIndexLimit && current != groupLocation) {
            current++;
            while (true) {
                if (current >= groupLocation) {
                    break loop1;
                }
                int end = this.reader.groupSize(current) + current;
                if (groupLocation >= end) {
                    index += updatedNodeCount(current);
                    current = end;
                }
            }
        }
        return index;
    }

    private final int updatedNodeCount(int group) {
        int override;
        Integer num;
        if (group < 0) {
            HashMap it = this.nodeCountVirtualOverrides;
            if (it == null || (num = it.get(Integer.valueOf(group))) == null) {
                return 0;
            }
            return num.intValue();
        }
        int[] nodeCounts = this.nodeCountOverrides;
        if (nodeCounts == null || (override = nodeCounts[group]) < 0) {
            return this.reader.nodeCount(group);
        }
        return override;
    }

    private final void updateNodeCount(int group, int count) {
        if (updatedNodeCount(group) == count) {
            return;
        }
        if (group < 0) {
            HashMap virtualCounts = this.nodeCountVirtualOverrides;
            if (virtualCounts == null) {
                HashMap newCounts = new HashMap();
                this.nodeCountVirtualOverrides = newCounts;
                virtualCounts = newCounts;
            }
            virtualCounts.put(Integer.valueOf(group), Integer.valueOf(count));
            return;
        }
        int[] nodeCounts = this.nodeCountOverrides;
        if (nodeCounts == null) {
            ComposerImpl $this$updateNodeCount_u24lambda_u2415 = this;
            int[] newCounts2 = new int[$this$updateNodeCount_u24lambda_u2415.reader.getSize()];
            ArraysKt.fill$default(newCounts2, -1, 0, 0, 6, (Object) null);
            $this$updateNodeCount_u24lambda_u2415.nodeCountOverrides = newCounts2;
            nodeCounts = newCounts2;
        }
        nodeCounts[group] = count;
    }

    private final void clearUpdatedNodeCounts() {
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    private final void recordUpsAndDowns(int oldGroup, int newGroup, int commonRoot) {
        SlotReader reader2 = this.reader;
        int nearestCommonRoot = ComposerKt.nearestCommonRootOf(reader2, oldGroup, newGroup, commonRoot);
        int current = oldGroup;
        while (current > 0 && current != nearestCommonRoot) {
            if (reader2.isNode(current)) {
                recordUp();
            }
            current = reader2.parent(current);
        }
        doRecordDownsFor(newGroup, nearestCommonRoot);
    }

    private final void doRecordDownsFor(int group, int nearestCommonRoot) {
        if (group > 0 && group != nearestCommonRoot) {
            doRecordDownsFor(this.reader.parent(group), nearestCommonRoot);
            if (this.reader.isNode(group)) {
                recordDown(nodeAt(this.reader, group));
            }
        }
    }

    private final int compoundKeyOf(int group, int recomposeGroup, int recomposeKey) {
        if (group == recomposeGroup) {
            return recomposeKey;
        }
        ComposerImpl $this$compoundKeyOf_u24lambda_u2416 = this;
        int groupKey = $this$compoundKeyOf_u24lambda_u2416.groupCompoundKeyPart($this$compoundKeyOf_u24lambda_u2416.reader, group);
        if (groupKey == 126665345) {
            return groupKey;
        }
        return Integer.rotateLeft($this$compoundKeyOf_u24lambda_u2416.compoundKeyOf($this$compoundKeyOf_u24lambda_u2416.reader.parent(group), recomposeGroup, recomposeKey), 3) ^ groupKey;
    }

    private final int groupCompoundKeyPart(SlotReader $this$groupCompoundKeyPart, int group) {
        Object aux;
        if ($this$groupCompoundKeyPart.hasObjectKey(group)) {
            Object it = $this$groupCompoundKeyPart.groupObjectKey(group);
            if (it == null) {
                return 0;
            }
            if (it instanceof Enum) {
                return ((Enum) it).ordinal();
            }
            if (it instanceof MovableContent) {
                return MovableContentKt.movableContentKey;
            }
            return it.hashCode();
        }
        int it2 = $this$groupCompoundKeyPart.groupKey(group);
        if (it2 != 207 || (aux = $this$groupCompoundKeyPart.groupAux(group)) == null) {
            return it2;
        }
        return Intrinsics.areEqual(aux, Composer.Companion.getEmpty()) ? it2 : aux.hashCode();
    }

    public final boolean tryImminentInvalidation$runtime_release(RecomposeScopeImpl scope, Object instance) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Anchor anchor = scope.getAnchor();
        if (anchor == null) {
            return false;
        }
        int location = anchor.toIndexFor(this.slotTable);
        if (!this.isComposing || location < this.reader.getCurrentGroup()) {
            return false;
        }
        ComposerKt.insertIfMissing(this.invalidations, location, scope, instance);
        return true;
    }

    public final int parentKey$runtime_release() {
        if (getInserting()) {
            SlotWriter slotWriter = this.writer;
            return slotWriter.groupKey(slotWriter.getParent());
        }
        SlotReader slotReader = this.reader;
        return slotReader.groupKey(slotReader.getParent());
    }

    @ComposeCompilerApi
    public void skipCurrentGroup() {
        if (this.invalidations.isEmpty()) {
            skipGroup();
            return;
        }
        SlotReader reader2 = this.reader;
        int key = reader2.getGroupKey();
        Object dataKey = reader2.getGroupObjectKey();
        Object aux = reader2.getGroupAux();
        updateCompoundKeyWhenWeEnterGroup(key, dataKey, aux);
        startReaderGroup(reader2.isNode(), (Object) null);
        recomposeToGroupEnd();
        reader2.endGroup();
        updateCompoundKeyWhenWeExitGroup(key, dataKey, aux);
    }

    private final void skipReaderToGroupEnd() {
        this.groupNodeCount = this.reader.getParentNodes();
        this.reader.skipToGroupEnd();
    }

    @ComposeCompilerApi
    public void skipToGroupEnd() {
        if (this.groupNodeCount == 0) {
            RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
            if (currentRecomposeScope$runtime_release != null) {
                currentRecomposeScope$runtime_release.scopeSkipped();
            }
            if (this.invalidations.isEmpty()) {
                skipReaderToGroupEnd();
            } else {
                recomposeToGroupEnd();
            }
        } else {
            ComposerKt.composeRuntimeError("No nodes can be emitted before calling skipAndEndGroup".toString());
            throw new KotlinNothingValueException();
        }
    }

    @ComposeCompilerApi
    public void deactivateToEndGroup(boolean changed) {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeRuntimeError("No nodes can be emitted before calling dactivateToEndGroup".toString());
            throw new KotlinNothingValueException();
        } else if (getInserting()) {
        } else {
            if (!changed) {
                skipReaderToGroupEnd();
                return;
            }
            int start = this.reader.getCurrentGroup();
            int end = this.reader.getCurrentEnd();
            for (int group = start; group < end; group++) {
                if (this.reader.isNode(group)) {
                    Object node = this.reader.node(group);
                    if (node instanceof ComposeNodeLifecycleCallback) {
                        record(new ComposerImpl$deactivateToEndGroup$2(node));
                    }
                }
                this.reader.forEachData$runtime_release(group, new ComposerImpl$deactivateToEndGroup$3(this, group));
            }
            ComposerKt.removeRange(this.invalidations, start, end);
            this.reader.reposition(start);
            this.reader.skipToGroupEnd();
        }
    }

    @ComposeCompilerApi
    public Composer startRestartGroup(int key) {
        m2765startBaiHCIY(key, (Object) null, GroupKind.Companion.m2775getGroupULZAiWs(), (Object) null);
        addRecomposeScope();
        return this;
    }

    private final void addRecomposeScope() {
        RecomposeScopeImpl newScope;
        if (getInserting()) {
            ControlledComposition composition2 = getComposition();
            Intrinsics.checkNotNull(composition2, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            RecomposeScopeImpl scope = new RecomposeScopeImpl((CompositionImpl) composition2);
            this.invalidateStack.push(scope);
            updateValue(scope);
            scope.start(this.compositionToken);
            return;
        }
        Invalidation invalidation = ComposerKt.removeLocation(this.invalidations, this.reader.getParent());
        Object slot = this.reader.next();
        if (Intrinsics.areEqual(slot, Composer.Companion.getEmpty())) {
            ControlledComposition composition3 = getComposition();
            Intrinsics.checkNotNull(composition3, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            newScope = new RecomposeScopeImpl((CompositionImpl) composition3);
            updateValue(newScope);
        } else {
            Intrinsics.checkNotNull(slot, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
            newScope = (RecomposeScopeImpl) slot;
        }
        newScope.setRequiresRecompose(invalidation != null);
        this.invalidateStack.push(newScope);
        newScope.start(this.compositionToken);
    }

    @ComposeCompilerApi
    public ScopeUpdateScope endRestartGroup() {
        RecomposeScopeImpl scope;
        Anchor anchor;
        Function1 it;
        RecomposeScopeImpl result = null;
        if (this.invalidateStack.isNotEmpty()) {
            scope = this.invalidateStack.pop();
        } else {
            scope = null;
        }
        if (scope != null) {
            scope.setRequiresRecompose(false);
        }
        if (!(scope == null || (it = scope.end(this.compositionToken)) == null)) {
            record(new ComposerImpl$endRestartGroup$1$1(it, this));
        }
        if (scope != null && !scope.getSkipped$runtime_release() && (scope.getUsed() || this.forceRecomposeScopes)) {
            if (scope.getAnchor() == null) {
                if (getInserting()) {
                    SlotWriter slotWriter = this.writer;
                    anchor = slotWriter.anchor(slotWriter.getParent());
                } else {
                    SlotReader slotReader = this.reader;
                    anchor = slotReader.anchor(slotReader.getParent());
                }
                scope.setAnchor(anchor);
            }
            scope.setDefaultsInvalid(false);
            result = scope;
        }
        end(false);
        return result;
    }

    public void insertMovableContent(MovableContent<?> value, Object parameter) {
        Intrinsics.checkNotNullParameter(value, "value");
        invokeMovableContentLambda(value, currentCompositionLocalScope(), parameter, false);
    }

    /* access modifiers changed from: private */
    public final void invokeMovableContentLambda(MovableContent<Object> content, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> locals, Object parameter, boolean force) {
        MovableContent<Object> movableContent = content;
        PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap = locals;
        Object obj = parameter;
        startMovableGroup(MovableContentKt.movableContentKey, movableContent);
        changed(obj);
        int savedCompoundKeyHash = getCompoundKeyHash();
        try {
            this.compoundKeyHash = MovableContentKt.movableContentKey;
            boolean z = false;
            if (getInserting()) {
                SlotWriter.markGroup$default(this.writer, 0, 1, (Object) null);
            }
            if (!getInserting() && !Intrinsics.areEqual(this.reader.getGroupAux(), (Object) persistentMap)) {
                z = true;
            }
            boolean providersChanged = z;
            if (providersChanged) {
                this.providerUpdates.set(this.reader.getCurrentGroup(), persistentMap);
            }
            m2765startBaiHCIY(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.m2775getGroupULZAiWs(), persistentMap);
            if (!getInserting() || force) {
                boolean savedProvidersInvalid = this.providersInvalid;
                this.providersInvalid = providersChanged;
                ActualJvm_jvmKt.invokeComposable(this, ComposableLambdaKt.composableLambdaInstance(694380496, true, new ComposerImpl$invokeMovableContentLambda$1(movableContent, obj)));
                this.providersInvalid = savedProvidersInvalid;
            } else {
                this.writerHasAProvider = true;
                this.providerCache = null;
                SlotWriter slotWriter = this.writer;
                Anchor anchor = slotWriter.anchor(slotWriter.parent(slotWriter.getParent()));
                this.parentContext.insertMovableContent$runtime_release(new MovableContentStateReference(content, parameter, getComposition(), this.insertTable, anchor, CollectionsKt.emptyList(), currentCompositionLocalScope()));
            }
        } finally {
            endGroup();
            this.compoundKeyHash = savedCompoundKeyHash;
            endMovableGroup();
        }
    }

    public void insertMovableContentReferences(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        Intrinsics.checkNotNullParameter(references, "references");
        try {
            insertMovableContentGuarded(references);
            cleanUpCompose();
        } catch (Throwable th) {
            abortRoot();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final void insertMovableContentGuarded$positionToParentOf(SlotWriter slots, Applier<Object> applier2, int index) {
        while (!slots.indexInParent(index)) {
            slots.skipToGroupEnd();
            if (slots.isNode(slots.getParent())) {
                applier2.up();
            }
            slots.endGroup();
        }
    }

    private static final int insertMovableContentGuarded$currentNodeIndex(SlotWriter slots) {
        int original = slots.getCurrentGroup();
        int current = slots.getParent();
        while (current >= 0 && !slots.isNode(current)) {
            current = slots.parent(current);
        }
        int index = 0;
        int current2 = current + 1;
        while (current2 < original) {
            if (slots.indexInGroup(original, current2)) {
                if (slots.isNode(current2)) {
                    index = 0;
                }
                current2++;
            } else {
                index += slots.isNode(current2) ? 1 : slots.nodeCount(current2);
                current2 += slots.groupSize(current2);
            }
        }
        return index;
    }

    /* access modifiers changed from: private */
    public static final int insertMovableContentGuarded$positionToInsert(SlotWriter slots, Anchor anchor, Applier<Object> applier2) {
        int destination = slots.anchorIndex(anchor);
        boolean z = true;
        ComposerKt.runtimeCheck(slots.getCurrentGroup() < destination);
        insertMovableContentGuarded$positionToParentOf(slots, applier2, destination);
        int nodeIndex2 = insertMovableContentGuarded$currentNodeIndex(slots);
        while (slots.getCurrentGroup() < destination) {
            if (slots.indexInCurrentGroup(destination)) {
                if (slots.isNode()) {
                    applier2.down(slots.node(slots.getCurrentGroup()));
                    nodeIndex2 = 0;
                }
                slots.startGroup();
            } else {
                nodeIndex2 += slots.skipGroup();
            }
        }
        if (slots.getCurrentGroup() != destination) {
            z = false;
        }
        ComposerKt.runtimeCheck(z);
        return nodeIndex2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0151, code lost:
        if (r1 == null) goto L_0x0153;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0164, code lost:
        if (r0 != null) goto L_0x016a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void insertMovableContentGuarded(java.util.List<kotlin.Pair<androidx.compose.runtime.MovableContentStateReference, androidx.compose.runtime.MovableContentStateReference>> r46) {
        /*
            r45 = this;
            r9 = r45
            java.util.List<kotlin.jvm.functions.Function3<androidx.compose.runtime.Applier<?>, androidx.compose.runtime.SlotWriter, androidx.compose.runtime.RememberManager, kotlin.Unit>> r0 = r9.lateChanges
            r10 = r45
            r11 = r0
            r12 = 0
            java.util.List r13 = r10.changes
            r10.changes = r11     // Catch:{ all -> 0x0351 }
            r14 = 0
            kotlin.jvm.functions.Function3 r0 = androidx.compose.runtime.ComposerKt.resetSlotsInstance     // Catch:{ all -> 0x0351 }
            r9.record(r0)     // Catch:{ all -> 0x0351 }
            r15 = r46
            r16 = 0
            r0 = 0
            int r8 = r15.size()     // Catch:{ all -> 0x0351 }
            r7 = r0
        L_0x0023:
            r0 = 0
            if (r7 >= r8) goto L_0x0332
            java.lang.Object r1 = r15.get(r7)     // Catch:{ all -> 0x0351 }
            r17 = r1
            r1 = r17
            kotlin.Pair r1 = (kotlin.Pair) r1     // Catch:{ all -> 0x0351 }
            r18 = 0
            java.lang.Object r2 = r1.component1()     // Catch:{ all -> 0x0351 }
            androidx.compose.runtime.MovableContentStateReference r2 = (androidx.compose.runtime.MovableContentStateReference) r2     // Catch:{ all -> 0x0351 }
            r6 = r2
            java.lang.Object r1 = r1.component2()     // Catch:{ all -> 0x0351 }
            androidx.compose.runtime.MovableContentStateReference r1 = (androidx.compose.runtime.MovableContentStateReference) r1     // Catch:{ all -> 0x0351 }
            r5 = r1
            androidx.compose.runtime.Anchor r1 = r6.getAnchor$runtime_release()     // Catch:{ all -> 0x0351 }
            r4 = r1
            androidx.compose.runtime.SlotTable r1 = r6.getSlotTable$runtime_release()     // Catch:{ all -> 0x0351 }
            int r1 = r1.anchorIndex(r4)     // Catch:{ all -> 0x0351 }
            r3 = r1
            kotlin.jvm.internal.Ref$IntRef r1 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x0351 }
            r1.<init>()     // Catch:{ all -> 0x0351 }
            r2 = r1
            r45.realizeUps()     // Catch:{ all -> 0x0351 }
            androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$1 r1 = new androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$1     // Catch:{ all -> 0x0351 }
            r1.<init>(r2, r4)     // Catch:{ all -> 0x0351 }
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1     // Catch:{ all -> 0x0351 }
            r9.record(r1)     // Catch:{ all -> 0x0351 }
            if (r5 != 0) goto L_0x0135
            androidx.compose.runtime.SlotTable r0 = r6.getSlotTable$runtime_release()     // Catch:{ all -> 0x012e }
            r1 = r0
            androidx.compose.runtime.SlotTable r0 = r9.insertTable     // Catch:{ all -> 0x012e }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r0)     // Catch:{ all -> 0x012e }
            if (r0 == 0) goto L_0x0073
            r45.createFreshInsertTable()     // Catch:{ all -> 0x012e }
        L_0x0073:
            androidx.compose.runtime.SlotTable r0 = r6.getSlotTable$runtime_release()     // Catch:{ all -> 0x012e }
            r19 = r0
            r20 = 0
            androidx.compose.runtime.SlotReader r0 = r19.openReader()     // Catch:{ all -> 0x012e }
            r21 = r0
            r22 = 0
            r0 = r21
            r23 = 0
            r0.reposition(r3)     // Catch:{ all -> 0x011c }
            r9.writersReaderDelta = r3     // Catch:{ all -> 0x011c }
            java.util.ArrayList r24 = new java.util.ArrayList     // Catch:{ all -> 0x011c }
            r24.<init>()     // Catch:{ all -> 0x011c }
            java.util.List r24 = (java.util.List) r24     // Catch:{ all -> 0x011c }
            r25 = r24
            r24 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = r1
            androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$2$1 r1 = new androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$2$1     // Catch:{ all -> 0x010f }
            r30 = r8
            r8 = r25
            r1.<init>(r9, r8, r0, r6)     // Catch:{ all -> 0x010f }
            r25 = r1
            kotlin.jvm.functions.Function0 r25 = (kotlin.jvm.functions.Function0) r25     // Catch:{ all -> 0x010f }
            r31 = 15
            r32 = 0
            r1 = r45
            r33 = r2
            r2 = r24
            r24 = r3
            r3 = r26
            r34 = r4
            r4 = r27
            r35 = r5
            r5 = r28
            r26 = r6
            r6 = r25
            r25 = r7
            r7 = r31
            r28 = r0
            r0 = r8
            r27 = r30
            r8 = r32
            recomposeMovableContent$default(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x010b }
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x010b }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x010b }
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x00ed
            androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$2$2 r1 = new androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$2$2     // Catch:{ all -> 0x010b }
            r7 = r33
            r1.<init>(r7, r0)     // Catch:{ all -> 0x0109 }
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1     // Catch:{ all -> 0x0109 }
            r9.record(r1)     // Catch:{ all -> 0x0109 }
            goto L_0x00ef
        L_0x00ed:
            r7 = r33
        L_0x00ef:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0109 }
            r21.close()     // Catch:{ all -> 0x012e }
            r32 = r11
            r28 = r12
            r33 = r15
            r43 = r26
            r44 = r34
            r8 = r35
            r34 = r14
            goto L_0x0295
        L_0x0109:
            r0 = move-exception
            goto L_0x012a
        L_0x010b:
            r0 = move-exception
            r7 = r33
            goto L_0x012a
        L_0x010f:
            r0 = move-exception
            r24 = r3
            r34 = r4
            r35 = r5
            r26 = r6
            r25 = r7
            r7 = r2
            goto L_0x012a
        L_0x011c:
            r0 = move-exception
            r29 = r1
            r24 = r3
            r34 = r4
            r35 = r5
            r26 = r6
            r25 = r7
            r7 = r2
        L_0x012a:
            r21.close()     // Catch:{ all -> 0x012e }
            throw r0     // Catch:{ all -> 0x012e }
        L_0x012e:
            r0 = move-exception
            r32 = r11
            r28 = r12
            goto L_0x0356
        L_0x0135:
            r24 = r3
            r34 = r4
            r35 = r5
            r26 = r6
            r25 = r7
            r27 = r8
            r7 = r2
            androidx.compose.runtime.CompositionContext r1 = r9.parentContext     // Catch:{ all -> 0x0351 }
            r8 = r35
            androidx.compose.runtime.MovableContentState r1 = r1.movableContentStateResolve$runtime_release(r8)     // Catch:{ all -> 0x0351 }
            r6 = r1
            if (r6 == 0) goto L_0x0153
            androidx.compose.runtime.SlotTable r1 = r6.getSlotTable$runtime_release()     // Catch:{ all -> 0x012e }
            if (r1 != 0) goto L_0x0157
        L_0x0153:
            androidx.compose.runtime.SlotTable r1 = r8.getSlotTable$runtime_release()     // Catch:{ all -> 0x0351 }
        L_0x0157:
            r5 = r1
            if (r6 == 0) goto L_0x0166
            androidx.compose.runtime.SlotTable r1 = r6.getSlotTable$runtime_release()     // Catch:{ all -> 0x012e }
            if (r1 == 0) goto L_0x0166
            androidx.compose.runtime.Anchor r0 = r1.anchor(r0)     // Catch:{ all -> 0x012e }
            if (r0 != 0) goto L_0x016a
        L_0x0166:
            androidx.compose.runtime.Anchor r0 = r8.getAnchor$runtime_release()     // Catch:{ all -> 0x0351 }
        L_0x016a:
            r4 = r0
            java.util.List r0 = androidx.compose.runtime.ComposerKt.collectNodesFrom(r5, r4)     // Catch:{ all -> 0x0351 }
            r3 = r0
            r0 = r3
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ all -> 0x0351 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0351 }
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x01ac
            androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$3 r0 = new androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$3     // Catch:{ all -> 0x012e }
            r0.<init>(r7, r3)     // Catch:{ all -> 0x012e }
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0     // Catch:{ all -> 0x012e }
            r9.record(r0)     // Catch:{ all -> 0x012e }
            androidx.compose.runtime.SlotTable r0 = r26.getSlotTable$runtime_release()     // Catch:{ all -> 0x012e }
            androidx.compose.runtime.SlotTable r1 = r9.slotTable     // Catch:{ all -> 0x012e }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)     // Catch:{ all -> 0x012e }
            if (r0 == 0) goto L_0x01a9
            androidx.compose.runtime.SlotTable r0 = r9.slotTable     // Catch:{ all -> 0x012e }
            r2 = r34
            int r0 = r0.anchorIndex(r2)     // Catch:{ all -> 0x012e }
            int r1 = r9.updatedNodeCount(r0)     // Catch:{ all -> 0x012e }
            int r19 = r3.size()     // Catch:{ all -> 0x012e }
            int r1 = r1 + r19
            r9.updateNodeCount(r0, r1)     // Catch:{ all -> 0x012e }
            goto L_0x01ae
        L_0x01a9:
            r2 = r34
            goto L_0x01ae
        L_0x01ac:
            r2 = r34
        L_0x01ae:
            androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$4 r0 = new androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$4     // Catch:{ all -> 0x0351 }
            r1 = r26
            r0.<init>(r6, r9, r8, r1)     // Catch:{ all -> 0x0351 }
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0     // Catch:{ all -> 0x0351 }
            r9.record(r0)     // Catch:{ all -> 0x0351 }
            r19 = r5
            r20 = 0
            androidx.compose.runtime.SlotReader r0 = r19.openReader()     // Catch:{ all -> 0x0351 }
            r21 = r0
            r22 = 0
            r23 = r21
            r26 = 0
            r28 = r45
            r29 = 0
            androidx.compose.runtime.SlotReader r0 = r28.reader     // Catch:{ all -> 0x0319 }
            r30 = r0
            int[] r0 = r28.nodeCountOverrides     // Catch:{ all -> 0x0319 }
            r31 = r0
            r0 = 0
            r32 = r11
            r11 = r28
            r11.nodeCountOverrides = r0     // Catch:{ all -> 0x0305 }
            r28 = r12
            r12 = r23
            r11.reader = r12     // Catch:{ all -> 0x02e7 }
            r23 = 0
            int r0 = r5.anchorIndex(r4)     // Catch:{ all -> 0x02e7 }
            r33 = r0
            r34 = r14
            r14 = r33
            r12.reposition(r14)     // Catch:{ all -> 0x02d3 }
            r9.writersReaderDelta = r14     // Catch:{ all -> 0x02d3 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x02d3 }
            r0.<init>()     // Catch:{ all -> 0x02d3 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x02d3 }
            r33 = r0
            r35 = r45
            r36 = 0
            java.util.List r0 = r35.changes     // Catch:{ all -> 0x02d3 }
            r37 = r0
            r38 = r14
            r14 = r33
            r33 = r15
            r15 = r35
            r15.changes = r14     // Catch:{ all -> 0x02ba }
            r0 = 0
            androidx.compose.runtime.ControlledComposition r35 = r8.getComposition$runtime_release()     // Catch:{ all -> 0x02ba }
            androidx.compose.runtime.ControlledComposition r39 = r1.getComposition$runtime_release()     // Catch:{ all -> 0x02ba }
            int r40 = r12.getCurrentGroup()     // Catch:{ all -> 0x02ba }
            java.lang.Integer r40 = java.lang.Integer.valueOf(r40)     // Catch:{ all -> 0x02ba }
            java.util.List r41 = r8.getInvalidations$runtime_release()     // Catch:{ all -> 0x02ba }
            r42 = r0
            androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$5$1$1$1 r0 = new androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$5$1$1$1     // Catch:{ all -> 0x02ba }
            r0.<init>(r9, r1)     // Catch:{ all -> 0x02ba }
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0     // Catch:{ all -> 0x02ba }
            r43 = r1
            r1 = r45
            r44 = r2
            r2 = r35
            r35 = r3
            r3 = r39
            r39 = r4
            r4 = r40
            r40 = r5
            r5 = r41
            r41 = r6
            r6 = r0
            r1.recomposeMovableContent(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x02b2 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x02b2 }
            r1 = r37
            r15.changes = r1     // Catch:{ all -> 0x02ac }
            r0 = r14
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ all -> 0x02ac }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x02ac }
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x027b
            androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$5$1$2 r0 = new androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$5$1$2     // Catch:{ all -> 0x0274 }
            r0.<init>(r7, r14)     // Catch:{ all -> 0x0274 }
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0     // Catch:{ all -> 0x0274 }
            r9.record(r0)     // Catch:{ all -> 0x0274 }
            goto L_0x027b
        L_0x0274:
            r0 = move-exception
            r2 = r30
            r3 = r31
            goto L_0x02fc
        L_0x027b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x02ac }
            r2 = r30
            r11.reader = r2     // Catch:{ all -> 0x0303 }
            r3 = r31
            r11.nodeCountOverrides = r3     // Catch:{ all -> 0x0303 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0303 }
            r21.close()     // Catch:{ all -> 0x034f }
        L_0x0295:
            kotlin.jvm.functions.Function3 r0 = androidx.compose.runtime.ComposerKt.skipToGroupEndInstance     // Catch:{ all -> 0x034f }
            r9.record(r0)     // Catch:{ all -> 0x034f }
            int r7 = r25 + 1
            r8 = r27
            r12 = r28
            r11 = r32
            r15 = r33
            r14 = r34
            goto L_0x0023
        L_0x02ac:
            r0 = move-exception
            r2 = r30
            r3 = r31
            goto L_0x02fc
        L_0x02b2:
            r0 = move-exception
            r2 = r30
            r3 = r31
            r1 = r37
            goto L_0x02cd
        L_0x02ba:
            r0 = move-exception
            r43 = r1
            r44 = r2
            r35 = r3
            r39 = r4
            r40 = r5
            r41 = r6
            r2 = r30
            r3 = r31
            r1 = r37
        L_0x02cd:
            r15.changes = r1     // Catch:{ all -> 0x02d1 }
            throw r0     // Catch:{ all -> 0x02d1 }
        L_0x02d1:
            r0 = move-exception
            goto L_0x02fc
        L_0x02d3:
            r0 = move-exception
            r43 = r1
            r44 = r2
            r35 = r3
            r39 = r4
            r40 = r5
            r41 = r6
            r33 = r15
            r2 = r30
            r3 = r31
            goto L_0x02fc
        L_0x02e7:
            r0 = move-exception
            r43 = r1
            r44 = r2
            r35 = r3
            r39 = r4
            r40 = r5
            r41 = r6
            r34 = r14
            r33 = r15
            r2 = r30
            r3 = r31
        L_0x02fc:
            r11.reader = r2     // Catch:{ all -> 0x0303 }
            r11.nodeCountOverrides = r3     // Catch:{ all -> 0x0303 }
            throw r0     // Catch:{ all -> 0x0303 }
        L_0x0303:
            r0 = move-exception
            goto L_0x032e
        L_0x0305:
            r0 = move-exception
            r43 = r1
            r44 = r2
            r35 = r3
            r39 = r4
            r40 = r5
            r41 = r6
            r28 = r12
            r34 = r14
            r33 = r15
            goto L_0x032e
        L_0x0319:
            r0 = move-exception
            r43 = r1
            r44 = r2
            r35 = r3
            r39 = r4
            r40 = r5
            r41 = r6
            r32 = r11
            r28 = r12
            r34 = r14
            r33 = r15
        L_0x032e:
            r21.close()     // Catch:{ all -> 0x034f }
            throw r0     // Catch:{ all -> 0x034f }
        L_0x0332:
            r25 = r7
            r32 = r11
            r28 = r12
            r34 = r14
            r33 = r15
            androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$2 r1 = androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$2.INSTANCE     // Catch:{ all -> 0x034f }
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1     // Catch:{ all -> 0x034f }
            r9.record(r1)     // Catch:{ all -> 0x034f }
            r9.writersReaderDelta = r0     // Catch:{ all -> 0x034f }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x034f }
            r10.changes = r13
            return
        L_0x034f:
            r0 = move-exception
            goto L_0x0356
        L_0x0351:
            r0 = move-exception
            r32 = r11
            r28 = r12
        L_0x0356:
            r10.changes = r13
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.insertMovableContentGuarded(java.util.List):void");
    }

    private final <R> R withChanges(List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> newChanges, Function0<? extends R> block) {
        List savedChanges = this.changes;
        try {
            this.changes = newChanges;
            return block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            this.changes = savedChanges;
            InlineMarker.finallyEnd(1);
        }
    }

    private final <R> R withReader(SlotReader reader2, Function0<? extends R> block) {
        SlotReader savedReader = this.reader;
        int[] savedCountOverrides = this.nodeCountOverrides;
        this.nodeCountOverrides = null;
        try {
            this.reader = reader2;
            return block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            this.reader = savedReader;
            this.nodeCountOverrides = savedCountOverrides;
            InlineMarker.finallyEnd(1);
        }
    }

    static /* synthetic */ Object recomposeMovableContent$default(ComposerImpl composerImpl, ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List list, Function0 function0, int i, Object obj) {
        ControlledComposition controlledComposition3;
        ControlledComposition controlledComposition4;
        Integer num2;
        List list2;
        if ((i & 1) != 0) {
            controlledComposition3 = null;
        } else {
            controlledComposition3 = controlledComposition;
        }
        if ((i & 2) != 0) {
            controlledComposition4 = null;
        } else {
            controlledComposition4 = controlledComposition2;
        }
        if ((i & 4) != 0) {
            num2 = null;
        } else {
            num2 = num;
        }
        if ((i & 8) != 0) {
            list2 = CollectionsKt.emptyList();
        } else {
            list2 = list;
        }
        return composerImpl.recomposeMovableContent(controlledComposition3, controlledComposition4, num2, list2, function0);
    }

    private final <R> R recomposeMovableContent(ControlledComposition from, ControlledComposition to, Integer index, List<Pair<RecomposeScopeImpl, IdentityArraySet<Object>>> invalidations2, Function0<? extends R> block) {
        R r;
        List $this$fastForEach$iv;
        ControlledComposition controlledComposition = from;
        boolean savedImplicitRootStart = this.implicitRootStart;
        boolean savedIsComposing = this.isComposing;
        int savedNodeIndex = this.nodeIndex;
        try {
            this.implicitRootStart = false;
            this.isComposing = true;
            this.nodeIndex = 0;
            List $this$fastForEach$iv2 = invalidations2;
            int index$iv = 0;
            int size = $this$fastForEach$iv2.size();
            while (index$iv < size) {
                Pair pair = $this$fastForEach$iv2.get(index$iv);
                RecomposeScopeImpl scope = (RecomposeScopeImpl) pair.component1();
                IdentityArraySet instances = (IdentityArraySet) pair.component2();
                if (instances != null) {
                    IdentityArraySet this_$iv = instances;
                    int i$iv = 0;
                    $this$fastForEach$iv = $this$fastForEach$iv2;
                    for (int size2 = this_$iv.size(); i$iv < size2; size2 = size2) {
                        tryImminentInvalidation$runtime_release(scope, this_$iv.get(i$iv));
                        i$iv++;
                    }
                } else {
                    $this$fastForEach$iv = $this$fastForEach$iv2;
                    tryImminentInvalidation$runtime_release(scope, (Object) null);
                }
                index$iv++;
                $this$fastForEach$iv2 = $this$fastForEach$iv;
            }
            if (controlledComposition != null) {
                try {
                    r = controlledComposition.delegateInvalidations(to, index != null ? index.intValue() : -1, block);
                    if (r == null) {
                    }
                    this.implicitRootStart = savedImplicitRootStart;
                    this.isComposing = savedIsComposing;
                    this.nodeIndex = savedNodeIndex;
                    return r;
                } catch (Throwable th) {
                    th = th;
                    this.implicitRootStart = savedImplicitRootStart;
                    this.isComposing = savedIsComposing;
                    this.nodeIndex = savedNodeIndex;
                    throw th;
                }
            } else {
                ControlledComposition controlledComposition2 = to;
                Function0<? extends R> function0 = block;
            }
            r = block.invoke();
            this.implicitRootStart = savedImplicitRootStart;
            this.isComposing = savedIsComposing;
            this.nodeIndex = savedNodeIndex;
            return r;
        } catch (Throwable th2) {
            th = th2;
            ControlledComposition controlledComposition3 = to;
            Function0<? extends R> function02 = block;
            this.implicitRootStart = savedImplicitRootStart;
            this.isComposing = savedIsComposing;
            this.nodeIndex = savedNodeIndex;
            throw th;
        }
    }

    @ComposeCompilerApi
    public void sourceInformation(String sourceInformation) {
        Intrinsics.checkNotNullParameter(sourceInformation, "sourceInformation");
        if (getInserting() && this.sourceInformationEnabled) {
            this.writer.insertAux(sourceInformation);
        }
    }

    @ComposeCompilerApi
    public void sourceInformationMarkerStart(int key, String sourceInformation) {
        Intrinsics.checkNotNullParameter(sourceInformation, "sourceInformation");
        if (this.sourceInformationEnabled) {
            m2765startBaiHCIY(key, (Object) null, GroupKind.Companion.m2775getGroupULZAiWs(), sourceInformation);
        }
    }

    @ComposeCompilerApi
    public void sourceInformationMarkerEnd() {
        if (this.sourceInformationEnabled) {
            end(false);
        }
    }

    public void disableSourceInformation() {
        this.sourceInformationEnabled = false;
    }

    public final void composeContent$runtime_release(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidationsRequested, Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(invalidationsRequested, "invalidationsRequested");
        Intrinsics.checkNotNullParameter(content, "content");
        if (this.changes.isEmpty()) {
            doCompose(invalidationsRequested, content);
        } else {
            ComposerKt.composeRuntimeError("Expected applyChanges() to have been called".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void prepareCompose$runtime_release(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (!this.isComposing) {
            this.isComposing = true;
            try {
                block.invoke();
            } finally {
                this.isComposing = false;
            }
        } else {
            ComposerKt.composeRuntimeError("Preparing a composition while composing is not supported".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final boolean recompose$runtime_release(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidationsRequested) {
        Intrinsics.checkNotNullParameter(invalidationsRequested, "invalidationsRequested");
        if (!this.changes.isEmpty()) {
            ComposerKt.composeRuntimeError("Expected applyChanges() to have been called".toString());
            throw new KotlinNothingValueException();
        } else if (!invalidationsRequested.isNotEmpty() && !(!this.invalidations.isEmpty()) && !this.forciblyRecompose) {
            return false;
        } else {
            doCompose(invalidationsRequested, (Function2<? super Composer, ? super Integer, Unit>) null);
            return !this.changes.isEmpty();
        }
    }

    private final void doCompose(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidationsRequested, Function2<? super Composer, ? super Integer, Unit> content) {
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        if (!this.isComposing) {
            Object token$iv = Trace.INSTANCE.beginSection("Compose:recompose");
            try {
                Snapshot currentSnapshot = SnapshotKt.currentSnapshot();
                this.snapshot = currentSnapshot;
                this.compositionToken = currentSnapshot.getId();
                this.providerUpdates.clear();
                IdentityArrayMap this_$iv = invalidationsRequested;
                int index$iv = 0;
                int size$runtime_release = this_$iv.getSize$runtime_release();
                while (index$iv < size$runtime_release) {
                    Object obj = this_$iv.getKeys$runtime_release()[index$iv];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                    IdentityArraySet set = (IdentityArraySet) this_$iv.getValues$runtime_release()[index$iv];
                    RecomposeScopeImpl scope = (RecomposeScopeImpl) obj;
                    Anchor anchor = scope.getAnchor();
                    if (anchor != null) {
                        this.invalidations.add(new Invalidation(scope, anchor.getLocation$runtime_release(), set));
                        index$iv++;
                    } else {
                        Trace.INSTANCE.endSection(token$iv);
                        return;
                    }
                }
                List $this$sortBy$iv = this.invalidations;
                if ($this$sortBy$iv.size() > 1) {
                    CollectionsKt.sortWith($this$sortBy$iv, new ComposerImpl$doCompose$lambda$37$$inlined$sortBy$1());
                }
                this.nodeIndex = 0;
                this.isComposing = true;
                startRoot();
                Object savedContent = nextSlot();
                if (!(savedContent == function2 || function2 == null)) {
                    updateValue(function2);
                }
                SnapshotStateKt.observeDerivedStateRecalculations(new ComposerImpl$doCompose$2$3(this), new ComposerImpl$doCompose$2$4(this), new ComposerImpl$doCompose$2$5(function2, this, savedContent));
                endRoot();
                this.isComposing = false;
                this.invalidations.clear();
                Unit unit = Unit.INSTANCE;
                Trace.INSTANCE.endSection(token$iv);
            } catch (Throwable th) {
                Trace.INSTANCE.endSection(token$iv);
                throw th;
            }
        } else {
            ComposerKt.composeRuntimeError("Reentrant composition is not supported".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final boolean getHasInvalidations() {
        return !this.invalidations.isEmpty();
    }

    private final Object getNode(SlotReader $this$node) {
        return $this$node.node($this$node.getParent());
    }

    private final Object nodeAt(SlotReader $this$nodeAt, int index) {
        return $this$nodeAt.node(index);
    }

    private final void validateNodeExpected() {
        if (this.nodeExpected) {
            this.nodeExpected = false;
        } else {
            ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected".toString());
            throw new KotlinNothingValueException();
        }
    }

    private final void validateNodeNotExpected() {
        if (!(!this.nodeExpected)) {
            ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected".toString());
            throw new KotlinNothingValueException();
        }
    }

    private final void record(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> change) {
        this.changes.add(change);
    }

    private final void recordApplierOperation(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> change) {
        realizeUps();
        realizeDowns();
        record(change);
    }

    private final void recordSlotEditingOperation(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> change) {
        realizeOperationLocation$default(this, false, 1, (Object) null);
        recordSlotEditing();
        record(change);
    }

    static /* synthetic */ void recordSlotTableOperation$default(ComposerImpl composerImpl, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        composerImpl.recordSlotTableOperation(z, function3);
    }

    private final void recordSlotTableOperation(boolean forParent, Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> change) {
        realizeOperationLocation(forParent);
        record(change);
    }

    private final void realizeUps() {
        int count = this.pendingUps;
        if (count > 0) {
            this.pendingUps = 0;
            record(new ComposerImpl$realizeUps$1(count));
        }
    }

    private final void realizeDowns(Object[] nodes) {
        record(new ComposerImpl$realizeDowns$1(nodes));
    }

    private final void realizeDowns() {
        if (this.downNodes.isNotEmpty()) {
            realizeDowns(this.downNodes.toArray());
            this.downNodes.clear();
        }
    }

    private final void recordDown(Object node) {
        this.downNodes.push(node);
    }

    private final void recordUp() {
        if (this.downNodes.isNotEmpty()) {
            this.downNodes.pop();
        } else {
            this.pendingUps++;
        }
    }

    static /* synthetic */ void realizeOperationLocation$default(ComposerImpl composerImpl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        composerImpl.realizeOperationLocation(z);
    }

    private final void realizeOperationLocation(boolean forParent) {
        SlotReader slotReader = this.reader;
        int location = forParent ? slotReader.getParent() : slotReader.getCurrentGroup();
        int distance = location - this.writersReaderDelta;
        if (!(distance >= 0)) {
            ComposerKt.composeRuntimeError("Tried to seek backward".toString());
            throw new KotlinNothingValueException();
        } else if (distance > 0) {
            record(new ComposerImpl$realizeOperationLocation$2(distance));
            this.writersReaderDelta = location;
        }
    }

    private final void recordInsert(Anchor anchor) {
        if (this.insertFixups.isEmpty()) {
            recordSlotEditingOperation(new ComposerImpl$recordInsert$1(this.insertTable, anchor));
            return;
        }
        List fixups = CollectionsKt.toMutableList(this.insertFixups);
        this.insertFixups.clear();
        realizeUps();
        realizeDowns();
        recordSlotEditingOperation(new ComposerImpl$recordInsert$2(this.insertTable, anchor, fixups));
    }

    private final void recordFixup(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> change) {
        this.insertFixups.add(change);
    }

    private final void recordInsertUpFixup(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> change) {
        this.insertUpFixups.push(change);
    }

    private final void registerInsertUpFixup() {
        this.insertFixups.add(this.insertUpFixups.pop());
    }

    private final void recordDelete() {
        reportFreeMovableContent(this.reader.getCurrentGroup());
        recordSlotEditingOperation(ComposerKt.removeCurrentGroupInstance);
        this.writersReaderDelta += this.reader.getGroupSize();
    }

    private static final int reportFreeMovableContent$reportGroup(ComposerImpl this$0, int group, boolean needsNodeDelete, int nodeIndex2) {
        ComposerImpl composerImpl = this$0;
        int i = group;
        int i2 = nodeIndex2;
        if (composerImpl.reader.hasMark(i)) {
            int key = composerImpl.reader.groupKey(i);
            Object objectKey = composerImpl.reader.groupObjectKey(i);
            if (key == 126665345 && (objectKey instanceof MovableContent)) {
                MovableContent movableContent = (MovableContent) objectKey;
                Object parameter = composerImpl.reader.groupGet(i, 0);
                Anchor anchor = composerImpl.reader.anchor(i);
                int end = i + composerImpl.reader.groupSize(i);
                List $this$fastMap$iv = ComposerKt.filterToRange(composerImpl.invalidations, i, end);
                ArrayList target$iv = new ArrayList($this$fastMap$iv.size());
                List $this$fastForEach$iv$iv = $this$fastMap$iv;
                int index$iv$iv = 0;
                int size = $this$fastForEach$iv$iv.size();
                while (index$iv$iv < size) {
                    Invalidation it = (Invalidation) $this$fastForEach$iv$iv.get(index$iv$iv);
                    target$iv.add(TuplesKt.to(it.getScope(), it.getInstances()));
                    index$iv$iv++;
                    $this$fastMap$iv = $this$fastMap$iv;
                }
                int i3 = end;
                MovableContentStateReference movableContentStateReference = new MovableContentStateReference(movableContent, parameter, this$0.getComposition(), composerImpl.slotTable, anchor, target$iv, this$0.currentCompositionLocalScope(group));
                composerImpl.parentContext.deletedMovableContent$runtime_release(movableContentStateReference);
                this$0.recordSlotEditing();
                composerImpl.record(new ComposerImpl$reportFreeMovableContent$reportGroup$1(composerImpl, movableContentStateReference));
                if (!needsNodeDelete) {
                    return composerImpl.reader.nodeCount(i);
                }
                this$0.realizeMovement();
                this$0.realizeUps();
                this$0.realizeDowns();
                int nodeCount = composerImpl.reader.isNode(i) ? 1 : composerImpl.reader.nodeCount(i);
                if (nodeCount > 0) {
                    composerImpl.recordRemoveNode(i2, nodeCount);
                }
                return 0;
            } else if (key != 206 || !Intrinsics.areEqual(objectKey, ComposerKt.getReference())) {
                return composerImpl.reader.nodeCount(i);
            } else {
                Object groupGet = composerImpl.reader.groupGet(i, 0);
                CompositionContextHolder contextHolder = groupGet instanceof CompositionContextHolder ? (CompositionContextHolder) groupGet : null;
                if (contextHolder != null) {
                    for (ComposerImpl composer : contextHolder.getRef().getComposers()) {
                        composer.reportAllMovableContent();
                    }
                }
                return composerImpl.reader.nodeCount(i);
            }
        } else if (!composerImpl.reader.containsMark(i)) {
            return composerImpl.reader.nodeCount(i);
        } else {
            int end2 = i + composerImpl.reader.groupSize(i);
            int runningNodeCount = 0;
            for (int current = i + 1; current < end2; current += composerImpl.reader.groupSize(current)) {
                boolean isNode = composerImpl.reader.isNode(current);
                if (isNode) {
                    this$0.realizeMovement();
                    composerImpl.recordDown(composerImpl.reader.node(current));
                }
                runningNodeCount += reportFreeMovableContent$reportGroup(composerImpl, current, isNode || needsNodeDelete, isNode ? 0 : i2 + runningNodeCount);
                if (isNode) {
                    this$0.realizeMovement();
                    this$0.recordUp();
                }
            }
            return runningNodeCount;
        }
    }

    private final void reportFreeMovableContent(int groupBeingRemoved) {
        reportFreeMovableContent$reportGroup(this, groupBeingRemoved, false, 0);
        realizeMovement();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public final void releaseMovableGroupAtCurrent(MovableContentStateReference reference, SlotWriter slots) {
        SlotTable slotTable2 = new SlotTable();
        SlotWriter writer$iv = slotTable2.openWriter();
        SlotWriter writer2 = writer$iv;
        try {
            writer2.beginInsert();
            writer2.startGroup(MovableContentKt.movableContentKey, reference.getContent$runtime_release());
            SlotWriter.markGroup$default(writer2, 0, 1, (Object) null);
            writer2.update(reference.getParameter$runtime_release());
            slots.moveTo(reference.getAnchor$runtime_release(), 1, writer2);
            writer2.skipGroup();
            writer2.endGroup();
            writer2.endInsert();
            Unit unit = Unit.INSTANCE;
            writer$iv.close();
            this.parentContext.movableContentStateReleased$runtime_release(reference, new MovableContentState(slotTable2));
        } catch (Throwable th) {
            writer$iv.close();
            throw th;
        }
    }

    private final void reportAllMovableContent() {
        List savedChanges$iv;
        if (this.slotTable.containsMark()) {
            List changes2 = new ArrayList();
            this.deferredChanges = changes2;
            SlotReader reader$iv = this.slotTable.openReader();
            try {
                this.reader = reader$iv;
                savedChanges$iv = this.changes;
                this.changes = changes2;
                reportFreeMovableContent(0);
                realizeUps();
                if (this.startedGroup) {
                    record(ComposerKt.skipToGroupEndInstance);
                    recordEndRoot();
                }
                Unit unit = Unit.INSTANCE;
                this.changes = savedChanges$iv;
                Unit unit2 = Unit.INSTANCE;
                reader$iv.close();
            } catch (Throwable th) {
                reader$iv.close();
                throw th;
            }
        }
    }

    private final void recordReaderMoving(int location) {
        this.writersReaderDelta = location - (this.reader.getCurrentGroup() - this.writersReaderDelta);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r7.reader;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void recordSlotEditing() {
        /*
            r7 = this;
            androidx.compose.runtime.SlotReader r0 = r7.reader
            int r0 = r0.getSize()
            if (r0 <= 0) goto L_0x0040
            androidx.compose.runtime.SlotReader r0 = r7.reader
            int r1 = r0.getParent()
            androidx.compose.runtime.IntStack r2 = r7.startedGroups
            r3 = -2
            int r2 = r2.peekOr(r3)
            if (r2 == r1) goto L_0x0040
            boolean r2 = r7.startedGroup
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 != 0) goto L_0x002b
            boolean r2 = r7.implicitRootStart
            if (r2 == 0) goto L_0x002b
            kotlin.jvm.functions.Function3 r2 = androidx.compose.runtime.ComposerKt.startRootGroup
            recordSlotTableOperation$default(r7, r4, r2, r5, r3)
            r7.startedGroup = r5
        L_0x002b:
            if (r1 <= 0) goto L_0x0040
            androidx.compose.runtime.Anchor r2 = r0.anchor(r1)
            androidx.compose.runtime.IntStack r6 = r7.startedGroups
            r6.push(r1)
            androidx.compose.runtime.ComposerImpl$recordSlotEditing$1 r6 = new androidx.compose.runtime.ComposerImpl$recordSlotEditing$1
            r6.<init>(r2)
            kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
            recordSlotTableOperation$default(r7, r4, r6, r5, r3)
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.recordSlotEditing():void");
    }

    private final void recordEndGroup() {
        int location = this.reader.getParent();
        if (!(this.startedGroups.peekOr(-1) <= location)) {
            ComposerKt.composeRuntimeError("Missed recording an endGroup".toString());
            throw new KotlinNothingValueException();
        } else if (this.startedGroups.peekOr(-1) == location) {
            this.startedGroups.pop();
            recordSlotTableOperation$default(this, false, ComposerKt.endGroupInstance, 1, (Object) null);
        }
    }

    private final void recordEndRoot() {
        if (this.startedGroup) {
            recordSlotTableOperation$default(this, false, ComposerKt.endGroupInstance, 1, (Object) null);
            this.startedGroup = false;
        }
    }

    private final void finalizeCompose() {
        realizeUps();
        if (!this.pendingStack.isEmpty()) {
            ComposerKt.composeRuntimeError("Start/end imbalance".toString());
            throw new KotlinNothingValueException();
        } else if (this.startedGroups.isEmpty()) {
            cleanUpCompose();
        } else {
            ComposerKt.composeRuntimeError("Missed recording an endGroup()".toString());
            throw new KotlinNothingValueException();
        }
    }

    private final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.writersReaderDelta = 0;
        this.compoundKeyHash = 0;
        this.nodeExpected = false;
        this.startedGroup = false;
        this.startedGroups.clear();
        this.invalidateStack.clear();
        clearUpdatedNodeCounts();
    }

    public final void verifyConsistent$runtime_release() {
        this.insertTable.verifyWellFormed();
    }

    private final void recordRemoveNode(int nodeIndex2, int count) {
        if (count > 0) {
            if (!(nodeIndex2 >= 0)) {
                ComposerKt.composeRuntimeError(("Invalid remove index " + nodeIndex2).toString());
                throw new KotlinNothingValueException();
            } else if (this.previousRemove == nodeIndex2) {
                this.previousCount += count;
            } else {
                realizeMovement();
                this.previousRemove = nodeIndex2;
                this.previousCount = count;
            }
        }
    }

    private final void recordMoveNode(int from, int to, int count) {
        if (count > 0) {
            int i = this.previousCount;
            if (i > 0 && this.previousMoveFrom == from - i && this.previousMoveTo == to - i) {
                this.previousCount = i + count;
                return;
            }
            realizeMovement();
            this.previousMoveFrom = from;
            this.previousMoveTo = to;
            this.previousCount = count;
        }
    }

    private final void realizeMovement() {
        int count = this.previousCount;
        this.previousCount = 0;
        if (count <= 0) {
            return;
        }
        if (this.previousRemove >= 0) {
            int removeIndex = this.previousRemove;
            this.previousRemove = -1;
            recordApplierOperation(new ComposerImpl$realizeMovement$1(removeIndex, count));
            return;
        }
        int from = this.previousMoveFrom;
        this.previousMoveFrom = -1;
        int to = this.previousMoveTo;
        this.previousMoveTo = -1;
        recordApplierOperation(new ComposerImpl$realizeMovement$2(from, to, count));
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextHolder;", "Landroidx/compose/runtime/RememberObserver;", "ref", "Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/ComposerImpl;", "(Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;)V", "getRef", "()Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "onAbandoned", "", "onForgotten", "onRemembered", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Composer.kt */
    private static final class CompositionContextHolder implements RememberObserver {
        private final CompositionContextImpl ref;

        public CompositionContextHolder(CompositionContextImpl ref2) {
            Intrinsics.checkNotNullParameter(ref2, "ref");
            this.ref = ref2;
        }

        public final CompositionContextImpl getRef() {
            return this.ref;
        }

        public void onRemembered() {
        }

        public void onAbandoned() {
            this.ref.dispose();
        }

        public void onForgotten() {
            this.ref.dispose();
        }
    }

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020+0/¢\u0006\u0002\b0H\u0010¢\u0006\u0004\b1\u00102J\u0015\u00103\u001a\u00020+2\u0006\u00104\u001a\u000205H\u0010¢\u0006\u0002\b6J\u0006\u00107\u001a\u00020+J\r\u00108\u001a\u00020+H\u0010¢\u0006\u0002\b9J-\u0010\u0015\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00120\u000fj\u0002`\u0013H\u0010¢\u0006\u0002\b:J\u0015\u0010;\u001a\u00020+2\u0006\u00104\u001a\u000205H\u0010¢\u0006\u0002\b<J\u0015\u0010=\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0010¢\u0006\u0002\b>J\u0015\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00020AH\u0010¢\u0006\u0002\bBJ\u001d\u0010C\u001a\u00020+2\u0006\u00104\u001a\u0002052\u0006\u0010D\u001a\u00020EH\u0010¢\u0006\u0002\bFJ\u0017\u0010G\u001a\u0004\u0018\u00010E2\u0006\u00104\u001a\u000205H\u0010¢\u0006\u0002\bHJ\u001b\u0010I\u001a\u00020+2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\"0\nH\u0010¢\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020+2\u0006\u0010M\u001a\u00020NH\u0010¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0010¢\u0006\u0002\bQJ\r\u0010R\u001a\u00020+H\u0010¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020+2\u0006\u0010M\u001a\u00020NH\u0010¢\u0006\u0002\bUJ\u0015\u0010V\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0010¢\u0006\u0002\bWJ.\u0010X\u001a\u00020+2&\u0010@\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00120\u000fj\u0002`\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rRk\u0010\u0014\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00120\u000fj\u0002`\u00132&\u0010\u000e\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00120\u000fj\u0002`\u00138B@BX\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8PX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R(\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\n\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u001e8PX\u0004¢\u0006\f\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010 ¨\u0006Y"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/CompositionContext;", "compoundHashKey", "", "collectingParameterInformation", "", "(Landroidx/compose/runtime/ComposerImpl;IZ)V", "getCollectingParameterInformation$runtime_release", "()Z", "composers", "", "Landroidx/compose/runtime/ComposerImpl;", "getComposers", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "compositionLocalScope", "getCompositionLocalScope", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "setCompositionLocalScope", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)V", "compositionLocalScope$delegate", "Landroidx/compose/runtime/MutableState;", "getCompoundHashKey$runtime_release", "()I", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext$runtime_release", "()Lkotlin/coroutines/CoroutineContext;", "inspectionTables", "Landroidx/compose/runtime/tooling/CompositionData;", "getInspectionTables", "setInspectionTables", "(Ljava/util/Set;)V", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release$annotations", "()V", "getRecomposeCoroutineContext$runtime_release", "composeInitial", "", "composition", "Landroidx/compose/runtime/ControlledComposition;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "deletedMovableContent", "reference", "Landroidx/compose/runtime/MovableContentStateReference;", "deletedMovableContent$runtime_release", "dispose", "doneComposing", "doneComposing$runtime_release", "getCompositionLocalScope$runtime_release", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "movableContentStateReleased", "data", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "recordInspectionTable", "table", "recordInspectionTable$runtime_release", "registerComposer", "composer", "Landroidx/compose/runtime/Composer;", "registerComposer$runtime_release", "registerComposition", "registerComposition$runtime_release", "startComposing", "startComposing$runtime_release", "unregisterComposer", "unregisterComposer$runtime_release", "unregisterComposition", "unregisterComposition$runtime_release", "updateCompositionLocalScope", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Composer.kt */
    private final class CompositionContextImpl extends CompositionContext {
        private final boolean collectingParameterInformation;
        private final Set<ComposerImpl> composers = new LinkedHashSet();
        private final MutableState compositionLocalScope$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ExtensionsKt.persistentHashMapOf(), (SnapshotMutationPolicy) null, 2, (Object) null);
        private final int compoundHashKey;
        private Set<Set<CompositionData>> inspectionTables;

        public static /* synthetic */ void getRecomposeCoroutineContext$runtime_release$annotations() {
        }

        public CompositionContextImpl(int compoundHashKey2, boolean collectingParameterInformation2) {
            this.compoundHashKey = compoundHashKey2;
            this.collectingParameterInformation = collectingParameterInformation2;
        }

        public int getCompoundHashKey$runtime_release() {
            return this.compoundHashKey;
        }

        public boolean getCollectingParameterInformation$runtime_release() {
            return this.collectingParameterInformation;
        }

        public final Set<Set<CompositionData>> getInspectionTables() {
            return this.inspectionTables;
        }

        public final void setInspectionTables(Set<Set<CompositionData>> set) {
            this.inspectionTables = set;
        }

        public final Set<ComposerImpl> getComposers() {
            return this.composers;
        }

        public final void dispose() {
            if (!this.composers.isEmpty()) {
                Set<Set<CompositionData>> it = this.inspectionTables;
                if (it != null) {
                    for (ComposerImpl composer : this.composers) {
                        for (Set<CompositionData> table : it) {
                            table.remove(composer.slotTable);
                        }
                    }
                }
                this.composers.clear();
            }
        }

        public void registerComposer$runtime_release(Composer composer) {
            Intrinsics.checkNotNullParameter(composer, "composer");
            super.registerComposer$runtime_release((ComposerImpl) composer);
            this.composers.add(composer);
        }

        public void unregisterComposer$runtime_release(Composer composer) {
            Intrinsics.checkNotNullParameter(composer, "composer");
            Set<Set<CompositionData>> $this$forEach$iv = this.inspectionTables;
            if ($this$forEach$iv != null) {
                for (Set it : $this$forEach$iv) {
                    it.remove(((ComposerImpl) composer).slotTable);
                }
            }
            TypeIntrinsics.asMutableCollection((Collection) this.composers).remove(composer);
        }

        public void registerComposition$runtime_release(ControlledComposition composition) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            ComposerImpl.this.parentContext.registerComposition$runtime_release(composition);
        }

        public void unregisterComposition$runtime_release(ControlledComposition composition) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            ComposerImpl.this.parentContext.unregisterComposition$runtime_release(composition);
        }

        public CoroutineContext getEffectCoroutineContext$runtime_release() {
            return ComposerImpl.this.parentContext.getEffectCoroutineContext$runtime_release();
        }

        public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
            return CompositionKt.getRecomposeCoroutineContext(ComposerImpl.this.getComposition());
        }

        public void composeInitial$runtime_release(ControlledComposition composition, Function2<? super Composer, ? super Integer, Unit> content) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            Intrinsics.checkNotNullParameter(content, "content");
            ComposerImpl.this.parentContext.composeInitial$runtime_release(composition, content);
        }

        public void invalidate$runtime_release(ControlledComposition composition) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            ComposerImpl.this.parentContext.invalidate$runtime_release(ComposerImpl.this.getComposition());
            ComposerImpl.this.parentContext.invalidate$runtime_release(composition);
        }

        public void invalidateScope$runtime_release(RecomposeScopeImpl scope) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            ComposerImpl.this.parentContext.invalidateScope$runtime_release(scope);
        }

        private final PersistentMap<CompositionLocal<Object>, State<Object>> getCompositionLocalScope() {
            return (PersistentMap) this.compositionLocalScope$delegate.getValue();
        }

        private final void setCompositionLocalScope(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
            this.compositionLocalScope$delegate.setValue(persistentMap);
        }

        public PersistentMap<CompositionLocal<Object>, State<Object>> getCompositionLocalScope$runtime_release() {
            return getCompositionLocalScope();
        }

        public final void updateCompositionLocalScope(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> scope) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            setCompositionLocalScope(scope);
        }

        public void recordInspectionTable$runtime_release(Set<CompositionData> table) {
            Intrinsics.checkNotNullParameter(table, "table");
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set == null) {
                HashSet it = new HashSet();
                this.inspectionTables = it;
                set = it;
            }
            set.add(table);
        }

        public void startComposing$runtime_release() {
            ComposerImpl composerImpl = ComposerImpl.this;
            composerImpl.childrenComposing = composerImpl.childrenComposing + 1;
        }

        public void doneComposing$runtime_release() {
            ComposerImpl composerImpl = ComposerImpl.this;
            composerImpl.childrenComposing = composerImpl.childrenComposing - 1;
        }

        public void insertMovableContent$runtime_release(MovableContentStateReference reference) {
            Intrinsics.checkNotNullParameter(reference, "reference");
            ComposerImpl.this.parentContext.insertMovableContent$runtime_release(reference);
        }

        public void deletedMovableContent$runtime_release(MovableContentStateReference reference) {
            Intrinsics.checkNotNullParameter(reference, "reference");
            ComposerImpl.this.parentContext.deletedMovableContent$runtime_release(reference);
        }

        public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference reference) {
            Intrinsics.checkNotNullParameter(reference, "reference");
            return ComposerImpl.this.parentContext.movableContentStateResolve$runtime_release(reference);
        }

        public void movableContentStateReleased$runtime_release(MovableContentStateReference reference, MovableContentState data) {
            Intrinsics.checkNotNullParameter(reference, "reference");
            Intrinsics.checkNotNullParameter(data, "data");
            ComposerImpl.this.parentContext.movableContentStateReleased$runtime_release(reference, data);
        }
    }

    private final void updateCompoundKeyWhenWeEnterGroup(int groupKey, Object dataKey, Object data) {
        if (dataKey == null) {
            if (data == null || groupKey != 207 || Intrinsics.areEqual(data, Composer.Companion.getEmpty())) {
                updateCompoundKeyWhenWeEnterGroupKeyHash(groupKey);
            } else {
                updateCompoundKeyWhenWeEnterGroupKeyHash(data.hashCode());
            }
        } else if (dataKey instanceof Enum) {
            updateCompoundKeyWhenWeEnterGroupKeyHash(((Enum) dataKey).ordinal());
        } else {
            updateCompoundKeyWhenWeEnterGroupKeyHash(dataKey.hashCode());
        }
    }

    private final void updateCompoundKeyWhenWeEnterGroupKeyHash(int keyHash) {
        this.compoundKeyHash = Integer.rotateLeft(getCompoundKeyHash(), 3) ^ keyHash;
    }

    private final void updateCompoundKeyWhenWeExitGroup(int groupKey, Object dataKey, Object data) {
        if (dataKey == null) {
            if (data == null || groupKey != 207 || Intrinsics.areEqual(data, Composer.Companion.getEmpty())) {
                updateCompoundKeyWhenWeExitGroupKeyHash(groupKey);
            } else {
                updateCompoundKeyWhenWeExitGroupKeyHash(data.hashCode());
            }
        } else if (dataKey instanceof Enum) {
            updateCompoundKeyWhenWeExitGroupKeyHash(((Enum) dataKey).ordinal());
        } else {
            updateCompoundKeyWhenWeExitGroupKeyHash(dataKey.hashCode());
        }
    }

    private final void updateCompoundKeyWhenWeExitGroupKeyHash(int groupKey) {
        this.compoundKeyHash = Integer.rotateRight(getCompoundKeyHash() ^ Integer.hashCode(groupKey), 3);
    }

    public RecomposeScope getRecomposeScope() {
        return getCurrentRecomposeScope$runtime_release();
    }

    public Object getRecomposeScopeIdentity() {
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null) {
            return currentRecomposeScope$runtime_release.getAnchor();
        }
        return null;
    }

    public Object rememberedValue() {
        return nextSlot();
    }

    public void updateRememberedValue(Object value) {
        updateValue(value);
    }

    public void recordUsed(RecomposeScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        RecomposeScopeImpl recomposeScopeImpl = scope instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) scope : null;
        if (recomposeScopeImpl != null) {
            recomposeScopeImpl.setUsed(true);
        }
    }
}
