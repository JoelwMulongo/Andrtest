package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u001f\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b8\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\nJ\u000e\u00105\u001a\u0002022\u0006\u00104\u001a\u00020\nJ\u0010\u00106\u001a\u00020\u00072\b\b\u0002\u00107\u001a\u00020\nJ\u000e\u00108\u001a\u00020\n2\u0006\u00106\u001a\u00020\u0007J\r\u00109\u001a\u000202H\u0000¢\u0006\u0002\b:J\u0006\u0010;\u001a\u000202J\u0010\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\nH\u0002J\u0006\u0010>\u001a\u000202J\u0010\u0010?\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\nH\u0002J\u0010\u0010@\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\nH\u0002J \u0010A\u001a\u00020\n2\u0006\u00106\u001a\u00020\n2\u0006\u0010B\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010C\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0002J\u0010\u0010D\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0002J(\u0010E\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u0010F\u001a\u00020\n2\u0006\u0010B\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010G\u001a\u00020\nJ\u0006\u0010H\u001a\u000202J\u000e\u0010I\u001a\u0002022\u0006\u00106\u001a\u00020\u0007J\u000e\u0010I\u001a\u0002022\u0006\u00107\u001a\u00020\nJ \u0010J\u001a\u0002022\u0006\u0010\"\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n2\u0006\u0010K\u001a\u00020\nH\u0002J\u0010\u0010L\u001a\u0004\u0018\u00010\u00012\u0006\u00107\u001a\u00020\nJ\u0010\u0010M\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0002J\u000e\u0010N\u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u0010\u0010O\u001a\u0004\u0018\u00010\u00012\u0006\u00107\u001a\u00020\nJ\u000e\u0010P\u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u000e\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010RJ\u0006\u0010S\u001a\u00020TJ\u000e\u0010U\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\nJ\u0016\u0010V\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010W\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\nJ\u0010\u0010X\u001a\u0002022\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u0010\u0010Z\u001a\u0002022\u0006\u0010&\u001a\u00020\nH\u0002J\u000e\u0010[\u001a\u0002022\u0006\u0010\\\u001a\u00020\nJ\u0018\u0010]\u001a\u0002022\u0006\u0010&\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0002J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\nJ\u000e\u0010^\u001a\b\u0012\u0004\u0012\u00020\n0_H\u0002J\u0010\u0010`\u001a\u0002022\b\b\u0002\u0010=\u001a\u00020\nJ \u0010a\u001a\u0002022\u0006\u0010b\u001a\u00020\n2\u0006\u0010c\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J\u001c\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00070_2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00107\u001a\u00020\nJ\u000e\u0010e\u001a\u0002022\u0006\u0010f\u001a\u00020\nJ\u0010\u0010g\u001a\u0002022\u0006\u00107\u001a\u00020\nH\u0002J$\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00070_2\u0006\u0010f\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00107\u001a\u00020\nJ\u0018\u0010i\u001a\u0002022\u0006\u00107\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0002J$\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00070_2\u0006\u00106\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\n2\u0006\u0010k\u001a\u00020\u0000J\u0010\u0010l\u001a\u0004\u0018\u00010\u00012\u0006\u00106\u001a\u00020\u0007J\u0010\u0010l\u001a\u0004\u0018\u00010\u00012\u0006\u00107\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\n2\u0006\u00106\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u0010\u0010m\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0002J\u0018\u0010n\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u0010F\u001a\u00020\nH\u0002J\b\u0010o\u001a\u000202H\u0002J\u0018\u0010p\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J\u0006\u0010q\u001a\u00020\u000eJ\u0018\u0010r\u001a\u00020\u000e2\u0006\u0010s\u001a\u00020\n2\u0006\u0010t\u001a\u00020\nH\u0002J \u0010u\u001a\u0002022\u0006\u0010s\u001a\u00020\n2\u0006\u0010t\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0002J\u0006\u0010v\u001a\u000202J\b\u0010w\u001a\u00020\nH\u0002J\b\u0010x\u001a\u000202H\u0002J\u000e\u0010y\u001a\u0002022\u0006\u00106\u001a\u00020\u0007J\u0010\u0010z\u001a\u0002022\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u001a\u0010z\u001a\u0004\u0018\u00010\u00012\u0006\u00107\u001a\u00020\n2\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\b\u0010{\u001a\u0004\u0018\u00010\u0001J\u0006\u0010|\u001a\u00020\nJ\u0006\u0010}\u001a\u000202J\u0018\u0010~\u001a\u0004\u0018\u00010\u00012\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\nJ\u0018\u0010~\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u001a\u0010\u0001\u001a\u0002022\u0006\u0010\\\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001J%\u0010\u0001\u001a\u0002022\u0006\u0010\\\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001J\u0007\u0010\u0001\u001a\u000202J\u000f\u0010\u0001\u001a\u0002022\u0006\u0010\\\u001a\u00020\nJ\u001a\u0010\u0001\u001a\u0002022\u0006\u0010\\\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001J/\u0010\u0001\u001a\u0002022\u0006\u0010\\\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u00020\u000e2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001H\u0002J\u001a\u0010\u0001\u001a\u0002022\u0006\u0010\\\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001J$\u0010\u0001\u001a\u0002022\u0006\u0010\\\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010l\u001a\u0004\u0018\u00010\u0001J\t\u0010\u0001\u001a\u00020TH\u0016J\u0013\u0010\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u001b\u0010\u0001\u001a\u0002022\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0002J\u0011\u0010\u0001\u001a\u0002022\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u0011\u0010\u0001\u001a\u0002022\u0006\u0010=\u001a\u00020\nH\u0002J\u0019\u0010\u0001\u001a\u0002022\u0006\u0010=\u001a\u00020\n2\u0006\u0010z\u001a\u00020%H\u0002J\u0019\u0010\u0001\u001a\u0002022\u0006\u00106\u001a\u00020\u00072\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u0011\u0010\u0001\u001a\u0002022\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u001b\u0010\u0001\u001a\u0002022\u0006\u00107\u001a\u00020\n2\b\u0010Y\u001a\u0004\u0018\u00010\u0001H\u0002J\u0011\u0010\u0001\u001a\u0002022\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u000f\u0010\u0001\u001a\u000202H\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u000202H\u0000¢\u0006\u0003\b\u0001J\u0015\u0010\u0001\u001a\u00020\n*\u00020\u001c2\u0006\u00103\u001a\u00020\nH\u0002J\u0014\u0010C\u001a\u00020\n*\u00020\u001c2\u0006\u00103\u001a\u00020\nH\u0002J\u0013\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\n0_*\u00020\u001cH\u0002J\u001b\u0010\u0001\u001a\u000202*\b0\u0001j\u0003`\u00012\u0006\u00107\u001a\u00020\nH\u0002J\u0015\u0010\u0001\u001a\u00020\n*\u00020\u001c2\u0006\u00103\u001a\u00020\nH\u0002J\u0014\u0010\"\u001a\u00020\n*\u00020\u001c2\u0006\u00107\u001a\u00020\nH\u0002J\u0015\u0010\u0001\u001a\u00020\n*\u00020\u001c2\u0006\u00103\u001a\u00020\nH\u0002J\u001d\u0010\u0001\u001a\u000202*\u00020\u001c2\u0006\u00103\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u000e\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0011R\u0011\u0010\u001f\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011R\u000e\u0010 \u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\fR\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\fR\u0018\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010)X\u000e¢\u0006\u0004\n\u0002\u0010*R\u000e\u0010+\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/SlotWriter;", "", "table", "Landroidx/compose/runtime/SlotTable;", "(Landroidx/compose/runtime/SlotTable;)V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "capacity", "", "getCapacity", "()I", "<set-?>", "", "closed", "getClosed", "()Z", "currentGroup", "getCurrentGroup", "currentGroupEnd", "currentSlot", "currentSlotEnd", "endStack", "Landroidx/compose/runtime/IntStack;", "groupGapLen", "groupGapStart", "groups", "", "insertCount", "isGroupEnd", "isNode", "nodeCount", "nodeCountStack", "parent", "getParent", "pendingRecalculateMarks", "Landroidx/compose/runtime/PrioritySet;", "size", "getSize$runtime_release", "slots", "", "[Ljava/lang/Object;", "slotsGapLen", "slotsGapOwner", "slotsGapStart", "startStack", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "addToGroupSizeAlongSpine", "", "address", "amount", "advanceBy", "anchor", "index", "anchorIndex", "bashGroup", "bashGroup$runtime_release", "beginInsert", "childContainsAnyMarks", "group", "close", "containsAnyGroupMarks", "containsGroupMark", "dataAnchorToDataIndex", "gapLen", "dataIndex", "dataIndexToDataAddress", "dataIndexToDataAnchor", "gapStart", "endGroup", "endInsert", "ensureStarted", "fixParentAnchorsFor", "firstChild", "groupAux", "groupIndexToAddress", "groupKey", "groupObjectKey", "groupSize", "groupSlots", "", "groupsAsString", "", "indexInCurrentGroup", "indexInGroup", "indexInParent", "insertAux", "value", "insertGroups", "insertParentGroup", "key", "insertSlots", "keys", "", "markGroup", "moveAnchors", "originalLocation", "newLocation", "moveFrom", "moveGroup", "offset", "moveGroupGapTo", "moveIntoGroupFrom", "moveSlotGapTo", "moveTo", "writer", "node", "parentAnchorToIndex", "parentIndexToAnchor", "recalculateMarks", "removeAnchors", "removeGroup", "removeGroups", "start", "len", "removeSlots", "reset", "restoreCurrentGroupEnd", "saveCurrentGroupEnd", "seek", "set", "skip", "skipGroup", "skipToGroupEnd", "slot", "groupIndex", "startData", "aux", "objectKey", "startGroup", "dataKey", "startNode", "toString", "update", "updateAnchors", "previousGapStart", "newGapStart", "updateAux", "updateContainsMark", "updateContainsMarkNow", "updateNode", "updateNodeOfGroup", "updateParentNode", "verifyDataAnchors", "verifyDataAnchors$runtime_release", "verifyParentAnchors", "verifyParentAnchors$runtime_release", "auxIndex", "dataIndexes", "groupAsString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nodeIndex", "slotIndex", "updateDataIndex", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SlotTable.kt */
public final class SlotWriter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public ArrayList<Anchor> anchors;
    private boolean closed;
    /* access modifiers changed from: private */
    public int currentGroup;
    private int currentGroupEnd;
    /* access modifiers changed from: private */
    public int currentSlot;
    private int currentSlotEnd;
    private final IntStack endStack = new IntStack();
    private int groupGapLen;
    /* access modifiers changed from: private */
    public int groupGapStart;
    /* access modifiers changed from: private */
    public int[] groups;
    private int insertCount;
    /* access modifiers changed from: private */
    public int nodeCount;
    private final IntStack nodeCountStack = new IntStack();
    private int parent = -1;
    private PrioritySet pendingRecalculateMarks;
    /* access modifiers changed from: private */
    public Object[] slots;
    /* access modifiers changed from: private */
    public int slotsGapLen;
    /* access modifiers changed from: private */
    public int slotsGapOwner;
    /* access modifiers changed from: private */
    public int slotsGapStart;
    private final IntStack startStack = new IntStack();
    private final SlotTable table;

    public SlotWriter(SlotTable table2) {
        Intrinsics.checkNotNullParameter(table2, "table");
        this.table = table2;
        this.groups = table2.getGroups();
        this.slots = table2.getSlots();
        this.anchors = table2.getAnchors$runtime_release();
        this.groupGapStart = table2.getGroupsSize();
        this.groupGapLen = (this.groups.length / 5) - table2.getGroupsSize();
        this.currentGroupEnd = table2.getGroupsSize();
        this.slotsGapStart = table2.getSlotsSize();
        this.slotsGapLen = this.slots.length - table2.getSlotsSize();
        this.slotsGapOwner = table2.getGroupsSize();
    }

    public final SlotTable getTable$runtime_release() {
        return this.table;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final boolean isGroupEnd() {
        return this.currentGroup == this.currentGroupEnd;
    }

    public final boolean isNode() {
        int i = this.currentGroup;
        return i < this.currentGroupEnd && SlotTableKt.isNode(this.groups, groupIndexToAddress(i));
    }

    public final boolean isNode(int index) {
        return SlotTableKt.isNode(this.groups, groupIndexToAddress(index));
    }

    public final int nodeCount(int index) {
        return SlotTableKt.nodeCount(this.groups, groupIndexToAddress(index));
    }

    public final int groupKey(int index) {
        return SlotTableKt.key(this.groups, groupIndexToAddress(index));
    }

    public final Object groupObjectKey(int index) {
        int address = groupIndexToAddress(index);
        if (SlotTableKt.hasObjectKey(this.groups, address)) {
            return this.slots[SlotTableKt.objectKeyIndex(this.groups, address)];
        }
        return null;
    }

    public final int groupSize(int index) {
        return SlotTableKt.groupSize(this.groups, groupIndexToAddress(index));
    }

    public final Object groupAux(int index) {
        int address = groupIndexToAddress(index);
        return SlotTableKt.hasAux(this.groups, address) ? this.slots[auxIndex(this.groups, address)] : Composer.Companion.getEmpty();
    }

    public final boolean indexInParent(int index) {
        int i = this.parent;
        return (index > i && index < this.currentGroupEnd) || (i == 0 && index == 0);
    }

    public final boolean indexInCurrentGroup(int index) {
        return indexInGroup(index, this.currentGroup);
    }

    public final boolean indexInGroup(int index, int group) {
        int end;
        if (group == this.parent) {
            end = this.currentGroupEnd;
        } else if (group > this.startStack.peekOr(0)) {
            end = groupSize(group) + group;
        } else {
            int openIndex = this.startStack.indexOf(group);
            if (openIndex < 0) {
                end = groupSize(group) + group;
            } else {
                end = (getCapacity() - this.groupGapLen) - this.endStack.peek(openIndex);
            }
        }
        if (index <= group || index >= end) {
            return false;
        }
        return true;
    }

    public final Object node(int index) {
        int address = groupIndexToAddress(index);
        if (SlotTableKt.isNode(this.groups, address)) {
            return this.slots[dataIndexToDataAddress(nodeIndex(this.groups, address))];
        }
        return null;
    }

    public final Object node(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return node(anchor.toIndexFor(this));
    }

    public final int getParent() {
        return this.parent;
    }

    public final int parent(int index) {
        return parent(this.groups, index);
    }

    public final int parent(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (anchor.getValid()) {
            return parent(this.groups, anchorIndex(anchor));
        }
        return -1;
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final void close() {
        this.closed = true;
        if (this.startStack.isEmpty()) {
            moveGroupGapTo(getSize$runtime_release());
            moveSlotGapTo(this.slots.length - this.slotsGapLen, this.groupGapStart);
            recalculateMarks();
        }
        this.table.close$runtime_release(this, this.groups, this.groupGapStart, this.slots, this.slotsGapStart, this.anchors);
    }

    public final void reset() {
        if (this.insertCount == 0) {
            recalculateMarks();
            this.currentGroup = 0;
            this.currentGroupEnd = getCapacity() - this.groupGapLen;
            this.currentSlot = 0;
            this.currentSlotEnd = 0;
            this.nodeCount = 0;
            return;
        }
        ComposerKt.composeRuntimeError("Cannot reset when inserting".toString());
        throw new KotlinNothingValueException();
    }

    public final Object update(Object value) {
        Object result = skip();
        set(value);
        return result;
    }

    public final void updateAux(Object value) {
        int address = groupIndexToAddress(this.currentGroup);
        if (SlotTableKt.hasAux(this.groups, address)) {
            this.slots[dataIndexToDataAddress(auxIndex(this.groups, address))] = value;
        } else {
            ComposerKt.composeRuntimeError("Updating the data of a group that was not created with a data slot".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void insertAux(Object value) {
        boolean z = false;
        if (this.insertCount >= 0) {
            int parent2 = this.parent;
            int parentGroupAddress = groupIndexToAddress(parent2);
            if (!SlotTableKt.hasAux(this.groups, parentGroupAddress)) {
                insertSlots(1, parent2);
                int auxIndex = auxIndex(this.groups, parentGroupAddress);
                int auxAddress = dataIndexToDataAddress(auxIndex);
                int i = this.currentSlot;
                if (i > auxIndex) {
                    int slotsToMove = i - auxIndex;
                    if (slotsToMove < 3) {
                        z = true;
                    }
                    if (z) {
                        if (slotsToMove > 1) {
                            Object[] objArr = this.slots;
                            objArr[auxAddress + 2] = objArr[auxAddress + 1];
                        }
                        Object[] objArr2 = this.slots;
                        objArr2[auxAddress + 1] = objArr2[auxAddress];
                    } else {
                        throw new IllegalStateException("Moving more than two slot not supported".toString());
                    }
                }
                SlotTableKt.addAux(this.groups, parentGroupAddress);
                this.slots[auxAddress] = value;
                this.currentSlot++;
                return;
            }
            ComposerKt.composeRuntimeError("Group already has auxiliary data".toString());
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("Cannot insert auxiliary data when not inserting".toString());
        throw new KotlinNothingValueException();
    }

    public final void updateNode(Object value) {
        updateNodeOfGroup(this.currentGroup, value);
    }

    public final void updateNode(Anchor anchor, Object value) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateNodeOfGroup(anchor.toIndexFor(this), value);
    }

    public final void updateParentNode(Object value) {
        updateNodeOfGroup(this.parent, value);
    }

    public final void set(Object value) {
        int i = this.currentSlot;
        if (i <= this.currentSlotEnd) {
            this.slots[dataIndexToDataAddress(i - 1)] = value;
        } else {
            ComposerKt.composeRuntimeError("Writing to an invalid slot".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final Object set(int index, Object value) {
        int slotsStart = slotIndex(this.groups, groupIndexToAddress(this.currentGroup));
        boolean value$iv = true;
        int slotsEnd = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
        int slotsIndex = slotsStart + index;
        if (slotsIndex < slotsStart || slotsIndex >= slotsEnd) {
            value$iv = false;
        }
        if (value$iv) {
            int slotAddress = dataIndexToDataAddress(slotsIndex);
            Object[] objArr = this.slots;
            Object result = objArr[slotAddress];
            objArr[slotAddress] = value;
            return result;
        }
        ComposerKt.composeRuntimeError(("Write to an invalid slot index " + index + " for group " + this.currentGroup).toString());
        throw new KotlinNothingValueException();
    }

    public final Object skip() {
        if (this.insertCount > 0) {
            insertSlots(1, this.parent);
        }
        Object[] objArr = this.slots;
        int i = this.currentSlot;
        this.currentSlot = i + 1;
        return objArr[dataIndexToDataAddress(i)];
    }

    public final Object slot(Anchor anchor, int index) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return slot(anchorIndex(anchor), index);
    }

    public final Object slot(int groupIndex, int index) {
        int slotsStart = slotIndex(this.groups, groupIndexToAddress(groupIndex));
        int slotsEnd = dataIndex(this.groups, groupIndexToAddress(groupIndex + 1));
        int slotsIndex = slotsStart + index;
        boolean z = false;
        if (slotsStart <= slotsIndex && slotsIndex < slotsEnd) {
            z = true;
        }
        if (!z) {
            return Composer.Companion.getEmpty();
        }
        return this.slots[dataIndexToDataAddress(slotsIndex)];
    }

    public final void advanceBy(int amount) {
        boolean value$iv = true;
        if (amount >= 0) {
            if (!(this.insertCount <= 0)) {
                throw new IllegalStateException("Cannot call seek() while inserting".toString());
            } else if (amount != 0) {
                int index = this.currentGroup + amount;
                if (index < this.parent || index > this.currentGroupEnd) {
                    value$iv = false;
                }
                if (value$iv) {
                    this.currentGroup = index;
                    int newSlot = dataIndex(this.groups, groupIndexToAddress(index));
                    this.currentSlot = newSlot;
                    this.currentSlotEnd = newSlot;
                    return;
                }
                ComposerKt.composeRuntimeError(("Cannot seek outside the current group (" + this.parent + '-' + this.currentGroupEnd + ')').toString());
                throw new KotlinNothingValueException();
            }
        } else {
            ComposerKt.composeRuntimeError("Cannot seek backwards".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void seek(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        advanceBy(anchor.toIndexFor(this) - this.currentGroup);
    }

    public final void skipToGroupEnd() {
        int newGroup = this.currentGroupEnd;
        this.currentGroup = newGroup;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(newGroup));
    }

    public final void beginInsert() {
        int i = this.insertCount;
        this.insertCount = i + 1;
        if (i == 0) {
            saveCurrentGroupEnd();
        }
    }

    public final void endInsert() {
        int i = this.insertCount;
        boolean value$iv = true;
        if (i > 0) {
            int i2 = i - 1;
            this.insertCount = i2;
            if (i2 == 0) {
                if (this.nodeCountStack.getSize() != this.startStack.getSize()) {
                    value$iv = false;
                }
                if (value$iv) {
                    restoreCurrentGroupEnd();
                } else {
                    ComposerKt.composeRuntimeError("startGroup/endGroup mismatch while inserting".toString());
                    throw new KotlinNothingValueException();
                }
            }
        } else {
            throw new IllegalStateException("Unbalanced begin/end insert".toString());
        }
    }

    public final void startGroup() {
        if (this.insertCount == 0) {
            startGroup(0, Composer.Companion.getEmpty(), false, Composer.Companion.getEmpty());
        } else {
            ComposerKt.composeRuntimeError("Key must be supplied when inserting".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void startGroup(int key) {
        startGroup(key, Composer.Companion.getEmpty(), false, Composer.Companion.getEmpty());
    }

    public final void startGroup(int key, Object dataKey) {
        startGroup(key, dataKey, false, Composer.Companion.getEmpty());
    }

    public final void startNode(int key, Object objectKey) {
        startGroup(key, objectKey, true, Composer.Companion.getEmpty());
    }

    public final void startNode(int key, Object objectKey, Object node) {
        startGroup(key, objectKey, true, node);
    }

    public final void startData(int key, Object objectKey, Object aux) {
        startGroup(key, objectKey, false, aux);
    }

    public final void startData(int key, Object aux) {
        startGroup(key, Composer.Companion.getEmpty(), false, aux);
    }

    private final void startGroup(int key, Object objectKey, boolean isNode, Object aux) {
        int newCurrent;
        Object obj = objectKey;
        Object obj2 = aux;
        int i = 1;
        boolean inserting = this.insertCount > 0;
        this.nodeCountStack.push(this.nodeCount);
        if (inserting) {
            insertGroups(1);
            int current = this.currentGroup;
            int currentAddress = groupIndexToAddress(current);
            boolean hasObjectKey = obj != Composer.Companion.getEmpty();
            boolean hasAux = !isNode && obj2 != Composer.Companion.getEmpty();
            SlotTableKt.initGroup(this.groups, currentAddress, key, isNode, hasObjectKey, hasAux, this.parent, this.currentSlot);
            this.currentSlotEnd = this.currentSlot;
            int i2 = (isNode) + (hasObjectKey);
            if (!hasAux) {
                i = 0;
            }
            int dataSlotsNeeded = i2 + i;
            if (dataSlotsNeeded > 0) {
                insertSlots(dataSlotsNeeded, current);
                Object[] slots2 = this.slots;
                int currentSlot2 = this.currentSlot;
                if (isNode) {
                    slots2[currentSlot2] = obj2;
                    currentSlot2++;
                }
                if (hasObjectKey) {
                    slots2[currentSlot2] = obj;
                    currentSlot2++;
                }
                if (hasAux) {
                    slots2[currentSlot2] = obj2;
                    currentSlot2++;
                }
                this.currentSlot = currentSlot2;
            }
            this.nodeCount = 0;
            newCurrent = current + 1;
            this.parent = current;
            this.currentGroup = newCurrent;
        } else {
            this.startStack.push(this.parent);
            saveCurrentGroupEnd();
            int currentGroup2 = this.currentGroup;
            int currentGroupAddress = groupIndexToAddress(currentGroup2);
            if (!Intrinsics.areEqual(obj2, Composer.Companion.getEmpty())) {
                if (isNode) {
                    updateNode(obj2);
                } else {
                    updateAux(obj2);
                }
            }
            this.currentSlot = slotIndex(this.groups, currentGroupAddress);
            this.currentSlotEnd = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
            this.nodeCount = SlotTableKt.nodeCount(this.groups, currentGroupAddress);
            this.parent = currentGroup2;
            this.currentGroup = currentGroup2 + 1;
            newCurrent = SlotTableKt.groupSize(this.groups, currentGroupAddress) + currentGroup2;
        }
        this.currentGroupEnd = newCurrent;
    }

    public final int endGroup() {
        int currentGroup2;
        int oldGroupSize;
        int i = 1;
        int nodesDelta = 0;
        boolean inserting = this.insertCount > 0;
        int currentGroup3 = this.currentGroup;
        int currentGroupEnd2 = this.currentGroupEnd;
        int groupIndex = this.parent;
        int groupAddress = groupIndexToAddress(groupIndex);
        int newNodes = this.nodeCount;
        int newGroupSize = currentGroup3 - groupIndex;
        boolean isNode = SlotTableKt.isNode(this.groups, groupAddress);
        if (inserting) {
            SlotTableKt.updateGroupSize(this.groups, groupAddress, newGroupSize);
            SlotTableKt.updateNodeCount(this.groups, groupAddress, newNodes);
            int pop = this.nodeCountStack.pop();
            if (!isNode) {
                i = newNodes;
            }
            this.nodeCount = pop + i;
            this.parent = parent(this.groups, groupIndex);
            boolean z = inserting;
            int i2 = currentGroup3;
        } else {
            if (currentGroup3 != currentGroupEnd2) {
                i = 0;
            }
            if (i != 0) {
                int oldGroupSize2 = SlotTableKt.groupSize(this.groups, groupAddress);
                int oldNodes = SlotTableKt.nodeCount(this.groups, groupAddress);
                SlotTableKt.updateGroupSize(this.groups, groupAddress, newGroupSize);
                SlotTableKt.updateNodeCount(this.groups, groupAddress, newNodes);
                int newParent = this.startStack.pop();
                restoreCurrentGroupEnd();
                this.parent = newParent;
                int groupParent = parent(this.groups, groupIndex);
                int pop2 = this.nodeCountStack.pop();
                this.nodeCount = pop2;
                if (groupParent == newParent) {
                    if (!isNode) {
                        nodesDelta = newNodes - oldNodes;
                    }
                    this.nodeCount = pop2 + nodesDelta;
                    boolean z2 = inserting;
                    int i3 = currentGroup3;
                } else {
                    int groupSizeDelta = newGroupSize - oldGroupSize2;
                    if (!isNode) {
                        nodesDelta = newNodes - oldNodes;
                    }
                    if (groupSizeDelta != 0 || nodesDelta != 0) {
                        int current = groupParent;
                        while (true) {
                            if (current != 0) {
                                if (current != newParent) {
                                    if (nodesDelta == 0 && groupSizeDelta == 0) {
                                        boolean z3 = inserting;
                                        int i4 = oldGroupSize2;
                                        int i5 = currentGroup3;
                                        break;
                                    }
                                    boolean inserting2 = inserting;
                                    int currentAddress = groupIndexToAddress(current);
                                    if (groupSizeDelta != 0) {
                                        oldGroupSize = oldGroupSize2;
                                        currentGroup2 = currentGroup3;
                                        SlotTableKt.updateGroupSize(this.groups, currentAddress, SlotTableKt.groupSize(this.groups, currentAddress) + groupSizeDelta);
                                    } else {
                                        oldGroupSize = oldGroupSize2;
                                        currentGroup2 = currentGroup3;
                                    }
                                    if (nodesDelta != 0) {
                                        int[] iArr = this.groups;
                                        SlotTableKt.updateNodeCount(iArr, currentAddress, SlotTableKt.nodeCount(iArr, currentAddress) + nodesDelta);
                                    }
                                    if (SlotTableKt.isNode(this.groups, currentAddress)) {
                                        nodesDelta = 0;
                                    }
                                    current = parent(this.groups, current);
                                    inserting = inserting2;
                                    oldGroupSize2 = oldGroupSize;
                                    currentGroup3 = currentGroup2;
                                } else {
                                    int i6 = oldGroupSize2;
                                    int i7 = currentGroup3;
                                    break;
                                }
                            } else {
                                int i8 = oldGroupSize2;
                                int i9 = currentGroup3;
                                break;
                            }
                        }
                    } else {
                        boolean z4 = inserting;
                        int i10 = oldGroupSize2;
                        int i11 = currentGroup3;
                    }
                    this.nodeCount += nodesDelta;
                }
            } else {
                ComposerKt.composeRuntimeError("Expected to be at the end of a group".toString());
                throw new KotlinNothingValueException();
            }
        }
        return newNodes;
    }

    public final void bashGroup$runtime_release() {
        startGroup();
        while (!isGroupEnd()) {
            insertParentGroup(-3);
            skipGroup();
        }
        endGroup();
    }

    public final void ensureStarted(int index) {
        boolean value$iv = true;
        if (this.insertCount <= 0) {
            int parent2 = this.parent;
            if (parent2 != index) {
                if (index < parent2 || index >= this.currentGroupEnd) {
                    value$iv = false;
                }
                if (value$iv) {
                    int oldCurrent = this.currentGroup;
                    int oldCurrentSlot = this.currentSlot;
                    int oldCurrentSlotEnd = this.currentSlotEnd;
                    this.currentGroup = index;
                    startGroup();
                    this.currentGroup = oldCurrent;
                    this.currentSlot = oldCurrentSlot;
                    this.currentSlotEnd = oldCurrentSlotEnd;
                    return;
                }
                ComposerKt.composeRuntimeError(("Started group at " + index + " must be a subgroup of the group at " + parent2).toString());
                throw new KotlinNothingValueException();
            }
            return;
        }
        ComposerKt.composeRuntimeError("Cannot call ensureStarted() while inserting".toString());
        throw new KotlinNothingValueException();
    }

    public final void ensureStarted(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        ensureStarted(anchor.toIndexFor(this));
    }

    public final int skipGroup() {
        int groupAddress = groupIndexToAddress(this.currentGroup);
        int newGroup = this.currentGroup + SlotTableKt.groupSize(this.groups, groupAddress);
        this.currentGroup = newGroup;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(newGroup));
        if (SlotTableKt.isNode(this.groups, groupAddress)) {
            return 1;
        }
        return SlotTableKt.nodeCount(this.groups, groupAddress);
    }

    public final boolean removeGroup() {
        if (this.insertCount == 0) {
            int oldGroup = this.currentGroup;
            int oldSlot = this.currentSlot;
            int count = skipGroup();
            PrioritySet it = this.pendingRecalculateMarks;
            if (it != null) {
                while (it.isNotEmpty() && it.peek() >= oldGroup) {
                    it.takeMax();
                }
            }
            boolean anchorsRemoved = removeGroups(oldGroup, this.currentGroup - oldGroup);
            removeSlots(oldSlot, this.currentSlot - oldSlot, oldGroup - 1);
            this.currentGroup = oldGroup;
            this.currentSlot = oldSlot;
            this.nodeCount -= count;
            return anchorsRemoved;
        }
        ComposerKt.composeRuntimeError("Cannot remove group while inserting".toString());
        throw new KotlinNothingValueException();
    }

    public final Iterator<Object> groupSlots() {
        int start = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int[] iArr = this.groups;
        int i = this.currentGroup;
        return new SlotWriter$groupSlots$1(start, dataIndex(iArr, groupIndexToAddress(i + groupSize(i))), this);
    }

    /*  JADX ERROR: NullPointerException in pass: CodeShrinkVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.inline(CodeShrinkVisitor.java:146)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:71)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final void moveGroup(int r28) {
        /*
            r27 = this;
            r0 = r27
            int r1 = r0.insertCount
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x000a
            r1 = r3
            goto L_0x000b
        L_0x000a:
            r1 = r2
        L_0x000b:
            r4 = 0
            if (r1 == 0) goto L_0x0143
            if (r28 < 0) goto L_0x0013
            r1 = r3
            goto L_0x0014
        L_0x0013:
            r1 = r2
        L_0x0014:
            r4 = 0
            java.lang.String r5 = "Parameter offset is out of bounds"
            if (r1 == 0) goto L_0x0133
            if (r28 != 0) goto L_0x001d
            return
        L_0x001d:
            int r1 = r0.currentGroup
            int r4 = r0.parent
            int r6 = r0.currentGroupEnd
            r7 = r28
            r8 = r1
        L_0x0026:
            if (r7 <= 0) goto L_0x004f
            int[] r9 = r0.groups
            int r10 = r0.groupIndexToAddress(r8)
            int r9 = androidx.compose.runtime.SlotTableKt.groupSize(r9, r10)
            int r8 = r8 + r9
            if (r8 > r6) goto L_0x0037
            r9 = r3
            goto L_0x0038
        L_0x0037:
            r9 = r2
        L_0x0038:
            r10 = 0
            if (r9 == 0) goto L_0x003f
            int r7 = r7 + -1
            goto L_0x0026
        L_0x003f:
            r2 = 0
            r2 = r5
            java.lang.String r3 = r2.toString()
            androidx.compose.runtime.ComposerKt.composeRuntimeError(r3)
            kotlin.KotlinNothingValueException r3 = new kotlin.KotlinNothingValueException
            r3.<init>()
            throw r3
        L_0x004f:
            int[] r5 = r0.groups
            int r9 = r0.groupIndexToAddress(r8)
            int r5 = androidx.compose.runtime.SlotTableKt.groupSize(r5, r9)
            int r9 = r0.currentSlot
            int[] r10 = r0.groups
            int r11 = r0.groupIndexToAddress(r8)
            int r10 = r0.dataIndex(r10, r11)
            int[] r11 = r0.groups
            int r12 = r8 + r5
            int r12 = r0.groupIndexToAddress(r12)
            int r11 = r0.dataIndex(r11, r12)
            int r12 = r11 - r10
            int r13 = r0.currentGroup
            int r13 = r13 - r3
            int r13 = java.lang.Math.max(r13, r2)
            r0.insertSlots(r12, r13)
            r0.insertGroups(r5)
            int[] r13 = r0.groups
            int r14 = r8 + r5
            int r14 = r0.groupIndexToAddress(r14)
            int r15 = r14 * 5
            int r16 = r0.groupIndexToAddress(r1)
            int r2 = r16 * 5
            int r18 = r5 * 5
            int r3 = r15 + r18
            kotlin.collections.ArraysKt.copyInto((int[]) r13, (int[]) r13, (int) r2, (int) r15, (int) r3)
            if (r12 <= 0) goto L_0x00b4
            java.lang.Object[] r2 = r0.slots
            int r3 = r10 + r12
            int r3 = r0.dataIndexToDataAddress(r3)
            r18 = r6
            int r6 = r11 + r12
            int r6 = r0.dataIndexToDataAddress(r6)
            kotlin.collections.ArraysKt.copyInto((T[]) r2, (T[]) r2, (int) r9, (int) r3, (int) r6)
            goto L_0x00b6
        L_0x00b4:
            r18 = r6
        L_0x00b6:
            int r2 = r10 + r12
            int r2 = r2 - r9
            int r3 = r0.slotsGapStart
            int r6 = r0.slotsGapLen
            r19 = r3
            java.lang.Object[] r3 = r0.slots
            int r3 = r3.length
            r20 = r7
            int r7 = r0.slotsGapOwner
            r21 = r1
            r22 = r9
            int r9 = r1 + r5
            r23 = r11
            r11 = r21
        L_0x00d0:
            if (r11 >= r9) goto L_0x00fc
            r21 = r9
            int r9 = r0.groupIndexToAddress(r11)
            int r24 = r0.dataIndex(r13, r9)
            r25 = r14
            int r14 = r24 - r2
            r26 = r2
            if (r7 >= r9) goto L_0x00e8
            r2 = 0
            goto L_0x00ea
        L_0x00e8:
            r2 = r19
        L_0x00ea:
            int r2 = r0.dataIndexToDataAnchor(r14, r2, r6, r3)
            r0.updateDataIndex(r13, r9, r2)
            int r11 = r11 + 1
            r9 = r21
            r14 = r25
            r2 = r26
            goto L_0x00d0
        L_0x00fc:
            r26 = r2
            r25 = r14
            int r2 = r8 + r5
            r0.moveAnchors(r2, r1, r5)
            int r2 = r8 + r5
            boolean r2 = r0.removeGroups(r2, r5)
            r9 = r2 ^ 1
            r11 = 0
            if (r9 == 0) goto L_0x0122
            int r9 = r0.currentGroupEnd
            r0.fixParentAnchorsFor(r4, r9, r1)
            if (r12 <= 0) goto L_0x0121
            int r9 = r10 + r12
            int r11 = r8 + r5
            r14 = 1
            int r11 = r11 - r14
            r0.removeSlots(r9, r12, r11)
        L_0x0121:
            return
        L_0x0122:
            r14 = 0
            java.lang.String r14 = "Unexpectedly removed anchors"
            java.lang.String r17 = r14.toString()
            androidx.compose.runtime.ComposerKt.composeRuntimeError(r17)
            kotlin.KotlinNothingValueException r17 = new kotlin.KotlinNothingValueException
            r17.<init>()
            throw r17
        L_0x0133:
            r2 = 0
            r2 = r5
            java.lang.String r3 = r2.toString()
            androidx.compose.runtime.ComposerKt.composeRuntimeError(r3)
            kotlin.KotlinNothingValueException r3 = new kotlin.KotlinNothingValueException
            r3.<init>()
            throw r3
        L_0x0143:
            r2 = 0
            java.lang.String r2 = "Cannot move a group while inserting"
            java.lang.String r3 = r2.toString()
            androidx.compose.runtime.ComposerKt.composeRuntimeError(r3)
            kotlin.KotlinNothingValueException r3 = new kotlin.KotlinNothingValueException
            r3.<init>()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SlotWriter.moveGroup(int):void");
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002¨\u0006\u000e"}, d2 = {"Landroidx/compose/runtime/SlotWriter$Companion;", "", "()V", "moveGroup", "", "Landroidx/compose/runtime/Anchor;", "fromWriter", "Landroidx/compose/runtime/SlotWriter;", "fromIndex", "", "toWriter", "updateFromCursor", "", "updateToCursor", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SlotTable.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final List<Anchor> moveGroup(SlotWriter fromWriter, int fromIndex, SlotWriter toWriter, boolean updateFromCursor, boolean updateToCursor) {
            int dataIndexDelta;
            List anchors;
            boolean anchorsRemoved;
            int moveEnd;
            SlotWriter slotWriter = fromWriter;
            int i = fromIndex;
            SlotWriter slotWriter2 = toWriter;
            int groupsToMove = fromWriter.groupSize(fromIndex);
            int sourceGroupsEnd = i + groupsToMove;
            int sourceSlotsStart = fromWriter.dataIndex(fromIndex);
            int sourceSlotsEnd = slotWriter.dataIndex(sourceGroupsEnd);
            int slotsToMove = sourceSlotsEnd - sourceSlotsStart;
            boolean hasMarks = fromWriter.containsAnyGroupMarks(fromIndex);
            slotWriter2.insertGroups(groupsToMove);
            slotWriter2.insertSlots(slotsToMove, toWriter.getCurrentGroup());
            if (fromWriter.groupGapStart < sourceGroupsEnd) {
                slotWriter.moveGroupGapTo(sourceGroupsEnd);
            }
            if (fromWriter.slotsGapStart < sourceSlotsEnd) {
                slotWriter.moveSlotGapTo(sourceSlotsEnd, sourceGroupsEnd);
            }
            int[] groups = toWriter.groups;
            int currentGroup = toWriter.getCurrentGroup();
            ArraysKt.copyInto(fromWriter.groups, groups, currentGroup * 5, i * 5, sourceGroupsEnd * 5);
            Object[] slots = toWriter.slots;
            int currentSlot = toWriter.currentSlot;
            ArraysKt.copyInto((T[]) fromWriter.slots, (T[]) slots, currentSlot, sourceSlotsStart, sourceSlotsEnd);
            int parent = toWriter.getParent();
            SlotTableKt.updateParentAnchor(groups, currentGroup, parent);
            int parentDelta = currentGroup - i;
            int moveEnd2 = currentGroup + groupsToMove;
            int i2 = sourceSlotsEnd;
            int dataIndexDelta2 = currentSlot - toWriter.dataIndex(groups, currentGroup);
            int slotsGapOwner = toWriter.slotsGapOwner;
            int parent2 = parent;
            int slotsGapLen = toWriter.slotsGapLen;
            boolean hasMarks2 = hasMarks;
            int slotsCapacity = slots.length;
            Object[] objArr = slots;
            int slotsGapOwner2 = slotsGapOwner;
            int slotsGapOwner3 = currentSlot;
            int groupAddress = currentGroup;
            while (true) {
                dataIndexDelta = 0;
                if (groupAddress >= moveEnd2) {
                    break;
                }
                if (groupAddress != currentGroup) {
                    moveEnd = moveEnd2;
                    SlotTableKt.updateParentAnchor(groups, groupAddress, SlotTableKt.parentAnchor(groups, groupAddress) + parentDelta);
                } else {
                    moveEnd = moveEnd2;
                }
                int newDataIndex = toWriter.dataIndex(groups, groupAddress) + dataIndexDelta2;
                SlotWriter $this$moveGroup_u24lambda_u242 = toWriter;
                if (slotsGapOwner2 >= groupAddress) {
                    dataIndexDelta = $this$moveGroup_u24lambda_u242.slotsGapStart;
                }
                int dataIndexDelta3 = dataIndexDelta2;
                int parentDelta2 = parentDelta;
                SlotTableKt.updateDataAnchor(groups, groupAddress, $this$moveGroup_u24lambda_u242.dataIndexToDataAnchor(newDataIndex, dataIndexDelta, slotsGapLen, slotsCapacity));
                if (groupAddress == slotsGapOwner2) {
                    slotsGapOwner2++;
                }
                groupAddress++;
                moveEnd2 = moveEnd;
                dataIndexDelta2 = dataIndexDelta3;
                parentDelta = parentDelta2;
            }
            int i3 = parentDelta;
            int i4 = moveEnd2;
            slotWriter2.slotsGapOwner = slotsGapOwner2;
            int startAnchors = SlotTableKt.locationOf(fromWriter.anchors, i, fromWriter.getSize$runtime_release());
            int endAnchors = SlotTableKt.locationOf(fromWriter.anchors, sourceGroupsEnd, fromWriter.getSize$runtime_release());
            if (startAnchors < endAnchors) {
                ArrayList sourceAnchors = fromWriter.anchors;
                int i5 = sourceGroupsEnd;
                ArrayList anchors2 = new ArrayList(endAnchors - startAnchors);
                int anchorDelta = currentGroup - i;
                int i6 = slotsCapacity;
                int anchorIndex = startAnchors;
                while (anchorIndex < endAnchors) {
                    int slotsGapOwner4 = slotsGapOwner2;
                    Object obj = sourceAnchors.get(anchorIndex);
                    Intrinsics.checkNotNullExpressionValue(obj, "sourceAnchors[anchorIndex]");
                    Anchor sourceAnchor = (Anchor) obj;
                    sourceAnchor.setLocation$runtime_release(sourceAnchor.getLocation$runtime_release() + anchorDelta);
                    anchors2.add(sourceAnchor);
                    anchorIndex++;
                    slotsGapOwner2 = slotsGapOwner4;
                    slotsGapLen = slotsGapLen;
                }
                int i7 = slotsGapLen;
                toWriter.anchors.addAll(SlotTableKt.locationOf(toWriter.anchors, toWriter.getCurrentGroup(), toWriter.getSize$runtime_release()), anchors2);
                sourceAnchors.subList(startAnchors, endAnchors).clear();
                anchors = anchors2;
            } else {
                int i8 = slotsCapacity;
                int i9 = slotsGapOwner2;
                int i10 = slotsGapLen;
                anchors = CollectionsKt.emptyList();
            }
            int parentGroup = fromWriter.parent(fromIndex);
            int i11 = 1;
            if (updateFromCursor) {
                boolean needsStartGroups = parentGroup >= 0;
                if (needsStartGroups) {
                    fromWriter.startGroup();
                    slotWriter.advanceBy(parentGroup - fromWriter.getCurrentGroup());
                    fromWriter.startGroup();
                }
                slotWriter.advanceBy(i - fromWriter.getCurrentGroup());
                anchorsRemoved = fromWriter.removeGroup();
                if (needsStartGroups) {
                    fromWriter.skipToGroupEnd();
                    fromWriter.endGroup();
                    fromWriter.skipToGroupEnd();
                    fromWriter.endGroup();
                }
            } else {
                anchorsRemoved = slotWriter.removeGroups(i, groupsToMove);
                slotWriter.removeSlots(sourceSlotsStart, slotsToMove, i - 1);
            }
            if (!anchorsRemoved) {
                dataIndexDelta = 1;
            }
            if (dataIndexDelta != 0) {
                int access$getNodeCount$p = toWriter.nodeCount;
                if (!SlotTableKt.isNode(groups, currentGroup)) {
                    i11 = SlotTableKt.nodeCount(groups, currentGroup);
                }
                slotWriter2.nodeCount = access$getNodeCount$p + i11;
                if (updateToCursor) {
                    slotWriter2.currentGroup = currentGroup + groupsToMove;
                    slotWriter2.currentSlot = slotsGapOwner3 + slotsToMove;
                }
                if (hasMarks2) {
                    slotWriter2.updateContainsMark(parent2);
                }
                return anchors;
            }
            ComposerKt.composeRuntimeError("Unexpectedly removed anchors".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final List<Anchor> moveTo(Anchor anchor, int offset, SlotWriter writer) {
        SlotWriter slotWriter = writer;
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(slotWriter, "writer");
        boolean z = true;
        ComposerKt.runtimeCheck(slotWriter.insertCount > 0);
        ComposerKt.runtimeCheck(this.insertCount == 0);
        ComposerKt.runtimeCheck(anchor.getValid());
        int location = anchorIndex(anchor) + offset;
        int currentGroup2 = this.currentGroup;
        ComposerKt.runtimeCheck(currentGroup2 <= location && location < this.currentGroupEnd);
        int parent2 = parent(location);
        int size = groupSize(location);
        int nodes = isNode(location) ? 1 : nodeCount(location);
        List result = Companion.moveGroup(this, location, writer, false, false);
        updateContainsMark(parent2);
        boolean updatingNodes = nodes > 0;
        for (int current = parent2; current >= currentGroup2; current = parent(current)) {
            int currentAddress = groupIndexToAddress(current);
            int[] iArr = this.groups;
            SlotTableKt.updateGroupSize(iArr, currentAddress, SlotTableKt.groupSize(iArr, currentAddress) - size);
            if (updatingNodes) {
                if (SlotTableKt.isNode(this.groups, currentAddress)) {
                    updatingNodes = false;
                } else {
                    int[] iArr2 = this.groups;
                    SlotTableKt.updateNodeCount(iArr2, currentAddress, SlotTableKt.nodeCount(iArr2, currentAddress) - nodes);
                }
            }
        }
        if (updatingNodes) {
            if (this.nodeCount < nodes) {
                z = false;
            }
            ComposerKt.runtimeCheck(z);
            this.nodeCount -= nodes;
        }
        return result;
    }

    public final List<Anchor> moveFrom(SlotTable table2, int index) {
        Intrinsics.checkNotNullParameter(table2, "table");
        ComposerKt.runtimeCheck(this.insertCount > 0);
        if (index == 0 && this.currentGroup == 0 && this.table.getGroupsSize() == 0) {
            int[] myGroups = this.groups;
            Object[] mySlots = this.slots;
            ArrayList<Anchor> arrayList = this.anchors;
            int[] groups2 = table2.getGroups();
            int groupsSize = table2.getGroupsSize();
            Object[] slots2 = table2.getSlots();
            int slotsSize = table2.getSlotsSize();
            this.groups = groups2;
            this.slots = slots2;
            this.anchors = table2.getAnchors$runtime_release();
            this.groupGapStart = groupsSize;
            this.groupGapLen = (groups2.length / 5) - groupsSize;
            this.slotsGapStart = slotsSize;
            this.slotsGapLen = slots2.length - slotsSize;
            this.slotsGapOwner = groupsSize;
            table2.setTo$runtime_release(myGroups, 0, mySlots, 0, arrayList);
            return this.anchors;
        }
        SlotWriter writer$iv = table2.openWriter();
        try {
            return Companion.moveGroup(writer$iv, index, this, true, true);
        } finally {
            writer$iv.close();
        }
    }

    public final void insertParentGroup(int key) {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeRuntimeError("Writer cannot be inserting".toString());
            throw new KotlinNothingValueException();
        } else if (isGroupEnd()) {
            beginInsert();
            startGroup(key);
            endGroup();
            endInsert();
        } else {
            int currentGroup2 = this.currentGroup;
            int parent2 = parent(this.groups, currentGroup2);
            int currentGroupEnd2 = parent2 + groupSize(parent2);
            int remainingSize = currentGroupEnd2 - currentGroup2;
            int nodeCount2 = 0;
            int currentNewChild = currentGroup2;
            while (currentNewChild < currentGroupEnd2) {
                int newChildAddress = groupIndexToAddress(currentNewChild);
                nodeCount2 += SlotTableKt.nodeCount(this.groups, newChildAddress);
                currentNewChild += SlotTableKt.groupSize(this.groups, newChildAddress);
            }
            int currentSlot2 = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress(currentGroup2));
            beginInsert();
            insertGroups(1);
            endInsert();
            int currentAddress = groupIndexToAddress(currentGroup2);
            int currentAddress2 = currentAddress;
            SlotTableKt.initGroup(this.groups, currentAddress, key, false, false, false, parent2, currentSlot2);
            SlotTableKt.updateGroupSize(this.groups, currentAddress2, remainingSize + 1);
            SlotTableKt.updateNodeCount(this.groups, currentAddress2, nodeCount2);
            addToGroupSizeAlongSpine(groupIndexToAddress(parent2), 1);
            fixParentAnchorsFor(parent2, currentGroupEnd2, currentGroup2);
            this.currentGroup = currentGroupEnd2;
        }
    }

    public final void addToGroupSizeAlongSpine(int address, int amount) {
        int current = address;
        while (current > 0) {
            int[] iArr = this.groups;
            SlotTableKt.updateGroupSize(iArr, current, SlotTableKt.groupSize(iArr, current) + amount);
            current = groupIndexToAddress(parentAnchorToIndex(SlotTableKt.parentAnchor(this.groups, current)));
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0017, code lost:
        if (groupSize(r7.currentGroup + r17) == 1) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<androidx.compose.runtime.Anchor> moveIntoGroupFrom(int r17, androidx.compose.runtime.SlotTable r18, int r19) {
        /*
            r16 = this;
            r7 = r16
            java.lang.String r0 = "table"
            r8 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            int r0 = r7.insertCount
            if (r0 > 0) goto L_0x001a
            int r0 = r7.currentGroup
            int r0 = r0 + r17
            int r0 = r7.groupSize(r0)
            r1 = 1
            if (r0 != r1) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            androidx.compose.runtime.ComposerKt.runtimeCheck(r1)
            int r9 = r7.currentGroup
            int r10 = r7.currentSlot
            int r11 = r7.currentSlotEnd
            r16.advanceBy(r17)
            r16.startGroup()
            r16.beginInsert()
            r12 = r18
            r13 = 0
            androidx.compose.runtime.SlotWriter r0 = r12.openWriter()
            r14 = r0
            r15 = 0
            r2 = r14
            r0 = 0
            androidx.compose.runtime.SlotWriter$Companion r1 = Companion     // Catch:{ all -> 0x005e }
            r5 = 0
            r6 = 1
            r3 = r19
            r4 = r16
            java.util.List r1 = r1.moveGroup(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x005e }
            r14.close()
            r0 = r1
            r16.endInsert()
            r16.endGroup()
            r7.currentGroup = r9
            r7.currentSlot = r10
            r7.currentSlotEnd = r11
            return r0
        L_0x005e:
            r0 = move-exception
            r14.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SlotWriter.moveIntoGroupFrom(int, androidx.compose.runtime.SlotTable, int):java.util.List");
    }

    public static /* synthetic */ Anchor anchor$default(SlotWriter slotWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = slotWriter.currentGroup;
        }
        return slotWriter.anchor(i);
    }

    public final Anchor anchor(int index) {
        ArrayList $this$getOrAdd$iv = this.anchors;
        int location$iv = SlotTableKt.search($this$getOrAdd$iv, index, getSize$runtime_release());
        if (location$iv < 0) {
            Anchor anchor$iv = new Anchor(index <= this.groupGapStart ? index : -(getSize$runtime_release() - index));
            $this$getOrAdd$iv.add(-(location$iv + 1), anchor$iv);
            return anchor$iv;
        }
        Anchor anchor = $this$getOrAdd$iv.get(location$iv);
        Intrinsics.checkNotNullExpressionValue(anchor, "get(location)");
        return anchor;
    }

    public static /* synthetic */ void markGroup$default(SlotWriter slotWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = slotWriter.parent;
        }
        slotWriter.markGroup(i);
    }

    public final void markGroup(int group) {
        int groupAddress = groupIndexToAddress(group);
        if (!SlotTableKt.hasMark(this.groups, groupAddress)) {
            SlotTableKt.updateMark(this.groups, groupAddress, true);
            if (!SlotTableKt.containsMark(this.groups, groupAddress)) {
                updateContainsMark(parent(group));
            }
        }
    }

    private final boolean containsGroupMark(int group) {
        return group >= 0 && SlotTableKt.containsMark(this.groups, groupIndexToAddress(group));
    }

    /* access modifiers changed from: private */
    public final boolean containsAnyGroupMarks(int group) {
        return group >= 0 && SlotTableKt.containsAnyMark(this.groups, groupIndexToAddress(group));
    }

    private final void recalculateMarks() {
        PrioritySet set = this.pendingRecalculateMarks;
        if (set != null) {
            while (set.isNotEmpty()) {
                updateContainsMarkNow(set.takeMax(), set);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateContainsMark(int group) {
        if (group >= 0) {
            PrioritySet it = this.pendingRecalculateMarks;
            if (it == null) {
                it = new PrioritySet((List) null, 1, (DefaultConstructorMarker) null);
                this.pendingRecalculateMarks = it;
            }
            it.add(group);
        }
    }

    private final void updateContainsMarkNow(int group, PrioritySet set) {
        int groupAddress = groupIndexToAddress(group);
        boolean containsAnyMarks = childContainsAnyMarks(group);
        if (SlotTableKt.containsMark(this.groups, groupAddress) != containsAnyMarks) {
            SlotTableKt.updateContainsMark(this.groups, groupAddress, containsAnyMarks);
            int parent2 = parent(group);
            if (parent2 >= 0) {
                set.add(parent2);
            }
        }
    }

    private final boolean childContainsAnyMarks(int group) {
        int child = group + 1;
        int end = groupSize(group) + group;
        while (child < end) {
            if (SlotTableKt.containsAnyMark(this.groups, groupIndexToAddress(child))) {
                return true;
            }
            child += groupSize(child);
        }
        return false;
    }

    public final int anchorIndex(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        int it = anchor.getLocation$runtime_release();
        return it < 0 ? getSize$runtime_release() + it : it;
    }

    public String toString() {
        return "SlotWriter(current = " + this.currentGroup + " end=" + this.currentGroupEnd + " size = " + getSize$runtime_release() + " gap=" + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + ')';
    }

    private final void saveCurrentGroupEnd() {
        this.endStack.push((getCapacity() - this.groupGapLen) - this.currentGroupEnd);
    }

    private final int restoreCurrentGroupEnd() {
        int newGroupEnd = (getCapacity() - this.groupGapLen) - this.endStack.pop();
        this.currentGroupEnd = newGroupEnd;
        return newGroupEnd;
    }

    private final void fixParentAnchorsFor(int parent2, int endGroup, int firstChild) {
        int parentAnchor = parentIndexToAnchor(parent2, this.groupGapStart);
        int child = firstChild;
        while (child < endGroup) {
            SlotTableKt.updateParentAnchor(this.groups, groupIndexToAddress(child), parentAnchor);
            int childEnd = SlotTableKt.groupSize(this.groups, groupIndexToAddress(child)) + child;
            fixParentAnchorsFor(child, childEnd, child + 1);
            child = childEnd;
        }
    }

    /* access modifiers changed from: private */
    public final void moveGroupGapTo(int index) {
        int gapLen = this.groupGapLen;
        int gapStart = this.groupGapStart;
        if (gapStart != index) {
            boolean z = true;
            if (!this.anchors.isEmpty()) {
                updateAnchors(gapStart, index);
            }
            if (gapLen > 0) {
                int[] groups2 = this.groups;
                int groupPhysicalAddress = index * 5;
                int groupPhysicalGapLen = gapLen * 5;
                int groupPhysicalGapStart = gapStart * 5;
                if (index < gapStart) {
                    ArraysKt.copyInto(groups2, groups2, groupPhysicalAddress + groupPhysicalGapLen, groupPhysicalAddress, groupPhysicalGapStart);
                } else {
                    ArraysKt.copyInto(groups2, groups2, groupPhysicalGapStart, groupPhysicalGapStart + groupPhysicalGapLen, groupPhysicalAddress + groupPhysicalGapLen);
                }
            }
            int groupAddress = index < gapStart ? index + gapLen : gapStart;
            int capacity = getCapacity();
            if (groupAddress >= capacity) {
                z = false;
            }
            ComposerKt.runtimeCheck(z);
            while (groupAddress < capacity) {
                int oldAnchor = SlotTableKt.parentAnchor(this.groups, groupAddress);
                int newAnchor = parentIndexToAnchor(parentAnchorToIndex(oldAnchor), index);
                if (newAnchor != oldAnchor) {
                    SlotTableKt.updateParentAnchor(this.groups, groupAddress, newAnchor);
                }
                int groupAddress2 = groupAddress + 1;
                if (groupAddress2 == index) {
                    groupAddress2 += gapLen;
                }
            }
        }
        this.groupGapStart = index;
    }

    /* access modifiers changed from: private */
    public final void moveSlotGapTo(int index, int group) {
        int gapLen = this.slotsGapLen;
        int gapStart = this.slotsGapStart;
        int slotsGapOwner2 = this.slotsGapOwner;
        if (gapStart != index) {
            Object[] slots2 = this.slots;
            if (index < gapStart) {
                ArraysKt.copyInto((T[]) slots2, (T[]) slots2, index + gapLen, index, gapStart);
            } else {
                ArraysKt.copyInto((T[]) slots2, (T[]) slots2, gapStart, gapStart + gapLen, index + gapLen);
            }
            ArraysKt.fill((T[]) slots2, null, index, index + gapLen);
        }
        int newSlotsGapOwner = Math.min(group + 1, getSize$runtime_release());
        if (slotsGapOwner2 != newSlotsGapOwner) {
            int slotsSize = this.slots.length - gapLen;
            if (newSlotsGapOwner < slotsGapOwner2) {
                int updateAddress = groupIndexToAddress(newSlotsGapOwner);
                int stopUpdateAddress = groupIndexToAddress(slotsGapOwner2);
                int groupGapStart2 = this.groupGapStart;
                while (updateAddress < stopUpdateAddress) {
                    int anchor = SlotTableKt.dataAnchor(this.groups, updateAddress);
                    if (anchor >= 0) {
                        SlotTableKt.updateDataAnchor(this.groups, updateAddress, -((slotsSize - anchor) + 1));
                        updateAddress++;
                        if (updateAddress == groupGapStart2) {
                            updateAddress += this.groupGapLen;
                        }
                    } else {
                        ComposerKt.composeRuntimeError("Unexpected anchor value, expected a positive anchor".toString());
                        throw new KotlinNothingValueException();
                    }
                }
            } else {
                int updateAddress2 = groupIndexToAddress(slotsGapOwner2);
                int stopUpdateAddress2 = groupIndexToAddress(newSlotsGapOwner);
                while (updateAddress2 < stopUpdateAddress2) {
                    int anchor2 = SlotTableKt.dataAnchor(this.groups, updateAddress2);
                    if (anchor2 < 0) {
                        SlotTableKt.updateDataAnchor(this.groups, updateAddress2, slotsSize + anchor2 + 1);
                        updateAddress2++;
                        if (updateAddress2 == this.groupGapStart) {
                            updateAddress2 += this.groupGapLen;
                        }
                    } else {
                        ComposerKt.composeRuntimeError("Unexpected anchor value, expected a negative anchor".toString());
                        throw new KotlinNothingValueException();
                    }
                }
            }
            this.slotsGapOwner = newSlotsGapOwner;
        }
        this.slotsGapStart = index;
    }

    /* access modifiers changed from: private */
    public final void insertGroups(int size) {
        int i = size;
        if (i > 0) {
            int currentGroup2 = this.currentGroup;
            moveGroupGapTo(currentGroup2);
            int gapStart = this.groupGapStart;
            int gapLen = this.groupGapLen;
            int oldCapacity = this.groups.length / 5;
            int oldSize = oldCapacity - gapLen;
            if (gapLen < i) {
                int[] groups2 = this.groups;
                int newCapacity = Math.max(Math.max(oldCapacity * 2, oldSize + i), 32);
                int[] newGroups = new int[(newCapacity * 5)];
                int newGapLen = newCapacity - oldSize;
                ArraysKt.copyInto(groups2, newGroups, 0, 0, gapStart * 5);
                ArraysKt.copyInto(groups2, newGroups, (gapStart + newGapLen) * 5, (gapStart + gapLen) * 5, oldCapacity * 5);
                this.groups = newGroups;
                gapLen = newGapLen;
            }
            int currentEnd = this.currentGroupEnd;
            if (currentEnd >= gapStart) {
                this.currentGroupEnd = currentEnd + i;
            }
            this.groupGapStart = gapStart + i;
            this.groupGapLen = gapLen - i;
            int anchor = dataIndexToDataAnchor(oldSize > 0 ? dataIndex(currentGroup2 + i) : 0, this.slotsGapOwner < gapStart ? 0 : this.slotsGapStart, this.slotsGapLen, this.slots.length);
            int i2 = gapStart + i;
            for (int groupAddress = gapStart; groupAddress < i2; groupAddress++) {
                SlotTableKt.updateDataAnchor(this.groups, groupAddress, anchor);
            }
            int slotsGapOwner2 = this.slotsGapOwner;
            if (slotsGapOwner2 >= gapStart) {
                this.slotsGapOwner = slotsGapOwner2 + i;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void insertSlots(int size, int group) {
        if (size > 0) {
            moveSlotGapTo(this.currentSlot, group);
            int gapStart = this.slotsGapStart;
            int gapLen = this.slotsGapLen;
            if (gapLen < size) {
                Object[] slots2 = this.slots;
                int oldCapacity = slots2.length;
                int oldSize = oldCapacity - gapLen;
                int newCapacity = Math.max(Math.max(oldCapacity * 2, oldSize + size), 32);
                Object[] newData = new Object[newCapacity];
                for (int i = 0; i < newCapacity; i++) {
                    newData[i] = null;
                }
                int newGapLen = newCapacity - oldSize;
                ArraysKt.copyInto((T[]) slots2, (T[]) newData, 0, 0, gapStart);
                ArraysKt.copyInto((T[]) slots2, (T[]) newData, gapStart + newGapLen, gapStart + gapLen, oldCapacity);
                this.slots = newData;
                gapLen = newGapLen;
            }
            int currentDataEnd = this.currentSlotEnd;
            if (currentDataEnd >= gapStart) {
                this.currentSlotEnd = currentDataEnd + size;
            }
            this.slotsGapStart = gapStart + size;
            this.slotsGapLen = gapLen - size;
        }
    }

    /* access modifiers changed from: private */
    public final boolean removeGroups(int start, int len) {
        if (len <= 0) {
            return false;
        }
        boolean anchorsRemoved = false;
        ArrayList<Anchor> arrayList = this.anchors;
        moveGroupGapTo(start);
        if (!arrayList.isEmpty()) {
            anchorsRemoved = removeAnchors(start, len);
        }
        this.groupGapStart = start;
        this.groupGapLen += len;
        int slotsGapOwner2 = this.slotsGapOwner;
        if (slotsGapOwner2 > start) {
            this.slotsGapOwner = Math.max(start, slotsGapOwner2 - len);
        }
        int i = this.currentGroupEnd;
        if (i >= this.groupGapStart) {
            this.currentGroupEnd = i - len;
        }
        if (!containsGroupMark(this.parent)) {
            return anchorsRemoved;
        }
        updateContainsMark(this.parent);
        return anchorsRemoved;
    }

    /* access modifiers changed from: private */
    public final void removeSlots(int start, int len, int group) {
        if (len > 0) {
            int gapLen = this.slotsGapLen;
            moveSlotGapTo(start + len, group);
            this.slotsGapStart = start;
            this.slotsGapLen = gapLen + len;
            ArraysKt.fill((T[]) this.slots, null, start, start + len);
            int currentDataEnd = this.currentSlotEnd;
            if (currentDataEnd >= start) {
                this.currentSlotEnd = currentDataEnd - len;
            }
        }
    }

    private final void updateNodeOfGroup(int index, Object value) {
        int address = groupIndexToAddress(index);
        int[] iArr = this.groups;
        if (address < iArr.length && SlotTableKt.isNode(iArr, address)) {
            this.slots[dataIndexToDataAddress(nodeIndex(this.groups, address))] = value;
        } else {
            ComposerKt.composeRuntimeError(("Updating the node of a group at " + index + " that was not created with as a node group").toString());
            throw new KotlinNothingValueException();
        }
    }

    private final void updateAnchors(int previousGapStart, int newGapStart) {
        int size = getCapacity() - this.groupGapLen;
        if (previousGapStart < newGapStart) {
            int index = SlotTableKt.locationOf(this.anchors, previousGapStart, size);
            while (index < this.anchors.size()) {
                Anchor anchor = this.anchors.get(index);
                Intrinsics.checkNotNullExpressionValue(anchor, "anchors[index]");
                Anchor anchor2 = anchor;
                int location = anchor2.getLocation$runtime_release();
                if (location < 0 && size + location < newGapStart) {
                    anchor2.setLocation$runtime_release(size + location);
                    index++;
                } else {
                    return;
                }
            }
            return;
        }
        int index2 = SlotTableKt.locationOf(this.anchors, newGapStart, size);
        while (index2 < this.anchors.size()) {
            Anchor anchor3 = this.anchors.get(index2);
            Intrinsics.checkNotNullExpressionValue(anchor3, "anchors[index]");
            Anchor anchor4 = anchor3;
            int location2 = anchor4.getLocation$runtime_release();
            if (location2 >= 0) {
                anchor4.setLocation$runtime_release(-(size - location2));
                index2++;
            } else {
                return;
            }
        }
    }

    private final boolean removeAnchors(int gapStart, int size) {
        int removeEnd = gapStart + size;
        int it = SlotTableKt.locationOf(this.anchors, gapStart + size, getCapacity() - this.groupGapLen);
        if (it >= this.anchors.size()) {
            it--;
        }
        int removeAnchorEnd = 0;
        int removeAnchorStart = it + 1;
        while (it >= 0) {
            Anchor anchor = this.anchors.get(it);
            Intrinsics.checkNotNullExpressionValue(anchor, "anchors[index]");
            Anchor anchor2 = anchor;
            int location = anchorIndex(anchor2);
            if (location < gapStart) {
                break;
            }
            if (location < removeEnd) {
                anchor2.setLocation$runtime_release(Integer.MIN_VALUE);
                removeAnchorStart = it;
                if (removeAnchorEnd == 0) {
                    removeAnchorEnd = it + 1;
                }
            }
            it--;
        }
        boolean it2 = removeAnchorStart < removeAnchorEnd;
        if (it2) {
            this.anchors.subList(removeAnchorStart, removeAnchorEnd).clear();
        }
        return it2;
    }

    private final void moveAnchors(int originalLocation, int newLocation, int size) {
        int i = originalLocation;
        int end = i + size;
        int groupsSize = getSize$runtime_release();
        int index = SlotTableKt.locationOf(this.anchors, i, groupsSize);
        List removedAnchors = new ArrayList();
        if (index >= 0) {
            while (index < this.anchors.size()) {
                Anchor anchor = this.anchors.get(index);
                Intrinsics.checkNotNullExpressionValue(anchor, "anchors[index]");
                Anchor anchor2 = anchor;
                int location = anchorIndex(anchor2);
                if (location < i || location >= end) {
                    break;
                }
                removedAnchors.add(anchor2);
                this.anchors.remove(index);
            }
        }
        int moveDelta = newLocation - i;
        List $this$fastForEach$iv = removedAnchors;
        int index$iv = 0;
        int size2 = $this$fastForEach$iv.size();
        while (index$iv < size2) {
            Anchor anchor3 = (Anchor) $this$fastForEach$iv.get(index$iv);
            int newAnchorIndex = anchorIndex(anchor3) + moveDelta;
            if (newAnchorIndex >= this.groupGapStart) {
                anchor3.setLocation$runtime_release(-(groupsSize - newAnchorIndex));
            } else {
                anchor3.setLocation$runtime_release(newAnchorIndex);
            }
            this.anchors.add(SlotTableKt.locationOf(this.anchors, newAnchorIndex, groupsSize), anchor3);
            index$iv++;
            int i2 = originalLocation;
            end = end;
        }
    }

    public final String groupsAsString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder $this$groupsAsString_u24lambda_u2435 = sb;
        int size$runtime_release = getSize$runtime_release();
        for (int index = 0; index < size$runtime_release; index++) {
            groupAsString($this$groupsAsString_u24lambda_u2435, index);
            $this$groupsAsString_u24lambda_u2435.append(10);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private final void groupAsString(StringBuilder $this$groupAsString, int index) {
        int address = groupIndexToAddress(index);
        $this$groupAsString.append("Group(");
        if (index < 10) {
            $this$groupAsString.append(' ');
        }
        if (index < 100) {
            $this$groupAsString.append(' ');
        }
        if (index < 1000) {
            $this$groupAsString.append(' ');
        }
        $this$groupAsString.append(index);
        if (address != index) {
            $this$groupAsString.append("(");
            $this$groupAsString.append(address);
            $this$groupAsString.append(")");
        }
        $this$groupAsString.append('#');
        $this$groupAsString.append(SlotTableKt.groupSize(this.groups, address));
        boolean openGroup = groupAsString$isStarted(this, index);
        if (openGroup) {
            $this$groupAsString.append('?');
        }
        $this$groupAsString.append('^');
        $this$groupAsString.append(parentAnchorToIndex(SlotTableKt.parentAnchor(this.groups, address)));
        $this$groupAsString.append(": key=");
        $this$groupAsString.append(SlotTableKt.key(this.groups, address));
        $this$groupAsString.append(", nodes=");
        $this$groupAsString.append(SlotTableKt.nodeCount(this.groups, address));
        if (openGroup) {
            $this$groupAsString.append('?');
        }
        $this$groupAsString.append(", dataAnchor=");
        $this$groupAsString.append(SlotTableKt.dataAnchor(this.groups, address));
        $this$groupAsString.append(", parentAnchor=");
        $this$groupAsString.append(SlotTableKt.parentAnchor(this.groups, address));
        if (SlotTableKt.isNode(this.groups, address)) {
            $this$groupAsString.append(", node=" + this.slots[dataIndexToDataAddress(nodeIndex(this.groups, address))]);
        }
        int startData = slotIndex(this.groups, address);
        int endData = dataIndex(this.groups, address + 1);
        if (endData > startData) {
            $this$groupAsString.append(", [");
            for (int dataIndex = startData; dataIndex < endData; dataIndex++) {
                if (dataIndex != startData) {
                    $this$groupAsString.append(", ");
                }
                $this$groupAsString.append(String.valueOf(this.slots[dataIndexToDataAddress(dataIndex)]));
            }
            $this$groupAsString.append(']');
        }
        $this$groupAsString.append(")");
    }

    private static final boolean groupAsString$isStarted(SlotWriter this$0, int index) {
        return index < this$0.currentGroup && (index == this$0.parent || this$0.startStack.indexOf(index) >= 0 || groupAsString$isStarted(this$0, this$0.parent(index)));
    }

    public final void verifyDataAnchors$runtime_release() {
        int previousDataIndex = 0;
        int owner = this.slotsGapOwner;
        boolean ownerFound = false;
        int slotsSize = this.slots.length - this.slotsGapLen;
        int index = 0;
        int size$runtime_release = getSize$runtime_release();
        while (index < size$runtime_release) {
            int address = groupIndexToAddress(index);
            int dataAnchor = SlotTableKt.dataAnchor(this.groups, address);
            int dataIndex = dataIndex(this.groups, address);
            boolean z = false;
            if (dataIndex >= previousDataIndex) {
                if (dataIndex <= slotsSize) {
                    if (dataAnchor < 0 && !ownerFound) {
                        if (owner == index) {
                            z = true;
                        }
                        if (z) {
                            ownerFound = true;
                        } else {
                            throw new IllegalStateException(("Expected the slot gap owner to be " + owner + " found gap at " + index).toString());
                        }
                    }
                    previousDataIndex = dataIndex;
                    index++;
                } else {
                    throw new IllegalStateException(("Data index, " + dataIndex + ", out of bound at " + index).toString());
                }
            } else {
                throw new IllegalStateException(("Data index out of order at " + index + ", previous = " + previousDataIndex + ", current = " + dataIndex).toString());
            }
        }
    }

    public final void verifyParentAnchors$runtime_release() {
        int gapStart = this.groupGapStart;
        int gapLen = this.groupGapLen;
        int capacity = getCapacity();
        int groupAddress = 0;
        while (true) {
            boolean z = false;
            if (groupAddress < gapStart) {
                if (SlotTableKt.parentAnchor(this.groups, groupAddress) > -2) {
                    z = true;
                }
                if (z) {
                    groupAddress++;
                } else {
                    throw new IllegalStateException(("Expected a start relative anchor at " + groupAddress).toString());
                }
            } else {
                for (int groupAddress2 = gapStart + gapLen; groupAddress2 < capacity; groupAddress2++) {
                    int parentAnchor = SlotTableKt.parentAnchor(this.groups, groupAddress2);
                    if (parentAnchorToIndex(parentAnchor) < gapStart) {
                        if (!(parentAnchor > -2)) {
                            throw new IllegalStateException(("Expected a start relative anchor at " + groupAddress2).toString());
                        }
                    } else {
                        if (!(parentAnchor <= -2)) {
                            throw new IllegalStateException(("Expected an end relative anchor at " + groupAddress2).toString());
                        }
                    }
                }
                return;
            }
        }
    }

    public final int getSize$runtime_release() {
        return getCapacity() - this.groupGapLen;
    }

    private final int getCapacity() {
        return this.groups.length / 5;
    }

    private final int groupIndexToAddress(int index) {
        return index < this.groupGapStart ? index : this.groupGapLen + index;
    }

    /* access modifiers changed from: private */
    public final int dataIndexToDataAddress(int dataIndex) {
        return dataIndex < this.slotsGapStart ? dataIndex : this.slotsGapLen + dataIndex;
    }

    private final int parent(int[] $this$parent, int index) {
        return parentAnchorToIndex(SlotTableKt.parentAnchor($this$parent, groupIndexToAddress(index)));
    }

    /* access modifiers changed from: private */
    public final int dataIndex(int index) {
        return dataIndex(this.groups, groupIndexToAddress(index));
    }

    /* access modifiers changed from: private */
    public final int dataIndex(int[] $this$dataIndex, int address) {
        if (address >= getCapacity()) {
            return this.slots.length - this.slotsGapLen;
        }
        return dataAnchorToDataIndex(SlotTableKt.dataAnchor($this$dataIndex, address), this.slotsGapLen, this.slots.length);
    }

    private final int slotIndex(int[] $this$slotIndex, int address) {
        if (address >= getCapacity()) {
            return this.slots.length - this.slotsGapLen;
        }
        return dataAnchorToDataIndex(SlotTableKt.slotAnchor($this$slotIndex, address), this.slotsGapLen, this.slots.length);
    }

    private final void updateDataIndex(int[] $this$updateDataIndex, int address, int dataIndex) {
        SlotTableKt.updateDataAnchor($this$updateDataIndex, address, dataIndexToDataAnchor(dataIndex, this.slotsGapStart, this.slotsGapLen, this.slots.length));
    }

    private final int nodeIndex(int[] $this$nodeIndex, int address) {
        return dataIndex($this$nodeIndex, address);
    }

    private final int auxIndex(int[] $this$auxIndex, int address) {
        return dataIndex($this$auxIndex, address) + SlotTableKt.countOneBits(SlotTableKt.groupInfo($this$auxIndex, address) >> 29);
    }

    private final List<Integer> dataIndexes(int[] $this$dataIndexes) {
        List it = SlotTableKt.dataAnchors$default(this.groups, 0, 1, (Object) null);
        List $this$fastMap$iv = CollectionsKt.plus(CollectionsKt.slice(it, RangesKt.until(0, this.groupGapStart)), CollectionsKt.slice(it, RangesKt.until(this.groupGapStart + this.groupGapLen, $this$dataIndexes.length / 5)));
        ArrayList target$iv = new ArrayList($this$fastMap$iv.size());
        List $this$fastForEach$iv$iv = $this$fastMap$iv;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size) {
            target$iv.add(Integer.valueOf(dataAnchorToDataIndex(((Number) $this$fastForEach$iv$iv.get(index$iv$iv)).intValue(), this.slotsGapLen, this.slots.length)));
            index$iv$iv++;
            $this$fastMap$iv = $this$fastMap$iv;
        }
        return target$iv;
    }

    private final List<Integer> keys() {
        List $this$fastFilterIndexed$iv = SlotTableKt.keys$default(this.groups, 0, 1, (Object) null);
        List target$iv = new ArrayList($this$fastFilterIndexed$iv.size());
        List $this$fastForEachIndexed$iv$iv = $this$fastFilterIndexed$iv;
        int size = $this$fastForEachIndexed$iv$iv.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            Object e$iv = $this$fastForEachIndexed$iv$iv.get(index$iv$iv);
            ((Number) e$iv).intValue();
            int index = index$iv$iv;
            int i = this.groupGapStart;
            if (index < i || index >= i + this.groupGapLen) {
                target$iv.add(e$iv);
            }
        }
        return target$iv;
    }

    /* access modifiers changed from: private */
    public final int dataIndexToDataAnchor(int index, int gapStart, int gapLen, int capacity) {
        return index > gapStart ? -(((capacity - gapLen) - index) + 1) : index;
    }

    private final int dataAnchorToDataIndex(int anchor, int gapLen, int capacity) {
        return anchor < 0 ? (capacity - gapLen) + anchor + 1 : anchor;
    }

    private final int parentIndexToAnchor(int index, int gapStart) {
        return index < gapStart ? index : -((getSize$runtime_release() - index) + 2);
    }

    private final int parentAnchorToIndex(int index) {
        return index > -2 ? index : (getSize$runtime_release() + index) - -2;
    }
}
