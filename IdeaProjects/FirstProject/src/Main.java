//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(equalSubstring("krpgjbjjznpzdfy","nxargkbydxmsgby",14));
        }

    public static int equalSubstring(String s, String t, int maxCost) {
        int count=0,temp=maxCost,maxCount=0;
        for(int i=0;i<s.length();i++){
            int dif=Math.abs(s.charAt(i)-t.charAt(i));
            System.out.println(dif);
            if(dif<=maxCost){
                count++;
                maxCost-=dif;
            }else{
                count=0;
                maxCost=temp;
                i--;
//                System.out.println(1);
            }
            maxCount=Math.max(count,maxCount);
        }
        return maxCount;
    }
}