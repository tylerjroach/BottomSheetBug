# BottomSheetBug
Sample app to demonstrate a BottomSheet bug.

Some fragments are completely invisible when created using the bottom sheet from the support library.

When the bottom sheet is in a collapsed state, and setState(BottomSheetBehavior.STATE_EXPANDED) is requested with a new fragment transaction for the bottom sheet, the fragment will not show up.
