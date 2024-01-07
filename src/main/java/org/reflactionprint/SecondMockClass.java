package org.reflactionprint;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class SecondMockClass {
    private double dNumb;
    private long milliseconds;
    private int listOfNumbers[];
    private MockClass mockClass;

    public SecondMockClass(double dNumb, long milliseconds, int[] listOfNumber, MockClass mockClass) {
        this.dNumb = dNumb;
        this.milliseconds = milliseconds;
        this.listOfNumbers = listOfNumber;
        this.mockClass = mockClass;
    }

    public void setMockClass(MockClass mockClass) {
        this.mockClass = mockClass;
    }
}
