<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
            <div id="signIn" class="col-5">
                <h2>회원가입</h2>
                <form id="loginForm" action="/user/sign-in" method="post">
                    <!--아이디-->
                    <div class="my-2">
                        <div class="mb-2">아이디</div>
                        <div class="d-flex">
                            <input class="form-control mb-2 col-5 mr-3" type="text" id="loginId" name="loginId" placeholder="아이디를 입력하세요">
                            <button class="duplicate-btn btn btn-secondary mb-2">중복확인</button>
                        </div>
                    </div>

                    <!--아이디 체크 결과-->
                    <div class="my-2">
                        <div id="idCheckLength" class="text-danger d-none ">ID를 4자 이상 입력해주세요</div>
                        <div id="idCheckDuplicated" class="text-danger d-none">중복된 아이디 입니다</div>
                        <div id="idCheckOk" class="text-success d-none">사용가능한 아이디 입니다</div>
                    </div>

                    <!--PW-->
                    <div class="my-2">
                        <div class="mb-2">비밀번호</div>
                        <input class="form-control mb-2 col-5 " type="password" id="password" name="password" placeholder="(8자이상)">
                    </div>

                    <div class="my-2">
                        <div class="mb-2">비밀번호 확인</div>
                        <input class="form-control mb-2 col-5" type="password" id="confirmPassword" name="confirmPassword">
                    </div>

                    <div class="my-2">
                        <div class="mb-2">이름</div>
                        <input class="form-control mb-2 col-5" type="text" id="name" name="name">
                    </div>

                    <div class="my-2">
                        <div class="mb-2">이메일</div>
                        <input class="form-control mb-2 col-5" type="text" id="emmail" name="emmail">
                    </div>

                    <div class="my-2">
                        <div class="mb-2">전화번호</div>
                        <input class="form-control mb-2 col-5" type="text" id="phoneNumber" name="phoneNumber">
                    </div>

                    <div class="my-2">
                        <div class="mb-2">우편번호</div>
                        <input class="form-control mb-2 col-5" type="text" id="postCode" name="postCode">
                    </div>

                    <div class="my-2">
                        <div class="mb-2">상세주소</div>
                        <input class="form-control mb-2 col-5" type="text" id="address" name="address">
                    </div>
                    <div class="d-flex justify-content-center mb-3 col-4">
                        <input type="submit" id="signUpBtn" class="btn bg-lemon mt-4" value="가입하기">
                    </div>

                </form>
                
               
               
            </div>
        </div>