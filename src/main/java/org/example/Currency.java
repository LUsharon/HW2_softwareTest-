package org.example;

class Currency {
  int amount;
  String symbol;
  public Currency(int a, String s) {
        this.symbol = s;
        this.amount = a;
  }

  public Currency Add(Currency other) {
    if(this.symbol.equalsIgnoreCase(other.symbol)){
      return new Currency(this.amount + other.amount,this.symbol);
    }
    else{
      if(this.symbol.equalsIgnoreCase("NT")){
        return new Currency(this.amount + other.amount*30,this.symbol);
      }
      else {
        return new Currency(this.amount + other.amount/30,this.symbol);
      }
    }
  }
}
