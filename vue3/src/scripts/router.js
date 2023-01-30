import Home from "@/pages/Home.vue";
import Login from "@/pages/Login.vue";
import Join from "@/pages/Join.vue";
import OAuthLogin from "@/pages/OAuthLogin.vue";
import NotFound from "@/pages/NotFound.vue";
import Admin from "@/pages/Admin.vue";
import User from "@/pages/User.vue";
import Cat from "@/pages/Cat.vue";
import Waiting from "@/pages/Waiting.vue";
import { createRouter, createWebHistory } from 'vue-router'


const routes = [
    {path: '/', component: Home},
    {path: '/login', component: Login},
    {path: '/cat', component: Cat},
    {path: '/user', component: User},
    {path: '/admin', component: Admin},
    {path: '/join', component: Join},
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