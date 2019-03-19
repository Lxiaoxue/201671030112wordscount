import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MAIN 
{ 
	static Scanner in = new Scanner(System.in);
	Map<String,Integer> Map = new LinkedHashMap<String, Integer>(); //ʹ������
    
    public void Lookup(Map<String, Integer> map)//��ʾ��Ƶ����״ͼ
    {
        System.out.println("Please input you want find word:\n");
        String string = in.nextLine();
        String[] word= string.split(","); //���ʺ͵���֮���ã�����
        float sum;
        for(int i=0; i<word.length; i++) 
        {
        	for(Map.Entry<String,Integer> w : map.entrySet()) 
        	{ 
        		if(word[i].equals(w.getKey()))
        		{  
        			System.out.println("����"+w.getKey() + "���ִ�����" + w.getValue());
        			sum=(float)(w.getValue())/100; 
        			for(int j=0;j<sum;j++)
        			{
        				System.out.print("*");//��*��������״ͼ,һ��*����100��
        			}
        			System.out.println();
        		}  
            } 
        }
    }
   
    public void Sort(Map<String, Integer> map,int i)//����
    {  
       Set<Entry<String,Integer>> m= map.entrySet();   
       LinkedList<Entry<String, Integer>> List = new LinkedList<Entry<String,Integer>>(m);
       if(i==1)
       {
             Collections.sort(List, new Comparator<Entry<String,Integer>>() 
             {     
                    public int compare(Entry<String, Integer> a1,  Entry<String, Integer> a2) 
                    {  
                           return a2.getValue().compareTo(a1.getValue());  
                    }     
             });  
       }
       else if(i==2) 
       {
    	   Collections.sort(List, new Comparator<Entry<String,Integer>>() 
    	   {     
               public int compare(Entry<String, Integer> a1,  Entry<String, Integer> a2)
               {  
                   return a1.getKey().compareTo(a2.getKey());  
               }     
           });  
       }
       for(Entry<String,Integer> entry: List) 
       {  
           Map.put(entry.getKey(), entry.getValue());  
       }  
   } 
  //���ǰn������
     public void Rate(Map<String, Integer> map)
     {  
    	Sort(map,1);
        System.out.println("Please input word num:\n");
        int num = in.nextInt();
        for(Entry<String,Integer> w : Map.entrySet()) 
        {  
            System.out.println("����"+w.getKey() + "���ִ���:" + w.getValue());  
            num--;
            if(num<=0)	
            	break;
        } 
       
    }  
    //��ͳ�Ƴ����Ĵ�Ƶд��result.txt
     public void Write(Map<String, Integer> map)throws IOException 
     {  
    	Sort(map,2);
        File file = new File("result.txt");
        FileWriter r = new FileWriter(file.getAbsoluteFile());
        for(Entry<String,Integer> w: Map.entrySet()) 
        {
        	r.write(w.getKey() + "  :  " + w.getValue()+"  ");
        }
        r.close();
        System.out.println("д�����");
    }  
}