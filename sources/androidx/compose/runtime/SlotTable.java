package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010(\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0015J\u000e\u0010-\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0007J\u0006\u0010.\u001a\u00020/J\u0015\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\b4JW\u00100\u001a\u0002012\u0006\u0010)\u001a\u0002052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u0006\u0010#\u001a\u00020\u00152\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0000¢\u0006\u0004\b4\u00106J\u0006\u00107\u001a\u00020\u001aJ\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020\u001509H\u0002J\u0012\u0010:\u001a\u0004\u0018\u00010\u00032\u0006\u0010;\u001a\u00020\u001eH\u0016J\u0012\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020\u0015H\u0002J\u0016\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0007J\u000e\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001509H\u0002J\u0010\u0010B\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u0015H\u0002J\u001d\u0010C\u001a\n\u0012\u0004\u0012\u00020=\u0018\u0001092\u0006\u0010D\u001a\u00020\u0015H\u0000¢\u0006\u0002\bEJ\u000f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00030GH\u0002J\u000e\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001509H\u0002J\u000e\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001509H\u0002J\u0006\u0010J\u001a\u000203J\u0006\u0010K\u001a\u000205J\u000e\u0010L\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0007J\u000e\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001509H\u0002J:\u0010N\u001a\u0002HO\"\u0004\b\u0000\u0010O2!\u0010P\u001a\u001d\u0012\u0013\u0012\u001103¢\u0006\f\bR\u0012\b\bS\u0012\u0004\b\b(2\u0012\u0004\u0012\u0002HO0QH\bø\u0001\u0000¢\u0006\u0002\u0010TJO\u0010U\u001a\u0002012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u0006\u0010#\u001a\u00020\u00152\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0000¢\u0006\u0004\bV\u0010WJ\u001d\u0010X\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e092\u0006\u0010>\u001a\u00020\u0015H\u0000¢\u0006\u0002\bYJ\u0006\u0010Z\u001a\u000201J:\u0010[\u001a\u0002HO\"\u0004\b\u0000\u0010O2!\u0010P\u001a\u001d\u0012\u0013\u0012\u001105¢\u0006\f\bR\u0012\b\bS\u0012\u0004\b\b()\u0012\u0004\u0012\u0002HO0QH\bø\u0001\u0000¢\u0006\u0002\u0010TJ \u0010\\\u001a\u00020\u0015*\u00060]j\u0002`^2\u0006\u0010,\u001a\u00020\u00152\u0006\u0010_\u001a\u00020\u0015H\u0002R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R0\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d@BX\u000e¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001e\u0010#\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u001a\u0010%\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u001a@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001b\u0002\u0007\n\u0005\b20\u0001¨\u0006`"}, d2 = {"Landroidx/compose/runtime/SlotTable;", "Landroidx/compose/runtime/tooling/CompositionData;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "()V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "getAnchors$runtime_release", "()Ljava/util/ArrayList;", "setAnchors$runtime_release", "(Ljava/util/ArrayList;)V", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "<set-?>", "", "groups", "getGroups", "()[I", "", "groupsSize", "getGroupsSize", "()I", "isEmpty", "", "()Z", "readers", "", "", "slots", "getSlots", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "slotsSize", "getSlotsSize", "version", "getVersion$runtime_release", "setVersion$runtime_release", "(I)V", "writer", "getWriter$runtime_release", "anchor", "index", "anchorIndex", "asString", "", "close", "", "reader", "Landroidx/compose/runtime/SlotReader;", "close$runtime_release", "Landroidx/compose/runtime/SlotWriter;", "(Landroidx/compose/runtime/SlotWriter;[II[Ljava/lang/Object;ILjava/util/ArrayList;)V", "containsMark", "dataIndexes", "", "find", "identityToFind", "findEffectiveRecomposeScope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "group", "groupContainsAnchor", "groupIndex", "groupSizes", "invalidateGroup", "invalidateGroupsWithKey", "target", "invalidateGroupsWithKey$runtime_release", "iterator", "", "keys", "nodes", "openReader", "openWriter", "ownsAnchor", "parentIndexes", "read", "T", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "setTo", "setTo$runtime_release", "([II[Ljava/lang/Object;ILjava/util/ArrayList;)V", "slotsOf", "slotsOf$runtime_release", "verifyWellFormed", "write", "emitGroup", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "level", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SlotTable.kt */
public final class SlotTable implements CompositionData, Iterable<CompositionGroup>, KMappedMarker {
    private ArrayList<Anchor> anchors = new ArrayList<>();
    private int[] groups = new int[0];
    private int groupsSize;
    private int readers;
    private Object[] slots = new Object[0];
    private int slotsSize;
    private int version;
    private boolean writer;

