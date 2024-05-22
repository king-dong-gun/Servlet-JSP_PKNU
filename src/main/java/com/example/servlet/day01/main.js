// function onClickButton(event) {
//     // 버튼 클릭 시 호출될 함수
//     signUp();
// }
//
// function signUp() {
//     var form = document.getElementById('regform');
//     var name = form.name.value;
//     var email = form.email.value;
//
//     // 입력 값 검증
//     if (name.trim() === "" || email.trim() === "") {
//         alert("모든 필드를 채워주세요.");
//         return false;
//     }
//
//     // 이메일 유효성 검사
//     if (!email.includes('@')) {
//         alert("올바른 이메일 주소를 입력하세요.");
//         return false;
//     }
//
//     // 회원가입 완료 알림
//     alert("회원가입이 완료되었습니다: 이름 - " + name + ", 이메일 - " + email);
// }
//
// function setEventListeners() {
//     const button = document.querySelector('button');
//     button.addEventListener('click', onClickButton);
// }
//
// // 이벤트 리스너 초기화
// setEventListeners();


document.addEventListener('DOMContentLoaded', function () {
    function create_id() {
        var name = document.querySelector('#name');  // id로 요소 선택
        var email = document.querySelector('#email');  // id로 요소 선택

        // 입력 값 공백 제거 후 검증
        if (name.value.trim() === "" || email.value.trim() === "") {
            alert("이름이나 이메일을 입력하지 않았습니다.");
        } else {
            // 사용자에게 가입 의사를 확인
            var isConfirmed = confirm("정말 가입하시겠습니까?");
            if (isConfirmed) {
                // 사용자가 'OK'를 선택했다면 regform.html로 이동
                location.href = "regform.html";
            }
        }
    }

    // 버튼에 이벤트 리스너 추가
    document.querySelector('.btn').addEventListener('click', create_id);
});


