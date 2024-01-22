package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.vector.PathNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aB\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\b2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110#¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020!0&H\b\u001a\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020!0 *\u00020\u00012\u0006\u0010\"\u001a\u00020#H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"ArcToKey", "", "CloseKey", "CurveToKey", "HorizontalToKey", "LineToKey", "MoveToKey", "NUM_ARC_TO_ARGS", "", "NUM_CURVE_TO_ARGS", "NUM_HORIZONTAL_TO_ARGS", "NUM_LINE_TO_ARGS", "NUM_MOVE_TO_ARGS", "NUM_QUAD_TO_ARGS", "NUM_REFLECTIVE_CURVE_TO_ARGS", "NUM_REFLECTIVE_QUAD_TO_ARGS", "NUM_VERTICAL_TO_ARGS", "QuadToKey", "ReflectiveCurveToKey", "ReflectiveQuadToKey", "RelativeArcToKey", "RelativeCloseKey", "RelativeCurveToKey", "RelativeHorizontalToKey", "RelativeLineToKey", "RelativeMoveToKey", "RelativeQuadToKey", "RelativeReflectiveCurveToKey", "RelativeReflectiveQuadToKey", "RelativeVerticalToKey", "VerticalToKey", "pathNodesFromArgs", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "args", "", "numArgs", "nodeFor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "subArray", "toPathNodes", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PathNode.kt */
public final class PathNodeKt {
    private static final char ArcToKey = 'A';
    private static final char CloseKey = 'Z';
    private static final char CurveToKey = 'C';
    private static final char HorizontalToKey = 'H';
    private static final char LineToKey = 'L';
    private static final char MoveToKey = 'M';
    private static final int NUM_ARC_TO_ARGS = 7;
    private static final int NUM_CURVE_TO_ARGS = 6;
    private static final int NUM_HORIZONTAL_TO_ARGS = 1;
    private static final int NUM_LINE_TO_ARGS = 2;
    private static final int NUM_MOVE_TO_ARGS = 2;
    private static final int NUM_QUAD_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_CURVE_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_QUAD_TO_ARGS = 2;
    private static final int NUM_VERTICAL_TO_ARGS = 1;
    private static final char QuadToKey = 'Q';
    private static final char ReflectiveCurveToKey = 'S';
    private static final char ReflectiveQuadToKey = 'T';
    private static final char RelativeArcToKey = 'a';
    private static final char RelativeCloseKey = 'z';
    private static final char RelativeCurveToKey = 'c';
    private static final char RelativeHorizontalToKey = 'h';
    private static final char RelativeLineToKey = 'l';
    private static final char RelativeMoveToKey = 'm';
    private static final char RelativeQuadToKey = 'q';
    private static final char RelativeReflectiveCurveToKey = 's';
    private static final char RelativeReflectiveQuadToKey = 't';
    private static final char RelativeVerticalToKey = 'v';
    private static final char VerticalToKey = 'V';

