package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b&\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010C\u001a\u00020\u00132\u0006\u0010D\u001a\u00020#2\u0006\u0010E\u001a\u00020\u0001J\u001e\u0010F\u001a\u00020\u00132\u0006\u0010G\u001a\u00020#2\u0006\u0010H\u001a\u00020#2\u0006\u0010I\u001a\u00020#J\u0016\u0010J\u001a\u00020\u00132\u0006\u0010D\u001a\u00020#2\u0006\u0010I\u001a\u00020#J\b\u0010K\u001a\u00020\u001cH\u0016J\b\u0010L\u001a\u00020\u0013H\u0002J\b\u0010M\u001a\u00020\u0013H\u0002J\f\u0010N\u001a\u00020\u0013*\u00020OH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R0\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R4\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012@PX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u001c@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R$\u0010)\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R$\u00101\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R$\u00104\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010+\"\u0004\b6\u0010-R$\u00107\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010+\"\u0004\b9\u0010-R$\u0010:\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010+\"\u0004\b<\u0010-R$\u0010=\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010+\"\u0004\b?\u0010-R\u0014\u0010@\u001a\u00020\u001a8BX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010B\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006P"}, d2 = {"Landroidx/compose/ui/graphics/vector/GroupComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "()V", "children", "", "clipPath", "Landroidx/compose/ui/graphics/Path;", "value", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "clipPathData", "getClipPathData", "()Ljava/util/List;", "setClipPathData", "(Ljava/util/List;)V", "groupMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "Lkotlin/Function0;", "", "invalidateListener", "getInvalidateListener$ui_release", "()Lkotlin/jvm/functions/Function0;", "setInvalidateListener$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "isClipPathDirty", "", "isMatrixDirty", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "numChildren", "", "getNumChildren", "()I", "parser", "Landroidx/compose/ui/graphics/vector/PathParser;", "", "pivotX", "getPivotX", "()F", "setPivotX", "(F)V", "pivotY", "getPivotY", "setPivotY", "rotation", "getRotation", "setRotation", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "willClipPath", "getWillClipPath", "()Z", "insertAt", "index", "instance", "move", "from", "to", "count", "remove", "toString", "updateClipPath", "updateMatrix", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Vector.kt */
public final class GroupComponent extends VNode {
    private final List<VNode> children = new ArrayList();
    private Path clipPath;
    private List<? extends PathNode> clipPathData = VectorKt.getEmptyPath();
    private float[] groupMatrix;
    private Function0<Unit> invalidateListener;
    private boolean isClipPathDirty = true;
    private boolean isMatrixDirty = true;
    private String name = "";
    private PathParser parser;
    private float pivotX;
    private float pivotY;
    private float rotation;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float translationX;
    private float translationY;

    public GroupComponent() {
        super((DefaultConstructorMarker) null);
    }

    public final List<PathNode> getClipPathData() {
        return this.clipPathData;
    }

    public final void setClipPathData(List<? extends PathNode> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.clipPathData = value;
        this.isClipPathDirty = true;
        invalidate();
    }

    private final boolean getWillClipPath() {
        return !this.clipPathData.isEmpty();
    }

    public Function0<Unit> getInvalidateListener$ui_release() {
        return this.invalidateListener;
    }

