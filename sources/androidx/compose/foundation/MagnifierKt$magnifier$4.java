package androidx.compose.foundation;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Magnifier.kt */
final class MagnifierKt$magnifier$4 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Function1<Density, Offset> $magnifierCenter;
    final /* synthetic */ Function1<DpSize, Unit> $onSizeChanged;
    final /* synthetic */ PlatformMagnifierFactory $platformMagnifierFactory;
    final /* synthetic */ Function1<Density, Offset> $sourceCenter;
    final /* synthetic */ MagnifierStyle $style;
    final /* synthetic */ float $zoom;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MagnifierKt$magnifier$4(Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, float f, Function1<? super DpSize, Unit> function13, PlatformMagnifierFactory platformMagnifierFactory, MagnifierStyle magnifierStyle) {
        super(3);
        this.$sourceCenter = function1;
        this.$magnifierCenter = function12;
        this.$zoom = f;
        this.$onSizeChanged = function13;
        this.$platformMagnifierFactory = platformMagnifierFactory;
        this.$style = magnifierStyle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Object value$iv$iv4;
        Object value$iv$iv5;
        Object value$iv$iv6;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        composer.startReplaceableGroup(-454877003);
        ComposerKt.sourceInformation(composer, "C273@11641L7,274@11680L7,275@11728L47,276@11807L34,277@11876L37,278@11937L26,279@11996L35,280@12062L331,290@12422L62,295@12614L107,307@13298L2602,373@15957L344,385@16670L78:Magnifier.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-454877003, $changed, -1, "androidx.compose.foundation.magnifier.<anonymous> (Magnifier.kt:272)");
        } else {
            int i = $changed;
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        ComposerKt.sourceInformationMarkerEnd($composer);
        View view = (View) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume2;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2904boximpl(Offset.Companion.m2930getUnspecifiedF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        MutableState anchorPositionInRoot$delegate = (MutableState) value$iv$iv;
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$sourceCenter, composer, 0);
        State updatedMagnifierCenter$delegate = SnapshotStateKt.rememberUpdatedState(this.$magnifierCenter, composer, 0);
        State updatedZoom$delegate = SnapshotStateKt.rememberUpdatedState(Float.valueOf(this.$zoom), composer, 0);
        State updatedOnSizeChanged$delegate = SnapshotStateKt.rememberUpdatedState(this.$onSizeChanged, composer, 0);
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv2 = SnapshotStateKt.derivedStateOf(new MagnifierKt$magnifier$4$sourceCenterInRoot$2$1(density, rememberUpdatedState, anchorPositionInRoot$delegate));
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        State sourceCenterInRoot$delegate = (State) value$iv$iv2;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv3 = $composer;
        Object it$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
        State<T> state = rememberUpdatedState;
        if (it$iv$iv3 == Composer.Companion.getEmpty()) {
            value$iv$iv3 = SnapshotStateKt.derivedStateOf(new MagnifierKt$magnifier$4$isMagnifierShown$2$1(sourceCenterInRoot$delegate));
            $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
        } else {
            value$iv$iv3 = it$iv$iv3;
        }
        $composer.endReplaceableGroup();
        State isMagnifierShown$delegate = (State) value$iv$iv3;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv4 = $composer;
        Object it$iv$iv4 = $this$cache$iv$iv4.rememberedValue();
        if (it$iv$iv4 == Composer.Companion.getEmpty()) {
            value$iv$iv4 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);
            $this$cache$iv$iv4.updateRememberedValue(value$iv$iv4);
        } else {
            value$iv$iv4 = it$iv$iv4;
        }
        $composer.endReplaceableGroup();
        final MutableSharedFlow onNeedsUpdate = (MutableSharedFlow) value$iv$iv4;
        Float valueOf = Float.valueOf(this.$platformMagnifierFactory.getCanUpdateZoom() ? 0.0f : this.$zoom);
        MagnifierStyle magnifierStyle = this.$style;
        Object[] objArr = {view, density, valueOf, magnifierStyle, Boolean.valueOf(Intrinsics.areEqual((Object) magnifierStyle, (Object) MagnifierStyle.Companion.getTextDefault()))};
        final PlatformMagnifierFactory platformMagnifierFactory = this.$platformMagnifierFactory;
        final MagnifierStyle magnifierStyle2 = this.$style;
        final View view2 = view;
        final Density density2 = density;
        Object[] objArr2 = objArr;
        final float f = this.$zoom;
        final MutableSharedFlow mutableSharedFlow = onNeedsUpdate;
        final State state2 = updatedOnSizeChanged$delegate;
        final State state3 = isMagnifierShown$delegate;
        final State state4 = sourceCenterInRoot$delegate;
        final State state5 = updatedMagnifierCenter$delegate;
        final MutableState mutableState = anchorPositionInRoot$delegate;
        final State state6 = updatedZoom$delegate;
        EffectsKt.LaunchedEffect(objArr2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1((Continuation<? super AnonymousClass1>) null), composer, 72);
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) anchorPositionInRoot$delegate);
        Composer $this$cache$iv$iv5 = $composer;
        Object it$iv$iv5 = $this$cache$iv$iv5.rememberedValue();
        if (invalid$iv$iv || it$iv$iv5 == Composer.Companion.getEmpty()) {
            value$iv$iv5 = (Function1) new MagnifierKt$magnifier$4$2$1(anchorPositionInRoot$delegate);
            $this$cache$iv$iv5.updateRememberedValue(value$iv$iv5);
        } else {
            value$iv$iv5 = it$iv$iv5;
        }
        $composer.endReplaceableGroup();
        Modifier drawBehind = DrawModifierKt.drawBehind(OnGloballyPositionedModifierKt.onGloballyPositioned($this$composed, (Function1) value$iv$iv5), new Function1<DrawScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((DrawScope) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(DrawScope $this$drawBehind) {
                Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
                onNeedsUpdate.tryEmit(Unit.INSTANCE);
            }
        });
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = composer.changed((Object) sourceCenterInRoot$delegate);
        Composer $this$cache$iv$iv6 = $composer;
        Object it$iv$iv6 = $this$cache$iv$iv6.rememberedValue();
        if (invalid$iv$iv2 || it$iv$iv6 == Composer.Companion.getEmpty()) {
            value$iv$iv6 = (Function1) new MagnifierKt$magnifier$4$4$1(sourceCenterInRoot$delegate);
            $this$cache$iv$iv6.updateRememberedValue(value$iv$iv6);
        } else {
            value$iv$iv6 = it$iv$iv6;
        }
        $composer.endReplaceableGroup();
        Modifier semantics$default = SemanticsModifierKt.semantics$default(drawBehind, false, (Function1) value$iv$iv6, 1, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return semantics$default;
    }

    /* access modifiers changed from: private */
    public static final long invoke$lambda$1(MutableState<Offset> $anchorPositionInRoot$delegate) {
        return ((Offset) $anchorPositionInRoot$delegate.getValue()).m2925unboximpl();
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$2(MutableState<Offset> $anchorPositionInRoot$delegate, long value) {
        $anchorPositionInRoot$delegate.setValue(Offset.m2904boximpl(value));
    }

    /* access modifiers changed from: private */
    public static final Function1<Density, Offset> invoke$lambda$3(State<? extends Function1<? super Density, Offset>> $updatedSourceCenter$delegate) {
        return (Function1) $updatedSourceCenter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Function1<Density, Offset> invoke$lambda$4(State<? extends Function1<? super Density, Offset>> $updatedMagnifierCenter$delegate) {
        return (Function1) $updatedMagnifierCenter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final float invoke$lambda$5(State<Float> $updatedZoom$delegate) {
        return ((Number) $updatedZoom$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final Function1<DpSize, Unit> invoke$lambda$6(State<? extends Function1<? super DpSize, Unit>> $updatedOnSizeChanged$delegate) {
        return (Function1) $updatedOnSizeChanged$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final long invoke$lambda$8(State<Offset> $sourceCenterInRoot$delegate) {
        return ((Offset) $sourceCenterInRoot$delegate.getValue()).m2925unboximpl();
    }

    /* access modifiers changed from: private */
    public static final boolean invoke$lambda$10(State<Boolean> $isMagnifierShown$delegate) {
        return ((Boolean) $isMagnifierShown$delegate.getValue()).booleanValue();
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.MagnifierKt$magnifier$4$1", f = "Magnifier.kt", i = {0}, l = {365}, m = "invokeSuspend", n = {"magnifier"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$1  reason: invalid class name */
    /* compiled from: Magnifier.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r1 = new AnonymousClass1(platformMagnifierFactory, magnifierStyle2, view2, density2, f, mutableSharedFlow, state2, state3, state4, state5, mutableState, state6, continuation);
            r1.L$0 = obj;
            return r1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: androidx.compose.foundation.PlatformMagnifier} */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b4, code lost:
            r4.dismiss();
            r0 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x00ba, code lost:
            return kotlin.Unit.INSTANCE;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                r20 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                r1 = r20
                int r2 = r1.label
                switch(r2) {
                    case 0: goto L_0x0024;
                    case 1: goto L_0x0013;
                    default: goto L_0x000b;
                }
            L_0x000b:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0013:
                r2 = r20
                r3 = r21
                java.lang.Object r0 = r2.L$0
                r4 = r0
                androidx.compose.foundation.PlatformMagnifier r4 = (androidx.compose.foundation.PlatformMagnifier) r4
                kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x0021 }
                goto L_0x00b4
            L_0x0021:
                r0 = move-exception
                goto L_0x00bd
            L_0x0024:
                kotlin.ResultKt.throwOnFailure(r21)
                r2 = r20
                r3 = r21
                java.lang.Object r4 = r2.L$0
                kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
                androidx.compose.foundation.PlatformMagnifierFactory r5 = r11
                androidx.compose.foundation.MagnifierStyle r6 = r12
                android.view.View r7 = r13
                androidx.compose.ui.unit.Density r8 = r14
                float r9 = r15
                androidx.compose.foundation.PlatformMagnifier r5 = r5.create(r6, r7, r8, r9)
                kotlin.jvm.internal.Ref$LongRef r6 = new kotlin.jvm.internal.Ref$LongRef
                r6.<init>()
                long r7 = r5.m520getSizeYbymL2g()
                androidx.compose.ui.unit.Density r9 = r14
                androidx.compose.runtime.State<kotlin.jvm.functions.Function1<androidx.compose.ui.unit.DpSize, kotlin.Unit>> r10 = r17
                r11 = r7
                r13 = 0
                kotlin.jvm.functions.Function1 r10 = androidx.compose.foundation.MagnifierKt$magnifier$4.invoke$lambda$6(r10)
                if (r10 == 0) goto L_0x0068
                r14 = 0
                r21 = r13
                r15 = r14
                long r13 = androidx.compose.ui.unit.IntSizeKt.m6156toSizeozmzZPI(r11)
                long r11 = r9.m5965toDpSizekrfVVM(r13)
                androidx.compose.ui.unit.DpSize r9 = androidx.compose.ui.unit.DpSize.m6072boximpl(r11)
                r10.invoke(r9)
                goto L_0x006a
            L_0x0068:
                r21 = r13
            L_0x006a:
                r6.element = r7
                kotlinx.coroutines.flow.MutableSharedFlow<kotlin.Unit> r7 = r16
                kotlinx.coroutines.flow.Flow r7 = (kotlinx.coroutines.flow.Flow) r7
                androidx.compose.foundation.MagnifierKt$magnifier$4$1$1 r8 = new androidx.compose.foundation.MagnifierKt$magnifier$4$1$1
                r9 = 0
                r8.<init>(r5, r9)
                kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
                kotlinx.coroutines.flow.Flow r7 = kotlinx.coroutines.flow.FlowKt.onEach(r7, r8)
                kotlinx.coroutines.flow.FlowKt.launchIn(r7, r4)
                androidx.compose.foundation.MagnifierKt$magnifier$4$1$2 r4 = new androidx.compose.foundation.MagnifierKt$magnifier$4$1$2     // Catch:{ all -> 0x00bb }
                androidx.compose.ui.unit.Density r12 = r14     // Catch:{ all -> 0x00bb }
                androidx.compose.runtime.State<java.lang.Boolean> r13 = r18     // Catch:{ all -> 0x00bb }
                androidx.compose.runtime.State<androidx.compose.ui.geometry.Offset> r14 = r19     // Catch:{ all -> 0x00bb }
                androidx.compose.runtime.State<kotlin.jvm.functions.Function1<androidx.compose.ui.unit.Density, androidx.compose.ui.geometry.Offset>> r15 = r20     // Catch:{ all -> 0x00bb }
                androidx.compose.runtime.MutableState<androidx.compose.ui.geometry.Offset> r7 = r21     // Catch:{ all -> 0x00bb }
                androidx.compose.runtime.State<java.lang.Float> r8 = r22     // Catch:{ all -> 0x00bb }
                androidx.compose.runtime.State<kotlin.jvm.functions.Function1<androidx.compose.ui.unit.DpSize, kotlin.Unit>> r9 = r17     // Catch:{ all -> 0x00bb }
                r10 = r4
                r11 = r5
                r16 = r7
                r17 = r8
                r18 = r6
                r19 = r9
                r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x00bb }
                kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4     // Catch:{ all -> 0x00bb }
                kotlinx.coroutines.flow.Flow r4 = androidx.compose.runtime.SnapshotStateKt.snapshotFlow(r4)     // Catch:{ all -> 0x00bb }
                r7 = r2
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch:{ all -> 0x00bb }
                r2.L$0 = r5     // Catch:{ all -> 0x00bb }
                r6 = 1
                r2.label = r6     // Catch:{ all -> 0x00bb }
                java.lang.Object r4 = kotlinx.coroutines.flow.FlowKt.collect(r4, r7)     // Catch:{ all -> 0x00bb }
                if (r4 != r0) goto L_0x00b3
                return r0
            L_0x00b3:
                r4 = r5
            L_0x00b4:
                r4.dismiss()
                r0 = r4
                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                return r4
            L_0x00bb:
                r0 = move-exception
                r4 = r5
            L_0x00bd:
                r4.dismiss()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierKt$magnifier$4.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
