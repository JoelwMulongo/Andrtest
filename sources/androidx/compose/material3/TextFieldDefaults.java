package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u001eJS\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#Jî\u0001\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00150(¢\u0006\u0002\b)2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u00102\u001a\u0002032\u0013\b\u0002\u00104\u001a\r\u0012\u0004\u0012\u00020\u00150(¢\u0006\u0002\b)H\u0007¢\u0006\u0002\u00105Jø\u0001\u00106\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00150(¢\u0006\u0002\b)2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u00102\u001a\u0002032\u0013\b\u0002\u00104\u001a\r\u0012\u0004\u0012\u00020\u00150(¢\u0006\u0002\b)H\u0007¢\u0006\u0002\u00107J­\u0002\u00108\u001a\u00020\u001c2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020:2\b\b\u0002\u0010<\u001a\u00020:2\b\b\u0002\u0010=\u001a\u00020:2\b\b\u0002\u0010>\u001a\u00020:2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020:2\b\b\u0002\u0010B\u001a\u00020:2\b\b\u0002\u0010C\u001a\u00020:2\b\b\u0002\u0010D\u001a\u00020:2\b\b\u0002\u0010E\u001a\u00020:2\b\b\u0002\u0010F\u001a\u00020:2\b\b\u0002\u0010G\u001a\u00020:2\b\b\u0002\u0010H\u001a\u00020:2\b\b\u0002\u0010I\u001a\u00020:2\b\b\u0002\u0010J\u001a\u00020:2\b\b\u0002\u0010K\u001a\u00020:2\b\b\u0002\u0010L\u001a\u00020:2\b\b\u0002\u0010M\u001a\u00020:2\b\b\u0002\u0010N\u001a\u00020:2\b\b\u0002\u0010O\u001a\u00020:2\b\b\u0002\u0010P\u001a\u00020:2\b\b\u0002\u0010Q\u001a\u00020:2\b\b\u0002\u0010R\u001a\u00020:2\b\b\u0002\u0010S\u001a\u00020:2\b\b\u0002\u0010T\u001a\u00020:2\b\b\u0002\u0010U\u001a\u00020:2\b\b\u0002\u0010V\u001a\u00020:H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010XJ=\u0010Y\u001a\u0002032\b\b\u0002\u0010Z\u001a\u00020\u00042\b\b\u0002\u0010[\u001a\u00020\u00042\b\b\u0002\u0010\\\u001a\u00020\u00042\b\b\u0002\u0010]\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010_J=\u0010`\u001a\u0002032\b\b\u0002\u0010Z\u001a\u00020\u00042\b\b\u0002\u0010[\u001a\u00020\u00042\b\b\u0002\u0010\\\u001a\u00020\u00042\b\b\u0002\u0010]\u001a\u00020\u0004H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\ba\u0010_J­\u0002\u0010b\u001a\u00020\u001c2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020:2\b\b\u0002\u0010<\u001a\u00020:2\b\b\u0002\u0010=\u001a\u00020:2\b\b\u0002\u0010>\u001a\u00020:2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010c\u001a\u00020:2\b\b\u0002\u0010d\u001a\u00020:2\b\b\u0002\u0010e\u001a\u00020:2\b\b\u0002\u0010f\u001a\u00020:2\b\b\u0002\u0010E\u001a\u00020:2\b\b\u0002\u0010F\u001a\u00020:2\b\b\u0002\u0010G\u001a\u00020:2\b\b\u0002\u0010H\u001a\u00020:2\b\b\u0002\u0010I\u001a\u00020:2\b\b\u0002\u0010J\u001a\u00020:2\b\b\u0002\u0010K\u001a\u00020:2\b\b\u0002\u0010L\u001a\u00020:2\b\b\u0002\u0010M\u001a\u00020:2\b\b\u0002\u0010N\u001a\u00020:2\b\b\u0002\u0010O\u001a\u00020:2\b\b\u0002\u0010P\u001a\u00020:2\b\b\u0002\u0010Q\u001a\u00020:2\b\b\u0002\u0010R\u001a\u00020:2\b\b\u0002\u0010S\u001a\u00020:2\b\b\u0002\u0010T\u001a\u00020:2\b\b\u0002\u0010U\u001a\u00020:2\b\b\u0002\u0010V\u001a\u00020:H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bg\u0010XJ=\u0010h\u001a\u0002032\b\b\u0002\u0010Z\u001a\u00020\u00042\b\b\u0002\u0010\\\u001a\u00020\u00042\b\b\u0002\u0010[\u001a\u00020\u00042\b\b\u0002\u0010]\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bi\u0010_J=\u0010j\u001a\u0002032\b\b\u0002\u0010Z\u001a\u00020\u00042\b\b\u0002\u0010[\u001a\u00020\u00042\b\b\u0002\u0010\\\u001a\u00020\u00042\b\b\u0002\u0010]\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bk\u0010_JM\u0010l\u001a\u00020m*\u00020m2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010n\u001a\u00020\u00042\b\b\u0002\u0010o\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bp\u0010qR\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006r"}, d2 = {"Landroidx/compose/material3/TextFieldDefaults;", "", "()V", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "filledShape", "Landroidx/compose/ui/graphics/Shape;", "getFilledShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape", "FilledContainerBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material3/TextFieldColors;", "shape", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "OutlinedBorderContainerBox", "focusedBorderThickness", "unfocusedBorderThickness", "OutlinedBorderContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "OutlinedTextFieldDecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "supportingText", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "TextFieldDecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "outlinedTextFieldColors", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "containerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "outlinedTextFieldColors-l59Burw", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/TextFieldColors;", "outlinedTextFieldPadding", "start", "top", "end", "bottom", "outlinedTextFieldPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "supportingTextPadding", "supportingTextPadding-a9UjIt4$material3_release", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-l59Burw", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "indicatorLine", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
/* compiled from: TextFieldDefaults.kt */
public final class TextFieldDefaults {
    private static final float FocusedBorderThickness = Dp.m5986constructorimpl((float) 2);
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = Dp.m5986constructorimpl((float) 56);
    private static final float MinWidth = Dp.m5986constructorimpl((float) 280);
    private static final float UnfocusedBorderThickness = Dp.m5986constructorimpl((float) 1);

    private TextFieldDefaults() {
    }

