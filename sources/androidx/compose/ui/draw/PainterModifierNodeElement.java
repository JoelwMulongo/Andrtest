package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003JG\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\b\u0010%\u001a\u00020\u0002H\u0016J\u0013\u0010&\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001J\u0010\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0002H\u0016J\f\u0010/\u001a\u000200*\u000201H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016¨\u00062"}, d2 = {"Landroidx/compose/ui/draw/PainterModifierNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/draw/PainterModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getAlpha", "()F", "autoInvalidate", "getAutoInvalidate", "()Z", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getSizeToIntrinsics", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PainterModifier.kt */
final class PainterModifierNodeElement extends ModifierNodeElement<PainterModifierNode> {
    private final Alignment alignment;
    private final float alpha;
    private final ColorFilter colorFilter;
    private final ContentScale contentScale;
    private final Painter painter;
    private final boolean sizeToIntrinsics;

    public static /* synthetic */ PainterModifierNodeElement copy$default(PainterModifierNodeElement painterModifierNodeElement, Painter painter2, boolean z, Alignment alignment2, ContentScale contentScale2, float f, ColorFilter colorFilter2, int i, Object obj) {
        if ((i & 1) != 0) {
            painter2 = painterModifierNodeElement.painter;
        }
        if ((i & 2) != 0) {
            z = painterModifierNodeElement.sizeToIntrinsics;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            alignment2 = painterModifierNodeElement.alignment;
        }
        Alignment alignment3 = alignment2;
        if ((i & 8) != 0) {
            contentScale2 = painterModifierNodeElement.contentScale;
        }
        ContentScale contentScale3 = contentScale2;
        if ((i & 16) != 0) {
            f = painterModifierNodeElement.alpha;
        }
        float f2 = f;
        if ((i & 32) != 0) {
            colorFilter2 = painterModifierNodeElement.colorFilter;
        }
        return painterModifierNodeElement.copy(painter2, z2, alignment3, contentScale3, f2, colorFilter2);
    }

    public final Painter component1() {
        return this.painter;
    }

    public final boolean component2() {
        return this.sizeToIntrinsics;
    }

    public final Alignment component3() {
        return this.alignment;
    }

    public final ContentScale component4() {
        return this.contentScale;
    }

    public final float component5() {
        return this.alpha;
    }

    public final ColorFilter component6() {
        return this.colorFilter;
    }

    public final PainterModifierNodeElement copy(Painter painter2, boolean z, Alignment alignment2, ContentScale contentScale2, float f, ColorFilter colorFilter2) {
        Intrinsics.checkNotNullParameter(painter2, "painter");
        Intrinsics.checkNotNullParameter(alignment2, "alignment");
        Intrinsics.checkNotNullParameter(contentScale2, "contentScale");
        return new PainterModifierNodeElement(painter2, z, alignment2, contentScale2, f, colorFilter2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PainterModifierNodeElement)) {
            return false;
        }
        PainterModifierNodeElement painterModifierNodeElement = (PainterModifierNodeElement) obj;
        return Intrinsics.areEqual((Object) this.painter, (Object) painterModifierNodeElement.painter) && this.sizeToIntrinsics == painterModifierNodeElement.sizeToIntrinsics && Intrinsics.areEqual((Object) this.alignment, (Object) painterModifierNodeElement.alignment) && Intrinsics.areEqual((Object) this.contentScale, (Object) painterModifierNodeElement.contentScale) && Float.compare(this.alpha, painterModifierNodeElement.alpha) == 0 && Intrinsics.areEqual((Object) this.colorFilter, (Object) painterModifierNodeElement.colorFilter);
    }

    public int hashCode() {
        int hashCode = this.painter.hashCode() * 31;
        boolean z = this.sizeToIntrinsics;
        if (z) {
            z = true;
        }
        int hashCode2 = (((((((hashCode + (z ? 1 : 0)) * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.hashCode(this.alpha)) * 31;
        ColorFilter colorFilter2 = this.colorFilter;
        return hashCode2 + (colorFilter2 == null ? 0 : colorFilter2.hashCode());
    }

    public String toString() {
        return "PainterModifierNodeElement(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", contentScale=" + this.contentScale + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public PainterModifierNodeElement(Painter painter2, boolean sizeToIntrinsics2, Alignment alignment2, ContentScale contentScale2, float alpha2, ColorFilter colorFilter2) {
        Intrinsics.checkNotNullParameter(painter2, "painter");
        Intrinsics.checkNotNullParameter(alignment2, "alignment");
        Intrinsics.checkNotNullParameter(contentScale2, "contentScale");
        this.painter = painter2;
        this.sizeToIntrinsics = sizeToIntrinsics2;
        this.alignment = alignment2;
        this.contentScale = contentScale2;
        this.alpha = alpha2;
        this.colorFilter = colorFilter2;
    }

    public boolean getAutoInvalidate() {
        return false;
    }

    public PainterModifierNode create() {
        return new PainterModifierNode(this.painter, this.sizeToIntrinsics, this.alignment, this.contentScale, this.alpha, this.colorFilter);
    }

    public PainterModifierNode update(PainterModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        boolean sizeToIntrinsics2 = node.getSizeToIntrinsics();
        boolean z = this.sizeToIntrinsics;
        boolean intrinsicsChanged = sizeToIntrinsics2 != z || (z && !Size.m2980equalsimpl0(node.getPainter().m3867getIntrinsicSizeNHjbRc(), this.painter.m3867getIntrinsicSizeNHjbRc()));
        node.setPainter(this.painter);
        node.setSizeToIntrinsics(this.sizeToIntrinsics);
        node.setAlignment(this.alignment);
        node.setContentScale(this.contentScale);
        node.setAlpha(this.alpha);
        node.setColorFilter(this.colorFilter);
        if (intrinsicsChanged) {
            LayoutModifierNodeKt.invalidateMeasurements(node);
        }
        DrawModifierNodeKt.invalidateDraw(node);
        return node;
    }

    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
        $this$inspectableProperties.setName("paint");
        $this$inspectableProperties.getProperties().set("painter", this.painter);
        $this$inspectableProperties.getProperties().set("sizeToIntrinsics", Boolean.valueOf(this.sizeToIntrinsics));
        $this$inspectableProperties.getProperties().set("alignment", this.alignment);
        $this$inspectableProperties.getProperties().set("contentScale", this.contentScale);
        $this$inspectableProperties.getProperties().set("alpha", Float.valueOf(this.alpha));
        $this$inspectableProperties.getProperties().set("colorFilter", this.colorFilter);
    }
}
