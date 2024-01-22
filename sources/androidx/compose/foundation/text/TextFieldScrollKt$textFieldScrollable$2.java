package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldScroll.kt */
final class TextFieldScrollKt$textFieldScrollable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldScrollKt$textFieldScrollable$2(TextFieldScrollerPosition textFieldScrollerPosition, boolean z, MutableInteractionSource mutableInteractionSource) {
        super(3);
        this.$scrollerPosition = textFieldScrollerPosition;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0114  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r19, androidx.compose.runtime.Composer r20, int r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            java.lang.String r2 = "$this$composed"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            r2 = 805428266(0x3001dc2a, float:4.72428E-10)
            r1.startReplaceableGroup(r2)
            java.lang.String r4 = "C67@2849L7,69@3018L388,69@2994L412,82@3558L352:TextFieldScroll.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r4)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0025
            r4 = -1
            java.lang.String r5 = "androidx.compose.foundation.text.textFieldScrollable.<anonymous> (TextFieldScroll.kt:65)"
            r6 = r21
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r6, r4, r5)
            goto L_0x0027
        L_0x0025:
            r6 = r21
        L_0x0027:
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 0
            r5 = 0
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r7, r8)
            java.lang.Object r7 = r1.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r20)
            androidx.compose.ui.unit.LayoutDirection r2 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r7 != r2) goto L_0x0044
            r2 = 1
            goto L_0x0045
        L_0x0044:
            r2 = 0
        L_0x0045:
            androidx.compose.foundation.text.TextFieldScrollerPosition r7 = r0.$scrollerPosition
            androidx.compose.foundation.gestures.Orientation r7 = r7.getOrientation()
            androidx.compose.foundation.gestures.Orientation r8 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r7 == r8) goto L_0x0054
            if (r2 != 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r13 = 0
            goto L_0x0055
        L_0x0054:
            r13 = 1
        L_0x0055:
            androidx.compose.foundation.text.TextFieldScrollerPosition r7 = r0.$scrollerPosition
            androidx.compose.foundation.text.TextFieldScrollerPosition r8 = r0.$scrollerPosition
            r9 = 0
            r10 = 0
            r11 = 1157296644(0x44faf204, float:2007.563)
            r1.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            boolean r11 = r1.changed((java.lang.Object) r7)
            r12 = r20
            r14 = 0
            java.lang.Object r15 = r12.rememberedValue()
            r16 = 0
            if (r11 != 0) goto L_0x0080
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r17.getEmpty()
            if (r15 != r4) goto L_0x007e
            goto L_0x0080
        L_0x007e:
            r4 = r15
            goto L_0x008d
        L_0x0080:
            r4 = 0
            androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$scrollableState$1$1 r5 = new androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$scrollableState$1$1
            r5.<init>(r8)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r4 = r5
            r12.updateRememberedValue(r4)
        L_0x008d:
            r20.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r5 = 0
            androidx.compose.foundation.gestures.ScrollableState r4 = androidx.compose.foundation.gestures.ScrollableStateKt.rememberScrollableState(r4, r1, r5)
            androidx.compose.foundation.text.TextFieldScrollerPosition r7 = r0.$scrollerPosition
            androidx.compose.foundation.text.TextFieldScrollerPosition r8 = r0.$scrollerPosition
            r9 = 0
            r10 = 0
            r11 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r1.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            boolean r11 = r1.changed((java.lang.Object) r4)
            boolean r12 = r1.changed((java.lang.Object) r7)
            r11 = r11 | r12
            r12 = r20
            r14 = 0
            java.lang.Object r15 = r12.rememberedValue()
            r16 = 0
            if (r11 != 0) goto L_0x00c9
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r17.getEmpty()
            if (r15 != r5) goto L_0x00c7
            goto L_0x00c9
        L_0x00c7:
            r1 = r15
            goto L_0x00d4
        L_0x00c9:
            r5 = 0
            androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1 r1 = new androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1
            r1.<init>(r4, r8)
            r12.updateRememberedValue(r1)
        L_0x00d4:
            r20.endReplaceableGroup()
            androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1 r1 = (androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1) r1
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.text.TextFieldScrollerPosition r7 = r0.$scrollerPosition
            androidx.compose.foundation.gestures.Orientation r11 = r7.getOrientation()
            boolean r7 = r0.$enabled
            if (r7 == 0) goto L_0x00f9
            androidx.compose.foundation.text.TextFieldScrollerPosition r7 = r0.$scrollerPosition
            float r7 = r7.getMaximum()
            r8 = 0
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x00f4
            r7 = 1
            goto L_0x00f5
        L_0x00f4:
            r7 = 0
        L_0x00f5:
            if (r7 != 0) goto L_0x00f9
            r12 = 1
            goto L_0x00fa
        L_0x00f9:
            r12 = 0
        L_0x00fa:
            r9 = r5
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            r10 = r1
            androidx.compose.foundation.gestures.ScrollableState r10 = (androidx.compose.foundation.gestures.ScrollableState) r10
            r14 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r15 = r0.$interactionSource
            r16 = 16
            r17 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.gestures.ScrollableKt.scrollable$default(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0117
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0117:
            r20.endReplaceableGroup()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
