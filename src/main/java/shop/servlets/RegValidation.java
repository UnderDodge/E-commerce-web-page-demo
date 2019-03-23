package shop.servlets;

/**
 * Created by Администратор on 26.02.2018.
 */
public class RegValidation {



    public RegValidation(){

    }



    public boolean passwordValidation(String pas){

        char [] unvalidChars = {'-','_','+','=','\\','|','/','!','@','#','$','%','^','&','*','(',')','№',':',';','.',',','~','`','"','}','{',']','[','<','>'};

        char [] numbers = {'1','2','3','4','5','6','7','8','9','0'};

        boolean flagNumber = false;
        boolean flagNonNumber = false;
        boolean buffFlag = false;

        if(pas.length()>=8){
            for(int i=0; i<pas.length(); i++){
                for(char ch : unvalidChars){
                    if(pas.charAt(i)==ch){
                        return false;    //unvalid char
                    }
                }
                for(char num : numbers){
                    if(pas.charAt(i)==num){
                        buffFlag = true;    //found a number
                    }
                }

                if(buffFlag==false){
                    flagNonNumber=true;
                }else{
                    buffFlag=false;
                    flagNumber=true;
                }
            }
        }else{
            return false; //length is less then 8
        }

        if(flagNonNumber && flagNumber){
            return true;     //password is a number and a character
        }else{
            return false;    //password is doesn't have a combination of numbers and characters
        }
    }





    public boolean emailValidation(String email){

        boolean firstBool = false;
        boolean secondBool = false;

        char [] unvalidChars = {'+','=','\\','|','/','!','#','$','%','^','&','*','(',')','№',':',';',',','~','`','"','}','{',']','[','<','>'};
        //user is able to use characters and numbers and '_' '-' '.' '@'

        if(email.length()<5){
            return false;                                           //email length must be at lest 5 ----  a@a.a
        }

        //System.out.println(email+"  passed length test");

        int emailLocation = 0;

        for(int i=0; i<email.length(); i++){
            for(char ch : unvalidChars){
                if(email.charAt(i)==ch){
                    return false;                                      //unvalid characters included
                }
            }
            if(email.charAt(i)=='@'){
                if(emailLocation==0){
                    emailLocation=i;
                }else{
                    return false;                                          //more then one '@' symbol
                }
            }
        }

        //System.out.println(email+"  passed unvalid characters");

        if(emailLocation==0){
            return false;
        }else if(email.charAt(emailLocation+1)=='.'){                  // check for some characters or numbers before and after '@'
            return false;
        }

        //System.out.println(email+"  passed length after @");


        String[] firstSplit = email.split("@");

        String fistPart = firstSplit[0];
        String secondPart = firstSplit[1];

        if(fistPart.length()>0){
            firstBool = true;
        }


        int pointCounter = 0;

        if(secondPart.length()>=3){
            for(int i=0; i<secondPart.length(); i++){
                if(secondPart.charAt(i)=='.'){
                   pointCounter++;
                }
            }
            if(pointCounter>0){
                String[] secondSplit = secondPart.split(String.valueOf('.'));
                for(String str : secondSplit){
                    if(str.length()==0){
                        return false;                                   //check for some characters or numbers before and after '.'
                    }
                }
            }else{
                return false;
            }

            //System.out.println(email+"  passed length after .");

            secondBool = true;
        }

        if(firstBool && secondBool){
            return true;
        }else{
            return false;
        }
    }



}
