package com.tylerjroach.bottomsheetbug;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.Random;

public class BottomSheetFragment extends Fragment {

  FrameLayout bottomSheetView;

  public BottomSheetFragment() {
    // Required empty public constructor
  }

  public static BottomSheetFragment newInstance() {
    BottomSheetFragment fragment = new BottomSheetFragment();
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment

    View rootView = inflater.inflate(R.layout.fragment_bottom_sheet, container, false);
    bottomSheetView = (FrameLayout) rootView.findViewById(R.id.bottom_sheet_view);

    Random random = new Random();
    int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
    bottomSheetView.setBackgroundColor(color);

    return rootView;
  }
}
