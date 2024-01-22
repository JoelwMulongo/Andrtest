package androidx.compose.ui.graphics.vector.compat;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0014J\u001e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0014J\u001e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005J(\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0011J0\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\"\u001a\b\u0018\u00010#R\u00020$2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020\u0005J8\u0010%\u001a\u00020&2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\"\u001a\b\u0018\u00010#R\u00020$2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020\u00052\b\b\u0001\u0010\u001a\u001a\u00020\u0005J(\u0010'\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0014J(\u0010(\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005J\u0018\u0010)\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005J\t\u0010*\u001a\u00020\u0005HÖ\u0001J,\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020$2\f\u0010\"\u001a\b\u0018\u00010#R\u00020$2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J\t\u00101\u001a\u00020\u001eHÖ\u0001J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u00065"}, d2 = {"Landroidx/compose/ui/graphics/vector/compat/AndroidVectorParser;", "", "xmlParser", "Lorg/xmlpull/v1/XmlPullParser;", "config", "", "(Lorg/xmlpull/v1/XmlPullParser;I)V", "getConfig", "()I", "setConfig", "(I)V", "getXmlParser", "()Lorg/xmlpull/v1/XmlPullParser;", "component1", "component2", "copy", "equals", "", "other", "getDimension", "", "typedArray", "Landroid/content/res/TypedArray;", "index", "defValue", "getFloat", "defaultValue", "getInt", "getNamedBoolean", "attrName", "", "resId", "getNamedColorStateList", "Landroid/content/res/ColorStateList;", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "getNamedComplexColor", "Landroidx/core/content/res/ComplexColorCompat;", "getNamedFloat", "getNamedInt", "getString", "hashCode", "obtainAttributes", "res", "set", "Landroid/util/AttributeSet;", "attrs", "", "toString", "updateConfig", "", "resConfig", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: XmlVectorParser.android.kt */
public final class AndroidVectorParser {
    private int config;
    private final XmlPullParser xmlParser;

    public static /* synthetic */ AndroidVectorParser copy$default(AndroidVectorParser androidVectorParser, XmlPullParser xmlPullParser, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            xmlPullParser = androidVectorParser.xmlParser;
        }
        if ((i2 & 2) != 0) {
            i = androidVectorParser.config;
        }
        return androidVectorParser.copy(xmlPullParser, i);
    }

    public final XmlPullParser component1() {
        return this.xmlParser;
    }

    public final int component2() {
        return this.config;
    }

    public final AndroidVectorParser copy(XmlPullParser xmlPullParser, int i) {
        Intrinsics.checkNotNullParameter(xmlPullParser, "xmlParser");
        return new AndroidVectorParser(xmlPullParser, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidVectorParser)) {
            return false;
        }
        AndroidVectorParser androidVectorParser = (AndroidVectorParser) obj;
        return Intrinsics.areEqual((Object) this.xmlParser, (Object) androidVectorParser.xmlParser) && this.config == androidVectorParser.config;
    }

    public int hashCode() {
        return (this.xmlParser.hashCode() * 31) + Integer.hashCode(this.config);
    }

    public String toString() {
        return "AndroidVectorParser(xmlParser=" + this.xmlParser + ", config=" + this.config + ')';
    }

    public AndroidVectorParser(XmlPullParser xmlParser2, int config2) {
        Intrinsics.checkNotNullParameter(xmlParser2, "xmlParser");
        this.xmlParser = xmlParser2;
        this.config = config2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AndroidVectorParser(XmlPullParser xmlPullParser, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(xmlPullParser, (i2 & 2) != 0 ? 0 : i);
    }

    public final XmlPullParser getXmlParser() {
        return this.xmlParser;
    }

    public final int getConfig() {
        return this.config;
    }

    public final void setConfig(int i) {
        this.config = i;
    }

    private final void updateConfig(int resConfig) {
        this.config |= resConfig;
    }

    public final TypedArray obtainAttributes(Resources res, Resources.Theme theme, AttributeSet set, int[] attrs) {
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(set, "set");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        TypedArray typedArray = TypedArrayUtils.obtainAttributes(res, theme, set, attrs);
        Intrinsics.checkNotNullExpressionValue(typedArray, "obtainAttributes(\n      …          attrs\n        )");
        updateConfig(typedArray.getChangingConfigurations());
        return typedArray;
    }

    public final int getNamedInt(TypedArray typedArray, String attrName, int resId, int defaultValue) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        Intrinsics.checkNotNullParameter(attrName, "attrName");
        TypedArray $this$getNamedInt_u24lambda_u240 = typedArray;
        int result = TypedArrayUtils.getNamedInt($this$getNamedInt_u24lambda_u240, this.xmlParser, attrName, resId, defaultValue);
        updateConfig($this$getNamedInt_u24lambda_u240.getChangingConfigurations());
        return result;
    }

    public final float getNamedFloat(TypedArray typedArray, String attrName, int resId, float defaultValue) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        Intrinsics.checkNotNullParameter(attrName, "attrName");
        TypedArray $this$getNamedFloat_u24lambda_u241 = typedArray;
        float result = TypedArrayUtils.getNamedFloat($this$getNamedFloat_u24lambda_u241, this.xmlParser, attrName, resId, defaultValue);
        updateConfig($this$getNamedFloat_u24lambda_u241.getChangingConfigurations());
        return result;
    }

    public final boolean getNamedBoolean(TypedArray typedArray, String attrName, int resId, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        Intrinsics.checkNotNullParameter(attrName, "attrName");
        TypedArray $this$getNamedBoolean_u24lambda_u242 = typedArray;
        boolean result = TypedArrayUtils.getNamedBoolean($this$getNamedBoolean_u24lambda_u242, this.xmlParser, attrName, resId, defaultValue);
        updateConfig($this$getNamedBoolean_u24lambda_u242.getChangingConfigurations());
        return result;
    }

    public final float getFloat(TypedArray typedArray, int index, float defaultValue) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        TypedArray $this$getFloat_u24lambda_u243 = typedArray;
        float result = $this$getFloat_u24lambda_u243.getFloat(index, defaultValue);
        updateConfig($this$getFloat_u24lambda_u243.getChangingConfigurations());
        return result;
    }

    public final int getInt(TypedArray typedArray, int index, int defaultValue) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        TypedArray $this$getInt_u24lambda_u244 = typedArray;
        int result = $this$getInt_u24lambda_u244.getInt(index, defaultValue);
        updateConfig($this$getInt_u24lambda_u244.getChangingConfigurations());
        return result;
    }

    public final String getString(TypedArray typedArray, int index) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        TypedArray $this$getString_u24lambda_u245 = typedArray;
        String result = $this$getString_u24lambda_u245.getString(index);
        updateConfig($this$getString_u24lambda_u245.getChangingConfigurations());
        return result;
    }

    public final float getDimension(TypedArray typedArray, int index, float defValue) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        TypedArray $this$getDimension_u24lambda_u246 = typedArray;
        float result = $this$getDimension_u24lambda_u246.getDimension(index, defValue);
        updateConfig($this$getDimension_u24lambda_u246.getChangingConfigurations());
        return result;
    }

    public final ComplexColorCompat getNamedComplexColor(TypedArray typedArray, Resources.Theme theme, String attrName, int resId, int defaultValue) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        Intrinsics.checkNotNullParameter(attrName, "attrName");
        TypedArray $this$getNamedComplexColor_u24lambda_u247 = typedArray;
        ComplexColorCompat result = TypedArrayUtils.getNamedComplexColor($this$getNamedComplexColor_u24lambda_u247, this.xmlParser, theme, attrName, resId, defaultValue);
        updateConfig($this$getNamedComplexColor_u24lambda_u247.getChangingConfigurations());
        Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    public final ColorStateList getNamedColorStateList(TypedArray typedArray, Resources.Theme theme, String attrName, int resId) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        Intrinsics.checkNotNullParameter(attrName, "attrName");
        ColorStateList result = TypedArrayUtils.getNamedColorStateList(typedArray, this.xmlParser, theme, attrName, resId);
        updateConfig(typedArray.getChangingConfigurations());
        return result;
    }
}
