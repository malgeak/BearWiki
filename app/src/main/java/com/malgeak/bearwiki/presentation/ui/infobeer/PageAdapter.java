package com.malgeak.bearwiki.presentation.ui.infobeer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragmentsArrayList = new ArrayList<>();
    ArrayList<String> stringArrayList = new ArrayList<>();

    public PageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    public void addFragmet(Fragment fragment, String s) {
        fragmentsArrayList.add(fragment);
        stringArrayList.add(s);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentsArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsArrayList.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return stringArrayList.get(position);
    }
}
