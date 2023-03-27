public class Sorting 
{
    //Functions used by the multiple methods below
    private static int findmax(Comparable [] list, int end)
    {
        int maxpos = 0;
        for(int j = 1; j <= end; j++)
        {
            if(list[maxpos].compareTo(list[j])<0)
                {maxpos = j;}
        }
        return maxpos;
    }

    private static void swap(Object [] list, int x, int y)
    {
        Object temp = list[x];
        list[x] = list[y];
        list[y] = temp;
    }
    //----------------------------------------------------------------------------
    //Selection
    public static void selection(Comparable [] list)
    {
        //Repeat, find the max by position, swap
        for(int i = list.length-1; i > 0; i--)
        {
            int maxpos = findmax(list, i);
            swap(list, i, maxpos);
        }
    }
    //----------------------------------------------------------------------------
    //Bubble
    public static void bubble(Comparable [] list)
    {
        boolean done = false;
        while(!done)
        {
            done = true;
            for(int i = 0; i+1 < list.length; i++)
            {
                if(list[i].compareTo(list[i + 1]) > 0)
                    {swap(list, i, i+1); done = false;}
            }
        }
    }
    //----------------------------------------------------------------------------
    //Insertion
    public static void insertion(Comparable [] list)
    {
        for(int toInsert = 1; toInsert < list.length; toInsert++)
        {
            Comparable saved = list[toInsert];
            int j;
            for(j = toInsert - 1; j >= 0; j--)
            {
                if(list[j].compareTo(saved) > 0)
                    {list[j+1] = list[j];}  //Slide larger items over
                else
                    {break;}
            }
            list[j + 1] = saved;
        }
    }
    //----------------------------------------------------------------------------
    //Shell
    public static void shell(Comparable [] list)
    {
        int gap = list.length / 5;
        while(gap >= 3)
        {
            for(int offset = 0; offset < gap; offset++)
            {
                shellSertion(list,gap,offset);
            }
            gap = (int) (gap / 2.2);
        }
        insertion(list);
    }

    //Insertion made for shell sort
    public static void shellSertion(Comparable [] list, int gap, int offset)
    {
        for(int toInsert = gap + offset; toInsert < list.length; toInsert += gap)
        {
            Comparable saved = list[toInsert];
            int j;
            for(j = toInsert - gap; j >= 0; j -= gap)
            {
                if(list[j].compareTo(saved) > 0)
                    {list[j+gap] = list[j];}  //Slide larger items over
                else
                    {break;}
            }
            list[j + gap] = saved;
        }
    }

    //----------------------------------------------------------------------------
    //Quick Sort
    private static int partition(Comparable [] list, int start, int stop)
    {//Return the array position of the pivot
        Comparable pivot = list[stop];
        int GoL = start; //First array possitions for items >= pivot
                     //OR, the array position to the right of the green line (Greater than or less than line) from the example below
        for(int i = start; i < stop; i++)   //i is the blue line (line of knowledge)
        {
            if(list[i].compareTo(pivot) < 0)
            {
                swap(list, i, GoL);
                GoL++;
            }
        }
        //Swap the pivot into position
        swap(list, stop, GoL);
        return GoL;
    }

    private static void quickHelp(Comparable [] list, int start, int stop)
    {
        if(stop <= start)
            {return;}
        if(start+1 == stop)
        {
            if(list[start].compareTo(list[stop]) > 0)
                {swap(list,start,stop);}
        }
        //Recursive Case
        int pivotPos = partition(list, start, stop);
        quickHelp(list,start,pivotPos - 1);
        quickHelp(list, pivotPos + 1, stop);
    }

    public static void quick(Comparable [] list)
    {
        quickHelp(list, 0, list.length -1);
    }

    //----------------------------------------------------------------------------
    //Merge Sort
    private static void mergeHelp(Comparable [] list, int start, int stop)
    {
        //base cases
        if(stop <= start)
            {return;}
        if(start + 1 == stop)
        {
            if(list[start].compareTo(list[stop]) > 0)
                {swap(list, start, stop);}
            return;
        }

        //recursive case
        int mid = (stop + start) / 2;
        mergeHelp(list, start, mid);
        mergeHelp(list, (mid + 1), stop);
        doMerge(list, start, mid, stop);
    }

    private static void doMerge(Comparable [] list, int start, int mid, int stop)
    {
        int left = start, right = mid + 1;
        Comparable [] A = new Comparable [stop - start+1];
        for(int i = 0; i < A.length; i++)
        {
            //Pull from the left if the right side is not empty or
            //left side is not empty and list[left] < list[right]
            if(right > stop || (left <= mid) && (list[left].compareTo(list[right]) < 0))
                {A[i] = list[left++];}
            else
                {A[i] = list[right++];}
        }
        //Copy A back to list
        for(int i = 0; i < A.length; i++)
            {list[start+i] = A[i];}
    }

    public static void merge(Comparable [] list)
    {
        mergeHelp(list, 0, list.length -1);
    }
}
/*
    Sorting
        Given an array of comparable objects, re-arrange them into non-decreasing order
    Sorts we'll learn:
        + Selection Sort: minimizes data moves
        + Insertion Sort: fast on almost-sorted data
            - Shell Sort
        + Bubble Sort: has poor performance and any other alternetives are better (it's used because it's easy and quick to write)
        + Quick Sort: } recursive     fast
        + Merge Sort: }           and

    Selection Sort (Repeat: 1. Find max - by position  |  2. Swap)
        |8| 1 7 2 6 3 5 4
        |4| 1 {7} 2 6 3 5 8

        Only O(n) data moves optimal
        O(n^2) running time
    
    Bubble Sort
        8 1 7 2 6 3 5 4
        1 8 7 2 6 3 5 4
        1 7 8 2 6 3 5 4
        1 7 2 8 6 3 5 4
        1 7 2 6 8 3 5 4
        1 7 2 6 3 8 5 4
        1 7 2 6 3 5 8 4
        1 7 2 6 3 5 4 8
        first pass ^ then...
        1 2 7 6 3 5 4 8
        etc.
        1 2 6 3 5 4 7 8
        second pass^ until...
        a pass goes through where a switch is not made, then we know we're done... i.e.
        1 2 3 4 5 6 7 8 (verified by the 5th pass)

        O(n^2) running time
        terrible, don't use it

    Insertion (this is a stable sort, meaning if two items are equal they keep their place)
        8 1 7 2 6 3 5 4
        _ the first item is sorted by itself...
        then take the second and sort it relative to the first item(8)
        1 8 7 2 6 3 5 4
        next, compare the third(7) to the first(8) and the second(1) items
        1 7 8 2 6 3 5 4
        then, compare the fourth(2) to the first(8), second(1), and third(7) items
        1 2 7 8 6 3 5 4
        etc. until...
        1 2 3 4 5 6 7 8
        This way works well if the list is "nearly sorted" because the more sorted it is, the less the old items have to slide to let in the
            new one
        O(n^2) (the benefit comes from the inner loop not running if the list is already sorted giving it a constant time)
    
    Shell
        30 1 29 2 28 3 27 4 26 5 25 6 24 7 23 8 22 9 21 10 20 11 19 12 18 13 17 14 16 15
        We'll be using a gap size of 4, so...
        30 28 26 24 22 20 18 16
        are our selected numbers for group 1, then group 2...
        1 3 5 7 9 11 13 15
        group 3...
        29 27 25 23 21 19 17
        and group 4...
        2 4 6 8 10 12 14
        Next, sort each group in order
        Group 1: 16 18 20 22 24 26 28 30
        Group 2: 1 3 5 7 9 11 13 15
        Group 3: 17 19 21 23 25 27 29
        Group 4: 2 4 6 8 10 12 14
        then, they're re-written as a full list...
        16 1 17 2 18 3 19 4 20 5 21 6 22 7 23 8 24 9 25 10 26 11 27 12 28 13 29 14 30 15
        Now they'll be regrouped in groups of 3
        Group 1: 16 2 19 5 22 8 25 11 28 14
            Becomes: 2 5 8 11 14 16 19 22 25 28
        Group 2: 1 18 4 21 7 24 10 27 13 30
            Becomes: 1 4 7 10 13 18 21 24 27 30
        Group 3: 17 3 20 6 23 9 26 12 29 15
            Becomes: 3 6 9 12 15 17 20 23 26 29
        So the list now looks like...
        2 1 3 5 4 6 8 7 9 11 10 12 14 13 15...
        Start with gap = n / 5 ish (rounded down), for each offset (1 per gap) sort with insertion sort, and then gap = gap/2 * 2 and repeat
            until the gap is less than three, then do a final run of insertion sort on the whole list
        This does not a definitive computable running time, but it's behavior in practice runs at O(n(log n)^2)

    Quick Sort
        (Recursive) 
        Base Case: listSize == 0 || listSize == 1 || listSize == 2
        Recursive Case: Partition
            Goal: [ , , {}, , ]
            {} = pivot, so things that are less than the pivot are put on it's left and greater than or equal to are on the right
                then recursive on the 2 halves (either side of the first pivot)
            Ex.
                8 1 7 2 6 3 5 [4] so, 4 is the first pivot and it will sort the following...
                [[< pivot] [>= pivot] [yet unmeasured numbers] [pivot]]
                Imagine a "line of knowledge" as | and the greater or less then line as /so starting...
                / | 8 1 7 2 6 3 5 [4]
                / 8 | 1 7 2 6 3 5 [4]
                1 / 8 | 7 2 6 3 5 [4]
                1 / 8 7 | 2 6 3 5 [4]
                here the 2 takes the 8's spot and the 8 the 2's
                1 2 / 7 8 | 6 3 5 [4]
                1 2 / 7 8 6 | 3 5 [4]
                1 2 3 / 8 6 7 | 5 [4]
                and we're done, besides swapping the pivot before the one greater than to it
                1 2 3 [4] 6 7 5 8
                Then this happens recursively on either half of the pivot, so two new pivots are created
                1 2 [3] | 4 | 6 7 5 [8]
                and four becomes unmoved
        Running Time
            T(0) = T(1) = 3
            T(2) = 4
            T(n) = O(n) + T(n/2) + T(n/2)
                partition   left    right
                            ^ guessing it's about a half
            Handy Wavy "Proof"
              {             n
              { [       []  ]   O(n) time
              { [ []   ] [  [] ]   2 * O(n/2)
              { [ []] [     [] ] [  [] ] [  []] 4 * O(n/4)
              { until...
              { [] [] [] [] ... [] n pieces of size 1 (n * O(1))
              ^ recursion depth: O(log(base 2)n)
        Average Case
            T(0) = T(1) = 3
            T(n) = n + T(L half) + T(R half)
                and we know L + R = n - 1
            so L can = (T(0) + T(1) + ... T(n-1)) / n and R can = T(n-1) + T(n-2) + ... T(0)
            and since they're both equal it can be simplified too...
            T(n) = n + 2 * (n-1)Sigma(i=0) (T(i)/n)
            nT(n) = n**2 + 2 * (n-1)Sigma(i=0) T(i)
            (n-1)T(n-1) = (n-1)**2 + 2 * (n-2)Sigma(i=0) T(i)
            nT(n) - (n-1)T(n-1) = n**2 - (n-1)**2 + 2 * T(n-1)
            nT(n) = (n+1)T(n-1) + 2n - 1
            divided by n(n+1)
            T(n)/(n+1) = (T(n-1)/n) + (2n-1/(n(n+1)))
                                          ^ we'll take this -1 and ignore it (because it makes it easier)
            T(n)/(n+1) = (T(n-1)/n) + (2/(n+1))
            We'll do a substitution to make this even easier... s(k) = T(k)/(k+1)
            which means s(k-1) = T(k-1)/k
                s(n) = s(n-1) + 2/(n+1)
                s(0) = 3
                s(1) = 3/2
                s(2) = s(1) + 2/3
                s(3) = s(2) + 2/4
                s(n) = (3/2) + (2/3) + (2/4) + (2/5) + (2/6) + ... + 2/(n+1)
                then if we factor out a 2 in s(n) we get...
                2(1/3) + (1/3) + (1/4) + (1/5) + ... + 1/(n+1)
                (1/1) + (1/2) + (1/3) +(1/4) + ... + (1/n) = H(n)
                (n)sigma(i=1) (1/i) ~= nS1 (1/x) dx = 1n(n)
                H(n) = 0(log n)
                so... s(n) = O(logn)
            T(n) = (n+1)S(n) = O(nlogn)
            so... quick sorts average running time is O(nlogn)
    Merge
        8 1 7 2 6 3 5 4
        Divided into two halfs
        8 1 7 2 | 6 3 5 4
        Recursively sort each half using the "half faith rule" (8 1 | 7 2 | 6 3 | 5 4, then merge sort)
        1 2 7 8 | 3 4 5 6
        Then merge each half...
        [1] 2 7 8 | [3] 4 5 6
        1 is smaller so it's copied: 1
        [2] 7 8 | [3] 4 5 6
        2 is smaller so it's copied: 1 2
        [7] 8 | [3] 4 5 6
        3 is smaller so it's copied: 1 2 3... etc. until...
        1 2 3 4 5 6 7 8 then copy back (requiring extra space to store this copy and the original until the original is replaced with the copy)
        O(log(n)) running time (again the downside is the extra space and data copying it does)
*/