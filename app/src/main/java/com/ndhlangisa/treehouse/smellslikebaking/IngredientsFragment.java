package com.ndhlangisa.treehouse.smellslikebaking;

public class IngredientsFragment extends CheckboxesFragment{

    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
