package androidx.core.app;

import android.app.RemoteInput;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class RemoteInput {
    public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0;
    public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1;
    public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2;
    private static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    private static final String EXTRA_RESULTS_SOURCE = "android.remoteinput.resultsSource";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    public static final int SOURCE_CHOICE = 1;
    public static final int SOURCE_FREE_FORM_INPUT = 0;
    private final boolean mAllowFreeFormTextInput;
    private final Set<String> mAllowedDataTypes;
    private final CharSequence[] mChoices;
    private final int mEditChoicesBeforeSending;
    private final Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;

    @Retention(RetentionPolicy.SOURCE)
    public @interface EditChoicesBeforeSending {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    RemoteInput(String resultKey, CharSequence label, CharSequence[] choices, boolean allowFreeFormTextInput, int editChoicesBeforeSending, Bundle extras, Set<String> allowedDataTypes) {
        this.mResultKey = resultKey;
        this.mLabel = label;
        this.mChoices = choices;
        this.mAllowFreeFormTextInput = allowFreeFormTextInput;
        this.mEditChoicesBeforeSending = editChoicesBeforeSending;
        this.mExtras = extras;
        this.mAllowedDataTypes = allowedDataTypes;
        if (getEditChoicesBeforeSending() == 2 && !getAllowFreeFormInput()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    public String getResultKey() {
        return this.mResultKey;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

    public CharSequence[] getChoices() {
        return this.mChoices;
    }

    public Set<String> getAllowedDataTypes() {
        return this.mAllowedDataTypes;
    }

    public boolean isDataOnly() {
        return !getAllowFreeFormInput() && (getChoices() == null || getChoices().length == 0) && getAllowedDataTypes() != null && !getAllowedDataTypes().isEmpty();
    }

    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormTextInput;
    }

    public int getEditChoicesBeforeSending() {
        return this.mEditChoicesBeforeSending;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public static final class Builder {
        private boolean mAllowFreeFormTextInput = true;
        private final Set<String> mAllowedDataTypes = new HashSet();
        private CharSequence[] mChoices;
        private int mEditChoicesBeforeSending = 0;
        private final Bundle mExtras = new Bundle();
        private CharSequence mLabel;
        private final String mResultKey;

        public Builder(String resultKey) {
            if (resultKey != null) {
                this.mResultKey = resultKey;
                return;
            }
            throw new IllegalArgumentException("Result key can't be null");
        }

        public Builder setLabel(CharSequence label) {
            this.mLabel = label;
            return this;
        }

        public Builder setChoices(CharSequence[] choices) {
            this.mChoices = choices;
            return this;
        }

        public Builder setAllowDataType(String mimeType, boolean doAllow) {
            if (doAllow) {
                this.mAllowedDataTypes.add(mimeType);
            } else {
                this.mAllowedDataTypes.remove(mimeType);
            }
            return this;
        }

        public Builder setAllowFreeFormInput(boolean allowFreeFormTextInput) {
            this.mAllowFreeFormTextInput = allowFreeFormTextInput;
            return this;
        }

        public Builder setEditChoicesBeforeSending(int editChoicesBeforeSending) {
            this.mEditChoicesBeforeSending = editChoicesBeforeSending;
            return this;
        }

        public Builder addExtras(Bundle extras) {
            if (extras != null) {
                this.mExtras.putAll(extras);
            }
            return this;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public RemoteInput build() {
            return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mEditChoicesBeforeSending, this.mExtras, this.mAllowedDataTypes);
        }
    }

    public static Map<String, Uri> getDataResultsFromIntent(Intent intent, String remoteInputResultKey) {
        return Api26Impl.getDataResultsFromIntent(intent, remoteInputResultKey);
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        return Api20Impl.getResultsFromIntent(intent);
    }

    public static void addResultsToIntent(RemoteInput[] remoteInputs, Intent intent, Bundle results) {
        Api20Impl.addResultsToIntent(fromCompat(remoteInputs), intent, results);
    }

    public static void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> results) {
        Api26Impl.addDataResultToIntent(remoteInput, intent, results);
    }

    public static void setResultsSource(Intent intent, int source) {
        Api28Impl.setResultsSource(intent, source);
    }

    public static int getResultsSource(Intent intent) {
        return Api28Impl.getResultsSource(intent);
    }

    private static String getExtraResultsKeyForData(String mimeType) {
        return EXTRA_DATA_TYPE_RESULTS_DATA + mimeType;
    }

    static android.app.RemoteInput[] fromCompat(RemoteInput[] srcArray) {
        if (srcArray == null) {
            return null;
        }
        android.app.RemoteInput[] result = new android.app.RemoteInput[srcArray.length];
        for (int i = 0; i < srcArray.length; i++) {
            result[i] = fromCompat(srcArray[i]);
        }
        return result;
    }

    static android.app.RemoteInput fromCompat(RemoteInput src) {
        return Api20Impl.fromCompat(src);
    }

    static RemoteInput fromPlatform(android.app.RemoteInput src) {
        return Api20Impl.fromPlatform(src);
    }

    private static Intent getClipDataIntentFromIntent(Intent intent) {
        ClipData clipData = Api16Impl.getClipData(intent);
        if (clipData == null) {
            return null;
        }
        ClipDescription clipDescription = clipData.getDescription();
        if (clipDescription.hasMimeType("text/vnd.android.intent") && clipDescription.getLabel().toString().contentEquals(RESULTS_CLIP_LABEL)) {
            return clipData.getItemAt(0).getIntent();
        }
        return null;
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static Map<String, Uri> getDataResultsFromIntent(Intent intent, String remoteInputResultKey) {
            return android.app.RemoteInput.getDataResultsFromIntent(intent, remoteInputResultKey);
        }

        static Set<String> getAllowedDataTypes(Object remoteInput) {
            return ((android.app.RemoteInput) remoteInput).getAllowedDataTypes();
        }

        static void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> results) {
            android.app.RemoteInput.addDataResultToIntent(RemoteInput.fromCompat(remoteInput), intent, results);
        }

        static RemoteInput.Builder setAllowDataType(RemoteInput.Builder builder, String mimeType, boolean doAllow) {
            return builder.setAllowDataType(mimeType, doAllow);
        }
    }

    static class Api20Impl {
        private Api20Impl() {
        }

        static Bundle getResultsFromIntent(Intent intent) {
            return android.app.RemoteInput.getResultsFromIntent(intent);
        }

        static void addResultsToIntent(Object remoteInputs, Intent intent, Bundle results) {
            android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[]) remoteInputs, intent, results);
        }

        static RemoteInput fromPlatform(Object srcObj) {
            android.app.RemoteInput src = (android.app.RemoteInput) srcObj;
            Builder builder = new Builder(src.getResultKey()).setLabel(src.getLabel()).setChoices(src.getChoices()).setAllowFreeFormInput(src.getAllowFreeFormInput()).addExtras(src.getExtras());
            Set<String> allowedDataTypes = Api26Impl.getAllowedDataTypes(src);
            if (allowedDataTypes != null) {
                for (String allowedDataType : allowedDataTypes) {
                    builder.setAllowDataType(allowedDataType, true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setEditChoicesBeforeSending(Api29Impl.getEditChoicesBeforeSending(src));
            }
            return builder.build();
        }

        public static android.app.RemoteInput fromCompat(RemoteInput src) {
            RemoteInput.Builder builder = new RemoteInput.Builder(src.getResultKey()).setLabel(src.getLabel()).setChoices(src.getChoices()).setAllowFreeFormInput(src.getAllowFreeFormInput()).addExtras(src.getExtras());
            Set<String> allowedDataTypes = src.getAllowedDataTypes();
            if (allowedDataTypes != null) {
                for (String allowedDataType : allowedDataTypes) {
                    Api26Impl.setAllowDataType(builder, allowedDataType, true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.setEditChoicesBeforeSending(builder, src.getEditChoicesBeforeSending());
            }
            return builder.build();
        }
    }

    static class Api16Impl {
        private Api16Impl() {
        }

        static ClipData getClipData(Intent intent) {
            return intent.getClipData();
        }

        static void setClipData(Intent intent, ClipData clip) {
            intent.setClipData(clip);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static int getEditChoicesBeforeSending(Object remoteInput) {
            return ((android.app.RemoteInput) remoteInput).getEditChoicesBeforeSending();
        }

        static RemoteInput.Builder setEditChoicesBeforeSending(RemoteInput.Builder builder, int editChoicesBeforeSending) {
            return builder.setEditChoicesBeforeSending(editChoicesBeforeSending);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static void setResultsSource(Intent intent, int source) {
            android.app.RemoteInput.setResultsSource(intent, source);
        }

        static int getResultsSource(Intent intent) {
            return android.app.RemoteInput.getResultsSource(intent);
        }
    }
}
