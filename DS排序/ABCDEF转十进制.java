package DS排序;
/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/2/1
 * Time: 16:22
 * Description: No Description
 */
public class ABCDEF转十进制 {
    public static void main(String args[]){
        long ans = (long)(Math.pow(16,0)*15+Math.pow(16,1)*14
                +Math.pow(16,2)*13+Math.pow(16,3)*12+Math.pow(16,4)*11+Math.pow(16,5)*10);
        System.out.printf("%15d",ans);
        //11259375
    }

}
