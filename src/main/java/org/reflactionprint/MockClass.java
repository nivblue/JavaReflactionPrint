package org.reflactionprint;

import lombok.Data;

@Data
public class MockClass {
    private int num;
    private String name;
    private SecondMockClass secondMockClass;

    public MockClass(int num, String name, SecondMockClass secondMockClass) {
        this.num = num;
        this.name = name;
        this.secondMockClass = secondMockClass;
    }
}
