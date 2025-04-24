import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import Login from '../components/Login.vue';
import StudentHome from '../components/StudentHome.vue';
import ForgetPassword from '../components/ForgetPassword.vue';
import Register from '../components/Register.vue';
import CoursePage from '../components/CoursePage.vue';
import AttendancePage from '../components/AttendancePage.vue';
import TodoPage from '../components/TodoPage.vue';
import AnnouncementPage from '../components/AnnouncementPage.vue';
import TeachingMaterialPage from '../components/TeachingMaterialPage.vue';
import TeachingEvaluationPage from '../components/TeachingEvaluationPage.vue';
import UserList from '../components/UserList.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
  },
  {
    path: '/studentHome',
    name: 'StudentHome',
    component: StudentHome,
  },
    {
        path: '/forgetPassword',
        name: 'ForgetPassword',
        component: ForgetPassword,
    },
    {
        path: '/register',
        name: 'Register',
        component: Register,
    },
    { path: '/coursePage', component: CoursePage },
    { path: '/attendancePage', component: AttendancePage },
    { path: '/todoPage', component: TodoPage },
    { path: '/announcementPage', component: AnnouncementPage },
    { path: '/teachingMaterialPage', component: TeachingMaterialPage },
    { path: '/teachingEvaluationPage', component: TeachingEvaluationPage },

  {
    path:'/userList',
    component:UserList
  }


];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;