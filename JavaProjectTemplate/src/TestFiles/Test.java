public class Test {
    public static void main(String[] args){
        String str = "CMI";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< str.length-1; i>=0; i--){
            if(i == 0){
                sb.append('S');
            }
            sb.append(str.charAt(i));
        }

        System.out.println(sb.toString());
    }
}