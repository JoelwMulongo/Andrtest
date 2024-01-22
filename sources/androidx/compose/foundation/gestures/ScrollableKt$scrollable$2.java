package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
final class ScrollableKt$scrollable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ FlingBehavior $flingBehavior;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ OverscrollEffect $overscrollEffect;
    final /* synthetic */ boolean $reverseDirection;
    final /* synthetic */ ScrollableState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollableKt$scrollable$2(Orientation orientation, ScrollableState scrollableState, boolean z, MutableInteractionSource mutableInteractionSource, FlingBehavior flingBehavior, OverscrollEffect overscrollEffect, boolean z2) {
        super(3);
        this.$orientation = orientation;
        this.$state = scrollableState;
        this.$reverseDirection = z;
        this.$interactionSource = mutableInteractionSource;
        this.$flingBehavior = flingBehavior;
        this.$overscrollEffect = overscrollEffect;
        this.$enabled = z2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r19, androidx.compose.runtime.Composer r20, int r21) {
        /*
            r18 = this;
            r0 = r18
            r11 = r20
            java.lang.String r1 = "$this$composed"
            r12 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            r1 = -629830927(0xffffffffda758af1, float:-1.72785342E16)
            r11.startReplaceableGroup(r1)
            java.lang.String r2 = "C156@7453L24,158@7535L170,165@7822L242:Scrollable.kt#8bwon0"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0025
            r2 = -1
            java.lang.String r3 = "androidx.compose.foundation.gestures.scrollable.<anonymous> (Scrollable.kt:155)"
            r13 = r21
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r13, r2, r3)
            goto L_0x0027
        L_0x0025:
            r13 = r21
        L_0x0027:
            r1 = 0
            r2 = 0
            r3 = 773894976(0x2e20b340, float:3.6538994E-11)
            r11.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
            r3 = r20
            r4 = 0
            r5 = r4
            r6 = 0
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r7)
            r7 = 0
            r8 = r20
            r9 = 0
            java.lang.Object r10 = r8.rememberedValue()
            r14 = 0
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r10 != r15) goto L_0x0071
            r15 = 0
            r16 = 0
            kotlin.coroutines.EmptyCoroutineContext r16 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r4 = r16
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
            kotlinx.coroutines.CoroutineScope r4 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r4, r3)
            r16 = r1
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r4)
            r8.updateRememberedValue(r1)
            goto L_0x0074
        L_0x0071:
            r16 = r1
            r1 = r10
        L_0x0074:
            r20.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r1
            kotlinx.coroutines.CoroutineScope r4 = r1.getCoroutineScope()
            r20.endReplaceableGroup()
            r14 = r4
            androidx.compose.foundation.gestures.Orientation r1 = r0.$orientation
            androidx.compose.foundation.gestures.ScrollableState r2 = r0.$state
            boolean r3 = r0.$reverseDirection
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            java.lang.Object[] r1 = new java.lang.Object[]{r14, r1, r2, r3}
            androidx.compose.foundation.gestures.Orientation r2 = r0.$orientation
            androidx.compose.foundation.gestures.ScrollableState r3 = r0.$state
            boolean r4 = r0.$reverseDirection
            r5 = 8
            r6 = 0
            r7 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r11.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r7)
            r7 = 0
            int r8 = r1.length
            r9 = r7
            r7 = 0
        L_0x00a9:
            if (r7 >= r8) goto L_0x00b5
            r10 = r1[r7]
            boolean r15 = r11.changed((java.lang.Object) r10)
            r9 = r9 | r15
            int r7 = r7 + 1
            goto L_0x00a9
        L_0x00b5:
            r7 = r20
            r8 = 0
            java.lang.Object r10 = r7.rememberedValue()
            r15 = 0
            if (r9 != 0) goto L_0x00cc
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r17 = r1
            java.lang.Object r1 = r16.getEmpty()
            if (r10 != r1) goto L_0x00ca
            goto L_0x00ce
        L_0x00ca:
            r1 = r10
            goto L_0x00db
        L_0x00cc:
            r17 = r1
        L_0x00ce:
            r1 = 0
            r16 = r1
            androidx.compose.foundation.gestures.ContentInViewModifier r1 = new androidx.compose.foundation.gestures.ContentInViewModifier
            r1.<init>(r14, r2, r3, r4)
            r7.updateRememberedValue(r1)
        L_0x00db:
            r20.endReplaceableGroup()
            androidx.compose.foundation.gestures.ContentInViewModifier r1 = (androidx.compose.foundation.gestures.ContentInViewModifier) r1
            r15 = r1
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.FocusableKt.focusGroup(r1)
            androidx.compose.ui.Modifier r2 = r15.getModifier()
            androidx.compose.ui.Modifier r1 = r1.then(r2)
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r0.$interactionSource
            androidx.compose.foundation.gestures.Orientation r3 = r0.$orientation
            boolean r4 = r0.$reverseDirection
            androidx.compose.foundation.gestures.ScrollableState r5 = r0.$state
            androidx.compose.foundation.gestures.FlingBehavior r6 = r0.$flingBehavior
            androidx.compose.foundation.OverscrollEffect r7 = r0.$overscrollEffect
            boolean r8 = r0.$enabled
            r10 = 0
            r9 = r20
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.gestures.ScrollableKt.pointerScrollable(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            boolean r2 = r0.$enabled
            if (r2 == 0) goto L_0x010f
            androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider r2 = androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider.INSTANCE
            goto L_0x0111
        L_0x010f:
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
        L_0x0111:
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Modifier r1 = r1.then(r2)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0120
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0120:
            r20.endReplaceableGroup()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt$scrollable$2.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
