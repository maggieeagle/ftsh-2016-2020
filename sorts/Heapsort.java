import java.util.Scanner;

//Oryol Margarita
//informatics 754

public class Inew{

	private static int size;
	private static int heapSize;

	public static void sort(int[] arr) {
		makeHeap(arr);
		while (size > 1) {
			swap(arr, 0, size - 1);
			size--;
			heapify(arr, 0);
		}
	}

	private static void makeHeap(int[] arr) {
		size = heapSize;
		// >arr.length is leaves
		for (int i = arr.length / 2; i >= 0; i--) {
			heapify(arr, i);
		}
	}

	private static void heapify(int[] arr, int element) // rebuild the heap
	{
		int left = 2 * element + 1;
		int right = 2 * element + 2;
		int biggest = element;

		if (left < size && arr[element] < arr[left])
			biggest = left;
		if (right < size && arr[right] > arr[biggest])
			biggest = right;

		if (element != biggest) {
			swap(arr, element, biggest);
			heapify(arr, biggest);
		}
	}

	public static void swap(int[] arr, int one, int two) {
		int tmp = arr[one];
		arr[one] = arr[two];
		arr[two] = tmp;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		heapSize = N;
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		sc.close();

		sort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}
