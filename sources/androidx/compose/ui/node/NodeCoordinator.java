package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinatesImpl;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b#\b \u0018\u0000 \u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005:\u0004\u0002\u0002B\r\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ$\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020 H\u0002J,\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J \u0010\u0001\u001a\u00020O2\u0006\u0010N\u001a\u00020OH\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00020D2\b\u0010\u0001\u001a\u00030\u0001H&J*\u0010\u0001\u001a\u00020\u001a2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010N\u001a\u00020OH\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0010\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0006J\u001c\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00062\b\u0010\u0001\u001a\u00030\u0001H\u0004J\u0012\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0006H\u0002J\u0018\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\b\u0001J\"\u0010\u0001\u001a\u00030\u00012\u0007\u0010`\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b \u0001\u0010\u0001J\u001b\u0010¡\u0001\u001a\u00020\u00072\u0007\u0010¢\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020 H\u0002J$\u0010£\u0001\u001a\u00020 2\f\u0010¤\u0001\u001a\u0007\u0012\u0002\b\u00030¥\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¦\u0001\u0010§\u0001J6\u0010¨\u0001\u001a\u0005\u0018\u0001H©\u0001\"\u0007\b\u0000\u0010©\u0001\u0018\u00012\u000f\u0010¤\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010¥\u0001H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bª\u0001\u0010«\u0001J\u0014\u0010¬\u0001\u001a\u0004\u0018\u00010u2\u0007\u0010­\u0001\u001a\u00020 H\u0002J1\u0010®\u0001\u001a\u0005\u0018\u0001H©\u0001\"\u0005\b\u0000\u0010©\u00012\u000f\u0010¤\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010¥\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¯\u0001\u0010«\u0001J`\u0010°\u0001\u001a\u00020\u0007\"\n\b\u0000\u0010©\u0001*\u00030±\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010³\u00012\b\u0010\u0001\u001a\u00030\u00012\u000f\u0010´\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010µ\u00012\u0007\u0010¶\u0001\u001a\u00020 2\u0007\u0010·\u0001\u001a\u00020 ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¸\u0001\u0010¹\u0001Jb\u0010º\u0001\u001a\u00020\u0007\"\n\b\u0000\u0010©\u0001*\u00030±\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010³\u00012\b\u0010\u0001\u001a\u00030\u00012\u000f\u0010´\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010µ\u00012\u0007\u0010¶\u0001\u001a\u00020 2\u0007\u0010·\u0001\u001a\u00020 H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b»\u0001\u0010¹\u0001J\t\u0010¼\u0001\u001a\u00020\u0007H\u0016J\u0013\u0010½\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0006H\u0002J\"\u0010¾\u0001\u001a\u00020 2\b\u0010\u0001\u001a\u00030\u0001H\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¿\u0001\u0010À\u0001J\u0007\u0010Á\u0001\u001a\u00020 J\u001c\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020\u00032\u0007\u0010\u0001\u001a\u00020 H\u0016J,\u0010Å\u0001\u001a\u00030\u00012\u0007\u0010Ä\u0001\u001a\u00020\u00032\b\u0010Æ\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÇ\u0001\u0010È\u0001J#\u0010É\u0001\u001a\u00030\u00012\b\u0010Ê\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bË\u0001\u0010\u0001J#\u0010Ì\u0001\u001a\u00030\u00012\b\u0010Ê\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÍ\u0001\u0010\u0001J#\u0010Î\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÏ\u0001\u0010\u0001J/\u0010Ð\u0001\u001a\u00020\u00072\u0019\u00106\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b52\t\b\u0002\u0010Ñ\u0001\u001a\u00020 H\u0002J\t\u0010Ò\u0001\u001a\u00020\u0007H\u0016J\u0007\u0010Ó\u0001\u001a\u00020\u0007J\u001b\u0010Ô\u0001\u001a\u00020\u00072\u0007\u0010Õ\u0001\u001a\u00020T2\u0007\u0010Ö\u0001\u001a\u00020TH\u0014J\u0007\u0010×\u0001\u001a\u00020\u0007J\u0007\u0010Ø\u0001\u001a\u00020\u0007J\u0007\u0010Ù\u0001\u001a\u00020\u0007J\u0012\u0010Ú\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0006H\u0016J6\u0010Û\u0001\u001a\u00030Ü\u00012\u0007\u0010Ý\u0001\u001a\u00020-2\u000e\u0010Þ\u0001\u001a\t\u0012\u0005\u0012\u00030Ü\u00010$H\bø\u0001\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bß\u0001\u0010à\u0001JD\u0010á\u0001\u001a\u00020\u00072\u0006\u0010`\u001a\u00020_2\u0007\u0010\u0001\u001a\u00020\u001a2\u0019\u00106\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b5H\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bâ\u0001\u0010ã\u0001J\u001d\u0010ä\u0001\u001a\u00020\u00072\b\u0010\u0001\u001a\u00030Ã\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010å\u0001J,\u0010æ\u0001\u001a\u00020\u00072\u0007\u0010¢\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020 2\t\b\u0002\u0010ç\u0001\u001a\u00020 H\u0000¢\u0006\u0003\bè\u0001J\u000f\u0010é\u0001\u001a\u00020\u0007H\u0010¢\u0006\u0003\bê\u0001J\u0007\u0010ë\u0001\u001a\u00020 J\"\u0010ì\u0001\u001a\u00030\u00012\u0007\u0010`\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bí\u0001\u0010\u0001J\b\u0010î\u0001\u001a\u00030Ã\u0001J+\u0010ï\u0001\u001a\u00020\u00072\u0007\u0010Ä\u0001\u001a\u00020\u00032\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bò\u0001\u0010ó\u0001J+\u0010ô\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bõ\u0001\u0010ö\u0001J+\u0010÷\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bø\u0001\u0010ö\u0001J-\u0010ù\u0001\u001a\u00020\u00072\u0019\u00106\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b52\t\b\u0002\u0010Ñ\u0001\u001a\u00020 J\t\u0010ú\u0001\u001a\u00020\u0007H\u0002J\u0011\u0010û\u0001\u001a\u00020\u00072\u0006\u0010E\u001a\u00020DH\u0004J\u001b\u0010ü\u0001\u001a\u00020\u00072\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0000¢\u0006\u0003\bý\u0001JL\u0010þ\u0001\u001a\u00020\u0007\"\u0007\b\u0000\u0010©\u0001\u0018\u00012\u000f\u0010¤\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010¥\u00012\u0014\u0010Þ\u0001\u001a\u000f\u0012\u0005\u0012\u0003H©\u0001\u0012\u0004\u0012\u00020\u00070\u0005H\bø\u0001\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÿ\u0001\u0010\u0002J4\u0010þ\u0001\u001a\u00020\u00072\u0007\u0010\u0002\u001a\u00020T2\u0007\u0010­\u0001\u001a\u00020 2\u0013\u0010Þ\u0001\u001a\u000e\u0012\u0004\u0012\u00020u\u0012\u0004\u0012\u00020\u00070\u0005H\bø\u0001\u0003J#\u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0001J+\u0010\u0002\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00062\u0013\u0010Þ\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\bø\u0001\u0003J\"\u0010\u0002\u001a\u00020 2\b\u0010\u0001\u001a\u00030\u0001H\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010À\u0001Ji\u0010\u0002\u001a\u00020\u0007\"\n\b\u0000\u0010©\u0001*\u00030±\u0001*\u0005\u0018\u0001H©\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010³\u00012\b\u0010\u0001\u001a\u00030\u00012\u000f\u0010´\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010µ\u00012\u0007\u0010¶\u0001\u001a\u00020 2\u0007\u0010·\u0001\u001a\u00020 H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002Jr\u0010\u0002\u001a\u00020\u0007\"\n\b\u0000\u0010©\u0001*\u00030±\u0001*\u0005\u0018\u0001H©\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010³\u00012\b\u0010\u0001\u001a\u00030\u00012\u000f\u0010´\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010µ\u00012\u0007\u0010¶\u0001\u001a\u00020 2\u0007\u0010·\u0001\u001a\u00020 2\u0007\u0010\u0002\u001a\u00020\u001aH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002Jr\u0010\u0002\u001a\u00020\u0007\"\n\b\u0000\u0010©\u0001*\u00030±\u0001*\u0005\u0018\u0001H©\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010³\u00012\b\u0010\u0001\u001a\u00030\u00012\u000f\u0010´\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010µ\u00012\u0007\u0010¶\u0001\u001a\u00020 2\u0007\u0010·\u0001\u001a\u00020 2\u0007\u0010\u0002\u001a\u00020\u001aH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J\r\u0010\u0002\u001a\u00020\u0000*\u00020\u0003H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070$X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\"R\u000e\u0010&\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\"R\u000e\u0010(\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020 2\u0006\u0010)\u001a\u00020 @BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u001d\u0010,\u001a\u00020-8@X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b.\u0010/R\"\u00101\u001a\u0004\u0018\u0001002\b\u0010)\u001a\u0004\u0018\u000100@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103RD\u00106\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b52\u0019\u0010)\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b5@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u000e\u00109\u001a\u00020:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\u00020<8VX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\"\u0010E\u001a\u0004\u0018\u00010D2\b\u0010)\u001a\u0004\u0018\u00010D@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR$\u0010I\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f8P@PX\u000e¢\u0006\f\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001a\u0010N\u001a\u00020O8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bP\u0010/R\u001c\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020T\u0018\u00010RX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010U\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\u0015R\u0013\u0010W\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bX\u0010\u0018R\u0016\u0010Y\u001a\u0004\u0018\u00010Z8VX\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0013\u0010]\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b^\u0010\u0018R/\u0010`\u001a\u00020_2\u0006\u0010)\u001a\u00020_@TX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010d\u001a\u0004\ba\u0010/\"\u0004\bb\u0010cR\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020S0f8VX\u0004¢\u0006\u0006\u001a\u0004\bg\u0010hR\u0014\u0010i\u001a\u00020\u000e8DX\u0004¢\u0006\u0006\u001a\u0004\bj\u0010kR\u000e\u0010l\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010m\u001a\u00020n8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bo\u0010/R\u0014\u0010p\u001a\u00020q8BX\u0004¢\u0006\u0006\u001a\u0004\br\u0010sR\u0012\u0010t\u001a\u00020uX¦\u0004¢\u0006\u0006\u001a\u0004\bv\u0010wR\u001c\u0010x\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u001c\u0010}\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010z\"\u0004\b\u0010|R(\u0010\u0001\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a@DX\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0001\u0010\u001c\"\u0006\b\u0001\u0010\u0001\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b20\u0001¨\u0006\u0002"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "invalidateParentLayer", "Lkotlin/Function0;", "isAttached", "isClipping", "isValidOwnerScope", "lastLayerAlpha", "<set-?>", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "lastMeasurementConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastMeasurementConstraints-msEJaDk$ui_release", "()J", "Landroidx/compose/ui/node/OwnedLayer;", "layer", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate$ui_release", "()Landroidx/compose/ui/node/LookaheadDelegate;", "value", "measureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "minimumTouchTargetSize", "Landroidx/compose/ui/geometry/Size;", "getMinimumTouchTargetSize-NH-jbRc", "oldAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "parent", "getParent", "parentCoordinates", "getParentCoordinates", "parentData", "", "getParentData", "()Ljava/lang/Object;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "Landroidx/compose/ui/unit/IntOffset;", "position", "getPosition-nOcc-ac", "setPosition--gyyYBs", "(J)V", "J", "providedAlignmentLines", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "rectCache", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "released", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrapped", "getWrapped$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "setWrapped$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", "zIndex", "getZIndex", "setZIndex", "(F)V", "ancestorToLocal", "ancestor", "rect", "clipBounds", "Landroidx/compose/ui/geometry/Offset;", "offset", "ancestorToLocal-R5De75A", "(Landroidx/compose/ui/node/NodeCoordinator;J)J", "calculateMinimumTouchTargetPadding", "calculateMinimumTouchTargetPadding-E7KxVPU", "(J)J", "createLookaheadDelegate", "scope", "Landroidx/compose/ui/layout/LookaheadScope;", "distanceInMinimumTouchTarget", "pointerPosition", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "draw", "canvas", "drawBorder", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawContainedDrawModifiers", "findCommonAncestor", "other", "findCommonAncestor$ui_release", "fromParentPosition", "fromParentPosition-MK-Hz9U", "fromParentRect", "bounds", "hasNode", "type", "Landroidx/compose/ui/node/NodeKind;", "hasNode-H91voCI", "(I)Z", "head", "T", "head-H91voCI", "(I)Ljava/lang/Object;", "headNode", "includeTail", "headUnchecked", "headUnchecked-H91voCI", "hitTest", "Landroidx/compose/ui/node/DelegatableNode;", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "isInLayer", "hitTest-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestChild", "hitTestChild-YqVAtuI", "invalidateLayer", "invoke", "isPointerInBounds", "isPointerInBounds-k-4lQ0M", "(J)Z", "isTransparent", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "offsetFromEdge", "offsetFromEdge-MK-Hz9U", "onLayerBlockUpdated", "forceLayerInvalidated", "onLayoutModifierNodeChanged", "onLayoutNodeAttach", "onMeasureResultChanged", "width", "height", "onMeasured", "onPlaced", "onRelease", "performDraw", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "block", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "propagateRelocationRequest", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rectInParent", "clipToMinimumTouchTargetSize", "rectInParent$ui_release", "replace", "replace$ui_release", "shouldSharePointerInputWithSiblings", "toParentPosition", "toParentPosition-MK-Hz9U", "touchBoundsInRoot", "transformFrom", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformFromAncestor", "transformFromAncestor-EL8BTi8", "(Landroidx/compose/ui/node/NodeCoordinator;[F)V", "transformToAncestor", "transformToAncestor-EL8BTi8", "updateLayerBlock", "updateLayerParameters", "updateLookaheadDelegate", "updateLookaheadScope", "updateLookaheadScope$ui_release", "visitNodes", "visitNodes-aLcG6gQ", "(ILkotlin/jvm/functions/Function1;)V", "mask", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "withPositionTranslation", "withinLayerBounds", "withinLayerBounds-k-4lQ0M", "hit", "hit-1hIXUjU", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitNear", "distanceFromEdge", "hitNear-JHbHoSQ", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZF)V", "speculativeHit", "speculativeHit-JHbHoSQ", "toCoordinator", "Companion", "HitTestSource", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeCoordinator.kt */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope, Function1<Canvas, Unit> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";
    /* access modifiers changed from: private */
    public static final HitTestSource<PointerInputModifierNode> PointerInputSource = new NodeCoordinator$Companion$PointerInputSource$1();
    /* access modifiers changed from: private */
    public static final HitTestSource<SemanticsModifierNode> SemanticsSource = new NodeCoordinator$Companion$SemanticsSource$1();
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    /* access modifiers changed from: private */
    public static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayer = NodeCoordinator$Companion$onCommitAffectingLayer$1.INSTANCE;
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayerParams = NodeCoordinator$Companion$onCommitAffectingLayerParams$1.INSTANCE;
    /* access modifiers changed from: private */
    public static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    private static final float[] tmpMatrix = Matrix.m3391constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private final Function0<Unit> invalidateParentLayer = new NodeCoordinator$invalidateParentLayer$1(this);
    private boolean isClipping;
    private float lastLayerAlpha = 0.8f;
    private boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private Density layerDensity = getLayoutNode().getDensity();
    private LayoutDirection layerLayoutDirection = getLayoutNode().getLayoutDirection();
    /* access modifiers changed from: private */
    public LayerPositionalProperties layerPositionalProperties;
    private final LayoutNode layoutNode;
    private LookaheadDelegate lookaheadDelegate;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position = IntOffset.Companion.m6114getZeronOccac();
    private boolean released;
    private NodeCoordinator wrapped;
    private NodeCoordinator wrappedBy;
    private float zIndex;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H&ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0007H&ø\u0001\u0003\u0002\u0015\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "N", "Landroidx/compose/ui/node/DelegatableNode;", "", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "(Landroidx/compose/ui/node/DelegatableNode;)Z", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NodeCoordinator.kt */
    public interface HitTestSource<N extends DelegatableNode> {
        /* renamed from: childHitTest-YqVAtuI  reason: not valid java name */
        void m5118childHitTestYqVAtuI(LayoutNode layoutNode, long j, HitTestResult<N> hitTestResult, boolean z, boolean z2);

        /* renamed from: entityType-OLwlOKw  reason: not valid java name */
        int m5119entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(N n);

        boolean shouldHitTestChildren(LayoutNode layoutNode);
    }

    public abstract LookaheadDelegate createLookaheadDelegate(LookaheadScope lookaheadScope);

    public abstract Modifier.Node getTail();

    public Object propagateRelocationRequest(Rect rect, Continuation<? super Unit> continuation) {
        return propagateRelocationRequest$suspendImpl(this, rect, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Canvas) p1);
        return Unit.INSTANCE;
    }

    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public NodeCoordinator(LayoutNode layoutNode2) {
        Intrinsics.checkNotNullParameter(layoutNode2, "layoutNode");
        this.layoutNode = layoutNode2;
    }

    public final NodeCoordinator getWrapped$ui_release() {
        return this.wrapped;
    }

    public final void setWrapped$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    public final NodeCoordinator getWrappedBy$ui_release() {
        return this.wrappedBy;
    }

    public final void setWrappedBy$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrappedBy = nodeCoordinator;
    }

    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    public LayoutCoordinates getCoordinates() {
        return this;
    }

    /* access modifiers changed from: private */
    public final Modifier.Node headNode(boolean includeTail) {
        Modifier.Node tail;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            return getLayoutNode().getNodes$ui_release().getHead$ui_release();
        }
        if (includeTail) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator == null || (tail = nodeCoordinator.getTail()) == null) {
                return null;
            }
            return tail.getChild$ui_release();
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 != null) {
            return nodeCoordinator2.getTail();
        }
        return null;
    }

    public final void visitNodes(int mask, boolean includeTail, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Modifier.Node stopNode = getTail();
        if (includeTail || (stopNode = stopNode.getParent$ui_release()) != null) {
            Modifier.Node node = headNode(includeTail);
            while (node != null && (node.getAggregateChildKindSet$ui_release() & mask) != 0) {
                if ((node.getKindSet$ui_release() & mask) != 0) {
                    block.invoke(node);
                }
                if (node != stopNode) {
                    node = node.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: visitNodes-aLcG6gQ  reason: not valid java name */
    public final /* synthetic */ <T> void m5111visitNodesaLcG6gQ(int type, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        boolean includeTail$iv = NodeKindKt.m5131getIncludeSelfInTraversalH91voCI(type);
        int mask$iv = type;
        Modifier.Node stopNode$iv = getTail();
        if (includeTail$iv || (stopNode$iv = stopNode$iv.getParent$ui_release()) != null) {
            Modifier.Node node$iv = headNode(includeTail$iv);
            while (node$iv != null && (node$iv.getAggregateChildKindSet$ui_release() & mask$iv) != 0) {
                if ((node$iv.getKindSet$ui_release() & mask$iv) != 0) {
                    Modifier.Node it = node$iv;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (it instanceof Object) {
                        block.invoke(it);
                    }
                }
                if (node$iv != stopNode$iv) {
                    node$iv = node$iv.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: hasNode-H91voCI  reason: not valid java name */
    public final boolean m5097hasNodeH91voCI(int type) {
        Modifier.Node headNode = headNode(NodeKindKt.m5131getIncludeSelfInTraversalH91voCI(type));
        return headNode != null && DelegatableNodeKt.m4961has64DMado(headNode, type);
    }

    /* renamed from: head-H91voCI  reason: not valid java name */
    public final /* synthetic */ <T> T m5098headH91voCI(int type) {
        boolean includeTail$iv = NodeKindKt.m5131getIncludeSelfInTraversalH91voCI(type);
        int mask$iv = type;
        Modifier.Node stopNode$iv = getTail();
        if (!includeTail$iv && (stopNode$iv = stopNode$iv.getParent$ui_release()) == null) {
            return null;
        }
        Modifier.Node node$iv = headNode(includeTail$iv);
        while (node$iv != null && (node$iv.getAggregateChildKindSet$ui_release() & mask$iv) != 0) {
            if ((node$iv.getKindSet$ui_release() & mask$iv) != 0) {
                Intrinsics.reifiedOperationMarker(2, "T");
                return node$iv;
            } else if (node$iv == stopNode$iv) {
                return null;
            } else {
                node$iv = node$iv.getChild$ui_release();
            }
        }
        return null;
    }

    /* renamed from: headUnchecked-H91voCI  reason: not valid java name */
    public final <T> T m5099headUncheckedH91voCI(int type) {
        boolean includeTail$iv = NodeKindKt.m5131getIncludeSelfInTraversalH91voCI(type);
        int mask$iv = type;
        Modifier.Node stopNode$iv = getTail();
        if (!includeTail$iv && (stopNode$iv = stopNode$iv.getParent$ui_release()) == null) {
            return null;
        }
        Modifier.Node node$iv = headNode(includeTail$iv);
        while (node$iv != null && (node$iv.getAggregateChildKindSet$ui_release() & mask$iv) != 0) {
            if ((node$iv.getKindSet$ui_release() & mask$iv) != 0) {
                return node$iv;
            }
            if (node$iv == stopNode$iv) {
                return null;
            }
            node$iv = node$iv.getChild$ui_release();
        }
        return null;
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public final long m5096getSizeYbymL2g() {
        return m4898getMeasuredSizeYbymL2g();
    }

    /* access modifiers changed from: protected */
    public final Function1<GraphicsLayerScope, Unit> getLayerBlock() {
        return this.layerBlock;
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release();
    }

    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    public void replace$ui_release() {
        m5107placeAtf8xVGno(m5095getPositionnOccac(), this.zIndex, this.layerBlock);
    }

    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    public boolean isAttached() {
        return !this.released && getLayoutNode().isAttached();
    }

    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException(UnmeasuredError.toString());
    }

    public void setMeasureResult$ui_release(MeasureResult value) {
        Intrinsics.checkNotNullParameter(value, "value");
        MeasureResult old = this._measureResult;
        if (value != old) {
            this._measureResult = value;
            if (!(old != null && value.getWidth() == old.getWidth() && value.getHeight() == old.getHeight())) {
                onMeasureResultChanged(value.getWidth(), value.getHeight());
            }
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if ((!(map == null || map.isEmpty()) || (!value.getAlignmentLines().isEmpty())) && !Intrinsics.areEqual((Object) value.getAlignmentLines(), (Object) this.oldAlignmentLines)) {
                getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
                Map oldLines = this.oldAlignmentLines;
                if (oldLines == null) {
                    oldLines = new LinkedHashMap();
                    this.oldAlignmentLines = oldLines;
                }
                oldLines.clear();
                oldLines.putAll(value.getAlignmentLines());
            }
        }
    }

    public final LookaheadDelegate getLookaheadDelegate$ui_release() {
        return this.lookaheadDelegate;
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [androidx.compose.ui.layout.LookaheadScope] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateLookaheadScope$ui_release(androidx.compose.ui.layout.LookaheadScope r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x001c
            r1 = r5
            r2 = 0
            androidx.compose.ui.node.LookaheadDelegate r3 = r4.lookaheadDelegate
            if (r3 == 0) goto L_0x000d
            androidx.compose.ui.layout.LookaheadScope r0 = r3.getLookaheadScope()
        L_0x000d:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x0018
            androidx.compose.ui.node.LookaheadDelegate r0 = r4.createLookaheadDelegate(r1)
            goto L_0x001a
        L_0x0018:
            androidx.compose.ui.node.LookaheadDelegate r0 = r4.lookaheadDelegate
        L_0x001a:
        L_0x001c:
            r4.lookaheadDelegate = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeCoordinator.updateLookaheadScope$ui_release(androidx.compose.ui.layout.LookaheadScope):void");
    }

    /* access modifiers changed from: protected */
    public final void updateLookaheadDelegate(LookaheadDelegate lookaheadDelegate2) {
        Intrinsics.checkNotNullParameter(lookaheadDelegate2, "lookaheadDelegate");
        this.lookaheadDelegate = lookaheadDelegate2;
    }

    public Set<AlignmentLine> getProvidedAlignmentLines() {
        Set set = null;
        for (NodeCoordinator coordinator = this; coordinator != null; coordinator = coordinator.wrapped) {
            MeasureResult measureResult = coordinator._measureResult;
            Map alignmentLines = measureResult != null ? measureResult.getAlignmentLines() : null;
            boolean z = false;
            if (alignmentLines != null && (!alignmentLines.isEmpty())) {
                z = true;
            }
            if (z) {
                if (set == null) {
                    set = new LinkedHashSet();
                }
                set.addAll(alignmentLines.keySet());
            }
        }
        return set == null ? SetsKt.emptySet() : set;
    }

    /* access modifiers changed from: protected */
    public void onMeasureResultChanged(int width, int height) {
        OwnedLayer layer2 = this.layer;
        if (layer2 != null) {
            layer2.m5170resizeozmzZPI(IntSizeKt.IntSize(width, height));
        } else {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null) {
                nodeCoordinator.invalidateLayer();
            }
        }
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(getLayoutNode());
        }
        m4901setMeasuredSizeozmzZPI(IntSizeKt.IntSize(width, height));
        graphicsLayerScope.m3499setSizeuvyYCjk(IntSizeKt.m6156toSizeozmzZPI(m4898getMeasuredSizeYbymL2g()));
        int type$iv = NodeKind.m5123constructorimpl(4);
        boolean includeTail$iv$iv = NodeKindKt.m5131getIncludeSelfInTraversalH91voCI(type$iv);
        int mask$iv$iv = type$iv;
        Modifier.Node stopNode$iv$iv = getTail();
        if (includeTail$iv$iv || (stopNode$iv$iv = stopNode$iv$iv.getParent$ui_release()) != null) {
            Modifier.Node node$iv$iv = headNode(includeTail$iv$iv);
            while (node$iv$iv != null && (node$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                    Modifier.Node it$iv = node$iv$iv;
                    if (it$iv instanceof DrawModifierNode) {
                        ((DrawModifierNode) it$iv).onMeasureResultChanged();
                    }
                }
                if (node$iv$iv != stopNode$iv$iv) {
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: getPosition-nOcc-ac  reason: not valid java name */
    public long m5095getPositionnOccac() {
        return this.position;
    }

    /* access modifiers changed from: protected */
    /* renamed from: setPosition--gyyYBs  reason: not valid java name */
    public void m5108setPositiongyyYBs(long j) {
        this.position = j;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    /* access modifiers changed from: protected */
    public final void setZIndex(float f) {
        this.zIndex = f;
    }

    public Object getParentData() {
        Ref.ObjectRef data = new Ref.ObjectRef();
        Modifier.Node thisNode = getTail();
        if (getLayoutNode().getNodes$ui_release().m5073hasH91voCI$ui_release(NodeKind.m5123constructorimpl(64))) {
            Density $this$_get_parentData__u24lambda_u248 = getLayoutNode().getDensity();
            for (Modifier.Node node$iv = getLayoutNode().getNodes$ui_release().getTail$ui_release(); node$iv != null; node$iv = node$iv.getParent$ui_release()) {
                Modifier.Node it = node$iv;
                if (it != thisNode) {
                    if (((it.getKindSet$ui_release() & NodeKind.m5123constructorimpl(64)) != 0) && (it instanceof ParentDataModifierNode)) {
                        data.element = ((ParentDataModifierNode) it).modifyParentData($this$_get_parentData__u24lambda_u248, data.element);
                    }
                }
            }
        }
        return data.element;
    }

    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (isAttached()) {
            return getLayoutNode().getOuterCoordinator$ui_release().wrappedBy;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    public final LayoutCoordinates getParentCoordinates() {
        if (isAttached()) {
            return this.wrappedBy;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    /* access modifiers changed from: protected */
    public final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect != null) {
            return mutableRect;
        }
        MutableRect it = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
        this._rectCache = it;
        return it;
    }

    private final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    /* renamed from: getLastMeasurementConstraints-msEJaDk$ui_release  reason: not valid java name */
    public final long m5093getLastMeasurementConstraintsmsEJaDk$ui_release() {
        return m4899getMeasurementConstraintsmsEJaDk();
    }

    /* access modifiers changed from: protected */
    /* renamed from: performingMeasure-K40F9xA  reason: not valid java name */
    public final Placeable m5106performingMeasureK40F9xA(long constraints, Function0<? extends Placeable> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        m4902setMeasurementConstraintsBRTryo0(constraints);
        Placeable result = (Placeable) block.invoke();
        OwnedLayer layer2 = getLayer();
        if (layer2 != null) {
            layer2.m5170resizeozmzZPI(m4898getMeasuredSizeYbymL2g());
        }
        return result;
    }

    public final void onMeasured() {
        Modifier.Node stopNode$iv$iv;
        int $i$f$withoutReadObservation;
        Snapshot.Companion this_$iv;
        int type$iv;
        if (m5097hasNodeH91voCI(NodeKind.m5123constructorimpl(128))) {
            Snapshot.Companion this_$iv2 = Snapshot.Companion;
            int $i$f$withoutReadObservation2 = false;
            Snapshot snapshot$iv = this_$iv2.createNonObservableSnapshot();
            Snapshot this_$iv$iv = snapshot$iv;
            try {
                Snapshot previous$iv$iv = this_$iv$iv.makeCurrent();
                try {
                    int type$iv2 = NodeKind.m5123constructorimpl(128);
                    boolean includeTail$iv$iv = NodeKindKt.m5131getIncludeSelfInTraversalH91voCI(type$iv2);
                    int mask$iv$iv = type$iv2;
                    if (includeTail$iv$iv) {
                        try {
                            stopNode$iv$iv = getTail();
                        } catch (Throwable th) {
                            th = th;
                            Snapshot.Companion companion = this_$iv2;
                            this_$iv$iv.restoreCurrent(previous$iv$iv);
                            throw th;
                        }
                    } else {
                        stopNode$iv$iv = getTail().getParent$ui_release();
                        if (stopNode$iv$iv == null) {
                            int i = type$iv2;
                            Snapshot.Companion companion2 = this_$iv2;
                            Unit unit = Unit.INSTANCE;
                            this_$iv$iv.restoreCurrent(previous$iv$iv);
                            snapshot$iv.dispose();
                        }
                    }
                    Modifier.Node node$iv$iv = headNode(includeTail$iv$iv);
                    while (true) {
                        if (node$iv$iv != null) {
                            if ((node$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) == 0) {
                                Snapshot.Companion companion3 = this_$iv2;
                                int i2 = $i$f$withoutReadObservation2;
                                break;
                            }
                            if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                                type$iv = type$iv2;
                                Modifier.Node it$iv = node$iv$iv;
                                if (it$iv instanceof LayoutAwareModifierNode) {
                                    this_$iv = this_$iv2;
                                    $i$f$withoutReadObservation = $i$f$withoutReadObservation2;
                                    try {
                                        ((LayoutAwareModifierNode) it$iv).m4989onRemeasuredozmzZPI(m4898getMeasuredSizeYbymL2g());
                                    } catch (Throwable th2) {
                                        th = th2;
                                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                                        throw th;
                                    }
                                } else {
                                    this_$iv = this_$iv2;
                                    $i$f$withoutReadObservation = $i$f$withoutReadObservation2;
                                }
                            } else {
                                type$iv = type$iv2;
                                this_$iv = this_$iv2;
                                $i$f$withoutReadObservation = $i$f$withoutReadObservation2;
                            }
                            if (node$iv$iv == stopNode$iv$iv) {
                                break;
                            }
                            node$iv$iv = node$iv$iv.getChild$ui_release();
                            type$iv2 = type$iv;
                            this_$iv2 = this_$iv;
                            $i$f$withoutReadObservation2 = $i$f$withoutReadObservation;
                        } else {
                            Snapshot.Companion companion4 = this_$iv2;
                            int i3 = $i$f$withoutReadObservation2;
                            break;
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                    try {
                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                        snapshot$iv.dispose();
                    } catch (Throwable th3) {
                        th = th3;
                        snapshot$iv.dispose();
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    Snapshot.Companion companion5 = this_$iv2;
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                Snapshot.Companion companion6 = this_$iv2;
                snapshot$iv.dispose();
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public void m5107placeAtf8xVGno(long position2, float zIndex2, Function1<? super GraphicsLayerScope, Unit> layerBlock2) {
        onLayerBlockUpdated$default(this, layerBlock2, false, 2, (Object) null);
        if (!IntOffset.m6103equalsimpl0(m5095getPositionnOccac(), position2)) {
            m5108setPositiongyyYBs(position2);
            getLayoutNode().getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer layer2 = this.layer;
            if (layer2 != null) {
                layer2.m5169movegyyYBs(position2);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            invalidateAlignmentLinesFromPositionChange(this);
            Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
            if (owner$ui_release != null) {
                owner$ui_release.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = zIndex2;
    }

    public final void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        OwnedLayer layer2 = this.layer;
        if (layer2 != null) {
            layer2.drawLayer(canvas);
            return;
        }
        float x = (float) IntOffset.m6104getXimpl(m5095getPositionnOccac());
        float y = (float) IntOffset.m6105getYimpl(m5095getPositionnOccac());
        canvas.translate(x, y);
        drawContainedDrawModifiers(canvas);
        canvas.translate(-x, -y);
    }

    /* access modifiers changed from: private */
    public final void drawContainedDrawModifiers(Canvas canvas) {
        int type$iv = NodeKind.m5123constructorimpl(4);
        boolean includeTail$iv$iv = NodeKindKt.m5131getIncludeSelfInTraversalH91voCI(type$iv);
        int mask$iv$iv = type$iv;
        DrawModifierNode drawModifierNode = null;
        Modifier.Node stopNode$iv$iv = getTail();
        if (includeTail$iv$iv || (stopNode$iv$iv = stopNode$iv$iv.getParent$ui_release()) != null) {
            Modifier.Node node$iv$iv = headNode(includeTail$iv$iv);
            while (true) {
                if (node$iv$iv != null && (node$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                    if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) == 0) {
                        if (node$iv$iv == stopNode$iv$iv) {
                            break;
                        }
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                    } else {
                        Modifier.Node it$iv = node$iv$iv;
                        if (it$iv instanceof DrawModifierNode) {
                            drawModifierNode = it$iv;
                        }
                        drawModifierNode = drawModifierNode;
                    }
                } else {
                    break;
                }
            }
        }
        DrawModifierNode head = drawModifierNode;
        if (head == null) {
            performDraw(canvas);
            return;
        }
        getLayoutNode().getMDrawScope$ui_release().m5007drawx_KDEd0$ui_release(canvas, IntSizeKt.m6156toSizeozmzZPI(m5096getSizeYbymL2g()), this, head);
    }

    public void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.draw(canvas);
        }
    }

    public final void onPlaced() {
        LookaheadDelegate lookahead = this.lookaheadDelegate;
        if (lookahead != null) {
            int type$iv = NodeKind.m5123constructorimpl(128);
            boolean includeTail$iv$iv = NodeKindKt.m5131getIncludeSelfInTraversalH91voCI(type$iv);
            int mask$iv$iv = type$iv;
            Modifier.Node stopNode$iv$iv = getTail();
            if (includeTail$iv$iv || (stopNode$iv$iv = stopNode$iv$iv.getParent$ui_release()) != null) {
                Modifier.Node node$iv$iv = headNode(includeTail$iv$iv);
                while (node$iv$iv != null && (node$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                    if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                        Modifier.Node it$iv = node$iv$iv;
                        if (it$iv instanceof LayoutAwareModifierNode) {
                            ((LayoutAwareModifierNode) it$iv).onLookaheadPlaced(lookahead.getLookaheadLayoutCoordinates());
                        }
                    }
                    if (node$iv$iv == stopNode$iv$iv) {
                        break;
                    }
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                }
            }
        }
        int type$iv2 = NodeKind.m5123constructorimpl(128);
        boolean includeTail$iv$iv2 = NodeKindKt.m5131getIncludeSelfInTraversalH91voCI(type$iv2);
        int mask$iv$iv2 = type$iv2;
        Modifier.Node stopNode$iv$iv2 = getTail();
        if (includeTail$iv$iv2 || (stopNode$iv$iv2 = stopNode$iv$iv2.getParent$ui_release()) != null) {
            Modifier.Node node$iv$iv2 = headNode(includeTail$iv$iv2);
            while (node$iv$iv2 != null && (node$iv$iv2.getAggregateChildKindSet$ui_release() & mask$iv$iv2) != 0) {
                if ((node$iv$iv2.getKindSet$ui_release() & mask$iv$iv2) != 0) {
                    Modifier.Node it$iv2 = node$iv$iv2;
                    if (it$iv2 instanceof LayoutAwareModifierNode) {
                        ((LayoutAwareModifierNode) it$iv2).onPlaced(this);
                    }
                }
                if (node$iv$iv2 != stopNode$iv$iv2) {
                    node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    public void invoke(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getLayoutNode().isPlaced()) {
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayer, new NodeCoordinator$invoke$1(this, canvas));
            this.lastLayerDrawingWasSkipped = false;
            return;
        }
        this.lastLayerDrawingWasSkipped = true;
    }

    public static /* synthetic */ void updateLayerBlock$default(NodeCoordinator nodeCoordinator, Function1 function1, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            nodeCoordinator.updateLayerBlock(function1, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
    }

    public final void updateLayerBlock(Function1<? super GraphicsLayerScope, Unit> layerBlock2, boolean forceLayerInvalidated) {
        boolean layerInvalidated = this.layerBlock != layerBlock2 || forceLayerInvalidated;
        this.layerBlock = layerBlock2;
        onLayerBlockUpdated(layerBlock2, layerInvalidated);
    }

    static /* synthetic */ void onLayerBlockUpdated$default(NodeCoordinator nodeCoordinator, Function1 function1, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            nodeCoordinator.onLayerBlockUpdated(function1, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLayerBlockUpdated");
    }

    private final void onLayerBlockUpdated(Function1<? super GraphicsLayerScope, Unit> layerBlock2, boolean forceLayerInvalidated) {
        Owner owner$ui_release;
        boolean layerInvalidated = this.layerBlock != layerBlock2 || !Intrinsics.areEqual((Object) this.layerDensity, (Object) getLayoutNode().getDensity()) || this.layerLayoutDirection != getLayoutNode().getLayoutDirection() || forceLayerInvalidated;
        this.layerBlock = layerBlock2;
        this.layerDensity = getLayoutNode().getDensity();
        this.layerLayoutDirection = getLayoutNode().getLayoutDirection();
        if (!isAttached() || layerBlock2 == null) {
            OwnedLayer it = this.layer;
            if (it != null) {
                it.destroy();
                getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
                if (isAttached() && (owner$ui_release = getLayoutNode().getOwner$ui_release()) != null) {
                    owner$ui_release.onLayoutChange(getLayoutNode());
                }
            }
            this.layer = null;
            this.lastLayerDrawingWasSkipped = false;
        } else if (this.layer == null) {
            OwnedLayer createLayer = LayoutNodeKt.requireOwner(getLayoutNode()).createLayer(this, this.invalidateParentLayer);
            OwnedLayer $this$onLayerBlockUpdated_u24lambda_u2416 = createLayer;
            $this$onLayerBlockUpdated_u24lambda_u2416.m5170resizeozmzZPI(m4898getMeasuredSizeYbymL2g());
            $this$onLayerBlockUpdated_u24lambda_u2416.m5169movegyyYBs(m5095getPositionnOccac());
            this.layer = createLayer;
            updateLayerParameters();
            getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
        } else if (layerInvalidated) {
            updateLayerParameters();
        }
    }

    /* access modifiers changed from: private */
    public final void updateLayerParameters() {
        OwnedLayer layer2 = this.layer;
        if (layer2 != null) {
            Function1<? super GraphicsLayerScope, Unit> function1 = this.layerBlock;
            if (function1 != null) {
                Function1<? super GraphicsLayerScope, Unit> function12 = function1;
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
                reusableGraphicsLayerScope.reset();
                reusableGraphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
                reusableGraphicsLayerScope.m3499setSizeuvyYCjk(IntSizeKt.m6156toSizeozmzZPI(m5096getSizeYbymL2g()));
                getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new NodeCoordinator$updateLayerParameters$1(function12));
                LayerPositionalProperties it = this.layerPositionalProperties;
                if (it == null) {
                    it = new LayerPositionalProperties();
                    this.layerPositionalProperties = it;
                }
                LayerPositionalProperties layerPositionalProperties2 = it;
                layerPositionalProperties2.copyFrom((GraphicsLayerScope) reusableGraphicsLayerScope);
                LayerPositionalProperties layerPositionalProperties3 = layerPositionalProperties2;
                ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = reusableGraphicsLayerScope;
                Function1<? super GraphicsLayerScope, Unit> function13 = function12;
                OwnedLayer ownedLayer = layer2;
                layer2.m5172updateLayerPropertiesdDxrwY(reusableGraphicsLayerScope.getScaleX(), reusableGraphicsLayerScope.getScaleY(), reusableGraphicsLayerScope.getAlpha(), reusableGraphicsLayerScope.getTranslationX(), reusableGraphicsLayerScope.getTranslationY(), reusableGraphicsLayerScope.getShadowElevation(), reusableGraphicsLayerScope.getRotationX(), reusableGraphicsLayerScope.getRotationY(), reusableGraphicsLayerScope.getRotationZ(), reusableGraphicsLayerScope.getCameraDistance(), reusableGraphicsLayerScope.m3496getTransformOriginSzJe1aQ(), reusableGraphicsLayerScope.getShape(), reusableGraphicsLayerScope2.getClip(), reusableGraphicsLayerScope2.getRenderEffect(), reusableGraphicsLayerScope.m3492getAmbientShadowColor0d7_KjU(), reusableGraphicsLayerScope.m3495getSpotShadowColor0d7_KjU(), reusableGraphicsLayerScope2.m3493getCompositingStrategyNrFUSI(), getLayoutNode().getLayoutDirection(), getLayoutNode().getDensity());
                this.isClipping = reusableGraphicsLayerScope2.getClip();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            if (!(this.layerBlock == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
        this.lastLayerAlpha = graphicsLayerScope.getAlpha();
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(getLayoutNode());
        }
    }

    public final boolean getLastLayerDrawingWasSkipped$ui_release() {
        return this.lastLayerDrawingWasSkipped;
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    public boolean isValidOwnerScope() {
        return this.layer != null && isAttached();
    }

    /* renamed from: getMinimumTouchTargetSize-NH-jbRc  reason: not valid java name */
    public final long m5094getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.m5968toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().m5282getMinimumTouchTargetSizeMYxV2XQ());
    }

    /* renamed from: hitTest-YqVAtuI  reason: not valid java name */
    public final <T extends DelegatableNode> void m5100hitTestYqVAtuI(HitTestSource<T> hitTestSource, long pointerPosition, HitTestResult<T> hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        float f;
        long j = pointerPosition;
        HitTestResult<T> hitTestResult2 = hitTestResult;
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult2, "hitTestResult");
        DelegatableNode head = (DelegatableNode) m5099headUncheckedH91voCI(hitTestSource.m5119entityTypeOLwlOKw());
        boolean z = true;
        if (!m5113withinLayerBoundsk4lQ0M(j)) {
            if (isTouchEvent) {
                float distanceFromEdge = m5091distanceInMinimumTouchTargettz77jQw(j, m5094getMinimumTouchTargetSizeNHjbRc());
                if (Float.isInfinite(distanceFromEdge) || Float.isNaN(distanceFromEdge)) {
                    z = false;
                }
                if (z && hitTestResult2.isHitInMinimumTouchTargetBetter(distanceFromEdge, false)) {
                    m5085hitNearJHbHoSQ(head, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, false, distanceFromEdge);
                }
            }
        } else if (head == null) {
            m5101hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        } else if (m5102isPointerInBoundsk4lQ0M(j)) {
            m5084hit1hIXUjU(head, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        } else {
            if (!isTouchEvent) {
                f = Float.POSITIVE_INFINITY;
            } else {
                f = m5091distanceInMinimumTouchTargettz77jQw(j, m5094getMinimumTouchTargetSizeNHjbRc());
            }
            float distanceFromEdge2 = f;
            if (Float.isInfinite(distanceFromEdge2) || Float.isNaN(distanceFromEdge2)) {
                z = false;
            }
            if (!z || !hitTestResult2.isHitInMinimumTouchTargetBetter(distanceFromEdge2, isInLayer)) {
                m5087speculativeHitJHbHoSQ(head, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge2);
            } else {
                m5085hitNearJHbHoSQ(head, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: hit-1hIXUjU  reason: not valid java name */
    public final <T extends DelegatableNode> void m5084hit1hIXUjU(T $this$hit_u2d1hIXUjU, HitTestSource<T> hitTestSource, long pointerPosition, HitTestResult<T> hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        if ($this$hit_u2d1hIXUjU == null) {
            m5101hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            HitTestResult<T> hitTestResult2 = hitTestResult;
            boolean z = isInLayer;
            return;
        }
        hitTestResult.hit($this$hit_u2d1hIXUjU, isInLayer, new NodeCoordinator$hit$1(this, $this$hit_u2d1hIXUjU, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer));
    }

    /* access modifiers changed from: private */
    /* renamed from: hitNear-JHbHoSQ  reason: not valid java name */
    public final <T extends DelegatableNode> void m5085hitNearJHbHoSQ(T $this$hitNear_u2dJHbHoSQ, HitTestSource<T> hitTestSource, long pointerPosition, HitTestResult<T> hitTestResult, boolean isTouchEvent, boolean isInLayer, float distanceFromEdge) {
        if ($this$hitNear_u2dJHbHoSQ == null) {
            m5101hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            HitTestResult<T> hitTestResult2 = hitTestResult;
            boolean z = isInLayer;
            float f = distanceFromEdge;
            return;
        }
        float f2 = distanceFromEdge;
        hitTestResult.hitInMinimumTouchTarget($this$hitNear_u2dJHbHoSQ, f2, isInLayer, new NodeCoordinator$hitNear$1(this, $this$hitNear_u2dJHbHoSQ, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge));
    }

    /* access modifiers changed from: private */
    /* renamed from: speculativeHit-JHbHoSQ  reason: not valid java name */
    public final <T extends DelegatableNode> void m5087speculativeHitJHbHoSQ(T $this$speculativeHit_u2dJHbHoSQ, HitTestSource<T> hitTestSource, long pointerPosition, HitTestResult<T> hitTestResult, boolean isTouchEvent, boolean isInLayer, float distanceFromEdge) {
        T t = $this$speculativeHit_u2dJHbHoSQ;
        if (t == null) {
            m5101hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            HitTestSource<T> hitTestSource2 = hitTestSource;
            HitTestResult<T> hitTestResult2 = hitTestResult;
            boolean z = isInLayer;
            float f = distanceFromEdge;
        } else if (hitTestSource.interceptOutOfBoundsChildEvents(t)) {
            float f2 = distanceFromEdge;
            hitTestResult.speculativeHit(t, f2, isInLayer, new NodeCoordinator$speculativeHit$1(this, $this$speculativeHit_u2dJHbHoSQ, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge));
        } else {
            HitTestResult<T> hitTestResult3 = hitTestResult;
            boolean z2 = isInLayer;
            float f3 = distanceFromEdge;
            m5087speculativeHitJHbHoSQ((DelegatableNode) NodeCoordinatorKt.m5121nextUncheckedUntilhw7D004(t, hitTestSource.m5119entityTypeOLwlOKw(), NodeKind.m5123constructorimpl(2)), hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge);
        }
    }

    /* renamed from: hitTestChild-YqVAtuI  reason: not valid java name */
    public <T extends DelegatableNode> void m5101hitTestChildYqVAtuI(HitTestSource<T> hitTestSource, long pointerPosition, HitTestResult<T> hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        NodeCoordinator wrapped2 = this.wrapped;
        if (wrapped2 != null) {
            wrapped2.m5100hitTestYqVAtuI(hitTestSource, wrapped2.m5092fromParentPositionMKHz9U(pointerPosition), hitTestResult, isTouchEvent, isInLayer);
        } else {
            long j = pointerPosition;
        }
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates root = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect bounds = getRectCache();
        long padding = m5090calculateMinimumTouchTargetPaddingE7KxVPU(m5094getMinimumTouchTargetSizeNHjbRc());
        bounds.setLeft(-Size.m2984getWidthimpl(padding));
        bounds.setTop(-Size.m2981getHeightimpl(padding));
        bounds.setRight(((float) getMeasuredWidth()) + Size.m2984getWidthimpl(padding));
        bounds.setBottom(((float) getMeasuredHeight()) + Size.m2981getHeightimpl(padding));
        NodeCoordinator coordinator = this;
        while (coordinator != root) {
            coordinator.rectInParent$ui_release(bounds, false, true);
            if (bounds.isEmpty()) {
                return Rect.Companion.getZero();
            }
            NodeCoordinator nodeCoordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            coordinator = nodeCoordinator;
        }
        return MutableRectKt.toRect(bounds);
    }

    /* renamed from: windowToLocal-MK-Hz9U  reason: not valid java name */
    public long m5112windowToLocalMKHz9U(long relativeToWindow) {
        if (isAttached()) {
            LayoutCoordinates root = LayoutCoordinatesKt.findRootCoordinates(this);
            return m5103localPositionOfR5De75A(root, Offset.m2919minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).m5173calculateLocalPositionMKHz9U(relativeToWindow), LayoutCoordinatesKt.positionInRoot(root)));
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    /* renamed from: localToWindow-MK-Hz9U  reason: not valid java name */
    public long m5105localToWindowMKHz9U(long relativeToLocal) {
        return LayoutNodeKt.requireOwner(getLayoutNode()).m5174calculatePositionInWindowMKHz9U(m5104localToRootMKHz9U(relativeToLocal));
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates $this$toCoordinator) {
        NodeCoordinator coordinator;
        LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinatesImpl = $this$toCoordinator instanceof LookaheadLayoutCoordinatesImpl ? (LookaheadLayoutCoordinatesImpl) $this$toCoordinator : null;
        if (lookaheadLayoutCoordinatesImpl != null && (coordinator = lookaheadLayoutCoordinatesImpl.getCoordinator()) != null) {
            return coordinator;
        }
        Intrinsics.checkNotNull($this$toCoordinator, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) $this$toCoordinator;
    }

    /* renamed from: localPositionOf-R5De75A  reason: not valid java name */
    public long m5103localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        NodeCoordinator nodeCoordinator = toCoordinator(sourceCoordinates);
        NodeCoordinator commonAncestor = findCommonAncestor$ui_release(nodeCoordinator);
        long position2 = relativeToSource;
        NodeCoordinator coordinator = nodeCoordinator;
        while (coordinator != commonAncestor) {
            position2 = coordinator.m5109toParentPositionMKHz9U(position2);
            NodeCoordinator nodeCoordinator2 = coordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator2);
            coordinator = nodeCoordinator2;
        }
        return m5083ancestorToLocalR5De75A(commonAncestor, position2);
    }

    /* renamed from: transformFrom-EL8BTi8  reason: not valid java name */
    public void m5110transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        NodeCoordinator commonAncestor = findCommonAncestor$ui_release(coordinator);
        Matrix.m3400resetimpl(matrix);
        coordinator.m5089transformToAncestorEL8BTi8(commonAncestor, matrix);
        m5088transformFromAncestorEL8BTi8(commonAncestor, matrix);
    }

    /* renamed from: transformToAncestor-EL8BTi8  reason: not valid java name */
    private final void m5089transformToAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        NodeCoordinator wrapper = this;
        while (!Intrinsics.areEqual((Object) wrapper, (Object) ancestor)) {
            OwnedLayer ownedLayer = wrapper.layer;
            if (ownedLayer != null) {
                ownedLayer.m5171transform58bKbWc(matrix);
            }
            long position2 = wrapper.m5095getPositionnOccac();
            if (!IntOffset.m6103equalsimpl0(position2, IntOffset.Companion.m6114getZeronOccac())) {
                float[] fArr = tmpMatrix;
                Matrix.m3400resetimpl(fArr);
                Matrix.m3411translateimpl$default(fArr, (float) IntOffset.m6104getXimpl(position2), (float) IntOffset.m6105getYimpl(position2), 0.0f, 4, (Object) null);
                Matrix.m3408timesAssign58bKbWc(matrix, fArr);
            }
            NodeCoordinator nodeCoordinator = wrapper.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            wrapper = nodeCoordinator;
        }
    }

    /* renamed from: transformFromAncestor-EL8BTi8  reason: not valid java name */
    private final void m5088transformFromAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        if (!Intrinsics.areEqual((Object) ancestor, (Object) this)) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            nodeCoordinator.m5088transformFromAncestorEL8BTi8(ancestor, matrix);
            if (!IntOffset.m6103equalsimpl0(m5095getPositionnOccac(), IntOffset.Companion.m6114getZeronOccac())) {
                float[] fArr = tmpMatrix;
                Matrix.m3400resetimpl(fArr);
                Matrix.m3411translateimpl$default(fArr, -((float) IntOffset.m6104getXimpl(m5095getPositionnOccac())), -((float) IntOffset.m6105getYimpl(m5095getPositionnOccac())), 0.0f, 4, (Object) null);
                Matrix.m3408timesAssign58bKbWc(matrix, fArr);
            }
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.m5166inverseTransform58bKbWc(matrix);
            }
        }
    }

    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        } else if (sourceCoordinates.isAttached()) {
            NodeCoordinator srcCoordinator = toCoordinator(sourceCoordinates);
            NodeCoordinator commonAncestor = findCommonAncestor$ui_release(srcCoordinator);
            MutableRect bounds = getRectCache();
            bounds.setLeft(0.0f);
            bounds.setTop(0.0f);
            bounds.setRight((float) IntSize.m6146getWidthimpl(sourceCoordinates.m4839getSizeYbymL2g()));
            bounds.setBottom((float) IntSize.m6145getHeightimpl(sourceCoordinates.m4839getSizeYbymL2g()));
            NodeCoordinator coordinator = srcCoordinator;
            while (coordinator != commonAncestor) {
                rectInParent$ui_release$default(coordinator, bounds, clipBounds, false, 4, (Object) null);
                if (bounds.isEmpty()) {
                    return Rect.Companion.getZero();
                }
                NodeCoordinator nodeCoordinator = coordinator.wrappedBy;
                Intrinsics.checkNotNull(nodeCoordinator);
                coordinator = nodeCoordinator;
            }
            ancestorToLocal(commonAncestor, bounds, clipBounds);
            return MutableRectKt.toRect(bounds);
        } else {
            throw new IllegalStateException(("LayoutCoordinates " + sourceCoordinates + " is not attached!").toString());
        }
    }

    /* renamed from: ancestorToLocal-R5De75A  reason: not valid java name */
    private final long m5083ancestorToLocalR5De75A(NodeCoordinator ancestor, long offset) {
        if (ancestor == this) {
            return offset;
        }
        NodeCoordinator wrappedBy2 = this.wrappedBy;
        if (wrappedBy2 == null || Intrinsics.areEqual((Object) ancestor, (Object) wrappedBy2)) {
            return m5092fromParentPositionMKHz9U(offset);
        }
        return m5092fromParentPositionMKHz9U(wrappedBy2.m5083ancestorToLocalR5De75A(ancestor, offset));
    }

    private final void ancestorToLocal(NodeCoordinator ancestor, MutableRect rect, boolean clipBounds) {
        if (ancestor != this) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null) {
                nodeCoordinator.ancestorToLocal(ancestor, rect, clipBounds);
            }
            fromParentRect(rect, clipBounds);
        }
    }

    /* renamed from: localToRoot-MK-Hz9U  reason: not valid java name */
    public long m5104localToRootMKHz9U(long relativeToLocal) {
        if (isAttached()) {
            long position2 = relativeToLocal;
            for (NodeCoordinator coordinator = this; coordinator != null; coordinator = coordinator.wrappedBy) {
                position2 = coordinator.m5109toParentPositionMKHz9U(position2);
            }
            return position2;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    /* access modifiers changed from: protected */
    public final void withPositionTranslation(Canvas canvas, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(block, "block");
        float x = (float) IntOffset.m6104getXimpl(m5095getPositionnOccac());
        float y = (float) IntOffset.m6105getYimpl(m5095getPositionnOccac());
        canvas.translate(x, y);
        block.invoke(canvas);
        canvas.translate(-x, -y);
    }

    /* renamed from: toParentPosition-MK-Hz9U  reason: not valid java name */
    public long m5109toParentPositionMKHz9U(long position2) {
        OwnedLayer layer2 = this.layer;
        return IntOffsetKt.m6118plusNvtHpc(layer2 != null ? layer2.m5168mapOffset8S9VItk(position2, false) : position2, m5095getPositionnOccac());
    }

    /* renamed from: fromParentPosition-MK-Hz9U  reason: not valid java name */
    public long m5092fromParentPositionMKHz9U(long position2) {
        long relativeToPosition = IntOffsetKt.m6116minusNvtHpc(position2, m5095getPositionnOccac());
        OwnedLayer layer2 = this.layer;
        if (layer2 != null) {
            return layer2.m5168mapOffset8S9VItk(relativeToPosition, true);
        }
        return relativeToPosition;
    }

    /* access modifiers changed from: protected */
    public final void drawBorder(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.drawRect(new Rect(0.5f, 0.5f, ((float) IntSize.m6146getWidthimpl(m4898getMeasuredSizeYbymL2g())) - 0.5f, ((float) IntSize.m6145getHeightimpl(m4898getMeasuredSizeYbymL2g())) - 0.5f), paint);
    }

    public final void onLayoutNodeAttach() {
        onLayerBlockUpdated$default(this, this.layerBlock, false, 2, (Object) null);
    }

    public final void onRelease() {
        this.released = true;
        if (this.layer != null) {
            onLayerBlockUpdated$default(this, (Function1) null, false, 2, (Object) null);
        }
    }

    public static /* synthetic */ void rectInParent$ui_release$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            nodeCoordinator.rectInParent$ui_release(mutableRect, z, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
    }

    public final void rectInParent$ui_release(MutableRect bounds, boolean clipBounds, boolean clipToMinimumTouchTargetSize) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        OwnedLayer layer2 = this.layer;
        if (layer2 != null) {
            if (this.isClipping) {
                if (clipToMinimumTouchTargetSize) {
                    long minTouch = m5094getMinimumTouchTargetSizeNHjbRc();
                    float horz = Size.m2984getWidthimpl(minTouch) / 2.0f;
                    float vert = Size.m2981getHeightimpl(minTouch) / 2.0f;
                    bounds.intersect(-horz, -vert, ((float) IntSize.m6146getWidthimpl(m5096getSizeYbymL2g())) + horz, ((float) IntSize.m6145getHeightimpl(m5096getSizeYbymL2g())) + vert);
                } else if (clipBounds) {
                    bounds.intersect(0.0f, 0.0f, (float) IntSize.m6146getWidthimpl(m5096getSizeYbymL2g()), (float) IntSize.m6145getHeightimpl(m5096getSizeYbymL2g()));
                }
                if (bounds.isEmpty()) {
                    return;
                }
            }
            layer2.mapBounds(bounds, false);
        }
        int x = IntOffset.m6104getXimpl(m5095getPositionnOccac());
        bounds.setLeft(bounds.getLeft() + ((float) x));
        bounds.setRight(bounds.getRight() + ((float) x));
        int y = IntOffset.m6105getYimpl(m5095getPositionnOccac());
        bounds.setTop(bounds.getTop() + ((float) y));
        bounds.setBottom(bounds.getBottom() + ((float) y));
    }

    private final void fromParentRect(MutableRect bounds, boolean clipBounds) {
        int x = IntOffset.m6104getXimpl(m5095getPositionnOccac());
        bounds.setLeft(bounds.getLeft() - ((float) x));
        bounds.setRight(bounds.getRight() - ((float) x));
        int y = IntOffset.m6105getYimpl(m5095getPositionnOccac());
        bounds.setTop(bounds.getTop() - ((float) y));
        bounds.setBottom(bounds.getBottom() - ((float) y));
        OwnedLayer layer2 = this.layer;
        if (layer2 != null) {
            layer2.mapBounds(bounds, true);
            if (this.isClipping && clipBounds) {
                bounds.intersect(0.0f, 0.0f, (float) IntSize.m6146getWidthimpl(m5096getSizeYbymL2g()), (float) IntSize.m6145getHeightimpl(m5096getSizeYbymL2g()));
                bounds.isEmpty();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: withinLayerBounds-k-4lQ0M  reason: not valid java name */
    public final boolean m5113withinLayerBoundsk4lQ0M(long pointerPosition) {
        if (!OffsetKt.m2932isFinitek4lQ0M(pointerPosition)) {
            return false;
        }
        OwnedLayer layer2 = this.layer;
        if (layer2 == null || !this.isClipping || layer2.m5167isInLayerk4lQ0M(pointerPosition)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: isPointerInBounds-k-4lQ0M  reason: not valid java name */
    public final boolean m5102isPointerInBoundsk4lQ0M(long pointerPosition) {
        float x = Offset.m2915getXimpl(pointerPosition);
        float y = Offset.m2916getYimpl(pointerPosition);
        return x >= 0.0f && y >= 0.0f && x < ((float) getMeasuredWidth()) && y < ((float) getMeasuredHeight());
    }

    public void invalidateLayer() {
        OwnedLayer layer2 = this.layer;
        if (layer2 != null) {
            layer2.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    static /* synthetic */ Object propagateRelocationRequest$suspendImpl(NodeCoordinator $this, Rect rect, Continuation<? super Unit> $completion) {
        NodeCoordinator parent = $this.wrappedBy;
        if (parent == null) {
            return Unit.INSTANCE;
        }
        Object propagateRelocationRequest = parent.propagateRelocationRequest(rect.m2952translatek4lQ0M(parent.localBoundingBoxOf($this, false).m2950getTopLeftF1C5BW0()), $completion);
        return propagateRelocationRequest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? propagateRelocationRequest : Unit.INSTANCE;
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final NodeCoordinator findCommonAncestor$ui_release(NodeCoordinator other) {
        Intrinsics.checkNotNullParameter(other, "other");
        LayoutNode ancestor1 = other.getLayoutNode();
        LayoutNode ancestor2 = getLayoutNode();
        if (ancestor1 == ancestor2) {
            Modifier.Node otherNode = other.getTail();
            DelegatableNode $this$visitLocalParents$iv = getTail();
            int mask$iv = NodeKind.m5123constructorimpl(2);
            if ($this$visitLocalParents$iv.getNode().isAttached()) {
                for (Modifier.Node next$iv = $this$visitLocalParents$iv.getNode().getParent$ui_release(); next$iv != null; next$iv = next$iv.getParent$ui_release()) {
                    if ((next$iv.getKindSet$ui_release() & mask$iv) != 0 && next$iv == otherNode) {
                        return other;
                    }
                }
                return this;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        while (ancestor1.getDepth$ui_release() > ancestor2.getDepth$ui_release()) {
            LayoutNode parent$ui_release = ancestor1.getParent$ui_release();
            Intrinsics.checkNotNull(parent$ui_release);
            ancestor1 = parent$ui_release;
        }
        while (ancestor2.getDepth$ui_release() > ancestor1.getDepth$ui_release()) {
            LayoutNode parent$ui_release2 = ancestor2.getParent$ui_release();
            Intrinsics.checkNotNull(parent$ui_release2);
            ancestor2 = parent$ui_release2;
        }
        while (ancestor1 != ancestor2) {
            LayoutNode parent1 = ancestor1.getParent$ui_release();
            LayoutNode parent2 = ancestor2.getParent$ui_release();
            if (parent1 == null || parent2 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
            ancestor1 = parent1;
            ancestor2 = parent2;
        }
        if (ancestor2 == getLayoutNode()) {
            return this;
        }
        if (ancestor1 == other.getLayoutNode()) {
            return other;
        }
        return ancestor1.getInnerCoordinator$ui_release();
    }

    public final boolean shouldSharePointerInputWithSiblings() {
        Modifier.Node start = headNode(NodeKindKt.m5131getIncludeSelfInTraversalH91voCI(NodeKind.m5123constructorimpl(16)));
        if (start == null) {
            return false;
        }
        int mask$iv$iv = NodeKind.m5123constructorimpl(16);
        DelegatableNode $this$visitLocalChildren$iv$iv = start;
        if ($this$visitLocalChildren$iv$iv.getNode().isAttached()) {
            Modifier.Node self$iv$iv = $this$visitLocalChildren$iv$iv.getNode();
            if ((self$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                for (Modifier.Node next$iv$iv = self$iv$iv.getChild$ui_release(); next$iv$iv != null; next$iv$iv = next$iv$iv.getChild$ui_release()) {
                    if ((next$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                        Modifier.Node it$iv = next$iv$iv;
                        if ((it$iv instanceof PointerInputModifierNode) && ((PointerInputModifierNode) it$iv).sharePointerInputWithSiblings()) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* renamed from: offsetFromEdge-MK-Hz9U  reason: not valid java name */
    private final long m5086offsetFromEdgeMKHz9U(long pointerPosition) {
        float x = Offset.m2915getXimpl(pointerPosition);
        float horizontal = Math.max(0.0f, x < 0.0f ? -x : x - ((float) getMeasuredWidth()));
        float y = Offset.m2916getYimpl(pointerPosition);
        return OffsetKt.Offset(horizontal, Math.max(0.0f, y < 0.0f ? -y : y - ((float) getMeasuredHeight())));
    }

    /* access modifiers changed from: protected */
    /* renamed from: calculateMinimumTouchTargetPadding-E7KxVPU  reason: not valid java name */
    public final long m5090calculateMinimumTouchTargetPaddingE7KxVPU(long minimumTouchTargetSize) {
        return SizeKt.Size(Math.max(0.0f, (Size.m2984getWidthimpl(minimumTouchTargetSize) - ((float) getMeasuredWidth())) / 2.0f), Math.max(0.0f, (Size.m2981getHeightimpl(minimumTouchTargetSize) - ((float) getMeasuredHeight())) / 2.0f));
    }

    /* access modifiers changed from: protected */
    /* renamed from: distanceInMinimumTouchTarget-tz77jQw  reason: not valid java name */
    public final float m5091distanceInMinimumTouchTargettz77jQw(long pointerPosition, long minimumTouchTargetSize) {
        if (((float) getMeasuredWidth()) >= Size.m2984getWidthimpl(minimumTouchTargetSize) && ((float) getMeasuredHeight()) >= Size.m2981getHeightimpl(minimumTouchTargetSize)) {
            return Float.POSITIVE_INFINITY;
        }
        long r2 = m5090calculateMinimumTouchTargetPaddingE7KxVPU(minimumTouchTargetSize);
        float width = Size.m2984getWidthimpl(r2);
        float height = Size.m2981getHeightimpl(r2);
        long offsetFromEdge = m5086offsetFromEdgeMKHz9U(pointerPosition);
        if ((width > 0.0f || height > 0.0f) && Offset.m2915getXimpl(offsetFromEdge) <= width && Offset.m2916getYimpl(offsetFromEdge) <= height) {
            return Offset.m2914getDistanceSquaredimpl(offsetFromEdge);
        }
        return Float.POSITIVE_INFINITY;
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\u00020\u0019X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001a\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$Companion;", "", "()V", "ExpectAttachedLayoutCoordinates", "", "PointerInputSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "getPointerInputSource$annotations", "getPointerInputSource", "()Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "SemanticsSource", "Landroidx/compose/ui/node/SemanticsModifierNode;", "getSemanticsSource", "UnmeasuredError", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "onCommitAffectingLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/node/NodeCoordinator;", "", "onCommitAffectingLayerParams", "tmpLayerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NodeCoordinator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getPointerInputSource$annotations() {
        }

        private Companion() {
        }

        public final HitTestSource<PointerInputModifierNode> getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        public final HitTestSource<SemanticsModifierNode> getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }
    }
}
