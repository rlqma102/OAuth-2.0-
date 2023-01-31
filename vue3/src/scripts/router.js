import Home from "@/pages/Home.vue";
import GoogleJoin from "@/pages/GoogleJoin.vue";
import Request from "@/pages/Request.vue";
import OAuthLogin from "@/pages/OAuthLogin.vue";
import NotFound from "@/pages/NotFound.vue";
import Admin from "@/pages/Admin.vue";
import User from "@/pages/User.vue";
import Cat from "@/pages/Cat.vue";
import Waiting from "@/pages/Waiting.vue";
import { createRouter, createWebHistory } from 'vue-router'
import Header from "@/components/Header.vue";
import RequestList from "@/components/RequestList.vue";
import List from "@/pages/List.vue";


const routes = [
    {path: '/', component: Home},
    {path: '/header', component: Header},
    {path: '/requestList', component: RequestList},
    {path: '/googleJoin', component: GoogleJoin},
    {path: '/cat', component: Cat},
    {path: '/user', component: User},
    {path: '/admin', component: Admin},
    {path: '/request', component: Request},
    {path: '/list', component: List},
    {path: '/redirect/oauth', component: OAuthLogin},
    {path: "/404", name: "notFound",component: NotFound},
    {path: "/waiting", component: Waiting},
    {path: "/:pathMatch(.*)*",redirect: "/404"},
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

export {router};