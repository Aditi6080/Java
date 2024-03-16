import java.util.*;
public class SortingAlgo{

    //selection sort's principle is select the minimum and just swap it.
    public static void SelectionSort(int [] arr, int n){ //n is the size of the array
        int i, j, temp, min;
        for(i=0; i<n-1; i++){
            min = i;
            for(j=i; j<n; j++){
                if(arr[min]> arr[j]){
                    min = j;
                }
            }
            temp=arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    //Bubble sort is all about push the maximum to the last of adjacent swaps
    public static void BubbleSort(int [] arr, int n){
        int i, j, temp;
        for(i=n-1; i>=1; i--){
            for(j=0; j<=i-1; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    //Insertion sort is basically take an element and place it in it's correct position
    public static void InsertionSort(int [] arr, int n){
        int i, j, temp;
        for(i=0; i<n; i++){
            j=i;
            while(j>0 && arr[j-1] > arr[j]){
                temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }


    //Merge sort is a recursive algorithm. Also known as divide and merge algorithm
    public static void MergeSort(int [] arr, int l, int r){
        if(l>=r){
            return;
        }
        int mid = (l+r)/2;
        MergeSort(arr, l, mid); //left half
        MergeSort(arr, mid+1, r); //right half
        merge(arr, l, mid, r);
    }
    public static void merge(int [] arr, int l, int mid, int r){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = l; //stating index of left half of array
        int right = mid+1; //stating index of rigth half of array

        //storing elements in the temp array in sorted manner
        while(left<=mid && right<=r){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }

        //if the elements of left half are still left
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }

        //if the elements of right half are still left
        while(right<=r){
            temp.add(arr[right]);
            right++;
        }

        //transferring all the elments from temp to arr
        for(int i=l; i<=r; i++){
            arr[i] = temp.get(i-l);
        }
    }


    //Pick a pivot and place it in its correct place in sorted array
    public static void QuickSort(int [] arr, int startIndex, int endIndex){
        if(startIndex < endIndex){
            int partIndex = partition(arr, startIndex, endIndex);
            QuickSort(arr, startIndex, partIndex-1);
            QuickSort(arr, partIndex+1, endIndex);
        }
    }
    public static int partition (int [] arr, int startIndex, int endIndex){
        int pivot = arr[startIndex];
        int i = startIndex;
        int j = endIndex;
        while(i<j){
            while(i<=endIndex && arr[i] <= pivot){
                i++;
            }
            while(j>= startIndex && arr[j] > pivot){
                j--;
            }
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[startIndex];
        arr[startIndex] = arr[j];
        arr[j] = temp;
        return j;
    }
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in array");
        int n = sc.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter array elements");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        //SelectionSort(arr, n);
        //BubbleSort(arr, n);
        //InsertionSort(arr, n);
        //MergeSort(arr, 0, n-1);
        QuickSort(arr, 0, n-1);
        System.out.println("After sorting..");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }
}