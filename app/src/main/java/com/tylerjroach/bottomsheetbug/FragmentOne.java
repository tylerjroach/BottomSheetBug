package com.tylerjroach.bottomsheetbug;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentOne extends Fragment {

  private Button openBottomSheet;

  public FragmentOne() {
    // Required empty public constructor
  }

  public static FragmentOne newInstance() {
    FragmentOne fragment = new FragmentOne();
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_one, container, false);

    openBottomSheet = (Button) rootView.findViewById(R.id.open_bottom_sheet);

    openBottomSheet.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        ((MainActivity)getActivity()).openBottomSheet();
      }
    });

    return rootView;
  }
}
