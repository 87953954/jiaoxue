import { createRouter, createWebHistory } from 'vue-router';

import Login from '../components/Login.vue';

import ForgetPassword from '../components/ForgetPassword.vue';
import Register from '../components/Register.vue';
import CoursePage from '../components/CoursePage.vue';
import AttendancePage from '../components/AttendancePage.vue';
import TodoPage from '../components/TodoPage.vue';
import AnnouncementPage from '../components/AnnouncementPage.vue';
import StudentLayout from '../layouts/StudentLayout.vue';

import TeachingMaterialPage from '../components/TeachingMaterialPage.vue';
import TeachingEvaluationPage from '../components/TeachingEvaluationPage.vue';
import UserList from '../components/UserList.vue'
import StudentHome from '../views/StudentHome.vue';
import StudentCourse from '../views/StudentCourse.vue';
import StudentProfile from '../views/StudentProfile.vue';

const routes = [
  {
    path: '/',
    redirect: '/studentHome',
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
  },
  { path: '/studentHome', component: StudentHome },
  { path: '/studentCourse', component: StudentCourse },
  { path: '/studentProfile', component: StudentProfile },
  {
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