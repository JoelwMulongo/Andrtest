package androidx.core.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class FontProvider {
    private static final Comparator<byte[]> sByteArrayComparator = new FontProvider$$ExternalSyntheticLambda0();

    private FontProvider() {
    }

    static FontsContractCompat.FontFamilyResult getFontFamilyResult(Context context, FontRequest request, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfo = getProvider(context.getPackageManager(), request, context.getResources());
        if (providerInfo == null) {
            return FontsContractCompat.FontFamilyResult.create(1, (FontsContractCompat.FontInfo[]) null);
        }
        return FontsContractCompat.FontFamilyResult.create(0, query(context, request, providerInfo.authority, cancellationSignal));
    }

    static ProviderInfo getProvider(PackageManager packageManager, FontRequest request, Resources resources) throws PackageManager.NameNotFoundException {
        String providerAuthority = request.getProviderAuthority();
        ProviderInfo info = packageManager.resolveContentProvider(providerAuthority, 0);
        if (info == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
        } else if (info.packageName.equals(request.getProviderPackage())) {
            List<byte[]> signatures = convertToByteArrayList(packageManager.getPackageInfo(info.packageName, 64).signatures);
            Collections.sort(signatures, sByteArrayComparator);
            List<List<byte[]>> requestCertificatesList = getCertificates(request, resources);
            for (int i = 0; i < requestCertificatesList.size(); i++) {
                List<byte[]> requestSignatures = new ArrayList<>(requestCertificatesList.get(i));
                Collections.sort(requestSignatures, sByteArrayComparator);
                if (equalsByteArrayList(signatures, requestSignatures)) {
                    return info;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + request.getProviderPackage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static androidx.core.provider.FontsContractCompat.FontInfo[] query(android.content.Context r21, androidx.core.provider.FontRequest r22, java.lang.String r23, android.os.CancellationSignal r24) {
        /*
            r1 = r23
            java.lang.String r0 = "result_code"
            java.lang.String r2 = "font_italic"
            java.lang.String r3 = "font_weight"
            java.lang.String r4 = "font_ttc_index"
            java.lang.String r5 = "file_id"
            java.lang.String r6 = "_id"
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            android.net.Uri$Builder r8 = new android.net.Uri$Builder
            r8.<init>()
            java.lang.String r9 = "content"
            android.net.Uri$Builder r8 = r8.scheme(r9)
            android.net.Uri$Builder r8 = r8.authority(r1)
            android.net.Uri r8 = r8.build()
            android.net.Uri$Builder r10 = new android.net.Uri$Builder
            r10.<init>()
            android.net.Uri$Builder r9 = r10.scheme(r9)
            android.net.Uri$Builder r9 = r9.authority(r1)
            java.lang.String r10 = "file"
            android.net.Uri$Builder r9 = r9.appendPath(r10)
            android.net.Uri r9 = r9.build()
            r17 = 0
            r10 = 7
            java.lang.String[] r12 = new java.lang.String[r10]     // Catch:{ all -> 0x011a }
            r15 = 0
            r12[r15] = r6     // Catch:{ all -> 0x011a }
            r14 = 1
            r12[r14] = r5     // Catch:{ all -> 0x011a }
            r10 = 2
            r12[r10] = r4     // Catch:{ all -> 0x011a }
            java.lang.String r10 = "font_variation_settings"
            r11 = 3
            r12[r11] = r10     // Catch:{ all -> 0x011a }
            r10 = 4
            r12[r10] = r3     // Catch:{ all -> 0x011a }
            r10 = 5
            r12[r10] = r2     // Catch:{ all -> 0x011a }
            r10 = 6
            r12[r10] = r0     // Catch:{ all -> 0x011a }
            android.content.ContentResolver r10 = r21.getContentResolver()     // Catch:{ all -> 0x011a }
            java.lang.String r13 = "query = ?"
            java.lang.String[] r11 = new java.lang.String[r14]     // Catch:{ all -> 0x011a }
            java.lang.String r16 = r22.getQuery()     // Catch:{ all -> 0x011a }
            r11[r15] = r16     // Catch:{ all -> 0x011a }
            r16 = 0
            r18 = r11
            r11 = r8
            r1 = r14
            r14 = r18
            r15 = r16
            r16 = r24
            android.database.Cursor r11 = androidx.core.provider.FontProvider.Api16Impl.query(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x011a }
            if (r11 == 0) goto L_0x010b
            int r13 = r11.getCount()     // Catch:{ all -> 0x0107 }
            if (r13 <= 0) goto L_0x010b
            int r0 = r11.getColumnIndex(r0)     // Catch:{ all -> 0x0107 }
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x0107 }
            r13.<init>()     // Catch:{ all -> 0x0107 }
            r7 = r13
            int r6 = r11.getColumnIndex(r6)     // Catch:{ all -> 0x0107 }
            int r5 = r11.getColumnIndex(r5)     // Catch:{ all -> 0x0107 }
            int r4 = r11.getColumnIndex(r4)     // Catch:{ all -> 0x0107 }
            int r3 = r11.getColumnIndex(r3)     // Catch:{ all -> 0x0107 }
            int r2 = r11.getColumnIndex(r2)     // Catch:{ all -> 0x0107 }
        L_0x00a0:
            boolean r13 = r11.moveToNext()     // Catch:{ all -> 0x0107 }
            if (r13 == 0) goto L_0x0102
            r13 = -1
            if (r0 == r13) goto L_0x00ae
            int r15 = r11.getInt(r0)     // Catch:{ all -> 0x0107 }
            goto L_0x00af
        L_0x00ae:
            r15 = 0
        L_0x00af:
            r14 = r15
            if (r4 == r13) goto L_0x00b7
            int r15 = r11.getInt(r4)     // Catch:{ all -> 0x0107 }
            goto L_0x00b8
        L_0x00b7:
            r15 = 0
        L_0x00b8:
            if (r5 != r13) goto L_0x00cb
            long r16 = r11.getLong(r6)     // Catch:{ all -> 0x0107 }
            r19 = r16
            r17 = r2
            r1 = r19
            android.net.Uri r18 = android.content.ContentUris.withAppendedId(r8, r1)     // Catch:{ all -> 0x0107 }
            r1 = r18
            goto L_0x00d7
        L_0x00cb:
            r17 = r2
            long r1 = r11.getLong(r5)     // Catch:{ all -> 0x0107 }
            android.net.Uri r18 = android.content.ContentUris.withAppendedId(r9, r1)     // Catch:{ all -> 0x0107 }
            r1 = r18
        L_0x00d7:
            if (r3 == r13) goto L_0x00de
            int r2 = r11.getInt(r3)     // Catch:{ all -> 0x0107 }
            goto L_0x00e0
        L_0x00de:
            r2 = 400(0x190, float:5.6E-43)
        L_0x00e0:
            r18 = r0
            r0 = r17
            if (r0 == r13) goto L_0x00f1
            int r13 = r11.getInt(r0)     // Catch:{ all -> 0x0107 }
            r17 = r0
            r0 = 1
            if (r13 != r0) goto L_0x00f4
            r13 = r0
            goto L_0x00f5
        L_0x00f1:
            r17 = r0
            r0 = 1
        L_0x00f4:
            r13 = 0
        L_0x00f5:
            androidx.core.provider.FontsContractCompat$FontInfo r0 = androidx.core.provider.FontsContractCompat.FontInfo.create(r1, r15, r2, r13, r14)     // Catch:{ all -> 0x0107 }
            r7.add(r0)     // Catch:{ all -> 0x0107 }
            r2 = r17
            r0 = r18
            r1 = 1
            goto L_0x00a0
        L_0x0102:
            r18 = r0
            r17 = r2
            goto L_0x010b
        L_0x0107:
            r0 = move-exception
            r17 = r11
            goto L_0x011b
        L_0x010b:
            if (r11 == 0) goto L_0x0110
            r11.close()
        L_0x0110:
            r0 = 0
            androidx.core.provider.FontsContractCompat$FontInfo[] r0 = new androidx.core.provider.FontsContractCompat.FontInfo[r0]
            java.lang.Object[] r0 = r7.toArray(r0)
            androidx.core.provider.FontsContractCompat$FontInfo[] r0 = (androidx.core.provider.FontsContractCompat.FontInfo[]) r0
            return r0
        L_0x011a:
            r0 = move-exception
        L_0x011b:
            if (r17 == 0) goto L_0x0120
            r17.close()
        L_0x0120:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontProvider.query(android.content.Context, androidx.core.provider.FontRequest, java.lang.String, android.os.CancellationSignal):androidx.core.provider.FontsContractCompat$FontInfo[]");
    }

    private static List<List<byte[]>> getCertificates(FontRequest request, Resources resources) {
        if (request.getCertificates() != null) {
            return request.getCertificates();
        }
        return FontResourcesParserCompat.readCerts(resources, request.getCertificatesArrayResId());
    }

    static /* synthetic */ int lambda$static$0(byte[] l, byte[] r) {
        if (l.length != r.length) {
            return l.length - r.length;
        }
        for (int i = 0; i < l.length; i++) {
            if (l[i] != r[i]) {
                return l[i] - r[i];
            }
        }
        return 0;
    }

    private static boolean equalsByteArrayList(List<byte[]> signatures, List<byte[]> requestSignatures) {
        if (signatures.size() != requestSignatures.size()) {
            return false;
        }
        for (int i = 0; i < signatures.size(); i++) {
            if (!Arrays.equals(signatures.get(i), requestSignatures.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> convertToByteArrayList(Signature[] signatures) {
        List<byte[]> shaList = new ArrayList<>();
        for (Signature signature : signatures) {
            shaList.add(signature.toByteArray());
        }
        return shaList;
    }

    static class Api16Impl {
        private Api16Impl() {
        }

        static Cursor query(ContentResolver contentResolver, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, Object cancellationSignal) {
            return contentResolver.query(uri, projection, selection, selectionArgs, sortOrder, (CancellationSignal) cancellationSignal);
        }
    }
}
