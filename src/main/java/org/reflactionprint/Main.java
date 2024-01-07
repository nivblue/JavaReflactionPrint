package org.reflactionprint;

public class Main {
    public static void main(String[] args) {
        SecondMockClass secondMockClass = new SecondMockClass(0.3,
                123456,
                new int[]{1, 2, 3, 4},
                null);
        MockClass mockClass = new MockClass(1, "hey", secondMockClass);

        secondMockClass.setMockClass(mockClass);

        System.out.println("testing printing the class : ");
        ExerciseUtilityClass.printObject(mockClass);
    }
}