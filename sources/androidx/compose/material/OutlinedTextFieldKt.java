package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010+\u001a\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010,\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010-\u001a\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010.\u001a\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010,\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010/\u001aÄ\u0001\u00100\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0011\u00101\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0019\u0010\u0018\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\r¢\u0006\u0002\b\u00172\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u00103\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0006\u0010\"\u001a\u00020\u00112\u0006\u00104\u001a\u0002052\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\t0\r2\u0011\u00108\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0006\u00109\u001a\u00020:H\u0001ø\u0001\u0000¢\u0006\u0002\u0010;\u001aU\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002052\u0006\u00109\u001a\u00020:H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a]\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020\u00112\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002052\u0006\u00109\u001a\u00020:H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010O\u001a)\u0010P\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010Q\u001a\u0002072\u0006\u00109\u001a\u00020:H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bR\u0010S\u001a|\u0010T\u001a\u00020\t*\u00020U2\u0006\u0010V\u001a\u00020$2\u0006\u0010W\u001a\u00020$2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\u0010Z\u001a\u0004\u0018\u00010Y2\u0006\u0010[\u001a\u00020Y2\b\u0010\\\u001a\u0004\u0018\u00010Y2\b\u0010]\u001a\u0004\u0018\u00010Y2\u0006\u0010^\u001a\u00020Y2\u0006\u00104\u001a\u0002052\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010D\u001a\u0002052\u0006\u0010_\u001a\u00020`2\u0006\u00109\u001a\u00020:H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006a"}, d2 = {"BorderId", "", "OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", "border", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-zUg2_y0", "(IIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "isLabelInMiddleSection", "calculateWidth-O3s9Psw", "(IIIIIZJFLandroidx/compose/foundation/layout/PaddingValues;)I", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "height", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "borderPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: OutlinedTextField.kt */
public final class OutlinedTextFieldKt {
    public static final String BorderId = "border";
    /* access modifiers changed from: private */
    public static final float OutlinedTextFieldInnerPadding = Dp.m5986constructorimpl((float) 4);
    private static final float OutlinedTextFieldTopPadding = Dp.m5986constructorimpl((float) 8);

    public static final void OutlinedTextField(String value, Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i) {
        int minLines2;
        boolean singleLine2;
        boolean readOnly2;
        Modifier modifier2;
        boolean enabled2;
        TextStyle textStyle2;
        Composer $composer2;
        boolean isError2;
        Shape shape2;
        TextFieldColors colors2;
        MutableInteractionSource interactionSource2;
        int maxLines2;
        KeyboardActions keyboardActions2;
        KeyboardOptions keyboardOptions2;
        VisualTransformation visualTransformation2;
        Function2 trailingIcon2;
        Function2 leadingIcon2;
        Function2 placeholder2;
        Function2 label2;
        MutableInteractionSource interactionSource3;
        int maxLines3;
        KeyboardActions keyboardActions3;
        KeyboardOptions keyboardOptions3;
        VisualTransformation visualTransformation3;
        Function2 trailingIcon3;
        Function2 leadingIcon3;
        Function2 placeholder3;
        Function2 label3;
        Modifier modifier3;
        boolean z;
        boolean enabled3;
        TextStyle textStyle3;
        boolean isError3;
        Shape shape3;
        TextFieldColors colors3;
        int $dirty;
        long textColor;
        Modifier modifier4;
        Modifier modifier5;
        boolean enabled4;
        boolean enabled5;
        Modifier modifier6;
        TextStyle textStyle4;
        Function2 label4;
        Function2 placeholder4;
        Function2 leadingIcon4;
        Function2 trailingIcon4;
        boolean isError4;
        VisualTransformation visualTransformation4;
        KeyboardOptions keyboardOptions4;
        KeyboardActions keyboardActions4;
        int maxLines4;
        int $dirty1;
        int maxLines5;
        int $dirty2;
        MutableInteractionSource interactionSource4;
        int $dirty12;
        Shape shape4;
        Object value$iv$iv;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str = value;
        Function1<? super String, Unit> function1 = onValueChange;
        int i7 = $changed;
        int i8 = $changed1;
        int i9 = i;
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-621914704);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)139@7767L7,151@8373L39,152@8447L6,153@8509L25,173@9280L24,182@9646L20,162@8837L2051:OutlinedTextField.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty13 = $changed1;
        if ((i9 & 1) != 0) {
            $dirty3 |= 6;
        } else if (i7 == false || !true) {
            $dirty3 |= $composer3.changed((Object) str) ? 4 : 2;
        }
        if ((i9 & 2) != 0) {
            $dirty3 |= 48;
        } else if (i7 == false || !true) {
            $dirty3 |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int i10 = i9 & 4;
        if (i10 != 0) {
            $dirty3 |= 384;
            Modifier modifier7 = modifier;
        } else if (i7 == false || !true) {
            $dirty3 |= $composer3.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier8 = modifier;
        }
        int i11 = i9 & 8;
        int i12 = 2048;
        if (i11 != 0) {
            $dirty3 |= 3072;
            boolean z2 = enabled;
        } else if (i7 == false || !true) {
            $dirty3 |= $composer3.changed(enabled) ? 2048 : true;
        } else {
            boolean z3 = enabled;
        }
        int i13 = i9 & 16;
        int i14 = 16384;
        if (i13 != 0) {
            $dirty3 |= 24576;
            boolean z4 = readOnly;
        } else if (i7 == false || !true) {
            $dirty3 |= $composer3.changed(readOnly) ? 16384 : true;
        } else {
            boolean z5 = readOnly;
        }
        if (i7 == false || !true) {
            if ((i9 & 32) != 0) {
                TextStyle textStyle5 = textStyle;
            } else if ($composer3.changed((Object) textStyle)) {
                i6 = 131072;
                $dirty3 |= i6;
            }
            i6 = 65536;
            $dirty3 |= i6;
        } else {
            TextStyle textStyle6 = textStyle;
        }
        int i15 = i9 & 64;
        if (i15 != 0) {
            $dirty3 |= 1572864;
            Function2<? super Composer, ? super Integer, Unit> function2 = label;
        } else if (i7 == false || !true) {
            $dirty3 |= $composer3.changedInstance(label) ? 1048576 : 0;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function22 = label;
        }
        int i16 = i9 & 128;
        if (i16 != 0) {
            $dirty3 |= 12582912;
            Function2<? super Composer, ? super Integer, Unit> function23 = placeholder;
        } else if (i7 == false || !true) {
            $dirty3 |= $composer3.changedInstance(placeholder) ? 8388608 : 4194304;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = placeholder;
        }
        int i17 = i9 & 256;
        if (i17 != 0) {
            $dirty3 |= 100663296;
            Function2<? super Composer, ? super Integer, Unit> function25 = leadingIcon;
        } else if (i7 == false || !true) {
            $dirty3 |= $composer3.changedInstance(leadingIcon) ? 67108864 : 33554432;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function26 = leadingIcon;
        }
        int i18 = i9 & 512;
        if (i18 != 0) {
            $dirty3 |= 805306368;
            Function2<? super Composer, ? super Integer, Unit> function27 = trailingIcon;
        } else if (i7 == false || !true) {
            $dirty3 |= $composer3.changedInstance(trailingIcon) ? 536870912 : 268435456;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function28 = trailingIcon;
        }
        int i19 = i9 & 1024;
        if (i19 != 0) {
            $dirty13 |= 6;
            boolean z6 = isError;
        } else if ((i8 & 14) == 0) {
            $dirty13 |= $composer3.changed(isError) ? 4 : 2;
        } else {
            boolean z7 = isError;
        }
        int i20 = i9 & 2048;
        if (i20 != 0) {
            $dirty13 |= 48;
            VisualTransformation visualTransformation5 = visualTransformation;
        } else if ((i8 & 112) == 0) {
            $dirty13 |= $composer3.changed((Object) visualTransformation) ? 32 : 16;
        } else {
            VisualTransformation visualTransformation6 = visualTransformation;
        }
        int i21 = i9 & 4096;
        if (i21 != 0) {
            $dirty13 |= 384;
            KeyboardOptions keyboardOptions5 = keyboardOptions;
        } else if ((i8 & 896) == 0) {
            $dirty13 |= $composer3.changed((Object) keyboardOptions) ? 256 : 128;
        } else {
            KeyboardOptions keyboardOptions6 = keyboardOptions;
        }
        int i22 = i9 & 8192;
        if (i22 != 0) {
            $dirty13 |= 3072;
            KeyboardActions keyboardActions5 = keyboardActions;
        } else if ((i8 & 7168) == 0) {
            if (!$composer3.changed((Object) keyboardActions)) {
                i12 = 1024;
            }
            $dirty13 |= i12;
        } else {
            KeyboardActions keyboardActions6 = keyboardActions;
        }
        int i23 = i9 & 16384;
        if (i23 != 0) {
            $dirty13 |= 24576;
            boolean z8 = singleLine;
        } else if ((i8 & 57344) == 0) {
            if (!$composer3.changed(singleLine)) {
                i14 = 8192;
            }
            $dirty13 |= i14;
        } else {
            boolean z9 = singleLine;
        }
        if ((i8 & 458752) == 0) {
            if ((i9 & 32768) != 0) {
                int i24 = maxLines;
            } else if ($composer3.changed(maxLines)) {
                i5 = 131072;
                $dirty13 |= i5;
            }
            i5 = 65536;
            $dirty13 |= i5;
        } else {
            int i25 = maxLines;
        }
        int i26 = i9 & 65536;
        if (i26 != 0) {
            $dirty13 |= 1572864;
            int i27 = minLines;
        } else if ((i8 & 3670016) == 0) {
            $dirty13 |= $composer3.changed(minLines) ? 1048576 : 524288;
        } else {
            int i28 = minLines;
        }
        int i29 = i9 & 131072;
        if (i29 != 0) {
            $dirty13 |= 12582912;
            MutableInteractionSource mutableInteractionSource = interactionSource;
        } else if ((i8 & 29360128) == 0) {
            $dirty13 |= $composer3.changed((Object) interactionSource) ? 8388608 : 4194304;
        } else {
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
        }
        if ((i8 & 234881024) == 0) {
            if ((i9 & 262144) != 0) {
                Shape shape5 = shape;
            } else if ($composer3.changed((Object) shape)) {
                i4 = 67108864;
                $dirty13 |= i4;
            }
            i4 = 33554432;
            $dirty13 |= i4;
        } else {
            Shape shape6 = shape;
        }
        if ((i8 & 1879048192) == 0) {
            if ((i9 & 524288) != 0) {
                TextFieldColors textFieldColors = colors;
            } else if ($composer3.changed((Object) colors)) {
                i3 = 536870912;
                $dirty13 |= i3;
            }
            i3 = 268435456;
            $dirty13 |= i3;
        } else {
            TextFieldColors textFieldColors2 = colors;
        }
        if (($dirty3 & 1533916891) == 306783378 && (1533916891 & $dirty13) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            enabled2 = enabled;
            readOnly2 = readOnly;
            textStyle2 = textStyle;
            label2 = label;
            placeholder2 = placeholder;
            leadingIcon2 = leadingIcon;
            trailingIcon2 = trailingIcon;
            isError2 = isError;
            visualTransformation2 = visualTransformation;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            maxLines2 = maxLines;
            minLines2 = minLines;
            interactionSource2 = interactionSource;
            shape2 = shape;
            colors2 = colors;
            int i30 = $dirty3;
            int i31 = $dirty13;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if ((i7 == false || !true) || $composer3.getDefaultsInvalid()) {
                if (i10 != 0) {
                    modifier5 = Modifier.Companion;
                } else {
                    modifier5 = modifier;
                }
                if (i11 != 0) {
                    enabled4 = true;
                } else {
                    enabled4 = enabled;
                }
                if (i13 != 0) {
                    readOnly2 = false;
                } else {
                    readOnly2 = readOnly;
                }
                if ((i9 & 32) != 0) {
                    modifier6 = modifier5;
                    enabled5 = enabled4;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(TextKt.getLocalTextStyle());
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle4 = (TextStyle) consume;
                    $dirty3 &= -458753;
                } else {
                    modifier6 = modifier5;
                    enabled5 = enabled4;
                    textStyle4 = textStyle;
                }
                if (i15 != 0) {
                    label4 = null;
                } else {
                    label4 = label;
                }
                if (i16 != 0) {
                    placeholder4 = null;
                } else {
                    placeholder4 = placeholder;
                }
                if (i17 != 0) {
                    leadingIcon4 = null;
                } else {
                    leadingIcon4 = leadingIcon;
                }
                if (i18 != 0) {
                    trailingIcon4 = null;
                } else {
                    trailingIcon4 = trailingIcon;
                }
                if (i19 != 0) {
                    isError4 = false;
                } else {
                    isError4 = isError;
                }
                if (i20 != 0) {
                    visualTransformation4 = VisualTransformation.Companion.getNone();
                } else {
                    visualTransformation4 = visualTransformation;
                }
                if (i21 != 0) {
                    keyboardOptions4 = KeyboardOptions.Companion.getDefault();
                } else {
                    keyboardOptions4 = keyboardOptions;
                }
                if (i22 != 0) {
                    keyboardActions4 = KeyboardActions.Companion.getDefault();
                } else {
                    keyboardActions4 = keyboardActions;
                }
                if (i23 != 0) {
                    singleLine2 = false;
                } else {
                    singleLine2 = singleLine;
                }
                if ((32768 & i9) != 0) {
                    maxLines4 = $dirty13 & -458753;
                    $dirty1 = singleLine2 ? 1 : Integer.MAX_VALUE;
                } else {
                    maxLines4 = $dirty13;
                    $dirty1 = maxLines;
                }
                if (i26 != 0) {
                    minLines2 = 1;
                } else {
                    minLines2 = minLines;
                }
                if (i29 != 0) {
                    $dirty2 = $dirty3;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    maxLines5 = $dirty1;
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
                    interactionSource4 = (MutableInteractionSource) value$iv$iv;
                } else {
                    $dirty2 = $dirty3;
                    maxLines5 = $dirty1;
                    interactionSource4 = interactionSource;
                }
                if ((262144 & i9) != 0) {
                    shape4 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall();
                    $dirty12 = maxLines4 & -234881025;
                } else {
                    shape4 = shape;
                    $dirty12 = maxLines4;
                }
                if ((i9 & 524288) != 0) {
                    Function2 placeholder5 = placeholder4;
                    z = true;
                    placeholder3 = placeholder5;
                    maxLines3 = maxLines5;
                    interactionSource3 = interactionSource4;
                    leadingIcon3 = leadingIcon4;
                    trailingIcon3 = trailingIcon4;
                    visualTransformation3 = visualTransformation4;
                    label3 = label4;
                    keyboardOptions3 = keyboardOptions4;
                    keyboardActions3 = keyboardActions4;
                    colors3 = TextFieldDefaults.INSTANCE.m1676outlinedTextFieldColorsdx8h9Zs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer3, 0, 0, 48, 2097151);
                    modifier3 = modifier6;
                    enabled3 = enabled5;
                    $dirty = $dirty2;
                    textStyle3 = textStyle4;
                    isError3 = isError4;
                    shape3 = shape4;
                    $dirty13 = $dirty12 & -1879048193;
                } else {
                    Function2 placeholder6 = placeholder4;
                    z = true;
                    placeholder3 = placeholder6;
                    maxLines3 = maxLines5;
                    interactionSource3 = interactionSource4;
                    leadingIcon3 = leadingIcon4;
                    trailingIcon3 = trailingIcon4;
                    visualTransformation3 = visualTransformation4;
                    label3 = label4;
                    keyboardOptions3 = keyboardOptions4;
                    keyboardActions3 = keyboardActions4;
                    modifier3 = modifier6;
                    enabled3 = enabled5;
                    $dirty = $dirty2;
                    colors3 = colors;
                    textStyle3 = textStyle4;
                    isError3 = isError4;
                    shape3 = shape4;
                    $dirty13 = $dirty12;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i9 & 32) != 0) {
                    i2 = -458753;
                    $dirty3 &= -458753;
                } else {
                    i2 = -458753;
                }
                if ((32768 & i9) != 0) {
                    $dirty13 &= i2;
                }
                if ((262144 & i9) != 0) {
                    $dirty13 &= -234881025;
                }
                if ((i9 & 524288) != 0) {
                    $dirty13 &= -1879048193;
                }
                modifier3 = modifier;
                enabled3 = enabled;
                readOnly2 = readOnly;
                textStyle3 = textStyle;
                label3 = label;
                placeholder3 = placeholder;
                leadingIcon3 = leadingIcon;
                trailingIcon3 = trailingIcon;
                isError3 = isError;
                visualTransformation3 = visualTransformation;
                keyboardOptions3 = keyboardOptions;
                keyboardActions3 = keyboardActions;
                singleLine2 = singleLine;
                maxLines3 = maxLines;
                minLines2 = minLines;
                interactionSource3 = interactionSource;
                shape3 = shape;
                colors3 = colors;
                $dirty = $dirty3;
                z = true;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-621914704, $dirty, $dirty13, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:133)");
            }
            $composer3.startReplaceableGroup(1961395213);
            ComposerKt.sourceInformation($composer3, "*157@8686L18");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle3.m5494getColor0d7_KjU();
            if ($this$takeOrElse_u2dDxMtmZc$iv != Color.Companion.m3200getUnspecified0d7_KjU() ? z : false) {
                textColor = $this$takeOrElse_u2dDxMtmZc$iv;
            } else {
                textColor = colors3.textColor(enabled3, $composer3, (($dirty >> 9) & 14) | (($dirty13 >> 24) & 112)).getValue().m3174unboximpl();
            }
            $composer3.endReplaceableGroup();
            TextStyle mergedTextStyle = textStyle3.merge(new TextStyle(textColor, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4194302, (DefaultConstructorMarker) null));
            if (label3 != null) {
                modifier4 = PaddingKt.m764paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier3, true, OutlinedTextFieldKt$OutlinedTextField$2.INSTANCE), 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, (Object) null);
            } else {
                modifier4 = modifier3;
            }
            int i32 = $dirty13;
            int $dirty4 = $dirty;
            colors2 = colors3;
            shape2 = shape3;
            isError2 = isError3;
            $composer2 = $composer3;
            textStyle2 = textStyle3;
            enabled2 = enabled3;
            modifier2 = modifier3;
            BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m814defaultMinSizeVpY3zN4(BackgroundKt.m448backgroundbw27NRU(modifier4, colors3.backgroundColor(enabled3, $composer3, (($dirty >> 9) & 14) | (($dirty13 >> 24) & 112)).getValue().m3174unboximpl(), shape3), TextFieldDefaults.INSTANCE.m1673getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1672getMinHeightD9Ej5fM()), enabled3, readOnly2, mergedTextStyle, keyboardOptions3, keyboardActions3, singleLine2, maxLines3, minLines2, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) null, interactionSource3, (Brush) new SolidColor(colors3.cursorColor(isError3, $composer3, ($dirty13 & 14) | (($dirty13 >> 24) & 112)).getValue().m3174unboximpl(), (DefaultConstructorMarker) null), (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer3, 1710364390, true, new OutlinedTextFieldKt$OutlinedTextField$3(value, enabled3, singleLine2, visualTransformation3, interactionSource3, isError3, label3, placeholder3, leadingIcon3, trailingIcon3, colors3, $dirty, $dirty13, shape3)), $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 7168) | ($dirty & 57344) | (($dirty13 << 12) & 3670016) | (($dirty13 << 12) & 29360128) | (($dirty13 << 12) & 234881024) | (($dirty13 << 12) & 1879048192), (($dirty13 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ($dirty13 & 112) | (($dirty13 >> 12) & 7168), 4096);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            keyboardOptions2 = keyboardOptions3;
            keyboardActions2 = keyboardActions3;
            maxLines2 = maxLines3;
            int i33 = $dirty4;
            placeholder2 = placeholder3;
            leadingIcon2 = leadingIcon3;
            trailingIcon2 = trailingIcon3;
            interactionSource2 = interactionSource3;
            visualTransformation2 = visualTransformation3;
            label2 = label3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new OutlinedTextFieldKt$OutlinedTextField$4(value, onValueChange, modifier2, enabled2, readOnly2, textStyle2, label2, placeholder2, leadingIcon2, trailingIcon2, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, minLines2, interactionSource2, shape2, colors2, $changed, $changed1, i));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v53, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r78v1, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: androidx.compose.ui.text.TextStyle} */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void OutlinedTextField(java.lang.String r71, kotlin.jvm.functions.Function1 r72, androidx.compose.ui.Modifier r73, boolean r74, boolean r75, androidx.compose.ui.text.TextStyle r76, kotlin.jvm.functions.Function2 r77, kotlin.jvm.functions.Function2 r78, kotlin.jvm.functions.Function2 r79, kotlin.jvm.functions.Function2 r80, boolean r81, androidx.compose.ui.text.input.VisualTransformation r82, androidx.compose.foundation.text.KeyboardOptions r83, androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, androidx.compose.foundation.interaction.MutableInteractionSource r87, androidx.compose.ui.graphics.Shape r88, androidx.compose.material.TextFieldColors r89, androidx.compose.runtime.Composer r90, int r91, int r92, int r93) {
        /*
            r15 = r71
            r14 = r72
            r13 = r91
            r12 = r92
            r11 = r93
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -2099955827(0xffffffff82d5378d, float:-3.1329422E-37)
            r1 = r90
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)229@11249L7,240@11809L39,241@11883L6,242@11945L25,244@11979L416:OutlinedTextField.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = r91
            r1 = r92
            r2 = r11 & 1
            if (r2 == 0) goto L_0x002f
            r0 = r0 | 6
            goto L_0x003d
        L_0x002f:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x003d
            boolean r2 = r10.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x003b
            r2 = 4
            goto L_0x003c
        L_0x003b:
            r2 = 2
        L_0x003c:
            r0 = r0 | r2
        L_0x003d:
            r2 = r11 & 2
            if (r2 == 0) goto L_0x0044
            r0 = r0 | 48
            goto L_0x0054
        L_0x0044:
            r2 = r13 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0054
            boolean r2 = r10.changedInstance(r14)
            if (r2 == 0) goto L_0x0051
            r2 = 32
            goto L_0x0053
        L_0x0051:
            r2 = 16
        L_0x0053:
            r0 = r0 | r2
        L_0x0054:
            r2 = r11 & 4
            if (r2 == 0) goto L_0x005d
            r0 = r0 | 384(0x180, float:5.38E-43)
            r9 = r73
            goto L_0x0073
        L_0x005d:
            r9 = r13 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0071
            r9 = r73
            boolean r16 = r10.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x006c
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r16 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r0 = r0 | r16
            goto L_0x0073
        L_0x0071:
            r9 = r73
        L_0x0073:
            r16 = r11 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0080
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r3 = r74
            goto L_0x0096
        L_0x0080:
            r3 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0094
            r3 = r74
            boolean r19 = r10.changed((boolean) r3)
            if (r19 == 0) goto L_0x008f
            r19 = r17
            goto L_0x0091
        L_0x008f:
            r19 = r18
        L_0x0091:
            r0 = r0 | r19
            goto L_0x0096
        L_0x0094:
            r3 = r74
        L_0x0096:
            r19 = r11 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            r64 = 57344(0xe000, float:8.0356E-41)
            if (r19 == 0) goto L_0x00a6
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r4 = r75
            goto L_0x00bc
        L_0x00a6:
            r22 = r13 & r64
            if (r22 != 0) goto L_0x00ba
            r4 = r75
            boolean r23 = r10.changed((boolean) r4)
            if (r23 == 0) goto L_0x00b5
            r23 = r20
            goto L_0x00b7
        L_0x00b5:
            r23 = r21
        L_0x00b7:
            r0 = r0 | r23
            goto L_0x00bc
        L_0x00ba:
            r4 = r75
        L_0x00bc:
            r65 = 458752(0x70000, float:6.42848E-40)
            r23 = r13 & r65
            r24 = 131072(0x20000, float:1.83671E-40)
            if (r23 != 0) goto L_0x00da
            r23 = r11 & 32
            if (r23 != 0) goto L_0x00d3
            r5 = r76
            boolean r25 = r10.changed((java.lang.Object) r5)
            if (r25 == 0) goto L_0x00d5
            r25 = r24
            goto L_0x00d7
        L_0x00d3:
            r5 = r76
        L_0x00d5:
            r25 = 65536(0x10000, float:9.18355E-41)
        L_0x00d7:
            r0 = r0 | r25
            goto L_0x00dc
        L_0x00da:
            r5 = r76
        L_0x00dc:
            r25 = r11 & 64
            r66 = 1572864(0x180000, float:2.204052E-39)
            r67 = 3670016(0x380000, float:5.142788E-39)
            if (r25 == 0) goto L_0x00e9
            r0 = r0 | r66
            r6 = r77
            goto L_0x00ff
        L_0x00e9:
            r26 = r13 & r67
            if (r26 != 0) goto L_0x00fd
            r6 = r77
            boolean r27 = r10.changedInstance(r6)
            if (r27 == 0) goto L_0x00f8
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fa
        L_0x00f8:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00fa:
            r0 = r0 | r27
            goto L_0x00ff
        L_0x00fd:
            r6 = r77
        L_0x00ff:
            r7 = r11 & 128(0x80, float:1.794E-43)
            r68 = 29360128(0x1c00000, float:7.052966E-38)
            if (r7 == 0) goto L_0x010c
            r28 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r28
            r8 = r78
            goto L_0x0122
        L_0x010c:
            r28 = r13 & r68
            if (r28 != 0) goto L_0x0120
            r8 = r78
            boolean r29 = r10.changedInstance(r8)
            if (r29 == 0) goto L_0x011b
            r29 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x011d
        L_0x011b:
            r29 = 4194304(0x400000, float:5.877472E-39)
        L_0x011d:
            r0 = r0 | r29
            goto L_0x0122
        L_0x0120:
            r8 = r78
        L_0x0122:
            r3 = r11 & 256(0x100, float:3.59E-43)
            r69 = 234881024(0xe000000, float:1.5777218E-30)
            if (r3 == 0) goto L_0x012f
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r29
            r4 = r79
            goto L_0x0145
        L_0x012f:
            r29 = r13 & r69
            if (r29 != 0) goto L_0x0143
            r4 = r79
            boolean r29 = r10.changedInstance(r4)
            if (r29 == 0) goto L_0x013e
            r29 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0140
        L_0x013e:
            r29 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0140:
            r0 = r0 | r29
            goto L_0x0145
        L_0x0143:
            r4 = r79
        L_0x0145:
            r4 = r11 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0150
            r29 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r29
            r5 = r80
            goto L_0x0168
        L_0x0150:
            r29 = 1879048192(0x70000000, float:1.58456325E29)
            r29 = r13 & r29
            if (r29 != 0) goto L_0x0166
            r5 = r80
            boolean r29 = r10.changedInstance(r5)
            if (r29 == 0) goto L_0x0161
            r29 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0163
        L_0x0161:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0163:
            r0 = r0 | r29
            goto L_0x0168
        L_0x0166:
            r5 = r80
        L_0x0168:
            r5 = r11 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x0171
            r1 = r1 | 6
            r6 = r81
            goto L_0x0187
        L_0x0171:
            r29 = r12 & 14
            if (r29 != 0) goto L_0x0185
            r6 = r81
            boolean r29 = r10.changed((boolean) r6)
            if (r29 == 0) goto L_0x0180
            r22 = 4
            goto L_0x0182
        L_0x0180:
            r22 = 2
        L_0x0182:
            r1 = r1 | r22
            goto L_0x0187
        L_0x0185:
            r6 = r81
        L_0x0187:
            r6 = r11 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0190
            r1 = r1 | 48
            r8 = r82
            goto L_0x01a6
        L_0x0190:
            r22 = r12 & 112(0x70, float:1.57E-43)
            if (r22 != 0) goto L_0x01a4
            r8 = r82
            boolean r22 = r10.changed((java.lang.Object) r8)
            if (r22 == 0) goto L_0x019f
            r26 = 32
            goto L_0x01a1
        L_0x019f:
            r26 = 16
        L_0x01a1:
            r1 = r1 | r26
            goto L_0x01a6
        L_0x01a4:
            r8 = r82
        L_0x01a6:
            r8 = r11 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x01af
            r1 = r1 | 384(0x180, float:5.38E-43)
            r9 = r83
            goto L_0x01c5
        L_0x01af:
            r9 = r12 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x01c3
            r9 = r83
            boolean r22 = r10.changed((java.lang.Object) r9)
            if (r22 == 0) goto L_0x01be
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x01c0
        L_0x01be:
            r27 = 128(0x80, float:1.794E-43)
        L_0x01c0:
            r1 = r1 | r27
            goto L_0x01c5
        L_0x01c3:
            r9 = r83
        L_0x01c5:
            r9 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r9 == 0) goto L_0x01ce
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r14 = r84
            goto L_0x01e2
        L_0x01ce:
            r14 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r14 != 0) goto L_0x01e0
            r14 = r84
            boolean r22 = r10.changed((java.lang.Object) r14)
            if (r22 == 0) goto L_0x01db
            goto L_0x01dd
        L_0x01db:
            r17 = r18
        L_0x01dd:
            r1 = r1 | r17
            goto L_0x01e2
        L_0x01e0:
            r14 = r84
        L_0x01e2:
            r14 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r14 == 0) goto L_0x01eb
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r15 = r85
            goto L_0x01ff
        L_0x01eb:
            r17 = r12 & r64
            if (r17 != 0) goto L_0x01fd
            r15 = r85
            boolean r17 = r10.changed((boolean) r15)
            if (r17 == 0) goto L_0x01f8
            goto L_0x01fa
        L_0x01f8:
            r20 = r21
        L_0x01fa:
            r1 = r1 | r20
            goto L_0x01ff
        L_0x01fd:
            r15 = r85
        L_0x01ff:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r11 & r17
            if (r17 == 0) goto L_0x020d
            r18 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r18
            r15 = r86
            goto L_0x0223
        L_0x020d:
            r18 = r12 & r65
            if (r18 != 0) goto L_0x0221
            r15 = r86
            boolean r18 = r10.changed((int) r15)
            if (r18 == 0) goto L_0x021c
            r18 = r24
            goto L_0x021e
        L_0x021c:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x021e:
            r1 = r1 | r18
            goto L_0x0223
        L_0x0221:
            r15 = r86
        L_0x0223:
            r18 = 65536(0x10000, float:9.18355E-41)
            r18 = r11 & r18
            if (r18 == 0) goto L_0x022e
            r1 = r1 | r66
            r15 = r87
            goto L_0x0244
        L_0x022e:
            r20 = r12 & r67
            if (r20 != 0) goto L_0x0242
            r15 = r87
            boolean r20 = r10.changed((java.lang.Object) r15)
            if (r20 == 0) goto L_0x023d
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x023f
        L_0x023d:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x023f:
            r1 = r1 | r20
            goto L_0x0244
        L_0x0242:
            r15 = r87
        L_0x0244:
            r20 = r12 & r68
            if (r20 != 0) goto L_0x025e
            r20 = r11 & r24
            if (r20 != 0) goto L_0x0257
            r15 = r88
            boolean r20 = r10.changed((java.lang.Object) r15)
            if (r20 == 0) goto L_0x0259
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x025b
        L_0x0257:
            r15 = r88
        L_0x0259:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x025b:
            r1 = r1 | r20
            goto L_0x0260
        L_0x025e:
            r15 = r88
        L_0x0260:
            r20 = r12 & r69
            if (r20 != 0) goto L_0x027c
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r11 & r20
            if (r20 != 0) goto L_0x0275
            r12 = r89
            boolean r20 = r10.changed((java.lang.Object) r12)
            if (r20 == 0) goto L_0x0277
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0279
        L_0x0275:
            r12 = r89
        L_0x0277:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0279:
            r1 = r1 | r20
            goto L_0x027e
        L_0x027c:
            r12 = r89
        L_0x027e:
            r20 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r12 = r0 & r20
            r15 = 306783378(0x12492492, float:6.3469493E-28)
            if (r12 != r15) goto L_0x02c5
            r12 = 191739611(0xb6db6db, float:4.5782105E-32)
            r12 = r12 & r1
            r15 = 38347922(0x2492492, float:1.4777643E-37)
            if (r12 != r15) goto L_0x02c5
            boolean r12 = r10.getSkipping()
            if (r12 != 0) goto L_0x0298
            goto L_0x02c5
        L_0x0298:
            r10.skipToGroupEnd()
            r24 = r73
            r25 = r74
            r26 = r75
            r27 = r76
            r28 = r77
            r29 = r78
            r30 = r79
            r31 = r80
            r32 = r81
            r33 = r82
            r34 = r83
            r35 = r84
            r36 = r85
            r37 = r86
            r38 = r87
            r39 = r88
            r40 = r89
            r43 = r0
            r42 = r1
            r41 = r10
            goto L_0x056d
        L_0x02c5:
            r10.startDefaults()
            r12 = r13 & 1
            if (r12 == 0) goto L_0x033c
            boolean r12 = r10.getDefaultsInvalid()
            if (r12 == 0) goto L_0x02d4
            goto L_0x033c
        L_0x02d4:
            r10.skipToGroupEnd()
            r2 = r11 & 32
            if (r2 == 0) goto L_0x02df
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r2
        L_0x02df:
            r2 = r11 & r24
            if (r2 == 0) goto L_0x02e7
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r2
        L_0x02e7:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r11
            if (r2 == 0) goto L_0x0316
            r2 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r2
            r24 = r73
            r25 = r74
            r26 = r75
            r27 = r76
            r28 = r77
            r29 = r78
            r30 = r79
            r31 = r80
            r32 = r81
            r33 = r82
            r34 = r83
            r35 = r84
            r36 = r85
            r37 = r86
            r38 = r87
            r39 = r88
            r40 = r89
            r15 = r0
            r14 = r1
            goto L_0x04c9
        L_0x0316:
            r24 = r73
            r25 = r74
            r26 = r75
            r27 = r76
            r28 = r77
            r29 = r78
            r30 = r79
            r31 = r80
            r32 = r81
            r33 = r82
            r34 = r83
            r35 = r84
            r36 = r85
            r37 = r86
            r38 = r87
            r39 = r88
            r40 = r89
            r15 = r0
            r14 = r1
            goto L_0x04c9
        L_0x033c:
            if (r2 == 0) goto L_0x0343
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0345
        L_0x0343:
            r2 = r73
        L_0x0345:
            if (r16 == 0) goto L_0x0349
            r12 = 1
            goto L_0x034b
        L_0x0349:
            r12 = r74
        L_0x034b:
            if (r19 == 0) goto L_0x034f
            r15 = 0
            goto L_0x0351
        L_0x034f:
            r15 = r75
        L_0x0351:
            r16 = r11 & 32
            if (r16 == 0) goto L_0x037c
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.material.TextKt.getLocalTextStyle()
            r73 = r2
            r2 = r16
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r16 = 6
            r19 = 0
            r74 = r12
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r13 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r12, r13)
            java.lang.Object r12 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r2 = r12
            androidx.compose.ui.text.TextStyle r2 = (androidx.compose.ui.text.TextStyle) r2
            r12 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r12
            goto L_0x0382
        L_0x037c:
            r73 = r2
            r74 = r12
            r2 = r76
        L_0x0382:
            if (r25 == 0) goto L_0x0386
            r12 = 0
            goto L_0x0388
        L_0x0386:
            r12 = r77
        L_0x0388:
            if (r7 == 0) goto L_0x038c
            r7 = 0
            goto L_0x038e
        L_0x038c:
            r7 = r78
        L_0x038e:
            if (r3 == 0) goto L_0x0392
            r3 = 0
            goto L_0x0394
        L_0x0392:
            r3 = r79
        L_0x0394:
            if (r4 == 0) goto L_0x0398
            r4 = 0
            goto L_0x039a
        L_0x0398:
            r4 = r80
        L_0x039a:
            if (r5 == 0) goto L_0x039e
            r5 = 0
            goto L_0x03a0
        L_0x039e:
            r5 = r81
        L_0x03a0:
            if (r6 == 0) goto L_0x03a9
            androidx.compose.ui.text.input.VisualTransformation$Companion r6 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r6 = r6.getNone()
            goto L_0x03ab
        L_0x03a9:
            r6 = r82
        L_0x03ab:
            if (r8 == 0) goto L_0x03b4
            androidx.compose.foundation.text.KeyboardOptions$Companion r8 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r8 = r8.getDefault()
            goto L_0x03b6
        L_0x03b4:
            r8 = r83
        L_0x03b6:
            if (r9 == 0) goto L_0x03bf
            androidx.compose.foundation.text.KeyboardActions$Companion r9 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r9 = r9.getDefault()
            goto L_0x03c1
        L_0x03bf:
            r9 = r84
        L_0x03c1:
            if (r14 == 0) goto L_0x03c5
            r13 = 0
            goto L_0x03c7
        L_0x03c5:
            r13 = r85
        L_0x03c7:
            if (r17 == 0) goto L_0x03cd
            r14 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x03cf
        L_0x03cd:
            r14 = r86
        L_0x03cf:
            if (r18 == 0) goto L_0x0417
            r16 = 0
            r17 = 0
            r75 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = 0
            r76 = r10
            r18 = 0
            r77 = r0
            java.lang.Object r0 = r76.rememberedValue()
            r19 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r90 = r2
            java.lang.Object r2 = r20.getEmpty()
            if (r0 != r2) goto L_0x0408
            r2 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r78 = r0
            r0 = r76
            r0.updateRememberedValue(r2)
            goto L_0x040e
        L_0x0408:
            r78 = r0
            r0 = r76
            r2 = r78
        L_0x040e:
            r10.endReplaceableGroup()
            r0 = r2
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x041d
        L_0x0417:
            r75 = r0
            r90 = r2
            r0 = r87
        L_0x041d:
            r2 = r11 & r24
            if (r2 == 0) goto L_0x0435
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r76 = r0
            r0 = 6
            androidx.compose.material.Shapes r0 = r2.getShapes(r10, r0)
            androidx.compose.foundation.shape.CornerBasedShape r0 = r0.getSmall()
            androidx.compose.ui.graphics.Shape r0 = (androidx.compose.ui.graphics.Shape) r0
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r2
            goto L_0x0439
        L_0x0435:
            r76 = r0
            r0 = r88
        L_0x0439:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r11
            if (r2 == 0) goto L_0x04a4
            androidx.compose.material.TextFieldDefaults r16 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r39 = 0
            r41 = 0
            r43 = 0
            r45 = 0
            r47 = 0
            r49 = 0
            r51 = 0
            r53 = 0
            r55 = 0
            r57 = 0
            r60 = 0
            r61 = 0
            r62 = 48
            r63 = 2097151(0x1fffff, float:2.938734E-39)
            r59 = r10
            androidx.compose.material.TextFieldColors r2 = r16.m1676outlinedTextFieldColorsdx8h9Zs(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r60, r61, r62, r63)
            r16 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r16
            r24 = r73
            r25 = r74
            r38 = r76
            r27 = r90
            r39 = r0
            r40 = r2
            r30 = r3
            r31 = r4
            r32 = r5
            r33 = r6
            r29 = r7
            r34 = r8
            r35 = r9
            r28 = r12
            r36 = r13
            r37 = r14
            r26 = r15
            r15 = r75
            r14 = r1
            goto L_0x04c9
        L_0x04a4:
            r24 = r73
            r25 = r74
            r38 = r76
            r40 = r89
            r27 = r90
            r39 = r0
            r30 = r3
            r31 = r4
            r32 = r5
            r33 = r6
            r29 = r7
            r34 = r8
            r35 = r9
            r28 = r12
            r36 = r13
            r37 = r14
            r26 = r15
            r15 = r75
            r14 = r1
        L_0x04c9:
            r10.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x04da
            r0 = -2099955827(0xffffffff82d5378d, float:-3.1329422E-37)
            java.lang.String r1 = "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:223)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r15, r14, r1)
        L_0x04da:
            r16 = 1
            r0 = r15 & 14
            r1 = r15 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r15 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r15 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = r15 & r64
            r0 = r0 | r1
            r1 = r15 & r65
            r0 = r0 | r1
            r1 = r15 & r67
            r0 = r0 | r1
            r1 = r15 & r68
            r0 = r0 | r1
            r1 = r15 & r69
            r0 = r0 | r1
            r1 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r15
            r21 = r0 | r1
            r0 = r14 & 14
            r0 = r0 | r66
            r1 = r14 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r14 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r14 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = r14 & r64
            r0 = r0 | r1
            r1 = r14 & r65
            r0 = r0 | r1
            int r1 = r14 << 3
            r1 = r1 & r68
            r0 = r0 | r1
            int r1 = r14 << 3
            r1 = r1 & r69
            r0 = r0 | r1
            int r1 = r14 << 3
            r2 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r2
            r22 = r0 | r1
            r23 = 0
            r0 = r71
            r1 = r72
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r27
            r6 = r28
            r7 = r29
            r8 = r30
            r9 = r31
            r41 = r10
            r10 = r32
            r11 = r33
            r12 = r34
            r13 = r35
            r42 = r14
            r14 = r36
            r43 = r15
            r15 = r37
            r17 = r38
            r18 = r39
            r19 = r40
            r20 = r41
            OutlinedTextField((java.lang.String) r0, (kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r6, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r7, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r8, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r9, (boolean) r10, (androidx.compose.ui.text.input.VisualTransformation) r11, (androidx.compose.foundation.text.KeyboardOptions) r12, (androidx.compose.foundation.text.KeyboardActions) r13, (boolean) r14, (int) r15, (int) r16, (androidx.compose.foundation.interaction.MutableInteractionSource) r17, (androidx.compose.ui.graphics.Shape) r18, (androidx.compose.material.TextFieldColors) r19, (androidx.compose.runtime.Composer) r20, (int) r21, (int) r22, (int) r23)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x056d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x056d:
            androidx.compose.runtime.ScopeUpdateScope r15 = r41.endRestartGroup()
            if (r15 != 0) goto L_0x0574
            goto L_0x05b2
        L_0x0574:
            androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$6 r23 = new androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$6
            r0 = r23
            r1 = r71
            r2 = r72
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r27
            r7 = r28
            r8 = r29
            r9 = r30
            r10 = r31
            r11 = r32
            r12 = r33
            r13 = r34
            r14 = r35
            r70 = r15
            r15 = r36
            r16 = r37
            r17 = r38
            r18 = r39
            r19 = r40
            r20 = r91
            r21 = r92
            r22 = r93
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = r23
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r70
            r1.updateScope(r0)
        L_0x05b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:146:0x01d7, code lost:
        if (r7.changed((java.lang.Object) r84) != false) goto L_0x01de;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue r71, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r72, androidx.compose.ui.Modifier r73, boolean r74, boolean r75, androidx.compose.ui.text.TextStyle r76, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r79, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r80, boolean r81, androidx.compose.ui.text.input.VisualTransformation r82, androidx.compose.foundation.text.KeyboardOptions r83, androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, int r87, androidx.compose.foundation.interaction.MutableInteractionSource r88, androidx.compose.ui.graphics.Shape r89, androidx.compose.material.TextFieldColors r90, androidx.compose.runtime.Composer r91, int r92, int r93, int r94) {
        /*
            r13 = r71
            r11 = r72
            r10 = r92
            r9 = r93
            r8 = r94
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 237745923(0xe2bb703, float:2.1165494E-30)
            r1 = r91
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(OutlinedTextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)340@17319L7,352@17919L39,353@17997L22,354@18069L25,374@18840L24,383@19206L20,363@18397L2056:OutlinedTextField.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            r0 = r92
            r1 = r93
            r2 = r8 & 1
            if (r2 == 0) goto L_0x002f
            r0 = r0 | 6
            goto L_0x003d
        L_0x002f:
            r2 = r10 & 14
            if (r2 != 0) goto L_0x003d
            boolean r2 = r7.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x003b
            r2 = 4
            goto L_0x003c
        L_0x003b:
            r2 = 2
        L_0x003c:
            r0 = r0 | r2
        L_0x003d:
            r2 = r8 & 2
            if (r2 == 0) goto L_0x0044
            r0 = r0 | 48
            goto L_0x0054
        L_0x0044:
            r2 = r10 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0054
            boolean r2 = r7.changedInstance(r11)
            if (r2 == 0) goto L_0x0051
            r2 = 32
            goto L_0x0053
        L_0x0051:
            r2 = 16
        L_0x0053:
            r0 = r0 | r2
        L_0x0054:
            r2 = r8 & 4
            if (r2 == 0) goto L_0x005d
            r0 = r0 | 384(0x180, float:5.38E-43)
            r15 = r73
            goto L_0x0073
        L_0x005d:
            r15 = r10 & 896(0x380, float:1.256E-42)
            if (r15 != 0) goto L_0x0071
            r15 = r73
            boolean r16 = r7.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x006c
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r16 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r0 = r0 | r16
            goto L_0x0073
        L_0x0071:
            r15 = r73
        L_0x0073:
            r16 = r8 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0080
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r3 = r74
            goto L_0x0096
        L_0x0080:
            r3 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0094
            r3 = r74
            boolean r19 = r7.changed((boolean) r3)
            if (r19 == 0) goto L_0x008f
            r19 = r17
            goto L_0x0091
        L_0x008f:
            r19 = r18
        L_0x0091:
            r0 = r0 | r19
            goto L_0x0096
        L_0x0094:
            r3 = r74
        L_0x0096:
            r19 = r8 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r62 = 57344(0xe000, float:8.0356E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x00a6
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r4 = r75
            goto L_0x00bc
        L_0x00a6:
            r22 = r10 & r62
            if (r22 != 0) goto L_0x00ba
            r4 = r75
            boolean r23 = r7.changed((boolean) r4)
            if (r23 == 0) goto L_0x00b5
            r23 = r20
            goto L_0x00b7
        L_0x00b5:
            r23 = r21
        L_0x00b7:
            r0 = r0 | r23
            goto L_0x00bc
        L_0x00ba:
            r4 = r75
        L_0x00bc:
            r23 = 458752(0x70000, float:6.42848E-40)
            r23 = r10 & r23
            r24 = 131072(0x20000, float:1.83671E-40)
            r25 = 65536(0x10000, float:9.18355E-41)
            if (r23 != 0) goto L_0x00dc
            r23 = r8 & 32
            if (r23 != 0) goto L_0x00d5
            r5 = r76
            boolean r26 = r7.changed((java.lang.Object) r5)
            if (r26 == 0) goto L_0x00d7
            r26 = r24
            goto L_0x00d9
        L_0x00d5:
            r5 = r76
        L_0x00d7:
            r26 = r25
        L_0x00d9:
            r0 = r0 | r26
            goto L_0x00de
        L_0x00dc:
            r5 = r76
        L_0x00de:
            r26 = r8 & 64
            r63 = 3670016(0x380000, float:5.142788E-39)
            r27 = 524288(0x80000, float:7.34684E-40)
            if (r26 == 0) goto L_0x00ed
            r28 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r28
            r6 = r77
            goto L_0x0103
        L_0x00ed:
            r28 = r10 & r63
            if (r28 != 0) goto L_0x0101
            r6 = r77
            boolean r29 = r7.changedInstance(r6)
            if (r29 == 0) goto L_0x00fc
            r29 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fe
        L_0x00fc:
            r29 = r27
        L_0x00fe:
            r0 = r0 | r29
            goto L_0x0103
        L_0x0101:
            r6 = r77
        L_0x0103:
            r12 = r8 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x010e
            r30 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r30
            r14 = r78
            goto L_0x0126
        L_0x010e:
            r30 = 29360128(0x1c00000, float:7.052966E-38)
            r30 = r10 & r30
            if (r30 != 0) goto L_0x0124
            r14 = r78
            boolean r31 = r7.changedInstance(r14)
            if (r31 == 0) goto L_0x011f
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0121
        L_0x011f:
            r31 = 4194304(0x400000, float:5.877472E-39)
        L_0x0121:
            r0 = r0 | r31
            goto L_0x0126
        L_0x0124:
            r14 = r78
        L_0x0126:
            r3 = r8 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0131
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r31
            r4 = r79
            goto L_0x0149
        L_0x0131:
            r31 = 234881024(0xe000000, float:1.5777218E-30)
            r31 = r10 & r31
            if (r31 != 0) goto L_0x0147
            r4 = r79
            boolean r31 = r7.changedInstance(r4)
            if (r31 == 0) goto L_0x0142
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0144
        L_0x0142:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0144:
            r0 = r0 | r31
            goto L_0x0149
        L_0x0147:
            r4 = r79
        L_0x0149:
            r4 = r8 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0154
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r31
            r5 = r80
            goto L_0x016c
        L_0x0154:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r10 & r31
            if (r31 != 0) goto L_0x016a
            r5 = r80
            boolean r31 = r7.changedInstance(r5)
            if (r31 == 0) goto L_0x0165
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0167
        L_0x0165:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0167:
            r0 = r0 | r31
            goto L_0x016c
        L_0x016a:
            r5 = r80
        L_0x016c:
            r5 = r8 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x0175
            r1 = r1 | 6
            r6 = r81
            goto L_0x018b
        L_0x0175:
            r31 = r9 & 14
            if (r31 != 0) goto L_0x0189
            r6 = r81
            boolean r31 = r7.changed((boolean) r6)
            if (r31 == 0) goto L_0x0184
            r22 = 4
            goto L_0x0186
        L_0x0184:
            r22 = 2
        L_0x0186:
            r1 = r1 | r22
            goto L_0x018b
        L_0x0189:
            r6 = r81
        L_0x018b:
            r6 = r8 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0194
            r1 = r1 | 48
            r11 = r82
            goto L_0x01aa
        L_0x0194:
            r22 = r9 & 112(0x70, float:1.57E-43)
            if (r22 != 0) goto L_0x01a8
            r11 = r82
            boolean r22 = r7.changed((java.lang.Object) r11)
            if (r22 == 0) goto L_0x01a3
            r28 = 32
            goto L_0x01a5
        L_0x01a3:
            r28 = 16
        L_0x01a5:
            r1 = r1 | r28
            goto L_0x01aa
        L_0x01a8:
            r11 = r82
        L_0x01aa:
            r11 = r8 & 4096(0x1000, float:5.74E-42)
            if (r11 == 0) goto L_0x01b3
            r1 = r1 | 384(0x180, float:5.38E-43)
            r13 = r83
            goto L_0x01c9
        L_0x01b3:
            r13 = r9 & 896(0x380, float:1.256E-42)
            if (r13 != 0) goto L_0x01c7
            r13 = r83
            boolean r22 = r7.changed((java.lang.Object) r13)
            if (r22 == 0) goto L_0x01c2
            r29 = 256(0x100, float:3.59E-43)
            goto L_0x01c4
        L_0x01c2:
            r29 = 128(0x80, float:1.794E-43)
        L_0x01c4:
            r1 = r1 | r29
            goto L_0x01c9
        L_0x01c7:
            r13 = r83
        L_0x01c9:
            r13 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r13 != 0) goto L_0x01e1
            r13 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r13 != 0) goto L_0x01da
            r13 = r84
            boolean r22 = r7.changed((java.lang.Object) r13)
            if (r22 == 0) goto L_0x01dc
            goto L_0x01de
        L_0x01da:
            r13 = r84
        L_0x01dc:
            r17 = r18
        L_0x01de:
            r1 = r1 | r17
            goto L_0x01e3
        L_0x01e1:
            r13 = r84
        L_0x01e3:
            r13 = r8 & 16384(0x4000, float:2.2959E-41)
            if (r13 == 0) goto L_0x01ec
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r14 = r85
            goto L_0x0200
        L_0x01ec:
            r17 = r9 & r62
            if (r17 != 0) goto L_0x01fe
            r14 = r85
            boolean r17 = r7.changed((boolean) r14)
            if (r17 == 0) goto L_0x01f9
            goto L_0x01fb
        L_0x01f9:
            r20 = r21
        L_0x01fb:
            r1 = r1 | r20
            goto L_0x0200
        L_0x01fe:
            r14 = r85
        L_0x0200:
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r9 & r17
            if (r17 != 0) goto L_0x021f
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r8 & r17
            if (r17 != 0) goto L_0x0218
            r14 = r86
            boolean r17 = r7.changed((int) r14)
            if (r17 == 0) goto L_0x021a
            r17 = r24
            goto L_0x021c
        L_0x0218:
            r14 = r86
        L_0x021a:
            r17 = r25
        L_0x021c:
            r1 = r1 | r17
            goto L_0x0221
        L_0x021f:
            r14 = r86
        L_0x0221:
            r17 = r8 & r25
            if (r17 == 0) goto L_0x022c
            r18 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r18
            r14 = r87
            goto L_0x0242
        L_0x022c:
            r18 = r9 & r63
            if (r18 != 0) goto L_0x0240
            r14 = r87
            boolean r18 = r7.changed((int) r14)
            if (r18 == 0) goto L_0x023b
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x023d
        L_0x023b:
            r18 = r27
        L_0x023d:
            r1 = r1 | r18
            goto L_0x0242
        L_0x0240:
            r14 = r87
        L_0x0242:
            r18 = r8 & r24
            if (r18 == 0) goto L_0x024d
            r20 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r20
            r14 = r88
            goto L_0x0265
        L_0x024d:
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            r20 = r9 & r20
            if (r20 != 0) goto L_0x0263
            r14 = r88
            boolean r20 = r7.changed((java.lang.Object) r14)
            if (r20 == 0) goto L_0x025e
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0260
        L_0x025e:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x0260:
            r1 = r1 | r20
            goto L_0x0265
        L_0x0263:
            r14 = r88
        L_0x0265:
            r20 = 234881024(0xe000000, float:1.5777218E-30)
            r20 = r9 & r20
            if (r20 != 0) goto L_0x0283
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r8 & r20
            if (r20 != 0) goto L_0x027c
            r14 = r89
            boolean r20 = r7.changed((java.lang.Object) r14)
            if (r20 == 0) goto L_0x027e
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0280
        L_0x027c:
            r14 = r89
        L_0x027e:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0280:
            r1 = r1 | r20
            goto L_0x0285
        L_0x0283:
            r14 = r89
        L_0x0285:
            r20 = 1879048192(0x70000000, float:1.58456325E29)
            r20 = r9 & r20
            if (r20 != 0) goto L_0x02a1
            r20 = r8 & r27
            if (r20 != 0) goto L_0x029a
            r15 = r90
            boolean r20 = r7.changed((java.lang.Object) r15)
            if (r20 == 0) goto L_0x029c
            r20 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x029e
        L_0x029a:
            r15 = r90
        L_0x029c:
            r20 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x029e:
            r1 = r1 | r20
            goto L_0x02a3
        L_0x02a1:
            r15 = r90
        L_0x02a3:
            r20 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r9 = r0 & r20
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r14) goto L_0x02ec
            r9 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r9 = r9 & r1
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r14) goto L_0x02ec
            boolean r9 = r7.getSkipping()
            if (r9 != 0) goto L_0x02bd
            goto L_0x02ec
        L_0x02bd:
            r7.skipToGroupEnd()
            r38 = r73
            r37 = r74
            r64 = r75
            r36 = r76
            r65 = r77
            r24 = r78
            r25 = r79
            r26 = r80
            r34 = r81
            r27 = r82
            r28 = r83
            r29 = r84
            r30 = r85
            r66 = r86
            r67 = r87
            r31 = r88
            r33 = r89
            r39 = r0
            r68 = r1
            r35 = r7
            r32 = r15
            goto L_0x06c4
        L_0x02ec:
            r7.startDefaults()
            r9 = r10 & 1
            r14 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r9 == 0) goto L_0x034b
            boolean r9 = r7.getDefaultsInvalid()
            if (r9 == 0) goto L_0x02fd
            goto L_0x034b
        L_0x02fd:
            r7.skipToGroupEnd()
            r2 = r8 & 32
            if (r2 == 0) goto L_0x0305
            r0 = r0 & r14
        L_0x0305:
            r2 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x030b
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x030b:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r8
            if (r2 == 0) goto L_0x0312
            r1 = r1 & r14
        L_0x0312:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r8
            if (r2 == 0) goto L_0x031b
            r2 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r2
        L_0x031b:
            r2 = r8 & r27
            if (r2 == 0) goto L_0x0323
            r2 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r1 = r1 & r2
        L_0x0323:
            r13 = r73
            r11 = r74
            r64 = r75
            r9 = r76
            r65 = r77
            r20 = r78
            r21 = r79
            r22 = r80
            r6 = r81
            r23 = r82
            r24 = r83
            r25 = r84
            r26 = r85
            r66 = r86
            r67 = r87
            r27 = r88
            r5 = r89
            r4 = r90
            r3 = r0
            r12 = 1
            goto L_0x0504
        L_0x034b:
            if (r2 == 0) goto L_0x0352
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0354
        L_0x0352:
            r2 = r73
        L_0x0354:
            if (r16 == 0) goto L_0x0358
            r9 = 1
            goto L_0x035a
        L_0x0358:
            r9 = r74
        L_0x035a:
            if (r19 == 0) goto L_0x0361
            r16 = 0
            r64 = r16
            goto L_0x0363
        L_0x0361:
            r64 = r75
        L_0x0363:
            r16 = r8 & 32
            if (r16 == 0) goto L_0x038b
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.material.TextKt.getLocalTextStyle()
            r15 = r16
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            r16 = 6
            r19 = 0
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            r73 = r2
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r14, r2)
            java.lang.Object r2 = r7.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.ui.text.TextStyle r2 = (androidx.compose.ui.text.TextStyle) r2
            r14 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r14
            goto L_0x038f
        L_0x038b:
            r73 = r2
            r2 = r76
        L_0x038f:
            if (r26 == 0) goto L_0x0395
            r14 = 0
            r65 = r14
            goto L_0x0397
        L_0x0395:
            r65 = r77
        L_0x0397:
            if (r12 == 0) goto L_0x039b
            r12 = 0
            goto L_0x039d
        L_0x039b:
            r12 = r78
        L_0x039d:
            if (r3 == 0) goto L_0x03a1
            r3 = 0
            goto L_0x03a3
        L_0x03a1:
            r3 = r79
        L_0x03a3:
            if (r4 == 0) goto L_0x03a7
            r4 = 0
            goto L_0x03a9
        L_0x03a7:
            r4 = r80
        L_0x03a9:
            if (r5 == 0) goto L_0x03ad
            r5 = 0
            goto L_0x03af
        L_0x03ad:
            r5 = r81
        L_0x03af:
            if (r6 == 0) goto L_0x03b8
            androidx.compose.ui.text.input.VisualTransformation$Companion r6 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r6 = r6.getNone()
            goto L_0x03ba
        L_0x03b8:
            r6 = r82
        L_0x03ba:
            if (r11 == 0) goto L_0x03c3
            androidx.compose.foundation.text.KeyboardOptions$Companion r11 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r11 = r11.getDefault()
            goto L_0x03c5
        L_0x03c3:
            r11 = r83
        L_0x03c5:
            r14 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x03f7
            androidx.compose.foundation.text.KeyboardActions r14 = new androidx.compose.foundation.text.KeyboardActions
            r15 = 0
            r16 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 63
            r25 = 0
            r74 = r14
            r75 = r15
            r76 = r16
            r77 = r19
            r78 = r21
            r79 = r22
            r80 = r23
            r81 = r24
            r82 = r25
            r74.<init>(r75, r76, r77, r78, r79, r80, r81, r82)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r70 = r14
            r14 = r1
            r1 = r70
            goto L_0x03fa
        L_0x03f7:
            r14 = r1
            r1 = r84
        L_0x03fa:
            if (r13 == 0) goto L_0x03fe
            r13 = 0
            goto L_0x0400
        L_0x03fe:
            r13 = r85
        L_0x0400:
            r15 = 32768(0x8000, float:4.5918E-41)
            r15 = r15 & r8
            if (r15 == 0) goto L_0x0415
            if (r13 == 0) goto L_0x040a
            r15 = 1
            goto L_0x040d
        L_0x040a:
            r15 = 2147483647(0x7fffffff, float:NaN)
        L_0x040d:
            r16 = -458753(0xfffffffffff8ffff, float:NaN)
            r14 = r14 & r16
            r66 = r15
            goto L_0x0417
        L_0x0415:
            r66 = r86
        L_0x0417:
            if (r17 == 0) goto L_0x041d
            r15 = 1
            r67 = r15
            goto L_0x041f
        L_0x041d:
            r67 = r87
        L_0x041f:
            if (r18 == 0) goto L_0x0466
            r15 = 0
            r16 = 0
            r74 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r7.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            r0 = 0
            r75 = r7
            r17 = 0
            r76 = r0
            java.lang.Object r0 = r75.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r77 = r1
            java.lang.Object r1 = r19.getEmpty()
            if (r0 != r1) goto L_0x0457
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r78 = r0
            r0 = r75
            r0.updateRememberedValue(r1)
            goto L_0x045d
        L_0x0457:
            r78 = r0
            r0 = r75
            r1 = r78
        L_0x045d:
            r7.endReplaceableGroup()
            r0 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x046c
        L_0x0466:
            r74 = r0
            r77 = r1
            r0 = r88
        L_0x046c:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r8
            if (r1 == 0) goto L_0x047f
            androidx.compose.material.TextFieldDefaults r1 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r15 = 6
            androidx.compose.ui.graphics.Shape r1 = r1.getOutlinedTextFieldShape(r7, r15)
            r15 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r14 = r14 & r15
            r68 = r14
            goto L_0x0483
        L_0x047f:
            r1 = r89
            r68 = r14
        L_0x0483:
            r14 = r8 & r27
            if (r14 == 0) goto L_0x04e5
            androidx.compose.material.TextFieldDefaults r14 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r15 = 0
            r75 = r12
            r12 = 1
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r39 = 0
            r41 = 0
            r43 = 0
            r45 = 0
            r47 = 0
            r49 = 0
            r51 = 0
            r53 = 0
            r55 = 0
            r58 = 0
            r59 = 0
            r60 = 48
            r61 = 2097151(0x1fffff, float:2.938734E-39)
            r57 = r7
            androidx.compose.material.TextFieldColors r14 = r14.m1676outlinedTextFieldColorsdx8h9Zs(r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r58, r59, r60, r61)
            r15 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r15 = r68 & r15
            r20 = r75
            r25 = r77
            r27 = r0
            r21 = r3
            r22 = r4
            r23 = r6
            r24 = r11
            r26 = r13
            r4 = r14
            r13 = r73
            r3 = r74
            r6 = r5
            r11 = r9
            r5 = r1
            r9 = r2
            r1 = r15
            goto L_0x0504
        L_0x04e5:
            r75 = r12
            r12 = 1
            r20 = r75
            r25 = r77
            r27 = r0
            r21 = r3
            r22 = r4
            r23 = r6
            r24 = r11
            r26 = r13
            r13 = r73
            r3 = r74
            r4 = r90
            r6 = r5
            r11 = r9
            r5 = r1
            r9 = r2
            r1 = r68
        L_0x0504:
            r7.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0515
            r0 = 237745923(0xe2bb703, float:2.1165494E-30)
            java.lang.String r2 = "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:334)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r1, r2)
        L_0x0515:
            r0 = 1961404773(0x74e8a965, float:1.4746687E32)
            r7.startReplaceableGroup(r0)
            java.lang.String r0 = "*358@18246L18"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            long r14 = r9.m5494getColor0d7_KjU()
            r0 = 0
            r16 = r14
            r2 = 0
            androidx.compose.ui.graphics.Color$Companion r18 = androidx.compose.ui.graphics.Color.Companion
            long r18 = r18.m3200getUnspecified0d7_KjU()
            int r18 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r18 == 0) goto L_0x0535
            r18 = r12
            goto L_0x0537
        L_0x0535:
            r18 = 0
        L_0x0537:
            if (r18 == 0) goto L_0x053c
            r29 = r14
            goto L_0x0557
        L_0x053c:
            r2 = 0
            int r16 = r3 >> 9
            r16 = r16 & 14
            int r17 = r1 >> 24
            r17 = r17 & 112(0x70, float:1.57E-43)
            r12 = r16 | r17
            androidx.compose.runtime.State r12 = r4.textColor(r11, r7, r12)
            java.lang.Object r12 = r12.getValue()
            androidx.compose.ui.graphics.Color r12 = (androidx.compose.ui.graphics.Color) r12
            long r16 = r12.m3174unboximpl()
            r29 = r16
        L_0x0557:
            r7.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r0 = new androidx.compose.ui.text.TextStyle
            r28 = r0
            r31 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r51 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 4194302(0x3ffffe, float:5.877469E-39)
            r57 = 0
            r28.<init>((long) r29, (long) r31, (androidx.compose.ui.text.font.FontWeight) r33, (androidx.compose.ui.text.font.FontStyle) r34, (androidx.compose.ui.text.font.FontSynthesis) r35, (androidx.compose.ui.text.font.FontFamily) r36, (java.lang.String) r37, (long) r38, (androidx.compose.ui.text.style.BaselineShift) r40, (androidx.compose.ui.text.style.TextGeometricTransform) r41, (androidx.compose.ui.text.intl.LocaleList) r42, (long) r43, (androidx.compose.ui.text.style.TextDecoration) r45, (androidx.compose.ui.graphics.Shadow) r46, (androidx.compose.ui.text.style.TextAlign) r47, (androidx.compose.ui.text.style.TextDirection) r48, (long) r49, (androidx.compose.ui.text.style.TextIndent) r51, (androidx.compose.ui.text.PlatformTextStyle) r52, (androidx.compose.ui.text.style.LineHeightStyle) r53, (androidx.compose.ui.text.style.LineBreak) r54, (androidx.compose.ui.text.style.Hyphens) r55, (int) r56, (kotlin.jvm.internal.DefaultConstructorMarker) r57)
            androidx.compose.ui.text.TextStyle r28 = r9.merge((androidx.compose.ui.text.TextStyle) r0)
            if (r65 == 0) goto L_0x05bd
            androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$8 r0 = androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$8.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r12 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r13, r12, r0)
            r2 = 0
            float r14 = OutlinedTextFieldTopPadding
            r15 = 0
            r16 = 0
            r17 = 13
            r18 = 0
            r73 = r0
            r74 = r2
            r75 = r14
            r76 = r15
            r77 = r16
            r78 = r17
            r79 = r18
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.PaddingKt.m764paddingqDBjuR0$default(r73, r74, r75, r76, r77, r78, r79)
            goto L_0x05bf
        L_0x05bd:
            r12 = 1
            r0 = r13
        L_0x05bf:
            int r2 = r3 >> 9
            r2 = r2 & 14
            int r14 = r1 >> 24
            r14 = r14 & 112(0x70, float:1.57E-43)
            r2 = r2 | r14
            androidx.compose.runtime.State r2 = r4.backgroundColor(r11, r7, r2)
            java.lang.Object r2 = r2.getValue()
            androidx.compose.ui.graphics.Color r2 = (androidx.compose.ui.graphics.Color) r2
            long r14 = r2.m3174unboximpl()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BackgroundKt.m448backgroundbw27NRU(r0, r14, r5)
            androidx.compose.material.TextFieldDefaults r2 = androidx.compose.material.TextFieldDefaults.INSTANCE
            float r2 = r2.m1673getMinWidthD9Ej5fM()
            androidx.compose.material.TextFieldDefaults r14 = androidx.compose.material.TextFieldDefaults.INSTANCE
            float r14 = r14.m1672getMinHeightD9Ej5fM()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m814defaultMinSizeVpY3zN4(r0, r2, r14)
            androidx.compose.ui.graphics.SolidColor r0 = new androidx.compose.ui.graphics.SolidColor
            r14 = r1 & 14
            int r15 = r1 >> 24
            r15 = r15 & 112(0x70, float:1.57E-43)
            r14 = r14 | r15
            androidx.compose.runtime.State r14 = r4.cursorColor(r6, r7, r14)
            java.lang.Object r14 = r14.getValue()
            androidx.compose.ui.graphics.Color r14 = (androidx.compose.ui.graphics.Color) r14
            long r14 = r14.m3174unboximpl()
            r12 = 0
            r0.<init>(r14, r12)
            r15 = 1
            r14 = r0
            androidx.compose.ui.graphics.Brush r14 = (androidx.compose.ui.graphics.Brush) r14
            androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$9 r0 = new androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$9
            r73 = r0
            r74 = r71
            r75 = r11
            r76 = r26
            r77 = r23
            r78 = r27
            r79 = r6
            r80 = r65
            r81 = r20
            r82 = r21
            r83 = r22
            r84 = r4
            r85 = r3
            r86 = r1
            r87 = r5
            r73.<init>(r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87)
            r12 = -1001528775(0xffffffffc44de239, float:-823.5347)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r7, r12, r15, r0)
            r15 = r0
            kotlin.jvm.functions.Function3 r15 = (kotlin.jvm.functions.Function3) r15
            r0 = r3 & 14
            r12 = r3 & 112(0x70, float:1.57E-43)
            r0 = r0 | r12
            r12 = r3 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r12
            r12 = r3 & r62
            r0 = r0 | r12
            int r12 = r1 << 12
            r12 = r12 & r63
            r0 = r0 | r12
            int r12 = r1 << 12
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r12 = r12 & r16
            r0 = r0 | r12
            int r12 = r1 << 12
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r12 = r12 & r16
            r0 = r0 | r12
            int r12 = r1 << 12
            r16 = 1879048192(0x70000000, float:1.58456325E29)
            r12 = r12 & r16
            r17 = r0 | r12
            int r0 = r1 >> 18
            r0 = r0 & 14
            r12 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r12
            r12 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r12
            int r12 = r1 >> 12
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r18 = r0 | r12
            r19 = 4096(0x1000, float:5.74E-42)
            r0 = r71
            r68 = r1
            r1 = r72
            r31 = r3
            r3 = r11
            r32 = r4
            r4 = r64
            r33 = r5
            r5 = r28
            r34 = r6
            r6 = r24
            r35 = r7
            r7 = r25
            r8 = r26
            r36 = r9
            r9 = r66
            r10 = r67
            r37 = r11
            r11 = r23
            r38 = r13
            r13 = r27
            r16 = r35
            r12 = 0
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((androidx.compose.ui.text.input.TextFieldValue) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (androidx.compose.foundation.text.KeyboardOptions) r6, (androidx.compose.foundation.text.KeyboardActions) r7, (boolean) r8, (int) r9, (int) r10, (androidx.compose.ui.text.input.VisualTransformation) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r12, (androidx.compose.foundation.interaction.MutableInteractionSource) r13, (androidx.compose.ui.graphics.Brush) r14, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r15, (androidx.compose.runtime.Composer) r16, (int) r17, (int) r18, (int) r19)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x06b2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x06b2:
            r28 = r24
            r29 = r25
            r30 = r26
            r39 = r31
            r24 = r20
            r25 = r21
            r26 = r22
            r31 = r27
            r27 = r23
        L_0x06c4:
            androidx.compose.runtime.ScopeUpdateScope r15 = r35.endRestartGroup()
            if (r15 != 0) goto L_0x06cb
            goto L_0x070b
        L_0x06cb:
            androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$10 r40 = new androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$10
            r0 = r40
            r1 = r71
            r2 = r72
            r3 = r38
            r4 = r37
            r5 = r64
            r6 = r36
            r7 = r65
            r8 = r24
            r9 = r25
            r10 = r26
            r11 = r34
            r12 = r27
            r13 = r28
            r14 = r29
            r69 = r15
            r15 = r30
            r16 = r66
            r17 = r67
            r18 = r31
            r19 = r33
            r20 = r32
            r21 = r92
            r22 = r93
            r23 = r94
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r0 = r40
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r69
            r1.updateScope(r0)
        L_0x070b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v51, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r79v1, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: androidx.compose.ui.text.TextStyle} */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x01d3, code lost:
        if (r10.changed((java.lang.Object) r85) != false) goto L_0x01da;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue r72, kotlin.jvm.functions.Function1 r73, androidx.compose.ui.Modifier r74, boolean r75, boolean r76, androidx.compose.ui.text.TextStyle r77, kotlin.jvm.functions.Function2 r78, kotlin.jvm.functions.Function2 r79, kotlin.jvm.functions.Function2 r80, kotlin.jvm.functions.Function2 r81, boolean r82, androidx.compose.ui.text.input.VisualTransformation r83, androidx.compose.foundation.text.KeyboardOptions r84, androidx.compose.foundation.text.KeyboardActions r85, boolean r86, int r87, androidx.compose.foundation.interaction.MutableInteractionSource r88, androidx.compose.ui.graphics.Shape r89, androidx.compose.material.TextFieldColors r90, androidx.compose.runtime.Composer r91, int r92, int r93, int r94) {
        /*
            r15 = r72
            r14 = r73
            r13 = r92
            r12 = r93
            r11 = r94
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -288998816(0xffffffffeec63a60, float:-3.0674301E28)
            r1 = r91
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)430@20830L7,441@21384L39,442@21462L22,443@21534L25,445@21568L416:OutlinedTextField.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = r92
            r1 = r93
            r2 = r11 & 1
            if (r2 == 0) goto L_0x002f
            r0 = r0 | 6
            goto L_0x003d
        L_0x002f:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x003d
            boolean r2 = r10.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x003b
            r2 = 4
            goto L_0x003c
        L_0x003b:
            r2 = 2
        L_0x003c:
            r0 = r0 | r2
        L_0x003d:
            r2 = r11 & 2
            if (r2 == 0) goto L_0x0044
            r0 = r0 | 48
            goto L_0x0054
        L_0x0044:
            r2 = r13 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0054
            boolean r2 = r10.changedInstance(r14)
            if (r2 == 0) goto L_0x0051
            r2 = 32
            goto L_0x0053
        L_0x0051:
            r2 = 16
        L_0x0053:
            r0 = r0 | r2
        L_0x0054:
            r2 = r11 & 4
            if (r2 == 0) goto L_0x005d
            r0 = r0 | 384(0x180, float:5.38E-43)
            r9 = r74
            goto L_0x0073
        L_0x005d:
            r9 = r13 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0071
            r9 = r74
            boolean r16 = r10.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x006c
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r16 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r0 = r0 | r16
            goto L_0x0073
        L_0x0071:
            r9 = r74
        L_0x0073:
            r16 = r11 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0080
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r3 = r75
            goto L_0x0096
        L_0x0080:
            r3 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0094
            r3 = r75
            boolean r19 = r10.changed((boolean) r3)
            if (r19 == 0) goto L_0x008f
            r19 = r17
            goto L_0x0091
        L_0x008f:
            r19 = r18
        L_0x0091:
            r0 = r0 | r19
            goto L_0x0096
        L_0x0094:
            r3 = r75
        L_0x0096:
            r19 = r11 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r64 = 57344(0xe000, float:8.0356E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x00a6
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r4 = r76
            goto L_0x00bc
        L_0x00a6:
            r22 = r13 & r64
            if (r22 != 0) goto L_0x00ba
            r4 = r76
            boolean r23 = r10.changed((boolean) r4)
            if (r23 == 0) goto L_0x00b5
            r23 = r20
            goto L_0x00b7
        L_0x00b5:
            r23 = r21
        L_0x00b7:
            r0 = r0 | r23
            goto L_0x00bc
        L_0x00ba:
            r4 = r76
        L_0x00bc:
            r65 = 458752(0x70000, float:6.42848E-40)
            r23 = r13 & r65
            r24 = 131072(0x20000, float:1.83671E-40)
            if (r23 != 0) goto L_0x00da
            r23 = r11 & 32
            if (r23 != 0) goto L_0x00d3
            r5 = r77
            boolean r25 = r10.changed((java.lang.Object) r5)
            if (r25 == 0) goto L_0x00d5
            r25 = r24
            goto L_0x00d7
        L_0x00d3:
            r5 = r77
        L_0x00d5:
            r25 = 65536(0x10000, float:9.18355E-41)
        L_0x00d7:
            r0 = r0 | r25
            goto L_0x00dc
        L_0x00da:
            r5 = r77
        L_0x00dc:
            r25 = r11 & 64
            r66 = 1572864(0x180000, float:2.204052E-39)
            r67 = 3670016(0x380000, float:5.142788E-39)
            if (r25 == 0) goto L_0x00e9
            r0 = r0 | r66
            r6 = r78
            goto L_0x00ff
        L_0x00e9:
            r26 = r13 & r67
            if (r26 != 0) goto L_0x00fd
            r6 = r78
            boolean r27 = r10.changedInstance(r6)
            if (r27 == 0) goto L_0x00f8
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fa
        L_0x00f8:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00fa:
            r0 = r0 | r27
            goto L_0x00ff
        L_0x00fd:
            r6 = r78
        L_0x00ff:
            r7 = r11 & 128(0x80, float:1.794E-43)
            r68 = 29360128(0x1c00000, float:7.052966E-38)
            if (r7 == 0) goto L_0x010c
            r28 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r28
            r8 = r79
            goto L_0x0122
        L_0x010c:
            r28 = r13 & r68
            if (r28 != 0) goto L_0x0120
            r8 = r79
            boolean r29 = r10.changedInstance(r8)
            if (r29 == 0) goto L_0x011b
            r29 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x011d
        L_0x011b:
            r29 = 4194304(0x400000, float:5.877472E-39)
        L_0x011d:
            r0 = r0 | r29
            goto L_0x0122
        L_0x0120:
            r8 = r79
        L_0x0122:
            r3 = r11 & 256(0x100, float:3.59E-43)
            r69 = 234881024(0xe000000, float:1.5777218E-30)
            if (r3 == 0) goto L_0x012f
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r29
            r4 = r80
            goto L_0x0145
        L_0x012f:
            r29 = r13 & r69
            if (r29 != 0) goto L_0x0143
            r4 = r80
            boolean r29 = r10.changedInstance(r4)
            if (r29 == 0) goto L_0x013e
            r29 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0140
        L_0x013e:
            r29 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0140:
            r0 = r0 | r29
            goto L_0x0145
        L_0x0143:
            r4 = r80
        L_0x0145:
            r4 = r11 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0150
            r29 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r29
            r5 = r81
            goto L_0x0168
        L_0x0150:
            r29 = 1879048192(0x70000000, float:1.58456325E29)
            r29 = r13 & r29
            if (r29 != 0) goto L_0x0166
            r5 = r81
            boolean r29 = r10.changedInstance(r5)
            if (r29 == 0) goto L_0x0161
            r29 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0163
        L_0x0161:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0163:
            r0 = r0 | r29
            goto L_0x0168
        L_0x0166:
            r5 = r81
        L_0x0168:
            r5 = r11 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x0171
            r1 = r1 | 6
            r6 = r82
            goto L_0x0187
        L_0x0171:
            r29 = r12 & 14
            if (r29 != 0) goto L_0x0185
            r6 = r82
            boolean r29 = r10.changed((boolean) r6)
            if (r29 == 0) goto L_0x0180
            r22 = 4
            goto L_0x0182
        L_0x0180:
            r22 = 2
        L_0x0182:
            r1 = r1 | r22
            goto L_0x0187
        L_0x0185:
            r6 = r82
        L_0x0187:
            r6 = r11 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0190
            r1 = r1 | 48
            r8 = r83
            goto L_0x01a6
        L_0x0190:
            r22 = r12 & 112(0x70, float:1.57E-43)
            if (r22 != 0) goto L_0x01a4
            r8 = r83
            boolean r22 = r10.changed((java.lang.Object) r8)
            if (r22 == 0) goto L_0x019f
            r26 = 32
            goto L_0x01a1
        L_0x019f:
            r26 = 16
        L_0x01a1:
            r1 = r1 | r26
            goto L_0x01a6
        L_0x01a4:
            r8 = r83
        L_0x01a6:
            r8 = r11 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x01af
            r1 = r1 | 384(0x180, float:5.38E-43)
            r9 = r84
            goto L_0x01c5
        L_0x01af:
            r9 = r12 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x01c3
            r9 = r84
            boolean r22 = r10.changed((java.lang.Object) r9)
            if (r22 == 0) goto L_0x01be
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x01c0
        L_0x01be:
            r27 = 128(0x80, float:1.794E-43)
        L_0x01c0:
            r1 = r1 | r27
            goto L_0x01c5
        L_0x01c3:
            r9 = r84
        L_0x01c5:
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x01dd
            r9 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r9 != 0) goto L_0x01d6
            r9 = r85
            boolean r22 = r10.changed((java.lang.Object) r9)
            if (r22 == 0) goto L_0x01d8
            goto L_0x01da
        L_0x01d6:
            r9 = r85
        L_0x01d8:
            r17 = r18
        L_0x01da:
            r1 = r1 | r17
            goto L_0x01df
        L_0x01dd:
            r9 = r85
        L_0x01df:
            r9 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r9 == 0) goto L_0x01e8
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r14 = r86
            goto L_0x01fc
        L_0x01e8:
            r17 = r12 & r64
            if (r17 != 0) goto L_0x01fa
            r14 = r86
            boolean r17 = r10.changed((boolean) r14)
            if (r17 == 0) goto L_0x01f5
            goto L_0x01f7
        L_0x01f5:
            r20 = r21
        L_0x01f7:
            r1 = r1 | r20
            goto L_0x01fc
        L_0x01fa:
            r14 = r86
        L_0x01fc:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r11 & r17
            if (r17 == 0) goto L_0x020a
            r18 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r18
            r14 = r87
            goto L_0x0220
        L_0x020a:
            r18 = r12 & r65
            if (r18 != 0) goto L_0x021e
            r14 = r87
            boolean r18 = r10.changed((int) r14)
            if (r18 == 0) goto L_0x0219
            r18 = r24
            goto L_0x021b
        L_0x0219:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x021b:
            r1 = r1 | r18
            goto L_0x0220
        L_0x021e:
            r14 = r87
        L_0x0220:
            r18 = 65536(0x10000, float:9.18355E-41)
            r18 = r11 & r18
            if (r18 == 0) goto L_0x022b
            r1 = r1 | r66
            r14 = r88
            goto L_0x0241
        L_0x022b:
            r20 = r12 & r67
            if (r20 != 0) goto L_0x023f
            r14 = r88
            boolean r20 = r10.changed((java.lang.Object) r14)
            if (r20 == 0) goto L_0x023a
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x023c
        L_0x023a:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x023c:
            r1 = r1 | r20
            goto L_0x0241
        L_0x023f:
            r14 = r88
        L_0x0241:
            r20 = r12 & r68
            if (r20 != 0) goto L_0x025b
            r20 = r11 & r24
            if (r20 != 0) goto L_0x0254
            r14 = r89
            boolean r20 = r10.changed((java.lang.Object) r14)
            if (r20 == 0) goto L_0x0256
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0258
        L_0x0254:
            r14 = r89
        L_0x0256:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x0258:
            r1 = r1 | r20
            goto L_0x025d
        L_0x025b:
            r14 = r89
        L_0x025d:
            r20 = r12 & r69
            if (r20 != 0) goto L_0x0279
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r11 & r20
            if (r20 != 0) goto L_0x0272
            r12 = r90
            boolean r20 = r10.changed((java.lang.Object) r12)
            if (r20 == 0) goto L_0x0274
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0276
        L_0x0272:
            r12 = r90
        L_0x0274:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0276:
            r1 = r1 | r20
            goto L_0x027b
        L_0x0279:
            r12 = r90
        L_0x027b:
            r20 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r12 = r0 & r20
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r12 != r14) goto L_0x02c2
            r12 = 191739611(0xb6db6db, float:4.5782105E-32)
            r12 = r12 & r1
            r14 = 38347922(0x2492492, float:1.4777643E-37)
            if (r12 != r14) goto L_0x02c2
            boolean r12 = r10.getSkipping()
            if (r12 != 0) goto L_0x0295
            goto L_0x02c2
        L_0x0295:
            r10.skipToGroupEnd()
            r24 = r74
            r25 = r75
            r26 = r76
            r27 = r77
            r28 = r78
            r29 = r79
            r30 = r80
            r31 = r81
            r32 = r82
            r33 = r83
            r34 = r84
            r35 = r85
            r36 = r86
            r70 = r87
            r37 = r88
            r38 = r89
            r39 = r90
            r42 = r0
            r41 = r1
            r40 = r10
            goto L_0x058d
        L_0x02c2:
            r10.startDefaults()
            r12 = r13 & 1
            if (r12 == 0) goto L_0x033f
            boolean r12 = r10.getDefaultsInvalid()
            if (r12 == 0) goto L_0x02d1
            goto L_0x033f
        L_0x02d1:
            r10.skipToGroupEnd()
            r2 = r11 & 32
            if (r2 == 0) goto L_0x02dc
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r2
        L_0x02dc:
            r2 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x02e2
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x02e2:
            r2 = r11 & r24
            if (r2 == 0) goto L_0x02ea
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r2
        L_0x02ea:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r11
            if (r2 == 0) goto L_0x0319
            r2 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r2
            r24 = r74
            r25 = r75
            r26 = r76
            r27 = r77
            r28 = r78
            r29 = r79
            r30 = r80
            r31 = r81
            r32 = r82
            r33 = r83
            r34 = r84
            r35 = r85
            r36 = r86
            r70 = r87
            r37 = r88
            r38 = r89
            r39 = r90
            r14 = r0
            r13 = r1
            goto L_0x04e9
        L_0x0319:
            r24 = r74
            r25 = r75
            r26 = r76
            r27 = r77
            r28 = r78
            r29 = r79
            r30 = r80
            r31 = r81
            r32 = r82
            r33 = r83
            r34 = r84
            r35 = r85
            r36 = r86
            r70 = r87
            r37 = r88
            r38 = r89
            r39 = r90
            r14 = r0
            r13 = r1
            goto L_0x04e9
        L_0x033f:
            if (r2 == 0) goto L_0x0346
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0348
        L_0x0346:
            r2 = r74
        L_0x0348:
            if (r16 == 0) goto L_0x034c
            r12 = 1
            goto L_0x034e
        L_0x034c:
            r12 = r75
        L_0x034e:
            if (r19 == 0) goto L_0x0352
            r14 = 0
            goto L_0x0354
        L_0x0352:
            r14 = r76
        L_0x0354:
            r16 = r11 & 32
            if (r16 == 0) goto L_0x037f
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.material.TextKt.getLocalTextStyle()
            r74 = r2
            r2 = r16
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r16 = 6
            r19 = 0
            r75 = r12
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r13 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r12, r13)
            java.lang.Object r12 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r2 = r12
            androidx.compose.ui.text.TextStyle r2 = (androidx.compose.ui.text.TextStyle) r2
            r12 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r12
            goto L_0x0385
        L_0x037f:
            r74 = r2
            r75 = r12
            r2 = r77
        L_0x0385:
            if (r25 == 0) goto L_0x0389
            r12 = 0
            goto L_0x038b
        L_0x0389:
            r12 = r78
        L_0x038b:
            if (r7 == 0) goto L_0x038f
            r7 = 0
            goto L_0x0391
        L_0x038f:
            r7 = r79
        L_0x0391:
            if (r3 == 0) goto L_0x0395
            r3 = 0
            goto L_0x0397
        L_0x0395:
            r3 = r80
        L_0x0397:
            if (r4 == 0) goto L_0x039b
            r4 = 0
            goto L_0x039d
        L_0x039b:
            r4 = r81
        L_0x039d:
            if (r5 == 0) goto L_0x03a1
            r5 = 0
            goto L_0x03a3
        L_0x03a1:
            r5 = r82
        L_0x03a3:
            if (r6 == 0) goto L_0x03ac
            androidx.compose.ui.text.input.VisualTransformation$Companion r6 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r6 = r6.getNone()
            goto L_0x03ae
        L_0x03ac:
            r6 = r83
        L_0x03ae:
            if (r8 == 0) goto L_0x03b7
            androidx.compose.foundation.text.KeyboardOptions$Companion r8 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r8 = r8.getDefault()
            goto L_0x03b9
        L_0x03b7:
            r8 = r84
        L_0x03b9:
            r13 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r13 == 0) goto L_0x03e7
            androidx.compose.foundation.text.KeyboardActions r13 = new androidx.compose.foundation.text.KeyboardActions
            r16 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r25 = 63
            r26 = 0
            r76 = r13
            r77 = r16
            r78 = r19
            r79 = r20
            r80 = r21
            r81 = r22
            r82 = r23
            r83 = r25
            r84 = r26
            r76.<init>(r77, r78, r79, r80, r81, r82, r83, r84)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x03e9
        L_0x03e7:
            r13 = r85
        L_0x03e9:
            if (r9 == 0) goto L_0x03ed
            r9 = 0
            goto L_0x03ef
        L_0x03ed:
            r9 = r86
        L_0x03ef:
            if (r17 == 0) goto L_0x03f7
            r16 = 2147483647(0x7fffffff, float:NaN)
            r70 = r16
            goto L_0x03f9
        L_0x03f7:
            r70 = r87
        L_0x03f9:
            if (r18 == 0) goto L_0x0441
            r16 = 0
            r17 = 0
            r76 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = 0
            r77 = r10
            r18 = 0
            r78 = r0
            java.lang.Object r0 = r77.rememberedValue()
            r19 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r91 = r2
            java.lang.Object r2 = r20.getEmpty()
            if (r0 != r2) goto L_0x0432
            r2 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r79 = r0
            r0 = r77
            r0.updateRememberedValue(r2)
            goto L_0x0438
        L_0x0432:
            r79 = r0
            r0 = r77
            r2 = r79
        L_0x0438:
            r10.endReplaceableGroup()
            r0 = r2
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x0447
        L_0x0441:
            r76 = r0
            r91 = r2
            r0 = r88
        L_0x0447:
            r2 = r11 & r24
            if (r2 == 0) goto L_0x0459
            androidx.compose.material.TextFieldDefaults r2 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r77 = r0
            r0 = 6
            androidx.compose.ui.graphics.Shape r0 = r2.getOutlinedTextFieldShape(r10, r0)
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r2
            goto L_0x045d
        L_0x0459:
            r77 = r0
            r0 = r89
        L_0x045d:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r11
            if (r2 == 0) goto L_0x04c6
            androidx.compose.material.TextFieldDefaults r16 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r39 = 0
            r41 = 0
            r43 = 0
            r45 = 0
            r47 = 0
            r49 = 0
            r51 = 0
            r53 = 0
            r55 = 0
            r57 = 0
            r60 = 0
            r61 = 0
            r62 = 48
            r63 = 2097151(0x1fffff, float:2.938734E-39)
            r59 = r10
            androidx.compose.material.TextFieldColors r2 = r16.m1676outlinedTextFieldColorsdx8h9Zs(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r60, r61, r62, r63)
            r16 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r16
            r24 = r74
            r25 = r75
            r37 = r77
            r27 = r91
            r38 = r0
            r39 = r2
            r30 = r3
            r31 = r4
            r32 = r5
            r33 = r6
            r29 = r7
            r34 = r8
            r36 = r9
            r28 = r12
            r35 = r13
            r26 = r14
            r14 = r76
            r13 = r1
            goto L_0x04e9
        L_0x04c6:
            r24 = r74
            r25 = r75
            r37 = r77
            r39 = r90
            r27 = r91
            r38 = r0
            r30 = r3
            r31 = r4
            r32 = r5
            r33 = r6
            r29 = r7
            r34 = r8
            r36 = r9
            r28 = r12
            r35 = r13
            r26 = r14
            r14 = r76
            r13 = r1
        L_0x04e9:
            r10.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x04fa
            r0 = -288998816(0xffffffffeec63a60, float:-3.0674301E28)
            java.lang.String r1 = "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:424)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r13, r1)
        L_0x04fa:
            r16 = 1
            r0 = r14 & 14
            r1 = r14 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r14 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r14 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = r14 & r64
            r0 = r0 | r1
            r1 = r14 & r65
            r0 = r0 | r1
            r1 = r14 & r67
            r0 = r0 | r1
            r1 = r14 & r68
            r0 = r0 | r1
            r1 = r14 & r69
            r0 = r0 | r1
            r1 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r14
            r21 = r0 | r1
            r0 = r13 & 14
            r0 = r0 | r66
            r1 = r13 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r13 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r13 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = r13 & r64
            r0 = r0 | r1
            r1 = r13 & r65
            r0 = r0 | r1
            int r1 = r13 << 3
            r1 = r1 & r68
            r0 = r0 | r1
            int r1 = r13 << 3
            r1 = r1 & r69
            r0 = r0 | r1
            int r1 = r13 << 3
            r2 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r2
            r22 = r0 | r1
            r23 = 0
            r0 = r72
            r1 = r73
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r27
            r6 = r28
            r7 = r29
            r8 = r30
            r9 = r31
            r40 = r10
            r10 = r32
            r11 = r33
            r12 = r34
            r41 = r13
            r13 = r35
            r42 = r14
            r14 = r36
            r15 = r70
            r17 = r37
            r18 = r38
            r19 = r39
            r20 = r40
            OutlinedTextField((androidx.compose.ui.text.input.TextFieldValue) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r6, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r7, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r8, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r9, (boolean) r10, (androidx.compose.ui.text.input.VisualTransformation) r11, (androidx.compose.foundation.text.KeyboardOptions) r12, (androidx.compose.foundation.text.KeyboardActions) r13, (boolean) r14, (int) r15, (int) r16, (androidx.compose.foundation.interaction.MutableInteractionSource) r17, (androidx.compose.ui.graphics.Shape) r18, (androidx.compose.material.TextFieldColors) r19, (androidx.compose.runtime.Composer) r20, (int) r21, (int) r22, (int) r23)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x058d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x058d:
            androidx.compose.runtime.ScopeUpdateScope r15 = r40.endRestartGroup()
            if (r15 != 0) goto L_0x0594
            goto L_0x05d2
        L_0x0594:
            androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$12 r23 = new androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$12
            r0 = r23
            r1 = r72
            r2 = r73
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r27
            r7 = r28
            r8 = r29
            r9 = r30
            r10 = r31
            r11 = r32
            r12 = r33
            r13 = r34
            r14 = r35
            r71 = r15
            r15 = r36
            r16 = r70
            r17 = r37
            r18 = r38
            r19 = r39
            r20 = r92
            r21 = r93
            r22 = r94
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = r23
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r71
            r1.updateScope(r0)
        L_0x05d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x023e  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x043b  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0457  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x05c2  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x05d9  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x05f8  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x05fe  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x061d  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0638  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0710  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x071c  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0720  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x07d5  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0946  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0232  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void OutlinedTextFieldLayout(androidx.compose.ui.Modifier r55, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, kotlin.jvm.functions.Function3<? super androidx.compose.ui.Modifier, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r59, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r60, boolean r61, float r62, kotlin.jvm.functions.Function1<? super androidx.compose.ui.geometry.Size, kotlin.Unit> r63, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r64, androidx.compose.foundation.layout.PaddingValues r65, androidx.compose.runtime.Composer r66, int r67, int r68) {
        /*
            r14 = r55
            r15 = r56
            r13 = r57
            r12 = r58
            r11 = r59
            r10 = r60
            r9 = r61
            r8 = r62
            r7 = r63
            r6 = r64
            r5 = r65
            r4 = r67
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "textField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onLabelMeasured"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "border"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "paddingValues"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = -2049536174(0xffffffff85d68f52, float:-2.0177111E-35)
            r1 = r66
            androidx.compose.runtime.Composer r3 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(OutlinedTextFieldLayout)P(4,9,7,2,3,10,8!1,5)489@22705L239,497@22992L7,498@23004L2308:OutlinedTextField.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r1)
            r1 = r67
            r2 = r68
            r16 = r4 & 14
            r17 = 4
            if (r16 != 0) goto L_0x005a
            boolean r16 = r3.changed((java.lang.Object) r14)
            if (r16 == 0) goto L_0x0056
            r16 = r17
            goto L_0x0058
        L_0x0056:
            r16 = 2
        L_0x0058:
            r1 = r1 | r16
        L_0x005a:
            r16 = r4 & 112(0x70, float:1.57E-43)
            if (r16 != 0) goto L_0x006b
            boolean r16 = r3.changedInstance(r15)
            if (r16 == 0) goto L_0x0067
            r16 = 32
            goto L_0x0069
        L_0x0067:
            r16 = 16
        L_0x0069:
            r1 = r1 | r16
        L_0x006b:
            r0 = r4 & 896(0x380, float:1.256E-42)
            if (r0 != 0) goto L_0x007b
            boolean r0 = r3.changedInstance(r13)
            if (r0 == 0) goto L_0x0078
            r0 = 256(0x100, float:3.59E-43)
            goto L_0x007a
        L_0x0078:
            r0 = 128(0x80, float:1.794E-43)
        L_0x007a:
            r1 = r1 | r0
        L_0x007b:
            r0 = r4 & 7168(0x1c00, float:1.0045E-41)
            if (r0 != 0) goto L_0x008b
            boolean r0 = r3.changedInstance(r12)
            if (r0 == 0) goto L_0x0088
            r0 = 2048(0x800, float:2.87E-42)
            goto L_0x008a
        L_0x0088:
            r0 = 1024(0x400, float:1.435E-42)
        L_0x008a:
            r1 = r1 | r0
        L_0x008b:
            r0 = 57344(0xe000, float:8.0356E-41)
            r0 = r0 & r4
            if (r0 != 0) goto L_0x009d
            boolean r0 = r3.changedInstance(r11)
            if (r0 == 0) goto L_0x009a
            r0 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r0 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r1 = r1 | r0
        L_0x009d:
            r0 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r4
            if (r0 != 0) goto L_0x00ae
            boolean r0 = r3.changedInstance(r10)
            if (r0 == 0) goto L_0x00ab
            r0 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ad
        L_0x00ab:
            r0 = 65536(0x10000, float:9.18355E-41)
        L_0x00ad:
            r1 = r1 | r0
        L_0x00ae:
            r0 = 3670016(0x380000, float:5.142788E-39)
            r0 = r0 & r4
            if (r0 != 0) goto L_0x00bf
            boolean r0 = r3.changed((boolean) r9)
            if (r0 == 0) goto L_0x00bc
            r0 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00be
        L_0x00bc:
            r0 = 524288(0x80000, float:7.34684E-40)
        L_0x00be:
            r1 = r1 | r0
        L_0x00bf:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r4
            if (r0 != 0) goto L_0x00d0
            boolean r0 = r3.changed((float) r8)
            if (r0 == 0) goto L_0x00cd
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00cf
        L_0x00cd:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x00cf:
            r1 = r1 | r0
        L_0x00d0:
            r0 = 234881024(0xe000000, float:1.5777218E-30)
            r0 = r0 & r4
            if (r0 != 0) goto L_0x00e1
            boolean r0 = r3.changedInstance(r7)
            if (r0 == 0) goto L_0x00de
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00e0
        L_0x00de:
            r0 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00e0:
            r1 = r1 | r0
        L_0x00e1:
            r0 = 1879048192(0x70000000, float:1.58456325E29)
            r0 = r0 & r4
            if (r0 != 0) goto L_0x00f2
            boolean r0 = r3.changedInstance(r6)
            if (r0 == 0) goto L_0x00ef
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x00f1
        L_0x00ef:
            r0 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x00f1:
            r1 = r1 | r0
        L_0x00f2:
            r0 = r68 & 14
            if (r0 != 0) goto L_0x0101
            boolean r0 = r3.changed((java.lang.Object) r5)
            if (r0 == 0) goto L_0x00fd
            goto L_0x00ff
        L_0x00fd:
            r17 = 2
        L_0x00ff:
            r2 = r2 | r17
        L_0x0101:
            r0 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r0 = r0 & r1
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r4) goto L_0x011e
            r0 = r2 & 11
            r4 = 2
            if (r0 != r4) goto L_0x011e
            boolean r0 = r3.getSkipping()
            if (r0 != 0) goto L_0x0116
            goto L_0x011e
        L_0x0116:
            r3.skipToGroupEnd()
            r66 = r2
            r5 = r3
            goto L_0x0949
        L_0x011e:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x012c
            java.lang.String r0 = "androidx.compose.material.OutlinedTextFieldLayout (OutlinedTextField.kt:476)"
            r4 = -2049536174(0xffffffff85d68f52, float:-2.0177111E-35)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r0)
        L_0x012c:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r61)
            java.lang.Float r4 = java.lang.Float.valueOf(r62)
            java.lang.Object[] r0 = new java.lang.Object[]{r7, r0, r4, r5}
            r4 = 8
            r16 = 0
            r66 = r2
            r2 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r3.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r2)
            r2 = 0
            r17 = r2
            int r2 = r0.length
            r18 = 0
            r54 = r18
            r18 = r4
            r4 = r54
        L_0x0155:
            if (r4 >= r2) goto L_0x0166
            r19 = r2
            r2 = r0[r4]
            boolean r20 = r3.changed((java.lang.Object) r2)
            r17 = r17 | r20
            int r4 = r4 + 1
            r2 = r19
            goto L_0x0155
        L_0x0166:
            r2 = r3
            r4 = 0
            r19 = r0
            java.lang.Object r0 = r2.rememberedValue()
            r20 = 0
            if (r17 != 0) goto L_0x0180
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r22 = r4
            java.lang.Object r4 = r21.getEmpty()
            if (r0 != r4) goto L_0x017d
            goto L_0x0182
        L_0x017d:
            r21 = r0
            goto L_0x0193
        L_0x0180:
            r22 = r4
        L_0x0182:
            r4 = 0
            r21 = r0
            androidx.compose.material.OutlinedTextFieldMeasurePolicy r0 = new androidx.compose.material.OutlinedTextFieldMeasurePolicy
            r0.<init>(r7, r9, r8, r5)
            r2.updateRememberedValue(r0)
        L_0x0193:
            r3.endReplaceableGroup()
            androidx.compose.material.OutlinedTextFieldMeasurePolicy r0 = (androidx.compose.material.OutlinedTextFieldMeasurePolicy) r0
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 0
            r16 = 0
            r17 = r4
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r4, r7)
            java.lang.Object r18 = r3.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r2 = r18
            androidx.compose.ui.unit.LayoutDirection r2 = (androidx.compose.ui.unit.LayoutDirection) r2
            int r16 = r1 << 3
            r16 = r16 & 112(0x70, float:1.57E-43)
            r17 = 0
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r3.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r20 = 6
            r21 = 0
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r8, r7)
            java.lang.Object r8 = r3.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r4 = r8
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r20 = 6
            r21 = 0
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r9, r7)
            java.lang.Object r9 = r3.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r8 = r9
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r20 = 6
            r21 = 0
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r14, r7)
            java.lang.Object r7 = r3.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            kotlin.jvm.functions.Function3 r14 = androidx.compose.ui.layout.LayoutKt.materializerOf(r55)
            int r12 = r16 << 9
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r12 = r12 | 6
            r20 = 0
            androidx.compose.runtime.Applier r15 = r3.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x0235
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0235:
            r3.startReusableNode()
            boolean r15 = r3.getInserting()
            if (r15 == 0) goto L_0x0242
            r3.createNode(r9)
            goto L_0x0245
        L_0x0242:
            r3.useNode()
        L_0x0245:
            androidx.compose.runtime.Composer r15 = androidx.compose.runtime.Updater.m2787constructorimpl(r3)
            r21 = 0
            r22 = r9
            r9 = r0
            androidx.compose.ui.layout.MeasurePolicy r9 = (androidx.compose.ui.layout.MeasurePolicy) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r23 = androidx.compose.ui.node.ComposeUiNode.Companion
            r24 = r0
            kotlin.jvm.functions.Function2 r0 = r23.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r15, r9, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r15, r4, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r15, r8, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r15, r7, r0)
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r3)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r0)
            int r9 = r12 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r14.invoke(r0, r3, r9)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r3.startReplaceableGroup(r0)
            int r9 = r12 >> 9
            r9 = r9 & 14
            r15 = r3
            r21 = 0
            r0 = 1169918054(0x45bb8866, float:6001.05)
            r25 = r4
            java.lang.String r4 = "C506@23508L8,545@24956L182:OutlinedTextField.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r0, r4)
            int r0 = r1 >> 27
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6.invoke(r15, r0)
            r0 = 1169918076(0x45bb887c, float:6001.0605)
            r15.startReplaceableGroup(r0)
            java.lang.String r0 = "509@23569L219"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            java.lang.String r4 = "C72@3384L9:Box.kt#2w3rfo"
            java.lang.String r0 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            java.lang.String r6 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            r28 = r7
            java.lang.String r7 = "C:CompositionLocal.kt#9igjgp"
            if (r11 == 0) goto L_0x043b
            androidx.compose.ui.Modifier$Companion r30 = androidx.compose.ui.Modifier.Companion
            r31 = r8
            r8 = r30
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            r30 = r9
            java.lang.String r9 = "Leading"
            androidx.compose.ui.Modifier r8 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r8, r9)
            androidx.compose.ui.Modifier r9 = androidx.compose.material.TextFieldImplKt.getIconDefaultSizeModifier()
            androidx.compose.ui.Modifier r8 = r8.then(r9)
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r9 = r9.getCenter()
            r26 = 48
            r32 = r26
            r33 = 0
            r34 = r12
            r12 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r15.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r6)
            r12 = 0
            int r35 = r32 >> 3
            r35 = r35 & 14
            int r36 = r32 >> 3
            r36 = r36 & 112(0x70, float:1.57E-43)
            r37 = r14
            r14 = r35 | r36
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r9, r12, r15, r14)
            int r35 = r32 << 3
            r35 = r35 & 112(0x70, float:1.57E-43)
            r36 = 0
            r38 = r9
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r15.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r39 = 6
            r40 = 0
            r41 = r12
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r12, r7)
            java.lang.Object r12 = r15.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r9 = r12
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r39 = 6
            r40 = 0
            r42 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r3, r7)
            java.lang.Object r3 = r15.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r39 = 6
            r40 = 0
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r13, r7)
            java.lang.Object r13 = r15.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r12 = r13
            androidx.compose.ui.platform.ViewConfiguration r12 = (androidx.compose.ui.platform.ViewConfiguration) r12
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            kotlin.jvm.functions.Function3 r39 = androidx.compose.ui.layout.LayoutKt.materializerOf(r8)
            r40 = r8
            int r8 = r35 << 9
            r8 = r8 & 7168(0x1c00, float:1.0045E-41)
            r8 = r8 | 6
            r43 = r39
            r39 = 0
            r44 = r2
            androidx.compose.runtime.Applier r2 = r15.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x038c
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x038c:
            r15.startReusableNode()
            boolean r2 = r15.getInserting()
            if (r2 == 0) goto L_0x0399
            r15.createNode(r13)
            goto L_0x039c
        L_0x0399:
            r15.useNode()
        L_0x039c:
            r15.disableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m2787constructorimpl(r15)
            r45 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r46 = androidx.compose.ui.node.ComposeUiNode.Companion
            r47 = r13
            kotlin.jvm.functions.Function2 r13 = r46.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r14, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r9, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r3, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r12, r13)
            r15.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r15)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r2)
            int r13 = r8 >> 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r45 = r3
            r3 = r43
            r3.invoke(r2, r15, r13)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r15.startReplaceableGroup(r2)
            int r2 = r8 >> 9
            r2 = r2 & 14
            r13 = r15
            r43 = 0
            r46 = r2
            r2 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r2, r4)
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r48 = r32 >> 6
            r48 = r48 & 112(0x70, float:1.57E-43)
            r48 = r48 | 6
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r49 = r13
            r50 = 0
            r51 = r2
            r2 = -905297788(0xffffffffca0a4084, float:-2265121.0)
            r52 = r3
            java.lang.String r3 = "C513@23761L9:OutlinedTextField.kt#jmzs0o"
            r53 = r8
            r8 = r49
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r2, r3)
            int r2 = r1 >> 12
            r2 = r2 & 14
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r11.invoke(r8, r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r15.endReplaceableGroup()
            r15.endNode()
            r15.endReplaceableGroup()
            r15.endReplaceableGroup()
            goto L_0x0447
        L_0x043b:
            r44 = r2
            r42 = r3
            r31 = r8
            r30 = r9
            r34 = r12
            r37 = r14
        L_0x0447:
            r15.endReplaceableGroup()
            r2 = 1169918361(0x45bb8999, float:6001.1997)
            r15.startReplaceableGroup(r2)
            java.lang.String r2 = "517@23855L221"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            if (r10 == 0) goto L_0x05c2
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            java.lang.String r3 = "Trailing"
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r2, r3)
            androidx.compose.ui.Modifier r3 = androidx.compose.material.TextFieldImplKt.getIconDefaultSizeModifier()
            androidx.compose.ui.Modifier r2 = r2.then(r3)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getCenter()
            r8 = 48
            r9 = 0
            r12 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r15.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r6)
            r12 = 0
            int r13 = r8 >> 3
            r13 = r13 & 14
            int r14 = r8 >> 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            r13 = r13 | r14
            androidx.compose.ui.layout.MeasurePolicy r13 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r3, r12, r15, r13)
            int r14 = r8 << 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            r26 = 0
            r32 = r3
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r15.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r33 = 6
            r35 = 0
            r36 = r9
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r9, r7)
            java.lang.Object r9 = r15.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r3 = r9
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r33 = 6
            r35 = 0
            r38 = r12
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r12, r7)
            java.lang.Object r12 = r15.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r9 = r12
            androidx.compose.ui.unit.LayoutDirection r9 = (androidx.compose.ui.unit.LayoutDirection) r9
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r33 = 6
            r35 = 0
            r39 = r0
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r0, r7)
            java.lang.Object r0 = r15.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            androidx.compose.ui.platform.ViewConfiguration r0 = (androidx.compose.ui.platform.ViewConfiguration) r0
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r33 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            r35 = r2
            int r2 = r14 << 9
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | 6
            r40 = r33
            r33 = 0
            r41 = r14
            androidx.compose.runtime.Applier r14 = r15.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x0513
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0513:
            r15.startReusableNode()
            boolean r14 = r15.getInserting()
            if (r14 == 0) goto L_0x0520
            r15.createNode(r12)
            goto L_0x0523
        L_0x0520:
            r15.useNode()
        L_0x0523:
            r15.disableReusing()
            androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m2787constructorimpl(r15)
            r43 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r45 = androidx.compose.ui.node.ComposeUiNode.Companion
            r46 = r12
            kotlin.jvm.functions.Function2 r12 = r45.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r14, r13, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r14, r3, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r14, r9, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r14, r0, r12)
            r15.enableReusing()
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r15)
            androidx.compose.runtime.SkippableUpdater r12 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r12)
            int r14 = r2 >> 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r43 = r0
            r0 = r40
            r0.invoke(r12, r15, r14)
            r12 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r15.startReplaceableGroup(r12)
            int r12 = r2 >> 9
            r12 = r12 & 14
            r14 = r15
            r40 = 0
            r45 = r0
            r0 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r0, r4)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r47 = r8 >> 6
            r47 = r47 & 112(0x70, float:1.57E-43)
            r47 = r47 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r48 = r14
            r49 = 0
            r50 = r0
            r0 = -905297501(0xffffffffca0a41a3, float:-2265192.8)
            r51 = r2
            java.lang.String r2 = "C521@24048L10:OutlinedTextField.kt#jmzs0o"
            r52 = r3
            r3 = r48
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r2)
            int r0 = r1 >> 15
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r10.invoke(r3, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r15.endReplaceableGroup()
            r15.endNode()
            r15.endReplaceableGroup()
            r15.endReplaceableGroup()
            goto L_0x05c4
        L_0x05c2:
            r39 = r0
        L_0x05c4:
            r15.endReplaceableGroup()
            r0 = r44
            float r2 = androidx.compose.foundation.layout.PaddingKt.calculateStartPadding(r5, r0)
            float r3 = androidx.compose.foundation.layout.PaddingKt.calculateEndPadding(r5, r0)
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            r43 = r8
            androidx.compose.ui.Modifier r43 = (androidx.compose.ui.Modifier) r43
            if (r11 == 0) goto L_0x05f8
            float r8 = androidx.compose.material.TextFieldImplKt.getHorizontalIconPadding()
            r9 = 0
            float r12 = r2 - r8
            float r8 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r12)
            r9 = 0
            r12 = 0
            float r13 = (float) r9
            float r9 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r13)
            r12 = 0
            float r13 = kotlin.ranges.RangesKt.coerceAtLeast((float) r8, (float) r9)
            float r8 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r13)
            r44 = r8
            goto L_0x05fa
        L_0x05f8:
            r44 = r2
        L_0x05fa:
            r45 = 0
            if (r10 == 0) goto L_0x061d
            float r8 = androidx.compose.material.TextFieldImplKt.getHorizontalIconPadding()
            r9 = 0
            float r12 = r3 - r8
            float r8 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r12)
            r9 = 0
            r12 = 0
            float r13 = (float) r9
            float r9 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r13)
            r12 = 0
            float r13 = kotlin.ranges.RangesKt.coerceAtLeast((float) r8, (float) r9)
            float r8 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r13)
            r46 = r8
            goto L_0x061f
        L_0x061d:
            r46 = r3
        L_0x061f:
            r47 = 0
            r48 = 10
            r49 = 0
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.PaddingKt.m764paddingqDBjuR0$default(r43, r44, r45, r46, r47, r48, r49)
            r9 = 1169919372(0x45bb8d8c, float:6001.6934)
            r15.startReplaceableGroup(r9)
            java.lang.String r9 = "542@24869L59"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r9)
            r13 = r57
            if (r13 == 0) goto L_0x0651
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            java.lang.String r12 = "Hint"
            androidx.compose.ui.Modifier r9 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r9, r12)
            androidx.compose.ui.Modifier r9 = r9.then(r8)
            int r12 = r1 >> 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r13.invoke(r9, r15, r12)
        L_0x0651:
            r15.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            java.lang.String r12 = "TextField"
            androidx.compose.ui.Modifier r9 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r9, r12)
            androidx.compose.ui.Modifier r9 = r9.then(r8)
            r12 = 1
            r14 = 384(0x180, float:5.38E-43)
            r26 = 0
            r44 = r0
            r0 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r15.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r6)
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r0.getTopStart()
            int r32 = r14 >> 3
            r32 = r32 & 14
            int r33 = r14 >> 3
            r33 = r33 & 112(0x70, float:1.57E-43)
            r35 = r2
            r2 = r32 | r33
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r0, r12, r15, r2)
            int r32 = r14 << 3
            r32 = r32 & 112(0x70, float:1.57E-43)
            r33 = 0
            r36 = r0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r15.startReplaceableGroup(r0)
            r0 = r39
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r38 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r39 = r3
            r3 = r38
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r38 = 6
            r40 = 0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r5, r7)
            java.lang.Object r5 = r15.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r3 = r5
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r38 = 6
            r40 = 0
            r41 = r8
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r8, r7)
            java.lang.Object r8 = r15.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r5 = r8
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r38 = 6
            r40 = 0
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r10, r7)
            java.lang.Object r10 = r15.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r8 = r10
            androidx.compose.ui.platform.ViewConfiguration r8 = (androidx.compose.ui.platform.ViewConfiguration) r8
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            kotlin.jvm.functions.Function3 r38 = androidx.compose.ui.layout.LayoutKt.materializerOf(r9)
            r40 = r9
            int r9 = r32 << 9
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | 6
            r43 = r38
            r38 = 0
            androidx.compose.runtime.Applier r11 = r15.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x0713
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0713:
            r15.startReusableNode()
            boolean r11 = r15.getInserting()
            if (r11 == 0) goto L_0x0720
            r15.createNode(r10)
            goto L_0x0723
        L_0x0720:
            r15.useNode()
        L_0x0723:
            r15.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m2787constructorimpl(r15)
            r45 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r46 = androidx.compose.ui.node.ComposeUiNode.Companion
            r47 = r10
            kotlin.jvm.functions.Function2 r10 = r46.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r11, r2, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r11, r3, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r11, r5, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r11, r8, r10)
            r15.enableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r15)
            androidx.compose.runtime.SkippableUpdater r10 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r10)
            int r11 = r9 >> 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r45 = r2
            r2 = r43
            r2.invoke(r10, r15, r11)
            r10 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r15.startReplaceableGroup(r10)
            int r10 = r9 >> 9
            r10 = r10 & 14
            r11 = r15
            r43 = 0
            r46 = r2
            r2 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r2, r4)
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r48 = r14 >> 6
            r48 = r48 & 112(0x70, float:1.57E-43)
            r48 = r48 | 6
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r49 = r11
            r50 = 0
            r51 = r2
            r2 = -905296436(0xffffffffca0a45cc, float:-2265459.0)
            r52 = r3
            java.lang.String r3 = "C549@25113L11:OutlinedTextField.kt#jmzs0o"
            r53 = r5
            r5 = r49
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r2, r3)
            int r2 = r1 >> 3
            r2 = r2 & 14
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = r56
            r3.invoke(r5, r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r15.endReplaceableGroup()
            r15.endNode()
            r15.endReplaceableGroup()
            r15.endReplaceableGroup()
            r2 = -614207951(0xffffffffdb63ee31, float:-6.4156714E16)
            r5 = r42
            r5.startReplaceableGroup(r2)
            java.lang.String r2 = "553@25189L54"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            r12 = r58
            if (r12 == 0) goto L_0x092d
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            java.lang.String r8 = "Label"
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r2, r8)
            r8 = 6
            r9 = 0
            r10 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r15.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r6)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r6.getTopStart()
            r10 = 0
            int r11 = r8 >> 3
            r11 = r11 & 14
            int r14 = r8 >> 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            r11 = r11 | r14
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r6, r10, r15, r11)
            int r14 = r8 << 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            r26 = 0
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r15.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r3 = 6
            r19 = 0
            r29 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r3, r7)
            java.lang.Object r3 = r15.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r0 = r3
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r19 = 6
            r29 = 0
            r32 = r6
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r6, r7)
            java.lang.Object r6 = r15.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r3 = r6
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r19 = 6
            r29 = 0
            r33 = r9
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r9, r7)
            java.lang.Object r7 = r15.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r6 = r7
            androidx.compose.ui.platform.ViewConfiguration r6 = (androidx.compose.ui.platform.ViewConfiguration) r6
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r9 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            r18 = r2
            int r2 = r14 << 9
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | 6
            r19 = 0
            r29 = r10
            androidx.compose.runtime.Applier r10 = r15.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x0883
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0883:
            r15.startReusableNode()
            boolean r10 = r15.getInserting()
            if (r10 == 0) goto L_0x0890
            r15.createNode(r7)
            goto L_0x0893
        L_0x0890:
            r15.useNode()
        L_0x0893:
            r15.disableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m2787constructorimpl(r15)
            r36 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r38 = androidx.compose.ui.node.ComposeUiNode.Companion
            r40 = r7
            kotlin.jvm.functions.Function2 r7 = r38.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r10, r11, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r10, r0, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r10, r3, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r10, r6, r7)
            r15.enableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r15)
            androidx.compose.runtime.SkippableUpdater r7 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r7)
            int r10 = r2 >> 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r9.invoke(r7, r15, r10)
            r7 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r15.startReplaceableGroup(r7)
            int r7 = r2 >> 9
            r7 = r7 & 14
            r10 = r15
            r23 = 0
            r36 = r0
            r0 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r0, r4)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r4 = r8 >> 6
            r4 = r4 & 112(0x70, float:1.57E-43)
            r4 = r4 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r27 = r10
            r38 = 0
            r42 = r0
            r0 = -905296315(0xffffffffca0a4645, float:-2265489.2)
            r43 = r2
            java.lang.String r2 = "C553@25234L7:OutlinedTextField.kt#jmzs0o"
            r45 = r3
            r3 = r27
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r2)
            int r0 = r1 >> 9
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r12.invoke(r3, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r15.endReplaceableGroup()
            r15.endNode()
            r15.endReplaceableGroup()
            r15.endReplaceableGroup()
        L_0x092d:
            r5.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r5.endReplaceableGroup()
            r5.endNode()
            r5.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0949
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0949:
            androidx.compose.runtime.ScopeUpdateScope r14 = r5.endRestartGroup()
            if (r14 != 0) goto L_0x0956
            r17 = r66
            r16 = r1
            r18 = r5
            goto L_0x0981
        L_0x0956:
            androidx.compose.material.OutlinedTextFieldKt$OutlinedTextFieldLayout$2 r15 = new androidx.compose.material.OutlinedTextFieldKt$OutlinedTextFieldLayout$2
            r0 = r15
            r16 = r1
            r1 = r55
            r17 = r66
            r2 = r56
            r18 = r5
            r3 = r57
            r4 = r58
            r5 = r59
            r6 = r60
            r7 = r61
            r8 = r62
            r9 = r63
            r10 = r64
            r11 = r65
            r12 = r67
            r13 = r68
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r14.updateScope(r15)
        L_0x0981:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextFieldLayout(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, float, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateWidth-O3s9Psw  reason: not valid java name */
    public static final int m1565calculateWidthO3s9Psw(int leadingPlaceableWidth, int trailingPlaceableWidth, int textFieldPlaceableWidth, int labelPlaceableWidth, int placeholderPlaceableWidth, boolean isLabelInMiddleSection, long constraints, float density, PaddingValues paddingValues) {
        int focusedLabelWidth = 0;
        int wrappedWidth = leadingPlaceableWidth + Math.max(textFieldPlaceableWidth, Math.max(isLabelInMiddleSection ? labelPlaceableWidth : 0, placeholderPlaceableWidth)) + trailingPlaceableWidth;
        if (!isLabelInMiddleSection) {
            focusedLabelWidth = labelPlaceableWidth + MathKt.roundToInt(Dp.m5986constructorimpl(paddingValues.m771calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr) + paddingValues.m772calculateRightPaddingu2uoSUM(LayoutDirection.Ltr)) * density);
        }
        return Math.max(wrappedWidth, Math.max(focusedLabelWidth, Constraints.m5932getMinWidthimpl(constraints)));
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateHeight-zUg2_y0  reason: not valid java name */
    public static final int m1564calculateHeightzUg2_y0(int leadingPlaceableHeight, int trailingPlaceableHeight, int textFieldPlaceableHeight, int labelPlaceableHeight, int placeholderPlaceableHeight, long constraints, float density, PaddingValues paddingValues) {
        return Math.max(Constraints.m5931getMinHeightimpl(constraints), Math.max(leadingPlaceableHeight, Math.max(trailingPlaceableHeight, MathKt.roundToInt(((float) Math.max(textFieldPlaceableHeight, placeholderPlaceableHeight)) + (paddingValues.m770calculateBottomPaddingD9Ej5fM() * density) + Math.max(paddingValues.m773calculateTopPaddingD9Ej5fM() * density, ((float) labelPlaceableHeight) / 2.0f)))));
    }

    /* access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope $this$place, int height, int width, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable textFieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable borderPlaceable, float animationProgress, boolean singleLine, float density, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        int i;
        int i2;
        int labelPositionY;
        int startPositionY;
        float f;
        int i3 = height;
        float f2 = animationProgress;
        int topPadding = MathKt.roundToInt(paddingValues.m773calculateTopPaddingD9Ej5fM() * density);
        int startPadding = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * density);
        float iconPadding = TextFieldImplKt.getHorizontalIconPadding() * density;
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, leadingPlaceable, 0, Alignment.Companion.getCenterVertically().align(leadingPlaceable.getHeight(), i3), 0.0f, 4, (Object) null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.Companion.getCenterVertically().align(trailingPlaceable.getHeight(), i3), 0.0f, 4, (Object) null);
        }
        Object labelPositionY2 = null;
        if (labelPlaceable != null) {
            Placeable it = labelPlaceable;
            if (singleLine) {
                startPositionY = Alignment.Companion.getCenterVertically().align(it.getHeight(), i3);
            } else {
                startPositionY = topPadding;
            }
            int positionY = MathHelpersKt.lerp(startPositionY, -(it.getHeight() / 2), f2);
            labelPositionY2 = Integer.valueOf(positionY);
            if (leadingPlaceable == null) {
                f = 0.0f;
            } else {
                f = (((float) TextFieldImplKt.widthOrZero(leadingPlaceable)) - iconPadding) * (((float) 1) - f2);
            }
            Placeable.PlacementScope.placeRelative$default($this$place, it, MathKt.roundToInt(f) + startPadding, positionY, 0.0f, 4, (Object) null);
        }
        if (singleLine) {
            i = Alignment.Companion.getCenterVertically().align(textFieldPlaceable.getHeight(), i3);
        } else {
            i = topPadding;
        }
        Placeable.PlacementScope placementScope = $this$place;
        Placeable placeable = textFieldPlaceable;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(leadingPlaceable), Math.max(i, TextFieldImplKt.heightOrZero(labelPlaceable) / 2), 0.0f, 4, (Object) null);
        if (placeholderPlaceable != null) {
            Placeable it2 = placeholderPlaceable;
            if (singleLine) {
                i2 = Alignment.Companion.getCenterVertically().align(it2.getHeight(), i3);
            } else {
                i2 = topPadding;
            }
            int placeholderVerticalPosition = Math.max(i2, TextFieldImplKt.heightOrZero(labelPlaceable) / 2);
            if (labelPositionY2 != null && placeholderVerticalPosition <= (labelPositionY = ((Number) labelPositionY2).intValue())) {
                placeholderVerticalPosition = labelPositionY + 1;
            }
            Placeable.PlacementScope.placeRelative$default($this$place, it2, TextFieldImplKt.widthOrZero(leadingPlaceable), placeholderVerticalPosition, 0.0f, 4, (Object) null);
        }
        Placeable.PlacementScope.m4903place70tqf50$default($this$place, borderPlaceable, IntOffset.Companion.m6114getZeronOccac(), 0.0f, 2, (Object) null);
    }

    /* renamed from: outlineCutout-12SF9DM  reason: not valid java name */
    public static final Modifier m1566outlineCutout12SF9DM(Modifier $this$outlineCutout_u2d12SF9DM, long labelSize, PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter($this$outlineCutout_u2d12SF9DM, "$this$outlineCutout");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return DrawModifierKt.drawWithContent($this$outlineCutout_u2d12SF9DM, new OutlinedTextFieldKt$outlineCutout$1(labelSize, paddingValues));
    }

    public static final float getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }
}
