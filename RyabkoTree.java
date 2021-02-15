package comp2402a4;

import java.util.ArrayList;
import java.util.Iterator;

public class RyabkoTree implements PrefixStack {

  ArrayList<Integer> stack;
  long[] tree;

  public RyabkoTree() {

   stack = new ArrayList<>();
   tree = new long[1];
  }

  public void push(int x) {
    
    stack.add(x);
    int i = stack.size();

    if(i + 1 > tree.length){
      resize();
    }

    while(i > 0){
      tree[i] += x;
      i -= i & (-i);
    }
  }

  public int pop() {
    
    int i = stack.size();
    int ele = stack.remove(stack.size() - 1);
    while(i > 0){
      tree[i] -= ele;
      i -= i & (-i);
    }

    if(3*i <= tree.length){
      //resize();
    }

    return ele;
  }

  public int get(int i) {
    
    return stack.get(i);
  }

  public int set(int i, int x) {

    int ele = stack.get(i);
    stack.set(i, x);
    i++;
    while(i > 0){
      tree[i] += x - ele;
      i -= i & (-i);
    }

    return ele;
  }

  public long prefixSum(int i) {

    int k = i;
    long nextSum = 0;
    long max = 0;
    int j = 1;
    i += 1;
    while(i <= size()){
      nextSum += tree[i];
      i += i & (-i);
    }
    while(j <= size()){
      max += tree[j];
      j += j & (-j);
    }

    return max - nextSum + stack.get(k);
  }

	public int size() {
    
    return stack.size();
	}

	public Iterator<Integer> iterator() {
    
	  return stack.iterator();
  }
  
  private void resize(){

    long[] a = new long[Math.max(stack.size()*2, 1)];
    for(int i = 1; i < stack.size(); i++){
      a[i] = tree[i];
    }
    tree = a;
  }
}
