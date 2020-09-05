package com.ndhlangisa.treehouse.smellslikebaking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class ViewPagerFragment extends Fragment {
    public static final String KEY_RECIPE_INDEX = "recipe_index";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(KEY_RECIPE_INDEX);
//        Toast.makeText(getActivity(), Recipes.names[index], Toast.LENGTH_SHORT).show();

        getActivity().setTitle(Recipes.names[index]);
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);

        final IngredientsFragment ingredientsFragment = new IngredientsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX, index);
        ingredientsFragment.setArguments(bundle);

        final DirectionsFragment directionsFragments = new DirectionsFragment();
        bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX, index);
        directionsFragments.setArguments(bundle);

        ViewPager viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            //when dealing with fragments within fragments
            //use the ChildFragmentManager
            @Override
            public Fragment getItem(int position) {
                return position == 0 ? ingredientsFragment : directionsFragments;

//                if(position == 0)
//                    return ingredientsFragment;
//                return directionsFragments;


//                if(position == 0){
//                    return ingredientsFragment;
//                }else {
//                    return directionsFragments;
//                }
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                //naming of the tabs or text
                return position == 0 ? "Ingredients" : "Directions";
            }

            @Override
            public int getCount() {
                return 2;//n# of fragments
            }
        });

        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();

        //setting title back to application's name
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
