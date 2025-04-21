import { createRouter, createWebHistory } from 'vue-router';
import TeacherList from '../components/TeacherList.vue';
import StudentList from '../components/StudentList.vue';
import CourseList from '../components/CourseList.vue';
import AnnouncementList from '../components/AnnouncementList.vue';
import Home from '../views/Home.vue';

const routes = [ 
  { path: '/', component: Home },
  { path: '/teachers', component: TeacherList },
  { path: '/students', component: StudentList },
  { path: '/courses', component: CourseList },
  { path: '/announcements', component: AnnouncementList },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;