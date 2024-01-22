package androidx.compose.material3;

import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u0012J\u0001\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u0006+"}, d2 = {"Landroidx/compose/material3/Typography;", "", "displayLarge", "Landroidx/compose/ui/text/TextStyle;", "displayMedium", "displaySmall", "headlineLarge", "headlineMedium", "headlineSmall", "titleLarge", "titleMedium", "titleSmall", "bodyLarge", "bodyMedium", "bodySmall", "labelLarge", "labelMedium", "labelSmall", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "getBodyLarge", "()Landroidx/compose/ui/text/TextStyle;", "getBodyMedium", "getBodySmall", "getDisplayLarge", "getDisplayMedium", "getDisplaySmall", "getHeadlineLarge", "getHeadlineMedium", "getHeadlineSmall", "getLabelLarge", "getLabelMedium", "getLabelSmall", "getTitleLarge", "getTitleMedium", "getTitleSmall", "copy", "equals", "", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Typography.kt */
public final class Typography {
    private final TextStyle bodyLarge;
    private final TextStyle bodyMedium;
    private final TextStyle bodySmall;
    private final TextStyle displayLarge;
    private final TextStyle displayMedium;
    private final TextStyle displaySmall;
    private final TextStyle headlineLarge;
    private final TextStyle headlineMedium;
    private final TextStyle headlineSmall;
    private final TextStyle labelLarge;
    private final TextStyle labelMedium;
    private final TextStyle labelSmall;
    private final TextStyle titleLarge;
    private final TextStyle titleMedium;
    private final TextStyle titleSmall;

