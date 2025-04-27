<template>
  <div id="app">
    <header>
      <a-menu mode="horizontal">
        <a-menu-item key="/">
          <router-link to="/">Home</router-link>
        </a-menu-item>
        <a-menu-item key="/teachers">
          <router-link to="/teachers">Teacher</router-link>
        </a-menu-item>
        <a-menu-item key="/students">
          <router-link to="/students">Student</router-link>
        </a-menu-item>
        <a-menu-item key="/courses">
          <router-link to="/courses">Course</router-link>
        </a-menu-item>
        <a-menu-item key="/announcements">
          <router-link to="/announcements">Announcement</router-link>
        </a-menu-item>
      </a-menu>
    </header>
    <main>
      <router-view/>
    </main>
    <footer>
      <p>&copy; 2024 教学管理系统</p>
    </footer>
  </div>
</template>
<script setup>
import { RouterLink } from 'vue-router';
</script>
<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  color: #2c3e50;
}
header {
  background-color: #f0f0f0;
  padding: 20px;
  margin-bottom: 20px;
}

footer {
  background-color: #f0f0f0;
  padding: 10px;
  margin-top: 20px;
}

.ant-menu-item a {
  text-decoration: none;
}
</style>