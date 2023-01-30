<template>
  <header>
    <div class="collapse bg-dark" id="navbarHeader">
      <div class="container">
        <div class="row">
          <div class="col-sm-4 py-4">
            <h4 class="text-white">사이트맵</h4>
            <ul class="list-unstyled">
              <li>
                <router-link to="/"  class="text-white">메인 화면</router-link>
              </li>
              <li>
                <router-link to="/join"  class="text-white">권한 신청</router-link>
              </li>
              <li>
                <router-link to="/user"  class="text-white">일반 회원</router-link>
              </li>
              <li>
                <router-link to="/cat"  class="text-white">고양이</router-link>
              </li>
              <li>
                <router-link to="/admin"  class="text-white">관리자</router-link>
              </li>
              <li>
                <router-link to="/login"  class="text-white">로그인</router-link>
              </li>
              <li>
                <router-link to="/login"  class="text-white" v-if="$store.state.account.id">로그인</router-link>
                <a to="/login"  class="text-white" @click="logout()">로그아웃</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="navbar navbar-dark bg-dark shadow-sm">
      <div class="container">
        <a href="#" class="navbar-brand d-flex align-items-center"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      </div>
    </div>
  </header>
</template>

<script>
import store from "@/scripts/store";

export default {
  name: 'Header',
  setup() {
    const logout=()=> {
      //로그아웃시 세션과 로컬스토리지에 남아있는 사용자 정보 지워주기
      store.commit('setAccount', 0);
      sessionStorage.removeItem('accessToken');
      sessionStorage.removeItem('name');
      sessionStorage.removeItem('email');
      localStorage.removeItem('accessToken');
      localStorage.removeItem('name');
      alert("로그아웃 되었습니다.")
    }
     return {logout};
  }
}
</script>

<style scoped>

</style>
