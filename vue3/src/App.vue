<template>
  <Header/>
  <RouterView/>
  <Footer/>
</template>

<script>

import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
// import store from "@/scripts/store";
// import axios from "axios";
import {useRoute} from "vue-router";
import {watch} from "vue";

export default {
  name: 'App',
  components: {
    Footer,
    Header

  },
  setup() {
    // const check = ()=> {
    //   axios.get("/api/account/check").then(({data})=> {
    //     console.log(data);
    //
    //     if(data) {
    //       store.commit("setAccount", data);
    //     } else {
    //       store.commit("setAccount", 0);
    //     }
    //   })
    // }

    const route = useRoute();

    watch(route, () => {

    })
  }
}
</script>

<style>

@media (min-width: 768px) {

}

.nav-scroller .nav {
  display: flex;
  flex-wrap: nowrap;
  padding-bottom: 1rem;
  margin-top: -1px;
  overflow-x: auto;
  text-align: center;
  white-space: nowrap;
  -webkit-overflow-scrolling: touch;
}
</style>
