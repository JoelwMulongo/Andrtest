package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000ª\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001aÚ\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00042%\b\u0002\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001c2\b\b\u0002\u0010!\u001a\u00020\"2&\u0010#\u001a\"\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b%H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'\u001aÖ\u0001\u0010(\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010+\u001a\u00020,2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042#\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001c2\u0006\u0010!\u001a\u00020\"2&\u0010#\u001a\"\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b%H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.\u001a&\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\r2\u0006\u00102\u001a\u0002032\f\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0002\u001aÚ\u0001\u00107\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00042%\b\u0002\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001c2\b\b\u0002\u0010!\u001a\u00020\"2&\u0010#\u001a\"\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b%H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00109\u001a(\u0010:\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020<H\u0002ø\u0001\u0001¢\u0006\u0002\u0010=\u001a\u0017\u0010>\u001a\u00020\b2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@H\b\u001a!\u0010B\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010C\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010D\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006E"}, d2 = {"ConsumeHorizontalFlingNestedScrollConnection", "Landroidx/compose/foundation/pager/ConsumeAllFlingOnDirection;", "ConsumeVerticalFlingNestedScrollConnection", "DEBUG", "", "LowVelocityAnimationDefaultDuration", "", "HorizontalPager", "", "pageCount", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "beyondBoundsPageCount", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "userScrollEnabled", "reverseLayout", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "pageContent", "page", "Landroidx/compose/runtime/Composable;", "HorizontalPager-AlbwjTQ", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Pager", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "Pager-wKDqQAw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;ILandroidx/compose/foundation/pager/PageSize;FLandroidx/compose/foundation/gestures/Orientation;ILandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "pagerState", "pagerSnapDistance", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "VerticalPager", "VerticalPager-AlbwjTQ", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "calculateContentPaddings", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/unit/LayoutDirection;)F", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "pagerSemantics", "isVertical", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Pager.kt */
public final class PagerKt {
    /* access modifiers changed from: private */
    public static final ConsumeAllFlingOnDirection ConsumeHorizontalFlingNestedScrollConnection = new ConsumeAllFlingOnDirection(Orientation.Horizontal);
    /* access modifiers changed from: private */
    public static final ConsumeAllFlingOnDirection ConsumeVerticalFlingNestedScrollConnection = new ConsumeAllFlingOnDirection(Orientation.Vertical);
    private static final boolean DEBUG = false;
    private static final int LowVelocityAnimationDefaultDuration = 500;

