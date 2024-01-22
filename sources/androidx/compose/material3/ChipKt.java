package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a¦\u0001\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001d\u001a¼\u0001\u0010\u001e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u0001\u0010(\u001a\u00020\b2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0006\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0001H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a¦\u0001\u0010.\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001d\u001a®\u0001\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u0002012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u0001022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u0001032\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u00104\u001a\u0001\u00105\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u00107\u001a®\u0001\u00108\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u0002012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u0001022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u0001032\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u00104\u001aÅ\u0001\u00109\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u0002012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u0001022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u0001032\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010:\u001aÑ\u0001\u0010;\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\u0006\u0010\u001f\u001a\u00020 2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u0002012\b\u0010\u0017\u001a\u0004\u0018\u0001022\b\u0010\u0019\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a\u0001\u0010>\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u00107\u001a&\u0010?\u001a\u00020\u00012\b\b\u0002\u0010@\u001a\u00020\u00102\b\b\u0002\u0010A\u001a\u00020\u00102\b\b\u0002\u0010B\u001a\u00020\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006C"}, d2 = {"AssistChipPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "FilterChipPadding", "HorizontalElementsPadding", "Landroidx/compose/ui/unit/Dp;", "F", "SuggestionChipPadding", "AssistChip", "", "onClick", "Lkotlin/Function0;", "label", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "leadingIcon", "trailingIcon", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ChipColors;", "elevation", "Landroidx/compose/material3/ChipElevation;", "border", "Landroidx/compose/material3/ChipBorder;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Chip", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "labelColor", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/foundation/BorderStroke;", "minHeight", "paddingValues", "Chip-nkUnTEs", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ChipContent", "avatar", "leadingIconColor", "trailingIconColor", "ChipContent-fe0OD_I", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "ElevatedAssistChip", "ElevatedFilterChip", "selected", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/SelectableChipElevation;", "Landroidx/compose/material3/SelectableChipBorder;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/material3/SelectableChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "ElevatedSuggestionChip", "icon", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "InputChip", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/material3/SelectableChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "SelectableChip", "SelectableChip-u0RnIRE", "(ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SuggestionChip", "inputChipPadding", "hasAvatar", "hasLeadingIcon", "hasTrailingIcon", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Chip.kt */
public final class ChipKt {
    private static final PaddingValues AssistChipPadding;
    private static final PaddingValues FilterChipPadding;
    /* access modifiers changed from: private */
    public static final float HorizontalElementsPadding;
    private static final PaddingValues SuggestionChipPadding;

    @ExperimentalMaterial3Api
    public static final void AssistChip(Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, ChipColors colors, ChipElevation elevation, ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1, int i) {
        Modifier modifier2;
        Function2 leadingIcon2;
        ChipColors chipColors;
        int i2;
        MutableInteractionSource mutableInteractionSource;
        Shape shape2;
        Function2 trailingIcon2;
        boolean enabled2;
        Composer $composer2;
        ChipColors colors2;
        ChipBorder border2;
        MutableInteractionSource interactionSource2;
        ChipElevation elevation2;
        Function2 leadingIcon3;
        Modifier modifier3;
        int $dirty1;
        boolean enabled3;
        ChipColors colors3;
        ChipBorder border3;
        int $dirty;
        int $dirty12;
        Modifier modifier4;
        boolean enabled4;
        ChipColors colors4;
        int $dirty2;
        ChipElevation elevation3;
        int i3;
        ChipBorder border4;
        MutableInteractionSource mutableInteractionSource2;
        int i4;
        int i5;
        int i6;
        int i7;
        Function0<Unit> function0 = onClick;
        Function2<? super Composer, ? super Integer, Unit> function2 = label;
        int i8 = $changed;
        int i9 = i;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function2, "label");
        Composer $composer3 = $composer.startRestartGroup(-1932300596);
        ComposerKt.sourceInformation($composer3, "C(AssistChip)P(8,5,7,3,6,10,9,1,2)111@5649L5,112@5700L18,113@5771L21,114@5839L18,115@5909L39,121@6085L10,122@6163L19,128@6342L21,116@5954L543:Chip.kt#uh7d8r");
        int $dirty3 = $changed;
        int $dirty13 = $changed1;
        if ((i9 & 1) != 0) {
            $dirty3 |= 6;
        } else if ((i8 & 14) == 0) {
            $dirty3 |= $composer3.changed((Object) function0) ? 4 : 2;
        }
        if ((i9 & 2) != 0) {
            $dirty3 |= 48;
        } else if ((i8 & 112) == 0) {
            $dirty3 |= $composer3.changed((Object) function2) ? 32 : 16;
        }
        int i10 = i9 & 4;
        if (i10 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if ((i8 & 896) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed((Object) modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i11 = i9 & 8;
        if (i11 != 0) {
            $dirty3 |= 3072;
            boolean z = enabled;
        } else if ((i8 & 7168) == 0) {
            $dirty3 |= $composer3.changed(enabled) ? 2048 : 1024;
        } else {
            boolean z2 = enabled;
        }
        int i12 = i9 & 16;
        if (i12 != 0) {
            $dirty3 |= 24576;
            leadingIcon2 = leadingIcon;
        } else if ((i8 & 57344) == 0) {
            leadingIcon2 = leadingIcon;
            $dirty3 |= $composer3.changed((Object) leadingIcon2) ? 16384 : 8192;
        } else {
            leadingIcon2 = leadingIcon;
        }
        int i13 = i9 & 32;
        if (i13 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            Function2<? super Composer, ? super Integer, Unit> function22 = trailingIcon;
        } else if ((i8 & 458752) == 0) {
            $dirty3 |= $composer3.changed((Object) trailingIcon) ? 131072 : 65536;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = trailingIcon;
        }
        if ((i8 & 3670016) == 0) {
            if ((i9 & 64) != 0) {
                Shape shape3 = shape;
            } else if ($composer3.changed((Object) shape)) {
                i7 = 1048576;
                $dirty3 |= i7;
            }
            i7 = 524288;
            $dirty3 |= i7;
        } else {
            Shape shape4 = shape;
        }
        if ((i8 & 29360128) == 0) {
            if ((i9 & 128) == 0) {
                chipColors = colors;
                if ($composer3.changed((Object) chipColors)) {
                    i6 = 8388608;
                    $dirty3 |= i6;
                }
            } else {
                chipColors = colors;
            }
            i6 = 4194304;
            $dirty3 |= i6;
        } else {
            chipColors = colors;
        }
        if ((i8 & 234881024) == 0) {
            if ((i9 & 256) != 0) {
                ChipElevation chipElevation = elevation;
            } else if ($composer3.changed((Object) elevation)) {
                i5 = 67108864;
                $dirty3 |= i5;
            }
            i5 = 33554432;
            $dirty3 |= i5;
        } else {
            ChipElevation chipElevation2 = elevation;
        }
        if ((i8 & 1879048192) == 0) {
            if ((i9 & 512) != 0) {
                ChipBorder chipBorder = border;
            } else if ($composer3.changed((Object) border)) {
                i4 = 536870912;
                $dirty3 |= i4;
            }
            i4 = 268435456;
            $dirty3 |= i4;
        } else {
            ChipBorder chipBorder2 = border;
        }
        int i14 = i9 & 1024;
        if (i14 != 0) {
            $dirty13 |= 6;
            i2 = i14;
            mutableInteractionSource = interactionSource;
        } else if (($changed1 & 14) == 0) {
            i2 = i14;
            mutableInteractionSource = interactionSource;
            $dirty13 |= $composer3.changed((Object) mutableInteractionSource) ? 4 : 2;
        } else {
            i2 = i14;
            mutableInteractionSource = interactionSource;
        }
        if (($dirty3 & 1533916891) == 306783378 && ($dirty13 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            enabled2 = enabled;
            trailingIcon2 = trailingIcon;
            shape2 = shape;
            elevation2 = elevation;
            border2 = border;
            int i15 = $dirty3;
            int i16 = $dirty13;
            colors2 = chipColors;
            modifier3 = modifier2;
            interactionSource2 = mutableInteractionSource;
            leadingIcon3 = leadingIcon2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if ((i8 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i10 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i11 != 0) {
                    enabled4 = true;
                } else {
                    enabled4 = enabled;
                }
                if (i12 != 0) {
                    leadingIcon2 = null;
                }
                if (i13 != 0) {
                    trailingIcon2 = null;
                } else {
                    trailingIcon2 = trailingIcon;
                }
                if ((i9 & 64) != 0) {
                    $dirty3 &= -3670017;
                    shape2 = AssistChipDefaults.INSTANCE.getShape($composer3, 6);
                } else {
                    shape2 = shape;
                }
                if ((i9 & 128) != 0) {
                    $dirty3 &= -29360129;
                    colors4 = AssistChipDefaults.INSTANCE.m1753assistChipColorsoq7We08(0, 0, 0, 0, 0, 0, 0, 0, $composer3, 100663296, 255);
                } else {
                    colors4 = chipColors;
                }
                if ((i9 & 256) != 0) {
                    $dirty2 = $dirty3 & -234881025;
                    elevation3 = AssistChipDefaults.INSTANCE.m1754assistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                } else {
                    elevation3 = elevation;
                    $dirty2 = $dirty3;
                }
                if ((i9 & 512) != 0) {
                    $dirty1 = $dirty13;
                    i3 = i2;
                    border4 = AssistChipDefaults.INSTANCE.m1752assistChipBorderd_3_b6Q(0, 0, 0.0f, $composer3, 3072, 7);
                    $dirty2 &= -1879048193;
                } else {
                    $dirty1 = $dirty13;
                    i3 = i2;
                    border4 = border;
                }
                if (i3 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        mutableInteractionSource2 = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource2);
                    } else {
                        mutableInteractionSource2 = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    modifier3 = modifier4;
                    border3 = border4;
                    interactionSource2 = mutableInteractionSource2;
                    leadingIcon3 = leadingIcon2;
                    elevation2 = elevation3;
                    $dirty = $dirty2;
                    colors3 = colors4;
                    enabled3 = enabled4;
                } else {
                    interactionSource2 = interactionSource;
                    modifier3 = modifier4;
                    border3 = border4;
                    leadingIcon3 = leadingIcon2;
                    elevation2 = elevation3;
                    $dirty = $dirty2;
                    colors3 = colors4;
                    enabled3 = enabled4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i9 & 64) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i9 & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                if ((i9 & 256) != 0) {
                    $dirty3 &= -234881025;
                }
                if ((i9 & 512) != 0) {
                    enabled3 = enabled;
                    trailingIcon2 = trailingIcon;
                    shape2 = shape;
                    elevation2 = elevation;
                    border3 = border;
                    interactionSource2 = interactionSource;
                    $dirty1 = $dirty13;
                    colors3 = chipColors;
                    modifier3 = modifier2;
                    leadingIcon3 = leadingIcon2;
                    $dirty = -1879048193 & $dirty3;
                } else {
                    enabled3 = enabled;
                    trailingIcon2 = trailingIcon;
                    shape2 = shape;
                    elevation2 = elevation;
                    border3 = border;
                    interactionSource2 = interactionSource;
                    $dirty1 = $dirty13;
                    colors3 = chipColors;
                    modifier3 = modifier2;
                    leadingIcon3 = leadingIcon2;
                    $dirty = $dirty3;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                $dirty12 = $dirty1;
                ComposerKt.traceEventStart(-1932300596, $dirty, $dirty12, "androidx.compose.material3.AssistChip (Chip.kt:104)");
            } else {
                $dirty12 = $dirty1;
            }
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), AssistChipTokens.INSTANCE.getLabelTextFont());
            long r23 = colors3.labelColor$material3_release(enabled3, $composer3, (($dirty >> 9) & 14) | (($dirty >> 18) & 112)).getValue().m3174unboximpl();
            State<BorderStroke> borderStroke$material3_release = border3 == null ? null : border3.borderStroke$material3_release(enabled3, $composer3, (($dirty >> 9) & 14) | (($dirty >> 24) & 112));
            $composer2 = $composer3;
            int i17 = (($dirty >> 6) & 14) | (($dirty << 3) & 112) | (($dirty >> 3) & 896) | (($dirty << 6) & 7168) | (($dirty << 6) & 3670016) | (($dirty << 6) & 29360128) | (($dirty << 6) & 234881024) | (($dirty << 6) & 1879048192);
            int i18 = (($dirty >> 24) & 14) | 3456 | (($dirty12 << 12) & 57344);
            int i19 = $dirty;
            int i20 = $dirty12;
            long j = r23;
            border2 = border3;
            colors2 = colors3;
            enabled2 = enabled3;
            m1785ChipnkUnTEs(modifier3, onClick, enabled3, label, fromToken, j, leadingIcon3, trailingIcon2, shape2, colors2, elevation2, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, AssistChipDefaults.INSTANCE.m1757getHeightD9Ej5fM(), AssistChipPadding, interactionSource2, $composer2, i17, i18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipKt$AssistChip$2(onClick, label, modifier3, enabled2, leadingIcon3, trailingIcon2, shape2, colors2, elevation2, border2, interactionSource2, $changed, $changed1, i));
        }
    }

    @ExperimentalMaterial3Api
    public static final void ElevatedAssistChip(Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, ChipColors colors, ChipElevation elevation, ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1, int i) {
        Modifier modifier2;
        boolean z;
        ChipColors chipColors;
        int i2;
        int i3;
        MutableInteractionSource mutableInteractionSource;
        Shape shape2;
        Function2 trailingIcon2;
        Function2 leadingIcon2;
        boolean enabled2;
        Composer $composer2;
        ChipColors colors2;
        ChipBorder border2;
        MutableInteractionSource interactionSource2;
        ChipElevation elevation2;
        Modifier modifier3;
        int $dirty1;
        boolean enabled3;
        ChipColors colors3;
        ChipBorder border3;
        int $dirty;
        int i4;
        int $dirty12;
        Modifier modifier4;
        boolean enabled4;
        int $dirty2;
        ChipColors colors4;
        Modifier modifier5;
        int i5;
        int i6;
        ChipElevation elevation3;
        ChipBorder border4;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        int i8;
        int i9;
        Function0<Unit> function0 = onClick;
        Function2<? super Composer, ? super Integer, Unit> function2 = label;
        int i10 = $changed;
        int i11 = i;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function2, "label");
        Composer $composer3 = $composer.startRestartGroup(1295844802);
        ComposerKt.sourceInformation($composer3, "C(ElevatedAssistChip)P(8,5,7,3,6,10,9,1,2)183@9378L5,184@9429L26,185@9508L29,187@9621L39,193@9796L10,194@9874L19,188@9665L543:Chip.kt#uh7d8r");
        int $dirty3 = $changed;
        int $dirty13 = $changed1;
        if ((i11 & 1) != 0) {
            $dirty3 |= 6;
        } else if ((i10 & 14) == 0) {
            $dirty3 |= $composer3.changed((Object) function0) ? 4 : 2;
        }
        if ((i11 & 2) != 0) {
            $dirty3 |= 48;
        } else if ((i10 & 112) == 0) {
            $dirty3 |= $composer3.changed((Object) function2) ? 32 : 16;
        }
        int i12 = i11 & 4;
        if (i12 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if ((i10 & 896) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed((Object) modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i13 = i11 & 8;
        if (i13 != 0) {
            $dirty3 |= 3072;
            z = enabled;
        } else if ((i10 & 7168) == 0) {
            z = enabled;
            $dirty3 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i14 = i11 & 16;
        if (i14 != 0) {
            $dirty3 |= 24576;
            Function2<? super Composer, ? super Integer, Unit> function22 = leadingIcon;
        } else if ((i10 & 57344) == 0) {
            $dirty3 |= $composer3.changed((Object) leadingIcon) ? 16384 : 8192;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = leadingIcon;
        }
        int i15 = i11 & 32;
        if (i15 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            Function2<? super Composer, ? super Integer, Unit> function24 = trailingIcon;
        } else if ((i10 & 458752) == 0) {
            $dirty3 |= $composer3.changed((Object) trailingIcon) ? 131072 : 65536;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function25 = trailingIcon;
        }
        if ((i10 & 3670016) == 0) {
            if ((i11 & 64) != 0) {
                Shape shape3 = shape;
            } else if ($composer3.changed((Object) shape)) {
                i9 = 1048576;
                $dirty3 |= i9;
            }
            i9 = 524288;
            $dirty3 |= i9;
        } else {
            Shape shape4 = shape;
        }
        if ((i10 & 29360128) == 0) {
            if ((i11 & 128) == 0) {
                chipColors = colors;
                if ($composer3.changed((Object) chipColors)) {
                    i8 = 8388608;
                    $dirty3 |= i8;
                }
            } else {
                chipColors = colors;
            }
            i8 = 4194304;
            $dirty3 |= i8;
        } else {
            chipColors = colors;
        }
        if ((i10 & 234881024) == 0) {
            if ((i11 & 256) != 0) {
                ChipElevation chipElevation = elevation;
            } else if ($composer3.changed((Object) elevation)) {
                i7 = 67108864;
                $dirty3 |= i7;
            }
            i7 = 33554432;
            $dirty3 |= i7;
        } else {
            ChipElevation chipElevation2 = elevation;
        }
        int i16 = i11 & 512;
        if (i16 != 0) {
            $dirty3 |= 805306368;
            i2 = i16;
            ChipBorder chipBorder = border;
        } else if ((i10 & 1879048192) == 0) {
            i2 = i16;
            $dirty3 |= $composer3.changed((Object) border) ? 536870912 : 268435456;
        } else {
            i2 = i16;
            ChipBorder chipBorder2 = border;
        }
        int i17 = i11 & 1024;
        if (i17 != 0) {
            $dirty13 |= 6;
            i3 = i17;
            mutableInteractionSource = interactionSource;
        } else if (($changed1 & 14) == 0) {
            i3 = i17;
            mutableInteractionSource = interactionSource;
            $dirty13 |= $composer3.changed((Object) mutableInteractionSource) ? 4 : 2;
        } else {
            i3 = i17;
            mutableInteractionSource = interactionSource;
        }
        if (($dirty3 & 1533916891) == 306783378 && ($dirty13 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            leadingIcon2 = leadingIcon;
            trailingIcon2 = trailingIcon;
            shape2 = shape;
            elevation2 = elevation;
            border2 = border;
            int i18 = $dirty3;
            int i19 = $dirty13;
            colors2 = chipColors;
            modifier3 = modifier2;
            enabled2 = z;
            interactionSource2 = mutableInteractionSource;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if ((i10 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i12 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i13 != 0) {
                    enabled4 = true;
                } else {
                    enabled4 = z;
                }
                if (i14 != 0) {
                    leadingIcon2 = null;
                } else {
                    leadingIcon2 = leadingIcon;
                }
                if (i15 != 0) {
                    trailingIcon2 = null;
                } else {
                    trailingIcon2 = trailingIcon;
                }
                if ((i11 & 64) != 0) {
                    $dirty3 &= -3670017;
                    shape2 = AssistChipDefaults.INSTANCE.getShape($composer3, 6);
                } else {
                    shape2 = shape;
                }
                if ((i11 & 128) != 0) {
                    $dirty2 = $dirty3 & -29360129;
                    colors4 = AssistChipDefaults.INSTANCE.m1755elevatedAssistChipColorsoq7We08(0, 0, 0, 0, 0, 0, 0, 0, $composer3, 100663296, 255);
                } else {
                    $dirty2 = $dirty3;
                    colors4 = chipColors;
                }
                if ((i11 & 256) != 0) {
                    $dirty1 = $dirty13;
                    modifier5 = modifier4;
                    i4 = 6;
                    i6 = i2;
                    i5 = i3;
                    elevation3 = AssistChipDefaults.INSTANCE.m1756elevatedAssistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                    $dirty2 &= -234881025;
                } else {
                    modifier5 = modifier4;
                    $dirty1 = $dirty13;
                    i4 = 6;
                    i6 = i2;
                    i5 = i3;
                    elevation3 = elevation;
                }
                if (i6 != 0) {
                    border4 = null;
                } else {
                    border4 = border;
                }
                if (i5 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        mutableInteractionSource2 = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource2);
                    } else {
                        mutableInteractionSource2 = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    modifier3 = modifier5;
                    elevation2 = elevation3;
                    border3 = border4;
                    interactionSource2 = mutableInteractionSource2;
                    colors3 = colors4;
                    $dirty = $dirty2;
                    enabled3 = enabled4;
                } else {
                    modifier3 = modifier5;
                    interactionSource2 = interactionSource;
                    elevation2 = elevation3;
                    border3 = border4;
                    colors3 = colors4;
                    $dirty = $dirty2;
                    enabled3 = enabled4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i11 & 64) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i11 & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                if ((i11 & 256) != 0) {
                    leadingIcon2 = leadingIcon;
                    trailingIcon2 = trailingIcon;
                    shape2 = shape;
                    elevation2 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty = -234881025 & $dirty3;
                    $dirty1 = $dirty13;
                    colors3 = chipColors;
                    modifier3 = modifier2;
                    i4 = 6;
                    enabled3 = z;
                    border3 = border;
                } else {
                    leadingIcon2 = leadingIcon;
                    trailingIcon2 = trailingIcon;
                    shape2 = shape;
                    elevation2 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty3;
                    $dirty1 = $dirty13;
                    colors3 = chipColors;
                    modifier3 = modifier2;
                    i4 = 6;
                    enabled3 = z;
                    border3 = border;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                $dirty12 = $dirty1;
                ComposerKt.traceEventStart(1295844802, $dirty, $dirty12, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:176)");
            } else {
                $dirty12 = $dirty1;
            }
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, i4), AssistChipTokens.INSTANCE.getLabelTextFont());
            long r22 = colors3.labelColor$material3_release(enabled3, $composer3, (($dirty >> 9) & 14) | (($dirty >> 18) & 112)).getValue().m3174unboximpl();
            float r16 = AssistChipDefaults.INSTANCE.m1757getHeightD9Ej5fM();
            PaddingValues paddingValues = AssistChipPadding;
            $composer3.startReplaceableGroup(-227039467);
            ComposerKt.sourceInformation($composer3, "202@10135L21");
            State<BorderStroke> borderStroke$material3_release = border3 == null ? null : border3.borderStroke$material3_release(enabled3, $composer3, (($dirty >> 9) & 14) | (($dirty >> 24) & 112));
            $composer3.endReplaceableGroup();
            int i20 = (($dirty >> 24) & 14) | 3456 | (($dirty12 << 12) & 57344);
            int i21 = $dirty12;
            long j = r22;
            int i22 = $dirty;
            border2 = border3;
            colors2 = colors3;
            enabled2 = enabled3;
            $composer2 = $composer3;
            m1785ChipnkUnTEs(modifier3, onClick, enabled3, label, fromToken, j, leadingIcon2, trailingIcon2, shape2, colors2, elevation2, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, r16, paddingValues, interactionSource2, $composer2, (($dirty >> 6) & 14) | (($dirty << 3) & 112) | (($dirty >> 3) & 896) | (($dirty << 6) & 7168) | (($dirty << 6) & 3670016) | (($dirty << 6) & 29360128) | (($dirty << 6) & 234881024) | (($dirty << 6) & 1879048192), i20);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipKt$ElevatedAssistChip$2(onClick, label, modifier3, enabled2, leadingIcon2, trailingIcon2, shape2, colors2, elevation2, border2, interactionSource2, $changed, $changed1, i));
        }
    }

    @ExperimentalMaterial3Api
    public static final void FilterChip(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, SelectableChipColors colors, SelectableChipElevation elevation, SelectableChipBorder border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1, int i) {
        Modifier modifier2;
        boolean z;
        Function2 function2;
        Function2 function22;
        int i2;
        int $dirty1;
        MutableInteractionSource mutableInteractionSource;
        Shape shape2;
        Function2 trailingIcon2;
        Function2 leadingIcon2;
        boolean enabled2;
        SelectableChipColors colors2;
        Composer $composer2;
        SelectableChipBorder border2;
        MutableInteractionSource interactionSource2;
        SelectableChipElevation elevation2;
        Modifier modifier3;
        boolean enabled3;
        SelectableChipBorder border3;
        int $dirty;
        int $dirty12;
        Modifier modifier4;
        boolean enabled4;
        int $dirty2;
        Composer $composer3;
        int i3;
        int $dirty3;
        SelectableChipElevation elevation3;
        SelectableChipBorder border4;
        Object value$iv$iv;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z2 = selected;
        Function0<Unit> function0 = onClick;
        Function2<? super Composer, ? super Integer, Unit> function23 = label;
        int i8 = $changed;
        int i9 = i;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function23, "label");
        Composer $composer4 = $composer.startRestartGroup(-1878072905);
        ComposerKt.sourceInformation($composer4, "C(FilterChip)P(9,8,5,7,3,6,11,10,1,2)265@13531L5,266@13592L18,267@13673L21,268@13751L18,269@13821L39,276@14031L10,270@13865L556:Chip.kt#uh7d8r");
        int $dirty4 = $changed;
        int $dirty13 = $changed1;
        if ((i9 & 1) != 0) {
            $dirty4 |= 6;
        } else if ((i8 & 14) == 0) {
            $dirty4 |= $composer4.changed(z2) ? 4 : 2;
        }
        if ((i9 & 2) != 0) {
            $dirty4 |= 48;
        } else if ((i8 & 112) == 0) {
            $dirty4 |= $composer4.changed((Object) function0) ? 32 : 16;
        }
        if ((i9 & 4) != 0) {
            $dirty4 |= 384;
        } else if ((i8 & 896) == 0) {
            $dirty4 |= $composer4.changed((Object) function23) ? 256 : 128;
        }
        int i10 = i9 & 8;
        if (i10 != 0) {
            $dirty4 |= 3072;
            modifier2 = modifier;
        } else if ((i8 & 7168) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer4.changed((Object) modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i11 = i9 & 16;
        if (i11 != 0) {
            $dirty4 |= 24576;
            z = enabled;
        } else if ((i8 & 57344) == 0) {
            z = enabled;
            $dirty4 |= $composer4.changed(z) ? 16384 : 8192;
        } else {
            z = enabled;
        }
        int i12 = i9 & 32;
        if (i12 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function2 = leadingIcon;
        } else if ((i8 & 458752) == 0) {
            function2 = leadingIcon;
            $dirty4 |= $composer4.changed((Object) function2) ? 131072 : 65536;
        } else {
            function2 = leadingIcon;
        }
        int i13 = i9 & 64;
        if (i13 != 0) {
            $dirty4 |= 1572864;
            function22 = trailingIcon;
        } else if ((i8 & 3670016) == 0) {
            function22 = trailingIcon;
            $dirty4 |= $composer4.changed((Object) function22) ? 1048576 : 524288;
        } else {
            function22 = trailingIcon;
        }
        if ((i8 & 29360128) == 0) {
            if ((i9 & 128) != 0) {
                Shape shape3 = shape;
            } else if ($composer4.changed((Object) shape)) {
                i7 = 8388608;
                $dirty4 |= i7;
            }
            i7 = 4194304;
            $dirty4 |= i7;
        } else {
            Shape shape4 = shape;
        }
        if ((i8 & 234881024) == 0) {
            if ((i9 & 256) != 0) {
                SelectableChipColors selectableChipColors = colors;
            } else if ($composer4.changed((Object) colors)) {
                i6 = 67108864;
                $dirty4 |= i6;
            }
            i6 = 33554432;
            $dirty4 |= i6;
        } else {
            SelectableChipColors selectableChipColors2 = colors;
        }
        if ((i8 & 1879048192) == 0) {
            if ((i9 & 512) != 0) {
                SelectableChipElevation selectableChipElevation = elevation;
            } else if ($composer4.changed((Object) elevation)) {
                i5 = 536870912;
                $dirty4 |= i5;
            }
            i5 = 268435456;
            $dirty4 |= i5;
        } else {
            SelectableChipElevation selectableChipElevation2 = elevation;
        }
        if (($changed1 & 14) == 0) {
            if ((i9 & 1024) != 0) {
                SelectableChipBorder selectableChipBorder = border;
            } else if ($composer4.changed((Object) border)) {
                i4 = 4;
                $dirty13 |= i4;
            }
            i4 = 2;
            $dirty13 |= i4;
        } else {
            SelectableChipBorder selectableChipBorder2 = border;
        }
        int i14 = i9 & 2048;
        if (i14 != 0) {
            $dirty1 = $dirty13 | 48;
            i2 = i14;
            mutableInteractionSource = interactionSource;
        } else {
            if (($changed1 & 112) == 0) {
                i2 = i14;
                mutableInteractionSource = interactionSource;
                $dirty13 |= $composer4.changed((Object) mutableInteractionSource) ? 32 : 16;
            } else {
                i2 = i14;
                mutableInteractionSource = interactionSource;
            }
            $dirty1 = $dirty13;
        }
        if ((1533916891 & $dirty4) == 306783378 && ($dirty1 & 91) == 18 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            shape2 = shape;
            colors2 = colors;
            elevation2 = elevation;
            border2 = border;
            int i15 = $dirty4;
            enabled2 = z;
            leadingIcon2 = function2;
            trailingIcon2 = function22;
            interactionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            $composer2 = $composer4;
        } else {
            $composer4.startDefaults();
            if ((i8 & 1) == 0 || $composer4.getDefaultsInvalid()) {
                if (i10 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i11 != 0) {
                    enabled4 = true;
                } else {
                    enabled4 = z;
                }
                if (i12 != 0) {
                    leadingIcon2 = null;
                } else {
                    leadingIcon2 = function2;
                }
                if (i13 != 0) {
                    trailingIcon2 = null;
                } else {
                    trailingIcon2 = function22;
                }
                if ((i9 & 128) != 0) {
                    $dirty4 &= -29360129;
                    shape2 = FilterChipDefaults.INSTANCE.getShape($composer4, 6);
                } else {
                    shape2 = shape;
                }
                if ((i9 & 256) != 0) {
                    $dirty2 = $dirty4 & -234881025;
                    colors2 = FilterChipDefaults.INSTANCE.m1934filterChipColorsXqyqHi0(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer4, 0, 384, 4095);
                } else {
                    colors2 = colors;
                    $dirty2 = $dirty4;
                }
                if ((i9 & 512) != 0) {
                    i3 = i2;
                    $composer3 = $composer4;
                    elevation3 = FilterChipDefaults.INSTANCE.m1935filterChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer4, 1572864, 63);
                    $dirty3 = $dirty2 & -1879048193;
                } else {
                    i3 = i2;
                    $composer3 = $composer4;
                    elevation3 = elevation;
                    $dirty3 = $dirty2;
                }
                if ((i9 & 1024) != 0) {
                    border4 = FilterChipDefaults.INSTANCE.m1933filterChipBordergHcDVlo(0, 0, 0, 0, 0.0f, 0.0f, $composer3, 1572864, 63);
                    $dirty1 &= -15;
                } else {
                    border4 = border;
                }
                if (i3 != 0) {
                    $composer4 = $composer3;
                    $composer4.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer4, "C(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer4;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    Modifier modifier5 = modifier4;
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer4.endReplaceableGroup();
                    modifier3 = modifier5;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    elevation2 = elevation3;
                    $dirty = $dirty3;
                    border3 = border4;
                    $dirty12 = $dirty1;
                    enabled3 = enabled4;
                } else {
                    $composer4 = $composer3;
                    modifier3 = modifier4;
                    interactionSource2 = interactionSource;
                    elevation2 = elevation3;
                    $dirty = $dirty3;
                    border3 = border4;
                    $dirty12 = $dirty1;
                    enabled3 = enabled4;
                }
            } else {
                $composer4.skipToGroupEnd();
                if ((i9 & 128) != 0) {
                    $dirty4 &= -29360129;
                }
                if ((i9 & 256) != 0) {
                    $dirty4 &= -234881025;
                }
                if ((i9 & 512) != 0) {
                    $dirty4 &= -1879048193;
                }
                if ((i9 & 1024) != 0) {
                    $dirty1 &= -15;
                }
                shape2 = shape;
                colors2 = colors;
                elevation2 = elevation;
                enabled3 = z;
                leadingIcon2 = function2;
                trailingIcon2 = function22;
                interactionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                $dirty12 = $dirty1;
                border3 = border;
                $dirty = $dirty4;
            }
            $composer4.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1878072905, $dirty, $dirty12, "androidx.compose.material3.FilterChip (Chip.kt:257)");
            }
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer4, 6), FilterChipTokens.INSTANCE.getLabelTextFont());
            float r22 = FilterChipDefaults.INSTANCE.m1936getHeightD9Ej5fM();
            PaddingValues paddingValues = FilterChipPadding;
            $composer4.startReplaceableGroup(276171483);
            ComposerKt.sourceInformation($composer4, "285@14338L31");
            State<BorderStroke> borderStroke$material3_release = border3 == null ? null : border3.borderStroke$material3_release(enabled3, z2, $composer4, (($dirty >> 12) & 14) | (($dirty << 3) & 112) | (($dirty12 << 6) & 896));
            $composer4.endReplaceableGroup();
            int i16 = $dirty12;
            int i17 = $dirty;
            border2 = border3;
            enabled2 = enabled3;
            $composer2 = $composer4;
            m1787SelectableChipu0RnIRE(selected, modifier3, onClick, enabled3, label, fromToken, leadingIcon2, (Function2<? super Composer, ? super Integer, Unit>) null, trailingIcon2, shape2, colors2, elevation2, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, r22, paddingValues, interactionSource2, $composer2, ($dirty & 14) | 12582912 | (($dirty >> 6) & 112) | (($dirty << 3) & 896) | (($dirty >> 3) & 7168) | (($dirty << 6) & 57344) | (($dirty << 3) & 3670016) | (($dirty << 6) & 234881024) | (($dirty << 6) & 1879048192), (($dirty >> 24) & 14) | 27648 | (($dirty >> 24) & 112) | (($dirty12 << 12) & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipKt$FilterChip$2(selected, onClick, label, modifier3, enabled2, leadingIcon2, trailingIcon2, shape2, colors2, elevation2, border2, interactionSource2, $changed, $changed1, i));
        }
    }

    @ExperimentalMaterial3Api
    public static final void ElevatedFilterChip(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, SelectableChipColors colors, SelectableChipElevation elevation, SelectableChipBorder border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1, int i) {
        Modifier modifier2;
        Function2 function2;
        Function2 function22;
        int i2;
        int i3;
        MutableInteractionSource mutableInteractionSource;
        Shape shape2;
        Function2 trailingIcon2;
        Function2 leadingIcon2;
        boolean enabled2;
        SelectableChipBorder border2;
        Composer $composer2;
        MutableInteractionSource interactionSource2;
        SelectableChipElevation elevation2;
        SelectableChipColors colors2;
        Modifier modifier3;
        int $dirty1;
        Composer $composer3;
        boolean enabled3;
        SelectableChipBorder border3;
        int $dirty;
        int $dirty12;
        Modifier modifier4;
        boolean enabled4;
        int $dirty2;
        SelectableChipColors colors3;
        int i4;
        int i5;
        SelectableChipElevation elevation3;
        SelectableChipBorder border4;
        MutableInteractionSource mutableInteractionSource2;
        int i6;
        int i7;
        int i8;
        boolean z = selected;
        Function0<Unit> function0 = onClick;
        Function2<? super Composer, ? super Integer, Unit> function23 = label;
        int i9 = $changed;
        int i10 = i;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function23, "label");
        Composer $composer4 = $composer.startRestartGroup(1904578605);
        ComposerKt.sourceInformation($composer4, "C(ElevatedFilterChip)P(9,8,5,7,3,6,11,10,1,2)345@17629L5,346@17690L26,347@17779L29,349@17902L39,356@18112L10,350@17946L556:Chip.kt#uh7d8r");
        int $dirty3 = $changed;
        int $dirty13 = $changed1;
        if ((i10 & 1) != 0) {
            $dirty3 |= 6;
        } else if ((i9 & 14) == 0) {
            $dirty3 |= $composer4.changed(z) ? 4 : 2;
        }
        if ((i10 & 2) != 0) {
            $dirty3 |= 48;
        } else if ((i9 & 112) == 0) {
            $dirty3 |= $composer4.changed((Object) function0) ? 32 : 16;
        }
        if ((i10 & 4) != 0) {
            $dirty3 |= 384;
        } else if ((i9 & 896) == 0) {
            $dirty3 |= $composer4.changed((Object) function23) ? 256 : 128;
        }
        int i11 = i10 & 8;
        if (i11 != 0) {
            $dirty3 |= 3072;
            modifier2 = modifier;
        } else if ((i9 & 7168) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer4.changed((Object) modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i12 = i10 & 16;
        if (i12 != 0) {
            $dirty3 |= 24576;
            boolean z2 = enabled;
        } else if ((i9 & 57344) == 0) {
            $dirty3 |= $composer4.changed(enabled) ? 16384 : 8192;
        } else {
            boolean z3 = enabled;
        }
        int i13 = i10 & 32;
        if (i13 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function2 = leadingIcon;
        } else if ((i9 & 458752) == 0) {
            function2 = leadingIcon;
            $dirty3 |= $composer4.changed((Object) function2) ? 131072 : 65536;
        } else {
            function2 = leadingIcon;
        }
        int i14 = i10 & 64;
        if (i14 != 0) {
            $dirty3 |= 1572864;
            function22 = trailingIcon;
        } else if ((i9 & 3670016) == 0) {
            function22 = trailingIcon;
            $dirty3 |= $composer4.changed((Object) function22) ? 1048576 : 524288;
        } else {
            function22 = trailingIcon;
        }
        if ((i9 & 29360128) == 0) {
            if ((i10 & 128) != 0) {
                Shape shape3 = shape;
            } else if ($composer4.changed((Object) shape)) {
                i8 = 8388608;
                $dirty3 |= i8;
            }
            i8 = 4194304;
            $dirty3 |= i8;
        } else {
            Shape shape4 = shape;
        }
        if ((i9 & 234881024) == 0) {
            if ((i10 & 256) != 0) {
                SelectableChipColors selectableChipColors = colors;
            } else if ($composer4.changed((Object) colors)) {
                i7 = 67108864;
                $dirty3 |= i7;
            }
            i7 = 33554432;
            $dirty3 |= i7;
        } else {
            SelectableChipColors selectableChipColors2 = colors;
        }
        if ((i9 & 1879048192) == 0) {
            if ((i10 & 512) != 0) {
                SelectableChipElevation selectableChipElevation = elevation;
            } else if ($composer4.changed((Object) elevation)) {
                i6 = 536870912;
                $dirty3 |= i6;
            }
            i6 = 268435456;
            $dirty3 |= i6;
        } else {
            SelectableChipElevation selectableChipElevation2 = elevation;
        }
        int i15 = i10 & 1024;
        if (i15 != 0) {
            $dirty13 |= 6;
            i2 = i15;
            SelectableChipBorder selectableChipBorder = border;
        } else if (($changed1 & 14) == 0) {
            i2 = i15;
            $dirty13 |= $composer4.changed((Object) border) ? 4 : 2;
        } else {
            i2 = i15;
            SelectableChipBorder selectableChipBorder2 = border;
        }
        int i16 = i10 & 2048;
        if (i16 != 0) {
            $dirty13 |= 48;
            i3 = i16;
            mutableInteractionSource = interactionSource;
        } else if (($changed1 & 112) == 0) {
            i3 = i16;
            mutableInteractionSource = interactionSource;
            $dirty13 |= $composer4.changed((Object) mutableInteractionSource) ? 32 : 16;
        } else {
            i3 = i16;
            mutableInteractionSource = interactionSource;
        }
        if (($dirty3 & 1533916891) == 306783378 && ($dirty13 & 91) == 18 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            enabled2 = enabled;
            shape2 = shape;
            colors2 = colors;
            elevation2 = elevation;
            border2 = border;
            int i17 = $dirty3;
            int i18 = $dirty13;
            leadingIcon2 = function2;
            trailingIcon2 = function22;
            interactionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            $composer2 = $composer4;
        } else {
            $composer4.startDefaults();
            if ((i9 & 1) == 0 || $composer4.getDefaultsInvalid()) {
                if (i11 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i12 != 0) {
                    enabled4 = true;
                } else {
                    enabled4 = enabled;
                }
                if (i13 != 0) {
                    leadingIcon2 = null;
                } else {
                    leadingIcon2 = function2;
                }
                if (i14 != 0) {
                    trailingIcon2 = null;
                } else {
                    trailingIcon2 = function22;
                }
                if ((i10 & 128) != 0) {
                    $dirty3 &= -29360129;
                    shape2 = FilterChipDefaults.INSTANCE.getShape($composer4, 6);
                } else {
                    shape2 = shape;
                }
                if ((i10 & 256) != 0) {
                    $dirty2 = $dirty3 & -234881025;
                    colors3 = FilterChipDefaults.INSTANCE.m1931elevatedFilterChipColorsXqyqHi0(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer4, 0, 384, 4095);
                } else {
                    colors3 = colors;
                    $dirty2 = $dirty3;
                }
                if ((i10 & 512) != 0) {
                    $dirty1 = $dirty13;
                    i4 = i3;
                    i5 = i2;
                    $composer3 = $composer4;
                    elevation3 = FilterChipDefaults.INSTANCE.m1932elevatedFilterChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer4, 1572864, 63);
                    $dirty2 &= -1879048193;
                } else {
                    i4 = i3;
                    $dirty1 = $dirty13;
                    $composer3 = $composer4;
                    i5 = i2;
                    elevation3 = elevation;
                }
                if (i5 != 0) {
                    border4 = null;
                } else {
                    border4 = border;
                }
                if (i4 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        mutableInteractionSource2 = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource2);
                    } else {
                        mutableInteractionSource2 = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    modifier3 = modifier4;
                    elevation2 = elevation3;
                    border3 = border4;
                    interactionSource2 = mutableInteractionSource2;
                    colors2 = colors3;
                    $dirty = $dirty2;
                    enabled3 = enabled4;
                } else {
                    interactionSource2 = interactionSource;
                    modifier3 = modifier4;
                    elevation2 = elevation3;
                    border3 = border4;
                    colors2 = colors3;
                    $dirty = $dirty2;
                    enabled3 = enabled4;
                }
            } else {
                $composer4.skipToGroupEnd();
                if ((i10 & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                if ((i10 & 256) != 0) {
                    $dirty3 &= -234881025;
                }
                if ((i10 & 512) != 0) {
                    shape2 = shape;
                    colors2 = colors;
                    elevation2 = elevation;
                    border3 = border;
                    $dirty1 = $dirty13;
                    leadingIcon2 = function2;
                    trailingIcon2 = function22;
                    interactionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    $composer3 = $composer4;
                    enabled3 = enabled;
                    $dirty = -1879048193 & $dirty3;
                } else {
                    shape2 = shape;
                    colors2 = colors;
                    elevation2 = elevation;
                    border3 = border;
                    $dirty1 = $dirty13;
                    leadingIcon2 = function2;
                    trailingIcon2 = function22;
                    interactionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    $composer3 = $composer4;
                    enabled3 = enabled;
                    $dirty = $dirty3;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                $dirty12 = $dirty1;
                ComposerKt.traceEventStart(1904578605, $dirty, $dirty12, "androidx.compose.material3.ElevatedFilterChip (Chip.kt:337)");
            } else {
                $dirty12 = $dirty1;
            }
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), FilterChipTokens.INSTANCE.getLabelTextFont());
            float r16 = FilterChipDefaults.INSTANCE.m1936getHeightD9Ej5fM();
            PaddingValues paddingValues = FilterChipPadding;
            $composer3.startReplaceableGroup(-790769726);
            ComposerKt.sourceInformation($composer3, "365@18419L31");
            State<BorderStroke> borderStroke$material3_release = border3 == null ? null : border3.borderStroke$material3_release(enabled3, z, $composer3, (($dirty >> 12) & 14) | (($dirty << 3) & 112) | (($dirty12 << 6) & 896));
            $composer3.endReplaceableGroup();
            int i19 = $dirty12;
            int i20 = $dirty;
            border2 = border3;
            enabled2 = enabled3;
            $composer2 = $composer3;
            m1787SelectableChipu0RnIRE(selected, modifier3, onClick, enabled3, label, fromToken, leadingIcon2, (Function2<? super Composer, ? super Integer, Unit>) null, trailingIcon2, shape2, colors2, elevation2, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, r16, paddingValues, interactionSource2, $composer2, ($dirty & 14) | 12582912 | (($dirty >> 6) & 112) | (($dirty << 3) & 896) | (($dirty >> 3) & 7168) | (($dirty << 6) & 57344) | (($dirty << 3) & 3670016) | (($dirty << 6) & 234881024) | (($dirty << 6) & 1879048192), (($dirty >> 24) & 14) | 27648 | (($dirty >> 24) & 112) | (($dirty12 << 12) & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipKt$ElevatedFilterChip$2(selected, onClick, label, modifier3, enabled2, leadingIcon2, trailingIcon2, shape2, colors2, elevation2, border2, interactionSource2, $changed, $changed1, i));
        }
    }

    @ExperimentalMaterial3Api
    public static final void InputChip(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> avatar, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, SelectableChipColors colors, SelectableChipElevation elevation, SelectableChipBorder border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1, int i) {
        Function2 leadingIcon2;
        Function2 avatar2;
        Composer $composer2;
        boolean enabled2;
        Function2 avatar3;
        SelectableChipBorder border2;
        MutableInteractionSource interactionSource2;
        SelectableChipElevation elevation2;
        SelectableChipColors colors2;
        Shape shape2;
        Function2 trailingIcon2;
        Function2 leadingIcon3;
        Modifier modifier2;
        boolean enabled3;
        Function2 leadingIcon4;
        SelectableChipBorder border3;
        int $dirty;
        int $dirty1;
        Function2 shapedAvatar;
        boolean z;
        Modifier modifier3;
        boolean enabled4;
        Function2 trailingIcon3;
        Modifier modifier4;
        Shape shape3;
        SelectableChipColors colors3;
        SelectableChipElevation elevation3;
        SelectableChipBorder border4;
        Object value$iv$iv;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z2 = selected;
        Function0<Unit> function0 = onClick;
        Function2<? super Composer, ? super Integer, Unit> function2 = label;
        int i6 = $changed;
        int i7 = $changed1;
        int i8 = i;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function2, "label");
        Composer $composer3 = $composer.startRestartGroup(-1599030387);
        ComposerKt.sourceInformation($composer3, "C(InputChip)P(10,9,6,8,4,7!1,12,11,2,3)430@21857L5,431@21917L17,432@21996L20,433@22072L17,434@22141L39,461@23112L10,468@23372L31,455@22922L787:Chip.kt#uh7d8r");
        int $dirty2 = $changed;
        int $dirty12 = $changed1;
        if ((i8 & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i6 & 14) == 0) {
            $dirty2 |= $composer3.changed(z2) ? 4 : 2;
        }
        if ((i8 & 2) != 0) {
            $dirty2 |= 48;
        } else if ((i6 & 112) == 0) {
            $dirty2 |= $composer3.changed((Object) function0) ? 32 : 16;
        }
        int i9 = 256;
        if ((i8 & 4) != 0) {
            $dirty2 |= 384;
        } else if ((i6 & 896) == 0) {
            $dirty2 |= $composer3.changed((Object) function2) ? 256 : 128;
        }
        int i10 = i8 & 8;
        if (i10 != 0) {
            $dirty2 |= 3072;
            Modifier modifier5 = modifier;
        } else if ((i6 & 7168) == 0) {
            $dirty2 |= $composer3.changed((Object) modifier) ? 2048 : 1024;
        } else {
            Modifier modifier6 = modifier;
        }
        int i11 = i8 & 16;
        if (i11 != 0) {
            $dirty2 |= 24576;
            boolean z3 = enabled;
        } else if ((i6 & 57344) == 0) {
            $dirty2 |= $composer3.changed(enabled) ? 16384 : 8192;
        } else {
            boolean z4 = enabled;
        }
        int i12 = i8 & 32;
        if (i12 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            leadingIcon2 = leadingIcon;
        } else if ((i6 & 458752) == 0) {
            leadingIcon2 = leadingIcon;
            $dirty2 |= $composer3.changed((Object) leadingIcon2) ? 131072 : 65536;
        } else {
            leadingIcon2 = leadingIcon;
        }
        int i13 = i8 & 64;
        if (i13 != 0) {
            $dirty2 |= 1572864;
            avatar2 = avatar;
        } else if ((i6 & 3670016) == 0) {
            avatar2 = avatar;
            $dirty2 |= $composer3.changed((Object) avatar2) ? 1048576 : 524288;
        } else {
            avatar2 = avatar;
        }
        int i14 = i8 & 128;
        if (i14 != 0) {
            $dirty2 |= 12582912;
            Function2<? super Composer, ? super Integer, Unit> function22 = trailingIcon;
        } else if ((i6 & 29360128) == 0) {
            $dirty2 |= $composer3.changed((Object) trailingIcon) ? 8388608 : 4194304;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = trailingIcon;
        }
        if ((i6 & 234881024) == 0) {
            if ((i8 & 256) != 0) {
                Shape shape4 = shape;
            } else if ($composer3.changed((Object) shape)) {
                i5 = 67108864;
                $dirty2 |= i5;
            }
            i5 = 33554432;
            $dirty2 |= i5;
        } else {
            Shape shape5 = shape;
        }
        if ((i6 & 1879048192) == 0) {
            if ((i8 & 512) != 0) {
                SelectableChipColors selectableChipColors = colors;
            } else if ($composer3.changed((Object) colors)) {
                i4 = 536870912;
                $dirty2 |= i4;
            }
            i4 = 268435456;
            $dirty2 |= i4;
        } else {
            SelectableChipColors selectableChipColors2 = colors;
        }
        if ((i7 & 14) == 0) {
            if ((i8 & 1024) != 0) {
                SelectableChipElevation selectableChipElevation = elevation;
            } else if ($composer3.changed((Object) elevation)) {
                i3 = 4;
                $dirty12 |= i3;
            }
            i3 = 2;
            $dirty12 |= i3;
        } else {
            SelectableChipElevation selectableChipElevation2 = elevation;
        }
        if ((i7 & 112) == 0) {
            if ((i8 & 2048) != 0) {
                SelectableChipBorder selectableChipBorder = border;
            } else if ($composer3.changed((Object) border)) {
                i2 = 32;
                $dirty12 |= i2;
            }
            i2 = 16;
            $dirty12 |= i2;
        } else {
            SelectableChipBorder selectableChipBorder2 = border;
        }
        int i15 = i8 & 4096;
        if (i15 != 0) {
            $dirty12 |= 384;
            MutableInteractionSource mutableInteractionSource = interactionSource;
        } else if ((i7 & 896) == 0) {
            if (!$composer3.changed((Object) interactionSource)) {
                i9 = 128;
            }
            $dirty12 |= i9;
        } else {
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
        }
        if (($dirty2 & 1533916891) == 306783378 && ($dirty12 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            enabled2 = enabled;
            trailingIcon2 = trailingIcon;
            shape2 = shape;
            colors2 = colors;
            elevation2 = elevation;
            border2 = border;
            interactionSource2 = interactionSource;
            int i16 = $dirty2;
            int i17 = $dirty12;
            leadingIcon3 = leadingIcon2;
            avatar3 = avatar2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if ((i6 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i11 != 0) {
                    enabled4 = true;
                } else {
                    enabled4 = enabled;
                }
                if (i12 != 0) {
                    leadingIcon2 = null;
                }
                if (i13 != 0) {
                    avatar2 = null;
                }
                if (i14 != 0) {
                    trailingIcon3 = null;
                } else {
                    trailingIcon3 = trailingIcon;
                }
                if ((i8 & 256) != 0) {
                    modifier4 = modifier3;
                    shape3 = InputChipDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty2 &= -234881025;
                } else {
                    modifier4 = modifier3;
                    shape3 = shape;
                }
                if ((i8 & 512) != 0) {
                    colors3 = InputChipDefaults.INSTANCE.m1967inputChipColorskwJvTHA(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer3, 0, 3072, 8191);
                    $dirty2 &= -1879048193;
                } else {
                    colors3 = colors;
                }
                int $dirty3 = $dirty2;
                if ((i8 & 1024) != 0) {
                    elevation3 = InputChipDefaults.INSTANCE.m1968inputChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                    $dirty12 &= -15;
                } else {
                    elevation3 = elevation;
                }
                SelectableChipElevation elevation4 = elevation3;
                if ((i8 & 2048) != 0) {
                    border4 = InputChipDefaults.INSTANCE.m1966inputChipBordergHcDVlo(0, 0, 0, 0, 0.0f, 0.0f, $composer3, 1572864, 63);
                    $dirty12 &= -113;
                } else {
                    border4 = border;
                }
                if (i15 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    SelectableChipBorder border5 = border4;
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        Object obj = it$iv$iv;
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        Object obj2 = it$iv$iv;
                        Object it$iv$iv2 = $this$cache$iv$iv;
                        value$iv$iv = obj2;
                    }
                    $composer3.endReplaceableGroup();
                    modifier2 = modifier4;
                    elevation2 = elevation4;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    colors2 = colors3;
                    shape2 = shape3;
                    leadingIcon3 = leadingIcon2;
                    leadingIcon4 = avatar2;
                    trailingIcon2 = trailingIcon3;
                    border3 = border5;
                    $dirty1 = $dirty12;
                    enabled3 = enabled4;
                    $dirty = $dirty3;
                } else {
                    modifier2 = modifier4;
                    elevation2 = elevation4;
                    interactionSource2 = interactionSource;
                    colors2 = colors3;
                    shape2 = shape3;
                    leadingIcon3 = leadingIcon2;
                    leadingIcon4 = avatar2;
                    trailingIcon2 = trailingIcon3;
                    border3 = border4;
                    $dirty1 = $dirty12;
                    enabled3 = enabled4;
                    $dirty = $dirty3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i8 & 256) != 0) {
                    $dirty2 &= -234881025;
                }
                if ((i8 & 512) != 0) {
                    $dirty2 &= -1879048193;
                }
                if ((i8 & 1024) != 0) {
                    $dirty12 &= -15;
                }
                if ((i8 & 2048) != 0) {
                    modifier2 = modifier;
                    trailingIcon2 = trailingIcon;
                    shape2 = shape;
                    colors2 = colors;
                    elevation2 = elevation;
                    border3 = border;
                    interactionSource2 = interactionSource;
                    $dirty1 = $dirty12 & -113;
                    $dirty = $dirty2;
                    leadingIcon3 = leadingIcon2;
                    leadingIcon4 = avatar2;
                    enabled3 = enabled;
                } else {
                    modifier2 = modifier;
                    trailingIcon2 = trailingIcon;
                    shape2 = shape;
                    colors2 = colors;
                    elevation2 = elevation;
                    border3 = border;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty2;
                    $dirty1 = $dirty12;
                    leadingIcon3 = leadingIcon2;
                    leadingIcon4 = avatar2;
                    enabled3 = enabled;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1599030387, $dirty, $dirty1, "androidx.compose.material3.InputChip (Chip.kt:421)");
            }
            $composer3.startReplaceableGroup(-1372002035);
            ComposerKt.sourceInformation($composer3, "441@22531L9");
            if (leadingIcon4 != null) {
                float avatarOpacity = enabled3 ? 1.0f : 0.38f;
                ChipKt$InputChip$2 chipKt$InputChip$2 = new ChipKt$InputChip$2(avatarOpacity, ShapesKt.toShape(InputChipTokens.INSTANCE.getAvatarShape(), $composer3, 6), leadingIcon4, $dirty);
                float f = avatarOpacity;
                z = true;
                shapedAvatar = ComposableLambdaKt.composableLambda($composer3, -352359235, true, chipKt$InputChip$2);
            } else {
                z = true;
                shapedAvatar = null;
            }
            $composer3.endReplaceableGroup();
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), InputChipTokens.INSTANCE.getLabelTextFont());
            State<BorderStroke> borderStroke$material3_release = border3 == null ? null : border3.borderStroke$material3_release(enabled3, z2, $composer3, (($dirty >> 12) & 14) | (($dirty << 3) & 112) | (($dirty1 << 3) & 896));
            BorderStroke value = borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null;
            float r28 = InputChipDefaults.INSTANCE.m1964getHeightD9Ej5fM();
            boolean z5 = false;
            boolean z6 = shapedAvatar != null ? z : false;
            boolean z7 = leadingIcon3 != null ? z : false;
            if (trailingIcon2 != null) {
                z5 = z;
            }
            int i18 = $dirty1;
            int i19 = $dirty;
            border2 = border3;
            avatar3 = leadingIcon4;
            enabled2 = enabled3;
            $composer2 = $composer3;
            m1787SelectableChipu0RnIRE(selected, modifier2, onClick, enabled3, label, fromToken, leadingIcon3, shapedAvatar, trailingIcon2, shape2, colors2, elevation2, value, r28, inputChipPadding(z6, z7, z5), interactionSource2, $composer2, ($dirty & 14) | (($dirty >> 6) & 112) | (($dirty << 3) & 896) | (($dirty >> 3) & 7168) | (($dirty << 6) & 57344) | (($dirty << 3) & 3670016) | (($dirty << 3) & 234881024) | (($dirty << 3) & 1879048192), (($dirty >> 27) & 14) | 3072 | (($dirty1 << 3) & 112) | (($dirty1 << 9) & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipKt$InputChip$3(selected, onClick, label, modifier2, enabled2, leadingIcon3, avatar3, trailingIcon2, shape2, colors2, elevation2, border2, interactionSource2, $changed, $changed1, i));
        }
    }

    @ExperimentalMaterial3Api
    public static final void SuggestionChip(Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> icon, Shape shape, ChipColors colors, ChipElevation elevation, ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i) {
        boolean z;
        Function2 function2;
        Shape shape2;
        ChipElevation elevation2;
        int i2;
        MutableInteractionSource mutableInteractionSource;
        Shape shape3;
        Function2 icon2;
        boolean enabled2;
        Composer $composer2;
        ChipColors colors2;
        ChipBorder border2;
        MutableInteractionSource interactionSource2;
        ChipElevation elevation3;
        Modifier modifier2;
        boolean enabled3;
        ChipColors colors3;
        ChipBorder border3;
        int $dirty;
        int i3;
        Modifier modifier3;
        boolean enabled4;
        ChipColors colors4;
        int $dirty2;
        Modifier modifier4;
        int i4;
        ChipBorder border4;
        MutableInteractionSource mutableInteractionSource2;
        int i5;
        int i6;
        int i7;
        int i8;
        Function0<Unit> function0 = onClick;
        Function2<? super Composer, ? super Integer, Unit> function22 = label;
        int i9 = $changed;
        int i10 = i;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function22, "label");
        Composer $composer3 = $composer.startRestartGroup(170629701);
        ComposerKt.sourceInformation($composer3, "C(SuggestionChip)P(8,6,7,3,4,9,1,2)526@26415L5,527@26470L22,528@26549L25,529@26625L22,530@26699L39,536@26875L10,537@26957L19,543@27121L21,531@26744L540:Chip.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i10 & 1) != 0) {
            $dirty3 |= 6;
        } else if ((i9 & 14) == 0) {
            $dirty3 |= $composer3.changed((Object) function0) ? 4 : 2;
        }
        if ((i10 & 2) != 0) {
            $dirty3 |= 48;
        } else if ((i9 & 112) == 0) {
            $dirty3 |= $composer3.changed((Object) function22) ? 32 : 16;
        }
        int i11 = i10 & 4;
        if (i11 != 0) {
            $dirty3 |= 384;
            Modifier modifier5 = modifier;
        } else if ((i9 & 896) == 0) {
            $dirty3 |= $composer3.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier6 = modifier;
        }
        int i12 = i10 & 8;
        if (i12 != 0) {
            $dirty3 |= 3072;
            z = enabled;
        } else if ((i9 & 7168) == 0) {
            z = enabled;
            $dirty3 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i13 = i10 & 16;
        if (i13 != 0) {
            $dirty3 |= 24576;
            function2 = icon;
        } else if ((i9 & 57344) == 0) {
            function2 = icon;
            $dirty3 |= $composer3.changed((Object) function2) ? 16384 : 8192;
        } else {
            function2 = icon;
        }
        if ((458752 & i9) == 0) {
            if ((i10 & 32) == 0) {
                shape2 = shape;
                if ($composer3.changed((Object) shape2)) {
                    i8 = 131072;
                    $dirty3 |= i8;
                }
            } else {
                shape2 = shape;
            }
            i8 = 65536;
            $dirty3 |= i8;
        } else {
            shape2 = shape;
        }
        if ((i9 & 3670016) == 0) {
            if ((i10 & 64) != 0) {
                ChipColors chipColors = colors;
            } else if ($composer3.changed((Object) colors)) {
                i7 = 1048576;
                $dirty3 |= i7;
            }
            i7 = 524288;
            $dirty3 |= i7;
        } else {
            ChipColors chipColors2 = colors;
        }
        if ((29360128 & i9) == 0) {
            if ((i10 & 128) == 0) {
                elevation2 = elevation;
                if ($composer3.changed((Object) elevation2)) {
                    i6 = 8388608;
                    $dirty3 |= i6;
                }
            } else {
                elevation2 = elevation;
            }
            i6 = 4194304;
            $dirty3 |= i6;
        } else {
            elevation2 = elevation;
        }
        if ((i9 & 234881024) == 0) {
            if ((i10 & 256) != 0) {
                ChipBorder chipBorder = border;
            } else if ($composer3.changed((Object) border)) {
                i5 = 67108864;
                $dirty3 |= i5;
            }
            i5 = 33554432;
            $dirty3 |= i5;
        } else {
            ChipBorder chipBorder2 = border;
        }
        int i14 = i10 & 512;
        if (i14 != 0) {
            $dirty3 |= 805306368;
            i2 = i14;
            mutableInteractionSource = interactionSource;
        } else if ((i9 & 1879048192) == 0) {
            i2 = i14;
            mutableInteractionSource = interactionSource;
            $dirty3 |= $composer3.changed((Object) mutableInteractionSource) ? 536870912 : 268435456;
        } else {
            i2 = i14;
            mutableInteractionSource = interactionSource;
        }
        if (($dirty3 & 1533916891) != 306783378 || !$composer3.getSkipping()) {
            $composer3.startDefaults();
            if ((i9 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i12 != 0) {
                    enabled4 = true;
                } else {
                    enabled4 = z;
                }
                if (i13 != 0) {
                    icon2 = null;
                } else {
                    icon2 = function2;
                }
                if ((i10 & 32) != 0) {
                    $dirty3 &= -458753;
                    shape3 = SuggestionChipDefaults.INSTANCE.getShape($composer3, 6);
                } else {
                    shape3 = shape2;
                }
                if ((i10 & 64) != 0) {
                    $dirty3 &= -3670017;
                    colors4 = SuggestionChipDefaults.INSTANCE.m2095suggestionChipColors5tl4gsc(0, 0, 0, 0, 0, 0, $composer3, 1572864, 63);
                } else {
                    colors4 = colors;
                }
                if ((i10 & 128) != 0) {
                    $dirty2 = $dirty3 & -29360129;
                    elevation2 = SuggestionChipDefaults.INSTANCE.m2096suggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                } else {
                    $dirty2 = $dirty3;
                }
                if ((i10 & 256) != 0) {
                    i4 = i2;
                    modifier4 = modifier3;
                    i3 = 6;
                    border4 = SuggestionChipDefaults.INSTANCE.m2094suggestionChipBorderd_3_b6Q(0, 0, 0.0f, $composer3, 3072, 7);
                    $dirty2 &= -234881025;
                } else {
                    i4 = i2;
                    modifier4 = modifier3;
                    i3 = 6;
                    border4 = border;
                }
                if (i4 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        mutableInteractionSource2 = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource2);
                    } else {
                        mutableInteractionSource2 = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    modifier2 = modifier4;
                    border3 = border4;
                    interactionSource2 = mutableInteractionSource2;
                    elevation3 = elevation2;
                    $dirty = $dirty2;
                    colors3 = colors4;
                    enabled3 = enabled4;
                } else {
                    modifier2 = modifier4;
                    interactionSource2 = interactionSource;
                    border3 = border4;
                    elevation3 = elevation2;
                    $dirty = $dirty2;
                    colors3 = colors4;
                    enabled3 = enabled4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i10 & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i10 & 64) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i10 & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                if ((i10 & 256) != 0) {
                    modifier2 = modifier;
                    interactionSource2 = interactionSource;
                    icon2 = function2;
                    shape3 = shape2;
                    elevation3 = elevation2;
                    colors3 = colors;
                    border3 = border;
                    boolean z2 = z;
                    $dirty = -234881025 & $dirty3;
                    i3 = 6;
                    enabled3 = z2;
                } else {
                    modifier2 = modifier;
                    interactionSource2 = interactionSource;
                    icon2 = function2;
                    shape3 = shape2;
                    i3 = 6;
                    elevation3 = elevation2;
                    colors3 = colors;
                    border3 = border;
                    enabled3 = z;
                    $dirty = $dirty3;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(170629701, $dirty, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:520)");
            }
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, i3), SuggestionChipTokens.INSTANCE.getLabelTextFont());
            long r22 = colors3.labelColor$material3_release(enabled3, $composer3, (($dirty >> 9) & 14) | (($dirty >> 15) & 112)).getValue().m3174unboximpl();
            State<BorderStroke> borderStroke$material3_release = border3 == null ? null : border3.borderStroke$material3_release(enabled3, $composer3, (($dirty >> 9) & 14) | (($dirty >> 21) & 112));
            $composer2 = $composer3;
            int i15 = (($dirty >> 6) & 14) | 12582912 | (($dirty << 3) & 112) | (($dirty >> 3) & 896) | (($dirty << 6) & 7168) | (($dirty << 6) & 3670016) | (($dirty << 9) & 234881024) | (($dirty << 9) & 1879048192);
            int i16 = (($dirty >> 21) & 14) | 3456 | (($dirty >> 15) & 57344);
            int i17 = $dirty;
            long j = r22;
            border2 = border3;
            colors2 = colors3;
            enabled2 = enabled3;
            m1785ChipnkUnTEs(modifier2, onClick, enabled3, label, fromToken, j, icon2, (Function2<? super Composer, ? super Integer, Unit>) null, shape3, colors2, elevation3, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, SuggestionChipDefaults.INSTANCE.m2092getHeightD9Ej5fM(), SuggestionChipPadding, interactionSource2, $composer2, i15, i16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            colors2 = colors;
            border2 = border;
            int i18 = $dirty3;
            enabled2 = z;
            icon2 = function2;
            shape3 = shape2;
            interactionSource2 = mutableInteractionSource;
            elevation3 = elevation2;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipKt$SuggestionChip$2(onClick, label, modifier2, enabled2, icon2, shape3, colors2, elevation3, border2, interactionSource2, $changed, i));
        }
    }

    @ExperimentalMaterial3Api
    public static final void ElevatedSuggestionChip(Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> icon, Shape shape, ChipColors colors, ChipElevation elevation, ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i) {
        Function2 function2;
        Shape shape2;
        ChipColors colors2;
        int i2;
        MutableInteractionSource mutableInteractionSource;
        Shape shape3;
        Function2 icon2;
        boolean enabled2;
        Modifier modifier2;
        Composer $composer2;
        ChipColors colors3;
        ChipBorder border2;
        MutableInteractionSource interactionSource2;
        ChipElevation elevation2;
        int i3;
        boolean enabled3;
        ChipBorder border3;
        int $dirty;
        boolean enabled4;
        int $dirty2;
        ChipColors colors4;
        int i4;
        ChipElevation elevation3;
        ChipBorder border4;
        MutableInteractionSource mutableInteractionSource2;
        int i5;
        int i6;
        int i7;
        Function0<Unit> function0 = onClick;
        Function2<? super Composer, ? super Integer, Unit> function22 = label;
        int i8 = $changed;
        int i9 = i;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function22, "label");
        Composer $composer3 = $composer.startRestartGroup(1668751803);
        ComposerKt.sourceInformation($composer3, "C(ElevatedSuggestionChip)P(8,6,7,3,4,9,1,2)595@29967L5,596@30022L30,597@30109L33,599@30226L39,605@30402L10,606@30484L19,600@30271L540:Chip.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i9 & 1) != 0) {
            $dirty3 |= 6;
        } else if ((i8 & 14) == 0) {
            $dirty3 |= $composer3.changed((Object) function0) ? 4 : 2;
        }
        if ((i9 & 2) != 0) {
            $dirty3 |= 48;
        } else if ((i8 & 112) == 0) {
            $dirty3 |= $composer3.changed((Object) function22) ? 32 : 16;
        }
        int i10 = i9 & 4;
        if (i10 != 0) {
            $dirty3 |= 384;
            Modifier modifier3 = modifier;
        } else if ((i8 & 896) == 0) {
            $dirty3 |= $composer3.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier4 = modifier;
        }
        int i11 = i9 & 8;
        if (i11 != 0) {
            $dirty3 |= 3072;
            boolean z = enabled;
        } else if ((i8 & 7168) == 0) {
            $dirty3 |= $composer3.changed(enabled) ? 2048 : 1024;
        } else {
            boolean z2 = enabled;
        }
        int i12 = i9 & 16;
        if (i12 != 0) {
            $dirty3 |= 24576;
            function2 = icon;
        } else if ((i8 & 57344) == 0) {
            function2 = icon;
            $dirty3 |= $composer3.changed((Object) function2) ? 16384 : 8192;
        } else {
            function2 = icon;
        }
        if ((458752 & i8) == 0) {
            if ((i9 & 32) == 0) {
                shape2 = shape;
                if ($composer3.changed((Object) shape2)) {
                    i7 = 131072;
                    $dirty3 |= i7;
                }
            } else {
                shape2 = shape;
            }
            i7 = 65536;
            $dirty3 |= i7;
        } else {
            shape2 = shape;
        }
        if ((i8 & 3670016) == 0) {
            if ((i9 & 64) == 0) {
                colors2 = colors;
                if ($composer3.changed((Object) colors2)) {
                    i6 = 1048576;
                    $dirty3 |= i6;
                }
            } else {
                colors2 = colors;
            }
            i6 = 524288;
            $dirty3 |= i6;
        } else {
            colors2 = colors;
        }
        if ((29360128 & i8) == 0) {
            if ((i9 & 128) != 0) {
                ChipElevation chipElevation = elevation;
            } else if ($composer3.changed((Object) elevation)) {
                i5 = 8388608;
                $dirty3 |= i5;
            }
            i5 = 4194304;
            $dirty3 |= i5;
        } else {
            ChipElevation chipElevation2 = elevation;
        }
        int i13 = i9 & 256;
        if (i13 != 0) {
            $dirty3 |= 100663296;
            ChipBorder chipBorder = border;
        } else if ((i8 & 234881024) == 0) {
            $dirty3 |= $composer3.changed((Object) border) ? 67108864 : 33554432;
        } else {
            ChipBorder chipBorder2 = border;
        }
        int i14 = i9 & 512;
        if (i14 != 0) {
            $dirty3 |= 805306368;
            i2 = i14;
            mutableInteractionSource = interactionSource;
        } else if ((i8 & 1879048192) == 0) {
            i2 = i14;
            mutableInteractionSource = interactionSource;
            $dirty3 |= $composer3.changed((Object) mutableInteractionSource) ? 536870912 : 268435456;
        } else {
            i2 = i14;
            mutableInteractionSource = interactionSource;
        }
        if (($dirty3 & 1533916891) != 306783378 || !$composer3.getSkipping()) {
            $composer3.startDefaults();
            if ((i8 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i11 != 0) {
                    enabled4 = true;
                } else {
                    enabled4 = enabled;
                }
                if (i12 != 0) {
                    icon2 = null;
                } else {
                    icon2 = function2;
                }
                if ((i9 & 32) != 0) {
                    $dirty3 &= -458753;
                    shape3 = SuggestionChipDefaults.INSTANCE.getShape($composer3, 6);
                } else {
                    shape3 = shape2;
                }
                if ((i9 & 64) != 0) {
                    $dirty2 = $dirty3 & -3670017;
                    colors4 = SuggestionChipDefaults.INSTANCE.m2090elevatedSuggestionChipColors5tl4gsc(0, 0, 0, 0, 0, 0, $composer3, 1572864, 63);
                } else {
                    $dirty2 = $dirty3;
                    colors4 = colors2;
                }
                if ((i9 & 128) != 0) {
                    i4 = i2;
                    i3 = 6;
                    elevation3 = SuggestionChipDefaults.INSTANCE.m2091elevatedSuggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                    $dirty2 &= -29360129;
                } else {
                    i4 = i2;
                    i3 = 6;
                    elevation3 = elevation;
                }
                if (i13 != 0) {
                    border4 = null;
                } else {
                    border4 = border;
                }
                if (i4 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        mutableInteractionSource2 = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource2);
                    } else {
                        mutableInteractionSource2 = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    border3 = border4;
                    elevation2 = elevation3;
                    interactionSource2 = mutableInteractionSource2;
                    colors2 = colors4;
                    $dirty = $dirty2;
                    enabled3 = enabled4;
                } else {
                    interactionSource2 = interactionSource;
                    border3 = border4;
                    elevation2 = elevation3;
                    colors2 = colors4;
                    $dirty = $dirty2;
                    enabled3 = enabled4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i9 & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i9 & 64) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i9 & 128) != 0) {
                    modifier2 = modifier;
                    elevation2 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty3 & -29360129;
                    icon2 = function2;
                    shape3 = shape2;
                    i3 = 6;
                    enabled3 = enabled;
                    border3 = border;
                } else {
                    modifier2 = modifier;
                    elevation2 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty3;
                    icon2 = function2;
                    shape3 = shape2;
                    i3 = 6;
                    enabled3 = enabled;
                    border3 = border;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1668751803, $dirty, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:589)");
            }
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, i3), SuggestionChipTokens.INSTANCE.getLabelTextFont());
            long r21 = colors2.labelColor$material3_release(enabled3, $composer3, (($dirty >> 9) & 14) | (($dirty >> 15) & 112)).getValue().m3174unboximpl();
            float r16 = SuggestionChipDefaults.INSTANCE.m2092getHeightD9Ej5fM();
            PaddingValues paddingValues = SuggestionChipPadding;
            $composer3.startReplaceableGroup(-1455593643);
            ComposerKt.sourceInformation($composer3, "614@30738L21");
            State<BorderStroke> borderStroke$material3_release = border3 == null ? null : border3.borderStroke$material3_release(enabled3, $composer3, (($dirty >> 9) & 14) | (($dirty >> 21) & 112));
            $composer3.endReplaceableGroup();
            int i15 = (($dirty >> 6) & 14) | 12582912 | (($dirty << 3) & 112) | (($dirty >> 3) & 896) | (($dirty << 6) & 7168) | (($dirty << 6) & 3670016) | (($dirty << 9) & 234881024) | (($dirty << 9) & 1879048192);
            int i16 = (($dirty >> 21) & 14) | 3456 | (($dirty >> 15) & 57344);
            int i17 = $dirty;
            long j = r21;
            border2 = border3;
            colors3 = colors2;
            enabled2 = enabled3;
            $composer2 = $composer3;
            m1785ChipnkUnTEs(modifier2, onClick, enabled3, label, fromToken, j, icon2, (Function2<? super Composer, ? super Integer, Unit>) null, shape3, colors3, elevation2, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, r16, paddingValues, interactionSource2, $composer2, i15, i16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            enabled2 = enabled;
            elevation2 = elevation;
            border2 = border;
            int i18 = $dirty3;
            icon2 = function2;
            shape3 = shape2;
            colors3 = colors2;
            interactionSource2 = mutableInteractionSource;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipKt$ElevatedSuggestionChip$2(onClick, label, modifier2, enabled2, icon2, shape3, colors3, elevation2, border2, interactionSource2, $changed, i));
        }
    }

    /* access modifiers changed from: private */
    @ExperimentalMaterial3Api
    /* renamed from: Chip-nkUnTEs  reason: not valid java name */
    public static final void m1785ChipnkUnTEs(Modifier modifier, Function0<Unit> onClick, boolean enabled, Function2<? super Composer, ? super Integer, Unit> label, TextStyle labelTextStyle, long labelColor, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, ChipColors colors, ChipElevation elevation, BorderStroke border, float minHeight, PaddingValues paddingValues, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1) {
        Composer $composer2;
        float f;
        int $dirty;
        State<Dp> state;
        float f2;
        boolean z = enabled;
        ChipColors chipColors = colors;
        ChipElevation chipElevation = elevation;
        MutableInteractionSource mutableInteractionSource = interactionSource;
        int i = $changed;
        int i2 = $changed1;
        Composer $composer3 = $composer.startRestartGroup(1400504719);
        ComposerKt.sourceInformation($composer3, "C(Chip)P(10,11,3,5,7,6:c#ui.graphics.Color,8,14,13,1,2!1,9:c#ui.unit.Dp,12)1330@66857L23,1332@67020L43,1325@66719L928:Chip.kt#uh7d8r");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        int i3 = 2;
        if ((i & 14) == 0) {
            $dirty2 |= $composer3.changed((Object) modifier) ? 4 : 2;
        } else {
            Modifier modifier2 = modifier;
        }
        int i4 = 32;
        if ((i & 112) == 0) {
            $dirty2 |= $composer3.changed((Object) onClick) ? 32 : 16;
        } else {
            Function0<Unit> function0 = onClick;
        }
        int i5 = 256;
        if ((i & 896) == 0) {
            $dirty2 |= $composer3.changed(z) ? 256 : 128;
        }
        int i6 = 2048;
        if ((i & 7168) == 0) {
            $dirty2 |= $composer3.changed((Object) label) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function2 = label;
        }
        int i7 = 16384;
        if ((i & 57344) == 0) {
            $dirty2 |= $composer3.changed((Object) labelTextStyle) ? 16384 : 8192;
        } else {
            TextStyle textStyle = labelTextStyle;
        }
        if ((i & 458752) == 0) {
            $dirty2 |= $composer3.changed(labelColor) ? 131072 : 65536;
        } else {
            long j = labelColor;
        }
        if ((i & 3670016) == 0) {
            $dirty2 |= $composer3.changed((Object) leadingIcon) ? 1048576 : 524288;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function22 = leadingIcon;
        }
        if ((29360128 & i) == 0) {
            $dirty2 |= $composer3.changed((Object) trailingIcon) ? 8388608 : 4194304;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = trailingIcon;
        }
        if ((i & 234881024) == 0) {
            $dirty2 |= $composer3.changed((Object) shape) ? 67108864 : 33554432;
        } else {
            Shape shape2 = shape;
        }
        if ((i & 1879048192) == 0) {
            $dirty2 |= $composer3.changed((Object) chipColors) ? 536870912 : 268435456;
        }
        if ((i2 & 14) == 0) {
            if ($composer3.changed((Object) chipElevation)) {
                i3 = 4;
            }
            $dirty1 |= i3;
        }
        if ((i2 & 112) == 0) {
            if (!$composer3.changed((Object) border)) {
                i4 = 16;
            }
            $dirty1 |= i4;
        } else {
            BorderStroke borderStroke = border;
        }
        if ((i2 & 896) == 0) {
            if (!$composer3.changed(minHeight)) {
                i5 = 128;
            }
            $dirty1 |= i5;
        } else {
            float f3 = minHeight;
        }
        if ((i2 & 7168) == 0) {
            if (!$composer3.changed((Object) paddingValues)) {
                i6 = 1024;
            }
            $dirty1 |= i6;
        } else {
            PaddingValues paddingValues2 = paddingValues;
        }
        if ((i2 & 57344) == 0) {
            if (!$composer3.changed((Object) mutableInteractionSource)) {
                i7 = 8192;
            }
            $dirty1 |= i7;
        }
        if (($dirty2 & 1533916891) == 306783378 && (46811 & $dirty1) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            int i8 = $dirty2;
            int i9 = $dirty1;
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1400504719, $dirty2, $dirty1, "androidx.compose.material3.Chip (Chip.kt:1308)");
            }
            long r17 = chipColors.containerColor$material3_release(z, $composer3, (($dirty2 >> 6) & 14) | (($dirty2 >> 24) & 112)).getValue().m3174unboximpl();
            $composer3.startReplaceableGroup(64019101);
            ComposerKt.sourceInformation($composer3, "1331@66924L42");
            State<Dp> state2 = chipElevation == null ? null : chipElevation.tonalElevation$material3_release(z, mutableInteractionSource, $composer3, (($dirty2 >> 6) & 14) | (($dirty1 >> 9) & 112) | (($dirty1 << 6) & 896));
            $composer3.endReplaceableGroup();
            if (state2 != null) {
                f = state2.getValue().m6000unboximpl();
            } else {
                f = Dp.m5986constructorimpl((float) 0);
            }
            if (chipElevation == null) {
                $dirty = $dirty2;
                state = null;
            } else {
                $dirty = $dirty2;
                state = chipElevation.shadowElevation$material3_release(z, mutableInteractionSource, $composer3, (($dirty1 << 6) & 896) | (($dirty2 >> 6) & 14) | (($dirty1 >> 9) & 112));
            }
            if (state != null) {
                f2 = state.getValue().m6000unboximpl();
            } else {
                f2 = Dp.m5986constructorimpl((float) 0);
            }
            int $dirty3 = $dirty;
            int $dirty12 = $dirty1;
            ChipKt$Chip$1 chipKt$Chip$1 = r0;
            Composer $composer4 = $composer3;
            ChipKt$Chip$1 chipKt$Chip$12 = new ChipKt$Chip$1(label, labelTextStyle, labelColor, leadingIcon, trailingIcon, colors, enabled, $dirty3, minHeight, paddingValues, $dirty12);
            int $dirty4 = $dirty3;
            $composer2 = $composer4;
            int i10 = $dirty4;
            SurfaceKt.m2100Surfaceo_FOJdg(onClick, modifier, enabled, shape, r17, 0, f, f2, border, interactionSource, ComposableLambdaKt.composableLambda($composer4, -1985962652, true, chipKt$Chip$1), $composer2, (($dirty4 >> 3) & 14) | (($dirty4 << 3) & 112) | ($dirty4 & 896) | (($dirty4 >> 15) & 7168) | (($dirty12 << 21) & 234881024) | (($dirty12 << 15) & 1879048192), 6, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipKt$Chip$2(modifier, onClick, enabled, label, labelTextStyle, labelColor, leadingIcon, trailingIcon, shape, colors, elevation, border, minHeight, paddingValues, interactionSource, $changed, $changed1));
        }
    }

    /* access modifiers changed from: private */
    @ExperimentalMaterial3Api
    /* renamed from: SelectableChip-u0RnIRE  reason: not valid java name */
    public static final void m1787SelectableChipu0RnIRE(boolean selected, Modifier modifier, Function0<Unit> onClick, boolean enabled, Function2<? super Composer, ? super Integer, Unit> label, TextStyle labelTextStyle, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> avatar, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Shape shape, SelectableChipColors colors, SelectableChipElevation elevation, BorderStroke border, float minHeight, PaddingValues paddingValues, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1) {
        Composer $composer2;
        float f;
        float f2;
        boolean z = selected;
        Modifier modifier2 = modifier;
        boolean z2 = enabled;
        SelectableChipColors selectableChipColors = colors;
        SelectableChipElevation selectableChipElevation = elevation;
        MutableInteractionSource mutableInteractionSource = interactionSource;
        int i = $changed;
        int i2 = $changed1;
        Composer $composer3 = $composer.startRestartGroup(402951308);
        ComposerKt.sourceInformation($composer3, "C(SelectableChip)P(13,10,11,4,6,7,8!1,15,14,2,3!1,9:c#ui.unit.Dp,12)1378@68514L33,1381@68699L43,1372@68312L1080:Chip.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        int i3 = 2;
        if ((i & 14) == 0) {
            $dirty |= $composer3.changed(z) ? 4 : 2;
        }
        int i4 = 16;
        if ((i & 112) == 0) {
            $dirty |= $composer3.changed((Object) modifier2) ? 32 : 16;
        }
        int i5 = 256;
        if ((i & 896) == 0) {
            $dirty |= $composer3.changed((Object) onClick) ? 256 : 128;
        } else {
            Function0<Unit> function0 = onClick;
        }
        int i6 = 2048;
        if ((i & 7168) == 0) {
            $dirty |= $composer3.changed(z2) ? 2048 : 1024;
        }
        int i7 = 16384;
        if ((i & 57344) == 0) {
            $dirty |= $composer3.changed((Object) label) ? 16384 : 8192;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function2 = label;
        }
        int i8 = 131072;
        if ((i & 458752) == 0) {
            $dirty |= $composer3.changed((Object) labelTextStyle) ? 131072 : 65536;
        } else {
            TextStyle textStyle = labelTextStyle;
        }
        if ((i & 3670016) == 0) {
            $dirty |= $composer3.changed((Object) leadingIcon) ? 1048576 : 524288;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function22 = leadingIcon;
        }
        if ((i & 29360128) == 0) {
            $dirty |= $composer3.changed((Object) avatar) ? 8388608 : 4194304;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = avatar;
        }
        if ((i & 234881024) == 0) {
            $dirty |= $composer3.changed((Object) trailingIcon) ? 67108864 : 33554432;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = trailingIcon;
        }
        if ((i & 1879048192) == 0) {
            $dirty |= $composer3.changed((Object) shape) ? 536870912 : 268435456;
        } else {
            Shape shape2 = shape;
        }
        if ((i2 & 14) == 0) {
            if ($composer3.changed((Object) selectableChipColors)) {
                i3 = 4;
            }
            $dirty1 |= i3;
        }
        if ((i2 & 112) == 0) {
            if ($composer3.changed((Object) selectableChipElevation)) {
                i4 = 32;
            }
            $dirty1 |= i4;
        }
        if ((i2 & 896) == 0) {
            if (!$composer3.changed((Object) border)) {
                i5 = 128;
            }
            $dirty1 |= i5;
        } else {
            BorderStroke borderStroke = border;
        }
        if ((i2 & 7168) == 0) {
            if (!$composer3.changed(minHeight)) {
                i6 = 1024;
            }
            $dirty1 |= i6;
        } else {
            float f3 = minHeight;
        }
        if ((i2 & 57344) == 0) {
            if (!$composer3.changed((Object) paddingValues)) {
                i7 = 8192;
            }
            $dirty1 |= i7;
        } else {
            PaddingValues paddingValues2 = paddingValues;
        }
        if ((i2 & 458752) == 0) {
            if (!$composer3.changed((Object) mutableInteractionSource)) {
                i8 = 65536;
            }
            $dirty1 |= i8;
        }
        if (($dirty & 1533916891) == 306783378 && (374491 & $dirty1) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            int i9 = $dirty;
            int i10 = $dirty1;
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(402951308, $dirty, $dirty1, "androidx.compose.material3.SelectableChip (Chip.kt:1353)");
            }
            State<Dp> state = null;
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier2, false, ChipKt$SelectableChip$1.INSTANCE, 1, (Object) null);
            long r19 = selectableChipColors.containerColor$material3_release(z2, z, $composer3, (($dirty >> 9) & 14) | (($dirty << 3) & 112) | (($dirty1 << 6) & 896)).getValue().m3174unboximpl();
            $composer3.startReplaceableGroup(1036661290);
            ComposerKt.sourceInformation($composer3, "1379@68591L42");
            State<Dp> state2 = selectableChipElevation == null ? null : selectableChipElevation.tonalElevation$material3_release(z2, mutableInteractionSource, $composer3, (($dirty >> 9) & 14) | (($dirty1 >> 12) & 112) | (($dirty1 << 3) & 896));
            $composer3.endReplaceableGroup();
            if (state2 != null) {
                f = state2.getValue().m6000unboximpl();
            } else {
                f = Dp.m5986constructorimpl((float) 0);
            }
            if (selectableChipElevation != null) {
                state = selectableChipElevation.shadowElevation$material3_release(z2, mutableInteractionSource, $composer3, (($dirty >> 9) & 14) | (($dirty1 >> 12) & 112) | (($dirty1 << 3) & 896));
            }
            if (state != null) {
                f2 = state.getValue().m6000unboximpl();
            } else {
                f2 = Dp.m5986constructorimpl((float) 0);
            }
            int $dirty12 = $dirty1;
            int $dirty2 = $dirty;
            ChipKt$SelectableChip$2 chipKt$SelectableChip$2 = r0;
            Composer $composer4 = $composer3;
            ChipKt$SelectableChip$2 chipKt$SelectableChip$22 = new ChipKt$SelectableChip$2(colors, enabled, selected, $dirty2, $dirty12, label, labelTextStyle, leadingIcon, avatar, trailingIcon, minHeight, paddingValues);
            int $dirty3 = $dirty2;
            int i11 = $dirty3;
            $composer2 = $composer4;
            SurfaceKt.m2098Surfaced85dljk(selected, onClick, semantics$default, enabled, shape, r19, 0, f, f2, border, interactionSource, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer4, -577614814, true, chipKt$SelectableChip$2), $composer4, ($dirty3 & 14) | (($dirty3 >> 3) & 112) | ($dirty3 & 7168) | (($dirty3 >> 15) & 57344) | (($dirty12 << 21) & 1879048192), (($dirty12 >> 15) & 14) | 48, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipKt$SelectableChip$3(selected, modifier, onClick, enabled, label, labelTextStyle, leadingIcon, avatar, trailingIcon, shape, colors, elevation, border, minHeight, paddingValues, interactionSource, $changed, $changed1));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ChipContent-fe0OD_I  reason: not valid java name */
    public static final void m1786ChipContentfe0OD_I(Function2<? super Composer, ? super Integer, Unit> label, TextStyle labelTextStyle, long labelColor, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> avatar, Function2<? super Composer, ? super Integer, Unit> trailingIcon, long leadingIconColor, long trailingIconColor, float minHeight, PaddingValues paddingValues, Composer $composer, int $changed) {
        TextStyle textStyle = labelTextStyle;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-782878228);
        ComposerKt.sourceInformation($composer2, "C(ChipContent)P(1,3,2:c#ui.graphics.Color,4!1,8,5:c#ui.graphics.Color,9:c#ui.graphics.Color,6:c#ui.unit.Dp)1414@69769L1012:Chip.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed((Object) label) ? 4 : 2;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function2 = label;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changed((Object) textStyle) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changed(labelColor) ? 256 : 128;
        } else {
            long j = labelColor;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer2.changed((Object) leadingIcon) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function22 = leadingIcon;
        }
        if ((57344 & i) == 0) {
            $dirty |= $composer2.changed((Object) avatar) ? 16384 : 8192;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = avatar;
        }
        if ((458752 & i) == 0) {
            $dirty |= $composer2.changed((Object) trailingIcon) ? 131072 : 65536;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = trailingIcon;
        }
        if ((3670016 & i) == 0) {
            $dirty |= $composer2.changed(leadingIconColor) ? 1048576 : 524288;
        } else {
            long j2 = leadingIconColor;
        }
        if ((29360128 & i) == 0) {
            $dirty |= $composer2.changed(trailingIconColor) ? 8388608 : 4194304;
        } else {
            long j3 = trailingIconColor;
        }
        if ((234881024 & i) == 0) {
            $dirty |= $composer2.changed(minHeight) ? 67108864 : 33554432;
        } else {
            float f = minHeight;
        }
        if ((i & 1879048192) == 0) {
            $dirty |= $composer2.changed((Object) paddingValues) ? 536870912 : 268435456;
        } else {
            PaddingValues paddingValues2 = paddingValues;
        }
        if (($dirty & 1533916891) != 306783378 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-782878228, $dirty, -1, "androidx.compose.material3.ChipContent (Chip.kt:1402)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(labelColor)), TextKt.getLocalTextStyle().provides(textStyle)}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, 1748799148, true, new ChipKt$ChipContent$1(minHeight, paddingValues, avatar, $dirty, leadingIcon, leadingIconColor, label, trailingIcon, trailingIconColor)), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i2 = $dirty;
            Composer composer = $composer2;
            return;
        }
        int i3 = $dirty;
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new ChipKt$ChipContent$2(label, labelTextStyle, labelColor, leadingIcon, avatar, trailingIcon, leadingIconColor, trailingIconColor, minHeight, paddingValues, $changed));
    }

    static /* synthetic */ PaddingValues inputChipPadding$default(boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return inputChipPadding(z, z2, z3);
    }

    private static final PaddingValues inputChipPadding(boolean hasAvatar, boolean hasLeadingIcon, boolean hasTrailingIcon) {
        float end;
        float start = (hasAvatar || !hasLeadingIcon) ? Dp.m5986constructorimpl((float) 4) : Dp.m5986constructorimpl((float) 8);
        if (hasTrailingIcon) {
            end = Dp.m5986constructorimpl((float) 8);
        } else {
            end = Dp.m5986constructorimpl((float) 4);
        }
        return PaddingKt.m757PaddingValuesa9UjIt4$default(start, 0.0f, end, 0.0f, 10, (Object) null);
    }

    static {
        float r0 = Dp.m5986constructorimpl((float) 8);
        HorizontalElementsPadding = r0;
        AssistChipPadding = PaddingKt.m755PaddingValuesYgX7TsA$default(r0, 0.0f, 2, (Object) null);
        FilterChipPadding = PaddingKt.m755PaddingValuesYgX7TsA$default(r0, 0.0f, 2, (Object) null);
        SuggestionChipPadding = PaddingKt.m755PaddingValuesYgX7TsA$default(r0, 0.0f, 2, (Object) null);
    }
}
