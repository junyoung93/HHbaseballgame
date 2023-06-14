import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] computerNumbers = generateRandomNumbers();
        int[] userNumbers;
        int attempts = 0;

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        while (true) {
            userNumbers = getUserNumbers();
            attempts++;

            int strikes = countStrikes(computerNumbers, userNumbers);
            int balls = countBalls(computerNumbers, userNumbers);

            System.out.println(balls+"B"+strikes+"S");

            if (strikes == 3) {
                System.out.println(attempts+"번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }

    // 0과 9 사이의 서로 다른 3개의 숫자를 무작위로 생성 ==> 해결
    private static int[] generateRandomNumbers() {
        int[] numbers = new int[3];
        boolean[] used = new boolean[10];
        int count = 0;

        while (count < 3) {  // while보다 for 문으로 짜는 쪽으로...지금은 괜찮지만, 나중을 위해서
            int randomNumber = (int) (Math.random() * 10);
//0 1 2 3 4 5 6 7 8 9
//f f f f f f f T f f      7  //3번만 돌리는게 아니라 count 3이 되기 전까지.
            if (!used[randomNumber]) {
                numbers[count] = randomNumber;
                used[randomNumber] = true;
                count++;
            }
        }

        return numbers;
    }

    // 사용자로부터 세 자리 숫자를 입력받음  ==> 질문
    private static int[] getUserNumbers() {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[3];

        //System.out.print("세 자리 숫자를 입력하세요: ");
        int input = scanner.nextInt();

        numbers[0] = input / 100;    // 백의 자리 숫자
        numbers[1] = (input / 10) % 10;    // 십의 자리 숫자
        numbers[2] = input % 10;    // 일의 자리 숫자

        return numbers;
    }

    // 스트라이크
    private static int countStrikes(int[] computerNumbers, int[] userNumbers) {
        int strikes = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == userNumbers[i]) {
                strikes++;
            }
        }

        return strikes;
    }

    // 볼
    private static int countBalls(int[] computerNumbers, int[] userNumbers) {
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && computerNumbers[i] == userNumbers[j]) {
                    balls++;
                }
            }
        }

        return balls;
    }
}
