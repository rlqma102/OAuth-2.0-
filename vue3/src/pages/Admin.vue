<template>
admin
  권한신청 목록이 들어와야함
<label>
  <input type="button" @click="approv">승인하기!
</label>
</template>

<script setup>

import axios from "axios";

const approv = ()=> {
  axios.post("http://localhost:8080/approveRole", {email: sessionStorage.getItem("email")}).then((res)=> {
    console.log(res)

  })
}

</script>

<style scoped>

</style>