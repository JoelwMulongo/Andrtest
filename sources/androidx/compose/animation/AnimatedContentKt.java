package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f21\u0010\r\u001a-\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0012¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0013\u001a\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u001521\u0010\r\u001a-\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0012¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0016\u001aU\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2>\b\u0002\u0010\u001b\u001a8\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001f0\u000eH\u0007ø\u0001\u0000\u001a¬\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020 2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2%\b\u0002\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\"0\u000721\u0010\r\u001a-\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0012¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010#\u001a\u0015\u0010$\u001a\u00020\t*\u00020%2\u0006\u0010&\u001a\u00020'H\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"AnimatedContent", "", "S", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/animation/ContentTransform;", "Lkotlin/ExtensionFunctionType;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "content", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "label", "", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "SizeTransform", "Landroidx/compose/animation/SizeTransform;", "clip", "", "sizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "initialSize", "targetSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/animation/core/Transition;", "contentKey", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "with", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
public final class AnimatedContentKt {
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S> void AnimatedContent(S r19, androidx.compose.ui.Modifier r20, kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentScope<S>, androidx.compose.animation.ContentTransform> r21, androidx.compose.ui.Alignment r22, java.lang.String r23, kotlin.jvm.functions.Function4<? super androidx.compose.animation.AnimatedVisibilityScope, ? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r9 = r19
            r10 = r24
            r11 = r26
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -802295584(0xffffffffd02df0e0, float:-1.16729774E10)
            r1 = r25
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AnimatedContent)P(4,3,5,1,2)132@6756L58,133@6830L116:AnimatedContent.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r26
            r2 = r27 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            goto L_0x0030
        L_0x0022:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0030
            boolean r2 = r12.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x002e
            r2 = 4
            goto L_0x002f
        L_0x002e:
            r2 = 2
        L_0x002f:
            r1 = r1 | r2
        L_0x0030:
            r2 = r27 & 2
            if (r2 == 0) goto L_0x0039
            r1 = r1 | 48
            r3 = r20
            goto L_0x004e
        L_0x0039:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004c
            r3 = r20
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0048
            r4 = 32
            goto L_0x004a
        L_0x0048:
            r4 = 16
        L_0x004a:
            r1 = r1 | r4
            goto L_0x004e
        L_0x004c:
            r3 = r20
        L_0x004e:
            r4 = r27 & 4
            if (r4 == 0) goto L_0x0057
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r21
            goto L_0x006c
        L_0x0057:
            r5 = r11 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x006a
            r5 = r21
            boolean r6 = r12.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0066
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r1 = r1 | r6
            goto L_0x006c
        L_0x006a:
            r5 = r21
        L_0x006c:
            r6 = r27 & 8
            if (r6 == 0) goto L_0x0075
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r22
            goto L_0x008a
        L_0x0075:
            r7 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0088
            r7 = r22
            boolean r8 = r12.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0084
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0086
        L_0x0084:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0086:
            r1 = r1 | r8
            goto L_0x008a
        L_0x0088:
            r7 = r22
        L_0x008a:
            r8 = r27 & 16
            if (r8 == 0) goto L_0x0093
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r13 = r23
            goto L_0x00aa
        L_0x0093:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r11
            if (r13 != 0) goto L_0x00a8
            r13 = r23
            boolean r14 = r12.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00a4
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a6
        L_0x00a4:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x00a6:
            r1 = r1 | r14
            goto L_0x00aa
        L_0x00a8:
            r13 = r23
        L_0x00aa:
            r14 = r27 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x00b4
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x00b2:
            r1 = r1 | r14
            goto L_0x00c4
        L_0x00b4:
            r14 = r11 & r15
            if (r14 != 0) goto L_0x00c4
            boolean r14 = r12.changed((java.lang.Object) r10)
            if (r14 == 0) goto L_0x00c1
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00c1:
            r14 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b2
        L_0x00c4:
            r14 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r14
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r15) goto L_0x00df
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x00d5
            goto L_0x00df
        L_0x00d5:
            r12.skipToGroupEnd()
            r15 = r3
            r16 = r5
            r17 = r7
            goto L_0x0149
        L_0x00df:
            if (r2 == 0) goto L_0x00e7
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r15 = r1
            goto L_0x00e8
        L_0x00e7:
            r15 = r3
        L_0x00e8:
            if (r4 == 0) goto L_0x00f1
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$1 r1 = androidx.compose.animation.AnimatedContentKt$AnimatedContent$1.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r16 = r1
            goto L_0x00f3
        L_0x00f1:
            r16 = r5
        L_0x00f3:
            if (r6 == 0) goto L_0x00fe
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getTopStart()
            r17 = r1
            goto L_0x0100
        L_0x00fe:
            r17 = r7
        L_0x0100:
            if (r8 == 0) goto L_0x0105
            java.lang.String r1 = "AnimatedContent"
            r13 = r1
        L_0x0105:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0111
            r1 = -1
            java.lang.String r2 = "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:120)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r1, r2)
        L_0x0111:
            r0 = r14 & 8
            r1 = r14 & 14
            r0 = r0 | r1
            int r1 = r14 >> 9
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = 0
            androidx.compose.animation.core.Transition r18 = androidx.compose.animation.core.TransitionKt.updateTransition(r9, (java.lang.String) r13, (androidx.compose.runtime.Composer) r12, (int) r0, (int) r1)
            r4 = 0
            r0 = r14 & 112(0x70, float:1.57E-43)
            r1 = r14 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r14 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r14
            r7 = r0 | r1
            r8 = 8
            r0 = r18
            r1 = r15
            r2 = r16
            r3 = r17
            r5 = r24
            r6 = r12
            AnimatedContent(r0, (androidx.compose.ui.Modifier) r1, r2, (androidx.compose.ui.Alignment) r3, r4, r5, (androidx.compose.runtime.Composer) r6, (int) r7, (int) r8)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0149
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0149:
            androidx.compose.runtime.ScopeUpdateScope r8 = r12.endRestartGroup()
            if (r8 != 0) goto L_0x0150
            goto L_0x016d
        L_0x0150:
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$2 r18 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$2
            r0 = r18
            r1 = r19
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r13
            r6 = r24
            r7 = r26
            r9 = r8
            r8 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x016d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(java.lang.Object, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, java.lang.String, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "AnimatedContent API now has a new label parameter added.")
    public static final /* synthetic */ void AnimatedContent(Object targetState, Modifier modifier, Function1 transitionSpec, Alignment contentAlignment, Function4 content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Function1 function1;
        Alignment alignment;
        Alignment contentAlignment2;
        Function1 transitionSpec2;
        Modifier modifier3;
        Function4 function4 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function4, "content");
        Composer $composer2 = $composer.startRestartGroup(2124549995);
        ComposerKt.sourceInformation($composer2, "C(AnimatedContent)P(3,2,4,1)159@7603L154:AnimatedContent.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            Object obj = targetState;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed(targetState) ? 4 : 2;
        } else {
            Object obj2 = targetState;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            function1 = transitionSpec;
        } else if ((i2 & 896) == 0) {
            function1 = transitionSpec;
            $dirty |= $composer2.changed((Object) function1) ? 256 : 128;
        } else {
            function1 = transitionSpec;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            alignment = contentAlignment;
        } else if ((i2 & 7168) == 0) {
            alignment = contentAlignment;
            $dirty |= $composer2.changed((Object) alignment) ? 2048 : 1024;
        } else {
            alignment = contentAlignment;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if ((57344 & i2) == 0) {
            $dirty |= $composer2.changed((Object) function4) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if ((46811 & $dirty2) != 9362 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                transitionSpec2 = AnimatedContentKt$AnimatedContent$3.INSTANCE;
            } else {
                transitionSpec2 = function1;
            }
            if (i5 != 0) {
                contentAlignment2 = Alignment.Companion.getTopStart();
            } else {
                contentAlignment2 = alignment;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2124549995, $dirty2, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:148)");
            }
            AnimatedContent(targetState, modifier3, transitionSpec2, contentAlignment2, "AnimatedContent", content, $composer2, ($dirty2 & 8) | 24576 | ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (($dirty2 << 3) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            transitionSpec2 = function1;
            contentAlignment2 = alignment;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AnimatedContentKt$AnimatedContent$4(targetState, modifier3, transitionSpec2, contentAlignment2, content, $changed, i));
        }
    }

    public static /* synthetic */ SizeTransform SizeTransform$default(boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function2 = AnimatedContentKt$SizeTransform$1.INSTANCE;
        }
        return SizeTransform(z, function2);
    }

    public static final SizeTransform SizeTransform(boolean clip, Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> sizeAnimationSpec) {
        Intrinsics.checkNotNullParameter(sizeAnimationSpec, "sizeAnimationSpec");
        return new SizeTransformImpl(clip, sizeAnimationSpec);
    }

    public static final ContentTransform with(EnterTransition $this$with, ExitTransition exit) {
        Intrinsics.checkNotNullParameter($this$with, "<this>");
        Intrinsics.checkNotNullParameter(exit, "exit");
        return new ContentTransform($this$with, exit, 0.0f, (SizeTransform) null, 12, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02be  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02e2  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x039f  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x03e5  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x03f3  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0471  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x047d  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0481  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x04fe  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0557  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0561  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x02b3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S> void AnimatedContent(androidx.compose.animation.core.Transition<S> r29, androidx.compose.ui.Modifier r30, kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentScope<S>, androidx.compose.animation.ContentTransform> r31, androidx.compose.ui.Alignment r32, kotlin.jvm.functions.Function1<? super S, ? extends java.lang.Object> r33, kotlin.jvm.functions.Function4<? super androidx.compose.animation.AnimatedVisibilityScope, ? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r9 = r29
            r10 = r34
            r11 = r36
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -114689412(0xfffffffff929fa7c, float:-5.516116E34)
            r1 = r35
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AnimatedContent)P(3,4,1,2)616@28718L7,617@28746L92,622@28927L51,623@29000L62,706@33066L58,707@33158L45,717@33473L52,708@33208L323:AnimatedContent.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r36
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r37 & r2
            if (r2 == 0) goto L_0x0029
            r1 = r1 | 6
            goto L_0x0037
        L_0x0029:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0037
            boolean r2 = r12.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x0035
            r2 = 4
            goto L_0x0036
        L_0x0035:
            r2 = 2
        L_0x0036:
            r1 = r1 | r2
        L_0x0037:
            r2 = r37 & 1
            if (r2 == 0) goto L_0x0040
            r1 = r1 | 48
            r3 = r30
            goto L_0x0055
        L_0x0040:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0053
            r3 = r30
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x004f
            r4 = 32
            goto L_0x0051
        L_0x004f:
            r4 = 16
        L_0x0051:
            r1 = r1 | r4
            goto L_0x0055
        L_0x0053:
            r3 = r30
        L_0x0055:
            r4 = r37 & 2
            if (r4 == 0) goto L_0x005e
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r31
            goto L_0x0073
        L_0x005e:
            r5 = r11 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0071
            r5 = r31
            boolean r6 = r12.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x006d
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x006f
        L_0x006d:
            r6 = 128(0x80, float:1.794E-43)
        L_0x006f:
            r1 = r1 | r6
            goto L_0x0073
        L_0x0071:
            r5 = r31
        L_0x0073:
            r6 = r37 & 4
            if (r6 == 0) goto L_0x007c
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r32
            goto L_0x0091
        L_0x007c:
            r7 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x008f
            r7 = r32
            boolean r8 = r12.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x008b
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x008d
        L_0x008b:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x008d:
            r1 = r1 | r8
            goto L_0x0091
        L_0x008f:
            r7 = r32
        L_0x0091:
            r8 = r37 & 8
            if (r8 == 0) goto L_0x009a
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r13 = r33
            goto L_0x00b1
        L_0x009a:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r11
            if (r13 != 0) goto L_0x00af
            r13 = r33
            boolean r14 = r12.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00ab
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ad
        L_0x00ab:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x00ad:
            r1 = r1 | r14
            goto L_0x00b1
        L_0x00af:
            r13 = r33
        L_0x00b1:
            r14 = r37 & 16
            if (r14 == 0) goto L_0x00b9
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x00b7:
            r1 = r1 | r14
            goto L_0x00ca
        L_0x00b9:
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r11
            if (r14 != 0) goto L_0x00ca
            boolean r14 = r12.changed((java.lang.Object) r10)
            if (r14 == 0) goto L_0x00c7
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00c7:
            r14 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b7
        L_0x00ca:
            r14 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r14
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r15) goto L_0x00e5
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x00db
            goto L_0x00e5
        L_0x00db:
            r12.skipToGroupEnd()
            r15 = r3
            r24 = r5
            r26 = r7
            goto L_0x055a
        L_0x00e5:
            if (r2 == 0) goto L_0x00ed
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r15 = r1
            goto L_0x00ee
        L_0x00ed:
            r15 = r3
        L_0x00ee:
            if (r4 == 0) goto L_0x00f5
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$5 r1 = androidx.compose.animation.AnimatedContentKt$AnimatedContent$5.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r5 = r1
        L_0x00f5:
            if (r6 == 0) goto L_0x00fe
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getTopStart()
            r7 = r1
        L_0x00fe:
            if (r8 == 0) goto L_0x0105
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$6 r1 = androidx.compose.animation.AnimatedContentKt$AnimatedContent$6.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r13 = r1
        L_0x0105:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r2 = -1
            if (r1 == 0) goto L_0x0111
            java.lang.String r1 = "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:605)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r2, r1)
        L_0x0111:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r3 = 0
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r8, r6)
            java.lang.Object r4 = r12.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            r0 = r14 & 14
            r1 = 0
            r3 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r3)
            java.lang.String r8 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r8)
            boolean r16 = r12.changed((java.lang.Object) r9)
            r31 = r12
            r17 = 0
            java.lang.Object r2 = r31.rememberedValue()
            r18 = 0
            if (r16 != 0) goto L_0x0158
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r19.getEmpty()
            if (r2 != r3) goto L_0x0152
            goto L_0x0158
        L_0x0152:
            r3 = r31
            r35 = r0
            r0 = r2
            goto L_0x0167
        L_0x0158:
            r3 = 0
            r35 = r0
            androidx.compose.animation.AnimatedContentScope r0 = new androidx.compose.animation.AnimatedContentScope
            r0.<init>(r9, r7, r4)
            r3 = r31
            r3.updateRememberedValue(r0)
        L_0x0167:
            r12.endReplaceableGroup()
            r3 = r0
            androidx.compose.animation.AnimatedContentScope r3 = (androidx.compose.animation.AnimatedContentScope) r3
            r0 = r14 & 14
            r1 = 0
            r2 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r8)
            boolean r2 = r12.changed((java.lang.Object) r9)
            r31 = r12
            r16 = 0
            r35 = r0
            java.lang.Object r0 = r31.rememberedValue()
            r17 = 0
            if (r2 != 0) goto L_0x019f
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r19 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r0 != r1) goto L_0x0199
            goto L_0x01a1
        L_0x0199:
            r1 = r0
            r18 = r1
            r0 = r31
            goto L_0x01b7
        L_0x019f:
            r19 = r1
        L_0x01a1:
            r1 = 0
            java.lang.Object r18 = r29.getCurrentState()
            java.lang.Object[] r18 = new java.lang.Object[]{r18}
            androidx.compose.runtime.snapshots.SnapshotStateList r1 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf(r18)
            r18 = r0
            r0 = r31
            r0.updateRememberedValue(r1)
        L_0x01b7:
            r12.endReplaceableGroup()
            r2 = r1
            androidx.compose.runtime.snapshots.SnapshotStateList r2 = (androidx.compose.runtime.snapshots.SnapshotStateList) r2
            r0 = r14 & 14
            r1 = 0
            r31 = r0
            r0 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r8)
            boolean r0 = r12.changed((java.lang.Object) r9)
            r8 = r12
            r16 = 0
            r33 = r1
            java.lang.Object r1 = r8.rememberedValue()
            r17 = 0
            if (r0 != 0) goto L_0x01ec
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r35 = r0
            java.lang.Object r0 = r18.getEmpty()
            if (r1 != r0) goto L_0x01ea
            goto L_0x01ee
        L_0x01ea:
            r0 = r1
            goto L_0x01fc
        L_0x01ec:
            r35 = r0
        L_0x01ee:
            r0 = 0
            java.util.LinkedHashMap r18 = new java.util.LinkedHashMap
            r18.<init>()
            java.util.Map r18 = (java.util.Map) r18
            r0 = r18
            r8.updateRememberedValue(r0)
        L_0x01fc:
            r12.endReplaceableGroup()
            r8 = r0
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r0 = r29.getCurrentState()
            boolean r0 = r2.contains(r0)
            if (r0 != 0) goto L_0x0218
            r2.clear()
            java.lang.Object r0 = r29.getCurrentState()
            r2.add(r0)
        L_0x0218:
            java.lang.Object r0 = r29.getCurrentState()
            java.lang.Object r1 = r29.getTargetState()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            r1 = 1
            if (r0 == 0) goto L_0x0260
            int r0 = r2.size()
            if (r0 != r1) goto L_0x023c
            r0 = 0
            java.lang.Object r1 = r2.get(r0)
            java.lang.Object r0 = r29.getCurrentState()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x0246
        L_0x023c:
            r2.clear()
            java.lang.Object r0 = r29.getCurrentState()
            r2.add(r0)
        L_0x0246:
            int r0 = r8.size()
            r1 = 1
            if (r0 != r1) goto L_0x0257
            java.lang.Object r0 = r29.getCurrentState()
            boolean r0 = r8.containsKey(r0)
            if (r0 == 0) goto L_0x025a
        L_0x0257:
            r8.clear()
        L_0x025a:
            r3.setContentAlignment$animation_release(r7)
            r3.setLayoutDirection$animation_release(r4)
        L_0x0260:
            java.lang.Object r0 = r29.getCurrentState()
            java.lang.Object r1 = r29.getTargetState()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 != 0) goto L_0x02cd
            java.lang.Object r0 = r29.getTargetState()
            boolean r0 = r2.contains(r0)
            if (r0 != 0) goto L_0x02cd
            r0 = r2
            java.util.List r0 = (java.util.List) r0
            r1 = 0
            r17 = 0
            java.util.Iterator r18 = r0.iterator()
        L_0x0282:
            boolean r19 = r18.hasNext()
            if (r19 == 0) goto L_0x02b3
            java.lang.Object r19 = r18.next()
            r33 = r19
            r20 = 0
            r35 = r0
            r0 = r33
            r33 = r1
            java.lang.Object r1 = r13.invoke(r0)
            r21 = r0
            java.lang.Object r0 = r29.getTargetState()
            java.lang.Object r0 = r13.invoke(r0)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x02ab
            goto L_0x02b9
        L_0x02ab:
            int r17 = r17 + 1
            r1 = r33
            r0 = r35
            goto L_0x0282
        L_0x02b3:
            r35 = r0
            r33 = r1
            r17 = -1
        L_0x02b9:
            r0 = r17
            r1 = -1
            if (r0 != r1) goto L_0x02c6
            java.lang.Object r1 = r29.getTargetState()
            r2.add(r1)
            goto L_0x02cd
        L_0x02c6:
            java.lang.Object r1 = r29.getTargetState()
            r2.set(r0, r1)
        L_0x02cd:
            java.lang.Object r0 = r29.getTargetState()
            boolean r0 = r8.containsKey(r0)
            if (r0 == 0) goto L_0x02f2
            java.lang.Object r0 = r29.getCurrentState()
            boolean r0 = r8.containsKey(r0)
            if (r0 != 0) goto L_0x02e2
            goto L_0x02f2
        L_0x02e2:
            r22 = r2
            r31 = r3
            r23 = r4
            r24 = r5
            r25 = r6
            r26 = r7
            r21 = 0
            goto L_0x0369
        L_0x02f2:
            r8.clear()
            r1 = r2
            java.util.List r1 = (java.util.List) r1
            r17 = 0
            r0 = 0
            int r9 = r1.size()
        L_0x0300:
            if (r0 >= r9) goto L_0x0356
            java.lang.Object r18 = r1.get(r0)
            r32 = r18
            r19 = 0
            r33 = r9
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$7$1 r9 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$7$1
            r16 = r0
            r20 = 0
            r0 = r9
            r21 = r20
            r10 = 1
            r20 = r1
            r1 = r29
            r22 = r2
            r2 = r32
            r31 = r3
            r3 = r14
            r23 = r4
            r4 = r5
            r24 = r5
            r5 = r31
            r25 = r6
            r6 = r34
            r26 = r7
            r7 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = 885640742(0x34c9ce26, float:3.758916E-7)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r0, r10, r9)
            r1 = r32
            r8.put(r1, r0)
            int r0 = r16 + 1
            r3 = r31
            r9 = r33
            r10 = r34
            r1 = r20
            r2 = r22
            r4 = r23
            r5 = r24
            r6 = r25
            r7 = r26
            goto L_0x0300
        L_0x0356:
            r16 = r0
            r20 = r1
            r22 = r2
            r31 = r3
            r23 = r4
            r24 = r5
            r25 = r6
            r26 = r7
            r21 = 0
        L_0x0369:
            androidx.compose.animation.core.Transition$Segment r0 = r29.getSegment()
            r1 = 72
            r2 = 0
            r3 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r12.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            r3 = r31
            boolean r4 = r12.changed((java.lang.Object) r3)
            boolean r5 = r12.changed((java.lang.Object) r0)
            r4 = r4 | r5
            r5 = r12
            r6 = 0
            java.lang.Object r7 = r5.rememberedValue()
            r9 = 0
            if (r4 != 0) goto L_0x039f
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r7 != r10) goto L_0x0399
            goto L_0x039f
        L_0x0399:
            r31 = r0
            r10 = r7
            r0 = r24
            goto L_0x03b0
        L_0x039f:
            r10 = 0
            r31 = r0
            r0 = r24
            java.lang.Object r16 = r0.invoke(r3)
            androidx.compose.animation.ContentTransform r16 = (androidx.compose.animation.ContentTransform) r16
            r10 = r16
            r5.updateRememberedValue(r10)
        L_0x03b0:
            r12.endReplaceableGroup()
            r1 = r10
            androidx.compose.animation.ContentTransform r1 = (androidx.compose.animation.ContentTransform) r1
            r2 = 72
            androidx.compose.ui.Modifier r2 = r3.createSizeAnimationModifier$animation_release(r1, r12, r2)
            androidx.compose.ui.Modifier r4 = r15.then(r2)
            r5 = r21
            r6 = 0
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r7)
            java.lang.String r7 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r7)
            r7 = 0
            r9 = r12
            r10 = 0
            r24 = r0
            java.lang.Object r0 = r9.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r31 = r1
            java.lang.Object r1 = r17.getEmpty()
            if (r0 != r1) goto L_0x03f3
            r1 = 0
            r32 = r0
            androidx.compose.animation.AnimatedContentMeasurePolicy r0 = new androidx.compose.animation.AnimatedContentMeasurePolicy
            r0.<init>(r3)
            r9.updateRememberedValue(r0)
            goto L_0x03f5
        L_0x03f3:
            r32 = r0
        L_0x03f5:
            r12.endReplaceableGroup()
            androidx.compose.animation.AnimatedContentMeasurePolicy r0 = (androidx.compose.animation.AnimatedContentMeasurePolicy) r0
            r1 = 384(0x180, float:5.38E-43)
            r5 = 0
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r12.startReplaceableGroup(r6)
            java.lang.String r6 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r7 = 6
            r9 = 0
            r32 = r2
            r10 = r25
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r2, r10)
            java.lang.Object r2 = r12.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r7 = 6
            r9 = 0
            r16 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r3, r10)
            java.lang.Object r3 = r12.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r7 = 6
            r9 = 0
            r33 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r5, r10)
            java.lang.Object r5 = r12.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r4 = androidx.compose.ui.layout.LayoutKt.materializerOf(r4)
            int r7 = r1 << 9
            r7 = r7 & 7168(0x1c00, float:1.0045E-41)
            r7 = r7 | 6
            r9 = 0
            androidx.compose.runtime.Applier r10 = r12.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x0474
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0474:
            r12.startReusableNode()
            boolean r10 = r12.getInserting()
            if (r10 == 0) goto L_0x0481
            r12.createNode(r6)
            goto L_0x0484
        L_0x0481:
            r12.useNode()
        L_0x0484:
            r12.disableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m2787constructorimpl(r12)
            r17 = 0
            androidx.compose.ui.layout.MeasurePolicy r0 = (androidx.compose.ui.layout.MeasurePolicy) r0
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            r30 = r1
            kotlin.jvm.functions.Function2 r1 = r18.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r10, r0, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r10, r2, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r10, r3, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r10, r5, r0)
            r12.enableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r12)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r0)
            int r1 = r7 >> 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4.invoke(r0, r12, r1)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r12.startReplaceableGroup(r0)
            int r0 = r7 >> 9
            r0 = r0 & 14
            r1 = r12
            r10 = 0
            r35 = r0
            r0 = -740841114(0xffffffffd3d7a966, float:-1.85252001E12)
            r17 = r2
            java.lang.String r2 = "C:AnimatedContent.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r2)
            r0 = -441512234(0xffffffffe5af0ed6, float:-1.0333598E23)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = ""
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            r0 = r22
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r2 = 0
            java.util.Iterator r18 = r0.iterator()
        L_0x04f8:
            boolean r19 = r18.hasNext()
            if (r19 == 0) goto L_0x0538
            java.lang.Object r19 = r18.next()
            r20 = r19
            r25 = 0
            r27 = r0
            r0 = r20
            r20 = r2
            java.lang.Object r2 = r13.invoke(r0)
            r28 = r3
            r3 = -1739564366(0xffffffff98505ab2, float:-2.692916E-24)
            r1.startMovableGroup(r3, r2)
            java.lang.String r2 = "713@33397L8"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            java.lang.Object r2 = r8.get(r0)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            if (r2 != 0) goto L_0x0526
            goto L_0x052d
        L_0x0526:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r21)
            r2.invoke(r1, r3)
        L_0x052d:
            r1.endMovableGroup()
            r2 = r20
            r0 = r27
            r3 = r28
            goto L_0x04f8
        L_0x0538:
            r27 = r0
            r20 = r2
            r28 = r3
            r12.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r12.endReplaceableGroup()
            r12.endNode()
            r12.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x055a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x055a:
            androidx.compose.runtime.ScopeUpdateScope r9 = r12.endRestartGroup()
            if (r9 != 0) goto L_0x0561
            goto L_0x057a
        L_0x0561:
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$10 r10 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$10
            r0 = r10
            r1 = r29
            r2 = r15
            r3 = r24
            r4 = r26
            r5 = r13
            r6 = r34
            r7 = r36
            r8 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x057a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(androidx.compose.animation.core.Transition, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }
}
