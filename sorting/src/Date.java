import java.lang.Integer;

public class Date{
    private final int month;
    private final int day;
    private final int year;

//    public Date(int y, int m, int d){
//
//        year = y; month = m; day = d;
//    }
   public Date(String s){
       String[] fields = s.split("/");
       year = Integer.parseInt(fields[0]);
       month = Integer.parseInt(fields[1]);
       day = Integer.parseInt(fields[2]);
   }

    public int day(){
        return day;
    }

    public int month(){
        return month;
    }

    public int year(){
        return year;
    }

    public String toString(){
        return year() +"/"+ month() + "/" + day() ;
    }

    public boolean equals(Object x){
        if(this == x) return true;
        if(x == null) return false;
        if(this.getClass() != x.getClass()) return false;
        Date that = (Date) x;
        if(this.day != that.day) return false;
        if(this.month != that.month) return false;
        if(this.year != that.year) return false;
        return true;
    }

    public boolean isValid(){
        Boolean leapYear = year%4==0 && year%100 !=0 || year%400==0;
        if(year<0) return false;
        if(month > 12 || month < 1) return false;
        if(day > 31 || day < 1) return false;
        if(month <= 7 && month %2 == 0 && day > 30) return false;
        if(month > 7 && month %2 != 0 && day > 30) return false;
        if(leapYear && month==2 && day>28) return false;
        if((!leapYear) && month ==2 && day >29) return false;
        return true;
    }
    //    wait to complement
    public String dayOfTheWeek(){
        return "";
    }

//    wait to complement
    public int compareTo(Date that){
        if (this.year  < that.year)  return +1;
        if (this.year  > that.year)  return -1;
        if (this.month < that.month) return +1;
        if (this.month > that.month) return -1;
        if (this.day   < that.day)   return +1;
        if (this.day   > that.day)   return -1;
        return 0;
    }
// wait to complement
    public int hashCode(){
        return 0;
    }

    public static void main(String args[]){
       String s1 = "2020/03/27";
        String s2 = "2020/03/27";
        String s3 = "2020/04/28";
        Date D = new Date(s1);
        Date B = new Date(s2);
        Date C = new Date(s3);
        System.out.println(D.equals(B));
        System.out.println(B.equals(C));
        System.out.println(D.toString());
    }

}