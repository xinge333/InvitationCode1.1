package intern_cvte.service;

import java.util.Random;

/**
 * Created by zxy on 2017/8/10.
 * 测试使用，该类不用
 */
public class Resolution {

    /**
     * 考虑直接将用户邀请码转换成一个36进制的数，邀请码范围（[a-z0-9]）
     * id范围（0-1679615）
     */
    private static char sourceString[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x',
            'y', 'z'};

    //根据用户的ID（十进制数）生成对应的四位邀请码（36进制）
    public static char[] encode(int id) {
        if (id < 0) {
            System.err.println("用户ID错误");
            return null;
        }
        char result[] = {'0', '0', '0', '0'};
        if (id <= 35) {
            result[3] = digitalToChar(id);
            return result;
        } else {
            int index = 3;
            int digit;
            while (id > 0) {
                digit = id % 36;
                result[index] = digitalToChar(digit);
                index--;
                id /= 36;
            }
        }
        return result;
    }

    //根据用户的邀请码生成对应的10进制数，作为数据库查询的索引
    public static int deCode(char[] useCode) {
        int result = 0;
        for (int i = 3; i >= 0; i--) {
            result += (Math.pow(36, 3 - i) * charToDigital(useCode[i]));
        }
        return result;
    }

    //将数字转为字符
    public static char digitalToChar(int n) {
        if (n >= 10) {
            return (char) ('a' + (n - 10));
        } else
            return (char) (n + '0');  //注意因为是将数字转换为字符，所以即使当n<10时仍应以字符的形式表示，所以此处不可以直接返回n
    }

    //将字符转为数字
    public static int charToDigital(char n) {
        if (n <= '9') {
            return (int) (n - '0');
        } else
            return (int) (n - 'a' + 10);  //注意因为是将数字转换为字符，所以即使当n<10时仍应以字符的形式表示，所以此处不可以直接返回n
    }

    //生成一个0-1679615范围内的任意随机数
    public static int radomGen() {
        int max = 1679615;
        int min = 0;
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        //System.out.println(s);
        return s;
    }


    public static void main(String args[]) {
        //Scanner scanner = new Scanner(System.in);
        /**while(true){
         String str;
         str = scanner.nextLine();
         char a[] = str.toCharArray();
         System.out.println(deCode(a));
         }*/
        int count = 0;
        for (int i = 0; i < 100000; i++) {
            int a = radomGen();
            System.out.println(encode(a));
        }

    }

}