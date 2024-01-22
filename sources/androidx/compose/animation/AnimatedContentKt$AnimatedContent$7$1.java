package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
final class AnimatedContentKt$AnimatedContent$7$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function4<AnimatedVisibilityScope, S, Composer, Integer, Unit> $content;
    final /* synthetic */ SnapshotStateList<S> $currentlyVisible;
    final /* synthetic */ AnimatedContentScope<S> $rootScope;
    final /* synthetic */ S $stateForContent;
    final /* synthetic */ Transition<S> $this_AnimatedContent;
    final /* synthetic */ Function1<AnimatedContentScope<S>, ContentTransform> $transitionSpec;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimatedContentKt$AnimatedContent$7$1(Transition<S> transition, S s, int i, Function1<? super AnimatedContentScope<S>, ContentTransform> function1, AnimatedContentScope<S> animatedContentScope, Function4<? super AnimatedVisibilityScope, ? super S, ? super Composer, ? super Integer, Unit> function4, SnapshotStateList<S> snapshotStateList) {
        super(2);
        this.$this_AnimatedContent = transition;
        this.$stateForContent = s;
        this.$$dirty = i;
        this.$transitionSpec = function1;
        this.$rootScope = animatedContentScope;
        this.$content = function4;
        this.$currentlyVisible = snapshotStateList;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r21, int r22) {
        /*
            r20 = this;
            r0 = r20
            r10 = r21
            r11 = r22
            java.lang.String r1 = "C664@30979L38,668@31193L323,675@31549L111,680@31843L1164:AnimatedContent.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r11 & 11
            r2 = 2
            if (r1 != r2) goto L_0x001c
            boolean r1 = r21.getSkipping()
            if (r1 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r21.skipToGroupEnd()
            goto L_0x0187
        L_0x001c:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x002b
            r1 = -1
            java.lang.String r2 = "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous> (AnimatedContent.kt:663)"
            r3 = 885640742(0x34c9ce26, float:3.758916E-7)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r11, r1, r2)
        L_0x002b:
            kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentScope<S>, androidx.compose.animation.ContentTransform> r1 = r0.$transitionSpec
            androidx.compose.animation.AnimatedContentScope<S> r2 = r0.$rootScope
            r3 = 0
            r4 = 0
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r6)
            java.lang.String r7 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r7)
            r5 = 0
            r8 = r21
            r9 = 0
            java.lang.Object r12 = r8.rememberedValue()
            r13 = 0
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r12 != r14) goto L_0x005a
            r14 = 0
            java.lang.Object r1 = r1.invoke(r2)
            androidx.compose.animation.ContentTransform r1 = (androidx.compose.animation.ContentTransform) r1
            r8.updateRememberedValue(r1)
            goto L_0x005b
        L_0x005a:
            r1 = r12
        L_0x005b:
            r21.endReplaceableGroup()
            r12 = r1
            androidx.compose.animation.ContentTransform r12 = (androidx.compose.animation.ContentTransform) r12
            androidx.compose.animation.core.Transition<S> r1 = r0.$this_AnimatedContent
            androidx.compose.animation.core.Transition$Segment r1 = r1.getSegment()
            java.lang.Object r1 = r1.getTargetState()
            S r2 = r0.$stateForContent
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            androidx.compose.animation.core.Transition<S> r2 = r0.$this_AnimatedContent
            S r3 = r0.$stateForContent
            kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentScope<S>, androidx.compose.animation.ContentTransform> r4 = r0.$transitionSpec
            androidx.compose.animation.AnimatedContentScope<S> r5 = r0.$rootScope
            r8 = 0
            r9 = 0
            r13 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r13)
            java.lang.String r13 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r13)
            boolean r13 = r10.changed((java.lang.Object) r1)
            r14 = r21
            r15 = 0
            java.lang.Object r6 = r14.rememberedValue()
            r17 = 0
            if (r13 != 0) goto L_0x00a8
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r19 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r6 != r1) goto L_0x00a6
            goto L_0x00aa
        L_0x00a6:
            r1 = r6
            goto L_0x00d0
        L_0x00a8:
            r19 = r1
        L_0x00aa:
            r1 = 0
            androidx.compose.animation.core.Transition$Segment r2 = r2.getSegment()
            java.lang.Object r2 = r2.getTargetState()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x00c0
            androidx.compose.animation.ExitTransition$Companion r2 = androidx.compose.animation.ExitTransition.Companion
            androidx.compose.animation.ExitTransition r2 = r2.getNone()
            goto L_0x00ca
        L_0x00c0:
            java.lang.Object r2 = r4.invoke(r5)
            androidx.compose.animation.ContentTransform r2 = (androidx.compose.animation.ContentTransform) r2
            androidx.compose.animation.ExitTransition r2 = r2.getInitialContentExit()
        L_0x00ca:
            r1 = r2
            r14.updateRememberedValue(r1)
        L_0x00d0:
            r21.endReplaceableGroup()
            r5 = r1
            androidx.compose.animation.ExitTransition r5 = (androidx.compose.animation.ExitTransition) r5
            S r1 = r0.$stateForContent
            androidx.compose.animation.core.Transition<S> r2 = r0.$this_AnimatedContent
            r3 = 0
            r4 = 0
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r7)
            r6 = 0
            r7 = r21
            r8 = 0
            java.lang.Object r9 = r7.rememberedValue()
            r13 = 0
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r9 != r14) goto L_0x010d
            r14 = 0
            androidx.compose.animation.AnimatedContentScope$ChildData r15 = new androidx.compose.animation.AnimatedContentScope$ChildData
            java.lang.Object r2 = r2.getTargetState()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            r15.<init>(r1)
            r1 = r15
            r7.updateRememberedValue(r1)
            goto L_0x010e
        L_0x010d:
            r1 = r9
        L_0x010e:
            r21.endReplaceableGroup()
            r13 = r1
            androidx.compose.animation.AnimatedContentScope$ChildData r13 = (androidx.compose.animation.AnimatedContentScope.ChildData) r13
            androidx.compose.animation.EnterTransition r4 = r12.getTargetContentEnter()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$7$1$1 r2 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$7$1$1
            r2.<init>(r12)
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.layout.LayoutModifierKt.layout(r1, r2)
            S r2 = r0.$stateForContent
            androidx.compose.animation.core.Transition<S> r3 = r0.$this_AnimatedContent
            r6 = r13
            r7 = 0
            java.lang.Object r3 = r3.getTargetState()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            r6.setTarget(r2)
            r2 = r13
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Modifier r3 = r1.then(r2)
            androidx.compose.animation.core.Transition<S> r1 = r0.$this_AnimatedContent
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$7$1$3 r2 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$7$1$3
            S r6 = r0.$stateForContent
            r2.<init>(r6)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$7$1$4 r6 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$7$1$4
            androidx.compose.animation.AnimatedContentScope<S> r15 = r0.$rootScope
            S r7 = r0.$stateForContent
            kotlin.jvm.functions.Function4<androidx.compose.animation.AnimatedVisibilityScope, S, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r8 = r0.$content
            int r9 = r0.$$dirty
            androidx.compose.runtime.snapshots.SnapshotStateList<S> r14 = r0.$currentlyVisible
            r19 = r14
            r14 = r6
            r16 = r7
            r17 = r8
            r18 = r9
            r14.<init>(r15, r16, r17, r18, r19)
            r7 = -1894897681(0xffffffff8f0e27ef, float:-7.0088315E-30)
            r8 = 1
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r7, r8, r6)
            kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
            int r7 = r0.$$dirty
            r7 = r7 & 14
            r8 = 196608(0x30000, float:2.75506E-40)
            r8 = r8 | r7
            r9 = 0
            r7 = r21
            androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(r1, r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.animation.EnterTransition) r4, (androidx.compose.animation.ExitTransition) r5, (kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r6, (androidx.compose.runtime.Composer) r7, (int) r8, (int) r9)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0187
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0187:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt$AnimatedContent$7$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
