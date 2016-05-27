(Update: See solution at bottom)

# BottomSheetBug
Sample app to demonstrate a BottomSheet bug.

Some fragments are completely invisible when created using the bottom sheet from the support library.

When the bottom sheet is in a collapsed state, and setState(BottomSheetBehavior.STATE_EXPANDED) is requested with a new fragment transaction for the bottom sheet, the fragment will not show up.


After reading this bug report https://code.google.com/p/android/issues/detail?id=202396, I found there was a note that you can't call setState before the view is laid out. In this case, the fragment view had yet to be drawn. Instead of trying to setState before or after the fragment transaction, you can run this code in onCreateView.

    rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
      @Override
      public void onGlobalLayout() {
        rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        ((MainActivity)getActivity()).expandBottomSheet();

      }
    });
    
    
Excuse some of the ugly shortcuts as this was quickly written to show the issue.
