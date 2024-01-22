package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/SpanStyle;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$SpanStyleSaver$2 extends Lambda implements Function1<Object, SpanStyle> {
    public static final SaversKt$SpanStyleSaver$2 INSTANCE = new SaversKt$SpanStyleSaver$2();

    SaversKt$SpanStyleSaver$2() {
        super(1);
    }

    public final SpanStyle invoke(Object it) {
        Color color;
        TextUnit textUnit;
        FontWeight fontWeight;
        FontStyle fontStyle;
        FontSynthesis fontSynthesis;
        String str;
        TextUnit textUnit2;
        BaselineShift baselineShift;
        TextGeometricTransform textGeometricTransform;
        LocaleList localeList;
        Color color2;
        TextDecoration textDecoration;
        Shadow shadow;
        Object obj = it;
        Intrinsics.checkNotNullParameter(obj, "it");
        List list = (List) obj;
        Object value$iv = list.get(0);
        Saver $this$restore_u24lambda_u243_u24lambda_u242$iv = SaversKt.getSaver(Color.Companion);
        if (Intrinsics.areEqual(value$iv, (Object) false)) {
            color = null;
        } else if (value$iv != null) {
            Object obj2 = value$iv;
            color = $this$restore_u24lambda_u243_u24lambda_u242$iv.restore(value$iv);
        } else {
            color = null;
        }
        Intrinsics.checkNotNull(color);
        long r4 = color.m3174unboximpl();
        Object value$iv2 = list.get(1);
        Saver $this$restore_u24lambda_u243_u24lambda_u242$iv2 = SaversKt.getSaver(TextUnit.Companion);
        if (Intrinsics.areEqual(value$iv2, (Object) false)) {
            textUnit = null;
        } else if (value$iv2 != null) {
            Object obj3 = value$iv2;
            textUnit = $this$restore_u24lambda_u243_u24lambda_u242$iv2.restore(value$iv2);
        } else {
            textUnit = null;
        }
        Intrinsics.checkNotNull(textUnit);
        long r8 = textUnit.m6176unboximpl();
        Object value$iv3 = list.get(2);
        Saver $this$restore_u24lambda_u243_u24lambda_u242$iv3 = SaversKt.getSaver(FontWeight.Companion);
        if (Intrinsics.areEqual(value$iv3, (Object) false)) {
            fontWeight = null;
        } else if (value$iv3 != null) {
            Object obj4 = value$iv3;
            fontWeight = $this$restore_u24lambda_u243_u24lambda_u242$iv3.restore(value$iv3);
        } else {
            fontWeight = null;
        }
        Object value$iv4 = list.get(3);
        if (value$iv4 != null) {
            fontStyle = (FontStyle) value$iv4;
        } else {
            fontStyle = null;
        }
        Object value$iv5 = list.get(4);
        if (value$iv5 != null) {
            fontSynthesis = (FontSynthesis) value$iv5;
        } else {
            fontSynthesis = null;
        }
        Object value$iv6 = list.get(6);
        if (value$iv6 != null) {
            str = (String) value$iv6;
        } else {
            str = null;
        }
        Object value$iv7 = list.get(7);
        Saver $this$restore_u24lambda_u243_u24lambda_u242$iv4 = SaversKt.getSaver(TextUnit.Companion);
        if (Intrinsics.areEqual(value$iv7, (Object) false)) {
            textUnit2 = null;
        } else if (value$iv7 != null) {
            Object obj5 = value$iv7;
            textUnit2 = $this$restore_u24lambda_u243_u24lambda_u242$iv4.restore(value$iv7);
        } else {
            textUnit2 = null;
        }
        Intrinsics.checkNotNull(textUnit2);
        long r15 = textUnit2.m6176unboximpl();
        Object value$iv8 = list.get(8);
        Saver $this$restore_u24lambda_u243_u24lambda_u242$iv5 = SaversKt.getSaver(BaselineShift.Companion);
        if (Intrinsics.areEqual(value$iv8, (Object) false)) {
            baselineShift = null;
        } else if (value$iv8 != null) {
            Object obj6 = value$iv8;
            baselineShift = $this$restore_u24lambda_u243_u24lambda_u242$iv5.restore(value$iv8);
        } else {
            baselineShift = null;
        }
        Object value$iv9 = list.get(9);
        Saver $this$restore_u24lambda_u243_u24lambda_u242$iv6 = SaversKt.getSaver(TextGeometricTransform.Companion);
        if (Intrinsics.areEqual(value$iv9, (Object) false)) {
            textGeometricTransform = null;
        } else if (value$iv9 != null) {
            Object obj7 = value$iv9;
            textGeometricTransform = $this$restore_u24lambda_u243_u24lambda_u242$iv6.restore(value$iv9);
        } else {
            textGeometricTransform = null;
        }
        Object value$iv10 = list.get(10);
        Saver saver = SaversKt.getSaver(LocaleList.Companion);
        if (Intrinsics.areEqual(value$iv10, (Object) false)) {
            localeList = null;
        } else if (value$iv10 != null) {
            Object obj8 = value$iv10;
            Saver<LocaleList, Object> saver2 = saver;
            Saver<LocaleList, Object> saver3 = saver;
            localeList = saver.restore(value$iv10);
        } else {
            Saver saver$iv = saver;
            localeList = null;
        }
        Object value$iv11 = list.get(11);
        Saver saver4 = SaversKt.getSaver(Color.Companion);
        if (Intrinsics.areEqual(value$iv11, (Object) false)) {
            color2 = null;
        } else if (value$iv11 != null) {
            Object obj9 = value$iv11;
            Saver<Color, Object> saver5 = saver4;
            Saver<Color, Object> saver6 = saver4;
            color2 = saver4.restore(value$iv11);
        } else {
            Saver saver$iv2 = saver4;
            color2 = null;
        }
        Intrinsics.checkNotNull(color2);
        long r24 = color2.m3174unboximpl();
        Object value$iv12 = list.get(12);
        Saver saver7 = SaversKt.getSaver(TextDecoration.Companion);
        if (Intrinsics.areEqual(value$iv12, (Object) false)) {
            textDecoration = null;
        } else if (value$iv12 != null) {
            Object obj10 = value$iv12;
            Saver<TextDecoration, Object> saver8 = saver7;
            Saver<TextDecoration, Object> saver9 = saver7;
            textDecoration = saver7.restore(value$iv12);
        } else {
            Saver saver$iv3 = saver7;
            textDecoration = null;
        }
        Object value$iv13 = list.get(13);
        Saver $this$restore_u24lambda_u243_u24lambda_u242$iv7 = SaversKt.getSaver(Shadow.Companion);
        if (Intrinsics.areEqual(value$iv13, (Object) false)) {
            List list2 = list;
            shadow = null;
        } else if (value$iv13 != null) {
            Object obj11 = value$iv13;
            List list3 = list;
            shadow = $this$restore_u24lambda_u243_u24lambda_u242$iv7.restore(value$iv13);
        } else {
            shadow = null;
        }
        return new SpanStyle(r4, r8, fontWeight, fontStyle, fontSynthesis, (FontFamily) null, str, r15, baselineShift, textGeometricTransform, localeList, r24, textDecoration, shadow, 32, (DefaultConstructorMarker) null);
    }
}
