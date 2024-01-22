package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000bJ\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J\u0002\u0010*\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010)R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuDefaults;", "", "()V", "ItemContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getItemContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "TrailingIcon", "", "expanded", "", "(ZLandroidx/compose/runtime/Composer;I)V", "outlinedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "containerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-St-qZLY", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/TextFieldColors;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-St-qZLY", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
/* compiled from: ExposedDropdownMenu.kt */
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;
    public static final ExposedDropdownMenuDefaults INSTANCE = new ExposedDropdownMenuDefaults();
    private static final PaddingValues ItemContentPadding = PaddingKt.m754PaddingValuesYgX7TsA(ExposedDropdownMenuKt.ExposedDropdownMenuItemHorizontalPadding, Dp.m5986constructorimpl((float) 0));

    private ExposedDropdownMenuDefaults() {
    }

    @ExperimentalMaterial3Api
    public final void TrailingIcon(boolean expanded, Composer $composer, int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1803742020);
        ComposerKt.sourceInformation($composer2, "C(TrailingIcon)299@12322L129:ExposedDropdownMenu.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(expanded) ? 4 : 2;
        }
        if (($dirty & 11) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1803742020, $changed, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.kt:298)");
            }
            IconKt.m1961Iconww6aTOc(ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE), (String) null, RotateKt.rotate(Modifier.Companion, expanded ? 180.0f : 0.0f), 0, $composer2, 48, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ExposedDropdownMenuDefaults$TrailingIcon$1(this, expanded, $changed));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v88, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: textFieldColors-St-qZLY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.material3.TextFieldColors m1913textFieldColorsStqZLY(long r109, long r111, long r113, long r115, long r117, androidx.compose.foundation.text.selection.TextSelectionColors r119, long r120, long r122, long r124, long r126, long r128, long r130, long r132, long r134, long r136, long r138, long r140, long r142, long r144, long r146, long r148, long r150, long r152, long r154, androidx.compose.runtime.Composer r156, int r157, int r158, int r159, int r160) {
        /*
            r108 = this;
            r14 = r156
            r15 = r157
            r12 = r158
            r13 = r159
            r0 = r160
            r1 = -2013303349(0xffffffff87ff6dcb, float:-3.8432666E-34)
            r14.startReplaceableGroup(r1)
            java.lang.String r2 = "C(textFieldColors)P(19:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,18,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,15:c#ui.graphics.Color,22:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,16:c#ui.graphics.Color,23:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)339@14991L9,340@15090L9,342@15264L9,343@15349L9,344@15449L9,345@15532L7,347@15652L9,349@15771L9,351@15897L9,354@16113L9,356@16233L9,358@16350L9,360@16474L9,363@16684L9,365@16806L9,367@16925L9,369@17051L9,372@17264L9,373@17360L9,374@17453L9,375@17553L9,376@17647L9,377@17742L9,379@17860L9,382@18007L1365:ExposedDropdownMenu.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            r2 = r0 & 1
            r3 = 6
            if (r2 == 0) goto L_0x0027
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldInputTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r61 = r4
            goto L_0x0029
        L_0x0027:
            r61 = r109
        L_0x0029:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0048
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldDisabledInputTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r6 = 1052938076(0x3ec28f5c, float:0.38)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 14
            r11 = 0
            long r4 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r4, r6, r7, r8, r9, r10, r11)
            r63 = r4
            goto L_0x004a
        L_0x0048:
            r63 = r111
        L_0x004a:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x005b
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldContainerColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r65 = r4
            goto L_0x005d
        L_0x005b:
            r65 = r113
        L_0x005d:
            r2 = r0 & 8
            if (r2 == 0) goto L_0x006e
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldCaretColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r67 = r4
            goto L_0x0070
        L_0x006e:
            r67 = r115
        L_0x0070:
            r2 = r0 & 16
            if (r2 == 0) goto L_0x0081
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorFocusCaretColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r69 = r4
            goto L_0x0083
        L_0x0081:
            r69 = r117
        L_0x0083:
            r2 = r0 & 32
            if (r2 == 0) goto L_0x00a4
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 0
            r5 = 0
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r6, r7)
            java.lang.Object r6 = r14.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r156)
            r2 = r6
            androidx.compose.foundation.text.selection.TextSelectionColors r2 = (androidx.compose.foundation.text.selection.TextSelectionColors) r2
            r71 = r2
            goto L_0x00a6
        L_0x00a4:
            r71 = r119
        L_0x00a6:
            r2 = r0 & 64
            if (r2 == 0) goto L_0x00b7
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldFocusActiveIndicatorColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r72 = r4
            goto L_0x00b9
        L_0x00b7:
            r72 = r120
        L_0x00b9:
            r2 = r0 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00ca
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldActiveIndicatorColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r74 = r4
            goto L_0x00cc
        L_0x00ca:
            r74 = r122
        L_0x00cc:
            r2 = r0 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x00f9
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldDisabledActiveIndicatorColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r2 = 1052938076(0x3ec28f5c, float:0.38)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 14
            r10 = 0
            r109 = r4
            r111 = r2
            r112 = r6
            r113 = r7
            r114 = r8
            r115 = r9
            r116 = r10
            long r4 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r109, r111, r112, r113, r114, r115, r116)
            r76 = r4
            goto L_0x00fb
        L_0x00f9:
            r76 = r124
        L_0x00fb:
            r2 = r0 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x010c
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorActiveIndicatorColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r78 = r4
            goto L_0x010e
        L_0x010c:
            r78 = r126
        L_0x010e:
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x011f
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldFocusLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r80 = r4
            goto L_0x0121
        L_0x011f:
            r80 = r128
        L_0x0121:
            r2 = r0 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0132
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r82 = r4
            goto L_0x0134
        L_0x0132:
            r82 = r130
        L_0x0134:
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x0161
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldDisabledLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r2 = 1052938076(0x3ec28f5c, float:0.38)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 14
            r10 = 0
            r109 = r4
            r111 = r2
            r112 = r6
            r113 = r7
            r114 = r8
            r115 = r9
            r116 = r10
            long r4 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r109, r111, r112, r113, r114, r115, r116)
            r84 = r4
            goto L_0x0163
        L_0x0161:
            r84 = r132
        L_0x0163:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0174
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r86 = r4
            goto L_0x0176
        L_0x0174:
            r86 = r134
        L_0x0176:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0187
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldFocusTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r88 = r4
            goto L_0x0189
        L_0x0187:
            r88 = r136
        L_0x0189:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x019c
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r90 = r4
            goto L_0x019e
        L_0x019c:
            r90 = r138
        L_0x019e:
            r2 = 65536(0x10000, float:9.18355E-41)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01cc
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldDisabledTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r2 = 1052938076(0x3ec28f5c, float:0.38)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 14
            r10 = 0
            r109 = r4
            r111 = r2
            r112 = r6
            r113 = r7
            r114 = r8
            r115 = r9
            r116 = r10
            long r4 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r109, r111, r112, r113, r114, r115, r116)
            r92 = r4
            goto L_0x01ce
        L_0x01cc:
            r92 = r140
        L_0x01ce:
            r2 = 131072(0x20000, float:1.83671E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01e0
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r94 = r4
            goto L_0x01e2
        L_0x01e0:
            r94 = r142
        L_0x01e2:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01f4
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldFocusLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r96 = r4
            goto L_0x01f6
        L_0x01f4:
            r96 = r144
        L_0x01f6:
            r2 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0208
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r98 = r4
            goto L_0x020a
        L_0x0208:
            r98 = r146
        L_0x020a:
            r2 = 1048576(0x100000, float:1.469368E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x021c
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldDisabledLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r100 = r4
            goto L_0x021e
        L_0x021c:
            r100 = r148
        L_0x021e:
            r2 = 2097152(0x200000, float:2.938736E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0230
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldErrorLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r102 = r4
            goto L_0x0232
        L_0x0230:
            r102 = r150
        L_0x0232:
            r2 = 4194304(0x400000, float:5.877472E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0244
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r104 = r4
            goto L_0x0246
        L_0x0244:
            r104 = r152
        L_0x0246:
            r2 = 8388608(0x800000, float:1.17549435E-38)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x0274
            androidx.compose.material3.tokens.FilledAutocompleteTokens r0 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldDisabledInputTextColor()
            long r2 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r14, r3)
            r0 = 1052938076(0x3ec28f5c, float:0.38)
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 14
            r8 = 0
            r109 = r2
            r111 = r0
            r112 = r4
            r113 = r5
            r114 = r6
            r115 = r7
            r116 = r8
            long r2 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r109, r111, r112, r113, r114, r115, r116)
            r106 = r2
            goto L_0x0276
        L_0x0274:
            r106 = r154
        L_0x0276:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0281
            java.lang.String r0 = "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:338)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r15, r12, r0)
        L_0x0281:
            androidx.compose.material3.TextFieldDefaults r0 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            r48 = 0
            r50 = 0
            r52 = 0
            r54 = 0
            r1 = r15 & 14
            r2 = r15 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r15 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r15 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r3 = r15 & r2
            r1 = r1 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r4 = r15 & r3
            r1 = r1 | r4
            r4 = 3670016(0x380000, float:5.142788E-39)
            r5 = r15 & r4
            r1 = r1 | r5
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r15 & r5
            r1 = r1 | r6
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r7 = r15 & r6
            r1 = r1 | r7
            r7 = 1879048192(0x70000000, float:1.58456325E29)
            r8 = r15 & r7
            r57 = r1 | r8
            r1 = r12 & 14
            r8 = r12 & 112(0x70, float:1.57E-43)
            r1 = r1 | r8
            r8 = r12 & 896(0x380, float:1.256E-42)
            r1 = r1 | r8
            r8 = r12 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r8
            r2 = r2 & r12
            r1 = r1 | r2
            r2 = r12 & r3
            r1 = r1 | r2
            r2 = r12 & r4
            r1 = r1 | r2
            r2 = r12 & r5
            r1 = r1 | r2
            r2 = r12 & r6
            r1 = r1 | r2
            r2 = r12 & r7
            r58 = r1 | r2
            r1 = 100663296(0x6000000, float:2.4074124E-35)
            r2 = r13 & 14
            r1 = r1 | r2
            r2 = r13 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r13 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r13 & 7168(0x1c00, float:1.0045E-41)
            r59 = r1 | r2
            r60 = 251658240(0xf000000, float:6.3108872E-30)
            r1 = r61
            r3 = r63
            r5 = r65
            r7 = r67
            r9 = r69
            r11 = r71
            r12 = r72
            r14 = r74
            r16 = r76
            r18 = r78
            r20 = r80
            r22 = r82
            r24 = r84
            r26 = r86
            r28 = r88
            r30 = r90
            r32 = r92
            r34 = r94
            r36 = r96
            r38 = r98
            r40 = r100
            r42 = r102
            r44 = r104
            r46 = r106
            r56 = r156
            androidx.compose.material3.TextFieldColors r0 = r0.m2157textFieldColorsl59Burw(r1, r3, r5, r7, r9, r11, r12, r14, r16, r18, r20, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r57, r58, r59, r60)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x033a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x033a:
            r156.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuDefaults.m1913textFieldColorsStqZLY(long, long, long, long, long, androidx.compose.foundation.text.selection.TextSelectionColors, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, androidx.compose.runtime.Composer, int, int, int, int):androidx.compose.material3.TextFieldColors");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v89, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: outlinedTextFieldColors-St-qZLY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.material3.TextFieldColors m1912outlinedTextFieldColorsStqZLY(long r109, long r111, long r113, long r115, long r117, androidx.compose.foundation.text.selection.TextSelectionColors r119, long r120, long r122, long r124, long r126, long r128, long r130, long r132, long r134, long r136, long r138, long r140, long r142, long r144, long r146, long r148, long r150, long r152, long r154, androidx.compose.runtime.Composer r156, int r157, int r158, int r159, int r160) {
        /*
            r108 = this;
            r14 = r156
            r15 = r157
            r12 = r158
            r13 = r159
            r0 = r160
            r1 = -83147315(0xfffffffffb0b45cd, float:-7.23145E35)
            r14.startReplaceableGroup(r1)
            java.lang.String r2 = "C(outlinedTextFieldColors)P(19:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,18,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,22:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,16:c#ui.graphics.Color,23:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)441@21894L9,442@21995L9,445@22217L9,447@22331L9,448@22414L7,449@22513L9,450@22611L9,452@22728L9,454@22917L9,456@23039L9,458@23158L9,460@23284L9,463@23498L9,465@23622L9,467@23743L9,469@23871L9,472@24088L9,473@24186L9,474@24281L9,475@24383L9,477@24563L9,478@24660L9,480@24780L9,483@24929L1349:ExposedDropdownMenu.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            r2 = r0 & 1
            r3 = 6
            if (r2 == 0) goto L_0x0027
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldInputTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r61 = r4
            goto L_0x0029
        L_0x0027:
            r61 = r109
        L_0x0029:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0048
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldDisabledInputTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r6 = 1052938076(0x3ec28f5c, float:0.38)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 14
            r11 = 0
            long r4 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r4, r6, r7, r8, r9, r10, r11)
            r63 = r4
            goto L_0x004a
        L_0x0048:
            r63 = r111
        L_0x004a:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0057
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r4 = r2.m3199getTransparent0d7_KjU()
            r65 = r4
            goto L_0x0059
        L_0x0057:
            r65 = r113
        L_0x0059:
            r2 = r0 & 8
            if (r2 == 0) goto L_0x006a
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldCaretColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r67 = r4
            goto L_0x006c
        L_0x006a:
            r67 = r115
        L_0x006c:
            r2 = r0 & 16
            if (r2 == 0) goto L_0x007d
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorFocusCaretColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r69 = r4
            goto L_0x007f
        L_0x007d:
            r69 = r117
        L_0x007f:
            r2 = r0 & 32
            if (r2 == 0) goto L_0x00a0
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 0
            r5 = 0
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r6, r7)
            java.lang.Object r6 = r14.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r156)
            r2 = r6
            androidx.compose.foundation.text.selection.TextSelectionColors r2 = (androidx.compose.foundation.text.selection.TextSelectionColors) r2
            r71 = r2
            goto L_0x00a2
        L_0x00a0:
            r71 = r119
        L_0x00a2:
            r2 = r0 & 64
            if (r2 == 0) goto L_0x00b3
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldFocusOutlineColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r72 = r4
            goto L_0x00b5
        L_0x00b3:
            r72 = r120
        L_0x00b5:
            r2 = r0 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00c6
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldOutlineColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r74 = r4
            goto L_0x00c8
        L_0x00c6:
            r74 = r122
        L_0x00c8:
            r2 = r0 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x00f5
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldDisabledOutlineColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r2 = 1039516303(0x3df5c28f, float:0.12)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 14
            r10 = 0
            r109 = r4
            r111 = r2
            r112 = r6
            r113 = r7
            r114 = r8
            r115 = r9
            r116 = r10
            long r4 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r109, r111, r112, r113, r114, r115, r116)
            r76 = r4
            goto L_0x00f7
        L_0x00f5:
            r76 = r124
        L_0x00f7:
            r2 = r0 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0108
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorOutlineColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r78 = r4
            goto L_0x010a
        L_0x0108:
            r78 = r126
        L_0x010a:
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x011b
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldFocusLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r80 = r4
            goto L_0x011d
        L_0x011b:
            r80 = r128
        L_0x011d:
            r2 = r0 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x012e
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r82 = r4
            goto L_0x0130
        L_0x012e:
            r82 = r130
        L_0x0130:
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x015d
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldDisabledLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r2 = 1052938076(0x3ec28f5c, float:0.38)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 14
            r10 = 0
            r109 = r4
            r111 = r2
            r112 = r6
            r113 = r7
            r114 = r8
            r115 = r9
            r116 = r10
            long r4 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r109, r111, r112, r113, r114, r115, r116)
            r84 = r4
            goto L_0x015f
        L_0x015d:
            r84 = r132
        L_0x015f:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0170
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r86 = r4
            goto L_0x0172
        L_0x0170:
            r86 = r134
        L_0x0172:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0183
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldFocusTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r88 = r4
            goto L_0x0185
        L_0x0183:
            r88 = r136
        L_0x0185:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0198
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r90 = r4
            goto L_0x019a
        L_0x0198:
            r90 = r138
        L_0x019a:
            r2 = 65536(0x10000, float:9.18355E-41)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01c8
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldDisabledTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r2 = 1052938076(0x3ec28f5c, float:0.38)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 14
            r10 = 0
            r109 = r4
            r111 = r2
            r112 = r6
            r113 = r7
            r114 = r8
            r115 = r9
            r116 = r10
            long r4 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r109, r111, r112, r113, r114, r115, r116)
            r92 = r4
            goto L_0x01ca
        L_0x01c8:
            r92 = r140
        L_0x01ca:
            r2 = 131072(0x20000, float:1.83671E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01dc
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r94 = r4
            goto L_0x01de
        L_0x01dc:
            r94 = r142
        L_0x01de:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01f0
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldFocusLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r96 = r4
            goto L_0x01f2
        L_0x01f0:
            r96 = r144
        L_0x01f2:
            r2 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0204
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r98 = r4
            goto L_0x0206
        L_0x0204:
            r98 = r146
        L_0x0206:
            r2 = 1048576(0x100000, float:1.469368E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0234
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldDisabledLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r2 = 1052938076(0x3ec28f5c, float:0.38)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 14
            r10 = 0
            r109 = r4
            r111 = r2
            r112 = r6
            r113 = r7
            r114 = r8
            r115 = r9
            r116 = r10
            long r4 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r109, r111, r112, r113, r114, r115, r116)
            r100 = r4
            goto L_0x0236
        L_0x0234:
            r100 = r148
        L_0x0236:
            r2 = 2097152(0x200000, float:2.938736E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0248
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldErrorLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r102 = r4
            goto L_0x024a
        L_0x0248:
            r102 = r150
        L_0x024a:
            r2 = 4194304(0x400000, float:5.877472E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x025c
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r104 = r4
            goto L_0x025e
        L_0x025c:
            r104 = r152
        L_0x025e:
            r2 = 8388608(0x800000, float:1.17549435E-38)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x028c
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldDisabledInputTextColor()
            long r2 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r14, r3)
            r0 = 1052938076(0x3ec28f5c, float:0.38)
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 14
            r8 = 0
            r109 = r2
            r111 = r0
            r112 = r4
            r113 = r5
            r114 = r6
            r115 = r7
            r116 = r8
            long r2 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r109, r111, r112, r113, r114, r115, r116)
            r106 = r2
            goto L_0x028e
        L_0x028c:
            r106 = r154
        L_0x028e:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0299
            java.lang.String r0 = "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:440)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r15, r12, r0)
        L_0x0299:
            androidx.compose.material3.TextFieldDefaults r0 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            r48 = 0
            r50 = 0
            r52 = 0
            r54 = 0
            r1 = r15 & 14
            r2 = r15 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r15 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r15 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r3 = r15 & r2
            r1 = r1 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r4 = r15 & r3
            r1 = r1 | r4
            r4 = 3670016(0x380000, float:5.142788E-39)
            r5 = r15 & r4
            r1 = r1 | r5
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r15 & r5
            r1 = r1 | r6
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r7 = r15 & r6
            r1 = r1 | r7
            r7 = 1879048192(0x70000000, float:1.58456325E29)
            r8 = r15 & r7
            r57 = r1 | r8
            r1 = r12 & 14
            r8 = r12 & 112(0x70, float:1.57E-43)
            r1 = r1 | r8
            r8 = r12 & 896(0x380, float:1.256E-42)
            r1 = r1 | r8
            r8 = r12 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r8
            r2 = r2 & r12
            r1 = r1 | r2
            r2 = r12 & r3
            r1 = r1 | r2
            r2 = r12 & r4
            r1 = r1 | r2
            r2 = r12 & r5
            r1 = r1 | r2
            r2 = r12 & r6
            r1 = r1 | r2
            r2 = r12 & r7
            r58 = r1 | r2
            r1 = 100663296(0x6000000, float:2.4074124E-35)
            r2 = r13 & 14
            r1 = r1 | r2
            r2 = r13 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r13 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r13 & 7168(0x1c00, float:1.0045E-41)
            r59 = r1 | r2
            r60 = 251658240(0xf000000, float:6.3108872E-30)
            r1 = r61
            r3 = r63
            r5 = r65
            r7 = r67
            r9 = r69
            r11 = r71
            r12 = r72
            r14 = r74
            r16 = r76
            r18 = r78
            r20 = r80
            r22 = r82
            r24 = r84
            r26 = r86
            r28 = r88
            r30 = r90
            r32 = r92
            r34 = r94
            r36 = r96
            r38 = r98
            r40 = r100
            r42 = r102
            r44 = r104
            r46 = r106
            r56 = r156
            androidx.compose.material3.TextFieldColors r0 = r0.m2154outlinedTextFieldColorsl59Burw(r1, r3, r5, r7, r9, r11, r12, r14, r16, r18, r20, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r57, r58, r59, r60)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0352
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0352:
            r156.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuDefaults.m1912outlinedTextFieldColorsStqZLY(long, long, long, long, long, androidx.compose.foundation.text.selection.TextSelectionColors, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, androidx.compose.runtime.Composer, int, int, int, int):androidx.compose.material3.TextFieldColors");
    }

    public final PaddingValues getItemContentPadding() {
        return ItemContentPadding;
    }
}
