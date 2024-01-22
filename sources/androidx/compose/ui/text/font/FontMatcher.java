package androidx.compose.ui.text.font;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\u000fJ7\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\u0011JF\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\tH\b¢\u0006\u0002\b\u0017\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/text/font/FontMatcher;", "", "()V", "matchFont", "", "Landroidx/compose/ui/text/font/Font;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "matchFont-RetOiIg", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "Landroidx/compose/ui/text/font/FontListFontFamily;", "(Landroidx/compose/ui/text/font/FontListFontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "fontList", "(Ljava/util/List;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "filterByClosestWeight", "preferBelow", "", "minSearchRange", "maxSearchRange", "filterByClosestWeight$ui_text_release", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontMatcher.kt */
public final class FontMatcher {
    /* renamed from: matchFont-RetOiIg  reason: not valid java name */
    public final List<Font> m5559matchFontRetOiIg(List<? extends Font> fontList, FontWeight fontWeight, int fontStyle) {
        List result;
        FontWeight fontWeight2 = fontWeight;
        int i = fontStyle;
        List<? extends Font> list = fontList;
        Intrinsics.checkNotNullParameter(list, "fontList");
        Intrinsics.checkNotNullParameter(fontWeight2, "fontWeight");
        List list2 = fontList;
        List target$iv = new ArrayList(list2.size());
        List $this$fastForEach$iv$iv = list2;
        int size = $this$fastForEach$iv$iv.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            Object it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            Font it = (Font) it$iv;
            if (Intrinsics.areEqual((Object) it.getWeight(), (Object) fontWeight2) && FontStyle.m5563equalsimpl0(it.m5535getStyle_LCdwA(), i)) {
                target$iv.add(it$iv);
            }
        }
        List<Font> list3 = target$iv;
        if (!list3.isEmpty()) {
            return list3;
        }
        List list4 = fontList;
        List target$iv2 = new ArrayList(list4.size());
        List $this$fastForEach$iv$iv2 = list4;
        int size2 = $this$fastForEach$iv$iv2.size();
        for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
            Object it$iv2 = $this$fastForEach$iv$iv2.get(index$iv$iv2);
            if (FontStyle.m5563equalsimpl0(((Font) it$iv2).m5535getStyle_LCdwA(), i)) {
                target$iv2.add(it$iv2);
            }
        }
        Collection collection = target$iv2;
        if (collection.isEmpty()) {
            collection = list;
        }
        List fontsToSearch = (List) collection;
        if (fontWeight2.compareTo(FontWeight.Companion.getW400()) < 0) {
            boolean preferBelow$iv = true;
            FontWeight bestWeightAbove$iv = null;
            FontWeight bestWeightBelow$iv = null;
            int index$iv = 0;
            int size3 = fontsToSearch.size();
            while (true) {
                if (index$iv >= size3) {
                    break;
                }
                FontWeight possibleWeight$iv = ((Font) fontsToSearch.get(index$iv)).getWeight();
                if ((0 == 0 || possibleWeight$iv.compareTo((FontWeight) null) >= 0) && (0 == 0 || possibleWeight$iv.compareTo((FontWeight) null) <= 0)) {
                    if (possibleWeight$iv.compareTo(fontWeight2) >= 0) {
                        if (possibleWeight$iv.compareTo(fontWeight2) <= 0) {
                            bestWeightAbove$iv = possibleWeight$iv;
                            bestWeightBelow$iv = possibleWeight$iv;
                            break;
                        } else if (bestWeightAbove$iv == null || possibleWeight$iv.compareTo(bestWeightAbove$iv) < 0) {
                            bestWeightAbove$iv = possibleWeight$iv;
                        }
                    } else if (bestWeightBelow$iv == null || possibleWeight$iv.compareTo(bestWeightBelow$iv) > 0) {
                        bestWeightBelow$iv = possibleWeight$iv;
                    }
                }
                index$iv++;
            }
            FontWeight bestWeight$iv = bestWeightBelow$iv == null ? bestWeightAbove$iv : bestWeightBelow$iv;
            List $this$fastFilter$iv$iv = fontsToSearch;
            ArrayList target$iv$iv = new ArrayList($this$fastFilter$iv$iv.size());
            List $this$fastForEach$iv$iv$iv = $this$fastFilter$iv$iv;
            int size4 = $this$fastForEach$iv$iv$iv.size();
            int index$iv$iv$iv = 0;
            while (index$iv$iv$iv < size4) {
                int i2 = size4;
                Object it$iv$iv = $this$fastForEach$iv$iv$iv.get(index$iv$iv$iv);
                boolean preferBelow$iv2 = preferBelow$iv;
                if (Intrinsics.areEqual((Object) ((Font) it$iv$iv).getWeight(), (Object) bestWeight$iv)) {
                    target$iv$iv.add(it$iv$iv);
                }
                index$iv$iv$iv++;
                size4 = i2;
                preferBelow$iv = preferBelow$iv2;
            }
            result = target$iv$iv;
            List list5 = fontsToSearch;
        } else if (fontWeight2.compareTo(FontWeight.Companion.getW500()) > 0) {
            boolean preferBelow$iv3 = false;
            FontWeight minSearchRange$iv = null;
            FontWeight bestWeightAbove$iv2 = null;
            FontWeight bestWeightBelow$iv2 = null;
            int index$iv2 = 0;
            int size5 = fontsToSearch.size();
            while (true) {
                if (index$iv2 >= size5) {
                    break;
                }
                FontWeight possibleWeight$iv2 = ((Font) fontsToSearch.get(index$iv2)).getWeight();
                if ((0 == 0 || possibleWeight$iv2.compareTo((FontWeight) null) >= 0) && (0 == 0 || possibleWeight$iv2.compareTo((FontWeight) null) <= 0)) {
                    if (possibleWeight$iv2.compareTo(fontWeight2) >= 0) {
                        if (possibleWeight$iv2.compareTo(fontWeight2) <= 0) {
                            bestWeightAbove$iv2 = possibleWeight$iv2;
                            bestWeightBelow$iv2 = possibleWeight$iv2;
                            break;
                        } else if (bestWeightAbove$iv2 == null || possibleWeight$iv2.compareTo(bestWeightAbove$iv2) < 0) {
                            bestWeightAbove$iv2 = possibleWeight$iv2;
                        }
                    } else if (bestWeightBelow$iv2 == null || possibleWeight$iv2.compareTo(bestWeightBelow$iv2) > 0) {
                        bestWeightBelow$iv2 = possibleWeight$iv2;
                    }
                }
                index$iv2++;
            }
            FontWeight bestWeight$iv2 = bestWeightAbove$iv2 == null ? bestWeightBelow$iv2 : bestWeightAbove$iv2;
            List $this$fastFilter$iv$iv2 = fontsToSearch;
            ArrayList target$iv$iv2 = new ArrayList($this$fastFilter$iv$iv2.size());
            List $this$fastForEach$iv$iv$iv2 = $this$fastFilter$iv$iv2;
            int index$iv$iv$iv2 = 0;
            int size6 = $this$fastForEach$iv$iv$iv2.size();
            while (index$iv$iv$iv2 < size6) {
                boolean preferBelow$iv4 = preferBelow$iv3;
                Object it$iv$iv2 = $this$fastForEach$iv$iv$iv2.get(index$iv$iv$iv2);
                FontWeight minSearchRange$iv2 = minSearchRange$iv;
                if (Intrinsics.areEqual((Object) ((Font) it$iv$iv2).getWeight(), (Object) bestWeight$iv2)) {
                    target$iv$iv2.add(it$iv$iv2);
                }
                index$iv$iv$iv2++;
                preferBelow$iv3 = preferBelow$iv4;
                minSearchRange$iv = minSearchRange$iv2;
            }
            FontWeight fontWeight3 = minSearchRange$iv;
            result = target$iv$iv2;
            List list6 = fontsToSearch;
        } else {
            FontWeight maxSearchRange$iv = FontWeight.Companion.getW500();
            FontMatcher this_$iv = this;
            List $this$filterByClosestWeight$iv = fontsToSearch;
            FontWeight bestWeightAbove$iv3 = null;
            FontWeight bestWeightBelow$iv3 = null;
            int index$iv3 = 0;
            int size7 = $this$filterByClosestWeight$iv.size();
            while (true) {
                if (index$iv3 >= size7) {
                    break;
                }
                FontWeight possibleWeight$iv3 = ((Font) $this$filterByClosestWeight$iv.get(index$iv3)).getWeight();
                if ((0 == 0 || possibleWeight$iv3.compareTo((FontWeight) null) >= 0) && (maxSearchRange$iv == null || possibleWeight$iv3.compareTo(maxSearchRange$iv) <= 0)) {
                    if (possibleWeight$iv3.compareTo(fontWeight2) >= 0) {
                        if (possibleWeight$iv3.compareTo(fontWeight2) <= 0) {
                            bestWeightAbove$iv3 = possibleWeight$iv3;
                            bestWeightBelow$iv3 = possibleWeight$iv3;
                            break;
                        } else if (bestWeightAbove$iv3 == null || possibleWeight$iv3.compareTo(bestWeightAbove$iv3) < 0) {
                            bestWeightAbove$iv3 = possibleWeight$iv3;
                        }
                    } else if (bestWeightBelow$iv3 == null || possibleWeight$iv3.compareTo(bestWeightBelow$iv3) > 0) {
                        bestWeightBelow$iv3 = possibleWeight$iv3;
                    }
                }
                index$iv3++;
            }
            FontWeight bestWeight$iv3 = bestWeightAbove$iv3 == null ? bestWeightBelow$iv3 : bestWeightAbove$iv3;
            List $this$fastFilter$iv$iv3 = $this$filterByClosestWeight$iv;
            ArrayList target$iv$iv3 = new ArrayList($this$fastFilter$iv$iv3.size());
            List $this$fastForEach$iv$iv$iv3 = $this$fastFilter$iv$iv3;
            int size8 = $this$fastForEach$iv$iv$iv3.size();
            FontWeight fontWeight4 = maxSearchRange$iv;
            int index$iv$iv$iv3 = 0;
            while (index$iv$iv$iv3 < size8) {
                FontMatcher this_$iv2 = this_$iv;
                Object it$iv$iv3 = $this$fastForEach$iv$iv$iv3.get(index$iv$iv$iv3);
                int i3 = size8;
                if (Intrinsics.areEqual((Object) ((Font) it$iv$iv3).getWeight(), (Object) bestWeight$iv3)) {
                    target$iv$iv3.add(it$iv$iv3);
                }
                index$iv$iv$iv3++;
                this_$iv = this_$iv2;
                size8 = i3;
            }
            Collection collection2 = target$iv$iv3;
            if (collection2.isEmpty()) {
                FontWeight minSearchRange$iv3 = FontWeight.Companion.getW500();
                List $this$filterByClosestWeight$iv2 = fontsToSearch;
                FontWeight bestWeightAbove$iv4 = null;
                FontWeight bestWeightBelow$iv4 = null;
                int index$iv4 = 0;
                int size9 = $this$filterByClosestWeight$iv2.size();
                while (true) {
                    if (index$iv4 >= size9) {
                        break;
                    }
                    FontWeight possibleWeight$iv4 = ((Font) $this$filterByClosestWeight$iv2.get(index$iv4)).getWeight();
                    if ((minSearchRange$iv3 == null || possibleWeight$iv4.compareTo(minSearchRange$iv3) >= 0) && (0 == 0 || possibleWeight$iv4.compareTo((FontWeight) null) <= 0)) {
                        if (possibleWeight$iv4.compareTo(fontWeight2) >= 0) {
                            if (possibleWeight$iv4.compareTo(fontWeight2) <= 0) {
                                bestWeightAbove$iv4 = possibleWeight$iv4;
                                bestWeightBelow$iv4 = possibleWeight$iv4;
                                break;
                            } else if (bestWeightAbove$iv4 == null || possibleWeight$iv4.compareTo(bestWeightAbove$iv4) < 0) {
                                bestWeightAbove$iv4 = possibleWeight$iv4;
                            }
                        } else if (bestWeightBelow$iv4 == null || possibleWeight$iv4.compareTo(bestWeightBelow$iv4) > 0) {
                            bestWeightBelow$iv4 = possibleWeight$iv4;
                        }
                    }
                    index$iv4++;
                }
                FontWeight bestWeight$iv4 = bestWeightAbove$iv4 == null ? bestWeightBelow$iv4 : bestWeightAbove$iv4;
                List $this$fastFilter$iv$iv4 = $this$filterByClosestWeight$iv2;
                ArrayList target$iv$iv4 = new ArrayList($this$fastFilter$iv$iv4.size());
                List $this$fastForEach$iv$iv$iv4 = $this$fastFilter$iv$iv4;
                int size10 = $this$fastForEach$iv$iv$iv4.size();
                int index$iv$iv$iv4 = 0;
                while (index$iv$iv$iv4 < size10) {
                    int i4 = size10;
                    Object it$iv$iv4 = $this$fastForEach$iv$iv$iv4.get(index$iv$iv$iv4);
                    List fontsToSearch2 = fontsToSearch;
                    if (Intrinsics.areEqual((Object) ((Font) it$iv$iv4).getWeight(), (Object) bestWeight$iv4)) {
                        target$iv$iv4.add(it$iv$iv4);
                    }
                    index$iv$iv$iv4++;
                    size10 = i4;
                    fontsToSearch = fontsToSearch2;
                }
                collection2 = target$iv$iv4;
            }
            result = (List) collection2;
        }
        return result;
    }

    public static /* synthetic */ List filterByClosestWeight$ui_text_release$default(FontMatcher $this, List $receiver, FontWeight fontWeight, boolean preferBelow, FontWeight minSearchRange, FontWeight maxSearchRange, int i, Object obj) {
        FontWeight minSearchRange2;
        FontWeight maxSearchRange2;
        List list = $receiver;
        FontWeight fontWeight2 = fontWeight;
        if ((i & 4) != 0) {
            minSearchRange2 = null;
        } else {
            minSearchRange2 = minSearchRange;
        }
        if ((i & 8) != 0) {
            maxSearchRange2 = null;
        } else {
            maxSearchRange2 = maxSearchRange;
        }
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(fontWeight2, "fontWeight");
        FontWeight bestWeightAbove = null;
        FontWeight bestWeightBelow = null;
        int index = 0;
        int size = $receiver.size();
        while (true) {
            if (index >= size) {
                break;
            }
            FontWeight possibleWeight = ((Font) list.get(index)).getWeight();
            if ((minSearchRange2 == null || possibleWeight.compareTo(minSearchRange2) >= 0) && (maxSearchRange2 == null || possibleWeight.compareTo(maxSearchRange2) <= 0)) {
                if (possibleWeight.compareTo(fontWeight2) >= 0) {
                    if (possibleWeight.compareTo(fontWeight2) <= 0) {
                        bestWeightAbove = possibleWeight;
                        bestWeightBelow = possibleWeight;
                        break;
                    } else if (bestWeightAbove == null || possibleWeight.compareTo(bestWeightAbove) < 0) {
                        bestWeightAbove = possibleWeight;
                    }
                } else if (bestWeightBelow == null || possibleWeight.compareTo(bestWeightBelow) > 0) {
                    bestWeightBelow = possibleWeight;
                }
            }
            index++;
        }
        FontWeight bestWeight = (!preferBelow ? bestWeightAbove != null : bestWeightBelow == null) ? bestWeightAbove : bestWeightBelow;
        List $this$fastFilter$iv = $receiver;
        ArrayList target$iv = new ArrayList($this$fastFilter$iv.size());
        List $this$fastForEach$iv$iv = $this$fastFilter$iv;
        int index$iv$iv = 0;
        int size2 = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size2) {
            Object it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            if (Intrinsics.areEqual((Object) ((Font) it$iv).getWeight(), (Object) bestWeight)) {
                target$iv.add(it$iv);
            }
            index$iv$iv++;
            List list2 = $receiver;
            FontWeight fontWeight3 = fontWeight;
        }
        return target$iv;
    }

    public final List<Font> filterByClosestWeight$ui_text_release(List<? extends Font> $this$filterByClosestWeight, FontWeight fontWeight, boolean preferBelow, FontWeight minSearchRange, FontWeight maxSearchRange) {
        List<? extends Font> list = $this$filterByClosestWeight;
        FontWeight fontWeight2 = fontWeight;
        FontWeight fontWeight3 = minSearchRange;
        FontWeight fontWeight4 = maxSearchRange;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(fontWeight2, "fontWeight");
        FontWeight bestWeightAbove = null;
        FontWeight bestWeightBelow = null;
        int index = 0;
        int size = $this$filterByClosestWeight.size();
        while (true) {
            if (index >= size) {
                break;
            }
            FontWeight possibleWeight = ((Font) list.get(index)).getWeight();
            if ((fontWeight3 == null || possibleWeight.compareTo(fontWeight3) >= 0) && (fontWeight4 == null || possibleWeight.compareTo(fontWeight4) <= 0)) {
                if (possibleWeight.compareTo(fontWeight2) >= 0) {
                    if (possibleWeight.compareTo(fontWeight2) <= 0) {
                        bestWeightAbove = possibleWeight;
                        bestWeightBelow = possibleWeight;
                        break;
                    } else if (bestWeightAbove == null || possibleWeight.compareTo(bestWeightAbove) < 0) {
                        bestWeightAbove = possibleWeight;
                    }
                } else if (bestWeightBelow == null || possibleWeight.compareTo(bestWeightBelow) > 0) {
                    bestWeightBelow = possibleWeight;
                }
            }
            index++;
        }
        FontWeight bestWeight = (!preferBelow ? bestWeightAbove != null : bestWeightBelow == null) ? bestWeightAbove : bestWeightBelow;
        List list2 = $this$filterByClosestWeight;
        ArrayList target$iv = new ArrayList(list2.size());
        List $this$fastForEach$iv$iv = list2;
        int index$iv$iv = 0;
        int size2 = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size2) {
            Object it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            if (Intrinsics.areEqual((Object) ((Font) it$iv).getWeight(), (Object) bestWeight)) {
                target$iv.add(it$iv);
            }
            index$iv$iv++;
            List<? extends Font> list3 = $this$filterByClosestWeight;
            FontWeight fontWeight5 = fontWeight;
        }
        return target$iv;
    }

    /* renamed from: matchFont-RetOiIg  reason: not valid java name */
    public final List<Font> m5557matchFontRetOiIg(FontFamily fontFamily, FontWeight fontWeight, int fontStyle) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        if (fontFamily instanceof FontListFontFamily) {
            return m5558matchFontRetOiIg((FontListFontFamily) fontFamily, fontWeight, fontStyle);
        }
        throw new IllegalArgumentException("Only FontFamily instances that presents a list of Fonts can be used");
    }

    /* renamed from: matchFont-RetOiIg  reason: not valid java name */
    public final List<Font> m5558matchFontRetOiIg(FontListFontFamily fontFamily, FontWeight fontWeight, int fontStyle) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return m5559matchFontRetOiIg((List<? extends Font>) fontFamily.getFonts(), fontWeight, fontStyle);
    }
}
