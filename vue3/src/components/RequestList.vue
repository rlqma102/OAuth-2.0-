<template>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">No.</th>
<!--      <th scope="col">이름</th>-->
      <th scope="col">이메일</th>
      <th scope="col">현재권한</th>
      <th scope="col">신청권한</th>
      <th scope="col">신청일</th>
      <th scope="col">처리상태</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <th scope="row">1</th>
      <td>{{ request.email }}</td>
      <td>{{  }}</td>
      <td>{{ request.role }}</td>
      <td>{{request.createDate}}</td>
      <td>{{request.rqStatus}}</td>
      <th scope="col"><input type="button" @click="approv">승인하기...</th>

    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td colspan="2">Larry the Bird</td>
      <td>@twitter</td>
    </tr>
    </tbody>
  </table>
</template>

<script>

// import axios from "axios";

import axios from "axios";

export default {
  name: "RequestList",
  props:{
    request: Object,
  }

}
const approv = ()=> {
  axios.post("http://localhost:8080/approveRole", {email: sessionStorage.getItem("email")}).then((res)=> {
    console.log("dddddddd" + res.data)
  })
}

</script>