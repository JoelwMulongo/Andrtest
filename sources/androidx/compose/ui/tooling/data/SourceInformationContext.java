package androidx.compose.ui.tooling.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0002\u0010\u0010J\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0011R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006!"}, d2 = {"Landroidx/compose/ui/tooling/data/SourceInformationContext;", "", "name", "", "sourceFile", "packageHash", "", "locations", "", "Landroidx/compose/ui/tooling/data/SourceLocationInfo;", "repeatOffset", "parameters", "Landroidx/compose/ui/tooling/data/Parameter;", "isCall", "", "isInline", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ILjava/util/List;ZZ)V", "()Z", "getLocations", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "nextLocation", "getPackageHash", "()I", "getParameters", "getRepeatOffset", "getSourceFile", "nextSourceLocation", "Landroidx/compose/ui/tooling/data/SourceLocation;", "sourceLocation", "callIndex", "parentContext", "ui-tooling-data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SlotTree.kt */
final class SourceInformationContext {
    private final boolean isCall;
    private final boolean isInline;
    private final List<SourceLocationInfo> locations;
    private final String name;
    private int nextLocation;
    private final int packageHash;
    private final List<Parameter> parameters;
    private final int repeatOffset;
    private final String sourceFile;

    public SourceInformationContext(String name2, String sourceFile2, int packageHash2, List<SourceLocationInfo> locations2, int repeatOffset2, List<Parameter> parameters2, boolean isCall2, boolean isInline2) {
        Intrinsics.checkNotNullParameter(locations2, "locations");
        this.name = name2;
        this.sourceFile = sourceFile2;
        this.packageHash = packageHash2;
        this.locations = locations2;
        this.repeatOffset = repeatOffset2;
        this.parameters = parameters2;
        this.isCall = isCall2;
        this.isInline = isInline2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSourceFile() {
        return this.sourceFile;
    }

    public final int getPackageHash() {
        return this.packageHash;
    }

    public final List<SourceLocationInfo> getLocations() {
        return this.locations;
    }

    public final int getRepeatOffset() {
        return this.repeatOffset;
    }

    public final List<Parameter> getParameters() {
        return this.parameters;
    }

    public final boolean isCall() {
        return this.isCall;
    }

    public final boolean isInline() {
        return this.isInline;
    }

    public final SourceLocation nextSourceLocation() {
        int i;
        if (this.nextLocation >= this.locations.size() && (i = this.repeatOffset) >= 0) {
            this.nextLocation = i;
        }
        if (this.nextLocation >= this.locations.size()) {
            return null;
        }
        List<SourceLocationInfo> list = this.locations;
        int i2 = this.nextLocation;
        this.nextLocation = i2 + 1;
        SourceLocationInfo location = list.get(i2);
        Integer lineNumber = location.getLineNumber();
        int intValue = lineNumber != null ? lineNumber.intValue() : -1;
        Integer offset = location.getOffset();
        int intValue2 = offset != null ? offset.intValue() : -1;
        Integer length = location.getLength();
        return new SourceLocation(intValue, intValue2, length != null ? length.intValue() : -1, this.sourceFile, this.packageHash);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.tooling.data.SourceLocation sourceLocation(int r11, androidx.compose.ui.tooling.data.SourceInformationContext r12) {
        /*
            r10 = this;
            r0 = r11
            java.util.List<androidx.compose.ui.tooling.data.SourceLocationInfo> r1 = r10.locations
            int r1 = r1.size()
            if (r0 < r1) goto L_0x0025
            int r1 = r10.repeatOffset
            if (r1 < 0) goto L_0x0025
            java.util.List<androidx.compose.ui.tooling.data.SourceLocationInfo> r2 = r10.locations
            int r2 = r2.size()
            if (r1 >= r2) goto L_0x0025
            int r1 = r10.repeatOffset
            int r1 = r11 - r1
            java.util.List<androidx.compose.ui.tooling.data.SourceLocationInfo> r2 = r10.locations
            int r2 = r2.size()
            int r3 = r10.repeatOffset
            int r2 = r2 - r3
            int r1 = r1 % r2
            int r1 = r1 + r3
            r0 = r1
        L_0x0025:
            java.util.List<androidx.compose.ui.tooling.data.SourceLocationInfo> r1 = r10.locations
            int r1 = r1.size()
            r2 = 0
            if (r0 >= r1) goto L_0x008b
            java.util.List<androidx.compose.ui.tooling.data.SourceLocationInfo> r1 = r10.locations
            java.lang.Object r1 = r1.get(r0)
            androidx.compose.ui.tooling.data.SourceLocationInfo r1 = (androidx.compose.ui.tooling.data.SourceLocationInfo) r1
            androidx.compose.ui.tooling.data.SourceLocation r9 = new androidx.compose.ui.tooling.data.SourceLocation
            java.lang.Integer r3 = r1.getLineNumber()
            r4 = -1
            if (r3 == 0) goto L_0x0045
            int r3 = r3.intValue()
            r5 = r3
            goto L_0x0046
        L_0x0045:
            r5 = r4
        L_0x0046:
            java.lang.Integer r3 = r1.getOffset()
            if (r3 == 0) goto L_0x0052
            int r3 = r3.intValue()
            r6 = r3
            goto L_0x0053
        L_0x0052:
            r6 = r4
        L_0x0053:
            java.lang.Integer r3 = r1.getLength()
            if (r3 == 0) goto L_0x005f
            int r3 = r3.intValue()
            r7 = r3
            goto L_0x0060
        L_0x005f:
            r7 = r4
        L_0x0060:
            java.lang.String r3 = r10.sourceFile
            if (r3 != 0) goto L_0x006b
            if (r12 == 0) goto L_0x0069
            java.lang.String r8 = r12.sourceFile
            goto L_0x006c
        L_0x0069:
            r8 = r2
            goto L_0x006c
        L_0x006b:
            r8 = r3
        L_0x006c:
            if (r3 != 0) goto L_0x0073
            if (r12 == 0) goto L_0x0079
            int r2 = r12.packageHash
            goto L_0x0075
        L_0x0073:
            int r2 = r10.packageHash
        L_0x0075:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x0079:
            if (r2 == 0) goto L_0x0080
            int r2 = r2.intValue()
            goto L_0x0081
        L_0x0080:
            r2 = r4
        L_0x0081:
            r3 = r9
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r2
            r3.<init>(r4, r5, r6, r7, r8)
            return r9
        L_0x008b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.data.SourceInformationContext.sourceLocation(int, androidx.compose.ui.tooling.data.SourceInformationContext):androidx.compose.ui.tooling.data.SourceLocation");
    }
}
