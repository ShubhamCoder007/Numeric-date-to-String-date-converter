import java.io.*;
class StringDate
{
    public static int[] processData(String s){
        s=s+"/";
        int[] d=new int[3];
        int i=0;
        String t="";
        for(int j=0;j<s.length();j++){
            char c=s.charAt(j);
            if(c=='/'){
                d[i]=Integer.parseInt(t);
                i++;
                t="";
                continue;
            }
            t=t+c;
        }
        return d;
    }
    
    public static String numericLiteral(int a){
        String num[]={"One","two","three","four","five","six","seven","eight","nine"};
        int n=0,i=0;
        String s="";
        while(a!=0)
        {
            n=a%10;
            a=a/10;
            i++;
            
            if(i==1)
                s=num[n-1];
                
            if(i==2){
                if(n==0){
                    continue;
                }
                else if(n==1){
					if(s=="One")
					{
						s="eleven";
						continue;
					}
					if(s=="two")
					{
						s="twelve";
						continue;
					}
					if(s=="three")
					{
						s="thirteen";
						continue;
					}
                    s=s+"teen";
                }
                else if(n==2){
                    s="twenty "+s;
                }
                else if(n==3){
                    s="thirty "+s;
                }
                else if(n==4){
                    s="fourty "+s;
                }
                else if(n==5){
                    s="fifty "+s;
                }
				else if(n==8){
					s="eighty "+s;
				}
                else{
                    s=num[n-1]+"ty "+s;
                }
            }
            
            if(i==3)
                s=num[n-1]+" hundred "+s;
                
            if(i==4)
                s=num[n-1]+" thousand "+s;
			if(i==5)
                s=num[n-1]+" ten thousand "+s;
			if(i==6)
                s=num[n-1]+" hundred thousand "+s;
			if(i==7)
                s=num[n-1]+" million "+s;
			if(i==8)
                s=num[n-1]+" ten million "+s;
			if(i==9)
                s=num[n-1]+" hundred million "+s;
			if(i==10)
                s=num[n-1]+" billion "+s;
            if(i==11)
			{
				s="Earth won't exist that far mate!";
				break;
			}
		}
            return s;
    }
    
    public static String month(int a)throws InvalidMonthException{
        String month[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
        
        if(a<0 || a>12)
            throw new InvalidMonthException();
        
        return month[a-1];
    }
    
    public static String dateLiteral(String s){
        int[] a=processData(s);
        String t="";
        try
        {
            t=numericLiteral(a[0])+"  "+month(a[1])+"  "+numericLiteral(a[2]);
        }catch(InvalidMonthException e){
            System.out.println(e.getMessage());
			e.printStackTrace();
        }
        return t;
    }
    
    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the date : ");
        String date=br.readLine();
        System.out.println("Date in literal : "+dateLiteral(date));
    }
}