    public final int[] getGroups() {
        return this.groups;
    }

    public final int getGroupsSize() {
        return this.groupsSize;
    }

    public final Object[] getSlots() {
        return this.slots;
    }

    public final int getSlotsSize() {
        return this.slotsSize;
    }

    public final boolean getWriter$runtime_release() {
        return this.writer;
    }

    public final int getVersion$runtime_release() {
        return this.version;
    }

    public final void setVersion$runtime_release(int i) {
        this.version = i;
    }

    public final ArrayList<Anchor> getAnchors$runtime_release() {
        return this.anchors;
    }

    public final void setAnchors$runtime_release(ArrayList<Anchor> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.anchors = arrayList;
    }

    public boolean isEmpty() {
        return this.groupsSize == 0;
    }

    public final <T> T read(Function1<? super SlotReader, ? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SlotReader reader = openReader();
        try {
            return block.invoke(reader);
        } finally {
            InlineMarker.finallyStart(1);
            reader.close();
            InlineMarker.finallyEnd(1);
        }
    }

    public final <T> T write(Function1<? super SlotWriter, ? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SlotWriter writer2 = openWriter();
        try {
            return block.invoke(writer2);
        } finally {
            InlineMarker.finallyStart(1);
            writer2.close();
            InlineMarker.finallyEnd(1);
        }
    }

    public final SlotReader openReader() {
        if (!this.writer) {
            this.readers++;
            return new SlotReader(this);
        }
        throw new IllegalStateException("Cannot read while a writer is pending".toString());
    }

