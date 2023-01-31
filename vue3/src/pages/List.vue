<template>
<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
<div class="col" v-for="(request, idx) in state.requests" :key="idx">
  <RequestList :request="request"/>
</div>
</div>
</template>


<script>
  import axios from "axios";
  import {reactive} from "vue";
  import RequestList from "@/components/RequestList.vue";

  //var json = JSON.parse()

  export default {
    name: "List",
    components: {RequestList},
    setup() {

      const state = reactive({
        requests:[]
      })

      axios.get("http://localhost:8080/api/approv").then((res) => {
        state.requests = res.data;
        console.log(state.requests)
      })

      return {state}
    }
  }

</script>