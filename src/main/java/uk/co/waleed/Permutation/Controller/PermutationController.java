package uk.co.waleed.Permutation.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.co.waleed.Permutation.Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PermutationController {

    private static final String template = "The permuted value is, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/permutation")
    public Permutation greeting(@RequestParam(value="permuteInt", defaultValue="326") String permuteInt) {
        ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();

        for(char ch : permuteInt.toCharArray()){
            if(Character.isDigit(ch)){
                listOfNumbers.add(Character.getNumericValue(ch));
            }
        }

        if (listOfNumbers == null || listOfNumbers.isEmpty()){
            throw new NumberFormatException("The input entered doesn't have any digits " + permuteInt);
        }

        System.out.println("You entered "+ permuteInt);
        System.out.println("The digits in the input are " + listOfNumbers.toString());
        ArrayList<String> result = new ArrayList<String>();
        permutation(listOfNumbers.toArray(),0,result);
        //if we get 123 the result should be 123,132,213,231,312,321
        String res = "";
        Collections.sort(result, Collections.reverseOrder());
        for (int i = 0; i<result.size();i++){
            if (i == result.size()-1){
                res += result.get(i);
            }
            else {
                res += result.get(i) + ",";
            }
        }
        System.out.println(res);
        //setResult(res);
        System.out.println("Thanks and goodbye");

        return new Permutation(counter.incrementAndGet(),
                            String.format(template, res));
    }

    private static void permutation(Object[] values, int index, ArrayList<String> res)
    {
        String result = "";
        Object[] num = Arrays.copyOf(values, values.length);
        if(index==num.length-1)
        {
            for(int j=0;j<num.length;j++)
            {
                result += num[j];
            }
            res.add(result);
        }
        else
        {
            for(int i=index;i<num.length;i++)
            {
                int temp;
                temp= (int) num[i];
                num[i]=num[index];
                num[index]=temp;

                permutation(num,index+1,res);
            }
        }
    }
}
