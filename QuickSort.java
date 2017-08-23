package test;


public class QuickSort {
	
	public static void quickSort(int[] arr,int left, int right){
		
		if((right-left)<2){
			if(arr[left]>arr[right]){
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}else{
			int i = left;
			int j = right-1;
			int temp = 0;
			//三数中值分割法选取枢纽元（基准值）
			//1.先排序，三个数中间的为枢纽元（arr[(right+left)/2]）
			if(arr[left]>arr[(right+left)/2]){
				temp = arr[left];
				arr[left] = arr[(right+left)/2];
				arr[(right+left)/2] = temp;
			}
			if(arr[(right+left)/2]>arr[right]){
				temp = arr[right];
				arr[right] = arr[(right+left)/2];
				arr[(right+left)/2] = temp;
			}
			if(arr[left]>arr[(right+left)/2]){
				temp = arr[left];
				arr[left] = arr[(right+left)/2];
				arr[(right+left)/2] = temp;
			}
			//2.将枢纽元换到倒数第二的位置
			temp = arr[right-1];
			arr[right-1] = arr[(right+left)/2];
			arr[(right+left)/2] = temp;
			//从left到right-2的元素一个一个与枢纽元比较
			while(true){
				//从左侧移动指针，元素比枢纽元小，一直移动下去，遇到比枢纽元大的元素，停止移动
				while(arr[++i]<arr[right-1]){
					
				}
				//从右侧移动指针，元素比枢纽元大，一直移动下去，遇到比枢纽元小的元素，停止移动
				while(arr[--j]>arr[right-1]){
					
				}
				//左右两侧都停止移动时，如果指针没有交叉，将左右两侧指针指的元素交换，指针交叉跳出循环
				if(i<j){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}else{
					break;
				}
			}
			//指针交叉后，再将枢纽元与左指针所指的元素互换，即把枢纽元放到了正确的位置
			temp = arr[right-1];
			arr[right-1] = arr[i];
			arr[i] = temp;
			//对枢纽元左右两侧的部分递归
			quickSort(arr, left, i-1);
			quickSort(arr, i+1, right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] array = {71,12,64,13,21,67,32,24,30,94};
		int[] array = new int[100];
		for(int i=0; i<array.length; i++){
			array[i] = (int)(Math.random()*100);
			System.out.print(array[i] + ",");
		}
		quickSort(array,0,array.length-1);
		
		System.out.println(array);
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+",");
		}
	}
}
