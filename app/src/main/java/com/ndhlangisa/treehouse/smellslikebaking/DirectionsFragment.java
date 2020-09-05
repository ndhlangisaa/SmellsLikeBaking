package com.ndhlangisa.treehouse.smellslikebaking;

public class DirectionsFragment extends CheckboxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recipes.directions[index].split("`");
    }
}
