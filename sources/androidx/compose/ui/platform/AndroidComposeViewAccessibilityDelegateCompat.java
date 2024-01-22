package androidx.compose.ui.platform;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.collection.ArraySet;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.R;
import androidx.compose.ui.TempListUtilsKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.platform.AccessibilityIterators;
import androidx.compose.ui.platform.accessibility.CollectionInfoKt;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesAndroid;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.app.NotificationCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1 = {"\u0000¼\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 Ù\u00012\u00020\u0001:\u000eÖ\u0001×\u0001Ø\u0001Ù\u0001Ú\u0001Û\u0001Ü\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010]\u001a\u00020\u001b2\u0006\u0010^\u001a\u00020\t2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00062\b\u0010b\u001a\u0004\u0018\u00010cH\u0002J\u0011\u0010d\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010eJ-\u0010f\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020\t2\u0006\u0010i\u001a\u00020jH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bk\u0010lJ;\u0010f\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0m2\u0006\u0010g\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020\t2\u0006\u0010i\u001a\u00020jH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bn\u0010oJ\b\u0010p\u001a\u00020\u001bH\u0002J\u0010\u0010q\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020\tH\u0002J\u001d\u0010r\u001a\u00020s2\u0006\u0010^\u001a\u00020\t2\u0006\u0010t\u001a\u00020\tH\u0001¢\u0006\u0002\buJ\u0012\u0010v\u001a\u0004\u0018\u00010`2\u0006\u0010^\u001a\u00020\tH\u0002J=\u0010w\u001a\u00020s2\u0006\u0010^\u001a\u00020\t2\b\u0010x\u001a\u0004\u0018\u00010\t2\b\u0010y\u001a\u0004\u0018\u00010\t2\b\u0010z\u001a\u0004\u0018\u00010\t2\b\u0010{\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010|J\u000e\u0010}\u001a\u00020\u000b2\u0006\u0010~\u001a\u00020J\u0013\u0010\u0001\u001a\u00020?2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020\t2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00020\t2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0017\u0010\u0001\u001a\u0004\u0018\u00010\u00062\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J!\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020\tH\u0002J#\u0010\u0001\u001a\u00020\t2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0003\b\u0001J\u0011\u0010\u0001\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020\tH\u0002J\u0013\u0010\u0001\u001a\u00020\u000b2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0012\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020UH\u0002J\u0018\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020UH\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020\u001bH\u0000¢\u0006\u0003\b\u0001J$\u0010\u0001\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\t2\b\u0010b\u001a\u0004\u0018\u00010cH\u0002J$\u0010\u0001\u001a\u00020\u001b2\u0006\u0010^\u001a\u00020\t2\u0007\u0010_\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0007J!\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\t2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020O0'H\u0002J\u0011\u0010 \u0001\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020\tH\u0002J&\u0010¡\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u00010¢\u0001j\n\u0012\u0005\u0012\u00030\u0001`£\u00012\u0007\u0010¤\u0001\u001a\u00020\u000bH\u0002J\u0012\u0010¥\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\tH\u0002J\u0011\u0010¦\u0001\u001a\u00020\u000b2\u0006\u0010~\u001a\u00020sH\u0002J?\u0010§\u0001\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020\t2\u0006\u0010t\u001a\u00020\t2\u000b\b\u0002\u0010¨\u0001\u001a\u0004\u0018\u00010\t2\u0011\b\u0002\u0010©\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010'H\u0002¢\u0006\u0003\u0010ª\u0001J&\u0010«\u0001\u001a\u00020\u001b2\u0007\u0010¬\u0001\u001a\u00020\t2\u0007\u0010¨\u0001\u001a\u00020\t2\t\u0010­\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010®\u0001\u001a\u00020\u001b2\u0007\u0010¬\u0001\u001a\u00020\tH\u0002J\u0012\u0010¯\u0001\u001a\u00020\u001b2\u0007\u0010°\u0001\u001a\u00020OH\u0002J$\u0010±\u0001\u001a\u00020\u001b2\u0013\u0010²\u0001\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f0\u001eH\u0001¢\u0006\u0003\b³\u0001J\u001c\u0010´\u0001\u001a\u00020\u001b2\b\u0010µ\u0001\u001a\u00030\u00012\u0007\u0010¶\u0001\u001a\u00020FH\u0002J!\u0010·\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020U2\r\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00020\t0AH\u0002J.\u0010¹\u0001\u001a\u00020\u000b2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010º\u0001\u001a\u00020\t2\u0007\u0010»\u0001\u001a\u00020\t2\u0007\u0010¼\u0001\u001a\u00020\u000bH\u0002J\u001c\u0010½\u0001\u001a\u00020\u001b2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010_\u001a\u00030\u0001H\u0002J\u001c\u0010¾\u0001\u001a\u00020\u001b2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010_\u001a\u00030\u0001H\u0002J\t\u0010¿\u0001\u001a\u00020\u001bH\u0002JG\u0010À\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010$2\u0007\u0010¤\u0001\u001a\u00020\u000b2\u000e\u0010Á\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010$2\u001c\b\u0002\u0010Â\u0001\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010$0EH\u0002J)\u0010Ã\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010$2\u0007\u0010¤\u0001\u001a\u00020\u000b2\u000e\u0010Ä\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010$H\u0002J\"\u0010Å\u0001\u001a\u0005\u0018\u00010Æ\u00012\n\u0010Ç\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010È\u0001\u001a\u00030É\u0001H\u0002J.\u0010Ê\u0001\u001a\u00020\u000b2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010Ë\u0001\u001a\u00020\u000b2\u0007\u0010Ì\u0001\u001a\u00020\u000bH\u0002J3\u0010Í\u0001\u001a\u0005\u0018\u0001HÎ\u0001\"\t\b\u0000\u0010Î\u0001*\u00020\u00182\t\u0010{\u001a\u0005\u0018\u0001HÎ\u00012\t\b\u0001\u0010Ï\u0001\u001a\u00020\tH\u0002¢\u0006\u0003\u0010Ð\u0001J\u0011\u0010Ñ\u0001\u001a\u00020\u001b2\u0006\u0010^\u001a\u00020\tH\u0002J\t\u0010Ò\u0001\u001a\u00020\u001bH\u0002J\u0011\u0010Ó\u0001\u001a\u0005\u0018\u00010Ô\u0001*\u00030Õ\u0001H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u00118\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0017X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f0\u001e8BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R2\u0010#\u001a&\u0012\f\u0012\n &*\u0004\u0018\u00010%0% &*\u0012\u0012\f\u0012\n &*\u0004\u0018\u00010%0%\u0018\u00010'0$X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u00020)8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0013\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R*\u00105\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t06j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`7X\u000e¢\u0006\u0002\n\u0000R*\u00108\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t06j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`7X\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\u000b8@X\u0004¢\u0006\f\u0012\u0004\b:\u0010\u0013\u001a\u0004\b;\u0010\rR\u0014\u0010<\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\rR \u0010=\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0\u001e0\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\t0AX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000R0\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020F0E8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bG\u0010\u0013\u001a\u0004\bH\u0010!\"\u0004\bI\u0010JR\u000e\u0010K\u001a\u00020FX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010L\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0004\n\u0002\u0010MR\u0014\u0010N\u001a\b\u0012\u0004\u0012\u00020O0$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010R\u001a\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020\u001b0SX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020U0AX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010V\u001a\u00020W8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bX\u0010\u0013\u001a\u0004\bY\u0010ZR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006Ý\u0001"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/core/view/AccessibilityDelegateCompat;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "EXTRA_DATA_TEST_TRAVERSALAFTER_VAL", "", "EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL", "accessibilityCursorPosition", "", "accessibilityForceEnabledForTesting", "", "getAccessibilityForceEnabledForTesting$ui_release", "()Z", "setAccessibilityForceEnabledForTesting$ui_release", "(Z)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "getAccessibilityManager$ui_release$annotations", "()V", "getAccessibilityManager$ui_release", "()Landroid/view/accessibility/AccessibilityManager;", "actionIdToLabel", "Landroidx/collection/SparseArrayCompat;", "", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "checkingForSemanticsChanges", "currentSemanticsNodes", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes", "()Ljava/util/Map;", "currentSemanticsNodesInvalidated", "enabledServices", "", "Landroid/accessibilityservice/AccessibilityServiceInfo;", "kotlin.jvm.PlatformType", "", "enabledStateListener", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "getEnabledStateListener$ui_release$annotations", "getEnabledStateListener$ui_release", "()Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "focusedVirtualViewId", "handler", "Landroid/os/Handler;", "hoveredVirtualViewId", "getHoveredVirtualViewId$ui_release", "()I", "setHoveredVirtualViewId$ui_release", "(I)V", "idToAfterMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "idToBeforeMap", "isEnabled", "isEnabled$ui_release$annotations", "isEnabled$ui_release", "isTouchExplorationEnabled", "labelToActionId", "nodeProvider", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "paneDisplayed", "Landroidx/collection/ArraySet;", "pendingTextTraversedEvent", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "previousSemanticsNodes", "", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "getPreviousSemanticsNodes$ui_release$annotations", "getPreviousSemanticsNodes$ui_release", "setPreviousSemanticsNodes$ui_release", "(Ljava/util/Map;)V", "previousSemanticsRoot", "previousTraversedNode", "Ljava/lang/Integer;", "scrollObservationScopes", "Landroidx/compose/ui/platform/ScrollObservationScope;", "semanticsChangeChecker", "Ljava/lang/Runnable;", "sendScrollEventIfNeededLambda", "Lkotlin/Function1;", "subtreeChangedLayoutNodes", "Landroidx/compose/ui/node/LayoutNode;", "touchExplorationStateListener", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "getTouchExplorationStateListener$ui_release$annotations", "getTouchExplorationStateListener$ui_release", "()Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "arguments", "Landroid/os/Bundle;", "boundsUpdatesEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canScroll", "vertical", "direction", "position", "Landroidx/compose/ui/geometry/Offset;", "canScroll-0AR0LA0$ui_release", "(ZIJ)Z", "", "canScroll-moWRBKg$ui_release", "(Ljava/util/Collection;ZIJ)Z", "checkForSemanticsChanges", "clearAccessibilityFocus", "createEvent", "Landroid/view/accessibility/AccessibilityEvent;", "eventType", "createEvent$ui_release", "createNodeInfo", "createTextSelectionChangedEvent", "fromIndex", "toIndex", "itemCount", "text", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;)Landroid/view/accessibility/AccessibilityEvent;", "dispatchHoverEvent", "event", "Landroid/view/MotionEvent;", "getAccessibilityNodeProvider", "host", "Landroid/view/View;", "getAccessibilitySelectionEnd", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "getAccessibilitySelectionStart", "getIterableTextForAccessibility", "getIteratorForGranularity", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "granularity", "hitTestSemanticsAt", "x", "", "y", "hitTestSemanticsAt$ui_release", "isAccessibilityFocused", "isAccessibilitySelectionExtendable", "notifySubtreeAccessibilityStateChangedIfNeeded", "layoutNode", "onLayoutChange", "onLayoutChange$ui_release", "onSemanticsChange", "onSemanticsChange$ui_release", "performActionHelper", "action", "populateAccessibilityNodeInfoProperties", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "registerScrollingId", "id", "oldScrollObservationScopes", "requestAccessibilityFocus", "semanticComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "layoutIsRtl", "semanticsNodeIdToAccessibilityVirtualNodeId", "sendEvent", "sendEventForVirtualView", "contentChangeType", "contentDescription", "(IILjava/lang/Integer;Ljava/util/List;)Z", "sendPaneChangeEvents", "semanticsNodeId", "title", "sendPendingTextTraversedAtGranularityEvent", "sendScrollEventIfNeeded", "scrollObservationScope", "sendSemanticsPropertyChangeEvents", "newSemanticsNodes", "sendSemanticsPropertyChangeEvents$ui_release", "sendSemanticsStructureChangeEvents", "newNode", "oldNode", "sendSubtreeChangeAccessibilityEvents", "subtreeChangedSemanticsNodesIds", "setAccessibilitySelection", "start", "end", "traversalMode", "setContentInvalid", "setText", "setTraversalValues", "sortByGeometryGroupings", "parentListToSort", "containerChildrenMapping", "subtreeSortedByGeometryGrouping", "listToSort", "toScreenCoords", "Landroid/graphics/RectF;", "textNode", "bounds", "Landroidx/compose/ui/geometry/Rect;", "traverseAtGranularity", "forward", "extendSelection", "trimToSize", "T", "size", "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "updateHoveredVirtualView", "updateSemanticsNodesCopyAndPanes", "getTextForTextField", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "Api24Impl", "Api28Impl", "Api29Impl", "Companion", "MyNodeProvider", "PendingTextTraversedEvent", "SemanticsNodeCopy", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    private static final int[] AccessibilityActionsResourceIds = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    public static final int AccessibilityCursorPositionUndefined = -1;
    public static final int AccessibilitySliderStepsCount = 20;
    public static final String ClassName = "android.view.View";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ExtraDataTestTagKey = "androidx.compose.ui.semantics.testTag";
    public static final int InvalidId = Integer.MIN_VALUE;
    public static final String LogTag = "AccessibilityDelegate";
    public static final int ParcelSafeTextLength = 100000;
    public static final long SendRecurringAccessibilityEventsIntervalMillis = 100;
    public static final String TextClassName = "android.widget.TextView";
    public static final String TextFieldClassName = "android.widget.EditText";
    public static final long TextTraversedEventTimeoutMillis = 1000;
    private final String EXTRA_DATA_TEST_TRAVERSALAFTER_VAL;
    private final String EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL;
    private int accessibilityCursorPosition;
    private boolean accessibilityForceEnabledForTesting;
    private final AccessibilityManager accessibilityManager;
    private SparseArrayCompat<SparseArrayCompat<CharSequence>> actionIdToLabel;
    private final Channel<Unit> boundsUpdateChannel;
    private boolean checkingForSemanticsChanges;
    private Map<Integer, SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    private List<AccessibilityServiceInfo> enabledServices;
    private final AccessibilityManager.AccessibilityStateChangeListener enabledStateListener;
    private int focusedVirtualViewId;
    /* access modifiers changed from: private */
    public final Handler handler;
    private int hoveredVirtualViewId = Integer.MIN_VALUE;
    private HashMap<Integer, Integer> idToAfterMap;
    private HashMap<Integer, Integer> idToBeforeMap;
    private SparseArrayCompat<Map<CharSequence, Integer>> labelToActionId;
    private AccessibilityNodeProviderCompat nodeProvider;
    private ArraySet<Integer> paneDisplayed;
    private PendingTextTraversedEvent pendingTextTraversedEvent;
    private Map<Integer, SemanticsNodeCopy> previousSemanticsNodes;
    private SemanticsNodeCopy previousSemanticsRoot;
    private Integer previousTraversedNode;
    private final List<ScrollObservationScope> scrollObservationScopes;
    /* access modifiers changed from: private */
    public final Runnable semanticsChangeChecker;
    private final Function1<ScrollObservationScope, Unit> sendScrollEventIfNeededLambda;
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateListener;
    private final AndroidComposeView view;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getAccessibilityManager$ui_release$annotations() {
    }

    public static /* synthetic */ void getEnabledStateListener$ui_release$annotations() {
    }

    public static /* synthetic */ void getPreviousSemanticsNodes$ui_release$annotations() {
    }

    public static /* synthetic */ void getTouchExplorationStateListener$ui_release$annotations() {
    }

    public static /* synthetic */ void isEnabled$ui_release$annotations() {
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Companion;", "", "()V", "AccessibilityActionsResourceIds", "", "AccessibilityCursorPositionUndefined", "", "AccessibilitySliderStepsCount", "ClassName", "", "ExtraDataTestTagKey", "InvalidId", "LogTag", "ParcelSafeTextLength", "SendRecurringAccessibilityEventsIntervalMillis", "", "TextClassName", "TextFieldClassName", "TextTraversedEventTimeoutMillis", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.view = view2;
        Object systemService = view2.getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        AccessibilityManager accessibilityManager2 = (AccessibilityManager) systemService;
        this.accessibilityManager = accessibilityManager2;
        this.enabledStateListener = new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0(this);
        this.touchExplorationStateListener = new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda1(this);
        this.enabledServices = accessibilityManager2.getEnabledAccessibilityServiceList(-1);
        this.handler = new Handler(Looper.getMainLooper());
        this.nodeProvider = new AccessibilityNodeProviderCompat(new MyNodeProvider());
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.actionIdToLabel = new SparseArrayCompat<>();
        this.labelToActionId = new SparseArrayCompat<>();
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet<>();
        this.boundsUpdateChannel = ChannelKt.Channel$default(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.currentSemanticsNodesInvalidated = true;
        this.currentSemanticsNodes = MapsKt.emptyMap();
        this.paneDisplayed = new ArraySet<>();
        this.idToBeforeMap = new HashMap<>();
        this.idToAfterMap = new HashMap<>();
        this.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.previousSemanticsNodes = new LinkedHashMap();
        this.previousSemanticsRoot = new SemanticsNodeCopy(view2.getSemanticsOwner().getUnmergedRootSemanticsNode(), MapsKt.emptyMap());
        view2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this) {
            final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat this$0;

            {
                this.this$0 = $receiver;
            }

            public void onViewAttachedToWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.this$0.getAccessibilityManager$ui_release().addAccessibilityStateChangeListener(this.this$0.getEnabledStateListener$ui_release());
                this.this$0.getAccessibilityManager$ui_release().addTouchExplorationStateChangeListener(this.this$0.getTouchExplorationStateListener$ui_release());
            }

            public void onViewDetachedFromWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.this$0.handler.removeCallbacks(this.this$0.semanticsChangeChecker);
                this.this$0.getAccessibilityManager$ui_release().removeAccessibilityStateChangeListener(this.this$0.getEnabledStateListener$ui_release());
                this.this$0.getAccessibilityManager$ui_release().removeTouchExplorationStateChangeListener(this.this$0.getTouchExplorationStateListener$ui_release());
            }
        });
        this.semanticsChangeChecker = new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda2(this);
        this.scrollObservationScopes = new ArrayList();
        this.sendScrollEventIfNeededLambda = new AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeededLambda$1(this);
    }

    public final int getHoveredVirtualViewId$ui_release() {
        return this.hoveredVirtualViewId;
    }

    public final void setHoveredVirtualViewId$ui_release(int i) {
        this.hoveredVirtualViewId = i;
    }

    public final AccessibilityManager getAccessibilityManager$ui_release() {
        return this.accessibilityManager;
    }

    public final boolean getAccessibilityForceEnabledForTesting$ui_release() {
        return this.accessibilityForceEnabledForTesting;
    }

    public final void setAccessibilityForceEnabledForTesting$ui_release(boolean z) {
        this.accessibilityForceEnabledForTesting = z;
    }

    public final AccessibilityManager.AccessibilityStateChangeListener getEnabledStateListener$ui_release() {
        return this.enabledStateListener;
    }

    /* access modifiers changed from: private */
    public static final void enabledStateListener$lambda$0(AndroidComposeViewAccessibilityDelegateCompat this$0, boolean enabled) {
        List<AccessibilityServiceInfo> list;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (enabled) {
            list = this$0.accessibilityManager.getEnabledAccessibilityServiceList(-1);
        } else {
            list = CollectionsKt.emptyList();
        }
        this$0.enabledServices = list;
    }

    public final AccessibilityManager.TouchExplorationStateChangeListener getTouchExplorationStateListener$ui_release() {
        return this.touchExplorationStateListener;
    }

    /* access modifiers changed from: private */
    public static final void touchExplorationStateListener$lambda$1(AndroidComposeViewAccessibilityDelegateCompat this$0, boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.enabledServices = this$0.accessibilityManager.getEnabledAccessibilityServiceList(-1);
    }

    public final boolean isEnabled$ui_release() {
        if (this.accessibilityForceEnabledForTesting) {
            return true;
        }
        if (this.accessibilityManager.isEnabled()) {
            List<AccessibilityServiceInfo> list = this.enabledServices;
            Intrinsics.checkNotNullExpressionValue(list, "enabledServices");
            if (!list.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private final boolean isTouchExplorationEnabled() {
        return this.accessibilityForceEnabledForTesting || (this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled());
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "action", "", "granularity", "fromIndex", "toIndex", "traverseTime", "", "(Landroidx/compose/ui/semantics/SemanticsNode;IIIIJ)V", "getAction", "()I", "getFromIndex", "getGranularity", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getToIndex", "getTraverseTime", "()J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class PendingTextTraversedEvent {
        private final int action;
        private final int fromIndex;
        private final int granularity;
        private final SemanticsNode node;
        private final int toIndex;
        private final long traverseTime;

        public PendingTextTraversedEvent(SemanticsNode node2, int action2, int granularity2, int fromIndex2, int toIndex2, long traverseTime2) {
            Intrinsics.checkNotNullParameter(node2, "node");
            this.node = node2;
            this.action = action2;
            this.granularity = granularity2;
            this.fromIndex = fromIndex2;
            this.toIndex = toIndex2;
            this.traverseTime = traverseTime2;
        }

        public final SemanticsNode getNode() {
            return this.node;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getGranularity() {
            return this.granularity;
        }

        public final int getFromIndex() {
            return this.fromIndex;
        }

        public final int getToIndex() {
            return this.toIndex;
        }

        public final long getTraverseTime() {
            return this.traverseTime;
        }
    }

    private final Map<Integer, SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getAllUncoveredSemanticsNodesToMap(this.view.getSemanticsOwner());
            setTraversalValues();
        }
        return this.currentSemanticsNodes;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "currentSemanticsNodes", "", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "(Landroidx/compose/ui/semantics/SemanticsNode;Ljava/util/Map;)V", "children", "", "getChildren", "()Ljava/util/Set;", "getSemanticsNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "unmergedConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getUnmergedConfig", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "hasPaneTitle", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    public static final class SemanticsNodeCopy {
        private final Set<Integer> children = new LinkedHashSet();
        private final SemanticsNode semanticsNode;
        private final SemanticsConfiguration unmergedConfig;

        public SemanticsNodeCopy(SemanticsNode semanticsNode2, Map<Integer, SemanticsNodeWithAdjustedBounds> currentSemanticsNodes) {
            Intrinsics.checkNotNullParameter(semanticsNode2, "semanticsNode");
            Intrinsics.checkNotNullParameter(currentSemanticsNodes, "currentSemanticsNodes");
            this.semanticsNode = semanticsNode2;
            this.unmergedConfig = semanticsNode2.getUnmergedConfig$ui_release();
            List $this$fastForEach$iv = semanticsNode2.getReplacedChildren$ui_release();
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                SemanticsNode child = $this$fastForEach$iv.get(index$iv);
                if (currentSemanticsNodes.containsKey(Integer.valueOf(child.getId()))) {
                    this.children.add(Integer.valueOf(child.getId()));
                }
            }
        }

        public final SemanticsNode getSemanticsNode() {
            return this.semanticsNode;
        }

        public final SemanticsConfiguration getUnmergedConfig() {
            return this.unmergedConfig;
        }

        public final Set<Integer> getChildren() {
            return this.children;
        }

        public final boolean hasPaneTitle() {
            return this.unmergedConfig.contains(SemanticsProperties.INSTANCE.getPaneTitle());
        }
    }

    public final Map<Integer, SemanticsNodeCopy> getPreviousSemanticsNodes$ui_release() {
        return this.previousSemanticsNodes;
    }

    public final void setPreviousSemanticsNodes$ui_release(Map<Integer, SemanticsNodeCopy> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.previousSemanticsNodes = map;
    }

    /* renamed from: canScroll-0AR0LA0$ui_release  reason: not valid java name */
    public final boolean m5207canScroll0AR0LA0$ui_release(boolean vertical, int direction, long position) {
        return m5208canScrollmoWRBKg$ui_release(getCurrentSemanticsNodes().values(), vertical, direction, position);
    }

    /* renamed from: canScroll-moWRBKg$ui_release  reason: not valid java name */
    public final boolean m5208canScrollmoWRBKg$ui_release(Collection<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes2, boolean vertical, int direction, long position) {
        SemanticsPropertyKey scrollRangeProperty;
        boolean z;
        Collection<SemanticsNodeWithAdjustedBounds> collection = currentSemanticsNodes2;
        boolean z2 = vertical;
        int i = direction;
        long j = position;
        Intrinsics.checkNotNullParameter(collection, "currentSemanticsNodes");
        if (Offset.m2912equalsimpl0(j, Offset.Companion.m2930getUnspecifiedF1C5BW0()) || !Offset.m2918isValidimpl(position)) {
            return false;
        }
        if (z2) {
            scrollRangeProperty = SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
        } else if (!z2) {
            scrollRangeProperty = SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Iterable<SemanticsNodeWithAdjustedBounds> $this$any$iv = collection;
        if (((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (SemanticsNodeWithAdjustedBounds node : $this$any$iv) {
            if (!RectHelper_androidKt.toComposeRect(node.getAdjustedBounds()).m2941containsk4lQ0M(j)) {
                z = false;
                continue;
            } else {
                ScrollAxisRange scrollRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(node.getSemanticsNode().getConfig(), scrollRangeProperty);
                if (scrollRange == null) {
                    z = false;
                    continue;
                } else {
                    int actualDirection = scrollRange.getReverseScrolling() ? -i : i;
                    if (i == 0 && scrollRange.getReverseScrolling()) {
                        actualDirection = -1;
                    }
                    if (actualDirection < 0) {
                        if (scrollRange.getValue().invoke().floatValue() > 0.0f) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                    } else if (scrollRange.getValue().invoke().floatValue() < scrollRange.getMaxValue().invoke().floatValue()) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: type inference failed for: r4v16, types: [android.view.ViewParent] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = (r0 = r0.getLifecycleOwner()).getLifecycle();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.accessibility.AccessibilityNodeInfo createNodeInfo(int r15) {
        /*
            r14 = this;
            androidx.compose.ui.platform.AndroidComposeView r0 = r14.view
            androidx.compose.ui.platform.AndroidComposeView$ViewTreeOwners r0 = r0.getViewTreeOwners()
            r1 = 0
            if (r0 == 0) goto L_0x001a
            androidx.lifecycle.LifecycleOwner r0 = r0.getLifecycleOwner()
            if (r0 == 0) goto L_0x001a
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            if (r0 == 0) goto L_0x001a
            androidx.lifecycle.Lifecycle$State r0 = r0.getCurrentState()
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            androidx.lifecycle.Lifecycle$State r2 = androidx.lifecycle.Lifecycle.State.DESTROYED
            if (r0 != r2) goto L_0x0020
            return r1
        L_0x0020:
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat r0 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.obtain()
            java.lang.String r2 = "obtain()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.util.Map r2 = r14.getCurrentSemanticsNodes()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r15)
            java.lang.Object r2 = r2.get(r3)
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r2 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r2
            if (r2 != 0) goto L_0x003b
            return r1
        L_0x003b:
            androidx.compose.ui.semantics.SemanticsNode r3 = r2.getSemanticsNode()
            r4 = -1
            if (r15 != r4) goto L_0x0055
            androidx.compose.ui.platform.AndroidComposeView r4 = r14.view
            android.view.View r4 = (android.view.View) r4
            android.view.ViewParent r4 = androidx.core.view.ViewCompat.getParentForAccessibility(r4)
            boolean r5 = r4 instanceof android.view.View
            if (r5 == 0) goto L_0x0051
            r1 = r4
            android.view.View r1 = (android.view.View) r1
        L_0x0051:
            r0.setParent(r1)
            goto L_0x007e
        L_0x0055:
            androidx.compose.ui.semantics.SemanticsNode r1 = r3.getParent()
            if (r1 == 0) goto L_0x00e8
            androidx.compose.ui.semantics.SemanticsNode r1 = r3.getParent()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.getId()
            androidx.compose.ui.platform.AndroidComposeView r4 = r14.view
            androidx.compose.ui.semantics.SemanticsOwner r4 = r4.getSemanticsOwner()
            androidx.compose.ui.semantics.SemanticsNode r4 = r4.getUnmergedRootSemanticsNode()
            int r4 = r4.getId()
            if (r1 != r4) goto L_0x0077
            r1 = -1
        L_0x0077:
            androidx.compose.ui.platform.AndroidComposeView r4 = r14.view
            android.view.View r4 = (android.view.View) r4
            r0.setParent(r4, r1)
        L_0x007e:
            androidx.compose.ui.platform.AndroidComposeView r1 = r14.view
            android.view.View r1 = (android.view.View) r1
            r0.setSource(r1, r15)
            android.graphics.Rect r1 = r2.getAdjustedBounds()
            androidx.compose.ui.platform.AndroidComposeView r4 = r14.view
            int r5 = r1.left
            float r5 = (float) r5
            int r6 = r1.top
            float r6 = (float) r6
            long r5 = androidx.compose.ui.geometry.OffsetKt.Offset(r5, r6)
            long r4 = r4.m5200localToScreenMKHz9U(r5)
            androidx.compose.ui.platform.AndroidComposeView r6 = r14.view
            int r7 = r1.right
            float r7 = (float) r7
            int r8 = r1.bottom
            float r8 = (float) r8
            long r7 = androidx.compose.ui.geometry.OffsetKt.Offset(r7, r8)
            long r6 = r6.m5200localToScreenMKHz9U(r7)
            android.graphics.Rect r8 = new android.graphics.Rect
            float r9 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r4)
            double r9 = (double) r9
            double r9 = java.lang.Math.floor(r9)
            float r9 = (float) r9
            int r9 = (int) r9
            float r10 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r4)
            double r10 = (double) r10
            double r10 = java.lang.Math.floor(r10)
            float r10 = (float) r10
            int r10 = (int) r10
            float r11 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r6)
            double r11 = (double) r11
            double r11 = java.lang.Math.ceil(r11)
            float r11 = (float) r11
            int r11 = (int) r11
            float r12 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r6)
            double r12 = (double) r12
            double r12 = java.lang.Math.ceil(r12)
            float r12 = (float) r12
            int r12 = (int) r12
            r8.<init>(r9, r10, r11, r12)
            r0.setBoundsInScreen(r8)
            r14.populateAccessibilityNodeInfoProperties(r15, r0, r3)
            android.view.accessibility.AccessibilityNodeInfo r8 = r0.unwrap()
            return r8
        L_0x00e8:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "semanticsNode "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r15)
            java.lang.String r5 = " has null parent"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r1.<init>(r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.createNodeInfo(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    private final Comparator<SemanticsNode> semanticComparator(boolean layoutIsRtl) {
        Comparator comparator = ComparisonsKt.compareBy((Function1<? super T, ? extends Comparable<?>>[]) new Function1[]{AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$comparator$1.INSTANCE, AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$comparator$2.INSTANCE, AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$comparator$3.INSTANCE, AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$comparator$4.INSTANCE});
        if (layoutIsRtl) {
            comparator = ComparisonsKt.compareBy((Function1<? super T, ? extends Comparable<?>>[]) new Function1[]{AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$1.INSTANCE, AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$2.INSTANCE, AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$3.INSTANCE, AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$4.INSTANCE});
        }
        return new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$2<>(new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$1(comparator, LayoutNode.Companion.getZComparator$ui_release()));
    }

    static /* synthetic */ List sortByGeometryGroupings$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z, List list, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = new LinkedHashMap();
        }
        return androidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings(z, list, map);
    }

    private final List<SemanticsNode> sortByGeometryGroupings(boolean layoutIsRtl, List<SemanticsNode> parentListToSort, Map<Integer, List<SemanticsNode>> containerChildrenMapping) {
        boolean z;
        List rowGroupings;
        boolean z2;
        Collection collection;
        List rowGroupings2 = new ArrayList();
        int entryIndex = 0;
        int lastIndex = CollectionsKt.getLastIndex(parentListToSort);
        boolean z3 = false;
        boolean z4 = true;
        if (0 <= lastIndex) {
            while (true) {
                SemanticsNode currEntry = parentListToSort.get(entryIndex);
                if (entryIndex == 0 || !sortByGeometryGroupings$placedEntryRowOverlaps(rowGroupings2, currEntry)) {
                    rowGroupings2.add(new Pair(currEntry.getBoundsInWindow(), CollectionsKt.mutableListOf(currEntry)));
                }
                if (entryIndex == lastIndex) {
                    break;
                }
                entryIndex++;
            }
        } else {
            List<SemanticsNode> list = parentListToSort;
        }
        CollectionsKt.sortWith(rowGroupings2, ComparisonsKt.compareBy((Function1<? super T, ? extends Comparable<?>>[]) new Function1[]{AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$1.INSTANCE, AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2.INSTANCE}));
        List returnList = new ArrayList();
        List $this$fastForEach$iv = rowGroupings2;
        int index$iv = 0;
        int size = $this$fastForEach$iv.size();
        while (index$iv < size) {
            Pair row = (Pair) $this$fastForEach$iv.get(index$iv);
            CollectionsKt.sortWith((List) row.getSecond(), semanticComparator(layoutIsRtl));
            List $this$fastForEach$iv2 = (List) row.getSecond();
            int index$iv2 = 0;
            int size2 = $this$fastForEach$iv2.size();
            while (index$iv2 < size2) {
                SemanticsNode node = (SemanticsNode) $this$fastForEach$iv2.get(index$iv2);
                List list2 = containerChildrenMapping.get(Integer.valueOf(node.getId()));
                if (list2 != null) {
                    rowGroupings = rowGroupings2;
                    collection = list2;
                    z2 = true;
                    z = false;
                } else {
                    rowGroupings = rowGroupings2;
                    z2 = true;
                    z = false;
                    collection = CollectionsKt.mutableListOf(node);
                }
                returnList.addAll(collection);
                index$iv2++;
                z4 = z2;
                rowGroupings2 = rowGroupings;
                z3 = z;
            }
            boolean z5 = z3;
            boolean z6 = z4;
            Map<Integer, List<SemanticsNode>> map = containerChildrenMapping;
            index$iv++;
            z4 = z6;
            z3 = z5;
        }
        return returnList;
    }

    private static final boolean sortByGeometryGroupings$placedEntryRowOverlaps(List<Pair<Rect, List<SemanticsNode>>> rowGroupings, SemanticsNode node) {
        float entryTopCoord = node.getBoundsInWindow().getTop();
        float entryBottomCoord = node.getBoundsInWindow().getBottom();
        OpenEndRange entryRange = AndroidComposeViewAccessibilityDelegateCompat_androidKt.rangeUntil(entryTopCoord, entryBottomCoord);
        int currIndex = 0;
        int lastIndex = CollectionsKt.getLastIndex(rowGroupings);
        if (0 > lastIndex) {
            return false;
        }
        while (true) {
            Rect currRect = (Rect) rowGroupings.get(currIndex).getFirst();
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.overlaps(AndroidComposeViewAccessibilityDelegateCompat_androidKt.rangeUntil(currRect.getTop(), currRect.getBottom()), entryRange)) {
                rowGroupings.set(currIndex, new Pair(currRect.intersect(new Rect(0.0f, entryTopCoord, Float.POSITIVE_INFINITY, entryBottomCoord)), rowGroupings.get(currIndex).getSecond()));
                ((List) rowGroupings.get(currIndex).getSecond()).add(node);
                return true;
            } else if (currIndex == lastIndex) {
                return false;
            } else {
                currIndex++;
            }
        }
    }

    private final List<SemanticsNode> subtreeSortedByGeometryGrouping(boolean layoutIsRtl, List<SemanticsNode> listToSort) {
        Map containerMapToChildren = new LinkedHashMap();
        List geometryList = new ArrayList();
        List $this$fastForEach$iv = listToSort;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            subtreeSortedByGeometryGrouping$depthFirstSearch(geometryList, containerMapToChildren, this, layoutIsRtl, $this$fastForEach$iv.get(index$iv));
        }
        return sortByGeometryGroupings(layoutIsRtl, geometryList, containerMapToChildren);
    }

    private static final void subtreeSortedByGeometryGrouping$depthFirstSearch(List<SemanticsNode> geometryList, Map<Integer, List<SemanticsNode>> containerMapToChildren, AndroidComposeViewAccessibilityDelegateCompat this$0, boolean $layoutIsRtl, SemanticsNode currNode) {
        geometryList.add(currNode);
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.getSemanticsNodeIsStructurallySignificant(currNode)) {
            containerMapToChildren.put(Integer.valueOf(currNode.getId()), this$0.subtreeSortedByGeometryGrouping($layoutIsRtl, CollectionsKt.toMutableList(currNode.getChildren())));
            return;
        }
        List $this$fastForEach$iv = currNode.getChildren();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            subtreeSortedByGeometryGrouping$depthFirstSearch(geometryList, containerMapToChildren, this$0, $layoutIsRtl, $this$fastForEach$iv.get(index$iv));
        }
    }

    private final void setTraversalValues() {
        this.idToBeforeMap.clear();
        this.idToAfterMap.clear();
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(-1);
        SemanticsNode hostSemanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
        Intrinsics.checkNotNull(hostSemanticsNode);
        List semanticsOrderList = subtreeSortedByGeometryGrouping(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(hostSemanticsNode), CollectionsKt.toMutableList(hostSemanticsNode.getChildren()));
        int i = 1;
        int lastIndex = CollectionsKt.getLastIndex(semanticsOrderList);
        if (1 <= lastIndex) {
            while (true) {
                int prevId = semanticsOrderList.get(i - 1).getId();
                int currId = semanticsOrderList.get(i).getId();
                this.idToBeforeMap.put(Integer.valueOf(prevId), Integer.valueOf(currId));
                this.idToAfterMap.put(Integer.valueOf(currId), Integer.valueOf(prevId));
                if (i != lastIndex) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void populateAccessibilityNodeInfoProperties(int virtualViewId, AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
        ScrollAxisRange yScrollState;
        String text;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2;
        float f;
        int percent;
        CharSequence charSequence;
        String className;
        int i = virtualViewId;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = info;
        SemanticsNode semanticsNode2 = semanticsNode;
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
        Intrinsics.checkNotNullParameter(semanticsNode2, "semanticsNode");
        boolean isUnmergedLeafNode = !semanticsNode.isFake$ui_release() && semanticsNode.getReplacedChildren$ui_release().isEmpty() && AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(semanticsNode.getLayoutNode$ui_release(), AndroidComposeViewAccessibilityDelegateCompat$populateAccessibilityNodeInfoProperties$isUnmergedLeafNode$1.INSTANCE) == null;
        accessibilityNodeInfoCompat.setClassName(ClassName);
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
        if (role != null) {
            int it = role.m5312unboximpl();
            if (semanticsNode.isFake$ui_release() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
                if (Role.m5309equalsimpl0(role.m5312unboximpl(), Role.Companion.m5319getTabo7Vup1c())) {
                    accessibilityNodeInfoCompat.setRoleDescription(this.view.getContext().getResources().getString(R.string.tab));
                } else {
                    if (Role.m5309equalsimpl0(role.m5312unboximpl(), Role.Companion.m5318getSwitcho7Vup1c())) {
                        accessibilityNodeInfoCompat.setRoleDescription(this.view.getContext().getResources().getString(R.string.switch_role));
                    } else {
                        if (Role.m5309equalsimpl0(it, Role.Companion.m5313getButtono7Vup1c())) {
                            className = "android.widget.Button";
                        } else if (Role.m5309equalsimpl0(it, Role.Companion.m5314getCheckboxo7Vup1c())) {
                            className = "android.widget.CheckBox";
                        } else if (Role.m5309equalsimpl0(it, Role.Companion.m5317getRadioButtono7Vup1c())) {
                            className = "android.widget.RadioButton";
                        } else if (Role.m5309equalsimpl0(it, Role.Companion.m5316getImageo7Vup1c())) {
                            className = "android.widget.ImageView";
                        } else if (Role.m5309equalsimpl0(it, Role.Companion.m5315getDropdownListo7Vup1c())) {
                            className = "android.widget.Spinner";
                        } else {
                            className = null;
                        }
                        if (!Role.m5309equalsimpl0(role.m5312unboximpl(), Role.Companion.m5316getImageo7Vup1c()) || isUnmergedLeafNode || semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants()) {
                            accessibilityNodeInfoCompat.setClassName(className);
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode)) {
            accessibilityNodeInfoCompat.setClassName(TextFieldClassName);
        }
        if (semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getText())) {
            accessibilityNodeInfoCompat.setClassName(TextClassName);
        }
        accessibilityNodeInfoCompat.setPackageName(this.view.getContext().getPackageName());
        accessibilityNodeInfoCompat.setImportantForAccessibility(true);
        List $this$fastForEach$iv = semanticsNode.getReplacedChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            SemanticsNode child = $this$fastForEach$iv.get(index$iv);
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(child.getId()))) {
                AndroidViewHolder holder = this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(child.getLayoutNode$ui_release());
                if (holder != null) {
                    accessibilityNodeInfoCompat.addChild(holder);
                } else {
                    accessibilityNodeInfoCompat.addChild(this.view, child.getId());
                }
            }
        }
        if (this.focusedVirtualViewId == i) {
            accessibilityNodeInfoCompat.setAccessibilityFocused(true);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else {
            accessibilityNodeInfoCompat.setAccessibilityFocused(false);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
        }
        setText(semanticsNode2, accessibilityNodeInfoCompat);
        setContentInvalid(semanticsNode2, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setStateDescription((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getStateDescription()));
        ToggleableState toggleState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getToggleableState());
        if (toggleState != null) {
            accessibilityNodeInfoCompat.setCheckable(true);
            switch (WhenMappings.$EnumSwitchMapping$0[toggleState.ordinal()]) {
                case 1:
                    accessibilityNodeInfoCompat.setChecked(true);
                    if ((role == null ? false : Role.m5309equalsimpl0(role.m5312unboximpl(), Role.Companion.m5318getSwitcho7Vup1c())) && info.getStateDescription() == null) {
                        accessibilityNodeInfoCompat.setStateDescription(this.view.getContext().getResources().getString(R.string.on));
                        break;
                    }
                case 2:
                    accessibilityNodeInfoCompat.setChecked(false);
                    if ((role == null ? false : Role.m5309equalsimpl0(role.m5312unboximpl(), Role.Companion.m5318getSwitcho7Vup1c())) && info.getStateDescription() == null) {
                        accessibilityNodeInfoCompat.setStateDescription(this.view.getContext().getResources().getString(R.string.off));
                        break;
                    }
                case 3:
                    if (info.getStateDescription() == null) {
                        accessibilityNodeInfoCompat.setStateDescription(this.view.getContext().getResources().getString(R.string.indeterminate));
                        break;
                    }
                    break;
            }
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
            boolean it2 = bool.booleanValue();
            if (role == null ? false : Role.m5309equalsimpl0(role.m5312unboximpl(), Role.Companion.m5319getTabo7Vup1c())) {
                accessibilityNodeInfoCompat.setSelected(it2);
            } else {
                accessibilityNodeInfoCompat.setCheckable(true);
                accessibilityNodeInfoCompat.setChecked(it2);
                if (info.getStateDescription() == null) {
                    if (it2) {
                        charSequence = this.view.getContext().getResources().getString(R.string.selected);
                    } else {
                        charSequence = this.view.getContext().getResources().getString(R.string.not_selected);
                    }
                    accessibilityNodeInfoCompat.setStateDescription(charSequence);
                }
            }
            Unit unit5 = Unit.INSTANCE;
            Unit unit6 = Unit.INSTANCE;
        }
        if (!semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
            List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getContentDescription());
            accessibilityNodeInfoCompat.setContentDescription(list != null ? (String) CollectionsKt.firstOrNull(list) : null);
        }
        String testTag = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getTestTag());
        if (testTag != null) {
            boolean testTagsAsResourceId = false;
            SemanticsNode current = semanticsNode;
            while (true) {
                if (current != null) {
                    if (current.getUnmergedConfig$ui_release().contains(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())) {
                        testTagsAsResourceId = ((Boolean) current.getUnmergedConfig$ui_release().get(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())).booleanValue();
                    } else {
                        current = current.getParent();
                    }
                }
            }
            if (testTagsAsResourceId) {
                accessibilityNodeInfoCompat.setViewIdResourceName(testTag);
            }
        }
        if (((Unit) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getHeading())) != null) {
            accessibilityNodeInfoCompat.setHeading(true);
            Unit it3 = Unit.INSTANCE;
            Unit unit7 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat.setPassword(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(semanticsNode));
        accessibilityNodeInfoCompat.setEditable(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode));
        accessibilityNodeInfoCompat.setEnabled(AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode));
        accessibilityNodeInfoCompat.setFocusable(semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getFocused()));
        int i2 = 2;
        if (info.isFocusable()) {
            accessibilityNodeInfoCompat.setFocused(((Boolean) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getFocused())).booleanValue());
            if (info.isFocused()) {
                accessibilityNodeInfoCompat.addAction(2);
            } else {
                accessibilityNodeInfoCompat.addAction(1);
            }
        }
        accessibilityNodeInfoCompat.setVisibleToUser(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isVisible(semanticsNode));
        LiveRegionMode liveRegionMode = (LiveRegionMode) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getLiveRegion());
        if (liveRegionMode != null) {
            int it4 = liveRegionMode.m5303unboximpl();
            if (LiveRegionMode.m5300equalsimpl0(it4, LiveRegionMode.Companion.m5305getPolite0phEisY())) {
                i2 = 1;
            } else if (!LiveRegionMode.m5300equalsimpl0(it4, LiveRegionMode.Companion.m5304getAssertive0phEisY())) {
                i2 = 1;
            }
            accessibilityNodeInfoCompat.setLiveRegion(i2);
            Unit unit8 = Unit.INSTANCE;
            Unit unit9 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat.setClickable(false);
        AccessibilityAction it5 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getOnClick());
        if (it5 != null) {
            boolean isSelected = Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected()), (Object) true);
            accessibilityNodeInfoCompat.setClickable(!isSelected);
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode) && !isSelected) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, it5.getLabel()));
            }
            Unit unit10 = Unit.INSTANCE;
            Unit unit11 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat.setLongClickable(false);
        AccessibilityAction it6 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getOnLongClick());
        if (it6 != null) {
            accessibilityNodeInfoCompat.setLongClickable(true);
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, it6.getLabel()));
            }
            Unit unit12 = Unit.INSTANCE;
            Unit unit13 = Unit.INSTANCE;
        }
        AccessibilityAction it7 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCopyText());
        if (it7 != null) {
            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, it7.getLabel()));
            Unit unit14 = Unit.INSTANCE;
            Unit unit15 = Unit.INSTANCE;
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
            AccessibilityAction it8 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetText());
            if (it8 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, it8.getLabel()));
                Unit unit16 = Unit.INSTANCE;
                Unit unit17 = Unit.INSTANCE;
            }
            AccessibilityAction it9 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCutText());
            if (it9 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, it9.getLabel()));
                Unit unit18 = Unit.INSTANCE;
                Unit unit19 = Unit.INSTANCE;
            }
            AccessibilityAction it10 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPasteText());
            if (it10 != null) {
                if (info.isFocused() && this.view.getClipboardManager().hasText()) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, it10.getLabel()));
                }
                Unit unit20 = Unit.INSTANCE;
                Unit unit21 = Unit.INSTANCE;
            }
        }
        String text2 = getIterableTextForAccessibility(semanticsNode2);
        CharSequence charSequence2 = text2;
        if (!(charSequence2 == null || charSequence2.length() == 0)) {
            accessibilityNodeInfoCompat.setTextSelection(getAccessibilitySelectionStart(semanticsNode2), getAccessibilitySelectionEnd(semanticsNode2));
            AccessibilityAction setSelectionAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetSelection());
            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, setSelectionAction != null ? setSelectionAction.getLabel() : null));
            accessibilityNodeInfoCompat.addAction(256);
            accessibilityNodeInfoCompat.addAction(512);
            accessibilityNodeInfoCompat.setMovementGranularities(11);
            Collection collection = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getContentDescription());
            if ((collection == null || collection.isEmpty()) && semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && !AndroidComposeViewAccessibilityDelegateCompat_androidKt.excludeLineAndPageGranularities(semanticsNode)) {
                accessibilityNodeInfoCompat.setMovementGranularities(16 | info.getMovementGranularities() | 4);
            }
        }
        List extraDataKeys = new ArrayList();
        CharSequence text3 = info.getText();
        if (!(text3 == null || text3.length() == 0) && semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
            extraDataKeys.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
        }
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTestTag())) {
            extraDataKeys.add(ExtraDataTestTagKey);
        }
        if (!extraDataKeys.isEmpty()) {
            AccessibilityNodeInfoVerificationHelperMethods accessibilityNodeInfoVerificationHelperMethods = AccessibilityNodeInfoVerificationHelperMethods.INSTANCE;
            AccessibilityNodeInfo unwrap = info.unwrap();
            Intrinsics.checkNotNullExpressionValue(unwrap, "info.unwrap()");
            accessibilityNodeInfoVerificationHelperMethods.setAvailableExtraData(unwrap, extraDataKeys);
        }
        ProgressBarRangeInfo rangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if (rangeInfo != null) {
            if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetProgress())) {
                accessibilityNodeInfoCompat.setClassName("android.widget.SeekBar");
            } else {
                accessibilityNodeInfoCompat.setClassName("android.widget.ProgressBar");
            }
            if (rangeInfo != ProgressBarRangeInfo.Companion.getIndeterminate()) {
                accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, rangeInfo.getRange().getStart().floatValue(), rangeInfo.getRange().getEndInclusive().floatValue(), rangeInfo.getCurrent()));
                if (info.getStateDescription() == null) {
                    ClosedFloatingPointRange valueRange = rangeInfo.getRange();
                    if (valueRange.getEndInclusive().floatValue() - valueRange.getStart().floatValue() == 0.0f) {
                        f = 0.0f;
                    } else {
                        f = (rangeInfo.getCurrent() - valueRange.getStart().floatValue()) / (valueRange.getEndInclusive().floatValue() - valueRange.getStart().floatValue());
                    }
                    float progress = RangesKt.coerceIn(f, 0.0f, 1.0f);
                    if (progress == 0.0f) {
                        percent = 0;
                    } else {
                        if (progress == 1.0f) {
                            percent = 100;
                        } else {
                            percent = RangesKt.coerceIn(MathKt.roundToInt(((float) 100) * progress), 1, 99);
                        }
                    }
                    ToggleableState toggleableState = toggleState;
                    accessibilityNodeInfoCompat.setStateDescription(this.view.getContext().getResources().getString(R.string.template_percent, new Object[]{Integer.valueOf(percent)}));
                }
            } else {
                if (info.getStateDescription() == null) {
                    accessibilityNodeInfoCompat.setStateDescription(this.view.getContext().getResources().getString(R.string.in_progress));
                }
            }
            if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetProgress()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (rangeInfo.getCurrent() < RangesKt.coerceAtLeast(rangeInfo.getRange().getEndInclusive().floatValue(), rangeInfo.getRange().getStart().floatValue())) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                }
                if (rangeInfo.getCurrent() > RangesKt.coerceAtMost(rangeInfo.getRange().getStart().floatValue(), rangeInfo.getRange().getEndInclusive().floatValue())) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                }
            }
        }
        Api24Impl.addSetProgressAction(info, semanticsNode);
        CollectionInfoKt.setCollectionInfo(semanticsNode2, accessibilityNodeInfoCompat);
        CollectionInfoKt.setCollectionItemInfo(semanticsNode2, accessibilityNodeInfoCompat);
        ScrollAxisRange xScrollState = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
        AccessibilityAction scrollAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getScrollBy());
        if (!(xScrollState == null || scrollAction == null)) {
            if (!CollectionInfoKt.hasCollectionInfo(semanticsNode)) {
                accessibilityNodeInfoCompat.setClassName("android.widget.HorizontalScrollView");
            }
            if (xScrollState.getMaxValue().invoke().floatValue() > 0.0f) {
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(xScrollState)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode)) {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    } else {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    }
                    accessibilityNodeInfoCompat.addAction(accessibilityActionCompat2);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(xScrollState)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode)) {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    } else {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    }
                    accessibilityNodeInfoCompat.addAction(accessibilityActionCompat);
                }
            }
        }
        ScrollAxisRange yScrollState2 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        if (yScrollState2 != null && scrollAction != null) {
            if (!CollectionInfoKt.hasCollectionInfo(semanticsNode)) {
                accessibilityNodeInfoCompat.setClassName("android.widget.ScrollView");
            }
            if (yScrollState2.getMaxValue().invoke().floatValue() > 0.0f) {
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(yScrollState2)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(yScrollState2)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.addPageActions(info, semanticsNode);
        }
        accessibilityNodeInfoCompat.setPaneTitle((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getPaneTitle()));
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
            AccessibilityAction it11 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getExpand());
            if (it11 != null) {
                ScrollAxisRange scrollAxisRange = xScrollState;
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, it11.getLabel()));
                Unit unit22 = Unit.INSTANCE;
                Unit unit23 = Unit.INSTANCE;
            }
            AccessibilityAction it12 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCollapse());
            if (it12 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, it12.getLabel()));
                Unit unit24 = Unit.INSTANCE;
                Unit unit25 = Unit.INSTANCE;
            }
            AccessibilityAction it13 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getDismiss());
            if (it13 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, it13.getLabel()));
                Unit unit26 = Unit.INSTANCE;
                Unit unit27 = Unit.INSTANCE;
            }
            if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getCustomActions())) {
                List customActions = (List) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getCustomActions());
                int size2 = customActions.size();
                int[] iArr = AccessibilityActionsResourceIds;
                if (size2 < iArr.length) {
                    SparseArrayCompat currentActionIdToLabel = new SparseArrayCompat();
                    Map currentLabelToActionId = new LinkedHashMap();
                    if (this.labelToActionId.containsKey(i)) {
                        Map oldLabelToActionId = this.labelToActionId.get(i);
                        List availableIds = ArraysKt.toMutableList(iArr);
                        String str = testTag;
                        List unassignedActions = new ArrayList();
                        List $this$fastForEach$iv2 = customActions;
                        Role role2 = role;
                        int size3 = $this$fastForEach$iv2.size();
                        AccessibilityAction accessibilityAction = scrollAction;
                        int index$iv2 = 0;
                        while (index$iv2 < size3) {
                            int i3 = size3;
                            List $this$fastForEach$iv3 = $this$fastForEach$iv2;
                            List $this$fastForEach$iv4 = $this$fastForEach$iv3;
                            CustomAccessibilityAction action = (CustomAccessibilityAction) $this$fastForEach$iv3.get(index$iv2);
                            Intrinsics.checkNotNull(oldLabelToActionId);
                            ProgressBarRangeInfo rangeInfo2 = rangeInfo;
                            if (oldLabelToActionId.containsKey(action.getLabel())) {
                                Integer actionId = (Integer) oldLabelToActionId.get(action.getLabel());
                                Intrinsics.checkNotNull(actionId);
                                text = text2;
                                yScrollState = yScrollState2;
                                currentActionIdToLabel.put(actionId.intValue(), action.getLabel());
                                currentLabelToActionId.put(action.getLabel(), actionId);
                                availableIds.remove(actionId);
                                Integer num = actionId;
                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(actionId.intValue(), action.getLabel()));
                            } else {
                                text = text2;
                                yScrollState = yScrollState2;
                                unassignedActions.add(action);
                            }
                            index$iv2++;
                            size3 = i3;
                            $this$fastForEach$iv2 = $this$fastForEach$iv4;
                            rangeInfo = rangeInfo2;
                            text2 = text;
                            yScrollState2 = yScrollState;
                        }
                        String str2 = text2;
                        ScrollAxisRange scrollAxisRange2 = yScrollState2;
                        List list2 = $this$fastForEach$iv2;
                        List $this$fastForEachIndexed$iv = unassignedActions;
                        int $i$f$fastForEachIndexed = false;
                        int index$iv3 = 0;
                        int size4 = $this$fastForEachIndexed$iv.size();
                        while (index$iv3 < size4) {
                            CustomAccessibilityAction action2 = (CustomAccessibilityAction) $this$fastForEachIndexed$iv.get(index$iv3);
                            List unassignedActions2 = unassignedActions;
                            int index = index$iv3;
                            int i4 = index;
                            int index2 = availableIds.get(index).intValue();
                            currentActionIdToLabel.put(index2, action2.getLabel());
                            currentLabelToActionId.put(action2.getLabel(), Integer.valueOf(index2));
                            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(index2, action2.getLabel()));
                            index$iv3++;
                            $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv;
                            unassignedActions = unassignedActions2;
                            $i$f$fastForEachIndexed = $i$f$fastForEachIndexed;
                        }
                        List list3 = $this$fastForEachIndexed$iv;
                        int i5 = $i$f$fastForEachIndexed;
                        List $this$fastForEachIndexed$iv2 = customActions;
                    } else {
                        Role role3 = role;
                        AccessibilityAction accessibilityAction2 = scrollAction;
                        ProgressBarRangeInfo progressBarRangeInfo = rangeInfo;
                        String str3 = text2;
                        ScrollAxisRange scrollAxisRange3 = yScrollState2;
                        List $this$fastForEachIndexed$iv3 = customActions;
                        int $i$f$fastForEachIndexed2 = false;
                        int index$iv4 = 0;
                        int size5 = $this$fastForEachIndexed$iv3.size();
                        while (index$iv4 < size5) {
                            CustomAccessibilityAction action3 = (CustomAccessibilityAction) $this$fastForEachIndexed$iv3.get(index$iv4);
                            List customActions2 = customActions;
                            int actionId2 = AccessibilityActionsResourceIds[index$iv4];
                            currentActionIdToLabel.put(actionId2, action3.getLabel());
                            currentLabelToActionId.put(action3.getLabel(), Integer.valueOf(actionId2));
                            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(actionId2, action3.getLabel()));
                            index$iv4++;
                            $this$fastForEachIndexed$iv3 = $this$fastForEachIndexed$iv3;
                            customActions = customActions2;
                            $i$f$fastForEachIndexed2 = $i$f$fastForEachIndexed2;
                        }
                        List list4 = $this$fastForEachIndexed$iv3;
                        int i6 = $i$f$fastForEachIndexed2;
                    }
                    this.actionIdToLabel.put(i, currentActionIdToLabel);
                    this.labelToActionId.put(i, currentLabelToActionId);
                } else {
                    String str4 = testTag;
                    throw new IllegalStateException("Can't have more than " + iArr.length + " custom actions for one widget");
                }
            } else {
                Role role4 = role;
                AccessibilityAction accessibilityAction3 = scrollAction;
                ProgressBarRangeInfo progressBarRangeInfo2 = rangeInfo;
                String str5 = text2;
                ScrollAxisRange scrollAxisRange4 = yScrollState2;
            }
        } else {
            String str6 = testTag;
            Role role5 = role;
            AccessibilityAction accessibilityAction4 = scrollAction;
            ProgressBarRangeInfo progressBarRangeInfo3 = rangeInfo;
            String str7 = text2;
            ScrollAxisRange scrollAxisRange5 = yScrollState2;
        }
        accessibilityNodeInfoCompat.setScreenReaderFocusable(semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants() || (isUnmergedLeafNode && (info.getContentDescription() != null || info.getText() != null || info.getHintText() != null || info.getStateDescription() != null || info.isCheckable())));
        if (this.idToBeforeMap.get(Integer.valueOf(virtualViewId)) != null) {
            Integer it14 = this.idToBeforeMap.get(Integer.valueOf(virtualViewId));
            if (it14 != null) {
                accessibilityNodeInfoCompat.setTraversalBefore(this.view, it14.intValue());
                Unit unit28 = Unit.INSTANCE;
                Unit unit29 = Unit.INSTANCE;
            }
            AccessibilityNodeInfo unwrap2 = info.unwrap();
            Intrinsics.checkNotNullExpressionValue(unwrap2, "info.unwrap()");
            addExtraDataToAccessibilityNodeInfoHelper(i, unwrap2, this.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL, (Bundle) null);
        }
        if (this.idToAfterMap.get(Integer.valueOf(virtualViewId)) != null) {
            Integer it15 = this.idToAfterMap.get(Integer.valueOf(virtualViewId));
            if (it15 != null) {
                accessibilityNodeInfoCompat.setTraversalAfter(this.view, it15.intValue());
                Unit unit30 = Unit.INSTANCE;
                Unit unit31 = Unit.INSTANCE;
            }
            AccessibilityNodeInfo unwrap3 = info.unwrap();
            Intrinsics.checkNotNullExpressionValue(unwrap3, "info.unwrap()");
            addExtraDataToAccessibilityNodeInfoHelper(i, unwrap3, this.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL, (Bundle) null);
        }
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange $this$populateAccessibilityNodeInfoProperties_u24canScrollForward) {
        return ($this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getValue().invoke().floatValue() < $this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getMaxValue().invoke().floatValue() && !$this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getReverseScrolling()) || ($this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getValue().invoke().floatValue() > 0.0f && $this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getReverseScrolling());
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward) {
        return ($this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getValue().invoke().floatValue() > 0.0f && !$this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getReverseScrolling()) || ($this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getValue().invoke().floatValue() < $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getMaxValue().invoke().floatValue() && $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getReverseScrolling());
    }

    private final void setContentInvalid(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        if (node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getError())) {
            info.setContentInvalid(true);
            info.setError((CharSequence) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getError()));
        }
    }

    private final void setText(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        AnnotatedString annotatedString;
        FontFamily.Resolver fontFamilyResolver = this.view.getFontFamilyResolver();
        AnnotatedString textForTextField = getTextForTextField(node.getUnmergedConfig$ui_release());
        SpannableString spannableString = null;
        SpannableString editableTextToAssign = (SpannableString) trimToSize(textForTextField != null ? AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(textForTextField, this.view.getDensity(), fontFamilyResolver) : null, ParcelSafeTextLength);
        List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
        if (!(list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) == null)) {
            spannableString = AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(annotatedString, this.view.getDensity(), fontFamilyResolver);
        }
        info.setText(editableTextToAssign != null ? editableTextToAssign : (SpannableString) trimToSize(spannableString, ParcelSafeTextLength));
    }

    private final boolean isAccessibilityFocused(int virtualViewId) {
        return this.focusedVirtualViewId == virtualViewId;
    }

    private final boolean requestAccessibilityFocus(int virtualViewId) {
        if (!isTouchExplorationEnabled() || isAccessibilityFocused(virtualViewId)) {
            return false;
        }
        int i = this.focusedVirtualViewId;
        if (i != Integer.MIN_VALUE) {
            sendEventForVirtualView$default(this, i, 65536, (Integer) null, (List) null, 12, (Object) null);
        }
        this.focusedVirtualViewId = virtualViewId;
        this.view.invalidate();
        sendEventForVirtualView$default(this, virtualViewId, 32768, (Integer) null, (List) null, 12, (Object) null);
        return true;
    }

    static /* synthetic */ boolean sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i, int i2, Integer num, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i, i2, num, list);
    }

    private final boolean sendEventForVirtualView(int virtualViewId, int eventType, Integer contentChangeType, List<String> contentDescription) {
        if (virtualViewId == Integer.MIN_VALUE || !isEnabled$ui_release()) {
            return false;
        }
        AccessibilityEvent event = createEvent$ui_release(virtualViewId, eventType);
        if (contentChangeType != null) {
            event.setContentChangeTypes(contentChangeType.intValue());
        }
        if (contentDescription != null) {
            event.setContentDescription(TempListUtilsKt.fastJoinToString$default(contentDescription, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
        return sendEvent(event);
    }

    /* access modifiers changed from: private */
    public final boolean sendEvent(AccessibilityEvent event) {
        if (!isEnabled$ui_release()) {
            return false;
        }
        return this.view.getParent().requestSendAccessibilityEvent(this.view, event);
    }

    public final AccessibilityEvent createEvent$ui_release(int virtualViewId, int eventType) {
        AccessibilityEvent event = AccessibilityEvent.obtain(eventType);
        Intrinsics.checkNotNullExpressionValue(event, "obtain(eventType)");
        event.setEnabled(true);
        event.setClassName(ClassName);
        event.setPackageName(this.view.getContext().getPackageName());
        event.setSource(this.view, virtualViewId);
        SemanticsNodeWithAdjustedBounds it = getCurrentSemanticsNodes().get(Integer.valueOf(virtualViewId));
        if (it != null) {
            event.setPassword(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(it.getSemanticsNode()));
        }
        return event;
    }

    private final AccessibilityEvent createTextSelectionChangedEvent(int virtualViewId, Integer fromIndex, Integer toIndex, Integer itemCount, CharSequence text) {
        AccessibilityEvent createEvent$ui_release = createEvent$ui_release(virtualViewId, 8192);
        AccessibilityEvent $this$createTextSelectionChangedEvent_u24lambda_u2434 = createEvent$ui_release;
        if (fromIndex != null) {
            $this$createTextSelectionChangedEvent_u24lambda_u2434.setFromIndex(fromIndex.intValue());
        }
        if (toIndex != null) {
            $this$createTextSelectionChangedEvent_u24lambda_u2434.setToIndex(toIndex.intValue());
        }
        if (itemCount != null) {
            $this$createTextSelectionChangedEvent_u24lambda_u2434.setItemCount(itemCount.intValue());
        }
        if (text != null) {
            $this$createTextSelectionChangedEvent_u24lambda_u2434.getText().add(text);
        }
        return createEvent$ui_release;
    }

    private final boolean clearAccessibilityFocus(int virtualViewId) {
        if (!isAccessibilityFocused(virtualViewId)) {
            return false;
        }
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.view.invalidate();
        sendEventForVirtualView$default(this, virtualViewId, 65536, (Integer) null, (List) null, 12, (Object) null);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v41, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v109, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v44, types: [java.lang.String] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean performActionHelper(int r23, int r24, android.os.Bundle r25) {
        /*
            r22 = this;
            r7 = r22
            r8 = r24
            r9 = r25
            java.util.Map r0 = r22.getCurrentSemanticsNodes()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r23)
            java.lang.Object r0 = r0.get(r1)
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r0 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r0
            r10 = 0
            if (r0 == 0) goto L_0x06a1
            androidx.compose.ui.semantics.SemanticsNode r0 = r0.getSemanticsNode()
            if (r0 != 0) goto L_0x0022
            r1 = r23
            r3 = r10
            goto L_0x06a4
        L_0x0022:
            r11 = r0
            r0 = 1
            switch(r8) {
                case 64: goto L_0x00ae;
                case 128: goto L_0x00a9;
                case 256: goto L_0x0089;
                case 512: goto L_0x0089;
                case 16384: goto L_0x0062;
                case 131072: goto L_0x002e;
                default: goto L_0x0027;
            }
        L_0x0027:
            boolean r1 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(r11)
            if (r1 != 0) goto L_0x00b3
            return r10
        L_0x002e:
            r0 = -1
            if (r9 == 0) goto L_0x0039
            java.lang.String r1 = "ACTION_ARGUMENT_SELECTION_START_INT"
            int r1 = r9.getInt(r1, r0)
            goto L_0x003a
        L_0x0039:
            r1 = r0
        L_0x003a:
            r12 = r1
            if (r9 == 0) goto L_0x0045
            java.lang.String r1 = "ACTION_ARGUMENT_SELECTION_END_INT"
            int r0 = r9.getInt(r1, r0)
            goto L_0x0046
        L_0x0045:
        L_0x0046:
            r13 = r0
            boolean r10 = r7.setAccessibilitySelection(r11, r12, r13, r10)
            if (r10 == 0) goto L_0x0061
            int r0 = r11.getId()
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r0)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 12
            r6 = 0
            r0 = r22
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
        L_0x0061:
            return r10
        L_0x0062:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getCopyText()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x0088
            kotlin.Function r0 = r0.getAction()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            if (r0 == 0) goto L_0x0088
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
        L_0x0088:
            return r10
        L_0x0089:
            if (r9 == 0) goto L_0x00a8
            java.lang.String r1 = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT"
            int r1 = r9.getInt(r1)
            java.lang.String r2 = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN"
            boolean r2 = r9.getBoolean(r2)
            r3 = 256(0x100, float:3.59E-43)
            if (r8 != r3) goto L_0x00a2
            r10 = r0
        L_0x00a2:
            boolean r0 = r7.traverseAtGranularity(r11, r1, r10, r2)
            return r0
        L_0x00a8:
            return r10
        L_0x00a9:
            boolean r0 = r22.clearAccessibilityFocus(r23)
            return r0
        L_0x00ae:
            boolean r0 = r22.requestAccessibilityFocus(r23)
            return r0
        L_0x00b3:
            r1 = 0
            switch(r8) {
                case 1: goto L_0x0630;
                case 2: goto L_0x0607;
                case 16: goto L_0x05cf;
                case 32: goto L_0x05a8;
                case 4096: goto L_0x03c2;
                case 8192: goto L_0x03c2;
                case 32768: goto L_0x039a;
                case 65536: goto L_0x0372;
                case 262144: goto L_0x034a;
                case 524288: goto L_0x0322;
                case 1048576: goto L_0x02fa;
                case 2097152: goto L_0x02b5;
                case 16908342: goto L_0x019e;
                case 16908344: goto L_0x03c2;
                case 16908345: goto L_0x03c2;
                case 16908346: goto L_0x03c2;
                case 16908347: goto L_0x03c2;
                case 16908349: goto L_0x0162;
                case 16908358: goto L_0x013d;
                case 16908359: goto L_0x0118;
                case 16908360: goto L_0x00f3;
                case 16908361: goto L_0x00ce;
                default: goto L_0x00b7;
            }
        L_0x00b7:
            androidx.collection.SparseArrayCompat<androidx.collection.SparseArrayCompat<java.lang.CharSequence>> r0 = r7.actionIdToLabel
            r1 = r23
            java.lang.Object r0 = r0.get(r1)
            androidx.collection.SparseArrayCompat r0 = (androidx.collection.SparseArrayCompat) r0
            if (r0 == 0) goto L_0x069f
            java.lang.Object r0 = r0.get(r8)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 != 0) goto L_0x0658
            r3 = 0
            goto L_0x06a0
        L_0x00ce:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getPageRight()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x00f2
            kotlin.Function r1 = r0.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x00f2
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r10 = r1.booleanValue()
        L_0x00f2:
            return r10
        L_0x00f3:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getPageLeft()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x0117
            kotlin.Function r1 = r0.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x0117
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r10 = r1.booleanValue()
        L_0x0117:
            return r10
        L_0x0118:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getPageDown()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x013c
            kotlin.Function r1 = r0.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x013c
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r10 = r1.booleanValue()
        L_0x013c:
            return r10
        L_0x013d:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getPageUp()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x0161
            kotlin.Function r1 = r0.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x0161
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r10 = r1.booleanValue()
        L_0x0161:
            return r10
        L_0x0162:
            if (r9 == 0) goto L_0x019d
            java.lang.String r0 = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"
            boolean r1 = r9.containsKey(r0)
            if (r1 != 0) goto L_0x016e
            goto L_0x019d
        L_0x016e:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getSetProgress()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            if (r1 == 0) goto L_0x019b
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            if (r1 == 0) goto L_0x019b
            float r0 = r9.getFloat(r0)
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            java.lang.Object r0 = r1.invoke(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
            goto L_0x019c
        L_0x019b:
        L_0x019c:
            return r10
        L_0x019d:
            return r10
        L_0x019e:
            androidx.compose.ui.semantics.SemanticsNode r2 = r11.getParent()
            if (r2 == 0) goto L_0x01b7
            androidx.compose.ui.semantics.SemanticsConfiguration r3 = r2.getConfig()
            if (r3 == 0) goto L_0x01b7
            androidx.compose.ui.semantics.SemanticsActions r4 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r4 = r4.getScrollBy()
            java.lang.Object r3 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r3, r4)
            androidx.compose.ui.semantics.AccessibilityAction r3 = (androidx.compose.ui.semantics.AccessibilityAction) r3
            goto L_0x01b8
        L_0x01b7:
            r3 = r1
        L_0x01b8:
            if (r2 == 0) goto L_0x01d9
            if (r3 == 0) goto L_0x01bd
            goto L_0x01d9
        L_0x01bd:
            androidx.compose.ui.semantics.SemanticsNode r2 = r2.getParent()
            if (r2 == 0) goto L_0x01d6
            androidx.compose.ui.semantics.SemanticsConfiguration r4 = r2.getConfig()
            if (r4 == 0) goto L_0x01d6
            androidx.compose.ui.semantics.SemanticsActions r5 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r5 = r5.getScrollBy()
            java.lang.Object r4 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r4, r5)
            androidx.compose.ui.semantics.AccessibilityAction r4 = (androidx.compose.ui.semantics.AccessibilityAction) r4
            goto L_0x01d7
        L_0x01d6:
            r4 = r1
        L_0x01d7:
            r3 = r4
            goto L_0x01b8
        L_0x01d9:
            if (r2 != 0) goto L_0x01dc
            return r10
        L_0x01dc:
            androidx.compose.ui.layout.LayoutInfo r1 = r2.getLayoutInfo()
            androidx.compose.ui.layout.LayoutCoordinates r1 = r1.getCoordinates()
            androidx.compose.ui.geometry.Rect r1 = androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInParent(r1)
            androidx.compose.ui.layout.LayoutInfo r4 = r2.getLayoutInfo()
            androidx.compose.ui.layout.LayoutCoordinates r4 = r4.getCoordinates()
            androidx.compose.ui.layout.LayoutCoordinates r4 = r4.getParentLayoutCoordinates()
            if (r4 == 0) goto L_0x01fb
            long r4 = androidx.compose.ui.layout.LayoutCoordinatesKt.positionInRoot(r4)
            goto L_0x0201
        L_0x01fb:
            androidx.compose.ui.geometry.Offset$Companion r4 = androidx.compose.ui.geometry.Offset.Companion
            long r4 = r4.m2931getZeroF1C5BW0()
        L_0x0201:
            androidx.compose.ui.geometry.Rect r6 = r1.m2952translatek4lQ0M(r4)
            long r12 = r11.m5321getPositionInRootF1C5BW0()
            long r14 = r11.m5323getSizeYbymL2g()
            long r14 = androidx.compose.ui.unit.IntSizeKt.m6156toSizeozmzZPI(r14)
            androidx.compose.ui.geometry.Rect r12 = androidx.compose.ui.geometry.RectKt.m2955Recttz77jQw(r12, r14)
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r2.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r14 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getHorizontalScrollAxisRange()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.ScrollAxisRange r13 = (androidx.compose.ui.semantics.ScrollAxisRange) r13
            androidx.compose.ui.semantics.SemanticsConfiguration r14 = r2.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r15 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r15 = r15.getVerticalScrollAxisRange()
            java.lang.Object r14 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r14, r15)
            androidx.compose.ui.semantics.ScrollAxisRange r14 = (androidx.compose.ui.semantics.ScrollAxisRange) r14
            float r15 = r12.getLeft()
            float r16 = r6.getLeft()
            float r15 = r15 - r16
            float r16 = r12.getRight()
            float r17 = r6.getRight()
            float r10 = r16 - r17
            float r10 = performActionHelper$scrollDelta(r15, r10)
            if (r13 == 0) goto L_0x025a
            boolean r15 = r13.getReverseScrolling()
            if (r15 != r0) goto L_0x025a
            r15 = r0
            goto L_0x025b
        L_0x025a:
            r15 = 0
        L_0x025b:
            if (r15 == 0) goto L_0x025e
            float r10 = -r10
        L_0x025e:
            boolean r15 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(r11)
            if (r15 == 0) goto L_0x0265
            float r10 = -r10
        L_0x0265:
            float r15 = r12.getTop()
            float r16 = r6.getTop()
            float r15 = r15 - r16
            float r16 = r12.getBottom()
            float r17 = r6.getBottom()
            float r0 = r16 - r17
            float r0 = performActionHelper$scrollDelta(r15, r0)
            if (r14 == 0) goto L_0x028b
            boolean r15 = r14.getReverseScrolling()
            r16 = r1
            r1 = 1
            if (r15 != r1) goto L_0x028d
            r19 = 1
            goto L_0x028f
        L_0x028b:
            r16 = r1
        L_0x028d:
            r19 = 0
        L_0x028f:
            if (r19 == 0) goto L_0x0292
            float r0 = -r0
        L_0x0292:
            if (r3 == 0) goto L_0x02b1
            kotlin.Function r1 = r3.getAction()
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            if (r1 == 0) goto L_0x02b1
            java.lang.Float r15 = java.lang.Float.valueOf(r10)
            r17 = r2
            java.lang.Float r2 = java.lang.Float.valueOf(r0)
            java.lang.Object r1 = r1.invoke(r15, r2)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            goto L_0x02b4
        L_0x02b1:
            r17 = r2
            r1 = 0
        L_0x02b4:
            return r1
        L_0x02b5:
            if (r9 == 0) goto L_0x02be
            java.lang.String r0 = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE"
            java.lang.String r1 = r9.getString(r0)
        L_0x02be:
            r0 = r1
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getSetText()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            if (r1 == 0) goto L_0x02f8
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            if (r1 == 0) goto L_0x02f8
            androidx.compose.ui.text.AnnotatedString r2 = new androidx.compose.ui.text.AnnotatedString
            if (r0 != 0) goto L_0x02e2
            java.lang.String r3 = ""
            r13 = r3
            goto L_0x02e3
        L_0x02e2:
            r13 = r0
        L_0x02e3:
            r14 = 0
            r15 = 0
            r16 = 6
            r17 = 0
            r12 = r2
            r12.<init>(r13, r14, r15, r16, r17)
            java.lang.Object r1 = r1.invoke(r2)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r10 = r1.booleanValue()
            goto L_0x02f9
        L_0x02f8:
            r10 = 0
        L_0x02f9:
            return r10
        L_0x02fa:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getDismiss()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x0320
            kotlin.Function r0 = r0.getAction()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            if (r0 == 0) goto L_0x0320
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
            goto L_0x0321
        L_0x0320:
            r10 = 0
        L_0x0321:
            return r10
        L_0x0322:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getCollapse()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x0348
            kotlin.Function r0 = r0.getAction()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            if (r0 == 0) goto L_0x0348
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
            goto L_0x0349
        L_0x0348:
            r10 = 0
        L_0x0349:
            return r10
        L_0x034a:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getExpand()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x0370
            kotlin.Function r0 = r0.getAction()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            if (r0 == 0) goto L_0x0370
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
            goto L_0x0371
        L_0x0370:
            r10 = 0
        L_0x0371:
            return r10
        L_0x0372:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getCutText()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x0398
            kotlin.Function r0 = r0.getAction()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            if (r0 == 0) goto L_0x0398
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
            goto L_0x0399
        L_0x0398:
            r10 = 0
        L_0x0399:
            return r10
        L_0x039a:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getPasteText()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x03c0
            kotlin.Function r0 = r0.getAction()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            if (r0 == 0) goto L_0x03c0
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
            goto L_0x03c1
        L_0x03c0:
            r10 = 0
        L_0x03c1:
            return r10
        L_0x03c2:
            r0 = 4096(0x1000, float:5.74E-42)
            if (r8 != r0) goto L_0x03c8
            r0 = 1
            goto L_0x03c9
        L_0x03c8:
            r0 = 0
        L_0x03c9:
            r1 = 8192(0x2000, float:1.14794E-41)
            if (r8 != r1) goto L_0x03cf
            r1 = 1
            goto L_0x03d0
        L_0x03cf:
            r1 = 0
        L_0x03d0:
            r2 = 16908345(0x1020039, float:2.387739E-38)
            if (r8 != r2) goto L_0x03d7
            r2 = 1
            goto L_0x03d8
        L_0x03d7:
            r2 = 0
        L_0x03d8:
            r3 = 16908347(0x102003b, float:2.3877394E-38)
            if (r8 != r3) goto L_0x03df
            r3 = 1
            goto L_0x03e0
        L_0x03df:
            r3 = 0
        L_0x03e0:
            r4 = 16908344(0x1020038, float:2.3877386E-38)
            if (r8 != r4) goto L_0x03e7
            r4 = 1
            goto L_0x03e8
        L_0x03e7:
            r4 = 0
        L_0x03e8:
            r5 = 16908346(0x102003a, float:2.3877392E-38)
            if (r8 != r5) goto L_0x03ef
            r5 = 1
            goto L_0x03f0
        L_0x03ef:
            r5 = 0
        L_0x03f0:
            if (r2 != 0) goto L_0x03fb
            if (r3 != 0) goto L_0x03fb
            if (r0 != 0) goto L_0x03fb
            if (r1 == 0) goto L_0x03f9
            goto L_0x03fb
        L_0x03f9:
            r6 = 0
            goto L_0x03fc
        L_0x03fb:
            r6 = 1
        L_0x03fc:
            if (r4 != 0) goto L_0x0407
            if (r5 != 0) goto L_0x0407
            if (r0 != 0) goto L_0x0407
            if (r1 == 0) goto L_0x0405
            goto L_0x0407
        L_0x0405:
            r10 = 0
            goto L_0x0408
        L_0x0407:
            r10 = 1
        L_0x0408:
            if (r0 != 0) goto L_0x0413
            if (r1 == 0) goto L_0x040d
            goto L_0x0413
        L_0x040d:
            r17 = r0
            r20 = r5
            goto L_0x04c4
        L_0x0413:
            androidx.compose.ui.semantics.SemanticsConfiguration r12 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r13 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r13 = r13.getProgressBarRangeInfo()
            java.lang.Object r12 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r12, r13)
            androidx.compose.ui.semantics.ProgressBarRangeInfo r12 = (androidx.compose.ui.semantics.ProgressBarRangeInfo) r12
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getSetProgress()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r12 == 0) goto L_0x04c0
            if (r13 == 0) goto L_0x04c0
            kotlin.ranges.ClosedFloatingPointRange r14 = r12.getRange()
            java.lang.Comparable r14 = r14.getEndInclusive()
            java.lang.Number r14 = (java.lang.Number) r14
            float r14 = r14.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r15 = r12.getRange()
            java.lang.Comparable r15 = r15.getStart()
            java.lang.Number r15 = (java.lang.Number) r15
            float r15 = r15.floatValue()
            float r14 = kotlin.ranges.RangesKt.coerceAtLeast((float) r14, (float) r15)
            kotlin.ranges.ClosedFloatingPointRange r15 = r12.getRange()
            java.lang.Comparable r15 = r15.getStart()
            java.lang.Number r15 = (java.lang.Number) r15
            float r15 = r15.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r16 = r12.getRange()
            java.lang.Comparable r16 = r16.getEndInclusive()
            java.lang.Number r16 = (java.lang.Number) r16
            r17 = r0
            float r0 = r16.floatValue()
            float r0 = kotlin.ranges.RangesKt.coerceAtMost((float) r15, (float) r0)
            int r15 = r12.getSteps()
            if (r15 <= 0) goto L_0x0490
            float r15 = r14 - r0
            int r16 = r12.getSteps()
            r20 = r5
            r19 = 1
            int r5 = r16 + 1
            float r5 = (float) r5
            float r15 = r15 / r5
            goto L_0x0499
        L_0x0490:
            r20 = r5
            float r5 = r14 - r0
            r15 = 20
            float r15 = (float) r15
            float r15 = r5 / r15
        L_0x0499:
            r5 = r15
            if (r1 == 0) goto L_0x049d
            float r5 = -r5
        L_0x049d:
            kotlin.Function r15 = r13.getAction()
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            if (r15 == 0) goto L_0x04bc
            float r16 = r12.getCurrent()
            float r16 = r16 + r5
            r19 = r0
            java.lang.Float r0 = java.lang.Float.valueOf(r16)
            java.lang.Object r0 = r15.invoke(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            goto L_0x04bf
        L_0x04bc:
            r19 = r0
            r0 = 0
        L_0x04bf:
            return r0
        L_0x04c0:
            r17 = r0
            r20 = r5
        L_0x04c4:
            androidx.compose.ui.layout.LayoutInfo r0 = r11.getLayoutInfo()
            androidx.compose.ui.layout.LayoutCoordinates r0 = r0.getCoordinates()
            androidx.compose.ui.geometry.Rect r0 = androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInParent(r0)
            long r12 = r0.m2948getSizeNHjbRc()
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r5 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r5 = r5.getScrollBy()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r5)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 != 0) goto L_0x04e8
            r0 = 0
            return r0
        L_0x04e8:
            androidx.compose.ui.semantics.SemanticsConfiguration r5 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r14 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getHorizontalScrollAxisRange()
            java.lang.Object r5 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r5, r14)
            androidx.compose.ui.semantics.ScrollAxisRange r5 = (androidx.compose.ui.semantics.ScrollAxisRange) r5
            if (r5 == 0) goto L_0x0550
            if (r6 == 0) goto L_0x0550
            float r15 = androidx.compose.ui.geometry.Size.m2984getWidthimpl(r12)
            if (r2 != 0) goto L_0x0506
            if (r1 == 0) goto L_0x0507
        L_0x0506:
            float r15 = -r15
        L_0x0507:
            boolean r16 = r5.getReverseScrolling()
            if (r16 == 0) goto L_0x050e
            float r15 = -r15
        L_0x050e:
            boolean r16 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(r11)
            if (r16 == 0) goto L_0x0519
            if (r2 != 0) goto L_0x0518
            if (r3 == 0) goto L_0x0519
        L_0x0518:
            float r15 = -r15
        L_0x0519:
            boolean r16 = performActionHelper$canScroll(r5, r15)
            if (r16 == 0) goto L_0x054b
            kotlin.Function r16 = r0.getAction()
            r14 = r16
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            if (r14 == 0) goto L_0x0544
            r16 = r2
            java.lang.Float r2 = java.lang.Float.valueOf(r15)
            r21 = r3
            r18 = 0
            java.lang.Float r3 = java.lang.Float.valueOf(r18)
            java.lang.Object r2 = r14.invoke(r2, r3)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r18 = r2
            goto L_0x054a
        L_0x0544:
            r16 = r2
            r21 = r3
            r18 = 0
        L_0x054a:
            return r18
        L_0x054b:
            r16 = r2
            r21 = r3
            goto L_0x0554
        L_0x0550:
            r16 = r2
            r21 = r3
        L_0x0554:
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r3 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r3.getVerticalScrollAxisRange()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r3)
            androidx.compose.ui.semantics.ScrollAxisRange r2 = (androidx.compose.ui.semantics.ScrollAxisRange) r2
            if (r2 == 0) goto L_0x05a4
            if (r10 == 0) goto L_0x05a4
            float r3 = androidx.compose.ui.geometry.Size.m2981getHeightimpl(r12)
            if (r4 != 0) goto L_0x0571
            if (r1 == 0) goto L_0x0572
        L_0x0571:
            float r3 = -r3
        L_0x0572:
            boolean r14 = r2.getReverseScrolling()
            if (r14 == 0) goto L_0x0579
            float r3 = -r3
        L_0x0579:
            boolean r14 = performActionHelper$canScroll(r2, r3)
            if (r14 == 0) goto L_0x05a1
            kotlin.Function r14 = r0.getAction()
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            if (r14 == 0) goto L_0x059d
            r15 = 0
            java.lang.Float r15 = java.lang.Float.valueOf(r15)
            r19 = r0
            java.lang.Float r0 = java.lang.Float.valueOf(r3)
            java.lang.Object r0 = r14.invoke(r15, r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            goto L_0x05a0
        L_0x059d:
            r19 = r0
            r0 = 0
        L_0x05a0:
            return r0
        L_0x05a1:
            r19 = r0
            goto L_0x05a6
        L_0x05a4:
            r19 = r0
        L_0x05a6:
            r0 = 0
            return r0
        L_0x05a8:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getOnLongClick()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x05cd
            kotlin.Function r0 = r0.getAction()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            if (r0 == 0) goto L_0x05cd
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
            goto L_0x05ce
        L_0x05cd:
            r10 = 0
        L_0x05ce:
            return r10
        L_0x05cf:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getOnClick()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r2)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x05f0
            kotlin.Function r0 = r0.getAction()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            if (r0 == 0) goto L_0x05f0
            java.lang.Object r0 = r0.invoke()
            r1 = r0
            java.lang.Boolean r1 = (java.lang.Boolean) r1
        L_0x05f0:
            r10 = r1
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 12
            r6 = 0
            r0 = r22
            r1 = r23
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            if (r10 == 0) goto L_0x0605
            boolean r0 = r10.booleanValue()
            goto L_0x0606
        L_0x0605:
            r0 = 0
        L_0x0606:
            return r0
        L_0x0607:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getFocused()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r2)
            r2 = 1
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x062e
            androidx.compose.ui.platform.AndroidComposeView r0 = r7.view
            androidx.compose.ui.focus.FocusOwner r0 = r0.getFocusOwner()
            androidx.compose.ui.focus.FocusManager r0 = (androidx.compose.ui.focus.FocusManager) r0
            r3 = 0
            androidx.compose.ui.focus.FocusManager.clearFocus$default(r0, r3, r2, r1)
            r10 = r2
            goto L_0x062f
        L_0x062e:
            r10 = 0
        L_0x062f:
            return r10
        L_0x0630:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getRequestFocus()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x0656
            kotlin.Function r0 = r0.getAction()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            if (r0 == 0) goto L_0x0656
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
            goto L_0x0657
        L_0x0656:
            r10 = 0
        L_0x0657:
            return r10
        L_0x0658:
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r3 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r3.getCustomActions()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r3)
            java.util.List r2 = (java.util.List) r2
            if (r2 != 0) goto L_0x066c
            r2 = 0
            return r2
        L_0x066c:
            r3 = r2
            r4 = 0
            r5 = 0
            int r6 = r3.size()
        L_0x0674:
            if (r5 >= r6) goto L_0x069c
            java.lang.Object r10 = r3.get(r5)
            r12 = r10
            androidx.compose.ui.semantics.CustomAccessibilityAction r12 = (androidx.compose.ui.semantics.CustomAccessibilityAction) r12
            r13 = 0
            java.lang.String r14 = r12.getLabel()
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r0)
            if (r14 == 0) goto L_0x0697
            kotlin.jvm.functions.Function0 r6 = r12.getAction()
            java.lang.Object r6 = r6.invoke()
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            return r6
        L_0x0697:
            int r5 = r5 + 1
            goto L_0x0674
        L_0x069c:
            r3 = 0
            return r3
        L_0x069f:
            r3 = 0
        L_0x06a0:
            return r3
        L_0x06a1:
            r1 = r23
            r3 = r10
        L_0x06a4:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.performActionHelper(int, int, android.os.Bundle):boolean");
    }

    private static final boolean performActionHelper$canScroll(ScrollAxisRange $this$performActionHelper_u24canScroll, float amount) {
        return (amount < 0.0f && $this$performActionHelper_u24canScroll.getValue().invoke().floatValue() > 0.0f) || (amount > 0.0f && $this$performActionHelper_u24canScroll.getValue().invoke().floatValue() < $this$performActionHelper_u24canScroll.getMaxValue().invoke().floatValue());
    }

    private static final float performActionHelper$scrollDelta(float a, float b) {
        if (Math.signum(a) == Math.signum(b)) {
            return Math.abs(a) < Math.abs(b) ? a : b;
        }
        return 0.0f;
    }

    /* access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey, Bundle arguments) {
        SemanticsNode node;
        String testTag;
        String str = extraDataKey;
        Bundle bundle = arguments;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(Integer.valueOf(virtualViewId));
        if (semanticsNodeWithAdjustedBounds != null && (node = semanticsNodeWithAdjustedBounds.getSemanticsNode()) != null) {
            String text = getIterableTextForAccessibility(node);
            if (Intrinsics.areEqual((Object) str, (Object) this.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL)) {
                Integer it = this.idToBeforeMap.get(Integer.valueOf(virtualViewId));
                if (it != null) {
                    info.getExtras().putInt(str, it.intValue());
                }
            } else if (Intrinsics.areEqual((Object) str, (Object) this.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL)) {
                Integer it2 = this.idToAfterMap.get(Integer.valueOf(virtualViewId));
                if (it2 != null) {
                    info.getExtras().putInt(str, it2.intValue());
                }
            } else if (node.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && bundle != null && Intrinsics.areEqual((Object) str, (Object) "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
                int positionInfoStartIndex = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
                int positionInfoLength = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
                if (positionInfoLength > 0 && positionInfoStartIndex >= 0) {
                    if (positionInfoStartIndex < (text != null ? text.length() : Integer.MAX_VALUE)) {
                        List textLayoutResults = new ArrayList();
                        Function1 function1 = (Function1) ((AccessibilityAction) node.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getGetTextLayoutResult())).getAction();
                        if (Intrinsics.areEqual((Object) function1 != null ? (Boolean) function1.invoke(textLayoutResults) : null, (Object) true)) {
                            TextLayoutResult textLayoutResult = (TextLayoutResult) textLayoutResults.get(0);
                            List boundingRects = new ArrayList();
                            for (int i = 0; i < positionInfoLength; i++) {
                                if (positionInfoStartIndex + i >= textLayoutResult.getLayoutInput().getText().length()) {
                                    boundingRects.add((Object) null);
                                } else {
                                    boundingRects.add(toScreenCoords(node, textLayoutResult.getBoundingBox(positionInfoStartIndex + i)));
                                }
                            }
                            info.getExtras().putParcelableArray(str, (Parcelable[]) boundingRects.toArray(new RectF[0]));
                            return;
                        }
                        return;
                    }
                }
                Log.e(LogTag, "Invalid arguments for accessibility character locations");
            } else if (node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTestTag()) && bundle != null && Intrinsics.areEqual((Object) str, (Object) ExtraDataTestTagKey) && (testTag = (String) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getTestTag())) != null) {
                info.getExtras().putCharSequence(str, testTag);
            }
        }
    }

    private final RectF toScreenCoords(SemanticsNode textNode, Rect bounds) {
        Rect visibleBounds;
        if (textNode == null) {
            return null;
        }
        Rect boundsInRoot = bounds.m2952translatek4lQ0M(textNode.m5321getPositionInRootF1C5BW0());
        Rect textNodeBoundsInRoot = textNode.getBoundsInRoot();
        if (boundsInRoot.overlaps(textNodeBoundsInRoot)) {
            visibleBounds = boundsInRoot.intersect(textNodeBoundsInRoot);
        } else {
            visibleBounds = null;
        }
        if (visibleBounds == null) {
            return null;
        }
        long topLeftInScreen = this.view.m5200localToScreenMKHz9U(OffsetKt.Offset(visibleBounds.getLeft(), visibleBounds.getTop()));
        long bottomRightInScreen = this.view.m5200localToScreenMKHz9U(OffsetKt.Offset(visibleBounds.getRight(), visibleBounds.getBottom()));
        return new RectF(Offset.m2915getXimpl(topLeftInScreen), Offset.m2916getYimpl(topLeftInScreen), Offset.m2915getXimpl(bottomRightInScreen), Offset.m2916getYimpl(bottomRightInScreen));
    }

    public final boolean dispatchHoverEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (!isTouchExplorationEnabled()) {
            return false;
        }
        switch (event.getAction()) {
            case 7:
            case 9:
                int virtualViewId = hitTestSemanticsAt$ui_release(event.getX(), event.getY());
                boolean handled = this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
                updateHoveredVirtualView(virtualViewId);
                if (virtualViewId == Integer.MIN_VALUE) {
                    return handled;
                }
                return true;
            case 10:
                if (this.hoveredVirtualViewId == Integer.MIN_VALUE) {
                    return this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
                }
                updateHoveredVirtualView(Integer.MIN_VALUE);
                return true;
            default:
                return false;
        }
    }

    public final int hitTestSemanticsAt$ui_release(float x, float y) {
        LayoutNode requireLayoutNode;
        SemanticsModifierNode semanticsModifierNode = null;
        Owner.measureAndLayout$default(this.view, false, 1, (Object) null);
        HitTestResult hitSemanticsEntities = new HitTestResult();
        LayoutNode.m4996hitTestSemanticsM_7yMNQ$ui_release$default(this.view.getRoot(), OffsetKt.Offset(x, y), hitSemanticsEntities, false, false, 12, (Object) null);
        SemanticsModifierNode semanticsModifierNode2 = (SemanticsModifierNode) CollectionsKt.lastOrNull(hitSemanticsEntities);
        if (!(semanticsModifierNode2 == null || (requireLayoutNode = DelegatableNodeKt.requireLayoutNode(semanticsModifierNode2)) == null)) {
            semanticsModifierNode = SemanticsNodeKt.getOuterSemantics(requireLayoutNode);
        }
        SemanticsModifierNode wrapper = semanticsModifierNode;
        if (wrapper == null || !AndroidComposeViewAccessibilityDelegateCompat_androidKt.isVisible(new SemanticsNode(wrapper, false, (LayoutNode) null, 4, (DefaultConstructorMarker) null))) {
            return Integer.MIN_VALUE;
        }
        LayoutNode layoutNode = DelegatableNodeKt.requireLayoutNode(wrapper);
        if (this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(layoutNode) == null) {
            return semanticsNodeIdToAccessibilityVirtualNodeId(layoutNode.getSemanticsId());
        }
        return Integer.MIN_VALUE;
    }

    private final void updateHoveredVirtualView(int virtualViewId) {
        if (this.hoveredVirtualViewId != virtualViewId) {
            int previousVirtualViewId = this.hoveredVirtualViewId;
            this.hoveredVirtualViewId = virtualViewId;
            sendEventForVirtualView$default(this, virtualViewId, 128, (Integer) null, (List) null, 12, (Object) null);
            sendEventForVirtualView$default(this, previousVirtualViewId, 256, (Integer) null, (List) null, 12, (Object) null);
        }
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        Intrinsics.checkNotNullParameter(host, "host");
        return this.nodeProvider;
    }

    private final <T extends CharSequence> T trimToSize(T text, int size) {
        boolean z = true;
        if (size > 0) {
            int len = size;
            if (!(text == null || text.length() == 0)) {
                z = false;
            }
            if (z || text.length() <= size) {
                return text;
            }
            if (Character.isHighSurrogate(text.charAt(size - 1)) && Character.isLowSurrogate(text.charAt(size))) {
                len = size - 1;
            }
            T subSequence = text.subSequence(0, len);
            Intrinsics.checkNotNull(subSequence, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
            return subSequence;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* access modifiers changed from: private */
    public static final void semanticsChangeChecker$lambda$38(AndroidComposeViewAccessibilityDelegateCompat this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Owner.measureAndLayout$default(this$0.view, false, 1, (Object) null);
        this$0.checkForSemanticsChanges();
        this$0.checkingForSemanticsChanges = false;
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release() && !this.checkingForSemanticsChanges) {
            this.checkingForSemanticsChanges = true;
            this.handler.post(this.semanticsChangeChecker);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object boundsUpdatesEventLoop(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 r0 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 r0 = new androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1
            r0.<init>(r10, r11)
        L_0x0019:
            r11 = r0
            java.lang.Object r0 = r11.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r11.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x0057;
                case 1: goto L_0x0042;
                case 2: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x002e:
            java.lang.Object r2 = r11.L$2
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r4 = r11.L$1
            androidx.collection.ArraySet r4 = (androidx.collection.ArraySet) r4
            java.lang.Object r5 = r11.L$0
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r5 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat) r5
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x00e4 }
            r9 = r4
            r4 = r2
            r2 = r9
            goto L_0x00d4
        L_0x0042:
            java.lang.Object r2 = r11.L$2
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r4 = r11.L$1
            androidx.collection.ArraySet r4 = (androidx.collection.ArraySet) r4
            java.lang.Object r5 = r11.L$0
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r5 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat) r5
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x00e4 }
            r6 = r5
            r5 = r4
            r4 = r2
            r2 = r1
            r1 = r0
            goto L_0x007c
        L_0x0057:
            kotlin.ResultKt.throwOnFailure(r0)
            r5 = r10
            androidx.collection.ArraySet r2 = new androidx.collection.ArraySet     // Catch:{ all -> 0x00e4 }
            r2.<init>()     // Catch:{ all -> 0x00e4 }
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r4 = r5.boundsUpdateChannel     // Catch:{ all -> 0x00e4 }
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()     // Catch:{ all -> 0x00e4 }
        L_0x0067:
            r11.L$0 = r5     // Catch:{ all -> 0x00e4 }
            r11.L$1 = r2     // Catch:{ all -> 0x00e4 }
            r11.L$2 = r4     // Catch:{ all -> 0x00e4 }
            r11.label = r3     // Catch:{ all -> 0x00e4 }
            java.lang.Object r6 = r4.hasNext(r11)     // Catch:{ all -> 0x00e4 }
            if (r6 != r1) goto L_0x0076
            return r1
        L_0x0076:
            r9 = r1
            r1 = r0
            r0 = r6
            r6 = r5
            r5 = r2
            r2 = r9
        L_0x007c:
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00de }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00de }
            if (r0 == 0) goto L_0x00d5
            r4.next()     // Catch:{ all -> 0x00de }
            boolean r0 = r6.isEnabled$ui_release()     // Catch:{ all -> 0x00de }
            if (r0 == 0) goto L_0x00b9
            r0 = 0
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r7 = r6.subtreeChangedLayoutNodes     // Catch:{ all -> 0x00de }
            int r7 = r7.size()     // Catch:{ all -> 0x00de }
        L_0x0094:
            if (r0 >= r7) goto L_0x00a9
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r8 = r6.subtreeChangedLayoutNodes     // Catch:{ all -> 0x00de }
            java.lang.Object r8 = r8.valueAt(r0)     // Catch:{ all -> 0x00de }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)     // Catch:{ all -> 0x00de }
            androidx.compose.ui.node.LayoutNode r8 = (androidx.compose.ui.node.LayoutNode) r8     // Catch:{ all -> 0x00de }
            r6.sendSubtreeChangeAccessibilityEvents(r8, r5)     // Catch:{ all -> 0x00de }
            int r0 = r0 + 1
            goto L_0x0094
        L_0x00a9:
            r5.clear()     // Catch:{ all -> 0x00de }
            boolean r0 = r6.checkingForSemanticsChanges     // Catch:{ all -> 0x00de }
            if (r0 != 0) goto L_0x00b9
            r6.checkingForSemanticsChanges = r3     // Catch:{ all -> 0x00de }
            android.os.Handler r0 = r6.handler     // Catch:{ all -> 0x00de }
            java.lang.Runnable r7 = r6.semanticsChangeChecker     // Catch:{ all -> 0x00de }
            r0.post(r7)     // Catch:{ all -> 0x00de }
        L_0x00b9:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r0 = r6.subtreeChangedLayoutNodes     // Catch:{ all -> 0x00de }
            r0.clear()     // Catch:{ all -> 0x00de }
            r11.L$0 = r6     // Catch:{ all -> 0x00de }
            r11.L$1 = r5     // Catch:{ all -> 0x00de }
            r11.L$2 = r4     // Catch:{ all -> 0x00de }
            r0 = 2
            r11.label = r0     // Catch:{ all -> 0x00de }
            r7 = 100
            java.lang.Object r0 = kotlinx.coroutines.DelayKt.delay(r7, r11)     // Catch:{ all -> 0x00de }
            if (r0 != r2) goto L_0x00d0
            return r2
        L_0x00d0:
            r0 = r1
            r1 = r2
            r2 = r5
            r5 = r6
        L_0x00d4:
            goto L_0x0067
        L_0x00d5:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r0 = r6.subtreeChangedLayoutNodes
            r0.clear()
            r0 = r6
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            return r2
        L_0x00de:
            r0 = move-exception
            r5 = r6
            r9 = r1
            r1 = r0
            r0 = r9
            goto L_0x00e5
        L_0x00e4:
            r1 = move-exception
        L_0x00e5:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r2 = r5.subtreeChangedLayoutNodes
            r2.clear()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.boundsUpdatesEventLoop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onLayoutChange$ui_release(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release()) {
            notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
        }
    }

    private final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.m252trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    private final void sendSubtreeChangeAccessibilityEvents(LayoutNode layoutNode, ArraySet<Integer> subtreeChangedSemanticsNodesIds) {
        LayoutNode access$findClosestParentNode;
        SemanticsModifierNode it;
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(layoutNode);
            if (outerSemantics == null) {
                LayoutNode access$findClosestParentNode2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsWrapper$1.INSTANCE);
                outerSemantics = access$findClosestParentNode2 != null ? SemanticsNodeKt.getOuterSemantics(access$findClosestParentNode2) : null;
                if (outerSemantics == null) {
                    return;
                }
            }
            SemanticsModifierNode it2 = outerSemantics;
            if (!(SemanticsModifierNodeKt.collapsedSemanticsConfiguration(it2).isMergingSemanticsOfDescendants() || (access$findClosestParentNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.INSTANCE)) == null || (it = SemanticsNodeKt.getOuterSemantics(access$findClosestParentNode)) == null)) {
                it2 = it;
            }
            int id = DelegatableNodeKt.requireLayoutNode(it2).getSemanticsId();
            if (subtreeChangedSemanticsNodesIds.add(Integer.valueOf(id))) {
                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 1, (List) null, 8, (Object) null);
            }
        }
    }

    private final void checkForSemanticsChanges() {
        sendSemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
        sendSemanticsPropertyChangeEvents$ui_release(getCurrentSemanticsNodes());
        updateSemanticsNodesCopyAndPanes();
    }

    private final void updateSemanticsNodesCopyAndPanes() {
        SemanticsConfiguration unmergedConfig;
        ArraySet toRemove = new ArraySet();
        Iterator<Integer> it = this.paneDisplayed.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(id);
            String str = null;
            SemanticsNode currentNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
            if (currentNode == null || !AndroidComposeViewAccessibilityDelegateCompat_androidKt.hasPaneTitle(currentNode)) {
                toRemove.add(id);
                Intrinsics.checkNotNullExpressionValue(id, "id");
                int intValue = id.intValue();
                SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(id);
                if (!(semanticsNodeCopy == null || (unmergedConfig = semanticsNodeCopy.getUnmergedConfig()) == null)) {
                    str = (String) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsProperties.INSTANCE.getPaneTitle());
                }
                sendPaneChangeEvents(intValue, 32, str);
            }
        }
        this.paneDisplayed.removeAll(toRemove);
        this.previousSemanticsNodes.clear();
        for (Map.Entry entry : getCurrentSemanticsNodes().entrySet()) {
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.hasPaneTitle(((SemanticsNodeWithAdjustedBounds) entry.getValue()).getSemanticsNode()) && this.paneDisplayed.add(entry.getKey())) {
                sendPaneChangeEvents(((Number) entry.getKey()).intValue(), 16, (String) ((SemanticsNodeWithAdjustedBounds) entry.getValue()).getSemanticsNode().getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getPaneTitle()));
            }
            this.previousSemanticsNodes.put(entry.getKey(), new SemanticsNodeCopy(((SemanticsNodeWithAdjustedBounds) entry.getValue()).getSemanticsNode(), getCurrentSemanticsNodes()));
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes());
    }

    public final void sendSemanticsPropertyChangeEvents$ui_release(Map<Integer, SemanticsNodeWithAdjustedBounds> newSemanticsNodes) {
        boolean newlyObservingScroll;
        boolean z;
        String text;
        int endCount;
        AccessibilityEvent accessibilityEvent;
        Map<Integer, SemanticsNodeWithAdjustedBounds> map = newSemanticsNodes;
        Intrinsics.checkNotNullParameter(map, "newSemanticsNodes");
        ArrayList oldScrollObservationScopes = new ArrayList(this.scrollObservationScopes);
        this.scrollObservationScopes.clear();
        for (Integer intValue : newSemanticsNodes.keySet()) {
            int id = intValue.intValue();
            SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(Integer.valueOf(id));
            if (semanticsNodeCopy != null) {
                SemanticsNodeCopy oldNode = semanticsNodeCopy;
                SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = map.get(Integer.valueOf(id));
                SemanticsNode newNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                Intrinsics.checkNotNull(newNode);
                Iterator<Map.Entry<SemanticsPropertyKey<?>, Object>> it = newNode.getUnmergedConfig$ui_release().iterator();
                boolean propertyChanged = false;
                while (true) {
                    boolean z2 = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry entry = it.next();
                    if (Intrinsics.areEqual(entry.getKey(), (Object) SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()) || Intrinsics.areEqual(entry.getKey(), (Object) SemanticsProperties.INSTANCE.getVerticalScrollAxisRange())) {
                        newlyObservingScroll = registerScrollingId(id, oldScrollObservationScopes);
                    } else {
                        newlyObservingScroll = false;
                    }
                    if (newlyObservingScroll || !Intrinsics.areEqual(entry.getValue(), SemanticsConfigurationKt.getOrNull(oldNode.getUnmergedConfig(), (SemanticsPropertyKey) entry.getKey()))) {
                        SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) entry.getKey();
                        if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getPaneTitle())) {
                            Object value = entry.getValue();
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
                            String paneTitle = (String) value;
                            if (oldNode.hasPaneTitle()) {
                                sendPaneChangeEvents(id, 8, paneTitle);
                            }
                        } else {
                            if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getStateDescription()) ? true : Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getToggleableState())) {
                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 64, (List) null, 8, (Object) null);
                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 0, (List) null, 8, (Object) null);
                            } else if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getProgressBarRangeInfo())) {
                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 64, (List) null, 8, (Object) null);
                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 0, (List) null, 8, (Object) null);
                            } else if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getSelected())) {
                                Role role = (Role) SemanticsConfigurationKt.getOrNull(newNode.getConfig(), SemanticsProperties.INSTANCE.getRole());
                                if (!(role == null ? false : Role.m5309equalsimpl0(role.m5312unboximpl(), Role.Companion.m5319getTabo7Vup1c()))) {
                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 64, (List) null, 8, (Object) null);
                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 0, (List) null, 8, (Object) null);
                                } else if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(newNode.getConfig(), SemanticsProperties.INSTANCE.getSelected()), (Object) true)) {
                                    AccessibilityEvent event = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(id), 4);
                                    SemanticsNode mergedNode = new SemanticsNode(newNode.getOuterSemanticsNode$ui_release(), true, (LayoutNode) null, 4, (DefaultConstructorMarker) null);
                                    List list = (List) SemanticsConfigurationKt.getOrNull(mergedNode.getConfig(), SemanticsProperties.INSTANCE.getContentDescription());
                                    String contentDescription = list != null ? TempListUtilsKt.fastJoinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) : null;
                                    List list2 = (List) SemanticsConfigurationKt.getOrNull(mergedNode.getConfig(), SemanticsProperties.INSTANCE.getText());
                                    String text2 = list2 != null ? TempListUtilsKt.fastJoinToString$default(list2, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) : null;
                                    if (contentDescription != null) {
                                        event.setContentDescription(contentDescription);
                                    }
                                    if (text2 != null) {
                                        event.getText().add(text2);
                                    }
                                    sendEvent(event);
                                } else {
                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 0, (List) null, 8, (Object) null);
                                }
                            } else if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getContentDescription())) {
                                int semanticsNodeIdToAccessibilityVirtualNodeId = semanticsNodeIdToAccessibilityVirtualNodeId(id);
                                Object value2 = entry.getValue();
                                Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                                sendEventForVirtualView(semanticsNodeIdToAccessibilityVirtualNodeId, 2048, 4, (List) value2);
                            } else {
                                String str = "";
                                if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getEditableText())) {
                                    if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(newNode)) {
                                        AnnotatedString textForTextField = getTextForTextField(oldNode.getUnmergedConfig());
                                        CharSequence oldText = textForTextField != null ? textForTextField : str;
                                        AnnotatedString textForTextField2 = getTextForTextField(newNode.getUnmergedConfig$ui_release());
                                        CharSequence newText = textForTextField2 != null ? textForTextField2 : str;
                                        CharSequence trimmedNewText = trimToSize(newText, ParcelSafeTextLength);
                                        int startCount = 0;
                                        int endCount2 = 0;
                                        int oldTextLen = oldText.length();
                                        int newTextLen = newText.length();
                                        int minLength = RangesKt.coerceAtMost(oldTextLen, newTextLen);
                                        while (true) {
                                            if (startCount >= minLength) {
                                                endCount = endCount2;
                                                break;
                                            }
                                            endCount = endCount2;
                                            if (oldText.charAt(startCount) != newText.charAt(startCount)) {
                                                break;
                                            }
                                            startCount++;
                                            endCount2 = endCount;
                                        }
                                        int endCount3 = endCount;
                                        while (true) {
                                            if (endCount3 >= minLength - startCount) {
                                                break;
                                            }
                                            int minLength2 = minLength;
                                            if (oldText.charAt((oldTextLen - 1) - endCount3) != newText.charAt((newTextLen - 1) - endCount3)) {
                                                break;
                                            }
                                            endCount3++;
                                            minLength = minLength2;
                                        }
                                        int removedCount = (oldTextLen - endCount3) - startCount;
                                        int addedCount = (newTextLen - endCount3) - startCount;
                                        boolean becamePasswordNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(oldNode.getSemanticsNode()) && !AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(oldNode.getSemanticsNode()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(newNode);
                                        boolean becameNotPasswordNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(oldNode.getSemanticsNode()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(oldNode.getSemanticsNode()) && !AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(newNode);
                                        if (becamePasswordNode) {
                                            int i = oldTextLen;
                                            int i2 = endCount3;
                                        } else if (becameNotPasswordNode) {
                                            int i3 = startCount;
                                            int i4 = oldTextLen;
                                            int i5 = endCount3;
                                        } else {
                                            int i6 = oldTextLen;
                                            int i7 = endCount3;
                                            accessibilityEvent = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(id), 16);
                                            AccessibilityEvent $this$sendSemanticsPropertyChangeEvents_u24lambda_u2442 = accessibilityEvent;
                                            $this$sendSemanticsPropertyChangeEvents_u24lambda_u2442.setFromIndex(startCount);
                                            $this$sendSemanticsPropertyChangeEvents_u24lambda_u2442.setRemovedCount(removedCount);
                                            $this$sendSemanticsPropertyChangeEvents_u24lambda_u2442.setAddedCount(addedCount);
                                            $this$sendSemanticsPropertyChangeEvents_u24lambda_u2442.setBeforeText(oldText);
                                            int i8 = startCount;
                                            $this$sendSemanticsPropertyChangeEvents_u24lambda_u2442.getText().add(trimmedNewText);
                                            int i9 = addedCount;
                                            CharSequence charSequence = trimmedNewText;
                                            CharSequence charSequence2 = newText;
                                            AccessibilityEvent event2 = accessibilityEvent;
                                            event2.setClassName(TextFieldClassName);
                                            sendEvent(event2);
                                            if (becamePasswordNode || becameNotPasswordNode) {
                                                long textRange = ((TextRange) newNode.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m5478unboximpl();
                                                event2.setFromIndex(TextRange.m5474getStartimpl(textRange));
                                                event2.setToIndex(TextRange.m5469getEndimpl(textRange));
                                                sendEvent(event2);
                                            }
                                        }
                                        int i10 = addedCount;
                                        CharSequence charSequence3 = newText;
                                        accessibilityEvent = createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(id), (Integer) null, (Integer) null, Integer.valueOf(newTextLen), trimmedNewText);
                                        AccessibilityEvent event22 = accessibilityEvent;
                                        event22.setClassName(TextFieldClassName);
                                        sendEvent(event22);
                                        long textRange2 = ((TextRange) newNode.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m5478unboximpl();
                                        event22.setFromIndex(TextRange.m5474getStartimpl(textRange2));
                                        event22.setToIndex(TextRange.m5469getEndimpl(textRange2));
                                        sendEvent(event22);
                                    } else {
                                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 2, (List) null, 8, (Object) null);
                                    }
                                } else if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getTextSelectionRange())) {
                                    AnnotatedString textForTextField3 = getTextForTextField(newNode.getUnmergedConfig$ui_release());
                                    if (!(textForTextField3 == null || (text = textForTextField3.getText()) == null)) {
                                        str = text;
                                    }
                                    String newText2 = str;
                                    long textRange3 = ((TextRange) newNode.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m5478unboximpl();
                                    sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(id), Integer.valueOf(TextRange.m5474getStartimpl(textRange3)), Integer.valueOf(TextRange.m5469getEndimpl(textRange3)), Integer.valueOf(newText2.length()), trimToSize(newText2, ParcelSafeTextLength)));
                                    sendPendingTextTraversedAtGranularityEvent(newNode.getId());
                                } else {
                                    if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange())) {
                                        z = true;
                                    } else {
                                        z = Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
                                    }
                                    if (z) {
                                        notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode$ui_release());
                                        ScrollObservationScope scope = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findById(this.scrollObservationScopes, id);
                                        Intrinsics.checkNotNull(scope);
                                        scope.setHorizontalScrollAxisRange((ScrollAxisRange) SemanticsConfigurationKt.getOrNull(newNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()));
                                        scope.setVerticalScrollAxisRange((ScrollAxisRange) SemanticsConfigurationKt.getOrNull(newNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange()));
                                        sendScrollEventIfNeeded(scope);
                                    } else if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getFocused())) {
                                        Object value3 = entry.getValue();
                                        Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type kotlin.Boolean");
                                        if (((Boolean) value3).booleanValue()) {
                                            sendEvent(createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(newNode.getId()), 8));
                                        }
                                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(newNode.getId()), 2048, 0, (List) null, 8, (Object) null);
                                    } else if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsActions.INSTANCE.getCustomActions())) {
                                        List actions = (List) newNode.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getCustomActions());
                                        List oldActions = (List) SemanticsConfigurationKt.getOrNull(oldNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCustomActions());
                                        if (oldActions != null) {
                                            Set labels = new LinkedHashSet();
                                            List $this$fastForEach$iv = actions;
                                            int index$iv = 0;
                                            int size = $this$fastForEach$iv.size();
                                            while (index$iv < size) {
                                                labels.add(((CustomAccessibilityAction) $this$fastForEach$iv.get(index$iv)).getLabel());
                                                index$iv++;
                                                $this$fastForEach$iv = $this$fastForEach$iv;
                                            }
                                            Set oldLabels = new LinkedHashSet();
                                            List $this$fastForEach$iv2 = oldActions;
                                            int index$iv2 = 0;
                                            int size2 = $this$fastForEach$iv2.size();
                                            while (index$iv2 < size2) {
                                                oldLabels.add(((CustomAccessibilityAction) $this$fastForEach$iv2.get(index$iv2)).getLabel());
                                                index$iv2++;
                                                oldActions = oldActions;
                                            }
                                            if (!labels.containsAll(oldLabels) || !oldLabels.containsAll(labels)) {
                                                z2 = true;
                                            }
                                            propertyChanged = z2;
                                            Map<Integer, SemanticsNodeWithAdjustedBounds> map2 = newSemanticsNodes;
                                        } else {
                                            if (!actions.isEmpty()) {
                                                propertyChanged = true;
                                                Map<Integer, SemanticsNodeWithAdjustedBounds> map3 = newSemanticsNodes;
                                            }
                                        }
                                    } else if (entry.getValue() instanceof AccessibilityAction) {
                                        Object value4 = entry.getValue();
                                        Intrinsics.checkNotNull(value4, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                                        propertyChanged = !AndroidComposeViewAccessibilityDelegateCompat_androidKt.accessibilityEquals((AccessibilityAction) value4, SemanticsConfigurationKt.getOrNull(oldNode.getUnmergedConfig(), (SemanticsPropertyKey) entry.getKey()));
                                        Map<Integer, SemanticsNodeWithAdjustedBounds> map4 = newSemanticsNodes;
                                    } else {
                                        propertyChanged = true;
                                        Map<Integer, SemanticsNodeWithAdjustedBounds> map5 = newSemanticsNodes;
                                    }
                                }
                            }
                        }
                    }
                    Map<Integer, SemanticsNodeWithAdjustedBounds> map6 = newSemanticsNodes;
                }
                if (!propertyChanged) {
                    propertyChanged = AndroidComposeViewAccessibilityDelegateCompat_androidKt.propertiesDeleted(newNode, oldNode);
                }
                if (propertyChanged) {
                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 0, (List) null, 8, (Object) null);
                    map = newSemanticsNodes;
                } else {
                    map = newSemanticsNodes;
                }
            }
        }
    }

    private final boolean registerScrollingId(int id, List<ScrollObservationScope> oldScrollObservationScopes) {
        ScrollObservationScope newScope;
        boolean newlyObservingScroll = false;
        ScrollObservationScope oldScope = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findById(oldScrollObservationScopes, id);
        if (oldScope != null) {
            newScope = oldScope;
        } else {
            newlyObservingScroll = true;
            newScope = new ScrollObservationScope(id, this.scrollObservationScopes, (Float) null, (Float) null, (ScrollAxisRange) null, (ScrollAxisRange) null);
        }
        this.scrollObservationScopes.add(newScope);
        return newlyObservingScroll;
    }

    /* access modifiers changed from: private */
    public final void sendScrollEventIfNeeded(ScrollObservationScope scrollObservationScope) {
        if (scrollObservationScope.isValidOwnerScope()) {
            this.view.getSnapshotObserver().observeReads$ui_release(scrollObservationScope, this.sendScrollEventIfNeededLambda, new AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeeded$1(scrollObservationScope, this));
        }
    }

    private final void sendPaneChangeEvents(int semanticsNodeId, int contentChangeType, String title) {
        AccessibilityEvent event = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNodeId), 32);
        event.setContentChangeTypes(contentChangeType);
        if (title != null) {
            event.getText().add(title);
        }
        sendEvent(event);
    }

    private final void sendSemanticsStructureChangeEvents(SemanticsNode newNode, SemanticsNodeCopy oldNode) {
        Set newChildren = new LinkedHashSet();
        List $this$fastForEach$iv = newNode.getReplacedChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            SemanticsNode child = $this$fastForEach$iv.get(index$iv);
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(child.getId()))) {
                if (!oldNode.getChildren().contains(Integer.valueOf(child.getId()))) {
                    notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode$ui_release());
                    return;
                }
                newChildren.add(Integer.valueOf(child.getId()));
            }
        }
        for (Integer intValue : oldNode.getChildren()) {
            if (!newChildren.contains(Integer.valueOf(intValue.intValue()))) {
                notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode$ui_release());
                return;
            }
        }
        List $this$fastForEach$iv2 = newNode.getReplacedChildren$ui_release();
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            SemanticsNode child2 = $this$fastForEach$iv2.get(index$iv2);
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(child2.getId()))) {
                SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(Integer.valueOf(child2.getId()));
                Intrinsics.checkNotNull(semanticsNodeCopy);
                sendSemanticsStructureChangeEvents(child2, semanticsNodeCopy);
            }
        }
    }

    /* access modifiers changed from: private */
    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int id) {
        if (id == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            return -1;
        }
        return id;
    }

    private final boolean traverseAtGranularity(SemanticsNode node, int granularity, boolean forward, boolean extendSelection) {
        AccessibilityIterators.TextSegmentIterator iterator;
        int selectionStart;
        int selectionEnd;
        int action;
        int id = node.getId();
        Integer num = this.previousTraversedNode;
        if (num == null || id != num.intValue()) {
            this.accessibilityCursorPosition = -1;
            this.previousTraversedNode = Integer.valueOf(node.getId());
        }
        String text = getIterableTextForAccessibility(node);
        CharSequence charSequence = text;
        if ((charSequence == null || charSequence.length() == 0) || (iterator = getIteratorForGranularity(node, granularity)) == null) {
            return false;
        }
        int current = getAccessibilitySelectionEnd(node);
        if (current == -1) {
            current = forward ? 0 : text.length();
        }
        int[] range = forward ? iterator.following(current) : iterator.preceding(current);
        if (range == null) {
            return false;
        }
        int segmentStart = range[0];
        int segmentEnd = range[1];
        if (!extendSelection || !isAccessibilitySelectionExtendable(node)) {
            selectionEnd = forward ? segmentEnd : segmentStart;
            selectionStart = selectionEnd;
        } else {
            int selectionStart2 = getAccessibilitySelectionStart(node);
            if (selectionStart2 == -1) {
                selectionStart2 = forward ? segmentStart : segmentEnd;
            }
            selectionEnd = forward ? segmentEnd : segmentStart;
            selectionStart = selectionStart2;
        }
        if (forward) {
            action = 256;
        } else {
            action = 512;
        }
        String str = text;
        PendingTextTraversedEvent pendingTextTraversedEvent2 = r8;
        PendingTextTraversedEvent pendingTextTraversedEvent3 = new PendingTextTraversedEvent(node, action, granularity, segmentStart, segmentEnd, SystemClock.uptimeMillis());
        this.pendingTextTraversedEvent = pendingTextTraversedEvent2;
        setAccessibilitySelection(node, selectionStart, selectionEnd, true);
        return true;
    }

    private final void sendPendingTextTraversedAtGranularityEvent(int semanticsNodeId) {
        PendingTextTraversedEvent it = this.pendingTextTraversedEvent;
        if (it != null) {
            if (semanticsNodeId == it.getNode().getId()) {
                if (SystemClock.uptimeMillis() - it.getTraverseTime() <= 1000) {
                    AccessibilityEvent event = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(it.getNode().getId()), 131072);
                    event.setFromIndex(it.getFromIndex());
                    event.setToIndex(it.getToIndex());
                    event.setAction(it.getAction());
                    event.setMovementGranularity(it.getGranularity());
                    event.getText().add(getIterableTextForAccessibility(it.getNode()));
                    sendEvent(event);
                }
            } else {
                return;
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    private final boolean setAccessibilitySelection(SemanticsNode node, int start, int end, boolean traversalMode) {
        String text;
        int i;
        boolean nonEmptyText = false;
        if (node.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetSelection()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(node)) {
            Function3 function3 = (Function3) ((AccessibilityAction) node.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getSetSelection())).getAction();
            if (function3 != null) {
                return ((Boolean) function3.invoke(Integer.valueOf(start), Integer.valueOf(end), Boolean.valueOf(traversalMode))).booleanValue();
            }
            return false;
        } else if ((start == end && end == this.accessibilityCursorPosition) || (text = getIterableTextForAccessibility(node)) == null) {
            return false;
        } else {
            if (start < 0 || start != end || end > text.length()) {
                i = -1;
            } else {
                i = start;
            }
            this.accessibilityCursorPosition = i;
            if (text.length() > 0) {
                nonEmptyText = true;
            }
            int semanticsNodeIdToAccessibilityVirtualNodeId = semanticsNodeIdToAccessibilityVirtualNodeId(node.getId());
            Integer num = null;
            Integer valueOf = nonEmptyText ? Integer.valueOf(this.accessibilityCursorPosition) : null;
            Integer valueOf2 = nonEmptyText ? Integer.valueOf(this.accessibilityCursorPosition) : null;
            if (nonEmptyText) {
                num = Integer.valueOf(text.length());
            }
            sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId, valueOf, valueOf2, num, text));
            sendPendingTextTraversedAtGranularityEvent(node.getId());
            return true;
        }
    }

    private final int getAccessibilitySelectionStart(SemanticsNode node) {
        if (node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription()) || !node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return this.accessibilityCursorPosition;
        }
        return TextRange.m5474getStartimpl(((TextRange) node.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m5478unboximpl());
    }

    private final int getAccessibilitySelectionEnd(SemanticsNode node) {
        if (node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription()) || !node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return this.accessibilityCursorPosition;
        }
        return TextRange.m5469getEndimpl(((TextRange) node.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m5478unboximpl());
    }

    private final boolean isAccessibilitySelectionExtendable(SemanticsNode node) {
        return !node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getEditableText());
    }

    private final AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(SemanticsNode node, int granularity) {
        AccessibilityIterators.AbstractTextSegmentIterator iterator;
        if (node == null) {
            return null;
        }
        String text = getIterableTextForAccessibility(node);
        CharSequence charSequence = text;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        switch (granularity) {
            case 1:
                AccessibilityIterators.CharacterTextSegmentIterator.Companion companion = AccessibilityIterators.CharacterTextSegmentIterator.Companion;
                Locale locale = this.view.getContext().getResources().getConfiguration().locale;
                Intrinsics.checkNotNullExpressionValue(locale, "view.context.resources.configuration.locale");
                iterator = companion.getInstance(locale);
                iterator.initialize(text);
                break;
            case 2:
                AccessibilityIterators.WordTextSegmentIterator.Companion companion2 = AccessibilityIterators.WordTextSegmentIterator.Companion;
                Locale locale2 = this.view.getContext().getResources().getConfiguration().locale;
                Intrinsics.checkNotNullExpressionValue(locale2, "view.context.resources.configuration.locale");
                iterator = companion2.getInstance(locale2);
                iterator.initialize(text);
                break;
            case 4:
            case 16:
                if (!node.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                    return null;
                }
                List textLayoutResults = new ArrayList();
                Function1 function1 = (Function1) ((AccessibilityAction) node.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getGetTextLayoutResult())).getAction();
                if (Intrinsics.areEqual((Object) function1 != null ? (Boolean) function1.invoke(textLayoutResults) : null, (Object) true)) {
                    TextLayoutResult textLayoutResult = (TextLayoutResult) textLayoutResults.get(0);
                    if (granularity != 4) {
                        AccessibilityIterators.AbstractTextSegmentIterator iterator2 = AccessibilityIterators.PageTextSegmentIterator.Companion.getInstance();
                        ((AccessibilityIterators.PageTextSegmentIterator) iterator2).initialize(text, textLayoutResult, node);
                        iterator = iterator2;
                        break;
                    } else {
                        AccessibilityIterators.AbstractTextSegmentIterator iterator3 = AccessibilityIterators.LineTextSegmentIterator.Companion.getInstance();
                        ((AccessibilityIterators.LineTextSegmentIterator) iterator3).initialize(text, textLayoutResult);
                        iterator = iterator3;
                        break;
                    }
                } else {
                    return null;
                }
            case 8:
                iterator = AccessibilityIterators.ParagraphTextSegmentIterator.Companion.getInstance();
                iterator.initialize(text);
                break;
            default:
                return null;
        }
        return iterator;
    }

    private final String getIterableTextForAccessibility(SemanticsNode node) {
        AnnotatedString annotatedString;
        if (node == null) {
            return null;
        }
        if (node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription())) {
            return TempListUtilsKt.fastJoinToString$default((List) node.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getContentDescription()), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(node)) {
            AnnotatedString textForTextField = getTextForTextField(node.getUnmergedConfig$ui_release());
            if (textForTextField != null) {
                return textForTextField.getText();
            }
            return null;
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
        if (list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) == null) {
            return null;
        }
        return annotatedString.getText();
    }

    private final AnnotatedString getTextForTextField(SemanticsConfiguration $this$getTextForTextField) {
        return (AnnotatedString) SemanticsConfigurationKt.getOrNull($this$getTextForTextField, SemanticsProperties.INSTANCE.getEditableText());
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$MyNodeProvider;", "Landroid/view/accessibility/AccessibilityNodeProvider;", "(Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;)V", "addExtraDataToAccessibilityNodeInfo", "", "virtualViewId", "", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "arguments", "Landroid/os/Bundle;", "createAccessibilityNodeInfo", "performAction", "", "action", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    public final class MyNodeProvider extends AccessibilityNodeProvider {
        public MyNodeProvider() {
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.createNodeInfo(virtualViewId);
        }

        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.performActionHelper(virtualViewId, action, arguments);
        }

        public void addExtraDataToAccessibilityNodeInfo(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey, Bundle arguments) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(extraDataKey, "extraDataKey");
            AndroidComposeViewAccessibilityDelegateCompat.this.addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, info, extraDataKey, arguments);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api24Impl;", "", "()V", "addSetProgressAction", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class Api24Impl {
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @JvmStatic
        public static final void addSetProgressAction(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            AccessibilityAction it;
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode) && (it = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetProgress())) != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908349, it.getLabel()));
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api28Impl;", "", "()V", "setScrollEventDelta", "", "event", "Landroid/view/accessibility/AccessibilityEvent;", "deltaX", "", "deltaY", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class Api28Impl {
        public static final Api28Impl INSTANCE = new Api28Impl();

        private Api28Impl() {
        }

        @JvmStatic
        public static final void setScrollEventDelta(AccessibilityEvent event, int deltaX, int deltaY) {
            Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
            event.setScrollDeltaX(deltaX);
            event.setScrollDeltaY(deltaY);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api29Impl;", "", "()V", "addPageActions", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class Api29Impl {
        public static final Api29Impl INSTANCE = new Api29Impl();

        private Api29Impl() {
        }

        @JvmStatic
        public static final void addPageActions(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                AccessibilityAction it = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageUp());
                if (it != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908358, it.getLabel()));
                }
                AccessibilityAction it2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageDown());
                if (it2 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908359, it2.getLabel()));
                }
                AccessibilityAction it3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageLeft());
                if (it3 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908360, it3.getLabel()));
                }
                AccessibilityAction it4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageRight());
                if (it4 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908361, it4.getLabel()));
                }
            }
        }
    }
}
