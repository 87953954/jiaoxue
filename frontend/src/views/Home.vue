<template>
  <div class="home">
    <h1>教学管理系统</h1>
    <a-button type="primary" @click="goToTeachers">教师列表</a-button>
    <a-button type="primary" @click="goToStudents">学生列表</a-button>
    <a-button type="primary" @click="goToCourses">课程列表</a-button>
    <a-button type="primary" @click="goToAnnouncements">公告列表</a-button>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router';

const router = useRouter();

const goToTeachers = () => {
  router.push('/teachers');
};

const goToStudents = () => {
  router.push('/students');
};

const goToCourses = () => {
  router.push('/courses');
};

const goToAnnouncements = () => {
  router.push('/announcements');
};
</script>

<style scoped>
.home {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
}

.home h1 {
  margin-bottom: 20px;
}

.ant-btn {
  margin: 10px;
}
</style>