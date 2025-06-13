# Assignment 1: Complexity and Sorting

This project is a Java application that sorts a collection of 3D geometric shapes based on different criteria. It implements and benchmarks six sorting algorithms: Bubble Sort, Selection Sort, Insertion Sort, Merge Sort, Quick Sort, and Heap Sort.

    **Arguments:**

    *   `-f` or `-F`: The path to the input data file (e.g., `res/shapes1.txt`).
    *   `-t` or `-T`: The attribute to sort by:
        *   `h` for Height
        *   `v` for Volume
        *   `a` for Base Area
    *   `-s` or `-S`: The sorting algorithm to use:
        *   `b` for Bubble Sort
        *   `s` for Selection Sort
        *   `i` for Insertion Sort
        *   `m` for Merge Sort
        *   `q` for Quick Sort
        *   `z` for Heap Sort (our custom choice)

    **Example:**

    ```bash
    java -jar Sort.jar -f res/shapes1.txt -t v -s z
    ```

## Custom Sorting Algorithm: Heap Sort

For this project, we chose **Heap Sort** as our custom sorting algorithm. Heap Sort is an efficient, in-place, comparison-based sorting algorithm. It is not stable, but its time complexity is consistently O(n log n) in the average and worst cases, making it a reliable choice for large datasets.

### How Heap Sort Works

Heap Sort works by first transforming the input array into a **max heap**. A max heap is a complete binary tree where the value of each node is greater than or equal to the value of its children. Once the max heap is built, the algorithm repeatedly swaps the root element (the largest element in the heap) with the last element of the heap, then reduces the heap size by one and "heapifies" the root to maintain the max heap property. This process is repeated until the entire array is sorted.

### Complexity Analysis

- **Time Complexity:**

  - **Building the heap:** The `Heapify` operation takes O(log n) time, and it is called for n/2 elements. Therefore, the time complexity to build the heap is O(n).
  - **Sorting:** The loop for extracting elements runs n-1 times. In each iteration, we perform a swap (O(1)) and a `Heapify` operation on the reduced heap (O(log n)). This results in a time complexity of O(n log n).
  - **Overall:** The total time complexity is **O(n log n)** for the best, average, and worst cases.

- **Space Complexity:**
  - Heap Sort is an **in-place** algorithm, meaning it requires a constant amount of additional memory. The space complexity is **O(1)**.
