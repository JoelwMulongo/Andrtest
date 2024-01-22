package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001al\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001av\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0016\u001al\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001c\u001av\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001d\u001a¬\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u00112%\b\n\u0010&\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\bø\u0001\u0000¢\u0006\u0002\u0010+\u001a\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\bø\u0001\u0000¢\u0006\u0002\u0010,\u001a¬\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u00112%\b\n\u0010&\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\bø\u0001\u0000¢\u0006\u0002\u0010.\u001a\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\bø\u0001\u0000¢\u0006\u0002\u0010/\u001aë\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2:\b\u0006\u0010&\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\bø\u0001\u0000¢\u0006\u0002\u00104\u001a¯\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\bø\u0001\u0000¢\u0006\u0002\u00105\u001aë\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2:\b\u0006\u0010&\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\bø\u0001\u0000¢\u0006\u0002\u00106\u001a¯\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\bø\u0001\u0000¢\u0006\u0002\u00107\u0002\u0007\n\u0005\b20\u0001¨\u00068"}, d2 = {"LazyColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "userScrollEnabled", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyRow", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "contentType", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyDsl.kt */
public final class LazyDslKt {
    public static /* synthetic */ void items$default(LazyListScope $this$items_u24default, List items, Function1 key, Function1 contentType, Function4 itemContent, int i, Object obj) {
        Function1 function1;
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            contentType = LazyDslKt$items$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter($this$items_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (key != null) {
            function1 = new LazyDslKt$items$2(key, items);
        } else {
            function1 = null;
        }
        $this$items_u24default.items(size, function1, new LazyDslKt$items$3(contentType, items), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new LazyDslKt$items$4(itemContent, items)));
    }

