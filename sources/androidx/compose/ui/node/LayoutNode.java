package androidx.compose.ui.node;

import android.view.View;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusTargetModifierNode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierCore;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Ð\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\bB\b\u0000\u0018\u0000 Ú\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\bÚ\u0002Û\u0002Ü\u0002Ý\u0002B\u0019\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001a\u0010Ù\u0001\u001a\u00030©\u00012\b\u0010³\u0001\u001a\u00030¨\u0001H\u0000¢\u0006\u0003\bÚ\u0001J\u0010\u0010Û\u0001\u001a\u00030©\u0001H\u0000¢\u0006\u0003\bÜ\u0001J\u0010\u0010Ý\u0001\u001a\u00030©\u0001H\u0000¢\u0006\u0003\bÞ\u0001J\u0010\u0010ß\u0001\u001a\u00030©\u0001H\u0000¢\u0006\u0003\bà\u0001J\n\u0010á\u0001\u001a\u00030©\u0001H\u0002J\u0014\u0010â\u0001\u001a\u00030ã\u00012\b\b\u0002\u00106\u001a\u00020\u000bH\u0002J\u0010\u0010ä\u0001\u001a\u00030©\u0001H\u0000¢\u0006\u0003\bå\u0001J\u0010\u0010æ\u0001\u001a\u00030©\u0001H\u0000¢\u0006\u0003\bç\u0001J\u001a\u0010è\u0001\u001a\u00030©\u00012\b\u0010é\u0001\u001a\u00030ê\u0001H\u0000¢\u0006\u0003\bë\u0001J%\u0010ì\u0001\u001a\u00030©\u00012\u0015\u0010í\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030©\u00010§\u0001H\bø\u0001\u0000J+\u0010î\u0001\u001a\u00030©\u00012\u001b\u0010í\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030©\u00010ï\u0001H\bø\u0001\u0000J#\u0010ð\u0001\u001a\u00030©\u00012\u0016\u0010í\u0001\u001a\u0011\u0012\u0005\u0012\u00030ñ\u0001\u0012\u0005\u0012\u00030©\u00010§\u0001H\bJ\"\u0010ò\u0001\u001a\u00030©\u00012\u0015\u0010í\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0005\u0012\u00030©\u00010§\u0001H\bJ\n\u0010ó\u0001\u001a\u00030©\u0001H\u0016J\u0013\u0010ô\u0001\u001a\f\u0018\u00010õ\u0001j\u0005\u0018\u0001`ö\u0001H\u0017J\u0010\u0010÷\u0001\u001a\t\u0012\u0005\u0012\u00030ø\u00010\"H\u0016JJ\u0010ù\u0001\u001a\u00030©\u00012\b\u0010ú\u0001\u001a\u00030û\u00012\u000f\u0010ü\u0001\u001a\n\u0012\u0005\u0012\u00030þ\u00010ý\u00012\t\b\u0002\u0010ÿ\u0001\u001a\u00020\t2\t\b\u0002\u0010\u0002\u001a\u00020\tH\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\b\u0002\u0010\u0002JJ\u0010\u0002\u001a\u00030©\u00012\b\u0010ú\u0001\u001a\u00030û\u00012\u000f\u0010\u0002\u001a\n\u0012\u0005\u0012\u00030\u00020ý\u00012\t\b\u0002\u0010ÿ\u0001\u001a\u00020\t2\t\b\u0002\u0010\u0002\u001a\u00020\tH\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\b\u0002\u0010\u0002J$\u0010A\u001a\u00030©\u00012\u000f\u0010í\u0001\u001a\n\u0012\u0005\u0012\u00030©\u00010\u0002H\bø\u0001\u0000¢\u0006\u0003\b\u0002J\"\u0010\u0002\u001a\u00030©\u00012\u0007\u0010\u0002\u001a\u00020\u000b2\u0007\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0003\b\u0002J\n\u0010\u0002\u001a\u00030©\u0001H\u0002J\n\u0010\u0002\u001a\u00030©\u0001H\u0002J\u0010\u0010\u0002\u001a\u00030©\u0001H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030©\u0001H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030©\u0001H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030©\u0001H\u0000¢\u0006\u0003\b\u0002J\u0013\u0010\u0002\u001a\u00030©\u00012\t\b\u0002\u0010\u0002\u001a\u00020\tJ\n\u0010\u0002\u001a\u00030©\u0001H\u0002J#\u0010\u0002\u001a\u00020\t2\f\b\u0002\u0010\u0002\u001a\u0005\u0018\u00010\u0002H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030©\u0001H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010 \u0002\u001a\u00030©\u0001H\u0000¢\u0006\u0003\b¡\u0002J\u0010\u0010¢\u0002\u001a\u00030©\u0001H\u0000¢\u0006\u0003\b£\u0002J\u0010\u0010¤\u0002\u001a\u00030©\u0001H\u0000¢\u0006\u0003\b¥\u0002J\u0010\u0010¦\u0002\u001a\u00030©\u0001H\u0000¢\u0006\u0003\b§\u0002J\n\u0010¨\u0002\u001a\u00030©\u0001H\u0002J\n\u0010©\u0002\u001a\u00030©\u0001H\u0002J+\u0010ª\u0002\u001a\u00030©\u00012\u0007\u0010«\u0002\u001a\u00020\u000b2\u0007\u0010¬\u0002\u001a\u00020\u000b2\u0007\u0010­\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\b®\u0002J\u0013\u0010¯\u0002\u001a\u00030©\u00012\u0007\u0010°\u0002\u001a\u00020\u0000H\u0002J\n\u0010±\u0002\u001a\u00030©\u0001H\u0016J\n\u0010²\u0002\u001a\u00030©\u0001H\u0002J\n\u0010³\u0002\u001a\u00030©\u0001H\u0016J\u0010\u0010´\u0002\u001a\u00030©\u0001H\u0000¢\u0006\u0003\bµ\u0002J\n\u0010¶\u0002\u001a\u00030©\u0001H\u0016J\n\u0010·\u0002\u001a\u00030©\u0001H\u0016J\u0010\u0010¸\u0002\u001a\u00030©\u0001H\u0000¢\u0006\u0003\b¹\u0002J\"\u0010º\u0002\u001a\u00030©\u00012\u0007\u0010»\u0002\u001a\u00020\u000b2\u0007\u0010¼\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\b½\u0002J\n\u0010¾\u0002\u001a\u00030©\u0001H\u0002J#\u0010¿\u0002\u001a\u00020\t2\f\b\u0002\u0010\u0002\u001a\u0005\u0018\u00010\u0002H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0003\bÀ\u0002J\u0010\u0010Á\u0002\u001a\u00030©\u0001H\u0000¢\u0006\u0003\bÂ\u0002J\"\u0010Ã\u0002\u001a\u00030©\u00012\u0007\u0010\u0002\u001a\u00020\u000b2\u0007\u0010­\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\bÄ\u0002J\u0010\u0010Å\u0002\u001a\u00030©\u0001H\u0000¢\u0006\u0003\bÆ\u0002J\u001b\u0010Ç\u0002\u001a\u00030©\u00012\t\b\u0002\u0010È\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÉ\u0002J\u001b\u0010Ê\u0002\u001a\u00030©\u00012\t\b\u0002\u0010È\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bË\u0002J\u001b\u0010Ì\u0002\u001a\u00030©\u00012\t\b\u0002\u0010È\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÍ\u0002J\u001b\u0010Î\u0002\u001a\u00030©\u00012\t\b\u0002\u0010È\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÏ\u0002J\u0019\u0010Ð\u0002\u001a\u00030©\u00012\u0007\u0010Ñ\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0003\bÒ\u0002J\n\u0010Ó\u0002\u001a\u00030©\u0001H\u0002J\u0010\u0010Ô\u0002\u001a\u00030©\u0001H\u0000¢\u0006\u0003\bÕ\u0002J\t\u0010Ö\u0002\u001a\u00020\tH\u0002J\n\u0010×\u0002\u001a\u00030ã\u0001H\u0016J\u0010\u0010Ø\u0002\u001a\u00030©\u0001H\u0000¢\u0006\u0003\bÙ\u0002R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\t8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"8@X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8@X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00000\"8@X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010%R\u0014\u0010*\u001a\u00020+8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R$\u00101\u001a\u0002002\u0006\u0010/\u001a\u000200@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00000\"8@X\u0004¢\u0006\u0006\u001a\u0004\b<\u0010%R\u0014\u0010=\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u001aR\u0014\u0010?\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b@\u00108R\u000e\u0010A\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\u00020\u00158@X\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0016\u0010E\u001a\u0004\u0018\u00010\u00158BX\u0004¢\u0006\u0006\u001a\u0004\bF\u0010DR\u001a\u0010G\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u001a\"\u0004\bI\u0010 R\"\u0010J\u001a\n\u0018\u00010Kj\u0004\u0018\u0001`LX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020RX\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0014\u0010[\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\u001aR$\u0010\\\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u001a\"\u0004\b]\u0010 R\u001e\u0010_\u001a\u00020\t2\u0006\u0010^\u001a\u00020\t@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\u001aR\u0013\u0010`\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0014\u0010b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\bb\u0010\u001aR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010c\u001a\u00020dX\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR$\u0010h\u001a\u00020g2\u0006\u0010/\u001a\u00020g@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u0014\u0010m\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\bn\u0010\u001aR\u0014\u0010o\u001a\u00020p8@X\u0004¢\u0006\u0006\u001a\u0004\bq\u0010rR\u0014\u0010s\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\bt\u0010\u001aR\u0014\u0010u\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\bv\u0010\u001aR\u001a\u0010w\u001a\b\u0018\u00010xR\u00020d8BX\u0004¢\u0006\u0006\u001a\u0004\by\u0010zR\u0014\u0010{\u001a\u00020|8@X\u0004¢\u0006\u0006\u001a\u0004\b}\u0010~R/\u0010\u0001\u001a\u0005\u0018\u00010\u00012\t\u0010\u001a\u0005\u0018\u00010\u0001@BX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u00070\u0001R\u00020d8BX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0016\u0010\u0001\u001a\u00020\t8@X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u001aR+\u0010\u0001\u001a\u00030\u00012\u0007\u0010/\u001a\u00030\u0001@VX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020VX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010X\"\u0005\b\u0001\u0010ZR\u001d\u0010\u0001\u001a\u00020VX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010X\"\u0005\b\u0001\u0010ZR+\u0010\u0001\u001a\u00030\u00012\u0007\u0010/\u001a\u00030\u0001@VX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020\tX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001a\"\u0005\b \u0001\u0010 R\u000f\u0010¡\u0001\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010¢\u0001\u001a\u00030£\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b¤\u0001\u0010¥\u0001R0\u0010¦\u0001\u001a\u0013\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030©\u0001\u0018\u00010§\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010­\u0001R0\u0010®\u0001\u001a\u0013\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030©\u0001\u0018\u00010§\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¯\u0001\u0010«\u0001\"\u0006\b°\u0001\u0010­\u0001R\u0016\u0010±\u0001\u001a\u00020\u00158@X\u0004¢\u0006\u0007\u001a\u0005\b²\u0001\u0010DR'\u0010³\u0001\u001a\u0005\u0018\u00010¨\u00012\t\u0010^\u001a\u0005\u0018\u00010¨\u0001@BX\u000e¢\u0006\n\n\u0000\u001a\u0006\b´\u0001\u0010µ\u0001R\u0019\u0010¶\u0001\u001a\u0004\u0018\u00010\u00008@X\u0004¢\u0006\b\u001a\u0006\b·\u0001\u0010¸\u0001R\u0019\u0010¹\u0001\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\b\u001a\u0006\bº\u0001\u0010»\u0001R \u0010¼\u0001\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020\u000b@BX\u000e¢\u0006\t\n\u0000\u001a\u0005\b½\u0001\u00108R\u000f\u0010¾\u0001\u001a\u00020VX\u000e¢\u0006\u0002\n\u0000R \u0010¿\u0001\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020\u000b@BX\u000e¢\u0006\t\n\u0000\u001a\u0005\bÀ\u0001\u00108R\u000f\u0010Á\u0001\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\t\n\u0000\u001a\u0005\bÂ\u0001\u00108R\"\u0010Ã\u0001\u001a\u0005\u0018\u00010Ä\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÅ\u0001\u0010Æ\u0001\"\u0006\bÇ\u0001\u0010È\u0001R\u000f\u0010É\u0001\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R \u0010Ê\u0001\u001a\u00030Ë\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÌ\u0001\u0010Í\u0001\"\u0006\bÎ\u0001\u0010Ï\u0001R\u000f\u0010Ð\u0001\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Ñ\u0001\u001a\u00020\u000b8VX\u0004¢\u0006\u0007\u001a\u0005\bÒ\u0001\u00108R\u0010\u0010Ó\u0001\u001a\u00030Ô\u0001X\u000e¢\u0006\u0002\n\u0000R#\u0010Õ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8@X\u0004¢\u0006\u000e\u0012\u0005\bÖ\u0001\u0010\u001d\u001a\u0005\b×\u0001\u0010\u0010R\u000f\u0010Ø\u0001\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000\u0002\u0012\n\u0005\b20\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006Þ\u0002"}, d2 = {"Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "Landroidx/compose/ui/layout/Remeasurement;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/layout/LayoutInfo;", "Landroidx/compose/ui/node/ComposeUiNode;", "Landroidx/compose/ui/node/InteroperableComposeUiNode;", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "isVirtual", "", "semanticsId", "", "(ZI)V", "_children", "Landroidx/compose/runtime/collection/MutableVector;", "get_children$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "_foldedChildren", "Landroidx/compose/ui/node/MutableVectorWithMutationTracking;", "_foldedParent", "_innerLayerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "_unfoldedChildren", "_zSortedChildren", "alignmentLinesRequired", "getAlignmentLinesRequired$ui_release", "()Z", "canMultiMeasure", "getCanMultiMeasure$ui_release$annotations", "()V", "getCanMultiMeasure$ui_release", "setCanMultiMeasure$ui_release", "(Z)V", "childLookaheadMeasurables", "", "Landroidx/compose/ui/layout/Measurable;", "getChildLookaheadMeasurables$ui_release", "()Ljava/util/List;", "childMeasurables", "getChildMeasurables$ui_release", "children", "getChildren$ui_release", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "deactivated", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "depth", "getDepth$ui_release", "()I", "setDepth$ui_release", "(I)V", "foldedChildren", "getFoldedChildren$ui_release", "hasFixedInnerContentConstraints", "getHasFixedInnerContentConstraints$ui_release", "height", "getHeight", "ignoreRemeasureRequests", "innerCoordinator", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "innerLayerCoordinator", "getInnerLayerCoordinator", "innerLayerCoordinatorIsDirty", "getInnerLayerCoordinatorIsDirty$ui_release", "setInnerLayerCoordinatorIsDirty$ui_release", "interopViewFactoryHolder", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/viewinterop/InteropViewFactoryHolder;", "getInteropViewFactoryHolder$ui_release", "()Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "setInteropViewFactoryHolder$ui_release", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;)V", "intrinsicsPolicy", "Landroidx/compose/ui/node/IntrinsicsPolicy;", "getIntrinsicsPolicy$ui_release", "()Landroidx/compose/ui/node/IntrinsicsPolicy;", "intrinsicsUsageByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getIntrinsicsUsageByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setIntrinsicsUsageByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "isAttached", "isLookaheadRoot", "setLookaheadRoot", "<set-?>", "isPlaced", "isPlacedInLookahead", "()Ljava/lang/Boolean;", "isValidOwnerScope", "layoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "getLayoutDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutPending", "getLayoutPending$ui_release", "layoutState", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui_release", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui_release", "lookaheadPassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "getLookaheadPassDelegate", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "mDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getMDrawScope$ui_release", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "newScope", "Landroidx/compose/ui/layout/LookaheadScope;", "mLookaheadScope", "getMLookaheadScope$ui_release", "()Landroidx/compose/ui/layout/LookaheadScope;", "setMLookaheadScope", "(Landroidx/compose/ui/layout/LookaheadScope;)V", "measurePassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measurePending", "getMeasurePending$ui_release", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "measuredByParent", "getMeasuredByParent$ui_release", "setMeasuredByParent$ui_release", "measuredByParentInLookahead", "getMeasuredByParentInLookahead$ui_release", "setMeasuredByParentInLookahead$ui_release", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "needsOnPositionedDispatch", "getNeedsOnPositionedDispatch$ui_release", "setNeedsOnPositionedDispatch$ui_release", "nextChildPlaceOrder", "nodes", "Landroidx/compose/ui/node/NodeChain;", "getNodes$ui_release", "()Landroidx/compose/ui/node/NodeChain;", "onAttach", "Lkotlin/Function1;", "Landroidx/compose/ui/node/Owner;", "", "getOnAttach$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnAttach$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onDetach", "getOnDetach$ui_release", "setOnDetach$ui_release", "outerCoordinator", "getOuterCoordinator$ui_release", "owner", "getOwner$ui_release", "()Landroidx/compose/ui/node/Owner;", "parent", "getParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "parentInfo", "getParentInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "placeOrder", "getPlaceOrder$ui_release", "previousIntrinsicsUsageByParent", "previousPlaceOrder", "getPreviousPlaceOrder$ui_release", "relayoutWithoutParentInProgress", "getSemanticsId", "subcompositionsState", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "getSubcompositionsState$ui_release", "()Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "setSubcompositionsState$ui_release", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "unfoldedVirtualChildrenListDirty", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "setViewConfiguration", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "virtualChildrenCount", "width", "getWidth", "zIndex", "", "zSortedChildren", "getZSortedChildren$annotations", "getZSortedChildren", "zSortedChildrenInvalidated", "attach", "attach$ui_release", "checkChildrenPlaceOrderForUpdates", "checkChildrenPlaceOrderForUpdates$ui_release", "clearPlaceOrder", "clearPlaceOrder$ui_release", "clearSubtreeIntrinsicsUsage", "clearSubtreeIntrinsicsUsage$ui_release", "clearSubtreePlacementIntrinsicsUsage", "debugTreeToString", "", "detach", "detach$ui_release", "dispatchOnPositionedCallbacks", "dispatchOnPositionedCallbacks$ui_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "draw$ui_release", "forEachChild", "block", "forEachChildIndexed", "Lkotlin/Function2;", "forEachCoordinator", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "forEachCoordinatorIncludingInner", "forceRemeasure", "getInteropView", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/InteropView;", "getModifierInfo", "Landroidx/compose/ui/layout/ModifierInfo;", "hitTest", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "isTouchEvent", "isInLayer", "hitTest-M_7yMNQ$ui_release", "(JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestSemantics", "hitSemanticsEntities", "Landroidx/compose/ui/node/SemanticsModifierNode;", "hitTestSemantics-M_7yMNQ$ui_release", "Lkotlin/Function0;", "ignoreRemeasureRequests$ui_release", "insertAt", "index", "instance", "insertAt$ui_release", "invalidateFocusOnAttach", "invalidateFocusOnDetach", "invalidateLayer", "invalidateLayer$ui_release", "invalidateLayers", "invalidateLayers$ui_release", "invalidateMeasurements", "invalidateMeasurements$ui_release", "invalidateParentData", "invalidateParentData$ui_release", "invalidateSubtree", "isRootOfInvalidation", "invalidateUnfoldedVirtualChildren", "lookaheadRemeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "lookaheadRemeasure-_Sx5XlM$ui_release", "lookaheadReplace", "lookaheadReplace$ui_release", "markLayoutPending", "markLayoutPending$ui_release", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui_release", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui_release", "markMeasurePending", "markMeasurePending$ui_release", "markNodeAndSubtreeAsPlaced", "markSubtreeAsNotPlaced", "move", "from", "to", "count", "move$ui_release", "onChildRemoved", "child", "onDeactivate", "onDensityOrLayoutDirectionChanged", "onLayoutComplete", "onNodePlaced", "onNodePlaced$ui_release", "onRelease", "onReuse", "onZSortedChildrenInvalidated", "onZSortedChildrenInvalidated$ui_release", "place", "x", "y", "place$ui_release", "recreateUnfoldedChildrenIfDirty", "remeasure", "remeasure-_Sx5XlM$ui_release", "removeAll", "removeAll$ui_release", "removeAt", "removeAt$ui_release", "replace", "replace$ui_release", "requestLookaheadRelayout", "forceRequest", "requestLookaheadRelayout$ui_release", "requestLookaheadRemeasure", "requestLookaheadRemeasure$ui_release", "requestRelayout", "requestRelayout$ui_release", "requestRemeasure", "requestRemeasure$ui_release", "rescheduleRemeasureOrRelayout", "it", "rescheduleRemeasureOrRelayout$ui_release", "resetModifierState", "resetSubtreeIntrinsicsUsage", "resetSubtreeIntrinsicsUsage$ui_release", "shouldInvalidateParentLayer", "toString", "updateChildrenIfDirty", "updateChildrenIfDirty$ui_release", "Companion", "LayoutState", "NoIntrinsicsMeasurePolicy", "UsageByParent", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNode.kt */
public final class LayoutNode implements ComposeNodeLifecycleCallback, Remeasurement, OwnerScope, LayoutInfo, ComposeUiNode, InteroperableComposeUiNode, Owner.OnLayoutCompletedListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Function0<LayoutNode> Constructor = LayoutNode$Companion$Constructor$1.INSTANCE;
    /* access modifiers changed from: private */
    public static final ViewConfiguration DummyViewConfiguration = new LayoutNode$Companion$DummyViewConfiguration$1();
    private static final NoIntrinsicsMeasurePolicy ErrorMeasurePolicy = new LayoutNode$Companion$ErrorMeasurePolicy$1();
    public static final int NotPlacedPlaceOrder = Integer.MAX_VALUE;
    /* access modifiers changed from: private */
    public static final Comparator<LayoutNode> ZComparator = new LayoutNode$$ExternalSyntheticLambda0();
    private final MutableVectorWithMutationTracking<LayoutNode> _foldedChildren;
    private LayoutNode _foldedParent;
    private NodeCoordinator _innerLayerCoordinator;
    private MutableVector<LayoutNode> _unfoldedChildren;
    private final MutableVector<LayoutNode> _zSortedChildren;
    private boolean canMultiMeasure;
    private boolean deactivated;
    private Density density;
    private int depth;
    /* access modifiers changed from: private */
    public boolean ignoreRemeasureRequests;
    private boolean innerLayerCoordinatorIsDirty;
    private AndroidViewHolder interopViewFactoryHolder;
    private final IntrinsicsPolicy intrinsicsPolicy;
    private UsageByParent intrinsicsUsageByParent;
    private boolean isLookaheadRoot;
    private boolean isPlaced;
    private final boolean isVirtual;
    private final LayoutNodeLayoutDelegate layoutDelegate;
    private LayoutDirection layoutDirection;
    private LookaheadScope mLookaheadScope;
    private MeasurePolicy measurePolicy;
    private UsageByParent measuredByParent;
    private UsageByParent measuredByParentInLookahead;
    private Modifier modifier;
    private boolean needsOnPositionedDispatch;
    private int nextChildPlaceOrder;
    private final NodeChain nodes;
    private Function1<? super Owner, Unit> onAttach;
    private Function1<? super Owner, Unit> onDetach;
    private Owner owner;
    private int placeOrder;
    private UsageByParent previousIntrinsicsUsageByParent;
    private int previousPlaceOrder;
    private boolean relayoutWithoutParentInProgress;
    private final int semanticsId;
    private LayoutNodeSubcompositionsState subcompositionsState;
    private boolean unfoldedVirtualChildrenListDirty;
    private ViewConfiguration viewConfiguration;
    private int virtualChildrenCount;
    private float zIndex;
    private boolean zSortedChildrenInvalidated;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$LayoutState;", "", "(Ljava/lang/String;I)V", "Measuring", "LookaheadMeasuring", "LayingOut", "LookaheadLayingOut", "Idle", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public enum LayoutState {
        Measuring,
        LookaheadMeasuring,
        LayingOut,
        LookaheadLayingOut,
        Idle
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "", "(Ljava/lang/String;I)V", "InMeasureBlock", "InLayoutBlock", "NotUsed", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public enum UsageByParent {
        InMeasureBlock,
        InLayoutBlock,
        NotUsed
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutState.values().length];
            try {
                iArr[LayoutState.Idle.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LayoutNode() {
        this(false, 0, 3, (DefaultConstructorMarker) null);
    }

    @Deprecated(message = "Temporary API to support ConstraintLayout prototyping.")
    public static /* synthetic */ void getCanMultiMeasure$ui_release$annotations() {
    }

    public static /* synthetic */ void getZSortedChildren$annotations() {
    }

    public LayoutNode(boolean isVirtual2, int semanticsId2) {
        this.isVirtual = isVirtual2;
        this.semanticsId = semanticsId2;
        this._foldedChildren = new MutableVectorWithMutationTracking<>(new MutableVector(new LayoutNode[16], 0), new LayoutNode$_foldedChildren$1(this));
        this._zSortedChildren = new MutableVector<>(new LayoutNode[16], 0);
        this.zSortedChildrenInvalidated = true;
        this.measurePolicy = ErrorMeasurePolicy;
        this.intrinsicsPolicy = new IntrinsicsPolicy(this);
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null);
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = DummyViewConfiguration;
        this.placeOrder = Integer.MAX_VALUE;
        this.previousPlaceOrder = Integer.MAX_VALUE;
        this.measuredByParent = UsageByParent.NotUsed;
        this.measuredByParentInLookahead = UsageByParent.NotUsed;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        this.previousIntrinsicsUsageByParent = UsageByParent.NotUsed;
        this.nodes = new NodeChain(this);
        this.layoutDelegate = new LayoutNodeLayoutDelegate(this);
        this.innerLayerCoordinatorIsDirty = true;
        this.modifier = Modifier.Companion;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LayoutNode(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? SemanticsModifierCore.Companion.generateSemanticsId() : i);
    }

    public int getSemanticsId() {
        return this.semanticsId;
    }

    public final Boolean isPlacedInLookahead() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        if (lookaheadPassDelegate != null) {
            return Boolean.valueOf(lookaheadPassDelegate.isPlaced());
        }
        return null;
    }

    public final List<LayoutNode> getFoldedChildren$ui_release() {
        return this._foldedChildren.asList();
    }

    private final void recreateUnfoldedChildrenIfDirty() {
        if (this.unfoldedVirtualChildrenListDirty) {
            this.unfoldedVirtualChildrenListDirty = false;
            MutableVector mutableVector = this._unfoldedChildren;
            if (mutableVector == null) {
                MutableVector it = new MutableVector(new LayoutNode[16], 0);
                this._unfoldedChildren = it;
                mutableVector = it;
            }
            MutableVector unfoldedChildren = mutableVector;
            unfoldedChildren.clear();
            MutableVector this_$iv$iv = this._foldedChildren.getVector();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    LayoutNode it2 = (LayoutNode) content$iv$iv[i$iv$iv];
                    if (it2.isVirtual) {
                        MutableVector this_$iv = unfoldedChildren;
                        this_$iv.addAll(this_$iv.getSize(), it2.get_children$ui_release());
                    } else {
                        unfoldedChildren.add(it2);
                    }
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
            this.layoutDelegate.markChildrenDirty();
        }
    }

    public final List<Measurable> getChildMeasurables$ui_release() {
        return getMeasurePassDelegate().getChildMeasurables$ui_release();
    }

    public final List<Measurable> getChildLookaheadMeasurables$ui_release() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        Intrinsics.checkNotNull(lookaheadPassDelegate);
        return lookaheadPassDelegate.getChildMeasurables$ui_release();
    }

    private final void invalidateUnfoldedVirtualChildren() {
        LayoutNode parent$ui_release;
        if (this.virtualChildrenCount > 0) {
            this.unfoldedVirtualChildrenListDirty = true;
        }
        if (this.isVirtual && (parent$ui_release = getParent$ui_release()) != null) {
            parent$ui_release.unfoldedVirtualChildrenListDirty = true;
        }
    }

    public final MutableVector<LayoutNode> get_children$ui_release() {
        updateChildrenIfDirty$ui_release();
        if (this.virtualChildrenCount == 0) {
            return this._foldedChildren.getVector();
        }
        MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
        Intrinsics.checkNotNull(mutableVector);
        return mutableVector;
    }

    public final void updateChildrenIfDirty$ui_release() {
        if (this.virtualChildrenCount > 0) {
            recreateUnfoldedChildrenIfDirty();
        }
    }

    public final void forEachChild(Function1<? super LayoutNode, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        MutableVector this_$iv = get_children$ui_release();
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                block.invoke(content$iv[i$iv]);
                i$iv++;
            } while (i$iv < size$iv);
        }
    }

    public final void forEachChildIndexed(Function2<? super Integer, ? super LayoutNode, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        MutableVector this_$iv = get_children$ui_release();
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                block.invoke(Integer.valueOf(i$iv), content$iv[i$iv]);
                i$iv++;
            } while (i$iv < size$iv);
        }
    }

    public final List<LayoutNode> getChildren$ui_release() {
        return get_children$ui_release().asMutableList();
    }

    public final LayoutNode getParent$ui_release() {
        LayoutNode layoutNode = this._foldedParent;
        boolean z = false;
        if (layoutNode != null && layoutNode.isVirtual) {
            z = true;
        }
        if (!z) {
            return layoutNode;
        }
        if (layoutNode != null) {
            return layoutNode.getParent$ui_release();
        }
        return null;
    }

    public final Owner getOwner$ui_release() {
        return this.owner;
    }

    public final AndroidViewHolder getInteropViewFactoryHolder$ui_release() {
        return this.interopViewFactoryHolder;
    }

    public final void setInteropViewFactoryHolder$ui_release(AndroidViewHolder androidViewHolder) {
        this.interopViewFactoryHolder = androidViewHolder;
    }

    public View getInteropView() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            return androidViewHolder.getInteropView();
        }
        return null;
    }

    public boolean isAttached() {
        return this.owner != null;
    }

    public final int getDepth$ui_release() {
        return this.depth;
    }

    public final void setDepth$ui_release(int i) {
        this.depth = i;
    }

    public final LayoutState getLayoutState$ui_release() {
        return this.layoutDelegate.getLayoutState$ui_release();
    }

    private final LayoutNodeLayoutDelegate.LookaheadPassDelegate getLookaheadPassDelegate() {
        return this.layoutDelegate.getLookaheadPassDelegate$ui_release();
    }

    private final LayoutNodeLayoutDelegate.MeasurePassDelegate getMeasurePassDelegate() {
        return this.layoutDelegate.getMeasurePassDelegate$ui_release();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1, types: [androidx.compose.ui.node.NodeCoordinator] */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: type inference failed for: r5v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void insertAt$ui_release(int r13, androidx.compose.ui.node.LayoutNode r14) {
        /*
            r12 = this;
            java.lang.String r0 = "instance"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            androidx.compose.ui.node.LayoutNode r0 = r14._foldedParent
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x000e
            r0 = r2
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            java.lang.String r3 = " Other tree: "
            java.lang.String r4 = "Cannot insert "
            r5 = 0
            if (r0 != 0) goto L_0x0051
            r0 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r4 = r6.append(r4)
            java.lang.StringBuilder r4 = r4.append(r14)
            java.lang.String r6 = " because it already has a parent. This tree: "
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r6 = debugTreeToString$default(r12, r1, r2, r5)
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.StringBuilder r3 = r4.append(r3)
            androidx.compose.ui.node.LayoutNode r4 = r14._foldedParent
            if (r4 == 0) goto L_0x003f
            java.lang.String r5 = debugTreeToString$default(r4, r1, r2, r5)
        L_0x003f:
            java.lang.StringBuilder r1 = r3.append(r5)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0051:
            androidx.compose.ui.node.Owner r0 = r14.owner
            if (r0 != 0) goto L_0x0057
            r0 = r2
            goto L_0x0058
        L_0x0057:
            r0 = r1
        L_0x0058:
            if (r0 == 0) goto L_0x00e6
            r14._foldedParent = r12
            androidx.compose.ui.node.MutableVectorWithMutationTracking<androidx.compose.ui.node.LayoutNode> r0 = r12._foldedChildren
            r0.add(r13, r14)
            r12.onZSortedChildrenInvalidated$ui_release()
            boolean r0 = r14.isVirtual
            if (r0 == 0) goto L_0x0082
            boolean r0 = r12.isVirtual
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x0074
            int r0 = r12.virtualChildrenCount
            int r0 = r0 + r2
            r12.virtualChildrenCount = r0
            goto L_0x0082
        L_0x0074:
            r0 = 0
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Virtual LayoutNode can't be added into a virtual parent"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0082:
            r12.invalidateUnfoldedVirtualChildren()
            androidx.compose.ui.node.NodeCoordinator r0 = r14.getOuterCoordinator$ui_release()
            boolean r1 = r12.isVirtual
            if (r1 == 0) goto L_0x0096
            androidx.compose.ui.node.LayoutNode r1 = r12._foldedParent
            if (r1 == 0) goto L_0x009a
            androidx.compose.ui.node.NodeCoordinator r5 = r1.getInnerCoordinator$ui_release()
            goto L_0x009a
        L_0x0096:
            androidx.compose.ui.node.NodeCoordinator r5 = r12.getInnerCoordinator$ui_release()
        L_0x009a:
            r0.setWrappedBy$ui_release(r5)
            boolean r0 = r14.isVirtual
            if (r0 == 0) goto L_0x00cc
            androidx.compose.ui.node.MutableVectorWithMutationTracking<androidx.compose.ui.node.LayoutNode> r0 = r14._foldedChildren
            r1 = 0
            androidx.compose.runtime.collection.MutableVector r3 = r0.getVector()
            r4 = 0
            int r5 = r3.getSize()
            if (r5 <= 0) goto L_0x00ca
            r6 = 0
            java.lang.Object[] r7 = r3.getContent()
        L_0x00b5:
            r8 = r7[r6]
            androidx.compose.ui.node.LayoutNode r8 = (androidx.compose.ui.node.LayoutNode) r8
            r9 = 0
            androidx.compose.ui.node.NodeCoordinator r10 = r8.getOuterCoordinator$ui_release()
            androidx.compose.ui.node.NodeCoordinator r11 = r12.getInnerCoordinator$ui_release()
            r10.setWrappedBy$ui_release(r11)
            int r6 = r6 + r2
            if (r6 < r5) goto L_0x00b5
        L_0x00ca:
        L_0x00cc:
            androidx.compose.ui.node.Owner r0 = r12.owner
            if (r0 == 0) goto L_0x00d3
            r14.attach$ui_release(r0)
        L_0x00d3:
            androidx.compose.ui.node.LayoutNodeLayoutDelegate r1 = r14.layoutDelegate
            int r1 = r1.getChildrenAccessingCoordinatesDuringPlacement()
            if (r1 <= 0) goto L_0x00e5
            androidx.compose.ui.node.LayoutNodeLayoutDelegate r1 = r12.layoutDelegate
            int r3 = r1.getChildrenAccessingCoordinatesDuringPlacement()
            int r3 = r3 + r2
            r1.setChildrenAccessingCoordinatesDuringPlacement(r3)
        L_0x00e5:
            return
        L_0x00e6:
            r0 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r4 = r6.append(r4)
            java.lang.StringBuilder r4 = r4.append(r14)
            java.lang.String r6 = " because it already has an owner. This tree: "
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r6 = debugTreeToString$default(r12, r1, r2, r5)
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.String r1 = debugTreeToString$default(r14, r1, r2, r5)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.insertAt$ui_release(int, androidx.compose.ui.node.LayoutNode):void");
    }

    public final void onZSortedChildrenInvalidated$ui_release() {
        if (this.isVirtual) {
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                parent$ui_release.onZSortedChildrenInvalidated$ui_release();
                return;
            }
            return;
        }
        this.zSortedChildrenInvalidated = true;
    }

    public final void removeAt$ui_release(int index, int count) {
        if (count >= 0) {
            int i = (index + count) - 1;
            if (index <= i) {
                while (true) {
                    onChildRemoved(this._foldedChildren.removeAt(i));
                    if (i != index) {
                        i--;
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException(("count (" + count + ") must be greater than 0").toString());
        }
    }

    public final void removeAll$ui_release() {
        int i = this._foldedChildren.getSize();
        while (true) {
            i--;
            if (-1 < i) {
                onChildRemoved(this._foldedChildren.get(i));
            } else {
                this._foldedChildren.clear();
                return;
            }
        }
    }

    private final void onChildRemoved(LayoutNode child) {
        if (child.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
            layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() - 1);
        }
        if (this.owner != null) {
            child.detach$ui_release();
        }
        child._foldedParent = null;
        child.getOuterCoordinator$ui_release().setWrappedBy$ui_release((NodeCoordinator) null);
        if (child.isVirtual) {
            this.virtualChildrenCount--;
            MutableVector this_$iv$iv = child._foldedChildren.getVector();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    ((LayoutNode) content$iv$iv[i$iv$iv]).getOuterCoordinator$ui_release().setWrappedBy$ui_release((NodeCoordinator) null);
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }
        invalidateUnfoldedVirtualChildren();
        onZSortedChildrenInvalidated$ui_release();
    }

    public final void move$ui_release(int from, int to, int count) {
        if (from != to) {
            for (int i = 0; i < count; i++) {
                this._foldedChildren.add(from > to ? to + i : (to + count) - 2, this._foldedChildren.removeAt(from > to ? from + i : from));
            }
            onZSortedChildrenInvalidated$ui_release();
            invalidateUnfoldedVirtualChildren();
            invalidateMeasurements$ui_release();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: androidx.compose.ui.layout.LookaheadScope} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void attach$ui_release(androidx.compose.ui.node.Owner r12) {
        /*
            r11 = this;
            java.lang.String r0 = "owner"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            androidx.compose.ui.node.Owner r0 = r11.owner
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x000e
            r0 = r2
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            r3 = 0
            if (r0 == 0) goto L_0x010d
            androidx.compose.ui.node.LayoutNode r0 = r11._foldedParent
            if (r0 == 0) goto L_0x0025
            if (r0 == 0) goto L_0x001b
            androidx.compose.ui.node.Owner r0 = r0.owner
            goto L_0x001c
        L_0x001b:
            r0 = r3
        L_0x001c:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r12)
            if (r0 == 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r0 = r1
            goto L_0x0026
        L_0x0025:
            r0 = r2
        L_0x0026:
            if (r0 != 0) goto L_0x007b
            r0 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Attaching to a different owner("
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r12)
            java.lang.String r5 = ") than the parent's owner("
            java.lang.StringBuilder r4 = r4.append(r5)
            androidx.compose.ui.node.LayoutNode r5 = r11.getParent$ui_release()
            if (r5 == 0) goto L_0x0047
            androidx.compose.ui.node.Owner r5 = r5.owner
            goto L_0x0048
        L_0x0047:
            r5 = r3
        L_0x0048:
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = "). This tree: "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = debugTreeToString$default(r11, r1, r2, r3)
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = " Parent tree: "
            java.lang.StringBuilder r4 = r4.append(r5)
            androidx.compose.ui.node.LayoutNode r5 = r11._foldedParent
            if (r5 == 0) goto L_0x0069
            java.lang.String r3 = debugTreeToString$default(r5, r1, r2, r3)
        L_0x0069:
            java.lang.StringBuilder r1 = r4.append(r3)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x007b:
            androidx.compose.ui.node.LayoutNode r0 = r11.getParent$ui_release()
            if (r0 != 0) goto L_0x0083
            r11.isPlaced = r2
        L_0x0083:
            r11.owner = r12
            if (r0 == 0) goto L_0x008a
            int r4 = r0.depth
            goto L_0x008b
        L_0x008a:
            r4 = -1
        L_0x008b:
            int r4 = r4 + r2
            r11.depth = r4
            androidx.compose.ui.node.SemanticsModifierNode r4 = androidx.compose.ui.semantics.SemanticsNodeKt.getOuterSemantics(r11)
            if (r4 == 0) goto L_0x0097
            r12.onSemanticsChange()
        L_0x0097:
            r12.onAttach(r11)
            if (r0 == 0) goto L_0x00a4
            androidx.compose.ui.layout.LookaheadScope r4 = r0.mLookaheadScope
            if (r4 != 0) goto L_0x00a2
            goto L_0x00a4
        L_0x00a2:
            r3 = r4
            goto L_0x00ad
        L_0x00a4:
            boolean r4 = r11.isLookaheadRoot
            if (r4 == 0) goto L_0x00ad
            androidx.compose.ui.layout.LookaheadScope r3 = new androidx.compose.ui.layout.LookaheadScope
            r3.<init>(r11)
        L_0x00ad:
            r11.setMLookaheadScope(r3)
            androidx.compose.ui.node.NodeChain r3 = r11.nodes
            r3.attach(r1)
            androidx.compose.ui.node.MutableVectorWithMutationTracking<androidx.compose.ui.node.LayoutNode> r1 = r11._foldedChildren
            r3 = 0
            androidx.compose.runtime.collection.MutableVector r4 = r1.getVector()
            r5 = 0
            int r6 = r4.getSize()
            if (r6 <= 0) goto L_0x00d6
            r7 = 0
            java.lang.Object[] r8 = r4.getContent()
        L_0x00c9:
            r9 = r8[r7]
            androidx.compose.ui.node.LayoutNode r9 = (androidx.compose.ui.node.LayoutNode) r9
            r10 = 0
            r9.attach$ui_release(r12)
            int r7 = r7 + r2
            if (r7 < r6) goto L_0x00c9
        L_0x00d6:
            r11.invalidateMeasurements$ui_release()
            if (r0 == 0) goto L_0x00e0
            r0.invalidateMeasurements$ui_release()
        L_0x00e0:
            r1 = r11
            r2 = 0
            androidx.compose.ui.node.NodeCoordinator r3 = r1.getOuterCoordinator$ui_release()
            androidx.compose.ui.node.NodeCoordinator r4 = r1.getInnerCoordinator$ui_release()
            androidx.compose.ui.node.NodeCoordinator r4 = r4.getWrapped$ui_release()
        L_0x00ee:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r5 != 0) goto L_0x0101
            if (r3 == 0) goto L_0x0101
            r5 = r3
            r6 = 0
            r5.onLayoutNodeAttach()
            androidx.compose.ui.node.NodeCoordinator r3 = r3.getWrapped$ui_release()
            goto L_0x00ee
        L_0x0101:
            kotlin.jvm.functions.Function1<? super androidx.compose.ui.node.Owner, kotlin.Unit> r1 = r11.onAttach
            if (r1 == 0) goto L_0x0109
            r1.invoke(r12)
        L_0x0109:
            r11.invalidateFocusOnAttach()
            return
        L_0x010d:
            r0 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Cannot attach "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r11)
            java.lang.String r5 = " as it already is attached.  Tree: "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r1 = debugTreeToString$default(r11, r1, r2, r3)
            java.lang.StringBuilder r1 = r4.append(r1)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.attach$ui_release(androidx.compose.ui.node.Owner):void");
    }

    public final void detach$ui_release() {
        Owner owner2 = this.owner;
        String str = null;
        if (owner2 == null) {
            StringBuilder append = new StringBuilder().append("Cannot detach node that is already detached!  Tree: ");
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                str = debugTreeToString$default(parent$ui_release, 0, 1, (Object) null);
            }
            throw new IllegalStateException(append.append(str).toString().toString());
        }
        invalidateFocusOnDetach();
        LayoutNode parent = getParent$ui_release();
        if (parent != null) {
            parent.invalidateLayer$ui_release();
            parent.invalidateMeasurements$ui_release();
            this.measuredByParent = UsageByParent.NotUsed;
        }
        this.layoutDelegate.resetAlignmentLines();
        Function1<? super Owner, Unit> function1 = this.onDetach;
        if (function1 != null) {
            function1.invoke(owner2);
        }
        if (SemanticsNodeKt.getOuterSemantics(this) != null) {
            owner2.onSemanticsChange();
        }
        this.nodes.detach$ui_release();
        owner2.onDetach(this);
        this.owner = null;
        this.depth = 0;
        MutableVector this_$iv$iv = this._foldedChildren.getVector();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                ((LayoutNode) content$iv$iv[i$iv$iv]).detach$ui_release();
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
        this.placeOrder = Integer.MAX_VALUE;
        this.previousPlaceOrder = Integer.MAX_VALUE;
        this.isPlaced = false;
    }

    public final MutableVector<LayoutNode> getZSortedChildren() {
        if (this.zSortedChildrenInvalidated) {
            this._zSortedChildren.clear();
            MutableVector this_$iv = this._zSortedChildren;
            this_$iv.addAll(this_$iv.getSize(), get_children$ui_release());
            this._zSortedChildren.sortWith(ZComparator);
            this.zSortedChildrenInvalidated = false;
        }
        return this._zSortedChildren;
    }

    public boolean isValidOwnerScope() {
        return isAttached();
    }

    public String toString() {
        return JvmActuals_jvmKt.simpleIdentityToString(this, (String) null) + " children: " + getChildren$ui_release().size() + " measurePolicy: " + getMeasurePolicy();
    }

    public final boolean getHasFixedInnerContentConstraints$ui_release() {
        long innerContentConstraints = getInnerCoordinator$ui_release().m5093getLastMeasurementConstraintsmsEJaDk$ui_release();
        return Constraints.m5928getHasFixedWidthimpl(innerContentConstraints) && Constraints.m5927getHasFixedHeightimpl(innerContentConstraints);
    }

    static /* synthetic */ String debugTreeToString$default(LayoutNode layoutNode, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return layoutNode.debugTreeToString(i);
    }

    private final String debugTreeToString(int depth2) {
        StringBuilder tree = new StringBuilder();
        for (int i = 0; i < depth2; i++) {
            tree.append("  ");
        }
        tree.append("|-");
        tree.append(toString());
        tree.append(10);
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                tree.append(((LayoutNode) content$iv$iv[i$iv$iv]).debugTreeToString(depth2 + 1));
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
        String treeString = tree.toString();
        Intrinsics.checkNotNullExpressionValue(treeString, "tree.toString()");
        if (depth2 != 0) {
            return treeString;
        }
        String treeString2 = treeString.substring(0, treeString.length() - 1);
        Intrinsics.checkNotNullExpressionValue(treeString2, "this as java.lang.String…ing(startIndex, endIndex)");
        return treeString2;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\"\u0010\u000f\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u0010\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "error", "", "(Ljava/lang/String;)V", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public static abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {
        private final String error;

        public NoIntrinsicsMeasurePolicy(String error2) {
            Intrinsics.checkNotNullParameter(error2, "error");
            this.error = error2;
        }

        public Void minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
            Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        public Void minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
            Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        public Void maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
            Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        public Void maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
            Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }
    }

    public MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    public void setMeasurePolicy(MeasurePolicy value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual((Object) this.measurePolicy, (Object) value)) {
            this.measurePolicy = value;
            this.intrinsicsPolicy.updateFrom(getMeasurePolicy());
            invalidateMeasurements$ui_release();
        }
    }

    public final IntrinsicsPolicy getIntrinsicsPolicy$ui_release() {
        return this.intrinsicsPolicy;
    }

    public Density getDensity() {
        return this.density;
    }

    public void setDensity(Density value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual((Object) this.density, (Object) value)) {
            this.density = value;
            onDensityOrLayoutDirectionChanged();
        }
    }

    public final LookaheadScope getMLookaheadScope$ui_release() {
        return this.mLookaheadScope;
    }

    private final void setMLookaheadScope(LookaheadScope newScope) {
        if (!Intrinsics.areEqual((Object) newScope, (Object) this.mLookaheadScope)) {
            this.mLookaheadScope = newScope;
            this.layoutDelegate.onLookaheadScopeChanged$ui_release(newScope);
            NodeCoordinator delegate$iv = getOuterCoordinator$ui_release();
            NodeCoordinator final$iv = getInnerCoordinator$ui_release().getWrapped$ui_release();
            while (!Intrinsics.areEqual((Object) delegate$iv, (Object) final$iv) && delegate$iv != null) {
                delegate$iv.updateLookaheadScope$ui_release(newScope);
                delegate$iv = delegate$iv.getWrapped$ui_release();
            }
        }
    }

    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public void setLayoutDirection(LayoutDirection value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.layoutDirection != value) {
            this.layoutDirection = value;
            onDensityOrLayoutDirectionChanged();
        }
    }

    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public void setViewConfiguration(ViewConfiguration viewConfiguration2) {
        Intrinsics.checkNotNullParameter(viewConfiguration2, "<set-?>");
        this.viewConfiguration = viewConfiguration2;
    }

    private final void onDensityOrLayoutDirectionChanged() {
        invalidateMeasurements$ui_release();
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        invalidateLayers$ui_release();
    }

    public int getWidth() {
        return this.layoutDelegate.getWidth$ui_release();
    }

    public int getHeight() {
        return this.layoutDelegate.getHeight$ui_release();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        r2 = r2.getAlignmentLines();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean getAlignmentLinesRequired$ui_release() {
        /*
            r5 = this;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = r5.layoutDelegate
            r1 = 0
            androidx.compose.ui.node.AlignmentLinesOwner r2 = r0.getAlignmentLinesOwner$ui_release()
            androidx.compose.ui.node.AlignmentLines r2 = r2.getAlignmentLines()
            boolean r2 = r2.getRequired$ui_release()
            r3 = 1
            if (r2 != 0) goto L_0x002d
            androidx.compose.ui.node.AlignmentLinesOwner r2 = r0.getLookaheadAlignmentLinesOwner$ui_release()
            r4 = 0
            if (r2 == 0) goto L_0x0027
            androidx.compose.ui.node.AlignmentLines r2 = r2.getAlignmentLines()
            if (r2 == 0) goto L_0x0027
            boolean r2 = r2.getRequired$ui_release()
            if (r2 != r3) goto L_0x0027
            r2 = r3
            goto L_0x0028
        L_0x0027:
            r2 = r4
        L_0x0028:
            if (r2 == 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r3 = r4
            goto L_0x002e
        L_0x002d:
        L_0x002e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.getAlignmentLinesRequired$ui_release():boolean");
    }

    public final LayoutNodeDrawScope getMDrawScope$ui_release() {
        return LayoutNodeKt.requireOwner(this).getSharedDrawScope();
    }

    public boolean isPlaced() {
        return this.isPlaced;
    }

    public final int getPlaceOrder$ui_release() {
        return this.placeOrder;
    }

    public final int getPreviousPlaceOrder$ui_release() {
        return this.previousPlaceOrder;
    }

    public final UsageByParent getMeasuredByParent$ui_release() {
        return this.measuredByParent;
    }

    public final void setMeasuredByParent$ui_release(UsageByParent usageByParent) {
        Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
        this.measuredByParent = usageByParent;
    }

    public final UsageByParent getMeasuredByParentInLookahead$ui_release() {
        return this.measuredByParentInLookahead;
    }

    public final void setMeasuredByParentInLookahead$ui_release(UsageByParent usageByParent) {
        Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
        this.measuredByParentInLookahead = usageByParent;
    }

    public final UsageByParent getIntrinsicsUsageByParent$ui_release() {
        return this.intrinsicsUsageByParent;
    }

    public final void setIntrinsicsUsageByParent$ui_release(UsageByParent usageByParent) {
        Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
        this.intrinsicsUsageByParent = usageByParent;
    }

    public final boolean getCanMultiMeasure$ui_release() {
        return this.canMultiMeasure;
    }

    public final void setCanMultiMeasure$ui_release(boolean z) {
        this.canMultiMeasure = z;
    }

    public final boolean isLookaheadRoot() {
        return this.isLookaheadRoot;
    }

    public final void setLookaheadRoot(boolean value) {
        if (value != this.isLookaheadRoot) {
            if (!value) {
                setMLookaheadScope((LookaheadScope) null);
            } else {
                setMLookaheadScope(new LookaheadScope(this));
            }
            this.isLookaheadRoot = value;
        }
    }

    public final NodeChain getNodes$ui_release() {
        return this.nodes;
    }

    public final NodeCoordinator getInnerCoordinator$ui_release() {
        return this.nodes.getInnerCoordinator$ui_release();
    }

    public final LayoutNodeLayoutDelegate getLayoutDelegate$ui_release() {
        return this.layoutDelegate;
    }

    public final NodeCoordinator getOuterCoordinator$ui_release() {
        return this.nodes.getOuterCoordinator$ui_release();
    }

    public final LayoutNodeSubcompositionsState getSubcompositionsState$ui_release() {
        return this.subcompositionsState;
    }

    public final void setSubcompositionsState$ui_release(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState) {
        this.subcompositionsState = layoutNodeSubcompositionsState;
    }

    public final boolean getInnerLayerCoordinatorIsDirty$ui_release() {
        return this.innerLayerCoordinatorIsDirty;
    }

    public final void setInnerLayerCoordinatorIsDirty$ui_release(boolean z) {
        this.innerLayerCoordinatorIsDirty = z;
    }

    private final NodeCoordinator getInnerLayerCoordinator() {
        if (this.innerLayerCoordinatorIsDirty) {
            NodeCoordinator coordinator = getInnerCoordinator$ui_release();
            NodeCoordinator wrappedBy$ui_release = getOuterCoordinator$ui_release().getWrappedBy$ui_release();
            this._innerLayerCoordinator = null;
            while (true) {
                if (Intrinsics.areEqual((Object) coordinator, (Object) wrappedBy$ui_release)) {
                    break;
                }
                if ((coordinator != null ? coordinator.getLayer() : null) != null) {
                    this._innerLayerCoordinator = coordinator;
                    break;
                }
                coordinator = coordinator != null ? coordinator.getWrappedBy$ui_release() : null;
            }
        }
        NodeCoordinator layerCoordinator = this._innerLayerCoordinator;
        if (layerCoordinator == null || layerCoordinator.getLayer() != null) {
            return layerCoordinator;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void invalidateLayer$ui_release() {
        NodeCoordinator innerLayerCoordinator = getInnerLayerCoordinator();
        if (innerLayerCoordinator != null) {
            innerLayerCoordinator.invalidateLayer();
            return;
        }
        LayoutNode parent = getParent$ui_release();
        if (parent != null) {
            parent.invalidateLayer$ui_release();
        }
    }

    public Modifier getModifier() {
        return this.modifier;
    }

    public void setModifier(Modifier value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!this.isVirtual || getModifier() == Modifier.Companion) {
            this.modifier = value;
            this.nodes.updateFrom$ui_release(value);
            NodeCoordinator delegate$iv = getOuterCoordinator$ui_release();
            NodeCoordinator final$iv = getInnerCoordinator$ui_release().getWrapped$ui_release();
            while (!Intrinsics.areEqual((Object) delegate$iv, (Object) final$iv) && delegate$iv != null) {
                delegate$iv.updateLookaheadScope$ui_release(this.mLookaheadScope);
                delegate$iv = delegate$iv.getWrapped$ui_release();
            }
            this.layoutDelegate.updateParentData();
            return;
        }
        throw new IllegalArgumentException("Modifiers are not supported on virtual LayoutNodes".toString());
    }

    private final void resetModifierState() {
        this.nodes.resetState$ui_release();
    }

    public final void invalidateParentData$ui_release() {
        this.layoutDelegate.invalidateParentData();
    }

    public LayoutCoordinates getCoordinates() {
        return getInnerCoordinator$ui_release();
    }

    public final Function1<Owner, Unit> getOnAttach$ui_release() {
        return this.onAttach;
    }

    public final void setOnAttach$ui_release(Function1<? super Owner, Unit> function1) {
        this.onAttach = function1;
    }

    public final Function1<Owner, Unit> getOnDetach$ui_release() {
        return this.onDetach;
    }

    public final void setOnDetach$ui_release(Function1<? super Owner, Unit> function1) {
        this.onDetach = function1;
    }

    public final boolean getNeedsOnPositionedDispatch$ui_release() {
        return this.needsOnPositionedDispatch;
    }

    public final void setNeedsOnPositionedDispatch$ui_release(boolean z) {
        this.needsOnPositionedDispatch = z;
    }

    public final void place$ui_release(int x, int y) {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNodeLayoutDelegate.MeasurePassDelegate $this$place_u24lambda_u2420 = getMeasurePassDelegate();
        Placeable.PlacementScope.Companion this_$iv = Placeable.PlacementScope.Companion;
        int parentWidth$iv = $this$place_u24lambda_u2420.getMeasuredWidth();
        LayoutDirection parentLayoutDirection$iv = getLayoutDirection();
        LayoutNode parent$ui_release = getParent$ui_release();
        LookaheadCapablePlaceable lookaheadCapablePlaceable$iv = parent$ui_release != null ? parent$ui_release.getInnerCoordinator$ui_release() : null;
        LayoutCoordinates previousLayoutCoordinates$iv = Placeable.PlacementScope._coordinates;
        int previousParentWidth$iv = Placeable.PlacementScope.Companion.getParentWidth();
        LayoutDirection previousParentLayoutDirection$iv = Placeable.PlacementScope.Companion.getParentLayoutDirection();
        LayoutNodeLayoutDelegate previousLayoutDelegate$iv = Placeable.PlacementScope.layoutDelegate;
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentWidth = parentWidth$iv;
        Placeable.PlacementScope.Companion companion2 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentLayoutDirection = parentLayoutDirection$iv;
        boolean wasPlacingForAlignment$iv = this_$iv.configureForPlacingForAlignment(lookaheadCapablePlaceable$iv);
        Placeable.PlacementScope.placeRelative$default(this_$iv, $this$place_u24lambda_u2420, x, y, 0.0f, 4, (Object) null);
        if (lookaheadCapablePlaceable$iv != null) {
            lookaheadCapablePlaceable$iv.setPlacingForAlignment$ui_release(wasPlacingForAlignment$iv);
        }
        Placeable.PlacementScope.Companion companion3 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentWidth = previousParentWidth$iv;
        Placeable.PlacementScope.Companion companion4 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentLayoutDirection = previousParentLayoutDirection$iv;
        Placeable.PlacementScope._coordinates = previousLayoutCoordinates$iv;
        Placeable.PlacementScope.layoutDelegate = previousLayoutDelegate$iv;
    }

    /* JADX INFO: finally extract failed */
    public final void replace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        try {
            this.relayoutWithoutParentInProgress = true;
            getMeasurePassDelegate().replace();
            this.relayoutWithoutParentInProgress = false;
        } catch (Throwable th) {
            this.relayoutWithoutParentInProgress = false;
            throw th;
        }
    }

    public final void lookaheadReplace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        Intrinsics.checkNotNull(lookaheadPassDelegate);
        lookaheadPassDelegate.replace();
    }

    public final void draw$ui_release(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getOuterCoordinator$ui_release().draw(canvas);
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release$default  reason: not valid java name */
    public static /* synthetic */ void m4995hitTestM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2, int i, Object obj) {
        boolean z3;
        boolean z4;
        if ((i & 4) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i & 8) != 0) {
            z4 = true;
        } else {
            z4 = z2;
        }
        layoutNode.m4999hitTestM_7yMNQ$ui_release(j, hitTestResult, z3, z4);
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release  reason: not valid java name */
    public final void m4999hitTestM_7yMNQ$ui_release(long pointerPosition, HitTestResult<PointerInputModifierNode> hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        getOuterCoordinator$ui_release().m5100hitTestYqVAtuI(NodeCoordinator.Companion.getPointerInputSource(), getOuterCoordinator$ui_release().m5092fromParentPositionMKHz9U(pointerPosition), hitTestResult, isTouchEvent, isInLayer);
    }

    /* renamed from: hitTestSemantics-M_7yMNQ$ui_release$default  reason: not valid java name */
    public static /* synthetic */ void m4996hitTestSemanticsM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2, int i, Object obj) {
        boolean z3;
        boolean z4;
        if ((i & 4) != 0) {
            z3 = true;
        } else {
            z3 = z;
        }
        if ((i & 8) != 0) {
            z4 = true;
        } else {
            z4 = z2;
        }
        layoutNode.m5000hitTestSemanticsM_7yMNQ$ui_release(j, hitTestResult, z3, z4);
    }

    /* renamed from: hitTestSemantics-M_7yMNQ$ui_release  reason: not valid java name */
    public final void m5000hitTestSemanticsM_7yMNQ$ui_release(long pointerPosition, HitTestResult<SemanticsModifierNode> hitSemanticsEntities, boolean isTouchEvent, boolean isInLayer) {
        Intrinsics.checkNotNullParameter(hitSemanticsEntities, "hitSemanticsEntities");
        getOuterCoordinator$ui_release().m5100hitTestYqVAtuI(NodeCoordinator.Companion.getSemanticsSource(), getOuterCoordinator$ui_release().m5092fromParentPositionMKHz9U(pointerPosition), hitSemanticsEntities, true, isInLayer);
    }

    public final void onNodePlaced$ui_release() {
        LayoutNode parent = getParent$ui_release();
        float newZIndex = getInnerCoordinator$ui_release().getZIndex();
        NodeCoordinator inner$iv = getInnerCoordinator$ui_release();
        for (NodeCoordinator coordinator$iv = getOuterCoordinator$ui_release(); coordinator$iv != inner$iv; coordinator$iv = ((LayoutModifierNodeCoordinator) coordinator$iv).getWrapped$ui_release()) {
            Intrinsics.checkNotNull(coordinator$iv, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            newZIndex += ((LayoutModifierNodeCoordinator) coordinator$iv).getZIndex();
        }
        boolean z = false;
        if (!(newZIndex == this.zIndex)) {
            this.zIndex = newZIndex;
            if (parent != null) {
                parent.onZSortedChildrenInvalidated$ui_release();
            }
            if (parent != null) {
                parent.invalidateLayer$ui_release();
            }
        }
        if (!isPlaced()) {
            if (parent != null) {
                parent.invalidateLayer$ui_release();
            }
            markNodeAndSubtreeAsPlaced();
        }
        if (parent == null) {
            this.placeOrder = 0;
        } else if (!this.relayoutWithoutParentInProgress && parent.getLayoutState$ui_release() == LayoutState.LayingOut) {
            if (this.placeOrder == Integer.MAX_VALUE) {
                z = true;
            }
            if (z) {
                int i = parent.nextChildPlaceOrder;
                this.placeOrder = i;
                parent.nextChildPlaceOrder = i + 1;
            } else {
                throw new IllegalStateException("Place was called on a node which was placed already".toString());
            }
        }
        this.layoutDelegate.getAlignmentLinesOwner$ui_release().layoutChildren();
    }

    public final void clearPlaceOrder$ui_release() {
        this.nextChildPlaceOrder = 0;
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                LayoutNode child = (LayoutNode) content$iv$iv[i$iv$iv];
                child.previousPlaceOrder = child.placeOrder;
                child.placeOrder = Integer.MAX_VALUE;
                if (child.measuredByParent == UsageByParent.InLayoutBlock) {
                    child.measuredByParent = UsageByParent.NotUsed;
                }
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
    }

    public final void checkChildrenPlaceOrderForUpdates$ui_release() {
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                LayoutNode child = (LayoutNode) content$iv$iv[i$iv$iv];
                if (child.previousPlaceOrder != child.placeOrder) {
                    onZSortedChildrenInvalidated$ui_release();
                    invalidateLayer$ui_release();
                    if (child.placeOrder == Integer.MAX_VALUE) {
                        child.markSubtreeAsNotPlaced();
                    }
                }
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
    }

    private final void markNodeAndSubtreeAsPlaced() {
        boolean wasPlaced = isPlaced();
        this.isPlaced = true;
        if (!wasPlaced) {
            if (getMeasurePending$ui_release()) {
                requestRemeasure$ui_release(true);
            } else if (getLookaheadMeasurePending$ui_release()) {
                requestLookaheadRemeasure$ui_release(true);
            }
        }
        NodeCoordinator delegate$iv = getOuterCoordinator$ui_release();
        NodeCoordinator final$iv = getInnerCoordinator$ui_release().getWrapped$ui_release();
        while (!Intrinsics.areEqual((Object) delegate$iv, (Object) final$iv) && delegate$iv != null) {
            NodeCoordinator it = delegate$iv;
            if (it.getLastLayerDrawingWasSkipped$ui_release()) {
                it.invalidateLayer();
            }
            delegate$iv = delegate$iv.getWrapped$ui_release();
        }
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                LayoutNode it2 = (LayoutNode) content$iv$iv[i$iv$iv];
                if (it2.placeOrder != Integer.MAX_VALUE) {
                    it2.markNodeAndSubtreeAsPlaced();
                    rescheduleRemeasureOrRelayout$ui_release(it2);
                }
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
    }

    public final void rescheduleRemeasureOrRelayout$ui_release(LayoutNode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (WhenMappings.$EnumSwitchMapping$0[it.getLayoutState$ui_release().ordinal()] != 1) {
            throw new IllegalStateException("Unexpected state " + it.getLayoutState$ui_release());
        } else if (it.getMeasurePending$ui_release()) {
            it.requestRemeasure$ui_release(true);
        } else if (it.getLayoutPending$ui_release()) {
            it.requestRelayout$ui_release(true);
        } else if (it.getLookaheadMeasurePending$ui_release()) {
            it.requestLookaheadRemeasure$ui_release(true);
        } else if (it.getLookaheadLayoutPending$ui_release()) {
            it.requestLookaheadRelayout$ui_release(true);
        }
    }

    private final void markSubtreeAsNotPlaced() {
        if (isPlaced()) {
            this.isPlaced = false;
            MutableVector this_$iv$iv = get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    ((LayoutNode) content$iv$iv[i$iv$iv]).markSubtreeAsNotPlaced();
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }
    }

    public static /* synthetic */ void requestRemeasure$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestRemeasure$ui_release(z);
    }

    public final void requestRemeasure$ui_release(boolean forceRequest) {
        Owner owner2;
        if (!this.ignoreRemeasureRequests && !this.isVirtual && (owner2 = this.owner) != null) {
            Owner.onRequestMeasure$default(owner2, this, false, forceRequest, 2, (Object) null);
            getMeasurePassDelegate().invalidateIntrinsicsParent(forceRequest);
        }
    }

    public static /* synthetic */ void requestLookaheadRemeasure$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestLookaheadRemeasure$ui_release(z);
    }

    public final void requestLookaheadRemeasure$ui_release(boolean forceRequest) {
        if (this.mLookaheadScope != null) {
            Owner owner2 = this.owner;
            if (owner2 != null && !this.ignoreRemeasureRequests && !this.isVirtual) {
                owner2.onRequestMeasure(this, true, forceRequest);
                LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
                Intrinsics.checkNotNull(lookaheadPassDelegate);
                lookaheadPassDelegate.invalidateIntrinsicsParent(forceRequest);
                return;
            }
            return;
        }
        throw new IllegalStateException("Lookahead measure cannot be requested on a node that is not a part of theLookaheadLayout".toString());
    }

    public final void invalidateMeasurements$ui_release() {
        if (this.mLookaheadScope != null) {
            requestLookaheadRemeasure$ui_release$default(this, false, 1, (Object) null);
        } else {
            requestRemeasure$ui_release$default(this, false, 1, (Object) null);
        }
    }

    private final void invalidateFocusOnAttach() {
        if (this.nodes.has$ui_release(NodeKind.m5123constructorimpl(1024) | NodeKind.m5123constructorimpl(2048) | NodeKind.m5123constructorimpl(4096))) {
            for (Modifier.Node node$iv = this.nodes.getHead$ui_release(); node$iv != null; node$iv = node$iv.getChild$ui_release()) {
                Modifier.Node it = node$iv;
                int i = 1;
                int i2 = ((it.getKindSet$ui_release() & NodeKind.m5123constructorimpl(1024)) != 0 ? 1 : 0) | ((it.getKindSet$ui_release() & NodeKind.m5123constructorimpl(2048)) != 0 ? 1 : 0);
                if ((it.getKindSet$ui_release() & NodeKind.m5123constructorimpl(4096)) == 0) {
                    i = 0;
                }
                if ((i2 | i) != 0) {
                    NodeKindKt.autoInvalidateInsertedNode(it);
                }
            }
        }
    }

    private final void invalidateFocusOnDetach() {
        if (this.nodes.m5073hasH91voCI$ui_release(NodeKind.m5123constructorimpl(1024))) {
            for (Modifier.Node node$iv = this.nodes.getTail$ui_release(); node$iv != null; node$iv = node$iv.getParent$ui_release()) {
                Modifier.Node it = node$iv;
                if (((it.getKindSet$ui_release() & NodeKind.m5123constructorimpl(1024)) != 0 ? 1 : 0) != 0 && (it instanceof FocusTargetModifierNode) && ((FocusTargetModifierNode) it).getFocusState().isFocused()) {
                    LayoutNodeKt.requireOwner(this).getFocusOwner().clearFocus(true, false);
                    ((FocusTargetModifierNode) it).scheduleInvalidationForFocusEvents$ui_release();
                }
            }
        }
    }

    public final void ignoreRemeasureRequests$ui_release(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.ignoreRemeasureRequests = true;
        block.invoke();
        this.ignoreRemeasureRequests = false;
    }

    public static /* synthetic */ void requestRelayout$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestRelayout$ui_release(z);
    }

    public final void requestRelayout$ui_release(boolean forceRequest) {
        Owner owner2;
        if (!this.isVirtual && (owner2 = this.owner) != null) {
            Owner.onRequestRelayout$default(owner2, this, false, forceRequest, 2, (Object) null);
        }
    }

    public static /* synthetic */ void requestLookaheadRelayout$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestLookaheadRelayout$ui_release(z);
    }

    public final void requestLookaheadRelayout$ui_release(boolean forceRequest) {
        Owner owner2;
        if (!this.isVirtual && (owner2 = this.owner) != null) {
            owner2.onRequestRelayout(this, true, forceRequest);
        }
    }

    public final void dispatchOnPositionedCallbacks$ui_release() {
        char c;
        if (getLayoutState$ui_release() == LayoutState.Idle && !getLayoutPending$ui_release() && !getMeasurePending$ui_release() && isPlaced()) {
            NodeChain this_$iv = this.nodes;
            char c2 = 256;
            int mask$iv$iv = NodeKind.m5123constructorimpl(256);
            NodeChain this_$iv$iv = this_$iv;
            if ((this_$iv$iv.getAggregateChildKindSet() & mask$iv$iv) != 0) {
                Modifier.Node node$iv$iv$iv = this_$iv$iv.getHead$ui_release();
                while (node$iv$iv$iv != null) {
                    Modifier.Node it$iv$iv = node$iv$iv$iv;
                    if ((it$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                        Modifier.Node it$iv = it$iv$iv;
                        if (it$iv instanceof GlobalPositionAwareModifierNode) {
                            GlobalPositionAwareModifierNode it = (GlobalPositionAwareModifierNode) it$iv;
                            c = 256;
                            it.onGloballyPositioned(DelegatableNodeKt.m4965requireCoordinator64DMado(it, NodeKind.m5123constructorimpl(256)));
                        } else {
                            c = c2;
                        }
                    } else {
                        c = c2;
                    }
                    if ((it$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        c2 = c;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public List<ModifierInfo> getModifierInfo() {
        return this.nodes.getModifierInfo();
    }

    public final void invalidateLayers$ui_release() {
        NodeCoordinator inner$iv = getInnerCoordinator$ui_release();
        for (NodeCoordinator coordinator$iv = getOuterCoordinator$ui_release(); coordinator$iv != inner$iv; coordinator$iv = ((LayoutModifierNodeCoordinator) coordinator$iv).getWrapped$ui_release()) {
            Intrinsics.checkNotNull(coordinator$iv, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            OwnedLayer layer = ((LayoutModifierNodeCoordinator) coordinator$iv).getLayer();
            if (layer != null) {
                layer.invalidate();
            }
        }
        OwnedLayer layer2 = getInnerCoordinator$ui_release().getLayer();
        if (layer2 != null) {
            layer2.invalidate();
        }
    }

    /* renamed from: lookaheadRemeasure-_Sx5XlM$ui_release$default  reason: not valid java name */
    public static /* synthetic */ boolean m4997lookaheadRemeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m5046getLastLookaheadConstraintsDWUhwKw();
        }
        return layoutNode.m5001lookaheadRemeasure_Sx5XlM$ui_release(constraints);
    }

    /* renamed from: lookaheadRemeasure-_Sx5XlM$ui_release  reason: not valid java name */
    public final boolean m5001lookaheadRemeasure_Sx5XlM$ui_release(Constraints constraints) {
        if (constraints == null || this.mLookaheadScope == null) {
            return false;
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        Intrinsics.checkNotNull(lookaheadPassDelegate);
        return lookaheadPassDelegate.m5050remeasureBRTryo0(constraints.m5936unboximpl());
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release$default  reason: not valid java name */
    public static /* synthetic */ boolean m4998remeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m5045getLastConstraintsDWUhwKw();
        }
        return layoutNode.m5002remeasure_Sx5XlM$ui_release(constraints);
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release  reason: not valid java name */
    public final boolean m5002remeasure_Sx5XlM$ui_release(Constraints constraints) {
        if (constraints == null) {
            return false;
        }
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreeIntrinsicsUsage$ui_release();
        }
        return getMeasurePassDelegate().m5055remeasureBRTryo0(constraints.m5936unboximpl());
    }

    public final boolean getMeasurePending$ui_release() {
        return this.layoutDelegate.getMeasurePending$ui_release();
    }

    public final boolean getLayoutPending$ui_release() {
        return this.layoutDelegate.getLayoutPending$ui_release();
    }

    public final boolean getLookaheadMeasurePending$ui_release() {
        return this.layoutDelegate.getLookaheadMeasurePending$ui_release();
    }

    public final boolean getLookaheadLayoutPending$ui_release() {
        return this.layoutDelegate.getLookaheadLayoutPending$ui_release();
    }

    public final void markLayoutPending$ui_release() {
        this.layoutDelegate.markLayoutPending$ui_release();
    }

    public final void markMeasurePending$ui_release() {
        this.layoutDelegate.markMeasurePending$ui_release();
    }

    public final void markLookaheadLayoutPending$ui_release() {
        this.layoutDelegate.markLookaheadLayoutPending$ui_release();
    }

    public static /* synthetic */ void invalidateSubtree$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        layoutNode.invalidateSubtree(z);
    }

    public final void invalidateSubtree(boolean isRootOfInvalidation) {
        OwnedLayer layer;
        if (isRootOfInvalidation) {
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
            LayoutNodeKt.requireOwner(this).onSemanticsChange();
        }
        requestRemeasure$ui_release$default(this, false, 1, (Object) null);
        NodeChain this_$iv = this.nodes;
        int mask$iv$iv = NodeKind.m5123constructorimpl(2);
        NodeChain this_$iv$iv = this_$iv;
        if ((this_$iv$iv.getAggregateChildKindSet() & mask$iv$iv) != 0) {
            Modifier.Node node$iv$iv$iv = this_$iv$iv.getHead$ui_release();
            while (node$iv$iv$iv != null) {
                Modifier.Node it$iv$iv = node$iv$iv$iv;
                if ((it$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                    Modifier.Node it$iv = it$iv$iv;
                    if ((it$iv instanceof LayoutModifierNode) && (layer = DelegatableNodeKt.m4965requireCoordinator64DMado((LayoutModifierNode) it$iv, NodeKind.m5123constructorimpl(2)).getLayer()) != null) {
                        layer.invalidate();
                    }
                }
                if ((it$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) == 0) {
                    break;
                }
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
            }
        }
        MutableVector this_$iv2 = get_children$ui_release();
        int size$iv = this_$iv2.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv2.getContent();
            do {
                ((LayoutNode) content$iv[i$iv]).invalidateSubtree(false);
                i$iv++;
            } while (i$iv < size$iv);
        }
    }

    public final void markLookaheadMeasurePending$ui_release() {
        this.layoutDelegate.markLookaheadMeasurePending$ui_release();
    }

    public void forceRemeasure() {
        requestRemeasure$ui_release$default(this, false, 1, (Object) null);
        Constraints lastConstraints = this.layoutDelegate.m5045getLastConstraintsDWUhwKw();
        if (lastConstraints != null) {
            Owner owner2 = this.owner;
            if (owner2 != null) {
                owner2.m5176measureAndLayout0kLqBqw(this, lastConstraints.m5936unboximpl());
                return;
            }
            return;
        }
        Owner owner3 = this.owner;
        if (owner3 != null) {
            Owner.measureAndLayout$default(owner3, false, 1, (Object) null);
        }
    }

    public void onLayoutComplete() {
        NodeCoordinator this_$iv = getInnerCoordinator$ui_release();
        int type$iv = NodeKind.m5123constructorimpl(128);
        boolean includeTail$iv$iv = NodeKindKt.m5131getIncludeSelfInTraversalH91voCI(type$iv);
        NodeCoordinator this_$iv$iv = this_$iv;
        int mask$iv$iv = type$iv;
        Modifier.Node stopNode$iv$iv = this_$iv$iv.getTail();
        if (includeTail$iv$iv || (stopNode$iv$iv = stopNode$iv$iv.getParent$ui_release()) != null) {
            Modifier.Node node$iv$iv = this_$iv$iv.headNode(includeTail$iv$iv);
            while (node$iv$iv != null && (node$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                    Modifier.Node it$iv = node$iv$iv;
                    if (it$iv instanceof LayoutAwareModifierNode) {
                        ((LayoutAwareModifierNode) it$iv).onPlaced(getInnerCoordinator$ui_release());
                    }
                }
                if (node$iv$iv != stopNode$iv$iv) {
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    private final void forEachCoordinator(Function1<? super LayoutModifierNodeCoordinator, Unit> block) {
        NodeCoordinator inner = getInnerCoordinator$ui_release();
        for (NodeCoordinator coordinator = getOuterCoordinator$ui_release(); coordinator != inner; coordinator = ((LayoutModifierNodeCoordinator) coordinator).getWrapped$ui_release()) {
            Intrinsics.checkNotNull(coordinator, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            block.invoke((LayoutModifierNodeCoordinator) coordinator);
        }
    }

    private final void forEachCoordinatorIncludingInner(Function1<? super NodeCoordinator, Unit> block) {
        NodeCoordinator delegate = getOuterCoordinator$ui_release();
        NodeCoordinator wrapped$ui_release = getInnerCoordinator$ui_release().getWrapped$ui_release();
        while (!Intrinsics.areEqual((Object) delegate, (Object) wrapped$ui_release) && delegate != null) {
            block.invoke(delegate);
            delegate = delegate.getWrapped$ui_release();
        }
    }

    private final boolean shouldInvalidateParentLayer() {
        if (this.nodes.m5073hasH91voCI$ui_release(NodeKind.m5123constructorimpl(4)) && !this.nodes.m5073hasH91voCI$ui_release(NodeKind.m5123constructorimpl(2))) {
            return true;
        }
        for (Modifier.Node node$iv = this.nodes.getHead$ui_release(); node$iv != null; node$iv = node$iv.getChild$ui_release()) {
            Modifier.Node it = node$iv;
            boolean z = false;
            if (((it.getKindSet$ui_release() & NodeKind.m5123constructorimpl(2)) != 0 ? 1 : 0) != 0 && (it instanceof LayoutModifierNode) && DelegatableNodeKt.m4965requireCoordinator64DMado(it, NodeKind.m5123constructorimpl(2)).getLayer() != null) {
                return false;
            }
            if ((it.getKindSet$ui_release() & NodeKind.m5123constructorimpl(4)) != 0) {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return true;
    }

    public final void clearSubtreeIntrinsicsUsage$ui_release() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                if (it.intrinsicsUsageByParent != UsageByParent.NotUsed) {
                    it.clearSubtreeIntrinsicsUsage$ui_release();
                }
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
    }

    private final void clearSubtreePlacementIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                if (it.intrinsicsUsageByParent == UsageByParent.InLayoutBlock) {
                    it.clearSubtreePlacementIntrinsicsUsage();
                }
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
    }

    public final void resetSubtreeIntrinsicsUsage$ui_release() {
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                UsageByParent usageByParent = it.previousIntrinsicsUsageByParent;
                it.intrinsicsUsageByParent = usageByParent;
                if (usageByParent != UsageByParent.NotUsed) {
                    it.resetSubtreeIntrinsicsUsage$ui_release();
                }
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
    }

    public LayoutInfo getParentInfo() {
        return getParent$ui_release();
    }

    public void onReuse() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onReuse();
        }
        if (this.deactivated) {
            this.deactivated = false;
        } else {
            resetModifierState();
        }
    }

    public void onDeactivate() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onDeactivate();
        }
        this.deactivated = true;
        resetModifierState();
    }

    public void onRelease() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onRelease();
        }
        NodeCoordinator delegate$iv = getOuterCoordinator$ui_release();
        NodeCoordinator final$iv = getInnerCoordinator$ui_release().getWrapped$ui_release();
        while (!Intrinsics.areEqual((Object) delegate$iv, (Object) final$iv) && delegate$iv != null) {
            delegate$iv.onRelease();
            delegate$iv = delegate$iv.getWrapped$ui_release();
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$Companion;", "", "()V", "Constructor", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "getConstructor$ui_release", "()Lkotlin/jvm/functions/Function0;", "DummyViewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getDummyViewConfiguration$ui_release", "()Landroidx/compose/ui/platform/ViewConfiguration;", "ErrorMeasurePolicy", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "NotPlacedPlaceOrder", "", "ZComparator", "Ljava/util/Comparator;", "getZComparator$ui_release", "()Ljava/util/Comparator;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function0<LayoutNode> getConstructor$ui_release() {
            return LayoutNode.Constructor;
        }

        public final ViewConfiguration getDummyViewConfiguration$ui_release() {
            return LayoutNode.DummyViewConfiguration;
        }

        public final Comparator<LayoutNode> getZComparator$ui_release() {
            return LayoutNode.ZComparator;
        }
    }

    /* access modifiers changed from: private */
    public static final int ZComparator$lambda$41(LayoutNode node1, LayoutNode node2) {
        float f = node1.zIndex;
        float f2 = node2.zIndex;
        if (f == f2) {
            return Intrinsics.compare(node1.placeOrder, node2.placeOrder);
        }
        return Float.compare(f, f2);
    }
}
