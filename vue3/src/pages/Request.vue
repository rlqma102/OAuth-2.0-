<template>

  <div class="requestForm">
    <div class="request-wrapper">
      <h2>권한신청</h2>
      <form method="post" action="" id="request-form">
        <input type="text" name="oaUserName" placeholder="Name" v-model=oaUserName>
        <input type="email" name="oaUserEmail" placeholder="Email" v-model=oaUserEmail>
        <input type="email" name="oaUserRole" placeholder="Role" v-model=oaUserRole>
        {{}}

        <div id="app">
          <h5><br><br>신청할 권한을 선택하세요<br><br></h5>
          <div>
          <label>
            <input type="radio" id="radioUser" name="role" value="USER">일반사용자
          </label>
          </div>
          <div>
          <label>
            <input type="radio" id="radioAdmin" name="role" value="ADMIN">관리자
          </label>
          </div>
          <div>
          <label>
            <input type="radio" id="radioCat" name="role" value="CAT">고양이
          </label>
        </div>
        </div>

        <input type="button" value="신청하기" @click="onRequest"> //버튼클릭시 권한신청 완료
      </form>

    </div>
  </div>
</template>


<script setup>

//import {onMounted, reactive} from "vue";
import axios from "axios";
//import {useStore} from "vuex";
import { createApp } from 'vue';

let oaUserName  = sessionStorage.getItem('name')
let oaUserEmail = sessionStorage.getItem('email')
let oaUserRole  = sessionStorage.getItem('role')

const onRequest = ()=> {
  sessionStorage.getItem('accessToken');
  axios.post("http://localhost:8080/request"
            ,{email:oaUserEmail
                   ,role:sessionStorage.getItem('role') // 현재 권한
                   ,rq_role:document.querySelector('input[name="role"]:checked').value} // 신청 권한
            ,{headers : {authorization: sessionStorage.getItem('accessToken')}})
       .then((res)=>{
           console.log(res);
           if ( res.status != 200 ) {
             window.location.href = '/googlejoin';
           } else {
             alert('권한신청 되었습니다');
             // 세션 스토리지에 저장
             sessionStorage.setItem('role', res.data.role);
             sessionStorage.setItem('createDate', res.data.createDate);
             localStorage.setItem('rqStatus', res.data.rqStatus);

             window.location.href='/waiting';
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
  margin: 0 auto;
  border: none;
}
body{
  font-size: 14px;
  font-family: 'Roboto', sans-serif;
}

.requestForm{
  width: 400px;
  height: 1000px;
  padding: 40px;
  box-sizing: border-box;
  margin: 0 auto;
  margin-top: 250px;
}

.request-wrapper > h2{
  /*width: 400px;*/
  /*height: 1000px;*/
  /*padding: 40px;*/
  /*box-sizing: border-box;*/
  /*margin: 0 auto;*/
}

.request-wrapper >h2 {
  font-size: 24px;
  color: #6A24FE;
  margin-bottom: 20px;
}

#request-form > input{
  width: 100%;
  height: 48px;
  padding: 0 10px;
  box-sizing: border-box;
  margin-bottom: 16px;
  border-radius: 6px;
  background-color: #F8F8F8;
}
#request-form > input::placeholder{
  color: #D2D2D2;
}

#request-form > input[type="button"]{
  color: #fff;
  font-size: 16px;
  background-color: #6A24FE;
  margin-top: 20px;
}


#request-form > input[type="checkbox"]{
  display: none;
}
#request-form > label{
  color: #999999;
}
#request-form input[type="checkbox"] + label{
  cursor: pointer;
  padding-left: 26px;
  /*background-image: url("checkbox.png");*/
  background-repeat: no-repeat;
  background-size: contain;
}
#request-form input[type="checkbox"]:checked + label{
  background-repeat: no-repeat;
  background-size: contain;
}

#radioUser {
  margin-right: 15px;
}
#radioAdmin {
  margin-right: 15px;
}
#radioCat {
  margin-right: 15px;
}
</style>