    public static final <T> void items(LazyListScope $this$items, List<? extends T> items, Function1<? super T, ? extends Object> key, Function1<? super T, ? extends Object> contentType, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Function1 function1;
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (key != null) {
            function1 = new LazyDslKt$items$2(key, items);
        } else {
            function1 = null;
        }
        $this$items.items(size, function1, new LazyDslKt$items$3(contentType, items), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new LazyDslKt$items$4(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyListScope $this$items_u24default, List items, Function1 key, Function4 itemContent, int i, Object obj) {
        Function1 function1;
        if ((i & 2) != 0) {
            key = null;
        }
        Intrinsics.checkNotNullParameter($this$items_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        LazyListScope $this$items_u24default$iv = $this$items_u24default;
        Function1 contentType$iv = LazyDslKt$items$1.INSTANCE;
        int size = items.size();
        if (key != null) {
            function1 = new LazyDslKt$items$2(key, items);
        } else {
            function1 = null;
        }
        $this$items_u24default$iv.items(size, function1, new LazyDslKt$items$3(contentType$iv, items), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new LazyDslKt$items$4(itemContent, items)));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void items(LazyListScope $this$items, List<? extends T> items, Function1<? super T, ? extends Object> key, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Function1 function1;
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        LazyListScope $this$items_u24default$iv = $this$items;
        Function1 contentType$iv = LazyDslKt$items$1.INSTANCE;
        int size = items.size();
        if (key != null) {
            function1 = new LazyDslKt$items$2(key, items);
        } else {
            function1 = null;
        }
        $this$items_u24default$iv.items(size, function1, new LazyDslKt$items$3(contentType$iv, items), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new LazyDslKt$items$4(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope $this$itemsIndexed_u24default, List items, Function2 key, Function2 contentType, Function5 itemContent, int i, Object obj) {
        Function1 function1;
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            contentType = LazyDslKt$itemsIndexed$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter($this$itemsIndexed_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (key != null) {
            function1 = new LazyDslKt$itemsIndexed$2(key, items);
        } else {
            function1 = null;
        }
        $this$itemsIndexed_u24default.items(size, function1, new LazyDslKt$itemsIndexed$3(contentType, items), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new LazyDslKt$itemsIndexed$4(itemContent, items)));
    }

    public static final <T> void itemsIndexed(LazyListScope $this$itemsIndexed, List<? extends T> items, Function2<? super Integer, ? super T, ? extends Object> key, Function2<? super Integer, ? super T, ? extends Object> contentType, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Function1 function1;
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (key != null) {
            function1 = new LazyDslKt$itemsIndexed$2(key, items);
        } else {
            function1 = null;
        }
        $this$itemsIndexed.items(size, function1, new LazyDslKt$itemsIndexed$3(contentType, items), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new LazyDslKt$itemsIndexed$4(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope $this$itemsIndexed_u24default, List items, Function2 key, Function5 itemContent, int i, Object obj) {
        Function1 function1;
        if ((i & 2) != 0) {
            key = null;
        }
        Intrinsics.checkNotNullParameter($this$itemsIndexed_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        LazyListScope $this$itemsIndexed_u24default$iv = $this$itemsIndexed_u24default;
        int size = items.size();
        if (key != null) {
            function1 = new LazyDslKt$itemsIndexed$2(key, items);
        } else {
            function1 = null;
        }
        $this$itemsIndexed_u24default$iv.items(size, function1, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(items), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new LazyDslKt$itemsIndexed$4(itemContent, items)));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void itemsIndexed(LazyListScope $this$itemsIndexed, List<? extends T> items, Function2<? super Integer, ? super T, ? extends Object> key, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Function1 function1;
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        LazyListScope $this$itemsIndexed_u24default$iv = $this$itemsIndexed;
        int size = items.size();
        if (key != null) {
            function1 = new LazyDslKt$itemsIndexed$2(key, items);
        } else {
            function1 = null;
        }
        $this$itemsIndexed_u24default$iv.items(size, function1, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(items), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new LazyDslKt$itemsIndexed$4(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyListScope $this$items_u24default, Object[] items, Function1 key, Function1 contentType, Function4 itemContent, int i, Object obj) {
        Function1 function1;
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            contentType = LazyDslKt$items$5.INSTANCE;
        }
        Intrinsics.checkNotNullParameter($this$items_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (key != null) {
            function1 = new LazyDslKt$items$6(key, items);
        } else {
            function1 = null;
        }
        $this$items_u24default.items(length, function1, new LazyDslKt$items$7(contentType, items), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new LazyDslKt$items$8(itemContent, items)));
    }

    public static final <T> void items(LazyListScope $this$items, T[] items, Function1<? super T, ? extends Object> key, Function1<? super T, ? extends Object> contentType, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Function1 function1;
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (key != null) {
            function1 = new LazyDslKt$items$6(key, items);
        } else {
            function1 = null;
        }
        $this$items.items(length, function1, new LazyDslKt$items$7(contentType, items), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new LazyDslKt$items$8(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyListScope $this$items_u24default, Object[] items, Function1 key, Function4 itemContent, int i, Object obj) {
        Function1 function1;
        if ((i & 2) != 0) {
            key = null;
        }
        Intrinsics.checkNotNullParameter($this$items_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        LazyListScope $this$items_u24default$iv = $this$items_u24default;
        Function1 contentType$iv = LazyDslKt$items$5.INSTANCE;
        int length = items.length;
        if (key != null) {
            function1 = new LazyDslKt$items$6(key, items);
        } else {
            function1 = null;
        }
        $this$items_u24default$iv.items(length, function1, new LazyDslKt$items$7(contentType$iv, items), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new LazyDslKt$items$8(itemContent, items)));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void items(LazyListScope $this$items, T[] items, Function1<? super T, ? extends Object> key, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Function1 function1;
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        LazyListScope $this$items_u24default$iv = $this$items;
        Function1 contentType$iv = LazyDslKt$items$5.INSTANCE;
        int length = items.length;
        if (key != null) {
            function1 = new LazyDslKt$items$6(key, items);
        } else {
            function1 = null;
        }
        $this$items_u24default$iv.items(length, function1, new LazyDslKt$items$7(contentType$iv, items), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new LazyDslKt$items$8(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope $this$itemsIndexed_u24default, Object[] items, Function2 key, Function2 contentType, Function5 itemContent, int i, Object obj) {
        Function1 function1;
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            contentType = LazyDslKt$itemsIndexed$5.INSTANCE;
        }
        Intrinsics.checkNotNullParameter($this$itemsIndexed_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (key != null) {
            function1 = new LazyDslKt$itemsIndexed$6(key, items);
        } else {
            function1 = null;
        }
        $this$itemsIndexed_u24default.items(length, function1, new LazyDslKt$itemsIndexed$7(contentType, items), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new LazyDslKt$itemsIndexed$8(itemContent, items)));
    }

    public static final <T> void itemsIndexed(LazyListScope $this$itemsIndexed, T[] items, Function2<? super Integer, ? super T, ? extends Object> key, Function2<? super Integer, ? super T, ? extends Object> contentType, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Function1 function1;
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (key != null) {
            function1 = new LazyDslKt$itemsIndexed$6(key, items);
        } else {
            function1 = null;
        }
        $this$itemsIndexed.items(length, function1, new LazyDslKt$itemsIndexed$7(contentType, items), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new LazyDslKt$itemsIndexed$8(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope $this$itemsIndexed_u24default, Object[] items, Function2 key, Function5 itemContent, int i, Object obj) {
        Function1 function1;
        if ((i & 2) != 0) {
            key = null;
        }
        Intrinsics.checkNotNullParameter($this$itemsIndexed_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        LazyListScope $this$itemsIndexed_u24default$iv = $this$itemsIndexed_u24default;
        int length = items.length;
        if (key != null) {
            function1 = new LazyDslKt$itemsIndexed$6(key, items);
        } else {
            function1 = null;
        }
        $this$itemsIndexed_u24default$iv.items(length, function1, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(items), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new LazyDslKt$itemsIndexed$8(itemContent, items)));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void itemsIndexed(LazyListScope $this$itemsIndexed, T[] items, Function2<? super Integer, ? super T, ? extends Object> key, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Function1 function1;
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        LazyListScope $this$itemsIndexed_u24default$iv = $this$itemsIndexed;
        int length = items.length;
        if (key != null) {
            function1 = new LazyDslKt$itemsIndexed$6(key, items);
        } else {
            function1 = null;
        }
        $this$itemsIndexed_u24default$iv.items(length, function1, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(items), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new LazyDslKt$itemsIndexed$8(itemContent, items)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyRow(androidx.compose.ui.Modifier r27, androidx.compose.foundation.lazy.LazyListState r28, androidx.compose.foundation.layout.PaddingValues r29, boolean r30, androidx.compose.foundation.layout.Arrangement.Horizontal r31, androidx.compose.ui.Alignment.Vertical r32, androidx.compose.foundation.gestures.FlingBehavior r33, boolean r34, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r13 = r35
            r12 = r37
            r11 = r38
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -1724297413(0xffffffff99394f3b, float:-9.580276E-24)
            r1 = r36
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LazyRow)P(4,6,1,5,3,8,2,7)291@14018L23,297@14369L15,301@14471L389:LazyDsl.kt#428nma"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r37
            r2 = r11 & 1
            if (r2 == 0) goto L_0x0024
            r1 = r1 | 6
            r3 = r27
            goto L_0x0037
        L_0x0024:
            r3 = r12 & 14
            if (r3 != 0) goto L_0x0035
            r3 = r27
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0032
            r4 = 4
            goto L_0x0033
        L_0x0032:
            r4 = 2
        L_0x0033:
            r1 = r1 | r4
            goto L_0x0037
        L_0x0035:
            r3 = r27
        L_0x0037:
            r4 = r12 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0050
            r4 = r11 & 2
            if (r4 != 0) goto L_0x004a
            r4 = r28
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004c
            r5 = 32
            goto L_0x004e
        L_0x004a:
            r4 = r28
        L_0x004c:
            r5 = 16
        L_0x004e:
            r1 = r1 | r5
            goto L_0x0052
        L_0x0050:
            r4 = r28
        L_0x0052:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x005b
            r1 = r1 | 384(0x180, float:5.38E-43)
            r6 = r29
            goto L_0x0070
        L_0x005b:
            r6 = r12 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x006e
            r6 = r29
            boolean r7 = r10.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x006a
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x006c
        L_0x006a:
            r7 = 128(0x80, float:1.794E-43)
        L_0x006c:
            r1 = r1 | r7
            goto L_0x0070
        L_0x006e:
            r6 = r29
        L_0x0070:
            r7 = r11 & 8
            if (r7 == 0) goto L_0x0079
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r8 = r30
            goto L_0x008e
        L_0x0079:
            r8 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x008c
            r8 = r30
            boolean r9 = r10.changed((boolean) r8)
            if (r9 == 0) goto L_0x0088
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x008a
        L_0x0088:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x008a:
            r1 = r1 | r9
            goto L_0x008e
        L_0x008c:
            r8 = r30
        L_0x008e:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r12
            if (r9 != 0) goto L_0x00a9
            r9 = r11 & 16
            if (r9 != 0) goto L_0x00a3
            r9 = r31
            boolean r14 = r10.changed((java.lang.Object) r9)
            if (r14 == 0) goto L_0x00a5
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a7
        L_0x00a3:
            r9 = r31
        L_0x00a5:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x00a7:
            r1 = r1 | r14
            goto L_0x00ab
        L_0x00a9:
            r9 = r31
        L_0x00ab:
            r14 = r11 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x00b8
            r16 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r16
            r15 = r32
            goto L_0x00ce
        L_0x00b8:
            r16 = r12 & r15
            if (r16 != 0) goto L_0x00cc
            r15 = r32
            boolean r16 = r10.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00c7
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c9
        L_0x00c7:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c9:
            r1 = r1 | r16
            goto L_0x00ce
        L_0x00cc:
            r15 = r32
        L_0x00ce:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r17 = r12 & r16
            if (r17 != 0) goto L_0x00ea
            r17 = r11 & 64
            if (r17 != 0) goto L_0x00e3
            r0 = r33
            boolean r18 = r10.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00e5
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e7
        L_0x00e3:
            r0 = r33
        L_0x00e5:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00e7:
            r1 = r1 | r18
            goto L_0x00ec
        L_0x00ea:
            r0 = r33
        L_0x00ec:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00f7
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r18
            r3 = r34
            goto L_0x010f
        L_0x00f7:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r12 & r18
            if (r18 != 0) goto L_0x010d
            r3 = r34
            boolean r18 = r10.changed((boolean) r3)
            if (r18 == 0) goto L_0x0108
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010a
        L_0x0108:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x010a:
            r1 = r1 | r18
            goto L_0x010f
        L_0x010d:
            r3 = r34
        L_0x010f:
            r3 = r11 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0117
            r3 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x0115:
            r1 = r1 | r3
            goto L_0x0128
        L_0x0117:
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r12
            if (r3 != 0) goto L_0x0128
            boolean r3 = r10.changedInstance(r13)
            if (r3 == 0) goto L_0x0125
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0115
        L_0x0125:
            r3 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x0115
        L_0x0128:
            r3 = 191739611(0xb6db6db, float:4.5782105E-32)
            r3 = r3 & r1
            r4 = 38347922(0x2492492, float:1.4777643E-37)
            if (r3 != r4) goto L_0x0151
            boolean r3 = r10.getSkipping()
            if (r3 != 0) goto L_0x0138
            goto L_0x0151
        L_0x0138:
            r10.skipToGroupEnd()
            r18 = r27
            r19 = r28
            r24 = r33
            r25 = r34
            r17 = r1
            r20 = r6
            r21 = r8
            r22 = r9
            r26 = r10
            r23 = r15
            goto L_0x028f
        L_0x0151:
            r10.startDefaults()
            r3 = r12 & 1
            r4 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            if (r3 == 0) goto L_0x01a0
            boolean r3 = r10.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0165
            goto L_0x01a0
        L_0x0165:
            r10.skipToGroupEnd()
            r0 = r11 & 2
            if (r0 == 0) goto L_0x016e
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x016e:
            r0 = r11 & 16
            if (r0 == 0) goto L_0x0174
            r1 = r1 & r18
        L_0x0174:
            r0 = r11 & 64
            if (r0 == 0) goto L_0x018d
            r0 = r1 & r4
            r18 = r27
            r19 = r28
            r24 = r33
            r25 = r34
            r20 = r6
            r21 = r8
            r22 = r9
            r23 = r15
            r6 = r0
            goto L_0x0224
        L_0x018d:
            r18 = r27
            r19 = r28
            r24 = r33
            r25 = r34
            r20 = r6
            r21 = r8
            r22 = r9
            r23 = r15
            r6 = r1
            goto L_0x0224
        L_0x01a0:
            if (r2 == 0) goto L_0x01a7
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x01a9
        L_0x01a7:
            r2 = r27
        L_0x01a9:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x01b6
            r3 = 0
            r4 = 3
            androidx.compose.foundation.lazy.LazyListState r3 = androidx.compose.foundation.lazy.LazyListStateKt.rememberLazyListState(r3, r3, r10, r3, r4)
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x01b8
        L_0x01b6:
            r3 = r28
        L_0x01b8:
            if (r5 == 0) goto L_0x01c9
            r4 = 0
            r5 = 0
            r27 = r2
            float r2 = (float) r4
            float r2 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r2)
            androidx.compose.foundation.layout.PaddingValues r2 = androidx.compose.foundation.layout.PaddingKt.m753PaddingValues0680j_4(r2)
            r6 = r2
            goto L_0x01cb
        L_0x01c9:
            r27 = r2
        L_0x01cb:
            if (r7 == 0) goto L_0x01cf
            r2 = 0
            r8 = r2
        L_0x01cf:
            r2 = r11 & 16
            if (r2 == 0) goto L_0x01e3
            androidx.compose.foundation.layout.Arrangement r2 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            if (r8 != 0) goto L_0x01dc
            androidx.compose.foundation.layout.Arrangement$Horizontal r2 = r2.getStart()
            goto L_0x01e0
        L_0x01dc:
            androidx.compose.foundation.layout.Arrangement$Horizontal r2 = r2.getEnd()
        L_0x01e0:
            r1 = r1 & r18
            r9 = r2
        L_0x01e3:
            if (r14 == 0) goto L_0x01ec
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r2 = r2.getTop()
            r15 = r2
        L_0x01ec:
            r2 = r11 & 64
            if (r2 == 0) goto L_0x01fc
            androidx.compose.foundation.gestures.ScrollableDefaults r2 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r4 = 6
            androidx.compose.foundation.gestures.FlingBehavior r2 = r2.flingBehavior(r10, r4)
            r4 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r4
            goto L_0x01fe
        L_0x01fc:
            r2 = r33
        L_0x01fe:
            if (r0 == 0) goto L_0x0213
            r0 = 1
            r18 = r27
            r25 = r0
            r24 = r2
            r19 = r3
            r20 = r6
            r21 = r8
            r22 = r9
            r23 = r15
            r6 = r1
            goto L_0x0224
        L_0x0213:
            r18 = r27
            r25 = r34
            r24 = r2
            r19 = r3
            r20 = r6
            r21 = r8
            r22 = r9
            r23 = r15
            r6 = r1
        L_0x0224:
            r10.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0236
            r0 = -1
            java.lang.String r1 = "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:289)"
            r2 = -1724297413(0xffffffff99394f3b, float:-9.580276E-24)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r6, r0, r1)
        L_0x0236:
            r4 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r0 = r6 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r1 = r6 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r6 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r6 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r6 >> 3
            r2 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r6 >> 3
            r1 = r1 & r16
            r14 = r0 | r1
            int r0 = r6 >> 15
            r0 = r0 & 14
            int r1 = r6 >> 9
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r6 >> 18
            r1 = r1 & 896(0x380, float:1.256E-42)
            r15 = r0 | r1
            r16 = 896(0x380, float:1.256E-42)
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r5 = r24
            r17 = r6
            r6 = r25
            r26 = r10
            r10 = r23
            r11 = r22
            r12 = r35
            r13 = r26
            androidx.compose.foundation.lazy.LazyListKt.LazyList(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x028f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x028f:
            androidx.compose.runtime.ScopeUpdateScope r12 = r26.endRestartGroup()
            if (r12 != 0) goto L_0x0296
            goto L_0x02b7
        L_0x0296:
            androidx.compose.foundation.lazy.LazyDslKt$LazyRow$1 r13 = new androidx.compose.foundation.lazy.LazyDslKt$LazyRow$1
            r0 = r13
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r35
            r10 = r37
            r11 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x02b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyRow(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyColumn(androidx.compose.ui.Modifier r27, androidx.compose.foundation.lazy.LazyListState r28, androidx.compose.foundation.layout.PaddingValues r29, boolean r30, androidx.compose.foundation.layout.Arrangement.Vertical r31, androidx.compose.ui.Alignment.Horizontal r32, androidx.compose.foundation.gestures.FlingBehavior r33, boolean r34, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r13 = r35
            r12 = r37
            r9 = r38
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -740714857(0xffffffffd3d99697, float:-1.86906876E12)
            r1 = r36
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LazyColumn)P(4,6,1,5,8,3,2,7)347@16950L23,353@17304L15,357@17406L388:LazyDsl.kt#428nma"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r37
            r2 = r9 & 1
            if (r2 == 0) goto L_0x0024
            r1 = r1 | 6
            r3 = r27
            goto L_0x0037
        L_0x0024:
            r3 = r12 & 14
            if (r3 != 0) goto L_0x0035
            r3 = r27
            boolean r4 = r8.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0032
            r4 = 4
            goto L_0x0033
        L_0x0032:
            r4 = 2
        L_0x0033:
            r1 = r1 | r4
            goto L_0x0037
        L_0x0035:
            r3 = r27
        L_0x0037:
            r4 = r12 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0050
            r4 = r9 & 2
            if (r4 != 0) goto L_0x004a
            r4 = r28
            boolean r5 = r8.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004c
            r5 = 32
            goto L_0x004e
        L_0x004a:
            r4 = r28
        L_0x004c:
            r5 = 16
        L_0x004e:
            r1 = r1 | r5
            goto L_0x0052
        L_0x0050:
            r4 = r28
        L_0x0052:
            r5 = r9 & 4
            if (r5 == 0) goto L_0x005b
            r1 = r1 | 384(0x180, float:5.38E-43)
            r6 = r29
            goto L_0x0070
        L_0x005b:
            r6 = r12 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x006e
            r6 = r29
            boolean r7 = r8.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x006a
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x006c
        L_0x006a:
            r7 = 128(0x80, float:1.794E-43)
        L_0x006c:
            r1 = r1 | r7
            goto L_0x0070
        L_0x006e:
            r6 = r29
        L_0x0070:
            r7 = r9 & 8
            if (r7 == 0) goto L_0x0079
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r10 = r30
            goto L_0x008e
        L_0x0079:
            r10 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x008c
            r10 = r30
            boolean r11 = r8.changed((boolean) r10)
            if (r11 == 0) goto L_0x0088
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x008a
        L_0x0088:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x008a:
            r1 = r1 | r11
            goto L_0x008e
        L_0x008c:
            r10 = r30
        L_0x008e:
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r12
            if (r11 != 0) goto L_0x00a9
            r11 = r9 & 16
            if (r11 != 0) goto L_0x00a3
            r11 = r31
            boolean r14 = r8.changed((java.lang.Object) r11)
            if (r14 == 0) goto L_0x00a5
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a7
        L_0x00a3:
            r11 = r31
        L_0x00a5:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x00a7:
            r1 = r1 | r14
            goto L_0x00ab
        L_0x00a9:
            r11 = r31
        L_0x00ab:
            r14 = r9 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x00b8
            r16 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r16
            r15 = r32
            goto L_0x00ce
        L_0x00b8:
            r16 = r12 & r15
            if (r16 != 0) goto L_0x00cc
            r15 = r32
            boolean r16 = r8.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00c7
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c9
        L_0x00c7:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c9:
            r1 = r1 | r16
            goto L_0x00ce
        L_0x00cc:
            r15 = r32
        L_0x00ce:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r17 = r12 & r16
            if (r17 != 0) goto L_0x00ea
            r17 = r9 & 64
            if (r17 != 0) goto L_0x00e3
            r0 = r33
            boolean r18 = r8.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00e5
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e7
        L_0x00e3:
            r0 = r33
        L_0x00e5:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00e7:
            r1 = r1 | r18
            goto L_0x00ec
        L_0x00ea:
            r0 = r33
        L_0x00ec:
            r0 = r9 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00f7
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r18
            r3 = r34
            goto L_0x010f
        L_0x00f7:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r12 & r18
            if (r18 != 0) goto L_0x010d
            r3 = r34
            boolean r18 = r8.changed((boolean) r3)
            if (r18 == 0) goto L_0x0108
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010a
        L_0x0108:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x010a:
            r1 = r1 | r18
            goto L_0x010f
        L_0x010d:
            r3 = r34
        L_0x010f:
            r3 = r9 & 256(0x100, float:3.59E-43)
            r18 = 234881024(0xe000000, float:1.5777218E-30)
            if (r3 == 0) goto L_0x0119
            r3 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x0117:
            r1 = r1 | r3
            goto L_0x0129
        L_0x0119:
            r3 = r12 & r18
            if (r3 != 0) goto L_0x0129
            boolean r3 = r8.changedInstance(r13)
            if (r3 == 0) goto L_0x0126
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0117
        L_0x0126:
            r3 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x0117
        L_0x0129:
            r3 = 191739611(0xb6db6db, float:4.5782105E-32)
            r3 = r3 & r1
            r4 = 38347922(0x2492492, float:1.4777643E-37)
            if (r3 != r4) goto L_0x0152
            boolean r3 = r8.getSkipping()
            if (r3 != 0) goto L_0x0139
            goto L_0x0152
        L_0x0139:
            r8.skipToGroupEnd()
            r19 = r27
            r20 = r28
            r25 = r33
            r26 = r34
            r17 = r1
            r21 = r6
            r18 = r8
            r22 = r10
            r23 = r11
            r24 = r15
            goto L_0x028f
        L_0x0152:
            r8.startDefaults()
            r3 = r12 & 1
            r4 = -3670017(0xffffffffffc7ffff, float:NaN)
            r19 = -57345(0xffffffffffff1fff, float:NaN)
            if (r3 == 0) goto L_0x01a1
            boolean r3 = r8.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0166
            goto L_0x01a1
        L_0x0166:
            r8.skipToGroupEnd()
            r0 = r9 & 2
            if (r0 == 0) goto L_0x016f
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x016f:
            r0 = r9 & 16
            if (r0 == 0) goto L_0x0175
            r1 = r1 & r19
        L_0x0175:
            r0 = r9 & 64
            if (r0 == 0) goto L_0x018e
            r0 = r1 & r4
            r19 = r27
            r20 = r28
            r25 = r33
            r26 = r34
            r21 = r6
            r22 = r10
            r23 = r11
            r24 = r15
            r6 = r0
            goto L_0x0225
        L_0x018e:
            r19 = r27
            r20 = r28
            r25 = r33
            r26 = r34
            r21 = r6
            r22 = r10
            r23 = r11
            r24 = r15
            r6 = r1
            goto L_0x0225
        L_0x01a1:
            if (r2 == 0) goto L_0x01a8
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x01aa
        L_0x01a8:
            r2 = r27
        L_0x01aa:
            r3 = r9 & 2
            if (r3 == 0) goto L_0x01b7
            r3 = 0
            r4 = 3
            androidx.compose.foundation.lazy.LazyListState r3 = androidx.compose.foundation.lazy.LazyListStateKt.rememberLazyListState(r3, r3, r8, r3, r4)
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x01b9
        L_0x01b7:
            r3 = r28
        L_0x01b9:
            if (r5 == 0) goto L_0x01ca
            r4 = 0
            r5 = 0
            r27 = r2
            float r2 = (float) r4
            float r2 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r2)
            androidx.compose.foundation.layout.PaddingValues r2 = androidx.compose.foundation.layout.PaddingKt.m753PaddingValues0680j_4(r2)
            r6 = r2
            goto L_0x01cc
        L_0x01ca:
            r27 = r2
        L_0x01cc:
            if (r7 == 0) goto L_0x01d0
            r2 = 0
            r10 = r2
        L_0x01d0:
            r2 = r9 & 16
            if (r2 == 0) goto L_0x01e4
            androidx.compose.foundation.layout.Arrangement r2 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            if (r10 != 0) goto L_0x01dd
            androidx.compose.foundation.layout.Arrangement$Vertical r2 = r2.getTop()
            goto L_0x01e1
        L_0x01dd:
            androidx.compose.foundation.layout.Arrangement$Vertical r2 = r2.getBottom()
        L_0x01e1:
            r1 = r1 & r19
            r11 = r2
        L_0x01e4:
            if (r14 == 0) goto L_0x01ed
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r2 = r2.getStart()
            r15 = r2
        L_0x01ed:
            r2 = r9 & 64
            if (r2 == 0) goto L_0x01fd
            androidx.compose.foundation.gestures.ScrollableDefaults r2 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r4 = 6
            androidx.compose.foundation.gestures.FlingBehavior r2 = r2.flingBehavior(r8, r4)
            r4 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r4
            goto L_0x01ff
        L_0x01fd:
            r2 = r33
        L_0x01ff:
            if (r0 == 0) goto L_0x0214
            r0 = 1
            r19 = r27
            r26 = r0
            r25 = r2
            r20 = r3
            r21 = r6
            r22 = r10
            r23 = r11
            r24 = r15
            r6 = r1
            goto L_0x0225
        L_0x0214:
            r19 = r27
            r26 = r34
            r25 = r2
            r20 = r3
            r21 = r6
            r22 = r10
            r23 = r11
            r24 = r15
            r6 = r1
        L_0x0225:
            r8.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0237
            r0 = -1
            java.lang.String r1 = "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:345)"
            r2 = -740714857(0xffffffffd3d99697, float:-1.86906876E12)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r6, r0, r1)
        L_0x0237:
            r4 = 1
            r7 = 0
            r10 = 0
            r11 = 0
            r0 = r6 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r1 = r6 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r6 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r6 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r6 >> 3
            r2 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r6 >> 3
            r1 = r1 & r16
            r0 = r0 | r1
            int r1 = r6 << 9
            r1 = r1 & r18
            r0 = r0 | r1
            int r1 = r6 << 15
            r2 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r2
            r14 = r0 | r1
            int r0 = r6 >> 18
            r15 = r0 & 896(0x380, float:1.256E-42)
            r16 = 3200(0xc80, float:4.484E-42)
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r5 = r25
            r17 = r6
            r6 = r26
            r18 = r8
            r8 = r24
            r9 = r23
            r12 = r35
            r13 = r18
            androidx.compose.foundation.lazy.LazyListKt.LazyList(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x028f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x028f:
            androidx.compose.runtime.ScopeUpdateScope r12 = r18.endRestartGroup()
            if (r12 != 0) goto L_0x0296
            goto L_0x02b7
        L_0x0296:
            androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1 r13 = new androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
            r0 = r13
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r24
            r7 = r25
            r8 = r26
            r9 = r35
            r10 = r37
            r11 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x02b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ void LazyColumn(Modifier modifier, LazyListState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Vertical verticalArrangement, Alignment.Horizontal horizontalAlignment, FlingBehavior flingBehavior, Function1 content, Composer $composer, int $changed, int i) {
        LazyListState lazyListState;
        PaddingValues contentPadding2;
        boolean reverseLayout2;
        Arrangement.Vertical verticalArrangement2;
        Alignment.Horizontal horizontalAlignment2;
        FlingBehavior flingBehavior2;
        Alignment.Horizontal horizontalAlignment3;
        Arrangement.Vertical verticalArrangement3;
        boolean reverseLayout3;
        PaddingValues contentPadding3;
        LazyListState state2;
        Modifier modifier2;
        int $dirty;
        Modifier modifier3;
        LazyListState state3;
        int i2;
        int i3;
        int i4;
        Function1 function1 = content;
        int i5 = $changed;
        int i6 = i;
        Intrinsics.checkNotNullParameter(function1, "content");
        Composer $composer2 = $composer.startRestartGroup(-563353797);
        ComposerKt.sourceInformation($composer2, "C(LazyColumn)P(4,6,1,5,7,3,2)375@17968L23,381@18322L15,384@18385L350:LazyDsl.kt#428nma");
        int $dirty2 = $changed;
        int i7 = i6 & 1;
        if (i7 != 0) {
            $dirty2 |= 6;
            Modifier modifier4 = modifier;
        } else if ((i5 & 14) == 0) {
            $dirty2 |= $composer2.changed((Object) modifier) ? 4 : 2;
        } else {
            Modifier modifier5 = modifier;
        }
        if ((i5 & 112) == 0) {
            if ((i6 & 2) == 0) {
                lazyListState = state;
                if ($composer2.changed((Object) lazyListState)) {
                    i4 = 32;
                    $dirty2 |= i4;
                }
            } else {
                lazyListState = state;
            }
            i4 = 16;
            $dirty2 |= i4;
        } else {
            lazyListState = state;
        }
        int i8 = i6 & 4;
        if (i8 != 0) {
            $dirty2 |= 384;
            contentPadding2 = contentPadding;
        } else if ((i5 & 896) == 0) {
            contentPadding2 = contentPadding;
            $dirty2 |= $composer2.changed((Object) contentPadding2) ? 256 : 128;
        } else {
            contentPadding2 = contentPadding;
        }
        int i9 = i6 & 8;
        if (i9 != 0) {
            $dirty2 |= 3072;
            reverseLayout2 = reverseLayout;
        } else if ((i5 & 7168) == 0) {
            reverseLayout2 = reverseLayout;
            $dirty2 |= $composer2.changed(reverseLayout2) ? 2048 : 1024;
        } else {
            reverseLayout2 = reverseLayout;
        }
        if ((i5 & 57344) == 0) {
            if ((i6 & 16) == 0) {
                verticalArrangement2 = verticalArrangement;
                if ($composer2.changed((Object) verticalArrangement2)) {
                    i3 = 16384;
                    $dirty2 |= i3;
                }
            } else {
                verticalArrangement2 = verticalArrangement;
            }
            i3 = 8192;
            $dirty2 |= i3;
        } else {
            verticalArrangement2 = verticalArrangement;
        }
        int i10 = i6 & 32;
        if (i10 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            horizontalAlignment2 = horizontalAlignment;
        } else if ((i5 & 458752) == 0) {
            horizontalAlignment2 = horizontalAlignment;
            $dirty2 |= $composer2.changed((Object) horizontalAlignment2) ? 131072 : 65536;
        } else {
            horizontalAlignment2 = horizontalAlignment;
        }
        if ((i5 & 3670016) == 0) {
            if ((i6 & 64) != 0) {
                FlingBehavior flingBehavior3 = flingBehavior;
            } else if ($composer2.changed((Object) flingBehavior)) {
                i2 = 1048576;
                $dirty2 |= i2;
            }
            i2 = 524288;
            $dirty2 |= i2;
        } else {
            FlingBehavior flingBehavior4 = flingBehavior;
        }
        if ((i6 & 128) != 0) {
            $dirty2 |= 12582912;
        } else if ((29360128 & i5) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 8388608 : 4194304;
        }
        if ((23967451 & $dirty2) != 4793490 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i5 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if ((i6 & 2) != 0) {
                    state3 = LazyListStateKt.rememberLazyListState(0, 0, $composer2, 0, 3);
                    $dirty2 &= -113;
                } else {
                    state3 = lazyListState;
                }
                if (i8 != 0) {
                    contentPadding2 = PaddingKt.m753PaddingValues0680j_4(Dp.m5986constructorimpl((float) 0));
                }
                if (i9 != 0) {
                    reverseLayout2 = false;
                }
                if ((i6 & 16) != 0) {
                    Arrangement arrangement = Arrangement.INSTANCE;
                    $dirty2 &= -57345;
                    verticalArrangement2 = !reverseLayout2 ? arrangement.getTop() : arrangement.getBottom();
                }
                if (i10 != 0) {
                    horizontalAlignment2 = Alignment.Companion.getStart();
                }
                if ((i6 & 64) != 0) {
                    modifier2 = modifier3;
                    $dirty = $dirty2 & -3670017;
                    state2 = state3;
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior($composer2, 6);
                    contentPadding3 = contentPadding2;
                    reverseLayout3 = reverseLayout2;
                    horizontalAlignment3 = horizontalAlignment2;
                    verticalArrangement3 = verticalArrangement2;
                } else {
                    flingBehavior2 = flingBehavior;
                    modifier2 = modifier3;
                    $dirty = $dirty2;
                    state2 = state3;
                    contentPadding3 = contentPadding2;
                    reverseLayout3 = reverseLayout2;
                    horizontalAlignment3 = horizontalAlignment2;
                    verticalArrangement3 = verticalArrangement2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i6 & 2) != 0) {
                    $dirty2 &= -113;
                }
                if ((i6 & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i6 & 64) != 0) {
                    modifier2 = modifier;
                    flingBehavior2 = flingBehavior;
                    $dirty = $dirty2 & -3670017;
                    state2 = lazyListState;
                    contentPadding3 = contentPadding2;
                    reverseLayout3 = reverseLayout2;
                    horizontalAlignment3 = horizontalAlignment2;
                    verticalArrangement3 = verticalArrangement2;
                } else {
                    modifier2 = modifier;
                    flingBehavior2 = flingBehavior;
                    $dirty = $dirty2;
                    state2 = lazyListState;
                    contentPadding3 = contentPadding2;
                    reverseLayout3 = reverseLayout2;
                    horizontalAlignment3 = horizontalAlignment2;
                    verticalArrangement3 = verticalArrangement2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-563353797, $dirty, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:373)");
            }
            int i11 = $dirty;
            LazyColumn(modifier2, state2, contentPadding3, reverseLayout3, verticalArrangement3, horizontalAlignment3, flingBehavior2, true, content, $composer2, ($dirty & 14) | 12582912 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | ($dirty & 458752) | ($dirty & 3670016) | (($dirty << 3) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            flingBehavior2 = flingBehavior;
            int i12 = $dirty2;
            state2 = lazyListState;
            contentPadding3 = contentPadding2;
            reverseLayout3 = reverseLayout2;
            horizontalAlignment3 = horizontalAlignment2;
            verticalArrangement3 = verticalArrangement2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyDslKt$LazyColumn$2(modifier2, state2, contentPadding3, reverseLayout3, verticalArrangement3, horizontalAlignment3, flingBehavior2, content, $changed, i));
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ void LazyRow(Modifier modifier, LazyListState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Horizontal horizontalArrangement, Alignment.Vertical verticalAlignment, FlingBehavior flingBehavior, Function1 content, Composer $composer, int $changed, int i) {
        LazyListState lazyListState;
        PaddingValues contentPadding2;
        boolean reverseLayout2;
        Arrangement.Horizontal horizontalArrangement2;
        Alignment.Vertical verticalAlignment2;
        FlingBehavior flingBehavior2;
        Alignment.Vertical verticalAlignment3;
        Arrangement.Horizontal horizontalArrangement3;
        boolean reverseLayout3;
        PaddingValues contentPadding3;
        LazyListState state2;
        Modifier modifier2;
        int $dirty;
        Modifier modifier3;
        LazyListState state3;
        int i2;
        int i3;
        int i4;
        Function1 function1 = content;
        int i5 = $changed;
        int i6 = i;
        Intrinsics.checkNotNullParameter(function1, "content");
        Composer $composer2 = $composer.startRestartGroup(407929823);
        ComposerKt.sourceInformation($composer2, "C(LazyRow)P(4,6,1,5,3,7,2)401@18906L23,407@19257L15,410@19320L347:LazyDsl.kt#428nma");
        int $dirty2 = $changed;
        int i7 = i6 & 1;
        if (i7 != 0) {
            $dirty2 |= 6;
            Modifier modifier4 = modifier;
        } else if ((i5 & 14) == 0) {
            $dirty2 |= $composer2.changed((Object) modifier) ? 4 : 2;
        } else {
            Modifier modifier5 = modifier;
        }
        if ((i5 & 112) == 0) {
            if ((i6 & 2) == 0) {
                lazyListState = state;
                if ($composer2.changed((Object) lazyListState)) {
                    i4 = 32;
                    $dirty2 |= i4;
                }
            } else {
                lazyListState = state;
            }
            i4 = 16;
            $dirty2 |= i4;
        } else {
            lazyListState = state;
        }
        int i8 = i6 & 4;
        if (i8 != 0) {
            $dirty2 |= 384;
            contentPadding2 = contentPadding;
        } else if ((i5 & 896) == 0) {
            contentPadding2 = contentPadding;
            $dirty2 |= $composer2.changed((Object) contentPadding2) ? 256 : 128;
        } else {
            contentPadding2 = contentPadding;
        }
        int i9 = i6 & 8;
        if (i9 != 0) {
            $dirty2 |= 3072;
            reverseLayout2 = reverseLayout;
        } else if ((i5 & 7168) == 0) {
            reverseLayout2 = reverseLayout;
            $dirty2 |= $composer2.changed(reverseLayout2) ? 2048 : 1024;
        } else {
            reverseLayout2 = reverseLayout;
        }
        if ((i5 & 57344) == 0) {
            if ((i6 & 16) == 0) {
                horizontalArrangement2 = horizontalArrangement;
                if ($composer2.changed((Object) horizontalArrangement2)) {
                    i3 = 16384;
                    $dirty2 |= i3;
                }
            } else {
                horizontalArrangement2 = horizontalArrangement;
            }
            i3 = 8192;
            $dirty2 |= i3;
        } else {
            horizontalArrangement2 = horizontalArrangement;
        }
        int i10 = i6 & 32;
        if (i10 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            verticalAlignment2 = verticalAlignment;
        } else if ((i5 & 458752) == 0) {
            verticalAlignment2 = verticalAlignment;
            $dirty2 |= $composer2.changed((Object) verticalAlignment2) ? 131072 : 65536;
        } else {
            verticalAlignment2 = verticalAlignment;
        }
        if ((i5 & 3670016) == 0) {
            if ((i6 & 64) != 0) {
                FlingBehavior flingBehavior3 = flingBehavior;
            } else if ($composer2.changed((Object) flingBehavior)) {
                i2 = 1048576;
                $dirty2 |= i2;
            }
            i2 = 524288;
            $dirty2 |= i2;
        } else {
            FlingBehavior flingBehavior4 = flingBehavior;
        }
        if ((i6 & 128) != 0) {
            $dirty2 |= 12582912;
        } else if ((29360128 & i5) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 8388608 : 4194304;
        }
        if ((23967451 & $dirty2) != 4793490 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i5 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if ((i6 & 2) != 0) {
                    state3 = LazyListStateKt.rememberLazyListState(0, 0, $composer2, 0, 3);
                    $dirty2 &= -113;
                } else {
                    state3 = lazyListState;
                }
                if (i8 != 0) {
                    contentPadding2 = PaddingKt.m753PaddingValues0680j_4(Dp.m5986constructorimpl((float) 0));
                }
                if (i9 != 0) {
                    reverseLayout2 = false;
                }
                if ((i6 & 16) != 0) {
                    Arrangement arrangement = Arrangement.INSTANCE;
                    $dirty2 &= -57345;
                    horizontalArrangement2 = !reverseLayout2 ? arrangement.getStart() : arrangement.getEnd();
                }
                if (i10 != 0) {
                    verticalAlignment2 = Alignment.Companion.getTop();
                }
                if ((i6 & 64) != 0) {
                    modifier2 = modifier3;
                    $dirty = $dirty2 & -3670017;
                    state2 = state3;
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior($composer2, 6);
                    contentPadding3 = contentPadding2;
                    reverseLayout3 = reverseLayout2;
                    verticalAlignment3 = verticalAlignment2;
                    horizontalArrangement3 = horizontalArrangement2;
                } else {
                    flingBehavior2 = flingBehavior;
                    modifier2 = modifier3;
                    $dirty = $dirty2;
                    state2 = state3;
                    contentPadding3 = contentPadding2;
                    reverseLayout3 = reverseLayout2;
                    verticalAlignment3 = verticalAlignment2;
                    horizontalArrangement3 = horizontalArrangement2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i6 & 2) != 0) {
                    $dirty2 &= -113;
                }
                if ((i6 & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i6 & 64) != 0) {
                    modifier2 = modifier;
                    flingBehavior2 = flingBehavior;
                    $dirty = $dirty2 & -3670017;
                    state2 = lazyListState;
                    contentPadding3 = contentPadding2;
                    reverseLayout3 = reverseLayout2;
                    verticalAlignment3 = verticalAlignment2;
                    horizontalArrangement3 = horizontalArrangement2;
                } else {
                    modifier2 = modifier;
                    flingBehavior2 = flingBehavior;
                    $dirty = $dirty2;
                    state2 = lazyListState;
                    contentPadding3 = contentPadding2;
                    reverseLayout3 = reverseLayout2;
                    verticalAlignment3 = verticalAlignment2;
                    horizontalArrangement3 = horizontalArrangement2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(407929823, $dirty, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:399)");
            }
            int i11 = $dirty;
            LazyRow(modifier2, state2, contentPadding3, reverseLayout3, horizontalArrangement3, verticalAlignment3, flingBehavior2, true, content, $composer2, ($dirty & 14) | 12582912 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | ($dirty & 458752) | ($dirty & 3670016) | (($dirty << 3) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            flingBehavior2 = flingBehavior;
            int i12 = $dirty2;
            state2 = lazyListState;
            contentPadding3 = contentPadding2;
            reverseLayout3 = reverseLayout2;
            verticalAlignment3 = verticalAlignment2;
            horizontalArrangement3 = horizontalArrangement2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyDslKt$LazyRow$2(modifier2, state2, contentPadding3, reverseLayout3, horizontalArrangement3, verticalAlignment3, flingBehavior2, content, $changed, i));
        }
    }
}
