package _1_Recurssion_easy_practice._7Backtracking;

import java.util.*;
class Practice_7_5_target_sum {
    static List<List<Integer>> findcombinations(int ind, int []arr, int target, List<List<Integer>>ans, List<Integer>ds)
    {
        if(target==0)
        {
            ArrayList<Integer> copy = new ArrayList<>();
            for(int i = 0;i<ds.size();i++){
                copy.add(ds.get(i));
            }
            System.out.println(copy);
            ans.add(copy);
        }
        if(ind>=arr.length)
        {
            return ans;
        }


        if(arr[ind]<=target)
        {
            ds.add(arr[ind]);
            return findcombinations(ind+1, arr, target-arr[ind], ans, ds);
        }


        int wrong_index = 0;
        int wrong_ans = 0;
        if(ds.size()>0) {
            wrong_index = ds.size() - 1;
            wrong_ans = ds.get(wrong_index);
            ds.remove(wrong_index);


        }

        return findcombinations(ind, arr, target + wrong_ans, ans, ds);

    }

    public static void main(String[] args) {



        int [] candidates = {2,5,6,7,4,3};
        int target =7;
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer>ds = new ArrayList();
        System.out.println( findcombinations(0,candidates,target,ans, ds));



    }
};