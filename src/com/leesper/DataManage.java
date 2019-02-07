package com.leesper;

import java.util.Scanner;

public class DataManage {
	public int[] insertData() {
		int[] data = new int[NUM];
		int count = 0;

		while(true) {
			System.out.println("请输入第" + (count+1) + "个数据");
			int datum = scan.nextInt();
			if (datum == 0) {
				continue;
			}
			data[count++] = datum;
			if (count >= NUM - 1) {
				break;
			}
		}
		showData(data, data.length);
		return data;
	}

	public void showData(int[] a, int length) {
		System.out.println("数组元素为：");
		for (int i = 0; i < length && a[i] != 0; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public void insertAtArray(int[] a, int n, int k) {
		if (k < 0 || k >= a.length) {
			return;
		}
		
		if (k == a.length - 1) {
			a[k] = n;
		} else {
			for (int i = a.length - 1; i > k; i--) {
				a[i] = a[i - 1];
			}
			a[k] = n;
		}
		showData(data, data.length);
	}
	
	public void divThree(int[] a) {
		System.out.println("数组中能被3整除的元素为：");
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 3 == 0) {
				System.out.print(a[i] + " ");
			}
		}
		System.out.println();
	}
//
//	public void notice();
	
	public void usage() {
		System.out.println("************************");
		System.out.println("1--插入数据");
		System.out.println("2--显示所有数据");
		System.out.println("3--在指定位置插入数据");
		System.out.println("4--查询能被3整除的数据");
		System.out.println("0--退出");
		System.out.println("************************");
		System.out.println("请输入对应的数字进行操作：");
	}
	
	public static void main(String[] args) {
		DataManage dm = new DataManage();
		while(true) {
			dm.usage();
			int command = scan.nextInt();
			switch (command) {
			case 1:
				dm.data = dm.insertData();
				break;
			case 2:
				if (dm.data != null) {
					dm.showData(dm.data, dm.data.length);
				}
				break;
			case 3:
				System.out.println("请输入要插入的数据：");
				int n = scan.nextInt();
				System.out.println("请输入要插入数据的位置：");
				int k = scan.nextInt();
				dm.insertAtArray(dm.data, n, k);
				break;
			case 4:
				if (dm.data != null) {
					dm.divThree(dm.data);
				}
				break;
			case 0:
				return;
			default:
				System.out.println("请输入正确的命令");
			}
		}
		
	}

	private int[] data;
	private static Scanner scan = new Scanner(System.in);
	private static final int NUM = 10;
}
