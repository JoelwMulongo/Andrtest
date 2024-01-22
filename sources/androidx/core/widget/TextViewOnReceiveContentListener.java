package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;

public final class TextViewOnReceiveContentListener implements OnReceiveContentListener {
    private static final String LOG_TAG = "ReceiveContent";

    public ContentInfoCompat onReceiveContent(View view, ContentInfoCompat payload) {
        if (Log.isLoggable(LOG_TAG, 3)) {
            Log.d(LOG_TAG, "onReceive: " + payload);
        }
        if (payload.getSource() == 2) {
            return payload;
        }
        ClipData clip = payload.getClip();
        int flags = payload.getFlags();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean didFirst = false;
        for (int i = 0; i < clip.getItemCount(); i++) {
            CharSequence itemText = coerceToText(context, clip.getItemAt(i), flags);
            if (itemText != null) {
                if (!didFirst) {
                    replaceSelection(editable, itemText);
                    didFirst = true;
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), itemText);
                }
            }
        }
        return null;
    }

    private static CharSequence coerceToText(Context context, ClipData.Item item, int flags) {
        return Api16Impl.coerce(context, item, flags);
    }

    private static void replaceSelection(Editable editable, CharSequence replacement) {
        int selStart = Selection.getSelectionStart(editable);
        int selEnd = Selection.getSelectionEnd(editable);
        int start = Math.max(0, Math.min(selStart, selEnd));
        int end = Math.max(0, Math.max(selStart, selEnd));
        Selection.setSelection(editable, end);
        editable.replace(start, end, replacement);
    }

    private static final class Api16Impl {
        private Api16Impl() {
        }

        static CharSequence coerce(Context context, ClipData.Item item, int flags) {
            if ((flags & 1) == 0) {
                return item.coerceToStyledText(context);
            }
            CharSequence text = item.coerceToText(context);
            return text instanceof Spanned ? text.toString() : text;
        }
    }

    private static final class ApiImpl {
        private ApiImpl() {
        }

        static CharSequence coerce(Context context, ClipData.Item item, int flags) {
            CharSequence text = item.coerceToText(context);
            if ((flags & 1) == 0 || !(text instanceof Spanned)) {
                return text;
            }
            return text.toString();
        }
    }
}
