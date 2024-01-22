package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a­\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-6oU6zVQ", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "buttons", "AlertDialog-wqdebIU", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidAlertDialog.android.kt */
public final class AndroidAlertDialog_androidKt {
    /* renamed from: AlertDialog-6oU6zVQ  reason: not valid java name */
    public static final void m1363AlertDialog6oU6zVQ(Function0<Unit> onDismissRequest, Function2<? super Composer, ? super Integer, Unit> confirmButton, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> dismissButton, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> text, Shape shape, long backgroundColor, long contentColor, DialogProperties properties, Composer $composer, int $changed, int i) {
        Function2 function2;
        long contentColor2;
        DialogProperties properties2;
        long contentColor3;
        long backgroundColor2;
        Shape shape2;
        Function2 text2;
        Function2 title2;
        Modifier modifier2;
        Composer $composer2;
        Function2 dismissButton2;
        Function2 dismissButton3;
        int $dirty;
        Modifier modifier3;
        Function2 dismissButton4;
        Function2 title3;
        Function2 text3;
        Shape shape3;
        Modifier modifier4;
        int $dirty2;
        long backgroundColor3;
        int i2;
        int i3;
        int i4;
        Function0<Unit> function0 = onDismissRequest;
        Function2<? super Composer, ? super Integer, Unit> function22 = confirmButton;
        int i5 = $changed;
        int i6 = i;
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function22, "confirmButton");
        Composer $composer3 = $composer.startRestartGroup(-606536823);
        ComposerKt.sourceInformation($composer3, "C(AlertDialog)P(5,1,4,3,9,8,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color)70@3471L6,71@3529L6,72@3571L32,75@3667L735:AndroidAlertDialog.android.kt#jmzs0o");
        int $dirty3 = $changed;
        if ((i6 & 1) != 0) {
            $dirty3 |= 6;
        } else if ((i5 & 14) == 0) {
            $dirty3 |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        if ((i6 & 2) != 0) {
            $dirty3 |= 48;
        } else if ((i5 & 112) == 0) {
            $dirty3 |= $composer3.changedInstance(function22) ? 32 : 16;
        }
        int i7 = i6 & 4;
        if (i7 != 0) {
            $dirty3 |= 384;
            Modifier modifier5 = modifier;
        } else if ((i5 & 896) == 0) {
            $dirty3 |= $composer3.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier6 = modifier;
        }
        int i8 = i6 & 8;
        if (i8 != 0) {
            $dirty3 |= 3072;
            Function2<? super Composer, ? super Integer, Unit> function23 = dismissButton;
        } else if ((i5 & 7168) == 0) {
            $dirty3 |= $composer3.changedInstance(dismissButton) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = dismissButton;
        }
        int i9 = i6 & 16;
        if (i9 != 0) {
            $dirty3 |= 24576;
            Function2<? super Composer, ? super Integer, Unit> function25 = title;
        } else if ((i5 & 57344) == 0) {
            $dirty3 |= $composer3.changedInstance(title) ? 16384 : 8192;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function26 = title;
        }
        int i10 = i6 & 32;
        if (i10 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function2 = text;
        } else if ((i5 & 458752) == 0) {
            function2 = text;
            $dirty3 |= $composer3.changedInstance(function2) ? 131072 : 65536;
        } else {
            function2 = text;
        }
        if ((i5 & 3670016) == 0) {
            if ((i6 & 64) != 0) {
                Shape shape4 = shape;
            } else if ($composer3.changed((Object) shape)) {
                i4 = 1048576;
                $dirty3 |= i4;
            }
            i4 = 524288;
            $dirty3 |= i4;
        } else {
            Shape shape5 = shape;
        }
        if ((i5 & 29360128) == 0) {
            if ((i6 & 128) != 0) {
                long j = backgroundColor;
            } else if ($composer3.changed(backgroundColor)) {
                i3 = 8388608;
                $dirty3 |= i3;
            }
            i3 = 4194304;
            $dirty3 |= i3;
        } else {
            long j2 = backgroundColor;
        }
        if ((i5 & 234881024) == 0) {
            if ((i6 & 256) == 0) {
                contentColor2 = contentColor;
                if ($composer3.changed(contentColor2)) {
                    i2 = 67108864;
                    $dirty3 |= i2;
                }
            } else {
                contentColor2 = contentColor;
            }
            i2 = 33554432;
            $dirty3 |= i2;
        } else {
            contentColor2 = contentColor;
        }
        int i11 = i6 & 512;
        if (i11 != 0) {
            $dirty3 |= 805306368;
            DialogProperties dialogProperties = properties;
        } else if ((i5 & 1879048192) == 0) {
            $dirty3 |= $composer3.changed((Object) properties) ? 536870912 : 268435456;
        } else {
            DialogProperties dialogProperties2 = properties;
        }
        if (($dirty3 & 1533916891) != 306783378 || !$composer3.getSkipping()) {
            $composer3.startDefaults();
            if ((i5 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i8 != 0) {
                    dismissButton4 = null;
                } else {
                    dismissButton4 = dismissButton;
                }
                if (i9 != 0) {
                    title3 = null;
                } else {
                    title3 = title;
                }
                if (i10 != 0) {
                    text3 = null;
                } else {
                    text3 = function2;
                }
                if ((i6 & 64) != 0) {
                    shape3 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getMedium();
                    $dirty3 &= -3670017;
                } else {
                    shape3 = shape;
                }
                if ((i6 & 128) != 0) {
                    $dirty2 = $dirty3 & -29360129;
                    modifier4 = modifier3;
                    backgroundColor3 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1449getSurface0d7_KjU();
                } else {
                    $dirty2 = $dirty3;
                    modifier4 = modifier3;
                    backgroundColor3 = backgroundColor;
                }
                if ((i6 & 256) != 0) {
                    contentColor2 = ColorsKt.m1463contentColorForek8zF_U(backgroundColor3, $composer3, ($dirty2 >> 21) & 14);
                    $dirty2 &= -234881025;
                }
                if (i11 != 0) {
                    modifier2 = modifier4;
                    properties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                    backgroundColor2 = backgroundColor3;
                    dismissButton3 = dismissButton4;
                    title2 = title3;
                    text2 = text3;
                    contentColor3 = contentColor2;
                    shape2 = shape3;
                    $dirty = $dirty2;
                } else {
                    modifier2 = modifier4;
                    properties2 = properties;
                    backgroundColor2 = backgroundColor3;
                    dismissButton3 = dismissButton4;
                    title2 = title3;
                    text2 = text3;
                    contentColor3 = contentColor2;
                    shape2 = shape3;
                    $dirty = $dirty2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i6 & 64) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i6 & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                if ((i6 & 256) != 0) {
                    modifier2 = modifier;
                    title2 = title;
                    shape2 = shape;
                    backgroundColor2 = backgroundColor;
                    properties2 = properties;
                    contentColor3 = contentColor2;
                    text2 = function2;
                    dismissButton3 = dismissButton;
                    $dirty = -234881025 & $dirty3;
                } else {
                    modifier2 = modifier;
                    title2 = title;
                    shape2 = shape;
                    backgroundColor2 = backgroundColor;
                    properties2 = properties;
                    contentColor3 = contentColor2;
                    text2 = function2;
                    dismissButton3 = dismissButton;
                    $dirty = $dirty3;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-606536823, $dirty, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
            }
            int i12 = $dirty;
            dismissButton2 = dismissButton3;
            $composer2 = $composer3;
            m1364AlertDialogwqdebIU(onDismissRequest, ComposableLambdaKt.composableLambda($composer3, -1849673151, true, new AndroidAlertDialog_androidKt$AlertDialog$1(dismissButton3, $dirty, function22)), modifier2, title2, text2, shape2, backgroundColor2, contentColor3, properties2, $composer3, ($dirty & 14) | 48 | ($dirty & 896) | (($dirty >> 3) & 7168) | (($dirty >> 3) & 57344) | (($dirty >> 3) & 458752) | (($dirty >> 3) & 3670016) | (($dirty >> 3) & 29360128) | (($dirty >> 3) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            dismissButton2 = dismissButton;
            title2 = title;
            shape2 = shape;
            backgroundColor2 = backgroundColor;
            properties2 = properties;
            int i13 = $dirty3;
            contentColor3 = contentColor2;
            text2 = function2;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$2(onDismissRequest, confirmButton, modifier2, dismissButton2, title2, text2, shape2, backgroundColor2, contentColor3, properties2, $changed, i));
        }
    }

    /* renamed from: AlertDialog-wqdebIU  reason: not valid java name */
    public static final void m1364AlertDialogwqdebIU(Function0<Unit> onDismissRequest, Function2<? super Composer, ? super Integer, Unit> buttons, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> text, Shape shape, long backgroundColor, long contentColor, DialogProperties properties, Composer $composer, int $changed, int i) {
        long backgroundColor2;
        long contentColor2;
        DialogProperties properties2;
        long contentColor3;
        long backgroundColor3;
        Shape shape2;
        Function2 text2;
        Function2 title2;
        Modifier modifier2;
        int $dirty;
        Modifier modifier3;
        Function2 title3;
        Function2 text3;
        Shape shape3;
        Modifier modifier4;
        int i2;
        int i3;
        int i4;
        Function0<Unit> function0 = onDismissRequest;
        Function2<? super Composer, ? super Integer, Unit> function2 = buttons;
        int i5 = $changed;
        int i6 = i;
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function2, "buttons");
        Composer $composer2 = $composer.startRestartGroup(1035523925);
        ComposerKt.sourceInformation($composer2, "C(AlertDialog)P(4,1,3,8,7,6,0:c#ui.graphics.Color,2:c#ui.graphics.Color)131@6133L6,132@6191L6,133@6233L32,136@6329L366:AndroidAlertDialog.android.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i6 & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i5 & 14) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        if ((i6 & 2) != 0) {
            $dirty2 |= 48;
        } else if ((i5 & 112) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        int i7 = i6 & 4;
        if (i7 != 0) {
            $dirty2 |= 384;
            Modifier modifier5 = modifier;
        } else if ((i5 & 896) == 0) {
            $dirty2 |= $composer2.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier6 = modifier;
        }
        int i8 = i6 & 8;
        if (i8 != 0) {
            $dirty2 |= 3072;
            Function2<? super Composer, ? super Integer, Unit> function22 = title;
        } else if ((i5 & 7168) == 0) {
            $dirty2 |= $composer2.changedInstance(title) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = title;
        }
        int i9 = i6 & 16;
        if (i9 != 0) {
            $dirty2 |= 24576;
            Function2<? super Composer, ? super Integer, Unit> function24 = text;
        } else if ((57344 & i5) == 0) {
            $dirty2 |= $composer2.changedInstance(text) ? 16384 : 8192;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function25 = text;
        }
        if ((458752 & i5) == 0) {
            if ((i6 & 32) != 0) {
                Shape shape4 = shape;
            } else if ($composer2.changed((Object) shape)) {
                i4 = 131072;
                $dirty2 |= i4;
            }
            i4 = 65536;
            $dirty2 |= i4;
        } else {
            Shape shape5 = shape;
        }
        if ((3670016 & i5) == 0) {
            if ((i6 & 64) == 0) {
                backgroundColor2 = backgroundColor;
                if ($composer2.changed(backgroundColor2)) {
                    i3 = 1048576;
                    $dirty2 |= i3;
                }
            } else {
                backgroundColor2 = backgroundColor;
            }
            i3 = 524288;
            $dirty2 |= i3;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((i5 & 29360128) == 0) {
            if ((i6 & 128) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i2 = 8388608;
                    $dirty2 |= i2;
                }
            } else {
                contentColor2 = contentColor;
            }
            i2 = 4194304;
            $dirty2 |= i2;
        } else {
            contentColor2 = contentColor;
        }
        int i10 = i6 & 256;
        if (i10 != 0) {
            $dirty2 |= 100663296;
            DialogProperties dialogProperties = properties;
        } else if ((i5 & 234881024) == 0) {
            $dirty2 |= $composer2.changed((Object) properties) ? 67108864 : 33554432;
        } else {
            DialogProperties dialogProperties2 = properties;
        }
        if (($dirty2 & 191739611) != 38347922 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i5 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i8 != 0) {
                    title3 = null;
                } else {
                    title3 = title;
                }
                if (i9 != 0) {
                    text3 = null;
                } else {
                    text3 = text;
                }
                if ((i6 & 32) != 0) {
                    shape3 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getMedium();
                    $dirty2 &= -458753;
                } else {
                    shape3 = shape;
                }
                if ((i6 & 64) != 0) {
                    modifier4 = modifier3;
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1449getSurface0d7_KjU();
                    $dirty2 &= -3670017;
                } else {
                    modifier4 = modifier3;
                }
                if ((i6 & 128) != 0) {
                    contentColor2 = ColorsKt.m1463contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 18) & 14);
                    $dirty2 &= -29360129;
                }
                if (i10 != 0) {
                    modifier2 = modifier4;
                    properties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                    title2 = title3;
                    text2 = text3;
                    shape2 = shape3;
                    contentColor3 = contentColor2;
                    backgroundColor3 = backgroundColor2;
                    $dirty = $dirty2;
                } else {
                    modifier2 = modifier4;
                    properties2 = properties;
                    title2 = title3;
                    text2 = text3;
                    shape2 = shape3;
                    contentColor3 = contentColor2;
                    backgroundColor3 = backgroundColor2;
                    $dirty = $dirty2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i6 & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i6 & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i6 & 128) != 0) {
                    modifier2 = modifier;
                    title2 = title;
                    text2 = text;
                    shape2 = shape;
                    properties2 = properties;
                    contentColor3 = contentColor2;
                    backgroundColor3 = backgroundColor2;
                    $dirty = $dirty2 & -29360129;
                } else {
                    modifier2 = modifier;
                    title2 = title;
                    text2 = text;
                    shape2 = shape;
                    properties2 = properties;
                    contentColor3 = contentColor2;
                    backgroundColor3 = backgroundColor2;
                    $dirty = $dirty2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1035523925, $dirty, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
            }
            AndroidAlertDialog_androidKt$AlertDialog$3 androidAlertDialog_androidKt$AlertDialog$3 = r0;
            int $dirty3 = $dirty;
            AndroidAlertDialog_androidKt$AlertDialog$3 androidAlertDialog_androidKt$AlertDialog$32 = new AndroidAlertDialog_androidKt$AlertDialog$3(buttons, modifier2, title2, text2, shape2, backgroundColor3, contentColor3, $dirty);
            AndroidDialog_androidKt.Dialog(onDismissRequest, properties2, ComposableLambdaKt.composableLambda($composer2, -1787418772, true, androidAlertDialog_androidKt$AlertDialog$3), $composer2, ($dirty3 & 14) | 384 | (($dirty3 >> 21) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            title2 = title;
            text2 = text;
            shape2 = shape;
            properties2 = properties;
            int i11 = $dirty2;
            contentColor3 = contentColor2;
            backgroundColor3 = backgroundColor2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$4(onDismissRequest, buttons, modifier2, title2, text2, shape2, backgroundColor3, contentColor3, properties2, $changed, i));
    }
}