    public Typography() {
        this((TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, 32767, (DefaultConstructorMarker) null);
    }

    public Typography(TextStyle displayLarge2, TextStyle displayMedium2, TextStyle displaySmall2, TextStyle headlineLarge2, TextStyle headlineMedium2, TextStyle headlineSmall2, TextStyle titleLarge2, TextStyle titleMedium2, TextStyle titleSmall2, TextStyle bodyLarge2, TextStyle bodyMedium2, TextStyle bodySmall2, TextStyle labelLarge2, TextStyle labelMedium2, TextStyle labelSmall2) {
        TextStyle textStyle = displayLarge2;
        TextStyle textStyle2 = displayMedium2;
        TextStyle textStyle3 = displaySmall2;
        TextStyle textStyle4 = headlineLarge2;
        TextStyle textStyle5 = headlineMedium2;
        TextStyle textStyle6 = headlineSmall2;
        TextStyle textStyle7 = titleLarge2;
        TextStyle textStyle8 = titleMedium2;
        TextStyle textStyle9 = titleSmall2;
        TextStyle textStyle10 = bodyLarge2;
        TextStyle textStyle11 = bodyMedium2;
        TextStyle textStyle12 = bodySmall2;
        TextStyle textStyle13 = labelLarge2;
        TextStyle textStyle14 = labelMedium2;
        TextStyle textStyle15 = labelSmall2;
        Intrinsics.checkNotNullParameter(textStyle, "displayLarge");
        Intrinsics.checkNotNullParameter(textStyle2, "displayMedium");
        Intrinsics.checkNotNullParameter(textStyle3, "displaySmall");
        Intrinsics.checkNotNullParameter(textStyle4, "headlineLarge");
        Intrinsics.checkNotNullParameter(textStyle5, "headlineMedium");
        Intrinsics.checkNotNullParameter(textStyle6, "headlineSmall");
        Intrinsics.checkNotNullParameter(textStyle7, "titleLarge");
        Intrinsics.checkNotNullParameter(textStyle8, "titleMedium");
        Intrinsics.checkNotNullParameter(textStyle9, "titleSmall");
        Intrinsics.checkNotNullParameter(textStyle10, "bodyLarge");
        Intrinsics.checkNotNullParameter(textStyle11, "bodyMedium");
        Intrinsics.checkNotNullParameter(textStyle12, "bodySmall");
        Intrinsics.checkNotNullParameter(textStyle13, "labelLarge");
        Intrinsics.checkNotNullParameter(textStyle14, "labelMedium");
        Intrinsics.checkNotNullParameter(textStyle15, "labelSmall");
        this.displayLarge = textStyle;
        this.displayMedium = textStyle2;
        this.displaySmall = textStyle3;
        this.headlineLarge = textStyle4;
        this.headlineMedium = textStyle5;
        this.headlineSmall = textStyle6;
        this.titleLarge = textStyle7;
        this.titleMedium = textStyle8;
        this.titleSmall = textStyle9;
        this.bodyLarge = textStyle10;
        this.bodyMedium = textStyle11;
        this.bodySmall = textStyle12;
        this.labelLarge = textStyle13;
        this.labelMedium = textStyle14;
        this.labelSmall = textStyle15;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Typography(androidx.compose.ui.text.TextStyle r16, androidx.compose.ui.text.TextStyle r17, androidx.compose.ui.text.TextStyle r18, androidx.compose.ui.text.TextStyle r19, androidx.compose.ui.text.TextStyle r20, androidx.compose.ui.text.TextStyle r21, androidx.compose.ui.text.TextStyle r22, androidx.compose.ui.text.TextStyle r23, androidx.compose.ui.text.TextStyle r24, androidx.compose.ui.text.TextStyle r25, androidx.compose.ui.text.TextStyle r26, androidx.compose.ui.text.TextStyle r27, androidx.compose.ui.text.TextStyle r28, androidx.compose.ui.text.TextStyle r29, androidx.compose.ui.text.TextStyle r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r15 = this;
            r0 = r31
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.material3.tokens.TypographyTokens r1 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r1 = r1.getDisplayLarge()
            goto L_0x000f
        L_0x000d:
            r1 = r16
        L_0x000f:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x001a
            androidx.compose.material3.tokens.TypographyTokens r2 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r2 = r2.getDisplayMedium()
            goto L_0x001c
        L_0x001a:
            r2 = r17
        L_0x001c:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0027
            androidx.compose.material3.tokens.TypographyTokens r3 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r3 = r3.getDisplaySmall()
            goto L_0x0029
        L_0x0027:
            r3 = r18
        L_0x0029:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0034
            androidx.compose.material3.tokens.TypographyTokens r4 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r4 = r4.getHeadlineLarge()
            goto L_0x0036
        L_0x0034:
            r4 = r19
        L_0x0036:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0041
            androidx.compose.material3.tokens.TypographyTokens r5 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r5 = r5.getHeadlineMedium()
            goto L_0x0043
        L_0x0041:
            r5 = r20
        L_0x0043:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x004e
            androidx.compose.material3.tokens.TypographyTokens r6 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r6 = r6.getHeadlineSmall()
            goto L_0x0050
        L_0x004e:
            r6 = r21
        L_0x0050:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x005b
            androidx.compose.material3.tokens.TypographyTokens r7 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r7 = r7.getTitleLarge()
            goto L_0x005d
        L_0x005b:
            r7 = r22
        L_0x005d:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0068
            androidx.compose.material3.tokens.TypographyTokens r8 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r8 = r8.getTitleMedium()
            goto L_0x006a
        L_0x0068:
            r8 = r23
        L_0x006a:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0075
            androidx.compose.material3.tokens.TypographyTokens r9 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r9 = r9.getTitleSmall()
            goto L_0x0077
        L_0x0075:
            r9 = r24
        L_0x0077:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0082
            androidx.compose.material3.tokens.TypographyTokens r10 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r10 = r10.getBodyLarge()
            goto L_0x0084
        L_0x0082:
            r10 = r25
        L_0x0084:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x008f
            androidx.compose.material3.tokens.TypographyTokens r11 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r11 = r11.getBodyMedium()
            goto L_0x0091
        L_0x008f:
            r11 = r26
        L_0x0091:
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x009c
            androidx.compose.material3.tokens.TypographyTokens r12 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r12 = r12.getBodySmall()
            goto L_0x009e
        L_0x009c:
            r12 = r27
        L_0x009e:
            r13 = r0 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x00a9
            androidx.compose.material3.tokens.TypographyTokens r13 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r13 = r13.getLabelLarge()
            goto L_0x00ab
        L_0x00a9:
            r13 = r28
        L_0x00ab:
            r14 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x00b6
            androidx.compose.material3.tokens.TypographyTokens r14 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r14 = r14.getLabelMedium()
            goto L_0x00b8
        L_0x00b6:
            r14 = r29
        L_0x00b8:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x00c3
            androidx.compose.material3.tokens.TypographyTokens r0 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r0 = r0.getLabelSmall()
            goto L_0x00c5
        L_0x00c3:
            r0 = r30
        L_0x00c5:
            r16 = r15
            r17 = r1
            r18 = r2
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r11
            r28 = r12
            r29 = r13
            r30 = r14
            r31 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.Typography.<init>(androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final TextStyle getDisplayLarge() {
        return this.displayLarge;
    }

    public final TextStyle getDisplayMedium() {
        return this.displayMedium;
    }

    public final TextStyle getDisplaySmall() {
        return this.displaySmall;
    }

    public final TextStyle getHeadlineLarge() {
        return this.headlineLarge;
    }

    public final TextStyle getHeadlineMedium() {
        return this.headlineMedium;
    }

    public final TextStyle getHeadlineSmall() {
        return this.headlineSmall;
    }

    public final TextStyle getTitleLarge() {
        return this.titleLarge;
    }

    public final TextStyle getTitleMedium() {
        return this.titleMedium;
    }

    public final TextStyle getTitleSmall() {
        return this.titleSmall;
    }

    public final TextStyle getBodyLarge() {
        return this.bodyLarge;
    }

    public final TextStyle getBodyMedium() {
        return this.bodyMedium;
    }

    public final TextStyle getBodySmall() {
        return this.bodySmall;
    }

    public final TextStyle getLabelLarge() {
        return this.labelLarge;
    }

    public final TextStyle getLabelMedium() {
        return this.labelMedium;
    }

    public final TextStyle getLabelSmall() {
        return this.labelSmall;
    }

    public static /* synthetic */ Typography copy$default(Typography typography, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, TextStyle textStyle14, TextStyle textStyle15, int i, Object obj) {
        TextStyle textStyle16;
        TextStyle textStyle17;
        TextStyle textStyle18;
        TextStyle textStyle19;
        TextStyle textStyle20;
        TextStyle textStyle21;
        TextStyle textStyle22;
        TextStyle textStyle23;
        TextStyle textStyle24;
        TextStyle textStyle25;
        TextStyle textStyle26;
        TextStyle textStyle27;
        TextStyle textStyle28;
        TextStyle textStyle29;
        TextStyle textStyle30;
        Typography typography2 = typography;
        int i2 = i;
        if ((i2 & 1) != 0) {
            textStyle16 = typography2.displayLarge;
        } else {
            textStyle16 = textStyle;
        }
        if ((i2 & 2) != 0) {
            textStyle17 = typography2.displayMedium;
        } else {
            textStyle17 = textStyle2;
        }
        if ((i2 & 4) != 0) {
            textStyle18 = typography2.displaySmall;
        } else {
            textStyle18 = textStyle3;
        }
        if ((i2 & 8) != 0) {
            textStyle19 = typography2.headlineLarge;
        } else {
            textStyle19 = textStyle4;
        }
        if ((i2 & 16) != 0) {
            textStyle20 = typography2.headlineMedium;
        } else {
            textStyle20 = textStyle5;
        }
        if ((i2 & 32) != 0) {
            textStyle21 = typography2.headlineSmall;
        } else {
            textStyle21 = textStyle6;
        }
        if ((i2 & 64) != 0) {
            textStyle22 = typography2.titleLarge;
        } else {
            textStyle22 = textStyle7;
        }
        if ((i2 & 128) != 0) {
            textStyle23 = typography2.titleMedium;
        } else {
            textStyle23 = textStyle8;
        }
        if ((i2 & 256) != 0) {
            textStyle24 = typography2.titleSmall;
        } else {
            textStyle24 = textStyle9;
        }
        if ((i2 & 512) != 0) {
            textStyle25 = typography2.bodyLarge;
        } else {
            textStyle25 = textStyle10;
        }
        if ((i2 & 1024) != 0) {
            textStyle26 = typography2.bodyMedium;
        } else {
            textStyle26 = textStyle11;
        }
        if ((i2 & 2048) != 0) {
            textStyle27 = typography2.bodySmall;
        } else {
            textStyle27 = textStyle12;
        }
        if ((i2 & 4096) != 0) {
            textStyle28 = typography2.labelLarge;
        } else {
            textStyle28 = textStyle13;
        }
        if ((i2 & 8192) != 0) {
            textStyle29 = typography2.labelMedium;
        } else {
            textStyle29 = textStyle14;
        }
        if ((i2 & 16384) != 0) {
            textStyle30 = typography2.labelSmall;
        } else {
            textStyle30 = textStyle15;
        }
        return typography.copy(textStyle16, textStyle17, textStyle18, textStyle19, textStyle20, textStyle21, textStyle22, textStyle23, textStyle24, textStyle25, textStyle26, textStyle27, textStyle28, textStyle29, textStyle30);
    }

    public final Typography copy(TextStyle displayLarge2, TextStyle displayMedium2, TextStyle displaySmall2, TextStyle headlineLarge2, TextStyle headlineMedium2, TextStyle headlineSmall2, TextStyle titleLarge2, TextStyle titleMedium2, TextStyle titleSmall2, TextStyle bodyLarge2, TextStyle bodyMedium2, TextStyle bodySmall2, TextStyle labelLarge2, TextStyle labelMedium2, TextStyle labelSmall2) {
        Intrinsics.checkNotNullParameter(displayLarge2, "displayLarge");
        Intrinsics.checkNotNullParameter(displayMedium2, "displayMedium");
        Intrinsics.checkNotNullParameter(displaySmall2, "displaySmall");
        Intrinsics.checkNotNullParameter(headlineLarge2, "headlineLarge");
        Intrinsics.checkNotNullParameter(headlineMedium2, "headlineMedium");
        Intrinsics.checkNotNullParameter(headlineSmall2, "headlineSmall");
        Intrinsics.checkNotNullParameter(titleLarge2, "titleLarge");
        Intrinsics.checkNotNullParameter(titleMedium2, "titleMedium");
        Intrinsics.checkNotNullParameter(titleSmall2, "titleSmall");
        Intrinsics.checkNotNullParameter(bodyLarge2, "bodyLarge");
        Intrinsics.checkNotNullParameter(bodyMedium2, "bodyMedium");
        Intrinsics.checkNotNullParameter(bodySmall2, "bodySmall");
        Intrinsics.checkNotNullParameter(labelLarge2, "labelLarge");
        Intrinsics.checkNotNullParameter(labelMedium2, "labelMedium");
        Intrinsics.checkNotNullParameter(labelSmall2, "labelSmall");
        return new Typography(displayLarge2, displayMedium2, displaySmall2, headlineLarge2, headlineMedium2, headlineSmall2, titleLarge2, titleMedium2, titleSmall2, bodyLarge2, bodyMedium2, bodySmall2, labelLarge2, labelMedium2, labelSmall2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof Typography) && Intrinsics.areEqual((Object) this.displayLarge, (Object) ((Typography) other).displayLarge) && Intrinsics.areEqual((Object) this.displayMedium, (Object) ((Typography) other).displayMedium) && Intrinsics.areEqual((Object) this.displaySmall, (Object) ((Typography) other).displaySmall) && Intrinsics.areEqual((Object) this.headlineLarge, (Object) ((Typography) other).headlineLarge) && Intrinsics.areEqual((Object) this.headlineMedium, (Object) ((Typography) other).headlineMedium) && Intrinsics.areEqual((Object) this.headlineSmall, (Object) ((Typography) other).headlineSmall) && Intrinsics.areEqual((Object) this.titleLarge, (Object) ((Typography) other).titleLarge) && Intrinsics.areEqual((Object) this.titleMedium, (Object) ((Typography) other).titleMedium) && Intrinsics.areEqual((Object) this.titleSmall, (Object) ((Typography) other).titleSmall) && Intrinsics.areEqual((Object) this.bodyLarge, (Object) ((Typography) other).bodyLarge) && Intrinsics.areEqual((Object) this.bodyMedium, (Object) ((Typography) other).bodyMedium) && Intrinsics.areEqual((Object) this.bodySmall, (Object) ((Typography) other).bodySmall) && Intrinsics.areEqual((Object) this.labelLarge, (Object) ((Typography) other).labelLarge) && Intrinsics.areEqual((Object) this.labelMedium, (Object) ((Typography) other).labelMedium) && Intrinsics.areEqual((Object) this.labelSmall, (Object) ((Typography) other).labelSmall)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.displayLarge.hashCode() * 31) + this.displayMedium.hashCode()) * 31) + this.displaySmall.hashCode()) * 31) + this.headlineLarge.hashCode()) * 31) + this.headlineMedium.hashCode()) * 31) + this.headlineSmall.hashCode()) * 31) + this.titleLarge.hashCode()) * 31) + this.titleMedium.hashCode()) * 31) + this.titleSmall.hashCode()) * 31) + this.bodyLarge.hashCode()) * 31) + this.bodyMedium.hashCode()) * 31) + this.bodySmall.hashCode()) * 31) + this.labelLarge.hashCode()) * 31) + this.labelMedium.hashCode()) * 31) + this.labelSmall.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Typography(displayLarge=").append(this.displayLarge).append(", displayMedium=").append(this.displayMedium).append(",displaySmall=").append(this.displaySmall).append(", headlineLarge=").append(this.headlineLarge).append(", headlineMedium=").append(this.headlineMedium).append(", headlineSmall=").append(this.headlineSmall).append(", titleLarge=").append(this.titleLarge).append(", titleMedium=").append(this.titleMedium).append(", titleSmall=").append(this.titleSmall).append(", bodyLarge=").append(this.bodyLarge).append(", bodyMedium=").append(this.bodyMedium).append(", bodySmall=");
        sb.append(this.bodySmall).append(", labelLarge=").append(this.labelLarge).append(", labelMedium=").append(this.labelMedium).append(", labelSmall=").append(this.labelSmall).append(')');
        return sb.toString();
    }
}
