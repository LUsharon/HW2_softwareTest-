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

class MyDateTest {
  MyDate today;
  @Test

  @BeforeAll
  static void setUpBeforeAll() {
    System.out.println("This is MyDate test");
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
  @CsvSource({
      "1901, 1, 1, 1901, 1, 2",
      "1901, 2, 28, 1901, 3, 1",
      "2000, 2, 28, 2000, 2, 29",
      "2000, 12, 31, 2001, 1, 1",
      "2000, 6, 30, 2000, 7, 1",
      "2000, 7, 30, 2000, 7, 31",
      "2004, 2, 28, 2004, 2, 29",
      "2023, 2, 28, 2023, 3, 1"
  })

  void testMyDate(int y1, int m1, int d1, int y2, int m2, int d2) {
    today = new MyDate(y1, m1, d1);
    MyDate expected_tomorrow = new MyDate(y2, m2, d2);
    assertTimeout(Duration.ofSeconds(3), () -> {
      assertEquals(expected_tomorrow.y, today.tomorrow().y);
      assertEquals(expected_tomorrow.m, today.tomorrow().m);
      assertEquals(expected_tomorrow.d, today.tomorrow().d);
      //assertEquals(expected_tomorrow.toString(), today.tomorrow().toString());
    });
  }
}