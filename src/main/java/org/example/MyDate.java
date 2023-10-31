package org.example;

public class MyDate {
  int y;
  int m;
  int d;
  public MyDate(int y, int m, int d){
    this.y = y;
    this.m = m;
    this.d = d;
  }
  public MyDate tomorrow(){
    int[] year_months = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    int[] leap_year_months = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};

    if((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)){
      //leap year閏年
      if(d >= leap_year_months[m - 1]){//如果為當月最後一天
        if(m==12){
          return new MyDate(y+1,1,1);
        }
        else if((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0) && m == 2){
          return new MyDate(y,m,d+1);
        }
        else {
          return new MyDate(y,m+1,1);
        }
      }
      else {
        return new MyDate(y,m,d+1);
      }
    }
    else{
      if(d >= year_months[m - 1]){//如果為當月最後一天
        if(m==12){
          return new MyDate(y+1,1,1);
        }
        else if((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0) && m == 2){
          return new MyDate(y,m,d+1);
        }
        else {
          return new MyDate(y,m+1,1);
        }
      }
      else {
        return new MyDate(y,m,d+1);
      }
    }

  }

}
