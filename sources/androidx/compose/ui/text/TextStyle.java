package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\bG\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006BØ\u0001\b\u0017\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'ø\u0001\u0000¢\u0006\u0002\u0010(Bð\u0001\b\u0017\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,ø\u0001\u0000¢\u0006\u0002\u0010-B\u0002\b\u0016\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101ø\u0001\u0000¢\u0006\u0002\u00102B \u0002\b\u0017\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106ø\u0001\u0000¢\u0006\u0002\u00107Bª\u0002\b\u0017\u0012\b\u00108\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010:\u001a\u00020;\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106ø\u0001\u0000¢\u0006\u0002\u0010<B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*¢\u0006\u0002\u0010=Jµ\u0002\u0010w\u001a\u00020\u00002\b\u00108\u001a\u0004\u0018\u0001092\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00105\u001a\u0004\u0018\u000106H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bx\u0010yJ«\u0002\u0010w\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00105\u001a\u0004\u0018\u000106H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bz\u0010{Jã\u0001\u0010w\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b|\u0010}Jû\u0001\u0010w\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b~\u0010J\u0002\u0010w\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u000101ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0016\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001H\u0002J\u0011\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0000J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\u0010\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0001J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0005H\u0007J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0003H\u0007J\u0016\u0010\u0001\u001a\u00020\u00002\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0007J\u0013\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0005H\u0002J\u0013\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0003H\u0002J\u0013\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0000H\u0002J\t\u0010\u0001\u001a\u00020\u0005H\u0007J\t\u0010\u0001\u001a\u00020\u0003H\u0007J\t\u0010\u0001\u001a\u00020\u0014H\u0016R\u001a\u0010:\u001a\u00020;8GX\u0004¢\u0006\f\u0012\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001a\u0010\u001c\u001a\u00020\b8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bB\u0010CR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00178Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bD\u0010ER\u001c\u00108\u001a\u0004\u0018\u0001098GX\u0004¢\u0006\f\u0012\u0004\bF\u0010?\u001a\u0004\bG\u0010HR\u001a\u0010\u0007\u001a\u00020\b8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bI\u0010CR\u001c\u00103\u001a\u0004\u0018\u0001048GX\u0004¢\u0006\f\u0012\u0004\bJ\u0010?\u001a\u0004\bK\u0010LR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\bO\u0010PR\u001a\u0010\t\u001a\u00020\n8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bQ\u0010CR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000e8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bR\u0010SR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00108Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\bV\u0010WR\u001c\u00100\u001a\u0004\u0018\u0001018Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bX\u0010YR\u001a\u0010\u0015\u001a\u00020\n8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bZ\u0010CR\u001c\u0010.\u001a\u0004\u0018\u00010/8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u001a\u0010%\u001a\u00020\n8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b]\u0010CR\u0013\u0010+\u001a\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\bf\u0010gR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u001c\u0010!\u001a\u0004\u0018\u00010\"8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bj\u0010kR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\bl\u0010mR\u001c\u0010#\u001a\u0004\u0018\u00010$8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bn\u0010oR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\bp\u0010qR\u0013\u0010&\u001a\u0004\u0018\u00010'8F¢\u0006\u0006\u001a\u0004\br\u0010sR\u001c\u00105\u001a\u0004\u0018\u0001068GX\u0004¢\u0006\f\u0012\u0004\bt\u0010?\u001a\u0004\bu\u0010v\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/TextStyle;", "", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;)V", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "platformStyle", "Landroidx/compose/ui/text/PlatformTextStyle;", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;Landroidx/compose/ui/text/PlatformTextStyle;)V", "getAlpha$annotations", "()V", "getAlpha", "()F", "getBackground-0d7_KjU", "()J", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "getBrush$annotations", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getColor-0d7_KjU", "getDrawStyle$annotations", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontFeatureSettings", "()Ljava/lang/String;", "getFontSize-XSAIIZE", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getHyphens-EaSxIns", "()Landroidx/compose/ui/text/style/Hyphens;", "getLetterSpacing-XSAIIZE", "getLineBreak-LgCVezo", "()Landroidx/compose/ui/text/style/LineBreak;", "getLineHeight-XSAIIZE", "getLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getParagraphStyle$ui_text_release", "()Landroidx/compose/ui/text/ParagraphStyle;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformTextStyle;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "getSpanStyle$ui_text_release", "()Landroidx/compose/ui/text/SpanStyle;", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "getTextMotion$annotations", "getTextMotion", "()Landroidx/compose/ui/text/style/TextMotion;", "copy", "copy-aIRg9q4", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-v2rsoow", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-HL5avdY", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/TextStyle;", "copy-NOaFTUo", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;)Landroidx/compose/ui/text/TextStyle;", "copy-CXVQc50", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;)Landroidx/compose/ui/text/TextStyle;", "equals", "", "other", "hasSameLayoutAffectingAttributes", "hashCode", "", "hashCodeLayoutAffectingAttributes", "hashCodeLayoutAffectingAttributes$ui_text_release", "merge", "plus", "toParagraphStyle", "toSpanStyle", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextStyle.kt */
public final class TextStyle {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TextStyle Default = new TextStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4194303, (DefaultConstructorMarker) null);
    private final ParagraphStyle paragraphStyle;
    private final PlatformTextStyle platformStyle;
    private final SpanStyle spanStyle;

    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, drawStyle, textAlign, textDirection, j5, textIndent, platformTextStyle, lineHeightStyle, lineBreak, hyphens, textMotion);
    }

    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, textAlign, textDirection, j5, textIndent, platformTextStyle, lineHeightStyle, lineBreak, hyphens);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.")
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, textAlign, textDirection, j5, textIndent, platformTextStyle, lineHeightStyle);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.")
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, textAlign, textDirection, j5, textIndent);
    }

    public /* synthetic */ TextStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, drawStyle, textAlign, textDirection, j4, textIndent, platformTextStyle, lineHeightStyle, lineBreak, hyphens, textMotion);
    }

    public static /* synthetic */ void getAlpha$annotations() {
    }

    public static /* synthetic */ void getBrush$annotations() {
    }

    public static /* synthetic */ void getDrawStyle$annotations() {
    }

    public static /* synthetic */ void getTextMotion$annotations() {
    }

    public TextStyle(SpanStyle spanStyle2, ParagraphStyle paragraphStyle2, PlatformTextStyle platformStyle2) {
        Intrinsics.checkNotNullParameter(spanStyle2, "spanStyle");
        Intrinsics.checkNotNullParameter(paragraphStyle2, "paragraphStyle");
        this.spanStyle = spanStyle2;
        this.paragraphStyle = paragraphStyle2;
        this.platformStyle = platformStyle2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextStyle(SpanStyle spanStyle2, ParagraphStyle paragraphStyle2, PlatformTextStyle platformTextStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(spanStyle2, paragraphStyle2, (i & 4) != 0 ? null : platformTextStyle);
    }

    public final SpanStyle getSpanStyle$ui_text_release() {
        return this.spanStyle;
    }

    public final ParagraphStyle getParagraphStyle$ui_text_release() {
        return this.paragraphStyle;
    }

    public final PlatformTextStyle getPlatformStyle() {
        return this.platformStyle;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TextStyle(SpanStyle spanStyle2, ParagraphStyle paragraphStyle2) {
        this(spanStyle2, paragraphStyle2, TextStyleKt.createPlatformTextStyleInternal(spanStyle2.getPlatformStyle(), paragraphStyle2.getPlatformStyle()));
        Intrinsics.checkNotNullParameter(spanStyle2, "spanStyle");
        Intrinsics.checkNotNullParameter(paragraphStyle2, "paragraphStyle");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStyle(long r25, long r27, androidx.compose.ui.text.font.FontWeight r29, androidx.compose.ui.text.font.FontStyle r30, androidx.compose.ui.text.font.FontSynthesis r31, androidx.compose.ui.text.font.FontFamily r32, java.lang.String r33, long r34, androidx.compose.ui.text.style.BaselineShift r36, androidx.compose.ui.text.style.TextGeometricTransform r37, androidx.compose.ui.text.intl.LocaleList r38, long r39, androidx.compose.ui.text.style.TextDecoration r41, androidx.compose.ui.graphics.Shadow r42, androidx.compose.ui.text.style.TextAlign r43, androidx.compose.ui.text.style.TextDirection r44, long r45, androidx.compose.ui.text.style.TextIndent r47, int r48, kotlin.jvm.internal.DefaultConstructorMarker r49) {
        /*
            r24 = this;
            r0 = r48
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m3200getUnspecified0d7_KjU()
            goto L_0x000f
        L_0x000d:
            r1 = r25
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m6178getUnspecifiedXSAIIZE()
            goto L_0x001c
        L_0x001a:
            r3 = r27
        L_0x001c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r29
        L_0x0024:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r30
        L_0x002c:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r31
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r32
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r33
        L_0x0044:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x004f
            androidx.compose.ui.unit.TextUnit$Companion r11 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r11.m6178getUnspecifiedXSAIIZE()
            goto L_0x0051
        L_0x004f:
            r11 = r34
        L_0x0051:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0057
            r13 = 0
            goto L_0x0059
        L_0x0057:
            r13 = r36
        L_0x0059:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x005f
            r14 = 0
            goto L_0x0061
        L_0x005f:
            r14 = r37
        L_0x0061:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 0
            goto L_0x0069
        L_0x0067:
            r15 = r38
        L_0x0069:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r6.m3200getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r16 = r39
        L_0x0076:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x007c
            r6 = 0
            goto L_0x007e
        L_0x007c:
            r6 = r41
        L_0x007e:
            r18 = r6
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0086
            r6 = 0
            goto L_0x0088
        L_0x0086:
            r6 = r42
        L_0x0088:
            r19 = r6
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0090
            r6 = 0
            goto L_0x0092
        L_0x0090:
            r6 = r43
        L_0x0092:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x009c
            r20 = 0
            goto L_0x009e
        L_0x009c:
            r20 = r44
        L_0x009e:
            r21 = 65536(0x10000, float:9.18355E-41)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00ab
            androidx.compose.ui.unit.TextUnit$Companion r21 = androidx.compose.ui.unit.TextUnit.Companion
            long r21 = r21.m6178getUnspecifiedXSAIIZE()
            goto L_0x00ad
        L_0x00ab:
            r21 = r45
        L_0x00ad:
            r23 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r23
            if (r0 == 0) goto L_0x00b5
            r0 = 0
            goto L_0x00b7
        L_0x00b5:
            r0 = r47
        L_0x00b7:
            r23 = 0
            r49 = r23
            r25 = r24
            r26 = r1
            r28 = r3
            r30 = r5
            r31 = r7
            r32 = r8
            r33 = r9
            r34 = r10
            r35 = r11
            r37 = r13
            r38 = r14
            r39 = r15
            r40 = r16
            r42 = r18
            r43 = r19
            r44 = r6
            r45 = r20
            r46 = r21
            r48 = r0
            r25.<init>(r26, r28, r30, r31, r32, r33, r34, r35, r37, r38, r39, r40, r42, r43, r44, r45, r46, r48, r49)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TextStyle(long r36, long r38, androidx.compose.ui.text.font.FontWeight r40, androidx.compose.ui.text.font.FontStyle r41, androidx.compose.ui.text.font.FontSynthesis r42, androidx.compose.ui.text.font.FontFamily r43, java.lang.String r44, long r45, androidx.compose.ui.text.style.BaselineShift r47, androidx.compose.ui.text.style.TextGeometricTransform r48, androidx.compose.ui.text.intl.LocaleList r49, long r50, androidx.compose.ui.text.style.TextDecoration r52, androidx.compose.ui.graphics.Shadow r53, androidx.compose.ui.text.style.TextAlign r54, androidx.compose.ui.text.style.TextDirection r55, long r56, androidx.compose.ui.text.style.TextIndent r58) {
        /*
            r35 = this;
            r1 = r36
            r3 = r38
            r5 = r40
            r6 = r41
            r7 = r42
            r8 = r43
            r9 = r44
            r10 = r45
            r12 = r47
            r13 = r48
            r14 = r49
            r15 = r50
            r17 = r52
            r18 = r53
            androidx.compose.ui.text.SpanStyle r0 = new androidx.compose.ui.text.SpanStyle
            r22 = r0
            r19 = 0
            r20 = 0
            r21 = 0
            r0.<init>((long) r1, (long) r3, (androidx.compose.ui.text.font.FontWeight) r5, (androidx.compose.ui.text.font.FontStyle) r6, (androidx.compose.ui.text.font.FontSynthesis) r7, (androidx.compose.ui.text.font.FontFamily) r8, (java.lang.String) r9, (long) r10, (androidx.compose.ui.text.style.BaselineShift) r12, (androidx.compose.ui.text.style.TextGeometricTransform) r13, (androidx.compose.ui.text.intl.LocaleList) r14, (long) r15, (androidx.compose.ui.text.style.TextDecoration) r17, (androidx.compose.ui.graphics.Shadow) r18, (androidx.compose.ui.text.PlatformSpanStyle) r19, (androidx.compose.ui.graphics.drawscope.DrawStyle) r20, (kotlin.jvm.internal.DefaultConstructorMarker) r21)
            androidx.compose.ui.text.ParagraphStyle r0 = new androidx.compose.ui.text.ParagraphStyle
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r23 = r0
            r24 = r54
            r25 = r55
            r26 = r56
            r28 = r58
            r23.<init>((androidx.compose.ui.text.style.TextAlign) r24, (androidx.compose.ui.text.style.TextDirection) r25, (long) r26, (androidx.compose.ui.text.style.TextIndent) r28, (androidx.compose.ui.text.PlatformParagraphStyle) r29, (androidx.compose.ui.text.style.LineHeightStyle) r30, (androidx.compose.ui.text.style.LineBreak) r31, (androidx.compose.ui.text.style.Hyphens) r32, (androidx.compose.ui.text.style.TextMotion) r33, (kotlin.jvm.internal.DefaultConstructorMarker) r34)
            r1 = 0
            r2 = r35
            r3 = r22
            r2.<init>(r3, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStyle(long r27, long r29, androidx.compose.ui.text.font.FontWeight r31, androidx.compose.ui.text.font.FontStyle r32, androidx.compose.ui.text.font.FontSynthesis r33, androidx.compose.ui.text.font.FontFamily r34, java.lang.String r35, long r36, androidx.compose.ui.text.style.BaselineShift r38, androidx.compose.ui.text.style.TextGeometricTransform r39, androidx.compose.ui.text.intl.LocaleList r40, long r41, androidx.compose.ui.text.style.TextDecoration r43, androidx.compose.ui.graphics.Shadow r44, androidx.compose.ui.text.style.TextAlign r45, androidx.compose.ui.text.style.TextDirection r46, long r47, androidx.compose.ui.text.style.TextIndent r49, androidx.compose.ui.text.PlatformTextStyle r50, androidx.compose.ui.text.style.LineHeightStyle r51, int r52, kotlin.jvm.internal.DefaultConstructorMarker r53) {
        /*
            r26 = this;
            r0 = r52
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m3200getUnspecified0d7_KjU()
            goto L_0x000f
        L_0x000d:
            r1 = r27
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m6178getUnspecifiedXSAIIZE()
            goto L_0x001c
        L_0x001a:
            r3 = r29
        L_0x001c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r31
        L_0x0024:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r32
        L_0x002c:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r33
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r34
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r35
        L_0x0044:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x004f
            androidx.compose.ui.unit.TextUnit$Companion r11 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r11.m6178getUnspecifiedXSAIIZE()
            goto L_0x0051
        L_0x004f:
            r11 = r36
        L_0x0051:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0057
            r13 = 0
            goto L_0x0059
        L_0x0057:
            r13 = r38
        L_0x0059:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x005f
            r14 = 0
            goto L_0x0061
        L_0x005f:
            r14 = r39
        L_0x0061:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 0
            goto L_0x0069
        L_0x0067:
            r15 = r40
        L_0x0069:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r6.m3200getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r16 = r41
        L_0x0076:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x007c
            r6 = 0
            goto L_0x007e
        L_0x007c:
            r6 = r43
        L_0x007e:
            r18 = r6
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0086
            r6 = 0
            goto L_0x0088
        L_0x0086:
            r6 = r44
        L_0x0088:
            r19 = r6
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0090
            r6 = 0
            goto L_0x0092
        L_0x0090:
            r6 = r45
        L_0x0092:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x009c
            r20 = 0
            goto L_0x009e
        L_0x009c:
            r20 = r46
        L_0x009e:
            r21 = 65536(0x10000, float:9.18355E-41)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00ab
            androidx.compose.ui.unit.TextUnit$Companion r21 = androidx.compose.ui.unit.TextUnit.Companion
            long r21 = r21.m6178getUnspecifiedXSAIIZE()
            goto L_0x00ad
        L_0x00ab:
            r21 = r47
        L_0x00ad:
            r23 = 131072(0x20000, float:1.83671E-40)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00b6
            r23 = 0
            goto L_0x00b8
        L_0x00b6:
            r23 = r49
        L_0x00b8:
            r24 = 262144(0x40000, float:3.67342E-40)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00c1
            r24 = 0
            goto L_0x00c3
        L_0x00c1:
            r24 = r50
        L_0x00c3:
            r25 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r25
            if (r0 == 0) goto L_0x00cb
            r0 = 0
            goto L_0x00cd
        L_0x00cb:
            r0 = r51
        L_0x00cd:
            r25 = 0
            r53 = r25
            r27 = r26
            r28 = r1
            r30 = r3
            r32 = r5
            r33 = r7
            r34 = r8
            r35 = r9
            r36 = r10
            r37 = r11
            r39 = r13
            r40 = r14
            r41 = r15
            r42 = r16
            r44 = r18
            r45 = r19
            r46 = r6
            r47 = r20
            r48 = r21
            r50 = r23
            r51 = r24
            r52 = r0
            r27.<init>(r28, r30, r32, r33, r34, r35, r36, r37, r39, r40, r41, r42, r44, r45, r46, r47, r48, r50, r51, r52, r53)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TextStyle(long r38, long r40, androidx.compose.ui.text.font.FontWeight r42, androidx.compose.ui.text.font.FontStyle r43, androidx.compose.ui.text.font.FontSynthesis r44, androidx.compose.ui.text.font.FontFamily r45, java.lang.String r46, long r47, androidx.compose.ui.text.style.BaselineShift r49, androidx.compose.ui.text.style.TextGeometricTransform r50, androidx.compose.ui.text.intl.LocaleList r51, long r52, androidx.compose.ui.text.style.TextDecoration r54, androidx.compose.ui.graphics.Shadow r55, androidx.compose.ui.text.style.TextAlign r56, androidx.compose.ui.text.style.TextDirection r57, long r58, androidx.compose.ui.text.style.TextIndent r60, androidx.compose.ui.text.PlatformTextStyle r61, androidx.compose.ui.text.style.LineHeightStyle r62) {
        /*
            r37 = this;
            r0 = r61
            androidx.compose.ui.text.SpanStyle r15 = new androidx.compose.ui.text.SpanStyle
            r23 = 0
            if (r0 == 0) goto L_0x001d
            androidx.compose.ui.text.PlatformSpanStyle r1 = r61.getSpanStyle()
            r20 = r1
            goto L_0x001f
        L_0x001d:
            r20 = r23
        L_0x001f:
            r21 = 0
            r22 = 0
            r1 = r15
            r2 = r38
            r4 = r40
            r6 = r42
            r7 = r43
            r8 = r44
            r9 = r45
            r10 = r46
            r11 = r47
            r13 = r49
            r14 = r50
            r24 = r15
            r15 = r51
            r16 = r52
            r18 = r54
            r19 = r55
            r1.<init>((long) r2, (long) r4, (androidx.compose.ui.text.font.FontWeight) r6, (androidx.compose.ui.text.font.FontStyle) r7, (androidx.compose.ui.text.font.FontSynthesis) r8, (androidx.compose.ui.text.font.FontFamily) r9, (java.lang.String) r10, (long) r11, (androidx.compose.ui.text.style.BaselineShift) r13, (androidx.compose.ui.text.style.TextGeometricTransform) r14, (androidx.compose.ui.text.intl.LocaleList) r15, (long) r16, (androidx.compose.ui.text.style.TextDecoration) r18, (androidx.compose.ui.graphics.Shadow) r19, (androidx.compose.ui.text.PlatformSpanStyle) r20, (androidx.compose.ui.graphics.drawscope.DrawStyle) r21, (kotlin.jvm.internal.DefaultConstructorMarker) r22)
            androidx.compose.ui.text.ParagraphStyle r1 = new androidx.compose.ui.text.ParagraphStyle
            if (r0 == 0) goto L_0x0051
            androidx.compose.ui.text.PlatformParagraphStyle r23 = r61.getParagraphStyle()
        L_0x0051:
            r31 = r23
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r25 = r1
            r26 = r56
            r27 = r57
            r28 = r58
            r30 = r60
            r32 = r62
            r25.<init>((androidx.compose.ui.text.style.TextAlign) r26, (androidx.compose.ui.text.style.TextDirection) r27, (long) r28, (androidx.compose.ui.text.style.TextIndent) r30, (androidx.compose.ui.text.PlatformParagraphStyle) r31, (androidx.compose.ui.text.style.LineHeightStyle) r32, (androidx.compose.ui.text.style.LineBreak) r33, (androidx.compose.ui.text.style.Hyphens) r34, (androidx.compose.ui.text.style.TextMotion) r35, (kotlin.jvm.internal.DefaultConstructorMarker) r36)
            r2 = r37
            r3 = r24
            r2.<init>(r3, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStyle(long r29, long r31, androidx.compose.ui.text.font.FontWeight r33, androidx.compose.ui.text.font.FontStyle r34, androidx.compose.ui.text.font.FontSynthesis r35, androidx.compose.ui.text.font.FontFamily r36, java.lang.String r37, long r38, androidx.compose.ui.text.style.BaselineShift r40, androidx.compose.ui.text.style.TextGeometricTransform r41, androidx.compose.ui.text.intl.LocaleList r42, long r43, androidx.compose.ui.text.style.TextDecoration r45, androidx.compose.ui.graphics.Shadow r46, androidx.compose.ui.text.style.TextAlign r47, androidx.compose.ui.text.style.TextDirection r48, long r49, androidx.compose.ui.text.style.TextIndent r51, androidx.compose.ui.text.PlatformTextStyle r52, androidx.compose.ui.text.style.LineHeightStyle r53, androidx.compose.ui.text.style.LineBreak r54, androidx.compose.ui.text.style.Hyphens r55, int r56, kotlin.jvm.internal.DefaultConstructorMarker r57) {
        /*
            r28 = this;
            r0 = r56
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m3200getUnspecified0d7_KjU()
            goto L_0x000f
        L_0x000d:
            r1 = r29
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m6178getUnspecifiedXSAIIZE()
            goto L_0x001c
        L_0x001a:
            r3 = r31
        L_0x001c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r33
        L_0x0024:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r34
        L_0x002c:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r35
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r36
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r37
        L_0x0044:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x004f
            androidx.compose.ui.unit.TextUnit$Companion r11 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r11.m6178getUnspecifiedXSAIIZE()
            goto L_0x0051
        L_0x004f:
            r11 = r38
        L_0x0051:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0057
            r13 = 0
            goto L_0x0059
        L_0x0057:
            r13 = r40
        L_0x0059:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x005f
            r14 = 0
            goto L_0x0061
        L_0x005f:
            r14 = r41
        L_0x0061:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 0
            goto L_0x0069
        L_0x0067:
            r15 = r42
        L_0x0069:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r6.m3200getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r16 = r43
        L_0x0076:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x007c
            r6 = 0
            goto L_0x007e
        L_0x007c:
            r6 = r45
        L_0x007e:
            r18 = r6
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0086
            r6 = 0
            goto L_0x0088
        L_0x0086:
            r6 = r46
        L_0x0088:
            r19 = r6
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0090
            r6 = 0
            goto L_0x0092
        L_0x0090:
            r6 = r47
        L_0x0092:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x009c
            r20 = 0
            goto L_0x009e
        L_0x009c:
            r20 = r48
        L_0x009e:
            r21 = 65536(0x10000, float:9.18355E-41)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00ab
            androidx.compose.ui.unit.TextUnit$Companion r21 = androidx.compose.ui.unit.TextUnit.Companion
            long r21 = r21.m6178getUnspecifiedXSAIIZE()
            goto L_0x00ad
        L_0x00ab:
            r21 = r49
        L_0x00ad:
            r23 = 131072(0x20000, float:1.83671E-40)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00b6
            r23 = 0
            goto L_0x00b8
        L_0x00b6:
            r23 = r51
        L_0x00b8:
            r24 = 262144(0x40000, float:3.67342E-40)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00c1
            r24 = 0
            goto L_0x00c3
        L_0x00c1:
            r24 = r52
        L_0x00c3:
            r25 = 524288(0x80000, float:7.34684E-40)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00cc
            r25 = 0
            goto L_0x00ce
        L_0x00cc:
            r25 = r53
        L_0x00ce:
            r26 = 1048576(0x100000, float:1.469368E-39)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00d7
            r26 = 0
            goto L_0x00d9
        L_0x00d7:
            r26 = r54
        L_0x00d9:
            r27 = 2097152(0x200000, float:2.938736E-39)
            r0 = r0 & r27
            if (r0 == 0) goto L_0x00e1
            r0 = 0
            goto L_0x00e3
        L_0x00e1:
            r0 = r55
        L_0x00e3:
            r27 = 0
            r57 = r27
            r29 = r28
            r30 = r1
            r32 = r3
            r34 = r5
            r35 = r7
            r36 = r8
            r37 = r9
            r38 = r10
            r39 = r11
            r41 = r13
            r42 = r14
            r43 = r15
            r44 = r16
            r46 = r18
            r47 = r19
            r48 = r6
            r49 = r20
            r50 = r21
            r52 = r23
            r53 = r24
            r54 = r25
            r55 = r26
            r56 = r0
            r29.<init>(r30, r32, r34, r35, r36, r37, r38, r39, r41, r42, r43, r44, r46, r47, r48, r49, r50, r52, r53, r54, r55, r56, r57)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TextStyle(long r36, long r38, androidx.compose.ui.text.font.FontWeight r40, androidx.compose.ui.text.font.FontStyle r41, androidx.compose.ui.text.font.FontSynthesis r42, androidx.compose.ui.text.font.FontFamily r43, java.lang.String r44, long r45, androidx.compose.ui.text.style.BaselineShift r47, androidx.compose.ui.text.style.TextGeometricTransform r48, androidx.compose.ui.text.intl.LocaleList r49, long r50, androidx.compose.ui.text.style.TextDecoration r52, androidx.compose.ui.graphics.Shadow r53, androidx.compose.ui.text.style.TextAlign r54, androidx.compose.ui.text.style.TextDirection r55, long r56, androidx.compose.ui.text.style.TextIndent r58, androidx.compose.ui.text.PlatformTextStyle r59, androidx.compose.ui.text.style.LineHeightStyle r60, androidx.compose.ui.text.style.LineBreak r61, androidx.compose.ui.text.style.Hyphens r62) {
        /*
            r35 = this;
            r0 = r59
            androidx.compose.ui.text.SpanStyle r15 = new androidx.compose.ui.text.SpanStyle
            r22 = 0
            if (r0 == 0) goto L_0x001d
            androidx.compose.ui.text.PlatformSpanStyle r1 = r59.getSpanStyle()
            r20 = r1
            goto L_0x001f
        L_0x001d:
            r20 = r22
        L_0x001f:
            r21 = 0
            r1 = r15
            r2 = r36
            r4 = r38
            r6 = r40
            r7 = r41
            r8 = r42
            r9 = r43
            r10 = r44
            r11 = r45
            r13 = r47
            r14 = r48
            r23 = r15
            r15 = r49
            r16 = r50
            r18 = r52
            r19 = r53
            r1.<init>((long) r2, (long) r4, (androidx.compose.ui.text.font.FontWeight) r6, (androidx.compose.ui.text.font.FontStyle) r7, (androidx.compose.ui.text.font.FontSynthesis) r8, (androidx.compose.ui.text.font.FontFamily) r9, (java.lang.String) r10, (long) r11, (androidx.compose.ui.text.style.BaselineShift) r13, (androidx.compose.ui.text.style.TextGeometricTransform) r14, (androidx.compose.ui.text.intl.LocaleList) r15, (long) r16, (androidx.compose.ui.text.style.TextDecoration) r18, (androidx.compose.ui.graphics.Shadow) r19, (androidx.compose.ui.text.PlatformSpanStyle) r20, (kotlin.jvm.internal.DefaultConstructorMarker) r21)
            androidx.compose.ui.text.ParagraphStyle r1 = new androidx.compose.ui.text.ParagraphStyle
            if (r0 == 0) goto L_0x004f
            androidx.compose.ui.text.PlatformParagraphStyle r22 = r59.getParagraphStyle()
        L_0x004f:
            r30 = r22
            r34 = 0
            r24 = r1
            r25 = r54
            r26 = r55
            r27 = r56
            r29 = r58
            r31 = r60
            r32 = r61
            r33 = r62
            r24.<init>((androidx.compose.ui.text.style.TextAlign) r25, (androidx.compose.ui.text.style.TextDirection) r26, (long) r27, (androidx.compose.ui.text.style.TextIndent) r29, (androidx.compose.ui.text.PlatformParagraphStyle) r30, (androidx.compose.ui.text.style.LineHeightStyle) r31, (androidx.compose.ui.text.style.LineBreak) r32, (androidx.compose.ui.text.style.Hyphens) r33, (kotlin.jvm.internal.DefaultConstructorMarker) r34)
            r2 = r35
            r3 = r23
            r2.<init>(r3, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStyle(long r31, long r33, androidx.compose.ui.text.font.FontWeight r35, androidx.compose.ui.text.font.FontStyle r36, androidx.compose.ui.text.font.FontSynthesis r37, androidx.compose.ui.text.font.FontFamily r38, java.lang.String r39, long r40, androidx.compose.ui.text.style.BaselineShift r42, androidx.compose.ui.text.style.TextGeometricTransform r43, androidx.compose.ui.text.intl.LocaleList r44, long r45, androidx.compose.ui.text.style.TextDecoration r47, androidx.compose.ui.graphics.Shadow r48, androidx.compose.ui.graphics.drawscope.DrawStyle r49, androidx.compose.ui.text.style.TextAlign r50, androidx.compose.ui.text.style.TextDirection r51, long r52, androidx.compose.ui.text.style.TextIndent r54, androidx.compose.ui.text.PlatformTextStyle r55, androidx.compose.ui.text.style.LineHeightStyle r56, androidx.compose.ui.text.style.LineBreak r57, androidx.compose.ui.text.style.Hyphens r58, androidx.compose.ui.text.style.TextMotion r59, int r60, kotlin.jvm.internal.DefaultConstructorMarker r61) {
        /*
            r30 = this;
            r0 = r60
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m3200getUnspecified0d7_KjU()
            goto L_0x000f
        L_0x000d:
            r1 = r31
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m6178getUnspecifiedXSAIIZE()
            goto L_0x001c
        L_0x001a:
            r3 = r33
        L_0x001c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r35
        L_0x0024:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r36
        L_0x002c:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r37
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r38
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r39
        L_0x0044:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x004f
            androidx.compose.ui.unit.TextUnit$Companion r11 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r11.m6178getUnspecifiedXSAIIZE()
            goto L_0x0051
        L_0x004f:
            r11 = r40
        L_0x0051:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0057
            r13 = 0
            goto L_0x0059
        L_0x0057:
            r13 = r42
        L_0x0059:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x005f
            r14 = 0
            goto L_0x0061
        L_0x005f:
            r14 = r43
        L_0x0061:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 0
            goto L_0x0069
        L_0x0067:
            r15 = r44
        L_0x0069:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r6.m3200getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r16 = r45
        L_0x0076:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x007c
            r6 = 0
            goto L_0x007e
        L_0x007c:
            r6 = r47
        L_0x007e:
            r18 = r6
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0086
            r6 = 0
            goto L_0x0088
        L_0x0086:
            r6 = r48
        L_0x0088:
            r19 = r6
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0090
            r6 = 0
            goto L_0x0092
        L_0x0090:
            r6 = r49
        L_0x0092:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x009c
            r20 = 0
            goto L_0x009e
        L_0x009c:
            r20 = r50
        L_0x009e:
            r21 = 65536(0x10000, float:9.18355E-41)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00a7
            r21 = 0
            goto L_0x00a9
        L_0x00a7:
            r21 = r51
        L_0x00a9:
            r22 = 131072(0x20000, float:1.83671E-40)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00b6
            androidx.compose.ui.unit.TextUnit$Companion r22 = androidx.compose.ui.unit.TextUnit.Companion
            long r22 = r22.m6178getUnspecifiedXSAIIZE()
            goto L_0x00b8
        L_0x00b6:
            r22 = r52
        L_0x00b8:
            r24 = 262144(0x40000, float:3.67342E-40)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00c1
            r24 = 0
            goto L_0x00c3
        L_0x00c1:
            r24 = r54
        L_0x00c3:
            r25 = 524288(0x80000, float:7.34684E-40)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00cc
            r25 = 0
            goto L_0x00ce
        L_0x00cc:
            r25 = r55
        L_0x00ce:
            r26 = 1048576(0x100000, float:1.469368E-39)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00d7
            r26 = 0
            goto L_0x00d9
        L_0x00d7:
            r26 = r56
        L_0x00d9:
            r27 = 2097152(0x200000, float:2.938736E-39)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00e2
            r27 = 0
            goto L_0x00e4
        L_0x00e2:
            r27 = r57
        L_0x00e4:
            r28 = 4194304(0x400000, float:5.877472E-39)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x00ed
            r28 = 0
            goto L_0x00ef
        L_0x00ed:
            r28 = r58
        L_0x00ef:
            r29 = 8388608(0x800000, float:1.17549435E-38)
            r0 = r0 & r29
            if (r0 == 0) goto L_0x00f7
            r0 = 0
            goto L_0x00f9
        L_0x00f7:
            r0 = r59
        L_0x00f9:
            r29 = 0
            r61 = r29
            r31 = r30
            r32 = r1
            r34 = r3
            r36 = r5
            r37 = r7
            r38 = r8
            r39 = r9
            r40 = r10
            r41 = r11
            r43 = r13
            r44 = r14
            r45 = r15
            r46 = r16
            r48 = r18
            r49 = r19
            r50 = r6
            r51 = r20
            r52 = r21
            r53 = r22
            r55 = r24
            r56 = r25
            r57 = r26
            r58 = r27
            r59 = r28
            r60 = r0
            r31.<init>((long) r32, (long) r34, (androidx.compose.ui.text.font.FontWeight) r36, (androidx.compose.ui.text.font.FontStyle) r37, (androidx.compose.ui.text.font.FontSynthesis) r38, (androidx.compose.ui.text.font.FontFamily) r39, (java.lang.String) r40, (long) r41, (androidx.compose.ui.text.style.BaselineShift) r43, (androidx.compose.ui.text.style.TextGeometricTransform) r44, (androidx.compose.ui.text.intl.LocaleList) r45, (long) r46, (androidx.compose.ui.text.style.TextDecoration) r48, (androidx.compose.ui.graphics.Shadow) r49, (androidx.compose.ui.graphics.drawscope.DrawStyle) r50, (androidx.compose.ui.text.style.TextAlign) r51, (androidx.compose.ui.text.style.TextDirection) r52, (long) r53, (androidx.compose.ui.text.style.TextIndent) r55, (androidx.compose.ui.text.PlatformTextStyle) r56, (androidx.compose.ui.text.style.LineHeightStyle) r57, (androidx.compose.ui.text.style.LineBreak) r58, (androidx.compose.ui.text.style.Hyphens) r59, (androidx.compose.ui.text.style.TextMotion) r60, (kotlin.jvm.internal.DefaultConstructorMarker) r61)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.graphics.drawscope.DrawStyle, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens, androidx.compose.ui.text.style.TextMotion, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TextStyle(long r38, long r40, androidx.compose.ui.text.font.FontWeight r42, androidx.compose.ui.text.font.FontStyle r43, androidx.compose.ui.text.font.FontSynthesis r44, androidx.compose.ui.text.font.FontFamily r45, java.lang.String r46, long r47, androidx.compose.ui.text.style.BaselineShift r49, androidx.compose.ui.text.style.TextGeometricTransform r50, androidx.compose.ui.text.intl.LocaleList r51, long r52, androidx.compose.ui.text.style.TextDecoration r54, androidx.compose.ui.graphics.Shadow r55, androidx.compose.ui.graphics.drawscope.DrawStyle r56, androidx.compose.ui.text.style.TextAlign r57, androidx.compose.ui.text.style.TextDirection r58, long r59, androidx.compose.ui.text.style.TextIndent r61, androidx.compose.ui.text.PlatformTextStyle r62, androidx.compose.ui.text.style.LineHeightStyle r63, androidx.compose.ui.text.style.LineBreak r64, androidx.compose.ui.text.style.Hyphens r65, androidx.compose.ui.text.style.TextMotion r66) {
        /*
            r37 = this;
            r0 = r62
            androidx.compose.ui.text.SpanStyle r15 = new androidx.compose.ui.text.SpanStyle
            r23 = 0
            if (r0 == 0) goto L_0x001d
            androidx.compose.ui.text.PlatformSpanStyle r1 = r62.getSpanStyle()
            r20 = r1
            goto L_0x001f
        L_0x001d:
            r20 = r23
        L_0x001f:
            r22 = 0
            r1 = r15
            r2 = r38
            r4 = r40
            r6 = r42
            r7 = r43
            r8 = r44
            r9 = r45
            r10 = r46
            r11 = r47
            r13 = r49
            r14 = r50
            r24 = r15
            r15 = r51
            r16 = r52
            r18 = r54
            r19 = r55
            r21 = r56
            r1.<init>((long) r2, (long) r4, (androidx.compose.ui.text.font.FontWeight) r6, (androidx.compose.ui.text.font.FontStyle) r7, (androidx.compose.ui.text.font.FontSynthesis) r8, (androidx.compose.ui.text.font.FontFamily) r9, (java.lang.String) r10, (long) r11, (androidx.compose.ui.text.style.BaselineShift) r13, (androidx.compose.ui.text.style.TextGeometricTransform) r14, (androidx.compose.ui.text.intl.LocaleList) r15, (long) r16, (androidx.compose.ui.text.style.TextDecoration) r18, (androidx.compose.ui.graphics.Shadow) r19, (androidx.compose.ui.text.PlatformSpanStyle) r20, (androidx.compose.ui.graphics.drawscope.DrawStyle) r21, (kotlin.jvm.internal.DefaultConstructorMarker) r22)
            androidx.compose.ui.text.ParagraphStyle r1 = new androidx.compose.ui.text.ParagraphStyle
            if (r0 == 0) goto L_0x0051
            androidx.compose.ui.text.PlatformParagraphStyle r23 = r62.getParagraphStyle()
        L_0x0051:
            r31 = r23
            r36 = 0
            r25 = r1
            r26 = r57
            r27 = r58
            r28 = r59
            r30 = r61
            r32 = r63
            r33 = r64
            r34 = r65
            r35 = r66
            r25.<init>((androidx.compose.ui.text.style.TextAlign) r26, (androidx.compose.ui.text.style.TextDirection) r27, (long) r28, (androidx.compose.ui.text.style.TextIndent) r30, (androidx.compose.ui.text.PlatformParagraphStyle) r31, (androidx.compose.ui.text.style.LineHeightStyle) r32, (androidx.compose.ui.text.style.LineBreak) r33, (androidx.compose.ui.text.style.Hyphens) r34, (androidx.compose.ui.text.style.TextMotion) r35, (kotlin.jvm.internal.DefaultConstructorMarker) r36)
            r2 = r37
            r3 = r24
            r2.<init>(r3, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.graphics.drawscope.DrawStyle, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens, androidx.compose.ui.text.style.TextMotion):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStyle(androidx.compose.ui.graphics.Brush r34, float r35, long r36, androidx.compose.ui.text.font.FontWeight r38, androidx.compose.ui.text.font.FontStyle r39, androidx.compose.ui.text.font.FontSynthesis r40, androidx.compose.ui.text.font.FontFamily r41, java.lang.String r42, long r43, androidx.compose.ui.text.style.BaselineShift r45, androidx.compose.ui.text.style.TextGeometricTransform r46, androidx.compose.ui.text.intl.LocaleList r47, long r48, androidx.compose.ui.text.style.TextDecoration r50, androidx.compose.ui.graphics.Shadow r51, androidx.compose.ui.graphics.drawscope.DrawStyle r52, androidx.compose.ui.text.style.TextAlign r53, androidx.compose.ui.text.style.TextDirection r54, long r55, androidx.compose.ui.text.style.TextIndent r57, androidx.compose.ui.text.PlatformTextStyle r58, androidx.compose.ui.text.style.LineHeightStyle r59, androidx.compose.ui.text.style.LineBreak r60, androidx.compose.ui.text.style.Hyphens r61, androidx.compose.ui.text.style.TextMotion r62, int r63, kotlin.jvm.internal.DefaultConstructorMarker r64) {
        /*
            r33 = this;
            r0 = r63
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000a
            r1 = 2143289344(0x7fc00000, float:NaN)
            r4 = r1
            goto L_0x000c
        L_0x000a:
            r4 = r35
        L_0x000c:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0018
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r1 = r1.m6178getUnspecifiedXSAIIZE()
            r5 = r1
            goto L_0x001a
        L_0x0018:
            r5 = r36
        L_0x001a:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0021
            r7 = r2
            goto L_0x0023
        L_0x0021:
            r7 = r38
        L_0x0023:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0029
            r8 = r2
            goto L_0x002b
        L_0x0029:
            r8 = r39
        L_0x002b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0031
            r9 = r2
            goto L_0x0033
        L_0x0031:
            r9 = r40
        L_0x0033:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0039
            r10 = r2
            goto L_0x003b
        L_0x0039:
            r10 = r41
        L_0x003b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0041
            r11 = r2
            goto L_0x0043
        L_0x0041:
            r11 = r42
        L_0x0043:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x004e
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r12 = r1.m6178getUnspecifiedXSAIIZE()
            goto L_0x0050
        L_0x004e:
            r12 = r43
        L_0x0050:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0056
            r14 = r2
            goto L_0x0058
        L_0x0056:
            r14 = r45
        L_0x0058:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x005e
            r15 = r2
            goto L_0x0060
        L_0x005e:
            r15 = r46
        L_0x0060:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0067
            r16 = r2
            goto L_0x0069
        L_0x0067:
            r16 = r47
        L_0x0069:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r17 = r1.m3200getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r17 = r48
        L_0x0076:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x007d
            r19 = r2
            goto L_0x007f
        L_0x007d:
            r19 = r50
        L_0x007f:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0086
            r20 = r2
            goto L_0x0088
        L_0x0086:
            r20 = r51
        L_0x0088:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0091
            r21 = r2
            goto L_0x0093
        L_0x0091:
            r21 = r52
        L_0x0093:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x009b
            r22 = r2
            goto L_0x009d
        L_0x009b:
            r22 = r53
        L_0x009d:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a5
            r23 = r2
            goto L_0x00a7
        L_0x00a5:
            r23 = r54
        L_0x00a7:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b3
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r24 = r1.m6178getUnspecifiedXSAIIZE()
            goto L_0x00b5
        L_0x00b3:
            r24 = r55
        L_0x00b5:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00bd
            r26 = r2
            goto L_0x00bf
        L_0x00bd:
            r26 = r57
        L_0x00bf:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00c7
            r27 = r2
            goto L_0x00c9
        L_0x00c7:
            r27 = r58
        L_0x00c9:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00d1
            r28 = r2
            goto L_0x00d3
        L_0x00d1:
            r28 = r59
        L_0x00d3:
            r1 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00db
            r29 = r2
            goto L_0x00dd
        L_0x00db:
            r29 = r60
        L_0x00dd:
            r1 = 8388608(0x800000, float:1.17549435E-38)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00e5
            r30 = r2
            goto L_0x00e7
        L_0x00e5:
            r30 = r61
        L_0x00e7:
            r1 = 16777216(0x1000000, float:2.3509887E-38)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00ef
            r31 = r2
            goto L_0x00f1
        L_0x00ef:
            r31 = r62
        L_0x00f1:
            r32 = 0
            r2 = r33
            r3 = r34
            r2.<init>((androidx.compose.ui.graphics.Brush) r3, (float) r4, (long) r5, (androidx.compose.ui.text.font.FontWeight) r7, (androidx.compose.ui.text.font.FontStyle) r8, (androidx.compose.ui.text.font.FontSynthesis) r9, (androidx.compose.ui.text.font.FontFamily) r10, (java.lang.String) r11, (long) r12, (androidx.compose.ui.text.style.BaselineShift) r14, (androidx.compose.ui.text.style.TextGeometricTransform) r15, (androidx.compose.ui.text.intl.LocaleList) r16, (long) r17, (androidx.compose.ui.text.style.TextDecoration) r19, (androidx.compose.ui.graphics.Shadow) r20, (androidx.compose.ui.graphics.drawscope.DrawStyle) r21, (androidx.compose.ui.text.style.TextAlign) r22, (androidx.compose.ui.text.style.TextDirection) r23, (long) r24, (androidx.compose.ui.text.style.TextIndent) r26, (androidx.compose.ui.text.PlatformTextStyle) r27, (androidx.compose.ui.text.style.LineHeightStyle) r28, (androidx.compose.ui.text.style.LineBreak) r29, (androidx.compose.ui.text.style.Hyphens) r30, (androidx.compose.ui.text.style.TextMotion) r31, (kotlin.jvm.internal.DefaultConstructorMarker) r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(androidx.compose.ui.graphics.Brush, float, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.graphics.drawscope.DrawStyle, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens, androidx.compose.ui.text.style.TextMotion, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TextStyle(androidx.compose.ui.graphics.Brush r38, float r39, long r40, androidx.compose.ui.text.font.FontWeight r42, androidx.compose.ui.text.font.FontStyle r43, androidx.compose.ui.text.font.FontSynthesis r44, androidx.compose.ui.text.font.FontFamily r45, java.lang.String r46, long r47, androidx.compose.ui.text.style.BaselineShift r49, androidx.compose.ui.text.style.TextGeometricTransform r50, androidx.compose.ui.text.intl.LocaleList r51, long r52, androidx.compose.ui.text.style.TextDecoration r54, androidx.compose.ui.graphics.Shadow r55, androidx.compose.ui.graphics.drawscope.DrawStyle r56, androidx.compose.ui.text.style.TextAlign r57, androidx.compose.ui.text.style.TextDirection r58, long r59, androidx.compose.ui.text.style.TextIndent r61, androidx.compose.ui.text.PlatformTextStyle r62, androidx.compose.ui.text.style.LineHeightStyle r63, androidx.compose.ui.text.style.LineBreak r64, androidx.compose.ui.text.style.Hyphens r65, androidx.compose.ui.text.style.TextMotion r66) {
        /*
            r37 = this;
            r0 = r62
            androidx.compose.ui.text.SpanStyle r15 = new androidx.compose.ui.text.SpanStyle
            r23 = 0
            if (r0 == 0) goto L_0x001e
            androidx.compose.ui.text.PlatformSpanStyle r1 = r62.getSpanStyle()
            r20 = r1
            goto L_0x0020
        L_0x001e:
            r20 = r23
        L_0x0020:
            r22 = 0
            r1 = r15
            r2 = r38
            r3 = r39
            r4 = r40
            r6 = r42
            r7 = r43
            r8 = r44
            r9 = r45
            r10 = r46
            r11 = r47
            r13 = r49
            r14 = r50
            r24 = r15
            r15 = r51
            r16 = r52
            r18 = r54
            r19 = r55
            r21 = r56
            r1.<init>((androidx.compose.ui.graphics.Brush) r2, (float) r3, (long) r4, (androidx.compose.ui.text.font.FontWeight) r6, (androidx.compose.ui.text.font.FontStyle) r7, (androidx.compose.ui.text.font.FontSynthesis) r8, (androidx.compose.ui.text.font.FontFamily) r9, (java.lang.String) r10, (long) r11, (androidx.compose.ui.text.style.BaselineShift) r13, (androidx.compose.ui.text.style.TextGeometricTransform) r14, (androidx.compose.ui.text.intl.LocaleList) r15, (long) r16, (androidx.compose.ui.text.style.TextDecoration) r18, (androidx.compose.ui.graphics.Shadow) r19, (androidx.compose.ui.text.PlatformSpanStyle) r20, (androidx.compose.ui.graphics.drawscope.DrawStyle) r21, (kotlin.jvm.internal.DefaultConstructorMarker) r22)
            androidx.compose.ui.text.ParagraphStyle r1 = new androidx.compose.ui.text.ParagraphStyle
            if (r0 == 0) goto L_0x0054
            androidx.compose.ui.text.PlatformParagraphStyle r23 = r62.getParagraphStyle()
        L_0x0054:
            r31 = r23
            r36 = 0
            r25 = r1
            r26 = r57
            r27 = r58
            r28 = r59
            r30 = r61
            r32 = r63
            r33 = r64
            r34 = r65
            r35 = r66
            r25.<init>((androidx.compose.ui.text.style.TextAlign) r26, (androidx.compose.ui.text.style.TextDirection) r27, (long) r28, (androidx.compose.ui.text.style.TextIndent) r30, (androidx.compose.ui.text.PlatformParagraphStyle) r31, (androidx.compose.ui.text.style.LineHeightStyle) r32, (androidx.compose.ui.text.style.LineBreak) r33, (androidx.compose.ui.text.style.Hyphens) r34, (androidx.compose.ui.text.style.TextMotion) r35, (kotlin.jvm.internal.DefaultConstructorMarker) r36)
            r2 = r37
            r3 = r24
            r2.<init>(r3, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(androidx.compose.ui.graphics.Brush, float, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.graphics.drawscope.DrawStyle, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens, androidx.compose.ui.text.style.TextMotion):void");
    }

    public final SpanStyle toSpanStyle() {
        return this.spanStyle;
    }

    public final ParagraphStyle toParagraphStyle() {
        return this.paragraphStyle;
    }

    public static /* synthetic */ TextStyle merge$default(TextStyle textStyle, TextStyle textStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            textStyle2 = null;
        }
        return textStyle.merge(textStyle2);
    }

    public final TextStyle merge(TextStyle other) {
        if (other == null || Intrinsics.areEqual((Object) other, (Object) Default)) {
            return this;
        }
        return new TextStyle(toSpanStyle().merge(other.toSpanStyle()), toParagraphStyle().merge(other.toParagraphStyle()));
    }

    public final TextStyle merge(SpanStyle other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return new TextStyle(toSpanStyle().merge(other), toParagraphStyle());
    }

    public final TextStyle merge(ParagraphStyle other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return new TextStyle(toSpanStyle(), toParagraphStyle().merge(other));
    }

    public final TextStyle plus(TextStyle other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return merge(other);
    }

    public final TextStyle plus(ParagraphStyle other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return merge(other);
    }

    public final TextStyle plus(SpanStyle other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return merge(other);
    }

    /* renamed from: copy-HL5avdY$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m5483copyHL5avdY$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, int i, Object obj) {
        long j6;
        long j7;
        FontWeight fontWeight2;
        FontStyle fontStyle2;
        TextAlign textAlign2;
        TextDirection textDirection2;
        TextDirection textDirection3;
        long j8;
        TextStyle textStyle2 = textStyle;
        int i2 = i;
        if ((i2 & 1) != 0) {
            j6 = textStyle2.spanStyle.m5434getColor0d7_KjU();
        } else {
            j6 = j;
        }
        if ((i2 & 2) != 0) {
            j7 = textStyle2.spanStyle.m5435getFontSizeXSAIIZE();
        } else {
            j7 = j2;
        }
        if ((i2 & 4) != 0) {
            fontWeight2 = textStyle2.spanStyle.getFontWeight();
        } else {
            fontWeight2 = fontWeight;
        }
        if ((i2 & 8) != 0) {
            fontStyle2 = textStyle2.spanStyle.m5436getFontStyle4Lr2A7w();
        } else {
            fontStyle2 = fontStyle;
        }
        FontSynthesis r8 = (i2 & 16) != 0 ? textStyle2.spanStyle.m5437getFontSynthesisZQGJjVo() : fontSynthesis;
        FontFamily fontFamily2 = (i2 & 32) != 0 ? textStyle2.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i2 & 64) != 0 ? textStyle2.spanStyle.getFontFeatureSettings() : str;
        long r11 = (i2 & 128) != 0 ? textStyle2.spanStyle.m5438getLetterSpacingXSAIIZE() : j3;
        BaselineShift r13 = (i2 & 256) != 0 ? textStyle2.spanStyle.m5433getBaselineShift5SSeXJ0() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i2 & 512) != 0 ? textStyle2.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i2 & 1024) != 0 ? textStyle2.spanStyle.getLocaleList() : localeList;
        long r33 = (i2 & 2048) != 0 ? textStyle2.spanStyle.m5432getBackground0d7_KjU() : j4;
        TextDecoration textDecoration2 = (i2 & 4096) != 0 ? textStyle2.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow2 = (i2 & 8192) != 0 ? textStyle2.spanStyle.getShadow() : shadow;
        TextAlign r15 = (i2 & 16384) != 0 ? textStyle2.paragraphStyle.m5391getTextAlignbuA522U() : textAlign;
        if ((i2 & 32768) != 0) {
            textAlign2 = r15;
            textDirection2 = textStyle2.paragraphStyle.m5393getTextDirectionmmuk1to();
        } else {
            textAlign2 = r15;
            textDirection2 = textDirection;
        }
        if ((i2 & 65536) != 0) {
            textDirection3 = textDirection2;
            j8 = textStyle2.paragraphStyle.m5390getLineHeightXSAIIZE();
        } else {
            textDirection3 = textDirection2;
            j8 = j5;
        }
        return textStyle.m5488copyHL5avdY(j6, j7, fontWeight2, fontStyle2, r8, fontFamily2, fontFeatureSettings, r11, r13, textGeometricTransform2, localeList2, r33, textDecoration2, shadow2, textAlign2, textDirection3, j8, (i2 & 131072) != 0 ? textStyle2.paragraphStyle.getTextIndent() : textIndent);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    /* renamed from: copy-HL5avdY  reason: not valid java name */
    public final /* synthetic */ TextStyle m5488copyHL5avdY(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent) {
        TextForegroundStyle textForegroundStyle;
        long j = color;
        if (Color.m3165equalsimpl0(j, this.spanStyle.m5434getColor0d7_KjU())) {
            textForegroundStyle = this.spanStyle.getTextForegroundStyle$ui_text_release();
        } else {
            textForegroundStyle = TextForegroundStyle.Companion.m5869from8_81llA(j);
        }
        SpanStyle spanStyle2 = r4;
        SpanStyle spanStyle3 = new SpanStyle(textForegroundStyle, fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, this.spanStyle.getPlatformStyle(), this.spanStyle.getDrawStyle(), (DefaultConstructorMarker) null);
        return new TextStyle(spanStyle2, new ParagraphStyle(textAlign, textDirection, lineHeight, textIndent, this.paragraphStyle.getPlatformStyle(), getLineHeightStyle(), m5500getLineBreakLgCVezo(), m5498getHyphensEaSxIns(), getTextMotion(), (DefaultConstructorMarker) null), this.platformStyle);
    }

    /* renamed from: copy-NOaFTUo$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m5484copyNOaFTUo$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i, Object obj) {
        long j6;
        long j7;
        FontWeight fontWeight2;
        FontStyle fontStyle2;
        TextAlign textAlign2;
        TextDirection textDirection2;
        TextDirection textDirection3;
        long j8;
        long j9;
        TextIndent textIndent2;
        TextIndent textIndent3;
        PlatformTextStyle platformTextStyle2;
        TextStyle textStyle2 = textStyle;
        int i2 = i;
        if ((i2 & 1) != 0) {
            j6 = textStyle2.spanStyle.m5434getColor0d7_KjU();
        } else {
            j6 = j;
        }
        if ((i2 & 2) != 0) {
            j7 = textStyle2.spanStyle.m5435getFontSizeXSAIIZE();
        } else {
            j7 = j2;
        }
        if ((i2 & 4) != 0) {
            fontWeight2 = textStyle2.spanStyle.getFontWeight();
        } else {
            fontWeight2 = fontWeight;
        }
        if ((i2 & 8) != 0) {
            fontStyle2 = textStyle2.spanStyle.m5436getFontStyle4Lr2A7w();
        } else {
            fontStyle2 = fontStyle;
        }
        FontSynthesis r8 = (i2 & 16) != 0 ? textStyle2.spanStyle.m5437getFontSynthesisZQGJjVo() : fontSynthesis;
        FontFamily fontFamily2 = (i2 & 32) != 0 ? textStyle2.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i2 & 64) != 0 ? textStyle2.spanStyle.getFontFeatureSettings() : str;
        long r11 = (i2 & 128) != 0 ? textStyle2.spanStyle.m5438getLetterSpacingXSAIIZE() : j3;
        BaselineShift r13 = (i2 & 256) != 0 ? textStyle2.spanStyle.m5433getBaselineShift5SSeXJ0() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i2 & 512) != 0 ? textStyle2.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i2 & 1024) != 0 ? textStyle2.spanStyle.getLocaleList() : localeList;
        long r33 = (i2 & 2048) != 0 ? textStyle2.spanStyle.m5432getBackground0d7_KjU() : j4;
        TextDecoration textDecoration2 = (i2 & 4096) != 0 ? textStyle2.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow2 = (i2 & 8192) != 0 ? textStyle2.spanStyle.getShadow() : shadow;
        TextAlign r15 = (i2 & 16384) != 0 ? textStyle2.paragraphStyle.m5391getTextAlignbuA522U() : textAlign;
        if ((i2 & 32768) != 0) {
            textAlign2 = r15;
            textDirection2 = textStyle2.paragraphStyle.m5393getTextDirectionmmuk1to();
        } else {
            textAlign2 = r15;
            textDirection2 = textDirection;
        }
        if ((i2 & 65536) != 0) {
            textDirection3 = textDirection2;
            j8 = textStyle2.paragraphStyle.m5390getLineHeightXSAIIZE();
        } else {
            textDirection3 = textDirection2;
            j8 = j5;
        }
        if ((i2 & 131072) != 0) {
            j9 = j8;
            textIndent2 = textStyle2.paragraphStyle.getTextIndent();
        } else {
            j9 = j8;
            textIndent2 = textIndent;
        }
        if ((i2 & 262144) != 0) {
            textIndent3 = textIndent2;
            platformTextStyle2 = textStyle2.platformStyle;
        } else {
            textIndent3 = textIndent2;
            platformTextStyle2 = platformTextStyle;
        }
        return textStyle.m5489copyNOaFTUo(j6, j7, fontWeight2, fontStyle2, r8, fontFamily2, fontFeatureSettings, r11, r13, textGeometricTransform2, localeList2, r33, textDecoration2, shadow2, textAlign2, textDirection3, j9, textIndent3, platformTextStyle2, (i2 & 524288) != 0 ? textStyle2.paragraphStyle.getLineHeightStyle() : lineHeightStyle);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    /* renamed from: copy-NOaFTUo  reason: not valid java name */
    public final /* synthetic */ TextStyle m5489copyNOaFTUo(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, PlatformTextStyle platformStyle2, LineHeightStyle lineHeightStyle) {
        TextForegroundStyle textForegroundStyle;
        long j = color;
        PlatformTextStyle platformTextStyle = platformStyle2;
        if (Color.m3165equalsimpl0(j, this.spanStyle.m5434getColor0d7_KjU())) {
            textForegroundStyle = this.spanStyle.getTextForegroundStyle$ui_text_release();
        } else {
            textForegroundStyle = TextForegroundStyle.Companion.m5869from8_81llA(j);
        }
        PlatformParagraphStyle platformParagraphStyle = null;
        SpanStyle spanStyle2 = r5;
        SpanStyle spanStyle3 = new SpanStyle(textForegroundStyle, fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformTextStyle != null ? platformStyle2.getSpanStyle() : null, this.spanStyle.getDrawStyle(), (DefaultConstructorMarker) null);
        if (platformTextStyle != null) {
            platformParagraphStyle = platformStyle2.getParagraphStyle();
        }
        return new TextStyle(spanStyle2, new ParagraphStyle(textAlign, textDirection, lineHeight, textIndent, platformParagraphStyle, lineHeightStyle, m5500getLineBreakLgCVezo(), m5498getHyphensEaSxIns(), getTextMotion(), (DefaultConstructorMarker) null), platformTextStyle);
    }

    /* renamed from: copy-CXVQc50$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m5482copyCXVQc50$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, int i, Object obj) {
        long j6;
        long j7;
        FontWeight fontWeight2;
        FontStyle fontStyle2;
        TextAlign textAlign2;
        TextDirection textDirection2;
        TextDirection textDirection3;
        long j8;
        long j9;
        TextIndent textIndent2;
        TextIndent textIndent3;
        PlatformTextStyle platformTextStyle2;
        PlatformTextStyle platformTextStyle3;
        LineHeightStyle lineHeightStyle2;
        LineHeightStyle lineHeightStyle3;
        LineBreak lineBreak2;
        TextStyle textStyle2 = textStyle;
        int i2 = i;
        if ((i2 & 1) != 0) {
            j6 = textStyle2.spanStyle.m5434getColor0d7_KjU();
        } else {
            j6 = j;
        }
        if ((i2 & 2) != 0) {
            j7 = textStyle2.spanStyle.m5435getFontSizeXSAIIZE();
        } else {
            j7 = j2;
        }
        if ((i2 & 4) != 0) {
            fontWeight2 = textStyle2.spanStyle.getFontWeight();
        } else {
            fontWeight2 = fontWeight;
        }
        if ((i2 & 8) != 0) {
            fontStyle2 = textStyle2.spanStyle.m5436getFontStyle4Lr2A7w();
        } else {
            fontStyle2 = fontStyle;
        }
        FontSynthesis r8 = (i2 & 16) != 0 ? textStyle2.spanStyle.m5437getFontSynthesisZQGJjVo() : fontSynthesis;
        FontFamily fontFamily2 = (i2 & 32) != 0 ? textStyle2.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i2 & 64) != 0 ? textStyle2.spanStyle.getFontFeatureSettings() : str;
        long r11 = (i2 & 128) != 0 ? textStyle2.spanStyle.m5438getLetterSpacingXSAIIZE() : j3;
        BaselineShift r13 = (i2 & 256) != 0 ? textStyle2.spanStyle.m5433getBaselineShift5SSeXJ0() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i2 & 512) != 0 ? textStyle2.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i2 & 1024) != 0 ? textStyle2.spanStyle.getLocaleList() : localeList;
        long r33 = (i2 & 2048) != 0 ? textStyle2.spanStyle.m5432getBackground0d7_KjU() : j4;
        TextDecoration textDecoration2 = (i2 & 4096) != 0 ? textStyle2.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow2 = (i2 & 8192) != 0 ? textStyle2.spanStyle.getShadow() : shadow;
        TextAlign r15 = (i2 & 16384) != 0 ? textStyle2.paragraphStyle.m5391getTextAlignbuA522U() : textAlign;
        if ((i2 & 32768) != 0) {
            textAlign2 = r15;
            textDirection2 = textStyle2.paragraphStyle.m5393getTextDirectionmmuk1to();
        } else {
            textAlign2 = r15;
            textDirection2 = textDirection;
        }
        if ((i2 & 65536) != 0) {
            textDirection3 = textDirection2;
            j8 = textStyle2.paragraphStyle.m5390getLineHeightXSAIIZE();
        } else {
            textDirection3 = textDirection2;
            j8 = j5;
        }
        if ((i2 & 131072) != 0) {
            j9 = j8;
            textIndent2 = textStyle2.paragraphStyle.getTextIndent();
        } else {
            j9 = j8;
            textIndent2 = textIndent;
        }
        if ((i2 & 262144) != 0) {
            textIndent3 = textIndent2;
            platformTextStyle2 = textStyle2.platformStyle;
        } else {
            textIndent3 = textIndent2;
            platformTextStyle2 = platformTextStyle;
        }
        if ((i2 & 524288) != 0) {
            platformTextStyle3 = platformTextStyle2;
            lineHeightStyle2 = textStyle2.paragraphStyle.getLineHeightStyle();
        } else {
            platformTextStyle3 = platformTextStyle2;
            lineHeightStyle2 = lineHeightStyle;
        }
        if ((i2 & 1048576) != 0) {
            lineHeightStyle3 = lineHeightStyle2;
            lineBreak2 = textStyle2.paragraphStyle.m5388getLineBreakLgCVezo();
        } else {
            lineHeightStyle3 = lineHeightStyle2;
            lineBreak2 = lineBreak;
        }
        return textStyle.m5487copyCXVQc50(j6, j7, fontWeight2, fontStyle2, r8, fontFamily2, fontFeatureSettings, r11, r13, textGeometricTransform2, localeList2, r33, textDecoration2, shadow2, textAlign2, textDirection3, j9, textIndent3, platformTextStyle3, lineHeightStyle3, lineBreak2, (i2 & 2097152) != 0 ? textStyle2.paragraphStyle.m5386getHyphensEaSxIns() : hyphens);
    }

    /* renamed from: copy-CXVQc50  reason: not valid java name */
    public final TextStyle m5487copyCXVQc50(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, PlatformTextStyle platformStyle2, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens) {
        TextForegroundStyle textForegroundStyle;
        long j = color;
        PlatformTextStyle platformTextStyle = platformStyle2;
        if (Color.m3165equalsimpl0(j, this.spanStyle.m5434getColor0d7_KjU())) {
            textForegroundStyle = this.spanStyle.getTextForegroundStyle$ui_text_release();
        } else {
            textForegroundStyle = TextForegroundStyle.Companion.m5869from8_81llA(j);
        }
        PlatformParagraphStyle platformParagraphStyle = null;
        SpanStyle spanStyle2 = r5;
        SpanStyle spanStyle3 = new SpanStyle(textForegroundStyle, fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformTextStyle != null ? platformStyle2.getSpanStyle() : null, getDrawStyle(), (DefaultConstructorMarker) null);
        if (platformTextStyle != null) {
            platformParagraphStyle = platformStyle2.getParagraphStyle();
        }
        return new TextStyle(spanStyle2, new ParagraphStyle(textAlign, textDirection, lineHeight, textIndent, platformParagraphStyle, lineHeightStyle, lineBreak, hyphens, getTextMotion(), (DefaultConstructorMarker) null), platformTextStyle);
    }

    /* renamed from: copy-v2rsoow$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m5486copyv2rsoow$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, Object obj) {
        long j6;
        long j7;
        FontWeight fontWeight2;
        FontStyle fontStyle2;
        DrawStyle drawStyle2;
        TextAlign textAlign2;
        TextAlign textAlign3;
        TextDirection textDirection2;
        TextDirection textDirection3;
        long j8;
        long j9;
        TextIndent textIndent2;
        TextIndent textIndent3;
        PlatformTextStyle platformTextStyle2;
        PlatformTextStyle platformTextStyle3;
        LineHeightStyle lineHeightStyle2;
        LineHeightStyle lineHeightStyle3;
        LineBreak lineBreak2;
        LineBreak lineBreak3;
        Hyphens hyphens2;
        TextStyle textStyle2 = textStyle;
        int i2 = i;
        if ((i2 & 1) != 0) {
            j6 = textStyle2.spanStyle.m5434getColor0d7_KjU();
        } else {
            j6 = j;
        }
        if ((i2 & 2) != 0) {
            j7 = textStyle2.spanStyle.m5435getFontSizeXSAIIZE();
        } else {
            j7 = j2;
        }
        if ((i2 & 4) != 0) {
            fontWeight2 = textStyle2.spanStyle.getFontWeight();
        } else {
            fontWeight2 = fontWeight;
        }
        if ((i2 & 8) != 0) {
            fontStyle2 = textStyle2.spanStyle.m5436getFontStyle4Lr2A7w();
        } else {
            fontStyle2 = fontStyle;
        }
        FontSynthesis r8 = (i2 & 16) != 0 ? textStyle2.spanStyle.m5437getFontSynthesisZQGJjVo() : fontSynthesis;
        FontFamily fontFamily2 = (i2 & 32) != 0 ? textStyle2.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i2 & 64) != 0 ? textStyle2.spanStyle.getFontFeatureSettings() : str;
        long r11 = (i2 & 128) != 0 ? textStyle2.spanStyle.m5438getLetterSpacingXSAIIZE() : j3;
        BaselineShift r13 = (i2 & 256) != 0 ? textStyle2.spanStyle.m5433getBaselineShift5SSeXJ0() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i2 & 512) != 0 ? textStyle2.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i2 & 1024) != 0 ? textStyle2.spanStyle.getLocaleList() : localeList;
        long r33 = (i2 & 2048) != 0 ? textStyle2.spanStyle.m5432getBackground0d7_KjU() : j4;
        TextDecoration textDecoration2 = (i2 & 4096) != 0 ? textStyle2.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow2 = (i2 & 8192) != 0 ? textStyle2.spanStyle.getShadow() : shadow;
        DrawStyle drawStyle3 = (i2 & 16384) != 0 ? textStyle2.spanStyle.getDrawStyle() : drawStyle;
        if ((i2 & 32768) != 0) {
            drawStyle2 = drawStyle3;
            textAlign2 = textStyle2.paragraphStyle.m5391getTextAlignbuA522U();
        } else {
            drawStyle2 = drawStyle3;
            textAlign2 = textAlign;
        }
        if ((i2 & 65536) != 0) {
            textAlign3 = textAlign2;
            textDirection2 = textStyle2.paragraphStyle.m5393getTextDirectionmmuk1to();
        } else {
            textAlign3 = textAlign2;
            textDirection2 = textDirection;
        }
        if ((i2 & 131072) != 0) {
            textDirection3 = textDirection2;
            j8 = textStyle2.paragraphStyle.m5390getLineHeightXSAIIZE();
        } else {
            textDirection3 = textDirection2;
            j8 = j5;
        }
        if ((i2 & 262144) != 0) {
            j9 = j8;
            textIndent2 = textStyle2.paragraphStyle.getTextIndent();
        } else {
            j9 = j8;
            textIndent2 = textIndent;
        }
        if ((i2 & 524288) != 0) {
            textIndent3 = textIndent2;
            platformTextStyle2 = textStyle2.platformStyle;
        } else {
            textIndent3 = textIndent2;
            platformTextStyle2 = platformTextStyle;
        }
        if ((i2 & 1048576) != 0) {
            platformTextStyle3 = platformTextStyle2;
            lineHeightStyle2 = textStyle2.paragraphStyle.getLineHeightStyle();
        } else {
            platformTextStyle3 = platformTextStyle2;
            lineHeightStyle2 = lineHeightStyle;
        }
        if ((i2 & 2097152) != 0) {
            lineHeightStyle3 = lineHeightStyle2;
            lineBreak2 = textStyle2.paragraphStyle.m5388getLineBreakLgCVezo();
        } else {
            lineHeightStyle3 = lineHeightStyle2;
            lineBreak2 = lineBreak;
        }
        if ((i2 & 4194304) != 0) {
            lineBreak3 = lineBreak2;
            hyphens2 = textStyle2.paragraphStyle.m5386getHyphensEaSxIns();
        } else {
            lineBreak3 = lineBreak2;
            hyphens2 = hyphens;
        }
        return textStyle.m5491copyv2rsoow(j6, j7, fontWeight2, fontStyle2, r8, fontFamily2, fontFeatureSettings, r11, r13, textGeometricTransform2, localeList2, r33, textDecoration2, shadow2, drawStyle2, textAlign3, textDirection3, j9, textIndent3, platformTextStyle3, lineHeightStyle3, lineBreak3, hyphens2, (i2 & 8388608) != 0 ? textStyle2.paragraphStyle.getTextMotion() : textMotion);
    }

    /* renamed from: copy-v2rsoow  reason: not valid java name */
    public final TextStyle m5491copyv2rsoow(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, PlatformTextStyle platformStyle2, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        TextForegroundStyle textForegroundStyle;
        long j = color;
        PlatformTextStyle platformTextStyle = platformStyle2;
        if (Color.m3165equalsimpl0(j, this.spanStyle.m5434getColor0d7_KjU())) {
            textForegroundStyle = this.spanStyle.getTextForegroundStyle$ui_text_release();
        } else {
            textForegroundStyle = TextForegroundStyle.Companion.m5869from8_81llA(j);
        }
        PlatformParagraphStyle platformParagraphStyle = null;
        SpanStyle spanStyle2 = r5;
        SpanStyle spanStyle3 = new SpanStyle(textForegroundStyle, fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformTextStyle != null ? platformStyle2.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null);
        if (platformTextStyle != null) {
            platformParagraphStyle = platformStyle2.getParagraphStyle();
        }
        return new TextStyle(spanStyle2, new ParagraphStyle(textAlign, textDirection, lineHeight, textIndent, platformParagraphStyle, lineHeightStyle, lineBreak, hyphens, textMotion, (DefaultConstructorMarker) null), platformTextStyle);
    }

    /* renamed from: copy-aIRg9q4$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m5485copyaIRg9q4$default(TextStyle textStyle, Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, Object obj) {
        float f2;
        long j5;
        FontWeight fontWeight2;
        Shadow shadow2;
        DrawStyle drawStyle2;
        DrawStyle drawStyle3;
        TextAlign textAlign2;
        TextAlign textAlign3;
        TextDirection textDirection2;
        long j6;
        TextDirection textDirection3;
        TextIndent textIndent2;
        PlatformTextStyle platformTextStyle2;
        PlatformTextStyle platformTextStyle3;
        LineHeightStyle lineHeightStyle2;
        LineHeightStyle lineHeightStyle3;
        LineBreak lineBreak2;
        LineBreak lineBreak3;
        Hyphens hyphens2;
        TextStyle textStyle2 = textStyle;
        int i2 = i;
        if ((i2 & 2) != 0) {
            f2 = textStyle2.spanStyle.getAlpha();
        } else {
            f2 = f;
        }
        if ((i2 & 4) != 0) {
            j5 = textStyle2.spanStyle.m5435getFontSizeXSAIIZE();
        } else {
            j5 = j;
        }
        if ((i2 & 8) != 0) {
            fontWeight2 = textStyle2.spanStyle.getFontWeight();
        } else {
            fontWeight2 = fontWeight;
        }
        FontStyle r6 = (i2 & 16) != 0 ? textStyle2.spanStyle.m5436getFontStyle4Lr2A7w() : fontStyle;
        FontSynthesis r7 = (i2 & 32) != 0 ? textStyle2.spanStyle.m5437getFontSynthesisZQGJjVo() : fontSynthesis;
        FontFamily fontFamily2 = (i2 & 64) != 0 ? textStyle2.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i2 & 128) != 0 ? textStyle2.spanStyle.getFontFeatureSettings() : str;
        long r10 = (i2 & 256) != 0 ? textStyle2.spanStyle.m5438getLetterSpacingXSAIIZE() : j2;
        BaselineShift r12 = (i2 & 512) != 0 ? textStyle2.spanStyle.m5433getBaselineShift5SSeXJ0() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i2 & 1024) != 0 ? textStyle2.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i2 & 2048) != 0 ? textStyle2.spanStyle.getLocaleList() : localeList;
        long r17 = (i2 & 4096) != 0 ? textStyle2.spanStyle.m5432getBackground0d7_KjU() : j3;
        TextDecoration textDecoration2 = (i2 & 8192) != 0 ? textStyle2.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow3 = (i2 & 16384) != 0 ? textStyle2.spanStyle.getShadow() : shadow;
        if ((i2 & 32768) != 0) {
            shadow2 = shadow3;
            drawStyle2 = textStyle2.spanStyle.getDrawStyle();
        } else {
            shadow2 = shadow3;
            drawStyle2 = drawStyle;
        }
        if ((i2 & 65536) != 0) {
            drawStyle3 = drawStyle2;
            textAlign2 = textStyle2.paragraphStyle.m5391getTextAlignbuA522U();
        } else {
            drawStyle3 = drawStyle2;
            textAlign2 = textAlign;
        }
        if ((i2 & 131072) != 0) {
            textAlign3 = textAlign2;
            textDirection2 = textStyle2.paragraphStyle.m5393getTextDirectionmmuk1to();
        } else {
            textAlign3 = textAlign2;
            textDirection2 = textDirection;
        }
        if ((i2 & 262144) != 0) {
            textDirection3 = textDirection2;
            j6 = textStyle2.paragraphStyle.m5390getLineHeightXSAIIZE();
        } else {
            textDirection3 = textDirection2;
            j6 = j4;
        }
        TextIndent textIndent3 = (524288 & i2) != 0 ? textStyle2.paragraphStyle.getTextIndent() : textIndent;
        if ((i2 & 1048576) != 0) {
            textIndent2 = textIndent3;
            platformTextStyle2 = textStyle2.platformStyle;
        } else {
            textIndent2 = textIndent3;
            platformTextStyle2 = platformTextStyle;
        }
        if ((i2 & 2097152) != 0) {
            platformTextStyle3 = platformTextStyle2;
            lineHeightStyle2 = textStyle2.paragraphStyle.getLineHeightStyle();
        } else {
            platformTextStyle3 = platformTextStyle2;
            lineHeightStyle2 = lineHeightStyle;
        }
        if ((i2 & 4194304) != 0) {
            lineHeightStyle3 = lineHeightStyle2;
            lineBreak2 = textStyle2.paragraphStyle.m5388getLineBreakLgCVezo();
        } else {
            lineHeightStyle3 = lineHeightStyle2;
            lineBreak2 = lineBreak;
        }
        if ((i2 & 8388608) != 0) {
            lineBreak3 = lineBreak2;
            hyphens2 = textStyle2.paragraphStyle.m5386getHyphensEaSxIns();
        } else {
            lineBreak3 = lineBreak2;
            hyphens2 = hyphens;
        }
        return textStyle.m5490copyaIRg9q4(brush, f2, j5, fontWeight2, r6, r7, fontFamily2, fontFeatureSettings, r10, r12, textGeometricTransform2, localeList2, r17, textDecoration2, shadow2, drawStyle3, textAlign3, textDirection3, j6, textIndent2, platformTextStyle3, lineHeightStyle3, lineBreak3, hyphens2, (i2 & 16777216) != 0 ? textStyle2.paragraphStyle.getTextMotion() : textMotion);
    }

    /* renamed from: copy-aIRg9q4  reason: not valid java name */
    public final TextStyle m5490copyaIRg9q4(Brush brush, float alpha, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, PlatformTextStyle platformStyle2, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        PlatformTextStyle platformTextStyle = platformStyle2;
        PlatformParagraphStyle platformParagraphStyle = null;
        SpanStyle spanStyle2 = r2;
        SpanStyle spanStyle3 = new SpanStyle(brush, alpha, fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformTextStyle != null ? platformStyle2.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null);
        if (platformTextStyle != null) {
            platformParagraphStyle = platformStyle2.getParagraphStyle();
        }
        return new TextStyle(spanStyle2, new ParagraphStyle(textAlign, textDirection, lineHeight, textIndent, platformParagraphStyle, lineHeightStyle, lineBreak, hyphens, textMotion, (DefaultConstructorMarker) null), platformTextStyle);
    }

    public final Brush getBrush() {
        return this.spanStyle.getBrush();
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m5494getColor0d7_KjU() {
        return this.spanStyle.m5434getColor0d7_KjU();
    }

    public final float getAlpha() {
        return this.spanStyle.getAlpha();
    }

    /* renamed from: getFontSize-XSAIIZE  reason: not valid java name */
    public final long m5495getFontSizeXSAIIZE() {
        return this.spanStyle.m5435getFontSizeXSAIIZE();
    }

    public final FontWeight getFontWeight() {
        return this.spanStyle.getFontWeight();
    }

    /* renamed from: getFontStyle-4Lr2A7w  reason: not valid java name */
    public final FontStyle m5496getFontStyle4Lr2A7w() {
        return this.spanStyle.m5436getFontStyle4Lr2A7w();
    }

    /* renamed from: getFontSynthesis-ZQGJjVo  reason: not valid java name */
    public final FontSynthesis m5497getFontSynthesisZQGJjVo() {
        return this.spanStyle.m5437getFontSynthesisZQGJjVo();
    }

    public final FontFamily getFontFamily() {
        return this.spanStyle.getFontFamily();
    }

    public final String getFontFeatureSettings() {
        return this.spanStyle.getFontFeatureSettings();
    }

    /* renamed from: getLetterSpacing-XSAIIZE  reason: not valid java name */
    public final long m5499getLetterSpacingXSAIIZE() {
        return this.spanStyle.m5438getLetterSpacingXSAIIZE();
    }

    /* renamed from: getBaselineShift-5SSeXJ0  reason: not valid java name */
    public final BaselineShift m5493getBaselineShift5SSeXJ0() {
        return this.spanStyle.m5433getBaselineShift5SSeXJ0();
    }

    public final TextGeometricTransform getTextGeometricTransform() {
        return this.spanStyle.getTextGeometricTransform();
    }

    public final LocaleList getLocaleList() {
        return this.spanStyle.getLocaleList();
    }

    /* renamed from: getBackground-0d7_KjU  reason: not valid java name */
    public final long m5492getBackground0d7_KjU() {
        return this.spanStyle.m5432getBackground0d7_KjU();
    }

    public final TextDecoration getTextDecoration() {
        return this.spanStyle.getTextDecoration();
    }

    public final Shadow getShadow() {
        return this.spanStyle.getShadow();
    }

    public final DrawStyle getDrawStyle() {
        return this.spanStyle.getDrawStyle();
    }

    /* renamed from: getTextAlign-buA522U  reason: not valid java name */
    public final TextAlign m5502getTextAlignbuA522U() {
        return this.paragraphStyle.m5391getTextAlignbuA522U();
    }

    /* renamed from: getTextDirection-mmuk1to  reason: not valid java name */
    public final TextDirection m5503getTextDirectionmmuk1to() {
        return this.paragraphStyle.m5393getTextDirectionmmuk1to();
    }

    /* renamed from: getLineHeight-XSAIIZE  reason: not valid java name */
    public final long m5501getLineHeightXSAIIZE() {
        return this.paragraphStyle.m5390getLineHeightXSAIIZE();
    }

    public final TextIndent getTextIndent() {
        return this.paragraphStyle.getTextIndent();
    }

    public final LineHeightStyle getLineHeightStyle() {
        return this.paragraphStyle.getLineHeightStyle();
    }

    /* renamed from: getHyphens-EaSxIns  reason: not valid java name */
    public final Hyphens m5498getHyphensEaSxIns() {
        return this.paragraphStyle.m5386getHyphensEaSxIns();
    }

    /* renamed from: getLineBreak-LgCVezo  reason: not valid java name */
    public final LineBreak m5500getLineBreakLgCVezo() {
        return this.paragraphStyle.m5388getLineBreakLgCVezo();
    }

    public final TextMotion getTextMotion() {
        return this.paragraphStyle.getTextMotion();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof TextStyle) && Intrinsics.areEqual((Object) this.spanStyle, (Object) ((TextStyle) other).spanStyle) && Intrinsics.areEqual((Object) this.paragraphStyle, (Object) ((TextStyle) other).paragraphStyle) && Intrinsics.areEqual((Object) this.platformStyle, (Object) ((TextStyle) other).platformStyle)) {
            return true;
        }
        return false;
    }

    public final boolean hasSameLayoutAffectingAttributes(TextStyle other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this == other || (Intrinsics.areEqual((Object) this.paragraphStyle, (Object) other.paragraphStyle) && this.spanStyle.hasSameLayoutAffectingAttributes$ui_text_release(other.spanStyle));
    }

    public int hashCode() {
        int result = ((this.spanStyle.hashCode() * 31) + this.paragraphStyle.hashCode()) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        return result + (platformTextStyle != null ? platformTextStyle.hashCode() : 0);
    }

    public final int hashCodeLayoutAffectingAttributes$ui_text_release() {
        int result = ((this.spanStyle.hashCodeLayoutAffectingAttributes$ui_text_release() * 31) + this.paragraphStyle.hashCode()) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        return result + (platformTextStyle != null ? platformTextStyle.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TextStyle(color=").append(Color.m3172toStringimpl(m5494getColor0d7_KjU())).append(", brush=").append(getBrush()).append(", alpha=").append(getAlpha()).append(", fontSize=").append(TextUnit.m6174toStringimpl(m5495getFontSizeXSAIIZE())).append(", fontWeight=").append(getFontWeight()).append(", fontStyle=").append(m5496getFontStyle4Lr2A7w()).append(", fontSynthesis=").append(m5497getFontSynthesisZQGJjVo()).append(", fontFamily=").append(getFontFamily()).append(", fontFeatureSettings=").append(getFontFeatureSettings()).append(", letterSpacing=").append(TextUnit.m6174toStringimpl(m5499getLetterSpacingXSAIIZE())).append(", baselineShift=").append(m5493getBaselineShift5SSeXJ0()).append(", textGeometricTransform=");
        sb.append(getTextGeometricTransform()).append(", localeList=").append(getLocaleList()).append(", background=").append(Color.m3172toStringimpl(m5492getBackground0d7_KjU())).append(", textDecoration=").append(getTextDecoration()).append(", shadow=").append(getShadow()).append(", drawStyle=").append(getDrawStyle()).append(", textAlign=").append(m5502getTextAlignbuA522U()).append(", textDirection=").append(m5503getTextDirectionmmuk1to()).append(", lineHeight=").append(TextUnit.m6174toStringimpl(m5501getLineHeightXSAIIZE())).append(", textIndent=").append(getTextIndent()).append(", platformStyle=").append(this.platformStyle).append(", lineHeightStyle=").append(getLineHeightStyle());
        sb.append(", lineBreak=").append(m5500getLineBreakLgCVezo()).append(", hyphens=").append(m5498getHyphensEaSxIns()).append(", textMotion=").append(getTextMotion()).append(')');
        return sb.toString();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/TextStyle$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/TextStyle;", "getDefault$annotations", "getDefault", "()Landroidx/compose/ui/text/TextStyle;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextStyle.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDefault$annotations() {
        }

        private Companion() {
        }

        public final TextStyle getDefault() {
            return TextStyle.Default;
        }
    }
}
