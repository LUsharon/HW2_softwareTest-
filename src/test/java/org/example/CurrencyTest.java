package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyTest {

  @BeforeAll
  static void setUpBeforeAll() {
    System.out.println("This is currency test");
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
  @CsvSource({"100,nt,200,us,6100", "100,us,298,nt,110", "30,us,30,US,60", "75,NT,75,nt,150"}) // 這裡使用 CsvSource 來指定測試用例
  void testCurrency(int amount1,String symbol1, int amount2, String symbol2,int r){
    assertTimeout(Duration.ofSeconds(3), () -> {
      Currency c = new Currency(amount1, symbol1.toUpperCase());
      Currency other = new Currency(amount2,symbol2.toUpperCase());
      Currency result = new Currency(r,symbol1.toUpperCase());
      assertEquals(result.amount, c.Add(other).amount, 1);//因為匯率所以會有小數問題 所以取最大誤差1
      assertEquals(result.symbol, c.Add(other).symbol);
    });
  }
}