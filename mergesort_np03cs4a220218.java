import java.util.*;
public class  mergesort_np03cs4a220218 {
    
    ArrayList getInput(ArrayList<Integer> al){
        //Creating  Scanner class
        Scanner ab= new Scanner(System.in);
        System.out.print("Enter length of ArrayList : ");
        int len = ab.nextInt();
        for(int a =0;a<len;a++){
        //Asking to input element    
        System.out.print("Enter Array Element : ");
        int element = ab.nextInt(); 
        al.add(a,element);
        }
        return al;
        
    }
    
    void getOutput(ArrayList<Integer> al){
        System.out.print("Sorted arrayList is");
        System.out.println(al);
    }

    void merge(ArrayList<Integer> al, int beg, int mid, int end)
    {
        int z = beg, a= beg, f = mid + 1;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.addAll(al);
 
        // looping till no elements remain
        while (a <= mid && f <= end)
        {
    
        //Comparing  to get greater number
            if (al.get(a) < al.get(f)) {    
                arr.add(z++,al.get(a++));
            } 
            else {
                 arr.add(z++,al.get(f++));
            }
        }
 
        // copy remaining elements 
        for(;a<=mid;a++){
            arr.add(z++,al.get(a));
        }
         for(;f<=end;f++){
            arr.add(z++,al.get(f));
        }
 
        // Copy arr array list value to initial array list
        for (a = beg; a <= end; a++) {
            al.set(a,arr.get(a));
        }
    }
    
    void sort(ArrayList<Integer> al,int start,int end)
    {
        int lo = start;
        int hi = end - 1;
        mergesort_np03cs4a220218 obj = new mergesort_np03cs4a220218(); 
        for (int p = 1; p<= hi - lo; p = 2*p)
        {
            for (int a = lo; a < hi; a += 2*p)
            {
                int from = a;
                int mid = a + p - 1;
                int to = Integer.min(a + 2*p - 1, hi);
                obj.merge(al, from, mid, to);
            }
        }
    }
    public static void main(String[] args){     
        mergesort_np03cs4a220218 obj = new  mergesort_np03cs4a220218();
        ArrayList<Integer> array = new ArrayList<Integer>();
                array = obj.getInput(array);   
        System.out.println("Original ArrayList is " + array);
        obj.sort(array,0,array.size());
        obj.getOutput(array);
    }
}