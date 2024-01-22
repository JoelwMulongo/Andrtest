package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ!\u0010\u000b\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\rH\u0000¢\u0006\u0002\b\u000fJ\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\u0012R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester;", "", "()V", "focusRequesterNodes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "getFocusRequesterNodes$ui_release$annotations", "getFocusRequesterNodes$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "captureFocus", "", "findFocusTarget", "onFound", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "findFocusTarget$ui_release", "freeFocus", "requestFocus", "", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusRequester.kt */
public final class FocusRequester {
    public static final int $stable = 0;
    /* access modifiers changed from: private */
    public static final FocusRequester Cancel = new FocusRequester();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final FocusRequester Default = new FocusRequester();
    private final MutableVector<FocusRequesterModifierNode> focusRequesterNodes = new MutableVector<>(new FocusRequesterModifierNode[16], 0);

    public static /* synthetic */ void getFocusRequesterNodes$ui_release$annotations() {
    }

    public final MutableVector<FocusRequesterModifierNode> getFocusRequesterNodes$ui_release() {
        return this.focusRequesterNodes;
    }

    public final void requestFocus() {
        findFocusTarget$ui_release(FocusRequester$requestFocus$1.INSTANCE);
    }

    public final boolean findFocusTarget$ui_release(Function1<? super FocusTargetModifierNode, Boolean> onFound) {
        Function1<? super FocusTargetModifierNode, Boolean> function1 = onFound;
        Intrinsics.checkNotNullParameter(function1, "onFound");
        if (!(!Intrinsics.areEqual((Object) this, (Object) Default))) {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
        } else if (!(!Intrinsics.areEqual((Object) this, (Object) Cancel))) {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
        } else if (this.focusRequesterNodes.isNotEmpty()) {
            boolean success = false;
            MutableVector this_$iv = this.focusRequesterNodes;
            int size$iv = this_$iv.getSize();
            if (size$iv > 0) {
                int i$iv = 0;
                Object[] content$iv = this_$iv.getContent();
                while (true) {
                    int mask$iv$iv = NodeKind.m5123constructorimpl(1024);
                    DelegatableNode $this$visitChildren$iv$iv = (FocusRequesterModifierNode) content$iv[i$iv];
                    if ($this$visitChildren$iv$iv.getNode().isAttached()) {
                        boolean success2 = success;
                        MutableVector this_$iv2 = this_$iv;
                        MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                        Modifier.Node child$iv$iv = $this$visitChildren$iv$iv.getNode().getChild$ui_release();
                        if (child$iv$iv == null) {
                            DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitChildren$iv$iv.getNode());
                        } else {
                            branches$iv$iv.add(child$iv$iv);
                        }
                        while (true) {
                            if (!branches$iv$iv.isNotEmpty()) {
                                Modifier.Node node = child$iv$iv;
                                success = success2;
                                break;
                            }
                            Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
                            if ((branch$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                                Modifier.Node node$iv$iv = branch$iv$iv;
                                while (true) {
                                    if (node$iv$iv == null) {
                                        Modifier.Node node2 = child$iv$iv;
                                        break;
                                    } else if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                                        MutableVector branches$iv$iv2 = branches$iv$iv;
                                        Modifier.Node it$iv = node$iv$iv;
                                        Modifier.Node child$iv$iv2 = child$iv$iv;
                                        if ((it$iv instanceof FocusTargetModifierNode) && function1.invoke((FocusTargetModifierNode) it$iv).booleanValue()) {
                                            success = true;
                                            break;
                                        }
                                        child$iv$iv = child$iv$iv2;
                                        branches$iv$iv = branches$iv$iv2;
                                    } else {
                                        Modifier.Node node3 = child$iv$iv;
                                        node$iv$iv = node$iv$iv.getChild$ui_release();
                                    }
                                }
                            } else {
                                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                            }
                        }
                        i$iv++;
                        if (i$iv >= size$iv) {
                            break;
                        }
                        this_$iv = this_$iv2;
                    } else {
                        boolean z = success;
                        throw new IllegalStateException("Check failed.".toString());
                    }
                }
            } else {
                MutableVector mutableVector = this_$iv;
            }
            return success;
        } else {
            throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        }
    }

    public final boolean captureFocus() {
        if (this.focusRequesterNodes.isNotEmpty()) {
            MutableVector this_$iv = this.focusRequesterNodes;
            int size$iv = this_$iv.getSize();
            if (size$iv <= 0) {
                return false;
            }
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            while (!FocusRequesterModifierNodeKt.captureFocus((FocusRequesterModifierNode) content$iv[i$iv])) {
                i$iv++;
                if (i$iv >= size$iv) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
    }

    public final boolean freeFocus() {
        if (this.focusRequesterNodes.isNotEmpty()) {
            MutableVector this_$iv = this.focusRequesterNodes;
            int size$iv = this_$iv.getSize();
            if (size$iv <= 0) {
                return false;
            }
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            while (!FocusRequesterModifierNodeKt.freeFocus((FocusRequesterModifierNode) content$iv[i$iv])) {
                i$iv++;
                if (i$iv >= size$iv) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007R\u001c\u0010\u0003\u001a\u00020\u00048GX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester$Companion;", "", "()V", "Cancel", "Landroidx/compose/ui/focus/FocusRequester;", "getCancel$annotations", "getCancel", "()Landroidx/compose/ui/focus/FocusRequester;", "Default", "getDefault", "createRefs", "Landroidx/compose/ui/focus/FocusRequester$Companion$FocusRequesterFactory;", "FocusRequesterFactory", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusRequester.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCancel$annotations() {
        }

        private Companion() {
        }

        public final FocusRequester getDefault() {
            return FocusRequester.Default;
        }

        public final FocusRequester getCancel() {
            return FocusRequester.Cancel;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0002J\t\u0010\u0006\u001a\u00020\u0004H\u0002J\t\u0010\u0007\u001a\u00020\u0004H\u0002J\t\u0010\b\u001a\u00020\u0004H\u0002J\t\u0010\t\u001a\u00020\u0004H\u0002J\t\u0010\n\u001a\u00020\u0004H\u0002J\t\u0010\u000b\u001a\u00020\u0004H\u0002J\t\u0010\f\u001a\u00020\u0004H\u0002J\t\u0010\r\u001a\u00020\u0004H\u0002J\t\u0010\u000e\u001a\u00020\u0004H\u0002J\t\u0010\u000f\u001a\u00020\u0004H\u0002J\t\u0010\u0010\u001a\u00020\u0004H\u0002J\t\u0010\u0011\u001a\u00020\u0004H\u0002J\t\u0010\u0012\u001a\u00020\u0004H\u0002J\t\u0010\u0013\u001a\u00020\u0004H\u0002¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester$Companion$FocusRequesterFactory;", "", "()V", "component1", "Landroidx/compose/ui/focus/FocusRequester;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: FocusRequester.kt */
        public static final class FocusRequesterFactory {
            public static final int $stable = 0;
            public static final FocusRequesterFactory INSTANCE = new FocusRequesterFactory();

            private FocusRequesterFactory() {
            }

            public final FocusRequester component1() {
                return new FocusRequester();
            }

            public final FocusRequester component2() {
                return new FocusRequester();
            }

            public final FocusRequester component3() {
                return new FocusRequester();
            }

            public final FocusRequester component4() {
                return new FocusRequester();
            }

            public final FocusRequester component5() {
                return new FocusRequester();
            }

            public final FocusRequester component6() {
                return new FocusRequester();
            }

            public final FocusRequester component7() {
                return new FocusRequester();
            }

            public final FocusRequester component8() {
                return new FocusRequester();
            }

            public final FocusRequester component9() {
                return new FocusRequester();
            }

            public final FocusRequester component10() {
                return new FocusRequester();
            }

            public final FocusRequester component11() {
                return new FocusRequester();
            }

            public final FocusRequester component12() {
                return new FocusRequester();
            }

            public final FocusRequester component13() {
                return new FocusRequester();
            }

            public final FocusRequester component14() {
                return new FocusRequester();
            }

            public final FocusRequester component15() {
                return new FocusRequester();
            }

            public final FocusRequester component16() {
                return new FocusRequester();
            }
        }

        public final FocusRequesterFactory createRefs() {
            return FocusRequesterFactory.INSTANCE;
        }
    }
}
