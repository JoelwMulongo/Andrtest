package androidx.compose.ui.tooling;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.FloatingActionButtonElevation;
import androidx.compose.material.FloatingActionButtonKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PreviewActivity.kt */
final class PreviewActivity$setParameterizedContent$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ String $className;
    final /* synthetic */ String $methodName;
    final /* synthetic */ Object[] $previewParameters;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreviewActivity$setParameterizedContent$1(Object[] objArr, String str, String str2) {
        super(2);
        this.$previewParameters = objArr;
        this.$className = str;
        this.$methodName = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Object value$iv$iv;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C109@4590L30,111@4638L768:PreviewActivity.kt#hevd2p");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1735847170, i, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous> (PreviewActivity.kt:108)");
            }
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            final MutableState index = (MutableState) value$iv$iv;
            final Object[] objArr = this.$previewParameters;
            final MutableState index2 = index;
            final String str = this.$className;
            final String str2 = this.$methodName;
            final Object[] objArr2 = this.$previewParameters;
            MutableState mutableState = index2;
            ScaffoldKt.m1589Scaffold27mzLpw((Modifier) null, (ScaffoldState) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit>) null, ComposableLambdaKt.composableLambda(composer, 2137630662, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    int i = $changed;
                    ComposerKt.sourceInformation($composer, "C123@5159L207:PreviewActivity.kt#hevd2p");
                    if ((i & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2137630662, i, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous>.<anonymous> (PreviewActivity.kt:122)");
                        }
                        Function2<Composer, Integer, Unit> r3 = ComposableSingletons$PreviewActivityKt.INSTANCE.m5904getLambda1$ui_tooling_release();
                        final MutableState<Integer> mutableState = index;
                        final Object[] objArr = objArr;
                        FloatingActionButtonKt.m1524ExtendedFloatingActionButtonwqdebIU(r3, new Function0<Unit>() {
                            public final void invoke() {
                                MutableState<Integer> mutableState = mutableState;
                                mutableState.setValue(Integer.valueOf((mutableState.getValue().intValue() + 1) % objArr.length));
                            }
                        }, (Modifier) null, (Function2<? super Composer, ? super Integer, Unit>) null, (MutableInteractionSource) null, (Shape) null, 0, 0, (FloatingActionButtonElevation) null, $composer, 6, 508);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            }), 0, false, (Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit>) null, false, (Shape) null, 0.0f, 0, 0, 0, 0, 0, ComposableLambdaKt.composableLambda(composer, -1578412612, true, new Function3<PaddingValues, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                    invoke((PaddingValues) p1, (Composer) p2, ((Number) p3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues padding, Composer $composer, int $changed) {
                    PaddingValues paddingValues = padding;
                    Composer composer = $composer;
                    int i = $changed;
                    Intrinsics.checkNotNullParameter(paddingValues, "padding");
                    ComposerKt.sourceInformation(composer, "C113@4715L351:PreviewActivity.kt#hevd2p");
                    int $dirty = $changed;
                    if ((i & 14) == 0) {
                        $dirty |= composer.changed((Object) paddingValues) ? 4 : 2;
                    }
                    if (($dirty & 91) != 18 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1578412612, i, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous>.<anonymous> (PreviewActivity.kt:112)");
                        }
                        Modifier modifier$iv = PaddingKt.padding(Modifier.Companion, paddingValues);
                        String str = str;
                        String str2 = str2;
                        Object[] objArr = objArr2;
                        MutableState<Integer> mutableState = index2;
                        composer.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        composer.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Density density$iv$iv = (Density) consume;
                        int i2 = $dirty;
                        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                        Modifier modifier = modifier$iv;
                        int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
                        Alignment alignment = contentAlignment$iv;
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            composer.createNode(constructor);
                        } else {
                            $composer.useNode();
                        }
                        $composer.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer);
                        Function0<ComposeUiNode> function0 = constructor;
                        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
                        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
                        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
                        $composer.enableReusing();
                        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                        composer.startReplaceableGroup(2058660585);
                        int i3 = ($changed$iv$iv$iv >> 9) & 14;
                        Composer $composer$iv = $composer;
                        Density density = density$iv$iv;
                        LayoutDirection layoutDirection = layoutDirection$iv$iv;
                        ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i4 = ((0 >> 6) & 112) | 6;
                        Composer $composer2 = $composer$iv;
                        ComposerKt.sourceInformationMarkerStart($composer2, -513396387, "C:PreviewActivity.kt#hevd2p");
                        ComposableInvoker.INSTANCE.invokeComposable(str, str2, $composer2, objArr[mutableState.getValue().intValue()]);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        $composer.endReplaceableGroup();
                        $composer.endNode();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                    int i5 = $dirty;
                }
            }), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 12582912, 131039);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