    public void setInvalidateListener$ui_release(Function0<Unit> value) {
        this.invalidateListener = value;
        List $this$fastForEach$iv = this.children;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            $this$fastForEach$iv.get(index$iv).setInvalidateListener$ui_release(value);
        }
    }

    private final void updateClipPath() {
        if (getWillClipPath()) {
            PathParser targetParser = this.parser;
            if (targetParser == null) {
                targetParser = new PathParser();
                this.parser = targetParser;
            } else {
                targetParser.clear();
            }
            Path targetClip = this.clipPath;
            if (targetClip == null) {
                targetClip = AndroidPath_androidKt.Path();
                this.clipPath = targetClip;
            } else {
                targetClip.reset();
            }
            targetParser.addPathNodes(this.clipPathData).toPath(targetClip);
        }
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.name = value;
        invalidate();
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final void setRotation(float value) {
        this.rotation = value;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final float getPivotX() {
        return this.pivotX;
    }

    public final void setPivotX(float value) {
        this.pivotX = value;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final float getPivotY() {
        return this.pivotY;
    }

    public final void setPivotY(float value) {
        this.pivotY = value;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final void setScaleX(float value) {
        this.scaleX = value;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final void setScaleY(float value) {
        this.scaleY = value;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final void setTranslationX(float value) {
        this.translationX = value;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public final void setTranslationY(float value) {
        this.translationY = value;
        this.isMatrixDirty = true;
        invalidate();
    }

    private final void updateMatrix() {
        float[] matrix;
        float[] target = this.groupMatrix;
        if (target == null) {
            matrix = Matrix.m3391constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
            this.groupMatrix = matrix;
        } else {
            matrix = target;
            Matrix.m3400resetimpl(matrix);
        }
        Matrix.m3411translateimpl$default(matrix, this.pivotX + this.translationX, this.pivotY + this.translationY, 0.0f, 4, (Object) null);
        Matrix.m3403rotateZimpl(matrix, this.rotation);
        Matrix.m3404scaleimpl(matrix, this.scaleX, this.scaleY, 1.0f);
        Matrix.m3411translateimpl$default(matrix, -this.pivotX, -this.pivotY, 0.0f, 4, (Object) null);
    }

    public final void insertAt(int index, VNode instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (index < getNumChildren()) {
            this.children.set(index, instance);
        } else {
            this.children.add(instance);
        }
        instance.setInvalidateListener$ui_release(getInvalidateListener$ui_release());
        invalidate();
    }

    public final void move(int from, int to, int count) {
        int i = 0;
        if (from > to) {
            int current = to;
            while (i < count) {
                int i2 = i;
                this.children.remove(from);
                this.children.add(current, this.children.get(from));
                current++;
                i++;
            }
        } else {
            while (i < count) {
                int i3 = i;
                this.children.remove(from);
                this.children.add(to - 1, this.children.get(from));
                i++;
            }
        }
        invalidate();
    }

    public final void remove(int index, int count) {
        for (int i = 0; i < count; i++) {
            int i2 = i;
            if (index < this.children.size()) {
                this.children.get(index).setInvalidateListener$ui_release((Function0<Unit>) null);
                this.children.remove(index);
            }
        }
        invalidate();
    }

    public void draw(DrawScope $this$draw) {
        DrawScope drawScope = $this$draw;
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        if (this.isMatrixDirty) {
            updateMatrix();
            this.isMatrixDirty = false;
        }
        if (this.isClipPathDirty) {
            updateClipPath();
            this.isClipPathDirty = false;
        }
        DrawScope $this$withTransform$iv = $this$draw;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$draw_u24lambda_u245 = $this$withTransform_u24lambda_u246$iv.getTransform();
        float[] fArr = this.groupMatrix;
        if (fArr != null) {
            $this$draw_u24lambda_u245.m3832transform58bKbWc((fArr != null ? Matrix.m3389boximpl(fArr) : null).m3412unboximpl());
        }
        Path targetClip = this.clipPath;
        if (getWillClipPath() && targetClip != null) {
            DrawTransform.m3822clipPathmtrdDE$default($this$draw_u24lambda_u245, targetClip, 0, 2, (Object) null);
        }
        DrawScope drawScope2 = $this$withTransform$iv;
        List $this$fastForEach$iv = this.children;
        int index$iv = 0;
        int size = $this$fastForEach$iv.size();
        while (index$iv < size) {
            $this$fastForEach$iv.get(index$iv).draw(drawScope);
            index$iv++;
        }
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.m3716setSizeuvyYCjk(previousSize$iv);
    }

    public final int getNumChildren() {
        return this.children.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder().append("VGroup: ").append(this.name);
        List $this$fastForEach$iv = this.children;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            sb.append("\t").append($this$fastForEach$iv.get(index$iv).toString()).append("\n");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
