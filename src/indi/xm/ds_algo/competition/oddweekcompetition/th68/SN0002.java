package indi.xm.ds_algo.competition.oddweekcompetition.th68;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SN0002 {

    // 暴力 tle了
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        List<String> ret = new ArrayList<>();
        List<String> supplyList = new ArrayList<>(Arrays.asList(supplies));
        // 第一次遍历做不出来的菜
        // key - 菜名，value - 原料index
        HashMap<String,Integer> firstNot = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            int ingredientNums = ingredients.get(i).size();
            for (String ingredient : ingredients.get(i)) {
                if (supplyList.contains(ingredient)) {
                    ingredientNums --;
                }
            }
            if (ingredientNums == 0){
                supplyList.add(recipes[i]);
                ret.add(recipes[i]);
            }
            else {
                firstNot.put(recipes[i],i);
            }
        }

        while (true){
            int pre = firstNot.size();
            ArrayList<String> keys = new ArrayList<>();
            firstNot.forEach((key, value) -> {
                int ingredientNums = ingredients.get(value).size();
                for (String ingredient : ingredients.get(value)) {
                    if (supplyList.contains(ingredient)) {
                        ingredientNums--;
                    }
                }
                if (ingredientNums == 0) {
                    supplyList.add(key);
                    ret.add(key);
                    keys.add(key);
                }
            });
            for (String key : keys) {
                firstNot.remove(key);
            }
            int end = firstNot.size();
            if (end == pre || firstNot.isEmpty()) break;
        }
        return ret;
    }



    @Test
    public void test(){
//        StringUtils.replaceMid("[\"yeast\",\"flour\",\"meat\"]");

        String[] recipes = new String[]{"sandwich", "bread"};
        String[] supplies = new String[]{"yeast","flour","meat"};
        List<List<String>> ingredients = new ArrayList<>();
        ArrayList<String> aa = new ArrayList<>();
        aa.add("yeast");
        aa.add("flour");
        ArrayList<String> bb = new ArrayList<>();
        bb.add("bread");
        bb.add("meat");
//        ingredients.add(aa);
        ingredients.add(bb);
        ingredients.add(aa);
        System.out.println(findAllRecipes(recipes, ingredients, supplies));
    }

}
