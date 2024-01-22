package androidx.compose.ui.platform;

import android.content.res.Configuration;
import androidx.compose.ui.text.input.PlatformTextInputService;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a5\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0014H\u0002\u001a!\u0010\u001b\u001a\u00020\u001c*\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\"0\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00018\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\"\u0018\u0010\n\u001a\u00020\u000b*\u00020\f8@X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"textInputServiceFactory", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputServiceFactory$annotations", "()V", "getTextInputServiceFactory", "()Lkotlin/jvm/functions/Function1;", "setTextInputServiceFactory", "(Lkotlin/jvm/functions/Function1;)V", "localeLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroid/content/res/Configuration;", "getLocaleLayoutDirection", "(Landroid/content/res/Configuration;)Landroidx/compose/ui/unit/LayoutDirection;", "dot", "", "m1", "Landroidx/compose/ui/graphics/Matrix;", "row", "", "m2", "column", "dot-p89u6pk", "([FI[FI)F", "layoutDirectionFromInt", "layoutDirection", "preTransform", "", "other", "preTransform-JiSxe2E", "([F[F)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
public final class AndroidComposeView_androidKt {
    private static Function1<? super PlatformTextInputService, ? extends TextInputService> textInputServiceFactory = AndroidComposeView_androidKt$textInputServiceFactory$1.INSTANCE;

    public static /* synthetic */ void getTextInputServiceFactory$annotations() {
    }

    public static final LayoutDirection getLocaleLayoutDirection(Configuration $this$localeLayoutDirection) {
        Intrinsics.checkNotNullParameter($this$localeLayoutDirection, "<this>");
        return layoutDirectionFromInt($this$localeLayoutDirection.getLayoutDirection());
    }

    /* access modifiers changed from: private */
    public static final LayoutDirection layoutDirectionFromInt(int layoutDirection) {
        switch (layoutDirection) {
            case 0:
                return LayoutDirection.Ltr;
            case 1:
                return LayoutDirection.Rtl;
            default:
                return LayoutDirection.Ltr;
        }
    }

    public static final Function1<PlatformTextInputService, TextInputService> getTextInputServiceFactory() {
        return textInputServiceFactory;
    }

    public static final void setTextInputServiceFactory(Function1<? super PlatformTextInputService, ? extends TextInputService> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        textInputServiceFactory = function1;
    }

    /* access modifiers changed from: private */
    /* renamed from: preTransform-JiSxe2E  reason: not valid java name */
    public static final void m5211preTransformJiSxe2E(float[] $this$preTransform_u2dJiSxe2E, float[] other) {
        float[] fArr = $this$preTransform_u2dJiSxe2E;
        float[] fArr2 = other;
        float v00 = m5210dotp89u6pk(fArr2, 0, fArr, 0);
        float v01 = m5210dotp89u6pk(fArr2, 0, fArr, 1);
        float v02 = m5210dotp89u6pk(fArr2, 0, fArr, 2);
        float v03 = m5210dotp89u6pk(fArr2, 0, fArr, 3);
        float v10 = m5210dotp89u6pk(fArr2, 1, fArr, 0);
        float v11 = m5210dotp89u6pk(fArr2, 1, fArr, 1);
        float v12 = m5210dotp89u6pk(fArr2, 1, fArr, 2);
        float v13 = m5210dotp89u6pk(fArr2, 1, fArr, 3);
        float v20 = m5210dotp89u6pk(fArr2, 2, fArr, 0);
        float v21 = m5210dotp89u6pk(fArr2, 2, fArr, 1);
        float v22 = m5210dotp89u6pk(fArr2, 2, fArr, 2);
        float v23 = m5210dotp89u6pk(fArr2, 2, fArr, 3);
        float v30 = m5210dotp89u6pk(fArr2, 3, fArr, 0);
        float v31 = m5210dotp89u6pk(fArr2, 3, fArr, 1);
        float v32 = m5210dotp89u6pk(fArr2, 3, fArr, 2);
        float v33 = m5210dotp89u6pk(fArr2, 3, fArr, 3);
        fArr[(0 * 4) + 0] = v00;
        fArr[(0 * 4) + 1] = v01;
        fArr[(0 * 4) + 2] = v02;
        fArr[(0 * 4) + 3] = v03;
        fArr[(1 * 4) + 0] = v10;
        fArr[(1 * 4) + 1] = v11;
        fArr[(1 * 4) + 2] = v12;
        fArr[(1 * 4) + 3] = v13;
        fArr[(2 * 4) + 0] = v20;
        fArr[(2 * 4) + 1] = v21;
        fArr[(2 * 4) + 2] = v22;
        fArr[(2 * 4) + 3] = v23;
        fArr[(3 * 4) + 0] = v30;
        fArr[(3 * 4) + 1] = v31;
        fArr[(3 * 4) + 2] = v32;
        fArr[(3 * 4) + 3] = v33;
    }

    /* renamed from: dot-p89u6pk  reason: not valid java name */
    private static final float m5210dotp89u6pk(float[] m1, int row, float[] m2, int column) {
        return (m1[(row * 4) + 0] * m2[(0 * 4) + column]) + (m1[(row * 4) + 1] * m2[(1 * 4) + column]) + (m1[(row * 4) + 2] * m2[(2 * 4) + column]) + (m1[(row * 4) + 3] * m2[(3 * 4) + column]);
    }
}
