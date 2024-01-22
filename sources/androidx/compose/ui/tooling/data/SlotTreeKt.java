package androidx.compose.ui.tooling.data;

import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0010\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#H\u0002\u001a(\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u000e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0%2\b\u0010)\u001a\u0004\u0018\u00010*H\u0003\u001a\u0014\u0010+\u001a\u0004\u0018\u00010\u00062\b\u0010,\u001a\u0004\u0018\u00010(H\u0003\u001a\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010/\u001a\u00020\u0006H\u0002\u001a\u001e\u00100\u001a\u0004\u0018\u00010*2\u0006\u00101\u001a\u00020\u00062\n\b\u0002\u00102\u001a\u0004\u0018\u00010*H\u0003\u001a\u001a\u00103\u001a\u0004\u0018\u000104*\u0006\u0012\u0002\b\u0003052\u0006\u00106\u001a\u00020\u0006H\u0002\u001a\f\u00107\u001a\u00020\u0019*\u000208H\u0007\u001a\f\u00109\u001a\u00020\u0006*\u00020\u0015H\u0002\u001a\u001e\u0010:\u001a\b\u0012\u0004\u0012\u00020&0%*\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=H\u0007\u001a\u0016\u0010>\u001a\u00020\u0019*\u00020;2\b\u0010?\u001a\u0004\u0018\u00010*H\u0003\u001a\f\u0010@\u001a\u00020\u0014*\u00020\u0015H\u0002\u001a\u0014\u0010A\u001a\u00020\u0014*\u00020\u00152\u0006\u0010B\u001a\u00020\u0006H\u0002\u001a\f\u0010C\u001a\u00020\u0014*\u00020\u0015H\u0002\u001a\f\u0010D\u001a\u00020\u0014*\u00020\u0015H\u0002\u001a\f\u0010E\u001a\u00020\u0014*\u00020\u0015H\u0002\u001aK\u0010F\u001a\u0004\u0018\u0001HG\"\u0004\b\u0000\u0010G*\u0002082&\u0010H\u001a\"\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020J\u0012\n\u0012\b\u0012\u0004\u0012\u0002HG0%\u0012\u0006\u0012\u0004\u0018\u0001HG0I2\b\b\u0002\u0010<\u001a\u00020=H\u0007¢\u0006\u0002\u0010K\u001a\f\u0010L\u001a\u00020\u0001*\u00020\u0015H\u0002\u001a\f\u0010M\u001a\u00020\u0001*\u00020\u0006H\u0002\u001a\u0014\u0010M\u001a\u00020\u0001*\u00020\u00062\u0006\u0010N\u001a\u00020\u0001H\u0002\u001a\u001c\u0010O\u001a\u00020\u0006*\u00020\u00062\u0006\u0010P\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u0006H\u0002\u001a\u0014\u0010R\u001a\u00020\t*\u00020\t2\u0006\u0010S\u001a\u00020\tH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0013\u001a\u00020\u0014*\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0016\"\u0018\u0010\u0017\u001a\u00020\u0014*\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016\" \u0010\u0018\u001a\u0004\u0018\u00010\u0006*\u00020\u00198GX\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0018\u0010\u001e\u001a\u00020\u0006*\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006T"}, d2 = {"BITS_PER_SLOT", "", "SLOT_MASK", "STABLE_BITS", "STATIC_BITS", "changedFieldName", "", "defaultFieldName", "emptyBox", "Landroidx/compose/ui/unit/IntRect;", "getEmptyBox", "()Landroidx/compose/ui/unit/IntRect;", "internalFieldPrefix", "jacocoDataField", "parameterPrefix", "parametersInformationTokenizer", "Lkotlin/text/Regex;", "recomposeScopeNameSuffix", "tokenizer", "isANumber", "", "Lkotlin/text/MatchResult;", "(Lkotlin/text/MatchResult;)Z", "isClassName", "position", "Landroidx/compose/ui/tooling/data/Group;", "getPosition$annotations", "(Landroidx/compose/ui/tooling/data/Group;)V", "getPosition", "(Landroidx/compose/ui/tooling/data/Group;)Ljava/lang/String;", "text", "getText", "(Lkotlin/text/MatchResult;)Ljava/lang/String;", "boundsOfLayoutNode", "node", "Landroidx/compose/ui/layout/LayoutInfo;", "extractParameterInfo", "", "Landroidx/compose/ui/tooling/data/ParameterInformation;", "data", "", "context", "Landroidx/compose/ui/tooling/data/SourceInformationContext;", "keyPosition", "key", "parseParameters", "Landroidx/compose/ui/tooling/data/Parameter;", "parameters", "sourceInformationContextOf", "information", "parent", "accessibleField", "Ljava/lang/reflect/Field;", "Ljava/lang/Class;", "name", "asTree", "Landroidx/compose/runtime/tooling/CompositionData;", "callName", "findParameters", "Landroidx/compose/runtime/tooling/CompositionGroup;", "cache", "Landroidx/compose/ui/tooling/data/ContextCache;", "getGroup", "parentContext", "isCallWithName", "isChar", "c", "isFileName", "isNumber", "isParameterInformation", "mapTree", "T", "factory", "Lkotlin/Function3;", "Landroidx/compose/ui/tooling/data/SourceContext;", "(Landroidx/compose/runtime/tooling/CompositionData;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/tooling/data/ContextCache;)Ljava/lang/Object;", "number", "parseToInt", "radix", "replacePrefix", "prefix", "replacement", "union", "other", "ui-tooling-data_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SlotTree.kt */
public final class SlotTreeKt {
    private static final int BITS_PER_SLOT = 3;
    private static final int SLOT_MASK = 7;
    private static final int STABLE_BITS = 4;
    private static final int STATIC_BITS = 3;
    private static final String changedFieldName = "$$changed";
    private static final String defaultFieldName = "$$default";
    private static final IntRect emptyBox = new IntRect(0, 0, 0, 0);
    private static final String internalFieldPrefix = "$$";
    private static final String jacocoDataField = "$jacoco";
    private static final String parameterPrefix = "$";
    private static final Regex parametersInformationTokenizer = new Regex("(\\d+)|,|[!P()]|:([^,!)]+)");
    private static final String recomposeScopeNameSuffix = ".RecomposeScopeImpl";
    private static final Regex tokenizer = new Regex("(\\d+)|([,])|([*])|([:])|L|(P\\([^)]*\\))|(C(\\(([^)]*)\\))?)|@");

