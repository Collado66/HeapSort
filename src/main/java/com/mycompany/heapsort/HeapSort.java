/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.heapsort;

/**
 *
 * @author marce
 */

 public class HeapSort {

    // Função principal que implementa o Heap Sort
    public static void heapSort(int[] array) {
        int n = array.length;

        // Constrói um heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extrai os elementos do heap, um por um
        for (int i = n - 1; i >= 0; i--) {
            // Move a raiz (maior elemento) para o fim
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Chama heapify no heap reduzido
            heapify(array, i, 0);
        }
    }

    // Função para reorganizar o heap (heapify)
    public static void heapify(int[] array, int n, int i) {
        int largest = i;  // Inicializa o maior como a raiz
        int left = 2 * i + 1;  // Filho à esquerda
        int right = 2 * i + 2;  // Filho à direita

        // Se o filho à esquerda for maior que a raiz
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // Se o filho à direita for maior que o maior elemento até agora
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // Se o maior não for a raiz
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursivamente heapifica a subárvore afetada
            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Array antes da ordenação:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Chama o Heap Sort
        heapSort(arr);

        System.out.println("Array após a ordenação:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
