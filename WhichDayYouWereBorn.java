
package calismalar;



public class WhichDayYouWereBorn 
{
    private int day;
    private int month;
    private int year;
   
     public WhichDayYouWereBorn(int day,int month,int year)
     {
         this.day = day;
         this.month = month;
         this.year = year;
     }
     public WhichDayYouWereBorn()
     {
         this(0,0,0);
     }
    public int getDay() { return day; }
    public void setDay(int day){ this.day = day; }
    
    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }
    
    public int getYear() { return year;  }
    public void setYear(int year) { this.year = year; }
    
    public int getMonthDuration(int month,int year)
    {
        int monthDuration;
        switch(month)
        {
            case 1: monthDuration = 31; break;
            case 2:{
                monthDuration = year%4==0? 29:28; break;
            }
            case 3: monthDuration = 31; break;
            case 4: monthDuration = 30; break;
            case 5: monthDuration = 31; break;
            case 6: monthDuration =30; break;
            case 7:monthDuration = 31; break;
            case 8:monthDuration =30; break;
            case 9: monthDuration=31; break;
            case 10:monthDuration = 31; break;
            case 11:monthDuration = 30; break;
            case 12: monthDuration = 31; break;
            default: throw new RuntimeException();
        }
        return monthDuration;
    }
    enum Days { FRIDAY("friday"),THURSDAY("thursday"),WEDNESDAY("wednesday")
    ,TUESDAY("tuesday"),MONDAY("monday"),SUNDAY("sunday"),
    SATURDAY("saturday");
     private final String text;
     
     Days(String text){
         this.text = text;
     }
     public String getText() { return text; }
    }
    public void process() {
        int total = 0;
        
        
        int currentDay = 12;
        int currentMonth = 4;
        int currentYear = 2019;
        
        Days[] days = Days.values();
        total += getMonthDuration(month,year)-day;
         
        for(int i=month+1;i<=12;i++)
        {
            total += getMonthDuration(i,year);
        }
       
        for(int i=year+1;i<currentYear;i++)
        {
            if(i%4==0)
            {
                total +=366;
              
            }else{
                total +=365;
            }
        }
        
        for(int i=1;i<currentMonth;i++)
        {
            total += getMonthDuration(i,currentYear);
        }
       
        total+=currentDay;
       System.out.println(days[total%days.length].getText());
    }
    public static void main(String[] args)
    {
      WhichDayYouWereBorn w = new WhichDayYouWereBorn(14,4,1982);
      w.process();
        
    }
}