    public static /* synthetic */ void getPosition$annotations(Group group) {
    }

    public static final IntRect getEmptyBox() {
        return emptyBox;
    }

    private static final boolean isNumber(MatchResult $this$isNumber) {
        return $this$isNumber.getGroups().get(1) != null;
    }

    private static final int number(MatchResult $this$number) {
        return parseToInt($this$number.getGroupValues().get(1));
    }

    private static final String getText(MatchResult $this$text) {
        return $this$text.getGroupValues().get(0);
    }

    private static final boolean isChar(MatchResult $this$isChar, String c) {
        return Intrinsics.areEqual((Object) getText($this$isChar), (Object) c);
    }

    private static final boolean isFileName(MatchResult $this$isFileName) {
        return $this$isFileName.getGroups().get(4) != null;
    }

    private static final boolean isParameterInformation(MatchResult $this$isParameterInformation) {
        return $this$isParameterInformation.getGroups().get(5) != null;
    }

    private static final boolean isCallWithName(MatchResult $this$isCallWithName) {
        return $this$isCallWithName.getGroups().get(6) != null;
    }

    private static final String callName(MatchResult $this$callName) {
        return $this$callName.getGroupValues().get(8);
    }

    private static final boolean isANumber(MatchResult $this$isANumber) {
        return $this$isANumber.getGroups().get(1) != null;
    }

    private static final boolean isClassName(MatchResult $this$isClassName) {
        return $this$isClassName.getGroups().get(2) != null;
    }

    private static final int parseToInt(String $this$parseToInt) {
        try {
            return Integer.parseInt($this$parseToInt);
        } catch (NumberFormatException e) {
            throw new ParseError();
        }
    }

    private static final int parseToInt(String $this$parseToInt, int radix) {
        try {
            return Integer.parseInt($this$parseToInt, CharsKt.checkRadix(radix));
        } catch (NumberFormatException e) {
            throw new ParseError();
        }
    }

    private static final List<Parameter> parseParameters(String parameters) {
        String inlineClass;
        Ref.ObjectRef currentResult = new Ref.ObjectRef();
        currentResult.element = Regex.find$default(parametersInformationTokenizer, parameters, 0, 2, (Object) null);
        List expectedSortedIndex = CollectionsKt.mutableListOf(0, 1, 2, 3);
        Ref.IntRef lastAdded = new Ref.IntRef();
        lastAdded.element = expectedSortedIndex.size() - 1;
        List result = new ArrayList();
        try {
            parseParameters$expect(currentResult, "P");
            parseParameters$expect(currentResult, "(");
            while (!parseParameters$isChar(currentResult, ")")) {
                if (parseParameters$isChar(currentResult, "!")) {
                    parseParameters$next(currentResult);
                    int count = parseParameters$expectNumber(currentResult);
                    parseParameters$ensureIndexes(lastAdded, expectedSortedIndex, result.size() + count);
                    for (int i = 0; i < count; i++) {
                        int i2 = i;
                        result.add(new Parameter(((Number) CollectionsKt.first(expectedSortedIndex)).intValue(), (String) null, 2, (DefaultConstructorMarker) null));
                        expectedSortedIndex.remove(0);
                    }
                } else if (parseParameters$isChar(currentResult, ",")) {
                    parseParameters$next(currentResult);
                } else {
                    int index = parseParameters$expectNumber(currentResult);
                    if (parseParameters$isClassName(currentResult)) {
                        inlineClass = parseParameters$expectClassName(currentResult);
                    } else {
                        inlineClass = null;
                    }
                    result.add(new Parameter(index, inlineClass));
                    parseParameters$ensureIndexes(lastAdded, expectedSortedIndex, index);
                    expectedSortedIndex.remove(Integer.valueOf(index));
                }
            }
            parseParameters$expect(currentResult, ")");
            while (expectedSortedIndex.size() > 0) {
                result.add(new Parameter(((Number) CollectionsKt.first(expectedSortedIndex)).intValue(), (String) null, 2, (DefaultConstructorMarker) null));
                expectedSortedIndex.remove(0);
            }
            return result;
        } catch (ParseError e) {
            return CollectionsKt.emptyList();
        } catch (NumberFormatException e2) {
            return CollectionsKt.emptyList();
        }
    }

