// p666 ~ 670 3가지 예제 중 첫번째 순서
// 이 클래스는 실행 안한다!
public class QuizProtocol {// p668 예제
    // 프로토콜이 가질 수 있는 상태
    private static final int WAITING = 0;
    private static final int PROBLEM = 1;
    private static final int ANSWER = 2;

    private static final int NUMPROBLEMS = 3;

    private int state = WAITING;
    private int currentProblem = 0;

    private String[] problems = { "네트워크 처리 패키지는?", "자바의 최신 버전은?", "인터넷에서 컴퓨터를 식별하는 주소는?" };

    private String[] answers = { "java.io", "1.11", "ip주소" };

    // ===== 변수 선언 끝 =====

    public String process(String theInput) {
        // theOutput : 클라이언트로 보내는 글자
        String theOutput = null;

        if (state == WAITING) {
            theOutput = "퀴즈를 시작합니다(y/n)";
            state = PROBLEM;

        } else if (state == PROBLEM) {
            // equalsIgnoreCase() : 대소문자 구별 없이 비교하는 메서드
            if (theInput.equalsIgnoreCase("y")) {
                theOutput = problems[currentProblem];
                state = ANSWER;

            } else {
                state = WAITING;
                theOutput = "quit";
            }

        } else if (state == ANSWER) {
            if (theInput.equalsIgnoreCase(answers[currentProblem])) {
                theOutput = "정답입니다. 계속하시겠습니까? (y/n)";
                state = PROBLEM;

            } else {
                state = PROBLEM;
                theOutput = "오답입니다. 계속하시겠습니까? (y/n)";
            }

            currentProblem = (currentProblem + 1) % NUMPROBLEMS;
        }

        return theOutput;
    }
}