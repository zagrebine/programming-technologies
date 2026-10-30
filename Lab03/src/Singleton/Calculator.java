package Singleton;

import java.util.function.BinaryOperator;

public class Calculator{
    public static int execute(int a, int b, BinaryOperator<Integer> operator, AppConfig config){
        if(config.testMode()){
            System.out.println("[TEST] Выполняется операция чисел: " + a + ',' + b);
            config.setTestMode(false);
            return operator.apply(a, b);
        }
        System.out.println("[NOT TEST] Выполняется операция чисел: " + a + ',' + b);
        return operator.apply(a, b);
    }
}
