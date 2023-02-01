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
//import List from "@/pages/List.vue";



//페이지 접근 권한 설정
const adminAuth = () => (from,to,next) => {
    const token = sessionStorage.getItem("role");
    if(token != 'ADMIN'){
        alert("관리자만 접근 가능합니다.");
        next('/home');
    }else {
        next();
    }
    console.log(token);
}

const catAuth = () => (from,to,next) => {
    const token = sessionStorage.getItem("role");

    if(token != 'ADMIN' && token != 'CAT'){
        alert("접근 권한이 없습니다. (고양이와 관리자만 접근이 가능합니다)");
        next('/home');
    }else{
        next();
    }
    console.log(token);
}

const userAuth = () => (from,to,next) => {
    const token = sessionStorage.getItem("role");
    if(token != 'CAT' && token!= 'ADMIN' && token!= 'USER'){
        alert("게스트는 접근 권한이 없습니다. 관리자에게 요청해주세요.");
        next('/home');
    }else {
        next();
    }
    console.log(token);
}

const homeAuth = () => (from,to,next) => {
    const token = sessionStorage.getItem("role");
    if(token != 'CAT' && token!= 'ADMIN' && token!= 'USER' && token!= 'GUEST'){
        alert("로그인 먼저 해주세요. 로그인 페이지로 이동합니다. ");
        next('/googlejoin');
    }else {
        next();
    }
    console.log(token);
}

// const requestAuth = () => (from,to,next) => {
//     const token = sessionStorage.getItem("role");
//     if(token != 'CAT' && token!= 'ADMIN' && token!= 'USER' && token!= 'GUEST'){
//         alert("회원만 권한신청이 가능합니다. 로그인 페이지로 이동합니다. ");
//         next('/googlejoin');
//     }
//     console.log(token);
// }


const routes = [
    {path: '/home', component: Home, beforeEnter : homeAuth()}, /*관리자, 일반회원, 고양이, 게스트*/
    {path: '/header', component: Header},
    {path: '/googleJoin', component: GoogleJoin},
    {path: '/cat', component: Cat, beforeEnter: catAuth()},  /*고양이, 관리자*/
    {path: '/user', component: User, beforeEnter: userAuth()}, /*관리자, 일반회원, 고양이*/
    {path: '/request', component: Request}, /*비회원 접근불가*/
    {path: '/admin', component: Admin, beforeEnter: adminAuth()}, /*관리자*/
    {path: '/redirect/oauth', component: OAuthLogin},
    {path: "/404", name: "notFound",component: NotFound},
    {path: "/waiting", component: Waiting}, /*게스트*/
    {path: "/:pathMatch(.*)*",redirect: "/404"},
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

export {router};