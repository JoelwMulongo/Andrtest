package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.os.BuildCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\\\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\nH\u0007J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J\"\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/android/BoringLayoutFactory;", "", "()V", "create", "Landroid/text/BoringLayout;", "text", "", "paint", "Landroid/text/TextPaint;", "width", "", "metrics", "Landroid/text/BoringLayout$Metrics;", "alignment", "Landroid/text/Layout$Alignment;", "includePadding", "", "useFallbackLineSpacing", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "isFallbackLineSpacingEnabled", "layout", "measure", "textDir", "Landroid/text/TextDirectionHeuristic;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BoringLayoutFactory.kt */
public final class BoringLayoutFactory {
    public static final BoringLayoutFactory INSTANCE = new BoringLayoutFactory();

    private BoringLayoutFactory() {
    }

    public final BoringLayout.Metrics measure(CharSequence text, TextPaint paint, TextDirectionHeuristic textDir) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(textDir, "textDir");
        if (BuildCompat.isAtLeastT()) {
            return BoringLayoutFactory33.isBoring(text, paint, textDir);
        }
        return BoringLayoutFactoryDefault.isBoring(text, paint, textDir);
    }

    public static /* synthetic */ BoringLayout create$default(BoringLayoutFactory boringLayoutFactory, CharSequence charSequence, TextPaint textPaint, int i, BoringLayout.Metrics metrics, Layout.Alignment alignment, boolean z, boolean z2, TextUtils.TruncateAt truncateAt, int i2, int i3, Object obj) {
        Layout.Alignment alignment2;
        int i4;
        int i5 = i3;
        if ((i5 & 16) != 0) {
            alignment2 = Layout.Alignment.ALIGN_NORMAL;
        } else {
            alignment2 = alignment;
        }
        boolean z3 = (i5 & 32) != 0 ? false : z;
        boolean z4 = (i5 & 64) != 0 ? true : z2;
        TextUtils.TruncateAt truncateAt2 = (i5 & 128) != 0 ? null : truncateAt;
        if ((i5 & 256) != 0) {
            i4 = i;
        } else {
            i4 = i2;
        }
        return boringLayoutFactory.create(charSequence, textPaint, i, metrics, alignment2, z3, z4, truncateAt2, i4);
    }

    public final BoringLayout create(CharSequence text, TextPaint paint, int width, BoringLayout.Metrics metrics, Layout.Alignment alignment, boolean includePadding, boolean useFallbackLineSpacing, TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        boolean z = true;
        if (width >= 0) {
            if (ellipsizedWidth < 0) {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            } else if (BuildCompat.isAtLeastT()) {
                return BoringLayoutFactory33.create(text, paint, width, alignment, 1.0f, 0.0f, metrics, includePadding, useFallbackLineSpacing, ellipsize, ellipsizedWidth);
            } else {
                return BoringLayoutFactoryDefault.create(text, paint, width, alignment, 1.0f, 0.0f, metrics, includePadding, ellipsize, ellipsizedWidth);
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final boolean isFallbackLineSpacingEnabled(BoringLayout layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        if (BuildCompat.isAtLeastT()) {
            return BoringLayoutFactory33.INSTANCE.isFallbackLineSpacingEnabled(layout);
        }
        return false;
    }
}
