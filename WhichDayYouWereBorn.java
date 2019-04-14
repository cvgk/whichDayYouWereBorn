
package calismalar;

import java.util.Locale;

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
                if(year%4==0){
                    monthDuration = 29; break;
                }else{
                    monthDuration = 28; break;
                }
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
    
    public void process() {
        int total = 0;
        
        
        int currentDay = 12;
        int currentMonth = 4;
        int currentYear = 2019;
        String[] days = { "friday","thursday","wednesday","tuesday",
        "monday","sunday","saturday"};
        total += getMonthDuration(month,year)-day;
         System.out.println("1.etap "+total);
        for(int i=month+1;i<=12;i++)
        {
            total += getMonthDuration(i,year);
        }
        System.out.println("2.etap "+total);
        for(int i=year+1;i<currentYear;i++)
        {
            if(i%4==0)
            {
                total +=366;
              
            }else{
                total +=365;
            }
        }
        System.out.println("3.etap "+total);
        for(int i=1;i<currentMonth;i++)
        {
            total += getMonthDuration(i,currentYear);
        }
        System.out.println("4.etap "+total);
        total+=currentDay;
       System.out.println(days[total%7]);
    }
    public static void main(String[] args)
    {
      WhichDayYouWereBorn w = new WhichDayYouWereBorn(4,1,2000);
      w.process();
        
    }
}
