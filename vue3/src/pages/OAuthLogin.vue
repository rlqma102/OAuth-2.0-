<script>
  import axios from "axios";
  import {router} from "@/scripts/router";

  var param = new URLSearchParams(window.location.search);
  let code = param.get("code");

  export default {
    setup() {
      if ( code == null || code == undefined || code == '' ) {
        window.location.href = '/login';
      }

      axios.get('http://localhost:8080/redirect/oauth/google?code='+code).then((res)=>{
        console.log("res=================="+res);
        console.log(router)
        if ( res.status != 200 ) {
          window.location.href = '/login';
        } else {
          alert('['+res.data.role+']로그인 되었습니다');
          sessionStorage.setItem('accessToken', res.data.accessToken);
          sessionStorage.setItem('name', res.data.name);
          sessionStorage.setItem('email', res.data.email);
          //window.location.href = '/join';// 로컬 스토리지에 저장
          if(res.data.role == 'ADMIN') {
            window.location.href = '/admin';
          }
          if(res.data.role == 'USER') {
            window.location.href = '/user';
          }
          if(res.data.role == 'GUEST') {
            window.location.href = '/join';
          }
          //router.push({path:"/join"})
          // localStorage.getItem('accessToken'); // 데이터 조회
          // window.location.href = '/';
        }
      });
    }
  }
</script>

<style scoped>
</style>