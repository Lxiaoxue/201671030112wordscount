/**
 * 201671030112
 * 
 * */

import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.IOException;  
import java.util.Map;
import java.util.Scanner; 
import java.util.TreeMap;
import java.io.IOException;
public class TEST 
{ 
	static Scanner in = new Scanner(System.in);
    public static void main(String[] args)throws IOException
    {  
    	
		BufferedReader a = new BufferedReader(new FileReader("a.txt"));// ��ȡҪ������ļ�
    	Map<String, Integer> map = new TreeMap<String, Integer>();//<����:��Ƶ>
            String value= a.readLine();
            while (value!= null) //���������
            {
            	String[] words = value.split("[�� $ % & * @ ��.��,\"!--;:?��\']"); 
            	for (int i = 0; i < words.length; i++) //����д��ĸת��ΪСд��ĸ
            	{
                      String key = words[i].toLowerCase();
                	  if (key.length() > 0) 
                	  {
                      		if (!map.containsKey(key))//��һ�γ��֣�Ϊ1. 
                      		{
                          		map.put(key, 1);	
                      		} 
                      		else 
                      		{ 
                      			int k = map.get(key)+1;//���ǵ�һ�γ��֣��Ͱ�kֵ+1
                                map.put(key, k);
                          	}
                      }
                } 
                value = a.readLine();
            }
            menu();
            System.out.println("Please input the choose:");
            int m= in.nextInt();  
            while(m!=4)
            {
                switch(m)
                {
                    case 1:
                    {
                    	MAIN n = new MAIN();
        				n.Lookup(map);
            	    }
            	         break;
                    case 2:
                    {
                    	MAIN n = new MAIN();
        				n.Rate(map);     
                    } 
            	        break;
                    case 3:
                    {
                    	MAIN n = new MAIN();
        				n.Write(map);
            	    }
            	        break;
                }
                System.out.println("Please input the choose:");
                m= in.nextInt();  
            }
    }
   public static void menu()
	{
		System.out.println
		      ("         ��Ƶ��ͳ�ƹ���                                                     " +'\n'+
		        "������������������������������������������������������������������������    " +'\n'+
                "    1��ָ�����ʴ�Ƶͳ��                                                     " +'\n'+
                "    2����Ƶ��ͳ�ƹ���                                                         " +'\n'+
                "    3��ͳ�����е�����������Ƶ��д��reuslt.txt��  " +'\n'+
                "    4���˳�                                                                            " +'\n'+
                "���������������������������������������������������������������������������� ");
	}
    
}