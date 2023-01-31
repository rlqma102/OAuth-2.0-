<template>
admin
  권한신청 목록이 들어와야함
<label>
  <input type="button" @click="approv">승인하기!

  <input type="text" name="requestUserEmail" v-model=requestUserEmail>
  <input type="text" name="requestUserName" v-model=requestUserName>
  <input type="text" name="requestUserRole" v-model=requestUserRole>현재권한
  <input type="text" name="requestUserRole" v-model=userRole>신청권한
  <input type="text" name="requestDate" v-model=state>
</label>
</template>

<script setup>

import axios from "axios";

let requestUserName = sessionStorage.getItem('name')
let requestUserEmail = sessionStorage.getItem('email')
let requestUserRole = sessionStorage.getItem('role')
let userRole = sessionStorage.getItem('role')
//let requestDate = sessionStorage.getItem('createDate')
//let approveDate = sessionStorage.getItem('okDate')
let state = sessionStorage.getItem('rqStatus')

const approv = ()=> {
  axios.post("http://localhost:8080/approveRole", {email: sessionStorage.getItem("email")}).then((res)=> {
    console.log(res.data)

    sessionStorage.setItem('role', res.data[0].role);
    sessionStorage.setItem('rqStatus', res.data);

  })
}

axios.get("http://localhost:8080/api/approv").then((res)=> {
  console.log(res.data)
  console.log(res.data[0].role)
  sessionStorage.setItem('role', res.data[0].role);
})


</script>

<style scoped>

</style>