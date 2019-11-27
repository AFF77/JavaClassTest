/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessthenumber;

/**
 *
 * @author aysen
 */
import java.util.*; 
import java.io.*; 

public class AliceInADigitalWorld{
	public static void main (String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int numTests = Integer.parseInt(br.readLine()); 
		String line[]; 

		for(int k = 0; k<numTests; k++){
			line = br.readLine().split(" "); 
			int size = Integer.parseInt(line[0]);
			int x = Integer.parseInt(line[1]);

			line = br.readLine().split(" "); 
			int arr[] = new int[size]; 

			convert(line,arr); 
			int sum = 0;
			int max = 0; 

			ArrayList<Integer> pos = new ArrayList<>();
			findPos(x,arr,pos); 

			for(int i = 0; i<pos.size(); i++){
				int p = pos.get(i); 

				//if pos is 0 or pos.size()-1
				sum = x;
				int j = p-1;

				while(j >= 0){
					if(arr[j] <= x)
						break;
					sum += arr[j];
					j--;
				}

				j = p+1;
				while(j<arr.length){
					if(arr[j] <= x)
						break;
					sum += arr[j]; 
					j++;
				}

				if(sum > max)
					max = sum;
				sum = 0; 

			}
			//System.out.println(max); 
			Integer s = max;
			bw.write(s.toString() +"\n");
		}

		bw.flush(); 
	}

	public static void convert(String line[], int arr[]){
		for(int i = 0; i<line.length; i++){
			arr[i] = Integer.parseInt(line[i]); 
		}
	}

	public static void findPos(int x, int arr[], ArrayList<Integer> pos){
		for(int i = 0; i<arr.length; i++){
			if(arr[i] == x){
				pos.add(i); 
			}
		}
	}

	public static int sum(int arr[]){
		int s = 0; 
		for(int i: arr)
			s += i;
		return s; 
	}
} 
