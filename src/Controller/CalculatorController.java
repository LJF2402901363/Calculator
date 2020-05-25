package Controller;

import Service.CalculatorService;

/**
 * Classname:CalculatorController
 *
 * @description:
 * @author: Ä°ÒâËæÓ°
 * @Date: 2020-05-25 16:33
 * @Version: 1.0
 **/
public class CalculatorController {
    CalculatorService calculatorService = new CalculatorService();

    public boolean isCanCalculate(String exp) {
        return  this.calculatorService.isCanCalculate(exp);
    }

    public String getExpResult(String exp) {
        return  this.calculatorService.getExpResult(exp);
    }
}
