package androidx.compose.ui.graphics;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\t\u00105\u001a\u00020\u0004HÆ\u0003J\t\u00106\u001a\u00020\u0004HÆ\u0003J\u0019\u00107\u001a\u00020\u000fHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u0010\u001fJ\t\u00109\u001a\u00020\u0011HÆ\u0003J\t\u0010:\u001a\u00020\u0013HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0019\u0010<\u001a\u00020\u0017HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010\u001fJ\u0019\u0010>\u001a\u00020\u0017HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010\u001fJ\u0019\u0010@\u001a\u00020\u001aHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010%J\t\u0010B\u001a\u00020\u0004HÆ\u0003J\t\u0010C\u001a\u00020\u0004HÆ\u0003J\t\u0010D\u001a\u00020\u0004HÆ\u0003J\t\u0010E\u001a\u00020\u0004HÆ\u0003J\t\u0010F\u001a\u00020\u0004HÆ\u0003J\t\u0010G\u001a\u00020\u0004HÆ\u0003J\t\u0010H\u001a\u00020\u0004HÆ\u0003J\t\u0010I\u001a\u00020\u0004HÆ\u0003JÂ\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u001aHÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\b\u0010M\u001a\u00020\u0002H\u0016J\u0013\u0010N\u001a\u00020\u00132\b\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020RHÖ\u0001J\t\u0010S\u001a\u00020THÖ\u0001J\u0010\u0010U\u001a\u00020\u00022\u0006\u0010V\u001a\u00020\u0002H\u0016J\f\u0010W\u001a\u00020X*\u00020YH\u0016R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001c\u0010\u0019\u001a\u00020\u001aø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001c\u0010\u0018\u001a\u00020\u0017ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010 \u001a\u0004\b1\u0010\u001fR\u001c\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010 \u001a\u0004\b2\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001d\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, d2 = {"Landroidx/compose/ui/graphics/GraphicsLayerModifierNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/graphics/SimpleGraphicsLayerModifier;", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlpha", "()F", "getAmbientShadowColor-0d7_KjU", "()J", "J", "getCameraDistance", "getClip", "()Z", "getCompositingStrategy--NrFUSI", "()I", "I", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "getRotationX", "getRotationY", "getRotationZ", "getScaleX", "getScaleY", "getShadowElevation", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getSpotShadowColor-0d7_KjU", "getTransformOrigin-SzJe1aQ", "getTranslationX", "getTranslationY", "component1", "component10", "component11", "component11-SzJe1aQ", "component12", "component13", "component14", "component15", "component15-0d7_KjU", "component16", "component16-0d7_KjU", "component17", "component17--NrFUSI", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copy-JVvOYNQ", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJI)Landroidx/compose/ui/graphics/GraphicsLayerModifierNodeElement;", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GraphicsLayerModifier.kt */
final class GraphicsLayerModifierNodeElement extends ModifierNodeElement<SimpleGraphicsLayerModifier> {
    private final float alpha;
    private final long ambientShadowColor;
    private final float cameraDistance;
    private final boolean clip;
    private final int compositingStrategy;
    private final RenderEffect renderEffect;
    private final float rotationX;
    private final float rotationY;
    private final float rotationZ;
    private final float scaleX;
    private final float scaleY;
    private final float shadowElevation;
    private final Shape shape;
    private final long spotShadowColor;
    private final long transformOrigin;
    private final float translationX;
    private final float translationY;

    public /* synthetic */ GraphicsLayerModifierNodeElement(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape2, boolean z, RenderEffect renderEffect2, long j2, long j3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, j, shape2, z, renderEffect2, j2, j3, i);
    }

    /* renamed from: copy-JVvOYNQ$default  reason: not valid java name */
    public static /* synthetic */ GraphicsLayerModifierNodeElement m3315copyJVvOYNQ$default(GraphicsLayerModifierNodeElement graphicsLayerModifierNodeElement, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape2, boolean z, RenderEffect renderEffect2, long j2, long j3, int i, int i2, Object obj) {
        GraphicsLayerModifierNodeElement graphicsLayerModifierNodeElement2 = graphicsLayerModifierNodeElement;
        int i3 = i2;
        return graphicsLayerModifierNodeElement.m3320copyJVvOYNQ((i3 & 1) != 0 ? graphicsLayerModifierNodeElement2.scaleX : f, (i3 & 2) != 0 ? graphicsLayerModifierNodeElement2.scaleY : f2, (i3 & 4) != 0 ? graphicsLayerModifierNodeElement2.alpha : f3, (i3 & 8) != 0 ? graphicsLayerModifierNodeElement2.translationX : f4, (i3 & 16) != 0 ? graphicsLayerModifierNodeElement2.translationY : f5, (i3 & 32) != 0 ? graphicsLayerModifierNodeElement2.shadowElevation : f6, (i3 & 64) != 0 ? graphicsLayerModifierNodeElement2.rotationX : f7, (i3 & 128) != 0 ? graphicsLayerModifierNodeElement2.rotationY : f8, (i3 & 256) != 0 ? graphicsLayerModifierNodeElement2.rotationZ : f9, (i3 & 512) != 0 ? graphicsLayerModifierNodeElement2.cameraDistance : f10, (i3 & 1024) != 0 ? graphicsLayerModifierNodeElement2.transformOrigin : j, (i3 & 2048) != 0 ? graphicsLayerModifierNodeElement2.shape : shape2, (i3 & 4096) != 0 ? graphicsLayerModifierNodeElement2.clip : z, (i3 & 8192) != 0 ? graphicsLayerModifierNodeElement2.renderEffect : renderEffect2, (i3 & 16384) != 0 ? graphicsLayerModifierNodeElement2.ambientShadowColor : j2, (i3 & 32768) != 0 ? graphicsLayerModifierNodeElement2.spotShadowColor : j3, (i3 & 65536) != 0 ? graphicsLayerModifierNodeElement2.compositingStrategy : i);
    }

    public final float component1() {
        return this.scaleX;
    }

    public final float component10() {
        return this.cameraDistance;
    }

    /* renamed from: component11-SzJe1aQ  reason: not valid java name */
    public final long m3316component11SzJe1aQ() {
        return this.transformOrigin;
    }

    public final Shape component12() {
        return this.shape;
    }

    public final boolean component13() {
        return this.clip;
    }

    public final RenderEffect component14() {
        return this.renderEffect;
    }

    /* renamed from: component15-0d7_KjU  reason: not valid java name */
    public final long m3317component150d7_KjU() {
        return this.ambientShadowColor;
    }

    /* renamed from: component16-0d7_KjU  reason: not valid java name */
    public final long m3318component160d7_KjU() {
        return this.spotShadowColor;
    }

    /* renamed from: component17--NrFUSI  reason: not valid java name */
    public final int m3319component17NrFUSI() {
        return this.compositingStrategy;
    }

    public final float component2() {
        return this.scaleY;
    }

    public final float component3() {
        return this.alpha;
    }

    public final float component4() {
        return this.translationX;
    }

    public final float component5() {
        return this.translationY;
    }

    public final float component6() {
        return this.shadowElevation;
    }

    public final float component7() {
        return this.rotationX;
    }

    public final float component8() {
        return this.rotationY;
    }

    public final float component9() {
        return this.rotationZ;
    }

    /* renamed from: copy-JVvOYNQ  reason: not valid java name */
    public final GraphicsLayerModifierNodeElement m3320copyJVvOYNQ(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape2, boolean z, RenderEffect renderEffect2, long j2, long j3, int i) {
        Intrinsics.checkNotNullParameter(shape2, "shape");
        return new GraphicsLayerModifierNodeElement(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, j, shape2, z, renderEffect2, j2, j3, i, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GraphicsLayerModifierNodeElement)) {
            return false;
        }
        GraphicsLayerModifierNodeElement graphicsLayerModifierNodeElement = (GraphicsLayerModifierNodeElement) obj;
        return Float.compare(this.scaleX, graphicsLayerModifierNodeElement.scaleX) == 0 && Float.compare(this.scaleY, graphicsLayerModifierNodeElement.scaleY) == 0 && Float.compare(this.alpha, graphicsLayerModifierNodeElement.alpha) == 0 && Float.compare(this.translationX, graphicsLayerModifierNodeElement.translationX) == 0 && Float.compare(this.translationY, graphicsLayerModifierNodeElement.translationY) == 0 && Float.compare(this.shadowElevation, graphicsLayerModifierNodeElement.shadowElevation) == 0 && Float.compare(this.rotationX, graphicsLayerModifierNodeElement.rotationX) == 0 && Float.compare(this.rotationY, graphicsLayerModifierNodeElement.rotationY) == 0 && Float.compare(this.rotationZ, graphicsLayerModifierNodeElement.rotationZ) == 0 && Float.compare(this.cameraDistance, graphicsLayerModifierNodeElement.cameraDistance) == 0 && TransformOrigin.m3580equalsimpl0(this.transformOrigin, graphicsLayerModifierNodeElement.transformOrigin) && Intrinsics.areEqual((Object) this.shape, (Object) graphicsLayerModifierNodeElement.shape) && this.clip == graphicsLayerModifierNodeElement.clip && Intrinsics.areEqual((Object) this.renderEffect, (Object) graphicsLayerModifierNodeElement.renderEffect) && Color.m3165equalsimpl0(this.ambientShadowColor, graphicsLayerModifierNodeElement.ambientShadowColor) && Color.m3165equalsimpl0(this.spotShadowColor, graphicsLayerModifierNodeElement.spotShadowColor) && CompositingStrategy.m3244equalsimpl0(this.compositingStrategy, graphicsLayerModifierNodeElement.compositingStrategy);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((Float.hashCode(this.scaleX) * 31) + Float.hashCode(this.scaleY)) * 31) + Float.hashCode(this.alpha)) * 31) + Float.hashCode(this.translationX)) * 31) + Float.hashCode(this.translationY)) * 31) + Float.hashCode(this.shadowElevation)) * 31) + Float.hashCode(this.rotationX)) * 31) + Float.hashCode(this.rotationY)) * 31) + Float.hashCode(this.rotationZ)) * 31) + Float.hashCode(this.cameraDistance)) * 31) + TransformOrigin.m3583hashCodeimpl(this.transformOrigin)) * 31) + this.shape.hashCode()) * 31;
        boolean z = this.clip;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        RenderEffect renderEffect2 = this.renderEffect;
        return ((((((i + (renderEffect2 == null ? 0 : renderEffect2.hashCode())) * 31) + Color.m3171hashCodeimpl(this.ambientShadowColor)) * 31) + Color.m3171hashCodeimpl(this.spotShadowColor)) * 31) + CompositingStrategy.m3245hashCodeimpl(this.compositingStrategy);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GraphicsLayerModifierNodeElement(scaleX=").append(this.scaleX).append(", scaleY=").append(this.scaleY).append(", alpha=").append(this.alpha).append(", translationX=").append(this.translationX).append(", translationY=").append(this.translationY).append(", shadowElevation=").append(this.shadowElevation).append(", rotationX=").append(this.rotationX).append(", rotationY=").append(this.rotationY).append(", rotationZ=").append(this.rotationZ).append(", cameraDistance=").append(this.cameraDistance).append(", transformOrigin=").append(TransformOrigin.m3584toStringimpl(this.transformOrigin)).append(", shape=");
        sb.append(this.shape).append(", clip=").append(this.clip).append(", renderEffect=").append(this.renderEffect).append(", ambientShadowColor=").append(Color.m3172toStringimpl(this.ambientShadowColor)).append(", spotShadowColor=").append(Color.m3172toStringimpl(this.spotShadowColor)).append(", compositingStrategy=").append(CompositingStrategy.m3246toStringimpl(this.compositingStrategy)).append(')');
        return sb.toString();
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public final float getShadowElevation() {
        return this.shadowElevation;
    }

    public final float getRotationX() {
        return this.rotationX;
    }

    public final float getRotationY() {
        return this.rotationY;
    }

    public final float getRotationZ() {
        return this.rotationZ;
    }

    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    /* renamed from: getTransformOrigin-SzJe1aQ  reason: not valid java name */
    public final long m3324getTransformOriginSzJe1aQ() {
        return this.transformOrigin;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final boolean getClip() {
        return this.clip;
    }

    public final RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    /* renamed from: getAmbientShadowColor-0d7_KjU  reason: not valid java name */
    public final long m3321getAmbientShadowColor0d7_KjU() {
        return this.ambientShadowColor;
    }

    /* renamed from: getSpotShadowColor-0d7_KjU  reason: not valid java name */
    public final long m3323getSpotShadowColor0d7_KjU() {
        return this.spotShadowColor;
    }

    /* renamed from: getCompositingStrategy--NrFUSI  reason: not valid java name */
    public final int m3322getCompositingStrategyNrFUSI() {
        return this.compositingStrategy;
    }

    private GraphicsLayerModifierNodeElement(float scaleX2, float scaleY2, float alpha2, float translationX2, float translationY2, float shadowElevation2, float rotationX2, float rotationY2, float rotationZ2, float cameraDistance2, long transformOrigin2, Shape shape2, boolean clip2, RenderEffect renderEffect2, long ambientShadowColor2, long spotShadowColor2, int compositingStrategy2) {
        this.scaleX = scaleX2;
        this.scaleY = scaleY2;
        this.alpha = alpha2;
        this.translationX = translationX2;
        this.translationY = translationY2;
        this.shadowElevation = shadowElevation2;
        this.rotationX = rotationX2;
        this.rotationY = rotationY2;
        this.rotationZ = rotationZ2;
        this.cameraDistance = cameraDistance2;
        this.transformOrigin = transformOrigin2;
        this.shape = shape2;
        this.clip = clip2;
        this.renderEffect = renderEffect2;
        this.ambientShadowColor = ambientShadowColor2;
        this.spotShadowColor = spotShadowColor2;
        this.compositingStrategy = compositingStrategy2;
    }

    public SimpleGraphicsLayerModifier create() {
        return new SimpleGraphicsLayerModifier(this.scaleX, this.scaleY, this.alpha, this.translationX, this.translationY, this.shadowElevation, this.rotationX, this.rotationY, this.rotationZ, this.cameraDistance, this.transformOrigin, this.shape, this.clip, this.renderEffect, this.ambientShadowColor, this.spotShadowColor, this.compositingStrategy, (DefaultConstructorMarker) null);
    }

    public SimpleGraphicsLayerModifier update(SimpleGraphicsLayerModifier node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.setScaleX(this.scaleX);
        node.setScaleY(this.scaleY);
        node.setAlpha(this.alpha);
        node.setTranslationX(this.translationX);
        node.setTranslationY(this.translationY);
        node.setShadowElevation(this.shadowElevation);
        node.setRotationX(this.rotationX);
        node.setRotationY(this.rotationY);
        node.setRotationZ(this.rotationZ);
        node.setCameraDistance(this.cameraDistance);
        node.m3527setTransformOrigin__ExYCQ(this.transformOrigin);
        node.setShape(this.shape);
        node.setClip(this.clip);
        node.setRenderEffect(this.renderEffect);
        node.m3524setAmbientShadowColor8_81llA(this.ambientShadowColor);
        node.m3526setSpotShadowColor8_81llA(this.spotShadowColor);
        node.m3525setCompositingStrategyaDBOjCE(this.compositingStrategy);
        node.invalidateLayerBlock();
        return node;
    }

    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
        $this$inspectableProperties.setName("graphicsLayer");
        $this$inspectableProperties.getProperties().set("scaleX", Float.valueOf(this.scaleX));
        $this$inspectableProperties.getProperties().set("scaleY", Float.valueOf(this.scaleY));
        $this$inspectableProperties.getProperties().set("alpha", Float.valueOf(this.alpha));
        $this$inspectableProperties.getProperties().set("translationX", Float.valueOf(this.translationX));
        $this$inspectableProperties.getProperties().set("translationY", Float.valueOf(this.translationY));
        $this$inspectableProperties.getProperties().set("shadowElevation", Float.valueOf(this.shadowElevation));
        $this$inspectableProperties.getProperties().set("rotationX", Float.valueOf(this.rotationX));
        $this$inspectableProperties.getProperties().set("rotationY", Float.valueOf(this.rotationY));
        $this$inspectableProperties.getProperties().set("rotationZ", Float.valueOf(this.rotationZ));
        $this$inspectableProperties.getProperties().set("cameraDistance", Float.valueOf(this.cameraDistance));
        $this$inspectableProperties.getProperties().set("transformOrigin", TransformOrigin.m3573boximpl(this.transformOrigin));
        $this$inspectableProperties.getProperties().set("shape", this.shape);
        $this$inspectableProperties.getProperties().set("clip", Boolean.valueOf(this.clip));
        $this$inspectableProperties.getProperties().set("renderEffect", this.renderEffect);
        $this$inspectableProperties.getProperties().set("ambientShadowColor", Color.m3154boximpl(this.ambientShadowColor));
        $this$inspectableProperties.getProperties().set("spotShadowColor", Color.m3154boximpl(this.spotShadowColor));
        $this$inspectableProperties.getProperties().set("compositingStrategy", CompositingStrategy.m3241boximpl(this.compositingStrategy));
    }
}
