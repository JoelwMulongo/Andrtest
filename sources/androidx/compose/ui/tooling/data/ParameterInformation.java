package androidx.compose.ui.tooling.data;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003JS\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Landroidx/compose/ui/tooling/data/ParameterInformation;", "", "name", "", "value", "fromDefault", "", "static", "compared", "inlineClass", "stable", "(Ljava/lang/String;Ljava/lang/Object;ZZZLjava/lang/String;Z)V", "getCompared", "()Z", "getFromDefault", "getInlineClass", "()Ljava/lang/String;", "getName", "getStable", "getStatic", "getValue", "()Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "ui-tooling-data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SlotTree.kt */
public final class ParameterInformation {
    public static final int $stable = 8;
    private final boolean compared;
    private final boolean fromDefault;
    private final String inlineClass;
    private final String name;
    private final boolean stable;

    /* renamed from: static  reason: not valid java name */
    private final boolean f64static;
    private final Object value;

    public static /* synthetic */ ParameterInformation copy$default(ParameterInformation parameterInformation, String str, Object obj, boolean z, boolean z2, boolean z3, String str2, boolean z4, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = parameterInformation.name;
        }
        if ((i & 2) != 0) {
            obj = parameterInformation.value;
        }
        Object obj3 = obj;
        if ((i & 4) != 0) {
            z = parameterInformation.fromDefault;
        }
        boolean z5 = z;
        if ((i & 8) != 0) {
            z2 = parameterInformation.f64static;
        }
        boolean z6 = z2;
        if ((i & 16) != 0) {
            z3 = parameterInformation.compared;
        }
        boolean z7 = z3;
        if ((i & 32) != 0) {
            str2 = parameterInformation.inlineClass;
        }
        String str3 = str2;
        if ((i & 64) != 0) {
            z4 = parameterInformation.stable;
        }
        return parameterInformation.copy(str, obj3, z5, z6, z7, str3, z4);
    }

    public final String component1() {
        return this.name;
    }

    public final Object component2() {
        return this.value;
    }

    public final boolean component3() {
        return this.fromDefault;
    }

    public final boolean component4() {
        return this.f64static;
    }

    public final boolean component5() {
        return this.compared;
    }

    public final String component6() {
        return this.inlineClass;
    }

    public final boolean component7() {
        return this.stable;
    }

    public final ParameterInformation copy(String str, Object obj, boolean z, boolean z2, boolean z3, String str2, boolean z4) {
        String str3 = str;
        Intrinsics.checkNotNullParameter(str, HintConstants.AUTOFILL_HINT_NAME);
        return new ParameterInformation(str, obj, z, z2, z3, str2, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParameterInformation)) {
            return false;
        }
        ParameterInformation parameterInformation = (ParameterInformation) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) parameterInformation.name) && Intrinsics.areEqual(this.value, parameterInformation.value) && this.fromDefault == parameterInformation.fromDefault && this.f64static == parameterInformation.f64static && this.compared == parameterInformation.compared && Intrinsics.areEqual((Object) this.inlineClass, (Object) parameterInformation.inlineClass) && this.stable == parameterInformation.stable;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        Object obj = this.value;
        int i = 0;
        int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        boolean z = this.fromDefault;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
        boolean z3 = this.f64static;
        if (z3) {
            z3 = true;
        }
        int i3 = (i2 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.compared;
        if (z4) {
            z4 = true;
        }
        int i4 = (i3 + (z4 ? 1 : 0)) * 31;
        String str = this.inlineClass;
        if (str != null) {
            i = str.hashCode();
        }
        int i5 = (i4 + i) * 31;
        boolean z5 = this.stable;
        if (!z5) {
            z2 = z5;
        }
        return i5 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "ParameterInformation(name=" + this.name + ", value=" + this.value + ", fromDefault=" + this.fromDefault + ", static=" + this.f64static + ", compared=" + this.compared + ", inlineClass=" + this.inlineClass + ", stable=" + this.stable + ')';
    }

    public ParameterInformation(String name2, Object value2, boolean fromDefault2, boolean z, boolean compared2, String inlineClass2, boolean stable2) {
        Intrinsics.checkNotNullParameter(name2, HintConstants.AUTOFILL_HINT_NAME);
        this.name = name2;
        this.value = value2;
        this.fromDefault = fromDefault2;
        this.f64static = z;
        this.compared = compared2;
        this.inlineClass = inlineClass2;
        this.stable = stable2;
    }

    public final String getName() {
        return this.name;
    }

    public final Object getValue() {
        return this.value;
    }

    public final boolean getFromDefault() {
        return this.fromDefault;
    }

    public final boolean getStatic() {
        return this.f64static;
    }

    public final boolean getCompared() {
        return this.compared;
    }

    public final String getInlineClass() {
        return this.inlineClass;
    }

    public final boolean getStable() {
        return this.stable;
    }
}