    public static final List<PathNode> toPathNodes(char $this$toPathNodes, float[] args) {
        PathNode pathNode;
        int $i$f$pathNodesFromArgs;
        PathNode pathNode2;
        PathNode pathNode3;
        PathNode pathNode4;
        PathNode pathNode5;
        PathNode pathNode6;
        PathNode pathNode7;
        PathNode pathNode8;
        int $i$f$pathNodesFromArgs2;
        int numArgs$iv;
        Iterable $this$map$iv$iv;
        PathNode pathNode9;
        int numArgs$iv2;
        PathNode pathNode10;
        Iterable $this$map$iv$iv2;
        PathNode pathNode11;
        Iterable $this$map$iv$iv3;
        PathNode pathNode12;
        Iterable $this$map$iv$iv4;
        PathNode pathNode13;
        Iterable $this$map$iv$iv5;
        int $i$f$pathNodesFromArgs3;
        PathNode pathNode14;
        PathNode pathNode15;
        PathNode pathNode16;
        PathNode pathNode17;
        PathNode pathNode18;
        char c = $this$toPathNodes;
        float[] fArr = args;
        Intrinsics.checkNotNullParameter(fArr, "args");
        char c2 = 0;
        if (c == 'z' || c == 'Z') {
            return CollectionsKt.listOf(PathNode.Close.INSTANCE);
        }
        if (c == 'm') {
            int numArgs$iv3 = 2;
            int $i$f$pathNodesFromArgs4 = false;
            Iterable $this$map$iv$iv6 = RangesKt.step((IntProgression) new IntRange(0, fArr.length - 2), 2);
            Collection destination$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv6, 10));
            Iterator it = $this$map$iv$iv6.iterator();
            while (it.hasNext()) {
                int index$iv = ((IntIterator) it).nextInt();
                float[] subArray$iv = ArraysKt.copyOfRange(fArr, index$iv, index$iv + numArgs$iv3);
                float[] array = subArray$iv;
                int numArgs$iv4 = numArgs$iv3;
                int $i$f$pathNodesFromArgs5 = $i$f$pathNodesFromArgs4;
                PathNode node$iv = new PathNode.RelativeMoveTo(array[c2], array[1]);
                if (!(node$iv instanceof PathNode.MoveTo) || index$iv <= 0) {
                    PathNode node$iv2 = node$iv;
                    if (index$iv > 0) {
                        pathNode18 = new PathNode.RelativeLineTo(subArray$iv[0], subArray$iv[1]);
                    } else {
                        pathNode18 = node$iv2;
                    }
                } else {
                    PathNode pathNode19 = node$iv;
                    pathNode18 = new PathNode.LineTo(subArray$iv[0], subArray$iv[1]);
                }
                destination$iv$iv$iv.add(pathNode18);
                numArgs$iv3 = numArgs$iv4;
                $i$f$pathNodesFromArgs4 = $i$f$pathNodesFromArgs5;
                c2 = 0;
            }
            int i = $i$f$pathNodesFromArgs4;
            return (List) destination$iv$iv$iv;
        } else if (c == 'M') {
            int numArgs$iv5 = 2;
            int $i$f$pathNodesFromArgs6 = false;
            Iterable $this$map$iv$iv7 = RangesKt.step((IntProgression) new IntRange(0, fArr.length - 2), 2);
            Collection destination$iv$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv7, 10));
            Iterator it2 = $this$map$iv$iv7.iterator();
            while (it2.hasNext()) {
                int index$iv2 = ((IntIterator) it2).nextInt();
                float[] subArray$iv2 = ArraysKt.copyOfRange(fArr, index$iv2, index$iv2 + numArgs$iv5);
                float[] array2 = subArray$iv2;
                int numArgs$iv6 = numArgs$iv5;
                int $i$f$pathNodesFromArgs7 = $i$f$pathNodesFromArgs6;
                Iterable $this$map$iv$iv8 = $this$map$iv$iv7;
                PathNode node$iv3 = new PathNode.MoveTo(array2[0], array2[1]);
                if (index$iv2 > 0) {
                    pathNode17 = new PathNode.LineTo(subArray$iv2[0], subArray$iv2[1]);
                } else if (!(node$iv3 instanceof PathNode.RelativeMoveTo) || index$iv2 <= 0) {
                    pathNode17 = node$iv3;
                } else {
                    pathNode17 = new PathNode.RelativeLineTo(subArray$iv2[0], subArray$iv2[1]);
                }
                destination$iv$iv$iv2.add(pathNode17);
                numArgs$iv5 = numArgs$iv6;
                $i$f$pathNodesFromArgs6 = $i$f$pathNodesFromArgs7;
                $this$map$iv$iv7 = $this$map$iv$iv8;
            }
            int i2 = $i$f$pathNodesFromArgs6;
            Iterable iterable = $this$map$iv$iv7;
            return (List) destination$iv$iv$iv2;
        } else if (c == 'l') {
            int numArgs$iv7 = 2;
            int $i$f$pathNodesFromArgs8 = false;
            Iterable $this$map$iv$iv9 = RangesKt.step((IntProgression) new IntRange(0, fArr.length - 2), 2);
            Collection destination$iv$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv9, 10));
            Iterator it3 = $this$map$iv$iv9.iterator();
            while (it3.hasNext()) {
                int index$iv3 = ((IntIterator) it3).nextInt();
                float[] subArray$iv3 = ArraysKt.copyOfRange(fArr, index$iv3, index$iv3 + numArgs$iv7);
                float[] array3 = subArray$iv3;
                int numArgs$iv8 = numArgs$iv7;
                int $i$f$pathNodesFromArgs9 = $i$f$pathNodesFromArgs8;
                Iterable $this$map$iv$iv10 = $this$map$iv$iv9;
                PathNode node$iv4 = new PathNode.RelativeLineTo(array3[0], array3[1]);
                if ((node$iv4 instanceof PathNode.MoveTo) && index$iv3 > 0) {
                    pathNode16 = new PathNode.LineTo(subArray$iv3[0], subArray$iv3[1]);
                } else if (!(node$iv4 instanceof PathNode.RelativeMoveTo) || index$iv3 <= 0) {
                    pathNode16 = node$iv4;
                } else {
                    pathNode16 = new PathNode.RelativeLineTo(subArray$iv3[0], subArray$iv3[1]);
                }
                destination$iv$iv$iv3.add(pathNode16);
                numArgs$iv7 = numArgs$iv8;
                $this$map$iv$iv9 = $this$map$iv$iv10;
                $i$f$pathNodesFromArgs8 = $i$f$pathNodesFromArgs9;
            }
            int i3 = $i$f$pathNodesFromArgs8;
            Iterable iterable2 = $this$map$iv$iv9;
            return (List) destination$iv$iv$iv3;
        } else if (c == 'L') {
            int numArgs$iv9 = 2;
            int $i$f$pathNodesFromArgs10 = false;
            Iterable $this$map$iv$iv11 = RangesKt.step((IntProgression) new IntRange(0, fArr.length - 2), 2);
            Collection destination$iv$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv11, 10));
            Iterator it4 = $this$map$iv$iv11.iterator();
            while (it4.hasNext()) {
                int index$iv4 = ((IntIterator) it4).nextInt();
                float[] subArray$iv4 = ArraysKt.copyOfRange(fArr, index$iv4, index$iv4 + numArgs$iv9);
                float[] array4 = subArray$iv4;
                int numArgs$iv10 = numArgs$iv9;
                int $i$f$pathNodesFromArgs11 = $i$f$pathNodesFromArgs10;
                Iterable $this$map$iv$iv12 = $this$map$iv$iv11;
                PathNode node$iv5 = new PathNode.LineTo(array4[0], array4[1]);
                if ((node$iv5 instanceof PathNode.MoveTo) && index$iv4 > 0) {
                    pathNode15 = new PathNode.LineTo(subArray$iv4[0], subArray$iv4[1]);
                } else if (!(node$iv5 instanceof PathNode.RelativeMoveTo) || index$iv4 <= 0) {
                    pathNode15 = node$iv5;
                } else {
                    pathNode15 = new PathNode.RelativeLineTo(subArray$iv4[0], subArray$iv4[1]);
                }
                destination$iv$iv$iv4.add(pathNode15);
                numArgs$iv9 = numArgs$iv10;
                $this$map$iv$iv11 = $this$map$iv$iv12;
                $i$f$pathNodesFromArgs10 = $i$f$pathNodesFromArgs11;
            }
            int i4 = $i$f$pathNodesFromArgs10;
            Iterable iterable3 = $this$map$iv$iv11;
            return (List) destination$iv$iv$iv4;
        } else if (c == 'h') {
            int numArgs$iv11 = 1;
            int $i$f$pathNodesFromArgs12 = false;
            Iterable $this$map$iv$iv13 = RangesKt.step((IntProgression) new IntRange(0, fArr.length - 1), 1);
            Collection destination$iv$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv13, 10));
            Iterator it5 = $this$map$iv$iv13.iterator();
            while (it5.hasNext()) {
                int index$iv5 = ((IntIterator) it5).nextInt();
                float[] subArray$iv5 = ArraysKt.copyOfRange(fArr, index$iv5, index$iv5 + numArgs$iv11);
                int numArgs$iv12 = numArgs$iv11;
                PathNode node$iv6 = new PathNode.RelativeHorizontalTo(subArray$iv5[0]);
                if (!(node$iv6 instanceof PathNode.MoveTo) || index$iv5 <= 0) {
                    $i$f$pathNodesFromArgs3 = $i$f$pathNodesFromArgs12;
                    $this$map$iv$iv5 = $this$map$iv$iv13;
                    if (!(node$iv6 instanceof PathNode.RelativeMoveTo) || index$iv5 <= 0) {
                        pathNode14 = node$iv6;
                    } else {
                        pathNode14 = new PathNode.RelativeLineTo(subArray$iv5[0], subArray$iv5[1]);
                    }
                } else {
                    $i$f$pathNodesFromArgs3 = $i$f$pathNodesFromArgs12;
                    $this$map$iv$iv5 = $this$map$iv$iv13;
                    pathNode14 = new PathNode.LineTo(subArray$iv5[0], subArray$iv5[1]);
                }
                destination$iv$iv$iv5.add(pathNode14);
                $i$f$pathNodesFromArgs12 = $i$f$pathNodesFromArgs3;
                $this$map$iv$iv13 = $this$map$iv$iv5;
                numArgs$iv11 = numArgs$iv12;
            }
            int i5 = $i$f$pathNodesFromArgs12;
            Iterable iterable4 = $this$map$iv$iv13;
            return (List) destination$iv$iv$iv5;
        } else if (c == 'H') {
            int numArgs$iv13 = 1;
            int $i$f$pathNodesFromArgs13 = false;
            Iterable $this$map$iv$iv14 = RangesKt.step((IntProgression) new IntRange(0, fArr.length - 1), 1);
            Collection destination$iv$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv14, 10));
            Iterator it6 = $this$map$iv$iv14.iterator();
            while (it6.hasNext()) {
                int index$iv6 = ((IntIterator) it6).nextInt();
                float[] subArray$iv6 = ArraysKt.copyOfRange(fArr, index$iv6, index$iv6 + numArgs$iv13);
                int numArgs$iv14 = numArgs$iv13;
                int $i$f$pathNodesFromArgs14 = $i$f$pathNodesFromArgs13;
                PathNode node$iv7 = new PathNode.HorizontalTo(subArray$iv6[0]);
                if (!(node$iv7 instanceof PathNode.MoveTo) || index$iv6 <= 0) {
                    $this$map$iv$iv4 = $this$map$iv$iv14;
                    if (!(node$iv7 instanceof PathNode.RelativeMoveTo) || index$iv6 <= 0) {
                        pathNode13 = node$iv7;
                    } else {
                        pathNode13 = new PathNode.RelativeLineTo(subArray$iv6[0], subArray$iv6[1]);
                    }
                } else {
                    $this$map$iv$iv4 = $this$map$iv$iv14;
                    pathNode13 = new PathNode.LineTo(subArray$iv6[0], subArray$iv6[1]);
                }
                destination$iv$iv$iv6.add(pathNode13);
                numArgs$iv13 = numArgs$iv14;
                $this$map$iv$iv14 = $this$map$iv$iv4;
                $i$f$pathNodesFromArgs13 = $i$f$pathNodesFromArgs14;
            }
            int i6 = $i$f$pathNodesFromArgs13;
            Iterable iterable5 = $this$map$iv$iv14;
            return (List) destination$iv$iv$iv6;
        } else if (c == 'v') {
            int numArgs$iv15 = 1;
            int $i$f$pathNodesFromArgs15 = false;
            Iterable $this$map$iv$iv15 = RangesKt.step((IntProgression) new IntRange(0, fArr.length - 1), 1);
            Collection destination$iv$iv$iv7 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv15, 10));
            Iterator it7 = $this$map$iv$iv15.iterator();
            while (it7.hasNext()) {
                int index$iv7 = ((IntIterator) it7).nextInt();
                float[] subArray$iv7 = ArraysKt.copyOfRange(fArr, index$iv7, index$iv7 + numArgs$iv15);
                int numArgs$iv16 = numArgs$iv15;
                int $i$f$pathNodesFromArgs16 = $i$f$pathNodesFromArgs15;
                PathNode node$iv8 = new PathNode.RelativeVerticalTo(subArray$iv7[0]);
                if (!(node$iv8 instanceof PathNode.MoveTo) || index$iv7 <= 0) {
                    $this$map$iv$iv3 = $this$map$iv$iv15;
                    if (!(node$iv8 instanceof PathNode.RelativeMoveTo) || index$iv7 <= 0) {
                        pathNode12 = node$iv8;
                    } else {
                        pathNode12 = new PathNode.RelativeLineTo(subArray$iv7[0], subArray$iv7[1]);
                    }
                } else {
                    $this$map$iv$iv3 = $this$map$iv$iv15;
                    pathNode12 = new PathNode.LineTo(subArray$iv7[0], subArray$iv7[1]);
                }
                destination$iv$iv$iv7.add(pathNode12);
                numArgs$iv15 = numArgs$iv16;
                $this$map$iv$iv15 = $this$map$iv$iv3;
                $i$f$pathNodesFromArgs15 = $i$f$pathNodesFromArgs16;
            }
            int i7 = $i$f$pathNodesFromArgs15;
            Iterable iterable6 = $this$map$iv$iv15;
            return (List) destination$iv$iv$iv7;
        } else if (c == 'V') {
            int numArgs$iv17 = 1;
            int $i$f$pathNodesFromArgs17 = false;
            Iterable $this$map$iv$iv16 = RangesKt.step((IntProgression) new IntRange(0, fArr.length - 1), 1);
            Collection destination$iv$iv$iv8 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv16, 10));
            Iterator it8 = $this$map$iv$iv16.iterator();
            while (it8.hasNext()) {
                int index$iv8 = ((IntIterator) it8).nextInt();
                float[] subArray$iv8 = ArraysKt.copyOfRange(fArr, index$iv8, index$iv8 + numArgs$iv17);
                int numArgs$iv18 = numArgs$iv17;
                int $i$f$pathNodesFromArgs18 = $i$f$pathNodesFromArgs17;
                PathNode node$iv9 = new PathNode.VerticalTo(subArray$iv8[0]);
                if (!(node$iv9 instanceof PathNode.MoveTo) || index$iv8 <= 0) {
                    $this$map$iv$iv2 = $this$map$iv$iv16;
                    if (!(node$iv9 instanceof PathNode.RelativeMoveTo) || index$iv8 <= 0) {
                        pathNode11 = node$iv9;
                    } else {
                        pathNode11 = new PathNode.RelativeLineTo(subArray$iv8[0], subArray$iv8[1]);
                    }
                } else {
                    $this$map$iv$iv2 = $this$map$iv$iv16;
                    pathNode11 = new PathNode.LineTo(subArray$iv8[0], subArray$iv8[1]);
                }
                destination$iv$iv$iv8.add(pathNode11);
                numArgs$iv17 = numArgs$iv18;
                $this$map$iv$iv16 = $this$map$iv$iv2;
                $i$f$pathNodesFromArgs17 = $i$f$pathNodesFromArgs18;
            }
            int i8 = $i$f$pathNodesFromArgs17;
            Iterable iterable7 = $this$map$iv$iv16;
            return (List) destination$iv$iv$iv8;
        } else {
            char c3 = 4;
            char c4 = 3;
            char c5 = 2;
            if (c == 'c') {
                int numArgs$iv19 = 6;
                Iterable $this$map$iv$iv17 = RangesKt.step((IntProgression) new IntRange(0, fArr.length - 6), 6);
                Collection destination$iv$iv$iv9 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv17, 10));
                Iterator it9 = $this$map$iv$iv17.iterator();
                while (it9.hasNext()) {
                    int index$iv9 = ((IntIterator) it9).nextInt();
                    float[] subArray$iv9 = ArraysKt.copyOfRange(fArr, index$iv9, index$iv9 + numArgs$iv19);
                    float[] array5 = subArray$iv9;
                    PathNode node$iv10 = new PathNode.RelativeCurveTo(array5[0], array5[1], array5[c5], array5[c4], array5[c3], array5[5]);
                    if (!(node$iv10 instanceof PathNode.MoveTo) || index$iv9 <= 0) {
                        numArgs$iv2 = numArgs$iv19;
                        if ((node$iv10 instanceof PathNode.RelativeMoveTo) == 0 || index$iv9 <= 0) {
                            pathNode10 = node$iv10;
                        } else {
                            PathNode pathNode20 = node$iv10;
                            pathNode10 = new PathNode.RelativeLineTo(subArray$iv9[0], subArray$iv9[1]);
                        }
                    } else {
                        numArgs$iv2 = numArgs$iv19;
                        pathNode10 = new PathNode.LineTo(subArray$iv9[0], subArray$iv9[1]);
                        PathNode pathNode21 = node$iv10;
                    }
                    destination$iv$iv$iv9.add(pathNode10);
                    numArgs$iv19 = numArgs$iv2;
                    c3 = 4;
                    c4 = 3;
                    c5 = 2;
                }
                return (List) destination$iv$iv$iv9;
            } else if (c == 'C') {
                int numArgs$iv20 = 6;
                int $i$f$pathNodesFromArgs19 = false;
                Iterable $this$map$iv$iv18 = RangesKt.step((IntProgression) new IntRange(0, fArr.length - 6), 6);
                Collection destination$iv$iv$iv10 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv18, 10));
                Iterator it10 = $this$map$iv$iv18.iterator();
                while (it10.hasNext()) {
                    int index$iv10 = ((IntIterator) it10).nextInt();
                    float[] subArray$iv10 = ArraysKt.copyOfRange(fArr, index$iv10, index$iv10 + numArgs$iv20);
                    float[] array6 = subArray$iv10;
                    PathNode node$iv11 = new PathNode.CurveTo(array6[0], array6[1], array6[2], array6[3], array6[4], array6[5]);
                    if (!(node$iv11 instanceof PathNode.MoveTo) || index$iv10 <= 0) {
                        numArgs$iv = numArgs$iv20;
                        $i$f$pathNodesFromArgs2 = $i$f$pathNodesFromArgs19;
                        if ((node$iv11 instanceof PathNode.RelativeMoveTo) == 0 || index$iv10 <= 0) {
                            $this$map$iv$iv = $this$map$iv$iv18;
                            pathNode9 = node$iv11;
                        } else {
                            $this$map$iv$iv = $this$map$iv$iv18;
                            pathNode9 = new PathNode.RelativeLineTo(subArray$iv10[0], subArray$iv10[1]);
                        }
                    } else {
                        numArgs$iv = numArgs$iv20;
                        $i$f$pathNodesFromArgs2 = $i$f$pathNodesFromArgs19;
                        pathNode9 = new PathNode.LineTo(subArray$iv10[0], subArray$iv10[1]);
                        $this$map$iv$iv = $this$map$iv$iv18;
                    }
                    destination$iv$iv$iv10.add(pathNode9);
                    $this$map$iv$iv18 = $this$map$iv$iv;
                    numArgs$iv20 = numArgs$iv;
                    $i$f$pathNodesFromArgs19 = $i$f$pathNodesFromArgs2;
                }
                int i9 = $i$f$pathNodesFromArgs19;
                Iterable iterable8 = $this$map$iv$iv18;
                return (List) destination$iv$iv$iv10;
            } else if (c == 's') {
                int numArgs$iv21 = 4;
                int $i$f$pathNodesFromArgs20 = false;
                Iterable $this$map$iv$iv19 = RangesKt.step((IntProgression) new IntRange(0, fArr.length - 4), 4);
                int $i$f$map = false;
                Collection destination$iv$iv$iv11 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv19, 10));
                Iterable $this$mapTo$iv$iv$iv = $this$map$iv$iv19;
                Iterator it11 = $this$mapTo$iv$iv$iv.iterator();
                while (it11.hasNext()) {
                    int index$iv11 = ((IntIterator) it11).nextInt();
                    float[] subArray$iv11 = ArraysKt.copyOfRange(fArr, index$iv11, index$iv11 + numArgs$iv21);
                    float[] array7 = subArray$iv11;
                    int numArgs$iv22 = numArgs$iv21;
                    int $i$f$pathNodesFromArgs21 = $i$f$pathNodesFromArgs20;
                    Iterable $this$map$iv$iv20 = $this$map$iv$iv19;
                    int $i$f$map2 = $i$f$map;
                    Iterable $this$mapTo$iv$iv$iv2 = $this$mapTo$iv$iv$iv;
                    PathNode node$iv12 = new PathNode.RelativeReflectiveCurveTo(array7[0], array7[1], array7[2], array7[3]);
                    if ((node$iv12 instanceof PathNode.MoveTo) && index$iv11 > 0) {
                        pathNode8 = new PathNode.LineTo(subArray$iv11[0], subArray$iv11[1]);
                    } else if (!(node$iv12 instanceof PathNode.RelativeMoveTo) || index$iv11 <= 0) {
                        pathNode8 = node$iv12;
                    } else {
                        pathNode8 = new PathNode.RelativeLineTo(subArray$iv11[0], subArray$iv11[1]);
                    }
                    destination$iv$iv$iv11.add(pathNode8);
                    numArgs$iv21 = numArgs$iv22;
                    $this$map$iv$iv19 = $this$map$iv$iv20;
                    $i$f$pathNodesFromArgs20 = $i$f$pathNodesFromArgs21;
                    $i$f$map = $i$f$map2;
                    $this$mapTo$iv$iv$iv = $this$mapTo$iv$iv$iv2;
                }
                int i10 = $i$f$pathNodesFromArgs20;
                Iterable iterable9 = $this$map$iv$iv19;
                int i11 = $i$f$map;
                Iterable iterable10 = $this$mapTo$iv$iv$iv;
                return (List) destination$iv$iv$iv11;
            } else if (c == 'S') {
                int numArgs$iv23 = 4;
                int $i$f$pathNodesFromArgs22 = false;
                Iterable $this$map$iv$iv21 = RangesKt.step((IntProgression) new IntRange(0, fArr.length - 4), 4);
                int $i$f$map3 = false;
                Collection destination$iv$iv$iv12 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv21, 10));
                Iterable $this$mapTo$iv$iv$iv3 = $this$map$iv$iv21;
                Iterator it12 = $this$mapTo$iv$iv$iv3.iterator();
                while (it12.hasNext()) {
                    int index$iv12 = ((IntIterator) it12).nextInt();
                    float[] subArray$iv12 = ArraysKt.copyOfRange(fArr, index$iv12, index$iv12 + numArgs$iv23);
                    float[] array8 = subArray$iv12;
                    int numArgs$iv24 = numArgs$iv23;
                    int $i$f$pathNodesFromArgs23 = $i$f$pathNodesFromArgs22;
                    Iterable $this$map$iv$iv22 = $this$map$iv$iv21;
                    int $i$f$map4 = $i$f$map3;
                    Iterable $this$mapTo$iv$iv$iv4 = $this$mapTo$iv$iv$iv3;
                    PathNode node$iv13 = new PathNode.ReflectiveCurveTo(array8[0], array8[1], array8[2], array8[3]);
                    if ((node$iv13 instanceof PathNode.MoveTo) && index$iv12 > 0) {
                        pathNode7 = new PathNode.LineTo(subArray$iv12[0], subArray$iv12[1]);
                    } else if (!(node$iv13 instanceof PathNode.RelativeMoveTo) || index$iv12 <= 0) {
                        pathNode7 = node$iv13;
                    } else {
                        pathNode7 = new PathNode.RelativeLineTo(subArray$iv12[0], subArray$iv12[1]);
                    }
                    destination$iv$iv$iv12.add(pathNode7);
                    numArgs$iv23 = numArgs$iv24;
                    $this$map$iv$iv21 = $this$map$iv$iv22;
                    $i$f$pathNodesFromArgs22 = $i$f$pathNodesFromArgs23;
                    $i$f$map3 = $i$f$map4;
                    $this$mapTo$iv$iv$iv3 = $this$mapTo$iv$iv$iv4;
                }
                int i12 = $i$f$pathNodesFromArgs22;
                Iterable iterable11 = $this$map$iv$iv21;
                int i13 = $i$f$map3;
                Iterable iterable12 = $this$mapTo$iv$iv$iv3;
                return (List) destination$iv$iv$iv12;
            } else if (c == 'q') {
                int numArgs$iv25 = 4;
                int $i$f$pathNodesFromArgs24 = false;
                Iterable $this$map$iv$iv23 = RangesKt.step((IntProgression) new IntRange(0, fArr.length - 4), 4);
                int $i$f$map5 = false;
                Collection destination$iv$iv$iv13 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv23, 10));
                Iterable $this$mapTo$iv$iv$iv5 = $this$map$iv$iv23;
                Iterator it13 = $this$mapTo$iv$iv$iv5.iterator();
                while (it13.hasNext()) {
                    int index$iv13 = ((IntIterator) it13).nextInt();
                    float[] subArray$iv13 = ArraysKt.copyOfRange(fArr, index$iv13, index$iv13 + numArgs$iv25);
                    float[] array9 = subArray$iv13;
                    int numArgs$iv26 = numArgs$iv25;
                    int $i$f$pathNodesFromArgs25 = $i$f$pathNodesFromArgs24;
                    Iterable $this$map$iv$iv24 = $this$map$iv$iv23;
                    int $i$f$map6 = $i$f$map5;
                    Iterable $this$mapTo$iv$iv$iv6 = $this$mapTo$iv$iv$iv5;
                    PathNode node$iv14 = new PathNode.RelativeQuadTo(array9[0], array9[1], array9[2], array9[3]);
                    if ((node$iv14 instanceof PathNode.MoveTo) && index$iv13 > 0) {
                        pathNode6 = new PathNode.LineTo(subArray$iv13[0], subArray$iv13[1]);
                    } else if (!(node$iv14 instanceof PathNode.RelativeMoveTo) || index$iv13 <= 0) {
                        pathNode6 = node$iv14;
                    } else {
                        pathNode6 = new PathNode.RelativeLineTo(subArray$iv13[0], subArray$iv13[1]);
                    }
                    destination$iv$iv$iv13.add(pathNode6);
                    numArgs$iv25 = numArgs$iv26;
                    $this$map$iv$iv23 = $this$map$iv$iv24;
                    $i$f$pathNodesFromArgs24 = $i$f$pathNodesFromArgs25;
                    $i$f$map5 = $i$f$map6;
                    $this$mapTo$iv$iv$iv5 = $this$mapTo$iv$iv$iv6;
                }
                int i14 = $i$f$pathNodesFromArgs24;
                Iterable iterable13 = $this$map$iv$iv23;
                int i15 = $i$f$map5;
                Iterable iterable14 = $this$mapTo$iv$iv$iv5;
                return (List) destination$iv$iv$iv13;
            } else if (c == 'Q') {
                int numArgs$iv27 = 4;
                int $i$f$pathNodesFromArgs26 = false;
                Iterable $this$map$iv$iv25 = RangesKt.step((IntProgression) new IntRange(0, fArr.length - 4), 4);
                int $i$f$map7 = false;
                Collection destination$iv$iv$iv14 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv25, 10));
                Iterable $this$mapTo$iv$iv$iv7 = $this$map$iv$iv25;
                Iterator it14 = $this$mapTo$iv$iv$iv7.iterator();
                while (it14.hasNext()) {
                    int index$iv14 = ((IntIterator) it14).nextInt();
                    float[] subArray$iv14 = ArraysKt.copyOfRange(fArr, index$iv14, index$iv14 + numArgs$iv27);
                    float[] array10 = subArray$iv14;
                    int numArgs$iv28 = numArgs$iv27;
                    int $i$f$pathNodesFromArgs27 = $i$f$pathNodesFromArgs26;
                    Iterable $this$map$iv$iv26 = $this$map$iv$iv25;
                    int $i$f$map8 = $i$f$map7;
                    Iterable $this$mapTo$iv$iv$iv8 = $this$mapTo$iv$iv$iv7;
                    PathNode node$iv15 = new PathNode.QuadTo(array10[0], array10[1], array10[2], array10[3]);
                    if ((node$iv15 instanceof PathNode.MoveTo) && index$iv14 > 0) {
                        pathNode5 = new PathNode.LineTo(subArray$iv14[0], subArray$iv14[1]);
                    } else if (!(node$iv15 instanceof PathNode.RelativeMoveTo) || index$iv14 <= 0) {
                        pathNode5 = node$iv15;
                    } else {
                        pathNode5 = new PathNode.RelativeLineTo(subArray$iv14[0], subArray$iv14[1]);
                    }
                    destination$iv$iv$iv14.add(pathNode5);
                    numArgs$iv27 = numArgs$iv28;
                    $this$map$iv$iv25 = $this$map$iv$iv26;
                    $i$f$pathNodesFromArgs26 = $i$f$pathNodesFromArgs27;
                    $i$f$map7 = $i$f$map8;
                    $this$mapTo$iv$iv$iv7 = $this$mapTo$iv$iv$iv8;
                }
                int i16 = $i$f$pathNodesFromArgs26;
                Iterable iterable15 = $this$map$iv$iv25;
                int i17 = $i$f$map7;
                Iterable iterable16 = $this$mapTo$iv$iv$iv7;
                return (List) destination$iv$iv$iv14;
            } else if (c == 't') {
                int numArgs$iv29 = 2;
                int $i$f$pathNodesFromArgs28 = false;
                Iterable $this$map$iv$iv27 = RangesKt.step((IntProgression) new IntRange(0, fArr.length - 2), 2);
                Collection destination$iv$iv$iv15 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv27, 10));
                Iterator it15 = $this$map$iv$iv27.iterator();
                while (it15.hasNext()) {
                    int index$iv15 = ((IntIterator) it15).nextInt();
                    float[] subArray$iv15 = ArraysKt.copyOfRange(fArr, index$iv15, index$iv15 + numArgs$iv29);
                    float[] array11 = subArray$iv15;
                    int numArgs$iv30 = numArgs$iv29;
                    int $i$f$pathNodesFromArgs29 = $i$f$pathNodesFromArgs28;
                    Iterable $this$map$iv$iv28 = $this$map$iv$iv27;
                    PathNode node$iv16 = new PathNode.RelativeReflectiveQuadTo(array11[0], array11[1]);
                    if ((node$iv16 instanceof PathNode.MoveTo) && index$iv15 > 0) {
                        pathNode4 = new PathNode.LineTo(subArray$iv15[0], subArray$iv15[1]);
                    } else if (!(node$iv16 instanceof PathNode.RelativeMoveTo) || index$iv15 <= 0) {
                        pathNode4 = node$iv16;
                    } else {
                        pathNode4 = new PathNode.RelativeLineTo(subArray$iv15[0], subArray$iv15[1]);
                    }
                    destination$iv$iv$iv15.add(pathNode4);
                    numArgs$iv29 = numArgs$iv30;
                    $this$map$iv$iv27 = $this$map$iv$iv28;
                    $i$f$pathNodesFromArgs28 = $i$f$pathNodesFromArgs29;
                }
                int i18 = $i$f$pathNodesFromArgs28;
                Iterable iterable17 = $this$map$iv$iv27;
                return (List) destination$iv$iv$iv15;
            } else if (c == 'T') {
                int numArgs$iv31 = 2;
                int $i$f$pathNodesFromArgs30 = false;
                Iterable $this$map$iv$iv29 = RangesKt.step((IntProgression) new IntRange(0, fArr.length - 2), 2);
                Collection destination$iv$iv$iv16 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv29, 10));
                Iterator it16 = $this$map$iv$iv29.iterator();
                while (it16.hasNext()) {
                    int index$iv16 = ((IntIterator) it16).nextInt();
                    float[] subArray$iv16 = ArraysKt.copyOfRange(fArr, index$iv16, index$iv16 + numArgs$iv31);
                    float[] array12 = subArray$iv16;
                    int numArgs$iv32 = numArgs$iv31;
                    int $i$f$pathNodesFromArgs31 = $i$f$pathNodesFromArgs30;
                    Iterable $this$map$iv$iv30 = $this$map$iv$iv29;
                    PathNode node$iv17 = new PathNode.ReflectiveQuadTo(array12[0], array12[1]);
                    if ((node$iv17 instanceof PathNode.MoveTo) && index$iv16 > 0) {
                        pathNode3 = new PathNode.LineTo(subArray$iv16[0], subArray$iv16[1]);
                    } else if (!(node$iv17 instanceof PathNode.RelativeMoveTo) || index$iv16 <= 0) {
                        pathNode3 = node$iv17;
                    } else {
                        pathNode3 = new PathNode.RelativeLineTo(subArray$iv16[0], subArray$iv16[1]);
                    }
                    destination$iv$iv$iv16.add(pathNode3);
                    numArgs$iv31 = numArgs$iv32;
                    $this$map$iv$iv29 = $this$map$iv$iv30;
                    $i$f$pathNodesFromArgs30 = $i$f$pathNodesFromArgs31;
                }
                int i19 = $i$f$pathNodesFromArgs30;
                Iterable iterable18 = $this$map$iv$iv29;
                return (List) destination$iv$iv$iv16;
            } else {
                float f = 0.0f;
                if (c == 'a') {
                    int numArgs$iv33 = 7;
                    int $i$f$pathNodesFromArgs32 = false;
                    Iterable $this$map$iv$iv31 = RangesKt.step((IntProgression) new IntRange(0, fArr.length - 7), 7);
                    Collection destination$iv$iv$iv17 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv31, 10));
                    Iterator it17 = $this$map$iv$iv31.iterator();
                    while (it17.hasNext()) {
                        int index$iv17 = ((IntIterator) it17).nextInt();
                        float[] subArray$iv17 = ArraysKt.copyOfRange(fArr, index$iv17, index$iv17 + numArgs$iv33);
                        float[] array13 = subArray$iv17;
                        int numArgs$iv34 = numArgs$iv33;
                        PathNode node$iv18 = new PathNode.RelativeArcTo(array13[0], array13[1], array13[2], Float.compare(array13[3], f) != 0, Float.compare(array13[4], f) != 0, array13[5], array13[6]);
                        if (!(node$iv18 instanceof PathNode.MoveTo) || index$iv17 <= 0) {
                            $i$f$pathNodesFromArgs = $i$f$pathNodesFromArgs32;
                            if (!(node$iv18 instanceof PathNode.RelativeMoveTo) || index$iv17 <= 0) {
                                pathNode2 = node$iv18;
                            } else {
                                PathNode pathNode22 = node$iv18;
                                pathNode2 = new PathNode.RelativeLineTo(subArray$iv17[0], subArray$iv17[1]);
                            }
                        } else {
                            $i$f$pathNodesFromArgs = $i$f$pathNodesFromArgs32;
                            pathNode2 = new PathNode.LineTo(subArray$iv17[0], subArray$iv17[1]);
                            PathNode pathNode23 = node$iv18;
                        }
                        destination$iv$iv$iv17.add(pathNode2);
                        $i$f$pathNodesFromArgs32 = $i$f$pathNodesFromArgs;
                        numArgs$iv33 = numArgs$iv34;
                        f = 0.0f;
                    }
                    int i20 = $i$f$pathNodesFromArgs32;
                    return (List) destination$iv$iv$iv17;
                } else if (c == 'A') {
                    int numArgs$iv35 = 7;
                    int $i$f$pathNodesFromArgs33 = false;
                    Iterable $this$map$iv$iv32 = RangesKt.step((IntProgression) new IntRange(0, fArr.length - 7), 7);
                    Collection destination$iv$iv$iv18 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv32, 10));
                    Iterator it18 = $this$map$iv$iv32.iterator();
                    while (it18.hasNext()) {
                        int index$iv18 = ((IntIterator) it18).nextInt();
                        float[] subArray$iv18 = ArraysKt.copyOfRange(fArr, index$iv18, index$iv18 + numArgs$iv35);
                        float[] array14 = subArray$iv18;
                        int numArgs$iv36 = numArgs$iv35;
                        int $i$f$pathNodesFromArgs34 = $i$f$pathNodesFromArgs33;
                        PathNode node$iv19 = new PathNode.ArcTo(array14[0], array14[1], array14[2], Float.compare(array14[3], 0.0f) != 0, Float.compare(array14[4], 0.0f) != 0, array14[5], array14[6]);
                        if ((node$iv19 instanceof PathNode.MoveTo) && index$iv18 > 0) {
                            pathNode = new PathNode.LineTo(subArray$iv18[0], subArray$iv18[1]);
                        } else if (!(node$iv19 instanceof PathNode.RelativeMoveTo) || index$iv18 <= 0) {
                            pathNode = node$iv19;
                        } else {
                            pathNode = new PathNode.RelativeLineTo(subArray$iv18[0], subArray$iv18[1]);
                        }
                        destination$iv$iv$iv18.add(pathNode);
                        fArr = args;
                        $i$f$pathNodesFromArgs33 = $i$f$pathNodesFromArgs34;
                        numArgs$iv35 = numArgs$iv36;
                    }
                    int i21 = $i$f$pathNodesFromArgs33;
                    return (List) destination$iv$iv$iv18;
                } else {
                    throw new IllegalArgumentException("Unknown command for: " + c);
                }
            }
        }
    }

    private static final List<PathNode> pathNodesFromArgs(float[] args, int numArgs, Function1<? super float[], ? extends PathNode> nodeFor) {
        PathNode pathNode;
        float[] fArr = args;
        int i = numArgs;
        Iterable $this$map$iv = RangesKt.step((IntProgression) new IntRange(0, fArr.length - i), i);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        Iterator it = $this$map$iv.iterator();
        while (it.hasNext()) {
            int index = ((IntIterator) it).nextInt();
            float[] subArray = ArraysKt.copyOfRange(fArr, index, index + i);
            PathNode node = (PathNode) nodeFor.invoke(subArray);
            if ((node instanceof PathNode.MoveTo) && index > 0) {
                pathNode = new PathNode.LineTo(subArray[0], subArray[1]);
            } else if (!(node instanceof PathNode.RelativeMoveTo) || index <= 0) {
                pathNode = node;
            } else {
                pathNode = new PathNode.RelativeLineTo(subArray[0], subArray[1]);
            }
            destination$iv$iv.add(pathNode);
            fArr = args;
            i = numArgs;
        }
        Function1<? super float[], ? extends PathNode> function1 = nodeFor;
        return (List) destination$iv$iv;
    }
}
