package com.thws;

public class ThwsLogic1 {

    @ThwsController
    public ThwsService ts;

    public String s;

    public int calculate(int input) {
        System.out.println(ts.getCreatedDate());
        return 42 * input;
    }

    public void doSomething() {
        System.out.println("logic1");
        System.out.println(calculate(1));
    }

}
