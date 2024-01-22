package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.ContentInViewModifier;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J<\u0010\u0011\u001a\u00020\u000b2#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000b0\u0013H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010\u0018\u001a\u00020\u000fJ\u0006\u0010\u0019\u001a\u00020\u000bJ<\u0010\u001a\u001a\u00020\u000b2#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f0\u0013H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "", "()V", "requests", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/gestures/ContentInViewModifier$Request;", "size", "", "getSize", "()I", "cancelAndRemoveAll", "", "cause", "", "enqueue", "", "request", "forEachFromSmallest", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Rect;", "Lkotlin/ParameterName;", "name", "bounds", "isEmpty", "resumeAndRemoveAll", "resumeAndRemoveWhile", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BringIntoViewRequestPriorityQueue.kt */
public final class BringIntoViewRequestPriorityQueue {
    /* access modifiers changed from: private */
    public final MutableVector<ContentInViewModifier.Request> requests = new MutableVector<>(new ContentInViewModifier.Request[16], 0);

    public final int getSize() {
        return this.requests.getSize();
    }

    public final boolean isEmpty() {
        return this.requests.isEmpty();
    }

    public final boolean enqueue(ContentInViewModifier.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Rect requestBounds = request.getCurrentBounds().invoke();
        if (requestBounds == null) {
            BringIntoViewRequestPriorityQueue bringIntoViewRequestPriorityQueue = this;
            Result.Companion companion = Result.Companion;
            request.getContinuation().resumeWith(Result.m6273constructorimpl(Unit.INSTANCE));
            return false;
        }
        request.getContinuation().invokeOnCancellation(new BringIntoViewRequestPriorityQueue$enqueue$1(this, request));
        IntRange intRange = new IntRange(0, this.requests.getSize() - 1);
        int first = intRange.getFirst();
        int i = intRange.getLast();
        if (first <= i) {
            while (true) {
                Rect rBounds = ((ContentInViewModifier.Request) this.requests.getContent()[i]).getCurrentBounds().invoke();
                if (rBounds != null) {
                    Rect intersection = requestBounds.intersect(rBounds);
                    if (Intrinsics.areEqual((Object) intersection, (Object) requestBounds)) {
                        this.requests.add(i + 1, request);
                        return true;
                    } else if (!Intrinsics.areEqual((Object) intersection, (Object) rBounds)) {
                        CancellationException cause = new CancellationException("bringIntoView call interrupted by a newer, non-overlapping call");
                        int j = this.requests.getSize() - 1;
                        if (j <= i) {
                            while (true) {
                                ((ContentInViewModifier.Request) this.requests.getContent()[i]).getContinuation().cancel(cause);
                                if (j == i) {
                                    break;
                                }
                                j++;
                            }
                        }
                    }
                }
                if (i == first) {
                    break;
                }
                i--;
            }
        }
        this.requests.add(0, request);
        return true;
    }

    public final void forEachFromSmallest(Function1<? super Rect, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        MutableVector this_$iv = this.requests;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = size$iv - 1;
            Object[] content$iv = this_$iv.getContent();
            do {
                block.invoke(((ContentInViewModifier.Request) content$iv[i$iv]).getCurrentBounds().invoke());
                i$iv--;
            } while (i$iv >= 0);
        }
    }

    public final void resumeAndRemoveAll() {
        IntRange intRange = new IntRange(0, this.requests.getSize() - 1);
        int i = intRange.getFirst();
        int last = intRange.getLast();
        if (i <= last) {
            while (true) {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                ((ContentInViewModifier.Request) this.requests.getContent()[i]).getContinuation().resumeWith(Result.m6273constructorimpl(unit));
                if (i == last) {
                    break;
                }
                i++;
            }
        }
        this.requests.clear();
    }

    public final void resumeAndRemoveWhile(Function1<? super Rect, Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        while (this.requests.isNotEmpty() && block.invoke(((ContentInViewModifier.Request) this.requests.last()).getCurrentBounds().invoke()).booleanValue()) {
            Unit unit = Unit.INSTANCE;
            Result.Companion companion = Result.Companion;
            ((ContentInViewModifier.Request) this.requests.removeAt(this.requests.getSize() - 1)).getContinuation().resumeWith(Result.m6273constructorimpl(unit));
        }
    }

    public final void cancelAndRemoveAll(Throwable cause) {
        MutableVector this_$iv$iv = this.requests;
        int size = this_$iv$iv.getSize();
        CancellableContinuation[] cancellableContinuationArr = new CancellableContinuation[size];
        for (int i = 0; i < size; i++) {
            cancellableContinuationArr[i] = ((ContentInViewModifier.Request) this_$iv$iv.getContent()[i]).getContinuation();
        }
        for (CancellableContinuation it : cancellableContinuationArr) {
            it.cancel(cause);
        }
        if (!this.requests.isEmpty()) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }
}
