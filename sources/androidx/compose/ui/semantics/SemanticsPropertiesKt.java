package androidx.compose.ui.semantics;

import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010u\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hx0w0v\"\u000e\b\u0000\u0010x*\b\u0012\u0004\u0012\u00020'0y2\u0006\u0010z\u001a\u00020\u0012H\b\u001a\u0013\u0010{\u001a\u0002Hx\"\u0004\b\u0000\u0010xH\u0002¢\u0006\u0002\u0010|\u001a(\u0010}\u001a\u00020~*\u00020\u00032\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020'\u0018\u00010\u0001\u001a)\u0010\u0001\u001a\u00020~*\u00020\u00032\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020'\u0018\u00010\u0001\u001a)\u0010\u0001\u001a\u00020~*\u00020\u00032\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020'\u0018\u00010\u0001\u001a\u000b\u0010\u0001\u001a\u00020~*\u00020\u0003\u001a\u000b\u0010\u0001\u001a\u00020~*\u00020\u0003\u001a)\u0010\u0001\u001a\u00020~*\u00020\u00032\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020'\u0018\u00010\u0001\u001a\u0014\u0010\u0001\u001a\u00020~*\u00020\u00032\u0007\u0010\u0001\u001a\u00020\u0012\u001a)\u0010\u0001\u001a\u00020~*\u00020\u00032\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020'\u0018\u00010\u0001\u001a7\u0010\u0001\u001a\u00020~*\u00020\u00032\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u00122\u001e\u0010\u0001\u001a\u0019\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00010\u0001\u0012\u0004\u0012\u00020'\u0018\u00010\u0001\u001a\u000b\u0010\u0001\u001a\u00020~*\u00020\u0003\u001a#\u0010\u0001\u001a\u00020~*\u00020\u00032\u0016\u0010\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u0001\u0012\u0005\u0012\u00030\u00010\u0001\u001a\r\u0010\u0001\u001a\u00020~*\u00020\u0003H\u0007\u001a)\u0010\u0001\u001a\u00020~*\u00020\u00032\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020'\u0018\u00010\u0001\u001a)\u0010\u0001\u001a\u00020~*\u00020\u00032\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020'\u0018\u00010\u0001\u001a)\u0010\u0001\u001a\u00020~*\u00020\u00032\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020'\u0018\u00010\u0001\u001a)\u0010\u0001\u001a\u00020~*\u00020\u00032\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020'\u0018\u00010\u0001\u001a)\u0010\u0001\u001a\u00020~*\u00020\u00032\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020'\u0018\u00010\u0001\u001a)\u0010\u0001\u001a\u00020~*\u00020\u00032\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020'\u0018\u00010\u0001\u001a\u000b\u0010\u0001\u001a\u00020~*\u00020\u0003\u001a)\u0010\u0001\u001a\u00020~*\u00020\u00032\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020'\u0018\u00010\u0001\u001a\u000b\u0010\u0001\u001a\u00020~*\u00020\u0003\u001a)\u0010\u0001\u001a\u00020~*\u00020\u00032\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020'\u0018\u00010\u0001\u001aY\u0010\u0001\u001a\u00020~*\u00020\u00032\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u00122@\u0010\u0001\u001a;\u0012\u0016\u0012\u00140 \u0001¢\u0006\u000e\b¡\u0001\u0012\t\bz\u0012\u0005\b\b(¢\u0001\u0012\u0016\u0012\u00140 \u0001¢\u0006\u000e\b¡\u0001\u0012\t\bz\u0012\u0005\b\b(£\u0001\u0012\u0004\u0012\u00020'\u0018\u00010\u0001\u001a.\u0010¤\u0001\u001a\u00020~*\u00020\u00032\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u00122\u0015\u0010\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020'0\u0001\u001a\u000b\u0010¥\u0001\u001a\u00020~*\u00020\u0003\u001a0\u0010¦\u0001\u001a\u00020~*\u00020\u00032\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u00122\u0017\u0010\u0001\u001a\u0012\u0012\u0005\u0012\u00030 \u0001\u0012\u0004\u0012\u00020'\u0018\u00010\u0001\u001ap\u0010§\u0001\u001a\u00020~*\u00020\u00032\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u00122W\u0010\u0001\u001aR\u0012\u0016\u0012\u00140\u0001¢\u0006\u000e\b¡\u0001\u0012\t\bz\u0012\u0005\b\b(©\u0001\u0012\u0016\u0012\u00140\u0001¢\u0006\u000e\b¡\u0001\u0012\t\bz\u0012\u0005\b\b(ª\u0001\u0012\u0015\u0012\u00130'¢\u0006\u000e\b¡\u0001\u0012\t\bz\u0012\u0005\b\b(«\u0001\u0012\u0004\u0012\u00020'\u0018\u00010¨\u0001\u001a.\u0010b\u001a\u00020~*\u00020\u00032\n\b\u0002\u0010\u001a\u0004\u0018\u00010\u00122\u0016\u0010\u0001\u001a\u0011\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020'\u0018\u00010\u0001\"/\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0002¢\u0006\u0012\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t*\u0004\b\u0004\u0010\u0005\"/\u0010\u000b\u001a\u00020\n*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\n8F@FX\u0002¢\u0006\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010*\u0004\b\f\u0010\u0005\"(\u0010\u0013\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00128F@FX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\";\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018*\u00020\u00032\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188F@FX\u0002¢\u0006\u0012\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f*\u0004\b\u001b\u0010\u0005\"/\u0010!\u001a\u00020 *\u00020\u00032\u0006\u0010\u0000\u001a\u00020 8F@FX\u0002¢\u0006\u0012\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&*\u0004\b\"\u0010\u0005\"/\u0010(\u001a\u00020'*\u00020\u00032\u0006\u0010\u0000\u001a\u00020'8F@FX\u0002¢\u0006\u0012\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-*\u0004\b)\u0010\u0005\"/\u0010/\u001a\u00020.*\u00020\u00032\u0006\u0010\u0000\u001a\u00020.8F@FX\u0002¢\u0006\u0012\u001a\u0004\b1\u00102\"\u0004\b3\u00104*\u0004\b0\u0010\u0005\"2\u00106\u001a\u000205*\u00020\u00032\u0006\u0010\u0000\u001a\u0002058F@FX\u0002ø\u0001\u0000¢\u0006\u0012\u001a\u0004\b8\u00109\"\u0004\b:\u0010;*\u0004\b7\u0010\u0005\"/\u0010<\u001a\u00020'*\u00020\u00032\u0006\u0010\u0000\u001a\u00020'8F@FX\u0002¢\u0006\u0012\u001a\u0004\b<\u0010+\"\u0004\b>\u0010-*\u0004\b=\u0010\u0005\"2\u0010@\u001a\u00020?*\u00020\u00032\u0006\u0010\u0000\u001a\u00020?8F@FX\u0002ø\u0001\u0000¢\u0006\u0012\u001a\u0004\bB\u00109\"\u0004\bC\u0010;*\u0004\bA\u0010\u0005\"/\u0010D\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00128F@FX\u0002¢\u0006\u0012\u001a\u0004\bF\u0010\u0015\"\u0004\bG\u0010\u0017*\u0004\bE\u0010\u0005\"/\u0010I\u001a\u00020H*\u00020\u00032\u0006\u0010\u0000\u001a\u00020H8F@FX\u0002¢\u0006\u0012\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N*\u0004\bJ\u0010\u0005\"2\u0010P\u001a\u00020O*\u00020\u00032\u0006\u0010\u0000\u001a\u00020O8F@FX\u0002ø\u0001\u0000¢\u0006\u0012\u001a\u0004\bR\u00109\"\u0004\bS\u0010;*\u0004\bQ\u0010\u0005\"/\u0010T\u001a\u00020'*\u00020\u00032\u0006\u0010\u0000\u001a\u00020'8F@FX\u0002¢\u0006\u0012\u001a\u0004\bV\u0010+\"\u0004\bW\u0010-*\u0004\bU\u0010\u0005\"/\u0010X\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00128F@FX\u0002¢\u0006\u0012\u001a\u0004\bZ\u0010\u0015\"\u0004\b[\u0010\u0017*\u0004\bY\u0010\u0005\"/\u0010\\\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00128F@FX\u0002¢\u0006\u0012\u001a\u0004\b^\u0010\u0015\"\u0004\b_\u0010\u0017*\u0004\b]\u0010\u0005\"(\u0010`\u001a\u00020 *\u00020\u00032\u0006\u0010\u0011\u001a\u00020 8F@FX\u000e¢\u0006\f\u001a\u0004\ba\u0010$\"\u0004\bb\u0010&\"2\u0010d\u001a\u00020c*\u00020\u00032\u0006\u0010\u0000\u001a\u00020c8F@FX\u0002ø\u0001\u0000¢\u0006\u0012\u001a\u0004\bf\u0010g\"\u0004\bh\u0010i*\u0004\be\u0010\u0005\"/\u0010k\u001a\u00020j*\u00020\u00032\u0006\u0010\u0000\u001a\u00020j8F@FX\u0002¢\u0006\u0012\u001a\u0004\bm\u0010n\"\u0004\bo\u0010p*\u0004\bl\u0010\u0005\"/\u0010q\u001a\u00020.*\u00020\u00032\u0006\u0010\u0000\u001a\u00020.8F@FX\u0002¢\u0006\u0012\u001a\u0004\bs\u00102\"\u0004\bt\u00104*\u0004\br\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006¬\u0001"}, d2 = {"<set-?>", "Landroidx/compose/ui/semantics/CollectionInfo;", "collectionInfo", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "getCollectionInfo$delegate", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/Object;", "getCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", "setCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/CollectionInfo;)V", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "collectionItemInfo", "getCollectionItemInfo$delegate", "getCollectionItemInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", "setCollectionItemInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/CollectionItemInfo;)V", "value", "", "contentDescription", "getContentDescription", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", "setContentDescription", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;)V", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "customActions", "getCustomActions$delegate", "getCustomActions", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", "setCustomActions", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/util/List;)V", "Landroidx/compose/ui/text/AnnotatedString;", "editableText", "getEditableText$delegate", "getEditableText", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", "setEditableText", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/text/AnnotatedString;)V", "", "focused", "getFocused$delegate", "getFocused", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", "setFocused", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Z)V", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "horizontalScrollAxisRange", "getHorizontalScrollAxisRange$delegate", "getHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", "setHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/ScrollAxisRange;)V", "Landroidx/compose/ui/text/input/ImeAction;", "imeAction", "getImeAction$delegate", "getImeAction", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", "setImeAction-4L7nppU", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;I)V", "isContainer", "isContainer$delegate", "setContainer", "Landroidx/compose/ui/semantics/LiveRegionMode;", "liveRegion", "getLiveRegion$delegate", "getLiveRegion", "setLiveRegion-hR3wRGc", "paneTitle", "getPaneTitle$delegate", "getPaneTitle", "setPaneTitle", "Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "progressBarRangeInfo", "getProgressBarRangeInfo$delegate", "getProgressBarRangeInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "setProgressBarRangeInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/ProgressBarRangeInfo;)V", "Landroidx/compose/ui/semantics/Role;", "role", "getRole$delegate", "getRole", "setRole-kuIjeqM", "selected", "getSelected$delegate", "getSelected", "setSelected", "stateDescription", "getStateDescription$delegate", "getStateDescription", "setStateDescription", "testTag", "getTestTag$delegate", "getTestTag", "setTestTag", "text", "getText", "setText", "Landroidx/compose/ui/text/TextRange;", "textSelectionRange", "getTextSelectionRange$delegate", "getTextSelectionRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", "setTextSelectionRange-FDrldGo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;J)V", "Landroidx/compose/ui/state/ToggleableState;", "toggleableState", "getToggleableState$delegate", "getToggleableState", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", "setToggleableState", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/state/ToggleableState;)V", "verticalScrollAxisRange", "getVerticalScrollAxisRange$delegate", "getVerticalScrollAxisRange", "setVerticalScrollAxisRange", "ActionPropertyKey", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/semantics/AccessibilityAction;", "T", "Lkotlin/Function;", "name", "throwSemanticsGetNotSupported", "()Ljava/lang/Object;", "collapse", "", "label", "action", "Lkotlin/Function0;", "copyText", "cutText", "dialog", "disabled", "dismiss", "error", "description", "expand", "getTextLayoutResult", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "heading", "indexForKey", "mapping", "", "", "invisibleToUser", "onClick", "onLongClick", "pageDown", "pageLeft", "pageRight", "pageUp", "password", "pasteText", "popup", "requestFocus", "scrollBy", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "x", "y", "scrollToIndex", "selectableGroup", "setProgress", "setSelection", "Lkotlin/Function3;", "startIndex", "endIndex", "relativeToOriginalText", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SemanticsProperties.kt */
public final class SemanticsPropertiesKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;

    /* access modifiers changed from: private */
    public static final <T> T throwSemanticsGetNotSupported() {
        throw new UnsupportedOperationException("You cannot retrieve a semantics property directly - use one of the SemanticsConfiguration.getOr* methods instead");
    }

    private static final <T extends Function<? extends Boolean>> SemanticsPropertyKey<AccessibilityAction<T>> ActionPropertyKey(String name) {
        return new SemanticsPropertyKey<>(name, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE);
    }

    public static final String getContentDescription(SemanticsPropertyReceiver $this$contentDescription) {
        Intrinsics.checkNotNullParameter($this$contentDescription, "<this>");
        return (String) throwSemanticsGetNotSupported();
    }

    public static final void setContentDescription(SemanticsPropertyReceiver $this$contentDescription, String value) {
        Intrinsics.checkNotNullParameter($this$contentDescription, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        $this$contentDescription.set(SemanticsProperties.INSTANCE.getContentDescription(), CollectionsKt.listOf(value));
    }

    static {
        Class<SemanticsPropertiesKt> cls = SemanticsPropertiesKt.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "stateDescription", "getStateDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "progressBarRangeInfo", "getProgressBarRangeInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "paneTitle", "getPaneTitle(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "liveRegion", "getLiveRegion(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "focused", "getFocused(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "isContainer", "isContainer(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "horizontalScrollAxisRange", "getHorizontalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "verticalScrollAxisRange", "getVerticalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "role", "getRole(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "testTag", "getTestTag(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "editableText", "getEditableText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "textSelectionRange", "getTextSelectionRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "imeAction", "getImeAction(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "selected", "getSelected(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "collectionInfo", "getCollectionInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "collectionItemInfo", "getCollectionItemInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "toggleableState", "getToggleableState(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "customActions", "getCustomActions(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", 1))};
        SemanticsProperties.INSTANCE.getStateDescription();
        SemanticsProperties.INSTANCE.getProgressBarRangeInfo();
        SemanticsProperties.INSTANCE.getPaneTitle();
        SemanticsProperties.INSTANCE.getLiveRegion();
        SemanticsProperties.INSTANCE.getFocused();
        SemanticsProperties.INSTANCE.getIsContainer();
        SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
        SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
        SemanticsProperties.INSTANCE.getRole();
        SemanticsProperties.INSTANCE.getTestTag();
        SemanticsProperties.INSTANCE.getEditableText();
        SemanticsProperties.INSTANCE.getTextSelectionRange();
        SemanticsProperties.INSTANCE.getImeAction();
        SemanticsProperties.INSTANCE.getSelected();
        SemanticsProperties.INSTANCE.getCollectionInfo();
        SemanticsProperties.INSTANCE.getCollectionItemInfo();
        SemanticsProperties.INSTANCE.getToggleableState();
        SemanticsActions.INSTANCE.getCustomActions();
    }

    public static final String getStateDescription(SemanticsPropertyReceiver $this$stateDescription) {
        Intrinsics.checkNotNullParameter($this$stateDescription, "<this>");
        return SemanticsProperties.INSTANCE.getStateDescription().getValue($this$stateDescription, $$delegatedProperties[0]);
    }

    private static Object getStateDescription$delegate(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getStateDescription();
    }

    public static final void setStateDescription(SemanticsPropertyReceiver $this$stateDescription, String str) {
        Intrinsics.checkNotNullParameter($this$stateDescription, "<this>");
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        SemanticsProperties.INSTANCE.getStateDescription().setValue($this$stateDescription, $$delegatedProperties[0], str);
    }

    public static final ProgressBarRangeInfo getProgressBarRangeInfo(SemanticsPropertyReceiver $this$progressBarRangeInfo) {
        Intrinsics.checkNotNullParameter($this$progressBarRangeInfo, "<this>");
        return SemanticsProperties.INSTANCE.getProgressBarRangeInfo().getValue($this$progressBarRangeInfo, $$delegatedProperties[1]);
    }

    private static Object getProgressBarRangeInfo$delegate(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getProgressBarRangeInfo();
    }

    public static final void setProgressBarRangeInfo(SemanticsPropertyReceiver $this$progressBarRangeInfo, ProgressBarRangeInfo progressBarRangeInfo) {
        Intrinsics.checkNotNullParameter($this$progressBarRangeInfo, "<this>");
        Intrinsics.checkNotNullParameter(progressBarRangeInfo, "<set-?>");
        SemanticsProperties.INSTANCE.getProgressBarRangeInfo().setValue($this$progressBarRangeInfo, $$delegatedProperties[1], progressBarRangeInfo);
    }

    public static final void heading(SemanticsPropertyReceiver $this$heading) {
        Intrinsics.checkNotNullParameter($this$heading, "<this>");
        $this$heading.set(SemanticsProperties.INSTANCE.getHeading(), Unit.INSTANCE);
    }

    public static final String getPaneTitle(SemanticsPropertyReceiver $this$paneTitle) {
        Intrinsics.checkNotNullParameter($this$paneTitle, "<this>");
        return SemanticsProperties.INSTANCE.getPaneTitle().getValue($this$paneTitle, $$delegatedProperties[2]);
    }

    private static Object getPaneTitle$delegate(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getPaneTitle();
    }

    public static final void setPaneTitle(SemanticsPropertyReceiver $this$paneTitle, String str) {
        Intrinsics.checkNotNullParameter($this$paneTitle, "<this>");
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        SemanticsProperties.INSTANCE.getPaneTitle().setValue($this$paneTitle, $$delegatedProperties[2], str);
    }

    public static final void disabled(SemanticsPropertyReceiver $this$disabled) {
        Intrinsics.checkNotNullParameter($this$disabled, "<this>");
        $this$disabled.set(SemanticsProperties.INSTANCE.getDisabled(), Unit.INSTANCE);
    }

    public static final int getLiveRegion(SemanticsPropertyReceiver $this$liveRegion) {
        Intrinsics.checkNotNullParameter($this$liveRegion, "<this>");
        return SemanticsProperties.INSTANCE.getLiveRegion().getValue($this$liveRegion, $$delegatedProperties[3]).m5303unboximpl();
    }

    private static Object getLiveRegion$delegate(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getLiveRegion();
    }

    /* renamed from: setLiveRegion-hR3wRGc  reason: not valid java name */
    public static final void m5326setLiveRegionhR3wRGc(SemanticsPropertyReceiver $this$liveRegion, int i) {
        Intrinsics.checkNotNullParameter($this$liveRegion, "$this$liveRegion");
        SemanticsProperties.INSTANCE.getLiveRegion().setValue($this$liveRegion, $$delegatedProperties[3], LiveRegionMode.m5297boximpl(i));
    }

    public static final boolean getFocused(SemanticsPropertyReceiver $this$focused) {
        Intrinsics.checkNotNullParameter($this$focused, "<this>");
        return SemanticsProperties.INSTANCE.getFocused().getValue($this$focused, $$delegatedProperties[4]).booleanValue();
    }

    private static Object getFocused$delegate(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getFocused();
    }

    public static final void setFocused(SemanticsPropertyReceiver $this$focused, boolean z) {
        Intrinsics.checkNotNullParameter($this$focused, "<this>");
        SemanticsProperties.INSTANCE.getFocused().setValue($this$focused, $$delegatedProperties[4], Boolean.valueOf(z));
    }

    public static final boolean isContainer(SemanticsPropertyReceiver $this$isContainer) {
        Intrinsics.checkNotNullParameter($this$isContainer, "<this>");
        return SemanticsProperties.INSTANCE.getIsContainer().getValue($this$isContainer, $$delegatedProperties[5]).booleanValue();
    }

    private static Object isContainer$delegate(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getIsContainer();
    }

    public static final void setContainer(SemanticsPropertyReceiver $this$isContainer, boolean z) {
        Intrinsics.checkNotNullParameter($this$isContainer, "<this>");
        SemanticsProperties.INSTANCE.getIsContainer().setValue($this$isContainer, $$delegatedProperties[5], Boolean.valueOf(z));
    }

    public static final void invisibleToUser(SemanticsPropertyReceiver $this$invisibleToUser) {
        Intrinsics.checkNotNullParameter($this$invisibleToUser, "<this>");
        $this$invisibleToUser.set(SemanticsProperties.INSTANCE.getInvisibleToUser(), Unit.INSTANCE);
    }

    public static final ScrollAxisRange getHorizontalScrollAxisRange(SemanticsPropertyReceiver $this$horizontalScrollAxisRange) {
        Intrinsics.checkNotNullParameter($this$horizontalScrollAxisRange, "<this>");
        return SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange().getValue($this$horizontalScrollAxisRange, $$delegatedProperties[6]);
    }

    private static Object getHorizontalScrollAxisRange$delegate(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
    }

    public static final void setHorizontalScrollAxisRange(SemanticsPropertyReceiver $this$horizontalScrollAxisRange, ScrollAxisRange scrollAxisRange) {
        Intrinsics.checkNotNullParameter($this$horizontalScrollAxisRange, "<this>");
        Intrinsics.checkNotNullParameter(scrollAxisRange, "<set-?>");
        SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange().setValue($this$horizontalScrollAxisRange, $$delegatedProperties[6], scrollAxisRange);
    }

    public static final ScrollAxisRange getVerticalScrollAxisRange(SemanticsPropertyReceiver $this$verticalScrollAxisRange) {
        Intrinsics.checkNotNullParameter($this$verticalScrollAxisRange, "<this>");
        return SemanticsProperties.INSTANCE.getVerticalScrollAxisRange().getValue($this$verticalScrollAxisRange, $$delegatedProperties[7]);
    }

    private static Object getVerticalScrollAxisRange$delegate(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
    }

    public static final void setVerticalScrollAxisRange(SemanticsPropertyReceiver $this$verticalScrollAxisRange, ScrollAxisRange scrollAxisRange) {
        Intrinsics.checkNotNullParameter($this$verticalScrollAxisRange, "<this>");
        Intrinsics.checkNotNullParameter(scrollAxisRange, "<set-?>");
        SemanticsProperties.INSTANCE.getVerticalScrollAxisRange().setValue($this$verticalScrollAxisRange, $$delegatedProperties[7], scrollAxisRange);
    }

    public static final void popup(SemanticsPropertyReceiver $this$popup) {
        Intrinsics.checkNotNullParameter($this$popup, "<this>");
        $this$popup.set(SemanticsProperties.INSTANCE.getIsPopup(), Unit.INSTANCE);
    }

    public static final void dialog(SemanticsPropertyReceiver $this$dialog) {
        Intrinsics.checkNotNullParameter($this$dialog, "<this>");
        $this$dialog.set(SemanticsProperties.INSTANCE.getIsDialog(), Unit.INSTANCE);
    }

    public static final int getRole(SemanticsPropertyReceiver $this$role) {
        Intrinsics.checkNotNullParameter($this$role, "<this>");
        return SemanticsProperties.INSTANCE.getRole().getValue($this$role, $$delegatedProperties[8]).m5312unboximpl();
    }

    private static Object getRole$delegate(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getRole();
    }

    /* renamed from: setRole-kuIjeqM  reason: not valid java name */
    public static final void m5327setRolekuIjeqM(SemanticsPropertyReceiver $this$role, int i) {
        Intrinsics.checkNotNullParameter($this$role, "$this$role");
        SemanticsProperties.INSTANCE.getRole().setValue($this$role, $$delegatedProperties[8], Role.m5306boximpl(i));
    }

    public static final String getTestTag(SemanticsPropertyReceiver $this$testTag) {
        Intrinsics.checkNotNullParameter($this$testTag, "<this>");
        return SemanticsProperties.INSTANCE.getTestTag().getValue($this$testTag, $$delegatedProperties[9]);
    }

    private static Object getTestTag$delegate(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getTestTag();
    }

    public static final void setTestTag(SemanticsPropertyReceiver $this$testTag, String str) {
        Intrinsics.checkNotNullParameter($this$testTag, "<this>");
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        SemanticsProperties.INSTANCE.getTestTag().setValue($this$testTag, $$delegatedProperties[9], str);
    }

    public static final AnnotatedString getText(SemanticsPropertyReceiver $this$text) {
        Intrinsics.checkNotNullParameter($this$text, "<this>");
        return (AnnotatedString) throwSemanticsGetNotSupported();
    }

    public static final void setText(SemanticsPropertyReceiver $this$text, AnnotatedString value) {
        Intrinsics.checkNotNullParameter($this$text, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        $this$text.set(SemanticsProperties.INSTANCE.getText(), CollectionsKt.listOf(value));
    }

    public static final AnnotatedString getEditableText(SemanticsPropertyReceiver $this$editableText) {
        Intrinsics.checkNotNullParameter($this$editableText, "<this>");
        return SemanticsProperties.INSTANCE.getEditableText().getValue($this$editableText, $$delegatedProperties[10]);
    }

    private static Object getEditableText$delegate(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getEditableText();
    }

    public static final void setEditableText(SemanticsPropertyReceiver $this$editableText, AnnotatedString annotatedString) {
        Intrinsics.checkNotNullParameter($this$editableText, "<this>");
        Intrinsics.checkNotNullParameter(annotatedString, "<set-?>");
        SemanticsProperties.INSTANCE.getEditableText().setValue($this$editableText, $$delegatedProperties[10], annotatedString);
    }

    public static final long getTextSelectionRange(SemanticsPropertyReceiver $this$textSelectionRange) {
        Intrinsics.checkNotNullParameter($this$textSelectionRange, "<this>");
        return SemanticsProperties.INSTANCE.getTextSelectionRange().getValue($this$textSelectionRange, $$delegatedProperties[11]).m5478unboximpl();
    }

    private static Object getTextSelectionRange$delegate(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getTextSelectionRange();
    }

    /* renamed from: setTextSelectionRange-FDrldGo  reason: not valid java name */
    public static final void m5328setTextSelectionRangeFDrldGo(SemanticsPropertyReceiver $this$textSelectionRange, long j) {
        Intrinsics.checkNotNullParameter($this$textSelectionRange, "$this$textSelectionRange");
        SemanticsProperties.INSTANCE.getTextSelectionRange().setValue($this$textSelectionRange, $$delegatedProperties[11], TextRange.m5462boximpl(j));
    }

    public static final int getImeAction(SemanticsPropertyReceiver $this$imeAction) {
        Intrinsics.checkNotNullParameter($this$imeAction, "<this>");
        return SemanticsProperties.INSTANCE.getImeAction().getValue($this$imeAction, $$delegatedProperties[12]).m5625unboximpl();
    }

    private static Object getImeAction$delegate(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getImeAction();
    }

    /* renamed from: setImeAction-4L7nppU  reason: not valid java name */
    public static final void m5325setImeAction4L7nppU(SemanticsPropertyReceiver $this$imeAction, int i) {
        Intrinsics.checkNotNullParameter($this$imeAction, "$this$imeAction");
        SemanticsProperties.INSTANCE.getImeAction().setValue($this$imeAction, $$delegatedProperties[12], ImeAction.m5619boximpl(i));
    }

    public static final boolean getSelected(SemanticsPropertyReceiver $this$selected) {
        Intrinsics.checkNotNullParameter($this$selected, "<this>");
        return SemanticsProperties.INSTANCE.getSelected().getValue($this$selected, $$delegatedProperties[13]).booleanValue();
    }

    private static Object getSelected$delegate(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getSelected();
    }

    public static final void setSelected(SemanticsPropertyReceiver $this$selected, boolean z) {
        Intrinsics.checkNotNullParameter($this$selected, "<this>");
        SemanticsProperties.INSTANCE.getSelected().setValue($this$selected, $$delegatedProperties[13], Boolean.valueOf(z));
    }

    public static final CollectionInfo getCollectionInfo(SemanticsPropertyReceiver $this$collectionInfo) {
        Intrinsics.checkNotNullParameter($this$collectionInfo, "<this>");
        return SemanticsProperties.INSTANCE.getCollectionInfo().getValue($this$collectionInfo, $$delegatedProperties[14]);
    }

    private static Object getCollectionInfo$delegate(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getCollectionInfo();
    }

    public static final void setCollectionInfo(SemanticsPropertyReceiver $this$collectionInfo, CollectionInfo collectionInfo) {
        Intrinsics.checkNotNullParameter($this$collectionInfo, "<this>");
        Intrinsics.checkNotNullParameter(collectionInfo, "<set-?>");
        SemanticsProperties.INSTANCE.getCollectionInfo().setValue($this$collectionInfo, $$delegatedProperties[14], collectionInfo);
    }

    public static final CollectionItemInfo getCollectionItemInfo(SemanticsPropertyReceiver $this$collectionItemInfo) {
        Intrinsics.checkNotNullParameter($this$collectionItemInfo, "<this>");
        return SemanticsProperties.INSTANCE.getCollectionItemInfo().getValue($this$collectionItemInfo, $$delegatedProperties[15]);
    }

    private static Object getCollectionItemInfo$delegate(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getCollectionItemInfo();
    }

    public static final void setCollectionItemInfo(SemanticsPropertyReceiver $this$collectionItemInfo, CollectionItemInfo collectionItemInfo) {
        Intrinsics.checkNotNullParameter($this$collectionItemInfo, "<this>");
        Intrinsics.checkNotNullParameter(collectionItemInfo, "<set-?>");
        SemanticsProperties.INSTANCE.getCollectionItemInfo().setValue($this$collectionItemInfo, $$delegatedProperties[15], collectionItemInfo);
    }

    public static final ToggleableState getToggleableState(SemanticsPropertyReceiver $this$toggleableState) {
        Intrinsics.checkNotNullParameter($this$toggleableState, "<this>");
        return SemanticsProperties.INSTANCE.getToggleableState().getValue($this$toggleableState, $$delegatedProperties[16]);
    }

    private static Object getToggleableState$delegate(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsProperties.INSTANCE.getToggleableState();
    }

    public static final void setToggleableState(SemanticsPropertyReceiver $this$toggleableState, ToggleableState toggleableState) {
        Intrinsics.checkNotNullParameter($this$toggleableState, "<this>");
        Intrinsics.checkNotNullParameter(toggleableState, "<set-?>");
        SemanticsProperties.INSTANCE.getToggleableState().setValue($this$toggleableState, $$delegatedProperties[16], toggleableState);
    }

    public static final void password(SemanticsPropertyReceiver $this$password) {
        Intrinsics.checkNotNullParameter($this$password, "<this>");
        $this$password.set(SemanticsProperties.INSTANCE.getPassword(), Unit.INSTANCE);
    }

    public static final void error(SemanticsPropertyReceiver $this$error, String description) {
        Intrinsics.checkNotNullParameter($this$error, "<this>");
        Intrinsics.checkNotNullParameter(description, "description");
        $this$error.set(SemanticsProperties.INSTANCE.getError(), description);
    }

    public static final void indexForKey(SemanticsPropertyReceiver $this$indexForKey, Function1<Object, Integer> mapping) {
        Intrinsics.checkNotNullParameter($this$indexForKey, "<this>");
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        $this$indexForKey.set(SemanticsProperties.INSTANCE.getIndexForKey(), mapping);
    }

    public static final void selectableGroup(SemanticsPropertyReceiver $this$selectableGroup) {
        Intrinsics.checkNotNullParameter($this$selectableGroup, "<this>");
        $this$selectableGroup.set(SemanticsProperties.INSTANCE.getSelectableGroup(), Unit.INSTANCE);
    }

    public static final List<CustomAccessibilityAction> getCustomActions(SemanticsPropertyReceiver $this$customActions) {
        Intrinsics.checkNotNullParameter($this$customActions, "<this>");
        return SemanticsActions.INSTANCE.getCustomActions().getValue($this$customActions, $$delegatedProperties[17]);
    }

    private static Object getCustomActions$delegate(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsActions.INSTANCE.getCustomActions();
    }

    public static final void setCustomActions(SemanticsPropertyReceiver $this$customActions, List<CustomAccessibilityAction> list) {
        Intrinsics.checkNotNullParameter($this$customActions, "<this>");
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        SemanticsActions.INSTANCE.getCustomActions().setValue($this$customActions, $$delegatedProperties[17], list);
    }

    public static /* synthetic */ void getTextLayoutResult$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        getTextLayoutResult(semanticsPropertyReceiver, str, function1);
    }

    public static final void getTextLayoutResult(SemanticsPropertyReceiver $this$getTextLayoutResult, String label, Function1<? super List<TextLayoutResult>, Boolean> action) {
        Intrinsics.checkNotNullParameter($this$getTextLayoutResult, "<this>");
        $this$getTextLayoutResult.set(SemanticsActions.INSTANCE.getGetTextLayoutResult(), new AccessibilityAction(label, action));
    }

    public static /* synthetic */ void onClick$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        onClick(semanticsPropertyReceiver, str, function0);
    }

    public static final void onClick(SemanticsPropertyReceiver $this$onClick, String label, Function0<Boolean> action) {
        Intrinsics.checkNotNullParameter($this$onClick, "<this>");
        $this$onClick.set(SemanticsActions.INSTANCE.getOnClick(), new AccessibilityAction(label, action));
    }

    public static /* synthetic */ void onLongClick$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        onLongClick(semanticsPropertyReceiver, str, function0);
    }

    public static final void onLongClick(SemanticsPropertyReceiver $this$onLongClick, String label, Function0<Boolean> action) {
        Intrinsics.checkNotNullParameter($this$onLongClick, "<this>");
        $this$onLongClick.set(SemanticsActions.INSTANCE.getOnLongClick(), new AccessibilityAction(label, action));
    }

    public static /* synthetic */ void scrollBy$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        scrollBy(semanticsPropertyReceiver, str, function2);
    }

    public static final void scrollBy(SemanticsPropertyReceiver $this$scrollBy, String label, Function2<? super Float, ? super Float, Boolean> action) {
        Intrinsics.checkNotNullParameter($this$scrollBy, "<this>");
        $this$scrollBy.set(SemanticsActions.INSTANCE.getScrollBy(), new AccessibilityAction(label, action));
    }

    public static /* synthetic */ void scrollToIndex$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        scrollToIndex(semanticsPropertyReceiver, str, function1);
    }

    public static final void scrollToIndex(SemanticsPropertyReceiver $this$scrollToIndex, String label, Function1<? super Integer, Boolean> action) {
        Intrinsics.checkNotNullParameter($this$scrollToIndex, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        $this$scrollToIndex.set(SemanticsActions.INSTANCE.getScrollToIndex(), new AccessibilityAction(label, action));
    }

    public static /* synthetic */ void setProgress$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        setProgress(semanticsPropertyReceiver, str, function1);
    }

    public static final void setProgress(SemanticsPropertyReceiver $this$setProgress, String label, Function1<? super Float, Boolean> action) {
        Intrinsics.checkNotNullParameter($this$setProgress, "<this>");
        $this$setProgress.set(SemanticsActions.INSTANCE.getSetProgress(), new AccessibilityAction(label, action));
    }

    public static /* synthetic */ void setText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        setText(semanticsPropertyReceiver, str, function1);
    }

    public static final void setText(SemanticsPropertyReceiver $this$setText, String label, Function1<? super AnnotatedString, Boolean> action) {
        Intrinsics.checkNotNullParameter($this$setText, "<this>");
        $this$setText.set(SemanticsActions.INSTANCE.getSetText(), new AccessibilityAction(label, action));
    }

    public static /* synthetic */ void setSelection$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        setSelection(semanticsPropertyReceiver, str, function3);
    }

    public static final void setSelection(SemanticsPropertyReceiver $this$setSelection, String label, Function3<? super Integer, ? super Integer, ? super Boolean, Boolean> action) {
        Intrinsics.checkNotNullParameter($this$setSelection, "<this>");
        $this$setSelection.set(SemanticsActions.INSTANCE.getSetSelection(), new AccessibilityAction(label, action));
    }

    public static /* synthetic */ void copyText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        copyText(semanticsPropertyReceiver, str, function0);
    }

    public static final void copyText(SemanticsPropertyReceiver $this$copyText, String label, Function0<Boolean> action) {
        Intrinsics.checkNotNullParameter($this$copyText, "<this>");
        $this$copyText.set(SemanticsActions.INSTANCE.getCopyText(), new AccessibilityAction(label, action));
    }

    public static /* synthetic */ void cutText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        cutText(semanticsPropertyReceiver, str, function0);
    }

    public static final void cutText(SemanticsPropertyReceiver $this$cutText, String label, Function0<Boolean> action) {
        Intrinsics.checkNotNullParameter($this$cutText, "<this>");
        $this$cutText.set(SemanticsActions.INSTANCE.getCutText(), new AccessibilityAction(label, action));
    }

    public static /* synthetic */ void pasteText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        pasteText(semanticsPropertyReceiver, str, function0);
    }

    public static final void pasteText(SemanticsPropertyReceiver $this$pasteText, String label, Function0<Boolean> action) {
        Intrinsics.checkNotNullParameter($this$pasteText, "<this>");
        $this$pasteText.set(SemanticsActions.INSTANCE.getPasteText(), new AccessibilityAction(label, action));
    }

    public static /* synthetic */ void expand$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        expand(semanticsPropertyReceiver, str, function0);
    }

    public static final void expand(SemanticsPropertyReceiver $this$expand, String label, Function0<Boolean> action) {
        Intrinsics.checkNotNullParameter($this$expand, "<this>");
        $this$expand.set(SemanticsActions.INSTANCE.getExpand(), new AccessibilityAction(label, action));
    }

    public static /* synthetic */ void collapse$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        collapse(semanticsPropertyReceiver, str, function0);
    }

    public static final void collapse(SemanticsPropertyReceiver $this$collapse, String label, Function0<Boolean> action) {
        Intrinsics.checkNotNullParameter($this$collapse, "<this>");
        $this$collapse.set(SemanticsActions.INSTANCE.getCollapse(), new AccessibilityAction(label, action));
    }

    public static /* synthetic */ void dismiss$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        dismiss(semanticsPropertyReceiver, str, function0);
    }

    public static final void dismiss(SemanticsPropertyReceiver $this$dismiss, String label, Function0<Boolean> action) {
        Intrinsics.checkNotNullParameter($this$dismiss, "<this>");
        $this$dismiss.set(SemanticsActions.INSTANCE.getDismiss(), new AccessibilityAction(label, action));
    }

    public static /* synthetic */ void requestFocus$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        requestFocus(semanticsPropertyReceiver, str, function0);
    }

    public static final void requestFocus(SemanticsPropertyReceiver $this$requestFocus, String label, Function0<Boolean> action) {
        Intrinsics.checkNotNullParameter($this$requestFocus, "<this>");
        $this$requestFocus.set(SemanticsActions.INSTANCE.getRequestFocus(), new AccessibilityAction(label, action));
    }

    public static /* synthetic */ void pageUp$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        pageUp(semanticsPropertyReceiver, str, function0);
    }

    public static final void pageUp(SemanticsPropertyReceiver $this$pageUp, String label, Function0<Boolean> action) {
        Intrinsics.checkNotNullParameter($this$pageUp, "<this>");
        $this$pageUp.set(SemanticsActions.INSTANCE.getPageUp(), new AccessibilityAction(label, action));
    }

    public static /* synthetic */ void pageDown$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        pageDown(semanticsPropertyReceiver, str, function0);
    }

    public static final void pageDown(SemanticsPropertyReceiver $this$pageDown, String label, Function0<Boolean> action) {
        Intrinsics.checkNotNullParameter($this$pageDown, "<this>");
        $this$pageDown.set(SemanticsActions.INSTANCE.getPageDown(), new AccessibilityAction(label, action));
    }

    public static /* synthetic */ void pageLeft$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        pageLeft(semanticsPropertyReceiver, str, function0);
    }

    public static final void pageLeft(SemanticsPropertyReceiver $this$pageLeft, String label, Function0<Boolean> action) {
        Intrinsics.checkNotNullParameter($this$pageLeft, "<this>");
        $this$pageLeft.set(SemanticsActions.INSTANCE.getPageLeft(), new AccessibilityAction(label, action));
    }

    public static /* synthetic */ void pageRight$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        pageRight(semanticsPropertyReceiver, str, function0);
    }

    public static final void pageRight(SemanticsPropertyReceiver $this$pageRight, String label, Function0<Boolean> action) {
        Intrinsics.checkNotNullParameter($this$pageRight, "<this>");
        $this$pageRight.set(SemanticsActions.INSTANCE.getPageRight(), new AccessibilityAction(label, action));
    }
}
