### JSP 학습 6일차

### JSTL 환경설정

1. [MAVEN](https://mvnrepository.com/)에 접속 후 검색 창에 `jstl`검색
2. `Relocated → javax.servlet.jsp.jstl » jstl` 선택

![스크린샷 2024-05-27 오전 9 57 36](https://github.com/king-dong-gun/Servlet-JSP_PKUN/assets/160683545/c3790e4d-52eb-418c-b0d6-d2da03043cfe)

3. 1.2 V 선택 후 `Gradle`의 코드 복사
```java
// https://mvnrepository.com/artifact/javax.servlet/jstl
implementation group: 'javax.servlet', name: 'jstl', version: '1.2'

```

4. 인텔리제이 툴에서 `dependencies` 함수에 위의 코드 붙혀넣기
 - `dependencies`는 외부라이브러리를 불러오는 빌드 함수

5. 인텔리제이 화면에 뜨는 빌드 활성화

### JSTL 
- JSP 표준 라이브러리이다.
- 반복과 조건, 데이터 관리 포맷을 구현하는 커스텀 태그 라이브러리 모음이다.

#### JSTL 문법
1. `c:url`: url을 호출한다.
2. `c:out`: 객체를 화면에 출력한다.
3. `c:set`: 저장영역에 객체를 저장한다.
4. `c:forEach`: 반복문을 실행한다.
5. `c:if`: 조건문을 실행한다.
