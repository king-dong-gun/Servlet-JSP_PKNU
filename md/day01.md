## 서블릿 1일차

### 서블릿 환경설정

### 톰켓 설치
1. [TomCat](https://tomcat.apache.org/) 왼쪽 메뉴창에서 다운로드 버튼 클릭
2. 자신의 OS에 맞춰서 설치 (V10)
3. 인텔리제이 실행 후 `Application Server`에서 다운받은 `TomCat Local` 클릭, `Gradle` 설정
4. 프로젝트 생성 후 상단 우측 톰켓V 클릭 후 `Edit Configuration` 클릭
5. `Application Server`에서 다시 한번 `TomCat version--`을 선택하고 `HTTP port`번호를 확인한다.
6. 상단 메뉴에 `Deployment`에서 `context`에 `/`만 남긴다.

![survletSetting](https://github.com/king-dong-gun/Spring_PKUN/assets/160683545/b25e7a93-778b-4b59-94a7-6bf0152c027c)


![servletSetting2](https://github.com/king-dong-gun/Spring_PKUN/assets/160683545/75ec59bf-4e3d-406d-9a0f-0a5f3a92361f)


7. `webapp` -> `web.xml` 파일에 아래 코드 입력

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!--
 Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
-->
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee
                      https://jakarta.ee/xml/ns/jakartaee/web-app_6_0.xsd"
  version="6.0"
  metadata-complete="false">

  <display-name>Welcome to Tomcat</display-name>
  <description>
     Welcome to Tomcat
  </description>

</web-app>

```

8. 마지막으로 터미널에서 다운받은 `catalina.bat` 파일을 찾아 `chmod` 775 입력


![terminar](https://github.com/king-dong-gun/Spring_PKUN/assets/160683545/9cee7eba-e762-46f1-9871-0599881f143d)


### 서블릿 시작


```java
package com.example.servlet;

import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

//
@WebServlet("/hi")  // 서블릿 주소 겹치면 안된다.
public class ServletTest extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        out.println("<h1>Hello World</h1>");
    }
}

```


![servletStart](https://github.com/king-dong-gun/Spring_PKUN/assets/160683545/04347935-02ef-489e-8ce8-bf68fef7eba0)


- `@WebServlet(/"url")`로 localhost:port번호 다음에 올 url을 생성했다.
- `extends HttpServlet`으로 서블릿을 상속한다.
- Http로 요청할 `req`와 응답할 `res`를 만들고 `<h1>Hello World</h1>`를 웹서버에서 응답하도록 했다.


> HttpServlet은 많은 구현을 위해 인터페이스, 클래스 등 다 만들어 놓아 상속만 받으면 된다.


![httpServlet](https://github.com/king-dong-gun/Spring_PKUN/assets/160683545/05e9afe0-72c6-41c4-90b4-6462e092fedd)
