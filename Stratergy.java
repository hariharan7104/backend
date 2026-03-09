import java.util.*;
interface Sorting{
    public void sort(int a[]);
}
class BubbleSort implements Sorting {

    public void sort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] < arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
    }
}
class MergeSort implements Sorting{
    public void sort(int a[]){
        mergeSort(a,0,a.length-1);
    }

    public static void mergeSort(int arr[], int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int arr[], int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
 class SelectionSort implements Sorting {

    public void sort(int arr[]) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }

            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

        }
    }
}
class Sort{

    Sorting s;
    Sort(Sorting p){
        s=p;

    }
    void sort(int a[]){
        s.sort(a);
    }
    void changetechnique(Sorting s){
        this.s=s;
    }

}
class Stratergy{
    public static void main(String args[]){
        int a[]={21,3,82,45,90,12,18};
        MergeSort m=new MergeSort();
        BubbleSort b=new BubbleSort();
        SelectionSort s=new SelectionSort();
        Sort sam=new Sort(b);
        sam.sort(a);
        System.out.println(Arrays.toString(a));
        sam.changetechnique(m);
        sam.sort(a);
        System.out.println(Arrays.toString(a));

    }
}