    /* renamed from: HorizontalPager-AlbwjTQ  reason: not valid java name */
    public static final void m1076HorizontalPagerAlbwjTQ(int pageCount, Modifier modifier, PagerState state, PaddingValues contentPadding, PageSize pageSize, int beyondBoundsPageCount, float pageSpacing, Alignment.Vertical verticalAlignment, SnapFlingBehavior flingBehavior, boolean userScrollEnabled, boolean reverseLayout, Function1<? super Integer, ? extends Object> key, NestedScrollConnection pageNestedScrollConnection, Function3<? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Composer $composer, int $changed, int $changed1, int i) {
        Modifier modifier2;
        int i2;
        float f;
        int i3;
        int i4;
        int i5;
        NestedScrollConnection pageNestedScrollConnection2;
        Function1 key2;
        boolean reverseLayout2;
        boolean userScrollEnabled2;
        SnapFlingBehavior flingBehavior2;
        Alignment.Vertical verticalAlignment2;
        float pageSpacing2;
        int beyondBoundsPageCount2;
        PageSize pageSize2;
        PaddingValues contentPadding2;
        Composer $composer2;
        PagerState state2;
        Modifier modifier3;
        int $dirty;
        int $dirty1;
        Modifier modifier4;
        int $dirty2;
        PagerState state3;
        PaddingValues contentPadding3;
        PageSize pageSize3;
        int beyondBoundsPageCount3;
        float pageSpacing3;
        Alignment.Vertical verticalAlignment3;
        int $dirty12;
        int i6;
        int i7;
        int i8;
        int i9;
        SnapFlingBehavior flingBehavior3;
        boolean userScrollEnabled3;
        boolean reverseLayout3;
        Function1 key3;
        int i10;
        int i11;
        Function3<? super Integer, ? super Composer, ? super Integer, Unit> function3 = pageContent;
        int i12 = $changed;
        int i13 = $changed1;
        int i14 = i;
        Intrinsics.checkNotNullParameter(function3, "pageContent");
        Composer $composer3 = $composer.startRestartGroup(-547020879);
        ComposerKt.sourceInformation($composer3, "C(HorizontalPager)P(6,4,11,1,8!1,9:c#ui.unit.Dp,13!1,12,10!1,7)124@6522L20,130@6830L28,139@7169L591:Pager.kt#g6yjnt");
        int $dirty3 = $changed;
        int $dirty13 = $changed1;
        if ((i14 & 1) != 0) {
            $dirty3 |= 6;
            int i15 = pageCount;
        } else if ((i12 & 14) == 0) {
            $dirty3 |= $composer3.changed(pageCount) ? 4 : 2;
        } else {
            int i16 = pageCount;
        }
        int i17 = i14 & 2;
        if (i17 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if ((i12 & 112) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i12 & 896) == 0) {
            if ((i14 & 4) != 0) {
                PagerState pagerState = state;
            } else if ($composer3.changed((Object) state)) {
                i11 = 256;
                $dirty3 |= i11;
            }
            i11 = 128;
            $dirty3 |= i11;
        } else {
            PagerState pagerState2 = state;
        }
        int i18 = i14 & 8;
        int i19 = 2048;
        if (i18 != 0) {
            $dirty3 |= 3072;
            PaddingValues paddingValues = contentPadding;
        } else if ((i12 & 7168) == 0) {
            $dirty3 |= $composer3.changed((Object) contentPadding) ? 2048 : 1024;
        } else {
            PaddingValues paddingValues2 = contentPadding;
        }
        int i20 = i14 & 16;
        if (i20 != 0) {
            $dirty3 |= 24576;
            PageSize pageSize4 = pageSize;
        } else if ((i12 & 57344) == 0) {
            $dirty3 |= $composer3.changed((Object) pageSize) ? 16384 : 8192;
        } else {
            PageSize pageSize5 = pageSize;
        }
        int i21 = i14 & 32;
        if (i21 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i2 = beyondBoundsPageCount;
        } else if ((i12 & 458752) == 0) {
            i2 = beyondBoundsPageCount;
            $dirty3 |= $composer3.changed(i2) ? 131072 : 65536;
        } else {
            i2 = beyondBoundsPageCount;
        }
        int i22 = i14 & 64;
        if (i22 != 0) {
            $dirty3 |= 1572864;
            f = pageSpacing;
        } else if ((i12 & 3670016) == 0) {
            f = pageSpacing;
            $dirty3 |= $composer3.changed(f) ? 1048576 : 524288;
        } else {
            f = pageSpacing;
        }
        int i23 = i14 & 128;
        if (i23 != 0) {
            $dirty3 |= 12582912;
            Alignment.Vertical vertical = verticalAlignment;
        } else if ((i12 & 29360128) == 0) {
            $dirty3 |= $composer3.changed((Object) verticalAlignment) ? 8388608 : 4194304;
        } else {
            Alignment.Vertical vertical2 = verticalAlignment;
        }
        if ((i12 & 234881024) == 0) {
            if ((i14 & 256) != 0) {
                SnapFlingBehavior snapFlingBehavior = flingBehavior;
            } else if ($composer3.changed((Object) flingBehavior)) {
                i10 = 67108864;
                $dirty3 |= i10;
            }
            i10 = 33554432;
            $dirty3 |= i10;
        } else {
            SnapFlingBehavior snapFlingBehavior2 = flingBehavior;
        }
        int i24 = i14 & 512;
        if (i24 != 0) {
            $dirty3 |= 805306368;
            i3 = i24;
            boolean z = userScrollEnabled;
        } else if ((i12 & 1879048192) == 0) {
            i3 = i24;
            $dirty3 |= $composer3.changed(userScrollEnabled) ? 536870912 : 268435456;
        } else {
            i3 = i24;
            boolean z2 = userScrollEnabled;
        }
        int i25 = i14 & 1024;
        if (i25 != 0) {
            $dirty13 |= 6;
            i4 = i25;
            boolean z3 = reverseLayout;
        } else if ((i13 & 14) == 0) {
            i4 = i25;
            $dirty13 |= $composer3.changed(reverseLayout) ? 4 : 2;
        } else {
            i4 = i25;
            boolean z4 = reverseLayout;
        }
        int i26 = i14 & 2048;
        if (i26 != 0) {
            $dirty13 |= 48;
            i5 = i26;
            Function1<? super Integer, ? extends Object> function1 = key;
        } else if ((i13 & 112) == 0) {
            i5 = i26;
            $dirty13 |= $composer3.changedInstance(key) ? 32 : 16;
        } else {
            i5 = i26;
            Function1<? super Integer, ? extends Object> function12 = key;
        }
        int i27 = i14 & 4096;
        if (i27 != 0) {
            $dirty13 |= 128;
        }
        if ((i14 & 8192) != 0) {
            $dirty13 |= 3072;
        } else if ((i13 & 7168) == 0) {
            if (!$composer3.changedInstance(function3)) {
                i19 = 1024;
            }
            $dirty13 |= i19;
        }
        int $dirty14 = $dirty13;
        if (i27 == 4096 && (1533916891 & $dirty3) == 306783378 && ($dirty14 & 5851) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            state2 = state;
            contentPadding2 = contentPadding;
            pageSize2 = pageSize;
            verticalAlignment2 = verticalAlignment;
            flingBehavior2 = flingBehavior;
            userScrollEnabled2 = userScrollEnabled;
            reverseLayout2 = reverseLayout;
            key2 = key;
            pageNestedScrollConnection2 = pageNestedScrollConnection;
            int i28 = $dirty3;
            int i29 = $dirty14;
            beyondBoundsPageCount2 = i2;
            pageSpacing2 = f;
            modifier3 = modifier2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if ((i12 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i17 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i14 & 4) != 0) {
                    $dirty2 = $dirty3 & -897;
                    state3 = PagerStateKt.rememberPagerState(0, 0.0f, $composer3, 0, 3);
                } else {
                    state3 = state;
                    $dirty2 = $dirty3;
                }
                if (i18 != 0) {
                    contentPadding3 = PaddingKt.m753PaddingValues0680j_4(Dp.m5986constructorimpl((float) 0));
                } else {
                    contentPadding3 = contentPadding;
                }
                if (i20 != 0) {
                    pageSize3 = PageSize.Fill.INSTANCE;
                } else {
                    pageSize3 = pageSize;
                }
                if (i21 != 0) {
                    beyondBoundsPageCount3 = 0;
                } else {
                    beyondBoundsPageCount3 = i2;
                }
                if (i22 != 0) {
                    pageSpacing3 = Dp.m5986constructorimpl((float) 0);
                } else {
                    pageSpacing3 = f;
                }
                if (i23 != 0) {
                    verticalAlignment3 = Alignment.Companion.getCenterVertically();
                } else {
                    verticalAlignment3 = verticalAlignment;
                }
                if ((i14 & 256) != 0) {
                    $dirty12 = $dirty14;
                    i6 = i27;
                    int i30 = i4;
                    i7 = i5;
                    i9 = i3;
                    i8 = i30;
                    flingBehavior3 = PagerDefaults.INSTANCE.flingBehavior(state3, (PagerSnapDistance) null, (AnimationSpec<Float>) null, (DecayAnimationSpec<Float>) null, (AnimationSpec<Float>) null, $composer3, (($dirty2 >> 6) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                    $dirty2 &= -234881025;
                } else {
                    $dirty12 = $dirty14;
                    i6 = i27;
                    int i31 = i4;
                    i7 = i5;
                    i9 = i3;
                    i8 = i31;
                    flingBehavior3 = flingBehavior;
                }
                if (i9 != 0) {
                    userScrollEnabled3 = true;
                } else {
                    userScrollEnabled3 = userScrollEnabled;
                }
                if (i8 != 0) {
                    reverseLayout3 = false;
                } else {
                    reverseLayout3 = reverseLayout;
                }
                if (i7 != 0) {
                    key3 = null;
                } else {
                    key3 = key;
                }
                if (i6 != 0) {
                    verticalAlignment2 = verticalAlignment3;
                    flingBehavior2 = flingBehavior3;
                    userScrollEnabled2 = userScrollEnabled3;
                    reverseLayout2 = reverseLayout3;
                    key2 = key3;
                    pageNestedScrollConnection2 = PagerDefaults.INSTANCE.pageNestedScrollConnection(Orientation.Horizontal);
                    $dirty1 = $dirty12 & -897;
                    modifier3 = modifier4;
                    beyondBoundsPageCount2 = beyondBoundsPageCount3;
                    $dirty = $dirty2;
                    pageSpacing2 = pageSpacing3;
                    contentPadding2 = contentPadding3;
                    state2 = state3;
                    pageSize2 = pageSize3;
                } else {
                    int $dirty15 = $dirty12;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    verticalAlignment2 = verticalAlignment3;
                    flingBehavior2 = flingBehavior3;
                    userScrollEnabled2 = userScrollEnabled3;
                    reverseLayout2 = reverseLayout3;
                    key2 = key3;
                    $dirty1 = $dirty15;
                    modifier3 = modifier4;
                    beyondBoundsPageCount2 = beyondBoundsPageCount3;
                    $dirty = $dirty2;
                    pageSpacing2 = pageSpacing3;
                    contentPadding2 = contentPadding3;
                    state2 = state3;
                    pageSize2 = pageSize3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i14 & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i14 & 256) != 0) {
                    $dirty3 &= -234881025;
                }
                if (i27 != 0) {
                    state2 = state;
                    contentPadding2 = contentPadding;
                    pageSize2 = pageSize;
                    verticalAlignment2 = verticalAlignment;
                    flingBehavior2 = flingBehavior;
                    userScrollEnabled2 = userScrollEnabled;
                    reverseLayout2 = reverseLayout;
                    key2 = key;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    $dirty = $dirty3;
                    beyondBoundsPageCount2 = i2;
                    pageSpacing2 = f;
                    modifier3 = modifier2;
                    $dirty1 = $dirty14 & -897;
                } else {
                    state2 = state;
                    contentPadding2 = contentPadding;
                    pageSize2 = pageSize;
                    verticalAlignment2 = verticalAlignment;
                    flingBehavior2 = flingBehavior;
                    userScrollEnabled2 = userScrollEnabled;
                    reverseLayout2 = reverseLayout;
                    key2 = key;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    $dirty = $dirty3;
                    beyondBoundsPageCount2 = i2;
                    pageSpacing2 = f;
                    modifier3 = modifier2;
                    $dirty1 = $dirty14;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-547020879, $dirty, $dirty1, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:121)");
            }
            int i32 = $dirty1;
            int i33 = $dirty;
            $composer2 = $composer3;
            m1077PagerwKDqQAw(modifier3, state2, pageCount, pageSize2, pageSpacing2, Orientation.Horizontal, beyondBoundsPageCount2, verticalAlignment2, (Alignment.Horizontal) null, contentPadding2, flingBehavior2, userScrollEnabled2, reverseLayout2, key2, pageNestedScrollConnection2, pageContent, $composer2, (($dirty >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (($dirty >> 3) & 112) | (($dirty << 6) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 6) & 57344) | (($dirty << 3) & 3670016) | (29360128 & $dirty) | (($dirty << 18) & 1879048192), (($dirty >> 24) & 14) | 32768 | (($dirty >> 24) & 112) | (($dirty1 << 6) & 896) | (($dirty1 << 6) & 7168) | (($dirty1 << 6) & 458752), 256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PagerKt$HorizontalPager$1(pageCount, modifier3, state2, contentPadding2, pageSize2, beyondBoundsPageCount2, pageSpacing2, verticalAlignment2, flingBehavior2, userScrollEnabled2, reverseLayout2, key2, pageNestedScrollConnection2, pageContent, $changed, $changed1, i));
        }
    }

    /* renamed from: VerticalPager-AlbwjTQ  reason: not valid java name */
    public static final void m1078VerticalPagerAlbwjTQ(int pageCount, Modifier modifier, PagerState state, PaddingValues contentPadding, PageSize pageSize, int beyondBoundsPageCount, float pageSpacing, Alignment.Horizontal horizontalAlignment, SnapFlingBehavior flingBehavior, boolean userScrollEnabled, boolean reverseLayout, Function1<? super Integer, ? extends Object> key, NestedScrollConnection pageNestedScrollConnection, Function3<? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Composer $composer, int $changed, int $changed1, int i) {
        Modifier modifier2;
        int i2;
        float f;
        int i3;
        int i4;
        int i5;
        NestedScrollConnection pageNestedScrollConnection2;
        Function1 key2;
        boolean reverseLayout2;
        boolean userScrollEnabled2;
        SnapFlingBehavior flingBehavior2;
        Alignment.Horizontal horizontalAlignment2;
        float pageSpacing2;
        int beyondBoundsPageCount2;
        PageSize pageSize2;
        PaddingValues contentPadding2;
        Composer $composer2;
        PagerState state2;
        Modifier modifier3;
        int $dirty;
        int $dirty1;
        Modifier modifier4;
        int $dirty2;
        PagerState state3;
        PaddingValues contentPadding3;
        PageSize pageSize3;
        int beyondBoundsPageCount3;
        float pageSpacing3;
        Alignment.Horizontal horizontalAlignment3;
        int $dirty12;
        int i6;
        int i7;
        int i8;
        int i9;
        SnapFlingBehavior flingBehavior3;
        boolean userScrollEnabled3;
        boolean reverseLayout3;
        Function1 key3;
        int i10;
        int i11;
        Function3<? super Integer, ? super Composer, ? super Integer, Unit> function3 = pageContent;
        int i12 = $changed;
        int i13 = $changed1;
        int i14 = i;
        Intrinsics.checkNotNullParameter(function3, "pageContent");
        Composer $composer3 = $composer.startRestartGroup(26030705);
        ComposerKt.sourceInformation($composer3, "C(VerticalPager)P(7,5,12,1,9!1,10:c#ui.unit.Dp,3!1,13,11!1,8)204@10765L20,210@11079L28,219@11416L593:Pager.kt#g6yjnt");
        int $dirty3 = $changed;
        int $dirty13 = $changed1;
        if ((i14 & 1) != 0) {
            $dirty3 |= 6;
            int i15 = pageCount;
        } else if ((i12 & 14) == 0) {
            $dirty3 |= $composer3.changed(pageCount) ? 4 : 2;
        } else {
            int i16 = pageCount;
        }
        int i17 = i14 & 2;
        if (i17 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if ((i12 & 112) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i12 & 896) == 0) {
            if ((i14 & 4) != 0) {
                PagerState pagerState = state;
            } else if ($composer3.changed((Object) state)) {
                i11 = 256;
                $dirty3 |= i11;
            }
            i11 = 128;
            $dirty3 |= i11;
        } else {
            PagerState pagerState2 = state;
        }
        int i18 = i14 & 8;
        int i19 = 2048;
        if (i18 != 0) {
            $dirty3 |= 3072;
            PaddingValues paddingValues = contentPadding;
        } else if ((i12 & 7168) == 0) {
            $dirty3 |= $composer3.changed((Object) contentPadding) ? 2048 : 1024;
        } else {
            PaddingValues paddingValues2 = contentPadding;
        }
        int i20 = i14 & 16;
        if (i20 != 0) {
            $dirty3 |= 24576;
            PageSize pageSize4 = pageSize;
        } else if ((i12 & 57344) == 0) {
            $dirty3 |= $composer3.changed((Object) pageSize) ? 16384 : 8192;
        } else {
            PageSize pageSize5 = pageSize;
        }
        int i21 = i14 & 32;
        if (i21 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i2 = beyondBoundsPageCount;
        } else if ((i12 & 458752) == 0) {
            i2 = beyondBoundsPageCount;
            $dirty3 |= $composer3.changed(i2) ? 131072 : 65536;
        } else {
            i2 = beyondBoundsPageCount;
        }
        int i22 = i14 & 64;
        if (i22 != 0) {
            $dirty3 |= 1572864;
            f = pageSpacing;
        } else if ((i12 & 3670016) == 0) {
            f = pageSpacing;
            $dirty3 |= $composer3.changed(f) ? 1048576 : 524288;
        } else {
            f = pageSpacing;
        }
        int i23 = i14 & 128;
        if (i23 != 0) {
            $dirty3 |= 12582912;
            Alignment.Horizontal horizontal = horizontalAlignment;
        } else if ((i12 & 29360128) == 0) {
            $dirty3 |= $composer3.changed((Object) horizontalAlignment) ? 8388608 : 4194304;
        } else {
            Alignment.Horizontal horizontal2 = horizontalAlignment;
        }
        if ((i12 & 234881024) == 0) {
            if ((i14 & 256) != 0) {
                SnapFlingBehavior snapFlingBehavior = flingBehavior;
            } else if ($composer3.changed((Object) flingBehavior)) {
                i10 = 67108864;
                $dirty3 |= i10;
            }
            i10 = 33554432;
            $dirty3 |= i10;
        } else {
            SnapFlingBehavior snapFlingBehavior2 = flingBehavior;
        }
        int i24 = i14 & 512;
        if (i24 != 0) {
            $dirty3 |= 805306368;
            i3 = i24;
            boolean z = userScrollEnabled;
        } else if ((i12 & 1879048192) == 0) {
            i3 = i24;
            $dirty3 |= $composer3.changed(userScrollEnabled) ? 536870912 : 268435456;
        } else {
            i3 = i24;
            boolean z2 = userScrollEnabled;
        }
        int i25 = i14 & 1024;
        if (i25 != 0) {
            $dirty13 |= 6;
            i4 = i25;
            boolean z3 = reverseLayout;
        } else if ((i13 & 14) == 0) {
            i4 = i25;
            $dirty13 |= $composer3.changed(reverseLayout) ? 4 : 2;
        } else {
            i4 = i25;
            boolean z4 = reverseLayout;
        }
        int i26 = i14 & 2048;
        if (i26 != 0) {
            $dirty13 |= 48;
            i5 = i26;
            Function1<? super Integer, ? extends Object> function1 = key;
        } else if ((i13 & 112) == 0) {
            i5 = i26;
            $dirty13 |= $composer3.changedInstance(key) ? 32 : 16;
        } else {
            i5 = i26;
            Function1<? super Integer, ? extends Object> function12 = key;
        }
        int i27 = i14 & 4096;
        if (i27 != 0) {
            $dirty13 |= 128;
        }
        if ((i14 & 8192) != 0) {
            $dirty13 |= 3072;
        } else if ((i13 & 7168) == 0) {
            if (!$composer3.changedInstance(function3)) {
                i19 = 1024;
            }
            $dirty13 |= i19;
        }
        int $dirty14 = $dirty13;
        if (i27 == 4096 && (1533916891 & $dirty3) == 306783378 && ($dirty14 & 5851) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            state2 = state;
            contentPadding2 = contentPadding;
            pageSize2 = pageSize;
            horizontalAlignment2 = horizontalAlignment;
            flingBehavior2 = flingBehavior;
            userScrollEnabled2 = userScrollEnabled;
            reverseLayout2 = reverseLayout;
            key2 = key;
            pageNestedScrollConnection2 = pageNestedScrollConnection;
            int i28 = $dirty3;
            int i29 = $dirty14;
            beyondBoundsPageCount2 = i2;
            pageSpacing2 = f;
            modifier3 = modifier2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if ((i12 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i17 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i14 & 4) != 0) {
                    $dirty2 = $dirty3 & -897;
                    state3 = PagerStateKt.rememberPagerState(0, 0.0f, $composer3, 0, 3);
                } else {
                    state3 = state;
                    $dirty2 = $dirty3;
                }
                if (i18 != 0) {
                    contentPadding3 = PaddingKt.m753PaddingValues0680j_4(Dp.m5986constructorimpl((float) 0));
                } else {
                    contentPadding3 = contentPadding;
                }
                if (i20 != 0) {
                    pageSize3 = PageSize.Fill.INSTANCE;
                } else {
                    pageSize3 = pageSize;
                }
                if (i21 != 0) {
                    beyondBoundsPageCount3 = 0;
                } else {
                    beyondBoundsPageCount3 = i2;
                }
                if (i22 != 0) {
                    pageSpacing3 = Dp.m5986constructorimpl((float) 0);
                } else {
                    pageSpacing3 = f;
                }
                if (i23 != 0) {
                    horizontalAlignment3 = Alignment.Companion.getCenterHorizontally();
                } else {
                    horizontalAlignment3 = horizontalAlignment;
                }
                if ((i14 & 256) != 0) {
                    $dirty12 = $dirty14;
                    i6 = i27;
                    int i30 = i4;
                    i7 = i5;
                    i9 = i3;
                    i8 = i30;
                    flingBehavior3 = PagerDefaults.INSTANCE.flingBehavior(state3, (PagerSnapDistance) null, (AnimationSpec<Float>) null, (DecayAnimationSpec<Float>) null, (AnimationSpec<Float>) null, $composer3, (($dirty2 >> 6) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                    $dirty2 &= -234881025;
                } else {
                    $dirty12 = $dirty14;
                    i6 = i27;
                    int i31 = i4;
                    i7 = i5;
                    i9 = i3;
                    i8 = i31;
                    flingBehavior3 = flingBehavior;
                }
                if (i9 != 0) {
                    userScrollEnabled3 = true;
                } else {
                    userScrollEnabled3 = userScrollEnabled;
                }
                if (i8 != 0) {
                    reverseLayout3 = false;
                } else {
                    reverseLayout3 = reverseLayout;
                }
                if (i7 != 0) {
                    key3 = null;
                } else {
                    key3 = key;
                }
                if (i6 != 0) {
                    horizontalAlignment2 = horizontalAlignment3;
                    flingBehavior2 = flingBehavior3;
                    userScrollEnabled2 = userScrollEnabled3;
                    reverseLayout2 = reverseLayout3;
                    key2 = key3;
                    pageNestedScrollConnection2 = PagerDefaults.INSTANCE.pageNestedScrollConnection(Orientation.Vertical);
                    $dirty1 = $dirty12 & -897;
                    modifier3 = modifier4;
                    beyondBoundsPageCount2 = beyondBoundsPageCount3;
                    $dirty = $dirty2;
                    pageSpacing2 = pageSpacing3;
                    contentPadding2 = contentPadding3;
                    state2 = state3;
                    pageSize2 = pageSize3;
                } else {
                    int $dirty15 = $dirty12;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    horizontalAlignment2 = horizontalAlignment3;
                    flingBehavior2 = flingBehavior3;
                    userScrollEnabled2 = userScrollEnabled3;
                    reverseLayout2 = reverseLayout3;
                    key2 = key3;
                    $dirty1 = $dirty15;
                    modifier3 = modifier4;
                    beyondBoundsPageCount2 = beyondBoundsPageCount3;
                    $dirty = $dirty2;
                    pageSpacing2 = pageSpacing3;
                    contentPadding2 = contentPadding3;
                    state2 = state3;
                    pageSize2 = pageSize3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i14 & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i14 & 256) != 0) {
                    $dirty3 &= -234881025;
                }
                if (i27 != 0) {
                    state2 = state;
                    contentPadding2 = contentPadding;
                    pageSize2 = pageSize;
                    horizontalAlignment2 = horizontalAlignment;
                    flingBehavior2 = flingBehavior;
                    userScrollEnabled2 = userScrollEnabled;
                    reverseLayout2 = reverseLayout;
                    key2 = key;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    $dirty = $dirty3;
                    beyondBoundsPageCount2 = i2;
                    pageSpacing2 = f;
                    modifier3 = modifier2;
                    $dirty1 = $dirty14 & -897;
                } else {
                    state2 = state;
                    contentPadding2 = contentPadding;
                    pageSize2 = pageSize;
                    horizontalAlignment2 = horizontalAlignment;
                    flingBehavior2 = flingBehavior;
                    userScrollEnabled2 = userScrollEnabled;
                    reverseLayout2 = reverseLayout;
                    key2 = key;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    $dirty = $dirty3;
                    beyondBoundsPageCount2 = i2;
                    pageSpacing2 = f;
                    modifier3 = modifier2;
                    $dirty1 = $dirty14;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(26030705, $dirty, $dirty1, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:201)");
            }
            int i32 = $dirty1;
            int i33 = $dirty;
            $composer2 = $composer3;
            m1077PagerwKDqQAw(modifier3, state2, pageCount, pageSize2, pageSpacing2, Orientation.Vertical, beyondBoundsPageCount2, (Alignment.Vertical) null, horizontalAlignment2, contentPadding2, flingBehavior2, userScrollEnabled2, reverseLayout2, key2, pageNestedScrollConnection2, pageContent, $composer2, (($dirty >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (($dirty >> 3) & 112) | (($dirty << 6) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 6) & 57344) | (($dirty << 3) & 3670016) | (($dirty << 3) & 234881024) | (($dirty << 18) & 1879048192), (($dirty >> 24) & 14) | 32768 | (($dirty >> 24) & 112) | (($dirty1 << 6) & 896) | (($dirty1 << 6) & 7168) | (($dirty1 << 6) & 458752), 128);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PagerKt$VerticalPager$1(pageCount, modifier3, state2, contentPadding2, pageSize2, beyondBoundsPageCount2, pageSpacing2, horizontalAlignment2, flingBehavior2, userScrollEnabled2, reverseLayout2, key2, pageNestedScrollConnection2, pageContent, $changed, $changed1, i));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x02d5  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x02de  */
    /* renamed from: Pager-wKDqQAw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1077PagerwKDqQAw(androidx.compose.ui.Modifier r44, androidx.compose.foundation.pager.PagerState r45, int r46, androidx.compose.foundation.pager.PageSize r47, float r48, androidx.compose.foundation.gestures.Orientation r49, int r50, androidx.compose.ui.Alignment.Vertical r51, androidx.compose.ui.Alignment.Horizontal r52, androidx.compose.foundation.layout.PaddingValues r53, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r54, boolean r55, boolean r56, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r57, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r58, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r59, androidx.compose.runtime.Composer r60, int r61, int r62, int r63) {
        /*
            r15 = r44
            r14 = r45
            r13 = r49
            r12 = r50
            r11 = r53
            r10 = r54
            r9 = r63
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "pageSize"
            r8 = r47
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "orientation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "contentPadding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "flingBehavior"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "pageNestedScrollConnection"
            r7 = r58
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "pageContent"
            r6 = r59
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = -765777783(0xffffffffd25b2889, float:-2.35319476E11)
            r1 = r60
            androidx.compose.runtime.Composer r5 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Pager)P(5,13,8,10,11:c#ui.unit.Dp,6!1,15,3!2,14,12!1,9)264@12945L7,265@13000L7,266@13044L187,274@13262L94,278@13406L77,278@13362L121,282@13511L188,282@13489L210,295@13843L2772:Pager.kt#g6yjnt"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r1)
            r4 = r61
            r3 = r62
            r1 = r9 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0061
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r1 = r1.getCenterVertically()
            r36 = r1
            goto L_0x0063
        L_0x0061:
            r36 = r51
        L_0x0063:
            r1 = r9 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0070
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r1 = r1.getCenterHorizontally()
            r37 = r1
            goto L_0x0072
        L_0x0070:
            r37 = r52
        L_0x0072:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x007d
            java.lang.String r1 = "androidx.compose.foundation.pager.Pager (Pager.kt:240)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r4, r3, r1)
        L_0x007d:
            r0 = 0
            if (r12 < 0) goto L_0x0082
            r1 = 1
            goto L_0x0083
        L_0x0082:
            r1 = r0
        L_0x0083:
            if (r1 == 0) goto L_0x031f
            androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r13 != r1) goto L_0x008a
            r0 = 1
        L_0x008a:
            r1 = r0
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r16 = 0
            r17 = 0
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            r52 = r1
            java.lang.String r1 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r2, r1)
            java.lang.Object r18 = r5.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r0 = r18
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r2 = r16
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r16 = 0
            r17 = 0
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r6, r1)
            java.lang.Object r1 = r5.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r6 = r1
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            int r1 = r4 >> 27
            r1 = r1 & 14
            int r2 = r4 >> 12
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = 0
            r60 = r1
            r1 = 1618982084(0x607fb4c4, float:7.370227E19)
            r5.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r1)
            boolean r17 = r5.changed((java.lang.Object) r11)
            boolean r18 = r5.changed((java.lang.Object) r13)
            r17 = r17 | r18
            boolean r18 = r5.changed((java.lang.Object) r6)
            r17 = r17 | r18
            r18 = r5
            r19 = 0
            r20 = r2
            java.lang.Object r2 = r18.rememberedValue()
            r21 = 0
            if (r17 != 0) goto L_0x010c
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r22.getEmpty()
            if (r2 != r7) goto L_0x0106
            goto L_0x010c
        L_0x0106:
            r7 = r2
            r22 = r7
            r2 = r18
            goto L_0x0121
        L_0x010c:
            r7 = 0
            float r7 = calculateContentPaddings(r11, r13, r6)
            androidx.compose.ui.unit.Dp r7 = androidx.compose.ui.unit.Dp.m5984boximpl(r7)
            r22 = r2
            r2 = r18
            r2.updateRememberedValue(r7)
        L_0x0121:
            r5.endReplaceableGroup()
            androidx.compose.ui.unit.Dp r7 = (androidx.compose.ui.unit.Dp) r7
            float r38 = r7.m6000unboximpl()
            r2 = r3 & 14
            r7 = r4 & 112(0x70, float:1.57E-43)
            r2 = r2 | r7
            r7 = 0
            r60 = r2
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r5.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            boolean r2 = r5.changed((java.lang.Object) r10)
            boolean r17 = r5.changed((java.lang.Object) r14)
            r2 = r2 | r17
            r17 = r5
            r18 = 0
            r19 = r3
            java.lang.Object r3 = r17.rememberedValue()
            r20 = 0
            if (r2 != 0) goto L_0x0169
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r22 = r2
            java.lang.Object r2 = r21.getEmpty()
            if (r3 != r2) goto L_0x0163
            goto L_0x016b
        L_0x0163:
            r2 = r3
            r21 = r2
            r3 = r17
            goto L_0x017c
        L_0x0169:
            r22 = r2
        L_0x016b:
            r2 = 0
            r21 = r2
            androidx.compose.foundation.pager.PagerWrapperFlingBehavior r2 = new androidx.compose.foundation.pager.PagerWrapperFlingBehavior
            r2.<init>(r10, r14)
            r21 = r3
            r3 = r17
            r3.updateRememberedValue(r2)
        L_0x017c:
            r5.endReplaceableGroup()
            r39 = r2
            androidx.compose.foundation.pager.PagerWrapperFlingBehavior r39 = (androidx.compose.foundation.pager.PagerWrapperFlingBehavior) r39
            androidx.compose.ui.unit.Dp r2 = androidx.compose.ui.unit.Dp.m5984boximpl(r48)
            androidx.compose.ui.unit.Dp r3 = androidx.compose.ui.unit.Dp.m5984boximpl(r48)
            r7 = r4 & 112(0x70, float:1.57E-43)
            r60 = r6
            int r6 = r4 >> 6
            r6 = r6 & 896(0x380, float:1.256E-42)
            r6 = r6 | r7
            r7 = 0
            r17 = r6
            r6 = 1618982084(0x607fb4c4, float:7.370227E19)
            r5.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r1)
            boolean r1 = r5.changed((java.lang.Object) r0)
            boolean r6 = r5.changed((java.lang.Object) r14)
            r1 = r1 | r6
            boolean r6 = r5.changed((java.lang.Object) r3)
            r1 = r1 | r6
            r6 = r5
            r16 = 0
            r18 = r3
            java.lang.Object r3 = r6.rememberedValue()
            r20 = 0
            r21 = r7
            if (r1 != 0) goto L_0x01d0
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r22.getEmpty()
            if (r3 != r7) goto L_0x01c8
            goto L_0x01d0
        L_0x01c8:
            r13 = r48
            r22 = r1
            r1 = r3
            r24 = r1
            goto L_0x01e4
        L_0x01d0:
            r7 = 0
            r22 = r1
            androidx.compose.foundation.pager.PagerKt$Pager$2$1 r1 = new androidx.compose.foundation.pager.PagerKt$Pager$2$1
            r13 = r48
            r24 = r3
            r3 = 0
            r1.<init>(r0, r14, r13, r3)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r6.updateRememberedValue(r1)
        L_0x01e4:
            r5.endReplaceableGroup()
            r3 = r1
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r1 = r4 & 112(0x70, float:1.57E-43)
            r1 = r1 | 4096(0x1000, float:5.74E-42)
            int r6 = r4 >> 6
            r6 = r6 & 896(0x380, float:1.256E-42)
            r6 = r6 | r1
            r40 = r0
            r7 = r52
            r1 = r45
            r8 = 1
            r41 = r19
            r42 = r4
            r4 = r5
            r8 = r5
            r5 = r6
            androidx.compose.runtime.EffectsKt.LaunchedEffect(r0, r1, r2, r3, r4, r5)
            int r0 = r42 >> 3
            r0 = r0 & 14
            r1 = 0
            r2 = 1157296644(0x44faf204, float:2007.563)
            r8.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            boolean r2 = r8.changed((java.lang.Object) r14)
            r3 = r8
            r4 = 0
            java.lang.Object r5 = r3.rememberedValue()
            r6 = 0
            if (r2 != 0) goto L_0x0232
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r52 = r0
            java.lang.Object r0 = r16.getEmpty()
            if (r5 != r0) goto L_0x022e
            goto L_0x0234
        L_0x022e:
            r17 = r1
            r0 = r5
            goto L_0x0246
        L_0x0232:
            r52 = r0
        L_0x0234:
            r0 = 0
            r16 = r0
            androidx.compose.foundation.pager.PagerKt$Pager$3$1 r0 = new androidx.compose.foundation.pager.PagerKt$Pager$3$1
            r17 = r1
            r1 = 0
            r0.<init>(r14, r1)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r3.updateRememberedValue(r0)
        L_0x0246:
            r8.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            int r1 = r42 >> 3
            r1 = r1 & 14
            r1 = r1 | 64
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r14, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r0, (androidx.compose.runtime.Composer) r8, (int) r1)
            r0 = 1445594592(0x562a05e0, float:4.6735552E13)
            r8.startReplaceableGroup(r0)
            java.lang.String r0 = "290@13768L33"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            if (r55 == 0) goto L_0x0270
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r1 = r42 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            androidx.compose.ui.Modifier r0 = pagerSemantics(r0, r14, r7, r8, r1)
            goto L_0x0274
        L_0x0270:
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x0274:
            r8.endReplaceableGroup()
            r6 = r0
            androidx.compose.ui.Modifier r0 = r15.then(r6)
            r1 = 0
            r2 = 0
            androidx.compose.foundation.pager.PagerKt$Pager$4 r3 = new androidx.compose.foundation.pager.PagerKt$Pager$4
            r16 = r3
            r17 = r7
            r18 = r40
            r19 = r48
            r20 = r38
            r21 = r56
            r22 = r45
            r23 = r42
            r24 = r53
            r25 = r39
            r26 = r55
            r27 = r50
            r28 = r37
            r29 = r36
            r30 = r41
            r31 = r47
            r32 = r46
            r33 = r57
            r34 = r58
            r35 = r59
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35)
            r4 = -1677736225(0xffffffff9bffc6df, float:-4.2314729E-22)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r4, r5, r3)
            r19 = r3
            kotlin.jvm.functions.Function3 r19 = (kotlin.jvm.functions.Function3) r19
            r21 = 3072(0xc00, float:4.305E-42)
            r22 = 6
            r16 = r0
            r17 = r1
            r18 = r2
            r20 = r8
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r16, r17, r18, r19, r20, r21, r22)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02cf
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02cf:
            androidx.compose.runtime.ScopeUpdateScope r5 = r8.endRestartGroup()
            if (r5 != 0) goto L_0x02de
            r21 = r60
            r22 = r6
            r23 = r7
            r24 = r8
            goto L_0x031e
        L_0x02de:
            androidx.compose.foundation.pager.PagerKt$Pager$5 r20 = new androidx.compose.foundation.pager.PagerKt$Pager$5
            r0 = r20
            r1 = r44
            r2 = r45
            r3 = r46
            r4 = r47
            r43 = r5
            r5 = r48
            r21 = r60
            r22 = r6
            r6 = r49
            r23 = r7
            r7 = r50
            r24 = r8
            r8 = r36
            r9 = r37
            r10 = r53
            r11 = r54
            r12 = r55
            r13 = r56
            r14 = r57
            r15 = r58
            r16 = r59
            r17 = r61
            r18 = r62
            r19 = r63
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r43
            r1.updateScope(r0)
        L_0x031e:
            return
        L_0x031f:
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "beyondBoundsPageCount should be greater than or equal to 0, you selected "
            java.lang.StringBuilder r1 = r1.append(r2)
            r2 = r50
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.m1077PagerwKDqQAw(androidx.compose.ui.Modifier, androidx.compose.foundation.pager.PagerState, int, androidx.compose.foundation.pager.PageSize, float, androidx.compose.foundation.gestures.Orientation, int, androidx.compose.ui.Alignment$Vertical, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final float calculateContentPaddings(PaddingValues contentPadding, Orientation orientation, LayoutDirection layoutDirection) {
        float startPadding;
        float endPadding;
        if (orientation == Orientation.Vertical) {
            startPadding = contentPadding.m773calculateTopPaddingD9Ej5fM();
        } else {
            startPadding = contentPadding.m771calculateLeftPaddingu2uoSUM(layoutDirection);
        }
        if (orientation == Orientation.Vertical) {
            endPadding = contentPadding.m770calculateBottomPaddingD9Ej5fM();
        } else {
            endPadding = contentPadding.m772calculateRightPaddingu2uoSUM(layoutDirection);
        }
        return Dp.m5986constructorimpl(startPadding + endPadding);
    }

    /* access modifiers changed from: private */
    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(PagerState pagerState, PagerSnapDistance pagerSnapDistance, DecayAnimationSpec<Float> decayAnimationSpec) {
        return new PagerKt$SnapLayoutInfoProvider$1(pagerState, decayAnimationSpec, pagerSnapDistance);
    }

    private static final Modifier pagerSemantics(Modifier $this$pagerSemantics, PagerState state, boolean isVertical, Composer $composer, int $changed) {
        Object value$iv$iv$iv;
        Composer composer = $composer;
        composer.startReplaceableGroup(1509835088);
        ComposerKt.sourceInformation(composer, "C(pagerSemantics)P(1)739@30533L24:Pager.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1509835088, $changed, -1, "androidx.compose.foundation.pager.pagerSemantics (Pager.kt:738)");
        } else {
            int i = $changed;
        }
        composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
        Composer composer$iv = $composer;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv$iv = $composer;
        Object it$iv$iv$iv = $this$cache$iv$iv$iv.rememberedValue();
        if (it$iv$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer$iv));
            $this$cache$iv$iv$iv.updateRememberedValue(value$iv$iv$iv);
        } else {
            value$iv$iv$iv = it$iv$iv$iv;
        }
        $composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv).getCoroutineScope();
        $composer.endReplaceableGroup();
        CoroutineScope scope = coroutineScope;
        Modifier then = $this$pagerSemantics.then(SemanticsModifierKt.semantics$default(Modifier.Companion, false, new PagerKt$pagerSemantics$1(isVertical, state, scope), 1, (Object) null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return then;
    }

    /* access modifiers changed from: private */
    public static final boolean pagerSemantics$performForwardPaging(PagerState $state, CoroutineScope scope) {
        if (!$state.getCanScrollForward()) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new PagerKt$pagerSemantics$performForwardPaging$1($state, (Continuation<? super PagerKt$pagerSemantics$performForwardPaging$1>) null), 3, (Object) null);
        return true;
    }

    /* access modifiers changed from: private */
    public static final boolean pagerSemantics$performBackwardPaging(PagerState $state, CoroutineScope scope) {
        if (!$state.getCanScrollBackward()) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new PagerKt$pagerSemantics$performBackwardPaging$1($state, (Continuation<? super PagerKt$pagerSemantics$performBackwardPaging$1>) null), 3, (Object) null);
        return true;
    }

    private static final void debugLog(Function0<String> generateMsg) {
    }
}
