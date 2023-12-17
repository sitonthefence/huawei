package NK;

public class NC149 {

    public int kmp (String S, String T) {
        if(S.length()>T.length()){
            return 0;
        }

        int count=0;
        for(int i=0;i<T.length();i++){
            int j;
            for (j = 0; j < S.length(); j++) {
                if(i+S.length()>T.length()||T.charAt(i+j)!=S.charAt(j)){
                    break;
                }
            }
            if(j==S.length()){
              count++;
            }

        }

        return  count;

    }


}
