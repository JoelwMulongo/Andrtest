package androidx.compose.ui.layout;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002By\u0012V\u0010\u0003\u001aR\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0004¢\u0006\u0002\b\u000f\u0012\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\"H\u0016J)\u0010#\u001a\u00020\u000e*\u00020\u00052\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%Rd\u0010\u0003\u001aR\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0004¢\u0006\u0002\b\u000fø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R%\u0010\u0017\u001a\u00020\fX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/ui/layout/LookaheadIntermediateLayoutModifierImpl;", "Landroidx/compose/ui/layout/IntermediateLayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "measureBlock", "Lkotlin/Function4;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Lkotlin/ParameterName;", "name", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/unit/IntSize;", "lookaheadSize", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;)V", "getMeasureBlock", "()Lkotlin/jvm/functions/Function4;", "targetSize", "getTargetSize-YbymL2g", "()J", "setTargetSize-ozmzZPI", "(J)V", "J", "equals", "", "other", "", "hashCode", "", "measure", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IntermediateLayoutModifier.kt */
public final class LookaheadIntermediateLayoutModifierImpl extends InspectorValueInfo implements IntermediateLayoutModifier {
    private final Function4<MeasureScope, Measurable, Constraints, IntSize, MeasureResult> measureBlock;
    private long targetSize = IntSize.Companion.m6151getZeroYbymL2g();

    public final Function4<MeasureScope, Measurable, Constraints, IntSize, MeasureResult> getMeasureBlock() {
        return this.measureBlock;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LookaheadIntermediateLayoutModifierImpl(Function4<? super MeasureScope, ? super Measurable, ? super Constraints, ? super IntSize, ? extends MeasureResult> measureBlock2, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        Intrinsics.checkNotNullParameter(measureBlock2, "measureBlock");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.measureBlock = measureBlock2;
    }

    /* renamed from: getTargetSize-YbymL2g  reason: not valid java name */
    public long m4851getTargetSizeYbymL2g() {
        return this.targetSize;
    }

    /* renamed from: setTargetSize-ozmzZPI  reason: not valid java name */
    public void m4853setTargetSizeozmzZPI(long j) {
        this.targetSize = j;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m4852measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return this.measureBlock.invoke($this$measure_u2d3p2s80s, measurable, Constraints.m5918boximpl(constraints), IntSize.m6138boximpl(m4851getTargetSizeYbymL2g()));
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LookaheadIntermediateLayoutModifierImpl)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object) this.measureBlock, (Object) ((LookaheadIntermediateLayoutModifierImpl) other).measureBlock) || !IntSize.m6144equalsimpl0(m4851getTargetSizeYbymL2g(), ((LookaheadIntermediateLayoutModifierImpl) other).m4851getTargetSizeYbymL2g())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.measureBlock.hashCode() * 31) + IntSize.m6147hashCodeimpl(m4851getTargetSizeYbymL2g());
    }
}
