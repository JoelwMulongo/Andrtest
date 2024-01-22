package androidx.compose.ui.autofill;

import android.util.Log;
import android.util.SparseArray;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.compose.ui.geometry.Rect;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0001¨\u0006\t"}, d2 = {"performAutofill", "", "Landroidx/compose/ui/autofill/AndroidAutofill;", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "populateViewStructure", "root", "Landroid/view/ViewStructure;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidAutofill.android.kt */
public final class AndroidAutofill_androidKt {
    public static final void populateViewStructure(AndroidAutofill $this$populateViewStructure, ViewStructure root) {
        ViewStructure viewStructure = root;
        Intrinsics.checkNotNullParameter($this$populateViewStructure, "<this>");
        Intrinsics.checkNotNullParameter(viewStructure, "root");
        int index = AutofillApi23Helper.INSTANCE.addChildCount(viewStructure, $this$populateViewStructure.getAutofillTree().getChildren().size());
        for (Map.Entry next : $this$populateViewStructure.getAutofillTree().getChildren().entrySet()) {
            int id = ((Number) next.getKey()).intValue();
            AutofillNode autofillNode = (AutofillNode) next.getValue();
            ViewStructure newChild = AutofillApi23Helper.INSTANCE.newChild(viewStructure, index);
            if (newChild != null) {
                ViewStructure child = newChild;
                AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.INSTANCE;
                AutofillId autofillId = AutofillApi26Helper.INSTANCE.getAutofillId(viewStructure);
                Intrinsics.checkNotNull(autofillId);
                autofillApi26Helper.setAutofillId(child, autofillId, id);
                AutofillApi23Helper.INSTANCE.setId(child, id, $this$populateViewStructure.getView().getContext().getPackageName(), (String) null, (String) null);
                AutofillApi26Helper.INSTANCE.setAutofillType(child, 1);
                AutofillApi26Helper autofillApi26Helper2 = AutofillApi26Helper.INSTANCE;
                List autofillTypes = autofillNode.getAutofillTypes();
                ArrayList target$iv = new ArrayList(autofillTypes.size());
                List $this$fastForEach$iv$iv = autofillTypes;
                int index$iv$iv = 0;
                int size = $this$fastForEach$iv$iv.size();
                while (index$iv$iv < size) {
                    target$iv.add(AndroidAutofillType_androidKt.getAndroidType((AutofillType) $this$fastForEach$iv$iv.get(index$iv$iv)));
                    index$iv$iv++;
                    AndroidAutofill androidAutofill = $this$populateViewStructure;
                    ViewStructure viewStructure2 = root;
                }
                autofillApi26Helper2.setAutofillHints(child, (String[]) target$iv.toArray(new String[0]));
                Rect boundingBox = autofillNode.getBoundingBox();
                if (boundingBox == null) {
                    Log.w("Autofill Warning", "Bounding box not set.\n                        Did you call perform autofillTree before the component was positioned? ");
                } else {
                    int left = MathKt.roundToInt(boundingBox.getLeft());
                    int top = MathKt.roundToInt(boundingBox.getTop());
                    AutofillApi23Helper.INSTANCE.setDimens(child, left, top, 0, 0, MathKt.roundToInt(boundingBox.getRight()) - left, MathKt.roundToInt(boundingBox.getBottom()) - top);
                }
            }
            index++;
            AndroidAutofill androidAutofill2 = $this$populateViewStructure;
            viewStructure = root;
        }
    }

    public static final void performAutofill(AndroidAutofill $this$performAutofill, SparseArray<AutofillValue> values) {
        Intrinsics.checkNotNullParameter($this$performAutofill, "<this>");
        Intrinsics.checkNotNullParameter(values, "values");
        int size = values.size();
        for (int index = 0; index < size; index++) {
            int itemId = values.keyAt(index);
            AutofillValue value = values.get(itemId);
            AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(value, "value");
            if (autofillApi26Helper.isText(value)) {
                $this$performAutofill.getAutofillTree().performAutofill(itemId, AutofillApi26Helper.INSTANCE.textValue(value).toString());
            } else if (AutofillApi26Helper.INSTANCE.isDate(value)) {
                throw new NotImplementedError("An operation is not implemented: " + "b/138604541: Add onFill() callback for date");
            } else if (AutofillApi26Helper.INSTANCE.isList(value)) {
                throw new NotImplementedError("An operation is not implemented: " + "b/138604541: Add onFill() callback for list");
            } else if (AutofillApi26Helper.INSTANCE.isToggle(value)) {
                throw new NotImplementedError("An operation is not implemented: " + "b/138604541:  Add onFill() callback for toggle");
            }
        }
    }
}
