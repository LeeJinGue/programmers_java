## 문제 설명

- 프린터를 인쇄 요청이 들어온 순서대로가 아닌 아래의 3가지 방식으로 인쇄 작업을 수행합니다.
1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.

## 변수 설명
- priorities: 현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 정수 배열
- location: 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 정수 변수
- answer: 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알려주는 정수 변수

## 제한사항
- 현재 대기목록에 1~100개의 문서가 있다.
- 인쇄 작업의 중요도는 1~9로 표현되며 클수록 중요함
- location은 0 ~ (대기목록의 작업 수-1)로 표현(배열의 Index)

# 문제 출처
[출처]: https://programmers.co.kr/learn/courses/30/lessons/42626?language=java