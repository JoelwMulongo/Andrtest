package androidx.compose.foundation;

import android.os.Build;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001\u001ao\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u000f2\u0019\b\u0002\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\rH\u0007ø\u0001\u0000\u001ao\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0001ø\u0001\u0000\"#\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"MagnifierPositionInRoot", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Offset;", "getMagnifierPositionInRoot", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "isPlatformMagnifierSupported", "", "sdkVersion", "", "magnifier", "Landroidx/compose/ui/Modifier;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "zoom", "", "style", "Landroidx/compose/foundation/MagnifierStyle;", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Magnifier.kt */
public final class MagnifierKt {
    private static final SemanticsPropertyKey<Function0<Offset>> MagnifierPositionInRoot = new SemanticsPropertyKey<>("MagnifierPositionInRoot", (Function2) null, 2, (DefaultConstructorMarker) null);

    public static final SemanticsPropertyKey<Function0<Offset>> getMagnifierPositionInRoot() {
        return MagnifierPositionInRoot;
    }

    public static /* synthetic */ Modifier magnifier$default(Modifier modifier, Function1 function1, Function1 function12, float f, MagnifierStyle magnifierStyle, Function1 function13, int i, Object obj) {
        Function1 function14;
        float f2;
        MagnifierStyle magnifierStyle2;
        if ((i & 2) != 0) {
            function14 = MagnifierKt$magnifier$1.INSTANCE;
        } else {
            function14 = function12;
        }
        if ((i & 4) != 0) {
            f2 = Float.NaN;
        } else {
            f2 = f;
        }
        if ((i & 8) != 0) {
            magnifierStyle2 = MagnifierStyle.Companion.getDefault();
        } else {
            magnifierStyle2 = magnifierStyle;
        }
        return magnifier(modifier, function1, function14, f2, magnifierStyle2, (i & 16) != 0 ? null : function13);
    }

    public static final Modifier magnifier(Modifier $this$magnifier, Function1<? super Density, Offset> sourceCenter, Function1<? super Density, Offset> magnifierCenter, float zoom, MagnifierStyle style, Function1<? super DpSize, Unit> onSizeChanged) {
        Function1 function1;
        Modifier modifier;
        Function1<? super Density, Offset> function12 = sourceCenter;
        Function1<? super Density, Offset> function13 = magnifierCenter;
        MagnifierStyle magnifierStyle = style;
        Intrinsics.checkNotNullParameter($this$magnifier, "<this>");
        Intrinsics.checkNotNullParameter(function12, "sourceCenter");
        Intrinsics.checkNotNullParameter(function13, "magnifierCenter");
        Intrinsics.checkNotNullParameter(magnifierStyle, "style");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new MagnifierKt$magnifier$$inlined$debugInspectorInfo$1(function12, function13, zoom, magnifierStyle);
        } else {
            float f = zoom;
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        Modifier $this$inspectable$iv = $this$magnifier;
        Function1 inspectorInfo$iv = function1;
        Modifier $this$magnifier_u24lambda_u241 = Modifier.Companion;
        if (isPlatformMagnifierSupported$default(0, 1, (Object) null)) {
            modifier = magnifier($this$magnifier_u24lambda_u241, sourceCenter, magnifierCenter, zoom, style, onSizeChanged, PlatformMagnifierFactory.Companion.getForCurrentPlatform());
        } else {
            modifier = Modifier.Companion;
        }
        return InspectableValueKt.inspectableWrapper($this$inspectable$iv, inspectorInfo$iv, modifier);
    }

    public static final Modifier magnifier(Modifier $this$magnifier, Function1<? super Density, Offset> sourceCenter, Function1<? super Density, Offset> magnifierCenter, float zoom, MagnifierStyle style, Function1<? super DpSize, Unit> onSizeChanged, PlatformMagnifierFactory platformMagnifierFactory) {
        Intrinsics.checkNotNullParameter($this$magnifier, "<this>");
        Intrinsics.checkNotNullParameter(sourceCenter, "sourceCenter");
        Intrinsics.checkNotNullParameter(magnifierCenter, "magnifierCenter");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(platformMagnifierFactory, "platformMagnifierFactory");
        return ComposedModifierKt.composed$default($this$magnifier, (Function1) null, new MagnifierKt$magnifier$4(sourceCenter, magnifierCenter, zoom, onSizeChanged, platformMagnifierFactory, style), 1, (Object) null);
    }

    public static /* synthetic */ boolean isPlatformMagnifierSupported$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Build.VERSION.SDK_INT;
        }
        return isPlatformMagnifierSupported(i);
    }

    public static final boolean isPlatformMagnifierSupported(int sdkVersion) {
        return sdkVersion >= 28;
    }
}
