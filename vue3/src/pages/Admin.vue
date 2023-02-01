<template>
  <div>
<div class="row row-cols row-cols-sm-2 row-cols-md-3 g-3">
<div class="col" style="width: 100%;">
  <table class="request_table">
    <thead style="height: 100px; color: #6A24FE">
      <tr>
        <th scope="col" style="width: 60px;">No.</th>
        <th scope="col" style="width: 200px;">이메일</th>
        <th scope="col" style="width: 100px;">현재권한</th>
        <th scope="col" style="width: 100px;">신청권한</th>
        <th scope="col" style="width: 200px;">신청일</th>
        <th scope="col" style="width: 100px;">상태</th>
        <th scope="col" style="width: 120px;">처리일</th>
        <th scope="col" style="width: 200px"></th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(request, idx) in state.requests" :key="idx">
        <th scope="row" style="border-bottom: black solid 1px">{{request.id}}</th>
        <td style="border-bottom: black solid 1px">{{ request.email }}</td>
        <td style="border-bottom: black solid 1px">{{ request.role }}</td>
        <td style="border-bottom: black solid 1px">{{ request.rq_role }}</td>
        <td style="border-bottom: black solid 1px">{{request.createDate}}</td>
        <td style="border-bottom: black solid 1px">{{request.rqStatus}}</td>
        <td style="border-bottom: black solid 1px">{{request.okDate}}</td>
        <th scope="col" style="border-bottom: black solid 1px">
          <input type="button" @click="approv(request.id);" value="승인하기" style="background-color: #6A24FE; color: white; border: none; margin-left: 20px">
          <input type="button" @click="reject(request.id);" value="반려하기" style="background-color: orangered; color: white; border: none; margin-left: 20px">
        </th>
      </tr>
    </tbody>
  </table>

</div>
</div>
  </div>
</template>


<script>
  import axios from "axios";
  import {reactive} from "vue";

  // var json = JSON.parse()

  export default {
    name: "Admin",
    setup() {
      const state = reactive({
        requests:[]
      });

      axios.get("http://localhost:8080/api/requests").then((res) => {
        state.requests = res.data;
      });
      return {state}
    },
    methods: {
      approv(id) {
        axios.post("http://localhost:8080/api/accept"
        , {id:id}
        , {headers : {authorization: sessionStorage.getItem('accessToken')}})
             .then((res) => {
               console.log(res);
               window.alert("권한 부여가 정상 처리되었습니다.")
        });
      },
      reject(id) {
        axios.post("http://localhost:8080/api/reject"
        , {id:id}
        , {headers : {authorization: sessionStorage.getItem('accessToken')}})
             .then((res) => {
               console.log(res);
               window.alert("권한 신청이 반려되었습니다.")
        });
      },
    }
  }

</script>

<style>
  .request_table {
    margin: 0 auto;
    margin-top: 100px;
    margin-bottom: 500px;
  }
</style>