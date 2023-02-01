<script>
  import axios from "axios";
  import {router} from "@/scripts/router";

  var param = new URLSearchParams(window.location.search);
  let code = param.get("code");

  export default {
    setup() {
      if ( code == null || code == undefined || code == '' ) {
        window.location.href = '/googlejoin';
      }

      axios.get('http://localhost:8080/redirect/oauth/google?code='+code).then((res)=>{
        console.log("res=================="+res);
        console.log(router)
        if ( res.status != 200 ) {
          window.location.href = '/googlejoin';
        } else {
          alert('['+res.data.role+']로그인 되었습니다');

          window.location.href = '/request';

          sessionStorage.setItem('accessToken', res.data.accessToken);
          sessionStorage.setItem('name', res.data.name);
          sessionStorage.setItem('email', res.data.email);
          sessionStorage.setItem('role', res.data.role);


        }
      });
    }
  }
</script>

<style scoped>
</style>