    private static final MatchResult parseParameters$next(Ref.ObjectRef<MatchResult> currentResult) {
        MatchResult it = (MatchResult) currentResult.element;
        if (it != null) {
            currentResult.element = it.next();
        }
        return currentResult.element;
    }

    private static final int parseParameters$expectNumber(Ref.ObjectRef<MatchResult> currentResult) {
        MatchResult mr = (MatchResult) currentResult.element;
        if (mr == null || !isANumber(mr)) {
            throw new ParseError();
        }
        parseParameters$next(currentResult);
        return parseToInt(getText(mr));
    }

    private static final String parseParameters$expectClassName(Ref.ObjectRef<MatchResult> currentResult) {
        MatchResult mr = (MatchResult) currentResult.element;
        if (mr == null || !isClassName(mr)) {
            throw new ParseError();
        }
        parseParameters$next(currentResult);
        String substring = getText(mr).substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return replacePrefix(substring, "c#", "androidx.compose.");
    }

    private static final void parseParameters$expect(Ref.ObjectRef<MatchResult> currentResult, String value) {
        MatchResult mr = (MatchResult) currentResult.element;
        if (mr == null || !Intrinsics.areEqual((Object) getText(mr), (Object) value)) {
            throw new ParseError();
        }
        parseParameters$next(currentResult);
    }

    private static final boolean parseParameters$isChar(Ref.ObjectRef<MatchResult> currentResult, String value) {
        MatchResult mr = (MatchResult) currentResult.element;
        return mr == null || Intrinsics.areEqual((Object) getText(mr), (Object) value);
    }

    private static final boolean parseParameters$isClassName(Ref.ObjectRef<MatchResult> currentResult) {
        MatchResult mr = (MatchResult) currentResult.element;
        return mr != null && isClassName(mr);
    }

    private static final void parseParameters$ensureIndexes(Ref.IntRef lastAdded, List<Integer> expectedSortedIndex, int index) {
        int missing = index - lastAdded.element;
        if (missing > 0) {
            int amountToAdd = missing < 4 ? 4 : missing;
            for (int it = 0; it < amountToAdd; it++) {
                expectedSortedIndex.add(Integer.valueOf(lastAdded.element + it + 1));
            }
            lastAdded.element += amountToAdd;
        }
    }

