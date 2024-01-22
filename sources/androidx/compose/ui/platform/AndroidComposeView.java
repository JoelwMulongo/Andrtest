package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AndroidAutofill;
import androidx.compose.ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillCallback;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEvent;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.ui.input.pointer.PointerInputEventProcessorKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.input.pointer.ProcessResult;
import androidx.compose.ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.semantics.SemanticsModifierCore;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.text.input.AndroidTextInputServicePlugin;
import androidx.compose.ui.text.input.PlatformTextInputAdapter;
import androidx.compose.ui.text.input.PlatformTextInputPluginRegistryImpl;
import androidx.compose.ui.text.input.TextInputForTests;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000È\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0019*\u0002\u0001\b\u0001\u0018\u0000 \u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004\u0003\u0003B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010í\u0001\u001a\u00020+2\b\u0010Ð\u0001\u001a\u00030î\u00012\b\u0010ï\u0001\u001a\u00030 \u0001J\u0019\u0010\u001a\u001a\u00020+2\u000f\u0010ð\u0001\u001a\n\u0012\u0005\u0012\u00030ò\u00010ñ\u0001H\u0016J\t\u0010ó\u0001\u001a\u00020RH\u0002J\u0013\u0010ô\u0001\u001a\u00020+H@ø\u0001\u0000¢\u0006\u0003\u0010õ\u0001J!\u0010ö\u0001\u001a\u00020k2\u0007\u0010÷\u0001\u001a\u00020kH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bø\u0001\u0010ù\u0001J!\u0010ú\u0001\u001a\u00020k2\u0007\u0010û\u0001\u001a\u00020kH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bü\u0001\u0010ù\u0001J\u0012\u0010ý\u0001\u001a\u00020R2\u0007\u0010þ\u0001\u001a\u000201H\u0016J\u0012\u0010ÿ\u0001\u001a\u00020R2\u0007\u0010þ\u0001\u001a\u000201H\u0016J\u0012\u0010\u0002\u001a\u00020+2\u0007\u0010\u0002\u001a\u00020\u0001H\u0002J\u001f\u0010\u0002\u001a\u000f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002010\u00022\u0007\u0010\u0002\u001a\u000201H\u0002J.\u0010\u0002\u001a\u00020;2\u0014\u0010\u0002\u001a\u000f\u0012\u0005\u0012\u00030\u0002\u0012\u0004\u0012\u00020+0)2\r\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020+0>H\u0016J\u0013\u0010\u0002\u001a\u00020+2\b\u0010\u0002\u001a\u00030\u0002H\u0014J\u0013\u0010\u0002\u001a\u00020R2\b\u0010\u0002\u001a\u00030\u0001H\u0016J\u0013\u0010\u0002\u001a\u00020R2\b\u0010\u0002\u001a\u00030\u0001H\u0016J\u0013\u0010\u0002\u001a\u00020R2\b\u0010\u0002\u001a\u00030\u0002H\u0016J\u0013\u0010\u0002\u001a\u00020R2\b\u0010\u0002\u001a\u00030\u0001H\u0016J\u001b\u0010\u0002\u001a\u00020+2\b\u0010Ð\u0001\u001a\u00030î\u00012\b\u0010\u0002\u001a\u00030\u0002J\u001f\u0010\u0002\u001a\u0005\u0018\u00010Ñ\u00012\u0007\u0010\u0002\u001a\u0002012\b\u0010\u0002\u001a\u00030Ñ\u0001H\u0002J\u0013\u0010\u0002\u001a\u0005\u0018\u00010Ñ\u00012\u0007\u0010\u0002\u001a\u000201J\u0013\u0010\u0002\u001a\u00020+2\b\u0010ï\u0001\u001a\u00030 \u0001H\u0016J%\u0010\u0002\u001a\u0005\u0018\u00010\u00022\b\u0010\u0002\u001a\u00030\u0002H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J\u0013\u0010\u0002\u001a\u00020+2\b\u0010 \u0002\u001a\u00030¡\u0002H\u0016J&\u0010¢\u0002\u001a\u00030£\u00022\b\u0010\u0002\u001a\u00030\u0001H\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¤\u0002\u0010¥\u0002J\u0013\u0010¦\u0002\u001a\u00020R2\b\u0010\u0002\u001a\u00030\u0001H\u0002J\u001d\u0010§\u0002\u001a\u00020R2\b\u0010\u0002\u001a\u00030\u00012\b\u0010¨\u0002\u001a\u00030\u0001H\u0002J\t\u0010©\u0002\u001a\u00020+H\u0016J\u0013\u0010ª\u0002\u001a\u00020+2\b\u0010«\u0002\u001a\u00030 \u0001H\u0002J\u0013\u0010¬\u0002\u001a\u00020+2\b\u0010«\u0002\u001a\u00030 \u0001H\u0002J\u0013\u0010­\u0002\u001a\u00020R2\b\u0010\u0002\u001a\u00030\u0001H\u0002J\u0013\u0010®\u0002\u001a\u00020R2\b\u0010\u0002\u001a\u00030\u0001H\u0002J\u0013\u0010¯\u0002\u001a\u00020R2\b\u0010\u0002\u001a\u00030\u0001H\u0002J\u0013\u0010°\u0002\u001a\u00020R2\b\u0010\u0002\u001a\u00030\u0001H\u0002J!\u0010±\u0002\u001a\u00020k2\u0007\u0010û\u0001\u001a\u00020kH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b²\u0002\u0010ù\u0001J,\u0010³\u0002\u001a\u00020+2\b\u0010ï\u0001\u001a\u00030 \u00012\b\u0010´\u0002\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bµ\u0002\u0010¶\u0002J\u0012\u0010³\u0002\u001a\u00020+2\u0007\u0010·\u0002\u001a\u00020RH\u0016J\t\u0010¸\u0002\u001a\u00020+H\u0016J!\u0010¹\u0002\u001a\u00020+2\u0007\u0010º\u0002\u001a\u00020;2\u0007\u0010»\u0002\u001a\u00020RH\u0000¢\u0006\u0003\b¼\u0002J\u0013\u0010½\u0002\u001a\u00020+2\b\u0010«\u0002\u001a\u00030 \u0001H\u0016J\t\u0010¾\u0002\u001a\u00020+H\u0014J\t\u0010¿\u0002\u001a\u00020RH\u0016J\u0012\u0010À\u0002\u001a\u00020+2\u0007\u0010Á\u0002\u001a\u00020*H\u0014J\u0016\u0010Â\u0002\u001a\u0005\u0018\u00010Ã\u00022\b\u0010Ä\u0002\u001a\u00030Å\u0002H\u0016J\u0013\u0010Æ\u0002\u001a\u00020+2\b\u0010«\u0002\u001a\u00030 \u0001H\u0016J\t\u0010Ç\u0002\u001a\u00020+H\u0014J\u0013\u0010È\u0002\u001a\u00020+2\b\u0010\u0002\u001a\u00030\u0002H\u0014J\t\u0010É\u0002\u001a\u00020+H\u0016J'\u0010Ê\u0002\u001a\u00020+2\u0007\u0010Ë\u0002\u001a\u00020R2\u0007\u0010þ\u0001\u001a\u0002012\n\u0010Ì\u0002\u001a\u0005\u0018\u00010¡\u0002H\u0014J6\u0010Í\u0002\u001a\u00020+2\u0007\u0010Î\u0002\u001a\u00020R2\u0007\u0010Ï\u0002\u001a\u0002012\u0007\u0010Ð\u0002\u001a\u0002012\u0007\u0010Ñ\u0002\u001a\u0002012\u0007\u0010Ò\u0002\u001a\u000201H\u0014J\u0013\u0010Ó\u0002\u001a\u00020+2\b\u0010ï\u0001\u001a\u00030 \u0001H\u0016J\u001b\u0010Ô\u0002\u001a\u00020+2\u0007\u0010Õ\u0002\u001a\u0002012\u0007\u0010Ö\u0002\u001a\u000201H\u0014J\u001e\u0010×\u0002\u001a\u00020+2\n\u0010Ø\u0002\u001a\u0005\u0018\u00010Ù\u00022\u0007\u0010Ú\u0002\u001a\u000201H\u0016J%\u0010Û\u0002\u001a\u00020+2\b\u0010ï\u0001\u001a\u00030 \u00012\u0007\u0010Ü\u0002\u001a\u00020R2\u0007\u0010Ý\u0002\u001a\u00020RH\u0016J%\u0010Þ\u0002\u001a\u00020+2\b\u0010ï\u0001\u001a\u00030 \u00012\u0007\u0010Ü\u0002\u001a\u00020R2\u0007\u0010Ý\u0002\u001a\u00020RH\u0016J\u0013\u0010ß\u0002\u001a\u00020+2\b\u0010à\u0002\u001a\u00030á\u0002H\u0016J\u0011\u0010â\u0002\u001a\u00020+2\u0006\u0010v\u001a\u000201H\u0016J\t\u0010ã\u0002\u001a\u00020+H\u0016J\u0012\u0010ä\u0002\u001a\u00020+2\u0007\u0010å\u0002\u001a\u00020RH\u0016J\t\u0010æ\u0002\u001a\u00020+H\u0002J\u0013\u0010æ\u0002\u001a\u00020+2\b\u0010\u0002\u001a\u00030\u0001H\u0002J\t\u0010ç\u0002\u001a\u00020+H\u0002J\u0018\u0010è\u0002\u001a\u00020R2\u0007\u0010º\u0002\u001a\u00020;H\u0000¢\u0006\u0003\bé\u0002J\u0018\u0010ê\u0002\u001a\u00020+2\r\u0010ë\u0002\u001a\b\u0012\u0004\u0012\u00020+0>H\u0016J\u0013\u0010ì\u0002\u001a\u00020+2\b\u0010ë\u0002\u001a\u00030í\u0002H\u0016J\u0011\u0010î\u0002\u001a\u00020+2\b\u0010Ð\u0001\u001a\u00030î\u0001J\u0007\u0010ï\u0002\u001a\u00020+J\u0013\u0010ð\u0002\u001a\u00020+2\b\u0010ï\u0001\u001a\u00030 \u0001H\u0016J\u0017\u0010ñ\u0002\u001a\u00020+2\f\b\u0002\u0010ò\u0002\u001a\u0005\u0018\u00010 \u0001H\u0002J!\u0010ó\u0002\u001a\u00020k2\u0007\u0010ô\u0002\u001a\u00020kH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bõ\u0002\u0010ù\u0001J\"\u0010ö\u0002\u001a\u00020R2\b\u0010\u0002\u001a\u00030\u0002H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b÷\u0002\u0010ø\u0002J&\u0010ù\u0002\u001a\u00030£\u00022\b\u0010\u0002\u001a\u00030\u0001H\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bú\u0002\u0010¥\u0002J0\u0010û\u0002\u001a\u00020+2\b\u0010\u0002\u001a\u00030\u00012\u0007\u0010ü\u0002\u001a\u0002012\u0007\u0010ý\u0002\u001a\u00020m2\t\b\u0002\u0010þ\u0002\u001a\u00020RH\u0002J\u001d\u0010ÿ\u0002\u001a\u00020+2\u0014\u0010\u0003\u001a\u000f\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020+0)J\t\u0010\u0003\u001a\u00020RH\u0016J\t\u0010\u0003\u001a\u00020+H\u0002J\u000e\u0010\u0003\u001a\u00020R*\u00030 \u0001H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020%X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R&\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u001e\u00104\u001a\u0002032\u0006\u00102\u001a\u000203@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020;0:X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010<\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020+\u0018\u00010>0=X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\u00020@X\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR+\u0010D\u001a\u00020C2\u0006\u00102\u001a\u00020C8V@RX\u0002¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010K\u001a\u00020L8\u0016X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u000e\u0010Q\u001a\u00020RX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020TX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010U\u001a\u00020VX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010WR\u0014\u0010X\u001a\u00020YX\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0014\u0010\\\u001a\u00020R8VX\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^R\u000e\u0010_\u001a\u00020RX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010`\u001a\u00020a8VX\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR\u000e\u0010d\u001a\u00020RX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010e\u001a\u00020R8VX\u0004¢\u0006\u0006\u001a\u0004\be\u0010^R\u000e\u0010f\u001a\u00020RX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020hX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020RX\u000e¢\u0006\u0002\n\u0000R\u0019\u0010j\u001a\u00020kX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010WR$\u0010l\u001a\u00020m8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bn\u0010N\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u0014\u0010s\u001a\b\u0012\u0004\u0012\u00020;0tX\u0004¢\u0006\u0002\n\u0000R+\u0010v\u001a\u00020u2\u0006\u00102\u001a\u00020u8V@RX\u0002¢\u0006\u0012\n\u0004\b{\u0010J\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u000e\u0010|\u001a\u00020}X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0001\u001a\u00020m8VX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010pR\u0018\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020RX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u001e\u0010\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020+\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020mX\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020+0>X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0005\n\u0003\u0010\u0001R\u0018\u0010\u0001\u001a\u00030 \u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b¡\u0001\u0010¢\u0001R\u0018\u0010£\u0001\u001a\u00030¤\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b¥\u0001\u0010¦\u0001R\u000f\u0010§\u0001\u001a\u00020hX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010¨\u0001\u001a\u00030©\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010ª\u0001\u001a\u00030«\u0001X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010¬\u0001\u001a\u00030­\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b®\u0001\u0010¯\u0001R\u0010\u0010°\u0001\u001a\u00030±\u0001X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010²\u0001\u001a\u00030³\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b´\u0001\u0010µ\u0001R%\u0010¶\u0001\u001a\u00020RX\u000e¢\u0006\u0018\n\u0000\u0012\u0005\b·\u0001\u0010N\u001a\u0005\b¸\u0001\u0010^\"\u0006\b¹\u0001\u0010º\u0001R\u0018\u0010»\u0001\u001a\u00030¼\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b½\u0001\u0010¾\u0001R\u000f\u0010¿\u0001\u001a\u00020RX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010À\u0001\u001a\u0005\u0018\u00010Á\u00018VX\u0004¢\u0006\b\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u0018\u0010Ä\u0001\u001a\u00030Å\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u0018\u0010È\u0001\u001a\u00030É\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bÊ\u0001\u0010Ë\u0001R\u0010\u0010Ì\u0001\u001a\u00030Í\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Î\u0001\u001a\u00030Ï\u0001X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Ð\u0001\u001a\u00030Ñ\u00018VX\u0004¢\u0006\b\u001a\u0006\bÒ\u0001\u0010Ó\u0001R\u0018\u0010Ô\u0001\u001a\u00030Õ\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bÖ\u0001\u0010×\u0001R\u0012\u0010Ø\u0001\u001a\u0005\u0018\u00010Ù\u0001X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010Ú\u0001\u001a\u00030Û\u0001X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0005\n\u0003\u0010Ü\u0001R7\u0010Ý\u0001\u001a\u0005\u0018\u00010\u00012\t\u00102\u001a\u0005\u0018\u00010\u00018F@BX\u0002¢\u0006\u0017\n\u0005\bâ\u0001\u0010J\u001a\u0006\bÞ\u0001\u0010ß\u0001\"\u0006\bà\u0001\u0010á\u0001R\u000f\u0010ã\u0001\u001a\u00020RX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010ä\u0001\u001a\u00030å\u00018VX\u0004¢\u0006\b\u001a\u0006\bæ\u0001\u0010ç\u0001R\u001a\u0010è\u0001\u001a\u00020kX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010WR\u001c\u0010é\u0001\u001a\u00030Û\u0001X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0005\n\u0003\u0010Ü\u0001R\u001b\u0010ê\u0001\u001a\u000201*\u00020*8BX\u0004¢\u0006\b\u001a\u0006\bë\u0001\u0010ì\u0001\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/ViewGroup;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_androidViewsHandler", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "_autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "_inputModeManager", "Landroidx/compose/ui/input/InputModeManagerImpl;", "_windowInfo", "Landroidx/compose/ui/platform/WindowInfoImpl;", "accessibilityDelegate", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "accessibilityManager", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "androidViewsHandler", "getAndroidViewsHandler$ui_release", "()Landroidx/compose/ui/platform/AndroidViewsHandler;", "autofill", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/AndroidClipboardManager;", "configurationChangeObserver", "Lkotlin/Function1;", "Landroid/content/res/Configuration;", "", "getConfigurationChangeObserver", "()Lkotlin/jvm/functions/Function1;", "setConfigurationChangeObserver", "(Lkotlin/jvm/functions/Function1;)V", "currentFontWeightAdjustment", "", "<set-?>", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "desiredPointerIcon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "dirtyLayers", "", "Landroidx/compose/ui/node/OwnedLayer;", "endApplyChangesListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function0;", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "getFocusOwner", "()Landroidx/compose/ui/focus/FocusOwner;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "fontFamilyResolver$delegate", "Landroidx/compose/runtime/MutableState;", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader$annotations", "()V", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "forceUseMatrixCache", "", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "hoverExitReceived", "inputModeManager", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "isDrawingContent", "isLifecycleInResumedState", "isRenderNodeCompatible", "keyInputModifier", "Landroidx/compose/ui/Modifier;", "keyboardModifiersRequireUpdate", "lastDownPointerPosition", "Landroidx/compose/ui/geometry/Offset;", "lastMatrixRecalculationAnimationTime", "", "getLastMatrixRecalculationAnimationTime$ui_release$annotations", "getLastMatrixRecalculationAnimationTime$ui_release", "()J", "setLastMatrixRecalculationAnimationTime$ui_release", "(J)V", "layerCache", "Landroidx/compose/ui/platform/WeakCache;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "matrixToWindow", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "measureAndLayoutDelegate", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "measureIteration", "getMeasureIteration", "modifierLocalManager", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "getModifierLocalManager", "()Landroidx/compose/ui/modifier/ModifierLocalManager;", "motionEventAdapter", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "observationClearRequested", "onMeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "onViewTreeOwnersAvailable", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "platformTextInputPluginRegistry", "Landroidx/compose/ui/text/input/PlatformTextInputPluginRegistryImpl;", "getPlatformTextInputPluginRegistry", "()Landroidx/compose/ui/text/input/PlatformTextInputPluginRegistryImpl;", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "pointerInputEventProcessor", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "postponedDirtyLayers", "previousMotionEvent", "Landroid/view/MotionEvent;", "relayoutTime", "resendMotionEventOnLayout", "resendMotionEventRunnable", "androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "Landroidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1;", "root", "Landroidx/compose/ui/node/LayoutNode;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "rotaryInputModifier", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "semanticsModifier", "Landroidx/compose/ui/semantics/SemanticsModifierCore;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "sendHoverExitEvent", "Ljava/lang/Runnable;", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "superclassInitComplete", "textInputForTests", "Landroidx/compose/ui/text/input/TextInputForTests;", "getTextInputForTests", "()Landroidx/compose/ui/text/input/TextInputForTests;", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "tmpPositionArray", "", "touchModeChangeListener", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "viewLayersContainer", "Landroidx/compose/ui/platform/DrawChildContainer;", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "viewTreeOwners", "getViewTreeOwners", "()Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "setViewTreeOwners", "(Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;)V", "viewTreeOwners$delegate", "wasMeasuredWithMultipleConstraints", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "windowPosition", "windowToViewMatrix", "fontWeightAdjustmentCompat", "getFontWeightAdjustmentCompat", "(Landroid/content/res/Configuration;)I", "addAndroidView", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "layoutNode", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "autofillSupported", "boundsUpdatesEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateLocalPosition", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "(J)J", "calculatePositionInWindow", "localPosition", "calculatePositionInWindow-MK-Hz9U", "canScrollHorizontally", "direction", "canScrollVertically", "clearChildInvalidObservations", "viewGroup", "convertMeasureSpec", "Lkotlin/Pair;", "measureSpec", "createLayer", "drawBlock", "Landroidx/compose/ui/graphics/Canvas;", "invalidateParentLayer", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchGenericMotionEvent", "event", "dispatchHoverEvent", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "motionEvent", "drawAndroidView", "findViewByAccessibilityIdRootedAtCurrentView", "accessibilityId", "currentView", "findViewByAccessibilityIdTraversal", "forceMeasureTheSubtree", "getFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "getFocusDirection-P8AzH3I", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "getFocusedRect", "rect", "Landroid/graphics/Rect;", "handleMotionEvent", "Landroidx/compose/ui/input/pointer/ProcessResult;", "handleMotionEvent-8iAsVTc", "(Landroid/view/MotionEvent;)I", "handleRotaryEvent", "hasChangedDevices", "lastEvent", "invalidateDescendants", "invalidateLayers", "node", "invalidateLayoutNodeMeasurement", "isBadMotionEvent", "isDevicePressEvent", "isInBounds", "isPositionChanged", "localToScreen", "localToScreen-MK-Hz9U", "measureAndLayout", "constraints", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "sendPointerUpdate", "measureAndLayoutForTest", "notifyLayerIsDirty", "layer", "isDirty", "notifyLayerIsDirty$ui_release", "onAttach", "onAttachedToWindow", "onCheckIsTextEditor", "onConfigurationChanged", "newConfig", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onDetach", "onDetachedFromWindow", "onDraw", "onEndApplyChanges", "onFocusChanged", "gainFocus", "previouslyFocusedRect", "onLayout", "changed", "l", "t", "r", "b", "onLayoutChange", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onProvideAutofillVirtualStructure", "structure", "Landroid/view/ViewStructure;", "flags", "onRequestMeasure", "affectsLookahead", "forceRequest", "onRequestRelayout", "onResume", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onRtlPropertiesChanged", "onSemanticsChange", "onWindowFocusChanged", "hasWindowFocus", "recalculateWindowPosition", "recalculateWindowViewTransforms", "recycle", "recycle$ui_release", "registerOnEndApplyChangesListener", "listener", "registerOnLayoutCompletedListener", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "removeAndroidView", "requestClearInvalidObservations", "requestOnPositionedCallback", "scheduleMeasureAndLayout", "nodeToRemeasure", "screenToLocal", "positionOnScreen", "screenToLocal-MK-Hz9U", "sendKeyEvent", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "sendMotionEvent", "sendMotionEvent-8iAsVTc", "sendSimulatedEvent", "action", "eventTime", "forceHover", "setOnViewTreeOwnersAvailable", "callback", "shouldDelayChildPressedState", "updatePositionCacheAndDispatch", "childSizeCanAffectParentSize", "Companion", "ViewTreeOwners", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
public final class AndroidComposeView extends ViewGroup implements Owner, ViewRootForTest, PositionCalculator, DefaultLifecycleObserver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FocusTag = "Compose Focus";
    private static final int MaximumLayerCacheSize = 10;
    /* access modifiers changed from: private */
    public static Method getBooleanMethod;
    /* access modifiers changed from: private */
    public static Class<?> systemPropertiesClass;
    private AndroidViewsHandler _androidViewsHandler;
    private final AndroidAutofill _autofill;
    private final InputModeManagerImpl _inputModeManager;
    private final WindowInfoImpl _windowInfo;
    private final AndroidComposeViewAccessibilityDelegateCompat accessibilityDelegate;
    private final AndroidAccessibilityManager accessibilityManager;
    private final AutofillTree autofillTree;
    private final CanvasHolder canvasHolder;
    private final AndroidClipboardManager clipboardManager;
    private Function1<? super Configuration, Unit> configurationChangeObserver;
    private int currentFontWeightAdjustment;
    private Density density;
    /* access modifiers changed from: private */
    public PointerIcon desiredPointerIcon;
    private final List<OwnedLayer> dirtyLayers;
    private final MutableVector<Function0<Unit>> endApplyChangesListeners;
    private final FocusOwner focusOwner;
    private final MutableState fontFamilyResolver$delegate;
    private final Font.ResourceLoader fontLoader;
    private boolean forceUseMatrixCache;
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private long globalPosition;
    private final HapticFeedback hapticFeedBack;
    private boolean hoverExitReceived;
    private boolean isDrawingContent;
    private boolean isRenderNodeCompatible;
    private final Modifier keyInputModifier;
    private boolean keyboardModifiersRequireUpdate;
    private long lastDownPointerPosition = Offset.Companion.m2930getUnspecifiedF1C5BW0();
    private long lastMatrixRecalculationAnimationTime;
    private final WeakCache<OwnedLayer> layerCache;
    private final MutableState layoutDirection$delegate;
    private final CalculateMatrixToWindow matrixToWindow;
    private final MeasureAndLayoutDelegate measureAndLayoutDelegate;
    private final ModifierLocalManager modifierLocalManager;
    private final MotionEventAdapter motionEventAdapter;
    private boolean observationClearRequested;
    private Constraints onMeasureConstraints;
    private Function1<? super ViewTreeOwners, Unit> onViewTreeOwnersAvailable;
    private final PlatformTextInputPluginRegistryImpl platformTextInputPluginRegistry;
    private final PointerIconService pointerIconService;
    private final PointerInputEventProcessor pointerInputEventProcessor;
    private List<OwnedLayer> postponedDirtyLayers;
    /* access modifiers changed from: private */
    public MotionEvent previousMotionEvent;
    /* access modifiers changed from: private */
    public long relayoutTime;
    private final Function0<Unit> resendMotionEventOnLayout;
    /* access modifiers changed from: private */
    public final AndroidComposeView$resendMotionEventRunnable$1 resendMotionEventRunnable;
    private final LayoutNode root;
    private final RootForTest rootForTest;
    private final Modifier rotaryInputModifier;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final SemanticsModifierCore semanticsModifier;
    private final SemanticsOwner semanticsOwner;
    private final Runnable sendHoverExitEvent;
    private final LayoutNodeDrawScope sharedDrawScope = new LayoutNodeDrawScope((CanvasDrawScope) null, 1, (DefaultConstructorMarker) null);
    private boolean showLayoutBounds;
    private final OwnerSnapshotObserver snapshotObserver;
    private boolean superclassInitComplete = true;
    private final TextInputService textInputService;
    private final TextToolbar textToolbar;
    private final int[] tmpPositionArray;
    private final ViewTreeObserver.OnTouchModeChangeListener touchModeChangeListener;
    private final ViewConfiguration viewConfiguration;
    private DrawChildContainer viewLayersContainer;
    private final float[] viewToWindowMatrix;
    private final MutableState viewTreeOwners$delegate;
    private boolean wasMeasuredWithMultipleConstraints;
    private long windowPosition;
    private final float[] windowToViewMatrix;

    @Deprecated(message = "fontLoader is deprecated, use fontFamilyResolver", replaceWith = @ReplaceWith(expression = "fontFamilyResolver", imports = {}))
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidComposeView(Context context) {
        super(context);
        CalculateMatrixToWindow calculateMatrixToWindow;
        Intrinsics.checkNotNullParameter(context, "context");
        this.density = AndroidDensity_androidKt.Density(context);
        SemanticsModifierCore semanticsModifierCore = new SemanticsModifierCore(false, false, AndroidComposeView$semanticsModifier$1.INSTANCE, (Function1) null, 8, (DefaultConstructorMarker) null);
        this.semanticsModifier = semanticsModifierCore;
        this.focusOwner = new FocusOwnerImpl(new AndroidComposeView$focusOwner$1(this));
        this._windowInfo = new WindowInfoImpl();
        Modifier onKeyEvent = KeyInputModifierKt.onKeyEvent(Modifier.Companion, new AndroidComposeView$keyInputModifier$1(this));
        this.keyInputModifier = onKeyEvent;
        Modifier onRotaryScrollEvent = RotaryInputModifierKt.onRotaryScrollEvent(Modifier.Companion, AndroidComposeView$rotaryInputModifier$1.INSTANCE);
        this.rotaryInputModifier = onRotaryScrollEvent;
        this.canvasHolder = new CanvasHolder();
        LayoutNode layoutNode = new LayoutNode(false, 0, 3, (DefaultConstructorMarker) null);
        LayoutNode it = layoutNode;
        it.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        it.setDensity(getDensity());
        it.setModifier(Modifier.Companion.then(semanticsModifierCore).then(onRotaryScrollEvent).then(getFocusOwner().getModifier()).then(onKeyEvent));
        this.root = layoutNode;
        this.rootForTest = this;
        this.semanticsOwner = new SemanticsOwner(getRoot());
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.accessibilityDelegate = androidComposeViewAccessibilityDelegateCompat;
        this.autofillTree = new AutofillTree();
        this.dirtyLayers = new ArrayList();
        this.motionEventAdapter = new MotionEventAdapter();
        this.pointerInputEventProcessor = new PointerInputEventProcessor(getRoot());
        this.configurationChangeObserver = AndroidComposeView$configurationChangeObserver$1.INSTANCE;
        this._autofill = autofillSupported() ? new AndroidAutofill(this, getAutofillTree()) : null;
        this.clipboardManager = new AndroidClipboardManager(context);
        this.accessibilityManager = new AndroidAccessibilityManager(context);
        this.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(this));
        this.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(getRoot());
        ViewConfiguration viewConfiguration2 = ViewConfiguration.get(context);
        Intrinsics.checkNotNullExpressionValue(viewConfiguration2, "get(context)");
        this.viewConfiguration = new AndroidViewConfiguration(viewConfiguration2);
        this.globalPosition = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.tmpPositionArray = new int[]{0, 0};
        this.viewToWindowMatrix = Matrix.m3391constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
        this.windowToViewMatrix = Matrix.m3391constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
        this.lastMatrixRecalculationAnimationTime = -1;
        this.windowPosition = Offset.Companion.m2929getInfiniteF1C5BW0();
        this.isRenderNodeCompatible = true;
        this.viewTreeOwners$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.globalLayoutListener = new AndroidComposeView$$ExternalSyntheticLambda0(this);
        this.scrollChangedListener = new AndroidComposeView$$ExternalSyntheticLambda1(this);
        this.touchModeChangeListener = new AndroidComposeView$$ExternalSyntheticLambda2(this);
        this.platformTextInputPluginRegistry = new PlatformTextInputPluginRegistryImpl(new AndroidComposeView$platformTextInputPluginRegistry$1(this));
        this.textInputService = ((AndroidTextInputServicePlugin.Adapter) getPlatformTextInputPluginRegistry().getOrCreateAdapter(AndroidTextInputServicePlugin.INSTANCE).getAdapter()).getService();
        this.fontLoader = new AndroidFontResourceLoader(context);
        this.fontFamilyResolver$delegate = SnapshotStateKt.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(context), SnapshotStateKt.referentialEqualityPolicy());
        Configuration configuration = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "context.resources.configuration");
        this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(configuration);
        Configuration configuration2 = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration2, "context.resources.configuration");
        this.layoutDirection$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AndroidComposeView_androidKt.getLocaleLayoutDirection(configuration2), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.hapticFeedBack = new PlatformHapticFeedback(this);
        this._inputModeManager = new InputModeManagerImpl(isInTouchMode() ? InputMode.Companion.m3920getTouchaOaMEAU() : InputMode.Companion.m3919getKeyboardaOaMEAU(), new AndroidComposeView$_inputModeManager$1(this), (DefaultConstructorMarker) null);
        this.modifierLocalManager = new ModifierLocalManager(this);
        this.textToolbar = new AndroidTextToolbar(this);
        this.layerCache = new WeakCache<>();
        this.endApplyChangesListeners = new MutableVector<>(new Function0[16], 0);
        this.resendMotionEventRunnable = new AndroidComposeView$resendMotionEventRunnable$1(this);
        this.sendHoverExitEvent = new AndroidComposeView$$ExternalSyntheticLambda3(this);
        this.resendMotionEventOnLayout = new AndroidComposeView$resendMotionEventOnLayout$1(this);
        if (Build.VERSION.SDK_INT >= 29) {
            calculateMatrixToWindow = new CalculateMatrixToWindowApi29();
        } else {
            calculateMatrixToWindow = new CalculateMatrixToWindowApi21();
        }
        this.matrixToWindow = calculateMatrixToWindow;
        setWillNotDraw(false);
        setFocusable(true);
        AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(this, 1, false);
        setFocusableInTouchMode(true);
        setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(this, androidComposeViewAccessibilityDelegateCompat);
        Function1<ViewRootForTest, Unit> onViewCreatedCallback = ViewRootForTest.Companion.getOnViewCreatedCallback();
        if (onViewCreatedCallback != null) {
            onViewCreatedCallback.invoke(this);
        }
        getRoot().attach$ui_release(this);
        if (Build.VERSION.SDK_INT >= 29) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(this);
        }
        this.pointerIconService = new AndroidComposeView$pointerIconService$1(this);
    }

    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    public View getView() {
        return this;
    }

    public Density getDensity() {
        return this.density;
    }

    public FocusOwner getFocusOwner() {
        return this.focusOwner;
    }

    public WindowInfo getWindowInfo() {
        return this._windowInfo;
    }

    public LayoutNode getRoot() {
        return this.root;
    }

    public RootForTest getRootForTest() {
        return this.rootForTest;
    }

    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.configurationChangeObserver;
    }

    public final void setConfigurationChangeObserver(Function1<? super Configuration, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.configurationChangeObserver = function1;
    }

    public Autofill getAutofill() {
        return this._autofill;
    }

    public AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    public boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    public void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this._androidViewsHandler == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(context);
            this._androidViewsHandler = androidViewsHandler;
            addView(androidViewsHandler);
        }
        AndroidViewsHandler androidViewsHandler2 = this._androidViewsHandler;
        Intrinsics.checkNotNull(androidViewsHandler2);
        return androidViewsHandler2;
    }

    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.getMeasureIteration();
    }

    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout();
    }

    public final long getLastMatrixRecalculationAnimationTime$ui_release() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j) {
        this.lastMatrixRecalculationAnimationTime = j;
    }

    private final void setViewTreeOwners(ViewTreeOwners viewTreeOwners) {
        this.viewTreeOwners$delegate.setValue(viewTreeOwners);
    }

    public final ViewTreeOwners getViewTreeOwners() {
        return (ViewTreeOwners) this.viewTreeOwners$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final void globalLayoutListener$lambda$1(AndroidComposeView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updatePositionCacheAndDispatch();
    }

    /* access modifiers changed from: private */
    public static final void scrollChangedListener$lambda$2(AndroidComposeView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updatePositionCacheAndDispatch();
    }

    /* access modifiers changed from: private */
    public static final void touchModeChangeListener$lambda$3(AndroidComposeView this$0, boolean touchMode) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InputModeManagerImpl inputModeManagerImpl = this$0._inputModeManager;
        InputMode.Companion companion = InputMode.Companion;
        inputModeManagerImpl.m3925setInputModeiuPiT84(touchMode ? companion.m3920getTouchaOaMEAU() : companion.m3919getKeyboardaOaMEAU());
    }

    public PlatformTextInputPluginRegistryImpl getPlatformTextInputPluginRegistry() {
        return this.platformTextInputPluginRegistry;
    }

    public TextInputService getTextInputService() {
        return this.textInputService;
    }

    public TextInputForTests getTextInputForTests() {
        PlatformTextInputAdapter focusedAdapter = getPlatformTextInputPluginRegistry().getFocusedAdapter();
        if (focusedAdapter != null) {
            return focusedAdapter.getInputForTests();
        }
        return null;
    }

    public Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    private void setFontFamilyResolver(FontFamily.Resolver resolver) {
        this.fontFamilyResolver$delegate.setValue(resolver);
    }

    public FontFamily.Resolver getFontFamilyResolver() {
        return (FontFamily.Resolver) this.fontFamilyResolver$delegate.getValue();
    }

    private final int getFontWeightAdjustmentCompat(Configuration $this$fontWeightAdjustmentCompat) {
        if (Build.VERSION.SDK_INT >= 31) {
            return $this$fontWeightAdjustmentCompat.fontWeightAdjustment;
        }
        return 0;
    }

    private void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection$delegate.setValue(layoutDirection);
    }

    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection$delegate.getValue();
    }

    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    /* access modifiers changed from: private */
    public static final void sendHoverExitEvent$lambda$5(AndroidComposeView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z = false;
        this$0.hoverExitReceived = false;
        MotionEvent lastEvent = this$0.previousMotionEvent;
        Intrinsics.checkNotNull(lastEvent);
        if (lastEvent.getActionMasked() == 10) {
            z = true;
        }
        if (z) {
            this$0.m5196sendMotionEvent8iAsVTc(lastEvent);
            return;
        }
        throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.".toString());
    }

    public void getFocusedRect(Rect rect) {
        Unit unit;
        Intrinsics.checkNotNullParameter(rect, "rect");
        androidx.compose.ui.geometry.Rect $this$getFocusedRect_u24lambda_u246 = getFocusOwner().getFocusRect();
        if ($this$getFocusedRect_u24lambda_u246 != null) {
            rect.left = MathKt.roundToInt($this$getFocusedRect_u24lambda_u246.getLeft());
            rect.top = MathKt.roundToInt($this$getFocusedRect_u24lambda_u246.getTop());
            rect.right = MathKt.roundToInt($this$getFocusedRect_u24lambda_u246.getRight());
            rect.bottom = MathKt.roundToInt($this$getFocusedRect_u24lambda_u246.getBottom());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.getFocusedRect(rect);
        }
    }

    public void onResume(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        setShowLayoutBounds(Companion.getIsShowingLayoutBounds());
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        Log.d(FocusTag, "Owner FocusChanged(" + gainFocus + ')');
        FocusOwner focusOwner2 = getFocusOwner();
        if (gainFocus) {
            focusOwner2.takeFocus();
        } else {
            focusOwner2.releaseFocus();
        }
    }

    public void onWindowFocusChanged(boolean hasWindowFocus) {
        boolean newShowLayoutBounds;
        this._windowInfo.setWindowFocused(hasWindowFocus);
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus && getShowLayoutBounds() != (newShowLayoutBounds = Companion.getIsShowingLayoutBounds())) {
            setShowLayoutBounds(newShowLayoutBounds);
            invalidateDescendants();
        }
    }

    /* renamed from: sendKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean m5203sendKeyEventZmokQxo(KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        return getFocusOwner().m2858dispatchKeyEventZmokQxo(keyEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (!isFocused()) {
            return super.dispatchKeyEvent(event);
        }
        this._windowInfo.m5295setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m4730constructorimpl(event.getMetaState()));
        return m5203sendKeyEventZmokQxo(androidx.compose.ui.input.key.KeyEvent.m4508constructorimpl(event));
    }

    public void onAttach(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
    }

    public void onDetach(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.measureAndLayoutDelegate.onNodeDetached(node);
        requestClearInvalidObservations();
    }

    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    public void onEndApplyChanges() {
        if (this.observationClearRequested) {
            getSnapshotObserver().clearInvalidObservations$ui_release();
            this.observationClearRequested = false;
        }
        AndroidViewsHandler childAndroidViews = this._androidViewsHandler;
        if (childAndroidViews != null) {
            clearChildInvalidObservations(childAndroidViews);
        }
        while (this.endApplyChangesListeners.isNotEmpty()) {
            int size = this.endApplyChangesListeners.getSize();
            for (int i = 0; i < size; i++) {
                Function0 listener = (Function0) this.endApplyChangesListeners.getContent()[i];
                this.endApplyChangesListeners.set(i, null);
                if (listener != null) {
                    listener.invoke();
                }
            }
            this.endApplyChangesListeners.removeRange(0, size);
        }
    }

    public void registerOnEndApplyChangesListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.endApplyChangesListeners.contains(listener)) {
            this.endApplyChangesListeners.add(listener);
        }
    }

    private final void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = viewGroup.getChildAt(i);
            if (child instanceof AndroidComposeView) {
                ((AndroidComposeView) child).onEndApplyChanges();
            } else if (child instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) child);
            }
        }
    }

    public final void addAndroidView(AndroidViewHolder view, LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(view, layoutNode);
        getAndroidViewsHandler$ui_release().addView(view);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, view);
        ViewCompat.setImportantForAccessibility(view, 1);
        ViewCompat.setAccessibilityDelegate(view, new AndroidComposeView$addAndroidView$1(layoutNode, this, this));
    }

    public final void removeAndroidView(AndroidViewHolder view) {
        Intrinsics.checkNotNullParameter(view, "view");
        registerOnEndApplyChangesListener(new AndroidComposeView$removeAndroidView$1(this, view));
    }

    public final void drawAndroidView(AndroidViewHolder view, Canvas canvas) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getAndroidViewsHandler$ui_release().drawView(view, canvas);
    }

    static /* synthetic */ void scheduleMeasureAndLayout$default(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.scheduleMeasureAndLayout(layoutNode);
    }

    private final void scheduleMeasureAndLayout(LayoutNode nodeToRemeasure) {
        if (!isLayoutRequested() && isAttachedToWindow()) {
            if (nodeToRemeasure != null) {
                LayoutNode node = nodeToRemeasure;
                while (node != null && node.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && childSizeCanAffectParentSize(node)) {
                    node = node.getParent$ui_release();
                }
                if (node == getRoot()) {
                    requestLayout();
                    return;
                }
            }
            if (getWidth() == 0 || getHeight() == 0) {
                requestLayout();
            } else {
                invalidate();
            }
        }
    }

    private final boolean childSizeCanAffectParentSize(LayoutNode $this$childSizeCanAffectParentSize) {
        if (this.wasMeasuredWithMultipleConstraints) {
            return true;
        }
        LayoutNode parent$ui_release = $this$childSizeCanAffectParentSize.getParent$ui_release();
        if (parent$ui_release != null && !parent$ui_release.getHasFixedInnerContentConstraints$ui_release()) {
            return true;
        }
        return false;
    }

    public void measureAndLayout(boolean sendPointerUpdate) {
        Function0 resend;
        Trace.beginSection("AndroidOwner:measureAndLayout");
        if (sendPointerUpdate) {
            try {
                resend = this.resendMotionEventOnLayout;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } else {
            resend = null;
        }
        if (this.measureAndLayoutDelegate.measureAndLayout(resend)) {
            requestLayout();
        }
        MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, (Object) null);
        Unit unit = Unit.INSTANCE;
        Trace.endSection();
    }

    /* renamed from: measureAndLayout-0kLqBqw  reason: not valid java name */
    public void m5201measureAndLayout0kLqBqw(LayoutNode layoutNode, long constraints) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.measureAndLayoutDelegate.m5066measureAndLayout0kLqBqw(layoutNode, constraints);
            MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, (Object) null);
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public void forceMeasureTheSubtree(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode);
    }

    public void onRequestMeasure(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, forceRequest)) {
                scheduleMeasureAndLayout(layoutNode);
            }
        } else if (this.measureAndLayoutDelegate.requestRemeasure(layoutNode, forceRequest)) {
            scheduleMeasureAndLayout(layoutNode);
        }
    }

    public void onRequestRelayout(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, forceRequest)) {
                scheduleMeasureAndLayout$default(this, (LayoutNode) null, 1, (Object) null);
            }
        } else if (this.measureAndLayoutDelegate.requestRelayout(layoutNode, forceRequest)) {
            scheduleMeasureAndLayout$default(this, (LayoutNode) null, 1, (Object) null);
        }
    }

    public void requestOnPositionedCallback(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.measureAndLayoutDelegate.requestOnPositionedCallback(layoutNode);
        scheduleMeasureAndLayout$default(this, (LayoutNode) null, 1, (Object) null);
    }

    public void measureAndLayoutForTest() {
        Owner.measureAndLayout$default(this, false, 1, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            Pair<Integer, Integer> convertMeasureSpec = convertMeasureSpec(widthMeasureSpec);
            int minWidth = convertMeasureSpec.component1().intValue();
            int maxWidth = convertMeasureSpec.component2().intValue();
            Pair<Integer, Integer> convertMeasureSpec2 = convertMeasureSpec(heightMeasureSpec);
            long constraints = ConstraintsKt.Constraints(minWidth, maxWidth, convertMeasureSpec2.component1().intValue(), convertMeasureSpec2.component2().intValue());
            Constraints constraints2 = this.onMeasureConstraints;
            boolean z = false;
            if (constraints2 == null) {
                this.onMeasureConstraints = Constraints.m5918boximpl(constraints);
                this.wasMeasuredWithMultipleConstraints = false;
            } else {
                if (constraints2 != null) {
                    z = Constraints.m5923equalsimpl0(constraints2.m5936unboximpl(), constraints);
                }
                if (!z) {
                    this.wasMeasuredWithMultipleConstraints = true;
                }
            }
            this.measureAndLayoutDelegate.m5067updateRootConstraintsBRTryo0(constraints);
            this.measureAndLayoutDelegate.measureOnly();
            setMeasuredDimension(getRoot().getWidth(), getRoot().getHeight());
            if (this._androidViewsHandler != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().getHeight(), 1073741824));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    private final Pair<Integer, Integer> convertMeasureSpec(int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        switch (mode) {
            case Integer.MIN_VALUE:
                return TuplesKt.to(0, Integer.valueOf(size));
            case 0:
                return TuplesKt.to(0, Integer.MAX_VALUE);
            case 1073741824:
                return TuplesKt.to(Integer.valueOf(size), Integer.valueOf(size));
            default:
                throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
        this.onMeasureConstraints = null;
        updatePositionCacheAndDispatch();
        if (this._androidViewsHandler != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, r - l, b - t);
        }
    }

    private final void updatePositionCacheAndDispatch() {
        boolean positionChanged = false;
        getLocationOnScreen(this.tmpPositionArray);
        long j = this.globalPosition;
        int globalX = IntOffset.m6096component1impl(j);
        int globalY = IntOffset.m6097component2impl(j);
        int[] iArr = this.tmpPositionArray;
        int i = iArr[0];
        if (!(globalX == i && globalY == iArr[1])) {
            this.globalPosition = IntOffsetKt.IntOffset(i, iArr[1]);
            if (!(globalX == Integer.MAX_VALUE || globalY == Integer.MAX_VALUE)) {
                positionChanged = true;
                getRoot().getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
            }
        }
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(positionChanged);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
    }

    public OwnedLayer createLayer(Function1<? super androidx.compose.ui.graphics.Canvas, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        DrawChildContainer drawChildContainer;
        Intrinsics.checkNotNullParameter(drawBlock, "drawBlock");
        Intrinsics.checkNotNullParameter(invalidateParentLayer, "invalidateParentLayer");
        OwnedLayer layer = this.layerCache.pop();
        if (layer != null) {
            layer.reuseLayer(drawBlock, invalidateParentLayer);
            return layer;
        }
        if (isHardwareAccelerated() && this.isRenderNodeCompatible) {
            try {
                return new RenderNodeLayer(this, drawBlock, invalidateParentLayer);
            } catch (Throwable th) {
                this.isRenderNodeCompatible = false;
            }
        }
        if (this.viewLayersContainer == null) {
            if (!ViewLayer.Companion.getHasRetrievedMethod()) {
                ViewLayer.Companion.updateDisplayList(new View(getContext()));
            }
            if (ViewLayer.Companion.getShouldUseDispatchDraw()) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                drawChildContainer = new DrawChildContainer(context);
            } else {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                drawChildContainer = new ViewLayerContainer(context2);
            }
            this.viewLayersContainer = drawChildContainer;
            addView(drawChildContainer);
        }
        DrawChildContainer drawChildContainer2 = this.viewLayersContainer;
        Intrinsics.checkNotNull(drawChildContainer2);
        return new ViewLayer(this, drawChildContainer2, drawBlock, invalidateParentLayer);
    }

    public final boolean recycle$ui_release(OwnedLayer layer) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        if (this.viewLayersContainer == null || !ViewLayer.Companion.getShouldUseDispatchDraw()) {
        }
        if (1 != 0) {
            this.layerCache.push(layer);
        }
        return true;
    }

    public void onSemanticsChange() {
        this.accessibilityDelegate.onSemanticsChange$ui_release();
    }

    public void onLayoutChange(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.accessibilityDelegate.onLayoutChange$ui_release(layoutNode);
    }

    public void registerOnLayoutCompletedListener(Owner.OnLayoutCompletedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.measureAndLayoutDelegate.registerOnLayoutCompletedListener(listener);
        scheduleMeasureAndLayout$default(this, (LayoutNode) null, 1, (Object) null);
    }

    /* renamed from: getFocusDirection-P8AzH3I  reason: not valid java name */
    public FocusDirection m5199getFocusDirectionP8AzH3I(KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        long r0 = KeyEvent_androidKt.m4524getKeyZmokQxo(keyEvent);
        if (Key.m3929equalsimpl0(r0, Key.Companion.m4452getTabEK5gGoQ())) {
            return FocusDirection.m2836boximpl(KeyEvent_androidKt.m4530isShiftPressedZmokQxo(keyEvent) ? FocusDirection.Companion.m2854getPreviousdhqQ8s() : FocusDirection.Companion.m2852getNextdhqQ8s());
        } else if (Key.m3929equalsimpl0(r0, Key.Companion.m4293getDirectionRightEK5gGoQ())) {
            return FocusDirection.m2836boximpl(FocusDirection.Companion.m2855getRightdhqQ8s());
        } else {
            if (Key.m3929equalsimpl0(r0, Key.Companion.m4292getDirectionLeftEK5gGoQ())) {
                return FocusDirection.m2836boximpl(FocusDirection.Companion.m2851getLeftdhqQ8s());
            }
            if (Key.m3929equalsimpl0(r0, Key.Companion.m4294getDirectionUpEK5gGoQ())) {
                return FocusDirection.m2836boximpl(FocusDirection.Companion.m2856getUpdhqQ8s());
            }
            if (Key.m3929equalsimpl0(r0, Key.Companion.m4289getDirectionDownEK5gGoQ())) {
                return FocusDirection.m2836boximpl(FocusDirection.Companion.m2847getDowndhqQ8s());
            }
            boolean z = true;
            if (Key.m3929equalsimpl0(r0, Key.Companion.m4288getDirectionCenterEK5gGoQ()) ? true : Key.m3929equalsimpl0(r0, Key.Companion.m4302getEnterEK5gGoQ()) ? true : Key.m3929equalsimpl0(r0, Key.Companion.m4394getNumPadEnterEK5gGoQ())) {
                return FocusDirection.m2836boximpl(FocusDirection.Companion.m2848getEnterdhqQ8s());
            }
            if (!Key.m3929equalsimpl0(r0, Key.Companion.m4231getBackEK5gGoQ())) {
                z = Key.m3929equalsimpl0(r0, Key.Companion.m4305getEscapeEK5gGoQ());
            }
            if (z) {
                return FocusDirection.m2836boximpl(FocusDirection.Companion.m2849getExitdhqQ8s());
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        Owner.measureAndLayout$default(this, false, 1, (Object) null);
        this.isDrawingContent = true;
        CanvasHolder this_$iv = this.canvasHolder;
        Canvas previousCanvas$iv = this_$iv.getAndroidCanvas().getInternalCanvas();
        this_$iv.getAndroidCanvas().setInternalCanvas(canvas);
        getRoot().draw$ui_release(this_$iv.getAndroidCanvas());
        this_$iv.getAndroidCanvas().setInternalCanvas(previousCanvas$iv);
        if (!this.dirtyLayers.isEmpty()) {
            int size = this.dirtyLayers.size();
            for (int i = 0; i < size; i++) {
                this.dirtyLayers.get(i).updateDisplayList();
            }
        }
        if (ViewLayer.Companion.getShouldUseDispatchDraw()) {
            int saveCount = canvas.save();
            canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(saveCount);
        }
        this.dirtyLayers.clear();
        this.isDrawingContent = false;
        List postponed = this.postponedDirtyLayers;
        if (postponed != null) {
            Intrinsics.checkNotNull(postponed);
            this.dirtyLayers.addAll(postponed);
            postponed.clear();
        }
    }

    public final void notifyLayerIsDirty$ui_release(OwnedLayer layer, boolean isDirty) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        if (!isDirty) {
            if (!this.isDrawingContent) {
                this.dirtyLayers.remove(layer);
                List<OwnedLayer> list = this.postponedDirtyLayers;
                if (list != null) {
                    list.remove(layer);
                }
            }
        } else if (!this.isDrawingContent) {
            this.dirtyLayers.add(layer);
        } else {
            List postponed = this.postponedDirtyLayers;
            if (postponed == null) {
                postponed = new ArrayList();
                this.postponedDirtyLayers = postponed;
            }
            postponed.add(layer);
        }
    }

    public final void setOnViewTreeOwnersAvailable(Function1<? super ViewTreeOwners, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            callback.invoke(viewTreeOwners);
        }
        if (!isAttachedToWindow()) {
            this.onViewTreeOwnersAvailable = callback;
        }
    }

    public final Object boundsUpdatesEventLoop(Continuation<? super Unit> $completion) {
        Object boundsUpdatesEventLoop = this.accessibilityDelegate.boundsUpdatesEventLoop($completion);
        return boundsUpdatesEventLoop == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? boundsUpdatesEventLoop : Unit.INSTANCE;
    }

    private final void invalidateLayoutNodeMeasurement(LayoutNode node) {
        MeasureAndLayoutDelegate.requestRemeasure$default(this.measureAndLayoutDelegate, node, false, 2, (Object) null);
        MutableVector this_$iv$iv = node.get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                invalidateLayoutNodeMeasurement((LayoutNode) content$iv$iv[i$iv$iv]);
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
    }

    private final void invalidateLayers(LayoutNode node) {
        node.invalidateLayers$ui_release();
        MutableVector this_$iv$iv = node.get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                invalidateLayers((LayoutNode) content$iv$iv[i$iv$iv]);
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
    }

    public void invalidateDescendants() {
        invalidateLayers(getRoot());
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        AndroidAutofill it;
        super.onAttachedToWindow();
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().startObserving$ui_release();
        if (autofillSupported() && (it = this._autofill) != null) {
            AutofillCallback.INSTANCE.register(it);
        }
        LifecycleOwner lifecycleOwner2 = ViewTreeLifecycleOwner.get(this);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(this);
        ViewTreeOwners oldViewTreeOwners = getViewTreeOwners();
        if (oldViewTreeOwners == null || !(lifecycleOwner2 == null || savedStateRegistryOwner == null || (lifecycleOwner2 == oldViewTreeOwners.getLifecycleOwner() && savedStateRegistryOwner == oldViewTreeOwners.getLifecycleOwner()))) {
            if (lifecycleOwner2 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            } else if (savedStateRegistryOwner != null) {
                if (!(oldViewTreeOwners == null || (lifecycleOwner = oldViewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null)) {
                    lifecycle.removeObserver(this);
                }
                lifecycleOwner2.getLifecycle().addObserver(this);
                ViewTreeOwners viewTreeOwners = new ViewTreeOwners(lifecycleOwner2, savedStateRegistryOwner);
                setViewTreeOwners(viewTreeOwners);
                Function1<? super ViewTreeOwners, Unit> function1 = this.onViewTreeOwnersAvailable;
                if (function1 != null) {
                    function1.invoke(viewTreeOwners);
                }
                this.onViewTreeOwnersAvailable = null;
            } else {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
        }
        this._inputModeManager.m3925setInputModeiuPiT84(isInTouchMode() ? InputMode.Companion.m3920getTouchaOaMEAU() : InputMode.Companion.m3919getKeyboardaOaMEAU());
        ViewTreeOwners viewTreeOwners2 = getViewTreeOwners();
        Intrinsics.checkNotNull(viewTreeOwners2);
        viewTreeOwners2.getLifecycleOwner().getLifecycle().addObserver(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().addOnTouchModeChangeListener(this.touchModeChangeListener);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AndroidAutofill it;
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        super.onDetachedFromWindow();
        getSnapshotObserver().stopObserving$ui_release();
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (!(viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null)) {
            lifecycle.removeObserver(this);
        }
        if (autofillSupported() && (it = this._autofill) != null) {
            AutofillCallback.INSTANCE.unregister(it);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().removeOnTouchModeChangeListener(this.touchModeChangeListener);
    }

    public void onProvideAutofillVirtualStructure(ViewStructure structure, int flags) {
        AndroidAutofill androidAutofill;
        if (autofillSupported() && structure != null && (androidAutofill = this._autofill) != null) {
            AndroidAutofill_androidKt.populateViewStructure(androidAutofill, structure);
        }
    }

    public void autofill(SparseArray<AutofillValue> values) {
        AndroidAutofill androidAutofill;
        Intrinsics.checkNotNullParameter(values, "values");
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AndroidAutofill_androidKt.performAutofill(androidAutofill, values);
        }
    }

    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (event.getActionMasked() != 8) {
            return super.dispatchGenericMotionEvent(event);
        }
        if (event.isFromSource(4194304)) {
            return handleRotaryEvent(event);
        }
        if (isBadMotionEvent(event) || !isAttachedToWindow()) {
            return super.dispatchGenericMotionEvent(event);
        }
        return ProcessResult.m4755getDispatchedToAPointerInputModifierimpl(m5195handleMotionEvent8iAsVTc(event));
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            MotionEvent lastEvent = this.previousMotionEvent;
            Intrinsics.checkNotNull(lastEvent);
            if (motionEvent.getActionMasked() != 0 || hasChangedDevices(motionEvent, lastEvent)) {
                this.sendHoverExitEvent.run();
            } else {
                this.hoverExitReceived = false;
            }
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && !isPositionChanged(motionEvent)) {
            return false;
        }
        int processResult = m5195handleMotionEvent8iAsVTc(motionEvent);
        if (ProcessResult.m4754getAnyMovementConsumedimpl(processResult)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return ProcessResult.m4755getDispatchedToAPointerInputModifierimpl(processResult);
    }

    private final boolean handleRotaryEvent(MotionEvent event) {
        ViewConfiguration config = ViewConfiguration.get(getContext());
        float axisValue = -event.getAxisValue(26);
        return getFocusOwner().dispatchRotaryEvent(new RotaryScrollEvent(ViewConfigurationCompat.getScaledVerticalScrollFactor(config, getContext()) * axisValue, ViewConfigurationCompat.getScaledHorizontalScrollFactor(config, getContext()) * axisValue, event.getEventTime()));
    }

    /*  JADX ERROR: NullPointerException in pass: CodeShrinkVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.inline(CodeShrinkVisitor.java:146)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:71)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    /* renamed from: handleMotionEvent-8iAsVTc  reason: not valid java name */
    private final int m5195handleMotionEvent8iAsVTc(android.view.MotionEvent r21) {
        /*
            r20 = this;
            r9 = r20
            r10 = r21
            androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1 r0 = r9.resendMotionEventRunnable
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r9.removeCallbacks(r0)
            r11 = 0
            r20.recalculateWindowPosition(r21)     // Catch:{ all -> 0x00d5 }
            r0 = 1
            r9.forceUseMatrixCache = r0     // Catch:{ all -> 0x00d5 }
            r9.measureAndLayout(r11)     // Catch:{ all -> 0x00d5 }
            r1 = 0
            r9.desiredPointerIcon = r1     // Catch:{ all -> 0x00d5 }
            java.lang.String r1 = "AndroidOwner:onTouch"
            r12 = r1
            r13 = 0
            android.os.Trace.beginSection(r12)     // Catch:{ all -> 0x00d5 }
            r14 = 0
            int r1 = r21.getActionMasked()     // Catch:{ all -> 0x00d0 }
            r15 = r1
            android.view.MotionEvent r1 = r9.previousMotionEvent     // Catch:{ all -> 0x00d0 }
            r8 = r1
            r7 = 3
            if (r8 == 0) goto L_0x0035
            int r1 = r8.getToolType(r11)     // Catch:{ all -> 0x00d0 }
            if (r1 != r7) goto L_0x0035
            r1 = r0
            goto L_0x0036
        L_0x0035:
            r1 = r11
        L_0x0036:
            r16 = r1
            if (r8 == 0) goto L_0x007a
            boolean r1 = r9.hasChangedDevices(r10, r8)     // Catch:{ all -> 0x00d0 }
            if (r1 == 0) goto L_0x0076
            boolean r1 = r9.isDevicePressEvent(r8)     // Catch:{ all -> 0x00d0 }
            if (r1 == 0) goto L_0x004f
            androidx.compose.ui.input.pointer.PointerInputEventProcessor r1 = r9.pointerInputEventProcessor     // Catch:{ all -> 0x00d0 }
            r1.processCancel()     // Catch:{ all -> 0x00d0 }
            r0 = r7
            r17 = r8
            goto L_0x007d
        L_0x004f:
            int r1 = r8.getActionMasked()     // Catch:{ all -> 0x00d0 }
            r2 = 10
            if (r1 == r2) goto L_0x0072
            if (r16 == 0) goto L_0x0072
            r3 = 10
            long r4 = r8.getEventTime()     // Catch:{ all -> 0x00d0 }
            r6 = 0
            r17 = 8
            r18 = 0
            r1 = r20
            r2 = r8
            r0 = r7
            r7 = r17
            r17 = r8
            r8 = r18
            sendSimulatedEvent$default(r1, r2, r3, r4, r6, r7, r8)     // Catch:{ all -> 0x00d0 }
            goto L_0x007d
        L_0x0072:
            r0 = r7
            r17 = r8
            goto L_0x007d
        L_0x0076:
            r0 = r7
            r17 = r8
            goto L_0x007d
        L_0x007a:
            r0 = r7
            r17 = r8
        L_0x007d:
            int r1 = r10.getToolType(r11)     // Catch:{ all -> 0x00d0 }
            if (r1 != r0) goto L_0x0086
            r19 = 1
            goto L_0x0088
        L_0x0086:
            r19 = r11
        L_0x0088:
            r18 = r19
            if (r16 != 0) goto L_0x00ab
            if (r18 == 0) goto L_0x00ab
            if (r15 == r0) goto L_0x00ab
            r0 = 9
            if (r15 == r0) goto L_0x00ab
            boolean r0 = r20.isInBounds(r21)     // Catch:{ all -> 0x00d0 }
            if (r0 == 0) goto L_0x00ab
            r3 = 9
            long r4 = r21.getEventTime()     // Catch:{ all -> 0x00d0 }
            r6 = 0
            r7 = 8
            r8 = 0
            r1 = r20
            r2 = r21
            sendSimulatedEvent$default(r1, r2, r3, r4, r6, r7, r8)     // Catch:{ all -> 0x00d0 }
        L_0x00ab:
            if (r17 == 0) goto L_0x00b0
            r17.recycle()     // Catch:{ all -> 0x00d0 }
        L_0x00b0:
            android.view.MotionEvent r0 = android.view.MotionEvent.obtainNoHistory(r21)     // Catch:{ all -> 0x00d0 }
            r9.previousMotionEvent = r0     // Catch:{ all -> 0x00d0 }
            int r0 = r20.m5196sendMotionEvent8iAsVTc(r21)     // Catch:{ all -> 0x00d0 }
            android.os.Trace.endSection()     // Catch:{ all -> 0x00d5 }
            androidx.compose.ui.platform.AndroidComposeViewVerificationHelperMethodsN r1 = androidx.compose.ui.platform.AndroidComposeViewVerificationHelperMethodsN.INSTANCE     // Catch:{ all -> 0x00d5 }
            r2 = r9
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x00d5 }
            androidx.compose.ui.input.pointer.PointerIcon r3 = r9.desiredPointerIcon     // Catch:{ all -> 0x00d5 }
            r1.setPointerIcon(r2, r3)     // Catch:{ all -> 0x00d5 }
            r9.forceUseMatrixCache = r11
            r1 = r0
            return r0
        L_0x00d0:
            r0 = move-exception
            android.os.Trace.endSection()     // Catch:{ all -> 0x00d5 }
            throw r0     // Catch:{ all -> 0x00d5 }
        L_0x00d5:
            r0 = move-exception
            r9.forceUseMatrixCache = r11
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.m5195handleMotionEvent8iAsVTc(android.view.MotionEvent):int");
    }

    private final boolean hasChangedDevices(MotionEvent event, MotionEvent lastEvent) {
        return (lastEvent.getSource() == event.getSource() && lastEvent.getToolType(0) == event.getToolType(0)) ? false : true;
    }

    private final boolean isDevicePressEvent(MotionEvent event) {
        if (event.getButtonState() != 0) {
            return true;
        }
        switch (event.getActionMasked()) {
            case 0:
            case 2:
            case 6:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: sendMotionEvent-8iAsVTc  reason: not valid java name */
    private final int m5196sendMotionEvent8iAsVTc(MotionEvent motionEvent) {
        PointerInputEventData it;
        if (this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = false;
            this._windowInfo.m5295setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m4730constructorimpl(motionEvent.getMetaState()));
        }
        PointerInputEvent pointerInputEvent = this.motionEventAdapter.convertToPointerInputEvent$ui_release(motionEvent, this);
        if (pointerInputEvent != null) {
            List $this$lastOrNull$iv = pointerInputEvent.getPointers();
            ListIterator iterator$iv = $this$lastOrNull$iv.listIterator($this$lastOrNull$iv.size());
            while (true) {
                if (!iterator$iv.hasPrevious()) {
                    it = null;
                    break;
                }
                it = iterator$iv.previous();
                if (it.getDown()) {
                    break;
                }
            }
            PointerInputEventData pointerInputEventData = it;
            if (pointerInputEventData != null) {
                this.lastDownPointerPosition = pointerInputEventData.m4681getPositionF1C5BW0();
            }
            int result = this.pointerInputEventProcessor.m4686processBIzXfog(pointerInputEvent, this, isInBounds(motionEvent));
            int action = motionEvent.getActionMasked();
            if ((action != 0 && action != 5) || ProcessResult.m4755getDispatchedToAPointerInputModifierimpl(result)) {
                return result;
            }
            this.motionEventAdapter.endStream(motionEvent.getPointerId(motionEvent.getActionIndex()));
            return result;
        }
        this.pointerInputEventProcessor.processCancel();
        return PointerInputEventProcessorKt.ProcessResult(false, false);
    }

    static /* synthetic */ void sendSimulatedEvent$default(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i, long j, boolean z, int i2, Object obj) {
        boolean z2;
        if ((i2 & 8) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        androidComposeView.sendSimulatedEvent(motionEvent, i, j, z2);
    }

    /* access modifiers changed from: private */
    public final void sendSimulatedEvent(MotionEvent motionEvent, int action, long eventTime, boolean forceHover) {
        long downTime;
        MotionEvent motionEvent2 = motionEvent;
        int upIndex = -1;
        int i = 0;
        switch (motionEvent.getActionMasked()) {
            case 1:
                switch (action) {
                    case 9:
                    case 10:
                        break;
                    default:
                        upIndex = 0;
                        break;
                }
            case 6:
                upIndex = motionEvent.getActionIndex();
                break;
        }
        int pointerCount = motionEvent.getPointerCount() - (upIndex >= 0 ? 1 : 0);
        if (pointerCount != 0) {
            MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
            for (int i2 = 0; i2 < pointerCount; i2++) {
                pointerPropertiesArr[i2] = new MotionEvent.PointerProperties();
            }
            MotionEvent.PointerProperties[] pointerProperties = pointerPropertiesArr;
            MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
            for (int i3 = 0; i3 < pointerCount; i3++) {
                pointerCoordsArr[i3] = new MotionEvent.PointerCoords();
            }
            MotionEvent.PointerCoords[] pointerCoords = pointerCoordsArr;
            int i4 = 0;
            while (i4 < pointerCount) {
                int sourceIndex = ((upIndex < 0 || i4 < upIndex) ? 0 : 1) + i4;
                motionEvent2.getPointerProperties(sourceIndex, pointerProperties[i4]);
                MotionEvent.PointerCoords coords = pointerCoords[i4];
                motionEvent2.getPointerCoords(sourceIndex, coords);
                long screenPosition = m5200localToScreenMKHz9U(OffsetKt.Offset(coords.x, coords.y));
                coords.x = Offset.m2915getXimpl(screenPosition);
                coords.y = Offset.m2916getYimpl(screenPosition);
                i4++;
            }
            if (!forceHover) {
                i = motionEvent.getButtonState();
            }
            int buttonState = i;
            if (motionEvent.getDownTime() == motionEvent.getEventTime()) {
                downTime = eventTime;
            } else {
                downTime = motionEvent.getDownTime();
            }
            int i5 = pointerCount;
            MotionEvent event = MotionEvent.obtain(downTime, eventTime, action, pointerCount, pointerProperties, pointerCoords, motionEvent.getMetaState(), buttonState, motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
            MotionEventAdapter motionEventAdapter2 = this.motionEventAdapter;
            Intrinsics.checkNotNullExpressionValue(event, NotificationCompat.CATEGORY_EVENT);
            PointerInputEvent pointerInputEvent = motionEventAdapter2.convertToPointerInputEvent$ui_release(event, this);
            Intrinsics.checkNotNull(pointerInputEvent);
            this.pointerInputEventProcessor.m4686processBIzXfog(pointerInputEvent, this, true);
            event.recycle();
        }
    }

    public boolean canScrollHorizontally(int direction) {
        return this.accessibilityDelegate.m5207canScroll0AR0LA0$ui_release(false, direction, this.lastDownPointerPosition);
    }

    public boolean canScrollVertically(int direction) {
        return this.accessibilityDelegate.m5207canScroll0AR0LA0$ui_release(true, direction, this.lastDownPointerPosition);
    }

    private final boolean isInBounds(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (0.0f <= x && x <= ((float) getWidth())) {
            if (0.0f <= y && y <= ((float) getHeight())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: localToScreen-MK-Hz9U  reason: not valid java name */
    public long m5200localToScreenMKHz9U(long localPosition) {
        recalculateWindowPosition();
        long local = Matrix.m3397mapMKHz9U(this.viewToWindowMatrix, localPosition);
        return OffsetKt.Offset(Offset.m2915getXimpl(local) + Offset.m2915getXimpl(this.windowPosition), Offset.m2916getYimpl(local) + Offset.m2916getYimpl(this.windowPosition));
    }

    /* renamed from: screenToLocal-MK-Hz9U  reason: not valid java name */
    public long m5202screenToLocalMKHz9U(long positionOnScreen) {
        recalculateWindowPosition();
        return Matrix.m3397mapMKHz9U(this.windowToViewMatrix, OffsetKt.Offset(Offset.m2915getXimpl(positionOnScreen) - Offset.m2915getXimpl(this.windowPosition), Offset.m2916getYimpl(positionOnScreen) - Offset.m2916getYimpl(this.windowPosition)));
    }

    private final void recalculateWindowPosition() {
        if (!this.forceUseMatrixCache) {
            long animationTime = AnimationUtils.currentAnimationTimeMillis();
            if (animationTime != this.lastMatrixRecalculationAnimationTime) {
                this.lastMatrixRecalculationAnimationTime = animationTime;
                recalculateWindowViewTransforms();
                ViewParent viewParent = getParent();
                View view = this;
                while (viewParent instanceof ViewGroup) {
                    view = (View) viewParent;
                    viewParent = ((ViewGroup) view).getParent();
                }
                view.getLocationOnScreen(this.tmpPositionArray);
                int[] iArr = this.tmpPositionArray;
                view.getLocationInWindow(iArr);
                int[] iArr2 = this.tmpPositionArray;
                this.windowPosition = OffsetKt.Offset(((float) iArr[0]) - ((float) iArr2[0]), ((float) iArr[1]) - ((float) iArr2[1]));
            }
        }
    }

    private final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        recalculateWindowViewTransforms();
        long positionInWindow = Matrix.m3397mapMKHz9U(this.viewToWindowMatrix, OffsetKt.Offset(motionEvent.getX(), motionEvent.getY()));
        this.windowPosition = OffsetKt.Offset(motionEvent.getRawX() - Offset.m2915getXimpl(positionInWindow), motionEvent.getRawY() - Offset.m2916getYimpl(positionInWindow));
    }

    private final void recalculateWindowViewTransforms() {
        this.matrixToWindow.m5212calculateMatrixToWindowEL8BTi8(this, this.viewToWindowMatrix);
        InvertMatrixKt.m5238invertToJiSxe2E(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    public boolean onCheckIsTextEditor() {
        return getPlatformTextInputPluginRegistry().getFocusedAdapter() != null;
    }

    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        PlatformTextInputAdapter focusedAdapter = getPlatformTextInputPluginRegistry().getFocusedAdapter();
        if (focusedAdapter != null) {
            return focusedAdapter.createInputConnection(outAttrs);
        }
        return null;
    }

    /* renamed from: calculateLocalPosition-MK-Hz9U  reason: not valid java name */
    public long m5197calculateLocalPositionMKHz9U(long positionInWindow) {
        recalculateWindowPosition();
        return Matrix.m3397mapMKHz9U(this.windowToViewMatrix, positionInWindow);
    }

    /* renamed from: calculatePositionInWindow-MK-Hz9U  reason: not valid java name */
    public long m5198calculatePositionInWindowMKHz9U(long localPosition) {
        recalculateWindowPosition();
        return Matrix.m3397mapMKHz9U(this.viewToWindowMatrix, localPosition);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.density = AndroidDensity_androidKt.Density(context);
        if (getFontWeightAdjustmentCompat(newConfig) != this.currentFontWeightAdjustment) {
            this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(newConfig);
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            setFontFamilyResolver(FontFamilyResolver_androidKt.createFontFamilyResolver(context2));
        }
        this.configurationChangeObserver.invoke(newConfig);
    }

    public void onRtlPropertiesChanged(int layoutDirection) {
        if (this.superclassInitComplete) {
            LayoutDirection it = AndroidComposeView_androidKt.layoutDirectionFromInt(layoutDirection);
            setLayoutDirection(it);
            getFocusOwner().setLayoutDirection(it);
        }
    }

    private final boolean autofillSupported() {
        return true;
    }

    public boolean dispatchHoverEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }
        if (isBadMotionEvent(event) || !isAttachedToWindow()) {
            return false;
        }
        if (event.isFromSource(InputDeviceCompat.SOURCE_TOUCHSCREEN) && event.getToolType(0) == 1) {
            return this.accessibilityDelegate.dispatchHoverEvent(event);
        }
        switch (event.getActionMasked()) {
            case 7:
                if (!isPositionChanged(event)) {
                    return false;
                }
                break;
            case 10:
                if (isInBounds(event)) {
                    if (event.getToolType(0) != 3) {
                        MotionEvent motionEvent = this.previousMotionEvent;
                        if (motionEvent != null) {
                            motionEvent.recycle();
                        }
                        this.previousMotionEvent = MotionEvent.obtainNoHistory(event);
                        this.hoverExitReceived = true;
                        post(this.sendHoverExitEvent);
                        return false;
                    } else if (event.getButtonState() != 0) {
                        return false;
                    }
                }
                break;
        }
        return ProcessResult.m4755getDispatchedToAPointerInputModifierimpl(m5195handleMotionEvent8iAsVTc(event));
    }

    private final boolean isBadMotionEvent(MotionEvent event) {
        float x = event.getX();
        if (!(!Float.isInfinite(x) && !Float.isNaN(x))) {
            return true;
        }
        float y = event.getY();
        if (!(!Float.isInfinite(y) && !Float.isNaN(y))) {
            return true;
        }
        float rawX = event.getRawX();
        if (!(!Float.isInfinite(rawX) && !Float.isNaN(rawX))) {
            return true;
        }
        float rawY = event.getRawY();
        if (!(!Float.isInfinite(rawY) && !Float.isNaN(rawY))) {
            return true;
        }
        return false;
    }

    private final boolean isPositionChanged(MotionEvent event) {
        MotionEvent lastEvent;
        if (event.getPointerCount() != 1 || (lastEvent = this.previousMotionEvent) == null) {
            return true;
        }
        if (!(event.getRawX() == lastEvent.getRawX())) {
            return true;
        }
        if (!(event.getRawY() == lastEvent.getRawY())) {
            return true;
        }
        return false;
    }

    private final View findViewByAccessibilityIdRootedAtCurrentView(int accessibilityId, View currentView) {
        if (Build.VERSION.SDK_INT >= 29) {
            return null;
        }
        Method getAccessibilityViewIdMethod = View.class.getDeclaredMethod("getAccessibilityViewId", new Class[0]);
        getAccessibilityViewIdMethod.setAccessible(true);
        if (Intrinsics.areEqual(getAccessibilityViewIdMethod.invoke(currentView, new Object[0]), (Object) Integer.valueOf(accessibilityId))) {
            return currentView;
        }
        if (!(currentView instanceof ViewGroup)) {
            return null;
        }
        int childCount = ((ViewGroup) currentView).getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = ((ViewGroup) currentView).getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "currentView.getChildAt(i)");
            View foundView = findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, childAt);
            if (foundView != null) {
                return foundView;
            }
        }
        return null;
    }

    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    public final View findViewByAccessibilityIdTraversal(int accessibilityId) {
        try {
            if (Build.VERSION.SDK_INT < 29) {
                return findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, this);
            }
            Method findViewByAccessibilityIdTraversalMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", new Class[]{Integer.TYPE});
            findViewByAccessibilityIdTraversalMethod.setAccessible(true);
            Object invoke = findViewByAccessibilityIdTraversalMethod.invoke(this, new Object[]{Integer.valueOf(accessibilityId)});
            if (invoke instanceof View) {
                return (View) invoke;
            }
            return null;
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public boolean isLifecycleInResumedState() {
        Lifecycle.State state;
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) {
            state = null;
        } else {
            state = lifecycle.getCurrentState();
        }
        return state == Lifecycle.State.RESUMED;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$Companion;", "", "()V", "FocusTag", "", "MaximumLayerCacheSize", "", "getBooleanMethod", "Ljava/lang/reflect/Method;", "systemPropertiesClass", "Ljava/lang/Class;", "getIsShowingLayoutBounds", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeView.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean getIsShowingLayoutBounds() {
            Object obj;
            Method method;
            try {
                Boolean bool = null;
                if (AndroidComposeView.systemPropertiesClass == null) {
                    AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                    Class access$getSystemPropertiesClass$cp = AndroidComposeView.systemPropertiesClass;
                    if (access$getSystemPropertiesClass$cp != null) {
                        method = access$getSystemPropertiesClass$cp.getDeclaredMethod("getBoolean", new Class[]{String.class, Boolean.TYPE});
                    } else {
                        method = null;
                    }
                    AndroidComposeView.getBooleanMethod = method;
                }
                Method access$getGetBooleanMethod$cp = AndroidComposeView.getBooleanMethod;
                if (access$getGetBooleanMethod$cp != null) {
                    obj = access$getGetBooleanMethod$cp.invoke((Object) null, new Object[]{"debug.layout", false});
                } else {
                    obj = null;
                }
                if (obj instanceof Boolean) {
                    bool = (Boolean) obj;
                }
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeView.android.kt */
    public static final class ViewTreeOwners {
        public static final int $stable = 8;
        private final LifecycleOwner lifecycleOwner;
        private final SavedStateRegistryOwner savedStateRegistryOwner;

        public ViewTreeOwners(LifecycleOwner lifecycleOwner2, SavedStateRegistryOwner savedStateRegistryOwner2) {
            Intrinsics.checkNotNullParameter(lifecycleOwner2, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(savedStateRegistryOwner2, "savedStateRegistryOwner");
            this.lifecycleOwner = lifecycleOwner2;
            this.savedStateRegistryOwner = savedStateRegistryOwner2;
        }

        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
            return this.savedStateRegistryOwner;
        }
    }
}