    public final SlotWriter openWriter() {
        if (!this.writer) {
            if (this.readers <= 0) {
                this.writer = true;
                this.version++;
                return new SlotWriter(this);
            }
            ComposerKt.composeRuntimeError("Cannot start a writer when a reader is pending".toString());
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("Cannot start a writer when another writer is pending".toString());
        throw new KotlinNothingValueException();
    }

    public final Anchor anchor(int index) {
        boolean z = true;
        if (!this.writer) {
            if (index < 0 || index >= this.groupsSize) {
                z = false;
            }
            if (z) {
                ArrayList $this$getOrAdd$iv = this.anchors;
                int location$iv = SlotTableKt.search($this$getOrAdd$iv, index, this.groupsSize);
                if (location$iv < 0) {
                    Anchor anchor$iv = new Anchor(index);
                    $this$getOrAdd$iv.add(-(location$iv + 1), anchor$iv);
                    return anchor$iv;
                }
                Anchor anchor = $this$getOrAdd$iv.get(location$iv);
                Intrinsics.checkNotNullExpressionValue(anchor, "get(location)");
                return anchor;
            }
            throw new IllegalArgumentException("Parameter index is out of range".toString());
        }
        ComposerKt.composeRuntimeError("use active SlotWriter to create an anchor location instead ".toString());
        throw new KotlinNothingValueException();
    }

    public final int anchorIndex(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (!(!this.writer)) {
            ComposerKt.composeRuntimeError("Use active SlotWriter to determine anchor location instead".toString());
            throw new KotlinNothingValueException();
        } else if (anchor.getValid()) {
            return anchor.getLocation$runtime_release();
        } else {
            throw new IllegalArgumentException("Anchor refers to a group that was removed".toString());
        }
    }

    public final boolean ownsAnchor(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (!anchor.getValid()) {
            return false;
        }
        int it = SlotTableKt.search(this.anchors, anchor.getLocation$runtime_release(), this.groupsSize);
        return ((it < 0 || !Intrinsics.areEqual((Object) this.anchors.get(it), (Object) anchor)) ? 0 : 1) != 0;
    }

    public final boolean groupContainsAnchor(int groupIndex, Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (!this.writer) {
            if (groupIndex >= 0 && groupIndex < this.groupsSize) {
                if (ownsAnchor(anchor)) {
                    int access$groupSize = SlotTableKt.groupSize(this.groups, groupIndex) + groupIndex;
                    int location$runtime_release = anchor.getLocation$runtime_release();
                    if (groupIndex <= location$runtime_release && location$runtime_release < access$groupSize) {
                        return true;
                    }
                }
                return false;
            }
            ComposerKt.composeRuntimeError("Invalid group index".toString());
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("Writer is active".toString());
        throw new KotlinNothingValueException();
    }

    public final void close$runtime_release(SlotReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (reader.getTable$runtime_release() == this && this.readers > 0) {
            this.readers--;
        } else {
            ComposerKt.composeRuntimeError("Unexpected reader close()".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void close$runtime_release(SlotWriter writer2, int[] groups2, int groupsSize2, Object[] slots2, int slotsSize2, ArrayList<Anchor> anchors2) {
        Intrinsics.checkNotNullParameter(writer2, "writer");
        Intrinsics.checkNotNullParameter(groups2, "groups");
        Intrinsics.checkNotNullParameter(slots2, "slots");
        Intrinsics.checkNotNullParameter(anchors2, "anchors");
        if (writer2.getTable$runtime_release() == this && this.writer) {
            this.writer = false;
            setTo$runtime_release(groups2, groupsSize2, slots2, slotsSize2, anchors2);
            return;
        }
        throw new IllegalArgumentException("Unexpected writer close()".toString());
    }

    public final void setTo$runtime_release(int[] groups2, int groupsSize2, Object[] slots2, int slotsSize2, ArrayList<Anchor> anchors2) {
        Intrinsics.checkNotNullParameter(groups2, "groups");
        Intrinsics.checkNotNullParameter(slots2, "slots");
        Intrinsics.checkNotNullParameter(anchors2, "anchors");
        this.groups = groups2;
        this.groupsSize = groupsSize2;
        this.slots = slots2;
        this.slotsSize = slotsSize2;
        this.anchors = anchors2;
    }

    /* JADX INFO: finally extract failed */
    public final List<RecomposeScopeImpl> invalidateGroupsWithKey$runtime_release(int target) {
        List anchors2 = new ArrayList();
        List<RecomposeScopeImpl> arrayList = new ArrayList<>();
        Ref.BooleanRef allScopesFound = new Ref.BooleanRef();
        allScopesFound.element = true;
        SlotReader reader$iv = openReader();
        try {
            invalidateGroupsWithKey$lambda$14$scanGroup(reader$iv, target, anchors2, allScopesFound, this, arrayList);
            Unit unit = Unit.INSTANCE;
            reader$iv.close();
            SlotTable this_$iv = this;
            int $i$f$write = false;
            SlotWriter writer$iv = this_$iv.openWriter();
            SlotWriter writer2 = writer$iv;
            try {
                writer2.startGroup();
                List $this$fastForEach$iv = anchors2;
                int index$iv = 0;
                int size = $this$fastForEach$iv.size();
                while (index$iv < size) {
                    Anchor anchor = (Anchor) $this$fastForEach$iv.get(index$iv);
                    SlotTable this_$iv2 = this_$iv;
                    try {
                        int $i$f$write2 = $i$f$write;
                        if (anchor.toIndexFor(writer2) >= writer2.getCurrentGroup()) {
                            writer2.seek(anchor);
                            writer2.bashGroup$runtime_release();
                        }
                        index$iv++;
                        this_$iv = this_$iv2;
                        $i$f$write = $i$f$write2;
                    } catch (Throwable th) {
                        th = th;
                        writer$iv.close();
                        throw th;
                    }
                }
                int i = $i$f$write;
                writer2.skipToGroupEnd();
                writer2.endGroup();
                writer$iv.close();
                if (allScopesFound.element) {
                    return arrayList;
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                SlotTable slotTable = this_$iv;
                writer$iv.close();
                throw th;
            }
        } catch (Throwable th3) {
            reader$iv.close();
            throw th3;
        }
    }

    private static final void invalidateGroupsWithKey$lambda$14$scanGroup(SlotReader $reader, int $target, List<Anchor> anchors2, Ref.BooleanRef allScopesFound, SlotTable this$0, List<RecomposeScopeImpl> scopes) {
        if ($reader.getGroupKey() == $target) {
            anchors2.add(SlotReader.anchor$default($reader, 0, 1, (Object) null));
            if (allScopesFound.element) {
                RecomposeScopeImpl nearestScope = this$0.findEffectiveRecomposeScope($reader.getCurrentGroup());
                if (nearestScope != null) {
                    scopes.add(nearestScope);
                } else {
                    allScopesFound.element = false;
                    scopes.clear();
                }
            }
            $reader.skipGroup();
            return;
        }
        $reader.startGroup();
        while (!$reader.isGroupEnd()) {
            invalidateGroupsWithKey$lambda$14$scanGroup($reader, $target, anchors2, allScopesFound, this$0, scopes);
        }
        $reader.endGroup();
    }

    public final boolean containsMark() {
        return this.groupsSize > 0 && SlotTableKt.containsMark(this.groups, 0);
    }

    private final RecomposeScopeImpl findEffectiveRecomposeScope(int group) {
        int current = group;
        while (current > 0) {
            Iterator<Object> it = new DataIterator(this, current).iterator();
            while (it.hasNext()) {
                Object data = it.next();
                if (data instanceof RecomposeScopeImpl) {
                    return (RecomposeScopeImpl) data;
                }
            }
            current = SlotTableKt.parentAnchor(this.groups, current);
        }
        return null;
    }

    private final boolean invalidateGroup(int group) {
        int current = group;
        while (current >= 0) {
            Iterator<Object> it = new DataIterator(this, current).iterator();
            while (it.hasNext()) {
                Object data = it.next();
                if (data instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) data).setRequiresRecompose(true);
                    if (((RecomposeScopeImpl) data).invalidateForResult((Object) null) != InvalidationResult.IGNORED) {
                        return true;
                    }
                    return false;
                }
            }
            current = SlotTableKt.parentAnchor(this.groups, current);
        }
        return false;
    }

    public final void verifyWellFormed() {
        Ref.IntRef current = new Ref.IntRef();
        if (this.groupsSize > 0) {
            while (current.element < this.groupsSize) {
                verifyWellFormed$validateGroup(current, this, -1, current.element + SlotTableKt.groupSize(this.groups, current.element));
            }
            if (!(current.element == this.groupsSize)) {
                throw new IllegalStateException(("Incomplete group at root " + current.element + " expected to be " + this.groupsSize).toString());
            }
        }
        int lastLocation = -1;
        List $this$fastForEach$iv = this.anchors;
        int index$iv = 0;
        int size = $this$fastForEach$iv.size();
        while (index$iv < size) {
            int location = ((Anchor) $this$fastForEach$iv.get(index$iv)).toIndexFor(this);
            if (location >= 0 && location <= this.groupsSize) {
                if (lastLocation < location) {
                    lastLocation = location;
                    index$iv++;
                } else {
                    throw new IllegalArgumentException("Anchor is out of order".toString());
                }
            } else {
                throw new IllegalArgumentException("Invalid anchor, location out of bound".toString());
            }
        }
    }

    private static final int verifyWellFormed$validateGroup(Ref.IntRef current, SlotTable this$0, int parent, int parentEnd) {
        Ref.IntRef intRef = current;
        SlotTable slotTable = this$0;
        int i = parent;
        int group = intRef.element;
        intRef.element = group + 1;
        int parentIndex = SlotTableKt.parentAnchor(slotTable.groups, group);
        if (parentIndex == i) {
            int end = SlotTableKt.groupSize(slotTable.groups, group) + group;
            if (end <= slotTable.groupsSize) {
                if (end <= parentEnd) {
                    int dataStart = SlotTableKt.dataAnchor(slotTable.groups, group);
                    int dataEnd = group >= slotTable.groupsSize - 1 ? slotTable.slotsSize : SlotTableKt.dataAnchor(slotTable.groups, group + 1);
                    if (dataEnd <= slotTable.slots.length) {
                        if (dataStart <= dataEnd) {
                            if (SlotTableKt.slotAnchor(slotTable.groups, group) <= dataEnd) {
                                if (dataEnd - dataStart >= ((SlotTableKt.isNode(slotTable.groups, group) ? 1 : 0) + (SlotTableKt.hasObjectKey(slotTable.groups, group) ? 1 : 0)) + (SlotTableKt.hasAux(slotTable.groups, group) ? 1 : 0)) {
                                    boolean isNode = SlotTableKt.isNode(slotTable.groups, group);
                                    if (!isNode || slotTable.slots[SlotTableKt.nodeIndex(slotTable.groups, group)] != null) {
                                        int nodeCount = 0;
                                        while (intRef.element < end) {
                                            nodeCount += verifyWellFormed$validateGroup(intRef, slotTable, group, end);
                                        }
                                        int expectedNodeCount = SlotTableKt.nodeCount(slotTable.groups, group);
                                        int expectedSlotCount = SlotTableKt.groupSize(slotTable.groups, group);
                                        int i2 = end;
                                        if (expectedNodeCount == nodeCount) {
                                            int actualSlotCount = intRef.element - group;
                                            if (expectedSlotCount == actualSlotCount) {
                                                if (SlotTableKt.containsAnyMark(slotTable.groups, group)) {
                                                    if (!(group <= 0 || SlotTableKt.containsMark(slotTable.groups, i))) {
                                                        throw new IllegalStateException(("Expected group " + i + " to record it contains a mark because " + group + " does").toString());
                                                    }
                                                }
                                                if (isNode) {
                                                    return 1;
                                                }
                                                return nodeCount;
                                            }
                                            throw new IllegalStateException(("Incorrect slot count detected at " + group + ", expected " + expectedSlotCount + ", received " + actualSlotCount).toString());
                                        }
                                        throw new IllegalStateException(("Incorrect node count detected at " + group + ", expected " + expectedNodeCount + ", received " + nodeCount).toString());
                                    }
                                    throw new IllegalStateException(("No node recorded for a node group at " + group).toString());
                                }
                                throw new IllegalStateException(("Not enough slots added for group " + group).toString());
                            }
                            throw new IllegalStateException(("Slots start out of range at " + group).toString());
                        }
                        throw new IllegalStateException(("Invalid data anchor at " + group).toString());
                    }
                    throw new IllegalStateException(("Slots for " + group + " extend past the end of the slot table").toString());
                }
                throw new IllegalStateException(("A group extends past its parent group at " + group).toString());
            }
            throw new IllegalStateException(("A group extends past the end of the table at " + group).toString());
        }
        throw new IllegalStateException(("Invalid parent index detected at " + group + ", expected parent index to be " + i + " found " + parentIndex).toString());
    }

    public final String asString() {
        if (this.writer) {
            return super.toString();
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder $this$asString_u24lambda_u2432 = sb;
        $this$asString_u24lambda_u2432.append(super.toString());
        $this$asString_u24lambda_u2432.append(10);
        int groupsSize2 = this.groupsSize;
        if (groupsSize2 > 0) {
            int current = 0;
            while (current < groupsSize2) {
                current += emitGroup($this$asString_u24lambda_u2432, current, 0);
            }
        } else {
            $this$asString_u24lambda_u2432.append("<EMPTY>");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private final int emitGroup(StringBuilder $this$emitGroup, int index, int level) {
        boolean z = false;
        for (int i = 0; i < level; i++) {
            int i2 = i;
            $this$emitGroup.append(' ');
        }
        $this$emitGroup.append("Group(");
        $this$emitGroup.append(index);
        $this$emitGroup.append(") key=");
        $this$emitGroup.append(SlotTableKt.key(this.groups, index));
        int groupSize = SlotTableKt.groupSize(this.groups, index);
        $this$emitGroup.append(", nodes=");
        $this$emitGroup.append(SlotTableKt.nodeCount(this.groups, index));
        $this$emitGroup.append(", size=");
        $this$emitGroup.append(groupSize);
        if (SlotTableKt.hasMark(this.groups, index)) {
            $this$emitGroup.append(", mark");
        }
        if (SlotTableKt.containsMark(this.groups, index)) {
            $this$emitGroup.append(", contains mark");
        }
        int dataStart = emitGroup$dataIndex(this, index);
        int dataEnd = emitGroup$dataIndex(this, index + 1);
        if (dataStart >= 0 && dataStart <= dataEnd) {
            z = true;
        }
        if (!z || dataEnd > this.slotsSize) {
            $this$emitGroup.append(", *invalid data offsets " + dataStart + '-' + dataEnd + '*');
        } else {
            if (SlotTableKt.hasObjectKey(this.groups, index)) {
                $this$emitGroup.append(" objectKey=" + this.slots[SlotTableKt.objectKeyIndex(this.groups, index)]);
            }
            if (SlotTableKt.isNode(this.groups, index)) {
                $this$emitGroup.append(" node=" + this.slots[SlotTableKt.nodeIndex(this.groups, index)]);
            }
            if (SlotTableKt.hasAux(this.groups, index)) {
                $this$emitGroup.append(" aux=" + this.slots[SlotTableKt.auxIndex(this.groups, index)]);
            }
            int slotStart = SlotTableKt.slotAnchor(this.groups, index);
            if (slotStart < dataEnd) {
                $this$emitGroup.append(", slots=[");
                $this$emitGroup.append(slotStart);
                $this$emitGroup.append(": ");
                for (int dataIndex = slotStart; dataIndex < dataEnd; dataIndex++) {
                    if (dataIndex != slotStart) {
                        $this$emitGroup.append(", ");
                    }
                    $this$emitGroup.append(String.valueOf(this.slots[dataIndex]));
                }
                $this$emitGroup.append("]");
            }
        }
        $this$emitGroup.append(10);
        int current = index + 1;
        int end = index + groupSize;
        while (current < end) {
            current += emitGroup($this$emitGroup, current, level + 1);
        }
        return groupSize;
    }

    private static final int emitGroup$dataIndex(SlotTable this$0, int index) {
        return index >= this$0.groupsSize ? this$0.slotsSize : SlotTableKt.dataAnchor(this$0.groups, index);
    }

    private final List<Integer> keys() {
        return SlotTableKt.keys(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> nodes() {
        return SlotTableKt.nodeCounts(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> parentIndexes() {
        return SlotTableKt.parentAnchors(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> dataIndexes() {
        return SlotTableKt.dataAnchors(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> groupSizes() {
        return SlotTableKt.groupSizes(this.groups, this.groupsSize * 5);
    }

    public final List<Object> slotsOf$runtime_release(int group) {
        return ArraysKt.toList((T[]) this.slots).subList(SlotTableKt.dataAnchor(this.groups, group), group + 1 < this.groupsSize ? SlotTableKt.dataAnchor(this.groups, group + 1) : this.slots.length);
    }

    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }

    public Iterator<CompositionGroup> iterator() {
        return new GroupIterator(this, 0, this.groupsSize);
    }

    public CompositionGroup find(Object identityToFind) {
        Intrinsics.checkNotNullParameter(identityToFind, "identityToFind");
        return new SlotTableGroup(this, 0, 0, 4, (DefaultConstructorMarker) null).find(identityToFind);
    }
}
