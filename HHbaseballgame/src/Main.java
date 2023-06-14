package baseball;
import java.lang.reflect.GenericArrayType;
import java.util.Scanner;

//세자리 랜덤숫자 구하기 구현(중복 x)
// 볼 스트라이크 표현 구현
// 게임종료하는 부분 구현
public class RandomNumber {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] number = new int[3];
        int[] user = new int[3];
        int Try = 0;
        int strike = 0;
        int ball = 0;

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        //랜덤숫자 세자리 뽑기
        for (int i = 0; i < 3; i++) {
            number[i] = (int)(Math.random()*10);
//            System.out.print(number[i]);

            //중복제거
            for (int j = 0; j < i; j++) {
                if (number[i] == number[j]) {
                    i--;
                    break;
                }
            }
        }

        //유저입력값

        for (int x = 0; x < 10; x++) {
            Try ++;

//            for (int i = 0; i < 3; i++) {
////                    user[i] = scan.nextInt();
//                    user[x] = Integer.parseInt(scan.nextLine());
////                    temp = user[i];
//                if(user.length != 3 ){
//                    System.out.println("3자리 숫자를 입력해주세요.");
//                }
////                System.out.println("유저가 입력한 값 : " + user[j] );
//            }
            System.out.println(Try+ " 번 째 시도 : ");

            String userInput =  scan.nextLine();
            if (userInput.length() != 3) {
                System.out.println("3자리 숫자를 입력해주세요.");
//                continue;
            }
            user[0] = Character.getNumericValue(userInput.charAt(0));   // Character.getNumericValue 는 char 타입의 숫자를 정수값으로 변환
            user[1] = Character.getNumericValue(userInput.charAt(1));
            user[2] = Character.getNumericValue(userInput.charAt(2));

            //볼, 스트라이크 구별
            for (int j = 0; j < 3; j++) {

                for (int k = 0; k < 3; k++) {
//                    System.out.println("스트라이크");
                    if (number[j] == user[k]) {
                        if (j == k) {
                            strike ++;
//                            System.out.println("스트라이크");
                        } else {
                            ball ++;
//                            System.out.println("볼");
                        }
                    }
                }
            }
            if (strike == 0 && ball == 0) {
                System.out.println("0B0S");
            } else if (strike == 1 && ball == 0) {
                System.out.println("0B1S");
            } else if (strike == 2 && ball == 0) {
                System.out.println("0B2S");
            } else if (strike == 1 && ball == 1) {
                System.out.println("1B1S");
            } else if (strike == 1 && ball == 2) {
                System.out.println("2B1S");
            } else if (strike == 1 && ball == 3) {
                System.out.println("3B1S");
            } else if (strike == 1 && ball == 4) {
                System.out.println("4B1S");
            } else if (strike == 0 && ball == 1) {
                System.out.println("1B0S");
            } else if (strike == 0 && ball == 2) {
                System.out.println("2B0S");
            } else if (strike == 0 && ball == 3) {
                System.out.println("3B0S");
            } else if (strike == 0 && ball == 4) {
                System.out.println("3B0S");
            } else {
                System.out.println("3S");
                System.out.println( Try + "번 만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");

                break;
            }
        }
    }
}

