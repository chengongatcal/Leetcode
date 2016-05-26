/** 166. Fraction to Recurring Decimal
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return ""; 
        if (numerator == 0) return "0";
        
        StringBuilder result = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            result.append('-');
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long integer = num/den; //整数部分
        long reminder = num % den; //余数部分
        result.append(integer); //加入整数部分
        //没有余数的情况下只return整数部分,不然需要考虑小数部分
        if (reminder == 0){
            return result.toString();
        } else {
            result.append('.');
        }
        while(!map.containsKey(reminder)) {
            map.put(reminder,result.length());
            integer = reminder*10/den;
            reminder = reminder*10%den;
            if (reminder != 0 || reminder == 0 && !map.containsKey(reminder)) {
                result.append(integer);
            }
        }
        //处理余数循环部分
        if (reminder != 0) {
            result.insert(map.get(reminder),"(");
            result.append(')');            
        }
        return result.toString();
    }
}