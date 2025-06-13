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

## Our Custom Sort: Heap Sort

For our "choose your own" algorithm, we went with **Heap Sort**. It is not stable, but its time complexity is consistently O(n log n) in the average and worst cases, making it a reliable choice for large datasets.

### How Heap Sort Works

Basically, Heap Sort turns the array of shapes into a "max heap." The max heap is a sort of tree structure where the parent node is always bigger than its children. This means the biggest shape is always at the very top.

The algorithm then takes the biggest item (from the top of the heap), moves it to the end of the array, and then fixes the heap to make sure the new biggest item is at the top. It keeps doing this until the whole array is sorted.

### Pseudocode and Analysis

**Pseudocode:**

```
HeapSort(array):
  // 1. Build the initial max heap
  BuildMaxHeap(array)

  // 2. Sort the array
  for i = length of array - 1 down to 1:
    // Move the largest element (root) to the end
    swap array[0] with array[i]
    // Reduce heap size and fix the heap
    Heapify(array, i, 0)
```

**Step Analysis:**

1.  **BuildMaxHeap:** This step arranges the initial array into a max heap. It iterates through about half of the elements (`n/2` times) and calls `Heapify` on each one. This process takes roughly `O(n)` operations.
2.  **Sorting Loop:** This loop runs `n-1` times. In each pass, it performs:
    - A **swap** operation (constant time, `O(1)`) to move the largest element to its final sorted position.
    - A call to **`Heapify`** to restore the max heap property on the remaining elements. This takes `O(log n)` time.

Combining these steps, the dominant factor is the sorting loop, which gives Heap Sort its overall time complexity.

### Complexity Analysis

- **Time Complexity:**

  - **Building the heap:** The `Heapify` operation takes O(log n) time, and it is called for n/2 elements. Therefore, the time complexity to build the heap is O(n).
  - **Sorting:** The loop for extracting elements runs n-1 times. In each iteration, we perform a swap (O(1)) and a `Heapify` operation on the reduced heap (O(log n)). This results in a time complexity of O(n log n).
  - **Overall:** The total time complexity is **O(n log n)** for the best, average, and worst cases.

- **Space Complexity:**
  - Heap Sort is an **in-place** algorithm, meaning it requires a constant amount of additional memory. The space complexity is **O(1)**.
