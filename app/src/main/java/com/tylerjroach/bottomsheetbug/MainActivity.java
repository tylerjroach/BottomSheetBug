package com.tylerjroach.bottomsheetbug;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

  private BottomSheetBehavior bottomSheetBehavior;
  private FrameLayout bottomSheet;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (savedInstanceState == null) {
      getSupportFragmentManager()
          .beginTransaction()
          .replace(R.id.fragment_container, FragmentOne.newInstance(), FragmentOne.class.getName())
          .commit();
    }

    bottomSheet = (FrameLayout) findViewById(R.id.bottom_sheet_container);

    bottomSheetBehavior = (BottomSheetBehavior) BottomSheetBehavior.from(bottomSheet);
    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    bottomSheetBehavior.setPeekHeight(200);
    bottomSheetBehavior.setHideable(false);
    bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
      @Override public void onStateChanged(@NonNull View bottomSheet, int newState) {

      }

      @Override public void onSlide(@NonNull View bottomSheet, float slideOffset) {

      }
    });
  }

  public void openBottomSheet() {

    Fragment oldBottomSheet = getSupportFragmentManager().findFragmentByTag(BottomSheetFragment.class.getName());
    if (oldBottomSheet != null) {
      getSupportFragmentManager()
          .beginTransaction()
          .remove(oldBottomSheet)
          .commit();

      getSupportFragmentManager().executePendingTransactions();
    }

    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.bottom_sheet_container, BottomSheetFragment.newInstance(), BottomSheetFragment.class.getName())
        .commit();
    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
  }

}
