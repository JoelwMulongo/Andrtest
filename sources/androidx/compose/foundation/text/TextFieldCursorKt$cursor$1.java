package androidx.compose.foundation.text;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldCursor.kt */
final class TextFieldCursorKt$cursor$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Brush $cursorBrush;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextFieldValue $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldCursorKt$cursor$1(Brush brush, TextFieldState textFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        super(3);
        this.$cursorBrush = brush;
        this.$state = textFieldState;
        this.$value = textFieldValue;
        this.$offsetMapping = offsetMapping;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        Object value$iv$iv;
        Modifier modifier;
        Modifier modifier2 = $this$composed;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
        composer.startReplaceableGroup(1634330012);
        ComposerKt.sourceInformation(composer, "C46@1774L27,49@1976L491:TextFieldCursor.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1634330012, $changed, -1, "androidx.compose.foundation.text.cursor.<anonymous> (TextFieldCursor.kt:45)");
        } else {
            int i = $changed;
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = AnimatableKt.Animatable$default(1.0f, 0.0f, 2, (Object) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        final Animatable cursorAlpha = (Animatable) value$iv$iv;
        Brush brush = this.$cursorBrush;
        boolean z = true;
        if (brush instanceof SolidColor) {
            if (((SolidColor) brush).m3529getValue0d7_KjU() == Color.Companion.m3200getUnspecified0d7_KjU()) {
                z = false;
            }
        }
        boolean isBrushSpecified = z;
        if (!this.$state.getHasFocus() || !TextRange.m5468getCollapsedimpl(this.$value.m5695getSelectiond9O1mEE()) || !isBrushSpecified) {
            modifier = Modifier.Companion;
        } else {
            EffectsKt.LaunchedEffect(this.$value.getAnnotatedString(), TextRange.m5462boximpl(this.$value.m5695getSelectiond9O1mEE()), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), composer, 512);
            final OffsetMapping offsetMapping = this.$offsetMapping;
            final Animatable animatable = cursorAlpha;
            final TextFieldValue textFieldValue = this.$value;
            final TextFieldState textFieldState = this.$state;
            final Brush brush2 = this.$cursorBrush;
            modifier = DrawModifierKt.drawWithContent(modifier2, new Function1<ContentDrawScope, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((ContentDrawScope) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(ContentDrawScope $this$drawWithContent) {
                    Rect rect;
                    TextLayoutResult value;
                    ContentDrawScope contentDrawScope = $this$drawWithContent;
                    Intrinsics.checkNotNullParameter(contentDrawScope, "$this$drawWithContent");
                    $this$drawWithContent.drawContent();
                    float cursorAlphaValue = RangesKt.coerceIn(animatable.getValue().floatValue(), 0.0f, 1.0f);
                    if (!(cursorAlphaValue == 0.0f)) {
                        int transformedOffset = offsetMapping.originalToTransformed(TextRange.m5474getStartimpl(textFieldValue.m5695getSelectiond9O1mEE()));
                        TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
                        if (layoutResult == null || (value = layoutResult.getValue()) == null || (rect = value.getCursorRect(transformedOffset)) == null) {
                            rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
                        }
                        Rect cursorRect = rect;
                        float cursorWidth = contentDrawScope.m5967toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
                        float f = (float) 2;
                        float cursorX = RangesKt.coerceAtMost(cursorRect.getLeft() + (cursorWidth / f), Size.m2984getWidthimpl($this$drawWithContent.m3772getSizeNHjbRc()) - (cursorWidth / f));
                        float f2 = cursorX;
                        DrawScope.m3739drawLine1RTmtNc$default(contentDrawScope, brush2, OffsetKt.Offset(cursorX, cursorRect.getTop()), OffsetKt.Offset(cursorX, cursorRect.getBottom()), cursorWidth, 0, (PathEffect) null, cursorAlphaValue, (ColorFilter) null, 0, 432, (Object) null);
                    }
                }
            });
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return modifier;
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1", f = "TextFieldCursor.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1  reason: invalid class name */
    /* compiled from: TextFieldCursor.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(cursorAlpha, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final Animatable<Float, AnimationVector1D> animatable = cursorAlpha;
                    this.label = 1;
                    if (BuildersKt.withContext(FixedMotionDurationScale.INSTANCE, new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                        int label;

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return 
                        }
