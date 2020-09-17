import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Kclosestpoints {
    public static void main(String args[]){
        int x[]= {1,2,3,5};
        int y[]={0,1,6,8};
        int n = x.length;
        kclosest(x,y,n,2);

//        public void pair{
//            int first, second;
//            Pair(int a, int b)
//            {
//                first = a;
//                second = b;
//            }
//
//            public int compareTo(Pair o)
//            {
//                int x1 = first * first;
//                int y1 = second * second;
//                int x2 = o.first * o.first;
//                int y2 = o.second * o.second;
//                return (x1 + y1) - (x2 + y2);
//            }
//        }

    }

    private static void kclosest(int[] x, int[] y, int n, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<> ();
        for (int i = 0; i < n; i++) {
            pq.add ( new Pair ( x[i], y[i] ) );
        }
        if (pq.size () > k) {
            pq.poll ();
//             System.out.println(pq.first +
//                     " " + pq.second);
//         }


          //  return false;

        }
    }

}
