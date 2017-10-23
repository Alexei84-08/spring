package cn.homjie.spring.webflow.domain;

public class CashOrCheckPayment extends Payment {

	public String toString() {
		return "CASH or CHECK:  $" + getAmount();
	}
}
