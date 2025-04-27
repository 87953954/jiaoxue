<template>
  <a-layout class="student-layout-container">
    <a-layout-header class="header">
      <div class="logo">Logo</div>
        <div class="user-info">
            <span class="user-type">学生/家长</span>
            <a-avatar size="large" icon="user" />
            <a-button type="link" @click="logout">退出</a-button>
      </div>
    </a-layout-header>
    <a-layout-content class="content">
      <div class="page-content">
        <slot></slot>
      </div>
    </a-layout-content>
    <a-layout-footer class="footer">
      <BottomNavigation />
    </a-layout-footer>
  </a-layout>
</template>
<script>
import BottomNavigation from '../components/BottomNavigation.vue';
export default {
    name: 'StudentLayout',

    components: {
        BottomNavigation,
    },
    methods: {
        logout() {
            // 清除本地存储的用户信息
            localStorage.removeItem('userInfo');
            // 跳转到登录页面
            this.$router.push('/login');
        }
    }

};
</script>

<style scoped>
.student-layout {
  min-height: 100vh;
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 24px;
  background-color: #fff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.logo {

  font-size: 20px;
  font-weight: bold;
}

.user-type{
  margin-right: 10px;
}


.user-info {
  display: flex;
  align-items: center;

}
.user-name {
  margin-left: 10px;
  font-weight: bold;
}

.page-content{
    background-color: white;

    padding: 20px;
    min-height: calc(100vh - 64px - 64px); /* 100vh - header - footer */
}

.content {

  min-height: calc(100vh - 114px);
  padding: 24px;
  background-color: #f0f2f5;
}

.footer {
  text-align: center;
  padding: 24px;
}
</style>