package androidx.compose.ui.text.platform;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontListFontFamily;
import androidx.compose.ui.text.font.FontMatcher;
import androidx.compose.ui.text.font.FontSynthesis_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\fø\u0001\u0000¢\u0006\u0002\u0010\rJ-\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u00020\f¢\u0006\n\n\u0002\b\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"Landroidx/compose/ui/text/platform/AndroidFontListTypeface;", "Landroidx/compose/ui/text/platform/AndroidTypeface;", "fontFamily", "Landroidx/compose/ui/text/font/FontListFontFamily;", "context", "Landroid/content/Context;", "necessaryStyles", "", "Lkotlin/Pair;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "(Landroidx/compose/ui/text/font/FontListFontFamily;Landroid/content/Context;Ljava/util/List;Landroidx/compose/ui/text/font/FontMatcher;)V", "Landroidx/compose/ui/text/font/FontFamily;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "fontMatcher$1", "loadedTypefaces", "", "Landroidx/compose/ui/text/font/Font;", "Landroid/graphics/Typeface;", "getNativeTypeface", "fontWeight", "fontStyle", "synthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "getNativeTypeface-PYhJU0U", "(Landroidx/compose/ui/text/font/FontWeight;II)Landroid/graphics/Typeface;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(message = "This is not supported after downloadable fonts.")
/* compiled from: AndroidFontListTypeface.android.kt */
public final class AndroidFontListTypeface implements AndroidTypeface {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Deprecated
    public static final FontMatcher fontMatcher = new FontMatcher();
    private final FontFamily fontFamily;
    private final FontMatcher fontMatcher$1;
    private final Map<Font, Typeface> loadedTypefaces;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0176  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AndroidFontListTypeface(androidx.compose.ui.text.font.FontListFontFamily r20, android.content.Context r21, java.util.List<kotlin.Pair<androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle>> r22, androidx.compose.ui.text.font.FontMatcher r23) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r23
            java.lang.String r0 = "fontFamily"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "fontMatcher"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r19.<init>()
            r1.fontMatcher$1 = r4
            java.util.List r0 = r20.getFonts()
            r5 = 0
            java.util.ArrayList r6 = new java.util.ArrayList
            int r7 = r0.size()
            r6.<init>(r7)
            r7 = r0
            r8 = 0
            r9 = 0
            int r10 = r7.size()
        L_0x0034:
            if (r9 >= r10) goto L_0x0061
            java.lang.Object r11 = r7.get(r9)
            r12 = r11
            r13 = 0
            r14 = r12
            androidx.compose.ui.text.font.Font r14 = (androidx.compose.ui.text.font.Font) r14
            r15 = 0
            r16 = r0
            int r0 = r14.m5534getLoadingStrategyPKNRLFQ()
            androidx.compose.ui.text.font.FontLoadingStrategy$Companion r17 = androidx.compose.ui.text.font.FontLoadingStrategy.Companion
            int r4 = r17.m5555getBlockingPKNRLFQ()
            boolean r0 = androidx.compose.ui.text.font.FontLoadingStrategy.m5550equalsimpl0(r0, r4)
            if (r0 == 0) goto L_0x0058
            r0 = r6
            java.util.Collection r0 = (java.util.Collection) r0
            r0.add(r12)
        L_0x0058:
            int r9 = r9 + 1
            r4 = r23
            r0 = r16
            goto L_0x0034
        L_0x0061:
            r16 = r0
            r0 = r6
            java.util.List r0 = (java.util.List) r0
            r4 = r0
            if (r22 == 0) goto L_0x0118
            r0 = r22
            r5 = 0
            java.util.ArrayList r6 = new java.util.ArrayList
            int r7 = r0.size()
            r6.<init>(r7)
            r7 = r0
            r8 = 0
            r9 = 0
            int r10 = r7.size()
        L_0x007f:
            if (r9 >= r10) goto L_0x00bd
            java.lang.Object r11 = r7.get(r9)
            r12 = r11
            r13 = 0
            r14 = r6
            java.util.Collection r14 = (java.util.Collection) r14
            r15 = r12
            kotlin.Pair r15 = (kotlin.Pair) r15
            r16 = 0
            java.lang.Object r17 = r15.component1()
            r18 = r0
            r0 = r17
            androidx.compose.ui.text.font.FontWeight r0 = (androidx.compose.ui.text.font.FontWeight) r0
            java.lang.Object r15 = r15.component2()
            androidx.compose.ui.text.font.FontStyle r15 = (androidx.compose.ui.text.font.FontStyle) r15
            int r15 = r15.m5566unboximpl()
            r17 = r5
            androidx.compose.ui.text.font.FontMatcher r5 = r1.fontMatcher$1
            java.util.List r5 = r5.m5559matchFontRetOiIg((java.util.List<? extends androidx.compose.ui.text.font.Font>) r4, (androidx.compose.ui.text.font.FontWeight) r0, (int) r15)
            java.lang.Object r5 = kotlin.collections.CollectionsKt.firstOrNull(r5)
            androidx.compose.ui.text.font.Font r5 = (androidx.compose.ui.text.font.Font) r5
            r14.add(r5)
            int r9 = r9 + 1
            r5 = r17
            r0 = r18
            goto L_0x007f
        L_0x00bd:
            r18 = r0
            r17 = r5
            r0 = r6
            java.util.List r0 = (java.util.List) r0
            java.util.List r0 = androidx.compose.ui.text.TempListUtilsKt.fastFilterNotNull(r0)
            if (r0 == 0) goto L_0x0118
            r5 = 0
            java.util.HashSet r6 = new java.util.HashSet
            int r7 = r0.size()
            r6.<init>(r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            int r8 = r0.size()
            r7.<init>(r8)
            r8 = r0
            r9 = 0
            r10 = 0
            int r11 = r8.size()
        L_0x00ea:
            if (r10 >= r11) goto L_0x0111
            java.lang.Object r12 = r8.get(r10)
            r13 = r12
            r14 = 0
            r15 = r13
            androidx.compose.ui.text.font.Font r15 = (androidx.compose.ui.text.font.Font) r15
            r16 = 0
            boolean r16 = r6.add(r15)
            if (r16 == 0) goto L_0x0108
            r16 = r0
            r0 = r7
            java.util.Collection r0 = (java.util.Collection) r0
            r0.add(r13)
            goto L_0x010a
        L_0x0108:
            r16 = r0
        L_0x010a:
            int r10 = r10 + 1
            r0 = r16
            goto L_0x00ea
        L_0x0111:
            r16 = r0
            r0 = r7
            java.util.List r0 = (java.util.List) r0
            goto L_0x0119
        L_0x0118:
            r0 = 0
        L_0x0119:
            r5 = r0
            if (r5 != 0) goto L_0x011e
            r0 = r4
            goto L_0x011f
        L_0x011e:
            r0 = r5
        L_0x011f:
            r6 = r0
            boolean r0 = r6.isEmpty()
            if (r0 != 0) goto L_0x0176
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            r7 = r0
            java.util.Map r7 = (java.util.Map) r7
            r8 = r6
            r9 = 0
            r0 = 0
            int r10 = r8.size()
            r11 = r0
        L_0x0137:
            if (r11 >= r10) goto L_0x016c
            java.lang.Object r12 = r8.get(r11)
            r13 = r12
            androidx.compose.ui.text.font.Font r13 = (androidx.compose.ui.text.font.Font) r13
            r14 = 0
            androidx.compose.ui.text.platform.AndroidTypefaceCache r0 = androidx.compose.ui.text.platform.AndroidTypefaceCache.INSTANCE     // Catch:{ Exception -> 0x0150 }
            android.graphics.Typeface r0 = r0.getOrCreate(r3, r13)     // Catch:{ Exception -> 0x0150 }
            r7.put(r13, r0)     // Catch:{ Exception -> 0x0150 }
            int r11 = r11 + 1
            goto L_0x0137
        L_0x0150:
            r0 = move-exception
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r16 = r0
            java.lang.String r0 = "Cannot create Typeface from "
            java.lang.StringBuilder r0 = r15.append(r0)
            java.lang.StringBuilder r0 = r0.append(r13)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L_0x016c:
            r1.loadedTypefaces = r7
            r0 = r2
            androidx.compose.ui.text.font.FontFamily r0 = (androidx.compose.ui.text.font.FontFamily) r0
            r1.fontFamily = r0
            return
        L_0x0176:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r7 = "Could not match font"
            r0.<init>(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidFontListTypeface.<init>(androidx.compose.ui.text.font.FontListFontFamily, android.content.Context, java.util.List, androidx.compose.ui.text.font.FontMatcher):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AndroidFontListTypeface(FontListFontFamily fontListFontFamily, Context context, List list, FontMatcher fontMatcher2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fontListFontFamily, context, (i & 4) != 0 ? null : list, (i & 8) != 0 ? fontMatcher : fontMatcher2);
    }

    public final FontMatcher getFontMatcher() {
        return this.fontMatcher$1;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidFontListTypeface$Companion;", "", "()V", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidFontListTypeface.android.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FontMatcher getFontMatcher() {
            return AndroidFontListTypeface.fontMatcher;
        }
    }

    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    /* renamed from: getNativeTypeface-PYhJU0U  reason: not valid java name */
    public Typeface m5700getNativeTypefacePYhJU0U(FontWeight fontWeight, int fontStyle, int synthesis) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Font font = (Font) CollectionsKt.firstOrNull(this.fontMatcher$1.m5559matchFontRetOiIg((List<? extends Font>) new ArrayList(this.loadedTypefaces.keySet()), fontWeight, fontStyle));
        if (font != null) {
            Typeface typeface = this.loadedTypefaces.get(font);
            if (typeface != null) {
                Object r2 = FontSynthesis_androidKt.m5582synthesizeTypefaceFxwP2eA(synthesis, typeface, font, fontWeight, fontStyle);
                Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.graphics.Typeface");
                return (Typeface) r2;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalStateException("Could not load font");
    }
}
