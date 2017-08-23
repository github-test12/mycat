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
			//������ֵ�ָѡȡ��ŦԪ����׼ֵ��
			//1.�������������м��Ϊ��ŦԪ��arr[(right+left)/2]��
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
			//2.����ŦԪ���������ڶ���λ��
			temp = arr[right-1];
			arr[right-1] = arr[(right+left)/2];
			arr[(right+left)/2] = temp;
			//��left��right-2��Ԫ��һ��һ������ŦԪ�Ƚ�
			while(true){
				//������ƶ�ָ�룬Ԫ�ر���ŦԪС��һֱ�ƶ���ȥ����������ŦԪ���Ԫ�أ�ֹͣ�ƶ�
				while(arr[++i]<arr[right-1]){
					
				}
				//���Ҳ��ƶ�ָ�룬Ԫ�ر���ŦԪ��һֱ�ƶ���ȥ����������ŦԪС��Ԫ�أ�ֹͣ�ƶ�
				while(arr[--j]>arr[right-1]){
					
				}
				//�������඼ֹͣ�ƶ�ʱ�����ָ��û�н��棬����������ָ��ָ��Ԫ�ؽ�����ָ�뽻������ѭ��
				if(i<j){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}else{
					break;
				}
			}
			//ָ�뽻����ٽ���ŦԪ����ָ����ָ��Ԫ�ػ�����������ŦԪ�ŵ�����ȷ��λ��
			temp = arr[right-1];
			arr[right-1] = arr[i];
			arr[i] = temp;
			//����ŦԪ��������Ĳ��ֵݹ�
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
