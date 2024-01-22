package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
    final /* synthetic */ Modifier $cursorModifier;
    final /* synthetic */ Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> $decorationBox;
    final /* synthetic */ Density $density;
    final /* synthetic */ Modifier $drawModifier;
    final /* synthetic */ Modifier $magnifierModifier;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ int $minLines;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ Modifier $onPositionedModifier;
    final /* synthetic */ Function1<TextLayoutResult, Unit> $onTextLayout;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;
    final /* synthetic */ boolean $showHandleAndMagnifier;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextStyle $textStyle;
    final /* synthetic */ TextFieldValue $value;
    final /* synthetic */ VisualTransformation $visualTransformation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$5(Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, int i, TextFieldState textFieldState, TextStyle textStyle, int i2, int i3, TextFieldScrollerPosition textFieldScrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4, BringIntoViewRequester bringIntoViewRequester, TextFieldSelectionManager textFieldSelectionManager, boolean z, boolean z2, Function1<? super TextLayoutResult, Unit> function1, OffsetMapping offsetMapping, Density density) {
        super(2);
        this.$decorationBox = function3;
        this.$$dirty1 = i;
        this.$state = textFieldState;
        this.$textStyle = textStyle;
        this.$minLines = i2;
        this.$maxLines = i3;
        this.$scrollerPosition = textFieldScrollerPosition;
        this.$value = textFieldValue;
        this.$visualTransformation = visualTransformation;
        this.$cursorModifier = modifier;
        this.$drawModifier = modifier2;
        this.$onPositionedModifier = modifier3;
        this.$magnifierModifier = modifier4;
        this.$bringIntoViewRequester = bringIntoViewRequester;
        this.$manager = textFieldSelectionManager;
        this.$showHandleAndMagnifier = z;
        this.$readOnly = z2;
        this.$onTextLayout = function1;
        this.$offsetMapping = offsetMapping;
        this.$density = density;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C564@25020L4485:CoreTextField.kt#423gt5");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-374338080, i, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:563)");
            }
            Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function3 = this.$decorationBox;
            final TextFieldState textFieldState = this.$state;
            final TextStyle textStyle = this.$textStyle;
            final int i2 = this.$minLines;
            final int i3 = this.$maxLines;
            final TextFieldScrollerPosition textFieldScrollerPosition = this.$scrollerPosition;
            final TextFieldValue textFieldValue = this.$value;
            final VisualTransformation visualTransformation = this.$visualTransformation;
            final Modifier modifier = this.$cursorModifier;
            final Modifier modifier2 = this.$drawModifier;
            final Modifier modifier3 = this.$onPositionedModifier;
            Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function32 = function3;
            AnonymousClass1 r3 = r4;
            final Modifier modifier4 = this.$magnifierModifier;
            final BringIntoViewRequester bringIntoViewRequester = this.$bringIntoViewRequester;
            final TextFieldSelectionManager textFieldSelectionManager = this.$manager;
            final boolean z = this.$showHandleAndMagnifier;
            final boolean z2 = this.$readOnly;
            final Function1<TextLayoutResult, Unit> function1 = this.$onTextLayout;
            final OffsetMapping offsetMapping = this.$offsetMapping;
            final Density density = this.$density;
            AnonymousClass1 r4 = new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C589@26124L3371:CoreTextField.kt#423gt5");
                    if (($changed & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2032502107, $changed, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:564)");
                        }
                        Modifier coreTextFieldModifier = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(HeightInLinesModifierKt.heightInLines(SizeKt.m818heightInVpY3zN4$default(Modifier.Companion, textFieldState.m1224getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, (Object) null), textStyle, i2, i3), textFieldScrollerPosition, textFieldValue, visualTransformation, new CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1(textFieldState)).then(modifier).then(modifier2), textStyle).then(modifier3).then(modifier4), bringIntoViewRequester);
                        final TextFieldSelectionManager textFieldSelectionManager = textFieldSelectionManager;
                        final TextFieldState textFieldState = textFieldState;
                        final boolean z = z;
                        final boolean z2 = z2;
                        final Function1<TextLayoutResult, Unit> function1 = function1;
                        final TextFieldValue textFieldValue = textFieldValue;
                        final OffsetMapping offsetMapping = offsetMapping;
                        final Density density = density;
                        final int i = i3;
                        SimpleLayoutKt.SimpleLayout(coreTextFieldModifier, ComposableLambdaKt.composableLambda($composer, -363167407, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                                invoke((Composer) p1, ((Number) p2).intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARNING: Removed duplicated region for block: B:34:0x0176  */
                            /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void invoke(androidx.compose.runtime.Composer r19, int r20) {
                                /*
                                    r18 = this;
                                    r0 = r18
                                    r1 = r19
                                    r2 = r20
                                    java.lang.String r3 = "C590@26178L2699,643@28895L327,655@29423L40:CoreTextField.kt#423gt5"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
                                    r3 = r2 & 11
                                    r4 = 2
                                    if (r3 != r4) goto L_0x001c
                                    boolean r3 = r19.getSkipping()
                                    if (r3 != 0) goto L_0x0017
                                    goto L_0x001c
                                L_0x0017:
                                    r19.skipToGroupEnd()
                                    goto L_0x0179
                                L_0x001c:
                                    boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r3 == 0) goto L_0x002b
                                    r3 = -1
                                    java.lang.String r4 = "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:589)"
                                    r5 = -363167407(0xffffffffea5a8151, float:-6.6039127E25)
                                    androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r3, r4)
                                L_0x002b:
                                    androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2 r3 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2
                                    androidx.compose.foundation.text.TextFieldState r7 = r3
                                    kotlin.jvm.functions.Function1<androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r8 = r6
                                    androidx.compose.ui.text.input.TextFieldValue r9 = r7
                                    androidx.compose.ui.text.input.OffsetMapping r10 = r8
                                    androidx.compose.ui.unit.Density r11 = r9
                                    int r12 = r10
                                    r6 = r3
                                    r6.<init>(r7, r8, r9, r10, r11, r12)
                                    androidx.compose.ui.layout.MeasurePolicy r3 = (androidx.compose.ui.layout.MeasurePolicy) r3
                                    r4 = 0
                                    r5 = r4
                                    r6 = 0
                                    r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
                                    r1.startReplaceableGroup(r7)
                                    java.lang.String r7 = "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r1, r7)
                                    androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
                                    androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
                                    androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
                                    androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
                                    r9 = 6
                                    r10 = 0
                                    r11 = 2023513938(0x789c5f52, float:2.5372864E34)
                                    java.lang.String r12 = "CC:CompositionLocal.kt#9igjgp"
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r11, r12)
                                    java.lang.Object r13 = r1.consume(r8)
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r19)
                                    r8 = r13
                                    androidx.compose.ui.unit.Density r8 = (androidx.compose.ui.unit.Density) r8
                                    androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
                                    androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
                                    r10 = 6
                                    r13 = 0
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r11, r12)
                                    java.lang.Object r14 = r1.consume(r9)
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r19)
                                    r9 = r14
                                    androidx.compose.ui.unit.LayoutDirection r9 = (androidx.compose.ui.unit.LayoutDirection) r9
                                    androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
                                    androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
                                    r13 = 6
                                    r14 = 0
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r11, r12)
                                    java.lang.Object r11 = r1.consume(r10)
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r19)
                                    r10 = r11
                                    androidx.compose.ui.platform.ViewConfiguration r10 = (androidx.compose.ui.platform.ViewConfiguration) r10
                                    androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
                                    kotlin.jvm.functions.Function3 r12 = androidx.compose.ui.layout.LayoutKt.materializerOf(r7)
                                    int r13 = r5 << 9
                                    r13 = r13 & 7168(0x1c00, float:1.0045E-41)
                                    r13 = r13 | 6
                                    r14 = 0
                                    androidx.compose.runtime.Applier r15 = r19.getApplier()
                                    boolean r15 = r15 instanceof androidx.compose.runtime.Applier
                                    if (r15 != 0) goto L_0x00b3
                                    androidx.compose.runtime.ComposablesKt.invalidApplier()
                                L_0x00b3:
                                    r19.startReusableNode()
                                    boolean r15 = r19.getInserting()
                                    if (r15 == 0) goto L_0x00c0
                                    r1.createNode(r11)
                                    goto L_0x00c3
                                L_0x00c0:
                                    r19.useNode()
                                L_0x00c3:
                                    androidx.compose.runtime.Composer r15 = androidx.compose.runtime.Updater.m2787constructorimpl(r19)
                                    r16 = 0
                                    androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r4 = r17.getSetMeasurePolicy()
                                    androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r15, r3, r4)
                                    androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r4 = r4.getSetDensity()
                                    androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r15, r8, r4)
                                    androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r4 = r4.getSetLayoutDirection()
                                    androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r15, r9, r4)
                                    androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r4 = r4.getSetViewConfiguration()
                                    androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r15, r10, r4)
                                    androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r19)
                                    androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r4)
                                    int r15 = r13 >> 3
                                    r15 = r15 & 112(0x70, float:1.57E-43)
                                    java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
                                    r12.invoke(r4, r1, r15)
                                    r4 = 2058660585(0x7ab4aae9, float:4.6903995E35)
                                    r1.startReplaceableGroup(r4)
                                    int r4 = r13 >> 9
                                    r4 = r4 & 14
                                    r15 = r19
                                    r16 = 0
                                    r2 = 1017243015(0x3ca1e587, float:0.019762767)
                                    r17 = r3
                                    java.lang.String r3 = "C:CoreTextField.kt#423gt5"
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r2, r3)
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
                                    r19.endReplaceableGroup()
                                    r19.endNode()
                                    r19.endReplaceableGroup()
                                    androidx.compose.foundation.text.selection.TextFieldSelectionManager r2 = r2
                                    androidx.compose.foundation.text.TextFieldState r3 = r3
                                    androidx.compose.foundation.text.HandleState r3 = r3.getHandleState()
                                    androidx.compose.foundation.text.HandleState r4 = androidx.compose.foundation.text.HandleState.Selection
                                    if (r3 != r4) goto L_0x0152
                                    androidx.compose.foundation.text.TextFieldState r3 = r3
                                    androidx.compose.ui.layout.LayoutCoordinates r3 = r3.getLayoutCoordinates()
                                    if (r3 == 0) goto L_0x0152
                                    androidx.compose.foundation.text.TextFieldState r3 = r3
                                    androidx.compose.ui.layout.LayoutCoordinates r3 = r3.getLayoutCoordinates()
                                    kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
                                    boolean r3 = r3.isAttached()
                                    if (r3 == 0) goto L_0x0152
                                    boolean r3 = r4
                                    if (r3 == 0) goto L_0x0152
                                    r4 = 1
                                    goto L_0x0153
                                L_0x0152:
                                    r4 = 0
                                L_0x0153:
                                    r3 = 8
                                    androidx.compose.foundation.text.CoreTextFieldKt.access$SelectionToolbarAndHandles(r2, r4, r1, r3)
                                    androidx.compose.foundation.text.TextFieldState r2 = r3
                                    androidx.compose.foundation.text.HandleState r2 = r2.getHandleState()
                                    androidx.compose.foundation.text.HandleState r4 = androidx.compose.foundation.text.HandleState.Cursor
                                    if (r2 != r4) goto L_0x0170
                                    boolean r2 = r5
                                    if (r2 != 0) goto L_0x0170
                                    boolean r2 = r4
                                    if (r2 == 0) goto L_0x0170
                                    androidx.compose.foundation.text.selection.TextFieldSelectionManager r2 = r2
                                    androidx.compose.foundation.text.CoreTextFieldKt.TextFieldCursorHandle(r2, r1, r3)
                                L_0x0170:
                                    boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r2 == 0) goto L_0x0179
                                    androidx.compose.runtime.ComposerKt.traceEventEnd()
                                L_0x0179:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.AnonymousClass1.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                            }
                        }), $composer, 48, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            };
            function32.invoke(ComposableLambdaKt.composableLambda(composer, 2032502107, true, r3), composer, Integer.valueOf(((this.$$dirty1 >> 12) & 112) | 6));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
