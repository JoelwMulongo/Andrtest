package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\bR*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00048Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\bR*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00048Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\bR*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\bR*\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0018\u0010\bR*\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00048Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b\u001b\u0010\u0002\u001a\u0004\b\u001c\u0010\bR*\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00048Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\bR*\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00048Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b#\u0010\u0002\u001a\u0004\b$\u0010\bR*\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00048Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b'\u0010\u0002\u001a\u0004\b(\u0010\bR*\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00048Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b+\u0010\u0002\u001a\u0004\b,\u0010\bR*\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00048Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b/\u0010\u0002\u001a\u0004\b0\u0010\bR*\u00101\u001a\b\u0012\u0004\u0012\u0002020\u00048Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b3\u0010\u0002\u001a\u0004\b4\u0010\bR*\u00105\u001a\b\u0012\u0004\u0012\u0002060\u00048Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b7\u0010\u0002\u001a\u0004\b8\u0010\bR*\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00048Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b;\u0010\u0002\u001a\u0004\b<\u0010\bR*\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u00048Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b?\u0010\u0002\u001a\u0004\b@\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006A"}, d2 = {"Landroidx/compose/ui/node/Nodes;", "", "()V", "Any", "Landroidx/compose/ui/node/NodeKind;", "Landroidx/compose/ui/Modifier$Node;", "getAny-OLwlOKw$annotations", "getAny-OLwlOKw", "()I", "Draw", "Landroidx/compose/ui/node/DrawModifierNode;", "getDraw-OLwlOKw$annotations", "getDraw-OLwlOKw", "FocusEvent", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "getFocusEvent-OLwlOKw$annotations", "getFocusEvent-OLwlOKw", "FocusProperties", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "getFocusProperties-OLwlOKw$annotations", "getFocusProperties-OLwlOKw", "FocusTarget", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "getFocusTarget-OLwlOKw$annotations", "getFocusTarget-OLwlOKw", "GlobalPositionAware", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "getGlobalPositionAware-OLwlOKw$annotations", "getGlobalPositionAware-OLwlOKw", "IntermediateMeasure", "Landroidx/compose/ui/node/IntermediateLayoutModifierNode;", "getIntermediateMeasure-OLwlOKw$annotations", "getIntermediateMeasure-OLwlOKw", "KeyInput", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "getKeyInput-OLwlOKw$annotations", "getKeyInput-OLwlOKw", "Layout", "Landroidx/compose/ui/node/LayoutModifierNode;", "getLayout-OLwlOKw$annotations", "getLayout-OLwlOKw", "LayoutAware", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "getLayoutAware-OLwlOKw$annotations", "getLayoutAware-OLwlOKw", "Locals", "Landroidx/compose/ui/modifier/ModifierLocalNode;", "getLocals-OLwlOKw$annotations", "getLocals-OLwlOKw", "ParentData", "Landroidx/compose/ui/node/ParentDataModifierNode;", "getParentData-OLwlOKw$annotations", "getParentData-OLwlOKw", "PointerInput", "Landroidx/compose/ui/node/PointerInputModifierNode;", "getPointerInput-OLwlOKw$annotations", "getPointerInput-OLwlOKw", "RotaryInput", "Landroidx/compose/ui/input/rotary/RotaryInputModifierNode;", "getRotaryInput-OLwlOKw$annotations", "getRotaryInput-OLwlOKw", "Semantics", "Landroidx/compose/ui/node/SemanticsModifierNode;", "getSemantics-OLwlOKw$annotations", "getSemantics-OLwlOKw", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeKind.kt */
public final class Nodes {
    public static final Nodes INSTANCE = new Nodes();

    @JvmStatic
    /* renamed from: getAny-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m5137getAnyOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getDraw-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m5139getDrawOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getFocusEvent-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m5141getFocusEventOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getFocusProperties-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m5143getFocusPropertiesOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getFocusTarget-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m5145getFocusTargetOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getGlobalPositionAware-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m5147getGlobalPositionAwareOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getIntermediateMeasure-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m5149getIntermediateMeasureOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getKeyInput-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m5151getKeyInputOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getLayout-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m5153getLayoutOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getLayoutAware-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m5155getLayoutAwareOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getLocals-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m5157getLocalsOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getParentData-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m5159getParentDataOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getPointerInput-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m5161getPointerInputOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getRotaryInput-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m5163getRotaryInputOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getSemantics-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m5165getSemanticsOLwlOKw$annotations() {
    }

    private Nodes() {
    }

    /* renamed from: getAny-OLwlOKw  reason: not valid java name */
    public static final int m5136getAnyOLwlOKw() {
        return NodeKind.m5123constructorimpl(1);
    }

    /* renamed from: getLayout-OLwlOKw  reason: not valid java name */
    public static final int m5152getLayoutOLwlOKw() {
        return NodeKind.m5123constructorimpl(2);
    }

    /* renamed from: getDraw-OLwlOKw  reason: not valid java name */
    public static final int m5138getDrawOLwlOKw() {
        return NodeKind.m5123constructorimpl(4);
    }

    /* renamed from: getSemantics-OLwlOKw  reason: not valid java name */
    public static final int m5164getSemanticsOLwlOKw() {
        return NodeKind.m5123constructorimpl(8);
    }

    /* renamed from: getPointerInput-OLwlOKw  reason: not valid java name */
    public static final int m5160getPointerInputOLwlOKw() {
        return NodeKind.m5123constructorimpl(16);
    }

    /* renamed from: getLocals-OLwlOKw  reason: not valid java name */
    public static final int m5156getLocalsOLwlOKw() {
        return NodeKind.m5123constructorimpl(32);
    }

    /* renamed from: getParentData-OLwlOKw  reason: not valid java name */
    public static final int m5158getParentDataOLwlOKw() {
        return NodeKind.m5123constructorimpl(64);
    }

    /* renamed from: getLayoutAware-OLwlOKw  reason: not valid java name */
    public static final int m5154getLayoutAwareOLwlOKw() {
        return NodeKind.m5123constructorimpl(128);
    }

    /* renamed from: getGlobalPositionAware-OLwlOKw  reason: not valid java name */
    public static final int m5146getGlobalPositionAwareOLwlOKw() {
        return NodeKind.m5123constructorimpl(256);
    }

    /* renamed from: getIntermediateMeasure-OLwlOKw  reason: not valid java name */
    public static final int m5148getIntermediateMeasureOLwlOKw() {
        return NodeKind.m5123constructorimpl(512);
    }

    /* renamed from: getFocusTarget-OLwlOKw  reason: not valid java name */
    public static final int m5144getFocusTargetOLwlOKw() {
        return NodeKind.m5123constructorimpl(1024);
    }

    /* renamed from: getFocusProperties-OLwlOKw  reason: not valid java name */
    public static final int m5142getFocusPropertiesOLwlOKw() {
        return NodeKind.m5123constructorimpl(2048);
    }

    /* renamed from: getFocusEvent-OLwlOKw  reason: not valid java name */
    public static final int m5140getFocusEventOLwlOKw() {
        return NodeKind.m5123constructorimpl(4096);
    }

    /* renamed from: getKeyInput-OLwlOKw  reason: not valid java name */
    public static final int m5150getKeyInputOLwlOKw() {
        return NodeKind.m5123constructorimpl(8192);
    }

    /* renamed from: getRotaryInput-OLwlOKw  reason: not valid java name */
    public static final int m5162getRotaryInputOLwlOKw() {
        return NodeKind.m5123constructorimpl(16384);
    }
}
