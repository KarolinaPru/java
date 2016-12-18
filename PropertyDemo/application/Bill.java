package application;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Bill {
	private DoubleProperty amountDue = new SimpleDoubleProperty();

	// ================================================================
	public final double getAmountDue() {
		return amountDue.get();
	}

	public final void setAmountDue(double value) {
		amountDue.set(value);
	}
	
	public DoubleProperty amountDueProperty()
	{
		return amountDue;
	}


}
