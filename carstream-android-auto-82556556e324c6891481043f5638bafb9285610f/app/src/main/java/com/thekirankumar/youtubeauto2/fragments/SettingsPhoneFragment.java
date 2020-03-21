package com.thekirankumar.youtubeauto2.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.thekirankumar.youtubeauto2.R;


public class SettingsPhoneFragment extends PreferenceFragment {

    public SettingsPhoneFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}
