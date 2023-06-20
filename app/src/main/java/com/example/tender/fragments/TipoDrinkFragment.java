package com.example.tender.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tender.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class TipoDrinkFragment extends Fragment {
    ViewPager2 viewPager2 ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tipo_drink, container, false);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Menu");
        }
        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tab_layout);
        viewPager2 = view.findViewById(R.id.viewPager2);
        List<String> titlesTab = new ArrayList<>();
        titlesTab.add("Cocktail");
        titlesTab.add("Frullati");
        setViewPagerAdapter();
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> tab.setText(titlesTab.get(position))).attach();
        return view;
    }
    public void setViewPagerAdapter() {
        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(getActivity());
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new CocktailFragment());
        fragmentList.add(new FrullatoFragment());
        viewPager2Adapter.setData(fragmentList);
        viewPager2.setAdapter(viewPager2Adapter);
    }

    public static class ViewPager2Adapter extends FragmentStateAdapter{
        private ArrayList<Fragment> fragments;

        public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }
        public void setData(ArrayList<Fragment> fragments) {
            this.fragments = fragments;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragments.get(position);
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }
}
