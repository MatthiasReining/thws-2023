package com.thws;

public class ThwsLogic2 {

    @ThwsController
    public ThwsService ts;

    public String s;

    public int calculate(int input) {
        System.out.println(ts.getCreatedDate());
        return 42 * input;
    }

    public void doSomething() {
        System.out.println("logic2");
        System.out.println(calculate(2));
    }

}
