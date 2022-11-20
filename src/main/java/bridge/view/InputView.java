package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String INPUT_MOVE_COMMAND_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	private static final String INPUT_RESTART_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
	private static final String INPUT_SIZE_ERROR_MESSAGE = "[ERROR] 다리의 길이는 숫자여야 합니다.";
	private static final String INPUT_COMMAND_ERROR_MESSAGE = "[ERROR] 커맨드는 대문자 알파벳으로 입력해야 합니다.";

	private InputView(){}

	public static void printIntroMessage() {
		System.out.println("다리 건너기 게임을 시작합니다.\n");
	}

	public static int readBridgeSize() {
		System.out.println("다리의 길이를 입력해주세요.\n");
		String input = Console.readLine();
		validSize(input);
		return Integer.parseInt(input);
	}

	private static void validSize(String input) {
		if (!checkDigit(input)) {
			throw new IllegalArgumentException(INPUT_SIZE_ERROR_MESSAGE);
		}
	}

	private static boolean checkDigit(String input) {
		boolean check = false;
		for (char c : input.toCharArray()) {
			check = Character.isDigit(c);
		}
		return check;
	}

	public static String readMoving() {
		System.out.println(INPUT_MOVE_COMMAND_MESSAGE);
		String input = Console.readLine();
		validCommand(input);
		return input;
	}

	public static String readGameCommand() {
		System.out.println(INPUT_RESTART_COMMAND_MESSAGE);
		String input = Console.readLine();
		validCommand(input);
		return input;
	}

	private static void validCommand(String input) {
		for (char c : input.toCharArray()) {
			checkUpperCase(c);
		}
	}

	private static void checkUpperCase(char input) {
		if (!Character.isUpperCase(input)) {
			throw new IllegalArgumentException(INPUT_COMMAND_ERROR_MESSAGE);
		}
	}
}
