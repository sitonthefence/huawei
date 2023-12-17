import org.junit.Test;

public class TestFunction {

  public long f(int n){
      if(n==1){

          return 1;
      }
      return n*f(n-1);
  }
  @Test
    public void fTest(){
      System.out.println(f(5));

  }

  public long f_loop(int n){
      long result =1;

      while(n>1){


          result=n*(n-1);
          n--;
      }
      return result;
  }
      @Test
      public void f_loopTest(){
          System.out.println(f_loop(1));

  }

  public int fibonacci(int n) {
      if (n == 1 || n == 2) {

          return 1;
      }

          return fibonacci(n - 1) + fibonacci(n - 2);


  }
  @Test
    public void fibonacciTest(){

      System.out.println(fibonacci(6));

  }


    public  int fibonacci_array(int n){

         if(n>2){

            int arr[]=new int[n];
                 arr[0]=1;
                 arr[1]=1;
             for (int i = 2; i < n; i++) {
               arr[i]=arr[i-1]+arr[i-2];
             }
             return arr[n-1];
         }
         return 1;

    }

    @Test
    public  void fibonacci_arrayTest(){

        System.out.println(fibonacci_array(5));

    }

    public  int  yangHui(int x,int y){

      if(y>=x&&y>=0){
          if(x==0||y==x){
            return 1;
          }else {
              return yangHui(x-1,y-1)+yangHui(x,y-1);
          }
      }
      return -1;
    }

    @Test
    public void getYanghui(){
        System.out.println(yangHui(1,3));

    }

    public int binarySearchNoRecursive(int[] array, int target){

      int left=0;
      int right=array.length-1;
      while (left<=right){
          int middle=(left+right)/2;
          if (target>array[middle]){
              left=middle+1;
          }else if(target==array[middle]){
               return middle;
          }else if(target<array[middle]){
                 right=middle-1;
          }
      }
           return -1;
    }
    @Test

    public void binarySearchNoRecursiveTest(){
      int [] array = {4,7,9};
        System.out.println(binarySearchNoRecursive(array, 9));


    }

    @Test
    public void test1(){


        System.out.println(Long.valueOf("1010000000110000001111000001"));
    }

    //暴力查找字符串中给是否有子串
    public int brute_force(String str1, String str2){
      if(str2.length()>str1.length()){
          return -1;
      }
      for(int i=0;i<str1.length();i++){
          int j;
          for (j = 0; j < str2.length(); j++) {
               if(i+j>=str1.length()||str1.charAt(i+j)!=str2.charAt(j)){
                   break;
               }

          }
          if(j==str2.length()){
              return  i;
          }

      }
      return  -1;

    }


  }