    public final Shape getOutlinedShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-584749279);
        ComposerKt.sourceInformation($composer, "C59@2665L9:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-584749279, $changed, -1, "androidx.compose.material3.TextFieldDefaults.<get-outlinedShape> (TextFieldDefaults.kt:59)");
        }
        Shape shape = ShapesKt.toShape(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getFilledShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(611926497);
        ComposerKt.sourceInformation($composer, "C62@2810L9:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(611926497, $changed, -1, "androidx.compose.material3.TextFieldDefaults.<get-filledShape> (TextFieldDefaults.kt:62)");
        }
        Shape shape = ShapesKt.toShape(FilledTextFieldTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m2150getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m2151getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m2152getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m2149getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void FilledContainerBox(boolean r21, boolean r22, androidx.compose.foundation.interaction.InteractionSource r23, androidx.compose.material3.TextFieldColors r24, androidx.compose.ui.graphics.Shape r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r20 = this;
            r10 = r20
            r11 = r23
            r12 = r24
            r13 = r27
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "colors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1358797526(0xffffffffaf02652a, float:-1.1859372E-10)
            r1 = r26
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(FilledContainerBox)P(1,3,2)107@4524L11,111@4614L16,109@4553L168:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r27
            r2 = r28 & 1
            if (r2 == 0) goto L_0x002c
            r1 = r1 | 6
            r15 = r21
            goto L_0x003f
        L_0x002c:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x003d
            r15 = r21
            boolean r2 = r14.changed((boolean) r15)
            if (r2 == 0) goto L_0x003a
            r2 = 4
            goto L_0x003b
        L_0x003a:
            r2 = 2
        L_0x003b:
            r1 = r1 | r2
            goto L_0x003f
        L_0x003d:
            r15 = r21
        L_0x003f:
            r2 = r28 & 2
            if (r2 == 0) goto L_0x0048
            r1 = r1 | 48
            r9 = r22
            goto L_0x005d
        L_0x0048:
            r2 = r13 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x005b
            r9 = r22
            boolean r2 = r14.changed((boolean) r9)
            if (r2 == 0) goto L_0x0057
            r2 = 32
            goto L_0x0059
        L_0x0057:
            r2 = 16
        L_0x0059:
            r1 = r1 | r2
            goto L_0x005d
        L_0x005b:
            r9 = r22
        L_0x005d:
            r2 = r28 & 4
            if (r2 == 0) goto L_0x0064
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0074
        L_0x0064:
            r2 = r13 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0074
            boolean r2 = r14.changed((java.lang.Object) r11)
            if (r2 == 0) goto L_0x0071
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0073
        L_0x0071:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0073:
            r1 = r1 | r2
        L_0x0074:
            r2 = r28 & 8
            if (r2 == 0) goto L_0x007b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x008b
        L_0x007b:
            r2 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x008b
            boolean r2 = r14.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x0088
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x008a
        L_0x0088:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x008a:
            r1 = r1 | r2
        L_0x008b:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r13
            if (r2 != 0) goto L_0x00a6
            r2 = r28 & 16
            if (r2 != 0) goto L_0x00a0
            r2 = r25
            boolean r3 = r14.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x00a2
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a0:
            r2 = r25
        L_0x00a2:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x00a4:
            r1 = r1 | r3
            goto L_0x00a8
        L_0x00a6:
            r2 = r25
        L_0x00a8:
            r3 = r28 & 32
            if (r3 == 0) goto L_0x00b0
            r3 = 196608(0x30000, float:2.75506E-40)
        L_0x00ae:
            r1 = r1 | r3
            goto L_0x00c1
        L_0x00b0:
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r13
            if (r3 != 0) goto L_0x00c1
            boolean r3 = r14.changed((java.lang.Object) r10)
            if (r3 == 0) goto L_0x00be
            r3 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ae
        L_0x00be:
            r3 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00ae
        L_0x00c1:
            r3 = 374491(0x5b6db, float:5.24774E-40)
            r3 = r3 & r1
            r4 = 74898(0x12492, float:1.04954E-40)
            if (r3 != r4) goto L_0x00da
            boolean r3 = r14.getSkipping()
            if (r3 != 0) goto L_0x00d1
            goto L_0x00da
        L_0x00d1:
            r14.skipToGroupEnd()
            r19 = r1
            r16 = r2
            goto L_0x015e
        L_0x00da:
            r14.startDefaults()
            r3 = r13 & 1
            r4 = -57345(0xffffffffffff1fff, float:NaN)
            if (r3 == 0) goto L_0x00f6
            boolean r3 = r14.getDefaultsInvalid()
            if (r3 == 0) goto L_0x00eb
            goto L_0x00f6
        L_0x00eb:
            r14.skipToGroupEnd()
            r3 = r28 & 16
            if (r3 == 0) goto L_0x0106
            r1 = r1 & r4
            r7 = r1
            r8 = r2
            goto L_0x0108
        L_0x00f6:
            r3 = r28 & 16
            if (r3 == 0) goto L_0x0106
            int r3 = r1 >> 15
            r3 = r3 & 14
            androidx.compose.ui.graphics.Shape r2 = r10.getFilledShape(r14, r3)
            r1 = r1 & r4
            r7 = r1
            r8 = r2
            goto L_0x0108
        L_0x0106:
            r7 = r1
            r8 = r2
        L_0x0108:
            r14.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0117
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.TextFieldDefaults.FilledContainerBox (TextFieldDefaults.kt:102)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r7, r1, r2)
        L_0x0117:
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            int r1 = r7 >> 9
            r1 = r1 & 14
            androidx.compose.runtime.State r1 = r12.containerColor$material3_release(r14, r1)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m3174unboximpl()
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.BackgroundKt.m448backgroundbw27NRU(r0, r1, r8)
            r6 = 0
            r16 = 0
            r17 = 48
            r18 = 0
            r0 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r24
            r19 = r7
            r7 = r16
            r16 = r8
            r8 = r17
            r9 = r18
            androidx.compose.ui.Modifier r0 = m2143indicatorLinegv0btCI$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r1 = 0
            androidx.compose.foundation.layout.BoxKt.Box(r0, r14, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x015e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x015e:
            androidx.compose.runtime.ScopeUpdateScope r9 = r14.endRestartGroup()
            if (r9 != 0) goto L_0x0165
            goto L_0x0183
        L_0x0165:
            androidx.compose.material3.TextFieldDefaults$FilledContainerBox$1 r17 = new androidx.compose.material3.TextFieldDefaults$FilledContainerBox$1
            r0 = r17
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r24
            r6 = r16
            r7 = r27
            r8 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0183:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.FilledContainerBox(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: indicatorLine-gv0btCI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m2143indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, int i, Object obj) {
        float f3;
        float f4;
        if ((i & 16) != 0) {
            f3 = FocusedBorderThickness;
        } else {
            f3 = f;
        }
        if ((i & 32) != 0) {
            f4 = UnfocusedBorderThickness;
        } else {
            f4 = f2;
        }
        return textFieldDefaults.m2153indicatorLinegv0btCI(modifier, z, z2, interactionSource, textFieldColors, f3, f4);
    }

    @ExperimentalMaterial3Api
    /* renamed from: indicatorLine-gv0btCI  reason: not valid java name */
    public final Modifier m2153indicatorLinegv0btCI(Modifier $this$indicatorLine_u2dgv0btCI, boolean enabled, boolean isError, InteractionSource interactionSource, TextFieldColors colors, float focusedIndicatorLineThickness, float unfocusedIndicatorLineThickness) {
        Modifier modifier = $this$indicatorLine_u2dgv0btCI;
        Intrinsics.checkNotNullParameter($this$indicatorLine_u2dgv0btCI, "$this$indicatorLine");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(colors, "colors");
        return ComposedModifierKt.composed($this$indicatorLine_u2dgv0btCI, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TextFieldDefaults$indicatorLinegv0btCI$$inlined$debugInspectorInfo$1(enabled, isError, interactionSource, colors, focusedIndicatorLineThickness, unfocusedIndicatorLineThickness) : InspectableValueKt.getNoInspectorInfo(), new TextFieldDefaults$indicatorLine$2(enabled, isError, interactionSource, colors, focusedIndicatorLineThickness, unfocusedIndicatorLineThickness));
    }

    @ExperimentalMaterial3Api
    /* renamed from: OutlinedBorderContainerBox-nbWgWpA  reason: not valid java name */
    public final void m2148OutlinedBorderContainerBoxnbWgWpA(boolean enabled, boolean isError, InteractionSource interactionSource, TextFieldColors colors, Shape shape, float focusedBorderThickness, float unfocusedBorderThickness, Composer $composer, int $changed, int i) {
        Shape shape2;
        float focusedBorderThickness2;
        float f;
        float unfocusedBorderThickness2;
        float unfocusedBorderThickness3;
        Shape shape3;
        float unfocusedBorderThickness4;
        float focusedBorderThickness3;
        Shape shape4;
        int $dirty;
        Shape shape5;
        int i2;
        int i3;
        int i4;
        InteractionSource interactionSource2 = interactionSource;
        TextFieldColors textFieldColors = colors;
        int i5 = $changed;
        int i6 = i;
        Intrinsics.checkNotNullParameter(interactionSource2, "interactionSource");
        Intrinsics.checkNotNullParameter(textFieldColors, "colors");
        Composer $composer2 = $composer.startRestartGroup(-1998946250);
        ComposerKt.sourceInformation($composer2, "C(OutlinedBorderContainerBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)180@7782L9,184@7953L203,195@8277L16,192@8165L143:TextFieldDefaults.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i6 & 1) != 0) {
            $dirty2 |= 6;
            boolean z = enabled;
        } else if ((i5 & 14) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 4 : 2;
        } else {
            boolean z2 = enabled;
        }
        if ((i6 & 2) != 0) {
            $dirty2 |= 48;
            boolean z3 = isError;
        } else if ((i5 & 112) == 0) {
            $dirty2 |= $composer2.changed(isError) ? 32 : 16;
        } else {
            boolean z4 = isError;
        }
        if ((i6 & 4) != 0) {
            $dirty2 |= 384;
        } else if ((i5 & 896) == 0) {
            $dirty2 |= $composer2.changed((Object) interactionSource2) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            $dirty2 |= 3072;
        } else if ((i5 & 7168) == 0) {
            $dirty2 |= $composer2.changed((Object) textFieldColors) ? 2048 : 1024;
        }
        if ((i5 & 57344) == 0) {
            if ((i6 & 16) == 0) {
                shape2 = shape;
                if ($composer2.changed((Object) shape2)) {
                    i4 = 16384;
                    $dirty2 |= i4;
                }
            } else {
                shape2 = shape;
            }
            i4 = 8192;
            $dirty2 |= i4;
        } else {
            shape2 = shape;
        }
        if ((i5 & 458752) == 0) {
            if ((i6 & 32) == 0) {
                focusedBorderThickness2 = focusedBorderThickness;
                if ($composer2.changed(focusedBorderThickness2)) {
                    i3 = 131072;
                    $dirty2 |= i3;
                }
            } else {
                focusedBorderThickness2 = focusedBorderThickness;
            }
            i3 = 65536;
            $dirty2 |= i3;
        } else {
            focusedBorderThickness2 = focusedBorderThickness;
        }
        if ((3670016 & i5) == 0) {
            if ((i6 & 64) == 0) {
                f = unfocusedBorderThickness;
                if ($composer2.changed(f)) {
                    i2 = 1048576;
                    $dirty2 |= i2;
                }
            } else {
                f = unfocusedBorderThickness;
            }
            i2 = 524288;
            $dirty2 |= i2;
        } else {
            f = unfocusedBorderThickness;
        }
        if ((i6 & 128) != 0) {
            $dirty2 |= 12582912;
        } else if ((29360128 & i5) == 0) {
            $dirty2 |= $composer2.changed((Object) this) ? 8388608 : 4194304;
        }
        if ((23967451 & $dirty2) != 4793490 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i5 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i6 & 16) != 0) {
                    shape5 = ShapesKt.toShape(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), $composer2, 6);
                    $dirty2 &= -57345;
                } else {
                    shape5 = shape2;
                }
                if ((i6 & 32) != 0) {
                    $dirty2 &= -458753;
                    focusedBorderThickness2 = FocusedBorderThickness;
                }
                if ((i6 & 64) != 0) {
                    $dirty = $dirty2 & -3670017;
                    shape4 = shape5;
                    unfocusedBorderThickness4 = UnfocusedBorderThickness;
                    focusedBorderThickness3 = focusedBorderThickness2;
                } else {
                    shape4 = shape5;
                    focusedBorderThickness3 = focusedBorderThickness2;
                    unfocusedBorderThickness4 = f;
                    $dirty = $dirty2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i6 & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i6 & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i6 & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                shape4 = shape2;
                focusedBorderThickness3 = focusedBorderThickness2;
                unfocusedBorderThickness4 = f;
                $dirty = $dirty2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1998946250, $dirty, -1, "androidx.compose.material3.TextFieldDefaults.OutlinedBorderContainerBox (TextFieldDefaults.kt:175)");
            }
            Shape shape6 = shape4;
            BoxKt.Box(BackgroundKt.m448backgroundbw27NRU(BorderKt.border(Modifier.Companion, (BorderStroke) TextFieldDefaultsKt.m2161animateBorderStrokeAsStateNuRrP5Q(enabled, isError, interactionSource, colors, focusedBorderThickness3, unfocusedBorderThickness4, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty >> 3) & 57344) | (($dirty >> 3) & 458752)).getValue(), shape6), textFieldColors.containerColor$material3_release($composer2, ($dirty >> 9) & 14).getValue().m3174unboximpl(), shape6), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            unfocusedBorderThickness2 = unfocusedBorderThickness4;
            unfocusedBorderThickness3 = focusedBorderThickness3;
            shape3 = shape6;
        } else {
            $composer2.skipToGroupEnd();
            int i7 = $dirty2;
            shape3 = shape2;
            unfocusedBorderThickness3 = focusedBorderThickness2;
            unfocusedBorderThickness2 = f;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextFieldDefaults$OutlinedBorderContainerBox$1(this, enabled, isError, interactionSource, colors, shape3, unfocusedBorderThickness3, unfocusedBorderThickness2, $changed, i));
        }
    }

    /* renamed from: textFieldWithLabelPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m2146textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getFirstBaselineOffset();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldBottomPadding();
        }
        return textFieldDefaults.m2158textFieldWithLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @ExperimentalMaterial3Api
    /* renamed from: textFieldWithLabelPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m2158textFieldWithLabelPaddinga9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.m756PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m2147textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m2159textFieldWithoutLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @ExperimentalMaterial3Api
    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m2159textFieldWithoutLabelPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m756PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: outlinedTextFieldPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m2144outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m2155outlinedTextFieldPaddinga9UjIt4(f, f2, f3, f4);
    }

    @ExperimentalMaterial3Api
    /* renamed from: outlinedTextFieldPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m2155outlinedTextFieldPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m756PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: supportingTextPadding-a9UjIt4$material3_release$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m2145supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float $this$dp$iv, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getSupportingTopPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            $this$dp$iv = Dp.m5986constructorimpl((float) 0);
        }
        return textFieldDefaults.m2156supportingTextPaddinga9UjIt4$material3_release(f, f2, f3, $this$dp$iv);
    }

    @ExperimentalMaterial3Api
    /* renamed from: supportingTextPadding-a9UjIt4$material3_release  reason: not valid java name */
    public final PaddingValues m2156supportingTextPaddinga9UjIt4$material3_release(float start, float top, float end, float bottom) {
        return PaddingKt.m756PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* renamed from: textFieldColors-l59Burw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.material3.TextFieldColors m2157textFieldColorsl59Burw(long r117, long r119, long r121, long r123, long r125, androidx.compose.foundation.text.selection.TextSelectionColors r127, long r128, long r130, long r132, long r134, long r136, long r138, long r140, long r142, long r144, long r146, long r148, long r150, long r152, long r154, long r156, long r158, long r160, long r162, long r164, long r166, long r168, long r170, androidx.compose.runtime.Composer r172, int r173, int r174, int r175, int r176) {
        /*
            r116 = this;
            r0 = r172
            r1 = r176
            r2 = -128842621(0xfffffffff8520483, float:-1.7038654E34)
            r0.startReplaceableGroup(r2)
            java.lang.String r3 = "C(textFieldColors)P(22:c#ui.graphics.Color,7:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,21,15:c#ui.graphics.Color,23:c#ui.graphics.Color,2:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,25:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color,19:c#ui.graphics.Color,27:c#ui.graphics.Color,8:c#ui.graphics.Color,14:c#ui.graphics.Color,16:c#ui.graphics.Color,24:c#ui.graphics.Color,3:c#ui.graphics.Color,11:c#ui.graphics.Color,20:c#ui.graphics.Color,5:c#ui.graphics.Color,18:c#ui.graphics.Color,26:c#ui.graphics.Color,6:c#ui.graphics.Color,13:c#ui.graphics.Color)293@13317L9,294@13404L9,296@13554L9,297@13627L9,298@13715L9,299@13798L7,300@13894L9,301@13989L9,302@14091L9,304@14267L9,305@14363L9,306@14456L9,307@14556L9,309@14726L9,310@14824L9,311@14919L9,312@15021L9,314@15194L9,315@15278L9,316@15359L9,317@15447L9,319@15599L9,320@15688L9,321@15782L9,323@15950L9,324@16045L9,325@16147L9,327@16318L9:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            r3 = r1 & 1
            r4 = 6
            if (r3 == 0) goto L_0x001f
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getInputColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r0, r4)
            goto L_0x0021
        L_0x001f:
            r5 = r117
        L_0x0021:
            r3 = r1 & 2
            if (r3 == 0) goto L_0x0040
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getDisabledInputColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r0, r4)
            r9 = 1052938076(0x3ec28f5c, float:0.38)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 14
            r14 = 0
            long r7 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r7, r9, r10, r11, r12, r13, r14)
            r64 = r7
            goto L_0x0042
        L_0x0040:
            r64 = r119
        L_0x0042:
            r3 = r1 & 4
            if (r3 == 0) goto L_0x0053
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getContainerColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r0, r4)
            r66 = r7
            goto L_0x0055
        L_0x0053:
            r66 = r121
        L_0x0055:
            r3 = r1 & 8
            if (r3 == 0) goto L_0x0066
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getCaretColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r0, r4)
            r68 = r7
            goto L_0x0068
        L_0x0066:
            r68 = r123
        L_0x0068:
            r3 = r1 & 16
            if (r3 == 0) goto L_0x0079
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getErrorFocusCaretColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r0, r4)
            r70 = r7
            goto L_0x007b
        L_0x0079:
            r70 = r125
        L_0x007b:
            r3 = r1 & 32
            if (r3 == 0) goto L_0x009a
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r7 = 0
            r8 = 0
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r9 = r0.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r172)
            r3 = r9
            androidx.compose.foundation.text.selection.TextSelectionColors r3 = (androidx.compose.foundation.text.selection.TextSelectionColors) r3
            goto L_0x009c
        L_0x009a:
            r3 = r127
        L_0x009c:
            r7 = r1 & 64
            if (r7 == 0) goto L_0x00ad
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getFocusActiveIndicatorColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r72 = r7
            goto L_0x00af
        L_0x00ad:
            r72 = r128
        L_0x00af:
            r7 = r1 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x00c0
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getActiveIndicatorColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r74 = r7
            goto L_0x00c2
        L_0x00c0:
            r74 = r130
        L_0x00c2:
            r7 = r1 & 256(0x100, float:3.59E-43)
            if (r7 == 0) goto L_0x00ef
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getDisabledActiveIndicatorColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r9 = 1052938076(0x3ec28f5c, float:0.38)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 14
            r14 = 0
            r117 = r7
            r119 = r9
            r120 = r10
            r121 = r11
            r122 = r12
            r123 = r13
            r124 = r14
            long r7 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r117, r119, r120, r121, r122, r123, r124)
            r76 = r7
            goto L_0x00f1
        L_0x00ef:
            r76 = r132
        L_0x00f1:
            r7 = r1 & 512(0x200, float:7.175E-43)
            if (r7 == 0) goto L_0x0102
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getErrorActiveIndicatorColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r78 = r7
            goto L_0x0104
        L_0x0102:
            r78 = r134
        L_0x0104:
            r7 = r1 & 1024(0x400, float:1.435E-42)
            if (r7 == 0) goto L_0x0115
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getFocusLeadingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r80 = r7
            goto L_0x0117
        L_0x0115:
            r80 = r136
        L_0x0117:
            r7 = r1 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x0128
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getLeadingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r82 = r7
            goto L_0x012a
        L_0x0128:
            r82 = r138
        L_0x012a:
            r7 = r1 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x0157
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getDisabledLeadingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r9 = 1052938076(0x3ec28f5c, float:0.38)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 14
            r14 = 0
            r117 = r7
            r119 = r9
            r120 = r10
            r121 = r11
            r122 = r12
            r123 = r13
            r124 = r14
            long r7 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r117, r119, r120, r121, r122, r123, r124)
            r84 = r7
            goto L_0x0159
        L_0x0157:
            r84 = r140
        L_0x0159:
            r7 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r7 == 0) goto L_0x016a
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getErrorLeadingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r86 = r7
            goto L_0x016c
        L_0x016a:
            r86 = r142
        L_0x016c:
            r7 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r7 == 0) goto L_0x017d
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getFocusTrailingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r88 = r7
            goto L_0x017f
        L_0x017d:
            r88 = r144
        L_0x017f:
            r7 = 32768(0x8000, float:4.5918E-41)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x0192
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getTrailingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r90 = r7
            goto L_0x0194
        L_0x0192:
            r90 = r146
        L_0x0194:
            r7 = 65536(0x10000, float:9.18355E-41)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x01c2
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getDisabledTrailingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r9 = 1052938076(0x3ec28f5c, float:0.38)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 14
            r14 = 0
            r117 = r7
            r119 = r9
            r120 = r10
            r121 = r11
            r122 = r12
            r123 = r13
            r124 = r14
            long r7 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r117, r119, r120, r121, r122, r123, r124)
            r92 = r7
            goto L_0x01c4
        L_0x01c2:
            r92 = r148
        L_0x01c4:
            r7 = 131072(0x20000, float:1.83671E-40)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x01d6
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getErrorTrailingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r94 = r7
            goto L_0x01d8
        L_0x01d6:
            r94 = r150
        L_0x01d8:
            r7 = 262144(0x40000, float:3.67342E-40)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x01ea
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getFocusLabelColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r96 = r7
            goto L_0x01ec
        L_0x01ea:
            r96 = r152
        L_0x01ec:
            r7 = 524288(0x80000, float:7.34684E-40)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x01fe
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getLabelColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r98 = r7
            goto L_0x0200
        L_0x01fe:
            r98 = r154
        L_0x0200:
            r7 = 1048576(0x100000, float:1.469368E-39)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x022e
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getDisabledLabelColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r9 = 1052938076(0x3ec28f5c, float:0.38)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 14
            r14 = 0
            r117 = r7
            r119 = r9
            r120 = r10
            r121 = r11
            r122 = r12
            r123 = r13
            r124 = r14
            long r7 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r117, r119, r120, r121, r122, r123, r124)
            r100 = r7
            goto L_0x0230
        L_0x022e:
            r100 = r156
        L_0x0230:
            r7 = 2097152(0x200000, float:2.938736E-39)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x0242
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getErrorLabelColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r102 = r7
            goto L_0x0244
        L_0x0242:
            r102 = r158
        L_0x0244:
            r7 = 4194304(0x400000, float:5.877472E-39)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x0256
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getInputPlaceholderColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r104 = r7
            goto L_0x0258
        L_0x0256:
            r104 = r160
        L_0x0258:
            r7 = 8388608(0x800000, float:1.17549435E-38)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x0286
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getDisabledInputColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r9 = 1052938076(0x3ec28f5c, float:0.38)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 14
            r14 = 0
            r117 = r7
            r119 = r9
            r120 = r10
            r121 = r11
            r122 = r12
            r123 = r13
            r124 = r14
            long r7 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r117, r119, r120, r121, r122, r123, r124)
            r106 = r7
            goto L_0x0288
        L_0x0286:
            r106 = r162
        L_0x0288:
            r7 = 16777216(0x1000000, float:2.3509887E-38)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x029a
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getFocusSupportingColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r108 = r7
            goto L_0x029c
        L_0x029a:
            r108 = r164
        L_0x029c:
            r7 = 33554432(0x2000000, float:9.403955E-38)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x02ae
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getSupportingColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r110 = r7
            goto L_0x02b0
        L_0x02ae:
            r110 = r166
        L_0x02b0:
            r7 = 67108864(0x4000000, float:1.5046328E-36)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x02de
            androidx.compose.material3.tokens.FilledTextFieldTokens r7 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getDisabledSupportingColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r9 = 1052938076(0x3ec28f5c, float:0.38)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 14
            r14 = 0
            r117 = r7
            r119 = r9
            r120 = r10
            r121 = r11
            r122 = r12
            r123 = r13
            r124 = r14
            long r7 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r117, r119, r120, r121, r122, r123, r124)
            r112 = r7
            goto L_0x02e0
        L_0x02de:
            r112 = r168
        L_0x02e0:
            r7 = 134217728(0x8000000, float:3.85186E-34)
            r1 = r1 & r7
            if (r1 == 0) goto L_0x02f2
            androidx.compose.material3.tokens.FilledTextFieldTokens r1 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getErrorSupportingColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r4)
            r114 = r7
            goto L_0x02f4
        L_0x02f2:
            r114 = r170
        L_0x02f4:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0304
            java.lang.String r1 = "androidx.compose.material3.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:292)"
            r4 = r173
            r14 = r174
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r4, r14, r1)
            goto L_0x0308
        L_0x0304:
            r4 = r173
            r14 = r174
        L_0x0308:
            androidx.compose.material3.TextFieldColors r1 = new androidx.compose.material3.TextFieldColors
            r7 = r1
            r63 = 0
            r8 = r5
            r10 = r64
            r12 = r66
            r14 = r68
            r16 = r70
            r18 = r3
            r19 = r72
            r21 = r74
            r23 = r78
            r25 = r76
            r27 = r80
            r29 = r82
            r31 = r84
            r33 = r86
            r35 = r88
            r37 = r90
            r39 = r92
            r41 = r94
            r43 = r96
            r45 = r98
            r47 = r100
            r49 = r102
            r51 = r104
            r53 = r106
            r55 = r108
            r57 = r110
            r59 = r112
            r61 = r114
            r7.<init>(r8, r10, r12, r14, r16, r18, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x036b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x036b:
            r172.endReplaceableGroup()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.m2157textFieldColorsl59Burw(long, long, long, long, long, androidx.compose.foundation.text.selection.TextSelectionColors, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, androidx.compose.runtime.Composer, int, int, int, int):androidx.compose.material3.TextFieldColors");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* renamed from: outlinedTextFieldColors-l59Burw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.material3.TextFieldColors m2154outlinedTextFieldColorsl59Burw(long r117, long r119, long r121, long r123, long r125, androidx.compose.foundation.text.selection.TextSelectionColors r127, long r128, long r130, long r132, long r134, long r136, long r138, long r140, long r142, long r144, long r146, long r148, long r150, long r152, long r154, long r156, long r158, long r160, long r162, long r164, long r166, long r168, long r170, androidx.compose.runtime.Composer r172, int r173, int r174, int r175, int r176) {
        /*
            r116 = this;
            r0 = r172
            r1 = r176
            r2 = -1654658683(0xffffffff9d5fe985, float:-2.9634531E-21)
            r0.startReplaceableGroup(r2)
            java.lang.String r3 = "C(outlinedTextFieldColors)P(22:c#ui.graphics.Color,7:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,10:c#ui.graphics.Color,21,15:c#ui.graphics.Color,23:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,17:c#ui.graphics.Color,25:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color,19:c#ui.graphics.Color,27:c#ui.graphics.Color,8:c#ui.graphics.Color,14:c#ui.graphics.Color,16:c#ui.graphics.Color,24:c#ui.graphics.Color,3:c#ui.graphics.Color,11:c#ui.graphics.Color,20:c#ui.graphics.Color,5:c#ui.graphics.Color,18:c#ui.graphics.Color,26:c#ui.graphics.Color,6:c#ui.graphics.Color,13:c#ui.graphics.Color)400@20949L9,401@21038L9,404@21236L9,405@21326L9,406@21409L7,407@21496L9,408@21582L9,409@21675L9,411@21836L9,412@21934L9,413@22029L9,414@22131L9,416@22305L9,417@22405L9,418@22502L9,420@22619L9,421@22783L9,422@22869L9,423@22952L9,424@23042L9,426@23198L9,427@23289L9,428@23385L9,430@23557L9,431@23654L9,433@23771L9,434@23933L9:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            r3 = r1 & 1
            r4 = 6
            if (r3 == 0) goto L_0x001f
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getInputColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r0, r4)
            goto L_0x0021
        L_0x001f:
            r5 = r117
        L_0x0021:
            r3 = r1 & 2
            if (r3 == 0) goto L_0x0040
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getDisabledInputColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r0, r4)
            r9 = 1052938076(0x3ec28f5c, float:0.38)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 14
            r14 = 0
            long r7 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r7, r9, r10, r11, r12, r13, r14)
            r64 = r7
            goto L_0x0042
        L_0x0040:
            r64 = r119
        L_0x0042:
            r3 = r1 & 4
            if (r3 == 0) goto L_0x004f
            androidx.compose.ui.graphics.Color$Companion r3 = androidx.compose.ui.graphics.Color.Companion
            long r7 = r3.m3199getTransparent0d7_KjU()
            r66 = r7
            goto L_0x0051
        L_0x004f:
            r66 = r121
        L_0x0051:
            r3 = r1 & 8
            if (r3 == 0) goto L_0x0062
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getCaretColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r0, r4)
            r68 = r7
            goto L_0x0064
        L_0x0062:
            r68 = r123
        L_0x0064:
            r3 = r1 & 16
            if (r3 == 0) goto L_0x0075
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getErrorFocusCaretColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r0, r4)
            r70 = r7
            goto L_0x0077
        L_0x0075:
            r70 = r125
        L_0x0077:
            r3 = r1 & 32
            if (r3 == 0) goto L_0x0096
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r7 = 0
            r8 = 0
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r9 = r0.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r172)
            r3 = r9
            androidx.compose.foundation.text.selection.TextSelectionColors r3 = (androidx.compose.foundation.text.selection.TextSelectionColors) r3
            goto L_0x0098
        L_0x0096:
            r3 = r127
        L_0x0098:
            r7 = r1 & 64
            if (r7 == 0) goto L_0x00a9
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getFocusOutlineColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r72 = r7
            goto L_0x00ab
        L_0x00a9:
            r72 = r128
        L_0x00ab:
            r7 = r1 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x00bc
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getOutlineColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r74 = r7
            goto L_0x00be
        L_0x00bc:
            r74 = r130
        L_0x00be:
            r7 = r1 & 256(0x100, float:3.59E-43)
            if (r7 == 0) goto L_0x00eb
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getDisabledOutlineColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r9 = 1039516303(0x3df5c28f, float:0.12)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 14
            r14 = 0
            r117 = r7
            r119 = r9
            r120 = r10
            r121 = r11
            r122 = r12
            r123 = r13
            r124 = r14
            long r7 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r117, r119, r120, r121, r122, r123, r124)
            r76 = r7
            goto L_0x00ed
        L_0x00eb:
            r76 = r132
        L_0x00ed:
            r7 = r1 & 512(0x200, float:7.175E-43)
            if (r7 == 0) goto L_0x00fe
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getErrorOutlineColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r78 = r7
            goto L_0x0100
        L_0x00fe:
            r78 = r134
        L_0x0100:
            r7 = r1 & 1024(0x400, float:1.435E-42)
            if (r7 == 0) goto L_0x0111
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getFocusLeadingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r80 = r7
            goto L_0x0113
        L_0x0111:
            r80 = r136
        L_0x0113:
            r7 = r1 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x0124
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getLeadingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r82 = r7
            goto L_0x0126
        L_0x0124:
            r82 = r138
        L_0x0126:
            r7 = r1 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x0153
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getDisabledLeadingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r9 = 1052938076(0x3ec28f5c, float:0.38)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 14
            r14 = 0
            r117 = r7
            r119 = r9
            r120 = r10
            r121 = r11
            r122 = r12
            r123 = r13
            r124 = r14
            long r7 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r117, r119, r120, r121, r122, r123, r124)
            r84 = r7
            goto L_0x0155
        L_0x0153:
            r84 = r140
        L_0x0155:
            r7 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r7 == 0) goto L_0x0166
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getErrorLeadingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r86 = r7
            goto L_0x0168
        L_0x0166:
            r86 = r142
        L_0x0168:
            r7 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r7 == 0) goto L_0x0179
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getFocusTrailingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r88 = r7
            goto L_0x017b
        L_0x0179:
            r88 = r144
        L_0x017b:
            r7 = 32768(0x8000, float:4.5918E-41)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x018e
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getTrailingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r90 = r7
            goto L_0x0190
        L_0x018e:
            r90 = r146
        L_0x0190:
            r7 = 65536(0x10000, float:9.18355E-41)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x01be
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getDisabledTrailingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r9 = 1052938076(0x3ec28f5c, float:0.38)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 14
            r14 = 0
            r117 = r7
            r119 = r9
            r120 = r10
            r121 = r11
            r122 = r12
            r123 = r13
            r124 = r14
            long r7 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r117, r119, r120, r121, r122, r123, r124)
            r92 = r7
            goto L_0x01c0
        L_0x01be:
            r92 = r148
        L_0x01c0:
            r7 = 131072(0x20000, float:1.83671E-40)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x01d2
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getErrorTrailingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r94 = r7
            goto L_0x01d4
        L_0x01d2:
            r94 = r150
        L_0x01d4:
            r7 = 262144(0x40000, float:3.67342E-40)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x01e6
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getFocusLabelColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r96 = r7
            goto L_0x01e8
        L_0x01e6:
            r96 = r152
        L_0x01e8:
            r7 = 524288(0x80000, float:7.34684E-40)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x01fa
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getLabelColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r98 = r7
            goto L_0x01fc
        L_0x01fa:
            r98 = r154
        L_0x01fc:
            r7 = 1048576(0x100000, float:1.469368E-39)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x022a
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getDisabledLabelColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r9 = 1052938076(0x3ec28f5c, float:0.38)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 14
            r14 = 0
            r117 = r7
            r119 = r9
            r120 = r10
            r121 = r11
            r122 = r12
            r123 = r13
            r124 = r14
            long r7 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r117, r119, r120, r121, r122, r123, r124)
            r100 = r7
            goto L_0x022c
        L_0x022a:
            r100 = r156
        L_0x022c:
            r7 = 2097152(0x200000, float:2.938736E-39)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x023e
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getErrorLabelColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r102 = r7
            goto L_0x0240
        L_0x023e:
            r102 = r158
        L_0x0240:
            r7 = 4194304(0x400000, float:5.877472E-39)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x0252
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getInputPlaceholderColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r104 = r7
            goto L_0x0254
        L_0x0252:
            r104 = r160
        L_0x0254:
            r7 = 8388608(0x800000, float:1.17549435E-38)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x0282
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getDisabledInputColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r9 = 1052938076(0x3ec28f5c, float:0.38)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 14
            r14 = 0
            r117 = r7
            r119 = r9
            r120 = r10
            r121 = r11
            r122 = r12
            r123 = r13
            r124 = r14
            long r7 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r117, r119, r120, r121, r122, r123, r124)
            r106 = r7
            goto L_0x0284
        L_0x0282:
            r106 = r162
        L_0x0284:
            r7 = 16777216(0x1000000, float:2.3509887E-38)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x0296
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getFocusSupportingColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r108 = r7
            goto L_0x0298
        L_0x0296:
            r108 = r164
        L_0x0298:
            r7 = 33554432(0x2000000, float:9.403955E-38)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x02aa
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getSupportingColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r110 = r7
            goto L_0x02ac
        L_0x02aa:
            r110 = r166
        L_0x02ac:
            r7 = 67108864(0x4000000, float:1.5046328E-36)
            r7 = r7 & r1
            if (r7 == 0) goto L_0x02da
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getDisabledSupportingColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r7, r0, r4)
            r9 = 1052938076(0x3ec28f5c, float:0.38)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 14
            r14 = 0
            r117 = r7
            r119 = r9
            r120 = r10
            r121 = r11
            r122 = r12
            r123 = r13
            r124 = r14
            long r7 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r117, r119, r120, r121, r122, r123, r124)
            r112 = r7
            goto L_0x02dc
        L_0x02da:
            r112 = r168
        L_0x02dc:
            r7 = 134217728(0x8000000, float:3.85186E-34)
            r1 = r1 & r7
            if (r1 == 0) goto L_0x02ee
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r1 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getErrorSupportingColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r4)
            r114 = r7
            goto L_0x02f0
        L_0x02ee:
            r114 = r170
        L_0x02f0:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0300
            java.lang.String r1 = "androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:399)"
            r4 = r173
            r14 = r174
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r4, r14, r1)
            goto L_0x0304
        L_0x0300:
            r4 = r173
            r14 = r174
        L_0x0304:
            androidx.compose.material3.TextFieldColors r1 = new androidx.compose.material3.TextFieldColors
            r7 = r1
            r63 = 0
            r8 = r5
            r10 = r64
            r12 = r66
            r14 = r68
            r16 = r70
            r18 = r3
            r19 = r72
            r21 = r74
            r23 = r78
            r25 = r76
            r27 = r80
            r29 = r82
            r31 = r84
            r33 = r86
            r35 = r88
            r37 = r90
            r39 = r92
            r41 = r94
            r43 = r96
            r45 = r98
            r47 = r100
            r49 = r102
            r51 = r104
            r53 = r106
            r55 = r108
            r57 = r110
            r59 = r112
            r61 = r114
            r7.<init>(r8, r10, r12, r14, r16, r18, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0367
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0367:
            r172.endReplaceableGroup()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.m2154outlinedTextFieldColorsl59Burw(long, long, long, long, long, androidx.compose.foundation.text.selection.TextSelectionColors, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, androidx.compose.runtime.Composer, int, int, int, int):androidx.compose.material3.TextFieldColors");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01c0, code lost:
        if (r7.changed((java.lang.Object) r88) != false) goto L_0x01c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x01da, code lost:
        if (r7.changed((java.lang.Object) r89) != false) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x01f4, code lost:
        if (r7.changed((java.lang.Object) r12) != false) goto L_0x01fb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x04b3  */
    /* JADX WARNING: Removed duplicated region for block: B:248:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x015c  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void TextFieldDecorationBox(java.lang.String r76, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, boolean r78, boolean r79, androidx.compose.ui.text.input.VisualTransformation r80, androidx.compose.foundation.interaction.InteractionSource r81, boolean r82, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r83, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r84, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r85, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r86, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r87, androidx.compose.ui.graphics.Shape r88, androidx.compose.material3.TextFieldColors r89, androidx.compose.foundation.layout.PaddingValues r90, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r91, androidx.compose.runtime.Composer r92, int r93, int r94, int r95) {
        /*
            r75 = this;
            r0 = r75
            r14 = r76
            r15 = r77
            r12 = r80
            r13 = r81
            r11 = r93
            r9 = r94
            r10 = r95
            java.lang.String r1 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            java.lang.String r1 = "innerTextField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            java.lang.String r1 = "visualTransformation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            java.lang.String r1 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            r1 = -1224712461(0xffffffffb7005ef3, float:-7.651502E-6)
            r2 = r92
            androidx.compose.runtime.Composer r7 = r2.startRestartGroup(r1)
            java.lang.String r1 = "C(TextFieldDecorationBox)P(14,4,3,11,15,5,6,7,9,8,13,12,10!1,2)540@30577L11,541@30624L17,552@30998L649:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = r93
            r2 = r94
            r3 = r10 & 1
            if (r3 == 0) goto L_0x0041
            r1 = r1 | 6
            goto L_0x004f
        L_0x0041:
            r3 = r11 & 14
            if (r3 != 0) goto L_0x004f
            boolean r3 = r7.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x004d
            r3 = 4
            goto L_0x004e
        L_0x004d:
            r3 = 2
        L_0x004e:
            r1 = r1 | r3
        L_0x004f:
            r3 = r10 & 2
            if (r3 == 0) goto L_0x0056
            r1 = r1 | 48
            goto L_0x0066
        L_0x0056:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0066
            boolean r3 = r7.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x0063
            r3 = 32
            goto L_0x0065
        L_0x0063:
            r3 = 16
        L_0x0065:
            r1 = r1 | r3
        L_0x0066:
            r3 = r10 & 4
            r16 = 256(0x100, float:3.59E-43)
            r17 = 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x0073
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r78
            goto L_0x0089
        L_0x0073:
            r3 = r11 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0087
            r3 = r78
            boolean r18 = r7.changed((boolean) r3)
            if (r18 == 0) goto L_0x0082
            r18 = r16
            goto L_0x0084
        L_0x0082:
            r18 = r17
        L_0x0084:
            r1 = r1 | r18
            goto L_0x0089
        L_0x0087:
            r3 = r78
        L_0x0089:
            r18 = r10 & 8
            r19 = 2048(0x800, float:2.87E-42)
            r20 = 1024(0x400, float:1.435E-42)
            if (r18 == 0) goto L_0x0096
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r4 = r79
            goto L_0x00ac
        L_0x0096:
            r4 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x00aa
            r4 = r79
            boolean r18 = r7.changed((boolean) r4)
            if (r18 == 0) goto L_0x00a5
            r18 = r19
            goto L_0x00a7
        L_0x00a5:
            r18 = r20
        L_0x00a7:
            r1 = r1 | r18
            goto L_0x00ac
        L_0x00aa:
            r4 = r79
        L_0x00ac:
            r18 = r10 & 16
            r61 = 57344(0xe000, float:8.0356E-41)
            r21 = 16384(0x4000, float:2.2959E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            if (r18 == 0) goto L_0x00ba
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00cb
        L_0x00ba:
            r18 = r11 & r61
            if (r18 != 0) goto L_0x00cb
            boolean r18 = r7.changed((java.lang.Object) r12)
            if (r18 == 0) goto L_0x00c7
            r18 = r21
            goto L_0x00c9
        L_0x00c7:
            r18 = r22
        L_0x00c9:
            r1 = r1 | r18
        L_0x00cb:
            r18 = r10 & 32
            r23 = 65536(0x10000, float:9.18355E-41)
            r62 = 458752(0x70000, float:6.42848E-40)
            if (r18 == 0) goto L_0x00d8
            r18 = 196608(0x30000, float:2.75506E-40)
        L_0x00d5:
            r1 = r1 | r18
            goto L_0x00e8
        L_0x00d8:
            r18 = r11 & r62
            if (r18 != 0) goto L_0x00e8
            boolean r18 = r7.changed((java.lang.Object) r13)
            if (r18 == 0) goto L_0x00e5
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d5
        L_0x00e5:
            r18 = r23
            goto L_0x00d5
        L_0x00e8:
            r18 = r10 & 64
            r63 = 3670016(0x380000, float:5.142788E-39)
            if (r18 == 0) goto L_0x00f5
            r24 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r24
            r5 = r82
            goto L_0x010b
        L_0x00f5:
            r24 = r11 & r63
            if (r24 != 0) goto L_0x0109
            r5 = r82
            boolean r25 = r7.changed((boolean) r5)
            if (r25 == 0) goto L_0x0104
            r25 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0106
        L_0x0104:
            r25 = 524288(0x80000, float:7.34684E-40)
        L_0x0106:
            r1 = r1 | r25
            goto L_0x010b
        L_0x0109:
            r5 = r82
        L_0x010b:
            r6 = r10 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x0116
            r26 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r26
            r8 = r83
            goto L_0x012e
        L_0x0116:
            r26 = 29360128(0x1c00000, float:7.052966E-38)
            r26 = r11 & r26
            if (r26 != 0) goto L_0x012c
            r8 = r83
            boolean r27 = r7.changed((java.lang.Object) r8)
            if (r27 == 0) goto L_0x0127
            r27 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0129
        L_0x0127:
            r27 = 4194304(0x400000, float:5.877472E-39)
        L_0x0129:
            r1 = r1 | r27
            goto L_0x012e
        L_0x012c:
            r8 = r83
        L_0x012e:
            r3 = r10 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0139
            r27 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r27
            r4 = r84
            goto L_0x0151
        L_0x0139:
            r27 = 234881024(0xe000000, float:1.5777218E-30)
            r27 = r11 & r27
            if (r27 != 0) goto L_0x014f
            r4 = r84
            boolean r27 = r7.changed((java.lang.Object) r4)
            if (r27 == 0) goto L_0x014a
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x014c
        L_0x014a:
            r27 = 33554432(0x2000000, float:9.403955E-38)
        L_0x014c:
            r1 = r1 | r27
            goto L_0x0151
        L_0x014f:
            r4 = r84
        L_0x0151:
            r4 = r10 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x015c
            r27 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r27
            r5 = r85
            goto L_0x0174
        L_0x015c:
            r27 = 1879048192(0x70000000, float:1.58456325E29)
            r27 = r11 & r27
            if (r27 != 0) goto L_0x0172
            r5 = r85
            boolean r27 = r7.changed((java.lang.Object) r5)
            if (r27 == 0) goto L_0x016d
            r27 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x016f
        L_0x016d:
            r27 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x016f:
            r1 = r1 | r27
            goto L_0x0174
        L_0x0172:
            r5 = r85
        L_0x0174:
            r5 = r10 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x017d
            r2 = r2 | 6
            r8 = r86
            goto L_0x0193
        L_0x017d:
            r27 = r9 & 14
            if (r27 != 0) goto L_0x0191
            r8 = r86
            boolean r27 = r7.changed((java.lang.Object) r8)
            if (r27 == 0) goto L_0x018c
            r24 = 4
            goto L_0x018e
        L_0x018c:
            r24 = 2
        L_0x018e:
            r2 = r2 | r24
            goto L_0x0193
        L_0x0191:
            r8 = r86
        L_0x0193:
            r8 = r10 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x019c
            r2 = r2 | 48
            r12 = r87
            goto L_0x01b2
        L_0x019c:
            r24 = r9 & 112(0x70, float:1.57E-43)
            if (r24 != 0) goto L_0x01b0
            r12 = r87
            boolean r24 = r7.changed((java.lang.Object) r12)
            if (r24 == 0) goto L_0x01ab
            r25 = 32
            goto L_0x01ad
        L_0x01ab:
            r25 = 16
        L_0x01ad:
            r2 = r2 | r25
            goto L_0x01b2
        L_0x01b0:
            r12 = r87
        L_0x01b2:
            r12 = r9 & 896(0x380, float:1.256E-42)
            if (r12 != 0) goto L_0x01ca
            r12 = r10 & 4096(0x1000, float:5.74E-42)
            if (r12 != 0) goto L_0x01c3
            r12 = r88
            boolean r24 = r7.changed((java.lang.Object) r12)
            if (r24 == 0) goto L_0x01c5
            goto L_0x01c7
        L_0x01c3:
            r12 = r88
        L_0x01c5:
            r16 = r17
        L_0x01c7:
            r2 = r2 | r16
            goto L_0x01cc
        L_0x01ca:
            r12 = r88
        L_0x01cc:
            r12 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x01e4
            r12 = r10 & 8192(0x2000, float:1.14794E-41)
            if (r12 != 0) goto L_0x01dd
            r12 = r89
            boolean r16 = r7.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x01df
            goto L_0x01e1
        L_0x01dd:
            r12 = r89
        L_0x01df:
            r19 = r20
        L_0x01e1:
            r2 = r2 | r19
            goto L_0x01e6
        L_0x01e4:
            r12 = r89
        L_0x01e6:
            r16 = r9 & r61
            if (r16 != 0) goto L_0x01fe
            r12 = r10 & 16384(0x4000, float:2.2959E-41)
            if (r12 != 0) goto L_0x01f7
            r12 = r90
            boolean r16 = r7.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x01f9
            goto L_0x01fb
        L_0x01f7:
            r12 = r90
        L_0x01f9:
            r21 = r22
        L_0x01fb:
            r2 = r2 | r21
            goto L_0x0200
        L_0x01fe:
            r12 = r90
        L_0x0200:
            r16 = 32768(0x8000, float:4.5918E-41)
            r64 = r10 & r16
            if (r64 == 0) goto L_0x020e
            r16 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r16
            r14 = r91
            goto L_0x0224
        L_0x020e:
            r16 = r9 & r62
            if (r16 != 0) goto L_0x0222
            r14 = r91
            boolean r16 = r7.changed((java.lang.Object) r14)
            if (r16 == 0) goto L_0x021d
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x021f
        L_0x021d:
            r16 = r23
        L_0x021f:
            r2 = r2 | r16
            goto L_0x0224
        L_0x0222:
            r14 = r91
        L_0x0224:
            r16 = r10 & r23
            if (r16 == 0) goto L_0x022d
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x022a:
            r2 = r2 | r16
            goto L_0x023d
        L_0x022d:
            r16 = r9 & r63
            if (r16 != 0) goto L_0x023d
            boolean r16 = r7.changed((java.lang.Object) r0)
            if (r16 == 0) goto L_0x023a
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x022a
        L_0x023a:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x022a
        L_0x023d:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r9 = r1 & r16
            r92 = r1
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r1) goto L_0x0278
            r1 = 2995931(0x2db6db, float:4.198194E-39)
            r1 = r1 & r2
            r9 = 599186(0x92492, float:8.39638E-40)
            if (r1 != r9) goto L_0x0278
            boolean r1 = r7.getSkipping()
            if (r1 != 0) goto L_0x0259
            goto L_0x0278
        L_0x0259:
            r7.skipToGroupEnd()
            r65 = r82
            r66 = r83
            r67 = r84
            r68 = r85
            r69 = r86
            r70 = r87
            r71 = r88
            r21 = r89
            r23 = r92
            r26 = r2
            r25 = r7
            r22 = r12
            r24 = r14
            goto L_0x04ac
        L_0x0278:
            r7.startDefaults()
            r1 = r11 & 1
            if (r1 == 0) goto L_0x02d3
            boolean r1 = r7.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0286
            goto L_0x02d3
        L_0x0286:
            r7.skipToGroupEnd()
            r1 = r10 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x028f
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x028f:
            r1 = r10 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0295
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0295:
            r1 = r10 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x02b8
            r1 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r2
            r65 = r82
            r66 = r83
            r67 = r84
            r68 = r85
            r69 = r86
            r70 = r87
            r71 = r88
            r20 = r89
            r72 = r92
            r13 = r1
            r15 = r10
            r21 = r12
            r22 = r14
            r14 = r7
            goto L_0x03fc
        L_0x02b8:
            r65 = r82
            r66 = r83
            r67 = r84
            r68 = r85
            r69 = r86
            r70 = r87
            r71 = r88
            r20 = r89
            r72 = r92
            r13 = r2
            r15 = r10
            r21 = r12
            r22 = r14
            r14 = r7
            goto L_0x03fc
        L_0x02d3:
            if (r18 == 0) goto L_0x02d9
            r1 = 0
            r65 = r1
            goto L_0x02db
        L_0x02d9:
            r65 = r82
        L_0x02db:
            if (r6 == 0) goto L_0x02e1
            r1 = 0
            r66 = r1
            goto L_0x02e3
        L_0x02e1:
            r66 = r83
        L_0x02e3:
            if (r3 == 0) goto L_0x02e9
            r1 = 0
            r67 = r1
            goto L_0x02eb
        L_0x02e9:
            r67 = r84
        L_0x02eb:
            if (r4 == 0) goto L_0x02f1
            r1 = 0
            r68 = r1
            goto L_0x02f3
        L_0x02f1:
            r68 = r85
        L_0x02f3:
            if (r5 == 0) goto L_0x02f9
            r1 = 0
            r69 = r1
            goto L_0x02fb
        L_0x02f9:
            r69 = r86
        L_0x02fb:
            if (r8 == 0) goto L_0x0301
            r1 = 0
            r70 = r1
            goto L_0x0303
        L_0x0301:
            r70 = r87
        L_0x0303:
            r1 = r10 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0315
            int r1 = r2 >> 18
            r1 = r1 & 14
            androidx.compose.ui.graphics.Shape r1 = r0.getFilledShape(r7, r1)
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            r71 = r1
            r9 = r2
            goto L_0x0318
        L_0x0315:
            r71 = r88
            r9 = r2
        L_0x0318:
            r1 = r10 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x037e
            r1 = 0
            r8 = r92
            r3 = 0
            r5 = 0
            r16 = 0
            r92 = r7
            r72 = r8
            r7 = r16
            r1 = r9
            r2 = r10
            r9 = r16
            r16 = 0
            r11 = r16
            r16 = 0
            r12 = r16
            r14 = r16
            r18 = 0
            r20 = 0
            r22 = 0
            r24 = 0
            r26 = 0
            r28 = 0
            r30 = 0
            r32 = 0
            r34 = 0
            r36 = 0
            r38 = 0
            r40 = 0
            r42 = 0
            r44 = 0
            r46 = 0
            r48 = 0
            r50 = 0
            r52 = 0
            r54 = 0
            r57 = 0
            r58 = 0
            int r56 = r1 << 6
            r59 = 234881024(0xe000000, float:1.5777218E-30)
            r59 = r56 & r59
            r60 = 268435455(0xfffffff, float:2.5243547E-29)
            r0 = r75
            r56 = r92
            r73 = r1
            r1 = 0
            androidx.compose.material3.TextFieldColors r0 = r0.m2157textFieldColorsl59Burw(r1, r3, r5, r7, r9, r11, r12, r14, r16, r18, r20, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r57, r58, r59, r60)
            r2 = r73
            r9 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0385
        L_0x037e:
            r72 = r92
            r92 = r7
            r2 = r9
            r0 = r89
        L_0x0385:
            r15 = r95
            r1 = r15 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x03c6
            if (r66 != 0) goto L_0x03a7
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 15
            r6 = 0
            r82 = r75
            r83 = r1
            r84 = r2
            r85 = r3
            r86 = r4
            r87 = r5
            r88 = r6
            androidx.compose.foundation.layout.PaddingValues r1 = m2147textFieldWithoutLabelPaddinga9UjIt4$default(r82, r83, r84, r85, r86, r87, r88)
            goto L_0x03c0
        L_0x03a7:
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 15
            r6 = 0
            r82 = r75
            r83 = r1
            r84 = r2
            r85 = r3
            r86 = r4
            r87 = r5
            r88 = r6
            androidx.compose.foundation.layout.PaddingValues r1 = m2146textFieldWithLabelPaddinga9UjIt4$default(r82, r83, r84, r85, r86, r87, r88)
        L_0x03c0:
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            r9 = r9 & r2
            goto L_0x03c8
        L_0x03c6:
            r1 = r90
        L_0x03c8:
            if (r64 == 0) goto L_0x03f3
            androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$1 r2 = new androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$1
            r82 = r2
            r83 = r78
            r84 = r65
            r85 = r81
            r86 = r0
            r87 = r71
            r88 = r72
            r89 = r9
            r82.<init>(r83, r84, r85, r86, r87, r88, r89)
            r3 = -1171460386(0xffffffffba2ceede, float:-6.596873E-4)
            r4 = 1
            r14 = r92
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r3, r4, r2)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r20 = r0
            r21 = r1
            r22 = r2
            r13 = r9
            goto L_0x03fc
        L_0x03f3:
            r14 = r92
            r22 = r91
            r20 = r0
            r21 = r1
            r13 = r9
        L_0x03fc:
            r14.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0410
            r0 = -1224712461(0xffffffffb7005ef3, float:-7.651502E-6)
            java.lang.String r1 = "androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:527)"
            r12 = r72
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r13, r1)
            goto L_0x0412
        L_0x0410:
            r12 = r72
        L_0x0412:
            androidx.compose.material3.TextFieldType r0 = androidx.compose.material3.TextFieldType.Filled
            int r1 = r12 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            int r2 = r12 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r12 >> 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r12 >> 9
            r2 = r2 & r61
            r1 = r1 | r2
            int r2 = r12 >> 9
            r2 = r2 & r62
            r1 = r1 | r2
            int r2 = r12 >> 9
            r2 = r2 & r63
            r1 = r1 | r2
            int r2 = r13 << 21
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r3
            r1 = r1 | r2
            int r2 = r13 << 21
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r3
            r1 = r1 | r2
            int r2 = r12 << 18
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r3
            r17 = r1 | r2
            int r1 = r12 >> 6
            r1 = r1 & 14
            int r2 = r12 >> 15
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r2 = r12 >> 9
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r13 >> 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r13 << 3
            r2 = r2 & r61
            r1 = r1 | r2
            r2 = r13 & r62
            r18 = r1 | r2
            r19 = 0
            r1 = r76
            r2 = r77
            r3 = r80
            r4 = r66
            r5 = r67
            r6 = r68
            r7 = r69
            r8 = r70
            r9 = r79
            r10 = r78
            r11 = r65
            r23 = r12
            r12 = r81
            r24 = r13
            r13 = r21
            r25 = r14
            r14 = r20
            r15 = r22
            r16 = r25
            androidx.compose.material3.TextFieldImplKt.CommonDecorationBox(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x04a4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04a4:
            r26 = r24
            r24 = r22
            r22 = r21
            r21 = r20
        L_0x04ac:
            androidx.compose.runtime.ScopeUpdateScope r15 = r25.endRestartGroup()
            if (r15 != 0) goto L_0x04b3
            goto L_0x04ed
        L_0x04b3:
            androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$2 r27 = new androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$2
            r0 = r27
            r1 = r75
            r2 = r76
            r3 = r77
            r4 = r78
            r5 = r79
            r6 = r80
            r7 = r81
            r8 = r65
            r9 = r66
            r10 = r67
            r11 = r68
            r12 = r69
            r13 = r70
            r14 = r71
            r74 = r15
            r15 = r21
            r16 = r22
            r17 = r24
            r18 = r93
            r19 = r94
            r20 = r95
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r0 = r27
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r74
            r1.updateScope(r0)
        L_0x04ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:143:0x01d4, code lost:
        if (r8.changed((java.lang.Object) r95) != false) goto L_0x01db;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0425  */
    /* JADX WARNING: Removed duplicated region for block: B:226:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0156  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void OutlinedTextFieldDecorationBox(java.lang.String r82, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r83, boolean r84, boolean r85, androidx.compose.ui.text.input.VisualTransformation r86, androidx.compose.foundation.interaction.InteractionSource r87, boolean r88, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r89, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r90, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r91, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r92, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r93, androidx.compose.material3.TextFieldColors r94, androidx.compose.foundation.layout.PaddingValues r95, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r96, androidx.compose.runtime.Composer r97, int r98, int r99, int r100) {
        /*
            r81 = this;
            r15 = r82
            r14 = r83
            r13 = r86
            r12 = r87
            r11 = r98
            r10 = r99
            r9 = r100
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "innerTextField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "visualTransformation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 508645792(0x1e5151a0, float:1.10812475E-20)
            r1 = r97
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(OutlinedTextFieldDecorationBox)P(13,4,3,10,14,5,6,7,9,8,12,11!1,2)642@36360L25,648@36611L651:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r0 = r98
            r1 = r99
            r2 = r9 & 1
            if (r2 == 0) goto L_0x003f
            r0 = r0 | 6
            goto L_0x004d
        L_0x003f:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x004d
            boolean r2 = r8.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x004b
            r2 = 4
            goto L_0x004c
        L_0x004b:
            r2 = 2
        L_0x004c:
            r0 = r0 | r2
        L_0x004d:
            r2 = r9 & 2
            if (r2 == 0) goto L_0x0054
            r0 = r0 | 48
            goto L_0x0064
        L_0x0054:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0064
            boolean r2 = r8.changed((java.lang.Object) r14)
            if (r2 == 0) goto L_0x0061
            r2 = 32
            goto L_0x0063
        L_0x0061:
            r2 = 16
        L_0x0063:
            r0 = r0 | r2
        L_0x0064:
            r2 = r9 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x006f
            r0 = r0 | 384(0x180, float:5.38E-43)
            r2 = r84
            goto L_0x0085
        L_0x006f:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0083
            r2 = r84
            boolean r17 = r8.changed((boolean) r2)
            if (r17 == 0) goto L_0x007e
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x0080
        L_0x007e:
            r17 = r16
        L_0x0080:
            r0 = r0 | r17
            goto L_0x0085
        L_0x0083:
            r2 = r84
        L_0x0085:
            r17 = r9 & 8
            r18 = 2048(0x800, float:2.87E-42)
            r19 = 1024(0x400, float:1.435E-42)
            if (r17 == 0) goto L_0x0092
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r3 = r85
            goto L_0x00a8
        L_0x0092:
            r3 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x00a6
            r3 = r85
            boolean r17 = r8.changed((boolean) r3)
            if (r17 == 0) goto L_0x00a1
            r17 = r18
            goto L_0x00a3
        L_0x00a1:
            r17 = r19
        L_0x00a3:
            r0 = r0 | r17
            goto L_0x00a8
        L_0x00a6:
            r3 = r85
        L_0x00a8:
            r17 = r9 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r77 = 57344(0xe000, float:8.0356E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r17 == 0) goto L_0x00b6
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00c7
        L_0x00b6:
            r17 = r11 & r77
            if (r17 != 0) goto L_0x00c7
            boolean r17 = r8.changed((java.lang.Object) r13)
            if (r17 == 0) goto L_0x00c3
            r17 = r20
            goto L_0x00c5
        L_0x00c3:
            r17 = r21
        L_0x00c5:
            r0 = r0 | r17
        L_0x00c7:
            r17 = r9 & 32
            r78 = 458752(0x70000, float:6.42848E-40)
            if (r17 == 0) goto L_0x00d2
            r17 = 196608(0x30000, float:2.75506E-40)
        L_0x00cf:
            r0 = r0 | r17
            goto L_0x00e2
        L_0x00d2:
            r17 = r11 & r78
            if (r17 != 0) goto L_0x00e2
            boolean r17 = r8.changed((java.lang.Object) r12)
            if (r17 == 0) goto L_0x00df
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cf
        L_0x00df:
            r17 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00cf
        L_0x00e2:
            r17 = r9 & 64
            if (r17 == 0) goto L_0x00ed
            r22 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r22
            r4 = r88
            goto L_0x0105
        L_0x00ed:
            r22 = 3670016(0x380000, float:5.142788E-39)
            r22 = r11 & r22
            if (r22 != 0) goto L_0x0103
            r4 = r88
            boolean r23 = r8.changed((boolean) r4)
            if (r23 == 0) goto L_0x00fe
            r23 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0100
        L_0x00fe:
            r23 = 524288(0x80000, float:7.34684E-40)
        L_0x0100:
            r0 = r0 | r23
            goto L_0x0105
        L_0x0103:
            r4 = r88
        L_0x0105:
            r5 = r9 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x0110
            r24 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r24
            r6 = r89
            goto L_0x0128
        L_0x0110:
            r24 = 29360128(0x1c00000, float:7.052966E-38)
            r24 = r11 & r24
            if (r24 != 0) goto L_0x0126
            r6 = r89
            boolean r25 = r8.changed((java.lang.Object) r6)
            if (r25 == 0) goto L_0x0121
            r25 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0123
        L_0x0121:
            r25 = 4194304(0x400000, float:5.877472E-39)
        L_0x0123:
            r0 = r0 | r25
            goto L_0x0128
        L_0x0126:
            r6 = r89
        L_0x0128:
            r7 = r9 & 256(0x100, float:3.59E-43)
            r79 = 234881024(0xe000000, float:1.5777218E-30)
            if (r7 == 0) goto L_0x0135
            r26 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r26
            r2 = r90
            goto L_0x014b
        L_0x0135:
            r26 = r11 & r79
            if (r26 != 0) goto L_0x0149
            r2 = r90
            boolean r26 = r8.changed((java.lang.Object) r2)
            if (r26 == 0) goto L_0x0144
            r26 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0146
        L_0x0144:
            r26 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0146:
            r0 = r0 | r26
            goto L_0x014b
        L_0x0149:
            r2 = r90
        L_0x014b:
            r2 = r9 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0156
            r26 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r26
            r3 = r91
            goto L_0x016e
        L_0x0156:
            r26 = 1879048192(0x70000000, float:1.58456325E29)
            r26 = r11 & r26
            if (r26 != 0) goto L_0x016c
            r3 = r91
            boolean r26 = r8.changed((java.lang.Object) r3)
            if (r26 == 0) goto L_0x0167
            r26 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0169
        L_0x0167:
            r26 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0169:
            r0 = r0 | r26
            goto L_0x016e
        L_0x016c:
            r3 = r91
        L_0x016e:
            r3 = r9 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0177
            r1 = r1 | 6
            r4 = r92
            goto L_0x018d
        L_0x0177:
            r26 = r10 & 14
            if (r26 != 0) goto L_0x018b
            r4 = r92
            boolean r26 = r8.changed((java.lang.Object) r4)
            if (r26 == 0) goto L_0x0186
            r22 = 4
            goto L_0x0188
        L_0x0186:
            r22 = 2
        L_0x0188:
            r1 = r1 | r22
            goto L_0x018d
        L_0x018b:
            r4 = r92
        L_0x018d:
            r4 = r9 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x0196
            r1 = r1 | 48
            r6 = r93
            goto L_0x01ac
        L_0x0196:
            r22 = r10 & 112(0x70, float:1.57E-43)
            if (r22 != 0) goto L_0x01aa
            r6 = r93
            boolean r22 = r8.changed((java.lang.Object) r6)
            if (r22 == 0) goto L_0x01a5
            r23 = 32
            goto L_0x01a7
        L_0x01a5:
            r23 = 16
        L_0x01a7:
            r1 = r1 | r23
            goto L_0x01ac
        L_0x01aa:
            r6 = r93
        L_0x01ac:
            r6 = r10 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x01c4
            r6 = r9 & 4096(0x1000, float:5.74E-42)
            if (r6 != 0) goto L_0x01bf
            r6 = r94
            boolean r22 = r8.changed((java.lang.Object) r6)
            if (r22 == 0) goto L_0x01c1
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x01c1
        L_0x01bf:
            r6 = r94
        L_0x01c1:
            r1 = r1 | r16
            goto L_0x01c6
        L_0x01c4:
            r6 = r94
        L_0x01c6:
            r6 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x01de
            r6 = r9 & 8192(0x2000, float:1.14794E-41)
            if (r6 != 0) goto L_0x01d7
            r6 = r95
            boolean r16 = r8.changed((java.lang.Object) r6)
            if (r16 == 0) goto L_0x01d9
            goto L_0x01db
        L_0x01d7:
            r6 = r95
        L_0x01d9:
            r18 = r19
        L_0x01db:
            r1 = r1 | r18
            goto L_0x01e0
        L_0x01de:
            r6 = r95
        L_0x01e0:
            r6 = r9 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x01e9
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r12 = r96
            goto L_0x01fd
        L_0x01e9:
            r16 = r10 & r77
            if (r16 != 0) goto L_0x01fb
            r12 = r96
            boolean r16 = r8.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x01f6
            goto L_0x01f8
        L_0x01f6:
            r20 = r21
        L_0x01f8:
            r1 = r1 | r20
            goto L_0x01fd
        L_0x01fb:
            r12 = r96
        L_0x01fd:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r9 & r16
            if (r16 == 0) goto L_0x020b
            r16 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r16
            r15 = r81
            goto L_0x0221
        L_0x020b:
            r16 = r10 & r78
            if (r16 != 0) goto L_0x021f
            r15 = r81
            boolean r16 = r8.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x021a
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x021c
        L_0x021a:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x021c:
            r1 = r1 | r16
            goto L_0x0221
        L_0x021f:
            r15 = r81
        L_0x0221:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r10 = r0 & r16
            r12 = 306783378(0x12492492, float:6.3469493E-28)
            if (r10 != r12) goto L_0x0258
            r10 = 374491(0x5b6db, float:5.24774E-40)
            r10 = r10 & r1
            r12 = 74898(0x12492, float:1.04954E-40)
            if (r10 != r12) goto L_0x0258
            boolean r10 = r8.getSkipping()
            if (r10 != 0) goto L_0x023b
            goto L_0x0258
        L_0x023b:
            r8.skipToGroupEnd()
            r20 = r88
            r21 = r89
            r22 = r90
            r23 = r91
            r24 = r92
            r25 = r93
            r26 = r94
            r27 = r95
            r28 = r96
            r29 = r0
            r31 = r1
            r30 = r8
            goto L_0x041e
        L_0x0258:
            r8.startDefaults()
            r10 = r11 & 1
            if (r10 == 0) goto L_0x028a
            boolean r10 = r8.getDefaultsInvalid()
            if (r10 == 0) goto L_0x0266
            goto L_0x028a
        L_0x0266:
            r8.skipToGroupEnd()
            r2 = r9 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x026f
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x026f:
            r2 = r9 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0275
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0275:
            r20 = r88
            r21 = r89
            r22 = r90
            r23 = r91
            r24 = r92
            r25 = r93
            r26 = r94
            r27 = r95
            r28 = r96
            r12 = r1
            goto L_0x037a
        L_0x028a:
            if (r17 == 0) goto L_0x028e
            r10 = 0
            goto L_0x0290
        L_0x028e:
            r10 = r88
        L_0x0290:
            if (r5 == 0) goto L_0x0294
            r5 = 0
            goto L_0x0296
        L_0x0294:
            r5 = r89
        L_0x0296:
            if (r7 == 0) goto L_0x029a
            r7 = 0
            goto L_0x029c
        L_0x029a:
            r7 = r90
        L_0x029c:
            if (r2 == 0) goto L_0x02a0
            r2 = 0
            goto L_0x02a2
        L_0x02a0:
            r2 = r91
        L_0x02a2:
            if (r3 == 0) goto L_0x02a6
            r3 = 0
            goto L_0x02a8
        L_0x02a6:
            r3 = r92
        L_0x02a8:
            if (r4 == 0) goto L_0x02ac
            r4 = 0
            goto L_0x02ae
        L_0x02ac:
            r4 = r93
        L_0x02ae:
            r12 = r9 & 4096(0x1000, float:5.74E-42)
            if (r12 == 0) goto L_0x0300
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r28 = 0
            r30 = 0
            r32 = 0
            r34 = 0
            r36 = 0
            r38 = 0
            r40 = 0
            r42 = 0
            r44 = 0
            r46 = 0
            r48 = 0
            r50 = 0
            r52 = 0
            r54 = 0
            r56 = 0
            r58 = 0
            r60 = 0
            r62 = 0
            r64 = 0
            r66 = 0
            r68 = 0
            r70 = 0
            r73 = 0
            r74 = 0
            int r12 = r1 << 9
            r75 = r12 & r79
            r76 = 268435455(0xfffffff, float:2.5243547E-29)
            r16 = r81
            r72 = r8
            androidx.compose.material3.TextFieldColors r12 = r16.m2154outlinedTextFieldColorsl59Burw(r17, r19, r21, r23, r25, r27, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r73, r74, r75, r76)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0302
        L_0x0300:
            r12 = r94
        L_0x0302:
            r97 = r2
            r2 = r9 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0328
            r2 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 15
            r20 = 0
            r88 = r81
            r89 = r2
            r90 = r16
            r91 = r17
            r92 = r18
            r93 = r19
            r94 = r20
            androidx.compose.foundation.layout.PaddingValues r2 = m2144outlinedTextFieldPaddinga9UjIt4$default(r88, r89, r90, r91, r92, r93, r94)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x032a
        L_0x0328:
            r2 = r95
        L_0x032a:
            if (r6 == 0) goto L_0x0362
            androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$1 r6 = new androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$1
            r88 = r6
            r89 = r84
            r90 = r10
            r91 = r87
            r92 = r12
            r93 = r0
            r94 = r1
            r88.<init>(r89, r90, r91, r92, r93, r94)
            r88 = r1
            r1 = 144282315(0x89992cb, float:9.242863E-34)
            r89 = r2
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r1, r2, r6)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r27 = r89
            r23 = r97
            r28 = r1
            r24 = r3
            r25 = r4
            r21 = r5
            r22 = r7
            r20 = r10
            r26 = r12
            r12 = r88
            goto L_0x037a
        L_0x0362:
            r88 = r1
            r89 = r2
            r27 = r89
            r28 = r96
            r23 = r97
            r24 = r3
            r25 = r4
            r21 = r5
            r22 = r7
            r20 = r10
            r26 = r12
            r12 = r88
        L_0x037a:
            r8.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x038b
            r1 = 508645792(0x1e5151a0, float:1.10812475E-20)
            java.lang.String r2 = "androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:629)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r0, r12, r2)
        L_0x038b:
            androidx.compose.material3.TextFieldType r1 = androidx.compose.material3.TextFieldType.Outlined
            r29 = r0
            r0 = r1
            int r1 = r29 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            int r2 = r29 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r29 >> 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r29 >> 9
            r2 = r2 & r77
            r1 = r1 | r2
            int r2 = r29 >> 9
            r2 = r2 & r78
            r1 = r1 | r2
            int r2 = r29 >> 9
            r3 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r3
            r1 = r1 | r2
            int r2 = r12 << 21
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r3
            r1 = r1 | r2
            int r2 = r12 << 21
            r2 = r2 & r79
            r1 = r1 | r2
            int r2 = r29 << 18
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r3
            r17 = r1 | r2
            int r1 = r29 >> 6
            r1 = r1 & 14
            int r2 = r29 >> 15
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r2 = r29 >> 9
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r12 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r12 << 6
            r2 = r2 & r77
            r1 = r1 | r2
            int r2 = r12 << 3
            r2 = r2 & r78
            r18 = r1 | r2
            r19 = 0
            r1 = r82
            r2 = r83
            r3 = r86
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r30 = r8
            r8 = r25
            r9 = r85
            r10 = r84
            r11 = r20
            r31 = r12
            r12 = r87
            r13 = r27
            r14 = r26
            r15 = r28
            r16 = r30
            androidx.compose.material3.TextFieldImplKt.CommonDecorationBox(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x041e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x041e:
            androidx.compose.runtime.ScopeUpdateScope r15 = r30.endRestartGroup()
            if (r15 != 0) goto L_0x0425
            goto L_0x045d
        L_0x0425:
            androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$2 r32 = new androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$2
            r0 = r32
            r1 = r81
            r2 = r82
            r3 = r83
            r4 = r84
            r5 = r85
            r6 = r86
            r7 = r87
            r8 = r20
            r9 = r21
            r10 = r22
            r11 = r23
            r12 = r24
            r13 = r25
            r14 = r26
            r80 = r15
            r15 = r27
            r16 = r28
            r17 = r98
            r18 = r99
            r19 = r100
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = r32
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r80
            r1.updateScope(r0)
        L_0x045d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
