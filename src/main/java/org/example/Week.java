package org.example;

class Week {
  public String Week(int month, int date){
    int[] array_months = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    int days_of_the_week = 4; //2020/12/31 thursday
    if(month<1 || month>12){
      return "ERROR";//"ERROR month要在1到12之間"
    }

    if(date<1 || date > array_months[month-1]){
      return "ERROR";//date要在1到當月的最大日期之間
    }
    else{
      for(int i = 0;i < month-1;i++){
        days_of_the_week += array_months[i];
      }

      days_of_the_week += date;
      days_of_the_week %= 7;
      switch (days_of_the_week) {
        case 0:
          return "Sunday";
        case 1:
          return "Monday";
        case 2:
          return "Tuesday";
        case 3:
          return "Wednesday";
        case 4:
          return "Thursday";
        case 5:
          return "Friday";
        case 6:
          return "Saturday";
        default:
          return "NOT DEFINE";
      }
    }
  }
}