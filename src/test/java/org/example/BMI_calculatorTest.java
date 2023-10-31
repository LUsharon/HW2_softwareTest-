package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

class BMI_calculatorTest {

  @BeforeAll
  static void setUpBeforeAll() {
    System.out.println("This is BMI_calculator test.\n");
  }
  @BeforeEach
  void setUpBeforeEach() {
    System.out.println("Test beginning...");
  }
  @AfterEach
  void setUpAfterEach() {
    System.out.println("Test End.\n");
  }

  @ParameterizedTest
  @CsvSource({"180.0, 80.0", "160.0, 60.0","110.0, 35.0"}) // 這裡使用 CsvSource 來指定測試用例
  void testBMI_calculate(double height, double weight) {
    assertTimeout(Duration.ofSeconds(3), () -> {
      BMI_calculator c = new BMI_calculator();
      assertEquals(weight / ((0.01 * height) * (0.01 * height)), c.BMI_calculator(height, weight),0.1);
    });
  }
}