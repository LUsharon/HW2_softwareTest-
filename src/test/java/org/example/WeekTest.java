package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class WeekTest {

  @BeforeAll
  static void week() {
    System.out.println("This is week test");
  }

  @BeforeEach
  void beforeEach(){
    System.out.println("Test beginning...");
  }

  @AfterEach
  void afterEach(){
    System.out.println("Test end.");
  }

  @ParameterizedTest
  @CsvSource({"1,1,Friday", "12,31,Friday"}) // 這裡使用 CsvSource 來指定測試用例
  void testWeek1(int month,int date, String r){
    assertTimeout(Duration.ofSeconds(3), () -> {
      Week c = new Week();
      assertEquals(r, c.Week(month,date));
    });
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/week_testdata.csv", numLinesToSkip = 1)//這裡使用CSVfile來當測試用例
  void testWeek2(int month,int date, String r){
    //boolean result = !r.equals("ERROR");//Error ->false
    Week c = new Week();
    assertEquals(r, c.Week(month,date));
  }
}