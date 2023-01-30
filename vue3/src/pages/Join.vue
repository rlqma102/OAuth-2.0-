<template>
  <h2>Join</h2>
  <div class="joinForm">
    <div class="join">
      <form method="post" action="서버의url" id="join-form">
        <input type="text" name="oaUserName" placeholder="Name" v-model=oaUserName>
        <input type="email" name="oaUserEmail" placeholder="Email" v-model=oaUserEmail>

        <div id="app">
          <h5><br><br>신청할 권한을 선택하세요<br><br></h5>
          <label>
            <input type="radio" name="role" value="USER">일반사용자
          </label>
          <label>
            <input type="radio" name="role" value="ADMIN">관리자
          </label>
          <label>
            <input type="radio" name="role" value="CAT">고양이
          </label>

          <div>확인용 : <input type="text" v-model="fruit" readonly></div>

        </div>

        <input type="button" value="신청하기" @click="onRequest"> //버튼클릭시 권한신청 완료
      </form>
    </div>
  </div>
</template>


<script setup>
import {router} from "@/scripts/router";
import axios from "axios";
import { createApp } from 'vue';
//import Vue from 'vue';

let oaUserName = sessionStorage.getItem('name')
let oaUserEmail = sessionStorage.getItem('email')

const onRequest = ()=> {
  console.log(document.querySelector('input[name="role"]:checked').value);
  axios.post("http://localhost:8080/join", {email: oaUserEmail, role: document.querySelector('input[name="role"]:checked').value}).then((res)=>{
    console.log(res.data.email);
    if (res.status != 200) {
      window.location.href = '/login';
    } else {
      alert('['+res.data.role+']권한신청 되었습니다');
      // 로컬 스토리지에 저장
      localStorage.setItem('accessToken', res.data.accessToken);
      //신청 버튼 클릭시 화면전환 되어야함(아직 안됨)
      router.push({path:"/waiting"})
    }
  });
}



createApp({
  data() {
   return {
     agree:false,
     fruit: "",
   }
  }
})


</script>

<style scoped>

*{
  padding: 0;
  margin: 0;
  border: none;
}
body{
  font-size: 14px;
  font-family: 'Roboto', sans-serif;
}

.joinForm{
  width: 400px;
  height: 350px;
  padding: 40px;
  box-sizing: border-box;
  margin: 0 auto;
}

.join-wrapper > h2{
  font-size: 24px;
  color: #6A24FE;
  margin-bottom: 20px;
}
#join-form > input{
  width: 100%;
  height: 48px;
  padding: 0 10px;
  box-sizing: border-box;
  margin-bottom: 16px;
  border-radius: 6px;
  background-color: #F8F8F8;
}
#join-form > input::placeholder{
  color: #D2D2D2;
}
#join-form > input[type="submit"]{
  color: #fff;
  font-size: 16px;
  background-color: #6A24FE;
  margin-top: 20px;
}


#join-form > input[type="checkbox"]{
  display: none;
}
#join-form > label{
  color: #999999;
}
#join-form input[type="checkbox"] + label{
  cursor: pointer;
  padding-left: 26px;
  /*background-image: url("checkbox.png");*/
  background-repeat: no-repeat;
  background-size: contain;
}
#join-form input[type="checkbox"]:checked + label{
  background-repeat: no-repeat;
  background-size: contain;
}

.radioButton {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>