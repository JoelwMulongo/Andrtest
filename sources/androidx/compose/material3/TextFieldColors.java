package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001Bê\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010 J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030%H\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u0010(\u001a\u00020)H\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001a\u00020)2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010.\u001a\u00020/H\u0016J0\u00100\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)2\u0006\u0010(\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105J0\u00106\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)2\u0006\u0010(\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0001ø\u0001\u0000¢\u0006\u0004\b7\u00105J0\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)2\u0006\u0010(\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0001ø\u0001\u0000¢\u0006\u0004\b9\u00105J \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)H\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010+J0\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)2\u0006\u0010(\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0001ø\u0001\u0000¢\u0006\u0004\b<\u00105J \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)H\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010+J0\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)2\u0006\u0010(\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0001ø\u0001\u0000¢\u0006\u0004\b?\u00105R\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\r\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0018\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0010\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u001b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u001e\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0014\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0019\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0011\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u001f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0015\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0016\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u000e\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u001c\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0012\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u001a\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0014\u0010\"\u001a\u00020\t8AX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0017\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u000f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u001d\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0013\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006@"}, d2 = {"Landroidx/compose/material3/TextFieldColors;", "", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "containerColor", "cursorColor", "errorCursorColor", "textSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "errorIndicatorColor", "disabledIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "selectionColors", "getSelectionColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "Landroidx/compose/runtime/State;", "containerColor$material3_release", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "isError", "", "cursorColor$material3_release", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "indicatorColor", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "indicatorColor$material3_release", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "labelColor", "labelColor$material3_release", "leadingIconColor", "leadingIconColor$material3_release", "placeholderColor$material3_release", "supportingTextColor", "supportingTextColor$material3_release", "textColor$material3_release", "trailingIconColor", "trailingIconColor$material3_release", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextFieldDefaults.kt */
public final class TextFieldColors {
    private final long containerColor;
    private final long cursorColor;
    private final long disabledIndicatorColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledPlaceholderColor;
    private final long disabledSupportingTextColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long errorCursorColor;
    private final long errorIndicatorColor;
    private final long errorLabelColor;
    private final long errorLeadingIconColor;
    private final long errorSupportingTextColor;
    private final long errorTrailingIconColor;
    private final long focusedIndicatorColor;
    private final long focusedLabelColor;
    private final long focusedLeadingIconColor;
    private final long focusedSupportingTextColor;
    private final long focusedTrailingIconColor;
    private final long placeholderColor;
    private final long textColor;
    private final TextSelectionColors textSelectionColors;
    private final long unfocusedIndicatorColor;
    private final long unfocusedLabelColor;
    private final long unfocusedLeadingIconColor;
    private final long unfocusedSupportingTextColor;
    private final long unfocusedTrailingIconColor;

    public /* synthetic */ TextFieldColors(long j, long j2, long j3, long j4, long j5, TextSelectionColors textSelectionColors2, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, textSelectionColors2, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27);
    }

    private TextFieldColors(long textColor2, long disabledTextColor2, long containerColor2, long cursorColor2, long errorCursorColor2, TextSelectionColors textSelectionColors2, long focusedIndicatorColor2, long unfocusedIndicatorColor2, long errorIndicatorColor2, long disabledIndicatorColor2, long focusedLeadingIconColor2, long unfocusedLeadingIconColor2, long disabledLeadingIconColor2, long errorLeadingIconColor2, long focusedTrailingIconColor2, long unfocusedTrailingIconColor2, long disabledTrailingIconColor2, long errorTrailingIconColor2, long focusedLabelColor2, long unfocusedLabelColor2, long disabledLabelColor2, long errorLabelColor2, long placeholderColor2, long disabledPlaceholderColor2, long focusedSupportingTextColor2, long unfocusedSupportingTextColor2, long disabledSupportingTextColor2, long errorSupportingTextColor2) {
        this.textColor = textColor2;
        this.disabledTextColor = disabledTextColor2;
        this.containerColor = containerColor2;
        this.cursorColor = cursorColor2;
        this.errorCursorColor = errorCursorColor2;
        this.textSelectionColors = textSelectionColors2;
        this.focusedIndicatorColor = focusedIndicatorColor2;
        this.unfocusedIndicatorColor = unfocusedIndicatorColor2;
        this.errorIndicatorColor = errorIndicatorColor2;
        this.disabledIndicatorColor = disabledIndicatorColor2;
        this.focusedLeadingIconColor = focusedLeadingIconColor2;
        this.unfocusedLeadingIconColor = unfocusedLeadingIconColor2;
        this.disabledLeadingIconColor = disabledLeadingIconColor2;
        this.errorLeadingIconColor = errorLeadingIconColor2;
        this.focusedTrailingIconColor = focusedTrailingIconColor2;
        this.unfocusedTrailingIconColor = unfocusedTrailingIconColor2;
        this.disabledTrailingIconColor = disabledTrailingIconColor2;
        this.errorTrailingIconColor = errorTrailingIconColor2;
        this.focusedLabelColor = focusedLabelColor2;
        this.unfocusedLabelColor = unfocusedLabelColor2;
        this.disabledLabelColor = disabledLabelColor2;
        this.errorLabelColor = errorLabelColor2;
        this.placeholderColor = placeholderColor2;
        this.disabledPlaceholderColor = disabledPlaceholderColor2;
        this.focusedSupportingTextColor = focusedSupportingTextColor2;
        this.unfocusedSupportingTextColor = unfocusedSupportingTextColor2;
        this.disabledSupportingTextColor = disabledSupportingTextColor2;
        this.errorSupportingTextColor = errorSupportingTextColor2;
    }

    public final State<Color> leadingIconColor$material3_release(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        long j;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(925127045);
        ComposerKt.sourceInformation($composer, "C(leadingIconColor)P(!1,2)723@39615L25,725@39657L267:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(925127045, $changed, -1, "androidx.compose.material3.TextFieldColors.leadingIconColor (TextFieldDefaults.kt:718)");
        }
        State focused$delegate = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer, ($changed >> 6) & 14);
        if (!enabled) {
            j = this.disabledLeadingIconColor;
        } else if (isError) {
            j = this.errorLeadingIconColor;
        } else if (m2140leadingIconColor$lambda0(focused$delegate)) {
            j = this.focusedLeadingIconColor;
        } else {
            j = this.unfocusedLeadingIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(j), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    /* renamed from: leadingIconColor$lambda-0  reason: not valid java name */
    private static final boolean m2140leadingIconColor$lambda0(State<Boolean> $focused$delegate) {
        return ((Boolean) $focused$delegate.getValue()).booleanValue();
    }

    public final State<Color> trailingIconColor$material3_release(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        long j;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(-109504137);
        ComposerKt.sourceInformation($composer, "C(trailingIconColor)P(!1,2)749@40510L25,751@40552L271:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-109504137, $changed, -1, "androidx.compose.material3.TextFieldColors.trailingIconColor (TextFieldDefaults.kt:744)");
        }
        State focused$delegate = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer, ($changed >> 6) & 14);
        if (!enabled) {
            j = this.disabledTrailingIconColor;
        } else if (isError) {
            j = this.errorTrailingIconColor;
        } else if (m2142trailingIconColor$lambda1(focused$delegate)) {
            j = this.focusedTrailingIconColor;
        } else {
            j = this.unfocusedTrailingIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(j), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    /* renamed from: trailingIconColor$lambda-1  reason: not valid java name */
    private static final boolean m2142trailingIconColor$lambda1(State<Boolean> $focused$delegate) {
        return ((Boolean) $focused$delegate.getValue()).booleanValue();
    }

    public final State<Color> indicatorColor$material3_release(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        long targetValue;
        State<Color> state;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(-1877482635);
        ComposerKt.sourceInformation($composer, "C(indicatorColor)P(!1,2)775@41409L25:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1877482635, $changed, -1, "androidx.compose.material3.TextFieldColors.indicatorColor (TextFieldDefaults.kt:770)");
        }
        State focused$delegate = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer, ($changed >> 6) & 14);
        if (!enabled) {
            targetValue = this.disabledIndicatorColor;
        } else if (isError) {
            targetValue = this.errorIndicatorColor;
        } else if (m2138indicatorColor$lambda2(focused$delegate)) {
            targetValue = this.focusedIndicatorColor;
        } else {
            targetValue = this.unfocusedIndicatorColor;
        }
        if (enabled) {
            $composer.startReplaceableGroup(715730990);
            ComposerKt.sourceInformation($composer, "784@41700L75");
            state = SingleValueAnimationKt.m362animateColorAsStateKTwxG1Y(targetValue, AnimationSpecKt.tween$default(150, 0, (Easing) null, 6, (Object) null), (Function1) null, $composer, 48, 4);
            $composer.endReplaceableGroup();
        } else {
            $composer.startReplaceableGroup(715731095);
            ComposerKt.sourceInformation($composer, "786@41805L33");
            state = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(targetValue), $composer, 0);
            $composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return state;
    }

    /* renamed from: indicatorColor$lambda-2  reason: not valid java name */
    private static final boolean m2138indicatorColor$lambda2(State<Boolean> $focused$delegate) {
        return ((Boolean) $focused$delegate.getValue()).booleanValue();
    }

    public final State<Color> containerColor$material3_release(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(954653884);
        ComposerKt.sourceInformation($composer, "C(containerColor)795@42012L36:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(954653884, $changed, -1, "androidx.compose.material3.TextFieldColors.containerColor (TextFieldDefaults.kt:794)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(this.containerColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> placeholderColor$material3_release(boolean enabled, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-117469162);
        ComposerKt.sourceInformation($composer, "C(placeholderColor)805@42307L81:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-117469162, $changed, -1, "androidx.compose.material3.TextFieldColors.placeholderColor (TextFieldDefaults.kt:804)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(enabled ? this.placeholderColor : this.disabledPlaceholderColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> labelColor$material3_release(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        long targetValue;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(1167161306);
        ComposerKt.sourceInformation($composer, "C(labelColor)P(!1,2)822@42959L25,830@43207L33:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1167161306, $changed, -1, "androidx.compose.material3.TextFieldColors.labelColor (TextFieldDefaults.kt:817)");
        }
        State focused$delegate = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer, ($changed >> 6) & 14);
        if (!enabled) {
            targetValue = this.disabledLabelColor;
        } else if (isError) {
            targetValue = this.errorLabelColor;
        } else if (m2139labelColor$lambda3(focused$delegate)) {
            targetValue = this.focusedLabelColor;
        } else {
            targetValue = this.unfocusedLabelColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(targetValue), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    /* renamed from: labelColor$lambda-3  reason: not valid java name */
    private static final boolean m2139labelColor$lambda3(State<Boolean> $focused$delegate) {
        return ((Boolean) $focused$delegate.getValue()).booleanValue();
    }

    public final State<Color> textColor$material3_release(boolean enabled, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(2080722220);
        ComposerKt.sourceInformation($composer, "C(textColor)835@43340L67:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2080722220, $changed, -1, "androidx.compose.material3.TextFieldColors.textColor (TextFieldDefaults.kt:834)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(enabled ? this.textColor : this.disabledTextColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> supportingTextColor$material3_release(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        long j;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(1464709698);
        ComposerKt.sourceInformation($composer, "C(supportingTextColor)P(!1,2)844@43629L25,846@43671L279:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1464709698, $changed, -1, "androidx.compose.material3.TextFieldColors.supportingTextColor (TextFieldDefaults.kt:839)");
        }
        State focused$delegate = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer, ($changed >> 6) & 14);
        if (!enabled) {
            j = this.disabledSupportingTextColor;
        } else if (isError) {
            j = this.errorSupportingTextColor;
        } else if (m2141supportingTextColor$lambda4(focused$delegate)) {
            j = this.focusedSupportingTextColor;
        } else {
            j = this.unfocusedSupportingTextColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(j), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    /* renamed from: supportingTextColor$lambda-4  reason: not valid java name */
    private static final boolean m2141supportingTextColor$lambda4(State<Boolean> $focused$delegate) {
        return ((Boolean) $focused$delegate.getValue()).booleanValue();
    }

    public final State<Color> cursorColor$material3_release(boolean isError, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1885422187);
        ComposerKt.sourceInformation($composer, "C(cursorColor)863@44216L68:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1885422187, $changed, -1, "androidx.compose.material3.TextFieldColors.cursorColor (TextFieldDefaults.kt:862)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3154boximpl(isError ? this.errorCursorColor : this.cursorColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final TextSelectionColors getSelectionColors(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(997785083);
        ComposerKt.sourceInformation($composer, "C:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(997785083, $changed, -1, "androidx.compose.material3.TextFieldColors.<get-selectionColors> (TextFieldDefaults.kt:870)");
        }
        TextSelectionColors textSelectionColors2 = this.textSelectionColors;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return textSelectionColors2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof TextFieldColors) || !Color.m3165equalsimpl0(this.textColor, ((TextFieldColors) other).textColor) || !Color.m3165equalsimpl0(this.disabledTextColor, ((TextFieldColors) other).disabledTextColor) || !Color.m3165equalsimpl0(this.cursorColor, ((TextFieldColors) other).cursorColor) || !Color.m3165equalsimpl0(this.errorCursorColor, ((TextFieldColors) other).errorCursorColor) || !Intrinsics.areEqual((Object) this.textSelectionColors, (Object) ((TextFieldColors) other).textSelectionColors) || !Color.m3165equalsimpl0(this.focusedIndicatorColor, ((TextFieldColors) other).focusedIndicatorColor) || !Color.m3165equalsimpl0(this.unfocusedIndicatorColor, ((TextFieldColors) other).unfocusedIndicatorColor) || !Color.m3165equalsimpl0(this.errorIndicatorColor, ((TextFieldColors) other).errorIndicatorColor) || !Color.m3165equalsimpl0(this.disabledIndicatorColor, ((TextFieldColors) other).disabledIndicatorColor) || !Color.m3165equalsimpl0(this.focusedLeadingIconColor, ((TextFieldColors) other).focusedLeadingIconColor) || !Color.m3165equalsimpl0(this.unfocusedLeadingIconColor, ((TextFieldColors) other).unfocusedLeadingIconColor) || !Color.m3165equalsimpl0(this.disabledLeadingIconColor, ((TextFieldColors) other).disabledLeadingIconColor) || !Color.m3165equalsimpl0(this.errorLeadingIconColor, ((TextFieldColors) other).errorLeadingIconColor) || !Color.m3165equalsimpl0(this.focusedTrailingIconColor, ((TextFieldColors) other).focusedTrailingIconColor) || !Color.m3165equalsimpl0(this.unfocusedTrailingIconColor, ((TextFieldColors) other).unfocusedTrailingIconColor) || !Color.m3165equalsimpl0(this.disabledTrailingIconColor, ((TextFieldColors) other).disabledTrailingIconColor) || !Color.m3165equalsimpl0(this.errorTrailingIconColor, ((TextFieldColors) other).errorTrailingIconColor) || !Color.m3165equalsimpl0(this.containerColor, ((TextFieldColors) other).containerColor) || !Color.m3165equalsimpl0(this.focusedLabelColor, ((TextFieldColors) other).focusedLabelColor) || !Color.m3165equalsimpl0(this.unfocusedLabelColor, ((TextFieldColors) other).unfocusedLabelColor) || !Color.m3165equalsimpl0(this.disabledLabelColor, ((TextFieldColors) other).disabledLabelColor) || !Color.m3165equalsimpl0(this.errorLabelColor, ((TextFieldColors) other).errorLabelColor) || !Color.m3165equalsimpl0(this.placeholderColor, ((TextFieldColors) other).placeholderColor) || !Color.m3165equalsimpl0(this.disabledPlaceholderColor, ((TextFieldColors) other).disabledPlaceholderColor) || !Color.m3165equalsimpl0(this.focusedSupportingTextColor, ((TextFieldColors) other).focusedSupportingTextColor) || !Color.m3165equalsimpl0(this.unfocusedSupportingTextColor, ((TextFieldColors) other).unfocusedSupportingTextColor) || !Color.m3165equalsimpl0(this.disabledSupportingTextColor, ((TextFieldColors) other).disabledSupportingTextColor) || !Color.m3165equalsimpl0(this.errorSupportingTextColor, ((TextFieldColors) other).errorSupportingTextColor)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((Color.m3171hashCodeimpl(this.textColor) * 31) + Color.m3171hashCodeimpl(this.disabledTextColor)) * 31) + Color.m3171hashCodeimpl(this.cursorColor)) * 31) + Color.m3171hashCodeimpl(this.errorCursorColor)) * 31) + this.textSelectionColors.hashCode()) * 31) + Color.m3171hashCodeimpl(this.focusedIndicatorColor)) * 31) + Color.m3171hashCodeimpl(this.unfocusedIndicatorColor)) * 31) + Color.m3171hashCodeimpl(this.errorIndicatorColor)) * 31) + Color.m3171hashCodeimpl(this.disabledIndicatorColor)) * 31) + Color.m3171hashCodeimpl(this.focusedLeadingIconColor)) * 31) + Color.m3171hashCodeimpl(this.unfocusedLeadingIconColor)) * 31) + Color.m3171hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m3171hashCodeimpl(this.errorLeadingIconColor)) * 31) + Color.m3171hashCodeimpl(this.focusedTrailingIconColor)) * 31) + Color.m3171hashCodeimpl(this.unfocusedTrailingIconColor)) * 31) + Color.m3171hashCodeimpl(this.disabledTrailingIconColor)) * 31) + Color.m3171hashCodeimpl(this.errorTrailingIconColor)) * 31) + Color.m3171hashCodeimpl(this.containerColor)) * 31) + Color.m3171hashCodeimpl(this.focusedLabelColor)) * 31) + Color.m3171hashCodeimpl(this.unfocusedLabelColor)) * 31) + Color.m3171hashCodeimpl(this.disabledLabelColor)) * 31) + Color.m3171hashCodeimpl(this.errorLabelColor)) * 31) + Color.m3171hashCodeimpl(this.placeholderColor)) * 31) + Color.m3171hashCodeimpl(this.disabledPlaceholderColor)) * 31) + Color.m3171hashCodeimpl(this.focusedSupportingTextColor)) * 31) + Color.m3171hashCodeimpl(this.unfocusedSupportingTextColor)) * 31) + Color.m3171hashCodeimpl(this.disabledSupportingTextColor)) * 31) + Color.m3171hashCodeimpl(this.errorSupportingTextColor);
    }
}
