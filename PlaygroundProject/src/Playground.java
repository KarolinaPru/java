
public class Playground
{
	
public static void main (String[] args)

{
	long[] hours = {120, 240, 150, 210};
	
	selectionSort(hours);
	
	for (long h : hours)
	{
		System.out.println(h);
	}
	
	
	
	
	
	
}
public static void selectionSort (long[] hours)
	{
		int i, j, first;
		long temp;  
		
		for (i = hours.length - 1; i > 0; i --)  
		{
			first = 0;   //initialize to subscript of first element
			for(j = 1; j <= i; j ++)   //locate smallest element between positions 1 and i.
			{
				if( hours[j] < hours[first] )         
					first = j;
			}
			temp = hours[first];   //swap smallest found with element in position i.
			hours[first] = hours[i];
			hours[i] = temp; 
		}           
	}
}