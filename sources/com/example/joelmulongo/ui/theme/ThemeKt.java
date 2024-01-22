package com.example.joelmulongo.ui.theme;

import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"DarkColorScheme", "Landroidx/compose/material3/ColorScheme;", "LightColorScheme", "JoelMulongoTheme", "", "darkTheme", "", "dynamicColor", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "app_debug"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Theme.kt */
public final class ThemeKt {
    private static final ColorScheme DarkColorScheme = ColorSchemeKt.m1856darkColorSchemeG1PFcw$default(ColorKt.getPurple80(), 0, 0, 0, 0, ColorKt.getPurpleGrey80(), 0, 0, 0, ColorKt.getPink80(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 536870366, (Object) null);
    private static final ColorScheme LightColorScheme = ColorSchemeKt.m1858lightColorSchemeG1PFcw$default(ColorKt.getPurple40(), 0, 0, 0, 0, ColorKt.getPurpleGrey40(), 0, 0, 0, ColorKt.getPink40(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 536870366, (Object) null);

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007b, code lost:
        if ((r15 & 2) != 0) goto L_0x0092;
     */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void JoelMulongoTheme(boolean r10, boolean r11, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -2049294654(0xffffffff85da3ec2, float:-2.0523675E-35)
            androidx.compose.runtime.Composer r13 = r13.startRestartGroup(r0)
            java.lang.String r1 = "C(JoelMulongoTheme)P(1,2)41@1302L21,55@1821L7,64@2124L126:Theme.kt#2x5zkh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r14
            r2 = r14 & 14
            if (r2 != 0) goto L_0x0024
            r2 = r15 & 1
            if (r2 != 0) goto L_0x0022
            boolean r2 = r13.changed((boolean) r10)
            if (r2 == 0) goto L_0x0022
            r2 = 4
            goto L_0x0023
        L_0x0022:
            r2 = 2
        L_0x0023:
            r1 = r1 | r2
        L_0x0024:
            r2 = r14 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0038
            r2 = r15 & 2
            if (r2 != 0) goto L_0x0035
            boolean r2 = r13.changed((boolean) r11)
            if (r2 == 0) goto L_0x0035
            r2 = 32
            goto L_0x0037
        L_0x0035:
            r2 = 16
        L_0x0037:
            r1 = r1 | r2
        L_0x0038:
            r2 = r15 & 4
            if (r2 == 0) goto L_0x003f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x004f
        L_0x003f:
            r2 = r14 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x004f
            boolean r2 = r13.changedInstance(r12)
            if (r2 == 0) goto L_0x004c
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x004e
        L_0x004c:
            r2 = 128(0x80, float:1.794E-43)
        L_0x004e:
            r1 = r1 | r2
        L_0x004f:
            r2 = r1 & 731(0x2db, float:1.024E-42)
            r3 = 146(0x92, float:2.05E-43)
            if (r2 != r3) goto L_0x0061
            boolean r2 = r13.getSkipping()
            if (r2 != 0) goto L_0x005c
            goto L_0x0061
        L_0x005c:
            r13.skipToGroupEnd()
            goto L_0x0139
        L_0x0061:
            r13.startDefaults()
            r2 = r14 & 1
            r3 = 0
            if (r2 == 0) goto L_0x007e
            boolean r2 = r13.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0070
            goto L_0x007e
        L_0x0070:
            r13.skipToGroupEnd()
            r2 = r15 & 1
            if (r2 == 0) goto L_0x0079
            r1 = r1 & -15
        L_0x0079:
            r2 = r15 & 2
            if (r2 == 0) goto L_0x0094
            goto L_0x0092
        L_0x007e:
            r2 = r15 & 1
            if (r2 == 0) goto L_0x0088
            boolean r10 = androidx.compose.foundation.DarkThemeKt.isSystemInDarkTheme(r13, r3)
            r1 = r1 & -15
        L_0x0088:
            r2 = r15 & 2
            if (r2 == 0) goto L_0x0096
            com.example.joelmulongo.ui.theme.LiveLiterals$ThemeKt r2 = com.example.joelmulongo.ui.theme.LiveLiterals$ThemeKt.INSTANCE
            boolean r11 = r2.m295Boolean$paramdynamicColor$funJoelMulongoTheme()
        L_0x0092:
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0094:
            r8 = r1
            goto L_0x0097
        L_0x0096:
            r8 = r1
        L_0x0097:
            r13.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00a6
            r1 = -1
            java.lang.String r2 = "com.example.joelmulongo.ui.theme.JoelMulongoTheme (Theme.kt:40)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r8, r1, r2)
        L_0x00a6:
            r0 = 1946052577(0x73fe67e1, float:4.0312204E31)
            r13.startReplaceableGroup(r0)
            java.lang.String r0 = "48@1604L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            java.lang.String r0 = "CC:CompositionLocal.kt#9igjgp"
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            if (r11 == 0) goto L_0x00e0
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 31
            if (r2 < r4) goto L_0x00e0
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 0
            r5 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r1, r0)
            java.lang.Object r6 = r13.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r2 = r6
            android.content.Context r2 = (android.content.Context) r2
            if (r10 == 0) goto L_0x00db
            androidx.compose.material3.ColorScheme r4 = androidx.compose.material3.DynamicTonalPaletteKt.dynamicDarkColorScheme(r2)
            goto L_0x00e7
        L_0x00db:
            androidx.compose.material3.ColorScheme r4 = androidx.compose.material3.DynamicTonalPaletteKt.dynamicLightColorScheme(r2)
            goto L_0x00e7
        L_0x00e0:
            if (r10 == 0) goto L_0x00e5
            androidx.compose.material3.ColorScheme r4 = DarkColorScheme
            goto L_0x00e7
        L_0x00e5:
            androidx.compose.material3.ColorScheme r4 = LightColorScheme
        L_0x00e7:
            r13.endReplaceableGroup()
            r9 = r4
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 0
            r5 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r1, r0)
            java.lang.Object r0 = r13.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            android.view.View r0 = (android.view.View) r0
            r1 = 1946052928(0x73fe6940, float:4.0313053E31)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "57@1867L245"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            boolean r1 = r0.isInEditMode()
            if (r1 != 0) goto L_0x011a
            com.example.joelmulongo.ui.theme.ThemeKt$JoelMulongoTheme$1 r1 = new com.example.joelmulongo.ui.theme.ThemeKt$JoelMulongoTheme$1
            r1.<init>(r0, r9, r10)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            androidx.compose.runtime.EffectsKt.SideEffect(r1, r13, r3)
        L_0x011a:
            r13.endReplaceableGroup()
            r2 = 0
            androidx.compose.material3.Typography r3 = com.example.joelmulongo.ui.theme.TypeKt.getTypography()
            int r1 = r8 << 3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r6 = r1 | 384(0x180, float:5.38E-43)
            r7 = 2
            r1 = r9
            r4 = r12
            r5 = r13
            androidx.compose.material3.MaterialThemeKt.MaterialTheme(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0138
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0138:
            r1 = r8
        L_0x0139:
            androidx.compose.runtime.ScopeUpdateScope r0 = r13.endRestartGroup()
            if (r0 != 0) goto L_0x0140
            goto L_0x0150
        L_0x0140:
            com.example.joelmulongo.ui.theme.ThemeKt$JoelMulongoTheme$2 r8 = new com.example.joelmulongo.ui.theme.ThemeKt$JoelMulongoTheme$2
            r2 = r8
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r14
            r7 = r15
            r2.<init>(r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r0.updateScope(r8)
        L_0x0150:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.joelmulongo.ui.theme.ThemeKt.JoelMulongoTheme(boolean, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
