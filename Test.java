package comp2402a4;

import java.util.Random;

public class Test {
    
    public static void main(String args[]){

        RyabkoTree tree = new RyabkoTree();
        SlowPrefixStack stack = new SlowPrefixStack();
        Random rand = new Random();
        int x;

        for(int i = 0; i < 10; i++){
            x = rand.nextInt(9) + 1;
            stack.push(x);
            tree.push(x);
        }
        System.out.println(tree.pop());
        tree.push(10);
        tree.set(3, 4);
        System.out.println(tree.pop());
        
        //print values
        System.out.print("[");
        for(int i = 0; i < tree.size() - 1; i++){
            System.out.print(Integer.toString(tree.get(i)) + ", ");
        }
        System.out.println(Integer.toString(tree.get(tree.size() - 1)) + "]");
        
        //print indices
        System.out.print("[");
        for(int i = 0; i < tree.size() - 1; i++){
            System.out.print(Integer.toString(i) + ", ");
        }
        System.out.println(Integer.toString(tree.size() - 1) + "]");

        //print out sums
        for(int i = 0; i < tree.size(); i++){
            System.out.println(Integer.toString(i) + ": " + Long.toString(tree.prefixSum(i)));
        }

        //auto test
        int sum = 0;
        for(int i = 0; i < tree.size(); i++){
            sum += tree.get(i);
        }
        if(sum == tree.prefixSum(tree.size()- 1)){
            System.out.println("Passed");
        }
        else{
            System.out.println("Failed");
        }
    }
}
