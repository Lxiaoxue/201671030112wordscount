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
    	
		BufferedReader a = new BufferedReader(new FileReader("a.txt"));// 读取要处理的文件
    	Map<String, Integer> map = new TreeMap<String, Integer>();//<单词:词频>
            String value= a.readLine();
            while (value!= null) //处理标点符号
            {
            	String[] words = value.split("[【 $ % & * @ 、.。,\"!--;:?】\']"); 
            	for (int i = 0; i < words.length; i++) //将大写字母转换为小写字母
            	{
                      String key = words[i].toLowerCase();
                	  if (key.length() > 0) 
                	  {
                      		if (!map.containsKey(key))//第一次出现，为1. 
                      		{
                          		map.put(key, 1);	
                      		} 
                      		else 
                      		{ 
                      			int k = map.get(key)+1;//不是第一次出现，就把k值+1
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
		      ("         词频率统计功能                                                     " +'\n'+
		        "————————————————————————————————————    " +'\n'+
                "    1、指定单词词频统计                                                     " +'\n'+
                "    2，高频词统计功能                                                         " +'\n'+
                "    3、统计所有单词数量及词频数写入reuslt.txt中  " +'\n'+
                "    4、退出                                                                            " +'\n'+
                "—————————————————————————————————————— ");
	}
    
}