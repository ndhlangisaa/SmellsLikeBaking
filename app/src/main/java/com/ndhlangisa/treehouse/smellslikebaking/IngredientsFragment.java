package com.ndhlangisa.treehouse.smellslikebaking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class IngredientsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);

        LinearLayout linearLayout = view.findViewById(R.id.ingredientsLayout);
        String[] ingredients = Recipes.ingredients[index].split("`");
        setupCheckboxes(ingredients, linearLayout);

        return view;
    }

    private void setupCheckboxes(String[] ingredients, ViewGroup container){
        for (String ingredient : ingredients){
            CheckBox checkBox = new CheckBox(getActivity());
            checkBox.setPadding(8, 16, 8, 16);
            checkBox.setTextSize(20f);
            checkBox.setText(ingredient);
            container.addView(checkBox);
        }
    }
}
