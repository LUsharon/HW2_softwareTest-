package org.example;

class BMI_calculator {

  public double BMI_calculator(double height, double weight){
    double bmi = weight / ((0.01 * height) * (0.01 * height));
    return bmi;
  }
}
