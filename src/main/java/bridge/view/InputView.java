package bridge.view;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        validSize(input);
        return Integer.parseInt(input);
    }

    private void validSize(String input) {
        if (!checkDigit(input) || input.equals("0")) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 자연수여야 합니다.");
        }
    }

    private boolean checkDigit(String input) {
        boolean check = false;
        for (char c : input.toCharArray()) {
            check =  Character.isDigit(c);
        }
        return check;
    }

    public String readMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        validCommand(input);
        return input;
    }

    public String readGameCommand() {
        String input = Console.readLine();
        validCommand(input);
        return input;
    }

    private void validCommand(String input) {
        try {
            for (char c : input.toCharArray()) {
                checkUpperCase(c);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 커맨드는 대문자 알파벳으로 입력해야 합니다.");
        }
    }

    private void checkUpperCase(char input) {
        if (!Character.isUpperCase(input)) {
            throw new IllegalArgumentException();
        }
    }
}