    static /* synthetic */ SourceInformationContext sourceInformationContextOf$default(String str, SourceInformationContext sourceInformationContext, int i, Object obj) {
        if ((i & 2) != 0) {
            sourceInformationContext = null;
        }
        return sourceInformationContextOf(str, sourceInformationContext);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0127  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final androidx.compose.ui.tooling.data.SourceInformationContext sourceInformationContextOf(java.lang.String r21, androidx.compose.ui.tooling.data.SourceInformationContext r22) {
        /*
            r1 = r21
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r2 = r0
            kotlin.text.Regex r0 = tokenizer
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4 = 0
            r5 = 2
            r6 = 0
            kotlin.text.MatchResult r0 = kotlin.text.Regex.find$default(r0, r3, r4, r5, r6)
            r2.element = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3 = r0
            java.util.List r3 = (java.util.List) r3
            r0 = -1
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r16 = r5
            r17 = r7
            r18 = r8
            r19 = r9
            r5 = r0
        L_0x002e:
            T r0 = r2.element
            if (r0 == 0) goto L_0x0118
            T r0 = r2.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r7 = r0
            kotlin.text.MatchResult r7 = (kotlin.text.MatchResult) r7
            boolean r0 = isNumber(r7)
            if (r0 != 0) goto L_0x0105
            java.lang.String r0 = "@"
            boolean r0 = isChar(r7, r0)
            if (r0 == 0) goto L_0x004b
            goto L_0x0105
        L_0x004b:
            java.lang.String r0 = "C"
            boolean r0 = isChar(r7, r0)
            if (r0 == 0) goto L_0x005f
            if (r16 == 0) goto L_0x0057
            r17 = 1
        L_0x0057:
            r0 = 1
            sourceInformationContextOf$next$4(r2)
            r16 = r0
            goto L_0x010f
        L_0x005f:
            boolean r0 = isCallWithName(r7)
            if (r0 == 0) goto L_0x0077
            if (r16 == 0) goto L_0x0069
            r17 = 1
        L_0x0069:
            r0 = 1
            java.lang.String r8 = callName(r7)
            sourceInformationContextOf$next$4(r2)
            r16 = r0
            r18 = r8
            goto L_0x010f
        L_0x0077:
            boolean r0 = isParameterInformation(r7)
            if (r0 == 0) goto L_0x008c
            java.lang.String r0 = getText(r7)
            java.util.List r0 = parseParameters(r0)
            sourceInformationContextOf$next$4(r2)
            r19 = r0
            goto L_0x010f
        L_0x008c:
            java.lang.String r0 = "*"
            boolean r0 = isChar(r7, r0)
            if (r0 == 0) goto L_0x009e
            int r0 = r3.size()
            sourceInformationContextOf$next$4(r2)
            r5 = r0
            goto L_0x010f
        L_0x009e:
            java.lang.String r0 = ","
            boolean r0 = isChar(r7, r0)
            if (r0 == 0) goto L_0x00ab
            sourceInformationContextOf$next$4(r2)
            goto L_0x010f
        L_0x00ab:
            boolean r0 = isFileName(r7)
            if (r0 == 0) goto L_0x0104
            kotlin.ranges.IntRange r0 = r7.getRange()
            int r0 = r0.getLast()
            r8 = 1
            int r0 = r0 + r8
            java.lang.String r0 = r1.substring(r0)
            java.lang.String r9 = "this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r9)
            java.lang.String r9 = "#"
            java.lang.String r10 = ""
            java.lang.String r9 = kotlin.text.StringsKt.substringAfterLast((java.lang.String) r0, (java.lang.String) r9, (java.lang.String) r10)
            r10 = r9
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            int r10 = r10.length()
            if (r10 <= 0) goto L_0x00d8
            r10 = r8
            goto L_0x00d9
        L_0x00d8:
            r10 = r4
        L_0x00d9:
            if (r10 == 0) goto L_0x0100
            int r10 = r0.length()
            int r12 = r9.length()
            int r10 = r10 - r12
            int r10 = r10 - r8
            kotlin.ranges.IntRange r4 = kotlin.ranges.RangesKt.until((int) r4, (int) r10)
            java.lang.String r4 = kotlin.text.StringsKt.substring((java.lang.String) r0, (kotlin.ranges.IntRange) r4)
            r0 = 36
            int r0 = parseToInt(r9, r0)     // Catch:{ NumberFormatException -> 0x00f8 }
            goto L_0x00fd
        L_0x00f8:
            r0 = move-exception
            r8 = r0
            r0 = r8
            r8 = -1
            r0 = r8
        L_0x00fd:
            r11 = r0
            r10 = r4
            goto L_0x0101
        L_0x0100:
            r10 = r0
        L_0x0101:
            r0 = r10
            r4 = r11
            goto L_0x011a
        L_0x0104:
            goto L_0x0118
        L_0x0105:
            androidx.compose.ui.tooling.data.SourceLocationInfo r0 = sourceInformationContextOf$parseLocation(r2)
            if (r0 == 0) goto L_0x010f
            r8 = 0
            r3.add(r0)
        L_0x010f:
            T r0 = r2.element
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x002e
            return r6
        L_0x0118:
            r0 = r10
            r4 = r11
        L_0x011a:
            androidx.compose.ui.tooling.data.SourceInformationContext r20 = new androidx.compose.ui.tooling.data.SourceInformationContext
            if (r0 != 0) goto L_0x0127
            if (r22 == 0) goto L_0x0125
            java.lang.String r6 = r22.getSourceFile()
        L_0x0125:
            r9 = r6
            goto L_0x0128
        L_0x0127:
            r9 = r0
        L_0x0128:
            if (r0 == 0) goto L_0x012b
        L_0x012a:
            goto L_0x0133
        L_0x012b:
            if (r22 == 0) goto L_0x012a
            int r6 = r22.getPackageHash()
            r10 = r6
            goto L_0x0134
        L_0x0133:
            r10 = r4
        L_0x0134:
            r7 = r20
            r8 = r18
            r11 = r3
            r12 = r5
            r13 = r19
            r14 = r16
            r15 = r17
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15)
            return r20
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.data.SlotTreeKt.sourceInformationContextOf(java.lang.String, androidx.compose.ui.tooling.data.SourceInformationContext):androidx.compose.ui.tooling.data.SourceInformationContext");
    }

    private static final MatchResult sourceInformationContextOf$next$4(Ref.ObjectRef<MatchResult> currentResult) {
        MatchResult it = (MatchResult) currentResult.element;
        if (it != null) {
            currentResult.element = it.next();
        }
        return currentResult.element;
    }

    private static final SourceLocationInfo sourceInformationContextOf$parseLocation(Ref.ObjectRef<MatchResult> currentResult) {
        Integer lineNumber = null;
        Integer offset = null;
        Integer length = null;
        try {
            MatchResult mr = (MatchResult) currentResult.element;
            if (mr != null && isNumber(mr)) {
                lineNumber = Integer.valueOf(number(mr) + 1);
                mr = sourceInformationContextOf$next$4(currentResult);
            }
            if (mr != null && isChar(mr, "@")) {
                MatchResult mr2 = sourceInformationContextOf$next$4(currentResult);
                if (mr2 != null) {
                    if (isNumber(mr2)) {
                        offset = Integer.valueOf(number(mr2));
                        MatchResult mr3 = sourceInformationContextOf$next$4(currentResult);
                        if (mr3 != null && isChar(mr3, "L")) {
                            MatchResult mr4 = sourceInformationContextOf$next$4(currentResult);
                            if (mr4 != null) {
                                if (isNumber(mr4)) {
                                    length = Integer.valueOf(number(mr4));
                                }
                            }
                            return null;
                        }
                    }
                }
                return null;
            }
            if (lineNumber == null || offset == null || length == null) {
                return null;
            }
            return new SourceLocationInfo(lineNumber, offset, length);
        } catch (ParseError e) {
            return null;
        }
    }

    private static final Group getGroup(CompositionGroup $this$getGroup, SourceInformationContext parentContext) {
        List modifierInfo;
        IntRect box;
        SourceInformationContext sourceInformationContext = parentContext;
        Object key = $this$getGroup.getKey();
        String it = $this$getGroup.getSourceInfo();
        Object obj = null;
        SourceInformationContext context = it != null ? sourceInformationContextOf(it, sourceInformationContext) : null;
        Object node = $this$getGroup.getNode();
        List data = new ArrayList();
        List children = new ArrayList();
        CollectionsKt.addAll(data, $this$getGroup.getData());
        for (CompositionGroup child : $this$getGroup.getCompositionGroups()) {
            children.add(getGroup(child, context));
        }
        if (node instanceof LayoutInfo) {
            modifierInfo = ((LayoutInfo) node).getModifierInfo();
        } else {
            modifierInfo = CollectionsKt.emptyList();
        }
        if (node instanceof LayoutInfo) {
            box = boundsOfLayoutNode((LayoutInfo) node);
        } else if (children.isEmpty()) {
            box = emptyBox;
        } else {
            Iterable<Group> $this$map$iv = children;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Group g : $this$map$iv) {
                destination$iv$iv.add(g.getBox());
            }
            Iterator iterator$iv = ((List) destination$iv$iv).iterator();
            if (iterator$iv.hasNext()) {
                Object accumulator$iv = iterator$iv.next();
                while (iterator$iv.hasNext()) {
                    accumulator$iv = union((IntRect) iterator$iv.next(), (IntRect) accumulator$iv);
                }
                box = (IntRect) accumulator$iv;
            } else {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
        }
        boolean z = false;
        SourceLocation location = (!(context != null && context.isCall()) || sourceInformationContext == null) ? null : parentContext.nextSourceLocation();
        if (node != null) {
            List list = children;
            List list2 = data;
            Object obj2 = node;
            SourceInformationContext sourceInformationContext2 = context;
            return new NodeGroup(key, node, box, data, modifierInfo, children);
        }
        String name = context != null ? context.getName() : null;
        CharSequence name2 = context != null ? context.getName() : null;
        if (!(name2 == null || name2.length() == 0) && (box.getBottom() - box.getTop() > 0 || box.getRight() - box.getLeft() > 0)) {
            obj = $this$getGroup.getIdentity();
        }
        List<ParameterInformation> extractParameterInfo = extractParameterInfo(data, context);
        Collection collection = data;
        Collection collection2 = children;
        if (context != null && context.isInline()) {
            z = true;
        }
        List list3 = children;
        List list4 = data;
        Object obj3 = obj;
        Object obj4 = node;
        List<ParameterInformation> list5 = extractParameterInfo;
        SourceInformationContext sourceInformationContext3 = context;
        return new CallGroup(key, name, box, location, obj3, list5, collection, collection2, z);
    }

    /* access modifiers changed from: private */
    public static final IntRect boundsOfLayoutNode(LayoutInfo node) {
        if (!node.isAttached()) {
            return new IntRect(0, 0, node.getWidth(), node.getHeight());
        }
        long position = LayoutCoordinatesKt.positionInWindow(node.getCoordinates());
        long size = node.getCoordinates().m4839getSizeYbymL2g();
        int left = MathKt.roundToInt(Offset.m2915getXimpl(position));
        int top = MathKt.roundToInt(Offset.m2916getYimpl(position));
        return new IntRect(left, top, IntSize.m6146getWidthimpl(size) + left, IntSize.m6145getHeightimpl(size) + top);
    }

    public static /* synthetic */ Object mapTree$default(CompositionData compositionData, Function3 function3, ContextCache contextCache, int i, Object obj) {
        if ((i & 2) != 0) {
            contextCache = new ContextCache();
        }
        return mapTree(compositionData, function3, contextCache);
    }

    public static final <T> T mapTree(CompositionData $this$mapTree, Function3<? super CompositionGroup, ? super SourceContext, ? super List<? extends T>, ? extends T> factory, ContextCache cache) {
        Intrinsics.checkNotNullParameter($this$mapTree, "<this>");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(cache, "cache");
        CompositionGroup group = (CompositionGroup) CollectionsKt.firstOrNull($this$mapTree.getCompositionGroups());
        if (group == null) {
            return null;
        }
        CompositionCallStack callStack = new CompositionCallStack(factory, cache.getContexts$ui_tooling_data_release());
        List out = new ArrayList();
        callStack.convert(group, 0, out);
        return CollectionsKt.firstOrNull(out);
    }

    public static /* synthetic */ List findParameters$default(CompositionGroup compositionGroup, ContextCache contextCache, int i, Object obj) {
        if ((i & 1) != 0) {
            contextCache = null;
        }
        return findParameters(compositionGroup, contextCache);
    }

    public static final List<ParameterInformation> findParameters(CompositionGroup $this$findParameters, ContextCache cache) {
        Object answer$iv;
        Intrinsics.checkNotNullParameter($this$findParameters, "<this>");
        String information = $this$findParameters.getSourceInfo();
        if (information == null) {
            return CollectionsKt.emptyList();
        }
        SourceInformationContext sourceInformationContext = null;
        if (cache == null) {
            sourceInformationContext = sourceInformationContextOf$default(information, (SourceInformationContext) null, 2, (Object) null);
        } else {
            Map $this$getOrPut$iv = cache.getContexts$ui_tooling_data_release();
            Object value$iv = $this$getOrPut$iv.get(information);
            if (value$iv == null) {
                answer$iv = sourceInformationContextOf$default(information, (SourceInformationContext) null, 2, (Object) null);
                $this$getOrPut$iv.put(information, answer$iv);
            } else {
                answer$iv = value$iv;
            }
            if (answer$iv instanceof SourceInformationContext) {
                sourceInformationContext = (SourceInformationContext) answer$iv;
            }
        }
        SourceInformationContext context = sourceInformationContext;
        List data = new ArrayList();
        CollectionsKt.addAll(data, $this$findParameters.getData());
        return extractParameterInfo(data, context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r0 = getGroup(r0, (androidx.compose.ui.tooling.data.SourceInformationContext) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.tooling.data.Group asTree(androidx.compose.runtime.tooling.CompositionData r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.Iterable r0 = r2.getCompositionGroups()
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            androidx.compose.runtime.tooling.CompositionGroup r0 = (androidx.compose.runtime.tooling.CompositionGroup) r0
            if (r0 == 0) goto L_0x0018
            r1 = 0
            androidx.compose.ui.tooling.data.Group r0 = getGroup(r0, r1)
            if (r0 != 0) goto L_0x001c
        L_0x0018:
            androidx.compose.ui.tooling.data.EmptyGroup r0 = androidx.compose.ui.tooling.data.EmptyGroup.INSTANCE
            androidx.compose.ui.tooling.data.Group r0 = (androidx.compose.ui.tooling.data.Group) r0
        L_0x001c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.data.SlotTreeKt.asTree(androidx.compose.runtime.tooling.CompositionData):androidx.compose.ui.tooling.data.Group");
    }

    public static final IntRect union(IntRect $this$union, IntRect other) {
        Intrinsics.checkNotNullParameter($this$union, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        IntRect intRect = emptyBox;
        if (Intrinsics.areEqual((Object) $this$union, (Object) intRect)) {
            return other;
        }
        if (Intrinsics.areEqual((Object) other, (Object) intRect)) {
            return $this$union;
        }
        return new IntRect(Math.min($this$union.getLeft(), other.getLeft()), Math.min($this$union.getTop(), other.getTop()), Math.max($this$union.getRight(), other.getRight()), Math.max($this$union.getBottom(), other.getBottom()));
    }

    private static final String keyPosition(Object key) {
        if (key instanceof String) {
            return (String) key;
        }
        if (!(key instanceof JoinedKey)) {
            return null;
        }
        String keyPosition = keyPosition(((JoinedKey) key).getLeft());
        if (keyPosition == null) {
            return keyPosition(((JoinedKey) key).getRight());
        }
        return keyPosition;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x010e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010b A[Catch:{ all -> 0x0208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0046 A[EDGE_INSN: B:96:0x0046->B:13:0x0046 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<androidx.compose.ui.tooling.data.ParameterInformation> extractParameterInfo(java.util.List<? extends java.lang.Object> r36, androidx.compose.ui.tooling.data.SourceInformationContext r37) {
        /*
            java.lang.String r0 = "it.name"
            r1 = r36
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x021a
            r1 = r36
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            r3 = 0
            java.util.Iterator r4 = r1.iterator()
        L_0x0018:
            boolean r5 = r4.hasNext()
            r6 = 2
            r7 = 0
            r8 = 0
            if (r5 == 0) goto L_0x0045
            java.lang.Object r5 = r4.next()
            r9 = r5
            r10 = 0
            if (r9 == 0) goto L_0x0041
            java.lang.Class r11 = r9.getClass()
            java.lang.String r11 = r11.getName()
            java.lang.String r12 = "it.javaClass.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            java.lang.String r12 = ".RecomposeScopeImpl"
            boolean r11 = kotlin.text.StringsKt.endsWith$default(r11, r12, r8, r6, r7)
            if (r11 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0042
        L_0x0041:
            r9 = r8
        L_0x0042:
            if (r9 == 0) goto L_0x0018
            goto L_0x0046
        L_0x0045:
            r5 = r7
        L_0x0046:
            r1 = r5
            if (r1 == 0) goto L_0x0218
            java.lang.Class r3 = r1.getClass()     // Catch:{ all -> 0x0214 }
            java.lang.String r4 = "block"
            java.lang.reflect.Field r3 = accessibleField(r3, r4)     // Catch:{ all -> 0x0214 }
            if (r3 == 0) goto L_0x020f
            java.lang.Object r4 = r3.get(r1)     // Catch:{ all -> 0x0214 }
            if (r4 == 0) goto L_0x020a
            java.lang.Class r5 = r4.getClass()     // Catch:{ all -> 0x0214 }
            java.lang.String r9 = "$$default"
            java.lang.reflect.Field r9 = accessibleField(r5, r9)     // Catch:{ all -> 0x0214 }
            java.lang.String r10 = "$$changed"
            java.lang.reflect.Field r10 = accessibleField(r5, r10)     // Catch:{ all -> 0x0214 }
            java.lang.String r11 = "null cannot be cast to non-null type kotlin.Int"
            if (r9 == 0) goto L_0x0084
            java.lang.Object r12 = r9.get(r4)     // Catch:{ all -> 0x007f }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r11)     // Catch:{ all -> 0x007f }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ all -> 0x007f }
            int r12 = r12.intValue()     // Catch:{ all -> 0x007f }
            goto L_0x0085
        L_0x007f:
            r0 = move-exception
            r23 = r1
            goto L_0x021a
        L_0x0084:
            r12 = r8
        L_0x0085:
            if (r10 == 0) goto L_0x0096
            java.lang.Object r13 = r10.get(r4)     // Catch:{ all -> 0x007f }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r11)     // Catch:{ all -> 0x007f }
            java.lang.Integer r13 = (java.lang.Integer) r13     // Catch:{ all -> 0x007f }
            int r11 = r13.intValue()     // Catch:{ all -> 0x007f }
            goto L_0x0097
        L_0x0096:
            r11 = r8
        L_0x0097:
            java.lang.reflect.Field[] r13 = r5.getDeclaredFields()     // Catch:{ all -> 0x0214 }
            java.lang.String r14 = "blockClass.declaredFields"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)     // Catch:{ all -> 0x0214 }
            java.lang.Object[] r13 = (java.lang.Object[]) r13     // Catch:{ all -> 0x0214 }
            r14 = 0
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x0214 }
            r15.<init>()     // Catch:{ all -> 0x0214 }
            java.util.Collection r15 = (java.util.Collection) r15     // Catch:{ all -> 0x0214 }
            r16 = r13
            r17 = 0
            r2 = r16
            int r6 = r2.length     // Catch:{ all -> 0x0214 }
            r7 = r8
        L_0x00b4:
            if (r7 >= r6) goto L_0x011c
            r20 = r2[r7]     // Catch:{ all -> 0x0214 }
            r21 = r20
            r8 = r21
            r21 = r8
            java.lang.reflect.Field r21 = (java.lang.reflect.Field) r21     // Catch:{ all -> 0x0214 }
            r22 = 0
            r23 = r1
            java.lang.String r1 = r21.getName()     // Catch:{ all -> 0x0208 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)     // Catch:{ all -> 0x0208 }
            r24 = r2
            java.lang.String r2 = "$"
            r25 = r3
            r26 = r5
            r27 = r6
            r3 = 2
            r5 = 0
            r6 = 0
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r1, r2, r6, r3, r5)     // Catch:{ all -> 0x0208 }
            if (r1 == 0) goto L_0x0106
            java.lang.String r1 = r21.getName()     // Catch:{ all -> 0x0208 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)     // Catch:{ all -> 0x0208 }
            java.lang.String r2 = "$$"
            r3 = 2
            r5 = 0
            r6 = 0
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r1, r2, r6, r3, r5)     // Catch:{ all -> 0x0208 }
            if (r1 != 0) goto L_0x0104
            java.lang.String r1 = r21.getName()     // Catch:{ all -> 0x0208 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)     // Catch:{ all -> 0x0208 }
            java.lang.String r2 = "$jacoco"
            r3 = 2
            r5 = 0
            r6 = 0
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r1, r2, r6, r3, r5)     // Catch:{ all -> 0x0208 }
            if (r1 != 0) goto L_0x0107
            r1 = 1
            goto L_0x0108
        L_0x0104:
            r6 = 0
            goto L_0x0107
        L_0x0106:
            r6 = 0
        L_0x0107:
            r1 = r6
        L_0x0108:
            if (r1 == 0) goto L_0x010e
            r15.add(r8)     // Catch:{ all -> 0x0208 }
        L_0x010e:
            int r7 = r7 + 1
            r8 = r6
            r1 = r23
            r2 = r24
            r3 = r25
            r5 = r26
            r6 = r27
            goto L_0x00b4
        L_0x011c:
            r23 = r1
            r24 = r2
            r25 = r3
            r26 = r5
            r6 = r8
            r0 = r15
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0208 }
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ all -> 0x0208 }
            r1 = 0
            androidx.compose.ui.tooling.data.SlotTreeKt$extractParameterInfo$$inlined$sortedBy$1 r2 = new androidx.compose.ui.tooling.data.SlotTreeKt$extractParameterInfo$$inlined$sortedBy$1     // Catch:{ all -> 0x0208 }
            r2.<init>()     // Catch:{ all -> 0x0208 }
            java.util.Comparator r2 = (java.util.Comparator) r2     // Catch:{ all -> 0x0208 }
            java.util.List r2 = kotlin.collections.CollectionsKt.sortedWith(r0, r2)     // Catch:{ all -> 0x0208 }
            r0 = r2
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0208 }
            r1.<init>()     // Catch:{ all -> 0x0208 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0208 }
            if (r37 == 0) goto L_0x0149
            java.util.List r2 = r37.getParameters()     // Catch:{ all -> 0x0208 }
            if (r2 != 0) goto L_0x014d
        L_0x0149:
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()     // Catch:{ all -> 0x0208 }
        L_0x014d:
            int r3 = r0.size()     // Catch:{ all -> 0x0208 }
            r5 = r6
        L_0x0152:
            if (r5 >= r3) goto L_0x0207
            r7 = r5
            r8 = 0
            int r13 = r2.size()     // Catch:{ all -> 0x0208 }
            if (r7 >= r13) goto L_0x0165
            java.lang.Object r13 = r2.get(r7)     // Catch:{ all -> 0x0208 }
            androidx.compose.ui.tooling.data.Parameter r13 = (androidx.compose.ui.tooling.data.Parameter) r13     // Catch:{ all -> 0x0208 }
            r14 = 2
            r15 = 0
            goto L_0x016c
        L_0x0165:
            androidx.compose.ui.tooling.data.Parameter r13 = new androidx.compose.ui.tooling.data.Parameter     // Catch:{ all -> 0x0208 }
            r14 = 2
            r15 = 0
            r13.<init>(r7, r15, r14, r15)     // Catch:{ all -> 0x0208 }
        L_0x016c:
            int r6 = r13.getSortedIndex()     // Catch:{ all -> 0x0208 }
            int r14 = r0.size()     // Catch:{ all -> 0x0208 }
            if (r6 >= r14) goto L_0x01f6
            int r6 = r13.getSortedIndex()     // Catch:{ all -> 0x0208 }
            java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x0208 }
            java.lang.reflect.Field r6 = (java.lang.reflect.Field) r6     // Catch:{ all -> 0x0208 }
            r14 = 1
            r6.setAccessible(r14)     // Catch:{ all -> 0x0208 }
            java.lang.Object r29 = r6.get(r4)     // Catch:{ all -> 0x0208 }
            int r17 = r14 << r7
            r14 = r17 & r12
            if (r14 == 0) goto L_0x0191
            r14 = 1
            goto L_0x0192
        L_0x0191:
            r14 = 0
        L_0x0192:
            int r17 = r7 * 3
            r18 = 1
            int r17 = r17 + 1
            r19 = 7
            int r19 = r19 << r17
            r19 = r19 & r11
            int r19 = r19 >> r17
            r15 = r19 & 3
            r22 = r0
            r0 = 3
            if (r15 != r0) goto L_0x01ab
            r31 = 1
            goto L_0x01ad
        L_0x01ab:
            r31 = 0
        L_0x01ad:
            r0 = r19 & 3
            if (r0 != 0) goto L_0x01b3
            r0 = 1
            goto L_0x01b4
        L_0x01b3:
            r0 = 0
        L_0x01b4:
            r15 = r19 & 4
            if (r15 != 0) goto L_0x01bb
            r34 = 1
            goto L_0x01bd
        L_0x01bb:
            r34 = 0
        L_0x01bd:
            androidx.compose.ui.tooling.data.ParameterInformation r15 = new androidx.compose.ui.tooling.data.ParameterInformation     // Catch:{ all -> 0x0208 }
            r24 = r2
            java.lang.String r2 = r6.getName()     // Catch:{ all -> 0x0208 }
            r35 = r3
            java.lang.String r3 = "field.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ all -> 0x0208 }
            r3 = 1
            java.lang.String r2 = r2.substring(r3)     // Catch:{ all -> 0x0208 }
            java.lang.String r3 = "this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ all -> 0x0208 }
            if (r0 == 0) goto L_0x01e2
            if (r14 != 0) goto L_0x01e2
            r32 = 1
            goto L_0x01e4
        L_0x01e2:
            r32 = 0
        L_0x01e4:
            java.lang.String r33 = r13.getInlineClass()     // Catch:{ all -> 0x0208 }
            r27 = r15
            r28 = r2
            r30 = r14
            r27.<init>(r28, r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x0208 }
            r1.add(r15)     // Catch:{ all -> 0x0208 }
            goto L_0x01fc
        L_0x01f6:
            r22 = r0
            r24 = r2
            r35 = r3
        L_0x01fc:
            int r5 = r5 + 1
            r0 = r22
            r2 = r24
            r3 = r35
            r6 = 0
            goto L_0x0152
        L_0x0207:
            return r1
        L_0x0208:
            r0 = move-exception
            goto L_0x021a
        L_0x020a:
            r23 = r1
            r25 = r3
            goto L_0x021a
        L_0x020f:
            r23 = r1
            r25 = r3
            goto L_0x021a
        L_0x0214:
            r0 = move-exception
            r23 = r1
            goto L_0x021a
        L_0x0218:
            r23 = r1
        L_0x021a:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.data.SlotTreeKt.extractParameterInfo(java.util.List, androidx.compose.ui.tooling.data.SourceInformationContext):java.util.List");
    }

    public static final String getPosition(Group $this$position) {
        Intrinsics.checkNotNullParameter($this$position, "<this>");
        return keyPosition($this$position.getKey());
    }

    private static final Field accessibleField(Class<?> $this$accessibleField, String name) {
        Field element$iv;
        Field[] declaredFields = $this$accessibleField.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "declaredFields");
        Object[] $this$firstOrNull$iv = (Object[]) declaredFields;
        int length = $this$firstOrNull$iv.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                element$iv = null;
                break;
            }
            element$iv = $this$firstOrNull$iv[i];
            if (Intrinsics.areEqual((Object) ((Field) element$iv).getName(), (Object) name)) {
                break;
            }
            i++;
        }
        Field $this$accessibleField_u24lambda_u2415 = element$iv;
        if ($this$accessibleField_u24lambda_u2415 == null) {
            return null;
        }
        $this$accessibleField_u24lambda_u2415.setAccessible(true);
        return $this$accessibleField_u24lambda_u2415;
    }

    private static final String replacePrefix(String $this$replacePrefix, String prefix, String replacement) {
        if (!StringsKt.startsWith$default($this$replacePrefix, prefix, false, 2, (Object) null)) {
            return $this$replacePrefix;
        }
        StringBuilder append = new StringBuilder().append(replacement);
        String substring = $this$replacePrefix.substring(prefix.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return append.append(substring).toString();
    }
}
