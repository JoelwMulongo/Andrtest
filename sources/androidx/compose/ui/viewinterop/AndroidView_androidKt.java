package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0001\u001au\u0010\n\u001a\u00020\u0006\"\b\b\u0000\u0010\u000b*\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u000b0\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00060\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00060\u00042\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0002\u0010\u0013\u001aK\u0010\n\u001a\u00020\u0006\"\b\b\u0000\u0010\u000b*\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u000b0\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0002\u0010\u0014\u001a9\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\"\b\b\u0000\u0010\u000b*\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u000b0\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0003¢\u0006\u0002\u0010\u001a\u001a\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u001c\"\b\b\u0000\u0010\u000b*\u00020\u0005*\u00020\u0017H\u0002\u001aQ\u0010\u001d\u001a\u00020\u0006\"\b\b\u0000\u0010\u000b*\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00170\u001e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\"\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006)"}, d2 = {"NoOpScrollConnection", "androidx/compose/ui/viewinterop/AndroidView_androidKt$NoOpScrollConnection$1", "Landroidx/compose/ui/viewinterop/AndroidView_androidKt$NoOpScrollConnection$1;", "NoOpUpdate", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "getNoOpUpdate", "()Lkotlin/jvm/functions/Function1;", "AndroidView", "T", "factory", "Landroid/content/Context;", "onReset", "modifier", "Landroidx/compose/ui/Modifier;", "update", "onRelease", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "createAndroidViewNodeFactory", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "requireViewFactoryHolder", "Landroidx/compose/ui/viewinterop/ViewFactoryHolder;", "updateViewHolderParams", "Landroidx/compose/runtime/Updater;", "density", "Landroidx/compose/ui/unit/Density;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "updateViewHolderParams-OlIkWs8", "(Landroidx/compose/runtime/Composer;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/unit/Density;Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;Landroidx/compose/ui/unit/LayoutDirection;)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidView.android.kt */
public final class AndroidView_androidKt {
    private static final AndroidView_androidKt$NoOpScrollConnection$1 NoOpScrollConnection = new AndroidView_androidKt$NoOpScrollConnection$1();
    private static final Function1<View, Unit> NoOpUpdate = AndroidView_androidKt$NoOpUpdate$1.INSTANCE;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v11, resolved type: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends android.view.View> void AndroidView(kotlin.jvm.functions.Function1<? super android.content.Context, ? extends T> r22, androidx.compose.ui.Modifier r23, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r6 = r22
            r7 = r26
            java.lang.String r0 = "factory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = -1783766393(0xffffffff95ade287, float:-7.023154E-26)
            r1 = r25
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AndroidView)100@5020L37,104@5219L7,105@5274L7,111@5657L7,112@5728L7,115@5795L49,114@5741L517:AndroidView.android.kt#z33iqn"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r26
            r2 = r27 & 1
            if (r2 == 0) goto L_0x0020
            r1 = r1 | 6
            goto L_0x002e
        L_0x0020:
            r2 = r7 & 14
            if (r2 != 0) goto L_0x002e
            boolean r2 = r8.changedInstance(r6)
            if (r2 == 0) goto L_0x002c
            r2 = 4
            goto L_0x002d
        L_0x002c:
            r2 = 2
        L_0x002d:
            r1 = r1 | r2
        L_0x002e:
            r2 = r27 & 2
            if (r2 == 0) goto L_0x0037
            r1 = r1 | 48
            r3 = r23
            goto L_0x004c
        L_0x0037:
            r3 = r7 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004a
            r3 = r23
            boolean r4 = r8.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0046
            r4 = 32
            goto L_0x0048
        L_0x0046:
            r4 = 16
        L_0x0048:
            r1 = r1 | r4
            goto L_0x004c
        L_0x004a:
            r3 = r23
        L_0x004c:
            r4 = r27 & 4
            if (r4 == 0) goto L_0x0055
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r24
            goto L_0x006a
        L_0x0055:
            r5 = r7 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0068
            r5 = r24
            boolean r9 = r8.changedInstance(r5)
            if (r9 == 0) goto L_0x0064
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r1 = r1 | r9
            goto L_0x006a
        L_0x0068:
            r5 = r24
        L_0x006a:
            r9 = r1
            r1 = r9 & 731(0x2db, float:1.024E-42)
            r10 = 146(0x92, float:2.05E-43)
            if (r1 != r10) goto L_0x007f
            boolean r1 = r8.getSkipping()
            if (r1 != 0) goto L_0x0078
            goto L_0x007f
        L_0x0078:
            r8.skipToGroupEnd()
            r10 = r3
            r11 = r5
            goto L_0x01a6
        L_0x007f:
            if (r2 == 0) goto L_0x0086
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0087
        L_0x0086:
            r1 = r3
        L_0x0087:
            if (r4 == 0) goto L_0x008c
            kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> r2 = NoOpUpdate
            goto L_0x008d
        L_0x008c:
            r2 = r5
        L_0x008d:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0099
            r3 = -1
            java.lang.String r4 = "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:95)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r9, r3, r4)
        L_0x0099:
            r0 = 0
            r3 = r0
            r4 = 0
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r8.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r5)
            r5 = 0
            r10 = r8
            r11 = 0
            java.lang.Object r12 = r10.rememberedValue()
            r13 = 0
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r12 != r14) goto L_0x00c4
            r14 = 0
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r15 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher
            r15.<init>()
            r14 = r15
            r10.updateRememberedValue(r14)
            goto L_0x00c5
        L_0x00c4:
            r14 = r12
        L_0x00c5:
            r8.endReplaceableGroup()
            r3 = r14
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r3 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r3
            androidx.compose.ui.viewinterop.AndroidView_androidKt$NoOpScrollConnection$1 r4 = NoOpScrollConnection
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r4 = (androidx.compose.ui.input.nestedscroll.NestedScrollConnection) r4
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll(r1, r4, r3)
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.ComposedModifierKt.materialize(r8, r4)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r10 = 6
            r11 = 0
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r13 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r12, r13)
            java.lang.Object r14 = r8.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r5 = r14
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r11 = 6
            r14 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r12, r13)
            java.lang.Object r15 = r8.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r16 = r15
            androidx.compose.ui.unit.LayoutDirection r16 = (androidx.compose.ui.unit.LayoutDirection) r16
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r11 = 6
            r14 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r12, r13)
            java.lang.Object r15 = r8.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r17 = r15
            androidx.lifecycle.LifecycleOwner r17 = (androidx.lifecycle.LifecycleOwner) r17
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r11 = 6
            r14 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r12, r13)
            java.lang.Object r12 = r8.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r18 = r12
            androidx.savedstate.SavedStateRegistryOwner r18 = (androidx.savedstate.SavedStateRegistryOwner) r18
            r10 = r9 & 14
            r10 = r10 | 64
            kotlin.jvm.functions.Function0 r10 = createAndroidViewNodeFactory(r6, r3, r8, r10)
            r15 = r10
            r19 = 0
            r10 = 1886828752(0x7076b8d0, float:3.0542695E29)
            r8.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(ComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r10)
            androidx.compose.runtime.Applier r10 = r8.getApplier()
            boolean r10 = r10 instanceof androidx.compose.ui.node.UiApplier
            if (r10 != 0) goto L_0x0157
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0157:
            r8.startNode()
            boolean r10 = r8.getInserting()
            if (r10 == 0) goto L_0x016b
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1 r10 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1
            r10.<init>(r15)
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            r8.createNode(r10)
            goto L_0x016e
        L_0x016b:
            r8.useNode()
        L_0x016e:
            androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m2787constructorimpl(r8)
            r20 = 0
            r10 = r14
            r11 = r4
            r12 = r5
            r13 = r17
            r23 = r0
            r0 = r14
            r14 = r18
            r21 = r15
            r15 = r16
            m6226updateViewHolderParamsOlIkWs8(r10, r11, r12, r13, r14, r15)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1$1 r10 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1$1.INSTANCE
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r0, r2, r10)
            r8.endNode()
            r8.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01a4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01a4:
            r10 = r1
            r11 = r2
        L_0x01a6:
            androidx.compose.runtime.ScopeUpdateScope r12 = r8.endRestartGroup()
            if (r12 != 0) goto L_0x01ad
            goto L_0x01c0
        L_0x01ad:
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2 r13 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2
            r0 = r13
            r1 = r22
            r2 = r10
            r3 = r11
            r4 = r26
            r5 = r27
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x01c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends android.view.View> void AndroidView(kotlin.jvm.functions.Function1<? super android.content.Context, ? extends T> r24, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r25, androidx.compose.ui.Modifier r26, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r27, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r8 = r24
            r9 = r25
            r10 = r30
            java.lang.String r0 = "factory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "onReset"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = -841537049(0xffffffffcdd729e7, float:-4.51230944E8)
            r1 = r29
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AndroidView)P(!1,3!1,4)203@11119L37,208@11319L7,209@11374L7,215@11757L7,216@11828L7,219@11903L49,218@11841L679:AndroidView.android.kt#z33iqn"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r30
            r2 = r31 & 1
            if (r2 == 0) goto L_0x0028
            r1 = r1 | 6
            goto L_0x0036
        L_0x0028:
            r2 = r10 & 14
            if (r2 != 0) goto L_0x0036
            boolean r2 = r11.changedInstance(r8)
            if (r2 == 0) goto L_0x0034
            r2 = 4
            goto L_0x0035
        L_0x0034:
            r2 = 2
        L_0x0035:
            r1 = r1 | r2
        L_0x0036:
            r2 = r31 & 2
            if (r2 == 0) goto L_0x003d
            r1 = r1 | 48
            goto L_0x004d
        L_0x003d:
            r2 = r10 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004d
            boolean r2 = r11.changedInstance(r9)
            if (r2 == 0) goto L_0x004a
            r2 = 32
            goto L_0x004c
        L_0x004a:
            r2 = 16
        L_0x004c:
            r1 = r1 | r2
        L_0x004d:
            r2 = r31 & 4
            if (r2 == 0) goto L_0x0056
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r26
            goto L_0x006b
        L_0x0056:
            r3 = r10 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0069
            r3 = r26
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0065
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0065:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r1 = r1 | r4
            goto L_0x006b
        L_0x0069:
            r3 = r26
        L_0x006b:
            r4 = r31 & 8
            if (r4 == 0) goto L_0x0074
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r27
            goto L_0x0089
        L_0x0074:
            r5 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0087
            r5 = r27
            boolean r6 = r11.changedInstance(r5)
            if (r6 == 0) goto L_0x0083
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0083:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r1 = r1 | r6
            goto L_0x0089
        L_0x0087:
            r5 = r27
        L_0x0089:
            r6 = r31 & 16
            if (r6 == 0) goto L_0x0092
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r7 = r28
            goto L_0x00a9
        L_0x0092:
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r10
            if (r7 != 0) goto L_0x00a7
            r7 = r28
            boolean r12 = r11.changedInstance(r7)
            if (r12 == 0) goto L_0x00a3
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a5
        L_0x00a3:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x00a5:
            r1 = r1 | r12
            goto L_0x00a9
        L_0x00a7:
            r7 = r28
        L_0x00a9:
            r12 = r1
            r1 = 46811(0xb6db, float:6.5596E-41)
            r1 = r1 & r12
            r13 = 9362(0x2492, float:1.3119E-41)
            if (r1 != r13) goto L_0x00c1
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L_0x00b9
            goto L_0x00c1
        L_0x00b9:
            r11.skipToGroupEnd()
            r13 = r3
            r14 = r5
            r15 = r7
            goto L_0x0202
        L_0x00c1:
            if (r2 == 0) goto L_0x00c8
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x00c9
        L_0x00c8:
            r1 = r3
        L_0x00c9:
            if (r4 == 0) goto L_0x00ce
            kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> r2 = NoOpUpdate
            goto L_0x00cf
        L_0x00ce:
            r2 = r5
        L_0x00cf:
            if (r6 == 0) goto L_0x00d4
            kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> r3 = NoOpUpdate
            goto L_0x00d5
        L_0x00d4:
            r3 = r7
        L_0x00d5:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x00e1
            r4 = -1
            java.lang.String r5 = "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:187)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r4, r5)
        L_0x00e1:
            r0 = 0
            r4 = r0
            r5 = 0
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r6)
            r6 = 0
            r7 = r11
            r13 = 0
            java.lang.Object r14 = r7.rememberedValue()
            r15 = 0
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r16.getEmpty()
            if (r14 != r0) goto L_0x010d
            r0 = 0
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r16 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher
            r16.<init>()
            r0 = r16
            r7.updateRememberedValue(r0)
            goto L_0x010e
        L_0x010d:
            r0 = r14
        L_0x010e:
            r11.endReplaceableGroup()
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r0
            androidx.compose.ui.viewinterop.AndroidView_androidKt$NoOpScrollConnection$1 r4 = NoOpScrollConnection
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r4 = (androidx.compose.ui.input.nestedscroll.NestedScrollConnection) r4
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll(r1, r4, r0)
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.ComposedModifierKt.materialize(r11, r4)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r6 = 6
            r7 = 0
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r14 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r13, r14)
            java.lang.Object r15 = r11.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r5 = r15
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r7 = 6
            r15 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r13, r14)
            java.lang.Object r16 = r11.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r6 = r16
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r15 = 6
            r16 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r13, r14)
            java.lang.Object r17 = r11.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r7 = r17
            androidx.lifecycle.LifecycleOwner r7 = (androidx.lifecycle.LifecycleOwner) r7
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            r16 = 6
            r17 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r13, r14)
            java.lang.Object r13 = r11.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r19 = r13
            androidx.savedstate.SavedStateRegistryOwner r19 = (androidx.savedstate.SavedStateRegistryOwner) r19
            r13 = r12 & 14
            r13 = r13 | 64
            kotlin.jvm.functions.Function0 r13 = createAndroidViewNodeFactory(r8, r0, r11, r13)
            r15 = r13
            r13 = 0
            r20 = r13
            r21 = 0
            r13 = 1405779621(0x53ca7ea5, float:1.73941627E12)
            r11.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(ReusableComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r13)
            androidx.compose.runtime.Applier r13 = r11.getApplier()
            boolean r13 = r13 instanceof androidx.compose.ui.node.UiApplier
            if (r13 != 0) goto L_0x01a4
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01a4:
            r11.startReusableNode()
            boolean r13 = r11.getInserting()
            if (r13 == 0) goto L_0x01b8
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1 r13 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1
            r13.<init>(r15)
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r11.createNode(r13)
            goto L_0x01bb
        L_0x01b8:
            r11.useNode()
        L_0x01bb:
            androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m2787constructorimpl(r11)
            r22 = 0
            r13 = r14
            r26 = r0
            r0 = r14
            r14 = r4
            r23 = r15
            r15 = r5
            r16 = r7
            r17 = r19
            r18 = r6
            m6226updateViewHolderParamsOlIkWs8(r13, r14, r15, r16, r17, r18)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$1 r13 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$1.INSTANCE
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r0, r9, r13)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$2 r13 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$2.INSTANCE
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r0, r2, r13)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$3 r13 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$3.INSTANCE
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r0, r3, r13)
            r11.endNode()
            r11.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01ff
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ff:
            r13 = r1
            r14 = r2
            r15 = r3
        L_0x0202:
            androidx.compose.runtime.ScopeUpdateScope r7 = r11.endRestartGroup()
            if (r7 != 0) goto L_0x0209
            goto L_0x0223
        L_0x0209:
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4 r16 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4
            r0 = r16
            r1 = r24
            r2 = r25
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r30
            r8 = r7
            r7 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x0223:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final <T extends View> Function0<LayoutNode> createAndroidViewNodeFactory(Function1<? super Context, ? extends T> factory, NestedScrollDispatcher dispatcher, Composer $composer, int $changed) {
        Composer composer = $composer;
        composer.startReplaceableGroup(-430628662);
        ComposerKt.sourceInformation(composer, "C(createAndroidViewNodeFactory)P(1)240@12710L7,241@12744L28,242@12824L7,243@12851L23:AndroidView.android.kt#z33iqn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-430628662, $changed, -1, "androidx.compose.ui.viewinterop.createAndroidViewNodeFactory (AndroidView.android.kt:236)");
        } else {
            int i = $changed;
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd($composer);
        CompositionContext parentReference = ComposablesKt.rememberCompositionContext(composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(SaveableStateRegistryKt.getLocalSaveableStateRegistry());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Function0<LayoutNode> androidView_androidKt$createAndroidViewNodeFactory$1 = new AndroidView_androidKt$createAndroidViewNodeFactory$1((Context) consume, factory, parentReference, dispatcher, (SaveableStateRegistry) consume2, String.valueOf(ComposablesKt.getCurrentCompositeKeyHash(composer, 0)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return androidView_androidKt$createAndroidViewNodeFactory$1;
    }

    /* renamed from: updateViewHolderParams-OlIkWs8  reason: not valid java name */
    private static final <T extends View> void m6226updateViewHolderParamsOlIkWs8(Composer $this$updateViewHolderParams_u2dOlIkWs8, Modifier modifier, Density density, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, LayoutDirection layoutDirection) {
        Updater.m2794setimpl($this$updateViewHolderParams_u2dOlIkWs8, modifier, AndroidView_androidKt$updateViewHolderParams$1.INSTANCE);
        Updater.m2794setimpl($this$updateViewHolderParams_u2dOlIkWs8, density, AndroidView_androidKt$updateViewHolderParams$2.INSTANCE);
        Updater.m2794setimpl($this$updateViewHolderParams_u2dOlIkWs8, lifecycleOwner, AndroidView_androidKt$updateViewHolderParams$3.INSTANCE);
        Updater.m2794setimpl($this$updateViewHolderParams_u2dOlIkWs8, savedStateRegistryOwner, AndroidView_androidKt$updateViewHolderParams$4.INSTANCE);
        Updater.m2794setimpl($this$updateViewHolderParams_u2dOlIkWs8, layoutDirection, AndroidView_androidKt$updateViewHolderParams$5.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static final <T extends View> ViewFactoryHolder<T> requireViewFactoryHolder(LayoutNode $this$requireViewFactoryHolder) {
        AndroidViewHolder interopViewFactoryHolder$ui_release = $this$requireViewFactoryHolder.getInteropViewFactoryHolder$ui_release();
        if (interopViewFactoryHolder$ui_release != null) {
            Intrinsics.checkNotNull(interopViewFactoryHolder$ui_release, "null cannot be cast to non-null type androidx.compose.ui.viewinterop.ViewFactoryHolder<T of androidx.compose.ui.viewinterop.AndroidView_androidKt.requireViewFactoryHolder>");
            return (ViewFactoryHolder) interopViewFactoryHolder$ui_release;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final Function1<View, Unit> getNoOpUpdate() {
        return NoOpUpdate;
    }
}
