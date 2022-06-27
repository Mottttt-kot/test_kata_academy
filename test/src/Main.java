import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(calc(input));
    }

    public static Integer rimsToArabs(String input)
    {
        Integer res = 0;
        switch(input)
        {
            case "I":
                res = 1;
                break;
            case "II":
                res = 2;
                break;
            case "III":
                res = 3;
                break;
            case "IV":
                res = 4;
                break;
            case "V":
                res = 5;
                break;
            case "VI":
                res = 6;
                break;
            case "VII":
                res = 7;
                break;
            case "VIII":
                res = 8;
                break;
            case "IX":
                res = 9;
                break;
            case "X":
                res = 10;
                break;
            case "XI":
                res = 11;
                break;
            case "XII":
                res = 12;
                break;
            case "XIII":
                res = 13;
                break;
            case "XIV":
                res = 14;
                break;
            case "XV":
                res = 15;
                break;
            case "XVI":
                res = 16;
                break;
            case "XVII":
                res = 17;
                break;
            case "XVIII":
                res = 18;
                break;
            case "XIX":
                res = 19;
                break;
            case "XXV":
                res = 20;
                break;
        }
        return res;
    }

    public static String arabsToRims(Integer input)
    {
        String res = "";
        switch(input)
        {
            case 1:
                res = "I";
                break;
            case 2:
                res = "II";
                break;
            case 3:
                res = "III";
                break;
            case 4:
                res = "IV";
                break;
            case 5:
                res = "V";
                break;
            case 6:
                res = "VI";
                break;
            case 7:
                res = "VII";
                break;
            case 8:
                res = "VIII";
                break;
            case 9:
                res ="IX";
                break;
            case 10:
                res = "X";
                break;
            case 11:
                res = "XI";
                break;
            case 12:
                res = "XII";
                break;
            case 13:
                res = "XIII";
                break;
            case 14:
                res = "XIV";
                break;
            case 15:
                res = "XV";
                break;
            case 16:
                res = "XVI";
                break;
            case 17:
                res = "XVII";
                break;
            case 18:
                res = "XVIII";
                break;
            case 19:
                res = "XIX";
                break;
            case 20:
                res = "XX";
                break;
        }
        return res;

    }
    

    public static String calc(String input) throws ExceptionEnter{
        input = input.trim().toUpperCase();
        String rims = "0,I,II,III,IV,V,VI,VII,VIII,IX,X";
        String arabs = "012345678910";
        boolean isArab = false;
        boolean isRim = false;
        String left = "";
        String right = "";
        String result = "";

        try{
            if(input.length() < 3)
            {
                    throw new ExceptionEnter("throws Exception //т.к. строка не является математической операцией");
            }
        }
        catch(ExceptionEnter ex)
        {
            ex.printStackTrace();
            System.exit(-1);
        }

        for(int i =0;i<input.length();i++)
        {
            if(input.charAt(i) =='+' || input.charAt(i) =='-' || input.charAt(i) =='*' || input.charAt(i) =='/')
            {
                left = input.substring(0,i).trim().toUpperCase();
                right = input.substring(i+1).trim().toUpperCase();


                try{
                    if(input.indexOf(input.charAt(i)) != input.lastIndexOf(input.charAt(i)))
                    {
                        throw new ExeptionOfCountZnaka("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    }
                }
                catch(ExeptionOfCountZnaka ex)
                {
                    ex.printStackTrace();
                    System.exit(-1);
                }

                if(rims.contains(left))
                {
                    isRim = true;
                }
                if(rims.contains(right))
                {
                    isRim = true;
                }
                if(arabs.contains(left))
                {
                    isArab = true;
                }
                if(arabs.contains(right))
                {
                    isArab = true;
                }

                try
                {
                    if(isArab & isRim)
                    {
                        throw new ExeptionDifferentNumberSystems("throws Exception //т.к. используются одновременно разные системы счисления");
                    }
                }
                catch(ExeptionDifferentNumberSystems ex)
                {
                    ex.printStackTrace();
                    System.exit(-1);
                }

                switch(input.charAt(i))
                {
                    case '+':
                        if(!isRim)
                        {
                            result = Integer.toString(arabs.indexOf(left) + arabs.indexOf(right));
                        }
                        else if(!isArab)
                        {
                            result = arabsToRims(rimsToArabs(left) + rimsToArabs(right));
                        }
                        break;
                    case '-':
                        if(!isRim)
                        {
                            result = Integer.toString(arabs.indexOf(left) - arabs.indexOf(right));
                        }
                        else if(!isArab)
                        {
                            try{
                                if(rimsToArabs(left) > rimsToArabs(right))
                                {
                                    result = arabsToRims(rimsToArabs(left) - rimsToArabs(right));
                                }
                                else{
                                    throw new ExeptionNegativeNumbers("throws Exception //т.к. в римской системе нет отрицательных чисел");
                                }
                            }
                            catch(ExeptionNegativeNumbers ex)
                            {
                                ex.printStackTrace();
                                System.exit(-1);  
                            }
                        }
                        break;
                    case '*':
                        if(!isRim)
                        {
                            result = Integer.toString(arabs.indexOf(left) * arabs.indexOf(right));
                        }
                        else if(!isArab)
                        {
                            result = arabsToRims(rimsToArabs(left) * rimsToArabs(right));
                        }
                        break;
                    case '/':
                        if(!isRim)
                        {
                            result = Integer.toString(arabs.indexOf(left) / arabs.indexOf(right));
                        }
                        else if(!isArab)
                        {
                            result = arabsToRims(rimsToArabs(left) / rimsToArabs(right));
                        }
                        break;
                }
            }
        }

        return result;
    }

}
