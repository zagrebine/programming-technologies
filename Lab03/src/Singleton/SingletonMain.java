package Singleton;

import java.util.function.BinaryOperator;

public class SingletonMain{
    public static void main(String[] args){
        BinaryOperator<Integer> addition = (a, b) -> a+b;
        BinaryOperator<Integer> multiply = (a, b) -> a*b;
        AppConfig config = AppConfig.getAppConfig();
        config.setTestMode(true);
        int a = 5;
        int b = 6;
        System.out.println(Calculator.execute(a, b, addition, config));
        System.out.println(Calculator.execute(a, b, multiply, config));

        AppConfig config2 = AppConfig.getAppConfig();
        System.out.println(config == config2);
    }
}
