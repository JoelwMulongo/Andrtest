package androidx.compose.ui.tooling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.activity.compose.LocalActivityResultRegistryOwner;
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.tooling.animation.AnimationSearch;
import androidx.compose.ui.tooling.animation.PreviewAnimationClock;
import androidx.compose.ui.tooling.data.Group;
import androidx.compose.ui.tooling.data.NodeGroup;
import androidx.compose.ui.tooling.data.SlotTreeKt;
import androidx.compose.ui.tooling.data.SourceLocation;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import androidx.compose.ui.unit.IntRect;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0004\u000b\u000e\u0011\u0014\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ \u0010Q\u001a\u00020(2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)H\u0003¢\u0006\u0002\u0010RJ\u0010\u0010S\u001a\u00020(2\u0006\u0010T\u001a\u00020UH\u0014J\r\u0010V\u001a\u00020(H\u0000¢\u0006\u0002\bWJ\b\u0010X\u001a\u00020(H\u0002J\b\u0010Y\u001a\u00020(H\u0002J\u0006\u0010:\u001a\u00020.J\u0010\u0010Z\u001a\u00020(2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0001\u0010Z\u001a\u00020(2\u0006\u0010[\u001a\u00020\u00172\u0006\u0010\\\u001a\u00020\u00172\u0016\b\u0002\u0010]\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030_\u0018\u00010^2\b\b\u0002\u0010`\u001a\u00020\b2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\b\b\u0002\u0010a\u001a\u00020b2\b\b\u0002\u00109\u001a\u00020.2\b\b\u0002\u0010;\u001a\u00020.2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00172\u000e\b\u0002\u0010c\u001a\b\u0012\u0004\u0012\u00020(0'2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020(0'H\u0001¢\u0006\u0002\bdJ\b\u0010e\u001a\u00020(H\u0002J\b\u0010f\u001a\u00020(H\u0014J0\u0010g\u001a\u00020(2\u0006\u0010h\u001a\u00020.2\u0006\u0010i\u001a\u00020\b2\u0006\u0010j\u001a\u00020\b2\u0006\u0010k\u001a\u00020\b2\u0006\u0010l\u001a\u00020\bH\u0014J\b\u0010m\u001a\u00020(H\u0002J\u000e\u0010n\u001a\u0004\u0018\u00010o*\u00020pH\u0002J\u0016\u0010q\u001a\u0004\u0018\u00010\u0017*\u00020K2\u0006\u0010r\u001a\u00020sH\u0002J\f\u0010t\u001a\u00020.*\u00020KH\u0002J\f\u0010u\u001a\u00020.*\u00020KH\u0002J\u001e\u0010v\u001a\u0004\u0018\u00010\u0017*\u00020p2\u0006\u0010w\u001a\u00020\b2\u0006\u0010x\u001a\u00020\bH\u0002J\f\u0010y\u001a\u00020.*\u00020KH\u0002J\f\u0010z\u001a\u00020G*\u00020KH\u0002R\u0010\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u00118\u0002X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017XD¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\u00198\u0000@\u0000X.¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R%\u0010%\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)0&X\u0004¢\u0006\b\n\u0000\u0012\u0004\b*\u0010\u001bR\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R \u00102\u001a\b\u0012\u0004\u0012\u00020\u001703X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00108\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020(0'X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010=\u001a\r\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)X\u000e¢\u0006\u0004\n\u0002\u0010>R\u000e\u0010?\u001a\u00020@X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER \u0010F\u001a\b\u0012\u0004\u0012\u00020G03X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00105\"\u0004\bI\u00107R\u0018\u0010J\u001a\u00020\u0017*\u00020K8BX\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0018\u0010N\u001a\u00020\b*\u00020K8BX\u0004¢\u0006\u0006\u001a\u0004\bO\u0010P¨\u0006{"}, d2 = {"Landroidx/compose/ui/tooling/ComposeViewAdapter;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "FakeActivityResultRegistryOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeActivityResultRegistryOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeActivityResultRegistryOwner$1;", "FakeOnBackPressedDispatcherOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1;", "FakeSavedStateRegistryOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeSavedStateRegistryOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeSavedStateRegistryOwner$1;", "FakeViewModelStoreOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeViewModelStoreOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeViewModelStoreOwner$1;", "TAG", "", "clock", "Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "getClock$ui_tooling_release$annotations", "()V", "getClock$ui_tooling_release", "()Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "setClock$ui_tooling_release", "(Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;)V", "composableName", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "composition", "Landroidx/compose/runtime/Composition;", "content", "Landroidx/compose/runtime/MutableState;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getContent$annotations", "debugBoundsPaint", "Landroid/graphics/Paint;", "debugPaintBounds", "", "debugViewInfos", "delayedException", "Landroidx/compose/ui/tooling/ThreadSafeException;", "designInfoList", "", "getDesignInfoList$ui_tooling_release", "()Ljava/util/List;", "setDesignInfoList$ui_tooling_release", "(Ljava/util/List;)V", "designInfoProvidersArgument", "forceCompositionInvalidation", "hasAnimations", "lookForDesignInfoProviders", "onDraw", "previewComposition", "Lkotlin/jvm/functions/Function2;", "slotTableRecord", "Landroidx/compose/ui/tooling/CompositionDataRecord;", "stitchTrees", "getStitchTrees$ui_tooling_release", "()Z", "setStitchTrees$ui_tooling_release", "(Z)V", "viewInfos", "Landroidx/compose/ui/tooling/ViewInfo;", "getViewInfos$ui_tooling_release", "setViewInfos$ui_tooling_release", "fileName", "Landroidx/compose/ui/tooling/data/Group;", "getFileName", "(Landroidx/compose/ui/tooling/data/Group;)Ljava/lang/String;", "lineNumber", "getLineNumber", "(Landroidx/compose/ui/tooling/data/Group;)I", "WrapPreview", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispose", "dispose$ui_tooling_release", "findAndTrackAnimations", "findDesignInfoProviders", "init", "className", "methodName", "parameterProvider", "Ljava/lang/Class;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "parameterProviderIndex", "animationClockStartTime", "", "onCommit", "init$ui_tooling_release", "invalidateComposition", "onAttachedToWindow", "onLayout", "changed", "left", "top", "right", "bottom", "processViewInfos", "getDesignInfoMethodOrNull", "Ljava/lang/reflect/Method;", "", "getDesignInfoOrNull", "box", "Landroidx/compose/ui/unit/IntRect;", "hasDesignInfo", "hasNullSourcePosition", "invokeGetDesignInfo", "x", "y", "isNullGroup", "toViewInfo", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposeViewAdapter.kt */
public final class ComposeViewAdapter extends FrameLayout {
    private final ComposeViewAdapter$FakeActivityResultRegistryOwner$1 FakeActivityResultRegistryOwner;
    private final ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1 FakeOnBackPressedDispatcherOwner;
    /* access modifiers changed from: private */
    public final ComposeViewAdapter$FakeSavedStateRegistryOwner$1 FakeSavedStateRegistryOwner;
    private final ComposeViewAdapter$FakeViewModelStoreOwner$1 FakeViewModelStoreOwner;
    private final String TAG = "ComposeViewAdapter";
    public PreviewAnimationClock clock;
    private String composableName;
    private final ComposeView composeView;
    private Composition composition;
    private final MutableState<Function2<Composer, Integer, Unit>> content;
    private final Paint debugBoundsPaint;
    private boolean debugPaintBounds;
    private boolean debugViewInfos;
    /* access modifiers changed from: private */
    public final ThreadSafeException delayedException;
    private List<String> designInfoList;
    private String designInfoProvidersArgument;
    private boolean forceCompositionInvalidation;
    private boolean hasAnimations;
    private boolean lookForDesignInfoProviders;
    private Function0<Unit> onDraw;
    private Function2<? super Composer, ? super Integer, Unit> previewComposition;
    /* access modifiers changed from: private */
    public final CompositionDataRecord slotTableRecord;
    private boolean stitchTrees;
    private List<ViewInfo> viewInfos;

    public static /* synthetic */ void getClock$ui_tooling_release$annotations() {
    }

    private static /* synthetic */ void getContent$annotations() {
    }

    public final List<ViewInfo> getViewInfos$ui_tooling_release() {
        return this.viewInfos;
    }

    public final void setViewInfos$ui_tooling_release(List<ViewInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.viewInfos = list;
    }

    public final List<String> getDesignInfoList$ui_tooling_release() {
        return this.designInfoList;
    }

    public final void setDesignInfoList$ui_tooling_release(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.designInfoList = list;
    }

    public final boolean getStitchTrees$ui_tooling_release() {
        return this.stitchTrees;
    }

    public final void setStitchTrees$ui_tooling_release(boolean z) {
        this.stitchTrees = z;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeViewAdapter(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.composeView = new ComposeView(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.viewInfos = CollectionsKt.emptyList();
        this.designInfoList = CollectionsKt.emptyList();
        this.slotTableRecord = CompositionDataRecord.Companion.create();
        this.composableName = "";
        this.delayedException = new ThreadSafeException();
        this.previewComposition = ComposableSingletons$ComposeViewAdapterKt.INSTANCE.m5902getLambda2$ui_tooling_release();
        this.content = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposeViewAdapterKt.emptyContent, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.designInfoProvidersArgument = "";
        this.onDraw = ComposeViewAdapter$onDraw$1.INSTANCE;
        this.stitchTrees = true;
        Paint paint = new Paint();
        Paint $this$debugBoundsPaint_u24lambda_u240 = paint;
        $this$debugBoundsPaint_u24lambda_u240.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, 0.0f));
        $this$debugBoundsPaint_u24lambda_u240.setStyle(Paint.Style.STROKE);
        $this$debugBoundsPaint_u24lambda_u240.setColor(ColorKt.m3218toArgb8_81llA(Color.Companion.m3198getRed0d7_KjU()));
        this.debugBoundsPaint = paint;
        this.FakeSavedStateRegistryOwner = new ComposeViewAdapter$FakeSavedStateRegistryOwner$1();
        this.FakeViewModelStoreOwner = new ComposeViewAdapter$FakeViewModelStoreOwner$1();
        this.FakeOnBackPressedDispatcherOwner = new ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1(this);
        this.FakeActivityResultRegistryOwner = new ComposeViewAdapter$FakeActivityResultRegistryOwner$1();
        init(attrs);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeViewAdapter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.composeView = new ComposeView(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.viewInfos = CollectionsKt.emptyList();
        this.designInfoList = CollectionsKt.emptyList();
        this.slotTableRecord = CompositionDataRecord.Companion.create();
        this.composableName = "";
        this.delayedException = new ThreadSafeException();
        this.previewComposition = ComposableSingletons$ComposeViewAdapterKt.INSTANCE.m5902getLambda2$ui_tooling_release();
        this.content = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposeViewAdapterKt.emptyContent, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.designInfoProvidersArgument = "";
        this.onDraw = ComposeViewAdapter$onDraw$1.INSTANCE;
        this.stitchTrees = true;
        Paint paint = new Paint();
        Paint $this$debugBoundsPaint_u24lambda_u240 = paint;
        $this$debugBoundsPaint_u24lambda_u240.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, 0.0f));
        $this$debugBoundsPaint_u24lambda_u240.setStyle(Paint.Style.STROKE);
        $this$debugBoundsPaint_u24lambda_u240.setColor(ColorKt.m3218toArgb8_81llA(Color.Companion.m3198getRed0d7_KjU()));
        this.debugBoundsPaint = paint;
        this.FakeSavedStateRegistryOwner = new ComposeViewAdapter$FakeSavedStateRegistryOwner$1();
        this.FakeViewModelStoreOwner = new ComposeViewAdapter$FakeViewModelStoreOwner$1();
        this.FakeOnBackPressedDispatcherOwner = new ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1(this);
        this.FakeActivityResultRegistryOwner = new ComposeViewAdapter$FakeActivityResultRegistryOwner$1();
        init(attrs);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getSourceFile();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getFileName(androidx.compose.ui.tooling.data.Group r2) {
        /*
            r1 = this;
            androidx.compose.ui.tooling.data.SourceLocation r0 = r2.getLocation()
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.getSourceFile()
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = ""
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ComposeViewAdapter.getFileName(androidx.compose.ui.tooling.data.Group):java.lang.String");
    }

    private final int getLineNumber(Group $this$lineNumber) {
        SourceLocation location = $this$lineNumber.getLocation();
        if (location != null) {
            return location.getLineNumber();
        }
        return -1;
    }

    private final boolean hasNullSourcePosition(Group $this$hasNullSourcePosition) {
        return (getFileName($this$hasNullSourcePosition).length() == 0) && getLineNumber($this$hasNullSourcePosition) == -1;
    }

    private final boolean isNullGroup(Group $this$isNullGroup) {
        if (hasNullSourcePosition($this$isNullGroup) && $this$isNullGroup.getChildren().isEmpty()) {
            LayoutInfo layoutInfo = null;
            NodeGroup nodeGroup = $this$isNullGroup instanceof NodeGroup ? (NodeGroup) $this$isNullGroup : null;
            Object node = nodeGroup != null ? nodeGroup.getNode() : null;
            if (node instanceof LayoutInfo) {
                layoutInfo = (LayoutInfo) node;
            }
            if (layoutInfo == null) {
                return true;
            }
        }
        return false;
    }

    private final ViewInfo toViewInfo(Group $this$toViewInfo) {
        String str;
        LayoutInfo layoutInfo = null;
        NodeGroup nodeGroup = $this$toViewInfo instanceof NodeGroup ? (NodeGroup) $this$toViewInfo : null;
        Object node = nodeGroup != null ? nodeGroup.getNode() : null;
        if (node instanceof LayoutInfo) {
            layoutInfo = (LayoutInfo) node;
        }
        LayoutInfo layoutInfo2 = layoutInfo;
        if ($this$toViewInfo.getChildren().size() == 1 && hasNullSourcePosition($this$toViewInfo) && layoutInfo2 == null) {
            return toViewInfo((Group) CollectionsKt.single($this$toViewInfo.getChildren()));
        }
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$toViewInfo.getChildren()) {
            if (!isNullGroup((Group) element$iv$iv)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable<Group> $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Group it : $this$map$iv) {
            destination$iv$iv2.add(toViewInfo(it));
        }
        List childrenViewInfo = (List) destination$iv$iv2;
        SourceLocation location = $this$toViewInfo.getLocation();
        if (location == null || (str = location.getSourceFile()) == null) {
            str = "";
        }
        String str2 = str;
        SourceLocation location2 = $this$toViewInfo.getLocation();
        return new ViewInfo(str2, location2 != null ? location2.getLineNumber() : -1, $this$toViewInfo.getBox(), $this$toViewInfo.getLocation(), childrenViewInfo, layoutInfo2);
    }

    private final void processViewInfos() {
        List list;
        Iterable<CompositionData> $this$map$iv = this.slotTableRecord.getStore();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (CompositionData it : $this$map$iv) {
            destination$iv$iv.add(toViewInfo(SlotTreeKt.asTree(it)));
        }
        List newViewInfos = CollectionsKt.toList((List) destination$iv$iv);
        if (this.stitchTrees) {
            list = ShadowViewInfoKt.stitchTrees(newViewInfos);
        } else {
            list = newViewInfos;
        }
        this.viewInfos = list;
        if (this.debugViewInfos) {
            Log.d(this.TAG, ViewInfoUtilKt.toDebugString$default(list, 0, (Function1) null, 3, (Object) null));
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.delayedException.throwIfPresent();
        processViewInfos();
        if (this.composableName.length() > 0) {
            findAndTrackAnimations();
            if (this.lookForDesignInfoProviders) {
                findDesignInfoProviders();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        View rootView = this.composeView.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "composeView.rootView");
        ViewTreeLifecycleOwner.set(rootView, this.FakeSavedStateRegistryOwner);
        super.onAttachedToWindow();
    }

    private final void findAndTrackAnimations() {
        Iterable<CompositionData> $this$map$iv = this.slotTableRecord.getStore();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (CompositionData it : $this$map$iv) {
            destination$iv$iv.add(SlotTreeKt.asTree(it));
        }
        AnimationSearch it2 = new AnimationSearch(new ComposeViewAdapter$findAndTrackAnimations$1(this), new ComposeViewAdapter$findAndTrackAnimations$2(this));
        it2.findAll((Collection) ((List) destination$iv$iv));
        this.hasAnimations = it2.getHasAnimations();
        if (this.clock != null) {
            it2.trackAll();
        }
    }

    private final void findDesignInfoProviders() {
        int $i$f$flatMap;
        Iterable<CompositionData> $this$map$iv = this.slotTableRecord.getStore();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (CompositionData it : $this$map$iv) {
            destination$iv$iv.add(SlotTreeKt.asTree(it));
        }
        Object it$iv$iv = (List) destination$iv$iv;
        Iterable<Group> $this$flatMap$iv = (Iterable) it$iv$iv;
        int $i$f$flatMap2 = false;
        Collection destination$iv$iv2 = new ArrayList();
        for (Group rootGroup : $this$flatMap$iv) {
            Collection destination$iv$iv3 = new ArrayList();
            for (Group group : PreviewUtilsKt.findAll(rootGroup, new ComposeViewAdapter$findDesignInfoProviders$1$1(this))) {
                Object slotTrees = it$iv$iv;
                Iterable $this$flatMap$iv2 = $this$flatMap$iv;
                Object it$iv$iv2 = getDesignInfoOrNull(group, group.getBox());
                if (it$iv$iv2 == null) {
                    Iterator it2 = group.getChildren().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            $i$f$flatMap = $i$f$flatMap2;
                            it$iv$iv2 = null;
                            break;
                        }
                        Iterator it3 = it2;
                        $i$f$flatMap = $i$f$flatMap2;
                        it$iv$iv2 = getDesignInfoOrNull((Group) it2.next(), group.getBox());
                        if (it$iv$iv2 != null) {
                            break;
                        }
                        it2 = it3;
                        $i$f$flatMap2 = $i$f$flatMap;
                    }
                } else {
                    $i$f$flatMap = $i$f$flatMap2;
                }
                if (it$iv$iv2 != null) {
                    destination$iv$iv3.add(it$iv$iv2);
                }
                it$iv$iv = slotTrees;
                $this$flatMap$iv = $this$flatMap$iv2;
                $i$f$flatMap2 = $i$f$flatMap;
            }
            Iterable iterable = $this$flatMap$iv;
            int i = $i$f$flatMap2;
            CollectionsKt.addAll(destination$iv$iv2, (List) destination$iv$iv3);
            it$iv$iv = it$iv$iv;
        }
        Object slotTrees2 = it$iv$iv;
        this.designInfoList = (List) destination$iv$iv2;
    }

    /* access modifiers changed from: private */
    public final boolean hasDesignInfo(Group $this$hasDesignInfo) {
        Object it;
        Iterable $this$any$iv = $this$hasDesignInfo.getData();
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        Iterator it2 = $this$any$iv.iterator();
        while (it2.hasNext()) {
            Object it3 = it2.next();
            if ((it3 != null ? getDesignInfoMethodOrNull(it3) : null) != null) {
                it = 1;
                continue;
            } else {
                it = null;
                continue;
            }
            if (it != null) {
                return true;
            }
        }
        return false;
    }

    private final String getDesignInfoOrNull(Group $this$getDesignInfoOrNull, IntRect box) {
        String str;
        Iterator it = $this$getDesignInfoOrNull.getData().iterator();
        do {
            str = null;
            if (!it.hasNext()) {
                break;
            }
            Object it2 = it.next();
            if (it2 != null) {
                str = invokeGetDesignInfo(it2, box.getLeft(), box.getRight());
                continue;
            }
        } while (str == null);
        return str;
    }

    private final Method getDesignInfoMethodOrNull(Object $this$getDesignInfoMethodOrNull) {
        try {
            return $this$getDesignInfoMethodOrNull.getClass().getDeclaredMethod("getDesignInfo", new Class[]{Integer.TYPE, Integer.TYPE, String.class});
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private final String invokeGetDesignInfo(Object $this$invokeGetDesignInfo, int x, int y) {
        Method designInfoMethod = getDesignInfoMethodOrNull($this$invokeGetDesignInfo);
        if (designInfoMethod == null) {
            return null;
        }
        try {
            boolean z = false;
            Object result = designInfoMethod.invoke($this$invokeGetDesignInfo, new Object[]{Integer.valueOf(x), Integer.valueOf(y), this.designInfoProvidersArgument});
            Intrinsics.checkNotNull(result, "null cannot be cast to non-null type kotlin.String");
            CharSequence charSequence = (String) result;
            if (charSequence.length() == 0) {
                z = true;
            }
            if (z) {
                charSequence = null;
            }
            return (String) charSequence;
        } catch (Exception e) {
            return null;
        }
    }

    private final void invalidateComposition() {
        this.content.setValue(ComposableSingletons$ComposeViewAdapterKt.INSTANCE.m5903getLambda3$ui_tooling_release());
        this.content.setValue(this.previewComposition);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.forceCompositionInvalidation) {
            invalidateComposition();
        }
        this.onDraw.invoke();
        if (this.debugPaintBounds) {
            Collection destination$iv$iv = new ArrayList();
            for (ViewInfo it : this.viewInfos) {
                CollectionsKt.addAll(destination$iv$iv, CollectionsKt.plus(CollectionsKt.listOf(it), it.allChildren()));
            }
            for (ViewInfo it2 : (List) destination$iv$iv) {
                if (it2.hasBounds()) {
                    canvas.drawRect(new Rect(it2.getBounds().getLeft(), it2.getBounds().getTop(), it2.getBounds().getRight(), it2.getBounds().getBottom()), this.debugBoundsPaint);
                }
            }
        }
    }

    public final PreviewAnimationClock getClock$ui_tooling_release() {
        PreviewAnimationClock previewAnimationClock = this.clock;
        if (previewAnimationClock != null) {
            return previewAnimationClock;
        }
        Intrinsics.throwUninitializedPropertyAccessException("clock");
        return null;
    }

    public final void setClock$ui_tooling_release(PreviewAnimationClock previewAnimationClock) {
        Intrinsics.checkNotNullParameter(previewAnimationClock, "<set-?>");
        this.clock = previewAnimationClock;
    }

    /* access modifiers changed from: private */
    public final void WrapPreview(Function2<? super Composer, ? super Integer, Unit> content2, Composer $composer, int $changed) {
        Composer $composer2 = $composer.startRestartGroup(493526445);
        ComposerKt.sourceInformation($composer2, "C(WrapPreview)442@16065L428:ComposeViewAdapter.kt#hevd2p");
        int $dirty = $changed;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(493526445, $dirty, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.WrapPreview (ComposeViewAdapter.kt:437)");
        }
        ProvidableCompositionLocal<Font.ResourceLoader> localFontLoader = CompositionLocalsKt.getLocalFontLoader();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{localFontLoader.provides(new LayoutlibFontResourceLoader(context)), localFontFamilyResolver.provides(FontFamilyResolver_androidKt.createFontFamilyResolver(context2)), LocalOnBackPressedDispatcherOwner.INSTANCE.provides(this.FakeOnBackPressedDispatcherOwner), LocalActivityResultRegistryOwner.INSTANCE.provides(this.FakeActivityResultRegistryOwner)}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, -1966112531, true, new ComposeViewAdapter$WrapPreview$1(this, content2, $dirty)), $composer2, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ComposeViewAdapter$WrapPreview$2(this, content2, $changed));
        }
    }

    public static /* synthetic */ void init$ui_tooling_release$default(ComposeViewAdapter composeViewAdapter, String str, String str2, Class cls, int i, boolean z, boolean z2, long j, boolean z3, boolean z4, String str3, Function0 function0, Function0 function02, int i2, Object obj) {
        Class cls2;
        int i3;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        String str4;
        Function0 function03;
        Function0 function04;
        int i4 = i2;
        if ((i4 & 4) != 0) {
            cls2 = null;
        } else {
            cls2 = cls;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        if ((i4 & 16) != 0) {
            z5 = false;
        } else {
            z5 = z;
        }
        if ((i4 & 32) != 0) {
            z6 = false;
        } else {
            z6 = z2;
        }
        long j2 = (i4 & 64) != 0 ? -1 : j;
        if ((i4 & 128) != 0) {
            z7 = false;
        } else {
            z7 = z3;
        }
        if ((i4 & 256) != 0) {
            z8 = false;
        } else {
            z8 = z4;
        }
        if ((i4 & 512) != 0) {
            str4 = null;
        } else {
            str4 = str3;
        }
        if ((i4 & 1024) != 0) {
            function03 = ComposeViewAdapter$init$1.INSTANCE;
        } else {
            function03 = function0;
        }
        if ((i4 & 2048) != 0) {
            function04 = ComposeViewAdapter$init$2.INSTANCE;
        } else {
            function04 = function02;
        }
        composeViewAdapter.init$ui_tooling_release(str, str2, cls2, i3, z5, z6, j2, z7, z8, str4, function03, function04);
    }

    public final void init$ui_tooling_release(String className, String methodName, Class<? extends PreviewParameterProvider<?>> parameterProvider, int parameterProviderIndex, boolean debugPaintBounds2, boolean debugViewInfos2, long animationClockStartTime, boolean forceCompositionInvalidation2, boolean lookForDesignInfoProviders2, String designInfoProvidersArgument2, Function0<Unit> onCommit, Function0<Unit> onDraw2) {
        String str = methodName;
        Function0<Unit> function0 = onDraw2;
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(str, "methodName");
        Intrinsics.checkNotNullParameter(onCommit, "onCommit");
        Intrinsics.checkNotNullParameter(function0, "onDraw");
        this.debugPaintBounds = debugPaintBounds2;
        this.debugViewInfos = debugViewInfos2;
        this.composableName = str;
        this.forceCompositionInvalidation = forceCompositionInvalidation2;
        this.lookForDesignInfoProviders = lookForDesignInfoProviders2;
        this.designInfoProvidersArgument = designInfoProvidersArgument2 == null ? "" : designInfoProvidersArgument2;
        this.onDraw = function0;
        ComposeViewAdapter$init$3 composeViewAdapter$init$3 = r0;
        ComposeViewAdapter$init$3 composeViewAdapter$init$32 = new ComposeViewAdapter$init$3(onCommit, this, animationClockStartTime, className, methodName, parameterProvider, parameterProviderIndex);
        Function2<? super Composer, ? super Integer, Unit> composableLambdaInstance = ComposableLambdaKt.composableLambdaInstance(-1704541905, true, composeViewAdapter$init$3);
        this.previewComposition = composableLambdaInstance;
        this.composeView.setContent(composableLambdaInstance);
        invalidate();
    }

    public final void dispose$ui_tooling_release() {
        this.composeView.disposeComposition();
        if (this.clock != null) {
            getClock$ui_tooling_release().dispose();
        }
        this.FakeSavedStateRegistryOwner.getLifecycleRegistry().setCurrentState(Lifecycle.State.DESTROYED);
        this.FakeViewModelStoreOwner.getViewModelStore().clear();
    }

    public final boolean hasAnimations() {
        return this.hasAnimations;
    }

    private final void init(AttributeSet attrs) {
        long animationClockStartTime;
        AttributeSet attributeSet = attrs;
        ViewTreeLifecycleOwner.set(this, this.FakeSavedStateRegistryOwner);
        ViewTreeSavedStateRegistryOwner.set(this, this.FakeSavedStateRegistryOwner);
        ViewTreeViewModelStoreOwner.set(this, this.FakeViewModelStoreOwner);
        addView(this.composeView);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/tools", "composableName");
        if (attributeValue != null) {
            String composableName2 = attributeValue;
            String className = StringsKt.substringBeforeLast$default(composableName2, '.', (String) null, 2, (Object) null);
            String methodName = StringsKt.substringAfterLast$default(composableName2, '.', (String) null, 2, (Object) null);
            int parameterProviderIndex = attributeSet.getAttributeIntValue("http://schemas.android.com/tools", "parameterProviderIndex", 0);
            String attributeValue2 = attributeSet.getAttributeValue("http://schemas.android.com/tools", "parameterProviderClass");
            Class parameterProviderClass = attributeValue2 != null ? PreviewUtilsKt.asPreviewProviderClass(attributeValue2) : null;
            try {
                String attributeValue3 = attributeSet.getAttributeValue("http://schemas.android.com/tools", "animationClockStartTime");
                Intrinsics.checkNotNullExpressionValue(attributeValue3, "attrs.getAttributeValue(…animationClockStartTime\")");
                animationClockStartTime = Long.parseLong(attributeValue3);
            } catch (Exception e) {
                animationClockStartTime = -1;
            }
            String str = composableName2;
            init$ui_tooling_release$default(this, className, methodName, parameterProviderClass, parameterProviderIndex, attributeSet.getAttributeBooleanValue("http://schemas.android.com/tools", "paintBounds", this.debugPaintBounds), attributeSet.getAttributeBooleanValue("http://schemas.android.com/tools", "printViewInfos", this.debugViewInfos), animationClockStartTime, attributeSet.getAttributeBooleanValue("http://schemas.android.com/tools", "forceCompositionInvalidation", false), attributeSet.getAttributeBooleanValue("http://schemas.android.com/tools", "findDesignInfoProviders", this.lookForDesignInfoProviders), attributeSet.getAttributeValue("http://schemas.android.com/tools", "designInfoProvidersArgument"), (Function0) null, (Function0) null, 3072, (Object) null);
        }
    }
}
