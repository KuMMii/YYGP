package boj_10989_수정렬하기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int N;
        int[] arr;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        mergeSort(arr, arr.length);


/*
        //insertion sort
        for (int i = 1; i < N; i++) {
            int key = arr[i];
            int j=i-1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1]=key;
        }*/




        /*
        // Selection Sort

        for (int i = 0; i < N - 1; i++) {
            int minIdx=i;
            for (int j = i+1; j < N; j++) {
                if (arr[minIdx]>arr[j]) minIdx=j;

            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i]=temp;
        }*/



       /* Bubble Sort
        for (int i = 0; i < N - 1; i++) {
            boolean flag=false;
            for (int j = 0; j < N - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }
            }
            if(flag==false) break;
        }*/

        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void mergeSort(int[] arr, int length) {
    }
}
